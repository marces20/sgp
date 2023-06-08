package controllers.contabilidad;

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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Cuenta;
import models.CuentaBancaria;
import models.Estado;
import models.FacturaLineaImpuesto;
import models.Pago;
import models.Periodo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.RetencionesUtils;
import utils.StringUtils;
import views.html.contabilidad.pagos.reportes.modalInformeLote;
import views.html.contabilidad.pagos.reportes.modalInformeMensualImpuestos;
import views.html.contabilidad.pagos.reportes.modalInformeMensualRentas;
import views.html.haberes.puestosLaborales.respuestaModal;
import views.html.haberes.puestosLaborales.reportes.descargarArchivo;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.google.common.base.Strings;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

@Security.Authenticated(Secured.class)
public class PagosReportesController extends Controller  {

	@CheckPermiso(key = "pagosInformeMensualRentas")
	public static Result modalInformeMensualRentas() {

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(modalInformeMensualRentas.render(null));
		}


		SqlRow noContabilizado = Ebean.createSqlQuery("SELECT count(id) cantidad FROM pagos p WHERE (state_id <> "+Estado.PAGO_ESTADO_CONCILIADO+" OR state_id <> "+Estado.PAGO_ESTADO_PAGADO+") AND p.id IN(:ids)").setParameter("ids", pagosSeleccionados).findUnique();

		if(noContabilizado.getInteger("cantidad") > 0) {
			flash("error", "El informe se puede confeccionar únicamente con pagos en estado \"Contabilizado\" o \"Entregado\" .");
			return ok(modalInformeMensualRentas.render(null));
		}

		SqlRow noContratado = Ebean.createSqlQuery("SELECT count(p.id) cantidad FROM pagos p INNER JOIN proveedores pr ON pr.id = p.proveedor_id INNER JOIN agentes a ON a.id = pr.agente_id WHERE (a.planta = true OR a.id IS NULL) AND p.id IN(:ids)").setParameter("ids", pagosSeleccionados).findUnique();

		if(noContratado.getInteger("cantidad") > 0) {
			flash("error", "El informe se puede confeccionar únicamente con agentes contratados.");
			return ok(modalInformeMensualRentas.render(null));
		}

		String sql = "SELECT pr.nombre, a.dni, pr.cuit, sum(m.total) total FROM pagos p "
				   + "INNER JOIN (select pago_id, sum(monto) as total from pagos_lineas group by pago_id) m on m.pago_id = p.id "
				   + "INNER JOIN proveedores pr ON pr.id = p.proveedor_id "
				   + "INNER JOIN agentes a ON a.id = pr.agente_id "
				   + "WHERE a.planta = false AND (state_id = :conciliado OR state_id = :pagado) AND p.id IN(:ids) and total > 0 "
				   + "GROUP BY a.id, pr.nombre, a.dni, pr.cuit order by pr.nombre ";

		List<SqlRow> c = Ebean.createSqlQuery(sql)
				.setParameter("ids", pagosSeleccionados)
				.setParameter("conciliado", Estado.PAGO_ESTADO_CONCILIADO)
				.setParameter("pagado", Estado.PAGO_ESTADO_PAGADO)
				.findList();

