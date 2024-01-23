package controllers.informes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.contabilidad.PeriodosController;
import models.Deposito;
import models.Estado;
import models.Factura;
import models.OrdenRubro;
import models.Periodo;
import models.Proveedor;
import models.haberes.LiquidacionMes;
import models.informes.InformeEstadisticoPagoProveedores;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.contabilidad.facturas.acciones.modalDetalleFacturacion;
import views.html.informes.informeMensual.*;
import views.html.informes.informeObligacion.*;

@Security.Authenticated(Secured.class)
public class InformeMensualController extends Controller {

	public static Result informeMensualPorInstitucion() {


		return ok();

	}

	public static Result index() {
		/*
		139	"01/2023"
		140	"02/2023"
		141	"03/2023"
		142	"04/2023"
		143	"05/2023"
		144	"06/2023"
		145	"07/2023"
		146	"08/2023"
		147	"09/2023"
		148	"10/2023"
		149	"11/2023"
		150	"12/2023"
		3	"Hospital Escuela de Agudos"
		5	"Hospital Materno"
		92	"Hospital de Fatima"
		93	"Hospital Obera"
					 * */
		String idsAgudo = "(3,6,7,9,10,29,8,30,18,19,11,12,14,15,16,17,20,23,24,25,26,13,88,89,27,22,21,28,182,184,181,185,186,187,61,67,57,66,63,147,148,149,150,71,73,72,76,77,116,31,32,33,34,35,36,114,38,39,40,41,42,44,45,46,47,48,49,50,51,52,53,54,55,56,58,59,62,64,65,68,70,75,78,79,80,81,82,83,84,85,86,87,60,90,37,115,91,74,121,162,168,199,203,43)";
		Long orga = new Long(92);
		Long pp = new Long(148);

		List<Integer> idsInstitucionesInforme2= new ArrayList<Integer>();
		idsInstitucionesInforme2.add(1);//1	"HOSPITAL ESCUELA DE AGUDOS"
		idsInstitucionesInforme2.add(4);//4	"HOSPITAL SAMIC DE OBERA"
		//idsInstitucionesInforme2.add(2);//2	"HOSPITAL MATERNO NEONATAL"
		//idsInstitucionesInforme2.add(32);//32	"HOSPITAL FATIMA"

		ExpressionList<InformeEstadisticoPagoProveedores> l = InformeEstadisticoPagoProveedores.find
				  .fetch("factura")
				  .fetch("deposito")
				  .fetch("ordenRubro")
				  .fetch("proveedor", "nombre")
				  .where()
				  .eq("tipo","payment")
				  .in("deposito_id", idsInstitucionesInforme2)
				  .ne("rubro_id",10)
				  .disjunction()
				  .eq("estado_id", Estado.PAGO_ESTADO_PAGADO)
				  .eq("estado_id", Estado.PAGO_ESTADO_CONCILIADO)
				  .endJunction();


		List<Integer> idsInstituciones= new ArrayList<Integer>();
		idsInstituciones.add(31);
		idsInstituciones.add(1);//1	"HOSPITAL ESCUELA DE AGUDOS"
		idsInstituciones.add(4);//4	"HOSPITAL SAMIC DE OBERA"
		idsInstituciones.add(34);
		idsInstituciones.add(33);
		idsInstituciones.add(2);//2	"HOSPITAL MATERNO NEONATAL"
		idsInstituciones.add(25);
		idsInstituciones.add(3);
		idsInstituciones.add(32);//32	"HOSPITAL FATIMA"

		Periodo p = Periodo.getPeriodoByDate(new Date());

		if(!RequestVar.get("periodo.id").isEmpty()){
			p = Periodo.find.byId(new Long(RequestVar.get("periodo.id"))) ;
		}else {
			p = Periodo.find.byId(pp) ;
		}

		l = l.ge("fecha_pago", p.date_start);
		l = l.le("fecha_pago", p.date_stop);



		ExpressionList<LiquidacionMes> lm = LiquidacionMes.find.where();
		lm = lm.ge("fecha_pago", p.date_start);
		lm = lm.le("fecha_pago", p.date_stop);

		List<LiquidacionMes> lmm = lm.findList();
		List<Integer> idsExpedientes = new ArrayList<Integer>();
		for(LiquidacionMes lmmx:lmm) {
			if(lmmx.expediente_aporte_id != null) {
				if(!idsExpedientes.contains(lmmx.expediente_aporte_id)) {
					idsExpedientes.add(lmmx.expediente_aporte_id);
				}
			}
			if(lmmx.expediente_segurovida_id != null) {
				if(!idsExpedientes.contains(lmmx.expediente_segurovida_id)) {
					idsExpedientes.add(lmmx.expediente_segurovida_id);
				}
			}
			if(lmmx.expediente_segurosepelio_id != null) {
				if(!idsExpedientes.contains(lmmx.expediente_segurosepelio_id)) {
					idsExpedientes.add(lmmx.expediente_segurosepelio_id);
				}
			}
			if(lmmx.expediente_contribuciones_id != null) {
				if(!idsExpedientes.contains(lmmx.expediente_contribuciones_id)) {
					idsExpedientes.add(lmmx.expediente_contribuciones_id);
				}
			}
			if(lmmx.expediente_id != null) {
				if(!idsExpedientes.contains(lmmx.expediente_id)) {
					idsExpedientes.add(lmmx.expediente_id);
				}
			}
		}

		l = l.not(Expr.in("expediente_id",idsExpedientes));

		List<InformeEstadisticoPagoProveedores> ll = l.findList();

		Map<String,Map<String,BigDecimal>> lista = new HashMap<String, Map<String,BigDecimal>>();
		Map<String,BigDecimal> listaPorInstitucion = new HashMap<String,BigDecimal>();
		Map<String,BigDecimal> listaPorRubro = new HashMap<String,BigDecimal>();

		//Map<String,BigDecimal> listaPorRubroInstitucion = new HashMap<String,BigDecimal>();
		Map<String,BigDecimal> listaPorInstitucionRubro = new HashMap<String,BigDecimal>();
		Map<String,BigDecimal> listaPorInstitucionSUBRubro = new HashMap<String,BigDecimal>();
		Map<String,BigDecimal> listaPorProveedores = new HashMap<String,BigDecimal>();

		BigDecimal total = new BigDecimal(0);


		for(InformeEstadisticoPagoProveedores llx:ll) {
			total = total.add(llx.total_factura.setScale(0, RoundingMode.HALF_UP));

			///////INSTITUCIONES/////////////
			if(listaPorInstitucion.containsKey(llx.deposito.nombre)) {

				BigDecimal tmp = listaPorInstitucion.get(llx.deposito.nombre);
				tmp = tmp.add(llx.total_factura.setScale(0, RoundingMode.HALF_UP));
				listaPorInstitucion.put(llx.deposito.nombre,tmp);

			}else {
				listaPorInstitucion.put(llx.deposito.nombre, llx.total_factura.setScale(0, RoundingMode.HALF_UP));
			}

			///////RUBRO/////////////
			if(listaPorRubro.containsKey(llx.ordenRubro.nombre)) {

				BigDecimal tmp = listaPorRubro.get(llx.ordenRubro.nombre);
				tmp = tmp.add(llx.total_factura.setScale(0, RoundingMode.HALF_UP));
				listaPorRubro.put(llx.ordenRubro.nombre,tmp);

			}else {
				listaPorRubro.put(llx.ordenRubro.nombre,  llx.total_factura.setScale(0, RoundingMode.HALF_UP));
			}

			///////INSTITUCIONES-RUBRO/////////////
			if(idsInstituciones.contains(llx.deposito.id.intValue())) {
				if(listaPorInstitucionRubro.containsKey(llx.deposito.nombre+"-"+llx.ordenRubro.nombre)) {

					BigDecimal tmp = listaPorInstitucionRubro.get(llx.deposito.nombre+"-"+llx.ordenRubro.nombre);
					tmp = tmp.add(llx.total_factura.setScale(0, RoundingMode.HALF_UP));
					listaPorInstitucionRubro.put(llx.deposito.nombre+"-"+llx.ordenRubro.nombre,tmp);

				}else {
					listaPorInstitucionRubro.put(llx.deposito.nombre+"-"+llx.ordenRubro.nombre, llx.total_factura.setScale(0, RoundingMode.HALF_UP));
				}
			}

			///////INSTITUCIONES--SUBRUBRO/////////////
			if(idsInstituciones.contains(llx.deposito.id.intValue())) {

				if(llx.ordenRubro.id == 7) {



					Logger.debug("llx.factura_id "+llx.factura_id);
					if(listaPorInstitucionSUBRubro.containsKey(llx.deposito.nombre+"-"+llx.ordenSubrubro.nombre+"-"+llx.proveedor.nombre)) {

						BigDecimal tmp = listaPorInstitucionSUBRubro.get(llx.deposito.nombre+"-"+llx.ordenSubrubro.nombre+"-"+llx.proveedor.nombre);
						tmp = tmp.add(llx.total_factura.setScale(0, RoundingMode.HALF_UP));
						listaPorInstitucionSUBRubro.put(llx.deposito.nombre+"-"+llx.ordenSubrubro.nombre+"-"+llx.proveedor.nombre,tmp);

					}else {
						listaPorInstitucionSUBRubro.put(llx.deposito.nombre+"-"+llx.ordenSubrubro.nombre+"-"+llx.proveedor.nombre, llx.total_factura.setScale(0, RoundingMode.HALF_UP));
					}
				}
			}

			///////PROVEEDORES/////////////
			String pNombre = "";

			if(Proveedor.getProveedoresDestacadosYRA().contains(llx.proveedor.id.intValue())) {

				if(Proveedor.getProveedoresDestacadosRA().contains(llx.proveedor.id)) {
					pNombre = "R.A.";
				}else {
					pNombre = llx.proveedor.nombre;
				}
				//pNombre = llx.proveedor.nombre;

			}else {
				pNombre = "OTROS";
			}


			if(listaPorProveedores.containsKey(pNombre)) {

				BigDecimal tmp = listaPorProveedores.get(pNombre);
				tmp = tmp.add(llx.total_factura.setScale(0, RoundingMode.HALF_UP));
				listaPorProveedores.put(pNombre,tmp);

			}else {
				listaPorProveedores.put(pNombre, llx.total_factura.setScale(0, RoundingMode.HALF_UP));
			}

		}

		 List<SqlRow> costoPorPeriodo = getCostoTotalPorPeriodo(p.id.longValue(),orga,idsAgudo);

		 List<SqlRow> countPorEscalaParque = getCountPorEscalaEnLiquidaciones(p.id.longValue(),false,orga,idsAgudo);
		 List<SqlRow> countPorEscalaCm = getCountPorEscalaEnLiquidaciones(p.id.longValue(),true,orga,idsAgudo);

		 List<SqlRow> costoTotalPorEscalaParque = getCostoBrutoTotalPorEscala(p.id.longValue(),false,false,orga,idsAgudo);
		 List<SqlRow> costoTotalPorEscalaCm = getCostoBrutoTotalPorEscala(p.id.longValue(),true,false,orga,idsAgudo);

		 List<SqlRow> costoTotalPorClasificacionParque = getCostoTotalPorClasificacionConcepto(p.id.longValue(),false,orga,idsAgudo);
		 List<SqlRow> costoTotalPorClasificacionCm = getCostoTotalPorClasificacionConcepto(p.id.longValue(),true,orga,idsAgudo);

		 List<SqlRow> countProfesionParque = getCountPorProfesion(p.id.longValue(),false);
		 List<SqlRow> countProfesionCm = getCountPorProfesion(p.id.longValue(),true);

		 TreeMap<String,BigDecimal> sorted_listaPorRubro = new TreeMap<String,BigDecimal>(listaPorRubro);
		 TreeMap<String,BigDecimal> sorted_listaPorInstitucionRubro = new TreeMap<String,BigDecimal>(listaPorInstitucionRubro);
		 TreeMap<String,BigDecimal> sorted_listaPorInstitucionSUBRubro = new TreeMap<String,BigDecimal>(listaPorInstitucionSUBRubro);

		return ok(index.render(total,
								listaPorInstitucion,
								sorted_listaPorRubro,
								sorted_listaPorInstitucionRubro,
								listaPorProveedores,
								costoPorPeriodo,
								countPorEscalaParque,
								countPorEscalaCm,
								costoTotalPorEscalaParque,
								costoTotalPorEscalaCm,
								costoTotalPorClasificacionParque,
								costoTotalPorClasificacionCm,
								countProfesionParque,
								countProfesionCm,
								sorted_listaPorInstitucionSUBRubro));
	}


