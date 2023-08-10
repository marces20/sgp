package controllers.rrhh;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Especialidad;
import models.Profesion;
import models.Puesto;
import models.Usuario;
import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.rrhh.profesion.*;

@Security.Authenticated(Secured.class)
public class ProfesionesController extends Controller {

	final static Form<Profesion> profesionForm = form(Profesion.class);

	public static Result URL_LISTA_PROFESION = redirect(
			controllers.rrhh.routes.ProfesionesController.indexProfesion()
	);

	@CheckPermiso(key = "puestosGeneral")
	public static Result indexProfesion() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexProfesion.render(
						Profesion.page(
								 RequestVar.get("nombre")
								 ),
								 d));

	}

	@CheckPermiso(key = "puestosGeneral")
	public static Result crearProfesion() {
		Form<Profesion> profesionForm = form(Profesion.class);

		profesionForm.discardErrors();
		return ok(crearProfesion.render(profesionForm));
	}

	@CheckPermiso(key = "puestosGeneral")
	public static Result guardarProfesion() {

		Form<Profesion> profesionForm = form(Profesion.class).bindFromRequest();

		try {

			if(profesionForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearProfesion.render(profesionForm));
			} else {
				Profesion p = profesionForm.get();
				p.save();
				flash("success", "La Profesion se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la rofesion");
			return badRequest(crearProfesion.render(profesionForm));
		}

		return URL_LISTA_PROFESION;
	}

	@CheckPermiso(key = "puestosGeneral")
	public static Result editarProfesion(Long id) {
		Profesion profesion = Ebean.find(Profesion.class, id);
		return ok(editarProfesion.render(profesionForm.fill(profesion)));
	}

	@CheckPermiso(key = "puestosGeneral")
	public static Result actualizarProfesion(){

		Form<Profesion> profesionForm = form(Profesion.class).bindFromRequest();

		try {
			if(profesionForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarProfesion.render(profesionForm));
			} else {
				Profesion p = profesionForm.get();
				p.update();

				flash("success", "La Profesion se ha actualizado");
			}

		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la Profesion");
			return badRequest(editarProfesion.render(profesionForm));
		}
		return URL_LISTA_PROFESION;
	}

	@CheckPermiso(key = "puestosGeneral")
	public static Result eliminarProfesion(Long id) {
		try {
			Profesion.find.byId(id).delete();
			flash("success", "Se ha eliminado la Profesion");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la Profesion");
		}

		return URL_LISTA_PROFESION;
	}



	public static Result suggestProfesion(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode profesion = rpta.arrayNode();

	    Profesion ad = new Profesion();

		for(Profesion a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        profesion.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", profesion);

		return ok(response);
	}

	public static Result get(int id){
		Profesion profesion = Profesion.find.select("id, nombre").where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(profesion == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la profesion.");
		} else {
			restJs.put("success", true);
			restJs.put("id", profesion.id);
			restJs.put("nombre", profesion.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result modalBuscar() {
    	Pagination<Profesion> p = new Pagination<Profesion>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(Profesion.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaProfesion.render(p, form().bindFromRequest()) );
	}
}
