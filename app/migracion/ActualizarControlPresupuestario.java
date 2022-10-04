package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 

import server.Configuracion2;

public class ActualizarControlPresupuestario {
	
	public boolean migrar(){
		boolean ret = false;
		//ret = certificaciones();
		//ret = pagos();\
		certificacionesSinDescuentos();
		return ret;
	}
	
	public boolean certificacionesSinDescuentos(){
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a migrar ActualizarControlPresupuestario");
		try {
			conn2 = play.db.DB.getConnection();
			
			
			PreparedStatement stmt0 = conn2.prepareStatement("select cert_id,debe,haber,id from controles_presupuestarios " +
					"where cert_id is not null and " +
					" cert_id not in (9057,1810,9148,9010,2929,1049,1725,2633) ");
					//"id in (20369,38254,38255,38277,38322,38335,38338,38339,38340,38341,38342,38343,38344,38345,41096,41099,41103,41107,41110,41111,41134,41167,41170,41173,34657,34687,34696,34698,34699,34787,34788,34706,34711,34729,20408,20603,20615,20671,20741,20772,20847,20850,20993,21071,21278,21544,21561,21621,21632,21701,21725,21739,21902,21964,21966,22048,22164,22168,22467,22598,22673,22675,22916,22992,23102,23287,23365,23382,23397,23596,23684,23704,23801,23852,23924,23936,23959,24102,24190,24206,24222,24284,24345,24396,24424,24533,24700,24703,25099,25204,25318,25546,25556,25590,25637,25676,25727,25736,25742,25920,25962,25963,39760,39762,39763,39764,39769,39771,39773,39774,39775,39777,39779,39780,39781,39782,39783,39784,39785,39786,39787,39788,39789,39790,39791,39792,39793,39794,39795,36373,36374,36375,36376,36377,36378,36379,36380,36381,36382,36383,36384,36385,36386,36387,36388,36389,36390,36391,36392,36393,36394,36396,36397,36398,36399,36400,36401,36402,36403,36404,36405,20129,40689,20073,41163,24537,39759,36395)"); 
			
			ResultSet rs0 = stmt0.executeQuery();
			while (rs0.next()) {
				
				PreparedStatement stmt = conn2.prepareStatement("select sum(round(l.precio*cantidad::numeric,2))-" +
						" COALESCE(sum(round((precio*cantidad*descuento)/100)),0) as total, " +
						"c.expediente_id,l.certificacion_id " +
						"from certificaciones c " +
						"inner join certificaciones_lineas l on l.certificacion_id = c.id " +
						"where c.id = ? AND c.state_id = 31 "+
						"group by  l.certificacion_id,c.expediente_id");
				stmt.setInt(1, rs0.getInt(1));
				
				ResultSet rs = stmt.executeQuery();
			
				while (rs.next()) {
					PreparedStatement stmt3;
					 
					
					if(rs0.getInt(2) > 0){
						 stmt3 = conn2.prepareStatement("update controles_presupuestarios set " +
						 		"debe = ?  where id = ?");
						 stmt3.setBigDecimal(1, rs.getBigDecimal(1));
						 stmt3.setInt(2, rs0.getInt(4));
						 stmt3.executeUpdate();
					}else if(rs0.getInt(3) > 0){
						 stmt3 = conn2.prepareStatement("update controles_presupuestarios set " +
						 		"haber = ?  where id = ?");
						 stmt3.setBigDecimal(1, rs.getBigDecimal(1));
						 stmt3.setInt(2, rs0.getInt(4));
						 stmt3.executeUpdate();
					}
					
					
				}
			
			}
			

			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
            try { if (conn != null) conn.close(); } catch (Exception e2) { }
            try { if (conn2 != null) conn2.close(); } catch (Exception e2) { }
            
        }
		
		System.out.println("Termino a migrar ActualizarControlPresupuestario");
		
		return true;
	}
	
