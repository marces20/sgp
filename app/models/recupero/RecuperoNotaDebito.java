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

import com.avaje.ebean.ExpressionList;

import models.Producto;
import models.PuntoVenta;
import models.Udm;
import models.Usuario;
import models.auth.Permiso;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
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

	//@Required(message="Debe escribir un numero")
	public String numero;

	@ManyToOne
	@JoinColumn(name="planilla_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoPlanilla planilla;
	@Required(message="Seleccion Planilla")
	public Integer planilla_id;

	@ManyToOne
	@JoinColumn(name="puntoventa_id", referencedColumnName="id", insertable=false, updatable=false)
	public PuntoVenta puntoVenta;
	@Required(message="Seleccion punto venta")
	public Integer puntoventa_id;

	public String cae;
	public Date fecha_vencimiento;

	public String nota;

	public Integer id_nota_materno;


	public BigDecimal getTotal(){
		return cantidad.multiply(precio).setScale(2, RoundingMode.HALF_UP);
	}

	public String getNumero(){
		String puntoventa = (puntoventa_id != null)?puntoVenta.numero:"";
		String nn = (numero != null)?numero:"";
		return puntoventa+"-"+nn;
	}

	public static Model.Finder<Long,RecuperoNotaDebito> find = new Finder<Long,RecuperoNotaDebito>(Long.class, RecuperoNotaDebito.class);

	public static Pagination<RecuperoNotaDebito> page(Long recuperoFacturaId,
			String numero,
			String puntoventa_id,
			String cliente_id,
			String fecha_desde,
			String fecha_hasta,
		  	String planilla_id,
		  	String create_usuario_id) {

		Pagination<RecuperoNotaDebito> p = new Pagination<RecuperoNotaDebito>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("fecha");

    	ExpressionList<RecuperoNotaDebito> e = find.fetch("recupero_factura")
												.fetch("puntoVenta")
												.fetch("planilla")
												.fetch("create_usuario")
												.fetch("udm")
												.fetch("producto").where();

    	if(recuperoFacturaId != null) {
    		e.eq("recupero_factura_id", recuperoFacturaId);
    	}

    	if(!planilla_id.isEmpty()) {
    		e.eq("planilla_id", Integer.parseInt(planilla_id));
    	}
    	if(!numero.isEmpty()) {
    		e.ilike("numero", "%"+numero+"%");
    	}
    	if(!cliente_id.isEmpty()) {
    		e.eq("recupero_factura.cliente_id", Integer.parseInt(cliente_id));
    	}
    	if(!puntoventa_id.isEmpty()) {
    		e.eq("puntoventa_id", Integer.parseInt(puntoventa_id));
    	}
		if(!fecha_desde.isEmpty()){
    		Date fd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		e.ge("fecha", fd);
    	}
		if(!fecha_hasta.isEmpty()){
    		Date fh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		e.le("fecha", fh);
    	}
		if(!create_usuario_id.isEmpty()) {
    		e.eq("create_usuario_id", Integer.parseInt(create_usuario_id));
    	}

		if(!Permiso.check("verTodoRecupero")){
			if(Usuario.getUsurioSesion().organigrama.id.equals(new Integer(178))){
    			e.eq("puntoventa_id", 14);
    		}else if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("planilla.deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("planilla.deposito_id");
    		}
    	}

    	if(p.parcheCountAllFormula)

    		p.setTotalRowCount(e.findList().size());

    	p.setExpressionList(e);
    	return p;
	}
}
