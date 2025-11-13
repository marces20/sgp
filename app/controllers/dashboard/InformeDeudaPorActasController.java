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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.ActaRecepcion;
import models.Usuario;
import models.informes.InformeDeudaPorActa;
import models.informes.InformeDeudaPorActaMaterializada;
import models.informes.InformeEstadisticoDeudaProveedores;
import play.Logger;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.dashboard.informeEstadisticoDeudaProveedores.informeDeudaPorActas;

@Security.Authenticated(Secured.class)
public class InformeDeudaPorActasController extends Controller {


	@CheckPermiso(key = "dashboardInformeDeudaPorActas")
	public static Result index() {

		/*Pagination<InformeDeudaPorActa> i = InformeDeudaPorActa.page(RequestVar.get("acta_numero"),
																	 RequestVar.get("orden_provision"),
																	 RequestVar.get("proveedor_id"),
																	 RequestVar.get("expediente_id"),
																	 RequestVar.get("ejercicio"),
																	 RequestVar.get("deuda_mayor"),
																	 RequestVar.get("deuda_menor"),
																	 RequestVar.get("profe"),
																	 false,
																	 RequestVar.get("dolar"),
																	 RequestVar.get("deposito_id"),
																	 RequestVar.get("tipo_acta"),
																	 RequestVar.get("tipo_cuenta_id"),
																	 RequestVar.get("tipo_moneda"));*/
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		Pagination<InformeDeudaPorActaMaterializada> i = InformeDeudaPorActaMaterializada.page(RequestVar.get("acta_numero"),
																								 RequestVar.get("orden_provision"),
																								 RequestVar.get("proveedor_id"),
																								 RequestVar.get("expediente_id"),
																								 RequestVar.get("ejercicio"),
																								 RequestVar.get("deuda_mayor"),
																								 RequestVar.get("deuda_menor"),
																								 RequestVar.get("profe"),
																								 false,
																								 RequestVar.get("dolar"),
																								 RequestVar.get("deposito_id"),
																								 RequestVar.get("tipo_acta"),
																								 RequestVar.get("tipo_cuenta_id"),
																								 RequestVar.get("tipo_moneda"),
																								 RequestVar.get("emergencia"),"");

		return ok(informeDeudaPorActas.render(i, form().bindFromRequest()));
	}

	@CheckPermiso(key = "dashboardInformeDeudaPorActas")
	public static Result archivoDeudaPorActas () {


		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		Pagination<InformeDeudaPorActaMaterializada> informe = InformeDeudaPorActaMaterializada.page(RequestVar.get("acta_numero"),
																			RequestVar.get("orden_provision"),
																			RequestVar.get("proveedor_id"),
																			RequestVar.get("expediente_id"),
																			RequestVar.get("ejercicio"),
																			RequestVar.get("deuda_mayor"),
																			RequestVar.get("deuda_menor"),
																			RequestVar.get("profe"),
																			false,
																			RequestVar.get("dolar"),
																			RequestVar.get("deposito_id"),
																			RequestVar.get("tipo_acta"),
																			RequestVar.get("tipo_cuenta_id"),
																			RequestVar.get("tipo_moneda"),
																			RequestVar.get("emergencia"),"");

		String dirTemp = System.getProperty("java.io.tmpdir");

		Integer fila = 10;

		Integer celdaActa 			 = 0;
		Integer celdaEjercicio 		 = 1;
		Integer celdaFecha 			 = 2;
		Integer celdaOp 			 = 3;
		Integer celdaExp			 = 4;
		Integer celdaCuenta			 = 5;
		Integer celdaInst			 = 6;
		Integer celdaRubro			 = 7;
		Integer celdaProveedor 		 = 8;
		Integer celdaTotalActa	 	 = 9;
		Integer celdaTotalAutorizado = 10;
		Integer celdaTotalPagado 	 = 11;
		Integer celdaTotalDeuda 	 = 12;
		Integer celdaDetalleExpediente = 13;

		try {
			File archivo = new File(dirTemp+"/informe-deuda-actas-"+Usuario.getUsuarioSesion()+".xls");
			if(archivo.exists()) archivo.delete();
			FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/dashboard/informe-deuda-actas.xls"));

			Workbook libro = new HSSFWorkbook(file);
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = libro.getSheetAt(0);
			Cell celda;

			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

		    for (InformeDeudaPorActaMaterializada i : informe.getList()) {

				Row f = hoja.createRow(fila);

				//Acta número
				celda = f.createCell(celdaActa);
				celda.setCellValue( i.acta_numero );

				Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx "+i.acta_numero);

				//ejercicio
				celda = f.createCell(celdaEjercicio);
				celda.setCellValue((i.ejercicio != null)?i.ejercicio.nombre:"");

				//fecha
				celda = f.createCell(celdaFecha);
				celda.setCellValue(utils.DateUtils.formatDate(i.fecha));

				//Número Op
				celda = f.createCell(celdaOp);
				String orden = "";
				if(i.ordenProvision != null){
					celda.setCellValue( i.ordenProvision.numero );
				}else{
					celda.setCellValue( "" );
				}
				//Celda Exp
				celda = f.createCell(celdaExp);
				celda.setCellValue(i.expediente.getExpedienteEjercicio());

				//Celda cuenta
				celda = f.createCell(celdaCuenta);
				celda.setCellValue((i.tipoCuenta != null)?i.tipoCuenta.nombre:"");

				//Celda Institucion
				celda = f.createCell(celdaInst);
				celda.setCellValue(i.ordenCompra.deposito.nombre);

				//Celda Rubro
				celda = f.createCell(celdaRubro);
				celda.setCellValue(i.ordenCompra.ordenRubro.nombre);

				//Celda Proveedor
				celda = f.createCell(celdaProveedor);
				celda.setCellValue(i.proveedor.nombre);

				//Celda total total acta
				celda = f.createCell(celdaTotalActa);
				celda.setCellValue(i.totalActa.doubleValue());
				celda.setCellStyle(style);

				//Celda total total acta
				celda = f.createCell(celdaTotalAutorizado);
				celda.setCellValue(i.totalAutorizado.doubleValue());
				celda.setCellStyle(style);

				//Celda total total pagado
				celda = f.createCell(celdaTotalPagado);
				celda.setCellValue(i.totalPagado.doubleValue());
				celda.setCellStyle(style);




				//Celda total de deudas
				celda = f.createCell(celdaTotalDeuda);
				celda.setCellValue(i.totalDeuda.doubleValue());
				celda.setCellStyle(style);

				//Celda detalle expediente
				celda = f.createCell(celdaDetalleExpediente);
				celda.setCellValue(i.expediente.descripcion);
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
}
