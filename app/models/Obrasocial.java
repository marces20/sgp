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
@Table(name = "obrasociales")
public class Obrasocial extends Model{
	
private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="obrasociales_id_seq")
	public Long id; 
	@Required(message="Debe escribir un nombre")
	public String nombre;
	
	public String cod_prog_medico_nacional;
	
	public static Model.Finder<Long,Obrasocial> find = new Finder<Long,Obrasocial>(Long.class, Obrasocial.class);
	
	public List<Obrasocial> getDataSuggest(String input,Integer limit){
		List<Obrasocial> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
