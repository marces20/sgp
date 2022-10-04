package controllers.compras;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.Secured;
import models.BalancePresupuestario;
import models.CuentaAnalitica;
import models.Ejercicio;
import models.Solicitud;
import models.SolicitudLineaAjuste;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.lineasSolicitudes.crearLineaAjuste;
import views.html.compras.lineasSolicitudes.crearLineaProducto;
import views.html.compras.lineasSolicitudes.indexLineaAjuste;
import views.html.compras.lineasSolicitudes.verLineaAjuste;

@Security.Authenticated(Secured.class)
public class AjustesSolicitudesController extends Controller {
	
	final static Form<SolicitudLineaAjuste> lineaForm = form(SolicitudLineaAjuste.class);
	
	public static Result index(Long solicitudId, Boolean editable) {
		Solicitud solicitud = Solicitud.find.byId(solicitudId);
		Pagination<SolicitudLineaAjuste> lineas = SolicitudLineaAjuste.page(solicitudId);
		
		return ok(indexLineaAjuste.render(lineas, editable,solicitud));
	}
	
	public static Result crear(String solicitudId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("solicitud_id", solicitudId);
		Form<SolicitudLineaAjuste> linea = form(SolicitudLineaAjuste.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaAjuste.render(linea));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			SolicitudLineaAjuste.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<SolicitudLineaAjuste> lineaForm = form(SolicitudLineaAjuste.class).bindFromRequest();

		if(lineaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(crearLineaAjuste.render(lineaForm));
		}
		
		SolicitudLineaAjuste s = lineaForm.get();
		
		Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxx");
		if(CuentaAnalitica.isCuentasAnliticasHijas(s.cuenta_analitica_id.longValue())){
			flash("error", "Las cuentas presupuestarias no deben ser Hija.");
			return ok(crearLineaAjuste.render(lineaForm));
		}
		
		Solicitud solicitud = Solicitud.find.byId(s.solicitud_id);
		CuentaAnalitica sx = CuentaAnalitica.find.byId(s.cuenta_analitica_id.longValue());
		
		BigDecimal saldoCuenta = BalancePresupuestario.getSaldoPresupuestarioPorCuenta(s.cuenta_analitica_id,solicitud.expediente.ejercicio_id.intValue());
		BigDecimal saldoAImputar = s.precio.multiply(s.cantidad); 
		BigDecimal saldoPresente = saldoCuenta.subtract(saldoAImputar);
		
		String aviso = "";
		boolean errorControl =  false;
		if(saldoCuenta.compareTo(saldoAImputar) < 0){
			errorControl =  true;
			aviso += "No tiene Saldo disponible para la cuenta "+sx.nombre+"<br>";
			aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoCuenta)+"<br>";
			aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
			aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			
			flash("error", aviso);
			return ok(crearLineaAjuste.render(lineaForm));
		}
		
		Ejercicio ejercicioActual  = Ejercicio.getEjercicioByFecha(new Date());
		if(!Permiso.check("ordenesAjustesAnoNoCorriente") && solicitud.expediente.ejercicio_id.compareTo(ejercicioActual.id) != 0){
			flash("error", "Solo tiene permisos para hacer ajustes del año corriente.");
			return ok(crearLineaAjuste.render(lineaForm));
		}
		
		try {
			
			s.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			s.create_date = new Date();
			s.save();
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaAjuste.render(lineaForm));
		}
		
		
		
		
		SolicitudLineaAjuste linea = SolicitudLineaAjuste.find.where().eq("id", lineaForm.get().id).findUnique();
		solicitud = Solicitud.find.byId(linea.solicitud_id);
		Object c = verLineaAjuste.render(linea,solicitud);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

}
