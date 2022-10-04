package controllers.dashboard;

import java.util.List;

import models.BalancePresupuestario;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.dashboard.presupuesto.devengado;
import views.html.dashboard.presupuesto.index;

import com.avaje.ebean.SqlRow;

import controllers.Secured;

@Security.Authenticated(Secured.class)
public class PresupuestoController extends Controller  {
	
	public static Result index() {
		return ok(index.render());
	}
	
	public static Result devengado() {
		
		List<SqlRow> datos = BalancePresupuestario.getDevengado();
		
		
		return ok(devengado.render(datos));
		
	}
	
	
	
}
