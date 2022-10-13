package controllers.contabilidad;

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
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Cuenta;
import models.Estado;
import models.Factura;
import models.FacturaDato;
import models.FacturaLinea;
import models.FacturaLineaImpuesto;
import models.Pago;
import models.RemitoLinea;
import models.TipoCuenta;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.velocity.tools.generic.MathTool;

import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.RetencionesUtils;
import views.html.contabilidad.facturas.reportes.*;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.google.common.collect.Lists;

import controllers.Secured;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

@Security.Authenticated(Secured.class)
public class FacturasReportesController extends Controller  {
	
	public static Result reporteComisiones() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(modalReporteControlFacturas.render(null));
		}
		
		List<FacturaLinea> listaFacturasLineas = FacturaLinea.find.where().in("factura_id", facturasSeleccionados).orderBy("factura.fecha_factura,id asc").findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/reporteComisiones.odt");
		
		try{
			BigDecimal n = new BigDecimal(0);
			for(FacturaLinea lx :listaFacturasLineas) {
				n = n.add(lx.getTotal());
			}
			
			String totalMoneda = utils.NumberUtils.moneda(n);
			String titulo = (listaFacturasLineas.size() > 0)?"ORDEN DE PAGO N°"+listaFacturasLineas.get(0).factura.ordenPago.getNombreCompleto() +" - EXP:"+listaFacturasLineas.get(0).factura.expediente.getInstitucionExpedienteEjercicio():"";
			String proveedor = (listaFacturasLineas.size() > 0)?listaFacturasLineas.get(0).factura.proveedor.nombre:"";
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/reporteComisiones.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasLineas", listaFacturasLineas);
			context.put("date", new DateUtils());
			context.put("totalMoneda",totalMoneda);
			context.put("titulo",titulo);
			context.put("proveedor",proveedor);
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(modalReporteControlFacturas.render(null));
		}
		
		
		return ok(modalReporteControlFacturas.render(archivo.getPath()));
	}
	
	public static Result reporteComprobanteRetencionMunicipal() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteComprobanteRetencionMunicipal.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where().in("factura_id", facturasSeleccionados).eq("cuenta_id",Cuenta.RET_MUNICIPAL_DERECHO_INSPECCION).findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/comprobanteRetencionMunicipal.odt");
		
		try{
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/comprobanteRetencionMunicipal.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasImpuestos", listaFacturasImpuestos);
			context.put("date", new DateUtils());
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteComprobanteRetencionMunicipal.render(null));
		}
		
		return ok(reporteComprobanteRetencionMunicipal.render(archivo.getPath()));
	}
	
	public static Result reporteComprobanteRetencionGcia() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}
		
		/*if(facturasSeleccionados.size() > 1) {
			flash("error", "Debe seleccionar una sola factura.");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}*/
		
		
		List<Pago> lp = Pago.find.where()
						//.eq("factura_id", facturasSeleccionados.get(0))
						.in("factura_id",facturasSeleccionados)
						.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
						.ne("estado_id",Estado.PAGO_ESTADO_CANCELADO)
						.eq("tipo","payment")
						.findList();
		
		if(lp.size() == 0) {
			flash("error", "Debe seleccionar facturas pagada para generar el reporte");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
															.in("factura_id", facturasSeleccionados)
															.disjunction()
															.eq("cuenta_id",Cuenta.RET_GCIAS_4245)
															.eq("cuenta_id",Cuenta.RET_GCIAS_4245_19)
															.endJunction()
															.findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/comprobante_retencion_ganancias.odt");
		
		try{
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/comprobante_retencion_ganancias.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasImpuestos", listaFacturasImpuestos);
			context.put("date", new DateUtils());
			//context.put("fechaPago", DateUtils.formatDate(lp.get(0).fecha_pago,"dd/MM/yyyy"));
			 
			
			//listaFacturasImpuestos.get(0).factura_id
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}
		
		return ok(reporteComprobanteRetencioniibb.render(archivo.getPath()));
	}
	
	public static Result reporteComprobanteRetencionIva() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}
		
		if(facturasSeleccionados.size() > 1) {
			flash("error", "Debe seleccionar una sola factura.");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}
		
		
		List<Pago> lp = Pago.find.where()
						.eq("factura_id", facturasSeleccionados.get(0))
						.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
						.ne("estado_id",Estado.PAGO_ESTADO_CANCELADO)
						.eq("tipo","payment")
						.findList();
		
		if(lp.size() == 0) {
			flash("error", "Debe seleccionar facturas pagada para generar el reporte");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
															.in("factura_id", facturasSeleccionados)
															.eq("cuenta_id",Cuenta.RET_IVA).findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/comprobante_retencion_iva.odt");
		
		try{
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/comprobante_retencion_iva.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasImpuestos", listaFacturasImpuestos);
			context.put("date", new DateUtils());
			context.put("fechaPago", DateUtils.formatDate(lp.get(0).fecha_pago,"dd/MM/yyyy"));
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}
		
		return ok(reporteComprobanteRetencioniibb.render(archivo.getPath()));
	}
	
	
	public static Result reporteRendicionSellos() {
		
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteRendicionSellos.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
				.in("factura_id", facturasSeleccionados)
				.disjunction()
				.eq("cuenta_id",Cuenta.RET_DGR_SELLOS)
				.eq("cuenta_id",Cuenta.RET_DGR_SELLOS_ART21)
				.eq("cuenta_id",Cuenta.RET_DGR_SELLOS_ART22)
				.endJunction()
				.orderBy("factura.proveedor.nombre").findList();

		
		try {
			String newLine = System.getProperty("line.separator");
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/generacion_retencion_sellos.txt");
			
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "Cp1252"));
			
			
			for (FacturaLineaImpuesto l : listaFacturasImpuestos) {
				
				out.append(l.nombre+",");
				out.append("0106"+",");
				out.append(l.factura.proveedor.nombre.replace(",","")+",");
				out.append(DateUtils.formatDate(l.factura.fecha_orden_pago,"dd-MM-yyyy")+",");
				String base = (l.base == null)?l.monto.divide(new BigDecimal(0.005),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
				out.append(base+",");
				out.append("0.010000"+",");
				out.append(l.monto.setScale(2, BigDecimal.ROUND_HALF_UP)+",");
				out.append("0"+",");
				out.append(""+",");
				out.append(""+",");
				out.append(""+",");
				out.append("50");
				out.append("\r\n");
				
			}
			out.flush();
			out.close();
			
			flash("success", "El archivo fue creado correctamente.");
			return ok(reporteRendicionSellos.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(reporteRendicionSellos.render(null));
	}
	
	public static Result reporteComprobanteRetencionSellos() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteComprobanteRetencionSellos.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
				.in("factura_id", facturasSeleccionados)
				.disjunction()
				.eq("cuenta_id",Cuenta.RET_DGR_SELLOS)
				.eq("cuenta_id",Cuenta.RET_DGR_SELLOS_ART21)
				.eq("cuenta_id",Cuenta.RET_DGR_SELLOS_ART22)
				.endJunction()
				.findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/comprobanteSellos.odt");
		
		try{
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/comprobanteRetencionSellos.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasImpuestos", listaFacturasImpuestos);
			context.put("date", new DateUtils());
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteComprobanteRetencionSellos.render(null));
		}
		
		return ok(reporteComprobanteRetencionSellos.render(archivo.getPath()));
	}
	
	public static Result reporteComprobanteRetencioniibb() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
				.in("factura_id", facturasSeleccionados)
				.disjunction()
				.eq("cuenta_id",Cuenta.RET_IIBB)
				.eq("cuenta_id",Cuenta.RET_IIBB_331)
				.endJunction()
				.findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/comprobanteIIBB.odt");
		
		try{
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/comprobanteRetencioniibb.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasImpuestos", listaFacturasImpuestos);
			context.put("date", new DateUtils());
			context.put("letra", new NumeroALetra());
			context.put("utils", new NumberUtils());
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteComprobanteRetencioniibb.render(null));
		}
		
		return ok(reporteComprobanteRetencioniibb.render(archivo.getPath()));
	}
	
	public static Result reporteComprobanteRetencioniibb370() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteComprobanteRetencioniibb370.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where().in("factura_id", facturasSeleccionados).eq("cuenta_id",Cuenta.RET_IIBB_370).findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/comprobanteIIBB370.odt");
		
		try{
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/comprobanteRetencioniibb370.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasImpuestos", listaFacturasImpuestos);
			context.put("date", new DateUtils());
			context.put("letra", new NumeroALetra());
			context.put("utils", new NumberUtils());
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteComprobanteRetencioniibb370.render(null));
		}
		
		return ok(reporteComprobanteRetencioniibb370.render(archivo.getPath()));
	}
	
	public static Result reporteComprobanteRetencionSeguridad() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteComprobanteRetencionSeguridad.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where().in("factura_id", facturasSeleccionados).eq("cuenta_id",Cuenta.RET_SEGURIDAD).findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/comprobanteSeguridad.odt");
		
		try{
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/comprobanteRetencionSeguridad.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasImpuestos", listaFacturasImpuestos);
			context.put("date", new DateUtils());
			context.put("letra", new NumeroALetra());
			context.put("utils", new NumberUtils());
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteComprobanteRetencionSeguridad.render(null));
		}
		
		return ok(reporteComprobanteRetencionSeguridad.render(archivo.getPath()));
	}
	
	public static Result reporteComprobanteRetencionReggral() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteComprobanteRetencionReggral.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
				.in("factura_id", facturasSeleccionados)
				.disjunction()
				.eq("cuenta_id",Cuenta.RET_REGGRAL)
				.eq("cuenta_id",Cuenta.RET_SUSS1)
				.endJunction()
				.findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/comprobanteReggral.odt");
		
		try{
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/comprobanteRetencionReggral.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasImpuestos", listaFacturasImpuestos);
			context.put("date", new DateUtils());
			context.put("letra", new NumeroALetra());
			context.put("utils", new NumberUtils());
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteComprobanteRetencionReggral.render(null));
		}
		
		return ok(reporteComprobanteRetencionReggral.render(archivo.getPath()));
	}
	
	public static Result reporteComprobanteRetencionLimpieza() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteComprobanteRetencionLimpieza.render(null));
		}
		
		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where().in("factura_id", facturasSeleccionados).eq("cuenta_id",Cuenta.RET_LIMPIEZA).findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/comprobanteLimpieza.odt");
		
		try{
        	
			InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/comprobanteRetencionLimpieza.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("listaFacturasImpuestos", listaFacturasImpuestos);
			context.put("date", new DateUtils());
			context.put("letra", new NumeroALetra());
			context.put("utils", new NumberUtils());
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
		
		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteComprobanteRetencionLimpieza.render(null));
		}
		
		return ok(reporteComprobanteRetencionLimpieza.render(archivo.getPath()));
	}
	
	public static Result OPCservicios() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(resultadoOPCservicios.render(null));
		}

		String sql = " SELECT count(*) FROM facturas f " +
					 " WHERE f.id in (:listId) and (f.debito_automatico is null or f.debito_automatico = false) " +
					 " GROUP BY f.expediente_id, periodo_id, tipo_cuenta_id,profe";
	
		List<SqlRow> facturasSql = Ebean.createSqlQuery(sql).setParameter("listId", facturasSeleccionados).findList();
		
		/*
		 * Si hay más de un registro quiere decir que hay distintos expedientes o distindos periodos
		 */
		if(facturasSql.size() > 1) {
			flash("error", "Las facturas seleccionadas deben ser del mismo expediente, mismo periodo y misma cuenta.");
			return ok(resultadoOPCservicios.render(null));
		}
		
		String sqlImpuestos = "SELECT " +
				" SUM ((select round(cast(sum((fl.precio*fl.cantidad)+((fl.precio*fl.cantidad*COALESCE(fl.descuento,0))/100)) as numeric),2) "+
				" from factura_lineas fl where fl.factura_id = f.id)) as base, "+
				" sum(get_impuesto(f.id,108)) as gcias, "+//GANANCIAS
				" sum(get_impuesto(f.id,259)) as suss, "+
				" sum(get_impuesto(f.id,254)) as iibb, "+
				" sum(get_impuesto(f.id,94)) as papagar, " +
				" sum(get_impuesto(f.id,277)) as suss1, " +
				" sum(get_impuesto(f.id,545)) as suss2682, " +
				" sum(get_impuesto(f.id,281)) as gcias3884, " +
				" sum(get_impuesto(f.id,284)) as gcias4245, " +
				" sum(get_impuesto(f.id,544)) as gcias424519, " +
				" sum(get_impuesto(f.id,282)) as suss3883, " +
				" sum(get_impuesto(f.id,283)) as muni, " +
				" sum(get_impuesto(f.id,263)) as sellos, "+ 
				" sum(get_impuesto(f.id,540)) as sellosart21, "+ 
				" sum(get_impuesto(f.id,541)) as sellosart22, "+ 
				" sum(get_impuesto(f.id,276)) as dgr331, " + 
				" sum(get_impuesto(f.id,274)) as dgr429, " +
				" sum(get_impuesto(f.id,261)) as dgr370, " +
				" sum(get_impuesto(f.id,110)) as dgr196, " +
				" sum(get_impuesto(f.id,285)) as gcias3726, " +
				" tipo_cuenta_id,profe " +
				" from facturas f, proveedores p "+
				" where f.proveedor_id=p.id "+
				" AND f.id in (:listId) group by tipo_cuenta_id,profe";
		
		List<SqlRow> impuestosSql = Ebean.createSqlQuery(sqlImpuestos).setParameter("listId", facturasSeleccionados).findList();
		SqlRow impuestos = impuestosSql.get(0);
		
		
		Double monto_afip = Math.round(impuestos.getDouble("gcias") *100.0)/100.0;
		Double monto_prov = Math.round(impuestos.getDouble("papagar") *100.0)/100.0;
		Double monto_orden = Math.round(impuestos.getDouble("base") *100.0)/100.0;
		Double monto_suss = Math.round(impuestos.getDouble("suss") *100.0)/100.0;
		Double monto_suss1 = Math.round(impuestos.getDouble("suss1") *100.0)/100.0;
		Double monto_suss2682 = Math.round(impuestos.getDouble("suss2682") *100.0)/100.0;
		Double gcias3884 = Math.round(impuestos.getDouble("gcias3884") *100.0)/100.0;
		Double gcias4245 = Math.round(impuestos.getDouble("gcias4245") *100.0)/100.0;
		Double gcias424519 = Math.round(impuestos.getDouble("gcias424519") *100.0)/100.0;
		Double suss3883 = Math.round(impuestos.getDouble("suss3883") *100.0)/100.0;
		Double muni = Math.round(impuestos.getDouble("muni") *100.0)/100.0;
		Double sello = Math.round(impuestos.getDouble("sellos") *100.0)/100.0;
		Double sellosart21 = Math.round(impuestos.getDouble("sellosart21") *100.0)/100.0;
		Double sellosart22 = Math.round(impuestos.getDouble("sellosart22") *100.0)/100.0;
		Double monto_dgr331= Math.round(impuestos.getDouble("dgr331") *100.0)/100.0;
		
		Double monto_dgr429= Math.round(impuestos.getDouble("dgr429") *100.0)/100.0;
		Double monto_dgr370= Math.round(impuestos.getDouble("dgr370") *100.0)/100.0;
		Double monto_dgr196= Math.round(impuestos.getDouble("dgr196") *100.0)/100.0;
		Double gcias3726 = Math.round(impuestos.getDouble("gcias3726") *100.0)/100.0;
		
		System.out.println("------------ "+monto_afip);
		String sqlFacturas = "select p.nombre nombre, p.cuit cuit, f.id facturaId, tipo_cuenta_id,profe, " +
							 "(select round(cast(sum((fl.precio*fl.cantidad)+((fl.precio*fl.cantidad*COALESCE(fl.descuento,0))/100)) as numeric),2) "+
							 " 	from factura_lineas fl where fl.factura_id = f.id) as base, " +
							 "sum(get_impuesto(f.id,108)+get_impuesto(f.id,285)+get_impuesto(f.id,544)+get_impuesto(f.id,281)+get_impuesto(f.id,284)) as gcias, " +//GANANCIAS
							 "sum(get_impuesto(f.id,263)) as sellos, " +
							 "sum(get_impuesto(f.id,540)) as sellosart21, " +
							 "sum(get_impuesto(f.id,541)) as sellosart22, " +
							 "(sum(get_impuesto(f.id,259))+sum(get_impuesto(f.id,545))+sum(get_impuesto(f.id,277))+sum(get_impuesto(f.id,282))) as suss, " +
							 
							 "sum(get_impuesto(f.id,254)) as iibb, " +
							 "sum(get_impuesto(f.id,94)) as papagar, " +
							 "(sum(get_impuesto(f.id,276))+sum(get_impuesto(f.id,274))+sum(get_impuesto(f.id,261))+sum(get_impuesto(f.id,110)))   as dgr331, " +
							 "sum(get_impuesto(f.id,283)) as muni " +
							 
							 "from facturas f, proveedores p " +
							 "where f.proveedor_id=p.id " +
							 "and f.id in (:listId) " +
							 "group by p.id, p.nombre, p.cuit, p.nombre, f.id " +
							 "order by p.nombre";

		List<SqlRow> facturas = Ebean.createSqlQuery(sqlFacturas).setParameter("listId", facturasSeleccionados).findList();
	
		Factura facturaDatosSimples = Factura.find.byId(facturas.get(0).getLong("facturaId"));
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/opc-servicios.odt");
		
        try {
        	
        	InputStream in = Play.application().resourceAsStream("resources/reportes/compras/certificaciones/reporte.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			metadata.addFieldAsTextStyling("saltoLineaBefore", SyntaxKind.Html);
			
			List<List<SqlRow>> contenedorFacturas = Lists.partition(facturas, 40);

            IContext context = report.createContext();
            context.put("math", new MathTool());
            context.put("totalfacturas", facturas.size());
            context.put("facturas", contenedorFacturas);
            context.put("saltoLinea", "<p style=\"page-break-after:always\"></p>");

            context.put("fecha_orden", utils.DateUtils.formatDate(facturaDatosSimples.fecha_orden_pago));
            context.put("expediente", facturaDatosSimples.expediente.getExpedienteEjercicio());
            context.put("expedienteDescripcion", facturaDatosSimples.expediente.descripcion);
            context.put("orden_pago", facturaDatosSimples.ordenPago.getOrdenEjercicio());
            
            context.put("monto_orden", utils.NumberUtils.moneda(new BigDecimal(monto_orden)));
            context.put("monto_neto",  utils.NumberUtils.moneda(new BigDecimal(((monto_orden - sellosart21 - sellosart22 -  sello - monto_afip - monto_prov - 
            		monto_suss - monto_suss1 - monto_dgr331-gcias3884-gcias4245-gcias424519-gcias3726-suss3883-muni-monto_dgr429-
            		monto_dgr370-monto_dgr196) *100.0)/100.0 )));
            
            context.put("monto_ret",utils.NumberUtils.moneda(new BigDecimal(sello)));
            context.put("monto_sellosart21",utils.NumberUtils.moneda(new BigDecimal(sellosart21)));
            context.put("monto_sellosart22",utils.NumberUtils.moneda(new BigDecimal(sellosart22)));
            
            
            
            context.put("monto_afip", utils.NumberUtils.moneda(new BigDecimal(monto_afip)));
            context.put("monto_prov", utils.NumberUtils.moneda(new BigDecimal(monto_prov)));
            context.put("monto_suss", utils.NumberUtils.moneda(new BigDecimal(monto_suss)));
            context.put("monto_suss3", utils.NumberUtils.moneda(new BigDecimal(monto_suss)));
            context.put("monto_suss1", utils.NumberUtils.moneda(new BigDecimal(monto_suss1)));
            context.put("monto_suss2682", utils.NumberUtils.moneda(new BigDecimal(monto_suss2682)));
            context.put("monto_dgr331", utils.NumberUtils.moneda(new BigDecimal(monto_dgr331)));
            context.put("monto_dgr429", utils.NumberUtils.moneda(new BigDecimal(monto_dgr429)));
            context.put("monto_dgr370", utils.NumberUtils.moneda(new BigDecimal(monto_dgr370)));
            context.put("monto_dgr196", utils.NumberUtils.moneda(new BigDecimal(monto_dgr196)));
            context.put("gcias3884", utils.NumberUtils.moneda(new BigDecimal(gcias3884)));
            context.put("gcias4245", utils.NumberUtils.moneda(new BigDecimal(gcias4245)));
            context.put("gcias424519", utils.NumberUtils.moneda(new BigDecimal(gcias424519)));
            context.put("gcias3726", utils.NumberUtils.moneda(new BigDecimal(gcias3726)));
            context.put("suss3883", utils.NumberUtils.moneda(new BigDecimal(suss3883)));
            context.put("muni", utils.NumberUtils.moneda(new BigDecimal(muni)));
            
            String cuenta = "";
            String denominacion = "";
            if(facturaDatosSimples.tipo_cuenta_id != null) {
	            cuenta = facturaDatosSimples.tipoCuenta.numero;
	            denominacion = facturaDatosSimples.tipoCuenta.denominacion;
	            
            }else {
            	 cuenta = (facturaDatosSimples.profe)?"300109408729322":"300109408769227";
                 denominacion = (facturaDatosSimples.profe)?"Parque de la Salud Programa PROFE":"Parque de la Salud de la Pcia. de Mnes. Dr. Ramón Madariaga";
            }
            context.put("cuenta", cuenta);
            context.put("denominacion",denominacion );
            
            new NumeroALetra();
			context.put("monto_letra", NumeroALetra.convertNumberToLetter(String.valueOf(monto_orden)));
            System.out.println("------------------- "+Double.toString(monto_afip));
            String[] periodoCortado = facturaDatosSimples.periodo.nombre.split("\\/");
            
            context.put("mesLetra", DateUtils.getMesLetras(Integer.parseInt(periodoCortado[0].replaceFirst ("^0*", "")) - 1));
            context.put("anio", periodoCortado[1]);
            
            OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
            
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return ok(resultadoOPCservicios.render(archivo.getPath()));
	}
	
	public static Result viatico() {
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar una factura para generar el reporte.");
			return ok(reporteOrdenDePago.render(null));
		}
		
		if(facturasSeleccionados.size() > 1) {
			flash("error", "El reporte se genera con una sola factura.");
			return ok(reporteOrdenDePago.render(null));
		}
		
		try {
			Factura facturaDatosSimples = Factura.find.byId( (long) facturasSeleccionados.get(0));
			
        	String dirTemp = System.getProperty("java.io.tmpdir");
    		File archivo = new File(dirTemp+"/orden-de-pago.odt");
    		List<String> listaErrores = new ArrayList<String>(); 
    		
        	InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/viatico.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			metadata.addFieldAsTextStyling("saltoLineaBefore", SyntaxKind.Html);
			IContext context = report.createContext();
			
			
			
			context.put("fecha_orden", utils.DateUtils.formatDate(facturaDatosSimples.fecha_orden_pago));
			context.put("expediente", facturaDatosSimples.expediente.getExpedienteEjercicio());
            context.put("expedienteDescripcion", facturaDatosSimples.expediente.descripcion);
            
             
            
            context.put("orden_pago",facturaDatosSimples.ordenPago.getOrdenEjercicio());
            context.put("monto_neto",facturaDatosSimples.getBaseMoneda());
            new NumeroALetra();
			context.put("monto_letra", NumeroALetra.convertNumberToLetter(String.valueOf(facturaDatosSimples.getBase())));
			
			String cuenta = "";
            String denominacion = "";
            if(facturaDatosSimples.tipo_cuenta_id != null) {
	            cuenta = facturaDatosSimples.tipoCuenta.numero;
	            denominacion = facturaDatosSimples.tipoCuenta.denominacion;
	        }else {
            	 cuenta = (facturaDatosSimples.profe)?"300109408729322":"300109408769227";
                 denominacion = (facturaDatosSimples.profe)?"Parque de la Salud Programa PROFE":"Parque de la Salud de la Pcia. de Mnes. Dr. Ramón Madariaga";
            }
			
			context.put("cuenta", cuenta);
	        context.put("denominacion",denominacion );
	        
	        context.put("nombre", facturaDatosSimples.proveedor.nombre);
	        
	        String dni = (facturaDatosSimples.proveedor.agente != null)?facturaDatosSimples.proveedor.agente.dni:facturaDatosSimples.proveedor.cuit.toString();
	        context.put("dni", dni);		
	        
	            
            OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
            return ok(reporteOrdenDePago.render(archivo.getPath()));
            
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "Errro al generar el reporte "+e);
		} catch (XDocReportException e) {
			e.printStackTrace();
			flash("error", "Errro al generar el reporte "+e);
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "Errro al generar el reporte "+e);
		}
		
        return ok(reporteOrdenDePago.render(null));
	}
	
	public static Result ordenDePago() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar facturas para generar el reporte.");
			return ok(reporteOrdenDePago.render(null));
		}

		if(facturasSeleccionados.size() > 1) {
			flash("error", "El reporte se genera con una sola factura.");
			return ok(reporteOrdenDePago.render(null));
		}
		
		Factura facturaDatosSimples = Factura.find.byId( (long) facturasSeleccionados.get(0));

		if(facturaDatosSimples.ordenPago == null){
			flash("error", "Debe ingresar Numero de orden de Pago.");
			return ok(reporteOrdenDePago.render(null));
		}
		
		if(facturaDatosSimples.expediente == null){
			flash("error", "Debe ingresar Numero de expediente.");
			return ok(reporteOrdenDePago.render(null));
		}
		if(facturaDatosSimples.periodo == null){
			flash("error", "Debe ingresar Numero de periodo.");
			return ok(reporteOrdenDePago.render(null));
		}
		if(facturaDatosSimples.orden == null && facturaDatosSimples.certificacionCompra == null && facturaDatosSimples.liquidacionMes == null){
			flash("error", "Debe tener una Orden Asociada.");
			return ok(reporteOrdenDePago.render(null));
		}
		
		
		
		
		String sqlImpuestos = "SELECT " +
				" SUM ((select round( cast(sum((fl.precio*fl.cantidad)+((fl.precio*fl.cantidad*COALESCE(fl.descuento,0))/100))as numeric),2) "+
				" from factura_lineas fl where fl.factura_id = f.id)) as base, "+
				" sum(get_impuesto(f.id,108)) as gcias, "+
				" sum(get_impuesto(f.id,263)) as sellos, "+
				" sum(get_impuesto(f.id,540)) as sellosart21, "+
				" sum(get_impuesto(f.id,541)) as sellosart22, "+
				" sum(get_impuesto(f.id,259)) as suss, "+
				" sum(get_impuesto(f.id,254)) as iibb, "+
				" sum(get_impuesto(f.id,94)) as papagar, " +
				" sum(get_impuesto(f.id,277)) as suss1, " +
				" sum(get_impuesto(f.id,545)) as suss2682, " +
				" sum(get_impuesto(f.id,110)) as ret_dgr, " +
				" sum(get_impuesto(f.id,258)) as iva3164_11, " +
				" sum(get_impuesto(f.id,260)) as suss1556_04, " +
				" sum(get_impuesto(f.id,109)) as suss1769_04, " +
				" sum(get_impuesto(f.id,276)) as ret331, " +
				" sum(get_impuesto(f.id,275)) as gtiactto6, " +
				" sum(get_impuesto(f.id,281)) as gcias3884, " +
				" sum(get_impuesto(f.id,285)) as gcias3726, " +
				" sum(get_impuesto(f.id,284)) as gcias4245, " +
				" sum(get_impuesto(f.id,544)) as gcias424519, " +
				" sum(get_impuesto(f.id,282)) as suss3883, " +
				" sum(get_impuesto(f.id,283)) as muni, " +
				
				" tipo_cuenta_id " +
				" from facturas f, proveedores p "+
				" where f.proveedor_id=p.id "+
				" AND f.id in (:listId) group by tipo_cuenta_id";
		
		List<SqlRow> impuestosSql = Ebean.createSqlQuery(sqlImpuestos).setParameter("listId", facturasSeleccionados).findList();
		SqlRow impuestos = impuestosSql.get(0);
		
		Double sello = Math.round(impuestos.getDouble("sellos") *100.0)/100.0;
		Double sellosart21 = Math.round(impuestos.getDouble("sellosart21") *100.0)/100.0;
		Double sellosart22 = Math.round(impuestos.getDouble("sellosart22") *100.0)/100.0;
		Double monto_afip = Math.round(impuestos.getDouble("gcias") *100.0)/100.0;
		Double monto_prov = Math.round(impuestos.getDouble("papagar") *100.0)/100.0;
		Double monto_orden = Math.round(impuestos.getDouble("base") *100.0)/100.0;
		Double monto_suss = Math.round(impuestos.getDouble("suss") *100.0)/100.0;
		Double monto_suss1 = Math.round(impuestos.getDouble("suss1") *100.0)/100.0;
		Double monto_suss2682 = Math.round(impuestos.getDouble("suss2682") *100.0)/100.0;
		Double ret_dgr = Math.round(impuestos.getDouble("ret_dgr") *100.0)/100.0;
		Double iva3164_11 = Math.round(impuestos.getDouble("iva3164_11") *100.0)/100.0;
		Double suss1556_04 = Math.round(impuestos.getDouble("suss1556_04") *100.0)/100.0;
		Double suss1769_04 = Math.round(impuestos.getDouble("suss1769_04") *100.0)/100.0;
		Double ret331 = Math.round(impuestos.getDouble("ret331") *100.0)/100.0;
		Double gtiactto6 = Math.round(impuestos.getDouble("gtiactto6") *100.0)/100.0;
		Double gcias3884 = Math.round(impuestos.getDouble("gcias3884") *100.0)/100.0;
		Double gcias4245 = Math.round(impuestos.getDouble("gcias4245") *100.0)/100.0;		
		Double gcias424519 = Math.round(impuestos.getDouble("gcias424519") *100.0)/100.0;
		Double gcias3726 = Math.round(impuestos.getDouble("gcias3726") *100.0)/100.0;	
		Double suss3883 = Math.round(impuestos.getDouble("suss3883") *100.0)/100.0;
		Double muni = Math.round(impuestos.getDouble("muni") *100.0)/100.0;
		
		try {
        	String dirTemp = System.getProperty("java.io.tmpdir");
    		File archivo = new File(dirTemp+"/orden-de-pago.odt");
    		List<String> listaErrores = new ArrayList<String>(); 
    		
        	InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/facturas/ordenDePago.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			metadata.addFieldAsTextStyling("saltoLineaBefore", SyntaxKind.Html);
			


            IContext context = report.createContext();
            context.put("math", new MathTool());

            context.put("saltoLinea", "<p style=\"page-break-after:always\"></p>");

            context.put("fecha_orden", utils.DateUtils.formatDate(facturaDatosSimples.fecha_orden_pago));
            context.put("expediente", facturaDatosSimples.expediente.getExpedienteEjercicio());
            context.put("expedienteDescripcion", facturaDatosSimples.expediente.descripcion);
            context.put("orden_pago", facturaDatosSimples.ordenPago.getOrdenEjercicio());
            
            context.put("monto_orden", utils.NumberUtils.moneda(new BigDecimal(monto_orden)));
            context.put("monto_neto",  utils.NumberUtils.moneda(new BigDecimal(((monto_orden-sellosart21-sellosart22 - sello - monto_afip - monto_prov - monto_suss -  
            		monto_suss2682 -monto_suss1 - ret_dgr - iva3164_11 - suss1556_04 - suss1769_04 - ret331 - gtiactto6-gcias3884-gcias4245-gcias424519-
            		gcias3726-suss3883-muni) *100.0)/100.0 )));
            
            context.put("monto_ret",utils.NumberUtils.moneda(new BigDecimal(sello)));
            context.put("monto_sellosart21",utils.NumberUtils.moneda(new BigDecimal(sellosart21)));
            context.put("monto_sellosart22",utils.NumberUtils.moneda(new BigDecimal(sellosart22)));
            context.put("monto_afip", utils.NumberUtils.moneda(new BigDecimal(monto_afip)));
            context.put("monto_prov", utils.NumberUtils.moneda(new BigDecimal(monto_prov)));
            context.put("monto_suss", utils.NumberUtils.moneda(new BigDecimal(monto_suss)));
            context.put("ret_dgr", utils.NumberUtils.moneda(new BigDecimal(ret_dgr)));
            context.put("iva3164_11", utils.NumberUtils.moneda(new BigDecimal(iva3164_11)));
            context.put("suss1556_04", utils.NumberUtils.moneda(new BigDecimal(suss1556_04)));  
            context.put("suss1769_04", utils.NumberUtils.moneda(new BigDecimal(suss1769_04)));
            context.put("ret331", utils.NumberUtils.moneda(new BigDecimal(ret331)));
            context.put("gtiactto6", utils.NumberUtils.moneda(new BigDecimal(gtiactto6)));
            context.put("gcias3884", utils.NumberUtils.moneda(new BigDecimal(gcias3884)));
            context.put("gcias4245", utils.NumberUtils.moneda(new BigDecimal(gcias4245)));
            context.put("gcias424519", utils.NumberUtils.moneda(new BigDecimal(gcias424519)));
            context.put("gcias3726", utils.NumberUtils.moneda(new BigDecimal(gcias3726)));
            
            context.put("suss3883", utils.NumberUtils.moneda(new BigDecimal(suss3883)));
            context.put("muni", utils.NumberUtils.moneda(new BigDecimal(muni)));
            context.put("monto_suss2682", utils.NumberUtils.moneda(new BigDecimal(monto_suss2682)));
            //context.put("profe", facturaDatosSimples.profe);
            //context.put("tipoCuenta", facturaDatosSimples.tipoCuenta.nombre);
            
            String cuenta = "";
            String denominacion = "";
            if(facturaDatosSimples.tipo_cuenta_id != null) {
            	cuenta = facturaDatosSimples.tipoCuenta.numero;
	            denominacion = facturaDatosSimples.tipoCuenta.denominacion;
	            
	        }else {
            	 cuenta = (facturaDatosSimples.profe)?"300109408729322":"300109408769227";
                 denominacion = (facturaDatosSimples.profe)?"Parque de la Salud Programa PROFE":"Parque de la Salud de la Pcia. de Mnes. Dr. Ramón Madariaga";
            }
            context.put("cuenta", cuenta);
            context.put("denominacion",denominacion );
            new NumeroALetra();
			context.put("monto_letra", NumeroALetra.convertNumberToLetter(String.valueOf(monto_orden)));
            System.out.println("------------------- "+Double.toString(monto_afip));
            context.put("monto_suss1", utils.NumberUtils.moneda(new BigDecimal(monto_suss1)));
            
            context.put("nombreProveedor", facturaDatosSimples.proveedor.nombre);
            
            Integer nop = 0;
            if(facturaDatosSimples.orden != null && facturaDatosSimples.orden.numero_orden_provision != null){
            	nop = facturaDatosSimples.orden.numero_orden_provision;
            }
            context.put("ordenProvision", nop);
            
            OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
            return ok(reporteOrdenDePago.render(archivo.getPath()));
            
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "Errro al generar el reporte "+e);
		} catch (XDocReportException e) {
			e.printStackTrace();
			flash("error", "Errro al generar el reporte "+e);
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "Errro al generar el reporte "+e);
		}
		
        return ok(reporteOrdenDePago.render(null));
		  
	}
	
	public static Result reporteFacturasCargadas(){
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado facturas.");
			return ok(modalReporteControlFacturas.render(null));
		}
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		 
		try {
			File archivo = new File(dirTemp+"/facturas.xls");
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
			
			Sheet hoja = libro.createSheet("Lineas Facturas");
			
			
			int fx = 0;
			Row fila = hoja.createRow(fx);
			Cell celda0 = fila.createCell(0);
			
			
				
			List<FacturaDato> fl = FacturaDato.find.where().in("id", facturasSeleccionados).orderBy("id").findList();
			 
				fila = hoja.createRow(fx);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Proveedor");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Expediente");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("OP");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("N° Factura");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Monto OP");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Monto F/C");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("Monto");
				celda0.setCellStyle(comun);
			 
				fx++;
			for (FacturaDato f : fl) {
				
				fila = hoja.createRow(fx);
				
				for(int c=0;c<7;c++){
					Cell celda = fila.createCell(c);
					switch (c) {
					case 0:
						celda.setCellValue(f.factura.proveedor.nombre);
						celda.setCellStyle(comun);
						break;
					case 1:
						celda.setCellValue(f.factura.expediente.getExpedienteEjercicio());
						celda.setCellStyle(comun);
						break;	
					case 2:
						celda.setCellValue(f.factura.ordenPago.getNombreCompleto());
						celda.setCellStyle(comun);
						break;	
					case 3:
						celda.setCellValue(f.numero_factura);
						celda.setCellStyle(comun);
						break;		
					case 4:
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda.setCellValue(f.factura.orden.getTotalTotal().doubleValue());
						celda.setCellStyle(estiloMoneda);
						break;	
					case 5:
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda.setCellValue(Factura.getTotalMontoFacturasCargadas(f.factura.id).doubleValue());
						celda.setCellStyle(estiloMoneda);
						break;	
					case 6:
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda.setCellValue(f.getMonto().doubleValue());
						celda.setCellStyle(estiloMoneda);
						break;		
					default:
						break;
					}
				}
				fx++;
			}
				 
			
			
			libro.write(archivoTmp);   
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			 
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalReporteControlFacturas.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
			
	}
	
	public static Result reporteLineasFacturas(){
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado facturas.");
			return ok(modalReporteControlFacturas.render(null));
		}
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		 
		try {
			File archivo = new File(dirTemp+"/lineas_facturas.xls");
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
			
			Sheet hoja = libro.createSheet("Lineas Facturas");
			
			
			int f = 0;
			Row fila = hoja.createRow(f);
			Cell celda0 = fila.createCell(0);
			
			List<Factura> facturas = Factura.find.where().in("id", facturasSeleccionados).orderBy("proveedor.nombre").findList();
			for (Factura factura : facturas) {
				
				fila = hoja.createRow(f);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Proveedor");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Expediente");
				celda0.setCellStyle(comun);
				f++;
				
				fila = hoja.createRow(f);
				celda0 = fila.createCell(0);
				celda0.setCellValue(factura.proveedor.nombre);
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(factura.expediente.getExpedienteEjercicio());
				celda0.setCellStyle(comun);
				
				f++;
				
				List<FacturaLinea> fl = FacturaLinea.find.where().eq("factura_id", factura.id).orderBy("cuentaAnalitica.nombre").findList();
				if(fl.size() > 0){
					fila = hoja.createRow(f);
					celda0 = fila.createCell(0);
					celda0.setCellValue("Producto");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue("Cuenta");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(2);
					celda0.setCellValue("Cantidad");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(3);
					celda0.setCellValue("Precio");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(4);
					celda0.setCellValue("Total");
					celda0.setCellStyle(comun);
					f++;
				}
				
				for (FacturaLinea fll : fl) {
					
					fila = hoja.createRow(f);
					
					for(int c=0;c<5;c++){
						Cell celda = fila.createCell(c);
						switch (c) {
						case 0:
							celda.setCellValue(fll.producto.nombre);
							celda.setCellStyle(comun);
							break;
						case 1:
							celda.setCellValue(fll.cuentaAnalitica.nombre);
							celda.setCellStyle(comun);
							break;	
						case 2:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(fll.cantidad.doubleValue());
							celda.setCellStyle(comun);
							break;	
						case 3:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(fll.precio.doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;	
						case 4:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(fll.getTotal().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;		
						default:
							break;
						}
					}
					f++;
				}
				f++;
			}
			
			
			
			libro.write(archivoTmp);   
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			 
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalReporteControlFacturas.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
			
	}
	
	public static Result reporteControlFacturas(){
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado facturas.");
			return ok(modalReporteControlFacturas.render(null));
		}
		
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		try {
			File archivo = new File(dirTemp+"/controlFacturas.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Lotes");
			
			List<Factura> facturas = Factura.find.where().in("id", facturasSeleccionados).orderBy("proveedor.nombre,id").findList();
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Proveedor");
			fila.createCell(1).setCellValue("Cuit");
			fila.createCell(2).setCellValue("OP");
			fila.createCell(3).setCellValue("Expediente");
			fila.createCell(4).setCellValue("Periodo");
			fila.createCell(5).setCellValue("N° Factura");
			fila.createCell(6).setCellValue("Monto Base");
			fila.createCell(7).setCellValue("Impuestos");
			fila.createCell(8).setCellValue("Monto Neto");
		
			
			int f = 1; 
			for (Factura factura : facturas) {
					fila = hoja.createRow(f);
					for(int c=0;c<9;c++){
						Cell celda = fila.createCell(c);
						
						switch (c) {
						case 0:
							celda.setCellValue(factura.proveedor.nombre);
							break;
						case 1:
							celda.setCellValue(factura.proveedor.cuit);
							break;	
						case 2:
							celda.setCellValue((factura.ordenPago != null)?factura.ordenPago.getNombreCompleto():"");
							break;	
						case 3:
							celda.setCellValue((factura.expediente != null)?factura.expediente.getExpedienteEjercicio():"");
							break;	
						case 4:
							celda.setCellValue((factura.periodo != null)?factura.periodo.nombre:"");
							break;	
						case 5:
							celda.setCellValue(factura.numero_factura);
							break;	
						case 6:
							celda.setCellValue(factura.getBase().doubleValue());
							break;		
						case 7:
							celda.setCellValue(factura.getTotalImpuesto().doubleValue());
							break;	
						case 8:
							celda.setCellValue(factura.getTotal().doubleValue());
							break;	
						default:
							break;
						}
					}	
					f++;
			}
			
			libro.write(archivoTmp);   
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			 
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalReporteControlFacturas.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
	}
	
	public static Result reporteControlFacturasAFIP(){
		
		List<Integer> facturasSeleccionados =  new ArrayList<Integer>();
	 
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		try {
			File archivo = new File(dirTemp+"/controlFacturasAFIP.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Lotes");
			
			
			String sql = "select * from informe_estadistico_deuda_proveedores i " + 
					"inner join expedientes e on e.id= i.expediente_id " + 
					"where proveedor_id = 1430 and e.ejercicio_id = 3";
			
			List<SqlRow> l = Ebean.createSqlQuery(sql).findList();
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("EXPEDIENTE");
			fila.createCell(1).setCellValue("PRODUCTO");
			
			int f = 1; 
			for(SqlRow z :l) {
			
				//List<RemitoLinea> sqlrm = RemitoLinea.find.where().eq("lineaOrden.orden_id", z.getInteger("orden_id")).findList();
				
				String sqlrm = "select exp.nombre||'/'||ej.nombre as expediente,p.nombre as producto from remitos_lineas rl " + 
						"inner join orden_lineas ol on rl.linea_orden_id = ol.id " + 
						"inner join productos p on p.id = ol.producto_id " + 
						"inner join ordenes o on o.id = ol.orden_id " + 
						"inner join expedientes exp on exp.id = o.expediente_id " + 
						"inner join ejercicios ej on ej.id = exp.ejercicio_id " + 
						"where o.id = :ordenId " + 
						"group by exp.nombre||'/'||ej.nombre,p.nombre " + 
						"order by exp.nombre||'/'||ej.nombre,p.nombre";
				
				List<SqlRow> sqlrmx = Ebean.createSqlQuery(sqlrm).setParameter("ordenId", z.getInteger("orden_id")).findList();
				
				for(SqlRow rl :sqlrmx) {
					fila = hoja.createRow(f);
					
					for(int c=0;c<3;c++){
						Cell celda = fila.createCell(c);
						
						switch (c) {
						case 0:
							celda.setCellValue(rl.getString("expediente"));
							break;
						case 1:
							celda.setCellValue(rl.getString("producto"));
							break;	
						default:
							break;	
						}
					}
					
					f++;
				}
				f++;
			}
			
			
			/*
			for(SqlRow z :l) {
				facturasSeleccionados.add(z.getInteger("orden_id")); 
			}
			
			List<Factura> facturas = Factura.find.where().in("orden_id", facturasSeleccionados).eq("proveedor_id",1430).orderBy("orden_id").findList();
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Proveedor");
			fila.createCell(1).setCellValue("Estado");
			fila.createCell(2).setCellValue("OP");
			fila.createCell(3).setCellValue("Expediente");
			fila.createCell(4).setCellValue("Periodo");
			fila.createCell(5).shttps://www.google.com/search?client=ubuntu&channel=fs&q=g%7D&ie=utf-8&oe=utf-8etCellValue("N° Factura");
			fila.createCell(6).setCellValue("Monto Base");
			fila.createCell(7).setCellValue("Impuestos");
			
			fila.createCell(8).setCellValue("SUSS 1% Res AFIP 2069/06, MOF 1784/04");
			fila.createCell(9).setCellValue("RET. MUNICIP. DERECHO INSPECCION. 0.7% RES. DGR 008/15");
			fila.createCell(10).setCellValue("SUSS 2% Res. AFIP 1784/04");
			fila.createCell(11).setCellValue("RET. D.G.R. - SELLOS 1 % - R.G. 13/97");
			fila.createCell(12).setCellValue("RET.AFIP-DGI- GCIAS. 2% RES.AFIP 3884/16");
			fila.createCell(13).setCellValue("RET. AFIP - DGI - GCIAS. 2% RES. AFIP 830 / 00");
			
			
			
			
			fila.createCell(14).setCellValue("Monto Neto");
			fila.createCell(15).setCellValue("Monto PAGADO");
			fila.createCell(16).setCellValue("Monto DEUDA");
			fila.createCell(17).setCellValue("ID");
			fila.createCell(18).setCellValue("ID P");
		
		 
			int f = 1; 
			BigDecimal tp= new BigDecimal(0);
			for (Factura factura : facturas) {
					fila = hoja.createRow(f);
					
					Map<Long,BigDecimal> lss = new HashMap<Long,BigDecimal>();
					
					List<FacturaLineaImpuesto> flx = FacturaLineaImpuesto.find.where().eq("factura_id",factura.id).findList();
					for (FacturaLineaImpuesto flxx : flx) {
						lss.put(flxx.cuenta_id, flxx.monto);
					}
					
					
					for(int c=0;c<19;c++){
						Cell celda = fila.createCell(c);
						 
						
						
						if(c ==9) {
							tp = new BigDecimal(0);
							List<Pago> lp = Pago.find.where().eq("factura_id", factura.id).disjunction().eq("estado_id", Estado.PAGO_ESTADO_CONCILIADO).eq("estado_id", Estado.PAGO_ESTADO_PAGADO).endJunction().findList();
							for(Pago px:lp) {
								tp = tp.add(px.total).add(px.total_credito);
							}
						}
						
						switch (c) {
						case 0:
							celda.setCellValue(factura.proveedor.nombre);
							break;
						case 1:
							celda.setCellValue(factura.estado.nombre);
							break;	
						case 2:
							celda.setCellValue((factura.ordenPago != null)?factura.ordenPago.getNombreCompleto():"");
							break;	
						case 3:
							celda.setCellValue((factura.expediente != null)?factura.expediente.getExpedienteEjercicio():"");
							break;	
						case 4:
							celda.setCellValue((factura.periodo != null)?factura.periodo.nombre:"");
							break;	
						case 5:
							celda.setCellValue(factura.numero_factura);
							break;	
						case 6:
							celda.setCellValue(factura.getBase().doubleValue());
							break;		
						case 7:
							celda.setCellValue(factura.getTotalImpuesto().doubleValue());
							break;
							
						 
						case 8:
							if(lss.get(new Long(277)) != null) {
								celda.setCellValue(lss.get(new Long(277)).doubleValue());
							}else {
								celda.setCellValue(0);
							}
							break;	
						case 9:
							if(lss.get(new Long(283)) != null) {
								celda.setCellValue(lss.get(new Long(283)).doubleValue());
							}else {
								celda.setCellValue(0);
							}
							break;
						case 10:
							if(lss.get(new Long(259)) != null) {
								celda.setCellValue(lss.get(new Long(259)).doubleValue());
							}else {
								celda.setCellValue(0);
							}
							break;	
						case 11:
							if(lss.get(new Long(263)) != null) {
								celda.setCellValue(lss.get(new Long(263)).doubleValue());
							}else {
								celda.setCellValue(0);
							}
							break;	
						case 12:
							if(lss.get(new Long(281)) != null) {
								celda.setCellValue(lss.get(new Long(281)).doubleValue());
							}else {
								celda.setCellValue(0);
							}
							break;
						case 13:
							if(lss.get(new Long(108)) != null) {
								celda.setCellValue(lss.get(new Long(108)).doubleValue());
							}else {
								celda.setCellValue(0);
							}
							break;	
						 
							
						case 14:
							celda.setCellValue(factura.getTotal().doubleValue());
							break;	
						case 15:
							celda.setCellValue(tp.doubleValue());
							break;	
						case 16:
							celda.setCellValue(factura.getBase().subtract(tp).doubleValue());
							break;		
						case 17:
							celda.setCellValue(factura.id);
							break;	
						case 18:
							if(factura.factura_principal_id != null) {
								celda.setCellValue( factura.factura_principal_id);
							}else {
								
							}
							
							break;		
						default:
							break;
						}
					}	
					f++;
			}
			*/
			
			
			libro.write(archivoTmp);   
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			 
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalReporteControlFacturas.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
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
	
	public static Result modalInformeSellos() {
		DynamicForm d = form().bindFromRequest();	
		
		return ok(modalInformeSellos.render(null,d));
	}
	
	public static Result informeSellos() {
		DynamicForm d = form().bindFromRequest();	
		Date ffh;
		Date ffd;
		
		String[] fecha_desde = request().body().asFormUrlEncoded().get("fecha_desde");
		String[] fecha_hasta = request().body().asFormUrlEncoded().get("fecha_hasta");
		String[] cuenta_id = request().body().asFormUrlEncoded().get("cuenta_id");
		String[] periodo_id = request().body().asFormUrlEncoded().get("periodo_id");
		
		boolean errorFecha = false; 
		if(fecha_desde == null || fecha_desde[0].isEmpty()){
			//flash("error", "Debe ingresar una fecha inicio.");
			//return ok(modalInformeSellos.render(null,d));
			errorFecha = true;
		}else{
			
		}
		
		if(fecha_hasta == null || fecha_hasta[0].isEmpty()){
			//flash("error", "Debe ingresar una fecha fin.");
			//return ok(modalInformeSellos.render(null,d));
			errorFecha = true;
		}else{
			
		}
		
		
		if(errorFecha && ( periodo_id == null || periodo_id[0].isEmpty())){
			flash("error", "Debe ingresar una fecha de OPG o un periodo.");
			return ok(modalInformeSellos.render(null,d));
		}
		
		
		
		if(cuenta_id == null || cuenta_id[0].isEmpty()){
			flash("error", "Debe ingresar una cuenta.");
			return ok(modalInformeSellos.render(null,d));
		}
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		try {
			File archivo = new File(dirTemp+"/informe_impuestos.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Lotes");
			
			
			ExpressionList<Factura> e = Factura.find.where();
			
			if(!fecha_desde[0].isEmpty()){
	    		e.ge("fecha_orden_pago", DateUtils.formatDate(fecha_desde[0], "dd/MM/yyyy"));
	    	}
			
			if(!fecha_hasta[0].isEmpty()){
	    		e.le("fecha_orden_pago", DateUtils.formatDate(fecha_hasta[0], "dd/MM/yyyy"));
	    	}
			if(!periodo_id[0].isEmpty()){
				e.eq("periodo_id",new Long(periodo_id[0]));
			}	
			
			
			
			List<Factura> facturas = e.findList();
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Fecha OPG");
			fila.createCell(1).setCellValue("N° Comprobante");
			fila.createCell(2).setCellValue("Proveedor");
			fila.createCell(3).setCellValue("Cuit");
			fila.createCell(4).setCellValue("N° Factura");
			fila.createCell(5).setCellValue("OP");
			fila.createCell(6).setCellValue("Expediente");
			fila.createCell(7).setCellValue("Tipo Cuenta");
			fila.createCell(8).setCellValue("Importe");
			fila.createCell(9).setCellValue("Base Calculo");
			fila.createCell(10).setCellValue("Importe Rentencion");
			
			int f = 1; 
			for (Factura factura : facturas) {
				if(factura.facturaLineaImpuesto != null && factura.facturaLineaImpuesto.size() > 0){
					for(FacturaLineaImpuesto fl :factura.facturaLineaImpuesto){
						if(fl.cuenta_id.equals(new Long(cuenta_id[0]))){
							fila = hoja.createRow(f);
							for(int c=0;c<11;c++){
								Cell celda = fila.createCell(c);
								
								switch (c) {
									case 0:
										celda.setCellValue(DateUtils.formatDate(factura.ordenPago.fecha));
										break;
									case 1:
										celda.setCellValue(fl.nombre);
										break;	
									case 2:
										celda.setCellValue(factura.proveedor.nombre);
										break;		
									case 3:
										celda.setCellValue(factura.proveedor.cuit);
										break;		
									case 4:
										celda.setCellValue(factura.numero_factura);
										break;
									case 5:
										celda.setCellValue(factura.ordenPago.numero);
										break;	
									case 6:
										celda.setCellValue(factura.expediente.nombre);
										break;
									case 7:
										String tc ="";
										
										if(factura.tipo_cuenta_id != null) {
											tc =factura.tipoCuenta.nombre;
										}else {
											tc = factura.profe?"PROFE":"OPER";
										}
										
										celda.setCellValue(tc);
										break;		
									case 8:
										celda.setCellValue((Math.round(factura.getBase().setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()*100.0)/100.0));
										break;	
									case 9:
										celda.setCellValue((Math.round(RetencionesUtils.getBaseByRentecion(fl.monto, fl.cuenta_id.intValue()).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()*100.0)/100.0));
										break;
									case 10:
										celda.setCellValue((Math.round(fl.monto.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()*100.0)/100.0));
										break;	
									default:
										break;
								}
							}	
							f++;
						}
					}
				}
			}
			
			libro.write(archivoTmp);   
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			 
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalInformeSellos.render(archivo.getPath(),d));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
	}
	
}
