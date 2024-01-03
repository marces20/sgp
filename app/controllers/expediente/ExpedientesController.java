package controllers.expediente;

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
import java.util.Map.Entry;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import models.BalancePresupuestario;
import models.Certificacion;
import models.Ejercicio;
import models.Estado;
import models.Expediente;
import models.ExpedienteMovimiento;
import models.Orden;
import models.OrdenProvision;
import models.Solicitud;
import models.Usuario;
import models.auth.Permiso;
import models.haberes.LiquidacionTipo;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.data.validation.ValidationError;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.contabilidad.facturas.acciones.reporte322;
import views.html.expediente.expediente.*;
import views.html.expediente.expedientesMovimientos.crearExpedienteMovimiento;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

@Security.Authenticated(Secured.class)
public class ExpedientesController extends Controller {

	final static Long ID_EJERCICIO_PREDETERMINADO = (long) 15;
	final static Form<Expediente> expedienteForm = form(Expediente.class);

	public static Result URL_LISTA_IEXPEDIENTE = redirect(
			controllers.expediente.routes.ExpedientesController.indexExpediente()
	);


	@CheckPermiso(key = "expedientesGeneral")
	public static Result indexExpediente() {


		Map<String,String> p = new HashMap<String, String>();
		String organigrama_id = RequestVar.get("organigrama_id");
		DynamicForm d = form().bindFromRequest();

		if(Usuario.getUsurioSesion().id !=132 && Usuario.getUsurioSesion().organigrama != null && RequestVar.getValueOrNull("organigrama_id") == null){

			 p.put("organigrama_id", Usuario.getUsurioSesion().organigrama_id.toString());
			 d = form().bind(p);
			 organigrama_id = Usuario.getUsurioSesion().organigrama_id.toString();
		}

		return ok(indexExpediente.render(Expediente.page(
				RequestVar.get("nombre"),
				RequestVar.get("descripcion"),
				RequestVar.get("ejercicio"),
				RequestVar.get("rp"),
				RequestVar.get("copia"),
				organigrama_id
				), d));
	}

	@CheckPermiso(key = "expedientesCrear")
	public static Result crearExpediente() {

		Ejercicio e = Ejercicio.find.byId(ID_EJERCICIO_PREDETERMINADO);
		Map<String,String> b = new HashMap<String, String>();
		b.put("ejercicio.nombre", e.nombre);
		b.put("ejercicio_id", e.id.toString());
		b.put("fecha", DateUtils.formatDate(new Date()));

		Form<Expediente> expedienteForm = form(Expediente.class).bind(b);
		expedienteForm.discardErrors();
		return ok(crearExpediente.render(expedienteForm));
	}

	@CheckPermiso(key = "expedientesCrear")
	public static Result guardarExpediente() {
		Form<Expediente> expedienteForm = form(Expediente.class).bindFromRequest();

		if(expedienteForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearExpediente.render(expedienteForm));
		}

		if(Usuario.getUsurioSesion().organigrama == null){
			flash("error", "Este usuario no tiene asignado un Servicio/Depto");
			return badRequest(crearExpediente.render(expedienteForm));
		}


