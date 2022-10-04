package controllers.compras;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Proveedor;
import models.ProveedorAtributo;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.proveedoresAtributos.*;

@Security.Authenticated(Secured.class)
public class ProveedorAtributosController extends Controller {
	
	final static Form<ProveedorAtributo> lineaForm = form(ProveedorAtributo.class);
	
	public static Result index(Long id, Boolean editable) {
		Pagination<ProveedorAtributo> lineas = ProveedorAtributo.page(id);
		return ok(indexLineaAtributo.render(lineas, editable));
	}
									  
	public static Result crear(String proveedorId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("proveedor_id", proveedorId);
		Form<ProveedorAtributo> linea = form(ProveedorAtributo.class).bind(b);
		linea.discardErrors();
		ProveedorAtributo o =  new ProveedorAtributo();
		return ok(crearLineaAtributo.render(linea,o));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			ProveedorAtributo.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		
		Form<ProveedorAtributo> atributoForm = form(ProveedorAtributo.class).bindFromRequest();
		
		
		try {
			if(atributoForm.hasErrors()) {
				System.out.println(atributoForm.errors());
				flash("error", "Error en formulario");
				ProveedorAtributo o = atributoForm.get();
				return ok(crearLineaAtributo.render(atributoForm,o));
			} else {
				ProveedorAtributo o = atributoForm.get();
				o.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				o.create_date = new Date();
				o.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			ProveedorAtributo o = null;
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaAtributo.render(atributoForm,o));
		}
		
		ProveedorAtributo linea = ProveedorAtributo.find.where().eq("id", atributoForm.get().id).findUnique();
		Object c = verLineaAtributo.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	 
	public static Result editar(Long id) {
		flash().clear();
		ProveedorAtributo linea = ProveedorAtributo.find.byId(id);
		return ok(editarLineaAtributo.render(lineaForm.fill(linea),linea));
	}
	
	public static Result actualizar() {
		
		Form<ProveedorAtributo> lineaForm = form(ProveedorAtributo.class).bindFromRequest();
		ProveedorAtributo f = lineaForm.get();
		try {
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarLineaAtributo.render(lineaForm,f));
			} else {
				
				f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.write_date = new Date();
				f.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaAtributo.render(lineaForm,f));
		}
		
		ProveedorAtributo linea = ProveedorAtributo.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaAtributo.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	
}
