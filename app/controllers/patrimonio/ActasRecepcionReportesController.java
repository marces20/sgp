package controllers.patrimonio;

import static play.data.Form.form;

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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import models.ActaRecepcion;
import models.ActaRecepcionLinea;
import models.ActaRecepcionLineaAjuste;
import models.CertificacionServicio;
import models.CertificacionServicioLinea;
import models.CertificacionServicioLineaCliente;
import models.DireccionProveedor;
import models.Estado;
import models.Inventario;
import models.OrdenLinea;
import models.OrdenLineaAjuste;
import models.OrdenLineaCliente;
import models.Recepcion;
import models.Remito;
import models.RemitoLinea;
import models.RemitoLineaCliente;
import models.TipoMoneda;
import models.UltimaCotizacion;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.velocity.tools.generic.MathTool;

import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.StringUtils;
import views.html.patrimonio.actaRecepcion.verActaRecepcion;
import views.html.patrimonio.actaRecepcion.modales.modalListadoInventariable;
import views.html.patrimonio.ordenesProvision.reportes.modalReporteGeneralOp;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.google.common.collect.Lists;

import controllers.Secured;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

@Security.Authenticated(Secured.class)
public class ActasRecepcionReportesController extends Controller {
	
	public static Result modalListadoInventariable() {
		DynamicForm d = form().bindFromRequest();	
		
		return ok(modalListadoInventariable.render(null,d));
	}
	
