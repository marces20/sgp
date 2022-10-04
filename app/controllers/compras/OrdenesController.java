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
import models.Certificacion;
import models.Ejercicio;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.Orden;
import models.OrdenLinea;
import models.OrdenProvision;
import models.Proveedor;
import models.SolicitudLinea;
import models.TipoCuenta;
import models.Usuario;
import models.auth.Permiso;
import models.recupero.RecuperoPlanilla;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NoRecordModelException;
import utils.RequestVar;
import utils.StringUtils;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.sinPermiso;
import views.html.compras.lineasAjustesOrdenes.crearLineaAjuste;
import views.html.compras.ordenes.crearOrden;
import views.html.compras.ordenes.editarOrden;
import views.html.compras.ordenes.indexOrden;
import views.html.compras.ordenes.modalBusquedaOrdenes;
import views.html.compras.ordenes.verOrden;
import views.html.compras.ordenes.modales.modalEditarCuentaAnalitica;
import views.html.recupero.recuperoFactura.crearRecuperoFactura;
import views.html.recupero.recuperoFactura.editarRecuperoFactura;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class OrdenesController extends Controller {
	
	final static Form<Orden> ordenForm = form(Orden.class);
	
	public static Result URL_LISTA_ORDEN = redirect(
			controllers.compras.routes.OrdenesController.index()
	);
	
	@CheckPermiso(key = "ordenesComprasVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		return ok(
				indexOrden.render(
						Orden.page(
								 RequestVar.get("nombre"),
								 RequestVar.get("create_usuario.id"),
								 RequestVar.get("proveedor.id"),
								 RequestVar.get("paciente_id"),
								 RequestVar.get("expediente.id"),
								 RequestVar.get("ejercicio"),
								 RequestVar.get("numero_orden_provision_desde"),
								 RequestVar.get("numero_orden_provision_hasta"),
								 RequestVar.get("fecha_fin_desde"),
								 RequestVar.get("fecha_fin_hasta"),
								 RequestVar.get("fecha_provision_desde"),
								 RequestVar.get("fecha_provision_hasta"),
								 RequestVar.get("btnFiltro[0]"),//borrador
								 RequestVar.get("btnFiltro[1]"),//en curso
								 RequestVar.get("btnFiltro[2]"),//aprobado
								 RequestVar.get("btnFiltro[3]"),//Cancelado
								 RequestVar.get("btnFiltro[4]"),//Precurso
								 RequestVar.get("producto_id"),
								 RequestVar.get("orden_rubro_id"),
								 RequestVar.get("deposito_id"),
								 RequestVar.get("tipo_moneda"),
								 RequestVar.get("profe"),
								 RequestVar.get("tipo_cuenta_id"),
								 RequestVar.get("emergencia"),
								 RequestVar.get("perimido")
								),
								 d, pf));
	}
	
	public static Result cambiarEstado(Long idOrden, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_ORDEN);
		
		Orden orden = Orden.find.byId(idOrden);
		
		if(orden == null){
			flash("error", "No se encuentra la orden.");
			return redirect(request().getHeader("referer"));
		}
		
		if((orden.expediente_id == null || orden.ordenLinea.isEmpty()) && (idEstado != Estado.ORDEN_ESTADO_BORRADOR && idEstado != Estado.ORDEN_ESTADO_CANCELADO)){
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(request().getHeader("referer"));
		}
		
		/*Integer sl = OrdenLinea.find.where().eq("orden_id",orden.id).isNull("cuenta_analitica_id").findRowCount();
		if(sl > 0 ){
			flash("error", "No puede cambiar de estado con lineas que no contengan cuenta presupuestaria.");
			return redirect(request().getHeader("referer"));
		}*/
		
		if(orden.proveedor_id == Proveedor.PROVEEDOR_COMODIN_PERSONAL && 
				!(orden.tipo_orden == null  || orden.tipo_orden.compareToIgnoreCase("imputacion") == 0) && orden.estado_id != Estado.ORDEN_ESTADO_CANCELADO){
			flash("error", "Error en formulario. Debe seleccionar un proveedor.");
			return redirect(request().getHeader("referer"));
		}
		
		if(idEstado != null){
			 
			Boolean permiso = false;
			
			switch ( idEstado.intValue() ) {
		      case  Estado.ORDEN_ESTADO_BORRADOR:
		    	  if(!Permiso.check("ordenesCompraPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(orden.id);
		    	  break;
		      case Estado.ORDEN_ESTADO_PRECURSO:
		    	  if(!Permiso.check("ordenesCompraPasarPreCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnPreCurso(orden.id);
		    	  break;     	  
		      case Estado.ORDEN_ESTADO_ENCURSO:
		    	  if(!Permiso.check("ordenesCompraPasarCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnCurso(orden.id);
		    	  break;       
		      case Estado.ORDEN_ESTADO_APROBADO:
		    	  if(!Permiso.check("ordenesCompraPasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobado(orden.id); 
		    	  break;
		      case Estado.ORDEN_ESTADO_FINALIZADO:
		    	  if(!Permiso.check("ordenesCompraPasarFinalizado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarFinalizado(orden.id); 
		    	  break;
		      case Estado.ORDEN_ESTADO_CANCELADO:
		    	  if(!Permiso.check("ordenesCompraPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(orden.id);   
		          break;      
		      default:
		           System.out.println("error" );
		           break;
		      }
			
			  
			
		}	 
		
		return redirect(controllers.compras.routes.OrdenesController.ver(orden.id)+ UriTrack.get("&"));
	}
	
	@CheckPermiso(key = "ordenesComprasVer")
	public static Result ver(Long id) {
		Orden orden = Orden.find.byId(id);
		if(orden != null){
			if(!orden.controlPermisoDeposito()) {
				flash("error", "La institucion de la orden no corresponde a su institucion asignada.");
				return redirect(controllers.compras.routes.OrdenesController.index()+UriTrack.get("?"));
			}
			
			Form<Orden> ordenForm = form(Orden.class).fill(orden);
			OrdenProvision op = OrdenProvision.find.where().eq("orden_compra_id",id).findUnique();
			
			return ok(verOrden.render(ordenForm, orden,op, new PaginadorFicha(UriTrack.code())));
		}else {
			flash("error", "No se encuentra la Orden");
			return redirect(controllers.compras.routes.OrdenesController.index()+UriTrack.get("?"));
		}
	}
	
	@CheckPermiso(key = "ordenesComprasCrear")
	public static Result crear() {
		Map<String,String> p = new HashMap<String, String>();
		p.put("fecha_orden",DateUtils.formatDate(new Date()));
		p.put("nombre","ORD");
		p.put("creacion_automatica","true");
		Form<Orden> orden = form(Orden.class).bind(p);
		orden.discardErrors();
		
		return ok(crearOrden.render(orden));
	}
	
	@CheckPermiso(key = "ordenesComprasCrear")
	public static Result guardar() {
		
		Form<Orden> ordenForm = form(Orden.class).bindFromRequest();
		
		validarForm(ordenForm);
		
		System.out.println(ordenForm.errorsAsJson());
		
		if(ordenForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearOrden.render(ordenForm));
		}
		
		if(ordenForm.get().proveedor_id == Proveedor.PROVEEDOR_COMODIN_PERSONAL && (!(ordenForm.get().tipo_orden.compareToIgnoreCase("imputacion") == 0))){
			flash("error", "Error en formulario. Debe seleccionar un proveedor.");
			return badRequest(crearOrden.render(ordenForm));
		}
		
		if(ordenForm.get().tipo_orden.compareToIgnoreCase("comun")  != 0 && ordenForm.get().monto_adelanto != null){
			flash("error", "Solo se puede poner monto adelanto para la recepcion de productos.");
			return badRequest(crearOrden.render(ordenForm));
		}
		
		if(ordenForm.get().tipo_orden.compareToIgnoreCase("comun")  == 0 || ordenForm.get().tipo_orden.compareToIgnoreCase("servicio")  == 0) {
			if(ordenForm.get().numero_presupuesto == null || ordenForm.get().numero_presupuesto.isEmpty()){
				flash("error", "Debe ingresar un N° de Presupuesto.");
				return badRequest(crearOrden.render(ordenForm));
			}
		}
		
		
		try {
			Orden o = ordenForm.get();
			
			if(o.numero_orden_provision != null && o.expediente_id != null){
				Expediente ex = Expediente.find.byId(o.expediente_id);
				//Ejercicio ej = Ejercicio.find.byId(ex.ejercicio_id); 
				List<Orden> lop  = Orden.find.where()
						   .eq("numero_orden_provision", o.numero_orden_provision)
						   .eq("expediente.ejercicio_id",ex.ejercicio_id).findList();
				
				if(lop.size() > 0){
					flash("error", "Ya existe este numero de orden de Provision cargada en otra orden");
					return badRequest(crearOrden.render(ordenForm));
				}			
			}
			
			if(o.cot_dolar != null) {
				if(o.cot_dolar.compareTo(BigDecimal.ZERO) <= 0) {
					flash("error", "Seleccione un monto de cotizacion mayor a cero");
					return badRequest(crearOrden.render(ordenForm));
				}
			}
			
			if(!o.controlPermisoDeposito()) {
				flash("error", "La institucion de la orden no corresponde a su institucion asignada.");
				return badRequest(crearOrden.render(ordenForm));
			}
			
			o.estado_id = (long) Estado.ORDEN_ESTADO_BORRADOR;
			o.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			o.create_date = new Date();
			o.save();
			flash("success", "La orden se ha actualizado");
			return redirect( controllers.compras.routes.OrdenesController.ver(ordenForm.get().id) );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la orden");
			return badRequest(crearOrden.render(ordenForm));
		}
		//return URL_LISTA_ORDEN;
	}
	
	@CheckPermiso(key = "ordenesComprasModificar")
	public static Result editar(Long id) {
		
		Orden orden = Ebean.find(Orden.class, id);
		if(orden == null){
			flash("error", "No se encuentra la orden.");
			return redirect(controllers.compras.routes.OrdenesController.index()+UriTrack.get("?"));
		}else if(orden.estado_id == Estado.ORDEN_ESTADO_APROBADO || orden.estado_id == Estado.ORDEN_ESTADO_CANCELADO){
			flash("error", "La orden no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}else if(!orden.controlPermisoDeposito()) {
			flash("error", "La orden institucion no corresponde a su institucion asignada.");
			return redirect(controllers.compras.routes.OrdenesController.index()+UriTrack.get("?"));
		}
		
		
		return ok(editarOrden.render(ordenForm.fill(orden),orden));
	}
	
	@CheckPermiso(key = "ordenesComprasModificar")
	public static Result actualizar(Long id){
		
		Form<Orden> ordenForm = form(Orden.class).bindFromRequest();
		validarForm(ordenForm);
		Orden orden = Ebean.find(Orden.class, id);
		
		if(ordenForm.hasErrors()) {
			flash("error", "Error en formulario ");
			return badRequest(editarOrden.render(ordenForm,orden));
		}
		
		if (ordenForm.get().proveedor_id == Proveedor.PROVEEDOR_COMODIN_PERSONAL && (!(ordenForm.get().tipo_orden.compareToIgnoreCase("imputacion") == 0))&& orden.estado_id != Estado.ORDEN_ESTADO_BORRADOR)
		{
			flash("error", "Error en formulario. Debe seleccionar un proveedor.");
			return badRequest(editarOrden.render(ordenForm,orden));
		}
		 
		if(ordenForm.get().tipo_orden.compareToIgnoreCase("comun")  != 0 && ordenForm.get().monto_adelanto != null){
			flash("error", "Solo se puede poner monto adelanto para la recepcion de productos.");
			return badRequest(editarOrden.render(ordenForm,orden));
		}
		
		if(ordenForm.get().tipo_orden.compareToIgnoreCase("comun")  == 0 || ordenForm.get().tipo_orden.compareToIgnoreCase("servicio")  == 0) {
			if(ordenForm.get().numero_presupuesto == null || ordenForm.get().numero_presupuesto.isEmpty()){
				flash("error", "Debe ingresar un N° de Presupuesto.");
				return badRequest(editarOrden.render(ordenForm,orden));
			}
		} 
		Logger.debug("uuuuuuuuuuuuuuuuuuuuuuu "+ordenForm.get().numero_presupuesto);
		
		try {
			Orden o = ordenForm.get();
			 
			 
			if(o.numero_orden_provision != null && o.expediente_id != null){
				Expediente ex = Expediente.find.byId(o.expediente_id);
				//Ejercicio ej = Ejercicio.find.byId(ex.ejercicio_id); 
				List<Orden> lop  = Orden.find.where()
						   .ne("id", id)
						   .eq("numero_orden_provision", o.numero_orden_provision)
						   .eq("expediente.ejercicio_id",ex.ejercicio_id).findList();
				
				if(lop.size() > 0){
					flash("error", "Ya existe este numero de orden de Provision cargada en otra orden");
					return badRequest(editarOrden.render(ordenForm,orden));
				}			
			}
			
			
			if(o.cot_dolar != null) {
				if(o.cot_dolar.compareTo(BigDecimal.ZERO) <= 0) {
					flash("error", "Seleccione un monto de cotizacion mayor a cero");
					return badRequest(editarOrden.render(ordenForm,orden));
				}
				if(o.tipo_moneda == null) {
					flash("error", "Seleccione un tipo de moneda");
					return badRequest(editarOrden.render(ordenForm,orden));
				}
			}
			
			if(!o.controlPermisoDeposito()) {
				flash("error", "La institucion de la orden no corresponde a su institucion asignada.");
				return badRequest(editarOrden.render(ordenForm,orden));
			}
			
			Orden s = Orden.find.byId(id);
			o.estado_id = s.estado_id;
			o.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			o.write_date = new Date();
			o.update();
			
			flash("success", "La orden se ha actualizado");
			return redirect( controllers.compras.routes.OrdenesController.ver(ordenForm.get().id)+ UriTrack.get("&"));
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la Orden");
			return badRequest(editarOrden.render(ordenForm,orden));
		}
		
		//return URL_LISTA_ORDEN;
	}
	
	@CheckPermiso(key = "ordenesComprasEliminar")
	public static Result eliminar(Long id) {
		
		Orden orden = Ebean.find(Orden.class).select("id, estado_id").setId(id).findUnique();
		
		if(orden == null){
			flash("error", "No se encuentra la orden.");
			return redirect(UriTrack.decode());
		}
		
		if(orden.estado_id == Estado.ORDEN_ESTADO_BORRADOR){
			try {
				orden.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				orden.write_date = new Date();
				orden.save();
				orden.delete();
				
				flash("success", "Se ha eliminado la orden");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar la orden");
			}
		} else {
			flash("error", "No se ha podido eliminar la orden. Unicamente se puede eliminar cuando el estado de la orden se encuentra en borrador o cancelado.");
		}

		String refererUrl = request().getHeader("referer");
		//return redirect(refererUrl);
		return redirect(UriTrack.decode());
	}
	
	@CheckPermiso(key = "ordenesComprasDuplicar")
	public static Result duplicar(Long id) throws IOException{
		
		try {
			
			Orden orden = new Orden();
			
			Long idNew = orden.duplicar(id);
			
			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha duplicado la orden");
				return redirect(controllers.compras.routes.OrdenesController.editar(idNew)+UriTrack.get("&"));
			}else{
				flash("error", "No se ha podido duplicar la orden");
				String refererUrl = request().getHeader("referer");
				return redirect(refererUrl);
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido duplicar la orden");
		}
		
		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	public static Result suggestOrden(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode ordenes = rpta.arrayNode();
	    
	    Orden ad = new Orden();
		 
		for(Orden a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.nombre);
	        restJs.put("info", "");
	        ordenes.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", ordenes);
		 
		return ok(response);
	}
	
	public static Result modalArticulo() {
		
		return ok();
	}
	
	public static void validarForm(Form<Orden> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("fecha_orden", "Fecha inválida"));
		v.add(new DateValidation("fecha_provision", "Fecha inválida"));
		v.add(new DateValidation("fecha_inicio", "Fecha inválida"));
		v.add(new DateValidation("fecha_fin", "Fecha inválida"));
		v.validate();
	}
	
	@CheckPermiso(key = "ordenesComprasModificarCuentaAnalitica")
	public static Result modalEditarCuentaAnalica(String tipo) {
    	
		return ok( modalEditarCuentaAnalitica.render(form().bindFromRequest() , tipo) );
	}
	
	@CheckPermiso(key = "ordenesComprasModificarCuentaAnalitica")
	public static Result editarCuentaAnalitica() {
		 
		String ret = "";
		String Error = "";
		System.out.println("+++++++++++++++++++++++++++++");
		
		if(request().body().asFormUrlEncoded().get("tipo") != null){ 
			
			String[] ordenes = null;
			
			if(request().body().asFormUrlEncoded().get("tipo")[0].compareToIgnoreCase("editar") == 0){
					
				if(request().body().asFormUrlEncoded().get("check_listado[]") != null){ 
					ordenes = request().body().asFormUrlEncoded().get("check_listado[]");	
					
					String s = StringUtils.implode(ordenes);
					
					Integer cuentaId = Integer.parseInt(request().body().asFormUrlEncoded().get("cuentaAnalitica_id")[0]);
					
					Ebean.createUpdate(SolicitudLinea.class, "UPDATE orden_lineas " +
							"SET cuenta_analitica_id=:cuenta_analitica_id,write_date = :write_date,write_usuario_id = :write_usuario_id " +
							"WHERE id in("+s+")")
					.setParameter("cuenta_analitica_id",cuentaId)
					.setParameter("write_date",new Date())
					.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()))
					//.setParameter("id", ordenes)
					.execute();
	
					ret += "<p class='responseOk'>- Se actualiz&oacute; "+ordenes.length+" lineas.</p>";
				}else{
					Error += "<p class='responseError'>- No se encuentra seleccionada una lineas.</p>";
					return ok( Error+ret );
				}
				
			}else{
				
				if(request().body().asFormUrlEncoded().get("check_listado[]") != null){ 
					ordenes = request().body().asFormUrlEncoded().get("check_listado[]");	
				}else{
					Error += "<p class='responseError'>- No se encuentra seleccionada una orden.</p>";
					return ok( Error+ret );
				}
				
				for (String idOrden : ordenes) {
					Orden orden = Ebean.find(Orden.class).select("id, estado_id").setId(Integer.parseInt(idOrden)).findUnique();
					
					if(orden.estado_id != Estado.ORDEN_ESTADO_APROBADO){
						Integer cuentaId = Integer.parseInt(request().body().asFormUrlEncoded().get("cuentaAnalitica_id")[0]);
						
						Ebean.createUpdate(SolicitudLinea.class, "UPDATE orden_lineas " +
								"SET cuenta_analitica_id=:cuenta_analitica_id,write_date = :write_date,write_usuario_id = :write_usuario_id " +
								"WHERE orden_id=:id")
						.setParameter("cuenta_analitica_id",cuentaId)
						.setParameter("write_date",new Date())
						.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()))
						.setParameter("id", Integer.parseInt(idOrden)).execute();
		
						ret += "<p class='responseOk'>- Se actualiz&oacute; la orden "+orden.nombre+".</p>";
					
					}else{
						Error += "<p class='responseError'>- No se puede actualizar la orden "+orden.nombre+" porque se encuentra en estado APROBADO.</p>";
					}
					
				}
			}	
		}else{
			Error += "<p class='responseError'>- No se puedo seleccionar el tipo de operacion.</p>";
			return ok( Error+ret );
		}
		
		return ok( Error+ret );
	}
	
	public static void pasarEnBorrador(Long idOrden){
		
		Orden orden = Ebean.find(Orden.class).select("id, estado_id,write_date,write_usuario_id").setId(idOrden).findUnique();
		
		if(orden != null){			
			orden.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			orden.write_date = new Date();
			orden.estado_id = new Long(Estado.ORDEN_ESTADO_BORRADOR);
			orden.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
		
	}
	
	public static void pasarEnPreCurso(Long idOrden){
		
		Orden orden = Ebean.find(Orden.class).select("id, estado_id,orden_rubro_id,expediente,tipo_orden,numero_orden_provision,proveedor_id,write_date,write_usuario_id").setId(idOrden).findUnique();
		
		boolean ordenOk = true;
		String error = "";
		if(orden.proveedor_id == null){
			error = "Debe seleccionar un proveedor para cambiar de estado.<br>";
			ordenOk = false;
		}
		
		if(orden.tipo_orden == null || orden.tipo_orden.isEmpty()){
			error = "Debe Seleccionar un tipo de orden.<br>";
			ordenOk = false;
		}
		
		if(orden.orden_rubro_id == null ){
			error += "Debe Seleccionar un tipo de Rubro.<br>";
			ordenOk =  false;
		}
		
		if(orden != null && ordenOk){	
			orden.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			orden.write_date = new Date();
			orden.estado_id = new Long(Estado.ORDEN_ESTADO_PRECURSO);
			orden.fecha_precurso = new Date();
			orden.save();
			flash("success", "Operación exitosa. Estado actual: En PreCurso");
		} else {
			flash("error", "Parámetros incorrectos.<br> "+error);
		}

	}
	
	public static void pasarEnCurso(Long idOrden){
		
		Orden orden = Ebean.find(Orden.class).select("id, estado_id,orden_rubro_id,expediente,tipo_orden,numero_orden_provision,proveedor_id,write_date,write_usuario_id").setId(idOrden).findUnique();
		
		boolean ordenOk = true;
		String error = "";
		if(orden.proveedor_id == null){
			error = "Debe seleccionar un proveedor para cambiar de estado.<br>";
			ordenOk = false;
		}
		
		/*List<Integer> lo = new ArrayList<Integer>();
		lo.add(orden.id.intValue());
		if(!soloCuentasAnliticasHijas(lo)){
			error = "Las cuentas presupuestarias deben ser Hijas unicamente.<br>";
			ordenOk = false;
		}*/
		
		
		if(orden.tipo_orden!= null && (orden.tipo_orden.compareToIgnoreCase("certificacionobra") != 0 && orden.tipo_orden.compareToIgnoreCase("haberesrelacion") != 0 && orden.tipo_orden.compareToIgnoreCase("certificacioncompra") != 0 && orden.tipo_orden.compareToIgnoreCase("personal") != 0 && orden.tipo_orden.compareToIgnoreCase("sinop") != 0 && orden.tipo_orden.compareToIgnoreCase("imputacion") != 0) ){
			if(orden.numero_orden_provision == null || orden.numero_orden_provision <= 0){
				error += "Debe insertar un numero de Orden de provision.<br>";
				ordenOk =  false;
			}else{
				Long eid = orden.expediente.ejercicio_id;
				int lop  = OrdenProvision.find.where().eq("numero", orden.numero_orden_provision).eq("ejercicio_id",eid).findRowCount();
				if(lop > 0){
					error += "Ya existe este numero de orden de Provision.<br>";
					ordenOk =  false;
				}
			}
		}else{
			if(orden.numero_orden_provision != null){
				error += "Este tipo de ordenes no lleva Numero de Orden de Provision.<br>";
				ordenOk =  false;
			}
		}
		
		if(orden.tipo_orden!= null && (orden.tipo_orden.compareToIgnoreCase("servicio")) == 0){
			if(orden.fecha_inicio == null || orden.fecha_fin == null) {
				error += "Las ordenes de servicios deben llevar fecha de inicio y fecha de fin.<br>";
				ordenOk =  false;
			}
		}
		
		
		if(orden.tipo_orden == null || orden.tipo_orden.isEmpty()){
			error = "Debe Seleccionar un tipo de orden.<br>";
			ordenOk = false;
		}
		
		if(orden.orden_rubro_id == null ){
			error += "Debe Seleccionar un tipo de Rubro.<br>";
			ordenOk =  false;
		}
		
		if(orden != null && ordenOk){	
			orden.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			orden.write_date = new Date();
			orden.fecha_curso = new Date();
			orden.estado_id = new Long(Estado.ORDEN_ESTADO_ENCURSO);
			orden.save();
			flash("success", "Operación exitosa. Estado actual: En Curso");
		} else {
			flash("error", "Parámetros incorrectos.<br> "+error);
		}

	}
	
	public static void pasarAprobado(Long idOrden){
		
		//Orden orden = Ebean.find(Orden.class).select("id, estado_id,fecha_orden,write_date,write_usuario_id").setId(idOrden).findUnique();
		Orden orden = Orden.find.byId(idOrden);
		List<Orden> lo = new ArrayList<Orden>();
		lo.add(orden);
		boolean errorControl =  false;
		String aviso = "";
		String avisoPresupuesto = "";
		
		List<Integer> lo2 = new ArrayList<Integer>();
		lo2.add(orden.id.intValue());
		if(!soloCuentasAnliticasHijas(lo2)){
			aviso += "Las cuentas presupuestarias deben ser Hijas unicamente.<br>";
			errorControl =  true;
		}
		
		Integer sl = OrdenLinea.find.where().eq("orden_id",orden.id).isNull("cuenta_analitica_id").findRowCount();
		if(sl > 0 ){
			aviso += "No puede cambiar de estado con lineas que no contengan cuenta presupuestaria.<br>";
			errorControl =  true;
		}
		
		Integer cuentasDePlan = OrdenLinea.find.where().eq("orden_id",orden.id).ilike("cuentaAnalitica.nombre","%(PLAN%" ).findRowCount();
		if(cuentasDePlan > 0 && orden.tipo_cuenta_id.compareTo(TipoCuenta.OPERATIVA) == 0){
			aviso += "La cuenta presupuesta es de algun PLAN y el tipo de CUENTA OPERATIVA.<br>";
			errorControl =  true;
		}
		
		
		Integer lineaMontosCero = OrdenLinea.find.where()
								  .eq("orden_id",orden.id)
								  .ne("orden.proveedor_id", Proveedor.PROVEEDOR_AFIP)
								  .le("precio",BigDecimal.ZERO).findRowCount();
		if(lineaMontosCero > 0 ){
			aviso += "No se puede aprobar ordenes que contengan lineas con precio en 0.<br>";
			errorControl =  true;
		}
		
		Ejercicio ejercicioActual  = Ejercicio.getEjercicioByFecha(new Date());
		
		if(!Permiso.check("ordenesAjustesAnoNoCorriente") && orden.expediente.ejercicio_id.compareTo(ejercicioActual.id) != 0){
			aviso += "Solo tiene permisos para aprobar ordenees del año corriente.<br>";
			errorControl =  true;
		}
		
		if(orden.tipo_orden!= null && (orden.tipo_orden.compareToIgnoreCase("certificacionobra") != 0 && orden.tipo_orden.compareToIgnoreCase("haberesrelacion") != 0 && orden.tipo_orden.compareToIgnoreCase("certificacioncompra") != 0 && orden.tipo_orden.compareToIgnoreCase("personal") != 0 && orden.tipo_orden.compareToIgnoreCase("sinop") != 0 && orden.tipo_orden.compareToIgnoreCase("imputacion") != 0) ){
			if(orden.numero_orden_provision == null || orden.numero_orden_provision <= 0){
				aviso += "Debe insertar un numero de Orden de provision.<br>";
				errorControl =  true;
			}else{
				Long eid = orden.expediente.ejercicio_id;
				int lop  = OrdenProvision.find.where().eq("numero", orden.numero_orden_provision).eq("ejercicio_id",eid).findRowCount();
				if(lop > 0){
					aviso += "Ya existe este numero de orden de Provision.<br>";
					errorControl =  true;
				}
			}
		}
		
		
		if(orden.tipo_orden.compareToIgnoreCase("comun")  == 0 || orden.tipo_orden.compareToIgnoreCase("servicio")  == 0) {
			if(orden.numero_presupuesto == null || orden.numero_presupuesto.isEmpty()){
				aviso += "Debe ingresar un N° de Presupuesto.<br>";
				errorControl =  true;
			}
		} 
		
		if(orden.monto_adelanto != null) {
			if(orden.monto_adelanto.compareTo(orden.getTotalTotalSinDiferenciaCotizacion()) > 0) {
				aviso += "El monto adelanto no puede ser mayor al total de la orden.<br>";
				errorControl =  true;
			}
		} 
		
		ArrayNode a = BalancePresupuestario.controlSaldoPreventivo(lo);
		for(JsonNode o :a){
			boolean success = new Boolean(o.get("success").toString());
			String cuenta = o.get("cuenta").toString();
			String expediente = o.get("expediente").toString();
			BigDecimal saldoDisponible =  new BigDecimal(o.get("saldoDisponible").toString());
			BigDecimal saldoAImputar =  new BigDecimal(o.get("saldoAImputar").toString());
			BigDecimal saldoPresente =  new BigDecimal(o.get("saldoPresente").toString());
			
			if(!success){
				errorControl =  true;
				avisoPresupuesto += "No tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
				avisoPresupuesto += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				avisoPresupuesto += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				avisoPresupuesto += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}else{
				avisoPresupuesto += "Tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
				avisoPresupuesto += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				avisoPresupuesto += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				avisoPresupuesto += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}
		}
		
		
		
		if(errorControl){
			String r = (aviso.isEmpty())?avisoPresupuesto:aviso;
			flash("error", r);
		}else{
			if(orden != null){
				orden.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				orden.write_date = new Date();
				orden.fecha_orden = new Date();
				orden.fecha_aprobada = new Date();
				orden.estado_id = new Long(Estado.ORDEN_ESTADO_APROBADO);
				orden.save();
				flash("success", "Operación exitosa. Estado actual: Aprobado<br>"+avisoPresupuesto);
			} else {
				flash("error", "Parámetros incorrectos");
			}
		}	

	}
	
	public static void pasarFinalizado(Long idOrden){
		
		Orden orden = Ebean.find(Orden.class).select("id, estado_id,write_date,write_usuario_id").setId(idOrden).findUnique();
		
		if(orden != null){
			orden.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			orden.write_date = new Date();
			orden.estado_id = new Long(Estado.ORDEN_ESTADO_FINALIZADO);
			orden.save();
			flash("success", "Operación exitosa. Estado actual: Finalizado");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	public static void pasarCancelado(Long idOrden){
		
		Orden orden = Ebean.find(Orden.class).select("id, estado_id,write_date,write_usuario_id").setId(idOrden).findUnique();
		
		boolean ordenOk = true;
		String error = "";
		
		Integer tieneCertificacion = Certificacion.find.where().eq("orden_id",orden.id).findRowCount();
		if(tieneCertificacion > 0){
			ordenOk = false;
			error = "Nose puede cancelar la orden porque tiene certificaciones asociadas.";
		}
		
		Integer tieneOrdenProvision = OrdenProvision.find.where().eq("orden_compra_id",orden.id).findRowCount();
		if(tieneOrdenProvision > 0){
			ordenOk = false;
			error = "Nose puede cancelar la orden porque tiene Orden de provision asociadas.";
		}
		
		Integer tieneFacturas = Factura.find.where().eq("orden_id",orden.id).findRowCount();
		if(tieneFacturas > 0){
			ordenOk = false;
			error = "Nose puede cancelar la orden porque tiene facturas asociadas.";
		}
		
		
		if(orden != null && ordenOk){	
			orden.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			orden.write_date = new Date();
			orden.estado_id = new Long(Estado.ORDEN_ESTADO_CANCELADO);
			orden.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos. "+error);
		}

	}
	
	public static Result modalBuscar() {
    	Pagination<Orden> p = new Pagination<Orden>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(Orden.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaOrdenes.render(p, form().bindFromRequest()) );
	}
	
	public static Result get(long id){
		Orden orden = Orden.find.select("id, nombre").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(orden == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la orden");
		} else {
			restJs.put("success", true);
			restJs.put("id", orden.id);
			restJs.put("nombre", orden.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	private static Orden loadOrden(Long id) throws NoRecordModelException {
		Orden orden = Orden.find.byId(id);
		if (orden == null) {
			flash("error", "La orden solicitada ya no existe.");
			throw new NoRecordModelException();
		}
		return orden;
	}
	
	public static Boolean soloCuentasAnliticasHijas(List<Integer> idsOrdenes) {
		boolean r = true;
		
		String sql = "SELECT * " +
				"FROM orden_lineas " +
				"WHERE orden_id in(:idsOrdenes) " +
				"AND cuenta_analitica_id IN (SELECT parent_id FROM cuentas_analiticas WHERE parent_id is not null)  ";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("idsOrdenes",idsOrdenes)		
				.findList();
		
		if(s.size() > 0){
			r = false;
		}
		
		return r;
	}
	
	
	
}

