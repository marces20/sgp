package controllers.rrhh;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Agente;
import models.AgenteAsistenciaLicencia;
import models.AgenteEstudio;
import models.AgenteSeguimiento;
import models.Certificacion;
import models.Estado;
import models.Factura;
import models.Usuario;
import models.auth.Permiso;
import models.haberes.LiquidacionPuesto;
import models.haberes.PuestoLaboral;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.validation.EmailFormatValidation;
import views.html.sinPermiso;
import views.html.rrhh.agenteSeguimientos.*;

@Security.Authenticated(Secured.class)
public class AgentesSeguimientoController extends Controller {
	
	final static Form<AgenteSeguimiento> agenteSeguimientoForm = form(AgenteSeguimiento.class);
	
	public static Result URL_LISTA_AGENTE = redirect(controllers.rrhh.routes.AgentesSeguimientoController.index());
	
	@CheckPermiso(key = "agentesSeguimientos")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		
		return ok(indexAgenteSeguimiento.render(
				 AgenteSeguimiento.page(
				 RequestVar.get("nombre"),
				 RequestVar.get("dni"),
				 RequestVar.get("tipo_agente_seguimiento"),
				 RequestVar.get("btnFiltro[0]"),
				 RequestVar.get("btnFiltro[1]"),
				 RequestVar.get("btnFiltro[2]")
				 ),d));
		
	}
	
	@CheckPermiso(key = "agentesSeguimientosCrear")
	public static Result crearAgenteSeguimiento() {
		
		Form<AgenteSeguimiento> agenteForm = form(AgenteSeguimiento.class);
		agenteForm.discardErrors();
		AgenteSeguimiento a = null;
		return ok(crearAgenteSeguimiento.render(agenteForm,a));
	}
	
	@CheckPermiso(key = "agentesSeguimientosCrear")
	public static Result guardarAgenteSeguimiento() {
		
		Form<AgenteSeguimiento> agenteForm = form(AgenteSeguimiento.class).bindFromRequest();
		AgenteSeguimiento a = new AgenteSeguimiento();
		if(agenteForm.hasErrors()) {
			flash("error", "Error en formulario");
			System.out.println(agenteForm.errors());
			return badRequest(crearAgenteSeguimiento.render(agenteForm,a));
		}
		a = agenteForm.get();
		
		 
		
		try {
			
			a.estado_id = (long) Estado.AGENTE_SEGUIMIENTO_BORRADOR;
			a.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			a.create_date = new Date();
			a.save();
			
			flash("success", "El agente seguimiento se ha guardado");
			return redirect( controllers.rrhh.routes.AgentesSeguimientoController.ver( a.id )+ UriTrack.get("&"));
			 
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el agente seguimiento");
			return badRequest(crearAgenteSeguimiento.render(agenteForm,a));
		}
	}
	
	@CheckPermiso(key = "agentesSeguimientosCrear")
	public static Result editarAgenteSeguimiento(Long id) {
		
		AgenteSeguimiento agente = Ebean.find(AgenteSeguimiento.class, id);
		
		if(agente.estado_id.compareTo((long) Estado.AGENTE_SEGUIMIENTO_BORRADOR) != 0) {
			flash("error", "No se puede editar. Debe cambiar su estado a borrador");
			return redirect(request().getHeader("referer"));
		}else {
			
			
			return ok(editarAgenteSeguimiento.render(agenteSeguimientoForm.fill(agente),agente));
		}
	}
	
	@CheckPermiso(key = "agentesSeguimientosCrear")
	public static Result actualizarAgenteSeguimiento(Long agenteSeguimientoId){
		
		Form<AgenteSeguimiento> agenteForm = form(AgenteSeguimiento.class).bindFromRequest();
		AgenteSeguimiento at = AgenteSeguimiento.find.byId(agenteSeguimientoId);
		
		
		try {
			
			if(agenteForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarAgenteSeguimiento.render(agenteForm,at));
			} else {
				AgenteSeguimiento a = agenteForm.get();
				 
				a.estado_id = at.estado_id;
				a.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				a.write_date = new Date();
				a.update();
				
				flash("success", "El agente seguimiento se ha actualizado");
				return redirect( controllers.rrhh.routes.AgentesSeguimientoController.ver( a.id )+ UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			 
			flash("error", "No se ha podido almacenar el agente seguimiento");
			return badRequest(editarAgenteSeguimiento.render(agenteForm,at));
		}
	}
	
	@CheckPermiso(key = "agentesSeguimientosEliminar")
	public static Result eliminarAgenteSeguimiento(Long id) {
		try {
			
			AgenteSeguimiento a = AgenteSeguimiento.find.byId(id);
			
			if(a.estado_id.compareTo((long) Estado.AGENTE_SEGUIMIENTO_BORRADOR) == 0) {
				a.delete();
				flash("success", "Se ha eliminado el agente seguimiento");
			}else {
				flash("error", "Solo se puede eliminar en estado Borrador");
			}
			
			
		} catch (PersistenceException pe) {
			System.out.println(pe);
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el agente seguimiento");
		}

		return URL_LISTA_AGENTE;
	}
	
	
	@CheckPermiso(key = "agentesSeguimientos")
	public static Result ver(Long id) throws IOException {
		 
		
		AgenteSeguimiento agenteSeguimiento = AgenteSeguimiento.find.byId(id);

		if(agenteSeguimiento == null){
			flash("error", "No se encuentra el agente.");
			return URL_LISTA_AGENTE;
		}
		Form<AgenteSeguimiento> lineaForm = form(AgenteSeguimiento.class).fill(agenteSeguimiento);
		return ok(verAgenteSeguimiento.render(agenteSeguimiento,lineaForm, new PaginadorFicha(UriTrack.code())));
	}
	
	public static Result cambiarEstado(Long idSeguimiento, Long idEstado) throws IOException{
		Boolean permiso = false;
		
		AgenteSeguimiento lc = AgenteSeguimiento.find.where().eq("id", idSeguimiento).findUnique();
		 
		switch ( idEstado.intValue() ) {
	      case  Estado.AGENTE_SEGUIMIENTO_BORRADOR:
	    	  if(!Permiso.check("agentesSeguimientosCrear")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarEnBorrador(idSeguimiento);
	    	  break;
	      case Estado.AGENTE_SEGUIMIENTO_PROCESO:
	    	  if(!Permiso.check("agentesSeguimientosCrear")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarProceso(idSeguimiento);
	    	  break;       
	      case Estado.AGENTE_SEGUIMIENTO_CERRADO:
	    	  if(!Permiso.check("agentesSeguimientosCrear")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarCerrado(idSeguimiento); 
	    	  break;
	     default:
	           break;
	      } 
		 
	    
		return redirect(controllers.rrhh.routes.AgentesSeguimientoController.ver(idSeguimiento)+ UriTrack.get("&"));
	}
	
	public static void pasarEnBorrador(Long idSeguimiento){
		
		AgenteSeguimiento lp = Ebean.find(AgenteSeguimiento.class).select("id, estado_id").setId(idSeguimiento).findUnique();
		
		if(lp != null){			
			lp.estado_id = new Long(Estado.AGENTE_SEGUIMIENTO_BORRADOR);
			lp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			lp.write_date = new Date();
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	public static void pasarProceso(Long idSeguimiento){
		
		AgenteSeguimiento lp = Ebean.find(AgenteSeguimiento.class).select("id, estado_id").setId(idSeguimiento).findUnique();
		
		if(lp != null){			
			lp.estado_id = new Long(Estado.AGENTE_SEGUIMIENTO_PROCESO);
			lp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			lp.write_date = new Date();
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Proceso");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	public static void pasarCerrado(Long idSeguimiento){
		
		AgenteSeguimiento lp = Ebean.find(AgenteSeguimiento.class).select("id, estado_id").setId(idSeguimiento).findUnique();
		
		if(lp != null){			
			lp.estado_id = new Long(Estado.AGENTE_SEGUIMIENTO_CERRADO);
			lp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			lp.write_date = new Date();
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Cerrado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
}
