package controllers.compras;

import static play.data.Form.form;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.apache.commons.mail.EmailAttachment;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.DireccionProveedor;
import models.Dispo;
import models.EnvioMail;
import models.Estado;
import models.Factura;
import models.FacturaDato;
import models.Orden;
import models.OrdenLinea;
import models.OrdenLineaCliente;
import models.OrdenProvision;
import models.OrdenesSolicitudes;
import models.Producto;
import models.Proveedor;
import models.Solicitud;
import models.Usuario;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.EmailUtilis;
import utils.RequestVar;
import utils.StringUtils;
import views.html.compras.ordenes.acciones.combinarOrdenes;
import views.html.compras.ordenes.acciones.resultadoOrdenSegunCuadroSugerenia;
import views.html.compras.ordenes.modales.*;


@Security.Authenticated(Secured.class)
public class OrdenesAccionesController extends Controller {

  @CheckPermiso(key = "ordenesEditarRubro")
  public static Result modalEditarRubro(Long id) {
    return ok(modalEditarRubro.render(form().bindFromRequest(), id));
  }

  @CheckPermiso(key = "reporteOrdenProvisionMail")
  public static Result modalOrdenMail(Long id) {

    DynamicForm d = form().bindFromRequest();
    Orden o = Orden.find.byId(id);

    List<DireccionProveedor> dp = DireccionProveedor.find.where().eq("proveedor_id", o.proveedor_id).findList();


    if (dp.size() > 0) {
      return ok(modalOrdenProvisionMail.render(d, o.id, dp));

    } else {
      flash("error", "No tiene cargada ninguna direccion el proveedor.");
      return ok(modalOrdenProvisionMail.render(d, o.id, null));
    }
  }

  @CheckPermiso(key = "reporteOrdenProvisionMail")
  public static Result enviarOrdenMail() {

    DynamicForm d = form().bindFromRequest();
    ObjectNode result = Json.newObject();
    Long ordenId = null;
    if (!request().body().asFormUrlEncoded().get("ordenId")[0].isEmpty()) {
      ordenId = new Long(request().body().asFormUrlEncoded().get("ordenId")[0]);
    }

    Orden o = Orden.find.byId(ordenId);
    if (o == null) {
      flash("error", "No se encuentra la orden de provision.");
      result.put("error", true);
      result.put("html", modalOrdenProvisionMail.render(d, null, null).toString());
      return ok(result);
    }

    if (o.fecha_provision == null) {
        flash("error", "La Orden debe tener una fecha de provision cargada.");
        result.put("error", true);
        result.put("html", modalOrdenProvisionMail.render(d, null, null).toString());
        return ok(result);
    }

    List<Dispo> listDispo = Dispo.find.where().eq("expediente_id", o.expediente_id).findList();
    if(listDispo.size() == 0) {
    	 flash("error", "La Orden debe tener una disposicion asociada al expediente.");
         result.put("error", true);
         result.put("html", modalOrdenProvisionMail.render(d, null, null).toString());
         return ok(result);
    }


    Long idDireProveedor = null;
    if (!request().body().asFormUrlEncoded().get("id_direccion")[0].isEmpty()) {
      idDireProveedor = new Long(request().body().asFormUrlEncoded().get("id_direccion")[0]);
    } else {
      flash("error", "No se encuentra la direccion.");
      result.put("error", true);
      result.put("html", modalOrdenProvisionMail.render(d, null, null).toString());
      return ok(result);
    }

    Proveedor pr = o.proveedor;
    DireccionProveedor dp = DireccionProveedor.find.where().eq("id", idDireProveedor).findUnique();

    String email = null;
    if (!request().body().asFormUrlEncoded().get("email")[0].isEmpty()) {
      email = request().body().asFormUrlEncoded().get("email")[0];
    } else {
      flash("error", "No se encuentra el email");
      result.put("error", true);
      result.put("html", modalOrdenProvisionMail.render(d, null, null).toString());
      return ok(result);
    }

    if (dp.email.compareToIgnoreCase(email) != 0) {
      dp.email = email;
      dp.write_date = new Date();
      dp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
      dp.save();
    }

    String dirTemp = System.getProperty("java.io.tmpdir");
    File archivo = new File(dirTemp + "/orden-provision2.odt");

    try {

      String textoMail = "<html>><p></p>";
      textoMail += "<p>Estimados Buenos D&iacute;as.</p>";
      textoMail += "<p>Por medio de la presente adjunto orden de provisi&oacute;n N&deg;"+o.numero_orden_provision+" con fecha "+utils.DateUtils.formatDate(o.fecha_provision)+" , expediente "+o.expediente.getInstitucionExpedienteEjercicio()+". "
      		+ "La misma es para que tomen conocimiento de que la compra les fue adjudicada.</p>";
      textoMail += "<p>En cuanto al pago, deben aguardar a que se comuniquen con Ustedes desde el Departamento de Tesorer&iacute;a del Parque de la Salud, "
      			+  "para darles aviso de que los fondos se encuentran disponibles y detallar que documentaci&oacute;n deber&aacute;n generar para poder cobrar.</p>";
      textoMail += "<p>Cualquier consulta estamos a su disposici&oacute;n.</p>";
      textoMail += "<p>Saludos cordiales.-</p></br></br></br>";

      textoMail += "<p style='font-weight: bold;font-size: 10px;'>"+Usuario.getUsurioSesion().nombre+"</p>";
      textoMail += "<p style='font-weight: bold;font-size: 10px;'>Departamento Compras</p>";
      textoMail += "<p style='font-weight: bold;font-size: 10px;'>Parque de la Salud de la Provincia de Misiones</p>";
      textoMail += "<p style='font-weight: bold;font-size: 10px;'>CUIT N&deg; 30-71222430-0</p>";
      textoMail += "<p style='font-weight: bold;font-size: 10px;'>Tel: 0376-4443700 - interno 2431</p>";
      textoMail += "<p style='font-weight: bold;font-size: 10px;'>Posadas - Misiones</p>";

      textoMail += "</html>";


      archivo = OrdenProvision.getArchivoReporteOrdenProvision(archivo, false, o, dp, pr);


      EmailAttachment attachment = new EmailAttachment();
      attachment.setPath(archivo.getPath());
      attachment.setDisposition(EmailAttachment.ATTACHMENT);
      attachment.setDescription("Orden Provision");
      attachment.setName(archivo.getName());
      List<EmailAttachment> attachmentList = new ArrayList<>();
      attachmentList.add(attachment);

      EmailUtilis eu = new EmailUtilis();
      eu.setFrom("compras@parquesaludmnes.org.ar");
      eu.setSubject("PARQUE DE LA SALUD - ORDEN DE PROVISION N°" + o.numero_orden_provision);
      eu.setHtmlMsg(textoMail);
      eu.setAttach(attachmentList);

      List<String> adds = new ArrayList<>();
      adds.add(dp.email);

      eu.setAdds(adds);

      eu.setAddCc("compras@parquesaludmnes.org.ar");


      eu.enviar();


      EnvioMail em = new EnvioMail();
      em.email = email;
      em.fecha = new Date();
      em.ids = o.id;
      em.usuario_id = new Long(Usuario.getUsuarioSesion());
      em.tipo = "ORDEN PROVISION";
      em.save();

      List<DireccionProveedor> dpl = DireccionProveedor.find.where().eq("proveedor_id", dp.proveedor_id).findList();
      result.put("success", true);
      flash("success", "Se envió el mail");
      result.put("html", modalOrdenProvisionMail.render(d, o.id, dpl).toString());
      return ok(result);

    } catch (Exception e) {
      e.printStackTrace();
      flash("error", "No se pudo generar el reporte.");
      result.put("error", true);
      result.put("html", modalOrdenProvisionMail.render(d, null, null).toString());
      return ok(result);
    }


  }


