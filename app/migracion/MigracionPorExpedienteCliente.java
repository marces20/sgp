package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import server.Configuracion2;
import server.Configuration;

public class MigracionPorExpedienteCliente {
	
	public boolean cliente(Long idCliente){
		
		Connection conn = null;
		Connection conn2 = null;
		
		try {
			System.out.println("Empezo a migrar ClientesMigracion");
			conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	
        	PreparedStatement stmt0 = conn2.prepareStatement("SELECT * FROM migracion_clientes m " +
        			"INNER JOIN clientes c ON c.id = m.id_new " +
        			"WHERE m.id_soltic = ? ");
        	stmt0.setLong(1,idCliente);
        	ResultSet rs0 = stmt0.executeQuery();
        	
        	if(!rs0.next()){
	        	PreparedStatement stmt = conn.prepareStatement("SELECT " +
	        			" ru.id," +
	        			" ru.name,"+
	        			" ru.active," +
	        			" ru.ref," +
	        			" replace(ru.cuit, ' ', '') c, "+
	        			" ru.create_uid," +
						" ru.create_date" +
	        			" FROM res_partner ru " +
	        			" WHERE  id = ? ");
	        	stmt.setLong(1, idCliente);
	        	ResultSet rs = stmt.executeQuery();
	        	PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
			 
				while (rs.next()) {
					 
					stmt2 = conn2.prepareStatement("INSERT INTO clientes " +
							" (nombre,activo,referencia,referencia_2,create_usuario_id,create_date,id_paciente_rismi)" +
							" VALUES (?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
					
					stmt2.setString(1, rs.getString(2));
					stmt2.setBoolean(2, rs.getBoolean(3));
					stmt2.setString(3, rs.getString(4));
					stmt2.setString(4, rs.getString(5));
					stmt2.setLong(5, rs.getLong(6));
					stmt2.setDate(6, rs.getDate(7));
					stmt2.setString(7, rs.getString(4));
					stmt2.executeUpdate();
					
					ResultSet rsstmt2 = stmt2.getGeneratedKeys();
					int generatedkey=0;
				    if (rsstmt2.next()) {
				       generatedkey=rsstmt2.getInt(1); 
				       stmt3 = conn2.prepareStatement("INSERT INTO migracion_clientes (id_soltic,id_new) VALUES (?,?) ");
				       stmt3.setLong(1, rs.getLong(1));
				       stmt3.setLong(2,generatedkey);
				       stmt3.executeUpdate();
				    
				       PreparedStatement stmtDires = conn.prepareStatement("select " +
							" ru.id,ru.partner_id,"+
							" ru.street," +
							" ru.active," +
							" ru.city," +
							" ru.name," +
							" ru.zip," +
							" ru.country_id," +
							" ru.state_id," +
							" ru.localidad_id," +
							" ru.email," +
							" ru.numero," +
							" ru.phone," +
							" ru.fax," +
							" ru.mobile," +
							" ru.create_date," +
							" ru.create_uid " +
							" from res_partner_address ru where partner_id = ? ");
					    stmtDires.setLong(1, rs.getLong(1));
					    ResultSet rsD = stmtDires.executeQuery();
						
						while (rsD.next()) {
							PreparedStatement stmt5 = conn2.prepareStatement("INSERT INTO clientes_direcciones " +
									" (cliente_id,calle,activo,ciudad,nombre,zip,pais_id,provincia_id," +
									"  localidad_id,email,numero,telefono,fax,mobile,create_date,create_usuario_id)" +
									" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							
							stmt5.setLong(1, generatedkey);
							stmt5.setString(2, rsD.getString(3));
							stmt5.setBoolean(3, rsD.getBoolean(4));
							stmt5.setString(4, rsD.getString(5));
							stmt5.setString(5, rsD.getString(6));
							stmt5.setString(6, rsD.getString(7));
							 
							if(rsD.getLong(8) == 0){
								stmt5.setNull(7,0);
							}else{
								stmt5.setLong(7, rsD.getLong(8));
							}
							if(rsD.getLong(9) == 0){
								stmt5.setNull(8,0);
							}else{
								stmt5.setLong(8, rsD.getLong(9));
							}
							if(rsD.getLong(10) == 0){
								stmt5.setNull(9,0);
							}else{
								stmt5.setLong(9, rsD.getLong(10));
							}
							stmt5.setString(10, rsD.getString(11));
							stmt5.setString(11, rsD.getString(12));
							stmt5.setString(12, rsD.getString(13));
							stmt5.setString(13, rsD.getString(14));
							stmt5.setString(14, rsD.getString(15));
							stmt5.setDate(15, rsD.getDate(16));
							stmt5.setLong(16, rsD.getLong(17));
							stmt5.executeUpdate();
						
						}
				    }
				
				}
        	}
			
		} catch (SQLException e) {
            play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		
		
		return true;
	}
}
