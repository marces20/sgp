package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class CuentaAnaliticasMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar CuentaAnaliticasMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name,"+
					" ru.date_start,"+
					" ru.parent_id,"+
					" ru.tipo_partida,"+
					" ru.carga_credito,"+
					" ru.ejecutable,"+
					" ru.code,"+
					" ru.create_uid, " +
					" ru.create_date " +
					" from account_analytic_account ru where id = 233");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO cuentas_analiticas " +
						" (id,nombre,date_start,parent_id,tipo_partida,carga_credito,ejecutable,codigo,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?)");
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setString(2, rs.getString(2));
				stmt2.setDate(3, rs.getDate(3));
				if(rs.getLong(4) == 0){
					stmt2.setNull(4,0);
				}else{
					stmt2.setLong(4, rs.getLong(4));
				}
				stmt2.setString(5, rs.getString(5));
				stmt2.setBoolean(6, rs.getBoolean(6));
				stmt2.setBoolean(7, rs.getBoolean(7));
				stmt2.setString(8, rs.getString(8));
				stmt2.setLong(9, rs.getLong(9));
				stmt2.setDate(10, rs.getDate(10));
				
				stmt2.executeUpdate();
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			
			System.out.println("Termino a migrar CuentaAnaliticasMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
