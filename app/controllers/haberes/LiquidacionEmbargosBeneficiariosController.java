package controllers.haberes;

import static play.data.Form.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.LiquidacionEmbargo;
import models.haberes.LiquidacionEmbargoBeneficiario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.pagination.Pagination;
import views.html.haberes.liquidacionEmbargos.liquidacionEmbargosBeneficiarios.*;

public class LiquidacionEmbargosBeneficiariosController extends Controller {

	final static Form<LiquidacionEmbargoBeneficiario> detalleForm = form(LiquidacionEmbargoBeneficiario.class);

	public static Result index(Long liquidacionEmbargoId, Boolean editable) {

		Pagination<LiquidacionEmbargoBeneficiario> detalles = LiquidacionEmbargoBeneficiario.page(liquidacionEmbargoId);
		LiquidacionEmbargo lp = LiquidacionEmbargo.find.byId(liquidacionEmbargoId);

		return ok(indexLiquidacionEmbargoBeneficiario.render(detalles, editable,lp));
	}

	@CheckPermiso(key = "liquidacionEmbargoBeneficiarioAgregar")
	public static Result crear(String liquidacionEmbargoId) {
		flash().clear();

		LiquidacionEmbargo le = LiquidacionEmbargo.find.byId(new Long(liquidacionEmbargoId));

		Map<String,String> b = new HashMap<String, String>();
		b.put("liquidacion_embargo_id", liquidacionEmbargoId);

		Form<LiquidacionEmbargoBeneficiario> linea = form(LiquidacionEmbargoBeneficiario.class).bind(b);
		linea.discardErrors();

		return ok(crearLiquidacionEmbargoBeneficiario.render(linea,le.agente_id));
	}

	@CheckPermiso(key = "liquidacionEmbargoBeneficiarioAgregar")
	public static Result guardar() {

		Form<LiquidacionEmbargoBeneficiario> detalleForm = form(LiquidacionEmbargoBeneficiario.class).bindFromRequest();
		LiquidacionEmbargo le = LiquidacionEmbargo.find.byId(detalleForm.get().liquidacion_embargo_id);





		try {
			if(detalleForm.hasErrors()) {
				System.out.println(detalleForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLiquidacionEmbargoBeneficiario.render(detalleForm,le.agente_id));
			} else {
				LiquidacionEmbargoBeneficiario f = detalleForm.get();

				List<LiquidacionEmbargoBeneficiario> controlBeneficiario = LiquidacionEmbargoBeneficiario.find.where().eq("agente_familia_id", detalleForm.get().agente_familia_id).findList();
				if(controlBeneficiario.size() > 0) {
					flash("error", "Este beneficiario ya se encuentra cargado.");
					return ok(crearLiquidacionEmbargoBeneficiario.render(detalleForm,le.agente_id));
				}

				//f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				//f.create_date = new Date();
				f.save();

				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLiquidacionEmbargoBeneficiario.render(detalleForm,le.agente_id));
		}

		LiquidacionEmbargoBeneficiario detalle = LiquidacionEmbargoBeneficiario.find.where().eq("id", detalleForm.get().id).findUnique();
		Object c = verLiquidacionEmbargoBeneficiario.render(detalle);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "liquidacionEmbargoBeneficiarioEditar")
	public static Result editar(Long id) {
		flash().clear();

		LiquidacionEmbargoBeneficiario detalle = LiquidacionEmbargoBeneficiario.find.byId(id);
		LiquidacionEmbargo le = LiquidacionEmbargo.find.byId(detalle.liquidacion_embargo_id);

		return ok(editarLiquidacionEmbargoBeneficiario.render(detalleForm.fill(detalle),le.agente_id));
	}

	@CheckPermiso(key = "liquidacionEmbargoBeneficiarioEditar")
	public static Result actualizar() {

		Form<LiquidacionEmbargoBeneficiario> detalleForm = form(LiquidacionEmbargoBeneficiario.class).bindFromRequest();
		LiquidacionEmbargo le = LiquidacionEmbargo.find.byId(detalleForm.get().liquidacion_embargo_id);

		try {
			if(detalleForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLiquidacionEmbargoBeneficiario.render(detalleForm,le.agente_id));
			} else {
				LiquidacionEmbargoBeneficiario fl = detalleForm.get();

				List<LiquidacionEmbargoBeneficiario> controlBeneficiario = LiquidacionEmbargoBeneficiario.find.where().ne("id", detalleForm.get().id).eq("agente_familia_id", detalleForm.get().agente_familia_id).findList();
				if(controlBeneficiario.size() > 0) {
					flash("error", "Este beneficiario ya se encuentra cargado.");
					return ok(editarLiquidacionEmbargoBeneficiario.render(detalleForm,le.agente_id));
				}

				//fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				//fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLiquidacionEmbargoBeneficiario.render(detalleForm,le.agente_id));
		}

		LiquidacionEmbargoBeneficiario detalle = LiquidacionEmbargoBeneficiario.find.where().eq("id", detalleForm.get().id).findUnique();
		Object c = verLiquidacionEmbargoBeneficiario.render(detalle);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "liquidacionEmbargoBeneficiarioEliminar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			LiquidacionEmbargoBeneficiario.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}
}