  @CheckPermiso(key = "ordenesEditarRubro")
  public static Result editarRubro() {
    DynamicForm d = form().bindFromRequest();
    d.discardErrors();

    if (RequestVar.get("id_orden") == null || RequestVar.get("id_orden").isEmpty()) {
      flash("error", "Solo se puede modificar. No se encuentra el ID de orden.");
      return ok(modalEditarRubro.render(d, null));
    }

    Long idOrden = new Long(RequestVar.get("id_orden"));

    if (RequestVar.get("orden_rubro_id") == null || RequestVar.get("orden_rubro_id").isEmpty()) {
      flash("error", "Seleccione un rubro");
      return ok(modalEditarRubro.render(d, idOrden));
    }

    Long idRubro = new Long(RequestVar.get("orden_rubro_id"));

    Long idSubRubro = (RequestVar.get("orden_subrubro_id") != null && !RequestVar.get("orden_subrubro_id").isEmpty())
        ? new Long(RequestVar.get("orden_subrubro_id"))
        : null;
    String detalle =
        (RequestVar.get("detalle_rubro") != null && !RequestVar.get("orden_subrubro_id").isEmpty()) ? RequestVar.get("detalle_rubro") : null;

    if (d.hasErrors())
      return ok(modalEditarRubro.render(d, idOrden));

    ObjectNode result = Json.newObject();
    try {
      Integer count = Orden.editarRubro(idOrden, idRubro, idSubRubro, detalle);
      result.put("success", true);
      flash("success", "Se actualizo la orden");
      result.put("html", modalEditarRubro.render(d, idOrden).toString());
      return ok(result);
    } catch (Exception e) {
      flash("error", "No se puede modificar los registros." + e);
      return ok(modalEditarRubro.render(d, idOrden));
    }

  }

  @CheckPermiso(key = "ordenesEditarRubro")
  public static Result modalEditarRubroMasivo() {
    return ok(modalEditarRubroMasivo.render(form().bindFromRequest()));
  }

  @CheckPermiso(key = "ordenesEditarRubro")
  public static Result editarRubroMasivo() {
    DynamicForm d = form().bindFromRequest();
    d.discardErrors();

    List<Integer> ids = getSeleccionados();

    if (ids.isEmpty() || ids.size() < 1) {
      flash("error", "Debe seleccionar al menos 1 orden.");
      return ok(modalEditarRubroMasivo.render(d));
    }

    Long idRubro = null;
    if (!request().body().asFormUrlEncoded().get("orden_rubro_id")[0].isEmpty()) {
    	idRubro = new Long(request().body().asFormUrlEncoded().get("orden_rubro_id")[0]);
    }else{
    	flash("error", "Seleccione un rubro");
        return ok(modalEditarRubroMasivo.render(d));
    }

    Long idSubRubro = null;
    if (!request().body().asFormUrlEncoded().get("orden_subrubro_id")[0].isEmpty()) {
    	idSubRubro = new Long(request().body().asFormUrlEncoded().get("orden_subrubro_id")[0]);
    }else {
    	flash("error", "Seleccione un subrubro");
    	return ok(modalEditarRubroMasivo.render(d));
    }

    String detalle =
        (request().body().asFormUrlEncoded().get("detalle_rubro")[0] != null && !request().body().asFormUrlEncoded().get("detalle_rubro")[0].isEmpty())
        ? request().body().asFormUrlEncoded().get("detalle_rubro")[0] : null;

    if (d.hasErrors())
      return ok(modalEditarRubroMasivo.render(d));

    ObjectNode result = Json.newObject();
    try {
      Integer count = Orden.editarRubroMasivo(ids, idRubro, idSubRubro, detalle);
      result.put("success", true);
      flash("success", "Se actualizo la orden");
      result.put("html", modalEditarRubroMasivo.render(d).toString());
      return ok(result);
    } catch (Exception e) {
      flash("error", "No se puede modificar los registros." + e);
      return ok(modalEditarRubroMasivo.render(d));
    }

  }


  @CheckPermiso(key = "ordenesEditarFechaProvision")
  public static Result modalEditarFechaProvision(Long id) {
    Orden o = Orden.find.byId(id);
    return ok(modalEditarFechaProvision.render(form().bindFromRequest(), id, o));
  }

  @CheckPermiso(key = "ordenesEditarFechaProvision")
  public static Result editarFechaProvision() {
    DynamicForm d = form().bindFromRequest();
    d.discardErrors();

    if (RequestVar.get("id_orden") == null || RequestVar.get("id_orden").isEmpty()) {
      flash("error", "Solo se puede modificar. No se encuentra el ID de orden.");
      return ok(modalEditarFechaProvision.render(d, null, null));
    }

    Long idOrden = new Long(RequestVar.get("id_orden"));

    Orden o = Orden.find.byId(idOrden);


    if (RequestVar.get("fecha_modal") == null || RequestVar.get("fecha_modal").isEmpty()) {
      flash("error", "Seleccione una fecha");
      return ok(modalEditarFechaProvision.render(d, idOrden, o));
    }

    Date fecha = DateUtils.formatDate(RequestVar.get("fecha_modal"), "dd/MM/yyyy");

    if (d.hasErrors())
      return ok(modalEditarFechaProvision.render(d, idOrden, o));

    ObjectNode result = Json.newObject();
    try {
      Integer count = Orden.editarFechaProvision(idOrden, fecha);
      result.put("success", true);
      flash("success", "Se actualizo la orden");
      result.put("html", modalEditarFechaProvision.render(d, idOrden, o).toString());
      return ok(result);
    } catch (Exception e) {
      flash("error", "No se puede modificar los registros.");
      return ok(modalEditarFechaProvision.render(d, idOrden, o));
    }

  }

  @CheckPermiso(key = "ordenesEditarMontoAdelanto")
  public static Result modalEditarCotDolar(Long id) {
    return ok(modalEditarCotDolar.render(form().bindFromRequest(), id));
  }

  @CheckPermiso(key = "ordenesEditarMontoAdelanto")
  public static Result editarCotDolar() {
    DynamicForm d = form().bindFromRequest();
    d.discardErrors();

    if (RequestVar.get("id_orden") == null || RequestVar.get("id_orden").isEmpty()) {
      flash("error", "Solo se puede modificar. No se encuentra el ID de orden.");
      return ok(modalEditarCotDolar.render(d, null));
    }

    BigDecimal monto = new BigDecimal(RequestVar.get("monto_adelanto_modal"));
    Long idOrden = new Long(RequestVar.get("id_orden"));

    if (RequestVar.get("monto_adelanto_modal") == null || RequestVar.get("monto_adelanto_modal").isEmpty()) {
      flash("error", "Seleccione un monto adelanto");
      return ok(modalEditarCotDolar.render(d, idOrden));
    } else if (monto.compareTo(BigDecimal.ZERO) <= 0) {
      flash("error", "Seleccione un monto mayor a cero");
      return ok(modalEditarCotDolar.render(d, idOrden));
    }

    Orden o = Orden.find.byId(idOrden);
    if (o.tipo_moneda == null) {
      flash("error", "No se puede modificar la orden. La orden no es una orden en con MONEDA EXTRAJERA. Debe crear nuevamente la orden.");
      return ok(modalEditarCotDolar.render(d, idOrden));
    }


    if (d.hasErrors())
      return ok(modalEditarCotDolar.render(d, idOrden));

    ObjectNode result = Json.newObject();
    try {
      Integer count = Orden.editarCotDolar(idOrden, monto);
      result.put("success", true);
      flash("success", "Se actualizo la orden");
      result.put("html", modalEditarCotDolar.render(d, idOrden).toString());
      return ok(result);
    } catch (Exception e) {
      flash("error", "No se puede modificar los registros.");
      return ok(modalEditarCotDolar.render(d, idOrden));
    }

  }

