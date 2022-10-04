package controllers.patrimonio;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

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
import models.ActaMovimiento;
import models.ActaRecepcion;
import models.Estado;
import models.Expediente;
import models.ExpedienteMovimiento;
import models.Organigrama;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination; 
import views.html.patrimonio.actasMovimientos.*;
import views.html.patrimonio.actasMovimientos.acciones.*;

@Security.Authenticated(Secured.class)
public class ActasMovimientosController extends Controller {
	
final static Form<ActaMovimiento> lineaForm = form(ActaMovimiento.class);
	
	public static Result indexPasesPorUsuario() {
		
		Map<String,String> p = new HashMap<String, String>();
		String organigrama_id = RequestVar.get("organigrama_id");
		DynamicForm d = form().bindFromRequest();
		
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		
		
		//if(Usuario.getUsurioSesion().id !=132 && Usuario.getUsurioSesion().organigrama != null && RequestVar.getValueOrNull("organigrama_id") == null){
			
			// p.put("organigrama_id", Usuario.getUsurioSesion().organigrama_id.toString());
			// d = form().bind(p);
			// organigrama_id = Usuario.getUsurioSesion().organigrama_id.toString();
		//}
		
		
		Pagination<ActaMovimiento> lineas = ActaMovimiento.pagePasesPorUsuario(Usuario.getUsurioSesion().id.toString(),
				RequestVar.get("numero"),
				RequestVar.get("expediente_id"));
	
		return ok(indexPasesPorUsuario.render(lineas,d,pf));
	}

	public static Result indexGeneral() {
		
		Map<String,String> p = new HashMap<String, String>();
		String organigrama_id = RequestVar.get("organigrama_id");
		DynamicForm d = form().bindFromRequest();
		
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		
		organigrama_id = Usuario.getUsurioSesion().organigrama_id.toString();
		
		Logger.debug("swssssssssssssssssss "+ organigrama_id);
		Pagination<ActaMovimiento> lineas = ActaMovimiento.pageGeneral(organigrama_id);

		return ok(indexGeneralActaMovimiento.render(lineas,d,pf));
	}
	
	public static Result index(Long actaId) {
		
		Pagination<ActaMovimiento> lineas = ActaMovimiento.page(actaId);

		return ok(indexActaMovimiento.render(lineas,false));
	}
	
