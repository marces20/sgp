--Agentes
DROP TRIGGER auditoria_agentes ON agentes;
CREATE TRIGGER auditoria_agentes AFTER INSERT OR UPDATE ON agentes FOR EACH ROW
EXECUTE PROCEDURE auditoria_registra_cambios('{apellido, dni, cuil, asignacion_familiar}');
--familia
DROP TRIGGER auditoria_hijos ON agente_familias;
CREATE TRIGGER agente_familias AFTER INSERT OR UPDATE ON agentes FOR EACH ROW
EXECUTE PROCEDURE auditoria_registra_cambios('{fnacimiento, discapacidad, vive, finicio_certificado_ar, ffin_certificado_ar, f_discapacidad, carga_en_conyugue, fpresentacion}');