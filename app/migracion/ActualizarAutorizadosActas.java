package migracion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import models.ActaRecepcion;
import models.Estado;

public class ActualizarAutorizadosActas {
	public boolean xxx(){
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a ActualizarAutorizados");
		try {
			conn2 = play.db.DB.getConnection();
			
			/*PreparedStatement stmt0 = conn2.prepareStatement("select proveedor_id,expediente_id,total_orden,orden_id,orden_provision_id " +
					"from informe_estadistico_deuda_proveedores " +
															"where total_orden = total_pagado " +
															"and orden_provision_id is not null " +
															"and total_deuda = 0 and total_compromiso = 0");*/
			
			PreparedStatement stmt0 = conn2.prepareStatement("" +
" select id from actas_recepcion where ejercicio_id = 5 and state_id = 40 and orden_provision_id is not null and id not in(" +
"select id from actas_recepcion ar where ejercicio_id = 5 and (  "+
"numero = '280' or "+
"numero = '308' or "+
"numero = '923' or "+
"numero = '320' or "+
"numero = '344' or "+
"numero = '355' or "+
"numero = '354' or "+
"numero = '417' or "+
"numero = '419' or "+
"numero = '421' or "+
"numero = '432' or "+
"numero = '428' or "+
"numero = '437' or "+
"numero = '439' or "+
"numero = '440' or "+
"numero = '445' or "+
"numero = '451' or "+
"numero = '464' or "+
"numero = '494' or "+
"numero = '504' or "+
"numero = '517' or "+
"numero = '519' or "+
"numero = '523' or "+
"numero = '522' or "+
"numero = '553' or "+
"numero = '569' or "+
"numero = '571' or "+
"numero = '570' or "+
"numero = '586' or "+
"numero = '598' or "+
"numero = '597' or "+
"numero = '599' or "+
"numero = '626' or "+
"numero = '635' or "+
"numero = '658' or "+
"numero = '656' or "+
"numero = '1376' or "+
"numero = '662' or "+
"numero = '669' or "+
"numero = '676' or "+
"numero = '677' or "+
"numero = '688' or "+
"numero = '721' or "+
"numero = '722' or "+
"numero = '728' or "+
"numero = '744' or "+
"numero = '743' or "+
"numero = '745' or "+
"numero = '746' or "+
"numero = '754' or "+
"numero = '753' or "+
"numero = '768' or "+
"numero = '764' or "+
"numero = '825' or "+
"numero = '759' or "+
"numero = '757' or "+
"numero = '780' or "+
"numero = '784' or "+
"numero = '775' or "+
"numero = '786' or "+
"numero = '790' or "+
"numero = '801' or "+
"numero = '800' or "+
"numero = '808' or "+
"numero = '838' or "+
"numero = '864' or "+
"numero = '834' or "+
"numero = '835' or "+
"numero = '845' or "+
"numero = '839' or "+
"numero = '847' or "+
"numero = '877' or "+
"numero = '886' or "+
"numero = '888' or "+
"numero = '940' or "+
"numero = '1012' or "+
"numero = '902' or "+
"numero = '1115' or "+
"numero = '1033' or "+
"numero = '969' or "+
"numero = '958' or "+
"numero = '1019' or "+
"numero = '1029' or "+
"numero = '1032' or "+
"numero = '913' or "+
"numero = '921' or "+
"numero = '924' or "+
"numero = '1116' or "+
"numero = '946' or "+
"numero = '948' or "+
"numero = '947' or "+
"numero = '980' or "+
"numero = '978' or "+
"numero = '979' or "+
"numero = '973' or "+
"numero = '989' or "+
"numero = '992' or "+
"numero = '984' or "+
"numero = '1229' or "+
"numero = '1178' or "+
"numero = '1234' or "+
"numero = '1146' or "+
"numero = '1145' or "+
"numero = '1092' or "+
"numero = '1094' or "+
"numero = '1091' or "+
"numero = '1098' or "+
"numero = '1101' or "+
"numero = '1102' or "+
"numero = '1100' or "+
"numero = '1103' or "+
"numero = '1104' or "+
"numero = '1108' or "+
"numero = '1130' or "+
"numero = '1110' or "+
"numero = '1111' or "+
"numero = '1112' or "+
"numero = '1117' or "+
"numero = '1118' or "+
"numero = '1127' or "+
"numero = '1124' or "+
"numero = '1122' or "+
"numero = '1135' or "+
"numero = '1136' or "+
"numero = '1134' or "+
"numero = '1133' or "+
"numero = '1147' or "+
"numero = '1163' or "+
"numero = '1167' or "+
"numero = '1148' or "+
"numero = '1168' or "+
"numero = '1173' or "+
"numero = '1184' or "+
"numero = '1218' or "+
"numero = '1221' or "+
"numero = '1232' or "+
"numero = '1239' or "+
"numero = '1240' or "+
"numero = '1241' or "+
"numero = '1247' or "+
"numero = '1248' or "+
"numero = '1249' or "+
"numero = '1252' or "+
"numero = '1379' or "+
"numero = '1260' or "+
"numero = '1261' or "+
"numero = '1262' or "+
"numero = '1263' or "+
"numero = '1278' or "+
"numero = '1289' or "+
"numero = '1279' or "+
"numero = '1288' or "+
"numero = '1291' or "+
"numero = '1294' or "+
"numero = '1302' or "+
"numero = '1303' or "+
"numero = '1304' or "+
"numero = '1310' or "+
"numero = '1311' or "+
"numero = '1312' or "+
"numero = '1313' or "+
"numero = '1314' or "+
"numero = '1315' or "+
"numero = '1327' or "+
"numero = '1316' or "+
"numero = '1317' or "+
"numero = '1318' or "+
"numero = '1319' or "+
"numero = '1320' or "+
"numero = '1321' or "+
"numero = '1322' or "+
"numero = '1323' or "+
"numero = '1333' or "+
"numero = '1334' or "+
"numero = '1335' or "+
"numero = '1344' or "+
"numero = '1330' or "+
"numero = '1332' or "+
"numero = '1337' or "+
"numero = '1346' or "+
"numero = '1382' or "+
"numero = '1389' or "+
"numero = '1393' or "+
"numero = '1414' or "+
"numero = '1417' or "+
"numero = '1418' or "+
"numero = '1424' or "+
"numero = '1426' or "+
"numero = '1430' or "+
"numero = '1433' or "+
"numero = '1434' or "+
"numero = '1449' or "+
"numero = '1453' or "+
"numero = '1455' or "+
"numero = '1456' or "+
"numero = '1465' or "+
"numero = '1466' or "+
"numero = '1467' or "+
"numero = '1473' or "+
"numero = '1584' or "+
"numero = '1493' or "+
"numero = '1494' or "+
"numero = '1515' or "+
"numero = '1516' or "+
"numero = '1513' or "+
"numero = '1496' or "+
"numero = '1474' or "+
"numero = '1480' or "+
"numero = '1481' or "+
"numero = '1486' or "+
"numero = '1488' or "+
"numero = '1500' or "+
"numero = '1505' or "+
"numero = '1510' or "+
"numero = '1511' or "+
"numero = '1509' or "+
"numero = '1519' or "+
"numero = '1521' or "+
"numero = '1522' or "+
"numero = '1524' or "+
"numero = '1520' or "+
"numero = '1562' or "+
"numero = '1563' or "+
"numero = '1564' or "+
"numero = '1565' or "+
"numero = '1566' or "+
"numero = '1567' or "+
"numero = '1568' or "+
"numero = '1570' or "+
"numero = '1525' or "+
"numero = '1526' or "+
"numero = '1552' or "+
"numero = '1553' or "+
"numero = '1554' or "+
"numero = '1555' or "+
"numero = '1556' or "+
"numero = '1558' or "+
"numero = '1559' or "+
"numero = '1560' or "+
"numero = '1569' or "+
"numero = '1571' or "+
"numero = '1572' or "+
"numero = '1573' or "+
"numero = '1574' or "+
"numero = '1575' or "+
"numero = '1576' or "+
"numero = '1577' or "+
"numero = '1578' or "+
"numero = '1579' or "+
"numero = '1580' or "+
"numero = '1581' or "+
"numero = '1582' or "+
"numero = '1583' or "+
"numero = '1585' or "+
"numero = '1586' or "+
"numero = '1587' or "+
"numero = '1588' or "+
"numero = '1589' or "+
"numero = '1590' or "+
"numero = '1591' or "+
"numero = '1592' or "+
"numero = '1593' or "+
"numero = '1594' or "+
"numero = '1595' or "+
"numero = '1596' or "+
"numero = '1597' or "+
"numero = '1598' or "+
"numero = '1601' or "+
"numero = '1603' or "+
"numero = '1604	')) ");
			
			
			stmt0 = conn2.prepareStatement("select id from actas_recepcion ar "+
					 "where (ejercicio_id = 4 or ejercicio_id = 3)  " +
					 "and state_id = 40 " +
					 "and id not in(5837,5526,6057,7214) " +
					 "and id not in(select acta_recepcion_id from autorizado_linea_actas) ");
			 
			ResultSet rs0 = stmt0.executeQuery();
			while (rs0.next()) {
				
				ActaRecepcion ar = ActaRecepcion.find.byId(rs0.getLong(1));
				
				PreparedStatement stmt3;
				PreparedStatement stmtu;
				PreparedStatement stmtsi = conn2.prepareStatement("SELECT nextval('autorizado_lineas_id_seq')");
        		ResultSet rssi = stmtsi.executeQuery();
        		if(rssi.next()){
        			
        			
        			PreparedStatement stmtor = conn2.prepareStatement("SELECT * from autorizado_linea_actas WHERE acta_recepcion_id = ? ");
    				stmtor.setLong(1, ar.id);
    				ResultSet rssor = stmtor.executeQuery();
        			
    				if(rssor.next()){
    					
    				}else{
    					
    				
    				
        			int idAutorizadoLinea = rssi.getInt(1);
					
        			if(ar.ordenProvision.ordenCompra.profe){
	        			stmt3 = conn2.prepareStatement("INSERT INTO autorizado_lineas(autorizado_id, proveedor_id, expediente_id, monto, " +
	        					"orden_id,id,orden_provision_id) " +
		 			    "VALUES (3, ?, ?, ?, ?, ?, ?)");
        			}else{
        				stmt3 = conn2.prepareStatement("INSERT INTO autorizado_lineas(autorizado_id, proveedor_id, expediente_id, monto, " +
	        					"orden_id,id,orden_provision_id) " +
		 			    "VALUES (4, ?, ?, ?, ?, ?, ?)");
        			}
        			
        			
					stmt3.setLong(1, ar.ordenProvision.ordenCompra.proveedor_id);
					stmt3.setLong(2, ar.ordenProvision.ordenCompra.expediente_id);
					stmt3.setBigDecimal(3, ar.getTotal());//monto
					stmt3.setLong(4, ar.ordenProvision.orden_compra_id);
					stmt3.setInt(5, idAutorizadoLinea);
					stmt3.setInt(6, ar.orden_provision_id);
					stmt3.executeUpdate();
					
					/*List<ActaRecepcion> arx = ActaRecepcion.find.where()
											.eq("orden_provision_id",rs0.getInt(5))
											.eq("estado_id", Estado.ACTA_ESTADO_APROBADA).findList();*/
					
					//BigDecimal montoa = new BigDecimal(0);
					//for(ActaRecepcion x : arx){
						PreparedStatement stmt4;
						stmt4 = conn2.prepareStatement("INSERT INTO autorizado_linea_actas(autorizado_linea_id, acta_recepcion_id, monto) VALUES (?, ?, ?)");
						stmt4.setInt(1, idAutorizadoLinea);
						stmt4.setLong(2, ar.id);
						stmt4.setBigDecimal(3, ar.getTotal().setScale(2, RoundingMode.HALF_DOWN));
						stmt4.executeUpdate();
						
						//	montoa = montoa.add(x.getTotal().setScale(2, RoundingMode.HALF_DOWN));
						//}
						//stmtu = conn2.prepareStatement("UPDATE autorizado_lineas SET monto=? WHERE id = ? ");
						//stmtu.setBigDecimal(1, montoa);//monto
						//stmtu.setInt(2, idAutorizadoLinea);
						//stmtu.executeUpdate();
    				}	
        		}	
			}
			

			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
            
            try { if (conn2 != null) conn2.close(); } catch (Exception e2) { }
            
        }
		
		System.out.println("Termino a ActualizarAutorizados");
		
		return true;
	}
}
