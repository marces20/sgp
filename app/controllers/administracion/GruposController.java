package controllers.administracion;

import static play.data.Form.form;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Expediente;
import models.Grupo;
import models.Solicitud;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.administracion.grupos.crearGrupo;
import views.html.administracion.grupos.editarGrupo;
import views.html.administracion.grupos.indexGrupo;
import views.html.compras.solicitudes.indexSolicitud;
import views.html.administracion.grupos.modalBusquedaGrupo;

import com.avaje.ebean.Ebean;

import controllers.Secured;

@Security.Authenticated(Secured.class)
public class GruposController extends Controller {
	final static Form<Grupo> grupoForm = form(Grupo.class);	
    public static Result URL_LISTA = redirect(
    		routes.GruposController.index()
        );

	public static Result index()
	{	
		DynamicForm d = form().bindFromRequest();

		return ok(
				 indexGrupo.render(
						 Grupo.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	public static Result crear()
	{
		return ok(crearGrupo.render(grupoForm));
	}
	
	public static Result guardar()
	{
		Form<Grupo> grupoForm = form(Grupo.class).bindFromRequest();

		try {
			if(grupoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearGrupo.render(grupoForm));
			} else {
				grupoForm.get().save();
				flash("success", "El registro se actualizó correctamente.");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el registro");
			return badRequest(crearGrupo.render(grupoForm));
		}
		
		return URL_LISTA;
	}

	public static Result editar(int id)
	{
		Grupo grupo = Ebean.find(Grupo.class, id);

		return ok(editarGrupo.render(grupoForm.fill(grupo)));
	}
	
	public static Result eliminar(int id)
	{
		try {
			Grupo.find.byId(id).delete();
			flash("success", "Se ha eliminado el registro");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el registro");
		}

		return URL_LISTA;
	}

	public static Result actualizar()
	{

		Form<Grupo> grupoForm = form(Grupo.class).bindFromRequest();

		Integer id = Integer.parseInt(grupoForm.data().get("id"));

		if(grupoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarGrupo.render(grupoForm));
		} else {
			grupoForm.get().update(id);
			flash("success", "El registro se actualizó correctamente.");
		}
		return URL_LISTA;
	}
	
	public static Result get(int id){
		Grupo grupo = Grupo.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(grupo == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el grupo");
		} else {
			restJs.put("success", true);
			restJs.put("id", grupo.id);
			restJs.put("nombre", grupo.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Grupo> p = new Pagination<Grupo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Grupo.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaGrupo.render(p, form().bindFromRequest()) );
	}

}
