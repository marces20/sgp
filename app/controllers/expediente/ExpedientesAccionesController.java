package controllers.expediente;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import models.Estado;
import models.Expediente;
import models.ExpedienteMovimiento;
import models.Factura;
import models.Organigrama;
import models.Usuario;
import models.auth.Permiso;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import views.html.expediente.expediente.acciones.*;
import views.html.expediente.expediente.reportes.modalReportePaseExpediente;

@Security.Authenticated(Secured.class)
public class ExpedientesAccionesController  extends Controller {
	
	
	public static Result modalAsignarMiServicio() {
		return ok(modalAsignarAMiServicio.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "expedientesAsignarMiServicio")
	public static Result asignarAMiServicioMasivo() {
		 
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		List<Integer> expedientesSeleccionados = getSeleccionados();
		
		if(expedientesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un expediente.");
			return ok(modalAsignarAMiServicio.render(d));
		}
		
		 if(!Permiso.check("expedientesAsignarMiServicioTotal")) {
			 List<Long> ret = ExpedienteMovimiento.getStringIsNotMovimientoServicioUsuario(expedientesSeleccionados, Organigrama.MINISTERIO_SALUD);
			 if(ret .size() > 0) {
				 flash("error", "Solo puede autoasignarse expedientes que esten en el servicio Ministerio de salud.");
				 return ok(modalAsignarAMiServicio.render(d));
			 }
		 }
		
		Long organigramaId = Usuario.getUsurioSesion().organigrama_id;
		if(organigramaId == null){
			flash("error", "El usuario no tiene asignado un servicio.");
			return ok(modalAsignarAMiServicio.render(d));
		}
		
		
		
		
		Integer count = 0;
		try {
			
			 count = ExpedienteMovimiento.pasarOtroServicioMasivo(expedientesSeleccionados, organigramaId, "Autoasignacion");
			
		} catch (PersistenceException pe) {
			flash("error", "No se puede asignar los expedientes.");
			return ok(modalAsignarAMiServicio.render(d));
		}
		
		flash("success", "Se asignaron "+count+" expedientes a su servicio.");
		return ok(modalAsignarAMiServicio.render(d));
	}
	
	public static Result modalPasarOtroServicioIndividual(Long id) {
		return ok(modalPasarOtroServicio.render(form().bindFromRequest(),id,null));
	}
	
	
	public static Result modalPasarOtroServicio() {
		return ok(modalPasarOtroServicio.render(form().bindFromRequest(),null,null));
	}
	
	@CheckPermiso(key = "expedientesPasarAOtroServicio")
	public static Result pasarOtroServicio() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> expedientesSeleccionados = getSeleccionados();
		
		Long idExpediente = null;
		
		if(request().body().asFormUrlEncoded().get("idExpediente") != null){
			String idExpedienteString =request().body().asFormUrlEncoded().get("idExpediente")[0];
			idExpediente =  new Long(idExpedienteString);
			expedientesSeleccionados.clear();
			expedientesSeleccionados.add(idExpediente.intValue());
		}
		
		
		if(expedientesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un expediente.");
			return ok(modalPasarOtroServicio.render(d,idExpediente,null));
		}
		
		List<Expediente> ef  = Expediente.find.where().in("id", expedientesSeleccionados).eq("residuo_pasivo", true).findList();
		if(ef.size() > 0){
			flash("error", "No se puede hacer pase de servicio de Expedientes RP.");
			return ok(modalPasarOtroServicio.render(d,idExpediente,null));
		}
		
		if(Usuario.getUsurioSesion().organigrama == null) {
			flash("error", "No tienes un servicio asignado a tu usuarios. Debes solicitar que se te asignen uno.");
			return ok(modalPasarOtroServicio.render(d,idExpediente,null));
		}
		
		String orgaId =request().body().asFormUrlEncoded().get("organigrama_id")[0];
		String descripcion = request().body().asFormUrlEncoded().get("descripcion")[0];
		
		if(orgaId.isEmpty()){
			d.reject("organigrama_id","Debe seleccionar un servicio.");
			return ok(modalPasarOtroServicio.render(d,idExpediente,null));
		}
		
		if(orgaId.compareTo(Usuario.getUsurioSesion().organigrama_id.toString()) == 0){
			d.reject("organigrama_id","No puede dar un pase a tu mismo servicio.");
			return ok(modalPasarOtroServicio.render(d,idExpediente,null));
		}
		
		List<Long> soloDeMiServicio = soloDeMiServicio(expedientesSeleccionados);
		
		//Logger.debug("++++++++++++++++ "+soloDeMiServicio.size());	
		
		if(soloDeMiServicio.size() > 0) {
			String error = "Solo se puede modificar realizar movimientos que se encuentren en mi servicio "+Usuario.getUsurioSesion().organigrama.nombre+" <br>";
			error += "Expedientes que no se encuentan en mi servicio:<br>";
			for(Long x :soloDeMiServicio){
				Expediente e = Expediente.find.byId(x);
				error += "- "+e.getExpedienteEjercicio()+"\n";
			}
			
			flash("error", error);
			return ok(modalPasarOtroServicio.render(d,idExpediente,null));
		}
		
		
		if(d.hasErrors())
			return ok(modalPasarOtroServicio.render(d,idExpediente,null));	
		
		ObjectNode result = Json.newObject();
		try {
			Long organigramaId =  new Long(orgaId);
			Integer count = ExpedienteMovimiento.pasarOtroServicioMasivo(expedientesSeleccionados, organigramaId, descripcion);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ expedientesSeleccionados.size() +" seleccionados.");
			
			
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/paseExpediente.odt");
			List<String> listaErrores = new ArrayList<String>(); 
			File archivoPdf = new File(dirTemp+"/paseExpediente-"+Usuario.getUsuarioSesion()+".pdf");
			try {	
				
				InputStream in = Play.application().resourceAsStream("resources/reportes/expedientes/paseExpediente.odt");
				IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
				IContext context = report.createContext();
				
				List<ExpedienteMovimiento> x = new ArrayList<ExpedienteMovimiento>();
				for(Integer z : expedientesSeleccionados){
					ExpedienteMovimiento um = ExpedienteMovimiento.getLastMovimiento(z.longValue());
					ExpedienteMovimiento ma = ExpedienteMovimiento.getMovimientoAnterior(um);
					x.add(um);
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
		        
		        
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			result.put("html", modalPasarOtroServicio.render(d,idExpediente,archivoPdf.getPath()).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarOtroServicio.render(d,idExpediente,null));
		}		
	}
	
	
	
	public static List<Long> soloDeMiServicio(List<Integer> expedientesSeleccionados) {
		
		List<Long> ret = ExpedienteMovimiento.getStringIsNotMovimientoServicioUsuario(expedientesSeleccionados, Usuario.getUsurioSesion().organigrama_id);
		
		return ret;
	}
	
	@CheckPermiso(key = "expedientesCancelarPase")
	public static Result cancelarPase(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			
			ExpedienteMovimiento um = ExpedienteMovimiento.getLastMovimiento(id);
			ExpedienteMovimiento ma = ExpedienteMovimiento.getMovimientoAnterior(um);
			
			if(um == null || um.usuario_id.compareTo(Usuario.getUsurioSesion().id.longValue()) != 0){
				
				restJs.put("error", "El ultimo pase no ha sido realizado por este usuario");
				return ok(restJs);
			}
			
			if(ma != null){
				SqlUpdate update = Ebean.createSqlUpdate("UPDATE expedientes_movimientos SET fecha_salida = null WHERE id = :id ");
				update.setParameter("id", ma.id);
				update.execute();
			}
			
			SqlUpdate update2 = Ebean.createSqlUpdate("UPDATE expedientes_movimientos SET cancelado = true WHERE id = :id ");
			update2.setParameter("id", um.id);
			update2.execute();
			
				
		} catch (PersistenceException pe) {
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	@CheckPermiso(key = "expedientesAsignarMiServicio")
	public static Result asignarMiServicio(Long id) {
		ObjectNode restJs = Json.newObject();
		 
		try {
			
			/*Expediente e = Expediente.find.byId(id);
			if(e != null && e.autoasignacion!= null && e.autoasignacion == true){
				restJs.put("error", "Este expediente ya ha sido AutoAsignado.");
				return ok(restJs);
			}else{
				e.autoasignacion = true;
				e.save();
			}*/
			
			Long organigramaId = Usuario.getUsurioSesion().organigrama_id;
			List<Integer> expedientesSeleccionados = new ArrayList<Integer>();
			expedientesSeleccionados.add(id.intValue());
			Integer count = ExpedienteMovimiento.pasarOtroServicioMasivo(expedientesSeleccionados, organigramaId, "Autoasignacion");
			
		} catch (PersistenceException pe) {
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
						 
	@CheckPermiso(key = "expedientesCancelarPase")
	public static Result cancelarPaseLista() {
		ObjectNode restJs = Json.newObject();
		
		try {
			
			List<Integer> expedientesSeleccionados = getSeleccionados();
			
			if(expedientesSeleccionados.isEmpty()) {
				restJs.put("error", "Debe seleccionar algun expediente.");
				return ok(restJs);
			}	
			
			List<Long> umx = new ArrayList<Long>();
			List<Long> max = new ArrayList<Long>();
			boolean error = false;
			String errorString = "El ultimo pase de estos de estos expedientes no han sidos realizados por este usuarios: ";
			for(Integer z : expedientesSeleccionados){
				ExpedienteMovimiento um = ExpedienteMovimiento.getLastMovimiento(z.longValue());
				ExpedienteMovimiento ma = ExpedienteMovimiento.getMovimientoAnterior(um);
				umx.add(um.id);
				
				if(ma == null){
					max.add(um.id);
				}else{
					max.add(ma.id);
				}
				
				if(um == null || um.usuario_id.compareTo(Usuario.getUsurioSesion().id.longValue()) != 0){
					error = true;
					errorString += um.expediente.getExpedienteEjercicio()+"-";
				}
			}
			
			if(error){
				restJs.put("error", errorString);
				return ok(restJs);
			}else{
				
				SqlUpdate update = Ebean.createSqlUpdate("UPDATE expedientes_movimientos SET fecha_salida = null WHERE id IN(:idList) ");
				update.setParameter("idList", max);
				update.execute();
				
				SqlUpdate update2 = Ebean.createSqlUpdate("UPDATE expedientes_movimientos SET cancelado = true WHERE id in(:idList) ");
				update2.setParameter("idList", umx);
				update2.execute();
			}
			
		} catch (PersistenceException pe) {
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
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
