package controllers.informes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.OrdenRubro;
import models.Periodo;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.informes.informeLaboratorio.*;

@Security.Authenticated(Secured.class)
public class InformeLaboratorioController extends Controller {

	@CheckPermiso(key = "verInformeLaboratorio")
	public static Result controlProductoPorMesPorInstitucion(Long ejercicioId) {

		Periodo px = Periodo.getPeriodoByDate(new Date());
		int periodo6meses = px.id.intValue() -12 ;
		//List<Periodo> p = Periodo.find.where().ge("id", periodo6meses).ge("id", 163).le("id", px.id).orderBy("id asc").findList();
		List<Periodo> p = Periodo.find.where().eq("ejercicio_id", ejercicioId).orderBy("id asc").findList();


		String sql  = "SELECT o.orden_linea_id as orden_linea_id, cantidad, precio, id, nombre,deposito, recepcionado, udm, pendiente, " +
				"	 o.totalRecepcionado totalRecepcionado, anulados,mes FROM ( " +
				"	  SELECT ol.id as orden_linea_id, " +
				"	 	 CASE WHEN ola.cantidad IS NOT NULL THEN (ol.cantidad - ola.cantidad) " +
				"	 		  ELSE ol.cantidad  " +
				"	 		  END as cantidad, " +
				"	 	  (ol.precio) as precio, p.id,p.nombre,  " +
				"	 	  coalesce(SUM(linea.cantidad),0) recepcionado, " +
				"	 	  u.nombre as udm, " +
				"	 	  ((ol.cantidad - coalesce(SUM(linea.cantidad),0)) - coalesce(SUM(ola.cantidad),0)) as pendiente,  " +
				"	 	  coalesce(sum(linea.precio),0) as totalRecepcionado, " +
				"	  	  coalesce(sum(ola.cantidad),0) as anulados," +
				"		  linea.mes as mes, "+
				"		  de.nombre as deposito" +
				"		 " +
				"	  from orden_lineas ol " +
				"		 " +
				"	  left join " +
				"	  (   " +
				"		  select rec.orden_provision_id, SUM(rl.cantidad) cantidad, rl.linea_orden_id, ol.precio,to_char(rem.fecha_remito,'MM/yyyy') as mes" +
				"		  from recepciones rec " +
				"		  inner join remitos rem on rec.id = rem.recepcion_id " +
				"		  inner join remitos_lineas rl on rem.id = rl.remito_id " +
				"		  inner join orden_lineas ol on ol.id = rl.linea_orden_id " +
				"	   	  GROUP BY rec.orden_provision_id,rl.linea_orden_id, ol.precio,to_char(rem.fecha_remito,'MM/yyyy')" +
				"	   " +
				"	  ) as linea on ol.id = linea.linea_orden_id " +
				"	  left join ordenes o on o.id = ol.orden_id  " +
				"	  left join productos p on p.id = ol.producto_id " +
				"	  left join depositos de on de.id = o.deposito_id  " +
				"	  left join udms u on u.id = ol.udm_id " +
				"	  left join (select orden_linea_id, SUM(cantidad) cantidad from orden_lineas_anulaciones GROUP BY orden_linea_id) ola on ola.orden_linea_id = ol.id " +
				"	 " +
				" 	  WHERE o.orden_subrubro_id = 614 AND linea.mes is not null AND o.deposito_id in(1,3,32)" +
				"	  group by ol.id, p.id, p.nombre, u.nombre, ola.cantidad,linea.mes,de.nombre  ORDER BY p.nombre ASC " +
				"	 ) as o";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);


		List<SqlRow>  row = sqlQuery.findList();

		Map<String,Integer> periodoTotal = new HashMap<>();
		Map<String,Map<String,Integer>> productoPeriodoTotal = new HashMap<>();
		Map<String,Map<String,Map<String,Integer>>> OrganigramaRubroPeriodoTotal = new HashMap<>();

		for(SqlRow sr : row) {

			Map<String,Integer> periodoTotalTmp =new HashMap<>();
			Map<String,Map<String,Integer>> rubroPeriodoTotalTmp = new HashMap<>();
			Map<String,Map<String,Map<String,Integer>>> OrganigramaRubroPeriodoTotalTmp = new HashMap<>();

			String depo = sr.getString("deposito");
			String producto = sr.getString("nombre");
			String periodo = sr.getString("mes");
			Integer cantidad = sr.getInteger("recepcionado");

			if(OrganigramaRubroPeriodoTotal.containsKey(depo)) {// si esta el organigrama

				rubroPeriodoTotalTmp = OrganigramaRubroPeriodoTotal.get(depo);// traigo el organigrama

				if(OrganigramaRubroPeriodoTotal.get(depo).containsKey(producto)) {// si tiene el rubro el organigrama

					OrganigramaRubroPeriodoTotalTmp = OrganigramaRubroPeriodoTotal;

					periodoTotalTmp = rubroPeriodoTotalTmp.get(producto);
					periodoTotalTmp.put(periodo, cantidad);

					rubroPeriodoTotalTmp.put(producto,periodoTotalTmp);



					OrganigramaRubroPeriodoTotalTmp.put(depo,rubroPeriodoTotalTmp);

					OrganigramaRubroPeriodoTotal = OrganigramaRubroPeriodoTotalTmp;


				}else {

					periodoTotalTmp.put(periodo, cantidad);

					OrganigramaRubroPeriodoTotalTmp = OrganigramaRubroPeriodoTotal;

					rubroPeriodoTotalTmp = OrganigramaRubroPeriodoTotal.get(depo);
					rubroPeriodoTotalTmp.put(producto,periodoTotalTmp);

					OrganigramaRubroPeriodoTotalTmp.put(depo,rubroPeriodoTotalTmp);

					OrganigramaRubroPeriodoTotal = OrganigramaRubroPeriodoTotalTmp;


				}

			}else {

				periodoTotal = new HashMap<>();
				periodoTotal.put(periodo, cantidad);
				productoPeriodoTotal = new HashMap<>();
				productoPeriodoTotal.put(producto, periodoTotal);
				OrganigramaRubroPeriodoTotal.put(depo, productoPeriodoTotal);
			}
		}

		Map<String,Map<String,Map<String,Integer>>> OrganigramaRubroPeriodoTotalTmp = new HashMap<>();
		for(Map.Entry<String,Map<String,Map<String,Integer>>> rubroPeriodoTotalTmp : OrganigramaRubroPeriodoTotal.entrySet()) {

			Map<String,Map<String,Integer>> rubroPeriodoTotalTree = new TreeMap(rubroPeriodoTotalTmp.getValue());

			OrganigramaRubroPeriodoTotalTmp.put(rubroPeriodoTotalTmp.getKey(), rubroPeriodoTotalTree);
		}

		Map<String,Map<String,Map<String,Integer>>> OrganigramaRubroPeriodoTotalTree = new TreeMap(OrganigramaRubroPeriodoTotalTmp);

		//Map<String,String> ordenRubro = new HashMap<>();

		//for(OrdenRubro orx:OrdenRubro.find.orderBy("orden asc").findList()) {
		//ordenRubro.put(orx.orden, orx.nombre);
		//}

		return ok(controlProductoPorMesPorInstitucion.render(OrganigramaRubroPeriodoTotalTree,p));

	}
}

