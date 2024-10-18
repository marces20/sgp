package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;
import java.util.List;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;

import controllers.auth.CheckPermiso;
import models.Estado;
import models.auth.Permiso;
import models.haberes.LiquidacionEmbargo;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.haberes.liquidacionEmbargos.*;

public class LiquidacionEmbargosController extends Controller {

	final static Form<LiquidacionEmbargo> embargoForm = form(LiquidacionEmbargo.class);

	public static Result URL_LISTA_EMBARGO = redirect(
			controllers.haberes.routes.LiquidacionEmbargosController.index()
	);

	@CheckPermiso(key = "liquidacionEmbargoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexLiquidacionEmbargo.render(LiquidacionEmbargo.page(
																RequestVar.get("puesto_laboral_id"),
																RequestVar.get("btnFiltro[0]"),//
																RequestVar.get("btnFiltro[1]"),//
																RequestVar.get("btnFiltro[2]"),
																RequestVar.get("cm")

																),d));

	}

	@CheckPermiso(key = "liquidacionEmbargoCrear")
	public static Result crear() {
		Form<LiquidacionEmbargo> liquidacionEmbargoForm = form(LiquidacionEmbargo.class);
		return ok(crearLiquidacionEmbargo.render(liquidacionEmbargoForm));
	}

	@CheckPermiso(key = "liquidacionEmbargoCrear")
	public static Result guardar() {

		Form<LiquidacionEmbargo> liquidacionEmbargoForm = form(LiquidacionEmbargo.class).bindFromRequest();

		try {
			if(liquidacionEmbargoForm.hasErrors()) {
				flash("error", "Error en formulario "+liquidacionEmbargoForm.errors());
				return badRequest(crearLiquidacionEmbargo.render(liquidacionEmbargoForm));
			} else {
				LiquidacionEmbargo lc = liquidacionEmbargoForm.get();



				lc.estado_id = (long) Estado.LIQUIDACION_EMBARGO_BORRADOR;

				lc.save();
				flash("success", "El embargo se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionEmbargosController.ver( liquidacionEmbargoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el embargo");
			return badRequest(crearLiquidacionEmbargo.render(liquidacionEmbargoForm));
		}
	}

	@CheckPermiso(key = "liquidacionEmbargoEditar")
	public static Result editar(Long id) {
		LiquidacionEmbargo lc = Ebean.find(LiquidacionEmbargo.class, id);
		return ok(editarLiquidacionEmbargo.render(embargoForm.fill(lc)));
	}

	@CheckPermiso(key = "liquidacionEmbargoEditar")
	public static Result actualizar(){

		Form<LiquidacionEmbargo> liquidacionEmbargoForm = form(LiquidacionEmbargo.class).bindFromRequest();

		try {

			if(liquidacionEmbargoForm.hasErrors()) {
				flash("error", "Error en formulario"+ liquidacionEmbargoForm.errors());
				return badRequest(editarLiquidacionEmbargo.render(liquidacionEmbargoForm));
			} else {
				LiquidacionEmbargo lc = liquidacionEmbargoForm.get();




				lc.update();
				flash("success", "El embargo se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionEmbargosController.ver( liquidacionEmbargoForm.get().id ) + UriTrack.get("&"));
			}

		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el embargo");
			return badRequest(editarLiquidacionEmbargo.render(liquidacionEmbargoForm));
		}
	}

	@CheckPermiso(key = "liquidacionEmbargoEliminar")
	public static Result eliminar(Long id) {
		try {
			LiquidacionEmbargo.find.byId(id).delete();
			flash("success", "Se ha eliminado el embargo");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el embargo");
		}

		return redirect(request().getHeader("referer"));
	}

	@CheckPermiso(key = "liquidacionEmbargoVer")
	public static Result ver(Long id) throws IOException {
		LiquidacionEmbargo lc = LiquidacionEmbargo.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el embargo.");
			return URL_LISTA_EMBARGO;
		}

		return ok(verLiquidacionEmbargo.render(embargoForm.fill(lc),lc));
	}

	public static Result cambiarEstado(Long idEmbargo, Long idEstado) throws IOException{

		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_LIQUIDACION_EMBARGO);
		LiquidacionEmbargo p = LiquidacionEmbargo.find.where().eq("id", idEmbargo).findUnique();

		if(p == null){
			flash("error", "No se encuentra el embargo.");
			return redirect(request().getHeader("referer"));
		}

		if(idEstado != null){

			Boolean permiso = false;

			switch ( idEstado.intValue() ) {
		      case  Estado.LIQUIDACION_EMBARGO_BORRADOR:
		    	  if(!Permiso.check("liquidacionEmbargoPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(p.id);
		    	  break;

		      case Estado.LIQUIDACION_EMBARGO_APROBADO:
		    	  if(!Permiso.check("liquidacionEmbargoPasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobado(p.id);
		    	  break;
		      case Estado.LIQUIDACION_EMBARGO_CANCELADO:
		    	  if(!Permiso.check("liquidacionEmbargoPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(p.id);
		          break;
		      default:
		           break;
		      }

		}

		return redirect(controllers.haberes.routes.LiquidacionEmbargosController.ver(p.id)+ UriTrack.get("&"));
	}

	@CheckPermiso(key = "liquidacionEmbargoPasarBorrador")
	public static void pasarEnBorrador(Long id){

		LiquidacionEmbargo p = Ebean.find(LiquidacionEmbargo.class).select("id, estado_id").setId(id).findUnique();

		if(p != null){
			p.estado_id = new Long(Estado.LIQUIDACION_EMBARGO_BORRADOR);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}

	@CheckPermiso(key = "liquidacionEmbargoPasarControlado")
	public static void pasarAprobado(Long id){

		LiquidacionEmbargo p = Ebean.find(LiquidacionEmbargo.class).select("id, estado_id").setId(id).findUnique();

		if(p != null){
			p.estado_id = new Long(Estado.LIQUIDACION_EMBARGO_APROBADO);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Controlado");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}

	@CheckPermiso(key = "liquidacionEmbargoPasarCancelado")
	public static void pasarCancelado(Long id){

		LiquidacionEmbargo p = Ebean.find(LiquidacionEmbargo.class).select("id, estado_id").setId(id).findUnique();

		if(p != null){
			p.estado_id = new Long(Estado.LIQUIDACION_EMBARGO_CANCELADO);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}

}
