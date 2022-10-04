package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "proveedor_direcciones")
public class DireccionProveedor extends Model {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proveedor_direcciones_id_seq")
	public Long id;
	@Required(message="El nombre de contacto es requerido")
	public String nombre;

	@OneToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	
	@OneToOne
	public Long proveedor_id;
		
	@OneToOne
	@JoinColumn(name="localidad_id", referencedColumnName="id", insertable=false, updatable=false)
	public Localidad localidad;
	
	@Required(message="Localidad es requerida")
	public Long localidad_id;

	public boolean activo = false;
	
	@Required(message="Calle es requerido")
	public String calle;
	@Required(message="Campo requerido")
	public String numero;

	public String email;
	public String telefono;
	public String mobile;
	public String fax;
	public String zip;
	
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
	
	public static Model.Finder<Long,DireccionProveedor> find = new Model.Finder<Long,DireccionProveedor>(Long.class, DireccionProveedor.class); 
	
	public Date getFechaActualizacion(){
		
		if(write_date != null) {
			return write_date;
		}else {
			return create_date;
		}
	}
}
