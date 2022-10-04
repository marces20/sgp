package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import server.Configuracion2;
import server.Configuration;

public class MigracionPorExpediente {

	
	public void migrar (){
		
		int z = 1;
		z = 0;
		
		int f = 2;
		String tipo = (f ==1)?"manual":"auto";
		
		
		int m =1;
		int idexp = 3264;
		
		//7744
		
		if(m == 1){
			MigracionPorExpedienteSolicitud x = new MigracionPorExpedienteSolicitud();
			x.solicitud(idexp,tipo);
			  
			//OrdenMigracion o = new OrdenMigracion();
			//o.migrar(idexp);
		}
		
		if(m == 2){
			MigracionPorExpedienteFactura mf = new MigracionPorExpedienteFactura();
			mf.factura(new Long(idexp), new Long(31409));
		}
		
		if(m == 3){
			ExpedienteMigracion expedienteMigracion = new ExpedienteMigracion();
			expedienteMigracion.migrar();
		}
		/*
		 * 
		 select * from adop_expediente where name like '%0054%' and ejercicio_id = 3
		652 VIATICO
		706 VIATICO 
		 
 		UPDATE facturas SET orden_id =14987 WHERE id = 15526;
 		UPDATE facturas SET orden_id =14347 WHERE id = 15468;
 		UPDATE facturas SET orden_id =14346 WHERE id = 15469;
 		UPDATE facturas SET orden_id =16347 WHERE id = 15251;
 		UPDATE facturas SET orden_id =15175 WHERE id = 13197;
 		
 		UPDATE facturas SET orden_id =15222 WHERE id = 14932;
 		UPDATE facturas SET orden_id =15221 WHERE id = 14934;
 		
 		UPDATE facturas SET orden_id =14119 WHERE id = 14826;
 		UPDATE facturas SET orden_id =12689 WHERE id = 14759;
 		
 		UPDATE facturas SET orden_id =13810 WHERE id = 14669;
 		
 		UPDATE facturas SET orden_id =13386 WHERE id = 14663;
 		UPDATE facturas SET orden_id =13586 WHERE id = 14665;
 		UPDATE facturas SET orden_id =12944 WHERE id = 14667;
 		UPDATE facturas SET orden_id =12758 WHERE id = 14661;
 		UPDATE facturas SET orden_id =11270 WHERE id = 14666;
 		UPDATE facturas SET orden_id =11269 WHERE id = 14664;
 		
 		
 		
 		12758 	14661
		11269	14664
 		
 		
 		UPDATE facturas SET orden_id =15176 WHERE id = 13196;
		UPDATE facturas SET orden_id =15175 WHERE id = 13194;
		UPDATE facturas SET orden_id =14970 WHERE id = 13102;
		
		3764299518
		-rw-r--r-- 1 root root 4374272786 2014-09-24 13:27 system.out
		VERRRR AJUSTE 0088  
		VERRRR AJUSTE 0128 ($85.363,56)
		VERRRR AJUSTE 0122 ($82.091,02)
		2;14593
2;9586
2;14605

		
		 
		
		//select * from adop_expediente where name like '%0070%'
		update controles_presupuestarios set cuenta_analitica_padre_id = 36 where cuenta_analitica_padre_id = 116
		*/
			
	}	
	
	
	
}
