package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class PeriodoMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar PeriodoMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name," +
					" ru.fiscalyear_id,ru.date_start,ru.date_stop,"+
					" ru.create_uid, " +
					" ru.create_date" +
					" from account_period ru");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			 
			 
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO periodos " +
						" (id,nombre,ejercicio_id,date_start,date_stop,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?)");
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setString(2, rs.getString(2));
				stmt2.setLong(3, rs.getLong(3));
				stmt2.setDate(4, rs.getDate(4));
				stmt2.setDate(5, rs.getDate(5));
				stmt2.setLong(6, rs.getLong(6));
				stmt2.setDate(7, rs.getDate(7));
				
				stmt2.executeUpdate();
			
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar PeriodoMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
