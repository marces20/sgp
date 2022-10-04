package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "estudio_subareas")
public class EstudioSubarea extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estudio_subareas_id_seq")
	public Long id;
	@Required(message="Nombre requerido")
	public String nombre;
	
	@ManyToOne
	@JoinColumn(name="estudio_area_id", referencedColumnName="id", insertable=false, updatable=false)
	public EstudioArea estudioArea; 
	@Column(name="estudio_area_id")
	public Long estudio_area_id;
	
	public static Finder<Long,EstudioSubarea> find = new Finder<Long,EstudioSubarea>(Long.class, EstudioSubarea.class);
	
	public static Pagination<EstudioSubarea> page(String nombre) {    	
    	Pagination<EstudioSubarea> p = new Pagination<EstudioSubarea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
	
	public static List<EstudioSubarea> getEstudioSubarea(int estudioAreaId){
		return find.where().eq("estudio_area_id", estudioAreaId).orderBy("nombre").findList();
	}
}
