package controllers.equipo;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.equipo.*;

public class IndexController extends Controller {

	public static Result index() {
		return ok(indexEquipos.render());
	}

}
