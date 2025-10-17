package controllers.novedades;

import static play.data.Form.form;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.novedades.produccion.imagenes.*;

@Security.Authenticated(Secured.class)
public class ProduccionImagenesController extends Controller {

	@CheckPermiso(key = "produccionImagenesVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexProduccionImagenes.render());
	}
}
