package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.CategoriaLaboral;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.categoriasLaborales.*;
	 
public class CategoriasLaboralesController extends Controller {
	
	final static Form<CategoriaLaboral> categoriaLaboralForm = form(CategoriaLaboral.class);
	
	public static Result URL_LISTA_CATEGORIA_LABORAL = redirect(
			controllers.haberes.routes.CategoriasLaboralesController.index()
	);
	
	@CheckPermiso(key = "categoriaLaboralIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexCategoriaLaboral.render(
						CategoriaLaboral.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "categoriaLaboralCrear")
	public static Result crear() {
		Form<CategoriaLaboral> categoriaLaboralForm = form(CategoriaLaboral.class);
		return ok(crearCategoriaLaboral.render(categoriaLaboralForm));
	}
	
	@CheckPermiso(key = "categoriaLaboralCrear")
	public static Result guardar() {
		
		Form<CategoriaLaboral> categoriaLaboralForm = form(CategoriaLaboral.class).bindFromRequest();
		
		try {
			if(categoriaLaboralForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearCategoriaLaboral.render(categoriaLaboralForm));
			} else {
				CategoriaLaboral lc = categoriaLaboralForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "La categoria laboral se ha actualizado");
				return redirect( controllers.haberes.routes.CategoriasLaboralesController.ver( categoriaLaboralForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la categoria laboral");
			return badRequest(crearCategoriaLaboral.render(categoriaLaboralForm));
		}
	}
	
	@CheckPermiso(key = "categoriaLaboralEditar")
	public static Result editar(Long id) {
		CategoriaLaboral lc = Ebean.find(CategoriaLaboral.class, id);
		return ok(editarCategoriaLaboral.render(categoriaLaboralForm.fill(lc)));
	}
	
	@CheckPermiso(key = "categoriaLaboralEditar")
	public static Result actualizar(){
		
		Form<CategoriaLaboral> categoriaLaboralForm = form(CategoriaLaboral.class).bindFromRequest();
		
		try {
			
			if(categoriaLaboralForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarCategoriaLaboral.render(categoriaLaboralForm));
			} else {
				CategoriaLaboral lc = categoriaLaboralForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "La categoria laboral se ha actualizado");
				return redirect( controllers.haberes.routes.CategoriasLaboralesController.ver( categoriaLaboralForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la categoria laboral");
			return badRequest(editarCategoriaLaboral.render(categoriaLaboralForm));
		}
	}
	
	@CheckPermiso(key = "categoriaLaboralEliminar")
	public static Result eliminar(Long id) {
		try {
			CategoriaLaboral.find.byId(id).delete();
			flash("success", "Se ha eliminado la categoria laboral");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la categoria laboral");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "categoriaLaboralVer")
	public static Result ver(Long id) throws IOException {
		CategoriaLaboral lc = CategoriaLaboral.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra la categoria laboral");
			return URL_LISTA_CATEGORIA_LABORAL;
		}
		
		return ok(verCategoriaLaboral.render(categoriaLaboralForm.fill(lc),lc));
	}
	
	public static Result suggestCategoriaLaboral(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode categoriaLaboral = rpta.arrayNode();
	    
	    CategoriaLaboral lc = new CategoriaLaboral();
		 
		for(CategoriaLaboral a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        categoriaLaboral.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", categoriaLaboral);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		CategoriaLaboral lc = CategoriaLaboral.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la categoria laboral");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<CategoriaLaboral> p = new Pagination<CategoriaLaboral>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(CategoriaLaboral.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaCategoriaLaboral.render(p, form().bindFromRequest()) );
	}
	
}
