package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "caja_chica_movimientos")
public class CajaChicaMovimiento extends Model{
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="caja_chica_movimientos_id_seq")
	public Long id; 
	
	@ManyToOne
	@JoinColumn(name="caja_chica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CajaChica caja; 
	@Required(message="Requiere caja_chica_id")
	public Integer caja_chica_id;
	
	@ManyToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm; 
	@Required(message="Requiere udm")
	public Integer udm_id;
	
	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Producto producto; 
	@Required(message="Requiere producto")
	public Integer producto_id;
	
	@DecimalComa(value="")
	@Required(message="Requiere cantidad")
	public BigDecimal cantidad;

	@DecimalComa(value="")
	@Required(message="El monto límite es obligatorio")
	public BigDecimal precio;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor; 
	@Required(message="Requiere proveedor")
	public Integer proveedor_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica; 
	@Required(message="Requiere cuenta")
	public Integer cuenta_analitica_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy") 
	@Required(message="La fecha es obligatorio")
	public Date fecha; 
	
	public Date create_date; 
	
	public String numero_factura;
	
	@Required(message="Requiere inventariable")
	public Boolean inventariable;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	public Long create_usuario_id;

	public BigDecimal getTotal() {
		return cantidad.multiply(precio);
	}
	
	public static Finder<Long,CajaChicaMovimiento> find = new Finder<Long,CajaChicaMovimiento>(Long.class, CajaChicaMovimiento.class);
	
	

	 public static Pagination<CajaChicaMovimiento> page(Long cajaChicaId) {    	
	    	Pagination<CajaChicaMovimiento> p = new Pagination<CajaChicaMovimiento>();
	    	p.setOrderDefault("ASC");
	    	p.setSortByDefault("fecha");
	    	
	    	p.setExpressionList(find
				    			.fetch("cuentaAnalitica")
				    			.fetch("proveedor")
				    			.fetch("udm")
				    			.fetch("caja")
				    			.fetch("create_usuario")
				    			.fetch("producto")
	    						.where().eq("caja_chica_id", cajaChicaId));
	    	return p;
	 }

	public static List<SqlRow>  getResumenPresupuesto(Long idCaja){
		
		String sql = "select ca.nombre as cuenta,sum(cantidad*precio) as total " + 
				"from caja_chica_movimientos cpl " + 
				"inner join cuentas_analiticas ca on ca.id = cpl.cuenta_analitica_id " + 
				"where cpl.caja_chica_id = :idCaja " + 
				"group by ca.nombre ";
				
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				   .setParameter("idCaja", idCaja)
				   .findList();
		
		
		return s;
	}
	
}
