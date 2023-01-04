package models;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

import models.auth.Permiso;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;


@Entity 
@Table(name = "pagos")
public class Pago extends Model {
	
	public static final String TIPO_PROVEEDOR = "payment";
	public static final String TIPO_IMPUESTO = "impuestos";
	
	private static final long serialVersionUID = 1L;
	@Id  		
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pagos_id_seq")
	public Long id;
	
	@Required(message="Referencia requerido")
	public String referencia;
	
	public String recibo;
	
	public String numero_cheque;
				  
	public String tipo_pago = "transferencia";
	
	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	//@Required(message="Requiere periodo")
	public Long periodo_id;
	
	@ManyToOne
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;
	@Required(message="Orden de pago requerido")
	public Long orden_pago_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Fecha Pago requerido")
	public Date fecha_pago;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_conciliacion;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_cancelacion;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_entregado;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Fecha Emision requerido")
	public Date fecha_emision;
	
	
	public Date fecha_curso;
	public Date fecha_conciliado_control;
	
	@ManyToOne
	@JoinColumn(name="state_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;

	@Column(name="state_id")
	public Long estado_id;
	
	public String tipo;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Requiere proveedor")
	public Integer proveedor_id;//Proveedor X
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Requiere expediente")
	public Integer expediente_id;//Expediente X

	public String paguese_a;
	public Boolean profe;
	public Integer orden_pago;
	
	@ManyToOne
	@JoinColumn(name="cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaPropia cuentaPropia;
	@Required(message="Requiere Cuenta Propia")
	public Integer cuenta_propia_id;//Cuenta Propia X
	
	@ManyToOne
	@JoinColumn(name="factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public Factura factura;
	@Required(message="Requiere factura")
	public Integer factura_id;//Factura X
	
	@Formula(select = "_b${ta}.total", join = "left outer join (select pago_id, round(sum(monto),2) as total from pagos_lineas group by pago_id) as _b${ta} on _b${ta}.pago_id = ${ta}.id")
	public BigDecimal total;
	
	@Formula(select = "_bc${ta}.total_credito", join = "left outer join (select pago_id, round(sum(monto_credito),2) as total_credito from pagos_lineas group by pago_id) as _bc${ta} on _bc${ta}.pago_id = ${ta}.id")
	public BigDecimal total_credito;
	
	@OneToMany
	@JoinColumn(name="pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<PagoLinea> pagoLinea;
	
	@Required(message="Requiere nombre")
	public String nombre;
	
	public String medio_pago;//Para Pago Cliente
	public String nota;//Para Pago Cliente
	public Boolean agente_pago_externo;
	
	@ManyToOne
	@JoinColumn(name="cuenta_impuesto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuentaImpuesto;
	public Integer cuenta_impuesto_id;//Cuenta Propia X
	
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
	@JoinColumn(name="tipo_cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoCuenta tipoCuenta;
	@Required(message="Tipo Cuenta requerido")
	public Long tipo_cuenta_id;
	
	@ManyToOne
	@JoinColumn(name="mis_pagos_id", referencedColumnName="id", insertable=false, updatable=false)
	public MiPago miPago;
	public Long mis_pagos_id;
	
	public boolean arevisar = false;
	
	public static Integer contabilizarPagos(String referencia, Long miPagoId) {
		String s = "UPDATE pagos " +
				"SET state_id = :estado, mis_pagos_id = :mi_pago, " +
				"write_date = :write_date, write_usuario_id = :write_usuario_id " +
				"WHERE referencia = :referencia and state_id = :borrador ";
		SqlUpdate update = Ebean.createSqlUpdate(s);
		update.setParameter("estado", Estado.PAGO_ESTADO_PAGADO);
		update.setParameter("borrador", Estado.PAGO_ESTADO_BORRADOR);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("mi_pago", miPagoId);
		update.setParameter("referencia", referencia);
		return Ebean.execute(update);
	}

	
	public static Integer conciliarPagosMasivo(String referencia, Long miPagoId) {
		String s = "UPDATE pagos " +
				"SET state_id = :estado, mis_pagos_id = :mi_pago,fecha_conciliacion = fecha_pago, " +
				"write_date = :write_date, write_usuario_id = :write_usuario_id " +
				"WHERE referencia = :referencia and state_id = :borrador ";
		SqlUpdate update = Ebean.createSqlUpdate(s);
		update.setParameter("estado", Estado.PAGO_ESTADO_CONCILIADO);
		update.setParameter("borrador", Estado.PAGO_ESTADO_PAGADO);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("mi_pago", miPagoId);
		update.setParameter("referencia", referencia);
		return Ebean.execute(update);
	}
	
	public static Finder<Long,Pago> find = new Finder<Long,Pago>(Long.class, Pago.class);
	
	public List<Pago> getDataSuggest(String input,Integer limit){
		List<Pago> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		return l;
	}
	
	public static Pagination<Pago> page(
										String fecha_pago_desde,
										String fecha_pago_hasta,
										String proveedor,
										String periodo,
										String expediente,
										String ejercicio,
										String orden_pago,
										String referencia,
										String profe,
										String tipo_proveedor,
										String btnFiltro0,//borrador
										String btnFiltro1,//contabilizado
										String btnFiltro2,//rendido
										String btnFiltro3,//entregado
										String btnFiltro4, //cancelado
										String cuentaImpuesto,
										String facturaProveedor,
										String tipo_proveedor_contraparte,
										String guardia,
										String fecha_entrega_factura_desde,
										String fecha_entrega_factura_hasta,
										String fecha_opg_desde,
										String fecha_opg_hasta,
										String fecha_conciliacion_desde,
										String fecha_conciliacion_hasta,
										String tipo_pago,
										String tipo,
										String rp,
										String tipo_cuenta_id,
										String emergencia,
										String arevisar
										){
		Pagination<Pago> p = new Pagination<Pago>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("proveedor.nombre,factura.proveedor.nombre,periodo_id DESC, id");
    	
    	ExpressionList<Pago> e = find.select("id, nombre, fecha_pago, fecha_conciliacion, tipo, referencia, tipo_pago, profe, total, total_credito, estado_id")
    			.fetch("proveedor", "nombre")
    			.fetch("periodo", "nombre")
    			.fetch("cuentaPropia", "nombre")
    			.fetch("expediente", "id, nombre, emergencia")
    			.fetch("expediente.ejercicio", "nombre")
    			.fetch("expediente.parent.ejercicio", "nombre")
    			.fetch("ordenPago", "numero, id")
    			.fetch("ordenPago.ejercicio", "nombre")
    			.fetch("tipoCuenta", "nombre")
    			.fetch("estado", "id, nombre")
    			.fetch("factura", "fecha_orden_pago, fecha_recepcion, proveedor_id")
    			.fetch("factura.proveedor", "nombre, agente_id")
    			.where();
    	
    	if(Usuario.getUsurioSesion().plansumarmaterno) {
			e = e.eq("tipo_cuenta_id",TipoCuenta.FONDO_PERMANENTE_MATERNO);
    	}	
    	
    	if(Usuario.getUsurioSesion().obera) {
			Date fdesde = DateUtils.formatDate("01/08/2022", "dd/MM/yyyy");
			e = e.ge("factura.create_date", fdesde);
    	}	
		
    	if(Usuario.getUsurioSesion().plansumarmaterno || Usuario.getUsurioSesion().obera) {
			e = e.disjunction();
			e = e.in("factura.orden.deposito_id",Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
			e = e.endJunction();
    		 
    	}
    	
    	
    	if(!tipo_cuenta_id.isEmpty()){
    		e.eq("tipo_cuenta_id", Integer.parseInt(tipo_cuenta_id));
    	}
    	
    	if(!fecha_pago_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_pago_desde, "dd/MM/yyyy");
    		e.ge("fecha_pago", fpd);
    	}
		if(!fecha_pago_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_pago_hasta, "dd/MM/yyyy");
    		e.le("fecha_pago", fph);
    	}
		
		if(!fecha_conciliacion_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_conciliacion_desde, "dd/MM/yyyy");
    		e.ge("fecha_conciliacion", fpd);
    	}
		if(!fecha_conciliacion_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_conciliacion_hasta, "dd/MM/yyyy");
    		e.le("fecha_conciliacion", fph);
    	}
		
		if(!fecha_opg_desde.isEmpty()){
    		Date fefd = DateUtils.formatDate(fecha_opg_desde, "dd/MM/yyyy");
    		e.ge("factura.fecha_orden_pago", fefd);
    	}
		if(!fecha_opg_hasta.isEmpty()){
    		Date fefh = DateUtils.formatDate(fecha_opg_hasta, "dd/MM/yyyy");
    		e.le("factura.fecha_orden_pago", fefh);
    	}
		
		if(!fecha_entrega_factura_desde.isEmpty()){
    		Date fefd = DateUtils.formatDate(fecha_entrega_factura_desde, "dd/MM/yyyy");
    		e.ge("factura.fecha_recepcion", fefd);
    	}
		if(!fecha_entrega_factura_hasta.isEmpty()){
    		Date fefh = DateUtils.formatDate(fecha_entrega_factura_hasta, "dd/MM/yyyy");
    		e.le("factura.fecha_recepcion", fefh);
    	}
    	
		if(!proveedor.isEmpty()){
    		e.eq("proveedor_id", Integer.parseInt(proveedor));
    	}
		
		if(!tipo_pago.isEmpty()){
    		e.eq("tipo_pago", tipo_pago);
    	}
		
		if(!tipo.isEmpty()){
			if(tipo.compareToIgnoreCase("si") == 0){
				e.eq("tipo", "impuestos");
			}else{
				e.eq("tipo", "payment");
			}
    	}
		
		
		if(!periodo.isEmpty()){
    		e.eq("periodo_id", Integer.parseInt(periodo));
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
		
		if(!cuentaImpuesto.isEmpty()){
			e.eq("cuenta_impuesto_id", Integer.parseInt(cuentaImpuesto));
		}	
		
		if(!ejercicio.isEmpty()){
			e.eq("expediente.ejercicio_id", Integer.parseInt(ejercicio));
		}	
		
		/*if(!rp.isEmpty()){
			e.eq("expediente.residuo_pasivo", true);
		}	 */
		
		if(!rp.isEmpty()){
			if(rp.compareToIgnoreCase("si") == 0){
				e.eq("expediente.residuo_pasivo", true);
			}else{
				e.eq("expediente.residuo_pasivo", false);
			}
    	}
		
		
		if(!emergencia.isEmpty()){
    		if(emergencia.compareToIgnoreCase("SI") == 0){
    			e.eq("expediente.emergencia", true);
    		}else{
    			e.eq("expediente.emergencia", false);
    		}
    	}
		
		if(!arevisar.isEmpty()){
    		if(arevisar.compareToIgnoreCase("SI") == 0){
    			e.eq("arevisar", true);
    		}else{
    			e.eq("arevisar", false);
    		}
    	}
		
		if(!facturaProveedor.isEmpty()){
			e.eq("factura.proveedor_id", Integer.parseInt(facturaProveedor));
		}
		
		switch (tipo_proveedor_contraparte) {
			case Proveedor.TIPO_INTERNO:
				e.isNotNull("factura.proveedor.agente_id");
				break;
			case Proveedor.TIPO_EXTERNO:
				e.isNull("factura.proveedor.agente_id");
				break;
			case Proveedor.TIPO_AGENTE_INTERNO:
				e.isNotNull("factura.proveedor.agente_id").eq("factura.proveedor.agente.planta", false);
				break;
			case Proveedor.TIPO_AGENTE_PLANTA:
				e.isNotNull("factura.proveedor.agente_id").eq("factura.proveedor.agente.planta", true);
				break;
		} 
		
		if(!orden_pago.isEmpty()){
    		e.eq("ordenPago.id",Integer.parseInt(orden_pago) );
    	}
		
		/*if(!numero_orden_pago_hasta.isEmpty()){
    		e.le("ordenPago.numero", Integer.parseInt(numero_orden_pago_hasta));
    	}*/
		
		if(!referencia.isEmpty()){
    		e.ilike("referencia", "%" + referencia + "%");
    	}	
		
		if(!profe.isEmpty()){
    		if(profe.compareToIgnoreCase("SI") ==0){
    			e.eq("profe", true);
    		}else{
    			e.eq("profe", false);
    		}
    	}
		
		if(!guardia.isEmpty()){
			e.eq("expediente.guardia", true);
    	}	
		
		boolean tipoProveedorAgente = false;
    	switch (tipo_proveedor) {
			case Proveedor.TIPO_INTERNO:
				e.isNotNull("proveedor.agente_id");
				tipoProveedorAgente = true;
				break;
			case Proveedor.TIPO_EXTERNO:
				//e.isNull("proveedor.agente_id");
				/*e = e.disjunction();
				e = e.isNull("proveedor.agente_id");
				e = e.eq("agente_pago_externo",true);
				e = e.endJunction();*/
				
				break;
			case Proveedor.TIPO_AGENTE_INTERNO:
				e.isNotNull("proveedor.agente_id").eq("proveedor.agente.planta", false);
				tipoProveedorAgente = true;
				break;
			case Proveedor.TIPO_AGENTE_PLANTA:
				e.isNotNull("proveedor.agente_id").eq("proveedor.agente.planta", true);
				tipoProveedorAgente = true;
				break;
		} 
		
    	
    	
		if(tipo_proveedor != null && !tipo_proveedor.isEmpty()){
			String sql = " SELECT expediente_id FROM certificaciones c " +
					 " GROUP BY c.expediente_id";
		
			List<SqlRow> l = Ebean.createSqlQuery(sql).findList();
			List<Integer> le = new ArrayList<Integer>();
			for(SqlRow s: l){
				
				Expediente ePadre2x = Expediente.find.where().eq("parent_id", new Long(s.getInteger("expediente_id"))).findUnique();
	    		if(ePadre2x != null){
	    			le.add(ePadre2x.id.intValue());   		
	    		}		
				
				le.add(s.getInteger("expediente_id"));
			}
	    	if(tipoProveedorAgente){
				e.isNull("agente_pago_externo");
				e.in("expediente_id", le);
			}else{
				e.not(Expr.in("expediente_id", le));
			}
		}
		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty() || !btnFiltro4.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_BORRADOR);
			}	
			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_CONCILIADO);
			}	
			if(!btnFiltro2.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_EN_CURSO);
			}	
			if(!btnFiltro3.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_PAGADO);
			}
			if(!btnFiltro4.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_CANCELADO);
			}
			
			e = e.endJunction();
		}
		
		if(!Permiso.check("verExpedientesGuardiasMonotributo")){
			e.not(Expr.in("expediente_id",Expediente.EXP_GUARDIA_MONOTRIBUTOS));
		}
		
    	p.setExpressionList(e);
    	
    	return p;
	}
	
	public static boolean controlHayReferenciaRepetida(String referencia){
		
		return controlHayReferenciaRepetida(referencia,new ArrayList<Integer>());
	}
	
	public static boolean controlHayReferenciaRepetida(String referencia,Integer id){
		List<Integer> l = new ArrayList<Integer>();
		l.add(id);
		
		return controlHayReferenciaRepetida(referencia,l);
	}
	
	public static boolean controlRefenciasDistintas(List<Integer> listId){
		boolean r = false;
		String sql = " SELECT referencia FROM pagos c " +
				 	 " WHERE id IN (:listId) " +
				 	 " GROUP BY referencia";
		SqlQuery x = Ebean.createSqlQuery(sql);
		List<SqlRow> l ;
		x = x.setParameter("listId", listId);
		l = x.findList();
		
		if(l.size() > 1){
			r = true;
		}
		
		return r;
	}
	
	public static boolean controlHayReferenciaRepetidaDesdeLista(List<Integer> listId){
		return controlHayReferenciaRepetidaDesdeLista(listId,false);
	}
	
	public static boolean controlHayReferenciaRepetidaDesdeLista(List<Integer> listId,boolean noBorrador){
		boolean r = false;
		 
		String sql = " SELECT * FROM pagos " +
				"WHERE referencia IS NOT NULL AND referencia <> '' " +
				"AND referencia = (SELECT referencia FROM pagos c WHERE id IN (:listId) LIMIT 1) ";
			   if(noBorrador){
				   sql +="AND state_id <> :state_id";
			   }
			   sql +="AND id NOT IN (:listId) ";
	
		List<SqlRow> l ;
		SqlQuery x = Ebean.createSqlQuery(sql);
		 		 x = x.setParameter("listId", listId);
		 		 if(noBorrador){
		 			x = x.setParameter("state_id", Estado.PAGO_ESTADO_BORRADOR);
		 		 }
				 l = x.findList();
		if(l.size() > 0){
			r = true;
		}
		 
		return r;
	}
	
	
	public static boolean controlHayReferenciaRepetida(String referencia,List<Integer> listId){
		boolean r = false;
		if(referencia != null){
			referencia = referencia.replace(" ", "");
			String sql = " SELECT * FROM pagos c " +
					 " WHERE upper(replace(referencia, ' ','')) = upper(:referencia) ";
			if(listId != null && listId.size() > 0)
				   sql += " AND id not in (:listId) ";
		
			List<SqlRow> l ;
			SqlQuery x = Ebean.createSqlQuery(sql);
			 		x = x.setParameter("referencia", referencia);
			 		if(listId != null && listId.size() > 0)
			 			x = x.setParameter("listId", listId);
					l = x.findList();
			if(l.size() > 0){
				r = true;
			}
		}
		return r;
	}
	
	public static Integer modificarFechaConciliacionMasiva(Date fecha, List<Integer> pagosSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos SET fecha_conciliacion = :fecha, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("fecha", fecha);
		update.setParameter("ids", pagosSeleccionados);
		//update.setParameter("estado", Estado.PAGO_ESTADO_PAGADO);
		
		return update.execute();
	}
	
	public static Integer modificarFechaCancelacionMasiva(Date fecha, List<Integer> pagosSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos SET fecha_cancelacion = :fecha, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids) ");
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("fecha", fecha);
		update.setParameter("ids", pagosSeleccionados);
		
		return update.execute();
	}
	
	public static Integer modificarNumeroFactura(String numero_factura, Long idPago){
		
		Pago p = Pago.find.byId(idPago);
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE facturas SET numero_factura = :numero_factura, " +
				"write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id = :id ");
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("numero_factura", numero_factura);
		update.setParameter("id", p.factura_id);
		
		return update.execute();
	}
	
	public static Integer modificarNumeroRecibo(String numero_recibo, Long idPago){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos SET recibo = :numero_recibo, " +
				"write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id = :id ");
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("numero_recibo", numero_recibo);
		update.setParameter("id", idPago);
		
		return update.execute();
	}
	
	public static Integer modificarNumeroCheque(String numero_cheque,List<Integer> pagosSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos SET numero_cheque = :numero_cheque, " +
				"write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids) ");
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("numero_cheque", numero_cheque);
		update.setParameter("ids", pagosSeleccionados);
		
		return update.execute();
	}
	
	public static Integer modificarTipoPago(String tipo_pago,List<Integer> pagosSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos SET tipo_pago = :tipo_pago, " +
				"write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids) ");
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("tipo_pago", tipo_pago);
		update.setParameter("ids", pagosSeleccionados);
		
		return update.execute();
	}
	
	public static Integer modificarCuentaPropia(Integer cuenta_propia_id,List<Integer> pagosSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos SET cuenta_propia_id = :cuenta_propia_id, " +
				"write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids) ");
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("cuenta_propia_id", cuenta_propia_id);
		update.setParameter("ids", pagosSeleccionados);
		
		return update.execute();
	}
	
	public static Integer modificarFechaMasiva(Date fecha, List<Integer> pagosSeleccionados){
		//String ids = StringUtils.concatWithSeparator(pagosSeleccionados, ", ");
		
		//SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos set fecha_pago = :fecha where id IN ("+ids+") AND state_id = :estado");
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos SET fecha_pago = :fecha, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids) AND state_id = :estado");
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("fecha", fecha);
		update.setParameter("ids", pagosSeleccionados);
		update.setParameter("estado", Estado.PAGO_ESTADO_BORRADOR);
		
		SqlUpdate update2 = Ebean.createSqlUpdate("UPDATE pagos SET fecha_pago = :fecha, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE factura_id IN (SELECT factura_id FROM pagos where id in(:ids) AND tipo <> 'impuestos') " +
				"AND tipo = 'impuestos' AND state_id = :estado");
		update2.setParameter("write_date",new Date());
		update2.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update2.setParameter("fecha", fecha);
		update2.setParameter("ids", pagosSeleccionados);
		update2.setParameter("estado", Estado.PAGO_ESTADO_BORRADOR);
		update2.execute();
		
		return update.execute();
	}
	
	//public static Integer modificarReferenciaMasiva(String referencia, String[] pagosSeleccionados){
	public static Integer modificarReferenciaMasiva(String referencia, List<Integer> pagosSeleccionados){
		//String ids = StringUtils.concatWithSeparator(pagosSeleccionados, ", ");
		
		//String s = "UPDATE pagos set referencia = :referencia where id IN ("+ids+") AND state_id = :estado";
		String s = "UPDATE pagos " +
				"SET referencia = :referencia, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids) AND state_id = :estado";
		SqlUpdate update = Ebean.createSqlUpdate(s);
		update.setParameter("referencia", referencia);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", pagosSeleccionados);
		update.setParameter("estado", Estado.PAGO_ESTADO_BORRADOR);
		return update.execute();
	}
	
	public static Integer modificarPagueseMasiva(String paguese, List<Integer> pagosSeleccionados){
		String s = "UPDATE pagos " +
				"SET paguese_a = :paguese_a, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids) ";
		SqlUpdate update = Ebean.createSqlUpdate(s);
		update.setParameter("paguese_a", paguese);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", pagosSeleccionados);
		return update.execute();
	}
	
	public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> pagosSeleccionados){
		
		if(idEstado.compareTo(Estado.PAGO_ESTADO_BORRADOR) == 0){
			SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos " +
					"SET state_id = :idEstado, write_date = :write_date,write_usuario_id = :write_usuario_id, " +
					" fecha_pago = :fecha_pago, fecha_conciliacion = :fecha_conciliacion, fecha_curso = :fecha_curso, " +
					" fecha_conciliado_control = :fecha_conciliado_control, fecha_entregado = :fecha_entregado, fecha_cancelacion = :fecha_cancelacion " +
					"WHERE id IN (:ids)");
			update.setParameter("idEstado", idEstado);
			update.setParameter("write_date",new Date());
			update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
			update.setParameter("fecha_pago",null);
			update.setParameter("fecha_conciliacion",null);
			update.setParameter("fecha_curso",null);
			update.setParameter("fecha_conciliado_control",null);
			update.setParameter("fecha_entregado",null);
			update.setParameter("fecha_cancelacion",null);
			update.setParameter("ids", pagosSeleccionados);
			return update.execute();
		}else{
		
			SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos " +
					"SET state_id = :idEstado, write_date = :write_date,write_usuario_id = :write_usuario_id " +
					"WHERE id IN (:ids)");
			update.setParameter("idEstado", idEstado);
			update.setParameter("write_date",new Date());
			update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
			update.setParameter("ids", pagosSeleccionados);
			return update.execute();
		}
		
	}
	
	public static Integer modificarEstadoMasivoAndMisPagos(Integer idEstado, List<Integer> pagosSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos " +
				"SET state_id = :idEstado ,mis_pagos_id = null , write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idEstado", idEstado);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", pagosSeleccionados);
		
		return update.execute();
	}
	
	public static List<SqlRow> getPagosAgentesPlanta(String referencia) {
		String sql = "SELECT * FROM pagos p"
		           +" INNER JOIN proveedores pr ON pr.id = p.proveedor_id " 
		           +" INNER JOIN agentes a ON a.id = pr.agente_id " 
		           +" WHERE a.planta = true AND p.state_id = :estado AND p.referencia = :referencia";
		
		return Ebean.createSqlQuery(sql).setParameter("referencia", referencia).setParameter("estado", Estado.PAGO_ESTADO_BORRADOR).findList();
	}
	
	public static Integer modificarFechaPagoImpuesto(Date fecha,Long idPago){
		SqlUpdate update2 = Ebean.createSqlUpdate("UPDATE pagos SET fecha_pago = :fecha, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE factura_id IN (SELECT factura_id FROM pagos where id = :id) AND tipo = 'impuestos' AND state_id = :estado");
		update2.setParameter("write_date",new Date());
		update2.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update2.setParameter("fecha", fecha);
		update2.setParameter("id", idPago);
		update2.setParameter("estado", Estado.PAGO_ESTADO_BORRADOR);
		
		return update2.execute();
	}
	
	public Long duplicar(Long id){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			stmt = conn.prepareStatement("SELECT duplicar_pagos(?,?)");
			stmt.setInt(1, id.intValue());
			stmt.setInt(2, Usuario.getUsuarioSesion());
			 
			
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
	
	public static List<SqlRow> getImpuestosNoPagadoAgrupados() {
		
		String sql = "SELECT count(*) cantidad,c.id id,c.nombre cuenta,sum(pl.monto) monto "+
					"FROM pagos p "+
					"INNER JOIN cuentas c ON c.id = p.cuenta_impuesto_id "+
					"INNER JOIN pagos_lineas pl ON p.id = pl.pago_id "+
					"WHERE tipo = 'impuestos' "+
					"AND (state_id = :estadoBorrado or state_id = :estadoCurso) "+
					"GROUP BY c.id,c.nombre ORDER BY c.nombre";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("estadoBorrado",Estado.PAGO_ESTADO_BORRADOR)
				.setParameter("estadoCurso",Estado.PAGO_ESTADO_EN_CURSO)
				.findList();
		
		return s;
	}
	
	public static List<SqlRow> getIdsPagosEnCircutoOrdenEnCurso(List<Integer> ids){
		
		String sql2 = " SELECT ocl.pago_id FROM ordenes_pagos_circuitos_lineas ocl "+
					  " INNER JOIN ordenes_pagos_circuitos oc ON oc.id = ocl.orden_pago_circuito_id "+
					  " WHERE oc.estado_id <> :idEstado AND ocl.pago_id in (:ids) ";
	   
		List<SqlRow> s2 = Ebean.createSqlQuery(sql2)
			.setParameter("idEstado",Estado.ORDEN_PAGO_CIRCUITO_ESTADO_BORRADOR)
			.setParameter("ids",ids)
			.findList();
		
		return s2;
	}
	
	public static Long getSecuenciaArchivoInterbanking(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			stmt = conn.prepareStatement("SELECT nextval('archivo_interbanking_id_seq')");
			 
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
}
