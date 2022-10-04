package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.auth.Permiso;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.StringUtils;
import utils.pagination.Pagination;
@Entity 
@Table(name = "ordenes_pagos_circuitos")
public class OrdenPagoCircuito extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordenes_pagos_circuitos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;
	@Required(message="Orden Pago requerido")
	public Long orden_pago_id;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Expediente requerido")
	public Long expediente_id;
	
	@ManyToOne
	@JoinColumn(name="expediente_fisico_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expedienteFisico;
	@Required(message="Expediente Fisico requerido")
	public Long expediente_fisico_id;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Proveedor requerido")
	public Long proveedor_id;
	
	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Required(message="estado requerido")
	public Long estado_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_creacion;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_contabilidad;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_rendiciones;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_rendicion;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_pago;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_mayor;	
	
	@ManyToOne
	@JoinColumn(name="cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaPropia cuentaPropia;
	public Integer cuenta_propia_id;
	
	@Formula(select = "_b${ta}.total", join = "left outer join (SELECT oc.id idoc, round(sum(pl.monto),2) AS total FROM ordenes_pagos_circuitos oc INNER JOIN ordenes_pagos_circuitos_lineas ocl ON oc.id = ocl.orden_pago_circuito_id INNER JOIN pagos p ON p.id = ocl.pago_id INNER JOIN pagos_lineas pl ON p.id = pl.pago_id GROUP BY idoc) as _b${ta} on _b${ta}.idoc = ${ta}.id")
	public BigDecimal total;
	
	public static Model.Finder<Long,OrdenPagoCircuito> find = new Model.Finder<Long,OrdenPagoCircuito>(Long.class, OrdenPagoCircuito.class);

	public static Pagination<OrdenPagoCircuito> page(String numero_orden_pago_desde, 
													 String numero_orden_pago_hasta,
													 String expediente,
													 String proveedor,
													 String btnFiltro0,//borrador
													 String btnFiltro1,//contabilidad
													 String btnFiltro2,//rendiciones
													 String btnFiltro3,//rendido
													 String btnFiltro4, //cancelado
													 String fecha_pago_desde, 
													 String fecha_pago_hasta,
													 String fecha_ultima_desde, 
													 String fecha_ultima_hasta,
													 String fecha_conta_desde, 
													 String fecha_conta_hasta,
													 String fecha_rendi_desde, 
													 String fecha_rendi_hasta,
													 String cuenta_propia,
													 String ordenPago
													 ) {    	
    	Pagination<OrdenPagoCircuito> p = new Pagination<OrdenPagoCircuito>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<OrdenPagoCircuito> e = find
    			.fetch("proveedor")
    			.fetch("expediente")
    			.fetch("ordenPago")
    			.fetch("cuentaPropia")
    			.where();
    	
    	if(!cuenta_propia.isEmpty()){
    		e.eq("cuenta_propia_id", Integer.parseInt(cuenta_propia));
    	}
    	
    	if(!fecha_rendi_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_rendi_desde, "dd/MM/yyyy");
    		e.ge("fecha_rendiciones", fpd);
    	}
		if(!fecha_rendi_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_rendi_hasta, "dd/MM/yyyy");
    		e.le("fecha_rendiciones", fph);
    	}
    	
    	if(!fecha_pago_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_pago_desde, "dd/MM/yyyy");
    		e.ge("fecha_pago", fpd);
    	}
		if(!fecha_pago_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_pago_hasta, "dd/MM/yyyy");
    		e.le("fecha_pago", fph);
    	}
		
		if(!fecha_ultima_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_ultima_desde, "dd/MM/yyyy");
    		e.ge("fecha_mayor", fpd);
    	}
		if(!fecha_ultima_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_ultima_hasta, "dd/MM/yyyy");
    		e.le("fecha_mayor", fph);
    	}
		
		if(!fecha_conta_desde.isEmpty()){
    		Date fcd = DateUtils.formatDate(fecha_conta_desde, "dd/MM/yyyy");
    		e.ge("fecha_contabilidad", fcd);
    	}
		if(!fecha_conta_hasta.isEmpty()){
    		Date fch = DateUtils.formatDate(fecha_conta_hasta, "dd/MM/yyyy");
    		e.le("fecha_contabilidad", fch);
    	}
    	
    	if(!numero_orden_pago_desde.isEmpty()){
    		e.ge("ordenPago.numero",Integer.parseInt(numero_orden_pago_desde) );
    	}
		
		if(!numero_orden_pago_hasta.isEmpty()){
    		e.le("ordenPago.numero", Integer.parseInt(numero_orden_pago_hasta));
    	}
		
		if(!ordenPago.isEmpty()){
			e.eq("ordenPago.id", Integer.parseInt(ordenPago));
		}
		
		if(!proveedor.isEmpty()){
    		e.eq("proveedor_id", Integer.parseInt(proveedor));
    	}
		
		if(!expediente.isEmpty()){
			//e.eq("expediente_id", Integer.parseInt(expediente));
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
		    			e = e.in("expediente_id", ePadre2);
		    		}
				e = e.endJunction();
    		}	
		}
    	
    	if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty() || !btnFiltro4.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.ORDEN_PAGO_CIRCUITO_ESTADO_BORRADOR);
			}	
			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CONTABILIDAD);
			}	
			if(!btnFiltro2.isEmpty()){
				 e = e.eq("estado_id", Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDICIONES);
			}	
			if(!btnFiltro3.isEmpty()){
				 e = e.eq("estado_id", Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDIDO);
			}	
			if(!btnFiltro4.isEmpty()){
				 e = e.eq("estado_id", Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CANCELADO);
			}
			
			e = e.endJunction();
		}
    	
    	if(!Permiso.check("verExpedientesGuardiasMonotributo")){
    		e.not(Expr.in("expediente_id", Expediente.EXP_GUARDIA_MONOTRIBUTOS));
		}
    	
    	p.setExpressionList( e );
    	return p;
    }
	
	public static List<Integer>  getIds(List<OrdenPagoCircuito> ocl){
		List<Integer> rl = new ArrayList<Integer>();
		for(OrdenPagoCircuito oc :ocl){
			rl.add(oc.id.intValue());
		}
		return rl;
	}
	
	
	public static List<Integer>  getIdsExpedientes(List<OrdenPagoCircuito> ocl){
		List<Integer> rl = new ArrayList<Integer>();
		List<Integer> idsOc = new ArrayList<Integer>();
		
		idsOc = getIds(ocl);
				
		String sql = "SELECT expediente_id idExpediente,expediente_fisico_id idExpedienteFisico " +
					 "FROM ordenes_pagos_circuitos opc " +
					 "WHERE opc.id in(:idsOc) ";
				
		List<SqlRow> sl = Ebean.createSqlQuery(sql).setParameter("idsOc", idsOc).findList();
				  
		for(SqlRow s :sl){
			Integer idExp;
			if(s.getInteger("idExpedienteFisico") != null){
				idExp = s.getInteger("idExpedienteFisico") ;
			}else{
				Expediente ex = Expediente.find.byId(s.getInteger("idExpediente").longValue());
				if(ex.residuo_pasivo){
					idExp = ex.parent_id.intValue();
				}else{
					idExp = s.getInteger("idExpediente") ;
				}
			}
			
			if(!rl.contains(idExp)){
				rl.add(idExp);
			}
		}
		
		return rl;
	}
	
	public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> opcSeleccionados){
		
		List<String> sqllist = new ArrayList<String>();
		String ahora = new Date().toString();  
		
		if(idEstado.compareTo(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CONTABILIDAD) == 0){
			sqllist.add(" fecha_contabilidad = '"+ahora+"' ");
		}else if(idEstado.compareTo(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDICIONES) == 0){
			sqllist.add(" fecha_rendiciones = '"+ahora+"' ");
		}else if(idEstado.compareTo(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDIDO) == 0){
			sqllist.add(" fecha_rendicion = '"+ahora+"' ");
		}else if(idEstado.compareTo(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CANCELADO) == 0){
			sqllist.add(" fecha_contabilidad = null ");
			sqllist.add(" fecha_rendiciones = null ");
			sqllist.add(" fecha_rendicion =  null ");
		}
		  
		sqllist.add(" estado_id = "+idEstado);  
		
		String parametros = StringUtils.implode(sqllist, ",");
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE ordenes_pagos_circuitos " +
				" SET "+parametros+
				" WHERE id IN (:ids)");
		
		
		update.setParameter("ids", opcSeleccionados);
		
		return update.execute();
	}
	
	public static Integer CargarExpedienteFisico(Integer idExpediente, List<Integer> facturasSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE ordenes_pagos_circuitos " +
				"SET expediente_fisico_id = :idExpediente " +
				"WHERE id IN (:ids)");
		update.setParameter("idExpediente", idExpediente);
		update.setParameter("ids", facturasSeleccionados);
		
		return update.execute();
	}
}
