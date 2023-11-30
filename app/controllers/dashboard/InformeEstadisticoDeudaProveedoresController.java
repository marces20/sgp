package controllers.dashboard;

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
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import models.ActaRecepcion;
import models.Estado;
import models.Recepcion;
import models.Remito;
import models.Usuario;
import models.informes.*;
import play.Logger;
import play.Play;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import scala.collection.parallel.ParIterableLike.Find;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.dashboard.informeEstadisticoDeudaProveedores.*;

@Security.Authenticated(Secured.class)
public class InformeEstadisticoDeudaProveedoresController extends Controller {
	final static Form<InformeDeudaProveedoresMaterializada> form = form(InformeDeudaProveedoresMaterializada.class);

	@CheckPermiso(key = "dashboardInformeDeudaProveedores")
	public static Result index() {
		actualizarVistaMaterializada();
		Pagination<InformeDeudaProveedoresMaterializada> i = InformeDeudaProveedoresMaterializada.page(
															RequestVar.get("orden"),
															RequestVar.get("proveedor_id"),
															RequestVar.get("expediente_id"),
															RequestVar.get("ejercicio"),
															RequestVar.get("rubro_id"),
															RequestVar.get("deuda_mayor"),
															RequestVar.get("deuda_menor"),
															RequestVar.get("pago_mayor"),
															RequestVar.get("pago_menor"),
															RequestVar.get("compromiso_mayor"),
															RequestVar.get("compromiso_menor"),
															RequestVar.get("profe"),
															RequestVar.get("deposito_id"),
															false,
															RequestVar.get("tipo_moneda"),
															RequestVar.get("tipo_cuenta_id"),
															RequestVar.get("acta_sin_adelanto_menor_pago"),
															RequestVar.get("monto_adelanto"),
															RequestVar.get("emergencia"),
															RequestVar.get("perimido"),
															RequestVar.get("orden_subrubro_id"));

		return ok(index.render(i, form().bindFromRequest()));
	}

