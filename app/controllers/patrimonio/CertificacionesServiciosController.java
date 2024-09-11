package controllers.patrimonio;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import play.libs.Json;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.document.json.JSONObject;
import models.ActaRecepcion;
import models.BalancePresupuestario;
import models.Certificacion;
import models.CertificacionServicio;
import models.CertificacionServicioLinea;
import models.CertificacionServicioLineaCliente;
import models.Cliente;
import models.Estado;
import models.Orden;
import models.OrdenLinea;
import models.OrdenProvision;
import models.OrdenProvisionLineas;
import models.Usuario;
import models.auth.Permiso;
import models.informes.InformeDeudaPorActaMaterializada;
import models.informes.InformeDeudaProveedoresMaterializada;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.compras.lineasOrdenes.verLineaProducto;
import views.html.compras.ordenes.crearOrden;
import views.html.expediente.expediente.crearExpediente;
import views.html.patrimonio.actaRecepcion.editarActaRecepcion;
import views.html.patrimonio.certificaciones.*;

@Security.Authenticated(Secured.class)
public class CertificacionesServiciosController extends Controller {
	final static Form<CertificacionServicio> cForm = form(CertificacionServicio.class);

	@CheckPermiso(key = "certificacionesServiciosVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		Pagination<CertificacionServicio> actas = CertificacionServicio.page(
				RequestVar.get("id"),
				RequestVar.get("expediente_id"),
				RequestVar.get("acta"),
				RequestVar.get("orden_provision_id"),
				RequestVar.get("orden_provision"),
				RequestVar.get("producto_id"),
				RequestVar.get("proveedor_id"),
				RequestVar.get("periodo_id"),
				RequestVar.get("orden_rubro_id"),
				RequestVar.get("deposito_id"),
				RequestVar.get("conacta"),
				RequestVar.get("btnFiltro[0]"),
				RequestVar.get("btnFiltro[1]"),
				RequestVar.get("btnFiltro[2]"),
				RequestVar.get("btnFiltro[3]"),
				RequestVar.get("tipo_cuenta_id"));

