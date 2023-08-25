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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.annotation.Formula;

import models.auth.Permiso;


@Entity
@Table(name = "actas_recepcion")
public class ActaRecepcion extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="actas_recepcion_id_seq")
	public Long id;


	@ManyToOne
	@JoinColumn(name="ejercicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Ejercicio ejercicio;

	@Required(message="Ejercicio requerido")
	public Integer ejercicio_id;

	@Required(message="Número requerido")
	public String numero;

	public Boolean cierre = false;

	public Boolean auto_creacion = false;

	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	public Long periodo_id;


	@OneToMany
	@JoinColumn(name = "acta_id")
	public List<Recepcion>  recepciones;

	@OneToMany
	@JoinColumn(name = "acta_id")
	public List<CertificacionServicio>  certificaciones;

	@DecimalComa(value="")
	public BigDecimal cot_dolar;


	//@Formula(select = "(select  SUM(rl.cantidad * ol.precio) as total from recepciones rec inner join remitos rem on rec.id = rem.recepcion_id inner join remitos_lineas rl on rl.remito_id = rem.id inner join orden_lineas ol on ol.id = rl.linea_orden_id where rec.acta_id = ${ta}.id)")
	//@Formula(select = "(select SUM(u.total) from (select  SUM(rl.cantidad * ol.precio) as total from recepciones rec inner join remitos rem on rec.id = rem.recepcion_id inner join remitos_lineas rl on rl.remito_id = rem.id inner join orden_lineas ol on ol.id = rl.linea_orden_id  where acta_id =  ${ta}.id  group by acta_id UNION select  SUM(cs.precio - (cs.precio * cs.descuento / 100)) * cs.cantidad as total from certificaciones_servicios cs where acta_id =  ${ta}.id group by acta_id, cs.cantidad) u)")

	@Formula(select = "(select COALESCE(SUM(u.total), 0) from (select  round(SUM(rl.cantidad * ol.precio),2) as total from recepciones rec "
			+ "inner join remitos rem on rec.id = rem.recepcion_id "
			+ "inner join remitos_lineas rl on rl.remito_id = rem.id "
			+ "inner join orden_lineas ol on ol.id = rl.linea_orden_id  where acta_id =  ${ta}.id  group by acta_id "
			+ "UNION "
			+ "select SUM(round(csl.precio * csl.cantidad,2)) - round(SUM(CAST (csl.precio AS numeric) * COALESCE(csl.descuento, 0) / 100)) as total "
			+ "from certificaciones_servicios cs "
			+ "inner join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id  "
			+ "where acta_id =  ${ta}.id group by acta_id) u)")
	public BigDecimal total;

	@Formula(select = "ajustes", join = "left join (select aj.acta_id, COALESCE(sum(la.precio * cantidad),0) ajustes from actas_ajustes aj inner join orden_lineas_ajustes la on la.id = aj.ajuste_id group by aj.acta_id) as _ajuste${ta} on _ajuste${ta}.acta_id = ${ta}.id")
	public BigDecimal ajustes;

	@Formula(select = "totalLineasAjustes", join = "left join (select alj.acta_id, COALESCE(sum(alj.precio * alj.cantidad),0) totalLineasAjustes from actas_recepcion_lineas_ajustes alj group by alj.acta_id) as _totalLineasAjustes${ta} on _totalLineasAjustes${ta}.acta_id = ${ta}.id")
	public BigDecimal totalLineasAjustes;

	public BigDecimal getTotalLineasAjustes() {
		if(totalLineasAjustes == null)
			return new BigDecimal(0);
		return totalLineasAjustes.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTotalAjustes() {
		if(ajustes == null)
			return new BigDecimal(0);
		return ajustes.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTotalAjustesConLineasAjustes() {
		return getTotalAjustes().add(getTotalLineasAjustes()).setScale(2, RoundingMode.HALF_UP);
	}


	public BigDecimal getSubTotal() {
		if(total == null)
			return new BigDecimal(0);
		return total.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTotal() {
		return getSubTotal().add(getTotalAjustes()).add(getTotalLineasAjustes());
	}

	public BigDecimal getTotalDolar(){
		if (ordenProvision.ordenCompra.cot_dolar != null && ordenProvision.ordenCompra.cot_dolar.compareTo(BigDecimal.ZERO) > 0)
			//return getTotal().divide(ordenProvision.ordenCompra.cot_dolar, 2, RoundingMode.HALF_UP);
			//return getTotal().divide((cot_dolar != null)?cot_dolar:ordenProvision.ordenCompra.cot_dolar, 2, RoundingMode.HALF_UP);
			return getTotal().divide((cot_dolar != null)?cot_dolar:new BigDecimal(1), 2, RoundingMode.HALF_UP);
		return new BigDecimal(0);
	}

	@ManyToOne
	@JoinColumn(name="state_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="state_id")
	public Long estado_id;

	@ManyToOne
	@JoinColumn(name="orden_provision_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenProvision ordenProvision;
	public Integer orden_provision_id;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Integer create_usuario_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Número requerido")
	public Date fecha;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date create_date;

	public String observaciones;

	public String nota_interna;

	public Date write_date;

	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario;
	@Column(name="write_usuario_id")
	public Integer write_usuario_id;

	public String getNombre(){
		return numero+"/"+ejercicio.nombre;
	}

	@Formula(select = "_d${ta}.servicio", join = "LEFT OUTER JOIN (SELECT o.nombre as servicio,acta_id FROM actas_movimientos  em INNER JOIN organigramas o ON o.id = em.organigrama_id WHERE (em.id, acta_id) IN (SELECT MAX(em2.id),acta_id FROM actas_movimientos em2 WHERE em2.cancelado <> true GROUP BY acta_id)) as _d${ta} on _d${ta}.acta_id = ${ta}.id")
	public String servicio;

	@OneToMany
	@JoinColumn(name="acta_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<ActaMovimiento> movimientos;

	@OneToMany
	public List<ActaMovimiento> actaMovimientos;

	@OneToOne(fetch=FetchType.LAZY, mappedBy="acta")
	public ActaMovimiento movimiento;

	public static Finder<Long,ActaRecepcion> find = new Finder<Long,ActaRecepcion>(Long.class, ActaRecepcion.class);

	public static Pagination<ActaRecepcion> page(String id,
												 String numero,
												 String orden_provision,
												 String expediente_id,
												 String proveedor_id,
												 String orden_compra,
												 String fecha_desde,
												 String fecha_hasta,
												 String tipo,
												 String ejercicio,
												 String filtroBorrador,
												 String filtroEnCurso,
												 String filtroPreajuste,
												 String filtroAprobada,
												 String filtroCancelada,
												 String rubro,
												 String deposito,
												 String profe,
												 String tipo_moneda,
												 String tipo_cuenta_id,
												 String emergencia,
												 String organigrama_id,
												 String fecha_op) {
    	Pagination<ActaRecepcion> p = new Pagination<ActaRecepcion>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<ActaRecepcion> e = find.select("id, numero, fecha, total, cierre, ajustes, totalLineasAjustes")
    			.fetch("movimiento").fetch("movimiento.organigrama")
										  .fetch("ordenProvision", "numero")
										  .fetch("estado", "nombre")
										  .fetch("periodo", "nombre")
										  .fetch("ordenProvision.ordenCompra","profe,tipo_moneda,tipo_cuenta_id,fecha_provision")
									 	  .fetch("ordenProvision.ordenCompra.proveedor", "nombre")
									 	  .fetch("ordenProvision.ordenCompra.deposito", "nombre")
										  .fetch("ordenProvision.ordenCompra.ordenRubro", "nombre")
										  .fetch("ordenProvision.ordenCompra.expediente", "nombre, emergencia")
										  .fetch("ordenProvision.ordenCompra.expediente.ejercicio", "nombre")
										  .fetch("ordenProvision.ordenCompra.expediente.parent.ejercicio", "nombre")
									 	  .fetch("ordenProvision.ordenCompra.tipoCuenta", "nombre")
									 	  .fetch("ejercicio", "nombre").where();

    	/*ExpressionList<ActaRecepcion> e = find.select("id, numero, fecha, total, cierre, ajustes")
				  .fetch("ordenProvision", "numero")
				  .fetch("estado", "nombre")
				  .fetch("ordenProvision.ordenCompra","profe,tipo_moneda,tipo_cuenta_id")
			 	  .fetch("ordenProvision.ordenCompra.proveedor", "nombre")
			 	  .fetch("ordenProvision.ordenCompra.expediente", "nombre")
			 	  .fetch("ordenProvision.ordenCompra.deposito", "nombre")
				  .fetch("ordenProvision.ordenCompra.ordenRubro", "nombre")
			 	  .fetch("ordenProvision.ordenCompra.expediente.ejercicio", "nombre")
			 	  .fetch("ejercicio", "nombre").where();*/

    	String or = "";
    	if(!organigrama_id.isEmpty())
    		e.eq("movimiento.organigrama_id", Integer.parseInt(organigrama_id));
    	else
    		or = "OR movimiento.id IS NULL";



    	e.add(Expr.raw("( (movimiento.fecha_llegada, movimiento.acta_id, movimiento.copia) in (SELECT MAX(em2.fecha_llegada),acta_id,copia FROM actas_movimientos em2 WHERE em2.cancelado <> true and em2.copia=false GROUP BY acta_id,copia) " + or +")"));


    	if(!tipo_moneda.isEmpty()){
			e.isNotNull("ordenProvision.ordenCompra.tipo_moneda");
		}

    	if(!tipo_cuenta_id.isEmpty()){
			e.eq("ordenProvision.ordenCompra.tipo_cuenta_id",Integer.parseInt(tipo_cuenta_id));
		}

    	if(!id.isEmpty()) {
    		e.eq("id", Integer.parseInt(id));
    	}

    	if(!rubro.isEmpty()){
    		e.eq("ordenProvision.ordenCompra.orden_rubro_id", Integer.parseInt(rubro));
    	}

    	if(!deposito.isEmpty()){
    		e.eq("ordenProvision.ordenCompra.deposito_id", Integer.parseInt(deposito));
    	}

    	if(!ejercicio.isEmpty()) {
    		e.eq("ejercicio_id", Integer.valueOf(ejercicio));
    	}

    	if(!expediente_id.isEmpty()) {
    		e.eq("ordenProvision.ordenCompra.expediente_id", Integer.valueOf(expediente_id));
    	}

    	if(!orden_provision.isEmpty()) {
    		e.eq("ordenProvision.numero",Integer.parseInt(orden_provision));
    	}

    	if(!proveedor_id.isEmpty()) {
    		if(proveedor_id.compareTo("14947") == 0) {
    			e.in("ordenProvision.ordenCompra.proveedor_id", Proveedor.getProveedoresDestacadosRA());
    		}else {
    			e.eq("ordenProvision.ordenCompra.proveedor_id", Integer.valueOf(proveedor_id));
    		}
        }

    	if(!numero.isEmpty()) {
    		e.eq("numero", numero);
    	}

    	if(!orden_compra.isEmpty()) {
    		e.eq("ordenProvision.ordenCompra.nombre", orden_compra);
    	}

    	if(tipo.equals("servicios")) {
    		e.eq("ordenProvision.ordenCompra.tipo_orden", "servicio");
    	} else if(tipo.equals("productos")) {
    		e.eq("ordenProvision.ordenCompra.tipo_orden", "comun");
    	}

		if(!fecha_desde.isEmpty()){
    		e.ge("fecha", DateUtils.formatDate(fecha_desde, "dd/MM/yyyy"));
    	}

		if(!fecha_hasta.isEmpty()){
    		e.le("fecha", DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy"));
    	}

		if(!profe.isEmpty()){
    		if(profe.compareToIgnoreCase("SI") == 0){
    			e.eq("ordenProvision.ordenCompra.profe", true);
    		}else{
    			e.eq("ordenProvision.ordenCompra.profe", false);
    		}
    	}

		if(!emergencia.isEmpty()){
    		if(emergencia.compareToIgnoreCase("SI") == 0){
    			e.eq("ordenProvision.ordenCompra.expediente.emergencia", true);
    		}else{
    			e.eq("ordenProvision.ordenCompra.expediente.emergencia", false);
    		}
    	}

		if(!fecha_op.isEmpty()){
    		if(fecha_op.compareToIgnoreCase("SI") == 0){
    			e.isNull("ordenProvision.ordenCompra.fecha_provision");
    		}else{
    			e.isNotNull("ordenProvision.ordenCompra.fecha_provision");
    		}
    	}


		if(!filtroBorrador.isEmpty() || !filtroPreajuste.isEmpty() || !filtroAprobada.isEmpty() || !filtroCancelada.isEmpty() || !filtroEnCurso.isEmpty()) {
			e = e.disjunction();
			if(!filtroBorrador.isEmpty()){
	    		e = e.eq("estado_id", 38);
	    	}
			if(!filtroAprobada.isEmpty()){
	    		e = e.eq("estado_id", 40);
	    	}
			if(!filtroPreajuste.isEmpty()){
	    		e = e.eq("estado_id", Estado.ACTA_ESTADO_PRECALCULAR_AJUSTES);
	    	}
			if(!filtroEnCurso.isEmpty()){
	    		e = e.eq("estado_id", 39);
	    	}
			if(!filtroCancelada.isEmpty()){
	    		e = e.eq("estado_id", 41);
	    	}
			e = e.endJunction();
		}

		if(!Permiso.check("verTodoOrdenProvision")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("ordenProvision.ordenCompra.deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("ordenProvision.ordenCompra.deposito_id");
    		}
    	}


    	p.setExpressionList( e );
    	return p;
    }


	public List<OrdenLineaAjuste> getAjustes () {
		String sql = " SELECT ajuste_id FROM actas_ajustes WHERE acta_id = :acta";

		List<SqlRow> facturasSql = Ebean.createSqlQuery(sql).setParameter("acta", id).findList();

		List<Integer> lista = new ArrayList<Integer>(facturasSql.size());

		for (SqlRow row : facturasSql)
			lista.add(row.getInteger("ajuste_id"));

		return OrdenLineaAjuste.find.where().in("id", lista).findList();
	}

	public static List<CertificacionCompra>  getListaCertificacionesComprasDeudas(Long idOrden,Long idCertificacion){
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		List<CertificacionCompra> listaCertificacion = new ArrayList<CertificacionCompra>();

		try {
			conn = play.db.DB.getConnection();


			String sql = " SELECT "+
					" round( cast(COALESCE(SUM(certi.total), 0)-COALESCE(SUM(lautorizados.total),0)as numeric),2) as totalx, "+
					" certi.id as id, "+
					" certi.orden_id as ordenId, "+
					" certi.fecha as fecha, "+
					" certi.estado, "+
					" COALESCE(certi.periodo_id,null) as periodo_id "+
					" FROM ( "+
					" select  SUM(linea.total)  as total, "+
					" cs.id as id,cs.orden_id,fecha_certificacion as fecha,cs.state_id estado,cs.periodo_id periodo_id "+
					" from certificaciones_compras cs  "+
					" JOIN(	SELECT certificaciones_compras_lineas.certificacion_compra_id, "+
					"                 sum(certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision  "+
					" 		- certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision  "+
					" 		* round(COALESCE(certificaciones_compras_lineas.descuento, 0::numeric), 2)::double precision / 100::double precision) AS total "+
					"               FROM certificaciones_compras_lineas "+
					"               GROUP BY certificaciones_compras_lineas.certificacion_compra_id "+
					"             UNION ALL "+
					"              SELECT certificaciones_compras_linea_ajustes.certificacion_compra_id, "+
					"                sum(COALESCE(certificaciones_compras_linea_ajustes.precio, 0::numeric)::double precision * COALESCE(certificaciones_compras_linea_ajustes.cantidad, 0::double precision)) AS total "+
					"                FROM certificaciones_compras_linea_ajustes "+
					"              GROUP BY certificaciones_compras_linea_ajustes.certificacion_compra_id "+
					" 	) linea ON linea.certificacion_compra_id = cs.id "+
					" 	group by cs.id,cs.orden_id,fecha_certificacion,cs.state_id,cs.periodo_id "+

					//" select  SUM(csl.precio * csl.cantidad) + SUM(COALESCE(csa.precio,0) * COALESCE(csa.cantidad, 0)) as total, "+
					//"  cs.id as id,cs.orden_id,fecha_certificacion as fecha,cs.state_id estado,cs.periodo_id periodo_id "+
					//" from certificaciones_compras cs "+
					//" inner join certificaciones_compras_lineas csl on csl.certificacion_compra_id = cs.id "+
					//" left join certificaciones_compras_linea_ajustes csa on csa.certificacion_compra_id = cs.id "+
					//" group by cs.id,cs.orden_id,fecha_certificacion,cs.state_id,cs.periodo_id "+
					" ) certi "+
					" left join (select ala.certificacion_compra_id ,sum(ala.monto) as total "+
					" from autorizado_lineas als "+
					" inner join autorizado_linea_actas ala on als.id =  ala.autorizado_linea_id "+
					" GROUP BY ala.certificacion_compra_id  "+
					" ) as lautorizados on "+
					" lautorizados.certificacion_compra_id = certi.id "+
					" WHERE 1=1 AND certi.estado = 81 ";

					if(idOrden != null){
						sql +="AND certi.orden_id = ? ";
					}else if(idCertificacion != null){
						sql +="AND certi.id = ? ";
					}
					sql +="GROUP BY certi.id,certi.orden_id,certi.fecha,certi.estado,certi.periodo_id "+
						  " HAVING round(cast(COALESCE(SUM(certi.total), 0)-COALESCE(SUM(lautorizados.total), 0)as numeric),2) > 0 "+
						  " ORDER BY fecha asc";
			stmt = conn.prepareStatement(sql);

			if(idOrden != null){
				stmt.setLong(1, idOrden);
			}else if(idCertificacion != null){
				stmt.setLong(1, idCertificacion);
			}

			rs = stmt.executeQuery();

			while (rs.next()) {
				CertificacionCompra ar = new CertificacionCompra();
				ar.id = rs.getLong("id");
				ar.base = rs.getBigDecimal("totalx");
				ar.orden_id = rs.getLong("ordenId");
				ar.fecha_certificacion = rs.getDate("fecha");
				ar.periodo_id = (rs.getLong("periodo_id") == 0)?null:rs.getLong("periodo_id");

				listaCertificacion.add(ar);
			}


		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
	    	try { if (stmt != null) stmt.close(); } catch (Exception e2) { }
	    	try { if (rs != null) rs.close(); } catch (Exception e2) { }
            try { if (conn != null) conn.close(); } catch (Exception e2) { }
        }

		return listaCertificacion;
	}

	public static List<ActaRecepcion>  getListaActasDeudas(Long idOrdenProvision,Long idActa){
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		List<ActaRecepcion> listaActas = new ArrayList<ActaRecepcion>();

		try {
			conn = play.db.DB.getConnection();


String sql = " SELECT " +
			//" round( cast(COALESCE(SUM(actas.total), 0)-COALESCE(SUM(lautorizados.total),0)as numeric),2) as totalx," +
			//"round(  " +
			//"		 cast(sum( (actas.total / COALESCE(o.cot_dolar, 1::numeric))* " +
			//"		COALESCE((SELECT ultimas_cotizaciones.cotizacion FROM ultimas_cotizaciones " +
			//"		                  WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda " +
			//"		                  ORDER BY ultimas_cotizaciones.fecha DESC LIMIT 1),1)) " +
			//"		-COALESCE(SUM(lautorizados.total),0) as numeric) "+
			//" ,2) as totalx," +
			" round(	" +
			" 		CASE " +
			" 		WHEN o.cot_dolar IS NOT NULL " +
			" 		THEN ( " +
			" 			cast(sum( " +

			" 				round( cast( ((actas.total/COALESCE(o.cot_dolar, 1::numeric))-COALESCE(lautorizados.total_dolar,0)) as numeric) ,2) " +

			" 				* " +
			" 				COALESCE( " +
			" 					(SELECT ultimas_cotizaciones.cotizacion FROM ultimas_cotizaciones " +
			" 				WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda " +
			" 				ORDER BY ultimas_cotizaciones.fecha DESC LIMIT 1) " +
			" 					,1) " +
			" 			) " +
			" 			as numeric) " +
			" 		) " +
			" 		ELSE cast(sum(actas.total- COALESCE(lautorizados.total,0))as numeric) " +
			" 		END,2) AS totalx, " +
			" actas.acta_id as actaId," +
			" actas.orden_provision_id as opId," +
			" actas.fecha as fecha, " +
			" actas.numero as numero, " +
			" actas.estado," +
			" COALESCE(actas.periodo_id,null) as periodo_id " +
			"FROM ( " +
				"select COALESCE(SUM(u.total), 0) total,u.acta_id,u.orden_provision_id,fecha,numero,estado,periodo_id " +
				    "from ( " +
						"select  COALESCE(SUM(rl.cantidad * ol.precio), 0) as total,acta_id," +
						"rec.orden_provision_id,fecha,ar.numero,ar.state_id estado,ar.periodo_id periodo_id " +
						"from recepciones rec " +
						"inner join remitos rem on rec.id = rem.recepcion_id " +
						"inner join remitos_lineas rl on rl.remito_id = rem.id " +
						"inner join orden_lineas ol on ol.id = rl.linea_orden_id " +
						"inner join actas_recepcion ar on ar.id = rec.acta_id " +
						"group by acta_id,rec.orden_provision_id,fecha,ar.numero,ar.state_id,ar.periodo_id " +
						"UNION " +
						"select  SUM(csl.precio * csl.cantidad) - SUM(csl.precio * COALESCE(csl.descuento, 0) / 100) as total," +
						"acta_id,cs.orden_provision_id,fecha,ar.numero,ar.state_id estado,ar.periodo_id periodo_id " +
						"from certificaciones_servicios cs " +
						"inner join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id " +
						"inner join actas_recepcion ar on ar.id = cs.acta_id " +
						"group by acta_id,cs.orden_provision_id,fecha,ar.numero,ar.state_id,ar.periodo_id " +
						"UNION " +
						"select " +
						"COALESCE(sum(la.precio * cantidad),0) as total, " +
						"acta_id,ar.orden_provision_id,fecha,ar.numero,ar.state_id estado,ar.periodo_id periodo_id " +
						"from actas_ajustes aj " +
						"inner join orden_lineas_ajustes la on la.id = aj.ajuste_id " +
						"inner join actas_recepcion ar on ar.id = aj.acta_id "+
						"where la.producto_id <> ALL (ARRAY[40277, 40276, 30653]) " +
						"group by acta_id,ar.orden_provision_id,fecha,ar.numero,ar.state_id,ar.periodo_id " +
					") u group by acta_id,orden_provision_id,fecha,numero,estado,periodo_id " +
			") as actas " +
			//"left join (select acta_recepcion_id ,monto as total,orden_provision_id  from autorizado_lineas ) as lautorizados on " +
			"inner join ordenes_provision op on op.id = actas.orden_provision_id "+
			"inner join ordenes o on o.id = op.orden_compra_id "+
			"left join (select ala.acta_recepcion_id ,sum(ala.monto) as total, " +
						"sum(round(COALESCE(ala.monto, 0::numeric) / COALESCE(als.cot_dolar, 1::numeric), 2)) AS total_dolar "+
						"from autorizado_lineas als " +
						"inner join autorizado_linea_actas ala on als.id =  ala.autorizado_linea_id " +
						"GROUP BY ala.acta_recepcion_id" +
						") as lautorizados on " +
			"lautorizados.acta_recepcion_id = actas.acta_id "+

			"WHERE 1=1 AND actas.estado = 40 ";
			if(idOrdenProvision != null){
				sql +="AND actas.orden_provision_id = ? ";
			}else if(idActa != null){
				sql +="AND actas.acta_id = ? ";
			}
			sql +="GROUP BY actas.acta_id,actas.orden_provision_id ,actas.fecha,actas.numero,actas.estado,actas.periodo_id,o.cot_dolar " +
			//"HAVING round(cast(COALESCE(SUM(actas.total), 0)-COALESCE(SUM(lautorizados.total), 0)as numeric),2) > 0  " +
			//"HAVING round(cast(sum( (actas.total / COALESCE(o.cot_dolar, 1::numeric))* COALESCE((SELECT ultimas_cotizaciones.cotizacion FROM ultimas_cotizaciones WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda ORDER BY ultimas_cotizaciones.fecha DESC LIMIT 1),1)) -COALESCE(SUM(lautorizados.total),0) as numeric)  ,2)  > 0  ORDER BY fecha asc ";
			"HAVING round(CASE WHEN o.cot_dolar IS NOT NULL THEN (cast(sum(((actas.total/COALESCE(o.cot_dolar, 1::numeric))-COALESCE(lautorizados.total_dolar,0))*COALESCE((SELECT ultimas_cotizaciones.cotizacion FROM ultimas_cotizaciones WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda ORDER BY ultimas_cotizaciones.fecha DESC LIMIT 1),1)) as numeric)) ELSE cast(sum(actas.total- COALESCE(lautorizados.total,0))as numeric) END,2) > 0.01  ORDER BY fecha asc";

			stmt = conn.prepareStatement(sql);

			if(idOrdenProvision != null){
				stmt.setLong(1, idOrdenProvision);
			}else if(idActa != null){
				stmt.setLong(1, idActa);
			}

			rs = stmt.executeQuery();

			while (rs.next()) {
				ActaRecepcion ar = new ActaRecepcion();
				ar.id = rs.getLong("actaId");
				ar.total = rs.getBigDecimal("totalx");
				ar.orden_provision_id = rs.getInt("opId");
				ar.fecha = rs.getDate("fecha");
				ar.numero = rs.getString("numero");

				ar.periodo_id = (rs.getLong("periodo_id") == 0)?null:rs.getLong("periodo_id");
				Logger.debug("---------------------------- "+ rs.getLong("periodo_id"));
				listaActas.add(ar);
			}


		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
	    	try { if (stmt != null) stmt.close(); } catch (Exception e2) { }
	    	try { if (rs != null) rs.close(); } catch (Exception e2) { }
            try { if (conn != null) conn.close(); } catch (Exception e2) { }
        }

		return listaActas;
	}

	public static int  seleccionAutomaticaActasDeudas(Long idOrdenProvision,BigDecimal monto){
		int x = 0;

		List<ActaRecepcion> listaActas = ActaRecepcion.getListaActasDeudas(idOrdenProvision,null);

		for(ActaRecepcion a :listaActas){

		}

		return x;
	}

	public boolean controlPermisoDeposito() {
		boolean r = true;

		if(!Permiso.check("verTodoOrdenProvision")){

			if(ordenProvision == null || ordenProvision.ordenCompra == null) {
				OrdenProvision o = OrdenProvision.find.byId(orden_provision_id.longValue());
				ordenProvision = o;
			}

			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
				if(Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(ordenProvision.ordenCompra.deposito_id) != 0) {
					r = false;
				}
			}else {
				r = false;
			}
		}

		return r;
	}


	public static Map<Integer,Map<String,String>> getPacientes(Long id) {

		ActaRecepcion ar = ActaRecepcion.find.byId(id);
		Integer x= 1;
		Map<Integer,Map<String,String>> pacientes = new HashMap<Integer,Map<String,String>>();

		if(ar.certificaciones != null && ar.certificaciones.size() > 0) {
	    	for(CertificacionServicio cs : ar.certificaciones ){
				for(CertificacionServicioLinea csl : cs.certificacionesServicioLinea ){

					for(CertificacionServicioLineaCliente clsc :csl.certificacionServicioLineaCliente){
						Map<String,String> hs = new HashMap<String,String>();
						//Logger.debug("aaaaaaaaaa"+oc.cliente.nombre);
						hs.put("nLinea",x.toString());
						hs.put("cantidad",clsc.cantidad.toString());
						hs.put("nombre",clsc.cliente.nombre);
						String refe = (clsc.cliente.id_paciente_rismi == null)?(clsc.cliente.referencia == null)?"":clsc.cliente.referencia:clsc.cliente.id_paciente_rismi;
						hs.put("referencia",refe);
						hs.put("producto",csl.producto.nombre);
						pacientes.put(clsc.id.intValue(),hs);

						x++;
					}
				}
	    	}
	    }else if(ar.recepciones != null && ar.recepciones.size() > 0) {

	    	List<Recepcion> rr = Recepcion.find
	    						.fetch("remito.lineas.remitoLineaCliente", "cantidad,id")
	    						.fetch("remito.lineas.remitoLineaCliente.cliente", "nombre,id_paciente_rismi,referencia")
	    						.fetch("remito.lineas.lineaOrden.producto", "nombre")
	    						.where().eq("acta_id",id)
	    						.findList();





	    	for(Recepcion cs : rr ){



	    		Logger.debug("xxxxxxxxxx "+cs.remito.size());
				for(Remito csl : cs.remito ){
					for(RemitoLinea clsc :csl.lineas){
						for(RemitoLineaCliente clscc :clsc.remitoLineaCliente ){
							Map<String,String> hs = new HashMap<String,String>();
							//Logger.debug("aaaaaaaaaa"+oc.cliente.nombre);
							hs.put("nLinea",x.toString());
							hs.put("cantidad",clscc.cantidad.toString());
							hs.put("nombre",clscc.cliente.nombre);
							String refe = (clscc.cliente.id_paciente_rismi == null)?(clscc.cliente.referencia == null)?"":clscc.cliente.referencia:clscc.cliente.id_paciente_rismi;
							hs.put("referencia",refe);
							hs.put("producto",clsc.lineaOrden.producto.nombre);
							pacientes.put(clscc.id.intValue(),hs);

							x++;
						}

					}
				}
	    	}
	    }

	    return pacientes;
	}
}