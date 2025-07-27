package controllers.recupero;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import de.mhus.lib.core.logging.LogFactory;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import models.DireccionCliente;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.Orden;
import models.Solicitud;
import models.SolicitudLinea;
import models.Usuario;
import models.auth.Permiso;
import models.recupero.InformeTotal;
import models.recupero.RecuperoCerficadoDeudaLinea;
import models.recupero.RecuperoCertificadoDeuda;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoNotaDebito;
import models.recupero.RecuperoPago;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.contabilidad.facturas.acciones.modalPasarEnPreCurso;
import views.html.recupero.recuperoCertificadoDeuda.*;

@Security.Authenticated(Secured.class)
public class RecuperoCertificadoDeudaController  extends Controller {

/*
 * PERMISOS CAMBIOSS DE ESTADOS
 * LINEAS
 * CUANDO SE BORRA UNA LINEA SACAR EL CERTIFICADO_DEUDA_ID Q VOY A PONER EN LA FACTURA
 *
 *
 *
 *
 */



	final static Form<RecuperoCertificadoDeuda> certificadoForm = form(RecuperoCertificadoDeuda.class);

	public static Result URL_LISTA_CERTIFICADO = redirect(
			controllers.recupero.routes.RecuperoCertificadoDeudaController.index()
	);

