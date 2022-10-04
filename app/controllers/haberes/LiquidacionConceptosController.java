package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.LiquidacionConcepto;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.liquidacionConceptos.*;

public class LiquidacionConceptosController extends Controller {
	
	final static Form<LiquidacionConcepto> liquidacionConceptoForm = form(LiquidacionConcepto.class);
	
	public static Result URL_LISTA_LIQUIDACION_CONCEPTO = redirect(
			controllers.haberes.routes.LiquidacionConceptosController.index()
	);
	
	@CheckPermiso(key = "liquidacionConceptoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexLiquidacionConcepto.render(
						LiquidacionConcepto.page(
								 RequestVar.get("codigo"),
								 RequestVar.get("denominacion")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "liquidacionConceptoCrear")
	public static Result crear() {
		Form<LiquidacionConcepto> liquidacionConceptoForm = form(LiquidacionConcepto.class);
		return ok(crearLiquidacionConcepto.render(liquidacionConceptoForm));
	}
	
	@CheckPermiso(key = "liquidacionConceptoCrear")
	public static Result guardar() {
		
		Form<LiquidacionConcepto> liquidacionConceptoForm = form(LiquidacionConcepto.class).bindFromRequest();
		
		try {
			if(liquidacionConceptoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearLiquidacionConcepto.render(liquidacionConceptoForm));
			} else {
				LiquidacionConcepto lc = liquidacionConceptoForm.get();
				
				List<LiquidacionConcepto> lcx = LiquidacionConcepto.find.where().eq("codigo",lc.codigo).findList();
				if(lcx.size() > 0) {
					flash("error", "Ya existe el codigo.");
					return badRequest(crearLiquidacionConcepto.render(liquidacionConceptoForm));
				}else {
				
				
					//b.create_date = new Date();
					//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					lc.save();
					flash("success", "El concepto se ha actualizado");
					return redirect( controllers.haberes.routes.LiquidacionConceptosController.ver( liquidacionConceptoForm.get().id ) + UriTrack.get("&"));
				}
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el concepto");
			return badRequest(crearLiquidacionConcepto.render(liquidacionConceptoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionConceptoEditar")
	public static Result editar(Long id) {
		LiquidacionConcepto lc = Ebean.find(LiquidacionConcepto.class, id);
		return ok(editarLiquidacionConcepto.render(liquidacionConceptoForm.fill(lc)));
	}
	
	@CheckPermiso(key = "liquidacionConceptoEditar")
	public static Result actualizar(){
		
		Form<LiquidacionConcepto> liquidacionConceptoForm = form(LiquidacionConcepto.class).bindFromRequest();
		
		try {
			
			if(liquidacionConceptoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarLiquidacionConcepto.render(liquidacionConceptoForm));
			} else {
				LiquidacionConcepto lc = liquidacionConceptoForm.get();
				
				List<LiquidacionConcepto> lcx = LiquidacionConcepto.find.where().ne("id", lc.id).eq("codigo",lc.codigo).findList();
				if(lcx.size() > 0) {
					flash("error", "Ya existe el codigo cargado en otro concepto.");
					return badRequest(crearLiquidacionConcepto.render(liquidacionConceptoForm));
				}else {
				
					//b.write_date = new Date();
					//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
					lc.update();
					flash("success", "El concepto se ha actualizado");
					return redirect( controllers.haberes.routes.LiquidacionConceptosController.ver( liquidacionConceptoForm.get().id ) + UriTrack.get("&"));
				}
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el concepto");
			return badRequest(editarLiquidacionConcepto.render(liquidacionConceptoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionConceptoEliminar")
	public static Result eliminar(Long id) {
		try {
			LiquidacionConcepto.find.byId(id).delete();
			flash("success", "Se ha eliminado el concepto");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el concepto");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "liquidacionConceptoVer")
	public static Result ver(Long id) throws IOException {
		LiquidacionConcepto lc = LiquidacionConcepto.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el concepto.");
			return URL_LISTA_LIQUIDACION_CONCEPTO;
		}
		
		return ok(verLiquidacionConcepto.render(liquidacionConceptoForm.fill(lc),lc));
	}
	
	public static Result suggestLiquidacionConceptoTipo(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode liquidacionConcepto = rpta.arrayNode();
	    
	    LiquidacionConcepto lc = new LiquidacionConcepto();
		 
		for(LiquidacionConcepto a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.codigo+"-"+a.denominacion);
	        restJs.put("info", a.codigo);
	        liquidacionConcepto.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", liquidacionConcepto);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		LiquidacionConcepto lc = LiquidacionConcepto.find.select("id, denominacion,codigo").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el concepto");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.denominacion);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<LiquidacionConcepto> p = new Pagination<LiquidacionConcepto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(LiquidacionConcepto.find.where()
    												.isNull("fecha_baja")
    												.ilike("denominacion", "%" + RequestVar.get("denominacion") + "%"));
		return ok(modalBusquedaLiquidacionConcepto.render(p, form().bindFromRequest()) );
	}
	
}
