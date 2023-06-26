package controllers.contabilidad;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.List;

import models.Estado;
import models.ExpedienteMovimiento;
import models.Factura;
import models.OrdenPagoCircuito;
import models.Organigrama;
import models.Usuario;

import com.avaje.ebean.Expr;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.contabilidad.ordenesPagosCircuitos.acciones.*;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class OrdenesPagosCircuitosAccionesController extends Controller {

	@CheckPermiso(key = "ordenesPagosCircuitoEditar")
	public static Result modalCargarExpedienteFisico() {
		return ok(modalCargarExpedienteFisico.render(form().bindFromRequest()));
	}

	public static Result cargarExpedienteFisico() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> opSeleccionados = getSeleccionados();

		if(opSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una OP.");
			return ok(modalCargarExpedienteFisico.render(d));
		}

		Integer idExpediente = null;
		if(!request().body().asFormUrlEncoded().get("expediente_fisico_id")[0].isEmpty()){
			idExpediente = new Integer(request().body().asFormUrlEncoded().get("expediente_fisico_id")[0]);
		}

		if(!soloBorrador(opSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalCargarExpedienteFisico.render(d));
		}


		if(d.hasErrors())
			return ok(modalCargarExpedienteFisico.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = OrdenPagoCircuito.CargarExpedienteFisico(idExpediente, opSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ opSeleccionados.size() +" seleccionados.");
			result.put("html", modalCargarExpedienteFisico.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCargarExpedienteFisico.render(d));
		}
	}

	@CheckPermiso(key = "ordenesPagosCircuitoPasarBorrador")
	public static Result modalPasarBorrador() {
		return ok(modalPasarBorrador.render(form().bindFromRequest()));
	}

	public static Result pasarBorradorMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> opcSeleccionados = getSeleccionados();

		if(opcSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un circuito.");
			return ok(modalPasarBorrador.render(d));
		}

		if(!soloCancelado(opcSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en cancelado.");
			return ok(modalPasarBorrador.render(d));
		}

		if(d.hasErrors())
			return ok(modalPasarBorrador.render(d));



		ObjectNode result = Json.newObject();
		try {

			List<OrdenPagoCircuito> ocx = OrdenPagoCircuito.find.where().in("id", opcSeleccionados).findList();
			List<Integer> idsExpedientes = OrdenPagoCircuito.getIdsExpedientes(ocx);

			Integer count2 = ExpedienteMovimiento.pasarOtroServicioMasivoConOps(idsExpedientes,ocx, Organigrama.TESORERIA, "");

			Integer count = OrdenPagoCircuito.modificarEstadoMasivo(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_BORRADOR, opcSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ opcSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarBorrador.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarBorrador.render(d));
		}

	}

	@CheckPermiso(key = "ordenesPagosCircuitoPasarContabilidad")
	public static Result modalPasarContabilidad(Long id) {
		return ok(modalPasarContabilidad.render(form().bindFromRequest()));
	}

	public static Result pasarContabilidadMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> opcSeleccionados = getSeleccionados();

		if(opcSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un circuito.");
			return ok(modalPasarContabilidad.render(d));
		}

		if(!soloBorrador(opcSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en borrador.");
			return ok(modalPasarContabilidad.render(d));
		}

		String comentario= null;
		try {
			comentario = request().body().asFormUrlEncoded().get("comentario")[0].toString();
		} catch (NullPointerException e) {
		}


		if(d.hasErrors())
			return ok(modalPasarContabilidad.render(d));

		ObjectNode result = Json.newObject();
		try {

			List<OrdenPagoCircuito> ocx = OrdenPagoCircuito.find.where().in("id", opcSeleccionados).findList();

			List<Integer> idsExpedientes = OrdenPagoCircuito.getIdsExpedientes(ocx);

			List<Long> soloDeMiServicio = ExpedienteMovimiento.getStringIsNotMovimientoServicioUsuario(idsExpedientes, Usuario.getUsurioSesion().organigrama_id);
			if(soloDeMiServicio.size() > 0) {
				String error = "Solo se puede modificar realizar movimientos donde el expediente se encuentren en mi servicio "+Usuario.getUsurioSesion().organigrama.nombre+" <br>";
				flash("error", error);
				return ok(modalPasarContabilidad.render(d));
			}



			Integer count2 = ExpedienteMovimiento.pasarOtroServicioMasivoConOps(idsExpedientes,ocx, Organigrama.CONTABILIDAD, comentario);

			Logger.debug("222222222 "+ocx);

			Integer count = OrdenPagoCircuito.modificarEstadoMasivo(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CONTABILIDAD, opcSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ opcSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarContabilidad.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarContabilidad.render(d));
		}

	}

	@CheckPermiso(key = "ordenesPagosCircuitoPasarRendiciones")
	public static Result modalPasarRendiciones() {
		return ok(modalPasarRendiciones.render(form().bindFromRequest()));
	}

	public static Result pasarRendicionesMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> opcSeleccionados = getSeleccionados();

		if(opcSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un circuito.");
			return ok(modalPasarRendiciones.render(d));
		}

		if(!soloContabilidad(opcSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en contabilidad.");
			return ok(modalPasarRendiciones.render(d));
		}

		if(d.hasErrors())
			return ok(modalPasarRendiciones.render(d));

		ObjectNode result = Json.newObject();
		try {

			List<OrdenPagoCircuito> ocx = OrdenPagoCircuito.find.where().in("id", opcSeleccionados).findList();
			List<Integer> idsExpedientes = OrdenPagoCircuito.getIdsExpedientes(ocx);
			List<Long> soloDeMiServicio = ExpedienteMovimiento.getStringIsNotMovimientoServicioUsuario(idsExpedientes, Usuario.getUsurioSesion().organigrama_id);
			if(soloDeMiServicio.size() > 0) {
				String error = "Solo se puede modificar realizar movimientos donde el expediente se encuentren en mi servicio "+Usuario.getUsurioSesion().organigrama.nombre+" <br>";
				flash("error", error);
				return ok(modalPasarRendiciones.render(d));
			}

			Integer count2 = ExpedienteMovimiento.pasarOtroServicioMasivoConOps(idsExpedientes,ocx, Organigrama.RENDICIONES, "");

			Integer count = OrdenPagoCircuito.modificarEstadoMasivo(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDICIONES, opcSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ opcSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarRendiciones.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarRendiciones.render(d));
		}

	}

	@CheckPermiso(key = "ordenesPagosCircuitoPasarRendido")
	public static Result modalPasarRendido() {
		return ok(modalPasarRendido.render(form().bindFromRequest()));
	}

	public static Result pasarRendidoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> opcSeleccionados = getSeleccionados();

		if(opcSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un circuito.");
			return ok(modalPasarRendido.render(d));
		}

		if(!soloRendiciones(opcSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en rendiciones.");
			return ok(modalPasarRendido.render(d));
		}

		if(d.hasErrors())
			return ok(modalPasarRendido.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = OrdenPagoCircuito.modificarEstadoMasivo(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDIDO, opcSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ opcSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarRendido.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarRendido.render(d));
		}

	}

	@CheckPermiso(key = "ordenesPagosCircuitoPasarCancelado")
	public static Result modalPasarCancelado() {
		return ok(modalPasarCancelado.render(form().bindFromRequest()));
	}

	public static Result pasarCanceladoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> opcSeleccionados = getSeleccionados();

		if(opcSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos un circuito.");
			return ok(modalPasarCancelado.render(d));
		}

		if(d.hasErrors())
			return ok(modalPasarCancelado.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = OrdenPagoCircuito.modificarEstadoMasivo(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CANCELADO, opcSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ opcSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarCancelado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarCancelado.render(d));
		}

	}


	public static Boolean soloBorrador(List<Integer> opcSeleccionados) {
		return OrdenPagoCircuito.find.where().ne("estado_id", Estado.ORDEN_PAGO_CIRCUITO_ESTADO_BORRADOR).in("id", opcSeleccionados).findRowCount() == 0;
	}
	public static Boolean soloContabilidad(List<Integer> opcSeleccionados) {
		return OrdenPagoCircuito.find.where().ne("estado_id", Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CONTABILIDAD).in("id", opcSeleccionados).findRowCount() == 0;
	}
	public static Boolean soloRendiciones(List<Integer> opcSeleccionados) {
		return OrdenPagoCircuito.find.where().ne("estado_id", Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDICIONES).in("id", opcSeleccionados).findRowCount() == 0;
	}
	public static Boolean soloCancelado(List<Integer> opcSeleccionados) {
		return OrdenPagoCircuito.find.where().ne("estado_id", Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CANCELADO).in("id", opcSeleccionados).findRowCount() == 0;
	}

	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("id_pago[]");
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
