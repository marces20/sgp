package controllers.compras;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import models.Categoria;
import models.Expediente;
import models.Solicitud;
import models.Usuario;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.compras.productos.crearCategoria;
import views.html.compras.productos.editarCategoria;
import views.html.compras.productos.indexCategoria;
import views.html.compras.solicitudes.indexSolicitud;
import views.html.compras.productos.modalBusquedaCategoria;

@Security.Authenticated(Secured.class)
public class CategoriasController extends Controller {
	final static Form<Categoria> categoriaForm = form(Categoria.class);
	
	public static Result URL_LISTA_CATEGORIA = redirect(
			controllers.compras.routes.CategoriasController.indexCategoria()
	);
	
	@CheckPermiso(key = "productosCategoriaGeneral")
	public static Result indexCategoria() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexCategoria.render(
						Categoria.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "productosCategoriaGeneral")
	public static Result crearCategoria() {
		Form<Categoria> categoriaForm = form(Categoria.class);
		return ok(crearCategoria.render(categoriaForm));
	}
	
	@CheckPermiso(key = "productosCategoriaGeneral")
	public static Result guardarCategoria() {
		Form<Categoria> categoriaForm = form(Categoria.class).bindFromRequest();
		try {
			
			if(categoriaForm.field("parent_categoria.id").value().isEmpty()){
				categoriaForm.reject("parent_categoria.id","La categoria padre es obligatoria.");
			}
			
			if(categoriaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearCategoria.render(categoriaForm));
			} else {
				Categoria c = categoriaForm.get();
				c.create_date = new Date();
				c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				c.save();
				flash("success", "La categoria ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la categoria");
			return badRequest(crearCategoria.render(categoriaForm));
		}
		
		return URL_LISTA_CATEGORIA;
	}
	
	@CheckPermiso(key = "productosCategoriaGeneral")
	public static Result editarCategoria(Long id) {
		Categoria categoria = Ebean.find(Categoria.class, id);
		
		return ok(editarCategoria.render(categoriaForm.fill(categoria)));
	}
	
	@CheckPermiso(key = "productosCategoriaGeneral")
	public static Result actualizarCategoria(){
		
		Form<Categoria> categoriaForm = form(Categoria.class).bindFromRequest();
		try {
			
			if(categoriaForm.field("parent_categoria.id").value().isEmpty()){
				categoriaForm.reject("parent_categoria.id","La categoria padre es obligatoria.");
			}
			
			if(categoriaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarCategoria.render(categoriaForm));
			} else {
				Categoria c = categoriaForm.get();
				c.write_date = new Date();
				c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				c.update();
				flash("success", "La categoria se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la categoria");
			return badRequest(editarCategoria.render(categoriaForm));
		}
		return URL_LISTA_CATEGORIA;
	}
	
	@CheckPermiso(key = "productosCategoriaGeneral")
	public static Result eliminarCategoria(Long id) {
		try {
			Categoria.find.byId(id).delete();
			flash("success", "Se ha eliminado la categoria");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la categoria");
		}

		return URL_LISTA_CATEGORIA;
	}
	
	@CheckPermiso(key = "productosCategoriaGeneral")
	public static Result suggestCategoria(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode categoria = rpta.arrayNode();
	    
	    Categoria ad = new Categoria();
		 
		for(Categoria a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        categoria.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", categoria);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Categoria categoria = Categoria.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(categoria == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la categoria");
		} else {
			restJs.put("success", true);
			restJs.put("id", categoria.id);
			restJs.put("nombre", categoria.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Categoria> p = new Pagination<Categoria>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Categoria.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaCategoria.render(p, form().bindFromRequest()) );
	}
}
