package controllers.compras;

import static play.data.Form.form;

import java.math.BigDecimal;
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

import models.BalancePresupuestario;
import models.CertificacionCompra;
import models.CertificacionCompraLinea;
import models.CertificacionesComprasLineaAjustes;
import models.Usuario;
import controllers.Secured;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.compras.lineaAjustesCertificacionesCompras.*; 
import views.html.compras.lineasAjustesOrdenes.crearLineaAjuste;

@Security.Authenticated(Secured.class)
public class CertificacionesComprasLineaAjustesController extends Controller {
	
	final static Form<CertificacionesComprasLineaAjustes> lineaForm = form(CertificacionesComprasLineaAjustes.class);
	
	public static Result index(Long certificacionId, Boolean editable) {
		
		Pagination<CertificacionesComprasLineaAjustes> lineas = CertificacionesComprasLineaAjustes.page(certificacionId);
		CertificacionCompra c = CertificacionCompra.find.byId(certificacionId);
		return ok(indexCertificacionLinea.render(lineas, editable,c));
	}
	
	public static Result crear(String certificacionId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("certificacion_compra_id", certificacionId);
		Form<CertificacionesComprasLineaAjustes> linea = form(CertificacionesComprasLineaAjustes.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaProducto.render(linea));
	}
	
	public static Result guardar() {
		Form<CertificacionesComprasLineaAjustes> lineaForm = form(CertificacionesComprasLineaAjustes.class).bindFromRequest();
		String aviso = "";
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario "+lineaForm.errors());
				return ok(crearLineaProducto.render(lineaForm));
			} else {
				
				CertificacionesComprasLineaAjustes l = lineaForm.get();
				
				
				if(!soloCuentasAnliticasHijasPorCuenta(l.cuenta_analitica_id)){
					flash("error", "Las cuentas presupuestarias deben ser Hijas unicamente.");
					return ok(crearLineaProducto.render(lineaForm));
				}
				
				
				CertificacionCompra o = CertificacionCompra.find.byId(l.certificacion_compra_id);
				ArrayNode a = BalancePresupuestario.controlSaldoPreventivoCertificacionCompraLineaAjuste(o,l);
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
						return ok(crearLineaProducto.render(lineaForm));
					}else{
						aviso += "Tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
						aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
						aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
						aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
					}
				}
				
				if(!errorControl){
					l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					l.create_date = new Date();
					l.save();
					flash("success", "El registro se almacenó correctamente.");
				}	
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaProducto.render(lineaForm));
		}
		
		CertificacionesComprasLineaAjustes linea = CertificacionesComprasLineaAjustes.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("message", aviso);
		restJs.put("html", c.toString());
		return ok(restJs);

	}
	
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			CertificacionesComprasLineaAjustes.find.byId(id).delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result editar(Long id) {
		flash().clear();
		CertificacionesComprasLineaAjustes linea = CertificacionesComprasLineaAjustes.find.byId(id);
		return ok(editarLineaProducto.render(lineaForm.fill(linea)));
	}
	
	public static Result actualizar() {

		Form<CertificacionesComprasLineaAjustes> lineaForm = form(CertificacionesComprasLineaAjustes.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaProducto.render(lineaForm));
			} else {
				CertificacionesComprasLineaAjustes fl = lineaForm.get();
				CertificacionesComprasLineaAjustes l = lineaForm.get();
				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.update(fl.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaProducto.render(lineaForm));
		}
		
		CertificacionesComprasLineaAjustes linea = CertificacionesComprasLineaAjustes.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaProducto.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
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
