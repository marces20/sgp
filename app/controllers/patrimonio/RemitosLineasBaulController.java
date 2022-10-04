package controllers.patrimonio;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.AgenteEstudio;
import models.AgenteHijo;
import models.RemitoBaul;
import models.RemitoLineaBaul;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.productos.indexProducto;
import views.html.patrimonio.baul.crearRemitoBaul;
import views.html.patrimonio.baul.lineas.*;
import views.html.patrimonio.remitos.editarRemito;
import views.html.rrhh.agenteHijos.editarAgenteHijo;
import views.html.rrhh.agenteHijos.verAgenteHijo;

@Security.Authenticated(Secured.class)
public class RemitosLineasBaulController  extends Controller {
	final static Form<RemitoLineaBaul> oForm = form(RemitoLineaBaul.class);

	public static Result index(Long remito_id, Boolean editable){
		DynamicForm d = form().bindFromRequest();
		Pagination<RemitoLineaBaul> lineas = RemitoLineaBaul.page(remito_id);
		
		return ok(indexProductoBaul.render(lineas, d, editable));
	}
	
	public static Result eliminar(Long id){
		RemitoLineaBaul linea = RemitoLineaBaul.find.where().eq("id", id).findUnique();
		
		ObjectNode restJs = Json.newObject();
		
		
		try {
			linea.delete();
			restJs.put("success", true);
		} catch (Exception e) {
			restJs.put("success", false);
			restJs.put("message", "No se pudo eliminar el registro.");
		}
		
		
		return ok(restJs);
	}
	
	public static Result crear(Long remito_id){
		Map<String,String> b = new HashMap<String, String>();
		b.put("remito_baul_id", remito_id.toString());
		Form<RemitoLineaBaul> linea = form(RemitoLineaBaul.class).bind(b);
		linea.discardErrors();
		return ok(crearProducto.render(linea));
	}
	
	public static Result guardar(){
		Form<RemitoLineaBaul> lineaForm = form(RemitoLineaBaul.class).bindFromRequest();
		
		if(lineaForm.hasErrors()) {
			flash("error", "Error en formulario.");
			System.out.println(lineaForm.errors());
			return ok(editarProducto.render(lineaForm));
		}
		
		RemitoLineaBaul f = lineaForm.get();
		
		try {				
			f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			f.write_date = new Date();
			f.save();

		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarProducto.render(lineaForm));
		}
		
		RemitoLineaBaul linea = RemitoLineaBaul.find.where().eq("id", f.id).findUnique();
		Object c = lineasProductoBaul.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result editar(Long id){
		RemitoLineaBaul r = RemitoLineaBaul.find.byId(id);
		Form<RemitoLineaBaul> rb = form(RemitoLineaBaul.class).fill(r);

		return ok(editarProducto.render(rb));
	}
	
	public static Result actualizar(){
		Form<RemitoLineaBaul> lineaForm = form(RemitoLineaBaul.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario.");
				System.out.println(lineaForm.errors());
				return ok(editarProducto.render(lineaForm));
			} else {
				RemitoLineaBaul f = lineaForm.get();
				f.update();
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarProducto.render(lineaForm));
		}
		
		RemitoLineaBaul linea = RemitoLineaBaul.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = lineasProductoBaul.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
}
