package controllers.patrimonio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controllers.Secured;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import models.CertificacionCompra;
import models.CertificacionServicio;
import models.CertificacionServicioLinea;
import models.CertificacionServicioLineaCliente;
import models.OrdenLinea;
import models.OrdenLineaCliente;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.UriTrack;
import views.html.compras.certificaciones.modales.modalReporteCertificacion;

@Security.Authenticated(Secured.class)
public class CertificacionesReportesController extends Controller {

	public static Result reporteCertificacion(Long id) throws IOException {
		
		

		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/certificacion.odt");
		
		try {
			   CertificacionServicio c = CertificacionServicio.find.byId(id);
		     
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/patrimonio/certificaciones/certificacion.odt");	
			  if(!c.ordenProvision.ordenCompra.deposito.parque) {
				   in = Play.application().resourceAsStream("resources/reportes/patrimonio/certificaciones/certificacion-sinlogo.odt");	
			  } 
			 
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		       

		      if(c.fecha_certificacion == null) {
		    	  flash("error", "Debe Ingresar una fecha de certificacion");
		    	  return redirect(controllers.patrimonio.routes.CertificacionesServiciosController.ver(id));
		      }
		      
		      context.put("proveedor",c.ordenProvision.ordenCompra.proveedor.nombre);
		      context.put("institucion",c.ordenProvision.ordenCompra.deposito.nombre);
		      context.put("expediente",c.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio());
		      context.put("numeroOp", c.ordenProvision.getOpEjercicio());
		      context.put("mes", DateUtils.getMesLetras(c.fecha_certificacion.getMonth()));
		      
		      context.put("lineas",c.certificacionesServicioLinea);
		      
		      
		      
		       
		      SimpleDateFormat format1 = new SimpleDateFormat("M");
		      
			  String mes = format1.format(c.fecha_certificacion);
			  context.put("mesOp",  DateUtils.getMesLetras(c.periodo.date_start.getMonth()));
			  

		      SimpleDateFormat format2 = new SimpleDateFormat("d");
			  String dia = format2.format(c.fecha_certificacion);
			  context.put("dia", dia);
		      
		      SimpleDateFormat format3 = new SimpleDateFormat("yyyy");
			  String anio = format3.format(c.fecha_certificacion);
			  context.put("anio", anio);
			  
			  Integer x= 1;
			  List<Map<String,String>> pacientes = new ArrayList<Map<String,String>>();
			  for(CertificacionServicioLinea lo : c.certificacionesServicioLinea ){
					
				for(CertificacionServicioLineaCliente oc :lo.certificacionServicioLineaCliente){
					Map<String,String> hs = new HashMap<String,String>();
					//Logger.debug("aaaaaaaaaa"+oc.cliente.nombre);
					hs.put("nLinea",x.toString());
					hs.put("cantidad",oc.cantidad.toString());
					hs.put("nombre",oc.cliente.nombre);
					String refe = (oc.cliente.id_paciente_rismi == null)?(oc.cliente.referencia == null)?"":oc.cliente.referencia:oc.cliente.id_paciente_rismi;
					hs.put("referencia",refe);
					hs.put("producto",lo.producto.nombre);
					pacientes.add(hs);
				}
				x++;
			  }
							 
				context.put("pacientes", pacientes);
			  
			  
			  
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

			  return ok(archivo);
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			
		 	flash("Error", "No se puedo crear el archivo.");
		 	return redirect(controllers.patrimonio.routes.CertificacionesServiciosController.ver(id));
	}
	
	
	private static List<Integer> getSeleccionados(){
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
