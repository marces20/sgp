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
import models.AgenteNovedad;
import models.Factura;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.rrhh.agenteNovedades.*;

@Security.Authenticated(Secured.class)
public class AgentesNovedadesController extends Controller {
	
	final static Form<AgenteNovedad> agenteNovedadForm = form(AgenteNovedad.class);

	public static Result index(Long agenteId, Boolean editable) {
		
		Pagination<AgenteNovedad> lineas = AgenteNovedad.page(agenteId);

		return ok(indexAgenteNovedad.render(lineas, editable));
	}
	
	@CheckPermiso(key = "crearAgenteNovedad")
	public static Result crear(String agenteId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("agente_id", agenteId);
		Form<AgenteNovedad> linea = form(AgenteNovedad.class).bind(b);
		linea.discardErrors();
		return ok(crearAgenteNovedad.render(linea));
	}
	
	@CheckPermiso(key = "crearAgenteNovedad")
	public static Result guardar() {
		Form<AgenteNovedad> agenteNovedadForm = form(AgenteNovedad.class).bindFromRequest();

		try {
			if(agenteNovedadForm.hasErrors()) {
				System.out.println(agenteNovedadForm.errors());
				flash("error", "Error en formulario");
				return ok(crearAgenteNovedad.render(agenteNovedadForm));
			} else {
				
				
				
				AgenteNovedad f = agenteNovedadForm.get();
				f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.create_date = new Date();
				f.activo = true;
				f.save();
				
				List<AgenteNovedad> anx = AgenteNovedad.find.where().eq("agente_id", f.agente_id).ne("id", f.id).ne("activo", false).findList();
				if(anx.size() > 0) {
					for(AgenteNovedad aa :anx) {
						AgenteNovedad ann = AgenteNovedad.find.byId(aa.id);
						ann.activo = false;
						ann.update();
					}
				}
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearAgenteNovedad.render(agenteNovedadForm));
		}
		
		AgenteNovedad linea = AgenteNovedad.find.where().eq("id", agenteNovedadForm.get().id).findUnique();
		Object c = verAgenteNovedad.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	@CheckPermiso(key = "editarAgenteNovedad")
	public static Result editar(Long id) {
		flash().clear();
		AgenteNovedad linea = AgenteNovedad.find.byId(id);
		return ok(editarAgenteNovedad.render(agenteNovedadForm.fill(linea)));
	}
	
	@CheckPermiso(key = "editarAgenteNovedad")
	public static Result actualizar() {
		
		Form<AgenteNovedad> lineaForm = form(AgenteNovedad.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarAgenteNovedad.render(lineaForm));
			} else {
				AgenteNovedad f = lineaForm.get();
				f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.write_date = new Date();
				f.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarAgenteNovedad.render(lineaForm));
		}
		
		AgenteNovedad linea = AgenteNovedad.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verAgenteNovedad.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	@CheckPermiso(key = "eliminarAgenteNovedad")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			AgenteNovedad.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
}
