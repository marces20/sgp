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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import models.Banco;
import models.Estado;
import models.SucursalBanco;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "recupero_cheques")
public class Cheque extends Model {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_cheques_id_seq")
	public Long id;
	

	@ManyToOne
	@JoinColumn(name="id_pago_recupero", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoPago pago;
	public Long id_pago_recupero;
	
	@Required(message="Debe escribir un número")
	public String numero;
	
	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;
	
	@ManyToOne
	@JoinColumn(name="banco_id", referencedColumnName="id", insertable=false, updatable=false)
	public Banco banco;
	@Required(message="Banco requerido")
	public Long banco_id;
	
	@ManyToOne
	@JoinColumn(name="sucursal_banco_id", referencedColumnName="id", insertable=false, updatable=false)
	public SucursalBanco sucursalBanco;
	@Required(message="Sucursal requerida")
	public Long sucursal_banco_id;
	
	public String observaciones;
	
	@DecimalComa(value="")
	@Required(message="Requiere monto")
	public BigDecimal monto;
	
	public static Model.Finder<Long,Cheque> find = new Model.Finder<Long,Cheque>(Long.class, Cheque.class);
	
	public static Pagination<Cheque> page(Long recuperoPagoId) {    	
    	Pagination<Cheque> p = new Pagination<Cheque>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("id_pago_recupero", recuperoPagoId));
    	return p;
	}
}
