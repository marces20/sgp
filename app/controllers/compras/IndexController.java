package controllers.compras;

import controllers.Secured;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.compras.*;

@Security.Authenticated(Secured.class)
public class IndexController extends Controller {

	public static Result index() {
		return ok(indexCompras.render());
	}

}
