-- Cotizaciones
CREATE INDEX idx_ultimas_cot_lookup 
ON ultimas_cotizaciones(tipo_moneda, ejercicio_id, fecha DESC);

-- Actas
CREATE INDEX idx_actas_state ON actas_recepcion(state_id) WHERE state_id = 40;
CREATE INDEX idx_actas_provision ON actas_recepcion(orden_provision_id);

-- Pagos
CREATE INDEX idx_pagos_state ON pagos(state_id) WHERE state_id IN (23, 25, 27);
CREATE INDEX idx_pagos_factura ON pagos(factura_id);

-- Órdenes
CREATE INDEX idx_ordenes_perimido ON ordenes(perimido) WHERE perimido = false;
CREATE INDEX idx_ordenes_adelanto ON ordenes(id) WHERE monto_adelanto IS NOT NULL;
CREATE INDEX idx_ordenes_state ON ordenes(state_id) WHERE state_id = 11;

-- Certificaciones
CREATE INDEX idx_cert_state ON certificaciones_compras(state_id) WHERE state_id = 81;
CREATE INDEX idx_cert_orden ON certificaciones_compras(orden_id);

-- Autorizado
CREATE INDEX idx_autorizado_lineas_orden ON autorizado_lineas(orden_id);
CREATE INDEX idx_autorizado_linea_actas_acta ON autorizado_linea_actas(acta_recepcion_id);
CREATE INDEX idx_autorizado_linea_actas_cert ON autorizado_linea_actas(certificacion_compra_id);
