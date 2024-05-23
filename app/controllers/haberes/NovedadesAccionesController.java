package controllers.haberes;

import static play.data.Form.form;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Organigrama;
import models.Periodo;
import models.Puesto;
import models.Usuario;
import models.haberes.LiquidacionConcepto;
import models.haberes.LiquidacionPuesto;
import models.haberes.Novedad;
import models.haberes.PuestoLaboral;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.avaje.ebean.Ebean;

import controllers.auth.CheckPermiso;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import utils.NumberUtils;
import views.html.haberes.novedades.*;

public class NovedadesAccionesController extends Controller {

	@CheckPermiso(key = "liquidacionNovedadesCrearMasivo")
	public static Result crearMasivo() {
		Form<Novedad> nForm = form(Novedad.class);
		return ok(crearMasivo.render(nForm, null));
	}

	public static Result procesarMasivo() {
		Form<Novedad> nForm = form(Novedad.class).bindFromRequest();
		MultipartFormData body = request().body().asMultipartFormData();
		Map<String, String[]> formData = request().body().asFormUrlEncoded();
		List<String> msgArchivo = new ArrayList<String>();
		List<String> msgCuit = new ArrayList<String>();
		List<String> msgConcepto = new ArrayList<String>();
		HashMap<String, List<String>> errores = new HashMap<String, List<String>>();

		String algo = "";

		File file;

		Long periodoId = null;
		Long tipoId = null;

		System.out.println(nForm.data());

		if (nForm.data().get("periodo_id").isEmpty()) {
			nForm.reject("periodo_id", "Debe seleccionar periodo.");
			return ok(crearMasivo.render(nForm, null));
		}

		if (nForm.data().get("liquidacion_tipo_id").isEmpty()) {
			nForm.reject("liquidacion_tipo_id", "Debe seleccionar un tipo.");
			return ok(crearMasivo.render(nForm, null));
		}

		try {
			FilePart upload = body.getFile("archivo");
			file = upload.getFile();
		} catch (NullPointerException n) {
			nForm.reject("archivo", "Debe seleccionar un archivo");
			return ok(crearMasivo.render(nForm, null));
		}

		periodoId = new Long(nForm.data().get("periodo_id"));
		tipoId = new Long(nForm.data().get("liquidacion_tipo_id"));

		Integer contador = 0;
		Integer cargas = 0;
		Integer actualizaciones = 0;

		try {
			FileInputStream input = new FileInputStream(file.getAbsolutePath());
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Row row;

			Ebean.beginTransaction();
			String repe = "";
			Boolean cargar = true;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				Boolean pasar = false;
				String cuit = null;
				Long codigo = null;
				String organigrama = null;
				String periodo = null;
				BigDecimal cantidad = null;
				BigDecimal importe = null;

				row = sheet.getRow(i);

				// Valido si alguna celda se encuentra vacía
				try {
					row.getCell(1).getCellType();
				} catch (Exception e) {
					msgArchivo.add("Linea " + (i + 1) + ". El CUIT se encuentra vacío.");
					pasar = true;
				}
				try {
					row.getCell(2).getCellType();
				} catch (Exception e) {
					msgArchivo.add("Linea " + (i + 1) + ". El CODIGO se encuentra vacío.");
					pasar = true;
				}
				try {
					row.getCell(4).getCellType();
				} catch (Exception e) {
					msgArchivo.add("Linea " + (i + 1) + ". La CANTIDAD se encuentra vacío.");
					pasar = true;
				}
				try {
					row.getCell(5).getCellType();
				} catch (Exception e) {
					msgArchivo.add("Linea " + (i + 1) + ". El MONTO se encuentra vacío.");
					pasar = true;
				}

				try {
					row.getCell(6).getCellType();
				} catch (Exception e) {
					msgArchivo.add("Linea " + (i + 1) + ". El Organigrama se encuentra vacío.");
					pasar = true;
				}

				try {
					row.getCell(7).getCellType();
				} catch (Exception e) {
					msgArchivo.add("Linea " + (i + 1) + ". El Periodo se encuentra vacío.");
					pasar = true;
				}


				if (pasar) {
					cargar = false;
					continue;
				}

				// Compruebo si el tipo de celda de cuit es numérico y luego la paso a string
				if (HSSFCell.CELL_TYPE_NUMERIC == row.getCell(1).getCellType()) {
					Double c = row.getCell(1).getNumericCellValue();
					DecimalFormat decimalFormat = new DecimalFormat(".");
					decimalFormat.setGroupingUsed(false);
					decimalFormat.setDecimalSeparatorAlwaysShown(false);
					cuit = decimalFormat.format(c);
				} else {
					msgArchivo.add("Linea " + (i + 1) + ". La celda de CUIT debe ser formato numérico.");
					pasar = true;
				}

				// Compruebo si el tipo de celda de codigo es numérico y luego la paso a integer
				if (HSSFCell.CELL_TYPE_NUMERIC == row.getCell(2).getCellType()) {
					Double c = row.getCell(2).getNumericCellValue();
					codigo = c.longValue();
				} else {
					msgArchivo.add("Linea " + (i + 1) + ". La celda de CODIGO debe ser formato numérico.");
					pasar = true;
				}

				// Compruebo si el tipo de celda de cantidad es numérico y luego la paso a
				// BigDecimal
				if (HSSFCell.CELL_TYPE_NUMERIC == row.getCell(4).getCellType()) {
					cantidad = new BigDecimal(row.getCell(4).getNumericCellValue()).setScale(2, RoundingMode.HALF_DOWN);
				} else {
					msgArchivo.add("Linea " + (i + 1) + ". La celda de CANTIDAD debe ser formato numérico.");
					pasar = true;
				}

				// Compruebo si el tipo de celda de importe es numérico y luego la paso a
				// BigDecimal
				if (HSSFCell.CELL_TYPE_NUMERIC == row.getCell(5).getCellType()) {
					importe = new BigDecimal(row.getCell(5).getNumericCellValue()).setScale(2, RoundingMode.HALF_DOWN);
				} else {
					msgArchivo.add("Linea " + (i + 1) + ". La celda de IMPORTE debe ser formato numérico.");
					pasar = true;
				}

				// Compruebo el organigrama
				if (HSSFCell.CELL_TYPE_STRING == row.getCell(6).getCellType()) {
					organigrama = row.getCell(6).getStringCellValue();
				} else {
					msgArchivo.add("Linea " + (i + 1) + ". La celda de ORGANIGRAMA debe ser formato text.");
					pasar = true;
				}

				// Compruebo el organigrama
				if (HSSFCell.CELL_TYPE_STRING == row.getCell(7).getCellType()) {
					periodo = row.getCell(7).getStringCellValue();
				} else {
					msgArchivo.add("Linea " + (i + 1) + ". La celda de PERIODO debe ser formato text.");
					pasar = true;
				}

				if (pasar) {
					System.out.println("paaaaasa");
					cargar = false;
					continue;
				}

				// Busco y compruebo si el puesto laboral se encuentra en el sistema
				PuestoLaboral puesto = PuestoLaboral.find.where()
						.eq("legajo.agente.cuit", cuit)
						.eq("activo", true)
						.findUnique();
				if (puesto == null) {
					msgCuit.add("Linea " + (i + 1) + ". El puesto laboral con CUIT <b>" + cuit
							+ "</b> no se encuentra en el sistema.");
					pasar = true;
				}

				System.out.println("-----------------------------------------" + codigo);
				// Busco y compruebo si el concepto se encuentra en el sistema
				LiquidacionConcepto concepto = LiquidacionConcepto.find.where().isNull("fecha_baja")
						.eq("codigo", codigo).findUnique();

				if (concepto == null) {
					msgConcepto.add(
							"Linea " + (i + 1) + ". El concepto <b>" + codigo + "</b> no se encuentra en el sistema.");
					pasar = true;
				}

				System.out.println("------------organigrama---------------" + organigrama);
				Organigrama orga = Organigrama.find.where().eq("nombre", organigrama).findUnique();

				if (orga == null) {
					msgConcepto.add(
							"Linea " + (i + 1) + ". El organigrama <b>" + organigrama + "</b> no se encuentra en el sistema.");
					pasar = true;
				}

				System.out.println("------------periodo---------------" + periodo);
				Periodo peri = Periodo.find.where().eq("nombre", periodo).findUnique();

				if (peri == null) {
					msgConcepto.add(
							"Linea " + (i + 1) + ". El periodo <b>" + periodo + "</b> no se encuentra en el sistema.");
					pasar = true;
				}


				if (pasar) {
					cargar = false;
					System.out.println("-------------------");
					continue;

				}

				if (cargar) {

					// Busco si existe un novedad cargada para eliminar y cargar nueva
					Novedad novedadExiste = Novedad.find.where()
							.eq("liquidacion_concepto_id", concepto.id)
							.eq("puesto_laboral_id", puesto.id)
							.eq("periodo_inicio_id", periodoId)
							.eq("periodo_hasta_id", periodoId)
							.eq("liquidacion_tipo_id", tipoId)
							.findUnique();

					if (novedadExiste != null) {
						novedadExiste.delete();
						actualizaciones++;
						// repe = " - " + puesto.legajo.agente.cuit;
						repe = " - " + puesto.legajo.agente.cuit;
					} else {
						cargas++;
					}

					Novedad n = new Novedad();
					n.puesto_laboral_id = puesto.id;
					n.liquidacion_concepto_id = concepto.id;
					n.cantidad = cantidad;
					n.periodo_inicio_id = periodoId;
					n.periodo_hasta_id = periodoId;
					n.liquidacion_tipo_id = tipoId;
					n.importe = importe;
					n.cargaMasiva = true;
					n.activo = true;
					n.usuario_id = Usuario.getUsuarioSesion().longValue();
					n.fecha_novedad = new Date();
					n.organigrama_id =orga.id.longValue();
					n.periodo_concepto_id = peri.id.longValue();
					n.save();

				}

				contador++;

			}

			errores.put("archivo", msgArchivo);
			errores.put("concepto", msgConcepto);
			errores.put("cuit", msgCuit);

			if (cargar) {
				flash("success", "Se han creado <b>(" + cargas + ")</b> novedades y <b>(" + actualizaciones
						+ ")</b> fueron acutalizadas." + repe);
				Ebean.commitTransaction();
			} else {
				Ebean.rollbackTransaction();
				flash("error", "Se han encontrado algunos errores. Corríjalos y vuelva a importar el archivo.");
			}

		} catch (Exception e) {
			Ebean.rollbackTransaction();
			System.out.println("Excepction: " + e.getMessage());
			flash("error", e.getMessage());
		} finally {
			Ebean.endTransaction();
		}

		return ok(crearMasivo.render(nForm, errores));
	}

}
