package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.Logger;
import server.Configuracion2;

public class ActualizarProductosIps {

	
	
	public void actualizar(){
		
		 
		Connection conn2 = null;

		try {
			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt = conn2.prepareStatement("SELECT id, codigo, nombre, precio  FROM migracion_productos_ips2 ");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			int x = 0;
			Logger.debug("1111111111111111111");
	 		while (rs.next()) {
	 			//Logger.debug("entraaaaaaa");
	 			stmt2 = conn2.prepareStatement("SELECT id FROM productos WHERE codigo_ips = ? ");
	 			//stmt2 = conn2.prepareStatement("SELECT id FROM migracion_productos_ips WHERE codigo = ? ");
	 			stmt2.setString(1,rs.getString(2));
	 			ResultSet rsx = stmt2.executeQuery();
	 			
	 			String ref = "IPS-"+rs.getString(2)+"-03/17";
	 			if(rsx.next()){
	 				PreparedStatement stmtx2 = conn2.prepareStatement("UPDATE productos " +
	 						"SET referencia=?,nombre=?,precio_coste=?,fecha_actualizacion_ips=now() " +
	 						"WHERE id = ?");
	 				
	 				
	 				stmtx2.setString(1,ref);
	 				stmtx2.setString(2,rs.getString(3));
	 				stmtx2.setBigDecimal(3, rs.getBigDecimal(4));
	 				stmtx2.setLong(4, rsx.getLong(1));
	 				stmtx2.executeUpdate(); 
	 				Logger.debug("encontrooo "+rs.getString(2));
	 				 
	 			}else{
	 				PreparedStatement stmtx2 = conn2.prepareStatement("INSERT INTO productos(nombre,referencia,codigo_ips,precio_coste,compra,venta," +
	 						"activo,create_date,categoria_id,tipo_producto_id,articulo_id,udm_id,create_usuario_id,fecha_actualizacion_ips)" +
	 						"VALUES (?, ?, ?, ?, true,true,true,now(),33,2,1537,1,1, now());"); 
	 				stmtx2.setString(1,rs.getString(3));
	 				stmtx2.setString(2,ref);
	 				stmtx2.setString(3,rs.getString(2));
	 				stmtx2.setBigDecimal(4, rs.getBigDecimal(4));
	 				stmtx2.executeUpdate();
	 				Logger.debug("inserto producto "+rs.getString(2));
	 			}
	 			
	 		}
	 		
	 		Logger.debug("2222222222222222");
	 		
		} catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            
        }
	}
}
