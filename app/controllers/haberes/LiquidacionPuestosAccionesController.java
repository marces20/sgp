package controllers.haberes;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import models.BalancePresupuestario;
import models.Certificacion;
import models.Estado;
import models.haberes.LiquidacionMes;
import models.haberes.LiquidacionPuesto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.haberes.liquidacionPuestos.modales.*;

public class LiquidacionPuestosAccionesController extends Controller {
	
	public static Result modalPasarAOtraLiquidacion() {
		return ok(modalPasarAOtraLiquidacion.render(form().bindFromRequest()));
	}
	
	public static Result pasarAOtraLiquidacion() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> lpSeleccionados = getSeleccionados();
		
		if(lpSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una liquidacion púesto.");
			return ok(modalPasarAOtraLiquidacion.render(d));
		}	
		
		Long idLiquidacion = null;
		if(!request().body().asFormUrlEncoded().get("liquidacion_mes_id_modal")[0].isEmpty()){
			idLiquidacion = new Long(request().body().asFormUrlEncoded().get("liquidacion_mes_id_modal")[0]);
		}else {
			flash("error", "Debe seleccionar un liquidacion");
			return ok(modalPasarAOtraLiquidacion.render(d));
		}
		
		List<LiquidacionPuesto> lc = LiquidacionPuesto.find.where()
				   .in("id",lpSeleccionados)
				   .ne("estado_id", Estado.LIQUIDACION_PUESTOS_BORRADOR).findList();

		if(lc.size() > 0) {
			flash("error", "Solo se pueden editar liquidaciones en borrador");
			return ok(modalPasarAOtraLiquidacion.render(d));
		}
		
		LiquidacionMes lmnew = LiquidacionMes.find.byId(idLiquidacion);
		
		
		if(lmnew.estado_id.compareTo(new Long(Estado.LIQUIDACION_MES_BORRADOR)) != 0) {
			flash("error", "La Liquidacion Nueva debe estar en borrador");
			return ok(modalPasarAOtraLiquidacion.render(d));
		}
		boolean error = false;
		String errorStr = "";
		
		List<LiquidacionPuesto> lcc = LiquidacionPuesto.find.where().in("id",lpSeleccionados).findList();
		for(LiquidacionPuesto lcx :lcc) {
			
			if(lcx.liquidacionMes.periodo_id.compareTo(lmnew.periodo_id) != 0) {
				error = true;
				errorStr += "El periodo de la Liquidacion del puesto "+lcx.puestoLaboral.legajo.agente.apellido+" no coincide con la liquidacion nueva.<br>";
			}
			
			if(lcx.liquidacionMes.convenio_ministerio.compareTo(lmnew.convenio_ministerio) != 0) {
				error = true;
				errorStr += "El convenio del puesto "+lcx.puestoLaboral.legajo.agente.apellido+" no coincide con la liquidacion nueva.<br>";
			}
			
			if(lcx.liquidacionMes.estado_id.compareTo(new Long(Estado.LIQUIDACION_MES_BORRADOR)) != 0) {
				error = true;
				errorStr += "La Liquidacion del puesto "+lcx.puestoLaboral.legajo.agente.apellido+" debe estar en borrador<br>";
			}
			
		}
		
		if(error) {
			flash("error", errorStr);
			return ok(modalPasarAOtraLiquidacion.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarAOtraLiquidacion.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = LiquidacionPuesto.modificarLiquidacionMasivo(idLiquidacion ,lpSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lpSeleccionados.size() +" seleccionados.<br>");
			result.put("html", modalPasarAOtraLiquidacion.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalPasarAOtraLiquidacion.render(d));
		}
	}
	
	
	public static Result modalPasarAprobado() {
		return ok(modalPasarAprobado.render(form().bindFromRequest()));
	}
	
	public static Result pasarAprobadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> lpSeleccionados = getSeleccionados();
		
		if(lpSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una liquidacion.");
			return ok(modalPasarAprobado.render(d));
		}	
		
		
		List<LiquidacionPuesto> lcx = LiquidacionPuesto.find.where()
				   .in("id",lpSeleccionados)
				   .isNotNull("puestoLaboral.legajo.agente.fbaja")
				   .findList();

		if(lcx.size() > 0) {
			String f = "";
			for(LiquidacionPuesto lcz : lcx) {
				f += lcz.puestoLaboral.legajo.agente.apellido+"<br>";
			}
			flash("error", "No se puede aprobar liquidaciones con fecha de baja en agentes.<br>"+f);
			return ok(modalPasarAprobado.render(d));
		}
		
		List<LiquidacionPuesto> lc = LiquidacionPuesto.find.where()
							   .in("id",lpSeleccionados)
							   .eq("liquidacionMes.estado_id", Estado.LIQUIDACION_MES_APROBADO).findList();
		
