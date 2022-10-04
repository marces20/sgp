package controllers.contabilidad;

import static play.data.Form.form;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;

import models.Cuenta;
import models.CuentaAnalitica;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.compras.lineasSolicitudes.modalBusquedaCuentasAsociadas;
import views.html.contabilidad.cuentasAnaliticas.crearCuentaAnalitica;
import views.html.contabilidad.cuentasAnaliticas.editarCuentaAnalitica;
import views.html.contabilidad.cuentasAnaliticas.indexCuentasAnaliticas;
import views.html.contabilidad.cuentasAnaliticas.modalBusquedaCuentaAnalitica;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class CuentasAnaliticasController extends Controller {
	final static Form<CuentaAnalitica> cuentaForm = form(CuentaAnalitica.class);

	@CheckPermiso(key = "cuentasPresupuestariasGeneral")
	public static Result index(Long id) {
		
		List<CuentaAnalitica> cuentas = CuentaAnalitica.find.where().eq("parent_id", null).findList();

		return ok(indexCuentasAnaliticas.render(cuentas));
	}
	
	@CheckPermiso(key = "cuentasPresupuestariasGeneral")
	public static Result crear(Long parent_id) {
		CuentaAnalitica cuentaPadre = CuentaAnalitica.find.where().eq("id", parent_id).findUnique();
		return ok(crearCuentaAnalitica.render(cuentaForm, cuentaPadre));
	}
	
	@CheckPermiso(key = "cuentasPresupuestariasGeneral")
	public static Result guardar(Long parent_id) {
		Form<CuentaAnalitica> cuentaForm = form(CuentaAnalitica.class).bindFromRequest();
		
		CuentaAnalitica cuentaPadre = CuentaAnalitica.find.byId(parent_id);
		
		if(cuentaForm.hasErrors()) {
			flash("error", "Compruebe los errores en el formulario.");
			System.out.println(cuentaForm.errors());
			return badRequest(crearCuentaAnalitica.render(cuentaForm, cuentaPadre));
		}
		
		CuentaAnalitica cuenta = cuentaForm.get();
		
		try {
			cuenta.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			cuenta.create_date = new Date();
			cuenta.save();
			flash("success", "El registro se almacenó correctamente.");
		} catch (PersistenceException pe){
			System.out.println(pe);
			flash("error", "No se ha podido almacenar el registro.");
			return badRequest(crearCuentaAnalitica.render(cuentaForm, cuentaPadre));
		}
		
		return redirect( controllers.contabilidad.routes.CuentasAnaliticasController.index(cuenta.id));
	}
	
	@CheckPermiso(key = "cuentasPresupuestariasGeneral")
	public static Result editar(Long parent_id) {
		CuentaAnalitica cuenta = CuentaAnalitica.find.byId(parent_id);
		Form<CuentaAnalitica> cuentaFormm = cuentaForm.fill(cuenta);
		
		if(cuenta.parent_id == null || cuenta.parent_id == 0){
			cuenta.padre = new CuentaAnalitica();
		}		
		return ok(editarCuentaAnalitica.render(cuentaFormm, cuenta.padre));
	}
	
	@CheckPermiso(key = "cuentasPresupuestariasGeneral")
	public static Result actualizar() {
		Form<CuentaAnalitica> cuentaForm = form(CuentaAnalitica.class).bindFromRequest();
		
		if(cuentaForm.hasErrors()) {
			flash("error", "Error en formulario");
			System.out.println(cuentaForm.errors());
		} else {
			CuentaAnalitica cuenta = cuentaForm.get();
			cuenta.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			cuenta.write_date = new Date();
			cuenta.update();
			flash("success", "El registro se actualizó correctamente.");
		}

		return redirect(controllers.contabilidad.routes.CuentasAnaliticasController.editar(Long.parseLong(cuentaForm.data().get("id"))));
	}
	
	@CheckPermiso(key = "cuentasPresupuestariasGeneral")
	public static Result eliminar(Long id) {
		
		int hijos = CuentaAnalitica.find.where().eq("parent_id", id).findRowCount();
		if(hijos > 0){
			flash("error", "La cuenta tiene items, debe eliminar primero sus items.");		
		} else {
			try {
				CuentaAnalitica cuenta = CuentaAnalitica.find.byId(id);
				id = cuenta.parent_id;
				cuenta.delete();
				flash("success", "Se ha eliminado el registro.");
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar el registro.");
			}
		}
		if(id == null){
			return redirect(controllers.contabilidad.routes.CuentasAnaliticasController.index(new Long(0)));
		}else{
			return redirect(controllers.contabilidad.routes.CuentasAnaliticasController.index(id) );
		}
		
	}
	
	public static Result get(Long id){
		CuentaAnalitica cuentaAnalitica = CuentaAnalitica.find.select("id, nombre,codigo").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(cuentaAnalitica == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la Cuenta");
		} else {
			restJs.put("success", true);
			restJs.put("id", cuentaAnalitica.id);
			restJs.put("nombre", cuentaAnalitica.nombre);
			restJs.put("code", cuentaAnalitica.codigo);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result suggestCuentaAnalitica(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode cuenta = rpta.arrayNode();
	    
	    CuentaAnalitica ad = new CuentaAnalitica();
		 
		for(CuentaAnalitica a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", a.codigo);
	        cuenta.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", cuenta);
		 
		return ok(response);
	}
	
	public static Result modalBuscar() {
    	Pagination<CuentaAnalitica> p = new Pagination<CuentaAnalitica>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(CuentaAnalitica.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaCuentaAnalitica.render(p, form().bindFromRequest()) );
	}
	
	public static Result modalBuscarCuentasAsociadas(Long solicitud_id) {
		flash().clear();
    	Pagination<CuentaAnalitica> p = new Pagination<CuentaAnalitica>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	

    	String sql = "select c.id, c.nombre from cuentas_analiticas c left outer join solicitud_lineas as sl on c.id = sl.cuenta_analitica_id group by c.id, c.nombre";
    	RawSql rawSql = RawSqlBuilder.parse(sql).create(); 
    	p.setExpressionList(Ebean.find(CuentaAnalitica.class).setRawSql(rawSql).where().ilike("nombre", "%" + RequestVar.get("nombre") + "%").eq("sl.solicitud_id", Integer.parseInt(RequestVar.get("solicitud_id")) ));

		return ok( modalBusquedaCuentasAsociadas.render(solicitud_id, p, form().bindFromRequest() ));
	}
	
}
