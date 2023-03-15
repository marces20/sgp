package controllers.dashboard;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.avaje.ebean.ExpressionList;

import models.ActaRecepcion;
import models.Estado;
import models.Pago;
import models.Periodo;
import models.Proveedor;
import models.Usuario;
import models.informes.InformeEstadisticoDeudaProveedores;
import models.informes.InformeEstadisticoPagoProveedores;
import play.Logger;
import play.Play;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.contabilidad.facturas.crearFacturaProveedor;
import views.html.dashboard.informeEstadisticoPagoProveedores.*;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class InformeEstadisticoPagoProveedoresController extends Controller {
	
	final static Form<InformeEstadisticoPagoProveedores> form = form(InformeEstadisticoPagoProveedores.class);
	
	@CheckPermiso(key = "dashboardInformeDeudaProveedores")
	public static Result index() {
	
		Pagination<InformeEstadisticoPagoProveedores> i = InformeEstadisticoPagoProveedores.page(
																								RequestVar.get("proveedor_id"), 
																								RequestVar.get("expediente_id"), 
																								RequestVar.get("ejercicio"), 
																								RequestVar.get("rubro_id"), 
																								RequestVar.get("deposito_id"),
																								RequestVar.get("fecha_pago_desde"),
																								RequestVar.get("fecha_pago_hasta"),
																								RequestVar.get("btnFiltro[0]"),//borrador
																								RequestVar.get("btnFiltro[1]"),//contabilizado
																								RequestVar.get("btnFiltro[2]"),//rendido
																								RequestVar.get("btnFiltro[3]"),//imputado
																								RequestVar.get("btnFiltro[4]"),
																								RequestVar.get("cuenta"),
																								RequestVar.get("profe"),
																								RequestVar.get("impuesto"),
																								RequestVar.get("tipo_cuenta_id")
																								);
		
		return ok(index.render(i, form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "dashboardInformeDeudaProveedores")
	public static Result archivoEstadistico () {

		Pagination<InformeEstadisticoPagoProveedores> informe = InformeEstadisticoPagoProveedores.page(
																										RequestVar.get("proveedor_id"), 
																										RequestVar.get("expediente_id"), 
																										RequestVar.get("ejercicio"), 
																										RequestVar.get("rubro_id"), 
																										RequestVar.get("deposito_id"),
																										RequestVar.get("fecha_pago_desde"),
																										RequestVar.get("fecha_pago_hasta"),
																										RequestVar.get("btnFiltro[0]"),//borrador
																										RequestVar.get("btnFiltro[1]"),//contabilizado
																										RequestVar.get("btnFiltro[2]"),//rendido
																										RequestVar.get("btnFiltro[3]"),//imputado
																										RequestVar.get("btnFiltro[4]"),
																										RequestVar.get("cuenta"),
																										RequestVar.get("profe"),
																										RequestVar.get("impuesto"),
																										RequestVar.get("tipo_cuenta_id"));

		
		String dirTemp = System.getProperty("java.io.tmpdir");
		
		Integer fila = 10;
		
		Integer celdaFecha 		 = 0;
		Integer celdaProveedor	 = 1;
		Integer celdaExp  		 = 2;
		Integer celdaRubro 		 = 3;
		Integer celdaInstitucion = 4;
		Integer celdaTotal 	 	 = 5;
		Integer celdaEstado 	 = 6;
		
		Integer imp1 	 = 7;
		Integer imp2 	 = 8;
		Integer imp3 	 = 9;
		Integer imp4 	 = 10;
		Integer imp5 	 = 11;
		Integer imp6 	 = 12;
		Integer imp7 	 = 13;
		Integer imp8 	 = 14;
		Integer imp9 	 = 14;
		
		
		
		try {
			File archivo = new File(dirTemp+"/informe-estadistico-"+Usuario.getUsuarioSesion()+".xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/dashboard/informe-estadistico-pago.xls"));
			
			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;


			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));
			
			Row f = hoja.createRow(8);
			//RET. D.G.R. - SELLOS 1 % - R.G. 13/97
			celda = f.createCell(imp1);
			celda.setCellValue("RET. D.G.R. - SELLOS 1 % - R.G. 13/97");
			celda.setCellStyle(style);
			//RET.AFIP-DGI- GCIAS. 2% RES.AFIP 4245/18
			
			celda = f.createCell(imp2);
			celda.setCellValue("RET.AFIP-DGI- GCIAS. 2% RES.AFIP 4245/18");
			celda.setCellStyle(style);
			//RET.AFIP-DGI- GCIAS. 2% RES.AFIP 4525/19
			
			celda = f.createCell(imp3);
			celda.setCellValue("RET.AFIP-DGI- GCIAS. 2% RES.AFIP 4525/19");
			celda.setCellStyle(style);
			//SUSS 1% Res AFIP 2069/06, MOF 1784/04
			
			celda = f.createCell(imp4);
			celda.setCellValue("SUSS 1% Res AFIP 2069/06, MOF 1784/04");
			celda.setCellStyle(style);
			//RET.AFIP-DGI- GCIAS. 2% RES.AFIP 3884/16
			
			celda = f.createCell(imp5);
			celda.setCellValue("RET.AFIP-DGI- GCIAS. 2% RES.AFIP 3884/16");
			celda.setCellStyle(style);
			//SUSS 2% Res. AFIP 1784/04
			
			celda = f.createCell(imp6);
			celda.setCellValue("SUSS 2% Res. AFIP 1784/04");
			celda.setCellStyle(style);
			//RET. AFIP - DGI - GCIAS. 2% RES. AFIP 830 / 00
			
			celda = f.createCell(imp7);
			celda.setCellValue("RET. AFIP - DGI - GCIAS. 2% RES. AFIP 830 / 00");
			celda.setCellStyle(style);
			
			//RET. MUNICIP. DERECHO INSPECCION. 0.7% RES. DGR 008/15
			celda = f.createCell(imp8);
			celda.setCellValue("RET. MUNICIP. DERECHO INSPECCION. 0.7% RES. DGR 008/15");
			celda.setCellStyle(style);
			
			//RET.AFIP-DGI-GCIAS. 25% RES. AFIP 4245/19 S/ANEXO RG 830
			celda = f.createCell(imp9);
			celda.setCellValue("RET.AFIP-DGI-GCIAS. 25% RES. AFIP 4245/19 S/ANEXO RG 830");
			celda.setCellStyle(style);
			
			
		    for (InformeEstadisticoPagoProveedores i : informe.getList()) {
		    	
				f = hoja.createRow(fila);
				
				//Celda Cuenta
				celda = f.createCell(celdaFecha);
				celda.setCellValue( utils.DateUtils.formatDate(i.fecha_pago) );
				
				//Celda Rubro
				celda = f.createCell(celdaProveedor);
				celda.setCellValue(i.proveedor.nombre);
				
				//Celda Exp
				celda = f.createCell(celdaExp);
				celda.setCellValue(i.expediente.getExpedienteEjercicio());
				
				//Celda Rubro
				celda = f.createCell(celdaRubro);
				celda.setCellValue((i.ordenRubro != null)?i.ordenRubro.nombre:"");
				
				//Celda Rubro
				celda = f.createCell(celdaInstitucion);
				celda.setCellValue((i.deposito != null)?i.deposito.nombre:"");
				
				//Celda total de orden
				celda = f.createCell(celdaTotal);
				celda.setCellValue(i.total.doubleValue());
				celda.setCellStyle(style);
				
				//Celda Rubro
				celda = f.createCell(celdaEstado);
				celda.setCellValue(i.estado.nombre);
				celda.setCellStyle(style);
				//----------------------------------------
				
				
				Pago px = Pago.find.byId(i.id.longValue());
				Logger.debug("---------"+i.id);
				List<Pago>  p = Pago.find.where().eq("tipo","impuestos").eq("factura_id",px.factura_id).findList();
				for(Pago pp :p) {
					Logger.debug("111111111111"+pp.id);
					Logger.debug("111111111111"+pp.cuenta_impuesto_id);
					
					if(pp.cuenta_impuesto_id.compareTo(263) == 0) {//263;"RET. D.G.R. - SELLOS 1 % - R.G. 13/97"x
						celda = f.createCell(imp1);
						celda.setCellValue(pp.total.subtract(pp.total_credito).doubleValue());
						celda.setCellStyle(style);
						Logger.debug("a");

					}else if(pp.cuenta_impuesto_id.compareTo(284) ==0) {//284;"RET.AFIP-DGI- GCIAS. 2% RES.AFIP 4245/18"
						celda = f.createCell(imp2);
						celda.setCellValue(pp.total.subtract(pp.total_credito).doubleValue());
						celda.setCellStyle(style);
						Logger.debug("b");
						
					}else if(pp.cuenta_impuesto_id.compareTo(544) ==0) {//544;"RET.AFIP-DGI- GCIAS. 2% RES.AFIP 4525/19"
						celda = f.createCell(imp3);
						celda.setCellValue(pp.total.subtract(pp.total_credito).doubleValue());
						celda.setCellStyle(style);
						Logger.debug("c");

					}else if(pp.cuenta_impuesto_id.compareTo(277) ==0) {//277;"SUSS 1% Res AFIP 2069/06, MOF 1784/04"
						celda = f.createCell(imp4);
						celda.setCellValue(pp.total.subtract(pp.total_credito).doubleValue());
						celda.setCellStyle(style);
						Logger.debug("d"); 

					}else if(pp.cuenta_impuesto_id.compareTo(281) ==0) {//281;"RET.AFIP-DGI- GCIAS. 2% RES.AFIP 3884/16x
						celda = f.createCell(imp5);
						celda.setCellValue(pp.total.subtract(pp.total_credito).doubleValue());
						celda.setCellStyle(style);
						Logger.debug("d"); 
						
					}else if(pp.cuenta_impuesto_id.compareTo(259) ==0) {//259;"SUSS 2% Res. AFIP 1784/04
						celda = f.createCell(imp6);
						celda.setCellValue(pp.total.subtract(pp.total_credito).doubleValue());
						celda.setCellStyle(style);
						Logger.debug("d"); 

					}else if(pp.cuenta_impuesto_id.compareTo(108) ==0) {//108;"RET. AFIP - DGI - GCIAS. 2% RES. AFIP 830 / 00
						celda = f.createCell(imp7);
						celda.setCellValue(pp.total.subtract(pp.total_credito).doubleValue());
						celda.setCellStyle(style);
						Logger.debug("d"); 

					}else if(pp.cuenta_impuesto_id.compareTo(283) ==0) {//283;"RET. MUNICIP. DERECHO INSPECCION. 0.7% RES. DGR 008/15"
						celda = f.createCell(imp8);
						celda.setCellValue(pp.total.subtract(pp.total_credito).doubleValue());
						celda.setCellStyle(style);
						Logger.debug("d"); 

					}else if(pp.cuenta_impuesto_id.compareTo(565) ==0) {//RET.AFIP-DGI-GCIAS. 25% RES. AFIP 4245/19 S/ANEXO RG 830
						celda = f.createCell(imp9);
						celda.setCellValue(pp.total.subtract(pp.total_credito).doubleValue());
						celda.setCellStyle(style);
						Logger.debug("d"); 

					} 

					Logger.debug("2222");
				}
				 
				
				fila++;
			}  
			
		    
		    
		    
			libro.write(archivoTmp);   
			  
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			
			
			return ok(archivo);
			
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		return ok();
	}
	
	@CheckPermiso(key = "dashboardInformeDeudaProveedores")
	public static Result informePeriodoProveedor() {
		
		
		BigDecimal totalSuperPagado = new BigDecimal(0);
		BigDecimal totalPagado = new BigDecimal(0);
		BigDecimal totalFacturado = new BigDecimal(0);
		BigDecimal totalImpuestos = new BigDecimal(0);
		
		BigDecimal totalPagadoAfip = new BigDecimal(0);
		BigDecimal totalPagadoDgr = new BigDecimal(0);
		BigDecimal totalPagadoOtros = new BigDecimal(0);

		ExpressionList<InformeEstadisticoPagoProveedores> l = InformeEstadisticoPagoProveedores.find
															  .fetch("factura")	
															  .fetch("proveedor", "nombre")
															  .where()
															  //.eq("tipo","payment")
															  .disjunction()
															  .eq("estado_id", Estado.PAGO_ESTADO_PAGADO)
															  .eq("estado_id", Estado.PAGO_ESTADO_CONCILIADO)
															  .endJunction();
		
		/*ExpressionList<InformeEstadisticoPagoProveedores> li = InformeEstadisticoPagoProveedores.find
															  .fetch("factura")	
															  .fetch("proveedor", "nombre")
															  .where()
															  .eq("tipo","impuestos")
															  .disjunction()
															  .eq("estado_id", Estado.PAGO_ESTADO_PAGADO)
															  .eq("estado_id", Estado.PAGO_ESTADO_CONCILIADO)
															  .endJunction();
		*/
		
		
		if(!RequestVar.get("periodo.id").isEmpty()){
			
			Periodo p = Periodo.find.byId(new Long(RequestVar.get("periodo.id"))) ;
			l = l.ge("fecha_pago", p.date_start);
			l = l.le("fecha_pago", p.date_stop);
			
			//li = li.ge("fecha_pago", p.date_start);
			//li = li.le("fecha_pago", p.date_stop);
			
    		 
    	}else if(!RequestVar.get("fecha_desde").isEmpty() && !RequestVar.get("fecha_hasta").isEmpty()){
    		Date fi = DateUtils.formatDate(RequestVar.get("fecha_desde"), "dd/MM/yyyy");
    		Date ff =  DateUtils.formatDate(RequestVar.get("fecha_hasta"), "dd/MM/yyyy");
    		l = l.ge("fecha_pago", fi);
			l = l.le("fecha_pago", ff);
    	}else {	
    		
    		flash("error", "Debe Seleccionar un Periodo o una Fecha Desda y Fecha Hasta");
			return badRequest(informePeriodoProveedor.render(null,form().bindFromRequest(),
															totalFacturado,
															totalImpuestos,
															totalPagado,
															totalPagadoAfip,
															totalPagadoDgr,
															totalPagadoOtros,
															totalSuperPagado));
    	}
		
		
		if(!RequestVar.get("proveedor_id").isEmpty()){
			Long z = new Long(RequestVar.get("proveedor_id"));
			if(z.compareTo(Proveedor.RA) == 0) {
				l =  l.in("proveedor_id", Proveedor.getProveedoresDestacadosRA());
			}else {
				l =  l.eq("proveedor_id", Integer.parseInt(RequestVar.get("proveedor_id")));
			}
		}
		
		List<InformeEstadisticoPagoProveedores> ll = l.orderBy("fecha_pago desc").findList();
		
		Map<String,List<InformeEstadisticoPagoProveedores>> hp = new HashMap<String,List<InformeEstadisticoPagoProveedores>>();
		
		
		
		List<Long> idsFacturas = new ArrayList<Long>();
		
		for (InformeEstadisticoPagoProveedores llx :ll) {
			
			totalPagado = totalPagado.add(llx.total);
			totalSuperPagado = totalSuperPagado.add(llx.total);
			if(idsFacturas.contains(llx.factura_id)) {
				
				
				
			}else {
				idsFacturas.add(llx.factura_id);
				totalFacturado = totalFacturado.add(llx.total_factura);
				totalImpuestos = totalImpuestos.add(llx.factura.getTotalImpuesto());
				
				
				
			}
			
			
			
			
			List<InformeEstadisticoPagoProveedores> xl = new ArrayList<InformeEstadisticoPagoProveedores>();
			
			if(hp.containsKey(llx.proveedor.nombre)) {
				
				List<InformeEstadisticoPagoProveedores> xxl = hp.get(llx.proveedor.nombre);
				xxl.add(llx);
				hp.put(llx.proveedor.nombre, xxl);
				
			}else {
				xl.add(llx);
				hp.put(llx.proveedor.nombre, xl);
			}
		}
		
		/*if(RequestVar.get("proveedor_id").isEmpty()){
			List<InformeEstadisticoPagoProveedores> lli = li.orderBy("fecha_pago desc").findList();
			
			for (InformeEstadisticoPagoProveedores llxi :lli) {
				
				if(llxi.proveedor.id.compareTo((long)1366) == 0) {
					totalPagadoAfip = totalPagadoAfip.add(llxi.total);
				}else if(llxi.proveedor.id.compareTo((long)1367) == 0) {
					totalPagadoDgr = totalPagadoDgr.add(llxi.total);
				}else {
					totalPagadoOtros = totalPagadoOtros.add(llxi.total);
				}
				
				totalSuperPagado = totalSuperPagado.add(llxi.total);
			}
		}*/
		
		
		Map<String,List<InformeEstadisticoPagoProveedores>> sortedMap = new TreeMap<String,List<InformeEstadisticoPagoProveedores>>(hp);
		
		return ok(informePeriodoProveedor.render(sortedMap, form().bindFromRequest(),
												totalFacturado,
												totalImpuestos,
												totalPagado,
												totalPagadoAfip,
												totalPagadoDgr,
												totalPagadoOtros,
												totalSuperPagado));
	}
	
	@CheckPermiso(key = "dashboardInformeDeudaProveedores")
	public static Result informePeriodoProveedorReporte() {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		BigDecimal totalSuperPagado = new BigDecimal(0);
		BigDecimal totalPagado = new BigDecimal(0);
		BigDecimal totalFacturado = new BigDecimal(0);
		BigDecimal totalImpuestos = new BigDecimal(0);
		
		BigDecimal totalPagadoAfip = new BigDecimal(0);
		BigDecimal totalPagadoDgr = new BigDecimal(0);
		BigDecimal totalPagadoOtros = new BigDecimal(0);

		
		ExpressionList<InformeEstadisticoPagoProveedores> l = InformeEstadisticoPagoProveedores.find
				  .fetch("factura")	
				  .fetch("proveedor", "nombre")
				  .where()
				  .eq("tipo","payment")
				  .disjunction()
				  .eq("estado_id", Estado.PAGO_ESTADO_PAGADO)
				  .eq("estado_id", Estado.PAGO_ESTADO_CONCILIADO)
				  .endJunction();
		
		if(!RequestVar.get("periodo.id").isEmpty()){
			
			Periodo p = Periodo.find.byId(new Long(RequestVar.get("periodo.id"))) ;
			l = l.ge("fecha_pago", p.date_start);
			l = l.le("fecha_pago", p.date_stop); 
			
    		 
    	} else {
    		Periodo p = Periodo.getPeriodoByDate(new Date());
			l = l.ge("fecha_pago", p.date_start);
			l = l.le("fecha_pago", p.date_stop); 
    	}
    		
		
		if(!RequestVar.get("proveedor_id").isEmpty()){
			Long z = new Long(RequestVar.get("proveedor_id"));
			if(z.compareTo(Proveedor.RA) == 0) {
				l =  l.in("proveedor_id", Proveedor.getProveedoresDestacadosRA());
			}else {
				l =  l.eq("proveedor_id", Integer.parseInt(RequestVar.get("proveedor_id")));
			}
		}
		
		try {
			 
			File archivo = new File(dirTemp+"/informePeriodoProveedorReporte.xls");	
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Listado");
			
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
			
			
			int x = 0;
			Row fila = hoja.createRow(x);
			
			
			
			
			
			
			
			List<InformeEstadisticoPagoProveedores> ll = l.orderBy("proveedor.nombre asc").findList();
			x++;
			boolean uno = true;
			 
			Long proveedorTmp = null;
			Cell celda0 = null;
			
			for (InformeEstadisticoPagoProveedores llx :ll) {
				
				 if(proveedorTmp != null && proveedorTmp.compareTo(llx.proveedor_id) != 0) {
					 fila = hoja.createRow(x);
					 celda0 = fila.createCell(0);
					 celda0.setCellValue("Facturado");
					 celda0.setCellStyle(comun);
					
					 celda0 = fila.createCell(1);
					 celda0.setCellValue("Impuestos");
					 celda0.setCellStyle(comun);
					
					 celda0 = fila.createCell(2);
					 celda0.setCellValue("Neto");
					 celda0.setCellStyle(comun);
					 x++;
					 
					 fila = hoja.createRow(x);
					 celda0 = fila.createCell(0);
					 celda0.setCellValue(totalFacturado.doubleValue());
					 celda0.setCellStyle(estiloMoneda);
					
					 celda0 = fila.createCell(1);
					 celda0.setCellValue(totalImpuestos.doubleValue());
					 celda0.setCellStyle(estiloMoneda);
					
					 celda0 = fila.createCell(2);
					 celda0.setCellValue(totalPagado.doubleValue());
					 celda0.setCellStyle(estiloMoneda);
					 x++;
					 x++;
					 uno = true;
					 totalPagado = new BigDecimal(0);
					 totalFacturado = new BigDecimal(0);
					 totalImpuestos = new BigDecimal(0);
				 }
				
				
				
				
				if(uno) {
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(llx.proveedor.nombre);
					celda0.setCellStyle(comun);
					hoja.addMergedRegion(new  CellRangeAddress(x,x,0,2));
					x++;
					
					totalPagado = totalPagado.add(llx.total);
					totalFacturado = totalFacturado.add(llx.factura.getBase());
					totalImpuestos = totalImpuestos.add(llx.factura.getTotalImpuesto());
					uno = false;
					proveedorTmp = llx.proveedor_id;
				}else {
					totalPagado = totalPagado.add(llx.total);
					totalFacturado = totalFacturado.add(llx.factura.getBase());
					totalImpuestos = totalImpuestos.add(llx.factura.getTotalImpuesto());
				}
				
				 
				
				
				
				
				
				
				 
			}
			
			
			libro.write(archivoTmp); 
			
			
			
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		return ok();
	}
	
	@CheckPermiso(key = "dashboardInformeDeudaProveedores")
	public static Result informeProveedor() {
		
		if(!RequestVar.get("proveedor_id").isEmpty()){
			Long z = new Long(RequestVar.get("proveedor_id"));
			if(z.compareTo(Proveedor.RA) == 0) {
				//l =  l.in("proveedor_id", Proveedor.getProveedoresDestacadosRA());
			}else {
				//l =  l.eq("proveedor_id", Integer.parseInt(RequestVar.get("proveedor_id")));
			}
		}
		
		 
		
		 
		
		return ok(informeProveedor.render(form().bindFromRequest()));
	}

}
