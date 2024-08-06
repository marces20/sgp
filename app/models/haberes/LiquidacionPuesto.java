package models.haberes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import models.Agente;
import models.EnvioMail;
import models.Estado;
import models.Usuario;
import play.Logger;
import play.Play;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.EmailUtilis;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_puestos")
public class LiquidacionPuesto extends Model {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liquidacion_puestos_id_seq")
  public Long id;

  @ManyToOne
  @JoinColumn(name = "liquidacion_mes_id", referencedColumnName = "id", insertable = false, updatable = false)
  public LiquidacionMes liquidacionMes;
  @Required(message = "Requiere una liquidacion mes")
  public Long liquidacion_mes_id;


  public Integer nro_liq_puesto;

  public Integer impresiones;
  public Integer envio_mail;

  @ManyToOne
  @JoinColumn(name = "puesto_laboral_id", referencedColumnName = "id", insertable = false, updatable = false)
  public PuestoLaboral puestoLaboral;
  @Required(message = "Requiere un puesto laboral")
  public Long puesto_laboral_id;

  @ManyToOne
  @JoinColumn(name = "estado_id", referencedColumnName = "id", insertable = false, updatable = false)
  public Estado estado;
  public Long estado_id;

  @OneToMany
  public List<LiquidacionDetalle> liquidacionDetalle;

  public List<LiquidacionDetalle> getLiquidacionDetalle() {
    return LiquidacionDetalle.find.fetch("liquidacionConcepto")
        .where()
        .eq("liquidacion_puesto_id", id)
        .order("liquidacionConcepto.codigo ASC")
        .findList();
  }

  @Formula(
      select = "_b${ta}.total_ca",
      join = "left outer join (select liquidacion_puesto_id, sum(round(importe*cantidad,2)) as total_ca from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(1,4) group by liquidacion_puesto_id) as _b${ta} on _b${ta}.liquidacion_puesto_id = ${ta}.id")
  public BigDecimal total_ca;

  public BigDecimal getTotalCA() {
    if (total_ca == null)
      return new BigDecimal(0);
    return total_ca;
  }

  public String getTotalCAMoneda() {
    return NumberUtils.moneda(getTotalCA());
  }

  @Formula(
      select = "_c${ta}.total_sa",
      join = "left outer join (select liquidacion_puesto_id, sum(round(importe*cantidad,2)) as total_sa from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(2) group by liquidacion_puesto_id) as _c${ta} on _c${ta}.liquidacion_puesto_id = ${ta}.id")
  public BigDecimal total_sa;

  public BigDecimal getTotalSA() {
    if (total_sa == null)
      return new BigDecimal(0);
    return total_sa;
  }

  /*
   * @Formula(select = "_c${ta}.total_sa", join =
   * "left outer join (select liquidacion_puesto_id, sum(round(importe*cantidad,2)) as total_sa from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(2) and lc.id not in(59,44,326,61,43,42,62,32,33,34,31,66) group by liquidacion_puesto_id) as _c${ta} on _c${ta}.liquidacion_puesto_id = ${ta}.id"
   * )
   * public BigDecimal total_sa2;
   * public BigDecimal getTotalSA2(){
   * if (total_sa2 == null)
   * return new BigDecimal(0);
   * return total_sa2;
   * }
   */

  public String getTotalSAMoneda() {
    return NumberUtils.moneda(this.getTotalSA());
  }

  @Formula(
      select = "_d${ta}.total_retencion",
      join = "left outer join (select liquidacion_puesto_id, sum(round(importe*cantidad,2)) as total_retencion from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(3) group by liquidacion_puesto_id) as _d${ta} on _d${ta}.liquidacion_puesto_id = ${ta}.id")
  public BigDecimal total_retencion;

  public BigDecimal getTotalRetenciones() {
    if (total_retencion == null)
      return new BigDecimal(0);
    return total_retencion;
  }

  public String getTotalRetencionesMoneda() {
    return NumberUtils.moneda(this.getTotalRetenciones());
  }

  public BigDecimal getTotalACobrar() {
    return getTotalCA().add(getTotalSA()).subtract(getTotalRetenciones());
  }

  /*
   * public BigDecimal getTotalACobrar2(){
   * return getTotalCA().add(getTotalSA2()).subtract(getTotalRetenciones());
   * }
   */

