package controllers.informes;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.informes.*;

public class IndexController extends Controller {
	
	public static Result index() {
		return ok(indexInformes.render());
	}
}
