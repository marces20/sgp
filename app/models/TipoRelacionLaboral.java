package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity 
@Table(name = "tipo_relacion_laborales")
public class TipoRelacionLaboral extends Model{
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_relacion_laborales_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;
	
	public static Model.Finder<Long,TipoRelacionLaboral> find = new Model.Finder<Long,TipoRelacionLaboral>(Long.class, TipoRelacionLaboral.class);
}