  @CheckPermiso(key = "ordenesEditarMontoAdelanto")
  public static Result modalEditarMontoAdelanto(Long id) {
    return ok(modalEditarMontoAdelanto.render(form().bindFromRequest(), id));
  }

  @CheckPermiso(key = "ordenesEditarMontoAdelanto")
  public static Result editarMontoAdelanto() {
    DynamicForm d = form().bindFromRequest();
    d.discardErrors();

    if (RequestVar.get("id_orden") == null || RequestVar.get("id_orden").isEmpty()) {
      flash("error", "Solo se puede modificar. No se encuentra el ID de orden.");
      return ok(modalEditarMontoAdelanto.render(d, null));
    }

    BigDecimal monto = new BigDecimal(RequestVar.get("monto_adelanto_modal"));
    Long idOrden = new Long(RequestVar.get("id_orden"));

    if (RequestVar.get("monto_adelanto_modal") == null || RequestVar.get("monto_adelanto_modal").isEmpty()) {
      flash("error", "Seleccione un monto adelanto");
      return ok(modalEditarMontoAdelanto.render(d, idOrden));
    }

    Orden o = Orden.find.byId(idOrden);

    if (monto.compareTo(o.getTotalTotalSinDiferenciaCotizacion().setScale(2, RoundingMode.HALF_UP)) > 0) {
        flash("error", "El monto adelanto no puede ser mayor al total de la orden.");
        return ok(modalEditarMontoAdelanto.render(d, idOrden));
      }


    if (o.tipo_orden.compareTo("comun") != 0 && o.tipo_orden.compareTo("servicio") != 0) {
      flash("error", "El monto adelanto solo se puede agregar en Recepcion de productos y Certificacion de Servicios patrimonio");
      return ok(modalEditarMontoAdelanto.render(d, idOrden));
    }


    if (d.hasErrors())
      return ok(modalEditarMontoAdelanto.render(d, idOrden));

    ObjectNode result = Json.newObject();
    try {
      Integer count = Orden.editarMontoAdelanto(idOrden, monto);
      result.put("success", true);
      flash("success", "Se actualizo la orden");
      result.put("html", modalEditarMontoAdelanto.render(d, idOrden).toString());
      return ok(result);
    } catch (Exception e) {
      flash("error", "No se puede modificar los registros.");
      return ok(modalEditarMontoAdelanto.render(d, idOrden));
    }

  }

  @CheckPermiso(key = "dispoCrear")
  public static Result modalCrearDispo(Long id) {
    return ok(modalCrearDispo.render(form().bindFromRequest(), id));
  }

  @CheckPermiso(key = "dispoCrear")
  public static Result crearDispo() {
    DynamicForm d = form().bindFromRequest();
    d.discardErrors();

    if (RequestVar.get("id_orden") == null || RequestVar.get("id_orden").isEmpty()) {
      flash("error", "No se encuentra el ID de orden.");
      return ok(modalCrearDispo.render(d, null));
    }

    Long idOrden = new Long(RequestVar.get("id_orden"));

    if (RequestVar.get("numero") == null || RequestVar.get("numero").isEmpty()) {
      flash("error", "Debe Ingresar un numero");
      return ok(modalCrearDispo.render(d, idOrden));
    }


    if (d.hasErrors())
      return ok(modalCrearDispo.render(d, idOrden));


    Orden o = Orden.find.byId(idOrden);
    if ((RequestVar.get("fecha") == null || RequestVar.get("fecha").isEmpty()) && o.fecha_provision == null) {
      flash("error", "Debe Ingresar una fecha");
      return ok(modalCrearDispo.render(d, idOrden));
    }

    Date fecha = DateUtils.formatDate(RequestVar.get("fecha"), "dd/MM/yyyy");

    String des = RequestVar.get("descripcion");
    Integer numero = Integer.parseInt(RequestVar.get("numero"));

    ObjectNode result = Json.newObject();
    try {

      Dispo.buscarDuplicado(o.expediente_id, numero, new Long(1));

      Dispo dispo = new Dispo();
      dispo.numero = numero;
      dispo.fecha = (o.fecha_provision != null) ? o.fecha_provision : fecha;
      dispo.expediente_id = o.expediente_id;
      dispo.descripcion = des;
      dispo.organigrama_id = new Long(1);
      dispo.create_usuario_id = new Long(Usuario.getUsuarioSesion());
      dispo.create_date = new Date();
      dispo.save();


      flash("success", "Se actualizo la orden");
      result.put("success", true);
      result.put("url", controllers.compras.routes.OrdenesController.ver(o.id).url());
      return ok(result);
    } catch (ConstraintViolationException e) {
      flash("error", "El número y ejercicio ya existe");
      return ok(modalCrearDispo.render(d, idOrden));
    } catch (Exception e) {
      flash("error", "No se puede modificar los registros." + e);
      return ok(modalCrearDispo.render(d, idOrden));
    }

  }


