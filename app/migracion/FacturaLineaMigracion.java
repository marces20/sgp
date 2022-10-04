package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class FacturaLineaMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar FacturaLineaMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id,uos_id,account_id,name,invoice_id,price_unit,price_subtotal,note," +
					" discount,account_analytic_id,quantity,partner_id,product_id,state,redondear,price_descuentos,"+
					" create_uid," +
					" create_date " +
					" from account_invoice_line");
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				
				
				stmt2 = conn2.prepareStatement("INSERT INTO factura_lineas " +
						" (id,udm_id,cuenta_id,nombre,factura_id,precio,precio_subtotal,nota,descuento,cuenta_analitica_id," +
						"  cantidad,proveedor_id,producto_id,estado,redondear,precio_descuento,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				stmt2.setLong(1, rs.getLong(1));
				if(rs.getLong(2) == 0){
					stmt2.setNull(2,0);
				}else{
					stmt2.setLong(2, rs.getLong(2));
				}
				if(rs.getLong(3) == 0){
					stmt2.setNull(3,0);
				}else{
					stmt2.setLong(3, rs.getLong(3));
				}
				stmt2.setString(4, rs.getString(4));  
				stmt2.setLong(5, rs.getLong(5));
				
				stmt2.setBigDecimal(6, rs.getBigDecimal(6));
				stmt2.setBigDecimal(7, rs.getBigDecimal(7));
				stmt2.setString(8, rs.getString(8));    
				stmt2.setBigDecimal(9, rs.getBigDecimal(9));  
				if(rs.getLong(10) == 0){
					stmt2.setNull(10,0);
				}else{
					stmt2.setLong(10, rs.getLong(10));
				}
				stmt2.setDouble(11, rs.getDouble(11)); 
				
				
				if(rs.getLong(12) == 0 || rs.getLong(12) == 2515 || rs.getLong(12) ==1945 || rs.getLong(12) ==786 || rs.getLong(12) ==1491 || rs.getLong(12) ==2326 || rs.getLong(12) ==2423 || rs.getLong(12) ==2282 || rs.getLong(12) ==2548 || rs.getLong(12) ==2062 || rs.getLong(12) ==2052 || rs.getLong(12) ==1444 || rs.getLong(12) ==2213 || rs.getLong(12) ==2330 || rs.getLong(12) ==2422 || rs.getLong(12) ==2379 || rs.getLong(12) ==1594 || rs.getLong(12) ==2435){
					stmt2.setNull(12,0);
				}else{
					stmt2.setLong(12, rs.getLong(12));
				}
				
				
				if(rs.getLong(13) == 0){
					stmt2.setNull(13,0);
				}else{
					stmt2.setLong(13, rs.getLong(13));
				}
				stmt2.setString(14, rs.getString(14)); 
				stmt2.setBoolean(15, rs.getBoolean(15));
				stmt2.setBigDecimal(16, rs.getBigDecimal(16));
				if(rs.getLong(17) == 0 || rs.getLong(17) == 129){
					stmt2.setNull(17,0);
				}else{
					stmt2.setLong(17, rs.getLong(17));
				}
				stmt2.setDate(18, rs.getDate(18));
				stmt2.executeUpdate();
				
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar FacturaLineaMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
