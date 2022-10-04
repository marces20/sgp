package controllers.compras;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.BalancePresupuestario;
import models.Certificacion;
import models.CertificacionCompra;
import models.Estado;
import models.Factura;
import controllers.Secured;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import views.html.compras.certificacionesCompras.modales.*;

@Security.Authenticated(Secured.class)
public class CertificacionesComprasAccionesController extends Controller {
	
	final static Form<CertificacionCompra> certificacionForm = form(CertificacionCompra.class);
	
	public static Result modalEditarFechaCertificacion() {
		return ok(modalEditarFechaCertificacion.render(form().bindFromRequest()));
	}
	
	public static Result editarFechaCertificacionMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> certificacionesSeleccionados = getSeleccionados();

		if(certificacionesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una certificacion.");
			return ok(modalEditarFechaCertificacion.render(d));
		}	
		
		if(!Certificacion.soloCertificado(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en certificado.");
			return ok(modalEditarFechaCertificacion.render(d));
		}
		
		Date fecha = DateUtils.formatDate(request().body().asFormUrlEncoded().get("fecha_certificacion_modal")[0], "dd/MM/yyyy");
		if(fecha == null){
			flash("error", "Seleccione una fecha de certificacion.");
			return ok(modalEditarFechaCertificacion.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalEditarFechaCertificacion.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Certificacion.modificarFechaDeCertificacion(fecha, certificacionesSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.");
			result.put("html", modalEditarFechaCertificacion.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalEditarFechaCertificacion.render(d));
		}
	}
	
	public static Result modalPasarEnCurso() {
		return ok(modalPasarEnCurso.render(form().bindFromRequest()));
	}
	
	public static Result pasarEnCursoMasivo() {
		
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> certificacionesSeleccionados = getSeleccionados();

		if(certificacionesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una certificacion.");
			return ok(modalPasarEnCurso.render(d));
		}	
		
		if(!Certificacion.soloBorrador(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(!Certificacion.conExpediente(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(!Certificacion.conLineas(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan lineas.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarEnCurso.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = CertificacionCompra.modificarEstadoMasivo(Estado.CERTIFICACION_COMPRA_ESTADO_ENCURSO, certificacionesSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarEnCurso.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarEnCurso.render(d));
		}		
	}
	
	public static Result modalPasarCertificado() {
		return ok(modalPasarCertificado.render(form().bindFromRequest()));
	}
	
	public static Result pasarCertificadoMasivo() {
		
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> certificacionesSeleccionados = getSeleccionados();

		if(certificacionesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una certificacion.");
			return ok(modalPasarCertificado.render(d));
		}	
		
		if(!Certificacion.soloEnCurso(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en curso.");
			return ok(modalPasarCertificado.render(d));
		}
		
		if(!Certificacion.conExpediente(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
			return ok(modalPasarCertificado.render(d));
		}
		
		if(!Certificacion.conPeriodo(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan periodo asignado.");
			return ok(modalPasarCertificado.render(d));
		}
		
		if(!Certificacion.conLineas(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan lineas.");
			return ok(modalPasarCertificado.render(d));
		}
		
		if(!Certificacion.soloCuentasAnliticasHijas(certificacionesSeleccionados)){
			flash("error", "Las cuentas presupuestarias deben ser Hijas unicamente.");
			return  ok(modalPasarCertificado.render(d));
		}
		
		if(!Certificacion.soloCertificadoConFecha(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que tenga asigando una fecha de certificacion.");
			return  ok(modalPasarCertificado.render(d));
		}
		
		ArrayNode a = BalancePresupuestario.controlSaldoDefinitivoCertificacionesCompras(certificacionesSeleccionados);
		boolean errorControl =  false;
		String aviso = "";
		for(JsonNode o :a){
			boolean success = new Boolean(o.get("success").toString());
			String cuenta = o.get("cuenta").toString();
			String expediente = o.get("expediente").toString();
			BigDecimal saldoDisponible =  new BigDecimal(o.get("saldoDisponible").toString());
			BigDecimal saldoAImputar =  new BigDecimal(o.get("saldoAImputar").toString());
			BigDecimal saldoPresente =  new BigDecimal(o.get("saldoPresente").toString());
			
			if(!success){
				errorControl =  true;
				aviso += "No tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
				aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}else{
				aviso += "Tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
				aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}
		}
		
		if(d.hasErrors())
			return ok(modalPasarCertificado.render(d));	
		
		if(errorControl){
			flash("error", aviso);
			return ok(modalPasarCertificado.render(d));
		}else{
			
			CertificacionCompra duplicado = unicoMismoAgenteConPeriodoConExpediente(certificacionesSeleccionados);
			if(duplicado != null) {
				flash("error", "Existe una certificación con periodo, expediente y agente duplicado. <br /> <b>Proveedor</b>: " + duplicado.proveedor_id + " " + duplicado.proveedor.nombre);
				return ok(modalPasarCertificado.render(d));
			}
			
			ObjectNode result = Json.newObject();
			try {
				Integer count = CertificacionCompra.modificarEstadoMasivoConFechaDeCertificacion(Estado.CERTIFICACION_COMPRA_ESTADO_CERTIFICADO, certificacionesSeleccionados);
				result.put("success", true);
				flash("success", "Se actualizaron " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.<br>");
				result.put("html", modalPasarCertificado.render(d).toString());
				return ok(result);
			} catch (Exception e){
				flash("error", "No se puede modificar los registros.");
				return ok(modalPasarCertificado.render(d));
			}		
		}
	}
	
	public static Result modalPasarBorrador() {
		return ok(modalPasarBorrador.render(form().bindFromRequest()));
	}
	
	public static Result pasarBorradorMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> certificacionesSeleccionados = getSeleccionados();

		if(certificacionesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una certificacion.");
			return ok(modalPasarBorrador.render(d));
		}	
		
		if(!Certificacion.soloCancelado(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en cancelado.");
			return ok(modalPasarBorrador.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarBorrador.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = CertificacionCompra.modificarEstadoMasivo(Estado.CERTIFICACION_COMPRA_ESTADO_BORRADOR, certificacionesSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.");
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
		
		List<Integer> certificacionesSeleccionados = getSeleccionados();

		if(certificacionesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una certificacion.");
			return ok(modalPasarCancelado.render(d));
		}	
		
		if(!Certificacion.soloSinFactura(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que esten relacionados con alguna factura.");
			return ok(modalPasarCancelado.render(d));
		} 
		
		if(d.hasErrors())
			return ok(modalPasarCancelado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = CertificacionCompra.modificarEstadoMasivo(Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO, certificacionesSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarCancelado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarCancelado.render(d));
		}
		
	}
	
	public static CertificacionCompra unicoMismoAgenteConPeriodoConExpediente(List<Integer> certificacionesSeleccionados) {
		
		for (Integer id : certificacionesSeleccionados) {
			
			CertificacionCompra certificacion = CertificacionCompra.find
												.select("orden_id,periodo_id, expediente_id, proveedor_id, proveedor.nombre")
												.where().eq("id", id).findUnique();
			
			List<CertificacionCompra> duplicados = CertificacionCompra.find.select("id").where()
												  .eq("orden_id", certificacion.orden_id)	
												  .eq("proveedor_id", certificacion.proveedor_id)
												  .eq("periodo_id", certificacion.periodo_id)
												  .eq("expediente_id", certificacion.expediente_id)
												  .ne("estado_id", Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO)
												  .ne("estado_id", Estado.CERTIFICACION_COMPRA_ESTADO_BORRADOR)
												  .findList();
			
			
			
			if(duplicados.size() > 1) {
				return certificacion;
			}
		}
		return null;
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
	
	/*
	 public static Result modalPasarAprobado() {
		return ok(modalPasarAprobado.render(form().bindFromRequest()));
	}
	
	public static Result pasarAprobadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> certificacionesSeleccionados = getSeleccionados();

		if(certificacionesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una certificacion.");
			return ok(modalPasarAprobado.render(d));
		}	
		
		if(!soloCertificado(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en certificado.");
			return ok(modalPasarAprobado.render(d));
		}
		
		if(!conExpediente(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
			return ok(modalPasarAprobado.render(d));
		}
		
		if(!conLineas(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan lineas.");
			return ok(modalPasarAprobado.render(d));
		}
		
		
		ArrayNode a = BalancePresupuestario.controlSaldoDefinitivo(certificacionesSeleccionados);
		boolean errorControl =  false;
		String aviso = "";
		for(JsonNode o :a){
			boolean success = new Boolean(o.get("success").toString());
			String cuenta = o.get("cuenta").toString();
			String expediente = o.get("expediente").toString();
			BigDecimal saldoDisponible =  new BigDecimal(o.get("saldoDisponible").toString());
			BigDecimal saldoAImputar =  new BigDecimal(o.get("saldoAImputar").toString());
			BigDecimal saldoPresente =  new BigDecimal(o.get("saldoPresente").toString());
			
			if(!success){
				errorControl =  true;
				aviso += "No tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
				aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}else{
				aviso += "Tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
				aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}
		}
		
		if(d.hasErrors())
			return ok(modalPasarAprobado.render(d));	
		
		if(errorControl){
			flash("error", aviso);
			return ok(modalPasarAprobado.render(d));
		}else{
			ObjectNode result = Json.newObject();
			try {
				Integer count = Certificacion.modificarEstadoMasivo(Estado.CERTIFICACION_ESTADO_IMPUTADO, certificacionesSeleccionados);
				result.put("success", true);
				flash("success", "Se actualizaron " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.<br>"+aviso);
				result.put("html", modalPasarAprobado.render(d).toString());
				return ok(result);
			} catch (Exception e){
				flash("error", "No se puede modificar los registros.");
				return ok(modalPasarAprobado.render(d));
			}
		}
	}
	 */
}
