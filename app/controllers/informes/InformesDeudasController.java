package controllers.informes;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.informes.HistorialDeudaProveedores;
import models.informes.InformeDeudaPorActaMaterializada;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DateUtils;
import utils.RequestVar;
import views.html.informes.informeDeuda.*;

public class InformesDeudasController extends Controller {
	
	public static Result deudasFotoPorFecha() {
		DynamicForm formBuscador = form().bindFromRequest();
		
		BigDecimal totalCorte = new BigDecimal(0);
		BigDecimal totalHoy = new BigDecimal(0);
		BigDecimal totalDiferencia = new BigDecimal(0);
		
		BigDecimal totalCorteE = new BigDecimal(0);
		BigDecimal totalHoyE = new BigDecimal(0);
		BigDecimal totalDiferenciaE = new BigDecimal(0);
		
		BigDecimal totalCorteO = new BigDecimal(0);
		BigDecimal totalHoyO = new BigDecimal(0);
		BigDecimal totalDiferenciaO = new BigDecimal(0);
		String fString= null;
		String fechaHoyString= null;
		if(!RequestVar.get("fecha_corte").isEmpty()){
			fString = RequestVar.get("fecha_corte");
			
			Date fechaHoy = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			fechaHoyString = simpleDateFormat.format(fechaHoy);
			
			Date fecha = DateUtils.formatDate(RequestVar.get("fecha_corte"), "dd/MM/yyyy"); 
			
			List<SqlRow> requipo = HistorialDeudaProveedores.getTotalesPorCorteFechaNuevo(true,fecha,true,false);
			for(SqlRow e : requipo) {
				totalCorte = totalCorte.add(e.getBigDecimal("total_deuda"));
				totalCorteE = totalCorteE.add(e.getBigDecimal("total_deuda"));
			}
			
			List<SqlRow> rtotros = HistorialDeudaProveedores.getTotalesPorCorteFechaNuevo(true,fecha,false,false);
			for(SqlRow o : rtotros) {
				totalCorte = totalCorte.add(o.getBigDecimal("total_deuda"));
				totalCorteO = totalCorteO.add(o.getBigDecimal("total_deuda"));
			}
			
			List<SqlRow> requipoHoy = HistorialDeudaProveedores.getTotalesPorCorteFechaNuevo(true,fecha,true,true);
			for(SqlRow e : requipoHoy) {
				totalHoy = totalHoy.add(e.getBigDecimal("total_deuda"));
				totalHoyE = totalHoyE.add(e.getBigDecimal("total_deuda"));
			}
			
			List<SqlRow> rtotrosHoy = HistorialDeudaProveedores.getTotalesPorCorteFechaNuevo(true,fecha,false,true);
			for(SqlRow o : rtotrosHoy) {
				totalHoy = totalHoy.add(o.getBigDecimal("total_deuda"));
				totalHoyO = totalHoyO.add(o.getBigDecimal("total_deuda"));
			}
			
			 
			
			
			
			
			
			totalDiferencia = totalCorte.subtract(totalHoy);
			totalDiferenciaE = totalCorteE.subtract(totalHoyE);
			totalDiferenciaO = totalCorteO.subtract(totalHoyO);
			
			
			
			
			
		}else {
			flash("error", "Debe Seleccionar una Fecha de Corte.");
		}
		
		
		return ok(deudaFotoPorFecha.render(formBuscador,fString,fechaHoyString,
				totalCorte,totalHoy,totalDiferencia,
				totalCorteE,totalHoyE,totalDiferenciaE,
				totalCorteO,totalHoyO,totalDiferenciaO));
	}
	
	
	/*public static Result deudasFotoPorFechaOld() {
		DynamicForm formBuscador = form().bindFromRequest();
		
		BigDecimal totalCorte = new BigDecimal(0);
		BigDecimal totalHoy = new BigDecimal(0);
		BigDecimal totalDiferencia = new BigDecimal(0);
		
		BigDecimal totalCorteE = new BigDecimal(0);
		BigDecimal totalHoyE = new BigDecimal(0);
		BigDecimal totalDiferenciaE = new BigDecimal(0);
		
		BigDecimal totalCorteO = new BigDecimal(0);
		BigDecimal totalHoyO = new BigDecimal(0);
		BigDecimal totalDiferenciaO = new BigDecimal(0);
		String fString= null;
		String fechaHoyString= null;
		if(!RequestVar.get("fecha_corte").isEmpty()){
			fString = RequestVar.get("fecha_corte");
			
			Date fechaHoy = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			fechaHoyString = simpleDateFormat.format(fechaHoy);
			
			Date fecha = DateUtils.formatDate(RequestVar.get("fecha_corte"), "dd/MM/yyyy"); 
			
			List<SqlRow> requipo = HistorialDeudaProveedores.getTotalesPorCorteFecha(true,fecha,true);
			for(SqlRow e : requipo) {
				
				totalCorte = totalCorte.add(e.getBigDecimal("total_deuda"));
				totalHoy = totalHoy.add(e.getBigDecimal("total"));
				
				totalCorteE = totalCorteE.add(e.getBigDecimal("total_deuda"));
				totalHoyE = totalHoyE.add(e.getBigDecimal("total"));
				
				
				//e.getBigDecimal("total_deuda_hoy");
				
			}
			
			List<SqlRow> rtotros = HistorialDeudaProveedores.getTotalesPorCorteFecha(true,fecha,false);
			for(SqlRow o : rtotros) {
				totalCorte = totalCorte.add(o.getBigDecimal("total_deuda"));
				totalHoy = totalHoy.add(o.getBigDecimal("total"));
				
				totalCorteO = totalCorteO.add(o.getBigDecimal("total_deuda"));
				
				totalHoyO = totalHoyO.add(o.getBigDecimal("total"));
				
			}
			totalDiferencia = totalCorte.subtract(totalHoy);
			totalDiferenciaE = totalCorteE.subtract(totalHoyE);
			totalDiferenciaO = totalCorteO.subtract(totalHoyO);
		}else {
			flash("error", "Debe Seleccionar una Fecha de Corte.");
		}
		
		
		return ok(deudaFotoPorFecha.render(formBuscador,fString,fechaHoyString,totalCorte,totalHoy,totalDiferencia
				,totalCorteE,totalHoyE,totalDiferenciaE
				,totalCorteO,totalHoyO,totalDiferenciaO));
	}	*/
	
