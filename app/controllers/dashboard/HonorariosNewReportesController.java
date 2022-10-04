package controllers.dashboard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import models.Periodo;
import models.haberes.LiquidacionMes;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.SqlRow;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.haberes.puestosLaborales.respuestaModal;
import views.html.haberes.puestosLaborales.reportes.descargarArchivo;

public class HonorariosNewReportesController extends Controller  {
	
	public static Result informeHonorarioPorPeriodo() {
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/Listado.xls");	
		
		List<Periodo> lp = Periodo.find.where().eq("ejercicio_id",4).le("date_start",new Date()).order("id asc").findList(); 
		
		 
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
			
			int x = 0;
			Row fila = hoja.createRow(x);
			
			fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("");
			celda0.setCellStyle(comun);
			
			
			x++;
			
			/***************************************************************/
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("Cantidad Agentes");
			celda0.setCellStyle(comun);
			int z = 0;
			int y = 0;
			
			x++;
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(z);
			celda0.setCellValue("Tipo /Periodo");
			celda0.setCellStyle(comun);
			z++;
			
			for(Periodo p : lp){
				celda0 = fila.createCell(z);
				celda0.setCellValue(p.nombre);
				celda0.setCellStyle(comun);
				z++;
			}	
			
			x++;
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("PS");
			celda0.setCellStyle(comun);
			x++;
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("CM");
			celda0.setCellStyle(comun);
			
			
			z=1;
			for(Periodo p : lp){
				List<SqlRow> lsTmp = LiquidacionMes.getCountRelacionPorPeriodo(p.id);
				if(lsTmp.size() > 0){
					play.Logger.debug("xxxxxx "+lsTmp);
					for(SqlRow sr:lsTmp){
						celda0 = fila.createCell(z);
						celda0.setCellValue("CM");
						celda0.setCellStyle(comun);
						
					}
				}
				z++;
			}
			
			 
			
			
			/***************************************************************/
			
			
			
			libro.write(archivoTmp); 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(descargarArchivo.render(archivo.getPath()));
	}
}
