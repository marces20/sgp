package models.haberes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_embargo_minimos")
public class LiquidacionEmbargoMinimos extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_embargo_minimos_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="liquidacion_embargo_concepto_tipo_id_minimo", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionEmbargoConceptoTipo liquidacionEmbargoConceptoTipo;
	@Required(message="Debe tener una Liquidacion asociada")
	public Long liquidacion_embargo_concepto_tipo_id_minimo;

	@Required(message="Debe tener un importe")
	public BigDecimal liquidacion_embargo_concepto_tipo_q_minimo;

	public static Model.Finder<Long,LiquidacionEmbargoMinimos> find = new Model.Finder<Long,LiquidacionEmbargoMinimos>(Long.class, LiquidacionEmbargoMinimos.class);

	public static Pagination<LiquidacionEmbargoMinimos> page(String nombre){

		Pagination<LiquidacionEmbargoMinimos> p = new Pagination<LiquidacionEmbargoMinimos>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");

		ExpressionList<LiquidacionEmbargoMinimos> e = find.where();

		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}

		p.setExpressionList(e);
		return p;
	}

	public List<LiquidacionEmbargoMinimos> getDataSuggest(String input,Integer limit){
		List<LiquidacionEmbargoMinimos> l = find.where()
				.eq("liquidacion_embargo_concepto_tipo_id_minimo", input)
				.setMaxRows(limit).orderBy("id")
			    .findList();

		return l;
	}

}
