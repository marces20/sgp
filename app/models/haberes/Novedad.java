package models.haberes;

import java.math.BigDecimal;
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
import models.Periodo;
import models.Remito;
import models.Usuario;
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
										   String cm) {
    	Pagination<Novedad> p = new Pagination<Novedad>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("puestoLaboral.legajo.agente.apellido");

    	ExpressionList<Novedad> e = find.fetch("periodoFin").fetch("periodoInicio").fetch("concepto").fetch("puestoLaboral").fetch("puestoLaboral.legajo").fetch("puestoLaboral.legajo.agente").where();

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


    	p.setExpressionList(e);
    	return p;
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

}