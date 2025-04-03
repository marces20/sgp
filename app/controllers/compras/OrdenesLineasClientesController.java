package controllers.compras;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.select.Evaluator.IsEmpty;

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
import utils.DateUtils;
import views.html.compras.lineasOrdenes.crearLineaProducto;
import views.html.contabilidad.facturas.acciones.modalModificarNumeroFactura;

@Security.Authenticated(Secured.class)
public class OrdenesLineasClientesController extends Controller {

	public static Result guardarAjax() {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();

	    String [] clienteId = request().body().asFormUrlEncoded().get("clienteId");
	    String [] lineaId = request().body().asFormUrlEncoded().get("idLinea");
	    String [] cantidad = request().body().asFormUrlEncoded().get("cantidad");

	    String [] ips = request().body().asFormUrlEncoded().get("ips");
	    String [] diagnostico = request().body().asFormUrlEncoded().get("diagnostico");
	    String [] ida = request().body().asFormUrlEncoded().get("ida");
	    String [] vuelta = request().body().asFormUrlEncoded().get("vuelta");
	    String [] fecha = request().body().asFormUrlEncoded().get("fecha");

	    ObjectNode restJs = Json.newObject();

	    Logger.debug("ggggggggggggggggg "+ (fecha[0] != null && fecha[0].isEmpty() && !DateUtils.validateJavaDate(fecha[0])));

	    if(fecha[0] != null && fecha[0].isEmpty() && !DateUtils.validateJavaDate(fecha[0])) {
			flash("error", "Fecha Incorrecta.");
			restJs.put("respuesta",false);
		}else {

			 Logger.debug("ggggggggggggggggg111111111111111 ");


		    if(clienteId != null && clienteId[0] !=null && !clienteId[0].isEmpty() && lineaId != null && lineaId[0] !=null && !lineaId[0].isEmpty()){
		    	try{
			    	OrdenLineaCliente olc = new OrdenLineaCliente();
			    	olc.cliente_id = new Long(clienteId[0]);
			    	olc.orden_linea_id  = new Long(lineaId[0]);
			    	olc.cantidad = (cantidad != null && cantidad[0] != null && !cantidad[0].isEmpty())?new BigDecimal(cantidad[0]):BigDecimal.ZERO;

			    	if(ips != null &&  !ips[0].isEmpty()) {
			    		olc.ips = new Boolean(ips[0]);
			    	}

			    	if(diagnostico != null &&  !diagnostico[0].isEmpty()) {
			    		olc.diagnostico = diagnostico[0];
			    	}

			    	if(ida != null &&  !ida[0].isEmpty()) {
			    		olc.ida_institucion_externa_id = new Long(ida[0]);
			    	}
			    	if(vuelta != null &&  !vuelta[0].isEmpty()) {
			    		olc.vuelta_institucion_externa_id = new Long(vuelta[0]);
			    	}
			    	if(fecha[0] != null &&  !fecha[0].isEmpty()) {
			    		Date fechastr = DateUtils.formatDate(fecha[0], "dd/MM/yyyy");
			    		olc.fecha = fechastr;
			    	}



			    	olc.save();

			    	restJs.put("respuesta",true);
			    	restJs.put("url",controllers.compras.routes.OrdenesLineasClientesController.eliminarAjax(olc.id).url());
		    	}catch(Exception e){
		    		 Logger.debug("ggggggggggggggggg122222 "+e);
		    		restJs.put("respuesta",false);
		    	}
		    }else{
		    	restJs.put("respuesta",false);
		    }
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
