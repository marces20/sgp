package controllers.recupero;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.SqlRow;

import controllers.auth.CheckPermiso;
import models.Cliente;
import models.ClienteTipo;
import models.Estado;
import models.OrdenLineaCliente;
import models.Periodo;
import models.auth.Permiso;
import models.recupero.InformeTotal;
import models.recupero.RecuperoFactura;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DateUtils;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.recupero.recuperoCliente.*;

public class RecuperoClientesController extends Controller {

	@CheckPermiso(key = "clientesVer")
	public static Result index(Long tipoCliente) {
		DynamicForm d = form().bindFromRequest();

		return ok(
				 index.render(
						 Cliente.page(
								 RequestVar.get("nombre"),
								 RequestVar.get("idPaciente"),
								 RequestVar.get("dni"),
								 RequestVar.get("cuit"),
								 tipoCliente.toString()
								 ),
								 d,tipoCliente));
	}

	public static Result ver(Long id,Long tipoCliente) {
		Cliente cliente = Cliente.find.byId(id);

		Form<Cliente> recuperoClienteForm = form(Cliente.class).fill(cliente);
		BigDecimal totalDeuda = InformeTotal.getDeudaPorIdCliente(id, null,null);
		Periodo p = Periodo.getPeriodoByDate(new Date());
		Periodo pMenosTres = Periodo.find.byId(p.id-4);

		String menos90 = DateUtils.formatDate(pMenosTres.date_stop, "dd/MM/yyyy");

		BigDecimal totalDeuda90Dias = InformeTotal.getDeudaPorIdCliente(id, null,menos90);

		return ok(verClienteRecupero.render(cliente,tipoCliente,recuperoClienteForm,totalDeuda,totalDeuda90Dias,menos90));
	}

	public static Result listaDeuda(Long id) {

		Pagination<InformeTotal> i = InformeTotal.page(id.toString(),
				RequestVar.get("periodo_id"),
				RequestVar.get("expediente_id"),
				RequestVar.get("ejercicio"),
				"0",
				RequestVar.get("deuda_menor"),
				RequestVar.get("pago_mayor"),
				RequestVar.get("pago_menor"),
				RequestVar.get("cliente_tipo_id"),
				RequestVar.get("fecha_factura_desde"),
				RequestVar.get("fecha_factura_hasta"),
				RequestVar.get("deposito_id")
				);

		return ok(listaDeudaTab.render(i, form().bindFromRequest()));
	}

	public static Result listaDeclaracionJuradaObraSocial() {

		Periodo p = Periodo.getPeriodoByDate(new Date());
		Periodo pMenosTres = Periodo.find.byId(p.id-4);
		Periodo pHoy = Periodo.find.byId(p.id);

		String menos90 = DateUtils.formatDate(pMenosTres.date_stop, "dd/MM/yyyy");

		String fechaDesde = DateUtils.formatDate(pHoy.date_start, "dd/MM/yyyy");
		String fechaHasta = DateUtils.formatDate(pHoy.date_stop, "dd/MM/yyyy");
		String fecha = DateUtils.formatDate(new Date(), "dd/MM/yyyy");

		List<SqlRow> getDeudaPorTipoDeCliente = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.OBRAS_SOCIALES,null,menos90,false);

