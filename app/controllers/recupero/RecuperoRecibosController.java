package controllers.recupero;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Estado;
import models.Expediente;
import models.Usuario;
import models.auth.Permiso;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoPago;
import models.recupero.RecuperoPlanilla;
import models.recupero.RecuperoRecibo;
import models.recupero.RecuperoReciboFactura;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.recupero.recuperoRecibo.*;

@Security.Authenticated(Secured.class)
public class RecuperoRecibosController extends Controller {

	/*
	 * 1- Control pasar a Aprobado Recibo
	 * 2- Control cargar factura-Recibo (DEEEUDA) POR FACTURA=???
	 * 3- GENERACION DE PAGOS DESDE FACTURAS SEGUN TIPO DE PAGO
	 * 4- Generacion automaticco de numero de recibos
	 *
	 * */


	final static Form<RecuperoRecibo> reciboForm = form(RecuperoRecibo.class);

	public static Result URL_LISTA_RECIBO = redirect(
			controllers.recupero.routes.RecuperoRecibosController.index()
	);

	@CheckPermiso(key = "reciboVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexRecibo.render(
											RecuperoRecibo.page(
												  		RequestVar.get("numero"),
												  		RequestVar.get("expediente_id"),
												  		RequestVar.get("fecha_desde"),
												  		RequestVar.get("fecha_hasta")
												  		),d));
	}

	@CheckPermiso(key = "reciboVer")
	public static Result ver(Long id) {
		RecuperoRecibo p = RecuperoRecibo.find.byId(id);
		if(p != null){



			Form<RecuperoRecibo> reciboForm = form(RecuperoRecibo.class).fill(p);
			return ok(verRecibo.render(reciboForm, p));
		}else{
			flash("error", "No se encuentra el recibo");
			return redirect(controllers.recupero.routes.RecuperoRecibosController.index()+UriTrack.get("?"));
		}
	}

	@CheckPermiso(key = "reciboCrear")
	public static Result crear() {

		Map<String,String> p = new HashMap<String, String>();

		Form<RecuperoRecibo> reciboForm = form(RecuperoRecibo.class).bind(p);
		reciboForm.discardErrors();

		return ok(crearRecibo.render(reciboForm));
	}

	@CheckPermiso(key = "reciboCrear")
	public static Result guardar() {

		Form<RecuperoRecibo> reciboForm = form(RecuperoRecibo.class).bindFromRequest();

		if(reciboForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearRecibo.render(reciboForm));
		}

		try {

			RecuperoRecibo c = reciboForm.get();

			List<RecuperoRecibo> cx = RecuperoRecibo.find.where()
					   .eq("numero",c.numero).findList();

			if(cx.size() > 0) {
				flash("error", "Ya existe este numero de recibo cargado.");
				return badRequest(crearRecibo.render(reciboForm));
			}

			c.estado_id = (long) Estado.RECUPERO_RECIBOS_BORRADOR;
			c.create_date = new Date();
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.save();



			flash("success", "El Recibo se ha creado");
			return redirect( controllers.recupero.routes.RecuperoRecibosController.ver(reciboForm.get().id)+UriTrack.get("&") );

		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el recibo");
			return badRequest(crearRecibo.render(reciboForm));
		}
	}

	@CheckPermiso(key = "reciboModificar")
	public static Result editar(Long id) {
		RecuperoRecibo recibo = RecuperoRecibo.find.byId(id);

		if(recibo  == null){
			flash("error", "No se encuentra el recibo.");
			return redirect(controllers.recupero.routes.RecuperoRecibosController.index()+UriTrack.get("?"));
		}else if(recibo.estado_id != Estado.RECUPERO_RECIBOS_BORRADOR){
			flash("error", "El Recibo no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}

		return ok(editarRecibo.render(reciboForm.fill(recibo),recibo));
	}

	@CheckPermiso(key = "reciboModificar")
	public static Result actualizar(Long id){

		Form<RecuperoRecibo> reciboForm = form(RecuperoRecibo.class).bindFromRequest();

		RecuperoRecibo recibo = Ebean.find(RecuperoRecibo.class, id);

		if(reciboForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarRecibo.render(reciboForm,recibo));
		}

		try {
			RecuperoRecibo c = reciboForm.get();

			List<RecuperoRecibo> rpx = RecuperoRecibo.find.where()
											.eq("numero", c.numero)
								   			.ne("id", c.id).findList();

			Logger.debug("cccccccccccccccccccccccccccccccccccccccccc");
			if(rpx.size() > 0){
				flash("error", "Ya existe ese numero de recibo");
				return badRequest(editarRecibo.render(reciboForm,recibo));
			}else{
				c.update();
			}

			flash("success", "El recibo se ha actualizado");
			return redirect( controllers.recupero.routes.RecuperoRecibosController.ver(reciboForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el recibo.");
			return badRequest(editarRecibo.render(reciboForm,recibo));
		}
	}

	@CheckPermiso(key = "reciboEliminar")
	public static Result eliminar(Long id) {

		RecuperoRecibo recibo = Ebean.find(RecuperoRecibo.class).select("id").setId(id).findUnique();

		if(recibo == null){
			flash("error", "No se encuentra el recibo.");
			return redirect(controllers.recupero.routes.RecuperoRecibosController.index()+UriTrack.get("?"));
		}

		List<RecuperoRecibo> rpx = RecuperoRecibo.find.where()
				.ne("estado_id",Estado.RECUPERO_RECIBOS_BORRADOR)
	   			.eq("id", recibo.id).findList();

		Logger.debug("cccccccccccccccccccccccccccccccccccccccccc");
		if(rpx.size() > 0){
			flash("error", "Solo se puede eliminar en estado Borrador");
			return badRequest(editarRecibo.render(reciboForm,recibo));
		}


		try {
			recibo.delete();
			flash("success", "Se ha eliminado el recibo.");
			return redirect(UriTrack.decode());
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el recibo.");
		}


		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}

	public static Result cambiarEstado(Long idRecibo, Long idEstado) throws IOException{

		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_PRESUPUESTO);

		RecuperoRecibo rp = RecuperoRecibo.find.byId(idRecibo);

		if(rp == null){
			flash("error", "No se encuentra el recibo");
			return redirect(request().getHeader("referer"));
		}



		if(idEstado != null){

			Boolean permiso = false;

			switch ( idEstado.intValue() ) {
		      case  Estado.RECUPERO_RECIBOS_BORRADOR:
		    	  if(!Permiso.check("recuperoRecibosPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(rp.id);
		    	  break;

		      case Estado.RECUPERO_RECIBOS_APROBADO:
		    	  if(!Permiso.check("recuperoRecibosPasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }

		    	  pasarAprobado(rp.id);
		    	  break;
		      case Estado.RECUPERO_RECIBOS_CANCELADO:
		    	  if(!Permiso.check("recuperoRecibosPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(rp.id);
		          break;
		      default:
		           break;
		      }

		}

		return redirect(controllers.recupero.routes.RecuperoRecibosController.ver(rp.id)+ UriTrack.get("&"));
	}

	@CheckPermiso(key = "recuperoRecibosPasarEnBorrador")
	public static void pasarEnBorrador(Long idRf){

		RecuperoRecibo rf = Ebean.find(RecuperoRecibo.class).select("id, estado_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_RECIBOS_BORRADOR);

			rf.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "recuperoRecibosPasarAprobado")
	public static void pasarAprobado(Long idRf){

		RecuperoRecibo rf = Ebean.find(RecuperoRecibo.class).select("id, estado_id").setId(idRf).findUnique();

		if(rf != null){

			List<RecuperoReciboFactura> rrf = Ebean.find(RecuperoReciboFactura.class).select("id, estado_id").where().eq("recupero_recibo_id",rf.id).findList();
			if(rrf.size() == 0 ) {
				flash("error", "No se puede pasar a Estado APROBADO. Debe contener facturas asociadas.");
			}else {

				/// ACAAAAAAAA CREAR LOS PAGOS


				rf.estado_id = new Long(Estado.RECUPERO_RECIBOS_APROBADO);
				rf.save();

				flash("success", "Operación exitosa. Estado actual: Aprobado");
			}
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "recuperoRecibosPasarCancelado")
	public static void pasarCancelado(Long idRf){

		RecuperoRecibo rf = Ebean.find(RecuperoRecibo.class).select("id, estado_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_RECIBOS_CANCELADO);

			rf.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

}
