package controllers.haberes;

import static play.data.Form.form;
import javax.persistence.PersistenceException;
import java.io.IOException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.InstrumentoLegal;
import models.haberes.Legajo;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.instrumentosLegales.*;

public class InstrumentosLegalesController extends Controller {
	
	final static Form<InstrumentoLegal> ilForm = form(InstrumentoLegal.class);
	
	public static Result URL_LISTA_IL = redirect(
			controllers.haberes.routes.InstrumentosLegalesController.index()
	);
	
	@CheckPermiso(key = "instrumentoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexInstrumentoLegal.render(
						InstrumentoLegal.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "instrumentoCrear")
	public static Result crear() {
		Form<InstrumentoLegal> ilForm = form(InstrumentoLegal.class);
		return ok(crearInstrumentoLegal.render(ilForm));
	}
	
	@CheckPermiso(key = "instrumentoCrear")
	public static Result guardar() {
		
		Form<InstrumentoLegal> ifForm = form(InstrumentoLegal.class).bindFromRequest();
		
		try {
			if(ifForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearInstrumentoLegal.render(ifForm));
			} else {
				InstrumentoLegal lc = ifForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El instrumento se ha actualizado");
				return redirect( controllers.haberes.routes.InstrumentosLegalesController.ver( ifForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el instrumento");
			return badRequest(crearInstrumentoLegal.render(ifForm));
		}
	}
	
	@CheckPermiso(key = "instrumentoEditar")
	public static Result editar(Long id) {
		InstrumentoLegal lc = Ebean.find(InstrumentoLegal.class, id);
		return ok(editarInstrumentoLegal.render(ilForm.fill(lc)));
	}
	
	@CheckPermiso(key = "instrumentoEditar")
	public static Result actualizar(){
		
		Form<InstrumentoLegal> ilForm = form(InstrumentoLegal.class).bindFromRequest();
		
		try {
			
			if(ilForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarInstrumentoLegal.render(ilForm));
			} else {
				InstrumentoLegal lc = ilForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El intrumento se ha actualizado");
				return redirect( controllers.haberes.routes.InstrumentosLegalesController.ver( ilForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el instrumento");
			return badRequest(editarInstrumentoLegal.render(ilForm));
		}
	}
	
	@CheckPermiso(key = "instrumentoEliminar")
	public static Result eliminar(Long id) {
		try {
			InstrumentoLegal.find.byId(id).delete();
			flash("success", "Se ha eliminado el instrumento");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el instrumento");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "instrumentoVer")
	public static Result ver(Long id) throws IOException {
		InstrumentoLegal lc = InstrumentoLegal.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el instrumento");
			return URL_LISTA_IL;
		}
		
		return ok(verInstrumentoLegal.render(ilForm.fill(lc),lc));
	}
	
	public static Result suggestInstrumentoLegal(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode instrumentoLegal = rpta.arrayNode();
	    
	    InstrumentoLegal lc = new InstrumentoLegal();
		 
		for(InstrumentoLegal a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        instrumentoLegal.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", instrumentoLegal);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		InstrumentoLegal lc = InstrumentoLegal.find.select("id, numero").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el instrumento");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<InstrumentoLegal> p = new Pagination<InstrumentoLegal>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(InstrumentoLegal.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaInstrumentoLegal.render(p, form().bindFromRequest()) );
	}
}
