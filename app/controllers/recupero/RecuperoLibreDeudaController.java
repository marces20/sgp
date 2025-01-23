package controllers.recupero;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.Cuenta;
import models.CuentaAnalitica;
import models.Usuario;
import models.recupero.RecuperoFacturaLinea;
import models.recupero.RecuperoLibreDeuda;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.recupero.recuperoLibreDeuda.*;

@Security.Authenticated(Secured.class)
public class RecuperoLibreDeudaController extends Controller {

	final static Form<RecuperoLibreDeuda> lineaForm = form(RecuperoLibreDeuda.class);

	public static Result index(Long clienteId, Boolean editable) {


		Pagination<RecuperoLibreDeuda> lineas = RecuperoLibreDeuda.page(clienteId);

		return ok(indexLibreDeuda.render(lineas, editable));
	}

	public static Result crear(String clienteId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("cliente_id", clienteId);


		Form<RecuperoLibreDeuda> linea = form(RecuperoLibreDeuda.class).bind(b);
		linea.discardErrors();
		return ok(crearLibreDeuda.render(linea));
	}

	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			RecuperoLibreDeuda.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("success", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}

	public static Result guardar() {
		Form<RecuperoLibreDeuda> lineaForm = form(RecuperoLibreDeuda.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario "+lineaForm.errors());
				return ok(crearLibreDeuda.render(lineaForm));
			} else {
				RecuperoLibreDeuda l = lineaForm.get();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLibreDeuda.render(lineaForm));
		}

		RecuperoLibreDeuda linea = RecuperoLibreDeuda.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLibreDeuda.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	public static Result editar(Long id) {
		flash().clear();
		RecuperoLibreDeuda linea = RecuperoLibreDeuda.find.byId(id);
		return ok(editarLibreDeuda.render(lineaForm.fill(linea)));
	}

	public static Result actualizar() {

		Form<RecuperoLibreDeuda> lineaForm = form(RecuperoLibreDeuda.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLibreDeuda.render(lineaForm));
			} else {
				RecuperoLibreDeuda fl = lineaForm.get();
				RecuperoLibreDeuda l = lineaForm.get();
				fl.write_user_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLibreDeuda.render(lineaForm));
		}

		RecuperoLibreDeuda linea = RecuperoLibreDeuda.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLibreDeuda.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

}
