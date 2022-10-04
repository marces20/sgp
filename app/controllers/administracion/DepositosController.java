package controllers.administracion;

import models.Deposito;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class DepositosController extends Controller {
	//
	/*public static Result suggestDeposito(String input) {
		ObjectNode rpta = Json.newObject();
	    ArrayNode deposito = rpta.arrayNode();
	    
	    Deposito ad = new Deposito();
		 
		for(Deposito a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        deposito.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", deposito);
		 
		return ok(response);
	}*/
}
