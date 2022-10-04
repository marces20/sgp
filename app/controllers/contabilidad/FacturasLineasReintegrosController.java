package controllers.contabilidad;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Factura;
import models.FacturaLineaReintegro;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.contabilidad.facturasLineasReintegros.*;							   
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class FacturasLineasReintegrosController extends Controller {
	
	final static Form<FacturaLineaReintegro> lineaForm = form(FacturaLineaReintegro.class);

	public static Result index(Long facturaId, Boolean editable) {
		
		Pagination<FacturaLineaReintegro> lineas = FacturaLineaReintegro.page(facturaId);
		
		Factura factura = Factura.find.byId(facturaId);

		return ok(indexFacturaLineaReintegro.render(lineas, editable,facturaId,factura));
	}
	
	@CheckPermiso(key = "facturasCargarReintegro")
	public static Result crear(String facturaId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("factura_id", facturaId);
		Form<FacturaLineaReintegro> linea = form(FacturaLineaReintegro.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaReintegro.render(linea));
	}
	
	@CheckPermiso(key = "facturasEliminarReintegro")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			FacturaLineaReintegro.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	@CheckPermiso(key = "facturasCargarReintegro")
	public static Result guardar() {
		Form<FacturaLineaReintegro> lineaForm = form(FacturaLineaReintegro.class).bindFromRequest();
		Factura factura = null;
		try {
			if(lineaForm.hasErrors()) {
				System.out.println(lineaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLineaReintegro.render(lineaForm));
			} else {
				FacturaLineaReintegro f = lineaForm.get();
				f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.create_date = new Date();
				f.save();
				factura = Factura.find.byId(f.factura_id);
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaReintegro.render(lineaForm));
		}
		
		FacturaLineaReintegro linea = FacturaLineaReintegro.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaReintegro.render(linea, true,factura);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	@CheckPermiso(key = "facturasEditarReintegro")
	public static Result editar(Long id) {
		flash().clear();
		FacturaLineaReintegro linea = FacturaLineaReintegro.find.byId(id);
		return ok(editarLineaReintegro.render(lineaForm.fill(linea)));
	}
	
	@CheckPermiso(key = "facturasEditarReintegro")
	public static Result actualizar() {
		
		Form<FacturaLineaReintegro> lineaForm = form(FacturaLineaReintegro.class).bindFromRequest();
		Factura factura = null;
		try {
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarLineaReintegro.render(lineaForm));
			} else {
				FacturaLineaReintegro f = lineaForm.get();
				f.update();
				factura = Factura.find.byId(f.factura_id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaReintegro.render(lineaForm));
		}
		
		FacturaLineaReintegro linea = FacturaLineaReintegro.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaReintegro.render(linea, true,factura);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	
}
