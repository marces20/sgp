package controllers.equipo;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.Estado;
import models.Usuario;
import models.auth.Permiso;
import models.equipos.Equipo;
import models.haberes.CentroCosto;
import models.recupero.RecuperoFactura;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.equipo.equipo.*;

public class EquipoController extends Controller {

	final static Form<Equipo> equipoForm = form(Equipo.class);

	public static Result URL_LISTA_EQUIPO = redirect(
			controllers.equipo.routes.EquipoController.index()
	);

	@CheckPermiso(key = "equipoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexEquipo.render(
						Equipo.page(
								 RequestVar.get("serial")
								 ),
								 d));
	}

	@CheckPermiso(key = "equipoCrear")
	public static Result crear() {
		Form<Equipo> equipoForm = form(Equipo.class);
		return ok(crearEquipo.render(equipoForm));
	}

	@CheckPermiso(key = "equipoCrear")
	public static Result guardar() {

		Form<Equipo> equipoForm = form(Equipo.class).bindFromRequest();

		try {
			if(equipoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearEquipo.render(equipoForm));
			} else {
				Equipo lc = equipoForm.get();
				lc.estado_id = (long) Estado.EQUIPO_BORRADOR;
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El equipo se ha actualizado");
				return redirect( controllers.equipo.routes.EquipoController.ver( equipoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el equipo "+pe);
			return badRequest(crearEquipo.render(equipoForm));
		}
	}

	@CheckPermiso(key = "equipoEditar")
	public static Result editar(Long id) {
		Equipo lc = Ebean.find(Equipo.class, id);
		return ok(editarEquipo.render(equipoForm.fill(lc),lc));
	}

	@CheckPermiso(key = "equipoEditar")
	public static Result actualizar(){

		Form<Equipo> equipoForm = form(Equipo.class).bindFromRequest();

		try {
			Equipo lc = equipoForm.get();

			if(equipoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarEquipo.render(equipoForm,lc));
			} else {

				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El equipo se ha actualizado");
				return redirect( controllers.equipo.routes.EquipoController.ver( equipoForm.get().id ) + UriTrack.get("&"));
			}

		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el equipo");
			return badRequest(editarEquipo.render(equipoForm,null));
		}
	}

	@CheckPermiso(key = "equipoEliminar")
	public static Result eliminar(Long id) {
		try {
			Equipo.find.byId(id).delete();
			flash("success", "Se ha eliminado el equipo");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el equioi");
		}

		return redirect(request().getHeader("referer"));
	}

	@CheckPermiso(key = "equipoVer")
	public static Result ver(Long id) throws IOException {
		Equipo lc = Equipo.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el equipo");
			return URL_LISTA_EQUIPO;
		}

		return ok(verEquipo.render(equipoForm.fill(lc),lc));
	}

	public static Result suggestEquipo(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode equipo = rpta.arrayNode();

	    Equipo lc = new Equipo();

		for(Equipo a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        equipo.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", equipo);

		return ok(response);
	}

	public static Result get(int id){
		Equipo lc = Equipo.find.select("id, nombre").where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el equipo");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result modalBuscar() {
    	Pagination<Equipo> p = new Pagination<Equipo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(Equipo.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaEquipo.render(p, form().bindFromRequest()) );
	}

	public static Result cambiarEstado(Long idEquipo, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_EQUIPO);

		Equipo rp = Equipo.find.byId(idEquipo);


		if(rp == null){
			flash("error", "No se encuentra el equipo");
			return redirect(request().getHeader("referer"));
		}



		if(idEstado != null){

			Boolean permiso = false;

			switch ( idEstado.intValue() ) {
		      case  Estado.EQUIPO_BORRADOR:
		    	  if(!Permiso.check("equipoPasarEnBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }

		    	  pasarEnBorrador(rp.id);
		    	  break;
		      case Estado.EQUIPO_FUNCIONANDO:
		    	  if(!Permiso.check("equipoPasarFuncionando")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }

		    	  pasarFuncionando(rp.id);
		    	  break;
		      case Estado.EQUIPO_REPARACION:
		    	  if(!Permiso.check("equipoPasarReparacion")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }

		    	  pasarReparacion(rp.id);
		    	  break;
		      case Estado.EQUIPO_APAGADO:
		    	  if(!Permiso.check("equipoPasarApagado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }


		    	  pasarApagado(rp.id);
		          break;
		      default:
		           break;
		      }

		}

		return redirect(controllers.equipo.routes.EquipoController.ver(rp.id)+ UriTrack.get("&"));
	}

	@CheckPermiso(key = "equipoPasarApagado")
	public static void pasarApagado(Long idRf){

		Equipo rf = Ebean.find(Equipo.class).select("id, estado_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.EQUIPO_APAGADO);
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Apagado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "equipoPasarReparacion")
	public static void pasarReparacion(Long idRf){

		Equipo rf = Ebean.find(Equipo.class).select("id, estado_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.EQUIPO_REPARACION);
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Reparacion");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "equipoPasarFuncionando")
	public static void pasarFuncionando(Long idRf){

		Equipo rf = Ebean.find(Equipo.class).select("id, estado_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.EQUIPO_FUNCIONANDO);
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Funcionando");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "equipoPasarEnBorrador")
	public static void pasarEnBorrador(Long idRf){

		Equipo rf = Ebean.find(Equipo.class).select("id, estado_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.EQUIPO_BORRADOR);
			rf.save();
			flash("success", "Operación exitosa. Estado actual: En Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
}
