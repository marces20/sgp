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
@Table(name = "liquidacion_base_calculos")
public class LiquidacionBaseCalculo extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_base_calculos_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public String parametros;
	
	@Required(message="Debe escribir una codigo")
	public String calculo;

	
	public static Model.Finder<Long,LiquidacionBaseCalculo> find = new Model.Finder<Long,LiquidacionBaseCalculo>(Long.class, LiquidacionBaseCalculo.class);
	
	public static Pagination<LiquidacionBaseCalculo> page(String nombre){

		Pagination<LiquidacionBaseCalculo> p = new Pagination<LiquidacionBaseCalculo>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<LiquidacionBaseCalculo> e = find.where();
		
		if(!nombre.isEmpty()){
		e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<LiquidacionBaseCalculo> getDataSuggest(String input,Integer limit){
		List<LiquidacionBaseCalculo> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}