package controllers.dashboard;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import models.ActaRecepcion;
import models.Deposito;
import models.Periodo;
import models.Proveedor;

import models.informes.InformeDeudaProveedoresMaterializada;

import models.TipoCuenta;
import models.Usuario;

import com.avaje.ebean.SqlRow;

import controllers.Secured;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.ReportesExcelsUtils;
import views.html.dashboard.deudasGlobalizadas.*;

@Security.Authenticated(Secured.class)
public class DeudasGlobalizadasReportesController extends Controller {
	
	public static Result deudasInformeGeneralResumen(boolean soloDeuda) {
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		DynamicForm d = form().bindFromRequest();
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-GENERAL-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			
			Sheet hoja = getDeudasResumidasSheet(libro,0,false,false,soloDeuda);
			
			//---------------------------------------------------
			hoja = getDeudasDetallesOtrosProveedoresResumenSheet(libro,false,false);
			hoja = getDeudasDetallesOtrosProveedoresResumenSheet(libro,true,false);
			hoja = getDeudasServiciosProveedoresResumenSheet(libro);
			hoja = getDeudasHonorariosProveedoresResumenSheet(libro);
						
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}
	
	
	public static Result deudasInformeGeneral(boolean soloDeuda) {
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		DynamicForm d = form().bindFromRequest();
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-GENERAL-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			
			Sheet hoja = getDeudasResumidasSheet(libro,0,false,true,soloDeuda);
			hoja = getDeudasResumidasSheet(libro,Deposito.HEARM,false,true,soloDeuda);
			hoja = getDeudasResumidasSheet(libro,-1,false,true,soloDeuda);
			hoja = getDeudasResumidasSheet(libro,0,true,true,soloDeuda);
			
			//---------------------------------------------------
			hoja = getDeudasDetallesSheet(libro,0,true,soloDeuda);
			hoja = getDeudasDetallesSheet(libro,1530,false,soloDeuda);
			hoja = getDeudasDetallesSheet(libro,4359,false,soloDeuda);
			hoja = getDeudasDetallesSheet(libro,2749,false,soloDeuda);
			hoja = getDeudasDetallesSheet(libro,15156,false,soloDeuda);
			//hoja = getDeudasDetallesSheet(libro,1498,false);
			hoja = getDeudasDetallesSheet(libro,1589,false,soloDeuda);
			hoja = getDeudasDetallesSheet(libro,14733,false,soloDeuda);
			//---------------------------------------------------
			hoja = getDeudasDetallesOtrosSheet(libro,false,false,soloDeuda);
			hoja = getDeudasDetallesOtrosSheet(libro,false,true,soloDeuda);
			hoja = getDeudasDetallesOtrosSheet(libro,true,false,soloDeuda);
			hoja = getDeudasDetallesOtrosSheet(libro,true,true,soloDeuda);
			//----------------------------------------------------
			hoja = getDeudasDetallesServiciosSheet(libro);
			hoja = getDeudasDetallesHonorariosSheet(libro);
						
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}
	
	public static Result deudasCuentasReportes(Integer idCuenta,Boolean soloDeuda) {
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		TipoCuenta tc = TipoCuenta.find.byId(idCuenta.longValue());
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-CUENTAS-"+tc.nombre+"-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		DynamicForm d = form().bindFromRequest();
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			getDeudasCuentasSheet(libro,tc.nombre,idCuenta,soloDeuda);
				
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}
	
	public static Sheet getDeudasCuentasSheet(Workbook libro,String nombreCuenta,Integer idCuenta,Boolean soloDeuda){
		
		String cuenta = nombreCuenta;  
		
		List<SqlRow> listadoPorCuentaHEARM= InformeDeudaProveedoresMaterializada.getDeudaPorCuenta(idCuenta,(long)Deposito.HEARM,soloDeuda);
		List<SqlRow> listadoPorCuentaOtros= InformeDeudaProveedoresMaterializada.getDeudaPorCuenta(idCuenta,null,soloDeuda);
		
		Sheet hoja = libro.createSheet(cuenta);
		hoja.setColumnWidth(1, 3000);
		hoja.setColumnWidth(2, 3000);
		hoja.setColumnWidth(3, 15000);
		hoja.setColumnWidth(4, 4000);
		hoja.setColumnWidth(5, 4000);
		if(!soloDeuda) {
			hoja.setColumnWidth(6, 6000);
			hoja.setColumnWidth(7, 20000);
		}else {
			hoja.setColumnWidth(6, 20000);
		}
		
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasCuentas(listadoPorCuentaHEARM,"HEARM",x,libro,hoja,cuenta,soloDeuda);
		x = getListadoDeudasCuentas(listadoPorCuentaOtros,"OTROS",x,libro,hoja,cuenta,soloDeuda);
				
		return hoja;
	}
	
