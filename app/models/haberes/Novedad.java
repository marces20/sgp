package models.haberes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;

import models.OrdenProvision;
import models.Organigrama;
import models.OrganigramaGuardiaDato;
import models.Periodo;
import models.Remito;
import models.Usuario;
import models.novedades.Planificacion;
import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.RequestVar;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_novedades")
public class Novedad extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_novedades_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="puesto_laboral_id", referencedColumnName="id", insertable=false, updatable=false)
	public PuestoLaboral puestoLaboral;

	@Required(message = "El puesto laboral es obligatorio")
	public Long puesto_laboral_id;

	@ManyToOne
	@JoinColumn(name="liquidacion_concepto_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionConcepto concepto;

	@Required(message = "El concepto es obligatorio")
	public Long liquidacion_concepto_id;

	@ManyToOne
	@JoinColumn(name="periodo_desde_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodoInicio;
	@Required(message = "Periodo de inicio obligatorio")
	@Column(name="periodo_desde_id")
	public Long periodo_inicio_id;

	@ManyToOne
	@JoinColumn(name="periodo_hasta_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodoFin;
	@Required(message = "Periodo de fin obligatorio")
	@Column(name="periodo_hasta_id")
	public Long periodo_hasta_id;

	@ManyToOne
	@JoinColumn(name="periodo_concepto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodoConcepto;
	@Column(name="periodo_concepto_id")
	public Long periodo_concepto_id;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	@Column(name="organigrama_id")
	public Long organigrama_id;



	public Boolean cargaMasiva;

	public Boolean activo = true;

	public Date fecha_novedad;

	@DecimalComa(value="")
	public BigDecimal importe;
	@DecimalComa(value="")
	public BigDecimal importe_tope;

	@DecimalComa(value="")
	@Required(message="Cantidad obligatorio")
	public BigDecimal cantidad;

	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;

	public Long usuario_id;

	@ManyToOne
	@JoinColumn(name="liquidacion_tipo_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionTipo liquidacionTipo;

	@Required(message="Debe indicar el tipo")
	public Long liquidacion_tipo_id;

	public Date create_date;

	@ManyToOne
	@JoinColumn(name="liquidacion_embargo_detalle_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionEmbargoDetalle liquidacionEmbargoDetalle;
	public Long liquidacion_embargo_detalle_id;

	@ManyToOne
	@JoinColumn(name="planificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public Planificacion planificacion;
	public Long planificacion_id;

	public static Finder<Long,Novedad> find = new Finder<Long,Novedad>(Long.class, Novedad.class);

	public static Pagination<Novedad> page(String puesto_laboral_id,
										   String liquidacion_concepto_id,
										   String periodo_inicio_id,
										   String fecha_desde,
										   String fecha_hasta,
										   String liquidacion_tipo_id,
										   String tipo_carga,
										   String periodo_inicio,
										   String periodo_fin,
										   String activo,
										   String cm,
										   String periodo_concepto_id,
										   String organigrama_id,
										   String planificacion_id) {

    	Pagination<Novedad> p = new Pagination<Novedad>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("puestoLaboral.legajo.agente.apellido");

    	ExpressionList<Novedad> e = find
    								.fetch("periodoFin","nombre")
    								.fetch("periodoInicio","nombre")
    								.fetch("concepto")
    								.fetch("puestoLaboral.legajo.agente","apellido")
    								.fetch("organigrama","nombre")
    								.fetch("periodoConcepto","nombre")
    								.fetch("liquidacionTipo","nombre")
    								.where();

    	if(!activo.isEmpty()) {
    		if(activo.equals("activo"))
    			e.eq("activo", true);

    		else if(tipo_carga.equals("desactivo"))
    			e.eq("activo", false);
    	}

    	if(!tipo_carga.isEmpty()) {
    		if(tipo_carga.equals("masiva"))
    			e.eq("cargaMasiva", true);

    		else if(tipo_carga.equals("manual"))
    			e.eq("cargaMasiva", false);
    	}

    	if(!cm.isEmpty()){
    		if(cm.compareToIgnoreCase("SI") == 0){
    			e.eq("puestoLaboral.convenio_ministerio", true);
    		}else{
    			e.eq("puestoLaboral.convenio_ministerio", false);
    		}
    	}

    	if(!periodo_concepto_id.isEmpty()) {
    		e.eq("periodo_concepto_id", Integer.parseInt(periodo_concepto_id));
    	}

    	if(!organigrama_id.isEmpty()) {
    		e.eq("organigrama_id", Integer.parseInt(organigrama_id));
    	}

    	if(!puesto_laboral_id.isEmpty()) {
    		e.eq("puesto_laboral_id", Integer.parseInt(puesto_laboral_id));
    	}

    	if(!periodo_inicio.isEmpty()) {
    		e.eq("periodo_desde_id", Integer.parseInt(periodo_inicio));
    	}

    	if(!periodo_fin.isEmpty()) {
    		e.eq("periodo_hasta_id", Integer.parseInt(periodo_fin));
    	}

    	if(periodo_fin.isEmpty()) {
    		Periodo px = Periodo.getPeriodoByDate(new Date());

    		e.ge("periodo_hasta_id", px.id);
    	}


    	if(!liquidacion_concepto_id.isEmpty()) {
    		e.eq("liquidacion_concepto_id", Integer.parseInt(liquidacion_concepto_id));
    	}

		if(!fecha_desde.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		e.ge("fecha_novedad", fod);
    	}

		if(!fecha_hasta.isEmpty()){
    		Date foh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		e.le("fecha_novedad", foh);
    	}

    	if(!liquidacion_tipo_id.isEmpty()) {
    		e.eq("liquidacion_tipo_id", Integer.parseInt(liquidacion_tipo_id));
    	}

    	if(!planificacion_id.isEmpty()) {
    		e.eq("planificacion_id", Integer.parseInt(planificacion_id));
    	}

    	p.setExpressionList(e);
    	return p;
    }

	public static BigDecimal getCantidadByHabilesHoras(BigDecimal horas,Boolean habiles,OrganigramaGuardiaDato ogd,Boolean festivas) {

		BigDecimal ret = BigDecimal.ZERO;
		BigDecimal hh = new BigDecimal(24);

		if(festivas) {
			 hh = new BigDecimal(ogd.horasxdia_festivas);
		}else {
			if(habiles) {
				hh = new BigDecimal(ogd.horasxdia_habiles);
			}else {
				hh = new BigDecimal(ogd.horasxdia_inhabiles);
			}
		}

		ret = (horas).divide(hh, 2, RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);

		return ret;
	}

	public static Long getLiquidacionConceptoGuardiaByHoraHabilesFestivaOrg(BigDecimal horas,Boolean habiles,Boolean festivas,OrganigramaGuardiaDato ogd) {
		Long ret = null;

		if(festivas) {
			if(ogd.critica) {
				ret = LiquidacionConcepto.GUARDIA_ACTIVA_CRITICA_FESTIVA;
			}else {
				ret = LiquidacionConcepto.GUARDIA_ACTIVA_NO_CRITICA_FESTIVA;
			}
		}else {

			if(habiles) {
				if(ogd.critica) {
					 ret = LiquidacionConcepto.GUARDIA_CRITICA_DÍA_HÁBIL;
				}else {
					 ret = LiquidacionConcepto.GUARDIA_ACTIVA_DÍA_HÁBIL;
				}

			}else {
				if(ogd.critica) {
					ret = LiquidacionConcepto.GUARDIA_CRITICA_DÍA_INHÁBIL;
				}else {
					ret = LiquidacionConcepto.GUARDIA_ACTIVA_DÍA_INHÁBIL;
				}
			}
		}

		return ret;
	}

	public static Long getLiquidacionConceptoHorasExtrasAdminitrativosByHoraHabilesFestivaOrg(BigDecimal horas,Boolean habiles,Boolean festivas,OrganigramaGuardiaDato ogd) {
		Long ret = null;

		if(festivas) {
			 ret = LiquidacionConcepto.HORAS_ADMINISTRATIVAS_PASIVAS_DIA_FESTIVO;
		}else {

			if(habiles) {
				ret = LiquidacionConcepto.ADICIONAL_MAYOR_CARGAR_HORARIA;
			}else {
				ret = LiquidacionConcepto.GUARDIA_ACTIVA_DÍA_INHÁBIL;
			}
		}

		return ret;
	}

	public static Long getLiquidacionConceptoHorasExtrasAdminitrativosNocturnidadByHoraHabilesFestivaOrg(BigDecimal horas,Boolean habiles,Boolean festivas,OrganigramaGuardiaDato ogd) {
		Long ret = null;

		ret = LiquidacionConcepto.NOCTURNIDAD_EMERGUER_COVID;

		return ret;
	}



	/*
	public Boolean comprobarPeriodoUnico() {
		return  Novedad.find.where()
				.eq("puesto_laboral_id", puesto_laboral_id)
				.eq("liquidacion_concepto_id", liquidacion_concepto_id)
				.le("periodo_inicio_id", periodo_inicio_id)
				.findList().size() > 0;

	}
	*/
	public Boolean comprobarPeriodoInicioConPeriodoFin() {
		return periodo_inicio_id <= periodo_hasta_id;
	}

	public static BigDecimal getSaldoGuardiaPorAgente(Long agenteId,Long periodo_id,Long novedad_id) {
		ResultSet rssi = null;
	    PreparedStatement stmtsi = null;
	    Connection conn2 = null;
	    PreparedStatement stmt2 = null;

	    BigDecimal ret = null;

		try {
		      conn2 = play.db.DB.getConnection();

		      stmtsi = conn2.prepareStatement("select (COALESCE(a.limite_guardia,0)-COALESCE(c.cantidad,0)) as saldo " +
		    		  "		from agentes a  " +
		    		  "		left outer join ( " +
			    		  "		select COALESCE(sum(cantidad),0) as cantidad,a.id as agente_id,ln.periodo_concepto_id " +
			    		  "		from liquidacion_novedades ln " +
			    		  "		inner join liquidacion_conceptos lc on lc.id = ln.liquidacion_concepto_id " +
			    		  "		left join puestos_laborales pl on pl.id = ln.puesto_laboral_id " +
			    		  "		left join legajos l on l.id = pl.legajo_id " +
			    		  "		left join agentes a on a.id = l.agente_id " +
			    		  "		where lc.control_guardia = true " +
			    		  "		AND a.id = ? " +
			    		  "		AND ln.periodo_concepto_id = ? " +
			    		  "		AND ln.id <> ? " +
			    		  "		group by a.id,ln.periodo_concepto_id " +
		    		  "		) as c on c.agente_id = a.id " +
		    		  "		where a.id = ? ");



		      stmtsi.setLong(1, agenteId);
		      stmtsi.setLong(2, periodo_id);
		      stmtsi.setLong(3, novedad_id);
		      stmtsi.setLong(4, agenteId);

		      rssi = stmtsi.executeQuery();

		      if (rssi.next()) {
		        ret = rssi.getBigDecimal("saldo");
		      }

		      return ret;

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

	public static BigDecimal getSaldoGuardiaPorOrganigrama(Long organigramaId,Long periodo_id,Long novedad_id) {
		ResultSet rssi = null;
	    PreparedStatement stmtsi = null;
	    Connection conn2 = null;
	    PreparedStatement stmt2 = null;

	    BigDecimal ret = null;

		try {
		      conn2 = play.db.DB.getConnection();

		      stmtsi = conn2.prepareStatement("select (COALESCE(a.limite_guardia,0)-COALESCE(c.cantidad,0)) as saldo " +
		    		  "		from organigramas a  " +
		    		  "		left outer join ( " +
			    		  "		select COALESCE(sum(cantidad),0) as cantidad,a.id as organigrama_id,ln.periodo_concepto_id " +
			    		  "		from liquidacion_novedades ln " +
			    		  "		inner join liquidacion_conceptos lc on lc.id = ln.liquidacion_concepto_id " +
			    		  "		left join organigramas a on a.id = ln.organigrama_id " +
			    		  "		where lc.control_guardia = true " +
			    		  "		AND a.id = ? " +
			    		  "		AND ln.periodo_concepto_id = ? " +
			    		  "		AND ln.id <> ? " +
			    		  "		group by a.id,ln.periodo_concepto_id " +
		    		  "		) as c on c.organigrama_id = a.id " +
		    		  "		where a.id = ? ");



		      stmtsi.setLong(1, organigramaId);
		      stmtsi.setLong(2, periodo_id);
		      stmtsi.setLong(3, novedad_id);
		      stmtsi.setLong(4, organigramaId);

		      rssi = stmtsi.executeQuery();

		      if (rssi.next()) {
		        ret = rssi.getBigDecimal("saldo");
		      }

		      return ret;

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


}