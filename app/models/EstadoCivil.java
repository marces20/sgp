package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity 
@Table(name = "estado_civiles")
public class EstadoCivil extends Model{
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estado_civiles_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;
	
	public static Model.Finder<Long,EstadoCivil> find = new Model.Finder<Long,EstadoCivil>(Long.class, EstadoCivil.class);

	
	public static String getBancoId(String id) {
	        switch (id) {
	            case "1": //soltero
	                return "S"; 
	            case "2": //casado
	            	return "C";     
	            case "6": //divorciado
	                return "D";
	            case "7": //viudo
	                return "V";
	            default:
	            	return "S";
	        }
	}
	
	
}
