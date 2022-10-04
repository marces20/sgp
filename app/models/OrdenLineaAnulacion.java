package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;

@Entity 
@Table(name = "orden_lineas_anulaciones")
public class OrdenLineaAnulacion extends Model {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orden_lineas_anulaciones_id_seq")
    public Long id;

	@OneToOne
	@JoinColumn(name="orden_linea_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenLinea ordenLinea;
	@Required(message="Requiere una linea de orden")
	public Long orden_linea_id;
	
	@Required(message="Requiere cantidad")
	public BigDecimal cantidad;

	public String observaciones;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	
	@OneToMany
	@JoinColumn(name = "orden_linea_anulacion_id")
	public List<OrdenLineaAnulacionCliente> ordenLineaAnulacionCliente;
	
	public BigDecimal getTotal(){
		BigDecimal x =  ordenLinea.precio.multiply(cantidad);
		
		return  x;
	}
	
	public static Model.Finder<Long,OrdenLineaAnulacion> find = new Finder<Long,OrdenLineaAnulacion>(Long.class, OrdenLineaAnulacion.class);
}
