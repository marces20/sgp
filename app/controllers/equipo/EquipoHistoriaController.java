package controllers.equipo;

import static play.data.Form.form;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.equipos.EquipoHistoria;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.pagination.Pagination;
import views.html.equipo.equipoHistoria.*;

public class EquipoHistoriaController extends Controller {

	final static Form<EquipoHistoria> historiaForm = form(EquipoHistoria.class);

	public static Result index(Long equipoId, Boolean editable) {

		Pagination<EquipoHistoria> historia = EquipoHistoria.page(equipoId);

		return ok(indexEquipoHistoria.render(historia, editable));
	}

	@CheckPermiso(key = "equipoHistoriaCrear")
	public static Result crear(String equipoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("equipo_id", equipoId);

		Form<EquipoHistoria> linea = form(EquipoHistoria.class).bind(b);
		linea.discardErrors();
		return ok(crearEquipoHistoria.render(linea));
	}

	@CheckPermiso(key = "equipoHistoriaCrear")
	public static Result guardar() {
		Form<EquipoHistoria> historiaForm = form(EquipoHistoria.class).bindFromRequest();

		try {
			if(historiaForm.hasErrors()) {
				System.out.println(historiaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearEquipoHistoria.render(historiaForm));
			} else {
				EquipoHistoria f = historiaForm.get();
				//f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				//f.create_date = new Date();
				f.save();

				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearEquipoHistoria.render(historiaForm));
		}

		EquipoHistoria historia = EquipoHistoria.find.where().eq("id", historiaForm.get().id).findUnique();
		Object c = verEquipoHistoria.render(historia);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "equipoHistoriaEditar")
	public static Result editar(Long id) {
		flash().clear();
		EquipoHistoria historia = EquipoHistoria.find.byId(id);
		return ok(editarEquipoHistoria.render(historiaForm.fill(historia)));
	}

	@CheckPermiso(key = "equipoHistoriaEditar")
	public static Result actualizar() {

		Form<EquipoHistoria> historiaForm = form(EquipoHistoria.class).bindFromRequest();

		try {
			if(historiaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarEquipoHistoria.render(historiaForm));
			} else {
				EquipoHistoria fl = historiaForm.get();
				//fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				//fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarEquipoHistoria.render(historiaForm));
		}

		EquipoHistoria historia = EquipoHistoria.find.where().eq("id", historiaForm.get().id).findUnique();
		Object c = verEquipoHistoria.render(historia);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "equipoHistoriaEliminar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			EquipoHistoria.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}
}
