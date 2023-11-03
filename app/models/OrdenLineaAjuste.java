package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
@Table(name = "orden_lineas_ajustes")
public class OrdenLineaAjuste extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orden_lineas_ajustes_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden orden;
	@Required(message="Debe tener una orden asociada")
	public Long orden_id;

	@ManyToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm;
	@Required(message="Requiere udm")
	public Long udm_id;

	@Required(message="Requiere precio")
	@DecimalComa(value="")
	public BigDecimal precio;

	@Required(message="Requiere cantidad")
	@DecimalComa(value="")
	public BigDecimal cantidad;

	@ManyToOne
	public Proveedor proveedor;

	public String nota;
	public boolean ajuste_automatico;

	public boolean suma_precio = true;

	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public  Producto producto;
	@Required(message="Requiere producto")
	public Long producto_id;

	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Requiere cuenta presupuestaria")
	public Long cuenta_analitica_id;

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

	@ManyToOne
	@JoinColumn(name="periodo_inicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo_inicio;
	public Long periodo_inicio_id;

	@ManyToOne
	@JoinColumn(name="periodo_fin_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo_fin;
	public Long periodo_fin_id;

	public BigDecimal getTotal(){
		return cantidad.multiply(precio).setScale(2, RoundingMode.HALF_UP);
	}

	public static Model.Finder<Long,OrdenLineaAjuste> find = new Finder<Long,OrdenLineaAjuste>(Long.class, OrdenLineaAjuste.class);

	public static Pagination<OrdenLineaAjuste> page(Long ordenId) {
		Pagination<OrdenLineaAjuste> p = new Pagination<OrdenLineaAjuste>();
		p.setOrderDefault("DESC");
		p.setSortByDefault("id");
		p.setExpressionList(find.fetch("producto").where().eq("orden_id", ordenId));

		return p;
	}

}
