package controllers.patrimonio;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import models.ActaRecepcion;
import models.ActaRecepcionLineaAjuste;
import models.CuentaAnalitica;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.FacturaLinea;
import models.OrdenLinea;
import models.OrdenLineaAjuste;
import models.OrdenLineaAnulacion;
import models.OrdenLineaAnulacionCliente;
import models.OrdenLineaCliente;
import models.OrdenProvision;
import models.OrdenProvisionLineas;
import models.Producto;
import models.Recepcion;
import models.Usuario;
import models.informes.InformeEstadisticoDeudaProveedores;
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
import views.html.patrimonio.actaRecepcion.modales.modalCrearActaRecepcion;
import views.html.patrimonio.ordenesProvision.*;
import views.html.patrimonio.ordenesProvision.reportes.modalReporteOrdenProvision;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class OrdenesProvisionController extends Controller {

	final static Form<OrdenProvision> oForm = form(OrdenProvision.class);
	final static Form<ActaRecepcion> actaForm = form(ActaRecepcion.class);

	@CheckPermiso(key = "ordenesProvisionVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());

		return ok(indexOrdenesProvision.render(OrdenProvision.page(RequestVar.get("numero"),
				RequestVar.get("orden_compra"),
				RequestVar.get("expediente_id"),
				RequestVar.get("proveedor_id"),
				RequestVar.get("con_acta"),
				RequestVar.get("ejercicio"),
				RequestVar.get("create_date_desde"),
				RequestVar.get("create_date_hasta"),
				RequestVar.get("fecha_op_desde"),
				RequestVar.get("fecha_op_hasta"),
				RequestVar.get("orden_rubro_id"),
				RequestVar.get("deposito_id"),
				RequestVar.get("tipo_moneda"),
				RequestVar.get("tipo_cuenta_id"),
				RequestVar.get("emergencia")), d, pf));
	}

	public static Result informacionPorPacientes() {
		DynamicForm d = form().bindFromRequest();

		return ok(informacionPorPacientes.render(OrdenLineaCliente.pageBuscador(RequestVar.get("paciente_id"),
				RequestVar.get("proveedor_id"),
				RequestVar.get("expediente_id"),
				RequestVar.get("ejercicio")), d));
	}

	@CheckPermiso(key = "verInfoPaciente")
	public static Result informacionPorPacientesExcel() {

		Pagination<OrdenLineaCliente> informe = OrdenLineaCliente.pageBuscador(
				RequestVar.get("paciente_id"),
				RequestVar.get("proveedor_id"),
				RequestVar.get("expediente_id"),
				RequestVar.get("ejercicio"));

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp + "/lineas.xls");

		try {

			if (archivo.exists())
				archivo.delete();
			archivo.createNewFile();

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("lineas");

			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);

			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);

			int x = 0;
			Row fila = hoja.createRow(x);
			fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Nombre");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue("Proveedor");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(2);
			celda0.setCellValue("Exp");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(3);
			celda0.setCellValue("OP");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(4);
			celda0.setCellValue("Producto");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(5);
			celda0.setCellValue("Cantidad");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(6);
			celda0.setCellValue("Recibidos");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(7);
			celda0.setCellValue("Anulados");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(8);
			celda0.setCellValue("Pendientes");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(9);
			celda0.setCellValue("Precio");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(10);
			celda0.setCellValue("Total");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(11);
			celda0.setCellValue("Monto Pediente");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(12);
			celda0.setCellValue("Monto Anulado");
			celda0.setCellStyle(comun);

			x++;

			for (OrdenLineaCliente olc : informe.getList()) {

				fila = hoja.createRow(x);

				celda0 = fila.createCell(0);
				celda0.setCellValue(olc.cliente.nombre);
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(olc.ordenLinea.orden.proveedor.nombre);
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue(olc.ordenLinea.orden.expediente.getExpedienteEjercicio());
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue((olc.ordenLinea.orden.numero_orden_provision != null)
						? olc.ordenLinea.orden.numero_orden_provision.toString()
						: "");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue(olc.ordenLinea.producto.nombre);
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue(olc.cantidad.doubleValue());
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue(olc.getTotalRecibido().doubleValue());
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue(olc.getTotalAnulado().doubleValue());
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(8);
				celda0.setCellValue(
						olc.cantidad.subtract(olc.getTotalRecibido()).subtract(olc.getTotalAnulado()).doubleValue());
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(9);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(olc.ordenLinea.precio.doubleValue());
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(10);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(olc.ordenLinea.precio.multiply(olc.cantidad).doubleValue());
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(11);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(olc.cantidad.subtract(olc.getTotalRecibido()).subtract(olc.getTotalAnulado())
						.multiply(olc.ordenLinea.precio).doubleValue());
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(12);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(olc.getTotalAnulado().multiply(olc.ordenLinea.precio).doubleValue());
				celda0.setCellStyle(comun);

				x++;
			}

			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			return ok(archivo);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ok();
	}

	@CheckPermiso(key = "ordenesProvisionEditar")
	public static Result editar(Long id) {
		OrdenProvision op = OrdenProvision.find.byId(id);

		if (op == null) {
			flash("error", "No se encuentra la orden.");
			return redirect(controllers.patrimonio.routes.OrdenesProvisionController.index() + UriTrack.get("?"));
		} else if (!op.controlPermisoDeposito()) {
			flash("error", "La institucion de la orden no corresponde a su institucion asignada.");
			return redirect(controllers.patrimonio.routes.OrdenesProvisionController.index() + UriTrack.get("?"));
		}

		return ok(editarOrdenProvision.render(oForm.fill(op)));
	}

	@CheckPermiso(key = "ordenesProvisionEditar")
	public static Result actualizar() {

		Form<OrdenProvision> opForm = form(OrdenProvision.class).bindFromRequest();

		if (opForm.hasErrors()) {
			flash("error", "Error en formulario" + opForm.errors());
			return badRequest(editarOrdenProvision.render(opForm));
		}

		OrdenProvision ordenProvision = opForm.get();

		/*
		 * List<OrdenProvision> op = OrdenProvision.find.where()
		 * .eq("numero", ordenProvision.numero)
		 * .eq("ejercicio_id", ordenProvision.ejercicio_id)
		 * .ne("id",ordenProvision.id).findList();
		 *
		 * if(op.size() > 0) {
		 * flash("error",
		 * "Ya existe una orden de provisión con el número <b>"+op.get(0).
		 * numero+"</b> y ejercicio <b>" + op.get(0).ejercicio.nombre + "</b>.");
		 * return badRequest(editarOrdenProvision.render(opForm));
		 * }
		 */

		if (!ordenProvision.controlPermisoDeposito()) {
			flash("error", "La institucion no corresponde a su institucion asignada.");
			return badRequest(editarOrdenProvision.render(opForm));
		}

		try {

			ordenProvision.update();
			flash("success", "La orden se ha modificado correctamente.");
			// return
			// redirect(controllers.patrimonio.routes.OrdenesProvisionController.index());
			return redirect(controllers.patrimonio.routes.OrdenesProvisionController.ver(ordenProvision.id, 0));
		} catch (Exception e) {
			flash("error", "No se ha podido mofificar la orden de provisión.");
			return badRequest(editarOrdenProvision.render(opForm));
		}

	}

	@CheckPermiso(key = "ordenesProvisionEliminar")
	public static Result eliminar(Long id) {

		// OrdenProvision op = OrdenProvision.find.byId(id);

		OrdenProvision op = Ebean.find(OrdenProvision.class).select("id").setId(id).findUnique();
		Integer numero = op.numero;

		try {
			op.delete();
			flash("success", "Se ha eliminado la orden de provisión número");
			return redirect(controllers.patrimonio.routes.OrdenesProvisionController.index() + UriTrack.get("?"));
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion");
			flash("error", "No se ha podido eliminar la orden de provisión.");
			return redirect(controllers.patrimonio.routes.OrdenesProvisionController.ver(id, 0));
		}

	}

	@CheckPermiso(key = "ordenesProvisionVer")
	public static Result productosRecepcionados(Long orden_provision_id) {

		Pagination<OrdenProvisionLineas> recepcionados = OrdenProvisionLineas
				.getProductosRecepcionados(orden_provision_id);

		return ok(productosRecepcionados.render(orden_provision_id, recepcionados));
	}

	@CheckPermiso(key = "ordenesProvisionVer")
	public static Result ver(long id, long idActa) {
		OrdenProvision op = OrdenProvision.find.byId(id);

		if (op != null) {
			if (!op.controlPermisoDeposito()) {
				flash("error", "La institucion de la orden no corresponde a su institucion asignada.");
				return redirect(controllers.patrimonio.routes.OrdenesProvisionController.index() + UriTrack.get("?"));
			}

			OrdenProvisionLineas o = new OrdenProvisionLineas();
			Pagination<OrdenProvisionLineas> b = OrdenProvisionLineas.getLineas(op.orden_compra_id);
			return ok(verOrdenProvision.render(op, b, new PaginadorFicha(UriTrack.code())));

		} else {
			flash("error", "No se encuentra la Orden de Provision.");
			return redirect(controllers.patrimonio.routes.OrdenesProvisionController.index() + UriTrack.get("?"));
		}
	}

	@CheckPermiso(key = "ordenesProvisionVer")
	public static Result verProductosSolicitados(long id) {
		OrdenProvision op = OrdenProvision.find.byId(id);

		OrdenProvisionLineas o = new OrdenProvisionLineas();
		Pagination<OrdenProvisionLineas> b = OrdenProvisionLineas.getLineas(op.orden_compra_id);

		return ok(listadoProductosSolicitados.render(op, b));
	}

	public static Result getRecepciones(Long id) {

		Pagination<Recepcion> recepciones = Recepcion.getRecepcionesByOrdenDeProvision(id);
		return ok(listadoRecepciones.render(id, recepciones));
	}

	public static Result suggestOrdenProvision(String input) {

		ObjectNode rpta = Json.newObject();
		ArrayNode ordenProvision = rpta.arrayNode();

		OrdenProvision ad = new OrdenProvision();

		for (OrdenProvision a : ad.getDataSuggest(input, 25, false)) {
			ObjectNode restJs = Json.newObject();
			restJs.put("id", a.id);
			restJs.put("value", a.numero);
			restJs.put("info", "");
			ordenProvision.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", ordenProvision);

		return ok(response);
	}

	public static Result get(int id) {
		OrdenProvision op = OrdenProvision.find.select("id, numero").where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
		ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if (op == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la orden provision");
		} else {
			restJs.put("success", true);
			restJs.put("id", op.id);
			restJs.put("nombre", op.numero);
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result modalBuscar() {
		Pagination<OrdenProvision> p = new Pagination<OrdenProvision>();
		p.setOrderDefault(" ");
		p.setSortByDefault("ejercicio.id DESC, id DESC");

		ExpressionList<OrdenProvision> e = OrdenProvision.find.where();

		if (!RequestVar.get("ejercicio").isEmpty()) {
			e.eq("ejercicio.id", Integer.parseInt(RequestVar.get("ejercicio")));
		}
		if (!RequestVar.get("numero").isEmpty()) {
			e.eq("numero", Integer.parseInt(RequestVar.get("numero")));
		}

		p.setExpressionList(e);
		return ok(modalBusquedaOrdenProvision.render(p, form().bindFromRequest()));
	}

	public static List<Integer> getSeleccionadosLineasAjusteOrden() {
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_linea_ajuste_orden[]");
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

	public static Result modalCrearActasDeAjustes(Long ordenId) {
		return ok(modalCrearActasDeAjustes.render(form().bindFromRequest(), ordenId, actaForm));
	}

	@CheckPermiso(key = "anulacionRecepcionProductosCrear")
	public static Result crearActasDeAjustes() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		ObjectNode result = Json.newObject();
		Form<ActaRecepcion> actaForm = form(ActaRecepcion.class).bindFromRequest();

		if (request().body().asFormUrlEncoded().get("ordenId")[0] == null) {
			flash("error", "Error no se puede determinar el id de orden.");
			return ok(modalCrearActasDeAjustes.render(d, null, actaForm));
		}

		Logger.debug("xxxxxxxxxxxx " + request().body().asFormUrlEncoded().get("ordenId")[0]);
		Long ordenId = new Long(request().body().asFormUrlEncoded().get("ordenId")[0]);

		if (actaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(modalCrearActasDeAjustes.render(d, ordenId, actaForm));
		}

		List<Integer> lineasAjusteOrdenSeleccionados = getSeleccionadosLineasAjusteOrden();
		if (lineasAjusteOrdenSeleccionados.size() == 0) {
			flash("error", "Debe seleccionar un ajuste.");
			return ok(modalCrearActasDeAjustes.render(d, ordenId, actaForm));
		}

		String sqlNumero = "SELECT id FROM actas_recepcion WHERE numero = '" + actaForm.data().get("numero").trim()
				+ "' and ejercicio_id = " + actaForm.data().get("ejercicio_id");

		SqlRow numero = Ebean.createSqlQuery(sqlNumero).findUnique();

		if (numero != null) {
			flash("error", "El número de acta ya existe.");
			return ok(modalCrearActasDeAjustes.render(d, ordenId, actaForm));
		}

		try {

			Ebean.beginTransaction();
			ActaRecepcion acta = actaForm.get();
			acta.create_usuario_id = Usuario.getUsuarioSesion();
			acta.orden_provision_id = ordenId.intValue();
			acta.estado_id = (long) Estado.ACTA_ESTADO_BORRADOR;
			acta.auto_creacion = true;
			acta.create_usuario_id = Usuario.getUsuarioSesion();
			acta.create_date = new Date();
			acta.save();

			for (Integer idAjuste : lineasAjusteOrdenSeleccionados) {

				OrdenLineaAjuste ola = OrdenLineaAjuste.find.byId(idAjuste.longValue());

				if (Producto.LISTA_PRODUCTOS_DIFERENCIA_CAMBIO.contains(ola.producto_id)) {
					if (ola != null) {
						ActaRecepcionLineaAjuste arl = new ActaRecepcionLineaAjuste();
						arl.acta_id = acta.id;
						arl.cantidad = ola.cantidad;
						arl.producto_id = ola.producto_id;
						arl.cuenta_analitica_id = ola.cuenta_analitica_id;
						arl.udm_id = ola.udm_id;
						arl.precio = ola.precio;
						arl.create_date = new Date();
						arl.create_usuario_id = Usuario.getUsuarioSesion().longValue();
						arl.save();

					}
				} else {
					result.put("error", true);
					flash("error", "Solo se puede crear ajustes de Diferencia de Cotizacion.");
					Ebean.rollbackTransaction();
					return ok(result);
				}
			}

			result.put("success", true);
			flash("success", "El acta de recepción número <b>" + acta.numero + "</b> se ha creado correctamente.");

			Ebean.commitTransaction();
			return ok(result);
		} catch (Exception e) {
			result.put("error", true);
			flash("error", "Ocurrió un problema al crear el acta de recepción. " + e.getMessage());
			Ebean.rollbackTransaction();
			return ok(result);
		} finally {
			Ebean.endTransaction();
		}
	}

	public static Result modalAnularProductosPedientes(Long ordenId) {

		OrdenProvision op = OrdenProvision.find.byId(ordenId);

		List<Factura> f = Factura.find.where()
				.eq("orden_id", op.orden_compra_id)
				.ne("state_id", Estado.FACTURA_ESTADO_BORRADOR)
				.ne("state_id", Estado.FACTURA_ESTADO_CANCELADO).findList();

		return ok(modalAnularProductosPedientes.render(form().bindFromRequest(), ordenId, f));
	}

	@CheckPermiso(key = "anulacionRecepcionProductosCrear")
	public static Result anularProductosPediente() throws SQLException {

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		String[] id = null;
		String[] ob = null;
		Long ordenId = null;
		String observaciones = "";
		try {
			id = request().body().asFormUrlEncoded().get("id");
			ob = request().body().asFormUrlEncoded().get("observaciones");
			ordenId = new Long(id[0]);
			observaciones = ob[0];
		} catch (NullPointerException e) {
		}

		OrdenProvision op = OrdenProvision.find.byId(ordenId);

		List<Factura> fx = Factura.find.where()
				.eq("orden_id", op.orden_compra_id)
				.ne("state_id", Estado.FACTURA_ESTADO_BORRADOR)
				.ne("state_id", Estado.FACTURA_ESTADO_CANCELADO).findList();

		List<Integer> lineasAnulacioneSeleccionadosSeleccionados = getSeleccionadosLineasAnulaciones();
		if (lineasAnulacioneSeleccionadosSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar las lineas.");
			return ok(modalAnularProductosPedientes.render(d, ordenId, fx));
		}

		if (d.hasErrors())
			return ok(modalAnularProductosPedientes.render(d, ordenId, fx));

		ObjectNode result = Json.newObject();
		Connection conn = null;
	    PreparedStatement stmt = null;

		Ebean.beginTransaction();



		try {
			int count = 0;
			int total = 0;

		    int x = 0;
			// OrdenProvision op = OrdenProvision.find.byId(ordenId);
			List<OrdenProvisionLineas> lop = OrdenProvisionLineas.getQuery(op.orden_compra_id)
					.where().in("orden_linea_id", lineasAnulacioneSeleccionadosSeleccionados).findList();

			boolean f = false;
			List<SqlRow> sc = OrdenLinea.getCantidadDisponiblePorClientesPorOrden(op.orden_compra_id);
			if (sc.size() > 0) {
				f = true;
			}

			conn = play.db.DB.getConnection();

			stmt = conn.prepareStatement("alter table ordenes disable trigger actualiza_total_orden");
		    x = stmt.executeUpdate();
		    stmt.close();

			stmt = conn.prepareStatement("alter table orden_lineas_ajustes disable trigger actualiza_total_orden");
		    x = stmt.executeUpdate();
		    stmt.close();

		    stmt = conn.prepareStatement("alter table orden_lineas_ajustes disable trigger after_insert_update_delete");
		    x = stmt.executeUpdate();
		    stmt.close();



			for (OrdenProvisionLineas ox : lop) {
				if (ox.getPendiente().compareTo(BigDecimal.ZERO) > 0) {
					OrdenLineaAnulacion ola = new OrdenLineaAnulacion();
					ola.cantidad = ox.getPendiente();
					ola.create_date = new Date();
					ola.create_usuario_id = Usuario.getUsuarioSesion().longValue();
					ola.orden_linea_id = ox.orden_linea_id;
					ola.observaciones = observaciones;
					ola.save();
					count++;

					if (f) {
						List<SqlRow> s = OrdenLinea.getCantidadDisponiblePorClientes(ox.orden_linea_id);

						if (s.size() > 0) {
							List<SqlRow> xx = OrdenLinea.getCantidadDisponiblePorClientes(ox.orden_linea_id);
							if (xx.size() > 0) {
								for (SqlRow xs : xx) {
									OrdenLineaAnulacionCliente olac = new OrdenLineaAnulacionCliente();
									olac.cantidad = xs.getBigDecimal("cantidad");
									olac.cliente_id = xs.getLong("cliente_id");
									;
									olac.orden_linea_anulacion_id = ola.id;
									olac.save();
								}
							}
						}
					}
				}
				total++;
			}





			stmt = conn.prepareStatement("alter table orden_lineas_ajustes enable trigger actualiza_total_orden");
		    x = stmt.executeUpdate();
		    stmt.close();
		    stmt = conn.prepareStatement("alter table orden_lineas_ajustes enable trigger after_insert_update_delete");
		    x = stmt.executeUpdate();
		    stmt.close();
		    stmt = conn.prepareStatement("alter table ordenes enable trigger actualiza_total_orden");
		    x = stmt.executeUpdate();
		    stmt.close();

			stmt = conn.prepareStatement("select actualiza_totales_ordenes_ordenes(null)");
		    stmt.execute();
		    stmt.close();

		    stmt = conn.prepareStatement("select actualiza_totales_ordenes_recepcionados(null)");
		    stmt.execute();
		    stmt.close();

		    Ebean.commitTransaction();



			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de " + total + " seleccionados.");
			result.put("html", modalAnularProductosPedientes.render(d, ordenId, fx).toString());
			return ok(result);
		} catch (Exception e) {

			Ebean.rollbackTransaction();
			OrdenProvision.enableTriggers();
			flash("error", "No se puede modificar los registros.");
			return ok(modalAnularProductosPedientes.render(d, ordenId, fx));
		} finally {
			Ebean.endTransaction();

		    if (stmt != null)
		          try {
		            stmt.close();
		          } catch (Exception e) {
		          }

		        if (conn != null)
		          try {
		            conn.close();
		          } catch (Exception e) {
		          }


		}
	}

	public static List<Integer> getSeleccionadosLineasAnulaciones() {
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_linea_solicitados[]");
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

	public static Result getLastNumeroProvision() {
		ObjectNode obj = Json.newObject();
		ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if (request().body().asFormUrlEncoded().get("expediente_id") == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
			nodo.add(restJs);
			return ok(restJs);
		} else {

			Long idExpediente = new Long(request().body().asFormUrlEncoded().get("expediente_id")[0]);
			Expediente ex = Expediente.find.byId(idExpediente);

			String sql = "SELECT (max(numero)+1) as numero FROM ordenes_provision WHERE ejercicio_id = :ejercicio_id ";
			SqlRow s = Ebean.createSqlQuery(sql).setParameter("ejercicio_id", ex.ejercicio_id).findUnique();

			if (s == null) {
				restJs.put("success", false);
				restJs.put("message", "No se encuentra la orden provision");
			} else {
				restJs.put("success", true);
				restJs.put("message", "No se encuentra el expediente");
				restJs.put("numero", s.getInteger("numero"));
			}
			nodo.add(restJs);
			return ok(restJs);
		}
	}

}
