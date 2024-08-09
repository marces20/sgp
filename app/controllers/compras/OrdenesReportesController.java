package controllers.compras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import models.CertificacionCompra;
import models.Estado;
import models.Orden;
import models.OrdenLinea;
import models.OrdenLineaCliente;
import models.UltimaCotizacion;
import models.informes.InformeDeudaProveedoresMaterializada;
import models.informes.InformeEstadisticoDeudaProveedores;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.util.IOUtils;

import play.Logger;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.StringUtils;
import views.html.compras.ordenes.reportes.resultadoCuadroComparativoPrecios;
import views.html.compras.certificaciones.modales.modalReporteCertificacion;
import views.html.compras.ordenes.modales.modalReporteImputacionDefinitiva;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

@Security.Authenticated(Secured.class)
public class OrdenesReportesController extends Controller {

	public static Result reporteCertificacionPaciente(Long id) throws IOException {

		if(id == null){
			flash("error", "Debe seleccionar una orden.");
		 	return ok(modalReporteImputacionDefinitiva.render(null));
		}

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/certificacion_pacientes.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/ordenes/certificacion_pacientes.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();

		      Orden c = Orden.find.byId(id);

		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Nombre");
		      metadata.addFieldAsList("listado.Dni");
		      metadata.addFieldAsList("listado.IdRismi");
		      metadata.addFieldAsList("listado.Cantidad");
		      metadata.addFieldAsList("listado.Producto");

		      report.setFieldsMetadata(metadata);

		      context.put("expediente",c.expediente.getInstitucionExpedienteEjercicio());
		      context.put("proveedor",c.proveedor.nombre);
		      //context.put("ultimodia", DateUtils.getLastDayOfMonth(c.periodo.date_start));
		      //context.put("mes", DateUtils.getMesLetras(c.periodo.date_start.getMonth()));

		      //SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
		      //String anio = format1.format(c.periodo.date_start);
			  //context.put("anio", anio);
		      List<Map<String,String>> listado = new ArrayList<Map<String,String>>();


		      for(OrdenLinea ol : c.ordenLinea) {

		    	  for(OrdenLineaCliente olc: ol.ordenLineaCliente) {
		    		Map<String,String> d = new HashMap<String, String>();
		    		d.put("Nombre", olc.cliente.nombre);
		    	  	d.put("Dni", (olc.cliente.dni != null)?"DNI:"+olc.cliente.dni.toString():"");
		    	  	d.put("IdRismi", (olc.cliente.id_paciente_rismi != null)?"ID:"+olc.cliente.id_paciente_rismi:"");
		    	  	d.put("Cantidad", olc.cantidad.toString());
		    	  	d.put("Producto",ol.producto.nombre);
		    	  	listado.add(d);
		    	  }
		      }


		      context.put("listado", listado);

		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		      flash("success", "El archivo fue creado correctamente.");
			  return ok(modalReporteImputacionDefinitiva.render(archivo.getPath()));
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }

