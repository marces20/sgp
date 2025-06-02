package models;

import java.util.Date;
import java.util.List;

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
@Table(name = "clientes_direcciones")
public class DireccionCliente extends Model {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clientes_direcciones_id_seq")
	public Long id;

	@OneToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;

	@OneToOne
	public Long cliente_id;

	@OneToOne
	@JoinColumn(name="localidad_id", referencedColumnName="id", insertable=false, updatable=false)
	public Localidad localidad;

	@Required(message="Localidad es requerida")
	public Long localidad_id;

	public boolean activo = false;

	@Column(name="zip")
	public String cp;

	@Required(message="El nombre de contacto es requerido")
	public String nombre;

	@Required(message="Calle es requerido")
	public String calle;
	@Required(message="Campo requerido")
	public String numero;

	public String email;
	public String telefono;
	public String mobile;
	public String fax;
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

	public static Model.Finder<Long,DireccionCliente> find = new Model.Finder<Long,DireccionCliente>(Long.class, DireccionCliente.class);

	public static List<DireccionCliente> getDireccionesById(Long id){
		return DireccionCliente.find
				.fetch("localidad")
				.fetch("localidad.provincia")
				.fetch("localidad.provincia.pais")
				.where().eq("cliente_id", id).findList();
	}
}
