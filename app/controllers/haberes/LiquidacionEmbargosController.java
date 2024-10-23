package controllers.haberes;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.Agente;
import models.AgenteNovedad;
import models.AgenteRul;
import models.Estado;
import models.Factura;
import models.auth.Permiso;
import models.haberes.LiquidacionEmbargo;
import models.haberes.LiquidacionEmbargoDetalle;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DateUtils;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.contabilidad.facturas.acciones.modalCargarFechaOrdenPago;
import views.html.haberes.liquidacionEmbargos.*;
import views.html.rrhh.agente.modales.modalDatosAgente;

public class LiquidacionEmbargosController extends Controller {

	final static Form<LiquidacionEmbargo> embargoForm = form(LiquidacionEmbargo.class);

	public static Result URL_LISTA_EMBARGO = redirect(
			controllers.haberes.routes.LiquidacionEmbargosController.index()
	);

	@CheckPermiso(key = "liquidacionEmbargoIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexLiquidacionEmbargo.render(LiquidacionEmbargo.page(
																RequestVar.get("puesto_laboral_id"),
																RequestVar.get("btnFiltro[0]"),//
																RequestVar.get("btnFiltro[1]"),//
																RequestVar.get("btnFiltro[2]"),
																RequestVar.get("cm"),
																RequestVar.get("tipo_embargo_id")

																),d));

	}

	@CheckPermiso(key = "liquidacionEmbargoCrear")
	public static Result crear() {
		Form<LiquidacionEmbargo> liquidacionEmbargoForm = form(LiquidacionEmbargo.class);
		return ok(crearLiquidacionEmbargo.render(liquidacionEmbargoForm));
	}

	@CheckPermiso(key = "liquidacionEmbargoCrear")
	public static Result guardar() {

		Form<LiquidacionEmbargo> liquidacionEmbargoForm = form(LiquidacionEmbargo.class).bindFromRequest();

		try {
			if(liquidacionEmbargoForm.hasErrors()) {
				flash("error", "Error en formulario "+liquidacionEmbargoForm.errors());
				return badRequest(crearLiquidacionEmbargo.render(liquidacionEmbargoForm));
			} else {
				LiquidacionEmbargo lc = liquidacionEmbargoForm.get();



				lc.estado_id = (long) Estado.LIQUIDACION_EMBARGO_BORRADOR;

				lc.save();
				flash("success", "El embargo se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionEmbargosController.ver( liquidacionEmbargoForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el embargo");
			return badRequest(crearLiquidacionEmbargo.render(liquidacionEmbargoForm));
		}
	}

	@CheckPermiso(key = "liquidacionEmbargoEditar")
	public static Result editar(Long id) {
		LiquidacionEmbargo lc = Ebean.find(LiquidacionEmbargo.class, id);
		return ok(editarLiquidacionEmbargo.render(embargoForm.fill(lc)));
	}

	@CheckPermiso(key = "liquidacionEmbargoEditar")
	public static Result actualizar(){

		Form<LiquidacionEmbargo> liquidacionEmbargoForm = form(LiquidacionEmbargo.class).bindFromRequest();

		try {

			if(liquidacionEmbargoForm.hasErrors()) {
				flash("error", "Error en formulario"+ liquidacionEmbargoForm.errors());
				return badRequest(editarLiquidacionEmbargo.render(liquidacionEmbargoForm));
			} else {
				LiquidacionEmbargo lc = liquidacionEmbargoForm.get();




				lc.update();
				flash("success", "El embargo se ha actualizado");
				return redirect( controllers.haberes.routes.LiquidacionEmbargosController.ver( liquidacionEmbargoForm.get().id ) + UriTrack.get("&"));
			}

		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el embargo");
			return badRequest(editarLiquidacionEmbargo.render(liquidacionEmbargoForm));
		}
	}

	@CheckPermiso(key = "liquidacionEmbargoEliminar")
	public static Result eliminar(Long id) {
		try {
			LiquidacionEmbargo.find.byId(id).delete();
			flash("success", "Se ha eliminado el embargo");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el embargo");
		}

		return redirect(request().getHeader("referer"));
	}

	@CheckPermiso(key = "liquidacionEmbargoVer")
	public static Result ver(Long id) throws IOException {
		LiquidacionEmbargo lc = LiquidacionEmbargo.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el embargo.");
			return URL_LISTA_EMBARGO;
		}

		return ok(verLiquidacionEmbargo.render(embargoForm.fill(lc),lc));
	}

	public static Result cambiarEstado(Long idEmbargo, Long idEstado) throws IOException{

		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_LIQUIDACION_EMBARGO);
		LiquidacionEmbargo p = LiquidacionEmbargo.find.where().eq("id", idEmbargo).findUnique();

		if(p == null){
			flash("error", "No se encuentra el embargo.");
			return redirect(request().getHeader("referer"));
		}

		if(idEstado != null){

			Boolean permiso = false;

			switch ( idEstado.intValue() ) {
		      case  Estado.LIQUIDACION_EMBARGO_BORRADOR:
		    	  if(!Permiso.check("liquidacionEmbargoPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(p.id);
		    	  break;

		      case Estado.LIQUIDACION_EMBARGO_APROBADO:
		    	  if(!Permiso.check("liquidacionEmbargoPasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAprobado(p.id);
		    	  break;
		      case Estado.LIQUIDACION_EMBARGO_CANCELADO:
		    	  if(!Permiso.check("liquidacionEmbargoPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(p.id);
		          break;
		      default:
		           break;
		      }

		}

		return redirect(controllers.haberes.routes.LiquidacionEmbargosController.ver(p.id)+ UriTrack.get("&"));
	}

	@CheckPermiso(key = "liquidacionEmbargoPasarBorrador")
	public static void pasarEnBorrador(Long id){

		LiquidacionEmbargo p = Ebean.find(LiquidacionEmbargo.class).select("id, estado_id").setId(id).findUnique();

		if(p != null){
			p.estado_id = new Long(Estado.LIQUIDACION_EMBARGO_BORRADOR);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}

	@CheckPermiso(key = "liquidacionEmbargoPasarControlado")
	public static void pasarAprobado(Long id){

		LiquidacionEmbargo p = Ebean.find(LiquidacionEmbargo.class).select("id, estado_id").setId(id).findUnique();

		if(p != null){
			p.estado_id = new Long(Estado.LIQUIDACION_EMBARGO_APROBADO);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Controlado");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}

	@CheckPermiso(key = "liquidacionEmbargoPasarCancelado")
	public static void pasarCancelado(Long id){

		LiquidacionEmbargo p = Ebean.find(LiquidacionEmbargo.class).select("id, estado_id").setId(id).findUnique();

		if(p != null){
			p.estado_id = new Long(Estado.LIQUIDACION_EMBARGO_CANCELADO);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	@CheckPermiso(key = "liquidacionEmbargoCargarDetalleMasivo")
	public static Result modalCargarDetalleMasivo() {
		return ok(modalCargarDetalleMasivo.render(form().bindFromRequest()));
	}

	@CheckPermiso(key = "liquidacionEmbargoCargarDetalleMasivo")
	public static Result cargarDetalleMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> facturasSeleccionados = getSeleccionados();

		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una retencion.");
			return ok(modalCargarDetalleMasivo.render(d));
		}

		//if(!soloBorrador(facturasSeleccionados)) {
		//	flash("error", "Solo se puede modificar registros en estado borrador.");
		//	return ok(modalCargarDetalleMasivo.render(d));
		//}

		Date fechaOrdenPago = DateUtils.formatDate(request().body().asFormUrlEncoded().get("fecha_orden_pago_modal")[0], "dd/MM/yyyy");
		if(fechaOrdenPago == null){
			flash("error", "Seleccione una fecha de orden de pago .");
			return ok(modalCargarFechaOrdenPago.render(d));
		}


		if(d.hasErrors())
			return ok(modalCargarDetalleMasivo.render(d));

		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.CargarFechaOrdenPagoMasivo(fechaOrdenPago, facturasSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalCargarDetalleMasivo.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCargarDetalleMasivo.render(d));
		}

	}

	public static Result reporteDetalle() {
		DynamicForm d = form().bindFromRequest();
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_retenciones.xls");


		List<Integer> reteIds = getSeleccionados();

		if(reteIds.size() <= 0){
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
			List<LiquidacionEmbargoDetalle> ld = LiquidacionEmbargoDetalle.find
					.fetch("liquidacionEmbargo")
					.fetch("liquidacionEmbargo.estado", "id, nombre")
					.fetch("liquidacionEmbargo.proveedor", "nombre")
			        .fetch("liquidacionEmbargo.puestoLaboral.legajo.agente", "apellido")
					.where().in("liquidacion_embargo_id", reteIds).orderBy("liquidacionEmbargo.puestoLaboral.legajo.agente.apellido asc")
						.findList();


			if(ld.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("Cuit");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellValue("Tipo Retencion");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(3);
				celda0.setCellValue("Nombre Oficio");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(4);
				celda0.setCellValue("CBU Oficio");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(5);
				celda0.setCellValue("Cuenta Oficio");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(6);
				celda0.setCellValue("Concepto");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(7);
				celda0.setCellValue("Periodo");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(8);
				celda0.setCellValue("Tipo Liquidacion");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(9);
				celda0.setCellValue("importe");
				celda0.setCellStyle(comun);


				x++;


				BigDecimal total =  new BigDecimal(0);
				BigDecimal totalHaberes =  new BigDecimal(0);


				for (LiquidacionEmbargoDetalle l: ld) {

					System.out.println(l.liquidacionEmbargo.puestoLaboral.legajo.agente.apellido);
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(l.liquidacionEmbargo.puestoLaboral.legajo.agente.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(l.liquidacionEmbargo.puestoLaboral.legajo.agente.cuit);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(l.liquidacionEmbargo.tipoEmbargo.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue(l.liquidacionEmbargo.proveedor.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue(l.liquidacionEmbargo.proveedor.getCuentaBancaria().cbu);
					celda0.setCellStyle(comun);

 					celda0 = fila.createCell(5);
					celda0.setCellValue(l.liquidacionEmbargo.proveedor.getCuentaBancaria().numero_cuenta);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(6);
					celda0.setCellValue(l.liquidacionConcepto.denominacion);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(7);
					celda0.setCellValue(l.periodo.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(8);
					celda0.setCellValue(l.liquidacionTipo.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(9);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(l.importe.doubleValue());
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
