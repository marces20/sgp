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

import controllers.Secured;

import models.BalancePresupuestario;
import models.Certificacion;
import models.Estado;
import models.Factura;
import models.Pago;
import models.Periodo;
import models.Proveedor;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.validation.DateValidation;
import utils.validation.RequiredValidation;
import utils.validation.Validator;
import views.html.compras.certificaciones.modales.*;
import views.html.contabilidad.facturas.acciones.modalCargarFechaOrdenPago;

@Security.Authenticated(Secured.class)
public class CertificacionesAccionesController extends Controller {
	
	final static Form<Certificacion> certificacionForm = form(Certificacion.class);
	
	public static Result modalCrearAguinaldo() {
		return ok(modalCrearAguinaldo.render(form().bindFromRequest(),null));
	}
	
	public static Result crearAguinaldo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> certificacionesSeleccionados = getSeleccionados();

		if(certificacionesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una certificacion.");
			return ok(modalCrearAguinaldo.render(d,null));
		}	
		
		Integer meses;
		if(request().body().asFormUrlEncoded().get("meses") != null){
			try{
				meses = new Integer(request().body().asFormUrlEncoded().get("meses")[0]);
			}catch(Exception e){
				flash("error", "Debe seleccionar un mes del 1 al 6");
				return ok(modalCrearAguinaldo.render(d,null));
			}
		}else{
			flash("error", "Seleccione meses.");
			return ok(modalCrearAguinaldo.render(d,null));
		}
		
		
		Integer idExpediente;
		if(request().body().asFormUrlEncoded().get("expediente_id_modal_agui") != null){
			try{
				idExpediente = new Integer(request().body().asFormUrlEncoded().get("expediente_id_modal_agui")[0]);
			}catch(Exception e){
				flash("error", "Seleccione un expediente.");
				return ok(modalCrearAguinaldo.render(d,null));
			}	
		}else{
			flash("error", "Seleccione un expediente.");
			return ok(modalCrearAguinaldo.render(d,null));
		}
		
		Integer idPeriodo;							 
		if(request().body().asFormUrlEncoded().get("periodo_id_modal_agui") != null){
			try{
				idPeriodo = new Integer(request().body().asFormUrlEncoded().get("periodo_id_modal_agui")[0]);
			}catch(Exception e){
				flash("error", "Seleccione un periodo.");
				return ok(modalCrearAguinaldo.render(d,null));
			}	
		}else{
			flash("error", "Seleccione un periodo.");
			return ok(modalCrearAguinaldo.render(d,null));
		}
		
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Certificacion.duplicarMasivo(certificacionesSeleccionados,meses,idExpediente,idPeriodo);
			result.put("success", true);
			
