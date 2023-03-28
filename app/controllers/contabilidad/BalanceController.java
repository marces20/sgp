package controllers.contabilidad;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.AutorizadoLinea;
import models.Balance;
import models.Estado;
import models.Factura;
import models.Orden;
import models.Periodo;
import models.UltimaCotizacion;
import models.Cuenta;
import models.Usuario;
import models.informes.InformeDeudaProveedoresMaterializada;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.RequestVar;
import utils.StringUtils;
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.contabilidad.facturas.acciones.reporte322;
import views.html.dashboard.controlDeuda.controlDeudaMonedaExtranjera;
import views.html.contabilidad.balance.*; 

@Security.Authenticated(Secured.class)
public class BalanceController extends Controller {
	
	final static Form<Balance> balanceForm = form(Balance.class);
	
	@CheckPermiso(key = "verBalance")
	public static Result index() {

		DynamicForm d = form().bindFromRequest();
		Logger.debug("11111111111111111");
		return ok(
				indexBalance.render(
						Balance.page(
								RequestVar.get("cuenta_propia_id"),
								RequestVar.get("fecha_desde"),
								RequestVar.get("fecha_hasta"),
								RequestVar.get("btnFiltro[0]"),//en curso 
								RequestVar.get("btnFiltro[1]"),//pagado
								RequestVar.get("btnFiltro[2]"),//conciliado
								RequestVar.get("btnFiltro[3]"),
								RequestVar.get("ejercicio"),
								RequestVar.get("cuenta.id"),
								RequestVar.get("tipo"),
								RequestVar.get("expediente.id"),
								RequestVar.get("ordenPago.id"),
								RequestVar.get("marca")
								 ),
								 d));
	}
	
	public static Result general() {
		List<Cuenta> cuentas = Cuenta.getHijos();
		return ok(indexBalanceGeneral.render(cuentas, Balance.getBalance()));
	}
	
	public static Result modalAgregarMovimientoBalance() {
		Map<String,String> b = new HashMap<String, String>();
		
		Form<Balance> linea = form(Balance.class).bind(b);
		linea.discardErrors();
		
		return ok(modalAgregarMovimientoBalance.render(linea));
	}
	
	@CheckPermiso(key = "agregarMovimientoBalance")
	public static Result agregarMovimientoBalance() {
		
		Form<Balance> bcpForm = form(Balance.class).bindFromRequest();
		
		ObjectNode restJs = Json.newObject();
		validarForm(bcpForm);
		try {
			if(bcpForm.hasErrors()){
				flash("error", "Error en formulario");
				return ok(modalAgregarMovimientoBalance.render(bcpForm));	
			}
			
			Balance df = bcpForm.get();
			df.create_usuario_id  = new Long(Usuario.getUsuarioSesion());
			df.create_date = new Date();
			df.save();
			
		} catch (PersistenceException pe) {
			flash("error", "Error en formulario"+pe.toString());
			return ok(modalAgregarMovimientoBalance.render(bcpForm));	
		}
		
		restJs.put("html", modalAgregarMovimientoBalance.render(bcpForm).toString());		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static void validarForm(Form<Balance> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("fecha", "Fecha inválida"));
		v.add(new DateValidation("fecha_debito", "Fecha inválida"));
		v.validate();
	}
	
	public static Result modalPasarBorrador() {
		return ok(modalPasarBorrador.render(form().bindFromRequest()));
	}
	
	public static Result pasarBorradorMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> idSeleccionados = getSeleccionados();
		
		if(idSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una linea.");
			return ok(modalPasarBorrador.render(d));
		}	
		
