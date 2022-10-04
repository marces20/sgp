package controllers.haberes;

import static play.data.Form.form;
import javax.persistence.PersistenceException;
import java.io.IOException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.Legajo;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.legajos.*;

public class LegajosController extends Controller {
	
	final static Form<Legajo> legajoForm = form(Legajo.class);
	
	public static Result URL_LISTA_LEGAJOS = redirect(
			controllers.haberes.routes.LegajosController.index()
	);
	
	@CheckPermiso(key = "legajoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexLegajo.render(
						Legajo.page(
								 RequestVar.get("numero")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "legajoCrear")
	public static Result crear() {
		Form<Legajo> legajoForm = form(Legajo.class);
		return ok(crearLegajo.render(legajoForm));
	}
	
	@CheckPermiso(key = "legajoCrear")
	public static Result guardar() {
		
		Form<Legajo> legajoForm = form(Legajo.class).bindFromRequest();
		
		try {
			if(legajoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearLegajo.render(legajoForm));
			} else {
				Legajo lc = legajoForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El legajo se ha actualizado");
				return redirect( controllers.haberes.routes.LegajosController.ver( legajoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el legajo");
			return badRequest(crearLegajo.render(legajoForm));
		}
	}
	
	@CheckPermiso(key = "legajoEditar")
	public static Result editar(Long id) {
		Legajo lc = Ebean.find(Legajo.class, id);
		return ok(editarLegajo.render(legajoForm.fill(lc)));
	}
	
	@CheckPermiso(key = "legajoEditar")
	public static Result actualizar(){
		
		Form<Legajo> legajoForm = form(Legajo.class).bindFromRequest();
		
		try {
			
			if(legajoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarLegajo.render(legajoForm));
			} else {
				Legajo lc = legajoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El legajo se ha actualizado");
				return redirect( controllers.haberes.routes.LegajosController.ver( legajoForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el legajo");
			return badRequest(editarLegajo.render(legajoForm));
		}
	}
	
	@CheckPermiso(key = "legajoEliminar")
	public static Result eliminar(Long id) {
		try {
			Legajo.find.byId(id).delete();
			flash("success", "Se ha eliminado el legajo");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el legajo");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "legajoVer")
	public static Result ver(Long id) throws IOException {
		Legajo lc = Legajo.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el legajo");
			return URL_LISTA_LEGAJOS;
		}
		
		return ok(verLegajo.render(legajoForm.fill(lc),lc));
	}
	
	public static Result suggestLegajo(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode legajo = rpta.arrayNode();
	    
	    Legajo lc = new Legajo();
		 
		for(Legajo a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.numero);
	        legajo.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", legajo);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Legajo lc = Legajo.find.select("id, numero").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el legajo");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.agente.apellido);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Legajo> p = new Pagination<Legajo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Legajo.find.fetch("agente").where().ilike("agente.apellido", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaLegajo.render(p, form().bindFromRequest()) );
	}
	
}
