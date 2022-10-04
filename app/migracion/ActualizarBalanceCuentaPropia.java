package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.Logger;
import server.Configuracion2;

public class ActualizarBalanceCuentaPropia {

	public boolean xxx(){
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a ActualizarAutorizados");
		try {
			conn2 = Configuracion2.get2().getConnection2();
			
			
			/*PreparedStatement stmt0 = conn2.prepareStatement("select numero,fecha_emision,fecha_debito from cheques_bk");
			ResultSet rs0 = stmt0.executeQuery();
			while (rs0.next()) {
				
				PreparedStatement stmtu = conn2.prepareStatement("UPDATE pagos SET fecha_emision=?,fecha_conciliacion=? WHERE numero_cheque = ? ");
				stmtu.setDate(1, rs0.getDate(2) );//monto
				stmtu.setDate(2, rs0.getDate(3));
				stmtu.setString(3, rs0.getString(1));
				stmtu.executeUpdate();
				Logger.debug("--- "+rs0.getString(1));
			}*/
			
			PreparedStatement stmtu;
			PreparedStatement stmt0 = conn2.prepareStatement("select balance_cuenta_propia_id,pago_id from balance_cuentas_propia_pagos bp "
					+ "where pago_id in(select id from pagos where fecha_pago > '2017-01-01')");
			
			ResultSet rs0 = stmt0.executeQuery();
			while (rs0.next()) {
				
				int idPago = rs0.getInt(2);
				
				PreparedStatement stmt1 = conn2.prepareStatement("select referencia,numero_cheque,fecha_emision,fecha_conciliacion from pagos where id = ?");
				stmt1.setInt(1, idPago);
				ResultSet rssi = stmt1.executeQuery();
        		
        		if(rssi.next()){
        			
        			int idBcp = rs0.getInt(1);
					stmtu = conn2.prepareStatement("UPDATE balance_cuentas_propias SET referencia=?,numero_cheque=?,fecha_emision=?,fecha_debito=? "+
												   " WHERE id = ? ");
					stmtu.setString(1, rssi.getString(1) );//monto
					stmtu.setString(2, rssi.getString(2));
					stmtu.setDate(3, rssi.getDate(3));
					stmtu.setDate(4, rssi.getDate(4));
					stmtu.setInt(5, idBcp);
					stmtu.executeUpdate();
					Logger.debug("--- "+idBcp);
        		}
			}
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
            
            try { if (conn2 != null) conn2.close(); } catch (Exception e2) { }
            
        }
		
		System.out.println("Termino a ActualizarBalanceCuentaPropia");
		
		return true;
	}	
}
