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
import models.Novedad;
import models.OrdenLinea;
import models.OrdenLineaAjuste;
import models.OrdenLineaCliente;
import models.Recepcion;
import models.Remito;
import models.RemitoLinea;
import models.RemitoLineaCliente;
import models.TipoMoneda;
import models.UltimaCotizacion;
import models.novedades.Planificacion;

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
import utils.ReportePdf;
import utils.StringUtils;
import views.html.patrimonio.actaRecepcion.verActaRecepcion;
import views.html.patrimonio.actaRecepcion.modales.modalListadoInventariable;
import views.html.patrimonio.ordenesProvision.reportes.modalReporteGeneralOp;
import views.html.tags.reportePlanilla;

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

	public static Result imprimirRemitosByActa(Long actaId) {



		 try {
			 ActaRecepcion rf = ActaRecepcion.find.byId(actaId);

			 String fileName = "remitos-"+rf.id;
			 int qpag = 0;
			 Map<String,String> datos = new HashMap<>();

			 String body = "";
			 String header ="<header><div class=\"header\"><table class=\"border_main cabecera_principal\" style=\"width: 100%;\">\n" +
			 		"             <tbody>\n" +
			 		"             	<tr>\n" +
			 		"                 <td style=\"width: 10%;text-align: center\">\n" +
			 		"                     <div style=\"margin:15px;text-align: left\">\n" +
			 		"                     <img src=\"data:image/png;base64,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\n" +
			 		"\" style=\"width: 100px; \">\n" +
			 		"					</div>\n" +
			 		"                 </td>\n" +
			 		"                 <td style=\"width: 90%;border-left: 2px solid;border-left-width: 2px;padding-left:10px;text-align: center\">\n" +
			 		"                     <h1>Remitos</h1>\n" +
			 		"					  <div style=\"text-align: center;\">" +
			 		"					  <p style=\"font-size:12px;\"><b>Acta: </b>"+rf.getNombre()+" - \n" +
			 		"					  </p>\n" +
			 		"					  </div>"+
			 		"                 </td>\n" +
			 		"             	</tr>\n" +
			 		"         	</tbody>\n" +
			 		"         </table></div></header>";



			// String periodo =rf.periodo.getMesAnioStringPeriodo();

			 String texto = "";

			 String footer = "<footer clase=\"footer\" style=\"\">\n" +
				 		"	<table style=\"width: 100%;    \">\n" +
				 		"	    <tbody>\n" +
				 		"		    <tr style=\" \">\n" +
				 		"				<td style=\"text-align: center;   border:none;\"><b style=\" padding-top:20px; border-top:1px solid #000000;\"></b></td>\n" +
				 		"		        <td style=\"text-align: center;   border:none;\"><b style=\" padding-top:20px; border-top:1px solid #000000;\">Firma y Sello Jefe de Servicio</b></td>\n" +
				 		"		        <td style=\"text-align: center;  border:none;\"><b style=\" padding-top:20px; border-top:1px solid #000000;\"></b></td>\n" +
				 		"			</tr>\n" +
				 		"		</tbody>\n" +
				 		"	</table>\n" +

				 		"</footer>";



			 List<Remito> novedades = Remito.find.where().eq("recepcion.acta_id", actaId).findList();
			 /*List<SqlRow> novedadestt = new ArrayList<SqlRow>();
			 for (int i = 0; i < 4; i++) {
				 for(SqlRow sx :novedades) {
					 novedadestt.add(sx);
				 }
		     }

			 novedades = novedadestt;*/
			 Logger.debug("novedades: " +novedades.toString());



			 List<List<Remito>> subsNovedades = new ArrayList<>();
			 int fin = (novedades.size() < 75)?novedades.size():75;
			 subsNovedades.add(novedades.subList(0,fin));



			 if(novedades.size() > 75 ) {

				 //int qTotalSubLis = (novedades.size()-20)/25;
				 int inicio = 75;
				 fin = 75;

				 Logger.debug("-----------111-------------: ");
				 Logger.debug("novedades.size(): " +(novedades.size()));
				 Logger.debug("fin: " +(fin));
				 Logger.debug("----------1111-----------: ");

				 while(fin < novedades.size()) {

					 Logger.debug("------------222------------: ");
					 Logger.debug("(fin <= novedades.size()): " +(fin <= novedades.size()));
					 Logger.debug("inicio: " +inicio);
					 Logger.debug("fin: " +fin);
					 Logger.debug("------------222-----------: ");
					 fin = fin+75;
					 fin = (fin > novedades.size())?novedades.size():fin;

					 List<Remito> listTmp = novedades.subList(inicio,fin);
					 subsNovedades.add(listTmp);
					 inicio = inicio+75;
				 }


			 }

			 qpag = qpag+subsNovedades.size();
			 String footerPage = "";

			 //PAAAGEEEEESSSS
			 int pag = 1;
			 for(List<Remito> sbx : subsNovedades) {

				 String textInicial = (pag == 1)?texto:"";

				 String novedadesTr ="";

				 int z = 0;
				 for(Remito sx :sbx) {


					 if(z == 0) {
						 novedadesTr  += "<tr>" ;
					 }

					 novedadesTr  += "<td style='text-align:left;border:1px solid black; padding:5px; margin:0px;'><b>"+sx.numero+"</b></td><td style='text-align: right;border:1px solid black; margin:0px;'>"+ utils.NumberUtils.moneda(sx.getTotal(), 2)+"</td>";
					 z++;
					 if(z == 3) {
						 novedadesTr  += "</tr>";
						 z = 0;
					 }
				 }

				 String novedadesTabla = "<table class=\"tabla-uno\" style=\"border:1px solid #000000;font-size:14px;width: 100%;text-align: center;\" cellspacing=\"2\" cellpadding=\"2\">\n" +
				 		"        <thead style=\"background-color: #BDBDBD;\">\n" +
				 		"            <tr>\n" +
				 		"            	<th style=\"border: 1px solid;\">N°</th>\n" +
				 		"               <th style=\"border: 1px solid;width:50px;\">Monto</th>\n" +
				 		"            	<th style=\"border: 1px solid;\">N°</th>\n" +
				 		"               <th style=\"border: 1px solid;width:50px;\">Monto</th>\n" +
				 		"            	<th style=\"border: 1px solid;\">N°</th>\n" +
				 		"               <th style=\"border: 1px solid;width:50px;\">Monto</th>\n" +
				 		"            </tr>\n" +
				 		"        </thead>\n" +
				 		"        	<tbody class=\"lineas\">\n" +novedadesTr+
				 		"			</tbody>\n" +
				 		"		</table>";

				 String hoja = "<div class=\"border_div\" style=\"height:900px; padding:10px;border-top:none; border-bottom:2px solid #000000;text-align: justify;\">\n"
					 		+textInicial+novedadesTabla+"</div>";

				 footerPage = ReportePdf.getFooterPage(pag, qpag);
				 pag ++;
				 body += header+hoja+footer+footerPage;
			 }
			 //FINN PAAAGEEEEESSSS




			 datos.put("body", body);

			 String outputPdf = ReportePdf.reportePdfGenerico(fileName,datos);

			 return ok(reportePlanilla.render(outputPdf));

		} catch (Exception e) {
		  // TODO Auto-generated catch block
		      e.printStackTrace();
		}



		 return ok(reportePlanilla.render(null));
	}

}