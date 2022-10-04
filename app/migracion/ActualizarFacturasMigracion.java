package migracion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import server.Configuracion2;
import server.Configuration;

public class ActualizarFacturasMigracion {
	public boolean migrar(){
		Connection conn = null;
		Connection conn2 = null;
	
		try {
			System.out.println("Empezo a migrar ActualizarFacturasMigracion");
			
			
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
        	PreparedStatement stmt = conn.prepareStatement("SELECT " +
        			" reference," +
        			" f_recepcion,"+
					" fecha_orden_pago,"+
					" debe_afip,"+
					" debe_dgr,"+
					" orden_pago,"+
					" period_id," +
					" expediente_id," +	
					" partner_id," +
					" id, state " +
					" FROM account_invoice " +
        			" WHERE period_id = 30 AND expediente_id in (1626) ");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.print("1");
				
				Integer opId = null;
				PreparedStatement stmt3 = conn2.prepareStatement("SELECT id FROM ordenes_pagos WHERE numero = ?");
				stmt3.setInt(1, rs.getInt(6));
				ResultSet rs3 = stmt3.executeQuery();
				
				if(rs3.next()){
					opId = rs3.getInt(1);
				}else{
					
					 
					PreparedStatement stmt4 = conn2.prepareStatement("INSERT INTO ordenes_pagos " +
							"(ejercicio_id,numero,fecha) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
					stmt4.setLong(1,new Integer(3).longValue());
					stmt4.setLong(2,rs.getInt(6));
					stmt4.setDate(3, rs.getDate(3));
					stmt4.executeUpdate();
					ResultSet keyset = stmt4.getGeneratedKeys();
					
					if(keyset.next()){
						 
						opId = keyset.getInt(1);
					}
				}
				
				
				PreparedStatement stmt2 = conn2.prepareStatement("UPDATE facturas SET  " +
						" numero_factura = ?,fecha_recepcion = ?,fecha_orden_pago = ?,debe_afip = ?,debe_dgr = ? , orden_pago_id = ? , state_id = ?" +
						" WHERE periodo_id = ? AND expediente_id = ? AND proveedor_id = ?", Statement.RETURN_GENERATED_KEYS );
				stmt2.setString(1, rs.getString(1));
				stmt2.setDate(2, rs.getDate(2));
				stmt2.setDate(3, rs.getDate(3));
				stmt2.setBoolean(4, rs.getBoolean(4));
				stmt2.setBoolean(5, rs.getBoolean(5));
				stmt2.setLong(6, opId);//OPG
				if(rs.getString(11).compareToIgnoreCase("paid") == 0){
					stmt2.setLong(7, new Integer(33).longValue());
				}else if(rs.getString(11).compareToIgnoreCase("devengado") == 0){
					stmt2.setLong(7, new Integer(17).longValue());
				}else{
					stmt2.setLong(7, new Integer(18).longValue());
				}
				
				stmt2.setLong(8, rs.getLong(7));
				stmt2.setLong(9, rs.getLong(8));
				stmt2.setLong(10, rs.getLong(9));
				
				
				stmt2.executeUpdate();
				 
				Integer facturaId = null;
				 
				PreparedStatement stmt7 = conn2.prepareStatement("SELECT id FROM facturas WHERE periodo_id = ? AND expediente_id = ? AND proveedor_id = ? ");
				stmt7.setLong(1, rs.getLong(7));
				stmt7.setLong(2, rs.getLong(8));
				stmt7.setLong(3, rs.getLong(9));
				ResultSet rs7 = stmt7.executeQuery();
				if(rs7.next()){
					facturaId = rs7.getInt(1);
				}
				
				if(facturaId != null){
					PreparedStatement stmt5 = conn.prepareStatement("select " +
							" account_id,amount," +
							" create_uid," +
							" create_date,name,invoice_id " +
							" from account_invoice_tax WHERE invoice_id = ? ");
					stmt5.setLong(1, rs.getLong(10));
					ResultSet rs5 = stmt5.executeQuery();
					
					while (rs5.next()) {
						PreparedStatement stmt6 = conn2.prepareStatement("INSERT INTO factura_linea_impuestos " +
								" (cuenta_id,monto,create_usuario_id,create_date,nombre,factura_id)" +
								" VALUES (?,?,?,?,?,?)");
						stmt6.setLong(1, rs5.getLong(1));
						BigDecimal n = new BigDecimal(-1);
						stmt6.setBigDecimal(2, rs5.getBigDecimal(2).multiply(n));
						stmt6.setLong(3, rs5.getLong(3));
						stmt6.setDate(4, rs5.getDate(4));
						stmt6.setString(5, rs5.getString(5)); 
						stmt6.setLong(6, facturaId);
						stmt6.executeUpdate();
					}
				}else{
					System.out.println("La la factura en null no se puede meter el impuesto.");
				}
			}
			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }
		System.out.println("Termino a migrar ActualizarFacturasMigracion");
		
		return true;
	}	
}
