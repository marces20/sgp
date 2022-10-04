package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class FacturaLineaImpuestoMigracion {
	
	
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar FacturaLineaImpuestoMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id,account_id,invoice_id,amount," +
					" create_uid," +
					" create_date,name " +
					" from account_invoice_tax");
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
														
				stmt2 = conn2.prepareStatement("INSERT INTO factura_linea_impuestos " +
						" (id,cuenta_id,factura_id,monto,create_usuario_id,create_date,nombre)" +
						" VALUES (?,?,?,?,?,?,?)");
				
				stmt2.setLong(1, rs.getLong(1));
				if(rs.getLong(2) == 0){
					stmt2.setNull(2,0);
				}else{
					stmt2.setLong(2, rs.getLong(2));
				}
				if(rs.getLong(3) == 0){
					stmt2.setNull(3,0);
				}else{
					stmt2.setLong(3, rs.getLong(3));
				}
				stmt2.setBigDecimal(4, rs.getBigDecimal(4));
				
				if(rs.getLong(5) == 0 || rs.getLong(5) == 129){
					stmt2.setNull(5,0);
				}else{
					stmt2.setLong(5, rs.getLong(5));
				}
				stmt2.setDate(6, rs.getDate(6));
				stmt2.setString(7, rs.getString(7));  
				stmt2.executeUpdate();
				
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar FacturaLineaImpuestoMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
