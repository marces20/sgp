package controllers.informes;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.ExpressionList;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.BalancePresupuestario;
import models.Certificacion;
import models.Ejercicio;
import models.Proveedor;
import models.haberes.PuestoLaboral;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import views.html.informes.informePresupuesto.*;

public class InformesPresupuestoController extends Controller {
	
	public static Result creditos(Integer lugarId) {
		
		DynamicForm formBuscador = form().bindFromRequest();
		return ok(creditos.render(formBuscador,lugarId));
	}
	
	
	public static Result getDatosInformesCreditosPresupuestarios(){
		
		
		
		ObjectNode rpta = Json.newObject();
		ArrayNode results = rpta.arrayNode(); 
		if(RequestVar.get("lugarId") != null) {
			Integer lugarId = new Integer(RequestVar.get("lugarId"));
			
			Ejercicio ej = Ejercicio.getEjercicioByFecha(new Date());
			
			List<BalancePresupuestario> ret = BalancePresupuestario.getInfoParaReportes(lugarId,ej.id);
			
			
			
			
			for(BalancePresupuestario x : ret) {
				ObjectNode restJs = Json.newObject();
				restJs.put("cuenta", x.nombre);
				
				BigDecimal saldoPorcentaje = ((x.saldo.subtract(x.preventivo)).multiply(new BigDecimal(100))).divide(x.saldo, 2, RoundingMode.HALF_UP); ;
						
				
				restJs.put("cuenta_analitica_padre_id", x.cuenta_analitica_padre_id); 
				restJs.put("saldo", saldoPorcentaje); 
				restJs.put("preventivo", x.preventivo);
				restJs.put("definitivo", x.definitivo);
				restJs.put("obligacion", x.obligacion);
				restJs.put("pago", x.pago);
				Logger.debug("fffffffffffffffffff "+saldoPorcentaje);
				Logger.debug("fffffffffffffffffff "+x.saldo.subtract(x.preventivo));
				Logger.debug("------------ ");
				results.add(restJs);
			}
			
			
			
			rpta.put("success", true);
			rpta.put("results", results);
		}
		
		return ok(rpta);
	}
}
