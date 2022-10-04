-- View: informe_deuda_actas

-- DROP VIEW informe_deuda_actas;

CREATE OR REPLACE VIEW informe_deuda_actas AS 
SELECT 'AC'||row_number() over () AS id_fake, a.acta_id AS id, null::integer certificacion_id, a.profe, a.fecha, COALESCE(a.numero,'') AS acta_numero, a.orden_id, a.orden_provision_id, a.tipo_cuenta_id,
COALESCE(a.total, 0::numeric) AS total_acta, 
COALESCE(p.total, 0::numeric) AS total_pagado, 

CASE WHEN a.es_dolar THEN 
	(COALESCE(a.total_dolar, 0::numeric) - COALESCE(p.total_dolar, 0::numeric)) * (select cotizacion from ultimas_cotizaciones where tipo_moneda = a.tipo_moneda order by fecha desc limit 1)
ELSE 
	COALESCE(a.total, 0::numeric) - COALESCE(p.total, 0::numeric)
END total_deuda,
 
a.proveedor_id, a.expediente_id, a.ejercicio_id, 
COALESCE(autorizado.total, 0) AS total_autorizado, 
a.periodo,
a.es_dolar,
a.rubro_id
FROM ( 	
	  	SELECT a.id AS acta_id, 
	  	COALESCE(pe.nombre, ''::character varying) AS periodo,
	  	o.profe, 
	  	a.fecha, 
	  	a.numero, 
	  	o.id AS orden_id, 
	  	op.id AS orden_provision_id, 
	  	o.proveedor_id, 
	  	a.ejercicio_id, 
	  	o.expediente_id, 
	  	o.tipo_moneda,
	  	o.tipo_cuenta_id,
	  	sum(COALESCE( al.total, 0)) AS total, sum(COALESCE(al.total_dolar,0)) AS total_dolar, al.es_dolar,o.orden_rubro_id as rubro_id 
       	FROM vista_actas_totales al
       	JOIN actas_recepcion a ON a.id = al.id
       	JOIN ordenes_provision op ON op.id = a.orden_provision_id
    	JOIN ordenes o ON o.id = op.orden_compra_id
   		LEFT JOIN periodos pe ON pe.id = a.periodo_id
   		LEFT JOIN periodos peo ON peo.id = o.periodo_id
  		WHERE a.state_id = 40
  		GROUP BY a.id, pe.nombre, o.id, op.id, al.es_dolar
  	 ) a
  	 
LEFT JOIN (
			SELECT ala.acta_recepcion_id AS acta_id, sum(  (round(COALESCE(pl.monto, 0) - COALESCE(pl.monto_credito, 0), 2) ) ) AS total, 
			sum(  (round(COALESCE(pl.monto, 0) - COALESCE(pl.monto_credito, 0), 2) ) / COALESCE(f.cot_dolar,1) ) AS total_dolar
            FROM autorizado_lineas aul
            JOIN autorizado_linea_actas ala ON ala.autorizado_linea_id = aul.id
            JOIN facturas f ON f.autorizado_id = aul.autorizado_id
            JOIN pagos p ON f.id = p.factura_id
       		JOIN pagos_lineas pl ON p.id = pl.pago_id
      		WHERE p.state_id = ANY (ARRAY[23, 25, 27])
      		GROUP BY ala.acta_recepcion_id
            UNION ALL 
            SELECT ala.acta_recepcion_id AS acta_id, sum(round(COALESCE(ala.monto, 0::numeric), 2)) AS total, sum(round(COALESCE(ala.monto, 0::numeric) / COALESCE(aul.cot_dolar,1), 2)) AS total_dolar
	   		FROM autorizado_lineas aul
            JOIN autorizado_linea_actas ala ON ala.autorizado_linea_id = aul.id
            GROUP BY ala.acta_recepcion_id
           ) p ON p.acta_id = a.acta_id
                
LEFT JOIN ( 
			SELECT ala.acta_recepcion_id, round( sum( COALESCE(ala.monto,0) ), 2) AS total
            FROM autorizado_lineas al
    	    JOIN autorizado_linea_actas ala ON ala.autorizado_linea_id = al.id
  	 		WHERE NOT (al.autorizado_id IN (
  	 								SELECT f.autorizado_id
            						FROM autorizados a
       								JOIN facturas f ON a.id = f.autorizado_id
   									JOIN pagos p ON p.factura_id = f.id
   								)
   						)
   			GROUP BY ala.acta_recepcion_id
   		) autorizado ON autorizado.acta_recepcion_id = a.acta_id
   		
