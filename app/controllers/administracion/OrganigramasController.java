package controllers.administracion;

import static play.data.Form.form;
import models.Localidad;
import models.Organigrama;
import models.Usuario;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.administracion.organigrama.modalBusquedaServicios;
import views.html.administracion.usuarios.modalBusquedaUsuario;

@Security.Authenticated(Secured.class)
public class OrganigramasController extends Controller {
	
	
	public static Result modalBuscarServicios() {
    	Pagination<Organigrama> p = new Pagination<Organigrama>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Organigrama.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaServicios.render(p, form().bindFromRequest()) );
	}
	

	
	public static Result get(long id){
		Organigrama orga = Organigrama.find.where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(orga == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra servicio");
		} else {
			restJs.put("success", true);
			restJs.put("id", orga.id);
			restJs.put("nombre", orga.nombre);
			restJs.put("departamento", orga.organigramaPadre.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result suggestOrganigrama(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode o = rpta.arrayNode();
	    
	    Organigrama ad = new Organigrama();
		 
		for(Organigrama a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        o.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", o);
		 
		return ok(response);
	}
}
