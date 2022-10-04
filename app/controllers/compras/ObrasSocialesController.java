package controllers.compras;

import static play.data.Form.form;
import models.Categoria;
import models.Obrasocial;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.compras.obrasSociales.*;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class ObrasSocialesController extends Controller {
	
	
	public static Result suggestObrasocial(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode ob = rpta.arrayNode();
	    
	    Obrasocial ad = new Obrasocial();
		 
		for(Obrasocial a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        ob.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", ob);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Obrasocial ob = Obrasocial.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(ob == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la obra social");
		} else {
			restJs.put("success", true);
			restJs.put("id", ob.id);
			restJs.put("nombre", ob.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Obrasocial> p = new Pagination<Obrasocial>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Obrasocial.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaObrasocial.render(p, form().bindFromRequest()) );
	}
}
