package controllers.rrhh;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import models.Departamento;
import models.Usuario;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.rrhh.departamento.crearDepartamento;
import views.html.rrhh.departamento.editarDepartamento;
import views.html.rrhh.departamento.indexDepartamento;
import views.html.rrhh.departamento.modalBusquedaDepartamento;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class DepartamentosController extends Controller {
	
	final static Form<Departamento> departamentoForm = form(Departamento.class);
	
	public static Result URL_LISTA_DEPARTAMENTO = redirect(
			controllers.rrhh.routes.DepartamentosController.indexDepartamento()
	);
	
	@CheckPermiso(key = "departamentosGeneral")
	public static Result indexDepartamento() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexDepartamento.render(
						Departamento.page(
								 RequestVar.get("nombre")
								 ),
								 d));
		
	}
	
	@CheckPermiso(key = "departamentosGeneral")
	public static Result crearDepartamento() {
		Form<Departamento> departamentoForm = form(Departamento.class);
		departamentoForm.discardErrors();
		return ok(crearDepartamento.render(departamentoForm));
	}
	
	@CheckPermiso(key = "departamentosGeneral")
	public static Result guardarDepartamento() {
		
		Form<Departamento> departamentoForm = form(Departamento.class).bindFromRequest();
		
		try {
			
			if(departamentoForm.field("parent_departamento.id").value().isEmpty()){
				departamentoForm.reject("parent_departamento.id","El Padre es obligatorio.");
			}
			
			if(departamentoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearDepartamento.render(departamentoForm));
			} else {
				Departamento d = departamentoForm.get();
				d.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				d.create_date = new Date();
				d.save();
				flash("success", "El departamento se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el departamento");
			return badRequest(crearDepartamento.render(departamentoForm));
		}
		
		return URL_LISTA_DEPARTAMENTO;
	}
	
	@CheckPermiso(key = "departamentosGeneral")
	public static Result editarDepartamento(Long id) {
		Departamento departamento = Ebean.find(Departamento.class, id);
		return ok(editarDepartamento.render(departamentoForm.fill(departamento)));
	}
	
	@CheckPermiso(key = "departamentosGeneral")
	public static Result actualizarDepartamento(){
		
		Form<Departamento> departamentoForm = form(Departamento.class).bindFromRequest();
		
		try {
			if(departamentoForm.field("parent_departamento.id").value().isEmpty()){
				departamentoForm.reject("parent_departamento.id","El Padre es obligatorio.");
			}
			
			if(departamentoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarDepartamento.render(departamentoForm));
			} else {
				Departamento d = departamentoForm.get();
				d.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				d.write_date = new Date();
				d.update();
				flash("success", "El departamento se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el departamento");
			return badRequest(editarDepartamento.render(departamentoForm));
		}
		return URL_LISTA_DEPARTAMENTO;
	}
	
	@CheckPermiso(key = "departamentosGeneral")
	public static Result eliminarDepartamento(Long id) {
		try {
			Departamento.find.byId(id).delete();
			flash("success", "Se ha eliminado el Departamento");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el Departamento");
		}

		return URL_LISTA_DEPARTAMENTO;
	}
	
	public static Result suggestDepartamento(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode departamento = rpta.arrayNode();
	    
	    Departamento ad = new Departamento();
		 
		for(Departamento a : ad.getDataSuggest(input, 25)){
			
			Logger.debug(a.id+"  ---- "+a.create_date);
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        departamento.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", departamento);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Departamento depto = Departamento.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(depto == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el departamento");
		} else {
			restJs.put("success", true);
			restJs.put("id", depto.id);
			restJs.put("nombre", depto.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Departamento> p = new Pagination<Departamento>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Departamento.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaDepartamento.render(p, form().bindFromRequest()) );
	}
	
}
