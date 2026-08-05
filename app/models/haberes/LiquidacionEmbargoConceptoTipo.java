package models.haberes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_embargo_concepto_tipos")
public class LiquidacionEmbargoConceptoTipo  extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_embargo_conceptos_id_seq")
	public Long id;

	@Required(message="Debe escribir una denominacion")
	public String nombre;

	public static Model.Finder<Long,LiquidacionEmbargoConceptoTipo> find = new Model.Finder<Long,LiquidacionEmbargoConceptoTipo>(Long.class, LiquidacionEmbargoConceptoTipo.class);

	public static Pagination<LiquidacionEmbargoConceptoTipo> page(String nombre){

		Pagination<LiquidacionEmbargoConceptoTipo> p = new Pagination<LiquidacionEmbargoConceptoTipo>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");

		ExpressionList<LiquidacionEmbargoConceptoTipo> e = find.where();

		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}

		p.setExpressionList(e);
		return p;
	}

	public List<LiquidacionEmbargoConceptoTipo> getDataSuggest(String input,Integer limit){
		List<LiquidacionEmbargoConceptoTipo> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();

		return l;
	}
}
