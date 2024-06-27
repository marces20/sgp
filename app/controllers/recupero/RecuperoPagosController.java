package controllers.recupero;

import static play.data.Form.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import models.Estado;
import models.Pago;
import models.Usuario;
import models.auth.Permiso;
import models.recupero.Cheque;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoPago;
import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.recupero.recuperoFactura.crearRecuperoFactura;
import views.html.recupero.recuperoFactura.editarRecuperoFactura;
import views.html.recupero.recuperoPago.*;

@Security.Authenticated(Secured.class)
public class RecuperoPagosController extends Controller {
	
	final static Form<RecuperoPago> recuperoPagoForm = form(RecuperoPago.class);
	
	public static Result URL_LISTA_RECUPEROPAGO = redirect(
			controllers.recupero.routes.RecuperoPagosController.index()
	);
	
	@CheckPermiso(key = "recuperoPagosVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexRecuperoPago.render(
											RecuperoPago.page(
											  		RequestVar.get("nombre"),
											  		RequestVar.get("cliente_id"),
											  		RequestVar.get("fecha_desde"),
											  		RequestVar.get("fecha_hasta"),
											  		RequestVar.get("tipoPago"),
											  		RequestVar.get("btnFiltro[0]"),//borrador
											  		RequestVar.get("btnFiltro[1]"),//encurso
											  		RequestVar.get("btnFiltro[2]"),//aprobado
											  		RequestVar.get("btnFiltro[3]"),//cancelado
											  		RequestVar.get("numero_factura"),
											  		RequestVar.get("cliente_tipo_id"),
											  		RequestVar.get("puntoventa_id"),
											  		RequestVar.get("deposito_id"),
											  		RequestVar.get("planilla_id"),
											  		RequestVar.get("numero_recibo")

												  ),d));
	}

	@CheckPermiso(key = "recuperoPagosVer")
	public static Result ver(Long id) {
		RecuperoPago p = RecuperoPago.find.byId(id);
		if(p != null){
			Logger.debug("zzzzzzzzzz "+p.controlPermisoDeposito());

			if(!p.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return redirect(controllers.recupero.routes.RecuperoPagosController.index()+UriTrack.get("?"));
			}

			Form<RecuperoPago> recuperoPagoForm = form(RecuperoPago.class).fill(p);
			return ok(verRecuperoPago.render(recuperoPagoForm, p));
		}else{
			flash("error", "No se encuentra el pago.");
			return redirect(controllers.recupero.routes.RecuperoPagosController.index()+UriTrack.get("?"));
		}
	}

	@CheckPermiso(key = "recuperoPagosCrear")
	public static Result crear() {

		Map<String,String> p = new HashMap<String, String>();
		p.put("nombre","RPAG");
		Form<RecuperoPago> recuperoPagoForm = form(RecuperoPago.class).bind(p);
		recuperoPagoForm.discardErrors();

		return ok(crearRecuperoPago.render(recuperoPagoForm));
	}

	@CheckPermiso(key = "recuperoFacturasCrear")
	public static Result guardar() {

		Form<RecuperoPago> recuperoPagoForm = form(RecuperoPago.class).bindFromRequest();
		Form<Cheque> chequeForm = form(Cheque.class).bindFromRequest();


		if(recuperoPagoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearRecuperoPago.render(recuperoPagoForm));
		}

		try {
			RecuperoPago c = recuperoPagoForm.get();

			/*if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return badRequest(crearRecuperoPago.render(recuperoPagoForm));
			}*/

			c.create_date = new Date();
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.save();

			flash("success", "El pago se ha creado");
			return redirect( controllers.recupero.routes.RecuperoPagosController.ver(recuperoPagoForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el pago");
			return badRequest(crearRecuperoPago.render(recuperoPagoForm));
		}
	}

	@CheckPermiso(key = "recuperoPagosModificar")
	public static Result editar(Long id) {
		RecuperoPago rp = RecuperoPago.find.byId(id);

		if(rp  == null){
			flash("error", "No se encuentra el pago .");
			return redirect(controllers.recupero.routes.RecuperoPagosController.index()+UriTrack.get("?"));
		}else if(rp.estado_id == Estado.RECUPERO_PAGO_PAGADO || rp.estado_id == Estado.RECUPERO_PAGO_CANCELADO ){
			flash("error", "El pago no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}/*else if(!rp.controlPermisoDeposito()) {
			flash("error", "La planilla institucion no corresponde a su institucion asignada.");
			return redirect(controllers.recupero.routes.RecuperoPagosController.index()+UriTrack.get("?"));
		}*/

		return ok(editarRecuperoPago.render(recuperoPagoForm.fill(rp),rp));
	}

	@CheckPermiso(key = "recuperoPagosModificar")
	public static Result actualizar(Long id){

		Form<RecuperoPago> recuperoPagoForm = form(RecuperoPago.class).bindFromRequest();

		RecuperoPago rp = Ebean.find(RecuperoPago.class, id);

		if(recuperoPagoForm.hasErrors()) {
			flash("error", "Error en formulario"+recuperoPagoForm.errors());
			return badRequest(editarRecuperoPago.render(recuperoPagoForm,rp));
		}

		try {
			RecuperoPago c = recuperoPagoForm.get();

			if(c.pago_principal_id != null){

				List<RecuperoPago> rpp3 = RecuperoPago.find.where().eq("recupero_factura_id", c.recupero_factura_id).ne("id", c.id).findList();

				BigDecimal montoPagoPrincipal = new BigDecimal(0);
				BigDecimal montosPagosParcializados = new BigDecimal(0);
				for(RecuperoPago x :rpp3){
					if(x.parcializada != null && x.parcializada) {
						montoPagoPrincipal = montoPagoPrincipal.add(x.total);
					}else {
						montosPagosParcializados = montosPagosParcializados.add(x.total);
					}
				}
				Logger.debug("montoPagoPrincipal: "+montoPagoPrincipal);
				Logger.debug("montosPagosParcializados: "+montosPagosParcializados);
				Logger.debug("montosPagosParcializados: "+montosPagosParcializados);


				if(montosPagosParcializados.add(c.total).compareTo(montoPagoPrincipal) > 0) {
					flash("error", "La suma de los pagos parcializados excede el monto del pago principal.");
					return badRequest(editarRecuperoPago.render(recuperoPagoForm,rp));
				}
			}else {
				RecuperoFactura rf = RecuperoFactura.find.byId(c.recupero_factura_id.longValue());
				if(c.total.compareTo(rf.getTotal()) >0) {
					flash("error", "La suma del pagos excede el monto de la factura.");
					return badRequest(editarRecuperoPago.render(recuperoPagoForm,rp));
				}
			}


			/*if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return badRequest(editarRecuperoPago.render(recuperoPagoForm,rp));
			}*/

			c.estado_id = rp.estado_id;
			c.write_date = new Date();
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.update();
			flash("success", "El pago se ha actualizado");
			return redirect( controllers.recupero.routes.RecuperoPagosController.ver(recuperoPagoForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el pago");
			return badRequest(editarRecuperoPago.render(recuperoPagoForm,rp));
		}
	}

	@CheckPermiso(key = "recuperoPagosEliminar")
	public static Result eliminar(Long id) {

		RecuperoPago rp = Ebean.find(RecuperoPago.class).select("id, estado_id,pago_principal_id").setId(id).findUnique();

		if(rp == null){
			flash("error", "No se encuentra el pago.");
			return redirect(controllers.recupero.routes.RecuperoPagosController.index()+UriTrack.get("?"));
		}

		List<RecuperoPago> rpp = RecuperoPago.find.where().eq("pago_principal_id", rp.id).findList();
		if(rpp.size() > 0){
			flash("error", "No se puede eliminar el pago porque tiene pago parciales.");
		}

		if(rp.estado_id == Estado.RECUPERO_PAGO_BORRADOR || rp.estado_id == Estado.RECUPERO_PAGO_CANCELADO){
			try {

				if(rp.pago_principal_id != null){
					List<RecuperoPago> rpp3 = RecuperoPago.find.where().eq("pago_principal_id", rp.pago_principal_id).ne("id", rp.id).findList();
					if(rpp3.size() == 0){
						SqlUpdate update = Ebean.createSqlUpdate("UPDATE recupero_pagos set parcializada = null where id = :id  ");
						update.setParameter("id", rp.pago_principal_id);
						update.execute();
					}
				}


				rp.delete();
				flash("success", "Se ha eliminado el pago");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar el pago");
			}
		} else {
			flash("error", "No se ha podido eliminar el pago . Unicamente se puede eliminar cuando el estado del pago se encuentra en borrador o cancelado.");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}


	public static Result crearPagoParcial(Long id) {
		RecuperoPago pago = RecuperoPago.find.byId(id);

		if((pago.estado_id != Estado.RECUPERO_PAGO_BORRADOR)){
			flash("error", "No se puede crear un pago parcial desde este pago. Debe cambiar su estado a borrador");
			return redirect(request().getHeader("referer"));
		}

		try {

			RecuperoPago rp = new RecuperoPago();

			Long idNew = rp.parcializar(id);

			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha parcializado el pago.");
				return redirect(controllers.recupero.routes.RecuperoPagosController.editar(idNew)+UriTrack.get("&"));
			}else{
				flash("error", "No se ha podido parcializar el pago.");
				String refererUrl = request().getHeader("referer");
				return redirect(refererUrl);
			}


			/*RecuperoPago pago2 = (RecuperoPago) pago._ebean_createCopy();
			pago2.setId(null);
			pago2.total = null;
			pago2.tipoPago = null;
			pago2.pago_principal_id = id;
			pago2.parcializada = false;
			pago2.save();



			SqlUpdate update = Ebean.createSqlUpdate("UPDATE recupero_pagos set parcializada = true where id = :id  ");
			update.setParameter("id", id);
			update.execute();

			flash("success", "Se creado el pago parcial");*/

			//Form<RecuperoPago> recuperoPagoForm = form(RecuperoPago.class).fill(pago2);
			//return ok(verRecuperoPago.render(recuperoPagoForm, pago2));
			//return redirect(controllers.recupero.routes.RecuperoPagosController.ver(pago2.id));

		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido crear el pago parcial.");
		}

		return redirect(request().getHeader("referer"));
	}



	public static Result cambiarEstado(Long idPago, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_PRESUPUESTO);

		RecuperoPago rp = RecuperoPago.find.byId(idPago);

		if(rp == null){
			flash("error", "No se encuentra el pago");
			return redirect(request().getHeader("referer"));
		}

		if(!rp.controlPermisoDeposito()) {
			flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
			return badRequest(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}


		if(idEstado != null){

			Boolean permiso = false;

			switch ( idEstado.intValue() ) {
		      case  Estado.RECUPERO_PAGO_BORRADOR:
		    	  if(!Permiso.check("recuperoPagosPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(rp.id);
		    	  break;
		      case Estado.RECUPERO_PAGO_ENCURSO:
		    	  if(!Permiso.check("recuperoPagosPasarCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
				  if(rp.tipoPago == null) {
					 flash("error", "Debe indicar un tipo de pago");
					 break;
				  }

				  if(rp.planilla_id == null) {
						 flash("error", "Debe indicar una planilla");
						 break;
					  }

				  if(rp.cheque == null && rp.tipoPago.equals(RecuperoPago.PAGO_CHEQUE)) {
					 flash("error", "Debe cargar datos del cheque");
					 break;
				  }

		    	  pasarEnCurso(rp.id);
		    	  break;
		      case Estado.RECUPERO_PAGO_PAGADO:
		    	  if(!Permiso.check("recuperoPagosPasarPagado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }

		    	  pasarPagado(rp.id);
		    	  break;
		      case Estado.RECUPERO_PAGO_CANCELADO:
		    	  if(!Permiso.check("recuperoPagosPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(rp.id);
		          break;
		      default:
		           break;
		      }

		}

		return redirect(controllers.recupero.routes.RecuperoPagosController.ver(rp.id)+ UriTrack.get("&"));
	}

	@CheckPermiso(key = "recuperoPagosPasarEnBorrador")
	public static void pasarEnBorrador(Long idRf){

		RecuperoPago rf = Ebean.find(RecuperoPago.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_PAGO_BORRADOR);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "recuperoPagosPasarEnCurso")
	public static void pasarEnCurso(Long idRf){

		RecuperoPago rf = Ebean.find(RecuperoPago.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_PAGO_ENCURSO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: En Curso");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "recuperoPagosPasarPagado")
	public static void pasarPagado(Long idRf){
		boolean error = false;
		RecuperoPago rf = RecuperoPago.find.byId(idRf);

		if(rf.pago_principal_id != null){

			List<RecuperoPago> rpp3 = RecuperoPago.find.where().eq("recupero_factura_id", rf.recupero_factura_id).ne("id", rf.id).findList();

			BigDecimal montoPagoPrincipal = new BigDecimal(0);
			BigDecimal montosPagosParcializados = new BigDecimal(0);
			for(RecuperoPago x :rpp3){
				if(x.parcializada != null && x.parcializada) {
					montoPagoPrincipal = montoPagoPrincipal.add(x.total);
				}else {
					montosPagosParcializados = montosPagosParcializados.add(x.total);
				}
			}
			Logger.debug("montoPagoPrincipal: "+montoPagoPrincipal);
			Logger.debug("montosPagosParcializados: "+montosPagosParcializados);
			Logger.debug("montosPagosParcializados: "+montosPagosParcializados);


			if(montosPagosParcializados.add(rf.total).compareTo(montoPagoPrincipal) > 0) {
				flash("error", "La suma de los pagos parcializados excede el monto del pago principal.");
				error = true;
			}
		}else {
			RecuperoFactura rfx = RecuperoFactura.find.byId(rf.recupero_factura_id.longValue());
			if(rf.total.compareTo(rfx.getTotal()) >0) {
				flash("error", "La suma del pagos excede el monto de la factura.");
				error = true;
			}
		}



		if(!error) {
			if(rf != null){
				rf.estado_id = new Long(Estado.RECUPERO_PAGO_PAGADO);
				rf.write_date = new Date();
				rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				rf.save();
				flash("success", "Operación exitosa. Estado actual: Pagado");
			} else {
				flash("error", "Parámetros incorrectos");
			}
		}
	}

	@CheckPermiso(key = "recuperoPagosPasarCancelado")
	public static void pasarCancelado(Long idRf){

		RecuperoPago rf = Ebean.find(RecuperoPago.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		boolean certificacionOk = true;
		String error = "";

		if(rf != null && certificacionOk){
			rf.estado_id = new Long(Estado.RECUPERO_PAGO_CANCELADO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos. "+error);
		}
	}
}