	public static List<SqlRow> getCostoTotalPorPeriodo(Long idPeriodo, Long orga,String idsAgudo){

		Periodo p = Periodo.find.byId(idPeriodo);

		String sql = " SELECT round(sum(ld.cantidad*ld.importe)) monto,pl.convenio_ministerio cm " +
					 " 	FROM puestos_laborales pl " +
					 " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " +
					 " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id " +
					 " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +
					 " inner join legajos l on l.id = pl.legajo_id    " +
					 " inner join agentes a on a.id = l.agente_id  " ;
					 if(orga != null) {
							//sql +=  "and a.organigrama_id = "+orga;

							sql +=  "and a.organigrama_id in "+idsAgudo;

						}
					 sql += " 	WHERE lm.periodo_id = :periodo_id " +
					 "	GROUP BY pl.convenio_ministerio ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getCountPorEscalaEnLiquidaciones(Long idPeriodo,boolean cm, Long orga,String idsAgudo){

		Periodo p = Periodo.find.byId(idPeriodo);
		String sql = "SELECT  COUNT(DISTINCT a.id) count,pl.convenio_ministerio cm,el.id,el.nombre nombre "+
				" FROM liquidacion_puestos lp " +
				" INNER JOIN liquidacion_meses lm ON lm.id = lp.liquidacion_mes_id " +
				" INNER JOIN puestos_laborales pl ON pl.id = lp.puesto_laboral_id " +
				" INNER JOIN escalas_laborales el ON el.id = pl.escala_laboral_id " +
				" inner join legajos l on l.id = pl.legajo_id    " +
				" inner join agentes a on a.id = l.agente_id  " +
				" WHERE " +
				" lm.periodo_id = :periodo_id " +
				" AND pl.convenio_ministerio = :cm ";

				if(orga != null) {
					//sql +=  "and a.organigrama_id = "+orga;
					sql +=  "and a.organigrama_id in "+idsAgudo;
				}
		sql += " GROUP BY pl.convenio_ministerio,el.id,el.nombre " +
				" order by el.id ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getCostoBrutoTotalPorEscala(Long idPeriodo,boolean cm,boolean sinsac, Long orga,String idsAgudo){
		Periodo p = Periodo.find.byId(idPeriodo);

		String sql = "SELECT " +
					 //"	round(sum(ld.cantidad*ld.importe),2) monto ," +
					 " round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) " +
					 " + " +
					 " COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) " +
					 " + " +
					 " COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0),0) monto, " +
					 "	el.nombre nombre "+
				     " 	FROM puestos_laborales pl "+
				     " 	INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id "+
				     " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+
				     " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id " +
				     "  INNER JOIN liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id " +
				     " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+
				     " inner join legajos l on l.id = pl.legajo_id    " +
					 " inner join agentes a on a.id = l.agente_id  " +
				     " 	WHERE lm.periodo_id = :periodo_id "+
				    " AND pl.convenio_ministerio = :cm " ;
		if(orga != null) {
			//sql +=  "and a.organigrama_id = "+orga;
			sql +=  "and a.organigrama_id in "+idsAgudo;
		}

					if(sinsac){
						sql += " AND lm.liquidacion_tipo_id in(1,4)";
					}
					sql += " 	GROUP BY pl.convenio_ministerio,el.nombre ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static List<SqlRow> getCostoTotalPorClasificacionConcepto(Long idPeriodo,boolean cm, Long orga,String idsAgudo){
		Periodo p = Periodo.find.byId(idPeriodo);

		String sql = "SELECT round(sum(ld.cantidad*ld.importe),0) monto ,lcc.nombre nombre "+
				" 	FROM puestos_laborales pl "+
				" 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+
				" 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "+
				" 	inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
				" 	inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
				" 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+
				" inner join legajos l on l.id = pl.legajo_id    " +
				" inner join agentes a on a.id = l.agente_id  " +
				" 	WHERE lm.periodo_id = :periodo_id "+
				//"   AND lm.liquidacion_tipo_id in(1,4)"+
				" AND pl.convenio_ministerio = :cm ";
		if(orga != null) {
			//sql +=  "and a.organigrama_id = "+orga;
			sql +=  "and a.organigrama_id in "+idsAgudo;
		}

		sql +=  " 	GROUP BY pl.convenio_ministerio,lcc.nombre ORDER BY monto desc ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static List<SqlRow> getCountPorProfesion(Long idPeriodo,boolean cm){

		Periodo p = Periodo.find.byId(idPeriodo);

		String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm,el.id,el.nombre escala,p.id ,p.nombre profesion " +
				" FROM puestos_laborales pl " +
				" INNER JOIN legajos l on l.id = pl.legajo_id " +
				" INNER JOIN agentes a on a.id = l.agente_id " +
				" LEFT JOIN profesiones p on p.id = a.profesion_id " +
				" INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id " +
				" INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " +
				" INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +
				" WHERE " +
				" lm.periodo_id = :periodo_id " +
				" AND pl.convenio_ministerio = :cm " +
				" GROUP BY pl.convenio_ministerio,el.id,el.nombre,p.id ,p.nombre " +
				" order by el.id asc,count desc ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		//sqlQuery.setParameter("date_stop",p.date_stop);
		//sqlQuery.setParameter("date_start",p.date_start);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static Result getObligacionPorOrganigrama(){

		Periodo px = Periodo.getPeriodoByDate(new Date());
		int periodo6meses = px.id.intValue() -6 ;
		List<Periodo> p = Periodo.find.where().ge("id", periodo6meses).le("id", px.id).orderBy("id asc").findList();

		String sql = "select d.nombre::text as depo,od.nombre as rubro, to_char(a.fecha,'MM/yyyy') as periodo,round(sum(a.total)) as total "+
					"FROM ordenes o "+
					"inner join depositos d on d.id = o.deposito_id "+
					"inner join ordenes_rubros od on od.id = o.orden_rubro_id "+
					"inner JOIN ( "+
						"SELECT a_2.orden_compra_id AS orden_id, ar.fecha as fecha, "+
					    "                sum(a_2.total) AS total, "+
					    "                sum(a_2.total_dolar) AS total_dolar "+
					    "               FROM vista_actas_totales a_2 "+
						"			 	inner join actas_recepcion ar on ar.id =a_2.id "+
					    "              WHERE a_2.state_id = 40 "+
					    "              GROUP BY a_2.orden_compra_id,ar.fecha "+

					    "    UNION "+
					    "     SELECT cc.orden_id,cc.fecha_certificacion as fecha, "+
					    "        sum(cl.total) AS total, "+
					    "        round((sum(cl.total) / COALESCE(o_1.cot_dolar, 1::numeric)::double precision)::numeric, 2) AS total_dolar "+
					    "       FROM ( SELECT certificaciones_compras_lineas.certificacion_compra_id, "+
					    "                sum(certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision - "+
					    "					certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision * "+
					    "					round(COALESCE(certificaciones_compras_lineas.descuento, 0::numeric), 2)::double precision / 100::double precision) AS total "+
					    "               FROM certificaciones_compras_lineas "+
					    "              WHERE certificaciones_compras_lineas.producto_id <> ALL (ARRAY[40277, 40276, 30653]) "+
					    "              GROUP BY certificaciones_compras_lineas.certificacion_compra_id "+
					    "            UNION ALL "+
					    "             SELECT certificaciones_compras_linea_ajustes.certificacion_compra_id, "+
					    "                sum(COALESCE(certificaciones_compras_linea_ajustes.precio, 0::numeric)::double precision * COALESCE(certificaciones_compras_linea_ajustes.cantidad, 0::double precision)) AS total "+
					    "               FROM certificaciones_compras_linea_ajustes "+
					    "              WHERE certificaciones_compras_linea_ajustes.producto_id <> ALL (ARRAY[40277, 40276, 30653]) "+
					    "              GROUP BY certificaciones_compras_linea_ajustes.certificacion_compra_id) cl "+
					    "         JOIN certificaciones_compras cc ON cc.id = cl.certificacion_compra_id "+
					    "         JOIN ordenes o_1 ON o_1.id = cc.orden_id "+
					    "      WHERE cc.state_id = 81 AND o_1.perimido = false "+
					    "      GROUP BY cc.orden_id, cc.state_id,cc.fecha_certificacion, o_1.cot_dolar) a ON a.orden_id = o.id "+

					"where  "+
					" o.deposito_id in(1) "+
					" and a.fecha >= ? "+
					//"and o.orden_rubro_id = 2 "+
					//"	--and to_char(a.fecha,''MM/yyyy'')  = '01/2023' "+
					"group by d.nombre,od.nombre, to_char(a.fecha,'MM/yyyy') "+
					"order by d.nombre,od.nombre, to_char(a.fecha,'MM/yyyy') ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter(1, p.get(0).date_start);

		List<SqlRow>  row = sqlQuery.findList();

		Map<String,BigDecimal> periodoTotal = new HashMap<>();
		Map<String,Map<String,BigDecimal>> rubroPeriodoTotal = new HashMap<>();
		Map<String,Map<String,Map<String,BigDecimal>>> OrganigramaRubroPeriodoTotal = new HashMap<>();





		for(SqlRow sr : row) {

			Map<String,BigDecimal> periodoTotalTmp =new HashMap<>();
			Map<String,Map<String,BigDecimal>> rubroPeriodoTotalTmp = new HashMap<>();
			Map<String,Map<String,Map<String,BigDecimal>>> OrganigramaRubroPeriodoTotalTmp = new HashMap<>();

			String depo = sr.getString("depo");
			String rubro = sr.getString("rubro");
			String periodo = sr.getString("periodo");
			BigDecimal total = sr.getBigDecimal("total");


			/*
			  	"HPS" , {"ESTUDIOS",{"01","$5243"} }
			 *
			 */

			if(OrganigramaRubroPeriodoTotal.containsKey(depo)) {// si esta el organigrama

				rubroPeriodoTotalTmp = OrganigramaRubroPeriodoTotal.get(depo);// traigo el organigrama

				if(OrganigramaRubroPeriodoTotal.get(depo).containsKey(rubro)) {// si tiene el rubro el organigrama



					OrganigramaRubroPeriodoTotalTmp = OrganigramaRubroPeriodoTotal;

					periodoTotalTmp = rubroPeriodoTotalTmp.get(rubro);
					periodoTotalTmp.put(periodo, total);

					rubroPeriodoTotalTmp.put(rubro,periodoTotalTmp);



					OrganigramaRubroPeriodoTotalTmp.put(depo,rubroPeriodoTotalTmp);

					OrganigramaRubroPeriodoTotal = OrganigramaRubroPeriodoTotalTmp;


				}else {

					periodoTotalTmp.put(periodo, total);


					rubroPeriodoTotalTmp = OrganigramaRubroPeriodoTotal.get(depo);
					rubroPeriodoTotalTmp.put(rubro,periodoTotalTmp);
					OrganigramaRubroPeriodoTotalTmp.put(depo,rubroPeriodoTotalTmp);
					OrganigramaRubroPeriodoTotal = OrganigramaRubroPeriodoTotalTmp;


				}


			}else {
				periodoTotal.put(periodo, total);
				rubroPeriodoTotal.put(rubro, periodoTotal);
				OrganigramaRubroPeriodoTotal.put(depo, rubroPeriodoTotal);
			}


		}

		//return row;
		return ok(obligacion_new.render(OrganigramaRubroPeriodoTotal,p));
	}

