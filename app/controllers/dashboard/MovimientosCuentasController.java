package controllers.dashboard;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.SqlRow;

import models.BalanceCuentaPropia;
import models.CuentaPropia;
import models.Estado;
import models.recupero.RecuperoPago;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.RequestVar;
import views.html.dashboard.movimientosCuentas.*;
import controllers.Secured;

@Security.Authenticated(Secured.class)
public class MovimientosCuentasController extends Controller {
	
	public static Result index() {
		return ok(index.render());
	}
	
	public static Result resumenFinancieroGeneral() {
		
		DynamicForm formBuscador = form().bindFromRequest();
		
		List<SqlRow> saldoCuentas = new ArrayList<SqlRow>();
		SqlRow saldoCuentasIniciales = null;
		BigDecimal ingresosRecupero = new BigDecimal(0);
		Date fdesde = null;
		Date fdesdeInicial = new Date();
		Date  fhasta = null;
		
		Map<String,Map<String,BigDecimal>> cuentaMovimientoMonto = new HashMap<String,Map<String,BigDecimal>>();
		
		if(Controller.request().queryString().size() > 0){
			if((!RequestVar.get("fdesde").isEmpty() && RequestVar.get("fhasta").isEmpty()) || (RequestVar.get("fdesde").isEmpty() && !RequestVar.get("fhasta").isEmpty())) {
				flash("error", "Debe fecha de inicio y fecha fin.");
				return ok(resumenFinancieroGeneral.render(formBuscador,cuentaMovimientoMonto));
			}else{
				if(!RequestVar.get("fdesde").isEmpty() && !RequestVar.get("fhasta").isEmpty()){
					fdesde = DateUtils.formatDate(RequestVar.get("fdesde"), "dd/MM/yyyy");
					fhasta = DateUtils.formatDate(RequestVar.get("fhasta"), "dd/MM/yyyy");
					fdesdeInicial = DateUtils.formatDate(RequestVar.get("fdesde"), "dd/MM/yyyy");
					Logger.debug("fffffffffffffffffffffffff "+fdesdeInicial);
					if(fdesde.compareTo(fhasta) > 0){
						flash("error", "La fecha de inicio no puede ser menor a la fecha fin.");
						return ok(resumenFinancieroGeneral.render(formBuscador,cuentaMovimientoMonto));
					}
				} 
			}
		}
		
		
		for(CuentaPropia ccc :CuentaPropia.find.all()){
			BigDecimal si = new BigDecimal(0);
			saldoCuentasIniciales = BalanceCuentaPropia.getSaldosInicialesCuentas(fdesdeInicial, ccc.id,(long)Estado.PAGO_ESTADO_CONCILIADO);
			if(saldoCuentasIniciales != null){
				si = saldoCuentasIniciales.getBigDecimal("saldo");
			}
			
			Map<String,BigDecimal> movimientoMonto = new HashMap<String,BigDecimal>();
			movimientoMonto.put("SALDOINICIAL",si);
			movimientoMonto.put("SALDO",BigDecimal.ZERO);
			movimientoMonto.put("INGRESO",BigDecimal.ZERO);
			movimientoMonto.put("GASTO", BigDecimal.ZERO);
			cuentaMovimientoMonto.put(ccc.nombre, movimientoMonto);
		}
		
		ingresosRecupero = RecuperoPago.getTotalPagadoPorFecha(fdesde, fhasta);
		saldoCuentas =  BalanceCuentaPropia.getSaldosCuentas(fdesde, fhasta,(long)Estado.PAGO_ESTADO_CONCILIADO);
		
		
		
		// "OPERATIVA"=> ("INGRESO" => $32.213.2)
		for(SqlRow s:saldoCuentas){
			
			if(cuentaMovimientoMonto.containsKey(s.getString("nombre"))){
				
				BigDecimal xx = new BigDecimal(0);
				Map<String,BigDecimal> movimientoMontoTmp = cuentaMovimientoMonto.get(s.getString("nombre"));
				
				if(!movimientoMontoTmp.containsKey("SALDO")){
					movimientoMontoTmp.put("SALDO", s.getBigDecimal("saldo"));
				}else{
					xx  =  movimientoMontoTmp.get("SALDO");
					movimientoMontoTmp.put("SALDO", s.getBigDecimal("saldo").add(xx));
				}
				
				if(!movimientoMontoTmp.containsKey("INGRESO")){
					movimientoMontoTmp.put("INGRESO", s.getBigDecimal("deposito"));
				}else{
					xx  =  movimientoMontoTmp.get("INGRESO");
					movimientoMontoTmp.put("INGRESO", s.getBigDecimal("deposito").add(xx));
				}
				
				if(!movimientoMontoTmp.containsKey("GASTO")){
					movimientoMontoTmp.put("GASTO", s.getBigDecimal("debito"));
				}else{
					xx  =  movimientoMontoTmp.get("GASTO");
					movimientoMontoTmp.put("GASTO", s.getBigDecimal("debito").add(xx));
				}
				
				cuentaMovimientoMonto.put(s.getString("nombre"), movimientoMontoTmp);		
			}/*else{
				
				Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
				Map<String,BigDecimal> movimientoMonto = new HashMap<String,BigDecimal>();
				
				movimientoMonto.put("SALDO", s.getBigDecimal("saldo"));
				movimientoMonto.put("INGRESO", s.getBigDecimal("deposito"));
				movimientoMonto.put("GASTO", s.getBigDecimal("debito"));
				cuentaMovimientoMonto.put(s.getString("nombre"), movimientoMonto);
			}*/
		}
		 

		return ok(resumenFinancieroGeneral.render(formBuscador,cuentaMovimientoMonto));
	}
	
