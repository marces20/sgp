package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import server.Configuracion2;
import server.Configuration;

public class MigracionPorExpedienteFactura {
	
	public boolean factura(Long idExpediente,Long ordenId){
		
		Connection conn = null;
		Connection conn2 = null;
			
		try {
			System.out.println("Empezo a migrar facturas");
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
			
        	PreparedStatement stmt0 = conn.prepareStatement("SELECT " +
        			"create_uid,create_date,write_date,write_uid," +
        			"comment,partner_id,user_id," +
        			"state,type,reference,date_invoice," +
        			"period_id,name,expediente_id,fecha_orden_pago," +
        			"orden_pago,debe_dgr,debe_afip," +
        			"profe,account_id,id " +
        			"FROM account_invoice WHERE expediente_id = ? and type = 'in_invoice'");
        	
        	stmt0.setLong(1, idExpediente);
        	ResultSet rs0 = stmt0.executeQuery();
        	
        	while(rs0.next()){
        		PreparedStatement stmts = conn2.prepareStatement("SELECT nextval('facturas_id_seq')");
        		ResultSet rss = stmts.executeQuery();
        		if(rss.next()){
        			
        			int idFactura = rss.getInt(1);
	        		
        			PreparedStatement stmt = conn2.prepareStatement("INSERT INTO facturas " +
	        				"(create_usuario_id,create_date,write_date,write_usuario_id,"+
							 "comentario,proveedor_id,usuario_id,"+
							 "estado,tipo,numero_factura,fecha_factura,"+
							 "periodo_id,nombre,expediente_id,fecha_orden_pago,"+
							 "numero_orden_pago,debe_dgr,debe_afip,"+
							 "profe,cuenta_id," +
							 "state_id,orden_pago_id,creacion_automatica,orden_id,id) " +
	        				 "VALUES " +
	        				 "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        			
        			if(rs0.getLong(1) == 0 || rs0.getLong(1) == 129){stmt.setNull(1,0);}else{stmt.setLong(1, rs0.getLong(1));}
					stmt.setDate(2, rs0.getDate(2));
					stmt.setDate(3, rs0.getDate(3));
					if(rs0.getLong(4) == 0 || rs0.getLong(4) == 129){stmt.setNull(4,0);}else{stmt.setLong(4, rs0.getLong(4));}
					stmt.setString(5, rs0.getString(5));//comentario
					stmt.setLong(6, rs0.getLong(6));//proveedor
					stmt.setLong(7, rs0.getLong(7));//user
					stmt.setString(8, rs0.getString(8));//estado
					stmt.setString(9, rs0.getString(9));//tipo
					stmt.setString(10, rs0.getString(10));//numero factura
					stmt.setDate(11, rs0.getDate(11));//fecha_factura
					if(rs0.getLong(12) == 0){stmt.setNull(12,0);}else{stmt.setLong(12, rs0.getLong(12));}//periodo_id
					String nombre = "FAC"+idFactura;
					stmt.setString(13, nombre);//nombre
					if(rs0.getLong(14) == 0){stmt.setNull(14,0);}else{stmt.setLong(14, rs0.getLong(14));}//expediente_id
					stmt.setDate(15, rs0.getDate(15));//fecha_orden_pago
					stmt.setInt(16, rs0.getInt(16));//numero_orden_pago
					stmt.setBoolean(17, rs0.getBoolean(17));//debe_dgr
					stmt.setBoolean(18, rs0.getBoolean(18));//debe_afip
					stmt.setBoolean(19, rs0.getBoolean(19));//profe
					if(rs0.getLong(20) == 0){stmt.setNull(20,0);}else{stmt.setLong(20, rs0.getLong(20));}//cuenta_id
					stmt.setLong(21, 18);//state_id
					
					
					if(rs0.getInt(16) != 0){
						PreparedStatement stmt1 = conn2.prepareStatement("SELECT id FROM ordenes_pagos where numero = ? ");
						stmt1.setInt(1, rs0.getInt(16));
						ResultSet rs1 = stmt1.executeQuery();
						if(rs1.next()){
							stmt.setLong(22, rs1.getLong(1));//orden de pago
						}else{
							PreparedStatement stmtoi = conn2.prepareStatement("INSERT INTO ordenes_pagos (ejercicio_id,numero,fecha) VALUES " +
									"(3,?,?)",Statement.RETURN_GENERATED_KEYS);
							stmtoi.setInt(1, rs0.getInt(16));
							stmtoi.setDate(2, rs0.getDate(11));
							stmtoi.executeUpdate();
							ResultSet keyset = stmtoi.getGeneratedKeys();
							if(keyset.next()){
								int opId = keyset.getInt(1);
								stmt.setLong(22, opId);
							}
							if(keyset != null) try { keyset.close(); } catch (Exception e) { }
						}
					}else{
						stmt.setNull(22,0);
					}
					
					stmt.setBoolean(23, true);//creacion automatica
					stmt.setLong(24, ordenId);//orden id
					stmt.setInt(25, idFactura);
					stmt.executeUpdate();
        			
					facturaLinea(rs0.getInt(21),idFactura);
					facturaImpuestos(rs0.getInt(21),idFactura);
        		}
			}
        	if(rs0 != null) try { rs0.close(); } catch (Exception e) { }
        	
		} catch (SQLException e) {
            play.Logger.error("errror", e);
        } finally {
        	
        	/*if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }*/
        }
		
		
		return true;
	}	
	
	public boolean facturaLinea(int idFacturaSoltic,int idFacturaNew){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar FacturaLineaMigracion");
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	 
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id,uos_id,account_id,name,invoice_id,price_unit,price_subtotal,note," +
					" discount,account_analytic_id,quantity,partner_id,product_id,state,redondear,price_descuentos,"+
					" create_uid," +
					" create_date " +
					" from account_invoice_line where invoice_id = ? ");
			stmt.setInt(1,idFacturaSoltic);
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				stmt2 = conn2.prepareStatement("INSERT INTO factura_lineas " +
						" (udm_id,cuenta_id,nombre,factura_id,precio,precio_subtotal,nota,descuento,cuenta_analitica_id," +
						"  cantidad,proveedor_id,producto_id,precio_descuento,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				
				if(rs.getLong(2) == 0){
					stmt2.setNull(1,0);
				}else{
					stmt2.setLong(1, rs.getLong(2));
				}
				if(rs.getLong(3) == 0){
					stmt2.setNull(2,0);
				}else{
					stmt2.setLong(2, rs.getLong(3));
				}
				stmt2.setString(3, rs.getString(4));  
				stmt2.setLong(4, idFacturaNew);
				
				stmt2.setBigDecimal(5, rs.getBigDecimal(6));
				stmt2.setBigDecimal(6, rs.getBigDecimal(7));
				stmt2.setString(7, rs.getString(8));    
				stmt2.setBigDecimal(8, rs.getBigDecimal(9));  
				if(rs.getLong(10) == 0){
					stmt2.setNull(9,0);
				}else{
					Long ca = rs.getLong(10);
					
					if(ca == 255){
						ca = new Long(269);
					}else if(ca == 254){
						ca = new Long(268);
					}else if(ca == 251){
						ca = new Long(261);
					}else if(ca == 250){
						ca = new Long(260);
					}else if(ca == 249){
						ca = new Long(259);
					}else if(ca == 242){
						ca = new Long(255);
					}else if(ca == 241){
						ca = new Long(254);
					}else if(ca == 61){
						ca = new Long(266);
					}
					
					/*255 269
					254	268
					251	261
					250	260
					249	259
					242	255
					241	254*/		
					stmt2.setLong(9, ca);
				}
				stmt2.setDouble(10, rs.getDouble(11)); 
				
				
				if(rs.getLong(12) == 0 || rs.getLong(12) == 2515 || rs.getLong(12) ==1945 || rs.getLong(12) ==786 || rs.getLong(12) ==1491 || rs.getLong(12) ==2326 || rs.getLong(12) ==2423 || rs.getLong(12) ==2282 || rs.getLong(12) ==2548 || rs.getLong(12) ==2062 || rs.getLong(12) ==2052 || rs.getLong(12) ==1444 || rs.getLong(12) ==2213 || rs.getLong(12) ==2330 || rs.getLong(12) ==2422 || rs.getLong(12) ==2379 || rs.getLong(12) ==1594 || rs.getLong(12) ==2435){
					stmt2.setNull(11,0);
				}else{
					stmt2.setLong(11, rs.getLong(12));
				}
				
				if(rs.getLong(13) == 0){
					stmt2.setNull(12,0);
				}else{
					MigracionPorExpedienteProducto mp = new MigracionPorExpedienteProducto();
					mp.migrar(rs.getLong(13));
					stmt2.setLong(12, rs.getLong(13));
				}
				
				
				stmt2.setBigDecimal(13, rs.getBigDecimal(16));
				if(rs.getLong(17) == 0 || rs.getLong(17) == 129){
					stmt2.setNull(14,0);
				}else{
					stmt2.setLong(14, rs.getLong(17));
				}
				stmt2.setDate(15, rs.getDate(18));
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
        	
        }	
		
		return true;
	}
	
