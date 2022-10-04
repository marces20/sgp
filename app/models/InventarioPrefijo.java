package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name = "nomenclador_cuentas_patrimonio")
public class InventarioPrefijo extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="nomenclador_cuentas_patrimonio_id_seq")
	public Long id;
	
	@Column(name="codigo")
	@Required(message="Debe ingresar un prefijo")
	public String prefijo;
	
	@Required(message="Debe escribir un nombre")
	public String nombre;
	
	public static Model.Finder<Long,InventarioPrefijo> find = new Finder<Long,InventarioPrefijo>(Long.class, InventarioPrefijo.class);
	
}
