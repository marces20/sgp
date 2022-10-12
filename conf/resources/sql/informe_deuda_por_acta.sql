-- View: informe_deuda_actas

-- DROP VIEW informe_deuda_actas;

DROP VIEW public.informe_deuda_actas;

CREATE OR REPLACE VIEW public.informe_deuda_actas
 AS
 SELECT 'AC'::text || row_number() OVER () AS id_fake,
    acta.id,
    NULL::integer AS certificacion_id,
    a.profe,
    a.fecha,
    COALESCE(a.numero, ''::character varying) AS acta_numero,
    a.orden_id,
    a.orden_provision_id,
    ordenes.tipo_cuenta_id,
    COALESCE(a.total, 0::numeric) AS total_acta,
    COALESCE(p.total, 0::numeric) AS total_pagado,
        CASE
            WHEN oec.orden_id IS NOT NULL THEN 0::numeric
            WHEN a.es_dolar THEN (COALESCE(a.total_dolar, 0::numeric) - COALESCE(p.total_dolar, 0::numeric)) * (( SELECT ultimas_cotizaciones.cotizacion
               FROM ultimas_cotizaciones
              WHERE ultimas_cotizaciones.tipo_moneda = a.tipo_moneda
              ORDER BY ultimas_cotizaciones.fecha DESC
             LIMIT 1))
            ELSE COALESCE(a.total, 0::numeric) - COALESCE(p.total, 0::numeric)
        END AS total_deuda,
        CASE
            WHEN oec.orden_id IS NOT NULL THEN 0::numeric
            WHEN a.es_dolar THEN (COALESCE(a.total_dolar, 0::numeric) - COALESCE(p.total, 0::numeric) / (( SELECT ultimas_cotizaciones.cotizacion
               FROM ultimas_cotizaciones
              WHERE ultimas_cotizaciones.tipo_moneda = a.tipo_moneda AND ultimas_cotizaciones.ejercicio_id = e.ejercicio_id
              ORDER BY ultimas_cotizaciones.fecha DESC
             LIMIT 1))) * (( SELECT ultimas_cotizaciones.cotizacion
               FROM ultimas_cotizaciones
              WHERE ultimas_cotizaciones.tipo_moneda = a.tipo_moneda AND ultimas_cotizaciones.ejercicio_id = e.ejercicio_id
              ORDER BY ultimas_cotizaciones.fecha DESC
             LIMIT 1))
            ELSE COALESCE(a.total, 0::numeric) - COALESCE(p.total, 0::numeric)
        END AS total_deuda_limite,
    ordenes.proveedor_id,
    ordenes.expediente_id,
    acta.ejercicio_id,
    COALESCE(autorizado.total, 0::numeric) AS total_autorizado,
    a.periodo,
    a.es_dolar,
    a.rubro_id,
    a.perimido
   FROM ( SELECT a_1.id AS acta_id,
            COALESCE(pe.nombre, ''::character varying) AS periodo,
            o.profe,
            a_1.fecha,
            a_1.numero,
            o.id AS orden_id,
            op.id AS orden_provision_id,
            o.tipo_moneda,
            sum(COALESCE(al.total, 0::numeric)) AS total,
            sum(COALESCE(al.total_dolar, 0::numeric)) AS total_dolar,
            al.es_dolar,
            o.orden_rubro_id AS rubro_id,
            o.perimido
           FROM vista_actas_totales al
             JOIN actas_recepcion a_1 ON a_1.id = al.id
             JOIN ordenes_provision op ON op.id = a_1.orden_provision_id
             JOIN ordenes o ON o.id = op.orden_compra_id
             LEFT JOIN periodos pe ON pe.id = a_1.periodo_id
             LEFT JOIN periodos peo ON peo.id = o.periodo_id
          WHERE a_1.state_id = 40
          GROUP BY a_1.id, pe.nombre, o.id, op.id, al.es_dolar) a
     JOIN actas_recepcion acta ON acta.id = a.acta_id
     JOIN ordenes_provision orden_provision ON orden_provision.orden_compra_id = a.orden_id
     JOIN ordenes ON ordenes.id = a.orden_id
     LEFT JOIN ( SELECT ordenes_ejercicio_concluido.orden_id
           FROM ordenes_ejercicio_concluido
          GROUP BY ordenes_ejercicio_concluido.orden_id) oec ON oec.orden_id = ordenes.id
     LEFT JOIN expedientes e ON e.id = ordenes.expediente_id
     LEFT JOIN ( SELECT ala.acta_recepcion_id AS acta_id,
            sum(round(COALESCE(pl.monto, 0::numeric) - COALESCE(pl.monto_credito, 0::numeric), 2)) AS total,
            sum(round(COALESCE(pl.monto, 0::numeric) - COALESCE(pl.monto_credito, 0::numeric), 2) / COALESCE(f.cot_dolar, 1::numeric)) AS total_dolar
           FROM autorizado_lineas aul
             JOIN autorizado_linea_actas ala ON ala.autorizado_linea_id = aul.id
             JOIN facturas f ON f.autorizado_id = aul.autorizado_id
             JOIN pagos p_1 ON f.id = p_1.factura_id
             JOIN pagos_lineas pl ON p_1.id = pl.pago_id
          WHERE p_1.state_id = ANY (ARRAY[23, 25, 27])
          GROUP BY ala.acta_recepcion_id
        UNION ALL
         SELECT ala.acta_recepcion_id AS acta_id,
            sum(round(COALESCE(ala.monto, 0::numeric), 2)) AS total,
            sum(round(COALESCE(ala.monto, 0::numeric) / COALESCE(aul.cot_dolar, 1::numeric), 2)) AS total_dolar
           FROM autorizado_lineas aul
             JOIN autorizado_linea_actas ala ON ala.autorizado_linea_id = aul.id
          GROUP BY ala.acta_recepcion_id) p ON p.acta_id = a.acta_id
     LEFT JOIN ( SELECT ala.acta_recepcion_id,
            round(sum(COALESCE(ala.monto, 0::numeric)), 2) AS total
           FROM autorizado_lineas al
             JOIN autorizado_linea_actas ala ON ala.autorizado_linea_id = al.id
          WHERE NOT (al.autorizado_id IN ( SELECT f.autorizado_id
                   FROM autorizados a_1
                     JOIN facturas f ON a_1.id = f.autorizado_id
                     JOIN pagos p_1 ON p_1.factura_id = f.id))
          GROUP BY ala.acta_recepcion_id) autorizado ON autorizado.acta_recepcion_id = a.acta_id
  WHERE ordenes.perimido = false AND NOT (a.orden_id IN ( SELECT a_1.orden_compra_id AS id
           FROM vista_actas_totales a_1
             JOIN ordenes o ON o.id = a_1.orden_compra_id
          WHERE o.monto_adelanto IS NOT NULL AND o.fecha_provision IS NOT NULL AND a_1.state_id = 40
          GROUP BY a_1.orden_compra_id, o.monto_adelanto, o.cot_dolar
         HAVING sum(a_1.total) < (o.monto_adelanto / COALESCE(o.cot_dolar, 1::numeric))))
