package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class SolicitudMigracion {
	public boolean migrar(){
		
		Connection conn = null;
		Connection conn2 = null;
		/*select * from purchase_requisition p 
		LEFT join adop_expediente e on e.id = p.expediente_id
		LEFT join account_fiscalyear a on a.id = e.ejercicio_id
		where p.create_date >= '2014-01-01' or a.id = 3
		order by p.create_date desc*/
		
		/*
		 select count(*) from purchase_requisition p
left join adop_expediente a on a.id = p.expediente_id
left join account_fiscalyear f on f.id = a.ejercicio_id
where f.id = 3 or p.create_date >= '2014-01-01' 
		 
		 */
		try {
			
			System.out.println("Empezo a migrar SolicitudMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			/*PreparedStatement stmt = conn.prepareStatement("select " +
					" p.id,p.origin,p.user_id,p.description,p.warehouse_id,p.state,p.name," +
					" p.dirigida_a,p.expediente_id,p.fecha_imputacion,p.contrato_personal," +
					" p.prioridad,p.patient_id,p.profe,p.hr_department_id," +
					" p.creacion_orden_compra,p.date_end,p.date_start,"+
					" p.create_uid," +
					" p.create_date,p.exclusive " +
					" from purchase_requisition p" +
					" LEFT join adop_expediente e on e.id = p.expediente_id " +
					" LEFT join account_fiscalyear a on a.id = e.ejercicio_id " +
					" WHERE (p.create_date >= '2014-01-01' or a.id = 3) " +
					" AND " +
					" p.expediente_id not in (1605,1606,1607,1608,1609,1610,1612,1613, " +
					" 1614,1616,1617,1618,1619,1620,1621,1622, " +
					" 1623,1625,1626,1627,1628,1644,1665,1828, " +
					" 1829,5181,5182,5201,5202,5221,5222,5241, " +
					" 5261,5262,5263,5281,5282,5301,5302,5303, " +
					" 5321,5341) " +
					" order by p.create_date desc ");*/
	 
			
        	PreparedStatement stmt = conn.prepareStatement("select " +
					" p.id,p.origin,p.user_id,p.description,p.warehouse_id,p.state,p.name," +
					" p.dirigida_a,p.expediente_id,p.fecha_imputacion,p.contrato_personal," +
					" p.prioridad,p.patient_id,p.profe,p.hr_department_id," +
					" p.creacion_orden_compra,p.date_end,p.date_start,"+
					" p.create_uid," +
					" p.create_date,p.exclusive " +
					" from purchase_requisition p" +
					" LEFT join adop_expediente e on e.id = p.expediente_id " +
					" LEFT join account_fiscalyear a on a.id = e.ejercicio_id " +
					" WHERE (p.create_date >= '2014-01-01' or a.id = 3) " +
					" AND " +
					" p.expediente_id in (2059) " +
					" order by p.create_date desc ");

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO solicitudes " +
						" (id,origen,usuario_id,descripcion,deposito_id,estado,referencia," +
						" dirigida,expediente_id,fecha_imputacion,contrato_personal,prioridad,cliente_id," +
						" profe,departamento_id,creacion_orden_compra,date_end,date_start," +
						" create_usuario_id,create_date,tipo_solicitud,state_id)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
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
					stmt2.setLong(9, rs.getLong(9));
				}
				stmt2.setDate(10, rs.getDate(10));
				stmt2.setBoolean(11, rs.getBoolean(11));
				stmt2.setString(12, rs.getString(12));
				
				
				PreparedStatement stmt4 = conn2.prepareStatement("select id_new from migracion_clientes where id_soltic = ?");
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
				
				stmt2.setBoolean(14, rs.getBoolean(14));
				if(rs.getLong(15) == 0){
					stmt2.setNull(15,0);
				}else{
					stmt2.setLong(15, rs.getLong(15));
				}
				
				stmt2.setString(16, rs.getString(16));
				stmt2.setDate(17, rs.getDate(17));
				stmt2.setDate(18, rs.getDate(18));
				if(rs.getLong(19) == 0 || rs.getLong(19) == 129){
					stmt2.setNull(19,0);
				}else{
					stmt2.setLong(19, rs.getLong(19));
				}
				stmt2.setDate(20, rs.getDate(20));
				stmt2.setString(21, rs.getString(21));
				stmt2.executeUpdate();
				
				
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar SolicitudMigracion");
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
