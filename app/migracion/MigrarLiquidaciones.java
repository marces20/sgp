package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class MigrarLiquidaciones {
	
	public static void migrar(Long liquidacion_mes_id){
		
		Connection connTest = null;
		Connection connPro = null;
		try {
			
			System.out.println("Empezo a migrar MigrarLiquidaciones");
			
        	connTest = Configuration.get().getConnection();
        	connPro = Configuracion2.get2().getConnection2();
        	
        	
        	PreparedStatement stmt = connTest.prepareStatement("select nro_liq_puesto, puesto_laboral_id, estado_id, comentario, liquidacion_mes_id, organigrama_id, impresiones,id "
        			+ "from liquidacion_puestos where liquidacion_mes_id = ?");
        	stmt.setLong(1, liquidacion_mes_id);		
        	
        	ResultSet rs = stmt.executeQuery();
        	PreparedStatement stmt2 = null;
        	int d = 1;
        	while (rs.next()) {
        		System.out.println("migrando "+rs.getLong(1));
        		PreparedStatement stmtsi = connPro.prepareStatement("SELECT nextval('liquidacion_puestos_id_seq')");
        		ResultSet rssi = stmtsi.executeQuery();
        		if(rssi.next()){
        			int idLiquidacionPuesto = rssi.getInt(1);
	        		stmt2 = connPro.prepareStatement("INSERT INTO liquidacion_puestos( nro_liq_puesto, puesto_laboral_id, estado_id, comentario, "+
	        	            					   "liquidacion_mes_id, organigrama_id, impresiones,id) "+
	        	            					   "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");
	        		
	        		stmt2.setLong(1, rs.getLong(1));
	        		stmt2.setLong(2, rs.getLong(2));
	        		stmt2.setLong(3, rs.getLong(3));
	        		stmt2.setString(4, rs.getString(4));
	        		stmt2.setLong(5, rs.getLong(5));
	        		stmt2.setLong(6, rs.getLong(6));
	        		stmt2.setLong(7, rs.getLong(7));
	        		stmt2.setLong(8, idLiquidacionPuesto);
	        		stmt2.executeUpdate();
	        		
	        		PreparedStatement stmt3 = connTest.prepareStatement("select liquidacion_puesto_id, liquidacion_concepto_id, cantidad,importe, liquidacion_novedad_id "
	        				+ "from liquidacion_detalles where liquidacion_puesto_id = ?");
	        		stmt3.setLong(1, rs.getLong(8));
	        		ResultSet rs3 = stmt3.executeQuery();
	        		
	        		PreparedStatement stmt4 = null;
	        		while (rs3.next()) {
	        			
	        			stmt4= connPro.prepareStatement("INSERT INTO liquidacion_detalles(liquidacion_puesto_id, liquidacion_concepto_id, cantidad,importe, liquidacion_novedad_id) "+
	        					"VALUES (?, ?, ?, ?, ?)");
	        			stmt4.setLong(1, idLiquidacionPuesto);
	        			stmt4.setLong(2,  rs3.getLong(2));
	        			stmt4.setBigDecimal(3,  rs3.getBigDecimal(3));
	        			stmt4.setBigDecimal(4,  rs3.getBigDecimal(4));
	        			stmt4.setLong(5,  0);
	        			stmt4.executeUpdate();
	        		}
	            }  
        	}
        	System.out.println("FIN a migrar MigrarLiquidaciones");
        	
		 } catch (SQLException e) {
	            //log.error("Error ResUserMigracion ", e);
	        	play.Logger.error("errror", e);
        } finally {
        	if (connTest != null) try { connTest.close(); } catch (Exception e) { }
            if (connPro != null) try { connPro.close(); } catch (Exception e) { }
        }
	}	
}
