package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "punto_ventas")
public class PuntoVenta extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="punto_ventas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	@Required(message="Requiere una Institucion")
	public Long deposito_id;
	
	@Required(message="Requiere una numero")
	public String numero;
	
	@Required(message="Requiere tipo facturacion")
	public String tipo_facturacion;
	
	public static Finder<Long,PuntoVenta> find = new Finder<Long,PuntoVenta>(Long.class, PuntoVenta.class);
}
