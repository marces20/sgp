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
import models.AgenteFamilia;
import models.AuditoriaRegistro;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.rrhh.agenteFamilias.*;

@Security.Authenticated(Secured.class)
public class AgentesFamiliasController extends Controller {
	
	final static Form<AgenteFamilia> agenteFamiliaForm = form(AgenteFamilia.class);

	public static Result index(Long agenteId, Boolean editable) {
		
		Pagination<AgenteFamilia> lineas = AgenteFamilia.page(agenteId);

		return ok(indexAgenteFamilia.render(lineas, editable));
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
		Form<AgenteFamilia> linea = form(AgenteFamilia.class).bind(b);
		linea.discardErrors();
		return ok(crearAgenteFamilia.render(linea));
	}
	
	@CheckPermiso(key = "eliminarAgenteHijo")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			AgenteFamilia.find.byId(id).delete();
			AuditoriaRegistro.registrar("agente_familias", id);
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	@CheckPermiso(key = "crearAgenteHijo")
	public static Result guardar() {
		Form<AgenteFamilia> agenteFamiliaForm = form(AgenteFamilia.class).bindFromRequest();

		try {
			if(agenteFamiliaForm.hasErrors()) {
				System.out.println(agenteFamiliaForm.errors());
				flash("error", "Error en formulario ");
				return ok(crearAgenteFamilia.render(agenteFamiliaForm));
			} else {
				
				AgenteFamilia f = agenteFamiliaForm.get();
				
				if(f.tipo_familia_id == 2){
					List<AgenteFamilia> oc = AgenteFamilia.find.where().eq("tipo_familia_id", 2).eq("agente_id", f.agente_id).findList();
					if(oc.size() > 0){
						flash("error", "Este Agente ya tiene un conyugue cargado.");
						return ok(crearAgenteFamilia.render(agenteFamiliaForm));
					}
				}
				
				
				List<AgenteFamilia> l = AgenteFamilia.controlCargaFamilias(f.dni,null);
				
				if(l.size() > 0 && (f.carga_en_conyugue == false || f.carga_en_conyugue == null)){
					
					String errorFamilia = "";
					
					for(AgenteFamilia a : l){
						errorFamilia += a.agente.apellido+" ";
					}
					
					flash("error", "Dni ya cargado bajo en el agente "+errorFamilia+". Verifique que sea conyugue, en caso de serlo marcar cargado en conyugue SI.");
					return ok(crearAgenteFamilia.render(agenteFamiliaForm));
				}
				
				f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.create_date = new Date();
				f.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearAgenteFamilia.render(agenteFamiliaForm));
		}
		
		AgenteFamilia linea = AgenteFamilia.find.where().eq("id", agenteFamiliaForm.get().id).findUnique();
		Object c = verAgenteFamilia.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	@CheckPermiso(key = "editarAgenteHijo")
	public static Result editar(Long id) {
		flash().clear();
		AgenteFamilia linea = AgenteFamilia.find.byId(id);
		return ok(editarAgenteFamilia.render(agenteFamiliaForm.fill(linea)));
	}
	
	@CheckPermiso(key = "editarAgenteHijo")
	public static Result actualizar() {
		
		Form<AgenteFamilia> lineaForm = form(AgenteFamilia.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarAgenteFamilia.render(lineaForm));
			} else {
				AgenteFamilia f = lineaForm.get();
				
				if(f.tipo_familia_id == 2){
					List<AgenteFamilia> oc = AgenteFamilia.find.where()
											 .eq("tipo_familia_id", 2).eq("agente_id", f.agente_id)
											 .ne("id", f.id)
											 .findList();
					if(oc.size() > 0){
						flash("error", "Este Agente ya tiene un conyugue cargado.");
						return ok(editarAgenteFamilia.render(agenteFamiliaForm));
					}
				}
				
				List<AgenteFamilia> l = AgenteFamilia.controlCargaFamilias(f.dni,f.id);
				if(l.size() > 0 && (f.carga_en_conyugue == false || f.carga_en_conyugue == null)){
					
					String errorFamilia = "";
					
					for(AgenteFamilia a : l){
						errorFamilia += a.agente.apellido+" ";
					}
					
					flash("error", "Dni ya cargado bajo en el agente "+errorFamilia+". Verifique que sea conyugue, en caso de serlo marcar cargado en conyugue SI.");
					return ok(crearAgenteFamilia.render(agenteFamiliaForm));
				}
				
				
				f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.write_date = new Date();
				f.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarAgenteFamilia.render(lineaForm));
		}
		
		AgenteFamilia linea = AgenteFamilia.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verAgenteFamilia.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
