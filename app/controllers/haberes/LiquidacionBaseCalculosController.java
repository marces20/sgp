package controllers.haberes;

import static play.data.Form.form;

import java.io.Console;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.LiquidacionBaseCalculo;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.StringUtils;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.liquidacionBaseCalculos.*;
	 
@SuppressWarnings("unused")
public class LiquidacionBaseCalculosController extends Controller {
	
	final static Form<LiquidacionBaseCalculo> liquidacionBaseCalculoForm = form(LiquidacionBaseCalculo.class);
	
	public static Result URL_LISTA_LIQUIDACION_BASE_CALCULO = redirect(
			controllers.haberes.routes.LiquidacionBaseCalculosController.index()
	);
	
	@CheckPermiso(key = "liquidacionBaseCalculoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexLiquidacionBaseCalculo.render(
						LiquidacionBaseCalculo.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "liquidacionBaseCalculoCrear")
	public static Result crear() {
		Form<LiquidacionBaseCalculo> liquidacionBaseCalculoForm = form(LiquidacionBaseCalculo.class);
		return ok(crearLiquidacionBaseCalculo.render(liquidacionBaseCalculoForm));
	}
	
	@CheckPermiso(key = "liquidacionBaseCalculoCrear")
	public static Result guardar() throws SQLException {
		
		Form<LiquidacionBaseCalculo> liquidacionBaseCalculoForm = form(LiquidacionBaseCalculo.class).bindFromRequest();
		
		try {
			if(liquidacionBaseCalculoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearLiquidacionBaseCalculo.render(liquidacionBaseCalculoForm));
			} else {
				LiquidacionBaseCalculo lc = liquidacionBaseCalculoForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				
				/*InterpretePostgres i = new InterpretePostgres(lc.nombre,lc.calculo, StringUtils.explode(lc.parametros, ","));
				i.generaFuncionSql();
				*/
				lc.save();
				
				
				
				flash("success", "La base calculo se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionBaseCalculosController.ver( liquidacionBaseCalculoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la base calculo");
			return badRequest(crearLiquidacionBaseCalculo.render(liquidacionBaseCalculoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionBaseCalculoEditar")
	public static Result editar(Long id) {
		LiquidacionBaseCalculo lc = Ebean.find(LiquidacionBaseCalculo.class, id);
													  	
		return ok(editarLiquidacionBaseCalculo.render(liquidacionBaseCalculoForm.fill(lc)));
	}
	
	@CheckPermiso(key = "liquidacionBaseCalculoEditar")
	public static Result actualizar(){
		
		Form<LiquidacionBaseCalculo> liquidacionBaseCalculoForm = form(LiquidacionBaseCalculo.class).bindFromRequest();
		
		try {
			
			if(liquidacionBaseCalculoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarLiquidacionBaseCalculo.render(liquidacionBaseCalculoForm));
			} else {
				LiquidacionBaseCalculo lc = liquidacionBaseCalculoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "La base calculo se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionBaseCalculosController.ver( liquidacionBaseCalculoForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la base calculo");
			return badRequest(editarLiquidacionBaseCalculo.render(liquidacionBaseCalculoForm));
		}
	}
	
	@CheckPermiso(key = "liquidacionBaseCalculoEliminar")
	public static Result eliminar(Long id) {
		try {
			LiquidacionBaseCalculo.find.byId(id).delete();
			flash("success", "Se ha eliminado la base calculo");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la base calculo");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "liquidacionBaseCalculoVer")
	public static Result ver(Long id) throws IOException {
		LiquidacionBaseCalculo lc = LiquidacionBaseCalculo.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra la base calculo.");
			return URL_LISTA_LIQUIDACION_BASE_CALCULO;
		}
		
		return ok(verLiquidacionBaseCalculo.render(liquidacionBaseCalculoForm.fill(lc),lc));
	}
	
	public static Result suggestLiquidacionBaseCalculo(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode liquidacionBaseCalculo = rpta.arrayNode();
	    
	    LiquidacionBaseCalculo lc = new LiquidacionBaseCalculo();
		 
		for(LiquidacionBaseCalculo a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        liquidacionBaseCalculo.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", liquidacionBaseCalculo);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		LiquidacionBaseCalculo lc = LiquidacionBaseCalculo.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la base calculo");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<LiquidacionBaseCalculo> p = new Pagination<LiquidacionBaseCalculo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(LiquidacionBaseCalculo.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaLiquidacionBaseCalculo.render(p, form().bindFromRequest()) );
	}
	
}
