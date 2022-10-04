package controllers.compras;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import models.CuentaAnalitica;
import models.Ejercicio;
import models.Estado;
import models.Solicitud;
import models.SolicitudLinea;
import models.Usuario;
import models.auth.Permiso;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.lineasAjustesOrdenes.crearLineaAjuste;
import views.html.compras.lineasSolicitudes.crearLineaProducto;
import views.html.compras.lineasSolicitudes.editarLineaProducto;
import views.html.compras.lineasSolicitudes.indexLineaSolicitud;
import views.html.compras.lineasSolicitudes.verLineaProducto;

@Security.Authenticated(Secured.class)
public class LineasSolicitudesController extends Controller {
	final static Form<SolicitudLinea> lineaForm = form(SolicitudLinea.class);	
	
	public static Result index(Long solicitudId, Boolean editable,Long estadoId) {
		Pagination<SolicitudLinea> lineas = SolicitudLinea.page(solicitudId);
		
		Boolean btnEliminar = (estadoId != Estado.SOLICITUD_ESTADO_APRESUPUESTO && estadoId != Estado.SOLICITUD_ESTADO_ADMINISTRACION && estadoId != Estado.SOLICITUD_ESTADO_AUTORIZADO);
				
		
		return ok(indexLineaSolicitud.render(lineas, editable,btnEliminar));
	}

	public static Result crear(String solicitudId,Long idDeposito) {
		flash().clear();
		
		Solicitud s = Solicitud.find.byId(new Long(solicitudId));
		s.deposito_id = idDeposito.intValue();
		s.save();
		
		Map<String,String> b = new HashMap<String, String>();
		b.put("solicitud_id", solicitudId);
		b.put("udm_id","1");
		b.put("precio_estimado","0");
		if(Usuario.getUsurioSesion().departamento_id != null && Usuario.getUsurioSesion().departamento_id.intValue() == 15){
			b.put("cuentaAnalitica.nombre",CuentaAnalitica.BIENES_CONSUMO_NOMBRE);
			b.put("cuenta_analitica_id",CuentaAnalitica.BIENES_CONSUMO_ID.toString());
		}else{
			b.put("cuentaAnalitica.nombre",CuentaAnalitica.FALTA_ASIGNAR_PARTIDA_NOMBRE);
			b.put("cuenta_analitica_id",CuentaAnalitica.FALTA_ASIGNAR_PARTIDA_ID.toString());
		}
		
		Form<SolicitudLinea> linea = form(SolicitudLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaProducto.render(linea,s));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			SolicitudLinea.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {		
		Form<SolicitudLinea> lineaForm = form(SolicitudLinea.class).bindFromRequest();
		
		Solicitud s = null;
		try {
			
			s = Solicitud.find.byId(lineaForm.get().solicitud_id);
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearLineaProducto.render(lineaForm,s));
			}
			
			
			
		
			SolicitudLinea linea = lineaForm.get();
			linea.create_usuario_id = (long) Usuario.getUsuarioSesion();
			linea.create_date = new Date();
			List<SolicitudLinea> lsl = SolicitudLinea.find.where().eq("producto_id",linea.producto_id).eq("solicitud_id",linea.solicitud_id).findList();
 			if(lsl.size() > 0){
				flash("error", "Ya existe una linea con este producto en la solicitud.");
				return ok(crearLineaProducto.render(lineaForm,s));
			}else{
				linea.save();
			}
			
			
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaProducto.render(lineaForm,s));
		}
		
		SolicitudLinea linea = SolicitudLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id,Long idDeposito) {
		flash().clear();
		
		SolicitudLinea linea = SolicitudLinea.find.byId(id);
		Solicitud s = Solicitud.find.byId(linea.solicitud_id);
		s.deposito_id = idDeposito.intValue();
		s.save();
		
		return ok(editarLineaProducto.render(lineaForm.fill(linea),s));
	}
	
	public static Result eliminarMasivo() {
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		SqlUpdate sqldelete = Ebean.createSqlUpdate("DELETE FROM solicitud_lineas WHERE id IN (:ids)");
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
	
	
	public static Result actualizar() {
		Form<SolicitudLinea> lineaForm = form(SolicitudLinea.class).bindFromRequest();
		Solicitud s = null;
		try {
			s = Solicitud.find.byId(lineaForm.get().solicitud_id);
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarLineaProducto.render(lineaForm,s));
			} else {
				SolicitudLinea linea = lineaForm.get();
				linea.write_usuario_id = (long) Usuario.getUsuarioSesion();
				linea.write_date = new Date();
				List<SolicitudLinea> lsl = SolicitudLinea.find.where()
						.eq("producto_id",linea.producto_id)
						.eq("solicitud_id",linea.solicitud_id)
						.ne("id",linea.id)
						.findList();
	 			if(lsl.size() > 0){
					flash("error", "Ya existe una linea con este producto en la solicitud.");
					return ok(editarLineaProducto.render(lineaForm,s));
				}else{
					linea.update();
				}
				
				
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaProducto.render(lineaForm,s));
		}
		
		SolicitudLinea linea = SolicitudLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
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
