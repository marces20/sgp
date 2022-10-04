package models.informes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
					+ "tipo_moneda,cotizacion,cotizacion_dia,total_orden_divisa,total_pago_divisa,total_autorizado_divisa) "  
					
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
					" END AS cotizacion_dia,tp.total_orden_divisa,tp.total_pago_divisa,tp.total_autorizado_divisa	"
					+ "FROM informe_estadistico_deuda_proveedores_matrializada v "
					+ "INNER JOIN totales_por_orden tp on tp.orden_id = v.orden_id ");
			stmt.executeUpdate();
			
			
			stmt2 = conn.prepareStatement("INSERT INTO historial_deuda_actas(fecha,orden_id, id_fake, id_acta, certificacion_id, total_acta, "
					+ "total_pagado,total_deuda, total_deuda_limite, total_autorizado,acta_numero)" + 
					"SELECT now (),orden_id,id_fake,id,certificacion_id,total_acta,total_pagado,total_deuda,total_deuda_limite,total_autorizado,acta_numero "
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
		 		"( " + 
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
				"where hd.total_deuda > 1 and hd.fecha = :fecha ";
		
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
				   " (  " +
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
}
