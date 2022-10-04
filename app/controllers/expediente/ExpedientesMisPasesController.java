package controllers.expediente;

import static play.data.Form.form;
import models.Expediente;
import models.ExpedienteMiPase;
import models.Usuario;
import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.expediente.expedienteMisPases.*;

@Security.Authenticated(Secured.class)
public class ExpedientesMisPasesController extends Controller {
	
	 
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		return ok(indexExpedienteMisPases.render(ExpedienteMiPase.page( 
				Usuario.getUsuarioSesion().toString(),
				RequestVar.get("organigrama_id"),
				RequestVar.get("fecha_desde"),
				RequestVar.get("fecha_hasta")
				), d));
	}
}
