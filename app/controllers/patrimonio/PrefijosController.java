package controllers.patrimonio;

import static play.data.Form.form;

import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Cliente;
import models.InventarioPrefijo;
import models.Remito;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.patrimonio.inventario.*;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class PrefijosController extends Controller {
		
	public static Result modalBuscar() {
    	Pagination<InventarioPrefijo> p = new Pagination<InventarioPrefijo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("prefijo");	
    	p.setExpressionList(InventarioPrefijo.find.where().disjunction().ilike("nombre", "%" + RequestVar.get("prefijo") + "%").ilike("prefijo", "%" + RequestVar.get("prefijo") + "%"));
		return ok( modalBusquedaPrefijos.render(p, form().bindFromRequest()) );
	}
	
	public static Result get(int id){
		InventarioPrefijo prefijo = InventarioPrefijo.find.select("id, prefijo, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(prefijo == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el usuario");
		} else {
			restJs.put("success", true);
			restJs.put("id", prefijo.id);
			restJs.put("nombre", prefijo.prefijo + " | " + prefijo.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result suggest(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode cliente = rpta.arrayNode();
	    
		List<InventarioPrefijo> l = InventarioPrefijo.find.where()
				.disjunction()
				.ilike("nombre", "%"+input+"%")
				.ilike("prefijo", "%"+input+"%")
				.setMaxRows(25)
				.orderBy("prefijo")
			    .findList(); 
		 
		for(InventarioPrefijo i : l){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", i.id);
	        restJs.put("value",i.prefijo + " | " + i.nombre);
	        restJs.put("info", "");
	        cliente.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", cliente);
		 
		return ok(response);
	}
}
