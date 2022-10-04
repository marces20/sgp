package controllers.dashboard;

import static play.data.Form.form;

import controllers.Secured;
import models.InventarioRismi;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import views.html.dashboard.inventarioRismi.*;

@Security.Authenticated(Secured.class)
public class InventarioRismiController  extends Controller {
	
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		return ok(
			indexInventarioRismi.render(InventarioRismi.page(
											 RequestVar.get("producto_inv"),
											 RequestVar.get("responsable_inv"),
											 RequestVar.get("lugar_inv"),
											 RequestVar.get("numero_inventario")
											),
											 d, pf));
	}
}
