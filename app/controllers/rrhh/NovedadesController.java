package controllers.rrhh;

import static play.data.Form.form;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Expediente;
import models.Feriado;
import models.Novedad;
import models.Especialidad;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.rrhh.especialidad.crearEspecialidad;
import views.html.rrhh.novedades.*;

@Security.Authenticated(Secured.class)
public class NovedadesController extends Controller {

	
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexNovedades.render());
		
	}
	
	public static Result lista() {
	    
		ObjectNode obj = Json.newObject();
	    ArrayNode s = obj.arrayNode();

	    List<Novedad> novedades = Novedad.page(RequestVar.get("agente_id"), RequestVar.get("servicio_id"), RequestVar.get("desde"), RequestVar.get("hasta")).getList();
	    
	    for (Novedad n : novedades) {
		    ObjectNode e = Json.newObject();
		    e.put("id", n.id.toString());
		    e.put("title", n.agente.apellido);
		    e.put("start", utils.DateUtils.formatDate(n.fecha_inicio, "yyyy-MM-dd'T'HH:mm:ss"));
		    e.put("color", n.servicio.color);
			s.add(e);
		}
		
		
		return ok(s);
	}
	
	public static Result getFeriados(){
		
		ObjectNode o = Json.newObject();
		ArrayNode s = o.arrayNode();
		
		List<Feriado> feriados = Feriado.find.findList();
		
		for (Feriado f : feriados) {
			s.add(utils.DateUtils.formatDate(f.fecha, "yyyy-MM-dd"));
		}
		o.put("feriados", s);
		return ok(o);
	}
	
	
	public static Result ver(Long id) {
		Novedad n = Novedad.find.byId(id);

		return ok(verNovedad.render(n));
	}
	
	public static Result eliminar(Long id) {
		try {
			Novedad.find.byId(id).delete();
			flash("success", "Se ha eliminado la novedad");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la novedad");
		}

		return redirect(controllers.rrhh.routes.NovedadesController.index());
	}
	
	public static Result crear() {
		Form<Novedad> nForm = form(Novedad.class);
		return ok(crearNovedad.render(nForm));

	}
	
	public static Result guardar() {
		Form<Novedad> nForm = form(Novedad.class).bindFromRequest();
		ObjectNode restJs = Json.newObject();
		ObjectNode evento = Json.newObject();
		try {
			
			if(nForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearNovedad.render(nForm));
			} else {
				Novedad e = nForm.get();
				e.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				e.create_date = new Date();
				e.save();
				Novedad n = Novedad.find.byId(e.id);
				restJs.put("success", true);
				restJs.put("nuevo", true);
				evento.put("id", n.id);
				evento.put("nombre", n.agente.apellido);
				evento.put("color", n.servicio.color);
				evento.put("fecha", utils.DateUtils.formatDate(n.fecha_inicio, "yyyy-MM-dd'T'HH:mm:ss"));
				
				restJs.put("evento", evento);
				return ok(restJs);
				//flash("success", "La novedad se ha creado correctamente");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la novedad");
			return badRequest(crearNovedad.render(nForm));
		}
		
	}
	
	public static Result editar(Long id) {
		Form<Novedad> nForm = form(Novedad.class).fill(Novedad.find.byId(id));
		return ok(editarNovedad.render(nForm));
	}
	
	public static Result actualizar() {
		Form<Novedad> nForm = form(Novedad.class).bindFromRequest();
		ObjectNode restJs = Json.newObject();
		ObjectNode evento = Json.newObject();
		try {
			
			if(nForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearNovedad.render(nForm));
			} else {
				nForm.get().update();
				
				Novedad e = Novedad.find.byId(nForm.get().id);
				
				restJs.put("success", true);
				evento.put("id", e.id);
				evento.put("nombre", e.agente.apellido);
				evento.put("fecha", utils.DateUtils.formatDate(e.fecha_inicio, "yyyy-MM-dd'T'HH:mm:ss"));
				evento.put("color", e.servicio.color);
				restJs.put("evento", evento);
				return ok(restJs);
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la novedad");
			return badRequest(crearNovedad.render(nForm));
		}
	}
	
}
