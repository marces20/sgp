package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.EscalaLaboral;
import models.haberes.TipoEmbargos;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.tipoEmbargos.*;

public class TipoEmbargosController extends Controller {

	final static Form<TipoEmbargos> tipoEmbargoForm = form(TipoEmbargos.class);

	public static Result URL_LISTA_TIPO_EMBARGO = redirect(
			controllers.haberes.routes.TipoEmbargosController.index()
	);

	@CheckPermiso(key = "tipoEmbargoVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexTipoEmbargo.render(
						TipoEmbargos.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}

	@CheckPermiso(key = "tipoEmbargoCrear")
	public static Result crear() {
		Form<TipoEmbargos> tipoEmbargoForm = form(TipoEmbargos.class);
		return ok(crearTipoEmbargo.render(tipoEmbargoForm));
	}

	@CheckPermiso(key = "tipoEmbargoCrear")
	public static Result guardar() {

		Form<TipoEmbargos> tipoEmbargoForm = form(TipoEmbargos.class).bindFromRequest();

		try {
			if(tipoEmbargoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearTipoEmbargo.render(tipoEmbargoForm));
			} else {
				TipoEmbargos lc = tipoEmbargoForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El tipo embargo se ha actualizado");
				return redirect( controllers.haberes.routes.TipoEmbargosController.ver( tipoEmbargoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo embargo");
			return badRequest(crearTipoEmbargo.render(tipoEmbargoForm));
		}
	}

	@CheckPermiso(key = "tipoEmbargoEditar")
	public static Result editar(Long id) {
		TipoEmbargos lc = Ebean.find(TipoEmbargos.class, id);
		return ok(editarTipoEmbargo.render(tipoEmbargoForm.fill(lc)));
	}

	@CheckPermiso(key = "tipoEmbargoEditar")
	public static Result actualizar(){

		Form<TipoEmbargos> tipoEmbargoForm = form(TipoEmbargos.class).bindFromRequest();

		try {

			if(tipoEmbargoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarTipoEmbargo.render(tipoEmbargoForm));
			} else {
				TipoEmbargos lc = tipoEmbargoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El tipo embargo se ha actualizado");
				return redirect( controllers.haberes.routes.TipoEmbargosController.ver( tipoEmbargoForm.get().id ) + UriTrack.get("&"));
			}

		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo embargo");
			return badRequest(editarTipoEmbargo.render(tipoEmbargoForm));
		}
	}

	@CheckPermiso(key = "tipoEmbargoEliminar")
	public static Result eliminar(Long id) {
		try {
			TipoEmbargos.find.byId(id).delete();
			flash("success", "Se ha eliminado el tipo embargo");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el tipo embargo");
		}

		return redirect(request().getHeader("referer"));
	}

	@CheckPermiso(key = "tipoEmbargoVer")
	public static Result ver(Long id) throws IOException {

		TipoEmbargos lc = TipoEmbargos.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el tipo embargo");
			return URL_LISTA_TIPO_EMBARGO;
		}

		return ok(verTipoEmbargo.render(tipoEmbargoForm.fill(lc),lc));
	}

	public static Result suggestTipoEmbargo(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode tipoEmbargo = rpta.arrayNode();

	    TipoEmbargos lc = new TipoEmbargos();

		for(TipoEmbargos a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        tipoEmbargo.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", tipoEmbargo);

		return ok(response);
	}

	public static Result get(int id){
		TipoEmbargos lc = TipoEmbargos.find.select("id, nombre").where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra tipo embargo");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	/*public static Result modalBuscar() {
    	Pagination<TipoEmbargos> p = new Pagination<TipoEmbargos>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(TipoEmbargos.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaTipoEmbargo.render(p, form().bindFromRequest()) );
	}*/

}
