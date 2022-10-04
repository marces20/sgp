package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "solicitud_lineas")
public class SolicitudLinea extends Model{
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="solicitud_lineas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="solicitud_id", referencedColumnName="id", insertable=false, updatable=false)
	public Solicitud solicitud;
	
	@Required(message="Debe tener una solicitud asociada")
	public Long solicitud_id;
	
	@OneToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Producto producto;

	@Required(message="Requiere un producto")
	public Long producto_id;
	
	@OneToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Cuenta requerida")
	public Integer cuenta_analitica_id;
	
	@OneToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm;
	
	@Required(message="Requiere Udm")
	public Integer udm_id;
	
	@Required(message="Requiere cantidad")
	@DecimalComa(value="")
	public BigDecimal cantidad;

	@Required(message="Requiere un valor")
	@DecimalComa(value="")
	public BigDecimal precio_estimado;

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

	public static Model.Finder<Long,SolicitudLinea> find = new Finder<Long,SolicitudLinea>(Long.class, SolicitudLinea.class);

    public static Pagination<SolicitudLinea> page(Long solicitudId) {    	
    	Pagination<SolicitudLinea> p = new Pagination<SolicitudLinea>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.fetch("producto").where().eq("solicitud_id", solicitudId));
    	return p;
    }
    
    public static void getValoresPorCuentaAnalitica(Integer idSolicitud){
    	
    }
	
}
