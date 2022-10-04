package controllers.compras;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import models.Estado;
import models.OrdenLinea;
import models.Solicitud;
import models.SolicitudLinea;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import views.html.compras.solicitudes.modales.*;
import views.html.contabilidad.pagos.reportes.modalInformeLote;
import views.html.contabilidad.pagos.reportes.modalInformeMensualImpuestos;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.google.common.collect.Lists;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

@Security.Authenticated(Secured.class)
public class SolicitudesReportesController extends Controller {
	
	@CheckPermiso(key = "solicitudesVerReporteImputacionPreventva")
	public static Result reporteImputacionPreventiva(Long idSolicitud) throws IOException {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/imputacion_preventiva.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/solicitudes/reporteImputacionPreventiva.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      Solicitud solicitud = Solicitud.find.byId(idSolicitud);
		      
		      List<Integer> ls =  new ArrayList<Integer>();
		      ls.add(idSolicitud.intValue());
		      
		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Codigo");
		      metadata.addFieldAsList("listado.Total");
		       
		      report.setFieldsMetadata(metadata);
		      
		      context.put("expediente", (solicitud.expediente != null)?solicitud.expediente.getExpedienteEjercicio():"SIN EXPEDIENTE");
		      context.put("asunto", (solicitud.expediente != null)?solicitud.expediente.descripcion:"SIN EXPEDIENTE");
		      context.put("listado", getMetadataReporteImputacionPreventiva(ls));
		      context.put("sePuedeImprimir",(solicitud.estado_id == Estado.SOLICITUD_ESTADO_APRESUPUESTO || solicitud.estado_id == Estado.SOLICITUD_ESTADO_AUTORIZADO)?true:false);
		      
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			 
	    	return ok(archivo);
	}
	
	public static Result reportePedidoAbastecimiento(Long idSolicitud) throws IOException {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/pedido_abastecimiento.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/solicitudes/pa.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      Solicitud solicitud = Solicitud.find.byId(idSolicitud);
		      
		      //List<Integer> ls =  new ArrayList<Integer>();
		      //ls.add(idSolicitud.intValue());
		      
		      context.put("fecha",(solicitud.date_start != null)?DateUtils.formatDate(solicitud.date_start):"");
		      context.put("servicio", (solicitud.departamento != null)?solicitud.departamento.nombre:"");
		      context.put("nota",(solicitud.descripcion != null && !solicitud.descripcion.isEmpty())?solicitud.descripcion:"");
		      context.put("referencia",solicitud.referencia);
		      context.put("paciente",(solicitud.cliente_id != null)?solicitud.cliente.id_paciente_rismi+"-"+solicitud.cliente.nombre:"");
		      
		      List<SolicitudLinea> sll = SolicitudLinea.find.where().eq("solicitud_id", solicitud.id).orderBy("producto.nombre asc").findList();
		      
		      List<List<SolicitudLinea>> contenedorLineas = Lists.partition(sll, 21); 
		      
		      
		      Logger.debug("1111111111111111111111-----------------"+contenedorLineas.size());
		      
		      context.put("cnl", contenedorLineas);
		      	
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			 
	    	return ok(archivo);
	}
	
