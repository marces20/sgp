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
@Table(name = "categorias_laborales")
public class CategoriaLaboral extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categorias_laborales_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public static Model.Finder<Long,CategoriaLaboral> find = new Model.Finder<Long,CategoriaLaboral>(Long.class, CategoriaLaboral.class);
	
	public static Pagination<CategoriaLaboral> page(String nombre){

		Pagination<CategoriaLaboral> p = new Pagination<CategoriaLaboral>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<CategoriaLaboral> e = find.where();
		
		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<CategoriaLaboral> getDataSuggest(String input,Integer limit){
		List<CategoriaLaboral> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
