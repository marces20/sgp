package controllers.equipo;

import static play.data.Form.form;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.Estado;
import models.Usuario;
import models.equipos.EquipoIncidencia;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.pagination.Pagination;
import views.html.equipo.equipoIncidencia.*;

public class EquipoIncidenciaController extends Controller {

	final static Form<EquipoIncidencia> incidenciaForm = form(EquipoIncidencia.class);

	public static Result index(Long equipoId, Boolean editable) {

		Pagination<EquipoIncidencia> historia = EquipoIncidencia.page(equipoId);

		return ok(indexEquipoIncidencia.render(historia, editable));
	}

	@CheckPermiso(key = "equipoIncidenciaCrear")
	public static Result crear(String equipoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("equipo_id", equipoId);

		Form<EquipoIncidencia> linea = form(EquipoIncidencia.class).bind(b);
		linea.discardErrors();
		return ok(crearEquipoIncidencia.render(linea));
	}

	@CheckPermiso(key = "equipoIncidenciaCrear")
	public static Result guardar() {
		Form<EquipoIncidencia> incidenciaForm = form(EquipoIncidencia.class).bindFromRequest();

		try {
			if(incidenciaForm.hasErrors()) {
				System.out.println(incidenciaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearEquipoIncidencia.render(incidenciaForm));
			} else {
				EquipoIncidencia f = incidenciaForm.get();
				f.create_user = new Long(Usuario.getUsuarioSesion());
				f.estado_id = (long) Estado.EQUIPO_INCIDENCIA_ABIERTO;
				//f.create_date = new Date();
				f.save();

				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearEquipoIncidencia.render(incidenciaForm));
		}

		EquipoIncidencia incidencia = EquipoIncidencia.find.where().eq("id", incidenciaForm.get().id).findUnique();
		Object c = verEquipoIncidencia.render(incidencia);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "equipoIncidenciaEditar")
	public static Result editar(Long id) {
		flash().clear();
		EquipoIncidencia incidencia = EquipoIncidencia.find.byId(id);
		return ok(editarEquipoIncidencia.render(incidenciaForm.fill(incidencia)));
	}

	@CheckPermiso(key = "equipoIncidenciaEditar")
	public static Result actualizar() {

		Form<EquipoIncidencia> incidenciaForm = form(EquipoIncidencia.class).bindFromRequest();

		try {
			if(incidenciaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarEquipoIncidencia.render(incidenciaForm));
			} else {
				EquipoIncidencia fl = incidenciaForm.get();
				//fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				//fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarEquipoIncidencia.render(incidenciaForm));
		}

		EquipoIncidencia incidencia = EquipoIncidencia.find.where().eq("id", incidenciaForm.get().id).findUnique();
		Object c = verEquipoIncidencia.render(incidencia);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "equipoIncidenciaEliminar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			EquipoIncidencia.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}
}
