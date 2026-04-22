package controllers.dashboard;

import static play.data.Form.form;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;


import models.Usuario;
import models.rismi.RismiFactura;
import models.rismi.RismiFacturaDetalle;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import utils.DateUtils;
import utils.RequestVar;
import utils.UriTrack;
import views.html.compras.solicitudes.modales.modalImportarListaProductosCantidades;
import views.html.dashboard.rismi.*;
import views.html.dashboard.rismi.rismiFactura.*;
import views.html.recupero.recuperoFactura.verRecuperoFactura;

public class FacturacionRismiController  extends Controller {

	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexRismiFactura.render(
				RismiFactura.page(RequestVar.get("nombre")),d));
	}

	public static Result ver(Long id) {
		RismiFactura p = RismiFactura.find.byId(id);

		if(p != null){
			Form<RismiFactura> rismiFacturaForm = form(RismiFactura.class).fill(p);
			return ok(verRismiFactura.render(rismiFacturaForm, p));
		}else{
			flash("error", "No se encuentra la factura.");
			return redirect(controllers.dashboard.routes.FacturacionRismiController.index()+UriTrack.get("?"));
		}
	}

	public static Result modalImportarFacturas() {
		return ok(modalImportarFacturas.render(form().bindFromRequest()));
	}

	public static Result importarFacturas() throws IOException{
		Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		String error = "";
		Boolean lineasValidas = true;
		String ok = "";

		MultipartFormData body = request().body().asMultipartFormData();
		FilePart upload = body.getFile("myfile");

		Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		try{


					Ebean.beginTransaction();



					if (upload != null) {
						//String fileName = upload.getFilename();
						//String contentType = upload.getContentType();
					    File file = upload.getFile();

					    FileInputStream input = new FileInputStream(file.getAbsolutePath());
						POIFSFileSystem fs = new POIFSFileSystem(input);
						HSSFWorkbook wb = new HSSFWorkbook(fs);
						HSSFSheet sheet = wb.getSheetAt(0);
						Row row;
						int cantidadDeRowProcesadas = 0;


						for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				            row = sheet.getRow(i);



						    Integer IDEPISODIO = (int) row.getCell(0).getNumericCellValue();// row.getCell(0).getStringCellValue();//IDEPISODIO
						    Integer IDPACIENTE =   (int) row.getCell(1).getNumericCellValue(); //row.getCell(1).getStringCellValue();//IDPACIENTE
							String NOMBREPACIENTE = row.getCell(2).getStringCellValue();//NOMBREPACIENTE
							String FECHAINGRESO = row.getCell(3).getStringCellValue();//FECHAINGRESO
							String FECHAEGRESO = row.getCell(4).getStringCellValue();//FECHAEGRESO

							String DOMINIO = row.getCell(5).getStringCellValue();//DOMINIO

							Double totalPrestaciones = row.getCell(6).getNumericCellValue();
							Double totalFarmacos = row.getCell(7).getNumericCellValue();
							Double totalCama = row.getCell(8).getNumericCellValue();
							Double totalTotal = row.getCell(9).getNumericCellValue();


							String ff = FECHAEGRESO;
							Date fechaEgreso = DateUtils.formatDate(ff, "dd/MM/yyyy");

							String ff2 = FECHAINGRESO;
							Date fechaIngreso = DateUtils.formatDate(ff2, "dd/MM/yyyy");



							Long proximaSec = Ebean.createSqlQuery("SELECT nextval('rismi_facturas_id_seq') id").findUnique().getLong("id");
							RismiFactura rf = new RismiFactura();
							rf.id = proximaSec;
							rf.dominio = DOMINIO;
							rf.episodio_id = IDEPISODIO.toString();
							rf.fecha_egreso =fechaEgreso;
							rf.fecha_ingreso = fechaIngreso;
							rf.nombre_paciente = NOMBREPACIENTE;
							rf.paciente_id =IDPACIENTE.toString();
							rf.total_total = new BigDecimal(totalTotal).setScale(2, BigDecimal.ROUND_HALF_UP);
							rf.save();

							RismiFacturaDetalle rdf = new RismiFacturaDetalle();
							rdf.monto = new BigDecimal(totalPrestaciones).setScale(2, BigDecimal.ROUND_HALF_UP);
							rdf.producto = "Total Prestaciones";
							rdf.rismi_factura_id  = proximaSec;
							rdf.save();

							RismiFacturaDetalle rdf2 = new RismiFacturaDetalle();
							rdf2.monto = new BigDecimal(totalFarmacos).setScale(2, BigDecimal.ROUND_HALF_UP);
							rdf2.producto = "Total Fármacos";
							rdf2.rismi_factura_id  = proximaSec;
							rdf2.save();

							RismiFacturaDetalle rdf3 = new RismiFacturaDetalle();
							rdf3.monto = new BigDecimal(totalCama).setScale(2, BigDecimal.ROUND_HALF_UP);
							rdf3.producto = "Total Días Cama";
							rdf3.rismi_factura_id  = proximaSec;
							rdf3.save();

				            String insert = "INSERT INTO rismi_facturas(nombre_paciente,dominio,fecha_ingreso,fecha_egreso,episodio_id,paciente_id) VALUES " +
					           		"('"+NOMBREPACIENTE+"','"+DOMINIO+"',"+FECHAINGRESO+","+FECHAEGRESO+","+IDEPISODIO+","+IDPACIENTE+");";

				            cantidadDeRowProcesadas ++;
						}

						ok += "<p class='responseOk'>- Se ha procesado correctamente el archivo. Se procesaron "+cantidadDeRowProcesadas+" lineas.</p>";

					} else {
						error += "<p class='responseError'>- No se encuentra el archivo a procesar.</p>";
					}
					Ebean.commitTransaction();
		}catch(Exception e){
			Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx21 "+e);
			  flash("error", "No se pudo crear las facturas " + e);
		      Ebean.rollbackTransaction();
		}finally {
		      Ebean.endTransaction();
	    }

		String ret = error+ok;
		return ok(ret);
	}


	public static Result datosMensualesResumenGeneral() {

		return ok( facturacion.render() );
	}
}
