package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.LiquidacionEmbargoConceptoTipo;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.liquidacionEmbargoConceptoTipos.*;

public class LiquidacionEmbargosConceptoTiposController extends Controller {

	final static Form<LiquidacionEmbargoConceptoTipo> liquidacionEmbargoConceptoTipoForm = form(LiquidacionEmbargoConceptoTipo.class);

	public static Result URL_LISTA_LIQUIDACION_EMBARGO_CONCEPTO_TIPO = redirect(
			controllers.haberes.routes.LiquidacionEmbargosConceptoTiposController.index()
	);

	@CheckPermiso(key = "liquidacionEmbargoConceptoTipoVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexLiquidacionEmbargoConceptoTipo.render(
						LiquidacionEmbargoConceptoTipo.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoTipoCrear")
	public static Result crear() {
		Form<LiquidacionEmbargoConceptoTipo> liquidacionEmbargoTipoConceptoForm = form(LiquidacionEmbargoConceptoTipo.class);
		return ok(crearLiquidacionEmbargoConceptoTipo.render(liquidacionEmbargoTipoConceptoForm));
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoTipoCrear")
	public static Result guardar() {

		Form<LiquidacionEmbargoConceptoTipo> liquidacionEmbargoConceptoTipoForm = form(LiquidacionEmbargoConceptoTipo.class).bindFromRequest();

		try {
			if(liquidacionEmbargoConceptoTipoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearLiquidacionEmbargoConceptoTipo.render(liquidacionEmbargoConceptoTipoForm));
			} else {
				LiquidacionEmbargoConceptoTipo lc = liquidacionEmbargoConceptoTipoForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El tipo de concepto se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionEmbargosConceptoTiposController.ver( liquidacionEmbargoConceptoTipoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo de concepto");
			return badRequest(crearLiquidacionEmbargoConceptoTipo.render(liquidacionEmbargoConceptoTipoForm));
		}
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoTipoEditar")
	public static Result editar(Long id) {
		LiquidacionEmbargoConceptoTipo lc = Ebean.find(LiquidacionEmbargoConceptoTipo.class, id);
		return ok(editarLiquidacionEmbargoConceptoTipo.render(liquidacionEmbargoConceptoTipoForm.fill(lc)));
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoTipoEditar")
	public static Result actualizar(){

		Form<LiquidacionEmbargoConceptoTipo> liquidacionEmbargoConceptoTipoForm = form(LiquidacionEmbargoConceptoTipo.class).bindFromRequest();

		try {

			if(liquidacionEmbargoConceptoTipoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarLiquidacionEmbargoConceptoTipo.render(liquidacionEmbargoConceptoTipoForm));
			} else {
				LiquidacionEmbargoConceptoTipo lc = liquidacionEmbargoConceptoTipoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El tipo de concepto se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionEmbargosConceptoTiposController.ver( liquidacionEmbargoConceptoTipoForm.get().id ) + UriTrack.get("&"));
			}

		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el tipo de concepto");
			return badRequest(editarLiquidacionEmbargoConceptoTipo.render(liquidacionEmbargoConceptoTipoForm));
		}
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoTipoEliminar")
	public static Result eliminar(Long id) {
		try {
			LiquidacionEmbargoConceptoTipo.find.byId(id).delete();
			flash("success", "Se ha eliminado el tipo de concepto");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el tipo de concepto");
		}

		return redirect(request().getHeader("referer"));
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoTipoVer")
	public static Result ver(Long id) throws IOException {
		LiquidacionEmbargoConceptoTipo lc = LiquidacionEmbargoConceptoTipo.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el tipo de concepto.");
			return URL_LISTA_LIQUIDACION_EMBARGO_CONCEPTO_TIPO;
		}

		return ok(verLiquidacionEmbargoConceptoTipo.render(liquidacionEmbargoConceptoTipoForm.fill(lc),lc));
	}

	public static Result suggestLiquidacionEmbargoConceptoTipo(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode liquidacionEmbargoConceptoTipo = rpta.arrayNode();

	    LiquidacionEmbargoConceptoTipo lc = new LiquidacionEmbargoConceptoTipo();

		for(LiquidacionEmbargoConceptoTipo a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        liquidacionEmbargoConceptoTipo.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", liquidacionEmbargoConceptoTipo);

		return ok(response);
	}

	public static Result get(int id){
		LiquidacionEmbargoConceptoTipo lc = LiquidacionEmbargoConceptoTipo.find.select("id, nombre").where().eq("id", id).findUnique();

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
    	Pagination<LiquidacionEmbargoConceptoTipo> p = new Pagination<LiquidacionEmbargoConceptoTipo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(LiquidacionEmbargoConceptoTipo.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaLiquidacionEmbargoConceptoTipo.render(p, form().bindFromRequest()) );
	}

}


