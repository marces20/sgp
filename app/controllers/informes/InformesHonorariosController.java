package controllers.informes;

import static play.data.Form.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Periodo;
import models.haberes.LiquidacionMes;
import models.haberes.LiquidacionTipo;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import views.html.informes.informeHonorario.*;

public class InformesHonorariosController extends Controller {
	
	public static Result honorarioRrhhPorPeriodo() {
		Long pId = null;
		Integer total= new Integer(0);
		Integer totalconve = new Integer(0);
		Integer totalparque = new Integer(0);
		
		if(!RequestVar.get("periodo.id").isEmpty()){
			pId = new Long(RequestVar.get("periodo.id"));
			
			List<SqlRow> l = LiquidacionMes.getCountRelacionPorPeriodoNew(pId);
					
			for(SqlRow lx : l) {
				
				if(lx.getBoolean("cm")) {
					totalconve = lx.getInteger("count");
					total = total+ totalconve;
				}else {
					totalparque = lx.getInteger("count");
					total = total+ totalparque;
				}
			}
			
			
		}else {
			flash("error", "Debe Seleccionar un Periodo.");
		}
		
		DynamicForm formBuscador = form().bindFromRequest();
		return ok(honorarioRrhhPorPeriodo.render(formBuscador,pId,total,totalconve,totalparque));
	}
	
	public static Result getCountRrrhPorEscala(){
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    
	    Long idPeriodo = null;
	    Boolean convenio = null;
	    
	    if(request().body().asFormUrlEncoded().get("idPeriodo")[0] != null && !request().body().asFormUrlEncoded().get("idPeriodo")[0].isEmpty()) {
	    	idPeriodo = new Long(request().body().asFormUrlEncoded().get("idPeriodo")[0]);
	    }
	    
	    if(request().body().asFormUrlEncoded().get("convenio")[0] != null && !request().body().asFormUrlEncoded().get("convenio")[0].isEmpty()) {
	    	convenio = new Boolean(request().body().asFormUrlEncoded().get("convenio")[0]);
	    }
	     
	    
	    if(idPeriodo != null && convenio != null){
	    
		    try {
				List<SqlRow> res = LiquidacionMes.getCountPorEscalaNew(idPeriodo, convenio);
				
				ObjectNode restJs = Json.newObject();
				for (SqlRow sr : res) {
					restJs.put(sr.getLong("escala_id").toString(),sr.getInteger("count"));
				}
				
				results.add(restJs);
				response.put("success", true);
				response.put("results", results);
		    }catch (Exception e) {
		    	response.put("success", false);
			}
	    }
		
		return ok(response);
	}
	
	
	public static Result honorario() {
		
		
		BigDecimal total= new BigDecimal(0);
		BigDecimal totalsp = new BigDecimal(0);
		BigDecimal totalp = new BigDecimal(0);
		
		BigDecimal totalParque= new BigDecimal(0);
		BigDecimal totalspParque = new BigDecimal(0);
		BigDecimal totalpParque = new BigDecimal(0);
		
		BigDecimal totalConvenio= new BigDecimal(0);
		BigDecimal totalspConvenio = new BigDecimal(0);
		BigDecimal totalpConvenio = new BigDecimal(0);
		
		BigDecimal contribucionesPatronalesObraSocial = new BigDecimal(0);
		BigDecimal contribucionesPatronalesJubilacion = new BigDecimal(0);
		
		BigDecimal porcentaje_patronal_ob = new BigDecimal(0); 
		BigDecimal porcentaje_patronal_jub = new BigDecimal(0); 
		Long pId = null;
		if(!RequestVar.get("periodo.id").isEmpty()){
			
			pId = new Long(RequestVar.get("periodo.id"));
			
			porcentaje_patronal_ob = Periodo.find.byId(pId).getPatronalObraSocialPorcentaje().divide(new BigDecimal(100));
			porcentaje_patronal_jub = Periodo.find.byId(pId).getPatronalJubilacionPorcentaje().divide(new BigDecimal(100));
			
			
			List<SqlRow> l = LiquidacionMes.getTotalesPorTipoConcepto(pId);
			
			for(SqlRow lx : l) {
				Logger.debug(lx.toString());
				Logger.debug(lx.getBigDecimal("total_ca").toString());
				
				total = total.add(lx.getBigDecimal("total_ca")).add(lx.getBigDecimal("total_sa")).add(lx.getBigDecimal("total_retencion"));
				
				
				//(liquidacion_tipo_id.compareTo((int)LiquidacionTipo.AYUDA_ESCOLAR) != 0 && liquidacion_tipo_id.compareTo((int)LiquidacionTipo.SAC) != 0)
				
				if( (lx.getLong("liquidacion_tipo_id").compareTo(LiquidacionTipo.AYUDA_ESCOLAR) != 0) && (lx.getLong("liquidacion_tipo_id").compareTo(LiquidacionTipo.SAC) != 0) ){
					contribucionesPatronalesObraSocial = contribucionesPatronalesObraSocial.add(lx.getBigDecimal("total_ca").multiply(porcentaje_patronal_ob).setScale(2, BigDecimal.ROUND_HALF_UP));
				}
				if( (lx.getLong("liquidacion_tipo_id").compareTo(LiquidacionTipo.AYUDA_ESCOLAR) != 0)){
					contribucionesPatronalesJubilacion = contribucionesPatronalesJubilacion.add(lx.getBigDecimal("total_ca").multiply(porcentaje_patronal_jub).setScale(2, BigDecimal.ROUND_HALF_UP));
				}
				
				totalp = totalp.add(contribucionesPatronalesObraSocial).add(contribucionesPatronalesJubilacion);
				
				
				if(lx.getBoolean("convenio_ministerio")) {
					totalConvenio = totalConvenio.add(lx.getBigDecimal("total_ca")).add(lx.getBigDecimal("total_sa")).add(lx.getBigDecimal("total_retencion"));
					totalpConvenio = totalpConvenio.add(contribucionesPatronalesObraSocial).add(contribucionesPatronalesJubilacion);
					
				}else {
					totalParque = totalParque.add(lx.getBigDecimal("total_ca")).add(lx.getBigDecimal("total_sa")).add(lx.getBigDecimal("total_retencion"));
					totalpParque = totalpParque.add(contribucionesPatronalesObraSocial).add(contribucionesPatronalesJubilacion);
				}
				
			}
			totalspConvenio = totalConvenio.subtract(totalpConvenio);
			totalspParque = totalParque.subtract(totalpParque);
			totalsp = total.subtract(totalp);
		}else {
			flash("error", "Debe Seleccionar un Periodo.");
		}
		
		
		
		
		
		//LiquidacionMes.getCostoTotalPorTipoConcepto(new Long(119), false);
		
		
		DynamicForm formBuscador = form().bindFromRequest();
		return ok(honorario.render(formBuscador,pId,total,
												totalp,
												totalsp,
												totalParque,totalpParque,totalspParque,
												totalConvenio,totalpConvenio,totalspConvenio));
	}
	
