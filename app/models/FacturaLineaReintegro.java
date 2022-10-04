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
@Table(name = "factura_linea_reintegros")
public class FacturaLineaReintegro extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="factura_linea_reintegros_id_seq")
	public Long id;
	
	@Required(message="Requiere monto")
	@DecimalComa(value="")
	public BigDecimal monto;
	
	@ManyToOne
	@JoinColumn(name="cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuenta;
	@Required(message="Requiere Cuenta")
	public Long cuenta_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuentaImpuesto;
	public Long cuenta_impuesto_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Requiere Cuenta Presupuestaria")
	public Long cuenta_analitica_id;
	
	
	@ManyToOne
	@JoinColumn(name="factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public Factura factura;
	@Required(message="Debe tener una factura asociada")
	public Long factura_id;
	
	public String descripcion;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	
	public BigDecimal getTotal(){
		if (monto == null)
			return new BigDecimal(0);
		return monto;
	}
	
	public static Model.Finder<Long,FacturaLineaReintegro> find = new Finder<Long,FacturaLineaReintegro>(Long.class, FacturaLineaReintegro.class);
	
	public static Pagination<FacturaLineaReintegro> page(Long facturaId) {    	
    	Pagination<FacturaLineaReintegro> p = new Pagination<FacturaLineaReintegro>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("factura_id", facturaId));
    	return p;
	}
	
	
}