		if(d.hasErrors())
			return ok(modalPasarBorrador.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Balance.modificarEstadoMasivo(Estado.BALANCE_BORRADOR, idSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ idSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarBorrador.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarBorrador.render(d));
		}
		
	}
	
	public static Result modalPasarControlado() {
		return ok(modalPasarControlado.render(form().bindFromRequest()));
	}
	
	public static Result pasarControladoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> idSeleccionados = getSeleccionados();
		
		if(idSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una linea.");
			return ok(modalPasarControlado.render(d));
		}	
		
		if(d.hasErrors())
			return ok(modalPasarControlado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Balance.modificarEstadoMasivo(Estado.BALANCE_CONTROLADO, idSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ idSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarControlado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalPasarControlado.render(d));
		}
		
	}
	
	public static Result modalCambiarCuenta() {
		return ok(modalCambiarCuenta.render(form().bindFromRequest()));
	}
	
	public static Result cambiarCuentaMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> idSeleccionados = getSeleccionados();
		
		if(idSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una linea.");
			return ok(modalCambiarCuenta.render(d));
		}	
		
		Integer idCuenta = null;
		if(!request().body().asFormUrlEncoded().get("cuenta_id")[0].isEmpty()){
			idCuenta = new Integer(request().body().asFormUrlEncoded().get("cuenta_id")[0]);
		}else {
			flash("error", "Seleccione una cuenta.");
			return ok(modalCambiarCuenta.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalCambiarCuenta.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Balance.modificarCuentaMasivo(idCuenta, idSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ idSeleccionados.size() +" seleccionados.");
			result.put("html", modalCambiarCuenta.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalCambiarCuenta.render(d));
		}
		
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
	
	
	public static Result archivoExcel() {
		
		List<Integer> balanSeleccionados = getSeleccionados();
		
		if(balanSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado balances.");
			return ok(reporte322.render(null));
		}
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/lineas.xls");	
		
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
			
			Sheet hoja = libro.createSheet("lineas");
			
			 
			List<Balance> b = Balance.find.where().in("id",balanSeleccionados).findList();
			
			if(b.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("CUENTA");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(1);
				celda0.setCellValue("CUENTA BALANCE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("OP");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("EXPEDIENTE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("FECHA");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("DEBE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("HABER");
				celda0.setCellStyle(comun);
				x++;
				for(Balance oll : b){
					fila = hoja.createRow(x);
					
					celda0 = fila.createCell(0);
					celda0.setCellValue(oll.cuentaPropia.nombre);
					celda0.setCellStyle(comun);
					
					celda0 = fila.createCell(1);
					celda0.setCellValue(oll.cuenta.nombre);
					celda0.setCellStyle(comun);
					
					if(oll.orden_pago_id != null){
						 
						celda0 = fila.createCell(2);
						celda0.setCellValue(oll.ordenPago.getNombreCompleto());
						celda0.setCellStyle(comun);
					}
					
					 
					
					celda0 = fila.createCell(3);
					celda0.setCellValue(oll.expediente.getExpedienteEjercicio());
					celda0.setCellStyle(comun);
					
					String fecha = (oll.fecha != null)?utils.DateUtils.formatDate(oll.fecha):"";
					celda0 = fila.createCell(4);
					celda0.setCellValue(fecha);
					celda0.setCellStyle(comun);
					
					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.debe.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					
					celda0 = fila.createCell(6);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.haber.doubleValue());
					celda0.setCellStyle(estiloMoneda); 
					
					x++;
				}
				
			}	
			
			libro.write(archivoTmp); 
			flash("success", "El archivo fue creado correctamente.");
			return ok(reporte322.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(reporte322.render(null));
			
	}
	
	
	public static Result archivoBejerman() {
		
		List<Integer> balanSeleccionados = getSeleccionados();
		
		if(balanSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado balances.");
			return ok(modalBejerman.render(null,null));
		}
		
		try {
			DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
			unusualSymbols.setDecimalSeparator('.');
			
			DecimalFormat df = new DecimalFormat("#.##",unusualSymbols);
			String newLine = System.getProperty("line.separator");
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/USUARIO1.IMP");
			File archivo2 = new File(dirTemp+"/USUARIO2.IMP");
			//FileOutputStream file = new FileOutputStream(archivo);
			String linea = "";
			String linea2 = "";
			String fecha = DateUtils.formatDate(new Date(), "MM-yyyy");
			
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "UTF8"));
			Writer out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo2), "UTF8"));
			
			List<Integer> asientos = new ArrayList<Integer>();
				
			for (Balance b1 : Balance.find.where()
					  				.in("id",balanSeleccionados)
									.gt("haber", BigDecimal.ZERO)
									.orderBy("id asc").findList()) {
				String fechac = DateUtils.formatDate(b1.fecha, "yyyyMMdd"); 
				
				
				
				if(!asientos.contains(b1.asiento)) {	 
					
					
					linea= "";
					linea += StringUtils.alfanumericoPadStart(b1.asiento.toString(),6);// Número de asiento (6 posiciones).
					linea += StringUtils.alfanumericoPadStart(fechac, 8);//Fecha de asiento (8 posiciones: aaaammdd).
					linea += StringUtils.alfanumerico(b1.cuenta.nombre, 30);//Concepto (30 posiciones).
					linea += StringUtils.alfanumericoPadStart("R", 1);//Tipo (1 posición; <R> = Real, <P>= Presupuestado, <A> = Apertura).
					linea += StringUtils.alfanumericoPadStart("1", 3);//Código de moneda del asiento (3 posiciones ; 1= Moneda de curso legal).
					linea += StringUtils.alfanumericoPadStart("", 3);//Código de asiento automático (3 posiciones);
					//linea += StringUtils.alfanumericoPadStart("", 2);//Caracteres de control 13 + 10 (2 posiciones)
					linea += "\r\n";
					out.append(linea);
				}
				
				if(!asientos.contains(b1.asiento)) {	 
					for (Balance b : Balance.find.where().eq("asiento",b1.asiento).orderBy("id asc").findList()) {
							
								
							
						 
							
							
							
							
								//for (Balance b2 : Balance.find.where().eq("asiento",b.asiento).orderBy("id asc").findList()) {
									String dh = "D";
									//String dfxc = new DecimalFormat("000000000.00").format(b.debe);
									BigDecimal dfxc = new BigDecimal(0);
									dfxc = b.debe;
									if(b.haber.compareTo(BigDecimal.ZERO) > 0) {
										 dh = "H";
										 dfxc = b.haber;
									}
									
									DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
									simbolos.setDecimalSeparator('.');
									DecimalFormat myFormatter = new DecimalFormat("########0.00",simbolos);
									String dfxcSTR = myFormatter.format(dfxc.doubleValue());
									
									linea2= "";
									linea2 += StringUtils.alfanumericoPadStart(b.asiento.toString(),6);//Número de asiento (6 posiciones).
									linea2 += StringUtils.alfanumerico(b.cuenta.code.replace(".", "").replace(" ",""),15);//Código de cuenta (15 posiciones).
									linea2 += StringUtils.alfanumericoPadStart("",8);//Fecha alternativa (8 posiciones: aaaammdd), si no tiene se graba la fecha del asiento.
									linea2 += StringUtils.alfanumericoPadStart(b.expediente.getExpedienteEjercicio(),30);//Leyenda (30 posiciones).
									linea2 += StringUtils.alfanumerico(dh,1);//Columna (1; <D> = Debe, <H> = Haber).
									//linea2 += StringUtils.alfanumericoPadStart(dfxc.toString().replace(",", "."),15);//Importe (15 posiciones; 12 enteros, punto decimal, 2 decimales).
									linea2 += StringUtils.alfanumericoPadStart(dfxcSTR,15);//Importe (15 posiciones; 12 enteros, punto decimal, 2 decimales).
									linea2 += StringUtils.alfanumericoPadStart("",17);//Cantidad en unidad alternativa (17 posiciones; 12 enteros, punto decimal, 4 decimales).
									linea2 += StringUtils.alfanumericoPadStart("",15);//Importe en moneda del asiento (15 posiciones; 12 enteros, punto decimal, 2 decimales).
									linea2 += StringUtils.alfanumericoPadStart(fechac,8);//Fecha de origen (8 posiciones: aaaammdd), si no tiene se asume la fecha del asiento.
									//linea2 += StringUtils.alfanumericoPadStart("",2);//Caracteres de control 13 + 10 (2 posiciones), que posibilitan la lectura secuencial del	archivo.
									linea2 += "\r\n";
									out2.append(linea2);
								//}
							
					}	
					 
				} 
				
				if(!asientos.contains(b1.asiento)) {
					asientos.add(b1.asiento);
				}
			}
			
			 
			out.flush();
			out.close();
			
			out2.flush();
			out2.close();
			
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalBejerman.render(archivo.getPath(),archivo2.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(modalBejerman.render(null,null));
	}
	
	public static Result archivoBejermanPagos() {
		
		List<Integer> balanSeleccionados = getSeleccionados();
		
		if(balanSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado balances.");
			return ok(modalBejerman.render(null,null));
		}
		
		try {
			DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
			unusualSymbols.setDecimalSeparator('.');
			
			DecimalFormat df = new DecimalFormat("#.##",unusualSymbols);
			String newLine = System.getProperty("line.separator");
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/USUARIO1.IMP");
			File archivo2 = new File(dirTemp+"/USUARIO2.IMP");
			//FileOutputStream file = new FileOutputStream(archivo);
			String linea = "";
			String linea2 = "";
			String fecha = DateUtils.formatDate(new Date(), "MM-yyyy");
			
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "UTF8"));
			Writer out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo2), "UTF8"));
			
			List<Integer> asientos = new ArrayList<Integer>();
				
			for (Balance b1 : Balance.find.where()
					  				.in("id",balanSeleccionados)
									.gt("debe", BigDecimal.ZERO)
									.orderBy("id asc").findList()) {
				String fechac = DateUtils.formatDate(b1.fecha, "yyyyMMdd"); 
				
				
				
				if(!asientos.contains(b1.asiento)) {	 
					
					
					linea= "";
					linea += StringUtils.alfanumericoPadStart(b1.asiento.toString(),6);// Número de asiento (6 posiciones).
					linea += StringUtils.alfanumericoPadStart(fechac, 8);//Fecha de asiento (8 posiciones: aaaammdd).
					linea += StringUtils.alfanumerico(b1.cuenta.nombre, 30);//Concepto (30 posiciones).
					linea += StringUtils.alfanumericoPadStart("R", 1);//Tipo (1 posición; <R> = Real, <P>= Presupuestado, <A> = Apertura).
					linea += StringUtils.alfanumericoPadStart("1", 3);//Código de moneda del asiento (3 posiciones ; 1= Moneda de curso legal).
					linea += StringUtils.alfanumericoPadStart("", 3);//Código de asiento automático (3 posiciones);
					//linea += StringUtils.alfanumericoPadStart("", 2);//Caracteres de control 13 + 10 (2 posiciones)
					linea += "\r\n";
					out.append(linea);
				}
				
				if(!asientos.contains(b1.asiento)) {	 
					for (Balance b : Balance.find.where().eq("asiento",b1.asiento).orderBy("id asc").findList()) {
							
								
							
						 
							
							
							
							
								//for (Balance b2 : Balance.find.where().eq("asiento",b.asiento).orderBy("id asc").findList()) {
									String dh = "D";
									//String dfxc = new DecimalFormat("000000000.00").format(b.debe);
									BigDecimal dfxc = new BigDecimal(0);
									dfxc = b.debe;
									if(b.haber.compareTo(BigDecimal.ZERO) > 0) {
										 dh = "H";
										 dfxc = b.haber;
									}
									 
									
									DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
									simbolos.setDecimalSeparator('.');
									DecimalFormat myFormatter = new DecimalFormat("########0.00",simbolos);
									String dfxcSTR = myFormatter.format(dfxc.doubleValue());
									 

									linea2= "";
									linea2 += StringUtils.alfanumericoPadStart(b.asiento.toString(),6);//Número de asiento (6 posiciones).
									linea2 += StringUtils.alfanumerico(b.cuenta.code.replace(".", "").replace(" ",""),15);//Código de cuenta (15 posiciones).
									linea2 += StringUtils.alfanumericoPadStart("",8);//Fecha alternativa (8 posiciones: aaaammdd), si no tiene se graba la fecha del asiento.
									linea2 += StringUtils.alfanumericoPadStart(b.expediente.getExpedienteEjercicio(),30);//Leyenda (30 posiciones).
									linea2 += StringUtils.alfanumerico(dh,1);//Columna (1; <D> = Debe, <H> = Haber).
									//linea2 += StringUtils.alfanumericoPadStart(dfxc.toString().replace(",", "."),15);//Importe (15 posiciones; 12 enteros, punto decimal, 2 decimales).
									linea2 += StringUtils.alfanumericoPadStart(dfxcSTR,15);//Importe (15 posiciones; 12 enteros, punto decimal, 2 decimales).

									linea2 += StringUtils.alfanumericoPadStart("",17);//Cantidad en unidad alternativa (17 posiciones; 12 enteros, punto decimal, 4 decimales).
									linea2 += StringUtils.alfanumericoPadStart("",15);//Importe en moneda del asiento (15 posiciones; 12 enteros, punto decimal, 2 decimales).
									linea2 += StringUtils.alfanumericoPadStart(fechac,8);//Fecha de origen (8 posiciones: aaaammdd), si no tiene se asume la fecha del asiento.
									//linea2 += StringUtils.alfanumericoPadStart("",2);//Caracteres de control 13 + 10 (2 posiciones), que posibilitan la lectura secuencial del	archivo.
									linea2 += "\r\n";
									out2.append(linea2);
								//}
							
					}	
					 
				} 
				
				if(!asientos.contains(b1.asiento)) {
					asientos.add(b1.asiento);
				}
			}
			
			 
			out.flush();
			out.close();
			
			out2.flush();
			out2.close();
			
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalBejerman.render(archivo.getPath(),archivo2.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(modalBejerman.render(null,null));
	}
	
	
	public static Result controlBalanceFactura() {
		
		List<SqlRow>  row = null;
		List<Factura> lf =  null;
		
		if(!RequestVar.get("periodo.id").isEmpty()){
			
			Periodo p = Periodo.find.byId(new Long(RequestVar.get("periodo.id"))) ;
			 
		
		String sql = "select b.id as id,b.fecha as fecha,b.orden_pago_id as orden_pago_id,b.haber as haber,b.expediente_id as expediente_id,cp.nombre as cuentaPropiaNombre,"
				+ "c.nombre as cuenta,e.nombre || '/' || ej.nombre as nombreExp,op.numero || '/' || ejop.nombre as opNombre " + 
				"from balances b " +
				"inner join cuentas_propias cp on cp.id = b.cuenta_propia_id " +
				"inner join cuentas c on c.id = b.cuenta_id " +
				"inner join expedientes e on e.id = b.expediente_id " +
				"inner join ejercicios ej on ej.id = e.ejercicio_id " +
				"inner join ordenes_pagos op on op.id = b.orden_pago_id " +
				"inner join ejercicios ejop on ejop.id = op.ejercicio_id " +
				"where " + 
				"b.tipo='facturas' and " + 
				"b.fecha >= :fdesde and  " + 
				"b.fecha <= :fhasta " + 
				"and debe = 0 " + 
				"order by b.fecha,haber asc ";
				SqlQuery sqlQuery = Ebean.createSqlQuery(sql)
									.setParameter("fdesde",  p.date_start)
									.setParameter("fhasta", p.date_stop);
				 row = sqlQuery.findList();
				 
				 
				 
				 lf = Factura.find
						    .select("id,  base, fecha_orden_pago")
			    			.fetch("proveedor", "nombre")
			    			.fetch("expediente", "nombre, id, emergencia")
			    			.fetch("expediente.ejercicio", "nombre")
			    			.fetch("tipoCuenta", "nombre")
			    			.fetch("expediente.parent.ejercicio", "nombre")
			    			.fetch("periodo", "nombre")
			    			.fetch("estado", "nombre")
			    			.fetch("ordenPago", "nombreCompleto")
			    			.fetch("ordenPago", "numero")
			    			.fetch("ordenPago.ejercicio", "nombre")
						    .where()
						    .ge("fecha_orden_pago", p.date_start)
							.le("fecha_orden_pago", p.date_stop)
							.gt("base", BigDecimal.ZERO)
							.eq("state_id", Estado.FACTURA_ESTADO_APROBADO).orderBy("fecha_orden_pago,base asc")
							.findList();
		}
		
		
		 
		
		return ok(controlBalanceFactura.render(row,lf,form().bindFromRequest()));
	}
	
	 
}
