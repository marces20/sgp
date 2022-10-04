package controllers.rrhh;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.AgenteSeguimientoLinea;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.rrhh.agenteSeguimientoLineas.*;
import views.html.rrhh.agenteSeguimientos.*;

@Security.Authenticated(Secured.class)
public class AgentesSeguimientoLineasController extends Controller {
	
	final static Form<AgenteSeguimientoLinea> lineaForm = form(AgenteSeguimientoLinea.class);
	
	public static Result index(Long seguimientoId, Boolean editable) {
		
		Pagination<AgenteSeguimientoLinea> lineas = AgenteSeguimientoLinea.page(seguimientoId);

		return ok(indexLineaSeguimiento.render(lineas, editable));
	}	
	
	public static Result crear(String seguimientoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("agente_seguimiento_id", seguimientoId);
		Form<AgenteSeguimientoLinea> linea = form(AgenteSeguimientoLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaSeguimiento.render(linea));
	}
	
	public static Result guardar() {
		Form<AgenteSeguimientoLinea> lineaForm = form(AgenteSeguimientoLinea.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				System.out.println(lineaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLineaSeguimiento.render(lineaForm));
			} else {
				AgenteSeguimientoLinea l = lineaForm.get();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaSeguimiento.render(lineaForm));
		}
		
		AgenteSeguimientoLinea linea = AgenteSeguimientoLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaSeguimiento.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id) {
		flash().clear();
		AgenteSeguimientoLinea linea = AgenteSeguimientoLinea.find.byId(id);
		return ok(editarLineaSeguimiento.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<AgenteSeguimientoLinea> lineaForm = form(AgenteSeguimientoLinea.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaSeguimiento.render(lineaForm));
			} else {
				AgenteSeguimientoLinea fl = lineaForm.get();
				AgenteSeguimientoLinea l = lineaForm.get();
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaSeguimiento.render(lineaForm));
		}
		
		AgenteSeguimientoLinea linea = AgenteSeguimientoLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaSeguimiento.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			AgenteSeguimientoLinea.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}

}
