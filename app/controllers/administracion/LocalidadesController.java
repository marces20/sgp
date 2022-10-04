package controllers.administracion;

import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Localidad;
import controllers.Secured;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.administracion.localidades.*;

@Security.Authenticated(Secured.class)
public class LocalidadesController extends Controller {
	
	public static Result listOptions(Integer provinciaId){
		List<Localidad> p = Localidad.find.where().eq("provincia_id", provinciaId).orderBy("nombre").findList();
		System.out.println(p.size());
		if(p.size() > 0)
			return ok(optionsListLocalidades.render(p));
		else
			return ok();
	}
	
	public static Result suggestLocalidad(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode localidad = rpta.arrayNode();
	    
	    Localidad ad = new Localidad();
		 
		for(Localidad a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        localidad.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", localidad);
		 
		return ok(response);
	}
	
}
