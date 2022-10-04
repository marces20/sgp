package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class OrdenLineaMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;
		/*
		 * 
		 * 
		 * 
		 * 
		 * QUERYYYY ANTESSSS NO EXISTE LOS PARTNER_ID Q TIENEN CARGADOS ALGUNOS
		 * 
		 * 
		 * update purchase_order_line set partner_id = null where id in( 
			select id from purchase_order_line where partner_id not in(select id from res_partner))
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		try {
			
			System.out.println("Empezo a migrar OrdenLineaMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id,product_uom,order_id,price_unit,product_qty,partner_id," +
					" notes,state,product_id,account_analytic_id,hr_department_id," +
					" note,patient_id,laboratorio,name,"+
					" create_uid," +
					" create_date " +
					" from purchase_order_line ");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO orden_lineas " +
						" (id,udm_id,orden_id,precio,cantidad,proveedor_id,nota,estado,producto_id,cuenta_analitica_id," +
						" departamento_id,observacion,cliente_id,laboratorio,nombre,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				stmt2.setLong(1, rs.getLong(1));
				if(rs.getLong(2) == 0){
					stmt2.setNull(2,0);
				}else{
					stmt2.setLong(2, rs.getLong(2));
				}
				stmt2.setLong(3, rs.getLong(3));
				stmt2.setBigDecimal(4, rs.getBigDecimal(4));
				stmt2.setBigDecimal(5, rs.getBigDecimal(5));
				if(rs.getLong(6) == 0){
					stmt2.setNull(6,0);
				}else{
					stmt2.setLong(6, rs.getLong(6));
				}
				stmt2.setString(7, rs.getString(7));
				stmt2.setString(8, rs.getString(8));
				stmt2.setLong(9, rs.getLong(9));
				if(rs.getLong(9) == 0){
					stmt2.setNull(9,0);
				}else{
					stmt2.setLong(9, rs.getLong(9));
				}
				if(rs.getLong(10) == 0){
					stmt2.setNull(10,0);
				}else{
					stmt2.setLong(10, rs.getLong(10));
				}
				
				if(rs.getLong(11) == 0){
					stmt2.setNull(11,0);
				}else{
					stmt2.setLong(11, rs.getLong(11));
				}
				stmt2.setString(12, rs.getString(12));
				if(rs.getLong(13) == 0){
					stmt2.setNull(13,0);
				}else{
					stmt2.setLong(13, rs.getLong(13));
				}
				stmt2.setString(14, rs.getString(14));
				stmt2.setString(15, rs.getString(15));
				stmt2.setLong(16, rs.getLong(16));
				if(rs.getLong(16) == 0 || rs.getLong(16) == 129){
					stmt2.setNull(16,0);
				}else{
					stmt2.setLong(16, rs.getLong(16));
				}
				stmt2.setDate(17, rs.getDate(17));
				
				stmt2.executeUpdate();
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar OrdenLineaMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