		return ok(listaDeclaracionJuradaObraSocial.render(getDeudaPorTipoDeCliente,fecha,fechaDesde,fechaHasta));
	}

	public static Result listaDeclaracionJuradaObraSocialArchivo(){

		try {
			String dirTemp = System.getProperty("java.io.tmpdir");


			File archivo = new File(dirTemp+"/informe-declaracion-jurada.xls");
			if(archivo.exists()) archivo.delete();
			//FileInputStream file = new FileInputStream(Play.application().getFile("conf/resources/reportes/recupero/planilla.xls"));
			archivo.createNewFile();

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			Sheet hoja = libro.createSheet("DJ");
			hoja.setColumnWidth(0, 5000);
			hoja.setColumnWidth(1, 5000);
			hoja.setColumnWidth(2, 20000);
			hoja.setColumnWidth(3, 5000);
			hoja.setColumnWidth(4, 5000);
			hoja.setColumnWidth(5, 5000);
			hoja.setColumnWidth(6, 5000);

			Cell celda;


			CellStyle style = libro.createCellStyle();
			Font defaultFont = libro.createFont();
		    defaultFont.setFontHeightInPoints((short)8);
		    style.setFont(defaultFont);
			style.setDataFormat(libro.createDataFormat().getFormat("$ #,##0.00"));

			CellStyle comun = libro.createCellStyle();
			comun.setDataFormat((short) 10);
			comun.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			comun.setAlignment(CellStyle.ALIGN_CENTER);
			comun.setBorderRight(CellStyle.BORDER_THIN);
			comun.setBorderLeft(CellStyle.BORDER_THIN);
			comun.setBorderTop(CellStyle.BORDER_THIN);
			comun.setBorderBottom(CellStyle.BORDER_THIN);
			comun.setWrapText(true);
			Font font2 = libro.createFont();
	        font2.setFontHeightInPoints((short) 10);
	        comun.setFont(font2);



			Periodo p = Periodo.getPeriodoByDate(new Date());
			Periodo pMenosTres = Periodo.find.byId(p.id-4);
			Periodo pHoy = Periodo.find.byId(p.id);

			String menos90 = DateUtils.formatDate(pMenosTres.date_stop, "dd/MM/yyyy");

			String fechaDesde = DateUtils.formatDate(pHoy.date_start, "dd/MM/yyyy");
			String fechaHasta = DateUtils.formatDate(pHoy.date_stop, "dd/MM/yyyy");
			String fecha = DateUtils.formatDate(new Date(), "dd/MM/yyyy");

			List<SqlRow> getDeudaPorTipoDeCliente = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.OBRAS_SOCIALES,null,menos90,false);


			Row fila = hoja.createRow(0);

			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("ENTIDAD");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue("CUIT");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(2);
			celda0.setCellValue("DENOMINACION");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(3);
			celda0.setCellValue("FECHA DE ACTUALIZACION");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(4);
			celda0.setCellValue("ESTADO");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(5);
			celda0.setCellValue("FECHA DE VIGENCIA DESDE");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(6);
			celda0.setCellValue("FECHA DE VIGENCIA HASTA");
			celda0.setCellStyle(comun);




			int f = 1;
		    for (SqlRow i : getDeudaPorTipoDeCliente ) {
		    	fila = hoja.createRow(f);
		    	for(int c=0;c<7;c++){
					celda = fila.createCell(c);

					switch (c) {
						case 0:
							celda.setCellValue("Parque de la Salud");
							celda.setCellStyle(comun);
							break;
						case 1:
							celda.setCellValue(i.getString("cuit"));
							celda.setCellStyle(comun);
							break;
						case 2:
							celda.setCellValue(i.getString("cliente_nombre"));
							celda.setCellStyle(comun);
							break;
						case 3:
							celda.setCellValue(fecha+" 00:00 HS");
							celda.setCellStyle(comun);
							break;
						case 4:
							String estado = "";

							if(i.getDouble("total_deuda") > 0){
								estado = "DEBE";
							}else{
								estado = "NO DEBE";
							}
							celda.setCellValue(estado);
							celda.setCellStyle(comun);
							break;
						case 5:
							celda.setCellValue(fechaDesde+" 00:00 HS");
							celda.setCellStyle(comun);
							break;
						case 6:
							celda.setCellValue(fechaHasta+" 23:59 HS");
							celda.setCellStyle(comun);
							break;
					}
		    	}

		    	f++;

		    }

		    libro.write(archivoTmp);

			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();


			return ok(archivo);

		} catch (IOException e) {
		    e.printStackTrace();
		}


		return ok("ddd");

	}

}
