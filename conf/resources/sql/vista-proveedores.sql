-- View: informe_estadistico_deuda_proveedores
-- DROP VIEW public.informe_estadistico_deuda_proveedores;

CREATE OR REPLACE VIEW public.informe_estadistico_deuda_proveedores
 AS
 SELECT o.id,
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
    o.perimido,
        CASE
            WHEN o.fecha_provision IS NOT NULL THEN o.monto_adelanto
            ELSE 0::numeric
        END AS monto_adelanto,
    ord.total_orden,
    ord.total_pago AS total_pagado,
    ord.total_autorizado,
    ord.total_recepcionado,
    COALESCE(sum(actas_sin_adelanto.total::double precision * COALESCE(o.cot_dolar, 1::numeric)::double precision), 0::numeric::double precision) AS total_actas_sin_adelanto,
    0 AS total_deuda_en_tramite,
    COALESCE(sum(a.total * COALESCE(o.cot_dolar, 1::numeric)::double precision), 0::numeric::double precision) AS total_actas,
        CASE
            WHEN oec.orden_id IS NOT NULL THEN 0::numeric
            WHEN o.cot_dolar IS NOT NULL THEN (COALESCE(sum(a.total_dolar), 0::numeric) - COALESCE(oec.total, 0::numeric) - COALESCE(sum(GREATEST(ord.total_pago_divisa, ord.total_autorizado_divisa)), 0::numeric)) * cotizacion.valor
            ELSE round((COALESCE(sum(a.total), 0::double precision) - COALESCE(sum(GREATEST(ord.total_pago, ord.total_autorizado))::double precision, 0::double precision) - COALESCE(oec.total::double precision, 0::double precision))::numeric, 2)
        END AS total_deuda,
        CASE
            WHEN o.cot_dolar IS NOT NULL THEN ((ord.total_orden_divisa - COALESCE(sum(ord.total_pago_divisa), 0::numeric) - (COALESCE(sum(a.total_dolar), 0::numeric) - COALESCE(sum(ord.total_pago_divisa), 0::numeric))) * cotizacion.valor)::double precision
            ELSE round((ord.total_orden::double precision - COALESCE(sum(ord.total_pago)::double precision, 0::double precision) - (COALESCE(sum(a.total), 0::double precision) - COALESCE(sum(ord.total_pago)::double precision, 0::double precision)))::numeric, 2)::double precision
        END AS total_compromiso,
    o.tipo_moneda
   FROM ordenes o
     LEFT JOIN ( SELECT ultimas_cotizaciones.cotizacion AS valor,
            ultimas_cotizaciones.tipo_moneda
           FROM ultimas_cotizaciones
          WHERE (ultimas_cotizaciones.id IN ( SELECT max(uc.id) AS id
                   FROM ultimas_cotizaciones uc
                  GROUP BY uc.tipo_moneda
                  ORDER BY (max(uc.fecha)), (max(uc.id)) DESC))) cotizacion ON cotizacion.tipo_moneda = o.tipo_moneda
     LEFT JOIN ( SELECT ordenes_ejercicio_concluido.orden_id,
            sum(round(ordenes_ejercicio_concluido.total / ordenes_ejercicio_concluido.cotizacion, 2)) AS total
           FROM ordenes_ejercicio_concluido
          GROUP BY ordenes_ejercicio_concluido.orden_id) oec ON oec.orden_id = o.id
     LEFT JOIN ( SELECT asd_2.orden_compra_id AS id,
            sum(asd_2.total) AS total,
            sum(asd_2.total_dolar) AS total_dolar
           FROM vista_actas_totales asd_2
          WHERE asd_2.state_id = 40
          GROUP BY asd_2.orden_compra_id) actas_sin_adelanto ON actas_sin_adelanto.id = o.id
     LEFT JOIN totales_por_orden ord ON ord.orden_id = o.id
     LEFT JOIN ( SELECT DISTINCT a_1.orden_id,
            max(a_1.total) AS total,
            max(a_1.total_dolar) AS total_dolar
           FROM ( SELECT a_2.orden_compra_id AS orden_id,
                    sum(a_2.total) AS total,
                    sum(a_2.total_dolar) AS total_dolar
                   FROM vista_actas_totales a_2
                  WHERE a_2.state_id = 40
                  GROUP BY a_2.orden_compra_id
                UNION
                 SELECT ordenes.id AS orden_id,
                    COALESCE(ordenes.monto_adelanto, 0::numeric) AS total,
                    round(COALESCE(ordenes.monto_adelanto, 0::numeric) / COALESCE(ordenes.cot_dolar, 1::numeric), 2) AS total_dolar
                   FROM ordenes
                  WHERE ordenes.monto_adelanto > 0::numeric AND ordenes.fecha_provision IS NOT NULL AND (ordenes.tipo_orden::text <> 'haberesrelacion'::text OR ordenes.tipo_orden::text <> 'certificacioncompra'::text OR ordenes.tipo_orden::text <> 'certificacionobra'::text)) a_1
          GROUP BY a_1.orden_id
        UNION
         SELECT o_1.id,
            sum(round(ol.precio * ol.cantidad, 2)) + sum(round(COALESCE(ola.precio, 0::numeric) * COALESCE(ola.cantidad, 0::numeric), 2)) AS total,
            0 AS total_dolar
           FROM ordenes o_1
             JOIN orden_lineas ol ON ol.orden_id = o_1.id
             LEFT JOIN orden_lineas_ajustes ola ON ola.orden_id = o_1.id
          WHERE (o_1.state_id = 11 OR o_1.state_id = 14) AND o_1.tipo_orden::text = 'haberesrelacion'::text
          GROUP BY o_1.id
        UNION
         SELECT cc.orden_id,
            sum(cl.total) AS total,
            round((sum(cl.total) / COALESCE(o_1.cot_dolar, 1::numeric)::double precision)::numeric, 2) AS total_dolar
           FROM ( SELECT certificaciones_compras_lineas.certificacion_compra_id,
                    sum(certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision - certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision * round(COALESCE(certificaciones_compras_lineas.descuento, 0::numeric), 2)::double precision / 100::double precision) AS total
                   FROM certificaciones_compras_lineas
                  WHERE certificaciones_compras_lineas.producto_id <> ALL (ARRAY[40277, 40276, 30653])
                  GROUP BY certificaciones_compras_lineas.certificacion_compra_id
                UNION ALL
                 SELECT certificaciones_compras_linea_ajustes.certificacion_compra_id,
                    sum(COALESCE(certificaciones_compras_linea_ajustes.precio, 0::numeric)::double precision * COALESCE(certificaciones_compras_linea_ajustes.cantidad, 0::double precision)) AS total
                   FROM certificaciones_compras_linea_ajustes
                  WHERE certificaciones_compras_linea_ajustes.producto_id <> ALL (ARRAY[40277, 40276, 30653])
                  GROUP BY certificaciones_compras_linea_ajustes.certificacion_compra_id) cl
             JOIN certificaciones_compras cc ON cc.id = cl.certificacion_compra_id
             JOIN ordenes o_1 ON o_1.id = cc.orden_id
          WHERE cc.state_id = 81 AND o_1.perimido = false
          GROUP BY cc.orden_id, cc.state_id, o_1.cot_dolar) a ON a.orden_id = o.id
     LEFT JOIN proveedores pr ON pr.id = o.proveedor_id
     LEFT JOIN expedientes e ON e.id = o.expediente_id
     LEFT JOIN ejercicios ej ON ej.id = e.ejercicio_id
     LEFT JOIN ordenes_provision op ON op.orden_compra_id = o.id
     LEFT JOIN ordenes_rubros r ON r.id = o.orden_rubro_id
  WHERE o.state_id <> 13 AND (op.id IS NOT NULL OR (o.id IN ( SELECT certificaciones_compras.orden_id
           FROM certificaciones_compras
          GROUP BY certificaciones_compras.orden_id)) OR o.tipo_orden::text = 'haberesrelacion'::text)
  GROUP BY o.id, op.id, ord.total_orden, ord.total_pago, ord.total_autorizado, ord.total_recepcionado, ord.total_orden_divisa, oec.total, oec.orden_id, o.nombre, o.expediente_id, e.ejercicio_id, o.numero_orden_provision, o.profe, e.nombre, ej.nombre, o.orden_rubro_id, r.nombre, pr.id, pr.nombre, o.deposito_id, cotizacion.valor;

ALTER TABLE public.informe_estadistico_deuda_proveedores
    OWNER TO root;


