package controllers.contabilidad;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.ActaRecepcion;
import models.BalanceCuentaPropia;
import models.BalanceCuentaPropiaExpediente;
import models.BalanceCuentaPropiaOrdenPago;
import models.BalanceCuentaPropiaPago;
import models.Estado;
import models.Expediente;
import models.ExpedienteMovimiento;
import models.Factura;
import models.OrdenPago;
import models.Pago;
import models.PagoLinea;
import models.Usuario;
import models.informes.InformeEstadisticoDeudaProveedores;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import utils.validation.DateValidation;
import utils.validation.RequiredValidation;
import utils.validation.Validator;
import views.html.contabilidad.balanceCuentaPropia.*;
import views.html.contabilidad.pagos.acciones.modalPagarCheques;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class BalanceCuentaPropiaController extends Controller {
	
	final static Form<BalanceCuentaPropia> balanceCuentaForm = form(BalanceCuentaPropia.class);
	
	public static Result URL_LISTA_BALANCE_CUENTA = redirect(
			controllers.contabilidad.routes.BalanceCuentaPropiaController.index() +"?"+ UriTrack.decode()
	);
	
	@CheckPermiso(key = "listadoBalanceCuentaPropia")
	public static Result index() {

		DynamicForm d = form().bindFromRequest();
		
		return ok(
				indexBalanceCuentaPropia.render(
						BalanceCuentaPropia.page(
								RequestVar.get("cuenta_propia_id"),
								RequestVar.get("expediente.id"),
								RequestVar.get("proveedor.id"),
								RequestVar.get("fecha_desde"),
								RequestVar.get("fecha_hasta"),
								RequestVar.get("fecha_debito_desde"),
								RequestVar.get("fecha_debito_hasta"),
								RequestVar.get("ordenPago.id"),
								RequestVar.get("btnFiltro[0]"),//en curso 
								RequestVar.get("btnFiltro[1]"),//pagado
								RequestVar.get("btnFiltro[2]"),//conciliado
								RequestVar.get("btnFiltro[3]"),
								RequestVar.get("ejercicio"),
								RequestVar.get("referencia"),
								RequestVar.get("numero_cheque")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "listadoBalanceCuentaPropia")
	public static Result archivoIndex() {
		Pagination<BalanceCuentaPropia> bcpx =BalanceCuentaPropia.page(
																	RequestVar.get("cuenta_propia_id"),
																	RequestVar.get("expediente.id"),
																	RequestVar.get("proveedor.id"),
																	RequestVar.get("fecha_desde"),
																	RequestVar.get("fecha_hasta"),
																	RequestVar.get("fecha_debito_desde"),
																	RequestVar.get("fecha_debito_hasta"),
																	RequestVar.get("ordenPago.id"),
																	RequestVar.get("btnFiltro[0]"),//en curso 
																	RequestVar.get("btnFiltro[1]"),//pagado
																	RequestVar.get("btnFiltro[2]"),//conciliado
																	RequestVar.get("btnFiltro[3]"),
																	RequestVar.get("ejercicio"),
																	RequestVar.get("referencia"),
																	RequestVar.get("numero_cheque")
																	 );
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		Integer fila = 10;
		
		Integer celdaCuenta = 0;
		Integer celdaFechaEmision = 1;
		Integer celdaFecha = 2;
		Integer celdaFechaDebito = 3;
		Integer celdaOp = 4;
		Integer celdaExp = 5;
		Integer celdaChTr = 6;
		Integer celdaRef = 7;
		Integer celdaOrden = 8;
		Integer celdaDebito = 9;
		Integer celdaDeposito = 10;
		Integer celdaEstado = 11;
		
		try {
			File archivo = new File(dirTemp+"/informe-libro-banco.xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/contabilidad/informe-libro-banco.xls"));
			
			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;


			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));
			
			CellStyle cellStyle = libro.createCellStyle(); 
			CreationHelper createHelper = libro.getCreationHelper(); 
			cellStyle.setDataFormat( createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
			
				for (BalanceCuentaPropia bcp : bcpx.getList()) {
				 
					Row f = hoja.createRow(fila);
					
				 

					
					celda = f.createCell(celdaCuenta);
					celda.setCellValue((bcp.cuentaPropia != null)?bcp.cuentaPropia.nombre:"");
					
					celda = f.createCell(celdaFechaEmision);
					celda.setCellValue((bcp.fecha_emision != null)?utils.DateUtils.formatDate(bcp.fecha_emision):(bcp.fecha != null)?utils.DateUtils.formatDate(bcp.fecha):"");
					celda.setCellStyle(cellStyle);
					
					celda = f.createCell(celdaFecha);
					celda.setCellValue((bcp.fecha != null)?utils.DateUtils.formatDate(bcp.fecha):"");
					celda.setCellStyle(cellStyle);
					
					celda = f.createCell(celdaFechaDebito);
					celda.setCellValue((bcp.fecha_debito != null)?utils.DateUtils.formatDate(bcp.fecha_debito):"");
					celda.setCellStyle(cellStyle);
					
					String ops = "";
					for(BalanceCuentaPropiaOrdenPago bop : bcp.balanceCuentaPropiaOrdenPago){
						ops += bop.ordenPago.getOrdenEjercicio()+" - "; 
					}
					celda = f.createCell(celdaOp);
					celda.setCellValue(ops);
					
					String expedientes = "";
					for(BalanceCuentaPropiaExpediente bpe : bcp.balanceCuentaPropiaExpediente){
						expedientes += bpe.expediente.getExpedienteEjercicio()+" - "; 
					}
					
					celda = f.createCell(celdaExp);
					celda.setCellValue(expedientes);
					
					celda = f.createCell(celdaChTr);
					celda.setCellValue((bcp.numero_cheque != null)?bcp.numero_cheque:"");
					
					celda = f.createCell(celdaChTr);
					celda.setCellValue((bcp.numero_cheque != null)?bcp.numero_cheque:"");
					
					celda = f.createCell(celdaRef);
					celda.setCellValue((bcp.referencia != null)?bcp.referencia:"");
					
					celda = f.createCell(celdaOrden);
					celda.setCellValue((bcp.a_la_orden != null)?bcp.a_la_orden:"");
					
					celda = f.createCell(celdaDebito);
					celda.setCellValue(bcp.debito.doubleValue());
					celda.setCellStyle(style);
					
					celda = f.createCell(celdaDeposito);
					celda.setCellValue(bcp.deposito.doubleValue());
					celda.setCellStyle(style);
					
					celda = f.createCell(celdaEstado);
					celda.setCellValue((bcp.estado != null)?bcp.estado.nombre:"");
					
				 
					fila++;
				}
			 
			 
			 
			 libro.write(archivoTmp);   
			  
				Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
				out.flush();
				out.close();
				
				
				return ok(archivo);
				
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
			
			return ok();
			
	}
	
	
	
	public static Result listaPagos(Long blcpId) {
		
		List<BalanceCuentaPropiaPago> lm = BalanceCuentaPropiaPago.find.where().eq("balance_cuenta_propia_id", blcpId).findList();
		
		List<Long> idsPagos = new ArrayList<Long>();
		for(BalanceCuentaPropiaPago cl : lm){
			idsPagos.add(cl.pago_id);
		}
		
		List<Pago> pl = Pago.find.where().in("id", idsPagos).findList();
		
		return ok(listaPagos.render(pl));
	}
	
	@CheckPermiso(key = "agregarMovimientoBalanceCuentaPropia")
	public static Result modalAgregarMovimientoBalanceCuentaPropia() {
		Map<String,String> b = new HashMap<String, String>();
		
		Form<BalanceCuentaPropia> linea = form(BalanceCuentaPropia.class).bind(b);
		linea.discardErrors();
		return ok(modalAgregarMovimientoBalanceCuentaPropiar.render(linea));
	}
	
	@CheckPermiso(key = "agregarMovimientoBalanceCuentaPropia")
	public static Result agregarMovimientoBalanceCuentaPropia() {
		
		Form<BalanceCuentaPropia> bcpForm = form(BalanceCuentaPropia.class).bindFromRequest();
		
		ObjectNode restJs = Json.newObject();
		validarForm(bcpForm);
		try {
			if(bcpForm.hasErrors()){
				flash("error", "Error en formulario");
				return ok(modalAgregarMovimientoBalanceCuentaPropiar.render(bcpForm));	
			}
			
			BalanceCuentaPropia df = bcpForm.get();
			
			if(df.estado_id.intValue() == Estado.PAGO_ESTADO_CONCILIADO && df.fecha_debito == null){
				bcpForm.reject("fecha_debito","Ingrese fecha");
				return ok(modalAgregarMovimientoBalanceCuentaPropiar.render(bcpForm));	
			}
			
			if(df.estado_id.intValue() == Estado.PAGO_ESTADO_CANCELADO && df.fecha_cancelado == null){
				bcpForm.reject("fecha_cancelado","Ingrese fecha");
				return ok(modalAgregarMovimientoBalanceCuentaPropiar.render(bcpForm));	
			}
			
			df.create_usuario_id  = new Long(Usuario.getUsuarioSesion());
			df.create_date = new Date();
			df.fecha_emision = df.fecha;
			df.tipo_balance_cuentas_propias_id = new Long(3);
			df.save();
			
		} catch (PersistenceException pe) {
			flash("error", "Error en formulario");
			return ok(modalAgregarMovimientoBalanceCuentaPropiar.render(bcpForm));	
		}
		
		restJs.put("html", modalAgregarMovimientoBalanceCuentaPropiar.render(bcpForm).toString());		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	@CheckPermiso(key = "transferenciaEntreCuentasPropias")
	public static Result modalTransferenciaEntreCuentasPropias() {
		return ok(modalTransferenciaEntreCuentasPropias.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "transferenciaEntreCuentasPropias")
	public static Result transferenciaEntreCuentasPropias() throws ParseException {
		
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		 
		Validator v = new Validator(d);
		v.add(new DateValidation("fecha", "Fecha incorrecta"));
		v.add(new RequiredValidation("cuenta_propia_id_debito", "Cuenta requerida"));
		v.add(new RequiredValidation("cuenta_propia_id_credito", "Cuenta requerida"));
		v.add(new RequiredValidation("importe", "Importe requerido"));
		v.add(new RequiredValidation("fecha", "fecha requerido"));
		v.add(new RequiredValidation("referencia", "referencia requerido"));
		v.validate();
		
		if(d.hasErrors())
			return ok(modalTransferenciaEntreCuentasPropias.render(d));
		
		
		Logger.debug("zzzzzzzzzzzzzz "+d.get());
		
		Integer idCuentaDebito = new Integer(d.get("cuenta_propia_id_debito"));
		Integer idCuentaCredito = new Integer(d.get("cuenta_propia_id_credito"));
		String referencia = d.get("referencia");
		String a_la_orden = d.get("a_la_orden");
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatoFecha.parse(d.get("fecha"));
		
		BigDecimal importe =new BigDecimal(d.get("importe").replace(",","."));
		
		if(idCuentaCredito.equals(idCuentaDebito)){
			flash("error", "Debe seleccionar una cuentas diferentes para la transferencia.");
			return ok(modalTransferenciaEntreCuentasPropias.render(d));	
		}
		
		ObjectNode restJs = Json.newObject();
		
		try {
			
			BalanceCuentaPropia deb = new BalanceCuentaPropia();
			deb.cuenta_propia_id = idCuentaDebito;
			deb.debito = importe;
			deb.deposito = new BigDecimal(0);
			deb.a_la_orden = "";
			deb.referencia = referencia;
			deb.numero_cheque = "";
			deb.fecha = fecha;
			deb.fecha_emision = fecha;
			deb.fecha_debito = fecha;
			deb.create_usuario_id  = new Long(Usuario.getUsuarioSesion());
			deb.create_date = new Date();
			deb.estado_id = (long) Estado.PAGO_ESTADO_CONCILIADO;
			deb.a_la_orden = a_la_orden;
			deb.tipo_balance_cuentas_propias_id = new Long(2);
			deb.save();
			
			BalanceCuentaPropia cre = new BalanceCuentaPropia();
			cre.cuenta_propia_id = idCuentaCredito;
			cre.debito = new BigDecimal(0);
			cre.deposito = importe;
			cre.a_la_orden = "";
			cre.referencia = referencia;
			cre.numero_cheque = "";
			cre.fecha = fecha;
			cre.fecha_emision = fecha;
			cre.fecha_debito = fecha;
			cre.create_usuario_id  = new Long(Usuario.getUsuarioSesion());
			cre.create_date = new Date();
			cre.estado_id = (long) Estado.PAGO_ESTADO_CONCILIADO;
			cre.a_la_orden = a_la_orden;
			cre.tipo_balance_cuentas_propias_id = new Long(2);
			cre.origen_balance_cuenta_propia_id = deb.id;
			cre.save();
			
		 
			
		} catch (PersistenceException pe) {
			flash("error", "Error en formulario"+pe);
			return ok(modalTransferenciaEntreCuentasPropias.render(d));	
		}
		
		restJs.put("html", modalTransferenciaEntreCuentasPropias.render(d).toString());		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result getOrdenes(Long id) {
		
		List<BalanceCuentaPropiaOrdenPago> listaOrden = BalanceCuentaPropiaOrdenPago.find									 
									 .fetch("ordenPago", "numero")
						    		 .fetch("ordenPago.ejercicio", "nombre")
									 .where().eq("balance_cuenta_propia_id", id)
									 .findList();
		String o = "";
		
		for(BalanceCuentaPropiaOrdenPago a:  listaOrden ) {
			o += a.ordenPago.getNombreCompleto()+", ";
		}
		
		if (listaOrden.isEmpty()) {
			o = "Sin Ordenes";
		}
		
		
		return ok(o.replaceAll(", $", ""));
	}
	
	public static Result getExpedientes(Long id) {
		
		List<BalanceCuentaPropiaExpediente> listaExp = BalanceCuentaPropiaExpediente.find									 
									 .fetch("expediente", "nombre")
									 .fetch("expediente.ejercicio", "nombre")
									 .where().eq("balance_cuenta_propia_id", id)
									 .findList();
		String o = "";
		
		for(BalanceCuentaPropiaExpediente a:  listaExp ) {
			o += a.expediente.getExpedienteEjercicio()+", ";
		}
		
		if (listaExp.isEmpty()) {
			o = "Sin Expedientes";
		}
		
		return ok(o.replaceAll(", $", ""));
	}
	
	public static void validarForm(Form<BalanceCuentaPropia> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("fecha", "Fecha inválida"));
		v.add(new DateValidation("fecha_debito", "Fecha inválida"));
		v.validate();
	}
}