where a.orden_id not in (
	SELECT orden_compra_id id 
	FROM vista_actas_totales a 
	INNER JOIN ordenes o ON o.id = a.orden_compra_id
	WHERE o.monto_adelanto is not null and a.state_id = 40
	GROUP BY orden_compra_id, monto_adelanto, o.cot_dolar
	having sum(a.total) < (o.monto_adelanto / COALESCE(cot_dolar,1) )
)   		
   		
UNION ALL 


SELECT 'AN'||row_number() over () AS id_fake, o.id, null certificacion_id, o.profe, o.fecha_orden AS fecha, 'Anticipo'::character varying AS acta_numero, o.id AS orden_id, op.id AS orden_provision_id, o.tipo_cuenta_id,
sum(round(o.monto_adelanto,2)) as total_acta, 
sum(round( COALESCE(al.monto, 0), 2)) AS total_pagado, 


CASE WHEN o.cot_dolar IS NOT NULL THEN 
	round( (sum(round(o.monto_adelanto / COALESCE(o.cot_dolar,1),2)) - sum(round(COALESCE(al.monto_dolar, 0::numeric), 2)) ) * (select cotizacion from ultimas_cotizaciones where tipo_moneda = o.tipo_moneda order by fecha desc limit 1),2)
ELSE 
	sum(o.monto_adelanto) - sum(round(COALESCE(al.monto, 0::numeric), 2))
END total_deuda,

o.proveedor_id, o.expediente_id, ex.ejercicio_id, COALESCE(al.monto,0) AS total_autorizado, 
CASE
    WHEN peo.nombre IS NOT NULL THEN peo.nombre
    ELSE ''::character varying
END AS periodo,
CASE WHEN o.cot_dolar IS NOT NULL THEN true ELSE false END es_dolar,o.orden_rubro_id as rubro_id
   FROM ordenes o 
     LEFT JOIN ordenes_provision op ON o.id = op.orden_compra_id
     LEFT JOIN (
     	select orden_id,  sum(round( COALESCE(monto, 0::numeric),2 )) monto, sum(round( COALESCE(monto, 0::numeric) / COALESCE(cot_dolar,1),2 )) monto_dolar from autorizado_lineas group by orden_id
     )  as al ON al.orden_id = o.id
     LEFT JOIN ( 
     				SELECT vista_actas_totales.orden_compra_id, sum(COALESCE(vista_actas_totales.total, 0::numeric)) AS total, sum(COALESCE(vista_actas_totales.total_dolar, 0::numeric)) AS total_dolar
           			FROM vista_actas_totales
          			WHERE (vista_actas_totales.orden_compra_id IN ( SELECT ordenes.id
                	FROM ordenes
                	WHERE ordenes.monto_adelanto IS NOT NULL))  and vista_actas_totales.state_id = 40
          			GROUP BY vista_actas_totales.orden_compra_id
          		) a ON a.orden_compra_id = o.id
     LEFT JOIN periodos peo ON peo.id = o.periodo_id  
     LEFT JOIN expedientes ex ON ex.id = o.expediente_id
  WHERE o.monto_adelanto IS NOT NULL AND o.state_id = 11 
  GROUP BY o.id, op.id, a.total, al.monto,ex.ejercicio_id,peo.nombre
 HAVING COALESCE(a.total, 0::numeric) < (COALESCE(o.monto_adelanto, 0::numeric) / COALESCE(o.cot_dolar,1))
 
/*
 * Union con las certificaciones de compras
 */
 