	public static Result getCostoPorEscala(){
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    
	    Long idPeriodo = null;
	    Boolean convenio = null;
	    
	    if(request().body().asFormUrlEncoded().get("idPeriodo")[0] != null && !request().body().asFormUrlEncoded().get("idPeriodo")[0].isEmpty()) {
	    	idPeriodo = new Long(request().body().asFormUrlEncoded().get("idPeriodo")[0]);
	    }
	    
	    if(request().body().asFormUrlEncoded().get("convenio")[0] != null && !request().body().asFormUrlEncoded().get("convenio")[0].isEmpty()) {
	    	convenio = new Boolean(request().body().asFormUrlEncoded().get("convenio")[0]);
	    }
	     
	    
	    if(idPeriodo != null && convenio != null){
	    
		    try {
				List<SqlRow> res = LiquidacionMes.getCostoTotalPorEscalaNew(idPeriodo, convenio);
				
				ObjectNode restJs = Json.newObject();
				for (SqlRow sr : res) {
					restJs.put(sr.getLong("escala_id").toString(),sr.getDouble("monto"));
				}
				
				results.add(restJs);
				response.put("success", true);
				response.put("results", results);
		    }catch (Exception e) {
		    	response.put("success", false);
			}
	    }
		
		return ok(response);
	}
	
	public static Result getCostoPorTipoConcepto(){
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    
	    Long idPeriodo = null;
	    Boolean convenio = null;
	    
	    if(request().body().asFormUrlEncoded().get("idPeriodo")[0] != null && !request().body().asFormUrlEncoded().get("idPeriodo")[0].isEmpty()) {
	    	idPeriodo = new Long(request().body().asFormUrlEncoded().get("idPeriodo")[0]);
	    }
	    
	    if(request().body().asFormUrlEncoded().get("convenio")[0] != null && !request().body().asFormUrlEncoded().get("convenio")[0].isEmpty()) {
	    	convenio = new Boolean(request().body().asFormUrlEncoded().get("convenio")[0]);
	    }
	     
	    
	    if(idPeriodo != null && convenio != null){
	    
		    try {
				List<SqlRow> res = LiquidacionMes.getCostoTotalPorTipoConceptoNew(idPeriodo, convenio);
				
				ObjectNode restJs = Json.newObject();
				for (SqlRow sr : res) {
					restJs.put(sr.getLong("tipo").toString(),sr.getDouble("monto"));
				}
				
				results.add(restJs);
				response.put("success", true);
				response.put("results", results);
		    }catch (Exception e) {
		    	response.put("success", false);
		    	Logger.debug(e.toString());
			}
	    }
		
		return ok(response);
	}
	
	public static Result getCostoPorClasificacionConcepto(){
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    
	    Long idPeriodo = null;
	    Boolean convenio = null;
	    
	    if(request().body().asFormUrlEncoded().get("idPeriodo")[0] != null && !request().body().asFormUrlEncoded().get("idPeriodo")[0].isEmpty()) {
	    	idPeriodo = new Long(request().body().asFormUrlEncoded().get("idPeriodo")[0]);
	    }
	    
	    if(request().body().asFormUrlEncoded().get("convenio")[0] != null && !request().body().asFormUrlEncoded().get("convenio")[0].isEmpty()) {
	    	convenio = new Boolean(request().body().asFormUrlEncoded().get("convenio")[0]);
	    }
	     
	    
	    if(idPeriodo != null && convenio != null){
	    
		    try {
				List<SqlRow> res = LiquidacionMes.getCostoTotalPorClasificacionConceptoNew(idPeriodo, convenio);
				
				ObjectNode restJs = Json.newObject();
				for (SqlRow sr : res) {
					restJs.put(sr.getLong("clasificacion_id").toString(),sr.getDouble("monto"));
				}
				
				results.add(restJs);
				response.put("success", true);
				response.put("results", results);
		    }catch (Exception e) {
		    	response.put("success", false);
		    	Logger.debug(e.toString());
			}
	    }
		
		return ok(response);
	}
	
	
}
