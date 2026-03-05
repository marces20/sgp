package controllers.dashboard;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import models.Estado;
import models.Organigrama;
import models.haberes.LiquidacionMes;
import models.informes.ResponseInformeOrganigramaTipoProfesion;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard.rrhh.*;

public class ProfesionalesMedicosController  extends Controller {

	public static Result datosMensualesResumenGeneral(Long organigramaId) {


		String sql = "WITH RECURSIVE recursetree(id, padre_id) AS ( " +
				   "SELECT id, padre_id FROM organigramas "+
				   //"WHERE padre_id = 1 OR  id = 1 " +
				   "UNION " +
				   "SELECT t.id, t.padre_id " +
				   "FROM organigramas t " +
				   "JOIN recursetree rt ON rt.id = t.padre_id " +
				 ") " +
				 "SELECT count(*) as cantidad,tl.id as idTipoRelacion,tl.nombre as tipoRelacion " +
				 "FROM agentes a " +
				 "inner join tipo_relacion_laborales tl on CAST(a.tipo_relacion_laboral AS INTEGER) = tl.id "+
				 "WHERE (a.organigrama_id in (SELECT id FROM recursetree)) "+
				 "AND a.activo = true "+
				 "GROUP BY tl.id,tl.nombre ORDER BY cantidad ";

		List<SqlRow> todos = Ebean.createSqlQuery(sql).findList();

		int parque = 0;
		int convenio = 0;
		int otro = 0;
		int total = 0;

		for(SqlRow x:todos) {



			switch (x.getInteger("idTipoRelacion")) {
			case 1://"Contrato Relacion Parque de la salud"
			case 2://"Contrato Sin Relacion Parque de la salud"
				parque += x.getInteger("cantidad");
				break;
			case 3://"Contrato Relacion Convenio Ministerio Salud"
				convenio += x.getInteger("cantidad");
				break;
			case 4://"Planta Permanente  - Otras Entidades"
			case 5://"Contrato Relacion - Otras Entidades"
			case 6://"Adscripto Otras Entidades"
			case 7://"Contrato Convenio Nacion"
			case 8://"Planta Temporaria - Otras Entidades"
			case 9:
				 otro += x.getInteger("cantidad");
				break;

			default:
				break;
			}


			total += x.getInteger("cantidad");
		}

		Map<String, Integer> totales = new HashMap<String, Integer>();
		totales.put("parque",parque);
		totales.put("convenio",convenio);
		totales.put("otro",otro);
		totales.put("total",total);



		return ok( datosMensualesResumenGeneral.render(organigramaId,totales) );
	}