	public static Result crear(String actaId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("acta_id", actaId);
		Form<ActaMovimiento> linea = form(ActaMovimiento.class).bind(b);
		linea.discardErrors();
		return ok(crearActaMovimiento.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			ActaMovimiento.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<ActaMovimiento> lineaForm = form(ActaMovimiento.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearActaMovimiento.render(lineaForm));
			} else {
				
				ActaMovimiento f = lineaForm.get();
				
				if(Usuario.getUsurioSesion().organigrama == null){
					flash("error", "Este usuario no tiene asignado un Servicio/Depto");
					return ok(crearActaMovimiento.render(lineaForm));
				}
				if(!ActaMovimiento.isLastMovimientoServicioUsuario(f.acta_id,Usuario.getUsurioSesion().organigrama_id)) {
					flash("error", "No puede realizar el pase por que pertence a otro servicio.");
					return ok(crearActaMovimiento.render(lineaForm));
				}
				
				Date ahora = new Date();
				Integer codigo = ActaMovimiento.getSecuenciaActaMovimientoCodigo();
				
				f.usuario_id = new Long(Usuario.getUsuarioSesion());
				f.fecha_llegada = ahora;
				f.cancelado = false;
				f.codigo = codigo;
				f.save();
				
				ActaMovimiento ma = ActaMovimiento.getMovimientoAnterior(f);
				if(ma != null){
					ma.fecha_salida = ahora;
					ma.update();
				}
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro."+e);
			return ok(crearActaMovimiento.render(lineaForm));
		}
		
		ActaMovimiento linea = ActaMovimiento.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verActaMovimiento.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result editar(Long id) {
		flash().clear();
		ActaMovimiento linea = ActaMovimiento.find.byId(id);
		return ok(editarActaMovimiento.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<ActaMovimiento> lineaForm = form(ActaMovimiento.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarActaMovimiento.render(lineaForm));
			} else {
				ActaMovimiento fl = lineaForm.get();
				 
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarActaMovimiento.render(lineaForm));
		}
		
		ActaMovimiento linea = ActaMovimiento.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verActaMovimiento.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
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
	
	public static Result modalCierreCircuitoIndividual(Long id) {
		return ok(modalCierreCircuito.render(form().bindFromRequest(),id,null));
	}
	
	public static Result modalCierreCircuito() {
		return ok(modalCierreCircuito.render(form().bindFromRequest(),null,null));
	}
	
	public static Result modalPasarOtroServicioIndividual(Long id) {
		return ok(modalPasarOtroServicio.render(form().bindFromRequest(),id,null));
	}
	
	public static Result modalPasarOtroServicio() {
		return ok(modalPasarOtroServicio.render(form().bindFromRequest(),null,null));
	}
	
	@CheckPermiso(key = "expedientesPasarAOtroServicio")
	public static Result cierreCircuito() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> actasSeleccionados = getSeleccionados();
		
		Long idActa = null;
		
		if(request().body().asFormUrlEncoded().get("idActa") != null){
			String idActaString =request().body().asFormUrlEncoded().get("idActa")[0];
			idActa =  new Long(idActaString);
			actasSeleccionados.clear();
			actasSeleccionados.add(idActa.intValue());
		}
		
		
		if(actasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un acta.");
			return ok(modalCierreCircuito.render(d,idActa,null));
		}
		
		 
		
		if(Usuario.getUsurioSesion().organigrama == null) {
			flash("error", "No tienes un servicio asignado a tu usuarios. Debes solicitar que se te asignen uno.");
			return ok(modalCierreCircuito.render(d,idActa,null));
		}
		
		
		String descripcion = request().body().asFormUrlEncoded().get("descripcion")[0];
		
		List<Long> soloDeMiServicio = soloDeMiServicio(actasSeleccionados);
		
		if(soloDeMiServicio.size() > 0) {
			String error = "Solo se puede modificar realizar movimientos que se encuentren en mi servicio "+Usuario.getUsurioSesion().organigrama.nombre+" <br>";
			
			error += "Actas que no se encuentan en mi servicio:<br>";
			
			for(Long x :soloDeMiServicio){
				ActaRecepcion e = ActaRecepcion.find.byId(x);
				error += "- "+e.getNombre()+"\n";
			}
			
			flash("error", error);
			return ok(modalCierreCircuito.render(d,idActa,null));
		}
		
		List<Long> soloAbiertas = ActaMovimiento.getStringIsNotMovimientoCierre(actasSeleccionados);
		
		Logger.debug("++++++++++++++++ "+soloAbiertas.size());
		
		if(soloAbiertas.size() > 0) {
			String error = "NO SE PUEDE CAMBIAR ACTAS CON EL CIRCUITO CERRADO<br>";
			error += "Actas que se encuentan CERRADAS:<br>";
			for(Long x :soloAbiertas){
				ActaRecepcion e = ActaRecepcion.find.byId(x);
				error += "- "+e.getNombre()+"\n";
			}
			
			flash("error", error);
			return ok(modalCierreCircuito.render(d,idActa,null));
		}
		
		List<ActaRecepcion> act = ActaRecepcion.find.where().ne("estado_id",Estado.ACTA_ESTADO_APROBADA).in("id",actasSeleccionados).findList();
		if(act.size() > 0) {
			flash("error", "Solo se pueden realizar Pases en Actas en estado APROBADAS.");
			return ok(modalPasarOtroServicio.render(d,idActa,null));
		}
		
		if(d.hasErrors())
			return ok(modalCierreCircuito.render(d,idActa,null));	
		
		ObjectNode result = Json.newObject();
		try {
			
			Long organigramaId = new Long(91);
			
			
			
			Integer count = ActaMovimiento.pasarOtroServicioMasivo(actasSeleccionados, organigramaId, descripcion,true);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ actasSeleccionados.size() +" seleccionados.");
			
			
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/paseActas.odt");
			List<String> listaErrores = new ArrayList<String>(); 
			File archivoPdf = new File(dirTemp+"/paseActa-"+Usuario.getUsuarioSesion()+".pdf");
			try {	
				
				InputStream in = Play.application().resourceAsStream("resources/reportes/patrimonio/actasRecepcion/paseActas.odt");
				IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
				IContext context = report.createContext();
				
				List<ActaMovimiento> x = new ArrayList<ActaMovimiento>();
				for(Integer z : actasSeleccionados){
					ActaMovimiento um = ActaMovimiento.getLastMovimiento(z.longValue());
					ActaMovimiento ma = ActaMovimiento.getMovimientoAnterior(um);
					x.add(um);
				}
				
				context.put("um",x);
				context.put("util",new DateUtils());
				context.put("user",Usuario.getUsurioSesion());
				context.put("ActaMovimiento",new ActaMovimiento());
				
				
				
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
			
			
			result.put("html", modalCierreCircuito.render(d,idActa,archivoPdf.getPath()).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCierreCircuito.render(d,idActa,null));
		}		
	}
	
	
	@CheckPermiso(key = "expedientesPasarAOtroServicio")
	public static Result pasarOtroServicio() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> actasSeleccionados = getSeleccionados();
		
