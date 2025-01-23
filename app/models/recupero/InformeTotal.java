package models.recupero;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import play.Logger;
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
	public BigDecimal totalNotaDebitos;
	public BigDecimal totalPagos;
	public BigDecimal totalDeuda;
	public String cuit;

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
												String fecha_factura_hasta,
												String deposito) {
    	Pagination<InformeTotal> p = new Pagination<InformeTotal>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("fecha");

    	ExpressionList<InformeTotal> e = find

    			.fetch("deposito","nombre")
    			.fetch("cliente","nombre").where();

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
    	}else {
    		if(!deposito.isEmpty()) {
        		e.eq("deposito_id", Integer.parseInt(deposito));
        	}
    	}

    	p.setExpressionList( e );
    	return p;
    }

	public static Map<Long, Date> getPagoLastDateClienteConDeudaPorTipoDeCliente(Long idTipoCliente){

		String sql = "SELECT max(fecha) as fecha,cliente_id "+
				"FROM recupero_pagos rp "+
				"inner join clientes c on c.id = rp.cliente_id "+
				"WHERE fecha >= '2023-01-01' and  estado_id = 71 AND recupero_nota_credito_id IS NULL AND recupero_nota_debito_id IS NULL ";


		if(idTipoCliente != 0){
			sql += " AND c.cliente_tipo_id = "+idTipoCliente;
		}
		sql +=" GROUP BY cliente_id ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		Map<Long, Date> ret = new HashMap<>();

		for(SqlRow r :row) {
			ret.put(r.getLong("cliente_id"), r.getDate("fecha"));
		}

		return ret;
	}


	public static Map<Long, Integer> getPagoClienteConDeudaPorTipoDeCliente(Long idTipoCliente){

		String sql = "SELECT count(*) as c,cliente_id "+
				"FROM recupero_pagos rp "+
				"inner join clientes c on c.id = rp.cliente_id "+
				"WHERE fecha >= '2023-01-01' and  estado_id = 71 AND recupero_nota_credito_id IS NULL AND recupero_nota_debito_id IS NULL ";


		if(idTipoCliente != 0){
			sql += " AND c.cliente_tipo_id = "+idTipoCliente;
		}
		sql +=" GROUP BY cliente_id ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		Map<Long, Integer> ret = new HashMap<>();

		for(SqlRow r :row) {
			ret.put(r.getLong("cliente_id"), r.getInteger("c"));
		}

		return ret;
	}

	public static List<SqlRow> getDeudaPorTipoDeCliente(Long idTipoCliente,String fecha_desde,String fecha_hasta){

		String sql = "SELECT sum(total_factura) total_factura,sum(total_pagos) total_pago,sum(total_deuda) total_deuda," +
				"cliente_id,tipo_cliente,cliente_nombre,cuit " +
				"FROM informe_totales_recupero " +
				"WHERE total_deuda > 0 ";

		if(idTipoCliente != 0){
			sql += " AND cliente_tipo_id = "+idTipoCliente;
		}

		if(!fecha_desde.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");

    		sql += " AND fecha >=  '"+DateUtils.formatDate(fod, "yyyy-MM-dd")+"' ";
    	}

		if(!fecha_hasta.isEmpty()){
			Logger.debug("xxxxxxxxxxxx "+fecha_hasta);
    		Date foh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");

    		sql += " AND fecha <= '"+DateUtils.formatDate(foh, "yyyy-MM-dd")+"' ";
    	}

		sql +=" GROUP BY cliente_id,tipo_cliente,cliente_nombre,cuit ORDER BY total_deuda desc ";


		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static BigDecimal getDeudaPorIdCliente(Long idCliente,String fecha_desde,String fecha_hasta){

		BigDecimal r = new BigDecimal(0);

		String sql = "SELECT sum(total_deuda) total_deuda," +
				"cliente_id,tipo_cliente,cliente_nombre,cuit " +
				"FROM informe_totales_recupero " +
				"WHERE total_deuda > 0 ";

		if(idCliente != 0){
			sql += " AND cliente_id = "+idCliente;
		}

		if(fecha_desde != null && !fecha_desde.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");

    		sql += " AND fecha >=  '"+DateUtils.formatDate(fod, "yyyy-MM-dd")+"' ";
    	}

		if(fecha_hasta != null && !fecha_hasta.isEmpty()){
			Date foh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		sql += " AND fecha <= '"+DateUtils.formatDate(foh, "yyyy-MM-dd")+"' ";
    	}

		sql +=" GROUP BY cliente_id,tipo_cliente,cliente_nombre,cuit ORDER BY total_deuda desc ";


		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		if(row.size() > 0) {
			r = row.get(0).getBigDecimal("total_deuda");
		}

		return r;
	}

}
