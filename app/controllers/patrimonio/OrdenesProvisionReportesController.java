package controllers.patrimonio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import models.ActaRecepcion;
import models.Certificacion;
import models.CertificacionServicio;
import models.CertificacionServicioLinea;
import models.CuentaAnalitica;
import models.DireccionProveedor;
import models.Estado;
import models.Factura;
import models.Orden;
import models.OrdenLinea;
import models.OrdenLineaAnulacion;
import models.OrdenLineaCliente;
import models.OrdenPago;
import models.OrdenProvision;
import models.OrdenProvisionLineas;
import models.Proveedor;
import models.RemitoLinea;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.MathTool;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Query;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.google.common.collect.Lists;

import controllers.Secured;
import controllers.compras.OrdenesController;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import play.Logger;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import views.html.contabilidad.facturas.reportes.reporteComprobanteRetencionMunicipal;
import views.html.patrimonio.ordenesProvision.reportes.*;

@Security.Authenticated(Secured.class)
public class OrdenesProvisionReportesController extends Controller  {

	public static Result reporteGeneralOp(){

		List<Integer> opSeleccionados = getSeleccionados();

		if(opSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado op.");
			return ok(modalReporteGeneralOp.render(null));
		}


		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;

		try {
			File archivo = new File(dirTemp+"/reporteGeneralOp.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			/*estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);*/

			Sheet hoja = libro.createSheet("reporte");

			List<OrdenProvision> op = OrdenProvision.find.fetch("ordenCompra")
												   .fetch("ordenCompra.proveedor")
												   .fetch("ordenCompra.expediente")
												   .where().in("id", opSeleccionados).orderBy("numero").findList();

			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Número");
			fila.createCell(1).setCellValue("Expediente");
			fila.createCell(2).setCellValue("Monto Base");
			fila.createCell(3).setCellValue("Ajuste");
			fila.createCell(4).setCellValue("Total");
			fila.createCell(5).setCellValue("Recepcionado");
			fila.createCell(6).setCellValue("Pediente");
			fila.createCell(7).setCellValue("Entregado");
			fila.createCell(8).setCellValue("Proveedor");
			fila.createCell(9).setCellValue("Fecha");
			fila.createCell(10).setCellValue("Tipo");
			fila.createCell(11).setCellValue("Institucion");

			int f = 1;
			for (OrdenProvision x : op) {
					fila = hoja.createRow(f);
					for(int c=0;c<11;c++){
						Cell celda = fila.createCell(c);

						switch (c) {
						case 0:
							celda.setCellValue(x.numero);
							break;
						case 1:
							celda.setCellValue(x.ordenCompra.expediente.getExpedienteEjercicio());
							break;
						case 2:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(x.ordenCompra.getTotal().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;
						case 3:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(x.ordenCompra.getTotalAjuste().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;
						case 4:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(x.ordenCompra.getTotalTotal().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;
						case 5:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(x.getTotalRecepcionado().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;
						case 6:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(x.getPendiente().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;
						case 7:
							celda.setCellValue(x.getPorcentajeEntregado());
							break;
						case 8:
							celda.setCellValue(x.ordenCompra.proveedor.nombre);
							break;
						case 9:
							celda.setCellValue(DateUtils.formatDate(x.fecha));
							break;
						case 10:
							celda.setCellValue((x.ordenCompra.tipo_orden == "servicio")?"Servicio":"Recepcion");
							break;
						case 11:
							celda.setCellValue(x.ordenCompra.deposito.nombre);
							break;
						default:
							break;
						}
					}
					f++;
			}

			libro.write(archivoTmp);
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(modalReporteGeneralOp.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result reporteListaLineasRemitos(){

		List<Integer> opSeleccionados = getSeleccionados();

		if(opSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado op.");
			return ok(modalReporteGeneralOp.render(null));
		}


		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;

		try {
			File archivo = new File(dirTemp+"/reporteGeneralOp.xls");
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

			Sheet hoja = libro.createSheet("reporte");

			List<OrdenProvision> op = OrdenProvision.find.fetch("ordenCompra")
												   .fetch("ordenCompra.proveedor")
												   .fetch("ordenCompra.expediente")
												   .where().in("id", opSeleccionados)
												   .orderBy("numero").findList();

			Row fila = null;



			int f = 0;
			for (OrdenProvision x : op) {

				hoja.addMergedRegion(new  CellRangeAddress(f,f,0,7));
				fila = hoja.createRow(f);
				fila.createCell(0).setCellValue(x.ordenCompra.proveedor.nombre+" - "+x.ordenCompra.expediente.getExpedienteEjercicio()+" - "+x.getOpEjercicio());
				f++;

				fila = hoja.createRow(f);
				fila.createCell(0).setCellValue("Producto");
				fila.createCell(1).setCellValue("Cantidad");
				fila.createCell(2).setCellValue("Precio");
				fila.createCell(3).setCellValue("Total");
				fila.createCell(4).setCellValue("Recepcionado");
				fila.createCell(5).setCellValue("Pediente");
				fila.createCell(6).setCellValue("Total pendiente");
				fila.createCell(7).setCellValue("Remitos");
				f++;

				ExpressionList<OrdenProvisionLineas> e = OrdenProvisionLineas.getQuery(x.ordenCompra.id).where();
				for (OrdenProvisionLineas l : e.findList()) {

					fila = hoja.createRow(f);

					for(int c=0;c<8;c++){
						Cell celda = fila.createCell(c);

						switch (c) {
						case 0:
							celda.setCellValue(l.producto.nombre);
							celda.setCellStyle(comun);
							break;
						case 1:
							celda.setCellValue(l.cantidad.doubleValue());
							celda.setCellStyle(comun);
							break;
						case 2:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(l.precio.doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;
						case 3:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(l.getTotal().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;
						case 4:
							celda.setCellValue(l.getRecepcionado().doubleValue());
							celda.setCellStyle(comun);
							break;
						case 5:

							celda.setCellValue(l.getPendiente().doubleValue());
							celda.setCellStyle(comun);
							break;
						case 6:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(l.getTotalPendiente().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;
						case 7:
							String texto ="";
							List<RemitoLinea> rl = RemitoLinea.find.fetch("lineaOrden").where().eq("linea_orden_id",l.orden_linea_id ).findList();
							for (RemitoLinea rlx : rl) {
								texto += rlx.remito.numero+"("+rlx.cantidad+") | ";
							}
							if(texto.length() > 0){
								texto.substring(0, texto.length()-1);
							}

							celda.setCellValue(texto);
							celda.setCellStyle(comun);
							break;

						default:
							break;
						}
					}
					f++;
				}
				f++;
				f++;
			}

			libro.write(archivoTmp);
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(modalReporteGeneralOp.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result informeGeneral(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/informe_general.xls");

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

			Sheet hoja = libro.createSheet("Informe General");

			//OrdenProvision o = OrdenProvision.find.byId(id);

			List<OrdenProvisionLineas> lineasPedientes = new ArrayList<OrdenProvisionLineas>();
			OrdenProvisionLineas o = new OrdenProvisionLineas();

			OrdenProvision orden = OrdenProvision.find.byId(id);


			Query<OrdenProvisionLineas> a = o.getQuery(orden.orden_compra_id);

			for (OrdenProvisionLineas ol: a.findList()) {
				lineasPedientes.add(ol);
			}

			int x = 0;
			if(lineasPedientes.size() > 0){
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("GENERAL");
				celda0.setCellStyle(comun);
				x++;
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Producto");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Solicitado");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Recepcionado");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Pendiente");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Total");
				celda0.setCellStyle(comun);
				x++;
				for(OrdenProvisionLineas oli : lineasPedientes){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(oli.producto.nombre);
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(oli.cantidad.doubleValue());
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(2);
					celda0.setCellValue(oli.getRecepcionado().doubleValue());
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(3);
					celda0.setCellValue(oli.getPendiente().toString());
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(4);
					celda0.setCellValue(utils.NumberUtils.moneda(oli.getTotal()));
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
		return ok(archivo);
	}


	public static Result informePendiente(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/informe_pendientes.xls");

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

			Sheet hoja = libro.createSheet("Informe Pedientes");

			//OrdenProvision o = OrdenProvision.find.byId(id);

			List<OrdenProvisionLineas> lineasPedientes = new ArrayList<OrdenProvisionLineas>();
			OrdenProvisionLineas o = new OrdenProvisionLineas();

			OrdenProvision orden = OrdenProvision.find.byId(id);

			Query<OrdenProvisionLineas> a = o.getQuery(orden.orden_compra_id);

			for (OrdenProvisionLineas ol: a.findList()) {
				if(ol.getPendiente().compareTo(BigDecimal.ZERO) > 0){
					lineasPedientes.add(ol);
				}
			}
			BigDecimal total = new BigDecimal(0);
			int x = 0;
			if(lineasPedientes.size() > 0){
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("PEDIENTES");
				celda0.setCellStyle(comun);
				x++;
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Producto");
				celda0.setCellStyle(comun);

				fila = hoja.createRow(x);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Cantidad");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellValue("Precio");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(3);
				celda0.setCellValue("Total");
				celda0.setCellStyle(comun);
				x++;
				for(OrdenProvisionLineas oli : lineasPedientes){
					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(oli.producto.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(oli.getPendiente().doubleValue());
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(oli.precio.doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(3);
					celda0.setCellValue(oli.getPendiente().multiply(oli.precio).setScale(2, RoundingMode.HALF_DOWN).doubleValue());
					celda0.setCellStyle(estiloMoneda);
					total = total.add(oli.getPendiente().multiply(oli.precio).setScale(2, RoundingMode.HALF_DOWN));
					x++;
				}

				fila = hoja.createRow(x);
				celda0 = fila.createCell(2);
				celda0.setCellValue("TOTAL");
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(3);
				celda0.setCellValue(total.doubleValue());
				celda0.setCellStyle(estiloMoneda);
			}
			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(archivo);
	}

	public static Result informeInventariable(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/informe_inventariables.xls");

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

			Sheet hoja = libro.createSheet("Informe Inventariables");

			OrdenProvision o = OrdenProvision.find.byId(id);


			List<OrdenLinea> lineasInventariables = new ArrayList<OrdenLinea>();
			List<OrdenLinea> lineasNoInventariables = new ArrayList<OrdenLinea>();

			for (OrdenLinea ol: o.ordenCompra.lineas) {

				if(CuentaAnalitica.getCuentasParaInventario().contains(ol.cuentaAnalitica.id.intValue())) {
				//if(ol.cuentaAnalitica.parent_id == 218 || ol.cuentaAnalitica.parent_id == 106 || ol.cuentaAnalitica.parent_id == 201 || ol.cuentaAnalitica.parent_id == 217){
					lineasInventariables.add(ol);
				}else{
					lineasNoInventariables.add(ol);
				}
			}

			int x = 0;
			if(lineasInventariables.size() > 0){
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("INVENTARIABLES");
				celda0.setCellStyle(comun);
				x++;
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Cantidad");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Id Cuenta");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Nombre Cuenta");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Producto");
				celda0.setCellStyle(comun);
				x++;
				for(OrdenLinea oli : lineasInventariables){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(oli.cantidad.toString());
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(oli.cuentaAnalitica.codigo);
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(2);
					celda0.setCellValue(oli.cuentaAnalitica.nombre);
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(3);
					celda0.setCellValue(oli.producto.nombre);
					celda0.setCellStyle(comun);

					x++;
				}
			}
			x++;

			if(lineasNoInventariables.size() > 0){
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("NO INVENTARIABLES");
				celda0.setCellStyle(comun);
				x++;
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Cantidad");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Id Cuenta");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Nombre Cuenta");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Producto");
				celda0.setCellStyle(comun);
				x++;
				for(OrdenLinea oli : lineasNoInventariables){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(oli.cantidad.toString());
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(oli.cuentaAnalitica.codigo);
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(2);
					celda0.setCellValue(oli.cuentaAnalitica.nombre);
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(3);
					celda0.setCellValue(oli.producto.nombre);
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
		return ok(archivo);
	}

	public static Result ordenDeProvision(Long idOrdenProvision,boolean sinMonto) {

		if(idOrdenProvision == null){
			flash("error", "Debe seleccionar una orden de provision.");
		 	return ok(modalReporteOrdenProvision.render(null));
		}

		Orden o = Orden.find.byId(idOrdenProvision);
		if(o == null){
			flash("error", "No se encuentra la orden de provision.");
			return ok(modalReporteOrdenProvision.render(null));
		}

		Proveedor pr = o.proveedor;
		List<DireccionProveedor> dpl = DireccionProveedor.find.where().eq("proveedor_id",pr.id).findList();
		if(dpl.size() <= 0){
			flash("error", "Faltan ingresar datos del proveedor.");
			return ok(modalReporteOrdenProvision.render(null));
		}
		DireccionProveedor dp = dpl.get(0);

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/orden-provision.odt");

		try {

			archivo = OrdenProvision.getArchivoReporteOrdenProvision(archivo,sinMonto,o,dp,pr);

		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte.");
			return ok(modalReporteOrdenProvision.render(null));
		}

		return ok(modalReporteOrdenProvision.render(archivo.getPath()));
	}




	/*public static Result ordenDeProvision(Long idOrdenProvision,boolean sinMonto) {

		if(idOrdenProvision == null){
			flash("error", "Debe seleccionar una orden de provision.");
		 	return ok(modalReporteOrdenProvision.render(null));
		}


		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/orden-provision.odt");

		try {

			InputStream in = Play.application().resourceAsStream("resources/reportes/patrimonio/ordenesProvision/orden-provision.odt");
			if(sinMonto){
				in = Play.application().resourceAsStream("resources/reportes/patrimonio/ordenesProvision/orden-provision-sinmontos.odt");
			}
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			//OrdenProvision op = OrdenProvision.find.byId(idOrdenProvision);

			SqlUpdate update = Ebean.createSqlUpdate("UPDATE orden_lineas SET departamento_id = 147 WHERE orden_id = :orden_id AND departamento_id is null ");
			update.setParameter("orden_id",idOrdenProvision);
			update.execute();

			Orden o = Orden.find.byId(idOrdenProvision);

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			metadata.addFieldAsTextStyling("notas", SyntaxKind.Html);
			IContext context = report.createContext();

			if(o != null){
				context.put("math", new MathTool());
				context.put("numberUtils", new NumberUtils());
				context.put("expediente", o.expediente.getInstitucionExpedienteEjercicio());
				context.put("numeroOP",(o.numero_orden_provision != null)?o.numero_orden_provision: "");
				context.put("fechaOP", (o.fecha_provision != null)?DateUtils.formatDate(o.fecha_provision): "");

				Proveedor pr = o.proveedor;
				context.put("proveedorNombre", pr.nombre);
				context.put("proveedorCuit", pr.cuit);

				DireccionProveedor dp = DireccionProveedor.find.where().eq("proveedor_id",pr.id).findUnique();
				if(dp != null){
					String dire = dp.calle;
					dire += " "+dp.numero;

					dire += (dp.localidad != null)?" - "+dp.localidad.nombre:" ";
					dire += (dp.zip != null)?" ("+dp.zip+")":" ";
					dire += (dp.localidad != null && dp.localidad.provincia!= null)?" - "+dp.localidad.provincia.nombre:" ";
					dire += (dp.localidad != null && dp.localidad.provincia!= null && dp.localidad.provincia.pais!= null)?" - "+dp.localidad.provincia.pais.nombre:" ";

					context.put("proveedorDireccion", dire);
					context.put("proveedorTelefono", (dp.telefono != null)?dp.telefono:"");
					context.put("proveedorFax", (dp.fax != null)?dp.fax:"");
					context.put("proveedorMail", (dp.email != null)?dp.email:"");
				}else{
					flash("error", "Faltan ingresar datos del proveedor.");
					return ok(modalReporteOrdenProvision.render(null));
				}

				String plazo = "20 días";

				String notas = "* Se informa que vencido el plazo de entrega se procedera a la ANULACION AUTOMATICA de los renglones no entregados, y se dara por cerrada la ORDEN DE PROVISION.<br />";
				if(o.orden_rubro_id != null){
					if(o.orden_rubro_id == 6){
						plazo = "Segun fecha de cirugía programada. A confirmar.";
						notas += "* Se solicita asistencia tecnica obligatoria en quirofano.<br />";
					}
					if(o.orden_rubro_id == 2){
						plazo = "Segun fecha de turno programado. A confirmar.";
						notas = "* Segun certificacion de servicios.<br />";
					}
					if(o.orden_rubro_id == 4){
						notas += "* LA ENTREGA DEBE REALIZARSE EN 2 PERIODOS CORRELATIVOS E IGUALES DE 30 DIAS; O CUANDO EL SERVICIO DE FARMACIA O JEFE DEL SERVICIO LO ESTIME CONVENIENTE, COMENZANDO EL MISMO A LA FECHA DE LA ORDEN DE PROVISION. (DICHA ENTREGAS NO SON EXCLUYENTES, Y PUEDEN SER MODIFICADAS DE ACUERDO A LAS NECESIDADES Y URGENCIAS QUE SE PRESENTEN).<br />";
						notas += "* PARA EL CASO DE LOS MEDICAMENTOS Y DESCARTABLES DEBEN ESTAR EN PERFECTAS CONDICIONES DE PRESENTACION Y EMBALAJE.<br />";
						notas += "* EL VENCIMIENTO DE LOS MEDICAMENTOS Y DESCARTABLES DEBEN SER MAYOR A 1 AÑO.<br />";
						notas += "* RESPETAR LAS MARCAS COTIZADAS Y SUGERIDAS POR EL SERVICIO DE FARMACIA.<br />";
						notas += "* NO SE RECIBIRAN MEDICAMENTOS, DESCARTABLES E INSUMOS QUE NO POSEAN AUTORIZACION VIGENTE A LA FECHA DE ENTREGA DE LA A.T.M.A.T.<br />";
					}

					if(o.tipo_moneda != null) {
						notas = "* Se considerará que al momento del pago se tomará el tipo de cambio vendedor del Banco Nación Argentina a la fecha del cierre de las operaciones del día anterior a la fecha de autorización al pago.<br/>";
					}
				}
				context.put("notas", notas);
				if(o.plazo_entrega != null && !o.plazo_entrega.isEmpty()){
					plazo = o.plazo_entrega;
				}

				context.put("plazoEntrega", plazo);

				String direccionEntrega = "Av. Marconi 3736 - Posadas Misiones";
				if(o.deposito.direccion != null){
					direccionEntrega = o.deposito.direccion;
				}
				context.put("direccionEntrega", direccionEntrega);


				String textoDolar =(o.cot_dolar != null && o.cot_dolar.compareTo(BigDecimal.ZERO) > 0)?"EQUIVALENTE A DOLARES ESTADOUNIDENSES  "+utils.NumberUtils.moneda(o.getTotalDolar(), true)+". TIPO DE CAMBIO VENDEDOR BANCO NACION USD 1 = "+utils.NumberUtils.moneda(o.cot_dolar)+".":"";
				context.put("textoDolar", textoDolar);

				String totalLetras = new NumeroALetra().convertNumberToLetterSinPesos(o.total.setScale(2, RoundingMode.HALF_DOWN).toString());
				//String totalLetras = new NumeroALetra().convertNumberToLetterSinPesos("14999040");


				context.put("totalLetras", totalLetras);

				//List<OrdenLinea> lineas = o.ordenLinea;

				List<OrdenLinea> lineas = OrdenLinea.find.where().eq("orden_id", o.id).orderBy("producto.nombre ASC").findList();
				int sizeLineas = lineas.size();

				//lineas = lineas.subList(0,45);

				if(sizeLineas <= 11){
					//Es decir si tiene menos o igual a 10 lineas hago esto
					context.put("menorContadorLineas",true);
					List<OrdenLinea> firtsLineas = lineas.subList(0, lineas.size());
					context.put("contenedorfirtsLineas", lineas);
				}else{
					//Es decir si tiene mas a 10 lineas hago esto
					context.put("menorContadorLineas",false);
					List<OrdenLinea> firtsLineas = lineas.subList(0, 11);
					context.put("contenedorfirtsLineas", firtsLineas);

					List<OrdenLinea> nextLineas = lineas.subList(11,  lineas.size());
					List<List<OrdenLinea>> contenedorNextLineas = Lists.partition(nextLineas, 20);
					Logger.debug("------------------------------- "+contenedorNextLineas.size());
					context.put("cnl", contenedorNextLineas);
				}

				Integer x= 1;
				List<Map<String,String>> pacientes = new ArrayList<Map<String,String>>();
				for(OrdenLinea lo : lineas ){

					for(OrdenLineaCliente oc :lo.ordenLineaCliente){
						Map<String,String> hs = new HashMap<String,String>();
						//Logger.debug("aaaaaaaaaa"+oc.cliente.nombre);
						hs.put("nLinea",x.toString());
						String ob = (oc.observacion != null)?oc.observacion:"";
						hs.put("obse",ob);
						hs.put("cantidad",oc.cantidad.toString());
						hs.put("nombre",oc.cliente.nombre);
						String refe = (oc.cliente.id_paciente_rismi == null)?(oc.cliente.referencia == null)?"":oc.cliente.referencia:oc.cliente.id_paciente_rismi;
						hs.put("referencia",refe);
						hs.put("producto",lo.producto.nombre);
						pacientes.add(hs);
					}
					x++;
				}

				context.put("pacientes", pacientes);


			}else{
				flash("error", "No se encuentra la orden de provision.");
				return ok(modalReporteOrdenProvision.render(null));
			}


			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);

		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte.");
			return ok(modalReporteOrdenProvision.render(null));
		}

		return ok(modalReporteOrdenProvision.render(archivo.getPath()));
	}*/

	public static Result reporteAnulados(Long idOrdenProvision) {

		if(idOrdenProvision == null){
			flash("error", "Debe seleccionar una orden de provision.");
		 	return ok(modalReporteOrdenProvision.render(null));
		}


		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_anulados.xls");

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

			Sheet hoja = libro.createSheet("Informe Inventariables");

			OrdenProvision o = OrdenProvision.find.byId(idOrdenProvision);

			List<Integer> lineasAnulacioneSeleccionadosSeleccionados = getSeleccionadosLineasAnulaciones();
			if(lineasAnulacioneSeleccionadosSeleccionados.isEmpty()) {
				flash("error", "Debe seleccionar las lineas.");
				return ok(modalReporteOrdenProvision.render(null));
			}

			List<OrdenLineaAnulacion> ox = OrdenLineaAnulacion.find.where()
										   .eq("ordenLinea.orden_id", o.orden_compra_id)
										   .in("id",lineasAnulacioneSeleccionadosSeleccionados)
										   .findList();


			int x = 0;

				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("PRODUCTOS ANULADOS");
				celda0.setCellStyle(comun);
				x++;

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Producto");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Cant.");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Precio");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Total");
				celda0.setCellStyle(comun);
				x++;

				for(OrdenLineaAnulacion oli : ox){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(oli.ordenLinea.producto.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(oli.cantidad.toString());
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(oli.ordenLinea.precio.doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(3);
					celda0.setCellValue(oli.cantidad.multiply(oli.ordenLinea.precio).doubleValue());
					celda0.setCellStyle(estiloMoneda);

					x++;
				}

			x++;



			libro.write(archivoTmp);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(modalReporteOrdenProvision.render(archivo.getPath()));
	}

	public static Result notaCierre(Long idOrdenProvision,Integer n) {

		if(idOrdenProvision == null){
			flash("error", "Debe seleccionar una orden de provision.");
		 	return ok(modalReporteOrdenProvision.render(null));
		}


		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/nota-cierre.odt");

		try {

			InputStream in = null;

			Logger.debug("ppppppppppppppppp- "+n.compareTo(1));

			if(n.compareTo(1) == 0) {
				in = Play.application().resourceAsStream("resources/reportes/patrimonio/ordenesProvision/nota-cierre.odt");

			}else {
				in = Play.application().resourceAsStream("resources/reportes/patrimonio/ordenesProvision/nota-cierre-2.odt");
			}

			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			metadata.addFieldAsTextStyling("notas", SyntaxKind.Html);
			IContext context = report.createContext();

			//Orden o = Orden.find.byId(idOrdenProvision);

			OrdenProvision o = OrdenProvision.find.byId(idOrdenProvision);

			if(o != null){
				context.put("math", new MathTool());
				context.put("numberUtils", new NumberUtils());
				context.put("expediente", o.ordenCompra.expediente.getExpedienteEjercicio());
				context.put("numeroOP",(o.getOpEjercicio() != null)?o.getOpEjercicio(): "");
				context.put("proveedor",o.ordenCompra.proveedor.nombre);


				String fc = "";
				if(o.fcierre != null){

					fc = "a los "+DateUtils.formatDate(o.fcierre,"dd")+" días del mes "+DateUtils.getMesLetras(new Integer(DateUtils.formatDate(o.fcierre,"MM"))-1);
				}

				context.put("fcierre", fc);

				if(o.ordenCompra.tipo_orden.compareToIgnoreCase("comun") == 0){
					List<Integer> lineasAnulacioneSeleccionadosSeleccionados = getSeleccionadosLineasAnulaciones();
					if(lineasAnulacioneSeleccionadosSeleccionados.isEmpty()) {
						flash("error", "Debe seleccionar las lineas.");
						return ok(modalReporteOrdenProvision.render(null));
					}

					List<OrdenLineaAnulacion> ox = OrdenLineaAnulacion.find.where()
												   .eq("ordenLinea.orden_id", o.orden_compra_id)
												   .in("id",lineasAnulacioneSeleccionadosSeleccionados)
												   .findList();
					context.put("anulados", ox);
					context.put("size", (ox.size() > 0)?"true":"");
					context.put("sizex","");
				}else{
					List<CertificacionServicio> ox = CertificacionServicio.find.where().eq("orden_provision_id", idOrdenProvision).eq("estado_id",Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA).findList();
					List<CertificacionServicioLinea> csl = new ArrayList<CertificacionServicioLinea>();
					for(CertificacionServicio cs : ox){
						for(CertificacionServicioLinea csx : cs.certificacionesServicioLinea){
							csl.add(csx);
						}
					}
					context.put("size","");
					context.put("anuladosc", csl);
					context.put("sizex", (csl.size() > 0)?"true":"");
				}


			}else{
				flash("error", "No se encuentra la nota de cierre.");
				return ok(modalReporteOrdenProvision.render(null));
			}


			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);

		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte.");
			return ok(modalReporteOrdenProvision.render(null));
		}

		return ok(modalReporteOrdenProvision.render(archivo.getPath()));
	}

	public static List<Integer> getSeleccionadosLineasAnulaciones(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_linea_anulacion[]");
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