		if(lc.size() > 0) {
			flash("error", "No se puede cambiar el estado para la liquidacion está aprobada.");
			return ok(modalPasarAprobado.render(d));
		}
		
		
		
		
		if(!soloPreaprobado(lpSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en preaprobado.");
			return ok(modalPasarAprobado.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarAprobado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = LiquidacionPuesto.modificarEstadoMasivo(Estado.LIQUIDACION_PUESTOS_APROBADO, lpSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lpSeleccionados.size() +" seleccionados.<br>");
			result.put("html", modalPasarAprobado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarAprobado.render(d));
		}
		
	}
	
	public static Result modalPasarPreaprobado() {
		return ok(modalPasarPreaprobado.render(form().bindFromRequest()));
	}
	
	public static Result pasarPreaprobadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> lpSeleccionados = getSeleccionados();
		
		if(lpSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una liquidacion.");
			return ok(modalPasarPreaprobado.render(d));
		}	
		
		List<LiquidacionPuesto> lc = LiquidacionPuesto.find.where()
				   .in("id",lpSeleccionados)
				   .eq("liquidacionMes.estado_id", Estado.LIQUIDACION_MES_APROBADO).findList();

		if(lc.size() > 0) {
			flash("error", "No se puede cambiar el estado para la liquidacion está aprobada.");
			return ok(modalPasarPreaprobado.render(d));
		}
		
		
		
		
		if(!soloBorrador(lpSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en borrador.");
			return ok(modalPasarPreaprobado.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarPreaprobado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = LiquidacionPuesto.modificarEstadoMasivo(Estado.LIQUIDACION_PUESTOS_PREAPROBADO, lpSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lpSeleccionados.size() +" seleccionados.<br>");
			result.put("html", modalPasarPreaprobado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalPasarPreaprobado.render(d));
		}
	}
	
	public static Result modalPasarBorrador() {
		return ok(modalPasarBorrador.render(form().bindFromRequest()));
	}
	
	public static Result pasarBorradorMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> lpSeleccionados = getSeleccionados();

		if(lpSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una liquidacion.");
			return ok(modalPasarBorrador.render(d));
		}	
		
		List<LiquidacionPuesto> lc = LiquidacionPuesto.find.where()
									   .in("id",lpSeleccionados)
									   .eq("liquidacionMes.estado_id", Estado.LIQUIDACION_MES_APROBADO).findList();

		if(lc.size() > 0) {
			flash("error", "No se puede cambiar el estado para la liquidacion está aprobada.");
			return ok(modalPasarPreaprobado.render(d));
		}
		
		
		if(!soloCancelado(lpSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en cancelado.");
			return ok(modalPasarBorrador.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarBorrador.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = LiquidacionPuesto.modificarEstadoMasivo(Estado.LIQUIDACION_PUESTOS_BORRADOR, lpSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lpSeleccionados.size() +" seleccionados.<br>");
			result.put("html", modalPasarBorrador.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarBorrador.render(d));
		}
	}
	
	public static Result modalPasarCancelado() {
		return ok(modalPasarCancelado.render(form().bindFromRequest()));
	}
	
	public static Result pasarCanceladoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> lpSeleccionados = getSeleccionados();

		if(lpSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una liquidacion.");
			return ok(modalPasarCancelado.render(d));
		}	
		
		List<LiquidacionPuesto> lc = LiquidacionPuesto.find.where()
									   .in("id",lpSeleccionados)
									   .eq("liquidacionMes.estado_id", Estado.LIQUIDACION_MES_APROBADO).findList();

		if(lc.size() > 0) {
			flash("error", "No se puede cambiar el estado para la liquidacion está aprobada.");
			return ok(modalPasarPreaprobado.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarCancelado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = LiquidacionPuesto.modificarEstadoMasivo(Estado.LIQUIDACION_PUESTOS_CANCELADO, lpSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lpSeleccionados.size() +" seleccionados.<br>");
			result.put("html", modalPasarCancelado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarCancelado.render(d));
		}
	}
	
	public static Boolean soloPreaprobado(List<Integer> lpSeleccionados) {
		return LiquidacionPuesto.find.where().ne("estado_id", Estado.LIQUIDACION_PUESTOS_PREAPROBADO).in("id", lpSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloBorrador(List<Integer> lpSeleccionados) {
		return LiquidacionPuesto.find.where().ne("estado_id", Estado.LIQUIDACION_PUESTOS_BORRADOR).in("id", lpSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloCancelado(List<Integer> lpSeleccionados) {
		return LiquidacionPuesto.find.where().ne("estado_id", Estado.LIQUIDACION_PUESTOS_CANCELADO).in("id", lpSeleccionados).findRowCount() == 0;
	}
	
	public static List<Integer> getSeleccionados(){
		String[] checks = request().body().asFormUrlEncoded().get("check_listado[]");
		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}
}
