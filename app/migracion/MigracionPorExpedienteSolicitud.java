package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.Logger;

import server.Configuracion2;
import server.Configuration;

public class MigracionPorExpedienteSolicitud {
	
	public boolean solicitud(Integer idExpediente,String creacionAutomatica){
		Connection conn = null;
		Connection conn2 = null;
		
		try {
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
			
			System.out.println("Empezo a migrar Solicitud");
			PreparedStatement stmt = conn.prepareStatement("SELECT " +
					" p.id,p.origin,p.user_id,p.description,p.warehouse_id,p.state,p.name," +
					" p.dirigida_a,p.expediente_id,p.fecha_imputacion,p.contrato_personal," +
					" p.prioridad,p.patient_id,p.profe,p.hr_department_id," +
					" p.creacion_orden_compra,p.date_end,p.date_start,"+
					" p.create_uid," +
					" p.create_date,p.exclusive " +
					" FROM purchase_requisition p" +
					" LEFT join adop_expediente e on e.id = p.expediente_id " +
					" LEFT join account_fiscalyear a on a.id = e.ejercicio_id " +
					" WHERE " +
					//" p.name = 'TE17893' " +

					" p.expediente_id in (?) " +
					//" p.id in(4388) "+	
					//"  (p.create_uid = 63) AND TO_CHAR(p.create_date, 'YYYY') = '2014' " +
					//"and p.id not in (8896,8871,8898) " +
					//" and (p.state = 'en_curso' or p.state = 'aprobado_js' or p.state = 'aprobado_jd') "+
					" ORDER BY p.create_date desc ");
			stmt.setInt(1,idExpediente);
			
			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			 		while (rs.next()) {
						
						PreparedStatement stmtx = conn2.prepareStatement(" SELECT id FROM solicitudes WHERE id = ? ");
						stmtx.setLong(1,rs.getLong(1));
						ResultSet rsx = stmtx.executeQuery();
						if(!rsx.next()){
						
						
						stmt2 = conn2.prepareStatement("INSERT INTO solicitudes " +
								" (id,origen,usuario_id,descripcion,deposito_id,estado,referencia," +
								" dirigida,expediente_id,fecha_imputacion,contrato_personal,prioridad,cliente_id," +
								" profe,departamento_id,creacion_orden_compra,date_end,date_start," +
								" create_usuario_id,create_date,tipo_solicitud,state_id,referencia_sigpar)" +
								" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,?)");
						
						stmt2.setLong(1, rs.getLong(1));
						stmt2.setString(2, rs.getString(2));
						if(rs.getLong(3) == 0 || rs.getLong(3) == 129){
							stmt2.setNull(3,0);
						}else{
							stmt2.setLong(3, rs.getLong(3));
						}
						stmt2.setString(4, rs.getString(4));
						
						if(rs.getLong(5) == 0){
							stmt2.setNull(5,0);
						}else{
							stmt2.setLong(5, rs.getLong(5));
						}
					
						stmt2.setString(6, rs.getString(6));
						stmt2.setString(7, rs.getString(7));
						stmt2.setString(8, rs.getString(8));
					
						if(rs.getLong(9) == 0){
							stmt2.setNull(9,0);
						}else{
							MigracionPorExpedienteExpediente mee = new MigracionPorExpedienteExpediente();
							mee.migrar(rs.getLong(9));
							stmt2.setLong(9, rs.getLong(9));
						}
						stmt2.setDate(10, rs.getDate(10));
						stmt2.setBoolean(11, rs.getBoolean(11));
						stmt2.setString(12, rs.getString(12));
				
				
						if(rs.getLong(13) != 0){
							
							MigracionPorExpedienteCliente mec = new MigracionPorExpedienteCliente();
							mec.cliente(rs.getLong(13));
							
							PreparedStatement stmt4 = conn2.prepareStatement("SELECT id_new FROM migracion_clientes WHERE id_soltic = ?");
							stmt4.setLong(1,rs.getLong(13));
							ResultSet rs4 = stmt4.executeQuery();
							
							if(rs4.next()){
								if(rs4.getLong(1) == 0){
									stmt2.setNull(13,0);
								}else{
									stmt2.setLong(13, rs4.getLong(1));
								}
							}else{
								stmt2.setNull(13,0);
							}
						}else{
							stmt2.setNull(13,0);
						}
				
						stmt2.setBoolean(14, rs.getBoolean(14));
						if(rs.getLong(15) == 0){
							stmt2.setNull(15,0);
						}else{
							stmt2.setLong(15, rs.getLong(15));
						}
						
						//stmt2.setString(16, rs.getString(16));
						stmt2.setString(16, creacionAutomatica);
						
						
						stmt2.setDate(17, rs.getDate(17));
						stmt2.setDate(18, rs.getDate(18));
						if(rs.getLong(19) == 0 || rs.getLong(19) == 129){
							stmt2.setNull(19,0);
						}else{
							stmt2.setLong(19, rs.getLong(19));
						}
						stmt2.setDate(20, rs.getDate(20));
						stmt2.setString(21, rs.getString(21));
						
						stmt2.setString(22, rs.getString(7));
						
						stmt2.executeUpdate();
						
						migrarLineas(rs.getLong(1));
						
						cambiarEstado(rs.getString(6),rs.getLong(1));
					}else{
						System.out.println("yaaaa estaaa "+rs.getString(7));
						
						PreparedStatement stmtx2 = conn2.prepareStatement(" UPDATE solicitudes SET referencia_sigpar = ? WHERE id = ? ");
						stmtx2.setString(1,rs.getString(7));
						stmtx2.setLong(2,rs.getLong(1));
						stmtx2.executeUpdate();
					}
				}
			
			
			if (rs != null) try { rs.close(); } catch (Exception e) { }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (stmt2 != null) try { stmt2.close(); } catch (Exception e) { }
			System.out.println("Termino a migrar SolicitudMigracion");
			
		} catch (SQLException e) {
            play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }	
       
		
		return true;
	}
	
