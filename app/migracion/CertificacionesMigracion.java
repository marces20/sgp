package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import play.Logger;

import server.Configuracion2;
import server.Configuration;

public class CertificacionesMigracion {
	
	public boolean migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			System.out.println("Empezo a migrar CertificacionesMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
        	PreparedStatement stmt = conn.prepareStatement("SELECT " +
        			" partner_id," +
        			" create_date," +
					" profe," +
					" period_id," +
					" expediente_id," +	
					" create_uid," +
					" create_date, " +
					" id " +
					" FROM account_invoice " +
        			//" WHERE expediente_id in (1644,1665,1605,1606,1607,1608,1609,1610,1612,1613,1614,1616,1617,1618,1619,1620,1621,1622,1623,1625,1626,1828,1829) ");
        			" WHERE expediente_id in (1621) AND period_id in (30)");
        	
        	
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			while (rs.next()) {
				System.out.print("1");
				stmt2 = conn2.prepareStatement("INSERT INTO certificaciones " +
						"(proveedor_id,fecha_certificacion,profe,periodo_id,expediente_id," +
						" create_usuario_id,create_date,state_id,creacion_automatica,orden_id)" +
						" VALUES (?,?,?,?,?,?,?,28,?,30046)", Statement.RETURN_GENERATED_KEYS);
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setDate(2, rs.getDate(2));  
				stmt2.setBoolean(3, rs.getBoolean(3)); 
				stmt2.setLong(4, rs.getLong(4));
				stmt2.setLong(5, rs.getLong(5));
				stmt2.setLong(6, rs.getLong(6));
				stmt2.setDate(7, rs.getDate(7));   
				stmt2.setBoolean(8, true); 
				stmt2.executeUpdate();
				ResultSet keyset = stmt2.getGeneratedKeys();
				Integer lastId = null;
				if(keyset.next()){
					lastId = keyset.getInt(1);
				}
				
				stmt3 = conn.prepareStatement("select " +
						" product_id,quantity,account_analytic_id,discount,uos_id,price_unit,create_uid,create_date" +
						" from account_invoice_line where invoice_id = ?");
				stmt3.setLong(1, rs.getLong(8));
				
				ResultSet rs3 = stmt3.executeQuery();
				PreparedStatement stmt4 = null;
				while (rs3.next()) {
					stmt4 = conn2.prepareStatement("INSERT INTO certificaciones_lineas " +
							"(producto_id,cantidad,cuenta_analitica_id,descuento,udm_id,precio,create_usuario_id," +
							" create_date,certificacion_id) VALUES (?,?,?,?,?,?,?,?,?)");
					
					stmt4.setLong(1, rs3.getLong(1));
					stmt4.setLong(2, rs3.getLong(2));
					//stmt4.setLong(3, rs3.getLong(3));
					stmt4.setLong(3, new Integer(178).longValue());
					stmt4.setLong(4, rs3.getLong(4));
					stmt4.setLong(5, rs3.getLong(5));
					stmt4.setBigDecimal(6, rs3.getBigDecimal(6));
					stmt4.setLong(7, rs3.getLong(7)); 
					stmt4.setDate(8, rs3.getDate(8));
					stmt4.setLong(9, lastId.longValue());
					stmt4.executeUpdate();
				}
				
			}
		
			
			
		}catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        }
		System.out.println("Termino a migrar CertificacionesMigracion");
		
		return true;
	}	
}
