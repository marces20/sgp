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
@Table(name = "tipo_embargos")
public class TipoEmbargos extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_embargos_id_seq")
	public Long id;

	@Required(message="Debe escribir una denominacion")
	public String nombre;

	public static Model.Finder<Long,TipoEmbargos> find = new Model.Finder<Long,TipoEmbargos>(Long.class, TipoEmbargos.class);

	public static Pagination<TipoEmbargos> page(String nombre){

		Pagination<TipoEmbargos> p = new Pagination<TipoEmbargos>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");

		ExpressionList<TipoEmbargos> e = find.where();

		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}

		p.setExpressionList(e);
		return p;
	}

	public List<TipoEmbargos> getDataSuggest(String input,Integer limit){
		List<TipoEmbargos> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();

		return l;
	}


}
