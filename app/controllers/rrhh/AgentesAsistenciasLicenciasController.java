package controllers.rrhh;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.AgenteAsistenciaLicencia;
import models.AgenteNovedad;
import models.CertificacionLinea;
import models.Ejercicio;
import models.Estado;
import models.ExpedienteMovimiento;
import models.Factura;
import models.FacturaLinea;
import models.Orden349;
import models.OrdenPagoCircuito;
import models.Organigrama;
import models.Usuario;
import models.auth.Permiso;
import models.haberes.LiquidacionConcepto;
import models.haberes.LiquidacionNovedadLicencia;
import models.haberes.Novedad;
import models.haberes.PuestoLaboral;
import models.recupero.InformeTotal;
import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.RequestVar;
import utils.pagination.Pagination;
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.contabilidad.facturas.acciones.modalCargar349;
import views.html.contabilidad.facturas.acciones.modalPasarEnPreCurso;
import views.html.contabilidad.facturas.acciones.modalPasarPreAprobado;
import views.html.rrhh.agenteAsistenciaLicencia.*;
import views.html.rrhh.agenteAsistenciaLicencia.acciones.*;

@Security.Authenticated(Secured.class)
public class AgentesAsistenciasLicenciasController extends Controller {

	final static Form<AgenteAsistenciaLicencia> lineaForm = form(AgenteAsistenciaLicencia.class);

	public static Result index(Long agenteId, Boolean editable,Long tipoLicencia) {
		Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzz");



		Pagination<AgenteAsistenciaLicencia> lineas = AgenteAsistenciaLicencia.page(agenteId,tipoLicencia);
		Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzz");
		return ok(indexAgenteAsistenciaLicencia.render(lineas, editable,AgenteAsistenciaLicencia.getDiasLicenciaReglamentariaPorEjercicio(agenteId)));
	}

	public static Result indexLicenciaNovedadesLiquidacion() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		Pagination<LiquidacionNovedadLicencia> lineas = LiquidacionNovedadLicencia.page(RequestVar.get("nombre"),
				 																		RequestVar.get("cuit"),
				 																		RequestVar.get("dni"),
				 																		RequestVar.get("periodo_id"),
				 																		RequestVar.get("tipo_relacion_laboral"),
				 																		RequestVar.get("organigrama_id"),
				 																		RequestVar.get("activo"),
				 																		RequestVar.get("btnFiltro[0]"),//borrador
				 																		RequestVar.get("btnFiltro[1]"),//cargado
				 																		RequestVar.get("btnFiltro[2]")//aprobado
				 																		);

