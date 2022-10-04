package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class UsuarioMigracion {
	public boolean migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar UsuarioMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name,ru.login,ru.password,ru.email,ru.active,"+
					" ru.create_date," +
					" ru.write_date " +
					" from res_users ru");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			
			while (rs.next()) {
				System.out.print('1');
				
				stmt3  = conn2.prepareStatement("select id,nombre,nick,password,email,activo,create_date,write_date from usuarios where id = ?");
				stmt3.setLong(1,rs.getLong(1));
				ResultSet rs3 = stmt3.executeQuery();
				if(rs3.next()){
					stmt2 = conn2.prepareStatement("UPDATE usuarios SET " +
												   "nombre=?,nick=?,password=?,email=?,activo=?,create_date=?,write_date=? " +
												   "WHERE id = ? ");
					
					stmt2.setString(1, rs.getString(2));
					stmt2.setString(2, rs.getString(3));
					stmt2.setString(3, rs.getString(4));
					stmt2.setString(4, rs.getString(5));
					stmt2.setBoolean(5, rs.getBoolean(6));
					stmt2.setDate(6, rs.getDate(7));
					stmt2.setDate(7, rs.getDate(8));
					stmt2.setLong(8, rs.getLong(1));
					
					stmt2.executeUpdate();
				}else{
				
					stmt2 = conn2.prepareStatement("INSERT INTO usuarios " +
							" (id,nombre,nick,password,email,activo,create_date,write_date)" +
							" VALUES (?,?,?,?,?,?,?,?)");
					stmt2.setLong(1, rs.getLong(1));
					stmt2.setString(2, rs.getString(2));
					stmt2.setString(3, rs.getString(3));
					stmt2.setString(4, rs.getString(4));
					stmt2.setString(5, rs.getString(5));
					stmt2.setBoolean(6, rs.getBoolean(6));
					stmt2.setDate(7, rs.getDate(7));
					stmt2.setDate(8, rs.getDate(8));
					
					stmt2.executeUpdate();
				}
			
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar UsuarioMigracion");
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
