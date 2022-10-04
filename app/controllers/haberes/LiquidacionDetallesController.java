package controllers.haberes;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.FacturaLinea;
import models.Usuario;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionPuesto;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.pagination.Pagination;
import views.html.haberes.liquidacionDetalles.*;

public class LiquidacionDetallesController extends Controller {
	
	final static Form<LiquidacionDetalle> detalleForm = form(LiquidacionDetalle.class);
	
	public static Result index(Long liquidacionPuestoId, Boolean editable) {
		
		Pagination<LiquidacionDetalle> detalles = LiquidacionDetalle.page(liquidacionPuestoId);
		LiquidacionPuesto lp = LiquidacionPuesto.find.byId(liquidacionPuestoId);
		return ok(indexLiquidacionDetalle.render(detalles, editable,lp));
	}
	
	public static Result crear(String liquidacionPuestoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("liquidacion_puesto_id", liquidacionPuestoId);
		
		Form<LiquidacionDetalle> linea = form(LiquidacionDetalle.class).bind(b);
		linea.discardErrors();
		return ok(crearLiquidacionDetalle.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			LiquidacionDetalle.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<LiquidacionDetalle> detalleForm = form(LiquidacionDetalle.class).bindFromRequest();

		try {
			if(detalleForm.hasErrors()) {
				System.out.println(detalleForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLiquidacionDetalle.render(detalleForm));
			} else {
				LiquidacionDetalle f = detalleForm.get();
				//f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				//f.create_date = new Date();
				f.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLiquidacionDetalle.render(detalleForm));
		}
		
		LiquidacionDetalle detalle = LiquidacionDetalle.find.where().eq("id", detalleForm.get().id).findUnique();
		Object c = verLiquidacionDetalle.render(detalle);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result editar(Long id) {
		flash().clear();
		LiquidacionDetalle detalle = LiquidacionDetalle.find.byId(id);
		return ok(editarLiquidacionDetalle.render(detalleForm.fill(detalle)));
	}
	
	public static Result actualizar() {

		Form<LiquidacionDetalle> detalleForm = form(LiquidacionDetalle.class).bindFromRequest();
		
		try {
			if(detalleForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLiquidacionDetalle.render(detalleForm));
			} else {
				LiquidacionDetalle fl = detalleForm.get();
				//fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				//fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLiquidacionDetalle.render(detalleForm));
		}
		
		LiquidacionDetalle detalle = LiquidacionDetalle.find.where().eq("id", detalleForm.get().id).findUnique();
		Object c = verLiquidacionDetalle.render(detalle);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