	public static Result getObligacionPorOrganigramaPorRubroPorPeriodo(String deposito,String rubro, Long periodoId){

		Periodo px = Periodo.find.byId(periodoId);
		Deposito d = Deposito.find.where().eq("nombre", deposito).findUnique();
		OrdenRubro or = OrdenRubro.find.where().eq("nombre", rubro).findUnique();

		//int periodo6meses = px.id.intValue() -6 ;
		//List<Periodo> p = Periodo.find.where().ge("id", periodo6meses).le("id", px.id).orderBy("id asc").findList();

		String sql = "select d.nombre::text as proveedor,COALESCE(od.nombre,'SIN SUBRUBRO') as rubro, to_char(a.fecha,'MM/yyyy') as periodo,round(sum(a.total)) as total "+
					"FROM ordenes o "+
					"inner join proveedores d on d.id = o.proveedor_id "+
					//"inner join depositos d on d.id = o.deposito_id "+
					"inner join ordenes_subrubros od on od.id = o.orden_subrubro_id "+
					"inner JOIN ( "+
						"SELECT a_2.orden_compra_id AS orden_id, ar.fecha as fecha, "+
					    "                sum(a_2.total) AS total, "+
					    "                sum(a_2.total_dolar) AS total_dolar "+
					    "               FROM vista_actas_totales a_2 "+
						"			 	inner join actas_recepcion ar on ar.id =a_2.id "+
					    "              WHERE a_2.state_id = 40 "+
					    "              GROUP BY a_2.orden_compra_id,ar.fecha "+

					    "    UNION "+
					    "     SELECT cc.orden_id,cc.fecha_certificacion as fecha, "+
					    "        sum(cl.total) AS total, "+
					    "        round((sum(cl.total) / COALESCE(o_1.cot_dolar, 1::numeric)::double precision)::numeric, 2) AS total_dolar "+
					    "       FROM ( SELECT certificaciones_compras_lineas.certificacion_compra_id, "+
					    "                sum(certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision - "+
					    "					certificaciones_compras_lineas.cantidad * round(certificaciones_compras_lineas.precio, 2)::double precision * "+
					    "					round(COALESCE(certificaciones_compras_lineas.descuento, 0::numeric), 2)::double precision / 100::double precision) AS total "+
					    "               FROM certificaciones_compras_lineas "+
					    "              WHERE certificaciones_compras_lineas.producto_id <> ALL (ARRAY[40277, 40276, 30653]) "+
					    "              GROUP BY certificaciones_compras_lineas.certificacion_compra_id "+
					    "            UNION ALL "+
					    "             SELECT certificaciones_compras_linea_ajustes.certificacion_compra_id, "+
					    "                sum(COALESCE(certificaciones_compras_linea_ajustes.precio, 0::numeric)::double precision * COALESCE(certificaciones_compras_linea_ajustes.cantidad, 0::double precision)) AS total "+
					    "               FROM certificaciones_compras_linea_ajustes "+
					    "              WHERE certificaciones_compras_linea_ajustes.producto_id <> ALL (ARRAY[40277, 40276, 30653]) "+
					    "              GROUP BY certificaciones_compras_linea_ajustes.certificacion_compra_id) cl "+
					    "         JOIN certificaciones_compras cc ON cc.id = cl.certificacion_compra_id "+
					    "         JOIN ordenes o_1 ON o_1.id = cc.orden_id "+
					    "      WHERE cc.state_id = 81 AND o_1.perimido = false "+
					    "      GROUP BY cc.orden_id, cc.state_id,cc.fecha_certificacion, o_1.cot_dolar) a ON a.orden_id = o.id "+

					"where  "+
					" o.orden_rubro_id = ? and "+
					" o.deposito_id in(?) "+
					//" and a.fecha >= ? "+
					//"and o.orden_rubro_id = 2 "+
					" and to_char(a.fecha,'MM/yyyy')  = ? "+
					"group by d.nombre,od.nombre, to_char(a.fecha,'MM/yyyy') "+
					"order by d.nombre,od.nombre, to_char(a.fecha,'MM/yyyy') ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter(1, or.id);
		sqlQuery.setParameter(2, d.id);
		sqlQuery.setParameter(3, px.nombre);

		List<SqlRow>  row = sqlQuery.findList();

		Map<String,BigDecimal> periodoTotal = new HashMap<>();
		Map<String,Map<String,BigDecimal>> rubroPeriodoTotal = new HashMap<>();
		Map<String,Map<String,Map<String,BigDecimal>>> OrganigramaRubroPeriodoTotal = new HashMap<>();







		//return row;
		return ok(modalInformeObligacion.render(row));
	}