  @CheckPermiso(key = "ordenesCompraCombinar")
  public static Result combinar() {
    List<Integer> ids = getSeleccionados();

    if (ids.isEmpty() || ids.size() < 2) {
      flash("error", "Debe seleccionar al menos 2 órdenes.");
      return ok(combinarOrdenes.render());
    }


    String sqlEstado = " SELECT * FROM ordenes WHERE state_id = " + Estado.ORDEN_ESTADO_APROBADO + " AND id in (:listId)";
    List<SqlRow> estado = Ebean.createSqlQuery(sqlEstado).setParameter("listId", ids).findList();

    if (estado.size() > 0) {
      flash("error", "Las órdenes a combinar no pueden ser órdenes en estado aprobado.");
      return ok(combinarOrdenes.render());
    }

    // Compruebo si las órdenes son del mismo proveedor y expediente
    String sql =
        " SELECT proveedor_id, expediente_id,tipo_cuenta_id FROM ordenes o WHERE o.id in (:listId) GROUP BY proveedor_id, expediente_id,tipo_cuenta_id ";
    List<SqlRow> o = Ebean.createSqlQuery(sql).setParameter("listId", ids).findList();
    if (o.size() > 1) {
      flash("error", "Las órdenes a combinar deben ser del mismo proveedor, cuenta y expediente.");
      return ok(combinarOrdenes.render());
    }

    // Junto y sumo las lineas
    String sqlCombinado = "SELECT sum(cantidad) cantidad, precio, producto_id,cuenta_analitica_id,udm_id " + "FROM orden_lineas "
        + "WHERE orden_id in (:listId) " + "GROUP BY producto_id,cuenta_analitica_id,precio,udm_id ";

    List<SqlRow> lineasCombinadas = Ebean.createSqlQuery(sqlCombinado).setParameter("listId", ids).findList();

    List<Long> controlProductoPrecio = new ArrayList<>();
    String error = "";
    for (SqlRow x : lineasCombinadas) {
      if (!controlProductoPrecio.contains(x.getLong("producto_id"))) {
        controlProductoPrecio.add(x.getLong("producto_id"));
      } else {
        Producto p = Producto.find.byId(x.getLong("producto_id"));
        error += "PRODUCTO: " + p.nombre;
      }
    }

    if (!error.isEmpty()) {
      flash("error", "Las órdenes a combinar no pueden tener productos iguales con distintos precios o distinta cuenta.<br>" + error);
      return ok(combinarOrdenes.render());
    }

    String sqlCombinado2 = "SELECT count(*) cantidad, producto_id,ol.departamento_id as departamento_id,solicitud_id " + "				FROM orden_lineas ol "
        + "				inner join ordenes o on o.id =ol.orden_id " + "				WHERE orden_id in (:listId) "
        + "				GROUP BY producto_id,ol.departamento_id,solicitud_id  ";
    List<SqlRow> lineasCombinadas2 = Ebean.createSqlQuery(sqlCombinado2).setParameter("listId", ids).findList();
    Map<Long, Long> controlProductoServicio = new HashMap<>();


    for (SqlRow x2 : lineasCombinadas2) {
      if (controlProductoServicio.containsKey(x2.getLong("producto_id"))) {
        if (x2.getLong("solicitud_id") != null) {
          Solicitud s = Solicitud.find.byId(x2.getLong("solicitud_id"));
          if (s.create_usuario.organigrama_id.equals(new Long(90))) {
            controlProductoServicio.remove(x2.getLong("producto_id"));
            controlProductoServicio.put(x2.getLong("producto_id"), new Long(15));
          }
        }
      } else {
        controlProductoServicio.put(x2.getLong("producto_id"), x2.getLong("departamento_id"));
      }
    }

    try {
      Ebean.beginTransaction();

      Long proximoSec = Ebean.createSqlQuery("SELECT nextval('ordenes_id_seq') id").findUnique().getLong("id");

      List<Orden> loo = Orden.find.where().in("id", ids).findList();

      Orden orden = new Orden();
      orden.nombre = "ORD" + proximoSec;
      orden.estado_id = (long) Estado.ORDEN_ESTADO_BORRADOR;
      orden.proveedor_id = loo.get(0).proveedor_id;
      orden.expediente_id = loo.get(0).expediente_id;
      orden.profe = loo.get(0).profe;
      orden.tipo_cuenta_id = loo.get(0).tipo_cuenta_id;
      orden.deposito_id = loo.get(0).deposito_id;
      orden.periodo_id = loo.get(0).periodo_id;
      orden.origen = loo.get(0).origen;
      orden.estado_id = (long) Estado.ORDEN_ESTADO_BORRADOR;
      orden.tipo_contratacion = loo.get(0).tipo_contratacion;
      orden.tipo_orden = loo.get(0).tipo_orden;
      orden.fecha_orden = new Date();
      orden.create_usuario_id = new Long(Usuario.getUsuarioSesion());
      orden.create_date = new Date();
      orden.save();


      String sqlListaIdSolicitudes = "SELECT solicitud_id FROM ordenes_solicitudes WHERE orden_id in(:idsList) GROUP BY solicitud_id";
      List<SqlRow> listaIdSolicitudes = Ebean.createSqlQuery(sqlListaIdSolicitudes).setParameter("idsList", ids).findList();
      for (SqlRow s : listaIdSolicitudes) {
        OrdenesSolicitudes os = new OrdenesSolicitudes();
        os.orden_id = orden.id;
        os.solicitud_id = s.getLong("solicitud_id");
        os.save();
      }


      for (SqlRow l : lineasCombinadas) {
        OrdenLinea linea = new OrdenLinea();
        linea.orden_id = orden.id;
        linea.nombre = "";
        linea.cantidad = l.getBigDecimal("cantidad");
        linea.producto_id = l.getLong("producto_id");
        linea.udm_id = l.getLong("udm_id");
        linea.precio = l.getBigDecimal("precio");
        linea.cuenta_analitica_id = l.getLong("cuenta_analitica_id");
        linea.departamento_id = controlProductoServicio.get(l.getLong("producto_id"));// l.getLong("departamento_id");
        linea.create_usuario_id = new Long(Usuario.getUsuarioSesion());
        linea.create_date = new Date();
        linea.save();

        String sqlBuscarPacientes = "SELECT SUM(olc.cantidad) as cantidad,olc.cliente_id as cliente " + "FROM orden_linea_clientes olc "
            + "INNER JOIN orden_lineas ol ON ol.id = olc.orden_linea_id " + "WHERE ol.orden_id IN (:listId) AND ol.producto_id = :idProducto "
            + "GROUP BY olc.cliente_id ";

        List<SqlRow> lineasConPacientes =
            Ebean.createSqlQuery(sqlBuscarPacientes).setParameter("listId", ids).setParameter("idProducto", linea.producto_id).findList();

        if (lineasConPacientes.size() > 0) {
          for (SqlRow z : lineasConPacientes) {
            OrdenLineaCliente olc = new OrdenLineaCliente();
            olc.cantidad = z.getBigDecimal("cantidad");
            olc.cliente_id = z.getLong("cliente");
            olc.orden_linea_id = linea.id;
            olc.save();
          }
        }
      }

      String sqlUpdate =
          "UPDATE ordenes " + "SET state_id = :estado,write_date = :write_date,write_usuario_id = :write_usuario_id " + "WHERE id in (:listId)";
      Ebean.createSqlUpdate(sqlUpdate)
          .setParameter("estado", Estado.ORDEN_ESTADO_CANCELADO)
          .setParameter("write_date", new Date())
          .setParameter("write_usuario_id", new Long(Usuario.getUsuarioSesion()))
          .setParameter("listId", ids)
          .execute();


      Ebean.commitTransaction();
      return ok(Json.newObject().put("url", controllers.compras.routes.OrdenesController.ver(orden.id).url()));
    } catch (Exception e) {
      Logger.debug("eeeeeeeeeeee " + e);
      Ebean.rollbackTransaction();
    } finally {
      Ebean.endTransaction();
    }

    return ok(combinarOrdenes.render());
  }

