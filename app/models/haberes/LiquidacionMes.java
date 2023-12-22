package models.haberes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.mail.EmailException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.annotation.Formula;

import models.Estado;
import models.Expediente;
import models.OrdenPago;
import models.Periodo;
import models.Usuario;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.EmailUtilis;
import utils.NumeroALetra;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_meses")
public class LiquidacionMes extends Model {

  /*
   * SELECT haber.agente_id, haber.periodo_id, certificacion.total certificacion, haber.total sueldo from (
   *
   * SELECT p.agente_id, c.periodo_id, round(sum(precio * cantidad)::numeric,2) - sum(round((((precio*descuento)/100) * cantidad)::numeric)) total
   * FROM certificaciones c
   * INNER JOIN certificaciones_lineas cl ON c.id = cl.certificacion_id
   * INNER JOIN proveedores p ON p.id = c.proveedor_id
   * WHERE periodo_id = (select MAX(periodo_id) periodo_id from certificaciones) AND state_id = 31 AND expediente_id != 5922
   * GROUP BY p.agente_id,c.periodo_id
   *
   * ) certificacion
   *
   * inner join (
   *
   * select l.agente_id, lm.periodo_id, sum(h.total - r.total) total from liquidacion_puestos lp
   * left join (select liquidacion_puesto_id, sum(importe*cantidad) as total from liquidacion_detalles ld inner join liquidacion_conceptos lc on
   * ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(1,4,2) group by liquidacion_puesto_id) h on h.liquidacion_puesto_id =
   * lp.id
   * left join (select liquidacion_puesto_id, sum(importe*cantidad) as total from liquidacion_detalles ld inner join liquidacion_conceptos lc on
   * ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(3) group by liquidacion_puesto_id) r on r.liquidacion_puesto_id =
   * lp.id
   * inner join liquidacion_meses lm on lm.id = lp.liquidacion_mes_id
   * inner join puestos_laborales pl on pl.id = lp.puesto_laboral_id
   * inner join legajos l on l.id = pl.legajo_id
   * where lp.liquidacion_mes_id = 24
   * group by l.agente_id, lm.periodo_id
   *
   * ) haber
   * on certificacion.agente_id = haber.agente_id
   *
   */


  public static BigDecimal PATRONAL_OBRA_SOCIAL_PORCENTAJE = new BigDecimal(0.02);
  public static BigDecimal PATRONAL_JUBILACION_PORCENTAJE = new BigDecimal(0.07);

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liquidacion_meses_id_seq")
  public Long id;

  @Required(message = "Debe escribir una denominacion")
  public Integer nro_liquidacion_parque;

  @Formats.DateTime(pattern = "dd/MM/yyyy")
  @Required(message = "Requiere fecha")
  public Date fecha_liquidacion;