UNION ALL
 SELECT 'CC'::text || row_number() OVER () AS id_fake,
    NULL::integer AS id,
    cc.id AS certificacion_id,
    o.profe,
    certificacion.fecha,
    'CC'::character varying AS acta_numero,
    o.id AS orden_id,
    0 AS orden_provision_id,
    o.tipo_cuenta_id,
    sum(round(COALESCE(certificacion.total::numeric, 0::numeric), 2)) AS total_acta,
    sum(round(COALESCE(al.total, 0::numeric), 2)) AS total_pagado,
    --sum(round(COALESCE(certificacion.total::numeric, 0::numeric), 2)) - sum(round(COALESCE(al.total, 0::numeric), 2)) AS total_deuda,
     CASE
        WHEN o.cot_dolar IS NOT NULL THEN 
          round(
          (
          round(sum(COALESCE(certificacion.total::numeric, 0::numeric) / COALESCE(o.cot_dolar, 1::numeric)),2) 
          - 
          sum(round(COALESCE(al.monto_dolar, 0::numeric), 2))
          ) 
          * (( 
          SELECT ultimas_cotizaciones.cotizacion
          FROM ultimas_cotizaciones
          WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda
          ORDER BY ultimas_cotizaciones.fecha DESC
         LIMIT 1))
         , 2)
        ELSE 
        sum(round(COALESCE(certificacion.total::numeric, 0::numeric), 2)) - sum(round(COALESCE(al.total, 0::numeric), 2))
    END AS total_deuda,	

    
    o.proveedor_id,
    o.expediente_id,
    e.ejercicio_id,
    COALESCE(al.total, 0::numeric) AS total_autorizado,
    COALESCE(pep.nombre, ''::character varying) AS periodo,
        CASE
            WHEN o.cot_dolar IS NOT NULL THEN true
            ELSE false
        END AS es_dolar,
    o.orden_rubro_id AS rubro_id
   FROM certificaciones_compras cc
     JOIN ordenes o ON o.id = cc.orden_id
     LEFT JOIN periodos pep ON pep.id = cc.periodo_id
     LEFT JOIN expedientes e ON e.id = o.expediente_id
     LEFT JOIN ( SELECT ala.certificacion_compra_id,
            round(sum(COALESCE(ala.monto, 0::numeric)), 2) AS total,
            sum(round(COALESCE(ala.monto, 0::numeric) / COALESCE(al_1.cot_dolar, 1::numeric), 2)) AS monto_dolar
           FROM autorizado_lineas al_1
             JOIN autorizado_linea_actas ala ON ala.autorizado_linea_id = al_1.id
          WHERE ala.certificacion_compra_id IS NOT NULL
          GROUP BY ala.certificacion_compra_id) al ON al.certificacion_compra_id = cc.id
     LEFT JOIN ( SELECT cc_1.id,
            cc_1.fecha_certificacion AS fecha,
            sum(linea.total) AS total,
            0 AS total_dolar
           FROM certificaciones_compras cc_1
             JOIN ( SELECT certificaciones_compras_lineas.certificacion_compra_id,
                    sum(certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision - certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision * round(COALESCE(certificaciones_compras_lineas.descuento, 0::numeric), 2)::double precision / 100::double precision) AS total
                   FROM certificaciones_compras_lineas
                   WHERE certificaciones_compras_linea_ajustes.producto_id <> ALL (ARRAY[40277, 40276, 30653])	
                  GROUP BY certificaciones_compras_lineas.certificacion_compra_id
                UNION ALL
                 SELECT certificaciones_compras_linea_ajustes.certificacion_compra_id,
                    sum(COALESCE(certificaciones_compras_linea_ajustes.precio, 0::numeric)::double precision * COALESCE(certificaciones_compras_linea_ajustes.cantidad, 0::double precision)) AS total
                   FROM certificaciones_compras_linea_ajustes
                   WHERE certificaciones_compras_linea_ajustes.producto_id <> ALL (ARRAY[40277, 40276, 30653])
                  GROUP BY certificaciones_compras_linea_ajustes.certificacion_compra_id) linea ON linea.certificacion_compra_id = cc_1.id
          WHERE cc_1.state_id = 81
          GROUP BY cc_1.id) certificacion ON certificacion.id = cc.id
  WHERE o.state_id = 11 AND cc.state_id = 81 AND (o.tipo_orden::text = 'certificacioncompra'::text OR o.tipo_orden::text = 'certificacionobra'::text)
  GROUP BY cc.id, o.id, e.ejercicio_id, certificacion.total, al.total, certificacion.fecha, pep.nombre;
