package controllers.patrimonio;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.ActaRecepcion;
import models.Articulo;
import models.Categoria;
import models.Estado;
import models.Expediente;
import models.OrdenProvision;
import models.Recepcion;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.contabilidad.bancos.crearBanco;
import views.html.patrimonio.actaRecepcion.modales.*;

@Security.Authenticated(Secured.class)
public class ActasRecepcionAccionesController extends Controller {
	final static Form<ActaRecepcion> actaForm = form(ActaRecepcion.class);

	@CheckPermiso(key = "actaRecepcionCrear")
	public static Result crear() {
		return ok(modalCrearActaRecepcion.render(actaForm));
	}

	@CheckPermiso(key = "actaRecepcionCrear")
	public static Result guardar() {
		List<Integer> ids = getSeleccionados();

		Form<ActaRecepcion> actaForm = form(ActaRecepcion.class).bindFromRequest();

		if (ids.isEmpty()) {
			flash("error", "Debe seleccionar al menos 1 recepción.");
			return ok(modalCrearActaRecepcion.render(actaForm));
		}

		if (actaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(modalCrearActaRecepcion.render(actaForm));
		}

		String sqlNumero = "SELECT id FROM actas_recepcion WHERE numero = '" + actaForm.data().get("numero").trim()
				+ "' and ejercicio_id = " + actaForm.data().get("ejercicio_id");

		SqlRow numero = Ebean.createSqlQuery(sqlNumero).findUnique();

		if (numero != null) {
			flash("error", "El número de acta ya existe.");
			return ok(modalCrearActaRecepcion.render(actaForm));
		}

		String sql = " SELECT id FROM recepciones WHERE acta_id IS NOT NULL AND id in (:listId)";
		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("listId", ids).findList();

		if (l.size() > 0) {
			flash("error", "Las recepciones no deben tener un acta asignada.");
			return ok(modalCrearActaRecepcion.render(actaForm));
		}

		String sql2 = " SELECT * FROM recepciones r " +
				" INNER JOIN ordenes_provision op ON op.id = r.orden_provision_id " +
				" INNER JOIN ordenes o ON o.id = op.orden_compra_id " +
				" WHERE r.id in (:listId) AND o.fecha_provision is null ";
		List<SqlRow> ordenesSinFecha = Ebean.createSqlQuery(sql2).setParameter("listId", ids).findList();
		if (ordenesSinFecha.size() > 0) {
			flash("error", "No se puede asignar acta porque la Orden no tiene Fecha de Provision Asignada.");
			return ok(modalCrearActaRecepcion.render(actaForm));
		}

		if (!Permiso.check("verTodoOrdenProvision")) {
			if (Usuario.getUsurioSesion().organigrama != null
					&& Usuario.getUsurioSesion().organigrama.deposito != null) {
				String sql3 = " SELECT * FROM recepciones r " +
						" INNER JOIN ordenes_provision op ON op.id = r.orden_provision_id " +
						" INNER JOIN ordenes o ON o.id = op.orden_compra_id " +
						" WHERE r.id in (:listId) AND o.deposito_id <> :deposito_id ";
				List<SqlRow> ordenesControlDeposito = Ebean.createSqlQuery(sql3)
						.setParameter("listId", ids)
						.setParameter("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id)
						.findList();

				if (ordenesControlDeposito.size() > 0) {
					flash("error", "No tiene permisos para asignar actas a esta institucion.");
					return ok(modalCrearActaRecepcion.render(actaForm));
				}
			} else {

				flash("error", "No tiene permisos para asignar actas a esta institucion.");
				return ok(modalCrearActaRecepcion.render(actaForm));
			}
		}

		String sqlOrdenDistinta = " SELECT orden_provision_id FROM recepciones WHERE id in (:listId) GROUP BY orden_provision_id";
		List<SqlRow> recepcionesOrdenDistinta = Ebean.createSqlQuery(sqlOrdenDistinta).setParameter("listId", ids)
				.findList();

		if (recepcionesOrdenDistinta.size() > 1) {
			flash("error", "Las recepciones deben pertenecer a la misma orden de provisión.");
			return ok(modalCrearActaRecepcion.render(actaForm));
		}

		Ebean.beginTransaction();

		try {

			ActaRecepcion acta = actaForm.get();
			acta.create_usuario_id = Usuario.getUsuarioSesion();
			acta.orden_provision_id = recepcionesOrdenDistinta.get(0).getInteger("orden_provision_id");
			acta.create_date = new Date();
			acta.estado_id = (long) Estado.ACTA_ESTADO_BORRADOR;
			acta.auto_creacion = false;
			acta.save();
			SqlUpdate update = Ebean.createSqlUpdate("UPDATE recepciones SET acta_id = :actaId WHERE id IN (:ids)");
			update.setParameter("actaId", acta.id);
			update.setParameter("ids", ids);
			update.execute();

			ObjectNode result = Json.newObject();
			result.put("success", true);
			flash("success", "El acta de recepción número <b>" + acta.numero + "</b> se ha creado correctamente.");

			Ebean.commitTransaction();
			return ok(result);
		} catch (Exception e) {
			Ebean.rollbackTransaction();
			flash("error", "Ocurrió un problema al crear el acta de recepción. " + e.getMessage());
		} finally {
			Ebean.endTransaction();
		}

		return ok(modalCrearActaRecepcion.render(actaForm));
	}

	@CheckPermiso(key = "actaRecepcionRevocar")
	public static Result revocar() {
		List<Integer> ids = getSeleccionados();
		ObjectNode result = Json.newObject();

		String sqlOrdenDistinta = " SELECT acta_id FROM recepciones WHERE id in (:listId) GROUP BY acta_id";
		List<SqlRow> recepcionesOrdenDistinta = Ebean.createSqlQuery(sqlOrdenDistinta).setParameter("listId", ids)
				.findList();

		if (recepcionesOrdenDistinta.size() > 1) {
			result.put("messagge", "Las recepciones seleccionadas deben pertenecer al mismo número de acta.");
			return ok(result);
		}

		if (!Permiso.check("verTodoOrdenProvision")) {
			if (Usuario.getUsurioSesion().organigrama != null
					&& Usuario.getUsurioSesion().organigrama.deposito != null) {
				String sql3 = " SELECT * FROM recepciones r " +
						" INNER JOIN ordenes_provision op ON op.id = r.orden_provision_id " +
						" INNER JOIN ordenes o ON o.id = op.orden_compra_id " +
						" WHERE r.id in (:listId) AND o.deposito_id <> :deposito_id ";
				List<SqlRow> ordenesControlDeposito = Ebean.createSqlQuery(sql3)
						.setParameter("listId", ids)
						.setParameter("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id)
						.findList();

				if (ordenesControlDeposito.size() > 0) {
					result.put("messagge", "No tiene permisos para revocar actas a esta institucion.");
					return ok(result);
				}
			} else {

				result.put("messagge", "No tiene permisos para revocar actas a esta institucion.");
				return ok(result);
			}
		}

		ActaRecepcion a = ActaRecepcion.find.byId(recepcionesOrdenDistinta.get(0).getLong("acta_id"));

		if (a.estado_id == Estado.ACTA_ESTADO_APROBADA || a.estado_id == Estado.ACTA_ESTADO_ENCURSO
				|| a.estado_id == Estado.ACTA_ESTADO_CANCELADA) {
			result.put("messagge", "Solo se puede revocar actas que estén en estado borrador.");
			return ok(result);
		}

		try {
			SqlUpdate update = Ebean.createSqlUpdate("UPDATE recepciones SET acta_id = NULL WHERE id IN (:ids)");
			System.out.println(update.getSql());
			update.setParameter("ids", ids);
			update.execute();
			result.put("success", true);
			flash("success", "El acta ha sido revocada de la recepción.");
			return ok(result);
		} catch (Exception e) {
			result.put("messagge", "No se ha podido revocar.");
		}

		return ok(result);
	}

	@CheckPermiso(key = "actaRecepcionAsignar")
	public static Result modalAsignar() {
		return ok(modalAsignarActaRecepcion.render(actaForm));
	}

	@CheckPermiso(key = "actaRecepcionAsignar")
	public static Result asignar() {
		Form<ActaRecepcion> actaForm = form(ActaRecepcion.class).bindFromRequest();
		List<Integer> ids = getSeleccionados();

		if (ids.isEmpty()) {
			flash("error", "Debe seleccionar al menos una recepción.");
			return ok(modalAsignarActaRecepcion.render(actaForm));
		}

		String sql2 = " SELECT * FROM recepciones r " +
				" INNER JOIN ordenes_provision op ON op.id = r.orden_provision_id " +
				" INNER JOIN ordenes o ON o.id = op.orden_compra_id " +
				" WHERE r.id in (:listId) AND o.fecha_provision is null ";
		List<SqlRow> ordenesSinFecha = Ebean.createSqlQuery(sql2).setParameter("listId", ids).findList();
		if (ordenesSinFecha.size() > 0) {
			flash("error", "No se puede asignar acta porque la Orden no tiene Fecha de Provision Asignada.");
			return ok(modalAsignarActaRecepcion.render(actaForm));
		}

		if (!Permiso.check("verTodoOrdenProvision")) {
			if (Usuario.getUsurioSesion().organigrama != null
					&& Usuario.getUsurioSesion().organigrama.deposito != null) {
				String sql3 = " SELECT * FROM recepciones r " +
						" INNER JOIN ordenes_provision op ON op.id = r.orden_provision_id " +
						" INNER JOIN ordenes o ON o.id = op.orden_compra_id " +
						" WHERE r.id in (:listId) AND o.deposito_id <> :deposito_id ";
				List<SqlRow> ordenesControlDeposito = Ebean.createSqlQuery(sql3)
						.setParameter("listId", ids)
						.setParameter("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id)
						.findList();

				if (ordenesControlDeposito.size() > 0) {
					flash("error", "No tiene permisos para asignar actas a esta institucion.");
					return ok(modalAsignarActaRecepcion.render(actaForm));
				}
			} else {

				flash("error", "No tiene permisos para asignar actas a esta institucion.");
				return ok(modalAsignarActaRecepcion.render(actaForm));
			}
		}

		String sql = "SELECT id FROM recepciones WHERE acta_id IS NOT NULL AND id in (:listId)";

		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("listId", ids).findList();

		if (l.size() > 0) {
			flash("error", "Las recepciones no deben tener un acta asignada.");
			return ok(modalAsignarActaRecepcion.render(actaForm));
		}

		String sqlOrdenDistinta = " SELECT orden_provision_id FROM recepciones WHERE id in (:listId) GROUP BY orden_provision_id";
		List<SqlRow> recepcionesOrdenDistinta = Ebean.createSqlQuery(sqlOrdenDistinta).setParameter("listId", ids)
				.findList();

		if (recepcionesOrdenDistinta.size() > 1) {
			flash("error", "Las recepciones deben pertenecer a la misma orden de provisión.");
			return ok(modalAsignarActaRecepcion.render(actaForm));
		}

		String numeroActa = form().bindFromRequest().get("numero").trim();
		Integer ejercicio = Integer.parseInt(form().bindFromRequest().get("ejercicio_id"));
		if (numeroActa.isEmpty()) {
			flash("error", "El número de acta es requerido.");
			return ok(modalAsignarActaRecepcion.render(actaForm));
		}

		ActaRecepcion acta = ActaRecepcion.find.where().eq("numero", numeroActa).eq("ejercicio_id", ejercicio)
				.findUnique();

		if (acta == null) {
			flash("error", "El número de acta no existe.");
			return ok(modalAsignarActaRecepcion.render(actaForm));
		}

		if (!acta.recepciones.isEmpty()) {
			flash("error", "El número de acta ya pertenece a recepciones de productos.");
			return ok(modalAsignarActaRecepcionCertificaciones.render(actaForm));
		}

		if (!acta.certificaciones.isEmpty()) {
			flash("error", "El número de acta ya pertenece a certificaciones de servicios.");
			return ok(modalAsignarActaRecepcion.render(actaForm));
		}

		try {
			SqlUpdate update = Ebean.createSqlUpdate("UPDATE recepciones SET acta_id = :actaId WHERE id IN (:ids)");
			update.setParameter("actaId", acta.id);
			update.setParameter("ids", ids);
			update.execute();

			acta.orden_provision_id = recepcionesOrdenDistinta.get(0).getInteger("orden_provision_id");
			acta.save();
		} catch (Exception e) {
			flash("error", "No se han podido asignar acta.");
			System.out.println(e.getMessage());
			return ok(modalAsignarActaRecepcion.render(actaForm));
		}

		flash("success", "Las recepciones se han asignado al acta número <b>" + numeroActa + "</b>.");
		ObjectNode result = Json.newObject();
		result.put("success", true);

		return ok(result);
	}

	public static List<Integer> getSeleccionados() {
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado[]");
		} catch (NullPointerException e) {
		}

		List<Integer> ids = new ArrayList<Integer>();
		if (checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}

}