  @CheckPermiso(key = "ordenesCompraAccionGenerarOrdenCuadroAdjudicacion")
  public static Result generarOrdenSegunCuadroSugerenia() {
    List<Integer> ids = getSeleccionados();

    if (ids.isEmpty() || ids.size() < 2) {
      flash("error", "Debe seleccionar al menos 2 órdenes.");
      return ok(resultadoOrdenSegunCuadroSugerenia.render());
    }


    String sqlEstado = " SELECT * FROM ordenes WHERE state_id = " + Estado.ORDEN_ESTADO_APROBADO + " AND id in (:listId)";
    List<SqlRow> estado = Ebean.createSqlQuery(sqlEstado).setParameter("listId", ids).findList();

    if (estado.size() > 0) {
      flash("error", "Las órdenes no pueden ser órdenes en estado aprobado.");
      return ok(resultadoOrdenSegunCuadroSugerenia.render());
    }

    // Compruebo hay lineas con cantidades diferentes
    String sqlCantidades = " " + " select count(producto_id), producto_id, p.nombre  from ( " + " 	select  ol.producto_id from ordenes o "
        + " 	inner join orden_lineas ol on o.id = ol.orden_id  " + " 	where o.id in (:listId) " + " 	group by ol.producto_id, ol.cantidad  "
        + " 	order by ol.producto_id " + " ) cantidades  " + " inner join productos p on cantidades.producto_id = p.id "
        + " group by producto_id, p.nombre " + " having count(producto_id) > 1";
    List<SqlRow> cantidades = Ebean.createSqlQuery(sqlCantidades).setParameter("listId", ids).findList();

    if (cantidades.size() > 0) {
      String lineas = "<ul>";
      for (SqlRow p : cantidades) {
        lineas += "<li>" + p.getString("nombre") + "</li>";
      }
      lineas += "</ul>";
      flash("error", "Estos productos tienen diferentes cantidades en alguna de las órdenes seleccionadas: <br />" + lineas);

      return ok(combinarOrdenes.render());
    }

    List<Integer> ordenesSeleccionadas = getSeleccionados();

    // Recupero la lista de productos con cantidades de todas las órdenes seleccionadas
    List<SqlRow> listaProductos =
        Ebean
            .createSqlQuery("SELECT ol.producto_id, p.nombre, ol.cantidad cantidad " + "FROM ordenes o "
                + "INNER JOIN orden_lineas ol ON o.id = ol.orden_id " + "INNER JOIN productos p ON p.id = ol.producto_id " + "WHERE o.id IN("
                + StringUtils.implode(ordenesSeleccionadas) + ") " + "GROUP BY ol.producto_id, p.nombre,ol.cantidad ORDER BY ol.producto_id")
            .findList();

    // Recupero los proveedores
    List<SqlRow> listaProveedores =
        Ebean.createSqlQuery("SELECT o.proveedor_id, " + "p.nombre, " + "o.expediente_id," + "o.profe profe," + "o.tipo_cuenta_id tipo_cuenta_id,"
            + "o.origen origen," + "o.deposito_id deposito," + "o.tipo_contratacion tipo_contratacion," + "o.periodo_id periodo " + "FROM ordenes o "
            + "INNER JOIN proveedores p ON p.id = o.proveedor_id " + "WHERE o.id IN(" + StringUtils.implode(ordenesSeleccionadas) + ") "
            + "GROUP BY o.proveedor_id, p.nombre, o.expediente_id,o.profe,o.tipo_cuenta_id,o.origen,o.deposito_id,o.tipo_contratacion,o.periodo_id "
            + "ORDER BY p.nombre").findList();

    // saco los pacientes de las lineas
    List<SqlRow> listaProductosClientesLineas =
        Ebean
            .createSqlQuery("SELECT ol.producto_id productoId," + "oc.cliente_id clienteId," + "oc.cantidad cantidad " + "FROM ordenes o "
                + "INNER JOIN orden_lineas ol ON o.id = ol.orden_id " + "INNER JOIN orden_linea_clientes oc ON ol.id = oc.orden_linea_id "
                + "WHERE o.id IN (" + StringUtils.implode(ordenesSeleccionadas) + ") " + "GROUP BY ol.producto_id,oc.cliente_id,oc.cantidad")
            .findList();

    // Recupero el proveedor y el detalle del producto que sea de menor valor
    List<SqlRow> listaDetalles = Ebean
        .createSqlQuery("SELECT o.proveedor_id, ol.producto_id, ol.precio, ol.udm_id, ol.cuenta_analitica_id,ol.departamento_id as departamento_id "
        		 		+ "FROM ordenes o "
            + "INNER JOIN orden_lineas ol ON o.id = ol.orden_id "
            + "INNER JOIN (SELECT MIN(precio) precio, producto_id FROM orden_lineas WHERE orden_id IN(" + StringUtils.implode(ordenesSeleccionadas)
            + ") AND (cantidad > 0 AND precio > 0) GROUP BY producto_id) ol2 ON ol.producto_id = ol2.producto_id AND ol.precio = ol2.precio "
            + "WHERE o.id IN(" + StringUtils.implode(ordenesSeleccionadas) + ") "
            + "GROUP BY o.proveedor_id, ol.producto_id, ol.precio, ol.udm_id, ol.cuenta_analitica_id,ol.departamento_id  " + "ORDER BY ol.producto_id")
        .findList();


    HashMap<Integer, List<SqlRow>> detalles = new HashMap<>();
    // Cargo los detalles en una lista (la clave es el id de producto)
    for (SqlRow detalle : listaDetalles) {
      Integer idProducto = detalle.getInteger("producto_id");
      if (detalles.containsKey(idProducto)) {
        detalles.get(idProducto).add(detalle);
      } else {
        List<SqlRow> productoDeProveedor = new ArrayList<>();
        productoDeProveedor.add(detalle);
        detalles.put(idProducto, productoDeProveedor);
      }
    }

    // Para guardar las lineas de las órdenes, la clave es id de proveedor
    HashMap<Integer, List<OrdenLinea>> lineasOrdenes = new HashMap<>();


    try {
      Ebean.beginTransaction();
      Long proximaSec = Ebean.createSqlQuery("SELECT nextval('ordenes_id_seq') id").findUnique().getLong("id");

      for (SqlRow producto : listaProductos) {
        if (detalles.containsKey(producto.getInteger("producto_id"))) {
          for (SqlRow detalle : detalles.get(producto.getInteger("producto_id"))) {

            List<OrdenLinea> linea = lineasOrdenes.get(detalle.getInteger("proveedor_id"));
            if (linea == null) {
              linea = new ArrayList<>();
            }

            BigDecimal cantidad = producto.getBigDecimal("cantidad");
            if (detalles.size() > 1) {
              cantidad = producto.getBigDecimal("cantidad").divide(BigDecimal.valueOf(detalles.get(producto.getInteger("producto_id")).size()));
            }

            OrdenLinea ol = new OrdenLinea();
            ol.producto_id = detalle.getLong("producto_id");
            ol.nombre = producto.getString("nombre");
            ol.precio = detalle.getBigDecimal("precio");
            ol.udm_id = detalle.getLong("udm_id");
            ol.cuenta_analitica_id = detalle.getLong("cuenta_analitica_id");
            ol.departamento_id = detalle.getLong("departamento_id");
            // Para la cantidad divido la cantidad de productos por la cantidad de proveedores
            ol.cantidad = producto.getBigDecimal("cantidad").divide(BigDecimal.valueOf(detalles.get(producto.getInteger("producto_id")).size()));
            linea.add(ol);
            lineasOrdenes.put(detalle.getInteger("proveedor_id"), linea);
          }
        }
      }

      Integer ordenesCreadas = 0;
      for (SqlRow p : listaProveedores) {
        if (lineasOrdenes.containsKey(p.getInteger("proveedor_id"))) {
          Orden orden = new Orden();
          orden.proveedor_id = p.getLong("proveedor_id");
          orden.nombre = "OC" + proximaSec;
          orden.expediente_id = p.getLong("expediente_id");
          orden.estado_id = (long) Estado.ORDEN_ESTADO_BORRADOR;
          orden.fecha_orden = new Date();
          orden.profe = p.getBoolean("profe");
          orden.tipo_cuenta_id = p.getLong("tipo_cuenta_id");
          orden.origen = p.getString("origen");
          orden.deposito_id = p.getLong("deposito");
          orden.tipo_contratacion = p.getString("tipo_contratacion");
          orden.tipo_orden = p.getString("tipo_orden");
          orden.periodo_id = p.getLong("periodo");
          orden.create_usuario_id = new Long(Usuario.getUsuarioSesion());
          orden.create_date = new Date();
          orden.creacion_automatica = true;
          orden.save();

          String sqlListaIdSolicitudes = "SELECT solicitud_id FROM ordenes_solicitudes " + "WHERE orden_id in(:idsList) " + "GROUP BY solicitud_id";
          List<SqlRow> listaIdSolicitudes = Ebean.createSqlQuery(sqlListaIdSolicitudes).setParameter("idsList", ids).findList();
          for (SqlRow s : listaIdSolicitudes) {
            OrdenesSolicitudes os = new OrdenesSolicitudes();
            os.orden_id = orden.id;
            os.solicitud_id = s.getLong("solicitud_id");
            os.save();
          }

          for (OrdenLinea o : lineasOrdenes.get(p.getInteger("proveedor_id"))) {
            o.orden_id = orden.id;
            o.save();

            for (SqlRow cx : listaProductosClientesLineas) {
              if (cx.getLong("productoId").equals(o.producto_id)) {
                try {
                  OrdenLineaCliente olc = new OrdenLineaCliente();
                  olc.cliente_id = cx.getLong("clienteId");
                  olc.orden_linea_id = o.id;
                  olc.cantidad = cx.getBigDecimal("cantidad");
                  olc.save();
                } catch (Exception x) {

                }
              }
            }
          }
          ordenesCreadas++;
        }
      }

      String sqlUpdate =
          "UPDATE ordenes " + "SET state_id = :estado,write_date = :write_date,write_usuario_id = :write_usuario_id " + "WHERE id in (:listId)";
      Ebean.createSqlUpdate(sqlUpdate)
          .setParameter("estado", Estado.ORDEN_ESTADO_CANCELADO)
          .setParameter("write_date", new Date())
          .setParameter("write_usuario_id", new Long(Usuario.getUsuarioSesion()))
          .setParameter("listId", ids)
          .execute();

      Ebean.commitTransaction();
      flash("success", "Se han creado " + ordenesCreadas + " órdene(s) a partir de las " + ordenesSeleccionadas.size() + " seleccionadas.");
    } catch (Exception e) {
      flash("error", "No se pudo crear las órdenes " + e);
      Ebean.rollbackTransaction();
    } finally {
      Ebean.endTransaction();
    }

    return ok(resultadoOrdenSegunCuadroSugerenia.render());
  }