	public static Result resumenFinancieroDetalle() {
		
		DynamicForm formBuscador = form().bindFromRequest();
		
		List<SqlRow> saldoCuentas = new ArrayList<SqlRow>();
		SqlRow saldoCuentasIniciales = null;
		List<SqlRow> listaGastosCuenta = null;
		BigDecimal ingresosRecupero = new BigDecimal(0);
		Date fdesde = null;
		Date fdesdeInicial = new Date();
		Date  fhasta = null;
		Map<String,List<SqlRow>> cuentasListaGastos = new HashMap<String,List<SqlRow>>();
		Map<String,Map<String,BigDecimal>> cuentaMovimientoMonto = new HashMap<String,Map<String,BigDecimal>>();
	
		
		if(Controller.request().queryString().size() > 0){
			if((!RequestVar.get("fdesde").isEmpty() && RequestVar.get("fhasta").isEmpty()) || (RequestVar.get("fdesde").isEmpty() && !RequestVar.get("fhasta").isEmpty())) {
				flash("error", "Debe fecha de inicio y fecha fin.");
				return ok(resumenFinancieroDetalle.render(formBuscador,cuentaMovimientoMonto,cuentasListaGastos));
			}else{
				if(!RequestVar.get("fdesde").isEmpty() && !RequestVar.get("fhasta").isEmpty()){
					fdesde = DateUtils.formatDate(RequestVar.get("fdesde"), "dd/MM/yyyy");
					fhasta = DateUtils.formatDate(RequestVar.get("fhasta"), "dd/MM/yyyy");
					fdesdeInicial = DateUtils.formatDate(RequestVar.get("fdesde"), "dd/MM/yyyy");
					if(fdesde.compareTo(fhasta) > 0){
						flash("error", "La fecha de inicio no puede ser menor a la fecha fin.");
						return ok(resumenFinancieroDetalle.render(formBuscador,cuentaMovimientoMonto,cuentasListaGastos));
					}
				} 
			}
		}
		
		
		for(CuentaPropia ccc :CuentaPropia.find.all()){
			BigDecimal si = new BigDecimal(0);
			saldoCuentasIniciales = BalanceCuentaPropia.getSaldosInicialesCuentas(fdesdeInicial, ccc.id,(long)Estado.PAGO_ESTADO_CONCILIADO);
			if(saldoCuentasIniciales != null){
				si = saldoCuentasIniciales.getBigDecimal("saldo");
			}
			
			listaGastosCuenta = BalanceCuentaPropia.getGastosDetallePorCuenta(fdesde, fhasta,(long)Estado.PAGO_ESTADO_CONCILIADO,ccc.id);
			
			if(listaGastosCuenta.size() > 0){
				cuentasListaGastos.put(ccc.nombre, listaGastosCuenta);
			}
			
			Map<String,BigDecimal> movimientoMonto = new HashMap<String,BigDecimal>();
			movimientoMonto.put("SALDOINICIAL",si);
			movimientoMonto.put("SALDO",BigDecimal.ZERO);
			movimientoMonto.put("INGRESO",BigDecimal.ZERO);
			movimientoMonto.put("GASTO", BigDecimal.ZERO);
			cuentaMovimientoMonto.put(ccc.nombre, movimientoMonto);
		}
		
		
		ingresosRecupero = RecuperoPago.getTotalPagadoPorFecha(fdesde, fhasta);
		saldoCuentas =  BalanceCuentaPropia.getSaldosCuentas(fdesde, fhasta,(long)Estado.PAGO_ESTADO_CONCILIADO);
		
		for(SqlRow s:saldoCuentas){
			
			if(cuentaMovimientoMonto.containsKey(s.getString("nombre"))){
				
				BigDecimal xx = new BigDecimal(0);
				Map<String,BigDecimal> movimientoMontoTmp = cuentaMovimientoMonto.get(s.getString("nombre"));
				
				if(!movimientoMontoTmp.containsKey("SALDO")){
					movimientoMontoTmp.put("SALDO", s.getBigDecimal("saldo"));
				}else{
					xx  =  movimientoMontoTmp.get("SALDO");
					movimientoMontoTmp.put("SALDO", s.getBigDecimal("saldo").add(xx));
				}
				
				if(!movimientoMontoTmp.containsKey("INGRESO")){
					movimientoMontoTmp.put("INGRESO", s.getBigDecimal("deposito"));
				}else{
					xx  =  movimientoMontoTmp.get("INGRESO");
					movimientoMontoTmp.put("INGRESO", s.getBigDecimal("deposito").add(xx));
				}
				
				if(!movimientoMontoTmp.containsKey("GASTO")){
					movimientoMontoTmp.put("GASTO", s.getBigDecimal("debito"));
				}else{
					xx  =  movimientoMontoTmp.get("GASTO");
					movimientoMontoTmp.put("GASTO", s.getBigDecimal("debito").add(xx));
				}
				
				cuentaMovimientoMonto.put(s.getString("nombre"), movimientoMontoTmp);		
			}
		}
		
		
		return ok(resumenFinancieroDetalle.render(formBuscador,cuentaMovimientoMonto,cuentasListaGastos));
	}
	
