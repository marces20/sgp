package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class CreditoMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar CreditoMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name," +
					" ru.ejercicio," +
					" ru.expediente_id," +
					" ru.state," +
					" fecha,"+
					" ru.create_date," +
					" ru.create_uid " +
					" from adop_credito ru");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO creditos_presupuestarios " +
						" (id,nombre,ejercicio_id,expediente_id,estado,fecha,create_date,create_usuario_id)" +
						" VALUES (?,?,?,?,?,?,?,?)");
				
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setString(2, rs.getString(2));
				stmt2.setLong(3, rs.getLong(3));
				stmt2.setLong(4, rs.getLong(4));
				stmt2.setString(5, rs.getString(5));
				stmt2.setDate(6, rs.getDate(6));
				stmt2.setDate(7, rs.getDate(7));
				stmt2.setLong(8, rs.getLong(8));
				
				stmt2.executeUpdate();
			
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar CreditoMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
