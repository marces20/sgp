package controllers.rrhh;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.Agente;
import models.Certificacion;
import models.CertificacionCompra;
import models.DireccionProveedor;
import models.Estado;
import models.Proveedor;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.compras.certificaciones.modales.modalPasarBorrador;
import views.html.compras.certificacionesCompras.modales.modalPasarEnCurso;
import views.html.rrhh.agente.modales.*;

@Security.Authenticated(Secured.class)
public class AgentesAccionesController extends Controller {

	public static Result modalPasarAAprobado() {
		return ok(modalPasarAAprobado.render(form().bindFromRequest()));
	}

	public static Result pasarAAprobado() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> agentesSeleccionados = getSeleccionados();

		if (agentesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un agente.");
			return ok(modalPasarAAprobado.render(d));
		}

		if (!soloPreaprobado(agentesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado preaprobado.");
			return ok(modalPasarAAprobado.render(d));
		}

		if (d.hasErrors())
			return ok(modalPasarAAprobado.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Agente.modificarEstadoMasivo(Estado.AGENTE_APROBADO, agentesSeleccionados);
			result.put("success", true);
			flash("success",
					"Se actualizaron " + count + " registros de " + agentesSeleccionados.size() + " seleccionados.");
			result.put("html", modalPasarAAprobado.render(d).toString());
			return ok(result);
		} catch (Exception e) {
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarAAprobado.render(d));
		}
	}

	public static Result modalPasarABorrador() {
		return ok(modalPasarABorrador.render(form().bindFromRequest()));
	}

	public static Result pasarABorrador() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> agentesSeleccionados = getSeleccionados();

		if (agentesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un agente.");
			return ok(modalPasarABorrador.render(d));
		}

		if (!soloCancelado(agentesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado cancelado.");
			return ok(modalPasarABorrador.render(d));
		}

		if (d.hasErrors())
			return ok(modalPasarABorrador.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Agente.modificarEstadoMasivo(Estado.AGENTE_BORRADOR, agentesSeleccionados);
			result.put("success", true);
			flash("success",
					"Se actualizaron " + count + " registros de " + agentesSeleccionados.size() + " seleccionados.");
			result.put("html", modalPasarABorrador.render(d).toString());
			return ok(result);
		} catch (Exception e) {
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarABorrador.render(d));
		}
	}

	public static Result modalPasarACancelado() {
		return ok(modalPasarACancelado.render(form().bindFromRequest()));
	}

	public static Result pasarACancelado() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> agentesSeleccionados = getSeleccionados();

		if (agentesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un agente.");
			return ok(modalPasarACancelado.render(d));
		}

		if (d.hasErrors())
			return ok(modalPasarACancelado.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Agente.modificarEstadoMasivo(Estado.AGENTE_CANCELADO, agentesSeleccionados);
			result.put("success", true);
			flash("success",
					"Se actualizaron " + count + " registros de " + agentesSeleccionados.size() + " seleccionados.");
			result.put("html", modalPasarACancelado.render(d).toString());
			return ok(result);
		} catch (Exception e) {
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarACancelado.render(d));
		}
	}

	public static Result modalPasarACargado() {
		return ok(modalPasarACargado.render(form().bindFromRequest()));
	}

	public static Result pasarACargado() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> agentesSeleccionados = getSeleccionados();

		if (agentesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un agente.");
			return ok(modalPasarACargado.render(d));
		}

		if (!soloBorrador(agentesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalPasarACargado.render(d));
		}

		if (d.hasErrors())
			return ok(modalPasarACargado.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Agente.modificarEstadoMasivo(Estado.AGENTE_CARGADO, agentesSeleccionados);
			result.put("success", true);
			flash("success",
					"Se actualizaron " + count + " registros de " + agentesSeleccionados.size() + " seleccionados.");
			result.put("html", modalPasarACargado.render(d).toString());
			return ok(result);
		} catch (Exception e) {
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarACargado.render(d));
		}
	}

	public static Result modalPasarAPreaprobado() {
		return ok(modalPasarAPreaprobado.render(form().bindFromRequest()));
	}

	public static Result pasarAPreaprobado() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> agentesSeleccionados = getSeleccionados();

		if (agentesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un agente.");
			return ok(modalPasarAPreaprobado.render(d));
		}

		if (!soloCargado(agentesSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado cargado.");
			return ok(modalPasarAPreaprobado.render(d));
		}

		if (d.hasErrors())
			return ok(modalPasarAPreaprobado.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Agente.modificarEstadoMasivo(Estado.AGENTE_PREAPROBADO, agentesSeleccionados);
			result.put("success", true);
			flash("success",
					"Se actualizaron " + count + " registros de " + agentesSeleccionados.size() + " seleccionados.");
			result.put("html", modalPasarAPreaprobado.render(d).toString());
			return ok(result);
		} catch (Exception e) {
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarAPreaprobado.render(d));
		}
	}

	public static Result modalReplicarProveedor(Long id) {
		return ok(modalReplicarProveedor.render(form().bindFromRequest()));
	}

	public static Result replicarProveedor() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		String agenteId = null;

		try {
			agenteId = request().body().asFormUrlEncoded().get("agenteId")[0];
		} catch (NullPointerException e) {

		}

		if (agenteId == null || agenteId.isEmpty()) {
			flash("error", "No existe el id Agente.");
			return ok(modalReplicarProveedor.render(d));
		}

		Agente a = Agente.find.byId(new Long(agenteId));

		if (a.cuit == null) {
			flash("error", "El agente debe tener un cuit.");
			return ok(modalReplicarProveedor.render(d));
		}

		if (existeProveedor(a.cuit)) {
			flash("error", "Ya existe un Proveedor con este cuit.");
			return ok(modalReplicarProveedor.render(d));
		}

		if (existeProveedorAgente(a.id)) {
			flash("error", "Ya existe un Proveedor con este agente asociado.");
			return ok(modalReplicarProveedor.render(d));
		}

		ObjectNode result = Json.newObject();
		try {
			replicarProveedor(a);
			result.put("success", true);
			flash("success", "Se replicador el proveedor.");
			result.put("html", modalReplicarProveedor.render(d).toString());
			return ok(result);
		} catch (Exception e) {
			flash("error", "No se puede replicar el proveedor.");
			return ok(modalReplicarProveedor.render(d));
		}
	}

	private static Boolean existeProveedor(String cuit) {
		return Proveedor.find.where().eq("cuit", new Long(cuit)).findRowCount() > 0;
	}

	private static Boolean existeProveedorAgente(Long agente_id) {
		return Proveedor.find.where().eq("agente_id", agente_id).findRowCount() > 0;
	}

	private static boolean replicarProveedor(Agente a) {
		Boolean r = false;
		try {
			Ebean.beginTransaction();
			Proveedor p = new Proveedor();
			p.activo = true;
			p.agente_id = a.id;
			p.cuit = new Long(a.cuit);
			p.nombre = a.apellido;
			p.save();

			DireccionProveedor d = new DireccionProveedor();
			d.activo = true;
			d.calle = a.calle;
			d.email = a.email;
			d.fax = a.fax;
			d.localidad = a.localidad;
			d.mobile = a.mobile;
			d.numero = a.numero;
			d.proveedor_id = p.id;
			d.telefono = a.telefono;
			d.zip = a.zip;
			d.nombre = a.apellido;
			d.save();
			Ebean.commitTransaction();
			r = true;
		} catch (Exception e) {
			r = false;
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();
		}
		return r;
	}

	public static List<Integer> getSeleccionados() {
		String[] checks = request().body().asFormUrlEncoded().get("check_listado[]");
		List<Integer> ids = new ArrayList<Integer>();
		if (checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}

	public static Boolean soloBorrador(List<Integer> agentesSeleccionados) {
		return Agente.find.where().ne("estado_id", Estado.AGENTE_BORRADOR).in("id", agentesSeleccionados)
				.findRowCount() == 0;
	}

	public static Boolean soloPreaprobado(List<Integer> agentesSeleccionados) {
		return Agente.find.where().ne("estado_id", Estado.AGENTE_PREAPROBADO).in("id", agentesSeleccionados)
				.findRowCount() == 0;
	}

	public static Boolean soloCancelado(List<Integer> agentesSeleccionados) {
		return Agente.find.where().ne("estado_id", Estado.AGENTE_CANCELADO).in("id", agentesSeleccionados)
				.findRowCount() == 0;
	}

	public static Boolean soloCargado(List<Integer> agentesSeleccionados) {
		return Agente.find.where().ne("estado_id", Estado.AGENTE_CARGADO).in("id", agentesSeleccionados)
				.findRowCount() == 0;
	}

}
