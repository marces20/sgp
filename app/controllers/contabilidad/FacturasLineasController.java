package controllers.contabilidad;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.FacturaLinea;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.contabilidad.facturasLineas.crearLineaProducto;
import views.html.contabilidad.facturasLineas.editarLineaProducto;
import views.html.contabilidad.facturasLineas.verLineaProducto;
import views.html.contabilidad.facturasLineas.indexFacturaLinea;

@Security.Authenticated(Secured.class)
public class FacturasLineasController extends Controller {
	
	final static Form<FacturaLinea> lineaForm = form(FacturaLinea.class);
	
	public static Result index(Long facturaId, Boolean editable) {
		
		Pagination<FacturaLinea> lineas = FacturaLinea.page(facturaId);

		return ok(indexFacturaLinea.render(lineas, editable));
	}
	
	public static Result crear(String facturaId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("factura_id", facturaId);
		Form<FacturaLinea> linea = form(FacturaLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaProducto.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			FacturaLinea.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<FacturaLinea> lineaForm = form(FacturaLinea.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				System.out.println(lineaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLineaProducto.render(lineaForm));
			} else {
				FacturaLinea f = lineaForm.get();
				f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.create_date = new Date();
				f.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaProducto.render(lineaForm));
		}
		
		FacturaLinea linea = FacturaLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id) {
		flash().clear();
		FacturaLinea linea = FacturaLinea.find.byId(id);
		return ok(editarLineaProducto.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<FacturaLinea> lineaForm = form(FacturaLinea.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaProducto.render(lineaForm));
			} else {
				FacturaLinea fl = lineaForm.get();
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaProducto.render(lineaForm));
		}
		
		FacturaLinea linea = FacturaLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	
	public static Result eliminarMasivo() {
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		SqlUpdate sqldelete = Ebean.createSqlUpdate("DELETE FROM factura_lineas WHERE id IN (:ids)");
		sqldelete.setParameter("ids", facturasSeleccionados);
		Integer sd = sqldelete.execute();
		ObjectNode result = Json.newObject();
		
		if (sd > 0) {
			result.put("success", true);
		} else {
			result.put("success", true);
		}
		
		
		return ok(result);
	}
	
	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado[]");
		} catch (NullPointerException e) {
		}
		
		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}
}
