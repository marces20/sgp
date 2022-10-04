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

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard.rrhh.*;

public class ProfesionalesMedicosController  extends Controller {

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
