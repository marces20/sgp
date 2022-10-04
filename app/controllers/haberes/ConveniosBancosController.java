package controllers.haberes;

import static play.data.Form.form;
import javax.persistence.PersistenceException;
import java.io.IOException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.CentroCosto;
import models.haberes.ConvenioBanco;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.conveniosBancos.*;

public class ConveniosBancosController extends Controller {
	
	final static Form<ConvenioBanco> convenioBancoForm = form(ConvenioBanco.class);
	
	public static Result URL_LISTA_CONVENIO_BANCO = redirect(
			controllers.haberes.routes.ConveniosBancosController.index()
	);
	
	@CheckPermiso(key = "convenioBancoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexConvenioBanco.render(
						ConvenioBanco.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "convenioBancoCrear")
	public static Result crear() {
		Form<ConvenioBanco> convenioBancoForm = form(ConvenioBanco.class);
		return ok(crearConvenioBanco.render(convenioBancoForm));
	}
	
	@CheckPermiso(key = "convenioBancoCrear")
	public static Result guardar() {
		
		Form<ConvenioBanco> convenioBancoForm = form(ConvenioBanco.class).bindFromRequest();
		
		try {
			if(convenioBancoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearConvenioBanco.render(convenioBancoForm));
			} else {
				ConvenioBanco lc = convenioBancoForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El convenio se ha actualizado");
				return redirect( controllers.haberes.routes.ConveniosBancosController.ver( convenioBancoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el convenio");
			return badRequest(crearConvenioBanco.render(convenioBancoForm));
		}
	}
	
	@CheckPermiso(key = "convenioBancoEditar")
	public static Result editar(Long id) {
		ConvenioBanco lc = Ebean.find(ConvenioBanco.class, id);
		return ok(editarConvenioBanco.render(convenioBancoForm.fill(lc)));
	}
	
	@CheckPermiso(key = "convenioBancoEditar")
	public static Result actualizar(){
		
		Form<ConvenioBanco> convenioBancoForm = form(ConvenioBanco.class).bindFromRequest();
		
		try {
			
			if(convenioBancoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarConvenioBanco.render(convenioBancoForm));
			} else {
				ConvenioBanco lc = convenioBancoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El convenio se ha actualizado");
				return redirect( controllers.haberes.routes.ConveniosBancosController.ver( convenioBancoForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el convenio");
			return badRequest(editarConvenioBanco.render(convenioBancoForm));
		}
	}
	
	@CheckPermiso(key = "convenioBancoEliminar")
	public static Result eliminar(Long id) {
		try {
			ConvenioBanco.find.byId(id).delete();
			flash("success", "Se ha eliminado el convenio");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el convenio");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "convenioBancoVer")
	public static Result ver(Long id) throws IOException {
		ConvenioBanco lc = ConvenioBanco.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el convenio");
			return URL_LISTA_CONVENIO_BANCO;
		}
		
		return ok(verConvenioBanco.render(convenioBancoForm.fill(lc),lc));
	}
	
	public static Result suggestConvenioBanco(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode convenioBanco = rpta.arrayNode();
	    
	    ConvenioBanco lc = new ConvenioBanco();
		 
		for(ConvenioBanco a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        convenioBanco.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", convenioBanco);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		ConvenioBanco lc = ConvenioBanco.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el convenio");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<ConvenioBanco> p = new Pagination<ConvenioBanco>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(ConvenioBanco.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaConvenioBanco.render(p, form().bindFromRequest()) );
	}
}
