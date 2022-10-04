package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class PagoLineaMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;
		
		try {
			
			System.out.println("Empezo a migrar PagoLineaMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id," +
					" account_id," +
					" account_analytic_id," +
					" amount," +
					" voucher_id," +
					" amount_original," +
					" name," +
					" period_id,"+
					" create_uid," +
					" create_date " +
					" from account_voucher_line ");
			
			
			  

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO pagos_lineas " +
						" (id,cuenta_id,cuenta_analitica_id,monto,pago_id,monto_original,nombre,periodo_id,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?)");
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
				
				if(rs.getLong(5) == 0){
					stmt2.setNull(5,0);
				}else{
					stmt2.setLong(5, rs.getLong(5));
				}
				
				stmt2.setBigDecimal(6, rs.getBigDecimal(6));
				stmt2.setString(7, rs.getString(7));
				if(rs.getLong(8) == 0){
					stmt2.setNull(8,0);
				}else{
					stmt2.setLong(8, rs.getLong(8));
				}
				
				if(rs.getLong(9) == 0 || rs.getLong(9) == 129){
					stmt2.setNull(9,0);
				}else{
					stmt2.setLong(9, rs.getLong(9));
				}
				stmt2.setDate(10, rs.getDate(10));
				
				stmt2.executeUpdate();
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar PagoLineaMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
