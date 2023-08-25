package controllers.patrimonio;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import models.ActaMovimiento;
import models.ActaRecepcion;
import models.ActaRecepcionLinea;
import models.ActaRecepcionLineaAjuste;
import models.AuditoriaRegistro;
import models.AutorizadoLinea;
import models.AutorizadoLineaActa;
import models.Dispo;
import models.Ejercicio;
import models.Estado;
import models.Pago;
import models.Producto;
import models.UltimaCotizacion;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.patrimonio.actaRecepcion.*;
import views.html.patrimonio.actaRecepcion.modales.modalAsignarActaRecepcion;
import views.html.patrimonio.remitos.crearRemito;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class ActasRecepcionController extends Controller {
	final static Form<ActaRecepcion> oForm = form(ActaRecepcion.class);
	
	@CheckPermiso(key = "actaRecepcionVer")
	public static Result index(){

		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		Pagination<ActaRecepcion> actas = ActaRecepcion.page(RequestVar.get("id"), 
															 RequestVar.get("numero"), 
															 RequestVar.get("orden_provision"),
															 RequestVar.get("expediente_id"),
															 RequestVar.get("proveedor_id"), 
															 RequestVar.get("orden_compra"), 
															 RequestVar.get("fecha_desde"), 
															 RequestVar.get("fecha_hasta"), 
															 RequestVar.get("tipo"),
															 RequestVar.get("ejercicio"),
															 RequestVar.get("btnFiltro[0]"),//borrador
															 RequestVar.get("btnFiltro[1]"),//en curso
															 RequestVar.get("btnFiltro[2]"),//preajuste
															 RequestVar.get("btnFiltro[3]"),//aprobado
															 RequestVar.get("btnFiltro[4]"),//Cancelado
															 RequestVar.get("orden_rubro_id"),
															 RequestVar.get("deposito_id"),
															 RequestVar.get("profe"),
															 RequestVar.get("tipo_moneda"),
															 RequestVar.get("tipo_cuenta_id"),
															 RequestVar.get("emergencia"),
															 RequestVar.get("organigrama_id")
				);
		
		return ok(indexActaRecepcion.render(actas, d, pf));
	}
	
	
	public static Result indexAjax(){
		DynamicForm d = form().bindFromRequest();
		
		Pagination<ActaRecepcion> actas = ActaRecepcion.page(RequestVar.get("id"), 
															 RequestVar.get("numero"), 
															 RequestVar.get("orden_provision"), 
															 RequestVar.get("expediente_id"), 
															 RequestVar.get("proveedor_id"), 
															 RequestVar.get("orden_compra"), 
															 RequestVar.get("fecha_desde"), 
															 RequestVar.get("fecha_hasta"), 
															 RequestVar.get("tipo"), 
															 RequestVar.get("ejercicio"),
															 RequestVar.get("btnFiltro[0]"),//borrador
															 RequestVar.get("btnFiltro[1]"),//en curso
															 RequestVar.get("btnFiltro[2]"),//preajuste
															 RequestVar.get("btnFiltro[3]"),//aprobado
															 RequestVar.get("btnFiltro[4]"),//Cancelado
															 RequestVar.get("orden_rubro_id"),
															 RequestVar.get("deposito_id"),
															 RequestVar.get("profe"),
															 RequestVar.get("tipo_moneda"),
															 RequestVar.get("tipo_cuenta_id"),
															 RequestVar.get("emergencia"),
															 RequestVar.get("organigrama_id")
															);
		

		return ok(indexActaRecepcionAjax.render(actas, d));
	}
	
	public static Result verModal(Long id){
		ActaRecepcion acta = ActaRecepcion.find.byId(id);
		
		return ok();
	}

	@CheckPermiso(key = "actaRecepcionVer")
	public static Result ver(Long id){
		ActaRecepcion acta = ActaRecepcion.find
				  .select("id, numero, fecha, total, cierre, ajustes, totalLineasAjustes,observaciones,nota_interna")
				  .fetch("ordenProvision", "numero")
				  .fetch("estado", "nombre")
				  .fetch("periodo", "nombre")
				  .fetch("create_usuario", "nombre")
				  .fetch("ordenProvision.ordenCompra","profe,tipo_moneda,tipo_cuenta_id")
			 	  .fetch("ordenProvision.ordenCompra.proveedor", "nombre")
			 	  .fetch("ordenProvision.ordenCompra.deposito", "nombre")
				  .fetch("ordenProvision.ordenCompra.ordenRubro", "nombre")
				  .fetch("ordenProvision.ordenCompra.expediente", "nombre, emergencia")
				  .fetch("ordenProvision.ordenCompra.expediente.ejercicio", "nombre")
				  .fetch("ordenProvision.ordenCompra.expediente.parent.ejercicio", "nombre")
			 	  .fetch("ordenProvision.ordenCompra.tipoCuenta", "nombre")
			 	  .fetch("ejercicio", "nombre")
			 	  .fetch("ejercicio", "nombre")
			 	  .where().eq("id", id).findUnique();
		
		Date fechaDispo = null;
		if(acta != null) {
			if(!acta.controlPermisoDeposito()) {
				flash("error", "El acta de la orden no corresponde a su institucion asignada.");
				return redirect(controllers.patrimonio.routes.ActasRecepcionController.index()+UriTrack.get("?"));
			}
			
			List<Dispo> d = Dispo.find.where().eq("expediente_id", acta.ordenProvision.ordenCompra.expediente_id).orderBy("id asc").findList();
			if(d.size() > 0) {
				fechaDispo = d.get(0).fecha;
			}
			
			PaginadorFicha pf = new PaginadorFicha(UriTrack.code());
			return ok(verActaRecepcion.render(acta,pf,fechaDispo));
		}else {
			flash("error", "No se encuentra el Acta");
			return redirect(controllers.patrimonio.routes.ActasRecepcionController.index()+UriTrack.get("?"));
		}
	}
	
	@CheckPermiso(key = "actaRecepcionCrear")
	public static Result crear(){
		
		Form<ActaRecepcion> actaRecepcionForm = form(ActaRecepcion.class);
		actaRecepcionForm.discardErrors();
		
		return ok(crearActaRecepcion.render(actaRecepcionForm));
	}
	
	@CheckPermiso(key = "actaRecepcionCrear")
	public static Result guardar() {
		
		Form<ActaRecepcion> actaRecepcionForm = form(ActaRecepcion.class).bindFromRequest();
		/*if(actaRecepcionForm.field("orden_provision_id").value().isEmpty()){
			actaRecepcionForm.reject("orden_provision_id","La orden de provision es obligatoria.");
			return badRequest(crearActaRecepcion.render(actaRecepcionForm));
		}*/
		
		if(actaRecepcionForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearActaRecepcion.render(actaRecepcionForm));
		}
		
		
		
		try {
			ActaRecepcion c = actaRecepcionForm.get();
			ActaRecepcion n = ActaRecepcion.find.where().eq("numero", c.numero).eq("ejercicio_id", c.ejercicio_id).findUnique();
			
			if(n != null) {
				flash("error", "En número de acta ya existe");
				return badRequest(crearActaRecepcion.render(actaRecepcionForm));
			}
			
			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return redirect(controllers.patrimonio.routes.ActasRecepcionController.index()+UriTrack.get("?"));
			}
			
			c.create_date = new Date();
			c.create_usuario_id = Usuario.getUsuarioSesion();
			c.estado_id = new Long(Estado.ACTA_ESTADO_BORRADOR);
			c.auto_creacion = true;
			c.save();
			
			flash("success", "El acta se ha actualizado");
			return redirect(controllers.patrimonio.routes.ActasRecepcionController.ver(c.id)+UriTrack.get("&"));
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el acta.");
			return badRequest(crearActaRecepcion.render(actaRecepcionForm));
		}
	}
	
	@CheckPermiso(key = "actaRecepcionCrear")
	public static Result editar(Long id){
		ActaRecepcion acta = ActaRecepcion.find.byId(id);
		
		if(acta.estado_id == Estado.ACTA_ESTADO_APROBADA || acta.estado_id == Estado.ACTA_ESTADO_ENCURSO || acta.estado_id == Estado.ACTA_ESTADO_CANCELADA){
			flash("error", "No se puede editar en este estado, debe estar en borrador.");
			return redirect(request().getHeader("referer"));
		}
		if(!acta.controlPermisoDeposito()) {
			flash("error", "La institucion no corresponde a su institucion asignada.");
			return redirect(controllers.patrimonio.routes.ActasRecepcionController.index()+UriTrack.get("?"));
		}
		return ok(editarActaRecepcion.render(form(ActaRecepcion.class).fill(acta),acta));
	}
	
	@CheckPermiso(key = "actaRecepcionCrear")
	public static Result actualizar(){

		Form<ActaRecepcion> actaForm = form(ActaRecepcion.class).bindFromRequest();
		
		/*if(actaForm.field("orden_provision_id").value().isEmpty()){
			actaForm.reject("orden_provision_id","La orden de provision es obligatoria.");
			return badRequest(editarActaRecepcion.render(actaForm));
		}*/
		ActaRecepcion a = actaForm.get();
		if(actaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarActaRecepcion.render(actaForm,a));
		}
		
		//ActaRecepcion a = actaForm.get();
		ActaRecepcion ax = ActaRecepcion.find.byId(a.id);
		
		if(ax.ordenProvision.ordenCompra.tipo_moneda != null && a.cot_dolar == null) {
			flash("error", "Debe Ingresar una cotizacion ya que es un expediente en Moneda Extranjera");
			return badRequest(editarActaRecepcion.render(actaForm,a));
		}else if(ax.ordenProvision.ordenCompra.tipo_moneda == null && a.cot_dolar != null) {
			flash("error", "No debe Ingresar una cotizacion ya que no es un expediente en Moneda Extranjera");
			return badRequest(editarActaRecepcion.render(actaForm,a));
		}
		
		
		ActaRecepcion n = ActaRecepcion.find.where().eq("numero", a.numero).eq("ejercicio_id", a.ejercicio_id).ne("id", a.id).findUnique();
		
		if(n != null) {
			flash("error", "En número de acta ya existe");
			return badRequest(editarActaRecepcion.render(actaForm,a));
		}
		
		
		try {		
			if(!a.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return redirect(controllers.patrimonio.routes.ActasRecepcionController.index()+UriTrack.get("?"));
			}
			a.update();
	
			flash("success", "El acta de recepción se ha creado correctamente");
			return redirect(controllers.patrimonio.routes.ActasRecepcionController.ver(a.id)+UriTrack.get("&"));
		} catch (PersistenceException pe){
			play.Logger.error("excepcion");
			flash("error", "No se pudo modificar el acta de recepción");
			return badRequest(editarActaRecepcion.render(actaForm,a));
		}

	}

	@CheckPermiso(key = "actaRecepcionEliminar")
	public static Result eliminar(Long id) {
		
		ActaRecepcion acta = ActaRecepcion.find.byId(id);
		
		if(acta.estado_id == Estado.ACTA_ESTADO_APROBADA || acta.estado_id == Estado.ACTA_ESTADO_ENCURSO || acta.estado_id == Estado.ACTA_ESTADO_CANCELADA){
			flash("error", "No se puede eliminar en este estado, debe estar en borrador.");
			return redirect(request().getHeader("referer"));
		}
		
		if( !acta.recepciones.isEmpty() ) {
			flash("error", "No se puede eliminar actas con recepciones asignadas.");
			return redirect(controllers.patrimonio.routes.ActasRecepcionController.ver(id)+UriTrack.get("&"));
		}
		
		
		String numero = acta.numero;
		try {
			acta.delete();
			AuditoriaRegistro.registrar("actas_recepcion", id);
			flash("success", "Se ha eliminado el acta número <b>"+numero+"</b>.");
			return redirect(controllers.patrimonio.routes.ActasRecepcionController.index()+UriTrack.get("?"));
		} catch (Exception e) {
			flash("error", "Problemas al eliminar el acta.");
			return redirect(controllers.patrimonio.routes.ActasRecepcionController.ver(id)+UriTrack.get("&"));
		}

	}
	
	public static Result cambiarEstado(Long idActa, Long idEstado) {
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_ACTA);
		
		ActaRecepcion acta = ActaRecepcion.find.byId(idActa);
		
		if(acta == null){
			flash("error", "No se encuentra el acta de recepción.");
			return redirect(request().getHeader("referer"));
		}
		
		if(!acta.controlPermisoDeposito()) {
			flash("error", "La institucion no corresponde a su institucion asignada.");
			return redirect(request().getHeader("referer"));
		}
		
		switch ( idEstado.intValue() ) {
	      case  Estado.ACTA_ESTADO_BORRADOR:
	    	  if(!Permiso.check("actaPasarBorrador")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarEnBorrador(acta);
	    	  break;
	      case  Estado.ACTA_ESTADO_ENCURSO:
	    	  if(!Permiso.check("actaPasarCurso")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  
	    	  if(acta.ordenProvision.ordenCompra.tipo_moneda != null && acta.cot_dolar == null) {
	  			flash("error", "Debe Ingresar una cotizacion ya que es un expediente en Moneda Extranjera");
	  			return redirect(request().getHeader("referer"));
	    	  }	
	    	  
	    	 
	    	  if(acta.auto_creacion != true && acta.ordenProvision.ordenCompra.tipo_orden.equals("comun")) {
	    		  if (acta.recepciones.size() <= 0) {
		    		  flash("error", "Para dar curso al acta debe recepcionar productos.");
		    		  return redirect(request().getHeader("referer"));
	    		  }

	    	  } else if(acta.auto_creacion != true && acta.ordenProvision.ordenCompra.tipo_orden.equals("servicio")) {
	    		  if(acta.certificaciones.size() <=0 ) {
	    			  flash("error", "Para dar curso al acta debe contener certificaciones de servicio.");
	    			  return redirect(request().getHeader("referer"));
	    		  }
	    	  }
	    	  
	    	  

	    	  pasarEnCurso(acta);
	    	  break;
	      case Estado.ACTA_ESTADO_CANCELADA:
	    	  if(!Permiso.check("actaPasarCancelado")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  pasarEnCancelado(acta);   
	          break;
	      case Estado.ACTA_ESTADO_PRECALCULAR_AJUSTES:
	    	  if(!Permiso.check("actaPasarPrecalularAjuste")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }
	    	  
	    	  if(acta.ordenProvision.ordenCompra.tipo_moneda != null && acta.cot_dolar == null) {
	    		  flash("error", "Debe Ingresar una cotizacion ya que es un expediente en Moneda Extranjera");
	    		  return redirect(request().getHeader("referer"));
		  	  }	
	    	  
	    	  
	    	  
	    	  pasarEnPreCalcularAjustes(acta);   
	          break;    
	      case Estado.ACTA_ESTADO_APROBADA:
	    	  
	    	  if(acta.ordenProvision.ordenCompra.tipo_moneda != null && acta.cot_dolar == null) {
	  			flash("error", "Debe Ingresar una cotizacion ya que es un expediente en Moneda Extranjera");
	  			return redirect(request().getHeader("referer"));
		  	  }else if(acta.ordenProvision.ordenCompra.tipo_moneda == null && acta.cot_dolar != null) {
		  			flash("error", "No debe Ingresar una cotizacion ya que no es un expediente en Moneda Extranjera");
		  			return redirect(request().getHeader("referer"));
		  	  }
	    	  
	    	  if(acta.ordenProvision.ordenCompra.expediente.ejercicio_id.compareTo(new Long(5)) <= 0){
	    		  flash("error", "No se puede Aprobar el Acta con Expediente con ejercicio menor o igual al 2016");
    			  return redirect(request().getHeader("referer"));
	    	  }
	    	  
	    	  
	    	  if(acta.periodo_id == null && acta.ordenProvision.ordenCompra.orden_rubro_id == 7){
	    		  flash("error", "No se puede Aprobar el Acta. Las ordenes de servicios deben llevar un periodo asignado.");
    			  return redirect(request().getHeader("referer"));
	    	  }
	    	  
	    	  if(!Permiso.check("actaPasarAprobado")) {
				  return ok(sinPermiso.render(request().getHeader("referer")));
			  }


	  		  if (acta.ordenProvision.ordenCompra.fecha_provision == null) {
	  			flash("error", "No se puede asignar acta porque la Orden no tiene Fecha de Provision Asignada.");
	  			return redirect(request().getHeader("referer"));
	  		  }

	    	  pasarEnAprobado(acta);
	          break;
	      default:
	           break;
		}
		
		return redirect(controllers.patrimonio.routes.ActasRecepcionController.ver(acta.id)+UriTrack.get("&"));
	}
	
	

	
	
	public static void pasarEnBorrador(ActaRecepcion acta){
		try {
			acta.estado_id = new Long(Estado.ACTA_ESTADO_BORRADOR);
			acta.write_date = new Date();
			acta.write_usuario_id = Usuario.getUsuarioSesion();
			acta.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} catch (Exception e) {
			flash("error", "No se pudo cambiar el estado.");
		}
	}
	
	public static void pasarEnCancelado(ActaRecepcion acta){
		try {
			
			List<Integer> actasSeleccionados = new ArrayList<Integer>();
			actasSeleccionados.add(acta.id.intValue());
			if(soloDeMiServicio(actasSeleccionados).size() >0) {
				flash("error", "Solo se pueden cancelar actas q se encuentren en mi servicio.");
			}else {
				List<AutorizadoLineaActa> ala = AutorizadoLineaActa.find.where().eq("acta_recepcion_id", acta.id).findList();
				
				if(ala.size() > 0){
					flash("error", "No se pudo cambiar el estado. El acta se encuentra asociada al AUTORIZADO "+ala.get(0).autorizadoLinea.autorizado.id);
				}else{
					acta.estado_id = new Long(Estado.ACTA_ESTADO_CANCELADA);
					acta.write_date = new Date();
					acta.write_usuario_id = Usuario.getUsuarioSesion();
					acta.save();
					actualizarVistaMaterializada();
					flash("success", "Operación exitosa. Estado actual: Cancelado");
				}
			}
			
			
			
			
			
			
		} catch (Exception e) {
			flash("error", "No se pudo cambiar el estado."+e);
		}
	}
	
	public static void pasarEnCurso(ActaRecepcion acta){
		try {
			acta.estado_id = new Long(Estado.ACTA_ESTADO_ENCURSO);
			acta.write_date = new Date();
			acta.write_usuario_id = Usuario.getUsuarioSesion();
			acta.save();
			flash("success", "Operación exitosa. Estado actual: En Curso");
		} catch (Exception e) {
			flash("error", "No se pudo cambiar el estado.");
		}
	}
	
	public static void pasarEnPreCalcularAjustes(ActaRecepcion acta){
		
		
		try {
			
			
			//ACA VOY A SACAR LOS AJUSTE Q HAY Q INSERTAR BASADO EN LA COTIZACION DE LA ORDEN Y EN LA COTIZACION DEL ACTA
			
			Map<Long,BigDecimal> montos = new HashMap<Long,BigDecimal>();
			
			List<ActaRecepcionLinea> alineas = ActaRecepcionLinea.getQuery().where().eq("acta_id", acta.id).findList();
			
			for(ActaRecepcionLinea xl: alineas) {
				
				if(montos.containsKey(xl.cuentaAnalitica.id)) {
					BigDecimal tmp = montos.get(xl.cuentaAnalitica.id);
					BigDecimal total = tmp.add(xl.getTotal());
					montos.put(xl.cuentaAnalitica.id, total);
					
				}else {
					montos.put(xl.cuentaAnalitica.id, xl.getTotal());
				}
			}
			
			
			Logger.debug("------------------ "+montos);
			BigDecimal totalAjusteAAgregar = new BigDecimal(0);
			 
			Ejercicio ejercicioActual  = Ejercicio.getEjercicioByFecha(new Date());
			for (Entry<Long,BigDecimal> mx : montos.entrySet()){
				
				BigDecimal difeCotizacion = acta.cot_dolar.subtract(acta.ordenProvision.ordenCompra.cot_dolar);
				
				BigDecimal actaCot_dolar = acta.cot_dolar;
				Logger.debug("difeCotizacion0: "+difeCotizacion);
				if(acta.ordenProvision.ordenCompra.expediente.ejercicio_id.compareTo(ejercicioActual.id) != 0) {
					BigDecimal ultimaCoti =  UltimaCotizacion.
							getUltimaCotizacionAnualDelExpediente(acta.ordenProvision.ordenCompra.expediente.ejercicio_id,
									acta.ordenProvision.ordenCompra.tipo_moneda.longValue());
					
					difeCotizacion = ultimaCoti.subtract(acta.ordenProvision.ordenCompra.cot_dolar);
					actaCot_dolar = ultimaCoti;
				}
				Logger.debug("difeCotizacion0: "+difeCotizacion);
				Logger.debug("acta.ordenProvision.ordenCompra.expediente.ejercicio_id: "+acta.ordenProvision.ordenCompra.expediente.ejercicio_id);
				Logger.debug("ejercicioActual.id: "+ejercicioActual.id);
				
				
				BigDecimal totalDolar = mx.getValue().divide(acta.ordenProvision.ordenCompra.cot_dolar, 2, RoundingMode.HALF_UP);//valor en dolares
				//BigDecimal ajusteAAgregar = totalDolar.multiply(difeCotizacion);
				
				//BigDecimal totalDolar = mx.getValue().divide(acta.ordenProvision.ordenCompra.cot_dolar, 2, RoundingMode.HALF_UP);//valor en dolares
				
				
				BigDecimal ajusteAAgregar = (totalDolar.multiply(actaCot_dolar)).subtract(mx.getValue()).setScale(2, RoundingMode.HALF_UP);;
				
				
				Logger.debug("difeCotizacion1: "+difeCotizacion);
				Logger.debug("totalDolar: "+totalDolar);
				Logger.debug("difeCotizacion2: "+UltimaCotizacion.getUltimaCotizacionAnualDelExpediente(acta.ordenProvision.ordenCompra.expediente.ejercicio_id,
						acta.ordenProvision.ordenCompra.tipo_moneda.longValue()));
				Logger.debug("------------------------ ");
				Logger.debug("acta.cot_dolar: "+acta.cot_dolar);
				Logger.debug("acta.ordenProvision.ordenCompra.cot_dolar: "+acta.ordenProvision.ordenCompra.cot_dolar);
				Logger.debug("difeCotizacion4: "+difeCotizacion);
				Logger.debug("ajusteAAgregar: "+ajusteAAgregar);
				
				ActaRecepcionLineaAjuste arl = new ActaRecepcionLineaAjuste();
				arl.acta_id = acta.id;
				arl.cantidad = new BigDecimal(1);
				arl.create_date = new Date();
				arl.create_usuario_id = Usuario.getUsuarioSesion().longValue();
				arl.precio = ajusteAAgregar;
				arl.cuenta_analitica_id = mx.getKey();
				arl.producto_id = Producto.ID_PRODUCTO_DIFERENCIA_CAMBIO_1;
				arl.udm_id= (long)1;
				arl.save();
				
				totalAjusteAAgregar  = totalAjusteAAgregar.add(ajusteAAgregar);
			}
			
			
			String ret = "Se agregaron Ajustes por un TOTAL de: "+utils.NumberUtils.moneda(totalAjusteAAgregar)+"</br>"; 
			//-------------------------------------------------
			
			
			acta.estado_id = new Long(Estado.ACTA_ESTADO_PRECALCULAR_AJUSTES);
			acta.write_date = new Date();
			acta.write_usuario_id = Usuario.getUsuarioSesion();
			acta.save();
			
			
			
			flash("success",ret+"Operación exitosa. Estado actual: Precalcular Ajustes");
		} catch (Exception e) {
			flash("error", "No se pudo cambiar el estado."+e);
		}
	}
	
	public static void pasarEnAprobado(ActaRecepcion acta){
		
		
		try {
			
			
			//controlo los ajuste de diferencia de cotizacion 
			boolean controlMontosAjustesDiferenciaCotizacion = ActaRecepcionLineaAjuste.controlMontosAjustesDiferenciaCotizacion(acta);
			
			Logger.debug("controlMontosAjustesDiferenciaCotizacion:"+controlMontosAjustesDiferenciaCotizacion);
			Logger.debug("controlMontosAjustesDiferenciaCotizacion.compareTo(BigDecimal.ZERO):");
			//controlMontosAjustesDiferenciaCotizacion = false;
			if(controlMontosAjustesDiferenciaCotizacion) {
				
				flash("error", "EL monto de ajustes en actas supera el monto de ajuste en ordenes");
				
			}else {
			
			
			
			
				acta.estado_id = new Long(Estado.ACTA_ESTADO_APROBADA);
				acta.write_date = new Date();
				acta.write_usuario_id = Usuario.getUsuarioSesion();
				acta.save();
				actualizarVistaMaterializada();
				
				AutorizadoLinea al = new AutorizadoLinea();
				al.cargarLineasSinActas(acta);
				
				List<Pago> listPagos = Pago.find.where().eq("expediente_id", acta.ordenProvision.ordenCompra.expediente_id).findList(); 
				
				String p = ""; 
				if(listPagos.size() > 0){
					p = "  ESTE EXPEDIENTE TIENE PAGOS.</br>";
				}
				
				List<Integer> idActa = new ArrayList<Integer>();
				idActa.add(acta.id.intValue());
				
				ActaMovimiento.pasarOtroServicioMasivo(idActa, Usuario.getUsurioSesion().organigrama_id, "Autoasignacion");
				
				
				flash("success", p+"Operación exitosa. Estado actual: Aprobado");
			 
			}
			
		} catch (Exception e) {
			flash("error", "No se pudo cambiar el estado."+e);
		}
	}
	
	public static void actualizarVistaMaterializada () {
		
		//Ebean.createSqlUpdate("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada").execute();
		Connection conn = play.db.DB.getConnection();
		Statement stmt = null;
		try {
		    stmt = conn.createStatement();
		    stmt.execute("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada;");
		    stmt.execute("REFRESH MATERIALIZED VIEW informe_deuda_actas_materializada;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
		    	stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static List<Long> soloDeMiServicio(List<Integer> actasSeleccionados) {
		
		List<Long> ret = ActaMovimiento.getStringIsNotMovimientoServicioUsuario(actasSeleccionados, Usuario.getUsurioSesion().organigrama_id);
		
		return ret;
	}
	
	public static Result getPacientes(Long id){
		Map<Integer,Map<String,String>> pacientes = ActaRecepcion.getPacientes(id);
		return ok(listaPacientes.render(pacientes));
	}
}
