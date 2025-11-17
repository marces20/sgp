package models.novedades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;

import com.avaje.ebean.SqlRow;
import models.Periodo;
import models.haberes.PuestoLaboral;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name = "produccion_puesto_laboral_periodos")
public class ProduccionPuestoPeriodo extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produccion_puesto_laboral_periodos_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name = "puesto_laboral_id", referencedColumnName = "id", insertable = false, updatable = false)
	public PuestoLaboral puestoLaboral;
	@Required(message = "Requiere un puesto laboral")
	public Long puesto_laboral_id;

	public String nombre_rismi;

	public String codigo_ips;

	public BigDecimal cantidad;

	public BigDecimal valor_ips;

	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	@Required(message="Debe seleccionar un periodo")
	public Integer periodo_id;

	@ManyToOne
	@JoinColumn(name="planificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public Planificacion planificacion;
	public Long planificacion_id;

	public BigDecimal getTotal(){
		return cantidad.multiply(valor_ips);
	}

	public static Model.Finder<Long,ProduccionPuestoPeriodo> find = new Finder<Long,ProduccionPuestoPeriodo>(Long.class, ProduccionPuestoPeriodo.class);

	public static BigDecimal getValorIps(String codigoIps) {

		BigDecimal ret = BigDecimal.ZERO;

		if(codigoIps != null) {
			String sql = " SELECT valor_ips FROM produccion_ips_nomencladores where codigo_ips = :codigo_ips and periodo_hasta_id is null";

			List<com.avaje.ebean.SqlRow> l = Ebean.createSqlQuery(sql).setParameter("codigo_ips", codigoIps).findList();
			if(l.size() > 0) {
				ret = l.get(0).getBigDecimal("valor_ips").multiply(new BigDecimal(0.6)).setScale(4, RoundingMode.HALF_DOWN);
			}

		}
		return  ret;
	}

	public static List<SqlRow> getProduccionMes(Long planificacion_id){

		/*String sql = "SELECT " +
				"pl.id as puesto_laboral_id,p.nombre, a.apellido as apellido, a.organigrama_id, o.nombre, " +
				"elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615) monto_tope , " +
				"coalesce(prod_topes.tope_produccion,1) cant_topes, " +
				"round(sum(prod_mes.cantidad * prod_nom.valor_ips * coalesce(prod_coef.coeficiente, 60) / 100),2) produccion_mes, " +
				"round(case when sum(prod_mes.cantidad * prod_nom.valor_ips * coalesce(prod_coef.coeficiente, 60) / 100) - (elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615)) > (elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615))* coalesce(prod_topes.tope_produccion,1) THEN " +
				"(elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615))* coalesce(prod_topes.tope_produccion,1) " +
				"when sum(prod_mes.cantidad * prod_nom.valor_ips * coalesce(prod_coef.coeficiente, 60) / 100) - (elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615)) < 0 " +
				"THEN 0 ELSE sum(prod_mes.cantidad * prod_nom.valor_ips * coalesce(prod_coef.coeficiente, 60) / 100) - (elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615)) END,2) total_produccion " +

				"FROM produccion_puesto_laboral_periodos prod_mes " +

				"JOIN produccion_ips_nomencladores prod_nom ON " +
				"(prod_mes.codigo_ips = prod_nom.codigo_ips and prod_mes.periodo_id between prod_nom.periodo_desde_id and coalesce(prod_nom.periodo_hasta_id,prod_mes.periodo_id)) " +

				"LEFT JOIN produccion_puesto_laboral_coeficientes prod_coef ON " +
				"(prod_coef.puesto_laboral_id = prod_mes.puesto_laboral_id AND prod_coef.codigo_ips = prod_coef.codigo_ips AND prod_mes.periodo_id between prod_coef.periodo_desde_id and coalesce(prod_coef.periodo_hasta_id, prod_mes.periodo_id)) " +

				"LEFT JOIN produccion_profesional_topes prod_topes ON " +
				"(prod_mes.puesto_laboral_id = prod_topes.puesto_laboral_id AND prod_mes.periodo_id BETWEEN prod_topes.periodo_desde_id AND COALESCE(prod_topes.periodo_hasta_id, prod_mes.periodo_id)) " +

				"JOIN puestos_laborales pl on prod_mes.puesto_laboral_id = pl.id " +
				"JOIN legajos l on pl.legajo_id = l.id " +
				"JOIN agentes a on l.agente_id = a.id " +
				"JOIN organigramas o on a.organigrama_id = o.id " +
				"JOIN periodos p on p.id = prod_mes.periodo_id " +
				"LEFT JOIN escalas_laborales_montos elm ON " +
				"(elm.escala_laboral_id = pl.escala_laboral_id AND elm.liquidacion_concepto_id = 15 AND " +
				"prod_mes.periodo_id BETWEEN elm.periodo_desde_id and coalesce(elm.periodo_hasta_id, prod_mes.periodo_id)) " +
				"LEFT JOIN liquidacion_conceptos_especialidad espe ON " +
				"(espe.especialidad_id = pl.especialidad_id AND prod_mes.periodo_id  BETWEEN espe.periodo_desde_id AND coalesce(espe.periodo_hasta_id, prod_mes.periodo_id)) " +
				"WHERE prod_mes.planificacion_id = :planificacion_id  " +
				"GROUP BY pl.id,o.nombre, a.organigrama_id, prod_mes.puesto_laboral_id, a.apellido, prod_mes.periodo_id, prod_topes.tope_produccion, elm.importe_referencia, espe.monto_mes, p.nombre " +
				"order by a.apellido ";*/


	String sql = "SELECT " +
				"prod_mes.puesto_laboral_id, prod_mes.periodo_id, " +
				"p.nombre, a.apellido, a.organigrama_id, o.nombre, " +
				"elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615) monto_tope , " +
				"coalesce(prod_topes.tope_produccion,1) cant_topes, " +
				"round(sum(prod_mes.cantidad * prod_nom.valor_ips * coalesce(prod_coef.coeficiente, 60) / 100),2) produccion_mes, " +
				"round(case when sum(prod_mes.cantidad * prod_nom.valor_ips * coalesce(prod_coef.coeficiente, 60) / 100) - (elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615)) > (elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615))* coalesce(prod_topes.tope_produccion,1) THEN " +
				"(elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615))* coalesce(prod_topes.tope_produccion,1) " +
				"when sum(prod_mes.cantidad * prod_nom.valor_ips * coalesce(prod_coef.coeficiente, 60) / 100) - (elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615)) < 0 " +
				"THEN 0 ELSE sum(prod_mes.cantidad * prod_nom.valor_ips * coalesce(prod_coef.coeficiente, 60) / 100) - (elm.importe_referencia+ (coalesce(espe.monto_mes,0)*0.80615)) END,2) total_produccion " +
			"FROM produccion_puesto_laboral_periodos prod_mes " +
			"JOIN puestos_laborales pl on prod_mes.puesto_laboral_id = pl.id " +
			"JOIN legajos l on pl.legajo_id = l.id " +
			"JOIN agentes a on l.agente_id = a.id " +
			"JOIN organigramas o on a.organigrama_id = o.id " +
			"JOIN periodos p on p.id = prod_mes.periodo_id " +
			"JOIN produccion_ips_nomencladores prod_nom ON (prod_mes.codigo_ips = prod_nom.codigo_ips and prod_mes.periodo_id between prod_nom.periodo_desde_id and coalesce(prod_nom.periodo_hasta_id,prod_mes.periodo_id)) " +
			
			"LEFT JOIN produccion_puesto_laboral_coeficientes prod_coef ON  " +
				"(prod_coef.puesto_laboral_id = prod_mes.puesto_laboral_id  " +
				"AND prod_coef.codigo_ips = prod_mes.codigo_ips  " +
				"AND prod_mes.periodo_id between prod_coef.periodo_desde_id  " +
				"and coalesce(prod_coef.periodo_hasta_id, prod_mes.periodo_id) " +
				"and prod_coef.organigrama_id = a.organigrama_produccion_id) " +
			
			"LEFT JOIN produccion_profesional_topes prod_topes ON  " +
				"(prod_mes.puesto_laboral_id = prod_topes.puesto_laboral_id AND prod_mes.periodo_id BETWEEN prod_topes.periodo_desde_id AND COALESCE(prod_topes.periodo_hasta_id, prod_mes.periodo_id)) " +
			
			"LEFT JOIN escalas_laborales_montos elm ON " +
				"(elm.escala_laboral_id = pl.escala_laboral_id AND elm.liquidacion_concepto_id = 15 AND " +
					"prod_mes.periodo_id BETWEEN elm.periodo_desde_id and coalesce(elm.periodo_hasta_id, prod_mes.periodo_id)) " +
			
			"LEFT JOIN liquidacion_conceptos_especialidad espe ON " +
				"(espe.especialidad_id = pl.especialidad_id AND prod_mes.periodo_id  BETWEEN espe.periodo_desde_id AND coalesce(espe.periodo_hasta_id, prod_mes.periodo_id)) " +
			"WHERE prod_mes.planificacion_id = :planificacion_id " +
			"GROUP BY o.nombre, a.organigrama_id, prod_mes.puesto_laboral_id, a.apellido, prod_mes.periodo_id, prod_topes.tope_produccion, elm.importe_referencia, espe.monto_mes,p.nombre "+
			"order by a.apellido ";

		List<com.avaje.ebean.SqlRow> l = Ebean.createSqlQuery(sql)
				.setParameter("planificacion_id", planificacion_id)
				.findList();

		return l;
	}
}
