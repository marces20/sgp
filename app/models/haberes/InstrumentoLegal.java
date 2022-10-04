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
@Table(name = "instrumentos_legales")
public class InstrumentoLegal extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instrumentos_legales_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public static Model.Finder<Long,InstrumentoLegal> find = new Model.Finder<Long,InstrumentoLegal>(Long.class, InstrumentoLegal.class);
	
	public static Pagination<InstrumentoLegal> page(String nombre){

		Pagination<InstrumentoLegal> p = new Pagination<InstrumentoLegal>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<InstrumentoLegal> e = find.where();
		
		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<InstrumentoLegal> getDataSuggest(String input,Integer limit){
		List<InstrumentoLegal> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
