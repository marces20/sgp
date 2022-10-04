package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.LiquidacionTipo;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.liquidacionTipos.*;
	 
public class LiquidacionTiposController extends Controller {
	
	final static Form<LiquidacionTipo> liquidacionTipoForm = form(LiquidacionTipo.class);
	
	public static Result URL_LISTA_LIQUIDACION_TIPO = redirect(
			controllers.haberes.routes.LiquidacionTiposController.index()
	);
	
	@CheckPermiso(key = "liquidacionTipoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexLiquidacionTipo.render(
						LiquidacionTipo.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "liquidacionTipoCrear")
	public static Result crear() {
		Form<LiquidacionTipo> liquidacionTipoForm = form(LiquidacionTipo.class);
		return ok(crearLiquidacionTipo.render(liquidacionTipoForm));
	}
	
	@CheckPermiso(key = "liquidacionTipoCrear")
	public static Result guardar() {
		
		Form<LiquidacionTipo> liquidacionTipoForm = form(LiquidacionTipo.class).bindFromRequest();
		
		try {
			if(liquidacionTipoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearLiquidacionTipo.render(liquidacionTipoForm));
			} else {
				LiquidacionTipo lc = liquidacionTipoForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El tipo de liquidacion se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionTiposController.ver( liquidacionTipoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo de liquidacion");
			return badRequest(crearLiquidacionTipo.render(liquidacionTipoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionTipoEditar")
	public static Result editar(Long id) {
		LiquidacionTipo lc = Ebean.find(LiquidacionTipo.class, id);
		return ok(editarLiquidacionTipo.render(liquidacionTipoForm.fill(lc)));
	}
	
	@CheckPermiso(key = "liquidacionTipoEditar")
	public static Result actualizar(){
		
		Form<LiquidacionTipo> liquidacionTipoForm = form(LiquidacionTipo.class).bindFromRequest();
		
		try {
			
			if(liquidacionTipoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarLiquidacionTipo.render(liquidacionTipoForm));
			} else {
				LiquidacionTipo lc = liquidacionTipoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El tipo de liquidacion se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionTiposController.ver( liquidacionTipoForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo de liquidacion");
			return badRequest(editarLiquidacionTipo.render(liquidacionTipoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionTipoEliminar")
	public static Result eliminar(Long id) {
		try {
			LiquidacionTipo.find.byId(id).delete();
			flash("success", "Se ha eliminado el tipo de liquidacion");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el tipo de liquidacion");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "liquidacionTipoVer")
	public static Result ver(Long id) throws IOException {
		LiquidacionTipo lc = LiquidacionTipo.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el tipo de liquidacion.");
			return URL_LISTA_LIQUIDACION_TIPO;
		}
		
		return ok(verLiquidacionTipo.render(liquidacionTipoForm.fill(lc),lc));
	}
	
	public static Result suggestLiquidacionTipo(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode liquidacionTipo = rpta.arrayNode();
	    
	    LiquidacionTipo lc = new LiquidacionTipo();
		 
		for(LiquidacionTipo a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        liquidacionTipo.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", liquidacionTipo);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		LiquidacionTipo lc = LiquidacionTipo.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el tipo de liquidacion");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<LiquidacionTipo> p = new Pagination<LiquidacionTipo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(LiquidacionTipo.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaLiquidacionTipo.render(p, form().bindFromRequest()) );
	}
	
}