	public boolean pagos(){
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a migrar ActualizarControlPresupuestario");
		try {
			conn2 = play.db.DB.getConnection();
			
			PreparedStatement stmt = conn2.prepareStatement("select sum(round(l.monto::numeric,2))," +
					"c.expediente_id,l.pago_id " +
					"from pagos c " +
					"inner join pagos_lineas l on l.pago_id = c.id where c.state_id = 23 " +
					"group by  l.pago_id,c.expediente_id");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int cuentaAnaliticaId = 0;
				int cuentaAnaliticaPadreId = 0;
				PreparedStatement stmt1 = conn2.prepareStatement("SELECT cuenta_analitica_id " +
						"from pagos_lineas where pago_id = ?");
				stmt1.setInt(1, rs.getInt(3));
				ResultSet rs1 = stmt1.executeQuery();
				if(rs1.next()){
					cuentaAnaliticaId = rs1.getInt(1);
				}
				
				PreparedStatement stmt2 = conn2.prepareStatement("SELECT parent_id from cuentas_analiticas where id = ?");
				stmt2.setInt(1, cuentaAnaliticaId);
				ResultSet rs2 = stmt2.executeQuery();
				if(rs2.next()){
					cuentaAnaliticaPadreId = rs2.getInt(1);
				}
				
				PreparedStatement stmt3 = conn2.prepareStatement("INSERT INTO controles_presupuestarios(cuenta_analitica_padre_id, " +
						"cuenta_analitica_hija_id, expediente_id,etapa_presupuestaria_id, " +
						" haber,pago_id) VALUES (?, ?, ?, 4, ?, ?)");
				
				stmt3.setInt(1, cuentaAnaliticaPadreId);
				stmt3.setInt(2, cuentaAnaliticaId);
				stmt3.setInt(3, rs.getInt(2));
				stmt3.setDouble(4, rs.getDouble(1));
				stmt3.setInt(5, rs.getInt(3));
				stmt3.executeUpdate();
			}
			
			
			

			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }
		System.out.println("Termino a migrar ActualizarControlPresupuestario");
		
		return true;
	}
	
	public boolean certificaciones(){
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a migrar ActualizarControlPresupuestario");
		try {
			conn2 = play.db.DB.getConnection();
			
			PreparedStatement stmt = conn2.prepareStatement("select sum(round(l.precio*cantidad::numeric,2)),c.expediente_id,l.certificacion_id " +
					"from certificaciones c " +
					"inner join certificaciones_lineas l on l.certificacion_id = c.id where c.state_id = 31 " +
					"group by  l.certificacion_id,c.expediente_id");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int cuentaAnaliticaId = 0;
				int cuentaAnaliticaPadreId = 0;
				PreparedStatement stmt1 = conn2.prepareStatement("SELECT cuenta_analitica_id " +
						"from certificaciones_lineas where certificacion_id = ?");
				stmt1.setInt(1, rs.getInt(3));
				ResultSet rs1 = stmt1.executeQuery();
				if(rs1.next()){
					cuentaAnaliticaId = rs1.getInt(1);
				}
				
				PreparedStatement stmt2 = conn2.prepareStatement("SELECT parent_id from cuentas_analiticas where id = ?");
				stmt2.setInt(1, cuentaAnaliticaId);
				ResultSet rs2 = stmt2.executeQuery();
				if(rs2.next()){
					cuentaAnaliticaPadreId = rs2.getInt(1);
				}
				
				PreparedStatement stmt3 = conn2.prepareStatement("INSERT INTO controles_presupuestarios(cuenta_analitica_padre_id, " +
						"cuenta_analitica_hija_id, expediente_id,etapa_presupuestaria_id, " +
						" haber,cert_id) VALUES (?, ?, ?, 3, ?, ?)");
				
				stmt3.setInt(1, cuentaAnaliticaPadreId);
				stmt3.setInt(2, cuentaAnaliticaId);
				stmt3.setInt(3, rs.getInt(2));
				stmt3.setDouble(4, rs.getDouble(1));
				stmt3.setInt(5, rs.getInt(3));
				stmt3.executeUpdate();
			}
			
			
			

			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }
		System.out.println("Termino a migrar ActualizarControlPresupuestario");
		
		return true;
	}	
}
