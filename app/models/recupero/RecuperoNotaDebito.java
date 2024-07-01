package models.recupero;

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

import models.Producto;
import models.Udm;
import models.Usuario;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_notas_debitos")
public class RecuperoNotaDebito extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_notas_debitos_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="recupero_factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoFactura recupero_factura;
	@Required(message="Debe tener una factura asociado")
	public Long recupero_factura_id;

	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public  Producto producto;
	@Required(message="Requiere producto")
	public Long producto_id;

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

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@Required(message="Debe escribir un numero")
	public String numero;

	@ManyToOne
	@JoinColumn(name="planilla_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoPlanilla planilla;
	@Required(message="Seleccion Planilla")
	public Integer planilla_id;

	public String cae;
	public Date fecha_vencimiento;

	public BigDecimal getTotal(){
		return cantidad.multiply(precio).setScale(2, RoundingMode.HALF_UP);
	}

	public static Model.Finder<Long,RecuperoNotaDebito> find = new Finder<Long,RecuperoNotaDebito>(Long.class, RecuperoNotaDebito.class);

	public static Pagination<RecuperoNotaDebito> page(Long recuperoFacturaId) {
    	Pagination<RecuperoNotaDebito> p = new Pagination<RecuperoNotaDebito>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");

    	p.setExpressionList(find.fetch("producto").where().eq("recupero_factura_id", recuperoFacturaId));
    	return p;
	}
}
