package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "organigrama_tipos")
public class OrganigramaTipo extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="organigrama_tipos_id_seq")
    public Integer id;
	
	@Required(message="Debe escribir el nombre")
	public String nombre;
	
	public static Model.Finder<Long,OrganigramaTipo> find = new Model.Finder<Long,OrganigramaTipo>(Long.class, OrganigramaTipo.class);
}
