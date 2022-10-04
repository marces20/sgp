package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.mail.EmailException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;

import play.Logger;
import play.db.ebean.Model;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.WS;
import play.libs.WS.WSRequestHolder;
import utils.DateUtils;
import utils.EmailUtilis;
import utils.pagination.Pagination;


@Entity
@Table(name = "inventario_rismi")
public class InventarioRismi extends Model {

  private static final long serialVersionUID = 1L;

  public String codigo;
  public String descripcion;
  public Integer numero_inventario;
  public String instrumento_legal;
  public String motivo_baja;
  public Integer numero_inventario_barra;
  public Date bi_producto_detalle_creado;
  public String numero_serie;
  public Integer sub_grupo;
  public Integer cuenta;
  public String nro_acta;
  public Date bi_fecha_alta_acta_fecha;
  public Date movimiento_cabecera_creado;
  public String movimiento_cabecera_numero_cargo;
  public String numero_expediente;
  public String bi_movimiento_cabecera_observacion;
  public String orden_provision;
  public String producto_nombre;
  public Date fecha_baja;
  public String param_condicion_producto;
  public String responsable;
  public BigDecimal precio;
  public String lugar;
  public String establecimiento;
  public String empresa;
  public Date fecha_carga;
  public Integer rismi_id;
  public Integer producto_id;


  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventario_rismi_id_seq")
  public Long id;

  public static Model.Finder<Long, InventarioRismi> find = new Finder<>(Long.class, InventarioRismi.class);

  public static Pagination<InventarioRismi> page(String producto, String responsable, String lugar, String numero_inventario) {


    String sql = "select TO_CHAR(max(fecha_carga)::DATE, 'yyyy-mm-dd') as fecha from inventario_rismi";
    SqlRow r = Ebean.createSqlQuery(sql).findUnique();
    InventarioRismi.findAll(r.getString("fecha"));

    Pagination<InventarioRismi> p = new Pagination<>();
    p.setOrderDefault("asc");
    p.setSortByDefault("producto_nombre");

    ExpressionList<InventarioRismi> e = find.where();

    if (!producto.isEmpty()) {
      e.ilike("producto_nombre", "%" + producto + "%");
    }

    if (!numero_inventario.isEmpty()) {
      e.eq("numero_inventario", Integer.parseInt(numero_inventario));
    }

    if (!responsable.isEmpty()) {
      e.ilike("responsable", "%" + responsable + "%");
    }

    if (!lugar.isEmpty()) {
      e.ilike("lugar", "%" + lugar + "%");
    }

    p.setExpressionList(e);
    return p;
  }

  public static boolean actualizarInventarioRismi() throws EmailException {

    String sql = "select TO_CHAR(max(fecha_carga)::DATE, 'yyyy-mm-dd') as fecha from inventario_rismi";
    SqlRow r = Ebean.createSqlQuery(sql).findUnique();
    InventarioRismi.findAll(r.getString("fecha"));


    EmailUtilis eu = new EmailUtilis();
    eu.setSubject("SE ACTUALIZO EL INVENTARI");
    eu.setHtmlMsg("SE ACTUALIZO EL INVENTARIO");
    eu.setFrom("marces2000@gmail.com");

    List<String> adds = new ArrayList<>();
    adds.add("marces2000@gmail.com");
    eu.setAdds(adds);
    eu.enviar();

    return true;
  }

