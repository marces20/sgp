package models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "orden_linea_anulacion_clientes")
public class OrdenLineaAnulacionCliente extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orden_linea_anulacion_clientes_id_seq")
	public Long id;
	
	@Required(message="Cantidad requerida")
	public BigDecimal cantidad;
	
	@ManyToOne
	@JoinColumn(name="orden_linea_anulacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenLineaAnulacion ordenLineaAnulacion;	
	@Required(message="Linea de anulacion requerido")
	public Long orden_linea_anulacion_id;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;	
	@Required(message="cliente requerido")
	public Long cliente_id;
	
	public static Finder<Long,OrdenLineaAnulacionCliente> find = new Finder<Long,OrdenLineaAnulacionCliente>(Long.class, OrdenLineaAnulacionCliente.class);
}
