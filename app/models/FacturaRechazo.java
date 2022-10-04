package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
@Entity 
@Table(name = "facturas_rechazos")
public class FacturaRechazo extends Model{
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="facturas_rechazos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public Factura factura;
	@Required(message="Requiere factura")
	public Long factura_id;
	
	@ManyToOne
	@JoinColumn(name="factura_motivo_rechazo_id", referencedColumnName="id", insertable=false, updatable=false)
	public FacturaMotivoRechazo facturaMotivoRechazo;
	@Required(message="Requiere factura motivo rechazo")
	public Long factura_motivo_rechazo_id;
	
	public String otro;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
}
