package controllers.recupero;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import controllers.Secured;

import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import models.recupero.Presupuesto;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import views.html.contabilidad.facturas.reportes.reporteRendicionSellos;

@Security.Authenticated(Secured.class)
public class PresupuestosReportesController extends Controller  {
	
	public static Result presupuesto(Long id,Boolean extrajero) {
		Presupuesto p = Presupuesto.find.byId(id);
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/presupuesto"+id+".odt");
		
		try {
			InputStream in = Play.application().resourceAsStream("resources/reportes/recupero/presupuesto/presupuesto.odt");
			if(extrajero){
				in = Play.application().resourceAsStream("resources/reportes/recupero/presupuesto/presupuesto_extrajeros.odt");
			}  
			
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();

			context.put("lineas", p.presupuestoLinea);
			context.put("date", new DateUtils());
			context.put("letra", new NumeroALetra());
			context.put("utils", new NumberUtils());
			
			context.put("numero", p.nombre);
			context.put("nombre", p.cliente.nombre);
			context.put("documento", (p.cliente.dni != null)?p.cliente.dni:"");
			context.put("idPaciente", (p.cliente.id_paciente_rismi != null)?p.cliente.id_paciente_rismi:"");
			context.put("cie", (p.cliente.cie != null)?p.cliente.cie:"");
			context.put("sexo", (p.cliente.sexo != null)?p.cliente.sexo:"");
			context.put("edad", (p.cliente.getEdad() > 0)?p.cliente.getEdad():"");
			context.put("nota", (p.nota != null)?p.nota:"");
			context.put("fecha", (p.fecha != null)?utils.DateUtils.formatDate(p.fecha):"");
			
			context.put("obrasocial", (p.cliente != null && p.cliente.obrasocial != null)?p.cliente.obrasocial.nombre:"");
			context.put("nafiliado", (p.cliente != null && p.cliente.nafiliado != null)?p.cliente.nafiliado:"");
			
			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
            
			return ok(archivo);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ok();
	}
}
