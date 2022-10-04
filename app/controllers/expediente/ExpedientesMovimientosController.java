package controllers.expediente;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.ExpedienteMovimiento;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.expediente.expedientesMovimientos.*;

@Security.Authenticated(Secured.class)
public class ExpedientesMovimientosController extends Controller {
	
	final static Form<ExpedienteMovimiento> lineaForm = form(ExpedienteMovimiento.class);
	
	public static Result index(Long expedienteId, Boolean editable) {
		
		Pagination<ExpedienteMovimiento> lineas = ExpedienteMovimiento.page(expedienteId);

		return ok(indexExpedienteMovimiento.render(lineas, editable));
	}
	
	public static Result crear(String expedienteId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("expediente_id", expedienteId);
		Form<ExpedienteMovimiento> linea = form(ExpedienteMovimiento.class).bind(b);
		linea.discardErrors();
		return ok(crearExpedienteMovimiento.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			ExpedienteMovimiento.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<ExpedienteMovimiento> lineaForm = form(ExpedienteMovimiento.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearExpedienteMovimiento.render(lineaForm));
			} else {
				
				ExpedienteMovimiento f = lineaForm.get();
				
				if(Usuario.getUsurioSesion().organigrama == null){
					flash("error", "Este usuario no tiene asignado un Servicio/Depto");
					return ok(crearExpedienteMovimiento.render(lineaForm));
				}
				if(!ExpedienteMovimiento.isLastMovimientoServicioUsuario(f.expediente_id,Usuario.getUsurioSesion().organigrama_id)) {
					flash("error", "No puede realizar el pase por que pertence a otro servicio.");
					return ok(crearExpedienteMovimiento.render(lineaForm));
				}
				
				Date ahora = new Date();
				Integer codigo = ExpedienteMovimiento.getSecuenciaExpedienteMovimientoCodigo();
				
				f.usuario_id = new Long(Usuario.getUsuarioSesion());
				f.fecha_llegada = ahora;
				f.cancelado = false;
				f.codigo = codigo;
				f.save();
				
				ExpedienteMovimiento ma = ExpedienteMovimiento.getMovimientoAnterior(f);
				if(ma != null){
					ma.fecha_salida = ahora;
					ma.update();
				}
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro."+e);
			return ok(crearExpedienteMovimiento.render(lineaForm));
		}
		
		ExpedienteMovimiento linea = ExpedienteMovimiento.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verExpedienteMovimiento.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result editar(Long id) {
		flash().clear();
		ExpedienteMovimiento linea = ExpedienteMovimiento.find.byId(id);
		return ok(editarExpedienteMovimiento.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<ExpedienteMovimiento> lineaForm = form(ExpedienteMovimiento.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarExpedienteMovimiento.render(lineaForm));
			} else {
				ExpedienteMovimiento fl = lineaForm.get();
				 
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarExpedienteMovimiento.render(lineaForm));
		}
		
		ExpedienteMovimiento linea = ExpedienteMovimiento.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verExpedienteMovimiento.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado[]");
		} catch (NullPointerException e) {
		}
		
		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}
}
