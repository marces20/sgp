package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import server.Configuracion2;
import server.Configuration;

public class OrdenMigracion {
	
	public void migrar(int idExpediente){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar OrdenMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	
			PreparedStatement stmt = conn.prepareStatement("SELECT " +
					" id,origin,warehouse_id,partner_ref,date_order,date_approve,amount_untaxed,name,shipped,partner_id," +
					" notes,amount_tax,state,amount_total,requisition_id,subparcial,contra_periodica,order_provision," +
					" fecha_provision,f_inicio_contrato,f_fin_contrato,expediente_id,tipo_contratacion,contrato_personal," +
					" profe,certificacion_servicio,acta_recepcion,acta_comite,tilde_orden,orden_provision,period_id,"+
					" create_uid," +
					" create_date " +
					" FROM purchase_order WHERE expediente_id = ?");
			 
			stmt.setInt(1,idExpediente);

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				
				stmt2 = conn2.prepareStatement("INSERT INTO ordenes " +
						" (id," +
						"origen," +
						"deposito_id," +
						"fecha_orden," +
						"fecha_aprovada," +
						" nombre," +
						"recibido," +
						"proveedor_id," +
						"estado," +
						"monto_total," +
						"solicitud_id," +
						"subparcial," +
						"contra_periodica," +
						"orden_provision," +
						"fecha_provision," +
						"fecha_inicio," +
						"fecha_fin," +
						"expediente_id," +
						"tipo_contratacion," +
						"contrato_personal," +
						"profe," +
						"certificacion_servicio," +
						"acta_recepcion," +
						"acta_comite," +
						"tilde_orden," +
						"numero_orden_provision," +
						"periodo_id," +
						"create_usuario_id," +
						"create_date," +
						"state_id)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?," +
								 "?,?,?,?,?,?,?,?,?,?," +
								 "?,?,?,?,?,?,?,?,?,?)");
			
				 
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setString(2, rs.getString(2));
				if(rs.getLong(3) == 0){
					stmt2.setNull(3,0);
				}else{
					stmt2.setLong(3, rs.getLong(3));
				}
				//stmt2.setString(4, rs.getString(4));
				stmt2.setDate(4, rs.getDate(5));
				stmt2.setDate(5, rs.getDate(6));
				//stmt2.setBigDecimal(7, rs.getBigDecimal(7));
				stmt2.setString(6, rs.getString(8));
				stmt2.setBoolean(7, rs.getBoolean(9));
				
				if(rs.getLong(10) == 0){
					stmt2.setNull(8,0);
				}else{
					ProveedorMigracion pm = new ProveedorMigracion();
					pm.migrar(rs.getLong(10));
					stmt2.setLong(8, rs.getLong(10));
				}
				
				//stmt2.setString(11, rs.getString(11));
				//stmt2.setBigDecimal(12, rs.getBigDecimal(12));
				stmt2.setString(9, rs.getString(13));
				stmt2.setBigDecimal(10, rs.getBigDecimal(14));
				if(rs.getLong(15) == 0){
					stmt2.setNull(11,0);
				}else{
					stmt2.setLong(11, rs.getLong(15));
				}
				stmt2.setBoolean(12, rs.getBoolean(16));
				stmt2.setBoolean(13, rs.getBoolean(17));
				stmt2.setBoolean(14, rs.getBoolean(18));
				stmt2.setDate(15, rs.getDate(19));
				stmt2.setDate(16, rs.getDate(20));
				stmt2.setDate(17, rs.getDate(21));
				if(rs.getLong(22) == 0){
					stmt2.setNull(18,0);
				}else{
					stmt2.setLong(18, rs.getLong(22));
				}
				stmt2.setString(19, rs.getString(23)); 
				stmt2.setBoolean(20, rs.getBoolean(24));
				stmt2.setBoolean(21, rs.getBoolean(25));
				stmt2.setBoolean(22, rs.getBoolean(26));
				stmt2.setBoolean(23, rs.getBoolean(27));
				stmt2.setBoolean(24, rs.getBoolean(28));
				stmt2.setBoolean(25, rs.getBoolean(29));
				stmt2.setLong(26, rs.getLong(30));
				if(rs.getLong(31) == 0){
					stmt2.setNull(27,0);
				}else{
					stmt2.setLong(27, rs.getLong(31));
				}
				if(rs.getLong(32) == 0 || rs.getLong(32) == 129){
					stmt2.setNull(28,0);
				}else{
					stmt2.setLong(28, rs.getLong(32));
				}
				stmt2.setDate(29, rs.getDate(33));
				
				if(rs.getString(13).compareToIgnoreCase("cancel") == 0){
					stmt2.setLong(30, new Long(13));
				}else{
					stmt2.setLong(30, new Long(12));
				}
				
				stmt2.executeUpdate();
				
				migrarLineas(rs.getLong(1));
				
				PreparedStatement stmte = conn2.prepareStatement("SELECT id FROM solicitudes WHERE expediente_id = ?");
				stmte.setLong(1, idExpediente);
				ResultSet rse = stmte.executeQuery();
				PreparedStatement stmte2 = null;
				
				while (rse.next()) {
					stmte2 = conn2.prepareStatement("INSERT INTO ordenes_solicitudes(orden_id, solicitud_id) VALUES (?,?)");
					stmte2.setLong(1, rs.getLong(1));
					stmte2.setLong(2, rse.getLong(1));
					stmte2.executeUpdate();
				}
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar OrdenMigracion");
        } catch (SQLException e) {
            play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
	
	public void migrarLineas(Long idOrden){
		Connection conn = null;
		Connection conn2 = null;
		try {
			
			System.out.println("Empezo a migrar OrdenLineaMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	PreparedStatement stmt = conn.prepareStatement("SELECT " +
					" product_uom,order_id,price_unit,product_qty,partner_id," +
					" notes,product_id,account_analytic_id,hr_department_id," +
					" note,patient_id,laboratorio,name,"+
					" create_uid," +
					" create_date " +
					" FROM purchase_order_line WHERE order_id = ?");
			
        	stmt.setLong(1, idOrden);
			ResultSet rs = stmt.executeQuery();
			
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				
				 stmt2 = conn2.prepareStatement("INSERT INTO orden_lineas " +
						" (" +
						//"id," +
						"udm_id," +
						"orden_id," +
						"precio," +
						"cantidad," +
						"proveedor_id," +
						"nota," +
						"producto_id," +
						"cuenta_analitica_id," +
						" departamento_id," +
						"observacion," +
						"cliente_id," +
						"laboratorio," +
						"nombre," +
						"create_usuario_id," +
						"create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				//stmt2.setLong(1, rs.getLong(1));
				if(rs.getLong(1) == 0){
					stmt2.setNull(1,0);
				}else{
					stmt2.setLong(1, rs.getLong(1));
				}
				stmt2.setLong(2, rs.getLong(2));
				stmt2.setBigDecimal(3, rs.getBigDecimal(3));
				stmt2.setBigDecimal(4, rs.getBigDecimal(4));
				stmt2.setNull(5,0);
				/*if(rs.getLong(5) == 0){
					
				}else{
					stmt2.setLong(5, rs.getLong(5));
				}*/
				stmt2.setString(6, rs.getString(6));
				
				
				if(rs.getLong(7) == 0){
					stmt2.setNull(7,0);
				}else{
					MigracionPorExpedienteProducto mp = new MigracionPorExpedienteProducto();
					mp.migrar(rs.getLong(7));
					stmt2.setLong(7, rs.getLong(7));
				}
				if(rs.getLong(8) == 0){
					stmt2.setNull(8,0);
				}else{
					Long ca = rs.getLong(8);
					
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
					stmt2.setLong(8, ca);
				}
				
				if(rs.getLong(9) == 0){
					stmt2.setNull(9,0);
				}else{
					stmt2.setLong(9, rs.getLong(9));
				}
				stmt2.setString(10, rs.getString(10));
				if(rs.getLong(11) == 0){
					stmt2.setNull(11,0);
				}else{
					
					PreparedStatement stmtp = conn2.prepareStatement("SELECT id_new FROM migracion_clientes WHERE id_soltic = ? ");
					stmtp.setLong(1, rs.getLong(11));
					ResultSet rsp = stmtp.executeQuery();
					if(rsp.next()){
						stmt2.setLong(11, rsp.getLong(1));
					}else{
						stmt2.setNull(11,0);
					}
					
				}
				stmt2.setString(12, rs.getString(12));
				stmt2.setString(13, rs.getString(13));
				
				if(rs.getLong(14) == 0 || rs.getLong(14) == 129){
					stmt2.setNull(14,0);
				}else{
					stmt2.setLong(14, rs.getLong(14));
				}
				stmt2.setDate(15, rs.getDate(15));
				
				stmt2.executeUpdate();
				ResultSet keyset = stmt2.getGeneratedKeys();
				
				if(keyset.next()){
					
					PreparedStatement stmtp = conn2.prepareStatement("SELECT id_new FROM migracion_clientes WHERE id_soltic = ? ");
					stmtp.setLong(1, rs.getLong(11));
					ResultSet rsp = stmtp.executeQuery();
					if(rsp.next()){
						PreparedStatement stmtc = conn2.prepareStatement("INSERT INTO orden_linea_clientes (cliente_id,orden_linea_id,cantidad) " +
								"VALUES (?,?,?)");
						stmtc.setLong(1, rsp.getLong(1));
						stmtc.setInt(2, keyset.getInt(18));
						stmtc.setBigDecimal(3, rs.getBigDecimal(4));
						stmtc.executeUpdate();
					}
				}
			}
			
			
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar OrdenLineaMigracion");
        } catch (SQLException e) {
            play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
	 
}
