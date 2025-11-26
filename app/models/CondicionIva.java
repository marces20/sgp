package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "condiciones_iva")
public class CondicionIva  extends Model{

	private static final long serialVersionUID = 1L;
	public static Long CLIENTE_EXTERIOR = (long)13;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="condiciones_iva_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String descripcion;

	public Integer codigo_macro;

	public Integer codigo_afip;

	public static Model.Finder<Long,CondicionIva> find = new Model.Finder<Long,CondicionIva>(Long.class, CondicionIva.class);
}
