package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class ProductoMigracion {
	public boolean migrar(){
		
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
					" where ru.id in ( " +
					" select product_id from purchase_requisition_line " + 
					" where requisition_id in( " +
					" select p.id from purchase_requisition p " +
					" left join adop_expediente a on a.id = p.expediente_id " +
					" left join account_fiscalyear f on f.id = a.ejercicio_id " +
					" where f.id = 3 or p.create_date >= '2014-01-01' " +
					" ) " +
					" ) " );
					
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			PreparedStatement stmt5 = null;
			while (rs.next()) {
				
				stmt5 = conn2.prepareStatement("SELECT * FROM productos where id = ?");
				stmt5.setLong(1, rs.getLong(1));
				ResultSet rs5 = stmt5.executeQuery();
				
				if(!rs5.next()){
					if(rs.getString(2) != null ){
						if(rs.getString(2).compareToIgnoreCase("") != 0){
							//System.out.print('1');
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
							}
							
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
					System.out.println("id ya cargado "+rs.getString(2)+" - "+rs.getLong(1));
				}
				rs5.close();
			}
			rs.close();
			
			stmt.close();
			stmt2.close();
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