		Long idActa = null;
		
		if(request().body().asFormUrlEncoded().get("idActa") != null){
			String idActaString =request().body().asFormUrlEncoded().get("idActa")[0];
			idActa =  new Long(idActaString);
			actasSeleccionados.clear();
			actasSeleccionados.add(idActa.intValue());
		}
		
		
		if(actasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un acta.");
			return ok(modalPasarOtroServicio.render(d,idActa,null));
		}
		
		 
		
		if(Usuario.getUsurioSesion().organigrama == null) {
			flash("error", "No tienes un servicio asignado a tu usuarios. Debes solicitar que se te asignen uno.");
			return ok(modalPasarOtroServicio.render(d,idActa,null));
		}
		
		String orgaId =request().body().asFormUrlEncoded().get("organigrama_id")[0];
		String descripcion = request().body().asFormUrlEncoded().get("descripcion")[0];
		
		if(orgaId.isEmpty()){
			d.reject("organigrama_id","Debe seleccionar un servicio.");
			return ok(modalPasarOtroServicio.render(d,idActa,null));
		}
		
		if(orgaId.compareTo(Usuario.getUsurioSesion().organigrama_id.toString()) == 0){
			d.reject("organigrama_id","No puede dar un pase a tu mismo servicio.");
			return ok(modalPasarOtroServicio.render(d,idActa,null));
		}
		
		List<Long> soloDeMiServicio = soloDeMiServicio(actasSeleccionados);
		
			
		
		if(soloDeMiServicio.size() > 0) {
			String error = "Solo se puede modificar realizar movimientos que se encuentren en mi servicio "+Usuario.getUsurioSesion().organigrama.nombre+" <br>";
			error += "Actas que no se encuentan en mi servicio:<br>";
			for(Long x :soloDeMiServicio){
				ActaRecepcion e = ActaRecepcion.find.byId(x);
				error += "- "+e.getNombre()+"\n";
			}
			
			flash("error", error);
			return ok(modalPasarOtroServicio.render(d,idActa,null));
		}
		
		List<Long> soloAbiertas = ActaMovimiento.getStringIsNotMovimientoCierre(actasSeleccionados);
		
		Logger.debug("++++++++++++++++ "+soloAbiertas.size());
		