  public String getTotalACobrarMoneda() {
    return NumberUtils.moneda(getTotalACobrar());
  }

  public String getTotalACobrarLetra() {
    return NumeroALetra.convertNumberToLetterBigDecimal(this.getTotalACobrar());
  }

  @Formula(
      select = "_h${ta}.total_clasificacion_haber_contrato",
      join = "left outer join (select liquidacion_puesto_id, sum(round(importe*cantidad,2)) as total_clasificacion_haber_contrato from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id where lcc.id in(1) group by liquidacion_puesto_id) as _h${ta} on _h${ta}.liquidacion_puesto_id = ${ta}.id")
  public BigDecimal total_clasificacion_haber_contrato;

  public BigDecimal getTotalClasificacionHaberContrato() {
    if (total_clasificacion_haber_contrato == null)
      return new BigDecimal(0);
    return total_clasificacion_haber_contrato;
  }

  @Formula(
      select = "_g${ta}.total_clasificacion_guardia",
      join = "left outer join (select liquidacion_puesto_id, sum(round(importe*cantidad,2)) as total_clasificacion_guardia from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id where lcc.id in(2) group by liquidacion_puesto_id) as _g${ta} on _g${ta}.liquidacion_puesto_id = ${ta}.id")
  public BigDecimal total_clasificacion_guardia;

  public BigDecimal getTotalClasificacionGuardia() {
    if (total_clasificacion_guardia == null)
      return new BigDecimal(0);
    return total_clasificacion_guardia;
  }

  @Formula(
      select = "_p${ta}.total_clasificacion_produccion",
      join = "left outer join (select liquidacion_puesto_id, sum(round(importe*cantidad,2)) as total_clasificacion_produccion from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id where lcc.id in(3) group by liquidacion_puesto_id) as _p${ta} on _p${ta}.liquidacion_puesto_id = ${ta}.id")
  public BigDecimal total_clasificacion_produccion;

  public BigDecimal getTotalClasificacionProduccion() {
    if (total_clasificacion_produccion == null)
      return new BigDecimal(0);
    return total_clasificacion_produccion;
  }

  @Formula(
      select = "_z${ta}.total_clasificacion_descuento",
      join = "left outer join (select liquidacion_puesto_id, sum(round(importe*cantidad,2)) as total_clasificacion_descuento from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id where lcc.id in(5) group by liquidacion_puesto_id) as _z${ta} on _z${ta}.liquidacion_puesto_id = ${ta}.id")
  public BigDecimal total_clasificacion_descuento;

  public BigDecimal getTotalClasificacionDescuento() {
    if (total_clasificacion_descuento == null)
      return new BigDecimal(0);
    return total_clasificacion_descuento;
  }

  @Formula(
      select = "_a${ta}.total_clasificacion_adicional",
      join = "left outer join (select liquidacion_puesto_id, sum(round(importe*cantidad,2)) as total_clasificacion_adicional from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id where lcc.id in(6) group by liquidacion_puesto_id) as _a${ta} on _a${ta}.liquidacion_puesto_id = ${ta}.id")
  public BigDecimal total_clasificacion_adicional;

  public BigDecimal getTotalClasificacionAdicional() {
    if (total_clasificacion_adicional == null)
      return new BigDecimal(0);
    return total_clasificacion_adicional;
  }

  @Formula(
      select = "_ga${ta}.tiene_ganancia",
      join = "left outer join (select liquidacion_puesto_id, CASE WHEN count(*)=0 THEN false WHEN count(*)>0 THEN true ELSE false END as tiene_ganancia from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id inner join liquidacion_concepto_clasificaciones lcc on lc.liquidacion_concepto_clasificacion_id = lcc.id  where lcc.id in(9,12) group by liquidacion_puesto_id) as _ga${ta} on _ga${ta}.liquidacion_puesto_id = ${ta}.id")
  public Boolean tiene_ganancia;

  public boolean getTieneGanancia() {
    if (tiene_ganancia == null || !tiene_ganancia)
      return false;
    return true;
  }


  public static Finder<Long, LiquidacionPuesto> find = new Finder<>(Long.class, LiquidacionPuesto.class);

