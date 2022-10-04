package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class PagoMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar PagoMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id," +
					" reference," +
					" period_id," +
					" narration," +
					" date," +
					" partner_id," +
					" name," +
					" amount," +
					" state," +
					" type," +
					" expediente_id," +
					" paguese_a," +
					" profe," +
					" orden_pago_manual," +
					" medio_pago,"+
					" create_uid," +
					" create_date " +
					" from account_voucher ");
			 
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO pagos " +
						" (id," +
						" referencia," +
						" periodo_id," +
						" nota," +
						" fecha_pago," +
						" proveedor_id," +
						" nombre," +
						" monto," +
						" estado," +
						" tipo," +
						" expediente_id," +
						" paguese_a," +
						" profe," +
						" orden_pago," +
						" medio_pago," +
						" create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
				 
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setString(2, rs.getString(2));
				if(rs.getLong(3) == 0){
					stmt2.setNull(3,0);
				}else{
					stmt2.setLong(3, rs.getLong(3));
				}
				
				stmt2.setString(4, rs.getString(4));
				stmt2.setDate(5, rs.getDate(5));
				if(rs.getLong(6) == 0){
					stmt2.setNull(6,0);
				}else{
					stmt2.setLong(6, rs.getLong(6));
				}
				stmt2.setString(7, rs.getString(7));
				stmt2.setBigDecimal(8, rs.getBigDecimal(8));
				stmt2.setString(9, rs.getString(9));
				stmt2.setString(10, rs.getString(10));
				if(rs.getLong(11) == 0){
					stmt2.setNull(11,0);
				}else{
					stmt2.setLong(11, rs.getLong(11));
				}
				stmt2.setString(12, rs.getString(12));
				stmt2.setBoolean(13, rs.getBoolean(13));
				stmt2.setInt(14, rs.getInt(14));
				stmt2.setString(15, rs.getString(15));
				if(rs.getLong(16) == 0 || rs.getLong(16) == 129){
					stmt2.setNull(16,0);
				}else{
					stmt2.setLong(16, rs.getLong(16));
				}
				stmt2.setDate(17, rs.getDate(17));
				
				stmt2.executeUpdate();
				
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar PagoMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
