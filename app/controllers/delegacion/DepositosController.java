package controllers.delegacion;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Deposito;
import models.Expediente;
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
import views.html.delegacion.depositos.*;

@Security.Authenticated(Secured.class)
public class DepositosController extends Controller {
	
	final static Form<Deposito> depositoForm = form(Deposito.class);
	
	public static Result URL_LISTA_DEPOSITO = redirect(
			controllers.delegacion.routes.DepositosController.index()
	);
	
	@CheckPermiso(key = "depositosGeneral")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		
		return ok(
				indexDeposito.render(
						Deposito.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "depositosGeneral")
	public static Result crear() {
		Form<Deposito> depositoForm = form(Deposito.class);
		return ok(crearDeposito.render(depositoForm));
	}
	
	@CheckPermiso(key = "depositosGeneral")
	public static Result guardar() {
		
		Form<Deposito> depositoForm = form(Deposito.class).bindFromRequest();
		
		if(depositoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearDeposito.render(depositoForm));
		}
		
		try {
			Deposito  d= depositoForm.get();
			d.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			d.create_date = new Date();
			d.save();
			
			flash("success", "El depósito se ha reado correctamente.");
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el depósito");
			return badRequest(crearDeposito.render(depositoForm));
		}
		
		return URL_LISTA_DEPOSITO;
	}
	
	@CheckPermiso(key = "depositosGeneral")
	public static Result editar(Long id) {
		Deposito deposito = Ebean.find(Deposito.class, id);
		return ok(editarDeposito.render(depositoForm.fill(deposito)));
	}
	
	@CheckPermiso(key = "depositosGeneral")
	public static Result actualizar(){
		Form<Deposito> depositoForm = form(Deposito.class).bindFromRequest();
		
		if(depositoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarDeposito.render(depositoForm));
		} 
		
		try {
			Deposito  d= depositoForm.get();
			d.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			d.write_date = new Date();
			d.update();
			
			flash("success", "El depósito se ha actualizado");
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el depósito");
			return badRequest(editarDeposito.render(depositoForm));
		}
		return URL_LISTA_DEPOSITO;
	}
	
	@CheckPermiso(key = "depositosGeneral")
	public static Result eliminar(Long id) {
		try {
			Deposito.find.byId(id).delete();
			flash("success", "Se ha eliminado el depósito");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el depósito");
		}

		return URL_LISTA_DEPOSITO;
	}
	
	public static Result suggestDeposito(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode depositos = rpta.arrayNode();
	    
	    Deposito ad = new Deposito();
		 
		for(Deposito a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        depositos.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", depositos);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Deposito deposito = Deposito.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(deposito == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el depósito");
		} else {
			restJs.put("success", true);
			restJs.put("id", deposito.id);
			restJs.put("nombre", deposito.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Deposito> p = new Pagination<Deposito>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Deposito.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaDeposito.render(p, form().bindFromRequest()) );
	}
}
