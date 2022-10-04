package controllers.rendiciones;

import static play.data.Form.form;
import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.MiPago;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.rendiciones.pagosRealizados.indexPagosRealizados;

@Security.Authenticated(Secured.class)
public class RendicionesController extends Controller {
	
	@CheckPermiso(key = "pagosRealizadosGeneral")
	public static Result indexPagosRealizados() {
		DynamicForm d = form().bindFromRequest();
		
		return ok(indexPagosRealizados.render(MiPago.page(RequestVar.get("tipo"),
														  RequestVar.get("fecha_desde"),
														  RequestVar.get("fecha_hasta"),
														  RequestVar.get("referencia"),
														  RequestVar.get("ordenPago.id")), d));
	}
}
