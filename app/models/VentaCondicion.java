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
@Table(name = "venta_condiciones")
public class VentaCondicion extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_licencias_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

	public static Finder<Long,VentaCondicion> find = new Finder<Long,VentaCondicion>(Long.class, VentaCondicion.class);

}