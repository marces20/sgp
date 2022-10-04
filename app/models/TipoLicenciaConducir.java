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
@Table(name = "tipo_licencias_conducir")
public class TipoLicenciaConducir {
	
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_licencias_conducir_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;
	
	
	public static Finder<Long,TipoLicenciaConducir> find = new Finder<Long,TipoLicenciaConducir>(Long.class, TipoLicenciaConducir.class);

	 
}
