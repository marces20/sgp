package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class FacturasMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar SolicitudLineaMigracion");
			 
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id," +
					" origin," +
					" comment," +
					" check_total," +
					" reference," +
					" number," +
					" partner_id," +
					" user_id," +
					" amount_tax," +
					" state," +
					" type," +
					" internal_number," +
					" account_id," +
					" reconciled," +
					" residual," +
					" date_invoice," +
					" period_id," +
					" amount_untaxed," +
					" amount_total," +
					" name," +
					" expediente_id,fecha_orden_pago,orden_pago,viatico,debe_dgr,debe_afip,contrato_personal,nro_planilla," +
					" purchase_id,profe,comprobante_pago,f_recepcion,partner_bank_id,"+
					" create_uid," +
					" create_date " +
					" from account_invoice ");
			
			  
			
			
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO facturas " +
						" (id,origen,comentario,total,referencia,numero,proveedor_id,usuario_id," +
						" monto_impuesto,estado,tipo,numero_factura,cuenta_id,conciliado,residual," +
						" fecha_factura,periodo_id,monto_sin_impuesto,monto_total,nombre," +
						" expediente_id,fecha_orden_pago,numero_orden_pago,viatico,debe_dgr,debe_afip,contrato_personal,numero_planilla," +
						" orden_id,profe,comprobante_pago,fecha_recepcion,cuenta_bancaria_id" +
						" ,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				 
				  
				stmt2.setLong(1, rs.getLong(1));//id
				stmt2.setString(2, rs.getString(2));//origen
				stmt2.setString(3, rs.getString(3));//comentario
				stmt2.setBigDecimal(4, rs.getBigDecimal(4));//total
				stmt2.setString(5, rs.getString(5));//referencia
				stmt2.setString(6, rs.getString(6));//numero
				if(rs.getLong(7) == 0){
					stmt2.setNull(7,0);
				}else{
					stmt2.setLong(7, rs.getLong(7));
				}
				if(rs.getLong(8) == 0 || rs.getLong(8) == 129){
					stmt2.setNull(8,0);
				}else{
					stmt2.setLong(8, rs.getLong(8));
				}
				
				stmt2.setBigDecimal(9, rs.getBigDecimal(9));//monto_impuesto
				stmt2.setString(10, rs.getString(10));//estado
				stmt2.setString(11, rs.getString(11));//tipo
				stmt2.setString(12, rs.getString(12));//numero_factura
				if(rs.getLong(13) == 0){
					stmt2.setNull(13,0);
				}else{
					stmt2.setLong(13, rs.getLong(13));
				}
				stmt2.setBoolean(14, rs.getBoolean(14));  //conciliado
				stmt2.setBigDecimal(15, rs.getBigDecimal(15));  //residual
				stmt2.setDate(16, rs.getDate(16));  //fecha_factura
				stmt2.setLong(17, rs.getLong(17));    //periodo_id
				if(rs.getLong(17) == 0){
					stmt2.setNull(17,0);
				}else{
					stmt2.setLong(17, rs.getLong(17));
				}
				stmt2.setBigDecimal(18, rs.getBigDecimal(18));     //monto_sin_impuesto
				stmt2.setBigDecimal(19, rs.getBigDecimal(19)); //monto_total  
				stmt2.setString(20, rs.getString(20));//nombre
				if(rs.getLong(21) == 0){
					stmt2.setNull(21,0);
				}else{
					stmt2.setLong(21, rs.getLong(21));
				}
				stmt2.setDate(22, rs.getDate(22));  //fecha_orden_pago
				stmt2.setLong(23, rs.getLong(23));   
				stmt2.setBoolean(24, rs.getBoolean(24));  
				stmt2.setBoolean(25, rs.getBoolean(25));  
				stmt2.setBoolean(26, rs.getBoolean(26));  
				stmt2.setBoolean(27, rs.getBoolean(27));  
				stmt2.setLong(28, rs.getLong(28));     
				if(rs.getLong(29) == 0){
					stmt2.setNull(29,0);
				}else{
					stmt2.setLong(29, rs.getLong(29));
				}
				stmt2.setBoolean(30, rs.getBoolean(30));     
				stmt2.setString(31, rs.getString(31));   
				stmt2.setDate(32, rs.getDate(32));   
				if(rs.getLong(33) == 0){
					stmt2.setNull(33,0);
				}else{
					stmt2.setLong(33, rs.getLong(33));
				}
				if(rs.getLong(34) == 0 || rs.getLong(34) == 129){
					stmt2.setNull(34,0);
				}else{
					stmt2.setLong(34, rs.getLong(34));
				}
				stmt2.setDate(35, rs.getDate(35));
				
				stmt2.executeUpdate();
				
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
	}
}