		if(soloAbiertas.size() > 0) {
			String error = "NO SE PUEDE CAMBIAR ACTAS CON EL CIRCUITO CERRADO<br>";
			error += "Actas que se encuentan CERRADAS:<br>";
			for(Long x :soloAbiertas){
				ActaRecepcion e = ActaRecepcion.find.byId(x);
				error += "- "+e.getNombre()+"\n";
			}
			
			flash("error", error);
			return ok(modalPasarOtroServicio.render(d,idActa,null));
		}
		
		List<ActaRecepcion> act = ActaRecepcion.find.where().ne("estado_id",Estado.ACTA_ESTADO_APROBADA).in("id",actasSeleccionados).findList();
		if(act.size() > 0) {
			flash("error", "Solo se pueden realizar Pases en Actas en estado APROBADAS.");
			return ok(modalPasarOtroServicio.render(d,idActa,null));
		}
		
		if(d.hasErrors())
			return ok(modalPasarOtroServicio.render(d,idActa,null));	
		
		ObjectNode result = Json.newObject();
		try {
			Long organigramaId =  new Long(orgaId);
			Integer count = ActaMovimiento.pasarOtroServicioMasivo(actasSeleccionados, organigramaId, descripcion);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ actasSeleccionados.size() +" seleccionados.");
			
			
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/paseActas.odt");
			List<String> listaErrores = new ArrayList<String>(); 
			File archivoPdf = new File(dirTemp+"/paseActa-"+Usuario.getUsuarioSesion()+".pdf");
			try {	
				
				InputStream in = Play.application().resourceAsStream("resources/reportes/patrimonio/actasRecepcion/paseActas.odt");
				IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
				IContext context = report.createContext();
				
				List<ActaMovimiento> x = new ArrayList<ActaMovimiento>();
				for(Integer z : actasSeleccionados){
					ActaMovimiento um = ActaMovimiento.getLastMovimiento(z.longValue());
					ActaMovimiento ma = ActaMovimiento.getMovimientoAnterior(um);
					x.add(um);
				}
				
				context.put("um",x);
				context.put("util",new DateUtils());
				context.put("user",Usuario.getUsurioSesion());
				context.put("ActaMovimiento",new ActaMovimiento());
				
				
				
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
			
			
			result.put("html", modalPasarOtroServicio.render(d,idActa,archivoPdf.getPath()).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarOtroServicio.render(d,idActa,null));
		}		
	}
	
	public static List<Long> soloDeMiServicio(List<Integer> actasSeleccionados) {
		
		List<Long> ret = ActaMovimiento.getStringIsNotMovimientoServicioUsuario(actasSeleccionados, Usuario.getUsurioSesion().organigrama_id);
		
		return ret;
	}
	
	@CheckPermiso(key = "expedientesCancelarPase")
	public static Result cancelarPase(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			
			ActaMovimiento um = ActaMovimiento.getLastMovimiento(id);
			ActaMovimiento ma = ActaMovimiento.getMovimientoAnterior(um);
			
			if(um == null || um.usuario_id.compareTo(Usuario.getUsurioSesion().id.longValue()) != 0){
				
				restJs.put("error", "El ultimo pase no ha sido realizado por este usuario");
				return ok(restJs);
			}
			
			if(um == null || um.cierre){
				
				restJs.put("error", "No se puede cancelar pases de CIERRE");
				return ok(restJs);
			}
			
			if(ma != null){
				SqlUpdate update = Ebean.createSqlUpdate("UPDATE actas_movimientos SET fecha_salida = null WHERE id = :id ");
				update.setParameter("id", ma.id);
				update.execute();
			}
			
			SqlUpdate update2 = Ebean.createSqlUpdate("UPDATE actas_movimientos SET cancelado = true WHERE id = :id ");
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
			
			Long organigramaId = Usuario.getUsurioSesion().organigrama_id;
			List<Integer> expedientesSeleccionados = new ArrayList<Integer>();
			expedientesSeleccionados.add(id.intValue());
			Integer count = ActaMovimiento.pasarOtroServicioMasivo(expedientesSeleccionados, organigramaId, "Autoasignacion");
			
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
			
			List<Integer> actasSeleccionados = getSeleccionados();
			
			if(actasSeleccionados.isEmpty()) {
				restJs.put("error", "Debe seleccionar algun acta.");
				return ok(restJs);
			}	
			
			List<Long> umx = new ArrayList<Long>();
			List<Long> max = new ArrayList<Long>();
			boolean error = false;
			boolean error2 = false;
			String errorString = "El ultimo pase de estos de estas actas no han sidos realizados por este usuarios: ";
			String errorString2 = "No se puede cancelar pases de CIERRE";
			
			for(Integer z : actasSeleccionados){
				ActaMovimiento um = ActaMovimiento.getLastMovimiento(z.longValue());
				ActaMovimiento ma = ActaMovimiento.getMovimientoAnterior(um);
				umx.add(um.id);
				
				if(ma == null){
					max.add(um.id);
				}else{
					max.add(ma.id);
				}
				
				if(um == null || um.usuario_id.compareTo(Usuario.getUsurioSesion().id.longValue()) != 0){
					error = true;
					errorString += um.acta.getNombre()+"-";
				}
				
				if(um == null || um.cierre){
					error = true;
					errorString2 += um.acta.getNombre()+"-";
				}
			}
			
			if(error){
				restJs.put("error", errorString);
				return ok(restJs);
			}else if(error2){
				restJs.put("error", errorString2);
				return ok(restJs);
			}else{
				
				SqlUpdate update = Ebean.createSqlUpdate("UPDATE actas_movimientos SET estado_id = null, fecha_salida = null WHERE id IN(:idList) ");
				update.setParameter("idList", max);
				update.execute();
				
				SqlUpdate update2 = Ebean.createSqlUpdate("UPDATE actas_movimientos SET estado_id = null, cancelado = true WHERE id in(:idList) ");
				update2.setParameter("idList", umx);
				update2.execute();
			}
			
		} catch (PersistenceException pe) {
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result modalAsignarMiServicio() {
		return ok(modalAsignarAMiServicio.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "expedientesAsignarMiServicio")
	public static Result asignarAMiServicioMasivo() {
		 
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		List<Integer> actasSeleccionados = getSeleccionados();
		
		if(actasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un acta.");
			return ok(modalAsignarAMiServicio.render(d));
		}
		
		  
		
		Long organigramaId = Usuario.getUsurioSesion().organigrama_id;
		if(organigramaId == null){
			flash("error", "El usuario no tiene asignado un servicio.");
			return ok(modalAsignarAMiServicio.render(d));
		}
		
		
		
		
		Integer count = 0;
		try {
			
			 count = ActaMovimiento.pasarOtroServicioMasivo(actasSeleccionados, organigramaId, "Autoasignacion");
			
		} catch (PersistenceException pe) {
			flash("error", "No se puede asignar los actas.");
			return ok(modalAsignarAMiServicio.render(d));
		}
		
		flash("success", "Se asignaron "+count+" actas a su servicio.");
		return ok(modalAsignarAMiServicio.render(d));
	}
	
	public static Result aceptarPase(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			
			ActaMovimiento linea = ActaMovimiento.find.where().eq("id", id).findUnique();
			linea.estado_id = (long) Estado.ACTA_MOVIMIENTO_RECEPCIONADO;
			linea.fecha_llegada = new Date();
			linea.usuario_receptor_id = new Long(Usuario.getUsuarioSesion());
			linea.save();
			
			
		} catch (PersistenceException pe) {
			restJs.put("success", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result rechazarPase(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			
			ActaMovimiento linea = ActaMovimiento.find.where().eq("id", id).findUnique();
			linea.estado_id = (long) Estado.ACTA_MOVIMIENTO_RECEPCIONADO_CANCELADO;
			linea.cancelado = true;
			linea.usuario_receptor_id = new Long(Usuario.getUsuarioSesion());
			linea.save();
			
			
		} catch (PersistenceException pe) {
			restJs.put("success", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
}
