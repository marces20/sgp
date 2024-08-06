package controllers.haberes;

import static play.data.Form.form;

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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.velocity.tools.generic.MathTool;


import models.Ejercicio;
import models.Estado;
import models.OrdenProvision;
import models.OrdenProvisionLineas;
import models.Organigrama;
import models.Periodo;
import models.haberes.LiquidacionConcepto;
import models.haberes.LiquidacionConceptoClasificacion;
import models.haberes.LiquidacionConceptoTipo;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionMes;
import models.haberes.LiquidacionPuesto;
import models.haberes.LiquidacionTipo;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DateUtils;
import utils.NumberUtils;
import views.html.haberes.liquidacionMeses.reportes.*;
import views.html.haberes.liquidacionPuestos.reportes.modalReporteReciboSueldo;

public class LiquidacionMesesReportesController extends Controller  {


	public static BigDecimal getBaseCalculo(Long id_puesto_laboral,Long id_periodo,Long ejercicioId){
		BigDecimal r = new BigDecimal(0);

		String sql = "SELECT round(COALESCE(max(total_x_agente.importe_mes),0),2) "+
         "- round(COALESCE(max(total_deducciones.importe_mes),0),2) "+
          "- (SELECT bc_deduccionesadmitidas(:id_periodo, pl.id)) total_para_calculo_ganancias "+
    "FROM puestos_laborales pl "+
    "LEFT JOIN ( "+
        "SELECT pl.id, sum(ld.importe*ld.cantidad) importe_mes "+
        "FROM liquidacion_detalles ld "+
        "JOIN liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
        "JOIN liquidacion_concepto_tipos lct on lc.liquidacion_concepto_tipo_id = lct.id "+
        "JOIN liquidacion_puestos lp on ld.liquidacion_puesto_id = lp.id "+
        "JOIN liquidacion_meses lm on lp.liquidacion_mes_id = lm.id "+
        "JOIN puestos_laborales pl on lp.puesto_laboral_id = pl.id "+
        "JOIN periodos p on p.id = lm.periodo_id "+
        "WHERE (lct.id in (1,2)) AND lc.deduce_ganancias IS TRUE AND (lm.periodo_id <=  :id_periodo and p.ejercicio_id = :anio_actual) "+
        "AND lm.liquidacion_tipo_id in (1,3,4) GROUP BY pl.id "+
        ") total_x_agente ON total_x_agente.id = pl.id "+
    "LEFT JOIN ( "+
        "SELECT pl.id, sum(ld.importe*ld.cantidad) importe_mes "+
        "FROM liquidacion_detalles ld "+
        "JOIN liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
        "JOIN liquidacion_concepto_tipos lct on lc.liquidacion_concepto_tipo_id = lct.id "+
        "JOIN liquidacion_puestos lp on ld.liquidacion_puesto_id = lp.id "+
        "JOIN liquidacion_meses lm on lp.liquidacion_mes_id = lm.id "+
        "JOIN puestos_laborales pl on lp.puesto_laboral_id = pl.id "+
        "JOIN periodos p on p.id = lm.periodo_id "+
        "WHERE (lct.id = 3) AND lc.deduce_ganancias IS TRUE AND (lm.periodo_id <=  :id_periodo and p.ejercicio_id = :anio_actual) "+
        "AND lm.liquidacion_tipo_id IN (1,3,4) GROUP BY pl.id "+
        ") total_deducciones ON total_deducciones.id = pl.id "+
    "GROUP BY pl.id "+
    "HAVING pl.activo IS TRUE and pl.id = :id_puesto_laboral ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("id_periodo",id_periodo);
		sqlQuery.setParameter("id_puesto_laboral",id_puesto_laboral);
		sqlQuery.setParameter("anio_actual",ejercicioId);
		SqlRow row = sqlQuery.findUnique();

		if(row != null){
			r = row.getBigDecimal("total_para_calculo_ganancias");
		}

		return r;
	}

	@CheckPermiso(key = "reporteDatosAfipGanancias")
	public static Result modalControlDatosAfipGanancias() {
		DynamicForm d = form().bindFromRequest();

		return ok(modalControlDatosAfipGanancias.render(null,d));
	}

	@CheckPermiso(key = "reporteDatosAfipGanancias")
	public static Result exportDatosPorConcepto(Long liquidacionId,Long conceptoId) {
		DynamicForm d = form().bindFromRequest();
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/Listado.xls");

		Ejercicio e = Ejercicio.find.where().eq("code", String.valueOf(DateUtils.getYearFromDate(new Date()))).findUnique();

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

			Sheet hoja = libro.createSheet("Listado");


			List<LiquidacionDetalle> liquidacionDetalles = LiquidacionDetalle.find
									.fetch("liquidacionPuesto.puestoLaboral.legajo.agente")
									.fetch("liquidacionConcepto")
									.where()
									.eq("liquidacionPuesto.liquidacion_mes_id",liquidacionId)
									.eq("liquidacion_concepto_id",conceptoId)
									.orderBy("liquidacionPuesto.puestoLaboral.legajo.agente.apellido")
									.findList();

			int x = 0;
			Row fila = hoja.createRow(x);

			fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Apellido y Nombre");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue("Cuit");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(2);
			celda0.setCellValue("Concepto");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(3);
			celda0.setCellValue("Cantidad");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(4);
			celda0.setCellValue("Monto");
			celda0.setCellStyle(comun);

			for(LiquidacionDetalle lp : liquidacionDetalles){
				x++;
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue(lp.liquidacionPuesto.puestoLaboral.legajo.agente.apellido);
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue(lp.liquidacionPuesto.puestoLaboral.legajo.agente.cuit);
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellValue(lp.liquidacionConcepto.denominacion);
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(3);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(lp.cantidad.doubleValue());
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(4);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(lp.getTotal().doubleValue());
				celda0.setCellStyle(estiloMoneda);

			}
			libro.write(archivoTmp);
			flash("success", "El archivo fue creado correctamente.");

			return ok(archivo);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		flash("success", "El archivo fue creado correctamente.");
		return ok();

	}

	@CheckPermiso(key = "reporteDatosAfipGanancias")
	public static Result reportesControlDatosAfipGanancias() {
		DynamicForm d = form().bindFromRequest();
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/Listado.xls");
		String[] periodo_id = request().body().asFormUrlEncoded().get("periodo_id");

		if( periodo_id == null || periodo_id[0].isEmpty()){
			flash("error", "Debe ingresar un periodo.");
			return ok(modalControlDatosAfipGanancias.render(null,d));
		}

		Ejercicio e = Ejercicio.find.where().eq("code", String.valueOf(DateUtils.getYearFromDate(new Date()))).findUnique();

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

			Sheet hoja = libro.createSheet("Listado");


			List<Object> liquidacionesIds = LiquidacionMes.find.where().eq("periodo_id", new Long(periodo_id[0])).findIds();

			List<LiquidacionPuesto> liquidacionPuestos = LiquidacionPuesto.find.where()
														.in("liquidacion_mes_id",liquidacionesIds)
														.eq("tiene_ganancia",true)
														.findList();

			Map<Long,Map<String,String>> mapDatos = new HashMap<Long,Map<String,String>>();
			Map<Long,BigDecimal> mapMontos = new HashMap<Long,BigDecimal>();

			String data = "";
			int xs= 0;

			int x = 0;
			Row fila = hoja.createRow(x);

			fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Apellido y Nombre");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue("Cuit");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(2);
			celda0.setCellValue("N° Recibo");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(3);
			celda0.setCellValue("Fecha Pago");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(4);
			celda0.setCellValue("Monto Base");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(5);
			celda0.setCellValue("Impuesto");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(6);
			celda0.setCellValue("Monto Neto");
			celda0.setCellStyle(comun);

			for(LiquidacionPuesto lp : liquidacionPuestos){

				for(LiquidacionDetalle ld : lp.liquidacionDetalle){
					 //Proveedor	Cuit	Monto Base	Impuestos	Monto Neto	Expediente	Periodo

					/*if(ld.liquidacion_concepto_id.compareTo(new Long(648)) == 0 ||
							ld.liquidacion_concepto_id.compareTo(new Long(642)) == 0 ||
							ld.liquidacion_concepto_id.compareTo(new Long(584)) == 0 ||
							ld.liquidacion_concepto_id.compareTo(new Long(591)) == 0 ||
							ld.liquidacion_concepto_id.compareTo(new Long(548)) == 0 ||
							ld.liquidacion_concepto_id.compareTo(new Long(562)) == 0){*/
					if(ld.liquidacionConcepto.liquidacion_concepto_clasificacion_id.compareTo(new Integer(9)) == 0) {

						x++;
						fila = hoja.createRow(x);
						celda0 = fila.createCell(0);
						celda0.setCellValue(lp.puestoLaboral.legajo.agente.apellido);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(1);
						celda0.setCellValue(lp.puestoLaboral.legajo.agente.cuit);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(2);
						celda0.setCellValue(lp.id);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(3);
						celda0.setCellValue(utils.DateUtils.formatDate(lp.liquidacionMes.fecha_pago));
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(4);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(lp.getTotalCA().add(lp.getTotalSA()).add(lp.getTotalRetenciones()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);

						celda0 = fila.createCell(5);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(ld.importe.multiply(ld.cantidad).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);

						celda0 = fila.createCell(6);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(lp.getTotalACobrar().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);


					}
				}
			}
			libro.write(archivoTmp);
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalControlDatosAfipGanancias.render(archivo.getPath(),d));

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		flash("success", "El archivo fue creado correctamente.");
		return ok(modalControlDatosAfipGanancias.render(null,d));

	}

