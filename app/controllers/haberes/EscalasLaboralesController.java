package controllers.haberes;

import play.mvc.Controller;

import static play.data.Form.form;

import java.io.IOException;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.CargoLaboral;
import models.haberes.EscalaLaboral;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.escalasLaborales.*;

public class EscalasLaboralesController extends Controller {
	
	final static Form<EscalaLaboral> escalaLaboralForm = form(EscalaLaboral.class);
	
	public static Result URL_LISTA_ESCALA_LABORAL = redirect(
			controllers.haberes.routes.EscalasLaboralesController.index()
	);
	
	@CheckPermiso(key = "escalaLaboralIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexEscalaLaboral.render(
						EscalaLaboral.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "escalaLaboralCrear")
	public static Result crear() {
		Form<EscalaLaboral> escalaLaboralForm = form(EscalaLaboral.class);
		return ok(crearEscalaLaboral.render(escalaLaboralForm));
	}
	
	@CheckPermiso(key = "escalaLaboralCrear")
	public static Result guardar() {
		
		Form<EscalaLaboral> escalaLaboralForm = form(EscalaLaboral.class).bindFromRequest();
		
		try {
			if(escalaLaboralForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearEscalaLaboral.render(escalaLaboralForm));
			} else {
				EscalaLaboral lc = escalaLaboralForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "La escala laboral se ha actualizado");
				return redirect( controllers.haberes.routes.EscalasLaboralesController.ver( escalaLaboralForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la escala laboral");
			return badRequest(crearEscalaLaboral.render(escalaLaboralForm));
		}
	}
	
	@CheckPermiso(key = "escalaLaboralEditar")
	public static Result editar(Long id) {
		EscalaLaboral lc = Ebean.find(EscalaLaboral.class, id);
		return ok(editarEscalaLaboral.render(escalaLaboralForm.fill(lc)));
	}
	
	@CheckPermiso(key = "escalaLaboralEditar")
	public static Result actualizar(){
		
		Form<EscalaLaboral> escalaLaboralForm = form(EscalaLaboral.class).bindFromRequest();
		
		try {
			
			if(escalaLaboralForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarEscalaLaboral.render(escalaLaboralForm));
			} else {
				EscalaLaboral lc = escalaLaboralForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "La escala laboral se ha actualizado");
				return redirect( controllers.haberes.routes.EscalasLaboralesController.ver( escalaLaboralForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la escala laboral");
			return badRequest(editarEscalaLaboral.render(escalaLaboralForm));
		}
	}
	
	@CheckPermiso(key = "escalaLaboralEliminar")
	public static Result eliminar(Long id) {
		try {
			EscalaLaboral.find.byId(id).delete();
			flash("success", "Se ha eliminado la escala laboral");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la escala laboral");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "escalaLaboralVer")
	public static Result ver(Long id) throws IOException {
		EscalaLaboral lc = EscalaLaboral.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra la escala laboral");
			return URL_LISTA_ESCALA_LABORAL;
		}
		
		return ok(verEscalaLaboral.render(escalaLaboralForm.fill(lc),lc));
	}
	
	public static Result suggestEscalaLaboral(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode escalaLaboral = rpta.arrayNode();
	    
	    EscalaLaboral lc = new EscalaLaboral();
		 
		for(EscalaLaboral a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        escalaLaboral.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", escalaLaboral);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		EscalaLaboral lc = EscalaLaboral.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la escala laboral");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<EscalaLaboral> p = new Pagination<EscalaLaboral>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(EscalaLaboral.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaEscalaLaboral.render(p, form().bindFromRequest()) );
	}
}
