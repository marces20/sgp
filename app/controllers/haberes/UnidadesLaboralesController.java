package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.UnidadLaboral;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.unidadesLaborales.*;
	 
public class UnidadesLaboralesController extends Controller {
	
	final static Form<UnidadLaboral> unidadLaboralForm = form(UnidadLaboral.class);
	
	public static Result URL_LISTA_UNIDAD_LABORAL = redirect(
			controllers.haberes.routes.UnidadesLaboralesController.index()
	);
	
	@CheckPermiso(key = "unidadLaboralIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexUnidadLaboral.render(
						UnidadLaboral.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "unidadLaboralCrear")
	public static Result crear() {
		Form<UnidadLaboral> unidadLaboralForm = form(UnidadLaboral.class);
		return ok(crearUnidadLaboral.render(unidadLaboralForm));
	}
	
	@CheckPermiso(key = "unidadLaboralCrear")
	public static Result guardar() {
		
		Form<UnidadLaboral> unidadLaboralForm = form(UnidadLaboral.class).bindFromRequest();
		
		try {
			if(unidadLaboralForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearUnidadLaboral.render(unidadLaboralForm));
			} else {
				UnidadLaboral lc = unidadLaboralForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "La unidad laboral se ha actualizado");
				return redirect( controllers.haberes.routes.UnidadesLaboralesController.ver( unidadLaboralForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la unidad laboral");
			return badRequest(crearUnidadLaboral.render(unidadLaboralForm));
		}
	}
	
	@CheckPermiso(key = "unidadLaboralEditar")
	public static Result editar(Long id) {
		UnidadLaboral lc = Ebean.find(UnidadLaboral.class, id);
		return ok(editarUnidadLaboral.render(unidadLaboralForm.fill(lc)));
	}
	
	@CheckPermiso(key = "unidadLaboralEditar")
	public static Result actualizar(){
		
		Form<UnidadLaboral> unidadLaboralForm = form(UnidadLaboral.class).bindFromRequest();
		
		try {
			
			if(unidadLaboralForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarUnidadLaboral.render(unidadLaboralForm));
			} else {
				UnidadLaboral lc = unidadLaboralForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "La unidad laboral se ha actualizado");
				return redirect( controllers.haberes.routes.UnidadesLaboralesController.ver( unidadLaboralForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la unidad laboral");
			return badRequest(editarUnidadLaboral.render(unidadLaboralForm));
		}
	}
	
	@CheckPermiso(key = "unidadLaboralEliminar")
	public static Result eliminar(Long id) {
		try {
			UnidadLaboral.find.byId(id).delete();
			flash("success", "Se ha eliminado la unidad laboral");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la unidad laboral");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "unidadLaboralVer")
	public static Result ver(Long id) throws IOException {
		UnidadLaboral lc = UnidadLaboral.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra la unidad laboral");
			return URL_LISTA_UNIDAD_LABORAL;
		}
		
		return ok(verUnidadLaboral.render(unidadLaboralForm.fill(lc),lc));
	}
	
	public static Result suggestUnidadLaboral(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode unidadLaboral = rpta.arrayNode();
	    
	    UnidadLaboral lc = new UnidadLaboral();
		 
		for(UnidadLaboral a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        unidadLaboral.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", unidadLaboral);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		UnidadLaboral lc = UnidadLaboral.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la unidad laboral");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<UnidadLaboral> p = new Pagination<UnidadLaboral>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(UnidadLaboral.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaUnidadLaboral.render(p, form().bindFromRequest()) );
	}
	
}
