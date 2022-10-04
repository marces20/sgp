package controllers.administracion;

import java.util.List;

import models.Provincia;
import controllers.Secured;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.administracion.provincias.*;

@Security.Authenticated(Secured.class)
public class ProvinciasController extends Controller {

	public static Result index() {
		return ok(indexProvincia.render());
	}
	
	public static Result listOptions(Integer paisId){
		List<Provincia> p = Provincia.find.where().eq("pais_id", paisId).orderBy("nombre").findList();
		System.out.println(p.size());
		if(p.size() > 0)
			return ok(optionsListProvincia.render(p));
		else
			return ok();
	}
	
}
