package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class EjercicioMigracion {
	public void migrar(){
		
		Connection conn = null;
		Connection conn2 = null;

		try {
			
			System.out.println("Empezo a migrar EjercicioMigracion");
			
        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name," +
					" ru.code,ru.state,ru.date_start,ru.date_stop,"+
					" ru.create_uid, " +
					" ru.create_date" +
					" from account_fiscalyear ru");
			

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;
			
			/*
				id serial NOT NULL,
				name character varying(64) NOT NULL, -- Fiscal Year
				code character varying(6) NOT NULL, -- Code
				state character varying(16), -- State
				date_start date NOT NULL, -- Start Date
				date_stop date NOT NULL, -- End Date
			  create_uid integer,
			  create_date timestamp without time zone,
			  write_date timestamp without time zone,
			  write_uid integer,
			*/
			
			while (rs.next()) {
				System.out.print('1');
				 stmt2 = conn2.prepareStatement("INSERT INTO ejercicios " +
						" (id,nombre,code,estado,date_start,date_stop,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?,?)");
				stmt2.setLong(1, rs.getLong(1));
				stmt2.setString(2, rs.getString(2));
				stmt2.setString(3, rs.getString(3));
				stmt2.setString(4, rs.getString(4));
				stmt2.setDate(5, rs.getDate(5));
				stmt2.setDate(6, rs.getDate(6));
				stmt2.setLong(7, rs.getLong(7));
				stmt2.setDate(8, rs.getDate(8));
				
				stmt2.executeUpdate();
			
			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar EjercicioMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