		try {
			DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
			unusualSymbols.setDecimalSeparator('.');

			DecimalFormat df = new DecimalFormat("#.##",unusualSymbols);
			String newLine = System.getProperty("line.separator");
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/informe_rentas.txt");
			//FileOutputStream file = new FileOutputStream(archivo);
			String linea = "";
			String fecha = DateUtils.formatDate(new Date(), "MM-yyyy");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "Cp1252"));
			out.append("PARQUE DE LA SALUD DR RAMON MADARIAGA@30712224300@"+fecha+"@O\r\n");

			for (SqlRow pago : c) {
				out.append(pago.getString("nombre").replace(",","") + "@");
				out.append(pago.getString("dni") + "@");
				out.append(pago.getString("cuit") + "@");
				out.append(pago.getString("cuit") + "@");
				out.append("@");
				out.append("@");
				out.append(df.format(pago.getBigDecimal("total")));
				out.append("\r\n");

			}

			//String textoArchivo = "PARQUE DE LA SALUD DE LA PROVINCIA DE MISIONES DR RAMON MADARIAGA@30712224300@FECHA"+newLine+newLine+linea;

			//file.write(textoArchivo.getBytes());
			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(modalInformeMensualRentas.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(modalInformeMensualRentas.render(null));
	}

	public static Result descargarInformeMensualRentas(String url){
		return ok(new File(url));
	}


	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("id_pago[]");
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

	public static Result reporteCheque(Long id) throws IOException {

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/cheque.odt");

		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/contabilidad/pagos/cheque.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();

		      Pago pago = Pago.find.byId(id);

		      context.put("importe", NumberUtils.formatNumber(pago.total.doubleValue()));
		      context.put("dia", utils.DateUtils.formatDate(pago.fecha_pago, "dd"));
		      Integer mes = new Integer(utils.DateUtils.formatDate(pago.fecha_pago, "M"));


		      context.put("mes", utils.DateUtils.getMesLetras(pago.fecha_pago.getMonth()).toUpperCase());
		      context.put("anio", utils.DateUtils.formatDate(pago.fecha_pago, "yyyy"));
		      context.put("paguese_a", pago.paguese_a);
		      new NumeroALetra();
			context.put("importe_letra", NumeroALetra.convertNumberToLetterSinPesos(pago.total.toString()));

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

	public static FileOutputStream armarExcelLote(List<Pago> pagos,File archivo) throws IOException{


		Workbook libro = new HSSFWorkbook();
		FileOutputStream archivoTmp = new FileOutputStream(archivo);

		Sheet hoja = libro.createSheet("Lotes");

		Row fila = hoja.createRow(0);
		fila.createCell(0).setCellValue("Proveedor");
		fila.createCell(1).setCellValue("Cuenta");
		fila.createCell(2).setCellValue("Monto facturado");
		fila.createCell(3).setCellValue("Monto");
		fila.createCell(4).setCellValue("Monto Credito");
		fila.createCell(5).setCellValue("Periodo");
		fila.createCell(6).setCellValue("Expediente");
		fila.createCell(7).setCellValue("OP");
		fila.createCell(8).setCellValue("Fecha de pago");
		fila.createCell(9).setCellValue("Referencia");
		fila.createCell(10).setCellValue("Estado");

		int f = 1;
		for (Pago pago : pagos) {
				fila = hoja.createRow(f);
				for(int c=0;c<10;c++){
					Cell celda = fila.createCell(c);

					switch (c) {
					case 0:
						celda.setCellValue(pago.proveedor.nombre);
						break;
					case 1:
						String cuentaN = "";
						for (CuentaBancaria cuenta : pago.proveedor.cuenta) {
							if(cuenta.predeterminada && cuenta.estado_id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO) {
								cuentaN = cuenta.numero_cuenta;
							}
						}
						celda.setCellValue(cuentaN);
						break;
					case 2:
						celda.setCellValue(pago.factura.getBase().doubleValue());
						break;
					case 3:
						celda.setCellValue(pago.total.doubleValue());
						break;
					case 4:
						celda.setCellValue(pago.total_credito.doubleValue());
						break;
					case 5:
						celda.setCellValue((pago.periodo != null)?pago.periodo.nombre:"");
						break;
					case 6:
						celda.setCellValue(pago.expediente.getExpedienteEjercicio());
						break;
					case 7:
						celda.setCellValue(pago.ordenPago.getNombreCompleto());
						break;
					case 8:
						celda.setCellValue(utils.DateUtils.formatDate(pago.fecha_pago));
						break;
					case 9:
						celda.setCellValue(pago.referencia);
						break;
					case 10:
						celda.setCellValue(pago.estado.nombre);
						break;
					default:
						break;
					}
				}
				f++;
		}

		libro.write(archivoTmp);

		return archivoTmp;
	}

	public static Result descargarLotesPago(Long idMisPagos){

		List<Pago> pagos = Pago.find.where().eq("mis_pagos_id", idMisPagos).findList();

		if(pagos.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(modalInformeLote.render(null));
		}

		String error = "";
		Boolean hayError = false;

		try {

			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/lotes.xls");

			if(archivo.exists()) archivo.delete();

			archivo.createNewFile();

			FileOutputStream archivoTmp = armarExcelLote(pagos,archivo);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			return ok(archivo);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result descargarLotes(){

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(modalInformeLote.render(null));
		}

		String error = "";
		Boolean hayError = false;

		try {

			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/lotes.xls");

			if(archivo.exists()) archivo.delete();

			archivo.createNewFile();

			List<Pago> pagos = Pago.find.where().in("id", pagosSeleccionados).findList();

			FileOutputStream archivoTmp = armarExcelLote(pagos,archivo);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(modalInformeLote.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result informeProfe(){

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(modalInformeLote.render(null));
		}

		String error = "";
		Boolean hayError = false;

		try {

			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/informeProfe.xls");

			if(archivo.exists()) archivo.delete();

			archivo.createNewFile();

			List<Pago> pagos = Pago.find.where().in("id", pagosSeleccionados).findList();

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			Sheet hoja = libro.createSheet("Lotes");

			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Fecha");
			fila.createCell(1).setCellValue("Nº Cheque/Tranferencia");
			fila.createCell(2).setCellValue("Nombre del Prestador");
			fila.createCell(3).setCellValue("Nº de Exp");
			fila.createCell(4).setCellValue("Mes de Prestación");
			fila.createCell(5).setCellValue("Importe");


			int f = 1;
			for (Pago pago : pagos) {


					fila = hoja.createRow(f);
					for(int c=0;c<6;c++){
						Cell celda = fila.createCell(c);

						switch (c) {
						case 0:
							celda.setCellValue(utils.DateUtils.formatDate(pago.fecha_pago));
							break;
						case 1:
							celda.setCellValue((pago.numero_cheque != null  && pago.numero_cheque.isEmpty())?pago.numero_cheque:pago.referencia);
							break;
						case 2:
							celda.setCellValue(pago.proveedor.nombre);
							break;
						case 3:
							celda.setCellValue(pago.expediente.getExpedienteEjercicio());
							break;
						case 4:
							celda.setCellValue((pago.periodo_id != null)? pago.periodo.nombre:"");
							break;
						case 5:
							Double monto = (pago.total != null)?pago.total.setScale(2, RoundingMode.HALF_UP).doubleValue():0;
							celda.setCellValue(monto);
							break;

						}
					}
					f++;

					FacturaLineaImpuesto ff = new FacturaLineaImpuesto();
					List<Pago> pagosImpuestos = Pago.find.where().eq("factura_id", pago.factura_id).eq("tipo","impuestos").findList();

					for(Pago pi :pagosImpuestos){

						fila = hoja.createRow(f);

						for(int c=0;c<8;c++){
							Cell celda = fila.createCell(c);

							switch (c) {
							case 0:
								celda.setCellValue("");
								break;
							case 1:
								celda.setCellValue("");
								break;
							case 2:
								celda.setCellValue(pago.proveedor.nombre +"-"+pi.cuentaImpuesto.nombre);
								break;
							case 3:
								celda.setCellValue(pi.expediente.getExpedienteEjercicio());
								break;
							case 4:
								celda.setCellValue("");
								break;
							case 5:
								Double monto = (pi.total != null)?pi.total.setScale(2, RoundingMode.HALF_UP).doubleValue():0;
								celda.setCellValue(monto);
								break;

							}
						}
						f++;
					}

			}

			libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(modalInformeLote.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result informeImpuestoMunicipal(){

		List<Integer> pagosSeleccionados = getSeleccionados();

		if(pagosSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(modalInformeLote.render(null));
		}

		String error = "";
		Boolean hayError = false;

		try {

			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/impuestoMunicipal.xls");

			if(archivo.exists()) archivo.delete();

			archivo.createNewFile();

			List<Pago> pagos = Pago.find.where().in("id", pagosSeleccionados).gt("total", 0).findList();

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			Sheet hoja = libro.createSheet("Lotes");

			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("cuit");
			fila.createCell(1).setCellValue("agente");
			fila.createCell(2).setCellValue("periodo");
			fila.createCell(3).setCellValue("tipo_declaracion");



			fila = hoja.createRow(1);
			fila.createCell(0).setCellValue("30712224300");
			fila.createCell(1).setCellValue("PARQUE DE LA SALUD DE LA PROVINCIA DE MISIONES");
			fila.createCell(2).setCellValue(Periodo.getPeriodoByDate(pagos.get(0).fecha_pago).nombre);
			fila.createCell(3).setCellValue("retencion");

			fila = hoja.createRow(3);
			fila.createCell(0).setCellValue("comprobante_numero");
			fila.createCell(1).setCellValue("cuit");
			fila.createCell(2).setCellValue("comprobante_fecha_emision");
			fila.createCell(3).setCellValue("importe_operacion");
			fila.createCell(4).setCellValue("alicuota");
			fila.createCell(5).setCellValue("importe_a_depositar");

			int f = 4;
			for (Pago pago : pagos) {
					fila = hoja.createRow(f);

					FacturaLineaImpuesto ff = new FacturaLineaImpuesto();
					List<FacturaLineaImpuesto> flil = pago.factura.facturaLineaImpuesto;

					for(FacturaLineaImpuesto fli: flil){
						if(fli.cuenta_id.compareTo(pago.cuenta_impuesto_id.longValue()) == 0){
							ff = fli;
						}
					}

					for(int c=0;c<8;c++){
						Cell celda = fila.createCell(c);

						switch (c) {
						case 0:
							celda.setCellValue(ff.nombre);
							break;
						case 1:
							celda.setCellValue(pago.factura.proveedor.cuit);
							break;
						case 2:
							celda.setCellValue(utils.DateUtils.formatDate(pago.fecha_pago));
							break;
						case 3:
							Double base = (ff.base != null)?ff.base.setScale(2, RoundingMode.HALF_DOWN).doubleValue():0;
							celda.setCellValue(base);
							break;
						case 4:
							celda.setCellValue(7);
							break;
						case 5:
							Double monto = (ff.monto != null)?ff.monto.setScale(2, RoundingMode.HALF_DOWN).doubleValue():0;
							celda.setCellValue(monto);
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
			return ok(modalInformeLote.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result informeRetencionSuss(String regimen) {
		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(respuestaModal.render());
		}

		try {
			String newLine = System.getProperty("line.separator");
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/f2004.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "Cp1252"));

			String linea = "";

			Integer i = 1;
			boolean error = false;


			List<Pago> pagos = Pago.find.where().in("id", seleccionadas).gt("total", BigDecimal.ZERO).findList();
			String stringError = "";
			for(Pago p : pagos){

				List<String> cadena = new ArrayList<>();

				FacturaLineaImpuesto ff = new FacturaLineaImpuesto();
				List<FacturaLineaImpuesto> flil = p.factura.facturaLineaImpuesto;
				for(FacturaLineaImpuesto fli: flil){
					if(fli.cuenta_id.compareTo(p.cuenta_impuesto_id.longValue()) == 0){
						ff = fli;
					}
				}

				/*List<Pago> pc = Pago.find.where()
						.eq("factura_id", p.factura.id)
						.eq("tipo", "impuestos")
						.eq("cuenta_impuesto_id", ff.cuenta_id)
						.eq("total",ff.monto)
						.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
						.findList();
				if(pc.size() > 0){
					flash("error", "Se superpone impuesto ya pagado. PAGO: PAG"+p.id+" referencia:"+p.referencia);
					return ok(respuestaModal.render());
				}*/

				List<Pago> plx = Pago.find.where()
						 .eq("factura_id", p.factura_id)
						 .eq("cuenta_impuesto_id", ff.cuenta_id)
						 .eq("total",ff.monto)
						 .ne("state_id", Estado.PAGO_ESTADO_BORRADOR)
						 .ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
						 .findList();
				if(plx.size() <= 0){
					cadena.add(StringUtils.numerico("2004", 4));//Formulario
					cadena.add(StringUtils.numerico("100", 4));//Version
					cadena.add(StringUtils.alfanumerico("",10));//Cod Trazabilidad
					cadena.add(StringUtils.numerico("30712224300", 11));//CuitAgente
					cadena.add(StringUtils.numerico("353", 3));//Impuesto
					//cadena.add(StringUtils.numerico("748", 3));//Regimen
					cadena.add(StringUtils.numerico(regimen, 3));//Regimen
					cadena.add(StringUtils.numerico(p.factura.proveedor.cuit.toString(), 11));//Cuit Retenido
					cadena.add(DateUtils.formatDate(p.fecha_pago));//Fecha retencion
					cadena.add(StringUtils.numerico("5", 2));//tipo comprobante
					cadena.add(DateUtils.formatDate(p.factura.fecha_orden_pago));//Fecha comprobante
					cadena.add(StringUtils.alfanumerico(p.ordenPago.numero.toString(),16));//numero comprobante
					cadena.add(StringUtils.numerico(p.factura.getBase().toString(), 14));//importe comprobante
					cadena.add(StringUtils.numerico(p.total.toString(), 14));//importe retencion
					cadena.add("                         ");//numero certificado
					cadena.add("          ");//Fecha retencion certificado
					cadena.add(StringUtils.numerico("0.00", 14));//importe certificado original
					cadena.add(StringUtils.alfanumerico("",30));//otros datos
					cadena.add(newLine);
					out.append(StringUtils.implode(cadena, ""));
					//out.append(newLine);
				}
			}

			out.flush();
			out.close();

			if(error){
				flash("error", stringError);
				return ok(descargarArchivo.render(null));
			}else{
				flash("success", "El archivo fue creado correctamente.");
				return ok(descargarArchivo.render(archivo.getPath()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		flash("error", "No se pudo generar el archivo");
		return ok(respuestaModal.render());

	}



	public static Result informeRetDgrSellos() {
		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(respuestaModal.render());
		}


		List<Integer> facturasSeleccionados = new ArrayList<Integer>();
		List<Pago> pagos = Pago.find.where().in("id", seleccionadas).gt("total", 0).findList();

		for (Pago pago : pagos) {
			facturasSeleccionados.add(pago.factura_id);
		}

		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
				.in("factura_id", facturasSeleccionados)
				.disjunction()
				.eq("cuenta_id",Cuenta.RET_DGR_SELLOS)
				.eq("cuenta_id",Cuenta.RET_DGR_SELLOS_ART21)
				.eq("cuenta_id",Cuenta.RET_DGR_SELLOS_ART22)
				.endJunction()
				.orderBy("factura.proveedor.nombre").findList();

		try {
			String dirTempSello = System.getProperty("java.io.tmpdir");
			File archivoSellos = new File(dirTempSello+"/generacion_retencion_dgr.txt");

			Writer outSellos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoSellos), "Cp1252"));



			for (FacturaLineaImpuesto l : listaFacturasImpuestos) {

				Pago p = Pago.find.where().eq("factura_id", l.factura.id)
						.eq("tipo","payment")
						.ne("state_id", Estado.PAGO_ESTADO_CANCELADO).findUnique();

				/*List<Pago> pc = Pago.find.where()
						.eq("factura_id", p.factura.id)
						.eq("tipo", "impuestos")
						.eq("cuenta_impuesto_id", l.cuenta_id)
						.eq("total",l.monto)
						.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
						.findList();
				if(pc.size() > 0){
					flash("error", "Se superpone impuesto ya pagado. PAGO: PAG"+p.id+" referencia:"+p.referencia);
					return ok(respuestaModal.render());
				}*/

				List<Pago> plx = Pago.find.where()
						 .eq("factura_id", l.factura_id)
						 .eq("cuenta_impuesto_id", l.cuenta_id)
						 .eq("total",l.monto)
						 .ne("state_id", Estado.PAGO_ESTADO_BORRADOR)
						 .ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
						 .findList();
				if(plx.size() <= 0){

					outSellos.append(l.nombre+",");
					outSellos.append("102"+",");
					outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
					//outSellos.append(DateUtils.formatDate(l.factura.fecha_orden_pago,"dd-MM-yyyy")+",");
					outSellos.append(DateUtils.formatDate(p.fecha_pago,"dd-MM-yyyy")+",");
					String base = (l.base == null)?l.monto.divide(new BigDecimal(0.005),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
					outSellos.append(base+",");
					outSellos.append("0.010000"+",");
					outSellos.append(l.monto.setScale(2, BigDecimal.ROUND_HALF_UP)+",");
					outSellos.append("0"+",");
					outSellos.append(l.factura.proveedor.getCuitConGuiones()+",");
					outSellos.append(""+",");
					outSellos.append(""+",");
					outSellos.append("50");
					outSellos.append("\r\n");
				}
			}

			outSellos.flush();
			outSellos.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(descargarArchivo.render(archivoSellos.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		flash("error", "No se pudo generar el archivo");
		return ok(respuestaModal.render());

	}

	public static Result informeRetDgrIibb() {
		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(respuestaModal.render());
		}


		List<Integer> facturasSeleccionados = new ArrayList<Integer>();
		List<Pago> pagos = Pago.find.where().in("id", seleccionadas).gt("total", 0).findList();

		for (Pago pago : pagos) {
			facturasSeleccionados.add(pago.factura_id);
		}

		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
				.in("factura_id", facturasSeleccionados)
				.eq("cuenta_id",Cuenta.RET_IIBB)
				.orderBy("factura.proveedor.nombre").findList();

		try {
			String dirTempSello = System.getProperty("java.io.tmpdir");
			File archivoSellos = new File(dirTempSello+"/generacion_retencion_dgr.txt");

			Writer outSellos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoSellos), "Cp1252"));



			for (FacturaLineaImpuesto l : listaFacturasImpuestos) {

				Pago p = Pago.find.where().eq("factura_id", l.factura.id)
						.eq("tipo","payment")
						.ne("state_id", Estado.PAGO_ESTADO_CANCELADO).findUnique();

				/*List<Pago> pc = Pago.find.where()
						.eq("factura_id", p.factura.id)
						.eq("tipo", "impuestos")
						.eq("cuenta_impuesto_id", l.cuenta_id)
						.eq("total",l.monto)
						.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
						.findList();
				if(pc.size() > 0){
					flash("error", "Se superpone impuesto ya pagado. PAGO: PAG"+p.id+" referencia:"+p.referencia);
					return ok(respuestaModal.render());
				}*/
				List<Pago> plx = Pago.find.where()
						 .eq("factura_id", l.factura_id)
						 .eq("cuenta_impuesto_id", l.cuenta_id)
						 .eq("total",l.monto)
						 .ne("state_id", Estado.PAGO_ESTADO_BORRADOR)
						 .ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
						 .findList();
				if(plx.size() <= 0){

					/*outSellos.append(DateUtils.formatDate(p.fecha_pago,"dd-MM-yyyy")+",");
					outSellos.append(l.nombre+",");
					outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
					outSellos.append(l.factura.proveedor.getFirstDireccion()+",");
					outSellos.append(l.factura.proveedor. getCuitConGuiones()+",");
					String base = (l.base == null)?l.monto.divide(new BigDecimal(0.0196),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
					outSellos.append(base+",");
					outSellos.append("1.96"+",");
					outSellos.append("\r\n");*/

					outSellos.append(DateUtils.formatDate(p.fecha_pago,"dd-MM-yyyy")+",");
					outSellos.append("CR,");
					outSellos.append(l.nombre+",");
					outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
					outSellos.append(l.factura.proveedor. getCuitConGuiones()+",");
					String base = (l.base == null)?l.monto.divide(new BigDecimal(0.0196),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
					outSellos.append(base+",");
					outSellos.append("1.96"+",,,,");
					outSellos.append("\r\n");
				}
			}

			outSellos.flush();
			outSellos.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(descargarArchivo.render(archivoSellos.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		flash("error", "No se pudo generar el archivo");
		return ok(respuestaModal.render());

	}

	public static Result informeRetDgrIibb331() {
		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(respuestaModal.render());
		}


		List<Integer> facturasSeleccionados = new ArrayList<Integer>();
		List<Pago> pagos = Pago.find.where().in("id", seleccionadas).gt("total", 0).findList();

		for (Pago pago : pagos) {
			facturasSeleccionados.add(pago.factura_id);
		}

		List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
				.in("factura_id", facturasSeleccionados)
				.eq("cuenta_id",Cuenta.RET_IIBB_331)
				.orderBy("factura.proveedor.nombre").findList();

		try {
			String dirTempSello = System.getProperty("java.io.tmpdir");
			File archivoSellos = new File(dirTempSello+"/generacion_retencion_dgr.txt");

			Writer outSellos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoSellos), "Cp1252"));



			for (FacturaLineaImpuesto l : listaFacturasImpuestos) {

				Pago p = Pago.find.where().eq("factura_id", l.factura.id)
						.eq("tipo","payment")
						.ne("state_id", Estado.PAGO_ESTADO_CANCELADO).findUnique();

				/*List<Pago> pc = Pago.find.where()
						.eq("factura_id", p.factura.id)
						.eq("tipo", "impuestos")
						.eq("cuenta_impuesto_id", l.cuenta_id)
						.eq("total",l.monto)
						.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
						.findList();
				if(pc.size() > 0){
					flash("error", "Se superpone impuesto ya pagado. PAGO: PAG"+p.id+" referencia:"+p.referencia);
					return ok(respuestaModal.render());
				}*/
				List<Pago> plx = Pago.find.where()
						 .eq("factura_id", l.factura_id)
						 .eq("cuenta_impuesto_id", l.cuenta_id)
						 .eq("total",l.monto)
						 .ne("state_id", Estado.PAGO_ESTADO_BORRADOR)
						 .ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
						 .findList();
				if(plx.size() <= 0){

					/*outSellos.append(DateUtils.formatDate(p.fecha_pago,"dd-MM-yyyy")+",");
					outSellos.append(l.nombre+",");
					outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
					outSellos.append(l.factura.proveedor.getFirstDireccion()+",");
					outSellos.append(l.factura.proveedor. getCuitConGuiones()+",");
					String base = (l.base == null)?l.monto.divide(new BigDecimal(0.0331),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
					outSellos.append(base+",");
					outSellos.append("3.31"+",");
					outSellos.append("\r\n");*/

					outSellos.append(DateUtils.formatDate(p.fecha_pago,"dd-MM-yyyy")+",");
					outSellos.append("CR,");
					outSellos.append(l.nombre+",");
					outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
					outSellos.append(l.factura.proveedor. getCuitConGuiones()+",");
					String base = (l.base == null)?l.monto.divide(new BigDecimal(0.0331),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
					outSellos.append(base+",");
					outSellos.append("3.31"+",,,,");
					outSellos.append("\r\n");

				}
			}

			outSellos.flush();
			outSellos.close();

			flash("success", "El archivo fue creado correctamente.");
			return ok(descargarArchivo.render(archivoSellos.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		flash("error", "No se pudo generar el archivo");
		return ok(respuestaModal.render());

	}

	public static Result modalInformeMensualImpuestos() {
		DynamicForm d = form().bindFromRequest();

		return ok(modalInformeMensualImpuestos.render(null,null,d));
	}

	public static Result informeMensualImpuestos() {
		DynamicForm d = form().bindFromRequest();
		Date ffh;
		Date ffd;

		String[] fecha_desde = request().body().asFormUrlEncoded().get("fecha_desde");
		String[] fecha_hasta = request().body().asFormUrlEncoded().get("fecha_hasta");
		String[] cuenta_id = request().body().asFormUrlEncoded().get("cuenta_id");

		if(fecha_desde == null && fecha_desde[0].isEmpty()){
			flash("error", "Debe ingresar una fecha inicio.");
			return ok(modalInformeMensualImpuestos.render(null,null,d));
		}else{
			ffd = DateUtils.formatDate(fecha_desde[0], "dd/MM/yyyy");
		}

		if(fecha_hasta == null || fecha_hasta[0].isEmpty()){
			flash("error", "Debe ingresar una fecha fin.");
			return ok(modalInformeMensualImpuestos.render(null,null,d));
		}else{
			ffh = DateUtils.formatDate(fecha_hasta[0], "dd/MM/yyyy");
		}

		if(cuenta_id == null || cuenta_id[0].isEmpty()){
			flash("error", "Debe ingresar una cuenta.");
			return ok(modalInformeMensualImpuestos.render(null,null,d));
		}

		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;

		try {
			File archivo = new File(dirTemp+"/informe_impuestos.xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.createSheet("Lotes");

			List<Pago> pagos = Pago.find.where()
												.ge("fecha_pago", ffd)
												.le("fecha_pago", ffh)
												.eq("tipo", "payment")
												//.ge("total", 0)
												.gt("total", BigDecimal.ZERO)
												.disjunction()
												.eq("state_id",Estado.PAGO_ESTADO_CONCILIADO)
												.eq("state_id",Estado.PAGO_ESTADO_PAGADO)
												.endJunction()
												.findList();

			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Fecha Emision");
			fila.createCell(1).setCellValue("N° Comprobante");
			fila.createCell(2).setCellValue("Proveedor");
			fila.createCell(3).setCellValue("Cuit");
			fila.createCell(4).setCellValue("N° Factura");
			fila.createCell(5).setCellValue("OP");
			fila.createCell(6).setCellValue("Expediente");
			fila.createCell(7).setCellValue("Tipo Cuenta");
			fila.createCell(8).setCellValue("Importe");
			fila.createCell(9).setCellValue("Base Calculo");
			fila.createCell(10).setCellValue("Importe Rentencion");
			fila.createCell(11).setCellValue("Ejercicio");

			int f = 1;
			for (Pago pago : pagos) {
				if(pago.factura.facturaLineaImpuesto != null && pago.factura.facturaLineaImpuesto.size() > 0){
					for(FacturaLineaImpuesto fl :pago.factura.facturaLineaImpuesto){
						Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx "+fl.cuenta_id+"  ---------- "+cuenta_id[0]);
						if(fl.cuenta_id.equals(new Long(cuenta_id[0]))){
							Logger.debug("222222222222222222 ");
							List<Pago> plx = Pago.find.where()
									 .eq("factura_id", pago.factura_id)
									 .eq("cuenta_impuesto_id", fl.cuenta_id)
									 .eq("total",fl.monto)
									 .ne("state_id", Estado.PAGO_ESTADO_BORRADOR)
									 .ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
									 .findList();
							if(plx.size() <= 0){
								Logger.debug("333333333333333333333 ");
								/*List<Pago> pc = Pago.find.where()
										.eq("factura_id", pago.factura.id)
										.eq("tipo", "impuestos")
										.eq("cuenta_impuesto_id", fl.cuenta_id)
										.eq("total",fl.monto)
										.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
										.findList();
								if(pc.size() > 0){
									flash("error", "Se superpone impuesto ya pagado. PAGO: PAG"+pago.id+" referencia:"+pago.referencia);
									return ok(modalInformeMensualImpuestos.render(null,null,d));
								}*/

								fila = hoja.createRow(f);
								for(int c=0;c<12;c++){
									Cell celda = fila.createCell(c);

									switch (c) {
										case 0:
											celda.setCellValue(DateUtils.formatDate(pago.fecha_pago));
											break;
										case 1:
											celda.setCellValue(fl.nombre);
											break;
										case 2:
											celda.setCellValue(pago.proveedor.nombre);
											break;
										case 3:
											celda.setCellValue(pago.proveedor.cuit);
											break;
										case 4:
											celda.setCellValue(pago.factura.numero_factura);
											break;
										case 5:
											celda.setCellValue(pago.ordenPago.numero);
											break;
										case 6:
											celda.setCellValue(pago.expediente.getExpedienteEjercicio());
											break;
										case 7:
											String cx = "";

											if(pago.tipo_cuenta_id != null) {
												cx = pago.tipoCuenta.nombre;
											}else {
												cx = (pago.profe)?"PROFE":"OPER.";
											}
											celda.setCellValue(cx);
											break;
										case 8:
											celda.setCellType(Cell.CELL_TYPE_NUMERIC);
											celda.setCellValue(
													/*(Math.round(pago.factura.getBase().setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()*100.0)/100.0)
														*/
													(pago.factura.getBase().setScale(2, BigDecimal.ROUND_HALF_UP)).doubleValue());
											break;
										case 9:
											celda.setCellType(Cell.CELL_TYPE_NUMERIC);
											celda.setCellValue(RetencionesUtils.getBaseByRentecion(fl.monto, fl.cuenta_id.intValue()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
											break;

										case 10:
											celda.setCellType(Cell.CELL_TYPE_NUMERIC);
											celda.setCellValue(
														//Math.round(fl.monto.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()*100.0)/100.0)
														fl.monto.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()
													);
											break;
										case 11:
											celda.setCellValue((pago.expediente.parent_id != null)?pago.expediente.parent.ejercicio.nombre:pago.expediente.ejercicio.nombre);
											break;
										default:
											break;
									}
								}
								f++;
							}
						}

					}
				}
			}

			libro.write(archivoTmp);
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();

			Long cuentaId = new Long(cuenta_id[0]);

			if(cuentaId.equals(Cuenta.RET_GCIAS_4245_ANEXO) || cuentaId.equals(Cuenta.RET_GCIAS_4245_19) || cuentaId.equals(Cuenta.RET_GCIAS_4245) || cuentaId.equals(Cuenta.RET_DGR_SELLOS) || cuentaId.equals(Cuenta.RET_IIBB) || cuentaId.equals(Cuenta.RET_IIBB_331)){
				List<Integer> facturasSeleccionados = new ArrayList<Integer>();

				for (Pago pago : pagos) {
					facturasSeleccionados.add(pago.factura_id);
				}

				List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
						.in("factura_id", facturasSeleccionados)
						.eq("cuenta_id",cuentaId)
						.orderBy("factura.proveedor.nombre").findList();

				try {
					String dirTempSello = System.getProperty("java.io.tmpdir");
					File archivoSellos = new File(dirTempSello+"/generacion_retencion.txt");

					Writer outSellos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoSellos), "Cp1252"));

					if(cuentaId.equals(Cuenta.RET_DGR_SELLOS)){
						for (FacturaLineaImpuesto l : listaFacturasImpuestos) {
							List<Pago> p = Pago.find.where()
									.eq("factura_id", l.factura.id)
									.eq("tipo","payment")
									.ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
									.gt("total",BigDecimal.ZERO)
									.isNull("cuenta_impuesto_id")
									.orderBy("fecha_pago asc")
									.findList();

							/*List<Pago> pc = Pago.find.where()
									.eq("factura_id", l.factura.id)
									.eq("tipo", "impuestos")
									.eq("cuenta_impuesto_id", cuentaId)
									.eq("total",l.monto)
									.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
									.findList();

							if(pc.size() > 0){
								flash("error", "Se superpone impuesto ya pagado. PAGO: PAG"+p.id+" referencia:"+p.referencia);
								return ok(modalInformeMensualImpuestos.render(null,null,d));
							}*/

							List<Pago> plx = Pago.find.where()
									 .eq("factura_id", l.factura_id)
									 .eq("cuenta_impuesto_id", l.cuenta_id)
									 .eq("total",l.monto)
									 .ne("state_id", Estado.PAGO_ESTADO_BORRADOR)
									 .ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
									 .findList();
							if(plx.size() <= 0){

								String c = "102";
								if(l.factura.proveedor.getLastAtributo() != null && l.factura.proveedor.getLastAtributo().afip_condicion.equals(1)) {
									c = "106";
								}

								outSellos.append(l.nombre+",");
								outSellos.append(c+",");
								outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
								//outSellos.append(DateUtils.formatDate(l.factura.fecha_orden_pago,"dd-MM-yyyy")+",");
								outSellos.append(DateUtils.formatDate(p.get(0).fecha_pago,"dd-MM-yyyy")+",");
								String base = (l.base == null)?l.monto.divide(new BigDecimal(0.005),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
								outSellos.append(base+",");
								outSellos.append("0.010000"+",");
								outSellos.append(l.monto.setScale(2, BigDecimal.ROUND_HALF_UP)+",");
								outSellos.append("0"+",");
								outSellos.append(l.factura.proveedor.getCuitConGuiones()+",");
								outSellos.append(""+",");
								outSellos.append(" "+",");
								outSellos.append("50");
								outSellos.append("\r\n");

								/*NÚMERO	TEXTO	6
								ACTOS/OPERACIÓN	TEXTO	6
								CONTRATANTES	TEXTO	50
								FECHA DE ACTO	TEXTO	10
								MONTO IMPONIBLE	TEXTO	16
								ALICUOTA	TEXTO	16
								IMPORTE RETENIDO	TEXTO	16
								IMPORTE INGRESADO POR EL CONTRIBUYENTE	TEXTO	16
								CUIT	TEXTO	13
								OBSERVACIONES	TEXTO	99
								DISPOSICIÓN LEGAL	TEXTO	15
								EXENCIÓN	NÚMERICO	3*/
							}
						}

					}else if(cuentaId.equals(Cuenta.RET_IIBB)){
						for (FacturaLineaImpuesto l : listaFacturasImpuestos) {

							List<Pago> p = Pago.find.where().eq("factura_id", l.factura.id)
													  .eq("tipo","payment")
													  .isNull("cuenta_impuesto_id")
													  .ne("estado_id", Estado.PAGO_ESTADO_CANCELADO)
													  .orderBy("fecha_pago asc")
													  .findList();


							/*List<Pago> pc = Pago.find.where()
									.eq("factura_id", l.factura.id)
									.eq("tipo", "impuestos")
									.eq("cuenta_impuesto_id", cuentaId)
									.eq("total",l.monto)
									.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
									.findList();

							if(pc.size() > 0){
								flash("error", "Se superpone impuesto ya pagado. PAGO: PAG"+p.id+" referencia:"+p.referencia);
								return ok(modalInformeMensualImpuestos.render(null,null,d));
							}*/

							List<Pago> plx = Pago.find.where()
									 .eq("factura_id", l.factura_id)
									 .eq("cuenta_impuesto_id", l.cuenta_id)
									 .eq("total",l.monto)
									 .ne("state_id", Estado.PAGO_ESTADO_BORRADOR)
									 .ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
									 .findList();
							if(plx.size() <= 0){
								/*VIEJO AL 16-05-2023
								 * outSellos.append(DateUtils.formatDate(p.get(0).fecha_pago,"dd-MM-yyyy")+",");
								outSellos.append(l.nombre+",");
								outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
								outSellos.append(l.factura.proveedor.getFirstDireccion()+",");
								outSellos.append(l.factura.proveedor. getCuitConGuiones()+",");
								String base = (l.base == null)?l.monto.divide(new BigDecimal(0.0196),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
								outSellos.append(base+",");
								outSellos.append("1.96"+",");*/


								outSellos.append(DateUtils.formatDate(p.get(0).fecha_pago,"dd-MM-yyyy")+",");
								outSellos.append("CR,");
								outSellos.append(l.nombre+",");
								outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
								outSellos.append(l.factura.proveedor. getCuitConGuiones()+",");
								String base = (l.base == null)?l.monto.divide(new BigDecimal(0.0196),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
								outSellos.append(base+",");
								outSellos.append("1.96"+",,,,");
								outSellos.append("\r\n");
							}
						}
					}else if(cuentaId.equals(Cuenta.RET_IIBB_331)){
						for (FacturaLineaImpuesto l : listaFacturasImpuestos) {

							List<Pago> p =  Pago.find.where()
									.eq("factura_id", l.factura.id).eq("tipo","payment")
									.ne("estado_id", Estado.PAGO_ESTADO_CANCELADO)
									.isNull("cuenta_impuesto_id")
									.orderBy("fecha_pago asc")
									.findList();

							/*List<Pago> pc = Pago.find.where()
									.eq("factura_id", l.factura.id)
									.eq("tipo", "impuestos")
									.eq("cuenta_impuesto_id", cuentaId)
									.eq("total",l.monto)
									.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
									.findList();

							if(pc.size() > 0){
								flash("error", "Se superpone impuesto ya pagado. PAGO: PAG"+p.id+" referencia:"+p.referencia);
								return ok(modalInformeMensualImpuestos.render(null,null,d));
							}*/
							List<Pago> plx = Pago.find.where()
									 .eq("factura_id", l.factura_id)
									 .eq("cuenta_impuesto_id", l.cuenta_id)
									 .eq("total",l.monto)
									 .ne("state_id", Estado.PAGO_ESTADO_BORRADOR)
									 .ne("state_id", Estado.PAGO_ESTADO_CANCELADO)
									 .findList();
							if(plx.size() <= 0){
								/* VIEJO AL 16-05-2023
								 * outSellos.append(DateUtils.formatDate(p.get(0).fecha_pago,"dd-MM-yyyy")+",");
								outSellos.append(l.nombre+",");
								outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
								outSellos.append(l.factura.proveedor.getFirstDireccion()+",");
								outSellos.append(l.factura.proveedor. getCuitConGuiones()+",");
								String base = (l.base == null)?l.monto.divide(new BigDecimal(0.0331),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
								outSellos.append(base+",");
								outSellos.append("3.31"+",");
								outSellos.append("\r\n");*/

								outSellos.append(DateUtils.formatDate(p.get(0).fecha_pago,"dd-MM-yyyy")+",");
								outSellos.append("CR,");
								outSellos.append(l.nombre+",");
								outSellos.append(l.factura.proveedor.nombre.replace(",","")+",");
								outSellos.append(l.factura.proveedor. getCuitConGuiones()+",");
								String base = (l.base == null)?l.monto.divide(new BigDecimal(0.0331),2, RoundingMode.HALF_UP).toString():l.base.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
								outSellos.append(base+",");
								outSellos.append("3.31"+",,,,");
								outSellos.append("\r\n");


							}
						}
					}else if(cuentaId.equals(Cuenta.RET_GCIAS_4245) || cuentaId.equals(Cuenta.RET_GCIAS_4245_19) || cuentaId.equals(Cuenta.RET_GCIAS_4245_ANEXO)) {
						String data = "";
						for (FacturaLineaImpuesto l : listaFacturasImpuestos) {


							List<Pago> p = Pago.find.where()
									.eq("factura_id", l.factura.id).eq("tipo","payment")
									.ne("estado_id", Estado.PAGO_ESTADO_CANCELADO)
									.isNull("cuenta_impuesto_id")
									.orderBy("fecha_pago asc")
									.findList();


							outSellos.append(getDataGanacias4245(l,p.get(0))).append("\r\n");
						}
					}else if(cuentaId.equals(Cuenta.RET_IVA)) {
						String data = "";
						for (FacturaLineaImpuesto l : listaFacturasImpuestos) {

							List<Pago>  p = Pago.find.where()
									.eq("factura_id", l.factura.id).eq("tipo","payment")
									.ne("estado_id", Estado.PAGO_ESTADO_CANCELADO)
									.isNull("cuenta_impuesto_id")
									.orderBy("fecha_pago asc")
									.findList();


							outSellos.append(getDataIva(l,p.get(0))).append("\r\n");
						}
					}

					outSellos.flush();
					outSellos.close();

					flash("success", "El archivo fue creado correctamente.");
					return ok(modalInformeMensualImpuestos.render(archivo.getPath(),archivoSellos.getPath(),d));
				} catch (IOException e) {
					e.printStackTrace();
					flash("error", "Error nose puede generar el archivo");
					return ok(modalInformeMensualImpuestos.render(null,null,d));

				} catch (Exception e) {
					e.printStackTrace();
					flash("error", "Error nose puede generar el archivo");
					return ok(modalInformeMensualImpuestos.render(null,null,d));
				}

			}

			flash("success", "El archivo fue creado correctamente.");
			return ok(modalInformeMensualImpuestos.render(archivo.getPath(),null,d));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok();
	}

	public static Result informeRetencionGcia4245() {
		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(respuestaModal.render());
		}

		try {
			String newLine = System.getProperty("line.separator");
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/generacion_retencion.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "Cp1252"));

			String linea = "";

			Integer i = 1;
			boolean error = false;
			String stringError = "";



			String data = "";
			List<Integer> facturasSeleccionados = new ArrayList<Integer>();
			List<Pago> pagos = Pago.find.where().in("id", seleccionadas).gt("total", 0).findList();

			for (Pago pago : pagos) {
				facturasSeleccionados.add(pago.factura_id);
			}

			List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
					.in("factura_id", facturasSeleccionados)
					.disjunction()
					.eq("cuenta_id",Cuenta.RET_GCIAS_4245)
					.eq("cuenta_id",Cuenta.RET_GCIAS_4245_19)
					.eq("cuenta_id",Cuenta.RET_GCIAS_4245_ANEXO)
					.endJunction()
					.orderBy("factura.proveedor.nombre").findList();


			for (FacturaLineaImpuesto l : listaFacturasImpuestos) {


				Pago p = Pago.find.where()
						.eq("factura_id", l.factura.id)
						.eq("tipo","payment")
						.ne("estado_id", Estado.PAGO_ESTADO_CANCELADO)
						.isNull("cuenta_impuesto_id")
						.findUnique();


				out.append(getDataGanacias4245(l,p)).append("\r\n");
			}


			out.flush();
			out.close();

			if(error){
				flash("error", stringError);
				return ok(descargarArchivo.render(null));
			}else{
				flash("success", "El archivo fue creado correctamente.");
				return ok(descargarArchivo.render(archivo.getPath()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		flash("error", "No se pudo generar el archivo");
		return ok(respuestaModal.render());

	}

	public static String getDataGanacias4245(FacturaLineaImpuesto l,Pago p) {
		String data = "";
		BigDecimal importeRet = l.monto;
		BigDecimal baseCalculo = new BigDecimal(0);

		if(importeRet.compareTo(BigDecimal.ZERO) < 0){
			importeRet = importeRet.multiply(new BigDecimal(-1));
			baseCalculo = importeRet;
		}

		data += Strings.padEnd("06", 2, '0');

		data +=  Strings.padEnd(DateUtils.formatDate(p.factura.fecha_orden_pago),10,'0');//fecha emision
		data += Strings.padStart(l.factura.ordenPago.getNombreCompleto().replace(" ", ""), 16, '0');//numero comprobante

		String importeComprobante = new DecimalFormat("###.##").format(p.factura.getBase());
		data += Strings.padStart(importeComprobante.replace('.', ','), 16, ' '); // importeComprobante
		data += Strings.padStart("217", 4, '0');//codigo impuesto

		String cod_regimen = (l.tipo != null)? (l.tipo.equals(1))?"094":"078":"XXX";

		data += Strings.padEnd(cod_regimen, 3, '0');//codigo regimen
		data += Strings.padEnd("1", 1, '0');//codigo operacion

		String baseCalculoStr = new DecimalFormat("###.##").format(l.getBase());
		data += Strings.padStart(baseCalculoStr.replace('.', ','), 14, ' '); // base calculo


		data +=  Strings.padEnd(DateUtils.formatDate(p.fecha_pago),10,'0');//fecha emision retencion
		data += Strings.padEnd("01", 2, '0');//codigo condicion


		data += Strings.padEnd("0", 1, '0');//codigo retencion practicada

		String importeRetencion = new DecimalFormat("###.##").format(importeRet);
		data += Strings.padStart(importeRetencion.replace('.', ','), 14, ' '); // importeretencion

		String porcentajeExclusion = new DecimalFormat("###.##").format(BigDecimal.ZERO);
		data += Strings.padStart(porcentajeExclusion.replace('.', ','), 6, ' '); // porcentajeExclusion

		data +=  Strings.padEnd(DateUtils.formatDate(p.fecha_pago),10,'0');//fecha emision boletin
		data += Strings.padEnd("80", 2, '0');//codigo condicion
		data += Strings.padEnd(l.factura.proveedor.cuit.toString(),20, ' '); // cuit

		data += Strings.padEnd("0", 14, '0');

		//data += Strings.padEnd("", 30, '0');
		//data += Strings.padEnd("0", 1, '0');
		//data += Strings.padEnd("", 11, '0');
		//data += Strings.padEnd("", 11, '0');

		return data;
	}

	public static Result informeRetencionIva() {
		List<Integer> seleccionadas = getSeleccionados();

		if(seleccionadas.isEmpty()) {
			flash("error", "No se han seleccionado pagos.");
			return ok(respuestaModal.render());
		}

		try {
			String newLine = System.getProperty("line.separator");
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/generacion_retencion.txt");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), "Cp1252"));

			String linea = "";

			Integer i = 1;
			boolean error = false;
			String stringError = "";



			String data = "";
			List<Integer> facturasSeleccionados = new ArrayList<Integer>();
			List<Pago> pagos = Pago.find.where().in("id", seleccionadas).gt("total", 0).findList();

			for (Pago pago : pagos) {
				facturasSeleccionados.add(pago.factura_id);
			}

			List<FacturaLineaImpuesto> listaFacturasImpuestos = FacturaLineaImpuesto.find.where()
					.in("factura_id", facturasSeleccionados)
					.eq("cuenta_id",Cuenta.RET_IVA)
					.orderBy("factura.proveedor.nombre").findList();


			for (FacturaLineaImpuesto l : listaFacturasImpuestos) {


				Pago p = Pago.find.where()
						.eq("factura_id", l.factura.id)
						.eq("tipo","payment")
						.ne("estado_id", Estado.PAGO_ESTADO_CANCELADO)
						.isNull("cuenta_impuesto_id")
						.findUnique();


				//out.append(getDataIva(l,p)).append("\r\n");
				out.append(getDataIvaNew(l,p)).append("\r\n");

			}


			out.flush();
			out.close();

			if(error){
				flash("error", stringError);
				return ok(descargarArchivo.render(null));
			}else{
				flash("success", "El archivo fue creado correctamente.");
				return ok(descargarArchivo.render(archivo.getPath()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		flash("error", "No se pudo generar el archivo");
		return ok(respuestaModal.render());

	}

	public static String getDataIvaNew(FacturaLineaImpuesto l,Pago p) {
		String newLine = System.getProperty("line.separator");
		String data = "";


		data +=StringUtils.numerico("2005", 4);//Formulario
		data +=StringUtils.numerico("100", 4);//Version
		data +=StringUtils.alfanumerico("",10);//Cod Trazabilidad
		data +=StringUtils.numerico("30712224300", 11);//CuitAgente
		data +=StringUtils.numerico("216", 3);//Impuesto
		data +=StringUtils.numerico("831", 3);//Regimen
		data +=StringUtils.numerico(p.factura.proveedor.cuit.toString(), 11);//Cuit Retenido
		data +=DateUtils.formatDate(p.fecha_pago);//Fecha retencion
		data +=StringUtils.numerico("5", 2);//tipo comprobante
		data +=DateUtils.formatDate(p.factura.fecha_orden_pago);//Fecha comprobante
		data +=StringUtils.alfanumerico(p.ordenPago.numero.toString(),16);//numero comprobante
		data +=StringUtils.numerico(p.factura.getBase().toString(), 14);//importe comprobante
		data +=StringUtils.numerico(p.total.toString(), 14);//importe retencion
		data +="                         ";//numero certificado
		data +="          ";//Fecha retencion certificado
		data +=StringUtils.numerico("0.00", 14);//importe certificado original
		data +=StringUtils.alfanumerico("",30);//otros datos
		data +=newLine;

		return data;
	}

	public static String getDataIva(FacturaLineaImpuesto l,Pago p) {
		String data = "";


		BigDecimal importeRet = l.monto; //ld.importe.multiply(ld.cantidad);
		BigDecimal baseCalculo = new BigDecimal(0);

		if(importeRet.compareTo(BigDecimal.ZERO) < 0){
			//data += Strings.padEnd("08", 2, '0');

			importeRet = importeRet.multiply(new BigDecimal(-1));
			baseCalculo = importeRet;
		}else{
			//data += Strings.padEnd("07", 2, '0');
		}





		data += Strings.padEnd("06", 2, '0');

		data +=  Strings.padEnd(DateUtils.formatDate(p.factura.fecha_orden_pago),10,'0');//fecha emision
		data += Strings.padStart(l.factura.ordenPago.getNombreCompleto().replace(" ", ""), 16, '0');//numero comprobante

		//String importeComprobante = new DecimalFormat("###.##").format(BigDecimal.ZERO);
		String importeComprobante = new DecimalFormat("###.##").format(p.factura.getBase());
		data += Strings.padStart(importeComprobante.replace('.', ','), 16, ' '); // importeComprobante
		data += Strings.padEnd("767", 3, '0');//codigo impuesto

		String cod_regimen = (l.tipo != null)? (l.tipo.equals(1))?"094":"078":"XXX";

		data += Strings.padEnd("831", 3, '0');//codigo regimen
		data += Strings.padEnd("1", 1, '0');//codigo operacion

		//String baseCalculoStr = new DecimalFormat("###.##").format(baseCalculo);
		String baseCalculoStr = new DecimalFormat("###.##").format(l.getBase());
		data += Strings.padStart(baseCalculoStr.replace('.', ','), 14, ' '); // base calculo


		data +=  Strings.padEnd(DateUtils.formatDate(p.fecha_pago),10,'0');//fecha emision retencion
		data += Strings.padEnd("01", 2, '0');//codigo condicion


		data += Strings.padEnd("0", 1, '0');//codigo retencion practicada

		String importeRetencion = new DecimalFormat("###.##").format(importeRet);
		data += Strings.padStart(importeRetencion.replace('.', ','), 14, ' '); // importeretencion

		String porcentajeExclusion = new DecimalFormat("###.##").format(BigDecimal.ZERO);
		data += Strings.padStart(porcentajeExclusion.replace('.', ','), 6, ' '); // porcentajeExclusion

		data +=  Strings.padEnd(DateUtils.formatDate(p.fecha_pago),10,'0');//fecha emision boletin
		data += Strings.padEnd("80", 2, '0');//codigo condicion
		data += Strings.padEnd(l.factura.proveedor.cuit.toString(),20, ' '); // cuit
		data += Strings.padEnd("0", 14, '0');
		data += Strings.padEnd("", 30, '0');
		data += Strings.padEnd("0", 1, '0');
		data += Strings.padEnd("", 11, '0');
		data += Strings.padEnd("", 11, '0');

		return data;
	}
}
