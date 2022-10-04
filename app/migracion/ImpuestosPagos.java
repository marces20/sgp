package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;

public class ImpuestosPagos {
	
	public boolean buscarImpuestosNoCreados(){
		
		Connection conn2 = null;
		System.out.println("Empezo a migrar ActualizarControlPresupuestario");
		int s = 0;
		try {
			conn2 = Configuracion2.get2().getConnection2();
			
			PreparedStatement stmt = conn2.prepareStatement("select f.expediente_id, l.cuenta_id,f.orden_pago_id,f.id " +
					" from facturas f  " +
					" inner join factura_linea_impuestos l on f.id = l.factura_id " +
					" where f.state_id = 19 ");
					
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				PreparedStatement stmt2 = conn2.prepareStatement("select p.expediente_id, p.cuenta_impuesto_id " +
						"from pagos p  " +
						"where p.expediente_id = ? and p.cuenta_impuesto_id = ? and p.orden_pago_id = ?  ");
				stmt2.setInt(1, rs.getInt(1));
				stmt2.setInt(2, rs.getInt(2));
				stmt2.setInt(3, rs.getInt(3));
				ResultSet rs2 = stmt2.executeQuery();
				
				if(!rs2.next()){
					System.out.println("ID FACTURA: "+rs.getInt(4));
				}
				
			}
			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }
		System.out.println("Termino a migrar ActualizarControlPresupuestario ");
		
		return true;	
	}
	
	
	public boolean actualizarCuentaImpuestosPagos(){
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a migrar ActualizarControlPresupuestario");
		int s = 0;
		try {
			conn2 = Configuracion2.get2().getConnection2();
			
			PreparedStatement stmt = conn2.prepareStatement("select l.cuenta_id,p.id " +
					"from pagos p " +
					"inner join facturas f on f.id = p.factura_id " +
					"inner join factura_linea_impuestos l on f.id = l.factura_id " +
					"where p.tipo = 'impuestos'");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				PreparedStatement stmt1 = conn2.prepareStatement("update pagos set cuenta_impuesto_id = ? where id = ?");
				stmt1.setInt(1, rs.getInt(1));
				stmt1.setInt(2, rs.getInt(2));
				stmt1.executeUpdate();
				s++;
			}
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }
		System.out.println("Termino a migrar ActualizarControlPresupuestario ");
		System.out.println("Se updetearons "+s+" regristos");
		return true;
	}
	
	
}