	public static Result reporteCuadroSolicitud() throws IOException {
		
		List<Integer> ls = getSeleccionados();
		
		if(ls.size() == 0 ) {
			flash("error", "No se han seleccionado solicitudes.");
			return ok(modalReporteCuadroSolicitud.render(null));
		}
		
		List<Solicitud> solicitudes = Solicitud.find.where().in("id", ls).findList();
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/cuadro_solicitud.xls");
		
		try {
			if(archivo.exists()) archivo.delete();
			
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			
			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			 
			CellStyle style = libro.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			HSSFFont font = (HSSFFont) libro.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			
			CellStyle estiloMonedaConFondo = libro.createCellStyle();
			estiloMonedaConFondo.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			estiloMonedaConFondo.setFillPattern(CellStyle.SOLID_FOREGROUND);
			estiloMonedaConFondo.setDataFormat((short) 7);
			estiloMonedaConFondo.setBorderRight(CellStyle.BORDER_THIN);
			estiloMonedaConFondo.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMonedaConFondo.setBorderTop(CellStyle.BORDER_THIN);
			estiloMonedaConFondo.setBorderBottom(CellStyle.BORDER_THIN);
			HSSFFont font2 = (HSSFFont) libro.createFont();
			font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
			estiloMonedaConFondo.setFont(font);
			
			
			
			Sheet hoja = libro.createSheet("Cuadro Solicitud");
		
			Row fila = hoja.createRow(0);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Producto");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(1);
			celda0.setCellValue("Cantidad");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(2);
			celda0.setCellValue("Precio");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(3);
			celda0.setCellValue("Unidad de medida");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(4);
			celda0.setCellValue("Subtotal");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(5);
			celda0.setCellValue("Nombre Paciente");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(6);
			//celda0.setCellValue("TIPO CUENTA");
			celda0.setCellValue("CUENTA");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(7);
			celda0.setCellValue("EXP");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(8);
			celda0.setCellValue("Fecha");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(9);
			celda0.setCellValue("Servicio");
			celda0.setCellStyle(style);
			
			
			
			int f = 1;
			BigDecimal total = new BigDecimal(0);
			
			for (Solicitud solicitud : solicitudes) {
				if(solicitud.lineas != null && solicitud.lineas.size() > 0){
					for(SolicitudLinea fl :solicitud.lineas){
						fila = hoja.createRow(f);
						for(int c=0;c<11;c++){
							Cell celda = fila.createCell(c);
							
							if(fl.precio_estimado == null){
								fl.precio_estimado = new BigDecimal(0);
							}
							switch (c) {
								case 0:
									celda.setCellValue(fl.producto.nombre.toUpperCase());
									celda.setCellStyle(comun);
									break;
								case 1:
									celda.setCellValue(fl.cantidad.intValue());
									celda.setCellStyle(comun);
									break;	
								case 2:
									celda.setCellType(Cell.CELL_TYPE_NUMERIC);
									//if(fl.precio_estimado != null){
										celda.setCellValue(Math.round(fl.precio_estimado.doubleValue()*100.0)/100.0);
									/*}else{
										celda.setCellValue(new Float(0));
									}*/
									celda.setCellStyle(estiloMoneda);
									break;		
								case 3:
									celda.setCellValue(fl.udm.nombre);
									celda.setCellStyle(comun);
									break;		
								case 4:
									
									celda.setCellType(Cell.CELL_TYPE_NUMERIC);
									celda.setCellValue(Math.round(fl.precio_estimado.multiply(fl.cantidad).doubleValue()*100.0)/100.0);
									celda.setCellStyle(estiloMoneda);
									BigDecimal t2 = fl.precio_estimado.multiply(fl.cantidad);
									total = total.add(t2);
									
									break;
								case 5:
									celda.setCellValue((solicitud.cliente != null)?solicitud.cliente.nombre.toUpperCase():"");
									celda.setCellStyle(comun);
									break;	
								case 6:
									String profe = (solicitud.tipo_cuenta_id != null)?solicitud.tipoCuenta.nombre:"";
									celda.setCellValue(profe);
									//celda.setCellValue(solicitud.tipoCuenta.nombre);
									celda.setCellStyle(comun);
									break;
								case 7:
									if(solicitud.expediente != null){
										celda.setCellValue(solicitud.expediente.getExpedienteEjercicio());
									}else{
										celda.setCellValue("");
									}
									celda.setCellStyle(comun);
									break;
								case 8:
									if(solicitud.fecha_imputacion != null){
										celda.setCellValue(utils.DateUtils.formatDate(solicitud.fecha_imputacion));
									}else{
										celda.setCellValue("");
									}
									celda.setCellStyle(comun);
									break;	
								case 9:
									if(solicitud.departamento_id != null){
										celda.setCellValue(solicitud.departamento.nombre);
									}else{
										celda.setCellValue("");
									}
									celda.setCellStyle(comun);
									break;		
								default:
									break;
							}	
						}
						f++;
					}	
				}
			}
			fila = hoja.createRow(f);
			
			Cell celda = fila.createCell(0);
			celda.setCellStyle(estiloMonedaConFondo);
			celda = fila.createCell(1);
			celda.setCellStyle(estiloMonedaConFondo);
			celda = fila.createCell(2);
			celda.setCellStyle(estiloMonedaConFondo);
			celda = fila.createCell(3);
			celda.setCellValue("Total");
			celda.setCellStyle(estiloMonedaConFondo);
			celda = fila.createCell(4);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(Math.round(total.doubleValue()*100.0)/100.0);
			celda.setCellStyle(estiloMonedaConFondo);
			celda = fila.createCell(5);
			celda.setCellStyle(estiloMonedaConFondo);
			celda = fila.createCell(6);
			celda.setCellStyle(estiloMonedaConFondo);
			celda = fila.createCell(7);
			celda.setCellStyle(estiloMonedaConFondo);
			celda = fila.createCell(8);
			celda.setCellStyle(estiloMonedaConFondo);
			libro.write(archivoTmp);
			celda = fila.createCell(9);
			celda.setCellStyle(estiloMonedaConFondo);
			libro.write(archivoTmp); 
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(modalReporteCuadroSolicitud.render(archivo.getPath()));
	}
	
	public static Result reporteLineasCotizacion(Long id) throws IOException {
	
		List<Integer> ls = getSeleccionados();
		
		if(ls.size() == 0 ) {
			flash("error", "No se han seleccionado solicitudes.");
			return ok(modalLineasCotizacion.render(null));
		}
		
		List<Solicitud> solicitudes = Solicitud.find.where().in("id", ls).findList();
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/lineas_cotizacion.xls");
		
		try {
			
			
			if(archivo.exists()) archivo.delete();
			
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			
			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			
			Sheet hoja = libro.createSheet("Lineas Cotizacion");
			 
			
			Row fila = hoja.createRow(1);
			//fila = hoja.createRow(0);
			if(id == 1) {
				
				
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("solicitud");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(1);
				celda0.setCellValue("descr");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(2);
				celda0.setCellValue("cant");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(3);
				celda0.setCellValue("cuenta analitica");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(4);
				celda0.setCellValue("Unidad de medida");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(5);
				celda0.setCellValue("precio");
				celda0.setCellStyle(comun);
				
			 
			}else if(id ==2) {
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("descr");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(1);
				celda0.setCellValue("cant");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(2);
				celda0.setCellValue("precio");
				celda0.setCellStyle(comun);
				
			}else if(id ==3) {
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("descr");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(1);
				celda0.setCellValue("cant");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(2);
				celda0.setCellValue("precio");
				celda0.setCellStyle(comun);
				
				celda0 = fila.createCell(3);
				celda0.setCellValue("TOTAL");
				celda0.setCellStyle(comun);
			}
			
			String sols= ""; 
			String notas= ""; 
			int f = 2; 
			for (Solicitud solicitud : solicitudes) {
				sols += solicitud.id.toString()+"-";
				notas += solicitud.descripcion+"-";
				if(solicitud.lineas != null && solicitud.lineas.size() > 0){
					for(SolicitudLinea fl :solicitud.lineas){
						fila = hoja.createRow(f);
						for(int c=0;c<11;c++){
							Cell celda = fila.createCell(c);
							if(id == 1) {
								switch (c) {
									case 0:
										celda.setCellValue(solicitud.id.toString());
										celda.setCellStyle(comun);
										break;
									case 1:
										celda.setCellValue(fl.producto.nombre);
										celda.setCellStyle(comun);
										break;	
									case 2:
										celda.setCellType(Cell.CELL_TYPE_NUMERIC);
										celda.setCellValue(fl.cantidad.doubleValue());
										celda.setCellStyle(comun);
										break;		
									case 3:
										celda.setCellValue(fl.cuentaAnalitica.codigo);
										celda.setCellStyle(comun);
										break;
									case 4:
										celda.setCellValue(fl.udm.nombre);
										celda.setCellStyle(comun);
										break;		
									case 5:
										
										celda.setCellType(Cell.CELL_TYPE_NUMERIC);
										//if(fl.precio_estimado != null){
											celda.setCellValue(Math.round(fl.precio_estimado.doubleValue()*100.0)/100.0);
										/*}else{
											celda.setCellValue(new Float(0));
										}*/
										celda.setCellStyle(estiloMoneda);
										break;
										
									default:
										break;
								}	
							}else if(id == 2 || id == 3) {
								switch (c) {
								case 0:
									celda.setCellValue(fl.producto.nombre);
									celda.setCellStyle(comun);
									break;
								case 1:
									celda.setCellType(Cell.CELL_TYPE_NUMERIC);
									celda.setCellValue(fl.cantidad.doubleValue());
									celda.setCellStyle(comun);
									break;	
								case 2:
									if(id == 3) {
										celda.setCellType(Cell.CELL_TYPE_NUMERIC);
										celda.setCellValue(fl.precio_estimado.doubleValue());
										celda.setCellStyle(estiloMoneda);
									}else if(id == 2) {
										celda.setCellValue(new Float(0));
										celda.setCellStyle(comun);
									}
									break;	
								case 3:
									if(id == 3) {
										celda.setCellType(Cell.CELL_TYPE_NUMERIC);
										celda.setCellValue(Math.round(fl.precio_estimado.multiply(fl.cantidad).doubleValue()*100.0)/100.0);
										celda.setCellStyle(estiloMoneda);
									}
									break;	
								default:
									break;
								}	
							}
						}
						f++;
					}	
				}
			}
			
			fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("SOLICITUD N°:"+sols);
			
			if(!notas.isEmpty()) {
				fila = hoja.createRow(f);
				fila.createCell(0).setCellValue("NOTAS:"+notas);
			}
			
			libro.write(archivoTmp); 
			 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(modalLineasCotizacion.render(archivo.getPath()));
	}
	
	public static Result reporteImputacionPreventivaLista() throws IOException {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/imputacion_preventiva.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/solicitudes/reporteImputacionPreventiva.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      
		      List<Integer> ls = getSeleccionados();
		      Solicitud solicitud = Solicitud.find.byId(ls.get(0).longValue());
		      
		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Codigo");
		      metadata.addFieldAsList("listado.Total");
		       
		      report.setFieldsMetadata(metadata);
		      
		      context.put("expediente", (solicitud.expediente != null)?solicitud.expediente.getExpedienteEjercicio():"SIN EXPEDIENTE");
		      context.put("asunto", (solicitud.expediente != null)?solicitud.expediente.descripcion:"SIN EXPEDIENTE");
		      context.put("listado", getMetadataReporteImputacionPreventiva(ls));
		      context.put("sePuedeImprimir",(solicitud.estado_id == Estado.SOLICITUD_ESTADO_APRESUPUESTO || solicitud.estado_id == Estado.SOLICITUD_ESTADO_AUTORIZADO)?true:false);
		      
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			 
	    	return ok(modalReporteImputacionPreventiva.render(archivo.getPath()));
	}
	
	private static List<Map<String,String>> getMetadataReporteImputacionPreventiva(List<Integer> solicitud){
		List<Map<String,String>> listado = new ArrayList<Map<String,String>>();
		Map<Integer,String> cuentasCodigo =  new HashMap<Integer,String>();
		
		String sqlAjuste = " SELECT sum(sl.cantidad* COALESCE(sl.precio_estimado,0)) total,sl.cuenta_analitica_id cuenta_analitica_id, " +
					 "ca.codigo codigo "  
				   + " FROM solicitud_lineas sl"   
				   + " INNER JOIN cuentas_analiticas ca ON ca.id = sl.cuenta_analitica_id "
				   + " WHERE solicitud_id in(:idSolicitud) "   
				   + " GROUP BY sl.cuenta_analitica_id,ca.codigo ";  
		List<SqlRow> rowAjuste = Ebean.createSqlQuery(sqlAjuste).setParameter("idSolicitud", solicitud).findList(); 
		String codigoCuenta; 
		Map<Integer, BigDecimal> lineasAjuste = new HashMap<Integer, BigDecimal>();
		for(SqlRow s : rowAjuste){
			Integer idCuenta = new Integer(s.get("cuenta_analitica_id").toString());
			codigoCuenta = s.get("codigo").toString();
			BigDecimal valor = new BigDecimal(s.get("total").toString());
			if(lineasAjuste.containsKey(idCuenta)){
			    valor = lineasAjuste.get(idCuenta).add(valor);
			}
			lineasAjuste.put(idCuenta, valor);
			
			cuentasCodigo.put(idCuenta, codigoCuenta);
		}
		
		String sql = " SELECT sum(sl.cantidad*sl.precio) total," +
				   " sl.cuenta_analitica_id cuenta_analitica_id, ca.codigo codigo "  
				   + " FROM solicitud_linea_ajustes sl"   
				   + " INNER JOIN cuentas_analiticas ca ON ca.id = sl.cuenta_analitica_id "
				   + " WHERE solicitud_id in(:idSolicitud) "   
				   + " GROUP BY sl.cuenta_analitica_id,ca.codigo ";
		
		
		List<SqlRow> row = Ebean.createSqlQuery(sql).setParameter("idSolicitud", solicitud).findList(); 
		
		for(SqlRow s : row){
			Integer idCuenta = new Integer(s.get("cuenta_analitica_id").toString());
			codigoCuenta = s.get("codigo").toString();
			BigDecimal b = new BigDecimal(s.get("total").toString());
			
			if(lineasAjuste.containsKey(idCuenta)){
				b = new BigDecimal(s.get("total").toString()).add(lineasAjuste.get(idCuenta));
			}
			
			lineasAjuste.put(idCuenta, b);
			cuentasCodigo.put(idCuenta, codigoCuenta);
		}
		
		for (Entry<Integer, BigDecimal> l : lineasAjuste.entrySet()){
			Integer clave = l.getKey();
			BigDecimal valor = l.getValue();
			
			Map<String,String> d = new HashMap<String, String>();
			d.put("Codigo", cuentasCodigo.get(clave).toString());
			d.put("Total", NumberUtils.moneda(valor,2));
			listado.add(d);
		}
		
		Map<String,String> mapTmp = new HashMap<String, String>();
		List<Map<String,String>> listadoTmp = new ArrayList<Map<String,String>>();
		for(Map<String,String> f: listado){
			 
			if(f.get("Total").compareToIgnoreCase("$0,00") != 0){
				if(!f.containsKey( f.get("Codigo"))){
					mapTmp.put("Codigo", f.get("Codigo"));
					mapTmp.put("Total", f.get("Total"));
					listadoTmp.add(mapTmp);
				}
				
			}
		}
		
		return listado;
	}
	
	public static Result modalInformeFarmacia() {
		DynamicForm d = form().bindFromRequest();	
		return ok(modalInformeFarmacia.render(null,null,d));
	}
	
	public static Result informeFarmacia() {
		DynamicForm d = form().bindFromRequest();	
		Date ffh;
		Date ffd;
		
		String[] fecha_desde = request().body().asFormUrlEncoded().get("fecha_desde");
		String[] fecha_hasta = request().body().asFormUrlEncoded().get("fecha_hasta");
		
		Logger.debug("zzzzzzzzzz "+fecha_desde);
		
		if(fecha_desde == null && fecha_desde[0].isEmpty()){
			flash("error", "Debe ingresar una fecha inicio.");
			return ok(modalInformeFarmacia.render(null,null,d));
		}else{
			ffd = DateUtils.formatDate(fecha_desde[0], "dd/MM/yyyy");
		}
		
		if(fecha_hasta == null || fecha_hasta[0].isEmpty()){
			flash("error", "Debe ingresar una fecha fin.");
			return ok(modalInformeFarmacia.render(null,null,d));
		}else{
			ffh = DateUtils.formatDate(fecha_hasta[0], "dd/MM/yyyy");
		}
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		
		
		try {
			File archivo = new File(dirTemp+"/informe_farmacia_por_servicio.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Informe");
			
			CellStyle style = libro.createCellStyle();
			
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			HSSFFont font = (HSSFFont) libro.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			
			Row fila = hoja.createRow(0);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("SERVICIO");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(1);
			celda0.setCellValue("TOTAL SERVICIO");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(2);
			celda0.setCellValue("TOTAL SIN PACIENTES");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(3);
			celda0.setCellValue("TOTAL CON PACIENTES");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(4);
			celda0.setCellValue("TOTAL LINEAS");
			celda0.setCellStyle(style);
			
			
			
			
			
			String sql = "SELECT count(*) AS c,s.departamento_id as deptoId,d.nombre as deptoNombre " + 
			"FROM solicitudes s " + 
			"INNER JOIN departamentos d ON d.id = s.departamento_id " + 
			"INNER JOIN usuarios u ON u.id = s.create_usuario_id " + 
			"WHERE fecha_imputacion BETWEEN :fdesde AND :fhasta AND u.organigrama_id = :organigrama_id " + 
			"GROUP BY s.departamento_id,d.nombre ORDER BY c desc ";
			
			List<SqlRow> row = Ebean.createSqlQuery(sql).setParameter("fdesde", ffd)
														.setParameter("fhasta", ffh)
														.setParameter("organigrama_id", 90)
														.findList(); 
			
			int f = 1;
			if(row.size() > 0) {
				
				for(SqlRow x :row) {
					fila = hoja.createRow(f);
					String sql2 = "SELECT count(*) AS c " + 
							"FROM solicitudes s " + 
							"INNER JOIN departamentos d ON d.id = s.departamento_id " + 
							"INNER JOIN usuarios u ON u.id = s.create_usuario_id " + 
							"WHERE  fecha_imputacion BETWEEN :fdesde AND :fhasta AND s.departamento_id = :departamento_id AND cliente_id is null AND u.organigrama_id = :organigrama_id ";
					SqlRow cantidadSinPacientes = Ebean.createSqlQuery(sql2)
							.setParameter("fdesde", ffd)
							.setParameter("fhasta", ffh)
							.setParameter("departamento_id", x.getInteger("deptoId"))
							.setParameter("organigrama_id", 90).findUnique();
					
					String sql3 = "SELECT count(*) AS c " + 
							"FROM solicitudes s " + 
							"INNER JOIN departamentos d ON d.id = s.departamento_id " + 
							"INNER JOIN usuarios u ON u.id = s.create_usuario_id " + 
							"WHERE fecha_imputacion BETWEEN :fdesde AND :fhasta AND s.departamento_id = :departamento_id AND cliente_id is not null AND u.organigrama_id = :organigrama_id";
					SqlRow cantidadConPacientes = Ebean.createSqlQuery(sql3)
							.setParameter("fdesde", ffd)
							.setParameter("fhasta", ffh)
							.setParameter("departamento_id", x.getInteger("deptoId"))
							.setParameter("organigrama_id", 90).findUnique();
					
					String sql4 = "SELECT count(*) AS c " + 
							"FROM solicitudes s " + 
							"INNER JOIN departamentos d ON d.id = s.departamento_id " + 
							"INNER JOIN usuarios u ON u.id = s.create_usuario_id " + 
							"INNER JOIN solicitud_lineas sl ON sl.solicitud_id = s.id " + 
							"WHERE fecha_imputacion BETWEEN :fdesde AND :fhasta AND s.departamento_id = :departamento_id AND u.organigrama_id = :organigrama_id ";
					SqlRow cantidadLineas = Ebean.createSqlQuery(sql4)
							.setParameter("fdesde", ffd)
							.setParameter("fhasta", ffh)
							.setParameter("departamento_id", x.getInteger("deptoId"))
							.setParameter("organigrama_id", 90).findUnique();
					
					
					for(int c=0;c<5;c++){
						Cell celda = fila.createCell(c);
						switch (c) {
							case 0:
								celda.setCellValue(x.getString("deptoNombre"));
								celda.setCellStyle(style);
								break;
							case 1:
								celda.setCellValue(x.getInteger("c"));
								celda.setCellStyle(style);
								break;	
							case 2:
								celda.setCellValue(cantidadSinPacientes.getInteger("c"));
								celda.setCellStyle(style);
								break;		
							case 3:
								celda.setCellValue(cantidadConPacientes.getInteger("c"));
								celda.setCellStyle(style);
								break;
							case 4:
								celda.setCellValue(cantidadLineas.getInteger("c"));
								celda.setCellStyle(style);
								break;		 
							default:
								break;
						}	
					}
					 
					f++;
				}
			}
			
			libro.write(archivoTmp); 
			
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalInformeFarmacia.render(archivo.getPath(),null,d));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
	}
			
	public static Result modalInformeFarmaciaPorUsuario() {
		DynamicForm d = form().bindFromRequest();	
		return ok(modalInformeFarmaciaPorUsuario.render(null,null,d));
	}
	
	public static Result informeFarmaciaPorUsuario() {
		DynamicForm d = form().bindFromRequest();	
		Date ffh;
		Date ffd;
		
		String[] fecha_desde = request().body().asFormUrlEncoded().get("fecha_desde");
		String[] fecha_hasta = request().body().asFormUrlEncoded().get("fecha_hasta");
		
		Logger.debug("zzzzzzzzzz "+fecha_desde);
		
		if(fecha_desde == null && fecha_desde[0].isEmpty()){
			flash("error", "Debe ingresar una fecha inicio.");
			return ok(modalInformeFarmaciaPorUsuario.render(null,null,d));
		}else{
			ffd = DateUtils.formatDate(fecha_desde[0], "dd/MM/yyyy");
		}
		
		if(fecha_hasta == null || fecha_hasta[0].isEmpty()){
			flash("error", "Debe ingresar una fecha fin.");
			return ok(modalInformeFarmaciaPorUsuario.render(null,null,d));
		}else{
			ffh = DateUtils.formatDate(fecha_hasta[0], "dd/MM/yyyy");
		}
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		
		
		try {
			File archivo = new File(dirTemp+"/informe_farmacia_por_usuario.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Informe");
			
			CellStyle style = libro.createCellStyle();
			
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			HSSFFont font = (HSSFFont) libro.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			
			Row fila = hoja.createRow(0);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("USUARIO");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(1);
			celda0.setCellValue("TOTAL USUARIO");
			celda0.setCellStyle(style);
			
			
			
			
			
			String sql = "SELECT count(*) AS c,u.id,u.nombre as nombre " + 
			"FROM solicitudes s " + 
			//"INNER JOIN departamentos d ON d.id = s.departamento_id " + 
			"INNER JOIN usuarios u ON u.id = s.create_usuario_id " + 
			"WHERE fecha_imputacion BETWEEN :fdesde AND :fhasta "+
			"AND u.id in(19,31,387,391) " + 
			"GROUP BY u.id,u.nombre ORDER BY c desc ";
			
			List<SqlRow> row = Ebean.createSqlQuery(sql).setParameter("fdesde", ffd)
														.setParameter("fhasta", ffh)
														//.setParameter("organigrama_id", 90)
														.findList(); 
			
			int f = 1;
			if(row.size() > 0) {
				
				for(SqlRow x :row) {
					fila = hoja.createRow(f);
					 
					
					 
					
					 
					
					for(int c=0;c<5;c++){
						Cell celda = fila.createCell(c);
						switch (c) {
							case 0:
								celda.setCellValue(x.getString("nombre"));
								celda.setCellStyle(style);
								break;
							case 1:
								celda.setCellValue(x.getInteger("c"));
								celda.setCellStyle(style);
								break;	
						
							default:
								break;
						}	
					}
					 
					f++;
				}
			}
			
			libro.write(archivoTmp); 
			
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalInformeFarmaciaPorUsuario.render(archivo.getPath(),null,d));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
	}
	
	public static Result informeFarmaciaPaciente() throws IOException {
		
		List<Integer> ls = getSeleccionados();
		
		if(ls.size() == 0 ) {
			flash("error", "No se han seleccionado solicitudes.");
			return ok(modalLineasCotizacion.render(null));
		}
		
		List<Solicitud> solicitudes = Solicitud.find.where().in("id", ls).findList();
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/lineas.xls");
		
		try {
			
			
			if(archivo.exists()) archivo.delete();
			
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			
			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			
			CellStyle style = libro.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			HSSFFont font = (HSSFFont) libro.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			
			Sheet hoja = libro.createSheet("Lineas Cotizacion");
			 
			Row fila = hoja.createRow(1);
			Cell celda0 = fila.createCell(0);
			String sols= ""; 
			String notas= ""; 
			int f = 1; 
			
			for (Solicitud solicitud : solicitudes) {
				
				fila = hoja.createRow(f);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Referencia");
				celda0.setCellStyle(style);
				
				celda0 = fila.createCell(1);
				celda0.setCellValue("Fecha");
				celda0.setCellStyle(style);
				
				celda0 = fila.createCell(2);
				celda0.setCellValue("Servicio");
				celda0.setCellStyle(style);
				
				celda0 = fila.createCell(3);
				celda0.setCellValue("Médico Solicitante");
				celda0.setCellStyle(style);
				
				f++;
				fila = hoja.createRow(f);
				for(int c=0;c<3;c++){
					Cell celda = fila.createCell(c);
					celda.setCellValue(solicitud.id.toString());
					celda.setCellStyle(comun);
					switch (c) {
						case 0:
							celda.setCellValue("SOL"+solicitud.id.toString());
							celda.setCellStyle(comun);
							break;
						case 1:
							celda.setCellValue(utils.DateUtils.formatDate(solicitud.create_date));
							celda.setCellStyle(comun);
							break;	
						case 2:
							celda.setCellValue(solicitud.departamento.nombre);
							celda.setCellStyle(comun);
							break;	
						case 3:
							celda.setCellValue((solicitud.medico != null)?solicitud.medico.apellido:"");
							celda.setCellStyle(comun);
							break;		
						default:
							break;
					}		
				}
				
				if(solicitud.cliente != null) {
					f++;
					fila = hoja.createRow(f);
					celda0 = fila.createCell(0);
					celda0.setCellValue("Paciente");
					celda0.setCellStyle(style);
					
					celda0 = fila.createCell(1);
					celda0.setCellValue("ID");
					celda0.setCellStyle(style);
					
					f++;
					fila = hoja.createRow(f);
					celda0 = fila.createCell(0);
					celda0.setCellValue(solicitud.cliente.nombre);
					celda0.setCellStyle(comun);
					
					celda0 = fila.createCell(1);
					celda0.setCellValue((solicitud.cliente.id_paciente_rismi != null)?solicitud.cliente.id_paciente_rismi:"");
					celda0.setCellStyle(comun);
					
				}
				
				if(solicitud.lineas != null && solicitud.lineas.size() > 0){
					f++;
					fila = hoja.createRow(f);
					celda0 = fila.createCell(0);
					celda0.setCellValue("Producto");
					celda0.setCellStyle(style);
					
					celda0 = fila.createCell(1);
					celda0.setCellValue("Cantidad");
					celda0.setCellStyle(style);
					
					for(SolicitudLinea fl :solicitud.lineas){
						f++;
						fila = hoja.createRow(f);
						celda0 = fila.createCell(0);
						celda0.setCellValue(fl.producto.nombre);
						celda0.setCellStyle(comun);
						
						celda0 = fila.createCell(1);
						celda0.setCellValue(fl.cantidad.doubleValue());
						celda0.setCellStyle(comun);
					}	
				}
				f++;f++;
				
			}
			
			/*fila = hoja.createRow(f);
			fila.createCell(0).setCellValue("SOLICITUD N°:"+sols);
			
			if(!notas.isEmpty()) {
				fila = hoja.createRow(f);
				fila.createCell(0).setCellValue("NOTAS:"+notas);
			}*/
			
			libro.write(archivoTmp); 
			 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(modalLineasCotizacion.render(archivo.getPath()));
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
