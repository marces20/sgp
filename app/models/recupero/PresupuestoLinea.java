package models.recupero;

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

import models.Cuenta;
import models.CuentaAnalitica;
import models.Producto;
import models.Udm;
import models.Usuario;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "presupuesto_lineas")
public class PresupuestoLinea extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="presupuesto_lineas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="presupuesto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Presupuesto presupuesto;
	@Required(message="Debe tener un presupuesto asociado")
	public Long presupuesto_id;
	
	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public  Producto producto;
	@Required(message="Requiere producto")
	public Long producto_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Requiere Cuenta Presupuestaria")
	public Long cuenta_analitica_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuenta;
	@Required(message="Requiere Cuenta")
	public Long cuenta_id;
	
	@DecimalComa(value="")
	@Required(message="Requiere precio")
	public BigDecimal precio;
	
	@DecimalComa(value="")
	@Required(message="Requiere cantidad")
	public BigDecimal cantidad;
	
	@ManyToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm;
	@Required(message="Requiere udm")
	public Long udm_id;
	
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
	
	public static Model.Finder<Long,PresupuestoLinea> find = new Finder<Long,PresupuestoLinea>(Long.class, PresupuestoLinea.class);
	
	public static Pagination<PresupuestoLinea> page(Long presupuestoId) {    	
    	Pagination<PresupuestoLinea> p = new Pagination<PresupuestoLinea>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("producto.nombre");
    	
    	p.setExpressionList(find.fetch("producto").where().eq("presupuesto_id", presupuestoId));
    	return p;
	}

}
