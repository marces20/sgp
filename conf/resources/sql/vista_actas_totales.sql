DROP VIEW public.vista_actas_totales;

CREATE OR REPLACE VIEW public.vista_actas_totales
 AS
 SELECT acta.id,
    a.orden_provision_id,
    round(sum(acta.total), 2) AS total,
    round(sum(acta.total /
        CASE
            WHEN a.cot_dolar IS NOT NULL THEN NULLIF(o.cot_dolar, 1::numeric)
            ELSE COALESCE(o.cot_dolar, 1::numeric)
        END), 2) AS total_dolar,
    a.state_id,
    op.orden_compra_id,
        CASE
            WHEN o.cot_dolar IS NOT NULL THEN true
            ELSE false
        END AS es_dolar,
        CASE
            WHEN a.cot_dolar IS NOT NULL THEN COALESCE(a.cot_dolar, 1::numeric)
            ELSE COALESCE(o.cot_dolar, 1::numeric)
        END AS cotizacion
   FROM actas_recepcion a
     LEFT JOIN ( SELECT rec.acta_id AS id,
            round(COALESCE(sum(ol.precio * rl.cantidad)), 2) AS total
           FROM actas_recepcion a_1
             JOIN recepciones rec ON a_1.id = rec.acta_id
             JOIN remitos rem ON rem.recepcion_id = rec.id
             JOIN remitos_lineas rl ON rl.remito_id = rem.id
             JOIN orden_lineas ol ON ol.id = rl.linea_orden_id
          WHERE rec.acta_id IS NOT NULL
          GROUP BY rec.acta_id
        UNION ALL
         SELECT cs.acta_id AS id,
            round(COALESCE(sum(csl.precio * csl.cantidad), 0::numeric), 2) AS total
           FROM actas_recepcion a_1
             JOIN certificaciones_servicios cs ON a_1.id = cs.acta_id
             JOIN certificaciones_servicios_lineas csl ON cs.id = csl.certificaciones_servicio_id
          WHERE cs.acta_id IS NOT NULL
          GROUP BY cs.acta_id
        UNION ALL
         SELECT aa.acta_id,
            round(COALESCE(sum(ola.cantidad * ola.precio), 0::numeric), 2) AS total
           FROM actas_ajustes aa
             JOIN orden_lineas_ajustes ola ON ola.id = aa.ajuste_id
          WHERE ola.producto_id <> ALL (ARRAY[40277, 40276, 30653])
          GROUP BY aa.acta_id
        UNION ALL
         SELECT arl.acta_id AS id,
            round(COALESCE(sum(arl.cantidad * arl.precio), 0::numeric), 2) AS total
           FROM actas_recepcion a_1
             JOIN actas_recepcion_lineas_ajustes arl ON a_1.id = arl.acta_id
          WHERE arl.acta_id IS NOT NULL AND (arl.producto_id <> ALL (ARRAY[40277, 40276, 30653]))
          GROUP BY arl.acta_id) acta ON acta.id = a.id
     JOIN ordenes_provision op ON op.id = a.orden_provision_id
     JOIN ordenes o ON o.id = op.orden_compra_id
  GROUP BY acta.id, a.orden_provision_id, a.state_id, op.orden_compra_id, o.cot_dolar, a.cot_dolar;

ALTER TABLE public.vista_actas_totales
    OWNER TO root;

