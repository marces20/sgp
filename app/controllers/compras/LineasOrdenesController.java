package controllers.compras;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.Factura;
import models.OrdenLinea;
import models.OrdenLineaCliente;
import models.Usuario;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.lineasOrdenes.crearLineaProducto;
import views.html.compras.lineasOrdenes.indexLineaOrden;
import views.html.compras.lineasOrdenes.editarLineaProducto;
import views.html.compras.lineasOrdenes.verLineaProducto;
import views.html.compras.lineasOrdenes.acciones.modalAddClientes;

@Security.Authenticated(Secured.class)
public class LineasOrdenesController extends Controller {
	
	final static Form<OrdenLinea> lineaForm = form(OrdenLinea.class);
	
	public static Result index(Long ordenId, Boolean editable) {
		
		Pagination<OrdenLinea> lineas = OrdenLinea.page(ordenId);

		return ok(indexLineaOrden.render(lineas, editable));
	}
	
	public static Result crear(String ordenId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("orden_id", ordenId);
		b.put("udm_id","1");
		Form<OrdenLinea> linea = form(OrdenLinea.class).bind(b);
		linea.discardErrors();
		OrdenLinea o = new OrdenLinea();
		return ok(crearLineaProducto.render(linea,null));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			Ebean.beginTransaction();
			
			Ebean.delete(OrdenLineaCliente.find.where().eq("orden_linea_id",id).findList());
			OrdenLinea.find.byId(id).delete();
			
			Ebean.commitTransaction();
			
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();  
		}
	    
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<OrdenLinea> lineaForm = form(OrdenLinea.class).bindFromRequest();
		OrdenLinea o = lineaForm.get();
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearLineaProducto.render(lineaForm,o));
			} else {
				
				o = lineaForm.get();
				o.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				o.create_date = new Date();
				
				List<OrdenLinea> lol =  OrdenLinea.find.where()
										.eq("producto_id",o.producto_id)
										.eq("orden_id",o.orden_id)
										.eq("cuenta_analitica_id",o.cuenta_analitica_id)
										.findList();
				if(lol.size() > 0){
					flash("error", "Ya existe una linea con este producto en la orden.");
					return ok(crearLineaProducto.render(lineaForm,o));
				}else{
					o.save();
				}
				flash("success", "El registro se almacenó correctamente.");
				
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaProducto.render(lineaForm,o));
		}
		
		OrdenLinea linea = OrdenLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id) {
		flash().clear();
		OrdenLinea linea = OrdenLinea.find.byId(id);
		return ok(editarLineaProducto.render(lineaForm.fill(linea),linea));
	}
	
	public static Result actualizar() {
		Form<OrdenLinea> lineaForm = form(OrdenLinea.class).bindFromRequest();
		OrdenLinea o = lineaForm.get();
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaProducto.render(lineaForm,o));
			} else {
				o = lineaForm.get();
				o.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				o.write_date = new Date();
				List<OrdenLinea> lol =  OrdenLinea.find.where()
						.eq("producto_id",o.producto_id)
						.eq("orden_id",o.orden_id)
						.eq("cuenta_analitica_id",o.cuenta_analitica_id)
						.ne("id",o.id)
						.findList();
				if(lol.size() > 0){
					flash("error", "Ya existe una linea con este producto en la orden.");
					return ok(editarLineaProducto.render(lineaForm,o));
				}else{
					o.update();
					lineaForm.get().update();
				}
				
				
				
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaProducto.render(lineaForm,o));
		}

		OrdenLinea linea = OrdenLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Result modalAddClientes(Long id) {
		OrdenLinea linea = OrdenLinea.find.where().eq("id", id).findUnique();
		Map<String,String> b = new HashMap<String, String>();
		b.put("cantidad", linea.cantidad.toString());
		b.put("id", id.toString());
		Form<OrdenLineaCliente> ordenLineaClienteForm = form(OrdenLineaCliente.class).bind(b);
		 
		
		return ok(modalAddClientes.render(id,ordenLineaClienteForm));
	}
	
	public static Result eliminarMasivo() {
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		SqlUpdate sqldelete = Ebean.createSqlUpdate("DELETE FROM orden_lineas WHERE id IN (:ids)");
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
