package controllers.compras;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;

import controllers.Secured;

import models.Certificacion;
import models.PedidoFondo;
import models.Usuario;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.compras.pedidosFondos.*;

@Security.Authenticated(Secured.class)
public class PedidosFondosController extends Controller {
	
	final static Form<PedidoFondo> pedidoFondoForm = form(PedidoFondo.class);
	 
	public static Result URL_LISTA_PEDIDO = redirect(
			controllers.compras.routes.PedidosFondosController.index()
	);
	
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		
		return ok(
				indexPedidoFondo.render(
						PedidoFondo.page(
								 RequestVar.get("id"),
								 RequestVar.get("fecha_pedido_desde"),
								 RequestVar.get("fecha_pedido_hasta")
								),
								 d));
	}
	
	public static Result ver(Long id) {
		PedidoFondo pedidoFondo = PedidoFondo.find.byId(id);
		Form<PedidoFondo> pedidoFondoForm = form(PedidoFondo.class).fill(pedidoFondo);
		return ok(verPedidoFondo.render(pedidoFondoForm, pedidoFondo));
	}
	
	public static Result crear() {
		return ok(crearPedidoFondo.render(pedidoFondoForm));
	}
	
	public static Result guardar() {
		
		Form<PedidoFondo> pedidoFondoForm = form(PedidoFondo.class).bindFromRequest();
		
		validarForm(pedidoFondoForm);
		if(pedidoFondoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearPedidoFondo.render(pedidoFondoForm));
		}
		
		try {
			PedidoFondo c = pedidoFondoForm.get();
			c.create_date = new Date();
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.save();
			
			flash("success", "El pedido de fondo se ha actualizado");
			return redirect( controllers.compras.routes.PedidosFondosController.ver(pedidoFondoForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el pedido");
			return badRequest(crearPedidoFondo.render(pedidoFondoForm));
		}
	}
	
	public static Result editar(Long id) {
		PedidoFondo pedidoFondo = PedidoFondo.find.byId(id);
		if(pedidoFondo  == null){
			flash("error", "No se encuentra el pedido.");
			return redirect(controllers.compras.routes.PedidosFondosController.index()+UriTrack.get("?"));
		}
		
		
		return ok(editarPedidoFondo.render(pedidoFondoForm.fill(pedidoFondo),pedidoFondo));
	}
	
	public static Result actualizar(Long id){
		
		Form<PedidoFondo> pedidoFondoForm = form(PedidoFondo.class).bindFromRequest();
		validarForm(pedidoFondoForm);
		PedidoFondo pedidoFondo = Ebean.find(PedidoFondo.class, id);
		
		if(pedidoFondoForm.hasErrors()) {
			 
			flash("error", "Error en formulario");
			return badRequest(editarPedidoFondo.render(pedidoFondoForm,pedidoFondo));
		}
		
		try {
			PedidoFondo c = pedidoFondoForm.get();
			c.write_date = new Date();
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.update();
			flash("success", "El pedido de fondo se ha actualizado");
			return redirect( controllers.compras.routes.PedidosFondosController.ver(pedidoFondoForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el pedido");
			return badRequest(editarPedidoFondo.render(pedidoFondoForm,pedidoFondo));
		}
	}
	
	public static Result eliminar(Long id) {
		
		PedidoFondo pedidoFondo = Ebean.find(PedidoFondo.class).select("id, estado_id").setId(id).findUnique();
		
		if(pedidoFondo == null){
			flash("error", "No se encuentra el pedido.");
			return redirect(controllers.compras.routes.PedidosFondosController.index()+UriTrack.get("?"));
		}
		

		try {
			pedidoFondo.delete();
			flash("success", "Se ha eliminado el pedido");
			return redirect(UriTrack.decode());
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el pedido");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	public static void validarForm(Form<PedidoFondo> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("fecha_pedido", "Fecha inválida"));
		v.validate();
	}
}
