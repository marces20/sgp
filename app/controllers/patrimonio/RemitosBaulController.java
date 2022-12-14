package controllers.patrimonio;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.CertificacionServicio;
import models.Estado;
import models.Orden;
import models.Pago;
import models.Recepcion;
import models.Remito;
import models.RemitoBaul;
import models.RemitoLinea;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.compras.ordenes.crearOrden;
import views.html.patrimonio.baul.*;

@Security.Authenticated(Secured.class)
public class RemitosBaulController extends Controller {
	final static Form<Remito> oForm = form(Remito.class);
	
	@CheckPermiso(key = "remitosVer")
	public static Result index(){

		DynamicForm d = form().bindFromRequest();
		Pagination<RemitoBaul> remitos = RemitoBaul.page(RequestVar.get("numero"), RequestVar.get("proveedor_id"), RequestVar.get("producto_id"), RequestVar.get("create_usuario_id"), RequestVar.get("fecha_desde"), RequestVar.get("fecha_hasta"));
		return ok(indexRemitoBaul.render(remitos, d));
	}
	
	@CheckPermiso(key = "remitosCrear")
	public static Result crear(){
		Form<RemitoBaul> rb = form(RemitoBaul.class).bindFromRequest();
		return ok(crearRemitoBaul.render(rb));
		
	}
	
	@CheckPermiso(key = "remitosCrear")
	public static Result guardar(){

		Form<RemitoBaul> rb = form(RemitoBaul.class).bindFromRequest();
		
		if(rb.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearRemitoBaul.render(rb));
		}

		try {
			RemitoBaul r = rb.get();
			r.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			r.create_date = new Date();
			r.save();
			flash("success", "Se ha cargado el remito en baúl.");
			return redirect( controllers.patrimonio.routes.RemitosBaulController.ver(r.id) );
		} catch (PersistenceException pe) {
			flash("error", "No se ha podido almacenar el remito." + pe.getMessage());
			return badRequest( crearRemitoBaul.render(rb) );
		}
		
	}
	
	
	@CheckPermiso(key = "remitosCrear")
	public static Result editar(Long id){
		RemitoBaul r = RemitoBaul.find.byId(id);
		Form<RemitoBaul> rb = form(RemitoBaul.class).fill(r);
		return ok(editarRemitoBaul.render(rb));
		
	}
	
	@CheckPermiso(key = "remitosCrear")
	public static Result actualizar(){
	
		Form<RemitoBaul> rb = form(RemitoBaul.class).bindFromRequest();
		
		if(rb.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarRemitoBaul.render(rb));
		}

		try {
			RemitoBaul r = rb.get();
			r.update();
			flash("success", "Se ha modificado el remito en baúl.");
			return redirect( controllers.patrimonio.routes.RemitosBaulController.ver(r.id) );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido modificar el remito.");
			return badRequest( editarRemitoBaul.render(rb) );
		}
		
	}
	
	@CheckPermiso(key = "remitosVer")
	public static Result ver(Long id){
		RemitoBaul r = RemitoBaul.find.byId(id);
	
		return ok(verRemitoBaul.render(r));
		
	}	
	
	
	@CheckPermiso(key = "remitosEliminar")
	public static Result eliminar(Long id){
		RemitoBaul r = RemitoBaul.find.byId(id);
		try {
			r.delete();
			flash("success", "Se ha eliminado el remito en baúl.");
			return redirect( controllers.patrimonio.routes.RemitosBaulController.index() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el remito.");
			return redirect(request().getHeader("referer"));
		}
		
	}
	
}
