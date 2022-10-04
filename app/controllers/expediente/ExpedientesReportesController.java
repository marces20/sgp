package controllers.expediente;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Estado;
import models.Expediente;
import models.ExpedienteMovimiento;
import models.Usuario;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import views.html.contabilidad.facturas.reportes.modalReporteControlFacturas;
import views.html.expediente.expediente.acciones.modalPasarOtroServicio;
import views.html.expediente.expediente.reportes.*;

@Security.Authenticated(Secured.class)
public class ExpedientesReportesController extends Controller  {
	
	
	@CheckPermiso(key = "reporteMovimientos")
	public static Result reporteMovimiento () {
		
		String sql = "select o.id,  o.nombre, r07.total r07, r0714.total r0714, r1421.total r1421, r2128.total r2128, r28.total r28 from organigramas o " + 
						" left join ( " + 
				" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', fecha_salida - fecha_llegada) < 7 AND  fecha_salida is not null and cancelado = false group by organigrama_id " +  
				" ) as r07 on r07.organigrama_id = o.id " + 
				" left join ( " + 
				" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', fecha_salida - fecha_llegada) between 7 and 14 AND  fecha_salida is not null and cancelado = false group by organigrama_id " +  
				" ) as r0714 on r0714.organigrama_id = o.id " + 
				" left join ( " + 
				" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', fecha_salida - fecha_llegada) between 14 and 21 AND  fecha_salida is not null and cancelado = false group by organigrama_id " +  
				" ) as r1421 on r1421.organigrama_id = o.id  " + 
				" left join ( " + 
				" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', fecha_salida - fecha_llegada) between 21 and 28 AND  fecha_salida is not null and cancelado = false group by organigrama_id " +  
				" ) as r2128 on r2128.organigrama_id = o.id " + 
				" left join ( " + 
				" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', fecha_salida - fecha_llegada) > 28 AND  fecha_salida is not null and cancelado = false group by organigrama_id " +  
				" ) as r28 on r28.organigrama_id = o.id " + 
				" where r07 is not null or r0714 is not null or r1421 is not null or r2128  is not null or  r28 is not null";
		
		List<SqlRow> m = Ebean.createSqlQuery(sql).findList();
		
		
		String sqlAbierto = "select o.id,  o.nombre, r07.total r07, r0714.total r0714, r1421.total r1421, r2128.total r2128, r28.total r28 from organigramas o " + 
				" left join ( " + 
		" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', now() - fecha_llegada) < 7 AND  fecha_salida is null and cancelado = false group by organigrama_id " +  
		" ) as r07 on r07.organigrama_id = o.id " + 
		" left join ( " + 
		" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', now() - fecha_llegada) between 7 and 14 AND  fecha_salida is null and cancelado = false group by organigrama_id " +  
		" ) as r0714 on r0714.organigrama_id = o.id " + 
		" left join ( " + 
		" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', now() - fecha_llegada) between 14 and 21 AND  fecha_salida is null and cancelado = false group by organigrama_id " +  
		" ) as r1421 on r1421.organigrama_id = o.id  " + 
		" left join ( " + 
		" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', now() - fecha_llegada) between 21 and 28 AND  fecha_salida is null and cancelado = false group by organigrama_id " +  
		" ) as r2128 on r2128.organigrama_id = o.id " + 
		" left join ( " + 
		" SELECT organigrama_id, count(*) total FROM expedientes_movimientos em inner join expedientes e on e.id = em.expediente_id where e.ejercicio_id > 4 AND DATE_PART('day', now() - fecha_llegada) > 28 AND  fecha_salida is null and cancelado = false group by organigrama_id " +  
		" ) as r28 on r28.organigrama_id = o.id " + 
		" where r07 is not null or r0714 is not null or r1421 is not null or r2128  is not null or  r28 is not null";

		List<SqlRow> a = Ebean.createSqlQuery(sqlAbierto).findList();
		
		
		return ok(reporteMovimiento.render(m, a));
	}
	
