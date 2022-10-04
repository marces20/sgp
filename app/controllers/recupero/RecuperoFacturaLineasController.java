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
import models.recupero.RecuperoFacturaLinea;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.recupero.recuperoFacturaLineas.*;

@Security.Authenticated(Secured.class)
public class RecuperoFacturaLineasController extends Controller {
	
	final static Form<RecuperoFacturaLinea> lineaForm = form(RecuperoFacturaLinea.class);
	
	public static Result index(Long facturaId, Boolean editable) {
		
		Pagination<RecuperoFacturaLinea> lineas = RecuperoFacturaLinea.page(facturaId);

		return ok(indexRecuperoFacturaLinea.render(lineas, editable));
	}
	
	public static Result crear(String facturaId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("recupero_factura_id", facturaId);
		b.put("udm_id","1");
		b.put("cuenta_analitica_id",CuentaAnalitica.ARANCELAMIENTO_ID.toString());
		b.put("cuentaAnalitica.nombre",CuentaAnalitica.ARANCELAMIENTO);
		b.put("cuenta_id",Cuenta.OTROS_INGRESOS_ID.toString());		
		b.put("cuenta.nombre",Cuenta.OTROS_INGRESOS);
		
		Form<RecuperoFacturaLinea> linea = form(RecuperoFacturaLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaProducto.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			RecuperoFacturaLinea.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("success", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<RecuperoFacturaLinea> lineaForm = form(RecuperoFacturaLinea.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario "+lineaForm.errors());
				return ok(crearLineaProducto.render(lineaForm));
			} else {
				RecuperoFacturaLinea l = lineaForm.get();
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
		
		RecuperoFacturaLinea linea = RecuperoFacturaLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result editar(Long id) {
		flash().clear();
		RecuperoFacturaLinea linea = RecuperoFacturaLinea.find.byId(id);
		return ok(editarLineaProducto.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<RecuperoFacturaLinea> lineaForm = form(RecuperoFacturaLinea.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaProducto.render(lineaForm));
			} else {
				RecuperoFacturaLinea fl = lineaForm.get();
				RecuperoFacturaLinea l = lineaForm.get();
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaProducto.render(lineaForm));
		}
		
		RecuperoFacturaLinea linea = RecuperoFacturaLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
