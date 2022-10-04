package controllers.contabilidad;

import static play.data.Form.form;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Ejercicio;
import models.Expediente;
import models.Periodo;
import models.Solicitud;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.compras.solicitudes.indexSolicitud;
import views.html.contabilidad.periodos.*;
import views.html.expediente.expediente.modalBusquedaExpediente;

@Security.Authenticated(Secured.class)
public class PeriodosController extends Controller {
	
	final static Form<Periodo> periodoForm = form(Periodo.class);
	
	public static Result URL_LISTA_PERIODO = redirect(
			controllers.contabilidad.routes.PeriodosController.indexPeriodo()
	);
	
	@CheckPermiso(key = "periodosGeneral")
	public static Result indexPeriodo() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexPeriodo.render(
						Periodo.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "periodosGeneral")
	public static Result crearPeriodo() {
		Form<Periodo> periodoForm = form(Periodo.class);
		return ok(crearPeriodo.render(periodoForm));
	}
	
	@CheckPermiso(key = "periodosGeneral")
	public static Result guardarPeriodo() {
		
		Form<Periodo> periodoForm = form(Periodo.class).bindFromRequest();
		
		try {
			if(periodoForm.field("ejercicio.id").value().isEmpty()){
				periodoForm.reject("ejercicio.id","El Ejercicio es obligatorio.");
			}
			if(periodoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearPeriodo.render(periodoForm));
			} else {
				periodoForm.get().save();
				flash("success", "El periodo se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el periodo");
			return badRequest(crearPeriodo.render(periodoForm));
		}
		
		return URL_LISTA_PERIODO;
	}
	
	@CheckPermiso(key = "periodosGeneral")
	public static Result editarPeriodo(Long id) {
		Periodo periodo = Ebean.find(Periodo.class, id);
		
		return ok(editarPeriodo.render(periodoForm.fill(periodo)));
	}
	
	@CheckPermiso(key = "periodosGeneral")
	public static Result actualizarPeriodo(){
		
		Form<Periodo> periodoForm = form(Periodo.class).bindFromRequest();
		
		try {
			if(periodoForm.field("ejercicio.id").value().isEmpty()){
				periodoForm.reject("ejercicio.id","El Ejercicio es obligatorio.");
			}
			if(periodoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarPeriodo.render(periodoForm));
			} else {
				periodoForm.get().update(periodoForm.get().id);
				flash("success", "El periodo se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el periodo");
			return badRequest(editarPeriodo.render(periodoForm));
		}
		return URL_LISTA_PERIODO;
	}
	
	@CheckPermiso(key = "periodosGeneral")
	public static Result eliminarPeriodo(Long id) {
		try {
			Periodo.find.byId(id).delete();
			flash("success", "Se ha eliminado el Periodo");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el Periodo");
		}

		return URL_LISTA_PERIODO;
	}
	
	public static Result suggestPeriodo(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode periodo = rpta.arrayNode();
	    
	    Periodo ad = new Periodo();
		 
		for(Periodo a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        periodo.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", periodo);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Periodo periodo = Periodo.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(periodo == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el periodo");
		} else {
			restJs.put("success", true);
			restJs.put("id", periodo.id);
			restJs.put("nombre", periodo.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Periodo> p = new Pagination<Periodo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Periodo.find.fetch("ejercicio").where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaPeriodo.render(p, form().bindFromRequest()) );
	}
}
