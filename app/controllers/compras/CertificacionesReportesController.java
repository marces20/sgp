package controllers.compras;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.MathTool;
import org.apache.velocity.tools.generic.ValueParser;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import controllers.Secured;

import models.Certificacion;
import models.CertificacionLinea;
import models.CuentaBancaria;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.Orden;
import models.Pago;
import models.auth.Permiso;
import models.xdocreport.MetadataReporteElevaciones;
import models.xdocreport.MetadataReporteElevacionesProductos;
import fr.opensagres.xdocreport.converter.ConverterRegistry;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.IConverter;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import play.Logger;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.ArrayUtils;
import utils.DateUtils;
import utils.NumberUtils;
import views.html.compras.certificaciones.modales.*;
import views.html.compras.certificaciones.reportes.*;
import views.html.contabilidad.pagos.reportes.modalInformeLote;

@Security.Authenticated(Secured.class)
public class CertificacionesReportesController extends Controller {
	
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
	
	public static Result bajas() {
		List<Integer> certificacionesSeleccionadas = getSeleccionados();
		if(certificacionesSeleccionadas.size() <= 0){
			flash("error", "Debe seleccionar una certificacion.");
		 	return ok(modalReporteResultadoBajas.render(null));
		}
		
		List<Certificacion> certificaciones = Certificacion.find.where().in("id", certificacionesSeleccionadas).findList();

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/bajas.odt");
		File archivoPdf = new File(dirTemp+"/bajas.pdf");
		Certificacion c = new Certificacion();
		
		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/compras/certificaciones/bajas.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			context.put("certificaciones", certificaciones);
			context.put("dateTool", new DateTool());
			context.put("math", new MathTool());
			context.put("date", new DateUtils());
			System.out.println(":::::: "+DateUtils.getMesLetras(2));
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
            //report.convert(context, options, out);
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte.");
			return ok(modalReporteResultadoBajas.render(null));
		}
		return ok(modalReporteResultadoBajas.render(archivo.getPath()));
		/*try {
			// 1) Load ODT file and set Velocity template engine and cache it to the registry                       
			InputStream in= Play.application().resourceAsStream("resources/reportes/compras/certificaciones/bajas.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			// 2) Create Java model context 
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			
			IContext context = report.createContext();
			context.put("certificaciones", certificaciones);
			context.put("dateTool", new DateTool());
			context.put("math", new MathTool());
			context.put("date", new DateUtils());
			context.put("saltoLinea", "<p style=\"page-break-after:always\"></p>");
			
			 
			OutputStream out = new FileOutputStream(archivo);
			return ok(modalReporteResultadoBajas.render(archivo.getPath()));
			//OutputStream out = new FileOutputStream(archivoPdf);
			//Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			//report.convert(context, options, out);
			//return ok(modalReporteResultadoBajas.render(archivoPdf.getPath()));
			
		} catch (Exception e) {
			flash("error", "No se pudo generar el reporte."+e);
			return ok(modalReporteResultadoBajas.render(null));
		}
		*/
		//return ok(modalReporteResultadoBajas.render(archivoPdf.getPath()));
	}	
	
	public static Result reporteElevaciones(boolean a) throws IOException {
		
		List<Integer> certificacionesSeleccionadas = getSeleccionados();
		
		if(certificacionesSeleccionadas.size() <= 0){
			flash("error", "Debe seleccionar una certificacion.");
		 	return ok(modalReporteElevacion.render(null));
		}
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/elevaciones.odt");
		DecimalFormat f = new DecimalFormat("###,###.##");
		
		try {
	     	// 1) Load Docx file by filling Freemarker template engine and cache
			InputStream in = null;
			
			String sql = " SELECT c.expediente_id expedienteId "  
					   + " FROM certificaciones c"   
					   + " WHERE c.id IN(:idsCertificaciones)"
					   + " group by c.expediente_id ";  			
			List<SqlRow> row = Ebean.createSqlQuery(sql).setParameter("idsCertificaciones", certificacionesSeleccionadas).findList(); 
			
			if(row.size() > 1){
				flash("error", "Se deben seleccionar certificaciones de un mismo expediente.");
			 	return ok(modalReporteElevacion.render(null));
			}else{
				if(Permiso.check("verExpedientesGuardiasMonotributo") && ArrayUtils.contains(Expediente.EXP_GUARDIA_MONOTRIBUTOS, row.get(0).getInteger("expedienteId").longValue())){
					if(a){
						in = Play.application().resourceAsStream("resources/reportes/compras/certificaciones/elevacion_gm.odt");
					}else{
						in = Play.application().resourceAsStream("resources/reportes/compras/certificaciones/elevacion_sin_descuento_gm.odt");
					}
				}else{
					if(a){
						in = Play.application().resourceAsStream("resources/reportes/compras/certificaciones/elevacion.odt");
					}else{
						in = Play.application().resourceAsStream("resources/reportes/compras/certificaciones/elevacion_sin_descuento.odt");
					}
				}
			}
	        IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
	
	        // 3) Create context Java model
	        IContext context = report.createContext();
        
	        List<Certificacion> certificaciones = Certificacion.find.where().in("id", certificacionesSeleccionadas).orderBy("proveedor.nombre").findList();
			Integer x = 1;
		
			List<MetadataReporteElevaciones> listados = new ArrayList<MetadataReporteElevaciones>();
			BigDecimal total = new BigDecimal(0);
			BigDecimal descuento = new BigDecimal(0);
			for(Certificacion c : certificaciones){
				
				MetadataReporteElevaciones m = new MetadataReporteElevaciones();
				m.setOrden(x.toString());
				m.setNombre(c.proveedor.nombre);
				m.setCuit(c.proveedor.cuit.toString());
				
				List<MetadataReporteElevacionesProductos> p = new ArrayList<MetadataReporteElevacionesProductos>();
				BigDecimal subTotal = new BigDecimal(0);
				BigDecimal subDescuento = new BigDecimal(0);
				
				for(CertificacionLinea cl : c.certificacionLinea){
					MetadataReporteElevacionesProductos mp = new MetadataReporteElevacionesProductos(cl.producto.nombre,cl.cantidad.toString(),cl.precio.toString());
					m.addMetadataReporteElevacionesProductos(mp);
					BigDecimal t = cl.cantidad.multiply(cl.precio);
					BigDecimal d = cl.cantidad.multiply(cl.precio);
					subTotal = subTotal.add(t);
					subDescuento = subDescuento.add(cl.getTotalDescuento());
					
				} 
				BigDecimal subTotalTmp = subTotal.subtract(subDescuento);
				total = total.add(subTotalTmp);
				
				m.setSubTotal(f.format(subTotalTmp).toString());
				m.setSubDescuento(f.format(subDescuento).toString());
				listados.add(m);
				x++;
			}  
			
			Certificacion c = Certificacion.find.byId(certificacionesSeleccionadas.get(0).longValue());
			context.put("expediente",c.expediente.getExpedienteEjercicio());
			context.put("expedienteDescripcion",c.expediente.descripcion);
			context.put("mes", DateUtils.getMesLetras(c.fecha_certificacion.getMonth()));
			
			context.put( "total", f.format(total).toString() );
			context.put( "listados", listados );
        
			OutputStream out = new FileOutputStream(archivo);
			report.process(context, out);
         
			flash("success", "El archivo fue creado correctamente.");
		  return ok(modalReporteElevacion.render(archivo.getPath()));
	    } catch (IOException e) {
	      e.printStackTrace();
	    } catch (XDocReportException e) {
	      e.printStackTrace();
	    }
			
	 	flash("error", "No se puedo crear el archivo.");
	 	return ok(modalReporteElevacion.render(null));
	}
	 
	public static Result reporteCertificacion() throws IOException {
		
		List<Integer> certificacionesSeleccionadas = getSeleccionados();
		
		if(certificacionesSeleccionadas.size() <= 0){
			flash("error", "Debe seleccionar una certificacion.");
		 	return ok(modalReporteCertificacion.render(null));
		}
		
		/*if(!soloCertificacionesCertificada(certificacionesSeleccionadas)){
			flash("error", "Debe seleccionar certificaciones solo en estado certificadas.");
		 	return ok(modalReporteCertificacion.render(null));
		}*/
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/certificacion.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/certificaciones/certificacion.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      Certificacion c = Certificacion.find.byId(certificacionesSeleccionadas.get(0).longValue());
		      
		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Nombre");
		      metadata.addFieldAsList("listado.Dni");
		      metadata.addFieldAsList("listado.Porcentaje");
		       
		      report.setFieldsMetadata(metadata);
		      
		      context.put("expediente",c.expediente.getExpedienteEjercicio());
		      context.put("ultimodia", DateUtils.getLastDayOfMonth(c.fecha_certificacion));
		      context.put("mes", DateUtils.getMesLetras(c.fecha_certificacion.getMonth()));
		       
		      SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
			  String anio = format1.format(c.fecha_certificacion);
		      context.put("anio", anio);
		      
		      context.put("listado", getMetadataReporteCertificacion(certificacionesSeleccionadas));
		      
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);
		      
		      flash("success", "El archivo fue creado correctamente.");
			  return ok(modalReporteCertificacion.render(archivo.getPath()));
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			
		 	flash("Error", "No se puedo crear el archivo.");
		 	return ok(modalReporteCertificacion.render(null));
	}
	
	public static Boolean soloCertificacionesCertificada(List<Integer> idsCertificaciones) {
		return Certificacion.find.where().ne("estado_id", Estado.CERTIFICACION_ESTADO_CERTIFICADO).in("id", idsCertificaciones).findRowCount() == 0;
	}
	
	private static List<Map<String,String>> getMetadataReporteCertificacion(List<Integer> idsCertificaciones){
		List<Map<String,String>> listado = new ArrayList<Map<String,String>>();
		
		String sql = " SELECT c.id id,p.nombre nombre,a.dni dni,sum(l.descuento) descuento "  
				   + " FROM certificaciones c"   
				   + " INNER JOIN proveedores p ON p.id = c.proveedor_id "
				   + " INNER JOIN agentes a ON a.id = p.agente_id"
				   + " INNER JOIN certificaciones_lineas l ON c.id = l.certificacion_id"
				   + " WHERE c.id IN(:idsCertificaciones)"
				   + " group by c.id,p.nombre,a.dni,l.certificacion_id order by nombre ";  
		
		List<SqlRow> row = Ebean.createSqlQuery(sql).setParameter("idsCertificaciones", idsCertificaciones).findList(); 
		
		for(SqlRow s : row){
			
			Double descuento = new Double((s.get("descuento") != null)?s.get("descuento").toString():"0");
			Double porcentaje = 100 - descuento;
			
			Map<String,String> d = new HashMap<String, String>();
			d.put("Nombre", s.get("nombre").toString());
			d.put("Dni", s.get("dni").toString());
			DecimalFormat f = new DecimalFormat("##.00");
			d.put("Porcentaje", f.format(porcentaje)+"%");
			listado.add(d);
		}
		
		return listado;
	}
	
	public static Result reporteTasas(){
		List<Integer> certificacionesSeleccionadas = getSeleccionados();
		
		if(certificacionesSeleccionadas.size() <= 0){
			flash("error", "Debe seleccionar una certificacion.");
		 	return ok(modalReporteTasas.render(null));
		}
		
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		try {
			File archivo = new File(dirTemp+"/tasa.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Tasa");
			
			List<Certificacion> certificaciones = Certificacion.find.where().in("id", certificacionesSeleccionadas).orderBy("proveedor.nombre").findList();
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("ORDEN");
			fila.createCell(1).setCellValue("APELLIDO Y NOMBRE");
			fila.createCell(2).setCellValue("CUIT");
			fila.createCell(3).setCellValue("BASE");
			
			int f = 1; 
			Double total = (double) 0;  
			for (Certificacion certificacion : certificaciones) {
					fila = hoja.createRow(f);
					for(int c=0;c<4;c++){
						Cell celda = fila.createCell(c);
						
						switch (c) {
						case 0:
							celda.setCellValue(f);
							break;
						case 1:
							celda.setCellValue(certificacion.proveedor.nombre);
							break;	
						case 2:
							celda.setCellValue(certificacion.proveedor.cuit);
							break;		
						case 3:
							celda.setCellValue(certificacion.getTotal().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							break;		
						default:
							break;
						}
					}
					total += certificacion.getTotal().doubleValue();
					f++;
			}
			fila = hoja.createRow(f);
			fila.createCell(2).setCellValue("Total");
			fila.createCell(3).setCellValue(total);
			 
			
			libro.write(archivoTmp);   
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			 
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalReporteTasas.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
	}
	
	public static Result reportePlanillaSueldos(){
		List<Integer> certificacionesSeleccionadas = getSeleccionados();
		if(certificacionesSeleccionadas.size() <= 0){
			flash("error", "Debe seleccionar una certificacion.");
		 	return ok(modalReportePlanillaSueldos.render(null));
		}
		
		try {
			return ok(modalReportePlanillaSueldos.render(getPathReportePlanillaSueldos(certificacionesSeleccionadas)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok();
	}
	
	public static String getPathReportePlanillaSueldos(List<Integer> certificacionesSeleccionadas){
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		try {
			File archivo = new File(dirTemp+"/planillaSueldos.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Tasa");
			
			List<Certificacion> certificaciones = Certificacion.find.where().in("id", certificacionesSeleccionadas).orderBy("proveedor.nombre").findList();
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("ORDEN");
			fila.createCell(1).setCellValue("APELLIDO Y NOMBRE");
			fila.createCell(2).setCellValue("CUIT");
			fila.createCell(3).setCellValue("BASE");
			
			int f = 1; 
			Double total = (double) 0;  
			for (Certificacion certificacion : certificaciones) {
					fila = hoja.createRow(f);
					for(int c=0;c<4;c++){
						Cell celda = fila.createCell(c);
						
						switch (c) {
						case 0:
							celda.setCellValue(f);
							break;
						case 1:
							celda.setCellValue(certificacion.proveedor.nombre);
							break;	
						case 2:
							celda.setCellValue(certificacion.proveedor.cuit);
							break;		
						case 3:
							celda.setCellValue(certificacion.getBase().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							break;		
						default:
							break;
						}
					}
					total += certificacion.getBase().doubleValue();
					f++;
			}
			fila = hoja.createRow(f);
			fila.createCell(2).setCellValue("Total");
			fila.createCell(3).setCellValue(total);
			 
			
			libro.write(archivoTmp);   
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			 
			flash("success", "El archivo fue creado correctamente.");
			return archivo.getPath();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		} catch (Exception e) {
			return "";
		}
	}
	
}
