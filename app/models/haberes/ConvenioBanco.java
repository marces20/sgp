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
@Table(name = "convenios_bancos")
public class ConvenioBanco extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="convenios_bancos_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public static Model.Finder<Long,ConvenioBanco> find = new Model.Finder<Long,ConvenioBanco>(Long.class, ConvenioBanco.class);
	
	public static Pagination<ConvenioBanco> page(String nombre){

		Pagination<ConvenioBanco> p = new Pagination<ConvenioBanco>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<ConvenioBanco> e = find.where();
		
		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<ConvenioBanco> getDataSuggest(String input,Integer limit){
		List<ConvenioBanco> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
