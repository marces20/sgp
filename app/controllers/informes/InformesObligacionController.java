package controllers.informes;

import static play.data.Form.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Certificacion;
import models.Estado;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import views.html.informes.informeObligacion.*;

public class InformesObligacionController extends Controller {
	
	public static Result obligacion() {
		
		DynamicForm formBuscador = form().bindFromRequest();
		return ok(obligacion.render(formBuscador));
	}
	
	public static Result getObligaciones() throws IOException{
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    
	    List<SqlRow> ra = new ArrayList<SqlRow>();
	    
	    String sql = "SELECT ocr.nombre as rubro,p.id as periodo_id,p.nombre as periodo,sum(o.total) as total " + 
		    		" FROM ( " + 
		    		"			select p.id as periodo_id,op.orden_compra_id as orden_id, " + 
		    		"			sum(total_acta) as total " + 
		    		"			from totales_por_acta ta " + 
		    		"			inner join actas_recepcion ar on ta.acta_id = ar.id " + 
		    		"			inner join ordenes_provision op on op.id = ta.orden_provision_id " + 
		    		"			inner join periodos p on ar.fecha BETWEEN date_start and date_stop "+			
		    		"			group by p.id,op.orden_compra_id " + 
		    		"UNION ALL " + 
		    		"			select c.periodo_id as periodo_id,c.orden_id as orden_id, " + 
		    		"			sum(COALESCE(cl.base,0)+COALESCE(cla.base,0)) as total " + 
		    		"			from certificaciones_compras  c " + 
		    		"			left outer join (select certificacion_compra_id, round(sum(precio * cantidad)::numeric,2) as base  " + 
		    		"					from certificaciones_compras_lineas group by certificacion_compra_id) as cl on cl.certificacion_compra_id = c.id " + 
		    		"			left outer join (select certificacion_compra_id, round(sum(precio * cantidad)::numeric,2) as base " + 
		    		"					from certificaciones_compras_linea_ajustes group by certificacion_compra_id) as cla on cla.certificacion_compra_id = c.id " + 
		    		"			where c.state_id = 81 " + 
		    		"			group by c.periodo_id,c.orden_id " + 
		    		") o " + 
		    		"inner join ordenes oc on oc.id = o.orden_id " + 
		    		"inner join ordenes_rubros ocr on ocr.id = oc.orden_rubro_id " + 
		    		"inner join periodos p on p.id = o.periodo_id " + 
		    		"inner join expedientes e on e.id = oc.expediente_id " + 
		    		"where e.ejercicio_id = 12 " + 
		    		//"and oc.orden_rubro_id in(7,8) " + 
		    		"group by ocr.nombre,p.nombre,p.id " + 
		    		"order by p.id";
	    
				SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
									//.setParameter("orden_id", Integer.parseInt(RequestVar.get("orden_id")));
				ra = sqlQuery.findList();
				
				
				ObjectNode restJs = Json.newObject();
				for (SqlRow sr : ra) {
					ObjectNode restJs2 = Json.newObject();
					
					Logger.debug("--------------------");
					Logger.debug(sr.getString("rubro"));
					Logger.debug(sr.getString("periodo"));
					Logger.debug(restJs.toString());
					
					
					
					
					if(restJs.has(sr.getString("periodo"))) {
						
						ObjectNode restJs3 = (ObjectNode) restJs.get(sr.getString("periodo"));
						
						restJs3.put(sr.getString("rubro"), sr.getDouble("total"));
						restJs.put(sr.getString("periodo"),restJs3);
						
						//Logger.debug(restJs.toString());
					}else {
						restJs2.put(sr.getString("rubro"), sr.getDouble("total"));
						restJs.put(sr.getString("periodo"),restJs2);
					}
					
					
					
					
					
				}
				
				
				results.add(restJs);
				response.put("success", true);
				response.put("results", results);
				return ok(response);
	    
	    /*if(request().body().asFormUrlEncoded().get("proveedorId") != null && request().body().asFormUrlEncoded().get("proveedorId")[0] !=null && !request().body().asFormUrlEncoded().get("proveedorId")[0].isEmpty()){
	    	
	    	List<Certificacion> c = Certificacion.
	    			find.where().
	    			eq("proveedor_id",new Long(request().body().asFormUrlEncoded().get("proveedorId")[0]))
	    			.orderBy("fecha_certificacion desc")
	    			.findList();
	    	
	    	
    		BigDecimal base = new BigDecimal(0);
    		BigDecimal descuento = new BigDecimal(0);
    		BigDecimal total = new BigDecimal(0);
    		
	    	for (Certificacion certificacion : c) {
	    		ObjectNode restJslinea = Json.newObject();
	    		ObjectNode restJs = Json.newObject();
	    		 
	    		restJs.put("referencia",certificacion.nombre);
	    		 
	    		
	    		String classEstado = "";
	    		Estado i = certificacion.estado;
	    		
	    		if(i != null && i.id == Estado.CERTIFICACION_ESTADO_BORRADOR){
	    			classEstado = "borrador";
	    		}else if(i != null && i.id == Estado.CERTIFICACION_ESTADO_CANCELADO){
	    			classEstado = "cancelada";
	    		}else if(i != null && i.id == Estado.CERTIFICACION_ESTADO_IMPUTADO){
	    			classEstado = "autorizado";
	    		}
	    		restJs.put("classEstado",classEstado);
	    		
	    		 
	    		
	    		results.add(restJs);
			}
    		
	    	response.put("base", utils.NumberUtils.moneda(base));
	    	response.put("descuento", utils.NumberUtils.moneda(descuento));
	    	response.put("total", utils.NumberUtils.moneda(total));
	    	
    	}*/
	    
	   
	}

}
