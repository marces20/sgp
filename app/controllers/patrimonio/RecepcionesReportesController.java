package controllers.patrimonio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import models.OrdenProvision;
import models.Recepcion;
import models.Remito;
import models.RemitoLinea;
import models.Usuario;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import views.html.patrimonio.recepciones.reportes.*;
import controllers.Secured;

@Security.Authenticated(Secured.class)
public class RecepcionesReportesController extends Controller  {
	
	public static Result reporteDatosRecepciones(){
		
		List<Integer> rSeleccionados = getSeleccionados();
		
		if(rSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado recepciones.");
			return ok(modalReporteRecepcion.render(null,null));
		}
		
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		try {
			File archivo = new File(dirTemp+"/listaDatosRecepciones-"+Usuario.getUsuarioSesion()+".xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			
			
			Sheet hoja = libro.createSheet("reporte");
			
			List<Recepcion> re = Recepcion.find.where().in("id", rSeleccionados).findList();
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("N°");
			fila.createCell(1).setCellValue("OP");
			fila.createCell(2).setCellValue("Exp.");
			
			fila.createCell(3).setCellValue("Institucion");
			fila.createCell(4).setCellValue("Fecha Provision");
			fila.createCell(5).setCellValue("Acta");
			fila.createCell(6).setCellValue("Total");
			fila.createCell(7).setCellValue("Pendiente OP");
			fila.createCell(8).setCellValue("Proveedor");
			fila.createCell(9).setCellValue("Fecha");
			fila.createCell(10).setCellValue("Tipo Cuenta");
			fila.createCell(11).setCellValue("Remitos");
			 	 	 	 	 	 	 	 	 	 	
			
			int f = 1; 
			 
			boolean errores = false;
			for (Recepcion x : re) {
				fila = hoja.createRow(f);
				for(int c=0;c<11;c++){
					Cell celda = fila.createCell(c);
					
					switch (c) {
					case 0:
						celda.setCellValue(x.numero);
						break;
					case 1:
						celda.setCellValue(x.ordenProvision.numero);
						break;	
					case 2:
						celda.setCellValue(x.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio());
						break;		
					case 3:
						celda.setCellValue(x.ordenProvision.ordenCompra.deposito.nombre);
						break;		
					case 4:
						celda.setCellValue(DateUtils.formatDate(x.ordenProvision.ordenCompra.fecha_provision));
						break;	
					case 5:
						celda.setCellValue((x.acta != null)?x.acta.numero:"");
						break;	
					case 6:
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda.setCellValue(x.getTotal().doubleValue());
						celda.setCellStyle(estiloMoneda);
						break;	
					case 7:
						celda.setCellType(Cell.CELL_TYPE_NUMERIC);
						celda.setCellValue(x.ordenProvision.getPendiente().doubleValue());
						celda.setCellStyle(estiloMoneda);
						break;	
					case 8:
						celda.setCellValue(x.ordenProvision.ordenCompra.proveedor.nombre);
						break;	
					case 9:
						celda.setCellValue(DateUtils.formatDate(x.create_date));
						break;	
					case 10:
						celda.setCellValue((x.ordenProvision.ordenCompra.tipoCuenta != null)?x.ordenProvision.ordenCompra.tipoCuenta.nombre:"");
						break;	
					case 11:
						celda.setCellValue(x.cantidadRemitos);
						break;	
					default:
						break;
					}
				}	
				f++;
			}
			
			if(errores){
				flash("error", "No se puede crear el archivo.");
				return ok(modalReporteRecepcion.render(null,error));
			}else{
			
				libro.write(archivoTmp);   
				Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
				out.flush();
				out.close();
				 
				flash("success", "El archivo fue creado correctamente.");
				return ok(modalReporteRecepcion.render(archivo.getPath(),null));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug("zzzzzzzzzz "+e);
		}
		
		return ok();
	}
	
	public static Result reporteLineasRecepciones(){
		
		List<Integer> rSeleccionados = getSeleccionados();
		
		if(rSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado recepciones.");
			return ok(modalReporteRecepcion.render(null,null));
		}
		
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		String error = "";
		Boolean hayError = false;
		
		try {
			File archivo = new File(dirTemp+"/listaRecepciones-"+Usuario.getUsuarioSesion()+".xls");
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			
			CellStyle estiloMoneda = libro.createCellStyle();
			estiloMoneda.setDataFormat((short) 7);
			
			
			Sheet hoja = libro.createSheet("reporte");
			
			List<RemitoLinea> re = RemitoLinea.find.where().in("remito.recepcion_id", rSeleccionados).findList();
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("ID-PRODUCTO-RISMI");
			fila.createCell(1).setCellValue("CANTIDAD");
			fila.createCell(2).setCellValue("PRECIO");
			
			int f = 1; 
			Logger.debug("0000000 "+re.size()); 
			boolean errores = false;
			for (RemitoLinea x : re) {
				Logger.debug("1111111111 "+x.linea_orden_id);
				if(x.lineaOrden.producto.codigo_rismi != null){
					Logger.debug("222222222 "+x.linea_orden_id);
					fila = hoja.createRow(f);
					for(int c=0;c<4;c++){
						Cell celda = fila.createCell(c);
						
						switch (c) {
						case 0:
							celda.setCellValue(x.lineaOrden.producto.codigo_rismi);
							break;
						case 1:
							celda.setCellValue(x.cantidad.doubleValue());
							break;	
						case 2:
							celda.setCellValue(x.lineaOrden.precio.doubleValue());
							break;	
						default:
							break;
						}
					}	
					f++;
				}else{
					errores = true;
					error += "<p class='responseError'>-Este producto "+x.lineaOrden.producto.nombre+" no tiene IDRISMI asociado </p>";
				}
				 
				
			}
			
			if(errores){
				flash("error", "No se puede crear el archivo.");
				return ok(modalReporteRecepcion.render(null,error));
			}else{
			
				libro.write(archivoTmp);   
				Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
				out.flush();
				out.close();
				 
				flash("success", "El archivo fue creado correctamente.");
				return ok(modalReporteRecepcion.render(archivo.getPath(),null));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug("zzzzzzzzzz "+e);
		}
		
		return ok();
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
