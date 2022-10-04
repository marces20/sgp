package controllers.dashboard;

import static play.data.Form.form;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import models.Ejercicio;
import models.UltimaCotizacion;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import views.html.compras.productos.crearTipoProducto;
import views.html.dashboard.ultimasCotizaciones.*;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class UltimasCotizacionesController extends Controller {
	
	final static Form<UltimaCotizacion> ultimaCotizacionesForm = form(UltimaCotizacion.class);
	
	public static Result URL_LISTA_COTIZACIONES = redirect(
			controllers.dashboard.routes.UltimasCotizacionesController.indexUltimaCotizaciones()
	);
	
	@CheckPermiso(key = "ultimaCotizaciones")
	public static Result indexUltimaCotizaciones() {
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		return ok(
				indexUltimaCotizaciones.render(
						UltimaCotizacion.page(RequestVar.get("fecha_desde"),RequestVar.get("fecha_hasta")),d,pf));
	}
	
	@CheckPermiso(key = "ultimaCotizacionesCrear")
	public static Result crearUltimaCotizaciones() {
		Form<UltimaCotizacion> tipoProductoForm = form(UltimaCotizacion.class);
		return ok(crearUltimaCotizaciones.render(ultimaCotizacionesForm));
	}
	
	@CheckPermiso(key = "ultimaCotizacionesCrear")
	public static Result guardarUltimaCotizaciones() {
		
		Form<UltimaCotizacion> ultimaCotizacionesForm = form(UltimaCotizacion.class).bindFromRequest();
		
		try {
			if(ultimaCotizacionesForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearUltimaCotizaciones.render(ultimaCotizacionesForm));
			} else {
				
				
				UltimaCotizacion t = ultimaCotizacionesForm.get();
				
				List<UltimaCotizacion> tl = UltimaCotizacion.find.where().eq("tipo_moneda",t.tipo_moneda).eq("fecha", t.fecha).findList();
				if(tl.size() > 0){
					flash("error", "Ya existe una cotizacion en esta fecha de esta moneda.");
					return badRequest(crearUltimaCotizaciones.render(ultimaCotizacionesForm));
				}
				
				t.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				t.create_date = new Date();
				Ejercicio e = Ejercicio.getEjercicioByFecha(t.fecha);
				t.ejercicio_id = e.id;
				t.save();
				
				flash("success", "La cotizacion se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la cotizaciones");
			return badRequest(crearUltimaCotizaciones.render(ultimaCotizacionesForm));
		}
		
		return URL_LISTA_COTIZACIONES;
	}
	
	@CheckPermiso(key = "ultimaCotizacionesEliminar")
	public static Result eliminar(Long id) {
		try {
			UltimaCotizacion.find.byId(id).delete();
			flash("success", "Se ha eliminado la cotizacion");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la cotizacion");
		}

		return URL_LISTA_COTIZACIONES;
	}
	
	
}