	public boolean migrarLineas(Long idSolicitud){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar SolicitudLineaMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	
			PreparedStatement stmt = conn.prepareStatement("select " +
					" l.id,product_uom_id,l.product_qty,l.requisition_id,l.product_id,l.cuenta_analitica_id,l.precio_estimado,"+
					" l.create_uid," +
					" l.create_date " +
					" from purchase_requisition_line l " +
					" INNER JOIN purchase_requisition pr ON pr.id = l.requisition_id " +
					" LEFT join adop_expediente e on e.id = pr.expediente_id " +
					" LEFT join account_fiscalyear a on a.id = e.ejercicio_id " +
					" WHERE requisition_id = ? ");
					
			stmt.setLong(1,idSolicitud);

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			
			while (rs.next()) {
				stmt3 = conn2.prepareStatement("select * from solicitud_lineas where id = ?");
				stmt3.setLong(1, rs.getLong(1));
				ResultSet rs3 = stmt3.executeQuery();
				if(!rs3.next()){
					 
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
					
					if(rs.getLong(5) == 0){//Producto
						stmt2.setNull(5,0);
					}else{
						MigracionPorExpedienteProducto mp = new MigracionPorExpedienteProducto();
						mp.migrar(rs.getLong(5));
						stmt2.setLong(5, rs.getLong(5));
					}
					
					if(rs.getLong(6) == 0){
						stmt2.setNull(6,0);
					}else{
						Long ca = rs.getLong(6);
						
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
						
						stmt2.setLong(6, ca);
					}
					stmt2.setBigDecimal(7, rs.getBigDecimal(7));
					stmt2.setLong(8, rs.getLong(8));
					stmt2.setDate(9, rs.getDate(9));
					
					stmt2.executeUpdate();
				}else{
					System.out.println("la linea id "+rs.getLong(1)+" ya esta cargada");
				}
				
			}
			if(stmt2 != null){
				stmt2.close();
			}
			
			rs.close();
			stmt.close();
			
			System.out.println("Termino a migrar SolicitudLineaMigracion");
        } catch (SQLException e) {
            play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		
		return true;
	}
	
	public boolean cambiarEstado(String estado,Long idSolicitud){
		Connection conn = null;
		Connection conn2 = null;

		try {
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	
			PreparedStatement stmt2b =  conn2.prepareStatement("UPDATE solicitudes SET state_id = ? where id = ? ");
			if(estado.compareToIgnoreCase("finalizado") == 0){
				
				stmt2b.setLong(1, new Long(1));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();//Borrador
				
				stmt2b.setLong(1, new Long(2));
				stmt2b.setLong(2,idSolicitud);
				stmt2b.executeUpdate();//en curso
				
				stmt2b.setLong(1, new Long(22));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();//aprobador por jefe de depto
				
				stmt2b.setLong(1, new Long(3));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();//aprobador por administracion
				
				stmt2b.setLong(1, new Long(4));
				stmt2b.setLong(2,idSolicitud);
				stmt2b.executeUpdate();//aprobador por presupuesto
				
				stmt2b.setLong(1, new Long(5));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();//autorizado
			}
			if(estado.compareToIgnoreCase("cancelado") == 0){
				
				stmt2b.setLong(1, new Long(6));
				stmt2b.setLong(2, idSolicitud);
			}
			if(estado.compareToIgnoreCase("en_curso") == 0){
				
				stmt2b.setLong(1, new Long(2));
				stmt2b.setLong(2,idSolicitud);
			}
			if(estado.compareToIgnoreCase("confirmado") == 0){
				stmt2b.setLong(1, new Long(2));
				stmt2b.setLong(2,idSolicitud);
				stmt2b.executeUpdate();//en curso
				
				stmt2b.setLong(1, new Long(22));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();//aprobador por jefe de servicio
				
				stmt2b.setLong(1, new Long(3));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();//aprobador por administracion
				
				stmt2b.setLong(1, new Long(4));
				stmt2b.setLong(2,idSolicitud);
				stmt2b.executeUpdate();//aprobador por presupuesto
			}
			if(estado.compareToIgnoreCase("aprobado_js") == 0){
				stmt2b.setLong(1, new Long(2));
				stmt2b.setLong(2,idSolicitud);
				stmt2b.executeUpdate();//en curso
				
				stmt2b.setLong(1, new Long(22));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();//aprobador por jefe de servicio
				
			}
			
			if(estado.compareToIgnoreCase("aprobado_jd") == 0){
				stmt2b.setLong(1, new Long(49));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();
			}
			
			if(estado.compareToIgnoreCase("aprobado_adm") == 0 || estado.compareToIgnoreCase("aprobado_ger") == 0){
				stmt2b.setLong(1, new Long(2));
				stmt2b.setLong(2,idSolicitud);
				stmt2b.executeUpdate();//en curso
				
				stmt2b.setLong(1, new Long(22));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();//aprobador por jefe de servicio
				
				stmt2b.setLong(1, new Long(3));
				stmt2b.setLong(2, idSolicitud);
				stmt2b.executeUpdate();//aprobador por administracion
			}
			
			/*
			 	"finalizado"X
				"cancelado"X
				"aprobado_adm"X
				"aprobado_js"X
				"borrador"S
				"aprobado_ger"X
				"confirmado"X
				"aprobado_jd"
				"en_curso"X
			 */
			
		} catch (SQLException e) {
            play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		
		return true;
	}	
}
