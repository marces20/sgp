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
@Table(name = "cargos_laborales")
public class CargoLaboral extends Model{
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cargos_laborales_id_seq")
	public Long id;
	
	@Required(message="Debe escribir una denominacion")
	public String nombre;
	
	public Integer numeracion;
	
	public static Model.Finder<Long,CargoLaboral> find = new Model.Finder<Long,CargoLaboral>(Long.class, CargoLaboral.class);
	
	public static Pagination<CargoLaboral> page(String nombre){

		Pagination<CargoLaboral> p = new Pagination<CargoLaboral>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("nombre");
		
		ExpressionList<CargoLaboral> e = find.where();
		
		if(!nombre.isEmpty()){
			e.ilike("nombre", "%" + nombre + "%");
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<CargoLaboral> getDataSuggest(String input,Integer limit){
		List<CargoLaboral> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}

}
