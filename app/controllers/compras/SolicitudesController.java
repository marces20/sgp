package controllers.compras;

import static play.data.Form.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import models.BalancePresupuestario;
import models.CuentaAnalitica;
import models.Ejercicio;
import models.Estado;
import models.Orden;
import models.OrdenLinea;
import models.OrdenLineaCliente;
import models.Solicitud;
import models.SolicitudLinea;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.EncondeUriBase64;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.sinPermiso;
import views.html.compras.solicitudes.crearSolicitud;
import views.html.compras.solicitudes.editarSolicitud;
import views.html.compras.solicitudes.indexSolicitud;
import views.html.compras.solicitudes.modalBusquedaSolicitudes;
import views.html.compras.solicitudes.verSolicitud;
import views.html.compras.solicitudes.modales.modalEditarCuentaAnalitica;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class SolicitudesController extends Controller {
	
	final static Form<Solicitud> solicitudForm = form(Solicitud.class);
	
	public static Result URL_LISTA_SOLICITUD = redirect(
			controllers.compras.routes.SolicitudesController.index()
	);

	public static Result redirectSearchIndex(String searchIndex) throws IOException{
		String search = EncondeUriBase64.dencode(searchIndex);
		
		return redirect(search);
	}
	
	@CheckPermiso(key = "solicitudesComprasVer")
	public static Result index() throws IOException {		
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		
		return ok(
				 indexSolicitud.render(
						 				Solicitud.page(
											 RequestVar.get("referencia"),
											 RequestVar.get("responsable_id"),
											 RequestVar.get("paciente_id"),
											 RequestVar.get("expediente_id"),
											 RequestVar.get("servicio_id"),
											 RequestVar.get("estado"),
											 RequestVar.get("ejercicio"),
											 RequestVar.get("desde"),
											 RequestVar.get("hasta"),
											 RequestVar.get("producto_id"),
											 RequestVar.get("pedido_rismi"),
											 RequestVar.get("profe"),
											 RequestVar.get("recuperable"),
											 RequestVar.get("solicitante_id"),
											 RequestVar.get("nro_liquidacion_parque"),
											 RequestVar.get("fdesdepreventiva"),
											 RequestVar.get("fhastapreventiva"),
											 RequestVar.get("cuenta_analitica_padre_id"),
											 RequestVar.get("obrasocial_id"),
											 RequestVar.get("tipo_cuenta_id"),
											 RequestVar.get("repo_stock"),
											 RequestVar.get("emergencia"),
											 RequestVar.get("entregado"),
											 RequestVar.get("asignacion_usuario_id")
											 ),
						 				d,EncondeUriBase64.encode(request().uri()),
						 				pf
						 			  )
				);

	}
	
	public static Result cambiarEstado(Long idSolicitud, Long idEstado, String searchIndex) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_SOLICITUD);
		
		Solicitud solicitud = Solicitud.find.byId(idSolicitud);
		
		if(solicitud == null){
			flash("error", "No se encuentra la solicitud.");
			return redirectSearchIndex(searchIndex);
		}
		
		if((solicitud.expediente_id != null && solicitud.lineas.isEmpty()) && (idEstado != Estado.SOLICITUD_ESTADO_CANCELADO && idEstado != Estado.SOLICITUD_ESTADO_BORRADOR)){
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(controllers.compras.routes.SolicitudesController.ver(solicitud.id,searchIndex));
		}
		
		Integer sl = SolicitudLinea.find.where().eq("solicitud_id",solicitud.id).isNull("cuenta_analitica_id").findRowCount();
		if(sl > 0 ){
			flash("error", "No puede cambiar de estado con lineas que no contengan Cuenta presupuestaria.");
			return redirect(controllers.compras.routes.SolicitudesController.ver(solicitud.id,searchIndex));
		}

		if(idEstado != null){
			
			Boolean permiso = false;
			
			switch ( idEstado.intValue() ) {
		      case  Estado.SOLICITUD_ESTADO_BORRADOR:
		    	  if(!Permiso.check("solicitudesPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(solicitud.id,searchIndex);
		    	  break;
		      case Estado.SOLICITUD_ESTADO_ENCURSO:
		    	  if(!Permiso.check("solicitudesComprasPasarCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnCurso(solicitud.id,searchIndex);
		    	  break;      
		      case Estado.SOLICITUD_ESTADO_PREAPROBADO:
		    	  if(!Permiso.check("solicitudesPasarPreaprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarPreaprobado(solicitud.id,searchIndex);
		    	  break;      	  
		      case Estado.SOLICITUD_APROBADO_JEFE:
		    	  if(!Permiso.check("solicitudesPasarAprobadoJefe")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobadoJefe(solicitud.id,searchIndex); 
		    	  break;
		      case Estado.SOLICITUD_ESTADO_ADEPTO:
		    	  if(!Permiso.check("solicitudesPasarAprobadoJefeDepto")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobadoJefeDepto(solicitud.id,searchIndex); 
		    	  break;	  
		      case Estado.SOLICITUD_ESTADO_ADMINISTRACION:
		    	  if(!Permiso.check("solicitudesPasarAprobadoAdministracion")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobadoAdministracion(solicitud.id,searchIndex); 
		    	  break;
		      case Estado.SOLICITUD_ESTADO_APRESUPUESTO:
		    	  if(!Permiso.check("solicitudAprobadoPorPresupuesto")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobadoPresupuesto(solicitud.id,searchIndex); 
		    	  break;
		      case Estado.SOLICITUD_ESTADO_AUTORIZADO:
		    	  if(!Permiso.check("solicitudEstadoAutorizado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAutorizado(solicitud.id,searchIndex);  
		          break;  
		      case Estado.SOLICITUD_ESTADO_CANCELADO:
		    	  if(!Permiso.check("solicitudesComprasPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(solicitud.id,searchIndex);   
		          break;      
		      case  Estado.SOLICITUD_ESTADO_RESERVADO:
		    	  if(!Permiso.check("solicitudesPasarReservado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarReservado(solicitud.id,searchIndex);
		    	  break;    
		      default:
		           break;
		      }
		}
		
		return redirect(controllers.compras.routes.SolicitudesController.ver(solicitud.id,searchIndex));
		
	}
	
	@CheckPermiso(key = "solicitudesComprasCrear")
	public static Result crearSolicitud(String searchIndex) throws IOException {
		 
		Map<String,String> p = new HashMap<String, String>();
		p.put("date_start",DateUtils.formatDate(new Date()));
		p.put("referencia","SOL");
		/*p.put("deposito_id","1");*/
		/*p.put("deposito.nombre","HOSPITAL ESCUELA DE AGUDOS");*/
		Form<Solicitud> solicitud = form(Solicitud.class).bind(p);
		solicitud.discardErrors();
		Solicitud s = null;
		return ok(crearSolicitud.render(solicitud,searchIndex));
	}
	
	@CheckPermiso(key = "solicitudesComprasVer")
	public static Result ver(Long id,String searchIndex) throws IOException {
		Solicitud solicitud = Solicitud.find.byId(id);

		if(solicitud == null){
			flash("error", "No se encuentra la solicitud.");
			return redirectSearchIndex(searchIndex);
		}
		
		return ok(verSolicitud.render(solicitudForm.fill(solicitud),solicitud,searchIndex, new PaginadorFicha(UriTrack.code())));
	}

	@CheckPermiso(key = "solicitudesComprasCrear")
	public static Result guardarSolicitud(String searchIndex) {
		
		Form<Solicitud> solicitudForm = form(Solicitud.class).bindFromRequest();
		validarForm(solicitudForm);
		
		if(solicitudForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearSolicitud.render(solicitudForm,searchIndex));
		}
		Solicitud s = solicitudForm.get();	
		try {
			
			s.estado_id = (long) 1;
			s.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			s.create_date = new Date();
			//s.tipo_cuenta_id = (s.profe)?new Long(2):new Long(1);
			s.save();
			
			flash("success", "La solicitud se creado correctamente");
			return redirect(controllers.compras.routes.SolicitudesController.editar(solicitudForm.get().id,searchIndex) );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la solicitud");
			return badRequest(crearSolicitud.render(solicitudForm,searchIndex));
		}
		
	}
	
	@CheckPermiso(key = "solicitudesComprasModificar")
	public static Result editar(Long id,String searchIndex) throws IOException {
		
		Solicitud solicitud = Solicitud.find.byId(id);

		if(solicitud == null){
			flash("error", "No se encuentra la solicitud.");
			return redirectSearchIndex(searchIndex);
		}else if(solicitud.estado_id == Estado.SOLICITUD_ESTADO_CANCELADO || solicitud.estado_id == Estado.SOLICITUD_ESTADO_APRESUPUESTO || solicitud.estado_id == Estado.SOLICITUD_ESTADO_AUTORIZADO){
			flash("error", "La solicitud no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}
		return ok(editarSolicitud.render(solicitudForm.fill(solicitud), solicitud,searchIndex));
	}
	
	@CheckPermiso(key = "solicitudesComprasModificar")
	public static Result actualizar(Long id,String searchIndex){
		Form<Solicitud> solicitudForm = form(Solicitud.class).bindFromRequest();
		Solicitud solicitudView = Solicitud.find.byId(id);	
		
		validarForm(solicitudForm);

		if(solicitudForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarSolicitud.render(solicitudForm, solicitudView,searchIndex));
		}

		try {	
			Solicitud solicitud = solicitudForm.get();
			Integer cliente_id = solicitud.cliente_id;
			
			
			Solicitud s = Solicitud.find.byId(id);
			solicitud.estado_id = s.estado_id;
			solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			solicitud.write_date = new Date();
			//solicitud.tipo_cuenta_id = (solicitud.profe)?new Long(2):new Long(1);
			solicitud.update();
			
			if (cliente_id == null) {
				String cd = "update solicitudes set cliente_id = null where id = :id";
				SqlUpdate update = Ebean.createSqlUpdate(cd).setParameter("id", s.id);
				update.execute();
			}
			
			
			flash("success", "La solicitud se ha actualizado correctamente.");
			return redirect( controllers.compras.routes.SolicitudesController.ver(solicitud.id,searchIndex) );			
		} catch (Exception e) {
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar la solicitud");
			return badRequest(editarSolicitud.render(solicitudForm, solicitudView,searchIndex));
		}

	}
	
	@CheckPermiso(key = "solicitudesComprasEliminar")
	public static Result eliminar(Long id,String searchIndex) throws IOException {
		
		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id").setId(id).findUnique();
		
		if(solicitud == null){
			flash("error", "No se encuentra la solicitud.");
			return redirectSearchIndex(searchIndex);
		}
		
		if(solicitud.estado_id == Estado.SOLICITUD_ESTADO_BORRADOR){
			try {
				solicitud.delete();
				flash("success", "Se ha eliminado la solicitud");
				return redirect(controllers.compras.routes.SolicitudesController.index() + "?" + EncondeUriBase64.dencode(searchIndex));
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar la solicitud");
			}
		} else {
			flash("error", "No se ha podido eliminar la solicitud. Unicamente se puede eliminar cuendo el estado de la solicitud se encuentra en borrador.");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
		
	}
	
	
	@CheckPermiso(key = "solicitudEntregado")
	public static Result modificarEntregado(Long id) throws IOException {
		
		Solicitud solicitud = Solicitud.find.byId(id);
		ObjectNode restJs = Json.newObject();
		
		
		try {
			solicitud.entregado = !solicitud.entregado;		
			restJs.put("succes", true);
			solicitud.save();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);

		
	}
	
	
	@CheckPermiso(key = "solicitudesDuplicar")
	public static Result duplicar(Long id,String searchIndex) throws IOException{
		
		try {
			
			Solicitud solicitud = new Solicitud();
			Long userLogin =  new Long(Usuario.getUsuarioSesion());
			Long idNew = solicitud.duplicar(id,userLogin);
			
			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha duplicado la solicitud");
				return redirect(controllers.compras.routes.SolicitudesController.editar(idNew,searchIndex));
			}else{
				flash("error", "No se ha podido duplicar la solicitud");
				String refererUrl = request().getHeader("referer");
				return redirect(refererUrl);
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido duplicar la solicitud");
		}
		
		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	public static Result suggestSolicitud(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode solicitud = rpta.arrayNode();
	    
	    Solicitud ad = new Solicitud();
		 
		for(Solicitud a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.referencia);
	        restJs.put("info", "");
	        solicitud.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", solicitud);
		 
		return ok(response);
	}
	
	public static void validarForm(Form<Solicitud> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("date_start", "Fecha inválida"));
		v.add(new DateValidation("date_end", "Fecha inválida"));
		v.add(new DateValidation("fecha_imputacion", "Fecha inválida"));
		v.validate();
	}
	
	public static void pasarEnBorrador(Long idSolicitud,String searchIndex){
		
		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id,write_date,write_usuario_id").setId(idSolicitud).findUnique();
		
		if(solicitud != null){			
			
			solicitud.estado_id = new Long(Estado.SOLICITUD_ESTADO_BORRADOR);
			solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			solicitud.write_date = new Date();
			solicitud.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	
	public static void pasarEnCurso(Long idSolicitud,String searchIndex){
		
		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id,write_date,write_usuario_id,profe").setId(idSolicitud).findUnique();
		
		Integer sl = SolicitudLinea.find.where()
				.eq("solicitud_id", solicitud.id)
				.disjunction().isNull("precio_estimado").isNull("cantidad").endJunction()
				.findRowCount();
		
		
		if(sl > 0){
			flash("error", "No se pueden poner en curso solicitudes con lineas con monto cero.");
		}/*else if(!Solicitud.controlTildeProfe(solicitud) && (solicitud.profe == null || !solicitud.profe)){
			flash("error", "Debe seleccionar el tilde PROFE para la solicitudes con cuentas PROFE.");
		}*/else{	
			if(solicitud != null){			
				solicitud.estado_id = new Long(Estado.SOLICITUD_ESTADO_ENCURSO);
				solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				solicitud.write_date = new Date();
				solicitud.save();
				flash("success", "Operación exitosa. Estado actual: En curso");
			} else {
				flash("error", "Parámetros incorrectos");
			}
		}
	}
	
	public static void pasarAprobadoJefe(Long idSolicitud,String searchIndex){
		
		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id,write_date,write_usuario_id").setId(idSolicitud).findUnique();
		
		if(solicitud != null){			
			
			solicitud.estado_id = new Long(Estado.SOLICITUD_APROBADO_JEFE);
			solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			solicitud.write_date = new Date();
			solicitud.save();
			flash("success", "Operación exitosa. Estado actual: Aprobado por Jefe de Servicio");
		} else {
			flash("error", "Parámetros incorrectos");
		}
		
	}
	
	public static void pasarAprobadoJefeDepto(Long idSolicitud,String searchIndex){
		
		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id,write_date,write_usuario_id").setId(idSolicitud).findUnique();
		
		if(solicitud != null){			
			
			solicitud.estado_id = new Long(Estado.SOLICITUD_ESTADO_ADEPTO);
			solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			solicitud.write_date = new Date();
			solicitud.save();
			flash("success", "Operación exitosa. Estado actual: Aprobado por Jefe de Departamento");
		} else {
			flash("error", "Parámetros incorrectos");
		}
		
	}
	 
	public static void pasarPreaprobado(Long idSolicitud,String searchIndex){
		
		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id,write_date,write_usuario_id").setId(idSolicitud).findUnique();
		
		if(solicitud != null){			
			
			solicitud.estado_id = new Long(Estado.SOLICITUD_ESTADO_PREAPROBADO);
			solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			solicitud.write_date = new Date();
			solicitud.save();
			flash("success", "Operación exitosa. Estado actual: Preaprobado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
		
	}
	
	
	
	public static void pasarAprobadoAdministracion(Long idSolicitud,String searchIndex){
		
		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id, expediente,write_date,write_usuario_id").setId(idSolicitud).findUnique();
		 
		if(solicitud.expediente != null){
			if(solicitud != null){			
				solicitud.estado_id = new Long(Estado.SOLICITUD_ESTADO_ADMINISTRACION);
				solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				solicitud.write_date = new Date();
				solicitud.save();
				flash("success", "Operación exitosa. Estado actual: Aprobado por Administracion");
			} else {
				flash("error", "Parámetros incorrectos");
			}
		}else{
			flash("error", "Debe ingresar un expediente a la solicitud para poder aprobarla.");
		}

	}
	
	public static void pasarAprobadoPresupuesto(Long idSolicitud,String searchIndex){
		
		//Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id,expediente_id,fecha_imputacion,write_date,write_usuario_id").setId().findUnique();
		Solicitud solicitud = Solicitud.find.byId(idSolicitud);
		
		List<SolicitudLinea> sl = SolicitudLinea.find.where()
								 .eq("solicitud_id",solicitud.id).in("cuenta_analitica_id", CuentaAnalitica.getCuentasProfe()).findList();
		
		if(solicitud.tipo_cuenta_id != null) {
			if(solicitud.tipo_cuenta_id == 2 && sl.size() < 1){
				flash("error", "Solo debe seleccionar la cuenta PROFE cuando las cuentas presupuestarias son PROFE");
				return;
			} 
			
			if(solicitud.tipo_cuenta_id != 2 && sl.size() >= 1){
				flash("error", "Debe seleccionar la cuenta PROFE si las cuentas presupuestarias son PROFE");
				return;
			}
		}else {
			if(solicitud.tipo_cuenta_id.compareTo(new Long(2)) == 0 && sl.size() < 1){
				flash("error", "Solo debe marcar la cuenta PROFE cuando las cuentas presupuestarias son PROFE");
				return;
			} 
			
			if(solicitud.tipo_cuenta_id.compareTo(new Long(2)) != 0 && sl.size() > 1){
				flash("error", "Debe marcar la cuenta PROFE cuando las cuentas presupuestarias son PROFE");
				return;
			} 
		}
		
		Ejercicio ejercicioActual  = Ejercicio.getEjercicioByFecha(new Date());
		if(!Permiso.check("ordenesAjustesAnoNoCorriente") && solicitud.expediente.ejercicio_id.compareTo(ejercicioActual.id) != 0){
			flash("error", "Solo tiene permisos para aprobar solicutudes del año corriente.");
			return;
		}
		
		
		if(solicitud.cliente_id != null){
			if(solicitud.cliente.obrasocial_id == null){
				flash("error", "El paciente debe tener cargada la Obra Social. Sino tiene se debe cargar SIN CAPACIDAD DE PAGO en la pantalla CLIENTES.");
				return;
			}else{
				if(!solicitud.cliente.obrasocial_id.equals(new Long(442)) && (solicitud.tipo_cuenta_id == 2)){
					flash("error", "El paciente debe tener cargada la Obra Social PROFE cuando la solicutud es PROFE.");
					return;
				}	
			}	
		} 
		
		List<Solicitud> l = new ArrayList<Solicitud>();
		l.add(solicitud);
		
		
		
		ArrayNode a = BalancePresupuestario.controlSaldo(l,solicitud.expediente.ejercicio_id.intValue());
		
		boolean errorControl =  false;
		String aviso = "";
		for(JsonNode o :a){
			
			boolean success = new Boolean(o.get("success").toString());
			String cuenta = o.get("cuenta").toString();
			BigDecimal saldoDisponible =  new BigDecimal(o.get("saldoDisponible").toString());
			BigDecimal saldoAImputar =  new BigDecimal(o.get("saldoAImputar").toString());
			BigDecimal saldoPresente =  new BigDecimal(o.get("saldoPresente").toString());
			
			if(!success){
				errorControl =  true;
				aviso += "No tiene Saldo disponible para la cuenta "+cuenta+"<br>";
				aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}else{
				aviso += "Tiene Saldo disponible para la cuenta "+cuenta+"<br>";
				aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}
		}
		if(errorControl){
			flash("error", aviso);
		}else{
			if(solicitud != null){			
				solicitud.fecha_imputacion = new Date();
				solicitud.estado_id = new Long(Estado.SOLICITUD_ESTADO_APRESUPUESTO);
				solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				solicitud.write_date = new Date();
				solicitud.save();
				
				flash("success", "Operación exitosa. Estado actual: Aprobado por Presupuesto<br>"+aviso);
			} else {
				flash("error", "Parámetros incorrectos");
			}
		}
		 	
	}
	
	public static void pasarAutorizado(Long idSolicitud,String searchIndex){
		
		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id,write_date,write_usuario_id").setId(idSolicitud).findUnique();
		
		if(solicitud != null){			
			
			solicitud.estado_id = new Long(Estado.SOLICITUD_ESTADO_AUTORIZADO);
			solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			solicitud.write_date = new Date();
			solicitud.save();
			flash("success", "Operación exitosa. Estado actual: Autorizado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
		
	}
	
	public static void pasarReservado(Long idSolicitud,String searchIndex){
		
		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id,write_date,write_usuario_id").setId(idSolicitud).findUnique();
		boolean solicitudOk = true;
		String error = "";
		
		
		if(solicitud.estado_id != Estado.SOLICITUD_ESTADO_BORRADOR){
			solicitudOk = false;
			error = "La solicitud debe estar en estado Borrador ";
		}
		
		if(solicitud != null && solicitudOk){			
			solicitud.estado_id = new Long(Estado.SOLICITUD_ESTADO_RESERVADO);
			solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			solicitud.write_date = new Date();
			solicitud.save();
			flash("success", "Operación exitosa. Estado actual: Reservado/Stock");
		} else {
			flash("error", "Parámetros incorrectos "+error);
		}
		
	}
	
	public static void pasarCancelado(Long idSolicitud,String searchIndex){

		Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id,write_date,write_usuario_id").setId(idSolicitud).findUnique();
		boolean solicitudOk = true;
		String error = "";
		
		Integer tieneOrden = Orden.find.where().eq("solicitud_id",solicitud.id).findRowCount();
		if(tieneOrden > 0){
			solicitudOk = false;
			 error = "No se puede cancelar la solicitud porque tiene órdenes de compras asociadas.";
		}
		
		/*if(Usuario.getUsuarioSesion() != 1 && (solicitud.estado_id == Estado.SOLICITUD_ESTADO_APRESUPUESTO || solicitud.estado_id == Estado.SOLICITUD_ESTADO_AUTORIZADO)){
			solicitudOk = false;
			error = "No se puede borrar la solicitud porque esta en estado "+solicitud.estado.nombre;
		}*/
		
		if(solicitud != null && solicitudOk){			
			solicitud.estado_id = new Long(Estado.SOLICITUD_ESTADO_CANCELADO);
			solicitud.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			solicitud.write_date = new Date();
			solicitud.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos. "+error);
		}

	}
	
	public static Result modalEditarCuentaAnalica() {
		            	
		return ok( modalEditarCuentaAnalitica.render(form().bindFromRequest()) );
	}
	
	@CheckPermiso(key = "solicitudesComprasEditarCuentaAnalitica")
	public static Result editarCuentaAnalitica() {
		 
		String ret = "";
		String Error = "";
		String[] solicitudes;
		if(request().body().asFormUrlEncoded().get("check_listado[]") != null){ 
			
			solicitudes = request().body().asFormUrlEncoded().get("check_listado[]");	
		}else if(request().body().asFormUrlEncoded().get("id") != null){
			solicitudes = request().body().asFormUrlEncoded().get("id");	
		}else{
			Error += "<p class='responseError'>- No se encuentra seleccionada una solicitud.</p>";
			return ok( Error+ret );
		}
		
		
		for (String idSolicitud : solicitudes) {
			Solicitud solicitud = Ebean.find(Solicitud.class).select("id, estado_id").setId(Integer.parseInt(idSolicitud)).findUnique();
			
			if(solicitud.estado_id != Estado.SOLICITUD_ESTADO_AUTORIZADO){
				Integer cuentaId = Integer.parseInt(request().body().asFormUrlEncoded().get("cuentaAnalitica_id")[0]);
				
				Ebean.createUpdate(SolicitudLinea.class, "UPDATE solicitud_lineas " +
						"SET cuenta_analitica_id=:cuenta_analitica_id,write_date = :write_date,write_usuario_id = :write_usuario_id " +
						"WHERE solicitud_id=:id")
				.setParameter("cuenta_analitica_id",cuentaId)
				.setParameter("write_date",new Date())
				.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()))
				.setParameter("id", Integer.parseInt(idSolicitud)).execute();

				ret += "<p class='responseOk'>- Se actualiz&oacute; la solicitud "+solicitud.referencia+".</p>";
			
			} else {
				Error += "<p class='responseError'>- No se puede actualizar la solicitud "+solicitud.referencia+" porque se encuentra en estado AUTORIZADO.</p>";
			}
			
		}
		
		
		return ok( Error+ret );
	}
	
	public static Result modalBuscar() {
    	Pagination<Solicitud> p = new Pagination<Solicitud>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Solicitud.find.where().ilike("referencia", "%" + RequestVar.get("referencia") + "%"));
		return ok( modalBusquedaSolicitudes.render(p, form().bindFromRequest()) );
	}
	
	public static Result get(long id){
		Solicitud solicitud = Solicitud.find.select("id, referencia").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(solicitud == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la solicitud");
		} else {
			restJs.put("success", true);
			restJs.put("id", solicitud.id);
			restJs.put("nombre", solicitud.referencia);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
}
