package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;

import controllers.auth.CheckPermiso;
import models.haberes.EscalaLaboralMonto;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import views.html.haberes.escalasLaboralesMontos.*;

public class EscalasLaboralesMontosController extends Controller {
	
	final static Form<EscalaLaboralMonto> escalaLaboralMontoForm = form(EscalaLaboralMonto.class);
	
	public static Result URL_LISTA_ESCALA_LABORAL_MONTO = redirect(
			controllers.haberes.routes.EscalasLaboralesMontosController.index()
	);
	
	@CheckPermiso(key = "escalaLaboralMontoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexEscalaLaboralMonto.render(
						EscalaLaboralMonto.page(
								 RequestVar.get("liquidacion_concepto_id"),
								 RequestVar.get("activo")
								 ),
								 d));
	}
	
	@CheckPermiso(key = "escalaLaboralMontoCrear")
	public static Result crear() {
		Form<EscalaLaboralMonto> escalaLaboralMontoForm = form(EscalaLaboralMonto.class);
		return ok(crearEscalaLaboralMonto.render(escalaLaboralMontoForm));
	}
	
	@CheckPermiso(key = "escalaLaboralMontoCrear")
	public static Result guardar() {
		
		Form<EscalaLaboralMonto> escalaLaboralMontoForm = form(EscalaLaboralMonto.class).bindFromRequest();
		
		try {
			if(escalaLaboralMontoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearEscalaLaboralMonto.render(escalaLaboralMontoForm));
			} else {
				EscalaLaboralMonto lc = escalaLaboralMontoForm.get();
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El monto se ha actualizado");
				return redirect( controllers.haberes.routes.EscalasLaboralesMontosController.ver( escalaLaboralMontoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el monto");
			return badRequest(crearEscalaLaboralMonto.render(escalaLaboralMontoForm));
		}
	}
	
	@CheckPermiso(key = "escalaLaboralMontoEditar")
	public static Result editar(Long id) {
		EscalaLaboralMonto lc = Ebean.find(EscalaLaboralMonto.class, id);
		return ok(editarEscalaLaboralMonto.render(escalaLaboralMontoForm.fill(lc)));
	}
	
	@CheckPermiso(key = "escalaLaboralMontoEditar")
	public static Result actualizar(){
		
		Form<EscalaLaboralMonto> escalaLaboralMontoForm = form(EscalaLaboralMonto.class).bindFromRequest();
		
		try {
			
			if(escalaLaboralMontoForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarEscalaLaboralMonto.render(escalaLaboralMontoForm));
			} else {
				EscalaLaboralMonto lc = escalaLaboralMontoForm.get();
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El monto se ha actualizado");
				return redirect( controllers.haberes.routes.EscalasLaboralesMontosController.ver( escalaLaboralMontoForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el monto");
			return badRequest(editarEscalaLaboralMonto.render(escalaLaboralMontoForm));
		}
	}
	
	@CheckPermiso(key = "escalaLaboralMontoEliminar")
	public static Result eliminar(Long id) {
		try {
			EscalaLaboralMonto.find.byId(id).delete();
			flash("success", "Se ha eliminado el monto");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el monto");
		}

		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "escalaLaboraMontolVer")
	public static Result ver(Long id) throws IOException {
		EscalaLaboralMonto lc = EscalaLaboralMonto.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el monto");
			return URL_LISTA_ESCALA_LABORAL_MONTO;
		}
		
		return ok(verEscalaLaboralMonto.render(escalaLaboralMontoForm.fill(lc),lc));
	}
	
	
}
