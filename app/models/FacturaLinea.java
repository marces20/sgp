package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "factura_lineas")
public class FacturaLinea extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="factura_lineas_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm;
	@Required(message="Requiere udm")
	public Long udm_id;

	@ManyToOne
	@JoinColumn(name="factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public Factura factura;
	@Required(message="Debe tener una factura asociada")
	public Long factura_id;

	@ManyToOne
	public Proveedor proveedor;

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
	@JoinColumn(name="cuenta_analitica_original_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnaliticaOriginal;
	@Required(message="Requiere Cuenta Presupuestaria Inicial")
	public Long cuenta_analitica_original_id;

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

	@Transient
	public BigDecimal subtotal;

	@Transient
	public BigDecimal totalDescuento;

	@DecimalComa(value="")
	public BigDecimal descuento;

	public String nota;

	public String nombre;

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

	public BigDecimal getTotalDescuento(){
		if (descuento == null)
			return new BigDecimal(0);
		return cantidad.multiply(precio).multiply(descuento).divide(new java.math.BigDecimal("100"));
	}

	public BigDecimal getTotal(){
		return cantidad.multiply(precio).subtract(getTotalDescuento()).setScale(2, RoundingMode.HALF_UP);
	}

	public String getTotalMoneda(){
		if(getTotal() != null){
			return  utils.NumberUtils.moneda(getTotal());
		}else{
			return "";
		}
	}

	public static Model.Finder<Long,FacturaLinea> find = new Finder<Long,FacturaLinea>(Long.class, FacturaLinea.class);

	 public static Pagination<FacturaLinea> page(Long facturaId) {
	    	Pagination<FacturaLinea> p = new Pagination<FacturaLinea>();
	    	p.setOrderDefault("ASC");
	    	p.setSortByDefault("producto.nombre");

	    	p.setExpressionList(find.fetch("producto").where().eq("factura_id", facturaId));
	    	return p;
	 }

	 public static boolean modificarCuentaAnaliticaPorFactura(List<Factura> lf){

		 	for(Factura f : lf){
		 		if(f.expediente.residuo_pasivo != null && f.expediente.residuo_pasivo){
			 		Long idCuenta = null;

					if(f.expediente.ejercicio_id.compareTo(new Long(5))== 0){
						idCuenta = new Long(528);
					}else if(f.expediente.ejercicio_id.compareTo(new Long(4))== 0){
						idCuenta = new Long(376);
					}else if(f.expediente.ejercicio_id.compareTo(new Long(3))== 0){
						idCuenta = new Long(234);
					}else if(f.expediente.ejercicio_id.compareTo(new Long(6))== 0){
						idCuenta = new Long(529);
					}else if(f.expediente.ejercicio_id.compareTo(new Long(7))== 0){
						idCuenta = new Long(590);
					}if(f.expediente.ejercicio_id.compareTo(new Long(8))== 0){
						idCuenta = new Long(794);
					}if(f.expediente.ejercicio_id.compareTo(new Long(9))== 0){
						idCuenta = new Long(832);
					}if(f.expediente.ejercicio_id.compareTo(new Long(12))== 0){
						idCuenta = new Long(833);
					}if(f.expediente.ejercicio_id.compareTo(new Long(13))== 0){
						idCuenta = new Long(1047);
					}if(f.expediente.ejercicio_id.compareTo(new Long(14))== 0){
						idCuenta = new Long(1752);
					}if(f.expediente.ejercicio_id.compareTo(new Long(15))== 0){
						idCuenta = new Long(2113);
					}


					SqlUpdate update = Ebean.createSqlUpdate("UPDATE factura_lineas " +
							"SET cuenta_analitica_id = :idCuenta, write_date = :write_date,write_usuario_id = :write_usuario_id " +
							"WHERE factura_id = :idFactura ");
					update.setParameter("idCuenta", idCuenta);
					update.setParameter("write_date",new Date());
					update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
					update.setParameter("idFactura", f.id);
					update.execute();
		 		}
		 	}
			return true;
		}
}
