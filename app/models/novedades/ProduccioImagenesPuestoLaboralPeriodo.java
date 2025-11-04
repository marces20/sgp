package models.novedades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import models.Periodo;
import models.haberes.PuestoLaboral;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name = "produccion_imagenes_puesto_laboral_periodos")
public class ProduccioImagenesPuestoLaboralPeriodo extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produccion_imagenes_puesto_laboral_periodos_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name = "puesto_laboral_id", referencedColumnName = "id", insertable = false, updatable = false)
	public PuestoLaboral puestoLaboral;
	@Required(message = "Requiere un puesto laboral")
	public Long puesto_laboral_id;

	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	@Required(message="Debe seleccionar un periodo")
	public Integer periodo_id;

	@ManyToOne
	@JoinColumn(name="planificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public Planificacion planificacion;
	public Long planificacion_id;

	public Integer dias_mes;
	public Integer minutos_profesional;
	public Integer minutos_practicas;
	public BigDecimal valor_minuto;
	public BigDecimal monto_sueldo;
	public BigDecimal monto_especialidad;
	public Integer minutos_exedentes;
	public BigDecimal produccion;
	public Date create_date;

	public static Model.Finder<Long,ProduccioImagenesPuestoLaboralPeriodo> find = new Finder<Long,ProduccioImagenesPuestoLaboralPeriodo>(Long.class, ProduccioImagenesPuestoLaboralPeriodo.class);

	public static List<SqlRow> getProduccionMes(Long planificacion_id){

		String sql = "SELECT ag.apellido as apellido, puesto_laboral_id, periodo_id, dias_mes, minutos_profesional, minutos_practicas, valor_minuto, monto_sueldo, monto_especialidad, "+
				"minutos_exedentes, produccion, planificacion_id " +
				"FROM produccion_imagenes_puesto_laboral_periodos pi " +
				"INNER JOIN puestos_laborales pl on pl.id = pi.puesto_laboral_id " +
				"INNER JOIN legajos l on l.id = pl.legajo_id  " +
				"INNER JOIN agentes ag on ag.id = l.agente_id  " +
				"WHERE planificacion_id = :planificacion_id "+
				"ORDER BY apellido ASC ";

		List<com.avaje.ebean.SqlRow> l = Ebean.createSqlQuery(sql)
				.setParameter("planificacion_id", planificacion_id)
				.findList();

		return l;
	}


}
