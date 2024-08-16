package controllers.recupero;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
//import java.time.LocalDate;
//import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import models.ClienteTipo;
import models.CuentaAnalitica;
import models.Deposito;
import models.DireccionCliente;
import models.Estado;
import models.Periodo;
import models.TipoComprobante;
import models.recupero.Cheque;
import models.recupero.InformeTotal;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoFacturaLinea;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoNotaDebito;
import models.recupero.RecuperoPago;
import models.recupero.RecuperoPlanilla;
import models.recupero.RecuperoRecibo;
import models.recupero.RecuperoReciboFactura;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.w3c.dom.Document;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

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

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

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
			fila.createCell(2).setCellValue("N° Factura");
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
			fila.createCell(2).setCellValue("N° Factura");
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
				RequestVar.get("fecha_factura_hasta"),
				RequestVar.get("deposito_id")
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
													RequestVar.get("fecha_factura_hasta"),
													RequestVar.get("deposito_id")
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
				RequestVar.get("fecha_factura_hasta"),
				RequestVar.get("deposito_id")
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

				//Número
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
				RequestVar.get("fecha_factura_hasta"),
				RequestVar.get("deposito_id")
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

				//Número
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
		    			 "AND rf.puntoventa_id = :puntoventa_id  "+
		    			 "(AND rp.recupero_nota_credito_id is null AND rp.recupero_nota_debito_id is null) "+
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

				celda = f.createCell(4);//TIPO PAGO
				celda.setCellValue((rpi.textoTipoPago != null)?rpi.textoTipoPago:"");
				celda.setCellStyle(comun);

				celda = f.createCell(5);//COMPROBANTE PAGO
				String comprobantePago = (rpi.numero!= null)?rpi.numero:"";
				celda.setCellValue("X "+comprobantePago);
				celda.setCellStyle(comun);



				celda = f.createCell(6);//FECHA PAGO
				if(rpi.fecha != null) {
					Date fechaPagp = rpi.fecha;
					celda.setCellValue(utils.DateUtils.formatDate(fechaPagp));
				}
				celda.setCellStyle(comun);


				Date fecha = rffi.fecha;
				//MONTO PAGO
				if(rpi.estado_id.compareTo((long)Estado.RECUPERO_PAGO_CANCELADO) == 0){

					celda = f.createCell(7);
					celda.setCellValue("ANULADO");
					celda.setCellStyle(comun);

				}else if(rpi.estado_id.compareTo((long)Estado.RECUPERO_PAGO_BORRADOR) == 0){

					celda = f.createCell(7);
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

					celda = f.createCell(7);
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

				celda = f.createCell(8);//FINANCIADOR
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
					celda.setCellValue("");
					celda.setCellStyle(comun);

					celda = f.createCell(7);
					celda.setCellValue("");
					celda.setCellStyle(comun);



					celda = f.createCell(8);
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



				celda = f.createCell(5);
				celda.setCellValue("");
				celda.setCellStyle(comun);

				celda = f.createCell(6);
				celda.setCellValue("");
				celda.setCellStyle(comun);

				celda = f.createCell(7);
				celda.setCellValue("");
				celda.setCellStyle(comun);


				celda = f.createCell(8);
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

			celda = f.createCell(7);
			celda.setCellValue("TOTAL");
			celda.setCellStyle(comun);

			celda = f.createCell(8);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_pagado.doubleValue());
			celda.setCellStyle(estiloMoneda);

			x++;

			f = hoja.createRow(x);
			celda = f.createCell(7);
			celda.setCellValue("Cheque");
			celda.setCellStyle(comun);

			celda = f.createCell(8);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_cheque.doubleValue());
			celda.setCellStyle(estiloMoneda);

			x++;

			f = hoja.createRow(x);
			celda = f.createCell(7);
			celda.setCellValue("Efectivo");
			celda.setCellStyle(comun);

			celda = f.createCell(8);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_efectivo.doubleValue());
			celda.setCellStyle(estiloMoneda);

			x++;

			f = hoja.createRow(x);
			celda = f.createCell(7);
			celda.setCellValue("Deposito");
			celda.setCellStyle(comun);

			celda = f.createCell(8);
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
				celda.setCellValue("Nº CHEQUE");
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
		/*
		 select nc.numero, pv.numero,rf.numero
from recupero_notas_creditos nc
inner join recupero_facturas rf on rf.id = nc.recupero_factura_id
inner join punto_ventas pv on pv.id = rf.puntoventa_id
order by nc.numero
		 * */


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
		    			 "WHERE (rf.planilla_id = :planilla_id OR rp.planilla_id = :planilla_id ) and rp.recupero_nota_debito_id is null and rp.recupero_nota_credito_id is null  " +
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
			celda.setCellValue("PLANILLA N°"+rp.numero);
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
				celda.setCellValue(rffi.serie+rffi.puntoVenta.numero+"-"+rffi.numero);
				celda.setCellStyle(comun);

				celda = f.createCell(3);//FACTURADO
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(rffi.getBase().doubleValue());
				celda.setCellStyle(estiloMoneda);
				total_facturado = total_facturado.add(rffi.getBase());

				celda = f.createCell(4);//TIPO PAGO
				celda.setCellValue((rpi.tipoPago != null)?rpi.tipoPago:"");
				celda.setCellStyle(comun);

				celda = f.createCell(5);//COMPROBANTE PAGO
				String comprobantePago = (rpi.numero!= null)?rpi.numero:"";
				celda.setCellValue("X "+comprobantePago);
				celda.setCellStyle(comun);



				celda = f.createCell(6);//FECHA PAGO
				if(rpi.fecha != null) {
					Date fechaPagp = rpi.fecha;
					celda.setCellValue(utils.DateUtils.formatDate(fechaPagp));
				}
				celda.setCellStyle(comun);

				Date fecha = rffi.fecha;
				//MONTO PAGO
				if(rpi.estado_id.compareTo((long)Estado.RECUPERO_PAGO_CANCELADO) == 0){

					celda = f.createCell(7);
					celda.setCellValue("ANULADO");
					celda.setCellStyle(comun);

				}else if(rpi.estado_id.compareTo((long)Estado.RECUPERO_PAGO_BORRADOR) == 0){

					celda = f.createCell(7);
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

					celda = f.createCell(7);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda.setCellValue(rpi.total.doubleValue());
					celda.setCellStyle(estiloMoneda);
					total_pagado = total_pagado.add(rpi.total);

					if(rpi.tipoPago != null){
						if(rpi.tipoPago.compareToIgnoreCase("efectivo") == 0){
							total_efectivo = total_efectivo.add(rpi.total);
						}else if(rpi.tipoPago.compareToIgnoreCase("cheque") == 0){
							total_cheque = total_cheque.add(rpi.total);
						}else if(rpi.tipoPago.compareToIgnoreCase("transferencia") == 0){
							total_deposito = total_deposito.add(rpi.total);
						}
					}else {
						total_deposito = total_deposito.add(rpi.total);
					}
				}

				celda = f.createCell(1);
				celda.setCellValue(utils.DateUtils.formatDate(fecha));
				celda.setCellStyle(comun);

				celda = f.createCell(8);//FINANCIADOR
				celda.setCellValue(rffi.cliente.nombre);
				celda.setCellStyle(comun);
				idsFacturas.add(sr.getLong("idfactura"));
				n++;
				x++;

			}

			/////////////////////////// - NOTAS DE CREDITOS- /////////////////////////////////7

			//List<Object> idsf = RecuperoFactura.find.where().eq("planilla_id",idPlanilla).findIds();
			List<RecuperoNotaCredito> ncl = RecuperoNotaCredito.find.where()
											 //.in("recupero_factura_id",idsf)
											  .in("planilla_id",idPlanilla)
											 .findList();

			for(RecuperoNotaCredito nc : ncl){
				RecuperoFactura rfn = nc.recupero_factura;
				if(!idsFacturas.contains(nc.recupero_factura_id)){


					f = hoja.createRow(x);
					celda = f.createCell(0);
					celda.setCellValue(n.toString());
					celda.setCellStyle(comun);

					celda = f.createCell(1);
					celda.setCellValue(utils.DateUtils.formatDate(rfn.fecha));
					celda.setCellStyle(comun);

					celda = f.createCell(2);
					celda.setCellValue(rfn.serie+rfn.puntoVenta.numero+"-"+rfn.numero);
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
					celda.setCellValue("");
					celda.setCellStyle(comun);
					celda = f.createCell(7);
					celda.setCellValue("");
					celda.setCellStyle(comun);

					celda = f.createCell(8);
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
				celda.setCellValue("NC"+rfn.puntoVenta.numero+"-"+nc.numero);
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
				celda.setCellValue("");
				celda.setCellStyle(comun);
				celda = f.createCell(7);
				celda.setCellValue("");
				celda.setCellStyle(comun);

				celda = f.createCell(8);
				celda.setCellValue(nc.recupero_factura.cliente.nombre);
				celda.setCellStyle(comun);

				n++;
				x++;
			}

			/////////////////////////- NOTA DEBITOS-///////////////////////////

			//List<Object> idsf = RecuperoFactura.find.where().eq("planilla_id",idPlanilla).findIds();
			List<RecuperoNotaDebito> ndl = RecuperoNotaDebito.find.where()
											 //.in("recupero_factura_id",idsf)
											  .in("planilla_id",idPlanilla)
											 .findList();

			for(RecuperoNotaDebito nd : ndl){
				RecuperoFactura rfn = nd.recupero_factura;
				if(!idsFacturas.contains(nd.recupero_factura_id)){


					f = hoja.createRow(x);
					celda = f.createCell(0);
					celda.setCellValue(n.toString());
					celda.setCellStyle(comun);

					celda = f.createCell(1);
					celda.setCellValue(utils.DateUtils.formatDate(rfn.fecha));
					celda.setCellStyle(comun);

					celda = f.createCell(2);
					celda.setCellValue(rfn.serie+rfn.puntoVenta.numero+"-"+rfn.numero);
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
					celda.setCellValue("");
					celda.setCellStyle(comun);
					celda = f.createCell(7);
					celda.setCellValue("");
					celda.setCellStyle(comun);

					celda = f.createCell(8);
					celda.setCellValue(nd.recupero_factura.cliente.nombre);
					celda.setCellStyle(comun);

					n++;
					x++;
				}


				f = hoja.createRow(x);

				celda = f.createCell(0);
				celda.setCellValue(n.toString());
				celda.setCellStyle(comun);

				celda = f.createCell(1);
				celda.setCellValue(utils.DateUtils.formatDate(nd.fecha));
				celda.setCellStyle(comun);

				celda = f.createCell(2);
				//celda.setCellValue("ND "+nd.numero);
				celda.setCellValue("ND"+rfn.puntoVenta.numero+"-"+nd.numero);
				celda.setCellStyle(comun);

				celda = f.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(nd.getTotal().multiply(new BigDecimal(-1)).doubleValue());
				celda.setCellStyle(estiloMoneda);
				total_facturado = total_facturado.add(nd.getTotal());

				celda = f.createCell(4);
				celda.setCellValue("");
				celda.setCellStyle(comun);
				celda = f.createCell(5);
				celda.setCellValue("");
				celda.setCellStyle(comun);
				celda = f.createCell(6);
				celda.setCellValue("");
				celda.setCellStyle(comun);
				celda = f.createCell(7);
				celda.setCellValue("");
				celda.setCellStyle(comun);

				celda = f.createCell(8);
				celda.setCellValue(nd.recupero_factura.cliente.nombre);
				celda.setCellStyle(comun);

				n++;
				x++;
			}

			////////////////////////-TOTALES-////////////////////////////
			f = hoja.createRow(x);

			celda = f.createCell(2);
			celda.setCellValue("TOTAL");
			celda.setCellStyle(comun);

			celda = f.createCell(3);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_facturado.doubleValue());
			celda.setCellStyle(estiloMoneda);

			celda = f.createCell(6);
			celda.setCellValue("TOTAL");
			celda.setCellStyle(comun);

			celda = f.createCell(7);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_pagado.doubleValue());
			celda.setCellStyle(estiloMoneda);

			x++;

			f = hoja.createRow(x);
			celda = f.createCell(6);
			celda.setCellValue("Cheque");
			celda.setCellStyle(comun);

			celda = f.createCell(7);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_cheque.doubleValue());
			celda.setCellStyle(estiloMoneda);

			x++;

			f = hoja.createRow(x);
			celda = f.createCell(6);
			celda.setCellValue("Efectivo");
			celda.setCellStyle(comun);

			celda = f.createCell(7);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(total_efectivo.doubleValue());
			celda.setCellStyle(estiloMoneda);

			x++;

			f = hoja.createRow(x);
			celda = f.createCell(6);
			celda.setCellValue("Tranferencias");
			celda.setCellStyle(comun);

			celda = f.createCell(7);
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
				celda.setCellValue("Nº CHEQUE");
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

	public static Result imprimirReciboNuevo(Long id) {

		RecuperoRecibo rf = RecuperoRecibo.find.byId(id);

		 if(rf.estado_id == Estado.RECUPERO_RECIBOS_BORRADOR ) {
			 flash("error", "El recibo no puede estar en estado Borrador.");
			 return ok(reportePlanilla.render(null));
		 }

		try {
			// id = new Long(29809);

			 String dirTemp = System.getProperty("java.io.tmpdir");

			 // Source HTML file
			 String inputHTML = null;
			 if(rf.recuperoReciboFactura.size() < 30) {
				 inputHTML = Play.application().getFile("conf/resources/reportes/recupero/recibo2.html").toString();
			 }else if(rf.recuperoReciboFactura.size() >= 30 && rf.recuperoReciboFactura.size() < 60 ) {
				 inputHTML = Play.application().getFile("conf/resources/reportes/recupero/recibo3.html").toString();
			 }else if(rf.recuperoReciboFactura.size() >= 60 && rf.recuperoReciboFactura.size() <= 90 ) {
				 inputHTML = Play.application().getFile("conf/resources/reportes/recupero/recibo4.html").toString();
			 }

			 // Generated PDF file name
			 String outputPdf = dirTemp+"/recibo_"+id+".pdf";

			 htmlToPdf(inputHTML, outputPdf, id,"recibo");

			 return ok(reportePlanilla.render(outputPdf));

		} catch (Exception e) {
		  // TODO Auto-generated catch block
		      e.printStackTrace();
		      flash("error", "No se puede generar el reporte. "+e);
				 return ok(reportePlanilla.render(null));
		}

		//return ok(reportePlanilla.render(null));
	}



	public static Result imprimirFacturaAfip(Long id) {

			 try {
				 RecuperoFactura rf = RecuperoFactura.find.byId(id);
				 String dirTemp = System.getProperty("java.io.tmpdir");

				 // Source HTML file
				 String inputHTML = null;
				 if(rf.recuperoFacturaLinea.size() < 25) {
					 inputHTML = Play.application().getFile("conf/resources/reportes/recupero/factura.html").toString();
				 }else if(rf.recuperoFacturaLinea.size() >= 25 && rf.recuperoFacturaLinea.size() < 50 ) {
					 inputHTML = Play.application().getFile("conf/resources/reportes/recupero/factura1.html").toString();
				 }else if(rf.recuperoFacturaLinea.size() >= 50 && rf.recuperoFacturaLinea.size() <= 75 ) {
					 inputHTML = Play.application().getFile("conf/resources/reportes/recupero/factura2.html").toString();
				 }



				 // Generated PDF file name
				 String outputPdf = dirTemp+"/factura-"+rf.puntoVenta.numero+rf.numero+".pdf";
				 // System.out.println(inputHTML);
				 //String inputHTML2 = inputHTML.replace("@@pv@@", "00009");
				 // System.out.println(inputHTML2);


				 htmlToPdf(inputHTML, outputPdf, id,"factura");

				 return ok(reportePlanilla.render(outputPdf));

			} catch (Exception e) {
			  // TODO Auto-generated catch block
			      e.printStackTrace();
			}



		return ok(reportePlanilla.render(null));
	}

	public static Result notaDebito(Long id) {

		try {
			 RecuperoNotaDebito rf = RecuperoNotaDebito.find.byId(id);
			 String dirTemp = System.getProperty("java.io.tmpdir");

			 // Source HTML file
			 String inputHTML = Play.application().getFile("conf/resources/reportes/recupero/nd.html").toString();
			 // Generated PDF file name
			 String outputPdf = dirTemp+"/nota-debito-"+rf.puntoVenta.numero+rf.numero+".pdf";
			 // System.out.println(inputHTML);
			 //String inputHTML2 = inputHTML.replace("@@pv@@", "00009");
			 // System.out.println(inputHTML2);


			 htmlToPdf(inputHTML, outputPdf, id,"notadebito");

			 return ok(reportePlanilla.render(outputPdf));

		} catch (Exception e) {
		  // TODO Auto-generated catch block
		      e.printStackTrace();
		}



		return ok(reportePlanilla.render(null));
	}

	public static Result notaCredito(Long id) {

		try {
			RecuperoNotaCredito rf = RecuperoNotaCredito.find.byId(id);
			 String dirTemp = System.getProperty("java.io.tmpdir");
			 String inputHTML = Play.application().getFile("conf/resources/reportes/recupero/nc.html").toString();
			 String outputPdf = dirTemp+"/nota-credito-"+rf.puntoVenta.numero+rf.numero+".pdf";
			 htmlToPdf(inputHTML, outputPdf, id,"notacredito");
			 return ok(reportePlanilla.render(outputPdf));

		} catch (Exception e) {
		      e.printStackTrace();
		}
		return ok(reportePlanilla.render(null));
	}


	private static void htmlToPdf(String inputHTML, String outputPdf,Long facturaId,String tipo) throws Exception,IOException {

		//Document doc = html5ParseDocument(inputHTML);

	 	//doc = doc.getDocumentElement().toString().replace("pv", "00005");




		/*org.jsoup.nodes.Document docTmp;
		docTmp = Jsoup.parse(new File(inputHTML), "UTF-8");

	    org.jsoup.select.Elements myImgs = docTmp.select(".pv");

	    for (org.jsoup.nodes.Element element : myImgs) {
	    	element.text("00005");
	    }*/

		Document doc = null;


		if(tipo =="factura") {
			 doc = html5ParseDocumentPorElemento(inputHTML,facturaId);
		}else if(tipo =="recibo") {
			doc = html5ParseDocumentPorElementoRecibo(inputHTML,facturaId);
		}else if(tipo =="notacredito") {
			doc = html5ParseDocumentPorElementoNotaCredito(inputHTML,facturaId);
		}else if(tipo =="notadebito") {
			doc = html5ParseDocumentPorElementoNotaDebito(inputHTML,facturaId);
		}





	    String dirTemp = System.getProperty("java.io.tmpdir");
	    String baseUri = FileSystems.getDefault()
	              .getPath(dirTemp+"/"+tipo+"_"+facturaId+".pdf")
	              .toUri()
	              .toString();


	    OutputStream os = new FileOutputStream(outputPdf);

	    PdfRendererBuilder builder = new PdfRendererBuilder();
	    builder.withUri(outputPdf);
	    builder.toStream(os);
	    // using absolute path here
	    //builder.useFont(new File("F:\\knpcode\\Java\\Java Programs\\PDF using Java\\PDFBox\\Gabriola.ttf"),"Gabriola");
	    builder.withW3cDocument(doc, baseUri);
	    //builder.useUriResolver(new MyResolver());
	    builder.run();

	    //System.out.println("PDF generation completed");
	    os.close();
	}

	private static Document html5ParseDocumentPorElementoRecibo(String inputHTML,Long id) throws IOException{

	    org.jsoup.nodes.Document doc;


	    doc = Jsoup.parse(new File(inputHTML), "UTF-8");

	    RecuperoRecibo rf = RecuperoRecibo.find.byId(id);

	    Map<String,String> datos = new HashMap<>();
	    String puntoventa = (rf.puntoventa_id != null)?rf.puntoVenta.numero:"";
	    datos.put("pv",puntoventa );
	    datos.put("numeroFactura",rf.numero);
	    datos.put("fecha_emision", utils.DateUtils.formatDate((rf.fecha!= null)?rf.fecha:rf.fecha));
	    datos.put("fecha_desde", utils.DateUtils.formatDate(rf.fecha));
	    datos.put("fecha_hasta", utils.DateUtils.formatDate(rf.fecha));
	    datos.put("fecha_transferencia", utils.DateUtils.formatDate(rf.fecha_transferencia));
	    datos.put("importe", utils.NumberUtils.moneda(rf.getTotal()));
	    datos.put("monto_letras", NumeroALetra.convertNumberToLetter(String.valueOf(rf.getTotal())));



	    List<RecuperoReciboFactura> rdlxr = rf.recuperoReciboFactura;
	    datos.put("cuit", rf.cliente.cuit2);
	    datos.put("razon_social", rf.cliente.nombre);


	    if(rf.estado_id.compareTo((long) Estado.RECUPERO_RECIBOS_CANCELADO) == 0) {
	    	String anulado = "<div id='cancelado'><div style='text-align: center; color:grey;padding: 10px;height:20px;'><h2 style='margin:0px; font-size: 60px;'>ANULADO</h2></div></div>";
	    	datos.put("anuladosspan", anulado);
	    }



	    String iva = (rf.cliente.condicionIva != null)?rf.cliente.condicionIva.descripcion:"IVA Responsable Inscripto";
	    datos.put("ivaa", iva);


	    String direccion = rdlxr.get(0).recuperoFactura.cliente.getFirstDireccion();
	    datos.put("direccion", direccion);


	    if(rdlxr.size() < 30) {// siiiiiii tengo 30 lineas nomas

	    	String lineas ="";
	 	    for(RecuperoReciboFactura rfl :rdlxr) {
	 	    	String desc = (rfl.descripcion != null)?rfl.descripcion:"";

	 		    lineas += "<tr>" +
	 		    		"        		<td style='text-align: center'>"+rfl.recuperoFactura.getNumeroFactura()+"</td>" +
	 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getBase()) +"</td>" +
	 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaCredito()) +"</td>" +
	 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaDebito()) +"</td>" +
	 		    		"               <td>"+utils.NumberUtils.moneda(rfl.monto) +"</td>" +
	 		    		"               <td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotal().subtract(rfl.monto))+"</td>" +
	 		    		"               <td>"+desc+"</td>" +
	 		    		"            </tr>";
	 	    }

	 	    datos.put("lineas",lineas);

		 }else if(rdlxr.size() >= 30 && rdlxr.size() < 60 ) {

			 List<RecuperoReciboFactura> first = new ArrayList<>(rdlxr.subList(0, 29));
			 List<RecuperoReciboFactura> second = new ArrayList<>(rdlxr.subList(30,rdlxr.size()));
			 String lineas1 ="";
			 BigDecimal total1 = new BigDecimal(0);

			 for(RecuperoReciboFactura rfl :first) {
		 	    	String desc = (rfl.descripcion != null)?rfl.descripcion:"";
		 	    	total1 = total1.add(rfl.recuperoFactura.getBase());

		 		    lineas1 += "<tr>" +
		 		    		"        		<td style='text-align: center'>"+rfl.recuperoFactura.getNumeroFactura()+"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getBase()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaCredito()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaDebito()) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.monto) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotal().subtract(rfl.monto))+"</td>" +
		 		    		"               <td>"+desc+"</td>" +
		 		    		"            </tr>";
		 	  }
			  datos.put("total1",utils.NumberUtils.moneda(total1));
		 	  datos.put("lineas1",lineas1);

		 	 String lineas2 ="";
		 	BigDecimal total2 = new BigDecimal(0);
			 for(RecuperoReciboFactura rfl :second) {
		 	    	String desc = (rfl.descripcion != null)?rfl.descripcion:"";
		 	    	total2 = total2.add(rfl.recuperoFactura.getBase());

		 		    lineas2 += "<tr>" +
		 		    		"        		<td style='text-align: center'>"+rfl.recuperoFactura.getNumeroFactura()+"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getBase()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaCredito()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaDebito()) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.monto) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotal().subtract(rfl.monto))+"</td>" +
		 		    		"               <td>"+desc+"</td>" +
		 		    		"            </tr>";
		 	  }
			 datos.put("total2",utils.NumberUtils.moneda(total2));
		 	 datos.put("lineas2",lineas2);



		 }else if(rdlxr.size() >= 60 && rdlxr.size() <= 90 ) {

			 List<RecuperoReciboFactura> first = new ArrayList<>(rdlxr.subList(0, 29));
			 List<RecuperoReciboFactura> second = new ArrayList<>(rdlxr.subList(30,59));
			 List<RecuperoReciboFactura> tres = new ArrayList<>(rdlxr.subList(60,rdlxr.size()));
			 String lineas1 ="";
			 BigDecimal total1 = new BigDecimal(0);
			 for(RecuperoReciboFactura rfl :first) {
		 	    	String desc = (rfl.descripcion != null)?rfl.descripcion:"";
		 	    	total1 = total1.add(rfl.recuperoFactura.getBase());
		 		    lineas1 += "<tr>" +
		 		    		"        		<td style='text-align: center'>"+rfl.recuperoFactura.getNumeroFactura()+"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getBase()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaCredito()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaDebito()) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.monto) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotal().subtract(rfl.monto))+"</td>" +
		 		    		"               <td>"+desc+"</td>" +
		 		    		"            </tr>";

		 	  }

		 	 datos.put("lineas1",lineas1);
		 	 datos.put("total1",utils.NumberUtils.moneda(total1));

		 	 String lineas2 ="";
		 	 BigDecimal total2 = new BigDecimal(0);
			 for(RecuperoReciboFactura rfl :second) {
		 	    	String desc = (rfl.descripcion != null)?rfl.descripcion:"";
		 	    	total2 = total2.add(rfl.recuperoFactura.getBase());
		 		    lineas2 += "<tr>" +
		 		    		"        		<td style='text-align: center'>"+rfl.recuperoFactura.getNumeroFactura()+"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getBase()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaCredito()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaDebito()) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.monto) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotal().subtract(rfl.monto))+"</td>" +
		 		    		"               <td>"+desc+"</td>" +
		 		    		"            </tr>";
		 	  }

		 	 datos.put("lineas2",lineas2);
		 	 datos.put("total2",utils.NumberUtils.moneda(total2));

		 	 String lineas3 ="";
		 	 BigDecimal total3 = new BigDecimal(0);
			 for(RecuperoReciboFactura rfl :tres) {
		 	    	String desc = (rfl.descripcion != null)?rfl.descripcion:"";
		 	    	total3 = total3.add(rfl.recuperoFactura.getBase());
		 		    lineas3 += "<tr>" +
		 		    		"        		<td style='text-align: center'>"+rfl.recuperoFactura.getNumeroFactura()+"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getBase()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaCredito()) +"</td>" +
		 		    		"        		<td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotalNotaDebito()) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.monto) +"</td>" +
		 		    		"               <td>"+utils.NumberUtils.moneda(rfl.recuperoFactura.getTotal().subtract(rfl.monto))+"</td>" +
		 		    		"               <td>"+desc+"</td>" +
		 		    		"            </tr>";
		 	  }
			 datos.put("total3",utils.NumberUtils.moneda(total3));
		 	 datos.put("lineas3",lineas3);
		 }





	    for (Map.Entry<String, String> entry : datos.entrySet()) {
	    	Logger.debug("xxxxxxx "+entry.getKey());
		    org.jsoup.select.Elements myImgs = doc.select("."+entry.getKey());

		    for (org.jsoup.nodes.Element element : myImgs) {
		    	//element.text(entry.getValue());

		    	element.append(entry.getValue());
		    }

	    }

	    return new W3CDom().fromJsoup(doc);
	}

	private static Document html5ParseDocumentPorElemento(String inputHTML,Long facturaId) throws IOException,Exception{

	    org.jsoup.nodes.Document doc;


	    doc = Jsoup.parse(new File(inputHTML), "UTF-8");

	    RecuperoFactura rf = RecuperoFactura.find.byId(facturaId);

	    Map<String,String> datos = new HashMap<>();

	    datos.put("pv", rf.puntoVenta.numero);
	    datos.put("numeroFactura", rf.numero);
	    datos.put("fecha_emision", utils.DateUtils.formatDate(rf.fecha));
	    datos.put("fecha_desde", utils.DateUtils.formatDate(rf.fecha_desde));
	    datos.put("fecha_hasta", utils.DateUtils.formatDate(rf.fecha_hasta));

	    String recupero_tipo_pago = (rf.recupero_tipo_pago_id != null)?rf.recuperoTipoPago.nombre:"Contado";

	    //if(recupero_tipo_pago.compareToIgnoreCase("cuenta corriente") ==  0 && rf.puntoVenta.deposito_id.intValue() == Deposito.LACMI) {
	    if(recupero_tipo_pago.compareToIgnoreCase("cuenta corriente") ==  0) {
	    	recupero_tipo_pago = "Otra";
	    }

	    datos.put("tipo_pago",recupero_tipo_pago);



	    datos.put("cuit", rf.cliente.cuit2);
	    datos.put("razon_social", rf.cliente.nombre);

	    String iva = (rf.cliente.condicionIva != null)?rf.cliente.condicionIva.descripcion:"IVA Responsable Inscripto";
	    datos.put("ivaa", iva);
	    String direccion = rf.cliente.getFirstDireccion();
	    datos.put("direccion", direccion);

	    datos.put("importe", utils.NumberUtils.moneda(rf.getTotalFacturado()) );
	    datos.put("cae", (rf.cae!=null)? rf.cae:"" );
	    datos.put("fechacae",utils.DateUtils.formatDate(rf.fecha_vencimiento));

	    if(rf.recuperoFacturaLinea.size() < 25) {

		    String lineas ="";

		    for(RecuperoFacturaLinea rfl :rf.recuperoFacturaLinea) {

		    	String prod = (rfl.nota != null && !rfl.nota.isEmpty())?rfl.producto.nombre+"-"+rfl.nota: rfl.producto.nombre;

			    lineas += "<tr>" +
			    		"        		<td style='text-align: left'>"+prod+"</td>" +
			    		"        		<td>"+rfl.cantidad+"</td>" +
			    		"                <td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.precio)+"</td>" +
			      		"                <td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.getTotal())+"</td>" +
			    		"            </tr>";
		    }

		    datos.put("lineas",lineas);
	    }else if(rf.recuperoFacturaLinea.size() >= 25 && rf.recuperoFacturaLinea.size() < 50 ) {
	    	 List<RecuperoFacturaLinea> first = new ArrayList<>(rf.recuperoFacturaLinea.subList(0, 24));
			 List<RecuperoFacturaLinea> second = new ArrayList<>(rf.recuperoFacturaLinea.subList(25,rf.recuperoFacturaLinea.size()));

			 	String lineas ="";
			 	BigDecimal total1 = new BigDecimal(0);

			    for(RecuperoFacturaLinea rfl :first) {

			    	String prod = (rfl.nota != null && !rfl.nota.isEmpty())?rfl.producto.nombre+"-"+rfl.nota: rfl.producto.nombre;
			    	total1 = total1.add(rfl.getTotal());
				    lineas += "<tr>" +
				    		"<td style='text-align: left'>"+prod+"</td>" +
				    		"<td>"+rfl.cantidad+"</td>" +
				    		"<td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.precio)+"</td>" +
				    		"<td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.getTotal())+"</td>" +
				    		"</tr>";
			    }

			    datos.put("lineas",lineas);
			    datos.put("total1",utils.NumberUtils.moneda(total1));

			    String lineas2 ="";

			    for(RecuperoFacturaLinea rfl :second) {

			    	String prod = (rfl.nota != null && !rfl.nota.isEmpty())?rfl.producto.nombre+"-"+rfl.nota: rfl.producto.nombre;

				    lineas2 += "<tr>" +
				    		"<td style='text-align: left'>"+prod+"</td>" +
				    		"<td>"+rfl.cantidad+"</td>" +
				    		"<td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.precio)+"</td>" +
				    	  	"<td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.getTotal())+"</td>" +
				    		"</tr>";
			    }

			    datos.put("lineas2",lineas2);


	    }else if(rf.recuperoFacturaLinea.size() >= 50 && rf.recuperoFacturaLinea.size() <= 75 ) {
	    		List<RecuperoFacturaLinea> first = new ArrayList<>(rf.recuperoFacturaLinea.subList(0, 24));
	    		List<RecuperoFacturaLinea> second = new ArrayList<>(rf.recuperoFacturaLinea.subList(25,49));
	    		List<RecuperoFacturaLinea> tres = new ArrayList<>(rf.recuperoFacturaLinea.subList(50,rf.recuperoFacturaLinea.size()));

			 	String lineas ="";
			 	BigDecimal total1 = new BigDecimal(0);

			    for(RecuperoFacturaLinea rfl :first) {

			    	String prod = (rfl.nota != null && !rfl.nota.isEmpty())?rfl.producto.nombre+"-"+rfl.nota: rfl.producto.nombre;
			    	total1 = total1.add(rfl.getTotal());
				    lineas += "<tr>" +
				    		"        		<td style='text-align: left'>"+prod+"</td>" +
				    		"        		<td>"+rfl.cantidad+"</td>" +
				    		"               <td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.precio)+"</td>" +
				    		"               <td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.getTotal())+"</td>" +
				    		"            </tr>";
			    }

			    datos.put("lineas",lineas);
			    datos.put("total1",utils.NumberUtils.moneda(total1));

			    String lineas2 ="";
			    BigDecimal total2 = new BigDecimal(0);
			    for(RecuperoFacturaLinea rfl :second) {

			    	String prod = (rfl.nota != null && !rfl.nota.isEmpty())?rfl.producto.nombre+"-"+rfl.nota: rfl.producto.nombre;
			    	total2 = total2.add(rfl.getTotal());
				    lineas2 += "<tr>" +
				    		"        		<td style='text-align: left'>"+prod+"</td>" +
				    		"        		<td>"+rfl.cantidad+"</td>" +
				    		"                <td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.precio)+"</td>" +
				    		"                <td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.getTotal())+"</td>" +
				    		"            </tr>";
			    }

			    datos.put("lineas2",lineas2);
			    datos.put("total2",utils.NumberUtils.moneda(total2));

			    String lineas3 ="";

			    for(RecuperoFacturaLinea rfl :tres) {

			    	String prod = (rfl.nota != null && !rfl.nota.isEmpty())?rfl.producto.nombre+"-"+rfl.nota: rfl.producto.nombre;

				    lineas3 += "<tr>" +
				    		"        		<td style='text-align: left'>"+prod+"</td>" +
				    		"        		<td>"+rfl.cantidad+"</td>" +
				    		"               <td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.precio)+"</td>" +
				    		"               <td style='text-align: center;'>"+utils.NumberUtils.moneda(rfl.getTotal())+"</td>" +
				    		"            </tr>";
			    }

			    datos.put("lineas3",lineas3);
	    }


	    String qrBase =  generarJsonQr(rf.id,rf.fecha,rf.puntoVenta.numero,TipoComprobante.FACTURA,rf.numero,rf.getBase().doubleValue(),rf.cliente.getTipoDocAfip(),rf.cliente.getDocAfip(),rf.cae);
	    String qr ="<img height='140' width='140'  src='data:image/png;base64,"+qrBase+"'>";
	    datos.put("qr",qr);

	    for (Map.Entry<String, String> entry : datos.entrySet()) {
	    	Logger.debug("xxxxxxx "+entry.getKey());
		    org.jsoup.select.Elements myImgs = doc.select("."+entry.getKey());

		    for (org.jsoup.nodes.Element element : myImgs) {
		    	//element.text(entry.getValue());

		    	element.append(entry.getValue());
		    }

	    }

	    return new W3CDom().fromJsoup(doc);
	}

	private static Document html5ParseDocumentPorElementoNotaCredito(String inputHTML,Long id) throws IOException,Exception{

	    org.jsoup.nodes.Document doc;


	    doc = Jsoup.parse(new File(inputHTML), "UTF-8");



	    RecuperoNotaCredito rd = RecuperoNotaCredito.find.byId(id);


	    RecuperoFactura rf = RecuperoFactura.find.byId(rd.recupero_factura_id);

	    Map<String,String> datos = new HashMap<>();

	    datos.put("pv", rd.puntoVenta.numero);
	    datos.put("numeroFactura", rd.numero);
	    datos.put("fc", rf.getNumeroFactura());

	    datos.put("fecha_emision", utils.DateUtils.formatDate(rd.fecha));

	    Periodo periodo = Periodo.getPeriodoByDate(rd.fecha);
		datos.put("fecha_desde", utils.DateUtils.formatDate(periodo.date_start));
	    datos.put("fecha_hasta", utils.DateUtils.formatDate(periodo.date_stop));

	    datos.put("tipo_pago",((rf.recupero_tipo_pago_id != null)?rf.recuperoTipoPago.nombre:"Contado"));



	    datos.put("cuit", rf.cliente.cuit2);
	    datos.put("razon_social", rf.cliente.nombre);

	    String iva = (rf.cliente.condicionIva != null)?rf.cliente.condicionIva.descripcion:"IVA Responsable Inscripto";
	    datos.put("ivaa", iva);
	    String direccion = rf.cliente.getFirstDireccion();
	    datos.put("direccion", direccion);

	    datos.put("importe", utils.NumberUtils.moneda(rd.getTotal()) );

	    datos.put("cae", (rd.cae!=null)? rd.cae:"" );
	    datos.put("fechacae",utils.DateUtils.formatDate(rd.fecha_vencimiento));
	    String lineas ="";


		    lineas += "<tr>" +
		    		"        		<td style='text-align: left'>"+rd.producto.nombre+"</td>" +
		    		"        		<td>"+rd.cantidad+"</td>" +
		    		"                <td style='text-align: right'>"+utils.NumberUtils.moneda(rd.precio)+"</td>" +
		    		"                <td style='text-align: right'>$ 0,00</td>" +
		    		"                <td style='text-align: right'>$ 0,00</td>" +
		    		"                <td style='text-align: right'>"+utils.NumberUtils.moneda(rd.getTotal())+"</td>" +
		    		"            </tr>";


	    datos.put("lineas",lineas);

	    String qrBase =  generarJsonQr(rd.id,rd.fecha,rf.puntoVenta.numero,TipoComprobante.NOTA_CREDITO,rd.numero,rd.getTotal().doubleValue(),rf.cliente.getTipoDocAfip(),rf.cliente.getDocAfip(),rd.cae);
	    String qr ="<img height='140' width='140' src='data:image/png;base64,"+qrBase+"'>";
	    datos.put("qr",qr);


	    for (Map.Entry<String, String> entry : datos.entrySet()) {
	    	Logger.debug("xxxxxxx "+entry.getKey());
		    org.jsoup.select.Elements myImgs = doc.select("."+entry.getKey());

		    for (org.jsoup.nodes.Element element : myImgs) {
		    	//element.text(entry.getValue());

		    	element.append(entry.getValue());
		    }

	    }

	    return new W3CDom().fromJsoup(doc);
	}

	private static Document html5ParseDocumentPorElementoNotaDebito(String inputHTML,Long id) throws IOException,Exception{

	    org.jsoup.nodes.Document doc;

	    doc = Jsoup.parse(new File(inputHTML), "UTF-8");

	    RecuperoNotaDebito rd = RecuperoNotaDebito.find.byId(id);

	    RecuperoFactura rf = RecuperoFactura.find.byId(rd.recupero_factura_id);

	    Map<String,String> datos = new HashMap<>();

	    datos.put("pv", rd.puntoVenta.numero);
	    datos.put("numeroFactura", rd.numero);
	    datos.put("fc", rf.getNumeroFactura());

	    datos.put("fecha_emision", utils.DateUtils.formatDate(rd.fecha));

	    Periodo periodo = Periodo.getPeriodoByDate(rd.fecha);
		datos.put("fecha_desde", utils.DateUtils.formatDate(periodo.date_start));
	    datos.put("fecha_hasta", utils.DateUtils.formatDate(periodo.date_stop));

	    datos.put("tipo_pago",((rf.recupero_tipo_pago_id != null)?rf.recuperoTipoPago.nombre:"Contado"));

	    datos.put("cuit", rf.cliente.cuit2);
	    datos.put("razon_social", rf.cliente.nombre);

	    String iva = (rf.cliente.condicionIva != null)?rf.cliente.condicionIva.descripcion:"IVA Responsable Inscripto";
	    datos.put("ivaa", iva);
	    String direccion = rf.cliente.getFirstDireccion();
	    datos.put("direccion", direccion);

	    datos.put("importe", utils.NumberUtils.moneda(rd.getTotal()) );

	    datos.put("cae", (rd.cae!=null)? rd.cae:"" );
	    datos.put("fechacae",utils.DateUtils.formatDate(rd.fecha_vencimiento));
	    String lineas ="";


		    lineas += "<tr>" +
		    		"        		<td style='text-align: left'>"+rd.producto.nombre+"</td>" +
		    		"        		<td>"+rd.cantidad+"</td>" +
		    		"                <td style='text-align: right'>"+utils.NumberUtils.moneda(rd.precio)+"</td>" +
		    		"                <td style='text-align: right'>$ 0,00</td>" +
		    		"                <td style='text-align: right'>$ 0,00</td>" +
		    		"                <td style='text-align: right'>"+utils.NumberUtils.moneda(rd.getTotal())+"</td>" +
		    		"            </tr>";


	    datos.put("lineas",lineas);

	    String qrBase =  generarJsonQr(rd.id,rd.fecha,rf.puntoVenta.numero,TipoComprobante.NOTA_DEBITO,rd.numero,rd.getTotal().doubleValue(),rf.cliente.getTipoDocAfip(),rf.cliente.getDocAfip(),rd.cae);
	    String qr ="<img height='140' width='140' src='data:image/png;base64,"+qrBase+"'>";
	    datos.put("qr",qr);



	    for (Map.Entry<String, String> entry : datos.entrySet()) {
	    	Logger.debug("xxxxxxx "+entry.getKey());
		    org.jsoup.select.Elements myImgs = doc.select("."+entry.getKey());

		    for (org.jsoup.nodes.Element element : myImgs) {
		    	//element.text(entry.getValue());

		    	element.append(entry.getValue());
		    }
	    }

	    return new W3CDom().fromJsoup(doc);
	}


	public static String generarJsonQr(Long id,Date fecha,String puntoVenta,int tipoComprobante,String nroCmp,double importe,int docTipo,Long doc,String cae) throws Exception {



		//ObjectNode restJs = Json.newObject();
		Map<String, Object> restJs = new HashMap<>();
		restJs.put("ver", 1);
		restJs.put("fecha", utils.DateUtils.formatDate(fecha, "yyyy-MM-dd"));//XXXXXXXXXXXX
		restJs.put("cuit", new Long("30712224300"));
		restJs.put("ptoVta", new Integer(puntoVenta));
		restJs.put("tipoCmp", tipoComprobante);
		restJs.put("nroCmp", new Integer(nroCmp));
		restJs.put("importe", importe);
		restJs.put("moneda", "PES");
		restJs.put("ctz", 1);
		restJs.put("tipoDocRec", docTipo);
		restJs.put("nroDocRec", doc);
		restJs.put("tipoCodAut", "E");
		restJs.put("codAut", new Long(cae));

		ObjectMapper mapper = new ObjectMapper();

		JsonNode node = mapper.convertValue(restJs, JsonNode.class);


		byte[] bytes = node.toString().getBytes();

		String base64Encoded = DatatypeConverter.printBase64Binary(bytes);
	    System.out.println("Encoded Json---------------:\n"+node.toString());
	    System.out.println(base64Encoded + "\n");


		String url= "https://www.afip.gob.ar/fe/qr/?p="+base64Encoded;

		String ret = generateQR(url, 140,140);

		return ret;



		//{"ver":1,"fecha":"2020-10-13","cuit":30000000007,"ptoVta":10,"tipoCmp":1,"nroCmp":94,"importe":12100,"moneda":"DOL","ctz":65,"tipoDocRec":80,"nroDocRec":20000000001,"tipoCodAut":"E","codAut":70417054367476}
	}


	public static String generateQR(String text, int h, int w) throws Exception
    {
		String dirTemp = System.getProperty("java.io.tmpdir");
		File file = new File(dirTemp+"/qr1.png");

	   Charset charset = Charset.forName("ISO-8859-1");
       CharsetEncoder encoder = charset.newEncoder();
       byte[] b = null;
       ByteBuffer bb = encoder.encode(CharBuffer.wrap(text));
       b = bb.array();
       String data = new String(b, "ISO-8859-1");

       BitMatrix matrix = null;
       QRCodeWriter writer = new QRCodeWriter();
       matrix = writer.encode(data, com.google.zxing.BarcodeFormat.QR_CODE, w, h);
       MatrixToImageWriter.writeToFile(matrix, "png", file);


      // BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
       //  MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));

       byte[] fileContent = Files.readAllBytes(file.toPath());
       String ret =  Base64.getEncoder().encodeToString(fileContent);

      // OutputStream out = new FileOutputStream(file);
       return ret;
    }

}
