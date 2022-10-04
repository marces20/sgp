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
@Table(name = "recupero_pago_lineas")
public class RecuperoPagoLinea extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_pago_lineas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="recupero_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoPago recupero_pago;
	@Required(message="Debe tener un pago asociado")
	public Long recupero_pago_id;
	
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
	@Required(message="Requiere monto")
	public BigDecimal monto;
	
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
		return monto;
	}
	
	public static Model.Finder<Long,RecuperoPagoLinea> find = new Finder<Long,RecuperoPagoLinea>(Long.class, RecuperoPagoLinea.class);
	
	public static Pagination<RecuperoPagoLinea> page(Long recuperoPagoId) {    	
    	Pagination<RecuperoPagoLinea> p = new Pagination<RecuperoPagoLinea>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("recupero_pago_id", recuperoPagoId));
    	return p;
	}
}
