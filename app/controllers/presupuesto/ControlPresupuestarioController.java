package controllers.presupuesto;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;

import akka.event.slf4j.Logger;
import models.ActaRecepcion;
import models.BalancePresupuestario;
import models.Ejercicio;
import models.Factura;
import models.OrdenLineaAjuste;
import models.informes.InformeEstadisticoDeudaProveedores;
import controllers.Secured;
import groovy.util.logging.Log;
import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import scala.collection.parallel.ParIterableLike.Find;
import utils.DateUtils;
import utils.RequestVar;
import views.html.presupuesto.controlPresupuestario.*;

@Security.Authenticated(Secured.class)
public class ControlPresupuestarioController extends Controller {
	
	public static Result controlAnulacionProductosAutomaticosExcel() {
		
		
		
		ExpressionList<OrdenLineaAjuste> e = OrdenLineaAjuste.find.where();
		
		if(!RequestVar.get("fecha_desde").isEmpty() || !RequestVar.get("fecha_hasta").isEmpty()){
			if(!RequestVar.get("fecha_desde").isEmpty()){
				Date fod = DateUtils.formatDate(RequestVar.get("fecha_desde"), "dd/MM/yyyy");
	    		e.ge("create_date", fod);
			}
			
			if(!RequestVar.get("fecha_hasta").isEmpty()){
				Date foh = DateUtils.formatDate(RequestVar.get("fecha_hasta"), "dd/MM/yyyy");
				e.le("create_date", foh);
			}
		}else{
			SimpleDateFormat sm = new SimpleDateFormat("dd/mm/yyyy");
		    String strDate = sm.format(new Date());
		    Date dt;
			try {
				dt = sm.parse(strDate);
				e.ge("create_date", dt);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(!RequestVar.get("expediente.id").isEmpty()){
			e.eq("orden.expediente_id", Integer.parseInt(RequestVar.get("expediente.id")));
		}
		
		if(!RequestVar.get("auto").isEmpty() && RequestVar.get("auto").compareTo("SI") == 0){
			e.eq("ajuste_automatico", true);
		}
		
		if(!RequestVar.get("ejercicio").isEmpty()){
			e.eq("orden.expediente.ejercicio_id", Integer.parseInt(RequestVar.get("ejercicio")));
		}
		
		e.orderBy("orden.id,orden.expediente_id,cuenta_analitica_id");
		
		List<OrdenLineaAjuste> el = e.findList();
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/control_ajustes_automaticos.xls");
		
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
			
			Sheet hoja = libro.createSheet("Ajustes Automaticos");
			
			int x = 0;
			Row fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Fecha");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(1);
			celda0.setCellValue("Usuario");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(2);
			celda0.setCellValue("Orden");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(3);
			celda0.setCellValue("OP");
			celda0.setCellStyle(style);

			celda0 = fila.createCell(4);
			celda0.setCellValue("Expediente");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(5);
			celda0.setCellValue("Cuenta");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(6);
			celda0.setCellValue("Producto");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(7);
			celda0.setCellValue("Cantidad");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(8);
			celda0.setCellValue("Precio");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(9);
			celda0.setCellValue("Total");
			celda0.setCellStyle(style);
			
			celda0 = fila.createCell(10);
			celda0.setCellValue("Nota");
			celda0.setCellStyle(style);
			x++;
			
			for(OrdenLineaAjuste p :el){
				
				
				fila = hoja.createRow(x);
				Cell celda = fila.createCell(0);
				celda.setCellValue((p.create_date != null)?utils.DateUtils.formatDate(p.create_date):"");
				celda.setCellStyle(comun);
				
				celda = fila.createCell(1);
				celda.setCellValue((p.create_usuario != null)?p.create_usuario.nombre:"");
				celda.setCellStyle(comun);
				
				
				celda = fila.createCell(2);
				celda.setCellValue("ORD"+p.orden.id);
				celda.setCellStyle(comun);
				
				celda = fila.createCell(3);
				celda.setCellValue((p.orden.numero_orden_provision != null)?p.orden.numero_orden_provision.toString():"");
				celda.setCellStyle(comun);
				
				celda = fila.createCell(4);
				celda.setCellValue(p.orden.expediente.getExpedienteEjercicio());
				celda.setCellStyle(comun);
				
				celda = fila.createCell(5);
				celda.setCellValue(p.cuentaAnalitica.cuentaReporta.codigo +"-"+ p.cuentaAnalitica.cuentaReporta.nombre);
				celda.setCellStyle(comun);
				
				celda = fila.createCell(6);
				celda.setCellValue(p.producto.nombre);
				celda.setCellStyle(comun);
				
				celda = fila.createCell(7);
				celda.setCellValue(p.cantidad.toString());
				celda.setCellStyle(comun);
				
				celda = fila.createCell(8);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(p.precio.doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(9);
				celda.setCellType(Cell.CELL_TYPE_NUMERIC);
				celda.setCellValue(p.precio.multiply(p.cantidad).doubleValue());
				celda.setCellStyle(estiloMoneda);
				
				celda = fila.createCell(10);
				celda.setCellValue(p.nota);
				celda.setCellStyle(comun);
				x++;
				
			}
			 
			
			
			libro.write(archivoTmp);   
			  
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
		 
			
			return ok(archivo);
			
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
		
		return ok();
	}
	
	public static Result controlAnulacionProductosAutomaticos() {
		
		DynamicForm d = form().bindFromRequest();
		
		ExpressionList<OrdenLineaAjuste> e = OrdenLineaAjuste.find.where();
		
		if(!RequestVar.get("fecha_desde").isEmpty() || !RequestVar.get("fecha_hasta").isEmpty()){
			play.Logger.debug("1111111111111");
			if(!RequestVar.get("fecha_desde").isEmpty()){
				Date fod = DateUtils.formatDate(RequestVar.get("fecha_desde"), "dd/MM/yyyy");
	    		e.ge("create_date", fod);
			}
			
			if(!RequestVar.get("fecha_hasta").isEmpty()){
				Date foh = DateUtils.formatDate(RequestVar.get("fecha_hasta"), "dd/MM/yyyy");
				e.le("create_date", foh);
			}
		}else{
			
			
			
			play.Logger.debug("2222222222");
			SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		    String strDate = sm.format(new Date());
		    Date dt;
			
		    try {
				dt = sm.parse(strDate);
				e.eq("create_date", dt);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		    flash("error", "Debe Ingresa una fecha creacion desde hasta");
		    return ok(indexControlPresupuestario.render(null,d));
		}
		
		if(!RequestVar.get("expediente.id").isEmpty()){
			e.eq("orden.expediente_id", Integer.parseInt(RequestVar.get("expediente.id")));
		}
		
		if(!RequestVar.get("auto").isEmpty() && RequestVar.get("auto").compareTo("SI") == 0){
			e.eq("ajuste_automatico", true);
		}
		
		if(!RequestVar.get("ejercicio").isEmpty()){
			e.eq("orden.expediente.ejercicio_id", Integer.parseInt(RequestVar.get("ejercicio")));
		}
		
		e.orderBy("orden.id,orden.expediente_id,cuenta_analitica_id");
		
		List<OrdenLineaAjuste> el = e.findList();
		
		return ok(indexControlPresupuestario.render(el,d));
		
	}
	
	public static Result movimientosSaldoPreventivo() {
		DynamicForm d = form().bindFromRequest();
		
		
		List<SqlRow> ret = new ArrayList<SqlRow>();
		
		if(!RequestVar.get("cuenta_analitica_padre_id").isEmpty()){
			Integer idEjercicio = null;
			if(!RequestVar.get("ejercicio").isEmpty()){
				idEjercicio = new Integer(RequestVar.get("ejercicio"));
			}else{
				
				idEjercicio = Ejercicio.getEjercicioByFecha(new Date()).id.intValue();
			}
			
			Integer idCuenta = null;
			if(!RequestVar.get("cuenta_analitica_padre_id").isEmpty()){
				idCuenta = new Integer(RequestVar.get("cuenta_analitica_padre_id"));
			}
			
			
			ret = BalancePresupuestario.movimientosSaldoPreventivo(idEjercicio,idCuenta);
		}
		return ok(movimientosSaldoPreventivo.render(d,ret));
	}
	
	public static Result movimientosSaldoPreventivoExcel() {
		DynamicForm d = form().bindFromRequest();
		List<SqlRow> ret = new ArrayList<SqlRow>();
		
		Integer idEjercicio = null;
		if(!RequestVar.get("ejercicio").isEmpty()){
			idEjercicio = new Integer(RequestVar.get("ejercicio"));
		}else{
			
			idEjercicio = Ejercicio.getEjercicioByFecha(new Date()).id.intValue();
		}
		
		return ok(movimientosSaldoPreventivo.render(d,ret));
	}
}
