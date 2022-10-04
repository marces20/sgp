package controllers.compras;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.CertificacionLinea;
import models.PedidoFondoLinea;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.lineasPedidosFondos.*;

@Security.Authenticated(Secured.class)
public class LineasPedidosFondosController extends Controller {
	final static Form<PedidoFondoLinea> lineaForm = form(PedidoFondoLinea.class);
	
	public static Result index(Long facturaId, Boolean editable) {
		
		Pagination<PedidoFondoLinea> lineas = PedidoFondoLinea.page(facturaId);

		return ok(indexPedidoLinea.render(lineas, editable));
	}
	
	public static Result crear(String pedidoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("pedido_fondo_id", pedidoId);
		Form<PedidoFondoLinea> linea = form(PedidoFondoLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaPedido.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			PedidoFondoLinea.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<PedidoFondoLinea> lineaForm = form(PedidoFondoLinea.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearLineaPedido.render(lineaForm));
			} else {
				PedidoFondoLinea l = lineaForm.get();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaPedido.render(lineaForm));
		}
		
		PedidoFondoLinea linea = PedidoFondoLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaPedido.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result editar(Long id) {
		flash().clear();
		PedidoFondoLinea linea = PedidoFondoLinea.find.byId(id);
		return ok(editarLineaPedido.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<PedidoFondoLinea> lineaForm = form(PedidoFondoLinea.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaPedido.render(lineaForm));
			} else {
				PedidoFondoLinea fl = lineaForm.get();
				PedidoFondoLinea l = lineaForm.get();
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaPedido.render(lineaForm));
		}
		
		PedidoFondoLinea linea = PedidoFondoLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaPedido.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
