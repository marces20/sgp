package controllers.compras;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Expediente;
import models.Solicitud;
import models.TipoProducto;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.compras.productos.*;
import views.html.compras.solicitudes.indexSolicitud;
import views.html.compras.productos.modalBusquedaTipoProducto;

@Security.Authenticated(Secured.class)
public class TipoProductosController extends Controller {
	
	final static Form<TipoProducto> tipoProductoForm = form(TipoProducto.class);
	
	public static Result URL_LISTA_TIPO_PRODUCTO = redirect(
			controllers.compras.routes.TipoProductosController.indexTipoProducto()
	);
	
	@CheckPermiso(key = "productosTipoGeneral")
	public static Result indexTipoProducto() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexTipoProducto.render(
						 TipoProducto.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "productosTipoGeneral")
	public static Result crearTipoProducto() {
		Form<TipoProducto> tipoProductoForm = form(TipoProducto.class);
		return ok(crearTipoProducto.render(tipoProductoForm));
	}
	
	@CheckPermiso(key = "productosTipoGeneral")
	public static Result guardarTipoProducto() {
		
		Form<TipoProducto> tipoProductoForm = form(TipoProducto.class).bindFromRequest();
		
		try {
			if(tipoProductoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearTipoProducto.render(tipoProductoForm));
			} else {
				TipoProducto t = tipoProductoForm.get();
				t.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				t.create_date = new Date();
				t.save();
				
				flash("success", "El tipo producto ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo de producto");
			return badRequest(crearTipoProducto.render(tipoProductoForm));
		}
		
		return URL_LISTA_TIPO_PRODUCTO;
	}
	
	@CheckPermiso(key = "productosTipoGeneral")
	public static Result editarTipoProducto(Long id) {
		TipoProducto tipoProducto = Ebean.find(TipoProducto.class, id);
		
		return ok(editarTipoProducto.render(tipoProductoForm.fill(tipoProducto)));
	}
	
	@CheckPermiso(key = "productosTipoGeneral")
	public static Result actualizarTipoProducto(){
		
		Form<TipoProducto> tipoProductoForm = form(TipoProducto.class).bindFromRequest();
		
		try {
			
			if(tipoProductoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarTipoProducto.render(tipoProductoForm));
			} else {
				TipoProducto t = tipoProductoForm.get();
				t.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				t.write_date = new Date();
				t.update();

				flash("success", "El tipo producto se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo producto");
			return badRequest(editarTipoProducto.render(tipoProductoForm));
		}
		return URL_LISTA_TIPO_PRODUCTO;
	}
	
	@CheckPermiso(key = "productosTipoGeneral")
	public static Result eliminarTipoProducto(Long id) {
		try {
			TipoProducto.find.byId(id).delete();
			flash("success", "Se ha eliminado el tipo producto");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el tipo producto");
		}

		return URL_LISTA_TIPO_PRODUCTO;
	}
	
	
	public static Result suggestTipoProducto(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode tipoProduto = rpta.arrayNode();
	    
	    TipoProducto ad = new TipoProducto();
		 
		for(TipoProducto a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        tipoProduto.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", tipoProduto);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		TipoProducto tipoProducto = TipoProducto.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(tipoProducto == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
		} else {
			restJs.put("success", true);
			restJs.put("id", tipoProducto.id);
			restJs.put("nombre", tipoProducto.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<TipoProducto> p = new Pagination<TipoProducto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(TipoProducto.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaTipoProducto.render(p, form().bindFromRequest()) );
	}
}
