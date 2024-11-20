package models.recupero;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import models.Cliente;
import models.CondicionIva;
import models.CondicionVenta;
import models.Estado;
import models.Expediente;
import models.Orden;
import models.OrdenLinea;
import models.Periodo;
import models.Producto;
import models.PuntoVenta;
import models.TipoResidencia;
import models.Usuario;
import models.auth.Permiso;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.annotation.Formula;

import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_facturas")
public class RecuperoFactura extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_facturas_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;
	@Required(message="Debe tener un cliente asociado")
	public Long cliente_id;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	public String serie;
	//@Required(message="Debe escribir un numero")
	public String numero;
	public String nombre;
	public String nota;
	public String tipo_pago;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id;

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
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	public Integer periodo_id;

	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Integer expediente_id;

	@ManyToOne
	@JoinColumn(name="planilla_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoPlanilla planilla;
	@Required(message="Seleccion Planilla")
	public Integer planilla_id;

	@ManyToOne
	@JoinColumn(name="presupuesto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Presupuesto presupuesto;
	public Integer presupuesto_id;

	@ManyToOne
	@JoinColumn(name="puntoventa_id", referencedColumnName="id", insertable=false, updatable=false)
	public PuntoVenta puntoVenta;
	@Required(message="Seleccion punto venta")
	public Integer puntoventa_id;


	public Long id_factura_materno;
	public String cae;
	public Date fecha_vencimiento;
	public Date fecha_emision;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_desde;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_hasta;

	@ManyToOne
	@JoinColumn(name="condicioniva_id", referencedColumnName="id", insertable=false, updatable=false)
	public CondicionIva condicionIva;
	public Integer condicioniva_id;

	@ManyToOne
	@JoinColumn(name="condicionventa_id", referencedColumnName="id", insertable=false, updatable=false)
	public CondicionVenta condicionVenta;
	public Integer condicionventa_id;

	@ManyToOne
	@JoinColumn(name="recupero_tipo_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoTipoPago recuperoTipoPago;
	@Required(message="Seleccion Tipo Pago")
	@Column(name="recupero_tipo_pago_id")
	public Long recupero_tipo_pago_id;


	@Formula(select = "_c${ta}.base", join = "left outer join (select recupero_factura_id, round(sum(precio * cantidad)::numeric,2) as base from recupero_factura_lineas group by recupero_factura_id) as _c${ta} on _c${ta}.recupero_factura_id = ${ta}.id")
	public BigDecimal base;//Base
	public BigDecimal getBase(){
		if (base == null)
			return new BigDecimal(0);
		return base;
	}

	@Formula(select = "_b${ta}.total_nota_credito", join = "left outer join (select recupero_factura_id,  round(sum(precio * cantidad)::numeric,2) as total_nota_credito from recupero_notas_creditos group by recupero_factura_id) as _b${ta} on _b${ta}.recupero_factura_id = ${ta}.id")
	public BigDecimal total_nota_credito;

	public BigDecimal getTotalNotaCredito(){
		if (total_nota_credito == null)
			return new BigDecimal(0);
		return total_nota_credito;
	}

	@Formula(select = "_nd${ta}.total_nota_debito", join = "left outer join (select recupero_factura_id,  round(sum(precio * cantidad)::numeric,2) as total_nota_debito from recupero_notas_debitos group by recupero_factura_id) as _nd${ta} on _nd${ta}.recupero_factura_id = ${ta}.id")

	public BigDecimal total_nota_debito;

	public BigDecimal getTotalNotaDebito(){
		if (total_nota_debito == null)
			return new BigDecimal(0);
		return total_nota_debito;
	}

	public BigDecimal getTotal(){
		return getBase().subtract(getTotalNotaCredito()).add(getTotalNotaDebito());
	}

	public BigDecimal getTotalFacturado(){
		return getBase();
	}

	@Formula(select = "_d${ta}.total_pagado", join = "LEFT OUTER JOIN (select p.recupero_factura_id, COALESCE(sum(p.total),0) as total_pagado "
			+ "FROM recupero_pagos p WHERE p.recupero_nota_debito_id is null and p.recupero_nota_credito_id is null and  p.estado_id = "+Estado.RECUPERO_PAGO_PAGADO+" GROUP BY p.recupero_factura_id) as _d${ta} on _d${ta}.recupero_factura_id = ${ta}.id")
	public BigDecimal total_pagado;

	public BigDecimal getPagado(){
		if (total_pagado == null || total_pagado.compareTo(BigDecimal.ZERO) == 0)
			return new BigDecimal(0);
		if(recupero_tipo_pago_id.equals(new Long(1))) {
			return  total_pagado.subtract(getTotalNotaCredito()).add(getTotalNotaDebito());
		}else {
			return  total_pagado;
		}
	}


	public BigDecimal getPorcentajePagado () {
		if(total_pagado == null || total_pagado.compareTo(BigDecimal.ZERO) == 0 || getTotal().compareTo(BigDecimal.ZERO) == 0)
			return new BigDecimal(0);

		return getPagado().multiply(new BigDecimal(100)).divide(getTotal(), 2, java.math.RoundingMode.HALF_UP);
	}

	public BigDecimal getSaldoPendiente(){


		return  getTotal().subtract(getPagado());
	}

	/*@Formula(select = "_de${ta}.deuda", join = "left outer join (select id, round(sum(total_deuda::numeric),2) as deuda from informe_totales_recupero group by id) as _de${ta} on _de${ta}.id = ${ta}.id")
	public BigDecimal deuda;
	public BigDecimal getDeuda(){
		if (deuda == null)
			return new BigDecimal(0);
		return deuda;
	}*/

	@OneToMany()
	public List<RecuperoFacturaLinea> recuperoFacturaLinea;

	@OneToMany
	public List<RecuperoNotaCredito> recuperoNotaCredito;

	@OneToMany
	public List<RecuperoNotaDebito> recuperoNotaDebito;

	@OneToMany
	@JoinColumn(name="recupero_factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<RecuperoPago> pagos;

	public String getNumeroFactura(){
		String puntoventa = (puntoventa_id != null)?puntoVenta.numero:"";
		return serie+puntoventa+"-"+numero;
	}

	public static Model.Finder<Long,RecuperoFactura> find = new Finder<Long,RecuperoFactura>(Long.class, RecuperoFactura.class);

	public static Pagination<RecuperoFactura> page(String nombre,
												   String numero,
											  	   String cliente,
												   String desde,
												   String hasta,
												   String filtroBorrador,
												   String filtroEnCurso,
												   String filtroAprobada,
												   String filtroCancelada,
												   String filtroPagado,
												   String puntoventa_id,
												   String planilla_id,
												   String deposito,
												   String create_usuario_id,
												   String numero_nc,
												   String numero_nd
												   ) {
    	Pagination<RecuperoFactura> p = new Pagination<RecuperoFactura>();
    	p.setOrderDefault("desc");
    	p.setSortByDefault("numero");

    	ExpressionList<RecuperoFactura> e = find
    										.fetch("planilla")
    										.fetch("estado")
    										.fetch("periodo")
    										.fetch("cliente")
    										.where();

    	if(!planilla_id.isEmpty()) {
    		e.eq("planilla_id", Integer.parseInt(planilla_id));
    	}

    	if(!create_usuario_id.isEmpty()) {
    		e.eq("create_usuario_id", Integer.parseInt(create_usuario_id));
    	}

    	if(!numero_nc.isEmpty()) {
    		e.ilike("recuperoNotaCredito.numero", "%"+numero_nc+"%");
    	}

    	if(!numero_nd.isEmpty()) {
    		e.ilike("recuperoNotaDebito.numero", "%"+numero_nd+"%");
    	}

    	if(!nombre.isEmpty()) {
    		e.ilike("nombre", "%"+nombre+"%");
    	}
    	if(!numero.isEmpty()) {
    		e.ilike("numero", "%"+numero+"%");
    	}
    	if(!cliente.isEmpty()) {
    		e.eq("cliente_id", Integer.parseInt(cliente));
    	}
    	if(!deposito.isEmpty()) {
    		e.eq("planilla.deposito_id", Integer.parseInt(deposito));
    	}
    	if(!puntoventa_id.isEmpty()) {
    		e.eq("puntoventa_id", Integer.parseInt(puntoventa_id));
    	}
		if(!desde.isEmpty()){
    		Date fd = DateUtils.formatDate(desde, "dd/MM/yyyy");
    		e.ge("fecha", fd);
    	}

		if(!hasta.isEmpty()){
    		Date fh = DateUtils.formatDate(hasta, "dd/MM/yyyy");
    		e.le("fecha", fh);
    	}

    	if(!filtroPagado.isEmpty() || !filtroBorrador.isEmpty() || !filtroAprobada.isEmpty() || !filtroCancelada.isEmpty() || !filtroEnCurso.isEmpty()) {
    		e = e.disjunction();
    		if(!filtroPagado.isEmpty()){
    			e = e.conjunction().gt("total_pagado", 0);
	   		}

	   		if(!filtroBorrador.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_FACTURA_BORRADOR);
	   		}

	   		if(!filtroAprobada.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_FACTURA_APROBADO);
	   		}

	   		if(!filtroCancelada.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_FACTURA_CANCELADO);
	   		}

	   		if(!filtroEnCurso.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_FACTURA_ENCURSO);
	   		}

	   		e = e.endJunction();
    		p.parcheCountAllFormula = true;
    	}

    	if(!Permiso.check("verTodoRecupero")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("puntoVenta.deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("puntoVenta.deposito_id");
    		}
    	}

    	if(p.parcheCountAllFormula)
    		p.setTotalRowCount(e.findList().size());



    	p.setExpressionList(e);
    	return p;
	}

	public boolean controlPermisoDeposito() {
		boolean r = true;
		if(!Permiso.check("verTodoRecupero")){
			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null && planilla != null){
				RecuperoPlanilla rp = RecuperoPlanilla.find.byId(planilla_id.longValue());

				if(Usuario.getUsurioSesion().organigrama.id.equals(new Integer(178))){//INSTITUTO GENETICA HUMANA
					r = true;
	    		}else if(Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(rp.deposito_id) != 0) {
					r = false;
				}
			}else {
				r = false;
			}
		}

		return r;
	}

	public List<RecuperoFactura> getDataSuggest(String input,Integer limit){
		ExpressionList<RecuperoFactura> l = find.fetch("cliente", "nombre").fetch("puntoVenta", "numero").where().eq("estado_id", Estado.RECUPERO_FACTURA_APROBADO).ilike("numero", "%"+input+"%");


		List<RecuperoFactura>	r =	l.setMaxRows(limit).orderBy("id desc").findList();

		return r;
	}

	public static Date getLastDateByPunto(Integer puntoVenta) {

		Date ret = null;
		String sql = "select fecha from ";
		 sql += "( ";
		 		sql += "select fecha from recupero_facturas rf ";
				sql += "inner join punto_ventas pv on pv.id = rf.puntoventa_id ";
				sql += "where rf.cae is not null and pv.tipo_facturacion = 'ws' and pv.id = :puntoVenta ";
				sql += "union ";
				sql += "select fecha from recupero_notas_creditos nc ";
				sql += "inner join punto_ventas pv on pv.id = nc.puntoventa_id ";
				sql += "where nc.cae is not null and pv.tipo_facturacion = 'ws' and pv.id = :puntoVenta ";
				sql += "union ";
				sql += "select fecha from recupero_notas_creditos nd ";
				sql += "inner join punto_ventas pv on pv.id = nd.puntoventa_id ";
				sql += "where nd.cae is not null and pv.tipo_facturacion = 'ws' and pv.id = :puntoVenta ";
				sql += ") as comprobantes ";
				sql += "order by fecha desc limit 1 ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("puntoVenta", puntoVenta);

		SqlRow  row = sqlQuery.findUnique();
		if(row != null) {
			ret = row.getDate("fecha");
		}

		return ret;

	}

}