  @ManyToOne
  @JoinColumn(name = "periodo_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Periodo periodo;
  @Required(message = "Requiere un periodo")
  public Integer periodo_id;

  @ManyToOne
  @JoinColumn(name = "expediente_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Expediente expediente;
  @Required(message = "Requiere un expediente")
  public Integer expediente_id;

  @ManyToOne
  @JoinColumn(name = "orden_pago_id", referencedColumnName = "id", insertable = false, updatable = false)
  public OrdenPago ordenPago;
  public Long orden_pago_id;

  @Formats.DateTime(pattern = "dd/MM/yyyy")
  public Date fecha_orden_pago;

  @Formats.DateTime(pattern = "dd/MM/yyyy")
  public Date fecha_pago;

  @Formats.DateTime(pattern = "dd/MM/yyyy")
  public Date fecha_preliquidacion;

  @ManyToOne
  @JoinColumn(name = "liquidacion_tipo_id", referencedColumnName = "id", insertable = false, updatable = false)
  public LiquidacionTipo liquidacionTipo;
  @Required(message = "Requiere un tipo de liquidacion")
  public Integer liquidacion_tipo_id;

  public String comentario;
  @Required(message = "Requiere Titulo")
  public String titulo;

  @ManyToOne
  @JoinColumn(name = "estado_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Estado estado;
  public Long estado_id;

  @Required(message = "Seleccion si es convencion ministerio")
  public Boolean convenio_ministerio;

  @ManyToOne
  @JoinColumn(name = "expediente_aporte_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Expediente expedienteAporte;
  @Required(message = "Requiere un expediente de aporte")
  public Integer expediente_aporte_id;

  @ManyToOne
  @JoinColumn(name = "expediente_segurovida_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Expediente expedienteSeguroVida;
  @Required(message = "Requiere un expediente de Seguro Vida")
  public Integer expediente_segurovida_id;

  @ManyToOne
  @JoinColumn(name = "expediente_segurosepelio_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Expediente expedienteSeguroSepelio;
  @Required(message = "Requiere un expediente de Seguro Sepelio")
  public Integer expediente_segurosepelio_id;

  @ManyToOne
  @JoinColumn(name = "expediente_contribuciones_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Expediente expedienteContribuciones;
  @Required(message = "Requiere un expediente de contribuciones")
  public Integer expediente_contribuciones_id;

  @ManyToOne
  @JoinColumn(name = "create_usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Usuario create_usuario;
  @Column(name = "create_usuario_id")
  public Long create_usuario_id;

  public Date create_date;
  public Date write_date;

  @ManyToOne
  @JoinColumn(name = "write_usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Usuario write_usuario;
  @Column(name = "write_usuario_id")
  public Long write_usuario_id;

  @Transient
  public String nombreLiquidacion;

  public String getNombreLiquidacion() {

    String cm = (convenio_ministerio != null && convenio_ministerio) ? "Convenio" : "Parque";

    return nro_liquidacion_parque != null ? "N° " + nro_liquidacion_parque + " - " + cm : "";

  }

  @Formula(
      select = "_b${ta}.total_ca",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as total_ca from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(1,4) group by liquidacion_mes_id) as _b${ta} on _b${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_ca;

  @Formula(
      select = "_x${ta}.cant_lp",
      join = "left outer join (select liquidacion_mes_id, count(*) as cant_lp from liquidacion_puestos lp group by liquidacion_mes_id) as _x${ta} on _x${ta}.liquidacion_mes_id = ${ta}.id")
  public Integer cantidad_liquidaciones_puestos;

  public BigDecimal getTotalCA() {
    if (total_ca == null)
      return new BigDecimal(0);
    return total_ca;
  }

  @Formula(
      select = "_c${ta}.total_sa",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as total_sa from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(2) group by liquidacion_mes_id) as _c${ta} on _c${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_sa;

  public BigDecimal getTotalSA() {
    if (total_sa == null)
      return new BigDecimal(0);
    return total_sa;
  }

  @Formula(
      select = "_d${ta}.total_retencion",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as total_retencion from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(3) group by liquidacion_mes_id) as _d${ta} on _d${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_retencion;

  public BigDecimal getTotalRetenciones() {
    if (total_retencion == null)
      return new BigDecimal(0);
    return total_retencion;
  }

  @Formula(
      select = "_j${ta}.total_jubilacion",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as total_jubilacion from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(5,204) group by liquidacion_mes_id) as _j${ta} on _j${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_jubilacion;

  public BigDecimal getTotalJubilacion() {
    if (total_jubilacion == null)
      return new BigDecimal(0);
    return total_jubilacion;
  }

  @Formula(
      select = "_o${ta}.total_ob",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as total_ob from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(4,203) group by liquidacion_mes_id) as _o${ta} on _o${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_ob;

  public BigDecimal getTotalOs() {
    if (total_ob == null)
      return new BigDecimal(0);
    return total_ob;
  }

  @Formula(
      select = "_sp${ta}.total_seguro_sepelio",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as total_seguro_sepelio from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(7,206) group by liquidacion_mes_id) as _sp${ta} on _sp${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_seguro_sepelio;

  public BigDecimal getTotalSeguroSepelio() {
    if (total_seguro_sepelio == null)
      return new BigDecimal(0);
    return total_seguro_sepelio;
  }

  @Formula(
      select = "_sv${ta}.total_seguro_vida",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as total_seguro_vida from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(6,205) group by liquidacion_mes_id) as _sv${ta} on _sv${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_seguro_vida;

  public BigDecimal getTotalSeguroVida() {
    if (total_seguro_vida == null)
      return new BigDecimal(0);
    return total_seguro_vida;
  }

  @Formula(
      select = "_em${ta}.embargo",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as embargo from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(20,427,508,509) group by liquidacion_mes_id) as _em${ta} on _em${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_embargo;

  public BigDecimal getTotalEmbargo() {
    if (total_embargo == null)
      return new BigDecimal(0);
    return total_embargo;
  }

  @Formula(
      select = "_pr${ta}.prestafacil",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as prestafacil from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(466,488) group by liquidacion_mes_id) as _pr${ta} on _pr${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_prestafacil;

  public BigDecimal getTotalPrestafacil() {
    if (total_prestafacil == null)
      return new BigDecimal(0);
    return total_prestafacil;
  }

  @Formula(
      select = "_ip${ta}.iprodha",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as iprodha from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(718,719) group by liquidacion_mes_id) as _ip${ta} on _ip${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_iprodha;

  public BigDecimal getTotalIprodha() {
    if (total_iprodha == null)
      return new BigDecimal(0);
    return total_iprodha;
  }

  @Formula(
      select = "_ya${ta}.yacare",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as yacare from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(752,755) group by liquidacion_mes_id) as _ya${ta} on _ya${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_yacare;

  public BigDecimal getTotalYacare() {
    if (total_yacare == null)
      return new BigDecimal(0);
    return total_yacare;
  }

  @Formula(
      select = "_mm${ta}.mutual",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as mutual from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(751,754) group by liquidacion_mes_id) as _mm${ta} on _mm${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_mutual;

  public BigDecimal getTotalMutual() {
    if (total_mutual == null)
      return new BigDecimal(0);
    return total_mutual;
  }

  @Formula(
      select = "_cu${ta}.cuotamutual",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as cuotamutual from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(753,756) group by liquidacion_mes_id) as _cu${ta} on _cu${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_cuotamutual;

  public BigDecimal getTotalCuotaMutual() {
    if (total_cuotamutual == null)
      return new BigDecimal(0);
    return total_cuotamutual;
  }


  @Formula(
      select = "_ig${ta}.impuesto_ganancia",
      join = "left outer join (select liquidacion_mes_id, sum(round(importe*cantidad,2)) as impuesto_ganancia from liquidacion_puestos lp inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where ld.liquidacion_concepto_id in(562,548,584,591,642,648,827) group by liquidacion_mes_id) as _ig${ta} on _ig${ta}.liquidacion_mes_id = ${ta}.id")
  public BigDecimal total_impuesto_ganancia;

  public BigDecimal getTotalImpuestoGanancia() {
    if (total_impuesto_ganancia == null)
      return new BigDecimal(0);
    return total_impuesto_ganancia;
  }

  public BigDecimal getTotalACobrar() {
    return getTotalCA().add(getTotalSA()).subtract(getTotalRetenciones());
  }

  public BigDecimal getContribucionesPatronalesObraSocial() {
    BigDecimal porcentaje_patronal_ob = new BigDecimal(0);
    if (periodo_id != null
        && (liquidacion_tipo_id.compareTo((int) LiquidacionTipo.AYUDA_ESCOLAR) != 0 && liquidacion_tipo_id.compareTo((int) LiquidacionTipo.SAC) != 0)
        && (getTotalOs().compareTo(BigDecimal.ZERO) > 0)) {
      porcentaje_patronal_ob = Periodo.find.byId((long) periodo_id).getPatronalObraSocialPorcentaje().divide(new BigDecimal(100));
    }
    return getTotalCA().multiply(porcentaje_patronal_ob).setScale(2, BigDecimal.ROUND_HALF_UP);
  }

  public BigDecimal getContribucionesPatronalesJubilacion() {
    BigDecimal porcentaje_patronal_jub = new BigDecimal(0);
    if (periodo_id != null && getTotalJubilacion().compareTo(BigDecimal.ZERO) > 0
        && (liquidacion_tipo_id.compareTo((int) LiquidacionTipo.AYUDA_ESCOLAR) != 0)) {
      porcentaje_patronal_jub = Periodo.find.byId((long) periodo_id).getPatronalJubilacionPorcentaje().divide(new BigDecimal(100));
    }
    return getTotalCA().multiply(porcentaje_patronal_jub).setScale(2, BigDecimal.ROUND_HALF_UP);
  }

  public BigDecimal getSubTotalAPagar() {// SIN PATRONALES SERIA
    return getTotalRetenciones().add(getTotalACobrar());
  }

  public String getSubTotalAPagarLetra() {
    return NumeroALetra.convertNumberToLetterBigDecimal(this.getSubTotalAPagar());
  }

  public BigDecimal getSubTotalAPagarOP() {// SIN PATRONALES SERIA
    return getTotalEmbargo().add(getTotalACobrar());
  }

  public String getSubTotalAPagarLetraOP() {
    return NumeroALetra.convertNumberToLetterBigDecimal(this.getSubTotalAPagarOP());
  }

  public BigDecimal getTotalACobrarOP() {
    return getSubTotalAPagarOP().subtract(getTotalEmbargo());
  }

  public BigDecimal getTotalAPagar() {
    return getTotalRetenciones().add(getTotalACobrar()).add(getContribucionesPatronalesObraSocial()).add(getContribucionesPatronalesJubilacion());
  }

  public static Model.Finder<Long, LiquidacionMes> find = new Model.Finder<>(Long.class, LiquidacionMes.class);

  public static Pagination<LiquidacionMes> page(String nro_liquidacion_parque, String expediente_id, String periodo_id,
      String numero_orden_pago_desde, String numero_orden_pago_hasta, String fecha_pago_desde, String fecha_pago_hasta, String cm) {

    Pagination<LiquidacionMes> p = new Pagination<>();
    p.setOrderDefault("DESC");
    p.setSortByDefault("id");

    ExpressionList<LiquidacionMes> e = find.select("id, nro_liquidacion_parque, titulo, convenio_ministerio, total_ca, total_sa, total_retencion")

        .fetch("estado", "id, nombre")
        .fetch("expediente", "nombre")
        .fetch("expediente.ejercicio", "nombre")
        .fetch("expediente.parent.ejercicio", "nombre")
        .fetch("periodo", "nombre")
        .where();

    if (!nro_liquidacion_parque.isEmpty()) {
      e.eq("nro_liquidacion_parque", Integer.parseInt(nro_liquidacion_parque));
    }

    if (!expediente_id.isEmpty()) {
      e = e.disjunction();
      e = e.eq("expediente_id", Integer.parseInt(expediente_id));
      e = e.eq("expediente_aporte_id", Integer.parseInt(expediente_id));
      e = e.eq("expediente_segurovida_id", Integer.parseInt(expediente_id));
      e = e.eq("expediente_segurosepelio_id", Integer.parseInt(expediente_id));
      e = e.eq("expediente_contribuciones_id", Integer.parseInt(expediente_id));
      e = e.endJunction();
    }

    if (!periodo_id.isEmpty()) {
      e.eq("periodo_id", Integer.parseInt(periodo_id));
    }

    if (!numero_orden_pago_desde.isEmpty()) {
      e.ge("ordenPago.numero", Integer.parseInt(numero_orden_pago_desde));
    }
    if (!numero_orden_pago_hasta.isEmpty()) {
      e.le("ordenPago.numero", Integer.parseInt(numero_orden_pago_hasta));
    }

    if (!fecha_pago_desde.isEmpty()) {
      Date fod = DateUtils.formatDate(fecha_pago_desde, "dd/MM/yyyy");
      e.ge("fecha_pago", fod);
    }

    if (!fecha_pago_hasta.isEmpty()) {
      Date foh = DateUtils.formatDate(fecha_pago_hasta, "dd/MM/yyyy");
      e.le("fecha_pago", foh);
    }

    if (!cm.isEmpty()) {
      if (cm.compareToIgnoreCase("SI") == 0) {
        e.eq("convenio_ministerio", true);
      } else {
        e.eq("convenio_ministerio", false);
      }
    }

    p.setExpressionList(e);
    return p;
  }

  public List<LiquidacionMes> getDataSuggest(String input, Integer limit) {
    Integer i = new Integer(input);
    List<LiquidacionMes> l = find.select("id, nro_liquidacion_parque,convenio_ministerio")
        .where()
        .eq("nro_liquidacion_parque", i)
        .setMaxRows(limit)
        .orderBy("nro_liquidacion_parque")
        .findList();

    return l;
  }

  public static boolean preliquidarEspera() throws EmailException {
    Logger.debug("ENTRA EN preliquidarEspera");
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    PreparedStatement stmt2 = null;
    ResultSet rs2 = null;

    PreparedStatement stmt3 = null;
    ResultSet rs3 = null;

    // Long ret = new Long(0);
    String r = "";

    actualizarVistaMaterializadaPuestosLaborales();

    try {

      conn = play.db.DB.getConnection();

      List<LiquidacionMes> lm =
          LiquidacionMes.find.where().isNull("fecha_preliquidacion").eq("estado_id", Estado.LIQUIDACION_MES_PRELIQUIDAR).orderBy("id asc").findList();
      int x = 0;
      for (LiquidacionMes lmx : lm) {


        if (x == 0) {
          String c = (lmx.convenio_ministerio) ? "CONVENIO" : "PARQUE";
          EmailUtilis eu = new EmailUtilis();
          eu.setSubject("LIQUIDACION EMPIEZA:" + lmx.nro_liquidacion_parque + "-" + c);
          eu.setHtmlMsg("LIQUIDACION EMPIEZA:" + lmx.nro_liquidacion_parque + "-" + c);
          eu.setFrom("marces2000@gmail.com");

          List<String> adds = new ArrayList<>();
          adds.add("marces2000@gmail.com");
          eu.setAdds(adds);
          eu.enviar();

        }


        /*
         * Logger.debug("RECORRIENDO LIQUIDACIONES");
         * stmt = conn.prepareStatement("SELECT pl.id as id " +
         * "			FROM puestos_laborales pl JOIN legajos l on pl.legajo_id = l.id JOIN agentes a ON l.agente_id = a.id " +
         * "			JOIN proveedores p ON p.agente_id = a.id "+
         * "			JOIN cuenta_bancarias cb ON cb.proveedor_id = p.id " +
         * "			JOIN ( " +
         * "				SELECT ln.puesto_laboral_id, count(ln.id) cantidad " +
         * "				FROM liquidacion_novedades ln  " +
         * "				WHERE ? BETWEEN ln.periodo_desde_id AND ln.periodo_hasta_id " +
         * "				AND ln.liquidacion_tipo_id = ? " +
         * "				GROUP BY ln.puesto_laboral_id " +
         * "				) AS liq_nov ON liq_nov.puesto_laboral_id = pl.id " +
         * "			WHERE cb.estado_id IN (36) AND pl.convenio_ministerio = ?  AND (pl.activo IS TRUE) ");
         *
         * stmt.setInt(1, lmx.periodo_id);
         * stmt.setInt(2, lmx.liquidacion_tipo_id);
         * stmt.setBoolean(3, lmx.convenio_ministerio);
         * rs = stmt.executeQuery();
         *
         *
         * int liquidados = 0;
         * while (rs.next()) {
         * Logger.debug("RECORRIENDO PUESTOS");
         * stmt2 = conn.prepareStatement("SELECT pre_liquidacion(?,?)");
         * stmt2.setInt(1, lmx.id.intValue());
         * stmt2.setInt(2, rs.getInt("id"));
         * rs2 = stmt2.executeQuery();
         * liquidados ++;
         *
         *
         * }
         */
        /*
         * String liquidados = "0";
         * stmt2 = conn.prepareStatement("SELECT pre_liquidacion(?)");
         * stmt2.setInt(1, lmx.id.intValue());
         * rs2 = stmt2.executeQuery();
         *
         * while (rs2.next()) {
         * liquidados = rs2.getString(1).split("xx")[0];
         * }
         */

        Logger.debug("RECORRIENDO LIQUIDACIONES");

        stmt = conn.prepareStatement(
            "SELECT pl.id as pid, pl.convenio_ministerio, a.organigrama_id " + "FROM puestos_laborales pl " + "JOIN legajos l on pl.legajo_id = l.id "
                + "JOIN agentes a ON l.agente_id = a.id " + "WHERE (pl.activo = TRUE) AND pl.convenio_ministerio = ? ORDER BY pl.id");


        stmt.setBoolean(1, lmx.convenio_ministerio);
        rs = stmt.executeQuery();
        int liquidados = 0;
        while (rs.next()) {
          Logger.debug("EMPIEZA PUESTO ID: " + rs.getInt("pid"));

          stmt2 = conn.prepareStatement("SELECT pre_liquidacion(?,?)");
          stmt2.setInt(1, lmx.id.intValue());
          stmt2.setInt(2, rs.getInt("pid"));
          rs2 = stmt2.executeQuery();


          String ret = "";
          while (rs2.next()) {
            ret = rs2.getString(1);

            if(!ret.contains("0xx")) {
            //if (ret.compareTo("0xx") != 0) {
              liquidados++;
              x++;
              Logger.debug("TERMINA PUESTO ID: " + rs.getInt("pid"));
            }
          }

          Logger.debug("valor x: " + x);
          if (x == 500 || x == 1000 || x == 1500 || x == 2000 || x == 2500) {


            String c = (lmx.convenio_ministerio) ? "CONVENIO" : "PARQUE";
            EmailUtilis eu = new EmailUtilis();
            eu.setSubject("LIQUIDACION:" + lmx.nro_liquidacion_parque + "-" + c + " VA POR EL NUMERO: " + x);
            eu.setHtmlMsg("LIQUIDACION:" + lmx.nro_liquidacion_parque + "-" + c + " VA POR EL NUMERO: " + x);
            eu.setFrom("marces2000@gmail.com");

            List<String> adds = new ArrayList<>();
            adds.add("marces2000@gmail.com");
            eu.setAdds(adds);
            eu.enviar();


          }
        }

        EmailUtilis eu = new EmailUtilis();
        String c = (lmx.convenio_ministerio) ? "CONVENIO" : "PARQUE";
        eu.setSubject("LIQUIDACION TERMINA:" + lmx.nro_liquidacion_parque + "-" + c + " TOTAL NUMERO: " + x);
        eu.setHtmlMsg("LIQUIDACION TERMINA:" + lmx.nro_liquidacion_parque + "-" + c + " TOTAL NUMERO: " + x);
        eu.setFrom("marces2000@gmail.com");

        List<String> adds = new ArrayList<>();
        adds.add("marces2000@gmail.com");
        eu.setAdds(adds);
        eu.enviar();


        x = 0;


        stmt3 = conn.prepareStatement("SELECT pl.id as id,a.apellido as nombre "
            + "			FROM puestos_laborales pl JOIN legajos l on pl.legajo_id = l.id JOIN agentes a ON l.agente_id = a.id "
            + "			JOIN proveedores p ON p.agente_id = a.id " + "			JOIN cuenta_bancarias cb ON cb.proveedor_id = p.id " + "			JOIN ( "
            + "				SELECT ln.puesto_laboral_id, count(ln.id) cantidad " + "				FROM liquidacion_novedades ln  "
            + "				WHERE ? BETWEEN ln.periodo_desde_id AND ln.periodo_hasta_id " + "				AND ln.liquidacion_tipo_id = ? "
            + "				GROUP BY ln.puesto_laboral_id " + "				) AS liq_nov ON liq_nov.puesto_laboral_id = pl.id "
            + "			WHERE cb.estado_id NOT IN (36) AND pl.convenio_ministerio = ?  AND (pl.activo IS TRUE) ");

        stmt3.setInt(1, lmx.periodo_id);
        stmt3.setInt(2, lmx.liquidacion_tipo_id);
        stmt3.setBoolean(3, lmx.convenio_ministerio);
        rs3 = stmt3.executeQuery();

        int noLiquidados = 0;
        String agentesNoLiqui = "";
        while (rs3.next()) {

          agentesNoLiqui += rs3.getString("nombre") + "<br>";
          noLiquidados++;
        }

        r = "TOTAL PUESTOS LIQUIDADOS:" + liquidados + " <br><br>";
        r += "<br>----------------------------------------------<br>";
        r += "PUESTOS SIN CUENTA APROBADA<br>";
        r += agentesNoLiqui;
        r += "<br>----------------------------------------------<br>";
        r += "USUARIO:AUTOMATICO<br>";


        lmx.fecha_preliquidacion = new Date();
        lmx.estado_id = (long) Estado.LIQUIDACION_MES_BORRADOR;
        lmx.save();
        Logger.debug("SE GRABA LA FECHA EN LA LIQUIDACION PARA QUE NO SE PRELIQUIDE MAS");


        eu = new EmailUtilis();
        c = (lmx.convenio_ministerio) ? "CONVENIO" : "PARQUE";
        eu.setSubject("LIQUIDACION LIQUIDADA:" + lmx.nro_liquidacion_parque + "-" + c);
        eu.setHtmlMsg(r);
        eu.setFrom("marces2000@gmail.com");


        eu.setAdds(adds);
        eu.enviar();

        Logger.debug("FIN preliquidarEspera");

      }
      return true;
      // return false;

    } catch (SQLException e) {
      Logger.error("Error duplicar: " + e);
    } finally {
      if (stmt != null)
        try {
          stmt.close();
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
    return true;
  }


  public Long preliquidar(Long id, String host) throws EmailException {
    Logger.debug("22222222222");
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Long ret = new Long(0);
    String r = "";
    try {
      Logger.debug("bbbbbbbbbbbbb");
      conn = play.db.DB.getConnection();

      stmt = conn.prepareStatement("SELECT pre_liquidacion(?)");
      stmt.setInt(1, id.intValue());
      rs = stmt.executeQuery();

      if (rs.next()) {
        r = rs.getString(1);

        String[] a = r.split("xx");
        String liquidados = a[0];

        r = "TOTAL PUESTOS LIQUIDADOS:" + liquidados + " <br><br>";

        if (a.length > 1) {
          String[] noLiquidados = a[1].split("@");

          r += "PUESTOS SIN CUENTA APROBADA<br>";
          for (String x : noLiquidados) {
            PuestoLaboral pl = PuestoLaboral.find.byId(new Long(x));
            r += pl.legajo.agente.apellido + "<br>";
          }
        }
        r += "<br>----------------------------------------------<br>";
        r += "USUARIO:" + Usuario.getUsurioSesion().nombre + "<br>";
        r += "HOST:" + host + "<br>";


        EmailUtilis eu = new EmailUtilis();
        String c = (convenio_ministerio) ? "CONVENIO" : "PARQUE";
        eu.setSubject("LIQUIDACION LIQUIDADA:" + nro_liquidacion_parque + "-" + c);
        eu.setHtmlMsg(r);
        eu.setFrom("marces2000@gmail.com");

        List<String> adds = new ArrayList<>();
        adds.add("marces2000@gmail.com");
        adds.add("palaciosmatias@gmail.com");
        adds.add("laliviales@gmail.com");
        eu.setAdds(adds);
        eu.enviar();

      }

      LiquidacionMes lmx = LiquidacionMes.find.byId(id);
      lmx.estado_id = (long) Estado.LIQUIDACION_MES_LIQUIDADO;
      lmx.save();

    } catch (SQLException e) {
      Logger.error("Error duplicar: " + e);
    } finally {
      if (stmt != null)
        try {
          stmt.close();
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

    return ret;
  }

  /*
   * public Integer preliquidar2(Long id){
   *
   * String sql = "SELECT pl.id as puesto_id, a.organigrama_id " +
   * "FROM puestos_laborales pl JOIN legajos l on pl.legajo_id = l.id JOIN agentes a ON l.agente_id = a.id " +
   * "WHERE (pl.activo = TRUE) AND pl.convenio_ministerio = false order by pl.id LIMIT 100 OFFSET 700 ";
   *
   * SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
   *
   * List<SqlRow> row = sqlQuery.findList();
   * int x = 0;
   * for(SqlRow sx :row) {
   *
   * preliquidar(sx.getLong("puesto_id"),id);
   * x++;
   * Logger.debug("xxxx "+x+" - "+sx.getLong("puesto_id"));
   * }
   *
   * Logger.debug("fiiiiiiinn "+x);
   * return x;
   * }
   */

  public static boolean controlLiquidacionesActivas() {
    ResultSet rssi = null;
    PreparedStatement stmtsi = null;
    Connection conn2 = null;
    PreparedStatement stmt2 = null;
    ResultSet rs2 = null;
    boolean ret = false;

    try {
      conn2 = play.db.DB.getConnection();

      stmtsi = conn2.prepareStatement("SELECT * from control_liquidaciones where estado = false");
      rssi = stmtsi.executeQuery();

      if (rssi.next()) {
        ret = true;
      }


    } catch (SQLException e) {
      Logger.error("Error duplicar: " + e);
    } finally {
      if (stmt2 != null)
        try {
          stmt2.close();
        } catch (Exception e) {
        }
      if (stmtsi != null)
        try {
          stmtsi.close();
        } catch (Exception e) {
        }
      if (rssi != null)
        try {
          rssi.close();
        } catch (Exception e) {
        }
      if (conn2 != null)
        try {
          conn2.close();
        } catch (Exception e) {
        }
    }

    return ret;
  }

  public int controlLiquidacion(Long idPuestoLaboral, Long idLiquidacionMes) {
    ResultSet rssi = null;
    PreparedStatement stmtsi = null;
    Connection conn2 = null;
    PreparedStatement stmt2 = null;
    ResultSet rs2 = null;
    int idcl = 0;

    try {
      conn2 = play.db.DB.getConnection();


      stmtsi = conn2.prepareStatement("SELECT nextval('control_liquidaciones_id_seq')");
      rssi = stmtsi.executeQuery();

      if (rssi.next()) {
        idcl = rssi.getInt(1);
      }

      stmt2 = conn2.prepareStatement(
          "INSERT INTO control_liquidaciones(id, liquidacion_mes_id, liquidacion_puesto_id, usuario_id, hora,estado) VALUES (?, ?, ?, ?, now(), ?)");
      stmt2.setInt(1, idcl);
      stmt2.setInt(2, idLiquidacionMes.intValue());
      stmt2.setInt(3, idPuestoLaboral.intValue());
      stmt2.setInt(4, Usuario.getUsuarioSesion());
      stmt2.setBoolean(5, false);
      stmt2.executeUpdate();

    } catch (SQLException e) {
      Logger.error("Error duplicar: " + e);
    } finally {
      if (stmt2 != null)
        try {
          stmt2.close();
        } catch (Exception e) {
        }
      if (stmtsi != null)
        try {
          stmtsi.close();
        } catch (Exception e) {
        }
      if (rssi != null)
        try {
          rssi.close();
        } catch (Exception e) {
        }
      if (conn2 != null)
        try {
          conn2.close();
        } catch (Exception e) {
        }
    }

    return idcl;
  }

  public Long preliquidar(Long idPuestoLaboral, Long idLiquidacionMes, int idControl) throws SQLException {
    Logger.debug("22222222222");
    Connection conn = null;
    PreparedStatement stmt = null;
    PreparedStatement stmtx = null;
    ResultSet rs = null;

    Long ret = new Long(0);
    conn = play.db.DB.getConnection();
    try {

      Logger.debug("bbbbbbbbbbbbb " + idPuestoLaboral + " - " + idLiquidacionMes);


      stmt = conn.prepareStatement("SELECT pre_liquidacion(?,?)");
      stmt.setInt(1, idLiquidacionMes.intValue());
      stmt.setInt(2, idPuestoLaboral.intValue());
      rs = stmt.executeQuery();

      if (rs.next()) {
        ret = (long) rs.getInt(1);
      }


    } catch (SQLException e) {

      Logger.error("Error duplicar: " + e);
    } finally {
      stmtx = conn.prepareStatement("UPDATE control_liquidaciones SET estado = true WHERE id = ?");
      stmtx.setInt(1, idControl);
      stmtx.executeUpdate();
      if (stmt != null)
        try {
          stmt.close();
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

    return ret;
  }

  public static List<SqlRow> getDataPorConcepto(Long idLiquidacion) {

    String sql =
        "SELECT count(*) cantidad,round(sum(ld.cantidad),0) totalCantidad,sum(round(ld.cantidad*ld.importe,2)) importe,lc.id as id,lc.codigo codigo,lc.denominacion deno,lc.liquidacion_concepto_tipo_id tipo "
            + "FROM liquidacion_detalles ld " + "INNER JOIN liquidacion_puestos lp ON ld.liquidacion_puesto_id = lp.id "
            + "INNER JOIN liquidacion_conceptos lc ON lc.id = ld.liquidacion_concepto_id " + "WHERE lp.liquidacion_mes_id = :idLiquidacion "
            + "GROUP BY lc.id,lc.codigo,lc.denominacion,lc.liquidacion_concepto_tipo_id " + "ORDER BY lc.codigo";

    List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("idLiquidacion", idLiquidacion).findList();

    return s;
  }

  public static List<SqlRow> getCostoTotalPorEscala(Long idPeriodo, boolean cm) {
    Periodo p = Periodo.find.byId(idPeriodo);

    String sql = "SELECT round(sum(ld.cantidad*ld.importe),2) monto ,el.nombre nombre,el.id escala_id " + " 	FROM puestos_laborales pl "
        + " 	INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id "
        + " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "
        + " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "
        + " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " + " 	WHERE lm.periodo_id = :periodo_id "
        + " 	AND lm.convenio_ministerio =  :cm AND lm.liquidacion_tipo_id in(1,4) " + " 	GROUP BY lm.convenio_ministerio,el.nombre,el.id "
        + "	ORDER BY el.id ASC";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("periodo_id", p.id);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;
  }

  public static List<SqlRow> getCostoTotalPorEscalaNew(Long idPeriodo, boolean cm) {
    Periodo p = Periodo.find.byId(idPeriodo);

    String sql = "SELECT round(sum(ld.cantidad*ld.importe),2) monto ,el.nombre nombre,el.id escala_id " + " 	FROM puestos_laborales pl "
        + " 	INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id "
        + " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "
        + " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "
        + " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " + " 	WHERE " +
        // + "lm.periodo_id = :periodo_id "+
        "  lm.fecha_pago BETWEEN :date_start AND :date_stop " + "  AND (lm.estado_id = :estado_id or lm.estado_id = :estado_cerrado_id) "
        + " 	AND lm.convenio_ministerio =  :cm  " + " 	GROUP BY lm.convenio_ministerio,el.nombre,el.id " + "	ORDER BY el.id ASC";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    // sqlQuery.setParameter("periodo_id",p.id);
    sqlQuery.setParameter("date_start", p.date_start);
    sqlQuery.setParameter("date_stop", p.date_stop);
    sqlQuery.setParameter("estado_id", Estado.LIQUIDACION_MES_APROBADO);
    sqlQuery.setParameter("estado_cerrado_id", Estado.LIQUIDACION_MES_CERRADA);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;
  }

  public static List<SqlRow> getCostoTotalPorClasificacionConceptoNew(Long idPeriodo, boolean cm) {
    Periodo p = Periodo.find.byId(idPeriodo);

    String sql = "SELECT round(sum(ld.cantidad*ld.importe),2) monto ,lcc.nombre nombre,lcc.id clasificacion_id  " + " 	FROM puestos_laborales pl "
        + " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "
        + " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "
        + " 	inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "
        + " 	inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "
        + " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " + " 	WHERE " +
        // "lm.periodo_id = :periodo_id "+
        "   lm.fecha_pago BETWEEN :date_start AND :date_stop " + "   AND (lm.estado_id = :estado_id or lm.estado_id = :estado_cerrado_id) "
        + " 	AND lm.convenio_ministerio =  :cm " + " 	GROUP BY lm.convenio_ministerio,lcc.nombre,lcc.id  ORDER BY lcc.id  ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    // sqlQuery.setParameter("periodo_id",p.id);
    sqlQuery.setParameter("date_start", p.date_start);
    sqlQuery.setParameter("date_stop", p.date_stop);
    sqlQuery.setParameter("estado_id", Estado.LIQUIDACION_MES_APROBADO);
    sqlQuery.setParameter("estado_cerrado_id", Estado.LIQUIDACION_MES_CERRADA);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;
  }


  public static List<SqlRow> getCostoTotalPorClasificacionConcepto(Long idPeriodo, boolean cm) {
    Periodo p = Periodo.find.byId(idPeriodo);

    String sql = "SELECT round(sum(ld.cantidad*ld.importe),2) monto ,lcc.nombre nombre " + " 	FROM puestos_laborales pl "
        + " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "
        + " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "
        + " 	inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "
        + " 	inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "
        + " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " + " 	WHERE lm.periodo_id = :periodo_id "
        + " 	AND lm.convenio_ministerio =  :cm AND lm.liquidacion_tipo_id in(1,4) " + " 	GROUP BY lm.convenio_ministerio,lcc.nombre ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("periodo_id", p.id);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;
  }


  public static List<SqlRow> getTotalesPorTipoConcepto(Long idPeriodo) {
    Periodo p = Periodo.find.byId(idPeriodo);

    String sql =
        " select " + " t.convenio_ministerio, " + " t.liquidacion_tipo_id, " + " sum(t.total_ca) total_ca,  " + " sum(t.total_sa) total_sa,  "
            + " sum(t.total_retencion) total_retencion " + " from( " + " select  " + " lm.convenio_ministerio, " + " lm.liquidacion_tipo_id, "
            + " CASE WHEN liquidacion_concepto_tipo_id in (1,4) THEN sum(round(importe*cantidad,2)) ELSE SUM(0) END as total_ca, "
            + " CASE WHEN liquidacion_concepto_tipo_id = 2 THEN sum(round(importe*cantidad,2)) ELSE SUM(0) END as total_sa, "
            + " CASE WHEN liquidacion_concepto_tipo_id = 3 THEN sum(round(importe*cantidad,2)) ELSE SUM(0) END as total_retencion "
            + " from liquidacion_puestos lp " + " inner join liquidacion_detalles ld on ld.liquidacion_puesto_id = lp.id "
            + " inner join liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id "
            + " INNER JOIN liquidacion_meses lm ON lm.id = lp.liquidacion_mes_id  " + " where " +
            // + "lm.periodo_id = :periodo_id and "+
            " lm.fecha_pago BETWEEN :date_start AND :date_stop " + " AND (lm.estado_id = :estado_id or lm.estado_id = :estado_cerrado_id) "
            + " AND liquidacion_concepto_tipo_id in (1,2,3,4)  "
            + " group by   liquidacion_concepto_tipo_id,lm.convenio_ministerio,lm.liquidacion_tipo_id "
            + " ) t  group by t.convenio_ministerio,t.liquidacion_tipo_id ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    // sqlQuery.setParameter("periodo_id",p.id);
    sqlQuery.setParameter("date_start", p.date_start);
    sqlQuery.setParameter("date_stop", p.date_stop);
    sqlQuery.setParameter("estado_id", Estado.LIQUIDACION_MES_APROBADO);
    sqlQuery.setParameter("estado_cerrado_id", Estado.LIQUIDACION_MES_CERRADA);
    List<SqlRow> rows = sqlQuery.findList();

    return rows;

  }

  public static List<SqlRow> getCostoTotalPorTipoConceptoNew(Long idPeriodo, boolean cm) {
    Periodo p = Periodo.find.byId(idPeriodo);
    String sql = " SELECT round(sum(ld.cantidad*ld.importe),2) monto, lc.liquidacion_concepto_tipo_id tipo,lct.nombre tipo_concepto "
        + " 	FROM puestos_laborales pl " + " 	INNER JOIN liquidacion_puestos lp ON pl.id = lp.puesto_laboral_id "
        + " 	INNER JOIN liquidacion_detalles ld ON lp.id = ld.liquidacion_puesto_id "
        + " 	INNER JOIN liquidacion_conceptos lc ON ld.liquidacion_concepto_id = lc.id "
        + " 	INNER JOIN liquidacion_concepto_tipos lct on lct.id = lc.liquidacion_concepto_tipo_id "
        + " 	INNER JOIN liquidacion_meses lm ON lm.id = lp.liquidacion_mes_id " + " 	WHERE " +
        // + "lm.periodo_id = :periodo_id "+
        " 	lm.fecha_pago BETWEEN :date_start AND :date_stop " + " 	AND (lm.estado_id = :estado_id or lm.estado_id = :estado_cerrado_id) "
        + " 	AND lm.convenio_ministerio =  :cm "
        + " 	GROUP BY lm.convenio_ministerio,lc.liquidacion_concepto_tipo_id,lct.nombre order by lc.liquidacion_concepto_tipo_id ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    // sqlQuery.setParameter("periodo_id",p.id);
    sqlQuery.setParameter("date_start", p.date_start);
    sqlQuery.setParameter("date_stop", p.date_stop);
    sqlQuery.setParameter("estado_id", Estado.LIQUIDACION_MES_APROBADO);
    sqlQuery.setParameter("estado_cerrado_id", Estado.LIQUIDACION_MES_CERRADA);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;
  }

  public static List<SqlRow> getCostoTotalPorTipoConcepto(Long idPeriodo, boolean cm) {
    Periodo p = Periodo.find.byId(idPeriodo);
    String sql = " SELECT round(sum(ld.cantidad*ld.importe),2) monto, lc.liquidacion_concepto_tipo_id tipo " + " 	FROM puestos_laborales pl "
        + " 	INNER JOIN liquidacion_puestos lp ON pl.id = lp.puesto_laboral_id "
        + " 	INNER JOIN liquidacion_detalles ld ON lp.id = ld.liquidacion_puesto_id "
        + " 	INNER JOIN liquidacion_conceptos lc ON ld.liquidacion_concepto_id = lc.id "
        + " 	INNER JOIN liquidacion_meses lm ON lm.id = lp.liquidacion_mes_id " + " 	WHERE lm.periodo_id = :periodo_id "
        + " 	AND lm.convenio_ministerio =  :cm AND lm.liquidacion_tipo_id in(1,4) "
        + " 	GROUP BY lm.convenio_ministerio,lc.liquidacion_concepto_tipo_id ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("periodo_id", p.id);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;
  }

  public static List<SqlRow> getCostoTotalPorPeriodo(Long idPeriodo) {

    Periodo p = Periodo.find.byId(idPeriodo);

    String sql = " SELECT round(sum(ld.cantidad*ld.importe),2) monto,lm.convenio_ministerio cm " + " 	FROM puestos_laborales pl "
        + " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "
        + " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "
        + " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "
        + " 	WHERE lm.periodo_id = :periodo_id AND lm.liquidacion_tipo_id in(1,4) " + "	GROUP BY lm.convenio_ministerio ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("periodo_id", p.id);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }


  public static List<SqlRow> getCountPorServicio(Long idPeriodo, boolean cm) {

    Periodo p = Periodo.find.byId(idPeriodo);

    String sql = "SELECT COUNT(*) count,organigrama_id,nombre  from ( "
        + " 	SELECT  pl.convenio_ministerio cm,lp.puesto_laboral_id,lp.organigrama_id organigrama_id,o.nombre nombre "
        + " 	FROM puestos_laborales pl " + "   INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "
        + " 	INNER JOIN organigramas o on o.id = lp.organigrama_id " + "	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "
        + " 	WHERE lm.periodo_id = :periodo_id " + "	AND pl.convenio_ministerio = :cm "
        + " 	GROUP BY pl.convenio_ministerio,lp.puesto_laboral_id,lp.organigrama_id,o.nombre " + " ) as coiu group by organigrama_id,nombre ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("periodo_id", p.id);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }


  public static List<SqlRow> getCountPorProfesion(Long idPeriodo, boolean cm) {

    Periodo p = Periodo.find.byId(idPeriodo);

    String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm,el.id,el.nombre escala,p.id ,p.nombre profesion "
        + " FROM puestos_laborales pl " + " INNER JOIN legajos l on l.id = pl.legajo_id " + " INNER JOIN agentes a on a.id = l.agente_id "
        + " INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " + " INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "
        + " LEFT JOIN profesiones p on p.id = a.profesion_id " + " INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id " + " WHERE "
        + " lm.periodo_id = :periodo_id " + " and pl.convenio_ministerio = :cm AND lm.liquidacion_tipo_id in(1,4) "
        + " GROUP BY pl.convenio_ministerio,el.id,el.nombre,p.id ,p.nombre " + " order by el.id,count ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    // sqlQuery.setParameter("date_stop",p.date_stop);
    sqlQuery.setParameter("periodo_id", p.id);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }

  public static List<SqlRow> getCountPorProfesionAsistencial(Long idPeriodo, boolean cm, boolean asistencial) {

    Periodo p = Periodo.find.byId(idPeriodo);

    String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm,el.id,el.nombre escala,p.id ,p.nombre profesion "
        + " FROM puestos_laborales pl " + " INNER JOIN legajos l on l.id = pl.legajo_id " + " INNER JOIN agentes a on a.id = l.agente_id "
        + " INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " + " INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "
        + " LEFT JOIN profesiones p on p.id = a.profesion_id " + " INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id " + " WHERE" +
        // " pl.fecha_posesion <= :date_stop " +
        // " AND (pl.fecha_baja >= :date_stop or pl.fecha_baja is null)" +
        " lm.periodo_id = :periodo_id " + " AND pl.convenio_ministerio = :cm AND lm.liquidacion_tipo_id in(1,4) "
        + " AND p.asistencial = :asistencial " + " GROUP BY pl.convenio_ministerio,el.id,el.nombre,p.id ,p.nombre " + " order by el.id,count ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    // sqlQuery.setParameter("date_stop",p.date_stop);
    sqlQuery.setParameter("periodo_id", p.id);
    sqlQuery.setParameter("cm", cm);
    sqlQuery.setParameter("asistencial", asistencial);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }

  public static List<SqlRow> getCountPorEscalaNew(Long idPeriodo, boolean cm) {

    Periodo p = Periodo.find.byId(idPeriodo);
    String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm,el.id,el.nombre nombre, el.id escala_id"
        + " FROM puestos_laborales pl " + " INNER JOIN legajos l on l.id = pl.legajo_id " + " INNER JOIN agentes a on a.id = l.agente_id "
        + " INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id	" + " INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "
        + " INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " + " WHERE " +
        // " pl.fecha_posesion <= :date_stop AND (pl.fecha_baja >= :date_stop or pl.fecha_baja is null) " +
        // " lm.periodo_id = :periodo_id " +
        " lm.fecha_pago BETWEEN :date_start AND :date_stop " + " AND (lm.estado_id = :estado_id or lm.estado_id = :estado_cerrado_id) "
        + " AND pl.convenio_ministerio = :cm " +
        // " AND lm.liquidacion_tipo_id in(1,4) " +
        " GROUP BY pl.convenio_ministerio,el.id,el.nombre,el.id order by el.id ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    // sqlQuery.setParameter("date_stop",p.date_stop);
    // sqlQuery.setParameter("periodo_id",p.id);
    sqlQuery.setParameter("date_start", p.date_start);
    sqlQuery.setParameter("date_stop", p.date_stop);
    sqlQuery.setParameter("estado_id", Estado.LIQUIDACION_MES_APROBADO);
    sqlQuery.setParameter("estado_cerrado_id", Estado.LIQUIDACION_MES_CERRADA);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }

  public static List<SqlRow> getCountPorEscala(Long idPeriodo, boolean cm) {

    Periodo p = Periodo.find.byId(idPeriodo);
    String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm,el.id,el.nombre nombre " + " FROM puestos_laborales pl "
        + " INNER JOIN legajos l on l.id = pl.legajo_id " + " INNER JOIN agentes a on a.id = l.agente_id "
        + " INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id	" + " INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "
        + " INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " + " WHERE " +
        // " pl.fecha_posesion <= :date_stop AND (pl.fecha_baja >= :date_stop or pl.fecha_baja is null) " +
        " lm.periodo_id = :periodo_id " + " AND pl.convenio_ministerio = :cm AND lm.liquidacion_tipo_id in(1,4)  "
        + " GROUP BY pl.convenio_ministerio,el.id,el.nombre order by el.id ";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    // sqlQuery.setParameter("date_stop",p.date_stop);
    sqlQuery.setParameter("periodo_id", p.id);
    sqlQuery.setParameter("cm", cm);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }

  public static List<SqlRow> getCountRelacionPorPeriodoNew(Long idPeriodo) {

    Periodo p = Periodo.find.byId(idPeriodo);
    String sql = "SELECT COUNT(distinct(pl.id)) count,pl.convenio_ministerio cm " + " FROM puestos_laborales pl 	" +
    // " INNER JOIN legajos l on l.id = pl.legajo_id " +
    // " INNER JOIN agentes a on a.id = l.agente_id " +
        " INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " + " INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +
        // " WHERE pl.fecha_posesion <= :date_stop " +
        // " AND (pl.fecha_baja >= :date_stop OR pl.fecha_baja is null) " +
        " WHERE  " + " lm.fecha_pago BETWEEN :date_start AND :date_stop " + " AND (lm.estado_id = :estado_id or lm.estado_id = :estado_cerrado_id) "
        + " GROUP BY pl.convenio_ministerio";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("date_start", p.date_start);
    sqlQuery.setParameter("date_stop", p.date_stop);
    sqlQuery.setParameter("estado_id", Estado.LIQUIDACION_MES_APROBADO);
    sqlQuery.setParameter("estado_cerrado_id", Estado.LIQUIDACION_MES_CERRADA);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }


  public static List<SqlRow> getCountRelacionPorPeriodo(Long idPeriodo) {

    Periodo p = Periodo.find.byId(idPeriodo);
    String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm " + " FROM puestos_laborales pl 	"
        + " INNER JOIN legajos l on l.id = pl.legajo_id " + " INNER JOIN agentes a on a.id = l.agente_id " + " WHERE pl.fecha_posesion <= :date_stop "
        + " AND (pl.fecha_baja >=  :date_stop OR pl.fecha_baja is null)  " + " GROUP BY pl.convenio_ministerio";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("date_stop", p.date_stop);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }

  public static List<SqlRow> getCountAltasPorPeriodo(Long idPeriodo) {

    Periodo p = Periodo.find.byId(idPeriodo);
    String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm " + " FROM puestos_laborales pl 	"
        + " INNER JOIN legajos l on l.id = pl.legajo_id " + " INNER JOIN agentes a on a.id = l.agente_id "
        + " WHERE pl.fecha_posesion BETWEEN :date_start AND :date_stop " + " GROUP BY pl.convenio_ministerio";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("date_start", p.date_start);
    sqlQuery.setParameter("date_stop", p.date_stop);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }

  public static List<SqlRow> getCountBajasPorPeriodo(Long idPeriodo) {

    Periodo p = Periodo.find.byId(idPeriodo);

    String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm " + " FROM puestos_laborales pl 	"
        + " INNER JOIN legajos l on l.id = pl.legajo_id " + " INNER JOIN agentes a on a.id = l.agente_id "
        + " WHERE pl.fecha_baja BETWEEN :date_start AND :date_stop   " + " GROUP BY pl.convenio_ministerio";

    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("date_start", p.date_start);
    sqlQuery.setParameter("date_stop", p.date_stop);
    List<SqlRow> row = sqlQuery.findList();

    return row;

  }

  public static void actualizarVistaMaterializadaPuestosLaborales () {

		Connection conn = play.db.DB.getConnection();
		Statement stmt = null;
		try {
		    stmt = conn.createStatement();
		    stmt.execute("REFRESH MATERIALIZED VIEW puesto_laboral_acum_haberes_parque_mv;");
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