  public static List<InventarioRismi> findAll(String fecha) {

    String accessToken = "c63e4bbc4f934e8ca9d154d230c5b8e2";

    // WSRequestHolder req =
    // WS.url("http://10.1.3.18/rismi2_hotfix/web/app_dev.php/api/bien_inventariable/producto/detalles/reporteinventario.json?fechaMovimientoDesde=2019-01-01");
    // WSRequestHolder req = WS.url("http://10.1.2.33/7.20.45/web/app.php/api/bien_inventariable/producto/detalles/reporteinventario.json");

    WSRequestHolder req = WS.url("http://10.1.2.33/rismi2/web/app.php/api/bien_inventariable/producto/detalles/reporteinventario.json");


    req.setHeader("Accept", "application/json");
    req.setHeader("Content-Type", "application/x-www-form-urlencoded");
    req.setHeader("Authorization", "Bearer " + accessToken);
    req.setQueryParameter("fechaMovimientoDesde", fecha);

    Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzz");
    // Promise<List<InventarioRismi>> jsonPromise = null;
    Promise<List<InventarioRismi>> jsonPromise = req.get().map(new Function<WS.Response, List<InventarioRismi>>() {

      @Override
      public List<InventarioRismi> apply(WS.Response response) {

        JsonNode data = response.asJson().get("data");
        List<InventarioRismi> listaInventario = new ArrayList<>();
        if (data != null) {


          for (JsonNode node : data) {

            InventarioRismi inventario = new InventarioRismi();
            inventario.codigo = (!node.get("codigo").isNull()) ? node.get("codigo").textValue() : null;
            inventario.descripcion = (!node.get("descripcion").isNull()) ? node.get("descripcion").textValue() : null;
            inventario.numero_inventario = (!node.get("numero_inventario").isNull()) ? node.get("numero_inventario").intValue() : null;
            inventario.instrumento_legal = (!node.get("instrumento_legal").isNull()) ? node.get("instrumento_legal").textValue() : null;
            inventario.motivo_baja = (!node.get("motivo_baja").isNull()) ? node.get("motivo_baja").textValue() : null;
            inventario.numero_inventario_barra =
                (!node.get("numero_inventario_barra").isNull()) ? node.get("numero_inventario_barra").intValue() : null;
            inventario.numero_serie = (!node.get("numero_serie").isNull()) ? node.get("numero_serie").textValue() : null;
            inventario.sub_grupo = (!node.get("sub_grupo").isNull()) ? node.get("sub_grupo").intValue() : null;
            inventario.cuenta = (!node.get("cuenta").isNull()) ? node.get("cuenta").intValue() : null;
            inventario.nro_acta = (!node.get("nro_acta").isNull()) ? node.get("nro_acta").textValue() : null;
            inventario.movimiento_cabecera_numero_cargo =
                (!node.get("movimiento_cabecera_numero_cargo").isNull()) ? node.get("movimiento_cabecera_numero_cargo").textValue() : null;
            inventario.numero_expediente = (!node.get("numero_expediente").isNull()) ? node.get("numero_expediente").textValue() : null;
            inventario.bi_movimiento_cabecera_observacion =
                (!node.get("bi_movimiento_cabecera_observacion").isNull()) ? node.get("bi_movimiento_cabecera_observacion").textValue() : null;
            inventario.orden_provision = (!node.get("orden_provision").isNull()) ? node.get("orden_provision").textValue() : null;
            inventario.producto_nombre = (!node.get("producto_nombre").isNull()) ? node.get("producto_nombre").textValue() : null;
            inventario.param_condicion_producto =
                (!node.get("param_condicion_producto").isNull()) ? node.get("param_condicion_producto").textValue() : null;

            String responsable = "";
            if (!node.get("responsable").isNull()) {
              responsable = node.get("responsable").textValue().substring(0, node.get("responsable").textValue().length() - 8);
            }
            inventario.responsable = responsable;
            inventario.precio = (!node.get("precio").isNull()) ? node.get("precio").decimalValue() : null;
            inventario.lugar = (!node.get("lugar").isNull()) ? node.get("lugar").textValue() : null;
            inventario.establecimiento = (!node.get("establecimiento").isNull()) ? node.get("establecimiento").textValue() : null;
            inventario.empresa = (!node.get("empresa").isNull()) ? node.get("empresa").textValue() : null;
            inventario.bi_producto_detalle_creado = (!node.get("bi_producto_detalle_creado").isNull())
                ? DateUtils.formatDate(node.get("bi_producto_detalle_creado").textValue(), "yyyy-MM-dd HH:mm:s")
                : null;
            inventario.bi_fecha_alta_acta_fecha = (!node.get("bi_fecha_alta_acta_fecha").isNull())
                ? DateUtils.formatDate(node.get("bi_fecha_alta_acta_fecha").textValue(), "yyyy-MM-dd HH:mm:s")
                : null;
            inventario.movimiento_cabecera_creado = (!node.get("movimiento_cabecera_creado").isNull())
                ? DateUtils.formatDate(node.get("movimiento_cabecera_creado").textValue(), "yyyy-MM-dd HH:mm:s")
                : null;
            inventario.fecha_baja =
                (!node.get("fecha_baja").isNull()) ? DateUtils.formatDate(node.get("fecha_baja").textValue(), "yyyy-MM-dd HH:mm:s") : null;
            inventario.fecha_carga = new Date();
            inventario.producto_id = (!node.get("id_producto").isNull()) ? node.get("id_producto").intValue() : null;


            Integer nv = (!node.get("numero_inventario").isNull()) ? node.get("numero_inventario").intValue() : null;
            Integer bv = (!node.get("numero_inventario_barra").isNull()) ? node.get("numero_inventario_barra").intValue() : null;
            String codigo = (!node.get("codigo").isNull()) ? node.get("codigo").textValue() : null;

            Logger.debug("numero_inventario000000000000: " + nv);
            Logger.debug("numero_inventario000000000000: " + bv);


            if (nv == null) {
              Logger.debug("No tiene numero de inventario codigo: " + codigo);
            } else {

              List<InventarioRismi> inventarioList = new ArrayList<>();

              if (bv != null) {
                inventarioList = InventarioRismi.find.where().eq("numero_inventario", nv).eq("numero_inventario_barra", bv).findList();
              } else {
                inventarioList = InventarioRismi.find.where().eq("numero_inventario", nv).isNull("numero_inventario_barra").findList();
              }

              if (inventarioList.size() > 0) {
                Logger.debug("UPDATE codigo: " + codigo);
                Logger.debug("UPDATE codigo: " + codigo);

                InventarioRismi xx = inventarioList.get(0);
                xx = inventario;
                xx.id = inventarioList.get(0).id;
                xx.update();


              } else {
                inventario.save();
                Logger.debug("INSERTO codigo: " + codigo);
              }
            }


            // listaInventario.add(inventario);
          }
        }
        return listaInventario;
      }
    });

    return jsonPromise.get(50000);


  }

}
