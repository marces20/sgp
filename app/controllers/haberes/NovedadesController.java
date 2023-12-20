package controllers.haberes;

import static play.data.Form.form;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lowagie.text.List;

import controllers.auth.CheckPermiso;

import models.RemitoBaul;
import models.Usuario;
import models.haberes.LiquidacionTipo;
import models.haberes.Novedad;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.dashboard.informeEstadisticoDeudaProveedores.diferencias;
import views.html.haberes.liquidacionTipos.crearLiquidacionTipo;
import views.html.haberes.novedades.*;

public class NovedadesController extends Controller {

	@CheckPermiso(key = "liquidacionNovedadesIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		Pagination<Novedad> lista = Novedad.page(RequestVar.get("puesto_laboral_id"),
												 RequestVar.get("liquidacion_concepto_id"),
												 RequestVar.get("periodo_inicio_id"),
												 RequestVar.get("fecha_desde"),
												 RequestVar.get("fecha_hasta"),
												 RequestVar.get("liquidacion_tipo_id"),
												 RequestVar.get("carga"),
												 RequestVar.get("periodo_inicio_id"),
												 RequestVar.get("periodo_fin_id"),
												 RequestVar.get("activo"),
												 RequestVar.get("cm"),
												 RequestVar.get("periodo_concepto_id"),
												 RequestVar.get("organigrama_id")
												 );
		return ok(indexNovedades.render(lista, d));
	}

	@CheckPermiso(key = "liquidacionNovedadesIndex")
	public static Result lista() {
		Pagination<Novedad> lista = Novedad.page(RequestVar.get("puesto_laboral_id"),
												 RequestVar.get("liquidacion_concepto_id"),
												 RequestVar.get("periodo_inicio_id"),
												 RequestVar.get("fecha_desde"),
												 RequestVar.get("fecha_hasta"),
												 RequestVar.get("liquidacion_tipo_id"),
												 RequestVar.get("carga"),
												 RequestVar.get("periodo_inicio_id"),
												 RequestVar.get("periodo_fin_id"),
												 "activo",
												 RequestVar.get("cm"),
												 RequestVar.get("periodo_concepto_id"),
												 RequestVar.get("organigrama_id")
												 );
		return ok(listaNovedades.render(lista));
	}


	@CheckPermiso(key = "liquidacionNovedadesCrear")
	public static Result crear() {

		Form<Novedad> nForm = form(Novedad.class);

		return ok(crearNovedades.render(nForm));
	}

	@CheckPermiso(key = "liquidacionNovedadesVer")
	public static Result ver(Long id) {


		return ok();
	}

	@CheckPermiso(key = "liquidacionNovedadesCrear")
	public static Result guardar() {
		Form<Novedad> nForm = form(Novedad.class).bindFromRequest();

		if(nForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(crearNovedades.render(nForm));
		}

		Novedad n = nForm.get();

		if(!n.comprobarPeriodoInicioConPeriodoFin()) {
			flash("error", "El periodo de fin debe ser mayor o igual al periodo de inicio.");
			return ok(crearNovedades.render(nForm));
		}

		try {


			n.fecha_novedad = new Date();
			n.usuario_id = (long) Usuario.getUsuarioSesion();
			n.cargaMasiva = false;
			n.activo = true;
			flash("success", "Se ha creado la novedad.");
			n.save();


		} catch (Exception e) {
			flash("error", "No se pudo crear la novedad"+e);
		}


		return ok(crearNovedades.render(nForm));

	}

	@CheckPermiso(key = "liquidacionNovedadesEditar")
	public static Result editar(Long id) {
		Novedad novedad = Novedad.find.byId(id);

		Form<Novedad> nForm = form(Novedad.class).fill(novedad);

		return ok(editarNovedades.render(nForm));
	}

	@CheckPermiso(key = "liquidacionNovedadesEditar")
	public static Result actualizar() {
		Form<Novedad> nForm = form(Novedad.class).bindFromRequest();

		if(nForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(editarNovedades.render(nForm));
		}

		Novedad n = nForm.get();

		if(!n.comprobarPeriodoInicioConPeriodoFin()) {
			flash("error", "El periodo de fin debe ser mayor o igual al periodo de inicio.");
			return ok(editarNovedades.render(nForm));
		}

		try {
			n.usuario_id = (long) Usuario.getUsuarioSesion();
			flash("success", "La novedad se ha modificado correctamente.");
			n.update();


		} catch (Exception e) {
			flash("error", "No se pudo modificar la novedad" + e);
		}


		return ok(editarNovedades.render(nForm));
	}

	@CheckPermiso(key = "liquidacionNovedadesEliminar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();
		try {
			Novedad.find.byId(id).delete();
			restJs.put("success", true);
			restJs.put("messagge", "Se ha eliminado la novedad");
		} catch (Exception e) {
			restJs.put("success", false);
			restJs.put("message", "Error al eliminar la novedad");
			play.Logger.error("excepcion", e);
		}

		return ok(restJs);
	}

}
