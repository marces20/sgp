package controllers.haberes;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Agente;
import models.Certificacion;
import models.EnvioMail;
import models.Factura;
import models.SolicitudLineaAjuste;
import models.Usuario;
import models.haberes.LiquidacionEnvioMail;
import models.haberes.LiquidacionMes;
import models.haberes.LiquidacionPuesto;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.MathTool;

import com.avaje.ebean.Expr;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import fr.opensagres.xdocreport.converter.Options;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DateUtils;
import utils.NumberUtils;
import utils.RequestVar;
import views.html.haberes.liquidacionPuestos.reportes.*;
import views.html.compras.ordenes.modales.modalEditarRubro;
import views.html.contabilidad.facturas.acciones.modalCargarOrdenPago;
import views.html.haberes.liquidacionPuestos.modales.*;

public class LiquidacionPuestosReportesController  extends Controller {
	
	public static Result modalReciboSueldoPorPuestoMail(Long liquidacionPuestoId) {
		
		LiquidacionPuesto lp = LiquidacionPuesto.find.byId(liquidacionPuestoId);
		
		Map<String,String> b = new HashMap<String, String>();
		b.put("email",lp.puestoLaboral.legajo.agente.email);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		String ff = format1.format(lp.puestoLaboral.legajo.agente.write_email_date);
		b.put("write_email_date",ff );
		b.put("lpid",lp.id.toString());
		b.put("agente_id",lp.puestoLaboral.legajo.agente.id.toString());
		DynamicForm d = form().bindFromRequest().bind(b);
		
		
		
		return ok(modalReciboSueldoPorPuestoMail.render(d));
	}
	
	public static Result enviarReciboPorMail() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		String email = null;
		if(!request().body().asFormUrlEncoded().get("email")[0].isEmpty()){
			email =  request().body().asFormUrlEncoded().get("email")[0];
		}		
		
		if(email == null ){
			flash("error", "Debe escribir un mail");
			return ok(modalReciboSueldoPorPuestoMail.render(d));
		}
		
		Long agenteId = null;
		if(!request().body().asFormUrlEncoded().get("agente_id")[0].isEmpty()){
			agenteId = new Long(request().body().asFormUrlEncoded().get("agente_id")[0]);
		}
		
		if(agenteId == null ){
			flash("error", "No se encuentra el agente");
			return ok(modalReciboSueldoPorPuestoMail.render(d));
		}
		
		Long lpid = null;
		if(!request().body().asFormUrlEncoded().get("lpid")[0].isEmpty()){
			lpid =  new Long(request().body().asFormUrlEncoded().get("lpid")[0]);
		}
		
