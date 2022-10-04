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
@Table(name = "pedidos_fondos_lineas")
public class PedidoFondoLinea extends Model {
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pedidos_fondos_lineas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="pedido_fondo_id", referencedColumnName="id", insertable=false, updatable=false)
	public PedidoFondo pedidoFondo;
	@Required(message="Debe tener un pedido fondo asociado")
	public Long pedido_fondo_id;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Requiere un expediente")
	public Long expediente_id;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	public Long proveedor_id;
	
	@DecimalComa(value="")
	@Required(message="Requiere monto")
	public BigDecimal monto;
	
	@Required(message="Requiere concepto")
	public String concepto;
	
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
	
	public static Model.Finder<Long,PedidoFondoLinea> find = new Finder<Long,PedidoFondoLinea>(Long.class, PedidoFondoLinea.class);
	
	public static Pagination<PedidoFondoLinea> page(Long pedidoFondoId) {    	
    	Pagination<PedidoFondoLinea> p = new Pagination<PedidoFondoLinea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("pedido_fondo_id", pedidoFondoId));
    	return p;
	}
}
