package controllers.contabilidad;

import static play.data.Form.form;

import javax.persistence.PersistenceException;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Factura;
import models.MiPago;
import models.OrdenPago;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NoRecordModelException;
import utils.RequestVar;
import utils.UriTrack;
import views.html.contabilidad.misPagos.editarMiPago;
import views.html.contabilidad.misPagos.indexMiPago;
import views.html.contabilidad.misPagos.verMiPago;

@Security.Authenticated(Secured.class)
public class MisPagosController  extends Controller {
	
	final static Form<MiPago> miPagoForm = form(MiPago.class);
	
	public static Result URL_INDEX_MIS_PAGOS = redirect(
			controllers.contabilidad.routes.MisPagosController.index()  + UriTrack.get("&")
	);
	
	@CheckPermiso(key = "misPagosVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexMiPago.render(MiPago.page(RequestVar.get("tipo"),
												 RequestVar.get("fecha_desde"),
												 RequestVar.get("fecha_hasta"),
												 RequestVar.get("referencia"),
												 RequestVar.get("ordenPago.id")
												 ), d));
	}
	
	@CheckPermiso(key = "misPagosEditar")
	public static Result editar(Long id) {
		MiPago miPago;
		try {
			miPago = loadModel(id);
		} catch (NoRecordModelException e) {
			return URL_INDEX_MIS_PAGOS;
		}
		
		return ok(editarMiPago.render(miPagoForm.fill(miPago),miPago));
	}
	
	@CheckPermiso(key = "misPagosEditar")
	public static Result actualizar(Long id){
		MiPago miPago = null;
		
		try {
			Form<MiPago> miPagoForm = form(MiPago.class).bindFromRequest();
			miPago = loadModel(id);
			
			if(miPagoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarMiPago.render(miPagoForm, miPago));
			}
			
			miPagoForm.get().update();
			flash("success", "El pago se ha actualizado");
			return redirect( controllers.contabilidad.routes.MisPagosController.ver( id ) + UriTrack.get("&"));
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el pago.");
			return badRequest(editarMiPago.render(miPagoForm, miPago));
		} catch (NoRecordModelException e) {
			return URL_INDEX_MIS_PAGOS;
		}

	}
	
	@CheckPermiso(key = "misPagosVer")
	public static Result ver(Long id) {

		MiPago miPago = null;

		try {
			miPago = loadModel(id);
			 
		} catch (NoRecordModelException e) {
			return URL_INDEX_MIS_PAGOS;
		}

		return ok(verMiPago.render(miPagoForm.fill(miPago),miPago));
	}
	
	private static MiPago loadModel(Long id) throws NoRecordModelException {
		MiPago miPago = MiPago.find.byId(id);
		
		if (miPago == null) {
			flash("error", "El pago solicitado ya no existe.");
			throw new NoRecordModelException();
		}
		return miPago;
	}
}
