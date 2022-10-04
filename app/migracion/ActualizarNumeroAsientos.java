package migracion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import models.Balance;
import models.Estado;
import models.Factura;
import server.Configuracion2;

public class ActualizarNumeroAsientos {
	

	public static boolean xxx(){
		Connection conn2 = null;
		System.out.println("Empezo a ActualizarNumeroAsientos");
		try {
			
			
			conn2 = Configuracion2.get2().getConnection2();
			PreparedStatement stmt1 = conn2.prepareStatement("select (orden_pago_id) as op from balances group by orden_pago_id order by orden_pago_id asc");
			ResultSet rs1 = stmt1.executeQuery();
			
			int i = 1;
			while (rs1.next()) {
				
				List<Balance> lfx = Balance.find.where().gt("haber", BigDecimal.ZERO).eq("orden_pago_id",rs1.getInt(1)).findList();
				for(Balance bbx: lfx) {
					bbx.asiento = i;
					bbx.save();
				}
				
				List<Balance> lfd = Balance.find.where().gt("debe", BigDecimal.ZERO).eq("orden_pago_id",rs1.getInt(1)).findList();
				for(Balance bbd: lfd) {
					bbd.asiento = i;
					bbd.save();
				}
				i++;
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
