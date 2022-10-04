package controllers.dashboard;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;


import models.Certificacion;
import models.CertificacionLinea;
import models.Estado;
import models.Factura;
import models.Organigrama;
import models.Pago;
import models.Proveedor;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.ExpressionList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NumberUtils;
import utils.RequestVar;
import views.html.dashboard.honorarios.*;
import views.html.dashboard.liquidaciones.liquidacionesPorPuesto;

@Security.Authenticated(Secured.class)
public class HonorariosController extends Controller {
	@CheckPermiso(key = "dashboardHonorarios")
	public static Result index() {
		return ok(indexHonorarios.render());
	}
	@CheckPermiso(key = "dashboardHonorarios")
	public static Result estadoDeuda() {
		return ok(estadoDeudaHonorarios.render());
	}
	
	@CheckPermiso(key = "dashboardHonorarios")
	public static Result estadoGeneralPorAgente() {
		DynamicForm formBuscador = form().bindFromRequest();
		return ok(estadoGeneralPorAgente.render(formBuscador,RequestVar.get("proveedor.id")));
	}
	
	
	@CheckPermiso(key = "dashboardLiquidacionesPorDepartamento")
	public static Result porDepartamento() {
		DynamicForm formBuscador = form().bindFromRequest();

		return ok(porDepartamento.render(formBuscador));		
/*

 */	
		
	}
	
	public static Result getHonorarioDepartamento() {
		ObjectNode obj = Json.newObject();
		

		Long periodo_id = null;
		String andWhere = "WHERE padre_id IS NULL ";
		if(!RequestVar.get("id").isEmpty()) {
			Long departamento_id = new Long(RequestVar.get("id"));
			andWhere = " where padre_id = " + departamento_id;
			Organigrama seleccionado = Organigrama.find.byId(departamento_id);
			obj.put("superior", seleccionado.padre_id);
			obj.put("nombreSuperior", seleccionado.nombre);
		}
		
		String andQuery = "";
		if(!RequestVar.get("periodo_id").isEmpty()) {
			periodo_id = new Long(RequestVar.get("periodo_id"));
			andQuery = " AND lm.periodo_id = " + periodo_id;
		}
		
		String sql = " WITH RECURSIVE recursetree(id, padre_id) AS ( " +
				 "    SELECT id, padre_id FROM organigramas WHERE padre_id = :departamentoId OR  id = :departamentoId" +
				 "  UNION " +
				 "    SELECT t.id, t.padre_id " +
				 "    FROM organigramas t " +
				 "    JOIN recursetree rt ON rt.id = t.padre_id " +
				 "  ) " +
				 " select SUM(cantidad * importe) importe, " +
				 " COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3 THEN cantidad * importe ELSE 0 END ),0) totalRetenciones, " +
				 " COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN cantidad * importe ELSE 0 END ),0) totalConAporte, " +
				 " COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN cantidad * importe ELSE 0 END ),0) totalSinAporte, " +
				 " COUNT(DISTINCT a.id) cantidadEmpleados from liquidacion_puestos lp " +
				 " inner join liquidacion_meses lm " +
				 " 	on  lm.id = lp.liquidacion_mes_id" +
				 " inner join liquidacion_detalles ld " +
				 " 	on lp.id = ld.liquidacion_puesto_id " +
				 " inner join liquidacion_conceptos lc " +
				 " 	on lc.id = ld.liquidacion_concepto_id " +
				 " inner join puestos_laborales pl " +
				 " 	on pl.id = lp.puesto_laboral_id " +
				 " inner join legajos l " +
				 " 	on l.id = pl.legajo_id " +
				 " inner join agentes a " +
				 " 	on a.id = l.agente_id " +
				 " where (lp.organigrama_id in (SELECT id FROM recursetree))" + andQuery;

		
		
		
		String s = "Select id, nombre from organigramas " + andWhere;
		List<SqlRow> dptos = Ebean.createSqlQuery(s).findList();
		

	    ArrayNode node2 = obj.arrayNode();


		for (SqlRow d : dptos) {
			
			SqlRow x = Ebean.createSqlQuery(sql).setParameter("departamentoId", d.getInteger("id")).setParameter("periodo", periodo_id).findUnique();
			
			
			ArrayNode a = obj.arrayNode();
			a.add( d.getString("nombre"));
			//a.add( (x.getDouble("importe")==null)?0:x.getDouble("importe") );
			
			ObjectNode o = Json.newObject();
			BigDecimal imp = (x.getBigDecimal("importe")==null)?new BigDecimal(0):x.getBigDecimal("importe");
			o.put("v", imp);
			o.put("f", NumberUtils.moneda(imp));
			a.add( o );
			
			a.add(d.getInteger("id"));
			
			ObjectNode t = Json.newObject();
			t.put("cantidadEmpleados", x.getInteger("cantidadEmpleados"));
			t.put("totalRetenciones", NumberUtils.moneda(x.getBigDecimal("totalRetenciones")));
			t.put("totalSinAporte", NumberUtils.moneda(x.getBigDecimal("totalSinAporte")));

			t.put("totalConAporte", NumberUtils.moneda(x.getBigDecimal("totalConAporte")));
			BigDecimal totalPatronales = x.getBigDecimal("totalConAporte").multiply(new BigDecimal(0.12));
			t.put("totalPatronales", NumberUtils.moneda( totalPatronales ));
			t.put("totalLiquidacion", NumberUtils.moneda(x.getBigDecimal("totalConAporte").add(x.getBigDecimal("totalSinAporte")).add(totalPatronales)  ));
			a.add( t );

			node2.add(a);
		}
		
		obj.put("result", node2);
		

		
		return ok(obj);
	}
	
