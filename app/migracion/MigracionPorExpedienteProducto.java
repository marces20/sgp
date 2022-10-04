package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class MigracionPorExpedienteProducto {
	
	public boolean migrar(Long idProducto){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar ProductoMigracion");
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	 
			PreparedStatement stmt = conn.prepareStatement("SELECT " +
					" ru.id," +
					" ru.name_template,"+
					" ru.codigo_rismi," +
					" ru.default_code," + 
					" ru.ips_code," +
					" rt.standard_price,"+
					" rt.purchase_ok,"+
					" rt.sale_ok,"+
					" ru.active,"+
					" rt.categ_id,"+
					" ru.tipo_producto_id,"+
					" ru.articulo_id,"+
					" rt.uom_id,"+
					" ru.create_uid," +
					" ru.create_date" +
					" from product_product ru " +
					" INNER JOIN product_template rt ON rt.id = ru.product_tmpl_id " +					
					" where ru.id = ?" );
			
			/*PreparedStatement stmt = conn.prepareStatement("SELECT " +
					" ru.id," +
					" ru.name_template,"+
					" ru.codigo_rismi," +
					" ru.default_code," + 
					" ru.ips_code," +
					" rt.standard_price,"+
					" rt.purchase_ok,"+
					" rt.sale_ok,"+
					" ru.active,"+
					" rt.categ_id,"+
					" ru.tipo_producto_id,"+
					" ru.articulo_id,"+
					" rt.uom_id,"+
					" ru.create_uid," +
					" ru.create_date" +
					" from product_product ru " +
					" INNER JOIN product_template rt ON rt.id = ru.product_tmpl_id " +		
					" INNER JOIN purchase_requisition_line prl ON prl.product_id = ru.id " +
					" INNER JOIN purchase_requisition pr ON pr.id = prl.requisition_id " +
					" WHERE pr.create_uid = 19 or pr.create_uid = 31 ");*/
					
			
			
			/*SELECT  * 
			from product_product ru 
			INNER JOIN product_template rt ON rt.id = ru.product_tmpl_id 
			INNER JOIN purchase_requisition_line prl ON prl.product_id = ru.id
			INNER JOIN purchase_requisition pr ON pr.id = prl.requisition_id
			WHERE pr.create_uid = 19 or pr.create_uid = 31*/

			stmt.setLong(1, idProducto);		
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			PreparedStatement stmt5 = null;
			while (rs.next()) {
				
				stmt5 = conn2.prepareStatement("SELECT * FROM productos where id = ?");
				stmt5.setLong(1, rs.getLong(1));
				ResultSet rs5 = stmt5.executeQuery();
				
				if(!rs5.next()){
					if(rs.getString(2) != null ){
						if(rs.getString(2).compareToIgnoreCase("") != 0){
							
							stmt2 = conn2.prepareStatement("INSERT INTO productos " +
									" (id,nombre,codigo_rismi,referencia,codigo_ips,precio_coste,compra,venta," +
									" activo,categoria_id,tipo_producto_id,articulo_id," +
									" udm_id,create_usuario_id,create_date)" +
									" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							 
							stmt2.setLong(1, rs.getLong(1));
							stmt2.setString(2, rs.getString(2));
							stmt2.setString(3, rs.getString(3));
							stmt2.setString(4, rs.getString(4));
							stmt2.setString(5, rs.getString(5));
							stmt2.setDouble(6, rs.getDouble(6));
							stmt2.setBoolean(7, rs.getBoolean(7));
							stmt2.setBoolean(8, rs.getBoolean(8));
							stmt2.setBoolean(9, rs.getBoolean(9));
							
							Long i =  rs.getLong(10);
							if( rs.getLong(10) == 137 ||  rs.getLong(10) == 122){
								i =  new Long(10);
							}else if(rs.getLong(10) == 2){ i =  new Long(27);}
							else if(rs.getLong(10) == 3){ i =  new Long(28);}
							else if(rs.getLong(10) == 4){ i =  new Long(29);}
							else if(rs.getLong(10) == 5){ i =  new Long(14);}
							else if(rs.getLong(10) == 6){ i =  new Long(10);}
							else if(rs.getLong(10) == 7){ i =  new Long(11);}
							else if(rs.getLong(10) == 8){ i =  new Long(12);}
							else if(rs.getLong(10) == 9){ i =  new Long(13);}
							else if(rs.getLong(10) == 10){ i =  new Long(14);}
							else if(rs.getLong(10) == 11){ i =  new Long(15);}
							else if(rs.getLong(10) == 12){ i =  new Long(16);}
							else if(rs.getLong(10) == 13){ i =  new Long(17);}
							else if(rs.getLong(10) == 14){ i =  new Long(18);}
							else if(rs.getLong(10) == 15){ i =  new Long(19);}
							else if(rs.getLong(10) == 16){ i =  new Long(20);}
							else if(rs.getLong(10) == 17){ i =  new Long(21);}
							else if(rs.getLong(10) == 18){ i =  new Long(22);}
							else if(rs.getLong(10) == 19){ i =  new Long(4);}
							else if(rs.getLong(10) == 20){ i =  new Long(6);}
							else if(rs.getLong(10) == 21){ i =  new Long(7);}
							else if(rs.getLong(10) == 22){ i =  new Long(8);}
							else if(rs.getLong(10) == 23){ i =  new Long(9);}
							else if(rs.getLong(10) == 24){ i =  new Long(23);}
							else if(rs.getLong(10) == 25){ i =  new Long(24);}
							else if(rs.getLong(10) == 26){ i =  new Long(25);}
							else if(rs.getLong(10) == 27){ i =  new Long(25);}
							else if(rs.getLong(10) == 29){ i =  new Long(32);}
							else if(rs.getLong(10) == 31){ i =  new Long(31);}
							else if(rs.getLong(10) == 32){ i =  new Long(31);}
							else if(rs.getLong(10) == 33){ i =  new Long(30);}
							else if(rs.getLong(10) == 113){ i =  new Long(14);}
							else if(rs.getLong(10) == 114){ i =  new Long(14);}
							else if(rs.getLong(10) == 121){ i =  new Long(25);}
							else if(rs.getLong(10) == 123){ i =  new Long(35);}
							else if(rs.getLong(10) == 125){ i =  new Long(33);}
							else if(rs.getLong(10) == 126){ i =  new Long(26);}
							else if(rs.getLong(10) == 129){ i =  new Long(34);}
							else if(rs.getLong(10) == 130){ i =  new Long(31);}
							else if(rs.getLong(10) == 131){ i =  new Long(25);}
							else if(rs.getLong(10) == 132){ i =  new Long(8);}
							else if(rs.getLong(10) == 133){ i =  new Long(20);}
							else if(rs.getLong(10) == 134){ i =  new Long(22);}
							else if(rs.getLong(10) == 135){ i =  new Long(25);}
							else if(rs.getLong(10) == 136){ i =  new Long(26);}
							else if(rs.getLong(10) == 88){ i =  new Long(26);}
							else if(rs.getLong(10) == 81){ i =  new Long(26);}
							
							stmt2.setLong(10, i);
							
							stmt2.setLong(11, rs.getLong(11));
							stmt2.setLong(12, rs.getLong(12));
							stmt2.setLong(13, rs.getLong(13));
							stmt2.setLong(14, rs.getLong(14));
							stmt2.setDate(15, rs.getDate(15));
							
							stmt2.executeUpdate();
						}
					}else{
						System.out.println("Nombre vacio");
					}
				}else{
					
					/*stmt3 = conn2.prepareStatement("UPDATE productos SET tipo_producto_id = ?,categoria_id = ? ,articulo_id = ?  " +
							" WHERE id = ? ");
					
					stmt3.setLong(1, rs.getLong(11));
					stmt3.setLong(2, rs.getLong(10));
					stmt3.setLong(3, rs.getLong(12));
					stmt3.setLong(4, rs.getLong(1));
					stmt3.executeUpdate();*/
					
					System.out.println("id Producto ya cargado "+rs.getString(2)+" - "+rs.getLong(1));
				}
				rs5.close();
			}
			rs.close();
			
			stmt.close();
			if(stmt2 != null){stmt2.close();}
			stmt5.close();
			System.out.println("Termino a migrar ProductoMigracion");
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
