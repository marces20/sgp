package models.haberes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import models.Ejercicio;

import com.avaje.ebean.ExpressionList;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity 
@Table(name = "liquidacion_tipos")
public class LiquidacionTipo extends Model{
	
	private static final long serialVersionUID = 1L;
	
	public static final long MENSUAL = 1;
	public static final long SAC = 2;
	public static final long EXTRAORDINARIA = 3;
	public static final long SUPLEMENTARIA = 4;
	public static final long AYUDA_ESCOLAR = 21;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_tipos_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public boolean excluido_ganancias = false;
	
	public static Model.Finder<Long,LiquidacionTipo> find = new Model.Finder<Long,LiquidacionTipo>(Long.class, LiquidacionTipo.class);
	
	public static Pagination<LiquidacionTipo> page(String nombre){

		Pagination<LiquidacionTipo> p = new Pagination<LiquidacionTipo>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<LiquidacionTipo> e = find.where();
		
		if(!nombre.isEmpty()){
		e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public static List<LiquidacionTipo> getTipos(){
		return find.orderBy("id desc").findList();
	}
	
	public List<LiquidacionTipo> getDataSuggest(String input,Integer limit){
		List<LiquidacionTipo> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