	public static int getListadoDeudasCuentas(List<SqlRow> proveedorLista,String deposito,int x,Workbook libro,Sheet hoja,String cuenta,Boolean soloDeuda){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		String nombreProv = "";
		int y = (soloDeuda)?6:7; 
		
		Row fila = hoja.createRow(x);
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue(cuenta+" - "+deposito+" - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,y));
		x++;
		
		
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("N° OP");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(1);
		celda0.setCellValue("FECHA EXP.");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(2);
		celda0.setCellValue("N° EXP.");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(3);
		celda0.setCellValue("PROVEEDOR");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(4);
		celda0.setCellValue("DEUDA");
		celda0.setCellStyle(cabecera);
		
		int z = 5;
		
		celda0 = fila.createCell(5);
		celda0.setCellValue("COMPROMISO");
		celda0.setCellStyle(cabecera);
		
		if(!soloDeuda) {
			z++;
		}
		
		celda0 = fila.createCell(z);
		celda0.setCellValue("RUBRO");
		celda0.setCellStyle(cabecera);
		z++;
		celda0 = fila.createCell(z);
		celda0.setCellValue("DETALLE");
		celda0.setCellStyle(cabecera);
		 
		
		x++;
		
		BigDecimal ptmpdeuda = new java.math.BigDecimal(0);
		BigDecimal ptmpcompromiso = new java.math.BigDecimal(0);
		BigDecimal totaldeuda = new java.math.BigDecimal(0);
		BigDecimal totalcompromiso = new java.math.BigDecimal(0);
		Integer idProv = 0 ;
		
		for(SqlRow s : proveedorLista){
			
			if(idProv != 0 && idProv.compareTo(s.getInteger("proveedorId")) != 0){
				ReportesExcelsUtils reux = new ReportesExcelsUtils();
				CellStyle estiloMonedaSubtotal = reu.getEstiloMoneda(libro);
				 
				estiloMonedaSubtotal.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				estiloMonedaSubtotal.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				estiloMonedaSubtotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
				
				fila = hoja.createRow(x);
		    	celda0 = fila.createCell(0);
				celda0.setCellValue("TOTAL - "+nombreProv);
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
				celda0 = fila.createCell(4);
				celda0.setCellValue(ptmpdeuda.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				celda0 = fila.createCell(5);
				celda0.setCellValue(ptmpcompromiso.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				z = 5;
				int zy = 6;
				if(!soloDeuda) {
					z++;
					zy = 7;
				}

				hoja.addMergedRegion(new  CellRangeAddress(x,x,z,zy));
				celda0 = fila.createCell(z);
				celda0.setCellValue("");
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				ptmpdeuda = new java.math.BigDecimal(0);
				ptmpcompromiso = new java.math.BigDecimal(0);
				x++;
			}
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue((s.getInteger("numeroProvision") != null)?s.getInteger("numeroProvision"):0);
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(utils.DateUtils.formatDate(s.getDate("fechaExpediente")));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(2);
			celda0.setCellValue(s.getString("expediente"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(3);
			celda0.setCellValue(s.getString("nombre_proveedor"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(4);
			celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			
			celda0 = fila.createCell(5);
			celda0.setCellValue(s.getBigDecimal("total_compromiso").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			
			z = 5;
			if(!soloDeuda) {
				z++;
			}
			
			celda0 = fila.createCell(z);
			celda0.setCellValue(s.getString("rubro"));
			celda0.setCellStyle(comun);
			z++;
			celda0 = fila.createCell(z);
			celda0.setCellValue(s.getString("descripcion"));
			celda0.setCellStyle(comun);
			 
			
			x++;
			
			idProv = s.getInteger("proveedorId");
			nombreProv =s.getString("nombre_proveedor");
			ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"));
			ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"));
			totaldeuda = totaldeuda.add(s.getBigDecimal("total_deuda"));
			totalcompromiso = totalcompromiso.add(s.getBigDecimal("total_compromiso"));
		}
		
		if(proveedorLista.size() > 0){
			
			if(idProv != 0){
				ReportesExcelsUtils reux = new ReportesExcelsUtils();
				CellStyle estiloMonedaSubtotal = reu.getEstiloMoneda(libro);
				 
				estiloMonedaSubtotal.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				estiloMonedaSubtotal.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				estiloMonedaSubtotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
				
				fila = hoja.createRow(x);
		    	celda0 = fila.createCell(0);
				celda0.setCellValue("TOTAL - "+nombreProv);
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
				
				celda0 = fila.createCell(4);
				celda0.setCellValue(ptmpdeuda.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				celda0 = fila.createCell(5);
				celda0.setCellValue(ptmpcompromiso.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
					
				z = 5;
				int zy = 6;
				if(!soloDeuda) {
					z++;
					zy++;
				}	
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,z,zy));
				celda0 = fila.createCell(z);
				celda0.setCellValue("");
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				
				ptmpdeuda = new java.math.BigDecimal(0);
				ptmpcompromiso = new java.math.BigDecimal(0);
				x++;
			}
			
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue("SUBTOTAL - "+deposito);
			celda0.setCellStyle(comun);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
			celda0 = fila.createCell(4);
			celda0.setCellValue(totaldeuda.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			if(!soloDeuda) {
				celda0 = fila.createCell(5);
				celda0.setCellValue(totalcompromiso.doubleValue());
				celda0.setCellStyle(estiloMoneda);
			}
		} 
		x++;
		x++;
		
		return x;
	}
	
	public static Result deudasDetallesServiciosReportes(Boolean soloDeuda) {
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-SERVICIOS-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		DynamicForm d = form().bindFromRequest();
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			getDeudasDetallesServiciosSheet(libro);
				
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}	
	
	public static Result deudasDetallesHonorariosReportes(boolean soloDeuda) {
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-HONORARIOS-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		DynamicForm d = form().bindFromRequest();
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			getDeudasDetallesHonorariosSheet(libro);
				
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}	
	
	public static Result deudasDetallesOtrosReportes(boolean profe,boolean equipamientos,boolean soloDeuda) {
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		DynamicForm d = form().bindFromRequest();
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			getDeudasDetallesOtrosSheet(libro,equipamientos,profe,soloDeuda);
				
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}	
	
	public static Sheet getDeudasDetallesOtrosSheet(Workbook libro,boolean equipamientos,boolean profe,boolean soloDeuda){
		
		String cuenta = (profe)?"PROFE":"OPERATIVA"; 
		String p = (profe)?"-PROFE":"";
		String e = (equipamientos)?"-EQUIPAMIENTOS":"";
		
		List<SqlRow> proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesOtros(profe,(long)Deposito.HEARM,equipamientos,soloDeuda);
		
		List<SqlRow> proveedorOtros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesOtros(profe,null,equipamientos,soloDeuda);
		
		Sheet hoja = libro.createSheet(cuenta+p+e);
		hoja.setColumnWidth(1, 3000);
		hoja.setColumnWidth(2, 3000);
		hoja.setColumnWidth(3, 15000);
		hoja.setColumnWidth(4, 4000);
		
		if(soloDeuda) {
			
			hoja.setColumnWidth(5, 6000);
			hoja.setColumnWidth(6, 20000);
			hoja.setDefaultRowHeight( (short) 400);
		}else {
			hoja.setColumnWidth(5, 4000);
			hoja.setColumnWidth(6, 6000);
			hoja.setColumnWidth(7, 20000);
			hoja.setDefaultRowHeight( (short) 400);
		}
		
		
		
		int x = 0;
		x = getListadoDeudasDetallesOtros(proveedorHEARM,"HEARM",x,libro,hoja,cuenta,equipamientos,soloDeuda);
		x = getListadoDeudasDetallesOtros(proveedorOtros,"OTROS",x,libro,hoja,cuenta,equipamientos,soloDeuda);
				
		return hoja;
	}
	
	public static Sheet getDeudasDetallesServiciosSheet(Workbook libro){
		String cuenta = "OPERATIVA"; 
		
		List<SqlRow> proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServicios((long)Deposito.HEARM,false);
		List<SqlRow> proveedorOtros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServicios(null,false);
		List<SqlRow> proveedorTodos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServicios(null,true);
		Sheet hoja = libro.createSheet("SERVICIOS OPERATIVA");
		
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasDetallesServicios(proveedorHEARM,proveedorOtros,proveedorTodos,x,libro,hoja,cuenta);
		//x = getListadoDeudasDetallesServicios(proveedorOtros,"OTROS",x,libro,hoja,cuenta);
				
		return hoja;
	}
	
	public static Sheet getDeudasDetallesHonorariosSheet(Workbook libro){
		String cuenta = "OPERATIVA"; 
		
		List<SqlRow> proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesHonorarios((long)Deposito.HEARM);
		
		List<SqlRow> proveedorOtros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesHonorarios(null);
		
		Sheet hoja = libro.createSheet("HONORARIOS OPERATIVA");
		/*hoja.setColumnWidth(1, 3000);
		hoja.setColumnWidth(2, 3000);
		hoja.setColumnWidth(3, 15000);
		hoja.setColumnWidth(4, 7000);
		hoja.setColumnWidth(5, 7000);
		hoja.setColumnWidth(6, 7000);
		hoja.setColumnWidth(7, 30000);*/
		hoja.setColumnWidth(0, 2000);
		hoja.setColumnWidth(1, 3000);
		hoja.setColumnWidth(2, 3000);
		hoja.setColumnWidth(3, 15000);
		hoja.setColumnWidth(4, 4000);
		hoja.setColumnWidth(5, 4000);
		hoja.setColumnWidth(6, 4000);
		hoja.setColumnWidth(7, 30000);
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasDetallesHonorarios(proveedorHEARM,"HEARM",x,libro,hoja,cuenta);
		x = getListadoDeudasDetallesHonorarios(proveedorOtros,"OTROS",x,libro,hoja,cuenta);
				
		return hoja;
	}
	
	public static int getListadoDeudasDetallesHonorarios(List<SqlRow> proveedorLista,String deposito,int x,Workbook libro,Sheet hoja,String cuenta){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		String nombreProv = "";
		 
		Row fila = hoja.createRow(x);
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue(cuenta+" - "+deposito+" - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,7));
		x++;
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("N° OP");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(1);
		celda0.setCellValue("FECHA EXP.");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(2);
		celda0.setCellValue("N° EXP.");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(3);
		celda0.setCellValue("PROVEEDOR");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(4);
		celda0.setCellValue("DEUDA");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(5);
		celda0.setCellValue("COMPROMISO");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(6);
		celda0.setCellValue("RUBRO");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(7);
		celda0.setCellValue("DETALLE");
		celda0.setCellStyle(cabecera);
		x++;
		BigDecimal ptmpdeuda = new java.math.BigDecimal(0);
		BigDecimal ptmpcompromiso = new java.math.BigDecimal(0);
		BigDecimal totaldeuda = new java.math.BigDecimal(0);
		BigDecimal totalcompromiso = new java.math.BigDecimal(0);
		Integer idProv = 0 ;
		
		for(SqlRow s : proveedorLista){
			
			if(idProv != 0 && idProv.compareTo(s.getInteger("proveedorId")) != 0){
				ReportesExcelsUtils reux = new ReportesExcelsUtils();
				CellStyle estiloMonedaSubtotal = reu.getEstiloMoneda(libro);
				 
				estiloMonedaSubtotal.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				estiloMonedaSubtotal.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				estiloMonedaSubtotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
				
				fila = hoja.createRow(x);
		    	celda0 = fila.createCell(0);
				celda0.setCellValue("TOTAL - "+nombreProv);
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
				celda0 = fila.createCell(4);
				celda0.setCellValue(ptmpdeuda.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				celda0 = fila.createCell(5);
				celda0.setCellValue(ptmpcompromiso.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,6,7));
				celda0 = fila.createCell(6);
				celda0.setCellValue("");
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				ptmpdeuda = new java.math.BigDecimal(0);
				ptmpcompromiso = new java.math.BigDecimal(0);
				x++;
				x++;
			}
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue((s.getInteger("numeroProvision") != null)?s.getInteger("numeroProvision"):0);
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(utils.DateUtils.formatDate(s.getDate("fechaExpediente")));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(2);
			celda0.setCellValue(s.getString("expediente"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(3);
			celda0.setCellValue(s.getString("nombre_proveedor"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(4);
			celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(5);
			celda0.setCellValue(s.getBigDecimal("total_compromiso").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(6);
			celda0.setCellValue(s.getString("rubro"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(7);
			celda0.setCellValue(s.getString("descripcion"));
			celda0.setCellStyle(comun);
			x++;
			
			idProv = s.getInteger("proveedorId");
			nombreProv =s.getString("nombre_proveedor");
			ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"));
			ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"));
			totaldeuda = totaldeuda.add(s.getBigDecimal("total_deuda"));
			totalcompromiso = totalcompromiso.add(s.getBigDecimal("total_compromiso"));
		}
		
		if(proveedorLista.size() > 0){
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue("SUBTOTAL - "+deposito);
			celda0.setCellStyle(comun);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
			celda0 = fila.createCell(4);
			celda0.setCellValue(totaldeuda.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(5);
			celda0.setCellValue(totalcompromiso.doubleValue());
			celda0.setCellStyle(estiloMoneda);
		} 
		x++;
		x++;
		
		return x;
	}
	
	public static int getListadoDeudasDetallesServicios(List<SqlRow> proveedorListaHearm,List<SqlRow> proveedorListaOtros,List<SqlRow> proveedorListaTodos,int x,Workbook libro,Sheet hoja,String cuenta){
		
		Map<Long,BigDecimal> periodoDeuda = new HashMap<Long, BigDecimal>();
		Map<String,Map<Long,BigDecimal>> pret = new HashMap<String, Map<Long,BigDecimal>>();
		Map<String,BigDecimal> deudaSinPeriodos = new HashMap<String,BigDecimal>();
		List<Long> peridoIds = new ArrayList<Long>();
		
		for(SqlRow ph : proveedorListaTodos){
			BigDecimal totalDeuda = ph.getBigDecimal("total_deuda");
			Long idOrdenProvision = ph.getLong("orden_provision_id");
			Long idExpediente = ph.getLong("expediente_id");
			String expedienteOp = ph.getLong("expediente_id").toString()+
					ph.getLong("orden_provision_id").toString();
			
			if(totalDeuda.compareTo(BigDecimal.ZERO) > 0){
				
				if(idOrdenProvision != null){
					List<ActaRecepcion> arl = ActaRecepcion.getListaActasDeudas(idOrdenProvision,null);
					if(arl.size() > 0){ 
						for(ActaRecepcion ar: arl){
	
							if(ar.periodo_id != null && ar.periodo_id.compareTo(new Long(0)) != 0){
								
								if(pret.containsKey(expedienteOp)){
									
									Map<Long,BigDecimal> periodoDeudaTmp = pret.get(expedienteOp);
									
									if(periodoDeudaTmp.containsKey(ar.periodo_id)){
										BigDecimal arTotalTmp = periodoDeudaTmp.get(ar.periodo_id);
										arTotalTmp = arTotalTmp.add(ar.total);
										periodoDeudaTmp.put(ar.periodo_id, arTotalTmp);
										pret.put(expedienteOp, periodoDeudaTmp);
										 
									}else{
										 periodoDeudaTmp.put(ar.periodo_id, ar.total);
										 pret.put(expedienteOp, periodoDeudaTmp);
									}
								}else{
									periodoDeuda = new HashMap<Long, BigDecimal>();
									periodoDeuda.put(ar.periodo_id, ar.total);
									pret.put(expedienteOp, periodoDeuda);
								}
								
								if(!peridoIds.contains(ar.periodo_id)){
									peridoIds.add(ar.periodo_id);
								}
								
							}else{
								if(deudaSinPeriodos.containsKey(expedienteOp)){
									BigDecimal arTotalTmp = deudaSinPeriodos.get(expedienteOp);
									arTotalTmp = arTotalTmp.add(ar.total);
									deudaSinPeriodos.put(expedienteOp, arTotalTmp);
								}else{
									deudaSinPeriodos.put(expedienteOp, ar.total);
								}
							}
						}
					}else{
						deudaSinPeriodos.put(expedienteOp, totalDeuda);
					}
				}else{
					deudaSinPeriodos.put(expedienteOp, totalDeuda);
				}
			}
		}
		Collections.sort(peridoIds); 
		
	
		
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		CellStyle estiloMonedaSubtotal = reu.getEstiloMoneda(libro);
		estiloMonedaSubtotal.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		estiloMonedaSubtotal.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		estiloMonedaSubtotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		String nombreProv = "";
		
		Row fila = hoja.createRow(x);
		hoja.setColumnWidth(0, 3000);
		hoja.setColumnWidth(1, 3500);
		hoja.setColumnWidth(2, 8000);
		hoja.setColumnWidth(3, 3500);
		hoja.setColumnWidth(4, 3500);
		int cc = 5;
		for(Long pi :peridoIds){
			hoja.setColumnWidth(cc, 3500);
			cc++;
		}
		hoja.setColumnWidth(cc, 3500);
		
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue("OPERATIVA - HEARM - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,5+peridoIds.size()));
		x++;
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("N° EXP.");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(1);
		celda0.setCellValue("INSTITUCION");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(2);
		celda0.setCellValue("PROVEEDOR");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(3);
		celda0.setCellValue("COMPROMISO");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(4);
		celda0.setCellValue("S/D");
		celda0.setCellStyle(cabecera);
		
		cc = 5;
		for(Long pi :peridoIds){
			
			celda0 = fila.createCell(cc);
			celda0.setCellValue(Periodo.find.byId(pi).nombre);
			celda0.setCellStyle(cabecera);
			cc++;
		}
		
		celda0 = fila.createCell(cc);
		celda0.setCellValue("TOTAL");
		celda0.setCellStyle(cabecera);
		 
		x++;
		
		BigDecimal totalCompromisoHearm = new java.math.BigDecimal(0);
		BigDecimal totalHearm = new java.math.BigDecimal(0);
		for(SqlRow s : proveedorListaHearm){
			BigDecimal totalTr = new java.math.BigDecimal(0);
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue(s.getString("expediente"));
			celda0.setCellStyle(comun);
			
			celda0 = fila.createCell(1);
			celda0.setCellValue(s.getString("deposito"));
			celda0.setCellStyle(comun);
			
			celda0 = fila.createCell(2);
			celda0.setCellValue(s.getString("nombre_proveedor"));
			celda0.setCellStyle(comun);
			
			celda0 = fila.createCell(3);
			celda0.setCellValue(s.getBigDecimal("total_compromiso").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			totalCompromisoHearm = totalCompromisoHearm.add(s.getBigDecimal("total_compromiso"));
			
			celda0 = fila.createCell(4);
			if(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null){
				celda0.setCellValue(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).doubleValue());
				totalTr = totalTr.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()));
				totalHearm = totalHearm.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()));
			}else{
				celda0.setCellValue(BigDecimal.ZERO.doubleValue());
			}
			celda0.setCellStyle(estiloMoneda);
			
			cc = 5;
			for(Long pe:peridoIds){
				celda0 = fila.createCell(cc);	
				if(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null && pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe) != null){
					celda0.setCellValue(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe).doubleValue());
					totalTr = totalTr.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe));
					totalHearm = totalHearm.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe));
				}else{
					celda0.setCellValue(BigDecimal.ZERO.doubleValue());
				}
				celda0.setCellStyle(estiloMoneda);
				cc++;
			}
			
			celda0 = fila.createCell(cc);	
			celda0.setCellValue(totalTr.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("");
		celda0.setCellStyle(estiloMonedaSubtotal);
    	celda0 = fila.createCell(1);
		celda0.setCellValue("");
		celda0.setCellStyle(estiloMonedaSubtotal);
		
		celda0 = fila.createCell(2);
		celda0.setCellValue("TOTALES");
		celda0.setCellStyle(estiloMonedaSubtotal);
		
		celda0 = fila.createCell(3);
		celda0.setCellValue(totalCompromisoHearm.doubleValue());
		celda0.setCellStyle(estiloMonedaSubtotal);

		celda0 = fila.createCell(4);
		celda0.setCellValue("");
		celda0.setCellStyle(estiloMonedaSubtotal);
		
		cc = 5;
		for(Long pe:peridoIds){
			celda0 = fila.createCell(cc);
			celda0.setCellValue("");
			celda0.setCellStyle(estiloMonedaSubtotal);
			cc++;
		}
		
		celda0 = fila.createCell(cc);
		celda0.setCellValue(totalHearm.doubleValue());
		celda0.setCellStyle(estiloMonedaSubtotal);
		x++; 
		x++; 
		
		//---------------------------OTRAS INSTITUCIONES
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("OPERATIVA - OTRAS INSTITUCIONES - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,5+peridoIds.size()));
		x++;
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("N° EXP.");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(1);
		celda0.setCellValue("INSTITUCION");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(2);
		celda0.setCellValue("PROVEEDOR");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(3);
		celda0.setCellValue("COMPROMISO");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(4);
		celda0.setCellValue("S/D");
		celda0.setCellStyle(cabecera);
		
		cc = 5;
		for(Long pi :peridoIds){
			
			celda0 = fila.createCell(cc);
			celda0.setCellValue(Periodo.find.byId(pi).nombre);
			celda0.setCellStyle(cabecera);
			cc++;
		}
		
		celda0 = fila.createCell(cc);
		celda0.setCellValue("TOTAL");
		celda0.setCellStyle(cabecera);
		 
		x++;
		
		BigDecimal totalCompromisoOtro = new java.math.BigDecimal(0);
		BigDecimal totalOtro = new java.math.BigDecimal(0);
		for(SqlRow s : proveedorListaOtros){
			BigDecimal totalTr = new java.math.BigDecimal(0);
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue(s.getString("expediente"));
			celda0.setCellStyle(comun);
			
			celda0 = fila.createCell(1);
			celda0.setCellValue(s.getString("deposito"));
			celda0.setCellStyle(comun);
			
			celda0 = fila.createCell(2);
			celda0.setCellValue(s.getString("nombre_proveedor"));
			celda0.setCellStyle(comun);
			
			celda0 = fila.createCell(3);
			celda0.setCellValue(s.getBigDecimal("total_compromiso").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			totalCompromisoOtro = totalCompromisoOtro.add(s.getBigDecimal("total_compromiso"));
			
			
			celda0 = fila.createCell(4);
			if(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null){
				celda0.setCellValue(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).doubleValue());
				totalTr = totalTr.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()));
				totalOtro = totalOtro.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()));
			}else{
				celda0.setCellValue(BigDecimal.ZERO.doubleValue());
			}
			celda0.setCellStyle(estiloMoneda);
			
			cc = 5;
			for(Long pe:peridoIds){
				celda0 = fila.createCell(cc);	
				if(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null && pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe) != null){
					celda0.setCellValue(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe).doubleValue());
					totalTr = totalTr.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe));
					totalOtro = totalOtro.add(pret.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).get(pe));
				}else{
					celda0.setCellValue(BigDecimal.ZERO.doubleValue());
				}
				celda0.setCellStyle(estiloMoneda);
				cc++;
			}
			
			celda0 = fila.createCell(cc);	
			celda0.setCellValue(totalTr.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
	
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("");
		celda0.setCellStyle(estiloMonedaSubtotal);
    	celda0 = fila.createCell(1);
		celda0.setCellValue("");
		celda0.setCellStyle(estiloMonedaSubtotal);
		
		celda0 = fila.createCell(2);
		celda0.setCellValue("TOTALES");
		celda0.setCellStyle(estiloMonedaSubtotal);
		
		celda0 = fila.createCell(3);
		celda0.setCellValue(totalCompromisoOtro.doubleValue());
		celda0.setCellStyle(estiloMonedaSubtotal);

		celda0 = fila.createCell(4);
		celda0.setCellValue("");
		celda0.setCellStyle(estiloMonedaSubtotal);
		
		cc = 5;
		for(Long pe:peridoIds){
			celda0 = fila.createCell(cc);
			celda0.setCellValue("");
			celda0.setCellStyle(estiloMonedaSubtotal);
			cc++;
		}
		
		celda0 = fila.createCell(cc);
		celda0.setCellValue(totalOtro.doubleValue());
		celda0.setCellStyle(estiloMonedaSubtotal);
		x++; 
		x++; 
		
		return x;
	}
	
	public static int getListadoDeudasDetallesOtros(List<SqlRow> proveedorLista,String deposito,int x,Workbook libro,Sheet hoja,String cuenta,boolean equipamientos,boolean soloDeuda){
		if(soloDeuda) {
			return getListadoDeudasDetallesOtrosDeuda(proveedorLista,deposito,x,libro,hoja,cuenta,equipamientos);
		}else {
			return getListadoDeudasDetallesOtrosDeudaCompromiso(proveedorLista,deposito,x,libro,hoja,cuenta,equipamientos);
		}
	}
	
	public static int getListadoDeudasDetallesOtrosDeuda(List<SqlRow> proveedorLista,String deposito,int x,Workbook libro,Sheet hoja,String cuenta,boolean equipamientos){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		String nombreProv = "";
		String e = (equipamientos)?"EQUIPAMIENTOS":"";
		
		Row fila = hoja.createRow(x);
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue(cuenta+" - "+deposito+" - "+e+" - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,7));
		x++;
		
		
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("N° OP");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(1);
		celda0.setCellValue("FECHA EXP.");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(2);
		celda0.setCellValue("N° EXP.");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(3);
		celda0.setCellValue("PROVEEDOR");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(4);
		celda0.setCellValue("DEUDA");
		celda0.setCellStyle(cabecera);
		
		
		celda0 = fila.createCell(5);
		celda0.setCellValue("RUBRO");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(6);
		celda0.setCellValue("DETALLE");
		celda0.setCellStyle(cabecera);
		x++;
		
		BigDecimal ptmpdeuda = new java.math.BigDecimal(0);
		BigDecimal totaldeuda = new java.math.BigDecimal(0);
		BigDecimal totalcompromiso = new java.math.BigDecimal(0);
		Integer idProv = 0 ;
		
		for(SqlRow s : proveedorLista){
			
			if(idProv != 0 && idProv.compareTo(s.getInteger("proveedorId")) != 0){
				ReportesExcelsUtils reux = new ReportesExcelsUtils();
				CellStyle estiloMonedaSubtotal = reu.getEstiloMoneda(libro);
				 
				estiloMonedaSubtotal.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				estiloMonedaSubtotal.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				estiloMonedaSubtotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
				
				fila = hoja.createRow(x);
		    	celda0 = fila.createCell(0);
				celda0.setCellValue("TOTAL - "+nombreProv);
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
				celda0 = fila.createCell(4);
				celda0.setCellValue(ptmpdeuda.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,5,6));
				celda0 = fila.createCell(5);
				celda0.setCellValue("");
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				ptmpdeuda = new java.math.BigDecimal(0);
				x++;
			}
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue((s.getInteger("numeroProvision") != null)?s.getInteger("numeroProvision"):0);
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(utils.DateUtils.formatDate(s.getDate("fechaExpediente")));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(2);
			celda0.setCellValue(s.getString("expediente"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(3);
			celda0.setCellValue(s.getString("nombre_proveedor"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(4);
			celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(5);
			celda0.setCellValue(s.getString("rubro"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(6);
			celda0.setCellValue(s.getString("descripcion"));
			celda0.setCellStyle(comun);
			x++;
			
			idProv = s.getInteger("proveedorId");
			nombreProv =s.getString("nombre_proveedor");
			ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"));
			totaldeuda = totaldeuda.add(s.getBigDecimal("total_deuda"));
			
		}
		
		if(proveedorLista.size() > 0){
			
			if(idProv != 0){
				ReportesExcelsUtils reux = new ReportesExcelsUtils();
				CellStyle estiloMonedaSubtotal = reu.getEstiloMoneda(libro);
				 
				estiloMonedaSubtotal.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				estiloMonedaSubtotal.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				estiloMonedaSubtotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
				
				fila = hoja.createRow(x);
		    	celda0 = fila.createCell(0);
				celda0.setCellValue("TOTAL - "+nombreProv);
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
				celda0 = fila.createCell(4);
				celda0.setCellValue(ptmpdeuda.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal); 
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,5,6));
				celda0 = fila.createCell(5);
				celda0.setCellValue("");
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				ptmpdeuda = new java.math.BigDecimal(0);
				x++;
			}
			
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue("SUBTOTAL - "+deposito);
			celda0.setCellStyle(comun);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
			celda0 = fila.createCell(4);
			celda0.setCellValue(totaldeuda.doubleValue());
			celda0.setCellStyle(estiloMoneda);  
		} 
		x++;
		x++;
		
		return x;
	}
	
	public static int getListadoDeudasDetallesOtrosDeudaCompromiso(List<SqlRow> proveedorLista,String deposito,int x,Workbook libro,Sheet hoja,String cuenta,boolean equipamientos){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		String nombreProv = "";
		String e = (equipamientos)?"EQUIPAMIENTOS":"";
		
		Row fila = hoja.createRow(x);
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue(cuenta+" - "+deposito+" - "+e+" - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,7));
		x++;
		
		
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("N° OP");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(1);
		celda0.setCellValue("FECHA EXP.");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(2);
		celda0.setCellValue("N° EXP.");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(3);
		celda0.setCellValue("PROVEEDOR");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(4);
		celda0.setCellValue("DEUDA");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(5);
		celda0.setCellValue("COMPROMISO");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(6);
		celda0.setCellValue("RUBRO");
		celda0.setCellStyle(cabecera);
		
		celda0 = fila.createCell(7);
		celda0.setCellValue("DETALLE");
		celda0.setCellStyle(cabecera);
		x++;
		
		BigDecimal ptmpdeuda = new java.math.BigDecimal(0);
		BigDecimal ptmpcompromiso = new java.math.BigDecimal(0);
		BigDecimal totaldeuda = new java.math.BigDecimal(0);
		BigDecimal totalcompromiso = new java.math.BigDecimal(0);
		Integer idProv = 0 ;
		
		for(SqlRow s : proveedorLista){
			
			if(idProv != 0 && idProv.compareTo(s.getInteger("proveedorId")) != 0){
				ReportesExcelsUtils reux = new ReportesExcelsUtils();
				CellStyle estiloMonedaSubtotal = reu.getEstiloMoneda(libro);
				 
				estiloMonedaSubtotal.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				estiloMonedaSubtotal.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				estiloMonedaSubtotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
				
				fila = hoja.createRow(x);
		    	celda0 = fila.createCell(0);
				celda0.setCellValue("TOTAL - "+nombreProv);
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
				celda0 = fila.createCell(4);
				celda0.setCellValue(ptmpdeuda.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				celda0 = fila.createCell(5);
				celda0.setCellValue(ptmpcompromiso.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,6,7));
				celda0 = fila.createCell(6);
				celda0.setCellValue("");
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				ptmpdeuda = new java.math.BigDecimal(0);
				ptmpcompromiso = new java.math.BigDecimal(0);
				x++;
			}
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue((s.getInteger("numeroProvision") != null)?s.getInteger("numeroProvision"):0);
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(utils.DateUtils.formatDate(s.getDate("fechaExpediente")));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(2);
			celda0.setCellValue(s.getString("expediente"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(3);
			celda0.setCellValue(s.getString("nombre_proveedor"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(4);
			celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(5);
			celda0.setCellValue(s.getBigDecimal("total_compromiso").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(6);
			celda0.setCellValue(s.getString("rubro"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(7);
			celda0.setCellValue(s.getString("descripcion"));
			celda0.setCellStyle(comun);
			x++;
			
			idProv = s.getInteger("proveedorId");
			nombreProv =s.getString("nombre_proveedor");
			ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"));
			ptmpcompromiso = ptmpcompromiso.add(s.getBigDecimal("total_compromiso"));
			totaldeuda = totaldeuda.add(s.getBigDecimal("total_deuda"));
			totalcompromiso = totalcompromiso.add(s.getBigDecimal("total_compromiso"));
		}
		
		if(proveedorLista.size() > 0){
			
			if(idProv != 0){
				ReportesExcelsUtils reux = new ReportesExcelsUtils();
				CellStyle estiloMonedaSubtotal = reu.getEstiloMoneda(libro);
				 
				estiloMonedaSubtotal.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				estiloMonedaSubtotal.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				estiloMonedaSubtotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
				
				fila = hoja.createRow(x);
		    	celda0 = fila.createCell(0);
				celda0.setCellValue("TOTAL - "+nombreProv);
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
				celda0 = fila.createCell(4);
				celda0.setCellValue(ptmpdeuda.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				celda0 = fila.createCell(5);
				celda0.setCellValue(ptmpcompromiso.doubleValue());
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				hoja.addMergedRegion(new  CellRangeAddress(x,x,6,7));
				celda0 = fila.createCell(6);
				celda0.setCellValue("");
				celda0.setCellStyle(estiloMonedaSubtotal);
				
				ptmpdeuda = new java.math.BigDecimal(0);
				ptmpcompromiso = new java.math.BigDecimal(0);
				x++;
			}
			
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue("SUBTOTAL - "+deposito);
			celda0.setCellStyle(comun);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
			celda0 = fila.createCell(4);
			celda0.setCellValue(totaldeuda.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(5);
			celda0.setCellValue(totalcompromiso.doubleValue());
			celda0.setCellStyle(estiloMoneda);
		} 
		x++;
		x++;
		
		return x;
	}
	
	
	
	public static Result deudasDetallesReporte(Integer idProveedor,boolean ra,boolean soloDeuda) {
		DynamicForm d = form().bindFromRequest();
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String proveedor = "R.A.";
		if(!ra){
			Proveedor p = Proveedor.find.byId(idProveedor.longValue());
			proveedor = p.nombre;
		}
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-"+proveedor+"-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = getDeudasDetallesSheet(libro,idProveedor,ra,soloDeuda);
			
			
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}
	
	
	public static Sheet getDeudasDetallesSheet(Workbook libro,Integer idProveedor,boolean ra,boolean soloDeuda){
		 
		String proveedor = "R.A.";
		if(!ra){
			Proveedor p = Proveedor.find.byId(idProveedor.longValue());
			proveedor = p.nombre;
		}
		
		Map<String,Map<String,Map<Integer,List<SqlRow>>>> listaFinal = InformeDeudaProveedoresMaterializada.getListaFinalDeudasDetallesReporte(idProveedor,ra,soloDeuda);
		
		Sheet hoja = libro.createSheet("RESUMEN -"+proveedor);
		hoja.setColumnWidth(0, 3100);
		hoja.setColumnWidth(1, 15000);
		hoja.setColumnWidth(2, 5000);
		hoja.setColumnWidth(3, 5000);
		hoja.setColumnWidth(4, 5000);
		hoja.setColumnWidth(5, 20000);
		 
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasDetalles(x,"HEARM","OPERATIVA",false,proveedor,libro,hoja,listaFinal,soloDeuda);
		x = getListadoDeudasDetalles(x,"OTRAS INSTITUCIONES","OPERATIVA",false,proveedor,libro,hoja,listaFinal,soloDeuda);
		x = getListadoDeudasDetalles(x,"HEARM","OPERATIVA",true,proveedor,libro,hoja,listaFinal,soloDeuda);//servicios
		x = getListadoDeudasDetalles(x,"OTRAS INSTITUCIONES","OPERATIVA",true,proveedor,libro,hoja,listaFinal,soloDeuda);//servicios
		
		
		x = getListadoDeudasDetalles(x,"HEARM","PROFE",false,proveedor,libro,hoja,listaFinal,soloDeuda);
		x = getListadoDeudasDetalles(x,"OTRAS INSTITUCIONES","PROFE",false,proveedor,libro,hoja,listaFinal,soloDeuda);
		x = getListadoDeudasDetalles(x,"HEARM","PROFE",true,proveedor,libro,hoja,listaFinal,soloDeuda);
		x = getListadoDeudasDetalles(x,"OTRAS INSTITUCIONES","PROFE",true,proveedor,libro,hoja,listaFinal,soloDeuda);
		x= 0;
		
		return hoja;

	}		
	
	public static int getListadoDeudasDetalles(int x,String deposito,String cuenta,boolean servicio,String proveedor,Workbook libro,Sheet hoja,Map<String,Map<String,Map<Integer,List<SqlRow>>>> listaFinal,boolean soloDeuda){
		if(soloDeuda) {
			return getListadoDeudasDetallesDeuda(x,deposito,cuenta,servicio,proveedor,libro,hoja,listaFinal);
		}else {
			return getListadoDeudasDetallesDeudaCompromiso(x,deposito,cuenta,servicio,proveedor,libro,hoja,listaFinal);
		}
	}
	
	public static int getListadoDeudasDetallesDeuda(int x,String deposito,String cuenta,boolean servicio,String proveedor,Workbook libro,Sheet hoja,Map<String,Map<String,Map<Integer,List<SqlRow>>>> listaFinal){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		
		String nombreProveedor = ""; 
		if(listaFinal.get(cuenta) != null){
			if(listaFinal.get(cuenta).get(deposito) != null){
				if(listaFinal.get(cuenta).get(deposito).size() > 0){
					
					Row fila = hoja.createRow(x);
					
					String s2 =(servicio)?"SERVICIOS -":"";
					Cell celda0 = fila.createCell(0);
					celda0.setCellValue(s2+cuenta+" - "+deposito+" - "+proveedor+" - "+utils.DateUtils.getNow());
					celda0.setCellStyle(cabeceraPrincipal);
					hoja.addMergedRegion(new  CellRangeAddress(x,x,0,4));
					x++;
					
					fila = hoja.createRow(x);
					
					/*celda0 = fila.createCell(0);
					celda0.setCellValue("N° OP");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(1);
					celda0.setCellValue("FECHA EXP");
					celda0.setCellStyle(cabecera);*/
					
					celda0 = fila.createCell(0);
					celda0.setCellValue("N° EXP");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(1);
					celda0.setCellValue("PROVEEDOR");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(2);
					celda0.setCellValue("DEUDA");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(3);
					celda0.setCellValue("RUBRO");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(4);
					celda0.setCellValue("DETALLE");
					celda0.setCellStyle(cabecera);
					x++;
					
					
					for (Map.Entry<Integer,List<SqlRow>> entry : listaFinal.get(cuenta).get(deposito).entrySet()) {
						BigDecimal mtdoh = new BigDecimal(0);
						BigDecimal mtcoh = new BigDecimal(0);
						boolean cargar = false;
						boolean xx = false;
						boolean ss = true;
						
						
					    for(SqlRow s : entry.getValue()){
					    	
					    	cargar = false;
					    	if(servicio && s.getString("rubro").compareTo("SERVICIOS") == 0){
					    		cargar = true;
					    	}else if(!servicio && s.getString("rubro").compareTo("SERVICIOS") != 0){
					    		cargar = true;
					    	}	
					    	
					    	
					    	if(cargar){
					    		if(ss){
								    fila = hoja.createRow(x);
								    celda0 = fila.createCell(0);
									celda0.setCellValue(s.getString("nombre_proveedor"));
									 
									celda0.setCellStyle(cabecera);
									hoja.addMergedRegion(new  CellRangeAddress(x,x,0,4));
									ss = false;
									x++;
					    		}		
					    		xx = true;
					    		fila = hoja.createRow(x);
						    	/*celda0 = fila.createCell(0);
								celda0.setCellValue((s.getInteger("numeroProvision") != null)?s.getInteger("numeroProvision"):0);
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(1);
								celda0.setCellValue(utils.DateUtils.formatDate(s.getDate("fechaExpediente")));
								celda0.setCellStyle(comun);*/
								
					    		celda0 = fila.createCell(0);
								celda0.setCellValue(s.getString("expediente"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(1);
								celda0.setCellValue(s.getString("nombre_proveedor"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(2);
								celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
								celda0.setCellStyle(estiloMoneda);
								celda0 = fila.createCell(3);
								celda0.setCellValue(s.getString("rubro"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(4);
								celda0.setCellValue(s.getString("descripcion"));
								celda0.setCellStyle(comun);
								x++;
								mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"));
								nombreProveedor = s.getString("nombre_proveedor");
					    	}
					    }
					    
					    if(xx){
						    fila = hoja.createRow(x);
						    celda0 = fila.createCell(0);
							celda0.setCellValue("SUB-TOTAL-"+nombreProveedor);
							celda0.setCellStyle(comun);
							hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
							
							celda0 = fila.createCell(2);
							celda0.setCellValue(mtdoh.doubleValue());
							celda0.setCellStyle(estiloMoneda);
							
							
							celda0 = fila.createCell(3);
							celda0.setCellValue("");
							celda0.setCellStyle(comun);
							hoja.addMergedRegion(new  CellRangeAddress(x,x,3,4));
							x++;
							x++;
					    }
						
					}	
				}
			}	
		}
		
		return x;
	}
	
	public static int getListadoDeudasDetallesDeudaCompromiso(int x,String deposito,String cuenta,boolean servicio,String proveedor,Workbook libro,Sheet hoja,Map<String,Map<String,Map<Integer,List<SqlRow>>>> listaFinal){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		
		String nombreProveedor = ""; 
		if(listaFinal.get(cuenta) != null){
			if(listaFinal.get(cuenta).get(deposito) != null){
				if(listaFinal.get(cuenta).get(deposito).size() > 0){
					
					Row fila = hoja.createRow(x);
					
					String s2 =(servicio)?"SERVICIOS -":"";
					Cell celda0 = fila.createCell(0);
					celda0.setCellValue(s2+cuenta+" - "+deposito+" - "+proveedor+" - "+utils.DateUtils.getNow());
					celda0.setCellStyle(cabeceraPrincipal);
					hoja.addMergedRegion(new  CellRangeAddress(x,x,0,5));
					x++;
					
					fila = hoja.createRow(x);
					
					/*celda0 = fila.createCell(0);
					celda0.setCellValue("N° OP");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(1);
					celda0.setCellValue("FECHA EXP");
					celda0.setCellStyle(cabecera);*/
					
					celda0 = fila.createCell(0);
					celda0.setCellValue("N° EXP");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(1);
					celda0.setCellValue("PROVEEDOR");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(2);
					celda0.setCellValue("DEUDA");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(3);
					celda0.setCellValue("COMPROMISO");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(4);
					celda0.setCellValue("RUBRO");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(5);
					celda0.setCellValue("DETALLE");
					celda0.setCellStyle(cabecera);
					x++;
					
					
					for (Map.Entry<Integer,List<SqlRow>> entry : listaFinal.get(cuenta).get(deposito).entrySet()) {
						BigDecimal mtdoh = new BigDecimal(0);
						BigDecimal mtcoh = new BigDecimal(0);
						boolean cargar = false;
						boolean xx = false;
						boolean ss = true;
						
						
					    for(SqlRow s : entry.getValue()){
					    	
					    	cargar = false;
					    	if(servicio && s.getString("rubro").compareTo("SERVICIOS") == 0){
					    		cargar = true;
					    	}else if(!servicio && s.getString("rubro").compareTo("SERVICIOS") != 0){
					    		cargar = true;
					    	}	
					    	
					    	
					    	if(cargar){
					    		if(ss){
								    fila = hoja.createRow(x);
								    celda0 = fila.createCell(0);
									celda0.setCellValue(s.getString("nombre_proveedor"));
									 
									celda0.setCellStyle(cabecera);
									hoja.addMergedRegion(new  CellRangeAddress(x,x,0,5));
									ss = false;
									x++;
					    		}		
					    		xx = true;
					    		fila = hoja.createRow(x);
						    	/*celda0 = fila.createCell(0);
								celda0.setCellValue((s.getInteger("numeroProvision") != null)?s.getInteger("numeroProvision"):0);
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(1);
								celda0.setCellValue(utils.DateUtils.formatDate(s.getDate("fechaExpediente")));
								celda0.setCellStyle(comun);*/
								
					    		celda0 = fila.createCell(0);
								celda0.setCellValue(s.getString("expediente"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(1);
								celda0.setCellValue(s.getString("nombre_proveedor"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(2);
								celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
								celda0.setCellStyle(estiloMoneda);
								celda0 = fila.createCell(3);
								celda0.setCellValue(s.getBigDecimal("total_compromiso").doubleValue());
								celda0.setCellStyle(estiloMoneda);
								celda0 = fila.createCell(4);
								celda0.setCellValue(s.getString("rubro"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(5);
								celda0.setCellValue(s.getString("descripcion"));
								celda0.setCellStyle(comun);
								x++;
								mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"));
								mtcoh= mtcoh.add(s.getBigDecimal("total_compromiso"));
								nombreProveedor = s.getString("nombre_proveedor");
					    	}
					    }
					    
					    if(xx){
						    fila = hoja.createRow(x);
						    celda0 = fila.createCell(0);
							celda0.setCellValue("SUB-TOTAL-"+nombreProveedor);
							celda0.setCellStyle(comun);
							hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
							
							celda0 = fila.createCell(2);
							celda0.setCellValue(mtdoh.doubleValue());
							celda0.setCellStyle(estiloMoneda);
							celda0 = fila.createCell(3);
							celda0.setCellValue(mtcoh.doubleValue());
							celda0.setCellStyle(estiloMoneda);
							
							celda0 = fila.createCell(4);
							celda0.setCellValue("");
							celda0.setCellStyle(comun);
							hoja.addMergedRegion(new  CellRangeAddress(x,x,4,5));
							x++;
							x++;
					    }
						
					}	
				}
			}	
		}
		
		return x;
	}
	
	public static Result deudasResumidasReporte(Integer deposito,boolean ra,boolean soloDeuda) {
		DynamicForm d = form().bindFromRequest();
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		
		String depositonNombre = (ra)?"GENERAL R.A.":"GENERAL";
		switch ( deposito.intValue() ) {
	      case  Deposito.HEARM:
	    	  depositonNombre = "HEARM";
	    	break;
	      	default:
		         System.out.println("error" );
		         break;
		}
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-"+depositonNombre+"-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			
			
			Sheet hoja = getDeudasResumidasSheet(libro,deposito,ra,true,soloDeuda);
			
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}
	}	
	
	public  static Sheet getDeudasResumidasSheet(Workbook libro,Integer deposito,boolean ra,boolean profe,boolean soloDeuda ){
		if(soloDeuda) {
			return getDeudasResumidasSheetDeuda(libro,deposito,ra,profe,soloDeuda);
		}else {
			return getDeudasResumidasSheetDeudaCompromiso(libro,deposito,ra,profe,soloDeuda);
		}
	}
	
	
	public  static Sheet getDeudasResumidasSheetDeudaCompromiso(Workbook libro,Integer deposito,boolean ra,boolean profe,boolean soloDeuda ){
		
		
		
		String depositonNombre = (ra)?"GENERAL R.A.":"GENERAL";
		
		if(deposito == Deposito.HEARM){
			depositonNombre = depositonNombre+" HEARM";
		}else if(deposito == -1){
			depositonNombre = depositonNombre+" OTRAS INSTITUCIONES";
		}
		
		List<SqlRow> proveedoresDestacados = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,false,deposito,ra,false,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,false,deposito,ra,true,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,false,deposito,ra,false,false,true,soloDeuda);
		List<SqlRow> proveedoresNoDestacados = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosEquipos = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosServicios = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosHonorarios = new ArrayList<SqlRow>();
		if(!ra){
			proveedoresNoDestacados = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,false,false,false,soloDeuda);
			proveedoresNoDestacadosEquipos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,false,true,false,soloDeuda);
			proveedoresNoDestacadosServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,true,false,false,soloDeuda);
			proveedoresNoDestacadosHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,false,false,true,soloDeuda);
		}
		
		List<SqlRow> proveedoresDestacadosProfe = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,true,deposito,ra,false,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosProfeServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,true,deposito,ra,true,false,false,soloDeuda);
		//List<SqlRow> proveedoresDestacadosProfeHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,true,deposito,ra,false,false,true);
		List<SqlRow> proveedoresNoDestacadosProfe = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeEquipos = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeServicios = new ArrayList<SqlRow>();
		//List<SqlRow> proveedoresNoDestacadosProfeHonorarios = new ArrayList<SqlRow>();
		if(!ra){
			proveedoresNoDestacadosProfe = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,false,false,false,soloDeuda);
			proveedoresNoDestacadosProfeEquipos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,false,true,false,soloDeuda);
			proveedoresNoDestacadosProfeServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,true,false,false,soloDeuda);
			//proveedoresNoDestacadosProfeHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,false,false,true);
		}
		
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		
		Sheet hoja = libro.createSheet("RESUMEN - "+depositonNombre);
		hoja.setColumnWidth(0, 15000);
		hoja.setColumnWidth(1, 5000);
		hoja.setColumnWidth(2, 5000);
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		
		Row fila = hoja.createRow(x);
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue("RESUMEN - "+depositonNombre+" - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,2));
		x++;
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("OPERATIVA");
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,2));
		x++;
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("PROVEDORES");
		celda0.setCellStyle(cabecera);
		celda0 = fila.createCell(1);
		celda0.setCellValue("MONTO DEUDA");
		celda0.setCellStyle(cabecera);
		celda0 = fila.createCell(2);
		celda0.setCellValue("MONTO COMPROMISO");
		celda0.setCellStyle(cabecera);
		x++;
		
		//DESCADOS
		BigDecimal sub_monto_total_deuda_nd = new BigDecimal(0);
		BigDecimal sub_monto_total_compromiso_nd = new BigDecimal(0);
		boolean hayra = false;
		if(proveedoresDestacados.size() > 0){
			
			BigDecimal monto_total_ra_tmp = new BigDecimal(0);
			BigDecimal monto_total_compromiso_ra_tmp = new BigDecimal(0);
			
			if(!ra){
				for(SqlRow pd : proveedoresDestacados){
					if(Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))){
						monto_total_ra_tmp = monto_total_ra_tmp.add(pd.getBigDecimal("total_deuda"));
						monto_total_compromiso_ra_tmp = monto_total_compromiso_ra_tmp.add(pd.getBigDecimal("total_compromiso"));
						hayra = true;
					}
				}
				
				if(hayra){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue("RA");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(monto_total_ra_tmp.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(2);
					celda0.setCellValue(monto_total_compromiso_ra_tmp.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}
			}
			
			for(SqlRow pd : proveedoresDestacados){
				if(!ra && !Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(2);
					celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}else if(ra){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(2);
					celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}
				sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
				sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
			}
		}
		
		
		//NO DESCADOS
		BigDecimal monto_total_deuda_nd = new BigDecimal(0);
		BigDecimal monto_total_compromiso_nd = new BigDecimal(0);
		
		if(proveedoresNoDestacados.size() > 0){
			for(SqlRow pd : proveedoresNoDestacados) {
				monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
				monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
				sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
				sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
			}
		
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("OTROS PROVEEDORES");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(monto_total_deuda_nd.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
		
		//NO DESCADOS
		BigDecimal monto_total_deuda_nde = new BigDecimal(0);
		BigDecimal monto_total_compromiso_nde = new BigDecimal(0);
		
		if(proveedoresNoDestacadosEquipos.size() > 0){
			for(SqlRow pd : proveedoresNoDestacadosEquipos) {
				monto_total_deuda_nde= monto_total_deuda_nde.add(pd.getBigDecimal("total_deuda"));
				monto_total_compromiso_nde= monto_total_compromiso_nde.add(pd.getBigDecimal("total_compromiso"));
				sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
				sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
			}
		
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("OTROS PROVEEDORES EQUIPOS");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(monto_total_deuda_nde.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(monto_total_compromiso_nde.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("SUB-TOTAL");
		celda0.setCellStyle(comun);
		celda0 = fila.createCell(1);
		celda0.setCellValue(sub_monto_total_deuda_nd.doubleValue());
		celda0.setCellStyle(estiloMoneda);
		celda0 = fila.createCell(2);
		celda0.setCellValue(sub_monto_total_compromiso_nd.doubleValue());
		celda0.setCellStyle(estiloMoneda);
		x++;
		
		if(proveedoresDestacadosServicios.size() > 0 || proveedoresNoDestacadosServicios.size() > 0){
			BigDecimal sub_monto_total_deuda_nd_servicio = new BigDecimal(0);
			BigDecimal sub_monto_total_compromiso_nd_servicio = new BigDecimal(0);
			
			//DESCADOS SERVICIOS
			if(proveedoresDestacadosServicios.size() > 0){
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("SERVICIOS");
				celda0.setCellStyle(cabeceraPrincipal);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,2));
				x++;
				
				for(SqlRow pd : proveedoresDestacadosServicios){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(2);
					celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					
					sub_monto_total_deuda_nd_servicio= sub_monto_total_deuda_nd_servicio.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_compromiso_nd_servicio= sub_monto_total_compromiso_nd_servicio.add(pd.getBigDecimal("total_compromiso"));
				}
			}	
		
			//NO DESCADOS SERVICIOS
			monto_total_deuda_nd = new BigDecimal(0);
			monto_total_compromiso_nd = new BigDecimal(0);
			
			if(proveedoresNoDestacadosServicios.size() > 0){
				for(SqlRow pd : proveedoresNoDestacadosServicios) {
					monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_nd_servicio= sub_monto_total_deuda_nd_servicio.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_compromiso_nd_servicio= sub_monto_total_compromiso_nd_servicio.add(pd.getBigDecimal("total_compromiso"));
				}
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("OTROS PROVEEDORES SERVICIOS");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(monto_total_deuda_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(2);
				celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				x++;
			}
		
		
			//SUB-TOTAL
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("SUB-TOTAL-SERVICIOS");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_nd_servicio.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(sub_monto_total_compromiso_nd_servicio.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
		//FIN SERVICIOS-----------------------------------------------------------------------
		
		
		//DESCADOS HONORARIOS
		if(proveedoresNoDestacadosHonorarios.size() > 0 || proveedoresDestacadosHonorarios.size() > 0){
			BigDecimal sub_monto_total_deuda_nd_honorarios = new BigDecimal(0);
			BigDecimal sub_monto_total_compromiso_nd_honorarios = new BigDecimal(0);
			if(proveedoresDestacadosHonorarios.size() > 0){
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("HONORARIOS");
				celda0.setCellStyle(cabeceraPrincipal);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,2));
				x++;
				
				for(SqlRow pd : proveedoresDestacadosHonorarios){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(2);
					celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					
					sub_monto_total_deuda_nd_honorarios= sub_monto_total_deuda_nd_honorarios.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_compromiso_nd_honorarios= sub_monto_total_compromiso_nd_honorarios.add(pd.getBigDecimal("total_compromiso"));
				}
			}	
			
			//NO DESCADOS HONORARIOS
			monto_total_deuda_nd = new BigDecimal(0);
			monto_total_compromiso_nd = new BigDecimal(0);
			
			if(proveedoresNoDestacadosHonorarios.size() > 0){
				for(SqlRow pd : proveedoresNoDestacadosHonorarios) {
					monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					
					sub_monto_total_deuda_nd_honorarios= sub_monto_total_deuda_nd_honorarios.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_compromiso_nd_honorarios= sub_monto_total_compromiso_nd_honorarios.add(pd.getBigDecimal("total_compromiso"));
				}
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("OTROS PROVEEDORES HONORARIOS");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(monto_total_deuda_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(2);
				celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				x++;
			}
			
			
			//SUB-TOTAL
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("SUB-TOTAL-HONORARIOS");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_nd_honorarios.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(sub_monto_total_compromiso_nd_honorarios.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
		//FIN HONORARIOS-----------------------------------------------------------------------
		
		
		
		//TOTAL
		x++;
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("TOTAL OPERATIVA");
		celda0.setCellStyle(comun);
		celda0 = fila.createCell(1);
		celda0.setCellValue(sub_monto_total_deuda_nd.doubleValue());
		celda0.setCellStyle(estiloMoneda);
		celda0 = fila.createCell(2);
		celda0.setCellValue(sub_monto_total_compromiso_nd.doubleValue());
		celda0.setCellStyle(estiloMoneda);
		x++;
		
		//TOTAL OPERATIVA 
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("TOTAL OPERATIVA DEUDA/COMPROMISO");
		celda0.setCellStyle(comun);
		celda0 = fila.createCell(1);
		celda0.setCellValue(sub_monto_total_deuda_nd.add(sub_monto_total_compromiso_nd).doubleValue());
		CellStyle estiloMonedaTmp = estiloMoneda;
		estiloMonedaTmp.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		celda0.setCellStyle(estiloMonedaTmp);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,1,2));
		
		x++;x++;
		//FIN OPERATIVAAAAAAAAAA
		
		//PROFE---------------------------------------------------------------------
		
		BigDecimal sub_monto_total_deuda_profe = new BigDecimal(0);
		BigDecimal sub_monto_total_compromiso_profe = new BigDecimal(0);		
		if(profe) {
			
		
		
			fila = hoja.createRow(x);
			
			celda0 = fila.createCell(0);
			celda0.setCellValue("PROFE");
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,2));
			x++;
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("PROVEDORES");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(1);
			celda0.setCellValue("MONTO DEUDA");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(2);
			celda0.setCellValue("MONTO COMPROMISO");
			celda0.setCellStyle(cabecera);
			x++;
			
			//DESCTACADOS
			
			if(proveedoresDestacadosProfe.size() > 0 || proveedoresNoDestacadosProfe.size() > 0){
				if(proveedoresDestacadosProfe.size() > 0){
					hayra = false;
					
					BigDecimal monto_total_ra_tmp = new BigDecimal(0);
					BigDecimal monto_total_compromiso_ra_tmp = new BigDecimal(0);
					if(!ra){
						for(SqlRow pd : proveedoresDestacadosProfe){
							if(Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))){
								monto_total_ra_tmp = monto_total_ra_tmp.add(pd.getBigDecimal("total_deuda"));
								monto_total_compromiso_ra_tmp = monto_total_compromiso_ra_tmp.add(pd.getBigDecimal("total_compromiso"));
								hayra = true;
							}
						}
						 
						if(hayra){
							fila = hoja.createRow(x);
							celda0 = fila.createCell(0);
							celda0.setCellValue("RA");
							celda0.setCellStyle(comun);
							celda0 = fila.createCell(1);
							celda0.setCellValue(monto_total_ra_tmp.doubleValue());
							celda0.setCellStyle(estiloMoneda);
							celda0 = fila.createCell(2);
							celda0.setCellValue(monto_total_compromiso_ra_tmp.doubleValue());
							celda0.setCellStyle(estiloMoneda);
							x++;
						}
					}
					
					for(SqlRow pd : proveedoresDestacadosProfe){
						if(!ra && !Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))){
							fila = hoja.createRow(x);
							celda0 = fila.createCell(0);
							celda0.setCellValue(pd.getString("nombre_proveedor"));
							celda0.setCellStyle(comun);
							celda0 = fila.createCell(1);
							celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							celda0 = fila.createCell(2);
							celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							x++;
						}else if(ra){
							fila = hoja.createRow(x);
							celda0 = fila.createCell(0);
							celda0.setCellValue(pd.getString("nombre_proveedor"));
							celda0.setCellStyle(comun);
							celda0 = fila.createCell(1);
							celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							celda0 = fila.createCell(2);
							celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							x++;
						}
						sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
						sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
					}
				}
			
				//NO DESTACADOS
				monto_total_deuda_nd = new BigDecimal(0);
				monto_total_compromiso_nd = new BigDecimal(0);
				if(proveedoresNoDestacadosProfe.size() > 0){
					for(SqlRow pd : proveedoresNoDestacadosProfe) {
						monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
						monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
						sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
						sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
					}
				
				
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue("OTROS PROVEEDORES");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(monto_total_deuda_nd.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(2);
					celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;	
				}
				
				//NO DESTACADOS
				monto_total_deuda_nde = new BigDecimal(0);
				monto_total_compromiso_nde = new BigDecimal(0);
				if(proveedoresNoDestacadosProfeEquipos.size() > 0){
					for(SqlRow pd : proveedoresNoDestacadosProfeEquipos) {
						monto_total_deuda_nde= monto_total_deuda_nde.add(pd.getBigDecimal("total_deuda"));
						monto_total_compromiso_nde= monto_total_compromiso_nde.add(pd.getBigDecimal("total_compromiso"));
						sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
						sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
					}
				
				
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue("OTROS PROVEEDORES EQUIPOS");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(monto_total_deuda_nde.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(2);
					celda0.setCellValue(monto_total_compromiso_nde.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;	
				}
				
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("SUB-TOTAL");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(sub_monto_total_deuda_profe.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(2);
				celda0.setCellValue(sub_monto_total_compromiso_profe.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				x++;
			}
			//SERVICIOS
			if(proveedoresDestacadosProfeServicios.size() > 0 || proveedoresNoDestacadosProfeServicios.size() > 0){
				BigDecimal sub_monto_total_deuda_profe_servicio = new BigDecimal(0);
				BigDecimal sub_monto_total_compromiso_profe_servicio = new BigDecimal(0);
				if(proveedoresDestacadosProfeServicios.size() > 0){
					fila = hoja.createRow(x);
					
					celda0 = fila.createCell(0);
					celda0.setCellValue("SERVICIOS");
					celda0.setCellStyle(cabeceraPrincipal);
					hoja.addMergedRegion(new  CellRangeAddress(x,x,0,2));
					x++;
					
					for(SqlRow pd : proveedoresDestacadosProfeServicios){
						fila = hoja.createRow(x);
						
						celda0 = fila.createCell(0);
						celda0.setCellValue(pd.getString("nombre_proveedor"));
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(1);
						celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
						celda0.setCellStyle(estiloMoneda);
						celda0 = fila.createCell(2);
						celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
						celda0.setCellStyle(estiloMoneda);
						x++;
						sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
						sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
						
						sub_monto_total_deuda_profe_servicio= sub_monto_total_deuda_profe_servicio.add(pd.getBigDecimal("total_deuda"));
						sub_monto_total_compromiso_profe_servicio= sub_monto_total_compromiso_profe_servicio.add(pd.getBigDecimal("total_compromiso"));
					}
				}
			
				//NO DESTACADOS SERVICIOS
				monto_total_deuda_nd = new BigDecimal(0);
				monto_total_compromiso_nd = new BigDecimal(0);
				if(proveedoresNoDestacadosProfeServicios.size() > 0){
					for(SqlRow pd : proveedoresNoDestacadosProfeServicios) {
						monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
						monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
						sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
						sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
						sub_monto_total_deuda_profe_servicio= sub_monto_total_deuda_profe_servicio.add(pd.getBigDecimal("total_deuda"));
						sub_monto_total_compromiso_profe_servicio= sub_monto_total_compromiso_profe_servicio.add(pd.getBigDecimal("total_compromiso"));
					}
				
				
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue("OTROS PROVEEDORES SERVICIOS");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(monto_total_deuda_nd.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(2);
					celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;	
				}
			
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("SUB-TOTAL-SERVICIO");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(sub_monto_total_deuda_profe_servicio.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				celda0 = fila.createCell(2);
				celda0.setCellValue(sub_monto_total_compromiso_profe_servicio.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				x++;
			}
			x++;
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTAL PROFE");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_profe.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(sub_monto_total_compromiso_profe.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
			//TOTAL PROFE 
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTAL PROFE DEUDA/COMPROMISO");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_profe.add(sub_monto_total_compromiso_profe).doubleValue());
			estiloMonedaTmp = estiloMoneda;
			estiloMonedaTmp.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			celda0.setCellStyle(estiloMonedaTmp);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,1,2));
		
			x++;
			 
			x++;
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTAL OPERATIVA/PROFE");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_nd.add(sub_monto_total_deuda_profe).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(sub_monto_total_compromiso_nd.add(sub_monto_total_compromiso_profe).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;		
			//FIN PROFEEEEEEEEEEEEEE
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTAL OPERATIVA/PROFE DEUDA/COMPROMISO");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_nd.add(sub_monto_total_deuda_profe).add(sub_monto_total_compromiso_nd.add(sub_monto_total_compromiso_profe)).doubleValue());
			estiloMonedaTmp = estiloMoneda;
			estiloMonedaTmp.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			celda0.setCellStyle(estiloMonedaTmp);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,1,2));
		}
		return hoja;
	}
	
	public  static Sheet getDeudasResumidasSheetDeuda(Workbook libro,Integer deposito,boolean ra,boolean profe,boolean soloDeuda ){
		
		
		
		String depositonNombre = (ra)?"GENERAL R.A.":"GENERAL";
		
		if(deposito == Deposito.HEARM){
			depositonNombre = depositonNombre+" HEARM";
		}else if(deposito == -1){
			depositonNombre = depositonNombre+" OTRAS INSTITUCIONES";
		}
		
		List<SqlRow> proveedoresDestacados = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,false,deposito,ra,false,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,false,deposito,ra,true,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,false,deposito,ra,false,false,true,soloDeuda);
		List<SqlRow> proveedoresNoDestacados = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosEquipos = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosServicios = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosHonorarios = new ArrayList<SqlRow>();
		if(!ra){
			proveedoresNoDestacados = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,false,false,false,soloDeuda);
			proveedoresNoDestacadosEquipos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,false,true,false,soloDeuda);
			proveedoresNoDestacadosServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,true,false,false,soloDeuda);
			proveedoresNoDestacadosHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,false,false,true,soloDeuda);
		}
		
		List<SqlRow> proveedoresDestacadosProfe = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,true,deposito,ra,false,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosProfeServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,true,deposito,ra,true,false,false,soloDeuda);
		//List<SqlRow> proveedoresDestacadosProfeHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,true,deposito,ra,false,false,true);
		List<SqlRow> proveedoresNoDestacadosProfe = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeEquipos = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeServicios = new ArrayList<SqlRow>();
		//List<SqlRow> proveedoresNoDestacadosProfeHonorarios = new ArrayList<SqlRow>();
		if(!ra){
			proveedoresNoDestacadosProfe = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,false,false,false,soloDeuda);
			proveedoresNoDestacadosProfeEquipos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,false,true,false,soloDeuda);
			proveedoresNoDestacadosProfeServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,true,false,false,soloDeuda);
			//proveedoresNoDestacadosProfeHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,false,false,true);
		}
		
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		
		Sheet hoja = libro.createSheet("RESUMEN - "+depositonNombre);
		hoja.setColumnWidth(0, 15000);
		hoja.setColumnWidth(1, 5000);
		hoja.setColumnWidth(2, 5000);
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		
		Row fila = hoja.createRow(x);
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue("RESUMEN - "+depositonNombre+" - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
		x++;
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("OPERATIVA");
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
		x++;
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("PROVEDORES");
		celda0.setCellStyle(cabecera);
		celda0 = fila.createCell(1);
		celda0.setCellValue("MONTO DEUDA");
		celda0.setCellStyle(cabecera);
		x++;
		
		//DESCADOS
		BigDecimal sub_monto_total_deuda_nd = new BigDecimal(0);
		BigDecimal sub_monto_total_compromiso_nd = new BigDecimal(0);
		boolean hayra = false;
		if(proveedoresDestacados.size() > 0){
			
			BigDecimal monto_total_ra_tmp = new BigDecimal(0);
			
			if(!ra){
				for(SqlRow pd : proveedoresDestacados){
					if(Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))){
						monto_total_ra_tmp = monto_total_ra_tmp.add(pd.getBigDecimal("total_deuda"));
						hayra = true;
					}
				}
				
				if(hayra){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue("RA");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(monto_total_ra_tmp.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}
			}
			
			for(SqlRow pd : proveedoresDestacados){
				if(!ra && !Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}else if(ra){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}
				sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
			}
		}
		
		
		//NO DESCADOS
		BigDecimal monto_total_deuda_nd = new BigDecimal(0);
		
		if(proveedoresNoDestacados.size() > 0){
			for(SqlRow pd : proveedoresNoDestacados) {
				monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
				sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
			}
		
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("OTROS PROVEEDORES");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(monto_total_deuda_nd.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
		
		//NO DESCADOS
		BigDecimal monto_total_deuda_nde = new BigDecimal(0);
		BigDecimal monto_total_compromiso_nde = new BigDecimal(0);
		
		if(proveedoresNoDestacadosEquipos.size() > 0){
			for(SqlRow pd : proveedoresNoDestacadosEquipos) {
				monto_total_deuda_nde= monto_total_deuda_nde.add(pd.getBigDecimal("total_deuda"));
				sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
			}
		
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("OTROS PROVEEDORES EQUIPOS");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(monto_total_deuda_nde.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("SUB-TOTAL");
		celda0.setCellStyle(comun);
		celda0 = fila.createCell(1);
		celda0.setCellValue(sub_monto_total_deuda_nd.doubleValue());
		celda0.setCellStyle(estiloMoneda);
		x++;
		
		if(proveedoresDestacadosServicios.size() > 0 || proveedoresNoDestacadosServicios.size() > 0){
			BigDecimal sub_monto_total_deuda_nd_servicio = new BigDecimal(0);
			
			//DESCADOS SERVICIOS
			if(proveedoresDestacadosServicios.size() > 0){
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("SERVICIOS");
				celda0.setCellStyle(cabeceraPrincipal);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
				x++;
				
				for(SqlRow pd : proveedoresDestacadosServicios){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_deuda_nd_servicio= sub_monto_total_deuda_nd_servicio.add(pd.getBigDecimal("total_deuda"));
				}
			}	
		
			//NO DESCADOS SERVICIOS
			monto_total_deuda_nd = new BigDecimal(0);
			
			if(proveedoresNoDestacadosServicios.size() > 0){
				for(SqlRow pd : proveedoresNoDestacadosServicios) {
					monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_nd_servicio= sub_monto_total_deuda_nd_servicio.add(pd.getBigDecimal("total_deuda"));
				}
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("OTROS PROVEEDORES SERVICIOS");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(monto_total_deuda_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				x++;
			}
		
		
			//SUB-TOTAL
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("SUB-TOTAL-SERVICIOS");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_nd_servicio.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
		//FIN SERVICIOS-----------------------------------------------------------------------
		
		
		//DESCADOS HONORARIOS
		if(proveedoresNoDestacadosHonorarios.size() > 0 || proveedoresDestacadosHonorarios.size() > 0){
			BigDecimal sub_monto_total_deuda_nd_honorarios = new BigDecimal(0);
			if(proveedoresDestacadosHonorarios.size() > 0){
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("HONORARIOS");
				celda0.setCellStyle(cabeceraPrincipal);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
				x++;
				
				for(SqlRow pd : proveedoresDestacadosHonorarios){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_deuda_nd_honorarios= sub_monto_total_deuda_nd_honorarios.add(pd.getBigDecimal("total_deuda"));
				}
			}	
			
			//NO DESCADOS HONORARIOS
			monto_total_deuda_nd = new BigDecimal(0);
			
			if(proveedoresNoDestacadosHonorarios.size() > 0){
				for(SqlRow pd : proveedoresNoDestacadosHonorarios) {
					monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					sub_monto_total_deuda_nd_honorarios= sub_monto_total_deuda_nd_honorarios.add(pd.getBigDecimal("total_deuda"));
				}
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("OTROS PROVEEDORES HONORARIOS");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(monto_total_deuda_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				x++;
			}
			
			
			//SUB-TOTAL
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("SUB-TOTAL-HONORARIOS");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_nd_honorarios.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
		}
		//FIN HONORARIOS-----------------------------------------------------------------------
		
		
		
		//TOTAL
		x++;
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("TOTAL OPERATIVA");
		celda0.setCellStyle(comun);
		celda0 = fila.createCell(1);
		celda0.setCellValue(sub_monto_total_deuda_nd.doubleValue());
		celda0.setCellStyle(estiloMoneda);
		x++;
		
		
		
		x++;x++;
		//FIN OPERATIVAAAAAAAAAA
		
		//PROFE---------------------------------------------------------------------
		
		BigDecimal sub_monto_total_deuda_profe = new BigDecimal(0);
		if(profe) {
			if(proveedoresDestacadosProfe.size() > 0 || proveedoresNoDestacadosProfe.size() > 0 || proveedoresDestacadosProfeServicios.size() > 0 || proveedoresNoDestacadosProfeServicios.size() > 0){
				fila = hoja.createRow(x);
				
				celda0 = fila.createCell(0);
				celda0.setCellValue("PROFE");
				celda0.setCellStyle(cabeceraPrincipal);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
				x++;
				
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("PROVEDORES");
				celda0.setCellStyle(cabecera);
				celda0 = fila.createCell(1);
				celda0.setCellValue("MONTO DEUDA");
				celda0.setCellStyle(cabecera);
				x++;
				
				//DESCTACADOS
				
				if(proveedoresDestacadosProfe.size() > 0 || proveedoresNoDestacadosProfe.size() > 0){
					if(proveedoresDestacadosProfe.size() > 0){
						hayra = false;
						
						BigDecimal monto_total_ra_tmp = new BigDecimal(0);
						BigDecimal monto_total_compromiso_ra_tmp = new BigDecimal(0);
						if(!ra){
							for(SqlRow pd : proveedoresDestacadosProfe){
								if(Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))){
									monto_total_ra_tmp = monto_total_ra_tmp.add(pd.getBigDecimal("total_deuda"));
									hayra = true;
								}
							}
							 
							if(hayra){
								fila = hoja.createRow(x);
								celda0 = fila.createCell(0);
								celda0.setCellValue("RA");
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(1);
								celda0.setCellValue(monto_total_ra_tmp.doubleValue());
								celda0.setCellStyle(estiloMoneda);
								x++;
							}
						}
						
						for(SqlRow pd : proveedoresDestacadosProfe){
							if(!ra && !Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))){
								fila = hoja.createRow(x);
								celda0 = fila.createCell(0);
								celda0.setCellValue(pd.getString("nombre_proveedor"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(1);
								celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
								celda0.setCellStyle(estiloMoneda);
								x++;
							}else if(ra){
								fila = hoja.createRow(x);
								celda0 = fila.createCell(0);
								celda0.setCellValue(pd.getString("nombre_proveedor"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(1);
								celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
								celda0.setCellStyle(estiloMoneda);
								x++;
							}
							sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
						}
					}
				
					//NO DESTACADOS
					monto_total_deuda_nd = new BigDecimal(0);
					if(proveedoresNoDestacadosProfe.size() > 0){
						for(SqlRow pd : proveedoresNoDestacadosProfe) {
							monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
							sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
						}
					
					
						fila = hoja.createRow(x);
						celda0 = fila.createCell(0);
						celda0.setCellValue("OTROS PROVEEDORES");
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(1);
						celda0.setCellValue(monto_total_deuda_nd.doubleValue());
						celda0.setCellStyle(estiloMoneda);
						x++;	
					}
					
					//NO DESTACADOS
					monto_total_deuda_nde = new BigDecimal(0);
					monto_total_compromiso_nde = new BigDecimal(0);
					if(proveedoresNoDestacadosProfeEquipos.size() > 0){
						for(SqlRow pd : proveedoresNoDestacadosProfeEquipos) {
							monto_total_deuda_nde= monto_total_deuda_nde.add(pd.getBigDecimal("total_deuda"));
							sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
						}
					
					
						fila = hoja.createRow(x);
						celda0 = fila.createCell(0);
						celda0.setCellValue("OTROS PROVEEDORES EQUIPOS");
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(1);
						celda0.setCellValue(monto_total_deuda_nde.doubleValue());
						celda0.setCellStyle(estiloMoneda);
						x++;	
					}
					
					
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue("SUB-TOTAL");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(sub_monto_total_deuda_profe.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}
				//SERVICIOS
				if(proveedoresDestacadosProfeServicios.size() > 0 || proveedoresNoDestacadosProfeServicios.size() > 0){
					BigDecimal sub_monto_total_deuda_profe_servicio = new BigDecimal(0);
					if(proveedoresDestacadosProfeServicios.size() > 0){
						fila = hoja.createRow(x);
						
						celda0 = fila.createCell(0);
						celda0.setCellValue("SERVICIOS");
						celda0.setCellStyle(cabeceraPrincipal);
						hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
						x++;
						
						for(SqlRow pd : proveedoresDestacadosProfeServicios){
							fila = hoja.createRow(x);
							
							celda0 = fila.createCell(0);
							celda0.setCellValue(pd.getString("nombre_proveedor"));
							celda0.setCellStyle(comun);
							celda0 = fila.createCell(1);
							celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							x++;
							sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
							sub_monto_total_deuda_profe_servicio= sub_monto_total_deuda_profe_servicio.add(pd.getBigDecimal("total_deuda"));
						}
					}
				
					//NO DESTACADOS SERVICIOS
					monto_total_deuda_nd = new BigDecimal(0);
					if(proveedoresNoDestacadosProfeServicios.size() > 0){
						for(SqlRow pd : proveedoresNoDestacadosProfeServicios) {
							monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
							sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
							sub_monto_total_deuda_profe_servicio= sub_monto_total_deuda_profe_servicio.add(pd.getBigDecimal("total_deuda"));
						}
					
					
						fila = hoja.createRow(x);
						celda0 = fila.createCell(0);
						celda0.setCellValue("OTROS PROVEEDORES SERVICIOS");
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(1);
						celda0.setCellValue(monto_total_deuda_nd.doubleValue());
						celda0.setCellStyle(estiloMoneda);
						x++;	
					}
				
				
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue("SUB-TOTAL-SERVICIO");
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(sub_monto_total_deuda_profe_servicio.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}
				x++;
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("TOTAL PROFE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(sub_monto_total_deuda_profe.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				x++;
				
			
				x++;
				 
				x++;
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("TOTAL OPERATIVA/PROFE");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(sub_monto_total_deuda_nd.add(sub_monto_total_deuda_profe).doubleValue());
				celda0.setCellStyle(estiloMoneda);
				x++;		
				//FIN PROFEEEEEEEEEEEEEE
			
			}
		}
		return hoja;
	}
	
	
	public static Result deudasDetallesOtrosProveedoresResumen(boolean profe,boolean equipamientos,boolean soloDeuda) {
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		DynamicForm d = form().bindFromRequest();
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			getDeudasDetallesOtrosProveedoresResumenSheet(libro,equipamientos,profe);
				
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}	
	
	public static Sheet getDeudasDetallesOtrosProveedoresResumenSheet(Workbook libro,boolean equipamientos,boolean profe){
		String cuenta = (profe)?"PROFE":"OPERATIVA"; 
		String p = (profe)?"-PROFE":"";
		String e = (equipamientos)?"-EQUIPAMIENTOS":"";
		List<SqlRow> proveedorHEARM = null;
		if(!profe) {
			proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorOtroProveedoresResumen(profe,(long)Deposito.HEARM,equipamientos);
		}else {
			proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorOtroProveedoresResumen(profe,null,equipamientos);
		}
		
		Sheet hoja = libro.createSheet("OTROS PROVEEDORES-"+cuenta+p+e);
		hoja.setColumnWidth(0, 15000);
		hoja.setColumnWidth(1, 6000);
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasDetallesOtrosProveedoresResumen(proveedorHEARM,"",x,libro,hoja,cuenta,equipamientos);
		//x = getListadoDeudasDetallesOtros(proveedorOtros,"OTROS",x,libro,hoja,cuenta,equipamientos);
				
		return hoja;
	}
	
	public static int getListadoDeudasDetallesOtrosProveedoresResumen(List<SqlRow> proveedorLista,String deposito,int x,Workbook libro,Sheet hoja,String cuenta,boolean equipamientos){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		String nombreProv = "";
		String e = (equipamientos)?"EQUIPAMIENTOS":"";
		
		Row fila = hoja.createRow(x);
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue(cuenta+" - "+deposito+" - "+e+" - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
		x++;
		
		
		
		fila = hoja.createRow(x);
		
		 
		celda0 = fila.createCell(0);
		celda0.setCellValue("PROVEEDOR");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(1);
		celda0.setCellValue("DEUDA");
		celda0.setCellStyle(cabecera);
		celda0.setCellStyle(cabecera);
		x++;
		
		BigDecimal ptmpdeuda = new java.math.BigDecimal(0);
		BigDecimal ptmpcompromiso = new java.math.BigDecimal(0);
		BigDecimal totaldeuda = new java.math.BigDecimal(0);
		BigDecimal totalcompromiso = new java.math.BigDecimal(0);
		Integer idProv = 0 ;
		
		for(SqlRow s : proveedorLista){
			
			
			
			fila = hoja.createRow(x);
	    
			celda0 = fila.createCell(0);
			celda0.setCellValue(s.getString("nombre_proveedor"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
			
			idProv = s.getInteger("proveedorId");
			nombreProv =s.getString("nombre_proveedor");
			ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"));
			 
			totaldeuda = totaldeuda.add(s.getBigDecimal("total_deuda"));
			 
		}
		
		if(proveedorLista.size() > 0){
			
			 
			
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue("SUBTOTAL - "+deposito);
			celda0.setCellStyle(comun);
			
			
			
			celda0 = fila.createCell(1);
			celda0.setCellValue(totaldeuda.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			 
		} 
		x++;
		x++;
		
		return x;
	}
	
	public static Result deudasServiciosProveedoresResumenReportes(Boolean soloDeuda) {
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		DynamicForm d = form().bindFromRequest();
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			getDeudasServiciosProveedoresResumenSheet(libro);
				
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}	
	
	public static Sheet getDeudasServiciosProveedoresResumenSheet(Workbook libro){
		
		String cuenta = "OPERATIVA"; 
		 
		 
		List<SqlRow> proveedorTodos = null;
		
		proveedorTodos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServiciosResumen(null,true);
		 
		
		Sheet hoja = libro.createSheet("SERVICIOS");
		hoja.setColumnWidth(0, 15000);
		hoja.setColumnWidth(1, 6000);
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasServiciosProveedoresResumen(proveedorTodos,"",x,libro,hoja,cuenta);
		//x = getListadoDeudasDetallesOtros(proveedorOtros,"OTROS",x,libro,hoja,cuenta,equipamientos);
				
		return hoja;
	}
	
	public static int getListadoDeudasServiciosProveedoresResumen(List<SqlRow> proveedorLista,String deposito,int x,Workbook libro,Sheet hoja,String cuenta){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		String nombreProv = "";
		String e = "";
		
		Row fila = hoja.createRow(x);
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue(cuenta+" - "+deposito+" - "+e+" - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
		x++;
		
		
		
		fila = hoja.createRow(x);
		
		 
		celda0 = fila.createCell(0);
		celda0.setCellValue("PROVEEDOR");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(1);
		celda0.setCellValue("DEUDA");
		celda0.setCellStyle(cabecera);
		celda0.setCellStyle(cabecera);
		x++;
		
		BigDecimal ptmpdeuda = new java.math.BigDecimal(0);
		BigDecimal ptmpcompromiso = new java.math.BigDecimal(0);
		BigDecimal totaldeuda = new java.math.BigDecimal(0);
		BigDecimal totalcompromiso = new java.math.BigDecimal(0);
		Integer idProv = 0 ;
		
		for(SqlRow s : proveedorLista){
			
			
			
			fila = hoja.createRow(x);
	    
			celda0 = fila.createCell(0);
			celda0.setCellValue(s.getString("nombre_proveedor"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
			
			idProv = s.getInteger("proveedorId");
			nombreProv =s.getString("nombre_proveedor");
			ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"));
			 
			totaldeuda = totaldeuda.add(s.getBigDecimal("total_deuda"));
			 
		}
		
		if(proveedorLista.size() > 0){
			
			 
			
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue("SUBTOTAL - "+deposito);
			celda0.setCellStyle(comun);
			
			
			
			celda0 = fila.createCell(1);
			celda0.setCellValue(totaldeuda.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			 
		} 
		x++;
		x++;
		
		return x;
	}
	
	public static Result deudasHonorariosProveedoresResumenReportes(Boolean soloDeuda) {
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");
		DynamicForm d = form().bindFromRequest();
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			getDeudasHonorariosProveedoresResumenSheet(libro);
				
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d,soloDeuda));
		}	
	}	
	
	public static Sheet getDeudasHonorariosProveedoresResumenSheet(Workbook libro){
		
		String cuenta = "OPERATIVA"; 
		 
		 
		List<SqlRow> proveedorTodos = null;
		
		proveedorTodos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorHonorariosResumen(null);
		 
		
		Sheet hoja = libro.createSheet("HONORARIOS");
		hoja.setColumnWidth(0, 15000);
		hoja.setColumnWidth(1, 6000);
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasHonorariosProveedoresResumen(proveedorTodos,"",x,libro,hoja,cuenta);
		//x = getListadoDeudasDetallesOtros(proveedorOtros,"OTROS",x,libro,hoja,cuenta,equipamientos);
				
		return hoja;
	}
	
	public static int getListadoDeudasHonorariosProveedoresResumen(List<SqlRow> proveedorLista,String deposito,int x,Workbook libro,Sheet hoja,String cuenta){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);
		String nombreProv = "";
		String e = "";
		
		Row fila = hoja.createRow(x);
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue(cuenta+" - "+deposito+" - "+e+" - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
		x++;
		
		
		
		fila = hoja.createRow(x);
		
		 
		celda0 = fila.createCell(0);
		celda0.setCellValue("PROVEEDOR");
		celda0.setCellStyle(cabecera);
		 
		celda0 = fila.createCell(1);
		celda0.setCellValue("DEUDA");
		celda0.setCellStyle(cabecera);
		celda0.setCellStyle(cabecera);
		x++;
		
		BigDecimal ptmpdeuda = new java.math.BigDecimal(0);
		BigDecimal ptmpcompromiso = new java.math.BigDecimal(0);
		BigDecimal totaldeuda = new java.math.BigDecimal(0);
		BigDecimal totalcompromiso = new java.math.BigDecimal(0);
		Integer idProv = 0 ;
		
		for(SqlRow s : proveedorLista){
			
			
			
			fila = hoja.createRow(x);
	    
			celda0 = fila.createCell(0);
			celda0.setCellValue(s.getString("nombre_proveedor"));
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
			
			idProv = s.getInteger("proveedorId");
			nombreProv =s.getString("nombre_proveedor");
			ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"));
			 
			totaldeuda = totaldeuda.add(s.getBigDecimal("total_deuda"));
			 
		}
		
		if(proveedorLista.size() > 0){
			
			 
			
			
			fila = hoja.createRow(x);
	    	celda0 = fila.createCell(0);
			celda0.setCellValue("SUBTOTAL - "+deposito);
			celda0.setCellStyle(comun);
			
			
			
			celda0 = fila.createCell(1);
			celda0.setCellValue(totaldeuda.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			 
		} 
		x++;
		x++;
		
		return x;
	}
}