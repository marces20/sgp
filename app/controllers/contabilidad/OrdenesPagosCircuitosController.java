package controllers.contabilidad;

import static play.data.Form.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Estado;
import models.ExpedienteMovimiento;
import models.Factura;
import models.OrdenPago;
import models.OrdenPagoCircuito;
import models.Organigrama;
import models.Usuario;
import models.auth.Permiso;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NoRecordModelException;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.contabilidad.ordenesPagosCircuitos.*;
import views.html.expediente.expediente.acciones.modalPasarOtroServicio;

@Security.Authenticated(Secured.class)
public class OrdenesPagosCircuitosController extends Controller {
	
	final static Form<OrdenPagoCircuito> ordenForm = form(OrdenPagoCircuito.class);
	
	public static Result URL_INDEX_ORDEN = redirect(
			controllers.contabilidad.routes.OrdenesPagosCircuitosController.index()  + UriTrack.get("&")
	);
	
	@CheckPermiso(key = "ordenesPagosCircuitoListado")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexOrdenPagoCircuito.render(OrdenPagoCircuito.page(
														RequestVar.get("numero_orden_pago_desde"), 
														RequestVar.get("numero_orden_pago_hasta"),
														RequestVar.get("expediente.id"),
														RequestVar.get("proveedor.id"),
														RequestVar.get("btnFiltro[0]"),//borrador
														RequestVar.get("btnFiltro[1]"),//contabilidad
														RequestVar.get("btnFiltro[2]"),//rendiciones
														RequestVar.get("btnFiltro[3]"),//rendido
														RequestVar.get("btnFiltro[4]"),//cancelado
														RequestVar.get("fecha_pago_desde"),
														RequestVar.get("fecha_pago_hasta"),
														RequestVar.get("fecha_ultima_desde"),
														RequestVar.get("fecha_ultima_hasta"),
														RequestVar.get("fecha_conta_desde"),
														RequestVar.get("fecha_conta_hasta"),
														RequestVar.get("fecha_rendi_desde"),
														RequestVar.get("fecha_rendi_hasta"),
														RequestVar.get("cuenta_propia"),
														RequestVar.get("ordenPago.id")
														), d));
	}
	
	@CheckPermiso(key = "ordenesPagosCircuitoVer")
	public static Result ver(Long id) {
		OrdenPagoCircuito ordenPagoCircuito = OrdenPagoCircuito.find.byId(id);
		
		return ok(verOrdenPagoCircuito.render(ordenForm.fill(ordenPagoCircuito),ordenPagoCircuito));
	}
	
	@CheckPermiso(key = "ordenesPagosCircuitoEditar")
	public static Result editar(Long id) {
		OrdenPagoCircuito orden;
		try {
			orden = loadModel(id);
		} catch (NoRecordModelException e) {
			return URL_INDEX_ORDEN;
		}
		return ok(editarOrdenPagoCircuito.render(ordenForm.fill(orden)));
	}
	
	@CheckPermiso(key = "ordenesPagosCircuitoEditar")
	public static Result actualizar(){
		
		Form<OrdenPagoCircuito> form = form(OrdenPagoCircuito.class).bindFromRequest();
		
		if(form.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarOrdenPagoCircuito.render(form));
		}
		
		try {
			OrdenPagoCircuito orden = form.get();
			orden.update();
			
			OrdenPagoCircuito orden2 = OrdenPagoCircuito.find.byId(orden.id);
			flash("success", "El registro se ha actualizado");
			return ok(verOrdenPagoCircuito.render(ordenForm.fill(orden2),orden2));
		}  catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el registro");
			return badRequest(editarOrdenPagoCircuito.render(form));
		}
		//return redirect( controllers.contabilidad.routes.OrdenesPagosCircuitosController.index() );
	}
	
	public static Result cambiarEstado(Long idOc, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_ORDEN);
		
		OrdenPagoCircuito oc = OrdenPagoCircuito.find.byId(idOc);
		
		if(oc == null){
			flash("error", "No se encuentra la Orden de pago.");
			return redirect(request().getHeader("referer"));
		}
		

		if(idEstado != null){
			Boolean permiso = false;
			switch ( idEstado.intValue() ) {
		      case  Estado.ORDEN_PAGO_CIRCUITO_ESTADO_BORRADOR:
			    	 if(!Permiso.check("ordenesPagosCircuitoPasarBorrador")) {
						  return ok(sinPermiso.render(request().getHeader("referer")));
					 }
			    	 pasarEnBorrador(oc.id,oc);
		    	 break;
		      case  Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CONTABILIDAD:
			    	 if(!Permiso.check("ordenesPagosCircuitoPasarContabilidad")) {
						  return ok(sinPermiso.render(request().getHeader("referer")));
					 }
			    	 pasarContabilidad(oc.id,oc);
			   break;	 
		      case Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDICIONES:
			    	 if(!Permiso.check("ordenesPagosCircuitoPasarRendiciones")) {
						  return ok(sinPermiso.render(request().getHeader("referer")));
					 }
			    	 pasarRendiciones(oc.id,oc); 
			    	
		    	 break;
		      case Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDIDO:
			    	 if(!Permiso.check("ordenesPagosCircuitoPasarRendido")) {
						  return ok(sinPermiso.render(request().getHeader("referer")));
					 }
			    	 pasarRendido(oc.id);
		    	 break;    
		      case Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CANCELADO:
			    	 if(!Permiso.check("ordenesPagosCircuitoPasarCancelado")) {
						  return ok(sinPermiso.render(request().getHeader("referer")));
					 }
			    	 pasarCancelado(oc.id);
		    	 break;    	 
		     default:
		         System.out.println("error" );
		         break;
		      }
			  
		}	 
		
		return redirect(controllers.contabilidad.routes.OrdenesPagosCircuitosController.ver(oc.id) + UriTrack.get("&"));
	}
	
	public static void pasarEnBorrador(Long idOc,OrdenPagoCircuito oco){
		try {
			Ebean.beginTransaction();
			OrdenPagoCircuito oc = Ebean.find(OrdenPagoCircuito.class).select("id, estado_id").setId(idOc).findUnique();
			List<OrdenPagoCircuito> ocol = new ArrayList<OrdenPagoCircuito>();
			ocol.add(oco);
			if(pasarExpediente(ocol,Organigrama.TESORERIA)){
				if(oc != null){			
					oc.estado_id = new Long(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_BORRADOR);
					oc.save();
					Ebean.commitTransaction();
					flash("success", "Operación exitosa. Estado actual: Borrador");
					
				} else {
					flash("error", "Parámetros incorrectos");
				}
			}	
			
		} catch (Exception e) {
			flash("error", "Parámetros incorrectos");
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();  
		}	
	}
	
	public static void pasarContabilidad(Long idOc,OrdenPagoCircuito oco){
		
		try {
			Ebean.beginTransaction();
			
			List<OrdenPagoCircuito> ocol = new ArrayList<OrdenPagoCircuito>();
			ocol.add(oco);
			if(pasarExpediente(ocol,Organigrama.CONTABILIDAD)){
				OrdenPagoCircuito oc = Ebean.find(OrdenPagoCircuito.class).select("id, estado_id,fecha_contabilidad").setId(idOc).findUnique();
				
				if(oc != null){			
					oc.estado_id = new Long(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CONTABILIDAD);
					oc.fecha_contabilidad = new Date();
					oc.save();
					
					Organigrama o = Organigrama.find.byId(Organigrama.CONTABILIDAD);
					String success = "Operación exitosa. Estado actual: Contabilidad<br>";
					success += "Se ingreso movienmiento del expediente "+oco.expediente.getExpedienteEjercicio()+" al servicio "+o.nombre;
					flash("success", success);
					Ebean.commitTransaction();
					
				} else {
					flash("error", "Parámetros incorrectos");
				}
			}
			
		} catch (Exception e) {
			flash("error", "Parámetros incorrectos");
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();  
		}	
	}
	
	public static void pasarRendiciones(Long idOc,OrdenPagoCircuito oco){
		
		try {
			Ebean.beginTransaction();
			List<OrdenPagoCircuito> ocol = new ArrayList<OrdenPagoCircuito>();
			ocol.add(oco);
			if(pasarExpediente(ocol,Organigrama.RENDICIONES)){
				OrdenPagoCircuito oc = Ebean.find(OrdenPagoCircuito.class).select("id, estado_id,fecha_rendiciones").setId(idOc).findUnique();
				
				if(oc != null){			
					oc.estado_id = new Long(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDICIONES);
					oc.fecha_rendiciones = new Date();
					oc.save();
					
					Organigrama o = Organigrama.find.byId(Organigrama.RENDICIONES);
					String success = "Operación exitosa. Estado actual: Rendiciones<br>";
					success += "Se ingreso movienmiento del expediente "+oco.expediente.getExpedienteEjercicio()+" al servicio "+o.nombre;
					flash("success", success);
					Ebean.commitTransaction();
				} else {
					flash("error", "Parámetros incorrectos");
				}
		 	}
			
		} catch (Exception e) {
			flash("error", "Parámetros incorrectos");
			Ebean.rollbackTransaction();
		} finally {
			Ebean.endTransaction();  
		}
	}
	
	public static void pasarRendido(Long idOc){
		
		OrdenPagoCircuito oc = Ebean.find(OrdenPagoCircuito.class).select("id, estado_id,fecha_rendicion").setId(idOc).findUnique();
		
		if(oc != null){			
			oc.estado_id = new Long(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_RENDIDO);
			oc.fecha_rendicion = new Date();
			oc.save();
			flash("success", "Operación exitosa. Estado actual: Rendido");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	public static void pasarCancelado(Long idOc){
		
		OrdenPagoCircuito oc = Ebean.find(OrdenPagoCircuito.class).select("id, estado_id,fecha_contabilidad,fecha_rendiciones,fecha_rendicion").setId(idOc).findUnique();
		
		if(oc != null){			
			oc.estado_id = new Long(Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CANCELADO);
			oc.fecha_contabilidad = null;
			oc.fecha_rendiciones = null;
			oc.fecha_rendicion = null;
			oc.update();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	private static OrdenPagoCircuito loadModel(Long id) throws NoRecordModelException {
		OrdenPagoCircuito orden = OrdenPagoCircuito.find.byId(id);
		if (orden == null) {
			flash("error", "La orden de pago ya no existe.");
			throw new NoRecordModelException();
		}
		return orden;
	}
	
	public static boolean pasarExpediente(List<OrdenPagoCircuito> ocl,Long orgaId){
		Organigrama o = Organigrama.find.byId(orgaId);
		
		if(ocl.size() > 0 && o != null) {
			
			if(Usuario.getUsurioSesion().organigrama == null) {
				flash("error", "No tienes un servicio asignado a tu usuarios. Debes solicitar que se te asignen uno.");
				return false;
			}
			
			if(orgaId == null){
				flash("error", "No tienes un servicio destino.");
				return false;
			}
			
			List<Integer> idsExpedientes = OrdenPagoCircuito.getIdsExpedientes(ocl);
			
			List<Long> soloDeMiServicio = ExpedienteMovimiento.getStringIsNotMovimientoServicioUsuario(idsExpedientes, Usuario.getUsurioSesion().organigrama_id);
			if(soloDeMiServicio.size() > 0 && orgaId.compareTo(Organigrama.TESORERIA) != 0){
				String error = "Solo se puede modificar realizar movimientos donde el expediente se encuentren en mi servicio "+Usuario.getUsurioSesion().organigrama.nombre+" <br>";
				//error += "Expedientes que no se encuentan en mi servicio:<br>";
				flash("error", error);
				return false;
			}
			
			try {
				Integer count = ExpedienteMovimiento.pasarOtroServicioMasivoConOps(idsExpedientes,ocl, orgaId, "");
				
				return true;
			} catch (Exception e){
				flash("error", "No se puede modificar los registros.");
				return false;
			}	
		}else{
			flash("error", "No se pudo crear el movimiento del expediente.");
			return false;
		}
		
	}
	
}
