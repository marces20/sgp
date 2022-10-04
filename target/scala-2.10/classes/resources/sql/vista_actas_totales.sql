CREATE OR REPLACE VIEW vista_actas_totales AS 
 	
SELECT acta.id, a.orden_provision_id, round(SUM(acta.total),2) as total, round(SUM(acta.total / COALESCE(o.cot_dolar,1)),2) as total_dolar, a.state_id, op.orden_compra_id,
CASE WHEN o.cot_dolar IS NOT NULL THEN true ELSE false END es_dolar 
FROM actas_recepcion a
JOIN (        
	
		SELECT rec.acta_id AS id, round(COALESCE(sum(ol.precio * rl.cantidad)), 2) AS total
        FROM actas_recepcion a
        JOIN recepciones rec ON a.id = rec.acta_id
        JOIN remitos rem ON rem.recepcion_id = rec.id
        JOIN remitos_lineas rl ON rl.remito_id = rem.id
       	JOIN orden_lineas ol ON ol.id = rl.linea_orden_id
      	WHERE rec.acta_id IS NOT NULL
      	GROUP BY rec.acta_id
                
      	UNION ALL 
                
      	SELECT cs.acta_id AS id, round(COALESCE(sum(csl.precio * csl.cantidad), 0::numeric), 2) AS total
        FROM actas_recepcion a
        JOIN certificaciones_servicios cs ON a.id = cs.acta_id
        JOIN certificaciones_servicios_lineas csl ON cs.id = csl.certificaciones_servicio_id
        WHERE cs.acta_id IS NOT NULL
        GROUP BY cs.acta_id

	 	UNION ALL

	 	SELECT aa.acta_id, round(COALESCE(sum(ola.cantidad * ola.precio), 0::numeric), 2) AS total
	 	FROM actas_ajustes aa
	 	JOIN orden_lineas_ajustes ola ON ola.id = aa.ajuste_id
		WHERE ola.producto_id not in (40277, 40276, 30653)
	 	GROUP BY aa.acta_id 

	) acta ON acta.id = a.id
JOIN ordenes_provision op ON op.id = a.orden_provision_id
JOIN ordenes o on o.id = op.orden_compra_id
GROUP BY acta.id, a.orden_provision_id, a.state_id, op.orden_compra_id, cot_dolar;