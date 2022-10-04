package models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
@Entity
@Table(name = "estados")
public class Estado extends Model {
	
private static final long serialVersionUID = 1L;
	
	public static final Integer TIPO_SOLICITUD = 1;
	public static final Integer TIPO_ORDEN = 2;
	public static final Integer TIPO_FACTURA = 3;
	public static final Integer TIPO_PAGO = 4;
	public static final Integer TIPO_CERTIFICACION = 5;
	public static final Integer TIPO_CUENTA_BANCARIA = 6;
	public static final Integer TIPO_ACTA = 7;
	public static final Integer TIPO_CERTIFICACION_SERVICIO = 8;
	public static final Integer TIPO_AGENTE = 9;
	public static final Integer TIPO_LIQUIDACION_PUESTOS = 10;
	public static final Integer TIPO_PUESTO_LABORAL = 11;
	public static final Integer TIPO_LIQUIDACION_MESES = 12;
	public static final Integer TIPO_PRESUPUESTO = 13;
	public static final Integer TIPO_RECUPERO_FACTURA = 14;
	public static final Integer TIPO_RECUPERO_PAGO = 15;
	public static final Integer ORDEN_PAGO_CIRCUITO = 16;
	public static final Integer TIPO_CERTIFICACION_COMPRA = 17;
	public static final Integer TIPO_AUTORIZADO = 18;
	public static final Integer TIPO_CAJA_CHICA = 19;
	public static final Integer TIPO_AGENTE_INASISTENCIA = 20;
	public static final Integer TIPO_TICKET = 21;
	public static final Integer	BALANACE = 22;
	public static final Integer	DISPOS = 23;
	public static final Integer	AGENTE_SEGUIMIENTO = 24;
	public static final Integer	ACTA_MOVIMIENTO = 25;
	
	public static final int SOLICITUD_ESTADO_BORRADOR = 1;
	public static final int SOLICITUD_ESTADO_ENCURSO = 2;
	public static final int SOLICITUD_APROBADO_JEFE = 22;
	public static final int SOLICITUD_ESTADO_ADMINISTRACION = 3;
	public static final int SOLICITUD_ESTADO_APRESUPUESTO = 4;
	public static final int SOLICITUD_ESTADO_AUTORIZADO = 5;
	public static final int SOLICITUD_ESTADO_CANCELADO = 6;
	public static final int SOLICITUD_ESTADO_ADEPTO = 49;
	public static final int SOLICITUD_ESTADO_PREAPROBADO = 50;
	public static final int SOLICITUD_ESTADO_RESERVADO = 83;
	
	public static final int ORDEN_ESTADO_FINALIZADO = 10;
	public static final int ORDEN_ESTADO_APROBADO = 11;
	public static final int ORDEN_ESTADO_BORRADOR = 12;
	public static final int ORDEN_ESTADO_CANCELADO = 13;
	public static final int ORDEN_ESTADO_ENCURSO = 14;
	public static final int ORDEN_ESTADO_EXCENVIO = 15;
	public static final int ORDEN_ESTADO_EXCFACTURA = 16;
	public static final int ORDEN_ESTADO_PRECURSO = 87;
	
	public static final int FACTURA_ESTADO_BORRADOR = 18;
	public static final int FACTURA_ESTADO_ENCURSO = 17;
	public static final int FACTURA_ESTADO_PREAPROBADO = 33;
	public static final int FACTURA_ESTADO_APROBADO = 19;
	public static final int FACTURA_ESTADO_PAGADO = 20;
	public static final int FACTURA_ESTADO_CANCELADO = 21;
	public static final int FACTURA_ESTADO_PRECURSO = 60;

	public static final int PAGO_ESTADO_CONCILIADO = 25;
	public static final int PAGO_ESTADO_BORRADOR = 24;
	public static final int PAGO_ESTADO_PAGADO = 23;
	public static final int PAGO_ESTADO_CANCELADO = 26;
	public static final int PAGO_ESTADO_EN_CURSO = 27;
	
