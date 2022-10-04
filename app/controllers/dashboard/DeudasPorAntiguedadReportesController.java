 package controllers.dashboard;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import models.ActaRecepcion;
import models.Deposito;
import models.Periodo;
import models.Proveedor;
import models.TipoCuenta;
import models.Usuario;
import models.informes.InformeDeudaPorActaMaterializada;
import models.informes.InformeEstadisticoDeudaProveedores;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.avaje.ebean.SqlRow;

import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.ReportesExcelsUtils;
import views.html.dashboard.deudasPorAntiguedad.index;
import controllers.Secured;

@Security.Authenticated(Secured.class)
public class DeudasPorAntiguedadReportesController extends Controller {
	
	
	public static Result deudasInformeGeneralNuevo() {
		
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		
		DynamicForm d = form().bindFromRequest();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-GENERAL-NUEVO-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			
			Sheet hoja =getDeudasMensualNUEVOSheet(libro);
			
			
			hoja = getDeudasResumenPeriodoSheet(libro,-1,false,0,true); //RESUMEN RA
			hoja = getDeudasDetallesSheet(libro,-1,false,0,true); //DETALLE RA
			hoja = getDeudasResumenPeriodoSheet(libro,14733,false,0,true); //DETALLE BISIONES S.R.L. 
			hoja = getDeudasDetallesSheet(libro,14733,false,0,true);//DETALLE BISIONES S.R.L. 
			hoja = getDeudasResumenPeriodoSheet(libro,1530,false,0,true); //RESUMEN MOFAR S.A.
			hoja = getDeudasDetallesSheet(libro,1530,false,0,true);//DETALLE MOFAR S.A.
			hoja = getDeudasResumenPeriodoSheet(libro,4359,false,0,true); //RESUMEN DROGUERIA SAN JORGE S.A.
			hoja = getDeudasDetallesSheet(libro,4359,false,0,true);//DETALLE DROGUERIA SAN JORGE S.A.
			hoja = getDeudasResumenPeriodoSheet(libro,2749,false,0,true); //RESUMEN IMPLANTEJ DE TEJEDOR FACUNDO
			hoja = getDeudasDetallesSheet(libro,2749,false,0,true);//DETALLE IMPLANTEJ DE TEJEDOR FACUNDO
			hoja = getDeudasResumenPeriodoSheet(libro,15156,false,0,true); //RESUMEN MACROFAR S.R.L.
			hoja = getDeudasDetallesSheet(libro,15156,false,0,true);//DETALLE DROGUERIA MACROFAR S.R.L.
			hoja = getDeudasResumenPeriodoSheet(libro,1589,false,0,true); //RESUMEN NR CONSTRUCCIONES S.A.
			hoja = getDeudasDetallesSheet(libro,1589,false,0,true);//DETALLE NR CONSTRUCCIONES S.A.
			hoja = getDeudasResumenPeriodoSheet(libro,-2,false,0,true); //RESUMEN OTROS PROVEEDORES
			hoja = getDeudasDetallesSheet(libro,-2,false,0,true);//DETALLE OTROS PROVEEDORES
			
			hoja.getPrintSetup().setLandscape(true);
			hoja.getPrintSetup().setScale((short)75);
			
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		}	
	}

	public static Result deudasInformeGeneral() {
		
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		
		DynamicForm d = form().bindFromRequest();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-GENERAL-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();
			
			Sheet hoja =getDeudasResumidasSheet(libro,0,false);
			hoja = getDeudasResumidasSheet(libro,Deposito.HEARM,false);
			hoja = getDeudasResumidasSheet(libro,-1,false);
			hoja = getDeudasResumidasSheet(libro,0,true);
			
			hoja = getDeudasMensualSheet(libro);
			hoja = getDeudasDetallesSheet(libro,0,false,0,true);
			
			//RA
			hoja = getDeudasDetallesSheet(libro,-1,false,0,true);
			hoja = getDeudasDetallesSheet(libro,2050,false,0,true);//DROGUERIA SAN MIGUEL de Alfonzo Ramón Dario
			hoja = getDeudasDetallesSheet(libro,1430,false,0,true);//DROGUERIA POSADAS de Colombo Rene Jorge Eduardo
			hoja = getDeudasDetallesSheet(libro,3045,false,0,true);//FARMACIA GROBLI de Alfonzo Ramón Dario
			hoja = getDeudasDetallesSheet(libro,2176,false,0,true);//AT.ME.DO. S.R.L.
			hoja = getDeudasDetallesSheet(libro,14106,false,0,true);//DROGUERIA POSADAS S.R.L.
			hoja = getDeudasDetallesSheet(libro,14441,false,0,true);//DROGUERIA GEMPRO de GENESIS S.A.S.
			hoja = getDeudasDetallesSheet(libro,14971,false,0,true);//FARMACIA GP de Genesis SAS
			hoja = getDeudasDetallesSheet(libro,16359,false,0,true);//BIOFIX de Ezcurra Mariel Cristina
			
			hoja = getDeudasDetallesSheet(libro,14733,false,0,true);//BISIONES S.R.L.
			hoja = getDeudasDetallesSheet(libro,1530,false,0,true);//MOFAR S.A.
			hoja = getDeudasDetallesSheet(libro,4359,false,0,true);//DROGUERIA SAN JORGE S.A.
			hoja = getDeudasDetallesSheet(libro,2749,false,0,true);//IMPLANTEJ DE TEJEDOR FACUNDO
			hoja = getDeudasDetallesSheet(libro,15156,false,0,true);//DROGUERIA MACROFAR S.R.L.
			hoja = getDeudasDetallesSheet(libro,1589,false,0,true);//NR CONSTRUCCIONES S.A.
			//hoja = getDeudasDetallesSheet(libro,1498,false,0,true);
			
			
			hoja = getDeudasDetallesSheet(libro,-2,false,0,true);
			hoja = getDeudasDetallesSheet(libro,0,true,0,true);
			hoja = getDeudasDetallesServiciosSheet(libro);
						
			hoja.getPrintSetup().setLandscape(true);
			hoja.getPrintSetup().setScale((short)75);
			
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		}	
	}	
	
	public static Result deudasDetallesReporte(Integer idProveedor,boolean equipamiento,Integer idCuenta,boolean sinServicio) {
		DynamicForm d = form().bindFromRequest();
		String proveedor = "";
		String equi = "";
		if(idProveedor.compareTo(-1) == 0){
			proveedor = "R.A.";
		}else if(idProveedor.compareTo(0) == 0){
			equi = (equipamiento)?" EQUIPAMIENTOS":"";
			proveedor = "TODOS "+equi;
		}else if(idProveedor.compareTo(-2) == 0){	
			proveedor = "OTROS PROVEEDORES";	
		}else{	
			Proveedor p = Proveedor.find.byId(idProveedor.longValue());
			proveedor = p.nombre;
		}

		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-"+proveedor+"-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = getDeudasDetallesSheet(libro,idProveedor,equipamiento,idCuenta,sinServicio);
			if(hoja != null){
				hoja.getPrintSetup().setLandscape(true);
				hoja.getPrintSetup().setScale((short)75);
			} 
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		}	
	}
	
	public static Sheet getDeudasResumenPeriodoSheet(Workbook libro,Integer idProveedor,boolean equipamiento,Integer idCuenta,boolean sinServicio){
		
		Boolean equi2 = (idProveedor == 0 && !equipamiento)?null:equipamiento;
		String proveedor = "";
		idCuenta = (idCuenta == 0)?null:idCuenta;
		
		if(idProveedor.compareTo(-1) == 0){
			proveedor = "R.A.";
		}else if(idProveedor.compareTo(0) == 0){
			
			if(equipamiento){
				proveedor = "TODOS EQUIPAMIENTOS";
			}
			
		}else if(idProveedor.compareTo(-2) == 0){	
			proveedor = "OTROS PROVEEDORES";	
		}else{	
			Proveedor p = Proveedor.find.byId(idProveedor.longValue());
			proveedor = p.nombre;
		}
		
		Map<String,Map<String,List<List<SqlRow>>>> listaFinal = InformeDeudaPorActaMaterializada.getListaFinalDeudasResumenPeriodoReporte(idProveedor,equi2,idCuenta,sinServicio);
		
		Sheet hoja = null;
		if(listaFinal.size() > 0){
			hoja = libro.createSheet("RESUMEN -"+proveedor);
			hoja.setColumnWidth(0, 5000);
			hoja.setColumnWidth(1, 10000); 
			 
			hoja.setDefaultRowHeight( (short) 350);
			int x = 0;
			x = getListadoDeudasResumenPeriodo(x,"HEARM","OPERATIVA",false,proveedor,libro,hoja,listaFinal,false);
			
			x= 0;
		}
		return hoja;

	}
	
	public static int getListadoDeudasResumenPeriodo(int x,String deposito,String cuenta,boolean servicio,String proveedor,Workbook libro,Sheet hoja,Map<String,Map<String,List<List<SqlRow>>>> listaFinal,boolean todos){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMonedaSinDecimales(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,12);
		CellStyle cabecera = reu.getCabeceraSinDecimales(libro,10);
		

		String nombreProveedor = ""; 
		String fecha = ""; 
		if(listaFinal.get(cuenta) != null){
			if(listaFinal.get(cuenta).get(deposito) != null){
				if(listaFinal.get(cuenta).get(deposito).size() > 0){
					
					Row fila = hoja.createRow(x);
					
					String s2 =(servicio)?"SERVICIOS -":"";
					
					Cell celda0 = fila.createCell(0);
					celda0.setCellValue(s2+cuenta+" - "+proveedor+" - "+utils.DateUtils.getNow());
					celda0.setCellStyle(cabeceraPrincipal);
					
					celda0 = fila.createCell(1);
					celda0.setCellStyle(cabeceraPrincipal);
					hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
					x++;
					
					fila = hoja.createRow(x);
										
					celda0 = fila.createCell(0);
					celda0.setCellValue("PERIODO");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(1);
					celda0.setCellValue("DEUDA");
					celda0.setCellStyle(cabecera);
					x++;
					
					BigDecimal mtdoh = new BigDecimal(0);
					BigDecimal mtcoh = new BigDecimal(0);
					int bandera = 0;
					boolean xx = false;
					BigDecimal total = new BigDecimal(0);
					
					for (List<SqlRow> entry : listaFinal.get(cuenta).get(deposito)) {
						for(SqlRow s : entry){
							fila = hoja.createRow(x);
						    celda0 = fila.createCell(0);
							celda0.setCellValue(s.getString("fecha_mes_ano"));
							celda0.setCellStyle(comun);
							
							celda0 = fila.createCell(1);
							celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							total = total.add(s.getBigDecimal("total_deuda"));
							x++;
							
						}
						fila = hoja.createRow(x);
					    celda0 = fila.createCell(0);
						celda0.setCellValue("TOTAL");
						celda0.setCellStyle(cabecera);
						
						celda0 = fila.createCell(1);
						celda0.setCellValue(total.doubleValue());
						celda0.setCellStyle(cabecera);
						
					}	
					
					
					 
					
				}
			}	
		}
		
		return x;
	}
	
	
	public static Sheet getDeudasDetallesSheet(Workbook libro,Integer idProveedor,boolean equipamiento,Integer idCuenta,boolean sinServicio){
		
		Boolean equi2 = (idProveedor == 0 && !equipamiento)?null:equipamiento;
		String proveedor = "";
		idCuenta = (idCuenta == 0)?null:idCuenta;
		
		if(idProveedor.compareTo(-1) == 0){
			proveedor = "R.A.";
		}else if(idProveedor.compareTo(0) == 0){
			
			if(equipamiento){
				proveedor = "TODOS EQUIPAMIENTOS";
			}
			
		}else if(idProveedor.compareTo(-2) == 0){	
			proveedor = "OTROS PROVEEDORES";	
		}else{	
			Proveedor p = Proveedor.find.byId(idProveedor.longValue());
			proveedor = p.nombre;
		}
		
		Map<String,Map<String,List<List<SqlRow>>>> listaFinal = InformeDeudaPorActaMaterializada.getListaFinalDeudasDetallesReporte(idProveedor,equi2,idCuenta,sinServicio);
		Sheet hoja = null;
		if(listaFinal.size() > 0){
			hoja = libro.createSheet("DETALLE -"+proveedor);
			hoja.setColumnWidth(0, 3000);
			hoja.setColumnWidth(1, 3000);
			hoja.setColumnWidth(2, 15000);
			hoja.setColumnWidth(3, 4200);
			hoja.setColumnWidth(4, 3000);
			hoja.setColumnWidth(5, 5000);
			hoja.setColumnWidth(6, 20000);
			 
			hoja.setDefaultRowHeight( (short) 350);
			
			int x = 0;
			if(idCuenta != null) {
				TipoCuenta tc = TipoCuenta.find.byId(idCuenta.longValue());
				x = getListadoDeudasDetalles(x,"HEARM",tc.nombre,false,proveedor,libro,hoja,listaFinal,true);
			}else {
				x = getListadoDeudasDetalles(x,"HEARM","OPERATIVA",false,proveedor,libro,hoja,listaFinal,false);
				x = getListadoDeudasDetalles(x,"HEARM","PROFE",false,proveedor,libro,hoja,listaFinal,false);
			}
			x= 0;
		}
		return hoja;

	}
	
	public static int getListadoDeudasDetalles(int x,String deposito,String cuenta,boolean servicio,String proveedor,Workbook libro,Sheet hoja,Map<String,Map<String,List<List<SqlRow>>>> listaFinal,boolean todos){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMonedaSinDecimales(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,12);
		CellStyle cabecera = reu.getCabeceraSinDecimales(libro,10);
		

		String nombreProveedor = ""; 
		String fecha = ""; 
		if(listaFinal.get(cuenta) != null){
			if(listaFinal.get(cuenta).get(deposito) != null){
				if(listaFinal.get(cuenta).get(deposito).size() > 0){
					
					Row fila = hoja.createRow(x);
					
					String s2 =(servicio)?"SERVICIOS -":"";
					Cell celda0 = fila.createCell(0);
					celda0.setCellValue(s2+cuenta+" - "+proveedor+" - "+utils.DateUtils.getNow());
					celda0.setCellStyle(cabeceraPrincipal);
					celda0 = fila.createCell(5);
					celda0.setCellStyle(cabeceraPrincipal);
					hoja.addMergedRegion(new  CellRangeAddress(x,x,0,6));
					x++;
					
					fila = hoja.createRow(x);
										
					celda0 = fila.createCell(0);
					celda0.setCellValue("FECHA");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(1);
					celda0.setCellValue("N° EXP");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(2);
					celda0.setCellValue("PROVEEDOR");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(3);
					celda0.setCellValue("DEUDA");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(4);
					celda0.setCellValue("INST.");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(5);
					celda0.setCellValue("RUBRO");
					celda0.setCellStyle(cabecera);
					celda0 = fila.createCell(6);
					celda0.setCellValue("DETALLE");
					celda0.setCellStyle(cabecera);
					x++;
					
					BigDecimal mtdoh = new BigDecimal(0);
					BigDecimal mtcoh = new BigDecimal(0);
					int bandera = 0;
					boolean xx = false;
					BigDecimal total = new BigDecimal(0);
					
					for (List<SqlRow> entry : listaFinal.get(cuenta).get(deposito)) {
						
						boolean cargar = false;
						boolean ss = true;
						
						for(SqlRow s : entry){
					    	
					    	cargar = true;
					    	
					    	if(servicio && s.getString("rubro").compareTo("SERVICIOS") == 0){
					    		cargar = true;
					    	}else if(!servicio && s.getString("rubro").compareTo("SERVICIOS") != 0){
					    		cargar = true;
					    	}if(todos) {
					    		cargar = true;
					    	}
					    	
					    	
					    	if(cargar){
					    		
					    		if(fecha.compareToIgnoreCase("") != 0 && fecha.compareToIgnoreCase(s.getString("fecha_mes_ano")) != 0){
					    			 fila = hoja.createRow(x);
									    celda0 = fila.createCell(0);
										celda0.setCellValue("");
										celda0.setCellStyle(comun);
										hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
										
										celda0 = fila.createCell(2);
										celda0.setCellValue("SUB-TOTAL-"+fecha);
										celda0.setCellStyle(estiloMoneda);
										
										celda0 = fila.createCell(3);
										celda0.setCellValue(mtdoh.doubleValue());
										celda0.setCellStyle(estiloMoneda);
										
										celda0 = fila.createCell(4);
										celda0.setCellStyle(comun);
										celda0 = fila.createCell(5);
										celda0.setCellStyle(comun);
										hoja.addMergedRegion(new  CellRangeAddress(x,x,4,6));
										x++;
										 
										bandera = 0;
										mtdoh = new BigDecimal(0);
					    		}
					    		
					    		
					    		if(bandera == 0){	
								    fila = hoja.createRow(x);
								    celda0 = fila.createCell(0);
									celda0.setCellValue(s.getString("fecha_mes_ano"));
									celda0.setCellStyle(cabecera);
									celda0 = fila.createCell(5);
									celda0.setCellStyle(cabecera);
									hoja.addMergedRegion(new  CellRangeAddress(x,x,0,6));
									ss = false;
									x++;
									bandera = 1;
					    		}	
					    		
					    		xx = true;
					    		fila = hoja.createRow(x);
					    		celda0 = fila.createCell(0);
								celda0.setCellValue(utils.DateUtils.formatDate(s.getDate("fecha")));
								celda0.setCellStyle(comun);
					    		celda0 = fila.createCell(1);
								celda0.setCellValue(s.getString("expediente"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(2);
								celda0.setCellValue(s.getString("nombre_proveedor"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(3);
								celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
								celda0.setCellStyle(estiloMoneda);
								celda0 = fila.createCell(4);
								celda0.setCellValue(s.getString("deposito"));
								celda0.setCellStyle(estiloMoneda);
								celda0 = fila.createCell(5);
								celda0.setCellValue(s.getString("rubro"));
								celda0.setCellStyle(comun);
								celda0 = fila.createCell(6);
								celda0.setCellValue(s.getString("descripcion"));
								celda0.setCellStyle(comun);
								x++;
								mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"));
								total = total.add(s.getBigDecimal("total_deuda"));
								nombreProveedor = s.getString("nombre_proveedor");
								fecha = s.getString("fecha_mes_ano");
					    	}
					    }
					}	
					
					
					if(xx){
						    fila = hoja.createRow(x);
						    celda0 = fila.createCell(0);
							celda0.setCellValue("");
							celda0.setCellStyle(comun);
							hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
							
							celda0 = fila.createCell(2);
							celda0.setCellValue("SUB-TOTAL-"+fecha);
							celda0.setCellStyle(estiloMoneda);
							
							celda0 = fila.createCell(3);
							celda0.setCellValue(mtdoh.doubleValue());
							celda0.setCellStyle(estiloMoneda);
							
							celda0 = fila.createCell(4);
							celda0.setCellStyle(comun);
							celda0 = fila.createCell(5);
							celda0.setCellStyle(comun);
							hoja.addMergedRegion(new  CellRangeAddress(x,x,4,6));
							x++;
					}
					
						fila = hoja.createRow(x);
					    celda0 = fila.createCell(0);
						celda0.setCellValue("");
						celda0.setCellStyle(comun);
						hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
						
						celda0 = fila.createCell(2);
						celda0.setCellValue("TOTAL");
						celda0.setCellStyle(estiloMoneda);
						
						celda0 = fila.createCell(3);
						celda0.setCellValue(total.doubleValue());
						celda0.setCellStyle(estiloMoneda);
						
						celda0 = fila.createCell(4);
						
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(5);
						celda0.setCellStyle(comun);
						hoja.addMergedRegion(new  CellRangeAddress(x,x,4,6));
						x++;
						x++;
						
					fecha ="";					
					bandera = 0;
					
				}
			}	
		}
		
		return x;
	}
	
	public static Result deudasMensualReporte() {
		DynamicForm d = form().bindFromRequest();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-MENSUAL-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = getDeudasMensualSheet(libro);
			/*hoja.getPrintSetup().setLandscape(true);
			hoja.getPrintSetup().setScale((short)75);*/
			 
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		}	
	}
	
	
		

	public  static Sheet getDeudasResumidasSheet(Workbook libro,Integer deposito,boolean ra){
		
		String depositonNombre = (ra)?"GENERAL R.A.":"GENERAL";
		
		if(deposito == Deposito.HEARM){
			depositonNombre = depositonNombre+" HEARM";
		}else if(deposito == -1){
			depositonNombre = depositonNombre+" OTRAS INSTITUCIONES";
		}
		
		List<SqlRow> proveedoresDestacados = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(true,false,deposito,ra,false,false,false);
		List<SqlRow> proveedoresDestacadosServicios = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(true,false,deposito,ra,true,false,false);
		List<SqlRow> proveedoresDestacadosHonorarios = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(true,false,deposito,ra,false,false,true);
		List<SqlRow> proveedoresNoDestacados = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosEquipos = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosServicios = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosHonorarios = new ArrayList<SqlRow>();
		if(!ra){
			proveedoresNoDestacados = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(false,false,deposito,ra,false,false,false);
			proveedoresNoDestacadosEquipos = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(false,false,deposito,ra,false,true,false);
			proveedoresNoDestacadosServicios = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(false,false,deposito,ra,true,false,false);
			proveedoresNoDestacadosHonorarios = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(false,false,deposito,ra,false,false,true);
		}
		
		List<SqlRow> proveedoresDestacadosProfe = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(true,true,deposito,ra,false,false,false);
		List<SqlRow> proveedoresDestacadosProfeServicios = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(true,true,deposito,ra,true,false,false);
		List<SqlRow> proveedoresDestacadosProfeHonorarios = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(true,true,deposito,ra,false,false,true);
		List<SqlRow> proveedoresNoDestacadosProfe = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeEquipos = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeServicios = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeHonorarios = new ArrayList<SqlRow>();
		if(!ra){
			proveedoresNoDestacadosProfe = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(false,true,deposito,ra,false,false,false);
			proveedoresNoDestacadosProfeEquipos = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(false,true,deposito,ra,false,true,false);
			proveedoresNoDestacadosProfeServicios = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(false,true,deposito,ra,true,false,false);
			proveedoresNoDestacadosProfeHonorarios = InformeDeudaPorActaMaterializada.getDeudaResumenPorAntiguedadResumenMensual(false,true,deposito,ra,false,false,true);
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
						//monto_total_compromiso_ra_tmp = monto_total_compromiso_ra_tmp.add(pd.getBigDecimal("total_compromiso"));
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
					//celda0 = fila.createCell(2);
					//celda0.setCellValue(monto_total_compromiso_ra_tmp.doubleValue());
					//celda0.setCellStyle(estiloMoneda);
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
					//celda0 = fila.createCell(2);
					//celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
					//celda0.setCellStyle(estiloMoneda);
					x++;
				}else if(ra){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					//celda0 = fila.createCell(2);
					//celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
					//celda0.setCellStyle(estiloMoneda);
					x++;
				}
				sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
				//sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
			}
		}
		
		
		//NO DESCADOS
		BigDecimal monto_total_deuda_nd = new BigDecimal(0);
		BigDecimal monto_total_compromiso_nd = new BigDecimal(0);
		
		if(proveedoresNoDestacados.size() > 0){
			for(SqlRow pd : proveedoresNoDestacados) {
				monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
				//monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
				sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
				//sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
			}
		
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("OTROS PROVEEDORES");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(monto_total_deuda_nd.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			//celda0 = fila.createCell(2);
			//celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
			//celda0.setCellStyle(estiloMoneda);
			x++;
		}
		
		//NO DESCADOS
		BigDecimal monto_total_deuda_nde = new BigDecimal(0);
		BigDecimal monto_total_compromiso_nde = new BigDecimal(0);
		
		if(proveedoresNoDestacadosEquipos.size() > 0){
			for(SqlRow pd : proveedoresNoDestacadosEquipos) {
				monto_total_deuda_nde= monto_total_deuda_nde.add(pd.getBigDecimal("total_deuda"));
				//monto_total_compromiso_nde= monto_total_compromiso_nde.add(pd.getBigDecimal("total_compromiso"));
				sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
				//sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
			}
		
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("OTROS PROVEEDORES EQUIPOS");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(monto_total_deuda_nde.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			//celda0 = fila.createCell(2);
			//celda0.setCellValue(monto_total_compromiso_nde.doubleValue());
			//celda0.setCellStyle(estiloMoneda);
			x++;
		}
		
		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("SUB-TOTAL");
		celda0.setCellStyle(comun);
		celda0 = fila.createCell(1);
		celda0.setCellValue(sub_monto_total_deuda_nd.doubleValue());
		celda0.setCellStyle(estiloMoneda);
		//celda0 = fila.createCell(2);
		//celda0.setCellValue(sub_monto_total_compromiso_nd.doubleValue());
		//celda0.setCellStyle(estiloMoneda);
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
					//celda0 = fila.createCell(2);
					//celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
					//celda0.setCellStyle(estiloMoneda);
					x++;
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					
					sub_monto_total_deuda_nd_servicio= sub_monto_total_deuda_nd_servicio.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_nd_servicio= sub_monto_total_compromiso_nd_servicio.add(pd.getBigDecimal("total_compromiso"));
				}
			}	
		
			//NO DESCADOS SERVICIOS
			monto_total_deuda_nd = new BigDecimal(0);
			monto_total_compromiso_nd = new BigDecimal(0);
			
			if(proveedoresNoDestacadosServicios.size() > 0){
				for(SqlRow pd : proveedoresNoDestacadosServicios) {
					monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					//monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_nd_servicio= sub_monto_total_deuda_nd_servicio.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_nd_servicio= sub_monto_total_compromiso_nd_servicio.add(pd.getBigDecimal("total_compromiso"));
				}
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("OTROS PROVEEDORES SERVICIOS");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(monto_total_deuda_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				//celda0 = fila.createCell(2);
				//celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
				//celda0.setCellStyle(estiloMoneda);
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
			//celda0 = fila.createCell(2);
			//celda0.setCellValue(sub_monto_total_compromiso_nd_servicio.doubleValue());
			//celda0.setCellStyle(estiloMoneda);
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
					//celda0 = fila.createCell(2);
					//celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
					//celda0.setCellStyle(estiloMoneda);
					x++;
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					
					sub_monto_total_deuda_nd_honorarios= sub_monto_total_deuda_nd_honorarios.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_nd_honorarios= sub_monto_total_compromiso_nd_honorarios.add(pd.getBigDecimal("total_compromiso"));
				}
			}	
			
			//NO DESCADOS HONORARIOS
			monto_total_deuda_nd = new BigDecimal(0);
			monto_total_compromiso_nd = new BigDecimal(0);
			
			if(proveedoresNoDestacadosHonorarios.size() > 0){
				for(SqlRow pd : proveedoresNoDestacadosHonorarios) {
					monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					//monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_nd= sub_monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_nd= sub_monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					
					sub_monto_total_deuda_nd_honorarios= sub_monto_total_deuda_nd_honorarios.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_nd_honorarios= sub_monto_total_compromiso_nd_honorarios.add(pd.getBigDecimal("total_compromiso"));
				}
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("OTROS PROVEEDORES HONORARIOS");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(monto_total_deuda_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				//celda0 = fila.createCell(2);
				//celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
				//celda0.setCellStyle(estiloMoneda);
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
			//celda0 = fila.createCell(2);
			//celda0.setCellValue(sub_monto_total_compromiso_nd_honorarios.doubleValue());
			//celda0.setCellStyle(estiloMoneda);
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
		//celda0 = fila.createCell(2);
		//celda0.setCellValue(sub_monto_total_compromiso_nd.doubleValue());
		//celda0.setCellStyle(estiloMoneda);
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
		//celda0 = fila.createCell(2);
		//celda0.setCellValue("MONTO COMPROMISO");
		//celda0.setCellStyle(cabecera);
		x++;
		
		//DESCTACADOS
		BigDecimal sub_monto_total_deuda_profe = new BigDecimal(0);
		BigDecimal sub_monto_total_compromiso_profe = new BigDecimal(0);
		if(proveedoresDestacadosProfe.size() > 0 || proveedoresNoDestacadosProfe.size() > 0){
			if(proveedoresDestacadosProfe.size() > 0){
				hayra = false;
				
				BigDecimal monto_total_ra_tmp = new BigDecimal(0);
				BigDecimal monto_total_compromiso_ra_tmp = new BigDecimal(0);
				if(!ra){
					for(SqlRow pd : proveedoresDestacadosProfe){
						if(Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))){
							monto_total_ra_tmp = monto_total_ra_tmp.add(pd.getBigDecimal("total_deuda"));
							//monto_total_compromiso_ra_tmp = monto_total_compromiso_ra_tmp.add(pd.getBigDecimal("total_compromiso"));
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
						//celda0 = fila.createCell(2);
						//celda0.setCellValue(monto_total_compromiso_ra_tmp.doubleValue());
						//celda0.setCellStyle(estiloMoneda);
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
						//celda0 = fila.createCell(2);
						//celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
						//celda0.setCellStyle(estiloMoneda);
						x++;
					}else if(ra){
						fila = hoja.createRow(x);
						celda0 = fila.createCell(0);
						celda0.setCellValue(pd.getString("nombre_proveedor"));
						celda0.setCellStyle(comun);
						celda0 = fila.createCell(1);
						celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
						celda0.setCellStyle(estiloMoneda);
						//celda0 = fila.createCell(2);
						//celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
						//celda0.setCellStyle(estiloMoneda);
						x++;
					}
					sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
				}
			}
		
			//NO DESTACADOS
			monto_total_deuda_nd = new BigDecimal(0);
			monto_total_compromiso_nd = new BigDecimal(0);
			if(proveedoresNoDestacadosProfe.size() > 0){
				for(SqlRow pd : proveedoresNoDestacadosProfe) {
					monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					//monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
				}
			
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("OTROS PROVEEDORES");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(monto_total_deuda_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				//celda0 = fila.createCell(2);
				//celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
				//celda0.setCellStyle(estiloMoneda);
				x++;	
			}
			
			//NO DESTACADOS
			monto_total_deuda_nde = new BigDecimal(0);
			monto_total_compromiso_nde = new BigDecimal(0);
			if(proveedoresNoDestacadosProfeEquipos.size() > 0){
				for(SqlRow pd : proveedoresNoDestacadosProfeEquipos) {
					monto_total_deuda_nde= monto_total_deuda_nde.add(pd.getBigDecimal("total_deuda"));
					//monto_total_compromiso_nde= monto_total_compromiso_nde.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
				}
			
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("OTROS PROVEEDORES EQUIPOS");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(monto_total_deuda_nde.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				//celda0 = fila.createCell(2);
				//celda0.setCellValue(monto_total_compromiso_nde.doubleValue());
				//celda0.setCellStyle(estiloMoneda);
				x++;	
			}
			
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("SUB-TOTAL");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_profe.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			//celda0 = fila.createCell(2);
			//celda0.setCellValue(sub_monto_total_compromiso_profe.doubleValue());
			//celda0.setCellStyle(estiloMoneda);
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
					//celda0 = fila.createCell(2);
					//celda0.setCellValue(pd.getBigDecimal("total_compromiso").doubleValue());
					//celda0.setCellStyle(estiloMoneda);
					x++;
					sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
					
					sub_monto_total_deuda_profe_servicio= sub_monto_total_deuda_profe_servicio.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_profe_servicio= sub_monto_total_compromiso_profe_servicio.add(pd.getBigDecimal("total_compromiso"));
				}
			}
		
			//NO DESTACADOS SERVICIOS
			monto_total_deuda_nd = new BigDecimal(0);
			monto_total_compromiso_nd = new BigDecimal(0);
			if(proveedoresNoDestacadosProfeServicios.size() > 0){
				for(SqlRow pd : proveedoresNoDestacadosProfeServicios) {
					monto_total_deuda_nd= monto_total_deuda_nd.add(pd.getBigDecimal("total_deuda"));
					//monto_total_compromiso_nd= monto_total_compromiso_nd.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_profe= sub_monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_profe= sub_monto_total_compromiso_profe.add(pd.getBigDecimal("total_compromiso"));
					sub_monto_total_deuda_profe_servicio= sub_monto_total_deuda_profe_servicio.add(pd.getBigDecimal("total_deuda"));
					//sub_monto_total_compromiso_profe_servicio= sub_monto_total_compromiso_profe_servicio.add(pd.getBigDecimal("total_compromiso"));
				}
			
			
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("OTROS PROVEEDORES SERVICIOS");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(1);
				celda0.setCellValue(monto_total_deuda_nd.doubleValue());
				celda0.setCellStyle(estiloMoneda);
				//celda0 = fila.createCell(2);
				//celda0.setCellValue(monto_total_compromiso_nd.doubleValue());
				//celda0.setCellStyle(estiloMoneda);
				x++;	
			}
		
		
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("SUB-TOTAL-SERVICIO");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(sub_monto_total_deuda_profe_servicio.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			//celda0 = fila.createCell(2);
			//celda0.setCellValue(sub_monto_total_compromiso_profe_servicio.doubleValue());
			//celda0.setCellStyle(estiloMoneda);
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
		//celda0 = fila.createCell(2);
		//celda0.setCellValue(sub_monto_total_compromiso_profe.doubleValue());
		//celda0.setCellStyle(estiloMoneda);
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
		//celda0 = fila.createCell(2);
		//celda0.setCellValue(sub_monto_total_compromiso_nd.add(sub_monto_total_compromiso_profe).doubleValue());
		//celda0.setCellStyle(estiloMoneda);
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
		
		return hoja;
	}
	
	public static Sheet getDeudasMensualNUEVOSheet(Workbook libro){
		
		List<SqlRow> listaFinal = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadResumenMensual(false,false);
		
		Sheet hoja = libro.createSheet("RESUMEN - MENSUAL");
		hoja.getPrintSetup().setLandscape(true);
		hoja.getPrintSetup().setScale((short)75);
		
		int x = 0;
		if(listaFinal.size() > 0){
			x = getListadoDeudasMensual("OPERATIVA",libro,hoja,listaFinal,0,false,0,null);
		}
		
		x= 0;
		
		return hoja;
	}
	
	
	public static Sheet getDeudasMensualSheet(Workbook libro){
		
		List<SqlRow> listaFinal = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadResumenMensual(false,false);
		List<SqlRow> listaFinalProfe = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorAntiguedadResumenMensual(true,false);
		List<SqlRow> listaFinalServiciosHospital = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorPeriodoPorAntiguedadResumenMensual(false,true,true);
		List<SqlRow> listaFinalServiciosParque = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorPeriodoPorAntiguedadResumenMensual(false,true,false);
		List<SqlRow> listaFinalServiciosTotal = InformeDeudaPorActaMaterializada.getDeudaPorProveedorPorPeriodoPorAntiguedadResumenMensual(false,true,null);
		Sheet hoja = libro.createSheet("RESUMEN - MENSUAL");
		hoja.getPrintSetup().setLandscape(true);
		hoja.getPrintSetup().setScale((short)75);
		
		int x = 0;
		if(listaFinal.size() > 0){
			x = getListadoDeudasMensual("OPERATIVA",libro,hoja,listaFinal,0,false,0,null);
		}
		if(listaFinalProfe.size() > 0){
			//x = getListadoDeudasMensual("PROFE",libro,hoja,listaFinalProfe,0,false,7,null);
		}
		x = getListadoDeudasMensualServicios("SERVICIOS",libro,hoja,listaFinalServiciosTotal,18,true,3,"TOTAL");
		x = getListadoDeudasMensualServicios("SERVICIOS",libro,hoja,listaFinalServiciosHospital,18,true,1,"HEARM");
		x = getListadoDeudasMensualServicios("SERVICIOS",libro,hoja,listaFinalServiciosParque,18,true,2,"PARQUE");
		
		x= 0;
		
		return hoja;
	}
	
	public static int getListadoDeudasMensualServicios(String cuenta,Workbook libro,Sheet hoja,List<SqlRow> listaFinal,int start,boolean servicios,int f,String lugarTitulo){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,12);
		CellStyle cabecera = reu.getCabecera(libro,10);
		
		hoja.setColumnWidth(0, 4200);
		
		int ss = start; 
		if(listaFinal != null){
			Row fila = hoja.getRow(ss);
			if(fila == null){
				fila = hoja.createRow(ss);
			}
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("SERVICIOS - "+utils.DateUtils.getNow());
			celda0.setCellStyle(cabeceraPrincipal);
			celda0 = fila.createCell(3);
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(ss,ss,0,3));
			ss++;	
			
			fila = hoja.getRow(ss);
			if(fila == null){
				fila = hoja.createRow(ss);
			}
			celda0 = fila.createCell(0);
			celda0.setCellValue("PERIODO");
			celda0.setCellStyle(cabeceraPrincipal);
			
			celda0 = fila.createCell(f);
			celda0.setCellValue(lugarTitulo);
			celda0.setCellStyle(cabeceraPrincipal);
			ss++;
			
			for(SqlRow srl:listaFinal){
				
				fila = hoja.getRow(ss);
				if(fila == null){
					fila = hoja.createRow(ss);
					celda0 = fila.createCell(0);
					celda0.setCellValue(srl.getString("mes")+"/"+srl.getString("ejercicio"));
					celda0.setCellStyle(comun);
					
					fila = hoja.getRow(ss);
					celda0 = fila.createCell(f);
					celda0.setCellValue(srl.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					
				}else{
					
					
					boolean t = true;
					while(t){
						fila = hoja.getRow(ss);
						celda0 = fila.getCell(0);
						if(celda0.getStringCellValue().compareToIgnoreCase(srl.getString("mes")+"/"+srl.getString("ejercicio")) == 0){
							
							celda0 = fila.createCell(f);
							celda0.setCellValue(srl.getBigDecimal("total_deuda").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							t= false;
						}else{
							celda0 = fila.createCell(f);
							celda0.setCellStyle(comun);
							ss++;
						}
					}
				}
				
				
					 
				ss++;
				
				
			}
		}
		//f++;
		return f;
	}	
	
	public static int getListadoDeudasMensual(String cuenta,Workbook libro,Sheet hoja,List<SqlRow> listaFinal,int start,boolean servicios,int f,String lugarTitulo){
		String[] meses = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMonedaSinDecimales(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,12);
		CellStyle cabecera = reu.getCabeceraSinDecimales(libro,10);
		
		List<String> ejercicios = new ArrayList<String>();
		Map<String,Map<String,BigDecimal>> listaMontos = new HashMap<String,Map<String,BigDecimal>>();
		hoja.setColumnWidth(0, 4200);
		
		int ss = start; 
		if(listaFinal != null){
			for(SqlRow srl:listaFinal){
				//if(!ejercicios.contains(srl.getString("ejercicio"))){
				String ejercicio = (srl.getString("ejercicio") != null)?srl.getString("ejercicio"):"S/D";
				String mes = (srl.getString("mes") != null)?srl.getString("mes"):"S/D";
				String periodo_id = (srl.getString("periodo_id") != null)?srl.getString("periodo_id"):"S/D";
				
				if(!listaMontos.containsKey(ejercicio)){
					ejercicios.add(ejercicio);
					
					Map<String,BigDecimal> mx = new HashMap<String,BigDecimal>();
					BigDecimal m = srl.getBigDecimal("total_deuda");
					 
					mx.put(mes, m);
					listaMontos.put(ejercicio, mx);
				
				}else{
					 
					Map<String,BigDecimal> listaMontosTmp  = listaMontos.get(ejercicio);
					if(!listaMontosTmp.containsKey(mes)){
						BigDecimal m = srl.getBigDecimal("total_deuda");
						 
						listaMontosTmp.put(mes, m);
						listaMontos.remove(ejercicio);
						listaMontos.put(ejercicio, listaMontosTmp);
					}else{
						BigDecimal mtmp = listaMontosTmp.get(periodo_id);
						mtmp = srl.getBigDecimal("total_deuda");
						
						listaMontosTmp.remove(mes);
						listaMontosTmp.put(mes, mtmp);
						listaMontos.remove(ejercicio);
						listaMontos.put(ejercicio, listaMontosTmp);
					}
				}
			}
			
			
			int ff = f; 
			
			for(int j=0;j<6;j++){
				hoja.setColumnWidth(j, 4200); 
				hoja.setDefaultRowHeight( (short) 340);
			}
			
			
			//Row fila = hoja.createRow(ss);
			Row fila = hoja.getRow(ss);
			if(fila == null){
				fila = hoja.createRow(ss);
			}
			Cell celda0 = fila.createCell(f);
			celda0.setCellValue(cuenta+" - "+utils.DateUtils.getNow());
			celda0.setCellStyle(cabeceraPrincipal);
			celda0 = fila.createCell(ejercicios.size()+f);
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(ss,ss,(servicios)?0:ff,ejercicios.size()+f));
			ss++;
			
			if(servicios){
				fila = hoja.getRow(ss);
				if(fila == null){
					fila = hoja.createRow(ss);
				}
				celda0 = fila.createCell(f);
				celda0.setCellValue(lugarTitulo);
				celda0.setCellStyle(cabecera);
				celda0 = fila.createCell(ejercicios.size()+f);
				celda0.setCellStyle(cabeceraPrincipal);
				hoja.addMergedRegion(new  CellRangeAddress(ss,ss,f,ejercicios.size()+f));
				ss++;
			}
			
			
			fila = hoja.getRow(ss);
			if(fila == null){
				fila = hoja.createRow(ss);
			}
			celda0 = fila.createCell(f);
			celda0.setCellValue("MES");
			celda0.setCellStyle(cabecera);
			ss++;
			
			
			for(String sm : meses){
				fila = hoja.getRow(ss);
				if(fila == null){
					fila = hoja.createRow(ss);
				}
				celda0 = fila.createCell(f);
				celda0.setCellValue(sm);
				celda0.setCellStyle(comun);
				ss++;
				 
			}
			
			fila = hoja.getRow(ss);
			if(fila == null){
				fila = hoja.createRow(ss);
			}
			celda0 = fila.createCell(f);
			celda0.setCellValue("SUBTOTALES");
			celda0.setCellStyle(cabecera);
			ss++;
			 
			fila = hoja.getRow(ss);
			if(fila == null){
				fila = hoja.createRow(ss);
			}
			celda0 = fila.createCell(f);
			celda0.setCellValue("TOTAL");
			celda0.setCellStyle(cabecera);
			ss++;
			 
			
			
			//f = 1;
			BigDecimal subtotal = new BigDecimal(0);
			BigDecimal total = new BigDecimal(0);
			
			f++;
			
			for(String ef :ejercicios){
				subtotal = new BigDecimal(0);
				if(servicios){
					ss = start+2; // titulo EJERCICIOS
				}else{
					ss = start+1; // titulo EJERCICIOS
				}
				
				fila = hoja.getRow(ss);	//1
				celda0 = fila.createCell(f);
				celda0.setCellValue(ef);// titulo EJERCICIOS
				celda0.setCellStyle(cabecera);
				ss++;
				
				for(String sm : meses){
					
					fila = hoja.getRow(ss);
		    		celda0 = fila.createCell(f);
					celda0.setCellValue(0);
					celda0.setCellStyle(estiloMoneda);
					
					for(Map.Entry<String,BigDecimal> entry : listaMontos.get(ef).entrySet()){
						
						if( entry.getKey().compareTo(sm) == 0){
							fila = hoja.getRow(ss);
				    		celda0 = fila.createCell(f);
							celda0.setCellValue(entry.getValue().doubleValue());
							celda0.setCellStyle(estiloMoneda);
							subtotal= subtotal.add(entry.getValue());
							total= total.add(entry.getValue());
						}
					}
					ss++;
				}
				
				fila = hoja.getRow(ss);
	    		celda0 = fila.createCell(f);
	    		celda0.setCellValue(subtotal.doubleValue());
				celda0.setCellStyle(cabecera);
				
				f++;
			}
			ss++;
			
			Logger.debug("zzzzzzzzzzzzzz "+ejercicios);
			Logger.debug("xxxxxxxxxxxxxx "+ejercicios.size());
			
			hoja.addMergedRegion(new  CellRangeAddress(ss,ss,ff+1,ejercicios.size()+ff));
			fila = hoja.getRow(ss);	 
			celda0 = fila.createCell(ejercicios.size()+ff);
			celda0.setCellStyle(cabecera);
			
			fila = hoja.getRow(ss);	 
			celda0 = fila.createCell(ff+1);
			celda0.setCellValue(total.doubleValue());
			celda0.setCellStyle(cabecera); 
		}
		//f++;
		return f;
	}
	
	public static Result deudasDetallePorInstitucionReporte() {
		DynamicForm d = form().bindFromRequest();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-DETALLE-INSTITUCION-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = getDeudasDetallePorInstitucionSheet(libro);
			
			 
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		}	
	}
	
	public static Sheet getDeudasDetallePorInstitucionSheet(Workbook libro){
		
		Map<String,List<SqlRow>>  listaFinal = InformeDeudaPorActaMaterializada.getListaFinalDeudasDetallesInstitucionReporte();
		
		Sheet hoja = libro.createSheet("DEUDAD - INSTITUCION");
		hoja.setColumnWidth(0, 3100);
		hoja.setColumnWidth(1, 3100);
		hoja.setColumnWidth(2, 15000);
		hoja.setColumnWidth(3, 5000);
		hoja.setColumnWidth(4, 5000);
		hoja.setColumnWidth(5, 5000);
		hoja.setColumnWidth(6, 20000);
		 
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasDetallePorInstitucion(x,"OPERATIVA",libro,hoja,listaFinal.get("OPERATIVA"));
		x = getListadoDeudasDetallePorInstitucion(x,"PROFE",libro,hoja,listaFinal.get("PROFE"));
		x= 0;
		
		return hoja;

	}
	
	public static int getListadoDeudasDetallePorInstitucion(int x,String cuenta,Workbook libro,Sheet hoja,List<SqlRow> listaFinal){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,12);
		CellStyle cabecera = reu.getCabecera(libro,10);
		
		String fecha = ""; 
		String deposito = ""; 
		if(listaFinal != null){
			if(listaFinal.size() > 0){
				
				Row fila = hoja.createRow(x);
				
				 
				Cell celda0 = fila.createCell(0);
				celda0.setCellValue(cuenta+" - "+utils.DateUtils.getNow());
				celda0.setCellStyle(cabeceraPrincipal);
				hoja.addMergedRegion(new  CellRangeAddress(x,x,0,6));
				x++;
				
				fila = hoja.createRow(x);
				
				
				celda0 = fila.createCell(0);
				celda0.setCellValue("FECHA");
				celda0.setCellStyle(cabecera);
				celda0 = fila.createCell(1);
				celda0.setCellValue("N° EXP");
				celda0.setCellStyle(cabecera);
				celda0 = fila.createCell(2);
				celda0.setCellValue("PROVEEDOR");
				celda0.setCellStyle(cabecera);
				celda0 = fila.createCell(3);
				celda0.setCellValue("DEUDA");
				celda0.setCellStyle(cabecera);
				celda0 = fila.createCell(4);
				celda0.setCellValue("INSTITUCION");
				celda0.setCellStyle(cabecera);
				celda0 = fila.createCell(5);
				celda0.setCellValue("RUBRO");
				celda0.setCellStyle(cabecera);
				celda0 = fila.createCell(6);
				celda0.setCellValue("DETALLE");
				celda0.setCellStyle(cabecera);
				x++;
				BigDecimal mtdoh = new BigDecimal(0);
				BigDecimal mtcoh = new BigDecimal(0);
				int bandera = 0;
				boolean xx = false;
				for (SqlRow s : listaFinal) {
					
			    	if(deposito.compareToIgnoreCase("") != 0 && deposito.compareToIgnoreCase(s.getString("deposito")) != 0){
			    		fila = hoja.createRow(x);
					    celda0 = fila.createCell(0);
						celda0.setCellValue("");
						celda0.setCellStyle(comun);
						hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
						
						celda0 = fila.createCell(2);
						celda0.setCellValue("SUB-TOTAL-"+deposito);
						celda0.setCellStyle(estiloMoneda);
						
						celda0 = fila.createCell(3);
						celda0.setCellValue(mtdoh.doubleValue());
						celda0.setCellStyle(estiloMoneda);
						
						celda0 = fila.createCell(4);
						celda0.setCellValue("");
						celda0.setCellStyle(comun);
						hoja.addMergedRegion(new  CellRangeAddress(x,x,4,6));
						x++;
						x++;
						bandera = 0;
						mtdoh = new BigDecimal(0);
		    		}
		    		
		    		
		    		if(bandera == 0){	
					    fila = hoja.createRow(x);
					    celda0 = fila.createCell(0);
						celda0.setCellValue(s.getString("deposito"));
						 
						celda0.setCellStyle(cabecera);
						hoja.addMergedRegion(new  CellRangeAddress(x,x,0,6));
						 
						x++;
						bandera = 1;
		    		}	
		    		
		    		xx = true;
		    		fila = hoja.createRow(x);
		    		celda0 = fila.createCell(0);
					celda0.setCellValue(utils.DateUtils.formatDate(s.getDate("fecha")));
					celda0.setCellStyle(comun);
		    		celda0 = fila.createCell(1);
					celda0.setCellValue(s.getString("expediente"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(2);
					celda0.setCellValue(s.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(3);
					celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(4);
					celda0.setCellValue(s.getString("deposito"));
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(5);
					celda0.setCellValue(s.getString("rubro"));
					celda0.setCellStyle(comun);
					celda0 = fila.createCell(6);
					celda0.setCellValue(s.getString("descripcion"));
					celda0.setCellStyle(comun);
					x++;
					mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"));
					 
					
					fecha = s.getString("fecha_mes_ano");
					deposito = s.getString("deposito"); 
				}	
				
				 if(xx){
				    fila = hoja.createRow(x);
				    celda0 = fila.createCell(0);
					celda0.setCellValue("");
					celda0.setCellStyle(comun);
					hoja.addMergedRegion(new  CellRangeAddress(x,x,0,1));
					
					celda0 = fila.createCell(2);
					celda0.setCellValue("SUB-TOTAL-"+deposito);
					celda0.setCellStyle(estiloMoneda);
					
					celda0 = fila.createCell(3);
					celda0.setCellValue(mtdoh.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					
					celda0 = fila.createCell(4);
					celda0.setCellValue("");
					celda0.setCellStyle(comun);
					hoja.addMergedRegion(new  CellRangeAddress(x,x,4,6));
					x++;
					x++;
				 }
				 
				 fecha ="";					
				 bandera = 0;
				 deposito = "";
				
			}
		}	
		 
		
		return x;
	}
	
	public static Result deudasResumenPorInstitucionReporte() {
		DynamicForm d = form().bindFromRequest();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-INSTITUCION-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+Usuario.getUsuarioSesion()+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = getDeudasResumenPorInstitucionSheet(libro);
			
			 
			libro.write(archivoTmp); 
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		}	
	}
	
	public static Sheet getDeudasResumenPorInstitucionSheet(Workbook libro){
		
		Map<String,List<SqlRow>>  listaFinal = InformeDeudaPorActaMaterializada.getListaFinalDeudasDetallesInstitucionReporte();
		
		Sheet hoja = libro.createSheet("DEUDAD - INSTITUCION");
		hoja.setColumnWidth(0, 3100);
		hoja.setColumnWidth(1, 3100);
		hoja.setColumnWidth(2, 3100);
		hoja.setColumnWidth(3, 3100);
		hoja.setColumnWidth(4, 3100);
		hoja.setColumnWidth(5, 3100);
		hoja.setColumnWidth(6, 3100);
		hoja.setColumnWidth(7, 3100);
		hoja.setColumnWidth(8, 3100);
		hoja.setColumnWidth(9, 3100);
		hoja.setColumnWidth(10, 3100);
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasResumenPorInstitucion(x,libro,hoja);
		x= 0;
		
		return hoja;
	}
	
	public static int getListadoDeudasResumenPorInstitucion(int x,Workbook libro,Sheet hoja){
		
		//----------------------------------rejunte de datos
		List<String> instiOp = new ArrayList<String>();
		List<String> instiProfe = new ArrayList<String>();
		Map<String,BigDecimal> instiMonto = new HashMap<String,BigDecimal>();
		Map<String,BigDecimal> instiMontoTotalOperativa = new HashMap<String,BigDecimal>();
		Map<String,BigDecimal> instiMontoTotalProfe = new HashMap<String,BigDecimal>();
		Map<Long,Map<String,BigDecimal>> periodoInsti = new HashMap<Long,Map<String,BigDecimal>>();
		Map<String,Map<Long,Map<String,BigDecimal>>> listaFinal = new HashMap<String, Map<Long,Map<String,BigDecimal>>>();
		
		//OPERTATIVAAAA
		List<SqlRow> operativa = InformeDeudaPorActaMaterializada.getDeudaPorInstitucionPorAntiguedadResumen(false);
		
		for(SqlRow z :operativa){
			instiMonto = new HashMap<String,BigDecimal>();
			Periodo p = Periodo.find.where().eq("nombre", z.getString("fecha_mes_ano")).findUnique();
			
			if(periodoInsti.get(p.id) == null){
				instiMonto.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
				periodoInsti.put(p.id, instiMonto);
			}else{
				
				Map<String,BigDecimal> instiMontoTmp = periodoInsti.get(p.id);
				if(instiMontoTmp.get(z.getString("deposito")) == null){
					instiMontoTmp.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
					periodoInsti.remove(p.id);
					periodoInsti.put(p.id, instiMontoTmp);
				}
			}
			if(!instiOp.contains(z.getString("deposito"))){
				instiOp.add(z.getString("deposito"));
			}
			if(instiMontoTotalOperativa.get(z.getString("deposito")) == null){
				instiMontoTotalOperativa.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
			}else{
				BigDecimal xtmp = instiMontoTotalOperativa.get(z.getString("deposito")).add(z.getBigDecimal("total_deuda"));
				instiMontoTotalOperativa.remove(z.getString("deposito"));
				instiMontoTotalOperativa.put(z.getString("deposito"), xtmp);
			}
			
		}
		Map<Long,Map<String,BigDecimal>> sortedPeriodoInsti = new TreeMap<Long,Map<String,BigDecimal>>(periodoInsti);
		listaFinal.put("OPERATIVA", sortedPeriodoInsti);
		
		//PROFEEEEEE
		instiMonto = new HashMap<String,BigDecimal>();
		periodoInsti = new HashMap<Long,Map<String,BigDecimal>>();
		
		List<SqlRow> profe = InformeDeudaPorActaMaterializada.getDeudaPorInstitucionPorAntiguedadResumen(true);
		for(SqlRow z :profe){
			 
			instiMonto = new HashMap<String,BigDecimal>();
			Periodo p = Periodo.find.where().eq("nombre", z.getString("fecha_mes_ano")).findUnique();
			if(periodoInsti.get(p.id) == null){
				instiMonto.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
				periodoInsti.put(p.id, instiMonto);
			}else{
				Map<String,BigDecimal> instiMontoTmp = periodoInsti.get(p.id);
				if(instiMontoTmp.get(z.getString("deposito")) == null){
					instiMontoTmp.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
					periodoInsti.remove(p.id);
					periodoInsti.put(p.id, instiMontoTmp);
				}
			}
			
			
			if(!instiProfe.contains(z.getString("deposito"))){
				instiProfe.add(z.getString("deposito"));
			}
			
			if(instiMontoTotalProfe.get(z.getString("deposito")) == null){
				instiMontoTotalProfe.put(z.getString("deposito"), z.getBigDecimal("total_deuda"));
			}else{
				BigDecimal xtmp = instiMontoTotalProfe.get(z.getString("deposito")).add(z.getBigDecimal("total_deuda"));
				instiMontoTotalProfe.remove(z.getString("deposito"));
				instiMontoTotalProfe.put(z.getString("deposito"), xtmp);
			}
		} 
		sortedPeriodoInsti = new TreeMap<Long,Map<String,BigDecimal>>(periodoInsti);
		listaFinal.put("PROFE", sortedPeriodoInsti);
		
		//----------------------------------armado de excel
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,12);
		CellStyle cabecera = reu.getCabecera(libro,10);
		
		
		if(listaFinal.get("OPERATIVA") != null){
			Row fila = hoja.createRow(x);
			fila = hoja.createRow(x);
			
			
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("OPERATIVA - "+utils.DateUtils.getNow());
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,instiOp.size()));
			x++;
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("Periodo/Institucion");
			celda0.setCellStyle(cabecera);
			int z = 1; 
			for(String i :instiOp){
				celda0 = fila.createCell(z);
				celda0.setCellValue(i);
				celda0.setCellStyle(cabecera);
				z++;
			}
			x++;
			
			for (Map.Entry<Long,Map<String,BigDecimal>> entry : listaFinal.get("OPERATIVA").entrySet()) {
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue(Periodo.find.byId(entry.getKey()).nombre);
				celda0.setCellStyle(comun);
				
				z = 1; 
				for(String i :instiOp){
					celda0 = fila.createCell(z);
					if(entry.getValue().get(i) != null){
						celda0.setCellValue(entry.getValue().get(i).doubleValue());
						celda0.setCellStyle(estiloMoneda);
					}else{
						celda0.setCellValue(0);
						celda0.setCellStyle(estiloMoneda);
					}
					z++;
				}
				x++;
			}
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTALES");
			celda0.setCellStyle(comun);
			
			z = 1;
			for(String i :instiOp){
				 
				celda0 = fila.createCell(z);
				if(instiMontoTotalOperativa.get(i) != null){
					celda0.setCellValue(instiMontoTotalOperativa.get(i).doubleValue());
					celda0.setCellStyle(estiloMoneda);
				}else{
					celda0.setCellValue(0);
					celda0.setCellStyle(estiloMoneda);
				}
				z++;
			}
		}
		x++;
		x++;
		if(listaFinal.get("PROFE") != null){
			Row fila = hoja.createRow(x);
			fila = hoja.createRow(x);
			
			
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("PROFE - "+utils.DateUtils.getNow());
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,instiProfe.size()));
			x++;
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("Periodo/Institucion");
			celda0.setCellStyle(cabecera);
			int z = 1; 
			for(String i :instiProfe){
				celda0 = fila.createCell(z);
				celda0.setCellValue(i);
				celda0.setCellStyle(cabecera);
				z++;
			}
			x++;
			
			for (Map.Entry<Long,Map<String,BigDecimal>> entry : listaFinal.get("PROFE").entrySet()) {
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue(Periodo.find.byId(entry.getKey()).nombre);
				celda0.setCellStyle(comun);
				
				z = 1; 
				for(String i :instiProfe){
					celda0 = fila.createCell(z);
					if(entry.getValue().get(i) != null){
						celda0.setCellValue(entry.getValue().get(i).doubleValue());
						celda0.setCellStyle(estiloMoneda);
					}else{
						celda0.setCellValue(0);
						celda0.setCellStyle(estiloMoneda);
					}
					z++;
				}
				x++;
			}
			
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTALES");
			celda0.setCellStyle(comun);
			
			z = 1;
			for(String i :instiProfe){
				 
				celda0 = fila.createCell(z);
				if(instiMontoTotalProfe.get(i) != null){
					celda0.setCellValue(instiMontoTotalProfe.get(i).doubleValue());
					celda0.setCellStyle(estiloMoneda);
				}else{
					celda0.setCellValue(0);
					celda0.setCellStyle(estiloMoneda);
				}
				z++;
			}
		}
		
		return x;
	}
	
	public static Result deudasDetallesServiciosReportes() {
		DynamicForm d = form().bindFromRequest();
		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN-SERVICIOS-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+Usuario.getUsuarioSesion()+".xls");
		
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
			return ok(index.render(d));
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render(d));
		}	
	}	
	
	public static Sheet getDeudasDetallesServiciosSheet(Workbook libro){
		
		String cuenta = "OPERATIVA"; 
		
		List<SqlRow> proveedorHEARM = InformeDeudaPorActaMaterializada.getDeudaServiciosPorPeriodoPorAntiguedadResumenMensual(false,true,true);
		List<SqlRow> proveedorOtros = InformeDeudaPorActaMaterializada.getDeudaServiciosPorPeriodoPorAntiguedadResumenMensual(false,true,false);
		List<SqlRow> proveedorTodos = InformeDeudaPorActaMaterializada.getDeudaServiciosPorPeriodoPorAntiguedadResumenMensual(false,true,null);
		
		Sheet hoja = libro.createSheet("SERVICIOS OPERATIVA");
		
		hoja.setDefaultRowHeight( (short) 400);
		
		int x = 0;
		x = getListadoDeudasDetallesServicios(proveedorHEARM,proveedorOtros,proveedorTodos,x,libro,hoja,cuenta);
		//x = getListadoDeudasDetallesServicios(proveedorOtros,"OTROS",x,libro,hoja,cuenta);
				
		return hoja;
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
			String expedienteOp = ph.getLong("expediente_id").toString()+ph.getLong("orden_provision_id").toString();
			
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
		CellStyle cabeceraPrincipal = reu.getCabecera(libro,12);
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
		int cc = 4;
		for(Long pi :peridoIds){
			hoja.setColumnWidth(cc, 3500);
			cc++;
		}
		hoja.setColumnWidth(cc, 3900);
		
		Cell celda0 = fila.createCell(0);
		celda0.setCellValue("OPERATIVA - HEARM - "+utils.DateUtils.getNow());
		celda0.setCellStyle(cabeceraPrincipal);
		celda0 = fila.createCell(4+peridoIds.size());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,4+peridoIds.size()));
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
		celda0.setCellValue("S/D");
		celda0.setCellStyle(cabecera);
		
		cc = 4;
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
			if(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null){
				celda0.setCellValue(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).doubleValue());
				totalTr = totalTr.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()));
				totalHearm = totalHearm.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()));
			}else{
				celda0.setCellValue(BigDecimal.ZERO.doubleValue());
			}
			celda0.setCellStyle(estiloMoneda);
			
			cc = 4;
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
		celda0.setCellValue("");
		celda0.setCellStyle(estiloMonedaSubtotal);
		
		cc = 4;
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
		celda0 = fila.createCell(4+peridoIds.size());
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,4+peridoIds.size()));
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
		celda0.setCellValue("S/D");
		celda0.setCellStyle(cabecera);
		
		cc = 4;
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
			if(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()) != null){
				celda0.setCellValue(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()).doubleValue());
				totalTr = totalTr.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()));
				totalOtro = totalOtro.add(deudaSinPeriodos.get(s.getLong("expediente_id").toString()+s.getLong("orden_provision_id").toString()));
			}else{
				celda0.setCellValue(BigDecimal.ZERO.doubleValue());
			}
			celda0.setCellStyle(estiloMoneda);
			
			cc = 4;
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
		celda0.setCellValue("");
		celda0.setCellStyle(estiloMonedaSubtotal);
		
		cc = 4;
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
}
