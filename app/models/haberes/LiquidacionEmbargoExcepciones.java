package models.haberes;

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
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_embargo_excepciones")
public class LiquidacionEmbargoExcepciones extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_embargo_excepciones_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="liquidacion_embargo_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionEmbargo liquidacionEmbargo;
	@Required(message="Debe tener una Liquidacion asociada")
	public Long liquidacion_embargo_id;

	@ManyToOne
	@JoinColumn(name="liquidacion_concepto_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionConcepto liquidacionConcepto;
	@Required(message="Debe tener una Liquidacion asociada")
	public Long liquidacion_concepto_id;

	public static Model.Finder<Long,LiquidacionEmbargoExcepciones> find = new Finder<Long,LiquidacionEmbargoExcepciones>(Long.class, LiquidacionEmbargoExcepciones.class);

	public static Pagination<LiquidacionEmbargoExcepciones> page(Long liquidacionEmbargoId) {

    	Pagination<LiquidacionEmbargoExcepciones> p = new Pagination<LiquidacionEmbargoExcepciones>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");

    	p.setExpressionList(find
    						.where().eq("liquidacion_embargo_id", liquidacionEmbargoId));
    	return p;
	}




}