  public static List<Integer> getSeleccionados() {
    String[] checks = null;
    try {
      checks = request().body().asFormUrlEncoded().get("check_listado[]");
    } catch (NullPointerException e) {
    }

    List<Integer> ids = new ArrayList<>();
    if (checks != null) {
      for (String id : checks) {
        ids.add(Integer.valueOf(id));
      }
    }
    return ids;
  }

  public static Result importarListaProductos() throws IOException {

    String error = "";
    Boolean lineasValidas = true;
    String ok = "";

    MultipartFormData body = request().body().asMultipartFormData();
    FilePart upload = body.getFile("myfile");
    Long idOrden = new Long(request().body().asMultipartFormData().asFormUrlEncoded().get("idOrd")[0]);
    /*
     * try{
     * if(idOrden != null){
     * Orden s1 = Orden.find.byId(idOrden);
     *
     * if(s1.estado_id == Estado.ORDEN_ESTADO_BORRADOR || s1.estado_id == Estado.ORDEN_ESTADO_ENCURSO){
     *
     * List<OrdenLinea> snx = OrdenLinea.find.where().eq("orden_id",idOrden).findList();
     * boolean yaTieneLineas = (snx.size() > 0)?true:false;
     *
     * if (upload != null) {
     * //String fileName = upload.getFilename();
     * //String contentType = upload.getContentType();
     * File file = upload.getFile();
     *
     * FileInputStream input = new FileInputStream(file.getAbsolutePath());
     * POIFSFileSystem fs = new POIFSFileSystem(input);
     * HSSFWorkbook wb = new HSSFWorkbook(fs);
     * HSSFSheet sheet = wb.getSheetAt(0);
     * Row row;
     * int cantidadDeRowProcesadas = 0;
     * List<OrdenLinea> lsl = new ArrayList<OrdenLinea>();
     * List<String> listaP = new ArrayList<String>();
     * Map<String,Double> productoControlPrecio = new HashMap<String,Double>();
     * List<String> productosRepetidos = new ArrayList<String>();
     *
     * for (int i = 1; i <= sheet.getLastRowNum(); i++) {
     * row = sheet.getRow(i);
     * SqlRow rowProducto = null;
     * SqlRow rowCuentaAnalitica = null;
     * SqlRow rowUnidad = null;
     * SqlRow rowServicio = null;
     *
     * int num_emp = (int) row.getCell(0).getNumericCellValue();
     * String nombreProducto = row.getCell(1).getStringCellValue().toUpperCase().trim().replace(" ","").replace("-","").replace(".","");
     * String nombreProductoAInsertar = row.getCell(1).getStringCellValue();
     * Double cantidad = row.getCell(2).getNumericCellValue();
     * String cuentaAnaliticaCodigo = row.getCell(3).getStringCellValue();
     * String unidadDeMedida = row.getCell(4).getStringCellValue();
     * Double precio = row.getCell(5).getNumericCellValue();
     * String servicio = row.getCell(6).getStringCellValue();
     *
     *
     * if(productoControlPrecio.containsKey(nombreProducto)){
     * Double a = productoControlPrecio.get(nombreProducto);
     * if(a.compareTo(precio) != 0){
     * //hay un producto igual con distinto precio
     * error += "<p class='responseError'>-Esta producto "+nombreProductoAInsertar+" repetido con distinto precio. linea "+num_emp+" </p>";
     * lineasValidas = false;
     * }
     * }else{
     * productoControlPrecio.put(nombreProducto, precio);
     * }
     *
     * String precioAinsertar = (precio != 0)?precio.toString():"1";
     * String insert = "INSERT INTO productos(nombre,referencia,precio_coste,activo,categoria_id," +
     * "tipo_producto_id, articulo_id, udm_id, cuenta_ingreso_id, cuenta_gasto_id,compra,venta) VALUES " +
     * "('"+nombreProductoAInsertar+"','"+nombreProductoAInsertar+"',"+precioAinsertar+",true,XXX,2, 1537, 1, 226,255,false,false);";
     *
     *
     *
     *
     * if(nombreProducto != null && !nombreProducto.isEmpty()){
     * //if(!listaP.contains(nombreProducto)){
     * //String sqlProducto = "SELECT id FROM productos WHERE UPPER(replace(replace(replace(trim(nombre),' ','' ),'-',''),'.','' )) = :nombre";
     * String sqlProducto = "SELECT id FROM productos WHERE slug = :nombre";
     * List<SqlRow> rp = Ebean.createSqlQuery(sqlProducto)
     * .setParameter("nombre", nombreProducto)
     * .findList();
     * for(SqlRow x : rp){
     * rowProducto = x;
     * }
     *
     *
     * if(rowProducto == null || rowProducto.isEmpty()){
     *
     * if(!productosRepetidos.contains(nombreProducto)){
     * if(Usuario.getUsuarioSesion() == 1){
     * error += "<p class='responseError'>"+insert+" </p>";
     * }else{
     * error += "<p class='responseError'>-No se encuentra el producto "+nombreProducto+" en la linea "+num_emp+" </p>";
     * }
     * productosRepetidos.add(nombreProducto);
     * }
     * lineasValidas = false;
     * }
     * listaP.add(nombreProducto);
     * /*}else{
     * lineasValidas = false;
     * error += "<p class='responseError'>-Esta repetido el producto "+nombreProducto+" en la linea "+num_emp+" </p>";
     * }
     */

    /*
     * }else{
     * error += "<p class='responseError'>-No se encuentra el producto en la linea "+num_emp+" </p>";
     * lineasValidas = false;
     * }
     *
     *
     *
     * if(cuentaAnaliticaCodigo != null && !cuentaAnaliticaCodigo.isEmpty()){
     * String sqlCuentaAnalitica = "SELECT id " +
     * "FROM cuentas_analiticas " +
     * "WHERE UPPER(replace(replace(trim(codigo),' ','' ),'-','')) = :codigo";
     * rowCuentaAnalitica = Ebean.createSqlQuery(sqlCuentaAnalitica)
     * .setParameter("codigo", cuentaAnaliticaCodigo.toUpperCase().trim().replace(" ","").replace("-",""))
     * .findUnique();
     * if(rowCuentaAnalitica == null || rowCuentaAnalitica.isEmpty()){
     * error += "<p class='responseError'>-No se encuentra la cuenta analitica "+cuentaAnaliticaCodigo+" en la linea "+num_emp+" </p>";
     * lineasValidas = false;
     * }
     * }else{
     * error += "<p class='responseError'>-No se encuentra la cuenta analitica en la linea "+num_emp+" </p>";
     * lineasValidas = false;
     * }
     *
     * if(unidadDeMedida != null && !unidadDeMedida.isEmpty()){
     * String sqlUnidad = "SELECT id FROM udms WHERE UPPER(replace(trim(nombre),' ','' )) = :unidad";
     * rowUnidad = Ebean.createSqlQuery(sqlUnidad)
     * .setParameter("unidad", unidadDeMedida.toUpperCase().trim().replace(" ",""))
     * .findUnique();
     * if(rowUnidad == null || rowUnidad.isEmpty()){
     * error += "<p class='responseError'>-No se encuentra la unidad "+unidadDeMedida+" en la linea "+num_emp+" </p>";
     * lineasValidas = false;
     * }
     * }else{
     * error += "<p class='responseError'>-No se encuentra la unidad en la linea "+num_emp+" </p>";
     * lineasValidas = false;
     * }
     *
     * if(servicio != null && !servicio.isEmpty()){
     * String sqlServicio = "SELECT id FROM departamentos WHERE UPPER(replace(trim(nombre),' ','' )) = :servicio";
     * rowServicio = Ebean.createSqlQuery(sqlServicio)
     * .setParameter("servicio", servicio.toUpperCase().trim().replace(" ",""))
     * .findUnique();
     * if(rowServicio == null || rowServicio.isEmpty()){
     * error += "<p class='responseError'>-No se encuentra la servicio "+servicio+" en la linea "+num_emp+" </p>";
     * lineasValidas = false;
     * }
     * }else{
     * error += "<p class='responseError'>-No se encuentra el servicio en la linea "+num_emp+" </p>";
     * lineasValidas = false;
     * }
     *
     * if(lineasValidas){
     * OrdenLinea sl = new OrdenLinea();
     * sl.producto_id = rowProducto.getLong("id");
     * sl.cantidad = new BigDecimal(cantidad).setScale(2, BigDecimal.ROUND_HALF_UP);
     * sl.cuenta_analitica_id = (long) rowCuentaAnalitica.getInteger("id");
     * sl.precio = new BigDecimal(precio).setScale(2, BigDecimal.ROUND_HALF_UP);
     * sl.orden_id = idOrden;
     * sl.udm_id = (long) rowUnidad.getInteger("id");
     * sl.departamento_id = (long) rowServicio.getInteger("id");
     * sl.create_date = new Date();
     * //sl.c = (long) Usuario.getUsuarioSesion();
     * lsl.add(sl);
     * }
     *
     * cantidadDeRowProcesadas ++;
     * }
     *
     * if(lineasValidas){
     * for(OrdenLinea s : lsl){
     * List<OrdenLinea> sn = OrdenLinea.find.where().eq("producto_id",s.producto_id)
     * .eq("orden_id",s.orden_id).findList();
     * if(sn != null && sn.size() > 0){
     * for(OrdenLinea st : sn){
     * if(yaTieneLineas){
     * st.cantidad = s.cantidad;
     * }else{
     * st.cantidad = st.cantidad.add(s.cantidad);
     * }
     *
     * st.cuenta_analitica_id = s.cuenta_analitica_id;
     * st.precio = s.precio;
     * st.udm_id = s.udm_id;
     * st.departamento_id = s.departamento_id;
     * st.update();
     *
     * }
     * }else{
     * s.save();
     * }
     * }
     * ok += "<p class='responseOk'>- Se ha procesado correctamente el archivo. Se procesaron "+cantidadDeRowProcesadas+" lineas.</p>";
     * }
     * } else {
     * error += "<p class='responseError'>- No se encuentra el archivo a procesar.</p>";
     * }
     * }else{
     * error += "<p class='responseError'>- Solo se puede procesar cuando el estado de la solicitud es Borrador o en Curso.</p>";
     * }
     * }else{
     * error += "<p class='responseError'>- No se encuentra la solicitud</p>";
     * }
     * }catch(Exception e){
     *
     * }
     */
    ////////////////////////////////////
    try {
      if (idOrden != null) {
        Orden s1 = Orden.find.byId(idOrden);

        if (s1.estado_id == Estado.ORDEN_ESTADO_BORRADOR || s1.estado_id == Estado.ORDEN_ESTADO_ENCURSO) {
          if (upload != null) {
            // String fileName = upload.getFilename();
            // String contentType = upload.getContentType();
            File file = upload.getFile();

            FileInputStream input = new FileInputStream(file.getAbsolutePath());
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            int cantidadDeRowProcesadas = 0;
            List<OrdenLinea> lsl = new ArrayList<>();

            List<String> listaP = new ArrayList<>();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
              SqlRow rowProducto = null;
              SqlRow rowCuentaAnalitica = null;
              SqlRow rowUnidad = null;
              SqlRow rowServicio = null;

              row = sheet.getRow(i);

              if (row.getCell(0) != null) {
                int num_emp = (int) row.getCell(0).getNumericCellValue();

                String nombreProducto = row.getCell(1).getStringCellValue().toUpperCase().trim().replace(" ", "").replace("-", "").replace(".", "");
                String nombreProductoAInsertar = row.getCell(1).getStringCellValue();
                Double cantidad = row.getCell(2).getNumericCellValue();
                String cuentaAnaliticaCodigo = row.getCell(3).getStringCellValue();
                String unidadDeMedida = row.getCell(4).getStringCellValue();
                Double precio = row.getCell(5).getNumericCellValue();
                String precioAinsertar = (precio != 0) ? precio.toString() : "1";
                String servicio = row.getCell(6).getStringCellValue();

                String insert = "INSERT INTO productos(nombre,referencia,precio_coste,activo,categoria_id,"
                    + "tipo_producto_id, articulo_id, udm_id, cuenta_ingreso_id, cuenta_gasto_id,compra,venta) VALUES " + "('"
                    + nombreProductoAInsertar + "','" + nombreProductoAInsertar + "'," + precioAinsertar
                    + ",true,XXX,2, 1537, 1, 226,255,false,false);";

                if (nombreProducto != null && !nombreProducto.isEmpty()) {
                  if (!listaP.contains(nombreProducto)) {
                    // String sqlProducto = "SELECT id FROM productos WHERE UPPER(replace(replace(replace(trim(nombre),' ','' ),'-',''),'.','' )) =
                    // :nombre";
                    String sqlProducto = "SELECT id FROM productos WHERE slug = :nombre";
                    List<SqlRow> rp =
                        Ebean.createSqlQuery(sqlProducto).setParameter("nombre", nombreProducto.toUpperCase().trim().replace(" ", "")).findList();
                    for (SqlRow x : rp) {
                      rowProducto = x;
                    }

                    if (rowProducto == null || rowProducto.isEmpty()) {
                      error += "<p class='responseError'>-No se encuentra el producto " + nombreProducto + " en la linea " + num_emp + " </p>";
                      lineasValidas = false;
                    }
                    listaP.add(nombreProducto);
                  } else {
                    lineasValidas = false;
                    error += "<p class='responseError'>-Esta repetido el producto " + nombreProducto + " en la linea " + num_emp + " </p>";
                  }
                } else {
                  error += "<p class='responseError'>-No se encuentra el producto en la linea " + num_emp + " </p>";
                  lineasValidas = false;
                }

                /*
                 * if(cantidad == null ){
                 * error += "<p class='responseError'>-No se encuentra la cantidad en la linea "+num_emp+" </p>";
                 * lineasValidas = false;
                 * }
                 */

                if (cuentaAnaliticaCodigo != null && !cuentaAnaliticaCodigo.isEmpty()) {
                  String sqlCuentaAnalitica =
                      "SELECT id " + "FROM cuentas_analiticas " + "WHERE UPPER(replace(replace(trim(codigo),' ','' ),'-','')) = :codigo";
                  rowCuentaAnalitica = Ebean.createSqlQuery(sqlCuentaAnalitica)
                      .setParameter("codigo", cuentaAnaliticaCodigo.toUpperCase().trim().replace(" ", "").replace("-", ""))
                      .findUnique();
                  if (rowCuentaAnalitica == null || rowCuentaAnalitica.isEmpty()) {
                    error += "<p class='responseError'>-No se encuentra la cuenta analitica " + cuentaAnaliticaCodigo + " en la linea " + num_emp
                        + " </p>";
                    lineasValidas = false;
                  }
                } else {
                  error += "<p class='responseError'>-No se encuentra la cuenta analitica en la linea " + num_emp + " </p>";
                  lineasValidas = false;
                }

                if (unidadDeMedida != null && !unidadDeMedida.isEmpty()) {
                  String sqlUnidad = "SELECT id FROM udms WHERE UPPER(replace(trim(nombre),' ','' )) = :unidad";
                  rowUnidad =
                      Ebean.createSqlQuery(sqlUnidad).setParameter("unidad", unidadDeMedida.toUpperCase().trim().replace(" ", "")).findUnique();
                  if (rowUnidad == null || rowUnidad.isEmpty()) {
                    error += "<p class='responseError'>-No se encuentra la unidad " + unidadDeMedida + " en la linea " + num_emp + " </p>";
                    lineasValidas = false;
                  }
                } else {
                  error += "<p class='responseError'>-No se encuentra la unidad en la linea " + num_emp + " </p>";
                  lineasValidas = false;
                }

                if (servicio != null && !servicio.isEmpty()) {
                  String sqlServicio = "SELECT id FROM departamentos WHERE UPPER(replace(trim(nombre),' ','' )) = :servicio";
                  rowServicio =
                      Ebean.createSqlQuery(sqlServicio).setParameter("servicio", servicio.toUpperCase().trim().replace(" ", "")).findUnique();
                  if (rowServicio == null || rowServicio.isEmpty()) {
                    error += "<p class='responseError'>-No se encuentra la servicio " + servicio + " en la linea " + num_emp + " </p>";
                    lineasValidas = false;
                  }
                } else {
                  error += "<p class='responseError'>-No se encuentra el servicio en la linea " + num_emp + " </p>";
                  lineasValidas = false;
                }


                if (lineasValidas) {
                  OrdenLinea sl = new OrdenLinea();
                  sl.producto_id = rowProducto.getLong("id");
                  sl.cantidad = new BigDecimal(cantidad).setScale(2, BigDecimal.ROUND_HALF_UP);
                  sl.cuenta_analitica_id = (long) rowCuentaAnalitica.getInteger("id");
                  sl.precio = new BigDecimal(precio).setScale(2, BigDecimal.ROUND_HALF_UP);
                  sl.orden_id = idOrden;
                  sl.udm_id = (long) rowUnidad.getInteger("id");
                  sl.create_date = new Date();
                  sl.departamento_id = (long) rowServicio.getInteger("id");
                  // sl.c = (long) Usuario.getUsuarioSesion();
                  lsl.add(sl);
                }
                cantidadDeRowProcesadas++;
              }
            }

            if (lineasValidas) {
              for (OrdenLinea s : lsl) {
                List<OrdenLinea> sn = OrdenLinea.find.where().eq("producto_id", s.producto_id).eq("orden_id", s.orden_id).findList();
                if (sn != null && sn.size() > 0) {
                  for (OrdenLinea st : sn) {
                    st.cantidad = s.cantidad;
                    st.cuenta_analitica_id = s.cuenta_analitica_id;
                    st.precio = s.precio;
                    st.udm_id = s.udm_id;
                    st.update();
                  }
                } else {
                  s.save();
                }
              }
              ok += "<p class='responseOk'>- Se ha procesado correctamente el archivo. Se procesaron " + cantidadDeRowProcesadas + " lineas.</p>";
            }

          } else {
            error += "<p class='responseError'>- No se encuentra el archivo a procesar.</p>";
          }
        } else {
          error += "<p class='responseError'>- Solo se puede procesar cuando el estado de la orden es Borrador o en Curso.</p>";
        }
      } else {
        error += "<p class='responseError'>- No se encuentra la orden</p>";
      }
    } catch (Exception e) {
      play.Logger.error("excepcion", e);
      error += "<p class='responseError'>ERROR " + e + "</p>";
    }

