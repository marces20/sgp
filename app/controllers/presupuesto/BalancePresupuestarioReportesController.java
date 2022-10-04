package controllers.presupuesto;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import models.BalancePresupuestario;

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

import com.avaje.ebean.SqlRow;

import controllers.Secured;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import views.html.presupuesto.balancePresupuestario.reportes.*;

@Security.Authenticated(Secured.class)
public class BalancePresupuestarioReportesController extends Controller {
	
	public static Result modalReporteExportarDatosPresupuestoControl() {
		DynamicForm d = form().bindFromRequest();	
		return ok(modalReporteExportarDatosPresupuestoControl.render(null,d));
	}
	
	public static Result reporteExportarDatosPresupuestoControl() throws IOException {
		
		Integer id = 1;
		DynamicForm d = form().bindFromRequest();	
		Long idEjecicio = null;
		String[] idEjecicioStr = request().body().asFormUrlEncoded().get("ejercicio");
		
		if(idEjecicioStr == null) {
			flash("error", "Debe ingresar un ejercicio.");
			return ok(modalReporteExportarDatosPresupuestoControl.render(null,d));
		}else {
			idEjecicio = new Long(idEjecicioStr[0]);
		}
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/balance_presupuestario.xls");
		
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
			
			BigDecimal totalPreventivo = new BigDecimal(0);	
			BigDecimal saldoPreventivo = new BigDecimal(0);		
			BigDecimal totalDefinitivo = new BigDecimal(0);		
			BigDecimal saldoDefinitivo = new BigDecimal(0);		
			BigDecimal totalObligacion = new BigDecimal(0);		
			BigDecimal saldoObligacion = new BigDecimal(0);		
			BigDecimal totalPago = new BigDecimal(0);
			
			Sheet hoja = libro.createSheet("Balance Presupuestario");
			
			int x = 0;
			
			Row fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Exp.");
			celda0.setCellStyle(style);
			
			hoja.addMergedRegion(new  CellRangeAddress(
		            x, //first row (0-based)
		            x, //last row  (0-based)
		            0, //first column (0-based)
		            7  //last column  (0-based)
		    ));
			
			x++;
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(1);
			celda0.setCellValue("Preventivo");
			celda0.setCellStyle(style);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,1,2));
			
			 
			celda0 = fila.createCell(3);
			celda0.setCellValue("Definitivo");
			celda0.setCellStyle(style);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,3,4));
			 
			
			celda0 = fila.createCell(5);
			celda0.setCellValue("Obligacion");
			celda0.setCellStyle(style);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,5,6));
			
			 
			celda0 = fila.createCell(7);
			celda0.setCellValue("Pago");	
			celda0.setCellStyle(style); 
			x++;
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue((id == 1)?"Exp.":"");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(1);
			celda0.setCellValue("Total");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(2);
			celda0.setCellValue("Saldo");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(3);
			celda0.setCellValue("Total");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(4);
			celda0.setCellValue("Saldo");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(5);
			celda0.setCellValue("Total");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(6);
			celda0.setCellValue("Saldo");
			celda0.setCellStyle(style);
			celda0 = fila.createCell(7);
			celda0.setCellValue("Total");
			celda0.setCellStyle(style);
			
			
			x++;
			
			
			
			
			List<BalancePresupuestario> lbp = BalancePresupuestario.getControlDeudaPorEjercicio(idEjecicio.intValue());
			
			for (BalancePresupuestario l:  lbp) {
				if(BalancePresupuestario.tieneRP(l.expediente.id)) {
					
					fila = hoja.createRow(x);
					Cell celda = fila.createCell(0);
					celda.setCellValue(l.expediente.nombre+"-"+l.expedienteRp);
					celda.setCellStyle(comun);
					
					celda = fila.createCell(1);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.add(l.preventivo_rp).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPreventivo = totalPreventivo.add(l.preventivo.add(l.preventivo_rp));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					///////////////////////////////////////////////////////
					
					celda = fila.createCell(2);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.subtract(l.definitivo).add(l.preventivo_rp.subtract(l.definitivo_rp)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoPreventivo = saldoPreventivo.add(l.preventivo.subtract(l.definitivo).add(l.preventivo_rp.subtract(l.definitivo_rp)));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(3);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.add(l.definitivo_rp).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalDefinitivo = totalDefinitivo.add(l.definitivo.add(l.definitivo_rp));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////x
					celda = fila.createCell(4);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.subtract(l.obligacion).add(l.definitivo_rp.subtract(l.obligacion_rp)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoDefinitivo = saldoDefinitivo.add(l.definitivo.subtract(l.obligacion).add(l.definitivo_rp.subtract(l.obligacion_rp)));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////x
					celda = fila.createCell(5);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.add(l.obligacion_rp).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalObligacion = totalObligacion.add(l.obligacion.add(l.obligacion_rp));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////x
					celda = fila.createCell(6);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.subtract(l.pago).add(l.obligacion_rp.subtract(l.pago_rp)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoObligacion = saldoObligacion.add(l.obligacion.subtract(l.pago).add(l.obligacion_rp.subtract(l.pago_rp)));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////x
					celda = fila.createCell(7);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.pago != null){
						celda.setCellValue(l.pago.add(l.pago_rp).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPago = totalPago.add(l.pago.add(l.pago_rp));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					
				}else {
					fila = hoja.createRow(x);
					Cell celda = fila.createCell(0);
					celda.setCellValue(l.expediente.nombre);
					celda.setCellStyle(comun);
					
					celda = fila.createCell(1);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPreventivo = totalPreventivo.add(l.preventivo);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					///////////////////////////////////////////////////////
					
					celda = fila.createCell(2);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.subtract(l.definitivo).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoPreventivo = saldoPreventivo.add(l.preventivo.subtract(l.definitivo));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(3);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalDefinitivo = totalDefinitivo.add(l.definitivo);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(4);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.subtract(l.obligacion).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoDefinitivo = saldoDefinitivo.add(l.definitivo.subtract(l.obligacion));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(5);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalObligacion = totalObligacion.add(l.obligacion);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(6);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.subtract(l.pago).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoObligacion = saldoObligacion.add(l.obligacion.subtract(l.pago));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(7);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.pago != null){
						celda.setCellValue(l.pago.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPago = totalPago.add(l.pago);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
				}
				
				x++;
			}
			 
			
			fila = hoja.createRow(x);
			Cell celda = fila.createCell(0);
			celda.setCellValue("TOTALES");
			celda.setCellStyle(comun);
			
			celda = fila.createCell(1);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(totalPreventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			celda = fila.createCell(2);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(saldoPreventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			celda = fila.createCell(3);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(totalDefinitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			celda = fila.createCell(4);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(saldoDefinitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			celda = fila.createCell(5);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(totalObligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			celda = fila.createCell(6);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(saldoObligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			celda.setCellStyle(estiloMoneda);
			
			celda = fila.createCell(7);
			celda.setCellType(Cell.CELL_TYPE_NUMERIC);
			celda.setCellValue(totalPago.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			celda.setCellStyle(estiloMoneda);
				
				 
			 
			
			libro.write(archivoTmp); 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(modalReporteExportarDatosPresupuestoControl.render(archivo.getPath(),d));
	}
	
	
	public static Result modalReporteBalancePorFecha() {
		DynamicForm d = form().bindFromRequest();	
		
		return ok(modalReporteBalancePorFecha.render(null,null,d));
	}
	
	
	public static Result reporteBalancePorFecha() {
		DynamicForm d = form().bindFromRequest();	
		Date ffh = null;
		Date ffd = null;
		Date ffhd = null;
		Date ffdd = null;
		
		String[] fecha_desde_preventivo = request().body().asFormUrlEncoded().get("fecha_desde_preventivo");
		String[] fecha_hasta_preventivo = request().body().asFormUrlEncoded().get("fecha_hasta_preventivo");
		String[] fecha_desde_definitivo = request().body().asFormUrlEncoded().get("fecha_desde_definitivo");
		String[] fecha_hasta_definitivo = request().body().asFormUrlEncoded().get("fecha_hasta_definitivo");
		String[] idEjecicio = request().body().asFormUrlEncoded().get("ejercicio");
		
		if(!fecha_desde_preventivo[0].isEmpty() || !fecha_hasta_preventivo[0].isEmpty()){
			if(fecha_desde_preventivo == null && fecha_desde_preventivo[0].isEmpty()){
				flash("error", "Debe ingresar una fecha inicio preventivo.");
				return ok(modalReporteBalancePorFecha.render(null,null,d));
			}else{
				ffd = DateUtils.formatDate(fecha_desde_preventivo[0], "dd/MM/yyyy");
			}
			
			if(fecha_hasta_preventivo == null || fecha_hasta_preventivo[0].isEmpty()){
				flash("error", "Debe ingresar una fecha fin preventivo.");
				return ok(modalReporteBalancePorFecha.render(null,null,d));
			}else{
				ffh = DateUtils.formatDate(fecha_hasta_preventivo[0], "dd/MM/yyyy");
			}
		}
		
		if(!fecha_desde_definitivo[0].isEmpty()  || !fecha_hasta_definitivo[0].isEmpty()){
		
			if(fecha_desde_definitivo == null && fecha_desde_definitivo[0].isEmpty()){
				flash("error", "Debe ingresar una fecha inicio definitivo.");
				return ok(modalReporteBalancePorFecha.render(null,null,d));
			}else{
				ffdd = DateUtils.formatDate(fecha_desde_definitivo[0], "dd/MM/yyyy");
			}
			
			if(fecha_hasta_definitivo == null || fecha_hasta_definitivo[0].isEmpty()){
				flash("error", "Debe ingresar una fecha fin definitivo.");
				return ok(modalReporteBalancePorFecha.render(null,null,d));
			}else{
				ffhd = DateUtils.formatDate(fecha_hasta_definitivo[0], "dd/MM/yyyy");
			}
		}
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/balance_presupuestario.xls");
		
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
			
			Sheet hoja = libro.createSheet("Balance Presupuestario");
			
			//Map<Integer,String> lr = BalancePresupuestario.getCuentas(Integer.parseInt(idEjecicio[0]));
			
			int x = 0;
			//for (Entry<Integer, String> e:  lr.entrySet()) {
				
			List<SqlRow> s = BalancePresupuestario.getCuentas(Integer.parseInt(idEjecicio[0]));
			for (SqlRow xs:  s) {
					
				Integer key = xs.getInteger("cuenta_analitica_padre_id");
				String value = xs.getString("nombre");	
				
				//System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue(value);
				celda0.setCellStyle(style);
				
				hoja.addMergedRegion(new  CellRangeAddress(
			            x, //first row (0-based)
			            x, //last row  (0-based)
			            0, //first column (0-based)
			            7  //last column  (0-based)
			    ));
				
				x++;
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Preventivo");
				celda0.setCellStyle(style);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,1,2));
				
				celda0 = fila.createCell(3);
				celda0.setCellValue("Definitivo");
				celda0.setCellStyle(style);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,3,4));
				
				
				celda0 = fila.createCell(5);
				celda0.setCellValue("Obligacion");
				celda0.setCellStyle(style);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,5,6));
				
				 
				celda0 = fila.createCell(7);
				celda0.setCellValue("Pago");	
				celda0.setCellStyle(style); 
				x++;
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Exp.");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(6);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(7);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				
				
				x++;
				BigDecimal totalPreventivo = new BigDecimal(0);	
				BigDecimal saldoPreventivo = new BigDecimal(0);		
				BigDecimal totalDefinitivo = new BigDecimal(0);		
				BigDecimal saldoDefinitivo = new BigDecimal(0);		
				BigDecimal totalObligacion = new BigDecimal(0);		
				BigDecimal saldoObligacion = new BigDecimal(0);		
				BigDecimal totalPago = new BigDecimal(0);

				for (BalancePresupuestario l :BalancePresupuestario.getSaldosPorCuentaPorExpedientesFecha
						(Integer.parseInt(idEjecicio[0]),ffd,ffh,ffdd,ffhd,key)){
					
					fila = hoja.createRow(x);
					Cell celda = fila.createCell(0);
					celda.setCellValue(l.expediente.nombre);
					celda.setCellStyle(comun);
					
					celda = fila.createCell(1);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPreventivo = totalPreventivo.add(l.preventivo);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(2);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.subtract(l.definitivo).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoPreventivo = saldoPreventivo.add(l.preventivo.subtract(l.definitivo));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(3);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalDefinitivo = totalDefinitivo.add(l.definitivo);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(4);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.subtract(l.obligacion).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoDefinitivo = saldoDefinitivo.add(l.definitivo.subtract(l.obligacion));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(5);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalObligacion = totalObligacion.add(l.obligacion);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(6);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.subtract(l.pago).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoObligacion = saldoObligacion.add(l.obligacion.subtract(l.pago));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(7);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.pago != null){
						celda.setCellValue(l.pago.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPago = totalPago.add(l.pago);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					x++;
				}
				
				fila = hoja.createRow(x);
				Cell celda = fila.createCell(0);
				celda.setCellValue("TOTALES");
				celda.setCellStyle(comun);
				
				celda = fila.createCell(1);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalPreventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(2);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(saldoPreventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalDefinitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(4);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(saldoDefinitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(5);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalObligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(6);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(saldoObligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(7);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalPago.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
								
				x++;
				x++;
			 }
			
			libro.write(archivoTmp); 
			return ok(modalReporteBalancePorFecha.render(archivo.getPath(),null,d));
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(modalReporteBalancePorFecha.render(null,null,d));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(modalReporteBalancePorFecha.render(null,null,d));
		}
		
		
		
		 
	}	
	
	public static Result reporteBalancePorFechaPorExpediente() {
		DynamicForm d = form().bindFromRequest();	
		Date ffh = null;
		Date ffd = null;
		Date ffhd = null;
		Date ffdd = null;
		
		String[] fecha_desde_preventivo = request().body().asFormUrlEncoded().get("fecha_desde_preventivo");
		String[] fecha_hasta_preventivo = request().body().asFormUrlEncoded().get("fecha_hasta_preventivo");
		String[] fecha_desde_definitivo = request().body().asFormUrlEncoded().get("fecha_desde_definitivo");
		String[] fecha_hasta_definitivo = request().body().asFormUrlEncoded().get("fecha_hasta_definitivo");
		String[] idEjecicio = request().body().asFormUrlEncoded().get("ejercicio");
		
		if(!fecha_desde_preventivo[0].isEmpty() || !fecha_hasta_preventivo[0].isEmpty()){
			if(fecha_desde_preventivo == null && fecha_desde_preventivo[0].isEmpty()){
				flash("error", "Debe ingresar una fecha inicio preventivo.");
				return ok(modalReporteBalancePorFecha.render(null,null,d));
			}else{
				ffd = DateUtils.formatDate(fecha_desde_preventivo[0], "dd/MM/yyyy");
			}
			
			if(fecha_hasta_preventivo == null || fecha_hasta_preventivo[0].isEmpty()){
				flash("error", "Debe ingresar una fecha fin preventivo.");
				return ok(modalReporteBalancePorFecha.render(null,null,d));
			}else{
				ffh = DateUtils.formatDate(fecha_hasta_preventivo[0], "dd/MM/yyyy");
			}
		}
		
		if(!fecha_desde_definitivo[0].isEmpty()  || !fecha_hasta_definitivo[0].isEmpty()){
		
			if(fecha_desde_definitivo == null && fecha_desde_definitivo[0].isEmpty()){
				flash("error", "Debe ingresar una fecha inicio definitivo.");
				return ok(modalReporteBalancePorFecha.render(null,null,d));
			}else{
				ffdd = DateUtils.formatDate(fecha_desde_definitivo[0], "dd/MM/yyyy");
			}
			
			if(fecha_hasta_definitivo == null || fecha_hasta_definitivo[0].isEmpty()){
				flash("error", "Debe ingresar una fecha fin definitivo.");
				return ok(modalReporteBalancePorFecha.render(null,null,d));
			}else{
				ffhd = DateUtils.formatDate(fecha_hasta_definitivo[0], "dd/MM/yyyy");
			}
		}
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/balance_presupuestario.xls");
		
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
			
			Sheet hoja = libro.createSheet("Balance Presupuestario");
			
			//Map<Integer,String> lr = BalancePresupuestario.getCuentas(Integer.parseInt(idEjecicio[0]));
			
			int x = 0;
			//for (Entry<Integer, String> e:  lr.entrySet()) {
				
			 
					
				 
				//System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				//celda0.setCellValue(value);
				celda0.setCellStyle(style);
				
			 
				
				fila = hoja.createRow(x);
				
				celda0 = fila.createCell(0);
				celda0.setCellValue("Fecha");
				celda0.setCellStyle(style);
				
				celda0 = fila.createCell(1);
				celda0.setCellValue("Exp.");
				celda0.setCellStyle(style);
				
				celda0 = fila.createCell(2);
				celda0.setCellValue("Numero Cuenta");
				celda0.setCellStyle(style);
				
				celda0 = fila.createCell(3);
				celda0.setCellValue("Cuenta");
				celda0.setCellStyle(style);
				
				celda0 = fila.createCell(4);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(6);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(7);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(8);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(9);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(10);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				
				
				x++;
				BigDecimal totalPreventivo = new BigDecimal(0);	
				BigDecimal saldoPreventivo = new BigDecimal(0);		
				BigDecimal totalDefinitivo = new BigDecimal(0);		
				BigDecimal saldoDefinitivo = new BigDecimal(0);		
				BigDecimal totalObligacion = new BigDecimal(0);		
				BigDecimal saldoObligacion = new BigDecimal(0);		
				BigDecimal totalPago = new BigDecimal(0);

				for (BalancePresupuestario l :BalancePresupuestario.getSaldosPorCuentaPorExpedientesFecha
						(Integer.parseInt(idEjecicio[0]),ffd,ffh,ffdd,ffhd,null)){
					
					fila = hoja.createRow(x);
					
					Cell celda = fila.createCell(0);
					celda.setCellValue(utils.DateUtils.formatDate(l.create_date));
					celda.setCellStyle(comun);
					
					
					celda = fila.createCell(1);
					celda.setCellValue(l.expediente.nombre);
					celda.setCellStyle(comun);
					
					celda = fila.createCell(2);
					celda.setCellValue(l.codigo);
					celda.setCellStyle(comun);
					
					celda = fila.createCell(3);
					celda.setCellValue(l.nombre);
					celda.setCellStyle(comun);
					
					
					celda = fila.createCell(4);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPreventivo = totalPreventivo.add(l.preventivo);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(5);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.subtract(l.definitivo).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoPreventivo = saldoPreventivo.add(l.preventivo.subtract(l.definitivo));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(6);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalDefinitivo = totalDefinitivo.add(l.definitivo);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(7);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.subtract(l.obligacion).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoDefinitivo = saldoDefinitivo.add(l.definitivo.subtract(l.obligacion));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(8);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalObligacion = totalObligacion.add(l.obligacion);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(9);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.subtract(l.pago).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoObligacion = saldoObligacion.add(l.obligacion.subtract(l.pago));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					celda = fila.createCell(10);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.pago != null){
						celda.setCellValue(l.pago.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPago = totalPago.add(l.pago);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					x++;
				}
				
				 
								
				x++;
				x++;
			 
			
			libro.write(archivoTmp); 
			return ok(modalReporteBalancePorFecha.render(archivo.getPath(),null,d));
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(modalReporteBalancePorFecha.render(null,null,d));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(modalReporteBalancePorFecha.render(null,null,d));
		}
		
		
		
		 
	}
	
	public static Result modalReporteBalancePorCuentaPorExpediente(Integer id) {
		DynamicForm d = form().bindFromRequest();	
		return ok(modalReporteBalancePorCuentaPorExpediente.render(null,d,id));
	}
	
	public static Result reporteBalancePorCuentaPorExpediente(Integer id) throws IOException {
		
		DynamicForm d = form().bindFromRequest();	
		Long idEjecicio = null;
		String[] idEjecicioStr = request().body().asFormUrlEncoded().get("ejercicio");
		
		if(idEjecicioStr == null) {
			flash("error", "Debe ingresar un ejercicio.");
			return ok(modalReporteBalancePorCuentaPorExpediente.render(null,d,id));
		}else {
			idEjecicio = new Long(idEjecicioStr[0]);
		}
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/balance_presupuestario.xls");
		
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
			
			Sheet hoja = libro.createSheet("Balance Presupuestario");
			
			//Map<Integer,String> lr = BalancePresupuestario.getCuentas(idEjecicio.intValue());
			
			
			
			int x = 0;
			//for (Entry<Integer, String> e:  sorted.entrySet()) {
			List<SqlRow> s = BalancePresupuestario.getCuentas(idEjecicio.intValue());
			for (SqlRow xs:  s) {
				
				//System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
				
				Integer key = xs.getInteger("cuenta_analitica_padre_id");
				String value = xs.getString("nombre");
				
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue(value);
				celda0.setCellStyle(style);
				
				hoja.addMergedRegion(new  CellRangeAddress(
			            x, //first row (0-based)
			            x, //last row  (0-based)
			            0, //first column (0-based)
			            7  //last column  (0-based)
			    ));
				
				x++;
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Preventivo");
				celda0.setCellStyle(style);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,1,2));
				
				 
				celda0 = fila.createCell(3);
				celda0.setCellValue("Definitivo");
				celda0.setCellStyle(style);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,3,4));
				 
				
				celda0 = fila.createCell(5);
				celda0.setCellValue("Obligacion");
				celda0.setCellStyle(style);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,5,6));
				
				 
				celda0 = fila.createCell(7);
				celda0.setCellValue("Pago");	
				celda0.setCellStyle(style); 
				x++;
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue((id == 1)?"Exp.":"");
				celda0.setCellStyle(style);
				
				celda0 = fila.createCell(1);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(6);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(7);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				
				
				x++;
				BigDecimal totalPreventivo = new BigDecimal(0);	
				BigDecimal saldoPreventivo = new BigDecimal(0);		
				BigDecimal totalDefinitivo = new BigDecimal(0);		
				BigDecimal saldoDefinitivo = new BigDecimal(0);		
				BigDecimal totalObligacion = new BigDecimal(0);		
				BigDecimal saldoObligacion = new BigDecimal(0);		
				BigDecimal totalPago = new BigDecimal(0);
				
				int z = x;
				for (BalancePresupuestario l :BalancePresupuestario.getSaldosPorCuentaPorExpedientes(key,null,idEjecicio.intValue(),null,null)){
					
					fila = hoja.createRow(x);
					Cell celda = fila.createCell(0);
					celda.setCellValue(l.expediente.nombre);
					celda.setCellStyle(comun);
					
					celda = fila.createCell(1);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPreventivo = totalPreventivo.add(l.preventivo);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					///////////////////////////////////////////////////////
					
					celda = fila.createCell(2);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.preventivo != null){
						celda.setCellValue(l.preventivo.subtract(l.definitivo).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoPreventivo = saldoPreventivo.add(l.preventivo.subtract(l.definitivo));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(3);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalDefinitivo = totalDefinitivo.add(l.definitivo);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(4);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.definitivo != null){
						celda.setCellValue(l.definitivo.subtract(l.obligacion).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoDefinitivo = saldoDefinitivo.add(l.definitivo.subtract(l.obligacion));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(5);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalObligacion = totalObligacion.add(l.obligacion);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(6);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.obligacion != null){
						celda.setCellValue(l.obligacion.subtract(l.pago).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						saldoObligacion = saldoObligacion.add(l.obligacion.subtract(l.pago));
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					///////////////////////////////////////////////////////
					celda = fila.createCell(7);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					if(l.pago != null){
						celda.setCellValue(l.pago.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						totalPago = totalPago.add(l.pago);
					}else{
						celda.setCellValue(new Float(0));
					}
					celda.setCellStyle(estiloMoneda);
					
					if(id == 2) {
						fila = hoja.createRow(x);
						celda = fila.createCell(0);
						celda = fila.createCell(1);
						celda = fila.createCell(2);
						celda = fila.createCell(3);
						celda = fila.createCell(4);
						celda = fila.createCell(5);
						celda = fila.createCell(6);
						celda = fila.createCell(7);
					}
					
					x++;
				}
				 
				if(id == 2) {
					x = z;
				}
				
				fila = hoja.createRow(x);
				Cell celda = fila.createCell(0);
				celda.setCellValue("TOTALES");
				celda.setCellStyle(comun);
				
				celda = fila.createCell(1);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalPreventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(2);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(saldoPreventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalDefinitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(4);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(saldoDefinitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(5);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalObligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(6);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(saldoObligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(7);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalPago.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				 
				x++;
				x++;
			 }
			
			libro.write(archivoTmp); 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(modalReporteBalancePorCuentaPorExpediente.render(archivo.getPath(),d,id));
	}
	
	
	public static Result reporteBalanceDiferenciaPreventivoDefinitivo(Long idEjecicio) throws IOException {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/balance_presupuestario.xls");
		
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
			
			Sheet hoja = libro.createSheet("Balance Presupuestario");
			int x = 0;
			
			//Map<Integer,String> lr = BalancePresupuestario.getCuentas(idEjecicio.intValue());
			
			//for (Entry<Integer, String> e:  lr.entrySet()) {
			
			List<SqlRow> s = BalancePresupuestario.getCuentas(idEjecicio.intValue());
			for (SqlRow xs:  s) {
				
				//System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
				
				Integer key = xs.getInteger("cuenta_analitica_padre_id");
				String value = xs.getString("nombre");
				
				Row fila = hoja.createRow(x);
				Cell celda0 = fila.createCell(0);
				//celda0.setCellValue(e.getValue());
				celda0.setCellValue(value);
				celda0.setCellStyle(style);
				
				hoja.addMergedRegion(new  CellRangeAddress(
			            x, //first row (0-based)
			            x, //last row  (0-based)
			            0, //first column (0-based)
			            7  //last column  (0-based)
			    ));
				
				x++;
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Preventivo");
				celda0.setCellStyle(style);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,1,2));
				
				celda0 = fila.createCell(3);
				celda0.setCellValue("Definitivo");
				celda0.setCellStyle(style);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,3,4));
				
				
				celda0 = fila.createCell(5);
				celda0.setCellValue("Obligacion");
				celda0.setCellStyle(style);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,5,6));
				
				 
				celda0 = fila.createCell(7);
				celda0.setCellValue("Pago");	
				celda0.setCellStyle(style); 
				x++;
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Exp.");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(1);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(2);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(5);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(6);
				celda0.setCellValue("Saldo");
				celda0.setCellStyle(style);
				celda0 = fila.createCell(7);
				celda0.setCellValue("Total");
				celda0.setCellStyle(style);
				
				
				x++;
				
				BigDecimal totalPreventivo = new BigDecimal(0);	
				BigDecimal saldoPreventivo = new BigDecimal(0);		
				BigDecimal totalDefinitivo = new BigDecimal(0);		
				BigDecimal saldoDefinitivo = new BigDecimal(0);		
				BigDecimal totalObligacion = new BigDecimal(0);		
				BigDecimal saldoObligacion = new BigDecimal(0);		
				BigDecimal totalPago = new BigDecimal(0);
				
				for (BalancePresupuestario l :BalancePresupuestario.getSaldosPorCuentaPorExpedientes(key,null,idEjecicio.intValue(),null,null)){
					if(l.preventivo.subtract(l.definitivo).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() != 0){
						fila = hoja.createRow(x);
						Cell celda = fila.createCell(0);
						celda.setCellValue(l.expediente.nombre);
						celda.setCellStyle(comun);
						
						celda = fila.createCell(1);
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						if(l.preventivo != null){
							celda.setCellValue(l.preventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							totalPreventivo = totalPreventivo.add(l.preventivo);
						}else{
							celda.setCellValue(new Float(0));
						}
						celda.setCellStyle(estiloMoneda);
						
						celda = fila.createCell(2);
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						if(l.preventivo != null){
							celda.setCellValue(l.preventivo.subtract(l.definitivo).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							saldoPreventivo = saldoPreventivo.add(l.preventivo.subtract(l.definitivo));
						}else{
							celda.setCellValue(new Float(0));
						}
						celda.setCellStyle(estiloMoneda);
						
						celda = fila.createCell(3);
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						if(l.definitivo != null){
							celda.setCellValue(l.definitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							totalDefinitivo = totalDefinitivo.add(l.definitivo);
						}else{
							celda.setCellValue(new Float(0));
						}
						celda.setCellStyle(estiloMoneda);
						
						celda = fila.createCell(4);
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						if(l.definitivo != null){
							celda.setCellValue(l.definitivo.subtract(l.obligacion).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							saldoDefinitivo = saldoDefinitivo.add(l.definitivo.subtract(l.obligacion));
						}else{
							celda.setCellValue(new Float(0));
						}
						celda.setCellStyle(estiloMoneda);
						
						celda = fila.createCell(5);
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						if(l.obligacion != null){
							celda.setCellValue(l.obligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							totalObligacion = totalObligacion.add(l.obligacion);
						}else{
							celda.setCellValue(new Float(0));
						}
						celda.setCellStyle(estiloMoneda);
						
						celda = fila.createCell(6);
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						if(l.obligacion != null){
							celda.setCellValue(l.obligacion.subtract(l.pago).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							saldoObligacion = saldoObligacion.add(l.obligacion.subtract(l.pago));
						}else{
							celda.setCellValue(new Float(0));
						}
						celda.setCellStyle(estiloMoneda);
						
						celda = fila.createCell(7);
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						if(l.pago != null){
							celda.setCellValue(l.pago.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							totalPago = totalPago.add(l.pago);
						}else{
							celda.setCellValue(new Float(0));
						}
						celda.setCellStyle(estiloMoneda);
						
						x++;
					}
				}
				
				fila = hoja.createRow(x);
				Cell celda = fila.createCell(0);
				celda.setCellValue("TOTALES");
				celda.setCellStyle(comun);
				
				celda = fila.createCell(1);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalPreventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(2);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(saldoPreventivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(3);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalDefinitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(4);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(saldoDefinitivo.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(5);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalObligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(6);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(saldoObligacion.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(7);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(totalPago.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				celda.setCellStyle(estiloMoneda);
				x++;
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
}
