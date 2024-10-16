package controllers.haberes;

import static play.data.Form.form;

import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionNovedadLicencia;
import models.haberes.Novedad;
import play.Logger;
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

		/*Logger.debug("EMPIEZAAAAAAAAAAAAAAAAAAA");

		List<LiquidacionDetalle> ld = LiquidacionDetalle.find.where()
				.eq("liquidacionPuesto.liquidacionMes.periodo_id", 154)
				.isNotNull("liquidacion_novedad_id")
				.findList();

		for(LiquidacionDetalle ldx : ld) {
			if(ldx.liquidacion_novedad_id != null) {
				Novedad n = Novedad.find.byId(ldx.liquidacion_novedad_id);
				if(n !=null) {
					ldx.periodo_id = n.periodo_concepto_id;
					ldx.organigrama_id = n.organigrama_id;
					ldx.update();
 				}
			}
		}

		Logger.debug("terminaaaaaaaaaaaaaaa");*/

		DynamicForm d = form().bindFromRequest();
		List<SqlRow>  sqlQueryoRet = null;

		if(RequestVar.get("periodo_id").isEmpty() && RequestVar.get("agente_id").isEmpty()  && RequestVar.get("organigrama_id").isEmpty()){
			flash("error", "Debe seleccionar algun filtro.");
			return ok(controlGuardiasPorAgentePorPeriodo.render(d,sqlQueryoRet));
		}

		String sql = "SELECT sum(ld.cantidad) as total,a.id,a.apellido as agente,o.nombre as organigrama,p.nombre as periodo,COALESCE(a.limite_guardia,0) as limite_guardia " +
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

		if(!RequestVar.get("organigrama_id").isEmpty()) {
			sql += "and ld.organigrama_id = :organigrama_id ";
		}

		if(!RequestVar.get("agente_id").isEmpty()) {
			sql += "and a.id = :agente_id ";
		}

		sql += "and lc.control_guardia = true " +
				"group by a.id,a.apellido,o.nombre,p.nombre,COALESCE(a.limite_guardia,0) "
				+ "order by a.apellido,o.nombre ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		if(!RequestVar.get("periodo_id").isEmpty()) {
			sqlQuery.setParameter("periodo_id",new Long(RequestVar.get("periodo_id")));
		}

		if(!RequestVar.get("organigrama_id").isEmpty()) {
			sqlQuery.setParameter("organigrama_id",new Long(RequestVar.get("organigrama_id")));
		}

		if(!RequestVar.get("agente_id").isEmpty()) {
			sqlQuery.setParameter("agente_id", new Long(RequestVar.get("agente_id")));
		}

		sqlQueryoRet = sqlQuery.findList();

		return ok(controlGuardiasPorAgentePorPeriodo.render(d,sqlQueryoRet));
	}
}
