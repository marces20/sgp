package controllers.contabilidad;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import models.Certificacion;
import models.Ejercicio;
import models.Estado;
import models.Expediente;
import models.Orden;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import controllers.Secured;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

@Security.Authenticated(Secured.class)
public class ResiduoPasivoController extends Controller  {
	
	/*public static Result reporteResiduoPasivo(Long idEjercicio) {
		
		String error = "";
		Boolean hayError = false;
		String dirTemp = System.getProperty("java.io.tmpdir");
		Ejercicio ej = Ejercicio.find.byId(idEjercicio);
		File archivo = new File(dirTemp+"/Residuo Pasivo - "+ej.nombre+".xls");	
		
		try {
			
			
			
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			
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
			
			Sheet hoja = libro.createSheet("Residuo Pasivo - "+ej.nombre);
			
			List<Orden> o = Orden.find.where()
					.eq("expediente.ejercicio.id", ej.id)
					.eq("state_id", Estado.ORDEN_ESTADO_APROBADO)
					//.eq("expediente_id", 1630)
					.orderBy("expediente.nombre").findList(); 
			
			int x = 0;
			Row fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("Datos");
			celda0.setCellStyle(comun);
			x++;
			
			for(Orden ol : o){
				fila = hoja.createRow(x);
				
				Expediente eHijo = Expediente.find.where().eq("parent_id", new Long(ol.expediente_id)).findUnique();
				
				BigDecimal vf  = new BigDecimal(0);
				List<SqlRow> valor_factura;
				String sqlProveedor = (ol.proveedor_id != 1387)?" AND f.proveedor_id = "+ol.proveedor_id :""; 
				String sqlExp ="(f.expediente_id = "+ol.expediente_id+") ";
				
				if(eHijo != null){
					sqlExp ="(f.expediente_id = "+ol.expediente_id+" or f.expediente_id = "+eHijo.id+") "; 
				}
				BigDecimal vp  = new BigDecimal(0);
				if(ol.proveedor_id != 1387){
					
					String sql = "SELECT f.proveedor_id, f.id id, SUM((fl.cantidad*fl.precio) ) total "+ 
								 "FROM facturas f "+ 
								 "INNER JOIN factura_lineas fl ON f.id = fl.factura_id "+ 
								 // "INNER JOIN estados e ON e.id = f.state_id	"+ 
								 "WHERE "+ 
								 sqlExp +
								 sqlProveedor+
								 " AND state_id = 19 "+ 
								 "GROUP BY f.proveedor_id,f.id "; 
					
					valor_factura = Ebean.createSqlQuery(sql)
							//.setParameter("e1", ol.expediente_id)
							//.setParameter("e2", eHijo.id)
							//.setParameter("idP", ol.proveedor_id)
							.findList();
					
					if(valor_factura != null){
						//vf  = valor_factura.getBigDecimal("total");
					}
						
					SqlRow valor_factura2;
					
					
					for(SqlRow sx : valor_factura){
						
						String sql2 = "SELECT  SUM(fl.monto) total "+ 
								 "FROM pagos f "+ 
								 "INNER JOIN pagos_lineas fl ON f.id = fl.pago_id "+ 
								 //"INNER JOIN estados e ON e.id = f.state_id	"+ 
								 "WHERE "+ 
								 " f.factura_id = :idP " +
								 sqlProveedor+
								 //"AND f.proveedor_id = :idP " +
								 "AND (state_id = 23 or state_id = 25 or state_id = 27) ";
								 //"GROUP BY f.proveedor_id "; 
					
						valor_factura2 = Ebean.createSqlQuery(sql2)
								//.setParameter("e1", ol.expediente_id)
								//.setParameter("e2", eHijo.id)
								.setParameter("idP", sx.getInteger("id"))
								.findUnique();
						
						if(valor_factura2.getBigDecimal("total") != null){
							BigDecimal vpt  = vp.add(valor_factura2.getBigDecimal("total"));
							vp = vpt;
						}
					}
				}else{
					BigDecimal vp2  = new BigDecimal(0);
					String sql2 = "SELECT SUM((fl.monto) ) total "+ 
							 "FROM pagos f "+ 
							 "INNER JOIN pagos_lineas fl ON f.id = fl.pago_id "+ 
							 //"INNER JOIN estados e ON e.id = f.state_id	"+ 
							 "WHERE "+ 
							 sqlExp +
							 //"AND f.proveedor_id = :idP " +
							 "AND (state_id = 23 or state_id = 25 or state_id = 27) ";
							 //"GROUP BY f.expediente_id "; 
					
					SqlRow valor_factura2 = Ebean.createSqlQuery(sql2)
							//.setParameter("e1", ol.expediente_id)
							//.setParameter("idP", ol.proveedor_id)
							.findUnique();
					
					if(valor_factura2.getBigDecimal("total") != null){
						vp  = valor_factura2.getBigDecimal("total");
					}
				}
			*/	
				/*BigDecimal vp  = new BigDecimal(0);
				if(eHijo != null){
					String sql = "SELECT f.proveedor_id , SUM((fl.monto) ) total "+ 
								 "FROM pagos f "+ 
								 "INNER JOIN pagos_lineas fl ON f.id = fl.pago_id "+ 
								 //"INNER JOIN estados e ON e.id = f.state_id	"+ 
								 "WHERE "+ 
								 "(f.expediente_id = :e1 or f.expediente_id = :e2) " +
								 "AND f.proveedor_id = :idP AND (state_id = 23 or state_id = 25 or state_id = 27) "+ 
								 "GROUP BY f.proveedor_id "; 
					
					SqlRow valor_factura = Ebean.createSqlQuery(sql)
							.setParameter("e1", ol.expediente_id)
							.setParameter("e2", eHijo.id)
							.setParameter("idP", ol.proveedor_id)
							.findUnique();
					
					if(valor_factura != null){
						vp  = valor_factura.getBigDecimal("total");
					}
				}else{
					String sql2 = "SELECT f.proveedor_id , SUM((fl.monto) ) total "+ 
							 "FROM pagos f "+ 
							 "INNER JOIN pagos_lineas fl ON f.id = fl.pago_id "+ 
							 //"INNER JOIN estados e ON e.id = f.state_id	"+ 
							 "WHERE "+ 
							 "(f.expediente_id = :e1) " +
							 "AND f.proveedor_id = :idP AND (state_id = 23 or state_id = 25 or state_id = 27) "+ 
							 "GROUP BY f.proveedor_id "; 
					
					SqlRow valor_factura2 = Ebean.createSqlQuery(sql2)
							.setParameter("e1", ol.expediente_id)
							.setParameter("idP", ol.proveedor_id)
							.findUnique();
					
					if(valor_factura2 != null){
						vp  = valor_factura2.getBigDecimal("total");
					}
					
					Logger.debug("xxxxxxxxxxxxxxxx "+vp);
				}*/
				
			/*	
				BigDecimal p1 = ol.getTotalTotal().subtract(vp); 
				
				 
				
				if(p1.compareTo(new BigDecimal(0) )!= 0){
				
					celda0 = fila.createCell(0);
					celda0.setCellValue(ol.expediente.getExpedienteEjercicio());
					celda0.setCellStyle(comun);
					
					
					celda0 = fila.createCell(1);
					String provee = ol.proveedor.nombre;
					if(ol.proveedor_id == 1387){
						List<Certificacion> cl = Certificacion.find.where().eq("expediente_id",ol.expediente_id).findList();
						if(cl.size() > 0){
							provee = ol.expediente.descripcion;
						}
					}
					celda0.setCellValue(provee);
					celda0.setCellStyle(comun);
					
					celda0 = fila.createCell(2);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(ol.getTotalTotal().doubleValue());
					celda0.setCellStyle(estiloMoneda);
					
					celda0 = fila.createCell(3);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(vp.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					
					celda0 = fila.createCell(4);
					celda0.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda0.setCellValue(p1.doubleValue());
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
		
	}*/
}
