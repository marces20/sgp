package models.informes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import models.ActaRecepcion;
import models.Deposito;
import models.Expediente;
import models.Orden;
import models.OrdenProvision;
import models.Periodo;
import models.Proveedor;
import models.TipoCuenta;
import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

@Entity 
@Table(name = "informe_estadistico_deuda_proveedores")
public class InformeEstadisticoDeudaProveedores extends Model{
	private static final long serialVersionUID = 1L;
	
	@Id
	public Integer id;
	
	public Long orden_id;
	public Long orden_provision_id;
	
	@OneToOne
	@JoinColumn(name="orden_provision_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenProvision ordenProvision;
	
	public Integer numero_orden_provision;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Requiere un proveedor")
	public Long proveedor_id;
	
	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	public Long deposito_id;

	public Integer tipo_moneda;
	
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expedienteObj;
	public Long expediente_id;
	
	public Long ejercicio_id;
	public Long rubro_id;
	public String rubro;
	public String ano;
	public Boolean profe;
	
	@ManyToOne
	@JoinColumn(name="tipo_cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoCuenta tipoCuenta;
	public Long tipo_cuenta_id;
	
	public BigDecimal monto_adelanto;
	
	public BigDecimal totalOrden;
	public BigDecimal totalDeuda;
	public BigDecimal totalPagado;
	public BigDecimal totalActas;
	public BigDecimal totalActasSinAdelanto;
	public BigDecimal totalDeudaEnTramite;
	public BigDecimal totalCompromiso;
	public BigDecimal totalAutorizado;
	public BigDecimal cotizacion;
	public String moneda;
	
	public String expediente;
	public String nombreProveedor;
	
	public Boolean perimido;
	
	public static Model.Finder<Long,InformeEstadisticoDeudaProveedores> find = new Finder<Long,InformeEstadisticoDeudaProveedores>(Long.class, InformeEstadisticoDeudaProveedores.class);
	
	public static Pagination<InformeEstadisticoDeudaProveedores> page(String orden, 
																	  String proveedor_id, 
																	  String expediente_id, 
																	  String ejercicio_id, 
																	  String rubro_id, 
																	  String deuda_mayor, 
																	  String deuda_menor, 
																	  String pago_mayor, 
																	  String pago_menor, 
																	  String compromiso_mayor, 
																	  String compromiso_menor,
																	  String cuenta,
																	  String deposito_id,
																	  boolean autorizado,
																	  String tipo_moneda,
																	  String tipo_cuenta_id,
																	  String acta_sin_adelanto_menor_pago,
																	  String monto_adelanto,
																	  String perimido) {    	
    	Pagination<InformeEstadisticoDeudaProveedores> p = new Pagination<InformeEstadisticoDeudaProveedores>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("expediente, numero_orden_provision");
    	
    	ExpressionList<InformeEstadisticoDeudaProveedores> e = find
    			.fetch("ordenProvision", "orden_compra_id")
    			.fetch("expedienteObj")
    			.fetch("deposito")
    			.where();
    	
    	boolean peri = false;
    	
    	if(!perimido.isEmpty()){
    		if(perimido.compareToIgnoreCase("SI") ==0){
    			peri = true;
    		}
    	}
    	
    	e.eq("perimido", peri);
    	
    	if(!acta_sin_adelanto_menor_pago.isEmpty()){
    		e.raw("(totalActasSinAdelanto < totalPagado)");
    		e.isNotNull("numero_orden_provision");
    	}
    	
    	if(autorizado) {
    		e.raw("(totalAutorizado < totalDeuda + totalPagado)");
    	}
    	
    	if(!tipo_cuenta_id.isEmpty()){
    		e.eq("tipo_cuenta_id", Integer.parseInt(tipo_cuenta_id));
    	}
    	
    	if(!orden.isEmpty()){
    		e.eq("numero_orden_provision", Integer.parseInt(orden));
    	}
    	
    	if(!proveedor_id.isEmpty()){
    		if(proveedor_id.compareTo("14947") == 0) {
				e.in("proveedor_id", Proveedor.getProveedoresDestacadosRA());
			}else {
				e.eq("proveedor_id", Integer.parseInt(proveedor_id));
			}
    	}
    	
    	if(!expediente_id.isEmpty()){
    		e.eq("expediente_id", Integer.parseInt(expediente_id));
    	}
    	
    	if(!deposito_id.isEmpty()){
    		e.eq("deposito_id", Integer.parseInt(deposito_id));
    	}
    	
    	if(!cuenta.isEmpty()){
    		if(cuenta.equals("operativa")) {
    			e.eq("profe", false);
    		} else if (cuenta.equals("profe")) {
    			e.eq("profe", true);
    		}else{
    			Boolean b = new Boolean(cuenta);
    			if(b){
    				e.eq("profe", true);
    			}else{
    				e.eq("profe", false);
    			}
    		}
    		
    		
    		
    	}
    	
    	if(!ejercicio_id.isEmpty()){
    		e.eq("ejercicio_id", Integer.parseInt(ejercicio_id));
    	}
    	
    	if(!rubro_id.isEmpty()){
    		e.eq("rubro_id", Integer.parseInt(rubro_id));
    	}
    	
    	if(!deuda_mayor.isEmpty()){
    		e.gt("total_deuda", Float.parseFloat(deuda_mayor));
    	}
    	
    	if(!deuda_menor.isEmpty()){
    		e.lt("total_deuda", Float.parseFloat(deuda_menor));
    	}
    	
    	if(!compromiso_mayor.isEmpty()){
    		e.gt("total_compromiso", Float.parseFloat(compromiso_mayor));
    	}
    	
    	if(!compromiso_menor.isEmpty()){
    		e.lt("total_compromiso", Float.parseFloat(compromiso_menor));
    	}
    	
    	if(!tipo_moneda.isEmpty()){
    		e.eq("tipo_moneda", Integer.parseInt(tipo_moneda));
    	}
    	
    	if(!monto_adelanto.isEmpty()){
    		e.isNotNull("monto_adelanto");
    		e.gt("monto_adelanto", 0);
    	}
    	
    	
    	//e.isNotNull("cot_dolar");
    	
    	
    	p.setExpressionList(e);
    	return p;
    }
	
	public BigDecimal getRestoAAutorizar() {
		return totalOrden.subtract(totalAutorizado);
	}
	
	public static List<SqlRow> getDeudaPorProveedorAgrupados(boolean proveedoresDestacados,boolean profe,Integer deposito,boolean ra,boolean servicios,boolean equipamiento,boolean honorarios){
		
		String sql = "SELECT i.proveedor_id proveedor_id,i.nombre_proveedor nombre_proveedor," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";
		
		 
		
		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}
		
		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}
		
		if(servicios){
			sql += " AND i.rubro_id = 7 ";
		}else if(honorarios){
			sql += " AND i.rubro_id = 8 ";
		}else if(equipamiento){
			sql += " AND i.rubro_id = 1 ";
		}else{
			if(ra || proveedoresDestacados){
				sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8 ";
			}else{
				sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 1 AND i.rubro_id <> 8 ";
			}
			
		}
		
		if(ra){
			sql += " AND p.id IN (2050,1430,3045,2176,14106,14441,14971,16359) ";
		}else{
			if(proveedoresDestacados){
				sql += " AND p.id IN (select proveedor_id from proveedores_destacados) ";
			}else{
				sql += " AND  p.id NOT IN (select proveedor_id from proveedores_destacados) ";
			}
		}
		
		sql += " GROUP BY i.proveedor_id,i.nombre_proveedor ORDER BY total_deuda DESC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static List<SqlRow> getDeudaPorProveedorDetallesOtros(boolean profe,Long deposito,boolean equipamiento){
		
		String sql = "SELECT i.numero_orden_provision numeroProvision, i.expediente expediente,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro_id rubroId,i.rubro rubro," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";
		
		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}
		
		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}
		
		if(equipamiento){
			sql += " AND i.rubro_id = 1";
		}else{
			sql += " AND i.rubro_id <> 1";
		}
		sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8 ";
		
		sql += " AND  p.id NOT IN (select proveedor_id from proveedores_destacados) ";
		
		
		sql += " GROUP BY i.numero_orden_provision, i.expediente,e.fecha,e.descripcion,i.proveedor_id,i.nombre_proveedor,i.rubro_id,i.rubro " +
			   " ORDER BY i.nombre_proveedor,e.fecha, i.numero_orden_provision  ASC ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static List<SqlRow> getDeudaPorProveedorDetalles(Integer idProoveedor,boolean profe,Long deposito){
		
		String sql = "SELECT i.numero_orden_provision numeroProvision, i.expediente expediente,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro rubro," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";
		
		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}
		
		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}
		
		if(idProoveedor != null){
			sql += " AND p.id = "+idProoveedor;
		}
		
		sql += " GROUP BY i.numero_orden_provision, i.expediente,e.fecha,e.descripcion,i.proveedor_id,i.nombre_proveedor,i.rubro " +
				"ORDER BY i.nombre_proveedor,e.fecha ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getDeudaPorProveedorDetallesServicios(Long deposito,boolean todos){
		
		String sql = "SELECT i.numero_orden_provision numeroProvision,i.orden_provision_id orden_provision_id,i.expediente expediente," +
				" i.expediente_id expediente_id,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro_id rubroId,i.rubro rubro,d.nombre deposito, " +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" INNER JOIN ordenes o ON o.id = i.orden_id " +
				" INNER JOIN depositos d ON d.id = o.deposito_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";
		
		if(!todos){
			if(deposito == null || deposito == -1){
				sql += " AND i.deposito_id <> 1";
			}else if(deposito != 0){
				sql += " AND i.deposito_id = "+deposito;
			}
		}
		sql += " AND i.rubro_id =7 ";
		
		sql += " GROUP BY i.numero_orden_provision,i.orden_provision_id, i.expediente,i.expediente_id,e.fecha,e.descripcion,i.proveedor_id," +
				" i.nombre_proveedor,i.rubro_id,i.rubro,d.nombre  " +
			   " ORDER BY i.nombre_proveedor,e.fecha, i.numero_orden_provision  ASC ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static List<SqlRow> getDeudaPorProveedorDetallesHonorarios(Long deposito){
		
		String sql = "SELECT i.numero_orden_provision numeroProvision, i.expediente expediente,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro_id rubroId,i.rubro rubro," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";
		
		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}
		
		sql += " AND i.rubro_id =8";
		
		
		//sql += " AND  p.id NOT IN (select proveedor_id from proveedores_destacados) ";
		
		
		sql += " GROUP BY i.numero_orden_provision, i.expediente,e.fecha,e.descripcion,i.proveedor_id,i.nombre_proveedor,i.rubro_id,i.rubro " +
			   " ORDER BY i.nombre_proveedor,e.fecha, i.numero_orden_provision  ASC ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static List<SqlRow> getDeudaPorCuenta(Integer idCuenta,Long deposito){
		
		String sql = "SELECT i.numero_orden_provision numeroProvision, i.expediente expediente,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro_id rubroId,i.rubro rubro," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";
		
		 
		sql += " AND i.tipo_cuenta_id = "+idCuenta;
		sql += " AND i.rubro_id <> 8 ";
		
		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}
	
		
		sql += " GROUP BY i.numero_orden_provision, i.expediente,e.fecha,e.descripcion,i.proveedor_id,i.nombre_proveedor,i.rubro_id,i.rubro " +
			   " ORDER BY i.nombre_proveedor,e.fecha, i.numero_orden_provision  ASC ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static Map<String,Map<String,Map<Integer,List<SqlRow>>>> getListaFinalDeudasDetallesReporte(Integer idProveedor,boolean ra){
		
		List<Integer> listaProveedores = new ArrayList<Integer>();
		if(ra){
			listaProveedores.add(2050);
			listaProveedores.add(1430);
			listaProveedores.add(3045);
			listaProveedores.add(2176);
			listaProveedores.add(14106);
			listaProveedores.add(14441);
			listaProveedores.add(14971);
			listaProveedores.add(16359);
			
		}else if(idProveedor.compareTo(1589) == 0){
			listaProveedores.add(7348);
			listaProveedores.add(idProveedor);
		}else{
			listaProveedores.add(idProveedor);
		}
		
		Map<String,Map<String,Map<Integer,List<SqlRow>>>> listaFinal = new HashMap<String, Map<String,Map<Integer,List<SqlRow>>>>();
		Map<String,Map<Integer,List<SqlRow>>> mapProveedores = new HashMap<String, Map<Integer,List<SqlRow>>>();
		
		Map<Integer,List<SqlRow>> listadoSqlRow = new HashMap<Integer, List<SqlRow>>();
		for(Integer idPro : listaProveedores){
			List<SqlRow> proveedorOperativa = InformeEstadisticoDeudaProveedores.getDeudaPorProveedorDetalles(idPro,false,(long)Deposito.HEARM);
			listadoSqlRow.put(idPro, proveedorOperativa);
		}
		 
		
		
		mapProveedores.put("HEARM", listadoSqlRow);
		
		listadoSqlRow = new HashMap<Integer, List<SqlRow>>();
		for(Integer idPro : listaProveedores){
			List<SqlRow> proveedorOperativaOtraInstitucion = InformeEstadisticoDeudaProveedores.getDeudaPorProveedorDetalles(idPro,false,null);
			listadoSqlRow.put(idPro, proveedorOperativaOtraInstitucion);
		}
		
		mapProveedores.put("OTRAS INSTITUCIONES", listadoSqlRow);
		listaFinal.put("OPERATIVA", mapProveedores);
		mapProveedores = new HashMap<String, Map<Integer,List<SqlRow>>>();
		
		listadoSqlRow = new HashMap<Integer, List<SqlRow>>();
		for(Integer idPro : listaProveedores){
			List<SqlRow> proveedorProfe = InformeEstadisticoDeudaProveedores.getDeudaPorProveedorDetalles(idPro,true,(long)Deposito.HEARM);
			listadoSqlRow.put(idPro, proveedorProfe);
		}
		
		mapProveedores.put("HEARM", listadoSqlRow);
		
		listadoSqlRow = new HashMap<Integer, List<SqlRow>>();
		for(Integer idPro : listaProveedores){
			List<SqlRow> proveedorProfeOtraInstitucion = InformeEstadisticoDeudaProveedores.getDeudaPorProveedorDetalles(idPro,true,null);
			listadoSqlRow.put(idPro, proveedorProfeOtraInstitucion);
		}
		
		mapProveedores.put("OTRAS INSTITUCIONES", listadoSqlRow);
		listaFinal.put("PROFE", mapProveedores);
		
		return listaFinal;
	}
}
