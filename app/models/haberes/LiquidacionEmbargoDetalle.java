package models.haberes;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.Periodo;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_embargo_detalles")
public class LiquidacionEmbargoDetalle  extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_embargo_detalles_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="liquidacion_embargo_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionEmbargo liquidacionEmbargo;
	@Required(message="Debe tener una retencion asociada")
	public Long liquidacion_embargo_id;

	@DecimalComa(value="")
	@Required(message="Debe tener un importe")
	public BigDecimal importe;

	@ManyToOne
	@JoinColumn(name = "periodo_id", referencedColumnName = "id", insertable = false, updatable = false)
	public Periodo periodo;
	@Required(message = "Requiere un periodo")
	public Integer periodo_id;

	@ManyToOne
	@JoinColumn(name = "liquidacion_tipo_id", referencedColumnName = "id", insertable = false, updatable = false)
	public LiquidacionTipo liquidacionTipo;
	@Required(message = "Requiere un tipo de liquidacion")
	public Integer liquidacion_tipo_id;


	public static Model.Finder<Long,LiquidacionEmbargoDetalle> find = new Finder<Long,LiquidacionEmbargoDetalle>(Long.class, LiquidacionEmbargoDetalle.class);

	public static Pagination<LiquidacionEmbargoDetalle> page(Long liquidacionEmbargoId) {

    	Pagination<LiquidacionEmbargoDetalle> p = new Pagination<LiquidacionEmbargoDetalle>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("periodo_id");

    	p.setExpressionList(find.where().eq("liquidacion_embargo_id", liquidacionEmbargoId));
    	return p;
	}
}
