package controllers.rrhh;

import static play.data.Form.form;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Especialidad;
import models.Profesion;
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