		 	flash("Error", "No se puedo crear el archivo.");
		 	return ok(modalReporteImputacionDefinitiva.render(null));
	}

	public static Result controlDolar() {

		List<Integer> ordenesSeleccionadas = getSeleccionados();

		if(ordenesSeleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado órdenes.");
			return ok(resultadoCuadroComparativoPrecios.render(null));
		}

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/lineas.xls");

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
			//estiloMoneda.setDataFormat(HSSFDataFormat.getBuiltinFormat("#.##0,00 [$USD]"));
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);

			Sheet hoja = libro.createSheet("lineas");

			//List<Orden> o = Orden.find.where().in("id", ordenesSeleccionadas).order("id asc").findList();

			List<InformeDeudaProveedoresMaterializada> o = InformeDeudaProveedoresMaterializada.find.where().in("orden_id", ordenesSeleccionadas).order("id asc").findList();

			if(o.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("PROVEEDOR");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("INSTITUCION");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("EXPEDIENTE");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(3);
				celda0.setCellValue("MONEDA");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(4);
				celda0.setCellValue("TOTAL ORDEN");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("COTIZACION ORDEN");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("MONTO DOLAR ORDEN");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue("TOTAL OBLIGACION");
				celda0.setCellStyle(comun);
				x++;
				for(InformeDeudaProveedoresMaterializada oll : o){
					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(oll.proveedor.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(oll.deposito.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(oll.expediente);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue(oll.moneda);
					celda0.setCellStyle(comun);

					Orden ox = Orden.find.byId(oll.orden_id);

					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(ox.getTotalTotalSinDiferenciaCotizacion().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.cotizacion.doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(6);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(ox.getTotalTotalSinDiferenciaCotizacion().divide(oll.cotizacion, 2, RoundingMode.HALF_UP).doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(7);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue((oll.totalActas != null)?oll.totalActas.doubleValue():0);
					celda0.setCellStyle(estiloMoneda);

					x++;

					String sql = "SELECT * FROM vista_pagos_totales_con_dolar where orden_id = :orderId";
					List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("orderId", oll.orden_id).findList();



					BigDecimal totalPagos = new BigDecimal(0);
					BigDecimal totalPagosDolar = new BigDecimal(0);

					if(s.size() > 0){
						fila = hoja.createRow(x);
						celda0 = fila.createCell(3);
						celda0.setCellValue("PAGOS");
						celda0.setCellStyle(comun);
						boolean primero = true;
						for(SqlRow sx :s){

							if(!primero){
								fila = hoja.createRow(x);
							}

							celda0 = fila.createCell(4);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(sx.getBigDecimal("total").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							totalPagos = totalPagos.add(sx.getBigDecimal("total"));

							celda0 = fila.createCell(5);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(sx.getBigDecimal("cot_dolar_autorizado").doubleValue());
							celda0.setCellStyle(estiloMoneda);

							celda0 = fila.createCell(6);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(sx.getBigDecimal("total_dolar").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							totalPagosDolar = totalPagosDolar.add(sx.getBigDecimal("total_dolar"));
							primero = false;
							x++;
						}

						fila = hoja.createRow(x);
						celda0 = fila.createCell(3);
						celda0.setCellValue("TOTAL PAGOS");

						celda0.setCellStyle(comun);
						celda0 = fila.createCell(4);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(totalPagos.doubleValue());
						celda0.setCellStyle(estiloMoneda);


						celda0 = fila.createCell(5);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue("");
						celda0.setCellStyle(estiloMoneda);

						celda0 = fila.createCell(6);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(totalPagosDolar.doubleValue());
						celda0.setCellStyle(estiloMoneda);


						x++;
					}
					fila = hoja.createRow(x);
					celda0 = fila.createCell(3);
					celda0.setCellValue("TOTAL DEUDA");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(ox.getTotalTotal().subtract(totalPagos).doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue("");
					celda0.setCellStyle(estiloMoneda);

					celda0.setCellStyle(comun);
					celda0 = fila.createCell(6);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(ox.getTotalTotalSinDiferenciaCotizacion().divide(oll.cotizacion, 2, RoundingMode.HALF_UP).subtract(totalPagosDolar).doubleValue());
					celda0.setCellStyle(estiloMoneda);


					x++;x++;
				}

			}

			libro.write(archivoTmp);
			flash("success", "El archivo fue creado correctamente.");
			return ok(resultadoCuadroComparativoPrecios.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(resultadoCuadroComparativoPrecios.render(null));

	}

	public static Result controlProfe(Long id) {

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/controlProfe.xls");

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

			Sheet hoja = libro.createSheet("lineas");

			String sql = "select to_char(e.fecha,'dd/MM/YYYY') AS fecha,e.nombre||'/'||ej.nombre as expediente,"+
					"p.nombre as producto,c.nombre as paciente,ca.nombre as cuenta_presupuestaria,"+
					"olc.cantidad as cantidad,ol.precio as precio,tc.nombre as cuenta,ou.nombre as rubro "+
					"from ordenes o "+
					"inner join expedientes e on e.id = o.expediente_id "+
					"inner join ejercicios ej on e.ejercicio_id = ej.id "+
					"inner join orden_lineas ol on ol.orden_id = o.id "+
					"inner join orden_linea_clientes olc on olc.orden_linea_id = ol.id "+
					"inner join clientes c on c.id = olc.cliente_id "+
					"inner join productos p on p.id = ol.producto_id "+
					"inner join cuentas_analiticas ca on ca.id = ol.cuenta_analitica_id "+
					"inner join ordenes_rubros ou on ou.id = o.orden_rubro_id "+
					"inner join tipo_cuenta tc on tc.id = o.tipo_cuenta_id "+
					"where o.state_id = 11 and c.obrasocial_id = 442 and ej.id = :id "+
					"order by e.nombre ";

			SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
			sqlQuery.setParameter("id",id);
			List<SqlRow>  row = sqlQuery.findList();



			if(row.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				fila = hoja.createRow(x);
 				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("FECHA");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("EXPEDIENTE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("PRODUCTO");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("PACIENTE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("CUENTA PRESUPUESTARIA");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("CUENTA");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("RUBRO");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue("CANTIDAD");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(8);
				celda0.setCellValue("PRECIO");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(9);
				celda0.setCellValue("TOTAL");
				celda0.setCellStyle(comun);

				x++;
				for(SqlRow oll : row){
					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(oll.getString("fecha"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(oll.getString("expediente"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(oll.getString("producto"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue(oll.getString("paciente"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue(oll.getString("cuenta_presupuestaria"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(5);
					celda0.setCellValue(oll.getString("cuenta"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(6);
					celda0.setCellValue(oll.getString("rubro"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(7);
					celda0.setCellValue(oll.getDouble("cantidad"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(8);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getBigDecimal("precio").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(9);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getBigDecimal("precio").multiply(oll.getBigDecimal("cantidad")).doubleValue());
					celda0.setCellStyle(estiloMoneda);

					x++;
				}

			}

			libro.write(archivoTmp);
			flash("success", "El archivo fue creado correctamente.");
			return ok(resultadoCuadroComparativoPrecios.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(resultadoCuadroComparativoPrecios.render(null));

	}

	public static Result exportacionDatos() {

		List<Integer> ordenesSeleccionadas = getSeleccionados();

		if(ordenesSeleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado órdenes.");
			return ok(resultadoCuadroComparativoPrecios.render(null));
		}

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/lineas.xls");

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

			Sheet hoja = libro.createSheet("lineas");

			List<Orden> o = Orden.find.where().in("id", ordenesSeleccionadas).order("id asc").findList();

			if(o.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("PROVEEDOR");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("INSTITUCION");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("EXPEDIENTE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("PERIODO");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("MONTO BASE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("AJUSTE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("MONTO TOTAL");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue("MONEDA");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(8);
				celda0.setCellValue("COTIZACION");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(9);
				celda0.setCellValue("MONTO MONEDA EXTRAJERA");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(10);
				celda0.setCellValue("RUBRO");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(11);
				celda0.setCellValue("TAPA EXP.");
				celda0.setCellStyle(comun);
				x++;
				for(Orden oll : o){
					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(oll.proveedor.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(oll.deposito.nombre);
					celda0.setCellStyle(comun);


					celda0 = fila.createCell(2);
					celda0.setCellValue(oll.expediente.getExpedienteEjercicio());
					celda0.setCellStyle(comun);

					String fecha_inicio = (oll.fecha_inicio != null)?utils.DateUtils.formatDate(oll.fecha_inicio):"";
					String fecha_fin = (oll.fecha_fin != null)?utils.DateUtils.formatDate(oll.fecha_fin):"";
					String periodo = (oll.periodo != null)?oll.periodo.nombre:fecha_inicio+"-"+fecha_fin;

					celda0 = fila.createCell(3);
					celda0.setCellValue(periodo);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getTotal().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getTotalAjuste().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(6);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getTotalTotal().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(7);
					celda0.setCellValue((oll.tipo_moneda != null)?UltimaCotizacion.getMoneda(oll.tipo_moneda):"");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(8);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue((oll.tipo_moneda != null && oll.cot_dolar != null)?oll.cot_dolar.doubleValue():0);
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(9);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue((oll.tipo_moneda != null)?oll.getTotalDolar() .doubleValue():0);
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(10);
					celda0.setCellValue((oll.orden_rubro_id != null)?oll.ordenRubro.nombre:"");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(11);
					celda0.setCellValue(oll.expediente.descripcion);
					celda0.setCellStyle(comun);

					x++;
				}

			}

			libro.write(archivoTmp);
			flash("success", "El archivo fue creado correctamente.");
			return ok(resultadoCuadroComparativoPrecios.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(resultadoCuadroComparativoPrecios.render(null));

	}

	public static Result exportacionDatosAuditoria() {

		List<Integer> ordenesSeleccionadas = getSeleccionados();

		if(ordenesSeleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado órdenes.dd");
			return ok(resultadoCuadroComparativoPrecios.render(null));
		}

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/lineas.xls");

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

			Sheet hoja = libro.createSheet("lineas");

			List<Orden> o = Orden.find.select("id,fecha_inicio,fecha_inicio,total,totalAjuste,")
							.fetch("proveedor","nombre")
							.fetch("deposito","nombre")
							.fetch("expediente", "nombre, id, emergencia")
			    			.fetch("expediente.ejercicio", "nombre")
			    			.fetch("periodo", "nombre")
							.where().in("id", ordenesSeleccionadas).order("id asc").findList();

			if(o.size() > 0){
				int x = 0;
				Row fila;
				Cell celda0;
				fila = hoja.createRow(x);


				celda0 = fila.createCell(0);
				celda0.setCellValue("Referencia");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Fecha");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Proveedor");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Provisión");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Institucion");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Rubro");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("SubRubro");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue("Expediente");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(8);
				celda0.setCellValue("Base");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(9);
				celda0.setCellValue("Ajuste");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(10);
				celda0.setCellValue("Total");
				celda0.setCellStyle(comun);

				x++;

				for(Orden oll : o){

					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(oll.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(utils.DateUtils.formatDate(oll.fecha_orden));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(oll.proveedor.nombre);
					celda0.setCellStyle(comun);


					celda0 = fila.createCell(3);
					celda0.setCellValue((oll.numero_orden_provision != null)?oll.numero_orden_provision:0);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue((oll.deposito != null)?oll.deposito.nombre:"");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(5);
					celda0.setCellValue((oll.ordenRubro != null)?oll.ordenRubro.nombre:"");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(6);
					celda0.setCellValue((oll.ordenSubrubro != null)?oll.ordenSubrubro.sigla:"");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(7);
					celda0.setCellValue(oll.expediente.getExpedienteEjercicio());
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(8);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getTotal().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(9);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getTotalAjuste().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(10);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getTotalTotal().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					x++;

				}

			}

			libro.write(archivoTmp);
			flash("success", "El archivo fue creado correctamente.");
			return ok(resultadoCuadroComparativoPrecios.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(resultadoCuadroComparativoPrecios.render(null));

	}

	public static Result exportacionDatosConLineas() {

		List<Integer> ordenesSeleccionadas = getSeleccionados();

		if(ordenesSeleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado órdenes.");
			return ok(resultadoCuadroComparativoPrecios.render(null));
		}

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/lineas.xls");

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

			Sheet hoja = libro.createSheet("lineas");

			List<Orden> o = Orden.find.select("id,fecha_inicio,fecha_inicio,total,totalAjuste,")
							.fetch("proveedor","nombre")
							.fetch("deposito","nombre")
							.fetch("expediente", "nombre, id, emergencia")
			    			.fetch("expediente.ejercicio", "nombre")
			    			.fetch("periodo", "nombre")
							.fetch("ordenLinea")
							.fetch("ordenLinea.producto","nombre")
							.fetch("ordenLinea.cuentaAnalitica","codigo,nombre")
							.fetch("ordenLinea.departamento","nombre")
							.fetch("ordenLinea.udm","nombre")
							.fetch("ordenLinea.ordenLineaCliente.cliente","id,orden_linea_id,nombre,id_paciente_rismi")

							.where().in("id", ordenesSeleccionadas).order("id asc").findList();

			if(o.size() > 0){
				int x = 0;
				Row fila;
				Cell celda0;
				for(Orden oll : o){

					fila = hoja.createRow(x);
					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue("PROVEEDOR");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue("INSTITUCION");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(2);
					celda0.setCellValue("EXPEDIENTE");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(3);
					celda0.setCellValue("PERIODO");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(4);
					celda0.setCellValue("MONTO BASE");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(5);
					celda0.setCellValue("AJUSTE");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(6);
					celda0.setCellValue("MONTO TOTAL");
					celda0.setCellStyle(comun);
					x++;

					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(oll.proveedor.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(oll.deposito.nombre);
					celda0.setCellStyle(comun);


					celda0 = fila.createCell(2);
					celda0.setCellValue(oll.expediente.getExpedienteEjercicio());
					celda0.setCellStyle(comun);

					String fecha_inicio = (oll.fecha_inicio != null)?utils.DateUtils.formatDate(oll.fecha_inicio):"";
					String fecha_fin = (oll.fecha_fin != null)?utils.DateUtils.formatDate(oll.fecha_fin):"";
					String periodo = (oll.periodo != null)?oll.periodo.nombre:fecha_inicio+"-"+fecha_fin;

					celda0 = fila.createCell(3);
					celda0.setCellValue(periodo);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getTotal().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getTotalAjuste().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(6);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.getTotalTotal().doubleValue());
					celda0.setCellStyle(estiloMoneda);

					x++;


					//List<OrdenLinea> ol = OrdenLinea.find.where().eq("orden_id", oll.id).order("id asc").findList();

					if(oll.lineas.size() > 0){
						fila = hoja.createRow(x);

						celda0 = fila.createCell(0);
						celda0.setCellValue("descr");
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(1);
						celda0.setCellValue("cant");
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(2);
						celda0.setCellValue("cuenta analitica");
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(3);
						celda0.setCellValue("udm");
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(4);
						celda0.setCellValue("precio");
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(5);
						celda0.setCellValue("servicio");
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(6);
						celda0.setCellValue("pacientes");
						celda0.setCellStyle(comun);
						x++;


						for(OrdenLinea ollx : oll.lineas){
							fila = hoja.createRow(x);

							celda0 = fila.createCell(0);
							celda0.setCellValue(ollx.producto.nombre);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(1);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(ollx.cantidad.doubleValue());
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(2);
							celda0.setCellValue(ollx.cuentaAnalitica.codigo);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(3);
							celda0.setCellValue(ollx.udm.nombre);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(4);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(ollx.precio.doubleValue());
							celda0.setCellStyle(estiloMoneda);

							celda0 = fila.createCell(5);
							celda0.setCellValue(ollx.departamento.nombre);
							celda0.setCellStyle(comun);

							String pacientes = "";

							if(ollx.ordenLineaCliente != null && ollx.ordenLineaCliente.size() > 0){
								for(OrdenLineaCliente olp : ollx.ordenLineaCliente) {
									pacientes += olp.cliente.nombre.toUpperCase()+" - ID:"+olp.cliente.id_paciente_rismi+" | ";
								}
							}

							celda0 = fila.createCell(6);
							celda0.setCellValue(pacientes);
							celda0.setCellStyle(comun);

							x++;
						}
					}
					x++;
				}

			}

			libro.write(archivoTmp);
			flash("success", "El archivo fue creado correctamente.");
			return ok(resultadoCuadroComparativoPrecios.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(resultadoCuadroComparativoPrecios.render(null));

	}

	@CheckPermiso(key = "ordenesCompraCuadroComparativo")
	public static Result cuadroComparativoPrecios() {

		List<Integer> ordenesSeleccionadas = getSeleccionados();

		if(ordenesSeleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado órdenes.");
			return ok(resultadoCuadroComparativoPrecios.render(null));
		}

		if(!(ordenesSeleccionadas.size() > 1)) {
			flash("error", "Debe seleccionar 2 o más órdenes para generar el cuadro comparativo.");
			return ok(resultadoCuadroComparativoPrecios.render(null));
		}

		//List<SqlRow> detalleProductos = Ebean.createSqlQuery("SELECT p.id id, p.nombre nombre, ol.cantidad cantidad FROM orden_lineas ol INNER JOIN productos p ON p.id = ol.producto_id WHERE ol.orden_id in (:listId) GROUP BY p.id, ol.cantidad ORDER BY p.nombre").setParameter("listId", ordenesSeleccionadas).findList();

		List<SqlRow> detalleProductos = Ebean.createSqlQuery(""+
		"SELECT p.id id, p.nombre, ol.cantidad cantidad FROM orden_lineas ol "+
		"RIGHT JOIN (SELECT MIN(precio) precio, producto_id FROM orden_lineas ol WHERE orden_id IN(:listId) GROUP BY ol.proveedor_id, producto_id ORDER BY ol.proveedor_id DESC) ol2 "+
		"ON ol.producto_id = ol2.producto_id AND ol.precio = ol2.precio "+
		"INNER JOIN ordenes o ON o.id = ol.orden_id "+
		"INNER JOIN productos p on p.id = ol.producto_id "+
		"WHERE o.id IN(:listId) "+
		"GROUP BY p.id, p.nombre, ol.cantidad " +
		"ORDER BY p.nombre ASC").setParameter("listId", ordenesSeleccionadas).findList();



		List<SqlRow> proveedores = Ebean.createSqlQuery("SELECT p.id id, p.nombre nombre FROM ordenes o INNER JOIN proveedores p ON p.id = o.proveedor_id WHERE o.id in (:listId) GROUP BY p.id  ORDER BY p.nombre DESC").setParameter("listId", ordenesSeleccionadas).findList();



		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";

		Integer inicioLineaCuadro = 10;

		try {
			File archivo = new File(dirTemp+"/comparativo.xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/compras/ordenes/modelo-cuadro-comparativo.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);


		    Cell cell;
		    CellStyle estilo = libro.createCellStyle();
		    estilo.setBorderRight(CellStyle.BORDER_THIN);
		    estilo.setBorderLeft(CellStyle.BORDER_THIN);
		    estilo.setBorderTop(CellStyle.BORDER_THIN);
		    estilo.setBorderBottom(CellStyle.BORDER_THIN);
		    estilo.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		    Font font = libro.createFont();
	        font.setFontHeightInPoints((short) 12);
	        estilo.setFont(font);


			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
		    Font font2 = libro.createFont();
	        font2.setFontHeightInPoints((short) 12);
	        estiloMoneda.setFont(font2);


			CellStyle estiloLineasDetalle = libro.createCellStyle();
			estiloLineasDetalle.setBorderBottom(CellStyle.BORDER_THIN);
			Cell celda;

			Integer reg = 1;
			Integer lineaAux = inicioLineaCuadro;
			List<Integer> idsProductos = new ArrayList<Integer>();
			for (SqlRow sr : detalleProductos) {
				Row f = hoja.createRow(++lineaAux);
				celda = f.createCell(0);
				celda.setCellValue(reg++);
				celda.setCellStyle(estilo);
				celda = f.createCell(1);
				celda.setCellValue(sr.getString("nombre"));
				celda.setCellStyle(estilo);

				celda = f.createCell(2);
				//celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(sr.getDouble("cantidad"));
				celda.setCellStyle(estilo);

				idsProductos.add( sr.getInteger("id") );
			}

	        CellStyle estiloTotales = libro.createCellStyle();
	        estiloTotales.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        estiloTotales.setAlignment(CellStyle.ALIGN_CENTER);
	        estiloTotales.setBorderRight(CellStyle.BORDER_THIN);
	        estiloTotales.setBorderLeft(CellStyle.BORDER_THIN);
	        estiloTotales.setBorderTop(CellStyle.BORDER_THIN);
	        estiloTotales.setBorderBottom(CellStyle.BORDER_THIN);
		    Font fontNegrita = libro.createFont();
		    fontNegrita.setFontHeightInPoints((short) 12);
		    fontNegrita.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

	        estiloTotales.setFont(fontNegrita);

	        CellStyle estiloTotalesMoneda = libro.createCellStyle();
	        estiloTotalesMoneda.setDataFormat((short) 7);
	        estiloTotalesMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        estiloTotalesMoneda.setAlignment(CellStyle.ALIGN_RIGHT);
	        estiloTotalesMoneda.setBorderRight(CellStyle.BORDER_THIN);
	        estiloTotalesMoneda.setBorderLeft(CellStyle.BORDER_THIN);
	        estiloTotalesMoneda.setBorderTop(CellStyle.BORDER_THIN);
	        estiloTotalesMoneda.setBorderBottom(CellStyle.BORDER_THIN);
	        estiloTotalesMoneda.setFont(fontNegrita);

			//Muestro los subtotales
			Row f = hoja.createRow(++lineaAux);
			f.setHeightInPoints((short) 31);
			Cell tb = f.createCell(0);
			tb.setCellStyle(estilo);
			Cell sub = f.createCell(1);
			sub.setCellValue("SUBTOTALES");
			sub.setCellStyle(estiloTotales);
			Cell subc = f.createCell(2);
			subc.setCellStyle(estiloTotales);

			Row filaProveedores = hoja.getRow(inicioLineaCuadro - 1);
			Integer celdaProveedor = 3;

			Integer i = 1;
			for (SqlRow sr : proveedores) {

				filaProveedores.getCell(celdaProveedor).setCellValue(sr.getString("nombre"));


				String sqlCantidades = " select p.id, p.nombre, SUM(o.cantidad) cantidad, precio from productos p " +
					" left join (  " +
					" 	select o.id, ol.producto_id producto_id, sum(cantidad) cantidad, precio " +
					"	from ordenes o " +
					"	inner join orden_lineas ol on o.id = ol.orden_id " +
					"	where o.proveedor_id = "+sr.getString("id")+"  AND o.id in("+ StringUtils.implode(ordenesSeleccionadas) +") " +
					"	group by o.id, ol.id, producto_id " +
					" ) o on o.producto_id = p.id  " +
					" where p.id in ("+ StringUtils.implode(idsProductos) +")  " +
					" GROUP BY p.id, precio " +
					" ORDER BY p.nombre";


				/*
				String sqlCantidades = "SELECT SUM(ol.cantidad) cantidad, ol.precio FROM orden_lineas ol "+
				"INNER JOIN (SELECT MIN(precio) precio, producto_id FROM orden_lineas ol INNER JOIN ordenes o ON o.id = ol.orden_id WHERE o.proveedor_id = "+sr.getString("id")+"  AND o.id in("+ StringUtils.implode(ordenesSeleccionadas) +") GROUP BY ol.proveedor_id, producto_id ORDER BY ol.proveedor_id DESC) ol2 "+
				"ON ol.producto_id = ol2.producto_id AND ol.precio = ol2.precio  "+
				"INNER JOIN ordenes as o ON o.id = ol.orden_id  "+
				"INNER JOIN productos p on p.id = ol.producto_id  "+
				"WHERE o.proveedor_id = "+sr.getString("id")+"  AND o.id in("+ StringUtils.implode(ordenesSeleccionadas) +") "+
				"GROUP BY ol.precio, o.proveedor_id, p.nombre "+
				"ORDER BY o.proveedor_id, p.nombre ASC";
				*/


				List<SqlRow> cantidades = Ebean.createSqlQuery(sqlCantidades).findList();


				Integer celdaCantidades = inicioLineaCuadro;


				Double total = (double) 0;
				for (SqlRow cantidad : cantidades) {
					if(cantidad.getInteger("id") == 10394) {
						System.out.println("Precio --------------- " + cantidad.getDouble("precio"));
					}
					Row ff = hoja.getRow(celdaCantidades + 1);
					ff.setHeightInPoints((short) 25);

					/*Parche cantidad */

					celda = ff.createCell(2);

					if(cantidad.getString("cantidad") != null) {
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda.setCellValue(cantidad.getDouble("cantidad"));
					} else {
						celda.setCellType(Cell.CELL_TYPE_BLANK);
					}
					celda.setCellStyle(estilo);

					celda = ff.createCell(celdaProveedor);
					if(cantidad.getString("cantidad") != null) {
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda.setCellValue(cantidad.getDouble("cantidad"));
					} else {
						celda.setCellType(Cell.CELL_TYPE_BLANK);
					}
					celda.setCellStyle(estilo);

					celda = ff.createCell(celdaProveedor + 1);
					if(cantidad.getString("precio") != null) {
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);


						celda.setCellValue(Math.round(cantidad.getDouble("precio") * 100.0) / 100.0);
						celda.setCellStyle(estiloMoneda);
					} else {
						celda.setCellType(Cell.CELL_TYPE_BLANK);
					}

					celda = ff.createCell(celdaProveedor + 2);
					if(cantidad.getString("cantidad") != null) {

						Double t = Math.round( (cantidad.getDouble("precio") * cantidad.getDouble("cantidad")) * 100.0) / 100.0;
						total += t;

						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda.setCellValue(t);
						celda.setCellStyle(estiloMoneda);
					}


					Row ft = hoja.getRow(lineaAux);
					celda = ft.createCell(celdaProveedor);
					celda.setCellStyle(estiloTotalesMoneda);
					celda = ft.createCell(celdaProveedor + 1);
					celda.setCellStyle(estiloTotalesMoneda);
					celda = ft.createCell(celdaProveedor + 2);
					celda.setCellStyle(estiloTotalesMoneda);
					celda.setCellValue(total);

					celdaCantidades++;
				}

				celdaProveedor = celdaProveedor + 3;
			}




			libro.write(archivoTmp);
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(resultadoCuadroComparativoPrecios.render(archivo.getPath()));

		} catch (Exception e) {
				e.printStackTrace();
		}

		return ok(resultadoCuadroComparativoPrecios.render(null));
	}

	@CheckPermiso(key = "ordenesCompraReporteCuadroAdjudicacion")
	public static Result cuadroSugerenciaAdjudicación() {

		List<Integer> ordenesSeleccionadas = getSeleccionados();

		//Recupero la lista de productos con cantidades de todas las órdenes seleccionadas
		List<SqlRow> listaProductos = Ebean.createSqlQuery("SELECT ol.producto_id, p.nombre, SUM(ol.cantidad) cantidad FROM orden_lineas ol " +
				"INNER JOIN (SELECT MIN(precio) precio, producto_id FROM orden_lineas ol WHERE orden_id IN("+ StringUtils.implode(ordenesSeleccionadas) +") AND ol.precio > 0 GROUP BY producto_id) ol2 " +
				"ON ol.producto_id = ol2.producto_id AND ol.precio = ol2.precio " +
				"INNER JOIN ordenes o ON o.id = ol.orden_id " +
				"INNER JOIN productos p on p.id = ol.producto_id " +
				"WHERE o.id IN("+ StringUtils.implode(ordenesSeleccionadas) +") " +
				"GROUP BY ol.producto_id, p.nombre, o.proveedor_id " +
				"ORDER BY o.proveedor_id, p.nombre ASC").findList();


		//Recupero los proveedores
		List<SqlRow> listaProveedores = Ebean.createSqlQuery("select o.proveedor_id, p.nombre " +
				"from ordenes o " +
				"INNER JOIN proveedores p ON p.id = o.proveedor_id " +
				"WHERE o.id IN("+ StringUtils.implode(ordenesSeleccionadas) +") " +
				"GROUP BY o.proveedor_id, p.nombre order by p.nombre DESC").findList();
		//Recupero el proveedor y el detalle del producto que sea de menor valor
		List<SqlRow> listaDetalles = Ebean.createSqlQuery(
				"SELECT o.proveedor_id, ol.producto_id, ol.precio " +
				"FROM ordenes o " +
				"INNER JOIN orden_lineas ol ON o.id = ol.orden_id " +
				"INNER JOIN (SELECT MIN(precio) precio, producto_id FROM orden_lineas WHERE orden_id IN("+ StringUtils.implode(ordenesSeleccionadas) +") AND precio > 0 GROUP BY producto_id) ol2 ON ol.producto_id = ol2.producto_id AND ol.precio = ol2.precio " +
				"INNER JOIN productos p ON p.id = ol.producto_id  " +
				"WHERE o.id IN("+ StringUtils.implode(ordenesSeleccionadas) +") " +
				"GROUP BY o.proveedor_id, ol.producto_id, ol.precio, p.nombre " +
				"ORDER BY o.proveedor_id, p.nombre, ol.producto_id").findList();
		//Lista de lineas de órdenes que tienen padroctos asignados a un paciente
		/*List<SqlRow> listaDetallesPacientes = Ebean.createSqlQuery(
				"SELECT p.id, p.nombre producto, c.nombre, ol.cliente_id paciente_id  " +
				"FROM orden_lineas ol " +
				"INNER JOIN productos p ON p.id = ol.producto_id " +
				"INNER JOIN clientes c ON c.id = ol.cliente_id " +
				"WHERE ol.orden_id IN("+ StringUtils.implode(ordenesSeleccionadas) +") " +
				"ORDER BY p.nombre").findList();*/
		//saco los pacientes de las lineas
				List<SqlRow> listaDetallesPacientes = Ebean.createSqlQuery("SELECT " +
						"ol.producto_id producto_id, " +
						"c.dni, " +
						"p.nombre producto, " +
						"c.nombre nombre, " +
						"c.id paciente_id, " +
						"c.id_paciente_rismi id_paciente_rismi, " +
						"oc.cantidad cantidad " +
						"FROM ordenes o "+
						"INNER JOIN orden_lineas ol ON o.id = ol.orden_id "+
						"INNER JOIN orden_linea_clientes oc ON ol.id = oc.orden_linea_id "+
						"INNER JOIN productos p ON p.id = ol.producto_id " +
						"INNER JOIN clientes c ON C.id = oc.cliente_id "+
						"WHERE o.id IN ("+ StringUtils.implode(ordenesSeleccionadas) +") "+
						"GROUP BY p.nombre, ol.producto_id,c.nombre,c.id,c.id_paciente_rismi,oc.cantidad ORDER BY p.nombre").findList();

		HashMap<Integer, List<SqlRow>> detalles = new HashMap<>();

		//Cargo los detalles en una lista (la clave es el id de producto)
		for (SqlRow detalle : listaDetalles) {
			Integer idProducto = detalle.getInteger("producto_id");
			if(detalles.containsKey(idProducto)){
				detalles.get(idProducto).add(detalle);
			} else {
				List<SqlRow> productoDeProveedor = new ArrayList<>();
				productoDeProveedor.add(detalle);
				detalles.put(idProducto, productoDeProveedor);
			}
		}

		try {
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/cuadro-adjudicacion.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();

			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/compras/ordenes/modelo-cuadro-adjudicacion.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			hoja.autoSizeColumn((short) 0);

		    CellStyle estilo = libro.createCellStyle();
		    estilo.setBorderRight(CellStyle.BORDER_THIN);
		    estilo.setBorderLeft(CellStyle.BORDER_THIN);
		    estilo.setBorderTop(CellStyle.BORDER_THIN);
		    estilo.setBorderBottom(CellStyle.BORDER_THIN);
		    estilo.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		    Font font = libro.createFont();
	        font.setFontHeightInPoints((short) 12);
	        estilo.setFont(font);


	        CellStyle estiloNegrita = libro.createCellStyle();
	        estiloNegrita.setBorderRight(CellStyle.BORDER_THIN);
	        estiloNegrita.setBorderLeft(CellStyle.BORDER_THIN);
	        estiloNegrita.setBorderTop(CellStyle.BORDER_THIN);
	        estilo.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        estiloNegrita.setBorderBottom(CellStyle.BORDER_THIN);
		    Font fontNegrita = libro.createFont();
		    fontNegrita.setFontHeightInPoints((short) 12);
		    fontNegrita.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        estiloNegrita.setFont(fontNegrita);

	        CellStyle estiloMonedaNegrita = libro.createCellStyle();
	        estiloMonedaNegrita.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        estiloMonedaNegrita.setBorderRight(CellStyle.BORDER_THIN);
	        estiloMonedaNegrita.setBorderLeft(CellStyle.BORDER_THIN);
	        estiloMonedaNegrita.setBorderTop(CellStyle.BORDER_THIN);
	        estiloMonedaNegrita.setBorderBottom(CellStyle.BORDER_THIN);
	        estiloMonedaNegrita.setDataFormat((short) 7);
	        estiloMonedaNegrita.setFont(fontNegrita);


			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
			estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
			estiloMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        estiloMoneda.setFont(font);

			Integer lineaCabecera = 10;
			Cell celdaCabecera;


			//Imprimo los proveedores
			Integer columnaProveedor = 3;
			Row filaCabeceraProveedor = hoja.getRow(lineaCabecera - 1);
			filaCabeceraProveedor.setHeightInPoints((short) 31);
			for (SqlRow proveedor : listaProveedores) {
				celdaCabecera = filaCabeceraProveedor.getCell(columnaProveedor);
				celdaCabecera.setCellValue( proveedor.getString("nombre") );

				columnaProveedor += 3;
			}

		    //para guardar los totales de cada proveedor, clave es id de proveedor
		    HashMap<Integer, Double> totalesProveedor = new HashMap<>();
			Integer inicioCeldaProveedor = 3;
			Integer celdaProveedor = inicioCeldaProveedor;
			Integer lineaAux = lineaCabecera + 1;
			Integer reg = 1;
			for (SqlRow producto : listaProductos) {

				Row f = hoja.createRow(lineaAux++);
				f.setHeightInPoints((short) 25);
				Cell celda = null;
				celda = f.createCell(0);
				celda.setCellValue(reg++);
				celda.setCellStyle(estilo);
				celda = f.createCell(1);
				celda.setCellValue( producto.getString("nombre") );
				celda.setCellStyle(estilo);
				celda = f.createCell(2);
				celda.setCellValue( producto.getDouble("cantidad") );
				celda.setCellStyle(estilo);

				Integer idProducto = producto.getInteger("producto_id");
			    System.out.println(". ID: " + idProducto + " - Cantidad: " + producto.getInteger("cantidad") + " Producto:"  + producto.getString("nombre") );

			    //Recoroo los detalles, si es que tiene
			    if(detalles.containsKey(idProducto)) {

			    	Integer cantProveedores = detalles.get(idProducto).size();
			    	Double subTotal = (double) 0;
				    for (SqlRow detalle : detalles.get(idProducto)) {
				    	celdaProveedor = inicioCeldaProveedor;

				    	//recorro los proveedores
				    	for (SqlRow proveedor : listaProveedores) {


							//Si el proveedor coincide con el proveedor que tiene el detalle
					    	if(detalle.getInteger("proveedor_id").equals(proveedor.getInteger("proveedor_id"))) {
								//Celda cantidad
								Cell celdaCantidad = f.createCell( celdaProveedor );
								celdaCantidad.setCellStyle(estilo);

								//Celda precio
								Cell celdaPrecio = f.createCell(celdaProveedor + 1);
								celdaPrecio.setCellStyle(estiloMoneda);

								//Celda subtotal
								Cell celdaSubtotal = f.createCell(celdaProveedor + 2);
								celdaSubtotal.setCellStyle(estiloMoneda);

					    		//si más de un proveedor tienen mismo precio divido la cantidad
					    		Double cantAsignada = producto.getDouble("cantidad");
					    		if(cantProveedores > 1) {
					    			//cantAsignada = (producto.getDouble("cantidad") / cantProveedores);
					    			cantAsignada = new BigDecimal(producto.getDouble("cantidad") / cantProveedores).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
					    		}

					    		celdaCantidad.setCellValue(cantAsignada);
					    		celdaPrecio.setCellValue( detalle.getDouble("precio") );

					    		Double st = new BigDecimal(detalle.getDouble("precio") * cantAsignada).setScale(2, RoundingMode.HALF_UP).doubleValue();
					    		//st = (detalle.getDouble("precio") * cantAsignada);

					    		//Acumulo los totales
								if(totalesProveedor.containsKey(detalle.getInteger("proveedor_id"))) {
									totalesProveedor.put(detalle.getInteger("proveedor_id"), totalesProveedor.get(detalle.getInteger("proveedor_id")) + st);
								} else {
									totalesProveedor.put(detalle.getInteger("proveedor_id"), st);
								}

					    		subTotal += st;
					    		celdaSubtotal.setCellValue( st );
					    	} else {
					    		//si la celda no contiene valor creamos los bordes
					    		if(f.getCell( celdaProveedor ) == null){
									//Celda cantidad
									Cell celdaCantidad = f.createCell( celdaProveedor );
									celdaCantidad.setCellStyle(estilo);

									//Celda precio
									Cell celdaPrecio = f.createCell(celdaProveedor + 1);
									celdaPrecio.setCellStyle(estilo);

									//Celda subtotal
									Cell celdaSubtotal = f.createCell(celdaProveedor + 2);
									celdaSubtotal.setCellStyle(estilo);
					    		}

					    	}
					    	celdaProveedor = inicioCeldaProveedor + celdaProveedor;
				    	}
				    	System.out.println("..... ID: " + detalle.getString("producto_id") + " proveedor_id: "+ detalle.getString("proveedor_id") + " precio: " + detalle.getString("precio"));
				    }
				    if(detalles.get(idProducto).size() > 1) {
				    	System.out.println("Hay que dividir "+producto.getInteger("cantidad")+" productos entre " + detalles.size() +" proveedores");
				    }
			    }
			}



			//Muestro los subtotales
			Row f = hoja.createRow(lineaAux);
			f.setHeightInPoints((short) 31);
			Cell tb = f.createCell(0);
			tb.setCellStyle(estilo);
			Cell sub = f.createCell(1);
			sub.setCellValue("SUBTOTALES");

	        CellStyle estiloTotales = libro.createCellStyle();
	        estiloTotales.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        estiloTotales.setAlignment(CellStyle.ALIGN_CENTER);
	        estiloTotales.setBorderRight(CellStyle.BORDER_THIN);
	        estiloTotales.setBorderLeft(CellStyle.BORDER_THIN);
	        estiloTotales.setBorderTop(CellStyle.BORDER_THIN);
	        estiloTotales.setBorderBottom(CellStyle.BORDER_THIN);
	        estiloTotales.setFont(fontNegrita);

	        CellStyle estiloTotalesMoneda = libro.createCellStyle();
	        estiloTotalesMoneda.setDataFormat((short) 7);
	        estiloTotalesMoneda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        estiloTotalesMoneda.setAlignment(CellStyle.ALIGN_CENTER);
	        estiloTotalesMoneda.setBorderRight(CellStyle.BORDER_THIN);
	        estiloTotalesMoneda.setBorderLeft(CellStyle.BORDER_THIN);
	        estiloTotalesMoneda.setBorderTop(CellStyle.BORDER_THIN);
	        estiloTotalesMoneda.setBorderBottom(CellStyle.BORDER_THIN);
	        estiloTotalesMoneda.setFont(fontNegrita);

			sub.setCellStyle(estiloTotales);


			Cell b = f.createCell(2);
			b.setCellStyle(estilo);


			celdaProveedor = inicioCeldaProveedor;
			for (SqlRow proveedor : listaProveedores) {
				Cell t = f.createCell(celdaProveedor);
				t.setCellStyle(estilo);
				Cell t2 = f.createCell(celdaProveedor + 1);
				t2.setCellStyle(estilo);
				Cell c = f.createCell(celdaProveedor + 2);
				if(totalesProveedor.containsKey(proveedor.get("proveedor_id"))) {
					c.setCellValue(totalesProveedor.get(proveedor.get("proveedor_id")));

				}
				c.setCellStyle(estiloMonedaNegrita);
				celdaProveedor = inicioCeldaProveedor + celdaProveedor;
			}

			//MUESTRO EL TOTAL
			Row ft = hoja.createRow(++lineaAux);
			ft.setHeightInPoints((short) 31);
			Cell tt = ft.createCell(0);
			tt.setCellStyle(estilo);
			Cell total = ft.createCell(1);
			total.setCellValue("TOTAL");
	        estiloTotales.setFont(fontNegrita);
	        total.setCellStyle(estiloTotales);

			CellRangeAddress crDet = new CellRangeAddress(lineaAux, lineaAux, 2, 2 + (3 * listaProveedores.size()));
			hoja.addMergedRegion( crDet );
			RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, crDet, hoja, libro);
			RegionUtil.setBorderTop(CellStyle.BORDER_THIN, crDet, hoja, libro);
			RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, crDet, hoja, libro);
			RegionUtil.setBorderRight(CellStyle.BORDER_THIN, crDet, hoja, libro);
			Cell celda = ft.createCell(2);
			celda.setCellStyle(estiloTotalesMoneda);

			Double totalGeneral = (double) 0;
			for (Double imp : totalesProveedor.values()) {
				totalGeneral += imp;
			}
			celda.setCellValue(totalGeneral);



			//Muestro los pacientes
			Integer lineaPaciente = lineaAux + 3;
			Row fCabeceraPaciente = hoja.createRow(lineaPaciente);
			celdaCabecera = fCabeceraPaciente.createCell(0);
			celdaCabecera.setCellValue("RENG");
			celdaCabecera.setCellStyle(estiloTotales);


			celdaCabecera = fCabeceraPaciente.createCell(1);
			celdaCabecera.setCellValue("DESCRIPCION");
			celdaCabecera.setCellStyle(estiloTotales);

			CellRangeAddress cr = new CellRangeAddress(lineaPaciente, lineaPaciente, 2, 3);
			RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, cr, hoja, libro);
			RegionUtil.setBorderTop(CellStyle.BORDER_THIN, cr, hoja, libro);
			RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, cr, hoja, libro);
			RegionUtil.setBorderRight(CellStyle.BORDER_THIN, cr, hoja, libro);
			hoja.addMergedRegion( cr );

			celdaCabecera = fCabeceraPaciente.createCell(2);
			celdaCabecera.setCellValue("ID");
			celdaCabecera.setCellStyle(estiloTotales);


			celdaCabecera = fCabeceraPaciente.createCell(4);
			CellRangeAddress crp = new CellRangeAddress(lineaPaciente, lineaPaciente, 4, 7);
			RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, crp, hoja, libro);
			RegionUtil.setBorderTop(CellStyle.BORDER_THIN, crp, hoja, libro);
			RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, crp, hoja, libro);
			RegionUtil.setBorderRight(CellStyle.BORDER_THIN, crp, hoja, libro);
			hoja.addMergedRegion( crp );
			celdaCabecera.setCellValue("Paciente");
			celdaCabecera.setCellStyle(estiloTotales);

			for (SqlRow paciente : listaDetallesPacientes) {
				fCabeceraPaciente = hoja.createRow(++lineaPaciente);
				Cell celdaPaciente = fCabeceraPaciente.createCell(0);

				int i = 0;
				for (SqlRow p : listaProductos) {
					i++;

					if(paciente.getInteger("producto_id").equals(p.getInteger("producto_id"))){
						System.out.println(paciente.getInteger("producto_id") +" ------------ "+ p.getInteger("producto_id"));
						break;
					}
				}
				celdaPaciente.setCellValue(i);


				celdaPaciente.setCellStyle(estilo);

				celdaPaciente = fCabeceraPaciente.createCell(1);
				celdaPaciente.setCellValue(paciente.getString("producto"));
				celdaPaciente.setCellStyle(estilo);

				CellRangeAddress crpp = new CellRangeAddress(lineaPaciente, lineaPaciente, 2, 3);
				RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, crpp, hoja, libro);
				RegionUtil.setBorderTop(CellStyle.BORDER_THIN, crpp, hoja, libro);
				RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, crpp, hoja, libro);
				RegionUtil.setBorderRight(CellStyle.BORDER_THIN, crpp, hoja, libro);
				hoja.addMergedRegion( crpp );

				celdaPaciente = fCabeceraPaciente.createCell(2);
				celdaPaciente.setCellValue(paciente.getString("id_paciente_rismi"));
				celdaPaciente.setCellStyle(estilo);

				celdaPaciente = fCabeceraPaciente.createCell(4);
				celdaPaciente.setCellValue(paciente.getString("nombre"));

				CellRangeAddress crppp = new CellRangeAddress(lineaPaciente, lineaPaciente, 4, 7);
				RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, crppp, hoja, libro);
				RegionUtil.setBorderTop(CellStyle.BORDER_THIN, crppp, hoja, libro);
				RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, crppp, hoja, libro);
				RegionUtil.setBorderRight(CellStyle.BORDER_THIN, crppp, hoja, libro);
				hoja.addMergedRegion( crppp );

			}


			libro.write(archivoTmp);
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(resultadoCuadroComparativoPrecios.render(archivo.getPath()));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	@CheckPermiso(key = "ordenesImputacionDefinitiva")
	public static Result reporteImputacionDefinitiva(Long idOrden) throws IOException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/imputacion_definitiva.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/ordenes/reporteImputacionDefinitiva.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();

		      Orden orden = Orden.find.byId(idOrden);

		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Codigo");
		      metadata.addFieldAsList("listado.Total");

		      report.setFieldsMetadata(metadata);


		      context.put("expediente", orden.expediente.getExpedienteEjercicio());
		      context.put("asunto", orden.expediente.descripcion);

		      List<Integer> lo = new ArrayList<Integer>();
		      lo.add(orden.id.intValue());
		      context.put("listado", getMetadataReporteImputacionDefinitiva(lo));
		      context.put("sePuedeImprimir", (orden.estado_id == Estado.ORDEN_ESTADO_APROBADO || orden.estado_id == Estado.ORDEN_ESTADO_FINALIZADO)?true:false );
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

	@CheckPermiso(key = "ordenesImputacionDefinitiva")
	public static Result reporteImputacionDefinitivaGlobal() throws IOException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/imputacion_definitiva.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/ordenes/reporteImputacionDefinitiva.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();

		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Codigo");
		      metadata.addFieldAsList("listado.Total");

		      report.setFieldsMetadata(metadata);

		      List<Integer> ls = getSeleccionados();
		      Orden orden = Orden.find.byId(ls.get(0).longValue());

		      context.put("expediente", orden.expediente.getExpedienteEjercicio());
		      context.put("asunto", orden.expediente.descripcion);
		      context.put("listado", getMetadataReporteImputacionDefinitiva(ls));
		      context.put("sePuedeImprimir", (orden.estado_id == Estado.ORDEN_ESTADO_APROBADO || orden.estado_id == Estado.ORDEN_ESTADO_FINALIZADO)?true:false );
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }

			return ok(modalReporteImputacionDefinitiva.render(archivo.getPath()));

	}


	private static List<Map<String,String>> getMetadataReporteImputacionDefinitiva(List<Integer> ids){
		List<Map<String,String>> listado = new ArrayList<Map<String,String>>();
		Map<Integer,String> cuentasCodigo =  new HashMap<Integer,String>();

		String sqlAjuste = " SELECT sum(sl.cantidad*sl.precio) total,sl.cuenta_analitica_id cuenta_analitica_id, ca.codigo codigo"
				   + " FROM orden_lineas sl"
				   + " INNER JOIN cuentas_analiticas ca ON ca.id = sl.cuenta_analitica_id "
				   + " WHERE orden_id in( :idsOrden ) "
				   + " GROUP BY sl.cuenta_analitica_id,ca.codigo ";
		List<SqlRow> rowAjuste = Ebean.createSqlQuery(sqlAjuste).setParameter("idsOrden", ids).findList();

		Map<Integer,BigDecimal> hashAjuste = new HashMap<Integer,BigDecimal>();
		String codigoCuenta;

		for(SqlRow s : rowAjuste){
			Integer idCuenta = new Integer(s.get("cuenta_analitica_id").toString());
			BigDecimal total = new BigDecimal(s.get("total").toString());
			codigoCuenta = s.get("codigo").toString();
			hashAjuste.put(idCuenta,total);

			cuentasCodigo.put(idCuenta, codigoCuenta);
		}

		String sql = " SELECT sum(sl.cantidad*sl.precio) total,sl.cuenta_analitica_id cuenta_analitica_id, ca.codigo codigo"
				   + " FROM orden_lineas_ajustes sl"
				   + " INNER JOIN cuentas_analiticas ca ON ca.id = sl.cuenta_analitica_id "
				   + " WHERE orden_id in( :idsOrden ) "
				   + " GROUP BY sl.cuenta_analitica_id,ca.codigo ";

		List<SqlRow> row = Ebean.createSqlQuery(sql).setParameter("idsOrden", ids).findList();

		for(SqlRow s : row){
			Integer idCuenta = new Integer(s.get("cuenta_analitica_id").toString());
			codigoCuenta = s.get("codigo").toString();
			BigDecimal b = new BigDecimal(s.get("total").toString());

			if(hashAjuste.containsKey(idCuenta)){
				b = new BigDecimal(s.get("total").toString()).add(hashAjuste.get(idCuenta));
			}
			hashAjuste.put(idCuenta, b);
			cuentasCodigo.put(idCuenta, codigoCuenta);
		}

		for (Entry<Integer, BigDecimal> l : hashAjuste.entrySet()){
			Integer clave = l.getKey();
			BigDecimal valor = l.getValue();

			Map<String,String> d = new HashMap<String, String>();
			d.put("Codigo", cuentasCodigo.get(clave).toString());
			d.put("Total", NumberUtils.moneda(valor,2));
			listado.add(d);
		}

		return listado;
	}

	@CheckPermiso(key = "reporteOrdenLineas")
	public static Result listadoLineas(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/lineas.xls");

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

			Sheet hoja = libro.createSheet("lineas");

			List<OrdenLinea> ol = OrdenLinea.find.where().eq("orden_id", id).order("id asc").findList();

			if(ol.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("descr");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("cant");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("cuenta analitica");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("udm");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("precio");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("servicio");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue("pacientes");
				celda0.setCellStyle(comun);
				x++;

				for(OrdenLinea oll : ol){
					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(x);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(oll.producto.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.cantidad.doubleValue());
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue(oll.cuentaAnalitica.codigo);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue(oll.udm.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(oll.precio.doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(6);
					celda0.setCellValue((oll.departamento != null)?oll.departamento.nombre:"");
					celda0.setCellStyle(comun);

					String pacientes = "";

					if(oll.ordenLineaCliente != null && oll.ordenLineaCliente.size() > 0){
						for(OrdenLineaCliente olp : oll.ordenLineaCliente) {
							pacientes += olp.cliente.nombre.toUpperCase()+" - ID:"+olp.cliente.id_paciente_rismi+" | ";
						}
					}

					celda0 = fila.createCell(7);
					celda0.setCellValue(pacientes);
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
