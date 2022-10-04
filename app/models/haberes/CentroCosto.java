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
@Table(name = "centros_costos")
public class CentroCosto extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="centros_costos_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public static Model.Finder<Long,CentroCosto> find = new Model.Finder<Long,CentroCosto>(Long.class, CentroCosto.class);
	
	public static Pagination<CentroCosto> page(String nombre){

		Pagination<CentroCosto> p = new Pagination<CentroCosto>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<CentroCosto> e = find.where();
		
		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<CentroCosto> getDataSuggest(String input,Integer limit){
		List<CentroCosto> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
	
}
