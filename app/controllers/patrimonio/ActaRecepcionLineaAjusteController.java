package controllers.patrimonio;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.ActaRecepcionLineaAjuste;
import models.Usuario;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.patrimonio.actaRecepcionAjustes.*;

@Security.Authenticated(Secured.class)
public class ActaRecepcionLineaAjusteController extends Controller {
	
	/*public static Result index(){
		DynamicForm d = form().bindFromRequest();
		Pagination<ActaRecepcionLineaAjuste> lineas = ActaRecepcionLineaAjuste.page(RequestVar.get("acta_id"));

		return ok(listaActaRecepcionLineasAjuste.render(lineas, d));
	}*/
	
	final static Form<ActaRecepcionLineaAjuste> lineaForm = form(ActaRecepcionLineaAjuste.class);
	
	public static Result index(Long acta_id, Boolean editable) {
		
		Pagination<ActaRecepcionLineaAjuste> lineas = ActaRecepcionLineaAjuste.page(acta_id);
		Logger.debug("ttttttttttttttttttttt "+acta_id);
		return ok(indexActaRecepcionLineaAjuste.render(lineas, editable));
	}
	
	public static Result crear(String actaId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("acta_id", actaId);
		b.put("producto_id","30653");
		b.put("producto.nombre","Diferencia Tipo de Cambio Moneda Extranjera");
		Form<ActaRecepcionLineaAjuste> linea = form(ActaRecepcionLineaAjuste.class).bind(b);
		linea.discardErrors();
		
		
		return ok(crearActaRecepcionLineaAjuste.render(linea));
				  
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			ActaRecepcionLineaAjuste cl = ActaRecepcionLineaAjuste.find.byId(id);
			cl.delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<ActaRecepcionLineaAjuste> lineaForm = form(ActaRecepcionLineaAjuste.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearActaRecepcionLineaAjuste.render(lineaForm));
			} else {
				ActaRecepcionLineaAjuste l = lineaForm.get();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro."+e);
			return ok(crearActaRecepcionLineaAjuste.render(lineaForm));
		}
		
		ActaRecepcionLineaAjuste linea = ActaRecepcionLineaAjuste.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verActaRecepcionLineaAjuste.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id) {
		flash().clear();
		ActaRecepcionLineaAjuste linea = ActaRecepcionLineaAjuste.find.byId(id);
		return ok(editarActaRecepcionLineaAjuste.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<ActaRecepcionLineaAjuste> lineaForm = form(ActaRecepcionLineaAjuste.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarActaRecepcionLineaAjuste.render(lineaForm));
			} else {
				ActaRecepcionLineaAjuste fl = lineaForm.get();
				//CertificacionServicioLinea l = lineaForm.get();
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarActaRecepcionLineaAjuste.render(lineaForm));
		}
		
		ActaRecepcionLineaAjuste linea = ActaRecepcionLineaAjuste.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verActaRecepcionLineaAjuste.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
