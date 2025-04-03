package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity
@Table(name = "instituciones_externas")
public class InstitucionExterna extends Model{

private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instituciones_externas_id_seq")
	public Long id;
	@Required(message="Debe escribir un apellido")
	public String nombre;

	public static Model.Finder<Long,InstitucionExterna> find = new Model.Finder<Long,InstitucionExterna>(Long.class, InstitucionExterna.class);

	public List<InstitucionExterna> getDataSuggest(String input,Integer limit){
		List<InstitucionExterna> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();
		return l;
	}

	public static Pagination<InstitucionExterna> page(String nombre) {
    	Pagination<InstitucionExterna> p = new Pagination<InstitucionExterna>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("nombre");

    	p.setExpressionList(
    			 find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }

}