  public static Pagination<LiquidacionPuesto> page(String liquidacion_mes_id, String puesto_laboral_id, String btnFiltro0, // borrador
      String btnFiltro1, // preaprobado
      String btnFiltro2, // aprobado
      String btnFiltro3, // cancelado
      String categoria_laboral_id, String cm, String escala_laboral_id, String ganancias, String fecha_desde, String fecha_hasta) {
    Pagination<LiquidacionPuesto> p = new Pagination<>();
    p.setOrderDefault(" ");
    p.setSortByDefault("puestoLaboral.legajo.agente.apellido ASC,liquidacionMes.id DESC");

    ExpressionList<LiquidacionPuesto> e = find.select("id, estado_id, total_ca, total_sa, total_retencion, tiene_ganancia, impresiones,envio_mail ")
        .fetch("estado", "id, nombre")
        .fetch("puestoLaboral.legajo.agente", "apellido")
        .fetch("liquidacionMes.periodo", "nombre")
        .fetch("puestoLaboral", "sueldo_referencia, fecha_posesion")
        .fetch("liquidacionMes", "id, nro_liquidacion_parque")
        .fetch("liquidacionMes.estado", "id, nombre")
        .where();

    if (!liquidacion_mes_id.isEmpty()) {
      // List<Object> lm = LiquidacionMes.find.where().eq("nro_liquidacion_parque", Integer.parseInt(nro_liq_parque)).findIds();
      e.eq("liquidacion_mes_id", Integer.parseInt(liquidacion_mes_id));
    }

    if (!puesto_laboral_id.isEmpty()) {
      e.eq("puestoLaboral.id", Integer.parseInt(puesto_laboral_id));
    }

    if (!escala_laboral_id.isEmpty()) {
      e.eq("puestoLaboral.escala_laboral_id", Integer.parseInt(escala_laboral_id));
    }

    if (!categoria_laboral_id.isEmpty()) {
      e.eq("puestoLaboral.categoria_laboral_id", Integer.parseInt(categoria_laboral_id));
    }

    if (!fecha_desde.isEmpty()) {
      Date fod = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
      e.ge("puestoLaboral.fecha_posesion", fod);
    }

    if (!fecha_hasta.isEmpty()) {
      Date foh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
      e.le("puestoLaboral.fecha_posesion", foh);
    }

    if (!cm.isEmpty()) {
      if (cm.compareToIgnoreCase("SI") == 0) {
        e.eq("puestoLaboral.convenio_ministerio", true);
      } else {
        e.eq("puestoLaboral.convenio_ministerio", false);
      }
    }

    if (!ganancias.isEmpty()) {
      if (ganancias.compareToIgnoreCase("SI") == 0) {
        e.eq("tiene_ganancia", true);
      } else if (ganancias.compareToIgnoreCase("NO") == 0) {
        e.isNull("tiene_ganancia");
      }
    }


    if (!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty()) {
      e = e.disjunction();
      if (!btnFiltro0.isEmpty()) {
        e = e.eq("estado_id", Estado.LIQUIDACION_PUESTOS_BORRADOR);
      }
      if (!btnFiltro1.isEmpty()) {
        e = e.eq("estado_id", Estado.LIQUIDACION_PUESTOS_PREAPROBADO);
      }
      if (!btnFiltro2.isEmpty()) {
        e = e.eq("estado_id", Estado.LIQUIDACION_PUESTOS_APROBADO);
      }
      if (!btnFiltro3.isEmpty()) {
        e = e.eq("estado_id", Estado.LIQUIDACION_PUESTOS_CANCELADO);
      }

      e = e.endJunction();
    }

    p.setExpressionList(e);

    return p;
  }

  public List<LiquidacionPuesto> getDataSuggest(String input, Integer limit) {
    List<LiquidacionPuesto> l =
        find.where().ilike("liquidacionMes.nro_liquidacion_parque", "%" + input + "%").setMaxRows(limit).orderBy("nro_liq_parque").findList();

    return l;
  }

  /*
   * public static Boolean conFechaPagoVieja(List<Integer> ids) {
   * String sql = " SELECT count(*) cantidad "+
   * " FROM pagos c " +
   * " WHERE c.fecha_pago < (select date_start from ejercicios where now() BETWEEN date_start AND date_stop) AND id in(:ids)" +
   * " GROUP BY c.id";
   *
   * List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("ids", ids).findList();
   *
   * return (l.size() == 0);
   * }
   */