	public static Result getDataPorOrganigramaIdPorTipoProfesion(){
		ObjectNode rpta = Json.newObject();
	    ArrayNode results = rpta.arrayNode();
	    ObjectNode response = Json.newObject();

	    Long organigramaId = null;
	    Boolean convenio = null;

	    if(request().body().asFormUrlEncoded().get("organigramaId")[0] != null && !request().body().asFormUrlEncoded().get("organigramaId")[0].isEmpty()) {
	    	organigramaId = new Long(request().body().asFormUrlEncoded().get("organigramaId")[0]);
	    }
	    if(organigramaId != null ){

		    try {
				List<SqlRow> res =getDataPorTipoProfesion(organigramaId);
				Logger.debug("=================================");
				Logger.debug(res.toString());
				Logger.debug("=================================");
				ObjectNode restJs = Json.newObject();
				/*

				 const depts = [
					{ name: 'Hsp. Escuela Agudos',  medicos: 11,enfermero: 22,tecnicos: 33,adminitrativo: 44,profesion: 55,total: 66, color: '#d83b3b' },
				    { name: 'Hsp. de Fatima', medicos: 11,enfermero: 22,tecnicos: 33,adminitrativo: 44,profesion: 55,total: 66, color: '#3b7dd8' },
				    { name: 'Hsp. Obera', medicos: 11,enfermero: 22,tecnicos: 33,adminitrativo: 44,profesion: 55,total: 66, color: '#10b981' },
				    { name: 'LACMI',  medicos: 11,enfermero: 22,tecnicos: 33,adminitrativo: 44,profesion: 55,total: 66, color: '#f59e0b' },
				    { name: 'U. Traslado', medicos: 11,enfermero: 22,tecnicos: 33,adminitrativo: 44,profesion: 55,total: 66,color: '#d8c83b' },
				    { name: 'Hsp Favaloro', medicos: 11,enfermero: 22,tecnicos: 33,adminitrativo: 44,profesion: 55,total: 66, color: '#8b5cf6' },
				    { name: 'IMC', medicos: 11,enfermero: 22,tecnicos: 33,adminitrativo: 44,profesion: 55,total: 66, color: '#0ea5e9' },
				    { name: 'IGH', medicos: 11,enfermero: 22,tecnicos: 33,adminitrativo: 44,profesion: 55,total: 66,color: '#ec4899' },
				    { name: 'G. Maternal Evita', medicos: 11,enfermero: 22,tecnicos: 33,adminitrativo: 44,profesion: 55,total: 66, color: '#14b8a6' },
				  ];

				 */

				List<ResponseInformeOrganigramaTipoProfesion> lr = new ArrayList<>();

				String organigramaTmp = "";

				Map<String, Map<String,Integer>> dataTmp = new HashMap<>();
				 Map<String,Integer> dt = new HashMap<>();

				for (SqlRow sr : res) {

					if(dataTmp.containsKey((sr.getString("organigrama_id")))) {

						dt = dataTmp.get(sr.getString("organigrama_id"));

						dt.put(sr.getString("idtipoprofesion"), sr.getInteger("cantidad_total"));

						dataTmp.put(sr.getString("organigrama_id"), dt);

					}else {

						Map<String,Integer> data = new HashMap<>();
						data.put(sr.getString("idtipoprofesion"), sr.getInteger("cantidad_total"));
						dataTmp.put(sr.getString("organigrama_id"), data);

					}
				}



				for (Map.Entry<String, Map<String,Integer>> entry : dataTmp.entrySet()) {
					String clave = entry.getKey();
					Logger.debug("================== "+clave);
					Map<String,Integer> valor = entry.getValue();
					Logger.debug("================== "+valor.toString());

					ResponseInformeOrganigramaTipoProfesion rp = new ResponseInformeOrganigramaTipoProfesion();

					Long idOrga = new Long(clave);
					Organigrama oo = Organigrama.find.byId(idOrga);

					rp.name = oo.sigla;
					rp.color = oo.color;

					for (Map.Entry<String,Integer> entryValue : entry.getValue().entrySet()) {
						String claveValue = entryValue.getKey();


						switch (claveValue) {
							case "1":	rp.medicos = entryValue.getValue(); break;//"Medicos"

							case "2":	rp.profesionAsistencia = entryValue.getValue(); break;//""Profesionales (Asistencial)" B
							case "5":	rp.enfermero = entryValue.getValue(); break;//""Enfermeria" B

							case "3":	rp.tecnicoAsistencial = entryValue.getValue(); break;//""Tecnicos (Asistencial)" C
							case "4":	rp.auxiliaresAsistencial = entryValue.getValue(); break;//""Auxiliares (Asistencial)" C
							case "9":	rp.adminitrativoAsistencial = entryValue.getValue(); break;//""Administrativos  (Asistencial)"


							case "6":	rp.profesion = entryValue.getValue(); break;//""Profesionales"
							case "7":	rp.tecnicos = entryValue.getValue(); break;//""Tecnicos"
							case "8":	rp.adminitrativo = entryValue.getValue(); break;//""Administrativos"
							case "10":	rp.auxiliares = entryValue.getValue(); break;//""Auxiliares"


							default:
								break;
						}
					}

					ObjectMapper mapper = new ObjectMapper();
					restJs.put(clave,mapper.writeValueAsString(rp));
				}

				results.add(restJs);

				response.put("success", true);
				response.put("results", results);
		    }catch (Exception e) {
		    	response.put("success", false);
			}
	    }

		return ok(response);
	}

