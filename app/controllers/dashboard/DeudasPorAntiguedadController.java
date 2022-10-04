package controllers.dashboard;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import models.ActaRecepcion;
import models.Periodo;
import models.Proveedor;
import models.informes.InformeDeudaPorActaMaterializada;

import com.avaje.ebean.SqlRow;

import controllers.Secured;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.dashboard.deudasPorAntiguedad.*;

@Security.Authenticated(Secured.class)
public class DeudasPorAntiguedadController extends Controller {
	
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		return ok(index.render(d));
	}
	
	public static Result deudasDetallesPorProveedor() {
		
		DynamicForm d = form().bindFromRequest();
		
		if(RequestVar.get("proveedor.id") != null && !RequestVar.get("proveedor.id").isEmpty()) {
			
			Integer idProveedor = (RequestVar.get("proveedor.id").compareTo("14947") == 0)?new Integer(-1):new Integer(RequestVar.get("proveedor.id"));
			boolean ra = (idProveedor.compareTo(new Integer(14947)) == 0)?true:false; 
			boolean sinServicio = false;
			
			Map<String,Map<String,List<List<SqlRow>>>> listaFinal = InformeDeudaPorActaMaterializada.getListaFinalDeudasDetallesReporte(idProveedor,null,null,sinServicio);
			
			 
			
			String proveedor = "";
			
			if(idProveedor.compareTo(-1) == 0){
				proveedor = "R.A.";
			}else{	
				Proveedor p = Proveedor.find.byId(idProveedor.longValue());
				proveedor = p.nombre;
			}
			
			return ok(deudasDetalles.render(false,idProveedor,listaFinal,proveedor,d,sinServicio));
		}else {
			flash("error", "Debe Seleccionar un proveedor.");
			return ok(index.render(d));
		}
	}
	
	public static Result deudasDetalles(Integer idProveedor,Boolean equipamiento) {
		
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		
		DynamicForm d = form().bindFromRequest();
		Boolean equi2 = (idProveedor == 0 && !equipamiento)?null:equipamiento;
		 
		boolean sinServicio = true;
		Map<String,Map<String,List<List<SqlRow>>>> listaFinal = InformeDeudaPorActaMaterializada.getListaFinalDeudasDetallesReporte(idProveedor,equi2,null,sinServicio);
		
		String proveedor = "";
		String equi = "";
		if(idProveedor.compareTo(-1) == 0){
			proveedor = "R.A.";
		}else if(idProveedor.compareTo(0) == 0){
			proveedor = "TODOS";
		}else if(idProveedor.compareTo(-2) == 0){	
			proveedor = "OTROS PROVEEDORES";	
		}else{	
			Proveedor p = Proveedor.find.byId(idProveedor.longValue());
			proveedor = p.nombre;
		}
		
		return ok(deudasDetalles.render(equipamiento,idProveedor,listaFinal,proveedor,d,sinServicio));
	}
	
	public static Result deudasResumenMensual() {
		
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		
		DynamicForm d = form().bindFromRequest();
		Map<String,List<SqlRow>> mapMensual = new HashMap<String, List<SqlRow>>();
		
		List<SqlRow> listaFinal = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadResumenMensual(false,false);
		mapMensual.put("OPERATIVA", listaFinal); 
		List<SqlRow> listaFinalProfe = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadResumenMensual(true,false);
		mapMensual.put("PROFE", listaFinalProfe); 
		
		
		return ok(deudasResumenMensual.render(mapMensual,d));
	}
	
	public static Result deudasDetallesInstitucion() {
		
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		
		DynamicForm d = form().bindFromRequest();
		Map<String,List<SqlRow>> listaFinal = InformeDeudaPorActaMaterializada.getListaFinalDeudasDetallesInstitucionReporte();
		return ok(deudasDetallesInstitucion.render(listaFinal,d));
	}
	
	public static Result deudasDetallesCuenta(Integer idCuenta) {
		
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		
		DynamicForm d = form().bindFromRequest();
		List<SqlRow> listaFinal = InformeDeudaPorActaMaterializada.getListaFinalDeudasDetallesCuentaReporte(idCuenta);
		return ok(deudasDetallesCuenta.render(listaFinal,d,idCuenta));
	}
	
	public static Result deudasResumenInstitucion() {
		
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		
		DynamicForm d = form().bindFromRequest();
		List<String> instiOp = new ArrayList<String>();
		List<String> instiProfe = new ArrayList<String>();
		Map<String,BigDecimal> instiMonto = new HashMap<String,BigDecimal>();
		Map<String,BigDecimal> instiMontoTotalOperativa = new HashMap<String,BigDecimal>();
		Map<String,BigDecimal> instiMontoTotalProfe = new HashMap<String,BigDecimal>();
		Map<Long,Map<String,BigDecimal>> periodoInsti = new HashMap<Long,Map<String,BigDecimal>>();
		Map<String,Map<Long,Map<String,BigDecimal>>> listaFinal = new HashMap<String, Map<Long,Map<String,BigDecimal>>>();
		
		//OPERTATIVAAAA
		List<SqlRow> operativa = InformeDeudaPorActaMaterializada.getDeudaPorInstitucionPorAntiguedadResumen(false);
		
		for(SqlRow z :operativa){
			instiMonto = new HashMap<String,BigDecimal>();
			Periodo p = Periodo.find.where().eq("nombre", z.getString("fecha_mes_ano")).findUnique();
			
			if(periodoInsti.get(p.id) == null){
				instiMonto.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
				periodoInsti.put(p.id, instiMonto);
			}else{
				
				Map<String,BigDecimal> instiMontoTmp = periodoInsti.get(p.id);
				if(instiMontoTmp.get(z.getString("deposito")) == null){
					instiMontoTmp.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
					periodoInsti.remove(p.id);
					periodoInsti.put(p.id, instiMontoTmp);
				}
			}
			if(!instiOp.contains(z.getString("deposito"))){
				instiOp.add(z.getString("deposito"));
			}
			if(instiMontoTotalOperativa.get(z.getString("deposito")) == null){
				instiMontoTotalOperativa.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
			}else{
				BigDecimal xtmp = instiMontoTotalOperativa.get(z.getString("deposito")).add(z.getBigDecimal("total_deuda"));
				instiMontoTotalOperativa.remove(z.getString("deposito"));
				instiMontoTotalOperativa.put(z.getString("deposito"), xtmp);
			}
			
		}
		Map<Long,Map<String,BigDecimal>> sortedPeriodoInsti = new TreeMap<Long,Map<String,BigDecimal>>(periodoInsti);
		listaFinal.put("OPERATIVA", sortedPeriodoInsti);
		
		//PROFEEEEEE
		instiMonto = new HashMap<String,BigDecimal>();
		periodoInsti = new HashMap<Long,Map<String,BigDecimal>>();
		
		List<SqlRow> profe = InformeDeudaPorActaMaterializada.getDeudaPorInstitucionPorAntiguedadResumen(true);
		for(SqlRow z :profe){
			 
			instiMonto = new HashMap<String,BigDecimal>();
			Periodo p = Periodo.find.where().eq("nombre", z.getString("fecha_mes_ano")).findUnique();
			if(periodoInsti.get(p.id) == null){
				instiMonto.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
				periodoInsti.put(p.id, instiMonto);
			}else{
				Map<String,BigDecimal> instiMontoTmp = periodoInsti.get(p.id);
				if(instiMontoTmp.get(z.getString("deposito")) == null){
					instiMontoTmp.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
					periodoInsti.remove(p.id);
					periodoInsti.put(p.id, instiMontoTmp);
				}
			}
			
			
			if(!instiProfe.contains(z.getString("deposito"))){
				instiProfe.add(z.getString("deposito"));
			}
			
			if(instiMontoTotalProfe.get(z.getString("deposito")) == null){
				instiMontoTotalProfe.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
			}else{
				BigDecimal xtmp = instiMontoTotalProfe.get(z.getString("deposito")).add(z.getBigDecimal("total_deuda"));
				instiMontoTotalProfe.remove(z.getString("deposito"));
				instiMontoTotalProfe.put(z.getString("deposito"), xtmp);
			}
		} 
		sortedPeriodoInsti = new TreeMap<Long,Map<String,BigDecimal>>(periodoInsti);
		listaFinal.put("PROFE", sortedPeriodoInsti);
		
		return ok(deudasResumenInstitucion.render(listaFinal,instiOp,instiProfe,instiMontoTotalOperativa,instiMontoTotalProfe,d));
	}
	
	public static Result deudasDetallesServicios() {
		
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		
		DynamicForm d = form().bindFromRequest();
		/*List<SqlRow> proveedorHEARM = InformeEstadisticoDeudaProveedores.getDeudaPorProveedorDetallesServicios((long)Deposito.HEARM,false);
		List<SqlRow> proveedorOtros = InformeEstadisticoDeudaProveedores.getDeudaPorProveedorDetallesServicios(null,false);
		List<SqlRow> proveedorTodos = InformeEstadisticoDeudaProveedores.getDeudaPorProveedorDetallesServicios(null,true);*/
		
		List<SqlRow> proveedorHEARM = InformeDeudaPorActaMaterializada.getDeudaServiciosPorPeriodoPorAntiguedadResumenMensual(false,true,true);
		List<SqlRow> proveedorOtros = InformeDeudaPorActaMaterializada.getDeudaServiciosPorPeriodoPorAntiguedadResumenMensual(false,true,false);
		List<SqlRow> proveedorTodos = InformeDeudaPorActaMaterializada.getDeudaServiciosPorPeriodoPorAntiguedadResumenMensual(false,true,null);
		
		
		Map<Long,BigDecimal> periodoDeuda = new HashMap<Long, BigDecimal>();
		Map<String,Map<Long,BigDecimal>> pret = new HashMap<String, Map<Long,BigDecimal>>();
		Map<String,BigDecimal> deudaSinPeriodos = new HashMap<String,BigDecimal>();
		List<Long> peridoIds = new ArrayList<Long>();
		
		for(SqlRow ph :proveedorTodos){
			
			BigDecimal totalDeuda = ph.getBigDecimal("total_deuda");
			Long idOrdenProvision = ph.getLong("orden_provision_id");
			Long idExpediente = ph.getLong("expediente_id");
			
			String expedienteOp = ph.getLong("expediente_id").toString()+ph.getLong("orden_provision_id").toString();
			
			if(totalDeuda.compareTo(BigDecimal.ZERO) > 0){
				
				if(idOrdenProvision != null ){
					List<ActaRecepcion> arl = ActaRecepcion.getListaActasDeudas(idOrdenProvision,null);
					if(arl.size() > 0){ 
						for(ActaRecepcion ar: arl){
	
							if(ar.periodo_id != null && ar.periodo_id.compareTo(new Long(0)) != 0){
								
								if(pret.containsKey(expedienteOp)){
									Map<Long,BigDecimal> periodoDeudaTmp = pret.get(expedienteOp);
									
									if(periodoDeudaTmp.containsKey(ar.periodo_id)){
										BigDecimal arTotalTmp = periodoDeudaTmp.get(ar.periodo_id);
										arTotalTmp = arTotalTmp.add(ar.total);
										periodoDeudaTmp.put(ar.periodo_id, arTotalTmp);
										pret.put(expedienteOp, periodoDeudaTmp);
										 
									}else{
										periodoDeudaTmp.put(ar.periodo_id, ar.total);
										pret.put(expedienteOp, periodoDeudaTmp);
									}
								}else{
									periodoDeuda = new HashMap<Long, BigDecimal>();
									periodoDeuda.put(ar.periodo_id, ar.total);
									pret.put(expedienteOp, periodoDeuda);
									
								}
								
								if(!peridoIds.contains(ar.periodo_id)){
									peridoIds.add(ar.periodo_id);
								}
								
							}else{
								if(deudaSinPeriodos.containsKey(idExpediente)){
									BigDecimal arTotalTmp = deudaSinPeriodos.get(idExpediente);
									arTotalTmp = arTotalTmp.add(ar.total);
									deudaSinPeriodos.put(expedienteOp, arTotalTmp);
								}else{
									deudaSinPeriodos.put(expedienteOp, ar.total);
								}
							}
						}
					}else{
						deudaSinPeriodos.put(expedienteOp, totalDeuda);
					}
				}else{
					deudaSinPeriodos.put(expedienteOp, totalDeuda);
				}
			}
		}
		
		Logger.debug("xxxxxxxxxxxxxxxx "+pret);
		
		Collections.sort(peridoIds); 
		
		return ok(deudasDetallesServicios.render(proveedorHEARM,proveedorOtros,peridoIds,pret,deudaSinPeriodos,d));
	}
	
}
