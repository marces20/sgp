package controllers.recupero;

import static play.data.Form.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.recupero.Cheque;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoRecibo;
import models.recupero.RecuperoReciboFactura;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.recupero.recuperoRecibo.recuperoReciboFactura.*;

@Security.Authenticated(Secured.class)
public class RecuperoReciboFacturasController extends Controller {

	final static Form<RecuperoReciboFactura> lineaForm = form(RecuperoReciboFactura.class);

	public static Result index(Long recuperoReciboId, Boolean editable) {

		Pagination<RecuperoReciboFactura> lineas = RecuperoReciboFactura.page(recuperoReciboId);



		return ok(indexRecuperoReciboFactura.render(lineas, editable));
	}

	public static Result crear(String recuperoReciboId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("recupero_recibo_id", recuperoReciboId);

		Form<RecuperoReciboFactura> linea = form(RecuperoReciboFactura.class).bind(b);
		linea.discardErrors();
		return ok(crearRecuperoReciboFactura.render(linea));
	}

	public static Result guardar() {
		Form<RecuperoReciboFactura> lineaForm = form(RecuperoReciboFactura.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario "+lineaForm.errors());
				return ok(crearRecuperoReciboFactura.render(lineaForm));
			} else {


				RecuperoReciboFactura l = lineaForm.get();


				RecuperoFactura rf = RecuperoFactura.find.byId(l.recupero_factura_id);

				List<RecuperoReciboFactura> ll = RecuperoReciboFactura.find.where().eq("recupero_recibo_id", l.recupero_recibo_id).findList();

				/*if(ll.size() > 0) {
					if(ll.get(0).recuperoFactura.cliente_id.compareTo(rf.cliente_id) != 0) {
						flash("error", "No se puede cargar la factura. Existe una factura con otro cliente cargada.");
						return ok(crearRecuperoReciboFactura.render(lineaForm));
					}
				}*/

				List<RecuperoReciboFactura> ll2 = RecuperoReciboFactura.find.where().eq("recupero_factura_id", l.recupero_factura_id).eq("recupero_recibo_id", l.recupero_recibo_id).findList();
				if(ll2.size() > 0) {
					flash("error", "No se puede cargar la factura. Ya existe una linea con esta factura cargada.");
					return ok(crearRecuperoReciboFactura.render(lineaForm));
				}

				if(l.monto.compareTo(rf.getSaldoPendiente()) > 0) {
					flash("error", "El monto es superior al Saldo Pendiente de la factura.");
					return ok(crearRecuperoReciboFactura.render(lineaForm));
				}

				RecuperoRecibo rr = RecuperoRecibo.find.byId(l.recupero_recibo_id);
				rr.cliente_id = rf.cliente_id.intValue();
				rr.save();



				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearRecuperoReciboFactura.render(lineaForm));
		}

		RecuperoReciboFactura linea = RecuperoReciboFactura.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verRecuperoReciboFactura.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	public static Result editar(Long id) {
		flash().clear();
		RecuperoReciboFactura linea = RecuperoReciboFactura.find.byId(id);
		return ok(editarRecuperoReciboFactura.render(lineaForm.fill(linea)));
	}

	public static Result actualizar() {

		Form<RecuperoReciboFactura> lineaForm = form(RecuperoReciboFactura.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarRecuperoReciboFactura.render(lineaForm));
			} else {
				RecuperoReciboFactura l = lineaForm.get();

				RecuperoFactura rf = RecuperoFactura.find.byId(l.recupero_factura_id);

				List<RecuperoReciboFactura> ll = RecuperoReciboFactura.find.where().eq("recupero_recibo_id", l.recupero_recibo_id).ne("id",l.id).findList();
				if(ll.size() > 0) {
					if(ll.get(0).recuperoFactura.cliente_id.compareTo(rf.cliente_id) == 0) {
						flash("error", "No se puede cargar la factura. Existe una factura con otro cliente cargada.");
						return ok(editarRecuperoReciboFactura.render(lineaForm));
					}
				}

				List<RecuperoReciboFactura> ll2 = RecuperoReciboFactura.find.where().eq("recupero_factura_id", l.recupero_factura_id).eq("recupero_recibo_id", l.recupero_recibo_id).ne("id",l.id).findList();
				if(ll2.size() > 0) {
					flash("error", "No se puede cargar la factura. Ya existe una linea con esta factura cargada.");
					return ok(editarRecuperoReciboFactura.render(lineaForm));
				}


				if(l.monto.compareTo(rf.getSaldoPendiente()) > 0) {
					flash("error", "El monto es superior al Saldo Pendiente de la factura.");
					return ok(editarRecuperoReciboFactura.render(lineaForm));
				}

				RecuperoRecibo rr = RecuperoRecibo.find.byId(l.recupero_recibo_id);
				rr.cliente_id = rf.cliente_id.intValue();
				rr.save();

				l.update(l.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarRecuperoReciboFactura.render(lineaForm));
		}

		RecuperoReciboFactura linea = RecuperoReciboFactura.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verRecuperoReciboFactura.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			RecuperoReciboFactura.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("success", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}
}
