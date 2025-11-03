package controllers.contabilidad;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Banco;
import models.Ejercicio;
import models.Expediente;
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
import views.html.contabilidad.ejercicios.*;

@Security.Authenticated(Secured.class)
public class EjerciciosController extends Controller {

	final static Form<Ejercicio> ejercicioForm = form(Ejercicio.class);

	public static Result URL_LISTA_EJERCICIO = redirect(
			controllers.contabilidad.routes.EjerciciosController.indexEjercicio()
	);

	@CheckPermiso(key = "ejercicioGeneral")
	public static Result indexEjercicio() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexEjercicio.render(
						 Ejercicio.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}

	@CheckPermiso(key = "ejercicioGeneral")
	public static Result crearEjercicio() {
		Form<Ejercicio> ejercicioForm = form(Ejercicio.class);
		return ok(crearEjercicio.render(ejercicioForm));
	}

	@CheckPermiso(key = "ejercicioGeneral")
	public static Result guardarEjercicio() {

		Form<Ejercicio> ejercicioForm = form(Ejercicio.class).bindFromRequest();

		try {
			if(ejercicioForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearEjercicio.render(ejercicioForm));
			} else {
				Ejercicio e = ejercicioForm.get();
				e.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				e.create_date = new Date();
				e.save();

				flash("success", "El ejercicio se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el ejercicio");
			return badRequest(crearEjercicio.render(ejercicioForm));
		}

		return URL_LISTA_EJERCICIO;
	}

	@CheckPermiso(key = "ejercicioGeneral")
	public static Result editarEjercicio(Long id) {
		Ejercicio ejercicio = Ebean.find(Ejercicio.class, id);

		return ok(editarEjercicio.render(ejercicioForm.fill(ejercicio)));
	}

	@CheckPermiso(key = "ejercicioGeneral")
	public static Result actualizarEjercicio(){

		Form<Ejercicio> ejercicioForm = form(Ejercicio.class).bindFromRequest();

		try {

			if(ejercicioForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarEjercicio.render(ejercicioForm));
			} else {
				Ejercicio e = ejercicioForm.get();
				e.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				e.write_date = new Date();
				e.update();

				flash("success", "El ejercicio se ha actualizado");
			}

		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el ejercicio");
			return badRequest(editarEjercicio.render(ejercicioForm));
		}
		return URL_LISTA_EJERCICIO;
	}

	@CheckPermiso(key = "ejercicioGeneral")
	public static Result eliminarEjercicio(Long id) {
		try {
			Ejercicio.find.byId(id).delete();
			flash("success", "Se ha eliminado el Ejercicio");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el Ejercicio");
		}

		return URL_LISTA_EJERCICIO;
	}

	public static Result suggestEjercicio(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode ejercicio = rpta.arrayNode();

	    Ejercicio ad = new Ejercicio();

		for(Ejercicio a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        ejercicio.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", ejercicio);

		return ok(response);
	}


	public static Result get(int id){
		Ejercicio ejercicio = Ejercicio.find.select("id, nombre").where().eq("activo",true).eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(ejercicio == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el ejercicio");
		} else {
			restJs.put("success", true);
			restJs.put("id", ejercicio.id);
			restJs.put("nombre", ejercicio.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result modalBuscar() {
    	Pagination<Ejercicio> p = new Pagination<Ejercicio>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(Ejercicio.find.where().eq("activo",true).ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaEjercicio.render(p, form().bindFromRequest()) );
	}
}
