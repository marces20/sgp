package controllers.compras;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.CajaChica;
import models.CajaChicaMovimiento;
import models.CuentaAnalitica;
import models.Estado;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.compras.cajaChica.movimientos.*;

@Security.Authenticated(Secured.class)
public class CajaChicaMovimientosController extends Controller {
	
	final static Form<CajaChicaMovimiento> movimientosForm = form(CajaChicaMovimiento.class);

	
	@CheckPermiso(key = "cajaChicaVer")
	public static Result lista(Long cajaId, Boolean editable) {		
		List<CajaChicaMovimiento> movimientos = CajaChicaMovimiento.find
												.fetch("cuentaAnalitica")
								    			.fetch("proveedor")
								    			.fetch("udm")
								    			.fetch("caja")
								    			.fetch("create_usuario")
								    			.fetch("producto")
								    			.where().eq("caja_chica_id", cajaId).orderBy("fecha ASC").findList();
		CajaChica cc = CajaChica.find.byId(cajaId);
		return ok( listaMovimientos.render(movimientos, editable,cc) );
	}
	
	@CheckPermiso(key = "cajaChicaCrear")
	public static Result crear(String cajaId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("caja_chica_id", cajaId);
		Form<CajaChicaMovimiento> linea = form(CajaChicaMovimiento.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaMovimiento.render(linea));
	}
	
	@CheckPermiso(key = "cajaChicaCrear")
	public static Result guardar() {
		
		Form<CajaChicaMovimiento> lineaForm = form(CajaChicaMovimiento.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearLineaMovimiento.render(lineaForm));
			} else {
				CajaChicaMovimiento l = lineaForm.get();
				
				if(!CuentaAnalitica.isCuentasAnliticasHijas(l.cuenta_analitica_id.longValue())){
					flash("error", "Las cuentas presupuestarias deben ser Hija.");
					return ok(crearLineaMovimiento.render(lineaForm));
				}
				
				CajaChica cc = CajaChica.find.byId((long) l.caja_chica_id);
				
				if(cc.estado_id.compareTo((long) Estado.CAJA_CHICA_ABIERTA) != 0) {
					flash("error", "La Caja Chica debe estar estado ABIERTA.");
					return ok(crearLineaMovimiento.render(lineaForm));
				}
				
				if(cc.monto_limite.compareTo( cc.getTotal().add(l.getTotal())) == -1 )  {
					flash("error", "El total de movimiento supera el monto límite de la caja chica");
					return ok(crearLineaMovimiento.render(lineaForm));
				}	
				
				
				
				
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaMovimiento.render(lineaForm));
		}
		
		CajaChicaMovimiento linea = CajaChicaMovimiento.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = lineaMovimiento.render(linea, true,BigDecimal.ZERO);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
		
	}
	
	@CheckPermiso(key = "cajaChicaModificar")
	public static Result editar(Long id) {
		flash().clear();
		CajaChicaMovimiento linea = CajaChicaMovimiento.find.byId(id);
		return ok(editarLineaMovimiento.render(movimientosForm.fill(linea)));
	}
	
	@CheckPermiso(key = "cajaChicaModificar")
	public static Result actualizar() {

		Form<CajaChicaMovimiento> lineaForm = form(CajaChicaMovimiento.class).bindFromRequest();
		
		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaMovimiento.render(lineaForm));
			} else {
				CajaChicaMovimiento c = lineaForm.get();
				
				CajaChica cc = CajaChica.find.byId((long) c.caja_chica_id);
				CajaChicaMovimiento cmaux = CajaChicaMovimiento.find.byId(c.id);
				
				System.out.println("++++ " + cc.monto_limite.compareTo( cc.getTotal().subtract(cmaux.getTotal()).add(c.getTotal())));
				
				if(cc.monto_limite.compareTo( cc.getTotal().subtract(cmaux.getTotal()).add(c.getTotal())) == -1 )  {
					flash("error", "El total de movimiento supera el monto límite de la caja chica");
					return ok(editarLineaMovimiento.render(lineaForm));
				}	
				
				
				c.update(c.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido modificar el registro.");
			return ok(editarLineaMovimiento.render(lineaForm));
		}
		
		CajaChicaMovimiento linea = CajaChicaMovimiento.find.byId(lineaForm.get().id);
		Object c = lineaMovimiento.render(linea, true,BigDecimal.ZERO);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
	
	@CheckPermiso(key = "cajaChicaModificar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		
		
		CajaChicaMovimiento c = CajaChicaMovimiento.find.byId(id);
		
		if(c.caja.estado_id == Estado.CAJA_CHICA_ABIERTA){
		
			try {
				c.delete();
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				restJs.put("messagge", "No se puedo eliminar el registro.");
				restJs.put("success", false);
			}
			restJs.put("success", true);
		
		} else {
			restJs.put("messagge", "Para eliminar debe estar la caja chica en estado abierta.");
			restJs.put("error", false);
			
		}
		
		return ok(restJs);
	}
	
}
