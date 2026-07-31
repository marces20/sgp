package models.haberes;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_embargo_conceptos")
public class LiquidacionEmbargoConceptos extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_embargo_conceptos_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="liquidacion_embargo_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionEmbargo liquidacionEmbargo;
	@Required(message="Debe tener una Liquidacion asociada")
	public Long liquidacion_embargo_id;

	@DecimalComa(value="")
	@Required(message="Debe tener una cantidad")
	public BigDecimal cantidad;

	@DecimalComa(value="")
	@Required(message="Debe tener un valor_dato")
	public BigDecimal valor_dato;

	@DecimalComa(value="")
	public BigDecimal porcentaje_afectacion;

	public static Model.Finder<Long,LiquidacionEmbargoConceptos> find = new Finder<Long,LiquidacionEmbargoConceptos>(Long.class, LiquidacionEmbargoConceptos.class);

	public static Pagination<LiquidacionEmbargoConceptos> page(Long liquidacionEmbargoId) {
    	Pagination<LiquidacionEmbargoConceptos> p = new Pagination<LiquidacionEmbargoConceptos>();
    	p.setPageSize(5000000);
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");

    	p.setExpressionList(find
    						.where().eq("liquidacion_embargo_id", liquidacionEmbargoId));
    	return p;
	}
}
