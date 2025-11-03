package models.novedades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;

import models.Agente;
import models.Periodo;
import models.haberes.PuestoLaboral;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "produccion_practicas_imagenes_rismi")
public class ProduccionPracticasImagenesRismi extends Model{

	public static final Integer HORAS_DIAS_MEDICO_PLANTA = 5;
	public static final Integer HORAS_DIAS_INSTRUCTORES_RESIDENTES = 6;
	public static final Integer HORAS_DIAS_JERARQUICO = 3;

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produccion_practicas_imagenes_rismi_id_seq")
	public Long id;

	@Required(message="Debe escribir un documento")
	public String agente_dni;

	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	public Long agente_id;

	@ManyToOne
	@JoinColumn(name = "puesto_laboral_id", referencedColumnName = "id", insertable = false, updatable = false)
	public PuestoLaboral puestoLaboral;
	public Long puesto_laboral_id;

	@ManyToOne
	@JoinColumn(name = "periodo_id", referencedColumnName = "id", insertable = false, updatable = false)
	public Periodo periodo;
	@Required(message = "Requiere un periodo")
	public Integer periodo_id;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fecha_desde;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fecha_hasta;

	public Date create_date;

	public Long practica_rismi_id;

	public Long practica_rismi_minutos;

	public BigDecimal practica_rismi_q;

	public static Model.Finder<Long,ProduccionPracticasImagenesRismi> find = new Finder<Long,ProduccionPracticasImagenesRismi>(Long.class, ProduccionPracticasImagenesRismi.class);

	public static Pagination<ProduccionPracticasImagenesRismi> page(){
		Pagination<ProduccionPracticasImagenesRismi> p = new Pagination<ProduccionPracticasImagenesRismi>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	ExpressionList<ProduccionPracticasImagenesRismi> e = find.where();


    	p.setExpressionList(e);
    	return p;
	}

	public static Map<String,String> calcularProduccionImages(PuestoLaboral pl,Periodo p) {

		Map<String,String> ret= new HashMap<>();

 		Integer diasMes =  diasMes(pl,p);
		Integer minutosPracticas = minutosPracticas(pl,p);
		Integer minutosProfesional = minutosProfesional(pl,p,diasMes);
		Integer minutosExedentes = (minutosPracticas-minutosProfesional);
		BigDecimal valorMinuto = valorMinuto(pl,p);
		BigDecimal producccion = new BigDecimal(minutosExedentes).multiply(valorMinuto).setScale(2, RoundingMode.HALF_DOWN);

		BigDecimal monto_sueldo= getMontoSueldo(pl,p);
		BigDecimal monto_especialidad= getMontoEspecilidad(pl,p);

		ret.put("diasMes", diasMes.toString());
		ret.put("minutosPracticas", minutosPracticas.toString());
		ret.put("minutosProfesional", minutosProfesional.toString());
		ret.put("minutosExedentes", minutosExedentes.toString());
		ret.put("producccion", producccion.toString());
		ret.put("valorMinuto", valorMinuto.toString());
		ret.put("monto_sueldo", monto_sueldo.toString());
		ret.put("monto_especialidad", monto_especialidad.toString());



		return ret;
	}

	public static Integer minutosPracticas(PuestoLaboral pl,Periodo p) {
		Integer minutos = new Integer(0);

		String sql = "SELECT agente_id, puesto_laboral_id,sum(practica_rismi_minutos) as minutos "+
				"	FROM produccion_practicas_imagenes_rismi elm " +
				"	WHERE periodo_id = :periodo_id AND puesto_laboral_id = :puesto_laboral_id " +
				"	GROUP BY agente_id,puesto_laboral_id ";

		List<com.avaje.ebean.SqlRow> l = Ebean.createSqlQuery(sql).setParameter("puesto_laboral_id", pl.id).setParameter("periodo_id", p.id).findList();
		if(l.size() > 0 ){
			minutos = l.get(0).getInteger("minutos");
		}
		return minutos;
	}



	public static Integer minutosProfesional(PuestoLaboral pl,Periodo p,Integer diasMes) {
		//MP: Médico de Planta. Total: 5hr de informes / día
		//I: Instructores de Residentes: Total: 6hr de informes / día
		//RJ: Rango Jerárquico. Total: 3hr de informes / día

		Integer minutos = new Integer(0);



		minutos =diasMes*HORAS_DIAS_MEDICO_PLANTA*60;



		return minutos;
	}

