package controllers.contabilidad;

import static play.data.Form.form;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.Cuenta;
import models.CuentaPropia;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.contabilidad.cuentasPropias.modalBusquedaCuentaPropia;

@Security.Authenticated(Secured.class)
public class CuentasPropiasController extends Controller {
	
	public static Result get(int id){
		CuentaPropia cuenta = CuentaPropia.find.select("id, nombre,code").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(cuenta == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la Cuenta");
		} else {
			restJs.put("success", true);
			restJs.put("id", cuenta.id);
			restJs.put("nombre", cuenta.nombre);
			restJs.put("code", cuenta.numero);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<CuentaPropia> p = new Pagination<CuentaPropia>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(CuentaPropia.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaCuentaPropia.render(p, form().bindFromRequest()) );
	}
}