	public static Result resumenFinancieroDetallePorInstitucion() {
		
		DynamicForm formBuscador = form().bindFromRequest();
		
		List<SqlRow> saldoCuentas = new ArrayList<SqlRow>();
		SqlRow saldoCuentasIniciales = null;
		List<SqlRow> listaGastosCuenta = null;
		BigDecimal ingresosRecupero = new BigDecimal(0);
		Date fdesde = null;
		Date fdesdeInicial = new Date();
		Date  fhasta = null;
		Map<String,List<SqlRow>> cuentasListaGastos = new HashMap<String,List<SqlRow>>();
		Map<String,Map<String,BigDecimal>> cuentaMovimientoMonto = new HashMap<String,Map<String,BigDecimal>>();
	
		
		if(Controller.request().queryString().size() > 0){
			if((!RequestVar.get("fdesde").isEmpty() && RequestVar.get("fhasta").isEmpty()) || (RequestVar.get("fdesde").isEmpty() && !RequestVar.get("fhasta").isEmpty())) {
				flash("error", "Debe fecha de inicio y fecha fin.");
				return ok(resumenFinancieroDetallePorInstitucion.render(formBuscador,cuentaMovimientoMonto,cuentasListaGastos));
			}else{
				if(!RequestVar.get("fdesde").isEmpty() && !RequestVar.get("fhasta").isEmpty()){
					fdesde = DateUtils.formatDate(RequestVar.get("fdesde"), "dd/MM/yyyy");
					fhasta = DateUtils.formatDate(RequestVar.get("fhasta"), "dd/MM/yyyy");
					fdesdeInicial = DateUtils.formatDate(RequestVar.get("fdesde"), "dd/MM/yyyy");
					if(fdesde.compareTo(fhasta) > 0){
						flash("error", "La fecha de inicio no puede ser menor a la fecha fin.");
						return ok(resumenFinancieroDetallePorInstitucion.render(formBuscador,cuentaMovimientoMonto,cuentasListaGastos));
					}
				} 
			}
		}
		
		
		for(CuentaPropia ccc :CuentaPropia.find.all()){
			BigDecimal si = new BigDecimal(0);
			saldoCuentasIniciales = BalanceCuentaPropia.getSaldosInicialesCuentas(fdesdeInicial, ccc.id,(long)Estado.PAGO_ESTADO_CONCILIADO);
			if(saldoCuentasIniciales != null){
				si = saldoCuentasIniciales.getBigDecimal("saldo");
			}
			
			listaGastosCuenta = BalanceCuentaPropia.getGastosDetallePorCuentaPorInstitucion(fdesde, fhasta,(long)Estado.PAGO_ESTADO_CONCILIADO,ccc.id);
			
			if(listaGastosCuenta.size() > 0){
				cuentasListaGastos.put(ccc.nombre, listaGastosCuenta);
			}
			
			Map<String,BigDecimal> movimientoMonto = new HashMap<String,BigDecimal>();
			movimientoMonto.put("SALDOINICIAL",si);
			movimientoMonto.put("SALDO",BigDecimal.ZERO);
			movimientoMonto.put("INGRESO",BigDecimal.ZERO);
			movimientoMonto.put("GASTO", BigDecimal.ZERO);
			cuentaMovimientoMonto.put(ccc.nombre, movimientoMonto);
		}
		
		
		ingresosRecupero = RecuperoPago.getTotalPagadoPorFecha(fdesde, fhasta);
		saldoCuentas =  BalanceCuentaPropia.getSaldosCuentas(fdesde, fhasta,(long)Estado.PAGO_ESTADO_CONCILIADO);
		
		for(SqlRow s:saldoCuentas){
			
			if(cuentaMovimientoMonto.containsKey(s.getString("nombre"))){
				
				BigDecimal xx = new BigDecimal(0);
				Map<String,BigDecimal> movimientoMontoTmp = cuentaMovimientoMonto.get(s.getString("nombre"));
				
				if(!movimientoMontoTmp.containsKey("SALDO")){
					movimientoMontoTmp.put("SALDO", s.getBigDecimal("saldo"));
				}else{
					xx  =  movimientoMontoTmp.get("SALDO");
					movimientoMontoTmp.put("SALDO", s.getBigDecimal("saldo").add(xx));
				}
				
				if(!movimientoMontoTmp.containsKey("INGRESO")){
					movimientoMontoTmp.put("INGRESO", s.getBigDecimal("deposito"));
				}else{
					xx  =  movimientoMontoTmp.get("INGRESO");
					movimientoMontoTmp.put("INGRESO", s.getBigDecimal("deposito").add(xx));
				}
				
				if(!movimientoMontoTmp.containsKey("GASTO")){
					movimientoMontoTmp.put("GASTO", s.getBigDecimal("debito"));
				}else{
					xx  =  movimientoMontoTmp.get("GASTO");
					movimientoMontoTmp.put("GASTO", s.getBigDecimal("debito").add(xx));
				}
				
				cuentaMovimientoMonto.put(s.getString("nombre"), movimientoMontoTmp);		
			}
		}
		
		
		return ok(resumenFinancieroDetallePorInstitucion.render(formBuscador,cuentaMovimientoMonto,cuentasListaGastos));
	}
	
