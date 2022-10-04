package controllers.compras;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Articulo;
import models.Categoria;
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

@Security.Authenticated(Secured.class)
public class ArticulosController extends Controller {
	
	final static Form<Articulo> articuloForm = form(Articulo.class);
	
	public static Result URL_LISTA_ARTICULO = redirect(
			controllers.compras.routes.ArticulosController.indexArticulo()
	);
	
	@CheckPermiso(key = "articulosGeneral")
	public static Result indexArticulo() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexArticulo.render(
						Articulo.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "articulosGeneral")
	public static Result crearArticulo() {
		Form<Articulo> articuloForm = form(Articulo.class);
		return ok(crearArticulo.render(articuloForm));
	}
	
	@CheckPermiso(key = "articulosGeneral")
	public static Result guardarArticulo() {
		
		Form<Articulo> articuloForm = form(Articulo.class).bindFromRequest();
		
		try {
			if(articuloForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearArticulo.render(articuloForm));
			} else {
				Articulo a = articuloForm.get();
				a.create_usuario_id  = new Long(Usuario.getUsuarioSesion());
				a.create_date =  new Date();
				a.save();
				flash("success", "El articulo se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el articulo");
			return badRequest(crearArticulo.render(articuloForm));
		}
		
		return URL_LISTA_ARTICULO;
	}
	
	@CheckPermiso(key = "articulosGeneral")
	public static Result editarArticulo(Long id) {
		Articulo articulo = Articulo.find.byId(id);
		
		return ok(editarArticulo.render(articuloForm.fill(articulo)));
	}
	
	@CheckPermiso(key = "articulosGeneral")
	public static Result actualizarArticulo(){
		
		Form<Articulo> articuloForm = form(Articulo.class).bindFromRequest();
		
		try {
			
			if(articuloForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarArticulo.render(articuloForm));
			} else {
				Articulo a = articuloForm.get();
				a.write_usuario_id  = new Long(Usuario.getUsuarioSesion());
				a.write_date = new Date();
				a.update();
				
				flash("success", "El articulo se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el articulo");
			return badRequest(editarArticulo.render(articuloForm));
		}
		return URL_LISTA_ARTICULO;
	}
	
	@CheckPermiso(key = "articulosGeneral")
	public static Result eliminarArticulo(Long id) {
		try {
			Articulo.find.byId(id).delete();
			flash("success", "Se ha eliminado el articulo");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el articulo");
		}

		return URL_LISTA_ARTICULO;
	}
	
	public static Result suggestArticulo(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode articulos = rpta.arrayNode();
	    
	    Articulo ad = new Articulo();
		 
		for(Articulo a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        articulos.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", articulos);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Articulo articulo = Articulo.find.select("id, nombre, descripcion").where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(articulo == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el Articulo");
		} else {
			restJs.put("success", true);
			restJs.put("id", articulo.id);
			restJs.put("nombre", articulo.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Articulo> p = new Pagination<Articulo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Articulo.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaArticulo.render(p, form().bindFromRequest()) );
	}
	
}
