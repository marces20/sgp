CREATE OR REPLACE VIEW informe_deuda_2016 AS
SELECT o.orden_id id, o.orden_id, o.total total_orden, p.total total_pagado, 
CASE WHEN o.es_dolar THEN
COALESCE(o.total,0) - COALESCE(p.total,0) * (select cotizacion from ultimas_cotizaciones order by fecha desc limit 1)
ELSE
COALESCE(o.total,0) - COALESCE(p.total,0)
END as total,
o.es_dolar
FROM (
-- todo lo que tiene acta
SELECT a.orden_id, 
	SUM(
        CASE
            WHEN a.es_dolar THEN COALESCE(a.total_dolar, 0::numeric)   
            ELSE COALESCE(a.total, 0::numeric)
        END) AS total,
    a.es_dolar
   FROM ( SELECT o.id AS orden_id, sum(al.total) AS total, sum(al.total_dolar) AS total_dolar, al.es_dolar
           FROM vista_actas_totales al
             JOIN actas_recepcion a_1 ON a_1.id = al.id
             JOIN ordenes_provision op ON op.id = a_1.orden_provision_id
             JOIN ordenes o ON o.id = op.orden_compra_id
          WHERE a_1.state_id = 40 and  (CAST(a_1.fecha AS DATE) <= '2016-12-31' or a_1.fecha is null)
          GROUP BY a_1.id, o.id, o.orden_rubro_id, al.es_dolar
) a
group by a.orden_id, es_dolar
UNION ALL
-- todas las ordenes que son haberes_relecion
	SELECT o.id, sum(round(ol.precio * ol.cantidad::numeric, 2))+sum(round(COALESCE(ola.precio, 0::numeric) * COALESCE(ola.cantidad, 0::numeric), 2)) AS total, false es_dolar
	FROM ordenes o
	JOIN orden_lineas ol ON ol.orden_id = o.id
	LEFT JOIN orden_lineas_ajustes ola ON ola.orden_id = o.id
	WHERE (o.state_id = 11) AND o.tipo_orden::text = 'haberesrelacion'::text and (CAST(o.fecha_aprobada AS DATE) <= '2016-12-31' or o.fecha_aprobada is null)
	GROUP BY o.id
UNION ALL
-- certificaiones compras 
	SELECT cc.orden_id, 
	sum(cl.cantidad * round(cl.precio, 2)::double precision - cl.cantidad * round(cl.precio, 2)::double precision * round(cl.descuento, 2)::double precision / 100::double precision)::numeric as total, false es_dolar
	FROM certificaciones_compras_lineas cl
	JOIN certificaciones_compras cc ON cc.id = cl.certificacion_compra_id
	WHERE cc.state_id = 81 and CAST(cc.fecha_certificacion AS DATE) <= '2016-12-31'
	GROUP BY cc.orden_id, cc.state_id
UNION ALL
-- certificaciones personal 
	SELECT c.orden_id, 
	sum(cl.cantidad * round(cl.precio, 2)::double precision - cl.cantidad * round(cl.precio, 2)::double precision * round(cl.descuento, 2)::double precision / 100::double precision)::numeric as total, false es_dolar
	FROM certificaciones c
	JOIN certificaciones_lineas cl ON c.id = cl.certificacion_id
	WHERE c.state_id = 31 and CAST(c.fecha_certificacion AS DATE) <= '2016-12-31'
	GROUP BY c.orden_id, c.state_id
) o 
-- obtengo los pagos
LEFT JOIN (
	SELECT o.id orden_id, sum(COALESCE(pp.total, 0::numeric) + COALESCE(pi.total, 0::numeric)) AS total,CASE WHEN o.cot_dolar is not null then true else false end es_dolar
	FROM facturas f
	INNER JOIN ( 
		SELECT p.factura_id, 
			CASE
			    WHEN f.cot_dolar IS NOT NULL THEN 
				round(sum((round(pl.monto, 2) - pl.monto_credito) / COALESCE(f.cot_dolar, 1)), 2) 
			    ELSE 
				round(sum(round(pl.monto, 2) - pl.monto_credito), 2)
			END AS total
		FROM pagos p
		JOIN facturas f on f.id = p.factura_id 
		JOIN pagos_lineas pl ON pl.pago_id = p.id
		WHERE (p.tipo::text = 'payment'::text OR p.proveedor_id = 4427) AND (p.state_id = 23 OR p.state_id = 25) and CAST(p.fecha_pago AS DATE) <= '2016-12-31'
		GROUP BY p.factura_id, f.cot_dolar
	) pp ON pp.factura_id = f.id
	LEFT JOIN ( 
		SELECT p.factura_id, 
		CASE
		    WHEN f.cot_dolar IS NOT NULL THEN 
			sum((round(COALESCE(pl.monto, 0::numeric), 2) - round(COALESCE(pl.monto_credito, 0::numeric), 2)) / COALESCE(f.cot_dolar, 1))
		    ELSE 
			sum(round(COALESCE(pl.monto, 0::numeric), 2) - round(COALESCE(pl.monto_credito, 0::numeric), 2))
		END AS total
		FROM pagos p
		JOIN facturas f on f.id = p.factura_id 
		JOIN pagos_lineas pl ON pl.pago_id = p.id
		WHERE p.tipo::text = 'impuestos'::text AND (p.state_id = 23 OR p.state_id = 25) AND p.proveedor_id <> 4427 and CAST(p.fecha_pago AS DATE) <= '2016-12-31'
		GROUP BY p.factura_id, f.cot_dolar
	) pi ON pi.factura_id = f.id
	INNER JOIN ordenes o ON o.id = f.orden_id
	WHERE f.orden_id IS NOT NULL
	GROUP BY o.id
) p on p.orden_id = o.orden_id