	public static Result conciliacion() {
		DynamicForm formBuscador = form().bindFromRequest();
		
		List<SqlRow> saldoCuentas = new ArrayList<SqlRow>();
		SqlRow saldoCuentasIniciales = null;
		List<SqlRow> listaGastosCuenta = null;
		BigDecimal ingresosRecupero = new BigDecimal(0);
		Map<String,List<SqlRow>> cuentasListaGastos = new HashMap<String,List<SqlRow>>();
		Map<String,Map<String,BigDecimal>> cuentaMovimientoMonto = new HashMap<String,Map<String,BigDecimal>>(); 
		 
		
		
		saldoCuentas =  BalanceCuentaPropia.getSaldosCuentas((long)Estado.PAGO_ESTADO_CONCILIADO);
		
		
		
		for(SqlRow s:saldoCuentas){
			
			
				
				Map<String,BigDecimal> movimientoMonto = new HashMap<String,BigDecimal>();
				movimientoMonto.put("SALDO", s.getBigDecimal("saldo"));
				movimientoMonto.put("CHEQUE_NO_ENTREGADOS", BalanceCuentaPropia.getTotalCheques(s.getLong("id"),(long) Estado.PAGO_ESTADO_EN_CURSO));
				movimientoMonto.put("CHEQUE_SIN_DEPOSITAR", BalanceCuentaPropia.getTotalCheques(s.getLong("id"),(long) Estado.PAGO_ESTADO_PAGADO));
				cuentaMovimientoMonto.put(s.getString("nombre"), movimientoMonto);
				
			
		}
		
		
		return ok(conciliacion.render(formBuscador,cuentaMovimientoMonto));
	}
}

