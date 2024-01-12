package controllers.rrhh;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import models.AgenteAsistenciaLicencia;
import models.Cuenta;
import models.FacturaLineaImpuesto;
import models.haberes.PuestoLaboral;
import controllers.Secured;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import play.Logger;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import views.html.rrhh.agenteAsistencia.reportes.*;

@Security.Authenticated(Secured.class)
public class AgentesAsistenciasReportesController extends Controller {

	public static Result reporteLicenciaMedicinaLaboral(Long idIUser) {

		List<Integer> licenciaSeleccionados = getSeleccionados();
		if(licenciaSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar una licencia para generar el reporte.");
			return ok(reporteLicencia.render(null));
		}

		if(licenciaSeleccionados.size() > 1){
			flash("error", "Debe seleccionar solo una licencia para generar el reporte.");
			return ok(reporteLicencia.render(null));
		}

		AgenteAsistenciaLicencia aal = AgenteAsistenciaLicencia.find.byId(licenciaSeleccionados.get(0).longValue());


		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/ficha_licencia_medica.odt");

		try{

			InputStream in = Play.application().resourceAsStream("resources/reportes/rrhh/ficha_licencia_medica.odt");

			if (idIUser.compareTo(new Long(0))== 0) {
				in = Play.application().resourceAsStream("resources/reportes/rrhh/ficha_licencia_medica_lesik.odt");
			}else if (idIUser.compareTo(new Long(437))== 0) {
				in = Play.application().resourceAsStream("resources/reportes/rrhh/ficha_licencia_medica_britto.odt");
			}


			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();

			String fpresentacion = (aal.fpresentacion != null)?DateUtils.formatDate(aal.fpresentacion,"dd/MM/yyyy"):"";
			context.put("fpresentacion", fpresentacion);
			context.put("aal", aal);
			context.put("usuario", aal.create_usuario.nombre);
			context.put("art", (aal.tipoLicencia.articulo!= null)?aal.tipoLicencia.articulo:"");
			context.put("cie", (aal.cie_id != null)?aal.cie.nombre:"");

			String agrupamiento = "";
			PuestoLaboral pl = PuestoLaboral.find.where().eq("legajo.agente_id", aal.agente_id).eq("activo",true).findUnique();
			if(pl != null) {
				agrupamiento = pl.escalaLaboral.abreviatura;
			}
			context.put("agrupamiento", agrupamiento);

			context.put("date", new DateUtils());

			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);

		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteLicencia.render(null));
		}

		return ok(reporteLicencia.render(archivo.getPath()));
	}

	public static Result reporteLicencia(boolean comun) {

		List<Integer> licenciaSeleccionados = getSeleccionados();
		if(licenciaSeleccionados.isEmpty()) {
			flash("error", "Debe seleccionar una licencia para generar el reporte.");
			return ok(reporteLicencia.render(null));
		}

		if(licenciaSeleccionados.size() > 1){
			flash("error", "Debe seleccionar solo una licencia para generar el reporte.");
			return ok(reporteLicencia.render(null));
		}

		AgenteAsistenciaLicencia aal = AgenteAsistenciaLicencia.find.byId(licenciaSeleccionados.get(0).longValue());


		String dirTemp = System.getProperty("java.io.tmpdir");

		File archivo = new File(dirTemp+"/ficha_licencia.odt");
		if(!comun) {
			archivo = new File(dirTemp+"/licencia_interrupcion.odt");
		}

		try{

			InputStream in = Play.application().resourceAsStream("resources/reportes/rrhh/ficha_licencia.odt");
			if(!comun) {
				in = Play.application().resourceAsStream("resources/reportes/rrhh/licencia_interrupcion.odt");
			}


			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();

			String fpresentacion = (aal.fpresentacion != null)?DateUtils.formatDate(aal.fpresentacion,"dd/MM/yyyy"):"";
			context.put("fpresentacion", fpresentacion);
			context.put("aal", aal);
			context.put("usuario", aal.create_usuario.nombre);

			context.put("date", new DateUtils());

			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);

		}catch (Exception e) {
			Logger.error(e.toString());
			flash("error", "No se pudo generar el reporte.");
			return ok(reporteLicencia.render(null));
		}

		return ok(reporteLicencia.render(archivo.getPath()));
	}

	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado_inasistencia[]");
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
