package controllers.rrhh;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.AgenteEstudio;
import models.EstudioSubarea;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.rrhh.agenteEstudios.*;

@Security.Authenticated(Secured.class)
public class AgentesEstudiosController extends Controller {
	
	final static Form<AgenteEstudio> agenteEstudioForm = form(AgenteEstudio.class);

	public static Result index(Long agenteId, Boolean editable) {
		
		Pagination<AgenteEstudio> lineas = AgenteEstudio.page(agenteId);

		return ok(indexAgenteEstudio.render(lineas, editable));
	}
	
	@CheckPermiso(key = "crearAgenteEstudio")
	public static Result crear(String agenteId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("agente_id", agenteId);
		Form<AgenteEstudio> linea = form(AgenteEstudio.class).bind(b);
		linea.discardErrors();
		return ok(crearAgenteEstudio.render(linea));
	}
	
	@CheckPermiso(key = "eliminarAgenteEstudio")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			AgenteEstudio.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	@CheckPermiso(key = "crearAgenteEstudio")
	public static Result guardar() {
		Form<AgenteEstudio> agenteEstudioForm = form(AgenteEstudio.class).bindFromRequest();

		try {
			if(agenteEstudioForm.hasErrors()) {
				System.out.println(agenteEstudioForm.errors());
				flash("error", "Error en formulario");
				return ok(crearAgenteEstudio.render(agenteEstudioForm));
			} else {
				AgenteEstudio f = agenteEstudioForm.get();
				f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.create_date = new Date();
				f.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearAgenteEstudio.render(agenteEstudioForm));
		}
		
		AgenteEstudio linea = AgenteEstudio.find.where().eq("id", agenteEstudioForm.get().id).findUnique();
		Object c = verAgenteEstudio.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	@CheckPermiso(key = "editarAgenteEstudio")
	public static Result editar(Long id) {
		flash().clear();
		AgenteEstudio linea = AgenteEstudio.find.byId(id);
		return ok(editarAgenteEstudio.render(agenteEstudioForm.fill(linea)));
	}
	
	@CheckPermiso(key = "editarAgenteEstudio")
	public static Result actualizar() {
		
		Form<AgenteEstudio> lineaForm = form(AgenteEstudio.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarAgenteEstudio.render(lineaForm));
			} else {
				AgenteEstudio f = lineaForm.get();
				f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.write_date = new Date();
				f.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarAgenteEstudio.render(lineaForm));
		}
		
		AgenteEstudio linea = AgenteEstudio.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verAgenteEstudio.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result listOptionsEstudioSubareas(Integer estudioAreaId){
		List<EstudioSubarea> p = EstudioSubarea.find.where().eq("estudio_area_id", estudioAreaId).orderBy("nombre").findList();
		 
		if(p.size() > 0)
			return ok(optionsListSubarea.render(p));
		else
			return ok();
	}
	
	
}