	public static Integer diasMes(PuestoLaboral pl,Periodo p) {

		Integer dias = new Integer(20);

		String sql = "SELECT a.id, p.nombre, a.apellido, a.dni, "+
		//"extract(day from age(p.date_stop , p.date_start)) + 1 total_dias_mes, "+
		//"(SELECT COUNT(*)FROM generate_series( p.date_start, p.date_stop, interval '1 day') AS d(fecha) WHERE EXTRACT(DOW FROM fecha) IN (0, 6)) inhabiles, "+
		//"(SELECT COUNT(*) FROM feriados where fecha between p.date_start and p.date_stop) feriados,coalesce(licencia_dias.dias_lic,0) as dias_licencia_mes "+

		"((extract(day from age(p.date_stop , p.date_start)) + 1)- "+
		"(SELECT COUNT(*)FROM generate_series( p.date_start, p.date_stop, interval '1 day') AS d(fecha) WHERE EXTRACT(DOW FROM fecha) IN (0, 6))- "+
		"(SELECT COUNT(*) FROM feriados where fecha between p.date_start and p.date_stop) - "+
		"coalesce(licencia_dias.dias_lic,0)) as dias "+

		"FROM agentes a "+
		"JOIN legajos l ON a.id = l.agente_id "+
		"JOIN puestos_laborales pl ON (l.id = pl.legajo_id and pl.activo is true) "+
		"JOIN periodos p ON (1 = 1) "+
		"LEFT JOIN ( "+
		"		SELECT alic.agente_id, lnl.periodo_id, coalesce(sum(lnl.dias),0) dias_lic "+
		"		FROM agente_asistencia_licencias alic "+
		"		JOIN liquidacion_novedad_licencias lnl on (alic.id = lnl.agente_asistencia_licencia_id  and lnl.estado_id = 119) "+
		"	group by alic.agente_id,lnl.periodo_id) AS licencia_dias ON (licencia_dias.periodo_id = p.id and licencia_dias.agente_id = a.id) "+
		"LEFT JOIN tipo_residencias tr ON a.tipo_residencia_id = tr.id "+
		"WHERE pl.id = :puesto_laboral_id and p.id = :periodo_id ";

		List<com.avaje.ebean.SqlRow> l = Ebean.createSqlQuery(sql).setParameter("puesto_laboral_id", pl.id).setParameter("periodo_id", p.id).findList();
		if(l.size() > 0 ){
			dias = l.get(0).getInteger("dias");
		}

		return dias;
	}

	public static BigDecimal valorMinuto(PuestoLaboral pl,Periodo p) {

		BigDecimal monto_sueldo= getMontoSueldo(pl,p);
		BigDecimal monto_especialidad= getMontoEspecilidad(pl,p);

		BigDecimal valor_hora = (monto_sueldo.add(monto_especialidad)).divide(new BigDecimal(100)).multiply(new BigDecimal(0.6)).setScale(2, RoundingMode.HALF_DOWN);//(se toma 0.6 porque se paga el 60%)
		BigDecimal valor_minuto = valor_hora.divide(new BigDecimal(60), 2, RoundingMode.HALF_UP);

		return valor_minuto;
	}

	public static BigDecimal getMontoSueldo(PuestoLaboral pl,Periodo p){
		BigDecimal ret = new BigDecimal(0);

		String sql = "SELECT elm.importe_referencia as importe_referencia "+
				"	FROM escalas_laborales_montos elm " +
				"	WHERE elm.liquidacion_concepto_id = 15 " +
				"	AND elm.escala_laboral_id = :escala_laboral_id   "+
				"	AND :periodo_concepto_id BETWEEN elm.periodo_desde_id AND coalesce(elm.periodo_hasta_id, :periodo_concepto_id)";

		List<com.avaje.ebean.SqlRow> l = Ebean.createSqlQuery(sql)
										.setParameter("escala_laboral_id", pl.escala_laboral_id)
										.setParameter("periodo_concepto_id", p.id)
										.findList();
		if(l.size() > 0 ){
			ret = l.get(0).getBigDecimal("importe_referencia");
		}

		return ret;
	}

	public static BigDecimal getMontoEspecilidad(PuestoLaboral pl,Periodo p){
		BigDecimal ret = new BigDecimal(0);

		String sql = "SELECT espe.monto_mes*0.80615  as importe_referencia "+
				"	FROM  liquidacion_conceptos_especialidad espe " +
				"	WHERE espe.especialidad_id  = 56 "+
				"	AND :periodo_concepto_id BETWEEN espe.periodo_desde_id AND coalesce(espe.periodo_hasta_id, :periodo_concepto_id)";

		List<com.avaje.ebean.SqlRow> l = Ebean.createSqlQuery(sql)
										.setParameter("escala_laboral_id", pl.escala_laboral_id)
										.setParameter("periodo_concepto_id", p.id)
										.findList();
		if(l.size() > 0 ){
			ret = l.get(0).getBigDecimal("importe_referencia");
		}

		return ret;
	}

	public static List<com.avaje.ebean.SqlRow> getPuestosACalcular(Periodo p){


		String sql = "SELECT puesto_laboral_id FROM produccion_practicas_imagenes_rismi  "+
					 "WHERE periodo_id = :periodo_id and puesto_laboral_id is not null "+
					 "GROUP BY puesto_laboral_id ";

		List<com.avaje.ebean.SqlRow> l = Ebean.createSqlQuery(sql)
				.setParameter("periodo_id", p.id)
				.findList();

		return l;
	}
}
