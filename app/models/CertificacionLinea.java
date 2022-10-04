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
import javax.persistence.Table;
import javax.persistence.Transient;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "certificaciones_lineas")
public class CertificacionLinea extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="certificaciones_lineas_id_seq")
	public Long id;
	
	
	@ManyToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm;
	@Required(message="Requiere UDM")
	public Long udm_id;
	
	@ManyToOne
	@JoinColumn(name="certificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public Certificacion certificacion;
	@Required(message="Debe tener una certificacion asociada")
	public Long certificacion_id;
	
	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public  Producto producto;
	@Required(message="Requiere producto")
	public Long producto_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Requiere Cuenta analitica")
	public Long cuenta_analitica_id;
	
	@DecimalComa(value="")
	@Required(message="Requiere precio")
	public BigDecimal precio;
	
	@Required(message="Requiere cantidad")
	public BigDecimal cantidad;
	
	@Transient
	public BigDecimal subtotal;
	
	@Transient
	public BigDecimal totalDescuento;
	
	@DecimalComa(value="")
	public BigDecimal descuento;
	
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
	
	public BigDecimal getTotalDescuento(){
		if (descuento == null)
			return new BigDecimal(0);
		return cantidad.multiply(precio).multiply(descuento).divide(new java.math.BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getTotal(){
		return cantidad.multiply(precio).subtract(getTotalDescuento());
	}
	
	public static Model.Finder<Long,CertificacionLinea> find = new Finder<Long,CertificacionLinea>(Long.class, CertificacionLinea.class);
	
	public static Pagination<CertificacionLinea> page(Long certificacionId) {    	
    	Pagination<CertificacionLinea> p = new Pagination<CertificacionLinea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.fetch("producto").where().eq("certificacion_id", certificacionId));
    	return p;
	}
	
}
