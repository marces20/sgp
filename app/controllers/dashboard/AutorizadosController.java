package controllers.dashboard;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.velocity.tools.generic.MathTool;
import org.h2.util.Utils;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;

import models.ActaRecepcion;
import models.Autorizado;
import models.AutorizadoLinea;
import models.AutorizadoLineaActa;
import models.AutorizadoLineaDetalle;
import models.CertificacionCompra;
import models.DireccionProveedor;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.Orden;
import models.OrdenLinea;
import models.OrdenLineaCliente;
import models.OrdenProvision;
import models.Proveedor;
import models.Remito;
import models.Usuario;
import models.auth.Permiso;
import models.informes.InformeDeudaPorActa;
import models.informes.InformeDeudaPorActaMaterializada;
import models.informes.InformeDeudaProveedoresMaterializada;
import models.informes.InformeEstadisticoDeudaProveedores;
import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.sinPermiso;
import views.html.contabilidad.facturas.contenidoTabInfoProveedor;
import views.html.dashboard.autorizados.*;
import views.html.dashboard.autorizados.modales.*;
import views.html.patrimonio.ordenesProvision.reportes.modalReporteOrdenProvision;

@Security.Authenticated(Secured.class)
public class AutorizadosController extends Controller {

	final static Form<Autorizado> autorizadoForm = form(Autorizado.class);

	public static Result URL_LISTA_AUTORIZADO = redirect(
			controllers.dashboard.routes.AutorizadosController.index());

