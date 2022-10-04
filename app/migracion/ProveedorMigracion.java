package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class ProveedorMigracion {
	
	public boolean migrar(Long idProveedor){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar ProveedorMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	 
        	
        	
        	PreparedStatement stmt = conn.prepareStatement("SELECT " +
					" ru.id,ru.name,"+
					" ru.active," +
					" replace(replace(replace(ru.cuit, ' ', ''), '-', ''), '.', '' )," +
					" ru.nro_inscripcion," +
					" ru.ref," +
					" ru.create_uid," +
					" ru.create_date " +
					" FROM res_partner ru " +
					" WHERE ru.id = ? ");
					//" WHERE ru.id in(select partner_id from purchase_order) " +
					//" AND ru.id not in(6623,6622,6621,6609,6608,6607,6606,6605," +
					//" 6604,6603,6602,6601,6600,6599,6598,6597,6596,6595,6594,6593," +
					//" 6592,6591,6590,6589,6588,6587,6586,6585,6584,6583,6582,6581," +
					//" 6563,6562,6561,6534,6533,6532,6531,6530,6529,6528,6527,6526," +
					//" 6525,6524,6523,6522,6521,6506,6505,6504,6503,6502,6501,1387) "); 
        	stmt.setLong(1, idProveedor);
        	
			/*
			update res_partner set cuit = null where id = 1433;
			update res_partner set cuit = null where id = 2431;
			*/
        	
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			int z =0;  
			while (rs.next()) {
				
				PreparedStatement stmt6 = conn2.prepareStatement("select * from proveedores where id = ?");
				stmt6.setLong(1, rs.getLong(1));
				ResultSet rs6 = stmt6.executeQuery();
				if(!rs6.next()){
					System.out.println(z +" "+rs.getLong(1));
					stmt2 = conn2.prepareStatement("INSERT INTO proveedores " +
							" (id,nombre,activo,cuit,nro_inscripcion,referencia,create_usuario_id,create_date)" +
							" VALUES (?,?,?,?,?,?,?,?)");
					stmt2.setLong(1, rs.getLong(1));
					stmt2.setString(2, rs.getString(2));
					stmt2.setBoolean(3, rs.getBoolean(3));
					if(rs.getString(4) != null){
						stmt2.setLong(4, rs.getLong(4));
					}else{
						stmt2.setNull(4,0);
					}
					stmt2.setString(5, rs.getString(5));
					stmt2.setString(6, rs.getString(6));
					stmt2.setLong(7, rs.getLong(7));
					stmt2.setDate(8, rs.getDate(8));
					
					stmt2.executeUpdate();
				
					PreparedStatement stmt3 = conn.prepareStatement("select " +
							" ru.id,ru.partner_id,"+
							" ru.street," +
							" ru.active," +
							" ru.city," +
							" ru.name," +
							" ru.zip," +
							" ru.country_id," +
							" ru.state_id," +
							" ru.localidad_id," +
							" ru.email," +
							" ru.numero," +
							" ru.phone," +
							" ru.fax," +
							" ru.mobile," +
							" ru.create_date," +
							" ru.create_uid " +
							" from res_partner_address ru where partner_id = ? ");
					stmt3.setLong(1, rs.getLong(1));
					
					ResultSet rs3 = stmt3.executeQuery();
				
					while (rs3.next()) {
						
						PreparedStatement stmt5 = conn2.prepareStatement("INSERT INTO proveedor_direcciones " +
								" (proveedor_id,calle,activo,ciudad,nombre,zip,pais_id,provincia_id," +
								"  localidad_id,email,numero,telefono,fax,mobile,create_date,create_usuario_id)" +
								" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						//stmt5.setLong(1, rs3.getLong(1));
						stmt5.setLong(1, rs3.getLong(2));//pid
						stmt5.setString(2, rs3.getString(3));//calle
						stmt5.setBoolean(3, rs3.getBoolean(4));//activo
						stmt5.setString(4, rs3.getString(5));//ciudad
						stmt5.setString(5, rs3.getString(6));//nombre
						stmt5.setString(6, rs3.getString(7));//zip
						 
						if(rs3.getLong(8) == 0){
							stmt5.setNull(7,0);
						}else{
							stmt5.setLong(7, rs3.getLong(8));
						}
						if(rs3.getLong(9) == 0){
							stmt5.setNull(8,0);
						}else{
							stmt5.setLong(8, rs3.getLong(9));
						}
						if(rs3.getLong(10) == 0){
							stmt5.setNull(9,0);
						}else{
							stmt5.setLong(9, rs3.getLong(10));
						}
						stmt5.setString(10, rs3.getString(11));
						stmt5.setString(11, rs3.getString(12));
						stmt5.setString(12, rs3.getString(13));
						stmt5.setString(13, rs3.getString(14));
						stmt5.setString(14, rs3.getString(15));
						stmt5.setDate(15, rs3.getDate(16));
						stmt5.setLong(16, rs3.getLong(17));
						stmt5.executeUpdate();
					}
					z++;
				}
				
			}
			rs.close();
			stmt.close();
			
			System.out.println("Termino a migrar ProveedorMigracion Total:"+z);
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
