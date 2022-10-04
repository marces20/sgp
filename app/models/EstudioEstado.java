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
@Table(name = "estudio_estados")
public class EstudioEstado extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estudio_estados_id_seq")
	public Long id;
	@Required(message="Nombre requerido")
	public String nombre;
	
	public static Finder<Long,EstudioEstado> find = new Finder<Long,EstudioEstado>(Long.class, EstudioEstado.class);
	
	public static Pagination<EstudioEstado> page(String nombre) {    	
    	Pagination<EstudioEstado> p = new Pagination<EstudioEstado>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
}