	/*
	 select d.nombre,od.nombre,round(sum(a.total))
FROM ordenes o
inner join depositos d on d.id = o.deposito_id
inner join ordenes_rubros od on od.id = o.orden_rubro_id
inner JOIN (

           SELECT a_2.orden_compra_id AS orden_id, ar.fecha as fecha,
                    sum(a_2.total) AS total,
                    sum(a_2.total_dolar) AS total_dolar
                   FROM vista_actas_totales a_2
				 	inner join actas_recepcion ar on ar.id =a_2.id
                  WHERE a_2.state_id = 40
                  GROUP BY a_2.orden_compra_id,ar.fecha

        UNION
         SELECT cc.orden_id,cc.fecha_certificacion as fecha,
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
          GROUP BY cc.orden_id, cc.state_id,cc.fecha_certificacion, o_1.cot_dolar) a ON a.orden_id = o.id
where a.fecha >='2023-10-01' and a.fecha <='2023-10-30'
and o.deposito_id in(1,4,2,32) group by d.nombre,od.nombre order by d.nombre,od.nombre
------------------------------------------------------------
SELECT * FROM crosstab(
    '
	select d.nombre::text as depo,, to_char(a.fecha,''MM/yyyy'') as periodo,round(sum(a.total)) as total
FROM ordenes o
inner join depositos d on d.id = o.deposito_id
inner join ordenes_rubros od on od.id = o.orden_rubro_id
inner JOIN (

           SELECT a_2.orden_compra_id AS orden_id, ar.fecha as fecha,
                    sum(a_2.total) AS total,
                    sum(a_2.total_dolar) AS total_dolar
                   FROM vista_actas_totales a_2
				 	inner join actas_recepcion ar on ar.id =a_2.id
                  WHERE a_2.state_id = 40
                  GROUP BY a_2.orden_compra_id,ar.fecha

        UNION
         SELECT cc.orden_id,cc.fecha_certificacion as fecha,
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
          GROUP BY cc.orden_id, cc.state_id,cc.fecha_certificacion, o_1.cot_dolar) a ON a.orden_id = o.id
inner join periodos p on p.id = o.deposito_id
where a.fecha >=''2023-01-01'' and
o.deposito_id in(1,4,2,32)
and o.orden_rubro_id = 2
	and to_char(a.fecha,''MM/yyyy'')  = ''01/2023''
group by d.nombre, to_char(a.fecha,''MM/yyyy'')
order by d.nombre, to_char(a.fecha,''MM/yyyy'')

	'
    ) AS ctab (
    depo text,  "01/2023" float8  --(select nombre from periodos where id > 139 order by nombre)
    );
	 */

}
