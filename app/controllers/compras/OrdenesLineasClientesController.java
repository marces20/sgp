package controllers.compras;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.OrdenLinea;
import models.OrdenLineaCliente;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.compras.lineasOrdenes.crearLineaProducto;

@Security.Authenticated(Secured.class)
public class OrdenesLineasClientesController extends Controller {
	
	public static Result guardarAjax() {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    
	    String [] clienteId = request().body().asFormUrlEncoded().get("clienteId");
	    String [] lineaId = request().body().asFormUrlEncoded().get("idLinea"); 
	    String [] cantidad = request().body().asFormUrlEncoded().get("cantidad"); 
	    ObjectNode restJs = Json.newObject();
	    
	    if(clienteId != null && clienteId[0] !=null && !clienteId[0].isEmpty() && lineaId != null && lineaId[0] !=null && !lineaId[0].isEmpty()){
	    	try{
		    	OrdenLineaCliente olc = new OrdenLineaCliente();
		    	olc.cliente_id = new Long(clienteId[0]);
		    	olc.orden_linea_id  = new Long(lineaId[0]);
		    	olc.cantidad = (cantidad != null && cantidad[0] != null && !cantidad[0].isEmpty())?new BigDecimal(cantidad[0]):BigDecimal.ZERO;
		    	olc.save();
		    	
		    	restJs.put("respuesta",true);
		    	restJs.put("url",controllers.compras.routes.OrdenesLineasClientesController.eliminarAjax(olc.id).url()); 
	    	}catch(Exception e){
	    		restJs.put("respuesta",false);
	    	}
	    }else{
	    	restJs.put("respuesta",false);
	    }
	    
	    results.add(restJs);
	    ObjectNode response = Json.newObject();
		response.put("results", results);
		
		return ok(response);
	}
	
	public static Result eliminarAjax(Long id) {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode restJs = Json.newObject();
	    
	    if(id != null){ 
    		try{
    			OrdenLineaCliente.find.byId(id).delete();
    			restJs.put("respuesta",true);
    		}catch(Exception e){
    			restJs.put("respuesta",false);
    		}	
		}else{
			restJs.put("respuesta",false);
		}
	    
	    results.add(restJs);
	    ObjectNode response = Json.newObject();
		response.put("results", results);
		
		return ok(response);
	}    
}
