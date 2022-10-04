package migracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;

public class debedgr {
	public boolean insertar() throws IOException{
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a insertar insertarSellos");
		BufferedReader br = null;
		String csvFile = "/home/marce/working/play-2.2.1/sgp/conf/resources/csv/debedgr.csv";
		String line = "";
		String cvsSplitBy = "@";
		int c = 0;
		int r = 0;
		
		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			
			while ((line = br.readLine()) != null) {
	 
			    String[] linea = line.split(cvsSplitBy);
			    
			    System.out.println(linea[0] +" ");
	 
			    conn2 = Configuracion2.get2().getConnection2();
				PreparedStatement stmt = conn2.prepareStatement("SELECT f.id FROM facturas f " +
						"INNER JOIN proveedores p ON p.id = f.proveedor_id " +
						"WHERE p.cuit = "+linea[0]+" AND f.periodo_id = ?");
				
				stmt.setInt(1, new Integer(34));
				
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					PreparedStatement stmt2 = conn2.prepareStatement("UPDATE facturas SET debe_dgr = true WHERE id = ?");
					stmt2.setInt(1, rs.getInt(1));
					stmt2.executeUpdate();
					stmt2.close();
					r++;
				}
				c++;
				stmt.close();
				conn2.close();
			}
			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Termino a insert ActualizarCuentaPagos");
		System.out.println("bucle "+c);
		System.out.println("insert "+r);
		
		return true;
	}
}