    String ret = error + ok;
    return ok(ret);
  }

  public static Result modalImportarListaProductos() {
    return ok(modalImportarListaProductosCantidades.render(form().bindFromRequest()));
  }

  @CheckPermiso(key = "ordenesModificarNumeroFactura")
  public static Result modalModificarNumeroFactura(Long id) {

	Orden p = Orden.find.byId(id);

	return ok(modalModificarNumeroFactura.render(form().bindFromRequest(),id,p));
  }

  @CheckPermiso(key = "ordenesModificarNumeroFactura")
  public static Result modificarNumeroFactura() {
	DynamicForm d = form().bindFromRequest();
	d.discardErrors();

	String numero_factura =request().body().asFormUrlEncoded().get("numero_factura")[0];
	String monto =request().body().asFormUrlEncoded().get("monto")[0];
	Long id = new Long(request().body().asFormUrlEncoded().get("id")[0]);
	Orden f = Orden.find.byId(id);

	if(f.estado_id.compareTo((long) Estado.ORDEN_ESTADO_APROBADO) != 0) {
		flash("error", "La orden debe estar en Estado Aprobado.");
		return ok(modalModificarNumeroFactura.render(d,id,f));
	}

	if(f == null) {
		flash("error", "Esta orden no existe. Ver con el Administrador del sistema.");
		return ok(modalModificarNumeroFactura.render(d,id,f));
	}

	if(numero_factura.isEmpty()) {
		flash("error", "Ingrese un N° de Factura");
		return ok(modalModificarNumeroFactura.render(d,id,f));
	}

	if(monto.isEmpty()) {
		flash("error", "Ingrese un monto");
		return ok(modalModificarNumeroFactura.render(d,id,f));
	}




	if(Factura.existeNumeroFacturaCargadoDesdeOrden(f.id, numero_factura)) {
		flash("error", "Ya existe este numero de factura cargado.");
		return ok(modalModificarNumeroFactura.render(d,id,f));
	}


	BigDecimal montoACargar = new BigDecimal(monto.replace(",","."));
	BigDecimal montoCargado = Factura.getTotalMontoFacturasCargadas(f.id);
	BigDecimal montoTotal = montoCargado.add(montoACargar);

	if(montoTotal.compareTo(f.getTotalTotal()) > 0) {
		flash("error", "Los montos de facturas excede el monto de la orden.");
		return ok(modalModificarNumeroFactura.render(d,id,f));
	}


	ObjectNode result = Json.newObject();
	try {
		//Integer count = Pago.modificarNumeroFactura(numero_factura, id);
		List<Factura> ff = Factura.find.where().isNotNull("factura_principal_id").eq("orden_id", id).findList();
		Long idFact = null;

		if(ff.size() > 0) {

			idFact = ff.get(0).factura_principal_id;

		}else {
			ff = Factura.find.where().eq("orden_id", id).findList();
			if(ff.size() > 0) {
				idFact = ff.get(0).id;
			}

		}


		Orden.guardarNumeroFactura(ff.get(0).id,new BigDecimal(monto.replace(",",".")),numero_factura,id);

		result.put("success", true);
		flash("success", "Se actualizado el Numero de factura");
		result.put("html", modalModificarNumeroFactura.render(d,id,f).toString());
		return ok(result);
	} catch (Exception e){
		flash("error", "No se puede modificar los registros.");
		return ok(modalModificarNumeroFactura.render(d,id,f));
	}

  }

	public static Result modalPasarAuditado() {
		return ok(modalPasarAuditado.render(form().bindFromRequest()));
	}

	public static Result pasarAuditado() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> ordenesSeleccionados = getSeleccionados();

		if(ordenesSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una orden.");
			return ok(modalPasarAuditado.render(d));
		}

		if(d.hasErrors())
			return ok(modalPasarAuditado.render(d));

		boolean errorControl =  false;

		if(errorControl){
			flash("error", "error");
			return ok(modalPasarAuditado.render(d));
		}else{

			ObjectNode result = Json.newObject();
			try {
				Integer count = Orden.pasarAuditado( ordenesSeleccionados);

				result.put("success", true);
				flash("success", "Se actualizaron " + count + " registros de "+ ordenesSeleccionados.size() +" seleccionados.<br>");
				result.put("html", modalPasarAuditado.render(d).toString());
				return ok(result);
			} catch (Exception e){
				flash("error", "No se puede modificar los registros.");
				return ok(modalPasarAuditado.render(d));
			}
		}
	}

}
