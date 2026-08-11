package controllers.haberes;

import static play.data.Form.form;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.LiquidacionEmbargo;
import models.haberes.LiquidacionEmbargoConcepto;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.pagination.Pagination;
import views.html.haberes.liquidacionEmbargos.liquidacionEmbargosConceptos.*;

public class LiquidacionEmbargosConceptosController extends Controller {

	final static Form<LiquidacionEmbargoConcepto> detalleForm = form(LiquidacionEmbargoConcepto.class);

	public static Result index(Long liquidacionEmbargoId, Boolean editable) {

		Pagination<LiquidacionEmbargoConcepto> detalles = LiquidacionEmbargoConcepto.page(liquidacionEmbargoId);
		LiquidacionEmbargo lp = LiquidacionEmbargo.find.byId(liquidacionEmbargoId);

		return ok(indexLiquidacionEmbargoConcepto.render(detalles, editable,lp));
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoAgregar")
	public static Result crear(String liquidacionEmbargoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("liquidacion_embargo_id", liquidacionEmbargoId);

		Form<LiquidacionEmbargoConcepto> linea = form(LiquidacionEmbargoConcepto.class).bind(b);
		linea.discardErrors();
		return ok(crearLiquidacionEmbargoConcepto.render(linea));
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoAgregar")
	public static Result guardar() {
		Form<LiquidacionEmbargoConcepto> detalleForm = form(LiquidacionEmbargoConcepto.class).bindFromRequest();

		try {
			if(detalleForm.hasErrors()) {
				System.out.println(detalleForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLiquidacionEmbargoConcepto.render(detalleForm));
			} else {
				LiquidacionEmbargoConcepto f = detalleForm.get();
				//f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				//f.create_date = new Date();
				f.save();

				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLiquidacionEmbargoConcepto.render(detalleForm));
		}

		LiquidacionEmbargoConcepto detalle = LiquidacionEmbargoConcepto.find.where().eq("id", detalleForm.get().id).findUnique();
		Object c = verLiquidacionEmbargoConcepto.render(detalle);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoEditar")
	public static Result editar(Long id) {
		flash().clear();
		LiquidacionEmbargoConcepto detalle = LiquidacionEmbargoConcepto.find.byId(id);
		return ok(editarLiquidacionEmbargoConcepto.render(detalleForm.fill(detalle)));
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoEditar")
	public static Result actualizar() {

		Form<LiquidacionEmbargoConcepto> detalleForm = form(LiquidacionEmbargoConcepto.class).bindFromRequest();

		try {
			if(detalleForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLiquidacionEmbargoConcepto.render(detalleForm));
			} else {
				LiquidacionEmbargoConcepto fl = detalleForm.get();
				//fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				//fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLiquidacionEmbargoConcepto.render(detalleForm));
		}

		LiquidacionEmbargoConcepto detalle = LiquidacionEmbargoConcepto.find.where().eq("id", detalleForm.get().id).findUnique();
		Object c = verLiquidacionEmbargoConcepto.render(detalle);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "liquidacionEmbargoConceptoEliminar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			LiquidacionEmbargoConcepto.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}
}
