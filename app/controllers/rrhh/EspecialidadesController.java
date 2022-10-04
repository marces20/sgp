package controllers.rrhh;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Departamento;
import models.Especialidad;
import models.Expediente;
import models.Solicitud;
import models.Usuario;
import play.Logger;
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
import views.html.rrhh.especialidad.*;

@Security.Authenticated(Secured.class)
public class EspecialidadesController extends Controller {
	
	final static Form<Especialidad> especialidadForm = form(Especialidad.class);
	
	public static Result URL_LISTA_ESPECIALIDAD = redirect(
			controllers.rrhh.routes.EspecialidadesController.indexEspecialidad()
	);
	
	@CheckPermiso(key = "especialidadesGeneral")
	public static Result indexEspecialidad() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexEspecialidad.render(
						Especialidad.page(
								 RequestVar.get("nombre")
								 ),
								 d));
		
	}
	
	@CheckPermiso(key = "especialidadesGeneral")
	public static Result crearEspecialidad() {
		
		Form<Especialidad> especialidadForm = form(Especialidad.class);
		especialidadForm.discardErrors();
		return ok(crearEspecialidad.render(especialidadForm));
	}
	
	@CheckPermiso(key = "especialidadesGeneral")
	public static Result guardarEspecialidad() {
		
		Form<Especialidad> especialidadForm = form(Especialidad.class).bindFromRequest();
		
		try {
			
			if(especialidadForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearEspecialidad.render(especialidadForm));
			} else {
				Especialidad e = especialidadForm.get();
				e.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				e.create_date = new Date();
				e.save();
				
				flash("success", "La Especialidad se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar La Especialidad");
			return badRequest(crearEspecialidad.render(especialidadForm));
		}
		
		return URL_LISTA_ESPECIALIDAD;
	}
	
	@CheckPermiso(key = "especialidadesGeneral")
	public static Result editarEspecialidad(Long id) {
		Especialidad especialidad = Ebean.find(Especialidad.class, id);
		return ok(editarEspecialidad.render(especialidadForm.fill(especialidad)));
	}
	
	@CheckPermiso(key = "especialidadesGeneral")
	public static Result actualizarEspecialidad(){
		
		Form<Especialidad> especialidadForm = form(Especialidad.class).bindFromRequest();
		
		try {
			if(especialidadForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarEspecialidad.render(especialidadForm));
			} else {
				Especialidad e = especialidadForm.get();
				e.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				e.write_date = new Date();
				e.update();

				flash("success", "La Especialidad se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar La Especialidad");
			return badRequest(editarEspecialidad.render(especialidadForm));
		}
		return URL_LISTA_ESPECIALIDAD;
	}
	
	@CheckPermiso(key = "especialidadesGeneral")
	public static Result eliminarEspecialidad(Long id) {
		try {
			Especialidad.find.byId(id).delete();
			flash("success", "Se ha eliminado la Especialidad");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la Especialidad");
		}

		return URL_LISTA_ESPECIALIDAD;
	}
	
	public static Result suggestEspecialidad(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode especialidad = rpta.arrayNode();
	    
	    Especialidad ad = new Especialidad();
		 
		for(Especialidad a : ad.getDataSuggest(input, 25)){
			
			Logger.debug(a.id+"  ---- "+a.create_date);
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        especialidad.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", especialidad);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Especialidad especialidad = Especialidad.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(especialidad == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
		} else {
			restJs.put("success", true);
			restJs.put("id", especialidad.id);
			restJs.put("nombre", especialidad.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Especialidad> p = new Pagination<Especialidad>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Especialidad.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaEspecialidad.render(p, form().bindFromRequest()) );
	}
}
