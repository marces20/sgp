package controllers.dashboard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import models.ClienteTipo;
import models.recupero.InformeTotal;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.avaje.ebean.SqlRow;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.ReportesExcelsUtils;
import views.html.dashboard.informesRecupero.*;
import controllers.Secured;

@Security.Authenticated(Secured.class)
public class InformesRecuperoReportesController extends Controller {

	public static Result deudasPorTipoDeCliente(Long idTipoCliente,String fecha_desde,String fecha_hasta) {


		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();

		File archivo = new File(dirTemp+"/INFORME-DEUDAS-RESUMEN"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+".xls");
		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Sheet hoja = getDeudasPorTipoDeClienteSheet(libro,idTipoCliente,fecha_desde,fecha_hasta);


			libro.write(archivoTmp);
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render());
		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(index.render());
		}
	}

	public static Sheet getDeudasPorTipoDeClienteSheet(Workbook libro,Long idTipoCliente,String fecha_desde,String fecha_hasta){

		List<SqlRow> deudasPorPaciente = new ArrayList<SqlRow>();
		List<SqlRow> deudasPorExtrajero = new ArrayList<SqlRow>();
		List<SqlRow> deudasPorObrasSociales = new ArrayList<SqlRow>();
		List<SqlRow> deudasPorArt = new ArrayList<SqlRow>();
		List<SqlRow> deudasPorSeguro = new ArrayList<SqlRow>();

		if(idTipoCliente.equals(ClienteTipo.PACIENTES) || idTipoCliente.equals(new Long(-1))){
			deudasPorPaciente = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.PACIENTES,fecha_desde,fecha_hasta);
		}
		if(idTipoCliente.equals(ClienteTipo.EXTRANJEROS) || idTipoCliente.equals(new Long(-1))){
			deudasPorExtrajero = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.EXTRANJEROS,fecha_desde,fecha_hasta);
		}
		if(idTipoCliente.equals(ClienteTipo.OBRAS_SOCIALES) || idTipoCliente.equals(new Long(-1))){
			deudasPorObrasSociales = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.OBRAS_SOCIALES,fecha_desde,fecha_hasta);
		}
		if(idTipoCliente.equals(ClienteTipo.ART) || idTipoCliente.equals(new Long(-1))){
			deudasPorArt = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.ART,fecha_desde,fecha_hasta);
		}

		if(idTipoCliente.equals(ClienteTipo.SEGUROS) || idTipoCliente.equals(new Long(-1))){
			deudasPorSeguro = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.SEGUROS,fecha_desde,fecha_hasta);
		}

		Sheet hoja = libro.createSheet("RESUMEN");

		hoja.setColumnWidth(0, 1200);
		hoja.setColumnWidth(1, 18000);
		hoja.setColumnWidth(2, 6000);
		hoja.setColumnWidth(3, 6000);

		hoja.setDefaultRowHeight( (short) 400);

		int x = 0;
		if(deudasPorPaciente.size() > 0){
			x = getListadoDeudasPorTipoDeCliente(x,"PACIENTES",libro,hoja,deudasPorPaciente);
		}
		if(deudasPorExtrajero.size() > 0){
			x = getListadoDeudasPorTipoDeCliente(x,"EXTRANJEROS",libro,hoja,deudasPorExtrajero);
		}
		if(deudasPorObrasSociales.size() > 0){
			x = getListadoDeudasPorTipoDeCliente(x,"OBRA SOCIALES",libro,hoja,deudasPorObrasSociales);//servicios
		}
		if(deudasPorSeguro.size() > 0){
			x = getListadoDeudasPorTipoDeCliente(x,"SEGUROS",libro,hoja,deudasPorSeguro);//servicios
		}
		if(deudasPorArt.size() > 0){
			x = getListadoDeudasPorTipoDeCliente(x,"ART",libro,hoja,deudasPorArt);//servicios
		}

		x= 0;

		return hoja;

	}

	public static int getListadoDeudasPorTipoDeCliente(int x,String tipoCliente,Workbook libro,Sheet hoja,List<SqlRow> lista){
		ReportesExcelsUtils reu = new ReportesExcelsUtils();
		CellStyle estiloMoneda = reu.getEstiloMoneda(libro);
		CellStyle comun = reu.getEstiloComun(libro);
		CellStyle cabeceraPrincipal = reu.getCabeceraSinFondoGris(libro,14);
		CellStyle cabecera = reu.getCabecera(libro,10);

		Row fila = hoja.createRow(x);

		Cell celda0 = fila.createCell(0);
		celda0.setCellValue("PARQUE DE LA SALUD DE LA PROVINCIA DE MISIONES ");
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
		x++;

		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue(tipoCliente+" CON ATRASOS EN LOS PAGOS");
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
		x++;



		String fecha = DateUtils.formatDate(new Date());

		fila = hoja.createRow(x);
		celda0 = fila.createCell(0);
		celda0.setCellValue("MONTOS A INTIMAR POR EXCEDER EL PLAZO NORMAL DE CUMPLIMIENTO - "+fecha);
		celda0.setCellStyle(cabeceraPrincipal);
		hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
		x++;




		fila = hoja.createRow(x);

		celda0 = fila.createCell(0);
		celda0.setCellValue("N°");
		celda0.setCellStyle(cabecera);

		celda0 = fila.createCell(1);
		celda0.setCellValue(tipoCliente);
		celda0.setCellStyle(cabecera);

		celda0 = fila.createCell(2);
		celda0.setCellValue("CUIT");
		celda0.setCellStyle(cabecera);

		/*celda0 = fila.createCell(2);
		celda0.setCellValue("IMPORTE");
		celda0.setCellStyle(cabecera);

		celda0 = fila.createCell(3);
		celda0.setCellValue("DEBITOS");
		celda0.setCellStyle(cabecera);*/

		celda0 = fila.createCell(3);
		celda0.setCellValue("SALDO");
		celda0.setCellStyle(cabecera);

		x++;

		BigDecimal mtfa = new BigDecimal(0);
		BigDecimal mtpa = new BigDecimal(0);
		BigDecimal mtde = new BigDecimal(0);
		boolean cargar = false;
		boolean xx = false;
		boolean ss = true;

		int z = 1;
		for(SqlRow s : lista){
	    	fila = hoja.createRow(x);

	    	celda0 = fila.createCell(0);
			celda0.setCellValue(z);
			celda0.setCellStyle(comun);

	    	celda0 = fila.createCell(1);
			celda0.setCellValue(s.getString("cliente_nombre"));
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(2);
			celda0.setCellValue(s.getString("cuit"));
			celda0.setCellStyle(comun);

			/*celda0 = fila.createCell(2);
			celda0.setCellValue(s.getBigDecimal("total_factura").doubleValue());
			celda0.setCellStyle(estiloMoneda);

			celda0 = fila.createCell(3);
			celda0.setCellValue(s.getBigDecimal("total_pago").doubleValue());
			celda0.setCellStyle(estiloMoneda);*/

			celda0 = fila.createCell(3);
			celda0.setCellValue(s.getBigDecimal("total_deuda").doubleValue());
			celda0.setCellStyle(estiloMoneda);

			x++;
			z++;

			mtfa= mtfa.add(s.getBigDecimal("total_factura"));
			mtpa= mtpa.add(s.getBigDecimal("total_pago"));
			mtde= mtde.add(s.getBigDecimal("total_deuda"));
			//nombreProveedor = s.getString("nombre_proveedor");
	    }

		    fila = hoja.createRow(x);
		    celda0 = fila.createCell(0);
			celda0.setCellValue("");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTAL GENERAL SUJETO A INTIMACION");
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,2));

			/*celda0 = fila.createCell(2);
			celda0.setCellValue(mtfa.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue(mtpa.doubleValue());
			celda0.setCellStyle(estiloMoneda);*/
			celda0 = fila.createCell(3);
			celda0.setCellValue(mtde.doubleValue());
			celda0.setCellStyle(estiloMoneda);

			/*celda0 = fila.createCell(4);
			celda0.setCellValue("");
			celda0.setCellStyle(comun);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,4,5));*/
			x++;
			x++;





		return x;
	}
}
