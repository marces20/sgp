package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class SolicitudLineaMigracion {
	
	public boolean migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar SolicitudLineaMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" l.id,product_uom_id,l.product_qty,l.requisition_id,l.product_id,l.cuenta_analitica_id,l.precio_estimado,"+
					" l.create_uid," +
					" l.create_date " +
					" from purchase_requisition_line l " +
					" INNER JOIN purchase_requisition pr ON pr.id = l.requisition_id " +
					" LEFT join adop_expediente e on e.id = pr.expediente_id " +
					" LEFT join account_fiscalyear a on a.id = e.ejercicio_id " +
					" WHERE (pr.create_date >= '2014-01-01' or a.id = 3) " +
					" AND " +
					" pr.expediente_id not in (1605,1606,1607,1608,1609,1610,1612,1613, " +
					" 1614,1616,1617,1618,1619,1620,1621,1622, " +
					" 1623,1625,1626,1627,1628,1644,1665,1828, " +
					" 1829,5181,5182,5201,5202,5221,5222,5241, " +
					" 5261,5262,5263,5281,5282,5301,5302,5303, " +
					" 5321,5341) ");
					
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			
			
			
			while (rs.next()) {
				stmt3 = conn2.prepareStatement("select * from solicitud_lineas where id = ?");
				stmt3.setLong(1, rs.getLong(1));
				ResultSet rs3 = stmt3.executeQuery();
				if(!rs3.next()){
					System.out.print('1');
					 stmt2 = conn2.prepareStatement("INSERT INTO solicitud_lineas " +
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
				}else{
					System.out.println("la linea id "+rs.getLong(1)+" ya esta cargada");
				}
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar SolicitudLineaMigracion");
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
