-- FUNCTION: public.actualiza_totales_ordenes_pagos(integer)

-- DROP FUNCTION public.actualiza_totales_ordenes_pagos(integer);

CREATE OR REPLACE FUNCTION public.actualiza_totales_ordenes_pagos(
	ordenn_id integer DEFAULT NULL::integer)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
declare
rec record;
begin

for rec in 

SELECT o.id AS orden_id, pagado.state_id, 
	--Se cambia pagado a pagado real, ya no más pagado real o autorizado
        --CASE
        --    WHEN COALESCE(pagado.total, 0::numeric) > COALESCE(autorizado.total, 0::numeric) THEN COALESCE(pagado.total, 0::numeric)
        --    ELSE COALESCE(autorizado.total, 0::numeric)
        --END AS total,
        
        COALESCE(pagado.total, 0::numeric) AS total_pagado,
        
        --CASE
        --    WHEN COALESCE(pagado.total_dolar, 0::numeric) > COALESCE(autorizado.total_dolar, 0::numeric) THEN COALESCE(pagado.total_dolar, 0::numeric)
        --    ELSE COALESCE(autorizado.total_dolar, 0::numeric)
        --END AS total_dolar,
        pagado.total_dolar as total_pagado_divisa
        /*
        CASE
            WHEN o.cot_dolar > 1 THEN COALESCE(pagado.total_dolar, 0::numeric)
            ELSE 0
        END AS total_dolar, */       
   FROM ordenes o
     LEFT JOIN ( SELECT f.orden_id, pp.state_id, 
            sum(COALESCE(pp.total, 0::numeric) + COALESCE(pi.total, 0::numeric)) AS total,
            sum(round(COALESCE(pp.total_dolar, 0::numeric) + COALESCE(pi.total_dolar, 0::numeric), 2)) AS total_dolar
           FROM facturas f
             RIGHT JOIN ( SELECT p.factura_id, p.state_id, 
                    round(sum(round(pl.monto, 2) - pl.monto_credito), 2) AS total,
                    sum((round(pl.monto, 2) - pl.monto_credito) / COALESCE(f_1.cot_dolar, 1::numeric)) AS total_dolar
                   FROM pagos p
                     JOIN facturas f_1 ON f_1.id = p.factura_id
                     JOIN pagos_lineas pl ON pl.pago_id = p.id
                  WHERE ((ordenn_id IS NULL OR f_1.orden_id = ordenn_id) AND p.tipo::text = 'payment'::text OR p.proveedor_id = 4427 OR (p.proveedor_id IN ( SELECT proveedores.id
                           FROM proveedores
                          WHERE proveedores.oficio = true))) AND (p.state_id = 23 OR p.state_id = 27 OR p.state_id = 25)
                  GROUP BY p.factura_id, p.state_id) pp ON pp.factura_id = f.id
             LEFT JOIN ( SELECT p.factura_id, 
                    sum(round(COALESCE(pl.monto, 0::numeric), 2) - round(COALESCE(pl.monto_credito, 0::numeric), 2)) AS total,
                    sum((round(COALESCE(pl.monto, 0::numeric), 2) - round(COALESCE(pl.monto_credito, 0::numeric), 2)) / COALESCE(f_1.cot_dolar, 1::numeric)) AS total_dolar
                   FROM pagos p
                     JOIN facturas f_1 ON f_1.id = p.factura_id
                     JOIN pagos_lineas pl ON pl.pago_id = p.id
                  WHERE (ordenn_id IS NULL OR f_1.orden_id = ordenn_id) AND p.tipo::text = 'impuestos'::text AND p.state_id <> 26 AND p.proveedor_id <> 4427 AND NOT (p.proveedor_id IN ( SELECT proveedores.id
                           FROM proveedores
                          WHERE proveedores.oficio = true))
                  GROUP BY p.factura_id
                  ORDER BY p.factura_id) pi ON pi.factura_id = f.id
          WHERE f.orden_id IS NOT NULL
          GROUP BY f.orden_id, pp.state_id) pagado ON pagado.orden_id = o.id
          WHERE (ordenn_id IS NULL OR o.id = ordenn_id)
  GROUP BY o.id, pagado.total, pagado.total_dolar,  pagado.state_id

	loop

	IF (rec.state_id = 26 OR rec.state_id = 24) THEN
		UPDATE totales_por_orden SET total_pago = 0, total_pago_divisa = 0 WHERE orden_id = rec.orden_id;
	ELSE
		UPDATE totales_por_orden SET total_pago = rec.total_pagado, total_pago_divisa = COALESCE(rec.total_pagado_divisa,0) WHERE orden_id = rec.orden_id;
	END IF;
end loop;

end
$BODY$;

ALTER FUNCTION public.actualiza_totales_ordenes_pagos(integer)
    OWNER TO administrador;