	@CheckPermiso(key = "reporteDatosAfipGanancias")
	public static Result modalDatosAfipGanancias() {
		DynamicForm d = form().bindFromRequest();

		return ok(modalDatosAfipGanancias.render(null,d));
	}

	@CheckPermiso(key = "reporteDatosAfipGanancias")
	public static Result reportesDatosAfipGanancias() {
		DynamicForm d = form().bindFromRequest();

		String[] periodo_id = request().body().asFormUrlEncoded().get("periodo_id");

		if( periodo_id == null || periodo_id[0].isEmpty()){
			flash("error", "Debe ingresar un periodo.");
			return ok(modalDatosAfipGanancias.render(null,d));
		}

		Ejercicio e = Ejercicio.find.where().eq("code", String.valueOf(DateUtils.getYearFromDate(new Date()))).findUnique();


		String dirTemp = System.getProperty("java.io.tmpdir");
		try {

			File archivo = new File(dirTemp + "/export_afip_ganancias.txt");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "Cp1252"));

			List<Object> liquidacionesIds = LiquidacionMes.find.where().eq("estado_id", Estado.LIQUIDACION_MES_CERRADA).eq("periodo_id", new Long(periodo_id[0])).findIds();

			List<LiquidacionPuesto> liquidacionPuestos = LiquidacionPuesto.find.select("id,estado_id,liquidacion_mes_id,tiene_ganancia")
														.fetch("puestoLaboral.legajo.agente","cuit")
														.fetch("liquidacionMes","fecha_pago,fecha_liquidacion")
														.fetch("liquidacionDetalle","importe,cantidad")
														.fetch("liquidacionDetalle.liquidacionConcepto","liquidacion_concepto_clasificacion_id")
														.where()
														.in("liquidacion_mes_id",liquidacionesIds)
														.eq("estado_id",Estado.LIQUIDACION_PUESTOS_APROBADO)
														.eq("tiene_ganancia",true)
														.findList();

			Map<Long,Map<String,String>> mapDatos = new HashMap<Long,Map<String,String>>();
			Map<Long,BigDecimal> mapMontos = new HashMap<Long,BigDecimal>();

			String data = "";
			int xs= 0;

