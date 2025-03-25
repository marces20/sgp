package controllers.haberes;

import static play.data.Form.form;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;
import models.Agente;
import models.AgenteNovedad;
import models.AgenteRul;
import models.Estado;
import models.Factura;
import models.Usuario;
import models.auth.Permiso;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionEmbargo;
import models.haberes.LiquidacionEmbargoDetalle;
import models.haberes.LiquidacionPuesto;
import models.haberes.Novedad;
import models.haberes.PuestoLaboral;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import utils.DateUtils;
import utils.RequestVar;
import utils.UriTrack;
import views.html.sinPermiso;
import views.html.contabilidad.facturas.acciones.modalCargarFechaOrdenPago;
import views.html.haberes.liquidacionEmbargos.*;
import views.html.haberes.novedades.crearMasivo;
import views.html.haberes.puestosLaborales.acciones.modalPasarABorrador;
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
																RequestVar.get("btnFiltro[3]"),
																RequestVar.get("btnFiltro[4]"),
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
		      case Estado.LIQUIDACION_EMBARGO_ESPERA:
		    	  if(!Permiso.check("liquidacionEmbargoPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEspera(p.id);
		          break;
		      case Estado.LIQUIDACION_EMBARGO_POST_ESPERA:
		    	  if(!Permiso.check("liquidacionEmbargoPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarPosEspera(p.id);
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

	@CheckPermiso(key = "liquidacionEmbargoPasarCancelado")
	public static void pasarEspera(Long id){

		LiquidacionEmbargo p = Ebean.find(LiquidacionEmbargo.class).select("id, estado_id").setId(id).findUnique();

		if(p != null){
			p.estado_id = new Long(Estado.LIQUIDACION_EMBARGO_ESPERA);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Espera");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}

	@CheckPermiso(key = "liquidacionEmbargoPasarCancelado")
	public static void pasarPosEspera(Long id){

		LiquidacionEmbargo p = Ebean.find(LiquidacionEmbargo.class).select("id, estado_id").setId(id).findUnique();

		if(p != null){
			p.estado_id = new Long(Estado.LIQUIDACION_EMBARGO_POST_ESPERA);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Pos Espera");
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

	public static Boolean soloAprobadosAndEnEspera(List<Integer> pSeleccionados) {
		return LiquidacionEmbargo.find.where().ne("estado_id", Estado.LIQUIDACION_EMBARGO_ESPERA).ne("estado_id", Estado.LIQUIDACION_EMBARGO_APROBADO).in("id", pSeleccionados).findRowCount() == 0;
	}

	public static Result crearLineaLiquidacion() {
		DynamicForm d = form().bindFromRequest();
		String error = "";
		Boolean hayError = false;

		List<Integer> reteIds = getSeleccionados();


		if(reteIds.size() <= 0){
			flash("error", "Debe seleccionar una Retencion.");
			return ok(modalResponseCargaLineaLiquidacion.render(null,d));
		}

		if(!soloAprobadosAndEnEspera(reteIds)) {
			flash("error", "Solo se puede cargar registros en estado aprobados o en espera");
			return ok(modalResponseCargaLineaLiquidacion.render(null,d));
		}




		int x = 0;

		try {

			List<Long> idsCargados = new ArrayList<>();
			List<LiquidacionDetalle> ids = LiquidacionDetalle.find.select("liquidacion_embargo_detalle_id")
										  .fetch("liquidacionPuesto")
										  .where().isNotNull("liquidacion_embargo_detalle_id")
										  .eq("liquidacionPuesto.estado_id", Estado.LIQUIDACION_PUESTOS_APROBADO)
										  .findList();
			for(LiquidacionDetalle ldx :ids) {
				idsCargados.add(ldx.liquidacion_embargo_detalle_id);
			}
			idsCargados.add(new Long(486));

			List<LiquidacionEmbargoDetalle> ld = LiquidacionEmbargoDetalle.find
					.fetch("liquidacionEmbargo")
					.fetch("liquidacionEmbargo.estado", "id, nombre")
					.fetch("liquidacionEmbargo.proveedor", "nombre")
			        .fetch("liquidacionEmbargo.puestoLaboral.legajo.agente", "apellido")
					.where()
					.in("liquidacion_embargo_id", reteIds)
					.disjunction()
					.eq("liquidacionEmbargo.estado.id",Estado.LIQUIDACION_EMBARGO_APROBADO)
					.eq("liquidacionEmbargo.estado.id",Estado.LIQUIDACION_EMBARGO_ESPERA)
					.endJunction()
					.not(Expr.in("id",idsCargados))
					.orderBy("liquidacionEmbargo.puestoLaboral.legajo.agente.apellido asc")
					.findList();

			Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx------------------------------------");
			for (LiquidacionEmbargoDetalle l: ld) {
				List<Novedad> ndelete = Novedad.find.where()
						.eq("puesto_laboral_id", l.liquidacionEmbargo.puesto_laboral_id)
						.eq("liquidacion_concepto_id",  l.liquidacion_concepto_id)
						.eq("periodo_inicio_id", l.periodo_id.longValue())
						.eq("periodo_hasta_id", l.periodo_id.longValue()).findList();

				for(Novedad nx :ndelete) {
					nx.delete();
				}
			}

			for (LiquidacionEmbargoDetalle l: ld) {

				LiquidacionPuesto lp = LiquidacionPuesto.find.select("id,puestoLaboral.id,puestoLaboral.legajo.agente.organigrama_id")
										.fetch("liquidacionMes","liquidacion_tipo_id,periodo_id")
										.fetch("puestoLaboral","id")
										.fetch("puestoLaboral.legajo.agente","organigrama_id")
										.where()
										.eq("liquidacionMes.liquidacion_tipo_id",l.liquidacion_tipo_id)
										.eq("liquidacionMes.periodo_id",l.periodo_id)
										.eq("puestoLaboral.id", l.liquidacionEmbargo.puesto_laboral_id)
										.disjunction()
										.eq("estado_id",Estado.LIQUIDACION_PUESTOS_PREAPROBADO)
										.eq("estado_id",Estado.LIQUIDACION_PUESTOS_BORRADOR)
										.endJunction()
										.findUnique();



				if(lp != null) {
					LiquidacionDetalle ldelete = LiquidacionDetalle.find.where().eq("liquidacion_embargo_detalle_id", l.id).findUnique();

					if(ldelete != null) {
						ldelete.delete();
					}

					LiquidacionDetalle ldx = new  LiquidacionDetalle();
					ldx.liquidacion_puesto_id = lp.id;
					ldx.liquidacion_concepto_id= l.liquidacion_concepto_id;
					ldx.cantidad=new BigDecimal(1);
					ldx.importe= l.importe;
					ldx.periodo_id=l.periodo_id.longValue();
					ldx.organigrama_id = lp.puestoLaboral.legajo.agente.organigrama_id;
					ldx.liquidacion_embargo_detalle_id= l.id;
					ldx.save();

					Novedad ndelete = Novedad.find.where().eq("liquidacion_embargo_detalle_id", l.id).findUnique();

					if(ndelete != null) {
						ndelete.delete();
					}

					Novedad n = new Novedad();
					n.puesto_laboral_id= lp.puestoLaboral.id;
					n.liquidacion_concepto_id= l.liquidacion_concepto_id;
					n.periodo_inicio_id= l.periodo_id.longValue();
					n.periodo_hasta_id= l.periodo_id.longValue();
					n.periodo_concepto_id= l.periodo_id.longValue();
					n.organigrama_id= lp.puestoLaboral.legajo.agente.organigrama_id;
					n.activo= true;
					n.fecha_novedad= new Date();;
					n.importe = l.importe;
					n.cantidad = new BigDecimal(1);
					n.usuario_id= new Long(Usuario.getUsuarioSesion());
					n.liquidacion_tipo_id = l.liquidacion_tipo_id.longValue();
					n.create_date = new Date();
					n.liquidacion_embargo_detalle_id = l.id;
					n.save();


					x ++;
				}else {

				}

			}

			String ret = "Se insertaron "+x+" detalles";

			return ok(modalResponseCargaLineaLiquidacion.render(ret,d));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(modalResponseCargaLineaLiquidacion.render(null,d));
	}

	public static Result reporteDetalle() {
		DynamicForm d = form().bindFromRequest();
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_retenciones.xls");


		List<Integer> reteIds = getSeleccionados();

		if(reteIds.size() <= 0){
			flash("error", "Debe seleccionar una Retencion.");
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

			Sheet hoja = libro.createSheet("Retencion");


 			List<LiquidacionEmbargoDetalle> ld = LiquidacionEmbargoDetalle.find
					.fetch("liquidacionEmbargo")
					.fetch("periodo")
					.fetch("liquidacionTipo")
					.fetch("liquidacionEmbargo.estado", "id, nombre")
					.fetch("liquidacionEmbargo.proveedor", "nombre")
			        .fetch("liquidacionEmbargo.puestoLaboral.legajo.agente", "apellido")
					.where()
					.in("liquidacion_embargo_id", reteIds)
					.orderBy("liquidacionEmbargo.puestoLaboral.legajo.agente.apellido,periodo.id asc")
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
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
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

	public static Result exportarRetencionSinLiquidacion() {
		DynamicForm d = form().bindFromRequest();
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_retenciones.xls");


		List<Integer> reteIds = getSeleccionados();

		if(reteIds.size() <= 0){
			flash("error", "Debe seleccionar una Retencion.");
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

			Sheet hoja = libro.createSheet("Retencion");

			List<Long> idsCargados = new ArrayList<>();
			List<LiquidacionDetalle> ids = LiquidacionDetalle.find.select("liquidacion_embargo_detalle_id").where()
					.isNotNull("liquidacion_embargo_detalle_id")
					.eq("liquidacionPuesto.estado_id", Estado.LIQUIDACION_PUESTOS_APROBADO)
					.findList();
			for(LiquidacionDetalle ldx :ids) {
				idsCargados.add(ldx.liquidacion_embargo_detalle_id);
			}
 			List<LiquidacionEmbargoDetalle> ld = LiquidacionEmbargoDetalle.find
					.fetch("liquidacionEmbargo")
					.fetch("periodo")
					.fetch("liquidacionTipo")
					.fetch("liquidacionEmbargo.estado", "id, nombre")
					.fetch("liquidacionEmbargo.proveedor", "nombre")
			        .fetch("liquidacionEmbargo.puestoLaboral.legajo.agente", "apellido")
					.where()
					.in("liquidacion_embargo_id", reteIds)
					.not(Expr.in("id",idsCargados))
					.orderBy("liquidacionEmbargo.puestoLaboral.legajo.agente.apellido,periodo.id asc")
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
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
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

	public static Result crearMasivo() {
		Form<LiquidacionEmbargoDetalle> nForm = form(LiquidacionEmbargoDetalle.class);
		return ok(crearEmbargoMasivo.render(nForm, null));
	}

	public static Result procesarMasivo() {

		Form<LiquidacionEmbargoDetalle> nForm = form(LiquidacionEmbargoDetalle.class).bindFromRequest();
		MultipartFormData body = request().body().asMultipartFormData();
		Map<String, String[]> formData = request().body().asFormUrlEncoded();
		List<String> msgArchivo = new ArrayList<String>();
		List<String> msgCuit = new ArrayList<String>();
		List<String> msgConcepto = new ArrayList<String>();
		HashMap<String, List<String>> errores = new HashMap<String, List<String>>();

		String algo = "";

		File file;

		Integer periodoId = null;
		Integer tipoId = null;


		System.out.println(nForm.data());

		if (nForm.data().get("periodo_id").isEmpty()) {
			nForm.reject("periodo_id", "Debe seleccionar periodo.");
			return ok(crearEmbargoMasivo.render(nForm, null));
		}

		try {
			FilePart upload = body.getFile("archivo");
			file = upload.getFile();
		} catch (NullPointerException n) {
			nForm.reject("archivo", "Debe seleccionar un archivo");
			return ok(crearEmbargoMasivo.render(nForm, null));
		}

		if (nForm.data().get("liquidacion_tipo_id").isEmpty()) {
			nForm.reject("liquidacion_tipo_id", "Debe seleccionar un tipo.");
			return ok(crearEmbargoMasivo.render(nForm, null));
		}

		periodoId = new Integer(nForm.data().get("periodo_id"));
		tipoId = new Integer(nForm.data().get("liquidacion_tipo_id"));

		Integer contador = 0;
		Integer cargas = 0;
		Integer actualizaciones = 0;

		System.out.println(nForm.data());
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


				row = sheet.getRow(i);

				Boolean pasar = false;
				String cuit = null;
				String cbu = null;
				String tipoRetencion = null;
				BigDecimal importe = null;

				try {
					row.getCell(1).getCellType();
				} catch (Exception e) {
					msgArchivo.add("Linea " + (i + 1) + ". El CUIT se encuentra vacío.");
					pasar = true;
				}

				try {
					row.getCell(4).getCellType();
				} catch (Exception e) {
					msgArchivo.add("Linea " + (i + 1) + ". El CBU se encuentra vacío.");
					pasar = true;
				}





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

				if (HSSFCell.CELL_TYPE_STRING == row.getCell(2).getCellType()) {
					tipoRetencion = row.getCell(2).getStringCellValue();
				} else {
					msgArchivo.add("Linea " + (i + 1) + ". La celda de Tipo Retencion debe ser formato text.");
					pasar = true;
				}

				if (HSSFCell.CELL_TYPE_STRING == row.getCell(4).getCellType()) {
					cbu = row.getCell(4).getStringCellValue();
				} else {
					msgArchivo.add("Linea " + (i + 1) + ". La celda de CBU debe ser formato text.");
					pasar = true;
				}

				Logger.debug("xxxxxxxxxxxxxx {}",row.getCell(9).getCellType());
				Logger.debug("xxxxxxxxxxxxxx {}",row.getCell(9).getCellType());
				//Logger.debug("xxxxxxxxxxxxxx {}",row.getCell(9).get);

				if (HSSFCell.CELL_TYPE_NUMERIC == row.getCell(9).getCellType()) {
					importe = new BigDecimal(row.getCell(9).getNumericCellValue()).setScale(2, RoundingMode.HALF_DOWN);
				} else {
					msgArchivo.add("Linea " + (i + 1) + ". La celda de IMPORTE debe ser formato numérico.");
					pasar = true;
				}

				List<LiquidacionEmbargo> le = LiquidacionEmbargo.find.where()
											 .eq("puestoLaboral.legajo.agente.cuit", cuit)
											 //.eq("proveedor.getCuentaBancaria().cbu",cbu)
											 .disjunction()
											 .eq("estado_id", Estado.LIQUIDACION_EMBARGO_ESPERA)
											 .eq("estado_id", Estado.LIQUIDACION_EMBARGO_APROBADO)
											 .endJunction()
											 .findList();


				Long liquidacion_embargo_id = null;
				if(le != null) {
					boolean noHay = true;
					String prov = "";
 					for(LiquidacionEmbargo lex : le) {

						if(lex.proveedor.getCuentaBancaria() !=  null && lex.proveedor.getCuentaBancaria().cbu.trim().compareToIgnoreCase(cbu) == 0) {
							 liquidacion_embargo_id = lex.id;
							 noHay = false;
						}

						Logger.debug("getCuentaBancaria {}", lex.proveedor.getCuentaBancaria().cbu);
						Logger.debug(".getCuentaBancaria().cbu.compareToIgnoreCase(cbu) {}", lex.proveedor.getCuentaBancaria().cbu.compareToIgnoreCase(cbu));
					}
 					if(noHay) {
 						Logger.debug("cbu noHaynoHay yyyyyyyyyyyyyyyyyyyyyyyyyyyyy {}", cbu +cuit);

 						msgArchivo.add("Linea " + (i + 1) + ". No se encuentra una cbu cargada para este cuit  "+cuit );
 						pasar = true;
 					}

				}else {
					msgArchivo.add("Linea " + (i + 1) + ". No se encuentra una retencion cargada con este cuit");
					pasar = true;
				}

				if (pasar) {
					cargar = false;
					continue;
				}


				Long liquidacion_concepto_id = null;

				if(tipoRetencion.compareToIgnoreCase("RETENCION JUDICIAL POR ALIMENTOS") == 0) {
					liquidacion_concepto_id = new Long(20);
				}else if (tipoRetencion.compareToIgnoreCase("EMBARGO JUDICIAL") == 0) {
					liquidacion_concepto_id = new Long(427);
				}



				if (cargar) {
					LiquidacionEmbargoDetalle ld = new LiquidacionEmbargoDetalle();
					ld.importe = importe;
					ld.liquidacion_concepto_id = liquidacion_concepto_id;
					ld.liquidacion_embargo_id = liquidacion_embargo_id;
					ld.liquidacion_tipo_id =  tipoId;
					ld.periodo_id = periodoId;
					ld.save();
					cargas ++;
				}

				contador++;

			}

			errores.put("archivo", msgArchivo);
			errores.put("concepto", msgConcepto);
			errores.put("cuit", msgCuit);


			if (cargar) {
				flash("success", "Se han creado <b>(" + cargas + ")</b> retenciones ");
				Ebean.commitTransaction();
			} else {
				Ebean.rollbackTransaction();
				flash("error", "Se han encontrado algunos errores. Corríjalos y vuelva a importar el archivo.");
			}

		} catch (Exception e) {
			Ebean.rollbackTransaction();
			System.out.println("Excepction: " + e.getMessage());
			flash("error", e.toString());
		} finally {
			Ebean.endTransaction();
		}

	return ok(crearEmbargoMasivo.render(nForm, errores));
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
