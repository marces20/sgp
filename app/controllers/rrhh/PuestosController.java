package controllers.rrhh;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Especialidad;
import models.Expediente;
import models.Puesto;
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
import views.html.rrhh.puesto.*;

@Security.Authenticated(Secured.class)
public class PuestosController extends Controller {
	
	final static Form<Puesto> puestoForm = form(Puesto.class);
	
	public static Result URL_LISTA_PUESTO = redirect(
			controllers.rrhh.routes.PuestosController.indexPuesto()
	);
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result indexPuesto() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexPuesto.render(
						Puesto.page(
								 RequestVar.get("nombre")
								 ),
								 d));
		
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result crearPuesto() {
		Form<Puesto> puestoForm = form(Puesto.class);
		
		puestoForm.discardErrors();
		return ok(crearPuesto.render(puestoForm));
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result guardarPuesto() {
		
		Form<Puesto> puestoForm = form(Puesto.class).bindFromRequest();
		
		try {
			
			if(puestoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearPuesto.render(puestoForm));
			} else {
				Puesto p = puestoForm.get();
				p.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.create_date = new Date();
				p.save();
				flash("success", "El puesto se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el puesto");
			return badRequest(crearPuesto.render(puestoForm));
		}
		
		return URL_LISTA_PUESTO;
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result editarPuesto(Long id) {
		Puesto puesto = Ebean.find(Puesto.class, id);
		return ok(editarPuesto.render(puestoForm.fill(puesto)));
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result actualizarPuesto(){
		
		Form<Puesto> puestoForm = form(Puesto.class).bindFromRequest();
		
		try {
			if(puestoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarPuesto.render(puestoForm));
			} else {
				Puesto p = puestoForm.get();
				p.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.write_date = new Date();
				p.update();
				
				flash("success", "El Puesto se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el Puesto");
			return badRequest(editarPuesto.render(puestoForm));
		}
		return URL_LISTA_PUESTO;
	}
	
	@CheckPermiso(key = "puestosGeneral")
	public static Result eliminarPuesto(Long id) {
		try {
			Puesto.find.byId(id).delete();
			flash("success", "Se ha eliminado el Puesto");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el Puesto");
		}

		return URL_LISTA_PUESTO;
	}
	
	public static Result suggestPuesto(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode puesto = rpta.arrayNode();
	    
	    Puesto ad = new Puesto();
		 
		for(Puesto a : ad.getDataSuggest(input, 25)){
			
			Logger.debug(a.id+"  ---- "+a.create_date);
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        puesto.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", puesto);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Puesto puesto = Puesto.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(puesto == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
		} else {
			restJs.put("success", true);
			restJs.put("id", puesto.id);
			restJs.put("nombre", puesto.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Puesto> p = new Pagination<Puesto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Puesto.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaPuesto.render(p, form().bindFromRequest()) );
	}
}
