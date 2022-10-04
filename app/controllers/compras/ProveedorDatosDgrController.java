package controllers.compras;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.ProveedorDatoDgr;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.proveedoresDatosDgr.*;

@Security.Authenticated(Secured.class)
public class ProveedorDatosDgrController extends Controller {

	
	final static Form<ProveedorDatoDgr> lineaForm = form(ProveedorDatoDgr.class);
	
	public static Result index(Long cuit, Boolean editable) {
		Pagination<ProveedorDatoDgr> lineas = ProveedorDatoDgr.page(cuit);
		return ok(indexLineaDatosDgr.render(lineas, editable));
	}
									  
	public static Result crear(Long cuit) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("cuit", cuit.toString());
		Form<ProveedorDatoDgr> linea = form(ProveedorDatoDgr.class).bind(b);
		linea.discardErrors();
		ProveedorDatoDgr o =  new ProveedorDatoDgr();
		return ok(crearLineaDatosDgr.render(linea,o));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			ProveedorDatoDgr.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		
		Form<ProveedorDatoDgr> datoForm = form(ProveedorDatoDgr.class).bindFromRequest();
		
		
		try {
			if(datoForm.hasErrors()) {
				System.out.println(datoForm.errors());
				flash("error", "Error en formulario");
				ProveedorDatoDgr o = datoForm.get();
				return ok(crearLineaDatosDgr.render(datoForm,o));
			} else {
				ProveedorDatoDgr o = datoForm.get();
				o.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				o.create_date = new Date();
				o.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			ProveedorDatoDgr o = null;
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaDatosDgr.render(datoForm,o));
		}
		
		ProveedorDatoDgr linea = ProveedorDatoDgr.find.where().eq("id", datoForm.get().id).findUnique();
		Object c = verLineaDatosDgr.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	 
	public static Result editar(Long id) {
		flash().clear();
		ProveedorDatoDgr linea = ProveedorDatoDgr.find.byId(id);
		return ok(editarLineaDatosDgr.render(lineaForm.fill(linea),linea));
	}
	
	public static Result actualizar() {
		
		Form<ProveedorDatoDgr> lineaForm = form(ProveedorDatoDgr.class).bindFromRequest();
		ProveedorDatoDgr f = lineaForm.get();
		try {
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarLineaDatosDgr.render(lineaForm,f));
			} else {
				
				f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.write_date = new Date();
				f.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaDatosDgr.render(lineaForm,f));
		}
		
		ProveedorDatoDgr linea = ProveedorDatoDgr.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaDatosDgr.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
}