			for(LiquidacionPuesto lp : liquidacionPuestos){

				for(LiquidacionDetalle ld : lp.liquidacionDetalle){

					//if(ld.liquidacion_concepto_id.compareTo(new Long(648)) == 0 || ld.liquidacion_concepto_id.compareTo(new Long(642)) == 0 || ld.liquidacion_concepto_id.compareTo(new Long(584)) == 0 || ld.liquidacion_concepto_id.compareTo(new Long(591)) == 0 || ld.liquidacion_concepto_id.compareTo(new Long(548)) == 0 || ld.liquidacion_concepto_id.compareTo(new Long(562)) == 0){
					if(ld.liquidacionConcepto.reporte_ganancias || ld.liquidacionConcepto.liquidacion_concepto_clasificacion_id.compareTo(new Integer(9)) == 0 || ld.liquidacionConcepto.liquidacion_concepto_clasificacion_id.compareTo(new Integer(13)) == 0) {
						data = "";
						/*if(ld.liquidacion_concepto_id.compareTo(new Long(548)) == 0){

						}else if(ld.liquidacion_concepto_id.compareTo(new Long(562)) == 0){

						}*/

						BigDecimal importeRet = ld.importe.multiply(ld.cantidad);
						BigDecimal baseCalculo = new BigDecimal(0);


						if(ld.liquidacionConcepto.id.compareTo(new Long(584)) == 0) {// codigo 61
							data += Strings.padEnd("61", 2, '0');
							if(importeRet.compareTo(BigDecimal.ZERO) < 0){
								importeRet = importeRet.multiply(new BigDecimal(-1));
								baseCalculo = importeRet;
							}

						}else if(ld.liquidacionConcepto.id.compareTo(new Long(591)) == 0) {//codigo 62
							data += Strings.padEnd("62", 2, '0');
							if(importeRet.compareTo(BigDecimal.ZERO) < 0){
								importeRet = importeRet.multiply(new BigDecimal(-1));
								baseCalculo = importeRet;
							}
						}else {

							if(importeRet.compareTo(BigDecimal.ZERO) < 0){
								data += Strings.padEnd("08", 2, '0');

								importeRet = importeRet.multiply(new BigDecimal(-1));
								baseCalculo = importeRet;
							}else{
								data += Strings.padEnd("07", 2, '0');
							}

							if(lp.liquidacionMes.fecha_liquidacion == null){
								flash("error", "Debe ingresar una fecha liquidacion.");
								return ok(modalDatosAfipGanancias.render(null,d));
							}
						}
						data +=  Strings.padEnd(DateUtils.formatDate(lp.liquidacionMes.fecha_pago),10,'0');//fecha emision
						data += Strings.padStart(lp.id.toString(), 16, '0');//numero comprobante

						String importeComprobante = new DecimalFormat("###.##").format(BigDecimal.ZERO);
						data += Strings.padStart(importeComprobante.replace('.', ','), 17, ' '); // importeComprobante
						data += Strings.padEnd("787", 3, '0');//codigo impuesto
						data += Strings.padEnd("160", 3, '0');//codigo regimen
						data += Strings.padEnd("1", 1, '0');//codigo operacion

						String baseCalculoStr = new DecimalFormat("###.##").format(baseCalculo);
						data += Strings.padStart(baseCalculoStr.replace('.', ','), 14, ' '); // base calculo

						if(lp.liquidacionMes.fecha_pago == null){
							flash("error", "Debe ingresar una fecha pago."+lp.id.toString()+" "+lp.liquidacionMes.fecha_pago+" "+lp.liquidacionMes.id);
							return ok(modalDatosAfipGanancias.render(null,d));
						}

						data +=  Strings.padEnd(DateUtils.formatDate(lp.liquidacionMes.fecha_pago),10,'0');//fecha emision retencion
						data += Strings.padEnd("01", 2, '0');//codigo condicion
						data += Strings.padEnd("0", 1, '0');//codigo retencion practicada

						String importeRetencion = new DecimalFormat("###.##").format(importeRet);
						data += Strings.padStart(importeRetencion.replace('.', ','), 14, ' '); // importeretencion

						String porcentajeExclusion = new DecimalFormat("###.##").format(BigDecimal.ZERO);
						data += Strings.padStart(porcentajeExclusion.replace('.', ','), 6, ' '); // importeretencion

						data +=  Strings.padEnd(DateUtils.formatDate(lp.liquidacionMes.fecha_liquidacion),10,'0');//fecha emision boletin
						data += Strings.padEnd("86", 2, '0');//codigo condicion
						data += Strings.padEnd(lp.puestoLaboral.legajo.agente.cuit,20, ' '); // cuit




						if(ld.liquidacionConcepto.id.compareTo(new Long(584)) == 0) {

							Integer ii = new Integer(e.code)-1;




							data += Strings.padEnd("0000"+ii.toString(), 8, '0');
							data += Strings.padEnd("0", 6, '0');
						}else {
							data += Strings.padEnd("0000"+e.code, 8, '0');
							data += Strings.padEnd("0", 6, '0');
							//data += Strings.padEnd("0", 14, '0');
						}
						data += Strings.padEnd("", 30, '0');
						data += Strings.padEnd("0", 1, '0');
						data += Strings.padEnd("", 11, '0');
						data += Strings.padEnd("", 11, '0');
						out.append(data).append("\r\n");
						xs++;
						Logger.debug("xxxx "+xs);

					}
				}
			}

			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(modalDatosAfipGanancias.render(archivo.getPath(),d));

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		flash("success", "El archivo fue creado correctamente.");
		return ok(modalDatosAfipGanancias.render(null,d));
	}

	@CheckPermiso(key = "reporteDatosAfip")
	public static Result modalDatosAfip() {
		DynamicForm d = form().bindFromRequest();

		return ok(modalDatosAfip.render(null,d));
	}

	@CheckPermiso(key = "reporteDatosAfip")
	public static Result reportesDatosAfip() {
		DynamicForm d = form().bindFromRequest();

		/*String[] periodo_id = request().body().asFormUrlEncoded().get("periodo_id");

		if( periodo_id == null || periodo_id[0].isEmpty()){
			flash("error", "Debe ingresar un periodo.");
			return ok(modalDatosAfip.render(null,d));
		}*/

		List<Integer> liquidacionesIds = getSeleccionados();

		if(liquidacionesIds.size() <= 0){
			flash("error", "Debe seleccionar una liquidacion.");
		 	return ok(modalDatosAfip.render(null,d));
		}

		String dirTemp = System.getProperty("java.io.tmpdir");
		try {

			File archivo = new File(dirTemp + "/export_afip.txt");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "Cp1252"));


			//List<Object> liquidacionesIds = LiquidacionMes.find.where().eq("periodo_id", new Long(periodo_id[0])).findIds();

			List<LiquidacionPuesto> liquidacionPuestos = LiquidacionPuesto.find
														 .fetch("puestoLaboral.legajo")
														 .fetch("puestoLaboral.legajo.agente","id,cuit,apellido,sexo,conyugue_dni,cantidad_hijos")
														 .where().in("liquidacion_mes_id",liquidacionesIds).findList();

			Map<Long,Map<String,String>> mapDatos = new HashMap<Long,Map<String,String>>();
			Map<Long,BigDecimal> mapMontos = new HashMap<Long,BigDecimal>();

			for(LiquidacionPuesto lp : liquidacionPuestos){
				//if(lp.puesto_laboral_id.compareTo(new Long(790)) == 0){

					if(mapDatos.containsKey(lp.puestoLaboral.legajo.agente_id)){

						BigDecimal remuns2 = lp.getTotalCA().add(lp.getTotalSA());
						BigDecimal mTmp = mapMontos.get(lp.puestoLaboral.legajo.agente_id);
						mapMontos.put(lp.puestoLaboral.legajo.agente_id, mTmp.add(remuns2));

					}else{
						Map<String,String> datoTmp = new HashMap<String,String>();
						datoTmp.put("CUIT", lp.puestoLaboral.legajo.agente.cuit);
						datoTmp.put("APELLIDO", lp.puestoLaboral.legajo.agente.apellido);

						if (lp.puestoLaboral.legajo.agente.conyugue_dni != null && lp.puestoLaboral.legajo.agente.sexo == "male") {
							datoTmp.put("CONYUGE", "1");
						} else {
							datoTmp.put("CONYUGE", "0");
						}

						/*String sql = "select count(*) hijos from agente_hijos where agente_id = :agente_id ";
						SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
						sqlQuery.setParameter("agente_id",lp.puestoLaboral.legajo.agente.id);
						SqlRow row = sqlQuery.findUnique();*/

						datoTmp.put("HIJOS",lp.puestoLaboral.legajo.agente.getCantidadHijos().toString());

						BigDecimal remuns2 = lp.getTotalCA().add(lp.getTotalSA());
						mapMontos.put(lp.puestoLaboral.legajo.agente.id, remuns2);
						mapDatos.put(lp.puestoLaboral.legajo.agente.id, datoTmp);
					}
				//}
			}

			for (Entry<Long, Map<String,String>> m : mapDatos.entrySet()){
				Long clave = m.getKey();
				Map<String,String> datos = m.getValue();

				String data = "";
				data += Strings.padEnd(datos.get("CUIT"),11, ' '); // cuit
				data += Strings.padEnd(datos.get("APELLIDO"),30, ' ').substring(0, 30); // apellido
				data += datos.get("CONYUGE");
				data += Strings.padStart(datos.get("HIJOS"), 2, '0');

				data += Strings.padEnd("01", 2, '0'); // cod situcion
				data += Strings.padEnd("01", 2, '0'); // cod condicion
				data += Strings.padEnd("905", 3, '0'); // cod actividad
				data += Strings.padEnd("51", 2, '0'); // cod zona
				data += Strings.padEnd("00,00", 5, '0'); // porc aporte adic
															// ss
				data += Strings.padEnd("008", 3, '0'); // cod modalidad
														// contratacion
				data += Strings.padEnd("", 6, '0'); // cod obra social
				data += Strings.padEnd("", 2, '0'); // cantidad de aderentes

				BigDecimal remuns2 = mapMontos.get(clave);

				NumberFormat numberFormat = NumberFormat.getInstance();
				numberFormat.setMaximumFractionDigits(2);
				//String remuns = numberFormat.format(remuns2);

				//String remuns = NumberUtils.formatNumber(remuns2.doubleValue(),2);
				String remuns = new DecimalFormat("###############.00").format(remuns2);

				data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remuneracion total

				data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remuneracion
				// imponible
				data += Strings.padStart("0,00", 9, ' '); // asig familiares
														  // pag
				data += Strings.padStart("0,00", 9, ' '); // importe aporte
														  // vol
				data += Strings.padStart("0,00", 9, ' '); // importe
														  // adicional os
				data += Strings.padStart("0,00", 9, ' '); // importe
															// exedente
				// aporte ss
				data += Strings.padStart("0,00", 9, ' '); // importe
														  // exedente
				// aporte os
				data += Strings.padEnd("Misiones Posadas", 50, ' '); // prov
																		// localidad
				data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remun imponible 2
				data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remun imponible 3
				data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remun imponible 4
				data += Strings.padEnd("00", 2, '0'); // codigo de
														// siniestrado
				data += Strings.padEnd("0", 1, '0'); // marca de corresponde
														// rediccion
				data += Strings.padStart("0,00", 9, ' '); // capital lrt
				data += Strings.padEnd("9", 1, ' '); // tipo de empresa
				data += Strings.padStart("0,00", 9, ' '); // aporte
														  // adicional de
				// obre social
				data += Strings.padEnd("1", 1, ' '); // regimen
				data += Strings.padEnd("01", 2, ' '); // sit revista 1
				data += Strings.padEnd("01", 2, ' '); // dia inicio sit
														// revista 1
				data += Strings.padEnd("01", 2, ' '); // sit revista 2
				data += Strings.padEnd("00", 2, ' '); // dia inicio sit
														// revista 2
				data += Strings.padEnd("01", 2, ' '); // sit revista 3
				data += Strings.padEnd("00", 2, ' '); // dia inicio sit
														// revista 3
				data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // sueldo +
														// adicionales
				data += Strings.padStart("0,00", 12, ' '); // sac
				data += Strings.padStart("0,00", 12, ' '); // horas extra
				data += Strings.padStart("0,00", 12, ' '); // zona
															// desfavorable
				data += Strings.padStart("0,00", 12, ' '); // vacaciones

				data += Strings.padStart("30,00", 9, ' '); // cant dias trabajados
														//
				data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // remun imponible 5
				data += Strings.padEnd("1", 1, ' '); // trabajador
														// convencionado
				data += Strings.padStart("0,00", 12, ' '); // remun imponible  6
				data += Strings.padEnd("0", 1, ' '); // tipo de operacion
				data += Strings.padStart("0,00", 12, ' '); // adicionales
				data += Strings.padStart("0,00", 12, ' '); // premios
				data += Strings.padStart(remuns.replace('.', ','), 12, ' '); // 788/05 rem impon 8
				data += Strings.padStart("0,00", 12, ' '); // remun imponible 7
				data += Strings.padEnd("000", 3, ' '); // cant horas extras
				data += Strings.padStart("0,00", 12, ' '); // conc no
															// remunerativos
				data += Strings.padStart("0,00", 12, ' '); // maternidad
				data += Strings.padStart("0,00", 9, ' '); // rectificacion
															// de
				// remuneracion
				data += Strings.padStart("0,00", 12, ' '); // remun  imponible 9
				//data += Strings.padStart(remuns.replace('.', ','), 12, ' ');// remun  imponible 9

				data += Strings.padStart("0,00", 9, ' '); // contrib tarea
				// diferencial
				data += Strings.padEnd("0", 3, '0'); // horas trabajadas
				data += Strings.padEnd("F", 1, ' '); // seguro vida oblig

				data += Strings.padStart("0,00", 12, ' '); // importe a de traer ley 27430
				data += Strings.padStart("0,00", 12, ' '); // incremento salarial
				data += Strings.padStart("0,00", 12, ' '); // remuneracion imponible 11

				// agrego la linea al archivo
				out.append(data).append("\r\n");

			}
			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(modalDatosAfip.render(archivo.getPath(),d));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}



		flash("success", "El archivo fue creado correctamente.");
		return ok(modalDatosAfip.render(null,d));

	}

	public static Result ordenDePago(Long id) {

		LiquidacionMes lm = LiquidacionMes.find.byId(id);



		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/orden-pago-liquidacion.odt");

		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/liquidaciones/ordenDePago.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();


			String expediente = (lm.expediente != null)?lm.expediente.getExpedienteEjercicio():" ";
			String expedienteDescripcion = (lm.expediente != null)?lm.expediente.descripcion:" ";
			String ordenPago = (lm.ordenPago != null)?lm.ordenPago.getOrdenEjercicio():" ";
			String fechaOrdenPago = (lm.fecha_orden_pago != null)?DateUtils.formatDate(lm.fecha_orden_pago,"dd/MM/yyyy"):" ";

			context.put("fechaOrdenPago", fechaOrdenPago);
			context.put("ordenPago", ordenPago);
			context.put("expedienteDescripcion", expedienteDescripcion);
			context.put("expediente", expediente);
			context.put("number", new NumberUtils());
			context.put("math", new MathTool());
			context.put("date",  new DateUtils());
			context.put("lm",lm);
			List<SqlRow> dataPorConcepto = LiquidacionMes.getDataPorConcepto(id);
			context.put("dc",dataPorConcepto);

			OutputStream out = new FileOutputStream(archivo);
	        report.process(context, out);

	        return ok(archivo);

		}  catch (Exception e) {
			System.out.println(e);
		}

		return ok();
	}


	public static Result datosGenerales(Long id) {

		LiquidacionMes lm = LiquidacionMes.find.byId(id);

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/datos-generales.odt");

		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/liquidaciones/reporteDatosGenerales.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();

			context.put("number", new NumberUtils());
			context.put("math", new MathTool());
			context.put("date",  new DateUtils());
			context.put("lm",lm);
			List<SqlRow> dataPorConcepto = LiquidacionMes.getDataPorConcepto(id);
			context.put("dc",dataPorConcepto);

			OutputStream out = new FileOutputStream(archivo);
	        report.process(context, out);

	        return ok(archivo);

		}  catch (Exception e) {
			System.out.println(e);
		}

		return ok();
	}

	public static Result comparativoCertificacion(Long id) {

		LiquidacionMes lm = LiquidacionMes.find.byId(id);

		/*
		String sql = "SELECT haber.agente_id, a.apellido agente, haber.periodo_id, certificacion.total certificacion, haber.total sueldo from ( " +

					 "		SELECT p.agente_id, c.periodo_id, round(sum(precio * cantidad)::numeric,2) -  sum(round((((precio*descuento)/100) * cantidad)::numeric)) total FROM certificaciones c " +
					 "		INNER JOIN certificaciones_lineas cl ON c.id = cl.certificacion_id " +
					 "		INNER JOIN proveedores p ON p.id = c.proveedor_id " +
					 "		WHERE periodo_id = (select MAX(periodo_id) periodo_id from certificaciones) AND state_id = 31 AND expediente_id != 5922 " +
					 "		GROUP BY p.agente_id,c.periodo_id " +

					 "	) certificacion " +

					"	inner join ( " +

					"		select l.agente_id, lm.periodo_id, sum(h.total - r.total) total from liquidacion_puestos lp " +
					"		left join (select liquidacion_puesto_id, sum(importe*cantidad) as total from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(1,4,2) group by liquidacion_puesto_id) h on h.liquidacion_puesto_id = lp.id " +
					"		left join (select liquidacion_puesto_id, sum(importe*cantidad) as total from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(3) group by liquidacion_puesto_id) r on r.liquidacion_puesto_id = lp.id " +
					"		inner join liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +
					"		inner join puestos_laborales pl on pl.id = lp.puesto_laboral_id " +
					"		inner join legajos l on l.id = pl.legajo_id " +
					"		where lp.liquidacion_mes_id = " + id +
					"		group by l.agente_id, lm.periodo_id " +

					"	) haber " +
					"	on certificacion.agente_id = haber.agente_id " +
					"   inner join agentes a on a.id = haber.agente_id ORDER BY a.apellido";
		*/


		String sql = "" +
				" select a.apellido agente, lm.periodo_id, sum(h.total - r.total) sueldo, pl.sueldo_referencia certificacion from liquidacion_puestos lp "+
				" left join (select liquidacion_puesto_id, sum(importe*cantidad) as total from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(1,4,2) group by liquidacion_puesto_id) h on h.liquidacion_puesto_id = lp.id"+
				" left join (select liquidacion_puesto_id, sum(importe*cantidad) as total from liquidacion_detalles ld inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id where lc.liquidacion_concepto_tipo_id in(3) group by liquidacion_puesto_id) r on r.liquidacion_puesto_id = lp.id "+
				" inner join liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+
				" inner join puestos_laborales pl on pl.id = lp.puesto_laboral_id "+
				" inner join legajos l on l.id = pl.legajo_id "+
				" inner join agentes a on a.id = l.agente_id "+
				" where lp.liquidacion_mes_id = "+ id +
				" group by l.agente_id, a.apellido, lm.periodo_id, pl.sueldo_referencia ORDER BY a.apellido";

		List<SqlRow> query = Ebean.createSqlQuery(sql).findList();

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/totales-por-conceptos.odt");

		try {
        	InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/liquidaciones/comparativo-certificacion.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();

			context.put("number", new NumberUtils());
			context.put("math", new MathTool());
			context.put("periodo", lm.periodo.nombre);
			context.put("liquidacion", lm.nro_liquidacion_parque);
			context.put("lista", query);

			OutputStream out = new FileOutputStream(archivo);
	        report.process(context, out);

	        return ok(archivo);

		}  catch (Exception e) {
			System.out.println(e);
		}

		return ok();
	}

	public static Result totalPorConceptos(Long id) {

		LiquidacionMes lc = LiquidacionMes.find.byId(id);
		List<SqlRow> dataPorConcepto = LiquidacionMes.getDataPorConcepto(id);

		if(lc == null){
			flash("error", "No se encuentra la liquidación.");
			return redirect(controllers.haberes.routes.LiquidacionMesesController.ver(id));
		}

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/totales-por-conceptos.odt");

		try {

        	InputStream in = Play.application().resourceAsStream("resources/reportes/haberes/liquidaciones/total-por-conceptos.odt");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			IContext context = report.createContext();

			context.put("number", new NumberUtils());
			context.put("math", new MathTool());
			context.put("fechaReporte", DateUtils.formatDate(new Date()));

			context.put("conAporte", LiquidacionConceptoTipo.HABERES_CON_APORTE);
			context.put("sinAporte", LiquidacionConceptoTipo.HABERES_SIN_APORTE);
			context.put("retenciones", LiquidacionConceptoTipo.RETENCIONES);
			context.put("contrib", LiquidacionConceptoTipo.CONTRIBUCIONES_PATRONALES);

			context.put("numero", lc.nro_liquidacion_parque );
			context.put("periodo", lc.periodo.nombre);

			context.put("contenedorObjetos",  Lists.partition(dataPorConcepto,30 ));


			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);


            return ok(archivo);

		} catch (Exception e) {

		}
		return ok();
	}


	public static Result listadoSeguroSepelio(Long id) {
		return listadoSeguros(id,"sepelio","Seguro de Sepelio");
	}

	public static Result listadoSeguroVida(Long id) {
		return listadoSeguros(id,"vida","Seguro de Vida");
	}

	public static Result listadoSeguros(Long id,String tipo,String titulo) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/Listado "+titulo+".xls");

		List<Long> listaConceptos = new ArrayList<Long>();
		if(tipo.compareTo("vida") == 0) {

			listaConceptos.add(LiquidacionConcepto.SEGURO_DE_VIDA);
			listaConceptos.add(LiquidacionConcepto.SEGURO_DE_VIDA_AJUSTE);
		}else {
			listaConceptos.add(LiquidacionConcepto.SEGURO_DE_SEPELIO);
			listaConceptos.add(LiquidacionConcepto.SEGURO_DE_SEPELIO_AJUSTE);
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

			Sheet hoja = libro.createSheet(titulo);

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral")
			.fetch("puestoLaboral.legajo")
			.fetch("puestoLaboral.legajo.agente")
			.where().eq("liquidacion_mes_id", id).orderBy("puestoLaboral.legajo.agente.apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				/*Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Datos");
				celda0.setCellStyle(comun);
				x++;*/

				fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Legajo");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Tipo Doc");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Documento");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Apellido y Nombre");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Cuil");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Sexo");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("Nacimiento");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(7);
				celda0.setCellValue("Sueldo");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(8);
				celda0.setCellValue("Premio");
				celda0.setCellStyle(comun);
				x++;

				BigDecimal total =  new BigDecimal(0);
				BigDecimal totalHaberes =  new BigDecimal(0);
				for (LiquidacionPuesto l: lp) {

					List<LiquidacionDetalle> ld = new LiquidacionDetalle().find
							.fetch("liquidacionConcepto")
							.where()
							.eq("liquidacion_puesto_id", l.id)
							.in("liquidacion_concepto_id", listaConceptos)
							.findList();
					BigDecimal imp = new BigDecimal(0);
					for(LiquidacionDetalle ldx:ld) {
						imp = imp.add(ldx.importe);
					}

					if(ld != null){
						fila = hoja.createRow(x);

						celda0 = fila.createCell(0);
						celda0.setCellValue(l.puestoLaboral.legajo.numero);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(1);
						celda0.setCellValue("DNI");
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(2);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.dni);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(3);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(4);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
						celda0.setCellStyle(comun);

						String sexo = l.puestoLaboral.legajo.agente.sexo;
						String sexoCortado=(sexo.length() > 0)?sexo.substring(0, 1).toUpperCase():"";
						celda0 = fila.createCell(5);
						celda0.setCellValue(sexoCortado);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(6);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.fnacimiento);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(7);
						totalHaberes = totalHaberes.add(l.getTotalCA());
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(NumberUtils.moneda(l.getTotalCA()));
						celda0.setCellValue(l.getTotalCA().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);

						celda0 = fila.createCell(8);
						total = total.add(imp);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(imp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);

						x++;
					}
				}

				fila = hoja.createRow(x);
				celda0 = fila.createCell(6);
				celda0.setCellValue("TOTAL");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(7);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalHaberes.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(8);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
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

	public static Result listadoJubilacion(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_jubilacion.xls");

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

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral")
			.fetch("puestoLaboral.legajo")
			.fetch("puestoLaboral.legajo.agente")
			.where().eq("liquidacion_mes_id", id).orderBy("puestoLaboral.legajo.agente.apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Datos");
				celda0.setCellStyle(comun);
				x++;

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Cuil");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Ingreso");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Haberes");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Monto");
				celda0.setCellStyle(comun);
				x++;
				BigDecimal total =  new BigDecimal(0);
				BigDecimal totalHaberes =  new BigDecimal(0);
				for (LiquidacionPuesto l: lp) {

					LiquidacionDetalle ld = new LiquidacionDetalle().find
							.fetch("liquidacionConcepto")
							.where()
							.eq("liquidacion_puesto_id", l.id)
							.eq("liquidacion_concepto_id", LiquidacionConcepto.JUBILACION).findUnique();

					if(ld != null){
						fila = hoja.createRow(x);
						celda0 = fila.createCell(0);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(1);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(2);
						celda0.setCellValue(utils.DateUtils.formatDate(l.puestoLaboral.fecha_posesion));
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(3);
						totalHaberes = totalHaberes.add(l.getTotalCA());
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(NumberUtils.moneda(l.getTotalCA()));
						celda0.setCellValue(l.getTotalCA().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);

						celda0 = fila.createCell(4);
						total = total.add(ld.importe);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(ld.importe.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);

						x++;
					}
				}

				fila = hoja.createRow(x);
				celda0 = fila.createCell(1);
				celda0.setCellValue("TOTAL");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalHaberes.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(3);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
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

	public static Result listadoObraSocial(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_jubilacion.xls");

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

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral")
			.fetch("puestoLaboral.legajo")
			.fetch("puestoLaboral.legajo.agente")
			.where().eq("liquidacion_mes_id", id).orderBy("puestoLaboral.legajo.agente.apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Datos");
				celda0.setCellStyle(comun);
				x++;

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Cuil");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Haberes");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Monto");
				celda0.setCellStyle(comun);
				x++;
				BigDecimal total =  new BigDecimal(0);
				BigDecimal totalHaberes =  new BigDecimal(0);
				for (LiquidacionPuesto l: lp) {

					LiquidacionDetalle ld = new LiquidacionDetalle().find
							.fetch("liquidacionConcepto")
							.where()
							.eq("liquidacion_puesto_id", l.id)
							.eq("liquidacion_concepto_id", LiquidacionConcepto.OB).findUnique();

					if(ld != null){
						fila = hoja.createRow(x);
						celda0 = fila.createCell(0);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(1);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(2);
						totalHaberes = totalHaberes.add(l.getTotalCA());
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(NumberUtils.moneda(l.getTotalCA()));
						celda0.setCellValue(l.getTotalCA().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);

						celda0 = fila.createCell(3);
						total = total.add(ld.importe);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(ld.importe.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);

						x++;
					}
				}

				fila = hoja.createRow(x);
				celda0 = fila.createCell(1);
				celda0.setCellValue("TOTAL");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalHaberes.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(3);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
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

	/*public static Result listadoSeguroVida(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_seguro_vida.xls");

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

			Sheet hoja = libro.createSheet("Seguro de Vida");

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral")
			.fetch("puestoLaboral.legajo")
			.fetch("puestoLaboral.legajo.agente")
			.where().eq("liquidacion_mes_id", id).orderBy("puestoLaboral.legajo.agente.apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Datos");
				celda0.setCellStyle(comun);
				x++;

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Cuil");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Monto");
				celda0.setCellStyle(comun);
				x++;
				BigDecimal total =  new BigDecimal(0);
				for (LiquidacionPuesto l: lp) {

					LiquidacionDetalle ld = new LiquidacionDetalle().find
							.fetch("liquidacionConcepto")
							.where()
							.eq("liquidacion_puesto_id", l.id)
							.eq("liquidacion_concepto_id", LiquidacionConcepto.SEGURO_DE_VIDA).findUnique();

					if(ld != null){
						fila = hoja.createRow(x);
						celda0 = fila.createCell(0);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(1);
						celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
						celda0.setCellStyle(comun);

						celda0 = fila.createCell(2);
						//celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						total = total.add(ld.importe);
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(ld.importe.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						celda0.setCellStyle(estiloMoneda);



						x++;
					}
				}

				fila = hoja.createRow(x);
				celda0 = fila.createCell(1);
				celda0.setCellValue("TOTAL");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);
			}

			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(archivo);
	}*/

	public static Result listadoPorConceptosPorPuestoLaboral(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_concepto_puesto.xls");

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

			Sheet hoja = libro.createSheet("Seguro de Vida");

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral","fecha_posesion")
			.fetch("puestoLaboral.escalaLaboral","nombre")

			.fetch("puestoLaboral.legajo","numero")
			.fetch("puestoLaboral.legajo.agente","apellido,cuit")
			.fetch("puestoLaboral.legajo.agente.profesion","nombre")
			.fetch("puestoLaboral.legajo.agente.organigrama","nombre")
			.fetch("puestoLaboral.categoriaLaboral","nombre")
			.fetch("liquidacionDetalle")
			.fetch("liquidacionDetalle.liquidacionConcepto","denominacion")
			.fetch("liquidacionDetalle.liquidacionConcepto.liquidacionConceptoClasificacion","nombre")
			.where().eq("liquidacion_mes_id", id)
			.orderBy("puestoLaboral.legajo.agente.apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("Cuil");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellValue("Legajo");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(3);
				celda0.setCellValue("Escala");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(4);
				celda0.setCellValue("Concepto");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(5);
				celda0.setCellValue("Concepto-Clasificacion");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(6);
				celda0.setCellValue("Categoria-Interna");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(7);
				celda0.setCellValue("Cantidad");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(8);
				celda0.setCellValue("Importe");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(9);
				celda0.setCellValue("Total");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(10);
				celda0.setCellValue("Profesion");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(11);
				celda0.setCellValue("Servicio");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(12);
				celda0.setCellValue("Fecha Ingreso");
				celda0.setCellStyle(comun);


				x++;

				BigDecimal total =  new BigDecimal(0);
				for (LiquidacionPuesto l: lp) {

					/*List<LiquidacionDetalle> lx = new LiquidacionDetalle().find
							.fetch("liquidacionConcepto")
							.where()
							.eq("liquidacion_puesto_id", l.id).findList();*/

					for (LiquidacionDetalle ld: l.liquidacionDetalle) {

						if(ld != null){

							fila = hoja.createRow(x);

							celda0 = fila.createCell(0);
							celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(1);
							celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(2);
							celda0.setCellValue(l.puestoLaboral.legajo.numero);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(3);
							celda0.setCellValue(l.puestoLaboral.escalaLaboral.nombre);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(4);
							total = total.add(ld.importe);
							celda0.setCellValue(ld.liquidacionConcepto.denominacion);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(5);
							celda0.setCellValue(ld.liquidacionConcepto.liquidacionConceptoClasificacion.nombre);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(6);
							celda0.setCellValue(l.puestoLaboral.categoriaLaboral.nombre);
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(7);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(ld.cantidad.doubleValue());
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(8);
							total = total.add(ld.importe);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(ld.importe.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							celda0.setCellStyle(estiloMoneda);

							celda0 = fila.createCell(9);
							total = total.add(ld.getTotal());
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(ld.getTotal().doubleValue());
							celda0.setCellStyle(estiloMoneda);

							celda0 = fila.createCell(10);
							celda0.setCellValue((l.puestoLaboral.legajo.agente.profesion != null)?l.puestoLaboral.legajo.agente.profesion.nombre:"");
							celda0.setCellStyle(comun);

							celda0 = fila.createCell(11);
							celda0.setCellValue((l.puestoLaboral.legajo.agente.organigrama != null)?l.puestoLaboral.legajo.agente.organigrama.nombre:"");
							celda0.setCellStyle(comun);


							celda0 = fila.createCell(12);
							celda0.setCellValue(utils.DateUtils.formatDate(l.puestoLaboral.fecha_posesion));
							celda0.setCellStyle(comun);
							x++;
						}
					}

					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(l.puestoLaboral.legajo.numero);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue(l.puestoLaboral.escalaLaboral.nombre);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue("TOTAL A COBRAR");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(5);
					celda0.setCellValue("TOTAL A COBRAR");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(9);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(l.getTotalACobrar().doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;

				}

				fila = hoja.createRow(x);
				celda0 = fila.createCell(7);
				celda0.setCellValue("TOTAL");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(8);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
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

	public static Result listadoPorEscalaPorPuestoLaboral(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_escala_profesion_puesto.xls");

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

			Sheet hoja = libro.createSheet("Seguro de Vida");

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral")
			.fetch("puestoLaboral.legajo")
			.fetch("puestoLaboral.legajo.agente")
			.fetch("puestoLaboral.legajo.agente.profesion")
			.where()
			.eq("liquidacion_mes_id", id)
			.orderBy("puestoLaboral.escalaLaboral.nombre,puestoLaboral.legajo.agente.apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("Cuit");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellValue("Legajo");
				celda0.setCellStyle(comun);


				celda0 = fila.createCell(3);
				celda0.setCellValue("Escala");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(4);
				celda0.setCellValue("Profesion");
				celda0.setCellStyle(comun);

				x++;

				BigDecimal total =  new BigDecimal(0);
				for (LiquidacionPuesto l: lp) {

					fila = hoja.createRow(x);

					celda0 = fila.createCell(0);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(l.puestoLaboral.legajo.numero);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue((l.puestoLaboral.escalaLaboral != null)?l.puestoLaboral.escalaLaboral.nombre:"");
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue((l.puestoLaboral.legajo.agente.profesion != null)?l.puestoLaboral.legajo.agente.profesion.nombre:"");
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


	/*
	public static Result listadoDePuestoLaboralComparativoPeriodo(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_puesto.xls");

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

			Sheet hoja = libro.createSheet("Comparativo");

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral")
			.fetch("puestoLaboral.legajo")
			.fetch("puestoLaboral.legajo.agente")
			.where().eq("liquidacion_mes_id", id).orderBy("puestoLaboral.legajo.agente.apellido").findList();
			if(lp.size() > 0){

				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Datos");
				celda0.setCellStyle(comun);
				x++;

				BigDecimal total =  new BigDecimal(0);
				for (LiquidacionPuesto l: lp) {

					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(l.getTotalACobrar().doubleValue());
					celda0.setCellStyle(estiloMoneda);


					LiquidacionMes lm = LiquidacionMes.find.byId(id);


					Calendar calendar = Calendar.getInstance();
					calendar.setTime(lm.periodo.date_start);
					calendar.add(Calendar.MONTH, -1);

					List<LiquidacionPuesto> lpp = new LiquidacionPuesto()
					.find
					.fetch("puestoLaboral").fetch("puestoLaboral.legajo").fetch("puestoLaboral.legajo.agente").where()
					.eq("liquidacionMes.periodo.date_start",calendar.getTime())
					.eq("puestoLaboral.id",l.puesto_laboral_id)
					.disjunction()
					.eq("liquidacionMes.liquidacion_tipo_id",1)
					.eq("liquidacionMes.liquidacion_tipo_id",3)
					.endJunction()
					.orderBy("puestoLaboral.legajo.agente.apellido").findList();

					BigDecimal t = new BigDecimal(0);
					String periodo = "";
					for (LiquidacionPuesto lppx: lpp) {
						t = t.add(lppx.getTotalACobrar());
						periodo = lppx.liquidacionMes.periodo.nombre;
					}

					Row filax = hoja.createRow(0);
					celda0 = filax.createCell(2);
					celda0.setCellValue(lm.periodo.nombre);
					celda0.setCellStyle(comun);
					celda0 = filax.createCell(3);
					celda0.setCellValue(periodo);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(t.doubleValue());
					celda0.setCellStyle(estiloMoneda);

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
	*/

	public static Result listadoDePuestoLaboralComparativoPeriodo(Long id) {
		LiquidacionMes LMActual   = LiquidacionMes.find.byId(id);
		Integer idPeriodoActual = LMActual.periodo_id;
		Integer idPeriodoAnterior = idPeriodoActual - 1;
		Periodo PeriodoActual   = Periodo.find.byId( (long) idPeriodoActual);
		Periodo PeriodoAnterior = Periodo.find.byId( (long) idPeriodoAnterior);


		String sql = ""
				+ "SELECT pl1.id, a.apellido nombre, a.cuit cuit, coalesce(periodo_anterior.total, 0) totalAnterior, coalesce(periodo_actual.total,0) totalActual, coalesce(guardias.total,0) totalGuardia "
				+ "FROM puestos_laborales pl1  "
				+ "left join ( "
							+ "	select sum(ld.importe*ld.cantidad*(case when lc.liquidacion_concepto_tipo_id = 3 then -1 else 1 end)) total, lp.puesto_laboral_id  from liquidacion_detalles ld "
							+ "	join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id  "
							+ "	join liquidacion_puestos lp on ld.liquidacion_puesto_id = lp.id "
							+ "	join liquidacion_meses lm on lp.liquidacion_mes_id = lm.id "
							+ "	where lc.fijo is true and lm.periodo_id = :periodoAnterior and lm.liquidacion_tipo_id in (1,3) "
							+ "	group by lp.puesto_laboral_id "
					+ "	) as periodo_anterior on periodo_anterior.puesto_laboral_id = pl1.id "
							+ "left join ( "
							+ "	select sum(ld.importe*ld.cantidad*(case when lc.liquidacion_concepto_tipo_id = 3 then -1 else 1 end)) total, puesto_laboral_id from liquidacion_detalles ld "
							+ "	join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id  "
							+ "	join liquidacion_puestos lp on ld.liquidacion_puesto_id = lp.id "
							+ "	join liquidacion_meses lm on lp.liquidacion_mes_id = lm.id "
							+ "	where lc.fijo is true and lm.periodo_id = :periodoActual "
							+ "	and lm.liquidacion_tipo_id in (1,3)  "
							+ "	group by lp.puesto_laboral_id "
					+ "	) as periodo_actual on  periodo_actual.puesto_laboral_id = pl1.id "
							+ "left join ( "
							+ "	select sum(ld.importe*ld.cantidad) total, puesto_laboral_id from liquidacion_detalles ld "
							+ "	join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id  "
							+ "	join liquidacion_puestos lp on ld.liquidacion_puesto_id = lp.id "
							+ "	join liquidacion_meses lm on lp.liquidacion_mes_id = lm.id "
							+ "	where lc.fijo is not true and lm.periodo_id = :periodoActual "
							+ "	and lm.liquidacion_tipo_id in (1,3) and lc.id <> 366 "
							+ "	group by lp.puesto_laboral_id "
					+ ") guardias on guardias.puesto_laboral_id = pl1.id  "
						+ "join legajos l on pl1.legajo_id = l.id "
						+ "join agentes a on l.agente_id = a.id "
						+ "where pl1.activo is true AND convenio_ministerio = :convenioMinisterio "
				+ "group by pl1.id, a.apellido, a.cuit, periodo_anterior.total, periodo_actual.total, guardias.total "
				+ "order by a.apellido ";

		List<SqlRow> row = Ebean.createSqlQuery(sql).setParameter("periodoActual", idPeriodoActual).setParameter("periodoAnterior", idPeriodoAnterior).setParameter("convenioMinisterio", LMActual.convenio_ministerio).findList();



		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_puesto.xls");

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

			Sheet hoja = libro.createSheet("Comparativo");
			Cell celda0;
			Row fila = hoja.createRow(1);

			celda0 = fila.createCell(1);
			celda0.setCellValue("Cuit");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(2);
			celda0.setCellValue(PeriodoAnterior.nombre);
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(3);
			celda0.setCellValue(PeriodoActual.nombre);
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(4);
			celda0.setCellValue("Guardia mes actual");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(5);
			celda0.setCellValue("Diferencia (Actual - Anterior)");
			celda0.setCellStyle(comun);

			int x = 2;
			for (SqlRow r : row) {

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue(r.getString("nombre"));
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue(r.getString("cuit"));
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellValue(r.getDouble("totalAnterior"));
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(3);
				celda0.setCellValue(r.getDouble("totalActual"));
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(4);
				celda0.setCellValue(r.getDouble("totalGuardia"));
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(5);
				celda0.setCellValue(r.getDouble("totalActual") - r.getDouble("totalAnterior"));
				celda0.setCellStyle(estiloMoneda);

				x++;
			}

			libro.write(archivoTmp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(archivo);
	}

	public static Result listadoDePuestoLaboral(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_puesto.xls");

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

			Sheet hoja = libro.createSheet("Seguro de Vida");

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral")
			.fetch("puestoLaboral.legajo")
			.fetch("puestoLaboral.legajo.agente")
			.where().eq("liquidacion_mes_id", id).orderBy("puestoLaboral.legajo.agente.apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Datos");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(5);
				celda0.setCellValue("Cantidad hijos");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(6);
				celda0.setCellValue("Discapacitados");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(7);
				celda0.setCellValue("Edades");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(8);
				celda0.setCellValue("Total");
				celda0.setCellStyle(comun);
				x++;

				BigDecimal total =  new BigDecimal(0);
				for (LiquidacionPuesto l: lp) {

					List<LiquidacionDetalle> lx = new LiquidacionDetalle().find
							.fetch("liquidacionConcepto")
							.where()
							.eq("liquidacion_puesto_id", l.id).findList();

					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(utils.NumberUtils.moneda(l.getTotalCA()));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellValue(utils.NumberUtils.moneda(l.getTotalSA()));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(4);
					celda0.setCellValue(utils.NumberUtils.moneda(l.getTotalRetenciones()));
					celda0.setCellStyle(comun);


					String sql = "select coalesce(count(*),0),extract(year from age(now(), h.fnacimiento)) edad,discapacidad "+
				   "from agente_familias h  "+
		   		   "where h.tipo_familia_id = 1 and h.agente_id in (select a.id from liquidacion_puestos lp "+
                   "inner join puestos_laborales p on p.id=lp.puesto_laboral_id  "+
                   "inner join legajos l on l.id = p.legajo_id  "+
                   "inner join agentes a on a.id = l.agente_id  "+
                   "where p.id = :puesto)  "+
                   "group by h.agente_id,extract(year from age(now(), h.fnacimiento)),discapacidad  ";

					List<SqlRow> row = Ebean.createSqlQuery(sql).setParameter("puesto", l.puestoLaboral.id).findList();

					int cantidad_hijos = 0;
					int total_cantidad_hijos = 0;
					String edades = "";
					int discapacitados = 0;

					for(SqlRow sr : row){

						if(sr.getBoolean("discapacidad")){
							discapacitados  ++;
						}else{
							cantidad_hijos ++;
						}
						total_cantidad_hijos ++;

						edades += sr.getInteger("edad")+" | ";
					}

					celda0 = fila.createCell(5);
					celda0.setCellValue(cantidad_hijos);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(6);
					celda0.setCellValue(discapacitados);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(7);
					celda0.setCellValue(edades);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(8);
					celda0.setCellValue(total_cantidad_hijos);
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

	public static Result controlDescuentosBasicos(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/control_descuentos_basicos.xls");

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

			Sheet hoja = libro.createSheet("Seguro de Vida");

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral")
			.fetch("puestoLaboral.legajo")
			.fetch("puestoLaboral.legajo.agente")
			.where().eq("liquidacion_mes_id", id).orderBy("puestoLaboral.legajo.agente.apellido").findList();

			if(lp.size() > 0){
				int x = 0;
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue("Datos");
				celda0.setCellStyle(comun);
				x++;

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Nombre");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Cuil");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Haber Con Aporte");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(4);
				celda0.setCellValue("Jubilacion Calculada");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("19%");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(6);
				celda0.setCellValue("Diferencia");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(9);
				celda0.setCellValue("OB Calculada");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(10);
				celda0.setCellValue("5%");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(11);
				celda0.setCellValue("Diferencia");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(13);
				celda0.setCellValue("Sepelio Calculado");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(14);
				celda0.setCellValue("0.0385%");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(15);
				celda0.setCellValue("Diferencia");
				celda0.setCellStyle(comun);



				x++;
				BigDecimal total =  new BigDecimal(0);
				BigDecimal totalJubilacion1 =  new BigDecimal(0);
				BigDecimal totalJubilacion2 =  new BigDecimal(0);
				BigDecimal totalJubilacion3 =  new BigDecimal(0);

				BigDecimal totalOb1 =  new BigDecimal(0);
				BigDecimal totalOb2 =  new BigDecimal(0);
				BigDecimal totalOb3 =  new BigDecimal(0);

				BigDecimal totalSepelio1 =  new BigDecimal(0);
				BigDecimal totalSepelio2 =  new BigDecimal(0);
				BigDecimal totalSepelio3 =  new BigDecimal(0);

				for (LiquidacionPuesto l: lp) {

					List<LiquidacionDetalle> lx = new LiquidacionDetalle().find
							.fetch("liquidacionConcepto")
							.where()
							.eq("liquidacion_puesto_id", l.id).findList();
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.apellido);
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(l.puestoLaboral.legajo.agente.cuit);
					celda0.setCellStyle(comun);



					for (LiquidacionDetalle ld: lx) {

						if(ld != null){

							total = total.add(ld.importe);
							celda0 = fila.createCell(2);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(l.getTotalCA().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							celda0.setCellStyle(estiloMoneda);


							if(ld.liquidacion_concepto_id.equals(LiquidacionConcepto.JUBILACION)){

								celda0 = fila.createCell(4);
								celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
								celda0.setCellValue(ld.importe.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
								celda0.setCellStyle(estiloMoneda);
								totalJubilacion1 = totalJubilacion1.add(ld.importe);

								celda0 = fila.createCell(5);
								celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
								celda0.setCellValue(l.getTotalCA().multiply(new BigDecimal(0.19)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
								celda0.setCellStyle(estiloMoneda);
								totalJubilacion2 = totalJubilacion2.add(l.getTotalCA().multiply(new BigDecimal(0.19)));

								celda0 = fila.createCell(6);
								celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
								celda0.setCellValue(ld.importe.subtract(l.getTotalCA().multiply(new BigDecimal(0.19))).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
								celda0.setCellStyle(estiloMoneda);
								totalJubilacion3 = totalJubilacion3.add(ld.importe.subtract(l.getTotalCA().multiply(new BigDecimal(0.19))));
							}

							if(ld.liquidacion_concepto_id.equals(LiquidacionConcepto.OB)){

								celda0 = fila.createCell(9);
								celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
								celda0.setCellValue(ld.importe.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
								celda0.setCellStyle(estiloMoneda);
								totalOb1 = totalOb1.add(ld.importe);

								celda0 = fila.createCell(10);
								celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
								celda0.setCellValue(l.getTotalCA().multiply(new BigDecimal(0.05)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
								celda0.setCellStyle(estiloMoneda);
								totalOb2 = totalOb2.add(l.getTotalCA().multiply(new BigDecimal(0.05)));

								celda0 = fila.createCell(11);
								celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
								celda0.setCellValue(ld.importe.subtract(l.getTotalCA().multiply(new BigDecimal(0.05))).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
								celda0.setCellStyle(estiloMoneda);
								totalOb3 = totalOb3.add(ld.importe.subtract(l.getTotalCA().multiply(new BigDecimal(0.05))));
							}

							if(ld.liquidacion_concepto_id.equals(LiquidacionConcepto.SEGURO_DE_SEPELIO)){

								celda0 = fila.createCell(13);
								celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
								celda0.setCellValue(ld.importe.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
								celda0.setCellStyle(estiloMoneda);
								totalSepelio1 = totalSepelio1.add(ld.importe);

								celda0 = fila.createCell(14);
								celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
								celda0.setCellValue(l.getTotalCA().multiply(new BigDecimal(0.00385)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
								celda0.setCellStyle(estiloMoneda);
								totalSepelio2 = totalSepelio2.add(l.getTotalCA().multiply(new BigDecimal(0.00385)).setScale(2, BigDecimal.ROUND_HALF_UP));

								celda0 = fila.createCell(15);
								celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
								celda0.setCellValue(ld.importe.subtract(l.getTotalCA().multiply(new BigDecimal(0.00385))).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
								celda0.setCellStyle(estiloMoneda);
								totalSepelio3 = totalSepelio3.add(ld.importe.subtract(l.getTotalCA().multiply(new BigDecimal(0.00385)).setScale(2, BigDecimal.ROUND_HALF_UP)));
							}


						}
					}
					x++;
				}

				fila = hoja.createRow(x);
				celda0 = fila.createCell(1);
				celda0.setCellValue("TOTAL");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(2);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(4);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalJubilacion1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(5);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalJubilacion2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(6);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalJubilacion3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(9);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalOb1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(10);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalOb2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(11);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalOb3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);

				celda0 = fila.createCell(13);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalSepelio1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(14);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalSepelio2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(15);
				celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda0.setCellValue(totalSepelio3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
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


	public static Result listadoGeneral(Long id) {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/listado_general.xls");

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


			/*Sheet hoja;
			List<Organigrama> o = new Organigrama().find.where().eq("tipo_id",1).findList();

			for(Organigrama o1 : o){
				Logger.debug("-"+o1.nombre);
				List<Organigrama> o2 = new Organigrama().find.where().eq("padre_id",o1.id).findList();
				if(o2.size() > 0){
					for(Organigrama ol2 : o2){
						Logger.debug("--"+ol2.nombre);

						hoja = libro.createSheet(ol2.nombre);


						List<Organigrama> o3 = new Organigrama().find.where().eq("padre_id",ol2.id).findList();
						if(o3.size() > 0){
							for(Organigrama ol3 : o3){
								Logger.debug("---"+ol3.nombre);

								hoja = libro.createSheet(ol3.nombre);

								List<Organigrama> o4 = new Organigrama().find.where().eq("padre_id",ol3.id).findList();
								if(o4.size() > 0){
									for(Organigrama ol4 : o4){
										Logger.debug("----"+ol4.nombre);

										hoja = libro.createSheet(ol4.nombre);


										List<Organigrama> o5 = new Organigrama().find.where().eq("padre_id",ol4.id).findList();
										if(o5.size() > 0){
											for(Organigrama ol5 : o5){
												Logger.debug("-----"+ol5.nombre);
												List<Organigrama> o6 = new Organigrama().find.where().eq("padre_id",ol5.id).findList();
												if(o6.size() > 0){
													for(Organigrama ol6 : o6){
														Logger.debug("------"+ol6.nombre);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}*/





			Sheet hoja = libro.createSheet("LISTADO");

			List<LiquidacionPuesto> lp = new LiquidacionPuesto()
			.find
			.fetch("puestoLaboral")
			.fetch("puestoLaboral.legajo")
			.fetch("puestoLaboral.legajo.agente")
			.fetch("puestoLaboral.legajo.agente.organigrama")
			.where().eq("liquidacion_mes_id", id).isNotNull("puestoLaboral.legajo.agente.organigrama_id")//.eq("puestoLaboral.categoria_laboral_id", 24)
			.orderBy("puestoLaboral.legajo.agente.organigrama.nombre,puestoLaboral.legajo.agente.apellido").findList();


			Map<String,Map<String,String>> mapGeneral = new HashMap<String,Map<String,String>>();
			Map<Integer,String> mapColumnas = new HashMap<Integer,String>();
			mapColumnas.put(1, "SERVICIO");
			mapColumnas.put(2, "NOMBRE");
			mapColumnas.put(3, "TOTAL CONTRATO");
			int y = 3;
			for (LiquidacionPuesto l: lp) {

				Map<String,String> datos = new HashMap<String,String>();
				datos.put("SERVICIO", l.puestoLaboral.legajo.agente.organigrama.nombre);
				datos.put("NOMBRE", l.puestoLaboral.legajo.agente.apellido);


				List<LiquidacionDetalle> lx = new LiquidacionDetalle()
				.find.fetch("liquidacionConcepto").where().eq("liquidacion_puesto_id", l.id).orderBy("liquidacionConcepto.orden asc")
				.findList();

				for (LiquidacionDetalle ld: lx) {

					if(!mapColumnas.containsValue(ld.liquidacionConcepto.denominacion)){
						mapColumnas.put(y, ld.liquidacionConcepto.denominacion);
						y++;
					}
					BigDecimal total = ld.cantidad.multiply(ld.importe);

					if(ld.liquidacionConcepto.liquidacionConceptoTipo.id.compareTo(new Long(3)) == 0){
						total = total.multiply(new BigDecimal(-1));
					}
					datos.put(ld.liquidacionConcepto.denominacion, total.toString());
				}

				mapGeneral.put(l.puestoLaboral.legajo.agente.organigrama.nombre+l.puestoLaboral.legajo.agente.apellido+l.id.toString(), datos);
			}


			Map<String,Map<String,String>> map = new TreeMap<String,Map<String,String>>(mapGeneral);

			int z = 0;
			int x = 0;

			Row fila = hoja.createRow(0);
			Cell celda0 = fila.createCell(0);



			fila = hoja.createRow(x);
			for(Map.Entry<Integer,String> entryColumnas : mapColumnas.entrySet()){
				Logger.debug("------------- "+entryColumnas.getValue());

				celda0 = fila.createCell(z);
				celda0.setCellValue(entryColumnas.getValue());
				celda0.setCellStyle(comun);
				z++;


			}

			x++;


			for (Map.Entry<String,Map<String,String>> entry : map.entrySet()) {
				//System.out.println(entry.getKey() + "/" + entry.getValue());
				z = 0;
				fila = hoja.createRow(x);
				for(Map.Entry<Integer,String> entryColumnas : mapColumnas.entrySet()){
					celda0 = fila.createCell(z);

					String valor = entry.getValue().get(entryColumnas.getValue());

					try{
						celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda0.setCellValue(new Double(valor));
						celda0.setCellStyle(estiloMoneda);
					}catch(Exception e){
						celda0.setCellValue(valor);
						celda0.setCellStyle(comun);
					}

					/*
					if(entry.getKey().compareToIgnoreCase("SERVICIO") == 0 || entry.getKey().compareToIgnoreCase("NOMBRE") == 0 || entry.getKey().compareToIgnoreCase("TOTAL CONTRATO") == 0){
						celda0.setCellValue(valor);
						celda0.setCellStyle(comun);
					}else{

					}*/
					z++;
				}
				x++;
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
