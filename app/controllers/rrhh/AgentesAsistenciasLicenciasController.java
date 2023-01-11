package controllers.rrhh;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.AgenteAsistenciaLicencia;
import models.CertificacionLinea;
import models.Ejercicio;
import models.Estado;
import models.ExpedienteMovimiento;
import models.Factura;
import models.FacturaLinea;
import models.OrdenPagoCircuito;
import models.Organigrama;
import models.Usuario;
import models.auth.Permiso;
import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.RequestVar;
import utils.pagination.Pagination; 
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.rrhh.agenteAsistenciaLicencia.*; 
import views.html.rrhh.agenteAsistenciaLicencia.acciones.*;

@Security.Authenticated(Secured.class)
public class AgentesAsistenciasLicenciasController extends Controller {
	
	final static Form<AgenteAsistenciaLicencia> lineaForm = form(AgenteAsistenciaLicencia.class);
	
	public static Result index(Long agenteId, Boolean editable,Long tipoLicencia) {
		Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzz");
		
		 
		Pagination<AgenteAsistenciaLicencia> lineas = AgenteAsistenciaLicencia.page(agenteId,tipoLicencia);
		Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzz");
		return ok(indexAgenteAsistenciaLicencia.render(lineas, editable));
	}
	
	@CheckPermiso(key = "agentesLicenciasCrear")
	public static Result crear(String agenteId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("agente_id", agenteId);
		Form<AgenteAsistenciaLicencia> linea = form(AgenteAsistenciaLicencia.class).bind(b);
		linea.discardErrors();
		return ok(crearAgenteAsistenciaLicencia.render(linea));
	}
	
