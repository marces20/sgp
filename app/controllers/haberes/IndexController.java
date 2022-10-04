package controllers.haberes;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.haberes.*;

public class IndexController extends Controller {

	public static Result index() {
		return ok(indexHaberes.render());
	}

}
