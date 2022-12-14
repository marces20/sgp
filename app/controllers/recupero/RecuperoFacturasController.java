package controllers.recupero;

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
import models.Usuario;
import models.auth.Permiso;
import models.recupero.RecuperoFactura;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.recupero.recuperoFactura.*;
import views.html.recupero.recuperoPlanilla.crearPlanilla;

@Security.Authenticated(Secured.class)
public class RecuperoFacturasController extends Controller {
	
	final static Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class);
	
	public static Result URL_LISTA_RECUPEROFACTURA = redirect(
			controllers.recupero.routes.RecuperoFacturasController.index()
	);
	
	@CheckPermiso(key = "recuperoFacturasVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		
		return ok(indexRecuperoFactura.render(
											RecuperoFactura.page(
												  		RequestVar.get("nombre"),
												  		RequestVar.get("numero"),
													  	RequestVar.get("cliente_id"),
													  	RequestVar.get("fecha_desde"),
													  	RequestVar.get("fecha_hasta"),
												  		RequestVar.get("btnFiltro[0]"),//borrador
												  		RequestVar.get("btnFiltro[1]"),//encurso
												  		RequestVar.get("btnFiltro[2]"),//aprobado
												  		RequestVar.get("btnFiltro[3]"),//cancelado
												  		RequestVar.get("btnFiltro[4]"),//pagada
												  		RequestVar.get("puntoventa_id"),
												  		RequestVar.get("planilla_id"),
												  		RequestVar.get("deposito_id")
												  		  ),d));
	}
	
	@CheckPermiso(key = "recuperoFacturasVer")
	public static Result ver(Long id) {
		RecuperoFactura p = RecuperoFactura.find.byId(id);
		if(p != null){
			
			if(!p.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
			}
			
			Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class).fill(p);
			return ok(verRecuperoFactura.render(recuperoFacturaForm, p));
		}else{
			flash("error", "No se encuentra la factura.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}
	}
	
	@CheckPermiso(key = "recuperoFacturasCrear")
	public static Result crear() {
		
		Map<String,String> p = new HashMap<String, String>();
		p.put("nombre","RFAC");
		Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class).bind(p);
		recuperoFacturaForm.discardErrors();
		
		return ok(crearRecuperoFactura.render(recuperoFacturaForm));
	}
	
	@CheckPermiso(key = "recuperoFacturasCrear")
	public static Result guardar() {
		
		Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class).bindFromRequest();
		
		if(recuperoFacturaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearRecuperoFactura.render(recuperoFacturaForm));
		}
		
		try {
			RecuperoFactura c = recuperoFacturaForm.get();
			
			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return badRequest(crearRecuperoFactura.render(recuperoFacturaForm));
			}
			
			List<RecuperoFactura> cx = RecuperoFactura.find.where()
									   .eq("numero",c.numero)
									   .eq("puntoventa_id", c.puntoventa_id)
									   .eq("serie",c.serie).findList();
			
			if(cx.size() > 0) {
				flash("error", "Ya existe este numero de factura cargada.");
				return badRequest(crearRecuperoFactura.render(recuperoFacturaForm));
			}
			
			c.create_date = new Date();
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.save();
			
			flash("success", "La factura se ha creado");
			return redirect( controllers.recupero.routes.RecuperoFacturasController.ver(recuperoFacturaForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la factura");
			return badRequest(crearRecuperoFactura.render(recuperoFacturaForm));
		}
	}
	
	@CheckPermiso(key = "recuperoFacturasModificar")
	public static Result editar(Long id) {
		RecuperoFactura rp = RecuperoFactura.find.byId(id);
		
		if(rp  == null){
			flash("error", "No se encuentra la factura.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}else if(rp.estado_id == Estado.RECUPERO_FACTURA_APROBADO || rp.estado_id == Estado.RECUPERO_FACTURA_CANCELADO ){
			flash("error", "La factura no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}else if(!rp.controlPermisoDeposito()) {
			flash("error", "La planilla institucion no corresponde a su institucion asignada.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}
		
		return ok(editarRecuperoFactura.render(recuperoFacturaForm.fill(rp),rp));
	}
	
	@CheckPermiso(key = "recuperoFacturasModificar")
	public static Result actualizar(Long id){
		
		Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class).bindFromRequest();
		
		RecuperoFactura rp = Ebean.find(RecuperoFactura.class, id);
		
		if(recuperoFacturaForm.hasErrors()) {
			flash("error", "Error en formulario ");
			return badRequest(editarRecuperoFactura.render(recuperoFacturaForm,rp));
		}
		
		try {
			RecuperoFactura c = recuperoFacturaForm.get();
			
			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return badRequest(editarRecuperoFactura.render(recuperoFacturaForm,rp));
			}
			
			List<RecuperoFactura> cx = RecuperoFactura.find.where()
					   .eq("numero",c.numero)
					   .eq("puntoventa_id", c.puntoventa_id)
					   .eq("serie",c.serie).ne("id", c.id).findList();

			if(cx.size() > 0) {
				flash("error", "Ya existe este numero de factura cargada.");
				return badRequest(editarRecuperoFactura.render(recuperoFacturaForm,rp));
			}
			
			c.estado_id = rp.estado_id;
			c.write_date = new Date();
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.update();
			flash("success", "La factura se ha actualizado");
			return redirect( controllers.recupero.routes.RecuperoFacturasController.ver(recuperoFacturaForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la factura");
			return badRequest(editarRecuperoFactura.render(recuperoFacturaForm,rp));
		}
	}
	
	@CheckPermiso(key = "recuperoFacturasEliminar")
	public static Result eliminar(Long id) {
		
		RecuperoFactura rp = Ebean.find(RecuperoFactura.class).select("id, estado_id").setId(id).findUnique();
		
		if(rp == null){
			flash("error", "No se encuentra la factura.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}
		
		if(rp.pagos.size() > 0) {
			flash("error", "No se puede eliminar facturas con pagos.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}
		
		if(rp.estado_id == Estado.RECUPERO_FACTURA_BORRADOR || rp.estado_id == Estado.RECUPERO_FACTURA_CANCELADO){
			try {
				rp.delete();
				flash("success", "Se ha eliminado la factura");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar la factura");
			}
		} else {
			flash("error", "No se ha podido eliminar la factura. Unicamente se puede eliminar cuando el estado de la factura se encuentra en borrador o cancelado.");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	public static Result cambiarEstado(Long idFactura, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_PRESUPUESTO);
		
		RecuperoFactura rp = RecuperoFactura.find.byId(idFactura);
		
		if(!rp.controlPermisoDeposito()) {
			flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
			return badRequest(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}
		
		if(rp == null){
			flash("error", "No se encuentra la factura");
			return redirect(request().getHeader("referer"));
		}
		
		if((rp.recuperoFacturaLinea.isEmpty()) && (idEstado != Estado.RECUPERO_FACTURA_CANCELADO && idEstado != Estado.RECUPERO_FACTURA_BORRADOR)){
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(request().getHeader("referer"));
		}
		
		if(idEstado != null){
			
			Boolean permiso = false;
			
			switch ( idEstado.intValue() ) {
		      case  Estado.RECUPERO_FACTURA_BORRADOR:
		    	  if(!Permiso.check("recuperoFacturasPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  
		    	  if(!rp.pagos.isEmpty()) {
		  			flash("error", "No se puede pasar a borrador cuando hay pagos asociados.");
					return redirect(request().getHeader("referer"));
		    	  }
		    	  
		    	  pasarEnBorrador(rp.id);
		    	  break;
		      case Estado.RECUPERO_FACTURA_ENCURSO:
		    	  if(!Permiso.check("recuperoFacturasPasarCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnCurso(rp.id);
		    	  break;       
		      case Estado.RECUPERO_FACTURA_APROBADO:
		    	  if(!Permiso.check("recuperoFacturasPasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobado(rp.id); 
		    	  break;
		      case Estado.RECUPERO_FACTURA_CANCELADO:
		    	  if(!Permiso.check("recuperoFacturasPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  
		    	  if(!rp.pagos.isEmpty()) {
		  			flash("error", "No se puede cancelar cuando hay pagos asociados.");
					return redirect(request().getHeader("referer"));
		    	  }
		    	  
		    	  pasarCancelado(rp.id);   
		          break;
		      default:
		           break;
		      }
			  
		}	 
		
		return redirect(controllers.recupero.routes.RecuperoFacturasController.ver(rp.id)+ UriTrack.get("&"));
	}
	
	@CheckPermiso(key = "recuperoFacturasPasarEnBorrador")
	public static void pasarEnBorrador(Long idRf){
		
		RecuperoFactura rf = Ebean.find(RecuperoFactura.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();
		
		if(rf != null){			
			rf.estado_id = new Long(Estado.RECUPERO_FACTURA_BORRADOR);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operaci??n exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Par??metros incorrectos");
		}
	}
	
	@CheckPermiso(key = "recuperoFacturasPasarEnCurso")
	public static void pasarEnCurso(Long idRf){
		
		RecuperoFactura rf = Ebean.find(RecuperoFactura.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();
		
		if(rf != null){			
			rf.estado_id = new Long(Estado.RECUPERO_FACTURA_ENCURSO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operaci??n exitosa. Estado actual: En Curso");
		} else {
			flash("error", "Par??metros incorrectos");
		}
	}
	
	@CheckPermiso(key = "recuperoFacturasPasarAprobado")
	public static void pasarAprobado(Long idRf){
		
		RecuperoFactura rf = Ebean.find(RecuperoFactura.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();
		
		if(rf != null){			
			rf.estado_id = new Long(Estado.RECUPERO_FACTURA_APROBADO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operaci??n exitosa. Estado actual: Aprobado");
		} else {
			flash("error", "Par??metros incorrectos");
		}
	}
	
	@CheckPermiso(key = "recuperoFacturasPasarCancelado")
	public static void pasarCancelado(Long idRf){
		
		RecuperoFactura rf = Ebean.find(RecuperoFactura.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();
		
		boolean certificacionOk = true;
		String error = "";
		
		if(rf != null && certificacionOk){			
			rf.estado_id = new Long(Estado.RECUPERO_FACTURA_CANCELADO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operaci??n exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Par??metros incorrectos. "+error);
		}
	}	
	
}
