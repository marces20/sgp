package controllers.compras;
import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.CajaChica;
import models.CajaChicaMovimiento;
import models.CajaChicaPresupuestoLinea;
import models.CuentaAnalitica;
import models.Estado;
import models.Usuario;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.compras.cajaChica.presupuestoLineas.*;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class CajaChicaPresupuestoLineasController extends Controller {

	final static Form<CajaChicaPresupuestoLinea> movimientosForm = form(CajaChicaPresupuestoLinea.class);
	
	@CheckPermiso(key = "cajaChicaVer")
	public static Result lista(Long cajaId, Boolean editable) {		
		List<CajaChicaPresupuestoLinea> movimientos = CajaChicaPresupuestoLinea.find.where().eq("caja_chica_id", cajaId).findList();
		return ok( listaPresupuestoLineas.render(movimientos, editable) );
	}
	
	@CheckPermiso(key = "cajaChicaCrear")
	public static Result crear(String cajaId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("caja_chica_id", cajaId);
		Form<CajaChicaPresupuestoLinea> linea = form(CajaChicaPresupuestoLinea.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaPresupuesto.render(linea));
	}	
	
	@CheckPermiso(key = "cajaChicaCrear")
	public static Result guardar() {
		
		Form<CajaChicaPresupuestoLinea> lineaForm = form(CajaChicaPresupuestoLinea.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearLineaPresupuesto.render(lineaForm));
			} else {
				CajaChicaPresupuestoLinea l = lineaForm.get();
				CajaChica cc = CajaChica.find.byId(l.caja_chica_id.longValue());
				
				if(cc.estado_id != Estado.CAJA_CHICA_BORRADOR && cc.estado_id != Estado.CAJA_CHICA_ABIERTA) {
					flash("error", "Solo se puede agregar lineas en estado BORRADOR o ABIERTA.");
					return ok(crearLineaPresupuesto.render(lineaForm));
				}
				
				if(CuentaAnalitica.isCuentasAnliticasHijas(l.cuenta_analitica_id.longValue())){
					flash("error", "Las cuentas presupuestarias no deben ser Hija.");
					return ok(crearLineaPresupuesto.render(lineaForm));
				}
				
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.ajuste = (cc.estado_id == Estado.CAJA_CHICA_BORRADOR)?false:true;
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearLineaPresupuesto.render(lineaForm));
		}
		
		CajaChicaPresupuestoLinea linea = CajaChicaPresupuestoLinea.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = lineaPresupuesto.render(linea, true);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
		
	}
	
	
}
