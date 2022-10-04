package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;

public class RecuperoFacturasMigracion {
	
	public void migrar(){
		
	 
		Connection conn2 = null;

		try {
			
			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt = conn2.prepareStatement("SELECT id, empresa, fecha, factura, importe, sini FROM migracion_solidario");
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			int x = 0;
	 		while (rs.next()) {
	 			
	 			stmt2 = conn2.prepareStatement("SELECT id FROM clientes WHERE nombre = ? ");
	 			stmt2.setString(1,rs.getString(2));
	 			ResultSet rsx = stmt2.executeQuery();
	 			if(rsx.next()){
	 				
	 				PreparedStatement stmtsi = conn2.prepareStatement("SELECT nextval('recupero_facturas_id_seq')");
	        		ResultSet rssi = stmtsi.executeQuery();
	        		if(rssi.next()){
	        			
	        			int idFactura = rssi.getInt(1);
	 				
		 				PreparedStatement stmtx2 = conn2.prepareStatement(" INSERT INTO recupero_facturas" +
		 						"(id,fecha, cliente_id, create_usuario_id,create_date, estado_id, numero,serie,nota) VALUES " +
		 						"( ?, ?, ?, 1,now(),65, ?,'C',?)");
		 				stmtx2.setInt(1,idFactura);
		 				stmtx2.setDate(2,rs.getDate(3));
		 				stmtx2.setInt(3,rsx.getInt(1));
		 				stmtx2.setString(4,rs.getString(4));
		 				stmtx2.setString(5,rs.getString(6));
		 				stmtx2.executeUpdate();
		 				
		 				PreparedStatement stmtxl = conn2.prepareStatement(" INSERT INTO recupero_factura_lineas" +
		 				"(recupero_factura_id, producto_id, cuenta_analitica_id, cuenta_id,precio, cantidad, udm_id, create_usuario_id,create_date)" +
		 				"VALUES (?, 48629, 478,226, ?, 1, 1, 1, now())");
		 				stmtxl.setInt(1,idFactura);
		 				stmtxl.setBigDecimal(2, rs.getBigDecimal(5));
		 				stmtxl.executeUpdate();
		 				System.out.println("factura numero "+x);
		 				x++;
	 				
	        		} 

	        		
	 			}else{
	 				System.out.println("--------------------NOSE SE ENCONTRO LA EMPRESA "+rs.getString(2));
	 			}
	 		}
			
		} catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            
        }
	}	
}
