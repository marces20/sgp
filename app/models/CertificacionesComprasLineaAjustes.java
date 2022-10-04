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
@Table(name = "certificaciones_compras_linea_ajustes")
public class CertificacionesComprasLineaAjustes extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="certificaciones_compras_linea_ajustes_id_seq")
	public Long id;
	
	
	@ManyToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm;
	@Required(message="Requiere UDM")
	public Long udm_id;
	
	@ManyToOne
	@JoinColumn(name="certificacion_compra_id", referencedColumnName="id", insertable=false, updatable=false)
	public CertificacionCompra certificacionCompra;
	@Required(message="Debe tener una certificacion asociada")
	public Long certificacion_compra_id;
	
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
	
	public BigDecimal getTotal(){
		return cantidad.multiply(precio);
	}
	
	public static Model.Finder<Long,CertificacionesComprasLineaAjustes> find = new Finder<Long,CertificacionesComprasLineaAjustes>(Long.class, CertificacionesComprasLineaAjustes.class);
	
	public static Pagination<CertificacionesComprasLineaAjustes> page(Long certificacionId) {    	
    	Pagination<CertificacionesComprasLineaAjustes> p = new Pagination<CertificacionesComprasLineaAjustes>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.fetch("producto").where().eq("certificacion_compra_id", certificacionId));
    	return p;
	}
}