	public static Result deudasGenerales() {
		
		
		
		 
		
		
		DynamicForm formBuscador = form().bindFromRequest();
		return ok(deudaGeneral.render(formBuscador));
	}	
	
	public static Result getDatosInformesDeudaAntiguedadInstitucion(){
		ObjectNode rpta = Json.newObject();
		ArrayNode results = rpta.arrayNode(); 
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		List<SqlRow> s = InformeDeudaPorActaMaterializada.getDeudaPorInstitucionPorAntiguedadPorEjercicioResumen(null);
		List<String> header = new ArrayList<String>();
		Map<String,Map<String,BigDecimal>> dat = new HashMap<String, Map<String,BigDecimal>>();
		ObjectNode restHeaderJs = Json.newObject();
		for(SqlRow sx : s) {
			if(!header.contains(sx.getString("deposito"))) {
					header.add(sx.getString("deposito"));
					restHeaderJs.put(sx.getString("deposito"), sx.getString("deposito"));
			}		
		}
		
		for(SqlRow sx : s) {
			
			
			//String[] fecha_mes_ano_array = sx.getString("fecha_mes_ano").split("/");
			//String fecha_mes_ano = fecha_mes_ano_array[1]+fecha_mes_ano_array[0];
			String fecha_mes_ano = sx.getString("fecha_ano");
					
			if(dat.containsKey(fecha_mes_ano)) {
				
				Map<String,BigDecimal> tmp = dat.get(fecha_mes_ano);
				
				tmp.put(sx.getString("deposito"), sx.getBigDecimal("total_deuda"));
				
				dat.put(fecha_mes_ano, tmp);
			}else {
				
				Map<String,BigDecimal> i = new HashMap<String,BigDecimal>();
				for(String insti : header) {
					i.put(insti, BigDecimal.ZERO);
				}
				i.put(sx.getString("deposito"), sx.getBigDecimal("total_deuda"));
				Map<String,BigDecimal> treeMapi = new TreeMap<String,BigDecimal>(i);
				dat.put(fecha_mes_ano, treeMapi);
			}
		}
		
		Map<String,Map<String,BigDecimal>> treeMap = new TreeMap<String,Map<String,BigDecimal>>(dat);
		ObjectNode restJs = (ObjectNode) Json.toJson(treeMap); 
		Logger.debug("11111111111 "+restJs); 
		Logger.debug("22222222222 "+restHeaderJs); 
		
		rpta.put("header", restHeaderJs);
		rpta.put("datos", restJs);
		rpta.put("success", true);
		 
		
		return ok(rpta);
	}
}
