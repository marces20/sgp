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

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;
@Entity 
@Table(name = "pagos_lineas")
public class PagoLinea extends Model{
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pagos_lineas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Requiere Cuenta presupuestaria")
	public Long cuenta_analitica_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuenta;
	@Required(message="Requiere Cuenta")
	public Long cuenta_id;
	
	@ManyToOne
	@JoinColumn(name="pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public Pago pago;
	@Required(message="Debe tener un Pago asocidada")
	public Long pago_id;
	
	@DecimalComa(value="")
	public BigDecimal monto = new BigDecimal(0);
	
	@DecimalComa(value="")
	public BigDecimal monto_original = new BigDecimal(0);
	
	@DecimalComa(value="")
	public BigDecimal monto_credito = new BigDecimal(0);
	
	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	public Long periodo_id;
	
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
	
	public static Model.Finder<Long,PagoLinea> find = new Finder<Long,PagoLinea>(Long.class, PagoLinea.class);
	
	public static Pagination<PagoLinea> page(Long pagoId) {    	
    	Pagination<PagoLinea> p = new Pagination<PagoLinea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("pago_id", pagoId));
    	return p;
    }
}
