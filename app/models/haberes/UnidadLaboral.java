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
@Table(name = "unidades_laborales")
public class UnidadLaboral extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="unidades_laborales_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public static Model.Finder<Long,UnidadLaboral> find = new Model.Finder<Long,UnidadLaboral>(Long.class, UnidadLaboral.class);
	
	public static Pagination<UnidadLaboral> page(String nombre){

		Pagination<UnidadLaboral> p = new Pagination<UnidadLaboral>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<UnidadLaboral> e = find.where();
		
		if(!nombre.isEmpty()){
		e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<UnidadLaboral> getDataSuggest(String input,Integer limit){
		List<UnidadLaboral> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}