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
@Table(name = "escalas_laborales")
public class EscalaLaboral extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="escalas_laborales_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public String abreviatura;
	
	public static Model.Finder<Long,EscalaLaboral> find = new Model.Finder<Long,EscalaLaboral>(Long.class, EscalaLaboral.class);
	
	public static Pagination<EscalaLaboral> page(String nombre){

		Pagination<EscalaLaboral> p = new Pagination<EscalaLaboral>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<EscalaLaboral> e = find.where();
		
		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<EscalaLaboral> getDataSuggest(String input,Integer limit){
		List<EscalaLaboral> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
