package controllers.recupero;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Certificacion;
import models.CertificacionLinea;
import models.Estado;
import models.Factura;
import models.Usuario;
import models.auth.Permiso;
import models.recupero.Presupuesto;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import views.html.sinPermiso;
import views.html.recupero.presupuesto.*;

@Security.Authenticated(Secured.class)
public class PresupuestosController  extends Controller {
	
	final static Form<Presupuesto> presupuestoForm = form(Presupuesto.class);
	
	public static Result URL_LISTA_PRESUPUESTO = redirect(
			controllers.recupero.routes.PresupuestosController.index()
	);
	
	@CheckPermiso(key = "presupuestosVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		
		return ok(indexPresupuesto.render(
										  Presupuesto.page(
												  		RequestVar.get("nombre"),
												  		RequestVar.get("cliente_id"),
												  		RequestVar.get("fecha_desde"),
												  		RequestVar.get("fecha_hasta"),
												  		RequestVar.get("btnFiltro[0]"),//borrador
												  		RequestVar.get("btnFiltro[1]"),//encurso
												  		RequestVar.get("btnFiltro[2]"),//aprobado
												  		RequestVar.get("btnFiltro[3]"),//cancelado
												  		RequestVar.get("deposito_id")
												  		),d));
	}
	
	@CheckPermiso(key = "presupuestosVer")
	public static Result ver(Long id) {
		Presupuesto p = Presupuesto.find.byId(id);
		if(p != null){
			
			if(!p.controlPermisoDeposito()) {
				flash("error", "La institucion del presupuesto no corresponde a su institucion asignada.");
				return redirect(controllers.recupero.routes.PresupuestosController.index()+UriTrack.get("?"));
			}
			
			Form<Presupuesto> presupuestoForm = form(Presupuesto.class).fill(p);
			return ok(verPresupuesto.render(presupuestoForm, p));
		}else{
			flash("error", "No se encuentra el presupuesto.");
			return redirect(controllers.recupero.routes.PresupuestosController.index()+UriTrack.get("?"));
		}
	}
	
	@CheckPermiso(key = "presupuestosCrear")
	public static Result crear() {
		
		Map<String,String> p = new HashMap<String, String>();
		p.put("nombre","PRE");
		Form<Presupuesto> presupuestoForm = form(Presupuesto.class).bind(p);
		presupuestoForm.discardErrors();
		
		return ok(crearPresupuesto.render(presupuestoForm));
	}
	
	@CheckPermiso(key = "presupuestosCrear")
	public static Result guardar() {
		
		Form<Presupuesto> presupuestoForm = form(Presupuesto.class).bindFromRequest();
		
		if(presupuestoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearPresupuesto.render(presupuestoForm));
		}
		
		try {
			Presupuesto c = presupuestoForm.get();
			
			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return badRequest(crearPresupuesto.render(presupuestoForm));
			}
			
			c.create_date = new Date();
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.save();
			
			flash("success", "El presupuesto se ha creado");
			return redirect( controllers.recupero.routes.PresupuestosController.ver(presupuestoForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el presupuesto");
			return badRequest(crearPresupuesto.render(presupuestoForm));
		}
	}
	
