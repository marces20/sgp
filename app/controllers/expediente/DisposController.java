package controllers.expediente;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.CertificacionCompra;
import models.CertificacionCompraLinea;
import models.Dispo;
import models.Estado;
import models.Expediente;
import models.ExpedienteMovimiento;
import models.Factura;
import models.Orden;
import models.Organigrama;
import models.Usuario;
import models.auth.Permiso;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NoRecordModelException;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.expediente.dispo.*; 

@Security.Authenticated(Secured.class)
public class DisposController extends Controller {
	
	final static Form<Dispo> dispoForm = form(Dispo.class);
	
	public static Result URL_INDEX_DISPO = redirect(
			controllers.expediente.routes.DisposController.index()  + UriTrack.get("&")
	);
	
	public static Result getDisposPorExpediente(Long expedienteId) {
		
		Pagination<Dispo> lineas = Dispo.page("",expedienteId.toString(),"","","","","","","");

		return ok(listaDispos.render(lineas, expedienteId));
	}
	
	@CheckPermiso(key = "dispoVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexDispo.render(Dispo.page(
												RequestVar.get("numero"), 
												RequestVar.get("expediente.id"),
												RequestVar.get("ejercicio"),
												RequestVar.get("fecha_desde"),
												RequestVar.get("fecha_hasta"),
												RequestVar.get("btnFiltro[0]"),//activa
												RequestVar.get("btnFiltro[1]"),//no activa
												RequestVar.get("organigrama_id"),
												RequestVar.get("desc")
												), d));
	}
	
	@CheckPermiso(key = "dispoCrear")
	public static Result crear() {
		Form<Dispo> form = form(Dispo.class);
		return ok(crearDispo.render(form));
	}
	
	@CheckPermiso(key = "dispoCrear")
	public static Result guardar() {
		
		Form<Dispo> form = form(Dispo.class).bindFromRequest();
		
		try {
			
			if(form.hasErrors()) {
				flash("error", "Error en formulario ");
				return badRequest(crearDispo.render(form));
			} else {
				Dispo dispo = form.get();
				dispo.estado_id = new Long(Estado.DISPO_ACTIVA);
				dispo.buscarDuplicado(dispo.expediente_id, dispo.numero,dispo.organigrama_id);
				dispo.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				dispo.create_date = new Date();
				dispo.save();
				flash("success", "La dispo se ha guardado.");
				return redirect( controllers.expediente.routes.DisposController.ver(dispo.id)+UriTrack.get("&") );
			}
			
			
		} catch(ConstraintViolationException  e){                                                         
			flash("error", "El número y ejercicio ya existe");    
			return badRequest(crearDispo.render(form));
        }  catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la dispo");
			return badRequest(crearDispo.render(form));
		}
	}
	
	@CheckPermiso(key = "dispoModificar")
	public static Result editar(Long id) {
		Dispo dipso = Dispo.find.byId(id);
		
		return ok(editarDispo.render(dispoForm.fill(dipso)));
	}
	
	@CheckPermiso(key = "dispoModificar")
	public static Result actualizar(){
		
		Form<Dispo> form = form(Dispo.class).bindFromRequest();
		
		if(form.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarDispo.render(form));
		}
		
		try {
			Dispo dispo = form.get();
			dispo.buscarDuplicado(dispo.expediente_id, dispo.numero,dispo.id,dispo.organigrama_id);
			dispo.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			dispo.write_date = new Date();
			dispo.update();
				
			flash("success", "El registro se ha actualizado");
			return redirect( controllers.expediente.routes.DisposController.ver(dispo.id) + UriTrack.get("&") );
		}catch(ConstraintViolationException  e){                                                         
			flash("error", "El número y ejercicio ya existe");    
			return badRequest(editarDispo.render(form));
        }  catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el registro");
			return badRequest(editarDispo.render(form));
		}
		 
		
	}
	
	@CheckPermiso(key = "dispoEliminar")
	public static Result eliminar(Long id) {
		try {
			Dispo.find.byId(id).delete();
			flash("success", "Se ha eliminado el registro");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el registro");
		}
		return redirect(request().getHeader("referer"));
	}
	
	
	@CheckPermiso(key = "dispoVer")
	public static Result ver(Long id) throws IOException {
		Dispo lc = Ebean.find(Dispo.class, id);
		
		if(lc == null){
			flash("error", "No se encuentra el expediente");
			return URL_INDEX_DISPO;
		}
		
		return ok(verDispo.render(dispoForm.fill(lc),lc));
	}
	
	
	
	public static Result getLastNumeroDispo(){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		
		
		if(request().body().asFormUrlEncoded().get("expediente_id") == null){
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
			nodo.add(restJs);
			return ok(restJs);
		}else{
			
			Long idExpediente = new Long(request().body().asFormUrlEncoded().get("expediente_id")[0]);
			Long idOrganigrama = new Long(request().body().asFormUrlEncoded().get("organigrama_id")[0]);
			Expediente ex = Expediente.find.byId(idExpediente);
			
			//Organigrama o = Organigrama.find.byId(idOrganigrama);
			
			String sql = "SELECT COALESCE((max(numero)+1)) as numero FROM dispos d "+
						 "inner join expedientes ex on ex.id = d.expediente_id "+
						 "WHERE ex.ejercicio_id = :ejercicio_id and d.organigrama_id= :organigrama_id ";
			SqlRow s = Ebean.createSqlQuery(sql)
					   .setParameter("ejercicio_id",ex.ejercicio_id)
					   .setParameter("organigrama_id",idOrganigrama)
					   .findUnique();
			
			if(s == null) {
				restJs.put("success", false);
				restJs.put("message", "No se encuentra la dispo");
			} else {
				restJs.put("success", true);
				restJs.put("numero", s.getInteger("numero"));
			}
			nodo.add(restJs);
			return ok(restJs);
		}
	}
	
	public static Result getLastNumeroDispoByOrden(){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		
		 
		if(request().body().asFormUrlEncoded().get("id_orden") == null){
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la orden");
			nodo.add(restJs);
			return ok(restJs);
		}else{
			
			Long idOrden = new Long(request().body().asFormUrlEncoded().get("id_orden")[0]);
			Orden o = Orden.find.byId(idOrden);
		 
			
			String sql = "SELECT COALESCE((max(numero)+1)) as numero FROM dispos d "+
						 "inner join expedientes ex on ex.id = d.expediente_id "+
						 " WHERE ex.ejercicio_id = :ejercicio_id and d.organigrama_id = :organigrama_id ";
			SqlRow s = Ebean.createSqlQuery(sql)
					  .setParameter("ejercicio_id",o.expediente.ejercicio_id)
					  .setParameter("organigrama_id",1)
					  .findUnique();
			
			if(s == null) {
				restJs.put("success", false);
				restJs.put("message", "No se encuentra la dispo");
			} else {
				restJs.put("success", true);
				restJs.put("numero", s.getInteger("numero"));
			}
			nodo.add(restJs);
			return ok(restJs);
		}
	}
	
	
	public static Result cambiarEstado(Long idDispo, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.DISPOS);
		
		Dispo dispo = Dispo.find.where().eq("id", idDispo).findUnique();
		
		if(dispo == null){
			flash("error", "No se encuentra la dispo.");
			return redirect(request().getHeader("referer"));
		}
		
		 
		
		if(idEstado != null){
			
			Boolean permiso = false;
			
			switch ( idEstado.intValue() ) {
		      
		      case Estado.DISPO_ACTIVA:
		    	  if(!Permiso.check("activarDispo")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarActivo(dispo.id); 
		    	  break;
		      case Estado.DISPO_DESACTIVA:
		    	  if(!Permiso.check("desactivarDispo")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarNoActivo(dispo.id);   
		          break;
		      default:
		           break;
		      }
			  
		}	 
		
		return redirect(controllers.expediente.routes.DisposController.ver(dispo.id)+ UriTrack.get("&"));
	}
	
	@CheckPermiso(key = "activarDispo")
	public static void pasarActivo(Long idDispo){
		
		Dispo dispo = Ebean.find(Dispo.class).select("id, estado_id,write_date,write_usuario_id").setId(idDispo).findUnique();
		
		boolean certificacionOk = true;
		String error = "";
		 
		
		if(dispo != null && certificacionOk){			
			dispo.estado_id = new Long(Estado.DISPO_ACTIVA);
			dispo.write_date = new Date();
			dispo.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			dispo.save();
			flash("success", "Operación exitosa. Estado actual: Activado");
		} else {
			flash("error", "Parámetros incorrectos. "+error);
		}

	}
	
	@CheckPermiso(key = "desactivarDispo")
	public static void pasarNoActivo(Long idDispo){
		
		Dispo dispo = Ebean.find(Dispo.class).select("id, estado_id,write_date,write_usuario_id").setId(idDispo).findUnique();
		
		boolean certificacionOk = true;
		String error = "";
		 
		
		if(dispo != null && certificacionOk){			
			dispo.estado_id = new Long(Estado.DISPO_DESACTIVA);
			dispo.write_date = new Date();
			dispo.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			dispo.save();
			flash("success", "Operación exitosa. Estado actual: Desactivado");
		} else {
			flash("error", "Parámetros incorrectos. "+error);
		}

	}
	
	
}
