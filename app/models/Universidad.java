package models;

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
@Table(name = "universidades")
public class Universidad extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="universidades_id_seq")
	public Long id;
	@Required(message="Nombre requerido")
	public String nombre;
	
	public static Finder<Long,Universidad> find = new Finder<Long,Universidad>(Long.class, Universidad.class);
	
	public static Pagination<Universidad> page(String nombre) {    	
    	Pagination<Universidad> p = new Pagination<Universidad>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
}
