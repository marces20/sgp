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
@Table(name = "liquidacion_concepto_tipos")
public class LiquidacionConceptoTipo extends Model{
	
	public static final Integer HABERES_CON_APORTE = 1;
	public static final Integer HABERES_SIN_APORTE = 2;
	public static final Integer RETENCIONES = 3;
	public static final Integer DESCUENTOS = 4;
	public static final Integer CONTRIBUCIONES_PATRONALES = 21;
	public static final Integer HORAS_EXTRAS = 5;
	
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_concepto_tipos_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public static Model.Finder<Long,LiquidacionConceptoTipo> find = new Model.Finder<Long,LiquidacionConceptoTipo>(Long.class, LiquidacionConceptoTipo.class);
	
	public static Pagination<LiquidacionConceptoTipo> page(String nombre){

		Pagination<LiquidacionConceptoTipo> p = new Pagination<LiquidacionConceptoTipo>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<LiquidacionConceptoTipo> e = find.where();
		
		if(!nombre.isEmpty()){
		e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<LiquidacionConceptoTipo> getDataSuggest(String input,Integer limit){
		List<LiquidacionConceptoTipo> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}