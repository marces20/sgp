package models.informes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import models.CertificacionCompra;
import models.Deposito;
import models.Ejercicio;
import models.Expediente;
import models.Orden;
import models.OrdenProvision;
import models.OrdenRubro;
import models.Periodo;
import models.Proveedor;
import models.TipoCuenta;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.RequestVar;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

@Entity 
@Table(name = "informe_deuda_actas_materializada")
public class InformeDeudaPorActaMaterializada extends Model{
	private static final long serialVersionUID = 1L;
	
	@Id
	public String id_fake;
	
	public Long id;
	
	public String acta_numero;
	
	public String periodo;
	
	@ManyToOne
	@JoinColumn(name="orden_provision_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenProvision ordenProvision;
	public Long orden_provision_id;
	
	@ManyToOne
	@JoinColumn(name="certificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public CertificacionCompra certificacionCompra;
	public Long certificacion_id;
	
	
	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden ordenCompra;
	public Long orden_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;
	
	public Boolean es_dolar;

	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	public Long proveedor_id;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Long expediente_id;
	
	@ManyToOne
	@JoinColumn(name="ejercicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Ejercicio ejercicio;
	public Long ejercicio_id;

	@ManyToOne
	@JoinColumn(name="rubro_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenRubro ordenRubro;
	public Long rubro_id;
	
	public BigDecimal totalActa;
	public BigDecimal totalDeuda;
	public BigDecimal totalPagado;
	public BigDecimal totalAutorizado;
	public BigDecimal totalDeudaLimite;
	public Boolean profe;
	
	@ManyToOne
	@JoinColumn(name="tipo_cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoCuenta tipoCuenta;
	public Long tipo_cuenta_id;
	
	public Boolean perimido;
	
	public static Model.Finder<Long,InformeDeudaPorActaMaterializada> find = new Finder<Long,InformeDeudaPorActaMaterializada>(Long.class, InformeDeudaPorActaMaterializada.class);
	
	
	public static Pagination<InformeDeudaPorActaMaterializada> page(String acta_numero, 
													   String orden_provision, 
													   String proveedor_id, 
													   String expediente_id, 
													   String ejercicio_id, 
													   String deuda_mayor, 
													   String deuda_menor,
													   String profe,
													   boolean autorizado,
													   String dolar,
													   String deposito_id,
													   String tipo_acta,
													   String tipo_cuenta_id,
													   String tipo_moneda,
													   String emergencia) {    	
    	Pagination<InformeDeudaPorActaMaterializada> p = new Pagination<InformeDeudaPorActaMaterializada>();
    	p.setOrderDefault("asc");
    	p.setSortByDefault("fecha,id");
    	
    	ExpressionList<InformeDeudaPorActaMaterializada> e = find
    			.fetch("proveedor", "nombre")
    			.fetch("expediente")
    			.fetch("ordenCompra")
    			.fetch("ordenCompra.deposito")
    			.fetch("expediente.ejercicio")
    			.fetch("ordenProvision", "numero, orden_compra_id")
    			.where();
    	
		if(!emergencia.isEmpty()){
    		if(emergencia.compareToIgnoreCase("SI") ==0){
    			e.eq("expediente.emergencia", true);
    		}else{
    			e.eq("expediente.emergencia", false);
    		}
    	}	
    	
    	
    	if(autorizado) {
    		e.raw("(totalDeuda > 0.01)");   	
    		

    		e.having().add(Expr.raw("( monto_adelanto - COALESCE(sum(round(al.monto,2)),0) > 0 "));
    		//e.raw("( having ( monto_adelanto - COALESCE(sum(round(al.monto,2)),0) > 0 )  )");
    		
    	}
    	    	
    	if(!tipo_moneda.isEmpty()){
    		e.eq("ordenCompra.tipo_moneda", Integer.parseInt(tipo_moneda));
    	} 	

    	
    	/*if(!profe.isEmpty()){
    		e.eq("profe", new Boolean(profe));
    	}*/
    	
    	if(!tipo_cuenta_id.isEmpty()){
    		e.eq("tipo_cuenta_id", Integer.parseInt(tipo_cuenta_id));
    	}
    	
    	if(!profe.isEmpty()){
    		if(profe.equals("operativa")) {
    			e.eq("profe", false);
    		} else if (profe.equals("profe")) {
    			e.eq("profe", true);
    		}else{
    			Boolean b = new Boolean(profe);
    			if(b){
    				e.eq("profe", true);
    			}else{
    				e.eq("profe", false);
    			}
    		}
    	}
    	
    	
		if(!tipo_acta.isEmpty()){
			if(tipo_acta.equals("Anticipo")) {
				e.eq("acta_numero", "Anticipo");
			}else if(tipo_acta.equals("acta")) {
	    		e.ne("acta_numero", "CC");      	
	    	} else if(tipo_acta.equals("CC")) {
	    		e.eq("acta_numero", "CC");
	    	}
    	}
    	
    	
    	
    	if(!orden_provision.isEmpty()){
    		e.eq("orden_provision", Integer.parseInt(orden_provision));
    	}
    	
    	if(!acta_numero.isEmpty()){
    		e.eq("acta_numero", acta_numero);
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
    	
    	if(!ejercicio_id.isEmpty()){
    		e.eq("ejercicio_id", Integer.parseInt(ejercicio_id));
    	}
    	
    	if(!deuda_mayor.isEmpty()){
    		e.gt("total_deuda", Float.parseFloat(deuda_mayor));
    	}
    	
    	if(!deuda_menor.isEmpty()){
    		e.lt("total_deuda", Float.parseFloat(deuda_menor));
    	}
    	
    	if(!dolar.isEmpty()){
    		e.eq("es_dolar", true);
    	}
    	
    	if(!deposito_id.isEmpty()){
    		e.eq("ordenCompra.deposito_id", Integer.parseInt(deposito_id));
    	}
		//e = e.disjunction();
		e.not(Expr.raw("(acta_numero = 'Anticipo' AND total_deuda < 0)"));

    	
    	
    	
    	p.setExpressionList(e);
    	return p;
    }
	
	public static Map<String,Map<String,List<List<SqlRow>>>> getListaFinalDeudasDetallesReporte(Integer idProveedor,Boolean equipamiento,Integer idCuenta,boolean sinServicio){
		
		List<Integer> listaProveedores = new ArrayList<Integer>();
		boolean noDestacados = false;
		if(idProveedor.compareTo(-1) == 0){
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
		}else if (idProveedor.compareTo(-2) == 0){
			listaProveedores.add(2050);
			listaProveedores.add(1430);
			listaProveedores.add(3045);
			listaProveedores.add(2176);
			listaProveedores.add(7348);
			listaProveedores.add(1589);
			listaProveedores.add(1530);
			listaProveedores.add(15156);
			listaProveedores.add(4359);
			listaProveedores.add(2749);
			//listaProveedores.add(1498);
			listaProveedores.add(14106);
			listaProveedores.add(14441);
			listaProveedores.add(14971);
			listaProveedores.add(16359);
			listaProveedores.add(14733);
			noDestacados = true;
		}else if (idProveedor != 0) {
			listaProveedores.add(idProveedor);
		}
		
		Map<String,Map<String,List<List<SqlRow>>>> listaFinal = new HashMap<String, Map<String,List<List<SqlRow>>>>();
		Map<String,List<List<SqlRow>>> mapProveedores = new HashMap<String, List<List<SqlRow>>>();
		
		if(idCuenta != null) {
			TipoCuenta tc = TipoCuenta.find.byId(idCuenta.longValue());
			//OPERTATIVAAAA
			List<List<SqlRow>> listadoSqlRow = new ArrayList<List<SqlRow>>();
			 
				List<SqlRow> proveedorOperativa = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadDetalles(listaProveedores,false,equipamiento,noDestacados,idCuenta,sinServicio);
				if(proveedorOperativa.size() > 0){
					listadoSqlRow.add(proveedorOperativa);
				}
			 
			if(listadoSqlRow.size() > 0){ 
				mapProveedores.put("HEARM", listadoSqlRow);
				listaFinal.put(tc.nombre, mapProveedores);
			}
		}else {
			//OPERTATIVAAAA
			List<List<SqlRow>> listadoSqlRow = new ArrayList<List<SqlRow>>();
			 
				List<SqlRow> proveedorOperativa = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadDetalles(listaProveedores,false,equipamiento,noDestacados,idCuenta,sinServicio);
				if(proveedorOperativa.size() > 0){
					listadoSqlRow.add(proveedorOperativa);
				}
			 
			if(listadoSqlRow.size() > 0){ 
				mapProveedores.put("HEARM", listadoSqlRow);
				listaFinal.put("OPERATIVA", mapProveedores);
			}
			
			//PROFEEEEEE
			mapProveedores = new HashMap<String, List<List<SqlRow>>>();
			
			listadoSqlRow = new ArrayList<List<SqlRow>>();
			 
				List<SqlRow> proveedorProfe = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadDetalles(listaProveedores,true,equipamiento,noDestacados,idCuenta,sinServicio);
				if(proveedorProfe.size() > 0){
					listadoSqlRow.add(proveedorProfe);
				}
				
	
			if(listadoSqlRow.size() > 0){ 		
				mapProveedores.put("HEARM", listadoSqlRow);
				listaFinal.put("PROFE", mapProveedores);
			}
		}	
		return listaFinal;
	}
	
	
	
	
	public static List<SqlRow> getDeudaPorProveedorPorAntiguedadDetalles(List<Integer> idProoveedor,boolean profe,Boolean equipamiento,boolean noDestacados,Integer idCuenta,boolean sinServicio){
		
		String sql = "SELECT  e.nombre||'/'||ej.nombre expediente,i.fecha fecha,TO_CHAR(i.fecha, 'MM/YYYY') fecha_mes_ano, " + 
				" e.descripcion descripcion, i.proveedor_id proveedorId,p.nombre nombre_proveedor,od.nombre rubro,d.sigla deposito, " + 
				" CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda " +
				" FROM informe_deuda_actas_materializada i " + 	 
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +  
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +  
				" INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id " +
				" INNER JOIN ordenes o ON o.id = i.orden_id " +
				" INNER JOIN ordenes_rubros od ON od.id = o.orden_rubro_id "+
				" INNER JOIN depositos d ON d.id = o.deposito_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 ) ";
		
		
		
		if(idCuenta != null ) {
			sql += " AND i.rubro_id <> 8 ";
			sql += " AND i.tipo_cuenta_id = "+idCuenta;
		}else {	
			if(sinServicio) {
				sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8 ";
			}else {
				//sql += " AND i.rubro_id <> 8 ";
			}
			if(profe){
				sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
			}else{
				sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
			}
		}
		if(equipamiento != null && equipamiento){
			if(equipamiento){
				sql += " AND i.rubro_id = 1 ";
			}else{
				sql += " AND i.rubro_id <> 1 ";
			}
		}
		 
		
		if(idProoveedor != null && idProoveedor.size() > 0){
			if(noDestacados){
				sql += " AND p.id not in (:idProoveedor)";
			}else{
				sql += " AND p.id in (:idProoveedor)";
			}
			
		}
		
		sql += " GROUP BY e.nombre,ej.nombre,i.fecha,e.descripcion,i.proveedor_id,p.nombre,od.nombre,d.sigla "+
			   " ORDER BY i.fecha,p.nombre ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		if(idProoveedor != null && idProoveedor.size() > 0){
			sqlQuery.setParameter("idProoveedor", idProoveedor);
		}
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static Map<String,Map<String,List<List<SqlRow>>>> getListaFinalDeudasResumenPeriodoReporte(Integer idProveedor,Boolean equipamiento,Integer idCuenta,boolean sinServicio){
		
		List<Integer> listaProveedores = new ArrayList<Integer>();
		boolean noDestacados = false;
		if(idProveedor.compareTo(-1) == 0){
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
		}else if (idProveedor.compareTo(-2) == 0){
			listaProveedores.add(2050);
			listaProveedores.add(1430);
			listaProveedores.add(3045);
			listaProveedores.add(2176);
			listaProveedores.add(7348);
			listaProveedores.add(1589);
			listaProveedores.add(1530);
			listaProveedores.add(15156);
			listaProveedores.add(4359);
			listaProveedores.add(2749);
			//listaProveedores.add(1498);
			listaProveedores.add(14106);
			listaProveedores.add(14441);
			listaProveedores.add(14971);
			listaProveedores.add(16359);
			listaProveedores.add(14733);
			noDestacados = true;
		}else if (idProveedor != 0) {
			listaProveedores.add(idProveedor);
		}
		
		Map<String,Map<String,List<List<SqlRow>>>> listaFinal = new HashMap<String, Map<String,List<List<SqlRow>>>>();
		Map<String,List<List<SqlRow>>> mapProveedores = new HashMap<String, List<List<SqlRow>>>();
		
		
		//OPERTATIVAAAA
		List<List<SqlRow>> listadoSqlRow = new ArrayList<List<SqlRow>>();
		 
		List<SqlRow> proveedorOperativa = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadPeriodoReporte(listaProveedores,false,equipamiento,noDestacados,idCuenta,sinServicio);
		if(proveedorOperativa.size() > 0){
			listadoSqlRow.add(proveedorOperativa);
		}
		 
		if(listadoSqlRow.size() > 0){ 
			mapProveedores.put("HEARM", listadoSqlRow);
			listaFinal.put("OPERATIVA", mapProveedores);
		}
			
			 
		 	
		return listaFinal;
	}
	
	public static List<SqlRow> getDeudaPorProveedorPorAntiguedadPeriodoReporte(List<Integer> idProoveedor,boolean profe,Boolean equipamiento,boolean noDestacados,Integer idCuenta,boolean sinServicio){
		
		String sql = "SELECT  pe.id,pe.nombre fecha_mes_ano, " + 
				" CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda " +
				" FROM informe_deuda_actas_materializada i " + 	 
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +  
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +  
				" INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id " +
				" INNER JOIN ordenes o ON o.id = i.orden_id " +
				" INNER JOIN ordenes_rubros od ON od.id = o.orden_rubro_id "+
				" INNER JOIN depositos d ON d.id = o.deposito_id " +
				" INNER JOIN periodos pe on pe.nombre = TO_CHAR(i.fecha, 'MM/YYYY') "+
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 ) ";
		
		
		
		if(idCuenta != null ) {
			sql += " AND i.rubro_id <> 8 ";
			sql += " AND i.tipo_cuenta_id = "+idCuenta;
		}else {	
			if(sinServicio) {
				sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8 ";
			}else {
				//sql += " AND i.rubro_id <> 8 ";
			}
			if(profe){
				sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
			}else{
				sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
			}
		}
		if(equipamiento != null && equipamiento){
			if(equipamiento){
				sql += " AND i.rubro_id = 1 ";
			}else{
				sql += " AND i.rubro_id <> 1 ";
			}
		}
		 
		
		if(idProoveedor != null && idProoveedor.size() > 0){
			if(noDestacados){
				sql += " AND p.id not in (:idProoveedor)";
			}else{
				sql += " AND p.id in (:idProoveedor)";
			}
			
		}
		
		sql += " GROUP BY  pe.id,pe.nombre "+
			   " ORDER BY pe.id ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		if(idProoveedor != null && idProoveedor.size() > 0){
			sqlQuery.setParameter("idProoveedor", idProoveedor);
		}
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static Map<String,List<List<SqlRow>>> getListaFinalDeudasResumenMensualReporte(Integer idProveedor,boolean equipamiento){
		
		
		Map<String,List<List<SqlRow>>> mapProveedores = new HashMap<String, List<List<SqlRow>>>();
		
		//OPERTATIVAAAA
		List<List<SqlRow>> listadoSqlRow = new ArrayList<List<SqlRow>>();
		 
			List<SqlRow> proveedorOperativa = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadResumenMensual(false,false);
			if(proveedorOperativa.size() > 0){
				listadoSqlRow.add(proveedorOperativa);
			}
		 
		 
		mapProveedores.put("OPERATIVA", listadoSqlRow); 
		
		//PROFEEEEEE
		mapProveedores = new HashMap<String, List<List<SqlRow>>>();
		listadoSqlRow = new ArrayList<List<SqlRow>>();
		 
			List<SqlRow> proveedorProfe = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadResumenMensual(true,false);
			if(proveedorProfe.size() > 0){
				listadoSqlRow.add(proveedorProfe);
			}
	 
		mapProveedores.put("PROFE", listadoSqlRow); 
		
		return mapProveedores;
	}
	
	public static List<SqlRow> getDeudaPorProveedorPorPeriodoPorAntiguedadResumenMensual(boolean profe,boolean servicios,Boolean deposito){
		
		String sql = "SELECT  p.nombre fecha_mes_ano,p.id as periodo_id,e.nombre ejercicio,p.mes as mes, " + 
				" CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda " +
				" FROM informe_deuda_actas_materializada i " + 	
				" INNER JOIN ordenes o on o.id = i.orden_id "+
				" INNER JOIN periodos p on p.nombre = i.periodo "+
				" INNER JOIN ejercicios e ON e.id = p.ejercicio_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 ) ";
		
		if(deposito != null){
			if(deposito){
				sql += " AND o.deposito_id = 1 ";
			}else{
				sql += " AND o.deposito_id <> 1 ";
			}
		}
		
		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}
		
		
		if(servicios){
			sql += " AND i.rubro_id = 7 ";
		}else{
			sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8 ";
		}
		
		  
		sql += " GROUP BY p.nombre,p.id,e.nombre "+
			   " ORDER BY p.id ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		 
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getDeudaResumenPorAntiguedadResumenMensual(boolean proveedoresDestacados,boolean profe,Integer deposito,boolean ra,boolean servicios,boolean equipamiento,boolean honorarios){
		
		String sql = "SELECT  p.nombre as nombre_proveedor,p.id as proveedor_id, " + 
				" CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda " +
				" FROM informe_deuda_actas_materializada i " + 	 
				" INNER JOIN proveedores p on p.id = i.proveedor_id "+
				" INNER JOIN ordenes o ON o.id = i.orden_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 ) ";
		
		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}
		
		if(deposito == null || deposito == -1){
			sql += " AND o.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND o.deposito_id = "+deposito;
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
		
		  
		sql += " GROUP BY p.nombre,p.id "+
			   " ORDER BY p.id ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getDeudaPorProveedorPorAntiguedadResumenMensual(boolean profe,boolean servicios){
		
		String sql = "SELECT  p.nombre fecha_mes_ano,p.id as periodo_id,e.nombre ejercicio,p.mes as mes, " + 
				" CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda " +
				" FROM informe_deuda_actas_materializada i " + 	 
				" INNER JOIN periodos p on p.nombre = TO_CHAR(i.fecha, 'MM/YYYY') "+
				" INNER JOIN ejercicios e ON e.id = p.ejercicio_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 ) ";
		
		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}
		
		if(servicios){
			sql += " AND i.rubro_id = 7 ";
		}else{
			sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8 ";
		}
		
		  
		sql += " GROUP BY p.nombre,p.id,e.nombre "+
			   " ORDER BY p.id ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		 
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static Map<String,List<SqlRow>> getListaFinalDeudasDetallesInstitucionReporte(){
		
		Map<String,List<SqlRow>> listaFinal = new HashMap<String, List<SqlRow>>();
		
		//OPERTATIVAAAA
		List<SqlRow> operativa = InformeDeudaPorActaMaterializada.getDeudaPorInstitucionPorAntiguedadDetalles(false);
		listaFinal.put("OPERATIVA", operativa);
		
		//PROFEEEEEE
		List<SqlRow> profe = InformeDeudaPorActaMaterializada.getDeudaPorInstitucionPorAntiguedadDetalles(true);
		listaFinal.put("PROFE", profe);
		
		return listaFinal;
	}
	
	public static List<SqlRow> getListaFinalDeudasDetallesCuentaReporte(Integer idCuenta){
		
		String sql = "SELECT  e.nombre||'/'||ej.nombre expediente,i.fecha fecha,TO_CHAR(i.fecha, 'MM/YYYY') fecha_mes_ano, " + 
				" e.descripcion descripcion,od.nombre rubro,d.sigla deposito,i.proveedor_id proveedorId,p.nombre nombre_proveedor,tc.nombre cuenta, " + 
				" CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda " +
				" FROM informe_deuda_actas_materializada i " + 	 
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +  
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +  
				" INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id " +
				" INNER JOIN ordenes o ON o.id = i.orden_id " +
				" INNER JOIN ordenes_rubros od ON od.id = o.orden_rubro_id "+
				" INNER JOIN depositos d ON d.id = o.deposito_id " +
				" INNER JOIN tipo_cuenta tc ON tc.id = i.tipo_cuenta_id "+
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 ) ";
		
		if(idCuenta.compareTo(2) == 0){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else if(idCuenta.compareTo(1) == 0){
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}else {
			sql += " AND i.tipo_cuenta_id = "+idCuenta;
		}
		
		sql += " AND i.rubro_id <> 8 ";
		
		sql += " GROUP BY e.nombre,ej.nombre,i.fecha,e.descripcion,od.nombre,d.sigla,tc.nombre,i.proveedor_id,p.nombre "+
			   " ORDER BY i.fecha ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getDeudaPorInstitucionPorAntiguedadDetalles(boolean profe){
		
		String sql = "SELECT  e.nombre||'/'||ej.nombre expediente,i.fecha fecha,TO_CHAR(i.fecha, 'MM/YYYY') fecha_mes_ano, " + 
				" e.descripcion descripcion,od.nombre rubro,d.sigla deposito,i.proveedor_id proveedorId,p.nombre nombre_proveedor, " + 
				" CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda " +
				" FROM informe_deuda_actas_materializada i " + 	 
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +  
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +  
				" INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id " +
				" INNER JOIN ordenes o ON o.id = i.orden_id " +
				" INNER JOIN ordenes_rubros od ON od.id = o.orden_rubro_id "+
				" INNER JOIN depositos d ON d.id = o.deposito_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 ) ";
		
		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}
		
		sql += " AND i.rubro_id <> 8 ";
		
		sql += " GROUP BY e.nombre,ej.nombre,i.fecha,e.descripcion,od.nombre,d.sigla,i.proveedor_id,p.nombre "+
			   " ORDER BY d.sigla,i.fecha ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	
	public static List<SqlRow> getDeudaPorInstitucionPorAntiguedadResumen(Boolean profe){
		
		String sql = "SELECT  TO_CHAR(i.fecha, 'MM/YYYY') fecha_mes_ano,d.sigla deposito,p.id, "+ 
				" CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda "+  
				" FROM informe_deuda_actas_materializada i "+  	 
				" INNER JOIN ordenes o ON o.id = i.orden_id "+ 
				" INNER JOIN depositos d ON d.id = o.deposito_id "+
				" INNER JOIN periodos p on p.nombre = TO_CHAR(i.fecha, 'MM/YYYY') "+  
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 ) ";
		
		if(profe != null){
			if(profe){
				sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
			}else{
				sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
			}
		}
		
		
		sql += " AND i.rubro_id <> 8 ";
		
		sql += " GROUP BY fecha_mes_ano,d.sigla,p.id  "+
			   " ORDER BY p.id,d.sigla ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getDeudaPorInstitucionPorAntiguedadPorEjercicioResumen(Boolean profe){
		
		String sql = "SELECT  TO_CHAR(i.fecha, 'YYYY') fecha_ano,d.sigla deposito, "+ 
				" CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda "+  
				" FROM informe_deuda_actas_materializada i "+  	 
				" INNER JOIN ordenes o ON o.id = i.orden_id "+ 
				" INNER JOIN depositos d ON d.id = o.deposito_id "+
				" INNER JOIN periodos p on p.nombre = TO_CHAR(i.fecha, 'MM/YYYY') "+  
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 )  ";
		
		if(profe != null){
			if(profe){
				sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
			}else{
				sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
			}
		}
		
		
		sql += " AND i.rubro_id <> 8 ";
		
		sql += " GROUP BY fecha_ano,d.sigla  "+
			   " ORDER BY d.sigla ASC";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getDeudaServiciosPorPeriodoPorAntiguedadResumenMensual(boolean profe,boolean servicios,Boolean deposito){
		
		String sql = "SELECT i.orden_provision_id orden_provision_id, "+
					 "i.expediente_id expediente_id,e.fecha fechaExpediente, "+ 
					 "e.descripcion descripcion, i.proveedor_id proveedorId,pr.nombre nombre_proveedor,i.rubro_id rubroId,d.sigla deposito, "+
					 "(e.nombre::text || '/'::text) || ej.nombre::text AS expediente,"+
					 "CASE WHEN coalesce(SUM(total_deuda),0) > 0 THEN coalesce(SUM(total_deuda),0) ELSE 0 END total_deuda "+
					 "FROM informe_deuda_actas_materializada i  "+
					 "INNER JOIN ordenes o on o.id = i.orden_id "+  
					 "INNER JOIN periodos p on p.nombre = i.periodo "+ 
					 "INNER JOIN expedientes e ON e.id = i.expediente_id "+
					 "INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id "+
					 "INNER JOIN proveedores pr ON pr.id = i.proveedor_id "+ 
					 "INNER JOIN depositos d ON d.id = o.deposito_id   " +
					 " WHERE i.perimido = false AND (i.total_deuda > 0.01 ) ";
		
		if(deposito != null){
			if(deposito){
				sql += " AND o.deposito_id = 1 ";
			}else{
				sql += " AND o.deposito_id <> 1 ";
			}
		}
		 
		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}
		
		if(servicios){
			sql += " AND i.rubro_id = 7 ";
		}else{
			sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8 ";
		}
		
		  
		sql += " GROUP BY i.orden_provision_id,i.expediente_id,e.fecha,e.descripcion,e.nombre, ej.nombre,i.proveedor_id,pr.nombre,i.rubro_id,d.sigla "+
			   " ORDER BY  pr.nombre,e.fecha ASC ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		 
		
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static void actualizarVistaMaterializada () {
		
		//Ebean.createSqlUpdate("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada").execute();
		Connection conn = play.db.DB.getConnection();
		try {
		    Statement stmt = conn.createStatement();
		    stmt.execute("REFRESH MATERIALIZED VIEW informe_deuda_actas_materializada;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
