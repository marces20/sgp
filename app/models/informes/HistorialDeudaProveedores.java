package models.informes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Calendar; 



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import play.Logger;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import server.Configuracion2;
import server.Configuration;

@Entity 
@Table(name = "historial_deuda_proveedores")
public class HistorialDeudaProveedores extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="historial_deuda_proveedores_id_seq")
	public Long id;
	
	public Date fecha; 
	
	public Long orden_id;
	
	public BigDecimal monto_adelanto;
	public BigDecimal total_orden;
	public BigDecimal total_pagado;
	public BigDecimal total_autorizado;
	public BigDecimal total_recepcionado;
	public BigDecimal total_actas_sin_adelanto;
	public BigDecimal total_deuda_en_tramite;
	public BigDecimal total_actas;
	public BigDecimal total_deuda;
	public BigDecimal total_compromiso;
	public Long tipo_moneda ;
	public Boolean perimido ;
	
	public static Model.Finder<Long,HistorialDeudaProveedores> find = new Finder<Long,HistorialDeudaProveedores>(Long.class, HistorialDeudaProveedores.class);
	
	public static boolean insertHistorialDeuda() throws EmailException {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		
		try {
			 
			
			
			conn = play.db.DB.getConnection();
			stmt = conn.prepareStatement("INSERT INTO historial_deuda_proveedores(fecha, orden_id, monto_adelanto, total_orden, total_pagado, "
					+ "total_autorizado, total_recepcionado, total_actas_sin_adelanto, total_deuda_en_tramite,total_actas, total_deuda, total_compromiso, "
					+ "tipo_moneda,cotizacion,cotizacion_dia,total_orden_divisa,total_pago_divisa,total_autorizado_divisa,perimido) "  
					
					+ "SELECT now(),v.orden_id, v.monto_adelanto, v.total_orden, v.total_pagado, v.total_autorizado, v.total_recepcionado, v.total_actas_sin_adelanto, "
					+ "v.total_deuda_en_tramite, v.total_actas, v.total_deuda, v.total_compromiso, tipo_moneda,cotizacion, "
					+ "CASE " + 
					" WHEN cotizacion IS NOT NULL " + 
					" THEN  " + 
					"	(SELECT ultimas_cotizaciones.cotizacion " + 
					"        FROM ultimas_cotizaciones " + 
					"        WHERE ultimas_cotizaciones.tipo_moneda = v.tipo_moneda " + 
					"        ORDER BY ultimas_cotizaciones.fecha DESC " + 
					"        LIMIT 1) " + 
					" ELSE  " + 
					"	null " + 
					" END AS cotizacion_dia,tp.total_orden_divisa,tp.total_pago_divisa,tp.total_autorizado_divisa,v.perimido	"
					+ "FROM informe_estadistico_deuda_proveedores_matrializada v "
					+ "INNER JOIN totales_por_orden tp on tp.orden_id = v.orden_id ");
			stmt.executeUpdate();
			
			
			stmt2 = conn.prepareStatement("INSERT INTO historial_deuda_actas(fecha,orden_id, id_fake, id_acta, certificacion_id, total_acta, "
					+ "total_pagado,total_deuda, total_deuda_limite, total_autorizado,acta_numero,perimido)" + 
					"SELECT now (),orden_id,id_fake,id,certificacion_id,total_acta,total_pagado,total_deuda,total_deuda_limite,total_autorizado,acta_numero,perimido "
					+ "FROM  informe_deuda_actas_materializada ");
			stmt2.executeUpdate();
			
			 
			
			
			
			
		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (stmt2 != null) try { stmt2.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		return true;
	}
	
	public static boolean insertHistorialDeudaUpdate(String fecha) throws EmailException {
		Connection conn = null;
		Connection conn2 = null;
		PreparedStatement stmt0 = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs0 = null;
		ResultSet rs = null;
		PreparedStatement stmt3 = null;
		PreparedStatement stmt4 = null;
		ResultSet rs3 = null;
		
		
		try {
			conn = Configuracion2.get2().getConnection2();
			conn2 = Configuration.get().getConnection(); 
			
			
			stmt0= conn2.prepareStatement("SELECT "
					+ "tp.total_autorizado_divisa,"
					+ "v.orden_id, "
					+ "v.monto_adelanto, "
					+ "v.total_orden, "
					+ "v.total_pagado, "
					
					+ "v.total_autorizado, "
					+ "v.total_recepcionado, "
					+ "v.total_actas_sin_adelanto, "
					+ "v.total_deuda_en_tramite, "
					+ "v.total_actas, "
					
					+ "v.total_deuda, "
					+ "v.total_compromiso, "
					+ "tipo_moneda,"
					+ "cotizacion, "
					+ "CASE " + 
					" WHEN cotizacion IS NOT NULL " + 
					" THEN  " + 
					"	(SELECT ultimas_cotizaciones.cotizacion " + 
					"        FROM ultimas_cotizaciones " + 
					"        WHERE ultimas_cotizaciones.tipo_moneda = v.tipo_moneda " + 
					"        ORDER BY ultimas_cotizaciones.fecha DESC " + 
					"        LIMIT 1) " + 
					" ELSE  " + 
					"	null " + 
					" END AS cotizacion_dia,"
					
					+ "tp.total_orden_divisa,"
					+ "tp.total_pago_divisa	"
					+ "FROM informe_estadistico_deuda_proveedores_matrializada v "
					+ "INNER JOIN totales_por_orden tp on tp.orden_id = v.orden_id ");
			
			rs0 = stmt0.executeQuery();
			int a = 1;
			while (rs0.next()) {
				 //play.db.DB.getConnection();
				
				stmt = conn.prepareStatement("INSERT INTO historial_deuda_proveedores("
						+ "total_autorizado_divisa, "
						+ "orden_id, "
						+ "monto_adelanto, "
						+ "total_orden, "
						+ "total_pagado, "
						
						+ "total_autorizado, "
						+ "total_recepcionado, "
						+ "total_actas_sin_adelanto,"
						+ " total_deuda_en_tramite,"
						+ "total_actas, "
						
						+ "total_deuda, "
						+ "total_compromiso, "
						+ "tipo_moneda,"
						+ "cotizacion,"
						+ "cotizacion_dia,"
						
						+ "total_orden_divisa,"
						+ "total_pago_divisa,"
						+ "fecha) "  
						// total_deuda, total_compromiso, tipo_moneda, cotizacion, cotizacion_dia, total_orden_divisa, total_pago_divisa, total_autorizado_divisa)
						+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '"+fecha+"')");
				
				Calendar myCal = Calendar.getInstance();
				myCal.set(Calendar.YEAR, 2022);
				myCal.set(Calendar.MONTH, 6);
				myCal.set(Calendar.DAY_OF_MONTH, 1);
				Date theDate = myCal.getTime();
				
				
				
				stmt.setBigDecimal(1, rs0.getBigDecimal(1));//total_autorizado_divisa
				stmt.setInt(2, rs0.getInt(2));//orden_id
				stmt.setBigDecimal(3, rs0.getBigDecimal(3));//monto_adelanto
				stmt.setBigDecimal(4, rs0.getBigDecimal(4));//total_orden
				stmt.setBigDecimal(5, rs0.getBigDecimal(5));//total_pagado
				
				stmt.setBigDecimal(6, rs0.getBigDecimal(6));//total_autorizado
				stmt.setBigDecimal(7, rs0.getBigDecimal(7));//total_recepcionado
				stmt.setBigDecimal(8, rs0.getBigDecimal(8));//total_actas_sin_adelanto
				stmt.setBigDecimal(9, rs0.getBigDecimal(9));//total_deuda_en_tramite
				stmt.setBigDecimal(10, rs0.getBigDecimal(10));//total_actas
				
				stmt.setBigDecimal(11, rs0.getBigDecimal(11));//total_deuda
				stmt.setBigDecimal(12, rs0.getBigDecimal(12));//total_compromiso
				stmt.setInt(13, rs0.getInt(13));//tipo_moneda
				stmt.setBigDecimal(14, rs0.getBigDecimal(14));//cotizacion
				stmt.setBigDecimal(15, rs0.getBigDecimal(15));//cotizacion_dia
				
				stmt.setBigDecimal(16, rs0.getBigDecimal(16));//total_orden_divisa
				stmt.setBigDecimal(17, rs0.getBigDecimal(17));//total_pago_divisa
								
				
				stmt.executeUpdate();
				System.out.println("zzzzzzzzzzzzzzz "+a);
				a++;
				 
			}
			
			System.out.println("fiiiiiiiiiin");
			
			
			
			
			
			 
			
			
			
			
		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (stmt2 != null) try { stmt2.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
            if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
        }
		
		 
		return true;
	}
	
	public static boolean insertHistorialDeudaUpdateActa(String fecha) throws EmailException {
		Connection conn = null;
		Connection conn2 = null;
		
		PreparedStatement stmt3 = null;
		PreparedStatement stmt4 = null;
		ResultSet rs3 = null;
		
		try {
			conn2 = Configuracion2.get2().getConnection2();
			conn = Configuration.get().getConnection(); 
			
			stmt3 = conn2.prepareStatement("SELECT orden_id,id_fake,id,certificacion_id,total_acta,"
											+ "total_pagado,total_deuda,total_deuda_limite,total_autorizado,acta_numero "
							+ "FROM  informe_deuda_actas_materializada ");
			
			
			rs3 = stmt3.executeQuery();
			int a = 1;
			while (rs3.next()) {
				stmt4 = conn.prepareStatement("INSERT INTO historial_deuda_actas(fecha,orden_id, id_fake, id_acta, certificacion_id, "
						+ "total_acta, total_pagado,total_deuda, total_deuda_limite, total_autorizado,acta_numero) " 
						+ "VALUES ('2022-06-01', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				stmt4.setInt(1, rs3.getInt(1));//orden_id
				stmt4.setString(2, rs3.getString(2));//id_fake
				stmt4.setInt(3, rs3.getInt(3));//id_acta
				stmt4.setInt(4, rs3.getInt(4));//certificacion_id
				stmt4.setBigDecimal(5, rs3.getBigDecimal(5));//total_acta
				
				stmt4.setBigDecimal(6, rs3.getBigDecimal(6));//total_pagado
				stmt4.setBigDecimal(7, rs3.getBigDecimal(7));//total_deuda
				stmt4.setBigDecimal(8, rs3.getBigDecimal(8));//total_deuda_limite
				stmt4.setBigDecimal(9, rs3.getBigDecimal(9));//total_autorizado
				stmt4.setString(10, rs3.getString(10));//acta_numero
				
				System.out.println("zzFFFFFFFFFFFFFF "+a);
				stmt4.executeUpdate();
				a++;
			
			}
			System.out.println("fiiiiiiiiiin2222222");
			
		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	 
        	if (stmt3 != null) try { stmt3.close(); } catch (Exception e) { }
        	if (stmt4 != null) try { stmt4.close(); } catch (Exception e) { }
        	if (rs3 != null) try { rs3.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
            if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            
        }
		
		return true;
	}
	
	public static List<SqlRow> getTotalesPorCorteFecha(boolean totales,Date fecha,boolean equipamiento){
		
		String sql = "select  ";
				if(!totales) {
					sql += "vd.proveedor_id proveedorId,vd.nombre_proveedor nombre_proveedor, ";
				} 
		
				 
		 sql += "CASE WHEN  " + 
		 		"coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) > 0  " + 
		 		"THEN coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) ELSE 0 END total_deuda,  " + 
		 		"( " + 
		 		"CASE WHEN  " + 
		 		"coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) > 0  " + 
		 		"THEN coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) ELSE 0 END " + 
		 		"-  " + 
		 		"( coalesce(SUM(oec.total),0) +  " + 
		 		"CASE WHEN  " + 
		 		"coalesce(SUM(CASE WHEN vd.total_pagado > 0 THEN vd.total_pagado ELSE 0 END),0) > 0 " + 
		 		"THEN coalesce(SUM(CASE WHEN vd.total_pagado > 0 THEN vd.total_pagado ELSE 0 END),0) ELSE 0 END  " + 
		 		"- " + 
		 		"CASE WHEN  " + 
		 		"coalesce(SUM(CASE WHEN hd.total_pagado > 0 THEN hd.total_pagado ELSE 0 END),0) > 0   " + 
		 		"THEN coalesce(SUM(CASE WHEN hd.total_pagado > 0 THEN hd.total_pagado ELSE 0 END),0) ELSE 0 END   " + 
		 		") " + 
		 		") as total " + 
				 
				"from historial_deuda_proveedores hd " + 
				"inner join informe_estadistico_deuda_proveedores_matrializada vd on hd.orden_id = vd.orden_id " + 
				"inner join proveedores p on p.id = vd.proveedor_id " + 
				"LEFT JOIN ( SELECT ordenes_ejercicio_concluido.orden_id, " + 
			    "       sum(round(ordenes_ejercicio_concluido.total , 2)) AS total " + 
			    "       FROM ordenes_ejercicio_concluido " + 
			    "       GROUP BY ordenes_ejercicio_concluido.orden_id) oec ON oec.orden_id = hd.orden_id " + 
				"where hd.perimido <> true and vd.perimido <> true and hd.total_deuda > 1 and hd.fecha = :fecha ";
		
			if(equipamiento) {
				sql += "AND vd.rubro_id = 1 ";
			}else {
				sql +="AND vd.rubro_id <> 1 ";
			}
			
			sql +=	"AND vd.rubro_id <> 7 AND vd.rubro_id <> 8 " + 
					"AND p.id NOT IN (select proveedor_id from proveedores_destacados) ";
			
			if(!totales) {
				sql += " GROUP BY vd.proveedor_id,vd.nombre_proveedor ";
			} 	
			
			sql += " HAVING " + 
				   " ( " +
				   " CASE WHEN " +
				   " coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) > 0 " +
				   " THEN coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) ELSE 0 END " +
				   " - " +
				   " (  + " +
				   " CASE WHEN " + 
				   " coalesce(SUM(CASE WHEN vd.total_pagado > 0 THEN vd.total_pagado ELSE 0 END),0) > 0 " +  
				   " THEN coalesce(SUM(CASE WHEN vd.total_pagado > 0 THEN vd.total_pagado ELSE 0 END),0) ELSE 0 END " +
				   " - " +
				   " CASE WHEN " +
				   " coalesce(SUM(CASE WHEN hd.total_pagado > 0 THEN hd.total_pagado ELSE 0 END),0) > 0 " +
				   " THEN coalesce(SUM(CASE WHEN hd.total_pagado > 0 THEN hd.total_pagado ELSE 0 END),0) ELSE 0 END " +  
				   " )) > 0 ";
			
			if(!totales) {
				sql += "ORDER BY total_deuda DESC ,vd.nombre_proveedor  ASC";
			} 
					
		
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql).setParameter("fecha", fecha);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getTotalesPorCorteFechaNuevo(boolean totales,Date fecha,boolean equipamiento,boolean hoy){
		
		String sql = "select  ";
				//if(!totales) {
		//	sql += "vd.proveedor_id proveedorId,vd.nombre_proveedor nombre_proveedor, ";
		//		} 
		
				 
		 sql += "CASE WHEN  " + 
		 		"coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) > 0  " + 
		 		"THEN coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) ELSE 0 END total_deuda  ";
		 if(!hoy) {
			 sql +=  "from historial_deuda_proveedores hd ";
		 }else {
			 sql +=  "from informe_estadistico_deuda_proveedores_matrializada hd ";
		 }
		 
		sql +=  "inner join ordenes o on o.id = hd.orden_id " + 
		 		"inner join proveedores p on p.id = o.proveedor_id " + 
				"where hd.perimido <> true and hd.total_deuda > 1 ";
			
		   	if(!hoy) {
				sql +=  "and hd.fecha = :fecha ";
			}
		 	  
		
			if(equipamiento) {
				sql += "AND o.orden_rubro_id = 1 ";
			}else {
				sql +="AND o.orden_rubro_id <> 1 ";
			}
			
			sql +=	"AND o.orden_rubro_id <> 7 AND o.orden_rubro_id <> 8 AND o.tipo_cuenta_id = 1 " + 
					"AND p.id NOT IN (select proveedor_id from proveedores_destacados) ";
			
			//if(!totales) {
			//	sql += " GROUP BY vd.proveedor_id,vd.nombre_proveedor ";
			//} 	
			
			sql += " HAVING " + 
				   " ( " +
				   " CASE WHEN " +
				   " coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) > 0 " +
				   " THEN coalesce(SUM(CASE WHEN hd.total_deuda > 0 THEN hd.total_deuda ELSE 0 END),0) ELSE 0 END " +
				   " ) > 0 ";
			
			if(!totales) {
			//	sql += "ORDER BY total_deuda DESC ,vd.nombre_proveedor  ASC";
			} 
					
		
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql).setParameter("fecha", fecha);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
}
