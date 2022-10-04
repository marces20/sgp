package controllers.contabilidad;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.Pago;
import models.PagoLinea;
import models.Usuario;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.contabilidad.pagosLineas.crearLineaPago;
import views.html.contabilidad.pagosLineas.editarLineaPago;
import views.html.contabilidad.pagosLineas.indexPagoLinea;
import views.html.contabilidad.pagosLineas.verLineaPago;

@Security.Authenticated(Secured.class)
public class PagosLineasController extends Controller {
	
	final static Form<PagoLinea> lineaForm = form(PagoLinea.class);
	
	public static Result index(Long pagoId, Boolean editable) {
		
		Pagination<PagoLinea> lineas = PagoLinea.page(pagoId);
		Pago p = Pago.find.byId(pagoId);

		return ok(indexPagoLinea.render(lineas, editable,p));
	}
	
	public static Result crear(String pagoId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("pago_id", pagoId);
		Form<PagoLinea> linea = form(PagoLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaPago.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			PagoLinea.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<PagoLinea> lineaForm = form(PagoLinea.class).bindFromRequest();

		try {
			 
			if(
				(lineaForm.field("monto").value().isEmpty() || lineaForm.field("monto").value().compareTo("0") == 0 ) 
				&& 
				(lineaForm.field("monto_credito").value().isEmpty() || lineaForm.field("monto_credito").value().compareTo("0") == 0 )){
				flash("error", "Debe ingresar un monto a debitar o un monto a acreditar.");
				lineaForm.reject("monto","");
				lineaForm.reject("monto_credito","");
				return ok(crearLineaPago.render(lineaForm));
			}else if(
					(!lineaForm.field("monto").value().isEmpty() &&  lineaForm.field("monto").value().compareTo("0") != 0)
					&&
					(!lineaForm.field("monto_credito").value().isEmpty() &&  lineaForm.field("monto_credito").value().compareTo("0") != 0)){
				flash("error", "Debe ingresar un monto a debitar o un monto a acreditar.");
				lineaForm.reject("monto","");
				lineaForm.reject("monto_credito","");
				return ok(crearLineaPago.render(lineaForm));
			}
			
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(crearLineaPago.render(lineaForm));
			} else {
				PagoLinea p = lineaForm.get();
				p.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.monto = (p.monto == null)?new BigDecimal(0):p.monto;
				p.monto_credito = (p.monto_credito == null)?new BigDecimal(0):p.monto_credito;
				p.monto_original = (p.monto_original == null)?new BigDecimal(0):p.monto_original;
				p.create_date = new Date();
				p.save();
				
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaPago.render(lineaForm));
		}
		
		PagoLinea linea = PagoLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		
		Object c = verLineaPago.render(linea,linea.pago);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result editar(Long id) {
		flash().clear();
		PagoLinea linea = PagoLinea.find.byId(id);
		return ok(editarLineaPago.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {
		
		Form<PagoLinea> lineaForm = form(PagoLinea.class).bindFromRequest();
		
		try {
			
			if(
				(lineaForm.field("monto").value().isEmpty() || lineaForm.field("monto").value().compareTo("0") == 0 ) 
					&& 
					(lineaForm.field("monto_credito").value().isEmpty() || lineaForm.field("monto_credito").value().compareTo("0") == 0 )){
					flash("error", "Debe ingresar un monto a debitar o un monto a acreditar.");
					lineaForm.reject("monto","");
					lineaForm.reject("monto_credito","");
					return ok(crearLineaPago.render(lineaForm));
				}else if(
						(!lineaForm.field("monto").value().isEmpty() &&  lineaForm.field("monto").value().compareTo("0") != 0)
						&&
						(!lineaForm.field("monto_credito").value().isEmpty() &&  lineaForm.field("monto_credito").value().compareTo("0") != 0)){
					flash("error", "Debe ingresar un monto a debitar o un monto a acreditar.");
					lineaForm.reject("monto","");
					lineaForm.reject("monto_credito","");
					return ok(crearLineaPago.render(lineaForm));
				}
			
			if(lineaForm.hasErrors()) {
				
				flash("error", "Error en formulario");
				return ok(editarLineaPago.render(lineaForm));
			} else {
				PagoLinea p = lineaForm.get();
				p.monto = (p.monto == null)?new BigDecimal(0):p.monto;
				p.monto_credito = (p.monto_credito == null)?new BigDecimal(0):p.monto_credito;
				p.monto_original = (p.monto_original == null)?new BigDecimal(0):p.monto_original;
				p.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				p.write_date = new Date();
				p.update();
				
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaPago.render(lineaForm));
		}
		
		PagoLinea linea = PagoLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaPago.render(linea,linea.pago);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
