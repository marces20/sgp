package controllers.contabilidad;

import static play.data.Form.form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import models.BalanceCuentaPropia;
import models.Ejercicio;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.MiPago;
import models.Pago;
import models.Proveedor;
import models.Usuario;
import models.auth.Permiso;

import org.apache.commons.lang.ArrayUtils;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NoRecordModelException;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.contabilidad.pagos.crearPagoProveedor;
import views.html.contabilidad.pagos.editarPagoProveedor;
import views.html.contabilidad.pagos.indexPagoProveedor;
import views.html.contabilidad.pagos.verPagoProveedor;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class PagosController extends Controller {

	final static Form<Pago> pagoForm = form(Pago.class);

	public static Result URL_LISTA_PAGO_PROVEEDOR = redirect(
			controllers.contabilidad.routes.PagosController.index() + "?" + UriTrack.decode());

	// proveedor, expediente, periodo, monto
	@CheckPermiso(key = "pagosVer")
	public static Result index() {

		DynamicForm d = form().bindFromRequest();

		return ok(
				indexPagoProveedor.render(
						Pago.page(
								RequestVar.get("fecha_pago_desde"),
								RequestVar.get("fecha_pago_hasta"),
								RequestVar.get("proveedor.id"),
								RequestVar.get("periodo.id"),
								RequestVar.get("expediente.id"),
								RequestVar.get("ejercicio"),
								RequestVar.get("ordenPago.id"),
								RequestVar.get("referencia"),
								RequestVar.get("profe"),
								RequestVar.get("tipo_proveedor"),
								RequestVar.get("btnFiltro[0]"), // borrador
								RequestVar.get("btnFiltro[1]"), // contabilizado
								RequestVar.get("btnFiltro[2]"), // rendido
								RequestVar.get("btnFiltro[3]"), // imputado
								RequestVar.get("btnFiltro[4]"), // cancelado
								RequestVar.get("cuentaImpuesto.id"),
								RequestVar.get("factura.proveedor.id"),
								RequestVar.get("tipo_proveedor_contraparte"),
								RequestVar.get("guardia"),
								RequestVar.get("fecha_entrega_factura_desde"),
								RequestVar.get("fecha_entrega_factura_hasta"),
								RequestVar.get("fecha_opg_desde"),
								RequestVar.get("fecha_opg_hasta"),
								RequestVar.get("fecha_conciliacion_desde"),
								RequestVar.get("fecha_conciliacion_hasta"),
								RequestVar.get("tipo_pago"),
								RequestVar.get("tipo"),
								RequestVar.get("rp"),
								RequestVar.get("tipo_cuenta_id"),
								RequestVar.get("emergencia")),
						d));
	}

	@CheckPermiso(key = "pagosVer")
	public static Result ver(Long id) {
		Pago pago = Pago.find.byId(id);
		if (!Permiso.check("verExpedientesGuardiasMonotributo")
				&& ArrayUtils.contains(Expediente.EXP_GUARDIA_MONOTRIBUTOS, pago.expediente_id)) {
			return URL_LISTA_PAGO_PROVEEDOR;
		}
		return ok(verPagoProveedor.render(pagoForm.fill(pago), pago));
	}

	@CheckPermiso(key = "pagosDuplicar")
	public static Result duplicar(Long id) {

		try {

			Pago pago = new Pago();

			Long idNew = pago.duplicar(id);

			if (idNew != -1 && idNew != 0) {
				flash("success", "Se ha duplicado el pago");
				return redirect(controllers.contabilidad.routes.PagosController.editar(idNew) + UriTrack.get("&"));
			} else {
				flash("error", "No se ha podido duplicar el pago");
				String refererUrl = request().getHeader("referer");
				return redirect(refererUrl);
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido duplicar el pago");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}

	@CheckPermiso(key = "pagosCrear")
	public static Result crear() {
		Map<String, String> p = new HashMap<String, String>();
		p.put("nombre", "PAG");

		Form<Pago> pagoForm = form(Pago.class).bind(p);
		pagoForm.discardErrors();

		return ok(crearPagoProveedor.render(pagoForm));
	}

	@CheckPermiso(key = "pagosCrear")
	public static Result guardar() {

		Form<Pago> pagoForm = form(Pago.class).bindFromRequest();

		try {
			Logger.debug("as " + pagoForm.errors());
			if (pagoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearPagoProveedor.render(pagoForm));
			} else {

				Pago p = pagoForm.get();

				Factura f = Factura.find.byId(new Long(p.factura_id));

				/*
				 * if(Pago.controlHayReferenciaRepetida(p.referencia)){
				 * pagoForm.reject("referencia","Ya existe referencia.");
				 * flash("error", "Ya existe esta referencia en otro pago.");
				 * return badRequest(crearPagoProveedor.render(pagoForm));
				 * }
				 */

				p.estado_id = (long) Estado.PAGO_ESTADO_BORRADOR;
				p.tipo = "payment";
				p.create_usuario_id = (long) Usuario.getUsuarioSesion();
				p.create_date = new Date();
				p.save();
				flash("success", "El pago  se ha actualizado");
				return redirect(
						controllers.contabilidad.routes.PagosController.ver(pagoForm.get().id) + UriTrack.get("&"));

			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el Pago");
			return badRequest(crearPagoProveedor.render(pagoForm));
		}

		// return URL_LISTA_PAGO_PROVEEDOR;
	}

	@CheckPermiso(key = "pagosModificar")
	public static Result editar(Long id) {
		Pago pago = null;

		try {
			pago = loadPago(id);
			if (!Permiso.check("verExpedientesGuardiasMonotributo")
					&& ArrayUtils.contains(Expediente.EXP_GUARDIA_MONOTRIBUTOS, pago.expediente_id)) {
				return URL_LISTA_PAGO_PROVEEDOR;
			}

			if (pago == null) {
				flash("error", "No se encuentra el pago.");
				return redirect(controllers.contabilidad.routes.PagosController.index() + "?" + UriTrack.decode());
				// }else if(pago.estado_id == Estado.PAGO_ESTADO_CANCELADO || pago.estado_id ==
				// Estado.PAGO_ESTADO_CONCILIADO){
			}

		} catch (NoRecordModelException e) {
		}

		return ok(editarPagoProveedor.render(pagoForm.fill(pago), pago));
	}

	@CheckPermiso(key = "pagosModificar")
	public static Result actualizar(Long id) throws Exception {
		Pago pago = null;
		Pago pagol = null;
		try {
			Form<Pago> pagoForm = form(Pago.class).bindFromRequest();
			pagol = loadPago(id);
			Logger.debug(pagoForm.toString());
			if (pagoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarPagoProveedor.render(pagoForm, pagol));
			}
			// Logger.debug("----------------------
			// "+pagoForm.get().factura.numero_factura);
			pago = pagoForm.get();
			Logger.debug("----------------------xxxxxxxxxxxx " + pagoForm.get().profe);
			Logger.debug("----------------------xxxxxxxxxxxx " + pagoForm.get().total);
			Logger.debug("----------------------xxxxxxxxxxxx " + pagoForm.get().total_credito);
			if (Pago.controlHayReferenciaRepetida(pago.referencia, pago.id.intValue())) {
				pagoForm.reject("referencia", "Ya existe referencia.");
				flash("error", "Ya existe esta referencia en otro pago.");
				return badRequest(editarPagoProveedor.render(pagoForm, pagol));
			}

			Factura f = Factura.find.byId((long) pago.factura_id);

			if (!pagoForm.get().factura.numero_factura.isEmpty() && f.factura_principal_id != null
					&& f.facturaPrincipal.numero_factura != null && !f.facturaPrincipal.numero_factura.isEmpty()) {

				String nff = f.facturaPrincipal.numero_factura.replace("-", "").replace(" ", "");
				String nfp = pagoForm.get().factura.numero_factura.replace("-", "").replace(" ", "");

				if (nff.compareToIgnoreCase(nfp) != 0) {
					flash("error",
							"El N° de factura Principal cargada no coincide con el N° de factura que se está cargando. N°FACTURA: "
									+ f.facturaPrincipal.numero_factura);
					return badRequest(editarPagoProveedor.render(pagoForm, pagol));
				}

			}

			pago.estado_id = pagol.estado_id;
			pago.id = pagol.id;
			pago.tipo = pagol.tipo;
			pago.write_usuario_id = (long) Usuario.getUsuarioSesion();
			pago.write_date = new Date();
			pago.update(pago.id);
			pago = loadPago(id);

			if (pago.estado_id.intValue() != Estado.PAGO_ESTADO_CANCELADO
					&& pago.estado_id.intValue() != Estado.PAGO_ESTADO_BORRADOR) {
				BalanceCuentaPropia.agregarLineaDesdePago(pago);
			}

			f.numero_factura = pagoForm.get().factura.numero_factura;
			f.numero_factura = pagoForm.get().factura.numero_factura;
			f.update();

			if (pago.tipo.compareToIgnoreCase("impuestos") != 0) {
				Pago.modificarFechaPagoImpuesto(pago.fecha_pago, pago.id);
			}

			flash("success", "El pago se ha actualizado");
			return redirect(controllers.contabilidad.routes.PagosController.ver(pagoForm.get().id) + UriTrack.get("&"));

		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el Pago");
			return badRequest(editarPagoProveedor.render(pagoForm, pago));
		} catch (NoRecordModelException e) {
		}
		return ok(editarPagoProveedor.render(pagoForm, pagol));

	}

	@CheckPermiso(key = "pagosEliminar")
	public static Result eliminar(Long id) {

		try {
			Pago pago = Ebean.find(Pago.class).select("id,estado_id").setId(id).findUnique();

			if (pago.estado_id != Estado.PAGO_ESTADO_BORRADOR) {
				flash("error", "Unicamente se pueden eliminar los pagos que se encuentran en estado borrador.");
				return redirect(request().getHeader("referer"));
			}

			if (pago == null) {
				flash("error", "El pago solicitada ya no existe.");
				throw new NoRecordModelException();
			}

			pago.delete();
			flash("success", "Se ha eliminado el pago");
			return redirect(UriTrack.decode());
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el pago");
		} catch (NoRecordModelException e) {
		}

		return redirect(request().getHeader("referer"));
	}

	public static Result suggestPago(String input) {

		ObjectNode rpta = Json.newObject();
		ArrayNode pago = rpta.arrayNode();

		Pago ad = new Pago();

		for (Pago a : ad.getDataSuggest(input, 25)) {
			ObjectNode restJs = Json.newObject();
			restJs.put("id", a.id);
			restJs.put("value", a.nombre);
			restJs.put("info", "");
			pago.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", pago);

		return ok(response);
	}

	private static Pago loadPago(Long id) throws NoRecordModelException {
		Pago pago = Pago.find.byId(id);
		if (pago == null) {
			flash("error", "El pago solicitado ya no existe.");
			throw new NoRecordModelException();
		}
		return pago;
	}

	public static Result cambiarEstado(Long idPago, Long idEstado) throws IOException {
		Estado estado = Estado.getEstado(idEstado, Estado.TIPO_PAGO);

		Pago pago = Pago.find.byId(idPago);

		if (pago == null) {
			flash("error", "No se encuentra el pago.");
			return redirect(request().getHeader("referer"));
		}

		if (pago.pagoLinea.isEmpty()) {
			flash("error", "No se puede modificar el estado si no contiene lineas.");
			return redirect(request().getHeader("referer"));
		}

		if (idEstado != null) {
			Boolean permiso = false;
			switch (idEstado.intValue()) {
				case Estado.PAGO_ESTADO_BORRADOR:
					if (!Permiso.check("pagosPasarBorrador")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarEnBorrador(pago.id);
					break;
				case Estado.PAGO_ESTADO_CONCILIADO:
					if (!Permiso.check("pagosPasarConciliado")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarConciliado(pago.id);
					break;
				case Estado.PAGO_ESTADO_PAGADO:
					if (!Permiso.check("pagosPasarContabilizado")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarPagado(pago.id, false);
					break;
				case Estado.PAGO_ESTADO_EN_CURSO:
					if (!Permiso.check("pagosPasarEnCurso")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarEnCurso(pago.id);
					break;
				case Estado.PAGO_ESTADO_CANCELADO:
					if (!Permiso.check("pagosPasarCancelado")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarCancelado(pago.id);
					break;
				default:
					System.out.println("error");
					break;
			}

		}

		return redirect(controllers.contabilidad.routes.PagosController.ver(pago.id) + UriTrack.get("&"));
	}

	public static Result cambiarEstadoTransferenciaConciliado(Long idPago) {
		pasarPagado(idPago, true);
		pasarConciliado(idPago);
		return redirect(controllers.contabilidad.routes.PagosController.ver(idPago) + UriTrack.get("&"));
	}

	public static void pasarEnBorrador(Long idPago) {

		try {
			Ebean.beginTransaction();
			// Pago pago = Ebean.find(Pago.class).select("id,
			// estado_id,write_date,write_usuario_id").setId(idPago).findUnique();
			Pago pago = Pago.find.byId(idPago);
			if (Pago.controlHayReferenciaRepetida(pago.referencia, pago.id.intValue())) {
				flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
				return;
			}

			if (pago.estado_id.compareTo(new Long(Estado.PAGO_ESTADO_CANCELADO)) == 0) {
				List<Factura> f = Factura.find.where().eq("id", pago.factura_id)
						.eq("state_id", Estado.FACTURA_ESTADO_CANCELADO).findList();
				if (f.size() > 0) {
					flash("error", "Existe facturas en estado cancelado asociadas al pago.");
					return;
				}
			}

			if (pago != null) {
				pago.estado_id = new Long(Estado.PAGO_ESTADO_BORRADOR);
				pago.write_usuario_id = (long) Usuario.getUsuarioSesion();
				pago.write_date = new Date();
				pago.fecha_pago = null;
				pago.fecha_conciliacion = null;
				pago.fecha_curso = null;
				pago.fecha_emision = null;
				pago.fecha_conciliado_control = null;
				pago.fecha_entregado = null;
				pago.fecha_cancelacion = null;
				pago.save();
				BalanceCuentaPropia.deleteDesdeIdPago(pago.id);
				Ebean.commitTransaction();
				flash("success", "Operación exitosa. Estado actual: Borrador");
			} else {
				flash("error", "Parámetros incorrectos");
			}
		} catch (Exception e) {
			Ebean.rollbackTransaction();
			flash("error", "Parámetros incorrectos" + e);
		} finally {
			Ebean.endTransaction();
		}

	}

	private static Boolean existenPagosIgualPeriodo(Integer proveedorId, Integer expedienteId, Long periodoId) {
		List<Pago> pago = Pago.find.fetch("pagoLinea").where().eq("proveedor_id", proveedorId)
				.eq("expediente_id", expedienteId).eq("periodo_id", periodoId).eq("tipo", Pago.TIPO_PROVEEDOR)
				.findList();
		return pago.size() > 0;
	}

	public static void pasarConciliado(Long idPago) {

		try {
			Ebean.beginTransaction();
			Pago pago = Pago.find.byId(idPago);

			if (pago.fecha_conciliacion == null) {
				flash("error", "Debe ingresar una fecha de conciliado.");
				return;
			}

			if (pago.referencia == null || pago.referencia.isEmpty()) {
				flash("error", "Debe ingresar una referencia.");
				return;
			}

			if (Pago.controlHayReferenciaRepetida(pago.referencia, pago.id.intValue())) {
				flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
				return;
			}

			if (pago.tipo_pago.compareTo("cheque") == 0 && pago.numero_cheque.isEmpty()) {
				flash("error", "Debe ingresar un numero de cheque.");
				return;
			}

			/*
			 * if(pago.fecha_pago != null){
			 * 
			 * Ejercicio ejActual = Ejercicio.getEjercicioByFecha(new Date());
			 * Ejercicio ejOp = Ejercicio.getEjercicioByFecha(pago.fecha_pago);
			 * 
			 * if(ejOp.id.compareTo(ejActual.id) < 0 &&
			 * !Usuario.getUsurioSesion().id.equals(401)) {
			 * flash("error", "La fecha de OP no debe ser menor al ejercicio actual");
			 * return;
			 * }
			 * }
			 */

			if (pago != null) {
				if (pago.mis_pagos_id != null) {

					pago.estado_id = new Long(Estado.PAGO_ESTADO_CONCILIADO);
					pago.write_usuario_id = (long) Usuario.getUsuarioSesion();
					pago.write_date = new Date();
					pago.save();
					BalanceCuentaPropia.agregarLineaDesdePago(pago);
					Ebean.commitTransaction();
				} else {

					MiPago mipago = new MiPago();
					mipago.fecha = new Date();
					mipago.tipo = Proveedor.getTipoProveedor(pago.proveedor);
					mipago.save();

					pago.mis_pagos_id = mipago.id;
					pago.estado_id = new Long(Estado.PAGO_ESTADO_CONCILIADO);
					pago.write_usuario_id = (long) Usuario.getUsuarioSesion();
					pago.write_date = new Date();
					pago.save();

					if (pago.tipo.compareTo("payment") == 0) {
						Factura f = Factura.find.byId((long) pago.factura_id);
						f.fecha_pago = pago.fecha_pago;
						f.save();
					}

					BalanceCuentaPropia.agregarLineaDesdePago(pago);
					Ebean.commitTransaction();
				}
				flash("success", "Operación exitosa. Estado actual: Conciliado");
			} else {
				flash("error", "Parámetros incorrectos");
			}
		} catch (Exception e) {
			Ebean.rollbackTransaction();
			flash("error", "Parámetros incorrectos" + e);
		} finally {
			Ebean.endTransaction();
		}
	}

	public static void pasarPagado(Long idPago, boolean transferencia) {

		try {
			Ebean.beginTransaction();
			// Pago pago =
			// Ebean.find(Pago.class).select("id,referencia,fecha_conciliacion,estado_id,mis_pagos_id,expediente_id,periodo_id,proveedor_id,proveedor,tipo_pago,numero_cheque,write_date,write_usuario_id,fecha_conciliado_control,fecha_entregado").setId(idPago).findUnique();
			Pago pago = Pago.find.byId(idPago);
			if (pago.referencia == null || pago.referencia.isEmpty()) {
				flash("error", "Debe ingresar una referencia.");
				return;
			}

			if (Pago.controlHayReferenciaRepetida(pago.referencia, pago.id.intValue())) {
				flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
				return;
			}

			if (pago.tipo_pago.compareTo("cheque") == 0 && pago.numero_cheque.isEmpty()) {
				flash("error", "Debe ingresar un numero de cheque.");
				return;
			}

			if (transferencia) {
				if (pago.fecha_conciliacion == null) {
					flash("error", "Debe ingresar una fecha de conciliado.");
					return;
				}
			}

			/*
			 * if(pago.fecha_pago != null) {
			 * 
			 * Ejercicio ejActual = Ejercicio.getEjercicioByFecha(new Date());
			 * Ejercicio ejOp = Ejercicio.getEjercicioByFecha(pago.fecha_pago);
			 * 
			 * if(ejOp.id.compareTo(ejActual.id) < 0 &&
			 * !Usuario.getUsurioSesion().id.equals(401)) {
			 * flash("error", "La fecha de OP no debe ser menor al ejercicio actual");
			 * return;
			 * }
			 * }
			 */

			if (pago != null) {

				List<Pago> pagos = Pago.find.where().isNotNull("proveedor.agente_id")
						.eq("proveedor_id", pago.proveedor_id)
						.eq("periodo_id", pago.periodo_id)
						.eq("expediente_id", pago.expediente_id)
						.ne("estado_id", Estado.PAGO_ESTADO_CANCELADO)
						.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
						.ne("id", pago.id)
						.findList();
				if (pagos.size() > 0 && Usuario.getUsuarioSesion().compareTo(1) != 0) {
					flash("error", "No se puede aprobar un pago con el mismo expediente, periodo y agente.");
					return;
				}
				MiPago mipago = new MiPago();
				mipago.fecha = new Date();
				mipago.tipo = Proveedor.getTipoProveedor(pago.proveedor);
				mipago.save();

				pago.mis_pagos_id = mipago.id;
				pago.estado_id = new Long(Estado.PAGO_ESTADO_PAGADO);
				pago.write_usuario_id = (long) Usuario.getUsuarioSesion();
				pago.write_date = new Date();
				pago.update();

				if (pago.tipo.compareTo("payment") == 0) {
					Factura f = Factura.find.byId((long) pago.factura_id);
					f.fecha_pago = pago.fecha_pago;
					f.save();
				}

				BalanceCuentaPropia.agregarLineaDesdePago(pago);
				Ebean.commitTransaction();

				flash("success", "Operación exitosa. Estado actual: Pagado");
			} else {
				flash("error", "Parámetros incorrectos");
			}

		} catch (Exception e) {
			Ebean.rollbackTransaction();
			flash("error", "Parámetros incorrectos" + e);
		} finally {
			Ebean.endTransaction();
		}

	}

	public static void pasarEnCurso(Long idPago) {

		try {
			Ebean.beginTransaction();
			// Pago pago = Ebean.find(Pago.class).select("id,
			// estado_id,write_date,write_usuario_id,referencia,tipo_pago,numero_cheque").setId(idPago).findUnique();
			Pago pago = Pago.find.byId(idPago);

			if (pago.referencia == null || pago.referencia.isEmpty()) {
				flash("error", "Debe ingresar una referencia.");
				return;
			}

			if (Pago.controlHayReferenciaRepetida(pago.referencia, pago.id.intValue())) {
				flash("error", "Existe esta referencia en otro pago. Debe realizar la accion masivamente.");
				return;
			}

			if (pago.tipo_pago.compareTo("cheque") == 0
					&& (pago.numero_cheque == null || pago.numero_cheque.isEmpty())) {
				flash("error", "Debe ingresar un numero de cheque.");
				return;
			}

			if (pago != null) {

				/*
				 * Date femision = null;
				 * if(pago.fecha_emision != null && pago.tipo_pago.compareToIgnoreCase("cheque")
				 * == 0){
				 * femision = pago.fecha_emision;
				 * }else if(pago.fecha_emision == null &&
				 * pago.tipo_pago.compareToIgnoreCase("cheque") == 0){
				 * femision = new Date();
				 * }
				 */

				// pago.fecha_emision = femision;
				pago.fecha_curso = new Date();
				pago.estado_id = new Long(Estado.PAGO_ESTADO_EN_CURSO);
				pago.write_usuario_id = (long) Usuario.getUsuarioSesion();
				pago.write_date = new Date();
				pago.save();

				BalanceCuentaPropia.agregarLineaDesdePago(pago);
				Ebean.commitTransaction();
				actualizarVistaMaterializada();
				flash("success", "Operación exitosa. Estado actual: En curso");
			} else {
				flash("error", "Parámetros incorrectos.");
			}
		} catch (Exception e) {
			Ebean.rollbackTransaction();
			flash("error", "Parámetros incorrectos ");
		} finally {
			Ebean.endTransaction();
		}
	}

	public static void pasarCancelado(Long idPago) {

		try {
			Ebean.beginTransaction();
			// Pago pago = Ebean.find(Pago.class).select("id,
			// estado_id,mis_pagos_id,write_date,write_usuario_id").where().eq("id",
			// idPago).findUnique();
			Pago pago = Pago.find.byId(idPago);
			if (Pago.controlHayReferenciaRepetida(pago.referencia, pago.id.intValue())) {
				flash("error",
						"Existe esta referencia en otro pago. Debe cancelar los pagos de la misma referencias en forma masiva");
				return;
			}

			if (pago.fecha_cancelacion == null) {
				flash("error", "Debe ingresar una fecha de cancelacion.");
				return;
			}

			List<Integer> idsPagos = new ArrayList<Integer>();
			idsPagos.add(idPago.intValue());
			if (Pago.getIdsPagosEnCircutoOrdenEnCurso(idsPagos).size() > 0) {
				flash("error", "Solo se puede cancelar pagos que no estan en un circuito de orden de pago en cursos.");
			} else {

				if (pago != null) {
					pago.mis_pagos_id = null;
					pago.estado_id = new Long(Estado.PAGO_ESTADO_CANCELADO);
					pago.write_usuario_id = (long) Usuario.getUsuarioSesion();
					pago.write_date = new Date();
					pago.save();
					BalanceCuentaPropia.cancelarDesdePago(pago);
					Ebean.commitTransaction();
					actualizarVistaMaterializada();
					flash("success", "Operación exitosa. Estado actual: Cancelado");
				} else {
					flash("error", "Parámetros incorrectos");
				}
			}
		} catch (Exception e) {
			flash("error", "Parámetros incorrectos " + e);
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();
		}
	}

	public static void actualizarVistaMaterializada() {

		// Ebean.createSqlUpdate("REFRESH MATERIALIZED VIEW
		// informe_estadistico_deuda_proveedores_matrializada").execute();
		Connection conn = play.db.DB.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.execute("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada;");
			stmt.execute("REFRESH MATERIALIZED VIEW informe_deuda_actas_materializada;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
