package controllers.patrimonio;

import static play.data.Form.form;
import controllers.Secured;
import models.ActaRecepcionLinea;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.patrimonio.actaRecepcionLineas.*;

@Security.Authenticated(Secured.class)
public class ActasRecepcionLineasController extends Controller {

	public static Result index(){
		DynamicForm d = form().bindFromRequest();
		Pagination<ActaRecepcionLinea> lineas = ActaRecepcionLinea.page(RequestVar.get("acta_id"), RequestVar.get("producto_id"));

		return ok(listaActaRecepcionLineas.render(lineas, d));
	}
	
}
