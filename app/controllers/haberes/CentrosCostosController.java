package controllers.haberes;

import static play.data.Form.form;
import javax.persistence.PersistenceException;
import java.io.IOException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.haberes.CentroCosto;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.haberes.centrosCostos.*;

public class CentrosCostosController extends Controller {
	
	final static Form<CentroCosto> centroCostoForm = form(CentroCosto.class);
	
	public static Result URL_LISTA_CENTRO_COSTO = redirect(
			controllers.haberes.routes.CentrosCostosController.index()
	);
	
	@CheckPermiso(key = "centroCostoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexCentroCosto.render(
						CentroCosto.page(
								 RequestVar.get("nombre")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "centroCostoCrear")
	public static Result crear() {
		Form<CentroCosto> centroCostoForm = form(CentroCosto.class);
		return ok(crearCentroCosto.render(centroCostoForm));
	}
	
	@CheckPermiso(key = "centroCostoCrear")
	public static Result guardar() {
		
		Form<CentroCosto> centroCostoForm = form(CentroCosto.class).bindFromRequest();
		
		try {
			if(centroCostoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearCentroCosto.render(centroCostoForm));
			} else {
				CentroCosto lc = centroCostoForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El centro de costo se ha actualizado");
				return redirect( controllers.haberes.routes.CentrosCostosController.ver( centroCostoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el centro costo");
			return badRequest(crearCentroCosto.render(centroCostoForm));
		}
	}
	
	@CheckPermiso(key = "centroCostoEditar")
	public static Result editar(Long id) {
		CentroCosto lc = Ebean.find(CentroCosto.class, id);
		return ok(editarCentroCosto.render(centroCostoForm.fill(lc)));
	}
	
	@CheckPermiso(key = "centroCostoEditar")
	public static Result actualizar(){
		
		Form<CentroCosto> centroCostoForm = form(CentroCosto.class).bindFromRequest();
		
		try {
			
			if(centroCostoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarCentroCosto.render(centroCostoForm));
			} else {
				CentroCosto lc = centroCostoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El centro costo se ha actualizado");
				return redirect( controllers.haberes.routes.CargosLaboralesController.ver( centroCostoForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el centro costo");
			return badRequest(editarCentroCosto.render(centroCostoForm));
		}
	}
	
	@CheckPermiso(key = "centroCostoEliminar")
	public static Result eliminar(Long id) {
		try {
			CentroCosto.find.byId(id).delete();
			flash("success", "Se ha eliminado el centro costo");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el centro costo");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "centroCostoVer")
	public static Result ver(Long id) throws IOException {
		CentroCosto lc = CentroCosto.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el centro costo");
			return URL_LISTA_CENTRO_COSTO;
		}
		
		return ok(verCentroCosto.render(centroCostoForm.fill(lc),lc));
	}
	
	public static Result suggestCentroCosto(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode centroCosto = rpta.arrayNode();
	    
	    CentroCosto lc = new CentroCosto();
		 
		for(CentroCosto a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        centroCosto.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", centroCosto);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		CentroCosto lc = CentroCosto.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(lc == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el centro costo");
		} else {
			restJs.put("success", true);
			restJs.put("id", lc.id);
			restJs.put("nombre", lc.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<CentroCosto> p = new Pagination<CentroCosto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(CentroCosto.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok(modalBusquedaCentroCosto.render(p, form().bindFromRequest()) );
	}
}