	public static Result getAgentesTotalDepartamento() {
		
		ObjectNode res = Json.newObject();
		ObjectNode obj = Json.newObject();
		
		Long periodo_id = null;
		String andWhere = "WHERE padre_id IS NULL ";
		if(!RequestVar.get("id").isEmpty()) {
			Long departamento_id = new Long(RequestVar.get("id"));
			andWhere = " where padre_id = " + departamento_id + " OR id = " + departamento_id;
		}
		
		String andQuery = "";
		if(!RequestVar.get("periodo_id").isEmpty()) {
			periodo_id = new Long(RequestVar.get("periodo_id"));
			andQuery = " AND lm.periodo_id = " + periodo_id;
		}
		
		String sql = " WITH RECURSIVE recursetree(id, padre_id) AS ( " +
				 "    SELECT id, padre_id FROM organigramas " + andWhere + " " +
				 "  UNION " +
				 "    SELECT t.id, t.padre_id " +
				 "    FROM organigramas t " +
				 "    JOIN recursetree rt ON rt.id = t.padre_id " +
				 "  ) " +
				 " select a.id, a.apellido, o.nombre as organigrama " +
				 " from liquidacion_puestos lp " +
				 " inner join liquidacion_meses lm " +
				 " 	on  lm.id = lp.liquidacion_mes_id" +
				 " inner join liquidacion_detalles ld " +
				 " 	on lp.id = ld.liquidacion_puesto_id " +
				 " inner join liquidacion_conceptos lc " +
				 " 	on lc.id = ld.liquidacion_concepto_id " +
				 " inner join puestos_laborales pl " +
				 " 	on pl.id = lp.puesto_laboral_id " +
				 " inner join legajos l " +
				 " 	on l.id = pl.legajo_id " +
				 " inner join agentes a " +
				 " 	on a.id = l.agente_id " +
				 " inner join organigramas o " +
				 " on o.id = lp.organigrama_id " +
				 " where (lp.organigrama_id in (SELECT id FROM recursetree))" + andQuery + "" +
				 " group by a.id, o.nombre order by a.apellido ASC";	
		
		List<SqlRow> agentes = Ebean.createSqlQuery(sql).findList();
		
		
		ArrayNode node = obj.arrayNode();
		for (SqlRow a : agentes) {
			ObjectNode t = Json.newObject();
			t.put("id", a.getString("id"));
			t.put("agente", a.getString("apellido"));
			t.put("nombre", a.getString("organigrama"));
			node.add(t);
		}
		res.put("result", node);
		return ok( res );
	}
	
	public static Result getEstadoDeudaGeneral() throws JsonProcessingException, IOException {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    response.put("results", results);
	    if(request().body().asFormUrlEncoded().get("proveedorId") != null && request().body().asFormUrlEncoded().get("proveedorId")[0] !=null && !request().body().asFormUrlEncoded().get("proveedorId")[0].isEmpty()){
	    	Long proveedorId = new Long(request().body().asFormUrlEncoded().get("proveedorId")[0]) ;
	    	
	    	Map<String,BigDecimal> ret = getEstadoDeudaDatosGeneral(proveedorId);
	    	
	    	ObjectMapper mapper = new ObjectMapper();
	    	String json = mapper.writeValueAsString(ret);
	    	JsonNode rootNode = mapper.readTree(json);
	    	
	    	response.put("results", (ObjectNode) rootNode);
	    }
	    
	    return ok(response);
	}
	
	public static Result getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo() throws JsonProcessingException, IOException {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    response.put("results", results);
	    if(request().body().asFormUrlEncoded().get("proveedorId") != null && request().body().asFormUrlEncoded().get("proveedorId")[0] !=null && !request().body().asFormUrlEncoded().get("proveedorId")[0].isEmpty()){
	    	Long proveedorId = new Long(request().body().asFormUrlEncoded().get("proveedorId")[0]) ;
	    	
	    	Map<String,Map<String,Map<String,BigDecimal>>> ret = getEstadoDeudaDatosEstadoGeneralPorAgenteEstadoPeriodo(proveedorId);
	    	
	    	ObjectMapper mapper = new ObjectMapper();
	    	String json = mapper.writeValueAsString(ret);
	    	JsonNode rootNode = mapper.readTree(json);
	    	
	    	response.put("results", (ObjectNode) rootNode);
	    }
	    
	    return ok(response);
	}
	
	public static Result getDatosEstadoGeneralPorAgente(){
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    
	    if(request().body().asFormUrlEncoded().get("proveedorId") != null && request().body().asFormUrlEncoded().get("proveedorId")[0] !=null && !request().body().asFormUrlEncoded().get("proveedorId")[0].isEmpty()){ 
	    	
	    	Proveedor p = Proveedor.find.byId(new Long(request().body().asFormUrlEncoded().get("proveedorId")[0]));
	    	ObjectNode restJs = Json.newObject();
    		restJs.put("nombre",p.agente.apellido);
    		
    		String relacion = (p.agente.planta == null)?"Sin informacion":(p.agente.planta == true)?"Planta":"Contratado";
    		restJs.put("relacion",relacion);
    		restJs.put("cuit",p.cuit);
    		results.add(restJs);
	    }
	    
	    ObjectNode response = Json.newObject();
		response.put("results", results);
		
		return ok(response);
	}
	