UNION ALL
 SELECT 'AN'::text || row_number() OVER () AS id_fake,
    o.id,
    NULL::integer AS certificacion_id,
    o.profe,
    o.fecha_orden AS fecha,
    'Anticipo'::character varying AS acta_numero,
    o.id AS orden_id,
    op.id AS orden_provision_id,
    o.tipo_cuenta_id,
    sum(round(o.monto_adelanto, 2)) AS total_acta,
    sum(round(COALESCE(al.monto, 0::numeric), 2)) AS total_pagado,
        CASE
            WHEN oec.orden_id IS NOT NULL THEN 0::numeric
            WHEN o.cot_dolar IS NOT NULL THEN round((sum(round(o.monto_adelanto / COALESCE(o.cot_dolar, 1::numeric), 2)) - sum(round(COALESCE(al.monto_dolar, 0::numeric), 2))) * (( SELECT ultimas_cotizaciones.cotizacion
               FROM ultimas_cotizaciones
              WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda
              ORDER BY ultimas_cotizaciones.fecha DESC
             LIMIT 1)), 2)
            ELSE sum(o.monto_adelanto) - sum(round(COALESCE(al.monto, 0::numeric), 2))
        END AS total_deuda,
        CASE
            WHEN o.cot_dolar IS NOT NULL THEN round((sum(round(o.monto_adelanto / COALESCE(o.cot_dolar, 1::numeric), 2)) - sum(round(COALESCE(al.monto_dolar, 0::numeric), 2))) * (( SELECT ultimas_cotizaciones.cotizacion
               FROM ultimas_cotizaciones
              WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda AND ultimas_cotizaciones.ejercicio_id = e.ejercicio_id
              ORDER BY ultimas_cotizaciones.fecha DESC
             LIMIT 1)), 2)
            ELSE sum(o.monto_adelanto) - sum(round(COALESCE(al.monto, 0::numeric), 2))
        END AS total_deuda_limite,
    o.proveedor_id,
    o.expediente_id,
    e.ejercicio_id,
    COALESCE(al.monto, 0::numeric) AS total_autorizado,
        CASE
            WHEN peo.nombre IS NOT NULL THEN peo.nombre
            ELSE ''::character varying
        END AS periodo,
        CASE
            WHEN o.cot_dolar IS NOT NULL THEN true
            ELSE false
        END AS es_dolar,
    o.orden_rubro_id AS rubro_id,
    o.perimido
   FROM ordenes o
     LEFT JOIN ordenes_provision op ON o.id = op.orden_compra_id
     LEFT JOIN expedientes e ON e.id = o.expediente_id
     LEFT JOIN ( SELECT autorizado_lineas.orden_id,
            sum(round(COALESCE(autorizado_lineas.monto, 0::numeric), 2)) AS monto,
            sum(round(COALESCE(autorizado_lineas.monto, 0::numeric) / COALESCE(autorizado_lineas.cot_dolar, 1::numeric), 2)) AS monto_dolar
           FROM autorizado_lineas
          GROUP BY autorizado_lineas.orden_id) al ON al.orden_id = o.id
     LEFT JOIN ( SELECT vista_actas_totales.orden_compra_id,
            sum(COALESCE(vista_actas_totales.total, 0::numeric)) AS total,
            sum(COALESCE(vista_actas_totales.total_dolar, 0::numeric)) AS total_dolar
           FROM vista_actas_totales
          WHERE (vista_actas_totales.orden_compra_id IN ( SELECT ordenes.id
                   FROM ordenes
                  WHERE ordenes.monto_adelanto IS NOT NULL)) AND vista_actas_totales.state_id = 40
          GROUP BY vista_actas_totales.orden_compra_id) a ON a.orden_compra_id = o.id
     LEFT JOIN periodos peo ON peo.id = o.periodo_id
     LEFT JOIN ( SELECT ordenes_ejercicio_concluido.orden_id
           FROM ordenes_ejercicio_concluido
          GROUP BY ordenes_ejercicio_concluido.orden_id) oec ON oec.orden_id = o.id
  WHERE o.perimido = false AND o.monto_adelanto IS NOT NULL AND o.fecha_provision IS NOT NULL AND o.state_id = 11
  GROUP BY o.id, op.id, e.id, a.total, al.monto, peo.nombre, oec.orden_id
 HAVING COALESCE(a.total, 0::numeric) < (COALESCE(o.monto_adelanto, 0::numeric) / COALESCE(o.cot_dolar, 1::numeric))
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
        CASE
            WHEN oec.orden_id IS NOT NULL THEN 0::numeric
            WHEN o.cot_dolar IS NOT NULL THEN + round((round(sum(COALESCE(certificacion.total::numeric, 0::numeric) / COALESCE(o.cot_dolar, 1::numeric)), 2) - sum(round(COALESCE(al.monto_dolar, 0::numeric), 2))) * (( SELECT ultimas_cotizaciones.cotizacion
               FROM ultimas_cotizaciones
              WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda
              ORDER BY ultimas_cotizaciones.fecha DESC
             LIMIT 1)), 2)
            ELSE sum(round(COALESCE(certificacion.total::numeric, 0::numeric), 2)) - sum(round(COALESCE(al.total, 0::numeric), 2))
        END AS total_deuda,
        CASE
            WHEN o.cot_dolar IS NOT NULL THEN round((round(sum(COALESCE(certificacion.total::numeric, 0::numeric) / COALESCE(o.cot_dolar, 1::numeric)), 2) - sum(round(COALESCE(al.monto_dolar, 0::numeric), 2))) * (( SELECT ultimas_cotizaciones.cotizacion
               FROM ultimas_cotizaciones
              WHERE ultimas_cotizaciones.tipo_moneda = o.tipo_moneda AND ultimas_cotizaciones.ejercicio_id = e.ejercicio_id
              ORDER BY ultimas_cotizaciones.fecha DESC
             LIMIT 1)), 2)
            ELSE sum(round(COALESCE(certificacion.total::numeric, 0::numeric), 2)) - sum(round(COALESCE(al.total, 0::numeric), 2))
        END AS total_deuda_limite,
    o.proveedor_id,
    o.expediente_id,
    e.ejercicio_id,
    COALESCE(al.total, 0::numeric) AS total_autorizado,
    COALESCE(pep.nombre, ''::character varying) AS periodo,
        CASE
            WHEN o.cot_dolar IS NOT NULL THEN true
            ELSE false
        END AS es_dolar,
    o.orden_rubro_id AS rubro_id,
    o.perimido
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
                  WHERE certificaciones_compras_lineas.producto_id <> ALL (ARRAY[40277, 40276, 30653])
                  GROUP BY certificaciones_compras_lineas.certificacion_compra_id
                UNION ALL
                 SELECT certificaciones_compras_linea_ajustes.certificacion_compra_id,
                    sum(COALESCE(certificaciones_compras_linea_ajustes.precio, 0::numeric)::double precision * COALESCE(certificaciones_compras_linea_ajustes.cantidad, 0::double precision)) AS total
                   FROM certificaciones_compras_linea_ajustes
                  WHERE certificaciones_compras_linea_ajustes.producto_id <> ALL (ARRAY[40277, 40276, 30653])
                  GROUP BY certificaciones_compras_linea_ajustes.certificacion_compra_id) linea ON linea.certificacion_compra_id = cc_1.id
          WHERE cc_1.state_id = 81
          GROUP BY cc_1.id) certificacion ON certificacion.id = cc.id
     LEFT JOIN ( SELECT ordenes_ejercicio_concluido.orden_id
           FROM ordenes_ejercicio_concluido
          GROUP BY ordenes_ejercicio_concluido.orden_id) oec ON oec.orden_id = o.id
  WHERE o.perimido = false AND o.state_id = 11 AND cc.state_id = 81 AND (o.tipo_orden::text = 'certificacioncompra'::text OR o.tipo_orden::text = 'certificacionobra'::text)
  GROUP BY cc.id, o.id, e.ejercicio_id, certificacion.total, al.total, certificacion.fecha, pep.nombre, oec.orden_id;

ALTER TABLE public.informe_deuda_actas
    OWNER TO root;

