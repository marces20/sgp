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
@Table(name = "liquidacion_concepto_clasificaciones")
public class LiquidacionConceptoClasificacion extends Model{

	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_concepto_clasificaciones_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public static Model.Finder<Long,LiquidacionConceptoClasificacion> find = new Model.Finder<Long,LiquidacionConceptoClasificacion>(Long.class, LiquidacionConceptoClasificacion.class);

	public static Pagination<LiquidacionConceptoClasificacion> page(String nombre){

		Pagination<LiquidacionConceptoClasificacion> p = new Pagination<LiquidacionConceptoClasificacion>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<LiquidacionConceptoClasificacion> e = find.where();
		
		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<LiquidacionConceptoClasificacion> getDataSuggest(String input,Integer limit){
		List<LiquidacionConceptoClasificacion> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
