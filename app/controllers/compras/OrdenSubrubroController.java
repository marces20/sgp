package controllers.compras;

import java.util.List;

import models.OrdenSubrubro;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.compras.ordenesSubrubro.optionsListSubrubro;
import controllers.Secured;

@Security.Authenticated(Secured.class)
public class OrdenSubrubroController extends Controller {

	public static Result listOptions(Integer rubroId){
		List<OrdenSubrubro> p = null;

		if(rubroId == 7 || rubroId == 5 || rubroId == 4 || rubroId == 3) {
			p = OrdenSubrubro.find.where().eq("orden_rubro_id", rubroId).eq("activo", true).orderBy("sigla").findList();

		}else {
			p = OrdenSubrubro.find.where().eq("orden_rubro_id", rubroId).orderBy("sigla").findList();
		}


		if(p.size() > 0)
			return ok(optionsListSubrubro.render(p));
		else
			return ok();
	}

}