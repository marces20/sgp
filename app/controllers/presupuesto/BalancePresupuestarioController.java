package controllers.presupuesto;

import static play.data.Form.form;

import java.util.Date;
import java.util.List;

import models.BalancePresupuestario;
import models.Ejercicio;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.presupuesto.balancePresupuestario.indexBalancePresupuestario;
import views.html.presupuesto.balancePresupuestario.indexBalancePresupuestarioPorEjercicio;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class BalancePresupuestarioController extends Controller {
	final static Form<BalancePresupuestario> bpForm = form(BalancePresupuestario.class);
			
	@CheckPermiso(key = "balancePresupuestarioGeneral")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		List<BalancePresupuestario> lbp = null;
		if(!RequestVar.get("cuenta_analitica_padre_id").isEmpty() || !RequestVar.get("cuenta_analitica_hija_id").isEmpty()){
			
			Integer idCuenta = null;
			if(!RequestVar.get("cuenta_analitica_padre_id").isEmpty()){
				idCuenta = new Integer(RequestVar.get("cuenta_analitica_padre_id"));
			}
			
			Integer idCuentaHija = null;
			if(!RequestVar.get("cuenta_analitica_hija_id").isEmpty()){
				idCuentaHija = new Integer(RequestVar.get("cuenta_analitica_hija_id"));
			}
			Integer idEjercicio = null;
			if(!RequestVar.get("ejercicio").isEmpty()){
				idEjercicio = new Integer(RequestVar.get("ejercicio"));
			}else{
				idEjercicio = new Integer(5);
			}
			
			Integer tipo_cuenta_id = null;
			Integer osId = null;
			if(!RequestVar.get("obrasocial_id").isEmpty() && !RequestVar.get("tipo_cuenta_id").isEmpty()){
				tipo_cuenta_id = new Integer(RequestVar.get("tipo_cuenta_id"));
				osId = new Integer(RequestVar.get("obrasocial_id"));
			}
			
			lbp = BalancePresupuestario.getSaldosPorCuentaPorExpedientes(idCuenta,idCuentaHija,idEjercicio,tipo_cuenta_id,osId);
		}
		
		Integer idEjercicio = null;
		if(!RequestVar.get("ejercicio").isEmpty()){
			idEjercicio = new Integer(RequestVar.get("ejercicio"));
		}else{
			Ejercicio ej = Ejercicio.getEjercicioByFecha(new Date());
			idEjercicio = ej.id.intValue();
		}
		
		Pagination<BalancePresupuestario> b = BalancePresupuestario.getPorCuentaPadre(
				RequestVar.get("cuenta_analitica_padre_id"),
				RequestVar.get("cuenta_analitica_hija_id"),
				RequestVar.get("expediente.id"),
				idEjercicio.toString(),
				RequestVar.get("tipo_cuenta_id"),
				RequestVar.get("obrasocial_id")
				);		

		
		
		return ok(indexBalancePresupuestario.render(b, d,lbp,idEjercicio.toString()));
		
	}
	
	@CheckPermiso(key = "balancePresupuestarioGeneral")
	public static Result balancePresupuestarioPorExpediente() {
		
		DynamicForm d = form().bindFromRequest();
		List<BalancePresupuestario> lbp = null;
		Integer idEjercicio = null;
		if(!RequestVar.get("ejercicio").isEmpty()){
			idEjercicio = new Integer(RequestVar.get("ejercicio"));
		}else{
			Ejercicio ejActual = Ejercicio.getEjercicioByFecha(new Date()); 
			idEjercicio = ejActual.id.intValue();
		}
		
		lbp = BalancePresupuestario.getControlDeudaPorEjercicio(idEjercicio);
		
		return ok(indexBalancePresupuestarioPorEjercicio.render(d,lbp,idEjercicio.toString()));
		
	}
	
}