	public static final int ORDEN_PAGO_CIRCUITO_ESTADO_BORRADOR= 73;
	public static final int ORDEN_PAGO_CIRCUITO_ESTADO_CONTABILIDAD = 74;
	public static final int ORDEN_PAGO_CIRCUITO_ESTADO_RENDICIONES = 75;
	public static final int ORDEN_PAGO_CIRCUITO_ESTADO_RENDIDO = 76;
	public static final int ORDEN_PAGO_CIRCUITO_ESTADO_CANCELADO = 77;
	
	public static final int CERTIFICACION_ESTADO_BORRADOR = 28;
	public static final int CERTIFICACION_ESTADO_ENCURSO = 29;
	public static final int CERTIFICACION_ESTADO_CERTIFICADO = 30;
	public static final int CERTIFICACION_ESTADO_IMPUTADO = 31;
	public static final int CERTIFICACION_ESTADO_CANCELADO = 32;
	
	public static final int CUENTA_BANCARIA_ESTADO_BORRADOR = 34;
	public static final int CUENTA_BANCARIA_ESTADO_ENCURSO = 35;
	public static final int CUENTA_BANCARIA_ESTADO_APROBADO = 36;
	public static final int CUENTA_BANCARIA_ESTADO_CANCELADO = 37;
	
	public static final int ACTA_ESTADO_BORRADOR = 38;
	public static final int ACTA_ESTADO_ENCURSO = 39;
	public static final int ACTA_ESTADO_APROBADA = 40;
	public static final int ACTA_ESTADO_CANCELADA = 41;
	public static final int ACTA_ESTADO_PRECALCULAR_AJUSTES = 101;
	
	public static final int CERTIFICACION_SERVICIO_CANCELADA = 44;
	public static final int CERTIFICACION_SERVICIO_BORRADOR = 43;
	public static final int CERTIFICACION_SERVICIO_CERTIFICADA = 42;
	public static final int CERTIFICACION_SERVICIO_NOCERTIFICADA = 88;
	
	public static final int AGENTE_CARGADO = 45;
	public static final int AGENTE_APROBADO = 46;
	public static final int AGENTE_CANCELADO = 47;
	public static final int AGENTE_BORRADOR = 48;
	public static final int AGENTE_PREAPROBADO = 51;
	
	public static final int LIQUIDACION_PUESTOS_BORRADOR = 52;
	public static final int LIQUIDACION_PUESTOS_PREAPROBADO = 59;
	public static final int LIQUIDACION_PUESTOS_APROBADO = 53;
	public static final int LIQUIDACION_PUESTOS_CANCELADO = 54;
	
	public static final int PUESTO_LABORAL_BORRADOR = 55;
	public static final int PUESTO_LABORAL_CONTROLADO = 109;
	public static final int PUESTO_LABORAL_CANCELADO = 56;
	
	public static final int LIQUIDACION_MES_BORRADOR = 57;
	public static final int LIQUIDACION_MES_APROBADO = 58;
	public static final int LIQUIDACION_MES_PRELIQUIDAR = 102;
	public static final int LIQUIDACION_MES_LIQUIDADO = 103;
	public static final int LIQUIDACION_MES_CANCELADO = 78;
	public static final int LIQUIDACION_MES_CERRADA = 108;
	
	public static final int PRESUPUESTO_BORRADOR = 61;
	public static final int PRESUPUESTO_ENCURSO = 62;
	public static final int PRESUPUESTO_APROBADO = 63;
	public static final int PRESUPUESTO_CANCELADO = 64;
	
	public static final int RECUPERO_FACTURA_BORRADOR = 65;
	public static final int RECUPERO_FACTURA_ENCURSO = 66;
	public static final int RECUPERO_FACTURA_APROBADO = 67;
	public static final int RECUPERO_FACTURA_CANCELADO = 68;
	
