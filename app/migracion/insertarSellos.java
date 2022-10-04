package migracion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;

public class insertarSellos {
	
	public boolean insertar() throws IOException{
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a insertar insertarSellos");
		BufferedReader br = null;
		
		String nameArc = "";Integer idExpediente = 0;
		//String nameArc = "0021.csv";Integer idExpediente = 1627;
		//String nameArc = "0022.csv";Integer idExpediente = 1628;
		//String nameArc = "0169.csv";Integer idExpediente = 1828;
		//String nameArc = "0170.csv";Integer idExpediente = 1829;
		//String nameArc = "0225.csv";Integer idExpediente = 5201;
		//String nameArc = "0226.csv";Integer idExpediente = 5202;
		//String nameArc = "0307.csv";Integer idExpediente = 5221;
		//String nameArc = "0308.csv";Integer idExpediente = 5222;
		//String nameArc = "0390.csv";Integer idExpediente = 5301;
		//String nameArc = "0401.csv";Integer idExpediente = 5303;
		//String nameArc = "0006.csv";Integer idExpediente = 1609;
		//String nameArc = "0009.csv";Integer idExpediente = 1613;
		//String nameArc = "0002.csv";Integer idExpediente = 1605;
		//String nameArc = "0182.csv";Integer idExpediente = 5181;
		//String nameArc = "0005.csv";Integer idExpediente = 1608;
		//String nameArc = "0011.csv";Integer idExpediente = 1616;
		//String nameArc = "0008.csv";Integer idExpediente = 1612;
		//String nameArc = "0003.csv";Integer idExpediente = 1606;
		//String nameArc = "0004.csv";Integer idExpediente = 1607;
		//String nameArc = "0007.csv";Integer idExpediente = 1610;
		
		String csvFile = "/home/marce/working/play-2.2.1/sgp/conf/resources/csv/"+nameArc;
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
						"WHERE p.cuit = "+linea[0]+" AND f.expediente_id = ? AND f.periodo_id = ?");
				
				stmt.setInt(1, new Integer(idExpediente));//0021
				
				stmt.setInt(2, new Integer(37));
				
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					PreparedStatement stmt2 = conn2.prepareStatement("INSERT INTO factura_linea_impuestos " +
							"(factura_id, cuenta_id,  monto,  base,nombre) " +
							"VALUES ( ?, ?, ?, ?,nextval('retencion_sellos_id_seq'))");
					stmt2.setInt(1, rs.getInt(1));
					stmt2.setInt(2, new Integer(263));
					stmt2.setDouble(3,new Double(linea[2]));
					stmt2.setDouble(4,new Double(linea[1]));
					
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
