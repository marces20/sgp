package models.novedades;

import java.math.BigDecimal;
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
@Table(name = "produccion_puesto_laboral_periodos")
public class ProduccionPuestoPeriodo extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produccion_puesto_laboral_periodos_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name = "puesto_laboral_id", referencedColumnName = "id", insertable = false, updatable = false)
	public PuestoLaboral puestoLaboral;
	@Required(message = "Requiere un puesto laboral")
	public Long puesto_laboral_id;

	public String nombre_rismi;

	public String codigo_ips;

	public BigDecimal cantidad;

	public BigDecimal valor_ips;

	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	@Required(message="Debe seleccionar un periodo")
	public Integer periodo_id;

	@ManyToOne
	@JoinColumn(name="planificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public Planificacion planificacion;
	public Long planificacion_id;

	public BigDecimal getTotal(){
		return cantidad.multiply(valor_ips);
	}

	public static Model.Finder<Long,ProduccionPuestoPeriodo> find = new Finder<Long,ProduccionPuestoPeriodo>(Long.class, ProduccionPuestoPeriodo.class);

	public static BigDecimal getValorIps(String codigoIps) {

		BigDecimal ret = BigDecimal.ZERO;

		if(codigoIps != null) {
			String sql = " SELECT valor_ips FROM produccion_ips_nomencladores where codigo_ips = :codigo_ips and periodo_hasta_id is null";

			List<com.avaje.ebean.SqlRow> l = Ebean.createSqlQuery(sql).setParameter("codigo_ips", codigoIps).findList();
			if(l.size() > 0) {
				ret = l.get(0).getBigDecimal("valor_ips");
			}

		}
		return  ret;
	}
}
