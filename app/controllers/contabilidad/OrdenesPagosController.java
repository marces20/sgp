package controllers.contabilidad;

import static play.data.Form.form;

import java.util.Date;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import models.CuentaAnalitica;
import models.OrdenPago;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NoRecordModelException;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.contabilidad.ordenesPagos.*;

import com.avaje.ebean.ExpressionList;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class OrdenesPagosController extends Controller {

	final static Form<OrdenPago> ordenForm = form(OrdenPago.class);
	
	public static Result URL_INDEX_ORDEN = redirect(
			controllers.contabilidad.routes.OrdenesPagosController.index()  + UriTrack.get("&")
	);
	
	@CheckPermiso(key = "ordenesPagosGeneral")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexOrdenPago.render(OrdenPago.page(
														RequestVar.get("numero"), 
														RequestVar.get("ejercicio"),
														RequestVar.get("fecha_ultimo_pago_desde"),
														RequestVar.get("fecha_ultimo_pago_hasta")
														), d));
	}
	
	@CheckPermiso(key = "ordenesPagosGeneral")
	public static Result crear() {
		Form<OrdenPago> form = form(OrdenPago.class);
		return ok(crearOrdenPago.render(form));
	}
	
	@CheckPermiso(key = "ordenesPagosGeneral")
	public static Result guardar() {
		
		Form<OrdenPago> form = form(OrdenPago.class).bindFromRequest();
		
		try {
			
			if(form.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearOrdenPago.render(form));
			} else {
				OrdenPago orden = form.get();
				buscarDuplicado(orden.ejercicio_id, orden.numero);
				orden.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				orden.create_date = new Date();
				orden.save();
				flash("success", "El ejercicio se ha actualizado");
			}
		} catch(ConstraintViolationException  e){                                                         
			flash("error", "El número y ejercicio ya existe");    
			return badRequest(crearOrdenPago.render(form));
        }  catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el ejercicio" + pe);
			return badRequest(crearOrdenPago.render(form));
		}
		
		return redirect( controllers.contabilidad.routes.OrdenesPagosController.index() );
	}
	

	@CheckPermiso(key = "ordenesPagosGeneral")
	public static Result editar(Long id) {
		OrdenPago orden;
		try {
			orden = loadModel(id);
		} catch (NoRecordModelException e) {
			return URL_INDEX_ORDEN;
		}
		
		
		return ok(editarOrdenPago.render(ordenForm.fill(orden)));
	}
	
	@CheckPermiso(key = "ordenesPagosGeneral")
	public static Result actualizar(){
		
		Form<OrdenPago> form = form(OrdenPago.class).bindFromRequest();
		
		if(form.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarOrdenPago.render(form));
		}
		
		try {
			OrdenPago orden = form.get();
			buscarDuplicado(orden.ejercicio_id, orden.numero,orden.id);
			orden.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			orden.write_date = new Date();
			orden.update();

			flash("success", "El registro se ha actualizado");
		}catch(ConstraintViolationException  e){                                                         
			flash("error", "El número y ejercicio ya existe");    
			return badRequest(editarOrdenPago.render(form));
        }  catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el registro");
			return badRequest(editarOrdenPago.render(form));
		}
		return redirect( controllers.contabilidad.routes.OrdenesPagosController.index() );
	}
	
	
	@CheckPermiso(key = "ordenesPagosGeneral")
	public static Result eliminar(Long id) {
		try {
			OrdenPago.find.byId(id).delete();
			flash("success", "Se ha eliminado el registro");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el registro");
		}
		return redirect(request().getHeader("referer"));
	}
	
	private static OrdenPago loadModel(Long id) throws NoRecordModelException {
		OrdenPago orden = OrdenPago.find.byId(id);
		if (orden == null) {
			flash("error", "La orden de pago ya no existe.");
			throw new NoRecordModelException();
		}
		return orden;
	}

	public static void buscarDuplicado(Long ejercicio_id, Integer numero){
		OrdenPago orden = OrdenPago.find.where().eq("ejercicio_id", ejercicio_id).eq("numero", numero).findUnique();
		if(orden != null)
			throw new ConstraintViolationException(null);
	}
	
	public static void buscarDuplicado(Long ejercicio_id, Integer numero,Long id){
		OrdenPago orden = OrdenPago.find.where().eq("ejercicio_id", ejercicio_id).eq("numero", numero).ne("id",id).findUnique();
		if(orden != null)
			throw new ConstraintViolationException(null);
	}
	
	public static Result get(int id){
		OrdenPago orden = OrdenPago.find.select("id, numero, ejercicio_id").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(orden == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
		} else {
			restJs.put("success", true);
			restJs.put("id", orden.id);
			restJs.put("nombre", orden.numero +" / "+orden.ejercicio.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<OrdenPago> p = new Pagination<OrdenPago>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	
    	ExpressionList<OrdenPago> e = OrdenPago.find.where();
    	
    	if(!RequestVar.get("ejercicio_id").isEmpty()){
    		e.eq("ejercicio_id", Integer.parseInt( RequestVar.get("ejercicio_id")) );
    	}
    	if(!RequestVar.get("numero").isEmpty()){
    		e.eq("numero", Integer.parseInt( RequestVar.get("numero") ) );
    	}
    	
    	//e = e.disjunction();
    	//e = e.ilike("descripcion", "%" + RequestVar.get("descripcion") + "%");

    	p.setExpressionList(e);
		return ok( modalBusquedaOrdenes.render(p, form().bindFromRequest()) );
	}
	
	public static Result suggestOrdenPago(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode cuenta = rpta.arrayNode();
	    
	    OrdenPago ad = new OrdenPago();
		 
		for(OrdenPago a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.getNombreCompleto());
	        restJs.put("info", "");
	        cuenta.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", cuenta);
		 
		return ok(response);
	}
}
