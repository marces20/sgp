package controllers.expediente;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Ejercicio;
import models.Expediente;
import models.IniciadorExpediente;
import models.Solicitud;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.compras.solicitudes.indexSolicitud;
import views.html.expediente.expediente.modalBusquedaExpediente;
import views.html.expediente.iniciador.*;

@Security.Authenticated(Secured.class)
public class IniciadorExpedientesController extends Controller {
	
	final static Form<IniciadorExpediente> iniciadorExpedienteForm = form(IniciadorExpediente.class);
	
	public static Result URL_LISTA_INICIADOR_EXPEDIENTE = redirect(
			controllers.expediente.routes.IniciadorExpedientesController.indexIniciadorExpediente()
	);
			
	@CheckPermiso(key = "iniciadorGeneral")
	public static Result indexIniciadorExpediente() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexIniciadorExpediente.render(
						IniciadorExpediente.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "iniciadorGeneral")
	public static Result crearIniciadorExpediente() {
		Form<IniciadorExpediente> iniciadorExpedienteForm = form(IniciadorExpediente.class);
		return ok(crearIniciadorExpediente.render(iniciadorExpedienteForm));
	}
	
	@CheckPermiso(key = "iniciadorGeneral")
	public static Result guardarIniciadorExpediente() {
		
		Form<IniciadorExpediente> iniciadorExpedienteForm = form(IniciadorExpediente.class).bindFromRequest();
		
		try {
			if(iniciadorExpedienteForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearIniciadorExpediente.render(iniciadorExpedienteForm));
			} else {
				IniciadorExpediente i = iniciadorExpedienteForm.get();
				i.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				i.create_date = new Date();
				i.save();
				
				flash("success", "El iniciador se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el iniciador");
			return badRequest(crearIniciadorExpediente.render(iniciadorExpedienteForm));
		}
		
		return URL_LISTA_INICIADOR_EXPEDIENTE;
	}
	
	@CheckPermiso(key = "iniciadorGeneral")
	public static Result editarIniciadorExpediente(Long id) {
		IniciadorExpediente iniciadorExpediente = Ebean.find(IniciadorExpediente.class, id);
		
		return ok(editarIniciadorExpediente.render(iniciadorExpedienteForm.fill(iniciadorExpediente)));
	}
	
	@CheckPermiso(key = "iniciadorGeneral")
	public static Result actualizarIniciadorExpediente(){
		
		Form<IniciadorExpediente> iniciadorExpedienteForm = form(IniciadorExpediente.class).bindFromRequest();
		
		try {
			
			if(iniciadorExpedienteForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarIniciadorExpediente.render(iniciadorExpedienteForm));
			} else {
				IniciadorExpediente i = iniciadorExpedienteForm.get();
				i.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				i.write_date = new Date();
				i.update();

				flash("success", "El iniciador se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el iniciador");
			return badRequest(editarIniciadorExpediente.render(iniciadorExpedienteForm));
		}
		return URL_LISTA_INICIADOR_EXPEDIENTE;
	}
	
	@CheckPermiso(key = "iniciadorGeneral")
	public static Result eliminarIniciadorExpediente(Long id) {
		try {
			IniciadorExpediente.find.byId(id).delete();
			flash("success", "Se ha eliminado el Iniciador");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el Iniciador");
		}

		return URL_LISTA_INICIADOR_EXPEDIENTE;
	}
	
	public static Result suggestIniciadorExpediente(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode iniciadorExpediente = rpta.arrayNode();
	    
	    IniciadorExpediente ad = new IniciadorExpediente();
		 
		for(IniciadorExpediente a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        iniciadorExpediente.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", iniciadorExpediente);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		IniciadorExpediente iniciadorExpediente = IniciadorExpediente.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(iniciadorExpediente == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
		} else {
			restJs.put("success", true);
			restJs.put("id", iniciadorExpediente.id);
			restJs.put("nombre", iniciadorExpediente.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<IniciadorExpediente> p = new Pagination<IniciadorExpediente>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(IniciadorExpediente.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaIniciadorExpediente.render(p, form().bindFromRequest()) );
	}
}