	@CheckPermiso(key = "dashboardAutorizadosListado")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		return ok(
				indexAutorizado.render(Autorizado.page(
						RequestVar.get("nombre"),
						RequestVar.get("btnFiltro[0]"), // borrador
						RequestVar.get("btnFiltro[1]"), // aprobado
						RequestVar.get("btnFiltro[2]"), // cancelado
						RequestVar.get("expediente.id"),
						RequestVar.get("proveedor.id")),
						d, pf));
	}

	@CheckPermiso(key = "dashboardAutorizadosVer")
	public static Result ver(Long id) {
		Autorizado autorizado = Autorizado.find.byId(id);
		Form<Autorizado> autorizadoForm = form(Autorizado.class).fill(autorizado);
		return ok(verAutorizado.render(autorizadoForm, autorizado, new PaginadorFicha(UriTrack.code())));
	}

	@CheckPermiso(key = "dashboardAutorizadosCrear")
	public static Result crear() {

		Map<String, String> p = new HashMap<String, String>();
		p.put("nombre", "AUT");
		Form<Autorizado> autorizadoForm = form(Autorizado.class).bind(p);
		autorizadoForm.discardErrors();
		return ok(crearAutorizado.render(autorizadoForm));
	}

	@CheckPermiso(key = "dashboardAutorizadosCrear")
	public static Result guardar() {

		Form<Autorizado> autorizadoForm = form(Autorizado.class).bindFromRequest();

		validarForm(autorizadoForm);

		if (autorizadoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearAutorizado.render(autorizadoForm));
		}

		try {
			Autorizado c = autorizadoForm.get();
			c.create_date = new Date();
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());

			if (c.cot_dolar != null && c.cot_dolar.compareTo(BigDecimal.ZERO) > 0) {
				if (c.tipo_moneda_id == null) {

					autorizadoForm.reject("tipo_moneda_id", "Debe ingresar un tipo de moneda para la cotizacion.");
					if (autorizadoForm.hasErrors()) {
						flash("error", "Debe ingresar un tipo de moneda para la cotizacion.");
						return badRequest(crearAutorizado.render(autorizadoForm));
					}

				}
			}

			if (c.tipo_moneda_id != null) {
				if (c.cot_dolar == null || c.cot_dolar.compareTo(BigDecimal.ZERO) == 0) {

					autorizadoForm.reject("cot_dolar", "Debe ingresar un tipo de moneda para la cotizacion.");
					if (autorizadoForm.hasErrors()) {
						flash("error", "Debe ingresar una cotizacion para el tipo de moneda.");
						return badRequest(crearAutorizado.render(autorizadoForm));
					}
				}
			}

			c.save();

			flash("success", "El Autorizado se ha actualizado");
			return redirect(controllers.dashboard.routes.AutorizadosController.ver(autorizadoForm.get().id)
					+ UriTrack.get("&"));
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el autorizado");
			return badRequest(crearAutorizado.render(autorizadoForm));
		}
	}

	@CheckPermiso(key = "dashboardAutorizadosModificar")
	public static Result editar(Long id) {
		Autorizado autorizado = Autorizado.find.byId(id);

		if (autorizado == null) {
			flash("error", "No se encuentra el autorizado.");
			return redirect(controllers.dashboard.routes.AutorizadosController.index() + UriTrack.get("?"));
		} else if (autorizado.estado_id == Estado.AUTORIZADO_ESTADO_APROBADO
				|| autorizado.estado_id == Estado.AUTORIZADO_ESTADO_CANCELADO) {
			flash("error", "El autorizado no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}

		return ok(editarAutorizado.render(autorizadoForm.fill(autorizado), autorizado));
	}

	@CheckPermiso(key = "dashboardAutorizadosModificar")
	public static Result actualizar(Long id) {

		Form<Autorizado> autorizadoForm = form(Autorizado.class).bindFromRequest();
		validarForm(autorizadoForm);
		Autorizado autorizado = Ebean.find(Autorizado.class, id);

		if (autorizadoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarAutorizado.render(autorizadoForm, autorizado));
		}

		try {
			Autorizado c = autorizadoForm.get();
			c.estado_id = autorizado.estado_id;
			c.write_date = new Date();
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());

			if (c.cot_dolar != null && c.cot_dolar.compareTo(BigDecimal.ZERO) > 0) {
				if (c.tipo_moneda_id == null) {

					autorizadoForm.reject("tipo_moneda_id", "Debe ingresar un tipo de moneda para la cotizacion.");
					if (autorizadoForm.hasErrors()) {
						flash("error", "Debe ingresar un tipo de moneda para la cotizacion.");
						return badRequest(editarAutorizado.render(autorizadoForm, autorizado));
					}

				}
			}

			if (c.tipo_moneda_id != null) {
				if (c.cot_dolar == null || c.cot_dolar.compareTo(BigDecimal.ZERO) == 0) {

					autorizadoForm.reject("cot_dolar", "Debe ingresar un tipo de moneda para la cotizacion.");
					if (autorizadoForm.hasErrors()) {
						flash("error", "Debe ingresar una cotizacion para el tipo de moneda.");
						return badRequest(editarAutorizado.render(autorizadoForm, autorizado));
					}
				}
			}

			if (c.tipo_moneda_id != null && c.cot_dolar != null) {
				List<AutorizadoLinea> alx = AutorizadoLinea.find.where().ne("orden.tipo_moneda", c.tipo_moneda_id)
						.eq("autorizado_id", c.id).findList();
				if (alx.size() > 0) {
					flash("error",
							"Existen lineas cargadas con un tipo de moneda diferente a la cargada en el autorizado");
					return badRequest(editarAutorizado.render(autorizadoForm, autorizado));
				}
			}

			String sql = " SELECT al.id as id FROM autorizado_lineas al " +
					" INNER JOIN autorizados a ON a.id = al.autorizado_id " +
					" INNER JOIN ordenes o ON o.id = al.orden_id " +
					" WHERE o.cot_dolar is not null AND o.cot_dolar > 0 AND a.id = :autorizadoId";

			List<SqlRow> s = Ebean.createSqlQuery(sql)
					.setParameter("autorizadoId", c.id)
					.findList();

			if (c.cot_dolar != null && c.cot_dolar.compareTo(BigDecimal.ZERO) > 0) {

				for (SqlRow sl : s) {
					SqlUpdate update = Ebean
							.createSqlUpdate("UPDATE autorizado_lineas SET cot_dolar =:cot_dolar WHERE id =:id");
					update.setParameter("cot_dolar", c.cot_dolar);
					update.setParameter("id", sl.getLong("id"));
					update.execute();
				}

			} else {
				if (s.size() > 0) {
					flash("error", "Hay lineas en Moneda Extranjera. Debe ingresar una cotizacion");
					return badRequest(editarAutorizado.render(autorizadoForm, autorizado));
				}
			}
			InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
			InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
			c.update();
			flash("success", "El autorizado se ha actualizado");
			return redirect(controllers.dashboard.routes.AutorizadosController.ver(autorizadoForm.get().id)
					+ UriTrack.get("&"));
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el autorizado");
			return badRequest(editarAutorizado.render(autorizadoForm, autorizado));
		}
	}

	@CheckPermiso(key = "dashboardAutorizadosEliminar")
	public static Result eliminar(Long id) {

		Autorizado autorizado = Ebean.find(Autorizado.class).select("id, estado_id").setId(id).findUnique();

		if (autorizado == null) {
			flash("error", "No se encuentra el autorizado.");
			return redirect(controllers.dashboard.routes.AutorizadosController.index() + UriTrack.get("?"));
		}

		if (autorizado.estado_id == Estado.AUTORIZADO_ESTADO_BORRADOR
				|| autorizado.estado_id == Estado.AUTORIZADO_ESTADO_CANCELADO) {
			try {
				autorizado.delete();
				flash("success", "Se ha eliminado el autorizado");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar el autorizado");
			}
		} else {
			flash("error",
					"No se ha podido eliminar el autorizado. Unicamente se puede eliminar cuando el estado de el autorizado se encuentra en borrador o cancelado.");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}

	public static Result cambiarEstado(Long idAutorizado, Long idEstado) throws IOException {
		Estado estado = Estado.getEstado(idEstado, Estado.TIPO_AUTORIZADO);

		Autorizado autorizado = Autorizado.find.byId(idAutorizado);

		if (autorizado == null) {
			flash("error", "No se encuentra el autorizado.");
			return redirect(request().getHeader("referer"));
		}

		if (autorizado.autorizadoLinea == null || autorizado.autorizadoLinea.isEmpty()) {
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(request().getHeader("referer"));
		}

		if (idEstado != null) {

			Boolean permiso = false;

			switch (idEstado.intValue()) {
				case Estado.AUTORIZADO_ESTADO_BORRADOR:
					if (!Permiso.check("dashboardAutorizadosPasarBorrador")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarEnBorrador(autorizado.id);
					break;
				case Estado.AUTORIZADO_ESTADO_APROBADO:
					if (!Permiso.check("dashboardAutorizadosPasarAprobado")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarAprobado(autorizado.id);
					break;
				case Estado.AUTORIZADO_ESTADO_CANCELADO:
					if (!Permiso.check("dashboardAutorizadosPasarCancelado")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarCancelado(autorizado.id);
					break;
				default:
					break;
			}

		}

		return redirect(controllers.dashboard.routes.AutorizadosController.ver(autorizado.id) + UriTrack.get("&"));
	}

	@CheckPermiso(key = "dashboardAutorizadosPasarBorrador")
	public static void pasarEnBorrador(Long idAutorizado) {

		Autorizado autorizado = Ebean.find(Autorizado.class).select("id, estado_id,write_date,write_usuario_id")
				.setId(idAutorizado).findUnique();

		if (autorizado != null) {
			autorizado.estado_id = new Long(Estado.AUTORIZADO_ESTADO_BORRADOR);
			autorizado.write_date = new Date();
			autorizado.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			autorizado.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}

	@CheckPermiso(key = "dashboardAutorizadosPasarAprobado")
	public static void pasarAprobado(Long idAutorizado) {

		Autorizado autorizado = Ebean.find(Autorizado.class).select("id, estado_id,write_date,write_usuario_id")
				.setId(idAutorizado).findUnique();

		if (autorizado != null) {

			try {

				autorizado.estado_id = new Long(Estado.AUTORIZADO_ESTADO_APROBADO);
				autorizado.write_date = new Date();
				autorizado.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				autorizado.save();

				String sqlOp = "SELECT SUM(monto) as monto,orden_provision_id FROM autorizado_lineas " +
						"WHERE autorizado_id = :autorizadoId AND orden_provision_id IS NOT NULL " +
						"GROUP BY orden_provision_id ";

				List<SqlRow> s = Ebean.createSqlQuery(sqlOp).setParameter("autorizadoId", idAutorizado).findList();

				boolean esPorElTotal = false;
				for (SqlRow sx : s) {

					OrdenProvision op = OrdenProvision.find.byId(sx.getLong("orden_provision_id"));

					if (op.ordenCompra.getTotalTotal().setScale(2, RoundingMode.HALF_DOWN)
							.compareTo(sx.getBigDecimal("monto").setScale(2, RoundingMode.HALF_DOWN)) == 0) {
						esPorElTotal = true;
					}

					if (esPorElTotal) {// aca si es por el total de la orden creo una sola factura.
						Factura.crearFactruasDesdeOrdenCompra(op.ordenCompra, idAutorizado, false);
					} else {

						List<Factura> fp = Factura.find.where().eq("orden_id", op.ordenCompra.id).findList();

						Long facturaPrincipalId = null;
						if (fp.size() == 0) {
							Factura ffp = Factura.crearFactruasDesdeOrdenCompra(op.ordenCompra, idAutorizado, true);
							facturaPrincipalId = ffp.id;
						} else {
							Factura ffp = Factura.find.where().eq("parcial", true).eq("orden_id", op.ordenCompra.id)
									.findUnique();
							facturaPrincipalId = ffp.id;
						}

						String sqlActas = "SELECT SUM(monto) as monto,acta_recepcion_id,orden_provision_id FROM autorizado_lineas "
								+
								"WHERE autorizado_id = :autorizadoId AND orden_provision_id = :orden_provision_id " +
								"GROUP BY acta_recepcion_id,orden_provision_id ";

						List<SqlRow> sa = Ebean.createSqlQuery(sqlActas)
								.setParameter("autorizadoId", idAutorizado)
								.setParameter("orden_provision_id", sx.getLong("orden_provision_id"))
								.findList();
						boolean tieneMasDeUnActa = (sa.size() > 1) ? true : false;

						Factura.crearFacturasDesdeAutorizadosConActas(sa, op, idAutorizado, facturaPrincipalId);
					}

				}

			} catch (Exception e) {

			}

			flash("success", "Operación exitosa. Estado actual: En Curso");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "dashboardAutorizadosPasarCancelado")
	public static void pasarCancelado(Long idAutorizado) {

		Autorizado autorizado = Ebean.find(Autorizado.class).select("id, estado_id,write_date,write_usuario_id")
				.setId(idAutorizado).findUnique();

		List<Factura> f = Factura.find.where().eq("autorizado_id", autorizado.id).findList();
		if (f.size() > 0) {
			flash("error", "No se puede cancelar el autorizado. Existen facturas asociadas al mismo.");
		} else {
			if (autorizado != null) {
				autorizado.estado_id = new Long(Estado.AUTORIZADO_ESTADO_CANCELADO);
				autorizado.write_date = new Date();
				autorizado.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				autorizado.save();
				flash("success", "Operación exitosa. Estado actual: Cancelado");
			} else {
				flash("error", "Parámetros incorrectos. ");
			}
		}

	}

	public static void validarForm(Form<Autorizado> filledForm) {
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("fecha", "Fecha inválida"));
		v.validate();
	}

	public static Result getListadoDeudasActas() {

		String deuda_mayor = "0";
		Pagination<InformeDeudaPorActaMaterializada> p = InformeDeudaPorActaMaterializada.page(
				// Pagination<InformeDeudaPorActa> p = InformeDeudaPorActa.page(
				RequestVar.get("acta_numero"),
				RequestVar.get("orden_provision"),
				RequestVar.get("proveedor_id"),
				RequestVar.get("expediente_id"),
				RequestVar.get("ejercicio"),
				RequestVar.get("deuda_mayor"),
				RequestVar.get("deuda_menor"),
				RequestVar.get("profe"),
				true,
				RequestVar.get("dolar"), RequestVar.get("deposito_id"),
				RequestVar.get("tipo_acta"),
				RequestVar.get("tipo_cuenta_id"),
				RequestVar.get("tipo_moneda"),
				RequestVar.get("emergencia"));

		Autorizado a = Autorizado.find.byId(new Long(RequestVar.get("idAutorizado")));
		a.profe = new Boolean(RequestVar.get("profe"));
		// a.tipo_cuenta_id = new Long(RequestVar.get("tipo_cuenta_id"));
		a.save();
		// InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		// InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();

		return ok(
				contenidoTabCargaActa.render(p, form().bindFromRequest(), new Long(RequestVar.get("idAutorizado")), a));
	}

	public static Result getListadoDeudas() {

		String deuda_mayor = "0";

		//Pagination<InformeDeudaProveedoresMaterializada> p = InformeDeudaProveedoresMaterializada.page(
				 Pagination<InformeEstadisticoDeudaProveedores> p = InformeEstadisticoDeudaProveedores.page(
				RequestVar.get("orden"),
				RequestVar.get("proveedor_id"),
				RequestVar.get("expediente_id"),
				RequestVar.get("ejercicio"),
				RequestVar.get("rubro_id"),
				"0.01", // RequestVar.get("deuda_mayor"),
				"", // RequestVar.get("deuda_menor"),
				"", // RequestVar.get("pago_mayor"),
				"", // RequestVar.get("pago_menor"),
				"", // RequestVar.get("compromiso_mayor"),
				"", // RequestVar.get("compromiso_menor"),
				RequestVar.get("profe"),
				RequestVar.get("deposito_id"),
				true,
				RequestVar.get("dolar"),
				RequestVar.get("tipo_cuenta_id"),
				RequestVar.get("acta_sin_adelanto_menor_pago"),
				"",
				RequestVar.get("emergencia"),
				RequestVar.get("perimido"),
				RequestVar.get("subrubro_id"));

		Logger.debug("zzzzzzzzzzzzz " + RequestVar.get("profe"));
		Logger.debug("zzzzzzzzzzzzz " + RequestVar.get("tipo_cuenta_id"));
		Autorizado a = Autorizado.find.byId(new Long(RequestVar.get("idAutorizado")));
		a.profe = new Boolean(RequestVar.get("profe"));
		// a.tipo_cuenta_id = new Long(RequestVar.get("tipo_cuenta_id"));
		a.tipo_cuenta_id = new Long(1);
		a.save();
		// InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		// InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();

		return ok(contenidoTabCarga.render(p, form().bindFromRequest(), new Long(RequestVar.get("idAutorizado")), a));
	}

	public static Result modalAgregarMontos(Long idOrdenProvision, Long idAutorizado, Long idOrdenCompra,
			Long tipo_cuenta_id) {
		DynamicForm d = form().bindFromRequest();

		List<ActaRecepcion> listaActas = ActaRecepcion.getListaActasDeudas(idOrdenProvision, null);

		return ok(modalAgregarMontos.render(listaActas, idAutorizado, idOrdenProvision, idOrdenCompra, tipo_cuenta_id));
	}

	public static Result modalAgregarMontosActas(Long idActa, Long idOrdenProvision, Long idAutorizado,
			Long idOrdenCompra, Long tipo_cuenta_id) {
		DynamicForm d = form().bindFromRequest();

		List<ActaRecepcion> listaActas = ActaRecepcion.getListaActasDeudas(null, idActa);

		InformeDeudaPorActaMaterializada ida = InformeDeudaPorActaMaterializada.find.where().eq("id", idActa)
				.findUnique();
		// InformeDeudaPorActa ida = InformeDeudaPorActa.find.where().eq("id",
		// idActa).findUnique();

		// BigDecimal deudaActa = InformeDeudaPorActa.find.where().eq("id",
		// idActa).findUnique().totalDeuda;

		return ok(modalAgregarMontosActas.render(listaActas, idAutorizado, idOrdenProvision, idOrdenCompra, ida,
				tipo_cuenta_id));
	}

	public static Result modalAgregarMontosSinOp(Long idAutorizado, Long idOrdenCompra, Long tipo_cuenta_id) {
		DynamicForm d = form().bindFromRequest();

		Orden o = Orden.find.byId(idOrdenCompra);

		if (o.tipo_orden.compareToIgnoreCase("certificacioncompra") == 0
				|| o.tipo_orden.compareToIgnoreCase("certificacionobra") == 0) {
			List<CertificacionCompra> listaCertificaciones = ActaRecepcion
					.getListaCertificacionesComprasDeudas(idOrdenCompra, null);
			return ok(modalAgregarMontosCertificacionesDesdeOrden.render(listaCertificaciones, idAutorizado,
					idOrdenCompra, tipo_cuenta_id));
		} else {
			List<ActaRecepcion> listaActas = new ArrayList<ActaRecepcion>();
			return ok(modalAgregarMontos.render(listaActas, idAutorizado, null, idOrdenCompra, tipo_cuenta_id));
		}

	}

	public static Result modalAgregarMontosCertificacionesCompras(Long idCertificacion, Long idAutorizado,
			Long idOrdenCompra, Long tipo_cuenta_id) {
		DynamicForm d = form().bindFromRequest();

		List<CertificacionCompra> listaCertificaciones = ActaRecepcion.getListaCertificacionesComprasDeudas(null,
				idCertificacion);

		return ok(modalAgregarMontosCertificacionCompras.render(listaCertificaciones, idAutorizado, idOrdenCompra,
				tipo_cuenta_id));
	}

	public static Result controlCargaCotizacion() {
		ObjectNode obj = Json.newObject();
		ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		ObjectNode errores = Json.newObject();
		boolean success = false;
		String texto = "";
		Logger.debug("aaaaaaaaaaa " + request().body().asFormUrlEncoded());
		Logger.debug("bbbbbbbbbbb " + request().body().asFormUrlEncoded().get("idAutorizado"));
		// Logger.debug("111111111111111111111
		// "+request().body().asFormUrlEncoded().get("cot_dolar"));
		try {

			String[] idAutorizado = request().body().asFormUrlEncoded().get("idAutorizado");
			Long atId = new Long(idAutorizado[0]);
			Autorizado a = Autorizado.find.byId(atId);

			BigDecimal cd = new BigDecimal(1);
			;
			String[] cot_dolar = request().body().asFormUrlEncoded().get("cot_dolar");
			if (cot_dolar != null && cot_dolar[0] != null && !cot_dolar[0].isEmpty()) {
				cd = new BigDecimal(cot_dolar[0]);
			}

			Long tm = new Long(0);
			String[] tipo_moneda = request().body().asFormUrlEncoded().get("tipo_moneda_id");
			if (tipo_moneda != null && tipo_moneda[0] != null && !tipo_moneda[0].isEmpty()) {
				tm = new Long(tipo_moneda[0]);
			}

			Logger.debug("aaaaaaaaaaa " + cd);
			Logger.debug("aaaaaaaaaaa " + a.cot_dolar);

			BigDecimal cda = new BigDecimal(1);
			if (a.cot_dolar != null) {
				cda = a.cot_dolar;
			}

			Logger.debug("bb " + tm);
			Logger.debug("bbbb " + a.tipo_moneda_id);

			boolean editarTM = false;
			if (a.tipo_moneda_id == null && tm.compareTo(new Long(0)) != 0) {
				a.tipo_moneda_id = tm;
				editarTM = true;
			} else if (tm.compareTo(new Long(0)) == 0 && a.tipo_moneda_id != null) {
				a.tipo_moneda_id = null;
				editarTM = true;
			} else if (a.tipo_moneda_id != null && a.tipo_moneda_id.compareTo(tm) != 0) {
				a.tipo_moneda_id = tm;
				editarTM = true;
			}

			if (a.cot_dolar != null && a.tipo_moneda_id == null && tm.compareTo(new Long(0)) == 0) {
				success = true;
				texto = "ERROR: Debe ingresar un tipo de moneda.";

			}

			if (cda.compareTo(cd) != 0 || editarTM) {// SI ES DIFERENTE EL VALOR Q VIENE CON LO CARGADO

				if (tm.compareTo(new Long(0)) == 0) {
					success = true;
					texto = "ERROR: Debe ingresar un tipo de moneda para actualizar la cotizacion.";
				} else {

					List<AutorizadoLinea> al = AutorizadoLinea.find.where().isNotNull("orden.cot_dolar")
							.eq("autorizado_id", atId).findList();

					if (al.size() > 0) {
						success = true;
						texto = "ERROR: No se puede modificar la cotizacion porque ya hay lineas cargadas con moneda extranjera.";
					} else {
						/*
						 * List<AutorizadoLinea> alx =
						 * AutorizadoLinea.find.where().ne("orden.tipo_moneda",tm).eq("autorizado_id",
						 * atId).findList();
						 * if(alx.size() >0) {
						 * restJs.put("success", true);
						 * restJs.put("texto",
						 * "ERROR: No se puede modificar la cotizacion porque ya hay lineas cargadas con moneda extranjera."
						 * );
						 * }else {
						 */
						if (cd.compareTo(BigDecimal.ONE) == 0) {
							a.cot_dolar = null;
							a.tipo_moneda_id = null;
						} else {
							a.cot_dolar = cd;
							a.tipo_moneda_id = tm;
						}

						a.save();
						success = true;
						texto = "SE ACTUALIZÓ LA COTIZACION.";
						// }
					}
				}
			} else {

			}

			if (success) {
				restJs.put("success", success);
				restJs.put("texto", texto);
			} else {
				restJs.put("success", false);
			}

			nodo.add(restJs);
		} catch (NullPointerException e) {
			Logger.debug("5555555555555555 " + e);
		}
		Logger.debug("6666666666666666");
		return ok(restJs);

	}

	public static Result getActualizarDatos(Long idAutorizado) {
		ObjectNode obj = Json.newObject();
		ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		ObjectNode errores = Json.newObject();

		try {
			Autorizado a = Autorizado.find.byId(idAutorizado);

			if (a != null) {
				restJs.put("total", utils.NumberUtils.moneda(a.getTotal()));
				restJs.put("success", true);
			} else {
				restJs.put("success", false);
				restJs.put("error", "No se encuentra autorizado");
			}

			nodo.add(restJs);
		} catch (NullPointerException e) {
		}

		return ok(restJs);

	}

	public static Result cargarLineasAutorizadosCertificacionesCompras() {
		ObjectNode obj = Json.newObject();
		ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		ObjectNode errores = Json.newObject();
		Logger.debug("ssssssssssssssssssssssssss  cargarLineasAutorizadosCertificacionesCompras");
		String[] profeStr = request().body().asFormUrlEncoded().get("profe");
		String[] tipoCuentaIdStr = request().body().asFormUrlEncoded().get("tipo_cuenta_id");
		String[] monto_general = request().body().asFormUrlEncoded().get("monto_general");// monto general para carga
																							// solo desde autorizado por
																							// OP
		String[] idAutorizado = request().body().asFormUrlEncoded().get("idAutorizado");
		String[] idOrdenCompra = request().body().asFormUrlEncoded().get("idOrdenCompra");
		String[] ids = request().body().asFormUrlEncoded().get("id[]");// CHECK DE CADA LINEA
		String[] montosStr = request().body().asFormUrlEncoded().get("monto[]");// INPUT DE CADA LINEA
		String[] monto_totalesStr = request().body().asFormUrlEncoded().get("monto_total[]");// INPUT HIDDEN TOTAL DE
																								// CADA LINEA
		String[] monto_t = request().body().asFormUrlEncoded().get("monto_t");//
		String[] tiene_actas = request().body().asFormUrlEncoded().get("tiene_actas");// diferencia las dos modales de
																						// carga
		int i = 0;

		Long atId = new Long(idAutorizado[0]);
		Long tipoCuentaId = new Long(tipoCuentaIdStr[0]);
		Boolean profe = new Boolean(profeStr[0]);
		Autorizado autorizado = Autorizado.find.byId(atId);

		// List<AutorizadoLinea> alx =
		// AutorizadoLinea.find.where().eq("autorizado_id",atId).ne("orden.profe",
		// profe).findList();
		List<AutorizadoLinea> alx = AutorizadoLinea.find.where().eq("autorizado_id", atId)
				.ne("orden.tipo_cuenta_id", tipoCuentaId).findList();
		if (alx.size() > 0) {
			restJs.put("success", false);
			restJs.put("errorGeneral",
					"Ya existen cuentas con otra cuenta cargada.No puede cargar una linea con distinta cuenta.");
			nodo.add(restJs);
			return ok(restJs);
		}

		Logger.debug("0000000000000000 " + monto_general);
		Long idOrden = new Long(idOrdenCompra[0]);
		// InformeEstadisticoDeudaProveedores iep =
		// InformeEstadisticoDeudaProveedores.find.where().eq("orden_id",
		// idOrden).findUnique();
		InformeDeudaProveedoresMaterializada iep = InformeDeudaProveedoresMaterializada.find.where()
				.eq("orden_id", idOrden).findUnique();
		BigDecimal restoAutorizar = iep.getRestoAAutorizar();

		if (monto_general != null && monto_general[0] != null && !monto_general[0].isEmpty()) {

			Logger.debug("11111111111111111111111111111111111111111");
			// Long idOrden = new Long(idOrdenCompra[0]);
			BigDecimal monto_generalBg = new BigDecimal(monto_general[0].replace(",", ".")).setScale(2,
					RoundingMode.HALF_UP);
			List<CertificacionCompra> listaCerti = ActaRecepcion.getListaCertificacionesComprasDeudas(idOrden, null);
			BigDecimal montoTmp = new BigDecimal(0);
			boolean errorMontoActasAutorizado = false;

			if (monto_generalBg.compareTo(restoAutorizar) > 0) {

				Logger.debug("monto_generalBg: " + monto_generalBg);
				Logger.debug("restoAutorizar: " + restoAutorizar);
				Logger.debug("monto_generalBg.compareTo(restoAutorizar): " + monto_generalBg.compareTo(restoAutorizar));
				restJs.put("success", false);
				restJs.put("errorGeneral",
						"El monto a autorizar supera el valor de la orden con lo ya autorizado. Monto Limite de la orden "
								+ utils.NumberUtils.moneda(iep.totalOrden) + "  (VER AJUSTES)");
				nodo.add(restJs);
				return ok(restJs);
			}

			Ebean.beginTransaction();

			for (CertificacionCompra a : listaCerti) {

				try {

					CertificacionCompra cc = CertificacionCompra.find.where().eq("id", a.id).findUnique();
					Long certificacion_id = a.id;
					AutorizadoLinea altmp = AutorizadoLinea.find.where().eq("autorizado_id", atId)
							.eq("orden_id", cc.orden_id).setMaxRows(1).findUnique();
					Long autoLineaId = null;
					BigDecimal montoACargar = new BigDecimal(0);

					Logger.debug("monto_generalBg " + monto_generalBg);
					Logger.debug("a.getTotal() " + a.getTotal());

					if (monto_generalBg.compareTo(BigDecimal.ZERO) > 0) {
						if (monto_generalBg.compareTo(a.getTotal()) >= 0) {// si el monto ingresado es mayor o igual al
																			// acta
							montoACargar = a.getTotal().setScale(2, RoundingMode.HALF_UP);
							if (altmp != null) {
								autoLineaId = altmp.id;
								altmp.monto = altmp.monto.add(montoACargar);
								altmp.save();
							} else {
								AutorizadoLinea al = new AutorizadoLinea();
								// al.acta_recepcion_id = new Long(a.id);
								al.autorizado_id = atId;
								// al.orden_provision_id = actaz.orden_provision_id.longValue();
								al.orden_id = cc.orden_id;
								al.expediente_id = cc.orden.expediente_id;
								al.proveedor_id = cc.orden.proveedor_id;
								al.monto = montoACargar;
								al.cot_dolar = autorizado.cot_dolar;
								al.create_date = new Date();
								al.create_usuario_id = new Long(Usuario.getUsuarioSesion());
								al.save();

								autoLineaId = al.id;
							}

							monto_generalBg = monto_generalBg.subtract(a.getTotal());

						} else {// si el monto ingresado es menor al acta

							montoACargar = monto_generalBg.setScale(2, RoundingMode.HALF_UP);
							if (altmp != null) {
								autoLineaId = altmp.id;
								altmp.monto = altmp.monto.add(montoACargar);
								altmp.save();
							} else {
								AutorizadoLinea al = new AutorizadoLinea();
								// al.acta_recepcion_id = new Long(a.id);
								al.autorizado_id = atId;
								// al.orden_provision_id = actaz.orden_provision_id.longValue();
								al.orden_id = cc.orden_id;
								al.expediente_id = cc.orden.expediente_id;
								al.proveedor_id = cc.orden.proveedor_id;
								al.monto = montoACargar;
								al.cot_dolar = autorizado.cot_dolar;
								al.create_date = new Date();
								al.create_usuario_id = new Long(Usuario.getUsuarioSesion());
								al.save();
								autoLineaId = al.id;
							}

							monto_generalBg = monto_generalBg.subtract(monto_generalBg);
						}

						String sqlActaMonto = "SELECT COALESCE(SUM(monto),0) monto,certificacion_compra_id FROM autorizado_linea_actas "
								+
								"WHERE certificacion_compra_id = :certificacion_compra_id " +
								"GROUP BY certificacion_compra_id";

						SqlRow sa = Ebean.createSqlQuery(sqlActaMonto)
								.setParameter("certificacion_compra_id", certificacion_id).findUnique();

						BigDecimal montoActaAutorizado = new BigDecimal(0);

						if (sa != null) {
							montoActaAutorizado = sa.getBigDecimal("monto");

						}
						Logger.debug("444444444444444 " + montoActaAutorizado);

						if (montoActaAutorizado.add(montoACargar)
								.compareTo(cc.getTotal().setScale(2, RoundingMode.HALF_UP)) > 0) {
							errorMontoActasAutorizado = true;

						} else {
							AutorizadoLineaActa ala = new AutorizadoLineaActa();
							ala.certificacion_compra_id = certificacion_id;
							ala.monto = montoACargar;
							ala.autorizado_linea_id = autoLineaId;
							ala.create_date = new Date();
							ala.create_usuario_id = new Long(Usuario.getUsuarioSesion());
							ala.save();
						}

					} else {
						restJs.put("success", true);
						nodo.add(restJs);
					}
				} catch (Exception e) {
					errorMontoActasAutorizado = true;
					Logger.debug("xxxxxxxxxxxxxx " + e);
				} finally {
					Ebean.endTransaction();
				}
			}

			if (errorMontoActasAutorizado) {
				Ebean.rollbackTransaction();
				restJs.put("success", false);
				restJs.put("errorGeneral", "Monto Ingresado y Autorizado supera el monto del Acta.");
				nodo.add(restJs);
			} else {
				Ebean.commitTransaction();
				InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
				InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
			}
			Ebean.endTransaction();

		} else if (ids != null) {
			Logger.debug("222222222222222222222222222222222222222222");
			BigDecimal montosTotalACargar = new BigDecimal(0);

			for (String cf : ids) {
				// CONTROLO QUE SI SE PUSO UN MONTO EN ALGUN INPUT DE UNA LINEA NO SEA MAYOR AL
				// TOTAL DE LA LINEA
				Logger.debug("id " + cf);
				Logger.debug("monto_total " + monto_totalesStr[i]);
				Logger.debug("monto " + montosStr[i]);

				montosStr[i] = (montosStr[i].trim().length() > 0) ? montosStr[i].trim().replace(",", ".") : "0";
				monto_totalesStr[i] = (monto_totalesStr[i].trim().length() > 0)
						? monto_totalesStr[i].trim().replace(",", ".")
						: "0";

				BigDecimal monto_totales = new BigDecimal(monto_totalesStr[i]).setScale(2, RoundingMode.HALF_UP);
				BigDecimal montos = new BigDecimal(montosStr[i]).setScale(2, RoundingMode.HALF_UP);

				Logger.debug("monto_total " + monto_totales);
				Logger.debug("monto " + montos);
				Logger.debug("dddddd " + montos.compareTo(monto_totales));

				if (montos.compareTo(BigDecimal.ZERO) != 0) {
					if (montos.compareTo(BigDecimal.ZERO) != 0 && (montos.compareTo(monto_totales) > 0)) {
						errores.put(cf, "El monto debe ser menor al disponible en el Acta.");
					}
					montosTotalACargar = montosTotalACargar.add(montos);
				} else {
					montosTotalACargar = montosTotalACargar.add(monto_totales);
				}

				i++;
			}

			if (errores.size() > 0) {
				restJs.put("success", false);
				restJs.put("errores", errores);
				nodo.add(restJs);
				return ok(restJs);
			} else if (montosTotalACargar.compareTo(restoAutorizar) > 0) {
				restJs.put("success", false);
				restJs.put("errorGeneral",
						"El monto a autorizar supera el valor de la orden con lo ya autorizado. Monto Limite de la orden "
								+ utils.NumberUtils.moneda(iep.totalOrden) + "  (VER AJUSTES)");
				nodo.add(restJs);
				return ok(restJs);
			}

			i = 0;
			boolean errorMontoActasAutorizado = false;
			Ebean.beginTransaction();
			for (String cfx : ids) {
				try {

					BigDecimal monto_totales = new BigDecimal(monto_totalesStr[i].replace(",", ".")).setScale(2,
							RoundingMode.HALF_UP);
					BigDecimal montos = new BigDecimal(montosStr[i].replace(",", ".")).setScale(2,
							RoundingMode.HALF_UP);
					BigDecimal montoACargar = (montos.compareTo(BigDecimal.ZERO) > 0) ? montos : monto_totales;

					CertificacionCompra cc = CertificacionCompra.find.where().eq("id", new Long(cfx)).findUnique();
					errorMontoActasAutorizado = cargarCertificacionCompra(cc.id, autorizado, montoACargar);
					Logger.debug("11111111111111 " + errorMontoActasAutorizado);
					/*
					 *
					 * String sqlActaMonto =
					 * "SELECT COALESCE(SUM(monto),0) monto,certificacion_compra_id FROM autorizado_linea_actas "
					 * +
					 * "WHERE certificacion_compra_id = :certificacion_compra_id " +
					 * "GROUP BY certificacion_compra_id";
					 *
					 * SqlRow sa =
					 * Ebean.createSqlQuery(sqlActaMonto).setParameter("certificacion_compra_id",cc.
					 * id).findUnique();
					 * BigDecimal montoActaAutorizado = new BigDecimal(0);
					 *
					 * if(sa !=null){
					 * montoActaAutorizado = sa.getBigDecimal("monto");
					 * }//saco el total autorizado por certificacion
					 *
					 *
					 *
					 * Long ordenId = cc.orden_id.longValue();
					 * AutorizadoLinea altmp = AutorizadoLinea.find.where()
					 * .eq("autorizado_id", atId)
					 * .eq("orden_id", ordenId)
					 * .setMaxRows(1).findUnique();
					 * Long autoLineaId = null;
					 *
					 * BigDecimal monto_totales = new BigDecimal(monto_totalesStr[i].replace(","
					 * ,".")).setScale(2, RoundingMode.HALF_UP);
					 * BigDecimal montos = new BigDecimal(montosStr[i].replace(","
					 * ,".")).setScale(2, RoundingMode.HALF_UP);
					 * BigDecimal montoACargar = (montos.compareTo(BigDecimal.ZERO) >
					 * 0)?montos:monto_totales;
					 *
					 *
					 * if(altmp != null){//acumulo el monto del total en la misma linea de
					 * autorizado_linea para no tener mas de una linea de la misma orden
					 * autoLineaId = altmp.id;
					 * altmp.monto = altmp.monto.add(montoACargar.setScale(2,
					 * RoundingMode.HALF_UP));
					 * altmp.save();
					 * }else{
					 * AutorizadoLinea al = new AutorizadoLinea();
					 * al.autorizado_id = atId;
					 * al.orden_id = ordenId;
					 * al.expediente_id = cc.orden.expediente_id;
					 * al.proveedor_id = cc.orden.proveedor_id;
					 * al.monto = montoACargar.setScale(2, RoundingMode.HALF_UP);
					 * al.cot_dolar = autorizado.cot_dolar;
					 * al.create_date = new Date();
					 * al.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					 * al.save();
					 * autoLineaId = al.id;
					 * }
					 *
					 * Logger.debug(
					 * "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz---------------------------------"
					 * );
					 * Logger.debug("montoActaAutorizado: "+montoActaAutorizado);
					 * Logger.debug("montoACargar: "+montoACargar);
					 * Logger.debug("montoActaAutorizado.add(montoACargar): "+montoActaAutorizado.
					 * add(montoACargar));
					 * Logger.debug("acta.getTotal(): "+cc.getTotal().setScale(2,
					 * RoundingMode.HALF_UP));
					 *
					 *
					 * if(montoActaAutorizado.add(montoACargar).compareTo(cc.getTotal().setScale(2,
					 * RoundingMode.HALF_UP)) > 0){
					 * errorMontoActasAutorizado = true;
					 * }else{
					 * AutorizadoLineaActa ala = new AutorizadoLineaActa();
					 * ala.certificacion_compra_id = cc.id;
					 * ala.monto = montoACargar;
					 * ala.autorizado_linea_id = autoLineaId;
					 * ala.create_date = new Date();
					 * ala.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					 * ala.save();
					 *
					 * }
					 */

					i++;
				} catch (Exception e) {
					errorMontoActasAutorizado = true;
					Logger.debug("22222222222 " + errorMontoActasAutorizado);
				} finally {
					//Ebean.endTransaction();
				}
			}
			Logger.debug("xxxxxxxx1111111 " + errorMontoActasAutorizado);
			if (errorMontoActasAutorizado) {
				Ebean.rollbackTransaction();
				restJs.put("errorGeneral", "Monto Ingresado y Autorizado supera el monto del Acta.");
				nodo.add(restJs);
				return ok(restJs);
			} else {
				Logger.debug("xxxxxxxxxxxxx222222 ") ;
				Ebean.commitTransaction();
				InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
				InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
			}
			Ebean.endTransaction();
		} else {
			Logger.debug("33333333333333333333333333333333333333");
		}

		restJs.put("success", true);
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result cargarLineasAutorizados() {
		ObjectNode obj = Json.newObject();
		ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		ObjectNode errores = Json.newObject();

		Logger.debug("xxxxxxxxxxx " + request().body().asFormUrlEncoded());
		// try{
		String[] profeStr = request().body().asFormUrlEncoded().get("profe");
		String[] tipoCuentaIdStr = request().body().asFormUrlEncoded().get("tipo_cuenta_id");
		String[] monto_general = request().body().asFormUrlEncoded().get("monto_general");
		String[] monto_t = request().body().asFormUrlEncoded().get("monto_t");
		// String[] monto_deuda_limite =
		// request().body().asFormUrlEncoded().get("monto_deuda_limite");
		// ------------------------------------------
		String[] idAutorizado = request().body().asFormUrlEncoded().get("idAutorizado");
		String[] idOp = request().body().asFormUrlEncoded().get("idOp");
		String[] idOrdenCompra = request().body().asFormUrlEncoded().get("idOrdenCompra");
		String[] ids = request().body().asFormUrlEncoded().get("id[]");
		// ---------------------------------------------
		String[] montosStr = request().body().asFormUrlEncoded().get("monto[]");
		String[] monto_totalesStr = request().body().asFormUrlEncoded().get("monto_total[]");
		String[] monto_deudaStr = request().body().asFormUrlEncoded().get("monto_deuda[]");
		String[] monto_deuda_limiteStr = request().body().asFormUrlEncoded().get("monto_deuda_limite[]");
		String[] tiene_actas = request().body().asFormUrlEncoded().get("tiene_actas");

		int i = 0;

		if (ids == null && (monto_general == null || monto_general[0].isEmpty())) {
			restJs.put("success", false);
			restJs.put("errorGeneral", "Debe ingresar un monto general o seleccionar algun acta.");
			nodo.add(restJs);
			return ok(restJs);
		}

		Long atId = new Long(idAutorizado[0]);
		Boolean profe = new Boolean(profeStr[0]);
		Long tipoCuentaId = new Long(tipoCuentaIdStr[0]);
		// List<AutorizadoLinea> alx =
		// AutorizadoLinea.find.where().eq("autorizado_id",atId).ne("orden.profe",
		// profe).findList();
		List<AutorizadoLinea> alx = AutorizadoLinea.find.where().eq("autorizado_id", atId)
				.ne("orden.tipo_cuenta_id", tipoCuentaId).findList();

		if (alx.size() > 0) {
			restJs.put("success", false);
			restJs.put("errorGeneral",
					"Ya existen cuentas con otra cuenta cargada.No puede cargar otra linea con distinta cuenta.");
			nodo.add(restJs);
			return ok(restJs);
		}

		Autorizado autorizado = Autorizado.find.byId(atId);
		Long ordenId = new Long(idOrdenCompra[0]);
		// InformeEstadisticoDeudaProveedores iep =
		// InformeEstadisticoDeudaProveedores.find.where().eq("orden_id",
		// ordenId).findUnique();
		InformeDeudaProveedoresMaterializada iep = InformeDeudaProveedoresMaterializada.find.where()
				.eq("orden_id", ordenId).findUnique();

		if (monto_general != null && monto_general[0] != null && !monto_general[0].isEmpty()) {
			BigDecimal monto_generalBg = new BigDecimal(monto_general[0].replace(",", ".")).setScale(2,
					RoundingMode.HALF_UP);
			BigDecimal restoAutorizar = iep.getRestoAAutorizar();

			if (monto_generalBg.compareTo(iep.totalDeuda.setScale(2, RoundingMode.HALF_UP)) > 0) {

				Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz---------------------------------");
				Logger.debug("monto_generalBg: " + monto_generalBg);
				Logger.debug("iep.totalDeuda.setScale(2, RoundingMode.HALF_DOWN): "
						+ iep.totalDeuda.setScale(2, RoundingMode.HALF_UP));
				Logger.debug("monto_generalBg.compareTo(iep.totalDeuda.setScale(2, RoundingMode.HALF_DOWN): "
						+ monto_generalBg.compareTo(iep.totalDeuda.setScale(2, RoundingMode.HALF_DOWN)));

				restJs.put("success", false);
				restJs.put("errorEnMontoTotal", "El monto no debe ser superior al resto a autorizar.");
				nodo.add(restJs);
				return ok(restJs);
			} else if (monto_generalBg.compareTo(restoAutorizar) > 0) {

				Logger.debug("monto_generalBg: " + monto_generalBg);
				Logger.debug("restoAutorizar: " + restoAutorizar);
				Logger.debug("monto_generalBg.compareTo(restoAutorizar): " + monto_generalBg.compareTo(restoAutorizar));
				restJs.put("success", false);
				restJs.put("errorEnMontoTotal",
						"El monto a autorizar supera el valor de la orden con lo ya autorizado. Monto Limite de la orden "
								+ utils.NumberUtils.moneda(iep.totalOrden) + "  (VER AJUSTES)");
				nodo.add(restJs);
				return ok(restJs);
			}

		}

		if (tiene_actas == null && idOrdenCompra != null && monto_general != null && monto_general[0] != null
				&& !monto_general[0].isEmpty()) {
			// CARGA MODAL DE ORDENES Y NO TIENE ACTAS SELECCIONADAS
			Logger.debug("1111111111111111111111111111111111");
			BigDecimal monto_generalBg = new BigDecimal(monto_general[0].replace(",", ".")).setScale(2,
					RoundingMode.HALF_UP);
			Orden o = Orden.find.byId(ordenId);
			AutorizadoLinea altmp = AutorizadoLinea.find.where().eq("autorizado_id", atId).eq("orden_id", ordenId)
					.findUnique();

			if (altmp != null) {
				altmp.monto = altmp.monto.add(monto_generalBg);
				altmp.save();
			} else {
				AutorizadoLinea al = new AutorizadoLinea();
				// al.acta_recepcion_id = new Long(a.id);
				al.autorizado_id = atId;
				al.orden_provision_id = (o.ordenProvision != null && o.ordenProvision.size() > 0)
						? o.ordenProvision.get(0).id.longValue()
						: null;
				al.orden_id = ordenId;
				al.expediente_id = o.expediente_id;
				al.proveedor_id = o.proveedor_id;
				al.monto = monto_generalBg;
				al.cot_dolar = autorizado.cot_dolar;
				al.create_date = new Date();
				al.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				al.save();

			}
			InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
			InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();

		} else if (tiene_actas != null && monto_general != null && monto_general[0] != null
				&& !monto_general[0].isEmpty()) {
			// CARGA MODAL DE ORDENES Y TIENE ACTAS RECORRES LAS ACTAS Y LAS CARGA
			Logger.debug("222222222222222222222222222222222222");
			Long ordenProvisionId = new Long(idOp[0]);
			BigDecimal monto_generalBg = new BigDecimal(monto_general[0].replace(",", ".")).setScale(2,
					RoundingMode.HALF_UP);
			List<ActaRecepcion> listaActas = ActaRecepcion.getListaActasDeudas(ordenProvisionId, null);

			BigDecimal montoTmp = new BigDecimal(0);
			boolean errorMontoActasAutorizado = false;

			Ebean.beginTransaction();
			for (ActaRecepcion a : listaActas) {
				Logger.debug("22222222222222222222222222222222222233333333 ");
				try {
					ActaRecepcion actaz = ActaRecepcion.find
							.fetch("ordenProvision")
							.fetch("ordenProvision.ordenCompra")
							.where().eq("id", a.id).findUnique();

					ordenId = actaz.ordenProvision.orden_compra_id.longValue();

					Long acta_recepcion_id = a.id;
					AutorizadoLinea altmp = AutorizadoLinea.find.where().eq("autorizado_id", atId)
							.eq("orden_id", ordenId).setMaxRows(1).findUnique();
					Long autoLineaId = null;
					BigDecimal montoACargar = new BigDecimal(0);

					if (monto_generalBg.compareTo(BigDecimal.ZERO) > 0) {

						if (monto_generalBg.compareTo(a.getTotal()) >= 0) {// si el monto ingresado es mayor o igual al
																			// acta

							montoACargar = a.getTotal().setScale(2, RoundingMode.HALF_UP);
							if (altmp != null) {
								autoLineaId = altmp.id;
								altmp.monto = altmp.monto.add(montoACargar);
								altmp.save();
							} else {
								AutorizadoLinea al = new AutorizadoLinea();
								// al.acta_recepcion_id = new Long(a.id);
								al.autorizado_id = atId;
								al.orden_provision_id = actaz.orden_provision_id.longValue();
								al.orden_id = ordenId;
								al.expediente_id = actaz.ordenProvision.ordenCompra.expediente_id;
								al.proveedor_id = actaz.ordenProvision.ordenCompra.proveedor_id;
								al.monto = montoACargar;
								al.cot_dolar = autorizado.cot_dolar;
								al.create_date = new Date();
								al.create_usuario_id = new Long(Usuario.getUsuarioSesion());
								al.save();

								autoLineaId = al.id;
							}

							monto_generalBg = monto_generalBg.subtract(a.getTotal());

						} else {// si el monto ingresado es menor al acta

							montoACargar = monto_generalBg.setScale(2, RoundingMode.HALF_UP);
							if (altmp != null) {
								autoLineaId = altmp.id;
								altmp.monto = altmp.monto.add(montoACargar);
								altmp.save();
							} else {
								AutorizadoLinea al = new AutorizadoLinea();
								// al.acta_recepcion_id = new Long(a.id);
								al.autorizado_id = atId;
								al.orden_provision_id = actaz.orden_provision_id.longValue();
								al.orden_id = ordenId;
								al.expediente_id = actaz.ordenProvision.ordenCompra.expediente_id;
								al.proveedor_id = actaz.ordenProvision.ordenCompra.proveedor_id;
								al.monto = montoACargar;
								al.cot_dolar = autorizado.cot_dolar;
								al.create_date = new Date();
								al.create_usuario_id = new Long(Usuario.getUsuarioSesion());
								al.save();
								autoLineaId = al.id;
							}

							monto_generalBg = monto_generalBg.subtract(monto_generalBg);
						}

						String sqlActaMonto = "SELECT COALESCE(SUM(monto),0) monto,acta_recepcion_id FROM autorizado_linea_actas "
								+
								"WHERE acta_recepcion_id = :acta_recepcion_id " +
								"GROUP BY acta_recepcion_id";

						SqlRow sa = Ebean.createSqlQuery(sqlActaMonto)
								.setParameter("acta_recepcion_id", acta_recepcion_id).findUnique();

						BigDecimal montoActaAutorizado = new BigDecimal(0);

						if (sa != null) {
							montoActaAutorizado = sa.getBigDecimal("monto");
						}

						Logger.debug("montoActaAutorizado.add(montoACargar) " + montoActaAutorizado.add(montoACargar));
						Logger.debug("a.getTotal().setScale(2, RoundingMode.HALF_UP) "
								+ a.getTotal().setScale(2, RoundingMode.HALF_UP));
						Logger.debug(
								"montoActaAutorizado.add(montoACargar).compareTo(actaz.getTotal().setScale(2, RoundingMode.HALF_UP) "
										+ montoActaAutorizado.add(montoACargar)
												.compareTo(actaz.getTotal().setScale(2, RoundingMode.HALF_UP)));

						if (montoACargar.compareTo(a.getTotal().setScale(2, RoundingMode.HALF_UP)) > 0) {
							errorMontoActasAutorizado = true;
							Logger.debug(
									"montoActaAutorizado.add(montoACargar) " + montoActaAutorizado.add(montoACargar));
							Logger.debug("a.getTotal().setScale(2, RoundingMode.HALF_UP) "
									+ a.getTotal().setScale(2, RoundingMode.HALF_UP));
							Logger.debug(
									"montoActaAutorizado.add(montoACargar).compareTo(actaz.getTotal().setScale(2, RoundingMode.HALF_UP) "
											+ montoActaAutorizado.add(montoACargar)
													.compareTo(actaz.getTotal().setScale(2, RoundingMode.HALF_UP)));
						} else {
							AutorizadoLineaActa ala = new AutorizadoLineaActa();
							ala.acta_recepcion_id = acta_recepcion_id;
							ala.monto = montoACargar;
							ala.autorizado_linea_id = autoLineaId;
							ala.create_date = new Date();
							ala.create_usuario_id = new Long(Usuario.getUsuarioSesion());
							ala.save();
						}

					} else {
						restJs.put("success", true);
						nodo.add(restJs);
					}
				} catch (Exception e) {
					Logger.debug("222222222222222222222222222222222222 " + e);
					errorMontoActasAutorizado = true;
				}
			}

			if (errorMontoActasAutorizado) {
				Ebean.rollbackTransaction();
				restJs.put("success", false);
				restJs.put("errorGeneral", "Monto Ingresado y Autorizado supera el monto del Acta.");
				nodo.add(restJs);
				return ok(restJs);
			} else {
				Ebean.commitTransaction();
				InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
				InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
			}
			Ebean.endTransaction();

		} else if (ids != null) {
			// CARGA MODAL DE ACTAS
			Logger.debug("33333333333333333333333333333");
			BigDecimal montosTotalACargar = new BigDecimal(0);
			BigDecimal restoAutorizar = iep.getRestoAAutorizar();

			for (String cf : ids) {
				Logger.debug("id " + cf);
				Logger.debug("monto_total " + monto_totalesStr[i]);
				Logger.debug("monto " + montosStr[i]);

				montosStr[i] = (montosStr[i].trim().length() > 0) ? montosStr[i].trim().replace(",", ".") : "0";// INPUT
				monto_totalesStr[i] = (monto_totalesStr[i].trim().length() > 0)
						? monto_totalesStr[i].trim().replace(",", ".")
						: "0";// TOTAL CARGADO
				monto_deudaStr[i] = (monto_deudaStr[i].trim().length() > 0) ? monto_deudaStr[i].trim().replace(",", ".")
						: "0";// LO MISMO Q TOTAL

				if (monto_deuda_limiteStr != null) {
					monto_deuda_limiteStr[i] = (monto_deuda_limiteStr[i].trim().length() > 0)
							? monto_deuda_limiteStr[i].trim().replace(",", ".")
							: "0";// LO MISMO Q TOTAL
				}

				BigDecimal monto_totales = new BigDecimal(monto_totalesStr[i]).setScale(2, RoundingMode.HALF_UP);
				BigDecimal monto_deuda = new BigDecimal(monto_deudaStr[i]).setScale(2, RoundingMode.HALF_UP);
				BigDecimal montos = new BigDecimal(montosStr[i]).setScale(2, RoundingMode.HALF_UP);
				BigDecimal monto_deuda_limite = monto_deuda;

				if (monto_deuda_limiteStr != null) {
					monto_totales = new BigDecimal(monto_deuda_limiteStr[i]).setScale(2, RoundingMode.HALF_UP);
					// monto_deuda = new BigDecimal(monto_deudaStr[i]).setScale(2,
					// RoundingMode.HALF_UP);
					// montos = new BigDecimal(montosStr[i]).setScale(2, RoundingMode.HALF_UP);
					monto_deuda_limite = new BigDecimal(monto_deuda_limiteStr[i]).setScale(2, RoundingMode.HALF_UP);
				}

				Logger.debug("monto_total " + monto_totales);
				Logger.debug("monto " + montos);
				Logger.debug("montos.compareTo(monto_totales) " + montos.compareTo(monto_totales));
				Logger.debug("monto_deuda " + monto_deuda);
				Logger.debug("monto_deuda_limite " + monto_deuda_limite);
				Logger.debug("montos.compareTo(monto_deuda) " + montos.compareTo(monto_deuda));

				if (montos.compareTo(BigDecimal.ZERO) != 0) {
					if (montos.compareTo(BigDecimal.ZERO) != 0 && (montos.compareTo(monto_deuda) > 0)) {
						errores.put(cf, "El monto debe ser menor al disponible en el Acta.");
					}
					if (montos.compareTo(BigDecimal.ZERO) != 0 && (montos.compareTo(monto_deuda_limite) > 0)) {
						errores.put(cf, "El monto debe ser menor ala DEUDA LIMITE en el Acta.");
					}
					montosTotalACargar = montosTotalACargar.add(montos);
				} else {
					montosTotalACargar = montosTotalACargar.add(monto_totales);
				}

				i++;
			}

			Logger.debug("3333333333333333333-------------------------------");
			Logger.debug("restoAutorizar: " + restoAutorizar);
			Logger.debug("montosTotalACargar: " + montosTotalACargar);

			if (errores.size() > 0) {
				restJs.put("success", false);
				restJs.put("errores", errores);
				nodo.add(restJs);
				return ok(restJs);
			} else if (montosTotalACargar.compareTo(restoAutorizar) > 0) {
				restJs.put("success", false);
				restJs.put("errorGeneral",
						"El monto a autorizar supera el valor de la orden con lo ya autorizado. Monto Limite de la orden "
								+ utils.NumberUtils.moneda(iep.totalOrden) + "  (VER AJUSTES)");
				nodo.add(restJs);
				return ok(restJs);
			} else if (montosTotalACargar.compareTo(BigDecimal.ZERO) <= 0) {
				restJs.put("success", false);
				restJs.put("errorGeneral", "El monto a autorizar debe ser mayor a 0.");
				nodo.add(restJs);
				return ok(restJs);
			}

			i = 0;
			boolean errorMontoActasAutorizado = false;
			Ebean.beginTransaction();
			for (String cfx : ids) {
				try {
					///////////////////////////////////
					ActaRecepcion acta = ActaRecepcion.find
							.fetch("ordenProvision")
							.fetch("ordenProvision.ordenCompra")
							.where().eq("id", new Long(cfx)).findUnique();

					String sqlActaMonto = "SELECT COALESCE(SUM(monto),0) monto,acta_recepcion_id FROM autorizado_linea_actas "
							+
							"WHERE acta_recepcion_id = :acta_recepcion_id " +
							"GROUP BY acta_recepcion_id";

					SqlRow sa = Ebean.createSqlQuery(sqlActaMonto).setParameter("acta_recepcion_id", acta.id)
							.findUnique();

					BigDecimal montoActaAutorizado = new BigDecimal(0);

					if (sa != null) {
						montoActaAutorizado = sa.getBigDecimal("monto");
					}

					ordenId = acta.ordenProvision.orden_compra_id.longValue();
					// Long atId = new Long(idAutorizado[0]);
					Long acta_recepcion_id = new Long(cfx);
					AutorizadoLinea altmp = AutorizadoLinea.find.where().eq("autorizado_id", atId)
							.eq("orden_id", ordenId).setMaxRows(1).findUnique();
					Long autoLineaId = null;

					BigDecimal monto_totales = new BigDecimal(monto_totalesStr[i].replace(",", ".")).setScale(2,
							RoundingMode.HALF_UP);
					if (monto_deuda_limiteStr != null) {// si tiene monto limite le cargo el monto limite
						monto_totales = new BigDecimal(monto_deuda_limiteStr[i]).setScale(2, RoundingMode.HALF_UP);
					}

					BigDecimal montos = new BigDecimal(montosStr[i].replace(",", ".")).setScale(2,
							RoundingMode.HALF_UP);// cuadrito q carga el monto a mano
					BigDecimal montoACargar = (montos.compareTo(BigDecimal.ZERO) > 0) ? montos : monto_totales;
					BigDecimal monto_deuda = new BigDecimal(monto_deudaStr[i]).setScale(2, RoundingMode.HALF_UP);// el
																													// monto
																													// de
																													// la
																													// deuda

					if (altmp != null) {
						autoLineaId = altmp.id;
						altmp.monto = altmp.monto.add(montoACargar.setScale(2, RoundingMode.HALF_UP));
						altmp.save();
					} else {
						AutorizadoLinea al = new AutorizadoLinea();
						// al.acta_recepcion_id = new Long(cfx);
						al.autorizado_id = atId;
						al.orden_provision_id = acta.orden_provision_id.longValue();
						al.orden_id = ordenId;
						al.expediente_id = acta.ordenProvision.ordenCompra.expediente_id;
						al.proveedor_id = acta.ordenProvision.ordenCompra.proveedor_id;
						al.monto = montoACargar.setScale(2, RoundingMode.HALF_UP);
						al.cot_dolar = autorizado.cot_dolar;
						al.create_date = new Date();
						al.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						al.save();
						autoLineaId = al.id;
					}

					Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz---------------------------------");
					Logger.debug("montoActaAutorizado: " + montoActaAutorizado);
					Logger.debug("montoACargar: " + montoACargar);
					Logger.debug("montoActaAutorizado.add(montoACargar): " + montoActaAutorizado.add(montoACargar));
					Logger.debug("acta.getTotal(): " + acta.getTotal().setScale(2, RoundingMode.HALF_UP));
					Logger.debug("monto_deuda: " + monto_deuda.setScale(2, RoundingMode.HALF_UP));
					Logger.debug(
							"montoActaAutorizado.add(montoACargar).compareTo(monto_deuda.setScale(2, RoundingMode.HALF_UP)): "
									+ montoActaAutorizado.add(montoACargar)
											.compareTo(monto_deuda.setScale(2, RoundingMode.HALF_UP)));

					// if(montoActaAutorizado.add(montoACargar).compareTo(acta.getTotal().setScale(2,
					// RoundingMode.HALF_UP)) > 0){
					if (montoACargar.compareTo(monto_deuda.setScale(2, RoundingMode.HALF_UP)) > 0) {// controlo q el
																									// monto a cargar
																									// nosea mayor a la
																									// deuda
						Logger.debug("errorMontoActasAutorizado ENTRA");
						errorMontoActasAutorizado = true;
					} else {
						AutorizadoLineaActa ala = new AutorizadoLineaActa();
						ala.acta_recepcion_id = acta_recepcion_id;
						ala.monto = montoACargar;
						ala.autorizado_linea_id = autoLineaId;
						ala.create_date = new Date();
						ala.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						ala.save();

					} ///////////////////////////////////////

					i++;
				} catch (Exception e) {
					errorMontoActasAutorizado = true;
				}
			}

			if (errorMontoActasAutorizado) {
				Ebean.rollbackTransaction();
				restJs.put("errorGeneral", "Monto Ingresado y Autorizado supera el monto del Acta.");
				nodo.add(restJs);
				return ok(restJs);
			} else {
				Ebean.commitTransaction();
				InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
				InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();

			}
			Ebean.endTransaction();
		}

		restJs.put("success", true);
		nodo.add(restJs);
		return ok(restJs);

	}

	public static Result cargarLineasAutorizadosMasivamente() throws Exception {
		ObjectNode obj = Json.newObject();
		ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		ObjectNode errores = Json.newObject();
		boolean errorMontoActasAutorizado = false;

		if (request().body().asFormUrlEncoded().get("check_listado_informe_acta[]") == null) {
			restJs.put("success", false);
			restJs.put("error", true);
			restJs.put("errorTexto", "Debe seleccionar una linea.");
			nodo.add(restJs);
			return ok(restJs);
		}

		String[] idAutorizado = request().body().asFormUrlEncoded().get("idAutorizado");
		String[] ids = request().body().asFormUrlEncoded().get("check_listado_informe_acta[]");
		Autorizado autorizado = Autorizado.find.byId(new Long(idAutorizado[0]));

		ArrayList<Long> idTempCC = new ArrayList<Long>();
		ArrayList<Long> idTempAC = new ArrayList<Long>();
		// ArrayList<Long> idTempANT = new ArrayList<Long>();
		for (String id : ids) {
			if (id.contains("CC")) {
				idTempCC.add(new Long(id.replace("CC", "")));
			} else if (id.contains("AC")) {
				idTempAC.add(new Long(id.replace("AC", "")));
			} else if (id.contains("ANT")) {

			}
		}

		List<SqlRow> sControlCCCuentas = new ArrayList<SqlRow>();
		List<SqlRow> sControlACCuentas = new ArrayList<SqlRow>();

		if (idTempCC.size() > 0) {
			String controlCCCuentas = "SELECT tipo_cuenta_id FROM certificaciones_compras " +
					"WHERE id in( :certificacion_compra_listid) " +
					"GROUP BY tipo_cuenta_id";

			sControlCCCuentas = Ebean.createSqlQuery(controlCCCuentas)
					.setParameter("certificacion_compra_listid", idTempCC).findList();
		}

		if (idTempAC.size() > 0) {
			String controlACCuentas = "SELECT o.tipo_cuenta_id FROM actas_recepcion ac " +
					"inner join ordenes_provision op on ac.orden_provision_id = op.id " +
					"inner join ordenes o on o.id = op.orden_compra_id " +
					"where ac.id in(:actaList) " +
					"GROUP BY o.tipo_cuenta_id";

			sControlACCuentas = Ebean.createSqlQuery(controlACCuentas).setParameter("actaList", idTempAC).findList();
		}

		boolean errorCuentas = false;

		if (sControlCCCuentas.size() > 1 || sControlACCuentas.size() > 1) {
			errorCuentas = true;
		} else {
			if (sControlCCCuentas.size() > 0 && sControlACCuentas.size() > 0) {
				if (sControlCCCuentas.get(0).getInteger("tipo_cuenta_id")
						.compareTo(sControlACCuentas.get(0).getInteger("tipo_cuenta_id")) != 0) {
					errorCuentas = true;
				}
			}
		}

		if (errorCuentas) {
			restJs.put("success", false);
			restJs.put("error", true);
			restJs.put("errorTexto", "Debe seleccionar un solo tipo de cuenta.");
			nodo.add(restJs);
			return ok(restJs);
		}

		Integer idCuentaACargar = (sControlCCCuentas.size() > 0) ? sControlCCCuentas.get(0).getInteger("tipo_cuenta_id")
				: (sControlACCuentas.size() > 0) ? sControlACCuentas.get(0).getInteger("tipo_cuenta_id") : null;
		if (idCuentaACargar != null) {
			String controlCuentasCargadas = "SELECT o.tipo_cuenta_id FROM autorizado_lineas a " +
					"INNER JOIN ordenes o ON o.id = a.orden_id " +
					"WHERE autorizado_id = :autorizado_id AND o.tipo_cuenta_id <> :tc " +
					"GROUP BY o.tipo_cuenta_id";

			List<SqlRow> sControlCuentasCargadas = Ebean.createSqlQuery(controlCuentasCargadas)
					.setParameter("autorizado_id", autorizado.id)
					.setParameter("tc", idCuentaACargar)
					.findList();
			if (sControlCuentasCargadas.size() > 0) {
				restJs.put("success", false);
				restJs.put("error", true);
				restJs.put("errorTexto", "Ya existen lineas cargadas con otro Tipo de Cuenta");
				nodo.add(restJs);
				return ok(restJs);
			}
		}

		Ebean.beginTransaction();
		for (String id : ids) {
			Logger.debug("xxxxxxxxxxxxx " + id);

			if (id.contains("CC")) {
				Long idCertificacion = new Long(id.replace("CC", ""));
				List<CertificacionCompra> listaCertificaciones = ActaRecepcion
						.getListaCertificacionesComprasDeudas(null, idCertificacion);
				errorMontoActasAutorizado = cargarCertificacionCompra(idCertificacion, autorizado,
						listaCertificaciones.get(0).base);
			} else if (id.contains("AC")) {
				Long idActa = new Long(id.replace("AC", ""));
				// InformeDeudaPorActa ida = InformeDeudaPorActa.find.where().eq("id",
				// idActa).findUnique();
				InformeDeudaPorActaMaterializada ida = InformeDeudaPorActaMaterializada.find.where().eq("id", idActa)
						.findUnique();
				errorMontoActasAutorizado = cargarActa(idActa, autorizado, ida.totalDeuda, ida.totalDeuda);

			} else if (id.contains("ANT")) {

			}
		}

		if (errorMontoActasAutorizado) {
			Ebean.rollbackTransaction();
			restJs.put("error", true);
			restJs.put("errorTexto", "Monto Ingresado y Autorizado supera el monto del Acta.");
			nodo.add(restJs);
			return ok(restJs);
		} else {
			Ebean.commitTransaction();
			InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
			InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		}
		// InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		// InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		Ebean.endTransaction();

		restJs.put("success", true);
		nodo.add(restJs);
		return ok(restJs);
	}

	public static boolean cargarActa(Long idActa, Autorizado autorizado, BigDecimal monto_total,
			BigDecimal monto_total_deuda) throws Exception {

		boolean errorMontoActasAutorizado = false;

		try {
			ActaRecepcion acta = ActaRecepcion.find
					.select("id")
					.fetch("ordenProvision", "orden_compra_id")
					.fetch("ordenProvision.ordenCompra", "expediente_id,proveedor_id")
					.where().eq("id", idActa).findUnique();

			String sqlActaMonto = "SELECT COALESCE(SUM(monto),0) monto,acta_recepcion_id FROM autorizado_linea_actas " +
					"WHERE acta_recepcion_id = :acta_recepcion_id " +
					"GROUP BY acta_recepcion_id";

			SqlRow sa = Ebean.createSqlQuery(sqlActaMonto).setParameter("acta_recepcion_id", idActa).findUnique();

			BigDecimal montoActaAutorizado = new BigDecimal(0);

			if (sa != null) {
				montoActaAutorizado = sa.getBigDecimal("monto");
			}

			Long ordenId = acta.ordenProvision.orden_compra_id.longValue();
			AutorizadoLinea altmp = AutorizadoLinea.find.where().eq("autorizado_id", autorizado.id)
					.eq("orden_id", ordenId).setMaxRows(1).findUnique();
			Long autoLineaId = null;

			/*
			 * BigDecimal monto_totales = new BigDecimal(monto_totalesStr[i].replace(","
			 * ,".")).setScale(2, RoundingMode.HALF_UP);
			 * if(monto_deuda_limiteStr != null) {
			 * monto_totales = new BigDecimal(monto_deuda_limiteStr[i]).setScale(2,
			 * RoundingMode.HALF_UP);
			 * }
			 *
			 * BigDecimal montos = new BigDecimal(montosStr[i].replace(","
			 * ,".")).setScale(2, RoundingMode.HALF_UP);
			 * BigDecimal montoACargar = (montos.compareTo(BigDecimal.ZERO) >
			 * 0)?montos:monto_totales;
			 * BigDecimal monto_deuda = new BigDecimal(monto_deudaStr[i]).setScale(2,
			 * RoundingMode.HALF_UP);
			 */

			BigDecimal montoACargar = monto_total;
			BigDecimal monto_deuda = monto_total_deuda;

			if (altmp != null) {
				autoLineaId = altmp.id;
				altmp.monto = altmp.monto.add(montoACargar.setScale(2, RoundingMode.HALF_UP));
				altmp.save();
			} else {
				AutorizadoLinea al = new AutorizadoLinea();
				// al.acta_recepcion_id = new Long(cfx);
				al.autorizado_id = autorizado.id;
				al.orden_provision_id = acta.orden_provision_id.longValue();
				al.orden_id = ordenId;
				al.expediente_id = acta.ordenProvision.ordenCompra.expediente_id;
				al.proveedor_id = acta.ordenProvision.ordenCompra.proveedor_id;
				al.monto = montoACargar.setScale(2, RoundingMode.HALF_UP);
				al.cot_dolar = autorizado.cot_dolar;
				al.create_date = new Date();
				al.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				al.save();
				autoLineaId = al.id;
			}

			Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz---------------------------------");
			Logger.debug("montoActaAutorizado: " + montoActaAutorizado);
			Logger.debug("montoACargar: " + montoACargar);
			Logger.debug("montoActaAutorizado.add(montoACargar): " + montoActaAutorizado.add(montoACargar));
			Logger.debug("acta.getTotal(): " + acta.getTotal().setScale(2, RoundingMode.HALF_UP));
			Logger.debug("monto_deuda: " + monto_deuda.setScale(2, RoundingMode.HALF_UP));
			Logger.debug(
					"montoActaAutorizado.add(montoACargar).compareTo(monto_deuda.setScale(2, RoundingMode.HALF_UP)): "
							+ montoActaAutorizado.add(montoACargar)
									.compareTo(monto_deuda.setScale(2, RoundingMode.HALF_UP)));

			// if(montoActaAutorizado.add(montoACargar).compareTo(acta.getTotal().setScale(2,
			// RoundingMode.HALF_UP)) > 0){
			if (montoACargar.compareTo(monto_deuda.setScale(2, RoundingMode.HALF_UP)) > 0) {
				Logger.debug("errorMontoActasAutorizado ENTRA");
				errorMontoActasAutorizado = true;
			} else {
				AutorizadoLineaActa ala = new AutorizadoLineaActa();
				ala.acta_recepcion_id = idActa;
				ala.monto = montoACargar;
				ala.autorizado_linea_id = autoLineaId;
				ala.create_date = new Date();
				ala.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				ala.save();

			}
		} catch (Exception e) {
			errorMontoActasAutorizado = true;
		}

		return errorMontoActasAutorizado;

	}

	public static boolean cargarCertificacionCompra(Long idCertificacion, Autorizado autorizado, BigDecimal monto_total)
			throws Exception {

		boolean errorMontoActasAutorizado = false;

		try {

			CertificacionCompra cc = CertificacionCompra.find.where().eq("id", idCertificacion).findUnique();

			String sqlActaMonto = "SELECT COALESCE(SUM(monto),0) monto,certificacion_compra_id FROM autorizado_linea_actas "
					+
					"WHERE certificacion_compra_id = :certificacion_compra_id " +
					"GROUP BY certificacion_compra_id";

			SqlRow sa = Ebean.createSqlQuery(sqlActaMonto).setParameter("certificacion_compra_id", cc.id).findUnique();
			BigDecimal montoActaAutorizado = new BigDecimal(0);

			if (sa != null) {
				montoActaAutorizado = sa.getBigDecimal("monto");
			} // saco el total autorizado por certificacion

			Long ordenId = cc.orden_id.longValue();
			AutorizadoLinea altmp = AutorizadoLinea.find.where()
					.eq("autorizado_id", autorizado.id)
					.eq("orden_id", ordenId)
					.setMaxRows(1).findUnique();
			Long autoLineaId = null;

			// BigDecimal monto_totales = new BigDecimal(monto_totalesStr[i].replace(","
			// ,".")).setScale(2, RoundingMode.HALF_UP);
			// BigDecimal montos = new BigDecimal(montosStr[i].replace(","
			// ,".")).setScale(2, RoundingMode.HALF_UP);
			// BigDecimal montoACargar = (montos.compareTo(BigDecimal.ZERO) >
			// 0)?montos:monto_totales;
			BigDecimal montoACargar = monto_total;

			if (altmp != null) {// acumulo el monto del total en la misma linea de autorizado_linea para no
								// tener mas de una linea de la misma orden
				autoLineaId = altmp.id;
				altmp.monto = altmp.monto.add(montoACargar.setScale(2, RoundingMode.HALF_UP));
				altmp.save();
			} else {
				AutorizadoLinea al = new AutorizadoLinea();
				al.autorizado_id = autorizado.id;
				al.orden_id = ordenId;
				al.expediente_id = cc.orden.expediente_id;
				al.proveedor_id = cc.orden.proveedor_id;
				al.monto = montoACargar.setScale(2, RoundingMode.HALF_UP);
				al.cot_dolar = autorizado.cot_dolar;
				al.create_date = new Date();
				al.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				al.save();
				autoLineaId = al.id;
			}

			Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz---------------------------------");
			Logger.debug("montoActaAutorizado: " + montoActaAutorizado);
			Logger.debug("montoACargar: " + montoACargar);
			Logger.debug("montoActaAutorizado.add(montoACargar): " + montoActaAutorizado.add(montoACargar));
			Logger.debug("acta.getTotal(): " + cc.getTotal().setScale(2, RoundingMode.HALF_UP));

			if (montoActaAutorizado.add(montoACargar).compareTo(cc.getTotal().setScale(2, RoundingMode.HALF_UP)) > 0) {
				errorMontoActasAutorizado = true;
			} else {
				AutorizadoLineaActa ala = new AutorizadoLineaActa();
				ala.certificacion_compra_id = cc.id;
				ala.monto = montoACargar;
				ala.autorizado_linea_id = autoLineaId;
				ala.create_date = new Date();
				ala.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				ala.save();

			}

			// i++;
		} catch (Exception e) {
			errorMontoActasAutorizado = true;
		}

		return errorMontoActasAutorizado;
	}

	public static Result reporteAutorizadoExcel(Long id) {

		String dirTemp = System.getProperty("java.io.tmpdir");

		try {
			File archivo = new File(dirTemp + "/reporte-autorizado.xls");
			if (archivo.exists())
				archivo.delete();
			FileInputStream file = new FileInputStream(
					Play.application().getFile("conf/resources/reportes/dashboard/reporte-autorizado.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;

			/*
			 * CellStyle style = libro.createCellStyle();
			 * Font defaultFont = libro.createFont();
			 * defaultFont.setFontHeightInPoints((short)8);
			 * style.setFont(defaultFont);
			 * style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));
			 */

			CellStyle comun = libro.createCellStyle();
			comun.setDataFormat((short) 10);
			comun.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			comun.setWrapText(true);
			Font font2 = libro.createFont();
			font2.setFontHeightInPoints((short) 10);
			comun.setFont(font2);

			CellStyle titulo = libro.createCellStyle();
			titulo.setDataFormat((short) 16);
			titulo.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			titulo.setWrapText(true);
			titulo.setAlignment(CellStyle.ALIGN_CENTER);
			Font font3 = libro.createFont();
			font3.setFontHeightInPoints((short) 16);
			font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titulo.setFont(font3);

			CellStyle titulo2 = libro.createCellStyle();
			titulo2.setDataFormat((short) 10);
			titulo2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			titulo2.setWrapText(true);
			titulo2.setAlignment(CellStyle.ALIGN_CENTER);
			Font font4 = libro.createFont();
			font4.setFontHeightInPoints((short) 10);
			font4.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titulo2.setFont(font4);

			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 10);
			estiloMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			estiloMoneda.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));
			estiloMoneda.setFont(font2);

			Autorizado a = Autorizado.find.byId(id);
			Logger.debug("-------" + id);
			Logger.debug("----dddd---" + a);
			List<AutorizadoLinea> lineas = AutorizadoLinea.find
					.fetch("expediente")
					.fetch("proveedor")
					.fetch("ordenProvision")
					.where().eq("autorizado_id", a.id).order("proveedor_id")
					.findList();
			String cuenta2 = "";
			String cuenta1 = "";

			if (a.tipo_cuenta_id != null) {
				cuenta2 = "CUENTA CORRIENTE EJECUTORA Y PAGADORA Nº " + a.tipoCuenta.numero + " - "
						+ a.tipoCuenta.nombre;
				cuenta1 = "CUENTA PARQUE DE LA SALUD - " + a.tipoCuenta.nombre;
			} else {
				if (a.profe) {
					cuenta2 = "CUENTA CORRIENTE EJECUTORA Y PAGADORA Nº 3-001-09408729322 - PROFE";
					cuenta1 = "CUENTA PARQUE DE LA SALUD - PROFE";
				} else {
					cuenta2 = "CUENTA CORRIENTE EJECUTORA Y PAGADORA Nº 3-001-09408769227 - OPERATIVA";
					cuenta1 = "CUENTA PARQUE DE LA SALUD - OPERATIVA";
				}
			}

			Row f = hoja.createRow(0);
			celda = f.createCell(0);
			celda.setCellValue(cuenta1);
			celda.setCellStyle(titulo);
			hoja.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

			f = hoja.createRow(8);
			celda = f.createCell(0);
			celda.setCellValue(cuenta2);
			celda.setCellStyle(titulo2);

			int x = 12;
			BigDecimal total = new BigDecimal(0);
			for (AutorizadoLinea al : lineas) {
				f = hoja.createRow(x);
				celda = f.createCell(0);
				celda.setCellValue(al.expediente.getInstitucionExpedienteEjercicio());
				celda.setCellStyle(comun);

				celda = f.createCell(1);
				celda.setCellValue(al.proveedor.nombre);
				celda.setCellStyle(comun);

				celda = f.createCell(2);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(al.getTotal().doubleValue());
				celda.setCellStyle(estiloMoneda);
				total = total.add(al.getTotal());





				String af = "";

				if (al.ordenProvision != null) {
					af += "OP " + al.ordenProvision.numero + " - ";
				}

				String p = "";
				String periodo = "";

				if (al.ordenProvision != null) {
					Long or = al.ordenProvision.ordenCompra.orden_rubro_id;
					if (al.autorizadoLineaActa != null && al.autorizadoLineaActa.size() > 0) {
						for (AutorizadoLineaActa ax : al.autorizadoLineaActa) {
							if (ax.actaRecepcion != null) {
								periodo = (ax.actaRecepcion.periodo != null)?ax.actaRecepcion.periodo.nombre:"";
								af += ax.actaRecepcion.getNombre() + " - ";
								if (or.compareTo(new Long(2)) == 0 || or.compareTo(new Long(6)) == 0) {
									Map<Integer, Map<String, String>> pacientes = ActaRecepcion.getPacientes(ax.actaRecepcion.id);
									for (Map<String, String> xd : pacientes.values()) {
										p += xd.get("nombre") + " - ";
									}

								}
							}
						}
					}
				}
				String depo = "";
				if(al.ordenProvision != null && al.ordenProvision.ordenCompra != null) {
					depo = (al.ordenProvision.ordenCompra.deposito != null)?al.ordenProvision.ordenCompra.deposito.nombre:"";
				}


				celda = f.createCell(3);
				celda.setCellValue(al.expediente.descripcion +" - "+ depo+" - "+periodo);
				celda.setCellStyle(comun);

				celda = f.createCell(4);
				celda.setCellValue(af);
				celda.setCellStyle(comun);

				celda = f.createCell(5);
				celda.setCellValue(p);
				celda.setCellStyle(comun);

				x++;
			}
			f = hoja.createRow(x);
			celda = f.createCell(1);
			celda.setCellValue("TOTAL");
			celda.setCellStyle(comun);

			celda = f.createCell(2);
			celda.setCellValue(total.doubleValue());
			celda.setCellStyle(estiloMoneda);
			x++;
			x++;

			f = hoja.createRow(x);
			celda = f.createCell(1);
			String fechaAuto = (a.fecha != null) ? utils.DateUtils.formatDate(a.fecha) : utils.DateUtils.getNow();
			celda.setCellValue("Posadas, " + fechaAuto);
			hoja.addMergedRegion(new CellRangeAddress(x, x, 1, 3));

			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			return ok(modalReporteOrdenProvision.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();

			return ok(modalReporteOrdenProvision.render(null));
		}
	}

	public static Result reporteAutorizadoRemitos(Long id) {

		String dirTemp = System.getProperty("java.io.tmpdir");

		try {
			File archivo = new File(dirTemp + "/reporte-autorizado-remitos.xls");
			if (archivo.exists())
				archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Remitos");
			hoja.setColumnWidth(0, 12000);
			hoja.setColumnWidth(1, 12000);

			Cell celda;
			CellStyle comun = libro.createCellStyle();
			comun.setDataFormat((short) 10);
			comun.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			comun.setWrapText(true);
			Font font2 = libro.createFont();
			font2.setFontHeightInPoints((short) 10);
			comun.setFont(font2);

			CellStyle titulo = libro.createCellStyle();
			titulo.setDataFormat((short) 16);
			titulo.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			titulo.setWrapText(true);
			titulo.setAlignment(CellStyle.ALIGN_CENTER);
			Font font3 = libro.createFont();
			font3.setFontHeightInPoints((short) 16);
			font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titulo.setFont(font3);

			CellStyle titulo2 = libro.createCellStyle();
			titulo2.setDataFormat((short) 10);
			titulo2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			titulo2.setWrapText(true);
			titulo2.setAlignment(CellStyle.ALIGN_CENTER);
			Font font4 = libro.createFont();
			font4.setFontHeightInPoints((short) 10);
			font4.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titulo2.setFont(font4);

			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 10);
			estiloMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			estiloMoneda.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));
			estiloMoneda.setFont(font2);

			Autorizado a = Autorizado.find.byId(id);
			List<AutorizadoLinea> lineas = AutorizadoLinea.find.where().eq("autorizado_id", a.id).order("proveedor_id")
					.findList();
			String cuenta2 = "";
			String cuenta1 = "";

			int x = 0;
			Row fila = hoja.createRow(x);
			fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Autorizado " + a.nombre);
			celda0.setCellStyle(comun);

			boolean cabeza = true;
			x++;
			int i = 0;
			int z = 0;
			for (AutorizadoLinea al : lineas) {

				String af = "";
				if (al.ordenProvision != null) {
					af += "OP " + al.ordenProvision.numero;
				}

				z = x;
				x++;

				fila = hoja.createRow(x);
				hoja.addMergedRegion(new CellRangeAddress(x, x, 0, 1));
				String ca = al.proveedor.nombre + " - " + al.expediente.getInstitucionExpedienteEjercicio() + " - "
						+ af;

				celda = fila.createCell(0);
				celda.setCellValue(ca);
				celda.setCellStyle(comun);
				x++;

				boolean d = true;
				if (al.autorizadoLineaActa != null && al.autorizadoLineaActa.size() > 0) {

					for (AutorizadoLineaActa ax : al.autorizadoLineaActa) {
						if (ax.actaRecepcion != null) {

							List<Remito> lr = Remito.find.where().eq("recepcion.acta_id", ax.acta_recepcion_id)
									.findList();
							if (lr.size() > 0) {

								fila = hoja.createRow(x);
								celda = fila.createCell(0);
								celda.setCellValue("ACTA");
								celda.setCellStyle(comun);

								celda = fila.createCell(1);
								celda.setCellValue("REMITO");
								celda.setCellStyle(comun);

								x++;

								for (Remito lrx : lr) {
									fila = hoja.createRow(x);
									celda = fila.createCell(0);
									celda.setCellValue(ax.actaRecepcion.getNombre());
									celda.setCellStyle(comun);

									celda = fila.createCell(1);
									celda.setCellValue(lrx.numero);
									celda.setCellStyle(comun);
									x++;
									d = false;
								}

							}

						}
					}

				}

				if (d) {
					fila = hoja.createRow(x);
					celda = fila.createCell(0);
					celda.setCellValue("SIN REMITO");
					celda.setCellStyle(comun);

					celda = fila.createCell(1);
					celda.setCellValue("SIN REMITO");
					celda.setCellStyle(comun);
					x++;
				}

				if (d) {
					// x = i-1;
				} else {
					/*
					 * Logger.debug("zzzzzzz: "+z);
					 * fila = hoja.createRow(z);
					 * hoja.addMergedRegion(new CellRangeAddress(z,z,0,1));
					 * String ca =
					 * al.proveedor.nombre+" - "+al.expediente.getInstitucionExpedienteEjercicio()
					 * +" - "+af;
					 *
					 * celda = fila.createCell(0);
					 * celda.setCellValue(ca);
					 * celda.setCellStyle(comun);
					 *
					 * x++;
					 * x++;
					 * i = x;
					 */
				}

			}

			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			return ok(modalReporteOrdenProvision.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();

			return ok(modalReporteOrdenProvision.render(null));
		}
	}

	public static Result reporteAutorizado(Long id) {

		if (id == null) {
			flash("error", "Debe seleccionar un autorizado.");
			return ok(modalReporteOrdenProvision.render(null));
		}

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp + "/reporte-autorizado.odt");

		try {
			InputStream in = Play.application().resourceAsStream("resources/reportes/dashboard/reporte-autorizado.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

			Autorizado a = Autorizado.find.byId(id);

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			metadata.addFieldAsTextStyling("notas", SyntaxKind.Html);
			IContext context = report.createContext();

			if (a != null) {
				context.put("math", new MathTool());
				context.put("numberUtils", new NumberUtils());

				// List<AutorizadoLinea> lineas =
				// AutorizadoLinea.find.where().eq("autorizado_id", a.id).findList();

				context.put("a", a);
				// String cuenta = (a.profe)?"PROFE":"OPERATIVA";
				String cuenta1 = "";

				String cuenta2 = "";

				if (a.tipo_cuenta_id != null) {
					cuenta2 = "CUENTA CORRIENTE EJECUTORA Y PAGADORA Nº " + a.tipoCuenta.numero + " - "
							+ a.tipoCuenta.nombre;
					cuenta1 = a.tipoCuenta.nombre;
				} else {
					if (a.profe) {
						cuenta2 = "CUENTA CORRIENTE EJECUTORA Y PAGADORA Nº 3-001-09408729322 - PROFE";
						cuenta1 = "PROFE";
					} else {
						cuenta2 = "CUENTA CORRIENTE EJECUTORA Y PAGADORA Nº 3-001-09408769227 - OPERATIVA";
						cuenta1 = "OPERATIVA";
					}
				}

				context.put("cuenta", cuenta1);
				context.put("cuenta2", cuenta2);
				context.put("total", a.total);

				// a.autorizadoLinea

			} else {
				flash("error", "No se encuentra el autorizado.");
				return ok(modalReporteOrdenProvision.render(null));
			}

			OutputStream out = new FileOutputStream(archivo);
			report.process(context, out);

		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte.");
			return ok(modalReporteOrdenProvision.render(null));
		}

		return ok(modalReporteOrdenProvision.render(archivo.getPath()));
	}

	public static Result getResumen(Long id) {

		Autorizado a = Autorizado.find.byId(id);

		List<SqlRow> rp = new ArrayList<SqlRow>();
		List<SqlRow> rr = new ArrayList<SqlRow>();

		if (id != null) {
			rp = Autorizado.getTotalPorProveedor(id);
			rr = Autorizado.getTotalPorRubro(id);
		}

		return ok(contenidoTabResumen.render(autorizadoForm.fill(a), a, rp, rr));
	}
}
