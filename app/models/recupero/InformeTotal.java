package models.recupero;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import models.Cliente;
import models.ClienteTipo;
import models.Deposito;
import models.Expediente;
import models.Periodo;
import models.Remito;
import models.Usuario;
import models.auth.Permiso;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity 
@Table(name = "informe_totales_recupero")
public class InformeTotal extends Model {

	private static final long serialVersionUID = 1L;
	@Id 
	public Long id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente; 
	@Required(message="Debe tener un cliente asociado")
	public Long cliente_id;
	
	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	public Integer periodo_id;
	
	@ManyToOne
	@JoinColumn(name="cliente_tipo_id", referencedColumnName="id", insertable=false, updatable=false)
	public ClienteTipo cliente_tipo;
	public Integer cliente_tipo_id;
	
	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	public Long deposito_id;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Integer expediente_id;
	public String numero;
	public String tipo_cliente;
	public String cliente_nombre;
	public BigDecimal totalLineasFactura;
	public BigDecimal totalFactura;
	public BigDecimal totalNotas;
	public BigDecimal totalPagos; 
	public BigDecimal totalDeuda;
	
	public static Model.Finder<Long,InformeTotal> find = new Model.Finder<Long,InformeTotal>(Long.class, InformeTotal.class);
	
	public static Pagination<InformeTotal> page(String cliente, 
												String periodo, 
												String expediente, 
												String ejercicio,
												String deuda_mayor, 
												String deuda_menor, 
												String pago_mayor, 
												String pago_menor,
												String cliente_tipo_id,
												String fecha_factura_desde,
												String fecha_factura_hasta) {    	
    	Pagination<InformeTotal> p = new Pagination<InformeTotal>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("fecha");
    	
    	ExpressionList<InformeTotal> e = find.fetch("expediente").fetch("periodo").fetch("cliente").where();

    	if(!cliente.isEmpty()) {
    		e.eq("cliente_id", Integer.parseInt(cliente));
    	}
    	
    	if(!cliente_tipo_id.isEmpty()){
    		e.eq("cliente_tipo_id", Integer.parseInt(cliente_tipo_id));
    	}	
    	
    	if(!periodo.isEmpty()) {
    		e.eq("periodo_id", Integer.parseInt(periodo));
    	}
    	
    	if(!expediente.isEmpty()) {
    		e.eq("expediente_id", Integer.parseInt(expediente));
    	}
  
    	if(!ejercicio.isEmpty()) {
    		e.eq("ejercicio", Integer.parseInt(ejercicio));
    	}
    	
    	
    	if(!deuda_mayor.isEmpty()){
    		e.gt("total_deuda", Float.parseFloat(deuda_mayor));
    	}
    	
    	if(!deuda_menor.isEmpty()){
    		e.lt("total_deuda", Float.parseFloat(deuda_menor));
    	}
    	
    	if(!pago_mayor.isEmpty()){
    		e.gt("total_pagos", Float.parseFloat(pago_mayor));
    	}
    	
    	if(!pago_menor.isEmpty()){
    		e.lt("total_pagos", Float.parseFloat(pago_menor));
    	}
    	
    	if(!fecha_factura_desde.isEmpty()){
    		Date ffd = DateUtils.formatDate(fecha_factura_desde, "dd/MM/yyyy");
    		e.ge("fecha", ffd);
    	}
    	
		if(!fecha_factura_hasta.isEmpty()){
    		Date ffh = DateUtils.formatDate(fecha_factura_hasta, "dd/MM/yyyy");
    		e.le("fecha", ffh);
    	}
		
		if(!Permiso.check("verTodoRecupero")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("deposito_id");
    		}
    	}
		
    	p.setExpressionList( e );
    	return p;
    }
	
	public static List<SqlRow> getDeudaPorTipoDeCliente(Long idTipoCliente){
		
		String sql = "SELECT sum(total_factura) total_factura,sum(total_pagos) total_pago,sum(total_deuda) total_deuda," +
				"cliente_id,tipo_cliente,cliente_nombre " +
				"FROM informe_totales_recupero " +
				"WHERE total_deuda > 0 ";
		
		if(idTipoCliente != 0){
			sql += " AND cliente_tipo_id = "+idTipoCliente;
		}
		sql +=" GROUP BY cliente_id,tipo_cliente,cliente_nombre ORDER BY cliente_nombre ";
		
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
} 