	private static List<SqlRow> getDataPorTipoProfesion(Long organigramaId) {
		String sql = "WITH RECURSIVE recursetree AS ( " +
				"    SELECT id, padre_id, id AS nodo_nivel2 " +
				"    FROM organigramas " +
				"    WHERE padre_id = :organigramaId " +
				"    UNION ALL " +
				"    SELECT t.id, t.padre_id, rt.nodo_nivel2  " +
				"    FROM organigramas t " +
				"    JOIN recursetree rt ON rt.id = t.padre_id " +
				"), " +
				"conteos_base AS ( " +
				"    SELECT " +
				"        rt.nodo_nivel2  AS organigrama_id, " +
				"        tp.id           AS idTipoProfesion, " +
				"        tp.nombre       AS tipoProfesion, " +
				"        COUNT(a.id)     AS cantidad " +
				"    FROM agentes a  " +
				"    INNER JOIN recursetree rt       ON a.organigrama_id = rt.id " +
				"    INNER JOIN organigramas o       ON a.organigrama_id = o.id   " +
				"    INNER JOIN profesiones p        ON a.profesion_id   = p.id   " +
				"    INNER JOIN tipo_profesiones tp  ON p.tipo_profesion_id = tp.id   " +
				"    WHERE a.activo = true " +
				"    GROUP BY rt.nodo_nivel2, tp.id, tp.nombre " +
				") " +
				"SELECT  " +
				"    o.id            AS organigrama_id, " +
				"    o.nombre        AS organigrama, " +
				"    cb.idTipoProfesion, " +
				"    cb.tipoProfesion, " +
				"    cb.cantidad     AS cantidad_total " +
				"FROM conteos_base cb  " +
				"INNER JOIN organigramas o ON o.id = cb.organigrama_id " +
				"ORDER BY o.id, cantidad_total DESC;";

		List<SqlRow> todos = Ebean.createSqlQuery(sql).setParameter("organigramaId",  organigramaId).findList();
		return todos;
	}

	private static List<SqlRow>  getd(Long organigramaId) {



		String sql = " WITH RECURSIVE recursetree AS ( "+
				"   SELECT id, padre_id "+
				" 	    FROM organigramas "+
				" 	    WHERE id = :organigramaId "+
				" 	    UNION ALL "+
				"    SELECT t.id, t.padre_id "+
				" 	    FROM organigramas t "+
				" 	    JOIN recursetree rt ON rt.id = t.padre_id "+
				" 	), conteos_base AS ( "+
				" 	    SELECT  "+
				" 	        tp.id           AS idTipoProfesion, "+
				" 	        tp.nombre       AS tipoProfesion, "+
				" 	        COUNT(a.id)     AS cantidad "+
				" 	    FROM agentes a "+
				" 	    INNER JOIN organigramas o       ON a.organigrama_id = o.id "+
				" 	    INNER JOIN profesiones p        ON a.profesion_id   = p.id "+
				" 	    INNER JOIN tipo_profesiones tp  ON p.tipo_profesion_id = tp.id "+
				" 	    WHERE a.organigrama_id IN (SELECT id FROM recursetree) "+
				" 	      AND a.activo  = true "+
				"      GROUP BY tp.id, tp.nombre "+
				" ) "+
				" SELECT "+
					" o.id AS organigrama_id, "+
				    " o.nombre AS organigrama, "+
				    " cb.idTipoProfesion, "+
				    " cb.tipoProfesion, "+
				    "  cb.cantidad AS cantidad_total "+
				    " FROM conteos_base cb "+
				" CROSS JOIN (SELECT id, nombre FROM organigramas WHERE id = :organigramaId) o "+
				" ORDER BY cantidad_total DESC ";

		List<SqlRow> todos = Ebean.createSqlQuery(sql).setParameter("organigramaId",  organigramaId).findList();
		return todos;
	}

