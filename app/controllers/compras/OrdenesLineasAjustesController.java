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
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

import models.BalancePresupuestario;
import models.Ejercicio;
import models.Orden;
import models.OrdenLineaAjuste;
import models.Solicitud;
import models.SolicitudLineaAjuste;
import models.Usuario;
import models.auth.Permiso;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.lineasAjustesOrdenes.*;

@Security.Authenticated(Secured.class)
public class OrdenesLineasAjustesController extends Controller {
	
	final static Form<OrdenLineaAjuste> lineaForm = form(OrdenLineaAjuste.class);
	
	public static Result index(Long ordenId, Boolean editable) {
		Orden orden = Orden.find.byId(ordenId);
		Pagination<OrdenLineaAjuste> lineas = OrdenLineaAjuste.page(ordenId);
		
		return ok(indexLineaAjuste.render(lineas, editable,orden));
	}
	
	public static Result crear(String ordenId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("orden_id", ordenId);
		Form<OrdenLineaAjuste> linea = form(OrdenLineaAjuste.class).bind(b);
		linea.discardErrors();
		OrdenLineaAjuste o =  new OrdenLineaAjuste();
		return ok(crearLineaAjuste.render(linea,o));
	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			OrdenLineaAjuste.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result guardar() {
		Form<OrdenLineaAjuste> lineaForm = form(OrdenLineaAjuste.class).bindFromRequest();
		OrdenLineaAjuste ola = new OrdenLineaAjuste();
		String aviso = "";
		if(lineaForm.hasErrors()) {
			flash("error", "Error en formulario ");
			return ok(crearLineaAjuste.render(lineaForm,ola));
		}
		
		try {
			OrdenLineaAjuste s = lineaForm.get();
			Orden o = Orden.find.byId(s.orden_id);
			Ejercicio ejercicioActual  = Ejercicio.getEjercicioByFecha(new Date());
			
			if(!Permiso.check("ordenesAjustesAnoNoCorriente") && o.expediente.ejercicio_id.compareTo(ejercicioActual.id) != 0){
				flash("error", "Solo tiene permisos para hacer ajustes del año corriente.");
				return ok(crearLineaAjuste.render(lineaForm,ola));
			}
			
			if(!soloCuentasAnliticasHijasPorCuenta(s.cuenta_analitica_id)){
				flash("error", "Las cuentas presupuestarias deben ser Hijas unicamente.");
				return ok(crearLineaAjuste.render(lineaForm,s));
			}
			
			
			
			ArrayNode a = BalancePresupuestario.controlSaldoPreventivoOrdenLineaAjuste(o,s);
			
			boolean errorControl =  false;
			
			for(JsonNode x :a){
				boolean success = new Boolean(x.get("success").toString());
				String cuenta = x.get("cuenta").toString();
				String expediente = x.get("expediente").toString();
				BigDecimal saldoDisponible =  new BigDecimal(x.get("saldoDisponible").toString());
				BigDecimal saldoAImputar =  new BigDecimal(x.get("saldoAImputar").toString());
				BigDecimal saldoPresente =  new BigDecimal(x.get("saldoPresente").toString());
				
				if(!success){
					errorControl =  true;
					aviso += "No tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
					aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
					aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
					aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
					flash("error", aviso);
					return ok(crearLineaAjuste.render(lineaForm,s));
				}else{
					aviso += "Tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
					aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
					aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
					aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
				}
			}
			
			if(!errorControl){
				s.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				s.create_date = new Date();
				s.ajuste_automatico = false;
				s.save();
			}
			
			
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaAjuste.render(lineaForm,ola));
		}
		
		
		OrdenLineaAjuste linea = OrdenLineaAjuste.find.where().eq("id", lineaForm.get().id).findUnique();
		Orden orden = Orden.find.byId(linea.orden_id);
		Object c = verLineaAjuste.render(linea,orden);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("message", aviso);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	public static Boolean soloCuentasAnliticasHijasPorCuenta(Long idCuenta) {
		boolean r = true;
		
		String sql = "SELECT parent_id FROM cuentas_analiticas WHERE parent_id = :idCuenta  ";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("idCuenta",idCuenta)		
				.findList();
		
		if(s.size() > 0){
			r = false;
		}
		
		return r;
	}
}
