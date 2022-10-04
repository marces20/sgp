package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class LineaCreditoMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar LineaCreditoMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name," +
					" ru.credito_id," +
					" ru.monto," +
					" ru.cuenta_analitica_id,"+
					" ru.create_date," +
					" ru.create_uid " +
					" from adop_linea_gasto ru");
			
			
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				if(rs.getLong(3) != 0){
					System.out.print('1');
					stmt2 = conn2.prepareStatement("INSERT INTO lineas_creditos_presupuestarios " +
							" (id,nombre,credito_presupuestario_id," +
							" monto,cuenta_analitica_id,create_date,create_usuario_id)" +
							" VALUES (?,?,?,?,?,?,?)");
					stmt2.setLong(1, rs.getLong(1));
					stmt2.setString(2, rs.getString(2));
					stmt2.setLong(3, rs.getLong(3));
					stmt2.setBigDecimal(4, rs.getBigDecimal(4));
					stmt2.setLong(5, rs.getLong(5));
					stmt2.setDate(6, rs.getDate(6));
					stmt2.setLong(7, rs.getLong(7));
					stmt2.executeUpdate();
				}
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar LineaCreditoMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
