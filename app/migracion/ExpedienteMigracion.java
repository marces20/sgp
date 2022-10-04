package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class ExpedienteMigracion {
	
	public boolean migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar ExpedienteMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name,"+
					" ru.create_uid," +
					" ru.create_date,ru.cerrar,ru.activo,ru.state,ejercicio_id,ru.descripcion,ru.requisition, " +
					" ru.iniciador_id,ru.ejercicio_original_id,ru.residuo_pasivo" +
					" from adop_expediente ru  where ru.id = 2258");
			
			/*
			 delete from expedientes where id not in (
1605,1606,1607,1608,1609,1610,1612,1613,
1614,1616,1617,1618,1619,1620,1621,1622,
1623,1625,1626,1627,1628,1644,1665,1828,
1829,5181,5182,5201,5202,5221,5222,5241,
5261,5262,5263,5281,5282,5301,5302,5303,
5321,1708
) 
			  
			 
			 */
			  
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			
			while (rs.next()) {
				System.out.print('1');
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
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		
		return true;
	}
}