	public void facturaImpuestos(int idFacturaSoltic,int idFacturaNew){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar FacturaLineaImpuestoMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	 
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id,account_id,invoice_id,abs(amount)," +
					" create_uid," +
					" create_date,name " +
					" from account_invoice_tax where invoice_id = ?");
			stmt.setInt(1,idFacturaSoltic);
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				
														
				stmt2 = conn2.prepareStatement("INSERT INTO factura_linea_impuestos " +
						" (cuenta_id,factura_id,monto,create_usuario_id,create_date,nombre)" +
						" VALUES (?,?,?,?,?,?)");
				
				 
				if(rs.getLong(2) == 0){
					stmt2.setNull(1,0);
				}else{
					stmt2.setLong(1, rs.getLong(2));
				}
				
				stmt2.setLong(2, idFacturaNew);
				
				stmt2.setBigDecimal(3, rs.getBigDecimal(4));
				
				if(rs.getLong(5) == 0 || rs.getLong(5) == 129){
					stmt2.setNull(4,0);
				}else{
					stmt2.setLong(4, rs.getLong(5));
				}
				stmt2.setDate(5, rs.getDate(6));
				stmt2.setString(6, rs.getString(7));  
				stmt2.executeUpdate();
				
				
			}
			if(rs != null){rs.close();}
			if(stmt != null){stmt.close();}
			if(stmt2 != null){stmt2.close();}
			System.out.println("Termino a migrar FacturaLineaImpuestoMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