	@CheckPermiso(key = "presupuestosModificar")
	public static Result editar(Long id) {
		Presupuesto presupuesto = Presupuesto.find.byId(id);
		
		if(presupuesto  == null){
			flash("error", "No se encuentra el presupuesto.");
			return redirect(controllers.recupero.routes.PresupuestosController.index()+UriTrack.get("?"));
		}else if(presupuesto.estado_id == Estado.PRESUPUESTO_APROBADO || presupuesto.estado_id == Estado.PRESUPUESTO_CANCELADO ){
			flash("error", "El presupuesto no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}else if(!presupuesto.controlPermisoDeposito()) {
			flash("error", "La institucion del presupuesto no corresponde a su institucion asignada.");
			return redirect(controllers.recupero.routes.PresupuestosController.index()+UriTrack.get("?"));
		}
		
		
		return ok(editarPresupuesto.render(presupuestoForm.fill(presupuesto),presupuesto));
	}
	
	
	@CheckPermiso(key = "presupuestosModificar")
	public static Result actualizar(Long id){
		
		Form<Presupuesto> presupuestoForm = form(Presupuesto.class).bindFromRequest();
		
		Presupuesto presupuesto = Ebean.find(Presupuesto.class, id);
		
		if(presupuestoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarPresupuesto.render(presupuestoForm,presupuesto));
		}
		
		try {
			Presupuesto c = presupuestoForm.get();
			
			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return badRequest(editarPresupuesto.render(presupuestoForm,presupuesto));
			}
			
			c.estado_id = presupuesto.estado_id;
			c.write_date = new Date();
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.update();
			flash("success", "El presupuesto se ha actualizado");
			return redirect( controllers.recupero.routes.PresupuestosController.ver(presupuestoForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el presupuesto");
			return badRequest(editarPresupuesto.render(presupuestoForm,presupuesto));
		}
	}
	
	@CheckPermiso(key = "presupuestosEliminar")
	public static Result eliminar(Long id) {
		
		Presupuesto presupuesto = Ebean.find(Presupuesto.class).select("id, estado_id").setId(id).findUnique();
		
		if(presupuesto == null){
			flash("error", "No se encuentra el presupuesto.");
			return redirect(controllers.recupero.routes.PresupuestosController.index()+UriTrack.get("?"));
		}
		
		if(presupuesto.estado_id == Estado.PRESUPUESTO_BORRADOR || presupuesto.estado_id == Estado.PRESUPUESTO_CANCELADO){
			try {
				presupuesto.delete();
				flash("success", "Se ha eliminado el presupuesto");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar el presupuesto");
			}
		} else {
			flash("error", "No se ha podido eliminar el presupuesto. Unicamente se puede eliminar cuando el estado del presupuesto se encuentra en borrador o cancelado.");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	@CheckPermiso(key = "presupuestosDuplicar")
	public static Result duplicar(Long id) {
		try {
			
			Presupuesto c = new Presupuesto();
			
			Long idNew = c.duplicar(id);
			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha duplicado el presupuesto");
				return redirect(controllers.recupero.routes.PresupuestosController.editar(idNew) + UriTrack.get("&"));
			}else{
				flash("error", "No se ha podido duplicar el presupuesto");
				String refererUrl = request().getHeader("referer");
				return redirect(refererUrl);
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido duplicar el presupuesto");
		}
		
		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	public static Result cambiarEstado(Long idPresupuesto, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_PRESUPUESTO);
		
		Presupuesto presupuesto = Presupuesto.find.byId(idPresupuesto);
		
		if(!presupuesto.controlPermisoDeposito()) {
			flash("error", "La institucion no corresponde a su institucion asignada.");
			return badRequest(controllers.recupero.routes.PresupuestosController.index()+UriTrack.get("?"));
		}
		
		if(presupuesto == null){
			flash("error", "No se encuentra el presupuesto.");
			return redirect(request().getHeader("referer"));
		}
		
		if((presupuesto.presupuestoLinea.isEmpty()) && (idEstado != Estado.PRESUPUESTO_CANCELADO && idEstado != Estado.PRESUPUESTO_BORRADOR)){
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(request().getHeader("referer"));
		}
		
		/*Integer sl = CertificacionLinea.find.where().eq("certificacion_id",certificacion.id).isNull("cuenta_analitica_id").findRowCount();
		if(sl > 0 ){
			flash("error", "No puede cambiar de estado con lineas que no contengan cuenta presupuestaria.");
			return redirect(request().getHeader("referer"));
		}*/
		
		if(idEstado != null){
			
			Boolean permiso = false;
			
			switch ( idEstado.intValue() ) {
		      case  Estado.PRESUPUESTO_BORRADOR:
		    	  if(!Permiso.check("presupuestosPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(presupuesto.id);
		    	  break;
		      case Estado.PRESUPUESTO_ENCURSO:
		    	  if(!Permiso.check("presupuestosPasarCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnCurso(presupuesto.id);
		    	  break;       
		      case Estado.PRESUPUESTO_APROBADO:
		    	  if(!Permiso.check("presupuestosPasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobado(presupuesto.id); 
		    	  break;
		      case Estado.PRESUPUESTO_CANCELADO:
		    	  if(!Permiso.check("presupuestosPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(presupuesto.id);   
		          break;
		      default:
		           break;
		      }
			  
		}	 
		
		return redirect(controllers.recupero.routes.PresupuestosController.ver(presupuesto.id)+ UriTrack.get("&"));
	}
	
	
	@CheckPermiso(key = "presupuestosPasarEnBorrador")
	public static void pasarEnBorrador(Long idPresupuesto){
		
		Presupuesto presupuesto = Ebean.find(Presupuesto.class).select("id, estado_id,write_date,write_usuario_id").setId(idPresupuesto).findUnique();
		
		if(presupuesto != null){			
			presupuesto.estado_id = new Long(Estado.PRESUPUESTO_BORRADOR);
			presupuesto.write_date = new Date();
			presupuesto.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			presupuesto.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	@CheckPermiso(key = "presupuestosPasarEnCurso")
	public static void pasarEnCurso(Long idPresupuesto){
		
		Presupuesto presupuesto = Ebean.find(Presupuesto.class).select("id, estado_id,write_date,write_usuario_id").setId(idPresupuesto).findUnique();
		
		if(presupuesto != null){			
			presupuesto.estado_id = new Long(Estado.PRESUPUESTO_ENCURSO);
			presupuesto.write_date = new Date();
			presupuesto.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			presupuesto.save();
			flash("success", "Operación exitosa. Estado actual: En Curso");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	@CheckPermiso(key = "presupuestosPasarAprobado")
	public static void pasarAprobado(Long idPresupuesto){
		
		Presupuesto presupuesto = Ebean.find(Presupuesto.class).select("id, estado_id,write_date,write_usuario_id").setId(idPresupuesto).findUnique();
		
		if(presupuesto != null){			
			presupuesto.estado_id = new Long(Estado.PRESUPUESTO_APROBADO);
			presupuesto.write_date = new Date();
			presupuesto.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			presupuesto.save();
			flash("success", "Operación exitosa. Estado actual: Aprobado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	@CheckPermiso(key = "presupuestosPasarCancelado")
	public static void pasarCancelado(Long idPresupuesto){
		
		Presupuesto presupuesto = Ebean.find(Presupuesto.class).select("id, estado_id,write_date,write_usuario_id").setId(idPresupuesto).findUnique();
		
		boolean certificacionOk = true;
		String error = "";
		/*Integer tieneFacturas = Factura.find.where().eq("certificacion_id",certificacion.id).findRowCount();
		if(tieneFacturas > 0){
			certificacionOk = false;
			error = "No se puede cancelar la certificación porque tiene facturas asociadas.";
		}*/
		
		if(presupuesto != null && certificacionOk){			
			presupuesto.estado_id = new Long(Estado.PRESUPUESTO_CANCELADO);
			presupuesto.write_date = new Date();
			presupuesto.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			presupuesto.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos. "+error);
		}

	}
	
}