	public static Result reportePaseExpediente(Long id){
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/paseExpediente.odt");
		List<String> listaErrores = new ArrayList<String>(); 
		File archivoPdf = new File(dirTemp+"/paseExpediente-"+Usuario.getUsuarioSesion()+".pdf");
		
		try {	
			
			InputStream in = Play.application().resourceAsStream("resources/reportes/expedientes/paseExpediente.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			IContext context = report.createContext();
			
			
			ExpedienteMovimiento um = ExpedienteMovimiento.getLastMovimiento(id);
			ExpedienteMovimiento ma = ExpedienteMovimiento.getMovimientoAnterior(um);
			
			if(ma == null || ma.usuario_id.compareTo(Usuario.getUsurioSesion().id.longValue()) != 0){
				flash("error", "El ultimo pase no ha sido realizado por este usuario");
				return ok(modalReportePaseExpediente.render(null));
			}
			
			List<ExpedienteMovimiento> x = new ArrayList<ExpedienteMovimiento>();
			x.add(um);
			
			context.put("um",x);
			context.put("util",new DateUtils());
			context.put("user",Usuario.getUsurioSesion());
			context.put("ExpedienteMovimiento",new ExpedienteMovimiento());
			//OutputStream out = new FileOutputStream(archivo);
			//report.process(context, out);
			
	        OutputStream out = new FileOutputStream(archivoPdf);
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			report.convert(context, options, out);
	        
	        flash("success", "El archivo fue creado correctamente.");
			return ok(modalReportePaseExpediente.render(archivoPdf.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return ok();
	}	
	
	public static Result reportePaseExpedienteListaCodigoCombinado(){
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/paseExpediente.odt");
		List<String> listaErrores = new ArrayList<String>(); 
		
		
		try {	
			File archivoPdf = new File(dirTemp+"/paseExpediente-"+Usuario.getUsuarioSesion()+".pdf");
			InputStream in = Play.application().resourceAsStream("resources/reportes/expedientes/paseExpediente.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			IContext context = report.createContext();
			
			List<Integer> pasesSeleccionados = getSeleccionados();
			
			List<ExpedienteMovimiento> x = ExpedienteMovimiento.find.where().in("codigo",pasesSeleccionados).ne("cancelado", true).findList();
			
			if(x.size() > 0){
				Long orTmp = x.get(0).organigrama_id;
				
				for(ExpedienteMovimiento ex : x){
					
					if(orTmp.compareTo(ex.organigrama_id) != 0){
						flash("error", "Los pases tiene distinto servicio de destino. Deben tener todos el mismo servicio de destino");
						return ok(modalReportePaseExpediente.render(null));
					}			
				}
			}
			context.put("um",x);
			context.put("util",new DateUtils());
			context.put("user",Usuario.getUsurioSesion());
			context.put("ExpedienteMovimiento",new ExpedienteMovimiento());
			
	        OutputStream out = new FileOutputStream(archivoPdf);
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			report.convert(context, options, out);
	        
	        flash("success", "El archivo fue creado correctamente.");
			return ok(modalReportePaseExpediente.render(archivoPdf.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return ok();
	}
	
	public static Result reportePaseExpedienteListaCodigo(Integer codigo){
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/paseExpediente.odt");
		List<String> listaErrores = new ArrayList<String>(); 
		
		
		try {	
			File archivoPdf = new File(dirTemp+"/paseExpediente-"+Usuario.getUsuarioSesion()+".pdf");
			InputStream in = Play.application().resourceAsStream("resources/reportes/expedientes/paseExpediente.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			IContext context = report.createContext();
			
			List<ExpedienteMovimiento> x = ExpedienteMovimiento.find.where().eq("codigo",codigo).ne("cancelado", true).findList();
			
			context.put("um",x);
			context.put("util",new DateUtils());
			context.put("user",Usuario.getUsurioSesion());
			context.put("ExpedienteMovimiento",new ExpedienteMovimiento());
			
	        OutputStream out = new FileOutputStream(archivoPdf);
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			report.convert(context, options, out);
	        
	        flash("success", "El archivo fue creado correctamente.");
			return ok(modalReportePaseExpediente.render(archivoPdf.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return ok();
	}
	
	public static Result reportePaseExpedienteLista(){
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/paseExpediente.odt");
		List<String> listaErrores = new ArrayList<String>(); 
		List<Integer> expedientesSeleccionados = getSeleccionados();
		
		if(expedientesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un expediente.");
			return ok(modalReportePaseExpediente.render(null));
		}	
		
		try {	
			File archivoPdf = new File(dirTemp+"/paseExpediente-"+Usuario.getUsuarioSesion()+".pdf");
			InputStream in = Play.application().resourceAsStream("resources/reportes/expedientes/paseExpediente.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			IContext context = report.createContext();
			
			List<ExpedienteMovimiento> x = new ArrayList<ExpedienteMovimiento>();
			boolean error = false;
			String errorString = "El ultimo pase de estos de estos expedientes no han sidos realizados por este usuarios:<br>";
			for(Integer z : expedientesSeleccionados){
				ExpedienteMovimiento um = ExpedienteMovimiento.getLastMovimiento(z.longValue());
				ExpedienteMovimiento ma = ExpedienteMovimiento.getMovimientoAnterior(um);
				x.add(um);
				
				if(ma == null || ma.usuario_id.compareTo(Usuario.getUsurioSesion().id.longValue()) != 0){
					error = true;
					Expediente e = Expediente.find.byId(z.longValue());
					errorString += e.getExpedienteEjercicio()+"<br>";
				}
			}
			
			if(error){
				flash("error", errorString);
				return ok(modalReportePaseExpediente.render(null));
			}
			
			
			context.put("um",x);
			context.put("util",new DateUtils());
			context.put("user",Usuario.getUsurioSesion());
			context.put("ExpedienteMovimiento",new ExpedienteMovimiento());
			//OutputStream out = new FileOutputStream(archivo);
			//report.process(context, out);
			
	        OutputStream out = new FileOutputStream(archivoPdf);
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			report.convert(context, options, out);
	        
	        flash("success", "El archivo fue creado correctamente.");
			return ok(modalReportePaseExpediente.render(archivoPdf.getPath()));
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
}
