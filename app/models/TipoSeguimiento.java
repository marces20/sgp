package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "tipo_seguimientos")
public class TipoSeguimiento extends Model{
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_seguimientos_id_seq")
	public Long id; 
	public String nombre;
	
	public static Model.Finder<Long,TipoSeguimiento> find = new Finder<Long,TipoSeguimiento>(Long.class, TipoSeguimiento.class);
	
	public List<TipoSeguimiento> getDataSuggest(String input,Integer limit){
		List<TipoSeguimiento> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
	
	public static Pagination<TipoSeguimiento> page(String nombre) {    	
    	Pagination<TipoSeguimiento> p = new Pagination<TipoSeguimiento>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
	
}
