package controllers.compras;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.CertificacionLinea;
import models.FacturaLinea;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.lineasCertificaciones.crearLineaProducto;
import views.html.compras.lineasCertificaciones.editarLineaProducto;
import views.html.compras.lineasCertificaciones.indexCertificacionLinea;
import views.html.compras.lineasCertificaciones.verLineaProducto;

@Security.Authenticated(Secured.class)
public class LineasCertificacionesController extends Controller {
	
	final static Form<CertificacionLinea> lineaForm = form(CertificacionLinea.class);
	
	public static Result index(Long facturaId, Boolean editable) {
		
		Pagination<CertificacionLinea> lineas = CertificacionLinea.page(facturaId);

		return ok(indexCertificacionLinea.render(lineas, editable));
	}
	
	public static Result crear(String certificacionId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("certificacion_id", certificacionId);
		Form<CertificacionLinea> linea = form(CertificacionLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaProducto.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			CertificacionLinea.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<CertificacionLinea> lineaForm = form(CertificacionLinea.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				System.out.println(lineaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLineaProducto.render(lineaForm));
			} else {
				CertificacionLinea l = lineaForm.get();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaProducto.render(lineaForm));
		}
		
		CertificacionLinea linea = CertificacionLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id) {
		flash().clear();
		CertificacionLinea linea = CertificacionLinea.find.byId(id);
		return ok(editarLineaProducto.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<CertificacionLinea> lineaForm = form(CertificacionLinea.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaProducto.render(lineaForm));
			} else {
				CertificacionLinea fl = lineaForm.get();
				CertificacionLinea l = lineaForm.get();
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaProducto.render(lineaForm));
		}
		
		CertificacionLinea linea = CertificacionLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
