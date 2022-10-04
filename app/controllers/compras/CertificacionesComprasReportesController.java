package controllers.compras;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import models.Certificacion;
import models.CertificacionCompra;

import controllers.Secured;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import views.html.compras.certificaciones.modales.modalReporteCertificacion;

@Security.Authenticated(Secured.class)
public class CertificacionesComprasReportesController extends Controller {
	
	public static Result reporteCertificacion() throws IOException {
		
		List<Integer> certificacionesSeleccionadas = getSeleccionados();
		
		if(certificacionesSeleccionadas.size() <= 0){
			flash("error", "Debe seleccionar una certificacion.");
		 	return ok(modalReporteCertificacion.render(null));
		}
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/certificacion.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/certificacionesCompras/certificacion.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      CertificacionCompra c = CertificacionCompra.find.byId(certificacionesSeleccionadas.get(0).longValue());
		      
		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Nombre");
		      metadata.addFieldAsList("listado.Dni");
		      metadata.addFieldAsList("listado.Porcentaje");
		       
		      report.setFieldsMetadata(metadata);
		      
		      context.put("expediente",c.expediente.getExpedienteEjercicio());
		      context.put("ultimodia", DateUtils.getLastDayOfMonth(c.periodo.date_start));
		      context.put("mes", DateUtils.getMesLetras(c.periodo.date_start.getMonth()));
		       
		      SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
			  String anio = format1.format(c.periodo.date_start);
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
	
	private static List<Map<String,String>> getMetadataReporteCertificacion(List<Integer> idsCertificaciones){
		List<Map<String,String>> listado = new ArrayList<Map<String,String>>();
		
		String sql = " SELECT c.id id,p.nombre nombre,p.cuit dni,sum(l.descuento) descuento "  
				   + " FROM certificaciones_compras c"   
				   + " INNER JOIN proveedores p ON p.id = c.proveedor_id "
				   + " INNER JOIN certificaciones_compras_lineas l ON c.id = l.certificacion_compra_id "
				   + " WHERE c.id IN(:idsCertificaciones)"
				   + " group by c.id,p.nombre,p.cuit,l.certificacion_compra_id order by nombre ";  
		
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
