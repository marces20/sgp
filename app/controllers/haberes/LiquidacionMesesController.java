package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.commons.mail.EmailException;

import models.Estado;
import models.Factura;
import models.Solicitud;
import models.Usuario;
import models.auth.Permiso;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionMes;
import models.haberes.LiquidacionPuesto;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.haberes.liquidacionMeses.crearLiquidacionMes;
import views.html.haberes.liquidacionMeses.editarLiquidacionMes;
import views.html.haberes.liquidacionMeses.indexLiquidacionMes;
import views.html.haberes.liquidacionMeses.modalBusquedaLiquidacionMes;
import views.html.haberes.liquidacionMeses.verLiquidacionMes;
import views.html.haberes.liquidacionPuestos.modales.modalPasarPreaprobado;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;

public class LiquidacionMesesController extends Controller {
	
	final static Form<LiquidacionMes> liquidacionMesForm = form(LiquidacionMes.class);
	
	public static Result URL_LISTA_LIQUIDACION_MES = redirect(
			controllers.haberes.routes.LiquidacionMesesController.index()
	);
	
	@CheckPermiso(key = "liquidacionMesIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexLiquidacionMes.render(
						LiquidacionMes.page(
								 RequestVar.get("nro_liquidacion_parque"),
								 RequestVar.get("expediente.id"),
								 RequestVar.get("periodo_id"),
								 RequestVar.get("numero_orden_pago_desde"),
								 RequestVar.get("numero_orden_pago_hasta"),
								 RequestVar.get("fecha_pago_desde"),
								 RequestVar.get("fecha_pago_hasta"),
								 RequestVar.get("cm")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "liquidacionMesCrear")
	public static Result crear() {
		Form<LiquidacionMes> liquidacionMesForm = form(LiquidacionMes.class);
		return ok(crearLiquidacionMes.render(liquidacionMesForm));
	}
	
	@CheckPermiso(key = "liquidacionMesCrear")
	public static Result guardar() {
		
		Form<LiquidacionMes> liquidacionMesForm = form(LiquidacionMes.class).bindFromRequest();
		
		try {
			if(liquidacionMesForm.hasErrors()) {
				flash("error", "Error en formulario ");
				return badRequest(crearLiquidacionMes.render(liquidacionMesForm));
			} else {
				LiquidacionMes lc = liquidacionMesForm.get();
				lc.estado_id = (long) Estado.LIQUIDACION_MES_BORRADOR;
				lc.create_date = new Date();
				lc.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "La liquidacion se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionMesesController.ver( liquidacionMesForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			//play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la liquidacion.");
			return badRequest(crearLiquidacionMes.render(liquidacionMesForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionMesEditar")
	public static Result editar(Long id) {
		LiquidacionMes lc = Ebean.find(LiquidacionMes.class, id);
		
		if(lc.estado_id == Estado.LIQUIDACION_MES_APROBADO || lc.estado_id == Estado.LIQUIDACION_MES_CANCELADO){
			flash("error", "La liquidacion no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}
		return ok(editarLiquidacionMes.render(liquidacionMesForm.fill(lc)));
	}
	
	@CheckPermiso(key = "liquidacionMesEditar")
	public static Result actualizar(){
		
		Form<LiquidacionMes> liquidacionMesForm = form(LiquidacionMes.class).bindFromRequest();
		
		try {
			
			if(liquidacionMesForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarLiquidacionMes.render(liquidacionMesForm));
			} else {
				LiquidacionMes lc = liquidacionMesForm.get();
				lc.write_date = new Date();
				lc.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "La liquidacion mes se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionMesesController.ver( liquidacionMesForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la liquidacion.");
			return badRequest(editarLiquidacionMes.render(liquidacionMesForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionMesEliminar")
	public static Result eliminar(Long id) {
		try {
			LiquidacionMes lm = Ebean.find(LiquidacionMes.class).select("id").setId(id).findUnique();
			lm.delete();
			flash("success", "Se ha eliminado la liquidacion mes");
			return URL_LISTA_LIQUIDACION_MES;
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la liquidacion.");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "liquidacionMesVer")
	public static Result ver(Long id) throws IOException {
		LiquidacionMes lc = LiquidacionMes.find.byId(id);
		List<SqlRow> dataPorConcepto = LiquidacionMes.getDataPorConcepto(id);
		if(lc == null){
			flash("error", "No se encuentra la liquidación.");
			return URL_LISTA_LIQUIDACION_MES;
		}
		
		return ok(verLiquidacionMes.render(liquidacionMesForm.fill(lc),lc,dataPorConcepto));
	}
	
	public static Result suggestLiquidacionMes(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode liquidacionMes = rpta.arrayNode();
	    
	    LiquidacionMes lc = new LiquidacionMes();
		 
		for(LiquidacionMes a : lc.getDataSuggest(input, 25)){
			
			String cm = (a.convenio_ministerio)?"Convenio":"Parque";
			
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value","N° "+a.nro_liquidacion_parque+" - "+cm);
	        liquidacionMes.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", liquidacionMes);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		LiquidacionMes lc = LiquidacionMes.find.select("id, nro_liquidacion_parque,convenio_ministerio").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la liquidacion.");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nro_liquidacion_parque);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<LiquidacionMes> p = new Pagination<LiquidacionMes>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	ExpressionList<LiquidacionMes> e = LiquidacionMes.find
    			.select("id,nro_liquidacion_parque,convenio_ministerio,titulo,periodo_id")
    			.fetch("periodo", "nombre")
    			.where();
    			
    	if(!RequestVar.get("nro_liquidacion_parque").isEmpty()){
    		e.eq("nro_liquidacion_parque", Integer.parseInt(RequestVar.get("nro_liquidacion_parque")));
    	}
    	
    	p.setExpressionList(e);
		return ok(modalBusquedaLiquidacionMes.render(p, form().bindFromRequest()) );
	}
	
	@CheckPermiso(key = "liquidacionMesPreliquidar")
	public static Result preliquidar(Long id) throws EmailException{
		
		try {
			String host = request().host(); 
			LiquidacionMes lm = LiquidacionMes.find.byId(id);
			Long userLogin =  new Long(Usuario.getUsuarioSesion());
			Long idNew = lm.preliquidar(id,host);
			//List<SqlRow> dataPorConcepto = LiquidacionMes.getDataPorConcepto(id);
			
			flash("success", "Se ha preliquidado correctamente");
			
			String refererUrl = request().getHeader("referer");
			return redirect(refererUrl);
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido preliquidar");
			String refererUrl = request().getHeader("referer");
			return redirect(refererUrl);
		}
	}
	
	public static Result cambiarEstado(Long idLiquidacion, Long idEstado) throws IOException{
		Boolean permiso = false;
		
		switch ( idEstado.intValue() ) {
	      case  Estado.LIQUIDACION_MES_BORRADOR:
	    	  if(!Permiso.check("liquidacionMesPasarABorrador")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarEnBorrador(idLiquidacion);
	    	  break;
	      case Estado.LIQUIDACION_MES_PRELIQUIDAR:
	    	  if(!Permiso.check("liquidacionMesPasarAAprobado")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarPreliquidar(idLiquidacion); 
	      break;	 
	      case Estado.LIQUIDACION_MES_LIQUIDADO:
	    	  if(!Permiso.check("liquidacionMesPasarAAprobado")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarLiquidado(idLiquidacion); 
	      break;
	      case Estado.LIQUIDACION_MES_APROBADO:
	    	  if(!Permiso.check("liquidacionMesPasarAAprobado")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarAprobado(idLiquidacion); 
	    	  break;
	      case Estado.LIQUIDACION_MES_CERRADA:
	    	  if(!Permiso.check("liquidacionMesPasarACerrado")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarCerrado(idLiquidacion); 
	    	  break;	  
	      case Estado.LIQUIDACION_MES_CANCELADO:
	    	  
	    	  List<Solicitud> sl = Solicitud.find.where().eq("liquidacion_mes_id", idLiquidacion).findList();
	    	  if(sl.size() > 0){
	    		  flash("error", "Nose puede Cancelar, tiene solicitudes asociadas.");
	    		  return redirect(controllers.haberes.routes.LiquidacionMesesController.ver(idLiquidacion)+ UriTrack.get("&"));
	    	  }
	    	  
	    	  List<Factura> fl = Factura.find.where().eq("liquidacion_mes_id", idLiquidacion).findList();
	    	  if(fl.size() > 0){
	    		  flash("error", "Nose puede Cancelar, tiene facturas asociadas.");
	    		  return redirect(controllers.haberes.routes.LiquidacionMesesController.ver(idLiquidacion)+ UriTrack.get("&"));
	    	  }
	    	  
	    	  if(!Permiso.check("liquidacionMesPasarACancelado")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarCancelado(idLiquidacion);   
	          break;
	      default:
	           break;
	      } 
	    
		return redirect(controllers.haberes.routes.LiquidacionMesesController.ver(idLiquidacion)+ UriTrack.get("&"));
	}
	
	public static void pasarEnBorrador(Long idLiquidacion){
		
		LiquidacionMes lp = Ebean.find(LiquidacionMes.class).select("id, estado_id").setId(idLiquidacion).findUnique();
		
		if(lp != null){			
			lp.write_date = new Date();
			lp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			lp.estado_id = new Long(Estado.LIQUIDACION_MES_BORRADOR);
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	public static void pasarAprobado(Long idLiquidacion){
		
		LiquidacionMes lp = Ebean.find(LiquidacionMes.class).select("id, estado_id,orden_pago_id,").setId(idLiquidacion).findUnique();
		
		List<LiquidacionPuesto> lc = LiquidacionPuesto.find.where()
				   .ne("estado_id",Estado.LIQUIDACION_PUESTOS_APROBADO)
				   .eq("liquidacionMes.id", idLiquidacion).findList();
		
		if(lc.size() > 0) {
			flash("error", "No se puede cambiar el estado de la liquidacion pq hay liquidaciones no aprobadas.");
			 
		}else {
			
			if(lp.orden_pago_id == null){
				flash("error", "Debe ingresa una Orden de pago. ");
			}else {
			
				if(lp != null){		
					lp.write_date = new Date();
					lp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
					lp.estado_id = new Long(Estado.LIQUIDACION_MES_APROBADO);
					lp.save();
					flash("success", "Operación exitosa. Estado actual: Aprobado");
				} else {
					flash("error", "Parámetros incorrectos");
				}
			}
		}
	}
	
	public static void pasarCerrado(Long idLiquidacion){
		
		LiquidacionMes lp = Ebean.find(LiquidacionMes.class).select("id, estado_id").setId(idLiquidacion).findUnique();
		
		
		if(lp != null){		
			lp.write_date = new Date();
			lp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			lp.estado_id = new Long(Estado.LIQUIDACION_MES_CERRADA);
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Cerrado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
		
	}
	
	public static void pasarPreliquidar(Long idLiquidacion){
		
		LiquidacionMes lp = Ebean.find(LiquidacionMes.class).select("id, estado_id").setId(idLiquidacion).findUnique();
		
		if(lp != null){		
			lp.write_date = new Date();
			lp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			lp.estado_id = new Long(Estado.LIQUIDACION_MES_PRELIQUIDAR);
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Preliquidar");
		} else {
			flash("error", "Parámetros incorrectos");
		}
		
	}
	
	public static void pasarLiquidado(Long idLiquidacion){
		
		LiquidacionMes lp = Ebean.find(LiquidacionMes.class).select("id, estado_id").setId(idLiquidacion).findUnique();
		
		if(lp != null){		
			lp.write_date = new Date();
			lp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			lp.estado_id = new Long(Estado.LIQUIDACION_MES_LIQUIDADO);
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Preliquidar");
		} else {
			flash("error", "Parámetros incorrectos");
		}
		
	}
	
	public static void pasarCancelado(Long idLiquidacion){
		
		LiquidacionMes lp = Ebean.find(LiquidacionMes.class).select("id, estado_id").setId(idLiquidacion).findUnique();
		
		if(lp != null){		
			lp.write_date = new Date();
			lp.fecha_preliquidacion = null;
			lp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			lp.estado_id = new Long(Estado.LIQUIDACION_MES_CANCELADO);
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}	
}
