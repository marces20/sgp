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
import models.Usuario;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.contabilidad.bancos.*;

@Security.Authenticated(Secured.class)
public class BancosController extends Controller {
	
	final static Form<Banco> bancoForm = form(Banco.class);
	
	public static Result URL_LISTA_BANCO = redirect(
			controllers.contabilidad.routes.BancosController.indexBanco()
	);
	
	@CheckPermiso(key = "bancosGeneral")
	public static Result indexBanco() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexBanco.render(
						Banco.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "bancosGeneral")
	public static Result crearBanco() {
		Form<Banco> bancoForm = form(Banco.class);
		return ok(crearBanco.render(bancoForm));
	}
	
	@CheckPermiso(key = "bancosGeneral")
	public static Result guardarBanco() {
		
		Form<Banco> bancoForm = form(Banco.class).bindFromRequest();
		
		try {
			if(bancoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearBanco.render(bancoForm));
			} else {
				Banco b = bancoForm.get();
				b.create_date = new Date();
				b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				b.save();
				flash("success", "El banco se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el banco");
			return badRequest(crearBanco.render(bancoForm));
		}
		
		return URL_LISTA_BANCO;
	}
	
	@CheckPermiso(key = "bancosGeneral")
	public static Result editarBanco(Long id) {
		Banco banco = Ebean.find(Banco.class, id);
		
		return ok(editarBanco.render(bancoForm.fill(banco)));
	}
	
	@CheckPermiso(key = "bancosGeneral")
	public static Result actualizarBanco(){
		
		Form<Banco> bancoForm = form(Banco.class).bindFromRequest();
		
		try {
			
			if(bancoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarBanco.render(bancoForm));
			} else {
				Banco b = bancoForm.get();
				b.write_date = new Date();
				b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				b.update();
				flash("success", "El banco se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el banco");
			return badRequest(editarBanco.render(bancoForm));
		}
		return URL_LISTA_BANCO;
	}
	
	@CheckPermiso(key = "bancosGeneral")
	public static Result eliminarBanco(Long id) {
		try {
			Banco.find.byId(id).delete();
			flash("success", "Se ha eliminado el Banco");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el Banco");
		}

		return URL_LISTA_BANCO;
	}
	
	public static Result suggestBanco(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode bancos = rpta.arrayNode();
	    
	    Banco ad = new Banco();
		 
		for(Banco a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", a.cuit);
	        bancos.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", bancos);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Banco banco = Banco.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(banco == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el banco");
		} else {
			restJs.put("success", true);
			restJs.put("id", banco.id);
			restJs.put("nombre", banco.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Banco> p = new Pagination<Banco>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Banco.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaBanco.render(p, form().bindFromRequest()) );
	}
}
