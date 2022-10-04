package controllers.presupuesto;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import models.LineaCreditoPresupuestario;
import models.LineaRecursoPresupuestario;
import models.Usuario;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.presupuesto.lineaRecursoPresupuestario.crearLineaRecurso;
import views.html.presupuesto.lineaRecursoPresupuestario.editarLineaRecurso;
import views.html.presupuesto.lineaRecursoPresupuestario.indexLineaRecurso;
import views.html.presupuesto.lineaRecursoPresupuestario.verLineaRecurso;

@Security.Authenticated(Secured.class)
public class LineasRecursosPresupuestariosController extends Controller {
	
	final static Form<LineaRecursoPresupuestario> lineaForm = form(LineaRecursoPresupuestario.class);
	
	public static Result index(Long creditoPresupuestarioId, Boolean editable) {
		
		Pagination<LineaRecursoPresupuestario> lineas = LineaRecursoPresupuestario.page(creditoPresupuestarioId);
		return ok(indexLineaRecurso.render(lineas, editable));
	}
	
	public static Result crear(String solicitudId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("credito_presupuestario_id", solicitudId);
		Form<LineaRecursoPresupuestario> linea = form(LineaRecursoPresupuestario.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaRecurso.render(linea));
	}
	
	public static Result guardar() {
		Form<LineaRecursoPresupuestario> lineaForm = form(LineaRecursoPresupuestario.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				 
				flash("error", "Error en formulario");
				return ok(crearLineaRecurso.render(lineaForm));
			} else {
				LineaRecursoPresupuestario l = lineaForm.get();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaRecurso.render(lineaForm));
		}
		
		LineaRecursoPresupuestario linea = LineaRecursoPresupuestario.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaRecurso.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id) {
		flash().clear();
		LineaRecursoPresupuestario linea = LineaRecursoPresupuestario.find.byId(id);
		return ok(editarLineaRecurso.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {
		Form<LineaRecursoPresupuestario> lineaForm = form(LineaRecursoPresupuestario.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaRecurso.render(lineaForm));
			} else {
				LineaRecursoPresupuestario l = lineaForm.get();
				l.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.write_date = new Date();
				l.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaRecurso.render(lineaForm));
		}
		
		LineaRecursoPresupuestario linea = LineaRecursoPresupuestario.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaRecurso.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			LineaRecursoPresupuestario.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
}
