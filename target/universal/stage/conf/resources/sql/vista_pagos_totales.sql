CREATE OR REPLACE VIEW vista_pagos_totales AS 
 SELECT o.id AS orden_id, 
        CASE
            WHEN COALESCE(pagado.total, 0::numeric) > COALESCE(autorizado.total, 0::numeric) THEN COALESCE(pagado.total, 0::numeric)
            ELSE COALESCE(autorizado.total, 0::numeric)
        END AS total, 
        CASE
            WHEN COALESCE(pagado.total_dolar, 0::numeric) > COALESCE(autorizado.total_dolar, 0::numeric) THEN COALESCE(pagado.total_dolar, 0::numeric)
            ELSE COALESCE(autorizado.total_dolar, 0::numeric)
        END AS total_dolar,         
        autorizado.total AS totalautorizado
   FROM ordenes o
   LEFT JOIN ( 	SELECT f.orden_id, 
   						sum(COALESCE(pp.total, 0::numeric) + COALESCE(pi.total, 0::numeric)) AS total,
   						sum(round(COALESCE(pp.total_dolar, 0::numeric) + COALESCE(pi.total_dolar, 0::numeric),2)) AS total_dolar
           		FROM facturas f
      			RIGHT JOIN ( SELECT p.factura_id, 
      								round(sum(round(pl.monto, 2) - pl.monto_credito), 2) AS total,
      								round(sum((round(pl.monto, 2) - pl.monto_credito) / COALESCE(f.cot_dolar, 1)), 2) AS total_dolar
                   			 FROM pagos p
                   			 JOIN facturas f on f.id = p.factura_id 
              				 JOIN pagos_lineas pl ON pl.pago_id = p.id
             				 WHERE (p.tipo::text = 'payment'::text OR p.proveedor_id = 4427) AND (p.state_id = 23 OR p.state_id = 27 OR p.state_id = 25)
             				 GROUP BY p.factura_id
             				) pp ON pp.factura_id = f.id
			   	LEFT JOIN ( SELECT p.factura_id, 
			   				sum(round(COALESCE(pl.monto, 0::numeric), 2) - round(COALESCE(pl.monto_credito, 0::numeric), 2)) AS total,
			   				sum((round(COALESCE(pl.monto, 0::numeric), 2) - round(COALESCE(pl.monto_credito, 0::numeric), 2)) / COALESCE(f.cot_dolar, 1)) AS total_dolar
			               FROM pagos p
			               JOIN facturas f on f.id = p.factura_id 
			         	   JOIN pagos_lineas pl ON pl.pago_id = p.id
			        	   WHERE p.tipo::text = 'impuestos'::text AND p.state_id <> 26 AND p.proveedor_id <> 4427
			        	   GROUP BY p.factura_id
			        	   ORDER BY p.factura_id
			        	  ) pi ON pi.factura_id = f.id
			  	WHERE f.orden_id IS NOT NULL
  			  	GROUP BY f.orden_id
  			  ) pagado ON pagado.orden_id = o.id
   LEFT JOIN ( 	SELECT t.orden_id,
   					round(sum(t.total),2)  AS total,
					round(sum(t.total / COALESCE(t.cot_dolar,1)),2)  AS total_dolar
			    FROM ( SELECT al.autorizado_id, cot_dolar, al.orden_id, 
			                   CASE
			                       WHEN sum(COALESCE(al.monto, 0::numeric)) > sum(COALESCE(ala.total, 0::numeric)) THEN sum(COALESCE(al.monto, 0::numeric))
			                       ELSE sum(COALESCE(ala.total, 0::numeric))
			                   END AS total
			            FROM autorizado_lineas al
			         	LEFT JOIN ( SELECT autorizado_linea_actas.autorizado_linea_id, sum(COALESCE(autorizado_linea_actas.monto, 0::numeric)) AS total
			                      	FROM autorizado_linea_actas
			                     	GROUP BY autorizado_linea_actas.autorizado_linea_id
			                       ) ala ON al.id = ala.autorizado_linea_id
			        	GROUP BY al.id
			        ) t 
					  	WHERE NOT (t.autorizado_id IN ( SELECT f.autorizado_id
					         							FROM autorizados a
					    								JOIN facturas f ON a.id = f.autorizado_id
					   									JOIN pagos p ON p.factura_id = f.id
					   									)
					   				)
  					GROUP BY t.orden_id) autorizado ON autorizado.orden_id = o.id
  GROUP BY o.id, pagado.total, autorizado.total, pagado.total_dolar, autorizado.total_dolar;
 
