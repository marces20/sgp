package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "estudio_areas")
public class EstudioArea extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estudio_areas_id_seq")
	public Long id;
	@Required(message="Nombre requerido")
	public String nombre;
	
	public Integer orden;
	
	@OneToMany
	public List<EstudioSubarea> estudioSubareas;
	
	public static Finder<Long,EstudioArea> find = new Finder<Long,EstudioArea>(Long.class, EstudioArea.class);
	
	public static Pagination<EstudioArea> page(String nombre) {    	
    	Pagination<EstudioArea> p = new Pagination<EstudioArea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }

}
