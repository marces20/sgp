package controllers.patrimonio;

import static play.data.Form.form;
import controllers.Secured;
import models.InventarioPrefijo;
import models.RemitoBaul;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.patrimonio.inventario.*;
import views.html.patrimonio.inventario.modales.modificarPrefijos;

@Security.Authenticated(Secured.class)
public class PrefijosAccionesController extends Controller {
		
	public static Result modificarModal() {
		Form<InventarioPrefijo> p = form(InventarioPrefijo.class).bindFromRequest();
		return ok(modificarPrefijos.render(p));
	}
	
	public static Result modificar(){

		return ok();
	}
	
}
