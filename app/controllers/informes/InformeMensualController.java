package controllers.informes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import controllers.Secured;
import models.Estado;
import models.Factura;
import models.Periodo;
import models.Proveedor;
import models.haberes.LiquidacionMes;
import models.informes.InformeEstadisticoPagoProveedores;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.contabilidad.facturas.acciones.modalDetalleFacturacion;
import views.html.informes.informeMensual.*;

@Security.Authenticated(Secured.class)
public class InformeMensualController extends Controller {

	public static Result index() {

		ExpressionList<InformeEstadisticoPagoProveedores> l = InformeEstadisticoPagoProveedores.find
				  .fetch("factura")
				  .fetch("deposito")
				  .fetch("ordenRubro")
				  .fetch("proveedor", "nombre")
				  .where()
				  .eq("tipo","payment")
				  .disjunction()
				  .eq("estado_id", Estado.PAGO_ESTADO_PAGADO)
				  .eq("estado_id", Estado.PAGO_ESTADO_CONCILIADO)
				  .endJunction();

		Periodo p = Periodo.getPeriodoByDate(new Date());
		if(!RequestVar.get("periodo.id").isEmpty()){
			p = Periodo.find.byId(new Long(RequestVar.get("periodo.id"))) ;
		}else {
			p = Periodo.find.byId(new Long(143)) ;
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
		Map<String,BigDecimal> listaPorInstitucionRubro = new HashMap<String,BigDecimal>();
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
			if(listaPorInstitucionRubro.containsKey(llx.deposito.nombre+"-"+llx.ordenRubro.nombre)) {

				BigDecimal tmp = listaPorInstitucionRubro.get(llx.deposito.nombre+"-"+llx.ordenRubro.nombre);
				tmp = tmp.add(llx.total_factura.setScale(0, RoundingMode.HALF_UP));
				listaPorInstitucionRubro.put(llx.deposito.nombre+"-"+llx.ordenRubro.nombre,tmp);

			}else {
				listaPorInstitucionRubro.put(llx.deposito.nombre+"-"+llx.ordenRubro.nombre, llx.total_factura.setScale(0, RoundingMode.HALF_UP));
			}

			///////PROVEEDORES/////////////
			String pNombre = "";

			if(Proveedor.getProveedoresDestacadosYRA().contains(llx.proveedor.id.intValue())) {

				if(Proveedor.getProveedoresDestacadosRA().contains(llx.proveedor.id)) {
					pNombre = "R.A.";
				}else {
					pNombre = llx.proveedor.nombre;
				}


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

		 List<SqlRow> costoPorPeriodo = getCostoTotalPorPeriodo(p.id.longValue());

		 List<SqlRow> countPorEscalaParque = getCountPorEscalaEnLiquidaciones(p.id.longValue(),false);
		 List<SqlRow> countPorEscalaCm = getCountPorEscalaEnLiquidaciones(p.id.longValue(),true);

		 List<SqlRow> costoTotalPorEscalaParque = getCostoBrutoTotalPorEscala(p.id.longValue(),false,false);
		 List<SqlRow> costoTotalPorEscalaCm = getCostoBrutoTotalPorEscala(p.id.longValue(),true,false);

		 List<SqlRow> costoTotalPorClasificacionParque = getCostoTotalPorClasificacionConcepto(p.id.longValue(),false);
		 List<SqlRow> costoTotalPorClasificacionCm = getCostoTotalPorClasificacionConcepto(p.id.longValue(),true);

		 List<SqlRow> countProfesionParque = getCountPorProfesion(p.id.longValue(),false);
		 List<SqlRow> countProfesionCm = getCountPorProfesion(p.id.longValue(),true);

		return ok(index.render(total,
								listaPorInstitucion,
								listaPorRubro,
								listaPorInstitucionRubro,
								listaPorProveedores,
								costoPorPeriodo,
								countPorEscalaParque,
								countPorEscalaCm,
								costoTotalPorEscalaParque,
								costoTotalPorEscalaCm,
								costoTotalPorClasificacionParque,
								costoTotalPorClasificacionCm,
								countProfesionParque,
								countProfesionCm));
	}


	public static List<SqlRow> getCostoTotalPorPeriodo(Long idPeriodo){

		Periodo p = Periodo.find.byId(idPeriodo);

		String sql = " SELECT round(sum(ld.cantidad*ld.importe)) monto,lm.convenio_ministerio cm " +
					 " 	FROM puestos_laborales pl " +
					 " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " +
					 " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id " +
					 " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +
					 " 	WHERE lm.periodo_id = :periodo_id " +
					 "	GROUP BY lm.convenio_ministerio ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getCountPorEscalaEnLiquidaciones(Long idPeriodo,boolean cm){

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
				" AND pl.convenio_ministerio = :cm " +
				" GROUP BY pl.convenio_ministerio,el.id,el.nombre " +
				" order by el.id ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getCostoBrutoTotalPorEscala(Long idPeriodo,boolean cm,boolean sinsac){
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
				     " 	WHERE lm.periodo_id = :periodo_id "+
				     " 	AND lm.convenio_ministerio =  :cm ";
					if(sinsac){
						sql += " AND lm.liquidacion_tipo_id in(1,4)";
					}
					sql += " 	GROUP BY lm.convenio_ministerio,el.nombre ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static List<SqlRow> getCostoTotalPorClasificacionConcepto(Long idPeriodo,boolean cm){
		Periodo p = Periodo.find.byId(idPeriodo);

		String sql = "SELECT round(sum(ld.cantidad*ld.importe),0) monto ,lcc.nombre nombre "+
				" 	FROM puestos_laborales pl "+
				" 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+
				" 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "+
				" 	inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
				" 	inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
				" 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+
				" 	WHERE lm.periodo_id = :periodo_id "+
				//"   AND lm.liquidacion_tipo_id in(1,4)"+
				" 	AND lm.convenio_ministerio =  :cm "+
				" 	GROUP BY lm.convenio_ministerio,lcc.nombre ORDER BY monto desc ";

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
}
