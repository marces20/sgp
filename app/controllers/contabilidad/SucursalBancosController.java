package controllers.contabilidad;

import static play.data.Form.form;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Banco;
import models.Expediente;
import models.Provincia;
import models.Solicitud;
import models.SucursalBanco;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.administracion.provincias.optionsListProvincia;
import views.html.compras.solicitudes.indexSolicitud;
import views.html.contabilidad.sucursalbancos.*;
import views.html.expediente.expediente.modalBusquedaExpediente;

@Security.Authenticated(Secured.class)
public class SucursalBancosController extends Controller {
	
	final static Form<SucursalBanco> sucursalBancoForm = form(SucursalBanco.class);
	
	public static Result URL_LISTA_SUCURSAL_BANCO = redirect(
			controllers.contabilidad.routes.SucursalBancosController.indexSucursalBanco()
	);
	
	@CheckPermiso(key = "bancosSucursalesGeneral")
	public static Result indexSucursalBanco() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexSucursalBanco.render(
						SucursalBanco.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "bancosSucursalesGeneral")
	public static Result crearSucursalBanco() {
		Form<SucursalBanco> sucursalBancoForm = form(SucursalBanco.class);
		return ok(crearSucursalBanco.render(sucursalBancoForm));
	}
	
	@CheckPermiso(key = "bancosSucursalesGeneral")
	public static Result guardarSucursalBanco() {
		
		Form<SucursalBanco> sucursalBancoForm = form(SucursalBanco.class).bindFromRequest();
		
		try {
			if(sucursalBancoForm.field("banco.id").value().isEmpty()){
				sucursalBancoForm.reject("banco.id","El Banco es obligatorio.");
			}
			if(sucursalBancoForm.field("localidad.id").value().isEmpty()){
				sucursalBancoForm.reject("localidad.id","La Localidad es obligatoria.");
			}
			
			if(sucursalBancoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearSucursalBanco.render(sucursalBancoForm));
			} else {
				SucursalBanco s = sucursalBancoForm.get();
				s.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				s.create_date = new Date();
				s.save();
				flash("success", "La Sucursal se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la Sucursal");
			return badRequest(crearSucursalBanco.render(sucursalBancoForm));
		}
		
		return URL_LISTA_SUCURSAL_BANCO;
	}
	
	@CheckPermiso(key = "bancosSucursalesGeneral")
	public static Result editarSucursalBanco(Long id) {
		SucursalBanco sucursalBanco = Ebean.find(SucursalBanco.class, id);
		
		return ok(editarSucursalBanco.render(sucursalBancoForm.fill(sucursalBanco)));
	}
	
	@CheckPermiso(key = "bancosSucursalesGeneral")
	public static Result actualizarSucursalBanco(){
		
		Form<SucursalBanco> sucursalBancoForm = form(SucursalBanco.class).bindFromRequest();
		
		try {
			
			if(sucursalBancoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarSucursalBanco.render(sucursalBancoForm));
			} else {
				SucursalBanco s = sucursalBancoForm.get();
				s.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				s.write_date = new Date();
				s.update();

				flash("success", "La Sucursal se ha actualizado");
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la Sucursal");
			return badRequest(editarSucursalBanco.render(sucursalBancoForm));
		}
		return URL_LISTA_SUCURSAL_BANCO;
	}
	
	@CheckPermiso(key = "bancosSucursalesGeneral")
	public static Result eliminarSucursalBanco(Long id) {
		try {
			SucursalBanco.find.byId(id).delete();
			flash("success", "Se ha eliminado la Sucursal");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la Sucursal");
		}

		return URL_LISTA_SUCURSAL_BANCO;
	}
	
	@CheckPermiso(key = "bancosSucursalesGeneral")
	public static Result suggestSucursalBanco(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode sucursalBanco = rpta.arrayNode();
	    
	    SucursalBanco ad = new SucursalBanco();
		 
		for(SucursalBanco a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", a.banco.nombre);
	        sucursalBanco.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", sucursalBanco);
		 
		return ok(response);
	}
	
	public static Result listOptions(Integer bancoId){
		List<SucursalBanco> p = SucursalBanco.find.where().eq("banco_id", bancoId).findList();
		System.out.println(p.size());
		if(p.size() > 0)
					  
			return ok(optionsListSucursalBanco.render(p));
		else
			return ok();
	}
	
	public static Result get(int id){
		SucursalBanco sucursalBanco = SucursalBanco.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(sucursalBanco == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
		} else {
			restJs.put("success", true);
			restJs.put("id", sucursalBanco.id);
			restJs.put("nombre", sucursalBanco.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<SucursalBanco> p = new Pagination<SucursalBanco>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(SucursalBanco.find.fetch("banco").where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaSucursalBanco.render(p, form().bindFromRequest()) );
	}
}
