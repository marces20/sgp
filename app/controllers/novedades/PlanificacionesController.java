package controllers.novedades;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Estado;
import models.Expediente;
import models.Usuario;
import models.auth.Permiso;
import models.novedades.Planificacion;
import models.recupero.RecuperoCertificadoDeuda;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.novedades.planificaciones.*;

@Security.Authenticated(Secured.class)
public class PlanificacionesController extends Controller {

	final static Form<Planificacion> planificacionForm = form(Planificacion.class);

	public static Result URL_LISTA_PLANIFICIACION = redirect(
			controllers.novedades.routes.PlanificacionesController.index()
	);

	@CheckPermiso(key = "planificacionVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexPlanificaciones.render(
				Planificacion.page(
												  		RequestVar.get("numero"),
												  		RequestVar.get("expediente_id"),
												  		RequestVar.get("fecha_desde"),
												  		RequestVar.get("btnFiltro[0]"),//borrador
												  		RequestVar.get("btnFiltro[1]"),
												  		RequestVar.get("cliente_id")
												  		),d));
	}

	@CheckPermiso(key = "planificacionCrear")
	public static Result crear() {

		Map<String,String> p = new HashMap<String, String>();

		Form<Planificacion> planificacionForm = form(Planificacion.class).bind(p);
		planificacionForm.discardErrors();

		return ok(crearPlanificaciones.render(planificacionForm));
	}

	@CheckPermiso(key = "planificacionCrear")
	public static Result guardar() {

		Form<Planificacion> planificacionForm = form(Planificacion.class).bindFromRequest();

		if(planificacionForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearPlanificaciones.render(planificacionForm));
		}

		try {

			Planificacion c = planificacionForm.get();
			c.organigrama_id= Usuario.getUsurioSesion().organigrama.id;
			c.estado_id = (long) Estado.PLANIFICIACION_BORRADOR;
			c.save();

			flash("success", "La planificacion se ha creado");
			return redirect( controllers.novedades.routes.PlanificacionesController.ver(planificacionForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la planificaciones");
			return badRequest(crearPlanificaciones.render(planificacionForm));
		}
	}

	@CheckPermiso(key = "planificacionModificar")
	public static Result editar(Long id) {
		Planificacion planificacion = Planificacion.find.byId(id);

		if(planificacion  == null){
			flash("error", "No se encuentra la planificaciones.");
			return redirect(controllers.novedades.routes.PlanificacionesController.index()+UriTrack.get("?"));
		}else if(planificacion.estado_id != Estado.PLANIFICIACION_BORRADOR){
			flash("error", "La planificacion no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));

		}

		return ok(editarPlanificaciones.render(planificacionForm.fill(planificacion),planificacion));
	}

	@CheckPermiso(key = "planificacionModificar")
	public static Result actualizar(Long id){

		Form<Planificacion> planificacionForm = form(Planificacion.class).bindFromRequest();

		Planificacion planificacion = Ebean.find(Planificacion.class, id);

		if(planificacionForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarPlanificaciones.render(planificacionForm,planificacion));
		}

		try {

			Planificacion c = planificacionForm.get();
			c.update();

			flash("success", "La planificacion se ha actualizado");
			return redirect( controllers.novedades.routes.PlanificacionesController.ver(planificacionForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la planificaciones");
			return badRequest(editarPlanificaciones.render(planificacionForm,planificacion));
		}
	}

	@CheckPermiso(key = "planificacionEliminar")
	public static Result eliminar(Long id) {

		Planificacion planificacion = Ebean.find(Planificacion.class).select("id").setId(id).findUnique();

		if(planificacion == null){
			flash("error", "No se encuentra la planificacion.");
			return redirect(controllers.novedades.routes.PlanificacionesController.index()+UriTrack.get("?"));
		}

		try {
			planificacion.delete();
			flash("success", "Se ha eliminado la planificacion");
			return redirect(UriTrack.decode());
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la planificacion");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}

	@CheckPermiso(key = "planificacionVer")
	public static Result ver(Long id) {

		Planificacion p = Planificacion.find.byId(id);

		if(p != null){

			Form<Planificacion> planificacionForm = form(Planificacion.class).fill(p);
			return ok(verPlanificaciones.render(planificacionForm, p));

		}else{
			flash("error", "No se encuentra la planificacion.");
			return redirect(controllers.novedades.routes.PlanificacionesController.index()+UriTrack.get("?"));
		}
	}

	public static Result cambiarEstado(Long id, Long idEstado) throws IOException{

		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_PLANIFICACION);

		Planificacion rp = Planificacion.find.byId(id);


		if(rp == null){
			flash("error", "No se encuentra la planificacion");
			return redirect(request().getHeader("referer"));
		}


		if(idEstado != null){

			Boolean permiso = false;

			switch ( idEstado.intValue() ) {
		      case  Estado.PLANIFICIACION_BORRADOR:
		    	  if(!Permiso.check("planificacionPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(rp.id);
		    	  break;

		      case Estado.PLANIFICIACION_APROBADO:
		    	  if(!Permiso.check("planificacionPasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobado(rp.id);
		    	  break;
		      case Estado.PLANIFICIACION_CANCELADO:
		    	  if(!Permiso.check("planificacionPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(rp.id);
		    	  break;
		      default:
		           break;
		      }

		}

		return redirect(controllers.novedades.routes.PlanificacionesController.ver(rp.id)+ UriTrack.get("&"));
	}

	public static void pasarEnBorrador(Long idRf){

		Planificacion rf = Ebean.find(Planificacion.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.PLANIFICIACION_BORRADOR);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	public static void pasarAprobado(Long idRf){

		Planificacion rf = Ebean.find(Planificacion.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.PLANIFICIACION_APROBADO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Aprobado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	public static void pasarCancelado(Long idRf){

		Planificacion rf = Ebean.find(Planificacion.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.PLANIFICIACION_CANCELADO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

}
