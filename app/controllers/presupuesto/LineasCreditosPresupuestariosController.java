package controllers.presupuesto;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.LineaCreditoPresupuestario;
import models.SolicitudLinea;
import models.SolicitudLineaAjuste;
import models.Usuario;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.presupuesto.lineaCreditoPresupuestario.crearLineaCredito;
import views.html.presupuesto.lineaCreditoPresupuestario.editarLineaCredito;
import views.html.presupuesto.lineaCreditoPresupuestario.verLineaCredito;
import views.html.presupuesto.lineaCreditoPresupuestario.indexLineaCredito;
import views.html.presupuesto.lineaCreditoPresupuestario.editarLineaCredito;

@Security.Authenticated(Secured.class)
public class LineasCreditosPresupuestariosController extends Controller {
	
	final static Form<LineaCreditoPresupuestario> lineaForm = form(LineaCreditoPresupuestario.class);
	
	public static Result index(Long creditoPresupuestarioId, Boolean editable) {
		
		Pagination<LineaCreditoPresupuestario> lineas = LineaCreditoPresupuestario.page(creditoPresupuestarioId);
		
		return ok(indexLineaCredito.render(lineas, editable));
	}
	
	public static Result crear(String solicitudId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("credito_presupuestario_id", solicitudId);
		Form<LineaCreditoPresupuestario> linea = form(LineaCreditoPresupuestario.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaCredito.render(linea));
	}
	
	public static Result guardar() {
		Form<LineaCreditoPresupuestario> lineaForm = form(LineaCreditoPresupuestario.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				 
				flash("error", "Error en formulario");
				return ok(crearLineaCredito.render(lineaForm));
			} else {
				LineaCreditoPresupuestario l = lineaForm.get();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaCredito.render(lineaForm));
		}
		
		LineaCreditoPresupuestario linea = LineaCreditoPresupuestario.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaCredito.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id) {
		flash().clear();
		LineaCreditoPresupuestario linea = LineaCreditoPresupuestario.find.byId(id);
		return ok(editarLineaCredito.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {
		Form<LineaCreditoPresupuestario> lineaForm = form(LineaCreditoPresupuestario.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaCredito.render(lineaForm));
			} else {
				LineaCreditoPresupuestario l = lineaForm.get();
				l.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.write_date = new Date();
				l.update();
				lineaForm.get().update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaCredito.render(lineaForm));
		}
		
		LineaCreditoPresupuestario linea = LineaCreditoPresupuestario.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaCredito.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			LineaCreditoPresupuestario.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	
	
}
