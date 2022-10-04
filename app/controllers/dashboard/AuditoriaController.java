package controllers.dashboard;

import static play.data.Form.form;

import controllers.Secured;
import models.AgenteRul;
import models.Auditoria;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import views.html.dashboard.auditoria.*;

@Security.Authenticated(Secured.class)
public class AuditoriaController extends Controller  {
	
	public static Result index() {
		
		DynamicForm d = form().bindFromRequest();
		Pagination<Auditoria> a = Auditoria.page(
				RequestVar.get("tabla"),
				RequestVar.get("operacion"),
				RequestVar.get("usuario_id"),
				RequestVar.get("fecha_desde"),
				RequestVar.get("fecha_hasta")
				);
			
		return ok(index.render(a, d));
	}	
}
