package controllers.dashboard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import models.Organigrama;
import models.Profesion;
import models.haberes.EscalaLaboral;
import models.haberes.PuestoLaboral;

import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.haberes.puestosLaborales.reportes.descargarArchivo;

@Security.Authenticated(Secured.class)
public class LiquidacionesReportesController extends Controller  {

	@CheckPermiso(key = "dashboardLiquidacionesPorAgrupadoOrganigrama")
	public static Result liquidacionesPorAgrupadoOrganigrama() {

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/liquidacionesPorAgrupadoOrganigrama.xls");
		Long idPeriodo = null;

		try{
			idPeriodo = new Long(RequestVar.get("periodo_id"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if(archivo.exists()) archivo.delete();
				archivo.createNewFile();

			List<SqlRow> row = PuestoLaboral.getTotalesPorAgrupadosOrganigramaPeriodo(idPeriodo,false);

			List<SqlRow> rowConvenio = PuestoLaboral.getTotalesPorAgrupadosOrganigramaPeriodo(idPeriodo,true);



			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			Sheet hoja = libro.createSheet("Listado");
			int x = 0;

			Row fila = null;
			Cell celda0 = null;

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

			if(row.size() > 0){

				//fila = hoja.createRow(x);
				//celda0 = fila.createCell(0);
				//celda0.setCellValue("");
				//celda0.setCellStyle(comun);

				//x++;

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Organigrama");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("Cantidad");
				celda0.setCellStyle(comun);


				celda0 = fila.createCell(2);
				celda0.setCellValue("Total Con Aportes");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Total Sin Aportes");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Retenciones");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("TOTAL GASTO");
				celda0.setCellStyle(comun);
				x++;

				for(SqlRow rp: row){

					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(rp.getString("nombre"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(rp.getInteger("cantidadEmpleados"));
					celda0.setCellStyle(comun);



					celda0 = fila.createCell(2);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("totalConAporte").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(3);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("totalSinAporte").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("totalRetenciones").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("totalConAporte").add(rp.getBigDecimal("totalSinAporte")).add(rp.getBigDecimal("totalRetenciones")).doubleValue());
					celda0.setCellStyle(estiloMoneda);

					x++;
				}

				x++;
				x++;

				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("CONVENIO");
				celda0.setCellStyle(comun);
				x++;
				fila = hoja.createRow(x);
				celda0 = fila.createCell(0);
				celda0.setCellValue("Organigrama");
				celda0.setCellStyle(comun);

				celda0 = fila.createCell(1);
				celda0.setCellValue("Cantidad");
				celda0.setCellStyle(comun);


				celda0 = fila.createCell(2);
				celda0.setCellValue("Total Con Aportes");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(3);
				celda0.setCellValue("Total Sin Aportes");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(4);
				celda0.setCellValue("Retenciones");
				celda0.setCellStyle(comun);
				celda0 = fila.createCell(5);
				celda0.setCellValue("TOTAL GASTO");
				celda0.setCellStyle(comun);
				x++;

				for(SqlRow rp: rowConvenio){

					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(rp.getString("nombre"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(rp.getInteger("cantidadEmpleados"));
					celda0.setCellStyle(comun);



					celda0 = fila.createCell(2);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("totalConAporte").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(3);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("totalSinAporte").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("totalRetenciones").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("totalConAporte").add(rp.getBigDecimal("totalSinAporte")).add(rp.getBigDecimal("totalRetenciones")).doubleValue());
					celda0.setCellStyle(estiloMoneda);

					x++;
				}


			}



			libro.write(archivoTmp);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(archivo);
	}

	@CheckPermiso(key = "dashboardLiquidacionesPorProfesion")
	public static Result liquidacionesPorOrganigrama() {

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/ListadoPorOrganigrama.xls");
		Long idPeriodo = null;
		Long idOrganigrama = null;

		try{
			idPeriodo = new Long(RequestVar.get("periodo_id"));
			idOrganigrama = new Long(RequestVar.get("organigrama_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if(archivo.exists()) archivo.delete();
				archivo.createNewFile();

			List<SqlRow> rowParque = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,null, false,null,idOrganigrama);

			List<SqlRow> rowConvenio = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,null, true,null,idOrganigrama);

			List<SqlRow> rowPlanta = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,null, null,null,idOrganigrama);

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			Sheet hoja = libro.createSheet("Listado");
			int x = 0;

			Row fila = null;
			Cell celda0 = null;

			Organigrama px = Organigrama.find.byId(idOrganigrama);

			x = getListadoLiquidacionesDetalles(idPeriodo,false,rowParque,x,celda0,fila,hoja,libro,px.nombre+" PARQUE DE LA SALUD");
			x = getListadoLiquidacionesDetalles(idPeriodo,false,rowConvenio,x,celda0,fila,hoja,libro,px.nombre+" CONVENIO MINISTERIO");
			x = getListadoLiquidacionesDetalles(idPeriodo,true,rowPlanta,x,celda0,fila,hoja,libro,px.nombre+" PLANTA");

			libro.write(archivoTmp);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(archivo);
	}

	@CheckPermiso(key = "dashboardLiquidacionesPorProfesion")
	public static Result liquidacionesPorEscala() {

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/ListadoPorEscala.xls");
		Long idPeriodo = null;
		Long idEscala = null;

		try{
			idPeriodo = new Long(RequestVar.get("periodo_id"));
			idEscala = new Long(RequestVar.get("escala_laboral_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if(archivo.exists()) archivo.delete();
				archivo.createNewFile();


			List<SqlRow> rowParque = PuestoLaboral.getTotalesPorEscalaProfesionPeriodo(idPeriodo,false,idEscala);

			List<SqlRow> rowConvenio = PuestoLaboral.getTotalesPorEscalaProfesionPeriodo(idPeriodo, true,idEscala);

			List<SqlRow> rowPlanta = PuestoLaboral.getTotalesPorEscalaProfesionPeriodo(idPeriodo, null,idEscala);

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			Sheet hoja = libro.createSheet("Listado");
			int x = 0;

			Row fila = null;
			Cell celda0 = null;


			EscalaLaboral px = EscalaLaboral.find.byId(idEscala);

			x = getListadoLiquidacionesPorEscala(idPeriodo,false,rowParque,x,celda0,fila,hoja,libro,px.nombre+" - PARQUE DE LA SALUD");
			x = getListadoLiquidacionesPorEscala(idPeriodo,false,rowConvenio,x,celda0,fila,hoja,libro,px.nombre+" - CONVENIO MINISTERIO");
			x = getListadoLiquidacionesPorEscala(idPeriodo,true,rowPlanta,x,celda0,fila,hoja,libro,px.nombre+" - PLANTA");

			libro.write(archivoTmp);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(archivo);
	}

	@CheckPermiso(key = "dashboardLiquidacionesPorProfesion")
	public static Result liquidacionesPorProfesion() {

		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/ListadoPorProfesion.xls");
		Long idPeriodo = null;
		Long idProfesion = null;

		try{
			idPeriodo = new Long(RequestVar.get("periodo_id"));
			idProfesion = new Long(RequestVar.get("profesion_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if(archivo.exists()) archivo.delete();
				archivo.createNewFile();

			List<SqlRow> rowParque = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,idProfesion, false,null,null);

			List<SqlRow> rowConvenio = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,idProfesion, true,null,null);

			List<SqlRow> rowPlanta = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,idProfesion, null,null,null);

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);

			Sheet hoja = libro.createSheet("Listado");
			int x = 0;

			Row fila = null;
			Cell celda0 = null;

			Profesion px = Profesion.find.byId(idProfesion);

			x = getListadoLiquidacionesDetalles(idPeriodo,false,rowParque,x,celda0,fila,hoja,libro,px.nombre+" PARQUE DE LA SALUD");
			x = getListadoLiquidacionesDetalles(idPeriodo,false,rowConvenio,x,celda0,fila,hoja,libro,px.nombre+" CONVENIO MINISTERIO");
			x = getListadoLiquidacionesDetalles(idPeriodo,true,rowPlanta,x,celda0,fila,hoja,libro,px.nombre+" PLANTA");

			libro.write(archivoTmp);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(archivo);
	}

	public static int getListadoLiquidacionesDetalles(Long idPeriodo,boolean planta,List<SqlRow> row,int x,Cell celda0,Row fila,Sheet hoja,Workbook libro,String titulo){



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

		if(row.size() > 0){

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue(titulo);
			celda0.setCellStyle(comun);

			x++;

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("NOMBRE");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue("PROFESION");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(2);
			celda0.setCellValue("LUGAR");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(3);
			celda0.setCellValue("HABER BRUTO");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(4);
			celda0.setCellValue("GUARDIA");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(5);
			celda0.setCellValue("PRODUCCION");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(6);
			celda0.setCellValue("ADICIONALES");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(7);
			celda0.setCellValue("DESCUENTOS");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(8);
			celda0.setCellValue("NETO");
			celda0.setCellStyle(comun);
			x++;

			HashMap<String, HashMap<String, List<SqlRow>>> fr = new HashMap<String, HashMap<String, List<SqlRow>>>();

			HashMap<String, Integer> conceptosGuardias = new HashMap<String, Integer>();
			HashMap<String, Integer> conceptosAdicional = new HashMap<String, Integer>();
			HashMap<String, Integer> conceptosProduccion = new HashMap<String, Integer>();

			for(SqlRow rp: row){
				boolean h = true;

				if(planta){
					h = (rp.getInteger("idTipoRelacion").compareTo(3) != 0 && rp.getInteger("idTipoRelacion").compareTo(1) != 0);
				}else{
					h = (rp.getInteger("idTipoRelacion").compareTo(3) == 0 || rp.getInteger("idTipoRelacion").compareTo(1) == 0);
				}

				if(h){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(rp.getString("nombre"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(rp.getString("profesion"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellValue(rp.getString("organigrama"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(3);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("haber").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("guardias").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					List<SqlRow> listConcepto = PuestoLaboral.getLiquidacionDetallePorTipo(idPeriodo,rp.getLong("idPuestoLaboral"),2);

					int lx = 1;
					for(SqlRow gtdpt : listConcepto){
						if(!conceptosGuardias.containsKey(gtdpt.getString("concepto"))){
							conceptosGuardias.put(gtdpt.getString("concepto"), lx);
							lx = lx+3;
						}
					}

					if(fr.containsKey("guardias")){
						HashMap<String, List<SqlRow>> gtmp = fr.get("guardias");
						gtmp.put(rp.getLong("idPuestoLaboral").toString()+"&&"+rp.getString("nombre"), listConcepto);
						fr.put("guardias", gtmp);
					}else{
						HashMap<String, List<SqlRow>> g = new HashMap<String, List<SqlRow>>();
						g.put(rp.getLong("idPuestoLaboral").toString()+"&&"+rp.getString("nombre"), listConcepto);
						fr.put("guardias", g);
					}


					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("produccion").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					listConcepto = PuestoLaboral.getLiquidacionDetallePorTipo(idPeriodo,rp.getLong("idPuestoLaboral"),3);

					lx = 1;
					for(SqlRow gtdpt : listConcepto){
						if(!conceptosAdicional.containsKey(gtdpt.getString("concepto"))){
							conceptosAdicional.put(gtdpt.getString("concepto"), lx);
							lx = lx+3;
						}
					}

					if(fr.containsKey("produccion")){
						HashMap<String, List<SqlRow>> gtmp = fr.get("produccion");
						gtmp.put(rp.getLong("idPuestoLaboral").toString()+"&&"+rp.getString("nombre"), listConcepto);
						fr.put("produccion", gtmp);
					}else{
						HashMap<String, List<SqlRow>> g = new HashMap<String, List<SqlRow>>();
						g.put(rp.getLong("idPuestoLaboral").toString()+"&&"+rp.getString("nombre"), listConcepto);
						fr.put("produccion", g);
					}

					celda0 = fila.createCell(6);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("adicional").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					listConcepto = PuestoLaboral.getLiquidacionDetallePorTipo(idPeriodo,rp.getLong("idPuestoLaboral"),6);

					lx = 1;
					for(SqlRow gtdpt : listConcepto){
						if(!conceptosAdicional.containsKey(gtdpt.getString("concepto"))){
							conceptosAdicional.put(gtdpt.getString("concepto"), lx);
							lx = lx+3;
						}
					}

					if(fr.containsKey("adicional")){
						HashMap<String, List<SqlRow>> gtmp = fr.get("adicional");
						gtmp.put(rp.getLong("idPuestoLaboral").toString()+"&&"+rp.getString("nombre"), listConcepto);
						fr.put("adicional", gtmp);
					}else{
						HashMap<String, List<SqlRow>> g = new HashMap<String, List<SqlRow>>();
						g.put(rp.getLong("idPuestoLaboral").toString()+"&&"+rp.getString("nombre"), listConcepto);
						fr.put("adicional", g);
					}

					celda0 = fila.createCell(7);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("descuentos").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(8);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("neto").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}
			}

			int z=0;
			hoja = libro.createSheet(titulo+"Anexo");



			for (Entry<String, HashMap<String, List<SqlRow>>> e: fr.entrySet()) {
				HashMap<String, Integer> cc = new HashMap<String, Integer>();
				if(e.getKey().compareTo("guardias") == 0 ){
					cc = conceptosGuardias;
				}else if(e.getKey().compareTo("produccion") == 0 ){
					cc = conceptosProduccion;
				}else if(e.getKey().compareTo("adicional") == 0 ){
					cc = conceptosAdicional;
				}

				fila = hoja.createRow(z);
				celda0 = fila.createCell(0);
				celda0.setCellValue(e.getKey());
				celda0.setCellStyle(comun);

				for (Entry<String, Integer> cg: cc.entrySet()) {
					celda0 = fila.createCell(cg.getValue());
					celda0.setCellValue(cg.getKey());
					celda0.setCellStyle(comun);
				}

				z++;

				for (Entry<String, List<SqlRow>> tt: e.getValue().entrySet()) {

					fila = hoja.createRow(z);
					celda0 = fila.createCell(0);
					String[] ff = tt.getKey().split("&&");

					for(String x2 : ff){
						Logger.debug("--------------------------"+x2);
					}



					celda0.setCellValue(ff[1]);
					celda0.setCellStyle(comun);

					for(SqlRow ll : tt.getValue() ){

						if(cc.containsKey(ll.getString("concepto"))){
							Integer xt = cc.get(ll.getString("concepto"));
							celda0 = fila.createCell(xt);
							celda0.setCellValue(ll.getBigDecimal("cantidad").doubleValue());
							celda0.setCellStyle(comun);
							xt++;
							celda0 = fila.createCell(xt);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(ll.getBigDecimal("importe").doubleValue());
							celda0.setCellStyle(estiloMoneda);
							xt++;
							celda0 = fila.createCell(xt);
							celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
							celda0.setCellValue(ll.getBigDecimal("importe").multiply(ll.getBigDecimal("cantidad")).doubleValue());
							celda0.setCellStyle(estiloMoneda);
						}
					}
					z++;
				}z++;
			}
			x++;
		}
		return x;
	}

	public static int getListadoLiquidacionesPorEscala(Long idPeriodo,boolean planta,List<SqlRow> row,int x,Cell celda0,Row fila,Sheet hoja,Workbook libro,String titulo){



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

		if(row.size() > 0){

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue(titulo);
			celda0.setCellStyle(comun);

			x++;

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("CANTIDAD");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue("PROFESION");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(2);
			celda0.setCellValue("HABER BRUTO");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(3);
			celda0.setCellValue("GUARDIA");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(4);
			celda0.setCellValue("PRODUCCION");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(5);
			celda0.setCellValue("ADICIONALES");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(6);
			celda0.setCellValue("DESCUENTOS");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(7);
			celda0.setCellValue("NETO");
			celda0.setCellStyle(comun);
			x++;

			HashMap<String, HashMap<String, List<SqlRow>>> fr = new HashMap<String, HashMap<String, List<SqlRow>>>();

			HashMap<String, Integer> conceptosGuardias = new HashMap<String, Integer>();
			HashMap<String, Integer> conceptosAdicional = new HashMap<String, Integer>();
			HashMap<String, Integer> conceptosProduccion = new HashMap<String, Integer>();
			int c =0;
			for(SqlRow rp: row){
				boolean h = true;

				if(planta){
					h = (rp.getInteger("idTipoRelacion").compareTo(3) != 0 && rp.getInteger("idTipoRelacion").compareTo(1) != 0);
				}else{
					h = (rp.getInteger("idTipoRelacion").compareTo(3) == 0 || rp.getInteger("idTipoRelacion").compareTo(1) == 0);
				}

				if(h){
					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(rp.getInteger("cant"));
					celda0.setCellStyle(comun);

					c = c +rp.getInteger("cant");
					celda0 = fila.createCell(1);
					celda0.setCellValue(rp.getString("profesion"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(2);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("haber").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(3);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("guardias").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("produccion").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(5);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("adicional").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(6);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("descuentos").doubleValue());
					celda0.setCellStyle(estiloMoneda);

					celda0 = fila.createCell(7);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(rp.getBigDecimal("neto").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;
				}
			}
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTAL:"+c);
			celda0.setCellStyle(comun);
			x++;

			x++;
		}
		return x;
	}
}
