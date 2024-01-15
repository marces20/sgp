package controllers.haberes;

import static play.data.Form.form;

import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.haberes.controlHaberes.*;

@Security.Authenticated(Secured.class)
public class ControlHaberes extends Controller {

	@CheckPermiso(key = "liquidacionMesIndex")
	public static Result controlGuardiasPorAgentePorPeriodo() {

		DynamicForm d = form().bindFromRequest();
		List<SqlRow>  sqlQueryoRet = null;

		if(RequestVar.get("periodo_id").isEmpty() && RequestVar.get("agente_id").isEmpty()  && RequestVar.get("organigrma_id").isEmpty()){
			flash("error", "Debe seleccionar algun filtro.");
			return ok(controlGuardiasPorAgentePorPeriodo.render(d,sqlQueryoRet));
		}

		String sql = "SELECT sum(ld.cantidad) as total,a.id,a.apellido as agente,o.nombre as organigrama,p.nombre as periodo " +
				"FROM liquidacion_detalles ld " +
				"inner join liquidacion_puestos lp on ld.liquidacion_puesto_id = lp.id " +
				"inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id " +
				"inner join organigramas o on o.id= ld.organigrama_id " +
				"inner join periodos p on p.id= ld.periodo_id " +
				"inner join puestos_laborales pl on pl.id = lp.puesto_laboral_id  " +
				"inner join legajos l on l.id = pl.legajo_id " +
				"inner join agentes a on a.id = l.agente_id " +
				"where 1= 1 ";

		if(!RequestVar.get("periodo_id").isEmpty()) {
			sql += "and ld.periodo_id = :periodo_id ";
		}

		if(!RequestVar.get("organigrma_id").isEmpty()) {
			sql += "and ld.organigrma_id = :organigrma_id ";
		}

		if(!RequestVar.get("agente_id").isEmpty()) {
			sql += "and a.id = :agente_id ";
		}

		sql += "and lc.control_guardia = true " +
				"group by a.id,a.apellido,o.nombre,p.nombre order by a.apellido,o.nombre ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		if(!RequestVar.get("periodo_id").isEmpty()) {
			sqlQuery.setParameter("periodo_id",new Long(RequestVar.get("periodo_id")));
		}

		if(!RequestVar.get("agente_id").isEmpty()) {
			sqlQuery.setParameter("agente_id", new Long(RequestVar.get("agente_id")));
		}

		sqlQueryoRet = sqlQuery.findList();

		return ok(controlGuardiasPorAgentePorPeriodo.render(d,sqlQueryoRet));
	}
}
