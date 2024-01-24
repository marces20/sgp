package controllers.dashboard;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import models.Estado;
import models.Orden;
import models.OrdenLinea;
import models.OrdenLineaCliente;
import models.Pago;
import models.Proveedor;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NumberUtils;
import utils.RequestVar;
import views.html.dashboard.proveedores.*;

@Security.Authenticated(Secured.class)
public class ProveedoresController  extends Controller {

	@CheckPermiso(key = "dashboardProveedoresEstadoPorExpedientePorLinea")
	public static Result estadoPorExpedientePorLinea() {
		DynamicForm formBuscador = form().bindFromRequest();


		List<Orden> ol = new ArrayList<Orden>();

		Long proveedorId = new Long(0);
		Long rubroId = new Long(0);
		Long ejercicioId = new Long(0);

		if(RequestVar.get("proveedor.id").isEmpty() && RequestVar.get("orden_rubro_id").isEmpty()){
			flash("error", "Debe seleccionar un proveedor o un rubro al menos para busqueda.");

			return ok(listadoDefinitivoPorExpedientesPorLineas.render(formBuscador,ol,proveedorId,rubroId,ejercicioId));
		}

		if(!RequestVar.get("ejercicio").isEmpty()){
			ExpressionList<Orden> ox = Orden.find
									   .fetch("expediente")
									   .fetch("proveedor")
									   .fetch("lineas")
									   .fetch("lineas.producto")
									   .fetch("lineas.ordenLineaCliente")
									   .fetch("lineas.ordenLineaCliente.cliente")
									   .where();

			if(!RequestVar.get("proveedor.id").isEmpty()){
				ox.eq("proveedor_id",new Long(RequestVar.get("proveedor.id")));
				proveedorId = new Long(RequestVar.get("proveedor.id"));
			}

			if(!RequestVar.get("orden_rubro_id").isEmpty()){
				ox.eq("orden_rubro_id",new Long(RequestVar.get("orden_rubro_id")));
				rubroId = new Long(RequestVar.get("orden_rubro_id"));
			}

			if(!RequestVar.get("ejercicio").isEmpty()){
				ox.eq("expediente.ejercicio_id",new Long(RequestVar.get("ejercicio")));
				ejercicioId = new Long(RequestVar.get("ejercicio"));
			}


			ol = ox.orderBy("proveedor.nombre").findList();
		}

		return ok(listadoDefinitivoPorExpedientesPorLineas.render(formBuscador,ol,proveedorId,rubroId,ejercicioId));
	}

	@CheckPermiso(key = "dashboardProveedoresEstadoPorExpedientePorLinea")
	public static Result reporteEstadoDefinitivoExpedienteLineas(Long proveedorId,Long rubroId,Long ejercicioId) throws IOException {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/estado_proveedores.xls");

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

			Sheet hoja = libro.createSheet("estado proveedores");

			/*List<Integer> lp = new ArrayList<Integer>();
			lp.add(2556);
			lp.add(3389);
			lp.add(10831);
			lp.add(779);
			lp.add(1);
			lp.add(22);
			lp.add(3479);
			lp.add(828);*/



			int x = 0;
			Row fila = hoja.createRow(x);
			fila = hoja.createRow(x);

			fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("fecha-expediente");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue("Expediente");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(2);
			celda0.setCellValue("Proveedor");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(3);
			celda0.setCellValue("Producto");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(4);
			celda0.setCellValue("Cantidad");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(5);
			celda0.setCellValue("Precio");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(6);
			celda0.setCellValue("Total");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(7);
			celda0.setCellValue("Pacientes");
			celda0.setCellStyle(comun);


			List<Orden> o = new ArrayList<Orden>();
			//List<Proveedor> o = Proveedor.find.where().in("id", lp).findList();



			if(ejercicioId.compareTo(new Long(0)) != 0){
				ExpressionList<Orden> ox = Orden.find
										   .fetch("expediente")
										   .fetch("proveedor")
										   .fetch("lineas")
										   .fetch("lineas.producto")
										   .fetch("lineas.ordenLineaCliente")
										   .fetch("lineas.ordenLineaCliente.cliente")
										   .where();
				ox.eq("state_id", Estado.ORDEN_ESTADO_APROBADO);

				if(proveedorId.compareTo(new Long(0)) != 0){
					ox.eq("proveedor_id",proveedorId);
				}

				if(rubroId.compareTo(new Long(0)) != 0){
					ox.eq("orden_rubro_id",rubroId);
				}

				if(ejercicioId.compareTo(new Long(0)) != 0){
					ox.eq("expediente.ejercicio_id",ejercicioId);
				}


				o = ox.orderBy("proveedor.nombre").findList();
			}

			Logger.debug("1111111111111-"+ejercicioId);
			Logger.debug("2222222222222-"+proveedorId);
			Logger.debug("3333333333333-"+rubroId);
			Logger.debug("4444444444444-"+o.size());

			if(o.size() > 0){
				for(Orden olx : o){

					BigDecimal total = new BigDecimal(0);
					for(OrdenLinea oll : olx.lineas){
						x++;
						fila = hoja.createRow(x);

						celda0 = fila.createCell(0);
						celda0.setCellValue(utils.DateUtils.formatDate(olx.expediente.fecha));
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(1);
						celda0.setCellValue(olx.expediente.getExpedienteEjercicio());
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(2);
						celda0.setCellValue(olx.proveedor.nombre);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(3);
						celda0.setCellValue(oll.producto.nombre);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(4);
						celda0.setCellValue(oll.cantidad.toString());
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(5);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(oll.precio.doubleValue());
						celda0.setCellStyle(estiloMoneda);

						BigDecimal subTotal = oll.precio.multiply(oll.cantidad);
						celda0 = fila.createCell(6);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(subTotal.doubleValue());
						celda0.setCellStyle(estiloMoneda);

						String clientes= "";
						for(OrdenLineaCliente olc : oll.ordenLineaCliente){
							clientes += olc.cliente.nombre.toUpperCase()+" - ";
						}

						celda0 = fila.createCell(7);
						celda0.setCellValue(clientes);
						celda0.setCellStyle(comun);

						total = total.add(subTotal);
					}
				}
			}





			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//return ok(modalReporteCuadroSolicitud.render(archivo.getPath()));
		return ok(archivo);
	}
}