	public static Result informeListadoInventariable() {
		DynamicForm d = form().bindFromRequest();	
		Date ffh;
		Date ffd;
		
		String[] fecha_desde = request().body().asFormUrlEncoded().get("fecha_desde");
		String[] fecha_hasta = request().body().asFormUrlEncoded().get("fecha_hasta");
		String[] cuenta_id = request().body().asFormUrlEncoded().get("cuenta_id");
		
		if(fecha_desde == null && fecha_desde[0].isEmpty()){
			flash("error", "Debe ingresar una fecha inicio.");
			return ok(modalListadoInventariable.render(null,d));
		}else{
			ffd = DateUtils.formatDate(fecha_desde[0], "dd/MM/yyyy");
		}
		
		if(fecha_hasta == null || fecha_hasta[0].isEmpty()){
			flash("error", "Debe ingresar una fecha fin.");
			return ok(modalListadoInventariable.render(null,d));
		}else{
			ffh = DateUtils.formatDate(fecha_hasta[0], "dd/MM/yyyy");
		}
		
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		try {
			File archivo = new File(dirTemp+"/listado_inventariable.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Inventariables");
			
			
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
			
			
			
			List<ActaRecepcion> ar = ActaRecepcion.find.where()
												.ge("fecha", ffd)
												.le("fecha", ffh)
												.eq("state_id",Estado.ACTA_ESTADO_APROBADA)
												.orderBy("id asc")
												.findList();
			
			
			
			Row fila = hoja.createRow(0);
			Cell celda = fila.createCell(0);
			celda.setCellValue("Expediente");
			celda.setCellStyle(comun);
			celda = fila.createCell(1);
			celda.setCellValue("OP");
			celda.setCellStyle(comun);
			celda = fila.createCell(2);
			celda.setCellValue("Acta");
			celda.setCellStyle(comun);
			celda = fila.createCell(3);
			celda.setCellValue("Fecha Acta");
			celda.setCellStyle(comun);
			celda = fila.createCell(4);
			celda.setCellValue("Producto");
			celda.setCellStyle(comun);
			celda = fila.createCell(5);
			celda.setCellValue("Prefijo");
			celda.setCellStyle(comun);
			celda = fila.createCell(6);
			celda.setCellValue("N° Inventario");
			celda.setCellStyle(comun);
			celda = fila.createCell(7);
			celda.setCellValue("Precio");
			celda.setCellStyle(comun);
			 
			
			int f = 1; 
			if(ar.size() > 0){
				for(ActaRecepcion arx: ar){
					if(arx.recepciones != null && arx.recepciones.size() > 0){
						for(Recepcion rx : arx.recepciones){
							if(rx.remito != null && rx.remito.size() > 0){
								for(Remito rex : rx.remito){
									List<Inventario> li = Inventario.find.where().eq("remito_id", rex.id).findList(); 
									
									for(Inventario ix : li){
										fila = hoja.createRow(f);
										celda = fila.createCell(0);
										celda.setCellValue(arx.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio());
										celda.setCellStyle(comun);
										
										celda = fila.createCell(1);
										celda.setCellValue(arx.ordenProvision.getOpEjercicio());
										celda.setCellStyle(comun);
										
										celda = fila.createCell(2);
										celda.setCellValue(arx.numero +"/"+arx.ejercicio.nombre);
										celda.setCellStyle(comun);
										
										celda = fila.createCell(3);
										celda.setCellValue(utils.DateUtils.formatDate(arx.fecha));
										celda.setCellStyle(comun);
										
										celda = fila.createCell(4);
										celda.setCellValue(ix.producto.nombre);
										celda.setCellStyle(comun);
										
										celda = fila.createCell(5);
										celda.setCellValue(ix.prefijo.prefijo);
										celda.setCellStyle(comun);
										
										celda = fila.createCell(6);
										celda.setCellValue(ix.numero);
										celda.setCellStyle(comun);
										
										OrdenLinea ol = OrdenLinea.find.where()
														.eq("orden_id",arx.ordenProvision.orden_compra_id)
														.eq("producto_id", ix.producto_id)
														.findUnique();
										
										celda = fila.createCell(7);
										celda.setCellType(Cell.CELL_TYPE_NUMERIC);
										celda.setCellValue(ol.precio.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
										celda.setCellStyle(estiloMoneda);
										
										f++;
									}
								}
							}
						}
					}
				}
			}
			
			libro.write(archivoTmp); 
			
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalListadoInventariable.render(archivo.getPath(),d));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
	}	
	
	public static Result reporteLineasActas() {
		
		List<Integer> opSeleccionados = getSeleccionados();
		
		if(opSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado op.");
			return ok(modalReporteGeneralOp.render(null));
		}
		
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		try {
			File archivo = new File(dirTemp+"/reporteLineas.xls");
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
			
			CellStyle comun = libro.createCellStyle();
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			
			Sheet hoja = libro.createSheet("reporte");
			
			List<ActaRecepcion> op = ActaRecepcion.find
												   .fetch("estado")
												   .fetch("ordenProvision")
												   .fetch("ordenProvision.ordenCompra")	
												   .fetch("ordenProvision.ordenCompra.proveedor")
												   .fetch("ordenProvision.ordenCompra.expediente")
												   .where().in("id", opSeleccionados).orderBy("numero::int").findList();
			Row fila = hoja.createRow(0);
			Cell celda = fila.createCell(0);
			celda.setCellValue("Expediente");
			celda.setCellStyle(comun);
			celda = fila.createCell(1);
			celda.setCellValue("OP");
			celda.setCellStyle(comun);
			celda = fila.createCell(2);
			celda.setCellValue("Acta");
			celda.setCellStyle(comun);
			celda = fila.createCell(3);
			celda.setCellValue("Fecha Acta");
			celda.setCellStyle(comun);
			celda = fila.createCell(4);
			celda.setCellValue("Producto");
			celda.setCellStyle(comun);
			celda = fila.createCell(5);
			celda.setCellValue("Cantidad");
			celda.setCellStyle(comun);
			celda = fila.createCell(6);
			celda.setCellValue("Precio");
			celda.setCellStyle(comun);
			celda = fila.createCell(7);
			celda.setCellValue("Total");
			celda.setCellStyle(comun);
			
			
			
			int f = 1; 
			for (ActaRecepcion x : op) {
				if(x.recepciones != null && x.recepciones.size() > 0){
					for(Recepcion rx : x.recepciones){
						if(rx.remito != null && rx.remito.size() > 0){
							for(Remito rex : rx.remito){
								
								List<RemitoLinea> li = RemitoLinea.find.where().eq("remito_id", rex.id).findList(); 
								for(RemitoLinea ix : li){

									fila = hoja.createRow(f);
									celda = fila.createCell(0);
									celda.setCellValue(x.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio());
									celda.setCellStyle(comun);
									
									celda = fila.createCell(1);
									celda.setCellValue(x.ordenProvision.getOpEjercicio());
									celda.setCellStyle(comun);
									
									celda = fila.createCell(2);
									celda.setCellValue(x.numero +"/"+x.ejercicio.nombre);
									celda.setCellStyle(comun);
									
									celda = fila.createCell(3);
									celda.setCellValue(utils.DateUtils.formatDate(x.fecha));
									celda.setCellStyle(comun);
									
									celda = fila.createCell(4);
									celda.setCellValue(ix.lineaOrden.producto.nombre);
									celda.setCellStyle(comun);
									
									celda = fila.createCell(5);
									celda.setCellType(Cell.CELL_TYPE_NUMERIC);
									celda.setCellValue(ix.cantidad.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
									celda.setCellStyle(comun);
									
									celda = fila.createCell(6);
									celda.setCellType(Cell.CELL_TYPE_NUMERIC);
									celda.setCellValue(ix.lineaOrden.precio.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
									celda.setCellStyle(estiloMoneda);
									
									celda = fila.createCell(7);
									celda.setCellType(Cell.CELL_TYPE_NUMERIC);
									celda.setCellValue(ix.lineaOrden.precio.multiply(ix.cantidad).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
									celda.setCellStyle(estiloMoneda);
									f++;
								}

								
							}
						}
					}
				}	
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
	
	public static Result reporteGeneralActa() {
		
		List<Integer> opSeleccionados = getSeleccionados();
		
		if(opSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado op.");
			return ok(modalReporteGeneralOp.render(null));
		}
		
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		try {
			File archivo = new File(dirTemp+"/reporteGeneralActa.xls");
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
			
			List<ActaRecepcion> op = ActaRecepcion.find
												   .fetch("estado")
												   .fetch("ordenProvision")
												   .fetch("ordenProvision.ordenCompra")	
												   .fetch("ordenProvision.ordenCompra.proveedor")
												   .fetch("ordenProvision.ordenCompra.expediente")
												   .fetch("ordenProvision.ordenCompra.deposito")
												   .where().in("id", opSeleccionados).orderBy("numero::int").findList();
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Número");
			fila.createCell(1).setCellValue("Expediente");
			fila.createCell(2).setCellValue("Fecha-Expediente");
			fila.createCell(3).setCellValue("N° OP");
			fila.createCell(4).setCellValue("Proveedor");
			fila.createCell(5).setCellValue("Monto");
			fila.createCell(6).setCellValue("Fecha");
			fila.createCell(7).setCellValue("Parcial");
			fila.createCell(8).setCellValue("Estado");
			fila.createCell(9).setCellValue("Observaciones");
			fila.createCell(10).setCellValue("Tipo Cuenta");
			fila.createCell(11).setCellValue("Institucion");
			fila.createCell(12).setCellValue("Periodo");
			
			int f = 1; 
			for (ActaRecepcion x : op) {
					fila = hoja.createRow(f);
					for(int c=0;c<13;c++){
						Cell celda = fila.createCell(c);
						
						switch (c) {
						case 0:
							celda.setCellValue(x.numero);
							break;
						case 1:
							celda.setCellValue(x.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio());
							break;	
						case 2:
							celda.setCellValue(DateUtils.formatDate(x.ordenProvision.ordenCompra.expediente.fecha));
							break;		
						case 3:
							celda.setCellValue(x.ordenProvision.numero);
							break;	
						case 4:
							celda.setCellValue(x.ordenProvision.ordenCompra.proveedor.nombre);
							break;	
						case 5:
							celda.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda.setCellValue(x.getTotal().doubleValue());
							celda.setCellStyle(estiloMoneda);
							break;		
						case 6:
							celda.setCellValue(DateUtils.formatDate(x.fecha));
							break;	
						case 7:
							String parcial = (x.cierre)?"CIERRE":"PARCIAL";
							celda.setCellValue(parcial);
							break;	
						case 8:
							celda.setCellValue(x.estado.nombre);
							break;	
						case 9:
							celda.setCellValue(x.observaciones);
							break;	
						case 10:
							String cx = null;
							if(x.ordenProvision.ordenCompra.tipo_cuenta_id != null ) {
								cx = x.ordenProvision.ordenCompra.tipoCuenta.nombre;
							}else {
								cx = (x.ordenProvision.ordenCompra.profe)?"PROFE":"OPER.";
							}
							
							celda.setCellValue(cx);
							break;	
						case 11:
							String is = "";
							if(x.ordenProvision.ordenCompra.deposito != null ) {
								is = x.ordenProvision.ordenCompra.deposito.nombre;
							} 
							
							celda.setCellValue(is);
							break;	
						case 12:
							String pe = "";
							if(x.periodo_id != null ) {
								pe = x.periodo.nombre;
							} 
							
							celda.setCellValue(pe);
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
	
	public static Result reporte(Long id) {
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/reporte-acta-recepcion.odt");
		
		
		try {
			
			ActaRecepcion ar = ActaRecepcion.find.byId(id);
			List<ActaRecepcionLinea> sqlRowsProductos = ActaRecepcionLinea.getQuery().where().eq("acta_id", id).order("p.nombre").findList();
			List<OrdenLineaAjuste> ajustes = ar.getAjustes();
			
			 
 			List<ActaRecepcionLineaAjuste> arm = ActaRecepcionLineaAjuste.find.where().eq("acta_id", id).findList();
		
			for(ActaRecepcionLineaAjuste arx :arm){
				OrdenLineaAjuste tp = new OrdenLineaAjuste();
				tp.cantidad = arx.cantidad;
				tp.cuenta_analitica_id = arx.cuenta_analitica_id;
				tp.precio = arx.precio;
				tp.producto = arx.producto;
				tp.udm_id = arx.udm_id;
				Logger.debug("--------------------------------- "+ arx.producto.nombre);
				Logger.debug("--------------------------------- "+ tp.producto.nombre);
				ajustes.add(tp);
			}
			 
			InputStream in = Play.application().resourceAsStream("resources/reportes/patrimonio/actasRecepcion/reporte-acta.odt");
			if(sqlRowsProductos.size() <= 0 && ajustes.size() > 0){
				in = Play.application().resourceAsStream("resources/reportes/patrimonio/actasRecepcion/reporte-acta-ajuste.odt");
			}
        	
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			if(ar.fecha == null) {
				flash("error", "El acta no tiene fecha.");
				return redirect(request().getHeader("referer"));
			}
			
		
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html); 
			metadata.addFieldAsTextStyling("xx", SyntaxKind.Html); 
			//metadata.addFieldAsTextStyling("observaciones", SyntaxKind.Html); 
			IContext context = report.createContext();


			
			context.put("saltoLinea", "<p style=\"page-break-after:auto\"></p>");
			
			context.put("math", new MathTool());	
			context.put("numberUtils", new NumberUtils());	
			context.put("ejercicio", ar.ordenProvision.ordenCompra.expediente.ejercicio.nombre);
			context.put("expediente", ar.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio());
			context.put("numeroOP", ar.ordenProvision.numero + " / " + ar.ordenProvision.ejercicio.nombre);
			context.put("cuenta", ar.ordenProvision.ordenCompra.tipoCuenta.nombre);
			context.put("parcial", !ar.cierre);
			context.put("actaNumero", ar.numero);
			context.put("institucion", ar.ordenProvision.ordenCompra.deposito.nombre);
			
			
			
						
		    Calendar cal = Calendar.getInstance();
	        cal.setTime(  ar.fecha );
			
			context.put("actaEjercicio", cal.get(Calendar.YEAR));
			context.put("esServicio", (ar.ordenProvision.ordenCompra.tipo_orden.equals("servicio"))?true:false);

			context.put("proveedor", ar.ordenProvision.ordenCompra.proveedor.nombre);
			
			if(ar.ordenProvision.ordenCompra.proveedor.direcciones.size() == 0) {
				flash("error", "El proveedor no tiene datos de contactos cargados. Debe cargar Datos de contacto en el proveedor.");
				return redirect(request().getHeader("referer"));
			}
			
			DireccionProveedor direccion = ar.ordenProvision.ordenCompra.proveedor.direcciones.get(0);
			context.put("domicilioProveedor", direccion.calle + " " + direccion.numero);
			context.put("localidadProveedor", (direccion.localidad != null && direccion.localidad.provincia != null) ? direccion.localidad.nombre + " - " + direccion.localidad.provincia.nombre : ""); 
			context.put("math", new MathTool());
			
			

	        cal.setTime(ar.fecha);
			
	        context.put("funcionLetra", new NumeroALetra());
	        context.put("number", new NumberUtils());
	        context.put("string", new StringUtils());
	        
	        context.put("dia", cal.get(Calendar.DAY_OF_MONTH));
	        context.put("anio", cal.get(Calendar.YEAR));
		    context.put("diaLetra", NumeroALetra.convertNumberToLetterSinPesos( String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) ));
		    context.put("mesLetra", DateUtils.getMesLetras( cal.get(Calendar.MONTH) ).toUpperCase());
		    context.put("anioLetra", NumeroALetra.convertNumberToLetterSinPesos(String.valueOf(cal.get(Calendar.YEAR))).replaceAll("\\s*$",""));
			
		    context.put("subtotal", 0);
		    context.put("total", ar.total);
		    
		    //Lista con los objetos ActaRecepcionLinea que coloco en hashmap objetos 
		    List<ActaRecepcionLinea> oProductos = new ArrayList<ActaRecepcionLinea>();
		    //Lista con los inventario que coloco hashmap objetos
		    List<String> oRemitos = new ArrayList<>();
		    //Lista con los id de productos en inventario que coloco hashmap objetos
		    List<Integer> oInventario = new ArrayList<>();
		    List<Integer> oPaciente = new ArrayList<>();
		    
		    
		    //Cada objeto de este contenedor va a ser una hoja, va a contener el hashmap de ojetos
		    List<HashMap<String, Object>> contenedorObjetos = new ArrayList<>();
		    //Va a contener claves/objetos = produtos/listaProductos, "remitos" e inventarios/listaProductosInventario
		    HashMap<String, Object> objetos = new HashMap<String, Object>(); 
		    
		    
		    
		    //Traigo productos en acta
		     
		    context.put("cantidadProductos", sqlRowsProductos.size());
		    
		    
		    //CARGO N° REMITOOOOOSSS
		    String sqlRemitos = " select  'Remito ' || rem.numero || ' del ' || to_char(fecha_remito, 'DD/MM/YYYY') as texto from remitos rem "+
								" inner join recepciones rec on rec.id = rem.recepcion_id "+
								" where rec.acta_id = :actaId order by fecha_remito, rem.numero";
		    List<SqlRow> sqlRowsRemitos = Ebean.createSqlQuery(sqlRemitos).setParameter("actaId", id).findList(); 
		    
		    
		    if(sqlRowsRemitos.size() == 0) {//SINO TIENE REMITOS QUIERE DECIR Q ES UNA CERTIFICACION ASI QUE BUSCO LO N° DE REMITO DE LA CERTIFICACION
		    	sqlRemitos = " select 'Remito ' || rem.numero_remito || ' del ' || to_char(fecha_certificacion, 'DD/MM/YYYY') as texto  "+
		    			"from certificaciones_servicios rem "+
						" where rem.acta_id = :actaId AND rem.numero_remito <> '' AND rem.numero_remito <> '0000-00000000' order by fecha_certificacion, rem.numero_remito";
		    	sqlRowsRemitos = Ebean.createSqlQuery(sqlRemitos).setParameter("actaId", id).findList(); 
		    }
		    
		    
		    for (SqlRow sqlRow : sqlRowsRemitos) {
				oRemitos.add(sqlRow.getString("texto"));
			}
		    context.put("sizeRemito", oRemitos.size());	
		    //FIN CARGA N° REMITOS
		    
		    
		    

		    String sql = "select i1.numero, producto_id, n.codigo, (select min(division) from inventario i2 where i1.numero = i2.numero) as minimo, (select max(division) from inventario i2 where i1.numero = i2.numero) as maximo  "+
		    		" from inventario i1 "+
		    		" inner join remitos rem on rem.id = i1.remito_id "+
		    		" inner join recepciones rec on rec.id = rem.recepcion_id "+
		    		" inner join nomenclador_cuentas_patrimonio n on n.id = i1.nomenclador_inventario_id "+
		    		" where rec.acta_id = :actaId  "+
		    		" group by i1.numero, producto_id, n.codigo  "+
		    		" order by numero ASC";
		    		

		    		
			List<SqlRow> listaSqlInventario = Ebean.createSqlQuery(sql).setParameter("actaId", id).findList(); 
		    
			Hashtable<Integer,Object> inventario = new Hashtable<>();
			crearIntervalo (listaSqlInventario, inventario);
		    
		    //inicio
		    Integer lineasMaxima = 20;
		    context.put("totalLineas", 0);
		    
		    
		    Integer lineaAux = 1;
		    Integer i = 1;
		    Integer renglonUltimaLinea = 0;
		    
		    //Cargo lineas de productos al contenedor
		    for (ActaRecepcionLinea linea : sqlRowsProductos) {
		    	oProductos.add(linea);
		    	if(lineaAux == lineasMaxima || i == sqlRowsProductos.size()){
		    		objetos = new HashMap<String, Object>();
		    		objetos.put("productos", oProductos);
		    		contenedorObjetos.add(objetos);
		    		renglonUltimaLinea = oProductos.size();
		    		oProductos =  new ArrayList<>();
		    		lineaAux = 0;
		    	}
		    	
		    	Integer productoId = linea.producto.id.intValue();
		    	if(inventario.containsKey(productoId)) {
		    		((Hashtable)inventario.get(productoId)).put("renglon", i);
		    		((Hashtable)inventario.get(productoId)).put("cantidad", linea.cantidad);
		    		
					//Cargo en oInventario los id solo para cargar en el contenedor
					oInventario.add(productoId);
		    	}

		    	lineaAux++;
		    	i++;
		    	
		    	
			}
		    context.put("sizeInventario", oInventario.size());	
		   
			if(ajustes.size() > 0) {
				context.put("ajustes", ajustes);
			}
		    
		    context.put("inventario", inventario);
		    
		    System.out.println("----------- " + lineasMaxima + " ... " + renglonUltimaLinea);
		    renglonUltimaLinea = renglonUltimaLinea + 2;
		    //Cargo remitos a lo que queda para completar los renglones
		    if(!oRemitos.isEmpty() && (lineasMaxima - renglonUltimaLinea) > 2 ) {
		    	int cortar = lineasMaxima - renglonUltimaLinea - 2;
		    	//si hay más remitos divido la lista
		    	if(cortar < oRemitos.size()) {
			    	List r = new ArrayList<>(oRemitos.subList(0, cortar));
			    	contenedorObjetos.get(contenedorObjetos.size() - 1).put("remitos", r); 
			    	oRemitos = new ArrayList<>(oRemitos.subList(cortar, oRemitos.size()));
		    	} else {
		    		//si hay menos remitos para completar cargo lista de remitos entera
		    		contenedorObjetos.get(contenedorObjetos.size() - 1).put("remitos", oRemitos);
		    		renglonUltimaLinea = renglonUltimaLinea+ oRemitos.size();
		    		oRemitos =  new ArrayList<>();
		    		
		    	}
		    }
		   // lineasMaxima = lineasMaxima + 3;
		    if(!oRemitos.isEmpty()) {
		    	List<List<String>> r = Lists.partition(oRemitos, lineasMaxima);
		    	for (List<String> list : r) {
			    	objetos = new HashMap<String, Object>();
			    	objetos.put("remitos", new ArrayList<>(list));
			    	contenedorObjetos.add(objetos);
			    	renglonUltimaLinea = list.size();
				}
		    }
		    
		    
		    System.out.println("----------- " + lineasMaxima + " ... " + renglonUltimaLinea);
		    renglonUltimaLinea = renglonUltimaLinea + 2;
		    //Cargo inventarios a lo que queda para completar los renglones
		    if(!oInventario.isEmpty() && (lineasMaxima - renglonUltimaLinea) > 2 ) {
		    	int cortar = lineasMaxima - renglonUltimaLinea;
		    	//si hay más remitos divido la lista
		    	if(cortar < oInventario.size()) {
			    	List r = new ArrayList<>(oInventario.subList(0, lineasMaxima - renglonUltimaLinea));
			    	contenedorObjetos.get(contenedorObjetos.size() - 1).put("inventarios", r); 
			    	oInventario = new ArrayList<>(oInventario.subList(lineasMaxima - renglonUltimaLinea, oInventario.size()));
		    	} else {
		    		//si hay menos remitos para completar cargo lista de remitos entera
		    		contenedorObjetos.get(contenedorObjetos.size() - 1).put("inventarios", oInventario);
		    		renglonUltimaLinea = renglonUltimaLinea+ oInventario.size();
		    		oInventario =  new ArrayList<>();
		    		
		    	}
		    }
		    
		    if(!oInventario.isEmpty()) {
		    	List<List<Integer>> r = Lists.partition(oInventario, lineasMaxima);
		    	for (List<Integer> list : r) {
			    	objetos = new HashMap<String, Object>();
			    	objetos.put("inventarios", new ArrayList<>(list));
			    	contenedorObjetos.add(objetos);
			    	renglonUltimaLinea = list.size();
				}
		    }
		    
		    
		    //////////////CARGA DE PACIENTES//////////////////
		    Integer x= 1;
			Map<Integer,Map<String,String>> pacientes = new HashMap<Integer,Map<String,String>>();
		    if(ar.certificaciones != null && ar.certificaciones.size() > 0) {
		    	for(CertificacionServicio cs : ar.certificaciones ){
					for(CertificacionServicioLinea csl : cs.certificacionesServicioLinea ){
						
						for(CertificacionServicioLineaCliente clsc :csl.certificacionServicioLineaCliente){
							Map<String,String> hs = new HashMap<String,String>();
							//Logger.debug("aaaaaaaaaa"+oc.cliente.nombre);
							hs.put("nLinea",x.toString()); 
							hs.put("cantidad",clsc.cantidad.toString());
							hs.put("nombre",clsc.cliente.nombre);
							String refe = (clsc.cliente.id_paciente_rismi == null)?(clsc.cliente.referencia == null)?"":clsc.cliente.referencia:clsc.cliente.id_paciente_rismi;
							hs.put("referencia",refe);
							hs.put("producto",csl.producto.nombre);
							pacientes.put(clsc.id.intValue(),hs);
							oPaciente.add(clsc.id.intValue());
							x++;
						}
					}
		    	}
		    }else if(ar.recepciones != null && ar.recepciones.size() > 0) {
		    	
		    	for(Recepcion cs : ar.recepciones ){
		    		Logger.debug("xxxxxxxxxx "+cs.remito.size());
					for(Remito csl : cs.remito ){
						for(RemitoLinea clsc :csl.lineas){
							for(RemitoLineaCliente clscc :clsc.remitoLineaCliente ){	
								Map<String,String> hs = new HashMap<String,String>();
								//Logger.debug("aaaaaaaaaa"+oc.cliente.nombre);
								hs.put("nLinea",x.toString()); 
								hs.put("cantidad",clscc.cantidad.toString());
								hs.put("nombre",clscc.cliente.nombre);
								String refe = (clscc.cliente.id_paciente_rismi == null)?(clscc.cliente.referencia == null)?"":clscc.cliente.referencia:clscc.cliente.id_paciente_rismi;
								hs.put("referencia",refe);
								hs.put("producto",clsc.lineaOrden.producto.nombre);
								pacientes.put(clscc.id.intValue(),hs);
								oPaciente.add(clscc.id.intValue());
								x++;
							}
							
						}
					}
		    	}
		    }
		    context.put("pacientes", pacientes); 
		    context.put("sizePaciente", oPaciente.size());	
		    renglonUltimaLinea = renglonUltimaLinea + 2;
		    
		  //Cargo pacientes a lo que queda para completar los renglones
		    if(!oPaciente.isEmpty() && (lineasMaxima - renglonUltimaLinea) > 2 ) {
		    	int cortar = lineasMaxima - renglonUltimaLinea;
		    	//si hay más remitos divido la lista
		    	if(cortar < oPaciente.size()) {
			    	List r = new ArrayList<>(oPaciente.subList(0, lineasMaxima - renglonUltimaLinea));
			    	contenedorObjetos.get(contenedorObjetos.size() - 1).put("pacientes", r); 
			    	oPaciente = new ArrayList<>(oPaciente.subList(lineasMaxima - renglonUltimaLinea, oPaciente.size()));
		    	} else {
		    		//si hay menos remitos para completar cargo lista de remitos entera
		    		contenedorObjetos.get(contenedorObjetos.size() - 1).put("pacientes", oPaciente);
		    		renglonUltimaLinea = renglonUltimaLinea+ oInventario.size();
		    		oPaciente =  new ArrayList<>();
		    		
		    	}
		    }
		    
		    if(!oPaciente.isEmpty()) {
		    	List<List<Integer>> r = Lists.partition(oPaciente, lineasMaxima);
		    	for (List<Integer> list : r) {
			    	objetos = new HashMap<String, Object>();
			    	objetos.put("pacientes", new ArrayList<>(list));
			    	contenedorObjetos.add(objetos);
			    	renglonUltimaLinea = list.size();
				}
		    }
		    //////////////FIN CARGA DE PACIENTES////////////////////////////////
		    
		    
		    /*
		    
		    System.out.println("Reporte con " + contenedorObjetos.size() + " hojas");
		    for (HashMap<String, Object> objeto : contenedorObjetos) {
		    	
		    	if(objeto.containsKey("productos")){
		    		System.out.println("-----------producto");
		    		System.out.println("-----------cantidad" + ((ArrayList) objeto.get("productos")).size());
		    	}
		    	if(objeto.containsKey("remitos")){
		    		System.out.println("-----------remitos");
		    		System.out.println("-----------cantidad" + ((ArrayList) objeto.get("remitos")).size());
		    	}
		    	if(objeto.containsKey("inventarios")){
		    		System.out.println("-----------inventarios");
		    		System.out.println("-----------cantidad" + ((ArrayList) objeto.get("inventarios")).size());
		    	}
		    	System.out.println("--------------------------");
			}
		    */
		    
		  //fin 
		    
		    /*String sql = "select ci.nombre,ci.id_paciente_rismi "
		    		+ "from certificaciones_servicios c "
		    		+ "inner join certificaciones_servicios_lineas cl on c.id = cl.certificaciones_servicio_id "
		    		+ "inner join orden_lineas ol on ol.id = cl.linea_orden_id "
		    		+ "inner join orden_linea_clientes olc on olc.orden_linea_id = ol.id "
		    		+ "inner join clientes ci on ci.id = olc.cliente_id "
		    		+ "where c.acta_id = 10877 order by cl.id ";*/
		    
		    String textoDolar ="";
		    String textoConDolar ="";
		    
		    if(ar.ordenProvision.ordenCompra.cot_dolar != null && ar.ordenProvision.ordenCompra.cot_dolar.compareTo(BigDecimal.ZERO) > 0) {
		    	//ar.getTotalDolar() //valor desde cotizacion del acta
		    	//ar.getSubTotal().divide(ar.ordenProvision.ordenCompra.cot_dolar, 2, RoundingMode.HALF_UP); //valor desde cotizacion del orden
		    	
		    	if(ar.getSubTotal().compareTo(BigDecimal.ZERO) > 0) {
			    	String textoDiferenciaEjercicio = "";
			    	BigDecimal cot = ar.ordenProvision.ordenCompra.cot_dolar;
			    	TipoMoneda tm = TipoMoneda.find.byId(ar.ordenProvision.ordenCompra.tipo_moneda.longValue());
			    	
			    	
			    	if(ar.ejercicio_id > ar.ordenProvision.ordenCompra.expediente.ejercicio_id) {
			    		cot = UltimaCotizacion.getUltimaCotizacionAnualDelExpediente(ar.ordenProvision.ordenCompra.expediente.ejercicio_id, ar.ordenProvision.ordenCompra.tipo_moneda.longValue());
			    		//textoDiferenciaEjercicio = "<br />ACAA VA EL TEXTO PQ LA COTIZACION DEL ACTA ES DE: "+utils.NumberUtils.moneda((ar.cot_dolar != null)?ar.cot_dolar:ar.ordenProvision.ordenCompra.cot_dolar);
			    	}else if(ar.cot_dolar != null){
			    		cot = ar.cot_dolar;
			    	}else {
			    		cot = new BigDecimal(1);
			    	}
			    	BigDecimal total = ar.getTotal().divide(cot, 2, RoundingMode.HALF_UP);
			    	
			    	//textoConDolar += utils.NumberUtils.moneda(ar.getTotalDolar(), ar.ordenProvision.ordenCompra.tipo_moneda);
			    	//textoConDolar +=". TIPO DE CAMBIO VENDEDOR BANCO NACION "+tm.signo+" 1 = "+utils.NumberUtils.moneda((ar.cot_dolar != null)?ar.cot_dolar:ar.ordenProvision.ordenCompra.cot_dolar);
			    	textoConDolar +="<br />EQUIVALENTE A "+tm.titulo+" ";
			    	textoConDolar += utils.NumberUtils.moneda(total, ar.ordenProvision.ordenCompra.tipo_moneda);
			    	textoConDolar +=". TIPO DE CAMBIO VENDEDOR BANCO NACION "+tm.signo+" 1 = "+utils.NumberUtils.moneda(cot);
			    	textoConDolar +=textoDiferenciaEjercicio;
			    	textoDolar += textoConDolar;
		    	}else {
		    		//textoDolar += "TEXTO CUANDO NO TIENE RECEPCIONES";
		    	}
		    	
		    	
		    	textoDolar +="<br />Se considerará que al momento del pago se tomará el tipo de cambio vendedor del Banco Nación Argentina a la fecha del cierre de las operaciones del día anterior a la fecha de autorización al pago.";
			}
		    
		    
		    
		    String pe = (ar.periodo != null && ar.ordenProvision.ordenCompra.orden_rubro_id.compareTo(new Long(7)) == 0)?"Correspondiente al periodo "+ar.periodo.nombre+"-.<br/>":"";
		    String ob = (ar.observaciones != null)?ar.observaciones:"";
		    textoDolar = pe+ob +textoDolar;
		    
		    context.put("periodo","");
		    context.put("xx",textoDolar);
		    context.put("observaciones",textoDolar);
		    context.put("contenedorObjetos", contenedorObjetos);	
		    //context.put("inventario", listaProductosInventario);		    

			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
			return ok(archivo);
		} catch (Exception e) {

			flash("error", "No se pudo generar el reporte." + e.toString());
			return redirect(request().getHeader("referer"));
		}
		
	}
	
	public static Result reporteActaCierre(Long id) {
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/reporte-acta-recepcion-cierre.odt");
		
		
		try {
			
			ActaRecepcion ar = ActaRecepcion.find.byId(id);
			List<ActaRecepcionLinea> sqlRowsProductos = ActaRecepcionLinea.getQuery().where().eq("acta_id", id).order("p.nombre").findList();
			 
			InputStream in = Play.application().resourceAsStream("resources/reportes/patrimonio/actasRecepcion/reporte-acta-cierre.odt");
			 
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			if(ar.fecha == null) {
				flash("error", "El acta no tiene fecha.");
				//return badRequest(verActaRecepcion.render(ar));
				return badRequest(request().getHeader("referer"));
			}
			
		
			FieldsMetadata metadata = report.createFieldsMetadata();
			metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
			metadata.addFieldAsTextStyling("xx", SyntaxKind.Html);
			IContext context = report.createContext();
			
			context.put("saltoLinea", "<p style=\"page-break-after:auto\"></p>");
			
			context.put("math", new MathTool());	
			context.put("numberUtils", new NumberUtils());	
			context.put("ejercicio", ar.ordenProvision.ordenCompra.expediente.ejercicio.nombre);
			context.put("expediente", ar.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio());
			context.put("numeroOP", ar.ordenProvision.numero + " / " + ar.ordenProvision.ejercicio.nombre);
			context.put("parcial", !ar.cierre);
			context.put("actaNumero", ar.numero);
			context.put("cuenta", ar.ordenProvision.ordenCompra.tipoCuenta.nombre);
			context.put("institucion", ar.ordenProvision.ordenCompra.deposito.nombre);
			
			
			context.put("observaciones", ar.observaciones);
			
		    Calendar cal = Calendar.getInstance();
	        cal.setTime(  ar.fecha );
			
			context.put("actaEjercicio", cal.get(Calendar.YEAR));
			context.put("esServicio", (ar.ordenProvision.ordenCompra.tipo_orden.equals("servicio"))?true:false);

			context.put("proveedor", ar.ordenProvision.ordenCompra.proveedor.nombre);
			DireccionProveedor direccion = ar.ordenProvision.ordenCompra.proveedor.direcciones.get(0);
			context.put("domicilioProveedor", direccion.calle + " " + direccion.numero);
			context.put("localidadProveedor", (direccion.localidad != null && direccion.localidad.provincia != null) ? direccion.localidad.nombre + " - " + direccion.localidad.provincia.nombre : ""); 
			context.put("math", new MathTool());
			
			

	        cal.setTime(ar.fecha);
			
	        context.put("funcionLetra", new NumeroALetra());
	        context.put("number", new NumberUtils());
	        context.put("string", new StringUtils());
	        
	        context.put("dia", cal.get(Calendar.DAY_OF_MONTH));
	        context.put("anio", cal.get(Calendar.YEAR));
		    context.put("diaLetra", NumeroALetra.convertNumberToLetterSinPesos( String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) ));
		    context.put("mesLetra", DateUtils.getMesLetras( cal.get(Calendar.MONTH) ).toUpperCase());
		    context.put("anioLetra", NumeroALetra.convertNumberToLetterSinPesos(String.valueOf(cal.get(Calendar.YEAR))).replaceAll("\\s*$",""));
			
		    context.put("subtotal", 0);
		    context.put("total", ar.total);
		    
		    /*String textoDolar ="";
		    if(ar.ordenProvision.ordenCompra.cot_dolar != null && ar.ordenProvision.ordenCompra.cot_dolar.compareTo(BigDecimal.ZERO) > 0) {
		    	
		    	TipoMoneda tm = TipoMoneda.find.byId(ar.ordenProvision.ordenCompra.tipo_moneda.longValue());
		    	
		    	textoDolar +="<br />EQUIVALENTE A "+tm.titulo+" ";
		    	
		    	textoDolar += utils.NumberUtils.moneda(ar.getTotalDolar(), ar.ordenProvision.ordenCompra.tipo_moneda);
		    	textoDolar +=". TIPO DE CAMBIO VENDEDOR BANCO NACION "+tm.signo+" 1 = "+utils.NumberUtils.moneda(ar.ordenProvision.ordenCompra.cot_dolar);
		    	textoDolar +="<br />Se considerará que al momento del pago se tomará el tipo de cambio vendedor del Banco Nación Argentina a la fecha del cierre de las operaciones del día anterior a la fecha de autorización al pago.";
			}*/
		    
		    String textoDolar ="";
		    String textoConDolar ="";
		    if(ar.ordenProvision.ordenCompra.cot_dolar != null && ar.ordenProvision.ordenCompra.cot_dolar.compareTo(BigDecimal.ZERO) > 0) {
		    	
		    	TipoMoneda tm = TipoMoneda.find.byId(ar.ordenProvision.ordenCompra.tipo_moneda.longValue());
		    	
		    	//ar.getTotalDolar() //valor desde cotizacion del acta
		    	//ar.getSubTotal().divide(ar.ordenProvision.ordenCompra.cot_dolar, 2, RoundingMode.HALF_UP); //valor desde cotizacion del orden
		    	//textoDolar +="<br />EQUIVALENTE A "+tm.titulo+" ";
		    	//textoDolar += utils.NumberUtils.moneda(ar.getTotalDolar(), ar.ordenProvision.ordenCompra.tipo_moneda);
		    	//textoDolar +=". TIPO DE CAMBIO VENDEDOR BANCO NACION "+tm.signo+" 1 = "+utils.NumberUtils.moneda((ar.cot_dolar != null)?ar.cot_dolar:ar.ordenProvision.ordenCompra.cot_dolar);
		    	//textoDolar +="<br />Se considerará que al momento del pago se tomará el tipo de cambio vendedor del Banco Nación Argentina a la fecha del cierre de las operaciones del día anterior a la fecha de autorización al pago.";
			
		    	if(ar.getSubTotal().compareTo(BigDecimal.ZERO) > 0) {
			    	String textoDiferenciaEjercicio = "";
			    	BigDecimal cot = ar.ordenProvision.ordenCompra.cot_dolar;
			    	//TipoMoneda tm = TipoMoneda.find.byId(ar.ordenProvision.ordenCompra.tipo_moneda.longValue());
			    	
			    	
			    	if(ar.ejercicio_id > ar.ordenProvision.ordenCompra.expediente.ejercicio_id) {
			    		cot = UltimaCotizacion.getUltimaCotizacionAnualDelExpediente(ar.ordenProvision.ordenCompra.expediente.ejercicio_id, ar.ordenProvision.ordenCompra.tipo_moneda.longValue());
			    		//textoDiferenciaEjercicio = "<br />ACAA VA EL TEXTO PQ LA COTIZACION DEL ACTA ES DE: "+utils.NumberUtils.moneda((ar.cot_dolar != null)?ar.cot_dolar:ar.ordenProvision.ordenCompra.cot_dolar);
			    	}else if(ar.cot_dolar != null){
			    		cot = ar.cot_dolar;
			    	}else {
			    		cot = new BigDecimal(1);
			    	}
			    	BigDecimal total = ar.getTotal().divide(cot, 2, RoundingMode.HALF_UP);
			    	
			    	//textoConDolar += utils.NumberUtils.moneda(ar.getTotalDolar(), ar.ordenProvision.ordenCompra.tipo_moneda);
			    	//textoConDolar +=". TIPO DE CAMBIO VENDEDOR BANCO NACION "+tm.signo+" 1 = "+utils.NumberUtils.moneda((ar.cot_dolar != null)?ar.cot_dolar:ar.ordenProvision.ordenCompra.cot_dolar);
			    	textoConDolar +="<br />EQUIVALENTE A "+tm.titulo+" ";
			    	textoConDolar += utils.NumberUtils.moneda(total, ar.ordenProvision.ordenCompra.tipo_moneda);
			    	textoConDolar +=". TIPO DE CAMBIO VENDEDOR BANCO NACION "+tm.signo+" 1 = "+utils.NumberUtils.moneda(cot);
			    	textoConDolar +=textoDiferenciaEjercicio;
			    	textoDolar += textoConDolar;
		    	}else {
		    		//textoDolar += "TEXTO CUANDO NO TIENE RECEPCIONES";
		    	}
		    	
		    	
		    	textoDolar +="<br />Se considerará que al momento del pago se tomará el tipo de cambio vendedor del Banco Nación Argentina a la fecha del cierre de las operaciones del día anterior a la fecha de autorización al pago.";

		    }
		    
		    
		    
		    
		    
		    String pe = (ar.periodo != null && ar.ordenProvision.ordenCompra.orden_rubro_id.compareTo(new Long(7)) == 0)?"Correspondiente al periodo "+ar.periodo.nombre+"-.<br/>":"";
		    String ob = (ar.observaciones != null)?ar.observaciones:"";
		    textoDolar = pe+ob +textoDolar;
		    
		    context.put("xx",textoDolar);
		    context.put("observaciones",textoDolar);
		   

			OutputStream out = new FileOutputStream(archivo);
            report.process(context, out);
			return ok(archivo);
		} catch (Exception e) {

			flash("error", "No se pudo generar el reporte." + e.toString());
			return redirect(request().getHeader("referer"));
		}
		
	}
	
	/*
	 * Reviso un número y compruebo el siguiente si es correlativo, cuando no lo es creo la "cadena desde hasta" en el método 'agregarNumerosInventario'
	 */
	private static void crearIntervalo (List<SqlRow> li, Hashtable<Integer,Object> inventario) {
		Integer cant = li.size();
		String desde = null;
		
		for (int i = 0; i < cant; i++) {
			Integer numeroActual = li.get(i).getInteger("numero");
			Integer numeroSiguiente = ((i + 1) < cant ) ? li.get(i + 1).getInteger("numero") : null;
			desde = (desde == null) ? numeroActual.toString() : desde;
			
			Integer produtoActual    = li.get(i).getInteger("producto_id");
			Integer produtoSiguiente = ((i + 1) < cant ) ? li.get(i + 1).getInteger("producto_id") : null;
			
			
			
			if(numeroSiguiente == null || (numeroSiguiente != null && (numeroActual + 1 != numeroSiguiente || !produtoActual.equals(produtoSiguiente) )  ) ) {
				System.out.println("desde " + desde + " al " + numeroActual + " producto " + li.get(i).getInteger("producto_id"));
				String texto = (desde.equals(numeroActual.toString()) )? desde: (desde + " al " + numeroActual.toString());
				agregarNumerosInventario (li.get(i).getInteger("producto_id"), li.get(i).getString("codigo"), texto, inventario);
				desde = null;
				numeroSiguiente = null;
				numeroActual = null;
			}
		}
	}
	
	/*
	 * Agrego a la lista "inventario" las lineas que van a ser "desde/hasta", la clave es el id de producto, la clave prefijo se utiliza en el odt
	 */
	private static void agregarNumerosInventario (Integer idProducto, String codigo, String texto, Hashtable<Integer,Object> inventario) {
		if(inventario.containsKey(idProducto)) {
			Hashtable<Integer,Object> h = (Hashtable<Integer, Object>) inventario.get(idProducto);
			List<String> l = (List<String>) h.get("lista");
			l.add(texto);
		} else {
			Hashtable c = new Hashtable();
			List<String> i = new ArrayList<>();
			c.put("prefijo", codigo);
			c.put("renglon", "");
			c.put("cantidad", "");
			i.add(texto);
			c.put("lista", i);
			inventario.put(idProducto, c);
			System.out.println("Agrego "+texto);

		}
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