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
@Table(name = "estudio_niveles")
public class EstudioNivel extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estudio_niveles_id_seq")
	public Long id;
	@Required(message="Nombre requerido")
	public String nombre;
	
	public Integer orden;
	
	public static Finder<Long,EstudioNivel> find = new Finder<Long,EstudioNivel>(Long.class, EstudioNivel.class);
	
	public static Pagination<EstudioNivel> page(String nombre) {    	
    	Pagination<EstudioNivel> p = new Pagination<EstudioNivel>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
}
