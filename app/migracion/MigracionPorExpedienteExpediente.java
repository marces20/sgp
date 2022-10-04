package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class MigracionPorExpedienteExpediente {
	
	public boolean migrar(Long idExpediente){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar ExpedienteMigracion");
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	 
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name,"+
					" ru.create_uid," +
					" ru.create_date,ru.cerrar,ru.activo,ru.state,ejercicio_id,ru.descripcion,ru.requisition, " +
					" ru.iniciador_id,ru.ejercicio_original_id,ru.residuo_pasivo" +
					" from adop_expediente ru where id = ?");
			stmt.setLong(1,idExpediente);
			
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			
			while (rs.next()) {
				
				stmt3 = conn2.prepareStatement("SELECT * from expedientes WHERE id = ?");
				stmt3.setLong(1,rs.getLong(1));
				
				ResultSet rs3 = stmt3.executeQuery();
				
				if (rs3.next()) {
					stmt2 = conn2.prepareStatement("UPDATE expedientes SET " +
							" nombre = ?,create_usuario_id = ?,create_date = ?,cerrar = ?,activo = ?,estado = ?," +
							" ejercicio_id = ?,descripcion = ?,requisition = ?," +
							" iniciador_id = ?,ejercicio_original_id = ?,residuo_pasivo = ? " +
							" WHERE id = ?");
					
					stmt2.setString(1, rs.getString(2));
					stmt2.setLong(2, rs.getLong(3));
					stmt2.setDate(3, rs.getDate(4));
					stmt2.setBoolean(4, rs.getBoolean(5));
					stmt2.setBoolean(5, rs.getBoolean(6));
					stmt2.setString(6, rs.getString(7));
					stmt2.setLong(7, rs.getLong(8));
					stmt2.setString(8, rs.getString(9));
					stmt2.setBoolean(9, rs.getBoolean(10));
					
					if(rs.getLong(11) == 0){
						stmt2.setNull(10,0);
					}else{
						stmt2.setLong(10, rs.getLong(11));
					}
					if(rs.getLong(12) == 0){
						stmt2.setNull(11,0);
					}else{
						stmt2.setLong(11, rs.getLong(12));
					}
					
					stmt2.setBoolean(12, rs.getBoolean(13));
					stmt2.setLong(13, rs.getLong(1));
					stmt2.executeUpdate();
				}else{
				
					stmt2 = conn2.prepareStatement("INSERT INTO expedientes " +
							" (id,nombre,create_usuario_id,create_date,cerrar,activo,estado,ejercicio_id,descripcion,requisition," +
							"iniciador_id,ejercicio_original_id,residuo_pasivo)" +
							" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt2.setLong(1, rs.getLong(1));
					stmt2.setString(2, rs.getString(2));
					stmt2.setLong(3, rs.getLong(3));
					stmt2.setDate(4, rs.getDate(4));
					stmt2.setBoolean(5, rs.getBoolean(5));
					stmt2.setBoolean(6, rs.getBoolean(6));
					stmt2.setString(7, rs.getString(7));
					stmt2.setLong(8, rs.getLong(8));
					stmt2.setString(9, rs.getString(9));
					stmt2.setBoolean(10, rs.getBoolean(10));
					
					if(rs.getLong(11) == 0){
						stmt2.setNull(11,0);
					}else{
						stmt2.setLong(11, rs.getLong(11));
					}
					if(rs.getLong(12) == 0){
						stmt2.setNull(12,0);
					}else{
						stmt2.setLong(12, rs.getLong(12));
					}
					
					stmt2.setBoolean(13, rs.getBoolean(13));
					
					stmt2.executeUpdate();
				}
			
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar ExpedienteMigracion");
        } catch (SQLException e) {
            play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		
		return true;
	}	
}