	public static Result getFacturacionEstadoGeneralPorAgente(){
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    if(request().body().asFormUrlEncoded().get("proveedorId") != null && request().body().asFormUrlEncoded().get("proveedorId")[0] !=null && !request().body().asFormUrlEncoded().get("proveedorId")[0].isEmpty()){
	    	List<Factura> fl = Factura.
	    			find.where().
	    			eq("proveedor_id",new Long(request().body().asFormUrlEncoded().get("proveedorId")[0]))
	    			.orderBy("id desc")
	    			.findList();
	    	
	    	BigDecimal totalBase = new BigDecimal(0);
    		BigDecimal totalImpuestos = new BigDecimal(0);
    		BigDecimal totalTotal = new BigDecimal(0);
    		BigDecimal totalSaldo = new BigDecimal(0);
    		
	    	for (Factura f : fl) {
	    		ObjectNode restJs = Json.newObject();
	    		restJs.put("id",f.id);
	    		restJs.put("referencia",f.nombre);
	    		restJs.put("OP",(f.ordenPago != null)?f.ordenPago.numero.toString():"");
	    		restJs.put("numero",(f.numero_factura != null)?f.numero_factura:"");
	    		restJs.put("expediente",f.expediente.getExpedienteEjercicio());
	    		restJs.put("periodo",f.periodo.nombre);
	    		restJs.put("profe",(f.profe)?"SI":"NO");
	    		restJs.put("base",(f.base != null)?(utils.NumberUtils.moneda(f.base)):utils.NumberUtils.moneda(new BigDecimal(0)));
	    		restJs.put("impuestos",utils.NumberUtils.moneda(f.getTotalImpuesto()));
	    		restJs.put("total",utils.NumberUtils.moneda(f.getTotal()));
	    		restJs.put("saldo",utils.NumberUtils.moneda(f.getSaldoPendiente()));
	    		
	    		totalBase = totalBase.add(f.base);
	    		totalImpuestos = totalImpuestos.add(f.getTotalImpuesto());
	    		totalTotal = totalTotal.add(f.getTotal());
	    		totalSaldo = totalSaldo.add(f.getSaldoPendiente());
	    		
	    		String classEstado = "";
	    		String nombreEstado = f.estado.nombre;
	    		if(!f.getSaldoPendiente().equals(f.base) && f.estado != null && f.estado_id == Estado.FACTURA_ESTADO_APROBADO){
	    			classEstado = "pagado";
	    			nombreEstado = "Pagado";
	    		}else{
	    			if(f.estado != null && f.estado.id == Estado.FACTURA_ESTADO_BORRADOR){
	    				classEstado = "borrador";
	    			}else if(f.estado != null && f.estado.id == Estado.FACTURA_ESTADO_CANCELADO){
	    				classEstado = "cancelada";
	    			}else if(f.estado != null && f.estado.id == Estado.FACTURA_ESTADO_APROBADO){
	    				classEstado = "autorizado";
	    			}
	    		}
	    		
	    		String porcentaje = "";
	    		BigDecimal cien = new BigDecimal(100);
	    		if(f.estado != null && f.estado.id == 19){
	    			if(f.getSaldoPendiente().compareTo(java.math.BigDecimal.ZERO) != 0 && f.base.compareTo(java.math.BigDecimal.ZERO) != 0){
	    				porcentaje = (f.base.subtract(f.getSaldoPendiente())).multiply(cien).divide(f.base, 2, java.math.RoundingMode.HALF_UP).toString();
	    			}else{
	    				porcentaje = new BigDecimal(0).toString();
	    			}
	    			porcentaje = (f.base.subtract(f.getSaldoPendiente())).multiply(cien).divide(f.base, 2, java.math.RoundingMode.HALF_UP).toString();
	    			nombreEstado += " "+porcentaje+"%";  
	    		}
	    		
	    		restJs.put("estado",nombreEstado);
	    		restJs.put("estadoSignificado",f.estado.significado);
	    		restJs.put("classEstado",classEstado);
	    		
	    		results.add(restJs);
	    	}	
	    	
	    	response.put("totalBase", utils.NumberUtils.moneda(totalBase));
	    	response.put("totalImpuestos", utils.NumberUtils.moneda(totalImpuestos));
	    	response.put("totalTotal", utils.NumberUtils.moneda(totalTotal));
	    	response.put("totalSaldo", utils.NumberUtils.moneda(totalSaldo));
	    }
	    
	    response.put("results", results);
		return ok(response);
	}
	
	public static Result getPagosEstadoGeneralPorAgente(){
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    if(request().body().asFormUrlEncoded().get("proveedorId") != null && request().body().asFormUrlEncoded().get("proveedorId")[0] !=null && !request().body().asFormUrlEncoded().get("proveedorId")[0].isEmpty()){
	    	List<Pago> pl = Pago.
	    			find.where().
	    			eq("proveedor_id",new Long(request().body().asFormUrlEncoded().get("proveedorId")[0]))
	    			.orderBy("fecha_pago desc")
	    			.findList();
	    	
	    	BigDecimal totalTotal = new BigDecimal(0);
	    	for (Pago p : pl) {
	    		ObjectNode restJs = Json.newObject();
	    		restJs.put("id",p.id);
	    		restJs.put("fecha",utils.DateUtils.formatDate(p.fecha_pago));
	    		restJs.put("referencia",p.referencia);
	    		restJs.put("op",(p.ordenPago != null)?p.ordenPago.numero.toString():"");
	    		restJs.put("expediente",p.expediente.getExpedienteEjercicio());
	    		restJs.put("periodo",p.periodo.nombre);
	    		restJs.put("profe",(p.profe)?"SI":"NO");
	    		restJs.put("total",utils.NumberUtils.moneda(p.total));
	    		restJs.put("estado",p.estado.nombre);
	    		restJs.put("estadoSignificado",p.estado.significado);
	    		
	    		String classEstado = "";
	    		if(p.estado != null && p.estado.id == Estado.PAGO_ESTADO_BORRADOR){
	    			classEstado = "borrador";
	    		}else if(p.estado != null && p.estado.id == Estado.PAGO_ESTADO_CANCELADO){
	    			classEstado = "cancelada";
	    		}else if(p.estado != null && p.estado.id == Estado.PAGO_ESTADO_CONCILIADO){
	    			classEstado = "autorizado";
	    		}
	    		
	    		totalTotal = totalTotal.add(p.total);
	    		restJs.put("classEstado",classEstado);
	    		
	    		results.add(restJs);
	    	}	
	    	
	    	response.put("totalTotal", utils.NumberUtils.moneda(totalTotal));
	    }
	 
		    
	    response.put("results", results);
		return ok(response);
	}
	
	public static Result getCertificacionesEstadoGeneralPorAgente() throws IOException{
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    if(request().body().asFormUrlEncoded().get("proveedorId") != null && request().body().asFormUrlEncoded().get("proveedorId")[0] !=null && !request().body().asFormUrlEncoded().get("proveedorId")[0].isEmpty()){
	    	
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
	    		restJs.put("id",certificacion.id);
	    		restJs.put("referencia",certificacion.nombre);
	    		restJs.put("fecha",utils.DateUtils.formatDate(certificacion.fecha_certificacion));
	    		restJs.put("expediente",certificacion.expediente.getExpedienteEjercicio());
	    		restJs.put("periodo",certificacion.periodo.nombre);
	    		restJs.put("profe",(certificacion.profe)?"SI":"NO");
	    		restJs.put("base",utils.NumberUtils.moneda(certificacion.getBase()));
	    		restJs.put("descuento",utils.NumberUtils.moneda(certificacion.getDescuento()));
	    		restJs.put("total",utils.NumberUtils.moneda(certificacion.getTotal()));
	    		restJs.put("estado",certificacion.estado.nombre);
	    		restJs.put("estadoSignificado",certificacion.estado.significado);
	    		
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
	    		
	    		base  = base.add(certificacion.getBase());
	    		descuento = descuento.add(certificacion.getDescuento());
	    		total = total.add(certificacion.getTotal());
	    		
	    		results.add(restJs);
			}
    		
	    	response.put("base", utils.NumberUtils.moneda(base));
	    	response.put("descuento", utils.NumberUtils.moneda(descuento));
	    	response.put("total", utils.NumberUtils.moneda(total));
	    	
    	}
	    
