package controllers.contabilidad;

import static play.data.Form.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import models.ActaRecepcion;
import models.AutorizadoLinea;
import models.BalancePresupuestario;
import models.Cuenta;
import models.Ejercicio;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.FacturaActaAsosiada;
import models.FacturaDato;
import models.FacturaLinea;
import models.FacturaMotivoRechazo;
import models.Orden;
import models.Orden349;
import models.OrdenPago;
import models.OrdenProvision;
import models.Pago;
import models.Periodo;
import models.Proveedor;
import models.Usuario;
import models.auth.Permiso;
import models.informes.InformeDeudaProveedoresMaterializada;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.ArrayUtils;
import utils.NoRecordModelException;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.sinPermiso;
import views.html.contabilidad.facturas.*;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class FacturasController extends Controller {
	
	final static Form<Factura> facturaForm = form(Factura.class);
	
	public static Result URL_LISTA_FACTURA_PROVEEDOR = redirect(
			controllers.contabilidad.routes.FacturasController.index() 
	);
	
	@CheckPermiso(key = "facturasVer")
	public static Result vistaFacturasCargadas() {
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		
		
		return ok(vistaFacturasCargadas.render(FacturaDato.pageListado( RequestVar.get("expediente.id"),
																		RequestVar.get("proveedor.id"),
																		RequestVar.get("ordenPago.id")
																		),d, pf) );
		
	}
	
	@CheckPermiso(key = "facturasVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		return ok(
				indexFacturaProveedor.render(
						Factura.page(
								 RequestVar.get("numero_factura"),
								 RequestVar.get("proveedor.id"),
								 RequestVar.get("create_usuario.id"),
								 RequestVar.get("expediente.id"),
								 RequestVar.get("periodo_id"),
								 RequestVar.get("ejercicio"),
								 RequestVar.get("ordenPago.id"),
								 RequestVar.get("fecha_factura_desde"),
								 RequestVar.get("fecha_factura_hasta"),
								 RequestVar.get("fecha_op_desde"),
								 RequestVar.get("fecha_op_hasta"),
								 RequestVar.get("profe"),
								 RequestVar.get("prestador"),
								 RequestVar.get("referencia"),
								 RequestVar.get("tipo_proveedor"),
								 RequestVar.get("fecha_aprobacion_desde"),
								 RequestVar.get("fecha_aprobacion_hasta"),
								 RequestVar.get("btnFiltro[0]"),//borrador
								 RequestVar.get("btnFiltro[1]"),//imputado
								 RequestVar.get("btnFiltro[2]"),//abierta
								 RequestVar.get("btnFiltro[3]"),//pagada
								 RequestVar.get("btnFiltro[4]"),//cancelada
								 RequestVar.get("btnFiltro[5]"),//debedgr
								 RequestVar.get("btnFiltro[6]"),//debeafip
								 RequestVar.get("btnFiltro[7]"),//preaprobada
								 RequestVar.get("btnFiltro[8]"),//rechazada
								 RequestVar.get("btnFiltro[9]"),//precurso
								 RequestVar.get("guardia"),
								 RequestVar.get("desc_ret"),
								 RequestVar.get("cuentaImpuesto.id"),
								 RequestVar.get("acta"),
								 RequestVar.get("tipo_cuenta_id"),
								 RequestVar.get("deposito_id"),
								 RequestVar.get("emergencia")
								 ),
								 d, pf));
	}
	
	@CheckPermiso(key = "facturasVer")
	public static Result ver(Long id) {

		Factura factura = null;

		try {
			factura = loadFactura(id);
			if(!Permiso.check("verExpedientesGuardiasMonotributo") && ArrayUtils.contains(Expediente.EXP_GUARDIA_MONOTRIBUTOS, factura.expediente_id)){
				return URL_LISTA_FACTURA_PROVEEDOR;
			}
		} catch (NoRecordModelException e) {
			return URL_LISTA_FACTURA_PROVEEDOR;
		}

		return ok(verFactura.render(facturaForm.fill(factura),factura,new PaginadorFicha(UriTrack.code())));
	}

	
	public static Result actasAsociadas (Long id) {
		List<FacturaActaAsosiada> a = FacturaActaAsosiada.find.where().eq("factura_id", id).findList();
		
		return ok(contenidoTabActas.render(id, a));
	}
	
	public static Result asignarActasAsociada (Long facturaId, Long actaId) {
		ObjectNode restJs = Json.newObject();
		
		try {
			FacturaActaAsosiada f = new FacturaActaAsosiada();
			f.acta_id = actaId;
			f.factura_id = facturaId;
			f.save();
			restJs.put("success", true);
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		
		return ok(restJs);
	}
	
	public static Result modalSeleccionActaRelacionada(Long facturaId) {
		
		List<FacturaActaAsosiada> fa = FacturaActaAsosiada.find.select("acta_id").where().eq("factura_id", facturaId).findList();
		ArrayList<Long> ids = new ArrayList<>();
		for (FacturaActaAsosiada ff : fa) {
			ids.add(ff.acta_id);
		}
		
		
		Factura f = Factura.find.byId(facturaId);
		List<ActaRecepcion> actas = ActaRecepcion.find.where().eq("ordenProvision.ordenCompra.id", f.orden_id).not(Expr.in("id", ids)).findList();

		return ok(modalBusquedaActasAsociadas.render(facturaId, actas));
	}
	

	
	public static Result eliminarActaAsociada (Long id) {

		ObjectNode restJs = Json.newObject();
		
		try {
			FacturaActaAsosiada.find.byId(id).delete();
			restJs.put("success", true);
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		;
		return ok(restJs);

	}
	
	@CheckPermiso(key = "facturasDuplicar")
	public static Result duplicar(Long id) {
		try {
			
			Factura factura = new Factura();
			
			Long idNew = factura.duplicar(id);
			
			
			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha duplicado la factura");
				return redirect(controllers.contabilidad.routes.FacturasController.editar(idNew)+UriTrack.get("&"));
			}else{
				flash("error", "No se ha podido duplicar la factura");
				String refererUrl = request().getHeader("referer");
				return redirect(refererUrl);
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido duplicar la factura");
		}
		
		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	@CheckPermiso(key = "facturasCrearFacturaParcial")
	public static Result crearFacturaParcial(Long id) throws NoRecordModelException {
		try {
			
			Factura factura = loadFactura(id);
			 
			if((factura.estado_id != Estado.FACTURA_ESTADO_BORRADOR)){
				flash("error", "La factura no se puede crear una factura parcial desde una factura en este Estado. Debe cambiar su estado a borrador");
				return redirect(request().getHeader("referer"));
			}
			
			 
			Long idNew = factura.crear_factura_parcial(id);
			
			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha creado la factura parcial");
				return redirect(controllers.contabilidad.routes.FacturasController.editar(idNew)+UriTrack.get("&"));
			}else{
				flash("error", "No se ha podido crear la factura parcial");
				String refererUrl = request().getHeader("referer");
				return redirect(refererUrl);
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido crear la factura parcial");
		}
		
		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	@CheckPermiso(key = "facturasCrear")
	public static Result crear() {
		Cuenta c = new Cuenta().find.byId((long)94);
		
		Map<String,String> p = new HashMap<String, String>();
		p.put("cuenta.nombre",c.nombre);
		p.put("cuenta_id","94");
		p.put("nombre","FAC");
		
		Form<Factura> facturaForm = form(Factura.class).bind(p);
		facturaForm.discardErrors();
		Factura factura = null;
		return ok(crearFacturaProveedor.render(facturaForm,factura));
	}
	
	public static Result guardar() {
		Form<Factura> facturaForm = form(Factura.class).bindFromRequest();
		Factura factura = null;
		
		if(facturaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearFacturaProveedor.render(facturaForm,factura));
		}
		
		
		try {
			
			Factura f = facturaForm.get();
			
			f.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			f.create_date = new Date();
			f.estado_id = (long) Estado.FACTURA_ESTADO_BORRADOR;
			f.save();

			flash("success", "La factura se ha creado");
			return redirect( controllers.contabilidad.routes.FacturasController.ver( facturaForm.get().id ) + UriTrack.get("&"));
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la factura");
			return badRequest(crearFacturaProveedor.render(facturaForm,factura));
		}
		
		//return URL_LISTA_FACTURA_PROVEEDOR;
	}
															
	public static Result getInfoRetenciones(Long id,Boolean fci) {
		
		Factura factura = Factura.find.byId(id);
		
		return ok(contenidoTabInfoProveedor.render(fci,facturaForm.fill(factura), factura));
	}
	
	@CheckPermiso(key = "facturasModificar")
	public static Result editar(Long id) {
		Factura factura = null;
		
		try {
			factura = loadFactura(id);
			if(!Permiso.check("verExpedientesGuardiasMonotributo") && ArrayUtils.contains(Expediente.EXP_GUARDIA_MONOTRIBUTOS, factura.expediente_id)){
				return URL_LISTA_FACTURA_PROVEEDOR;
			}
			if(factura == null){
				flash("error", "No se encuentra la factura.");
				return redirect(controllers.contabilidad.routes.FacturasController.index()+UriTrack.get("?"));
			}else if((factura.estado_id == Estado.FACTURA_ESTADO_APROBADO || factura.estado_id == Estado.FACTURA_ESTADO_CANCELADO)){
				if(factura.expediente_id != 5261  && factura.expediente_id != 5262 && factura.expediente_id != 5263 && factura.expediente_id != 5922 && factura.expediente_id != 5923 && factura.expediente_id != 5924){
					flash("error", "La factura no se puede editar en este Estado. Debe cambiar su estado a borrador");
					return redirect(request().getHeader("referer"));
				}
			}else if(factura.facturaParciales != null && factura.facturaParciales.size() > 0){
				flash("error", "La factura no se puede editar porque esta parcializada.");
				return redirect(request().getHeader("referer"));
			}
			
			if((factura.numero_factura == null || factura.numero_factura.isEmpty()) && (factura.estado_id == Estado.FACTURA_ESTADO_ENCURSO || (factura.expediente_id == 5261  || factura.expediente_id == 5262 || factura.expediente_id == 5263)) ){
				factura.numero_factura = "C0001-00000XXX";
			}
			
		} catch (NoRecordModelException e) {
			return URL_LISTA_FACTURA_PROVEEDOR;
		}
		
		return ok(editarFacturaProveedor.render(facturaForm.fill(factura), factura));
	}
	
	@CheckPermiso(key = "facturasModificar")
	public static Result actualizar(Long id){
		Factura factura = null;
		
		String guardarPreaprobar[] = request().body().asFormUrlEncoded().get("guardarPreaprobar");
		
		try {
			Form<Factura> facturaForm = form(Factura.class).bindFromRequest();
			factura = loadFactura(id);
			
			validarForm(facturaForm);
			boolean error = false;
			if(facturaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarFacturaProveedor.render(facturaForm, factura));
			}
			
			if(factura.estado_id == Estado.FACTURA_ESTADO_BORRADOR){
				if(facturaForm.get().orden_pago_id != null){
					Integer fa = Factura.find.where().eq("orden_pago_id",facturaForm.get().orden_pago_id).ne("id",factura.id).findRowCount();
					if(fa > 0){
						flash("error", "Ya existe el numero de orden de pago en otra factura.");
						return ok(editarFacturaProveedor.render(facturaForm, factura));
					}
				}
			}
			if(guardarPreaprobar != null){
				String errorString = "";
				if( facturaForm.get().numero_factura == null ||  facturaForm.get().numero_factura.isEmpty()){
					errorString += "- Debe cargar el numero de factura.<br>"; 
					error = true;
				}
				
				if( facturaForm.get().debe_afip != null &&  facturaForm.get().debe_afip == true){
					errorString += "- La factura no puede ser preaprobada pq Debe AFIP.<br>";
					error = true;
				}
				
				
				Date fechaActual = new Date();
				boolean vencimiento322 = (facturaForm.get().fecha_vencimiento_322 != null && facturaForm.get().fecha_vencimiento_322.before(fechaActual));
				boolean debeDgr = ( facturaForm.get().debe_dgr != null &&  facturaForm.get().debe_dgr == true);
						
				if( vencimiento322 || debeDgr){
					if(debeDgr){
						errorString += "- La factura no puede ser preaprobada pq Debe DGR.<br>";
						error = true;
					}
					if(vencimiento322){
						errorString += "- Tiene vencido el 322<br>";
						error = true;
					}
				}
				
				
				if( facturaForm.get().debe_dgr_aguinaldo != null &&  facturaForm.get().debe_dgr_aguinaldo == true){
					errorString += "- La factura no puede ser preaprobada pq Debe DGR aguinaldo.<br>";
					error = true;
				}
				if( facturaForm.get().debe_judicial != null &&  facturaForm.get().debe_judicial == true){
					errorString += "- La factura no puede ser preaprobada pq Debe Judicial.<br>";
					error = true;
				}
				
				//if(facturaForm.get().numero_factura.indexOf("X") > 0){
				//	errorString += "- El numero de factura es incorrecto.";
				//	error = true;
				//}
				
				if(error){
					flash("error", errorString);
					return badRequest(editarFacturaProveedor.render(facturaForm, factura));
				}
			}else{
				//if(facturaForm.get().numero_factura.indexOf("X") > 0){
				//	flash("error", "El numero de factura es incorrecto.");
				//	error = true;
				//}
				
				if(error){
					return badRequest(editarFacturaProveedor.render(facturaForm, factura));
				}
			}
			
			Factura f = facturaForm.get();
			
			if(factura.orden != null){ 
				if(factura.orden.cot_dolar != null && f.cot_dolar == null) {
					flash("error", "La orden de esta factura es en dólar. Debe ingresar la cotización actual del dólar en esta factura.");
					return badRequest(editarFacturaProveedor.render(facturaForm, factura));
				} else if(factura.orden.cot_dolar == null && f.cot_dolar != null) {
					flash("error", "La orden de esta factura no es en dólar, no ingrese cotización.");
					return badRequest(editarFacturaProveedor.render(facturaForm, factura));
				}
			}
			

			if (f.cot_dolar == null) {
				String cd = "update facturas set cot_dolar = null where id = :id";
				SqlUpdate update = Ebean.createSqlUpdate(cd).setParameter("id", id);
				update.execute();
			}
			
			
			if(guardarPreaprobar != null){
				f.fecha_recepcion = new Date();
				f.rechazado = false;
				f.estado_id = new Long(Estado.FACTURA_ESTADO_PREAPROBADO);
				List<Integer> idList = new ArrayList<Integer>();
				idList.add(f.id.intValue());
				FacturaMotivoRechazo.delete(idList);
				
				flash("success", "Operación exitosa. Estado actual: Preaprobado");
			}else{
				f.estado_id = factura.estado_id;
			}
			f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			f.write_date = new Date();
			//f.fecha_vencimiento_322 = (f.fecha_vencimiento_322 == null)?null:f.fecha_vencimiento_322;
			
			f.update();
			
			flash("success", "La factura se ha actualizado");
			return redirect( controllers.contabilidad.routes.FacturasController.ver( id ) + UriTrack.get("&"));
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la factura");
			return badRequest(editarFacturaProveedor.render(facturaForm, factura));
		} catch (NoRecordModelException e) {
			return URL_LISTA_FACTURA_PROVEEDOR;
		}
	}
	
	@CheckPermiso(key = "facturasEliminar")
	public static Result eliminar(Long id) {
		
		try {
			Factura factura = Ebean.find(Factura.class).select("id").setId(id).findUnique();
			
			if (factura == null) {
				flash("error", "La factura solicitada ya no existe.");
				throw new NoRecordModelException();
			}else if(factura.facturaParciales != null && factura.facturaParciales.size() > 0){
				flash("error", "La factura no se puede eliminar porque esta parcializada. Elimine primero sus parciales.");
				return redirect(request().getHeader("referer"));
			}
			
			Integer cantidadFactura = Factura.find.where().eq("orden_id", factura.orden_id).findRowCount();
			
			if(cantidadFactura == 1) {
				Integer op = OrdenProvision.find.where().eq("orden_compra_id", factura.orden_id).findRowCount();
				if(op > 0) {
					flash("error", "Debe eliminar las órdenes de provisión.");
					return redirect(request().getHeader("referer"));
				} 
			}

			factura.delete();
			flash("success", "Se ha eliminado la Factura");
			return redirect( UriTrack.decode() );
			
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la Factura");
		} catch (NoRecordModelException e) {
		}
		 
		return redirect(request().getHeader("referer"));
	}
	
	@CheckPermiso(key = "facturasDatosEliminar")
	public static Result eliminarFacturaDato(Long id) {
		
		try {
			FacturaDato fd = FacturaDato.find.byId(id);
			
			if (fd == null) {
				flash("error", "La factura solicitada ya no existe.");
				throw new NoRecordModelException();
			} 
			
			fd.delete();
			flash("success", "Se ha eliminado el N° Factura");
			//return redirect( UriTrack.decode() );
			return redirect(controllers.contabilidad.routes.FacturasController.ver(fd.factura_id) + UriTrack.get("&"));
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la Factura");
		} catch (NoRecordModelException e) {
		}
		 
		return redirect(request().getHeader("referer"));
	}
	
	public static Result suggestFactura(String input) {
		ObjectNode rpta = Json.newObject();
	    ArrayNode factura = rpta.arrayNode();
	    
	    Factura ad = new Factura();
		 
		for(Factura a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        factura.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", factura);
		 
		return ok(response);
	}
	
	public static void validarForm(Form<Factura> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("fecha_factura", "Fecha inválida"));
		v.add(new DateValidation("fecha_orden_pago", "Fecha inválida"));
		v.add(new DateValidation("fecha_recepcion", "Fecha inválida"));
		v.validate();
	}
	
	private static Factura loadFactura(Long id) throws NoRecordModelException {
		Factura factura = Factura.find.byId(id);
		if (factura == null) {
			flash("error", "La factura solicitada ya no existe.");
			throw new NoRecordModelException();
		}
		return factura;
	}
						  
	public static Result cambiarEstadoAprobado(Long idFactura) throws IOException{
		Factura factura = Factura.find.byId(idFactura);
		
		if(factura == null){
			flash("error", "No se encuentra la factura.");
			return redirect(request().getHeader("referer"));
		}
		
		if(factura.facturaLinea.isEmpty()){
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(request().getHeader("referer"));
		}
		
		if(factura.orden.cot_dolar != null && factura.cot_dolar == null) {
			flash("error", "La orden de esta factura es en dólar. Debe ingresar la cotización actual del dólar en esta factura.");
			return redirect(request().getHeader("referer"));
		} else if(factura.orden.cot_dolar == null && factura.cot_dolar != null) {
			flash("error", "La orden de esta factura no es en dólar, no ingrese cotización.");
			redirect(request().getHeader("referer"));
		}
		
		 List<Factura> facturas = Factura.find.where().eq("orden_id", factura.orden_id).isNotNull("orden_id").eq("state_id", 19).findList();
    	 BigDecimal totalLineas = new BigDecimal(0);
    	 for (Factura f : facturas) {
    		 totalLineas = totalLineas.add(f.getBase());
		 }
    	 totalLineas = totalLineas.add(factura.getBase());
    	 
    	
 		 if(totalLineas.compareTo(factura.orden.getTotalTotal()) > 1 ) {
 			flash("error", "El monto de las facturas aprobadas no puede ser mayor al monto de la orden de compra.");
			return redirect(request().getHeader("referer")); 
 		 }
 		 
 		pasarAprobado(factura.id);
 		return redirect(controllers.contabilidad.routes.FacturasController.ver(factura.id) + UriTrack.get("&"));
	}
	
	public static Result cambiarEstado(Long idFactura, Long idEstado) throws IOException {
		return cambiarEstadoPrecargado(idFactura,idEstado, false);
	}
	
	
	public static Result cambiarEstadoPrecargado(Long idFactura, Long idEstado,boolean precarga) throws IOException{
		
		Factura factura = Factura.find.byId(idFactura);
		
		if(factura == null){
			flash("error", "No se encuentra la factura.");
			return redirect(request().getHeader("referer"));
		}
		
		if(factura.facturaLinea.isEmpty()){
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(request().getHeader("referer"));
		}

		if(factura.orden != null && factura.orden.cot_dolar != null && factura.cot_dolar == null) {
			flash("error", "La orden de esta factura es en dólar. Debe ingresar la cotización actual del dólar en esta factura.");
			return redirect(request().getHeader("referer"));
		} else if(factura.orden != null && factura.orden.cot_dolar == null && factura.cot_dolar != null) {
			flash("error", "La orden de esta factura no es en dólar, no ingrese cotización.");
			redirect(request().getHeader("referer"));
		}
		
		
		if(idEstado != null){
			Boolean permiso = false;
			switch ( idEstado.intValue() ) {
		      case  Estado.FACTURA_ESTADO_BORRADOR:
		    	 if(!Permiso.check("facturasPasaarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				 }
		    	 pasarEnBorrador(factura.id);
		    	 break;
		      case  Estado.FACTURA_ESTADO_PRECURSO:
			    	 if(!Permiso.check("facturasPasarEstadoPreCurso")) {
						  return ok(sinPermiso.render(request().getHeader("referer")));
					 }
			    	 
			    	 /*
			 		 * Comprobar que tenga fecha de orden de provision para realizar el pago
			 		 */
			 	 	if(factura.orden != null) {
			 			Orden ordenCompra = factura.orden;
			 			if( (ordenCompra.tipo_orden.equals("comun") || ordenCompra.tipo_orden.equals("servicio")) && ordenCompra.fecha_provision == null ) {
			 				flash("error", "No se puede pasar a precurso porque la orden no tiene fecha de provisión");
			 				return redirect(request().getHeader("referer")); 
			 			}
			 	 	}
			    	 
			    	pasarEnPrecurso(factura,precarga);
			   break;	 
		      case Estado.FACTURA_ESTADO_ENCURSO:
		    	 if(!Permiso.check("facturasPasarEstadoCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				 }
		    	 pasarEnCurso(factura.id); 
		    	 break;
		      case Estado.FACTURA_ESTADO_APROBADO:
		    	 if(!Permiso.check("facturasPasarEstadoAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				 }
		    	 
		    	 //Total de faturas aprobadas
		    	 List<Factura> facturas = Factura.find.where().eq("orden_id", factura.orden_id).isNotNull("orden_id").eq("state_id", 19).findList();
		    	 BigDecimal totalLineas = new BigDecimal(0);
		    	 for (Factura f : facturas) {
		    		 totalLineas = totalLineas.add(f.getBase());
				 }
		    	 totalLineas = totalLineas.add(factura.getBase());
		    	 
		    	 if(factura.orden != null) {
			 		 if(totalLineas.compareTo(factura.orden.getTotalTotal()) > 1 ) {
			 			flash("error", "El monto de las facturas aprobadas no puede ser mayor al monto de la orden de compra.");
						return redirect(request().getHeader("referer")); 
			 		 }
		    	 }
		    	 
		    	 
		    	 
		    	 /*if(factura.fecha_orden_pago != null){
		 			 
		 			Ejercicio ejActual = Ejercicio.getEjercicioByFecha(new Date()); 
		 			Ejercicio ejOp = Ejercicio.getEjercicioByFecha(factura.fecha_orden_pago); 
		 			
		 			if(ejOp.id.compareTo(ejActual.id) < 0) {
		 				flash("error", "La fecha de OP no debe ser menor al ejercicio actual.");
						return redirect(request().getHeader("referer"));
		 			}
		 		 }*/
		 		 
		 		 
		    	 pasarAprobado(factura.id);
		    	 break;       
		     case Estado.FACTURA_ESTADO_CANCELADO:
		    	 if(!Permiso.check("facturasPasarEstadoCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				 }
		    	 pasarCancelado(factura.id);   
		         break;      
		     case Estado.FACTURA_ESTADO_PREAPROBADO:
		    	 if(!Permiso.check("facturasPasarEstadoPreAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				 }
		    	 pasarPreaprobado(factura.id);   
		         break;      
		      default:
		         System.out.println("error" );
		         break;
		      }
			  
		}	 
		
		return redirect(controllers.contabilidad.routes.FacturasController.ver(factura.id) + UriTrack.get("&"));
	}
	
	public static void pasarEnBorrador(Long idFactura){
		
		Factura factura = Ebean.find(Factura.class).select("id, estado_id,write_date,write_usuario_id").setId(idFactura).findUnique();
		
		Integer tienePago = Pago.find.where().eq("factura_id",factura.id).findRowCount();
		if(tienePago > 0){
			 flash("error", "No se puede cancelar la factura porque tiene pagos asociados.");
			 
		}else{
			if(factura != null){			
				factura.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				factura.write_date = new Date();
				factura.estado_id = new Long(Estado.FACTURA_ESTADO_BORRADOR);
				factura.fecha_pago = null;
				factura.save();
				flash("success", "Operación exitosa. Estado actual: Borrador");
			} else {
				flash("error", "Parámetros incorrectos");
			}
		}
	}
	
	public static void pasarEnPrecurso(Factura factura,boolean precarga){
		String errorString = "";
		
		
		
	 	if(factura.expediente.residuo_pasivo != null && factura.expediente.residuo_pasivo){
			List<Factura> lf = new ArrayList<Factura>();
			lf.add(factura);
			FacturaLinea.modificarCuentaAnaliticaPorFactura(lf);
		}
		
		Boolean error = false;
		
		if(factura != null && !precarga){			
			if(factura.orden_pago_id == null){
				errorString += "Debe cargar el numero de Orden de Pago.<br>";
				error = true;
			}
			 
			if(factura.fecha_orden_pago == null){
				errorString += "Debe cargar la fecha de Orden de Pago.<br>";
				error = true;
			}
			if(factura.periodo_id == null){
				errorString += "Debe cargar un Periodo<br>";
				error = true;
			}
		}
		
		
		if(factura != null){	
			if(!error) {
				
				if(precarga) {
					Periodo p = Periodo.getPeriodoByDate(new Date());
					Ejercicio ej = Ejercicio.getEjercicioByFecha(new Date());
					
					String sql = "SELECT (max(numero)+1) as numero FROM ordenes_pagos WHERE ejercicio_id = :ejercicio_id ";
					SqlRow s = Ebean.createSqlQuery(sql).setParameter("ejercicio_id", ej.id).findUnique();
					
					OrdenPago orden = new OrdenPago();
					orden.ejercicio_id = ej.id;
					orden.fecha = new Date();
					orden.monto = factura.getTotal();
					orden.numero = s.getInteger("numero");
					orden.observacion = "Automatico desde Factura";
					orden.create_usuario_id = new Long(Usuario.getUsuarioSesion());
					orden.create_date = new Date();
					orden.save();
					
					factura.fecha_orden_pago = new Date();
					factura.orden_pago_id = orden.id;
					if(factura.periodo_id == null) {
						factura.periodo_id = p.id.intValue();
					}
					
					
				}
				
				
				
				factura.numero_factura = "C0001-00000";
				factura.debito_automatico = (factura.debito_automatico == null)?false:factura.debito_automatico;
				factura.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				factura.write_date = new Date();
				factura.estado_id = new Long(Estado.FACTURA_ESTADO_PRECURSO);
				factura.save();
				flash("success", "Operación exitosa. Estado actual: Precurso");
			}else{
				flash("error", errorString);
			}
		} else {
			flash("error", "Parámetros incorrectos");
		}
		
	}
	
	public static void pasarPreaprobado(Long idFactura){
		
		Factura factura = Ebean.find(Factura.class).select("id, estado_id,numero_factura,fecha_recepcion," +
															"debe_afip,debe_dgr,debe_dgr_aguinaldo,rechazado,debe_judicial," +
															"write_date,write_usuario_id,fecha_vencimiento_322")
															.setId(idFactura).findUnique();
		
		
		if(factura != null){			
			
			Boolean error = false;
			String errorString = "";
			if(factura.numero_factura == null || factura.numero_factura.isEmpty()){
				errorString += "Debe cargar el numero de factura.<br>";
				error = true;
			}
			if(factura.debe_afip != null && factura.debe_afip == true){
				errorString += "- La factura no puede ser preaprobada pq Debe AFIP.<br>";
				error = true;
			}
			
			Date fechaActual = new Date();
			boolean vencimiento322 = (factura.fecha_vencimiento_322 != null && factura.fecha_vencimiento_322.before(fechaActual));
			boolean debe_dgr = (factura.debe_dgr != null && factura.debe_dgr == true);
			
			if(vencimiento322 || debe_dgr){
				if(debe_dgr){
					errorString += "- La factura no puede ser preaprobada pq Debe DGR.<br>";
					error = true;
				}
				if(vencimiento322){
					errorString += "- Tiene vencido el 322<br>";
					error = true;
				}
			}
			if(factura.debe_dgr_aguinaldo != null && factura.debe_dgr_aguinaldo == true){
				errorString += "- La factura no puede ser preaprobada pq Debe DGR aguinaldo.<br>";
				error = true;
			}
			if(factura.debe_judicial != null && factura.debe_judicial == true){
				errorString += "- La factura no puede ser preaprobada pq Debe Judicial.<br>";
				error = true;
			}
			
			
			
			if(!error) {
				
				factura.fecha_recepcion = new Date();
				factura.fecha_factura = (factura.fecha_factura == null)?new Date():factura.fecha_factura;
				factura.debito_automatico = (factura.debito_automatico == null)?false:factura.debito_automatico;
				factura.rechazado = false;
				factura.estado_id = new Long(Estado.FACTURA_ESTADO_PREAPROBADO);
				factura.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				factura.write_date = new Date();
				factura.save();
				List<Integer> idList = new ArrayList<Integer>();
				idList.add(factura.id.intValue());
				Integer deleteMotivosRechazos = FacturaMotivoRechazo.delete(idList);
				flash("success", "Operación exitosa. Estado actual: Preaprobado");
			}else{
				flash("error", errorString);
			}
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	public static void pasarEnCurso(Long idFactura){
		
		Factura factura = Factura.find.byId(idFactura);
		
		List<Factura> facturas = Factura.find.where().eq("orden_id", factura.orden_id).isNotNull("orden_id").eq("state_id", 19).findList();
   	 	BigDecimal totalLineas = new BigDecimal(0);
   	 	for (Factura f : facturas) {
   	 		totalLineas = totalLineas.add(f.getBase());
		}
   		totalLineas = totalLineas.add(factura.getBase());
   	 
   		if(factura.orden != null && totalLineas.compareTo(factura.orden.getTotalTotal()) > 1 ) {
			flash("error", "El monto de las facturas aprobadas no puede ser mayor al monto de la orden de compra.");
		}else {
		
			if(factura != null){	
				if(factura.debe_judicial != null && factura.debe_judicial){
					flash("error", "No se puede pasar a borrar porque debe judicial.");
				}else{
					factura.write_usuario_id = new Long(Usuario.getUsuarioSesion());
					factura.write_date = new Date();
					factura.estado_id = new Long(Estado.FACTURA_ESTADO_ENCURSO);
					factura.save();
					flash("success", "Operación exitosa. Estado actual: En Curso");
				}
			} else {
				flash("error", "Parámetros incorrectos");
			}
		}
		
	}
	
	public static void pasarCancelado(Long idFactura){

		Factura factura = Ebean.find(Factura.class).select("id, estado_id,write_date,write_usuario_id").setId(idFactura).findUnique();
		Boolean error = false;
		if(factura == null) {
			flash("error", "La factura no existe");
			error = true;
		}
		
		Integer tienePago = Pago.find.where().eq("factura_id",factura.id).ne("state_id", Estado.PAGO_ESTADO_CANCELADO).findRowCount();
		if(tienePago > 0){
			 flash("error", "No se puede cancelar la factura porque tiene pagos asociados.");
			 error = true;
		}
			
		if(!error) {
			factura.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			factura.write_date = new Date();
			factura.estado_id = new Long(Estado.FACTURA_ESTADO_CANCELADO);
			factura.fecha_pago = null;
			factura.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		}

	}
	
	public static void pasarAprobado(Long idFactura){
		 
		//Factura factura = Ebean.find(Factura.class).select("id,orden_id,numero_factura,estado_id,fecha_aprobacion,write_date,write_usuario_id,proveedor_id,periodo_id,expediente_id").setId(idFactura).findUnique();
		
		Factura factura = Factura.find.byId(idFactura);
		
		if(factura == null){
			flash("error", "Parámetros incorrectos");
			return;
		}
		
		if(factura.debito_automatico != null && factura.debito_automatico && factura.fecha_factura == null) {
			flash("error", "La factura con debito automatico debe tener fecha de factura.");
			return;
		}
		
		
		Date vencimiento349 = Orden349.getLastFecha(factura.orden_id);
		if(vencimiento349 != null) {
			if(utils.DateUtils.compareDate(vencimiento349,new Date()) < 0) {
				flash("error", "No se puede aprobar pq tiene vencido el 349.");
				//return;
			}
		}
		
		
		//Control para ver si existe factura con mismo agente, mismo proveedor, mismo periodo
		List<Factura> facturas = Factura.find.where()
				.isNotNull("proveedor.agente_id")
				.eq("proveedor_id", factura.proveedor_id)
				.ne("proveedor_id", Proveedor.PROVEEDOR_COMODIN_PERSONAL)
				.ne("proveedor_id", Proveedor.HABERES_VARIOS)
				.eq("periodo_id", factura.periodo_id)
				.eq("expediente_id", factura.expediente_id)
				.ne("estado_id", Estado.FACTURA_ESTADO_CANCELADO)
				.ne("estado_id", Estado.FACTURA_ESTADO_BORRADOR)
				.ne("id", factura.id)
				.findList();
		
		if(facturas.size() > 1 && Usuario.getUsuarioSesion().compareTo(1) != 0) {
			flash("error", "No se puede aprobar una factura con el mismo expediente, periodo y agente.");
			return;
		}
		
		
		if(factura.orden_id != null && factura.orden.tipo_orden.compareTo("personal") != 0) {
			System.out.println("--------------------111");
			Integer autorizado = AutorizadoLinea.find.where().eq("orden_id", factura.orden_id).findRowCount();
			if(autorizado <= 0) {
				flash("error", "La factura no tiene pagos autorizados.");
				return;	
			}
			System.out.println("--------------------111");
		}
		
		
		List<Factura> lp = new ArrayList<Factura>();
		lp.add(factura);
		ArrayNode a = BalancePresupuestario.controlSaldoPreventivoContraFactura(lp); 
		boolean errorControl =  false;
		String aviso = "";
		for(JsonNode o :a){
			
			boolean success = new Boolean(o.get("success").toString());
			String expediente = o.get("expediente").toString();
																
			BigDecimal saldoPreventivo =  new BigDecimal(o.get("saldoPreventivo").toString());
			BigDecimal saldoAFacturar =  new BigDecimal(o.get("saldoFacturado").toString());
			if(Usuario.getUsuarioSesion().compareTo(103) != 0){
				if(!success){
					errorControl =  true;
					aviso += "No Tiene Saldo Preventivo disponible para la facturar el expediente "+expediente+"<br>";
					aviso += "Saldo Preventivo: "+utils.NumberUtils.moneda(saldoPreventivo)+"<br>";
					aviso += "Saldo a Facturar/Facturado: "+utils.NumberUtils.moneda(saldoAFacturar)+"<br><br>";
				}else{
					aviso += "Tiene Saldo Preventivo disponible para la facturar el expediente "+expediente+"<br>";
					aviso += "Saldo Preventivo: "+utils.NumberUtils.moneda(saldoPreventivo)+"<br>";
					aviso += "Saldo a Facturar/Facturado: "+utils.NumberUtils.moneda(saldoAFacturar)+"<br><br>";
				}
			}
		}
		
		if(errorControl){
			flash("error", aviso);
		}else{
			
			if(factura.numero_factura != null && factura.numero_factura.compareToIgnoreCase("C0001-00000") != 0) {
				FacturaDato fd = new FacturaDato();
				fd.numero_factura = factura.numero_factura;
				fd.factura_id = factura.id;
				fd.orden_id = (factura.orden_id != null)?factura.orden_id.longValue():null;
				fd.monto = factura.base;
				fd.create_date = new Date();
				fd.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				fd.save();
			}
			
			String pr = "";
			
			if(factura.facturaLinea.size() > 0) {
				pr = factura.facturaLinea.get(0).producto.nombre;
			}
			
			factura.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			factura.write_date = new Date();
			factura.fecha_aprobacion = new Date();
			factura.estado_id = new Long(Estado.FACTURA_ESTADO_APROBADO);
			factura.referencia = (factura.debito_automatico != null && factura.debito_automatico && (factura.referencia == null || factura.referencia.isEmpty()))?"FAC"+factura.id.toString()+"-"+pr:factura.referencia;
			factura.save();
			
			
			if(factura.debito_automatico != null && factura.debito_automatico){
				Pago px = Pago.find.where().eq("factura_id", factura.id).findUnique();
				if(px != null){
					PagosController.pasarEnCurso(px.id);
					PagosController.pasarPagado(px.id,true);
					PagosController.pasarConciliado(px.id);
				}
			}
			
			flash("success", "Operación exitosa. Estado actual: Aprobado<br>"+aviso);
		}	
	}
	
	public static Result modalBuscar() {
    	Pagination<Factura> p = new Pagination<Factura>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Factura.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaFacturas.render(p, form().bindFromRequest()) );
	}
	
	public static Result get(long id){
		Factura factura = Factura.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(factura == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la factura");
		} else {
			restJs.put("success", true);
			restJs.put("id", factura.id);
			restJs.put("nombre", factura.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	
}
