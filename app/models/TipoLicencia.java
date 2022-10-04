package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "tipo_licencias")
public class TipoLicencia extends Model{
	
	
	public static final String TIPO_LICENCIA_DOCENCIA = "DOCENCIA";
	public static final String TIPO_LICENCIA_PERSONAL = "PERSONAL";
	public static final String TIPO_LICENCIA_MEDICINA = "MEDICINA";
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_licencias_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;
	
	public String tipo;
	
	public Integer dias;
	
	public Boolean habiles;
	
	public String articulo;
	
	public static Finder<Long,TipoLicencia> find = new Finder<Long,TipoLicencia>(Long.class, TipoLicencia.class);

}
