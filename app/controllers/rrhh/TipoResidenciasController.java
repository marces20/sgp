package controllers.rrhh;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import models.Agente;
import models.Profesion;
import models.Puesto;
import models.TipoResidencia;
import models.Usuario;
import models.haberes.PuestoLaboral;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.rrhh.agente.verAgente;
import views.html.rrhh.tipoResidencia.*;

@Security.Authenticated(Secured.class)
public class TipoResidenciasController extends Controller {
	
	final static Form<TipoResidencia> tpForm = form(TipoResidencia.class);
	
	public static Result URL_LISTA_TP = redirect(
			controllers.rrhh.routes.TipoResidenciasController.indexTipoResidencia()
	);
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result indexTipoResidencia() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexTipoResidencia.render(
						TipoResidencia.page(
								 RequestVar.get("nombre")
								 ),
								 d));
		
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result crearTipoResidencia() {
		Form<TipoResidencia> tpForm = form(TipoResidencia.class);
		
		tpForm.discardErrors();
		return ok(crearTipoResidencia.render(tpForm));
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result guardarTipoResidencia() {
		
		Form<TipoResidencia> tpForm = form(TipoResidencia.class).bindFromRequest();
		
		try {
			
			if(tpForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearTipoResidencia.render(tpForm));
			} else {
				TipoResidencia p = tpForm.get();
				p.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.create_date = new Date();
				p.save();
				flash("success", "El Tipo Residencia se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el puesto");
			return badRequest(crearTipoResidencia.render(tpForm));
		}
		
		return URL_LISTA_TP;
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result editarTipoResidencia(Long id) {
		TipoResidencia puesto = Ebean.find(TipoResidencia.class, id);
		return ok(editarTipoResidencia.render(tpForm.fill(puesto)));
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result actualizarTipoResidencia(){
		
		Form<TipoResidencia> tpForm = form(TipoResidencia.class).bindFromRequest();
		
		try {
			if(tpForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarTipoResidencia.render(tpForm));
			} else {
				TipoResidencia p = tpForm.get();
				p.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.write_date = new Date();
				p.update();
				
				flash("success", "El Tipo Residencia se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el Tipo Residencia");
			return badRequest(editarTipoResidencia.render(tpForm));
		}
		return URL_LISTA_TP;
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result eliminarTipoResidencia(Long id) {
		try {
			TipoResidencia.find.byId(id).delete();
			flash("success", "Se ha eliminado el Tipo Residencia");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el Tipo Residencia");
		}

		return URL_LISTA_TP;
	}
	
	public static Result suggestTipoResidencia(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode tr = rpta.arrayNode();
	    
	    TipoResidencia ad = new TipoResidencia();
		 
		for(TipoResidencia a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        tr.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", tr);
		 
		return ok(response);
	}

	@CheckPermiso(key = "puestosGeneral")
	public static Result ver(Long id) throws IOException {
		TipoResidencia tp = TipoResidencia.find.byId(id);
		
		List<TipoResidencia> tpl = TipoResidencia.find.where().eq("id", tp.id).orderBy("id").findList();
		
		if(tpl == null){
			flash("error", "No se encuentra el agente.");
			return URL_LISTA_TP;
		}
		
		return ok(verTipoResidencia.render(tpForm.fill(tp),tp));
	}
	
	public static Result get(int id){
		TipoResidencia profesion = TipoResidencia.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(profesion == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
		} else {
			restJs.put("success", true);
			restJs.put("id", profesion.id);
			restJs.put("nombre", profesion.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<TipoResidencia> p = new Pagination<TipoResidencia>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(TipoResidencia.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaTipoResidencia.render(p, form().bindFromRequest()) );
	}
}
