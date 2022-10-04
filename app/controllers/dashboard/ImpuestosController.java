package controllers.dashboard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Cuenta;
import models.Estado;
import models.Factura;
import models.Pago;
import models.Periodo;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.dashboard.impuestos.*;
import views.html.dashboard.impuestos.vistas.*;

@Security.Authenticated(Secured.class)
public class ImpuestosController  extends Controller {
	
	@CheckPermiso(key = "dashboardImpuestosEstadoDeuda")
	public static Result estadoDeuda() {
		
		List<SqlRow>  p = Pago.getImpuestosNoPagadoAgrupados();

		return ok(estadoDeudaImpuestos.render(p));
	}
	
	@CheckPermiso(key = "dashboardImpuestosEstadoDeuda")
	public static Result detalleImpuestos(Long id) {
		
		List<Pago> p = Pago.find.where()
				.disjunction()
				.eq("estado_id", Estado.PAGO_ESTADO_BORRADOR)
				.eq("estado_id", Estado.PAGO_ESTADO_EN_CURSO)
				.endJunction()
				.eq("cuenta_impuesto_id",id)
				.findList();
		
		Cuenta z = Cuenta.find.byId(id);
		TreeMap<Long,List<Pago>> retPeriodoPago = new TreeMap<Long,List<Pago>>();
		Map<Long,String> periodo = new HashMap<Long,String>();
		Map<Long,BigDecimal> totalPeriodo = new HashMap<Long,BigDecimal>();
		BigDecimal total = new BigDecimal(0); 
		for(Pago x :p){
			Periodo pe = Periodo.getPeriodoByDate(x.fecha_pago);
			if(pe != null){
				Long periodoId = pe.id; 
				periodo.put(pe.id, pe.nombre);
				total = total.add(x.total);
				if(retPeriodoPago.containsKey(periodoId)){
					List<Pago> lpt = retPeriodoPago.get(periodoId);
					lpt.add(x);
					retPeriodoPago.put(periodoId, lpt);
					
					BigDecimal stt = totalPeriodo.get(periodoId);
					BigDecimal stt2 = new BigDecimal(0); 
					stt2 = stt.add(x.total);
					totalPeriodo.put(periodoId, stt2);
					
				}else{
					List<Pago> lpt = new ArrayList<Pago>();
					lpt.add(x);
					retPeriodoPago.put(periodoId, lpt);
					
					totalPeriodo.put(periodoId, x.total);
				}
			}
		}
		
		Object c = detalleImpuestos.render(retPeriodoPago,periodo,z.nombre,totalPeriodo,total);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

}