	@CheckPermiso(key = "dashboardInformeDeudaProveedores")
	public static Result archivoEstadistico () {
		actualizarVistaMaterializada();
		Pagination<InformeDeudaProveedoresMaterializada> informe = InformeDeudaProveedoresMaterializada.page(
																 RequestVar.get("orden"),
																 RequestVar.get("proveedor_id"),
																 RequestVar.get("expediente_id"),
																 RequestVar.get("ejercicio"),
																 RequestVar.get("rubro_id"),
																 RequestVar.get("deuda_mayor"),
																 RequestVar.get("deuda_menor"),
																 RequestVar.get("pago_mayor"),
																 RequestVar.get("pago_menor"),
																 RequestVar.get("compromiso_mayor"),
																 RequestVar.get("compromiso_menor"),
																 RequestVar.get("profe"),
																 RequestVar.get("deposito_id"),
																 false,
																 RequestVar.get("tipo_moneda"),
																 RequestVar.get("tipo_cuenta_id"),
																 RequestVar.get("acta_sin_adelanto_menor_pago"),
																 RequestVar.get("monto_adelanto"),
																 RequestVar.get("emergencia"),
																 RequestVar.get("perimido"),
																 RequestVar.get("orden_subrubro_id"));


		String dirTemp = System.getProperty("java.io.tmpdir");

		Integer fila = 10;

		Integer celdaOp 			 = 0;
		Integer celdaFechaExp		 = 1;
		Integer celdaExp			 = 2;
		Integer celdaRubro  		 = 3;
		Integer celdaCuenta 		 = 4;
		Integer celdaInstitucion 	 = 5;
		Integer celdaProveedor 		 = 6;
		Integer celdaTotalOrden 	 = 7;
		Integer celdaTotalPagado 	 = 8;
		Integer celdaTotalDeuda 	 = 9;
		Integer celdaActas 			 = 10;
		Integer celdaTotalCompromiso = 11;
		Integer celdaDetalleExpediente = 12;
		Integer celdaRemitos = 13;




		try {
			File archivo = new File(dirTemp+"/informe-estadistico-"+Usuario.getUsuarioSesion()+".xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/dashboard/informe-estadistico.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;


			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));


		    for (InformeDeudaProveedoresMaterializada i : informe.getList()) {

				Row f = hoja.createRow(fila);

				//Número Op
				celda = f.createCell(celdaOp);
				String orden = "";
				if(i.ordenProvision != null)

				celda.setCellValue( i.ordenProvision.numero );

				//Celda Fecha Exp
				celda = f.createCell(celdaFechaExp);
				celda.setCellValue(utils.DateUtils.formatDate(i.expedienteObj.fecha));

				//Celda Exp
				celda = f.createCell(celdaExp);
				celda.setCellValue(i.expediente);

				//Celda Cuenta
				celda = f.createCell(celdaCuenta);
				celda.setCellValue( (i.tipo_cuenta_id != null)?i.tipoCuenta.nombre:"" );

				//Celda Rubro
				celda = f.createCell(celdaRubro);
				celda.setCellValue(i.rubro);

				//Celda Rubro
				celda = f.createCell(celdaInstitucion);
				celda.setCellValue(i.deposito.nombre);

				//Celda Rubro
				celda = f.createCell(celdaProveedor);
				celda.setCellValue(i.proveedor.nombre);

				//Celda total de orden
				celda = f.createCell(celdaTotalOrden);
				celda.setCellValue(i.totalOrden.doubleValue());
				celda.setCellStyle(style);


				//Celda total total pagado
				celda = f.createCell(celdaTotalPagado);
				celda.setCellValue(i.totalPagado.doubleValue());
				celda.setCellStyle(style);


				//Celda total de deudas
				celda = f.createCell(celdaTotalDeuda);
				if(i.totalDeuda != null) celda.setCellValue(i.totalDeuda.doubleValue());
				else celda.setCellValue(0.0);

				celda.setCellStyle(style);



				//Celda total de compromiso
				celda = f.createCell(celdaTotalCompromiso);
				if(i.totalCompromiso != null) celda.setCellValue(i.totalCompromiso.doubleValue());
				else celda.setCellValue(0.0);
				celda.setCellStyle(style);


				String actas = "";
				if(i.orden_provision_id != null){
					for(ActaRecepcion a:  ActaRecepcion.find.fetch("ejercicio", "nombre").select("numero").where().eq("orden_provision_id", i.orden_provision_id).findList() ) {
						actas += a.numero+"/"+a.ejercicio.nombre+", ";
					}
				}


				//Celda actas
				celda = f.createCell(celdaActas);
				celda.setCellValue(actas.replaceAll(", $", ""));

				//Celda Detalle Expediente
				celda = f.createCell(celdaDetalleExpediente);
				celda.setCellValue(i.expedienteObj.descripcion);
				celda.setCellStyle(style);

				String remitos= "";
				/*if(i.orden_provision_id != null){

					for(Recepcion rx : Recepcion.find.where().eq("orden_provision_id", i.orden_provision_id).findList()) {
						String ac = "";
						ActaRecepcion arx = ActaRecepcion.find.where().eq("id", rx.acta_id).findUnique();
						if(arx != null) {
							ac = arx.numero+"/"+arx.ejercicio.nombre;
						}

						for(Remito rm: Remito.find.where().eq("recepcion_id", rx.id).findList()){

							//remitos += ac+"-"+rm.numero+"||";

						}
					}*/

					/*for(ActaRecepcion a:  ActaRecepcion.find.fetch("ejercicio", "nombre").select("numero").where().eq("orden_provision_id", i.orden_provision_id).findList() ) {
						actas += a.numero+"/"+a.ejercicio.nombre+", ";
					}*/
				//}


				celda = f.createCell(celdaRemitos);
				celda.setCellValue(remitos);
				celda.setCellStyle(style);

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


	public static Result getActas(Long id_orden_provision) {

		List<ActaRecepcion> listaActas = ActaRecepcion.find.fetch("ejercicio", "nombre").select("numero").where().eq("orden_provision_id", id_orden_provision).eq("state_id", Estado.ACTA_ESTADO_APROBADA).findList();
		String actas = "";



		for(ActaRecepcion a:  listaActas ) {
			actas += a.numero+"/"+a.ejercicio.nombre+", ";
		}

		if (listaActas.isEmpty()) {
			actas = "Sin acta";
		}


		return ok(actas.replaceAll(", $", ""));
	}

	public static Result diferencias() {
		List<String> msg = new ArrayList<String>();
		return ok(diferencias.render(msg));
	}

	public static Result procesarDiferencias() {
		actualizarVistaMaterializada();
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart upload = body.getFile("archivo");
		List<String> msg = new ArrayList<String>();

		if(upload == null) {
			return ok(diferencias.render(msg));
		}

	    File file = upload.getFile();


	    List<InformeDeudaProveedoresMaterializada> informe = InformeDeudaProveedoresMaterializada.find.where().findList();
	    Map<String,InformeDeudaProveedoresMaterializada> aux = new HashMap<String,InformeDeudaProveedoresMaterializada>();


	    for (InformeDeudaProveedoresMaterializada info : informe) {
	    	//System.out.println(info.ano);
			if(info.ordenProvision.numero != null) {
				//System.out.println(info.ordenProvision);
				aux.put(info.ordenProvision.numero.toString()+info.ano, info);



			}
		}


	    try{
		    FileInputStream input = new FileInputStream(file.getAbsolutePath());
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Row row;

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				String op = null;
				String ano = null;
				String clave = null;
				row = sheet.getRow(i);
				//Número de orden de provision
				if(HSSFCell.CELL_TYPE_NUMERIC == row.getCell(0).getCellType()) {
					Double opa = row.getCell(0).getNumericCellValue();
					try {
						op = String.valueOf(opa.intValue()).trim();
					}  catch(Exception e){}
				}
				if(HSSFCell.CELL_TYPE_STRING == row.getCell(0).getCellType()) {
					try {
						op = row.getCell(0).getStringCellValue().trim();
					}  catch(Exception e){}

				}

				//Año
				if(HSSFCell.CELL_TYPE_NUMERIC == row.getCell(1).getCellType()) {
					Double anodd = row.getCell(1).getNumericCellValue();
					try {
						ano = String.valueOf(anodd.intValue()).trim();
					}  catch(Exception e){}
				}
				if(HSSFCell.CELL_TYPE_STRING == row.getCell(1).getCellType()) {
					try {
						ano = row.getCell(1).getStringCellValue().trim();
					}  catch(Exception e){}

				}

				//Total orden
				BigDecimal totalOrden = new BigDecimal(0).setScale(2);
				if(HSSFCell.CELL_TYPE_NUMERIC == row.getCell(3).getCellType()) {
					Double to = row.getCell(3).getNumericCellValue();
					try {
						totalOrden = new BigDecimal(to).setScale(2, RoundingMode.HALF_UP);
					}  catch(Exception e){}
				}
				if(HSSFCell.CELL_TYPE_STRING == row.getCell(3).getCellType()) {
					try {
						totalOrden = new BigDecimal(row.getCell(3).getStringCellValue()).setScale(2, RoundingMode.HALF_UP);
					}  catch(Exception e){}

				}



				//Total pagado
				BigDecimal totalPagado = new BigDecimal(0).setScale(2);
				if(HSSFCell.CELL_TYPE_NUMERIC == row.getCell(4).getCellType()) {
					Double tp = row.getCell(4).getNumericCellValue();
					try {
						totalPagado = new BigDecimal(tp).setScale(2, RoundingMode.HALF_UP);
					}  catch(Exception e){
						totalPagado = new BigDecimal(0.00);
						System.out.println("ppppppppppppppppp");
					}
				}

				if(HSSFCell.CELL_TYPE_STRING == row.getCell(4).getCellType()) {
					try {
						totalPagado = new BigDecimal(row.getCell(4).getStringCellValue()).setScale(2, RoundingMode.HALF_UP);
					}  catch(Exception e){
						totalPagado = new BigDecimal(0.00);

					}

				}


				System.out.println("xxxxxxxxxxxxxxx");
				String exp = "";
				if(HSSFCell.CELL_TYPE_STRING == row.getCell(2).getCellType()) {
					try {
						exp = row.getCell(2).getStringCellValue();
					}  catch(Exception e){
						exp = "---";
						System.out.println("ddddd");
						System.out.println("eeeeeeeeeeeeeeeeee");
					}

				}


				if(op != null && ano != null) {

					if(!aux.containsKey(op+ano)) {
						//msg.add("La OP: " + op+" ejercicio "+ano+" del exp: " + exp + " es diferente o no existe en el sistema.");
						//System.out.println("La OP "+op+ano+" no existe en el sistema.");
					} else {

						InformeDeudaProveedoresMaterializada info = aux.get(op+ano);

						/*
						if(totalOrden != null && info.totalOrden.compareTo(totalOrden) != 0) {
							msg.add(op+" ejercicio "+ano+" Total de orden diferente.");
							msg.add(op+" ejercicio "+ano + " expediente "+info.expediente);
							System.out.println("La OP "+op+ano+" Totales de orden diferentes.");
						}
						*/

						/*
						if(info.totalPagado.compareTo(totalPagado) != 0) {
							msg.add(op+" expediente "+info.expediente + " proveedor " + info.proveedor.nombre);
							System.out.println("La OP "+op+ano+" Pagos diferentes.");
						}
						*/

						/*
						 1670

						 13193

						if((info.totalActas.subtract(info.totalOrden)).compareTo(totalActas) != 0) {
							msg.add(op+" expediente "+info.expediente + " proveedor " + info.proveedor.nombre + " | " + info.totalActas.subtract(info.totalPagado) + " - " + totalActas);
							System.out.println("La OP "+op+ano+" Pagos diferentes.");
						}
						*/


						BigDecimal pagoArchivo = totalPagado;
						BigDecimal pagadoSistema = info.totalPagado.setScale(2, RoundingMode.HALF_UP);



						//msg.add("Archivo: "+totalPagado+" sistema: "+info.totalPagado +" --------- " +op+" ejercicio "+ano + " expediente "+info.expediente + " proveedor " + info.proveedor.nombre);
						if(pagadoSistema.compareTo(pagoArchivo) != 0) {
							msg.add("Archivo: "+pagoArchivo+" sistema: "+info.totalPagado +" --------- Orden de provisión: "  +op+ " expediente "+info.expediente + " proveedor " + info.proveedor.nombre);
						}



						/*
						if(deudaSistema.compareTo(deudaArchivo) != 0) {
							msg.add(op+" ejercicio "+ano + " expediente "+info.expediente+ " | " + info.totalOrden + " | " + deudaSistema + " | " +  deudaArchivo);
							System.out.println("La OP "+op+ano+" Pagos diferentes.");
						}




						if(totalActas == null && (info.totalDeuda.compareTo( BigDecimal.ZERO) != 0) ) {
							//msg.add(op+" ejercicio "+ano + " expediente "+info.expediente + " proveedor " + info.proveedor.nombre   + " | " + info.totalPagado + " - " + totalPagado);
						}
						*/
					}

				}




			}
	    } catch(Exception e){
	    	System.out.println("Excepction: " + e.getMessage());
	    	System.out.println("dddddddddddddddddddd");
		}



		return ok(diferencias.render(msg));
	}

	private static void actualizarVistaMaterializada () {

		//Ebean.createSqlUpdate("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada").execute();
		Connection conn = play.db.DB.getConnection();
		try {
		    Statement stmt = conn.createStatement();
		    stmt.execute("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
