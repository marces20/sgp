package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.LiquidacionConceptoTipo;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.liquidacionConceptoTipos.*;
	 
public class LiquidacionConceptoTiposController extends Controller {
	
	final static Form<LiquidacionConceptoTipo> liquidacionConceptoTipoForm = form(LiquidacionConceptoTipo.class);
	
	public static Result URL_LISTA_LIQUIDACION_CONCEPTO_TIPO = redirect(
			controllers.haberes.routes.LiquidacionConceptoTiposController.index()
	);
	
	@CheckPermiso(key = "liquidacionConceptoTipoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexLiquidacionConceptoTipo.render(
						LiquidacionConceptoTipo.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "liquidacionConceptoTipoCrear")
	public static Result crear() {
		Form<LiquidacionConceptoTipo> liquidacionTipoConceptoForm = form(LiquidacionConceptoTipo.class);
		return ok(crearLiquidacionConceptoTipo.render(liquidacionTipoConceptoForm));
	}
	
	@CheckPermiso(key = "liquidacionConceptoTipoCrear")
	public static Result guardar() {
		
		Form<LiquidacionConceptoTipo> liquidacionConceptoTipoForm = form(LiquidacionConceptoTipo.class).bindFromRequest();
		
		try {
			if(liquidacionConceptoTipoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearLiquidacionConceptoTipo.render(liquidacionConceptoTipoForm));
			} else {
				LiquidacionConceptoTipo lc = liquidacionConceptoTipoForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El tipo de concepto se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionConceptoTiposController.ver( liquidacionConceptoTipoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo de concepto");
			return badRequest(crearLiquidacionConceptoTipo.render(liquidacionConceptoTipoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionConceptoTipoEditar")
	public static Result editar(Long id) {
		LiquidacionConceptoTipo lc = Ebean.find(LiquidacionConceptoTipo.class, id);
		return ok(editarLiquidacionConceptoTipo.render(liquidacionConceptoTipoForm.fill(lc)));
	}
	
	@CheckPermiso(key = "liquidacionConceptoTipoEditar")
	public static Result actualizar(){
		
		Form<LiquidacionConceptoTipo> liquidacionConceptoTipoForm = form(LiquidacionConceptoTipo.class).bindFromRequest();
		
		try {
			
			if(liquidacionConceptoTipoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarLiquidacionConceptoTipo.render(liquidacionConceptoTipoForm));
			} else {
				LiquidacionConceptoTipo lc = liquidacionConceptoTipoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El tipo de concepto se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionConceptoTiposController.ver( liquidacionConceptoTipoForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo de concepto");
			return badRequest(editarLiquidacionConceptoTipo.render(liquidacionConceptoTipoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionConceptoTipoEliminar")
	public static Result eliminar(Long id) {
		try {
			LiquidacionConceptoTipo.find.byId(id).delete();
			flash("success", "Se ha eliminado el tipo de concepto");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el tipo de concepto");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "liquidacionConceptoTipoVer")
	public static Result ver(Long id) throws IOException {
		LiquidacionConceptoTipo lc = LiquidacionConceptoTipo.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el tipo de concepto.");
			return URL_LISTA_LIQUIDACION_CONCEPTO_TIPO;
		}
		
		return ok(verLiquidacionConceptoTipo.render(liquidacionConceptoTipoForm.fill(lc),lc));
	}
	
	public static Result suggestLiquidacionConceptoTipo(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode liquidacionConceptoTipo = rpta.arrayNode();
	    
	    LiquidacionConceptoTipo lc = new LiquidacionConceptoTipo();
		 
		for(LiquidacionConceptoTipo a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        liquidacionConceptoTipo.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", liquidacionConceptoTipo);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		LiquidacionConceptoTipo lc = LiquidacionConceptoTipo.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el tipo de concepto");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<LiquidacionConceptoTipo> p = new Pagination<LiquidacionConceptoTipo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(LiquidacionConceptoTipo.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaLiquidacionConceptoTipo.render(p, form().bindFromRequest()) );
	}
	
}
