package controllers.recupero;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Usuario;
import models.recupero.Cheque;
import models.recupero.PresupuestoLinea;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoFacturaLinea;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoPago;
import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import utils.pagination.Pagination;
import views.html.recupero.recuperoPago.cheques.*;

@Security.Authenticated(Secured.class)
public class RecuperoChequesController extends Controller {

	final static Form<Cheque> lineaForm = form(Cheque.class);

	public static Result index(Long pagoId, Boolean editable) {

		Pagination<Cheque> lineas = Cheque.page(pagoId);

		Cheque rf = Cheque.find.byId(pagoId);

		return ok(indexCheque.render(lineas, editable,rf));
	}

	public static Result crear(String pagoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("id_pago_recupero", pagoId);

		Form<Cheque> linea = form(Cheque.class).bind(b);
		linea.discardErrors();
		return ok(crearDatosCheque.render(linea));
	}

	public static Result guardar() {
		Form<Cheque> lineaForm = form(Cheque.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario "+lineaForm.errors());
				return ok(crearDatosCheque.render(lineaForm));
			} else {
				Cheque l = lineaForm.get();

				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearDatosCheque.render(lineaForm));
		}

		Cheque linea = Cheque.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verDatos.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}


	public static Result editar(Long id) {
		flash().clear();
		Cheque linea = Cheque.find.byId(id);
		return ok(editarDatosCheque.render(lineaForm.fill(linea)));
	}

	public static Result actualizar() {

		Form<Cheque> lineaForm = form(Cheque.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarDatosCheque.render(lineaForm));
			} else {
				Cheque l = lineaForm.get();
				l.update(l.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarDatosCheque.render(lineaForm));
		}

		Cheque linea = Cheque.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verDatos.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			Cheque.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("success", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}


}
