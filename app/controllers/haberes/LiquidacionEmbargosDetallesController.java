package controllers.haberes;

import static play.data.Form.form;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionEmbargo;
import models.haberes.LiquidacionEmbargoDetalle;
import models.haberes.LiquidacionPuesto;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.pagination.Pagination;
import views.html.haberes.liquidacionDetalles.crearLiquidacionDetalle;
import views.html.haberes.liquidacionDetalles.editarLiquidacionDetalle;
import views.html.haberes.liquidacionDetalles.verLiquidacionDetalle;
import views.html.haberes.liquidacionEmbargos.liquidacionEmbargosDetalles.*;

public class LiquidacionEmbargosDetallesController extends Controller {

	final static Form<LiquidacionEmbargoDetalle> detalleForm = form(LiquidacionEmbargoDetalle.class);

	public static Result index(Long liquidacionEmbargoId, Boolean editable) {

		Pagination<LiquidacionEmbargoDetalle> detalles = LiquidacionEmbargoDetalle.page(liquidacionEmbargoId);
		LiquidacionEmbargo lp = LiquidacionEmbargo.find.byId(liquidacionEmbargoId);

		return ok(indexLiquidacionEmbargoDetalle.render(detalles, editable,lp));
	}

	@CheckPermiso(key = "liquidacionEmbargoDetalleAgregar")
	public static Result crear(String liquidacionEmbargoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("liquidacion_embargo_id", liquidacionEmbargoId);

		Form<LiquidacionEmbargoDetalle> linea = form(LiquidacionEmbargoDetalle.class).bind(b);
		linea.discardErrors();
		return ok(crearLiquidacionEmbargoDetalle.render(linea));
	}

	@CheckPermiso(key = "liquidacionEmbargoDetalleAgregar")
	public static Result guardar() {
		Form<LiquidacionEmbargoDetalle> detalleForm = form(LiquidacionEmbargoDetalle.class).bindFromRequest();

		try {
			if(detalleForm.hasErrors()) {
				System.out.println(detalleForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLiquidacionEmbargoDetalle.render(detalleForm));
			} else {
				LiquidacionEmbargoDetalle f = detalleForm.get();
				//f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				//f.create_date = new Date();
				f.save();

				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLiquidacionEmbargoDetalle.render(detalleForm));
		}

		LiquidacionEmbargoDetalle detalle = LiquidacionEmbargoDetalle.find.where().eq("id", detalleForm.get().id).findUnique();
		Object c = verLiquidacionEmbargoDetalle.render(detalle);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "liquidacionEmbargoDetalleEditar")
	public static Result editar(Long id) {
		flash().clear();
		LiquidacionEmbargoDetalle detalle = LiquidacionEmbargoDetalle.find.byId(id);
		return ok(editarLiquidacionEmbargoDetalle.render(detalleForm.fill(detalle)));
	}

	@CheckPermiso(key = "liquidacionEmbargoDetalleEditar")
	public static Result actualizar() {

		Form<LiquidacionEmbargoDetalle> detalleForm = form(LiquidacionEmbargoDetalle.class).bindFromRequest();

		try {
			if(detalleForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLiquidacionEmbargoDetalle.render(detalleForm));
			} else {
				LiquidacionEmbargoDetalle fl = detalleForm.get();
				//fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				//fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLiquidacionEmbargoDetalle.render(detalleForm));
		}

		LiquidacionEmbargoDetalle detalle = LiquidacionEmbargoDetalle.find.where().eq("id", detalleForm.get().id).findUnique();
		Object c = verLiquidacionEmbargoDetalle.render(detalle);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "liquidacionEmbargoDetalleEliminar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			LiquidacionEmbargoDetalle.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}
}
