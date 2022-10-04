package models;

import java.math.BigDecimal;

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
@Table(name = "certificaciones_servicios_linea_clientes")
public class CertificacionServicioLineaCliente extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="certificaciones_servicios_linea_clientes_id_seq")
	public Long id;
	
	@Required(message="Cantidad requerida")
	public BigDecimal cantidad;
	
	@ManyToOne
	@JoinColumn(name="certificaciones_servicios_linea_id", referencedColumnName="id", insertable=false, updatable=false)
	public CertificacionServicioLinea certificiacionServicioLinea;	
	@Required(message="Linea de certificacion requerido")
	public Long certificaciones_servicios_linea_id;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;	
	@Required(message="cliente requerido")
	public Long cliente_id;
	
	public static Finder<Long,CertificacionServicioLineaCliente> find = new Finder<Long,CertificacionServicioLineaCliente>(Long.class, CertificacionServicioLineaCliente.class);
}
