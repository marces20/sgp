package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class SolicitudLineaAjusteMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar SolicitudLineaAjusteMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id,product_uom_id,product_qty,requisition_id,product_id,cuenta_analitica_id,precio_estimado,"+
					" create_uid," +
					" create_date " +
					" from purchase_requisition_line_ajuste ");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO solicitud_linea_ajustes " +
						" (id,udm_id,cantidad,solicitud_id,producto_id,cuenta_analitica_id,precio_estimado,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?)");
				stmt2.setLong(1, rs.getLong(1));
				if(rs.getLong(2) == 0){
					stmt2.setNull(2,0);
				}else{
					stmt2.setLong(2, rs.getLong(2));
				}
				stmt2.setBigDecimal(3, rs.getBigDecimal(3));
				stmt2.setLong(4, rs.getLong(4));
				if(rs.getLong(5) == 0){
					stmt2.setNull(5,0);
				}else{
					stmt2.setLong(5, rs.getLong(5));
				}
				if(rs.getLong(6) == 0){
					stmt2.setNull(6,0);
				}else{
					stmt2.setLong(6, rs.getLong(6));
				}
				stmt2.setBigDecimal(7, rs.getBigDecimal(7));
				stmt2.setLong(8, rs.getLong(8));
				stmt2.setDate(9, rs.getDate(9));
				
				stmt2.executeUpdate();
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar SolicitudLineaAjusteMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
