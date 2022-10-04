package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;

public class ActualizarCuentaPagos {
	
	public boolean migrar(){
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a migrar ActualizarCuentaPagos");
		try {
			
			System.out.println("Empezo a migrar ActualizarFacturasMigracion");
			conn2 = Configuracion2.get2().getConnection2();
			
			PreparedStatement stmt = conn2.prepareStatement("SELECT f.id,fl.cuenta_analitica_id FROM facturas f " +
					"INNER JOIN factura_lineas fl ON fl.factura_id = f.id ");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PreparedStatement stmt2 = conn2.prepareStatement("SELECT id FROM pagos where factura_id = ? ");
				stmt2.setInt(1, rs.getInt(1));
				
				ResultSet rs2 = stmt2.executeQuery();
				
				while (rs2.next()) {
					PreparedStatement stmt3 = conn2.prepareStatement("UPDATE pagos_lineas SET cuenta_analitica_id = ? " +
							"WHERE pago_id = ? AND cuenta_analitica_id is null ");
					stmt3.setInt(1, rs.getInt(2));
					stmt3.setInt(2, rs2.getInt(1));
					stmt3.executeUpdate();
				}
			}
			
			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }
		System.out.println("Termino a migrar ActualizarCuentaPagos");
		
		return true;
	}	
}	

