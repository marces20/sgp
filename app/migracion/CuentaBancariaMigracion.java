package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class CuentaBancariaMigracion {
	public boolean migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar CuentaBancariaMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.sequence,ru.partner_id,ru.bank,ru.acc_number,"+
					" ru.create_uid, " +
					" ru.create_date " +
					" from res_partner_bank ru " +
					" where ru.partner_id in (892)");
					//" where ru.partner_id not in (641,1555,1592,2050,1838,1430,1585,1389,1390,1388,1530,1455,1587,2176,892)");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO cuenta_bancarias " +
						" (id,sucursal_banco_id,proveedor_id,banco_id,numero_cuenta,create_usuario_id,create_date,activo,predeterminada)" +
						" VALUES (?,?,?,?,?,?,?,true,true)");
				stmt2.setLong(1, rs.getLong(1));
				//stmt2.setLong(2, rs.getLong(2));
				
				switch ( rs.getInt(2)) {
			      case 37:
			    	   stmt2.setInt(2, 22);
			           break;
			      case 9:
			    	  stmt2.setInt(2, 21); 
			           break;
			      case 13:
			    	   stmt2.setInt(2, 20);
			           break;
			      case 5:
			    	   stmt2.setInt(2, 19);
			           break;
			      case 31:
			    	   stmt2.setInt(2, 18);
			           break;
			      case 23:
			    	  stmt2.setInt(2, 17); 
			           break;
			      case 3:
			    	   stmt2.setInt(2, 16);
			           break;
			      case 21:
			    	   stmt2.setInt(2, 15);
			           break;
			      case 1:
			    	   stmt2.setInt(2, 23);
			           break;
			      case 2:
			    	  stmt2.setInt(2, 14); 
			           break;
			      case 584:
			    	   stmt2.setInt(2, 13);
			           break;
			      case 522:
			    	   stmt2.setInt(2, 12);
			           break;     
			      case 518:
			    	   stmt2.setInt(2, 11);
			           break;     
			      case 682:
			    	   stmt2.setInt(2, 10);
			           break;     
			      case 6:
			    	   stmt2.setInt(2, 9);
			           break;     
			      case 782:
			    	   stmt2.setInt(2, 7);
			           break;     
			      case 30:
			    	   stmt2.setInt(2, 6);
			           break;     
			      case 540:
			    	   stmt2.setInt(2, 5);
			           break;     
			      case 42:
			    	   stmt2.setInt(2, 4);
			           break;     
			      case 8:
			    	   stmt2.setInt(2, 3);
			           break;   
			      case 12:
			    	   stmt2.setInt(2, 2);
			           break;   
			      case 14:
			    	   stmt2.setInt(2, 1);
			           break;   
			      default:
			    	  stmt2.setNull(2, 0);
			          break;
			      }
				
				stmt2.setLong(3, rs.getLong(3));
				if(rs.getLong(4) == 2){
					stmt2.setLong(4, 1);
				}else{
					stmt2.setLong(4, rs.getLong(4));
				}
				stmt2.setString(5, rs.getString(5));
				stmt2.setLong(6, rs.getLong(6));
				stmt2.setDate(7, rs.getDate(7));
				
				stmt2.executeUpdate();
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			
			System.out.println("Termino a migrar CuentaBancariaMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		
		return true;
	}
}
