package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.CargoLaboral;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.cargosLaborales.*;

public class CargosLaboralesController extends Controller {
	
	final static Form<CargoLaboral> cargoLaboralForm = form(CargoLaboral.class);
	
	public static Result URL_LISTA_CARGO_LABORAL = redirect(
			controllers.haberes.routes.CargosLaboralesController.index()
	);
	
	@CheckPermiso(key = "cargoLaboralIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexCargoLaboral.render(
						CargoLaboral.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "cargoLaboralCrear")
	public static Result crear() {
		Form<CargoLaboral> cargoLaboralForm = form(CargoLaboral.class);
		return ok(crearCargoLaboral.render(cargoLaboralForm));
	}
	
	@CheckPermiso(key = "cargoLaboralCrear")
	public static Result guardar() {
		
		Form<CargoLaboral> cargoLaboralForm = form(CargoLaboral.class).bindFromRequest();
		
		try {
			if(cargoLaboralForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearCargoLaboral.render(cargoLaboralForm));
			} else {
				CargoLaboral lc = cargoLaboralForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El cargo laboral se ha actualizado");
				return redirect( controllers.haberes.routes.CargosLaboralesController.ver( cargoLaboralForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el cargo laboral");
			return badRequest(crearCargoLaboral.render(cargoLaboralForm));
		}
	}
	
	@CheckPermiso(key = "cargoLaboralEditar")
	public static Result editar(Long id) {
		CargoLaboral lc = Ebean.find(CargoLaboral.class, id);
		return ok(editarCargoLaboral.render(cargoLaboralForm.fill(lc)));
	}
	
	@CheckPermiso(key = "cargoLaboralEditar")
	public static Result actualizar(){
		
		Form<CargoLaboral> cargoLaboralForm = form(CargoLaboral.class).bindFromRequest();
		
		try {
			
			if(cargoLaboralForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarCargoLaboral.render(cargoLaboralForm));
			} else {
				CargoLaboral lc = cargoLaboralForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El cargo laboral se ha actualizado");
				return redirect( controllers.haberes.routes.CargosLaboralesController.ver( cargoLaboralForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el cargo laboral");
			return badRequest(editarCargoLaboral.render(cargoLaboralForm));
		}
	}
	
	@CheckPermiso(key = "cargoLaboralEliminar")
	public static Result eliminar(Long id) {
		try {
			CargoLaboral.find.byId(id).delete();
			flash("success", "Se ha eliminado el cargo laboral");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el cargo laboral");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "cargoLaboralVer")
	public static Result ver(Long id) throws IOException {
		CargoLaboral lc = CargoLaboral.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el cargo laboral");
			return URL_LISTA_CARGO_LABORAL;
		}
		
		return ok(verCargoLaboral.render(cargoLaboralForm.fill(lc),lc));
	}
	
	public static Result suggestCargoLaboral(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode cargoLaboral = rpta.arrayNode();
	    
	    CargoLaboral lc = new CargoLaboral();
		 
		for(CargoLaboral a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        cargoLaboral.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", cargoLaboral);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		CargoLaboral lc = CargoLaboral.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el cargo laboral");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<CargoLaboral> p = new Pagination<CargoLaboral>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(CargoLaboral.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaCargoLaboral.render(p, form().bindFromRequest()) );
	}
	
}
