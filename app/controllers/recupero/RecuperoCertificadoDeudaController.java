package controllers.recupero;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.google.common.collect.Lists;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import de.mhus.lib.core.logging.LogFactory;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import models.Expediente;
import models.Solicitud;
import models.SolicitudLinea;
import models.recupero.RecuperoCertificadoDeuda;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoNotaDebito;
import models.recupero.RecuperoPago;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumeroALetra;
import utils.RequestVar;
import utils.UriTrack;
import views.html.recupero.recuperoCertificadoDeuda.*;

@Security.Authenticated(Secured.class)
public class RecuperoCertificadoDeudaController  extends Controller {

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
												  		RequestVar.get("fecha_desde")
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
		}else {

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

	public static Result reporteCertificadoDeuda(Long id) throws IOException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/certificado_deuda.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/recupero/certificado_deuda.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();

		      RecuperoCertificadoDeuda certificado = RecuperoCertificadoDeuda.find.byId(id);

		      context.put("fecha",(certificado.fecha != null)?DateUtils.formatDate(certificado.fecha):"");

		      context.put("expediente",(certificado.expediente.getExpedienteEjercicio() != null)?certificado.expediente.getExpedienteEjercicio():"");
		      context.put("cliente",(certificado.cliente.nombre != null)?certificado.cliente.nombre:"");
		      context.put("cuit",(certificado.cliente.cuit2 != null)?certificado.cliente.cuit2:"");

		      context.put("numero",(certificado.numero != null)? certificado.numero +"/"+ certificado.expediente.ejercicio.nombre :"");
		      String fechaStr = "";
		      fechaStr = DateUtils.formatDate(certificado.fecha,"dd")+" de "+DateUtils.getMesLetras(new Integer(DateUtils.formatDate(certificado.fecha,"MM"))-1) +" "+DateUtils.formatDate(certificado.fecha,"YYYY");
		      context.put("fechaStr",fechaStr);

		      context.put("monto",utils.NumberUtils.moneda(certificado.monto));
		      new NumeroALetra();
			  context.put("monto_letra", NumeroALetra.convertNumberToLetter(String.valueOf(certificado.monto)));



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


}
