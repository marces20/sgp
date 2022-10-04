package models;

import java.math.BigDecimal;
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
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;
@Entity 
@Table(name = "balance_cuentas_propias")
public class BalanceCuentaPropia extends Model {
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="balance_cuentas_propias_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaPropia cuentaPropia;
	@Required(message="Requiere cuenta propia")
	public Integer cuenta_propia_id;
	
	@Required(message="Requiere Fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_debito;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_emision;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_cancelado;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Integer expediente_id;
	
	@ManyToOne
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;
	public Long orden_pago_id;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	public Integer proveedor_id;
	
	@OneToMany
	@JoinColumn(name="balance_cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<BalanceCuentaPropiaOrdenPago> balanceCuentaPropiaOrdenPago;
	
	@OneToMany
	@JoinColumn(name="balance_cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<BalanceCuentaPropiaExpediente> balanceCuentaPropiaExpediente;
	
	@OneToMany
	@JoinColumn(name="balance_cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<BalanceCuentaPropiaPago> balanceCuentaPropiaPago;
	
	@DecimalComa(value="")
	@Required(message="Requiere deposito")
	public BigDecimal deposito;
	
	@DecimalComa(value="")
	@Required(message="Requiere deposito")
	public BigDecimal debito;
	
	@Required(message="Requiere N° Cheque/Trasf.")
	public String numero_cheque;
	@Required(message="Requiere referencia")
	public String referencia;
	public String a_la_orden;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	
	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id;
	
	@Formula(select = "_b${ta}.cantidadop", join = "left outer join (select count(*) as cantidadop,balance_cuenta_propia_id from balance_cuentas_propia_ordenespagos group by balance_cuenta_propia_id) as _b${ta} on _b${ta}.balance_cuenta_propia_id = ${ta}.id")
	public BigDecimal cantidadop;
	
	@Formula(select = "_e${ta}.cantidadex", join = "left outer join (select count(*) as cantidadex,balance_cuenta_propia_id from balance_cuentas_propia_expedientes group by balance_cuenta_propia_id) as _e${ta} on _e${ta}.balance_cuenta_propia_id = ${ta}.id")
	public BigDecimal cantidadex;
	
	@ManyToOne
	@JoinColumn(name="tipo_balance_cuentas_propias_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario tipo_balance_cuentas_propias; 
	@Column(name="tipo_balance_cuentas_propias_id")
	public Long tipo_balance_cuentas_propias_id;
	
	@ManyToOne
	@JoinColumn(name="origen_balance_cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public BalanceCuentaPropia origen_balance_cuenta_propia; 
	@Column(name="origen_balance_cuenta_propia_id")
	public Long origen_balance_cuenta_propia_id;
	
	
	
	public static Finder<Long,BalanceCuentaPropia> find = new Finder<Long,BalanceCuentaPropia>(Long.class, BalanceCuentaPropia.class);
	
	public static Pagination<BalanceCuentaPropia> page(String cuentaId,
													   String expedienteId,
													   String proveedoId,
													   String fecha_desde,
													   String fecha_hasta,
													   String fecha_debito_desde,
													   String fecha_debito_hasta,
													   String ordenPagoId,
													   String btnFiltro0,//en curso
													   String btnFiltro1,//pagado
													   String btnFiltro2,//conciliado
													   String btnFiltro3,//cancelado
													   String ejercicio,
													   String referencia,
													   String numero_cheque
													   ) { 
		
    	Pagination<BalanceCuentaPropia> p = new Pagination<BalanceCuentaPropia>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("fecha,debito");
    	p.setPageSize(500);
    	
    	ExpressionList<BalanceCuentaPropia> f = find
    			.fetch("estado", "id,nombre")
    			.fetch("cuentaPropia", "nombre")
    			//.fetch("balanceCuentaPropiaOrdenPago.ordenPago", "numero")
    			//.fetch("balanceCuentaPropiaOrdenPago.ordenPago.ejercicio", "nombre")
    			//.fetch("balanceCuentaPropiaExpediente.expediente", "nombre")
    			//.fetch("balanceCuentaPropiaExpediente.expediente.ejercicio", "nombre")
    			.where();
    	
    	if(!ejercicio.equals("")){
    		Ejercicio ej = Ejercicio.find.byId(new Long(ejercicio));
    		f = f.disjunction();
    		f = f.between("fecha", ej.date_start, ej.date_stop);
    		//f = f.between("fecha_debito", ej.date_start, ej.date_stop); 
    		f = f.between("fecha_emision", ej.date_start, ej.date_stop); 
    		f = f.between("fecha_cancelado", ej.date_start, ej.date_stop); 
    		f = f.endJunction();
		}else{
			Ejercicio ej = Ejercicio.find.byId(new Long(6));
    		f = f.disjunction();
    		f = f.between("fecha", ej.date_start, ej.date_stop);
    		//f = f.between("fecha_debito", ej.date_start, ej.date_stop);
    		f = f.between("fecha_emision", ej.date_start, ej.date_stop); 
    		f = f.between("fecha_cancelado", ej.date_start, ej.date_stop);
    		f = f.endJunction();
		}
    	
    	if(!referencia.equals("")){
    		f.ilike("referencia", "%" + referencia + "%");
		}
    	
    	if(!numero_cheque.equals("")){
    		f.ilike("numero_cheque", "%" + numero_cheque + "%");
		}
    	
    	if(!cuentaId.equals("")){
    		f.eq("cuenta_propia_id", Integer.parseInt(cuentaId));
		}
    	
    	if(!expedienteId.equals("")){
    		f = f.disjunction();	
    		f = f.eq("expediente_id", Integer.parseInt(expedienteId));
    		f = f.eq("balanceCuentaPropiaExpediente.expediente_id", Integer.parseInt(expedienteId));
    		f = f.endJunction();
		}
    	if(!ordenPagoId.equals("")){
    		f = f.disjunction();	
    		f = f.eq("orden_pago_id", Integer.parseInt(ordenPagoId));
    		f = f.eq("balanceCuentaPropiaOrdenPago.orden_pago_id", Integer.parseInt(ordenPagoId));
    		f = f.endJunction();
		}
    	if(!proveedoId.equals("")){
    		f.eq("proveedor_id", Integer.parseInt(proveedoId));
		}
    	
    	/*if(!fecha_desde.isEmpty()){
    		Date ffd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		f.ge("fecha_emision", ffd);
    	}
		if(!fecha_hasta.isEmpty()){
    		Date ffh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		f.le("fecha_emision", ffh);
    	}*/
    	
    	if(!fecha_desde.isEmpty() && !fecha_hasta.isEmpty()){
    		Date ffd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		Date ffh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    
    		f = f.disjunction();
	    		f = f.conjunction();
	    			f = f.add(Expr.between("fecha_emision",ffd, ffh)).add(Expr.isNull("fecha_cancelado"));
	    		f = f.endJunction();
	    		f = f.conjunction();
	    			f = f.add(Expr.between("fecha_cancelado",ffd, ffh)).add(Expr.isNotNull("fecha_cancelado"));
	    		f = f.endJunction();
    		f = f.endJunction();
    		
    	}
		
		if(!fecha_debito_desde.isEmpty()){
    		Date ffd = DateUtils.formatDate(fecha_debito_desde, "dd/MM/yyyy");
    		f.ge("fecha_debito", ffd);
    	}
		if(!fecha_debito_hasta.isEmpty()){
    		Date ffh = DateUtils.formatDate(fecha_debito_hasta, "dd/MM/yyyy");
    		f.le("fecha_debito", ffh);
    	}
			
		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty()){
			f = f.disjunction();
			 
			if(!btnFiltro0.isEmpty()){
				 f = f.eq("estado_id", Estado.PAGO_ESTADO_EN_CURSO);
			}	
			if(!btnFiltro1.isEmpty()){
				 f = f.eq("estado_id", Estado.PAGO_ESTADO_PAGADO);
			}	
			if(!btnFiltro2.isEmpty()){
				 f = f.eq("estado_id", Estado.PAGO_ESTADO_CONCILIADO);
			}
			if(!btnFiltro3.isEmpty()){
				 f = f.eq("estado_id", Estado.PAGO_ESTADO_CANCELADO);
			}
			
			f = f.endJunction();
		}
		
		if(!Permiso.check("verExpedientesGuardiasMonotributo")){
			f.not(Expr.in("balanceCuentaPropiaExpediente.expediente_id", Expediente.EXP_GUARDIA_MONOTRIBUTOS));
		}
		
    	p.setExpressionList(f);
    	return p;
    }
	
	public static BalanceCuentaPropia cancelarDesdePago(Pago p) throws Exception {
		BalanceCuentaPropia bcp = null;
		try {
			BalanceCuentaPropiaPago ccpTmp = BalanceCuentaPropiaPago.find.where().eq("pago_id", p.id).setMaxRows(1).findUnique();
			if(ccpTmp != null){
				List<Object> r = new ArrayList<Object>();
				ExpressionList<BalanceCuentaPropia> e = BalanceCuentaPropia.find.where().eq("id", ccpTmp.balance_cuenta_propia_id);
				e = e.eq("Extract(month from fecha)", new Integer(DateUtils.formatDate(p.fecha_cancelacion,"M")));
				e = e.eq("Extract(YEAR from fecha)", new Integer(DateUtils.formatDate(p.fecha_cancelacion,"yyyy")));
				r = e.findIds();
				
				//if(r.size() <= 0){
					SqlUpdate update = Ebean.createSqlUpdate("UPDATE balance_cuentas_propias " +
							"SET estado_id = :idEstado, fecha_cancelado = :fcancelado " +
							"WHERE id IN (SELECT balance_cuenta_propia_id FROM balance_cuentas_propia_pagos WHERE pago_id = :pago_id)");
					update.setParameter("idEstado", p.estado_id);
					update.setParameter("fcancelado", p.fecha_cancelacion);
					//update.setParameter("fcancelado", null);
					update.setParameter("pago_id", p.id);
					update.execute();
					
					bcp = insertDesdePago(p,true);
				/*}else{
					bcp = updateDesdePago(p,ccpTmp.balance_cuenta_propia_id,true);
					
				}*/
			}
		} catch (Exception e) {
			
			throw e;
		}	
		return bcp;
	}
	
	public static BalanceCuentaPropia agregarLineaDesdePago(Pago p) throws Exception {
		BalanceCuentaPropia bcp = null;
		BalanceCuentaPropiaPago ccpTmp = BalanceCuentaPropiaPago.find.where().eq("pago_id", p.id).setMaxRows(1).findUnique();
		if(ccpTmp != null){
			bcp = updateDesdePago(p,ccpTmp.balance_cuenta_propia_id,false);
		}else{
			bcp = insertDesdePago(p,false);
		}
		
		return bcp;
	}
	
	public static int deleteDesdeListaPago(List<Integer> ids) throws Exception{
		int r = 0;
		try {
			SqlUpdate down = Ebean.createSqlUpdate("DELETE FROM balance_cuentas_propias WHERE id IN(SELECT balance_cuenta_propia_id FROM balance_cuentas_propia_pagos WHERE pago_id IN(:idsPagos))");
			down.setParameter("idsPagos", ids);
			r = down.execute(); 
		} catch (Exception e) {
			throw e;
		}
		
		return  r; 
	}
	
	public static int deleteDesdeIdPago(Long id) throws Exception{
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(id.intValue());
		return deleteDesdeListaPago(ids);
	}

	public static BalanceCuentaPropia insertUpdateDesdeListaPago(String referencia,boolean cancelar) throws Exception{
		
		List<Integer> pagoSeleccionados = new ArrayList<Integer>();
		List<Object> pagoIds = Pago.find.select("id").where().eq("referencia", referencia).findIds();
		
		for(Object x :pagoIds){
			Long f = new Long((long)x);
			pagoSeleccionados.add(f.intValue());
		}
		
		return insertUpdateDesdeListaPago(pagoSeleccionados,false,cancelar);
	}
	
	public static BalanceCuentaPropia insertUpdateDesdeListaPago(List<Integer> pagosSeleccionados,boolean delete,boolean cancelar) throws Exception{
		BalanceCuentaPropia bcp = new BalanceCuentaPropia();
		try {
			
			if(delete){
				BalanceCuentaPropia.deleteDesdeListaPago(pagosSeleccionados);
			}
			
			List<SqlRow> r = Ebean.createSqlQuery("SELECT SUM(pl.monto) total,SUM(pl.monto_credito) total_credito,p.cuenta_propia_id cuenta_propia_id,"  
					+"p.fecha_pago fecha_pago,p.fecha_cancelacion fecha_cancelacion,p.fecha_conciliacion fecha_conciliacion,p.expediente_id expediente_id,p.orden_pago_id orden_pago_id,p.numero_cheque,p.referencia referencia,p.state_id state_id "  
					+"FROM pagos p " 
					+"INNER JOIN pagos_lineas pl on p.id = pl.pago_id " 
					+"WHERE p.id IN (:ids) " 
					+"GROUP BY p.cuenta_propia_id,p.fecha_pago,p.fecha_cancelacion,p.fecha_conciliacion,p.expediente_id,p.orden_pago_id,p.numero_cheque,p.referencia,p.state_id ")
					.setParameter("ids",pagosSeleccionados).findList();
			
			Integer cuenta_propia_idTmp = null;
			Date fecha_pagoTmp = null;
			Date fecha_debito = null;
			Date fecha_cancelacion = null;
			String referenciaTmp = null;
			Long estado_idTmp = null;
			BigDecimal total_credito = new BigDecimal(0);
			BigDecimal total = new BigDecimal(0);
			
			List<Long> listExp = new ArrayList<Long>();
			List<Long> listOp = new ArrayList<Long>();
			
			
			for(SqlRow x :r){
				cuenta_propia_idTmp = x.getInteger("cuenta_propia_id");
				fecha_pagoTmp = x.getDate("fecha_pago");
				fecha_debito = x.getDate("fecha_conciliacion");
				fecha_cancelacion = x.getDate("fecha_cancelacion");
				referenciaTmp = x.getString("referencia");
				estado_idTmp = x.getLong("state_id");
				total_credito = total_credito.add(x.getBigDecimal("total_credito"));
				total = total.add(x.getBigDecimal("total"));
				
				listExp.add(x.getLong("expediente_id"));
				if(x.getLong("orden_pago_id") != null){
					listOp.add(x.getLong("orden_pago_id"));
				}
			}
			
			bcp.cuenta_propia_id = cuenta_propia_idTmp;
			//bcp.fecha = fecha_pagoTmp;
			bcp.fecha_debito = fecha_debito;
			bcp.fecha_cancelado = fecha_cancelacion;
			//bcp.proveedor_id = p.proveedor_id;
			//bcp.expediente_id = p.expediente_id;
			//bcp.orden_pago_id = p.orden_pago_id;
			if(cancelar){
				bcp.fecha = fecha_cancelacion;
				bcp.fecha_emision = fecha_cancelacion;
				bcp.deposito = total;
				bcp.debito = total_credito;
			}else{
				bcp.fecha = fecha_pagoTmp;
				bcp.deposito = total_credito;
				bcp.debito = total;
			}
			//bcp.numero_cheque = p.numero_cheque;
			bcp.referencia = referenciaTmp;
			bcp.a_la_orden ="";
			bcp.create_usuario_id = (long) Usuario.getUsuarioSesion();
			bcp.create_date = new Date();
			bcp.estado_id = estado_idTmp;
			bcp.save();
			
			for(Integer pp : pagosSeleccionados){
				BalanceCuentaPropiaPago cpp = new BalanceCuentaPropiaPago();
				cpp.balance_cuenta_propia_id = bcp.id;
				cpp.pago_id = pp.longValue();
				cpp.save();
			}
			
			for(Long el : listExp){
				BalanceCuentaPropiaExpediente cpe = new BalanceCuentaPropiaExpediente();
				cpe.balance_cuenta_propia_id = bcp.id;
				cpe.expediente_id = el;
				cpe.save();
			}
			
			for(Long ol : listOp){
				BalanceCuentaPropiaOrdenPago cpo = new BalanceCuentaPropiaOrdenPago();
				cpo.balance_cuenta_propia_id = bcp.id;
				cpo.orden_pago_id = ol;
				cpo.save();
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return bcp;
	}
	
	public static BalanceCuentaPropia cancelarDesdeListaPago(List<Integer> pagosSeleccionados) throws Exception {
		
		BalanceCuentaPropia bcp = null;
		try {
			BalanceCuentaPropiaPago ccpTmp = BalanceCuentaPropiaPago.find.where().in("pago_id", pagosSeleccionados).setMaxRows(1).findUnique();
			if(ccpTmp != null){
				List<Object> r = new ArrayList<Object>();
				
				Pago ptmp = Pago.find.where().in("id", pagosSeleccionados).setMaxRows(1).findUnique();
				
				ExpressionList<BalanceCuentaPropia> e = BalanceCuentaPropia.find.where().eq("id", ccpTmp.balance_cuenta_propia_id);
				e = e.eq("Extract(month from fecha)", new Integer(DateUtils.formatDate(ptmp.fecha_cancelacion,"M")));
				e = e.eq("Extract(YEAR from fecha)", new Integer(DateUtils.formatDate(ptmp.fecha_cancelacion,"yyyy")));
				r = e.findIds();
				
				if(r.size() <= 0){
					Logger.debug("SI EL PAGO ES DEL MISMO MES Y AÑO NO BORRO.. INSERTO UNO NUEVO ");
					SqlUpdate update = Ebean.createSqlUpdate("UPDATE balance_cuentas_propias " +
							"SET estado_id = :idEstado, fecha_cancelado = :fcancelado " +
							"WHERE id IN (SELECT balance_cuenta_propia_id FROM balance_cuentas_propia_pagos WHERE pago_id IN(:ids))");
					update.setParameter("idEstado", Estado.PAGO_ESTADO_CANCELADO);
					update.setParameter("fcancelado", ptmp.fecha_cancelacion);
					update.setParameter("ids", pagosSeleccionados);
					update.execute();
					
					 
					
					bcp = BalanceCuentaPropia.insertUpdateDesdeListaPago(pagosSeleccionados,false,true);
					 
				}else{
					Logger.debug("SI EL PAGO ES DEL MISMO MES Y AÑO NO BORRO.. BORROOO INSERTO UNO NUEVO ");
					bcp =  BalanceCuentaPropia.insertUpdateDesdeListaPago(pagosSeleccionados,true,true);
					
				}
			}
		} catch (Exception e) {
			
			throw e;
		}	
		return bcp;
	}
	
	
	public static BalanceCuentaPropia updateDesdePago(Pago p,Long id,boolean cancelar) throws Exception{
		BalanceCuentaPropia bcp = new BalanceCuentaPropia();
		try {
			bcp.id = id;
			bcp.cuenta_propia_id = p.cuenta_propia_id;
			bcp.fecha = p.fecha_pago;
			bcp.fecha_debito = p.fecha_conciliacion;
			bcp.fecha_emision = p.fecha_emision;
			bcp.fecha_cancelado = p.fecha_cancelacion;
			
			bcp.proveedor_id = p.proveedor_id;
			if(cancelar){
				bcp.deposito = p.total;
				bcp.debito = p.total_credito;
			}else{
				bcp.deposito = p.total_credito;
				bcp.debito = p.total;
			}
			bcp.numero_cheque = p.numero_cheque;
			bcp.referencia = p.referencia;
			bcp.a_la_orden = (p.proveedor.nombre.compareToIgnoreCase(p.paguese_a) != 0 && (p.paguese_a != null && !p.paguese_a.isEmpty()))?p.paguese_a:p.proveedor.nombre;
			bcp.create_usuario_id = (long) Usuario.getUsuarioSesion();
			bcp.create_date = new Date();
			bcp.estado_id = p.estado_id;
			bcp.expediente_id=p.expediente_id;
			bcp.orden_pago_id = (p.orden_pago_id != null)?p.orden_pago_id:null;
			bcp.update();
			
			BalanceCuentaPropiaExpediente.deleteDesdeBalance(bcp.id);
			BalanceCuentaPropiaExpediente.insert(bcp.id, p.expediente_id.longValue());
			if(p.orden_pago_id != null){
				BalanceCuentaPropiaOrdenPago.deleteDesdeBalance(bcp.id);
				BalanceCuentaPropiaOrdenPago.insert(bcp.id, p.orden_pago_id.longValue());
			}
		} catch (Exception e) {
			
			throw e;
		}	

		return bcp;
	}
	
	public static BalanceCuentaPropia insertDesdePago(Pago p,boolean cancelar) throws Exception{
		
		BalanceCuentaPropia bcp = new BalanceCuentaPropia();
		
		try {
			
			bcp.cuenta_propia_id = p.cuenta_propia_id;
			bcp.fecha_debito = p.fecha_conciliacion;
			bcp.fecha_emision = p.fecha_emision;
			bcp.proveedor_id = p.proveedor_id;
			bcp.fecha_cancelado = p.fecha_cancelacion;
			if(cancelar){
				bcp.fecha = p.fecha_cancelacion;
				bcp.fecha_emision = p.fecha_cancelacion;
				bcp.deposito = p.total;
				bcp.debito = p.total_credito;
			}else{
				bcp.fecha = p.fecha_pago;
				bcp.deposito = p.total_credito;
				bcp.debito = p.total;
			}
			bcp.numero_cheque = p.numero_cheque;
			bcp.referencia = p.referencia;
			bcp.a_la_orden = (p.proveedor.nombre.compareToIgnoreCase(p.paguese_a) != 0 && (p.paguese_a != null && !p.paguese_a.isEmpty()))?p.paguese_a:p.proveedor.nombre;
			bcp.create_usuario_id = (long) Usuario.getUsuarioSesion();
			bcp.create_date = new Date();
			bcp.estado_id = p.estado_id;
			bcp.expediente_id=p.expediente_id;
			bcp.orden_pago_id = (p.orden_pago_id != null)?p.orden_pago_id:null;
			bcp.save();
			
			BalanceCuentaPropiaPago.insert(bcp.id, p.id);
			BalanceCuentaPropiaExpediente.insert(bcp.id, p.expediente_id.longValue());
			if(p.orden_pago_id != null){
				BalanceCuentaPropiaOrdenPago.insert(bcp.id, p.orden_pago_id.longValue());
			}
		} catch (Exception e) {
			throw e;
		}

		return bcp;
	}
	
	public static List<SqlRow> getSaldosCuentas(Long estado_id){
		return getSaldosCuentas(null,null,estado_id);
	}
	
	public static List<SqlRow> getSaldosCuentas(Date fdesde,Date fhasta,Long estado_id){
		List<SqlRow> re = new ArrayList<SqlRow>();
		String union = "";
		
		if(fhasta != null && fdesde != null){
				union = " UNION ALL "+
							" SELECT 0 as deposito,0 as debito,COALESCE(SUM(deposito),0)-COALESCE(SUM(debito),0) as saldo, cp.id as id ,cp.nombre as nombre "+
							" FROM balance_cuentas_propias bcp "+
							" INNER JOIN cuentas_propias cp ON cp.id = bcp.cuenta_propia_id "+
							" WHERE 1 = 1 "+
							//" AND (( bcp.fecha_debito < :fdesde) OR (bcp.fecha < :fdesde) OR (bcp.fecha_cancelado < :fdesde) OR (bcp.fecha_emision < :fdesde)) "+
							" AND ((bcp.fecha_cancelado < :fdesde and bcp.fecha_cancelado is not null) OR (bcp.fecha_emision < :fdesde and bcp.fecha_cancelado is null)) "+
							" AND ((bcp.fecha >= '2019-08-01' and bcp.fecha_debito >= '2019-08-01' and bcp.fecha_cancelado >= '2019-08-01' and bcp.fecha_emision >= '2019-08-01') or (bcp.id in(16770,16769,16768,16767,16766)) ) "+
							" AND (bcp.estado_id = :estado or bcp.estado_id = :estadopagado or bcp.estado_id = :estadocancelado or bcp.estado_id = :estadoconciliado or bcp.estado_id = :estadoencurso) "+
							" GROUP BY cp.id ,cp.nombre ";
		}
		
		String sql = "SELECT COALESCE(SUM(s.deposito),0) as deposito,COALESCE(SUM(s.debito),0) as debito,COALESCE(SUM(s.saldo),0) as saldo,"+
											"s.id as id,s.nombre as nombre "+
											"FROM( "+
												"SELECT COALESCE(SUM(deposito),0) as deposito,COALESCE(SUM(debito),0) as debito,COALESCE(SUM(deposito),0)-COALESCE(SUM(debito),0) as saldo, cp.id  as id,cp.nombre as nombre "+ 
												"FROM balance_cuentas_propias bcp "+
												"INNER JOIN cuentas_propias cp ON cp.id = bcp.cuenta_propia_id "+
												"WHERE 1 = 1 ";
										if(fhasta != null && fdesde != null){
											 
											/*sql += "AND (( bcp.fecha_debito >= :fdesde AND bcp.fecha_debito <= :fhasta) "+
														  "OR (bcp.fecha_cancelado >= :fdesde AND bcp.fecha_cancelado <= :fhasta) "+
														  "OR (bcp.fecha_emision >= :fdesde AND bcp.fecha_emision <= :fhasta) "+
														  "OR (bcp.fecha >= :fdesde AND bcp.fecha <= :fhasta)) ";*/
											sql += "AND ((bcp.fecha_cancelado >= :fdesde AND bcp.fecha_cancelado <= :fhasta AND bcp.fecha_cancelado is not null ) "+
													  "OR (bcp.fecha_emision >= :fdesde AND bcp.fecha_emision <= :fhasta AND bcp.fecha_cancelado is null)) ";
											
										}
										sql += " AND ((bcp.fecha >= '2019-08-01' or bcp.fecha_debito >= '2019-08-01' or bcp.fecha_cancelado >= '2019-08-01' or bcp.fecha_emision >= '2019-08-01') or (bcp.id in(16770,16769,16768,16767,16766)) ) ";
										sql += " AND (bcp.estado_id = :estado or bcp.estado_id = :estadopagado or  bcp.estado_id = :estadocancelado or bcp.estado_id = :estadoconciliado or bcp.estado_id = :estadoencurso) "+
												"GROUP BY cp.id ,cp.nombre ";
											sql +=  union;
										sql += ") s "+
											"GROUP BY s.id ,s.nombre ORDER BY s.nombre asc";
		
		
		
		SqlQuery r = Ebean.createSqlQuery(sql);
		if(fhasta != null && fdesde != null){
			r = r.setParameter("fdesde",fdesde);
			r = r.setParameter("fhasta",fhasta);
		}
		r = r.setParameter("estado",estado_id);
		r = r.setParameter("estadopagado",Estado.PAGO_ESTADO_PAGADO);
		r = r.setParameter("estadocancelado",Estado.PAGO_ESTADO_CANCELADO);
		r = r.setParameter("estadoencurso",Estado.PAGO_ESTADO_EN_CURSO);
		r = r.setParameter("estadoconciliado",Estado.PAGO_ESTADO_CONCILIADO);
		
		re = r.findList();
		
		return re;
	}
	
	public static SqlRow getSaldosInicialesCuentas(Date fdesde,Long cuenta_id,Long estado_id){
		SqlRow re = null;
		String union = "";
		
	 
		String sql = "SELECT COALESCE(SUM(s.deposito),0) as deposito,COALESCE(SUM(s.debito),0) as debito,COALESCE(SUM(s.saldo),0) as saldo,"+
					"s.id as id,s.nombre as nombre "+
					"FROM( "+
					" SELECT COALESCE(SUM(deposito),0) as deposito,COALESCE(SUM(debito),0) as debito,COALESCE(SUM(deposito),0)-COALESCE(SUM(debito),0) as saldo, "+
					" cp.id as id ,cp.nombre as nombre "+
					" FROM balance_cuentas_propias bcp "+  
					" INNER JOIN cuentas_propias cp ON cp.id = bcp.cuenta_propia_id "+ 
					" WHERE 1 = 1 "+
					//" AND ((bcp.fecha_debito < :fdesde) or (bcp.fecha < :fdesde) or (bcp.fecha_emision < :fdesde) or (bcp.fecha_cancelado < :fdesde)) "+
					" AND ("
					+ "		(bcp.fecha_emision < :fdesde and bcp.fecha_cancelado is null) or "
					+ "		(bcp.fecha_cancelado < :fdesde AND bcp.fecha_cancelado is not null)"
					+ "	  ) "+
					" AND (("
					+ "		bcp.fecha >= '2018-08-01' and bcp.fecha_debito >= '2018-08-01' and bcp.fecha_emision >= '2018-08-01'"
					+ "		 AND bcp.fecha_cancelado >= '2018-08-01'"
					+ "		) or "
					+ "		(bcp.id in(16770,16769,16768,16767,16766)"
					+ "		)"
					+ "	   ) "+
					" AND (bcp.estado_id = :estado or bcp.estado_id = :estadopagado or bcp.estado_id = :estadocancelado or bcp.estado_id = :estadoconciliado or bcp.estado_id = :estadoencurso)  "+
					" AND cp.id = :cuenta_id "+
					" GROUP BY cp.id ,cp.nombre "+
					") s "+
					"GROUP BY s.id ,s.nombre ORDER BY s.nombre asc LIMIT 1";
		
		

		
		SqlQuery r = Ebean.createSqlQuery(sql);
		if(fdesde != null){
			r = r.setParameter("fdesde",fdesde);
		}
		r = r.setParameter("cuenta_id",cuenta_id);
		r = r.setParameter("estado",estado_id);
		r = r.setParameter("estadopagado",Estado.PAGO_ESTADO_PAGADO);
		r = r.setParameter("estadocancelado",Estado.PAGO_ESTADO_CANCELADO);
		r = r.setParameter("estadoencurso",Estado.PAGO_ESTADO_EN_CURSO);
		r = r.setParameter("estadoconciliado",Estado.PAGO_ESTADO_CONCILIADO);
		
		re = r.findUnique();
		
		return re;
	}
	
	
	public static List<SqlRow> getIngresos(Date fdesde,Long estado_id){
		List<SqlRow> re = new ArrayList<SqlRow>();
		String union = "";
		
	 
		String sql = "SELECT SUM(s.deposito) as deposito,sum(s.debito) as debito,sum(s.saldo) as saldo,"+
					"s.id as id,s.nombre as nombre "+
					"FROM( "+
					" SELECT SUM(deposito) as deposito,sum(debito) as debito,SUM(deposito)-SUM(debito) as saldo, "+
					" cp.id as id ,cp.nombre as nombre "+
					" FROM balance_cuentas_propias bcp "+  
					" INNER JOIN cuentas_propias cp ON cp.id = bcp.cuenta_propia_id "+ 
					" WHERE 1 = 1 "+
					//" AND ((bcp.fecha_debito < :fdesde) or (bcp.fecha < :fdesde) or (bcp.fecha_emision < :fdesde) or (bcp.fecha_cancelado < :fdesde)) "+
					" AND ((bcp.fecha_emision < :fdesde and bcp.fecha_cancelado is null) or (bcp.fecha_cancelado < :fdesde and bcp.fecha_cancelado is not null)) "+
					" AND ((bcp.fecha >= '2019-08-01' and bcp.fecha_debito >= '2019-08-01' and bcp.fecha_emision >= '2019-08-01' and bcp.fecha_cancelado >= '2019-08-01') or (bcp.id in(16770,16769,16768,16767,16766))) "+
					" AND (bcp.estado_id = :estado or bcp.estado_id = :estadopagado or bcp.estado_id = :estadocancelado or bcp.estado_id = :estadoconciliado or bcp.estado_id = :estadoencurso) "+
					" GROUP BY cp.id ,cp.nombre "+
					") s "+
					"GROUP BY s.id ,s.nombre ORDER BY s.nombre asc";
		
		
		
		SqlQuery r = Ebean.createSqlQuery(sql);
		if(fdesde != null){
			r = r.setParameter("fdesde",fdesde);
		}
		r = r.setParameter("estado",estado_id);
		r = r.setParameter("estadopagado",Estado.PAGO_ESTADO_PAGADO);
		r = r.setParameter("estadocancelado",Estado.PAGO_ESTADO_CANCELADO);
		r = r.setParameter("estadoencurso",Estado.PAGO_ESTADO_EN_CURSO);
		r = r.setParameter("estadoconciliado",Estado.PAGO_ESTADO_CONCILIADO);
		
		re = r.findList();
		
		return re;
	}
	
	public static List<SqlRow> getGastosDetallePorCuenta(Date fdesde,Date fhasta,Long estado_id,Long cuenta_id){
		List<SqlRow> re = new ArrayList<SqlRow>();
		String union = "";
		
	 
		String sql = " SELECT sum(debito) as debito,ord.nombre rubro "+
					 " FROM balance_cuentas_propias bcp "+   
					 " INNER JOIN cuentas_propias cp ON cp.id = bcp.cuenta_propia_id "+  
					 " INNER JOIN balance_cuentas_propia_pagos bcpp ON bcpp.balance_cuenta_propia_id = bcp.id "+
					 " INNER JOIN pagos p ON p.id = bcpp.pago_id "+
					 " INNER JOIN facturas f ON f.id = p.factura_id "+
					 " INNER JOIN ordenes o ON o.id = f.orden_id "+
					 " INNER JOIN ordenes_rubros ord ON ord.id = o.orden_rubro_id "+
					 " WHERE 1 = 1 ";  
		if(fhasta != null && fdesde != null){
			/*sql += " AND (( bcp.fecha_debito >= :fdesde AND bcp.fecha_debito <= :fhasta) "+ 
				   " OR (bcp.fecha_emision >= :fdesde AND bcp.fecha_emision <= :fhasta) "+
				   " OR (bcp.fecha_cancelado >= :fdesde AND bcp.fecha_cancelado <= :fhasta) "+
				   " OR (bcp.fecha >= :fdesde AND bcp.fecha <= :fhasta)) ";*/
			sql += " AND ((bcp.fecha_emision >= :fdesde AND bcp.fecha_emision <= :fhasta AND bcp.fecha_cancelado is null) "+
					   " OR (bcp.fecha_cancelado >= :fdesde AND bcp.fecha_cancelado <= :fhasta AND bcp.fecha_cancelado is not null)) ";
		}
					 sql += " AND (bcp.estado_id = :estado or bcp.estado_id = :estadopagado or bcp.estado_id = :estadocancelado or bcp.estado_id = :estadoconciliado or bcp.estado_id = :estadoencurso) "+
					 " AND ((bcp.fecha >= '2019-08-01' and bcp.fecha_debito >= '2019-08-01' AND bcp.fecha_emision >= '2019-08-01' and bcp.fecha_cancelado >= '2019-08-01') or (bcp.id in(16770,16769,16768,16767,16766))) "+		 
					 " AND bcp.cuenta_propia_id = :cuentaId "+
					 " GROUP BY ord.nombre ORDER BY ord.nombre";
		
		
		
		SqlQuery r = Ebean.createSqlQuery(sql);
		if(fhasta != null && fdesde != null){
			r = r.setParameter("fdesde",fdesde);
			r = r.setParameter("fhasta",fhasta);
		}
		r = r.setParameter("estado",estado_id);
		r = r.setParameter("estadopagado",Estado.PAGO_ESTADO_PAGADO);
		r = r.setParameter("estadocancelado",Estado.PAGO_ESTADO_CANCELADO);
		r = r.setParameter("estadoencurso",Estado.PAGO_ESTADO_EN_CURSO);
		r = r.setParameter("estadoconciliado",Estado.PAGO_ESTADO_CONCILIADO);
		r = r.setParameter("cuentaId",cuenta_id); 
		
		re = r.findList();
		
		return re;
	}
	
	public static List<SqlRow> getGastosDetallePorCuentaPorInstitucion(Date fdesde,Date fhasta,Long estado_id,Long cuenta_id){
		List<SqlRow> re = new ArrayList<SqlRow>();
		String union = "";
		
	 
		String sql = " SELECT sum(debito) as debito,ord.nombre rubro "+
					 " FROM balance_cuentas_propias bcp "+   
					 " INNER JOIN cuentas_propias cp ON cp.id = bcp.cuenta_propia_id "+  
					 " INNER JOIN balance_cuentas_propia_pagos bcpp ON bcpp.balance_cuenta_propia_id = bcp.id "+
					 " INNER JOIN pagos p ON p.id = bcpp.pago_id "+
					 " INNER JOIN facturas f ON f.id = p.factura_id "+
					 " INNER JOIN ordenes o ON o.id = f.orden_id "+
					 " INNER JOIN depositos ord ON ord.id = o.deposito_id "+
					 " WHERE 1 = 1 ";  
		if(fhasta != null && fdesde != null){
			/*sql += " AND (( bcp.fecha_debito >= :fdesde AND bcp.fecha_debito <= :fhasta) "+ 
				   " OR (bcp.fecha_emision >= :fdesde AND bcp.fecha_emision <= :fhasta) "+	
				   " OR (bcp.fecha_cancelado >= :fdesde AND bcp.fecha_cancelado <= :fhasta) "+	
				   " OR (bcp.fecha >= :fdesde AND bcp.fecha <= :fhasta AND deposito > 0)) ";*/
			sql += " AND ((bcp.fecha_emision >= :fdesde AND bcp.fecha_emision <= :fhasta AND bcp.fecha_cancelado is null) "+	
					   " OR (bcp.fecha_cancelado >= :fdesde AND bcp.fecha_cancelado <= :fhasta AND bcp.fecha_cancelado is not null)) ";
		}
					 sql += " AND (bcp.estado_id = :estado or bcp.estado_id = :estadopagado or bcp.estado_id = :estadocancelado or bcp.estado_id = :estadoconciliado or bcp.estado_id = :estadoencurso) "+
					 " AND ((bcp.fecha >= '2019-08-01' AND bcp.fecha_debito >= '2019-08-01' AND bcp.fecha_emision >= '2019-08-01' AND bcp.fecha_cancelado >= '2019-08-01') or (bcp.id in(16770,16769,16768,16767,16766))) "+		 
					 " AND bcp.cuenta_propia_id = :cuentaId "+
					 " GROUP BY ord.nombre ORDER BY ord.nombre";
		
		
		
		SqlQuery r = Ebean.createSqlQuery(sql);
		if(fhasta != null && fdesde != null){
			r = r.setParameter("fdesde",fdesde);
			r = r.setParameter("fhasta",fhasta);
		}
		r = r.setParameter("estado",estado_id);
		r = r.setParameter("estadopagado",Estado.PAGO_ESTADO_PAGADO);
		r = r.setParameter("estadocancelado",Estado.PAGO_ESTADO_CANCELADO);
		r = r.setParameter("estadoencurso",Estado.PAGO_ESTADO_EN_CURSO);
		r = r.setParameter("estadoconciliado",Estado.PAGO_ESTADO_CONCILIADO);
		r = r.setParameter("cuentaId",cuenta_id); 
		
		re = r.findList();
		
		return re;
	}
	
	public static BigDecimal getTotalCheques(Long cuentaId,Long estadoId){
		SqlRow re = null;
		String union = "";
		BigDecimal totalRet = new BigDecimal(0);
	 
		String sql = " SELECT  sum(debito) as total, cp.id as id ,cp.nombre as nombre "+
				" FROM balance_cuentas_propias bcp "+
				" INNER JOIN cuentas_propias cp ON cp.id = bcp.cuenta_propia_id "+
				" INNER JOIN balance_cuentas_propia_pagos bcpp ON bcpp.balance_cuenta_propia_id = bcp.id "+
				" INNER JOIN pagos p ON p.id = bcpp.pago_id "+
				" WHERE 1 = 1 "+
				" AND bcp.estado_id = :estadoId "+
				" AND bcp.cuenta_propia_id = :cuentaId "+
				" AND p.tipo_pago = 'cheque' "+
				" GROUP BY cp.id ,cp.nombre limit 1 ";
		
		
		
		SqlQuery r = Ebean.createSqlQuery(sql);
		r = r.setParameter("estadoId",estadoId);
		r = r.setParameter("cuentaId",cuentaId);
		re = r.findUnique();
		
		if(re != null){
			totalRet = re.getBigDecimal("total");
		}
		
		return totalRet;
	}
	
}
