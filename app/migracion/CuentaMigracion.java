package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class CuentaMigracion {
	
	public boolean migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar CuentaMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name,"+
					" ru.active," +
					" ru.reconcile," +
					" ru.code," +
					" ru.level," +
					" ru.parent_id," +
					" ru.parent_left," +
					" ru.parent_right," +
					" ru.create_uid, " +
					" ru.create_date " +
					" from account_account ru");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO cuentas " +
						" (id,nombre,active,reconcile,code,level,parent_id,parent_left_id,parent_right_id,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?)");
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setString(2, rs.getString(2));
				stmt2.setBoolean(3, rs.getBoolean(3));
				stmt2.setBoolean(4, rs.getBoolean(4));
				stmt2.setString(5, rs.getString(5));
				stmt2.setLong(6, rs.getLong(6));
				stmt2.setLong(7, rs.getLong(7));
				stmt2.setLong(8, rs.getLong(8));
				stmt2.setLong(9, rs.getLong(9));
				stmt2.setLong(10, rs.getLong(10));
				stmt2.setDate(11, rs.getDate(11));
				
				stmt2.executeUpdate();
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar CuentaMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		
		return true;
	}
}