	@CheckPermiso(key = "agentesLicenciasCrear")
	public static Result guardar() {
		Form<AgenteAsistenciaLicencia> lineaForm = form(AgenteAsistenciaLicencia.class).bindFromRequest();

		try {
			validarForm(lineaForm);
			if(lineaForm.hasErrors()) {
				System.out.println(lineaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
			} else {
				AgenteAsistenciaLicencia l = lineaForm.get();
				if(lineaForm.get().ffin.before(lineaForm.get().finicio)){
					flash("error", "La Fecha de fin es manor a la Fecha de inicio.");
					return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}
				
				int diasPermitidos = 30;
				int diasPermitidosFin = 120;
				if(Permiso.check("agentesLicenciasCargarMas200dias")){
					diasPermitidos = 1000;
					diasPermitidosFin = 1000;
				}
				
				Date ahora = new Date();
				long diferenciaEn_ms = lineaForm.get().finicio.getTime() - ahora.getTime();
				long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
				if((int) dias > diasPermitidos || (int) dias < -diasPermitidos){
					flash("error", "La Fecha de inicio no puede ser ni mayor ni menor de "+diasPermitidos+" dias desde hoy.");
					return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}
				
				ahora = new Date();
				diferenciaEn_ms = lineaForm.get().ffin.getTime() - ahora.getTime();
				dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
				if((int) dias > diasPermitidosFin || (int) dias < -diasPermitidosFin){
					flash("error", "La Fecha de fin no puede ser ni mayor ni menor de "+diasPermitidosFin+" dias desde hoy.");
					return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}
				
				
				if(!l.tienePermisosTipoLicencia(l)){
					flash("error", "No tiene permisos para cargar este tipo de licencias.");
					return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}
				
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.estado_id = (long)Estado.AGENTE_LICENCIA_BORRADOR;
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
		}
		
		AgenteAsistenciaLicencia linea = AgenteAsistenciaLicencia.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verAgenteAsistenciaLicencia.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	@CheckPermiso(key = "agentesLicenciasModificar")
	public static Result editar(Long id) {
		flash().clear();
		AgenteAsistenciaLicencia linea = AgenteAsistenciaLicencia.find.byId(id);
		if(!linea.tienePermisosTipoLicencia(linea)){
			flash("error", "No tiene permisos para editar este tipo de licencias.");
			return ok(editarAgenteAsistenciaLicencia.render(lineaForm.fill(linea),false));
		}
		
		return ok(editarAgenteAsistenciaLicencia.render(lineaForm.fill(linea),true));
	}
	
	@CheckPermiso(key = "agentesLicenciasModificar")
	public static Result actualizar() {

		Form<AgenteAsistenciaLicencia> lineaForm = form(AgenteAsistenciaLicencia.class).bindFromRequest();
		
		try {
			validarForm(lineaForm);
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarAgenteAsistenciaLicencia.render(lineaForm,true));
			} else {
				AgenteAsistenciaLicencia fl = lineaForm.get();
				
				if(lineaForm.get().ffin.before(lineaForm.get().finicio)){
					flash("error", "La Fecha de fin es manor a la Fecha de inicio.");
					return ok(editarAgenteAsistenciaLicencia.render(lineaForm,true));
				}
				if(!fl.tienePermisosTipoLicencia(fl)){
					flash("error", "No tiene permisos para cargar este tipo de licencias.");
					return ok(editarAgenteAsistenciaLicencia.render(lineaForm,true));
				}
				
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarAgenteAsistenciaLicencia.render(lineaForm,true));
		}
		
		AgenteAsistenciaLicencia linea = AgenteAsistenciaLicencia.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verAgenteAsistenciaLicencia.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	@CheckPermiso(key = "agentesLicenciasEliminar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			AgenteAsistenciaLicencia aal = AgenteAsistenciaLicencia.find.byId(id);
			if(!aal.tienePermisosTipoLicencia(aal)){
				flash("error", "No tiene permisos para cargar este tipo de licencias.");
				restJs.put("succes", false);
			}else{
				aal.delete();
			}
			
			
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static void validarForm(Form<AgenteAsistenciaLicencia> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("finicio", "Fecha inválida"));
		v.add(new DateValidation("ffin", "Fecha inválida"));
		v.validate();
	}
	
	@CheckPermiso(key = "agentesLicenciasPasarBorrador")
	public static Result modalPasarBorrador() {
		return ok(modalPasarBorrador.render(form().bindFromRequest()));
	}
	
	public static Result pasarBorradorMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> lSeleccionados = getSeleccionados();

		if(lSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			return ok(modalPasarBorrador.render(d));
		}	
		
		if(!soloCancelado(lSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en cancelado.");
			return ok(modalPasarBorrador.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarBorrador.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = AgenteAsistenciaLicencia.modificarEstadoMasivo(Estado.AGENTE_LICENCIA_BORRADOR, lSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarBorrador.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarBorrador.render(d));
		}
		
	}
	
	public static Boolean soloCancelado(List<Integer> opcSeleccionados) {
		return AgenteAsistenciaLicencia.find.where().ne("estado_id", Estado.AGENTE_LICENCIA_CANCELADO).in("id", opcSeleccionados).findRowCount() == 0;
	}
	
	@CheckPermiso(key = "agentesLicenciasPasarPreAprobado")
	public static Result modalPasarPreAprobado() {
		return ok(modalPasarPreAprobado.render(form().bindFromRequest()));
	}
	
	public static Result pasarPreAprobadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> lSeleccionados = getSeleccionados();

		if(lSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			return ok(modalPasarPreAprobado.render(d));
		}	
		
		if(!soloBorrador(lSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en borrador.");
			return ok(modalPasarPreAprobado.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarPreAprobado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = AgenteAsistenciaLicencia.modificarEstadoMasivo(Estado.AGENTE_LICENCIA_PREAPROBADO, lSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarPreAprobado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarPreAprobado.render(d));
		}
		
	}
	
	@CheckPermiso(key = "agentesLicenciasPasarAprobado")
	public static Result modalPasarAprobado() {
		return ok(modalPasarAprobado.render(form().bindFromRequest()));
	}
	
	public static Result pasarAprobadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> lSeleccionados = getSeleccionados();

		if(lSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			return ok(modalPasarAprobado.render(d));
		}	
		
		if(!soloBorrador(lSeleccionados) && !soloPreaprobado(lSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en borrador o preaprobado.");
			return ok(modalPasarAprobado.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarAprobado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = AgenteAsistenciaLicencia.modificarEstadoMasivo(Estado.AGENTE_LICENCIA_APROBADO, lSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarAprobado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarAprobado.render(d));
		}
		
	}
	
	public static Boolean soloBorrador(List<Integer> opcSeleccionados) {
		return AgenteAsistenciaLicencia.find.where().ne("estado_id", Estado.AGENTE_LICENCIA_BORRADOR).in("id", opcSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloPreaprobado(List<Integer> opcSeleccionados) {
		return AgenteAsistenciaLicencia.find.where().ne("estado_id", Estado.AGENTE_LICENCIA_PREAPROBADO).in("id", opcSeleccionados).findRowCount() == 0;
	}
	
	@CheckPermiso(key = "agentesLicenciasPasarCancelado")
	public static Result modalPasarCancelado() {
		return ok(modalPasarCancelado.render(form().bindFromRequest()));
	}
	
	public static Result pasarCanceladoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> lSeleccionados = getSeleccionados();

		if(lSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			return ok(modalPasarCancelado.render(d));
		}	
		
		if(d.hasErrors())
			return ok(modalPasarCancelado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = AgenteAsistenciaLicencia.modificarEstadoMasivo(Estado.AGENTE_LICENCIA_CANCELADO, lSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarCancelado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarCancelado.render(d));
		}
		
	}
	
	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado_inasistencia[]");
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
	
	public static Result resumen(Long agenteId, Boolean editable) {
		
		AgenteAsistenciaLicencia aal = new AgenteAsistenciaLicencia();
		
		return ok(resumenAgenteAsistenciaLicencia.render(aal.getResumenInasistencia(agenteId)));
	}
	
	public static Result getListaLicenciasPendientes(){
		DynamicForm d = form().bindFromRequest();
		AgenteAsistenciaLicencia aal = new AgenteAsistenciaLicencia();
		String ejercicio = "2017";
		if(!RequestVar.get("ejercicio").isEmpty()){
			ejercicio = Ejercicio.find.byId(new Long(RequestVar.get("ejercicio"))).nombre;
    	}
		return ok(listadoLicenciasPedientes.render(aal.getDiasLicencias(RequestVar.get("ejercicio"), 
													RequestVar.get("apellido"), 
													RequestVar.get("dni"), 
													RequestVar.get("cuit"), 
													RequestVar.get("organigrama_id"), 
													RequestVar.get("tipo_relacion_laboral"),
													RequestVar.get("completas"),
													RequestVar.get("activo")
													),d,ejercicio));
		
	}
	
	public static Result getListaLicenciasEnFecha(){
		DynamicForm d = form().bindFromRequest();
		AgenteAsistenciaLicencia aal = new AgenteAsistenciaLicencia();
		
		return ok(listadoLicenciasEnFecha.render(aal.getDiasLicenciasEnFecha(RequestVar.get("desde"),
																			 RequestVar.get("hasta"),
																			 RequestVar.get("organigrama_id"),
																			 RequestVar.get("tipo_relacion_laboral"),
																			 RequestVar.get("tipo_licencia_id"),
																			 RequestVar.get("estado_id"),
																			 RequestVar.get("descripcion"),
																			 RequestVar.get("ejercicio"),
																			 RequestVar.get("nombre"),
																			 RequestVar.get("dni")
																			 ),d));
	}
}