		if(lpid == null ){
			flash("error", "No se encuentra la liquidacion");
			return ok(modalReciboSueldoPorPuestoMail.render(d));
		}
			
		
		if(d.hasErrors())
			return ok(modalReciboSueldoPorPuestoMail.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			
			LiquidacionPuesto.enviarMailReciboByLiquidacionPuestoId(email,lpid,"LIQUIDACION_PUESTO");
			
			result.put("success", true);
			flash("success", "Se envio el mail");
			result.put("html", modalReciboSueldoPorPuestoMail.render(d).toString());
			return ok(result);
		} catch (Exception e){
			Logger.debug("No se puede enviar el mail "+e.getMessage());
			flash("error", "No se puede enviar el mail ");
			return ok(modalReciboSueldoPorPuestoMail.render(d));
		}
		
	}
	
	
	@CheckPermiso(key = "liquidacionMesReciboSueldo")
	public static Result reciboSueldo() {
		List<Integer> liquidacionesSeleccionadas = getSeleccionados();
		
		if(liquidacionesSeleccionadas.size() <= 0){
			flash("error", "Debe seleccionar una liquidacion.");
		 	return ok(modalReporteReciboSueldo.render(null));
		}
		
		List<LiquidacionPuesto> lp = LiquidacionPuesto.find
														.fetch("puestoLaboral")
														.fetch("puestoLaboral.legajo")
														.fetch("puestoLaboral.legajo.agente")
														.fetch("liquidacionMes.periodo")
														.where().in("id", liquidacionesSeleccionadas).findList();
		
		/*liquidacionesSeleccionadas.add(9480);
		liquidacionesSeleccionadas.add(12756);
		List<LiquidacionPuesto> lp = LiquidacionPuesto.find.where().in("id", liquidacionesSeleccionadas).findList();*/
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivoPdf = new File(dirTemp+"/reporteReciboSueldo.pdf");
		
		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/reporteReciboSueldoConvenio.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("liquidaciones", lp);
			context.put("date",  new DateUtils());
			
			OutputStream out = new FileOutputStream(archivoPdf);
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			report.convert(context, options, out);
			
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte.");
			return ok(modalReporteReciboSueldo.render(null));
		}
		
		return ok(modalReporteReciboSueldo.render(archivoPdf.getPath()));
	}	
	
	
	public static Result reciboSueldoPorPuesto(Long liquidacionPuestoId) {
		
		
		LiquidacionPuesto lp = LiquidacionPuesto.find
												.fetch("puestoLaboral")
												.fetch("puestoLaboral.legajo")
												.fetch("puestoLaboral.legajo.agente")
												.fetch("liquidacionMes.periodo")
												.where().eq("id", liquidacionPuestoId).findUnique();
		
		if(lp != null){
			List<LiquidacionPuesto> llp = new ArrayList<LiquidacionPuesto>();
			llp.add(lp);
			
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivoPdf = new File(dirTemp+"/reporteReciboSueldo-"+lp.id+".pdf");
			
			try {
	        	InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/reporteReciboSueldoConvenio.odt");
				//InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/reporteReciboSueldoConImagenes.odt");
				IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
				
				FieldsMetadata metadata = report.createFieldsMetadata();
				metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
				IContext context = report.createContext();
				
				context.put("liquidaciones", llp);
				context.put("date",  new DateUtils());
				
				OutputStream out = new FileOutputStream(archivoPdf);
				Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
				report.convert(context, options, out);
				
			} catch (Exception e) {
				e.printStackTrace();
				flash("error", "No se pudo generar el reporte.");
				return ok(modalReporteReciboSueldo.render(null));
			}
			
			int count = lp.impresiones+1;
			
			lp.impresiones = count;
			lp.save();
			
			return ok(modalReporteReciboSueldo.render(archivoPdf.getPath()));
		}
		
		flash("error", "No se pudo generar el reporte no se encuentra la liquidacion puesto.");
		return ok(modalReporteReciboSueldo.render(null));
		
	}
	
	@CheckPermiso(key = "liquidacionMesReciboSueldo")
	public static Result reciboSueldosByLiquidacionMes(Long liquidacionMesId) {
		
		List<LiquidacionPuesto> lp = LiquidacionPuesto.find
				.fetch("puestoLaboral")
				.fetch("puestoLaboral.legajo")
				.fetch("puestoLaboral.legajo.agente")
				.fetch("liquidacionMes.periodo")
				.where()
				.eq("liquidacion_mes_id", liquidacionMesId)
				//.eq("puestoLaboral.id", 238)
				.orderBy("puestoLaboral.legajo.agente.apellido asc")
				.findList();
		
		//List<LiquidacionPuesto> lp = LiquidacionPuesto.find.where().in("id", 730).findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivoPdf = new File(dirTemp+"/reporteReciboSueldo.pdf");
		
		
		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/reporteReciboSueldoConvenio.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("liquidaciones", lp);
			context.put("date",  new DateUtils());
			
			OutputStream out = new FileOutputStream(archivoPdf);
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			report.convert(context, options, out);
			
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte.");
			return ok(modalReporteReciboSueldo.render(null));
		}
		return ok(archivoPdf);
	}
	
	public static Result libroSueldos(Long liquidacionMesId) {
		
		LiquidacionMes liquidacion = LiquidacionMes.find.byId(liquidacionMesId);
		
		List<LiquidacionPuesto> lp = LiquidacionPuesto.find.where().eq("liquidacion_mes_id", liquidacionMesId).orderBy("puestoLaboral.legajo.agente.apellido asc").findList();
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivoPdf = new File(dirTemp+"/reporteLibroSueldo.pdf");
		Certificacion c = new Certificacion();
		
		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/liquidaciones/reporteLibroSueldo.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("liquidacion", liquidacion);
			context.put("liquidaciones", lp);
			context.put("date",  new DateUtils());
			context.put("number",  new NumberUtils());
			
			OutputStream out = new FileOutputStream(archivoPdf);
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			report.convert(context, options, out);
			
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte.");
			return ok(modalReporteReciboSueldo.render(null));
		}
		return ok(archivoPdf);
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
