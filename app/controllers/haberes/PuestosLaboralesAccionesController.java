package controllers.haberes;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.Agente;
import models.Estado;
import models.Usuario;
import models.haberes.LiquidacionMes;
import models.haberes.PuestoLaboral;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import views.html.haberes.puestosLaborales.acciones.*; 

public class PuestosLaboralesAccionesController extends Controller {
	
	public static Result modalPasarABorrador() {
		return ok(modalPasarABorrador.render(form().bindFromRequest()));
	}
	
	public static Result pasarABorrador() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		List<Integer> pSeleccionados = getSeleccionados();

		if(pSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un puesto.");
			return ok(modalPasarABorrador.render(d));
		}	
		
		if(!soloControlado(pSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado controlado.");
			return ok(modalPasarABorrador.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarABorrador.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = PuestoLaboral.modificarEstadoMasivo(Estado.PUESTO_LABORAL_BORRADOR, pSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarABorrador.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarABorrador.render(d));
		}
	}
	
	public static Boolean soloControlado(List<Integer> pSeleccionados) {
		return PuestoLaboral.find.where().ne("estado_id", Estado.PUESTO_LABORAL_CONTROLADO).in("id", pSeleccionados).findRowCount() == 0;
	}
	
	public static Result modalPasarAControlado() {
		return ok(modalPasarAControlado.render(form().bindFromRequest()));
	}
	
	public static Result pasarAControlado() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		List<Integer> pSeleccionados = getSeleccionados();

		if(pSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un puesto.");
			return ok(modalPasarAControlado.render(d));
		}	
		
		if(!soloBorrador(pSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado Borrador.");
			return ok(modalPasarAControlado.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarAControlado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = PuestoLaboral.modificarEstadoMasivo(Estado.PUESTO_LABORAL_CONTROLADO, pSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarAControlado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarAControlado.render(d));
		}
	}
	
	public static Boolean soloBorrador(List<Integer> pSeleccionados) {
		return PuestoLaboral.find.where().ne("estado_id", Estado.PUESTO_LABORAL_BORRADOR).in("id", pSeleccionados).findRowCount() == 0;
	}
	
	@CheckPermiso(key = "liquidacionMesPreliquidar")
	public static Result modalPreliquidarFinalPuesto() {
		return ok(modalPreliquidarFinalPuesto.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "liquidacionMesPreliquidar")
	public static Result preliquidarFinalPuesto() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		 
		//String[] liquidacion_id = request().body().asFormUrlEncoded().get("liquidacion_id"); 
		String[] puestoId = request().body().asFormUrlEncoded().get("puestoLaboralId"); 
		 
		Logger.debug("xxxxxxxxxxx "+request().body().asFormUrlEncoded());
		
		Long p = new Long(puestoId[0]);
		PuestoLaboral pl = PuestoLaboral.find.byId(p);
		
		
		if(pl.liquidacion_mes_id == null){
			flash("error", "Debe setear una liquidacion final en el puesto");
			return ok(modalPreliquidarFinalPuesto.render(d));
		}
		
		 
		if(pl.liquidacionMes.estado_id.compareTo((long)Estado.LIQUIDACION_MES_BORRADOR) !=  0){
			flash("error", "La liquidacion debe estar en borrador.");
			return ok(modalPreliquidarFinalPuesto.render(d));
		}
		
		
		
		if(pl.convenio_ministerio != pl.liquidacionMes.convenio_ministerio){
			flash("error", "La liquidacion no coincide con el tipo de convenio del puesto.");
			return ok(modalPreliquidarFinalPuesto.render(d));
		}
		
		 
		ObjectNode result = Json.newObject();
		try {
			Integer count = PuestoLaboral.preliquidarPuestoFinal(pl.liquidacion_mes_id.intValue(),p.intValue());
			if(count < 0 ){
				flash("error", "No se puede modificar los registros.");
				return ok(modalPreliquidarFinalPuesto.render(d));
			}
			
			result.put("success", true);
			flash("success", "Se prelquidaron "+count+" puestos.");
			result.put("html", modalPreliquidarFinalPuesto.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalPreliquidarFinalPuesto.render(d));
		}
	}
	
	
	@CheckPermiso(key = "liquidacionMesPreliquidar")
	public static Result modalPreliquidarPuesto() {
		return ok(modalPreliquidarPuesto.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "liquidacionMesPreliquidar")
	public static Result preliquidarPuesto() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		 
		String[] liquidacion_id = request().body().asFormUrlEncoded().get("liquidacion_id"); 
		String[] puestoId = request().body().asFormUrlEncoded().get("puestoLaboralId"); 
		 
		Logger.debug("xxxxxxxxxxx "+request().body().asFormUrlEncoded());
		
		
		if(liquidacion_id[0] == null || liquidacion_id[0].isEmpty()){
			flash("error", "Debe seleccionar una liquidacion");
			return ok(modalPreliquidarPuesto.render(d));
		}
		
		Long l = new Long(liquidacion_id[0]);
		LiquidacionMes lm = LiquidacionMes.find.byId(l);
		if(lm.estado_id.compareTo((long)Estado.LIQUIDACION_MES_BORRADOR) !=  0){
			flash("error", "La liquidacion debe estar en borrador.");
			return ok(modalPreliquidarPuesto.render(d));
		}
		
		Long p = new Long(puestoId[0]);
		PuestoLaboral pl = PuestoLaboral.find.byId(p);
		
		if(pl.convenio_ministerio != lm.convenio_ministerio){
			flash("error", "La liquidacion no coincide con el tipo de convenio del puesto.");
			return ok(modalPreliquidarPuesto.render(d));
		}
		
		 
		ObjectNode result = Json.newObject();
		try {
			Integer count = PuestoLaboral.preliquidarPuesto(l.intValue(),p.intValue());
			if(count < 0 ){
				flash("error", "No se puede modificar los registros.");
				return ok(modalPreliquidarPuesto.render(d));
			}
			
			result.put("success", true);
			flash("success", "Se prelquidaron "+count+" puestos.");
			result.put("html", modalPreliquidarPuesto.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalPreliquidarPuesto.render(d));
		}
	}
	
	
	@CheckPermiso(key = "puestoLaboralCrearNovedadesBasicas")
	public static Result modalCrearNovedades() {
		return ok(modalCrearNovedades.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "puestoLaboralCrearNovedadesBasicas")
	public static Result crearNovedadesBasicas() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> plSeleccionados = getSeleccionados();
		
		if(plSeleccionados.isEmpty()){
			flash("error", "Debe seleccionar al menos un puesto laboral.");
			return ok(modalCrearNovedades.render(d));
		}
		
		String[] periodo_desde_id = request().body().asFormUrlEncoded().get("periodo_desde_id");
		String[] periodo_hasta_id = request().body().asFormUrlEncoded().get("periodo_hasta_id");
			
		if(periodo_desde_id[0] == null || periodo_desde_id[0].isEmpty()){
			flash("error", "Debe seleccionar un periodo desde.");
			return ok(modalCrearNovedades.render(d));
		}
		
		if(periodo_hasta_id[0] == null || periodo_hasta_id[0].isEmpty()) {
			flash("error", "Debe seleccionar un periodo hasta.");
			return ok(modalCrearNovedades.render(d));
		}
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = PuestoLaboral.crearNovedadesBasicas(plSeleccionados,Integer.parseInt(periodo_desde_id[0]),Integer.parseInt(periodo_hasta_id[0]));
			if(count < 0 ){
				flash("error", "No se puede modificar los registros.");
				return ok(modalCrearNovedades.render(d));
			}
			
			result.put("success", true);
			flash("success", "Se crearon "+count+" novedades.");
			result.put("html", modalCrearNovedades.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCrearNovedades.render(d));
		}
	}
	
	@CheckPermiso(key = "puestoLaboralActivarDesactivarMasivo")
	public static Result activar() {
		List<Integer> ids = getSeleccionados();
		
		if(ids.isEmpty() || ids.size() < 1) {
			flash("error", "Debe seleccionar al menos 2 puestos.");
			return ok(respuestaModal.render());
		}
		
		try {
			Ebean.beginTransaction();  
			
			String sqlUpdate = "UPDATE puestos_laborales SET activo = :estado WHERE id in (:listId)";
			Ebean.createSqlUpdate(sqlUpdate).setParameter("estado", true).setParameter("listId", ids).execute();
	
	
			Ebean.commitTransaction();
		} catch(Exception e) {	
			flash("error", "No se pudo activar el puesto laboral.");
			Ebean.rollbackTransaction();
			return ok(respuestaModal.render());
		} finally {
			Ebean.endTransaction();  
		}
		
		flash("success", "Se han activado los puestos laborales seleccionados.");
		
		return ok(respuestaModal.render());
	}
	
	@CheckPermiso(key = "puestoLaboralActivarDesactivarMasivo")
	public static Result desactivar() {
		List<Integer> ids = getSeleccionados();
		
		if(ids.isEmpty() || ids.size() < 1) {
			flash("error", "Debe seleccionar al menos 2 puestos.");
			return ok(respuestaModal.render());
		}
		
		try {
			Ebean.beginTransaction();  
			
			String sqlUpdate = "UPDATE puestos_laborales SET activo = :estado WHERE id in (:listId)";
			Ebean.createSqlUpdate(sqlUpdate).setParameter("estado", false).setParameter("listId", ids).execute();
	
	
			Ebean.commitTransaction();
		} catch(Exception e) {	
			flash("error", "No se pudo desactivar el puesto laboral.");
			Ebean.rollbackTransaction();
			return ok(respuestaModal.render());
		} finally {
			Ebean.endTransaction();  
		}
		
		flash("success", "Se han desactivado los puestos laborales seleccionados.");
		
		return ok(respuestaModal.render());
	}
	
	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado[]");
		} catch (NullPointerException e) {
		}
		
		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}
	
}
