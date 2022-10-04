package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.Certificacion;
import models.Estado;
import models.Usuario;
import models.auth.Permiso;
import models.haberes.LiquidacionBaseCalculo;
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
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.haberes.liquidacionBaseCalculos.modalBusquedaLiquidacionBaseCalculo;
import views.html.haberes.liquidacionPuestos.*;
import views.html.haberes.liquidacionPuestos.modales.modalPasarAprobado;

public class LiquidacionPuestosController extends Controller {
	
	final static Form<LiquidacionPuesto> liquidacionPuestoForm = form(LiquidacionPuesto.class);
	
	public static Result URL_LISTA_LIQUIDACION_PUESTO = redirect(
			controllers.haberes.routes.LiquidacionPuestosController.index()
	);
	
	@CheckPermiso(key = "liquidacionPuestoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		return ok(
				indexLiquidacionPuesto.render(
						LiquidacionPuesto.page(
								RequestVar.get("liquidacion_mes_id"),
								RequestVar.get("puesto_laboral_id"),
								RequestVar.get("btnFiltro[0]"),//borrador
								RequestVar.get("btnFiltro[1]"),//preaprobado
								RequestVar.get("btnFiltro[2]"),//aprobado
								RequestVar.get("btnFiltro[3]"),//cancelado
								RequestVar.get("categoria_laboral_id"),
								RequestVar.get("cm"),
								RequestVar.get("escala_laboral_id"),
								RequestVar.get("ganancias"),
								RequestVar.get("fecha_desde"),
								RequestVar.get("fecha_hasta")
								),
								 d, pf));
	}
	
	@CheckPermiso(key = "liquidacionPuestoCrear")
	public static Result crear() {
		Form<LiquidacionPuesto> liquidacionPuestoForm = form(LiquidacionPuesto.class);
		return ok(crearLiquidacionPuesto.render(liquidacionPuestoForm));
	}
	
	
	@CheckPermiso(key = "liquidacionPuestoCrear")
	public static Result guardar() {
		
		Form<LiquidacionPuesto> liquidacionPuestoForm = form(LiquidacionPuesto.class).bindFromRequest();
		
		try {
			if(liquidacionPuestoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearLiquidacionPuesto.render(liquidacionPuestoForm));
			} else {
				LiquidacionPuesto lc = liquidacionPuestoForm.get();
				lc.estado_id = (long) Estado.LIQUIDACION_PUESTOS_BORRADOR;
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "La liquidacion puesto se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionPuestosController.ver( liquidacionPuestoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la liquidacion puesto.");
			return badRequest(crearLiquidacionPuesto.render(liquidacionPuestoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionPuestoEditar")
	public static Result editar(Long id) {
		LiquidacionPuesto lc = Ebean.find(LiquidacionPuesto.class, id);
		if(lc.estado_id != Estado.LIQUIDACION_PUESTOS_BORRADOR){
			flash("error", "La liquidacion no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}										
		
		return ok(editarLiquidacionPuesto.render(liquidacionPuestoForm.fill(lc)));
	}
	
	@CheckPermiso(key = "liquidacionPuestoEditar")
	public static Result actualizar(){
		
		Form<LiquidacionPuesto> liquidacionPuestoForm = form(LiquidacionPuesto.class).bindFromRequest();
		
		try {
			
			if(liquidacionPuestoForm.hasErrors()) {
				flash("error", "Error en formulario" + liquidacionPuestoForm.errors());
				return badRequest(editarLiquidacionPuesto.render(liquidacionPuestoForm));
			} else {
				LiquidacionPuesto lc = liquidacionPuestoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "La liquidacion puesto se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionPuestosController.ver( liquidacionPuestoForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la liquidacion puesto");
			return badRequest(editarLiquidacionPuesto.render(liquidacionPuestoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionPuestoEliminar")
	public static Result eliminar(Long id) {
		try {
			LiquidacionPuesto lc = LiquidacionPuesto.find.byId(id);
			if(lc.estado_id != Estado.LIQUIDACION_PUESTOS_BORRADOR){
				flash("error", "La liquidacion no se puede eliminar en este Estado. Debe cambiar su estado a borrador.");
				return redirect(request().getHeader("referer"));
			}										
			
			
			LiquidacionPuesto.find.byId(id).delete();
			flash("success", "Se ha eliminado la liquidacion puesto");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la liquidacion puesto ");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "liquidacionPuestoVer")
	public static Result ver(Long id) throws IOException {
		LiquidacionPuesto lc = LiquidacionPuesto.find
								.fetch("liquidacionMes","nro_liquidacion_parque")
								.fetch("puestoLaboral.legajo.agente","apellido")
								.where().eq("id", id).findUnique();

		if(lc == null){
			flash("error", "No se encuentra la liquidacion puesto.");
			return URL_LISTA_LIQUIDACION_PUESTO;
		}
		
		return ok(verLiquidacionPuesto.render(liquidacionPuestoForm.fill(lc),lc, new PaginadorFicha(UriTrack.code())));
	}
	
	public static Result suggestLiquidacionPuesto(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode liquidacionPuesto = rpta.arrayNode();
	    
	    LiquidacionPuesto lc = new LiquidacionPuesto();
		 
		for(LiquidacionPuesto a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.liquidacionMes.nro_liquidacion_parque);
	        liquidacionPuesto.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", liquidacionPuesto);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		LiquidacionPuesto lc = LiquidacionPuesto.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la liquidacion");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.liquidacionMes.nro_liquidacion_parque);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<LiquidacionPuesto> p = new Pagination<LiquidacionPuesto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(LiquidacionPuesto.find.where().ilike("nro_liq_parque", "%" + RequestVar.get("nro_liq_parque") + "%"));
		return ok(modalBusquedaLiquidacionPuesto.render(p, form().bindFromRequest()) );
	}
	
	public static Result cambiarEstado(Long idLiquidacionPuesto, Long idEstado) throws IOException{
		Boolean permiso = false;
		
		LiquidacionPuesto lc = LiquidacionPuesto.find.where().eq("id", idLiquidacionPuesto).findUnique();
		if(lc.liquidacionMes.estado_id != Estado.LIQUIDACION_MES_APROBADO) {
			switch ( idEstado.intValue() ) {
		      case  Estado.LIQUIDACION_PUESTOS_BORRADOR:
		    	  if(!Permiso.check("liquidacionPuestoPasarABorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(idLiquidacionPuesto);
		    	  break;
		      case Estado.LIQUIDACION_PUESTOS_PREAPROBADO:
		    	  if(!Permiso.check("liquidacionPuestoPasarAPreaprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarPreaprobado(idLiquidacionPuesto);
		    	  break;       
		      case Estado.LIQUIDACION_PUESTOS_APROBADO:
		    	  if(!Permiso.check("liquidacionPuestoPasarAAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobado(idLiquidacionPuesto); 
		    	  break;
		      case Estado.LIQUIDACION_PUESTOS_CANCELADO:
		    	  if(!Permiso.check("liquidacionPuestoPasarACancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(idLiquidacionPuesto);   
		          break;
		      default:
		           break;
		      } 
		}else {
			flash("error", "No se puede cambiar de estado las liquidaciones cuando la liquidacion esta en estado APROBADA.");
		}
	    
		return redirect(controllers.haberes.routes.LiquidacionPuestosController.ver(idLiquidacionPuesto)+ UriTrack.get("&"));
	}
	
	public static void pasarEnBorrador(Long idLiquidacionPuesto){
		
		LiquidacionPuesto lp = Ebean.find(LiquidacionPuesto.class).select("id, estado_id").setId(idLiquidacionPuesto).findUnique();
		
		if(lp != null){			
			lp.estado_id = new Long(Estado.LIQUIDACION_PUESTOS_BORRADOR);
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	public static void pasarPreaprobado(Long idLiquidacionPuesto){
		
		LiquidacionPuesto lp = Ebean.find(LiquidacionPuesto.class).select("id, estado_id").setId(idLiquidacionPuesto).findUnique();
		
		if(lp != null){			
			lp.estado_id = new Long(Estado.LIQUIDACION_PUESTOS_PREAPROBADO);
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Preaprobado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	public static void pasarAprobado(Long idLiquidacionPuesto){
		
		LiquidacionPuesto lp = Ebean.find(LiquidacionPuesto.class).select("id, estado_id").setId(idLiquidacionPuesto).findUnique();
		
		List<LiquidacionPuesto> lcx = LiquidacionPuesto.find.where()
				   .eq("id",idLiquidacionPuesto)
				   .isNotNull("puestoLaboral.legajo.agente.fbaja")
				   .findList();

		if(lcx.size() > 0) {
			String f = "";
			for(LiquidacionPuesto lcz : lcx) {
				f += lcz.puestoLaboral.legajo.agente.apellido+"<br>";
			}
			flash("error", "No se puede aprobar liquidaciones con fecha de baja en agentes.<br>"+f);
			 
		}else {
		
			if(lp != null){			
				lp.estado_id = new Long(Estado.LIQUIDACION_PUESTOS_APROBADO);
				lp.save();
				flash("success", "Operación exitosa. Estado actual: Aprobado");
			} else {
				flash("error", "Parámetros incorrectos");
			}
		}
	}
	
	public static void pasarCancelado(Long idLiquidacionPuesto){
		
		LiquidacionPuesto lp = Ebean.find(LiquidacionPuesto.class).select("id, estado_id").setId(idLiquidacionPuesto).findUnique();
		
		if(lp != null){			
			lp.estado_id = new Long(Estado.LIQUIDACION_PUESTOS_CANCELADO);
			lp.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	@CheckPermiso(key = "liquidacionMesPreliquidar")
	public static Result preLiquidar(Long idPuestoLaboral,Long idLiquidacionMes,Long idLiquidacionPuesto) throws SQLException{
		
		boolean c = LiquidacionMes.controlLiquidacionesActivas();
		LiquidacionPuesto lp = LiquidacionPuesto.find.where().eq("puesto_laboral_id", idPuestoLaboral).eq("liquidacion_mes_id", idLiquidacionMes).findUnique();
		Long idNew = lp.id;
		try {
			if(!c) {
				int idControl = new LiquidacionMes().controlLiquidacion(idPuestoLaboral,idLiquidacionMes);
				idNew  = new LiquidacionMes().preliquidar(idPuestoLaboral,idLiquidacionMes,idControl);
				
			}else {
				flash("error", "HAY PUESTO LIQUIDANDOSE SOLO SE PUEDE LIQUIDAR UN PUESTO A LA VEZ. ESPERE Y VUELVA A INTENTARLO. ");
			}
		}catch (SQLException e) {
			flash("error","ERROR: "+e);
			Logger.error("Error duplicar: "+e);
			return redirect(controllers.haberes.routes.LiquidacionPuestosController.ver(lp.id)+ UriTrack.get("&"));
        }
		
		Logger.debug("zzzzzzzzzzzzzzzzz "+idNew);
		
		return redirect(controllers.haberes.routes.LiquidacionPuestosController.ver(idNew)+ UriTrack.get("&"));
	}
	
}
