package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import models.auth.Permiso;
import models.haberes.LiquidacionMes;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.StringUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;

@Entity
@Table(name = "facturas")
public class Factura extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="facturas_id_seq")
	public Long id;
	public String comentario;
	public String referencia;
	public String numero;
	public Integer numero_planilla;

	@DecimalComa(value="")
	public BigDecimal cot_dolar;

	@ManyToOne
	@JoinColumn(name="state_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;

	@Column(name="state_id")
	public Long estado_id;

	@Formula(select = "_b${ta}.total_impuesto", join = "left outer join (select factura_id,  round(sum(monto)::numeric,2) as total_impuesto from factura_linea_impuestos group by factura_id) as _b${ta} on _b${ta}.factura_id = ${ta}.id")
	public BigDecimal total_impuesto;
	@Formula(select = "_c${ta}.base", join = "left outer join (select factura_id, round(sum(precio * cantidad)::numeric,2) as base from factura_lineas group by factura_id) as _c${ta} on _c${ta}.factura_id = ${ta}.id")
	public BigDecimal base;//Base

	@Formula(select = "_re${ta}.total_reintegro", join = "left outer join (select factura_id,  round(sum(monto)::numeric,2) as total_reintegro from factura_linea_reintegros group by factura_id) as _re${ta} on _re${ta}.factura_id = ${ta}.id")
	public BigDecimal total_reintegro;

	//suma de lines del pago relacionado con la factura, estado del pago tiene que ser = 23

	@Formula(select = "_d${ta}.total_pagado", join = "LEFT OUTER JOIN (select p.factura_id, round(sum(pl.monto)::numeric,2)-round(sum(pl.monto_credito),2) as total_pagado FROM pagos p INNER JOIN pagos_lineas pl ON p.id = pl.pago_id WHERE p.state_id = "+Estado.PAGO_ESTADO_CONCILIADO+" OR p.state_id = "+Estado.PAGO_ESTADO_PAGADO+" GROUP BY factura_id) as _d${ta} on _d${ta}.factura_id = ${ta}.id")
	public BigDecimal total_pagado;

	public BigDecimal getTotalPagado(){
		if (total_pagado == null)
			return new BigDecimal(0);
		return total_pagado;
	}

	public BigDecimal getSaldoPendiente(){
		if (total_pagado == null)
			return getBase();
		return  getBase().subtract(getTotalReintegros()).subtract(total_pagado);
	}

	public BigDecimal getTotalImpuesto(){
		if (total_impuesto == null)
			return new BigDecimal(0);
		return total_impuesto;
	}

	public BigDecimal getTotalReintegros(){
		if (total_reintegro == null)
			return new BigDecimal(0);
		return total_reintegro;
	}

	public BigDecimal getBase(){
		if (base == null)
			return new BigDecimal(0);
		return base;
	}

	public BigDecimal getTotal(){
		return getBase().subtract(getTotalImpuesto()).subtract(getTotalReintegros());

	}

	public String getBaseMoneda(){
		if(base != null){
			return  utils.NumberUtils.moneda(base);
		}else{
			return "";
		}
	}

	@Column(insertable=false, updatable=false)
	public String tipo = "proveedor";

	@Required(message="Requiere referencia")
	public String nombre;//Valor de referencia de la OC X

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_factura;//Fecha Factura X

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_orden_pago;//Fecha 0rden de Pago X

	public Integer numero_orden_pago;//N Orden de Pago X
	public Boolean profe;
	public Boolean debe_dgr = false;
	public Boolean debe_afip = false;
	public Boolean debe_judicial = false;
	public Boolean debe_dgr_aguinaldo = false;
	public Boolean creacion_automatica = false;
	public Boolean produccion = false;
	public Boolean debito_automatico = false;
	public Boolean fondo_cerrado = false;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_recepcion;//Fecha Recepcion X de Factura
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_aprobacion;//Fecha Aprobacion
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_vencimiento_322;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_pago;

	@ManyToOne
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;

	//@Required(message="Requiere orden de pago")
	public Long orden_pago_id;

	@ManyToOne
	public Usuario usuario;
	/*@ManyToOne
	public CuentaBancaria cuenta_bancaria;*/

	@ManyToOne
	@JoinColumn(name="certificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public Certificacion certificacion;
	public Integer certificacion_id;

	@ManyToOne
	@JoinColumn(name="certificacion_compra_id", referencedColumnName="id", insertable=false, updatable=false)
	public CertificacionCompra certificacionCompra;
	public Integer certificacion_compra_id;

	@ManyToOne
	@JoinColumn(name="liquidacion_mes_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionMes liquidacionMes;
	public Integer liquidacion_mes_id;

	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Requiere proveedor")
	public Integer proveedor_id;//Proveedor X

	//@Required(message="Requiere N° de Factura")
	public String numero_factura;//Numero de Factura X

	@ManyToOne
	@JoinColumn(name="cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuenta;
	@Required(message="Requiere cuenta")
	public Integer cuenta_id;//Cuenta X

	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	public Integer periodo_id;//Periodo X

	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Requiere expediente")
	public Integer expediente_id;//Expediente X

	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden orden;
	public Integer orden_id;//Expediente X

	@OneToMany
	public List<FacturaLinea> facturaLinea;
	@OneToMany
	public List<FacturaLineaImpuesto> facturaLineaImpuesto;

	public Boolean rechazado;

	public Boolean agente_pago_externo;

	@OneToMany
	public List<FacturaRechazo> facturaRechazo;


	/*@ManyToMany
	@JoinTable(name = "facturas_actas", joinColumns={ @JoinColumn(name="factura_id")}, inverseJoinColumns={@JoinColumn(name="acta_id")})
	public List<ActaRecepcion> actas;*/



	public Boolean parcial;

	//@OneToMany(mappedBy="factura_principal_id")
	//public List<Factura> facturaParciales;

	@OneToMany(mappedBy = "facturaPrincipal")
	public List<Factura> facturaParciales;

	@ManyToOne
	@JoinColumn(name="factura_principal_id", referencedColumnName="id", insertable=false, updatable=false)
	public Factura facturaPrincipal;
	@Column(name="factura_principal_id")
	public Long factura_principal_id;

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
	@JoinColumn(name="autorizado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Autorizado autorizado;
	@Column(name="autorizado_id")
	public Long autorizado_id;

	@ManyToOne
	@JoinColumn(name="tipo_cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoCuenta tipoCuenta;
	@Required(message="Tipo Cuenta requerido")
	public Long tipo_cuenta_id;

	public static Finder<Long,Factura> find = new Finder<Long,Factura>(Long.class, Factura.class);

	public List<Factura> getDataSuggest(String input,Integer limit){
		List<Factura> l = find
				.fetch("usuario")
    			.fetch("proveedor")
    			.fetch("expediente")
    			.fetch("ordenPago")
    			.fetch("periodo")
				.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();

		return l;
	}




	public static Pagination<Factura> page(String numero_factura,
											String proveedor,
											String create_usuario,
											String expediente,
											String periodo,
											String ejercicio,
											String orden_pago,
											String fecha_factura_desde,
											String fecha_factura_hasta,
											String fecha_op_desde,
											String fecha_op_hasta,
											String profe,
											String prestador,
											String referencia,
											String tipo_proveedor,
											String fecha_aprobacion_desde,
											String fecha_aprobacion_hasta,
											String btnFiltro0,//borrador
											String btnFiltro1,//imputado
											String btnFiltro2,//abierta
											String btnFiltro3,//pagada
											String btnFiltro4,//cancelada
											String btnFiltro5,//debedgr
											String btnFiltro6, //debeafip
											String btnFiltro7, //preaprobada
											String btnFiltro8, //rechazada
											String btnFiltro9, //precurso
											String guardia, //guardia
											String desc_ret,
											String cuenta_impuesto,
											String acta,
											String tipo_cuenta_id,
											String deposito_id,
											String emergencia
											){

    	Pagination<Factura> p = new Pagination<Factura>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("proveedor.nombre, periodo_id DESC,id");


    	ExpressionList<Factura> e = find
    			.select("id, estado_id, periodo_id, rechazado, nombre, numero_factura, parcial, total_pagado, base, total_reintegro, facturaPrincipal, total_impuesto")
    			.fetch("proveedor", "nombre")
    			.fetch("expediente", "nombre, id, emergencia")
    			.fetch("expediente.ejercicio", "nombre")
    			.fetch("tipoCuenta", "nombre")
    			.fetch("expediente.parent.ejercicio", "nombre")
    			.fetch("periodo", "nombre")
    			.fetch("estado", "nombre")
    			.fetch("ordenPago", "nombreCompleto")
    			.fetch("ordenPago", "numero")
    			.fetch("ordenPago.ejercicio", "nombre")
    			.where();


    	if(Usuario.getUsurioSesion().plansumarmaterno) {
			e = e.eq("tipo_cuenta_id",TipoCuenta.FONDO_PERMANENTE_MATERNO);
    	}

    	if(Usuario.getUsurioSesion().obera) {
			Date fdesde = DateUtils.formatDate("01/08/2022", "dd/MM/yyyy");
			e = e.ge("create_date", fdesde);
    	}

    	if(Usuario.getUsurioSesion().plansumarmaterno || Usuario.getUsurioSesion().obera) {
			e = e.disjunction();
			e = e.in("orden.deposito_id",Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
			e = e.endJunction();

    	}


    	if(!desc_ret.isEmpty()){
    		e.ilike("facturaLineaImpuesto.nombre", "%" + desc_ret + "%");
    	}

    	if(!tipo_cuenta_id.isEmpty()){
    		e.eq("tipo_cuenta_id", Integer.parseInt(tipo_cuenta_id));
    	}

    	if(!acta.isEmpty()){
    		e.ilike("actas.numero", acta);
    	}

    	if(!numero_factura.isEmpty()){
    		e.ilike("numero_factura", "%" + numero_factura + "%");
    	}

    	if(!referencia.isEmpty()){
    		e.ilike("nombre", "%" + referencia + "%");
    	}

    	if(!proveedor.isEmpty()){
    		e.eq("proveedor_id", Integer.parseInt(proveedor));
    	}

    	if(!deposito_id.isEmpty()){
    		e.eq("orden.deposito_id", Integer.parseInt(deposito_id));
    	}

    	if(!create_usuario.isEmpty()){
			e.eq("create_usuario.id", Integer.parseInt(create_usuario));
    	}

    	if(!expediente.isEmpty()){

    		Expediente ePadre = Expediente.find.byId(new Long(expediente));

    		List<Object> ePadre2 = Expediente.find.where().eq("parent_id", new Long(expediente)).findIds();

    		if(ePadre2.isEmpty() && ePadre.parent == null){
    			e = e.eq("expediente_id", Integer.parseInt(expediente));
    		}else{
	    		e = e.disjunction();
	    			e = e.eq("expediente_id", Integer.parseInt(expediente));
		    		if(ePadre.parent != null){

		    			e = e.eq("expediente_id", ePadre.parent_id);
		    			List<Object> ePadre3 = Expediente.find.where().eq("parent_id", ePadre.parent_id).findIds();
		    			e = e.in("expediente_id", ePadre3);
		    		}else{
		    			//ePadre = Expediente.find.where().eq("parent_id", new Long(expediente)).findUnique();
		    		 	e = e.in("expediente_id", ePadre2);
		    		}
				e = e.endJunction();
    		}
    	}
    	if(!periodo.isEmpty()){
			e.eq("periodo_id", Integer.parseInt(periodo));
		}
    	if(!ejercicio.isEmpty()){
			e.eq("expediente.ejercicio_id", Integer.parseInt(ejercicio));
		}
    	if(!orden_pago.isEmpty()){
    		e.eq("ordenPago.id", Integer.parseInt(orden_pago));
    	}


		if(!fecha_op_desde.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_op_desde, "dd/MM/yyyy");
    		e.ge("fecha_orden_pago", fod);
    	}

		if(!fecha_op_hasta.isEmpty()){
    		Date foh = DateUtils.formatDate(fecha_op_hasta, "dd/MM/yyyy");
    		e.le("fecha_orden_pago", foh);
    	}

		if(!fecha_factura_desde.isEmpty()){
    		Date ffd = DateUtils.formatDate(fecha_factura_desde, "dd/MM/yyyy");
    		e.ge("fecha_factura", ffd);
    	}
		if(!fecha_factura_hasta.isEmpty()){
    		Date ffh = DateUtils.formatDate(fecha_factura_hasta, "dd/MM/yyyy");
    		e.le("fecha_factura", ffh);
    	}
		if(!fecha_aprobacion_desde.isEmpty()){
    		Date fad = DateUtils.formatDate(fecha_aprobacion_desde, "dd/MM/yyyy");
    		e.ge("fecha_aprobacion", fad);
    	}
		if(!fecha_aprobacion_hasta.isEmpty()){
    		Date fah = DateUtils.formatDate(fecha_aprobacion_hasta, "dd/MM/yyyy");
    		e.le("fecha_aprobacion", fah);
    	}

		/*if(!profe.isEmpty()){
			e.eq("profe",Boolean.parseBoolean(profe));
		}*/

		if(!profe.isEmpty()){
    		if(profe.compareToIgnoreCase("SI") == 0){
    			e.eq("profe", true);
    		}else{
    			e.eq("profe", false);
    		}
    	}

		if(!emergencia.isEmpty()){
    		if(emergencia.compareToIgnoreCase("SI") == 0){
    			e.eq("expediente.emergencia", true);
    		}else{
    			e.eq("expediente.emergencia", false);
    		}
    	}

		if(!guardia.isEmpty()){
			e.eq("expediente.guardia",Boolean.parseBoolean(guardia));
		}

		if(!prestador.isEmpty()){
			//e.eq("profe",Boolean.parseBoolean(profe));
		}

		if(!cuenta_impuesto.isEmpty()){
		 e.in("facturaLineaImpuesto.cuenta_id", Integer.parseInt(cuenta_impuesto));
		}

		boolean tipoProveedorAgente = false;
    	switch (tipo_proveedor) {
			case Proveedor.TIPO_INTERNO:
				e.isNotNull("proveedor.agente_id");
				tipoProveedorAgente = true;
				break;
			case Proveedor.TIPO_EXTERNO:
				e = e.disjunction();
				e = e.isNull("proveedor.agente_id");
				e = e.eq("agente_pago_externo",true);
				e = e.endJunction();
				break;
			case Proveedor.TIPO_AGENTE_INTERNO:
				e.isNotNull("proveedor.agente_id").eq("proveedor.agente.planta", false);
				tipoProveedorAgente = true;
				break;
			case Proveedor.TIPO_AGENTE_PLANTA:
				e.eq("proveedor.agente.planta", true);
				tipoProveedorAgente = true;
				break;
		}

		if(tipoProveedorAgente){
			e.isNull("agente_pago_externo");
		}

		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty() || !btnFiltro4.isEmpty() || !btnFiltro7.isEmpty() || !btnFiltro8.isEmpty() || !btnFiltro9.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.FACTURA_ESTADO_BORRADOR);
			}
			if(!btnFiltro9.isEmpty()){
				 e = e.eq("estado_id", Estado.FACTURA_ESTADO_PRECURSO);
			}
			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.FACTURA_ESTADO_ENCURSO);
			}
			if(!btnFiltro2.isEmpty()){

				 e.conjunction().eq("estado_id", Estado.FACTURA_ESTADO_APROBADO).isNull("total_pagado");
					p.parcheCountAllFormula = true;

			}
			if(!btnFiltro3.isEmpty()){
				e.isNotNull("total_pagado");
				p.parcheCountAllFormula = true;
			}
			if(!btnFiltro4.isEmpty()){
				 e = e.eq("estado_id", Estado.FACTURA_ESTADO_CANCELADO);
			}
			if(!btnFiltro7.isEmpty()){
				 e = e.eq("estado_id", Estado.FACTURA_ESTADO_PREAPROBADO);
			}

			if(!btnFiltro8.isEmpty()){
				 e = e.eq("rechazado", true);
			}

			e = e.endJunction();
		}

		if(!btnFiltro5.isEmpty() || !btnFiltro6.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro5.isEmpty()){
				 e = e.eq("debe_dgr", true);
			}
			if(!btnFiltro6.isEmpty()){
				 e = e.eq("debe_afip", true);
			}
		}

		if(!Permiso.check("verExpedientesGuardiasMonotributo")){
			e.not(Expr.in("expediente_id", Expediente.EXP_GUARDIA_MONOTRIBUTOS));
		}

    	if(p.parcheCountAllFormula)
    		p.setTotalRowCount(e.findList().size());

    	p.setExpressionList(e);
    	return p;
    }

	public Long duplicar(Long id){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {

			conn = play.db.DB.getConnection();

			stmt = conn.prepareStatement("SELECT duplicar_factura(?)");
			stmt.setInt(1, id.intValue());

			rs = stmt.executeQuery();

			if (rs.next()) {
				ret = (long) rs.getInt(1);
			}

		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }

		return ret;
	}

	public Long crear_factura_parcial(Long id){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {

			conn = play.db.DB.getConnection();

			stmt = conn.prepareStatement("SELECT crear_factura_parcial(?)");
			stmt.setInt(1, id.intValue());

			rs = stmt.executeQuery();

			if (rs.next()) {
				ret = (long) rs.getInt(1);
			}

		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }

		return ret;
	}

	public static List<Factura> facturasDelMismoMes(Factura f){
		List<Factura> r = new ArrayList<Factura>();

		if(f.fecha_orden_pago != null){

			Periodo px = Periodo.getPeriodoByDate(f.fecha_orden_pago);

			Logger.debug("facturasDelMismoMesfacturasDelMismoMesfacturasDelMismoMes");
			Long c  = new Long(f.proveedor.cuit);
			ExpressionList<Factura> e = Factura.find
					.fetch("proveedor","cuit")
	    			.where()
					//.eq("proveedor_id", f.proveedor_id).ne("id", f.id);
					.eq("proveedor.cuit", c)
					.ne("id", f.id)
			 		.ge("fecha_orden_pago", px.date_start)
			 		.le("fecha_orden_pago", px.date_stop);


			//e = e.eq("Extract(month from fecha_orden_pago)", new Integer(DateUtils.formatDate(f.fecha_orden_pago,"M")));
			//e = e.eq("Extract(YEAR from fecha_orden_pago)", new Integer(DateUtils.formatDate(f.fecha_orden_pago,"yyyy")));
			e = e.disjunction();
			e = e.eq("state_id", Estado.FACTURA_ESTADO_ENCURSO);
			e = e.eq("state_id", Estado.FACTURA_ESTADO_PREAPROBADO);
			e = e.eq("state_id", Estado.FACTURA_ESTADO_APROBADO);
			e = e.endJunction();
			r = e.findList();
		}

		return r;
	}

	public static List<Factura> facturasConSellosMismaOrden(Factura f){

		List<Integer> expIds = new ArrayList<Integer>();
		expIds.add(f.expediente_id);

		if(f.expediente.parent_id != null){
			expIds.add(f.expediente.parent_id.intValue());
		}
		Logger.debug("------------------------");
		ExpressionList<Factura> e = Factura.find.select("id,expediente_id,proveedor_id,orden_id,estado_id")
				//.fetch("facturaLineaImpuesto","cuenta_id")
				//.fetch("create_usuario")
    			//.fetch("proveedor")
    			//.fetch("expediente")
    			//.fetch("expediente.ejercicio")
    			//.fetch("periodo")
    			//.fetch("ordenPago")
				.where()
				.in("facturaLineaImpuesto.cuenta_id", Cuenta.RET_DGR_SELLOS)
				.in("expediente_id", expIds)
				.eq("proveedor_id", f.proveedor_id)
				.eq("orden_id", f.orden_id)
				.ne("id", f.id);

		e = e.disjunction();
		e = e.eq("estado_id", Estado.FACTURA_ESTADO_ENCURSO);
		e = e.eq("estado_id", Estado.FACTURA_ESTADO_PREAPROBADO);
		e = e.eq("estado_id", Estado.FACTURA_ESTADO_APROBADO);
		e = e.endJunction();

		return e.findList();
	}

	public Pago getPagoPrincipal(){
		ExpressionList<Pago> e = Pago.find.where()

				.eq("factura_id", id)
				.eq("tipo","payment");

		/*e = e.disjunction();
		e = e.eq("state_id", Estado.PAGO_ESTADO_EN_CURSO);
		e = e.eq("state_id", Estado.PAGO_ESTADO_CONTABILIZADO);
		e = e.endJunction();*/

		return e.orderBy("fecha_pago desc").setMaxRows(1).findUnique();
	}


	public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> facturasSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE facturas " +
				"SET state_id = :idEstado,rechazado = false, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idEstado", idEstado);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", facturasSeleccionados);

		return update.execute();
	}

	public static Integer modificarEstadoAndFechaAprobacionMasivo(Integer idEstado,Date fFactura, List<Integer> facturasSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE facturas " +
				"SET state_id = :idEstado ,fecha_aprobacion = :fFactura,rechazado = false,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idEstado", idEstado);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("fFactura", fFactura);
		update.setParameter("ids", facturasSeleccionados);

		return update.execute();
	}

	public static Integer CargarOrdenPagoMasivo(Integer idOrdenPago, List<Integer> facturasSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE facturas " +
				"SET orden_pago_id = :idOrdenPago,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idOrdenPago", idOrdenPago);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", facturasSeleccionados);

		return update.execute();
	}

	public static Integer CargarMarcadoresMasivo(List<Integer> facturasSeleccionados,String debe_dgr,String debe_dgr_aguinaldo, String debe_afip, String debe_judicial){

		List<String> sqllist = new ArrayList<String>();

		if(!debe_dgr.isEmpty()){
			String a = (debe_dgr.compareToIgnoreCase("SI") == 0)?"true":"false";
			sqllist.add(" debe_dgr = "+a);
		}
		if(!debe_dgr_aguinaldo.isEmpty()){
			String a = (debe_dgr_aguinaldo.compareToIgnoreCase("SI") == 0)?"true":"false";
			sqllist.add(" debe_dgr_aguinaldo = "+a);
		}
		if(!debe_afip.isEmpty()){
			String a = (debe_afip.compareToIgnoreCase("SI") == 0)?"true":"false";
			sqllist.add(" debe_afip = "+a);
		}
		if(!debe_judicial.isEmpty()){
			String a = (debe_judicial.compareToIgnoreCase("SI") == 0)?"true":"false";
			sqllist.add(" debe_judicial = "+a);
		}

		String parametros = StringUtils.implode(sqllist, ",");

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE facturas " +
				"SET   "+parametros+
				" WHERE id IN (:ids)");

		update.setParameter("ids", facturasSeleccionados);

		return update.execute();
	}

	public static Integer CargarFechaOrdenPagoMasivo(Date fechaOrdenPago, List<Integer> facturasSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE facturas " +
				"SET fecha_orden_pago = :fechaOrdenPago,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("fechaOrdenPago", fechaOrdenPago);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", facturasSeleccionados);

		return update.execute();
	}

	public static Integer CargarNumeroFacturaParciales(String numero, List<Integer> facturasSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE facturas " +
				"SET numero_factura = :numero_factura,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("numero_factura",numero);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", facturasSeleccionados);

		return update.execute();
	}

	public static Integer CargarFecha322Masivo(Date fecha322, List<Integer> facturasSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE facturas " +
				"SET fecha_vencimiento_322 = :fecha322,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("fecha322", fecha322);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", facturasSeleccionados);

		return update.execute();
	}

	public static BigDecimal getTotalPorServicios(Long idFactura){

		BigDecimal r = new BigDecimal(0);

		String sql = "SELECT factura_id, sum(precio * cantidad) as base " +
				"FROM factura_lineas fl " +
				"WHERE cuenta_analitica_id NOT IN (:ids) AND factura_id = :f_id " +
				"GROUP BY factura_id  ";

		SqlRow s = Ebean.createSqlQuery(sql)
				   .setParameter("ids", CuentaAnalitica.getCuentasAnaliticasBienes())
				   .setParameter("f_id", idFactura)
				   .findUnique();

		if(s != null){
			r = s.getBigDecimal("base");
		}

		return r;
	}

	public static BigDecimal getTotalMontoFacturasCargadas(Long idFactura){
		return getTotalMontoFacturasCargadas(idFactura,null);
	}

	public static BigDecimal getTotalMontoFacturasCargadas(Long idFactura,Long ordenId){

		BigDecimal r = new BigDecimal(0);

		String sql = "SELECT sum(fd.monto) as monto " +
				"FROM factura_datos fd ";

		if(idFactura != null) {
			sql += "WHERE fd.orden_id =(select orden_id from facturas where id =:f_id) ";
			sql += "GROUP BY orden_id";

			SqlRow s = Ebean.createSqlQuery(sql)
					   .setParameter("f_id", idFactura)
					   .findUnique();

			if(s != null){
				r = s.getBigDecimal("monto");
			}
		}else {

			sql += "WHERE fd.orden_id = :ordenId ";
			sql += "GROUP BY orden_id";

			SqlRow s = Ebean.createSqlQuery(sql)
					   .setParameter("ordenId", ordenId)
					   .findUnique();

			if(s != null){
				r = s.getBigDecimal("monto");
			}
		}

		return r;
	}

	public static boolean existeNumeroFacturaCargado(Long idFactura,String nfactura){

		boolean r = false;

		String sql = "SELECT * "+
				"FROM factura_datos fd "+
				"WHERE fd.orden_id =(select orden_id from facturas where id =:f_id) "+
				"and upper(REPLACE(numero_factura,'-','')) =  upper(REPLACE(:nfactura,'-',''))";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
				   .setParameter("f_id", idFactura)
				   .setParameter("nfactura", nfactura)
				   .findList();

		if(s.size() > 0){
			r = true;
		}

		return r;
	}


	public static boolean existeNumeroFacturaCargadoDesdeOrden(Long idOrden,String nfactura){

		boolean r = false;

		String sql = "SELECT * "+
				"FROM factura_datos fd "+
				"WHERE fd.orden_id =:f_id "+
				"and upper(REPLACE(numero_factura,'-','')) =  upper(REPLACE(:nfactura,'-',''))";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
				   .setParameter("f_id", idOrden)
				   .setParameter("nfactura", nfactura)
				   .findList();

		if(s.size() > 0){
			r = true;
		}

		return r;
	}


	public static List<SqlRow> getFacturasDatosCargadas(Long idFactura){
		return getFacturasDatosCargadas(idFactura,null);
	}

	public static List<SqlRow> getFacturasDatosCargadas(Long idFactura,Long ordenId){

		String sql = "SELECT fd.id as id,'FAC'||fd.factura_id as nombre,fd.numero_factura,fd.monto as monto,"+
				"fd.fecha as fecha,fd.tipo_comprobante_id as tipo_comprobante_id " +
				"FROM factura_datos fd ";

		if(idFactura != null) {
			sql += "WHERE fd.orden_id =(select orden_id from facturas where id =:f_id) ";
			List<SqlRow> s = Ebean.createSqlQuery(sql)
					   .setParameter("f_id", idFactura)
					   .findList();

			return s;
		}else {
			sql += "WHERE fd.orden_id =:ordenId ";
			List<SqlRow> s = Ebean.createSqlQuery(sql)
					   .setParameter("ordenId", ordenId)
					   .findList();

			return s;
		}

	}


	public static BigDecimal getTotalPorBienes(Long idFactura){

		BigDecimal r = new BigDecimal(0);

		String sql = "SELECT factura_id, sum(precio * cantidad) as base " +
				"FROM factura_lineas fl " +
				"WHERE cuenta_analitica_id IN (:ids) AND factura_id = :f_id " +
				"GROUP BY factura_id ";

		SqlRow s = Ebean.createSqlQuery(sql)
				   .setParameter("ids", CuentaAnalitica.getCuentasAnaliticasBienes())
				   .setParameter("f_id", idFactura)
				   .findUnique();

		if(s != null){
			r = s.getBigDecimal("base");
		}
		//Logger.debug("getTotalPorBienes------------------ "+r);
		return r;
	}

	public static BigDecimal getTotalPorOp(Long idOp){

		BigDecimal r = new BigDecimal(0);

		String sql = "SELECT   sum(precio * cantidad) as base, orden_pago_id " +
				"FROM factura_lineas fl "+
				"INNER JOIN facturas f on f.id = fl.factura_id " +
				"WHERE orden_pago_id = :f_id " +
				"GROUP BY  orden_pago_id ";

		SqlRow s = Ebean.createSqlQuery(sql)
				   .setParameter("f_id", idOp)
				   .findUnique();

		if(s != null){
			r = s.getBigDecimal("base");
		}
		//Logger.debug("getTotalPorBienes------------------ "+r);
		return r;
	}

	public static List<SqlRow> getDataEstadoDeudaPagadosPorEjercicio(Integer idEjercicio){

		String sql = "SELECT a.id,a.apellido apellido,f.expediente_id,x.nombre expediente," +
				"sum(fl.precio*cantidad)-(CASE WHEN sum(fi.monto)=0 THEN 0 WHEN sum(fi.monto) is null THEN 0 ELSE sum(fi.monto) END) - (CASE WHEN sum(ri.monto)=0 THEN 0 WHEN sum(ri.monto) is null THEN 0 ELSE sum(ri.monto) END) total " +
				"FROM facturas f " +
				"INNER JOIN factura_lineas fl ON fl.factura_id = f.id " +
				"INNER JOIN pagos p ON p.factura_id = f.id " +
				"INNER JOIN periodos e ON e.id = f.periodo_id " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"INNER JOIN expedientes x ON x.id = f.expediente_id " +
				"LEFT JOIN factura_linea_impuestos fi ON f.id = fi.factura_id " +
				"LEFT JOIN factura_linea_reintegros ri ON f.id = ri.factura_id " +
				"WHERE (p.state_id = :conciliado OR p.state_id = :pagado OR p.state_id = :en_curso) " +
				"AND p.proveedor_id = f.proveedor_id " +
				"AND e.ejercicio_id = :idEjercicio " +
				"GROUP BY a.id,f.expediente_id,x.nombre " +
				"ORDER BY a.apellido ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("conciliado", Estado.PAGO_ESTADO_CONCILIADO)
				.setParameter("pagado", Estado.PAGO_ESTADO_PAGADO)
				.setParameter("en_curso",Estado.PAGO_ESTADO_EN_CURSO)
				.setParameter("idEjercicio", idEjercicio)
				.findList();

		return s;
	}

	public static List<SqlRow> getDataEstadoDeudaNoPagadosPorEjercicio(Integer idEjercicio){

		String sql = "SELECT a.id,a.apellido apellido,f.expediente_id,x.nombre expediente," +
				"sum(fl.precio*cantidad)-(CASE WHEN sum(fi.monto)=0 THEN 0 WHEN sum(fi.monto) is null THEN 0 ELSE sum(fi.monto) END)-(CASE WHEN sum(ri.monto)=0 THEN 0 WHEN sum(ri.monto) is null THEN 0 ELSE sum(ri.monto) END) total " +
				"FROM facturas f  " +
				"INNER JOIN factura_lineas fl ON fl.factura_id = f.id  " +
				"INNER JOIN periodos e ON e.id = f.periodo_id  " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"INNER JOIN expedientes x ON x.id = f.expediente_id " +
				"LEFT JOIN pagos p ON p.factura_id = f.id " +
				"LEFT JOIN factura_linea_impuestos fi ON f.id = fi.factura_id " +
				"LEFT JOIN factura_linea_reintegros ri ON f.id = ri.factura_id " +
				"WHERE  (f.state_id = :enCurso " +
				"		 OR f.state_id = :facturaBorrador " +
				"  		 OR f.state_id = :facturaPreaprobada " +
				"		 OR (f.state_id =:aprobada AND p.proveedor_id is not null AND (p.state_id = :pagoBorrador OR p.state_id = :pagoCancelado))) " +
				"AND f.state_id <> :facturaCancelado  " +
				"AND e.ejercicio_id = :idEjercicio " +
				"AND (p.proveedor_id = f.proveedor_id OR p.proveedor_id is null) " +
				"GROUP BY a.id,f.expediente_id,x.nombre " +
				"ORDER BY a.apellido ";

				List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("enCurso",Estado.FACTURA_ESTADO_ENCURSO)
				.setParameter("facturaBorrador",Estado.FACTURA_ESTADO_BORRADOR)
				.setParameter("facturaPreaprobada",Estado.FACTURA_ESTADO_PREAPROBADO)
				.setParameter("aprobada", Estado.FACTURA_ESTADO_APROBADO)
				.setParameter("pagoBorrador", Estado.PAGO_ESTADO_BORRADOR)
				.setParameter("pagoCancelado",Estado.PAGO_ESTADO_CANCELADO)
				.setParameter("facturaCancelado",Estado.FACTURA_ESTADO_CANCELADO)
				.setParameter("idEjercicio", idEjercicio)
				.findList();

		return s;
	}


	public static BigDecimal getTotalFacturasPagadasHonorariosPorEjercicio(Integer idEjercicio){
		BigDecimal ret =  new BigDecimal(0);

		String sql = "SELECT sum(fl.precio*cantidad) total " +
				"FROM facturas f " +
				"INNER JOIN factura_lineas fl ON fl.factura_id = f.id " +
				"INNER JOIN pagos p ON p.factura_id = f.id " +
				"INNER JOIN periodos e ON e.id = f.periodo_id " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"WHERE (p.state_id = :conciliado OR p.state_id = :en_curso OR p.state_id = :pagado) " +
				"AND p.proveedor_id = f.proveedor_id " +
				"AND e.ejercicio_id = :idEjercicio ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
		.setParameter("conciliado", Estado.PAGO_ESTADO_CONCILIADO)
		.setParameter("pagado", Estado.PAGO_ESTADO_PAGADO)
		.setParameter("en_curso",Estado.PAGO_ESTADO_EN_CURSO)
		.setParameter("idEjercicio", idEjercicio)
		.findList();

		if(s.size() > 0){
			ret = (s.get(0).getBigDecimal("total") != null)?s.get(0).getBigDecimal("total"):new BigDecimal(0);
		}

		return ret;
	}

	public static BigDecimal getTotalImpuestosFacturasPagadasHonorariosPorEjercicio(Integer idEjercicio){
		BigDecimal ret =  new BigDecimal(0);

		String sql = "SELECT sum(fl.monto) total " +
				"FROM facturas f " +
				"INNER JOIN factura_linea_impuestos fl ON fl.factura_id = f.id  " +
				"INNER JOIN pagos p ON p.factura_id = f.id " +
				"INNER JOIN periodos e ON e.id = f.periodo_id " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"WHERE (p.state_id = :conciliado OR p.state_id = :en_curso OR p.state_id = :pagado) " +
				"AND p.proveedor_id = f.proveedor_id " +
				"AND e.ejercicio_id = :idEjercicio ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
		.setParameter("conciliado", Estado.PAGO_ESTADO_CONCILIADO)
		.setParameter("pagado", Estado.PAGO_ESTADO_PAGADO)
		.setParameter("en_curso",Estado.PAGO_ESTADO_EN_CURSO)
		.setParameter("idEjercicio", idEjercicio)
		.findList();

		if(s.size() > 0){
			ret = (s.get(0).getBigDecimal("total") != null)?s.get(0).getBigDecimal("total"):new BigDecimal(0);
		}

		return ret;
	}

	public static BigDecimal getTotalFacturasNoPagadasHonorariosPorEjercicio(Integer idEjercicio){

		BigDecimal ret =  new BigDecimal(0);
		String sql = "SELECT sum(fl.precio*fl.cantidad) total " +
				"FROM facturas f  " +
				"INNER JOIN factura_lineas fl ON fl.factura_id = f.id  " +
				"INNER JOIN periodos e ON e.id = f.periodo_id  " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"LEFT JOIN pagos p ON p.factura_id = f.id " +
				"WHERE  (f.state_id = :enCurso " +
				"		 OR f.state_id = :facturaBorrador " +
				"  		 OR f.state_id = :facturaPreaprobada " +
				"		 OR (f.state_id =:aprobada AND p.proveedor_id is not null AND (p.state_id = :pagoBorrador OR p.state_id = :pagoCancelado))) " +
				"AND f.state_id <> :facturaCancelado  " +
				"AND e.ejercicio_id = :idEjercicio " +
				"AND (p.proveedor_id = f.proveedor_id OR p.proveedor_id is null) ";

				List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("enCurso",Estado.FACTURA_ESTADO_ENCURSO)
				.setParameter("facturaBorrador",Estado.FACTURA_ESTADO_BORRADOR)
				.setParameter("facturaPreaprobada",Estado.FACTURA_ESTADO_PREAPROBADO)
				.setParameter("aprobada", Estado.FACTURA_ESTADO_APROBADO)
				.setParameter("pagoBorrador", Estado.PAGO_ESTADO_BORRADOR)
				.setParameter("pagoCancelado",Estado.PAGO_ESTADO_CANCELADO)
				.setParameter("facturaCancelado",Estado.FACTURA_ESTADO_CANCELADO)
				.setParameter("idEjercicio", idEjercicio)
				.findList();
		if(s.size() > 0){
			ret = (s.get(0).getBigDecimal("total") != null)?s.get(0).getBigDecimal("total"):new BigDecimal(0);
		}

		return ret;
	}

	public static BigDecimal getTotalImpuestosFacturasNoPagadasHonorariosPorEjercicio(Integer idEjercicio){

		BigDecimal ret =  new BigDecimal(0);
		String sql = "SELECT sum(fl.monto) total " +
				"FROM facturas f  " +
				"INNER JOIN factura_linea_impuestos fl ON fl.factura_id = f.id  " +
				"INNER JOIN periodos e ON e.id = f.periodo_id  " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"LEFT JOIN pagos p ON p.factura_id = f.id " +
				"WHERE  (f.state_id = :enCurso " +
				"		 OR f.state_id = :facturaBorrador " +
				"  		 OR f.state_id = :facturaPreaprobada " +
				"		 OR (f.state_id =:aprobada AND p.proveedor_id is not null AND (p.state_id = :pagoBorrador OR p.state_id = :pagoCancelado))) " +
				"AND f.state_id <> :facturaCancelado  " +
				"AND e.ejercicio_id = :idEjercicio " +
				"AND (p.proveedor_id = f.proveedor_id OR p.proveedor_id is null) ";

				List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("enCurso",Estado.FACTURA_ESTADO_ENCURSO)
				.setParameter("facturaBorrador",Estado.FACTURA_ESTADO_BORRADOR)
				.setParameter("facturaPreaprobada",Estado.FACTURA_ESTADO_PREAPROBADO)
				.setParameter("aprobada", Estado.FACTURA_ESTADO_APROBADO)
				.setParameter("pagoBorrador", Estado.PAGO_ESTADO_BORRADOR)
				.setParameter("pagoCancelado",Estado.PAGO_ESTADO_CANCELADO)
				.setParameter("facturaCancelado",Estado.FACTURA_ESTADO_CANCELADO)
				.setParameter("idEjercicio", idEjercicio)
				.findList();

		if(s.size() > 0){
			ret = (s.get(0).getBigDecimal("total") != null)?s.get(0).getBigDecimal("total"):new BigDecimal(0);
		}

		return ret;
	}

	public static Map<String,BigDecimal> getTotalFacturasPagadasHonorariosPorPeriodo(Integer idEjercicio){
		BigDecimal ret =  new BigDecimal(0);
		Map<String,BigDecimal> aret =  new HashMap<String,BigDecimal>();
		String sql = "SELECT e.id id,e.nombre nombre,sum(fl.precio*cantidad) total " +
				"FROM facturas f " +
				"INNER JOIN factura_lineas fl ON fl.factura_id = f.id " +
				"INNER JOIN pagos p ON p.factura_id = f.id " +
				"INNER JOIN periodos e ON e.id = f.periodo_id " +
				"INNER JOIN proveedores pr ON pr.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = pr.agente_id " +
				"WHERE (p.state_id = :conciliado OR p.state_id = :en_curso OR p.state_id = :pagado) " +
				"AND p.proveedor_id = f.proveedor_id " +
				"AND e.ejercicio_id = :idEjercicio " +
				"group by e.id,e.nombre ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
		.setParameter("conciliado", Estado.PAGO_ESTADO_CONCILIADO)
		.setParameter("pagado", Estado.PAGO_ESTADO_PAGADO)
		.setParameter("en_curso",Estado.PAGO_ESTADO_EN_CURSO)
		.setParameter("idEjercicio", idEjercicio)
		.findList();

		if(s.size() > 0){
			for(SqlRow q : s){
				aret.put(q.getString("nombre"),q.getBigDecimal("total"));
			}
		}

		return aret;
	}

	public static Map<String,BigDecimal> getTotalImpuestosFacturasPagadasHonorariosPorPeriodo(Integer idEjercicio){
		BigDecimal ret =  new BigDecimal(0);
		Map<String,BigDecimal> aret =  new HashMap<String,BigDecimal>();
		String sql = "SELECT e.id id,e.nombre nombre,sum(fl.monto) total " +
				"FROM facturas f " +
				"INNER JOIN factura_linea_impuestos fl ON fl.factura_id = f.id  " +
				"INNER JOIN pagos p ON p.factura_id = f.id " +
				"INNER JOIN periodos e ON e.id = f.periodo_id " +
				"INNER JOIN proveedores pr ON pr.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = pr.agente_id " +
				"WHERE (p.state_id = :conciliado OR p.state_id = :en_curso OR p.state_id = :pagado) " +
				"AND p.proveedor_id = f.proveedor_id " +
				"AND e.ejercicio_id = :idEjercicio " +
				"group by e.id,e.nombre ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
		.setParameter("conciliado", Estado.PAGO_ESTADO_CONCILIADO)
		.setParameter("pagado", Estado.PAGO_ESTADO_PAGADO)
		.setParameter("en_curso",Estado.PAGO_ESTADO_EN_CURSO)
		.setParameter("idEjercicio", idEjercicio)
		.findList();

		if(s.size() > 0){
			for(SqlRow q : s){
				aret.put(q.getString("nombre"),q.getBigDecimal("total"));
			}
		}

		return aret;
	}

	public static Map<String,BigDecimal> getTotalFacturasNoPagadasHonorariosPorPeriodo(Integer idEjercicio){

		BigDecimal ret =  new BigDecimal(0);
		Map<String,BigDecimal> aret =  new HashMap<String,BigDecimal>();
		String sql = "SELECT e.id id,e.nombre nombre,sum(fl.precio*cantidad) total " +
				"FROM facturas f  " +
				"INNER JOIN factura_lineas fl ON fl.factura_id = f.id  " +
				"INNER JOIN periodos e ON e.id = f.periodo_id  " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"LEFT JOIN pagos p ON p.factura_id = f.id " +
				"WHERE  (f.state_id = :enCurso " +
				"		 OR f.state_id = :facturaBorrador " +
				"  		 OR f.state_id = :facturaPreaprobada " +
				"		 OR (f.state_id =:aprobada AND p.proveedor_id is not null AND (p.state_id = :pagoBorrador OR p.state_id = :pagoCancelado))) " +
				"AND f.state_id <> :facturaCancelado  " +
				"AND e.ejercicio_id = :idEjercicio " +
				"AND (p.proveedor_id = f.proveedor_id OR p.proveedor_id is null) " +
				"group by e.id,e.nombre ";

				List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("enCurso",Estado.FACTURA_ESTADO_ENCURSO)
				.setParameter("facturaBorrador",Estado.FACTURA_ESTADO_BORRADOR)
				.setParameter("facturaPreaprobada",Estado.FACTURA_ESTADO_PREAPROBADO)
				.setParameter("aprobada", Estado.FACTURA_ESTADO_APROBADO)
				.setParameter("pagoBorrador", Estado.PAGO_ESTADO_BORRADOR)
				.setParameter("pagoCancelado",Estado.PAGO_ESTADO_CANCELADO)
				.setParameter("facturaCancelado",Estado.FACTURA_ESTADO_CANCELADO)
				.setParameter("idEjercicio", idEjercicio)
				.findList();
		if(s.size() > 0){
			for(SqlRow q : s){
				aret.put(q.getString("nombre"),q.getBigDecimal("total"));
			}
		}

		return aret;
	}

	public static Map<String,BigDecimal> getTotalImpuestosFacturasNoPagadasHonorariosPorPeriodo(Integer idEjercicio){

		BigDecimal ret =  new BigDecimal(0);
		Map<String,BigDecimal> aret =  new HashMap<String,BigDecimal>();
		String sql = "SELECT e.id id,e.nombre nombre,sum(fl.monto) total " +
				"FROM facturas f  " +
				"INNER JOIN factura_linea_impuestos fl ON fl.factura_id = f.id  " +
				"INNER JOIN periodos e ON e.id = f.periodo_id  " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"LEFT JOIN pagos p ON p.factura_id = f.id " +
				"WHERE  (f.state_id = :enCurso " +
				"		 OR f.state_id = :facturaBorrador " +
				"  		 OR f.state_id = :facturaPreaprobada " +
				"		 OR (f.state_id =:aprobada AND p.proveedor_id is not null AND (p.state_id = :pagoBorrador OR p.state_id = :pagoCancelado))) " +
				"AND f.state_id <> :facturaCancelado  " +
				"AND e.ejercicio_id = :idEjercicio " +
				"AND (p.proveedor_id = f.proveedor_id OR p.proveedor_id is null) " +
				"group by e.id,e.nombre ";

				List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("enCurso",Estado.FACTURA_ESTADO_ENCURSO)
				.setParameter("facturaBorrador",Estado.FACTURA_ESTADO_BORRADOR)
				.setParameter("facturaPreaprobada",Estado.FACTURA_ESTADO_PREAPROBADO)
				.setParameter("aprobada", Estado.FACTURA_ESTADO_APROBADO)
				.setParameter("pagoBorrador", Estado.PAGO_ESTADO_BORRADOR)
				.setParameter("pagoCancelado",Estado.PAGO_ESTADO_CANCELADO)
				.setParameter("facturaCancelado",Estado.FACTURA_ESTADO_CANCELADO)
				.setParameter("idEjercicio", idEjercicio)
				.findList();

		if(s.size() > 0){
			for(SqlRow q : s){
				aret.put(q.getString("nombre"),q.getBigDecimal("total"));
			}
		}

		return aret;
	}

	public static List<SqlRow> getDataEstadoDeudaPagadosPorPeriodo(Integer idEjercicio,String nombrePeriodo){
		String sql = "SELECT a.id,a.apellido,f.expediente_id,x.nombre expediente,e.id id,e.nombre nombre," +
				"sum(fl.precio*cantidad)-(CASE WHEN sum(fi.monto)=0 THEN 0 WHEN sum(fi.monto) is null THEN 0 ELSE sum(fi.monto) END) total " +
				"FROM facturas f " +
				"INNER JOIN factura_lineas fl ON fl.factura_id = f.id " +
				"INNER JOIN pagos p ON p.factura_id = f.id " +
				"INNER JOIN periodos e ON e.id = f.periodo_id " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id  " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"INNER JOIN expedientes x ON x.id = f.expediente_id " +
				"LEFT JOIN factura_linea_impuestos fi ON f.id = fi.factura_id " +
				"WHERE (p.state_id = :conciliado OR p.state_id = :en_curso OR p.state_id = :pagado) " +
				"AND p.proveedor_id = f.proveedor_id " +
				"AND e.ejercicio_id = :idEjercicio " +
				"AND e.nombre = :nombrePeriodo " +
				"group by a.id,f.expediente_id,x.nombre,e.id,e.nombre " +
				"ORDER BY a.apellido ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
		.setParameter("conciliado", Estado.PAGO_ESTADO_CONCILIADO)
		.setParameter("pagado",Estado.PAGO_ESTADO_PAGADO)
		.setParameter("en_curso",Estado.PAGO_ESTADO_EN_CURSO)
		.setParameter("idEjercicio", idEjercicio)
		.setParameter("nombrePeriodo", nombrePeriodo)
		.findList();

		return s;
	}

	public static List<SqlRow> getDataEstadoDeudaNoPagadosPorPeriodo(Integer idEjercicio,String nombrePeriodo){

		String sql = "SELECT a.id,a.apellido,f.expediente_id,x.nombre expediente,e.id id,e.nombre nombre," +
				"sum(fl.precio*cantidad)-(CASE WHEN sum(fi.monto)=0 THEN 0 WHEN sum(fi.monto) is null THEN 0 ELSE sum(fi.monto) END)-(CASE WHEN sum(ri.monto)=0 THEN 0 WHEN sum(ri.monto) is null THEN 0 ELSE sum(ri.monto) END) total " +
				"FROM facturas f  " +
				"INNER JOIN factura_lineas fl ON fl.factura_id = f.id  " +
				"INNER JOIN periodos e ON e.id = f.periodo_id  " +
				"INNER JOIN proveedores r ON r.id = f.proveedor_id " +
				"INNER JOIN agentes a ON a.id = r.agente_id " +
				"INNER JOIN expedientes x ON x.id = f.expediente_id " +
				"LEFT JOIN pagos p ON p.factura_id = f.id " +
				"LEFT JOIN factura_linea_impuestos fi ON f.id = fi.factura_id " +
				"LEFT JOIN factura_linea_reintegros ri ON f.id = ri.factura_id " +
				"WHERE  (f.state_id = :enCurso " +
				"		 OR f.state_id = :facturaBorrador " +
				"  		 OR f.state_id = :facturaPreaprobada " +
				"		 OR (f.state_id =:aprobada AND p.proveedor_id is not null AND (p.state_id = :pagoBorrador OR p.state_id = :pagoCancelado))) " +
				"AND f.state_id <> :facturaCancelado  " +
				"AND e.ejercicio_id = :idEjercicio " +
				"AND (p.proveedor_id = f.proveedor_id OR p.proveedor_id is null) " +
				"AND e.nombre = :nombrePeriodo " +
				"group by a.id,f.expediente_id,x.nombre,e.id,e.nombre " +
				"ORDER BY a.apellido ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
		.setParameter("enCurso",Estado.FACTURA_ESTADO_ENCURSO)
		.setParameter("facturaBorrador",Estado.FACTURA_ESTADO_BORRADOR)
		.setParameter("facturaPreaprobada",Estado.FACTURA_ESTADO_PREAPROBADO)
		.setParameter("aprobada", Estado.FACTURA_ESTADO_APROBADO)
		.setParameter("pagoBorrador", Estado.PAGO_ESTADO_BORRADOR)
		.setParameter("pagoCancelado",Estado.PAGO_ESTADO_CANCELADO)
		.setParameter("facturaCancelado",Estado.FACTURA_ESTADO_CANCELADO)
		.setParameter("idEjercicio", idEjercicio)
		.setParameter("nombrePeriodo", nombrePeriodo)
		.findList();

		return s;
	}

	public static Boolean soloCuentasAnliticasHijas(List<Integer> idsFacturas) {
		boolean r = true;

		String sql = "SELECT * " +
				"FROM factura_lineas " +
				"WHERE factura_id in(:idsFacturas) " +
				"AND cuenta_analitica_id IN (SELECT parent_id FROM cuentas_analiticas WHERE parent_id is not null)  ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("idsFacturas",idsFacturas)
				.findList();

		if(s.size() > 0){
			r = false;
		}

		return r;
	}

	public static List<SqlRow> getTotalPorProveedorEstadoPeriodo(Long proveedorId) {

		String sql = "SELECT f.periodo_id,p.nombre periodoNombre,state_id estadoId,e.nombre estadoNombre, " +
		 "SUM((fl.cantidad*fl.precio) - NULLIF(0, fli.monto)- NULLIF(0, rli.monto)) total " +
		 "FROM facturas f " +
		 "INNER JOIN periodos p ON p.id = f.periodo_id " +
		 "INNER JOIN factura_lineas fl ON f.id = fl.factura_id " +
		 "LEFT JOIN factura_linea_impuestos fli ON f.id = fli.factura_id " +
		 "LEFT JOIN factura_linea_reintegros rli ON f.id = rli.factura_id " +
		 "INNER JOIN estados e ON e.id = f.state_id	" +
		 "WHERE f.proveedor_id = :proveedorId " +
		 "GROUP BY f.periodo_id,p.nombre,f.state_id,e.nombre ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("proveedorId",proveedorId)
				.findList();

		return s;
	}

	public static Factura crearFactruasDesdeOrdenCompra(Orden oc,Long idAutorizado,boolean parcial){
		boolean ret = false;
		boolean debe_judicial = false;
		Factura f = null;
		try{
			if(oc.proveedor_id.compareTo(new Long(726)) == 0 || oc.proveedor_id.compareTo(new Long(485)) == 0){
				debe_judicial = true;
			}

			f = new Factura();
			f.creacion_automatica = true;
			f.create_usuario_id = Usuario.getUsuarioSesion().longValue();
			f.create_date = new Date();
			f.proveedor_id = oc.proveedor_id.intValue();
			//f.periodo_id = oc.periodo_id.intValue();
			f.expediente_id = oc.expediente_id.intValue();
			f.profe = oc.profe;
			f.cuenta_id = 255;
			f.estado_id = new Long(Estado.FACTURA_ESTADO_BORRADOR);
			f.orden_id = oc.id.intValue();
			f.tipo = "in_invoice";
			f.debe_judicial= debe_judicial;
			f.agente_pago_externo = (oc.proveedor.agente_id != null)?true:false;
			f.autorizado_id = idAutorizado;
			f.parcial = parcial;
			f.tipo_cuenta_id = oc.tipo_cuenta_id;
			f.save();

			for(OrdenLinea ol :oc.ordenLinea){
				FacturaLinea olx = new FacturaLinea();
				olx.cuenta_id = new Long(255);
				olx.create_usuario_id = Usuario.getUsuarioSesion().longValue();
				olx.create_date = new Date();
				olx.udm_id = ol.udm_id;
				olx.factura_id = f.id;
				olx.precio = ol.precio;
				olx.cuenta_analitica_id = ol.cuenta_analitica_id;
				olx.cantidad = ol.cantidad;
				olx.producto_id = ol.producto_id;
				olx.cuenta_analitica_original_id = ol.cuenta_analitica_id;
				olx.save();
			}

		}catch(Exception e){

		}


		return f;
	}

	public static Factura crearFacturasDesdeAutorizadosConActas(List<SqlRow> sa,OrdenProvision op,Long idAutorizado,Long facturaPrincipalId){
		boolean ret = false;
		boolean debe_judicial = false;
		Factura f = null;

		try{

			Orden oc = op.ordenCompra;

			if(oc.proveedor_id.compareTo(new Long(726)) == 0 || oc.proveedor_id.compareTo(new Long(485)) == 0){
				debe_judicial = true;
			}

			f = new Factura();
			f.creacion_automatica = true;
			f.create_usuario_id = Usuario.getUsuarioSesion().longValue();
			f.create_date = new Date();
			f.proveedor_id = oc.proveedor_id.intValue();
			//f.periodo_id = oc.periodo_id.intValue();
			f.expediente_id = oc.expediente_id.intValue();
			f.profe = oc.profe;
			f.cuenta_id = 255;
			f.estado_id = new Long(Estado.FACTURA_ESTADO_BORRADOR);
			f.orden_id = oc.id.intValue();
			f.tipo = "in_invoice";
			f.debe_judicial= debe_judicial;
			f.agente_pago_externo = (oc.proveedor.agente_id != null)?true:false;
			f.autorizado_id = idAutorizado;
			f.parcial = false;
			f.factura_principal_id = facturaPrincipalId;
			f.tipo_cuenta_id = oc.tipo_cuenta_id;
			f.save();

			for(SqlRow sxa:sa){
				ActaRecepcion ac = ActaRecepcion.find.byId(sxa.getLong("acta_recepcion_id"));

				if(ac.getSubTotal().setScale(2, RoundingMode.HALF_DOWN).compareTo(sxa.getBigDecimal("monto").setScale(2, RoundingMode.HALF_DOWN)) == 0){

					if(ac.certificaciones != null && ac.certificaciones.size() > 0){
						for(CertificacionServicio cs :ac.certificaciones){
							for(CertificacionServicioLinea csl : cs.certificacionesServicioLinea){

								FacturaLinea flc = FacturaLinea.find.where()
												  .eq("producto_id",  csl.producto_id)
												  .eq("precio",  csl.precio.setScale(2, RoundingMode.HALF_DOWN))
												  .eq("factura_id", f.id)
												  .findUnique();
								if(flc != null){
									flc.cantidad = flc.cantidad.add(csl.cantidad);
									flc.save();
								}else{
									FacturaLinea olx = new FacturaLinea();
									olx.cuenta_id = new Long(255);
									olx.create_usuario_id = Usuario.getUsuarioSesion().longValue();
									olx.create_date = new Date();
									olx.udm_id = csl.udm_id;
									olx.factura_id = f.id;
									olx.precio = csl.precio.setScale(2, RoundingMode.HALF_DOWN);
									olx.cuenta_analitica_id = csl.cuenta_analitica_id;
									olx.cantidad = csl.cantidad;
									olx.producto_id = csl.producto_id;
									olx.cuenta_analitica_original_id = csl.cuenta_analitica_id;
									olx.save();
								}
							}
						}
					}else if(ac.recepciones != null && ac.recepciones.size() > 0){
						for(Recepcion r :ac.recepciones){
							for(Remito re :r.remito){
								for(RemitoLinea rl :re.lineas){
									FacturaLinea flc = FacturaLinea.find.where()
									  .eq("producto_id",  rl.lineaOrden.producto_id)
									  .eq("precio",  rl.lineaOrden.precio.setScale(2, RoundingMode.HALF_DOWN))
									  .eq("factura_id", f.id).setMaxRows(1)
									  .findUnique();

									if(flc != null){
										flc.cantidad = flc.cantidad.add(rl.cantidad);
										flc.save();
									}else{
										FacturaLinea olx = new FacturaLinea();
										olx.cuenta_id = new Long(255);
										olx.create_usuario_id = Usuario.getUsuarioSesion().longValue();
										olx.create_date = new Date();
										olx.udm_id = rl.lineaOrden.udm_id;
										olx.factura_id = f.id;
										olx.precio = rl.lineaOrden.precio.setScale(2, RoundingMode.HALF_DOWN);
										olx.cuenta_analitica_id = rl.lineaOrden.cuenta_analitica_id;
										olx.cantidad = rl.cantidad;
										olx.producto_id = rl.lineaOrden.producto_id;
										olx.cuenta_analitica_original_id = rl.lineaOrden.cuenta_analitica_id;
										olx.save();
									}
								}
							}
						}
					}

				}else{
					FacturaLinea olx = new FacturaLinea();
					olx.cuenta_id = new Long(255);
					olx.create_usuario_id = Usuario.getUsuarioSesion().longValue();
					olx.create_date = new Date();
					olx.udm_id = new Long(1);
					olx.factura_id = f.id;
					olx.precio = sxa.getBigDecimal("monto").setScale(2, RoundingMode.HALF_DOWN);
					olx.cuenta_analitica_id = null;
					olx.cantidad = new BigDecimal(1);
					olx.producto_id = new Long(44719);
					olx.save();
				}


			}

		}catch(Exception e){

		}


		return f;
	}
}
