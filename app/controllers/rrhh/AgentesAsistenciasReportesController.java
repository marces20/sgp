package controllers.rrhh;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import models.AgenteAsistenciaLicencia;
import models.Cuenta;
import models.FacturaLineaImpuesto;
import models.Orden;
import models.OrdenLinea;
import models.OrdenLineaCliente;
import models.haberes.LiquidacionNovedadLicencia;
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
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import views.html.compras.ordenes.reportes.resultadoCuadroComparativoPrecios;
import views.html.rrhh.agente.modales.modalDatosAgente;
import views.html.rrhh.agenteAsistencia.reportes.*;

@Security.Authenticated(Secured.class)
public class AgentesAsistenciasReportesController extends Controller {

	public static Result exportacionNovedadesLicencias() {

		DynamicForm d = form().bindFromRequest();
		List<Integer> nSeleccionadas = getSeleccionados();

		if(nSeleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado licencias.");
			return ok(modalDatosAgente.render(null,d));
		}

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/novedades.xls");

		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);

			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);

			Sheet hoja = libro.createSheet("lineas");

			List<LiquidacionNovedadLicencia> o = LiquidacionNovedadLicencia.find.where().in("id", nSeleccionadas).findList();

			if(o.size() > 0){
				int x = 0;
				Row fila;
				Cell celda0;



					fila = hoja.createRow(x);


					celda0 = fila.createCell(0);
					celda0.setCellValue("APELLIDO Y NOMBRE");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue("Cuil");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(2);

					celda0.setCellValue("codigo");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(3);
					celda0.setCellValue("Concepto");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(4);
					celda0.setCellValue("Cantidad");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(5);
					celda0.setCellValue("IMPORTE");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(6);
					celda0.setCellValue("PERIODO");
					celda0.setCellStyle(comun);
					x++;
				for(LiquidacionNovedadLicencia oll : o){
					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(oll.agenteAsistenciaLicencia.agente.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(oll.agenteAsistenciaLicencia.agente.cuit);
					celda0.setCellStyle(comun);
					//10960 diferencial por vacaciones
					//70960 ajuste diferencial por vacaciones

					String codigo = (oll.dias > 0)?"10960":"70960";

					celda0 = fila.createCell(2);
					celda0.setCellValue(codigo);
					celda0.setCellStyle(comun);

					String concepto = (oll.dias > 0)?"DIFERENCIAL POR VACACIONES":"AJUSTE DIFERENCIAL POR VACACIONES";

					celda0 = fila.createCell(3);
					celda0.setCellValue(concepto);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue(oll.dias);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(5);
					celda0.setCellValue("");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(6);
					celda0.setCellValue(oll.periodo.nombre);
					celda0.setCellStyle(comun);

					x++;



				}

			}

			libro.write(archivoTmp);
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalDatosAgente.render(archivo.getPath(),d));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(modalDatosAgente.render(null,d));

	}

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