	@CheckPermiso(key = "certificadoDeudaVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexCertificadoDeuda.render(
				RecuperoCertificadoDeuda.page(
												  		RequestVar.get("numero"),
												  		RequestVar.get("expediente_id"),
												  		RequestVar.get("fecha_desde"),
												  		RequestVar.get("btnFiltro[0]"),//borrador
												  		RequestVar.get("btnFiltro[1]"),
												  		RequestVar.get("cliente_id")
												  		),d));
	}

	@CheckPermiso(key = "certificadoDeudaVer")
	public static Result ver(Long id) {

		RecuperoCertificadoDeuda p = RecuperoCertificadoDeuda.find.byId(id);

		if(p != null){

			Form<RecuperoCertificadoDeuda> certificadoForm = form(RecuperoCertificadoDeuda.class).fill(p);
			return ok(verCertificadoDeuda.render(certificadoForm, p));

		}else{
			flash("error", "No se encuentra la certificado.");
			return redirect(controllers.recupero.routes.RecuperoCertificadoDeudaController.index()+UriTrack.get("?"));
		}
	}

	@CheckPermiso(key = "certificadoDeudaCrear")
	public static Result crear() {

		Map<String,String> p = new HashMap<String, String>();

		Form<RecuperoCertificadoDeuda> certificadoForm = form(RecuperoCertificadoDeuda.class).bind(p);
		certificadoForm.discardErrors();

		return ok(crearCertificadoDeuda.render(certificadoForm));
	}

	@CheckPermiso(key = "certificadoDeudaCrear")
	public static Result guardar() {

		Form<RecuperoCertificadoDeuda> certificadoForm = form(RecuperoCertificadoDeuda.class).bindFromRequest();

		if(certificadoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearCertificadoDeuda.render(certificadoForm));
		}

		try {
			RecuperoCertificadoDeuda c = certificadoForm.get();




			Expediente e  = Expediente.find.byId(c.expediente_id.longValue());

			List<RecuperoCertificadoDeuda> rpx = RecuperoCertificadoDeuda.find.where()
											.eq("numero", c.numero)
								    		.eq("expediente.ejercicio_id",e.ejercicio_id)
								    		.eq("expediente_id",e.id)
								    		.findList();


			if(rpx.size() > 0){
				flash("error", "Ya existe ese numero de certificado para este ejercicio.");
				return badRequest(crearCertificadoDeuda.render(certificadoForm));
			}else{
				c.save();
			}


			flash("success", "El certificado se ha creado");
			return redirect( controllers.recupero.routes.RecuperoCertificadoDeudaController.ver(certificadoForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el certificado");
			return badRequest(crearCertificadoDeuda.render(certificadoForm));
		}
	}

	@CheckPermiso(key = "certificadoDeudaModificar")
	public static Result editar(Long id) {
		RecuperoCertificadoDeuda certificado = RecuperoCertificadoDeuda.find.byId(id);

		if(certificado  == null){
			flash("error", "No se encuentra el certificado.");
			return redirect(controllers.recupero.routes.RecuperoCertificadoDeudaController.index()+UriTrack.get("?"));
		}else if(certificado.estado_id != Estado.RECUPERO_CERTIFICADO_DEUDA_BORRADOR ){
			flash("error", "El certificado no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));

		}

		return ok(editarCertificadoDeuda.render(certificadoForm.fill(certificado),certificado));
	}

	@CheckPermiso(key = "certificadoDeudaModificar")
	public static Result actualizar(Long id){

		Form<RecuperoCertificadoDeuda> certificadoForm = form(RecuperoCertificadoDeuda.class).bindFromRequest();

		RecuperoCertificadoDeuda certificado = Ebean.find(RecuperoCertificadoDeuda.class, id);

		if(certificadoForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarCertificadoDeuda.render(certificadoForm,certificado));
		}

		try {
			RecuperoCertificadoDeuda c = certificadoForm.get();



			Expediente e  = Expediente.find.byId(c.expediente_id.longValue());

			List<RecuperoCertificadoDeuda> rpx = RecuperoCertificadoDeuda.find.where()
											.eq("numero", c.numero)
											.eq("expediente.ejercicio_id",e.ejercicio_id)
											.eq("expediente_id",e.id)
								   			.ne("id", c.id).findList();

			Logger.debug("cccccccccccccccccccccccccccccccccccccccccc");
			if(rpx.size() > 0){
				flash("error", "Ya existe ese numero certificado para este ejercicio.");
				return badRequest(editarCertificadoDeuda.render(certificadoForm,certificado));
			}else{
				c.update();
			}

			flash("success", "El certificado se ha actualizado");
			return redirect( controllers.recupero.routes.RecuperoCertificadoDeudaController.ver(certificadoForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el certificado");
			return badRequest(editarCertificadoDeuda.render(certificadoForm,certificado));
		}
	}

	@CheckPermiso(key = "certificadoDeudaEliminar")
	public static Result eliminar(Long id) {

		RecuperoCertificadoDeuda certificado = Ebean.find(RecuperoCertificadoDeuda.class).select("id").setId(id).findUnique();

		if(certificado == null){
			flash("error", "No se encuentra el certificado.");
			return redirect(controllers.recupero.routes.RecuperoCertificadoDeudaController.index()+UriTrack.get("?"));
		}

		try {
			certificado.delete();
			flash("success", "Se ha eliminado el certificado");
			return redirect(UriTrack.decode());
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el certificado");
		}


		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}

	public static Result cambiarEstado(Long id, Long idEstado) throws IOException{

		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_RECUPERO_CERTIFICADO_DEUDA);

		RecuperoCertificadoDeuda rp = RecuperoCertificadoDeuda.find.byId(id);


		if(rp == null){
			flash("error", "No se encuentra el certificado");
			return redirect(request().getHeader("referer"));
		}

		if((rp.recuperoCerficadoDeudaLinea.isEmpty())){
			flash("error", "No se puede modificar el estado si no contiene lineas asociadas.");
			return redirect(request().getHeader("referer"));
		}

		if(idEstado != null){

			Boolean permiso = false;

			switch ( idEstado.intValue() ) {
		      case  Estado.RECUPERO_CERTIFICADO_DEUDA_BORRADOR:
		    	  if(!Permiso.check("certificadoDeudaPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(rp.id);
		    	  break;

		      case Estado.RECUPERO_CERTIFICADO_DEUDA_APROBADO:
		    	  if(!Permiso.check("certificadoDeudaPasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobado(rp.id);
		    	  break;
		      case Estado.RECUPERO_CERTIFICADO_DEUDA_PAGADO:
		    	  if(!Permiso.check("certificadoDeudaPasarPagado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarPagado(rp.id);
		    	  break;
		      case Estado.RECUPERO_CERTIFICADO_DEUDA_CANCELADO:

		    	  if(!Permiso.check("certificadoDeudaPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }

		    	  if(rp.estado_id.compareTo(new Long(Estado.RECUPERO_CERTIFICADO_DEUDA_PAGADO)) == 0) {
		  			flash("error", "No se puede cancelar Certificados Aprobados");
					return redirect(request().getHeader("referer"));
		    	  }

		    	  pasarCancelado(rp.id);
		    	  break;

		      default:
		           break;
		      }

		}

		return redirect(controllers.recupero.routes.RecuperoCertificadoDeudaController.ver(rp.id)+ UriTrack.get("&"));
	}

	public static void pasarEnBorrador(Long idRf){

		RecuperoCertificadoDeuda rf = Ebean.find(RecuperoCertificadoDeuda.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_CERTIFICADO_DEUDA_BORRADOR);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	public static void pasarAprobado(Long idRf){

		RecuperoCertificadoDeuda rf = Ebean.find(RecuperoCertificadoDeuda.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_CERTIFICADO_DEUDA_APROBADO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Aprobado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	public static void pasarPagado(Long idRf){

		RecuperoCertificadoDeuda rf = Ebean.find(RecuperoCertificadoDeuda.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_CERTIFICADO_DEUDA_PAGADO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Pagado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	public static void pasarCancelado(Long idRf){

		RecuperoCertificadoDeuda rf = Ebean.find(RecuperoCertificadoDeuda.class).select("id, estado_id,write_date,write_usuario_id").setId(idRf).findUnique();

		if(rf != null){
			rf.estado_id = new Long(Estado.RECUPERO_CERTIFICADO_DEUDA_CANCELADO);
			rf.write_date = new Date();
			rf.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			rf.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	public static Result reporteCartaDocumento(Long id,Boolean correo) throws IOException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/carta_documento.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry

			  InputStream in = Play.application().resourceAsStream("resources/reportes/recupero/carta_documento.odt");
			  if(correo) {
				  in = Play.application().resourceAsStream("resources/reportes/recupero/carta_documento_correo_argentino.odt");
			  }
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();

		      RecuperoCertificadoDeuda certificado = RecuperoCertificadoDeuda.find.byId(id);

		      context.put("fecha",(certificado.fecha != null)?DateUtils.formatDate(certificado.fecha):"");

		      context.put("expediente",(certificado.expediente.getInstitucionExpedienteEjercicio() != null)?certificado.expediente.getInstitucionExpedienteEjercicio():"");
		      context.put("expedienteCaratura",(certificado.expediente != null)?certificado.expediente.descripcion:"");
		      context.put("cliente",(certificado.cliente.nombre != null)?certificado.cliente.nombre:"");
		      context.put("cliente_direccion",(certificado.cliente.getFirstDireccion() != null)?certificado.cliente.getFirstDireccion():"");
		      context.put("cuit",(certificado.cliente.cuit2 != null)?certificado.cliente.cuit2:"");

		      context.put("numero",(certificado.numero != null)? certificado.numero:"");
		      context.put("numeroEjercicio",(certificado.numero != null)? certificado.getNombreCompleto():"");

		      String fechaStr = "";
		      fechaStr = DateUtils.formatDate(certificado.fecha,"dd")+" de "+DateUtils.getMesLetras(new Integer(DateUtils.formatDate(certificado.fecha,"MM"))-1) +" "+DateUtils.formatDate(certificado.fecha,"YYYY");
		      context.put("fechaStr",fechaStr);

		      context.put("monto",utils.NumberUtils.moneda(certificado.getTotal()));
		      new NumeroALetra();
			  context.put("monto_letra", NumeroALetra.convertNumberToLetter(String.valueOf(certificado.getTotal())));



		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }

	    	return ok(archivo);
	}

	public static Result reporteDispoCertificadoDeuda(Long id) throws IOException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/dispo_certificado_deuda.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/recupero/dispo_certificado_deuda.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();

		      RecuperoCertificadoDeuda certificado = RecuperoCertificadoDeuda.find.byId(id);

		      context.put("fecha",(certificado.fecha != null)?DateUtils.formatDate(certificado.fecha):"");

		      context.put("expediente",(certificado.expediente != null)?certificado.expediente.getInstitucionExpedienteEjercicio():"");
		      context.put("cliente",(certificado.cliente.nombre != null)?certificado.cliente.nombre:"");
		      context.put("cuit",(certificado.cliente.cuit2 != null)?certificado.cliente.cuit2:"");

		      context.put("numero",(certificado.numero != null)? certificado.getNombreCompleto():"");
		      String fechaStr = "";
		      fechaStr = DateUtils.formatDate(certificado.fecha,"dd")+" de "+DateUtils.getMesLetras(new Integer(DateUtils.formatDate(certificado.fecha,"MM"))-1) +" "+DateUtils.formatDate(certificado.fecha,"YYYY");
		      context.put("fechaStr",fechaStr);

		      context.put("monto",utils.NumberUtils.moneda(certificado.getTotal()));
		      new NumeroALetra();
			  context.put("monto_letra", NumeroALetra.convertNumberToLetter(String.valueOf(certificado.getTotal())));



		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }

	    	return ok(archivo);
	}

	public static Result reporteCertificadoDeuda(Long id) throws IOException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/certificado_deuda.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/recupero/certificadodeuda3.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();

		      RecuperoCertificadoDeuda certificado = RecuperoCertificadoDeuda.find.byId(id);

		      context.put("fecha",(certificado.fecha != null)?DateUtils.formatDate(certificado.fecha):"");

		      context.put("expediente",(certificado.expediente != null)?certificado.expediente.getInstitucionExpedienteEjercicio():"");
		      context.put("cliente",(certificado.cliente.nombre != null)?certificado.cliente.nombre:"");
		      context.put("cuit",(certificado.cliente.cuit2 != null)?certificado.cliente.cuit2:"");

		      context.put("numero",(certificado.numero != null)? certificado.getNombreCompleto():"");
		      String fechaStr = "";
		      fechaStr = DateUtils.formatDate(certificado.fecha,"dd")+" de "+DateUtils.getMesLetras(new Integer(DateUtils.formatDate(certificado.fecha,"MM"))-1) +" "+DateUtils.formatDate(certificado.fecha,"YYYY");
		      context.put("fechaStr",fechaStr);

		      context.put("monto",utils.NumberUtils.moneda(certificado.getTotal()));
		      new NumeroALetra();
			  context.put("monto_letra", NumeroALetra.convertNumberToLetter(String.valueOf(certificado.getTotal())));

			  DireccionCliente dp =   certificado.cliente.getFirstDireccionObj();

			  String calle = (dp != null && dp.calle != null)?dp.calle:"";
		      String numero = (dp != null && dp.numero != null)?dp.numero:"";
		      String otro = (dp.otro != null)?"-"+dp.otro:"";
		      String localidad = (dp != null && dp.localidad != null)? dp.localidad.nombre:"";
		      String provincia = (dp != null && dp.localidad != null && dp.localidad.provincia != null)?dp.localidad.provincia.nombre:"";
		      String pais = (dp != null && dp.localidad != null && dp.localidad.provincia != null && dp.localidad.provincia.pais != null)?dp.localidad.provincia.pais.nombre:"";
		      String cp = (dp != null && dp.cp != null)?" - CP "+ dp.cp:"";
 		      String direccionTotal = calle+" "+numero+otro+", "+localidad+" "+cp+" provincia de " +provincia;
 		      String direccion = calle+" "+numero;



 		      context.put("provincia",provincia);
 		      context.put("localidad",localidad+cp);
			  context.put("direccion",direccion);
			  context.put("direccionTotal",direccionTotal);

			  context.put("lineas",certificado.recuperoCerficadoDeudaLinea);

			  context.put("dateUtils", new DateUtils());
			  context.put("numberUtils", new NumberUtils());



		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }

	    	return ok(archivo);
	}

	public static Result suggestCertificadoDeudas(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode ordenes = rpta.arrayNode();

	    RecuperoCertificadoDeuda ad = new RecuperoCertificadoDeuda();

		for(RecuperoCertificadoDeuda a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.getNombreCompleto());
	        restJs.put("info", "");
	        ordenes.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", ordenes);

		return ok(response);
	}


	public static Result modalBuscar() {
    	Pagination<RecuperoCertificadoDeuda> p = new Pagination<RecuperoCertificadoDeuda>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	Model.Finder<Long,RecuperoCertificadoDeuda> find = new Finder<Long,RecuperoCertificadoDeuda>(Long.class, RecuperoCertificadoDeuda.class);

    	ExpressionList<RecuperoCertificadoDeuda> e = find
				.fetch("cliente", "nombre")
				.where();

    	if(!RequestVar.get("numero").isEmpty()) {
    		e.ilike("numero", "%" + RequestVar.get("numero") + "%");
    	}

    	p.setExpressionList(e);
		return ok( modalBusquedaCertificadoDeuda.render(p, form().bindFromRequest()) );
	}

	public static Result get(int id){
		RecuperoCertificadoDeuda cert = RecuperoCertificadoDeuda.find.fetch("cliente", "nombre") .where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(cert == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el certificado");
		} else {
			restJs.put("success", true);
			restJs.put("id", cert.id);
			restJs.put("nombre", cert.getNombreCompleto());
			restJs.put("cliente", cert.cliente.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}


	public static Result modalCargarCertificadoDeuda() {
		return ok(modalCargarCertificadoDeuda.render(form().bindFromRequest()));
	}

	public static Result cargarCertificadoDeuda() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		//FACTURAS CONTROL
		List<Integer> factSeleccionados = getSeleccionados();

		if(factSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalCargarCertificadoDeuda.render(d));
		}

		if(!soloSinCertficiadoAsignado(factSeleccionados)) {
			flash("error", "Solo se puede agregar facturas que no tenga certificado asignado.");
			return ok(modalPasarEnPreCurso.render(d));
		}

		//CERTIFICADOS CONTROL
		Integer idCert  = null;
		if(request().body().asFormUrlEncoded().get("cert_id_modal") !=null && !request().body().asFormUrlEncoded().get("cert_id_modal")[0].isEmpty()){
			idCert = new Integer(request().body().asFormUrlEncoded().get("cert_id_modal")[0]);
		}else {
			flash("error", "Debe seleccionar un certificado.");
			return ok(modalCargarCertificadoDeuda.render(d));

		}

		RecuperoCertificadoDeuda ce = RecuperoCertificadoDeuda.find.where().eq("id",idCert).findUnique();

		if(ce == null){
			flash("error", "No se encuentra el certificado");
			return ok(modalCargarCertificadoDeuda.render(d));
		}else {
			if(ce.estado_id.compareTo(new Long(Estado.RECUPERO_CERTIFICADO_DEUDA_BORRADOR)) != 0 ) {
				flash("error", "El certificado seleccionado debe estar en estado Borrador");
				return ok(modalCargarCertificadoDeuda.render(d));
			}
		}

		//CERTIFICADO-FACTURAS CONTROL
		if(!mismoCliente(factSeleccionados,ce.cliente_id)) {
			flash("error", "Los clientes de las facturas seleccionados deben coincidir con el cliente del certificado.");
			return ok(modalCargarCertificadoDeuda.render(d));
		}

		//CERTIFICADO-FACTURAS CONTROL
		List<InformeTotal> listInforme = InformeTotal.find.where().in("id", factSeleccionados).gt("total_deuda", Float.parseFloat("0")).findList();
		if(listInforme.size() != factSeleccionados.size()) {
			flash("error", "Solo se pueden asignar facturas con deuda.");
			return ok(modalCargarCertificadoDeuda.render(d));
		}

		if(d.hasErrors())
			return ok(modalCargarCertificadoDeuda.render(d));

		ObjectNode result = Json.newObject();

		Map<Long,BigDecimal> facturaDeuda = new HashMap<>();
		for(InformeTotal ix:listInforme) {
			facturaDeuda.put(ix.id, ix.totalDeuda);
		}



		try {



			Ebean.beginTransaction();
			List<RecuperoFactura> lf = RecuperoFactura.find.where().in("id", factSeleccionados).findList();
			for(RecuperoFactura lfx:lf) {


				RecuperoCerficadoDeudaLinea rcl = new RecuperoCerficadoDeudaLinea();
				rcl.create_usuario_id =  Usuario.getUsuarioSesion().longValue();
				rcl.recupero_certificado_deuda_id = ce.id;
				rcl.recupero_factura_id = lfx.id;
				rcl.deuda = facturaDeuda.get(lfx.id);
				rcl.save();

			}

			RecuperoFactura.modificarCertificadoDeudaId(ce.id,factSeleccionados);

			Ebean.commitTransaction();
			result.put("success", true);
			result.put("html", modalCargarCertificadoDeuda.render(d).toString());
			return ok(result);


		} catch (Exception e){
			Ebean.rollbackTransaction();
			flash("error", "No se puede modificar los registros.");
			return ok(modalCargarCertificadoDeuda.render(d));
		}

	}

	public static Boolean facturaSoloConDeuda(List<Integer> facturasSeleccionados) {
		return InformeTotal.find.where().in("id", facturasSeleccionados).gt("total_deuda", Float.parseFloat("0")).findRowCount() == facturasSeleccionados.size();
	}

	public static Boolean soloSinCertficiadoAsignado(List<Integer> facturasSeleccionados) {
		return RecuperoFactura.find.where().isNotNull("recupero_certificado_deuda_id").in("id", facturasSeleccionados).findRowCount() == 0;
	}

	public static Boolean mismoCliente(List<Integer> facturasSeleccionados,Long idCliente) {
		return RecuperoFactura.find.where().eq("cliente_id",idCliente).in("id", facturasSeleccionados).findRowCount() == facturasSeleccionados.size();
	}

	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado[]");
		} catch (NullPointerException e) {
		}

		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}
}
