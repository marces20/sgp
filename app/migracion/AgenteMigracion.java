package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class AgenteMigracion {
	public boolean migrar(){
		
		Connection conn = null;
		Connection conn2 = null;
		
		try{
			System.out.println("Empezo a migrar AgenteMigracion22");	
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	PreparedStatement stmt = conn.prepareStatement("select h.id,rp.id from hr_employee h " +
        			" INNER JOIN res_partner_address rpa ON rpa.id = h.address_home_id " +
        			" INNER JOIN res_partner rp ON rp.id = rpa.partner_id WHERE h.id in (1645)");
        	

        	ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			while (rs.next()) {
				System.out.print("1"); 
				stmt2 = conn2.prepareStatement("UPDATE proveedores SET agente_id = ? where id = ? ");
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setLong(2, rs.getLong(2));
				stmt2.executeUpdate();
			}

        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		 
		System.out.println("Termino a migrar AgenteMigracion22");  
		/*try {
			
			System.out.println("Empezo a migrar AgenteMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" id," +
					" apellido,nombre,licenseno,gender," +
					" birthday,estado_civil,fecha_ingreso,department_id," +
					" tipo_doc,especialidad_id,job_id,pin,bank_account_id,ssnid,localidad_nac,mobile_phone,user_id," +
					" create_uid, " +
					" create_date" +
					" from hr_employee where id in(1645) ");
			


			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			 
			 
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO agentes " +
						 " (" +
							" id,apellido,nombre,dni,sexo,fnacimiento," +
							"  estado_civil,fingreso,departamento_id,tipo_documento,especialidad_id," +
							"  puesto_id,pin,cuenta_bancaria,cuit,localidad_id,telefono,usuario_id," +
							" create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				 
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setString(2, rs.getString(2));
				stmt2.setString(3, rs.getString(3));
				stmt2.setString(4, rs.getString(4));
				stmt2.setString(5, rs.getString(5));
				stmt2.setDate(6, rs.getDate(6));
				stmt2.setString(7, rs.getString(7));
				stmt2.setDate(8, rs.getDate(8));
				if(rs.getLong(9) == 0){
					stmt2.setNull(9,0);
				}else{
					stmt2.setLong(9, rs.getLong(9));
				}
				
				stmt2.setString(10, rs.getString(10)); 
				if(rs.getLong(11) == 0){
					stmt2.setNull(11,0);
				}else{
					stmt2.setLong(11, rs.getLong(11));
				}
				if(rs.getLong(12) == 0){
					stmt2.setNull(12,0);
				}else{
					stmt2.setLong(12, rs.getLong(12));
				}
				stmt2.setString(13, rs.getString(13));  
				stmt2.setLong(14, rs.getLong(14)); 
				stmt2.setString(15, rs.getString(15));   
				if(rs.getLong(16) == 0){
					stmt2.setNull(16,0);
				}else{
					stmt2.setLong(16, rs.getLong(16));
				}
				stmt2.setString(17, rs.getString(17));  
				if(rs.getLong(18) == 0 || rs.getLong(18) == 97){
					stmt2.setNull(18,0);
				}else{
					stmt2.setLong(18, rs.getLong(18));
				}
				stmt2.setLong(19, rs.getLong(19));
				stmt2.setDate(20, rs.getDate(20));
				
				stmt2.executeUpdate();
			
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar AgenteMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        } */
		 
		return true;
	}
}
