package controllers.recupero;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
//import java.time.LocalDate;
//import java.time.ZoneId;
import java.util.List;

import models.CuentaAnalitica;
import models.DireccionCliente;
import models.Estado;
import models.recupero.Cheque;
import models.recupero.InformeTotal;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoFacturaLinea;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoPago;
import models.recupero.RecuperoPlanilla;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.RequestVar;
import utils.pagination.Pagination; 
import views.html.contabilidad.pagos.reportes.modalInformeLote;
import views.html.contabilidad.pagos.reportes.modalInformeMensualImpuestos;
import views.html.recupero.recuperoFactura.modalPlanilla;
import views.html.recupero.recuperoPlanilla.reportePlanilla;
import views.html.recupero.informes.*;
import controllers.Secured;

@Security.Authenticated(Secured.class)
public class RecuperoReportesController extends Controller {
	
	public static Result reporteFacturasExcel() {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		List<Integer> seleccionadas = getSeleccionados();
		
		if(seleccionadas.isEmpty()) {
			flash("error", "No seleccionadas se han seleccionado facturas.");
			return ok(modalInformeLote.render(null));
		}
		
		
		try {
			File archivo = new File(dirTemp+"/reporte-facturas.xls");
			if(archivo.exists()) archivo.delete();
			//FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/recupero/planilla.xls"));
			archivo.createNewFile();
			 
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			 
			Sheet hoja = libro.createSheet("facturas");
			Cell celda;
			
			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			CellStyle comun = libro.createCellStyle();
			comun.setDataFormat((short) 10);
			comun.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			comun.setAlignment(CellStyle.ALIGN_CENTER);
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			comun.setWrapText(true);
			Font font2 = libro.createFont();
	        font2.setFontHeightInPoints((short) 10);
	        comun.setFont(font2);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 10);
			estiloMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			estiloMoneda.setAlignment(CellStyle.ALIGN_CENTER);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			estiloMoneda.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));
		    estiloMoneda.setFont(font2);
		    
		    
		    List<RecuperoFactura> rp = RecuperoFactura.find.where().in("id", seleccionadas).orderBy("fecha").findList();
		    
		    Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Fecha");
			fila.createCell(1).setCellValue("Cliente");
			fila.createCell(2).setCellValue("N?? Factura");
			fila.createCell(3).setCellValue("Base");
			fila.createCell(4).setCellValue("Total Nota Credito");
			fila.createCell(5).setCellValue("Total");
			
			int f = 1;
		    for(RecuperoFactura rpx :rp){
		    	fila = hoja.createRow(f);
		    	
		    	for(int c=0;c<6;c++){
					celda = fila.createCell(c);
					
					switch (c) {
						case 0:
							celda.setCellValue(utils.DateUtils.formatDate(rpx.fecha));
							celda.setCellStyle(comun);
							break;
						case 1:
							celda.setCellValue(rpx.cliente.nombre);
							celda.setCellStyle(comun);
							break;	
						case 2:
							celda.setCellValue(rpx.numero);
							celda.setCellStyle(comun);
							break;
						case 3:
							Double base = (rpx.getBase() != null)?rpx.getBase().setScale(2, RoundingMode.HALF_DOWN).doubleValue():0;
							
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(base);
							celda.setCellStyle(estiloMoneda);
							break;
						case 4:
							Double credito = (rpx.getTotalNotaCredito() != null)?rpx.getTotalNotaCredito().setScale(2, RoundingMode.HALF_DOWN).doubleValue():0;
							
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(credito);
							celda.setCellStyle(estiloMoneda);
							break;
						case 5:
							Double total = (rpx.getTotal() != null)?rpx.getTotal().setScale(2, RoundingMode.HALF_DOWN).doubleValue():0;
							
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(total);
							celda.setCellStyle(estiloMoneda);
							break;	
										
					}
				}	
				f++;	
						
		    }
		    
		    
		    
		    
		    libro.write(archivoTmp);   
			  
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			
			
			return ok(modalInformeLote.render(archivo.getPath()));
			
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		flash("error", "No seleccionadas se han seleccionado pagos.");
		return ok(modalInformeLote.render(null));
	}
	
	public static Result reportePagosExcel() {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		List<Integer> seleccionadas = getSeleccionados();
		
		if(seleccionadas.isEmpty()) {
			flash("error", "No seleccionadas se han seleccionado pagos.");
			return ok(modalInformeLote.render(null));
		}
		
		
		try {
			File archivo = new File(dirTemp+"/reporte-pagos.xls");
			if(archivo.exists()) archivo.delete();
			//FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/recupero/planilla.xls"));
			archivo.createNewFile();
			 
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			 
			Sheet hoja = libro.createSheet("Pagos");
			Cell celda;
			
			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			CellStyle comun = libro.createCellStyle();
			comun.setDataFormat((short) 10);
			comun.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			comun.setAlignment(CellStyle.ALIGN_CENTER);
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			comun.setWrapText(true);
			Font font2 = libro.createFont();
	        font2.setFontHeightInPoints((short) 10);
	        comun.setFont(font2);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 10);
			estiloMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			estiloMoneda.setAlignment(CellStyle.ALIGN_CENTER);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			estiloMoneda.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));
		    estiloMoneda.setFont(font2);
		    
		    
		    List<RecuperoPago> rp = RecuperoPago.find.where().in("id", seleccionadas).orderBy("fecha").findList();
		    
		    Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Fecha");
			fila.createCell(1).setCellValue("Cliente");
			fila.createCell(2).setCellValue("N?? Factura");
			fila.createCell(3).setCellValue("Total");
			fila.createCell(4).setCellValue("Tipo Pago");
		    
			int f = 1;
		    for(RecuperoPago rpx :rp){
		    	fila = hoja.createRow(f);
		    	
		    	for(int c=0;c<4;c++){
					celda = fila.createCell(c);
					
					switch (c) {
						case 0:
							celda.setCellValue(utils.DateUtils.formatDate(rpx.fecha));
							celda.setCellStyle(comun);
							break;
						case 1:
							celda.setCellValue(rpx.cliente.nombre);
							celda.setCellStyle(comun);
							break;	
						case 2:
							celda.setCellValue(rpx.recuperoFactura.numero);
							celda.setCellStyle(comun);
							break;
						case 3:
							Double base = (rpx.total != null)?rpx.total.setScale(2, RoundingMode.HALF_DOWN).doubleValue():0;
							
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(base);
							celda.setCellStyle(estiloMoneda);
							break;
						case 4:
							celda.setCellValue(rpx.tipoPago);
							celda.setCellStyle(comun);
							break;
										
					}
				}	
				f++;	
						
		    }
		    
		    
		    
		    
		    libro.write(archivoTmp);   
			  
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			
			
			return ok(modalInformeLote.render(archivo.getPath()));
			
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		flash("error", "No seleccionadas se han seleccionado pagos.");
		return ok(modalInformeLote.render(null));
	}
	
	public static Result informeGeneral() {
		
		Pagination<InformeTotal> i = InformeTotal.page(RequestVar.get("cliente_id"), 
				RequestVar.get("periodo_id"), 
				RequestVar.get("expediente_id"), 
				RequestVar.get("ejercicio"),
				RequestVar.get("deuda_mayor"), 
				RequestVar.get("deuda_menor"), 
				RequestVar.get("pago_mayor"), 
				RequestVar.get("pago_menor"),
				RequestVar.get("cliente_tipo_id"),
				RequestVar.get("fecha_factura_desde"),
				RequestVar.get("fecha_factura_hasta")
				);
				
		return ok(informeGeneral.render(i, form().bindFromRequest()));
	}
	
	public static Result informeDeuda() {
		
		Pagination<InformeTotal> i = InformeTotal.page(
													RequestVar.get("cliente_id"), 
													RequestVar.get("periodo_id"), 
													RequestVar.get("expediente_id"), 
													RequestVar.get("ejercicio"),
													RequestVar.get("deuda_mayor"), 
													RequestVar.get("deuda_menor"), 
													RequestVar.get("pago_mayor"), 
													RequestVar.get("pago_menor"),
													RequestVar.get("cliente_tipo_id"),
													RequestVar.get("fecha_factura_desde"),
													RequestVar.get("fecha_factura_hasta")
				);
				
		return ok(deudas.render(i, form().bindFromRequest()));
	}
	
	public static Result archivoInformeDeuda() {

		Pagination<InformeTotal> informe = InformeTotal.page(RequestVar.get("cliente_id"), 
				RequestVar.get("periodo_id"), 
				RequestVar.get("expediente_id"), 
				RequestVar.get("ejercicio"),
				RequestVar.get("deuda_mayor"), 
				RequestVar.get("deuda_menor"), 
				RequestVar.get("pago_mayor"), 
				RequestVar.get("pago_menor"),
				RequestVar.get("cliente_tipo_id"),
				RequestVar.get("fecha_factura_desde"),
				RequestVar.get("fecha_factura_hasta")
				);

		
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		Integer fila = 10;
		
		Integer celdaNumero 		 = 0;
		Integer celdaFecha 			 = 1;
		Integer celdaCliente  		 = 2;
		Integer celdaTotalFactura	 = 3;
		Integer celdaTotalPagos		 = 4;
		Integer celdaTotalDeuda 	 = 5;
		
		
		
		
		try {
			File archivo = new File(dirTemp+"/informe-estadistico.xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/recupero/informe-deuda.xls"));
			
			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;


			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			
		    for (InformeTotal i : informe.getList()) {
		    	
				Row f = hoja.createRow(fila);
				
				//N??mero 
				celda = f.createCell(celdaNumero);
				String orden = "";
				if(i.numero != null)
					celda.setCellValue( i.numero );
				
				//Celda fecha
				celda = f.createCell(celdaFecha);
				celda.setCellValue(DateUtils.formatDate(i.fecha));
				
				//Celda Cliente
				celda = f.createCell(celdaCliente);
				celda.setCellValue( i.cliente.nombre );
				
				//Celda total factura
				celda = f.createCell(celdaTotalFactura);
				celda.setCellValue(i.totalFactura.doubleValue());
				celda.setCellStyle(style);
	
				//Celda total pagos
				celda = f.createCell(celdaTotalPagos);
				celda.setCellValue(i.totalPagos.doubleValue());
				celda.setCellStyle(style);
				

				
				//Celda total de deudas
				celda = f.createCell(celdaTotalDeuda);
				celda.setCellValue(i.totalDeuda.doubleValue());
				celda.setCellStyle(style);

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
		
		
		return ok("ddd");
	}
	
	public static Result archivoInformeGeneral () {

		Pagination<InformeTotal> informe = InformeTotal.page(RequestVar.get("cliente_id"), 
				RequestVar.get("periodo_id"), 
				RequestVar.get("expediente_id"), 
				RequestVar.get("ejercicio"),
				RequestVar.get("deuda_mayor"), 
				RequestVar.get("deuda_menor"), 
				RequestVar.get("pago_mayor"), 
				RequestVar.get("pago_menor"),
				RequestVar.get("cliente_tipo_id"),
				RequestVar.get("fecha_factura_desde"),
				RequestVar.get("fecha_factura_hasta")
				);

		
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		Integer fila = 10;
		Integer celdaInstitucion 	 = 0;
		Integer celdaNumero 		 = 1;
		Integer celdaFecha 			 = 2;
		Integer celdaCliente  		 = 3;
		Integer celdaTotalFactura	 = 4;
		Integer celdaTotalPagos		 = 5;
		Integer celdaTotalDeuda 	 = 6;
		
		
		
		
		try {
			File archivo = new File(dirTemp+"/informe-estadistico.xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/recupero/informe-deuda.xls"));
			
			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;


			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			
		    for (InformeTotal i : informe.getList()) {
		    	
				Row f = hoja.createRow(fila);
				
				
				//Celda fecha
				celda = f.createCell(celdaInstitucion);
				celda.setCellValue((i.deposito != null)?i.deposito.sigla:"");
				
				//N??mero 
				celda = f.createCell(celdaNumero);
				String orden = "";
				if(i.numero != null)
					celda.setCellValue( i.numero );
				
				//Celda fecha
				celda = f.createCell(celdaFecha);
				celda.setCellValue(DateUtils.formatDate(i.fecha));
				
				//Celda Cliente
				celda = f.createCell(celdaCliente);
				celda.setCellValue( i.cliente.nombre );
				
				//Celda total factura
				celda = f.createCell(celdaTotalFactura);
				celda.setCellValue(i.totalFactura.doubleValue());
				celda.setCellStyle(style);
	
				//Celda total pagos
				celda = f.createCell(celdaTotalPagos);
				celda.setCellValue(i.totalPagos.doubleValue());
				celda.setCellStyle(style);
				

				
				//Celda total de deudas
				celda = f.createCell(celdaTotalDeuda);
				celda.setCellValue(i.totalDeuda.doubleValue());
				celda.setCellStyle(style);

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
		
		
		return ok("ddd");
	}
	
	public static Result imprimirRecibo(Long id) {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		RecuperoPago pago = RecuperoPago.find.byId(id);
		
		try {
			File archivo = new File(dirTemp+"/recibo.xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/recupero/recibo.xls"));
			
			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;

			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			Calendar cal = Calendar.getInstance();
		    cal.setTime(pago.fecha);
			
			Row f = hoja.getRow(4);
			celda = f.getCell(5);
			celda.setCellValue(cal.DAY_OF_WEEK+"         " +cal.get(Calendar.MONTH) +"             "+cal.getWeekYear());
			
			//Cliente
			f = hoja.getRow(8);
			celda = f.getCell(1);
			celda.setCellValue(pago.cliente.nombre);
			
			//Localidad
			f = hoja.getRow(10);
			if (pago.cliente.direcciones.get(0).localidad.provincia.pais.id == 11) {
				celda = f.getCell(1);
				
				DireccionCliente direccion = pago.cliente.direcciones.get(0);
				
				celda.setCellValue(direccion.localidad.nombre);
				celda = f.getCell(4);
				celda.setCellValue(direccion.localidad.provincia.nombre);
				
				//Direccion
				f = hoja.getRow(9);
				celda = f.getCell(1);
				celda.setCellValue(direccion.calle + " " + direccion.numero);
			} else {
				celda = f.getCell(1);
				celda.setCellValue(pago.cliente.direcciones.get(0).localidad.provincia.pais.nombre);
			}		
			
			
			
			f = hoja.getRow(13);
			celda = f.getCell(3);
			celda.setCellValue(NumeroALetra.convertNumberToLetterBigDecimal(pago.total));
			
			f = hoja.getRow(30);
			celda = f.getCell(1);
			celda.setCellValue( NumberUtils.moneda(pago.total));
			
			
			
			libro.write(archivoTmp);
			
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			return ok(archivo);
			
		} catch (IOException e) {
		    e.printStackTrace();
		} 
		
		return null;
	}
	
	public static Result imprimirFactura(Long id) {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		RecuperoFactura factura = RecuperoFactura.find.byId(id);
		
		try {
			File archivo = new File(dirTemp+"/factura.xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/recupero/factura.xls"));
			
			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;


			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			
			Calendar cal = Calendar.getInstance();
		    cal.setTime(factura.fecha);

			
			Row f = hoja.getRow(4);
			celda = f.getCell(5);
			celda.setCellValue(cal.DAY_OF_WEEK+"         " +cal.get(Calendar.MONTH) +"             "+cal.getWeekYear());
			   
			
			//Cliente
			f = hoja.getRow(8);
			celda = f.getCell(1);
			celda.setCellValue(factura.cliente.nombre);
			

			
			//Localidad
			f = hoja.getRow(10);
			if (factura.cliente.direcciones.get(0).localidad.provincia.pais.id == 11) {
				celda = f.getCell(1);
				
				DireccionCliente direccion = factura.cliente.direcciones.get(0);
				
				celda.setCellValue(direccion.localidad.nombre);
				celda = f.getCell(4);
				celda.setCellValue(direccion.localidad.provincia.nombre);
				
				//Direccion
				f = hoja.getRow(9);
				celda = f.getCell(1);
				celda.setCellValue(direccion.calle + " " + direccion.numero);
				
			} else {
				celda = f.getCell(1);
				celda.setCellValue(factura.cliente.direcciones.get(0).localidad.provincia.pais.nombre);
			}
			
			List<RecuperoFacturaLinea> lineas = factura.recuperoFacturaLinea;
			
			
			Integer indiceLinea = 14;
			for (RecuperoFacturaLinea l : lineas) {
				
				f = hoja.getRow(indiceLinea);
				
				celda = f.getCell(0);
				celda.setCellValue(l.cantidad.doubleValue());
				
				celda = f.getCell(1);
				celda.setCellValue(l.producto.codigo_rismi);
				
				celda = f.getCell(2);
				celda.setCellValue(l.producto.nombre);
				
				celda = f.getCell(5);
				celda.setCellValue(l.precio.doubleValue());
				
				
				celda = f.getCell(6);
				celda.setCellValue(l.precio.multiply(l.cantidad).doubleValue());
				
				indiceLinea++;
			}
			
			f = hoja.getRow(27);
			celda = f.getCell(2);
			celda.setCellValue(NumeroALetra.convertNumberToLetterBigDecimal(factura.getBase()));
			
			

			hoja.autoSizeColumn((short) 5);

			
			libro.write(archivoTmp);
			
			
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			
			
			return ok(archivo);
			
		} catch (IOException e) {
		    e.printStackTrace();
		} 
		
		return null;
	}
	
	public static Result modalPlanilla() {
		DynamicForm d = form().bindFromRequest();	
		
		return ok(modalPlanilla.render(null,d));
	}
	
	public static Result informePlanilla() {
		DynamicForm d = form().bindFromRequest();	
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		//RecuperoFactura factura = RecuperoFactura.find.byId(id);
		
		Date ffh;
		Date ffd;
		Long puntoventa_id;
		String[] fecha_desde = request().body().asFormUrlEncoded().get("fecha_desde");
		String[] fecha_hasta = request().body().asFormUrlEncoded().get("fecha_hasta");
		String[] puntoventaId = request().body().asFormUrlEncoded().get("puntoventa_id");
		
		if(puntoventaId == null && puntoventaId[0].isEmpty()){
			flash("error", "Debe ingresar un punto de venta.");
			return ok(modalPlanilla.render(null,d));
		}else{
			puntoventa_id = new Long(puntoventaId[0]);
		}
		
		if(fecha_desde == null && fecha_desde[0].isEmpty()){
			flash("error", "Debe ingresar una fecha inicio.");
			return ok(modalPlanilla.render(null,d));
		}else{
			ffd = DateUtils.formatDate(fecha_desde[0], "dd/MM/yyyy");
		}
		
		if(fecha_hasta == null || fecha_hasta[0].isEmpty()){
			flash("error", "Debe ingresar una fecha fin.");
			return ok(modalPlanilla.render(null,d));
		}else{
			ffh = DateUtils.formatDate(fecha_hasta[0], "dd/MM/yyyy");
		}
		
		try {
			File archivo = new File(dirTemp+"/planilla.xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/recupero/planilla.xls"));
			
			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;
			
			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			CellStyle comun = libro.createCellStyle();
			comun.setDataFormat((short) 10);
			comun.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			comun.setAlignment(CellStyle.ALIGN_CENTER);
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			comun.setWrapText(true);
			Font font2 = libro.createFont();
	        font2.setFontHeightInPoints((short) 10);
	        comun.setFont(font2);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 10);
			estiloMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			estiloMoneda.setAlignment(CellStyle.ALIGN_CENTER);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			estiloMoneda.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));
		    estiloMoneda.setFont(font2);
			
		    /*List<RecuperoPago> rfl = RecuperoPago.find.where()
													 .ge("fecha", ffd)
													 .le("fecha", ffh)
													 .disjunction()
													 .eq("estado_id", Estado.RECUPERO_PAGO_BORRADOR)
													 .eq("estado_id", Estado.RECUPERO_PAGO_PAGADO)
													 .endJunction()
													 .findList();*/
			
		    String sql = "SELECT rf.id idfactura,rp.id idpago "+
		    			 "FROM recupero_facturas rf "+
		    			 "INNER JOIN recupero_pagos rp ON rf.id = rp.recupero_factura_id "+
		    			 "WHERE ((rf.fecha BETWEEN :date_start AND :date_stop) " +
		    			 "OR (rp.fecha BETWEEN :date_start AND :date_stop " +
		    			 "AND (rp.estado_id =:estadoPagado OR rp.estado_id =:estadoCancelado))) " +
		    			 "AND (rp.parcializada <> true OR rp.parcializada is null)  " +
		    			 "AND rf.puntoventa_id = :puntoventa_id "+
		    			 "ORDER BY rf.serie,rf.numero ASC ";
					
			List<SqlRow> s = Ebean.createSqlQuery(sql)
						.setParameter("puntoventa_id", puntoventa_id)
					   .setParameter("date_start", ffd)
					   .setParameter("date_stop", ffh)
					   .setParameter("estadoPagado", Estado.RECUPERO_PAGO_PAGADO)
					   .setParameter("estadoCancelado", Estado.RECUPERO_PAGO_CANCELADO)
					   .findList();
		    
		    
			Integer n = 1;
			int x =8;
			Row f;
			BigDecimal total_pagado = new BigDecimal(0);
			BigDecimal total_facturado = new BigDecimal(0);
			BigDecimal total_cheque = new BigDecimal(0);
			BigDecimal total_efectivo = new BigDecimal(0);
			BigDecimal total_deposito = new BigDecimal(0);
			List<Cheque> che = new ArrayList<Cheque>();
			List<Long> idsFacturas = new ArrayList<Long>();
			for(SqlRow sr : s){
				
				RecuperoFactura rffi = RecuperoFactura.find.byId(sr.getLong("idfactura"));
				RecuperoPago rpi = RecuperoPago.find.byId(sr.getLong("idpago"));
				
				f = hoja.createRow(x);
				
				celda = f.createCell(0);
				celda.setCellValue(n.toString());
				celda.setCellStyle(comun);
				
				celda = f.createCell(1);
				celda.setCellValue(utils.DateUtils.formatDate(rffi.fecha));
				celda.setCellStyle(comun);
				
				celda = f.createCell(2);
				celda.setCellValue(rffi.serie+rffi.puntoVenta.numero+"-"+rffi.numero);
				celda.setCellStyle(comun);
			
				celda = f.createCell(3);//FACTURADO
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(rffi.getBase().doubleValue());
				celda.setCellStyle(estiloMoneda);
				total_facturado = total_facturado.add(rffi.getBase());
				
				
				celda = f.createCell(4);//COMPROBANTE PAGO
				String comprobantePago = (rpi.numero!= null)?rpi.numero:"";
				celda.setCellValue("X "+comprobantePago);
				celda.setCellStyle(comun);
				
				Date fecha = rffi.fecha;
				//MONTO PAGO
				if(rpi.estado_id.compareTo((long)Estado.RECUPERO_PAGO_CANCELADO) == 0){
					
					celda = f.createCell(5);
					celda.setCellValue("ANULADO");
					celda.setCellStyle(comun);
					
				}else if(rpi.estado_id.compareTo((long)Estado.RECUPERO_PAGO_BORRADOR) == 0){
					
					celda = f.createCell(5);
					celda.setCellValue("PEDIENTE");
					celda.setCellStyle(comun);
					
				}else{
					
					List<Cheque> cx = Cheque.find.where().eq("id_pago_recupero",rpi.id).findList();
					if(cx.size() > 0){
						for(Cheque chr :cx){
							che.add(chr);
						}
					}
					
					fecha = rpi.fecha;
					
					celda = f.createCell(5);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda.setCellValue(rpi.total.doubleValue());
					celda.setCellStyle(estiloMoneda);
					total_pagado = total_pagado.add(rpi.total);
					
					if(rpi.tipoPago.compareToIgnoreCase("efectivo") == 0){
						total_efectivo = total_efectivo.add(rpi.total);
					}else if(rpi.tipoPago.compareToIgnoreCase("cheque") == 0){
						total_cheque = total_cheque.add(rpi.total);
					}else if(rpi.tipoPago.compareToIgnoreCase("transferencia") == 0){
						total_deposito = total_deposito.add(rpi.total);
					}
				}
				
				celda = f.createCell(1);
				celda.setCellValue(utils.DateUtils.formatDate(fecha));
				celda.setCellStyle(comun);
				
				celda = f.createCell(6);//FINANCIADOR
				celda.setCellValue(rffi.cliente.nombre);
				celda.setCellStyle(comun);
				idsFacturas.add(sr.getLong("idfactura"));
				n++;
				x++;
				
			}
			
			
			List<RecuperoNotaCredito> ncl = RecuperoNotaCredito.find.where()
											 .ge("fecha", ffd)
											 .le("fecha", ffh)
											 .eq("recupero_factura.puntoventa_id", puntoventa_id)
											 .findList();
			
			for(RecuperoNotaCredito nc : ncl){
				
				if(!idsFacturas.contains(nc.recupero_factura_id)){
					RecuperoFactura rfn = nc.recupero_factura;
					
					f = hoja.createRow(x);
					celda = f.createCell(0);
					celda.setCellValue(n.toString());
					celda.setCellStyle(comun);
					
					celda = f.createCell(1);
					celda.setCellValue(utils.DateUtils.formatDate(rfn.fecha));
					celda.setCellStyle(comun);
					
					celda = f.createCell(2);
					celda.setCellValue(rfn.serie+rfn.numero);
					celda.setCellStyle(comun);
					
					celda = f.createCell(3);//FACTURADO
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda.setCellValue(rfn.getBase().doubleValue());
					celda.setCellStyle(estiloMoneda);
					total_facturado = total_facturado.add(rfn.getBase());
					
					celda = f.createCell(4);
					celda.setCellValue("");
					celda.setCellStyle(comun);
					celda = f.createCell(5);
					celda.setCellValue("");
					celda.setCellStyle(comun);
					 
					celda = f.createCell(6);
					celda.setCellValue(nc.recupero_factura.cliente.nombre);
					celda.setCellStyle(comun);
					
					n++;
					x++;
				}
				
				
				f = hoja.createRow(x);
				
				celda = f.createCell(0);
				celda.setCellValue(n.toString());
				celda.setCellStyle(comun);
				
				celda = f.createCell(1);
				celda.setCellValue(utils.DateUtils.formatDate(nc.fecha));
				celda.setCellStyle(comun);
				
				celda = f.createCell(2);
				celda.setCellValue("NC "+nc.numero);
				celda.setCellStyle(comun);
			
				celda = f.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(nc.getTotal().multiply(new BigDecimal(-1)).doubleValue());
				celda.setCellStyle(estiloMoneda);
				total_facturado = total_facturado.add(nc.getTotal().multiply(new BigDecimal(-1)));
				
				celda = f.createCell(4);
				celda.setCellValue("");
				celda.setCellStyle(comun);
				celda = f.createCell(5);
				celda.setCellValue("");
				celda.setCellStyle(comun);
				 
				celda = f.createCell(6);
				celda.setCellValue(nc.recupero_factura.cliente.nombre);
				celda.setCellStyle(comun);
				
				n++;
				x++;
			}
			
			
			f = hoja.createRow(x);
			
			celda = f.createCell(2);
			celda.setCellValue("TOTAL");
			celda.setCellStyle(comun);    
			
			celda = f.createCell(3);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_facturado.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			celda = f.createCell(4);
			celda.setCellValue("TOTAL");
			celda.setCellStyle(comun);
			
			celda = f.createCell(5);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_pagado.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			x++;
			
			f = hoja.createRow(x);
			celda = f.createCell(4);
			celda.setCellValue("Cheque");
			celda.setCellStyle(comun);
			
			celda = f.createCell(5);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_cheque.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			x++;
			
			f = hoja.createRow(x);
			celda = f.createCell(4);
			celda.setCellValue("Efectivo");
			celda.setCellStyle(comun);
			
			celda = f.createCell(5);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_efectivo.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			x++;
			
			f = hoja.createRow(x);
			celda = f.createCell(4);
			celda.setCellValue("Deposito");
			celda.setCellStyle(comun);
			
			celda = f.createCell(5);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_deposito.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			
			x++;x++;
			
			if(che.size() > 0){
				total_cheque = new BigDecimal(0);
				f = hoja.createRow(x);
				celda = f.createCell(0);
				celda.setCellValue("ITEMS");
				celda.setCellStyle(comun);
				
				celda = f.createCell(1);
				celda.setCellValue("N?? CHEQUE");
				celda.setCellStyle(comun);
				
				celda = f.createCell(2);
				celda.setCellValue("BANCO");
				celda.setCellStyle(comun);
				
				celda = f.createCell(3);
				celda.setCellValue("MONTO");
				celda.setCellStyle(comun);
				
				celda = f.createCell(4);
				celda.setCellValue("FECHA DE COBRO");
				celda.setCellStyle(comun);
				
				celda = f.createCell(5);
				celda.setCellValue("FINANCIADOR");
				celda.setCellStyle(comun);
				x++;
				Integer k = 1;
				
				for(Cheque chs : che){
					f = hoja.createRow(x);
					celda = f.createCell(0);
					celda.setCellValue(k.toString());
					celda.setCellStyle(comun);
					
					celda = f.createCell(1);
					celda.setCellValue(chs.numero);
					celda.setCellStyle(comun);
					
					celda = f.createCell(2);
					celda.setCellValue(chs.banco.nombre);
					celda.setCellStyle(comun);
					
					celda = f.createCell(3);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda.setCellValue(chs.monto.doubleValue());
					celda.setCellStyle(estiloMoneda);
					total_cheque = total_cheque.add(chs.monto);
					
					celda = f.createCell(4);
					celda.setCellValue(utils.DateUtils.formatDate(chs.fecha));
					celda.setCellStyle(comun);
					
					celda = f.createCell(5);
					celda.setCellValue(chs.pago.cliente.nombre);
					celda.setCellStyle(comun);
					
					x++;
					k++;
				}
				
				f = hoja.createRow(x);
				
				celda = f.createCell(2);
				celda.setCellValue("TOTAL");
				celda.setCellStyle(comun);
				
				celda = f.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(total_cheque.doubleValue());
				celda.setCellStyle(estiloMoneda);
			}
			
			 
			libro.write(archivoTmp);
			
			
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			
			return ok(modalPlanilla.render(archivo.getPath(),d));
			
			
		} catch (IOException e) {
		    e.printStackTrace();
		} 
		
		return ok(modalPlanilla.render(null,d));
	}
	
	public static Result informeDesdePlanilla(Long idPlanilla) {
		DynamicForm d = form().bindFromRequest();	
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		//RecuperoFactura factura = RecuperoFactura.find.byId(id);
		
		
		
		if(idPlanilla == null){
			flash("error", "No se encuentra la planilla");
			return ok(reportePlanilla.render(null));
		} 
		
		try {
			File archivo = new File(dirTemp+"/planilla.xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/recupero/planilla.xls"));
			
			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;
			
			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			CellStyle comun = libro.createCellStyle();
			comun.setDataFormat((short) 10);
			comun.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			comun.setAlignment(CellStyle.ALIGN_CENTER);
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			comun.setWrapText(true);
			Font font2 = libro.createFont();
	        font2.setFontHeightInPoints((short) 10);
	        comun.setFont(font2);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 10);
			estiloMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			estiloMoneda.setAlignment(CellStyle.ALIGN_CENTER);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			estiloMoneda.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));
		    estiloMoneda.setFont(font2);
			
		    /*List<RecuperoPago> rfl = RecuperoPago.find.where()
													 .ge("fecha", ffd)
													 .le("fecha", ffh)
													 .disjunction()
													 .eq("estado_id", Estado.RECUPERO_PAGO_BORRADOR)
													 .eq("estado_id", Estado.RECUPERO_PAGO_PAGADO)
													 .endJunction()
													 .findList();*/
			
		    String sql = "SELECT rf.id idfactura,rp.id idpago " +
		    			 "FROM recupero_facturas rf "+
		    			 "INNER JOIN recupero_pagos rp ON rf.id = rp.recupero_factura_id "+
		    			 "WHERE rf.planilla_id = :planilla_id OR rp.planilla_id = :planilla_id  " +
		    			 "ORDER BY rf.serie,rf.numero ASC ";
					
			List<SqlRow> s = Ebean.createSqlQuery(sql)
					   .setParameter("planilla_id", idPlanilla)
					   .findList();
		    
		    
			Integer n = 1;
			
			Row f;
			
			RecuperoPlanilla rp = RecuperoPlanilla.find.byId(idPlanilla);
			
			f = hoja.createRow(3);
			celda = f.createCell(3);
			celda.setCellValue("EXPEDIENTE: "+rp.expediente.getInstitucionExpedienteEjercicio());
			celda.setCellStyle(comun);
			
			f = hoja.createRow(4);
			celda = f.createCell(3);
			celda.setCellValue("PLANILLA N??"+rp.numero);
			celda.setCellStyle(comun);
			
			f = hoja.createRow(5);
			celda = f.createCell(3);
			celda.setCellValue("FECHA: "+utils.DateUtils.formatDate(rp.fecha));
			celda.setCellStyle(comun);
	
			int x =8;
			BigDecimal total_pagado = new BigDecimal(0);
			BigDecimal total_facturado = new BigDecimal(0);
			BigDecimal total_cheque = new BigDecimal(0);
			BigDecimal total_efectivo = new BigDecimal(0);
			BigDecimal total_deposito = new BigDecimal(0);
			List<Cheque> che = new ArrayList<Cheque>();
			List<Long> idsFacturas = new ArrayList<Long>();
			for(SqlRow sr : s){
				
				RecuperoFactura rffi = RecuperoFactura.find.byId(sr.getLong("idfactura"));
				RecuperoPago rpi = RecuperoPago.find.byId(sr.getLong("idpago"));
				
				f = hoja.createRow(x);
				
				celda = f.createCell(0);
				celda.setCellValue(n.toString());
				celda.setCellStyle(comun);
				
				celda = f.createCell(1);
				celda.setCellValue(utils.DateUtils.formatDate(rffi.fecha));
				celda.setCellStyle(comun);
				
				celda = f.createCell(2);
				celda.setCellValue(rffi.serie+rffi.numero);
				celda.setCellStyle(comun);
			
				celda = f.createCell(3);//FACTURADO
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(rffi.getBase().doubleValue());
				celda.setCellStyle(estiloMoneda);
				total_facturado = total_facturado.add(rffi.getBase());
				
				
				celda = f.createCell(4);//COMPROBANTE PAGO
				String comprobantePago = (rpi.numero!= null)?rpi.numero:"";
				celda.setCellValue("X "+comprobantePago);
				celda.setCellStyle(comun);
				
				Date fecha = rffi.fecha;
				//MONTO PAGO
				if(rpi.estado_id.compareTo((long)Estado.RECUPERO_PAGO_CANCELADO) == 0){
					
					celda = f.createCell(5);
					celda.setCellValue("ANULADO");
					celda.setCellStyle(comun);
					
				}else if(rpi.estado_id.compareTo((long)Estado.RECUPERO_PAGO_BORRADOR) == 0){
					
					celda = f.createCell(5);
					celda.setCellValue("PEDIENTE");
					celda.setCellStyle(comun);
					
				}else{
					
					List<Cheque> cx = Cheque.find.where().eq("id_pago_recupero",rpi.id).findList();
					if(cx.size() > 0){
						for(Cheque chr :cx){
							che.add(chr);
						}
					}
					
					fecha = rpi.fecha;
					
					celda = f.createCell(5);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda.setCellValue(rpi.total.doubleValue());
					celda.setCellStyle(estiloMoneda);
					total_pagado = total_pagado.add(rpi.total);
					
					if(rpi.tipoPago.compareToIgnoreCase("efectivo") == 0){
						total_efectivo = total_efectivo.add(rpi.total);
					}else if(rpi.tipoPago.compareToIgnoreCase("cheque") == 0){
						total_cheque = total_cheque.add(rpi.total);
					}else if(rpi.tipoPago.compareToIgnoreCase("transferencia") == 0){
						total_deposito = total_deposito.add(rpi.total);
					}
				}
				
				celda = f.createCell(1);
				celda.setCellValue(utils.DateUtils.formatDate(fecha));
				celda.setCellStyle(comun);
				
				celda = f.createCell(6);//FINANCIADOR
				celda.setCellValue(rffi.cliente.nombre);
				celda.setCellStyle(comun);
				idsFacturas.add(sr.getLong("idfactura"));
				n++;
				x++;
				
			}
			
			
			List<Object> idsf = RecuperoFactura.find.where().eq("planilla_id",idPlanilla).findIds();
			List<RecuperoNotaCredito> ncl = RecuperoNotaCredito.find.where()
											 //.in("recupero_factura_id",idsf)
											  .in("planilla_id",idPlanilla)
											 .findList();
			
			for(RecuperoNotaCredito nc : ncl){
				
				if(!idsFacturas.contains(nc.recupero_factura_id)){
					RecuperoFactura rfn = nc.recupero_factura;
					
					f = hoja.createRow(x);
					celda = f.createCell(0);
					celda.setCellValue(n.toString());
					celda.setCellStyle(comun);
					
					celda = f.createCell(1);
					celda.setCellValue(utils.DateUtils.formatDate(rfn.fecha));
					celda.setCellStyle(comun);
					
					celda = f.createCell(2);
					celda.setCellValue(rfn.serie+rfn.numero);
					celda.setCellStyle(comun);
					
					celda = f.createCell(3);//FACTURADO
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda.setCellValue(rfn.getBase().doubleValue());
					celda.setCellStyle(estiloMoneda);
					total_facturado = total_facturado.add(rfn.getBase());
					
					celda = f.createCell(4);
					celda.setCellValue("");
					celda.setCellStyle(comun);
					celda = f.createCell(5);
					celda.setCellValue("");
					celda.setCellStyle(comun);
					 
					celda = f.createCell(6);
					celda.setCellValue(nc.recupero_factura.cliente.nombre);
					celda.setCellStyle(comun);
					
					n++;
					x++;
				}
				
				
				f = hoja.createRow(x);
				
				celda = f.createCell(0);
				celda.setCellValue(n.toString());
				celda.setCellStyle(comun);
				
				celda = f.createCell(1);
				celda.setCellValue(utils.DateUtils.formatDate(nc.fecha));
				celda.setCellStyle(comun);
				
				celda = f.createCell(2);
				celda.setCellValue("NC "+nc.numero);
				celda.setCellStyle(comun);
			
				celda = f.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(nc.getTotal().multiply(new BigDecimal(-1)).doubleValue());
				celda.setCellStyle(estiloMoneda);
				total_facturado = total_facturado.add(nc.getTotal().multiply(new BigDecimal(-1)));
				
				celda = f.createCell(4);
				celda.setCellValue("");
				celda.setCellStyle(comun);
				celda = f.createCell(5);
				celda.setCellValue("");
				celda.setCellStyle(comun);
				 
				celda = f.createCell(6);
				celda.setCellValue(nc.recupero_factura.cliente.nombre);
				celda.setCellStyle(comun);
				
				n++;
				x++;
			}
			
			
			f = hoja.createRow(x);
			
			celda = f.createCell(2);
			celda.setCellValue("TOTAL");
			celda.setCellStyle(comun);    
			
			celda = f.createCell(3);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_facturado.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			celda = f.createCell(4);
			celda.setCellValue("TOTAL");
			celda.setCellStyle(comun);
			
			celda = f.createCell(5);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_pagado.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			x++;
			
			f = hoja.createRow(x);
			celda = f.createCell(4);
			celda.setCellValue("Cheque");
			celda.setCellStyle(comun);
			
			celda = f.createCell(5);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_cheque.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			x++;
			
			f = hoja.createRow(x);
			celda = f.createCell(4);
			celda.setCellValue("Efectivo");
			celda.setCellStyle(comun);
			
			celda = f.createCell(5);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_efectivo.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			x++;
			
			f = hoja.createRow(x);
			celda = f.createCell(4);
			celda.setCellValue("Deposito");
			celda.setCellStyle(comun);
			
			celda = f.createCell(5);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_deposito.doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			
			x++;x++;
			
			if(che.size() > 0){
				total_cheque = new BigDecimal(0);
				f = hoja.createRow(x);
				celda = f.createCell(0);
				celda.setCellValue("ITEMS");
				celda.setCellStyle(comun);
				
				celda = f.createCell(1);
				celda.setCellValue("N?? CHEQUE");
				celda.setCellStyle(comun);
				
				celda = f.createCell(2);
				celda.setCellValue("BANCO");
				celda.setCellStyle(comun);
				
				celda = f.createCell(3);
				celda.setCellValue("MONTO");
				celda.setCellStyle(comun);
				
				celda = f.createCell(4);
				celda.setCellValue("FECHA DE COBRO");
				celda.setCellStyle(comun);
				
				celda = f.createCell(5);
				celda.setCellValue("FINANCIADOR");
				celda.setCellStyle(comun);
				x++;
				Integer k = 1;
				
				for(Cheque chs : che){
					f = hoja.createRow(x);
					celda = f.createCell(0);
					celda.setCellValue(k.toString());
					celda.setCellStyle(comun);
					
					celda = f.createCell(1);
					celda.setCellValue(chs.numero);
					celda.setCellStyle(comun);
					
					celda = f.createCell(2);
					celda.setCellValue(chs.banco.nombre);
					celda.setCellStyle(comun);
					
					celda = f.createCell(3);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda.setCellValue(chs.monto.doubleValue());
					celda.setCellStyle(estiloMoneda);
					total_cheque = total_cheque.add(chs.monto);
					
					celda = f.createCell(4);
					celda.setCellValue(utils.DateUtils.formatDate(chs.fecha));
					celda.setCellStyle(comun);
					
					celda = f.createCell(5);
					celda.setCellValue(chs.pago.cliente.nombre);
					celda.setCellStyle(comun);
					
					x++;
					k++;
				}
				
				f = hoja.createRow(x);
				
				celda = f.createCell(2);
				celda.setCellValue("TOTAL");
				celda.setCellStyle(comun);
				
				celda = f.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(total_cheque.doubleValue());
				celda.setCellStyle(estiloMoneda);
			}
			
			 
			libro.write(archivoTmp);
			
			
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			
			return ok(reportePlanilla.render(archivo.getPath()));
			
			
		} catch (IOException e) {
		    e.printStackTrace();
		} 
		flash("error", "No se puede generar el reporte.");
		return ok(reportePlanilla.render(null));
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
