package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "cie")
public class Cie extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cie_id_seq")
	public Long id;
	@Required(message="Nombre requerido")
	public String nombre;
	
	@Required(message="descripcion requerido")
	public String descripcion;
	
	public String sexo;
	
	public Integer limite_inferior;
	
	public Integer limite_superior;
	
	public static Finder<Long,Cie> find = new Finder<Long,Cie>(Long.class, Cie.class);
	
	public List<Cie> getDataSuggest(String input,Integer limit){
		
		List<Cie> l = find.where()
				.disjunction()
				.ilike("nombre", "%"+input+"%")
				.ilike("descripcion", "%"+input+"%")
				.endJunction()
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
