package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class ActualizarPagosMigracion {
	public boolean migrar(){
		Connection conn = null;
		Connection conn2 = null;
	
		try {
			/*conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
        	PreparedStatement stmt = conn2.prepareStatement("select p.factura_id,l.monto,l.monto_original " +
        			"from pagos_lineas l " +
        			"INNER JOIN pagos p on p.id = l.pago_id " +
        			"where p.tipo = 'impuestos' ");
        	
        	ResultSet rs = stmt.executeQuery();
			
        	while (rs.next()) {
        		System.out.println("1");
        		PreparedStatement stmt3 = conn2.prepareStatement("select l.id,l.monto,l.monto_original " +
        				" from pagos_lineas l " +
        				" INNER JOIN pagos p on p.id = l.pago_id " +
        				" where p.tipo = 'payment' AND p.factura_id = ? AND p.proveedor_id = 748");
        		stmt3.setLong(1, rs.getLong(1));
        		ResultSet rs2 = stmt3.executeQuery();
        		
        		if(rs2.next()){
        			PreparedStatement stmt2 = conn2.prepareStatement("UPDATE pagos_lineas SET  " +
        					" monto = (monto-?), monto_original = (monto_original-?)  " +
    						" WHERE id = ? ");
        			System.out.println("1 "+rs.getDouble(2));
        			System.out.println("2 "+rs.getDouble(3));
        			System.out.println("3 "+rs.getDouble(3));
        			stmt2.setDouble(1, rs.getDouble(2));
        			stmt2.setDouble(2, rs.getDouble(3));
        			stmt2.setLong(3, rs2.getLong(1));
        			stmt2.executeUpdate();
        			
        		}
        		
        		
        	}*/
			
			System.out.println("Empezo a migrar ActualizarPagosMigracion");
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
        	PreparedStatement stmt = conn.prepareStatement("SELECT " +
        			" v.state, " +
        			" v.date," +
        			" v.reference, "+
					" l.period_id," +
					" v.expediente_id," +	
					" v.partner_id," +
					" v.id " +
					" FROM account_voucher v" +
					" INNER JOIN account_voucher_line l on v.id = l.voucher_id " +
        			" WHERE partner_id not in (1367,1366) AND expediente_id in (1644,1665,1605,1606,1607,1608,1609,1610,1612,1613,1614,1616,1617,1618,1619,1620,1621,1622,1623,1625,1626,1828,1829) ");
        	
        	ResultSet rs = stmt.executeQuery();
			
        	while (rs.next()) {
				System.out.print("1");
				if(rs.getString(1).compareToIgnoreCase("posted") == 0){
					PreparedStatement stmt2 = conn2.prepareStatement("UPDATE pagos SET  state_id= ?,referencia = ? ,fecha_pago = ?  " +
							" WHERE expediente_id = ? AND proveedor_id = ? AND periodo_id =  ? ");
					
					stmt2.setLong(1, new Integer(23));
					stmt2.setString(2, rs.getString(3));
					stmt2.setDate(3, rs.getDate(2));
					
					//stmt2.setDate(1, rs.getDate(2));
					//stmt2.setString(2, rs.getString(3));
					
					stmt2.setLong(4, rs.getLong(5));
					stmt2.setLong(5, rs.getLong(6));
					stmt2.setLong(6, rs.getLong(4));
					stmt2.executeUpdate();
				}
			}	 
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }
		System.out.println("Termino a migrar ActualizarPagosMigracion");
		
		return true;
	}	
}
