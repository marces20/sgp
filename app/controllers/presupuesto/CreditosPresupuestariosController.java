package controllers.presupuesto;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.CreditoPresupuestario;
import models.Ejercicio;
import models.Expediente;
import models.LineaCreditoPresupuestario;
import models.Solicitud;
import models.Usuario;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.presupuesto.creditoPresupuestario.*;

@Security.Authenticated(Secured.class)
public class CreditosPresupuestariosController extends Controller {
	final static Form<CreditoPresupuestario> creditoPresupuestarioForm = form(CreditoPresupuestario.class);

	public static Result URL_LISTA_CREDITO = redirect(
			controllers.presupuesto.routes.CreditosPresupuestariosController.index()
	);

	@CheckPermiso(key = "creditosPresupuestarioGeneral")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexCreditoPresupuestario.render(CreditoPresupuestario.page(RequestVar.get("nombre"),RequestVar.get("ejercicio")),d));

	}

	@CheckPermiso(key = "creditosPresupuestarioGeneral")
	public static Result listaCargas() {
		DynamicForm d = form().bindFromRequest();

		Ejercicio e = Ejercicio.getEjercicioByFecha(new Date());
		if(!RequestVar.get("ejercicio").isEmpty()) {
			e = Ejercicio.find.byId(new Long(RequestVar.get("ejercicio")));
		}else {

		}



		ExpressionList<LineaCreditoPresupuestario> elc = LineaCreditoPresupuestario
											 .find
											 .fetch("creditoPresupuestario")
											 .fetch("creditoPresupuestario.ejercicio")
											 .where();

		if(!RequestVar.get("cuenta_analitica_padre_id").isEmpty()) {
			elc = elc.eq("cuenta_analitica_id", new Long(RequestVar.get("cuenta_analitica_padre_id")));
		}

		List<LineaCreditoPresupuestario> lc = elc.eq("creditoPresupuestario.ejercicio.id", e.id)
											 .orderBy("creditoPresupuestario.fecha")
											 .findList();


		return ok(listaCargas.render(lc,d));

	}

	@CheckPermiso(key = "crearCredito")
	public static Result crear() {

		Form<CreditoPresupuestario> creditoPresupuestarioForm = form(CreditoPresupuestario.class);
		return ok(crearCreditoPresupuestario.render(creditoPresupuestarioForm));
	}

	@CheckPermiso(key = "crearCredito")
	public static Result guardar() {

		Form<CreditoPresupuestario> creditoPresupuestarioForm = form(CreditoPresupuestario.class).bindFromRequest();

		try {
			if(creditoPresupuestarioForm.field("ejercicio.id").value().isEmpty()){
				creditoPresupuestarioForm.reject("ejercicio.id","El Ejercicio es obligatorio.");
			}


			if(creditoPresupuestarioForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(crearCreditoPresupuestario.render(creditoPresupuestarioForm));
			} else {
				CreditoPresupuestario c = creditoPresupuestarioForm.get();
				c.estado = "Borrador";
				c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				c.create_date = new Date();
				c.save();
				flash("success", "El credito se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el credito");
			return badRequest(crearCreditoPresupuestario.render(creditoPresupuestarioForm));
		}

		return URL_LISTA_CREDITO;
	}

	@CheckPermiso(key = "crearCredito")
	public static Result editar(Long id) {
		CreditoPresupuestario creditoPresupuestario = Ebean.find(CreditoPresupuestario.class, id);

		if(creditoPresupuestario.estado.compareTo("Completado")  == 0) {
			flash("error", "No se pueden aprobar Creditos aprobados");
			return redirect(request().getHeader("referer"));
		}

		return ok(editarCreditoPresupuestario.render(creditoPresupuestarioForm.fill(creditoPresupuestario),id));
	}

	@CheckPermiso(key = "crearCredito")
	public static Result actualizar(){

		Form<CreditoPresupuestario> creditoPresupuestarioForm = form(CreditoPresupuestario.class).bindFromRequest();

		try {
			if(creditoPresupuestarioForm.field("ejercicio.id").value().isEmpty()){
				creditoPresupuestarioForm.reject("ejercicio.id","El Ejercicio es obligatorio.");
			}

			if(creditoPresupuestarioForm.field("plan_sumar").value().isEmpty()){
				creditoPresupuestarioForm.reject("plan_sumar","El Ejercicio es obligatorio.");
			}

			if(creditoPresupuestarioForm.field("afecta").value().isEmpty()){
				creditoPresupuestarioForm.reject("afecta","El Ejercicio es obligatorio.");
			}

			if(creditoPresupuestarioForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarCreditoPresupuestario.render(creditoPresupuestarioForm,new Long(creditoPresupuestarioForm.field("id").value())));
			} else {
				CreditoPresupuestario c = creditoPresupuestarioForm.get();
				c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				c.write_date = new Date();
				c.update();
				flash("success", "El credito se ha actualizado");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el credito");
			return badRequest(editarCreditoPresupuestario.render(creditoPresupuestarioForm,new Long(creditoPresupuestarioForm.field("id").value())));
		}
		return URL_LISTA_CREDITO;
	}

	@CheckPermiso(key = "eliminarCredito")
	public static Result eliminar(Long id) {
		try {
			CreditoPresupuestario.find.byId(id).delete();
			flash("success", "Se ha eliminado el credito");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el credito");
		}

		return URL_LISTA_CREDITO;
	}

	@CheckPermiso(key = "creditosPresupuestarioGeneral")
	public static Result ver(Long id) {
		CreditoPresupuestario creditoPresupuestario = CreditoPresupuestario.find.byId(id);
		return ok(verCreditoPresupuestario.render(creditoPresupuestario));
	}

	public static Result get(int id){
		CreditoPresupuestario creditoPresupuestario = CreditoPresupuestario.find.select("id, nombre").where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(creditoPresupuestario == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el credito");
		} else {
			restJs.put("success", true);
			restJs.put("id", creditoPresupuestario.id);
			restJs.put("nombre", creditoPresupuestario.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result reporteListadoCreditos() {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_creditos.xls");
		Logger.debug("343333333 "+request());
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


			List<Integer> creditosSeleccionados = getSeleccionados();

			if(creditosSeleccionados.isEmpty()) {
				flash("error", "Debe seleccionar lineas para generar el reporte.");
				return ok(modalReporteListadoCreditos.render(null));
			}

			Sheet hoja = libro.createSheet("Creditos");

			List<CreditoPresupuestario> el = CreditoPresupuestario.find.where().in("id", creditosSeleccionados).orderBy("fecha").findList();

			if(el.size() > 0){

				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("Fecha");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellValue("Ejercicio");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(3);
				celda0.setCellValue("Cuenta");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(4);
				celda0.setCellValue("Monto");
				celda0.setCellStyle(comun);

				x++;

				for(CreditoPresupuestario e : el){

					List<LineaCreditoPresupuestario> lc = LineaCreditoPresupuestario.find.where().eq("credito_presupuestario_id", e.id).findList();


					for(LineaCreditoPresupuestario lcx : lc){
						fila = hoja.createRow(x);
						celda0 = fila.createCell(0);
						celda0.setCellValue(e.nombre);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(1);
						celda0.setCellValue(utils.DateUtils.formatDate(e.fecha));
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(2);
						celda0.setCellValue(e.ejercicio.nombre);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(3);
						celda0.setCellValue(lcx.cuentaAnalitica.codigo+" "+lcx.cuentaAnalitica.nombre);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(4);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(lcx.monto.doubleValue());
						celda0.setCellStyle(estiloMoneda);

						x++;
					}
				}
			}


			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se puede generar el reporte.");
			return ok(modalReporteListadoCreditos.render(null));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se puede generar el reporte.");
			return ok(modalReporteListadoCreditos.render(null));
		}

		return ok(modalReporteListadoCreditos.render(archivo.getPath()));

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

	@CheckPermiso(key = "aprobarCredito")
	public static Result aprobar(Long id) {
		CreditoPresupuestario creditoPresupuestario = CreditoPresupuestario.find.where().eq("id", id).findUnique();

		if(creditoPresupuestario == null) {
			flash("error", "No se encuentra el credito.");
			return redirect(controllers.presupuesto.routes.CreditosPresupuestariosController.ver(id));
		}

		if(creditoPresupuestario.getTotal().compareTo(creditoPresupuestario.getTotalRecursos()) != 0) {
			flash("error", "El total cargado debe ser igual al total de Recursos");
			return redirect(controllers.presupuesto.routes.CreditosPresupuestariosController.ver(id));
		}
		try {
			creditoPresupuestario.estado = "Completado";
			creditoPresupuestario.save();

		}catch (Exception e) {
			flash("error", "Error no se puede aprobar el credito el credito."+e);
		}


		return redirect(controllers.presupuesto.routes.CreditosPresupuestariosController.ver(id));
	}
	/*public static Result modalBuscar() {
    	Pagination<CreditoPresupuestario> p = new Pagination<CreditoPresupuestario>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(CreditoPresupuestario.find.where().ilike("nombre", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaCreditoPresupuestario.render(p, form().bindFromRequest()) );
	}*/
}
