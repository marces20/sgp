package controllers.contabilidad;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import models.Estado;
import models.Pago;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import utils.NumberUtils;
import views.html.contabilidad.conciliacionPagos.*;
import views.html.patrimonio.actaRecepcion.modales.modalAsignarActaRecepcion;

public class ConciliacionPagosController extends Controller {
	
	public static Result index() {
		
		return ok( index.render() );
	}
	
	public static Result analisisConciliacionCheques() {
		
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart upload = body.getFile("archivo");
		List<HashMap<String, Object>> lista = new ArrayList<HashMap<String, Object>>();
		List<Integer> conciliar = new ArrayList<Integer>();
		
		
		if(upload == null) {
			flash("error", "Debe subir un archivo.");
			return redirect(request().getHeader("referer"));
		}	
		
	    File file = upload.getFile();
	    
	    try{
		    FileInputStream input = new FileInputStream(file.getAbsolutePath());
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Row row;

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Integer referencia = null;
				Integer codigo = null;
				BigDecimal debito = null;
				row = sheet.getRow(i);
				
				
				if(HSSFCell.CELL_TYPE_NUMERIC != row.getCell(1).getCellType()) {
					flash("error", "La columna \"referencia\" debe ser numérica.");
					return redirect(request().getHeader("referer"));
				}
				
				try {
					if(HSSFCell.CELL_TYPE_NUMERIC != row.getCell(2).getCellType()) {
						flash("error", "La columna \"código\" debe ser numérica.");
						return redirect(request().getHeader("referer"));
					}
				} catch (Exception e) {}

				Double c = row.getCell(2).getNumericCellValue();
				codigo = c.intValue();
				System.out.println(codigo);
				if (codigo != 85) {
					continue;
				}
				
				try {
					if(HSSFCell.CELL_TYPE_STRING != row.getCell(4).getCellType()) {
						flash("error", "La columna \"débito\" debe ser de texto.");
						return redirect(request().getHeader("referer"));
					}
				} catch (Exception e) {}


				
				String fecha = "";
				
				Double r = row.getCell(1).getNumericCellValue();
				referencia = r.intValue();

				DecimalFormat nf = (DecimalFormat)NumberFormat.getInstance(new Locale("en","US"));
				debito = new BigDecimal( nf.parse(row.getCell(4).getStringCellValue()).toString() );

				Pago pago = Pago.find.where().eq("referencia", referencia.toString()).findUnique();
				
				if (pago == null) {
					flash("error", "La referencia "+referencia+" no existe en el sistema.");
					return redirect(request().getHeader("referer"));
				}

				
				if(pago.total.compareTo(debito) != 0) {		
					List<String> msg = new ArrayList<String>();
					HashMap<String, Object> m = new HashMap<String, Object>();
					m.put("referencia", referencia);
					m.put("debito", utils.NumberUtils.moneda(debito));
					m.put("total", utils.NumberUtils.moneda(pago.total));
					m.put("fecha", fecha);
					m.put("mensajes", "No coincide el total con el pago.");
					lista.add(m);
				}

				conciliar.add(referencia);

				
			}
			
	    } catch (Exception e) {

			flash("error", "Ocurrió un error al procesar el archivo: \"" + e.getMessage() + "\"." + e.getStackTrace());
			return redirect(request().getHeader("referer"));
	    	
	    }
		
		
		return ok(analisisConciliacionCheques.render(lista, conciliar));
	}
	
	public static Result conciliarCheques() {
		
		String[] data = request().body().asFormUrlEncoded().get("referencia");
			
			try {
				SqlUpdate update = Ebean.createSqlUpdate("UPDATE pagos SET state_id = "+Estado.PAGO_ESTADO_CONCILIADO+" WHERE referencia IN (:referencias)");

				update.setParameter("referencias", Arrays.asList(data));
				Integer c = update.execute();
				
				flash("success", "Operación finalizada correctamente. Se han conciliado "+c+" pagos.");
				
			} catch (Exception e) {
				flash("error", "No se han podido conciliar los pagos.");
			}

			return redirect(controllers.contabilidad.routes.ConciliacionPagosController.index());
		
	}
	
}
