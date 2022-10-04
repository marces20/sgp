package controllers.compras;

import static play.data.Form.form;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import models.DireccionProveedor;
import models.Factura;
import models.Orden;
import models.Proveedor;
import models.Usuario;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NoRecordModelException;
import utils.RequestVar;
import utils.pagination.Pagination;
import utils.validation.EmailFormatValidation;
import utils.validation.RequiredValidation;
import utils.validation.Validator;
import views.html.compras.proveedores.*;
import views.html.haberes.liquidacionPuestos.modales.modalReciboSueldoPorPuestoMail;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class ProveedoresController extends Controller {

	final static Form<Proveedor> provForm = form(Proveedor.class);	
	
    public static Result URL_LISTA = redirect(
    		controllers.compras.routes.ProveedoresController.index()
        );

    @CheckPermiso(key = "proveedoresVer")
	public static Result index() {		
		DynamicForm d = form().bindFromRequest();
		return ok(indexProveedor.render(
										 Proveedor.page(
												 RequestVar.get("nombre"),
												 RequestVar.get("cuit"),
												 RequestVar.get("tipo")
												 ), d));
	}

    @CheckPermiso(key = "proveedoresCrear")
	public static Result crear() {		
		Form<Proveedor> provForm = form(Proveedor.class);
		return ok(crearProveedor.render(provForm));
	}
    
    @CheckPermiso(key = "proveedoresCrear")
	public static Result guardar() {
		Form<Proveedor> provForm = form(Proveedor.class).bindFromRequest();
		
		if(provForm.hasErrors()) {
			flash("error", "Compruebe los errores en el formulario.");
			return badRequest(crearProveedor.render(provForm));
		}
		
		try {
			Proveedor p =  provForm.get();
			
			if(p.cuit == null && p.dni == null) {
				flash("error", "Debe ingresar DNI o CUIT.");
				return badRequest(crearProveedor.render(provForm));
			}
			
			if(p.agente_id != null){
				if(Proveedor.find.where().eq("agente_id",p.agente_id).findRowCount() > 0){
					flash("error", "Ya existe un proveedor con este agente asociado.");
					return badRequest(crearProveedor.render(provForm));
				}
			}
			
			if(p.cuit != null) {
				List<Proveedor> px =  Proveedor.find.where().eq("cuit",p.cuit).findList() ;
				if(px.size() > 0){
					flash("error", "Ya existe un proveedor con este cuit");
					return badRequest(editarProveedor.render(provForm));
				}
			}else if(p.dni != null) {
				List<Proveedor> px =  Proveedor.find.where().eq("dni",p.dni).findList() ;
				if(px.size() > 0){
					flash("error", "Ya existe un proveedor con este dni");
					return badRequest(editarProveedor.render(provForm));
				}
			}
			 
			p.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			p.create_date = new Date();
			p.save();
			
			flash("success", "El registro se almacenó correctamente.");
			return redirect(controllers.compras.routes.ProveedoresController.ver(p.id) );
		} catch (PersistenceException pe){
			flash("error", "No se ha podido almacenar el registro.");
			return badRequest(crearProveedor.render(provForm));
		}
		
		//return URL_LISTA;
	}
	
    @CheckPermiso(key = "proveedoresCrear")
	public static Result editar(Long id) {
		Proveedor provedor = Proveedor.find.byId(id);
		
		return ok(editarProveedor.render(provForm.fill(provedor)));
	}
	
    @CheckPermiso(key = "proveedoresCrear")
	public static Result actualizar() {
		Form<Proveedor> provForm = form(Proveedor.class).bindFromRequest();
		
		if(provForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarProveedor.render(provForm));
		} else {
			Proveedor p = provForm.get();
			
			if(p.cuit == null && p.dni == null) {
				flash("error", "Debe ingresar DNI o CUIT.");
				return badRequest(crearProveedor.render(provForm));
			}
			
			if(p.agente_id != null){
				if(Proveedor.find.where().eq("agente_id",p.agente_id).ne("id",p.id).findRowCount() > 0){
					flash("error", "Ya existe un proveedor con este agente asociado.");
					return badRequest(editarProveedor.render(provForm));
				}
			}
			
			if(p.cuit != null) {
				List<Proveedor> px =  Proveedor.find.where().eq("cuit",p.cuit).ne("id", p.id).findList() ;
				if(px.size() > 0){
					flash("error", "Ya existe un proveedor con este cuit");
					return badRequest(editarProveedor.render(provForm));
				}
			}else if(p.dni != null) {
				List<Proveedor> px =  Proveedor.find.where().eq("dni",p.dni).ne("id", p.id).findList() ;
				if(px.size() > 0){
					flash("error", "Ya existe un proveedor con este dni");
					return badRequest(editarProveedor.render(provForm));
				}
			}
			
			
			p.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			p.write_date = new Date();
			p.update();
			
			flash("success", "El registro se ha modificado correctamente.");
			return redirect(controllers.compras.routes.ProveedoresController.ver(p.id));
		}
	}	
    
    
	
    /*
	public static Result formularioContacto(Long id) {
		if(id > 0){
			Proveedor proveedor = new Proveedor();
			proveedor.direcciones.add( DireccionProveedor.find.byId(id) );
			return ok(formProvDirecciones.render(provForm.fill(proveedor), true));
		}

		return ok(formProvDirecciones.render(provForm, true));
	}
	*/
    
	public static Result formularioContacto(Long proveedorId, Long id) {
		Form<DireccionProveedor> fp = form(DireccionProveedor.class);
		
		if(id > 0){
			DireccionProveedor p = DireccionProveedor.find.byId(id);
			p.proveedor_id = proveedorId;
			return ok(formProvDirecciones.render( fp.fill(p), proveedorId, true ));
		}

		return ok(formProvDirecciones.render(fp, proveedorId, true));
	}    
    
    
    @CheckPermiso(key = "proveedoresCrear")
	public static Result actualizarContacto() {
		Form<DireccionProveedor> provForm = form(DireccionProveedor.class).bindFromRequest();

		if(provForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(formProvDirecciones.render(provForm, Long.parseLong(provForm.data().get("proveedor_id")), true));
		} else {
			DireccionProveedor dp = provForm.get();
			
			if (!EmailFormatValidation.EmailValidation(dp.email)) {
				flash("error", "Email Inválido");
				return ok(formProvDirecciones.render(provForm, Long.parseLong(provForm.data().get("proveedor_id")), true));
			}else {
			
				if(dp.id == null) {
					dp.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					dp.create_date = new Date();
					dp.save();
				} else {
					dp.write_usuario_id = new Long(Usuario.getUsuarioSesion());
					dp.write_date = new Date();
					dp.update();
				}
			}
						
			ObjectNode restJs = Json.newObject();
			restJs.put("success", true);
			restJs.put("redirect", controllers.compras.routes.ProveedoresController.ver( Long.parseLong(provForm.data().get("proveedor_id"))).toString() );
			return ok(restJs);
		}
	}
	
    @CheckPermiso(key = "proveedoresCrear")
	public static Result guardarContacto() {
		Form<DireccionProveedor> provForm = form(DireccionProveedor.class).bindFromRequest();
		
		if(provForm.hasErrors()) {
			flash("error", "Error en formulario");
			//return badRequest(editarProveedor.render(provForm));
			return ok();
		} else {
			DireccionProveedor p = provForm.get();
			p.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			p.create_date = new Date();
			p.save();
			
			flash("success", "El registro se ha modificado correctamente.");
			return redirect(controllers.compras.routes.ProveedoresController.ver(p.id));
		}
	}
    
	public static Result eliminarContacto(Long id, Long cId){
		
		if( DireccionProveedor.find.where().eq("proveedor_id", id).findRowCount() > 1 ){
			try {
				DireccionProveedor dp = Ebean.find(DireccionProveedor.class).select("id").setId(cId).findUnique();
				dp.delete();
				flash("success", "Se ha eliminado el registro.");
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar el registro."+pe.getMessage());
			}
		} else {
			flash("error", "No se puede eliminar el único contacto existente.");
		}
		
		return redirect(controllers.compras.routes.ProveedoresController.editar(id));
	}
	
	@CheckPermiso(key = "proveedoresEliminar")
	public static Result eliminar(Long id) {
		try {
			Proveedor.find.byId(id).delete();
			flash("success", "Se ha eliminado el registro.");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el registro.");
		}

		return URL_LISTA;
	}
	
	public static Result ver(Long id) {

		Proveedor proveedor = null;

		try {
			proveedor = loadProveedor(id);
		} catch (NoRecordModelException e) {
			return URL_LISTA;
		}

		return ok(verProveedor.render(provForm.fill(proveedor),proveedor));
	}
	
	private static Proveedor loadProveedor(Long id) throws NoRecordModelException {
		Proveedor proveedor = Proveedor.find.byId(id);
		if (proveedor == null) {
			flash("error", "El proveedor solicitado ya no existe.");
			throw new NoRecordModelException();
		}
		return proveedor;
	}
    
    public static Result suggestProveedor(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode proveedor = rpta.arrayNode();
	    
	    Proveedor ad = new Proveedor();
		 
		for(Proveedor a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        proveedor.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", proveedor);
		 
		return ok(response);
	}
    
    public static Result modalBuscar() {
    	Pagination<Proveedor> p = new Pagination<Proveedor>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("nombre");	
    	p.setExpressionList(Proveedor.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaProveedor.render(p, form().bindFromRequest()) );
	}
	
    public static Result get(int id){
		Proveedor proveedor = Proveedor.find.select("id, nombre").where()
											.eq("id", id)
											//.eq("activo", true)
											.findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(proveedor == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el proveedor");
		} else {
			restJs.put("success", true);
			restJs.put("id", proveedor.id);
			restJs.put("nombre", proveedor.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
    
}
