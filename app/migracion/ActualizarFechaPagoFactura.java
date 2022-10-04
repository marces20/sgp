package migracion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import models.Balance;
import models.Factura;
import server.Configuracion2;

public class ActualizarFechaPagoFactura {
	
	public static boolean xxx(){
		Connection conn2 = null;
		System.out.println("Empezo a ActualizarNumeroAsientos");
		try {
			
			
			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt1 = conn2.prepareStatement("select fecha_pago,factura_id from pagos where tipo = 'payment' and state_id not in(23,25) ");
			ResultSet rs1 = stmt1.executeQuery();
			
			int i = 1;
			while (rs1.next()) {
				
				Factura f = Factura.find.where().eq("id", rs1.getInt(2)).findUnique();
				f.fecha_pago = null;
				f.save();
				
				
				 
				 
			}
			
		}catch (Exception e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
            
         
            
        }
		
		System.out.println("Termino a ActualizarNumeroAsientos");
		
		return true;
	}
}
