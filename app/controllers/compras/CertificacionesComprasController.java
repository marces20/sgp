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
import models.CertificacionCompra;
import models.CertificacionCompraLinea;
import models.CertificacionLinea;
import models.Estado;
import models.Factura;
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
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.sinPermiso;
import views.html.compras.certificacionesCompras.crearCertificacion;
import views.html.compras.certificacionesCompras.editarCertificacion;
import views.html.compras.certificacionesCompras.indexCertificacion;
import views.html.compras.certificacionesCompras.verCertificacion;
import views.html.compras.certificacionesCompras.modales.modalEditarCuentaAnalitica;
import views.html.compras.certificacionesCompras.modales.modalPasarCertificado;
import views.html.compras.certificacionesCompras.modales.modalPasarEnCurso;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class CertificacionesComprasController extends Controller {
	
	final static Form<CertificacionCompra> certificacionForm = form(CertificacionCompra.class);
	
	public static Result URL_LISTA_CERTIFICACION = redirect(
			controllers.compras.routes.CertificacionesComprasController.index()
	);
	
	
	@CheckPermiso(key = "certificacionesComprasListado")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		return ok(
				indexCertificacion.render(
						CertificacionCompra.page(
								 RequestVar.get("nombre"),
								 RequestVar.get("proveedor.id"),
								 RequestVar.get("expediente.id"),
								 RequestVar.get("fecha_certificacion_desde"),
								 RequestVar.get("fecha_certificacion_hasta"),
								 RequestVar.get("periodo_id"),
								 RequestVar.get("ejercicio"),
								 RequestVar.get("btnFiltro[0]"),//borrador
								 RequestVar.get("btnFiltro[1]"),//en curso
								 RequestVar.get("btnFiltro[2]"),//certificado
								 RequestVar.get("btnFiltro[3]"),//canceladi
								 "",
								 RequestVar.get("tipo_cuenta_id"),
								 RequestVar.get("orden_rubro_id")
								),
								 d, pf,false));
	}
	
	public static Result cambiarEstado(Long idCertificacion, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_CERTIFICACION_COMPRA);
		
		CertificacionCompra certificacion = CertificacionCompra.find.where().eq("id", idCertificacion).eq("obras",false).findUnique();
		
		if(certificacion == null){
			flash("error", "No se encuentra la certificación.");
			return redirect(request().getHeader("referer"));
		}
		
		if((certificacion.expediente_id != null && certificacion.certificacionCompraLinea.isEmpty()) && (idEstado != Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO && idEstado != Estado.CERTIFICACION_COMPRA_ESTADO_BORRADOR)){
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(request().getHeader("referer"));
		}
		
		Integer sl = CertificacionCompraLinea.find.where().eq("certificacion_compra_id",certificacion.id).isNull("cuenta_analitica_id").findRowCount();
		if(sl > 0 ){
			flash("error", "No puede cambiar de estado con lineas que no contengan cuenta presupuestaria.");
			return redirect(request().getHeader("referer"));
		}
		
		if(idEstado != null){
			
			Boolean permiso = false;
			
			switch ( idEstado.intValue() ) {
		      case  Estado.CERTIFICACION_COMPRA_ESTADO_BORRADOR:
		    	  if(!Permiso.check("certificacionesComprasPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(certificacion.id);
		    	  break;
		      case Estado.CERTIFICACION_COMPRA_ESTADO_ENCURSO:
		    	  if(!Permiso.check("certificacionesComprasPasarEnCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnCurso(certificacion.id);
		    	  break;       
		      case Estado.CERTIFICACION_COMPRA_ESTADO_CERTIFICADO:
		    	  if(!Permiso.check("certificacionesComprasPasarCertificado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCertificado(certificacion.id); 
		    	  break;
		      case Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO:
		    	  if(!Permiso.check("certificacionesComprasPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(certificacion.id);   
		          break;
		      default:
		           break;
		      }
			  
		}	 
		
		return redirect(controllers.compras.routes.CertificacionesComprasController.ver(certificacion.id)+ UriTrack.get("&"));
	}
	
	@CheckPermiso(key = "certificacionesComprasVer")
	public static Result ver(Long id) {
		CertificacionCompra certificacion = CertificacionCompra.find.where().eq("id", id).eq("obras",false).findUnique();
		Form<CertificacionCompra> certificacionForm = form(CertificacionCompra.class).fill(certificacion);
		return ok(verCertificacion.render(certificacionForm, certificacion, new PaginadorFicha(UriTrack.code()),false));
	}
	
	@CheckPermiso(key = "certificacionesComprasCrear")
	public static Result crear() {
		
		Map<String,String> p = new HashMap<String, String>();
		p.put("nombre","CC");
		Form<CertificacionCompra> certificacionForm = form(CertificacionCompra.class).bind(p);
		certificacionForm.discardErrors();
		
		return ok(crearCertificacion.render(certificacionForm,false));
	}
	
	@CheckPermiso(key = "certificacionesComprasCrear")
	public static Result guardar() {
		
		Form<CertificacionCompra> certificacionForm = form(CertificacionCompra.class).bindFromRequest();
		
		validarForm(certificacionForm);
		
		if(certificacionForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearCertificacion.render(certificacionForm,false));
		}
		
		try {
			CertificacionCompra c = certificacionForm.get();
			c.create_date = new Date();
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.obras = false;
			c.save();
			
			flash("success", "La certificacion se ha actualizado");
			return redirect( controllers.compras.routes.CertificacionesComprasController.ver(certificacionForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la certificacion");
			return badRequest(crearCertificacion.render(certificacionForm,false));
		}
		//return URL_LISTA_CERTIFICACION;
	}
	
	@CheckPermiso(key = "certificacionesComprasModificar")
	public static Result editar(Long id) {
		CertificacionCompra certificacion = CertificacionCompra.find.where().eq("id", id).eq("obras",false).findUnique();
		
		if(certificacion  == null){
			flash("error", "No se encuentra la certificacion.");
			return redirect(controllers.compras.routes.CertificacionesComprasController.index()+UriTrack.get("?"));
		}else if(certificacion.estado_id == Estado.CERTIFICACION_COMPRA_ESTADO_CERTIFICADO || certificacion.estado_id == Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO){
			flash("error", "La certificación no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}
		
		
		return ok(editarCertificacion.render(certificacionForm.fill(certificacion),certificacion,false));
	}
	
	@CheckPermiso(key = "certificacionesComprasModificar")
	public static Result actualizar(Long id){
		
		Form<CertificacionCompra> certificacionForm = form(CertificacionCompra.class).bindFromRequest();
		validarForm(certificacionForm);
		CertificacionCompra certificacion = Ebean.find(CertificacionCompra.class, id);
		
		if(certificacionForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarCertificacion.render(certificacionForm,certificacion,false));
		}
		
		try {
			CertificacionCompra c = certificacionForm.get();
			c.estado_id = certificacion.estado_id;
			c.write_date = new Date();
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.update();
			flash("success", "La certificacion se ha actualizado");
			return redirect( controllers.compras.routes.CertificacionesComprasController.ver(certificacionForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la certificacion");
			return badRequest(editarCertificacion.render(certificacionForm,certificacion,false));
		}
		
		//return URL_LISTA_CERTIFICACION;
	}
	
	@CheckPermiso(key = "certificacionesComprasEliminar")
	public static Result eliminar(Long id) {
		
		CertificacionCompra certificacion = Ebean.find(CertificacionCompra.class).select("id, estado_id").setId(id).where().eq("id", id).eq("obras",false).findUnique();
		
		if(certificacion == null){
			flash("error", "No se encuentra la certificación.");
			return redirect(controllers.compras.routes.CertificacionesComprasController.index()+UriTrack.get("?"));
		}
		
		if(certificacion.estado_id == Estado.CERTIFICACION_COMPRA_ESTADO_BORRADOR || certificacion.estado_id == Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO){
			try {
				certificacion.delete();
				flash("success", "Se ha eliminado la certificación");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar la certificación");
			}
		} else {
			flash("error", "No se ha podido eliminar la certificación. Unicamente se puede eliminar cuando el estado de la certificacion se encuentra en borrador o cancelado.");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	public static void validarForm(Form<CertificacionCompra> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("fecha_certificacion", "Fecha inválida"));
		v.validate();
	}
	
	@CheckPermiso(key = "certificacionesComprasPasarBorrador")
	public static void pasarEnBorrador(Long idCertificacion){
		
		CertificacionCompra certificacion = Ebean.find(CertificacionCompra.class).select("id, estado_id,write_date,write_usuario_id").setId(idCertificacion).findUnique();
		
		if(certificacion != null){			
			certificacion.estado_id = new Long(Estado.CERTIFICACION_COMPRA_ESTADO_BORRADOR);
			certificacion.write_date = new Date();
			certificacion.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			certificacion.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	@CheckPermiso(key = "certificacionesComprasPasarEnCurso")
	public static void pasarEnCurso(Long idCertificacion){
		
		CertificacionCompra certificacion = Ebean.find(CertificacionCompra.class).select("id, estado_id,write_date,write_usuario_id").setId(idCertificacion).findUnique();
		Logger.debug("xxxxxxxxxxxxxxxxxxx");																	   
		if(certificacion != null){			
			certificacion.estado_id = new Long(Estado.CERTIFICACION_COMPRA_ESTADO_ENCURSO);
			certificacion.write_date = new Date();
			certificacion.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			certificacion.save();
			flash("success", "Operación exitosa. Estado actual: En Curso");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	@CheckPermiso(key = "certificacionesComprasPasarCertificado")
	public static void pasarCertificado(Long idCertificacion){
		
		CertificacionCompra certificacion = Ebean.find(CertificacionCompra.class).select("id, estado_id,fecha_certificacion,expediente_id,write_date,write_usuario_id,proveedor_id,periodo_id").setId(idCertificacion).findUnique();
		
		if(certificacion != null){	
			boolean ordenOk = true;
			String error = "";
			
			List<Integer> co = new ArrayList<Integer>();
			co.add(certificacion.id.intValue());
			if(!Certificacion.soloCuentasAnliticasHijas(co)){
				flash("error", "Las cuentas presupuestarias deben ser Hijas unicamente.");
				return;
			}
			
			if(!Certificacion.soloCuentasAnliticasHijas(co)){
				flash("error", "Las cuentas presupuestarias deben ser Hijas unicamente.");
				return;
			}
			
			if(!Certificacion.conExpediente(co)) {
				flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
				return;
			}
			
			if(!Certificacion.conLineas(co)) {
				flash("error", "Solo se puede modificar registros que no contengan lineas.");
				return;
			}
			
			if(!Certificacion.soloEnCurso(co)) {
				flash("error", "Solo se puede modificar registros en estado en curso.");
				return;
			}
			
			if(!Certificacion.conPeriodo(co)) {
				flash("error", "Solo se puede modificar registros que no tengan periodo asignado.");
				return;
			}
						
			if(!Certificacion.soloCertificadoConFecha(co)) {
				flash("error", "Solo se puede modificar registros que tenga asigando una fecha de certificacion.");
				return;
			}
			
			List<Integer> cco = new ArrayList<Integer>();
			cco.add(certificacion.id.intValue());
			
			ArrayNode a = BalancePresupuestario.controlSaldoDefinitivoCertificacionesCompras(cco);
			boolean errorControl =  false;
			String aviso = "";
			for(JsonNode o :a){
				boolean success = new Boolean(o.get("success").toString());
				String cuenta = o.get("cuenta").toString();
				String expediente = o.get("expediente").toString();
				BigDecimal saldoDisponible =  new BigDecimal(o.get("saldoDisponible").toString());
				BigDecimal saldoAImputar =  new BigDecimal(o.get("saldoAImputar").toString());
				BigDecimal saldoPresente =  new BigDecimal(o.get("saldoPresente").toString());
				
				if(!success){
					errorControl =  true;
					aviso += "No tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
					aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
					aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
					aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
				}else{
					aviso += "Tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
					aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
					aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
					aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
				}
			}
			
			if(errorControl){
				flash("error", aviso);
			}else{
				if(certificacion.fecha_certificacion == null){
					certificacion.fecha_certificacion = new Date();
				}
				certificacion.estado_id = new Long(Estado.CERTIFICACION_COMPRA_ESTADO_CERTIFICADO);
				certificacion.write_date = new Date();
				certificacion.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				certificacion.save();
				flash("success", "Operación exitosa. Estado actual: Certificado<br>"+aviso);
			}	
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	@CheckPermiso(key = "certificacionesComprasPasarCancelado")
	public static void pasarCancelado(Long idCertificacion){
		
		CertificacionCompra certificacion = Ebean.find(CertificacionCompra.class).select("id, estado_id,write_date,write_usuario_id").setId(idCertificacion).findUnique();
		
		boolean certificacionOk = true;
		String error = "";
		Integer tieneFacturas = Factura.find.where().eq("certificacion_compra_id",certificacion.id).findRowCount();
		if(tieneFacturas > 0){
			certificacionOk = false;
			error = "No se puede cancelar la certificación porque tiene facturas asociadas.";
		}
		
		if(certificacion != null && certificacionOk){			
			certificacion.estado_id = new Long(Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO);
			certificacion.write_date = new Date();
			certificacion.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			certificacion.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos. "+error);
		}

	}
	
	@CheckPermiso(key = "certificacionesComprasEditarCuentaAnalitica")
	public static Result editarCuentaAnalitica() {
		 
		String ret = "";
		String Error = "";
		String[] certificaciones;
		if(request().body().asFormUrlEncoded().get("check_listado[]") != null){ 
			
			certificaciones = request().body().asFormUrlEncoded().get("check_listado[]");	
		}else if(request().body().asFormUrlEncoded().get("id") != null){
			certificaciones = request().body().asFormUrlEncoded().get("id");	
		}else{
			Error += "<p class='responseError'>- No se encuentra seleccionada una certificación.</p>";
			return ok( Error+ret );
		}
		
		
		for (String idCertificacion : certificaciones) {
			CertificacionCompra certificacion = Ebean.find(CertificacionCompra.class).select("id, estado_id,write_date,write_usuario_id").setId(Integer.parseInt(idCertificacion)).findUnique();
			
			if(certificacion.estado_id != Estado.CERTIFICACION_COMPRA_ESTADO_CERTIFICADO){
				Integer cuentaId = Integer.parseInt(request().body().asFormUrlEncoded().get("cuentaAnalitica_id")[0]);
				
				Ebean.createUpdate(CertificacionLinea.class, "UPDATE certificaciones_compras_lineas " +
						"SET cuenta_analitica_id=:cuenta_analitica_id,write_date = :write_date,write_usuario_id = :write_usuario_id " +
						"WHERE certificacion_compra_id=:id")
				.setParameter("cuenta_analitica_id",cuentaId)
				.setParameter("write_date",new Date())
				.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()))
				.setParameter("id", Integer.parseInt(idCertificacion)).execute();

				ret += "<p class='responseOk'>- Se actualiz&oacute; la certificación "+certificacion.nombre+".</p>";
			
			}else{
				Error += "<p class='responseError'>- No se puede actualizar la certificación "+certificacion.nombre+" porque se encuentra en estado CERTIFICADO.</p>";
			}
			
		}
		
		
		return ok( Error+ret );
	}
	
	public static Result modalEditarCuentaAnalica() {
    	
		return ok( modalEditarCuentaAnalitica.render(form().bindFromRequest()) );
	}
	
	
	@CheckPermiso(key = "certificacionesComprasDuplicar")
	public static Result duplicar(Long id) throws IOException{
		
		try {
			
			CertificacionCompra c = new CertificacionCompra();
			
			Long idNew = c.duplicar(id);
			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha duplicado la certificacion");
				return redirect(controllers.compras.routes.CertificacionesComprasController.editar(idNew) + UriTrack.get("&"));
			}else{
				flash("error", "No se ha podido duplicar la certificacion");
				String refererUrl = request().getHeader("referer");
				return redirect(refererUrl);
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido duplicar la certificacion");
		}
		
		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
}