  public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> lpSeleccionados) {

    SqlUpdate update = Ebean.createSqlUpdate("UPDATE liquidacion_puestos " + "SET estado_id = :idEstado " + "WHERE id IN (:ids)");
    update.setParameter("idEstado", idEstado);
    update.setParameter("ids", lpSeleccionados);

    return update.execute();
  }

  public static Integer modificarLiquidacionMasivo(Long idLiquidacion, List<Integer> lpSeleccionados) {

    SqlUpdate update = Ebean.createSqlUpdate("UPDATE liquidacion_puestos " + "SET liquidacion_mes_id = :idLiquidacion " + "WHERE id IN (:ids)");
    update.setParameter("idLiquidacion", idLiquidacion);
    update.setParameter("ids", lpSeleccionados);

    return update.execute();
  }

  public static void enviarMailReciboByLiquidacionPuestoId(String email, Long lpid, String tipoEnvio)
      throws IOException, XDocReportException, EmailException {

    LiquidacionPuesto lp = LiquidacionPuesto.find.select("id,envio_mail,impresiones,total_ca,total_sa,total_retencion")
        .fetch("liquidacionMes", "titulo,nro_liquidacion_parque,")
        .fetch("liquidacionMes.periodo")
        .fetch("liquidacionMes.liquidacionTipo")

        .fetch("puestoLaboral")
        .fetch("puestoLaboral.cargoLaboral", "numeracion")
        .fetch("puestoLaboral.escalaLaboral", "abreviatura")
        .fetch("puestoLaboral.legajo", "numero")
        .fetch("puestoLaboral.legajo.agente", "cuit,dni,apellido,fingreso")
        .fetch("puestoLaboral.cargoLaboral")
        .fetch("puestoLaboral.escalaLaboral")
        .where()
        .eq("id", lpid)
        .findUnique();

    String textoMail = "<html>- LIQUIDACION: " + lp.liquidacionMes.titulo + "";
    textoMail += "<p>Numero: " + lp.liquidacionMes.nro_liquidacion_parque + "</p>";
    textoMail += "<p>PERIODO: " + lp.liquidacionMes.periodo.nombre + "</p>";
    textoMail += "<p>TIPO: " + lp.liquidacionMes.liquidacionTipo.nombre + "</p>";
    textoMail += "</html> ";

    if (lp != null) {

      try {
        List<LiquidacionPuesto> llp = new ArrayList<>();
        llp.add(lp);

        String dirTemp = System.getProperty("java.io.tmpdir");
        File archivoPdf = new File(dirTemp + "/reporteReciboSueldo-" + lp.id + ".pdf");

        InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/reporteReciboSueldoConImagenes.odt");
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

        FieldsMetadata metadata = report.createFieldsMetadata();
        metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
        IContext context = report.createContext();

        context.put("liquidaciones", llp);
        context.put("date", new DateUtils());

        OutputStream out = new FileOutputStream(archivoPdf);
        Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
        report.convert(context, options, out);

        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(archivoPdf.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Recibo");
        attachment.setName(archivoPdf.getName());

       /* File archivoPdf2 =   Play.application().getFile("conf/resources/email/FIN_CICLO_ESCOLAR_2023.pdf");
        EmailAttachment attachment2 = new EmailAttachment();
        attachment2.setPath(archivoPdf2.getPath());
        attachment2.setDisposition(EmailAttachment.ATTACHMENT);
        attachment2.setDescription("Ayuda Escolar");
        attachment2.setName(archivoPdf2.getName());

        File archivoPdf3 = Play.application().getFile("conf/resources/email/ACTUALIZAR_DOCUMENTACION_2023.pdf");
        EmailAttachment attachment3 = new EmailAttachment();
        attachment3.setPath(archivoPdf3.getPath());
        attachment3.setDisposition(EmailAttachment.ATTACHMENT);
        attachment3.setDescription("Actualizacion Documentacion");
        attachment3.setName(archivoPdf3.getName());*/

        List<EmailAttachment> attachmentList = new ArrayList<>();
        attachmentList.add(attachment);
        //attachmentList.add(attachment2);
        //attachmentList.add(attachment3);


        EmailUtilis eu = new EmailUtilis();
        eu.setSubject("LIQUIDACION:" + lp.liquidacionMes.nro_liquidacion_parque + "-" + lp.liquidacionMes.periodo.nombre);
        eu.setHtmlMsg(textoMail);
        eu.setFrom("liquidaciones@parquesaludmnes.org.ar");
        eu.setAttach(attachmentList);

        List<String> adds = new ArrayList<>();
        adds.add(email);
        eu.setAdds(adds);
        eu.enviar();


        int count = lp.impresiones + 1;
        int count_envio = lp.envio_mail + 1;

        // lp.impresiones = count;
        lp.envio_mail = count_envio;
        lp.save();

        Agente agente = Agente.find.where().eq("id", lp.puestoLaboral.legajo.agente.id).findUnique();
        agente.write_email_date = new Date();
        agente.save();

        Long idUser = new Long(1);
        if (Usuario.getUsuarioSesion() != null) {
          idUser = new Long(Usuario.getUsuarioSesion());
        }


        LiquidacionEnvioMail ll = new LiquidacionEnvioMail();
        ll.email = email;
        ll.fecha = new Date();
        ll.liquidacion_puesto_id = lpid;
        ll.usuario_id = idUser;
        ll.save();

        EnvioMail em = new EnvioMail();
        em.email = email;
        em.fecha = new Date();
        em.ids = lpid;
        em.usuario_id = idUser;
        em.tipo = tipoEnvio;
        em.save();
      } catch (Exception e) {
    	  Logger.error("Error enviarMailReciboByLiquidacionPuestoId: " + e);
      }
    }
  }


  public static void envioMailsReciboAutomatico() throws EmailException, IOException, XDocReportException {
    Logger.debug("ENTRA EN envioMailsReciboAutomatico");
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String r = "";

    EmailUtilis eu = new EmailUtilis();
    eu.setFrom("liquidaciones@parquesaludmnes.org.ar");
    eu.setSubject("LIQUIDACION envio nummero:");
    eu.setHtmlMsg("VA POR EL NUMERO ");

    List<String> adds = new ArrayList<>();
    adds.add("marces2000@gmail.com");

    eu.setAdds(adds);
    eu.enviar();

    try {

      conn = play.db.DB.getConnection();
      stmt = conn.prepareStatement("SELECT lp.id as id,a.email as email  "
          + "FROM liquidacion_puestos lp  "
          + "inner join liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "
          + "inner join puestos_laborales pl on pl.id = lp.puesto_laboral_id "
          + "inner join legajos l on l.id = pl.legajo_id "
          + "inner join agentes a on a.id = l.agente_id " +
          "where pl.id in(790) and " +
          // "where lp.id in(414519) and "+
          // "where "+
          "lp.envio_mail = 0  " + "and lp.estado_id = ? " +
          // "and pl.mail_automatico = true " +
          "and (a.email is not null and a.email <> '') " + "and lm.estado_id = ? " + "and lm.periodo_id > 110 " + "order by lm.id,a.email desc");

      stmt.setInt(1, Estado.LIQUIDACION_PUESTOS_APROBADO);
      stmt.setInt(2, Estado.LIQUIDACION_MES_CERRADA);

      rs = stmt.executeQuery();
      int x = 0;
      List<Integer> l = new ArrayList<>();
      l.add(0);
      l.add(250);
      l.add(500);
      l.add(750);
      l.add(1000);
      l.add(1250);
      l.add(1500);
      l.add(1750);
      l.add(2000);
      l.add(2250);
      l.add(2500);
      l.add(2750);
      l.add(3000);
      l.add(3250);
      l.add(3500);

      while (rs.next()) {

        Logger.debug("es: " + l.contains(x));

        if (l.contains(x)) {
        	Logger.debug("esssssssssssssssssssss: " );

          eu = new EmailUtilis();
          eu.setFrom("liquidaciones@parquesaludmnes.org.ar");
          eu.setSubject("LIQUIDACION envio nummero:" + x);
          eu.setHtmlMsg("VA POR EL NUMERO " + x + " hora:" + new Date());
          eu.setAdds(adds);
          eu.enviar();


        }

        Logger.debug("entra recibo mail:" + x);
        //LiquidacionPuesto.enviarMailReciboByLiquidacionPuestoId(rs.getString("email"), rs.getLong("id"), "LIQUIDACION_PUESTO AUTOMATICO");
        Logger.debug("sale recibo mail");

        x++;
      }

    } catch (Exception e) {
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

  }

}
