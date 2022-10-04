package controllers.patrimonio;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.CertificacionServicio;
import models.CertificacionServicioLinea;
import models.CertificacionServicioLineaCliente;
import models.FacturaLinea;
import models.Orden;
import models.OrdenLinea;
import models.Usuario;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.patrimonio.certificaciones.modalAgregarConClientes;
import views.html.patrimonio.lineasCertificaciones.*;

@Security.Authenticated(Secured.class)
public class LineasCertificacionesController extends Controller {
	
	final static Form<CertificacionServicioLinea> lineaForm = form(CertificacionServicioLinea.class);
	
	public static Result index(Long facturaId, Boolean editable) {
		
		Pagination<CertificacionServicioLinea> lineas = CertificacionServicioLinea.page(facturaId);

		return ok(indexCertificacionLinea.render(lineas, editable));
	}
	
	public static Result getListaLineasPacientes(Long certificacionId) {
		ObjectNode restJs = Json.newObject();
		
		CertificacionServicio cs = CertificacionServicio.find.byId(certificacionId);
		
		Object c = listaLineasPacientes.render(cs.certificacionesServicioLinea);
		
		restJs.put("html", c.toString());
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result crear(String certificacionId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("certificaciones_servicio_id", certificacionId);
		Form<CertificacionServicioLinea> linea = form(CertificacionServicioLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaProducto.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			CertificacionServicioLinea cl = CertificacionServicioLinea.find.byId(id);
			cl.delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<CertificacionServicioLinea> lineaForm = form(CertificacionServicioLinea.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				System.out.println(lineaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearLineaProducto.render(lineaForm));
			} else {
				CertificacionServicioLinea l = lineaForm.get();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro."+e);
			return ok(crearLineaProducto.render(lineaForm));
		}
		
		CertificacionServicioLinea linea = CertificacionServicioLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id) {
		flash().clear();
		CertificacionServicioLinea linea = CertificacionServicioLinea.find.byId(id);
		return ok(editarLineaProducto.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<CertificacionServicioLinea> lineaForm = form(CertificacionServicioLinea.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaProducto.render(lineaForm));
			} else {
				CertificacionServicioLinea fl = lineaForm.get();
				
				OrdenLinea ol =  OrdenLinea.find.byId(fl.linea_orden_id);  
				if(ol != null) {
					if(fl.cantidad.compareTo(ol.cantidad) >0) {
						flash("error", "La cantidad cargada supera la cantidad de la linea original");
						return ok(editarLineaProducto.render(lineaForm));
					}else {
						
						List<CertificacionServicioLineaCliente> cc = CertificacionServicioLineaCliente.find.where().eq("certificaciones_servicios_linea_id", fl.id).findList();
						if(cc.size() > 0) {
							BigDecimal cantidadEnPacientes = BigDecimal.ZERO;
							
							for(CertificacionServicioLineaCliente ccx:cc) {
								cantidadEnPacientes = cantidadEnPacientes.add(ccx.cantidad);
							}
							
							if(fl.cantidad.compareTo(cantidadEnPacientes) != 0) {
								flash("error", "La cantidad es diferente a la cantidad total de cargada en los pacientes.");
								return ok(editarLineaProducto.render(lineaForm));
							}
						}
					}
				}
				
				
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaProducto.render(lineaForm));
		}
		
		CertificacionServicioLinea linea = CertificacionServicioLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
