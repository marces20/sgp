package controllers.novedades;

import controllers.Secured;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.novedades.indexNovedades;

@Security.Authenticated(Secured.class)
public class IndexController extends Controller {

	public static Result index() {
		return ok(indexNovedades.render());
	}

}
