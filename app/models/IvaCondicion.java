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
@Table(name = "iva_condiciones")
public class IvaCondicion extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_licencias_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

	public static Finder<Long,IvaCondicion> find = new Finder<Long,IvaCondicion>(Long.class, IvaCondicion.class);
}