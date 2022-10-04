package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;

public class ActualizarProductosRepetidos {
	
	public boolean actualizar(){
		Connection conn = null;
		Connection conn2 = null;
		
		/*
			alter table solicitud_lineas disable trigger all;
UPDATE solicitud_lineas SET producto_id = 1621 WHERE producto_id = 5275;
alter table solicitud_lineas enable trigger all;

UPDATE factura_lineas SET producto_id = 1621 WHERE producto_id = 5275;
UPDATE inventario SET producto_id = 1621 WHERE producto_id = 5275;

alter table orden_lineas disable trigger all;
UPDATE orden_lineas SET producto_id = 1621 WHERE producto_id = 5275 ;
alter table orden_lineas enable trigger all;

UPDATE remito_linea_baul SET producto_id = 1621 WHERE producto_id = 5275 ;
		
		*/
		try {
			conn2 = Configuracion2.get2().getConnection2();
        	
			boolean a = true;
			boolean x = false;
			
			play.Logger.debug("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			
			PreparedStatement stmt1 = conn2.prepareStatement("select count(*) c," +
					"UPPER(replace(replace(replace(trim(nombre),' ','' ),'-',''),'.','' )) nombre " +
					"from productos "+
					"where nombre = 'Mango p/electrobisturi p/cirugia x unidad' "+
					"group by UPPER(replace(replace(replace(trim(nombre),' ','' ),'-',''),'.','' )) " +
					"order by c desc limit 100"); 
			ResultSet rs1 = stmt1.executeQuery();
			
			while (rs1.next()) {
				
				 
				if(rs1.getInt(1) > 1){
				
				 
					PreparedStatement stmt2 = conn2.prepareStatement("select id,nombre " +
							"from productos " +
							"where UPPER(replace(replace(replace(trim(nombre),' ','' ),'-',''),'.','' )) = ?  and id = 767 limit 1 ");
					stmt2.setString(1, rs1.getString(2));
					ResultSet rs2 = stmt2.executeQuery();
			
				
				
					while (rs2.next()) {
						 
						String nombreProducto = rs2.getString(2).toUpperCase().trim().replace(" ","").replace("-","").replace(".","");
						
						PreparedStatement stmt = conn2.prepareStatement("SELECT id FROM productos " +
								"where UPPER(replace(replace(replace(trim(nombre),' ','' ),'-',''),'.','' )) = ? AND id <> ?");
						stmt.setString(1, nombreProducto);
						stmt.setInt(2, rs2.getInt(1));
						ResultSet rs = stmt.executeQuery();
						System.out.println("nombre : "+nombreProducto);
						System.out.println("id : "+rs2.getInt(1));
						
							while (rs.next()) {
								 
								x = true;
								PreparedStatement stmtat2z = conn2.prepareStatement("alter table solicitud_lineas disable trigger all");
								stmtat2z.executeUpdate();
								PreparedStatement stmtat2zz = conn2.prepareStatement("alter table solicitud_linea_ajustes disable trigger all");
								stmtat2zz.executeUpdate();
								PreparedStatement stmts = conn2.prepareStatement("UPDATE solicitud_lineas SET producto_id = ? WHERE producto_id = ? ");
								stmts.setInt(1, rs2.getInt(1));
								stmts.setInt(2, rs.getInt(1));
								stmts.executeUpdate();
								System.out.println("ID a2: "+rs2.getInt(1));
								System.out.println("ID 2: "+rs.getInt(1));
								
								
								PreparedStatement stmtsa = conn2.prepareStatement("UPDATE solicitud_linea_ajustes SET producto_id = ? WHERE producto_id = ? ");
								stmtsa.setInt(1, rs2.getInt(1));
								stmtsa.setInt(2, rs.getInt(1));
								stmtsa.executeUpdate();
								
								PreparedStatement stmtatz2 = conn2.prepareStatement("alter table solicitud_linea_ajustes enable trigger all");
								stmtatz2.executeUpdate();
								PreparedStatement stmtatzl2 = conn2.prepareStatement("alter table solicitud_lineas enable trigger all");
								stmtatzl2.executeUpdate();
								
								
								PreparedStatement stmtf = conn2.prepareStatement("UPDATE factura_lineas SET producto_id = ? WHERE producto_id = ? ");
								stmtf.setInt(1, rs2.getInt(1));
								stmtf.setInt(2, rs.getInt(1));
								stmtf.executeUpdate();
							
								PreparedStatement stmtat2cl = conn2.prepareStatement("alter table certificaciones_lineas disable trigger all");
								stmtat2cl.executeUpdate();
								PreparedStatement stmtc = conn2.prepareStatement("UPDATE certificaciones_lineas SET producto_id = ? WHERE producto_id = ? ");
								stmtc.setInt(1, rs2.getInt(1));
								stmtc.setInt(2, rs.getInt(1));
								stmtc.executeUpdate();
								PreparedStatement stmtat2clz = conn2.prepareStatement("alter table certificaciones_lineas enable trigger all");
								stmtat2clz.executeUpdate();
								
								PreparedStatement stmtcs = conn2.prepareStatement("UPDATE certificaciones_servicios_lineas SET producto_id = ? WHERE producto_id = ? ");
								stmtcs.setInt(1, rs2.getInt(1));
								stmtcs.setInt(2, rs.getInt(1));
								stmtcs.executeUpdate();
								
								PreparedStatement stmtcc = conn2.prepareStatement("UPDATE certificaciones_compras_lineas SET producto_id = ? WHERE producto_id = ? ");
								stmtcc.setInt(1, rs2.getInt(1));
								stmtcc.setInt(2, rs.getInt(1));
								stmtcc.executeUpdate();
								
								PreparedStatement stmti = conn2.prepareStatement("UPDATE inventario SET producto_id = ? WHERE producto_id = ? ");
								stmti.setInt(1, rs2.getInt(1));
								stmti.setInt(2, rs.getInt(1));
								stmti.executeUpdate();
								
								
								PreparedStatement stmtat = conn2.prepareStatement("alter table orden_lineas disable trigger all");
								stmtat.executeUpdate();
								PreparedStatement stmtatx = conn2.prepareStatement("alter table orden_lineas_ajustes disable trigger all");
								stmtatx.executeUpdate();
								
								PreparedStatement stmtol = conn2.prepareStatement("UPDATE orden_lineas SET producto_id = ? WHERE producto_id = ? ");
								stmtol.setInt(1, rs2.getInt(1));
								stmtol.setInt(2, rs.getInt(1));
								stmtol.executeUpdate();
								
								PreparedStatement stmtola = conn2.prepareStatement("UPDATE orden_lineas_ajustes SET producto_id = ? WHERE producto_id = ? ");
								stmtola.setInt(1, rs2.getInt(1));
								stmtola.setInt(2, rs.getInt(1));
								stmtola.executeUpdate();
								
								PreparedStatement stmtrl = conn2.prepareStatement("UPDATE remito_linea_baul SET producto_id = ? WHERE producto_id = ? ");
								stmtrl.setInt(1, rs2.getInt(1));
								stmtrl.setInt(2, rs.getInt(1));
								stmtrl.executeUpdate();
								
								
								
								PreparedStatement stmtat2 = conn2.prepareStatement("alter table orden_lineas enable trigger all");
								stmtat2.executeUpdate();
								PreparedStatement stmtat2x = conn2.prepareStatement("alter table orden_lineas_ajustes enable trigger all");
								stmtat2x.executeUpdate();
								
								PreparedStatement stmd = conn2.prepareStatement("delete from productos where id = ? ");
								stmd.setInt(1, rs.getInt(1));
								stmd.executeUpdate();
								
								System.out.println("ID ELIMINADO: "+rs.getInt(1));
							}
							
						/*if(x){
							break;
						}*/
					}
				}
			}
        	
        	
		} catch (SQLException e) {
            play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }	
		
		return true;
	}	
	 /*
	alter table solicitud_lineas disable trigger all;
	alter table solicitud_linea_ajustes disable trigger all;
	UPDATE solicitud_lineas SET producto_id = 767 WHERE producto_id = 70072;
	UPDATE solicitud_linea_ajustes SET producto_id = 767 WHERE producto_id = 70072 ;
	alter table solicitud_linea_ajustes enable trigger all ;
	alter table solicitud_lineas enable trigger all ;
	UPDATE factura_lineas SET producto_id = 767 WHERE producto_id = 70072  ;
	alter table certificaciones_lineas disable trigger all ;
	UPDATE certificaciones_lineas SET producto_id = 767 WHERE producto_id = 70072  ;
	alter table certificaciones_lineas enable trigger all ;
	UPDATE certificaciones_servicios_lineas SET producto_id =767 WHERE producto_id = 70072  ;
	UPDATE certificaciones_compras_lineas SET producto_id = 767 WHERE producto_id = 70072 ;
	UPDATE inventario SET producto_id = 767 WHERE producto_id =70072 ;
	alter table orden_lineas disable trigger all ;
	alter table orden_lineas_ajustes disable trigger all ;
	UPDATE orden_lineas SET producto_id = 767 WHERE producto_id = 70072  ;
	UPDATE orden_lineas_ajustes SET producto_id = 767 WHERE producto_id = 70072  ;
	UPDATE remito_linea_baul SET producto_id = 767 WHERE producto_id = 70072 ;
	alter table orden_lineas enable trigger all ;
	alter table orden_lineas_ajustes enable trigger all ;
	delete from productos where id = 70072  ;
	 
	 */
}
