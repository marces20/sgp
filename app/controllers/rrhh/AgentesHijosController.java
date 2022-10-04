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
import models.AgenteHijo;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.rrhh.agenteHijos.*;

@Security.Authenticated(Secured.class)
public class AgentesHijosController extends Controller {
	
	final static Form<AgenteHijo> agenteHijoForm = form(AgenteHijo.class);

	public static Result index(Long agenteId, Boolean editable) {
		
		Pagination<AgenteHijo> lineas = AgenteHijo.page(agenteId);

		return ok(indexAgenteHijo.render(lineas, editable));
	}
	
	@CheckPermiso(key = "crearAgenteHijo")
	public static Result crear(String agenteId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("agente_id", agenteId);
		b.put("vive","true");
		b.put("carga_en_conyugue","false");
		b.put("adoptado","false");
		b.put("discapacidad","false");
		Form<AgenteHijo> linea = form(AgenteHijo.class).bind(b);
		linea.discardErrors();
		return ok(crearAgenteHijo.render(linea));
	}
	
	@CheckPermiso(key = "eliminarAgenteHijo")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			AgenteHijo.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	@CheckPermiso(key = "crearAgenteHijo")
	public static Result guardar() {
		Form<AgenteHijo> agenteHijoForm = form(AgenteHijo.class).bindFromRequest();

		try {
			if(agenteHijoForm.hasErrors()) {
				System.out.println(agenteHijoForm.errors());
				flash("error", "Error en formulario ");
				return ok(crearAgenteHijo.render(agenteHijoForm));
			} else {
				
				AgenteHijo f = agenteHijoForm.get();
				List<AgenteHijo> l = AgenteHijo.controlCargaHijos(f.dni,null);
				
				if(l.size() > 0 && (f.carga_en_conyugue == false || f.carga_en_conyugue == null)){
					
					String errorHijos = "";
					
					for(AgenteHijo a : l){
						errorHijos += a.agente.apellido+" ";
					}
					
					flash("error", "Dni ya cargado bajo en el agente "+errorHijos+". Verifique que sea conyugue, en caso de serlo marcar cargado en conyugue SI.");
					return ok(crearAgenteHijo.render(agenteHijoForm));
				}
				
				f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.create_date = new Date();
				f.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearAgenteHijo.render(agenteHijoForm));
		}
		
		AgenteHijo linea = AgenteHijo.find.where().eq("id", agenteHijoForm.get().id).findUnique();
		Object c = verAgenteHijo.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	@CheckPermiso(key = "editarAgenteHijo")
	public static Result editar(Long id) {
		flash().clear();
		AgenteHijo linea = AgenteHijo.find.byId(id);
		return ok(editarAgenteHijo.render(agenteHijoForm.fill(linea)));
	}
	
	@CheckPermiso(key = "editarAgenteHijo")
	public static Result actualizar() {
		
		Form<AgenteHijo> lineaForm = form(AgenteHijo.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarAgenteHijo.render(lineaForm));
			} else {
				AgenteHijo f = lineaForm.get();
				
				List<AgenteHijo> l = AgenteHijo.controlCargaHijos(f.dni,f.id);
				
				if(l.size() > 0 && (f.carga_en_conyugue == false || f.carga_en_conyugue == null)){
					
					String errorHijos = "";
					
					for(AgenteHijo a : l){
						errorHijos += a.agente.apellido+" ";
					}
					
					flash("error", "Dni ya cargado bajo en el agente "+errorHijos+". Verifique que sea conyugue, en caso de serlo marcar cargado en conyugue SI.");
					return ok(crearAgenteHijo.render(agenteHijoForm));
				}
				
				
				f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.write_date = new Date();
				f.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarAgenteHijo.render(lineaForm));
		}
		
		AgenteHijo linea = AgenteHijo.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verAgenteHijo.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
