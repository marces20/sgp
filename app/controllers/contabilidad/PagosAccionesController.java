package controllers.contabilidad;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.BalanceCuentaPropia;
import models.Certificacion;
import models.CuentaBancaria;
import models.DireccionProveedor;
import models.Estado;
import models.Factura;
import models.FacturaDato;
import models.MiPago;
import models.Pago;
import models.Periodo;
import models.Proveedor;
import models.Usuario;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.StringUtils;
import utils.UriTrack;
import utils.validation.DateValidation;
import utils.validation.RequiredValidation;
import utils.validation.Validator;
import views.html.contabilidad.facturas.acciones.modalPasarAprobado;
import views.html.contabilidad.pagos.editarPagoProveedor;
import views.html.contabilidad.pagos.acciones.*;
import views.html.haberes.liquidacionAcciones.reporteBanco;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class PagosAccionesController extends Controller {

	final static Form<Pago> pagoForm = form(Pago.class);

	public static Result modalCrearRefenciaEmbargos() {
		return ok(modalCrearRefenciaEmbargos.render(form().bindFromRequest()));
	}

	public static Result crearRefenciaEmbargos(){

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalCrearRefenciaEmbargos.render(d));
		}

		if(!soloBorrador(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalCrearRefenciaEmbargos.render(d));
		}

		String refExterna = "EMBARGOS-EXTERNOS-"+utils.DateUtils.formatDate(new Date(),"dd-MM-yyyy HHmm");
		String refMacro = "EMBARGOS-MACRO-"+utils.DateUtils.formatDate(new Date(),"dd-MM-yyyy HHmm");

		List<Pago> controlReferenciaNueva = Pago.find.where()
											.disjunction()
											.eq("referencia",refExterna)
											.eq("referencia",refMacro)
											.endJunction()
											.findList();
		if(controlReferenciaNueva.size() > 0) {
			flash("error", "NO ES POSIBLE CREAR LA REFERENCIA PQ YA EXISTE PAGOS CON REF. "+refExterna+" o "+refMacro);
			return ok(modalCrearRefenciaEmbargos.render(d));
		}

		List<Integer> pagosExternos = new ArrayList<Integer>();
		List<Integer> pagosMacro = new ArrayList<Integer>();

		String errorStr= "";
		boolean error = false;


		ObjectNode result = Json.newObject();
		try {

			List<Pago> lp = Pago.find.where().in("id",pagosSeleccionados).findList();

			for(Pago p :lp) {
				CuentaBancaria cc = null;
				for (CuentaBancaria cuenta : p.proveedor.cuenta) {
					if(cuenta.predeterminada && cuenta.estado_id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
						 cc = cuenta;
					}
				}

				if(cc == null) {
					errorStr += p.proveedor.nombre+ " NO TIENE CUENTA DEFINIDA,APROBADA o PREDETERMINADA.<br>";
					error = true;
				}else if(cc.banco_id.compareTo(new Long(1)) == 0){
					pagosMacro.add(p.id.intValue());
				}else if(cc.banco_id.compareTo(new Long(1)) != 0){
					pagosExternos.add(p.id.intValue());
				}
			}

			if(error) {
				flash("error", errorStr);
				return ok(modalCrearRefenciaEmbargos.render(d));
			}

			if(pagosExternos.size() > 0) {
				Integer countEX = Pago.modificarReferenciaMasiva(refExterna, pagosExternos);
			}

			if(pagosMacro.size() > 0) {
				Integer count = Pago.modificarReferenciaMasiva(refMacro, pagosMacro);
			}

			result.put("success", true);
			flash("success", "Se actualizaron   registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalCrearRefenciaEmbargos.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalCrearRefenciaEmbargos.render(d));
		}


	}

	public static Result modalModificarFechaCancelacion() {
		return ok(modalModificarFechaCancelacion.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosModificarFechaCancelacionMasivamente")
	public static Result modificarFechaCancelacion() {

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		Validator v = new Validator(d);
		v.add(new RequiredValidation("fecha_cancelacion", "Fecha requerida"));
		v.add(new DateValidation("fecha_cancelacion", "Fecha inválida"));
		v.validate();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalModificarFechaCancelacion.render(d));
		}

		if(Pago.controlRefenciasDistintas(pagosSeleccionados)){
			flash("error", "Para las acciones masivas debe seleccionar todos los pagos con las mismas referencias.");
			return ok(modalModificarFechaCancelacion.render(d));
		}

		if(Pago.controlHayReferenciaRepetidaDesdeLista(pagosSeleccionados)){
			flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
			return ok(modalModificarFechaCancelacion.render(d));
		}


		if(d.hasErrors())
			return ok(modalModificarFechaCancelacion.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Pago.modificarFechaCancelacionMasiva(utils.DateUtils.formatDate(d.get("fecha_cancelacion"), "dd/MM/yyyy"), pagosSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalModificarFechaCancelacion.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarFechaCancelacion.render(d));
		}
	}

	public static Result modalModificarFechaConciliado() {
		return ok(modalModificarFechaConciliado.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosModificarFechaConciliadoMasivamente")
	public static Result modificarFechaConciliado() {

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		Validator v = new Validator(d);
		v.add(new RequiredValidation("fecha_conciliado", "Fecha requerida"));
		v.add(new DateValidation("fecha_conciliado", "Fecha inválida"));
		v.validate();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalModificarFechaConciliado.render(d));
		}

		/*if(!soloPagados(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado pagado.");
			return ok(modalModificarFechaConciliado.render(d));
		}*/

		if(Pago.controlRefenciasDistintas(pagosSeleccionados)){
			flash("error", "Para las acciones masivas debe seleccionar todos los pagos con las mismas referencias.");
			return ok(modalModificarFechaConciliado.render(d));
		}

		if(Pago.controlHayReferenciaRepetidaDesdeLista(pagosSeleccionados)){
			flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
			return ok(modalModificarFechaConciliado.render(d));
		}

		if(d.hasErrors())
			return ok(modalModificarFechaConciliado.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Pago.modificarFechaConciliacionMasiva(utils.DateUtils.formatDate(d.get("fecha_conciliado"), "dd/MM/yyyy"), pagosSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalModificarFechaConciliado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarFechaConciliado.render(d));
		}
	}

	public static Result modalModificarFecha() {
		return ok(modalModificarFecha.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosModificarFechaMasivamente")
	public static Result modificarFecha() {

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		Validator v = new Validator(d);
		v.add(new RequiredValidation("fecha_pago", "Fecha requerida"));
		v.add(new DateValidation("fecha_pago", "Fecha inválida"));
		v.validate();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalModificarFecha.render(d));
		}

		if(!soloBorrador(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalModificarFecha.render(d));
		}

		if(Pago.controlRefenciasDistintas(pagosSeleccionados)){
			flash("error", "Para las acciones masivas debe seleccionar todos los pagos con las mismas referencias.");
			return ok(modalModificarFecha.render(d));
		}

		if(Pago.controlHayReferenciaRepetidaDesdeLista(pagosSeleccionados)){
			flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
			return ok(modalModificarFecha.render(d));
		}

		if(d.hasErrors())
			return ok(modalModificarFecha.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Pago.modificarFechaMasiva(utils.DateUtils.formatDate(d.get("fecha_pago"), "dd/MM/yyyy"), pagosSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalModificarFecha.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarFecha.render(d));
		}
	}

	@CheckPermiso(key = "pagosModificarNumeroFactura")
	public static Result modalModificarNumeroFactura(Long id) {


		Pago p = Pago.find.byId(id);


		return ok(modalModificarNumeroFactura.render(form().bindFromRequest(),id,p));
	}

	@CheckPermiso(key = "pagosModificarNumeroFactura")
	public static Result modificarNumeroFactura() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();



		String numero_factura =request().body().asFormUrlEncoded().get("numero_factura")[0];
		String monto =request().body().asFormUrlEncoded().get("monto")[0];
		Long id = new Long(request().body().asFormUrlEncoded().get("id")[0]);
		Pago p = Pago.find.byId(id);
		Factura f = Factura.find.byId((long) p.factura_id);


		if(numero_factura.isEmpty()) {
			flash("error", "Ingrese un N° de Factura");
			return ok(modalModificarNumeroFactura.render(d,id,p));
		}

		if(monto.isEmpty()) {
			flash("error", "Ingrese un monto");
			return ok(modalModificarNumeroFactura.render(d,id,p));
		}


		if(f.factura_principal_id != null && f.facturaPrincipal.numero_factura != null && !f.facturaPrincipal.numero_factura.isEmpty()) {

			String nff = f.facturaPrincipal.numero_factura.replace("-","").replace(" ","");
			String nfp =numero_factura.replace("-","").replace(" ","");

			if(nff.compareToIgnoreCase(nfp) != 0) {
				flash("error", "El N° de factura Principal cargada no coincide con el N° de factura que se está cargando. N°FACTURA: "+f.facturaPrincipal.numero_factura);
				return ok(modalModificarNumeroFactura.render(d,id,p));
			}

		}

		if(Factura.existeNumeroFacturaCargado(f.id, numero_factura)) {
			flash("error", "Ya existe este numero de factura cargado.");
			return ok(modalModificarNumeroFactura.render(d,id,p));
		}


		BigDecimal montoACargar = new BigDecimal(monto.replace(",","."));
		BigDecimal montoCargado = Factura.getTotalMontoFacturasCargadas(f.id);
		BigDecimal montoTotal = montoCargado.add(montoACargar);

		if(montoTotal.compareTo(f.orden.getTotalTotal()) > 0) {
			flash("error", "Los montos de facturas excede el monto de la orden.");
			return ok(modalModificarNumeroFactura.render(d,id,p));
		}




		ObjectNode result = Json.newObject();
		try {
			//Integer count = Pago.modificarNumeroFactura(numero_factura, id);

			FacturaDato fd = new FacturaDato();
			fd.numero_factura = numero_factura;
			fd.factura_id = f.id;
			fd.orden_id = (f.orden_id != null)?f.orden_id.longValue():null;
			fd.monto = new BigDecimal(monto.replace(",","."));
			fd.create_date = new Date();
			fd.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			fd.save();


			result.put("success", true);
			flash("success", "Se actualizado el Numero de factura");
			result.put("html", modalModificarNumeroFactura.render(d,id,p).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarNumeroFactura.render(d,id,p));
		}

	}

	@CheckPermiso(key = "pagosModificarTipoPago")
	public static Result modalModificarTipoPago() {
		return ok(modalModificarTipoPago.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosModificarTipoPago")
	public static Result modificarTipoPago() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();


		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalModificarTipoPago.render(d));
		}

		if(!soloBorrador(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalModificarTipoPago.render(d));
		}

		if(Pago.controlRefenciasDistintas(pagosSeleccionados)){
			flash("error", "Para las acciones masivas debe seleccionar todos los pagos con las mismas referencias.");
			return ok(modalModificarTipoPago.render(d));
		}

		if(Pago.controlHayReferenciaRepetidaDesdeLista(pagosSeleccionados)){
			flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
			return ok(modalModificarTipoPago.render(d));
		}

		if(d.hasErrors())
			return ok(modalModificarTipoPago.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Pago.modificarTipoPago(d.get("tipo_pago"), pagosSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalModificarTipoPago.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarTipoPago.render(d));
		}
	}

	@CheckPermiso(key = "pagosModificarNumeroCheque")
	public static Result modalModificarNumeroCheque() {
		return ok(modalModificarNumeroCheque.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosModificarNumeroCheque")
	public static Result modificarNumeroCheque() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		Validator v = new Validator(d);
		v.add(new RequiredValidation("numero_cheque", "Requiere numero cheque"));
		v.validate();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalModificarNumeroCheque.render(d));
		}

		if(!soloBorrador(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalModificarNumeroCheque.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id")
									.where()
									.in("id",pagosSeleccionados)
									.disjunction()
									.eq("tipo_pago","transferencia")
									.eq("tipo_pago","transferenciaMacroProveedores")
									.eq("tipo_pago","transferenciaInterbanking")
									.endJunction()
									.findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los cambios deben ser solamente para cheques.");
			return ok(modalModificarNumeroCheque.render(d));
		}

		if(d.hasErrors())
			return ok(modalModificarNumeroCheque.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Pago.modificarNumeroCheque(d.get("numero_cheque"), pagosSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalModificarNumeroCheque.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarNumeroCheque.render(d));
		}
	}

	@CheckPermiso(key = "pagosModificarNumeroRecibo")
	public static Result modalModificarNumeroRecibo(Long id) {
		return ok(modalModificarNumeroRecibo.render(form().bindFromRequest(),id));
	}

	@CheckPermiso(key = "pagosModificarNumeroRecibo")
	public static Result modificarNumeroRecibo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		String numero_recibo =request().body().asFormUrlEncoded().get("numero_recibo")[0];
		Long id = new Long(request().body().asFormUrlEncoded().get("id")[0]);


		ObjectNode result = Json.newObject();
		try {
			Integer count = Pago.modificarNumeroRecibo(numero_recibo, id);
			result.put("success", true);
			flash("success", "Se actualizado el Numero de recibo");
			result.put("html", modalModificarNumeroRecibo.render(d,id).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarNumeroRecibo.render(d,id));
		}

	}

	public static Result modalModificarPaguese() {
		return ok(modalModificarPaguese.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosModificarPagueseMasivamente")
	public static Result modificarPaguese() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalModificarPaguese.render(d));
		}

		if(!soloBorrador(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalModificarPaguese.render(d));
		}



		if(d.hasErrors())
			return ok(modalModificarPaguese.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Pago.modificarPagueseMasiva(d.get("paguese"), pagosSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalModificarPaguese.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarPaguese.render(d));
		}
	}


	public static Result modalModificarReferencia() {
		return ok(modalModificarReferencia.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosModificarReferenciaMasivamente")
	public static Result modificarReferencia() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		/*Validator v = new Validator(d);
		v.add(new RequiredValidation("referencia", "Referencia requerida"));
		v.validate();*/

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalModificarReferencia.render(d));
		}

		if(!soloBorrador(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalModificarReferencia.render(d));
		}

		if(soloUnaCuenta(pagosSeleccionados)) {
			flash("error", "No se puede cambiar la referencia a pagos con distintas cuentas a la misma vez.");
			return ok(modalModificarReferencia.render(d));
		}

		if(d.get("referencia").isEmpty()){
			flash("error", "Debe ingresar una referencia.");
			return ok(modalModificarReferencia.render(d));
		}

		if(!d.get("referencia").isEmpty()){
			if(Pago.controlHayReferenciaRepetida(d.get("referencia"),pagosSeleccionados)){
				flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
				return ok(modalModificarReferencia.render(d));
			}
		}else{
			if(Pago.controlHayReferenciaRepetidaDesdeLista(pagosSeleccionados,true)){
				flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
				return ok(modalModificarReferencia.render(d));
			}
		}

		if(d.hasErrors())
			return ok(modalModificarReferencia.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Pago.modificarReferenciaMasiva(d.get("referencia"), pagosSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalModificarReferencia.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarReferencia.render(d));
		}
	}

	public static Result modalPagarDebitos(){
		return ok(modalPagarDebitos.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPagarCheques")
	public static Result pagarDebitos(){

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalPagarDebitos.render(d));
		}

		if(!soloBorrador(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalPagarDebitos.render(d));
		}

		//Verifico que no hay fechas vacias
		List<Pago> listPago = Pago.find.select("id").where().in("id", pagosSeleccionados).isNull("fecha_pago").findList();
		if(listPago.size() > 0) {
			flash("error", "Los pagos deben tener fecha de pago.");
			return ok(modalPagarDebitos.render(d));
		}



		//Verifico que no haya cheques
		/*Integer soloTransferencias = Pago.find.select("id").where()
							.eq("referencia", referencia)
							.disjunction()
							.eq("tipo_pago","transferencia")
							.eq("tipo_pago","transferenciaMacroProveedores")
							.eq("tipo_pago","transferenciaInterbanking")
							.endJunction()
							.findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los pagos deben ser solamente para cheques.");
			return ok(modalPagarCheques.render(d));
		}*/

		List<Pago> listPago2 = Pago.find.select("id").where().in("id", pagosSeleccionados).findList();
		Ebean.beginTransaction();
		try {
			for(Pago pp :listPago2){
				MiPago mipago = new MiPago();
				mipago.fecha = new Date();
				mipago.tipo = MiPago.Tipo.PROVEEDORES_EXTERNOS.key();
				mipago.save();

				int pagosRealizados = Pago.contabilizarPagos(pp.referencia, mipago.id);
				pagosRealizados = Pago.conciliarPagosMasivo(pp.referencia, mipago.id);
				BalanceCuentaPropia.insertUpdateDesdeListaPago(pp.referencia,false);


			}

			flash("success", "Se han generado  pagos.");
			Ebean.commitTransaction();

			return ok(modalPagarDebitos.render(d));

		} catch (Exception e) {
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();
		}

		return ok(modalPagarDebitos.render(d));
	}

	public static Result modalPagarCheques(){
		return ok(modalPagarCheques.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPagarCheques")
	public static Result pagarCheques(){
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		Validator v = new Validator(d);
		v.add(new RequiredValidation("referencia", "Referencia requerida"));
		v.validate();

		if(d.hasErrors())
			return ok(modalPagarCheques.render(d));

		//Tomo la referencia enviada del formulario
		String referencia = d.get("referencia");

		//Verifico que no hay fechas vacias
		Integer soloConFechaPago = Pago.find.select("id").where().eq("referencia", referencia).isNull("fecha_pago").findRowCount();
		if(soloConFechaPago > 0) {
			flash("error", "Los pagos deben tener fecha de pago.");
			return ok(modalPagarCheques.render(d));
		}

		if(!conFechaPagoVieja(referencia) && !Usuario.getUsurioSesion().id.equals(401)){
			flash("error", "No se pueden aprobar pagos con fecha de pago menor del ejercicio actual.");
			return ok(modalPagarCheques.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id").where()
							.eq("referencia", referencia)
							.disjunction()
							.eq("tipo_pago","transferencia")
							.eq("tipo_pago","transferenciaMacroProveedores")
							.eq("tipo_pago","transferenciaInterbanking")
							.endJunction()
							.findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los pagos deben ser solamente para cheques.");
			return ok(modalPagarCheques.render(d));
		}

		Ebean.beginTransaction();
		try {
			MiPago mipago = new MiPago();
			mipago.fecha = new Date();
			mipago.tipo = MiPago.Tipo.PROVEEDORES_EXTERNOS.key();
			mipago.save();

			int pagosRealizados = Pago.contabilizarPagos(referencia, mipago.id);
			//int pagosRealizados = Pago.conciliarPagos(referencia, mipago.id);
			BalanceCuentaPropia.insertUpdateDesdeListaPago(referencia,false);

			flash("success", "Se han generado " + pagosRealizados + " pagos.");
			Ebean.commitTransaction();

			return ok(resultadoPagarProveedoresExternos.render());

		} catch (Exception e) {
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();
		}

		return ok(modalPagarCheques.render(d));
	}

	public static Result modalPagarProveedoresExternos(){
		return ok(modalPagarProveedoresExternos.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPagarProveedoresExternos")
	public static Result pagarProveedoresExternos(){
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		Validator v = new Validator(d);
		v.add(new RequiredValidation("referencia", "Referencia requerida"));
		v.validate();

		if(d.hasErrors())
			return ok(modalPagarProveedoresExternos.render(d));

		//Tomo la referencia enviada del formulario
		String referencia = d.get("referencia");

		//Verifico que no hay fechas vacias
		Integer soloConFechaPago = Pago.find.select("id").where().eq("referencia", referencia).isNull("fecha_pago").findRowCount();
		if(soloConFechaPago > 0) {
			flash("error", "Los pagos deben tener fecha de pago.");
			return ok(modalPagarProveedoresExternos.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id").where().eq("referencia", referencia).eq("tipo_pago","cheque").findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los pagos deben ser solamente para transferencias.");
			return ok(modalPagarProveedoresExternos.render(d));
		}

		//Verifico que los pagos seleccionados sean solo para proveedores tipo externos
		Integer noAgentes = Pago.find.select("id").where().eq("referencia", referencia)
							.eq("estado_id", Estado.PAGO_ESTADO_BORRADOR)
							.isNotNull("proveedor.agente_id").findRowCount();
		if(noAgentes > 0) {
			flash("error", "Los pagos deben ser solamente para proveedores externos.");
			return ok(modalPagarProveedoresExternos.render(d));
		}

		String cptm = controlesPagosTransferenciasMasivas(referencia);
		if(!cptm.isEmpty()){
			flash("error", cptm);
			return ok(modalPagarProveedoresExternos.render(d));
		}

		if(!conFechaPagoVieja(referencia) && !Usuario.getUsurioSesion().id.equals(401)){
			flash("error", "No se pueden aprobar pagos con fecha de pago menor del ejercicio actual.");
			return ok(modalPagarProveedoresExternos.render(d));
		}

		Ebean.beginTransaction();
		try {
			MiPago mipago = new MiPago();
			mipago.fecha = new Date();
			mipago.tipo = MiPago.Tipo.PROVEEDORES_EXTERNOS.key();
			mipago.save();

			int pagosRealizadosx = Pago.contabilizarPagos(referencia, mipago.id);
			int pagosRealizados = Pago.conciliarPagosMasivo(referencia, mipago.id);

			BalanceCuentaPropia.insertUpdateDesdeListaPago(referencia,false);

			flash("success", "Se han generado " + pagosRealizados + " pagos.");
			Ebean.commitTransaction();

			return ok(resultadoPagarProveedoresExternos.render());

		} catch (Exception e) {
			play.Logger.debug("zzzzzzzzzzzzzzzzzzzzz "+e );
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();
		}

		return ok(modalPagarProveedoresExternos.render(d));
	}

	public static String controlesPagosTransferenciasMasivas(String referenciaPago) {
		String r = "";

		List<SqlRow> controlReferencia = Ebean.createSqlQuery("SELECT cuenta_propia_id FROM pagos WHERE referencia = :referenciaPago GROUP BY cuenta_propia_id")
				.setParameter("referenciaPago",referenciaPago).findList();
		if(controlReferencia.size() > 1){
			r += "Los pagos deben ser todos de la misma cuenta propia. <br>";
		}

		List<SqlRow> controlFechaPago = Ebean.createSqlQuery("SELECT fecha_pago FROM pagos WHERE referencia = :referenciaPago GROUP BY fecha_pago")
				.setParameter("referenciaPago",referenciaPago).findList();
		if(controlFechaPago.size() > 1){
			r += "Los pagos deben tener todos la misma fecha de pago. <br>";
		}

		List<SqlRow> controlNumeroCheque = Ebean.createSqlQuery("SELECT * FROM pagos WHERE referencia = :referenciaPago AND numero_cheque IS NOT NULL AND TRIM (numero_cheque) <> '' ")
				.setParameter("referenciaPago",referenciaPago).findList();
		if(controlNumeroCheque.size() > 0){
			r += "Los pagos por referencia no deben tener numero de cheque cargado. <br>";
		}

		List<SqlRow> controlTipoPago = Ebean.createSqlQuery("SELECT tipo_pago FROM pagos WHERE referencia = :referenciaPago GROUP BY tipo_pago")
		.setParameter("referenciaPago",referenciaPago).findList();
		if(controlTipoPago.size() > 1){
			r += "Los pagos deben tener todos el mismo tipo de pago. <br>";
		}

		return r;
	}
	public static Pago unicoMismoAgenteConPeriodoConExpediente(String referenciaPago) {
		List<Pago> pagos = Pago.find.select("periodo_id, expediente_id, proveedor_id, proveedor.nombre").where().eq("referencia", referenciaPago).findList();
		for (Pago pago : pagos) {
			List<Pago> duplicados = Pago.find.select("id").where().eq("proveedor_id", pago.proveedor_id).eq("periodo_id", pago.periodo_id).eq("expediente_id", pago.expediente_id).ne("estado_id", Estado.PAGO_ESTADO_CANCELADO).findList();

			if(duplicados.size() > 1) {
				return pago;
			}
		}
		return null;
	}

	public static Result modalPagarPlanta(){
		return ok(modalPagarPlanta.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPagarAgentesPlanta")
	public static Result pagarPlanta(){

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		Validator v = new Validator(d);
		v.add(new RequiredValidation("referencia", "Referencia requerida"));
		v.validate();

		if(d.hasErrors())
			return ok(modalPagarPlanta.render(d));

		//Tomo la referencia enviada del formulario
		String referencia = d.get("referencia");

		//Verifico que no hay fechas vacias
		Integer soloConFechaPago = Pago.find.select("id").where().eq("referencia", referencia).isNull("fecha_pago").findRowCount();
		if(soloConFechaPago > 0) {
			flash("error", "Los pagos deben tener fecha de pago.");
			return ok(modalPagarPlanta.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id").where().eq("referencia", referencia).eq("tipo_pago","cheque").findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los pagos deben ser solamente para transferencias.");
			return ok(modalPagarPlanta.render(d));
		}

		if(!conFechaPagoVieja(referencia) && !Usuario.getUsurioSesion().id.equals(401)){
			flash("error", "No se pueden aprobar pagos con fecha de pago menor del ejercicio actual.");
			return ok(modalPagarPlanta.render(d));
		}

		//Verifico que los pagos seleccionados sean solo para agentes en planta
		Integer noPlanta = Pago.find.select("id").where()
				.eq("referencia", referencia)
				.disjunction()
				.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
				.eq("proveedor.agente.planta", false)
				.isNull("proveedor.agente.id")
				.findRowCount();
		if(noPlanta > 0) {
			flash("error", "Los pagos deben ser solamente para agentes de tipo planta y en estado borrador.");
			return ok(modalPagarPlanta.render(d));
		}

		String m = esPagoConExpedienteSinCertificacion(referencia);
		if(m != null){
			String ee = "Los pagos deben ser solamente para expedientes que esten en certificaciones.<br>";
				   ee += m;
			flash("error", ee);
			return ok(modalPagarPlanta.render(d));
		}

		String cptm = controlesPagosTransferenciasMasivas(referencia);
		if(!cptm.isEmpty()){
			flash("error", cptm);
			return ok(modalPagarPlanta.render(d));
		}

		Ebean.beginTransaction();
		try {
			MiPago mipago = new MiPago();
			mipago.fecha = new Date();
			mipago.tipo = MiPago.Tipo.AGENTE_PLANTA.key();
			mipago.save();

			int pagosRealizadosx = Pago.contabilizarPagos(referencia, mipago.id);
			int pagosRealizados = Pago.conciliarPagosMasivo(referencia, mipago.id);

			BalanceCuentaPropia.insertUpdateDesdeListaPago(referencia,false);

			flash("success", "Se han generado " + pagosRealizados + " pagos.");
			Ebean.commitTransaction();

			return ok(resultadoPagarPlanta.render());

		} catch (Exception e) {
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();
		}

		return ok(modalPagarPlanta.render(d));
	}

	public static Result modalPagarInterno() {
		return ok(modalPagarInterno.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPagarAgentesContratados")
	public static Result pagarInterno(){

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		Validator v = new Validator(d);
		v.add(new RequiredValidation("referencia", "Referencia requerida"));
		v.validate();

		if(d.hasErrors())
			return ok(modalPagarInterno.render(d));

		//Tomo la referencia enviada del formulario
		String referencia = d.get("referencia");

		//Verifico que no hay fechas vacias
		Integer soloConFechaPago = Pago.find.select("id").where().eq("referencia", referencia).isNull("fecha_pago").findRowCount();
		if(soloConFechaPago > 0) {
			flash("error", "Los pagos deben tener fecha de pago.");
			return ok(modalPagarInterno.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id").where().eq("referencia", referencia).eq("tipo_pago","cheque").findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los pagos deben ser solamente para transferencias.");
			return ok(modalPagarInterno.render(d));
		}

		//Verifico que los pagos seleccionados sean solo para proveedores activos
		Integer agentesInactivos = Pago.find.select("id").where().eq("referencia", referencia).eq("proveedor.activo", false).findRowCount();
		if(agentesInactivos > 0) {
			flash("error", "Los pagos deben ser solamente para agentes contratados activos.");
			return ok(modalPagarInterno.render(d));
		}

		//Verifico que los pagos seleccionados sean solo para proveedores tipo agentes internos
		Integer noAgentes = Pago.find.select("id").where().eq("referencia", referencia).disjunction().ne("estado_id", Estado.PAGO_ESTADO_BORRADOR).eq("proveedor.agente.planta", true).isNull("proveedor.agente.id").findRowCount();
		if(noAgentes > 0) {
			flash("error", "Los pagos deben ser solamente para agentes contratados y en estado borrador.");
			return ok(modalPagarInterno.render(d));
		}

		Integer noAgentePagoExterno = Pago.find.select("id").where().eq("referencia", referencia).eq("agente_pago_externo", true).findRowCount();
		if(noAgentePagoExterno > 0) {
			flash("error", "Los pagos no debe ser para agentes pago externo.");
			return ok(modalPagarInterno.render(d));
		}

		String m = esPagoConExpedienteSinCertificacion(referencia);
		if(m != null){
			String ee = "Los pagos deben ser solamente para expedientes que esten en certificaciones.<br>";
				   ee += m;
			flash("error", ee);
			return ok(modalPagarInterno.render(d));
		}

		//Verifico si hay pagos con mismo agente, expediente y periodo
		Pago duplicado = unicoMismoAgenteConPeriodoConExpediente(referencia);
		if(duplicado != null) {
			flash("error", "Existe un pago con periodo, expediente y agente duplicado. <br /> <b>Proveedor</b>: " + duplicado.proveedor_id + " " + duplicado.proveedor.nombre);
			return ok(modalPagarInterno.render(d));
		}

		String cptm = controlesPagosTransferenciasMasivas(referencia);
		if(!cptm.isEmpty()){
			flash("error", cptm);
			return ok(modalPagarInterno.render(d));
		}

		if(!conFechaPagoVieja(referencia) && !Usuario.getUsurioSesion().id.equals(401)){
			flash("error", "No se pueden aprobar pagos con fecha de pago menor del ejercicio actual.");
			return ok(modalPagarInterno.render(d));
		}

		Ebean.beginTransaction();
		try {
			MiPago mipago = new MiPago();
			mipago.fecha = new Date();
			mipago.tipo = MiPago.Tipo.AGENTE_CONTRATADO.key();
			mipago.save();

			int pagosRealizadosx = Pago.contabilizarPagos(referencia, mipago.id);
			int pagosRealizados = Pago.conciliarPagosMasivo(referencia, mipago.id);

			BalanceCuentaPropia.insertUpdateDesdeListaPago(referencia,false);

			String error = "";
			for (Pago pago : Pago.find.where().eq("mis_pagos_id", mipago.id).findList()) {
				error += getErrorProveedor(pago);
			}
			if(!error.isEmpty()) {
				flash("error", error);
			} else {
				Ebean.commitTransaction();
				flash("success", "Se han generado " + pagosRealizados + " pagos.");
				return ok(resultadoPagarInterno.render(mipago));
			}

		} catch (Exception e) {
			Ebean.rollbackTransaction();
			e.printStackTrace();
		} finally {
			Ebean.endTransaction();
		}

		return ok(modalPagarInterno.render(d));
	}
	////////////////////////////////////////////////////////
	@CheckPermiso(key = "pagosPagarProveedoresInterbanking")
	public static Result modalPagarInterbankingProveedores(){
		return ok(modalPagarInterbankingProveedores.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPagarProveedoresInterbanking")
	public static Result pagarInterbankingProveedores(){
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		Validator v = new Validator(d);
		v.add(new RequiredValidation("referencia", "Referencia requerida"));
		v.validate();

		if(d.hasErrors())
			return ok(modalPagarInterbankingProveedores.render(d));

		String referencia = d.get("referencia");
		//Verifico que no hay fechas vacias
		Integer soloConFechaPago = Pago.find.select("id").where().eq("referencia", referencia).isNull("fecha_pago").findRowCount();
		if(soloConFechaPago > 0) {
			flash("error", "Los pagos deben tener fecha de pago.");
			return ok(modalPagarInterbankingProveedores.render(d));
		}

		Integer soloConFechaConciliacion = Pago.find.select("id").where().eq("referencia", referencia).isNull("fecha_conciliacion").findRowCount();
		if(soloConFechaConciliacion > 0) {
			flash("error", "Los pagos deben tener fecha de conciliacion.");
			return ok(modalPagarInterbankingProveedores.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id").where().eq("referencia", referencia).eq("tipo_pago","cheque").findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los pagos deben ser solamente para transferencias.");
			return ok(modalPagarInterbankingProveedores.render(d));
		}

		Integer soloBorrador = Pago.find.select("id").where().eq("referencia", referencia).ne("estado_id", Estado.PAGO_ESTADO_BORRADOR).findRowCount();
		if(soloBorrador > 0) {
			flash("error", "Los pagos deben ser solamente en estado borrador.");
			return ok(modalPagarInterbankingProveedores.render(d));
		}

		Integer soloInterbanking = Pago.find.select("id").where().eq("referencia", referencia).ne("tipo_pago","transferenciaInterbanking").findRowCount();
		if(soloInterbanking > 0) {
			flash("error", "Los pagos deben ser solamente tipo Interbanking.");
			return ok(modalPagarInterbankingProveedores.render(d));
		}

		if(!conFechaPagoVieja(referencia) && !Usuario.getUsurioSesion().id.equals(401)){
			flash("error", "No se pueden aprobar pagos con fecha de pago menor del ejercicio actual.");
			return ok(modalPagarInterbankingProveedores.render(d));
		}

		List<SqlRow> controlFechaPago = Ebean.createSqlQuery("SELECT fecha_conciliacion FROM pagos WHERE referencia = :referenciaPago GROUP BY fecha_conciliacion")
										.setParameter("referenciaPago",referencia).findList();
		if(controlFechaPago.size() > 1){
			flash("error", "Los pagos deben tener todos la misma fecha de conciliacion.");
			return ok(modalPagarInterbankingProveedores.render(d));
		}



		String cptm = controlesPagosTransferenciasMasivas(referencia);
		if(!cptm.isEmpty()){
			flash("error", cptm);
			return ok(modalPagarInterbankingProveedores.render(d));
		}


		Ebean.beginTransaction();
		try {
			MiPago mipago = new MiPago();
			mipago.fecha = new Date();
			mipago.tipo = MiPago.Tipo.PROVEEDORES_EXTERNOS.key();
			mipago.save();

			int pagosRealizadosx = Pago.contabilizarPagos(referencia, mipago.id);
			int pagosRealizados = Pago.conciliarPagosMasivo(referencia, mipago.id);

			BalanceCuentaPropia.insertUpdateDesdeListaPago(referencia,false);

			String error = "";
			for (Pago pago : Pago.find.where().eq("mis_pagos_id", mipago.id).findList()) {
				error += getErrorProveedorEmbargoExterno(pago,false);
			}
			if(!error.isEmpty()) {
				flash("error", error);
			} else {
				Ebean.commitTransaction();
				flash("success", "Se han generado " + pagosRealizados + " pagos.");
				return ok(resultadoPagarInterbankingProveedores.render(mipago));
			}

		} catch (Exception e) {
			Ebean.rollbackTransaction();
			e.printStackTrace();
		} finally {
			Ebean.endTransaction();
		}



		return ok(modalPagarInterbankingProveedores.render(d));
	}

	public static Result descargarArchivoInterbankingProveedores(Long id){

		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		String data = "";
		Boolean hayError = false;
		try {
			File archivoOPG = new File(dirTemp+"/interbankingProveedores.txt");
			File errorOPG = new File(dirTemp+"/mensajeInterbankingProveedores.txt");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoOPG), "UTF8"));
			Writer outError = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorOPG), "UTF8"));

			List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", id).findList();

			if(pagos.size() > 0) {

				Pago p1 = pagos.get(0);

				data += StringUtils.alfanumerico("*U*", 3);//01-03 |X03 |Tipo de registros Contiene M
				data += StringUtils.alfanumerico("2850001030094087692271", 22);//04-25 |X22 |Numero CBU
				data += StringUtils.alfanumerico("D", 1);//26-26|x01|debito D o Credito C
				data += StringUtils.alfanumerico(utils.DateUtils.formatDate(p1.fecha_conciliacion, "yyyyMMdd"), 8);//27-34|908|fecha solicitud AAAAMMDD VAMOS A PONER FECHA DE CONCILIACION
				data += StringUtils.alfanumerico("S", 1);//35-35|x01| S o N
				data += StringUtils.alfanumerico("", 60);//36-95|x60| observacion
				data += StringUtils.alfanumerico("", 1);//96-96|x01|blanco
				data += StringUtils.alfanumerico("000", 3);//97-99|903| 000
				data += StringUtils.alfanumerico("00", 2);//100-101|902| 00

				String fechaTwoDigitYear = utils.DateUtils.formatDate(p1.fecha_pago, "MM/dd/yyyy").substring(0, 6)+utils.DateUtils.formatDate(p1.fecha_pago, "MM/dd/yyyy").substring(8, 10);

				data += StringUtils.alfanumerico(fechaTwoDigitYear, 8);//102-109|x08| fecha del archivo MM/DD/YY

				String sec = Pago.getSecuenciaArchivoInterbanking().toString();

				data += StringUtils.alfanumerico("IM"+sec, 8);//110-117|X08| numero secuencial para no enviar dos veces el mismo archivo
				data += StringUtils.alfanumerico("", 123);//118-240|x123| espacios
				data += "\r\n";

				for (Pago pago : pagos) {

					String sql = "SELECT c.cbu numero_cuenta, sb.codigo sucursal "
							+ " FROM cuenta_bancarias c "
							+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
							+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
							+ " WHERE c.activo = TRUE AND c.predeterminada =  true AND p.id = :proveedor_id ";
					SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
					sqlQuery.setParameter("proveedor_id",pago.proveedor.id);

					SqlRow row = sqlQuery.findUnique();
					if(row == null){
						error = "EL PROVEEDOR: "+pago.proveedor.nombre+" NO TIENE CUENTA CARGADA ACTIVA.";
						outError.append(error);
						hayError = true;


					}else if(row.getString("numero_cuenta") == null || row.getString("numero_cuenta").isEmpty()){
						error = "EL PROVEEDOR: "+pago.proveedor.nombre+" NO TIENE CBU CARGADO.";
						outError.append(error);
						hayError = true;
					}else {


						data += StringUtils.alfanumerico("*M*", 3);//01-03 |X03 |Tipo de registros Contiene M
						data += StringUtils.alfanumerico(row.getString("numero_cuenta"), 22);//04-25 |X22 |Numero CBU
						String df = new DecimalFormat("000000000000000.00").format(pago.total);
						data += df.replace(",", "");// 26-42 |9(15)v99 | importe ????????????
						data += StringUtils.alfanumerico("", 60);//43-102|X60 |Observaciones
						data += StringUtils.alfanumerico("FA", 2);//103-104|x02| Documento a cancelar FA o DB
						data += StringUtils.alfanumerico("", 12);//105-116|x12|numero documento a cancelar
						data += StringUtils.alfanumerico("OP", 2);//117-118|x02|tipo de orden de pago
						data += StringUtils.alfanumerico(pago.ordenPago.numero.toString(), 12);//119-130|x12|numero de op
						data += StringUtils.alfanumerico("", 12);//131-142|x12|codigo cliente
						data += StringUtils.alfanumerico("", 2);//143-144|x02|Tipo de retencion(01iva-02gcias-03iibb-04suss)
						data += StringUtils.alfanumerico("000000000000", 12);//145-156|9(15)v99|total retencion?????????
						data += StringUtils.alfanumerico("", 12);//157-168|x12| numero nota credito
						data += StringUtils.alfanumerico("0000000000", 10);//169-178|9(15)v99|importe nota credito
						data += StringUtils.alfanumerico(pago.proveedor.cuit.toString(), 11);//179-189|x11| cuit
						data += StringUtils.alfanumerico("", 51);//190-240|x51| espaciones en blanco
						data += "\r\n";

					}

				}
				out.append(data);
			}
			out.flush();
			out.close();
			outError.flush();
			outError.close();


			if(hayError) {
				return ok(errorOPG);
			} else {
				return ok(archivoOPG);
			}



		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}


	/////////////////////////////
	@CheckPermiso(key = "pagosPagarProveedoresMacrosMaviso")
	public static Result modalPagarProveedoresMacroMasivos(){
		return ok(modalPagarProveedoresMacroMasivos.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPagarProveedoresMacrosMaviso")
	public static Result pagarProveedoresMacroMasivos(){
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		Validator v = new Validator(d);
		v.add(new RequiredValidation("referencia", "Referencia requerida"));
		v.validate();

		if(d.hasErrors())
			return ok(modalPagarProveedoresMacroMasivos.render(d));

		String referencia = d.get("referencia");
		//Verifico que no hay fechas vacias
		Integer soloConFechaPago = Pago.find.select("id").where().eq("referencia", referencia).isNull("fecha_pago").findRowCount();
		if(soloConFechaPago > 0) {
			flash("error", "Los pagos deben tener fecha de pago.");
			return ok(modalPagarProveedoresMacroMasivos.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id").where().eq("referencia", referencia).eq("tipo_pago","cheque").findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los pagos deben ser solamente para transferencias.");
			return ok(modalPagarProveedoresMacroMasivos.render(d));
		}

		Integer soloBorrador = Pago.find.select("id").where().eq("referencia", referencia).ne("estado_id", Estado.PAGO_ESTADO_BORRADOR).findRowCount();
		if(soloBorrador > 0) {
			flash("error", "Los pagos deben ser solamente en estado borrador.");
			return ok(modalPagarProveedoresMacroMasivos.render(d));
		}

		/*Integer soloMacro= Pago.find.select("id").where().eq("referencia", referencia).ne("tipo_pago","transferenciaMacroProveedores").findRowCount();
		if(soloMacro > 0) {
			//flash("error", "Los pagos deben ser solamente tipo Macro Proveedores.");
			//return ok(modalPagarProveedoresMacroMasivos.render(d));
		}*/

		if(!conFechaPagoVieja(referencia) && !Usuario.getUsurioSesion().id.equals(401)){
			flash("error", "No se pueden aprobar pagos con fecha de pago menor del ejercicio actual.");
			return ok(modalPagarProveedoresMacroMasivos.render(d));
		}

		String cptm = controlesPagosTransferenciasMasivas(referencia);
		if(!cptm.isEmpty()){
			flash("error", cptm);
			return ok(modalPagarProveedoresMacroMasivos.render(d));
		}

		List<Long> idsProveedors = new ArrayList<Long>();
		String sql1 = "SELECT proveedor_id "
					+ " FROM pagos "
					+ " WHERE referencia=:refe group by proveedor_id ";
		SqlQuery sqlQuery1 = Ebean.createSqlQuery(sql1);
		sqlQuery1.setParameter("refe",referencia);
		List<SqlRow> rowL = sqlQuery1.findList();
		for(SqlRow rl:rowL) {
			idsProveedors.add(rl.getLong("proveedor_id"));
		}

		String sql = "SELECT c.numero_cuenta numero_cuenta, sb.codigo sucursal "
				+ " FROM cuenta_bancarias c "
				+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
				+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
				+ " WHERE c.activo = TRUE AND c.predeterminada =  true AND c.numero_cuenta is not null AND p.id in(:proveedor_id) ";
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("proveedor_id",idsProveedors);
		List<SqlRow> rows = sqlQuery.findList();

		if(rows.size() != idsProveedors.size()) {
			flash("error", "Hay proveedores que no tienen Cuenta Bancaria Seteada");
			return ok(modalPagarProveedoresMacroMasivos.render(d));
		}


		try {
			Ebean.beginTransaction();
			MiPago mipago = new MiPago();
			mipago.fecha = new Date();
			mipago.tipo = MiPago.Tipo.PROVEEDORES_EXTERNOS.key();
			mipago.save();

			int pagosRealizadosx = Pago.contabilizarPagos(referencia, mipago.id);
			int pagosRealizados = Pago.conciliarPagosMasivo(referencia, mipago.id);

			BalanceCuentaPropia.insertUpdateDesdeListaPago(referencia,false);

			String error = "";
			for (Pago pago : Pago.find.where().eq("mis_pagos_id", mipago.id).findList()) {
				error += getErrorProveedorMasivo(pago);
			}
			if(!error.isEmpty()) {
				flash("error", error);
			} else {
				Ebean.commitTransaction();
				flash("success", "Se han generado " + pagosRealizados + " pagos.");
				return ok(resultadoPagarProveedoresMacroMasivos.render(mipago));
			}

		} catch (Exception e) {
			Ebean.rollbackTransaction();
			e.printStackTrace();
		} finally {
			Ebean.endTransaction();
		}




		return ok(modalPagarProveedoresMacroMasivos.render(d));
	}

	public static Result descargarArchivoProveedoresMacroMasivos(Long id){

		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		String data = "";

		Boolean hayError = false;
		try {
			File archivoOPG = new File(dirTemp+"/proveedoresMacroMasivo.txt");
			File archivoBNF = new File(dirTemp+"/bnfMacroMasivo.txt");
			File errorOPG = new File(dirTemp+"/mensajeProveedoresMacro.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoOPG), "UTF8"));
			Writer bnf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoBNF), "UTF8"));
			Writer outError = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorOPG), "UTF8"));

			List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", id).findList();

			for (Pago pago : pagos) {

				String sql = "SELECT c.numero_cuenta numero_cuenta,c.cbu cbu, sb.codigo sucursal,c.banco_id as banco_id "
						+ " FROM cuenta_bancarias c "
						+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
						+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
						+ " WHERE c.activo = TRUE AND c.predeterminada =  true AND c.numero_cuenta is not null AND p.id = :proveedor_id ";
				SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
				sqlQuery.setParameter("proveedor_id",pago.proveedor.id);

				SqlRow row = sqlQuery.findUnique();
				if(row == null){
					error = "EL PROVEEDOR: "+pago.proveedor.nombre+" NO TIENE CUENTA CARGADA ACTIVA.";
					outError.append(error);
					hayError = true;


				}else if(row.getString("cbu") == null || row.getString("cbu").isEmpty()){
					error = "EL PROVEEDOR: "+pago.proveedor.nombre+" NO TIENE CBU CARGADO.";
					outError.append(error);
					hayError = true;
				}else {
					/*
					tipo_dni	2	numerico
					bnfcuit		11	numerico
					suc_entrega	3	numerico
					opg		30	alfa
					op-razon	120	alfa
					importe		15	decimales con coma
					cuentadebito	25	numercio
					cuenta		22	numerico
					modalidad	2	numerico
					marca		/t
					fechaop		10	DD/MM/AAAA
					pagodife	/t
					firma1		/t
					firma2		/t
					firma3		/t
					*/

					data += "10\t";//tipo_dni	2	numerico
					data += StringUtils.cortarString(pago.proveedor.cuit.toString(),11)+"\t";//bnfcuit		11	numerico
					data += "1\t";//suc_entrega	3	numerico
					//data += StringUtils.cortarString(pago.ordenPago.getNombreCompleto(),30)+"\t";//opg		30	alfa
					String fechaActual = utils.DateUtils.formatDate(new Date(),"ddMMyyyy");
					data += StringUtils.cortarString(pago.proveedor_id+""+pago.orden_pago_id+""+pago.periodo_id+""+fechaActual,30)+"\t";//opg		30	alfa

					data += StringUtils.cortarString(pago.proveedor.nombre,120)+"\t";//op-razon	120	alfa

					String df = new DecimalFormat("0.00").format(pago.total);
					//String df = new DecimalFormat("000000000000000.00").format(pago.total);
					data += df+"\t";
					//data += pago.total.toString()+"\t";//importe		15	decimales con coma
					data += pago.cuentaPropia.numero+"\t";//cuentadebito	25	numercio
					data += row.getString("cbu")+"\t";//cuenta/cbu		22	numerico

					if(row.getInteger("banco_id").compareTo(new Integer(1)) !=0) {
						data += "04\t";//modalidad	2	numerico
					}else {
						data += "02\t";//modalidad	2	numerico
					}

					data += "\t";//marca		/t
					data += utils.DateUtils.formatDate(pago.fecha_pago)+"\t";//fechaop		10	DD/MM/AAAA
					data += "\t";//pagodife		/t
					data += "\t";//firma1		/t
					data += "\t";//firma2		/t
					data += "";//firma3		/t
					data +="\r\n";



					/*data += StringUtils.alfanumerico("U", 3);//01-03 |X03 |Tipo de registros Contiene U
					data += StringUtils.alfanumerico(row.getString("numero_cuenta"), 22);//04-25 |X22 |Numero CBU



					String df = new DecimalFormat("000000000000000.00").format(pago.total);
					data += df.replace(",", "");// 26-42 |9(15)v99 | importe ????????????

					data += StringUtils.alfanumerico("", 60);//43-102|X60 |Observaciones
					data += StringUtils.alfanumerico("", 2);//103-104|x02| Documento a cancelar FA o DB
					data += StringUtils.alfanumerico("", 12);//105-116|x12|numero documento a cancelar
					data += StringUtils.alfanumerico("", 2);//117-118|x02|tipo de orden de pago
					data += StringUtils.alfanumerico("", 12);//119-130|x12|numero de op
					data += StringUtils.alfanumerico("", 12);//131-142|x12|codigo cliente
					data += StringUtils.alfanumerico("", 2);//143-144|x02|Tipo de retencion(01iva-02gcias-03iibb-04suss)
					data += StringUtils.alfanumerico("00000000000000000", 17);//145-156|9(15)v99|total retencion?????????
					data += StringUtils.alfanumerico("", 12);//157-168|x12| numero nota credito
					data += StringUtils.alfanumerico("00000000000000000", 17);//169-178|9(15)v99|importe nota credito
					data += StringUtils.alfanumerico(pago.proveedor.cuit.toString(), 11);//179-189|x11| cuit
					data += StringUtils.alfanumerico("", 51);//190-240|x51| espaciones en blanco*/


				}

			}
			out.append(data);
			out.flush();
			out.close();
			outError.flush();
			outError.close();


			if(hayError) {
				return ok(errorOPG);
			} else {
				return ok(archivoOPG);
			}



		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result descargarArchivoBnfMacroMasivos(Long id){

		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		String data = "";

		Boolean hayError = false;
		try {
			File archivoOPG = new File(dirTemp+"/beneficiarioMacroMasivo.txt");
			File errorOPG = new File(dirTemp+"/mensajeProveedoresMacro.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoOPG), "UTF8"));
			Writer outError = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorOPG), "UTF8"));

			List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", id).findList();

			for (Pago pago : pagos) {

				String sql = "SELECT c.numero_cuenta numero_cuenta, sb.codigo sucursal "
						+ " FROM cuenta_bancarias c "
						+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
						+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
						+ " WHERE c.activo = TRUE AND c.predeterminada =  true AND c.numero_cuenta is not null AND p.id = :proveedor_id ";
				SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
				sqlQuery.setParameter("proveedor_id",pago.proveedor.id);

				SqlRow row = sqlQuery.findUnique();
				if(row == null){
					error = "EL PROVEEDOR: "+pago.proveedor.nombre+" NO TIENE CUENTA CARGADA ACTIVA.";
					outError.append(error);
					hayError = true;


				}else if(row.getString("numero_cuenta") == null || row.getString("numero_cuenta").isEmpty()){
					error = "EL PROVEEDOR: "+pago.proveedor.nombre+" NO TIENE CBU CARGADO.";
					outError.append(error);
					hayError = true;
				}else {
					/*
					tipo_doc	2	numerico
					cuit		11	numerico
					iibb		2	numerico
					gcias		2	numerico
					iva		2	numerico
					razon		40	alfa
					calle		60	alfa
					puerta		/t
					unidad		/t
					CP		4	numerico
					numib		/t
					email		/t
					piso		/t
					pais		/t
					provincia	/t
					ciudad		/t
					*/

					data += "10\t";//tipo_dni	2	numerico
					data += StringUtils.cortarString(pago.proveedor.cuit.toString(),11)+"\t";//bnfcuit		11	numerico
					data += "99\t";//iibb		2	numerico
					data += "99\t";//gcias		2	numerico
					data += "99\t";//iva		2	numerico
					data += StringUtils.cortarString(pago.proveedor.nombre.toString(),40)+"\t";//razon		40	alfa



					data += StringUtils.cortarString("SIN INFORMAR",40)+"\t";//calle		60	alfa
					data += "\t";//puerta		/t
					data += "\t";//unidad		/t
					data += "3300\t";//CP		4	numerico
					data += "\t";//numib		/t
					data += "\t";//email		/t
					data += "\t";//data += "/t";//piso		/t
					data += "\t";//pais		/t
					data += "\t";//provincia	/t
					data += "";//ciudad		/t
					data +="\r\n";

				}

			}
			out.append(data);
			out.flush();
			out.close();
			outError.flush();
			outError.close();


			if(hayError) {
				return ok(errorOPG);
			} else {
				return ok(archivoOPG);
			}



		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}



	/////////////////////////////////////////////////////
	@CheckPermiso(key = "pagosPagarProveedoresExternos")
	public static Result modalPagarEmbargosExternos(){
		return ok(modalPagarEmbargosExternos.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPagarProveedoresExternos")
	public static Result pagarEmbargosExternos(){

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		Validator v = new Validator(d);
		v.add(new RequiredValidation("referencia", "Referencia requerida"));
		v.validate();

		if(d.hasErrors())
			return ok(modalPagarEmbargosExternos.render(d));

		//Tomo la referencia enviada del formulario
		String referencia = d.get("referencia");

		//Verifico que no hay fechas vacias
		Integer soloConFechaPago = Pago.find.select("id").where().eq("referencia", referencia).isNull("fecha_pago").findRowCount();
		if(soloConFechaPago > 0) {
			flash("error", "Los pagos deben tener fecha de pago.");
			return ok(modalPagarEmbargosExternos.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id").where().eq("referencia", referencia).eq("tipo_pago","cheque").findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los pagos deben ser solamente para transferencias.");
			return ok(modalPagarEmbargosExternos.render(d));
		}


		//Verifico que los pagos seleccionados sean solo para proveedores tipo agentes internos
		Integer noAgentes = Pago.find.select("id").where().eq("referencia", referencia).ne("estado_id", Estado.PAGO_ESTADO_BORRADOR).findRowCount();
		if(noAgentes > 0) {
			flash("error", "Los pagos deben ser solamente en estado borrador.");
			return ok(modalPagarEmbargosExternos.render(d));
		}


		//Verifico si hay pagos con mismo agente, expediente y periodo
		Pago duplicado = unicoMismoAgenteConPeriodoConExpediente(referencia);
		if(duplicado != null) {
			flash("error", "Existe un pago con periodo, expediente y agente duplicado. <br /> <b>Proveedor</b>: " + duplicado.proveedor_id + " " + duplicado.proveedor.nombre);
			return ok(modalPagarEmbargosExternos.render(d));
		}

		String cptm = controlesPagosTransferenciasMasivas(referencia);
		if(!cptm.isEmpty()){
			flash("error", cptm);
			return ok(modalPagarEmbargosExternos.render(d));
		}

		if(!conFechaPagoVieja(referencia) && !Usuario.getUsurioSesion().id.equals(401)){
			flash("error", "No se pueden aprobar pagos con fecha de pago menor del ejercicio actual.");
			return ok(modalPagarEmbargosExternos.render(d));
		}


		try {
			Ebean.beginTransaction();
			MiPago mipago = new MiPago();
			mipago.fecha = new Date();
			mipago.tipo = MiPago.Tipo.PROVEEDORES_EXTERNOS.key();
			mipago.save();

			int pagosRealizadosx = Pago.contabilizarPagos(referencia, mipago.id);
			int pagosRealizados = Pago.conciliarPagosMasivo(referencia, mipago.id);

			BalanceCuentaPropia.insertUpdateDesdeListaPago(referencia,false);

			String error = "";
			for (Pago pago : Pago.find.where().eq("mis_pagos_id", mipago.id).findList()) {
				error += getErrorProveedorEmbargoExterno(pago,true);
			}
			if(!error.isEmpty()) {
				flash("error", error);
			} else {
				Ebean.commitTransaction();
				flash("success", "Se han generado " + pagosRealizados + " pagos.");
				return ok(resultadoPagarEmbargoExterno.render(mipago));
			}

		} catch (Exception e) {
			Ebean.rollbackTransaction();
			e.printStackTrace();
		} finally {
			Ebean.endTransaction();
		}

		return ok(modalPagarEmbargosExternos.render(d));
	}

	public static Result descargarOpgEmbargoExterno(Long id){

		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		try {
			File archivoOPG = new File(dirTemp+"/opgembargo.txt");
			File errorOPG = new File(dirTemp+"/mensajeOPG.txt");
			//FileOutputStream fileOPG = new FileOutputStream(archivoOPG);

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoOPG), "UTF8"));
			Writer outError = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorOPG), "UTF8"));
			String fechaActual = utils.DateUtils.formatDate(new Date());

			List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", id).findList();
			int contador = 1;
			boolean listo = false;
			for (Pago pago : pagos) {

				error = getErrorProveedorEmbargoExterno(pago,true);
				if(!error.isEmpty()) {
					outError.append(error);
					hayError = true;
				}

				try {

					String nombreProveedor = pago.proveedor.nombre;
					String[] split = nombreProveedor.split(",");

					if(!listo){

						StringBuilder sb = new StringBuilder();

						for (int n = 0; n < nombreProveedor.length (); n ++){
							char c = nombreProveedor.charAt(n);

							if(!listo) {
								listo= true;
								if(c == 'A') {
									c = 'Á';
								}else if(c == 'E') {
									c = 'É';
								}else if(c == 'I') {
									c = 'Í';
								}else if(c == 'O') {
									c = 'Ó';
								}else if(c == 'U') {
									c = 'O';
								}else {
									listo= false;
								}

							}
							sb.append(c);
						}
						nombreProveedor = sb.toString();
					}else {
						nombreProveedor = pago.proveedor.nombre;
					}



					out.append(crearLineaOPGEmbargoExterno(pago, fechaActual,contador,nombreProveedor));
				} catch (Exception e) {
					outError.append(e.toString());
					hayError = true;
				}
				contador ++;
			}

			out.flush();
			out.close();
			outError.flush();
			outError.close();

			if(hayError) {
				return ok(errorOPG);
			} else {
				return ok(archivoOPG);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	@CheckPermiso(key = "pagosPagarProveedoresExternos")
	public static Result modalPagarEmbargos(){
		return ok(modalPagarEmbargos.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPagarProveedoresExternos")
	public static Result pagarEmbargos(){

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		Validator v = new Validator(d);
		v.add(new RequiredValidation("referencia", "Referencia requerida"));
		v.validate();

		if(d.hasErrors())
			return ok(modalPagarEmbargos.render(d));

		//Tomo la referencia enviada del formulario
		String referencia = d.get("referencia");

		//Verifico que no hay fechas vacias
		Integer soloConFechaPago = Pago.find.select("id").where().eq("referencia", referencia).isNull("fecha_pago").findRowCount();
		if(soloConFechaPago > 0) {
			flash("error", "Los pagos deben tener fecha de pago.");
			return ok(modalPagarEmbargos.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id").where().eq("referencia", referencia).eq("tipo_pago","cheque").findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los pagos deben ser solamente para transferencias.");
			return ok(modalPagarEmbargos.render(d));
		}

		//Verifico que los pagos seleccionados sean solo para proveedores activos
		/*Integer agentesInactivos = Pago.find.select("id").where().eq("referencia", referencia).eq("proveedor.activo", false).findRowCount();
		if(agentesInactivos > 0) {
			flash("error", "Los pagos deben ser solamente para agentes contratados activos.");
			return ok(modalPagarInterno.render(d));
		}*/

		//Verifico que los pagos seleccionados sean solo para proveedores tipo agentes internos
		Integer noAgentes = Pago.find.select("id").where().eq("referencia", referencia).ne("estado_id", Estado.PAGO_ESTADO_BORRADOR).findRowCount();
		if(noAgentes > 0) {
			flash("error", "Los pagos deben ser solamente en estado borrador.");
			return ok(modalPagarEmbargos.render(d));
		}



		//Verifico si hay pagos con mismo agente, expediente y periodo
		Pago duplicado = unicoMismoAgenteConPeriodoConExpediente(referencia);
		if(duplicado != null) {
			flash("error", "Existe un pago con periodo, expediente y agente duplicado. <br /> <b>Proveedor</b>: " + duplicado.proveedor_id + " " + duplicado.proveedor.nombre);
			return ok(modalPagarEmbargos.render(d));
		}

		String cptm = controlesPagosTransferenciasMasivas(referencia);
		if(!cptm.isEmpty()){
			flash("error", cptm);
			return ok(modalPagarEmbargos.render(d));
		}

		if(!conFechaPagoVieja(referencia) && !Usuario.getUsurioSesion().id.equals(401)){
			flash("error", "No se pueden aprobar pagos con fecha de pago menor del ejercicio actual.");
			return ok(modalPagarEmbargos.render(d));
		}


		try {
			Ebean.beginTransaction();
			MiPago mipago = new MiPago();
			mipago.fecha = new Date();
			mipago.tipo = MiPago.Tipo.PROVEEDORES_EXTERNOS.key();
			mipago.save();

			int pagosRealizadosx = Pago.contabilizarPagos(referencia, mipago.id);
			int pagosRealizados = Pago.conciliarPagosMasivo(referencia, mipago.id);

			BalanceCuentaPropia.insertUpdateDesdeListaPago(referencia,false);

			String error = "";
			for (Pago pago : Pago.find.where().eq("mis_pagos_id", mipago.id).findList()) {
				error += getErrorProveedorEmbargo(pago);
			}
			if(!error.isEmpty()) {
				flash("error", error);
			} else {
				Ebean.commitTransaction();
				flash("success", "Se han generado " + pagosRealizados + " pagos.");
				return ok(resultadoPagarEmbargo.render(mipago));
			}

		} catch (Exception e) {
			Ebean.rollbackTransaction();
			e.printStackTrace();
		} finally {
			Ebean.endTransaction();
		}

		return ok(modalPagarEmbargos.render(d));
	}

	private static String crearLineaOPGEmbargo(Pago pago, String fechaActual,Integer contador,String nombreProveedor){
		String linea = "";

		/*for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
			if(cuenta.predeterminada && cuenta.estado_id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
				//linea += cuenta.numero_cuenta+"\t";
				linea += StringUtils.numerico(cuenta.numero_cuenta, 15);
			}
		}


		String df = new DecimalFormat("000000000.00").format(pago.total);
		df =  pago.total.toString();


		linea += StringUtils.alfanumerico(df.replace(",", "").replace(".", ""),12);

		String x = pago.proveedor.id.toString();
		if(pago.proveedor.id.toString().length() > 4) {
			x = pago.proveedor.id.toString().substring(pago.proveedor.id.toString().length()-4, pago.proveedor.id.toString().length());
		}

		linea += StringUtils.numerico(x,4);
		linea += "\r\n"; */

		/*
		 \t
		legajo	7	numerico	NO
		cuil	11	numerico	SI
		apellido	64	texto 	SI
		cuenta 	15	numerico	NI
		CBU	22		numerico	NI
		importe	14	numerico	SI
		comprobante	7	numerico	no
		*/

		String cbu= "";
		String cuitBanco = "";
		for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
			if(cuenta.predeterminada && cuenta.estado_id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
				//linea += cuenta.numero_cuenta+"\t";
				cbu = StringUtils.cortarString(cuenta.numero_cuenta, 15);
				cuitBanco = StringUtils.cortarString(cuenta.banco.cuit,11);
			}
		}

		linea += "\t";//legajo
		linea += "\t";//cuil
		linea += StringUtils.cortarString(nombreProveedor,64)+"\t";//apellido
		linea += cbu+"\t";//numerocuenta
		linea += "\t";//CBU
		linea += pago.total.toString()+"\t";
		linea += "";//comprobante
		linea +="\r\n";

		return linea;
	}

	private static String crearLineaOPGEmbargoExterno(Pago pago, String fechaActual,Integer contador,String nombreProveedor){
		String linea = "";


		/*String cbu = "";
		String cuitBanco = "";
		for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
			if(cuenta.predeterminada && cuenta.estado_id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
				//linea += cuenta.numero_cuenta+"\t";
				cbu = cuenta.cbu;
				cuitBanco = cuenta.banco.cuit;
			}
		}

		linea += StringUtils.alfanumerico(pago.proveedor.id.toString(),10);//dni
		linea += StringUtils.numerico(cuitBanco,11);//cuit
		linea += StringUtils.alfanumerico("000000000000000",15);//numero de cuenta
		linea += StringUtils.numerico(cbu, 22);//cbu

		String df = new DecimalFormat("000000000.00").format(pago.total);
		df =  pago.total.toString();
		linea += StringUtils.alfanumerico(df.replace(",", "").replace(".", ""),9);//importe
		linea += StringUtils.alfanumerico("A",9);//apellido
		linea += StringUtils.alfanumerico("N",9);//nombree
		//linea += StringUtils.numerico(contador.toString(),4);  */

		String cbu= "";
		String cuitBanco = "";
		for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
			if(cuenta.predeterminada && cuenta.estado_id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
				//linea += cuenta.numero_cuenta+"\t";
				cbu = StringUtils.cortarString(cuenta.cbu, 22);
				cuitBanco = StringUtils.cortarString(cuenta.banco.cuit,11);
			}
		}

		linea += "\t";//legajo
		linea += cuitBanco+"\t";//cuil
		linea += StringUtils.cortarString(nombreProveedor,64)+"\t";//apellido
		linea += "\t";
		linea += cbu+"\t";//CBU
		linea += pago.total.toString()+"\t";
		linea += "";//comprobante
		linea +="\r\n";
		return linea;
	}


	private static String crearLineaOPG(Pago pago, String fechaActual){
		String linea = "";
		linea += "3\t"; //tipo documento
		linea += pago.proveedor.agente.dni+"\t"; //Número documento
		linea += "2\t"; //Sucursal de entrega
		//linea += pago.expediente.nombre+"|"+pago.proveedor_id+"|"+pago.ordenPago.numero+"|"+pago.periodo.nombre+"|"+fechaActual+"\t"; //Clave identificatoria de la orden de pago
		linea += pago.proveedor_id+"|"+pago.orden_pago_id+"|"+pago.periodo_id+"|"+fechaActual+"\t"; //Clave identificatoria de la orden de pago
		linea += "\t"; //Orden de pago / razón social
		linea += pago.total.toString().replace(".", ",")+"\t"; //Importe del pago
		linea += pago.cuentaPropia.numero+"\t"; //Cuenta de débito

		for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
			if(cuenta.predeterminada && cuenta.estado_id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
				linea += cuenta.numero_cuenta+"\t"; //Cuenta de pago
			}
		}

		linea += "2\t"; //Modalidad de pago
		linea += "\t"; //Marca de registración de cheque
		linea += utils.DateUtils.formatDate(pago.fecha_pago) + "\t"; //Fecha pago
		linea += "\t"; //Fecha de pago diferido
		linea += "VVILLARRUE\t"; //Identificacion del firmante1
		linea += "RYWAKALI\t"; //Identificacion del firmante2
		linea += ""; //Identificacion del firmante3
		linea += "\r\n";
		System.out.print(linea);
		return linea;
	}

	private static String crearLineaBnf(Proveedor p, String fechaActual){
		String linea = "";
		DireccionProveedor d = p.direcciones.get(0);
		linea += "3\t"; //tipo documento
		linea += p.agente.dni+"\t";  //Número de documento
		linea += "1\t"; //Condición ingresos brutos
		linea += "1\t"; //Condicion de ganancias
		linea += "1\t"; //Condicion de IVA
		linea += p.nombre+"\t";//Razón social
		linea += d.calle+" "+d.numero+"\t";//Calle
		linea += "1\t"; //Número
		linea += "\t"; //Unidad funcional
		linea += d.zip+"\t"; //Código postal
		linea += "\r\n";
		return linea;
	}

	public static String getErrorProveedorEmbargoExterno(Pago pago,boolean soloMacro) {
		String newLine = System.getProperty("line.separator");
		String error = "";



		if(pago.fecha_pago == null) {
			error += "La fecha de pago del proveedor " + pago.proveedor.nombre + " no se encuentra definido" + newLine;
		}
		if(pago.proveedor.cuit == null) {
			error += "El CUIT del proveedor " + pago.proveedor.nombre + " no se encuentra definido" + newLine;
		}


		//Verifico total
		if(pago.total == null || pago.total.equals(0)) {
			error += "El pago del proveedor " + pago.proveedor.nombre + " no se encuentra definido." + newLine;
		}
		//Si no tiene cuenta asignada
		if(pago.proveedor.cuenta.isEmpty()) {
			error += "La cuenta del proveedor " + pago.proveedor.nombre + " no se encuentra definida." + newLine;
		}



			/*String[] ss = pago.proveedor.nombre.split("C/ ");
			if(ss.length > 1) {
				if(ss[1] == null) {
					error += "El pago del proveedor " + pago.proveedor.nombre + " no se puede definir." + newLine;
				}
			}else{
				error += "El pago del proveedor " + pago.proveedor.nombre + " no se puede definir." + newLine;
			} */

		//Verifico que tenga una cuenta predeterminada
		Boolean tieneCuentaPredeterminada = false;
		Boolean tieneCuentaActiva = false;
		for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
			if(cuenta.estado != null && cuenta.estado.id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
				tieneCuentaActiva = true;
				if(cuenta.predeterminada) {
					tieneCuentaPredeterminada = true;
					//Verifico que la cuenta predeterminada tenga un numero
					if(cuenta.numero_cuenta.isEmpty()) {
						error += "El número de cuenta del agente " + pago.proveedor.nombre+ " no se encuentra definido."+newLine;
					}else if(cuenta.cbu.isEmpty()) {
						error += "El CBU del agente " + pago.proveedor.nombre+ " no se encuentra definido."+newLine;
					}else if(cuenta.banco_id.compareTo(new Long(1)) == 0 && soloMacro){
						error += "El Banco de la cuenta del agente " + pago.proveedor.nombre+ " NO debe ser BANCO MACRO para pagos externos."+newLine;
					}
				}
				break;
			}
		}


		if(!tieneCuentaActiva) {
			error += "El proveedor " + pago.proveedor.nombre + " no tiene cuenta bancaria aprobada."+newLine;
		} else if (!tieneCuentaPredeterminada) {
			error += "El proveedor " + pago.proveedor.nombre + " no tiene cuenta predeterminada."+newLine;
		}

		return error;
	}

	public static String getErrorProveedorEmbargo(Pago pago) {
		String newLine = System.getProperty("line.separator");
		String error = "";



		if(pago.fecha_pago == null) {
			error += "La fecha de pago del proveedor " + pago.proveedor.nombre + " no se encuentra definido" + newLine;
		}
		if(pago.proveedor.cuit == null) {
			error += "El CUIT del proveedor " + pago.proveedor.nombre + " no se encuentra definido" + newLine;
		}


		//Verifico total
		if(pago.total == null || pago.total.equals(0)) {
			error += "El pago del proveedor " + pago.proveedor.nombre + " no se encuentra definido." + newLine;
		}
		//Si no tiene cuenta asignada
		if(pago.proveedor.cuenta.isEmpty()) {
			error += "La cuenta del proveedor " + pago.proveedor.nombre + " no se encuentra definida." + newLine;
		}



			/*String[] ss = pago.proveedor.nombre.split("C/ ");
			if(ss.length > 1) {
				if(ss[1] == null) {
					error += "El pago del proveedor " + pago.proveedor.nombre + " no se puede definir." + newLine;
				}
			}else{
				error += "El pago del proveedor " + pago.proveedor.nombre + " no se puede definir." + newLine;
			} */

		//Verifico que tenga una cuenta predeterminada
		Boolean tieneCuentaPredeterminada = false;
		Boolean tieneCuentaActiva = false;
		for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
			if(cuenta.estado != null && cuenta.estado.id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
				tieneCuentaActiva = true;
				if(cuenta.predeterminada) {
					tieneCuentaPredeterminada = true;
					//Verifico que la cuenta predeterminada tenga un numero
					if(cuenta.numero_cuenta.isEmpty()) {
						error += "El número de cuenta del agente " + pago.proveedor.nombre+ " no se encuentra definido."+newLine;
					}else if(cuenta.banco_id.compareTo(new Long(1)) !=0){
						error += "El Banco de la cuenta del agente " + pago.proveedor.nombre+ " debe ser BANCO MACRO para pagos no externos."+newLine;
					}
				}
				break;
			}
		}


		if(!tieneCuentaActiva) {
			error += "El proveedor " + pago.proveedor.nombre + " no tiene cuenta bancaria aprobada."+newLine;
		} else if (!tieneCuentaPredeterminada) {
			error += "El proveedor " + pago.proveedor.nombre + " no tiene cuenta predeterminada."+newLine;
		}

		return error;
	}

	public static String getErrorProveedorMasivo(Pago pago) {
		String newLine = System.getProperty("line.separator");
		String error = "";



		if(pago.fecha_pago == null) {
			error += "La fecha de pago del proveedor " + pago.proveedor.nombre + " no se encuentra definido" + newLine;
		}
		if(pago.proveedor.cuit == null) {
			error += "El CUIT del proveedor " + pago.proveedor.nombre + " no se encuentra definido" + newLine;
		}


		//Verifico total
		if(pago.total == null || pago.total.equals(0)) {
			error += "El pago del proveedor " + pago.proveedor.nombre + " no se encuentra definido." + newLine;
		}
		//Si no tiene cuenta asignada
		if(pago.proveedor.cuenta.isEmpty()) {
			error += "La cuenta del proveedor " + pago.proveedor.nombre + " no se encuentra definida." + newLine;
		}



			/*String[] ss = pago.proveedor.nombre.split("C/ ");
			if(ss.length > 1) {
				if(ss[1] == null) {
					error += "El pago del proveedor " + pago.proveedor.nombre + " no se puede definir." + newLine;
				}
			}else{
				error += "El pago del proveedor " + pago.proveedor.nombre + " no se puede definir." + newLine;
			} */

		//Verifico que tenga una cuenta predeterminada
		Boolean tieneCuentaPredeterminada = false;
		Boolean tieneCuentaActiva = false;
		for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
			if(cuenta.estado != null && cuenta.estado.id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
				tieneCuentaActiva = true;
				if(cuenta.predeterminada) {
					tieneCuentaPredeterminada = true;
					//Verifico que la cuenta predeterminada tenga un numero
					if(cuenta.numero_cuenta.isEmpty()) {
						error += "El número de cuenta del agente " + pago.proveedor.nombre+ " no se encuentra definido."+newLine;
					}else if(cuenta.banco_id.compareTo(new Long(1)) !=0){
						//error += "El Banco de la cuenta del agente " + pago.proveedor.nombre+ " debe ser BANCO MACRO para pagos no externos."+newLine;
					}
				}
				break;
			}
		}


		if(!tieneCuentaActiva) {
			error += "El proveedor " + pago.proveedor.nombre + " no tiene cuenta bancaria aprobada."+newLine;
		} else if (!tieneCuentaPredeterminada) {
			error += "El proveedor " + pago.proveedor.nombre + " no tiene cuenta predeterminada."+newLine;
		}

		return error;
	}

	public static String getErrorProveedor(Pago pago) {
		String newLine = System.getProperty("line.separator");
		String error = "";

		//El nombre es muy largo
		if(pago.proveedor.nombre.length() > 40) {
			error += "El nombre del agente " + pago.proveedor.agente.getNombreCompleto() + " contiene más de 40 caracteres.\r\n";
		}
		//Direccion indefinida
		if(pago.proveedor.direcciones.isEmpty() || pago.proveedor.direcciones == null) {
			error += "La dirección del agente " + pago.proveedor.agente.getNombreCompleto() +" no se encuentra definida.\r\n";
		}else{
			if(pago.proveedor.direcciones.get(0).zip == null) {
				error += "El código postal del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definida.\r\n";
			}
			if(pago.proveedor.direcciones.get(0).calle == null) {
				error += "La calle del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definida.\r\n";
			}
			if(pago.proveedor.direcciones.get(0).calle.length() > 60){
				error += "La calle del agente " + pago.proveedor.agente.getNombreCompleto() + " contiene más de 60 caracteres.\r\n";
			}
			if(pago.proveedor.direcciones.get(0).numero == null) {
				error += "EL número de calle del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definida.\r\n";
			}
		}
		//Verifico que el dni se encuentre definico
		if(pago.proveedor.agente.dni == null) {
			error += "El DNI del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definido" + newLine;
		}
		if(pago.fecha_pago == null) {
			error += "La fecha de pago del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definido" + newLine;
		}
		if(pago.proveedor.cuit == null) {
			error += "El CUIT del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definido" + newLine;
		}
		//Verifico total
		if(pago.total == null || pago.total.equals(0)) {
			error += "El pago del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definido." + newLine;
		}
		//Si no tiene cuenta asignada
		if(pago.proveedor.cuenta.isEmpty()) {
			error += "La cuenta del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definida." + newLine;
		}

		//Verifico que tenga una cuenta predeterminada
		Boolean tieneCuentaPredeterminada = false;
		Boolean tieneCuentaActiva = false;
		for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
			if(cuenta.estado != null && cuenta.estado.id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
				tieneCuentaActiva = true;
				if(cuenta.predeterminada) {
					tieneCuentaPredeterminada = true;
					//Verifico que la cuenta predeterminada tenga un numero
					if(cuenta.numero_cuenta.isEmpty()) {
						error += "El número de cuenta del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definido."+newLine;
					}
				}
				break;
			}
		}

		if(!tieneCuentaActiva) {
			error += "El agente " + pago.proveedor.agente.getNombreCompleto() + " no tiene cuenta bancaria aprobada."+newLine;
		} else if (!tieneCuentaPredeterminada) {
			error += "El agente " + pago.proveedor.agente.getNombreCompleto() + " no tiene cuenta predeterminada."+newLine;
		}

		return error;
	}

	public static Result descargarRendiciones(Long id){

		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;

		try {
			File archivo = new File(dirTemp+"/rendiciones.xls");

			if(archivo.exists()) archivo.delete();

			archivo.createNewFile();

			Workbook libro = new HSSFWorkbook();

			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			Sheet hoja = libro.createSheet("Rendiciones");

			List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", id).findList();

			Map<Long, List<Pago>> hp = new HashMap<Long, List<Pago>>();
			Map<Long,BigDecimal> totales = new HashMap<Long, BigDecimal>();
			for (Pago pago : pagos) {
					if(hp.containsKey(pago.orden_pago_id)){
						hp.get(pago.orden_pago_id).add(pago);


						BigDecimal tTmp = totales.get(pago.orden_pago_id).add(pago.total);
						totales.remove(pago.orden_pago_id);
						totales.put(pago.orden_pago_id, tTmp);
					}else{
						List<Pago> lp = new ArrayList<Pago>();
						lp.add(pago);

						hp.put(pago.orden_pago_id, lp);
						totales.put(pago.orden_pago_id,pago.total);
					}
			}

			for (Map.Entry<Long,BigDecimal> f : totales.entrySet()) {
				play.Logger.debug("a "+f.getValue()+" "+f.getKey()+" "+hp.get(f.getKey()).size());
			}

			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Proveedor");
			fila.createCell(1).setCellValue("Expediente");
			fila.createCell(2).setCellValue("OP");
			fila.createCell(3).setCellValue("Ejercicio/OP");
			fila.createCell(4).setCellValue("Monto");

			int f = 1;
			for (Map.Entry<Long, List<Pago>> e : hp.entrySet()) {
				for (Pago pago : e.getValue()) {
					fila = hoja.createRow(f);
					for(int c=0;c<5;c++){
						Cell celda = fila.createCell(c);

						switch (c) {
						case 0:
							celda.setCellValue(pago.proveedor.nombre);
							break;
						case 1:
							celda.setCellValue(pago.expediente.getExpedienteEjercicio());
							break;
						case 2:
							celda.setCellValue(pago.ordenPago.numero);
							break;
						case 3:
							celda.setCellValue(pago.ordenPago.ejercicio.nombre);
							break;
						case 4:
							celda.setCellValue(pago.total.doubleValue());
							break;
						default:
							break;
						}
					}
					f++;
				}
				fila = hoja.createRow(f++);
				Cell celda = fila.createCell(3);
				celda.setCellValue("Total");
				Cell celda3 = fila.createCell(4);
				celda3.setCellValue(totales.get(e.getKey()).doubleValue());
				fila = hoja.createRow(f++);
			}

			libro.write(archivoTmp);
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			return ok(archivo);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();

	}

	public static Result descargarMacroSueldo(Long id){

		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		String data = "";
		Boolean hayError = false;
		try {
			File archivoOPG = new File(dirTemp+"/opg.txt");
			File errorOPG = new File(dirTemp+"/mensajeOPG.txt");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoOPG), "UTF8"));
			Writer outError = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorOPG), "UTF8"));

			List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", id).findList();

			for (Pago pago : pagos) {

				String sql = "SELECT c.numero_cuenta numero_cuenta, sb.codigo sucursal FROM cuenta_bancarias c "
						+ " LEFT JOIN sucursal_bancos sb ON sb.id = c.sucursal_banco_id "
						+ " INNER JOIN proveedores p ON p.id =  c.proveedor_id"
						+ " WHERE c.activo = TRUE AND c.predeterminada =  true AND p.id = :proveedor_id ";
				SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
				sqlQuery.setParameter("proveedor_id",pago.proveedor.id);

				SqlRow row = sqlQuery.findUnique();
				if(row == null){
					error = "EL PROVEEDOR: "+pago.proveedor.nombre+" NO TIENE CUENTA CARGADA ACTIVA.";
					outError.append(error);
					hayError = true;


				}else {


					data += StringUtils.numerico(pago.proveedor.cuit .toString(), 10);  //cuit

					data += StringUtils.numerico(row.getString("numero_cuenta"), 15);  //cuenta

					String df = new DecimalFormat("000000000.00").format(pago.total);
					data += df.replace(",", "");// importe

					//data += StringUtils.alfanumerico("88915", 5); // Convenio

					data += StringUtils.numerico(pago.proveedor.nombre, 20);

					out.append(data).append("\r\n");
				}

			}
			out.flush();
			out.close();
			outError.flush();
			outError.close();


			if(hayError) {
				return ok(errorOPG);
			} else {
				return ok(archivoOPG);
			}



		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result descargarOpg(Long id){

		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		try {
			File archivoOPG = new File(dirTemp+"/opg.txt");
			File errorOPG = new File(dirTemp+"/mensajeOPG.txt");
			//FileOutputStream fileOPG = new FileOutputStream(archivoOPG);

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoOPG), "UTF8"));
			Writer outError = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorOPG), "UTF8"));
			String fechaActual = utils.DateUtils.formatDate(new Date());

			List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", id).findList();

			for (Pago pago : pagos) {

				error = getErrorProveedor(pago);
				if(!error.isEmpty()) {
					outError.append(error);
					hayError = true;
				}

				try {
				out.append(crearLineaOPG(pago, fechaActual));
				} catch (Exception e) {}

			}

			out.flush();
			out.close();
			outError.flush();
			outError.close();

			if(hayError) {
				return ok(errorOPG);
			} else {
				return ok(archivoOPG);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result descargarBnf(Long id){
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivoBNF = new File(dirTemp+"/bnf.txt");
		File errorBNF = new File(dirTemp+"/mensajeBNF.txt");
		FileOutputStream fileBNF;
		String lineaBnf = "";
		String error = "";

		try {
			//fileBNF = new FileOutputStream(archivoBNF);
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoBNF), "UTF8"));
			Writer outError = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorBNF), "UTF8"));
			String fechaActual = utils.DateUtils.formatDate(new Date());

			List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", id).findList();

			for (Pago pago : pagos) {
				//Verifico cantidad de caracteres de la razón social
				if(pago.proveedor.nombre.length() > 40) {
					error += "El nombre del agente " + pago.proveedor.agente.getNombreCompleto() + " contiene más de 40 caracteres.\r\n";
				}
				//Verifico que el dni se encuentre definido
				if(pago.proveedor.agente.dni == null) {
					error += "El DNI del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definido.\r\n";
				}
				if(pago.proveedor.direcciones.isEmpty()) {
					error += "La dirección del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definida.\r\n";
				}
				if(pago.proveedor.direcciones.get(0).zip == null) {
					error += "El código postal del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definida.\r\n";
				}
				if(pago.proveedor.direcciones.get(0).calle == null) {
					error += "La calle del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definida.\r\n";
				}
				if(pago.proveedor.direcciones.get(0).calle.length() > 60){
					error += "La calle del agente " + pago.proveedor.agente.getNombreCompleto() + " contiene más de 60 caracteres.\r\n";
				}
				if(pago.proveedor.direcciones.get(0).numero == null) {
					error += "EL número de calle del agente " + pago.proveedor.agente.getNombreCompleto() + " no se encuentra definida.\r\n";
				}

				try {
					out.append(crearLineaBnf(pago.proveedor, fechaActual));
				} catch (Exception e) {}

			}
			outError.append(error);

			out.flush();
			out.close();
			outError.flush();
			outError.close();

			if(error.isEmpty()) {
				return ok(archivoBNF);
			} else {
				return ok(errorBNF);
			}


		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result descargarOpgEmbargo(Long id){

		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		try {
			File archivoOPG = new File(dirTemp+"/opgembargo.txt");
			File errorOPG = new File(dirTemp+"/mensajeOPG.txt");
			//FileOutputStream fileOPG = new FileOutputStream(archivoOPG);

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoOPG), "UTF8"));
			Writer outError = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorOPG), "UTF8"));
			String fechaActual = utils.DateUtils.formatDate(new Date());

			List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", id).findList();
			int contador = 1;
			boolean listo = false;
			for (Pago pago : pagos) {

				error = getErrorProveedorEmbargo(pago);
				if(!error.isEmpty()) {
					outError.append(error);
					hayError = true;
				}

				try {

					String nombreProveedor = pago.proveedor.nombre;
					//String[] split = nombreProveedor.split(",");

					if(!listo){

						StringBuilder sb = new StringBuilder();

						for (int n = 0; n < nombreProveedor.length (); n ++){
							char c = nombreProveedor.charAt(n);

							if(!listo) {
								listo= true;
								if(c == 'A') {
									c = 'Á';
								}else if(c == 'E') {
									c = 'É';
								}else if(c == 'I') {
									c = 'Í';
								}else if(c == 'O') {
									c = 'Ó';
								}else if(c == 'U') {
									c = 'O';
								}else {
									listo= false;
								}

							}
							sb.append(c);
						}
						nombreProveedor = sb.toString();
					}else {
						nombreProveedor = pago.proveedor.nombre;
					}


					out.append(crearLineaOPGEmbargo(pago, fechaActual,contador,nombreProveedor));
				} catch (Exception e) {
					outError.append(e.toString());
					hayError = true;
				}
				contador ++;
			}

			out.flush();
			out.close();
			outError.flush();
			outError.close();

			if(hayError) {
				return ok(errorOPG);
			} else {
				return ok(archivoOPG);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Boolean soloBorrador(List<Integer> pagosSeleccionados) {
		return Pago.find.where().ne("estado_id", Estado.PAGO_ESTADO_BORRADOR).in("id", pagosSeleccionados).findRowCount() == 0;
	}

	public static Boolean soloUnaCuenta(List<Integer> pagosSeleccionados) {
		//Integer op = Pago.find.where().eq("profe",false).in("id", pagosSeleccionados).findRowCount();
		//Integer pr = Pago.find.where().eq("profe",true).in("id", pagosSeleccionados).findRowCount();
		boolean ret = false;
		String sql = " SELECT cuenta_propia_id FROM pagos WHERE id in(:ids) group by cuenta_propia_id ";

		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("ids", pagosSeleccionados).findList();
		if(l.size() > 1){
			ret = true;
		}


		return ret;
	}

	public static Boolean conFechaPagoVieja(String referencia) {
		String sql = " SELECT count(*) cantidad "+
				 	 " FROM pagos c " +
					 " WHERE c.fecha_pago < (select date_start from ejercicios where now() BETWEEN date_start AND date_stop) AND referencia = :referencia" +
					 " GROUP BY c.id";

		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("referencia", referencia).findList();

		//return  (l.size() == 0);
		return true;
	}

	public static Boolean conFechaPagoVieja(List<Integer> ids) {
		String sql = " SELECT count(*) cantidad "+
				 	 " FROM pagos c " +
					 " WHERE c.fecha_pago < (select date_start from ejercicios where now() BETWEEN date_start AND date_stop) AND id in(:ids)" +
					 " GROUP BY c.id";

		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("ids", ids).findList();

		//return  (l.size() == 0);
		return true;
	}

	public static List<Integer> getSeleccionados(){
		String[] checks = request().body().asFormUrlEncoded().get("id_pago[]");
		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}

	@CheckPermiso(key = "pagosPasarConciliadoMasivo")
	public static Result modalPasarConciliado() {
		return ok(modalPasarConciliado.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPasarConciliadoMasivo")
	public static Result pasarConciliadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalPasarConciliado.render(d));
		}

		if(!soloPagados(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en pagado.");
			return ok(modalPasarConciliado.render(d));
		}

		if(Pago.find.where().isNull("fecha_conciliacion").in("id", pagosSeleccionados).findList().size() > 0){
			flash("error", "Debe ingresar fecha de conciliado en los pagos.");
			return ok(modalPasarConciliado.render(d));
		}

		//Verifico que no haya cheques
		Integer soloTransferencias = Pago.find.select("id")
									.where()
									.in("id",pagosSeleccionados)
									.disjunction()
									.eq("tipo_pago","transferencia")
									.eq("tipo_pago","transferenciaMacroProveedores")
									.eq("tipo_pago","transferenciaInterbanking")
									.endJunction()
									.findRowCount();
		if(soloTransferencias > 0) {
			flash("error", "Los cambios deben ser solamente para cheques.");
			return ok(modalPasarConciliado.render(d));
		}

		if(Pago.controlRefenciasDistintas(pagosSeleccionados)){
			flash("error", "Para las acciones masivas debe seleccionar todos los pagos con las mismas referencias.");
			return ok(modalPasarConciliado.render(d));
		}

		if(Pago.controlHayReferenciaRepetidaDesdeLista(pagosSeleccionados)){
			flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
			return ok(modalPasarConciliado.render(d));
		}


		if(!conFechaPagoVieja(pagosSeleccionados) && !Usuario.getUsurioSesion().id.equals(401)){
			flash("error", "No se pueden aprobar pagos con fecha de pago menor del ejercicio actual.");
			return ok(modalPasarConciliado.render(d));
		}


		if(d.hasErrors())
			return ok(modalPasarConciliado.render(d));

		ObjectNode result = Json.newObject();

		try {
			Ebean.beginTransaction();
			Integer count = Pago.modificarEstadoMasivo(Estado.PAGO_ESTADO_CONCILIADO, pagosSeleccionados);
			BalanceCuentaPropia. insertUpdateDesdeListaPago(pagosSeleccionados,true,false);

			Ebean.commitTransaction();
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarConciliado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			Ebean.rollbackTransaction();
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarConciliado.render(d));
		} finally {
			Ebean.endTransaction();
		}
	}

	public static Boolean soloCancelado(List<Integer> pagosSeleccionados) {
		return Pago.find.where().ne("estado_id", Estado.PAGO_ESTADO_CANCELADO).in("id", pagosSeleccionados).findRowCount() == 0;
	}

	@CheckPermiso(key = "pagosPasarBorradorMasivo")
	public static Result modalPasarBorrador() {
		return ok(modalPasarBorrador.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPasarBorradorMasivo")
	public static Result pasarBorradorMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalPasarBorrador.render(d));
		}

		if(!soloCancelado(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en cancelado.");
			return ok(modalPasarBorrador.render(d));
		}

		if(Pago.controlHayReferenciaRepetidaDesdeLista(pagosSeleccionados)){
			flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
			return ok(modalPasarBorrador.render(d));
		}

		if(d.hasErrors())
			return ok(modalPasarBorrador.render(d));

		ObjectNode result = Json.newObject();


		try {
			Ebean.beginTransaction();
			Integer count = Pago.modificarEstadoMasivo(Estado.PAGO_ESTADO_BORRADOR, pagosSeleccionados);
			BalanceCuentaPropia.deleteDesdeListaPago(pagosSeleccionados);
			Ebean.commitTransaction();
			actualizarVistaMaterializada();
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarBorrador.render(d).toString());
			return ok(result);
		} catch (Exception e){
			Ebean.rollbackTransaction();
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarBorrador.render(d));
		} finally {
			Ebean.endTransaction();
		}
	}

	public static Boolean soloPagados(List<Integer> pagosSeleccionados) {
		return Pago.find.where()
				.conjunction()
				.ne("estado_id", Estado.PAGO_ESTADO_PAGADO)
				.endJunction()
				.in("id", pagosSeleccionados).findRowCount() == 0;
	}


	public static List<SqlRow> soloPagosCompletos(Integer idEstado,List<Integer> pagosSeleccionados) {

		String sql = " SELECT nombre nombre FROM pagos WHERE state_id <> :idEstado " +
					 " AND tipo <> 'impuestos' " +
					 " AND (orden_pago_id,proveedor_id) IN( " +
					 " SELECT orden_pago_id,proveedor_id FROM pagos WHERE id IN(:pagosSeleccionados) " +
					 " GROUP BY orden_pago_id,proveedor_id) ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("idEstado",idEstado)
				.setParameter("pagosSeleccionados",pagosSeleccionados)
				.findList();

		String sql2 = " SELECT p.nombre nombre FROM pagos p " +
				 	  " INNER JOIN facturas f ON f.id = p.factura_id " +
				 	  " WHERE f.proveedor_id IN (SELECT proveedor_id FROM pagos WHERE id IN(:pagosSeleccionados)) " +
				 	  " AND p.tipo = 'impuestos' " +
				 	  "	AND p.state_id <> :idEstado" +
				 	  " AND f.orden_pago_id in(SELECT orden_pago_id FROM pagos WHERE id IN(:pagosSeleccionados)) ";

		List<SqlRow> s2 = Ebean.createSqlQuery(sql2)
			.setParameter("idEstado",idEstado)
			.setParameter("pagosSeleccionados",pagosSeleccionados)
			.findList();

		s.addAll(s2);

		return s;
	}

	@CheckPermiso(key = "pagosPasarCanceladoMasivo")
	public static Result modalPasarCancelado() {
		return ok(modalPasarCancelado.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosPasarCanceladoMasivo")
	public static Result pasarCanceladoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		Validator v = new Validator(d);
		v.add(new RequiredValidation("fecha_cancelacion", "Fecha requerida"));
		v.add(new DateValidation("fecha_cancelacion", "Fecha inválida"));
		v.validate();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalPasarCancelado.render(d));
		}

		if(soloCancelado(pagosSeleccionados)) {
			flash("error", "Hay pagos ya cancelados. No se pueden cancelar 2 veces.");
			return ok(modalPasarCancelado.render(d));
		}

		if(Pago.getIdsPagosEnCircutoOrdenEnCurso(pagosSeleccionados).size() > 0) {
			flash("error", "Solo se puede cancelar pagos que no estan en un circuito de orden de pago en cursos.");
			return ok(modalPasarCancelado.render(d));
		}

		if(Pago.controlHayReferenciaRepetidaDesdeLista(pagosSeleccionados)){
			flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
			return ok(modalPasarCancelado.render(d));
		}

		List<SqlRow> controlTipoPago = Ebean.createSqlQuery("SELECT fecha_pago FROM pagos WHERE id IN(:ids) GROUP BY fecha_pago").setParameter("ids",pagosSeleccionados).findList();
		if(controlTipoPago.size() > 1){
			flash("error", "Deben tener todos la misma fecha de pago.");
			return ok(modalPasarCancelado.render(d));
		}

		if(d.hasErrors())
			return ok(modalPasarCancelado.render(d));

		ObjectNode result = Json.newObject();


		try {
			Ebean.beginTransaction();
			Integer countx = Pago.modificarFechaCancelacionMasiva(utils.DateUtils.formatDate(d.get("fecha_cancelacion"), "dd/MM/yyyy"), pagosSeleccionados);

			Integer count = Pago.modificarEstadoMasivoAndMisPagos(Estado.PAGO_ESTADO_CANCELADO, pagosSeleccionados);
			BalanceCuentaPropia.cancelarDesdeListaPago(pagosSeleccionados);
			Ebean.commitTransaction();
			actualizarVistaMaterializada();
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarCancelado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			Ebean.rollbackTransaction();
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarCancelado.render(d));
		} finally {
			Ebean.endTransaction();
		}
	}

	public static Result modalDetallePago(Long id) {

		Pago f = Pago.find.byId(id);

		return ok(modalDetallePago.render(f));
	}

	public static Result modalDetalleDeudaPorEstadoPorPeriodo(String nombrePeriodo,Integer estado,Integer proveedorId) {

		Periodo p = Periodo.find.where().eq("nombre", nombrePeriodo).findUnique();
		List<Certificacion> c = new ArrayList<Certificacion>();
		List<Factura> f = new ArrayList<Factura>();
		List<Pago> pa = new ArrayList<Pago>();
		if(estado.equals(1)){
			c = Certificacion.find.where()
					.eq("periodo_id",p.id)
					.eq("estado_id",Estado.CERTIFICACION_ESTADO_CERTIFICADO)
					.eq("proveedor_id", proveedorId).findList();

			f = Factura.find.where()
					.eq("periodo_id",p.id)
					.eq("estado.descripcion","factura")
					.ne("estado_id",Estado.FACTURA_ESTADO_APROBADO)
					.ne("estado_id",Estado.FACTURA_ESTADO_CANCELADO)
					.eq("proveedor_id", proveedorId).findList();

			pa = Pago.find.where()
					.eq("periodo_id",p.id)
					.eq("estado_id",Estado.PAGO_ESTADO_BORRADOR)
					.eq("proveedor_id", proveedorId).findList();

		}else{
			pa = Pago.find.where()
					.eq("periodo_id",p.id)
					.disjunction()
					.eq("estado_id",Estado.PAGO_ESTADO_CONCILIADO)
					.eq("estado_id",Estado.PAGO_ESTADO_PAGADO)
					.eq("estado_id",Estado.PAGO_ESTADO_EN_CURSO)
					.endJunction()
					.eq("proveedor_id", proveedorId).findList();
		}

		return ok(modalDetalleDeudaPorEstadoPorPeriodo.render(c,f,pa));
	}

	@CheckPermiso(key = "pagosModificarCuentaPropia")
	public static Result modalModificarCuentaPropia() {
		return ok(modalModificarCuentaPropia.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "pagosModificarCuentaPropia")
	public static Result modificarCuentaPropia() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un pago.");
			return ok(modalModificarCuentaPropia.render(d));
		}

		if(!soloBorrador(pagosSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalModificarCuentaPropia.render(d));
		}

		if(d.hasErrors())
			return ok(modalModificarCuentaPropia.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Pago.modificarCuentaPropia(new Integer(d.get("cuenta_propia_id")), pagosSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ pagosSeleccionados.size() +" seleccionados.");
			result.put("html", modalModificarCuentaPropia.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalModificarCuentaPropia.render(d));
		}
	}



	public static String esPagoConExpedienteSinCertificacion(String referencia){

		List<SqlRow> r = Ebean.createSqlQuery("SELECT count(*),p.expediente_id,e.nombre nombre " +
												"FROM pagos p " +
												"INNER JOIN expedientes e ON e.id = p.expediente_id " +
												"WHERE p.expediente_id not in (SELECT c.expediente_id FROM certificaciones c GROUP BY c.expediente_id) " +
												"AND p.referencia = :referencia " +
												"AND e.parent_id is null " +
												"GROUP BY p.expediente_id, e.nombre ")
												.setParameter("referencia",referencia).findList();

		List<SqlRow> r2 = Ebean.createSqlQuery("SELECT count(*),p.expediente_id,e.nombre nombre " +
				" FROM pagos p " +
				" INNER JOIN expedientes e ON e.id = p.expediente_id " +
				" WHERE " +
				" e.parent_id is not null " +
				" AND e.parent_id not in (SELECT c.expediente_id FROM certificaciones c GROUP BY c.expediente_id)" +
				" AND p.referencia = :referencia " +
				" GROUP BY p.expediente_id, e.nombre ")
				.setParameter("referencia",referencia).findList();

		if(r.size() > 0 || r2.size() > 0){
			String rs = "";
			for (SqlRow pago : r) {
				rs += pago.getString("nombre")+"<br>";
			}

			for (SqlRow pago : r2) {
				rs += pago.getString("nombre")+"<br>";
			}

			//return rs;
			return null;
		}else{
			return null;
		}
	}

	public static void actualizarVistaMaterializada () {

		//Ebean.createSqlUpdate("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada").execute();
		Connection conn = play.db.DB.getConnection();
		Statement stmt = null;
		try {
		    stmt = conn.createStatement();
		    stmt.execute("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada;");
		    stmt.execute("REFRESH MATERIALIZED VIEW informe_deuda_actas_materializada;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
		    	stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