	    response.put("results", results);
		return ok(response);
	}
	
	public static Result getDataEstadoDeudaPagadosPorEjercicio() throws IOException {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    
	    if(request().body().asFormUrlEncoded().get("idEjercicio") != null){ 
	    	Integer idEjercicio = new Integer(request().body().asFormUrlEncoded().get("idEjercicio")[0]) ;
	    	List<SqlRow> x = Factura.getDataEstadoDeudaPagadosPorEjercicio(idEjercicio);
	    	
	    	for(SqlRow s : x){
	    		ObjectNode restJs = Json.newObject();
	    		restJs.put("apellido",s.getString("apellido"));
		        restJs.put("expediente", s.getString("expediente"));
		        restJs.put("total",s.getBigDecimal("total"));
		        results.add(restJs);
	    	}
	    }
	    
	    ObjectNode response = Json.newObject();
		response.put("results", results);
	    
	    return ok(response);
	}
	
	public static Result getDataEstadoDeudaNoPagadosPorEjercicio() throws IOException {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	     
	    if(request().body().asFormUrlEncoded().get("idEjercicio") != null){ 
	    	Integer idEjercicio = new Integer(request().body().asFormUrlEncoded().get("idEjercicio")[0]) ;
	    	List<SqlRow> x = Factura.getDataEstadoDeudaNoPagadosPorEjercicio(idEjercicio);
	    	for(SqlRow s : x){
	    		ObjectNode restJs = Json.newObject();
	    		restJs.put("apellido",s.getString("apellido"));
		        restJs.put("expediente", s.getString("expediente"));
		        restJs.put("total",s.getBigDecimal("total"));
		        results.add(restJs);
	    	}
	    }
	    
	    ObjectNode response = Json.newObject();
		response.put("results", results);
	    
	    return ok(response);
	}
	
	public static Result getEstadoDeudaPorEjercicio() {
		
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode restJs = Json.newObject();
        
	    if(request().body().asFormUrlEncoded().get("idEjercicio") != null){ 
			
	        Integer idEjercicio = new Integer(request().body().asFormUrlEncoded().get("idEjercicio")[0]) ;
	        BigDecimal p =  getFacturasPagadasHonorariosPorEjercicio(idEjercicio);
	        BigDecimal np = getFacturasNoPagadasHonorariosPorEjercicio(idEjercicio);
		    restJs.put("pagados", p);
	        restJs.put("noPagados",np);
	        
	        results.add(restJs);
		}
	    
	    ObjectNode response = Json.newObject();
		response.put("results", results);
		 
		return ok(response);
	}
	
	public static Result getEstadoDeudaPorPeriodo() throws JsonProcessingException, IOException {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();
	    response.put("results", results);
	    if(request().body().asFormUrlEncoded().get("idEjercicio") != null){ 
	    	Integer idEjercicio = new Integer(request().body().asFormUrlEncoded().get("idEjercicio")[0]) ;
	    	
	    	Map<String,Map<String,BigDecimal>> ret = getFacturasPagadasHonorariosPorPeriodo(idEjercicio);
	    	
	    	ObjectMapper mapper = new ObjectMapper();
	    	String json = mapper.writeValueAsString(ret);
	    	JsonNode rootNode = mapper.readTree(json);
	    	
	    	response.put("results", (ObjectNode) rootNode);
	    }
	    
	    return ok(response);
	}
	
	public static BigDecimal getFacturasPagadasHonorariosPorEjercicio(Integer idEjercicio){
		BigDecimal retTotal =  Factura.getTotalFacturasPagadasHonorariosPorEjercicio(idEjercicio);
		BigDecimal retImpuestos = Factura.getTotalImpuestosFacturasPagadasHonorariosPorEjercicio(idEjercicio);
		
		BigDecimal ret = retTotal.subtract(retImpuestos);
		return ret;
	}
	
	public static BigDecimal getFacturasNoPagadasHonorariosPorEjercicio(Integer idEjercicio){
		BigDecimal retTotal =  Factura.getTotalFacturasNoPagadasHonorariosPorEjercicio(idEjercicio);
		BigDecimal retTotalImpuestos =  Factura.getTotalImpuestosFacturasNoPagadasHonorariosPorEjercicio(idEjercicio);
		
		BigDecimal ret = retTotal.subtract(retTotalImpuestos);
		
		return ret;
	}
	
	public static Map<String,Map<String,BigDecimal>> getFacturasPagadasHonorariosPorPeriodo(Integer idEjercicio){
		Map<String,BigDecimal> retTotalPagados =  Factura.getTotalFacturasPagadasHonorariosPorPeriodo(idEjercicio);
		Map<String,BigDecimal> retImpuestosPagados = Factura.getTotalImpuestosFacturasPagadasHonorariosPorPeriodo(idEjercicio);
		Map<String,BigDecimal> retTotalNoPagados =  Factura.getTotalFacturasNoPagadasHonorariosPorPeriodo(idEjercicio);
		Map<String,BigDecimal> retImpuestosNoPagados = Factura.getTotalImpuestosFacturasNoPagadasHonorariosPorPeriodo(idEjercicio);
		
		Map<String,Map<String,BigDecimal>> ret = new HashMap<String,Map<String,BigDecimal>>();
		
		for (Entry<String,BigDecimal> e: retTotalPagados.entrySet()) {
			BigDecimal subTotal = e.getValue();
			if(retImpuestosPagados.containsKey(e.getKey())){
				BigDecimal i = retImpuestosPagados.get(e.getKey());
				BigDecimal t = e.getValue();
				//subTotal = t.subtract(i);
			}
			Map<String,BigDecimal> hTmp= new HashMap<String,BigDecimal>();
			hTmp.put("pagados", subTotal);
			ret.put(e.getKey(), hTmp);
		}
		
		for (Entry<String,BigDecimal> x: retTotalNoPagados.entrySet()) {
			BigDecimal subTotalNoPagado = x.getValue();
			if(retImpuestosNoPagados.containsKey(x.getKey())){
				BigDecimal i = retImpuestosNoPagados.get(x.getKey());
				BigDecimal t = x.getValue();
				//subTotalNoPagado = t.subtract(i);
			}
			
			if(ret.containsKey(x.getKey())){
				ret.get(x.getKey()).put("no pagados", subTotalNoPagado);
			}else{
				Map<String,BigDecimal> hTmp2= new HashMap<String,BigDecimal>();
				hTmp2.put("pagados",new BigDecimal(0));
				hTmp2.put("no pagados",subTotalNoPagado);
				ret.put(x.getKey(), hTmp2);
			}
		}
		Map<String,Map<String,BigDecimal>> sortedMap = new TreeMap<String,Map<String,BigDecimal>>(ret);
		 
		return sortedMap;
	}
	
	public static Result getDataEstadoDeudaPagadosPorPeriodo() throws IOException {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    
	    if(request().body().asFormUrlEncoded().get("idEjercicio") != null){ 
	    	Integer idEjercicio = new Integer(request().body().asFormUrlEncoded().get("idEjercicio")[0]) ;
	    																	
	    	String nombrePeriodo = request().body().asFormUrlEncoded().get("nombrePeriodo")[0] ;
	    	
	    	
	    	List<SqlRow> x = Factura.getDataEstadoDeudaPagadosPorPeriodo(idEjercicio,nombrePeriodo);
	    	
	    	for(SqlRow s : x){
	    		ObjectNode restJs = Json.newObject();
	    		restJs.put("apellido",s.getString("apellido"));
		        restJs.put("expediente", s.getString("expediente"));
		        restJs.put("total",s.getBigDecimal("total"));
		        results.add(restJs);
	    	}
	    }
	    
	    ObjectNode response = Json.newObject();
		response.put("results", results);
	    
	    return ok(response);
	}
	
	public static Result getDataEstadoDeudaNoPagadosPorPeriodo() throws IOException {
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	     
	    if(request().body().asFormUrlEncoded().get("idEjercicio") != null){ 
	    	Integer idEjercicio = new Integer(request().body().asFormUrlEncoded().get("idEjercicio")[0]) ;
	    	String nombrePeriodo = request().body().asFormUrlEncoded().get("nombrePeriodo")[0] ;
	    	List<SqlRow> x = Factura.getDataEstadoDeudaNoPagadosPorPeriodo(idEjercicio,nombrePeriodo);
	    	for(SqlRow s : x){
	    		ObjectNode restJs = Json.newObject();
	    		restJs.put("apellido",s.getString("apellido"));
		        restJs.put("expediente", s.getString("expediente"));
		        restJs.put("total",s.getBigDecimal("total"));
		        results.add(restJs);
	    	}
	    }
	    
	    ObjectNode response = Json.newObject();
		response.put("results", results);
	    
	    return ok(response);
	}
	
	public static Map<String,BigDecimal> getEstadoDeudaDatosGeneral(Long proveedorId){
		Map<String,BigDecimal> retDeuda = new HashMap<String,BigDecimal>();
		
		if(proveedorId != null){ 
			
		}
		
		return retDeuda;
	}
	
	public static  Map<String,Map<String,Map<String,BigDecimal>>> getEstadoDeudaDatosEstadoGeneralPorAgenteEstadoPeriodo(Long proveedorId){
		
	    Map<String,Map<String,Map<String,BigDecimal>>> hashReturn= new HashMap<String,Map<String,Map<String,BigDecimal>>>();
	    Map<String,Map<String,BigDecimal>> retCertificaciones = new HashMap<String,Map<String,BigDecimal>>();
	    Map<String,Map<String,BigDecimal>> retFacturas = new HashMap<String,Map<String,BigDecimal>>();
	    Map<String,Map<String,BigDecimal>> retDeuda = new HashMap<String,Map<String,BigDecimal>>();
	    Map<String,Map<String,BigDecimal>> retDatos = new HashMap<String,Map<String,BigDecimal>>();
	    
	    if(proveedorId != null){ 
	    	
	    	String sql = "SELECT c.periodo_id,p.nombre periodoNombre,state_id estadoId,e.nombre estadoNombre,e.descripcion estadoDescripcion, "+ 
									"SUM((cl.cantidad*cl.precio) - COALESCE(ROUND((cl.precio*cl.descuento)/100),0) ) total "+
									"FROM certificaciones c "+
									"INNER JOIN periodos p ON p.id = c.periodo_id "+  
									"INNER JOIN certificaciones_lineas cl ON c.id = cl.certificacion_id "+ 
									"INNER JOIN estados e on e.id = c.state_id "+  
									"WHERE proveedor_id = :proveedorId "+
									"GROUP BY c.periodo_id,p.nombre,state_id,e.nombre,e.descripcion "+
						"UNION "+
							"SELECT f.periodo_id,p.nombre periodoNombre,state_id estadoId,e.nombre estadoNombre,e.descripcion estadoDescripcion, "+  
									 "SUM((fl.cantidad*fl.precio) - NULLIF(0, fli.monto)) total "+  
									 "FROM facturas f "+
									 "INNER JOIN periodos p ON p.id = f.periodo_id "+ 
									 "INNER JOIN factura_lineas fl ON f.id = fl.factura_id "+ 
									 "LEFT JOIN factura_linea_impuestos fli ON f.id = fli.factura_id "+
									 "INNER JOIN estados e ON e.id = f.state_id "+	 
									 "WHERE f.proveedor_id = :proveedorId "+
									 "GROUP BY f.periodo_id,p.nombre,f.state_id,e.nombre,e.descripcion "+
						"UNION "+
							"SELECT f.periodo_id,p.nombre periodoNombre,state_id estadoId,e.nombre estadoNombre,e.descripcion estadoDescripcion, "+
									 "SUM(COALESCE(fl.monto,0)-COALESCE(fl.monto_credito,0)) total "+  
									 "FROM pagos f "+ 
									 "INNER JOIN periodos p ON p.id = f.periodo_id "+
									 "INNER JOIN pagos_lineas fl ON f.id = fl.pago_id "+
									 "INNER JOIN estados e ON e.id = f.state_id "+	 
									 "WHERE f.proveedor_id = :proveedorId "+
									 "GROUP BY f.periodo_id,p.nombre,f.state_id,e.nombre,e.descripcion ";
	    			
	    			List<SqlRow> x = Ebean.createSqlQuery(sql)
	    					.setParameter("proveedorId",proveedorId)	
	    					.setParameter("proveedorId",proveedorId)	
	    					.setParameter("proveedorId",proveedorId)	
	    					.findList();
			
	    	hashReturn.put("Certificaciones", new HashMap<String,Map<String,BigDecimal>>());
    		hashReturn.put("Facturas", new HashMap<String,Map<String,BigDecimal>>());
    		hashReturn.put("Deuda", new HashMap<String,Map<String,BigDecimal>>());
    		hashReturn.put("DeudasGenerales", new HashMap<String,Map<String,BigDecimal>>());
    		
	    	for(SqlRow s : x){
	    		
	    		//Certificaciones
	    		if(s.getString("estadoDescripcion").compareToIgnoreCase("certificacion") == 0){
	    			
	    			if(s.getInteger("estadoId").equals(Estado.CERTIFICACION_ESTADO_IMPUTADO) || s.getInteger("estadoId").equals(Estado.CERTIFICACION_ESTADO_CERTIFICADO)){
		    			if(!retCertificaciones.containsKey(s.getString("periodoNombre"))){
			    			Map<String,BigDecimal> hTmp= new HashMap<String,BigDecimal>();
				    		hTmp.put("Certificado", new BigDecimal(0));
				    		hTmp.put("Aprobado", new BigDecimal(0));
				    		retCertificaciones.put(s.getString("periodoNombre"), hTmp);
			    		}
			    		
		    			Map<String,BigDecimal> hTmp2 = retCertificaciones.get(s.getString("periodoNombre"));
			    		BigDecimal tTmp = hTmp2.get(s.getString("estadoNombre"));
			    		BigDecimal tTmp2 = tTmp.add(s.getBigDecimal("total"));   
			    		hTmp2.put(s.getString("estadoNombre"), tTmp2);
			    		retCertificaciones.put(s.getString("periodoNombre"), hTmp2);
			    	}
	    		}
	    		
	    		//Facturacion
	    		if(s.getString("estadoDescripcion").compareToIgnoreCase("factura") == 0){
		    		
	    			if(!s.getInteger("estadoId").equals(Estado.FACTURA_ESTADO_CANCELADO)){
		    			
		    			String estado = "Esperando";
			    		if(s.getInteger("estadoId").equals(Estado.FACTURA_ESTADO_APROBADO)){
			    			estado = "Aprobado";
			    		}
			    		
			    		if(!retFacturas.containsKey(s.getString("periodoNombre"))){
			    			Map<String,BigDecimal> hTmp= new HashMap<String,BigDecimal>();
				    		hTmp.put("Esperando", new BigDecimal(0));
				    		hTmp.put("Aprobado", new BigDecimal(0));
				    		retFacturas.put(s.getString("periodoNombre"), hTmp);
			    		}
			    		
			    		Map<String,BigDecimal> hTmp2 = retFacturas.get(s.getString("periodoNombre"));
			    		BigDecimal tTmp = hTmp2.get(estado);
			    		BigDecimal tTmp2 = tTmp.add(s.getBigDecimal("total")); 
			    		hTmp2.put(estado, tTmp2);
			    		retFacturas.put(s.getString("periodoNombre"), hTmp2);
			    	}
	    		}
	    		
	    		//Deuda
	    		if(!s.getInteger("estadoId").equals(Estado.CERTIFICACION_ESTADO_CANCELADO) 
	    				&& !s.getInteger("estadoId").equals(Estado.CERTIFICACION_ESTADO_IMPUTADO) 
	    				&& !s.getInteger("estadoId").equals(Estado.FACTURA_ESTADO_CANCELADO) 
	    				&& !s.getInteger("estadoId").equals(Estado.FACTURA_ESTADO_APROBADO)
	    				&& !s.getInteger("estadoId").equals(Estado.PAGO_ESTADO_CANCELADO)){
	    			
	    			String estado = "NoPagado";
		    		if(s.getInteger("estadoId").equals(Estado.PAGO_ESTADO_PAGADO) || s.getInteger("estadoId").equals(Estado.PAGO_ESTADO_CONCILIADO) || s.getInteger("estadoId").equals(Estado.PAGO_ESTADO_EN_CURSO)){
		    			estado = "Pagado";
		    		}
		    		
		    		if(!retDeuda.containsKey(s.getString("periodoNombre"))){
		    			Map<String,BigDecimal> hTmp= new HashMap<String,BigDecimal>();
			    		hTmp.put("NoPagado", new BigDecimal(0));
			    		hTmp.put("Pagado", new BigDecimal(0));
			    		retDeuda.put(s.getString("periodoNombre"), hTmp);
		    		}
		    		
		    		Map<String,BigDecimal> hTmp2 = retDeuda.get(s.getString("periodoNombre"));
		    		BigDecimal tTmp = hTmp2.get(estado);
		    		BigDecimal tTmp2 = tTmp.add(s.getBigDecimal("total")); 
		    		hTmp2.put(estado, tTmp2);
		    		retDeuda.put(s.getString("periodoNombre"), hTmp2);
		    	}
	    		
	    		//Deuda General
	    		if(!isCancelado(s)){
	    			String estado = "";
		    		if(isDeuda(s)){
		    			estado = "DeudaTotal";
		    		}else if(isDeudaExigible(s)){
		    			estado = "DeudaExigible";
		    		}else if(isPagado(s)){
		    			estado = "Pagado";
		    		}
		    		
		    		if(!retDatos.containsKey("datos")){
		    			Map<String,BigDecimal> dtoTmp= new HashMap<String,BigDecimal>();
		    			dtoTmp.put("DeudaTotal", new BigDecimal(0));
		    			dtoTmp.put("DeudaExigible", new BigDecimal(0));
		    			dtoTmp.put("Pagado", new BigDecimal(0));
		    			retDatos.put("datos", dtoTmp);
		    		}
		    		
		    		Map<String,BigDecimal> hTmp3 = retDatos.get("datos");
		    		if(!hTmp3.containsKey(estado)){
		    			hTmp3.put(estado, new BigDecimal(0));
		    		}
		    		
		    		BigDecimal tTmp = hTmp3.get(estado);
		    		BigDecimal tTmp2 = tTmp.add(s.getBigDecimal("total"));
		    		
		    		hTmp3.put(estado, tTmp2);
		    		retDatos.put("datos", hTmp3);
		    		
	    		}
	    	}
	    	
	    	Map<String,Map<String,BigDecimal>> sortedMapCert = new TreeMap<String,Map<String,BigDecimal>>(retCertificaciones);
    		hashReturn.put("Certificaciones", sortedMapCert);
    		Map<String,Map<String,BigDecimal>> sortedMapFact = new TreeMap<String,Map<String,BigDecimal>>(retFacturas);
    		hashReturn.put("Facturas", sortedMapFact);
    		Map<String,Map<String,BigDecimal>> sortedMapDeuda = new TreeMap<String,Map<String,BigDecimal>>(retDeuda);
    		hashReturn.put("Deuda", sortedMapDeuda);
    		hashReturn.put("DeudasGenerales", retDatos);
	    }
	    
	    return hashReturn;
	}
	
	public static boolean isCancelado(SqlRow s){
		boolean ret = false;
		Integer eId = s.getInteger("estadoId");
		if(eId.equals(Estado.CERTIFICACION_ESTADO_CANCELADO) || eId.equals(Estado.FACTURA_ESTADO_CANCELADO) ||	eId.equals(Estado.PAGO_ESTADO_CANCELADO)){
			ret = true;
		}
		
		return ret;
	}
	
	public static boolean isDeudaExigible(SqlRow s){
		boolean ret = false;
		String eDesc = s.getString("estadoDescripcion");
		Integer eId = s.getInteger("estadoId");
		
		if(eId.equals(Estado.PAGO_ESTADO_BORRADOR)){
			ret = true;
		}
		
		return ret;
	}
	
	public static boolean isPagado(SqlRow s){
		boolean ret = false;
		String eDesc = s.getString("estadoDescripcion");
		Integer eId = s.getInteger("estadoId");
		
		if(eId.equals(Estado.PAGO_ESTADO_PAGADO) || eId.equals(Estado.PAGO_ESTADO_CONCILIADO) || eId.equals(Estado.PAGO_ESTADO_EN_CURSO)){
			ret = true;
		}
		
		return ret;
	}
	
	public static boolean isDeuda(SqlRow s){
		boolean ret = false;
		String eDesc = s.getString("estadoDescripcion");
		Integer eId = s.getInteger("estadoId");
		
		if(eDesc.compareToIgnoreCase("factura") == 0){
			if(!eId.equals(Estado.FACTURA_ESTADO_APROBADO)){
				ret = true;
			}
		}
		if(eId.equals(Estado.CERTIFICACION_ESTADO_CERTIFICADO)){
			ret = true;
		}
		
		if(eId.equals(Estado.PAGO_ESTADO_BORRADOR)){
			ret = true;
		}
			
		return ret;
	}
	
	public static List<Factura> estadoDeudaMonotributoFacturas(boolean profe) {
		ExpressionList<Factura> f = Factura.find
			    .fetch("proveedor") 
			    .fetch("expediente")
			    .fetch("periodo")
				.where();
				
				if(profe){
					f.eq("profe",true);
				}else{
					f = f.disjunction();
					f = f.eq("profe",false);
					f = f.isNull("profe");
					f = f.endJunction();
				}
				
				f.eq("certificacion.estado_id", Estado.CERTIFICACION_ESTADO_IMPUTADO);
				f.ne("estado_id",Estado.FACTURA_ESTADO_CANCELADO);
				
				f = f.disjunction();
				f = f.ne("parcial",true);
				f = f.isNull("parcial");
				f = f.endJunction();
				
				f = f.disjunction();
				f = f.eq("total_pagado", 0);
				f = f.isNull("total_pagado");
				f = f.endJunction();
				
				f.orderBy("expediente.nombre,proveedor.nombre");
				
		
		return f.findList();
	}
	
	@CheckPermiso(key = "dashboardHonorarios")
	public static Result estadoDeudaMonotributo() {
		return estadoDeudaMonotributoTodos(false);
	}
	
	@CheckPermiso(key = "dashboardHonorarios")
	public static Result estadoDeudaMonotributoProfe() {
		return estadoDeudaMonotributoTodos(true);
	}
	
	@CheckPermiso(key = "dashboardHonorarios")
	public static Result estadoDeudaMonotributoExcel() {
		return estadoDeudaMonotributoExcelTodos(false);
	}
	
	@CheckPermiso(key = "dashboardHonorarios")
	public static Result estadoDeudaMonotributoExcelProfe() {
		return estadoDeudaMonotributoExcelTodos(true);
	}
	
	public static Result estadoDeudaMonotributoTodos(boolean profe) {
		TreeMap<Long,List<Factura>> retPeriodoFactura = new TreeMap<Long,List<Factura>>();
		Map<Long,String> periodo = new HashMap<Long,String>();
		Map<Long,BigDecimal> totalPeriodo = new HashMap<Long,BigDecimal>();
		Map<Long,BigDecimal> totalImpuestoPeriodo = new HashMap<Long,BigDecimal>();
		Map<Long,BigDecimal> totalNetoPeriodo = new HashMap<Long,BigDecimal>();
		BigDecimal total = new BigDecimal(0);
		BigDecimal totalImpuesto = new BigDecimal(0);
		BigDecimal totalNeto = new BigDecimal(0);
		
		for(Factura fx : estadoDeudaMonotributoFacturas(profe)){
			boolean cargar = true;
			if(cargar){
				
				periodo.put(fx.periodo.id, fx.periodo.nombre);
				total = total.add(fx.getBase());
				totalImpuesto = totalImpuesto.add(fx.getTotalImpuesto());
				totalNeto = totalNeto.add(fx.getTotal());
				if(retPeriodoFactura.containsKey(fx.periodo.id)){
					List<Factura> ft = retPeriodoFactura.get(fx.periodo.id);
					ft.add(fx);
					retPeriodoFactura.put(fx.periodo.id, ft);
					BigDecimal tmp = totalPeriodo.get(fx.periodo.id);
					BigDecimal tmpi = totalImpuestoPeriodo.get(fx.periodo.id);
					BigDecimal tmpn = totalNetoPeriodo.get(fx.periodo.id);
					tmp = tmp.add(fx.getBase());
					tmpi = tmpi.add(fx.getTotalImpuesto());
					tmpn = tmpn.add(fx.getTotal());
					totalPeriodo.put(fx.periodo.id, tmp);		
					totalImpuestoPeriodo.put(fx.periodo.id, tmpi);
					totalNetoPeriodo.put(fx.periodo.id, tmpn);
					
				}else{
					List<Factura> ft = new ArrayList<Factura>();
					ft.add(fx);
					retPeriodoFactura.put(fx.periodo.id, ft);
					
					totalPeriodo.put(fx.periodo.id, fx.getBase());
					totalImpuestoPeriodo.put(fx.periodo.id, fx.getTotalImpuesto());
					totalNetoPeriodo.put(fx.periodo.id, fx.getTotal());
				}
			}
		}
		
		return ok(estadoDeudaMonotributo.render(retPeriodoFactura,periodo,totalPeriodo,totalImpuestoPeriodo,totalNetoPeriodo,total,totalImpuesto,totalNeto));
	}
	
	
	public static Result estadoDeudaMonotributoExcelTodos(boolean profe) {
		TreeMap<Long,List<Factura>> retPeriodoFactura = new TreeMap<Long,List<Factura>>();
		Map<Long,String> periodo = new HashMap<Long,String>();
		Map<Long,BigDecimal> totalPeriodo = new HashMap<Long,BigDecimal>();
		Map<Long,BigDecimal> totalImpuestoPeriodo = new HashMap<Long,BigDecimal>();
		Map<Long,BigDecimal> totalNetoPeriodo = new HashMap<Long,BigDecimal>();
		BigDecimal total = new BigDecimal(0);
		BigDecimal totalImpuesto = new BigDecimal(0);
		BigDecimal totalNeto = new BigDecimal(0);
		
		for(Factura fx : estadoDeudaMonotributoFacturas(profe)){
			boolean cargar = true;
			if(cargar){
				
				periodo.put(fx.periodo.id, fx.periodo.nombre);
				total = total.add(fx.getBase());
				totalImpuesto = totalImpuesto.add(fx.getTotalImpuesto());
				totalNeto = totalNeto.add(fx.getTotal());
				
				if(retPeriodoFactura.containsKey(fx.periodo.id)){
					List<Factura> ft = retPeriodoFactura.get(fx.periodo.id);
					ft.add(fx);
					retPeriodoFactura.put(fx.periodo.id, ft);
					BigDecimal tmp = totalPeriodo.get(fx.periodo.id);
					BigDecimal tmpi = totalImpuestoPeriodo.get(fx.periodo.id);
					BigDecimal tmpn = totalNetoPeriodo.get(fx.periodo.id);
					tmp = tmp.add(fx.getBase());
					tmpi = tmpi.add(fx.getTotalImpuesto());
					tmpn = tmpn.add(fx.getTotal());
					
					totalPeriodo.put(fx.periodo.id, tmp);		
					totalImpuestoPeriodo.put(fx.periodo.id, tmpi);
					totalNetoPeriodo.put(fx.periodo.id, tmpn);
					
				}else{
					List<Factura> ft = new ArrayList<Factura>();
					ft.add(fx);
					retPeriodoFactura.put(fx.periodo.id, ft);
					
					totalPeriodo.put(fx.periodo.id, fx.getBase());
					totalImpuestoPeriodo.put(fx.periodo.id, fx.getTotalImpuesto());
					totalNetoPeriodo.put(fx.periodo.id, fx.getTotal());
				}
			}
		}
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/estadoDeudaMonotributo.xls");	
		
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			
			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			
			Sheet hoja = libro.createSheet("estadoDeudaMonotributo");
			
			int x = 0;
			Row fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			for (Entry<Long, List<Factura>> l : retPeriodoFactura.entrySet()){
				Long clave = l.getKey();
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue(periodo.get(clave));
				celda0.setCellStyle(comun);
				
				
				hoja.addMergedRegion(new CellRangeAddress(
			            x, //first row (0-based)
			            x, //last row  (0-based)
			            0, //first column (0-based)
			            4  //last column  (0-based)
			    ));
				
				x++;
				
				fila = hoja.createRow(x);
				
				celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Expediente");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Base");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Impuesto");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Total");
				celda0.setCellStyle(comun);
				
				x++;
				for(Factura lx : l.getValue()){
					fila = hoja.createRow(x);
					
					celda0 = fila.createCell(0);
					celda0.setCellValue(lx.proveedor.nombre);
					celda0.setCellStyle(comun);
					
					celda0 = fila.createCell(1);
					celda0.setCellValue(lx.expediente.getExpedienteEjercicio());
					celda0.setCellStyle(comun);
					
					celda0 = fila.createCell(2);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(lx.getBase().doubleValue());
					celda0.setCellStyle(estiloMoneda);
					
					celda0 = fila.createCell(3);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(lx.getTotalImpuesto().doubleValue());
					celda0.setCellStyle(estiloMoneda);
					
					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(lx.getTotal().doubleValue());
					celda0.setCellStyle(estiloMoneda);
					
					x++;
				}
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(1);
				celda0.setCellValue("SUB-TOTALES:");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(2);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalPeriodo.get(clave).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				
				celda0 = fila.createCell(3);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalImpuestoPeriodo.get(clave).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				
				celda0 = fila.createCell(4);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalNetoPeriodo.get(clave).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				x++;
				x++;
			}
			
			fila = hoja.createRow(x);
			
			celda0 = fila.createCell(1);
			celda0.setCellValue("TOTALES:");
			celda0.setCellStyle(comun);
			
			celda0 = fila.createCell(2);
			celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda0.setCellValue(total.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			
			celda0 = fila.createCell(3);
			celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda0.setCellValue(totalImpuesto.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			
			celda0 = fila.createCell(4);
			celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda0.setCellValue(totalNeto.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			
			libro.write(archivoTmp); 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(archivo);
	}
}
