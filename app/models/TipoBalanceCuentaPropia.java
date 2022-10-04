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
@Table(name = "tipos_balance_cuentas_propias")
public class TipoBalanceCuentaPropia extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipos_balance_cuentas_propias_id_seq")
	public Long id;
	
	@Required(message="Debe escribir un nombre")
	public String nombre;
	
	public static Finder<Long,TipoBalanceCuentaPropia> find = new Finder<Long,TipoBalanceCuentaPropia>(Long.class, TipoBalanceCuentaPropia.class);
}