		return ok(indexLicenciaNovedadesLiquidacion.render(lineas,d));
	}

	@CheckPermiso(key = "agentesLicenciasCrear")
	public static Result crear(String agenteId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("agente_id", agenteId);
		Form<AgenteAsistenciaLicencia> linea = form(AgenteAsistenciaLicencia.class).bind(b);
		linea.discardErrors();
		return ok(crearAgenteAsistenciaLicencia.render(linea));
	}

	@CheckPermiso(key = "agentesLicenciasCrear")
	public static Result guardar() {
		Form<AgenteAsistenciaLicencia> lineaForm = form(AgenteAsistenciaLicencia.class).bindFromRequest();

		try {
			validarForm(lineaForm);
			if(lineaForm.hasErrors()) {
				System.out.println(lineaForm.errors());
				flash("error", "Error en formulario");
				return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
			} else {
				AgenteAsistenciaLicencia l = lineaForm.get();
				if(lineaForm.get().ffin.before(lineaForm.get().finicio)){
					//flash("error", "La Fecha de fin es manor a la Fecha de inicio.");
					//return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}


				Calendar calendarFinicio = Calendar.getInstance();
				calendarFinicio.setTime(lineaForm.get().finicio);

				Calendar calendarFfin = Calendar.getInstance();
				calendarFfin.setTime(lineaForm.get().ffin);

				Integer YEARFINICIO = calendarFinicio.get(Calendar.YEAR);
				Ejercicio ejFinicio = Ejercicio.find.where().eq("nombre", YEARFINICIO.toString()).findUnique();
				if(ejFinicio == null) {
					flash("error", "No existe el ejercicio para la fecha de inicio");
					return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}

				Integer YEARFFIN = calendarFfin.get(Calendar.YEAR);
				Ejercicio ejFin= Ejercicio.find.where().eq("nombre", YEARFFIN.toString()).findUnique();
				if(ejFin == null) {
					flash("error", "No existe el ejercicio para la fecha de fin");
					return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}


				int diasPermitidos = 30;
				int diasPermitidosFin = 120;
				if(Permiso.check("agentesLicenciasCargarMas200dias")){
					diasPermitidos = 1000;
					diasPermitidosFin = 1000;
				}

				Date ahora = new Date();
				long diferenciaEn_ms = lineaForm.get().finicio.getTime() - ahora.getTime();
				long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
				if((int) dias > diasPermitidos || (int) dias < -diasPermitidos){
					flash("error", "La Fecha de inicio no puede ser ni mayor ni menor de "+diasPermitidos+" dias desde hoy.");
					return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}

				ahora = new Date();
				diferenciaEn_ms = lineaForm.get().ffin.getTime() - ahora.getTime();
				dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
				if((int) dias > diasPermitidosFin || (int) dias < -diasPermitidosFin){
					flash("error", "La Fecha de fin no puede ser ni mayor ni menor de "+diasPermitidosFin+" dias desde hoy.");
					return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}


				if(!l.tienePermisosTipoLicencia(l)){
					flash("error", "No tiene permisos para cargar este tipo de licencias.");
					return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
				}

				l.dias = l.getDiasEntreFechas();
				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.estado_id = (long)Estado.AGENTE_LICENCIA_BORRADOR;
				l.save();

				AgenteAsistenciaLicencia fltmp = AgenteAsistenciaLicencia.find.byId(l.id);
				fltmp.dias = fltmp.getDiasEntreFechas();
				fltmp.update();

				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(crearAgenteAsistenciaLicencia.render(lineaForm));
		}

		AgenteAsistenciaLicencia linea = AgenteAsistenciaLicencia.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verAgenteAsistenciaLicencia.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "agentesLicenciasModificar")
	public static Result editar(Long id) {
		flash().clear();
		AgenteAsistenciaLicencia linea = AgenteAsistenciaLicencia.find.byId(id);
		if(!linea.tienePermisosTipoLicencia(linea)){
			flash("error", "No tiene permisos para editar este tipo de licencias.");
			return ok(editarAgenteAsistenciaLicencia.render(lineaForm.fill(linea),false));
		}

		return ok(editarAgenteAsistenciaLicencia.render(lineaForm.fill(linea),true));
	}

	@CheckPermiso(key = "agentesLicenciasModificar")
	public static Result actualizar() {

		Form<AgenteAsistenciaLicencia> lineaForm = form(AgenteAsistenciaLicencia.class).bindFromRequest();

		try {
			validarForm(lineaForm);
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarAgenteAsistenciaLicencia.render(lineaForm,true));
			} else {
				AgenteAsistenciaLicencia fl = lineaForm.get();

				if(lineaForm.get().ffin.before(lineaForm.get().finicio)){
					//flash("error", "La Fecha de fin es manor a la Fecha de inicio.");
					//return ok(editarAgenteAsistenciaLicencia.render(lineaForm,true));
				}
				if(!fl.tienePermisosTipoLicencia(fl)){
					flash("error", "No tiene permisos para cargar este tipo de licencias.");
					return ok(editarAgenteAsistenciaLicencia.render(lineaForm,true));
				}

				fl.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				fl.write_date = new Date();
				fl.dias = fl.getDiasEntreFechas();
				fl.update();

				AgenteAsistenciaLicencia fltmp = AgenteAsistenciaLicencia.find.byId(fl.id);
				fltmp.dias = fltmp.getDiasEntreFechas();
				fltmp.update();


			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarAgenteAsistenciaLicencia.render(lineaForm,true));
		}

		AgenteAsistenciaLicencia linea = AgenteAsistenciaLicencia.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verAgenteAsistenciaLicencia.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "agentesLicenciasEliminar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			AgenteAsistenciaLicencia aal = AgenteAsistenciaLicencia.find.byId(id);
			if(!aal.tienePermisosTipoLicencia(aal)){
				flash("error", "No tiene permisos para cargar este tipo de licencias.");
				restJs.put("succes", false);
			}else{
				aal.delete();
			}


		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("succes", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}

	public static void validarForm(Form<AgenteAsistenciaLicencia> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("finicio", "Fecha inválida"));
		v.add(new DateValidation("ffin", "Fecha inválida"));
		v.validate();
	}

	@CheckPermiso(key = "agentesLicenciasPasarBorrador")
	public static Result modalPasarBorrador() {
		return ok(modalPasarBorrador.render(form().bindFromRequest()));
	}

	public static Result pasarBorradorMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> lSeleccionados = getSeleccionados();

		if(lSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			return ok(modalPasarBorrador.render(d));
		}

		if(!soloCancelado(lSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en cancelado.");
			return ok(modalPasarBorrador.render(d));
		}

		if(d.hasErrors())
			return ok(modalPasarBorrador.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = AgenteAsistenciaLicencia.modificarEstadoMasivo(Estado.AGENTE_LICENCIA_BORRADOR, lSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarBorrador.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarBorrador.render(d));
		}

	}

	public static Boolean soloCancelado(List<Integer> opcSeleccionados) {
		return AgenteAsistenciaLicencia.find.where().ne("estado_id", Estado.AGENTE_LICENCIA_CANCELADO).in("id", opcSeleccionados).findRowCount() == 0;
	}

	@CheckPermiso(key = "agentesLicenciasPasarPreAprobado")
	public static Result modalPasarPreAprobado() {
		return ok(modalPasarPreAprobado.render(form().bindFromRequest()));
	}

	public static Result pasarPreAprobadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> lSeleccionados = getSeleccionados();

		if(lSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			return ok(modalPasarPreAprobado.render(d));
		}

		if(!soloBorrador(lSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en borrador.");
			return ok(modalPasarPreAprobado.render(d));
		}

		if(d.hasErrors())
			return ok(modalPasarPreAprobado.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = AgenteAsistenciaLicencia.modificarEstadoMasivo(Estado.AGENTE_LICENCIA_PREAPROBADO, lSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarPreAprobado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarPreAprobado.render(d));
		}

	}

	@CheckPermiso(key = "agentesLicenciasPasarAprobado")
	public static Result modalPasarAprobado() {
		return ok(modalPasarAprobado.render(form().bindFromRequest()));
	}

	public static Result pasarAprobadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> lSeleccionados = getSeleccionados();

		if(lSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			return ok(modalPasarAprobado.render(d));
		}

		if(!soloBorrador(lSeleccionados) && !soloPreaprobado(lSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en borrador o preaprobado.");
			return ok(modalPasarAprobado.render(d));
		}




		if(d.hasErrors())
			return ok(modalPasarAprobado.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = AgenteAsistenciaLicencia.modificarEstadoMasivo(Estado.AGENTE_LICENCIA_APROBADO, lSeleccionados);

			List<AgenteAsistenciaLicencia> ll = AgenteAsistenciaLicencia.find.where().in("id", lSeleccionados).findList();

			Logger.debug("0000000000  "+ll.size());

			for(AgenteAsistenciaLicencia llx : ll) {

				Logger.debug("aaaaaaaaaaaaaa111111111");

				llx.dias = llx.getDiasEntreFechas();
				llx.save();

				Logger.debug("11111111111111111");

				if(llx.tipo_licencia_id.compareTo(new Long(5)) == 0) {
					Logger.debug("222222222222");
					AgenteAsistenciaLicencia.setDiasPorPeriodos(llx.id.intValue());
				}
			}

			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ lSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarAprobado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarAprobado.render(d));
		}

	}

	public static Boolean soloBorrador(List<Integer> opcSeleccionados) {
		return AgenteAsistenciaLicencia.find.where().ne("estado_id", Estado.AGENTE_LICENCIA_BORRADOR).in("id", opcSeleccionados).findRowCount() == 0;
	}

	public static Boolean soloPreaprobado(List<Integer> opcSeleccionados) {
		return AgenteAsistenciaLicencia.find.where().ne("estado_id", Estado.AGENTE_LICENCIA_PREAPROBADO).in("id", opcSeleccionados).findRowCount() == 0;
	}



	@CheckPermiso(key = "agentesLicenciasPasarCancelado")
	public static Result modalPasarCancelado() {
		return ok(modalPasarCancelado.render(form().bindFromRequest()));
	}

	public static Result pasarCanceladoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> lSeleccionados = getSeleccionados();

		if(lSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			return ok(modalPasarCancelado.render(d));
		}

		if(!soloBorrador(lSeleccionados) && !soloPreaprobado(lSeleccionados) && !Permiso.check("agentesLicenciasPasarCancelado")) {
			flash("error", "Solo se puede modificar registros en estado en borrador o preaprobado.");
			return ok(modalPasarCancelado.render(d));
		}

		List<AgenteAsistenciaLicencia> laal = AgenteAsistenciaLicencia.find.where().in("id", lSeleccionados).findList();
		for(AgenteAsistenciaLicencia laalx : laal) {
			List<LiquidacionNovedadLicencia> lnl = LiquidacionNovedadLicencia.find.where().in("agente_asistencia_licencia_id", laalx.id).findList();
			for(LiquidacionNovedadLicencia lnlx : lnl) {
				lnlx.delete();
			}
			//laalx.delete();
		}

		if(d.hasErrors())
			return ok(modalPasarCancelado.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = AgenteAsistenciaLicencia.modificarEstadoMasivo(Estado.AGENTE_LICENCIA_CANCELADO, lSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron registros seleccionados.");
			result.put("html", modalPasarCancelado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarCancelado.render(d));
		}

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

	public static Result resumen(Long agenteId, Boolean editable) {

		AgenteAsistenciaLicencia aal = new AgenteAsistenciaLicencia();

		return ok(resumenAgenteAsistenciaLicencia.render(aal.getResumenInasistencia(agenteId)));
	}

	public static Result getListaLicenciasPendientes(){
		DynamicForm d = form().bindFromRequest();
		AgenteAsistenciaLicencia aal = new AgenteAsistenciaLicencia();
		String ejercicio = "2017";
		if(!RequestVar.get("ejercicio").isEmpty()){
			ejercicio = Ejercicio.find.byId(new Long(RequestVar.get("ejercicio"))).nombre;
    	}
		return ok(listadoLicenciasPedientes.render(aal.getDiasLicencias(RequestVar.get("ejercicio"),
													RequestVar.get("apellido"),
													RequestVar.get("dni"),
													RequestVar.get("cuit"),
													RequestVar.get("organigrama_id"),
													RequestVar.get("tipo_relacion_laboral"),
													RequestVar.get("completas"),
													RequestVar.get("activo")
													),d,ejercicio));

	}

	public static Result getListaLicenciasEnFecha(){
		DynamicForm d = form().bindFromRequest();
		AgenteAsistenciaLicencia aal = new AgenteAsistenciaLicencia();

		if(RequestVar.get("desde").isEmpty() ||  RequestVar.get("desde").isEmpty()){
			flash("error", "Seleccione un fecha correcta.");
			return ok(listadoLicenciasEnFecha.render(null,d));
    	}

		return ok(listadoLicenciasEnFecha.render(aal.getDiasLicenciasEnFecha(RequestVar.get("desde"),
																			 RequestVar.get("hasta"),
																			 RequestVar.get("organigrama_id"),
																			 RequestVar.get("tipo_relacion_laboral"),
																			 RequestVar.get("tipo_licencia_id"),
																			 RequestVar.get("estado_id"),
																			 RequestVar.get("descripcion"),
																			 RequestVar.get("ejercicio"),
																			 RequestVar.get("nombre"),
																			 RequestVar.get("cuit"),
																			 RequestVar.get("activo")
																			 ),d));
	}

	public static Result getListaLicenciasEnFechaExcel () {

		AgenteAsistenciaLicencia aal = new AgenteAsistenciaLicencia();

		List<SqlRow> ss = aal.getDiasLicenciasEnFecha(RequestVar.get("desde"),
				 RequestVar.get("hasta"),
				 RequestVar.get("organigrama_id"),
				 RequestVar.get("tipo_relacion_laboral"),
				 RequestVar.get("tipo_licencia_id"),
				 RequestVar.get("estado_id"),
				 RequestVar.get("descripcion"),
				 RequestVar.get("ejercicio"),
				 RequestVar.get("nombre"),
				 RequestVar.get("cuit"),
				 RequestVar.get("activo"));

		try {
			String dirTemp = System.getProperty("java.io.tmpdir");

			File archivo = new File(dirTemp+"/listado_agente.xls");

			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();


			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Licencias");
			Cell celda;


			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			if(ss.size() > 0){

				CellStyle comun = libro.createCellStyle();
				comun.setBorderRight(CellStyle.BORDER_THIN);
				comun.setBorderLeft(CellStyle.BORDER_THIN);
				comun.setBorderTop(CellStyle.BORDER_THIN);
				comun.setBorderBottom(CellStyle.BORDER_THIN);

				int x = 0;
				Row fila = hoja.createRow(x);

				fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Apellido y Nombre");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("DNI");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("CUIT");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Organigrama");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Profesion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Categoría");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("Carga horaria");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue("Relación");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(8);
				celda0.setCellValue("Fecha Inicio");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(9);
				celda0.setCellValue("Fecha Fin");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(10);
				celda0.setCellValue("Dias");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(11);
				celda0.setCellValue("Tipo Licencia");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(12);
				celda0.setCellValue("Estado");
				celda0.setCellStyle(comun);

				x++;
				for (SqlRow i : ss) {

					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(i.getString("apellido"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(i.getString("dni"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(2);
					celda0.setCellValue(i.getString("cuit"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(3);
					celda0.setCellValue(i.getString("organigrama"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(4);
					celda0.setCellValue(i.getString("profesion"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(5);
					celda0.setCellValue(i.getString("escala"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(6);
					celda0.setCellValue(i.getString("carga_horaria"));
					celda0.setCellStyle(comun);

					String relacion = "";
					switch ( i.getString("tipo_relacion_laboral") ) {
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

					celda0 = fila.createCell(8);
					celda0.setCellValue(utils.DateUtils.formatDate(i.getDate("finicio")));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(9);
					celda0.setCellValue(utils.DateUtils.formatDate(i.getDate("ffin")));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(10);
					celda0.setCellValue(i.getInteger("dias"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(11);
					celda0.setCellValue(i.getString("tipoLicencia"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(12);
					celda0.setCellValue(i.getString("estado"));
					celda0.setCellStyle(comun);

					x++;
				}
			}


			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();


			return ok(archivo);

		} catch (IOException e) {
		    e.printStackTrace();
		}


		return ok("ddd");
	}

	@CheckPermiso(key = "agentesLicenciasPasarAprobado")
	public static Result modalPasarABorradorNovedadLicencia() {
		return ok(modalPasarABorradorNovedadLicencia.render(form().bindFromRequest()));
	}

	public static Result PasarABorradorNovedadLicencia() {

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		ObjectNode result = Json.newObject();
		List<Integer> nSeleccionados = getSeleccionados();

		if(nSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			result.put("success",false);
			result.put("html", modalPasarABorradorNovedadLicencia.render(d).toString());
			return ok(result);
		}

		List<LiquidacionNovedadLicencia> lnl = LiquidacionNovedadLicencia.find.where().in("id", nSeleccionados).ne("estado_id", Estado.LIQUIDACION_LICENCIAS_NOVEDADES_CONTROLADO).findList();
		if(lnl.size() > 0) {
			flash("error", "Solo puede modificar novedades con licencias en estado Controlado.");
			result.put("success",false);
			result.put("html", modalPasarABorradorNovedadLicencia.render(d).toString());
			return ok(result);
		}


		try {

			lnl = LiquidacionNovedadLicencia.find.where().in("id", nSeleccionados).findList();
			int cargas = 0;

			for(LiquidacionNovedadLicencia lnlx : lnl) {

				LiquidacionNovedadLicencia ll = LiquidacionNovedadLicencia.find.where().eq("id", lnlx.id).findUnique();
				ll.estado_id = (long) Estado.LIQUIDACION_LICENCIAS_NOVEDADES_BORRADOR;
				ll.save();
				cargas ++;
			}


			flash("success", "Se actualizaron <b>("+cargas+")</b> novedades" );
			result.put("success",true);
			result.put("html", modalPasarABorradorNovedadLicencia.render(d).toString());
			return ok(result);

		} catch (Exception e){
			flash("error", "No se han podido cargar las novedades");
			result.put("success",false);
			result.put("html", modalPasarABorradorNovedadLicencia.render(d).toString());
			return ok(result);
		}finally {

		}


	}

	@CheckPermiso(key = "agentesLicenciasPasarAprobado")
	public static Result modalPasarAControladoNovedadLicencia() {
		return ok(modalPasarAControladoNovedadLicencia.render(form().bindFromRequest()));
	}

	public static Result PasarAControladoNovedadLicencia() {

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		ObjectNode result = Json.newObject();

		List<Integer> nSeleccionados = getSeleccionados();

		if(nSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			result.put("success",false);
			result.put("html", modalPasarAControladoNovedadLicencia.render(d).toString());
			return ok(result);
		}

		List<LiquidacionNovedadLicencia> lnl = LiquidacionNovedadLicencia.find.where().in("id", nSeleccionados).ne("estado_id", Estado.LIQUIDACION_LICENCIAS_NOVEDADES_BORRADOR).findList();
		if(lnl.size() > 0) {
			flash("error", "Solo puede cargar novedades con licencias en estado Borrador.");
			result.put("success",false);
			result.put("html", modalPasarAControladoNovedadLicencia.render(d).toString());
			return ok(result);
		}

		try {

			lnl = LiquidacionNovedadLicencia.find.where().in("id", nSeleccionados).findList();
			int cargas = 0;
			for(LiquidacionNovedadLicencia lnlx : lnl) {
				LiquidacionNovedadLicencia ll = LiquidacionNovedadLicencia.find.where().eq("id", lnlx.id).findUnique();
				ll.estado_id = (long) Estado.LIQUIDACION_LICENCIAS_NOVEDADES_CONTROLADO;
				ll.save();
				cargas ++;
			}


			flash("success", "Se actualizaron <b>("+cargas+")</b> novedades" );
			result.put("success",true);
			result.put("html", modalPasarAControladoNovedadLicencia.render(d).toString());
			return ok(result);

		} catch (Exception e){
			flash("error", "No se han podido cargar las novedades");
			result.put("success",false);
			result.put("html", modalPasarAControladoNovedadLicencia.render(d).toString());
			return ok(result);

		}finally {

		}


	}

	@CheckPermiso(key = "liquidacionNovedadesCrear")
	public static Result modalCrearNovedadLicencia() {
		return ok(modalCrearNovedadLicencia.render(form().bindFromRequest()));
	}

	public static Result crearNovedadLicencia() {

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		ObjectNode result = Json.newObject();

		Long periodo_id =null;

		try {
			periodo_id = new Long(request().body().asFormUrlEncoded().get("periodo_id_modal_agui")[0]);
		}catch (Exception e) {
			flash("error", "No se puede determinar el periodo. Seleccione uno. ");
			result.put("success",false);
			result.put("html", modalCrearNovedadLicencia.render(d).toString());
			return ok(result);
		}

		if(periodo_id == null) {
			flash("error", "No se puede determinar el periodo. Seleccione uno. ");
			result.put("success",false);
			result.put("html", modalCrearNovedadLicencia.render(d).toString());
			return ok(result);
		}

		Long tipo_licencia_id =null;

		try {
			tipo_licencia_id = new Long(request().body().asFormUrlEncoded().get("liquidacion_tipo_id")[0]);
		}catch (Exception e) {
			flash("error", "No se puede determinar el tipo de licencia. Seleccione uno. ");
			result.put("success",false);
			result.put("html", modalCrearNovedadLicencia.render(d).toString());
			return ok(result);
		}

		if(tipo_licencia_id == null) {
			flash("error", "No se puede determinar el tipo de licencia. Seleccione uno. ");
			result.put("success",false);
			result.put("html", modalCrearNovedadLicencia.render(d).toString());
			return ok(result);
		}



		List<Integer> nSeleccionados = getSeleccionados();

		if(nSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una licencia.");
			result.put("success",false);
			result.put("html", modalCrearNovedadLicencia.render(d).toString());
			return ok(result);
		}

		List<LiquidacionNovedadLicencia> lnl = LiquidacionNovedadLicencia.find.where().in("id", nSeleccionados)
											   .ne("estado_id", Estado.LIQUIDACION_LICENCIAS_NOVEDADES_CONTROLADO).findList();
		if(lnl.size() > 0) {
			flash("error", "Solo puede cargar novedades con licencias en estado Controlado.");
			result.put("success",false);
			result.put("html", modalCrearNovedadLicencia.render(d).toString());
			return ok(result);
		}


		Ebean.beginTransaction();
		try {

			lnl = LiquidacionNovedadLicencia.find.where().in("id", nSeleccionados).findList();

			LiquidacionConcepto lc10960 = LiquidacionConcepto.find.where().eq("codigo", 10960).findUnique();
			LiquidacionConcepto lc70960 = LiquidacionConcepto.find.where().eq("codigo", 70960).findUnique();

			int cargas = 0;
			for(LiquidacionNovedadLicencia lnlx : lnl) {

				PuestoLaboral pl  = PuestoLaboral.find.where().eq("legajo.agente_id", lnlx.agenteAsistenciaLicencia.agente_id).isNull("fecha_baja").findUnique();

				if(pl == null) {
					Ebean.rollbackTransaction();
					flash("error", "No existe el puesto laboral activo para el agente "+ lnlx.agenteAsistenciaLicencia.agente.apellido);
					result.put("success",false);
					result.put("html", modalCrearNovedadLicencia.render(d).toString());
					return ok(result);
				}

				Long concepto_id = (lnlx.dias > 0)?lc10960.id:lc70960.id;

				Novedad n = new Novedad();
				n.puesto_laboral_id = pl.id;
				n.liquidacion_concepto_id = concepto_id;
				n.periodo_inicio_id = periodo_id;
				n.periodo_hasta_id = periodo_id;
				n.periodo_concepto_id = lnlx.periodo_id;
				n.organigrama_id = lnlx.agenteAsistenciaLicencia.agente.organigrama_id;
				n.fecha_novedad = new Date();
				n.importe = new BigDecimal(0);
				n.cantidad = new BigDecimal(lnlx.dias);
				n.usuario_id = new Long(Usuario.getUsuarioSesion());
				n.liquidacion_tipo_id = tipo_licencia_id;
				n.save();

				LiquidacionNovedadLicencia ll = LiquidacionNovedadLicencia.find.where().eq("id", lnlx.id).findUnique();

				ll.estado_id = (long) Estado.LIQUIDACION_LICENCIAS_NOVEDADES_APROBADO;
				ll.save();

				cargas ++;


			}

			Ebean.commitTransaction();
			result.put("success", true);
			flash("success", "Se han creado <b>("+cargas+")</b> novedades" );
			result.put("html", modalCrearNovedadLicencia.render(d).toString());
			return ok(result);

			//return ok(modalCrearNovedadLicencia.render(d));

		} catch (Exception e){
			Ebean.rollbackTransaction();
			Logger.debug(" xxxxxxxxxxxx "+e);
			flash("error", "No se han podido cargar las novedades. "+e);
			result.put("success",false);
			result.put("html", modalCrearNovedadLicencia.render(d).toString());
			return ok(result);

			//return ok(modalCrearNovedadLicencia.render(d));
		}finally {
			Ebean.endTransaction();
		}


	}

}
