package controllers.recupero;

import static play.data.Form.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.http.impl.cookie.DateUtils;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.afip.AfipController;
import controllers.auth.CheckPermiso;
import models.Estado;
import models.Periodo;
import models.Producto;
import models.PuntoVenta;
import models.TipoComprobante;
import models.Usuario;
import models.auth.Permiso;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoNotaDebito;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.recupero.recuperoFactura.*;

@Security.Authenticated(Secured.class)
public class RecuperoFacturasController extends Controller {

	final static Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class);

	public static Result URL_LISTA_RECUPEROFACTURA = redirect(
			controllers.recupero.routes.RecuperoFacturasController.index()
	);

	@CheckPermiso(key = "recuperoFacturasVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexRecuperoFactura.render(
											RecuperoFactura.page(
												  		RequestVar.get("nombre"),
												  		RequestVar.get("numero"),
													  	RequestVar.get("cliente_id"),
													  	RequestVar.get("fecha_desde"),
													  	RequestVar.get("fecha_hasta"),
												  		RequestVar.get("btnFiltro[0]"),//borrador
												  		RequestVar.get("btnFiltro[1]"),//encurso
												  		RequestVar.get("btnFiltro[2]"),//aprobado
												  		RequestVar.get("btnFiltro[3]"),//cancelado
												  		RequestVar.get("btnFiltro[4]"),//pagada
												  		RequestVar.get("puntoventa_id"),
												  		RequestVar.get("planilla_id"),
												  		RequestVar.get("deposito_id"),
												  		RequestVar.get("create_usuario_id")
												  		  ),d));
	}

	@CheckPermiso(key = "recuperoFacturasVer")
	public static Result ver(Long id) {
		RecuperoFactura p = RecuperoFactura.find.byId(id);
		if(p != null){

			if(!p.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
			}

			Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class).fill(p);
			return ok(verRecuperoFactura.render(recuperoFacturaForm, p));
		}else{
			flash("error", "No se encuentra la factura.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}
	}

	@CheckPermiso(key = "recuperoFacturasCrear")
	public static Result crear() {

		Map<String,String> p = new HashMap<String, String>();
		p.put("nombre","RFAC");
		Date d = new Date();
		p.put("fecha",DateUtils.formatDate(d,"dd/MM/yyyy"));
		if(Usuario.getUsuarioSesion().equals(83)){//GRaciela traid
			p.put("planilla.recuperoPlanillaEjercicio","154");
			p.put("planilla_id","4735");
		}

		Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class).bind(p);
		recuperoFacturaForm.discardErrors();

		return ok(crearRecuperoFactura.render(recuperoFacturaForm));
	}

	@CheckPermiso(key = "recuperoFacturasCrear")
	public static Result guardar() {

		Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class).bindFromRequest();

		if(recuperoFacturaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearRecuperoFactura.render(recuperoFacturaForm));
		}

		try {
			RecuperoFactura c = recuperoFacturaForm.get();

			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return badRequest(crearRecuperoFactura.render(recuperoFacturaForm));
			}

			/*List<RecuperoFactura> cx = RecuperoFactura.find.where()
									   .eq("numero",c.numero)
									   .eq("puntoventa_id", c.puntoventa_id)
									   .eq("serie",c.serie).findList();

			if(cx.size() > 0) {
				flash("error", "Ya existe este numero de factura cargada.");
				return badRequest(crearRecuperoFactura.render(recuperoFacturaForm));
			}*/

			Periodo periodo = Periodo.getPeriodoByDate(c.fecha);
			c.fecha_desde = periodo.date_start;
			c.fecha_hasta = periodo.date_stop;

			if(c.periodo_id != null) {
				periodo = Periodo.find.byId(c.periodo_id.longValue());
				c.fecha_desde = periodo.date_start;
				c.fecha_hasta = periodo.date_stop;
			}

			c.create_date = new Date();
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.save();

			flash("success", "La factura se ha creado");
			return redirect( controllers.recupero.routes.RecuperoFacturasController.ver(recuperoFacturaForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la factura");
			return badRequest(crearRecuperoFactura.render(recuperoFacturaForm));
		}
	}

	@CheckPermiso(key = "recuperoFacturasModificar")
	public static Result editar(Long id) {
		RecuperoFactura rp = RecuperoFactura.find.byId(id);

		if(rp  == null){
			flash("error", "No se encuentra la factura.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}else if(rp.estado_id == Estado.RECUPERO_FACTURA_APROBADO || rp.estado_id == Estado.RECUPERO_FACTURA_CANCELADO ){
			flash("error", "La factura no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}else if(!rp.controlPermisoDeposito()) {
			flash("error", "La planilla institucion no corresponde a su institucion asignada.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}

		return ok(editarRecuperoFactura.render(recuperoFacturaForm.fill(rp),rp));
	}

	@CheckPermiso(key = "recuperoFacturasModificar")
	public static Result actualizar(Long id){

		Form<RecuperoFactura> recuperoFacturaForm = form(RecuperoFactura.class).bindFromRequest();

		RecuperoFactura rp = Ebean.find(RecuperoFactura.class, id);

		if(recuperoFacturaForm.hasErrors()) {
			flash("error", "Error en formulario ");
			return badRequest(editarRecuperoFactura.render(recuperoFacturaForm,rp));
		}

		try {
			RecuperoFactura c = recuperoFacturaForm.get();

			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return badRequest(editarRecuperoFactura.render(recuperoFacturaForm,rp));
			}

			/*List<RecuperoFactura> cx = RecuperoFactura.find.where()
					   .eq("numero",c.numero)
					   .eq("puntoventa_id", c.puntoventa_id)
					   .eq("serie",c.serie).ne("id", c.id).findList();

			if(cx.size() > 0) {
				flash("error", "Ya existe este numero de factura cargada.");
				return badRequest(editarRecuperoFactura.render(recuperoFacturaForm,rp));
			}*/

			Periodo periodo = Periodo.getPeriodoByDate(c.fecha);
			c.fecha_desde = periodo.date_start;
			c.fecha_hasta = periodo.date_stop;

			if(c.periodo_id != null) {
				periodo = Periodo.find.byId(c.periodo_id.longValue());
				c.fecha_desde = periodo.date_start;
				c.fecha_hasta = periodo.date_stop;
			}

			c.estado_id = rp.estado_id;
			c.write_date = new Date();
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.update();
			flash("success", "La factura se ha actualizado");
			return redirect( controllers.recupero.routes.RecuperoFacturasController.ver(recuperoFacturaForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la factura");
			return badRequest(editarRecuperoFactura.render(recuperoFacturaForm,rp));
		}
	}

	@CheckPermiso(key = "recuperoFacturasEliminar")
	public static Result eliminar(Long id) {

		RecuperoFactura rp = Ebean.find(RecuperoFactura.class).select("id, estado_id").setId(id).findUnique();

		if(rp == null){
			flash("error", "No se encuentra la factura.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}

		if(rp.pagos.size() > 0) {
			flash("error", "No se puede eliminar facturas con pagos.");
			return redirect(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}

		if(rp.estado_id == Estado.RECUPERO_FACTURA_BORRADOR || rp.estado_id == Estado.RECUPERO_FACTURA_CANCELADO){
			try {
				rp.delete();
				flash("success", "Se ha eliminado la factura");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar la factura");
			}
		} else {
			flash("error", "No se ha podido eliminar la factura. Unicamente se puede eliminar cuando el estado de la factura se encuentra en borrador o cancelado.");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}

	public static Result cambiarEstado(Long idFactura, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_PRESUPUESTO);

		RecuperoFactura rp = RecuperoFactura.find.byId(idFactura);

		if(!rp.controlPermisoDeposito()) {
			flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
			return badRequest(controllers.recupero.routes.RecuperoFacturasController.index()+UriTrack.get("?"));
		}

		if(rp == null){
			flash("error", "No se encuentra la factura");
			return redirect(request().getHeader("referer"));
		}

		if((rp.recuperoFacturaLinea.isEmpty()) && (idEstado != Estado.RECUPERO_FACTURA_CANCELADO && idEstado != Estado.RECUPERO_FACTURA_BORRADOR)){
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(request().getHeader("referer"));
		}

		if(idEstado != null){

			Boolean permiso = false;

			switch ( idEstado.intValue() ) {
		      case  Estado.RECUPERO_FACTURA_BORRADOR:
		    	  if(!Permiso.check("recuperoFacturasPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }

		    	  if(!rp.pagos.isEmpty()) {
		  			flash("error", "No se puede pasar a borrador cuando hay pagos asociados.");
					return redirect(request().getHeader("referer"));
		    	  }

		    	  pasarEnBorrador(rp.id);
		    	  break;
		      case Estado.RECUPERO_FACTURA_ENCURSO:
		    	  if(!Permiso.check("recuperoFacturasPasarCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnCurso(rp.id);
		    	  break;
		      case Estado.RECUPERO_FACTURA_APROBADO:
		    	  if(!Permiso.check("recuperoFacturasPasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobado(rp.id);
		    	  break;
		      case Estado.RECUPERO_FACTURA_CANCELADO:
		    	  if(!Permiso.check("recuperoFacturasPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }

		    	  if(!rp.pagos.isEmpty()) {
		  			flash("error", "No se puede cancelar cuando hay pagos asociados.");
					return redirect(request().getHeader("referer"));
		    	  }

		    	  pasarCancelado(rp.id);
		          break;
		      default:
		           break;
		      }

		}

		return redirect(controllers.recupero.routes.RecuperoFacturasController.ver(rp.id)+ UriTrack.get("&"));
	}

	@CheckPermiso(key = "recuperoFacturasPasarEnBorrador")
	public static void pasarEnBorrador(Long idRf){

		RecuperoFactura rf = Ebean.find(RecuperoFactura.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_FACTURA_BORRADOR);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "recuperoFacturasPasarEnCurso")
	public static void pasarEnCurso(Long idRf){

		RecuperoFactura rf = Ebean.find(RecuperoFactura.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_FACTURA_ENCURSO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: En Curso");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "recuperoFacturasPasarAprobado")
	public static void pasarAprobado(Long idRf){

		RecuperoFactura rf = Ebean.find(RecuperoFactura.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){

			if(rf.recupero_tipo_pago_id == null){
				flash("error", "Debe cargar un Tipo de Pago.");

			}else {

				rf.estado_id = new Long(Estado.RECUPERO_FACTURA_APROBADO);
				rf.write_date = new Date();
				rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				rf.save();
				flash("success", "Operación exitosa. Estado actual: Aprobado");
			}
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	@CheckPermiso(key = "recuperoFacturasPasarCancelado")
	public static void pasarCancelado(Long idRf){

		RecuperoFactura rf = Ebean.find(RecuperoFactura.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		boolean certificacionOk = true;
		String error = "";

		if(rf != null && certificacionOk){
			rf.estado_id = new Long(Estado.RECUPERO_FACTURA_CANCELADO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos. "+error);
		}
	}

	public static Result suggestFactura(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode udm = rpta.arrayNode();

	    RecuperoFactura ad = new RecuperoFactura();

		for(RecuperoFactura a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.getNumeroFactura());
	        restJs.put("info",a.cliente.nombre);
	        udm.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", udm);

		return ok(response);
	}

	public static Result modalBuscar() {
    	Pagination<RecuperoFactura> p = new Pagination<RecuperoFactura>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(RecuperoFactura.find.fetch("cliente", "nombre").fetch("puntoVenta", "numero").where().eq("estado_id",Estado.RECUPERO_FACTURA_APROBADO).ilike("numero", "%" + RequestVar.get("numero") + "%"));
		return ok( modalBusquedaRecuperoFactura.render(p, form().bindFromRequest()) );
	}

	public static Result modalBuscarSoloSaldo() {
    	Pagination<RecuperoFactura> p = new Pagination<RecuperoFactura>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	Model.Finder<Long,RecuperoFactura> find = new Finder<Long,RecuperoFactura>(Long.class, RecuperoFactura.class);

    	ExpressionList<RecuperoFactura> e = find
				.fetch("cliente", "nombre")
				.fetch("puntoVenta", "numero")
				.where();

    	e.eq("estado_id",Estado.RECUPERO_FACTURA_APROBADO);

    	if(!RequestVar.get("numero").isEmpty()) {
    		e.ilike("numero", "%" + RequestVar.get("numero") + "%");
    	}



    	if(!RequestVar.get("puntoventa_id").isEmpty()) {
    		e.eq("puntoventa_id", Integer.parseInt(RequestVar.get("puntoventa_id")));
    	}

    	p.setExpressionList(e);
		return ok( modalBusquedaRecuperoFactura.render(p, form().bindFromRequest()) );
	}

	public static Result get(int id){
		RecuperoFactura factura = RecuperoFactura.find.fetch("cliente", "nombre").fetch("puntoVenta", "numero").where().eq("id", id).eq("estado_id",Estado.RECUPERO_FACTURA_APROBADO).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(factura == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la factura");
		} else {
			restJs.put("success", true);
			restJs.put("id", factura.id);
			restJs.put("nombre", factura.getNumeroFactura());
			restJs.put("cliente", factura.cliente.nombre);
			restJs.put("monto", factura.getSaldoPendiente());
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result getUltimoComprobante(Long idFactura) throws IOException{
		try {
			RecuperoFactura factura = RecuperoFactura.find.fetch("cliente", "nombre").fetch("puntoVenta", "numero").where().eq("id", idFactura).findUnique();

			AfipController ac = new AfipController();
			ObjectNode ret = ac.getUltimoComprobanteNew(new Integer(factura.puntoVenta.numero),TipoComprobante.FACTURA);

			if(ret.get("success").asText().compareTo("true")  == 0) {
				flash("success", "data: "+ret.get("data").asText());
			}else {
				flash("error", "error: ");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}

		return redirect(controllers.recupero.routes.RecuperoFacturasController.ver(idFactura)+ UriTrack.get("&"));
	}

	public static Result correrFacturaAfip(Long idFactura) throws IOException{
		//if (play.Play.isProd()) {
			try {
				AfipController ac = new AfipController();
				ObjectNode ret = ac.setComprobante(idFactura,TipoComprobante.FACTURA);

				if(ret.get("success").asText().compareTo("true")  == 0) {
					flash("success", "CAEE: "+ret.get("cae").asText());
				}else {
					flash("error", "error: "+ret.get("error").asText());
				}
			}catch (Exception e) {
				flash("error", "error: "+e);
			}
		/*}else {
			flash("error", "error: NO ES PRODUCCION");
		}*/


		return redirect(controllers.recupero.routes.RecuperoFacturasController.ver(idFactura)+ UriTrack.get("&"));
	}

	public static Result correrNota(Long idNota,int tipoComprobante) throws IOException{

		//if (play.Play.isProd()) {
			try {
				AfipController ac = new AfipController();
				ObjectNode ret = null;
				if(tipoComprobante == TipoComprobante.NOTA_CREDITO) {

					RecuperoNotaCredito rc = RecuperoNotaCredito.find.byId(idNota);

					//if(rc.recupero_factura.cae != null && !rc.recupero_factura.cae.isEmpty()) {
						ret = ac.setComprobante(idNota,TipoComprobante.NOTA_CREDITO);
						if(ret.get("success").asText().compareTo("true")  == 0) {
							flash("success", "CAEE: "+ret.get("cae").asText());
						}else if(ret.get("error") != null){
							flash("error", "error: "+ret.get("error").asText());
						}
					//}else {
						//	flash("error", "error: La factura no tiene cae asignado");
						//}

					return redirect(controllers.recupero.routes.RecuperoFacturasController.ver(rc.recupero_factura.id)+ UriTrack.get("&"));
				}else if(tipoComprobante == TipoComprobante.NOTA_DEBITO) {

					RecuperoNotaDebito rd = RecuperoNotaDebito.find.byId(idNota);
					//if(rd.recupero_factura.cae != null && !rd.recupero_factura.cae.isEmpty()) {
						ret = ac.setComprobante(idNota,TipoComprobante.NOTA_DEBITO);
						if(ret.get("success").asText().compareTo("true")  == 0) {
							flash("success", "CAEE: "+ret.get("cae").asText());
						}else if(ret.get("error") != null){
							flash("error", "error: "+ret.get("error").asText());
						}
						//}else {

						//	flash("error", "error: La factura no tiene cae asignado");
						//}

					return redirect(controllers.recupero.routes.RecuperoFacturasController.ver(rd.recupero_factura.id)+ UriTrack.get("&"));
				}



			}catch (Exception e) {
				flash("error", "error: "+e);
			}
		/*}else {
			flash("error", "error: NO ES PRODUCCION");
		}*/


		return redirect(controllers.recupero.routes.RecuperoFacturasController.index());
	}
}
