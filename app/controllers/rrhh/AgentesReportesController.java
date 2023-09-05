package controllers.rrhh;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import models.Agente;
import models.AgenteEstudio;
import models.AgenteFamilia;
import models.AgenteHijo;
import models.AgenteNovedad;
import models.AgenteRul;
import models.Estado;
import models.haberes.LiquidacionConcepto;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionPuesto;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import views.html.rrhh.agente.modales.*;

@Security.Authenticated(Secured.class)
public class AgentesReportesController extends Controller  {

	@CheckPermiso(key = "reporteDatosAgente")
	public static Result reportesDatosAgente() {
		DynamicForm d = form().bindFromRequest();
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_agente.xls");


		List<Integer> agenteIds = getSeleccionados();

		if(agenteIds.size() <= 0){
			flash("error", "Debe seleccionar un Agente.");
			return ok(modalDatosAgente.render(null,d));
		}

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

			Sheet hoja = libro.createSheet("Seguro de Sepelio");

			List<Agente> lp = new Agente()
			.find
			.where().in("id",agenteIds).orderBy("apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Datos");
				celda0.setCellStyle(comun);
				x++;

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("DNI");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Cuit");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Organigrama");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Profesion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Especialidad");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("Puesto");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue("Relacion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(8);
				celda0.setCellValue("RUL");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(9);
				celda0.setCellValue("Agrupamiento");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(10);
				celda0.setCellValue("Horas");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(11);
				celda0.setCellValue("telefono");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(12);
				celda0.setCellValue("direccion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(13);
				celda0.setCellValue("legajo");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(14);
				celda0.setCellValue("matricula");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(15);
				celda0.setCellValue("fingreso");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(16);
				celda0.setCellValue("fnacimiento");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(17);
				celda0.setCellValue("email");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(18);
				celda0.setCellValue("edad");
				celda0.setCellStyle(comun);
				x++;


				BigDecimal total =  new BigDecimal(0);
				BigDecimal totalHaberes =  new BigDecimal(0);
				for (Agente l: lp) {

					System.out.println(l.apellido);
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(l.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(l.dni);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(l.cuit);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue((l.organigrama != null)?l.organigrama.nombre:"");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue((l.profesion != null)?l.profesion.nombre:"");
					celda0.setCellStyle(comun);
					System.out.println("1111111111");
					celda0 = fila.createCell(5);
					celda0.setCellValue((l.especialidad_id != null)?l.especialidad.nombre:"");
					celda0.setCellStyle(comun);
					System.out.println("22222222222");
					celda0 = fila.createCell(6);
					celda0.setCellValue((l.puesto != null)?l.puesto.nombre:"");
					celda0.setCellStyle(comun);

					String relacion = "";
					switch ( l.tipo_relacion_laboral ) {
				    	case  "1": relacion = "Contrato Relacion Parque de la salud"; break;
				    	case  "2": relacion = "Monotributo Parque de la salud"; break;
				    	case  "3": relacion = "Contrato Relacion Convenio Ministerio Salud"; break;
				    	case  "4": relacion = "Planta Ministerio Salud"; break;
				    	case  "5": relacion = "Contrato Relacion Ministerio Salud"; break;
				    	case  "6": relacion = "Adscripto Otras Entidades"; break;
				    	case  "7": relacion = "Contrato Convenio Nacion"; break;
				    	case  "8": relacion = "Planta Temporaria - Otras Entidades"; break;
				    	case  "9": relacion = "Otro"; break;
				    }


					celda0 = fila.createCell(7);
					celda0.setCellValue(relacion);
					celda0.setCellStyle(comun);

					String rul = "";

					if(l.agenteRuls.size() > 0) {

						for(AgenteRul ar :l.agenteRuls) {
							rul += ar.institucionExterna.nombre+" - "+ar.tipoRelacionLaboral.nombre+" | ";
						}


						celda0 = fila.createCell(8);
						celda0.setCellValue(rul);
						celda0.setCellStyle(comun);
					}

					AgenteNovedad an = AgenteNovedad.find.where().eq("agente_id",l.id).setMaxRows(1).orderBy("id desc").findUnique();

					if(an != null) {

						String ag = (an.escalaLaboral != null)?an.escalaLaboral.nombre:"";
						String ch = (an.carga_horaria != null)?an.carga_horaria.toString():"";

						celda0 = fila.createCell(9);
						celda0.setCellValue(ag);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(10);
						celda0.setCellValue(ch);
						celda0.setCellStyle(comun);
					}


					celda0 = fila.createCell(11);
					celda0.setCellValue((l.telefono != null)?l.telefono:"");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(12);
                    celda0.setCellValue(l.getDireccionCompleta());
                    celda0.setCellStyle(comun);

                    if(l.legajos.size() > 0) {
                    	if(	l.legajos.get(0) != null) {
	                    	celda0 = fila.createCell(13);
	                        celda0.setCellValue(l.legajos.get(0).numero.toString());
	                        celda0.setCellStyle(comun);
                    	}
                    }

                    celda0 = fila.createCell(14);
                    celda0.setCellValue(l.pin);
                    celda0.setCellStyle(comun);

                    celda0 = fila.createCell(15);
                    celda0.setCellValue(utils.DateUtils.formatDate(l.fingreso));
                    celda0.setCellStyle(comun);

                    celda0 = fila.createCell(16);
                    celda0.setCellValue(utils.DateUtils.formatDate(l.fnacimiento));
                    celda0.setCellStyle(comun);

                    celda0 = fila.createCell(17);
                    celda0.setCellValue(l.email);
                    celda0.setCellStyle(comun);

                    celda0 = fila.createCell(18);
                    celda0.setCellValue(l.getEdad());
                    celda0.setCellStyle(comun);

					x++;

				}


			}

			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(modalDatosAgente.render(archivo.getPath(),d));
	}

