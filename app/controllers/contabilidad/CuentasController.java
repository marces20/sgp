package controllers.contabilidad;

import static play.data.Form.form;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import models.Cuenta;
import models.CuentaBancaria;
import models.Usuario;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.contabilidad.cuentas.*;

@Security.Authenticated(Secured.class)
public class CuentasController extends Controller {
	final static Form<Cuenta> cuentaForm = form(Cuenta.class);
	
	@CheckPermiso(key = "cuentasGeneral")
	public static Result index(Long id) {
		
		List<Cuenta> cuentas = Cuenta.getHijos();

		return ok(indexCuentas.render(cuentas));
	}
	
	public static Result crear(Long parent_id) {
		Cuenta cuentaPadre = Cuenta.find.where().eq("id", parent_id).findUnique();
		
		return ok(crearCuenta.render(cuentaForm, cuentaPadre));
	}
	
	public static Result guardar(Long parent_id) {
		Form<Cuenta> cuentaForm = form(Cuenta.class).bindFromRequest();
		
		Cuenta cuentaPadre = Cuenta.find.byId(parent_id);
		
		if(cuentaForm.hasErrors()) {
			flash("error", "Compruebe los errores en el formulario.");
			System.out.println(cuentaForm.errors());
			return badRequest(crearCuenta.render(cuentaForm, cuentaPadre));
		}
		
		Cuenta cuenta = cuentaForm.get();
		
		try {	
			cuenta.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			cuenta.create_date = new Date();
			cuenta.save();
			flash("success", "El registro se almacenó correctamente.");
		} catch (PersistenceException pe){
			System.out.println(pe);
			flash("error", "No se ha podido almacenar el registro.");
			return badRequest(crearCuenta.render(cuentaForm, cuentaPadre));
		}
		
		return redirect( controllers.contabilidad.routes.CuentasController.index(cuenta.id));
	}
	
	public static Result editar(Long parent_id) {
		Cuenta cuenta = Cuenta.find.byId(parent_id);
		Form<Cuenta> cuentaFormm = cuentaForm.fill(cuenta);
		
		if(cuenta.parent_id == 0){
			cuenta.padre = new Cuenta();
		}		
		return ok(editarCuenta.render(cuentaFormm, cuenta.padre));
	}
	
	public static Result actualizar() {
		Form<Cuenta> cuentaForm = form(Cuenta.class).bindFromRequest();
		
		if(cuentaForm.hasErrors()) {
			flash("error", "Error en formulario");
			System.out.println(cuentaForm.errors());
		} else {
			Cuenta cuenta = cuentaForm.get();
			cuenta.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			cuenta.write_date = new Date();
			cuenta.update();
			flash("success", "El registro se actualizó correctamente.");
		}

		return redirect(controllers.contabilidad.routes.CuentasController.editar(Long.parseLong(cuentaForm.data().get("id"))));
	}
	
	public static Result eliminar(Long id) {
		
		int hijos = Cuenta.find.where().eq("parent_id", id).findRowCount();
		if(hijos > 0){
			flash("error", "La cuenta tiene items, debe eliminar primero sus items.");		
		} else {
			try {
				Cuenta cuenta = Cuenta.find.byId(id);
				id = cuenta.parent_id;
				cuenta.delete();
				flash("success", "Se ha eliminado el registro.");
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar el registro.");
			}
		}

		return redirect(controllers.contabilidad.routes.CuentasController.index(id) );
	}
	
	public static Result suggestCuenta(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode cuenta = rpta.arrayNode();
	    
	    Cuenta ad = new Cuenta();
		 
		for(Cuenta a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", a.code);
	        cuenta.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", cuenta);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		Cuenta cuenta = Cuenta.find.select("id, nombre,code").where().eq("id", id).findUnique();
		
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
			restJs.put("code", cuenta.code);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<Cuenta> p = new Pagination<Cuenta>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Cuenta.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaCuenta.render(p, form().bindFromRequest()) );
	}
}