			String path = CertificacionesReportesController.getPathReportePlanillaSueldos(certificacionesSeleccionados);
			flash("success", "Se crearon " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.");
			result.put("html", modalCrearAguinaldo.render(d,path).toString());
			
			
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCrearAguinaldo.render(d,null));
		}
	}
	
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
		
		if(!soloCertificado(certificacionesSeleccionados)) {
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
		
		if(!soloBorrador(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(!conExpediente(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(!conLineas(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan lineas.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarEnCurso.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Certificacion.modificarEstadoMasivo(Estado.CERTIFICACION_ESTADO_ENCURSO, certificacionesSeleccionados);
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
		
		if(!soloEnCurso(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en curso.");
			return ok(modalPasarCertificado.render(d));
		}
		
		if(!conExpediente(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
			return ok(modalPasarCertificado.render(d));
		}
		
		if(!conLineas(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan lineas.");
			return ok(modalPasarCertificado.render(d));
		}
		
		if(!Certificacion.soloCuentasAnliticasHijas(certificacionesSeleccionados)){
			flash("error", "Las cuentas presupuestarias deben ser Hijas unicamente.");
			return  ok(modalPasarCertificado.render(d));
		}
	
		if(d.hasErrors())
			return ok(modalPasarCertificado.render(d));	
		
		Certificacion duplicado = unicoMismoAgenteConPeriodoConExpediente(certificacionesSeleccionados);
		if(duplicado != null) {
			flash("error", "Existe una certificación con periodo, expediente y agente duplicado. <br /> <b>Proveedor</b>: " + duplicado.proveedor_id + " " + duplicado.proveedor.nombre);
			return ok(modalPasarCertificado.render(d));
		}
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Certificacion.modificarEstadoMasivoConFechaDeCertificacion(Estado.CERTIFICACION_ESTADO_CERTIFICADO, certificacionesSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.<br>");
			result.put("html", modalPasarCertificado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarCertificado.render(d));
		}		
			
	}
	
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
		
		if(!soloCancelado(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en cancelado.");
			return ok(modalPasarBorrador.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarBorrador.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Certificacion.modificarEstadoMasivo(Estado.CERTIFICACION_ESTADO_BORRADOR, certificacionesSeleccionados);
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
		
		/*if(!soloSinFactura(certificacionesSeleccionados)) {
			flash("error", "Solo se puede modificar registros que esten relacionados con alguna factura.");
			return ok(modalPasarCancelado.render(d));
		} */
		
		if(d.hasErrors())
			return ok(modalPasarCancelado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Certificacion.modificarEstadoMasivo(Estado.CERTIFICACION_ESTADO_CANCELADO, certificacionesSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarCancelado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarCancelado.render(d));
		}
		
	}
	
	
	public static Certificacion unicoMismoAgenteConPeriodoConExpediente(List<Integer> certificacionesSeleccionados) {
		for (Integer id : certificacionesSeleccionados) {
			Certificacion certificacion = Certificacion.find.select("periodo_id, expediente_id, proveedor_id, proveedor.nombre").where().eq("id", id).findUnique();
			List<Certificacion> duplicados = Certificacion.find.select("id").where().eq("proveedor_id", certificacion.proveedor_id).eq("periodo_id", certificacion.periodo_id).eq("expediente_id", certificacion.expediente_id).ne("estado_id", Estado.CERTIFICACION_ESTADO_CANCELADO).ne("estado_id", Estado.CERTIFICACION_ESTADO_BORRADOR).findList();
			if(duplicados.size() > 1) {
				return certificacion;
			}
		}
		return null;
	}
	
	public static Boolean soloCertificado(List<Integer> certificacionesSeleccionados) {
		return Certificacion.find.where().ne("estado_id", Estado.CERTIFICACION_ESTADO_CERTIFICADO).in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloEnCurso(List<Integer> certificacionesSeleccionados) {
		return Certificacion.find.where().ne("estado_id", Estado.CERTIFICACION_ESTADO_ENCURSO).in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloBorrador(List<Integer> certificacionesSeleccionados) {
		return Certificacion.find.where().ne("estado_id", Estado.CERTIFICACION_ESTADO_BORRADOR).in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloCancelado(List<Integer> certificacionesSeleccionados) {
		return Certificacion.find.where().ne("estado_id", Estado.CERTIFICACION_ESTADO_CANCELADO).in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean conExpediente(List<Integer> certificacionesSeleccionados) {
		return Certificacion.find.where().isNull("expediente_id").in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloSinFactura(List<Integer> certificacionesSeleccionados) {
		return Factura.find.where().in("certificacion_id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean conLineas(List<Integer> certificacionesSeleccionados) {
		String sql = " SELECT count(*) cantidad FROM certificaciones c " +
					 " LEFT OUTER JOIN certificaciones_lineas cl ON c.id = cl.certificacion_id" +
					 " WHERE cl.id IS NULL AND c.id in (:listId)" +
					 " GROUP BY c.id";
		
		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("listId", certificacionesSeleccionados).findList();
		 
		return  (l.size() == 0);
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
	
	public static Result modalDuplicarMasivo() {
    	
		return ok( modalDuplicarMasivo.render(form().bindFromRequest()) );
	}
	
	public static Result duplicarMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> certificacionesSeleccionados = getSeleccionados();
		
		if(certificacionesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una certificacion.");
			return ok(modalDuplicarMasivo.render(d));
		}
		
		String periodoId = request().body().asFormUrlEncoded().get("periodo_id_modal")[0];
		String porcentaje = request().body().asFormUrlEncoded().get("porcentaje_modal")[0];	
		String porcentajeTotal = request().body().asFormUrlEncoded().get("total_porcentaje_modal")[0];	
		
		if((porcentaje == null || porcentaje.isEmpty()) && (porcentajeTotal != null && !porcentajeTotal.isEmpty())) {
			flash("error", "Debe ingresar un porcentaje parcial si ingreso un porcentaje total.");
			return ok(modalDuplicarMasivo.render(d));
			 
		}
		
		
		Double porcentajeDouble = new Double(0);
		Double porcentajeTotalDouble = new Double(0);
		 
		if(porcentaje != null && !porcentaje.isEmpty()){
			porcentajeDouble = new Double(porcentaje);
		}
		if(porcentajeTotal != null && !porcentajeTotal.isEmpty()){
			porcentajeTotalDouble = new Double(porcentajeTotal);
		}
		
		Integer periodoIdInt = new Integer(0);
		
		if(periodoId != null){
			periodoIdInt = new Integer(periodoId);
		}else{
			d.reject("periodo_id_modal","Debe ingresar un periodo");
		}
		
		if(d.hasErrors())
			return ok(modalDuplicarMasivo.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = 0 ;
			if((porcentaje != null && !porcentaje.isEmpty()) && (porcentajeTotal != null && !porcentajeTotal.isEmpty())){
				count = Certificacion.duplicarMasivoSinPreaumento(certificacionesSeleccionados,periodoIdInt,porcentajeDouble,porcentajeTotalDouble);
			}else{
				count = Certificacion.duplicarMasivo(certificacionesSeleccionados,periodoIdInt,porcentajeDouble);
			}
			
			
			result.put("success", true);
			flash("success", "Se duplicaron " + count + " registros de "+ certificacionesSeleccionados.size() +" seleccionados.");
			result.put("html", modalDuplicarMasivo.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede duplicar los registros.");
			return ok(modalDuplicarMasivo.render(d));
		}
	}
	
	public static Result modalDetalleCertificacion(Long id) {
		
		Certificacion c = Certificacion.find.byId(id);
		
		return ok(modalDetalleCertificacion.render(c));
	}
	
	public static Result modalDetalleCertificacionesPorEstadoPorPeriodo(String nombrePeriodo,Integer estado,Integer proveedorId) {
		
		Integer estadoId = (estado != null && estado == 1)?Estado.CERTIFICACION_ESTADO_CERTIFICADO:(estado != null && estado == 2)?Estado.CERTIFICACION_ESTADO_IMPUTADO:null;
		
		Periodo p = Periodo.find.where().eq("nombre", nombrePeriodo).findUnique();
		List<Certificacion> c = Certificacion.find.where().eq("periodo_id",p.id).eq("estado_id",estadoId).eq("proveedor_id", proveedorId).findList();
		
		return ok(modalDetalleCertificacionesPorEstadoPorPeriodo.render(c));
	}
}