	public static final int RECUPERO_PAGO_BORRADOR = 69;
	public static final int RECUPERO_PAGO_ENCURSO = 70;
	public static final int RECUPERO_PAGO_PAGADO = 71;
	public static final int RECUPERO_PAGO_CANCELADO = 72;
	
	public static final int CERTIFICACION_COMPRA_ESTADO_BORRADOR = 79;
	public static final int CERTIFICACION_COMPRA_ESTADO_ENCURSO = 80;
	public static final int CERTIFICACION_COMPRA_ESTADO_CERTIFICADO = 81;
	public static final int CERTIFICACION_COMPRA_ESTADO_CANCELADO = 82;
	
	public static final int AUTORIZADO_ESTADO_BORRADOR = 84;
	public static final int AUTORIZADO_ESTADO_APROBADO = 85;
	public static final int AUTORIZADO_ESTADO_CANCELADO = 86;
	
	public static final int CAJA_CHICA_BORRADOR  = 91;
	public static final int CAJA_CHICA_CANCELADA = 92;
	public static final int CAJA_CHICA_ABIERTA 	 = 89;
	public static final int CAJA_CHICA_CERRADA 	 = 90;
	
	public static final int AGENTE_LICENCIA_BORRADOR  = 93;
	public static final int AGENTE_LICENCIA_APROBADO = 94;
	public static final int AGENTE_LICENCIA_CANCELADO = 95;
	public static final int AGENTE_LICENCIA_PREAPROBADO = 96;
	
	public static final int TICKET_ABIERTO = 97;
	public static final int TICKET_EN_PROCESO = 98;
	public static final int TICKET_CERRADO = 99;
	public static final int TICKET_CANCELADO = 100;
	
	public static final int BALANCE_BORRADOR = 104;
	public static final int BALANCE_CONTROLADO = 105;
	
	public static final int DISPO_ACTIVA = 106;
	public static final int DISPO_DESACTIVA = 107;
	
	public static final int AGENTE_SEGUIMIENTO_BORRADOR  = 110;
	public static final int AGENTE_SEGUIMIENTO_PROCESO = 111;
	public static final int AGENTE_SEGUIMIENTO_CERRADO = 112;
	
	public static final int ACTA_MOVIMIENTO_RECEPCIONADO = 113;
	public static final int ACTA_MOVIMIENTO_RECEPCIONADO_AUTOMATICO = 114;
	public static final int ACTA_MOVIMIENTO_RECEPCIONADO_CANCELADO = 115;
	public static final int ACTA_MOVIMIENTO_ENVIADO = 116;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estados_id_seq")
    public Integer id;
	
	@Required(message="Debe escribir el nombre")
	public String nombre;
	
	@Required(message="Debe escribir un tipo")
	public Integer tipo;
	
	public Integer orden;
	
	@Required(message="Debe escribir la descripcion.")
	public String descripcion;
	
	public String significado;
	
	public static Model.Finder<Long,Estado> find = new Model.Finder<Long,Estado>(Long.class, Estado.class);
	
	public static List<Estado> getSiguienteEstadoPorAprobar(Integer orden,Integer tipo){
		Logger.debug("11111111111111111111111111111111111111111111111 "+orden+" - "+tipo);
		return Estado.find.where().gt("orden", orden).eq("tipo", tipo).orderBy("orden").setMaxRows(1).findList();
	}
	
	public static Estado getEstado(Long id,Integer tipo){
		return Estado.find.where().eq("id", id).eq("tipo", tipo).findUnique();
	}
	
	public static List<Estado> getEstados(Integer tipo){	
		return Estado.find.where().eq("tipo", tipo).findList();
	}
	
	/*
	public List<Estado> getSiguientesEstadosAprobacion (Integer id){
		return Estado.find.where().ge("id" , id).eq("tipo", TIPO_SOLICITUD).findList();
	}
	*/
}
