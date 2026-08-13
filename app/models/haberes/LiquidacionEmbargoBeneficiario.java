package models.haberes;

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
@Table(name = "liquidacion_embargo_beneficiarios")
public class LiquidacionEmbargoBeneficiario extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_embargo_beneficiarios_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="liquidacion_embargo_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionEmbargo liquidacionEmbargo;
	@Required(message="Debe tener una Liquidacion asociada")
	public Long liquidacion_embargo_id;

	@Required(message="Debe escribir un beneficiario_dni")
	public String beneficiario_dni;

	public static Model.Finder<Long,LiquidacionEmbargoBeneficiario> find = new Model.Finder<Long,LiquidacionEmbargoBeneficiario>(Long.class, LiquidacionEmbargoBeneficiario.class);

	public static Pagination<LiquidacionEmbargoBeneficiario> page(String nombre){

		Pagination<LiquidacionEmbargoBeneficiario> p = new Pagination<LiquidacionEmbargoBeneficiario>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("id");

		ExpressionList<LiquidacionEmbargoBeneficiario> e = find.where();

		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}

		p.setExpressionList(e);
		return p;
	}

	public List<LiquidacionEmbargoBeneficiario> getDataSuggest(String input,Integer limit){
		List<LiquidacionEmbargoBeneficiario> l = find.where()
				.eq("liquidacion_embargo_id", input)
				.setMaxRows(limit).orderBy("id")
			    .findList();

		return l;
	}
}
