package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.NumberUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;


@Entity
@Table(name = "ordenes_pagos")
public class OrdenPago extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordenes_pagos_id_seq")
	public Long id;

	@Required(message="Número requerido")
	public Integer numero;

	@Required(message="Monto requerido")
	@DecimalComa(value="")
	public BigDecimal monto;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@ManyToOne
	@JoinColumn(name="ejercicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Ejercicio ejercicio;

	@Required(message="Ejercicio requerido")
	public Long ejercicio_id;

	public String observacion;

	@ManyToOne
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;
	public Long orden_pago_id;

	@Transient
	public String nombreCompleto;

	public String getNombreCompleto(){

		if(numero != null && ejercicio != null) {
			return ejercicio.nombre != null ? NumberUtils.agregarCerosAlaIzquierda(numero, 4) + " / " + ejercicio.nombre : "";
		}else {
			return "";
		}


	}

	@Transient
	public String ordenEjercicio;

	public String getOrdenEjercicio(){
		return NumberUtils.agregarCerosAlaIzquierda(numero, 4)+" / "+ejercicio.nombre;
	}

	@PrePersist
	public void prePersit(){
		fecha = new Date();
	}

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
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="estado_id")
	public Long estado_id;

	@Formula(select = "_d${ta}.total_facturado", join = "LEFT OUTER JOIN (SELECT orden_pago_id,round(sum(precio * cantidad)::numeric,2) as total_facturado FROM facturas p INNER JOIN factura_lineas pl ON p.id = pl.factura_id GROUP BY orden_pago_id) as _d${ta} on _d${ta}.orden_pago_id = ${ta}.id")
	public BigDecimal total_facturado;

	@Formula(select = "_d1${ta}.fecha_pago", join = "LEFT OUTER JOIN ( select fecha_pago, orden_pago_id from pagos p where tipo = 'payment' and (fecha_pago, orden_pago_id) in (SELECT MAX(fecha_pago), orden_pago_id FROM pagos where tipo = 'payment' GROUP BY orden_pago_id)  GROUP BY orden_pago_id, fecha_pago) as _d1${ta} on _d1${ta}.orden_pago_id = ${ta}.id")
	public Date fecha_ultimo_pago;

	public BigDecimal getTotalFacturado(){
		if (total_facturado == null)
			return new BigDecimal(0);
		return total_facturado;
	}

	@Formula(select = "_p${ta}.total_pagado", join = "LEFT OUTER JOIN (SELECT orden_pago_id,round(SUM(COALESCE(pl.monto,0)-COALESCE(pl.monto_credito,0))::numeric,2) as total_pagado FROM pagos p INNER JOIN pagos_lineas pl ON p.id = pl.pago_id GROUP BY orden_pago_id) as _p${ta} on _p${ta}.orden_pago_id = ${ta}.id")
	public BigDecimal total_pagado;

	public BigDecimal getTotalPagado(){
		if (total_pagado == null)
			return new BigDecimal(0);
		return total_pagado;
	}

	public BigDecimal getTotalDeuda(){
		return getTotalFacturado().subtract(getTotalPagado());
	}

	public static Model.Finder<Long,OrdenPago> find = new Model.Finder<Long,OrdenPago>(Long.class, OrdenPago.class);

	public List<OrdenPago> getDataSuggest(String input,Integer limit){
		Integer m = 0;
		try{
			m = Integer.parseInt(input);
		}catch(NumberFormatException e){

		}

		Integer[] aa = {new Integer(1),new Integer(2),new Integer(3),new Integer(4),new Integer(5),new Integer(6),new Integer(7),new Integer(8)};

		List<OrdenPago> l = find.where()
				.eq("numero", m)
				.not(Expr.in("ejercicio_id",aa))
				.setMaxRows(limit).orderBy("numero")
			    .findList();
		return l;
	}

	public static Pagination<OrdenPago> page(String numero, String ejercicio_id,String fecha_ultimo_pago_desde,String fecha_ultimo_pago_hasta) {
    	Pagination<OrdenPago> p = new Pagination<OrdenPago>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<OrdenPago> e = find.where();

    	if(!fecha_ultimo_pago_desde.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_ultimo_pago_desde, "dd/MM/yyyy");
    		e.ge("fecha_ultimo_pago", fod);
    	}

		if(!fecha_ultimo_pago_hasta.isEmpty()){
    		Date foh = DateUtils.formatDate(fecha_ultimo_pago_hasta, "dd/MM/yyyy");
    		e.le("fecha_ultimo_pago", foh);
    	}

    	if(!numero.isEmpty())
    		e.eq("CAST(numero AS TEXT)",  numero );

    	if(!ejercicio_id.isEmpty())
    		e.eq("CAST(ejercicio_id AS TEXT)",  ejercicio_id );

    	p.setExpressionList( e );
    	return p;
    }

}
