package controllers.recupero;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.Cuenta;
import models.CuentaAnalitica;
import models.Usuario;
import models.recupero.PresupuestoLinea;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.recupero.presupuestoLineas.*;

@Security.Authenticated(Secured.class)
public class PresupuestoLineasController extends Controller {
	
	final static Form<PresupuestoLinea> lineaForm = form(PresupuestoLinea.class);
	
	public static Result index(Long presupuestoId, Boolean editable) {
		
		Pagination<PresupuestoLinea> lineas = PresupuestoLinea.page(presupuestoId);

		return ok(indexPresupuestoLinea.render(lineas, editable));
	}
	
	public static Result crear(String presupuestoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("presupuesto_id", presupuestoId);
		b.put("udm_id","1");
		b.put("cuenta_analitica_id",CuentaAnalitica.ARANCELAMIENTO_ID.toString());
		b.put("cuentaAnalitica.nombre",CuentaAnalitica.ARANCELAMIENTO);
		b.put("cuenta_id",Cuenta.OTROS_INGRESOS_ID.toString());		
		b.put("cuenta.nombre",Cuenta.OTROS_INGRESOS);
		
		Form<PresupuestoLinea> linea = form(PresupuestoLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaProducto.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			PresupuestoLinea.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("success", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<PresupuestoLinea> lineaForm = form(PresupuestoLinea.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario "+lineaForm.errors());
				return ok(crearLineaProducto.render(lineaForm));
			} else {
				PresupuestoLinea l = lineaForm.get();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaProducto.render(lineaForm));
		}
		
		PresupuestoLinea linea = PresupuestoLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result editar(Long id) {
		flash().clear();
		PresupuestoLinea linea = PresupuestoLinea.find.byId(id);
		return ok(editarLineaProducto.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<PresupuestoLinea> lineaForm = form(PresupuestoLinea.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaProducto.render(lineaForm));
			} else {
				PresupuestoLinea fl = lineaForm.get();
				PresupuestoLinea l = lineaForm.get();
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaProducto.render(lineaForm));
		}
		
		PresupuestoLinea linea = PresupuestoLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
