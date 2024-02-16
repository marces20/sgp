package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "profesiones")
public class Profesion extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="profesiones_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;


	public Boolean asistencial = false;

	public static Finder<Long,Profesion> find = new Finder<Long,Profesion>(Long.class, Profesion.class);

	public List<Profesion> getDataSuggest(String input,Integer limit){
		List<Profesion> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();
		return l;
	}

	public static Pagination<Profesion> page(String nombre) {
    	Pagination<Profesion> p = new Pagination<Profesion>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("nombre");

    	p.setExpressionList(
    			 find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }

}
