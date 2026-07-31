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
public class LiquidacionEmbargoConceptoTipos extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_embargo_conceptos_id_seq")
	public Long id;

	@Required(message="Debe escribir una denominacion")
	public String nombre;

	public static Model.Finder<Long,LiquidacionEmbargoConceptoTipos> find = new Model.Finder<Long,LiquidacionEmbargoConceptoTipos>(Long.class, LiquidacionEmbargoConceptoTipos.class);

	public static Pagination<LiquidacionEmbargoConceptoTipos> page(String nombre){

		Pagination<LiquidacionEmbargoConceptoTipos> p = new Pagination<LiquidacionEmbargoConceptoTipos>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");

		ExpressionList<LiquidacionEmbargoConceptoTipos> e = find.where();

		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}

		p.setExpressionList(e);
		return p;
	}

	public List<LiquidacionEmbargoConceptoTipos> getDataSuggest(String input,Integer limit){
		List<LiquidacionEmbargoConceptoTipos> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();

		return l;
	}
}
