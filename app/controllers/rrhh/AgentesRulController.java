package controllers.rrhh;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.AgenteEstudio;
import models.AgenteRul;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.rrhh.agenteRul.*;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class AgentesRulController extends Controller {
	
	final static Form<AgenteRul> agenteRulForm = form(AgenteRul.class);

	public static Result index(Long agenteId, Boolean editable) {
		
		Pagination<AgenteRul> lineas = AgenteRul.page(agenteId);

		return ok(indexAgenteRul.render(lineas, editable));
	}
	
	@CheckPermiso(key = "crearAgenteRul")
	public static Result crear(String agenteId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("agente_id", agenteId);
		Form<AgenteRul> linea = form(AgenteRul.class).bind(b);
		linea.discardErrors();
		return ok(crearAgenteRul.render(linea));
	}
	
	@CheckPermiso(key = "eliminarAgenteRul")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			AgenteRul.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	@CheckPermiso(key = "crearAgenteRul")
	public static Result guardar() {
		Form<AgenteRul> agenteRulForm = form(AgenteRul.class).bindFromRequest();

		try {
			if(agenteRulForm.hasErrors()) {
				System.out.println(agenteRulForm.errors());
				flash("error", "Error en formulario");
				return ok(crearAgenteRul.render(agenteRulForm));
			} else {
				AgenteRul f = agenteRulForm.get();
				f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.create_date = new Date();
				f.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearAgenteRul.render(agenteRulForm));
		}
		
		AgenteRul linea = AgenteRul.find.where().eq("id", agenteRulForm.get().id).findUnique();
		Object c = verAgenteRul.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	@CheckPermiso(key = "editarAgenteRul")
	public static Result editar(Long id) {
		flash().clear();
		AgenteRul linea = AgenteRul.find.byId(id);
		return ok(editarAgenteRul.render(agenteRulForm.fill(linea)));
	}
	
	@CheckPermiso(key = "editarAgenteRul")
	public static Result actualizar() {
		
		Form<AgenteRul> lineaForm = form(AgenteRul.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarAgenteRul.render(lineaForm));
			} else {
				AgenteRul f = lineaForm.get();
				f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.write_date = new Date();
				f.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarAgenteRul.render(lineaForm));
		}
		
		AgenteRul linea = AgenteRul.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verAgenteRul.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