	@CheckPermiso(key = "reporteDatosAgente")
	public static Result reportesDatosRulAgente() {
		DynamicForm d = form().bindFromRequest();
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_agente_rul.xls");


		List<Integer> agenteIds = getSeleccionados();

		if(agenteIds.size() <= 0){
			flash("error", "Debe seleccionar un Agente.");
			return ok(modalDatosAgente.render(null,d));
		}

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

			Sheet hoja = libro.createSheet("Seguro de Sepelio");

			List<Agente> lp = new Agente()
			.find
			.where().in("id",agenteIds).orderBy("apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Datos");
				celda0.setCellStyle(comun);
				x++;

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("DNI");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Cuit");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Organigrama");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Profesion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Relacion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("RUL");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue("Tipo Relacion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(8);
				celda0.setCellValue("Institucion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(9);
				celda0.setCellValue("Nota");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(10);
				celda0.setCellValue("telefono");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(11);
				celda0.setCellValue("direccion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(12);
				celda0.setCellValue("email");
				celda0.setCellStyle(comun);



				x++;


				BigDecimal total =  new BigDecimal(0);
				BigDecimal totalHaberes =  new BigDecimal(0);
				for (Agente l: lp) {




					System.out.println(l.apellido);
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(l.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(l.dni);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(l.cuit);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue((l.organigrama != null)?l.organigrama.nombre:"");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue((l.profesion != null)?l.profesion.nombre:"");
					celda0.setCellStyle(comun);
					System.out.println("1111111111");



					String relacion = "";
					switch ( l.tipo_relacion_laboral ) {
				    	case  "1": relacion = "Contrato Relacion Parque de la salud"; break;
				    	case  "2": relacion = "Monotributo Parque de la salud"; break;
				    	case  "3": relacion = "Contrato Relacion Convenio Ministerio Salud"; break;
				    	case  "4": relacion = "Planta Ministerio Salud"; break;
				    	case  "5": relacion = "Contrato Relacion Ministerio Salud"; break;
				    	case  "6": relacion = "Adscripto Otras Entidades"; break;
				    	case  "7": relacion = "Contrato Convenio Nacion"; break;
				    	case  "8": relacion = "Planta Temporaria - Otras Entidades"; break;
				    	case  "9": relacion = "Otro"; break;
				    }


					celda0 = fila.createCell(5);
					celda0.setCellValue(relacion);
					celda0.setCellStyle(comun);

					String rul = "";

					if(l.agenteRuls.size() > 0) {

						for(AgenteRul ar :l.agenteRuls) {

							celda0 = fila.createCell(6);
							celda0.setCellValue(rul);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(7);
							celda0.setCellValue(ar.tipoRelacionLaboral.nombre);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(8);
							celda0.setCellValue(ar.institucionExterna.nombre);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(9);
							celda0.setCellValue(ar.nota);
							celda0.setCellStyle(comun);
						}
					}


					celda0 = fila.createCell(10);
					celda0.setCellValue((l.telefono != null)?l.telefono:"");
					celda0.setCellStyle(comun);


                    celda0 = fila.createCell(11);
                    celda0.setCellValue(l.getDireccionCompleta());
                    celda0.setCellStyle(comun);



                    celda0 = fila.createCell(12);
                    celda0.setCellValue(l.email);
                    celda0.setCellStyle(comun);

					x++;

				}


			}

			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(modalDatosAgente.render(archivo.getPath(),d));
	}

	public static Result reportesCertificacionesAgente() {
		DynamicForm d = form().bindFromRequest();
		List<Integer> agenteIds = getSeleccionados();

		if(agenteIds.size() <= 0){
			flash("error", "Debe seleccionar un Agente.");
			return ok(modalDatosAgente.render(null,d));
		}

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/certificaciones_agente.odt");

		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/rrhh/certificaciones_agente.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();


			List<Agente> a = Agente.find.where().in("id",agenteIds).orderBy("apellido asc").findList();

			context.put("agente", a);

			OutputStream out = new FileOutputStream(archivo);
	        report.process(context, out);

	        return ok(modalDatosAgente.render(archivo.getPath(),d));

		}  catch (Exception e) {
			System.out.println(e);
		}

		return ok(modalDatosAgente.render(null,d));
	}



	public static Result ficha(Long id) {

		Agente a = Agente.find.byId(id);

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/ficha-personal.odt");

		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/rrhh/ficha-personal2.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();


			List<AgenteFamilia> ah = AgenteFamilia.find.where().eq("agente_id", id).eq("tipo_familia_id", 1).findList();
			AgenteFamilia cy = AgenteFamilia.find.where().eq("agente_id", id).eq("tipo_familia_id", 2).order("id desc").setMaxRows(1).findUnique();
			context.put("agente", a);
			context.put("agenteHijos", ah);

			context.put("legajo", (a.legajos != null && a.legajos.size() > 0)?a.legajos.get(0).numero:"" );

			List<AgenteEstudio> ae = AgenteEstudio.find.where().eq("agente_id", id).order("id desc").findList();

			context.put("agenteEstudios", ae);

			context.put("conyuge_nombre",(cy != null)?cy.nombre:"");
			context.put("conyuge_dni",(cy != null)?cy.dni:"");
			context.put("date",  new DateUtils());


			OutputStream out = new FileOutputStream(archivo);
	        report.process(context, out);

	        return ok(archivo);

		}  catch (Exception e) {
			System.out.println(e);
		}

		return ok();
	}

	public static Result fichaAptitud(Long id) {

		Agente a = Agente.find.byId(id);

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/examen-aptitud-psico-fisico.odt");

		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/rrhh/examen-aptitud-psico-fisico2.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();


			List<AgenteFamilia> ah = AgenteFamilia.find.where().eq("agente_id", id).eq("tipo_familia_id", 1).findList();
			AgenteFamilia cy = AgenteFamilia.find.where().eq("agente_id", id).eq("tipo_familia_id", 2).order("id desc").setMaxRows(1).findUnique();
			context.put("agente", a);
			context.put("agenteHijos", ah);

			context.put("conyuge_nombre",(cy != null)?cy.nombre:"");
			context.put("conyuge_dni",(cy != null)?cy.dni:"");
			context.put("date",  new DateUtils());


			OutputStream out = new FileOutputStream(archivo);
	        report.process(context, out);

	        return ok(archivo);

		}  catch (Exception e) {
			System.out.println(e);
		}

		return ok();
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
