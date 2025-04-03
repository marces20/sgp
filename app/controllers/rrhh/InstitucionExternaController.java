package controllers.rrhh;

import static play.data.Form.form;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.Especialidad;
import models.InstitucionExterna;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.rrhh.institucionExterna.*;

@Security.Authenticated(Secured.class)

public class InstitucionExternaController extends Controller {

	public static Result suggestInstitucionExterna(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode especialidad = rpta.arrayNode();

	    InstitucionExterna ad = new InstitucionExterna();

		for(InstitucionExterna a : ad.getDataSuggest(input, 25)){


			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        especialidad.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", especialidad);

		return ok(response);
	}

	public static Result get(int id){
		InstitucionExterna x = InstitucionExterna.find.select("id, nombre").where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(x == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el Institucion Externa");
		} else {
			restJs.put("success", true);
			restJs.put("id", x.id);
			restJs.put("nombre", x.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result modalBuscar() {
    	Pagination<InstitucionExterna> p = new Pagination<InstitucionExterna>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(InstitucionExterna.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaInstitucionExterna.render(p, form().bindFromRequest()) );
	}
}
