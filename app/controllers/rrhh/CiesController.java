package controllers.rrhh;

import static play.data.Form.form;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Cie;
import models.auth.Permiso;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.rrhh.cies.modalBusquedaCie;


public class CiesController extends Controller {
	
	public static Result suggestCie(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode profesion = rpta.arrayNode();
	    
	    Cie ad = new Cie();
		 
		for(Cie a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        String info = (Permiso.check("descripcionCie"))?a.descripcion:"";
	        restJs.put("info", info);
	        profesion.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", profesion);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Cie c = Cie.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(c == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el cie");
		} else {
			restJs.put("success", true);
			restJs.put("id", c.id);
			restJs.put("nombre", c.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Cie> p = new Pagination<Cie>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Cie.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaCie.render(p, form().bindFromRequest()) );
	}
}
