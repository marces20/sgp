package controllers.recupero;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

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
import utils.DateUtils;
import utils.NumberUtils;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.recupero.recuperoRecibo.*;

@Security.Authenticated(Secured.class)
public class RecuperoRecibosController extends Controller {

	/*

	 * 6- periodo en factura
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
												  		RequestVar.get("fecha_hasta"),
												  		RequestVar.get("puntoventa_id"),
												  		RequestVar.get("cliente_id")
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
		Date d = new Date();
		p.put("fecha",DateUtils.formatDate(d,"dd/MM/yyyy"));

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

			/*List<RecuperoRecibo> cx = RecuperoRecibo.find.where()
					   .eq("numero",c.numero).findList();

			if(cx.size() > 0) {
				flash("error", "Ya existe este numero de recibo cargado.");
				return badRequest(crearRecibo.render(reciboForm));
			}*/

			c.numero = "00000000";
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

		    	 /* List<RecuperoReciboFactura> rrfl = Ebean.find(RecuperoReciboFactura.class).select("id, estado_id,recupero_factura_id,monto").where().eq("recupero_recibo_id",rp.id).findList();
				  if(rrfl.size() == 0 ) {
					  flash("error", "No se puede pasar a Estado APROBADO. Debe contener facturas asociadas.");
					  return redirect(request().getHeader("referer"));
				  }*/

		    	  String numeroRecibo = "";

		    	  try {
		    		  	if(rp.numero.compareTo("00000000") == 0) {

							String sql = "select  (max(CAST(numero as integer ))+1) as numero from recupero_recibos where puntoventa_id = :puntoventa_id";
					    	SqlQuery sqlQuery = Ebean.createSqlQuery(sql)
									.setParameter("puntoventa_id", rp.puntoventa_id);
					    	SqlRow  row = sqlQuery.findUnique();

					    	numeroRecibo = NumberUtils.agregarCerosAlaIzquierda(row.getInteger("numero"),8);

						}else {
							numeroRecibo = rp.numero;
						}
					}catch (Exception e) {
						flash("error", "No se puede obtener el numero de recibo.");
						return redirect(request().getHeader("referer"));
					}


		    	  pasarAprobado(rp.id,numeroRecibo);
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

			List<RecuperoPago> rp = Ebean.find(RecuperoPago.class).select("id, estado_id").where().eq("recupero_recibo_id", rf.id).findList();

			for(RecuperoPago rpx :rp) {

				rpx.delete();
			}

			List<RecuperoReciboFactura> rpf = Ebean.find(RecuperoReciboFactura.class).select("id, estado_id").where().eq("recupero_recibo_id", rf.id).findList();

			for(RecuperoReciboFactura rpxf :rpf) {
				rpxf.delete();
			}

			rf.estado_id = new Long(Estado.RECUPERO_RECIBOS_BORRADOR);

			rf.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "recuperoRecibosPasarAprobado")
	public static void pasarAprobado(Long idRf,String numeroRecibo){

		RecuperoRecibo rf = Ebean.find(RecuperoRecibo.class).select("id, estado_id").setId(idRf).findUnique();

		if(rf != null){



					rf.numero = numeroRecibo;
					rf.write_date = new Date();
					rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
					rf.estado_id = new Long(Estado.RECUPERO_RECIBOS_APROBADO);
					rf.save();

					flash("success", "Operación exitosa. Estado actual: Aprobado");


		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "recuperoRecibosPasarCancelado")
	public static void pasarCancelado(Long idRf){

		RecuperoRecibo rf = Ebean.find(RecuperoRecibo.class).select("id, estado_id").setId(idRf).findUnique();

		if(rf != null){

			List<RecuperoPago> rp = Ebean.find(RecuperoPago.class).select("id, estado_id").where().eq("recupero_recibo_id", rf.id).findList();

			for(RecuperoPago rpx :rp) {
				rpx.estado_id = (long) Estado.RECUPERO_PAGO_CANCELADO;
				rpx.save();

				rpx.estado_id = (long) Estado.RECUPERO_PAGO_BORRADOR;
				rpx.save();

				rpx.delete();
			}



			rf.estado_id = new Long(Estado.RECUPERO_RECIBOS_CANCELADO);

			rf.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

}