		return ok(indexCertificacion.render(actas, d, pf));
	}

	public static Result indexAjax() {
		Pagination<CertificacionServicio> actas = CertificacionServicio.page(
				RequestVar.get("id"),
				RequestVar.get("expediente_id"),
				RequestVar.get("acta"),
				RequestVar.get("orden_provision_id"),
				RequestVar.get("orden_provision"),
				RequestVar.get("producto_id"),
				RequestVar.get("proveedor_id"),
				RequestVar.get("periodo_id"),
				RequestVar.get("orden_rubro_id"),
				RequestVar.get("deposito_id"),
				RequestVar.get("conacta"),
				RequestVar.get("btnFiltro[0]"),
				RequestVar.get("btnFiltro[1]"),
				RequestVar.get("btnFiltro[2]"),
				RequestVar.get("btnFiltro[3]"),
				RequestVar.get("tipo_cuenta_id"));
		DynamicForm d = form().bindFromRequest();
		return ok(indexCertificacionAjax.render(actas, d));
	}

	public static Result agregarLineasConCliente() {

		ObjectNode result = Json.newObject();
		JsonNode json = Controller.request().body().asJson();
		boolean error = false;
		String strError = "";
		Ebean.beginTransaction();

		try {

			if (json.get("idOrdenProvision") != null) {

				Logger.info("cantidadTotalOrden -> " + json.get("cantidadTotalOrden").asDouble());
				Logger.info("withArray(\"datos\").size() -> " + json.withArray("datos").size());

				if (json.get("cantidadTotalOrden").asDouble() > 0 && json.withArray("datos").size() > 0) {
					Logger.info("idOrdenProvision -> " + json.get("idOrdenProvision").asLong());
					Long idOrdenProvision = json.get("idOrdenProvision").asLong();

					CertificacionServicio cs = new CertificacionServicio();
					cs.orden_provision_id = idOrdenProvision;
					cs.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					cs.estado_id = (long) Estado.CERTIFICACION_SERVICIO_BORRADOR;
					cs.create_date = new Date();
					cs.save();

					for (JsonNode data : json.withArray("datos")) {

						Logger.info("linea_orden_id -> " + data.get("linea_orden_id").asLong());
						Logger.info("cantidadTotal -> " + data.get("cantidadTotal").asLong());
						OrdenLinea cp = OrdenLinea.find.where().eq("id", data.get("linea_orden_id").asLong())
								.findUnique();

						CertificacionServicioLinea csl = new CertificacionServicioLinea();
						csl.cantidad = new BigDecimal(data.get("cantidadTotal").asDouble());// ESTA CANTIDAD ES LA Q
																							// VIENE EN EL JSON
						csl.certificaciones_servicio_id = cs.id;
						csl.linea_orden_id = cp.id;
						csl.create_date = new Date();
						csl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						csl.cuenta_analitica_id = cp.cuenta_analitica_id;
						csl.precio = cp.precio;
						csl.producto_id = cp.producto_id;
						csl.udm_id = cp.udm_id;
						csl.save();

						for (JsonNode dataPacientes : data.withArray("datosLinea")) {
							if (dataPacientes.get("clienteId") != null) {
								Cliente c = Cliente.find.byId(dataPacientes.get("clienteId").asLong());

								if (dataPacientes.get("cantidadCargar") != null
										&& dataPacientes.get("cantidad") != null) {
									BigDecimal cantidad = new BigDecimal(dataPacientes.get("cantidad").asLong());
									BigDecimal cantidadCargar = new BigDecimal(
											dataPacientes.get("cantidadCargar").asLong());

									//////////////// CAAAAAAA TENGO Q PONER UN CONTROL DE CANTIDADES A CARGAR POR SI
									//////////////// DEJAN COLGADA LA PANTALLA Y VIENE
									/// OTRO Y CARGA.

									/*
									 * Logger.info("clienteId -> " + dataPacientes.get("clienteId").asLong());
									 * Logger.info("cantidad -> " + dataPacientes.get("cantidad").asLong());
									 * Logger.info("cantidadCargar -> " +
									 * dataPacientes.get("cantidadCargar").asLong());
									 *
									 * Logger.info("getCantidadDisponibleConCertificacionPorLineaPorCliente -> " +
									 * OrdenLinea.getCantidadDisponibleConCertificacionPorLineaPorCliente(cp.id,c.id
									 * ));
									 * Logger.info("cantidadCargar -> " +
									 * dataPacientes.get("cantidadCargar").asLong());
									 * Logger.info("compareTo -> ");
									 */

									if (OrdenLinea.getCantidadDisponibleConCertificacionPorLineaPorCliente(cp.id, c.id)
											.compareTo(cantidadCargar) < 0) {
										Logger.debug("---------" + OrdenLinea
												.getCantidadDisponibleConCertificacionPorLineaPorCliente(cp.id, c.id)
												.compareTo(cantidadCargar));
										error = true;
										strError += "La cantidad a cargar supera a la cantidad disponible para el paciente:"
												+ c.nombre + " - ";
									}

									if (cantidadCargar.compareTo(cantidad) > 0) {
										error = true;
										strError = "La cantidad a cargar supera a la cantidad disponible para el paciente:"
												+ c.nombre + "-";
									} else {

										if (cantidadCargar.compareTo(BigDecimal.ZERO) > 0) {
											CertificacionServicioLineaCliente cslc = new CertificacionServicioLineaCliente();
											cslc.cantidad = new BigDecimal(
													dataPacientes.get("cantidadCargar").asDouble());
											cslc.certificaciones_servicios_linea_id = csl.id;
											cslc.cliente_id = dataPacientes.get("clienteId").asLong();
											cslc.save();
										}
									}

								} else {

									error = true;
									strError = "Debe seleccionar una cantidad a cargar para el paciente:" + c.nombre;
								}
							}
						}
					}
					if (error) {
						Ebean.rollbackTransaction();
						result.put("success", false);
						result.put("error", strError);

					} else {
						result.put("success", true);
						result.put("idCertificacionServicio", cs.id.toString());
						Ebean.commitTransaction();
					}
				} else {
					result.put("success", false);
					result.put("error", "No hay cantidad disponible para cargar.");
					return ok(result);
				}
			} else {
				result.put("success", false);
				result.put("error", "No se encuentra el id de Orden de Provision.");
				return ok(result);
			}

		} catch (Exception e) {
			Ebean.rollbackTransaction();
			result.put("success", false);
			result.put("error", "No se Puede crear la certificacion. " + e);
			Logger.info("error" + e);
			return ok(result);
		} finally {
			Ebean.endTransaction();
		}

		return ok(result);
	}

	@CheckPermiso(key = "certificacionesServiciosCrear")
	public static Result crearDesdeOrdenAjax(Long id) {
		List<Integer> serviciosSeleccionados = getSeleccionados();
		ObjectNode result = Json.newObject();

		if (serviciosSeleccionados.size() == 0) {
			result.put("success", false);
			return ok(result);
		}

		Map<Integer, BigDecimal> lineaTotalDisponble = new HashMap<Integer, BigDecimal>();
		Map<Integer, List<SqlRow>> lineas = new HashMap<Integer, List<SqlRow>>();
		Map<Integer, String> lineaProducto = new HashMap<Integer, String>();
		boolean tienePacientes = false;

		Map<Long, BigDecimal> lineaProductoPrecioConAjustes = new HashMap<Long, BigDecimal>();




		for (Integer i : serviciosSeleccionados) {

			OrdenLinea c = OrdenLinea.find.where().eq("id", i).findUnique();

			List<SqlRow> sl = OrdenLinea.getCantidadDisponibleConCertificacionPorClientesPorOrdenLinea(i, false);
			if (sl.size() > 0) {
				tienePacientes = true;

				lineas.put(i, sl);
				lineaProducto.put(i, c.producto.nombre);

				BigDecimal opl = OrdenProvisionLineas.getCantidadDisponibleCertificaciones(i.longValue());

				Logger.debug("hhhhhhhhhhhhhhhhhh " + opl);
				SqlRow slx = OrdenLinea.getCantidadDisponibleConCertificacionPorLineaConClientes(i);
				Logger.debug("hhhhhhhhhhhhhhhhhh " + slx.getBigDecimal("cantidad_disponible"));
				Logger.debug("hhhhhhhhhhhhhhhhhh " + opl.subtract(slx.getBigDecimal("cantidad_disponible")));

				if (opl.subtract(slx.getBigDecimal("cantidad_disponible")).compareTo(BigDecimal.ZERO) > 0) {
					if (!lineaTotalDisponble.containsKey(i)) {
						lineaTotalDisponble.put(i, opl.subtract(slx.getBigDecimal("cantidad_disponible")));
					}
				}
			}
		}

		if (tienePacientes) {
			result.put("success", false);
			Object c = modalAgregarConClientes.render(lineas, lineaTotalDisponble, lineaProducto);
			result.put("cargarPacientes", true);
			result.put("html", c.toString());
			return ok(result);
		} else {
			// OrdenLinea c = OrdenLinea.find.where().eq("id",
			// serviciosSeleccionados.get(0)).findUnique();
			Long idOrdenProvision = id;

			OrdenProvision op = OrdenProvision.find.byId(idOrdenProvision);

			CertificacionServicio cs = new CertificacionServicio();
			Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx " );

			List<SqlRow> precioPorProductoConAjustes = OrdenLinea.getPrecioPorProductoConAjustes(op.orden_compra_id);

			for (SqlRow ppa : precioPorProductoConAjustes) {
				lineaProductoPrecioConAjustes.put(ppa.getLong("producto_id"), ppa.getBigDecimal("sumatoria"));
			}

			Ebean.beginTransaction();

			try {

				cs.orden_provision_id = idOrdenProvision;
				cs.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				cs.estado_id = (long) Estado.CERTIFICACION_SERVICIO_BORRADOR;
				cs.create_date = new Date();
				cs.save();

				for (Integer i : serviciosSeleccionados) {
					OrdenLinea cp = OrdenLinea.find.where().eq("id", i).findUnique();
					CertificacionServicioLinea csl = new CertificacionServicioLinea();

					csl.cantidad = cp.cantidad;
					csl.certificaciones_servicio_id = cs.id;
					csl.linea_orden_id = cp.id;
					csl.create_date = new Date();
					csl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					csl.cuenta_analitica_id = cp.cuenta_analitica_id;
					//csl.precio = cp.precio;

					csl.precio = lineaProductoPrecioConAjustes.get(cp.producto_id);

					csl.producto_id = cp.producto_id;
					csl.udm_id = cp.udm_id;
					csl.save();

					result.put("success", true);
					result.put("idCertificacionServicio", cs.id);
				}
				Ebean.commitTransaction();

			} catch (Exception e) {
				Ebean.rollbackTransaction();
				result.put("success", false);
				return ok(result);
			}

			return ok(result);
		}
	}

	public static Result cambiarEstado(Long idCertificacion, Long idEstado) {
		Estado estado = Estado.getEstado(idEstado, Estado.TIPO_CERTIFICACION_SERVICIO);

		CertificacionServicio cert = CertificacionServicio.find.byId(idCertificacion);

		if (cert == null) {
			flash("error", "No se encuentra la certificación.");
			return redirect(request().getHeader("referer"));
		}

		if (cert.acta_id != null && cert.estado_id == Estado.CERTIFICACION_SERVICIO_CERTIFICADA
				&& idEstado == Estado.CERTIFICACION_SERVICIO_CANCELADA) {
			if (cert.acta.estado_id.compareTo((long) Estado.ACTA_ESTADO_APROBADA) == 0) {
				flash("error", "No se puede cancelar una certificación con acta APROBADA asignada.");
				return redirect(controllers.patrimonio.routes.CertificacionesServiciosController.ver(cert.id)
						+ UriTrack.get("&"));
			}
		}

		if (cert.acta_id != null && idEstado == Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA) {
			flash("error", "No se puede No certificar una certificación con acta asignada.");
			return redirect(
					controllers.patrimonio.routes.CertificacionesServiciosController.ver(cert.id) + UriTrack.get("&"));
		}

		if (cert.estado_id == Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA
				&& idEstado == Estado.CERTIFICACION_SERVICIO_CANCELADA) {
			flash("error", "No se puede cancelar una certificacion No certificada.");
			return redirect(
					controllers.patrimonio.routes.CertificacionesServiciosController.ver(cert.id) + UriTrack.get("&"));
		}

		if (!cert.controlPermisoDeposito()) {
			flash("error", "La institucion no corresponde a su institucion asignada.");
			return redirect(
					controllers.patrimonio.routes.CertificacionesServiciosController.index() + UriTrack.get("?"));
		}

		switch (idEstado.intValue()) {
			case Estado.CERTIFICACION_SERVICIO_BORRADOR:
				if (!Permiso.check("certificacionServicioPasarBorrador")) {
					return ok(sinPermiso.render(request().getHeader("referer")));
				}
				pasarEnBorrador(cert.id);
				break;
			case Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA:
				if (!Permiso.check("certificacionServicioPasarNoCertificada")) {
					return ok(sinPermiso.render(request().getHeader("referer")));
				}
				pasarNoCertificada(cert.id);
				break;
			case Estado.CERTIFICACION_SERVICIO_CANCELADA:
				if (!Permiso.check("certificacionServicioPasarCancelado")) {
					return ok(sinPermiso.render(request().getHeader("referer")));
				}
				pasarEnCancelada(cert.id);
				break;
			case Estado.CERTIFICACION_SERVICIO_CERTIFICADA:
				if (!Permiso.check("certificacionServicioPasarAprobado")) {
					return ok(sinPermiso.render(request().getHeader("referer")));
				}
				pasarEnCertificada(cert.id);
				break;
			default:
				break;
		}

		return redirect(
				controllers.patrimonio.routes.CertificacionesServiciosController.ver(cert.id) + UriTrack.get("&"));
	}

	public static void pasarEnBorrador(Long idCertificacion) {
		CertificacionServicio cert = CertificacionServicio.find.byId(idCertificacion);

		try {
			cert.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			cert.write_date = new Date();
			cert.estado_id = new Long(Estado.CERTIFICACION_SERVICIO_BORRADOR);
			cert.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} catch (Exception e) {
			flash("error", "No se pudo cambiar el estado.");
		}
	}

	public static void pasarNoCertificada(Long idCertificacion) {
		CertificacionServicio cert = CertificacionServicio.find.byId(idCertificacion);
		String erroresCantidad = "";
		boolean errorControl = false;
		/*List<CertificacionServicioLinea> csl = CertificacionServicioLinea.find.where()
				.eq("certificaciones_servicio_id", cert.id).findList();
		if (csl.size() > 0) {

			for (CertificacionServicioLinea cslx : csl) {

				OrdenLinea ol = OrdenLinea.find.byId(cslx.linea_orden_id);

				List<CertificacionServicioLinea> cslol = CertificacionServicioLinea.find.where()
						.eq("linea_orden_id", ol.id)
						.ne("certificaciones_servicio_id", idCertificacion)
						.findList();
				BigDecimal cantidadTotalLineas = BigDecimal.ZERO;
				for (CertificacionServicioLinea cslolx : cslol) {// BUSCO TODAS LAS LINEAS QUE TIENEN LA ORDEN_LINEA
																	// PARA SUMAR Y COMPARAR CONTRA EL TOTAL
					cantidadTotalLineas = cantidadTotalLineas.add(cslolx.cantidad);
				}

			}
		}*/

		if (errorControl) {
			flash("error", erroresCantidad);
		} else {
			Connection conn = null;
		    PreparedStatement stmt = null;
		    PreparedStatement stmt2 = null;
		    ResultSet rs = null;
		    int x = 0;
			try {

				conn = play.db.DB.getConnection();

			    stmt = conn.prepareStatement("alter table certificaciones_servicios disable trigger actualiza_total_orden");
			    x = stmt.executeUpdate();
			    stmt.close();
			    stmt = conn.prepareStatement("alter table certificaciones_servicios_lineas disable trigger actualiza_total_orden");
			    x = stmt.executeUpdate();
			    stmt.close();

			    stmt = conn.prepareStatement("alter table orden_lineas_ajustes disable trigger actualiza_total_orden");
			    x = stmt.executeUpdate();
			    stmt.close();

			    stmt = conn.prepareStatement("alter table orden_lineas_ajustes disable trigger after_insert_update_delete");
			    x = stmt.executeUpdate();
			    stmt.close();

			    stmt = conn.prepareStatement("alter table ordenes disable trigger actualiza_total_orden");
			    x = stmt.executeUpdate();
			    stmt.close();





				cert.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				cert.write_date = new Date();
				cert.estado_id = new Long(Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA);
				cert.save();

				stmt = conn.prepareStatement("alter table certificaciones_servicios enable trigger actualiza_total_orden");
				stmt.execute();
			    stmt.close();

			    stmt = conn.prepareStatement("alter table certificaciones_servicios_lineas enable trigger actualiza_total_orden");
			    stmt.execute();
			    stmt.close();

			    stmt = conn.prepareStatement("alter table orden_lineas_ajustes enable trigger actualiza_total_orden");
			    stmt.execute();
			    stmt.close();

			    stmt = conn.prepareStatement("alter table orden_lineas_ajustes enable trigger after_insert_update_delete");
			    stmt.execute();
			    stmt.close();


			    stmt = conn.prepareStatement("alter table ordenes enable trigger actualiza_total_orden");
			    stmt.execute();
			    stmt.close();

			    stmt = conn.prepareStatement("select actualiza_totales_ordenes_ordenes(null)");
			    stmt.execute();
			    stmt.close();

			    stmt = conn.prepareStatement("select actualiza_totales_ordenes_recepcionados(null)");
			    stmt.execute();
			    stmt.close();

			    InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
			    InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();

				flash("success", "Operación exitosa. Estado actual: No Certificada");

			} catch (Exception e) {
				OrdenProvision.enableTriggers();
				flash("error", "No se pudo cambiar el estado. "+e);
			}finally {
			      if (stmt != null)
			          try {
			            stmt.close();
			          } catch (Exception e) {
			          }
			      if (stmt2 != null)
			          try {
			            stmt2.close();
			          } catch (Exception e) {
			          }
			        if (rs != null)
			          try {
			            rs.close();
			          } catch (Exception e) {
			          }
			        if (conn != null)
			          try {
			            conn.close();
			          } catch (Exception e) {
			          }
			      }
		}
	}

	public static void pasarEnCancelada(Long idCertificacion) {
		CertificacionServicio cert = CertificacionServicio.find.byId(idCertificacion);

		try {
			String r = "";
			if (cert.acta_id != null) {
				r = "Se revocó el acta que tenia asignada.<br>";
			}
			cert.acta_id = null;
			cert.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			cert.write_date = new Date();
			cert.estado_id = new Long(Estado.CERTIFICACION_SERVICIO_CANCELADA);
			cert.save();
			flash("success", r + "Operación exitosa. Estado actual: Borrador");
		} catch (Exception e) {
			flash("error", "No se pudo cambiar el estado.");
		}
	}

	public static void pasarEnCertificada(Long idCertificacion) {
		CertificacionServicio cert = CertificacionServicio.find.byId(idCertificacion);
		String erroresCantidad = "";
		if (cert.periodo_id == null) {
			flash("error", "Debe indicar el periodo.");
		} else {

			List<Integer> ids = new ArrayList<Integer>();
			ids.add(idCertificacion.intValue());

			boolean errorControl = false;
			String avisoPresupuesto = "";
			ArrayNode a = BalancePresupuestario.controlSaldoDefinitivoCertificacionServicio(ids);
			for (JsonNode o : a) {
				boolean success = new Boolean(o.get("success").toString());
				String cuenta = o.get("cuenta").toString();
				String expediente = o.get("expediente").toString();
				BigDecimal saldoDisponible = new BigDecimal(o.get("saldoDisponible").toString());
				BigDecimal saldoAImputar = new BigDecimal(o.get("saldoAImputar").toString());
				BigDecimal saldoPresente = new BigDecimal(o.get("saldoPresente").toString());

				if (!success) {
					errorControl = true;
					avisoPresupuesto += "No tiene Saldo disponible para la cuenta " + cuenta + " para el expediente "
							+ expediente + "<br>";
					avisoPresupuesto += "Saldo Disponible: " + utils.NumberUtils.moneda(saldoDisponible) + "<br>";
					avisoPresupuesto += "Saldo a Imputar: " + utils.NumberUtils.moneda(saldoAImputar) + "<br>";
					avisoPresupuesto += "Saldo Total: " + utils.NumberUtils.moneda(saldoPresente) + "<br><br>";
				} else {
					avisoPresupuesto += "Tiene Saldo disponible para la cuenta " + cuenta + " para el expediente "
							+ expediente + "<br>";
					avisoPresupuesto += "Saldo Disponible: " + utils.NumberUtils.moneda(saldoDisponible) + "<br>";
					avisoPresupuesto += "Saldo a Imputar: " + utils.NumberUtils.moneda(saldoAImputar) + "<br>";
					avisoPresupuesto += "Saldo Total: " + utils.NumberUtils.moneda(saldoPresente) + "<br><br>";
				}
			}

			if (errorControl) {
				flash("error", avisoPresupuesto);

			} else {

				List<CertificacionServicioLinea> csl = CertificacionServicioLinea.find.where()
						.eq("certificaciones_servicio_id", cert.id).findList();
				if (csl.size() > 0) {

					for (CertificacionServicioLinea cslx : csl) {

						OrdenLinea ol = OrdenLinea.find.byId(cslx.linea_orden_id);

						List<CertificacionServicioLinea> cslol = CertificacionServicioLinea.find.where()
								.eq("linea_orden_id", ol.id).findList();
						BigDecimal cantidadTotalLineas = BigDecimal.ZERO;
						for (CertificacionServicioLinea cslolx : cslol) {// BUSCO TODAS LAS LINEAS QUE TIENEN LA
																			// ORDEN_LINEA PARA SUMAR Y COMPARAR CONTRA
																			// EL TOTAL
							cantidadTotalLineas = cantidadTotalLineas.add(cslolx.cantidad);
						}

						if (cantidadTotalLineas.compareTo(ol.cantidad) > 0) {
							errorControl = false;
							erroresCantidad += "La cantidad cargada en las certificaciones de la linea  "
									+ ol.producto.nombre + " supera a la cantida de la linea original<br>";
						}
					}
				}

				if (errorControl) {

					flash("error", erroresCantidad);
				} else {
					try {
						cert.write_usuario_id = new Long(Usuario.getUsuarioSesion());
						cert.write_date = new Date();
						cert.estado_id = new Long(Estado.CERTIFICACION_SERVICIO_CERTIFICADA);
						if (cert.fecha_certificacion == null) {
							cert.fecha_certificacion = new Date();
						}
						cert.save();
						flash("success", "Operación exitosa. Estado actual: Certificada");
					} catch (Exception e) {
						flash("error", "No se pudo cambiar el estado.");
					}
				}
			}
		}
	}

	@CheckPermiso(key = "certificacionesServiciosCrear")
	public static Result guardar() {

		// OrdenLinea c = OrdenLinea.find.where().eq("id", linea_orden_id).findUnique();

		Form<CertificacionServicio> cf = form(CertificacionServicio.class).bindFromRequest();
		CertificacionServicio cs = cf.get();
		if (cf.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearCertificacionServicio.render(cf, cs));
		}

		try {

			if (!cs.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return redirect(
						controllers.patrimonio.routes.CertificacionesServiciosController.index() + UriTrack.get("?"));
			}

			cs.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			cs.estado_id = (long) Estado.CERTIFICACION_SERVICIO_BORRADOR;
			cs.create_date = new Date();
			cs.save();
			flash("success", "Se ha creado la certficación número <b>" + cs.id + "</b> .");
		} catch (Exception e) {
			flash("error", "No se ha podido almacenar la certificación." + e.getMessage());
			return badRequest(crearCertificacionServicio.render(cf, cs));
		}

		return redirect(controllers.patrimonio.routes.CertificacionesServiciosController.index() + UriTrack.get("?"));
	}

	@CheckPermiso(key = "certificacionesServiciosCrear")
	public static Result editar(Long id) {

		CertificacionServicio cs = CertificacionServicio.find.byId(id);

		if (cs.estado_id != Estado.CERTIFICACION_SERVICIO_BORRADOR) {
			flash("error", "Solo se pueden editar certificaciones en estado <b>BORRADOR</b>.");
			return redirect(request().getHeader("referer"));
		}

		if (!cs.controlPermisoDeposito()) {
			flash("error", "La institucion no corresponde a su institucion asignada.");
			return redirect(
					controllers.patrimonio.routes.CertificacionesServiciosController.index() + UriTrack.get("?"));
		}

		return ok(editarCertificacionServicio.render(cForm.fill(cs), cs));

	}

	@CheckPermiso(key = "certificacionesServiciosCrear")
	public static Result actualizar(Long id) {
		// OrdenLinea c = OrdenLinea.find.where().eq("id", linea_orden_id).findUnique();
		CertificacionServicio cv = CertificacionServicio.find.byId(id);
		Form<CertificacionServicio> cf = form(CertificacionServicio.class).bindFromRequest();

		if (cf.hasErrors()) {
			flash("error", "Error en formulario");
			Logger.debug("xxxxxxxxxxxxx " + cf.errors());
			return badRequest(editarCertificacionServicio.render(cf, cv));
		}

		try {
			CertificacionServicio cs = cf.get();

			if (!cs.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return redirect(
						controllers.patrimonio.routes.CertificacionesServiciosController.index() + UriTrack.get("?"));
			}

			cs.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			cs.write_date = new Date();
			cs.estado_id = cv.estado_id;
			cs.update();
			flash("success", "Se ha modificado la certficación número <b>" + cs.id + "</b> .");
		} catch (Exception e) {
			flash("error", "No se ha podido almacenar la orden. " + e);
			return badRequest(editarCertificacionServicio.render(cf, cv));
		}

		// return
		// redirect(controllers.patrimonio.routes.CertificacionesServiciosController.index());
		return redirect(controllers.patrimonio.routes.CertificacionesServiciosController.ver(id) + UriTrack.get("&"));
	}

	@CheckPermiso(key = "certificacionesServiciosVer")
	public static Result ver(Long id) {
		CertificacionServicio cs = CertificacionServicio.find.byId(id);

		if (cs != null) {
			if (!cs.controlPermisoDeposito()) {
				flash("error", "La certificacion de la orden no corresponde a su institucion asignada.");
				return redirect(
						controllers.patrimonio.routes.CertificacionesServiciosController.index() + UriTrack.get("?"));
			}
			Form<CertificacionServicio> certificacionForm = form(CertificacionServicio.class).fill(cs);
			PaginadorFicha pf = new PaginadorFicha(UriTrack.code());
			return ok(verCertificacionServicio.render(cs, certificacionForm, pf));
		} else {
			flash("error", "No se encuentra la certificacion.");
			return redirect(
					controllers.patrimonio.routes.CertificacionesServiciosController.index() + UriTrack.get("?"));
		}
	}

	@CheckPermiso(key = "certificacionesServiciosEliminar")
	public static Result eliminar(Long id) {

		CertificacionServicio cs = CertificacionServicio.find.byId(id);

		if (cs.estado_id != Estado.CERTIFICACION_SERVICIO_BORRADOR) {
			flash("error", "La certificación debe estar en estado borrador.");
			return redirect(request().getHeader("referer"));
		}

		if(cs.acta_id != null) {
			flash("error", "La certificación tiene un acta asociada. Debe eliminar la asociacion.");
			return redirect(request().getHeader("referer"));
		}

		try {
			cs.delete();
			flash("success", "Se ha elimindo la certificación <b>" + id + "</b>.");
			return redirect(UriTrack.decode());

		} catch (Exception e) {
			flash("error", "No se ha podido eliminar la certificación.");
			return redirect(request().getHeader("referer"));
		}

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