	public static Result index() {

		String sql =    " select menores_35.cantidad mn_35, intermedios.cantidad entre_35_45, mayores_45_55.cantidad my_45, mayores_55.cantidad my_55 " +
						" from escalas_laborales e  " +
						" LEFT join  " +
						" (select count(*) cantidad, pl.escala_laboral_id " +
						" from puestos_laborales pl  " +
						" join legajos l on pl.legajo_id = l.id " +
						" join agentes a on l.agente_id = a.id " +
						" where pl.activo is true and pl.convenio_ministerio = :convenio " +
						" and CAST(CAST(age(a.fnacimiento) as char(2)) as int)  <= 35 " +
						" group by pl.escala_laboral_id) as menores_35 on menores_35.escala_laboral_id = e.id " +
						" LEFT join " +
						" (select count(*) cantidad, pl.escala_laboral_id " +
						" from puestos_laborales pl  " +
						" join legajos l on pl.legajo_id = l.id " +
						" join agentes a on l.agente_id = a.id " +
						" where pl.activo is true and pl.convenio_ministerio = :convenio " +
						" and CAST(CAST(age(a.fnacimiento) as char(2)) as int)  between 36 and 45 " +
						" group by pl.escala_laboral_id) as intermedios on intermedios.escala_laboral_id = e.id " +
						" LEFT join  " +
						" (select count(*) cantidad, pl.escala_laboral_id " +
						" from puestos_laborales pl  " +
						" join legajos l on pl.legajo_id = l.id " +
						" join agentes a on l.agente_id = a.id " +
						" where pl.activo is true and pl.convenio_ministerio = :convenio " +
						" and CAST(CAST(age(a.fnacimiento) as char(2)) as int)  between 46 and 55 " +
						" group by pl.escala_laboral_id) as mayores_45_55 on mayores_45_55.escala_laboral_id = e.id " +
						" LEFT join  " +
						" (select count(*) cantidad, pl.escala_laboral_id " +
						" from puestos_laborales pl  " +
						" join legajos l on pl.legajo_id = l.id " +
						" join agentes a on l.agente_id = a.id " +
						" where pl.activo is true and pl.convenio_ministerio = :convenio " +
						" and CAST(CAST(age(a.fnacimiento) as char(2)) as int)  > 55 " +
						" group by pl.escala_laboral_id) as mayores_55 on mayores_55.escala_laboral_id = e.id " +
						" where e.id = 5";

		SqlRow ministerio = Ebean.createSqlQuery(sql).setParameter("convenio",  true).findUnique();
		SqlRow parque = Ebean.createSqlQuery(sql).setParameter("convenio",  false).findUnique();

		Integer mmn_35 		 = ministerio.getInteger("mn_35");
		Integer mentre_35_45 = ministerio.getInteger("entre_35_45");
		Integer mmy_45 		 = ministerio.getInteger("my_45");
		Integer mmy_55		 = ministerio.getInteger("my_55");

		Integer pmn_35 		 = parque.getInteger("mn_35");
		Integer pentre_35_45 = parque.getInteger("entre_35_45");
		Integer pmy_45 		 = parque.getInteger("my_45");
		Integer pmy_55		 = parque.getInteger("my_55");


		Integer totalMinisterio = mmn_35 + mentre_35_45 + mmy_45 + mmy_55;
		Integer totalParque 	= pmn_35 + pentre_35_45 + pmy_45 + pmy_55;
		Integer total = totalMinisterio + totalParque;


		Map<String, List<Integer>> numeros = new HashMap<String, List<Integer>>();
		numeros.put("parque", Arrays.asList(pmn_35, pentre_35_45, pmy_45, pmy_55));
		numeros.put("ministerio", Arrays.asList(mmn_35, mentre_35_45, mmy_45, mmy_55) );
		numeros.put("totales", Arrays.asList(mmn_35+pmn_35, mentre_35_45+pentre_35_45, mmy_45+pmy_45, mmy_55 + pmy_55));



		Map<String, List<Double>> porcentajes = new HashMap<String, List<Double>>();



		porcentajes.put("parque", Arrays.asList(redondear(pmn_35 * 100.0 / totalParque),  redondear(pentre_35_45 * 100.00 / totalParque), redondear(pmy_45 * 100.00 / totalParque), redondear(pmy_55 * 100.00 / totalParque)));
		porcentajes.put("ministerio", Arrays.asList(redondear(mmn_35 * 100.00 / totalMinisterio),  redondear(mentre_35_45 * 100.00 / totalMinisterio), redondear(mmy_45 * 100.00 / totalMinisterio), redondear(mmy_55 * 100.00 / totalMinisterio)) );
		porcentajes.put("totales", Arrays.asList(redondear(mmn_35+pmn_35 * 100.00 / total),  redondear(mentre_35_45+pentre_35_45 * 100.00 / total), redondear(mmy_45+pmy_45 * 100.00 / total), redondear(mmy_55 + pmy_55 * 100.00 / total)));

		return ok( profesionalesMedicos.render(numeros, porcentajes) );

	}

	private static Double redondear (Double d) {
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

}