		try {
			Expediente e = expedienteForm.get();
			if(e.residuo_pasivo && e.parent_id == null){
				flash("error", "Debe seleccionar un Expediente Padre para un Expediente RP");
				return badRequest(crearExpediente.render(expedienteForm));
			}

			Ejercicio ec = Ejercicio.getEjercicioByFecha(new Date());
			if(e.ejercicio_id.compareTo(ec.id) != 0){
				if(!Permiso.check("crearExpedienteAñoCorriente")) {
					flash("error", "Solo se puede crear ejercicios del año corriente.");
					return badRequest(crearExpediente.render(expedienteForm));
				}
			}

			e.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			e.create_date = new Date();
			e.save();

			ExpedienteMovimiento em = new ExpedienteMovimiento();
			em.usuario_id = Usuario.getUsurioSesion().id.longValue();
			em.organigrama_id = Usuario.getUsurioSesion().organigrama_id;
			em.fecha_llegada = new Date();
			em.expediente_id = e.id;
			em.cancelado = false;
			em.save();

			flash("success", "El expediente se ha actualizado");
			return ok(verExpediente.render(expedienteForm.fill(e),e));
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el expediente");
			return badRequest(crearExpediente.render(expedienteForm));
		}
	}

	@CheckPermiso(key = "expedientesCrear")
	public static Result crearSiguiente() {
		Ejercicio e = Ejercicio.find.byId(ID_EJERCICIO_PREDETERMINADO);
		Map<String,String> b = new HashMap<String, String>();
		b.put("ejercicio.nombre", e.nombre);
		b.put("ejercicio_id", e.id.toString());
		b.put("fecha", DateUtils.formatDate(new Date()));


		String str ="";
        try{
        	List<Expediente> ee = Expediente.find.where()
					  .eq("ejercicio_id", ID_EJERCICIO_PREDETERMINADO)
					  .eq("residuo_pasivo",false)
					  .isNull("padre_copia_id").orderBy("nombre DESC")
					  .findList();


        	str = ee.get(0).nombre;
            int number = Integer.parseInt(str)+1;

            str = NumberUtils.agregarCerosAlaIzquierda(number,4);
        }
        catch (NumberFormatException ex){
        	flash("error", "No se ha podido determinar el numero siguiente de expediente.");
			return badRequest(crearExpediente.render(expedienteForm));
        }




		b.put("nombre",str);


		Form<Expediente> expedienteForm = form(Expediente.class).bind(b);
		expedienteForm.discardErrors();
		return ok(crearExpediente.render(expedienteForm));
	}

	@CheckPermiso(key = "expedientesEditar")
	public static Result editarExpediente(Long id) {
		Expediente expediente = Ebean.find(Expediente.class, id);

		if(expediente.nro_copia != null){
			flash("error", "No se puede editar una copia.");
			return ok(verExpediente.render(expedienteForm.fill(expediente),expediente));
		}

		List<Expediente> le = Expediente.find.where().eq("padre_copia_id", expediente.id).findList();
		if(le.size() > 0){
			flash("error", "No se puede editar este expediente porque ya tiene copias hechas.");
			return ok(verExpediente.render(expedienteForm.fill(expediente),expediente));
		}

		List<Solicitud> sl = Solicitud.find.where().eq("expediente_id", expediente.id).findList();
		List<Orden> ol = Orden.find.where().eq("expediente_id", expediente.id).findList();


		if((sl.size() > 0 || ol.size() > 0) && !Permiso.check("editarExpedienteUsado")) {
			flash("error", "No se puede editar este expediente porque ya esta siendo usado");
			return ok(verExpediente.render(expedienteForm.fill(expediente),expediente));
		}

		if(expediente.cerrar) {
			flash("error", "No se puede editar expedientes que esten cerrados");
			return ok(verExpediente.render(expedienteForm.fill(expediente),expediente));
		}

		return ok(editarExpediente.render(expedienteForm.fill(expediente)));
	}

	@CheckPermiso(key = "expedientesEditar")
	public static Result actualizarExpediente(){

		Form<Expediente> expedienteForm = form(Expediente.class).bindFromRequest();

		if(expedienteForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarExpediente.render(expedienteForm));
		}

		try {


			Expediente e = expedienteForm.get();

			//if(e.ejercicio_id.compareTo(new Long(9)) != 0 && (!Usuario.getUsurioSesion().id.equals(1) && !Usuario.getUsurioSesion().id.equals(149) && !Usuario.getUsurioSesion().id.equals(401))){

			Ejercicio ec = Ejercicio.getEjercicioByFecha(new Date());
			if(e.ejercicio_id.compareTo(ec.id) != 0){
				if(!Permiso.check("crearExpedienteAñoCorriente")) {

					flash("error", "Solo se puede editar ejercicios del año corriente..");
					return badRequest(editarExpediente.render(expedienteForm));
				}
			}

			if(e.residuo_pasivo && e.parent_id == null){
				flash("error", "Debe seleccionar un Expediente Padre para un Expediente RP");
				return badRequest(editarExpediente.render(expedienteForm));
			}

			e.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			e.write_date = new Date();
			e.update();

			flash("success", "El expediente se ha actualizado");
			return ok(verExpediente.render(expedienteForm.fill(e),e));
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el expediente");
			return badRequest(editarExpediente.render(expedienteForm));
		}
	}

	@CheckPermiso(key = "expedientesEliminar")
	public static Result eliminarExpediente(Long id) {
		try {
			Expediente.find.byId(id).delete();
			flash("success", "Se ha eliminado el Expediente");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el Expediente");
		}

		return URL_LISTA_IEXPEDIENTE;
	}

	@CheckPermiso(key = "expedientesEliminarCopias")
	public static Result eliminarExpedienteCopia(Long id) {

		Expediente lc = Ebean.find(Expediente.class, id);
		List<ExpedienteMovimiento> em = ExpedienteMovimiento.find.where().eq("expediente_id",id).findList();

		if(lc.nro_copia == null) {
			flash("error", "El expediente no es una copia.");
			return ok(verExpediente.render(expedienteForm.fill(lc),lc));
		}else if(em.size() > 1) {
			flash("error", "No se puede eliminar las copias que tiene mas de un movimiento.");
			return ok(verExpediente.render(expedienteForm.fill(lc),lc));
		}else if(em.size() == 1){
			if(em.get(0).usuario_id.compareTo(new Long(Usuario.getUsuarioSesion())) != 0) {
				flash("error", "No se puede eliminar las copias que tienen movimientos de otro usuario.");
				return ok(verExpediente.render(expedienteForm.fill(lc),lc));
			}
		}

		try {
			Expediente lcx = Ebean.find(Expediente.class).select("id").setId(id).findUnique();
			lcx.delete();
			flash("success", "Se ha eliminado el Expediente");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el Expediente");
		}

		return URL_LISTA_IEXPEDIENTE;
	}

	public static Result suggestExpediente(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode expediente = rpta.arrayNode();

	    Expediente ad = new Expediente();

		for(Expediente a : ad.getDataSuggest(input, 25,false)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.getExpedienteEjercicio());
	        restJs.put("info", "");
	        expediente.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", expediente);

		return ok(response);
	}

	public static Result suggestExpedienteCopia(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode expediente = rpta.arrayNode();

	    Expediente ad = new Expediente();

		for(Expediente a : ad.getDataSuggest(input, 25,true)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.getExpedienteEjercicio());
	        restJs.put("info", "");
	        expediente.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", expediente);

		return ok(response);
	}

	public static Result get(int id){
		Expediente expediente = Expediente.find.select("id, nombre, descripcion").where().eq("activo", true).eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(expediente == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el expediente");
		} else {
			restJs.put("success", true);
			restJs.put("id", expediente.id);
			restJs.put("nombre", expediente.getExpedienteEjercicio());
			restJs.put("descripcion", expediente.descripcion);
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result modalBuscar() {
    	Pagination<Expediente> p = new Pagination<Expediente>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Expediente> e = Expediente.find.where().eq("activo", true);

    	e.isNull("nro_copia");

    	if(!RequestVar.get("ejercicio").isEmpty()){
    		e.eq("ejercicio.id", Integer.parseInt( RequestVar.get("ejercicio")) );
    	}
    	if(!RequestVar.get("nombre").isEmpty()){
    		e.like("nombre", "%"+RequestVar.get("nombre")+"%" );
    	}

    	e = e.disjunction();

    	e = e.ilike("descripcion", "%" + RequestVar.get("descripcion") + "%");


    	p.setExpressionList(e);
		return ok( modalBusquedaExpediente.render(p, form().bindFromRequest()) );
	}

	public static Result modalBuscarCopia() {
    	Pagination<Expediente> p = new Pagination<Expediente>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Expediente> e = Expediente.find.where().eq("activo", true);

    	e.isNotNull("nro_copia");

    	if(!RequestVar.get("ejercicio").isEmpty()){
    		e.eq("ejercicio.id", Integer.parseInt( RequestVar.get("ejercicio")) );
    	}
    	if(!RequestVar.get("nombre").isEmpty()){
    		e.like("nombre", "%"+RequestVar.get("nombre")+"%" );
    	}

    	e = e.disjunction();
    	e = e.ilike("descripcion", "%" + RequestVar.get("descripcion") + "%");

    	p.setExpressionList(e);
		return ok( modalBusquedaExpedienteCopia.render(p, form().bindFromRequest()) );
	}

	@CheckPermiso(key = "expedientesVer")
	public static Result ver(Long id) throws IOException {
		//Expediente lc = Expediente.find.byId(id);
		Expediente lc = Ebean.find(Expediente.class, id);

		if(lc == null){
			flash("error", "No se encuentra el expediente");
			return URL_LISTA_IEXPEDIENTE;
		}

		return ok(verExpediente.render(expedienteForm.fill(lc),lc));
	}

	public static Result reporteTapaExpedienteMasivo() throws IOException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/tapa_expediente.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/expedientes/tapa_expediente_old.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();


		      List<Integer> ls = getSeleccionados();
		      List<Expediente> e = Expediente.find.where().in("id",ls).findList();
		      Expediente ex = new Expediente();

		      context.put("date", new DateUtils());
		      context.put("expedientes", e);

		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }

	    	return ok(modalReporteListadoExpedientes.render(archivo.getPath()));
	}

	public static Result reporteTapaExpediente(Long id) throws IOException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/tapa_expediente.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/expedientes/tapa_expediente_old.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();


		      List<Integer> ls = new ArrayList<Integer>();
		      ls.add(id.intValue());
		      List<Expediente> e = Expediente.find.where().in("id",ls).findList();
		      Expediente ex = new Expediente();

		      context.put("date", new DateUtils());
		      context.put("expedientes", e);

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

	public static Result listadoExpedientes() {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_expedientes.xls");

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


			List<Integer> expedientesSeleccionados = getSeleccionados();
			if(expedientesSeleccionados.isEmpty()) {
				flash("error", "Debe seleccionar expedientes para generar el reporte.");
				return ok(modalReporteListadoExpedientes.render(null));
			}

			Sheet hoja = libro.createSheet("Expedientes");

			List<Expediente> el = Expediente.find.where().in("id", expedientesSeleccionados).orderBy("nombre").findList();

			if(el.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Expediente");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("Descripcion");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellValue("Fecha");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(3);
				celda0.setCellValue("RP");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(4);
				celda0.setCellValue("Institucion");
				celda0.setCellStyle(comun);

				x++;

				for(Expediente e : el){

					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(e.getExpedienteEjercicio());
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(e.descripcion);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(utils.DateUtils.formatDate(e.fecha));
					celda0.setCellStyle(comun);

					String rp = (e.residuo_pasivo == true)?"SI":"NO";
					celda0 = fila.createCell(3);
					celda0.setCellValue(rp);
					celda0.setCellStyle(comun);

					List<Orden> lo = Orden.find.where().eq("expediente_id",e.id).eq("state_id", Estado.ORDEN_ESTADO_APROBADO).findList();
					if(lo.size() >0) {
						celda0 = fila.createCell(4);
						celda0.setCellValue(lo.get(0).deposito.nombre);
						celda0.setCellStyle(comun);
					}




					x++;
				}
			}


			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return ok(archivo);
		return ok(modalReporteListadoExpedientes.render(archivo.getPath()));

	}

	@CheckPermiso(key = "expedientesCrearCopia")
	public static Result crearCopia(Long id) throws IOException{

		try {

			if(Usuario.getUsurioSesion().organigrama == null){
				flash("error", "Este usuario no tiene asignado un Servicio/Depto no puede crear copias.");
				return redirect(controllers.expediente.routes.ExpedientesController.ver(id) + UriTrack.get("&"));
			}


			Expediente eTmp = Expediente.find.byId(id);
			if(eTmp.residuo_pasivo){
				flash("error", "No se pueden crear copias del expedientes RP");
				return redirect(controllers.expediente.routes.ExpedientesController.ver(id) + UriTrack.get("&"));
			}

			Expediente e = new Expediente();
			Long usuario_id = Usuario.getUsurioSesion().id.longValue();
			Long organigrama_id = Usuario.getUsurioSesion().organigrama_id;
			Long idNew = e.crearCopia(id,usuario_id,organigrama_id);
			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha creado la copia del expediente.");
				return redirect(controllers.expediente.routes.ExpedientesController.ver(idNew) + UriTrack.get("&"));
			}else{
				flash("error", "No se ha podido crear la copia.");
				String refererUrl = request().getHeader("referer");
				return URL_LISTA_IEXPEDIENTE;
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido crear la copia.");
		}

		String refererUrl = request().getHeader("referer");
		return URL_LISTA_IEXPEDIENTE;
	}

	@CheckPermiso(key = "expedientesCrearRP")
	public static Result crearRP(Long id) throws IOException{

		try {



			List<Expediente> l =Expediente.find.where().eq("parent_id", id).eq("residuo_pasivo",true).eq("ejercicio_id",Ejercicio.getEjercicioByFecha(new Date()).id).findList();
			if(l.size() > 0) {
				flash("error", "Este expediente ya tiene creado un RP para este ejercicio.");
				return redirect(controllers.expediente.routes.ExpedientesController.ver(id) + UriTrack.get("&"));
			}

			Expediente e = new Expediente();

			Long idNew = e.crearRP(id);
			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha creado el RP del expediente.");
				return redirect(controllers.expediente.routes.ExpedientesController.ver(idNew) + UriTrack.get("&"));
			}else{
				flash("error", "No se ha podido crear el RP.");
				String refererUrl = request().getHeader("referer");
				return URL_LISTA_IEXPEDIENTE;
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido crear la copia.");
		}

		String refererUrl = request().getHeader("referer");
		return URL_LISTA_IEXPEDIENTE;
	}

	public static Result getExpedientesRecepcionSinFirma()  {
    	List<OrdenProvision> op = OrdenProvision.find
    							  .fetch("ordenCompra", "total, totalAjuste, tipo_moneda")
    							 .fetch("ordenCompra.proveedor", "nombre")
    							 .fetch("ordenCompra.expediente", "nombre")
    							 .fetch("ordenCompra.expediente.ejercicio", "nombre")
    							 .fetch("totales")
    							 .where()
    							 .not(Expr.in("ordenCompra.expediente.ejercicio.id", new Long[]{1L,2L,3L,4L,5L}))
    							 .isNull("ordenCompra.fecha_provision")
    							 .gt("totales.totalRecepcionado",BigDecimal.ZERO)
    							 .orderBy("id asc")
    							 .findList();




    	return ok(listaExpedientesRecepcionSinFirma.render(op));
	}

	public static Result getExpedientesSinFirma()  {
    	List<OrdenProvision> op = OrdenProvision.find
    							 .fetch("ordenCompra", "total, totalAjuste, tipo_moneda")
    							 .fetch("ordenCompra.proveedor", "nombre")
    							 .fetch("ordenCompra.expediente", "nombre")
    							 .fetch("ordenCompra.expediente.ejercicio", "nombre")
    							 .where()
    							 .not(Expr.in("ordenCompra.expediente.ejercicio.id", new Long[]{1L,2L,3L,4L,5L}))
    							 .isNull("ordenCompra.fecha_provision")

    							 .orderBy("id asc")
    							 .findList();




    	return ok(listaExpedientesSinFirma.render(op));
	}

	public static Result getExpedientesSinFirmaReporte()  {

    	String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/expedientes_recepcionados_sinfirma.xls");

		try {
			if(archivo.exists()) archivo.delete();

			archivo.createNewFile();

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);

			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);

			CellStyle style = libro.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			HSSFFont font = (HSSFFont) libro.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);

			CellStyle estiloMonedaConFondo = libro.createCellStyle();
			estiloMonedaConFondo.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			estiloMonedaConFondo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			estiloMonedaConFondo.setDataFormat((short) 7);
			estiloMonedaConFondo.setBorderRight(CellStyle.BORDER_THIN);
			estiloMonedaConFondo.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMonedaConFondo.setBorderTop(CellStyle.BORDER_THIN);
			estiloMonedaConFondo.setBorderBottom(CellStyle.BORDER_THIN);
			HSSFFont font2 = (HSSFFont) libro.createFont();
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			estiloMonedaConFondo.setFont(font);

			Sheet hoja = libro.createSheet("Expedientes");


			int x = 0;

			Row fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Expediente");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(1);
			celda0.setCellValue("Proveedor");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(2);
			celda0.setCellValue("Total Orden");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(3);
			celda0.setCellValue("Recepcionado");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(4);
			celda0.setCellValue("Diferencia");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(5);
			celda0.setCellValue("Servicio");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(6);
			celda0.setCellValue("Tiempo");
			celda0.setCellStyle(style);
			x++;

			BigDecimal totalOrden = new BigDecimal(0);
			BigDecimal totalRecepcion = new BigDecimal(0);
			BigDecimal totalDeuda = new BigDecimal(0);

			List<OrdenProvision> opx = OrdenProvision.find
					 .fetch("ordenCompra", "total, totalAjuste, tipo_moneda")
					 .fetch("ordenCompra.proveedor", "nombre")
					 .fetch("ordenCompra.expediente", "nombre")
					 .fetch("ordenCompra.expediente.ejercicio", "nombre")
					 .where()
					 .not(Expr.in("ordenCompra.expediente.ejercicio.id", new Long[]{1L,2L,3L,4L,5L}))
					 .isNull("ordenCompra.fecha_provision")

					 .orderBy("id asc")
					 .findList();


			for (OrdenProvision op :opx){

				fila = hoja.createRow(x);
				Cell celda = fila.createCell(0);
				celda.setCellValue(op.ordenCompra.expediente.getExpedienteEjercicio());
				celda.setCellStyle(comun);

				celda = fila.createCell(1);
				celda.setCellValue(op.ordenCompra.proveedor.nombre);
				celda.setCellStyle(comun);

				celda = fila.createCell(2);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(op.ordenCompra.getTotalTotal().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				celda = fila.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(op.getTotalRecepcionado().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				BigDecimal diferencia = new BigDecimal(0);
				diferencia = op.ordenCompra.getTotalTotal().subtract(op.getTotalRecepcionado());

				celda = fila.createCell(4);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(diferencia.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				celda = fila.createCell(5);
				celda.setCellValue(op.ordenCompra.expediente.getServicio());
				celda.setCellStyle(comun);

				celda = fila.createCell(6);
				celda.setCellValue(ExpedienteMovimiento.tiempoEnMovimiento(ExpedienteMovimiento.getLastMovimiento(op.ordenCompra.expediente.id)));
				celda.setCellStyle(comun);

				totalOrden = totalOrden.add(op.ordenCompra.getTotalTotal());
				totalRecepcion = totalRecepcion.add(op.getTotalRecepcionado());
				totalDeuda = totalDeuda.add(diferencia);

				x++;
			}

				fila = hoja.createRow(x);
				Cell celda = fila.createCell(1);
				celda.setCellValue("TOTALES");
				celda.setCellStyle(comun);

				celda = fila.createCell(2);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalOrden.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				celda = fila.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalRecepcion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				celda = fila.createCell(4);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalDeuda.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);


			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(archivo);
    }

	public static Result getExpedientesRecepcionSinFirmaReporte()  {

    	String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/expedientes_recepcionados_sinfirma.xls");

		try {
			if(archivo.exists()) archivo.delete();

			archivo.createNewFile();

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);

			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);

			CellStyle style = libro.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			HSSFFont font = (HSSFFont) libro.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);

			CellStyle estiloMonedaConFondo = libro.createCellStyle();
			estiloMonedaConFondo.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			estiloMonedaConFondo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			estiloMonedaConFondo.setDataFormat((short) 7);
			estiloMonedaConFondo.setBorderRight(CellStyle.BORDER_THIN);
			estiloMonedaConFondo.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMonedaConFondo.setBorderTop(CellStyle.BORDER_THIN);
			estiloMonedaConFondo.setBorderBottom(CellStyle.BORDER_THIN);
			HSSFFont font2 = (HSSFFont) libro.createFont();
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			estiloMonedaConFondo.setFont(font);

			Sheet hoja = libro.createSheet("Expedientes");


			int x = 0;

			Row fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Expediente");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(1);
			celda0.setCellValue("Proveedor");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(2);
			celda0.setCellValue("Total Orden");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(3);
			celda0.setCellValue("Recepcionado");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(4);
			celda0.setCellValue("Diferencia");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(5);
			celda0.setCellValue("Servicio");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(6);
			celda0.setCellValue("Tiempo");
			celda0.setCellStyle(style);
			x++;

			BigDecimal totalOrden = new BigDecimal(0);
			BigDecimal totalRecepcion = new BigDecimal(0);
			BigDecimal totalDeuda = new BigDecimal(0);

			List<OrdenProvision> opx = OrdenProvision.find
					 .fetch("ordenCompra", "total, totalAjuste, tipo_moneda")
					 .fetch("ordenCompra.proveedor", "nombre")
					 .fetch("ordenCompra.expediente", "nombre")
					 .fetch("ordenCompra.expediente.ejercicio", "nombre")
					 .fetch("totales")
					 .where()
					 .not(Expr.in("ordenCompra.expediente.ejercicio.id", new Long[]{1L,2L,3L,4L,5L}))
					 .isNull("ordenCompra.fecha_provision")
					 .gt("totales.totalRecepcionado",BigDecimal.ZERO)
					 .orderBy("id asc")
					 .findList();


			for (OrdenProvision op :opx){

				fila = hoja.createRow(x);
				Cell celda = fila.createCell(0);
				celda.setCellValue(op.ordenCompra.expediente.getExpedienteEjercicio());
				celda.setCellStyle(comun);

				celda = fila.createCell(1);
				celda.setCellValue(op.ordenCompra.proveedor.nombre);
				celda.setCellStyle(comun);

				celda = fila.createCell(2);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(op.ordenCompra.getTotalTotal().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				celda = fila.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(op.getTotalRecepcionado().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				BigDecimal diferencia = new BigDecimal(0);
				diferencia = op.ordenCompra.getTotalTotal().subtract(op.getTotalRecepcionado());

				celda = fila.createCell(4);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(diferencia.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				celda = fila.createCell(5);
				celda.setCellValue(op.ordenCompra.expediente.getServicio());
				celda.setCellStyle(comun);

				celda = fila.createCell(6);
				celda.setCellValue(ExpedienteMovimiento.tiempoEnMovimiento(ExpedienteMovimiento.getLastMovimiento(op.ordenCompra.expediente.id)));
				celda.setCellStyle(comun);

				totalOrden = totalOrden.add(op.ordenCompra.getTotalTotal());
				totalRecepcion = totalRecepcion.add(op.getTotalRecepcionado());
				totalDeuda = totalDeuda.add(diferencia);

				x++;
			}

				fila = hoja.createRow(x);
				Cell celda = fila.createCell(1);
				celda.setCellValue("TOTALES");
				celda.setCellStyle(comun);

				celda = fila.createCell(2);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalOrden.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				celda = fila.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalRecepcion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);

				celda = fila.createCell(4);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalDeuda.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);


			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(archivo);
    }
}
