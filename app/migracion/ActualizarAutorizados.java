package migracion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import models.ActaRecepcion;
import models.Estado;

public class ActualizarAutorizados {
	
	public boolean xxx(){
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a ActualizarAutorizados");
		try {
			conn2 = play.db.DB.getConnection();
			
			/*PreparedStatement stmt0 = conn2.prepareStatement("select proveedor_id,expediente_id,total_orden,orden_id,orden_provision_id " +
					"from informe_estadistico_deuda_proveedores " +
															"where total_orden = total_pagado " +
															"and orden_provision_id is not null " +
															"and total_deuda = 0 and total_compromiso = 0");*/
			
			PreparedStatement stmt0 = conn2.prepareStatement("select proveedor_id,expediente_id,total_orden,orden_id,orden_provision_id " +
															"from informe_estadistico_deuda_proveedores " +
															"where " +
															"total_actas = total_pagado " + 
															"and orden_provision_id is not null " + 
															//"and orden_id = 15208 ");
															"and total_actas <> 0 "+
															"and orden_id not in (select orden_id from autorizado_lineas)");
			ResultSet rs0 = stmt0.executeQuery();
			while (rs0.next()) {
				
				PreparedStatement stmtor = conn2.prepareStatement("SELECT * from autorizado_lineas WHERE orden_id = ? ");
				stmtor.setInt(1, rs0.getInt(4));
				ResultSet rssor = stmtor.executeQuery();
				
				if(rssor.next()){
				
				}else{
				
					PreparedStatement stmt3;
					PreparedStatement stmtu;
					PreparedStatement stmtsi = conn2.prepareStatement("SELECT nextval('autorizado_lineas_id_seq')");
	        		ResultSet rssi = stmtsi.executeQuery();
	        		
	        		if(rssi.next()){
	        			
	        			int idAutorizadoLinea = rssi.getInt(1);
						
	        			stmt3 = conn2.prepareStatement("INSERT INTO autorizado_lineas(autorizado_id, proveedor_id, expediente_id, monto, " +
	        					"orden_id,id,orden_provision_id) " +
		 			    "VALUES (2, ?, ?, ?, ?, ?, ?)");
						stmt3.setInt(1, rs0.getInt(1));
						stmt3.setInt(2, rs0.getInt(2));
						stmt3.setBigDecimal(3, rs0.getBigDecimal(3));//monto
						stmt3.setInt(4, rs0.getInt(4));
						stmt3.setInt(5, idAutorizadoLinea);
						stmt3.setInt(6, rs0.getInt(5));
						stmt3.executeUpdate();
						
						List<ActaRecepcion> ar = ActaRecepcion.find.where()
												 .eq("orden_provision_id",rs0.getInt(5))
												 .eq("estado_id", Estado.ACTA_ESTADO_APROBADA).findList();
						
						BigDecimal montoa = new BigDecimal(0);
						for(ActaRecepcion x : ar){
							PreparedStatement stmt4;
							stmt4 = conn2.prepareStatement("INSERT INTO autorizado_linea_actas(autorizado_linea_id, acta_recepcion_id, monto) VALUES (?, ?, ?)");
							stmt4.setInt(1, idAutorizadoLinea);
							stmt4.setLong(2, x.id);
							stmt4.setBigDecimal(3, x.getTotal().setScale(2, RoundingMode.HALF_DOWN));
							stmt4.executeUpdate();
							
							montoa = montoa.add(x.getTotal().setScale(2, RoundingMode.HALF_DOWN));
						}
						stmtu = conn2.prepareStatement("UPDATE autorizado_lineas SET monto=? WHERE id = ? ");
						stmtu.setBigDecimal(1, montoa);//monto
						stmtu.setInt(2, idAutorizadoLinea);
						stmtu.executeUpdate();
	        		}	
				}	
			}
			

			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
            
            try { if (conn2 != null) conn2.close(); } catch (Exception e2) { }
            
        }
		
		System.out.println("Termino a ActualizarAutorizados");
		
		return true;
	}
}
