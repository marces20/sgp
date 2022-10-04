package controllers.administracion;

import static play.data.Form.form;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import models.BalancePresupuestario;
import models.Usuario;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.administracion.usuarios.crearUsuario;
import views.html.administracion.usuarios.editarUsuario;
import views.html.administracion.usuarios.indexUsuario;
import views.html.administracion.usuarios.modalBusquedaUsuario;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Page;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class UsuariosController extends Controller {
	final static Form<Usuario> usuarioForm = form(Usuario.class);	
    public static Result URL_LISTA = redirect(
    	controllers.administracion.routes.UsuariosController.index()
    );
    
    @CheckPermiso(key = "usuariosVer")
    public static Result index() {		
		DynamicForm d = form().bindFromRequest();
		
		

		
		
		return ok(
				indexUsuario.render(
						 Usuario.page(
								 RequestVar.get("nombre"),
								 RequestVar.get("nick")
								 ),
								 d));

	}
	
	public static Result suggest(String input) {
		 
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		 
		for(Usuario usuario : Usuario.getDataSuggest(input, 10)){
			System.out.println(usuario.nombre);
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", usuario.id);
	        restJs.put("value",usuario.nombre);
	        restJs.put("info", "");
	        nodo.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", nodo);
		return ok(response);
	}
	
	public static Result get(int id){
		Usuario usuario = Usuario.find.select("id, nombre, nick").where().eq("id", id).eq("activo", true).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(usuario == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el usuario");
		} else {
			restJs.put("success", true);
			restJs.put("id", usuario.id);
			restJs.put("nombre", usuario.nombre);
			restJs.put("nick", usuario.nick);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Usuario> p = new Pagination<Usuario>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Usuario.find.where().eq("activo", true).ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaUsuario.render(p, form().bindFromRequest()) );
	}
	
	public static Result crear() {
		Form<Usuario> usuarioForm = form(Usuario.class);
		return ok(crearUsuario.render(usuarioForm));
	}
	
	@CheckPermiso(key = "usuariosCrear")
	public static Result guardar() {
		Form<Usuario> usuarioForm = form(Usuario.class).bindFromRequest();

		try {
			if(usuarioForm.hasErrors()) {
				 
				
				
				play.Logger.error("excepcion "+usuarioForm.errors());
				flash("error", "Error en formulario");
				return badRequest(crearUsuario.render(usuarioForm));
			} else {
				Usuario u = usuarioForm.get();
				u.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				u.create_date = new Date();
				u.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el registro.");
			return badRequest(crearUsuario.render(usuarioForm));
		}
		
		return URL_LISTA;
	}

	@CheckPermiso(key = "usuariosCrear")
	public static Result editar(int id) {
		Usuario usuario = Ebean.find(Usuario.class, id);

		return ok(editarUsuario.render(usuarioForm.fill(usuario)));
	}

	@CheckPermiso(key = "usuariosEliminar")
	public static Result eliminar(int id) {
		try {
			Usuario.find.byId(id).delete();
			flash("success", "Se ha eliminado el registro.");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el registro.");
		}

		return URL_LISTA;
	}

	@CheckPermiso(key = "usuariosCrear")
	public static Result actualizar() {
		Form<Usuario> usuarioForm = form(Usuario.class).bindFromRequest();
		Integer id = Integer.parseInt(usuarioForm.data().get("id"));

		if(usuarioForm.hasErrors()) {
			play.Logger.error("excepcion"+usuarioForm.errors());
			flash("error", "Error en formulario");
			return badRequest(editarUsuario.render(usuarioForm));
		} else {
			Usuario u = usuarioForm.get();
			u.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			u.write_date = new Date();
			u.update();

			flash("success", "El registro se actualizó correctamente.");
		}

		return URL_LISTA;
	}

}
