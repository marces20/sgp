-- View: informe_estadistico_deuda_proveedores

DROP VIEW informe_estadistico_deuda_proveedores;

CREATE OR REPLACE VIEW informe_estadistico_deuda_proveedores AS 
 SELECT  o.id,
	 o.id AS orden_id,
	o.cot_dolar AS cotizacion,
	CASE
	    WHEN o.tipo_moneda = 1 THEN 'Dólar'::text
	    WHEN o.tipo_moneda = 2 THEN 'Euro'::text
	    ELSE 'Peso'::text
	END AS moneda,
	op.id AS orden_provision_id,
	o.deposito_id,
	o.numero_orden_provision,
	ej.nombre AS ano,
	o.nombre,
	(e.nombre::text || '/'::text) || ej.nombre::text AS expediente,
	o.expediente_id,
	o.profe,
	e.ejercicio_id,
	pr.id AS proveedor_id,
	pr.nombre AS nombre_proveedor,
	o.orden_rubro_id AS rubro_id,
	r.nombre AS rubro,
	o.tipo_cuenta_id,
 		COALESCE(sum(ord.total), 0::numeric) AS total_orden, 
 		COALESCE(sum(p.total), 0::numeric) AS total_pagado, 
 		COALESCE(sum(p.totalautorizado), 0::numeric) AS total_autorizado, 
 		COALESCE(sum(actas_sin_adelanto.total::double precision * COALESCE(o.cot_dolar, 1::numeric)::double precision), 0::numeric::double precision) AS total_actas_sin_adelanto,
		COALESCE(sum(a.total * COALESCE(o.cot_dolar, 1)), 0::numeric) AS total_actas, 
 		
		CASE WHEN o.cot_dolar IS NOT NULL THEN 
			((COALESCE(sum( a.total_dolar ), 0) - COALESCE(sum(p.total_dolar), 0)) * (select cotizacion from ultimas_cotizaciones where tipo_moneda = o.tipo_moneda order by fecha desc limit 1))::numeric
		ELSE 
			(COALESCE(sum(a.total), 0) - COALESCE(sum(p.total), 0))::numeric
		END total_deuda,

        CASE
            WHEN o.cot_dolar IS NOT NULL THEN ((COALESCE(sum(ord.total_dolar), 0::numeric) - COALESCE(sum(p.total_dolar), 0::numeric) - (COALESCE(sum(a.total_dolar), 0::numeric) - COALESCE(sum(p.total_dolar), 0::numeric))) * (( SELECT ultimas_cotizaciones.cotizacion
               FROM ultimas_cotizaciones
              WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda
              ORDER BY ultimas_cotizaciones.fecha DESC
             LIMIT 1)))::double precision
            ELSE (COALESCE(sum(ord.total), 0::numeric::double precision) - COALESCE(sum(p.total), 0::numeric::double precision)) - (COALESCE(sum(a.total), 0::numeric::double precision) - COALESCE(sum(p.total), 0::numeric)::double precision)
        END AS total_compromiso, 
        
        o.tipo_moneda
   FROM ordenes o
   LEFT JOIN vista_pagos_totales p ON p.orden_id = o.id
   LEFT JOIN ( SELECT asd_2.orden_compra_id AS id,
            sum(asd_2.total) AS total,
            sum(asd_2.total_dolar) AS total_dolar
           FROM vista_actas_totales asd_2
          WHERE asd_2.state_id = 40
          GROUP BY asd_2.orden_compra_id) actas_sin_adelanto ON actas_sin_adelanto.id = o.id
   LEFT JOIN ( 
				SELECT o.id, 
					(sum(round(ol.precio * ol.cantidad::numeric,2)) + COALESCE(ajustes.total, 0) + COALESCE(ajustes_dolar.total, 0) ) AS total,
					round((sum(round(ol.precio * ol.cantidad::numeric,2)) + COALESCE(ajustes.total, 0)) / COALESCE(o.cot_dolar,1),2) AS total_dolar
			        FROM ordenes o
				JOIN orden_lineas ol ON ol.orden_id = o.id
				LEFT JOIN ( 
						SELECT orden_id, COALESCE(sum(round(a.precio * a.cantidad, 2)), 0) AS total
						FROM orden_lineas_ajustes a
						WHERE a.producto_id not in (40277, 40276, 30653)
						GROUP BY a.orden_id
					) as ajustes on ajustes.orden_id = o.id
				LEFT JOIN ( 
						SELECT orden_id, COALESCE(sum(round(a.precio * a.cantidad, 2)), 0) AS total
						FROM orden_lineas_ajustes a
						WHERE a.producto_id in (40277, 40276, 30653)
						GROUP BY a.orden_id
					) as ajustes_dolar on ajustes_dolar.orden_id = o.id
				WHERE (o.state_id = 11 OR o.state_id = 14)
				GROUP BY o.id  , o.cot_dolar, ajustes.total, ajustes_dolar.total
  			) ord ON ord.id = o.id
   LEFT JOIN (        
   				( 

		  		  -- Suma todos los totales de actas de una orden y si la orden tiene un monto de adelnto mayor entonces toma el total del adelanto como monto de acta --
				  select distinct orden_id, max(total) total, max(total_dolar) total_dolar from (
				  select  orden_compra_id orden_id, SUM(a.total) total, sum(total_dolar) total_dolar from vista_actas_totales a WHERE a.state_id = 40 group by orden_compra_id
				  union
				  select  id orden_id, 
				  		  COALESCE(monto_adelanto,0) total , 
				  		  round(COALESCE(monto_adelanto,0) / COALESCE(cot_dolar, 1),2) total_dolar 
				  		  from ordenes 
				  		  where monto_adelanto > 0 
				  		  and ( tipo_orden::text != 'haberesrelacion'::text or tipo_orden::text != 'certificacioncompra'::text or tipo_orden::text != 'certificacionobra'::text)
				  ) as a
				  group by orden_id
   				
   				
        		  UNION 
                  SELECT o.id, sum(round(ol.precio * ol.cantidad::numeric, 2))+sum(round(COALESCE(ola.precio, 0::numeric) * COALESCE(ola.cantidad, 0::numeric), 2)) AS total, 0 total_dolar
                  FROM ordenes o
              	  JOIN orden_lineas ol ON ol.orden_id = o.id
              	  LEFT JOIN orden_lineas_ajustes ola ON ola.orden_id = o.id
             	  WHERE (o.state_id = 11 OR o.state_id = 14) AND o.tipo_orden::text = 'haberesrelacion'::text
             	  GROUP BY o.id
             	  
					UNION 
	         		SELECT cc.orden_id, 
	         		--SUM(cl.total) total,   0 total_dolar
	           		round((sum(cl.total) / COALESCE(o_1.cot_dolar, 1::numeric)::double precision)::numeric,2) AS total_dolar
	         		
	         		FROM (
							select certificacion_compra_id, 
									sum(cantidad * round(precio, 2) - cantidad * round(precio, 2) *  round(COALESCE(descuento, 0), 2) / 100) AS total 
							from certificaciones_compras_lineas group by certificacion_compra_id
							union all
							select certificacion_compra_id, (SUM(COALESCE(precio,0) * COALESCE(cantidad,0))) total 
							from certificaciones_compras_linea_ajustes group by certificacion_compra_id
							) cl
	      			JOIN certificaciones_compras cc ON cc.id = cl.certificacion_compra_id
	      			JOIN ordenes o ON o.id = cc.orden_id
	      			WHERE cc.state_id = 81
	    	 		GROUP BY cc.orden_id, cc.state_id, o.cot_dolar
	    	 		
	    	 		
             	  )

    	 	) a ON a.orden_id = o.id
   LEFT JOIN proveedores pr ON pr.id = o.proveedor_id
   LEFT JOIN expedientes e ON e.id = o.expediente_id
   LEFT JOIN ejercicios ej ON ej.id = e.ejercicio_id
   LEFT JOIN ordenes_provision op ON op.orden_compra_id = o.id
   LEFT JOIN ordenes_rubros r ON r.id = o.orden_rubro_id
   WHERE o.state_id <> 13 AND (op.id IS NOT NULL OR (o.id IN ( SELECT certificaciones_compras.orden_id
   															   FROM certificaciones_compras group by orden_id
   															   )
   													  ) OR o.tipo_orden::text = 'haberesrelacion'::text)
  GROUP BY o.id, op.id, o.nombre, o.expediente_id, e.ejercicio_id, o.numero_orden_provision, o.profe, e.nombre, ej.nombre, o.orden_rubro_id, r.nombre, pr.id, pr.nombre, o.deposito_id;