package controllers.contabilidad;

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
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.BalancePresupuestario;
import models.Certificacion;
import models.Ejercicio;
import models.Estado;
import models.Factura;
import models.FacturaDato;
import models.FacturaLinea;
import models.FacturaMotivoRechazo;
import models.FacturaRechazo;
import models.Orden;
import models.Orden349;
import models.OrdenPago;
import models.Pago;
import models.Periodo;
import models.Producto;
import models.Proveedor;
import models.Usuario;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import utils.DateUtils;
import views.html.compras.certificaciones.modales.modalDetalleCertificacionesPorEstadoPorPeriodo;
import views.html.compras.certificaciones.modales.modalPasarCertificado;
import views.html.contabilidad.facturas.editarFacturaProveedor;
import views.html.contabilidad.facturas.acciones.*;

@Security.Authenticated(Secured.class)
public class FacturasAccionesController  extends Controller {
	
	@CheckPermiso(key = "cargar349")
	public static Result modalCargar349(Long id) {
		return ok(modalCargar349.render(form().bindFromRequest(),id));
	}
	
	@CheckPermiso(key = "cargar349")
	public static Result cargar349() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		
		Long id = new Long(request().body().asFormUrlEncoded().get("id")[0]);
		Factura f = Factura.find.byId(id);
		
		if(f == null) {
			flash("error", "No se encuentra la factura.");
			return ok(modalCargar349.render(form().bindFromRequest(),id));
		}
		
		Date fecha_349 = null;
		
		if(request().body().asFormUrlEncoded().get("fecha_349")[0] != null && !request().body().asFormUrlEncoded().get("fecha_349")[0].isEmpty()) {
			fecha_349 = DateUtils.formatDate(request().body().asFormUrlEncoded().get("fecha_349")[0], "dd/MM/yyyy");
		}else {
			flash("error", "Debe ingresar una fecha");
			return ok(modalCargar349.render(form().bindFromRequest(),id));
		}
		
		String nui = "";
		if(request().body().asFormUrlEncoded().get("nui")[0] != null && !request().body().asFormUrlEncoded().get("nui")[0].isEmpty()) {
			nui =request().body().asFormUrlEncoded().get("nui")[0];
		}else {
			flash("error", "Debe ingresar un NUI");
			return ok(modalCargar349.render(form().bindFromRequest(),id));
		}
		
		
		ObjectNode result = Json.newObject();
		try {			
			 
			
			Orden349 fd = new Orden349();
			fd.nui = nui;
			fd.fecha_vencimiento = fecha_349;
			fd.orden_id = (f.orden_id != null)?f.orden_id.longValue():null;
			fd.create_date = new Date();
			fd.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			fd.save();
			
			result.put("success", true);
			flash("success", "Se actualizado el 349");
			result.put("html",modalCargar349.render(form().bindFromRequest(),id).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCargar349.render(form().bindFromRequest(),id));
		}
	}
	
	public static Result modalImportarListaComisiones() {
		return ok(modalImportarListaComisiones.render(form().bindFromRequest()));
	}
	
	public static Result importarListaComisiones() throws IOException{
		
		String error = "";
		Boolean lineasValidas = true;
		String ok = "";
		String nombreProducto = "";
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart upload = body.getFile("myfile");
		Long idFactura = new Long(request().body().asMultipartFormData().asFormUrlEncoded().get("idFac")[0]);
		try{
			if(idFactura != null){
				Factura f = Factura.find.byId(idFactura);
				
				if (upload != null) {
					
					File file = upload.getFile();
				    FileInputStream input = new FileInputStream(file.getAbsolutePath());
					POIFSFileSystem fs = new POIFSFileSystem(input);
					HSSFWorkbook wb = new HSSFWorkbook(fs);
					HSSFSheet sheet = wb.getSheetAt(0);
					Row row;
					int cantidadDeRowProcesadas = 0;
					
					Map<Integer,Date> mapDates = new HashMap<Integer,Date>();
					Map<Integer,Date> mapDatesOp = new HashMap<Integer,Date>();
					Map<Integer,Long> mapProducto1 = new HashMap<Integer,Long>();
					Map<Integer,BigDecimal> mapPrecio1 = new HashMap<Integer,BigDecimal>();
					Map<Integer,Long> mapProducto2 = new HashMap<Integer,Long>();
					Map<Integer,BigDecimal> mapPrecio2 = new HashMap<Integer,BigDecimal>();
					Map<Integer,Long> mapOp = new HashMap<Integer,Long>();
					 
					for (int i = 1; i <= sheet.getLastRowNum(); i++) {
						row = sheet.getRow(i);
						if(row.getCell(0) != null){
							Logger.debug("OP:"+row.getCell(0).getStringCellValue());
							Logger.debug("fecha:"+row.getCell(1).getDateCellValue());
							Logger.debug("Producto1:"+row.getCell(2).getStringCellValue());
							Logger.debug("monto1:"+row.getCell(3).getNumericCellValue());
							Logger.debug("Producto2:"+row.getCell(4).getStringCellValue());
							Logger.debug("monto2:"+row.getCell(5).getNumericCellValue());
							
							int num_emp = i;
							
							if(row.getCell(1).getDateCellValue() == null) {
								error += "<p class='responseError'>- No se puede leer la fecha en la linea "+i+"</p>";
								lineasValidas = false;
							}else {
								mapDates.put(i, row.getCell(1).getDateCellValue());
							}
							
							if(row.getCell(6).getDateCellValue() == null) {
								error += "<p class='responseError'>- No se puede leer la fecha de OP en la linea "+i+"</p>";
								lineasValidas = false;
							}else {
								mapDatesOp.put(i, row.getCell(6).getDateCellValue());
							}
							
							if(row.getCell(2).getStringCellValue() == null || row.getCell(2).getStringCellValue().isEmpty()) {
								error += "<p class='responseError'>- No se puede leer producto 1 en la linea "+i+"</p>";
								lineasValidas = false;
							}else{
								String pr1 = row.getCell(2).getStringCellValue();
								List<Producto> p1 = Producto.find.where().eq("nombre",pr1).findList();
								if(p1.size() == 0) {
									error += "<p class='responseError'>- No se encuentra producto 1 de la linea "+i+"</p>";
									lineasValidas = false;
								}else {
									mapProducto1.put(i, p1.get(0).id);
									nombreProducto = p1.get(0).nombre;
								}
							}
								
							
							if(row.getCell(4).getStringCellValue()  == null || row.getCell(4).getStringCellValue().isEmpty()) {
								error += "<p class='responseError'>- No se puede leer el producto 2 en la linea "+i+"</p>";
								lineasValidas = false;
							}else {
								String pr2 = row.getCell(4).getStringCellValue();
								List<Producto> p2 = Producto.find.where().eq("nombre",pr2).findList();
								if(p2.size() == 0) {
									error += "<p class='responseError'>- No se encuentra producto 2 de la linea "+i+"</p>";
									lineasValidas = false;
								}else {
									mapProducto2.put(i, p2.get(0).id);
								}
							}
							
							
							OrdenPago op = null;
							
							if(row.getCell(0).getStringCellValue().isEmpty()) {
								error += "<p class='responseError'>- No se encuentra la OP de la linea "+i+"</p>";
								lineasValidas = false;
							}else {
							
								String opstr = row.getCell(0).getStringCellValue();
								String[] oparray = opstr.split("/");
								
								Ejercicio e = Ejercicio.find.where().eq("nombre","20"+oparray[1]).findUnique();
								op = OrdenPago.find.where().eq("numero",new Integer(oparray[0])).eq("ejercicio_id",e.id).findUnique();
								if(op == null) {
									error += "<p class='responseError'>- No se encuentra OP de la linea "+i+"</p>";
									lineasValidas = false;
								}else {
									mapOp.put(i, op.id);
								}
							}
							
							
							BigDecimal precio1 = new BigDecimal(row.getCell(3).getNumericCellValue());
							mapPrecio1.put(i, precio1.setScale(2, RoundingMode.HALF_UP));
							BigDecimal precio2 = new BigDecimal(row.getCell(5).getNumericCellValue());
							mapPrecio2.put(i, precio2.setScale(2, RoundingMode.HALF_UP));
						}	
					}		 
						
					if(lineasValidas) {
						for (int z = 1; z <= sheet.getLastRowNum(); z++) {		
							
							
							
							Long idFacturaParcializada = new Factura().crear_factura_parcial(f.id);
							
							Factura facturaParcializada = Factura.find.byId(idFacturaParcializada);
							facturaParcializada.orden_pago_id = mapOp.get(z);
							facturaParcializada.fecha_factura = mapDates.get(z);
							facturaParcializada.fecha_orden_pago = mapDatesOp.get(z);
							facturaParcializada.debito_automatico = true;
							facturaParcializada.referencia = "FAC"+facturaParcializada.id.toString()+"-"+nombreProducto;
							facturaParcializada.periodo_id = Periodo.getPeriodoByDate(mapDates.get(z)).id.intValue();
							facturaParcializada.save();
							
							Long cuentaAnaliticaId = null;
							List<FacturaLinea> lfl = FacturaLinea.find.where().eq("factura_id", facturaParcializada.id).findList();
							for(FacturaLinea flx : lfl) {
								cuentaAnaliticaId = flx.cuenta_analitica_id;
								flx.delete();
							}
							
							
							
							FacturaLinea fl1 = new FacturaLinea();
							fl1.udm_id= (long)1;
							fl1.cuenta_id = (long)255;
							fl1.factura_id = facturaParcializada.id;
							fl1.precio = mapPrecio1.get(z);
							fl1.cuenta_analitica_id = cuentaAnaliticaId;
							fl1.cantidad = new BigDecimal(1);
							fl1.producto_id = mapProducto1.get(z);
							fl1.cuenta_analitica_original_id = cuentaAnaliticaId;
							fl1.save();
							
							FacturaLinea fl2 = new FacturaLinea();
							fl2.udm_id= (long)1;
							fl2.cuenta_id = (long)255;
							fl2.factura_id = facturaParcializada.id;
							fl2.precio = mapPrecio2.get(z);
							fl2.cuenta_analitica_id = cuentaAnaliticaId;
							fl2.cantidad = new BigDecimal(1);
							fl2.producto_id = mapProducto2.get(z);
							fl2.cuenta_analitica_original_id = cuentaAnaliticaId;
							fl2.save();
							
							 
							
							Logger.debug("------------------------------------------------");
							cantidadDeRowProcesadas ++; 
								
						}
					}else {
						Logger.debug("----LINEA INVALIDAS");
					}
					
					if(lineasValidas){
						ok += "<p class='responseOk'>- Se ha procesado correctamente el archivo. Se procesaron "+cantidadDeRowProcesadas+" lineas.</p>";
					}
				}else {
					error += "<p class='responseError'>- No se puede procesar el archivo.</p>";
				}
			}	
			
		}catch(Exception e){
			play.Logger.error("excepcion", e);
			error += "<p class='responseError'>ERROR "+e+"</p>";
		}
			
		String ret = error+ok;
		return ok(ret);
	}
	
	
	@CheckPermiso(key = "facturasSolicitud322")
	public static Result solicitud322() {
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado facturas.");
			return ok(reporte322.render(null));
		}
		
		Integer soloContratados = Factura.find.fetch("proveedor")
									.fetch("proveedor.agente")
									.where()
									.eq("proveedor.agente.planta", false)
									//.isNull("proveedor.agente_id")
									//.ne("proveedor.id", 13694)//GONZALES MIGUEL IGNACIO 
									.in("id", facturasSeleccionados).findRowCount();
		
		if(soloContratados != facturasSeleccionados.size()) {
			flash("error", "Las solicitudes 322 deben ser solamente para proveedores contratados.");
			return ok(reporte322.render(null));
		}
		
		BigDecimal mayor = new BigDecimal(999.999);
		List<Factura> facturas = Factura.find.fetch("proveedor")
				.fetch("expediente")
				.fetch("expediente.ejercicio")
				.where().in("id", facturasSeleccionados).ge("base",mayor).orderBy("proveedor.nombre").findList();

		String newLine = System.getProperty("line.separator");
		String dirTemp = System.getProperty("java.io.tmpdir");

		try {
			File archivo322 = new File(dirTemp+"/solicitud_322.txt");
			//FileOutputStream file322 = new FileOutputStream(archivo322);

			String linea322 = "";
			
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo322), "Cp1252"));

			String textoArchivo = "30712224300@PARQUE DE LA SALUD DE LA PROVINCIA DE MISIONES DR RAMON MADARIAGA";
			out.append(textoArchivo).append("\r\n");
			for (Factura factura : facturas) {
				out.append(crearLinea322(factura)).append("\r\n");
				linea322 += crearLinea322(factura);
				linea322 += "\r\n";
			}
			
			//file322.write(textoArchivo.getBytes());	
	 
			out.flush();
			out.close();
			
			flash("success", "El archivo fue creado correctamente.");
			return ok(reporte322.render(archivo322.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(reporte322.render(null));
	}
	
	public static String crearLinea322(Factura factura) {
		String linea = ""; 
		linea += factura.proveedor.cuit + "@"; //Cuit 
		linea += factura.proveedor.nombre.replace(",", "") + "@"; //Razón ocial 
		linea += "2@"; //Tipo de contratación -  el 2 es expediente
		linea += "6550"+ ((factura.expediente != null)?factura.expediente.nombre:"") + "@";
		linea += ((factura.expediente != null && factura.expediente.ejercicio != null)?factura.expediente.ejercicio.nombre:"") + "@";
		DecimalFormat df = new DecimalFormat("#.##");
		linea += df.format(factura.getBase()).replace(",", ".");
		return linea;
	}
	
	public static Result descargar322(String url){
		return ok(new File(url));
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
	
	
	final static Form<Factura> facturaForm = form(Factura.class);
	
	@CheckPermiso(key = "facturasPasarEstadoPreCurso")
	public static Result modalPasarEnPreCurso() {
		return ok(modalPasarEnPreCurso.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasPasarEstadoPreCurso")
	public static Result pasarEnPreCursoMasivo() {
		
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();

		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalPasarEnPreCurso.render(d));
		}	
		
		if(sinFechaProvision(facturasSeleccionados)){
			flash("error", "No se pueden pasar a precurso porque hay ordenes sin fecha de provisión.");
			return ok(modalPasarEnPreCurso.render(d));
		}
		
		
		if(hayFacturasParcializadas(facturasSeleccionados)){
			flash("error", "No se pueden pasar a borrador facturas Parcializadas.");
			return ok(modalPasarEnPreCurso.render(d));
		}
		
		if(!conDebeJudicial(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que tenga Deudas judiciales.");
			return ok(modalPasarEnPreCurso.render(d));
		}
		
		if(!soloBorrador(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalPasarEnPreCurso.render(d));
		}
		
		if(!soloConOp(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar que tiene asignada una OP");
			return ok(modalPasarEnPreCurso.render(d));
		}
		if(!soloConPeriodo(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar que tiene asignado un Periodo");
			return ok(modalPasarEnPreCurso.render(d));
		}
		
		if(!soloConFechaOp(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar que tiene asignada una Fecha de OP");
			return ok(modalPasarEnPreCurso.render(d));
		}
		
		if(!conExpediente(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
			return ok(modalPasarEnPreCurso.render(d));
		}
		
		if(!conLineas(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan lineas.");
			return ok(modalPasarEnPreCurso.render(d));
		}
		
		
		
		if(d.hasErrors())
			return ok(modalPasarEnPreCurso.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
						 
			List<Factura> lf = Factura.find.where().in("id", facturasSeleccionados).findList();
			FacturaLinea.modificarCuentaAnaliticaPorFactura(lf);
						
			Integer count = Factura.modificarEstadoMasivo(Estado.FACTURA_ESTADO_PRECURSO, facturasSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarEnPreCurso.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarEnPreCurso.render(d));
		}		
	}
	
	@CheckPermiso(key = "facturasPasarEstadoCurso")
	public static Result modalPasarEnCurso() {
		return ok(modalPasarEnCurso.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasPasarEstadoCurso")
	public static Result pasarEnCursoMasivo() {
		
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();

		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalPasarEnCurso.render(d));
		}	
		
		if(hayFacturasParcializadas(facturasSeleccionados)){
			flash("error", "No se pueden pasar a borrador facturas Parcializadas.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(!conDebeJudicial(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que tenga Deudas judiciales.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(!soloPrecurso(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en PreCurso.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(!conExpediente(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		if(!conLineas(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan lineas.");
			return ok(modalPasarEnCurso.render(d));
		}
		
		
		
		if(d.hasErrors())
			return ok(modalPasarEnCurso.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.modificarEstadoMasivo(Estado.FACTURA_ESTADO_ENCURSO, facturasSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarEnCurso.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarEnCurso.render(d));
		}		
	}
	
	@CheckPermiso(key = "facturasPasarEstadoPreAprobado")
	public static Result modalPasarPreAprobado() {
		return ok(modalPasarPreAprobado.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasPasarEstadoPreAprobado")
	public static Result pasarPreAprobadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();
	
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalPasarPreAprobado.render(d));
		}	
		
		if(hayFacturasParcializadas(facturasSeleccionados)){
			flash("error", "No se pueden pasar a preaprobada facturas Parcializadas.");
			return ok(modalPasarPreAprobado.render(d));
		}
		
		if(!soloEnCurso(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en curso.");
			return ok(modalPasarPreAprobado.render(d));
		}
		
		if(!soloConNumero(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan N° Factura.");
			return ok(modalPasarPreAprobado.render(d));
		}
		
		if(!conExpediente(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
			return ok(modalPasarPreAprobado.render(d));
		}
		
		if(!conLineas(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan lineas.");
			return ok(modalPasarPreAprobado.render(d));
		}
		if(!conDeudas(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que tenga Deudas.");
			return ok(modalPasarPreAprobado.render(d));
		}
		if(!conFecha322Vencida(facturasSeleccionados)){
			flash("error", "Solo se puede modificar registros que el proveedor no tengan vencido el 322.");
			return ok(modalPasarPreAprobado.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarPreAprobado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.modificarEstadoMasivo(Estado.FACTURA_ESTADO_PREAPROBADO, facturasSeleccionados);
			Integer deleteMotivosRechazos = FacturaMotivoRechazo.delete(facturasSeleccionados);
			
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarPreAprobado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalPasarPreAprobado.render(d));
		}
	}
	
	@CheckPermiso(key = "facturasPasarEstadoAprobado")
	public static Result modalPasarAprobado() {
		return ok(modalPasarAprobado.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasPasarEstadoAprobado")
	public static Result pasarAprobadoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();
	
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalPasarAprobado.render(d));
		}	
		
		if(hayFacturasParcializadas(facturasSeleccionados)){
			flash("error", "No se pueden pasar a aprobada facturas Parcializadas.");
			return ok(modalPasarAprobado.render(d));
		}
		
		if(!soloPreAprobado(facturasSeleccionados) ) {
			flash("error", "Solo se puede modificar registros en estado preaprobado.");
			return ok(modalPasarAprobado.render(d));
		}
		
		if(!conExpediente(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no tengan expediente asignado.");
			return ok(modalPasarAprobado.render(d));
		}
		
		if(!conLineas(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que no contengan lineas.");
			return ok(modalPasarAprobado.render(d));
		}
		
		if(!conFechaOpVieja(facturasSeleccionados)){
			flash("error", "No se pueden aprobar facturas con fecha de OP menor del ejercicio actual.");
			return ok(modalPasarAprobado.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarAprobado.render(d));	
		
		Factura duplicado = unicoMismoAgenteConPeriodoConExpediente(facturasSeleccionados);
		if(duplicado != null && Usuario.getUsuarioSesion() != 1) {
			flash("error", "Existe una factura con periodo, expediente y agente duplicado. <br /> <b>Proveedor</b>: " + duplicado.proveedor_id + " " + duplicado.proveedor.nombre);
			return ok(modalPasarAprobado.render(d));
		}
		
		//CONTRO CONTRA VALOR DE LA ORDEN
		BigDecimal totalLineas = new BigDecimal(0);
		Map<Integer,BigDecimal> x = new HashMap<Integer,BigDecimal>();
		List<Factura> facturas = Factura.find.where().in("id", facturasSeleccionados).findList();
		for (Factura f : facturas) {
			if(x.containsKey(f.orden_id)) {
				BigDecimal tmp = x.get(f.orden_id);
				tmp = tmp.add(f.getBase());
				
				x.put(f.orden_id, tmp);
			}else {
				x.put(f.orden_id, f.getBase());
			}
		}
		
		for (Map.Entry<Integer,BigDecimal> entry : x.entrySet()) {
			Integer key = entry.getKey();
			BigDecimal value = entry.getValue();
			
			BigDecimal totalLineasF = new BigDecimal(0);
			List<Factura> facturasx = Factura.find.where().eq("orden_id", key).isNotNull("orden_id").eq("state_id", 19).findList(); 
			for (Factura fx : facturasx) {
				totalLineasF = totalLineasF.add(fx.getBase());
			}
			if(key != null) {
				if(totalLineasF.compareTo(value) > 1 ) {
					flash("error", "El monto de las facturas aprobadas no puede ser mayor al monto de la orden de compra.");
					return ok(modalPasarAprobado.render(d));
				}
				
				Date vencimiento349 = Orden349.getLastFecha(key);
				if(vencimiento349 != null) {
					if(utils.DateUtils.compareDate(vencimiento349,new Date()) < 0) {
						flash("error", "No se puede aprobar pq tiene vencido el 349.");
						//return ok(modalPasarAprobado.render(d));
					}
				}
			}
		}
		
		//FINN CONTROL CONTRA VALOR DE LA ORDEN
	   	
		
		
		List<Factura> lf = Factura.find.where().in("id", facturasSeleccionados).findList();
		ArrayNode a = BalancePresupuestario.controlSaldoPreventivoContraFactura(lf); 
		boolean errorControl =  false;
		String aviso = "";
		for(JsonNode o :a){
			
			boolean success = new Boolean(o.get("success").toString());
			String expediente = o.get("expediente").toString();
			BigDecimal saldoPreventivo =  new BigDecimal(o.get("saldoPreventivo").toString());
			BigDecimal saldoAFacturar =  new BigDecimal(o.get("saldoFacturado").toString());
			
			if(!success){
				errorControl =  true;
				aviso += "No Tiene Saldo Preventivo disponible para la facturar el expediente "+expediente+"<br>";
				aviso += "Saldo Preventivo: "+utils.NumberUtils.moneda(saldoPreventivo)+"<br>";
				aviso += "Saldo a Facturar/Facturado: "+utils.NumberUtils.moneda(saldoAFacturar)+"<br><br>";
				 
			}else{
				aviso += "Tiene Saldo Preventivo disponible para la facturar el expediente "+expediente+"<br>";
				aviso += "Saldo Preventivo: "+utils.NumberUtils.moneda(saldoPreventivo)+"<br>";
				aviso += "Saldo a Facturar/Facturado: "+utils.NumberUtils.moneda(saldoAFacturar)+"<br><br>";
			}
		}
		
		
		if(errorControl){
			flash("error", aviso);
			return ok(modalPasarAprobado.render(d));
		}else{
		
			ObjectNode result = Json.newObject();
			try {
				Integer count = Factura.modificarEstadoAndFechaAprobacionMasivo(Estado.FACTURA_ESTADO_APROBADO,new Date(), facturasSeleccionados);
				
				result.put("success", true);
				flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.<br>"+aviso);
				result.put("html", modalPasarAprobado.render(d).toString());
				return ok(result);
			} catch (Exception e){
				flash("error", "No se puede modificar los registros.");
				return ok(modalPasarAprobado.render(d));
			}
		}	 
	}
	
	private static Factura unicoMismoAgenteConPeriodoConExpediente(List<Integer> facturasSeleccionados) {
		for (Integer id : facturasSeleccionados) {
			Factura factura = Factura.find.select("periodo_id, expediente_id, proveedor_id, proveedor.nombre").where()
					.isNotNull("proveedor.agente_id")
					.eq("id", id).findUnique();
			
			
			if(factura != null){
				List<Factura> duplicados = Factura.find.select("id").where()
						.eq("proveedor_id", factura.proveedor_id)
						.eq("periodo_id", factura.periodo_id)
						.eq("expediente_id", factura.expediente_id)
						.ne("estado_id", Estado.FACTURA_ESTADO_CANCELADO)
						.ne("estado_id", Estado.FACTURA_ESTADO_BORRADOR).findList();
				if(duplicados.size() > 1) {
					return factura;
				}
			}
		}
		return null;
	}
	
	
	@CheckPermiso(key = "facturasPasaarBorrador")
	public static Result modalPasarBorrador() {
		return ok(modalPasarBorrador.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasPasaarBorrador")
	public static Result pasarBorradorMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();

		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalPasarBorrador.render(d));
		}	
		
		if(!soloCancelado(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado en cancelado.");
			return ok(modalPasarBorrador.render(d));
		}
		
		if(!soloSinPago(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que esten relacionados con algun pago.");
			return ok(modalPasarBorrador.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarBorrador.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.modificarEstadoMasivo(Estado.FACTURA_ESTADO_BORRADOR, facturasSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarBorrador.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarBorrador.render(d));
		}
		
	}
	
	@CheckPermiso(key = "facturasPasarEstadoCancelado")
	public static Result modalPasarCancelado() {
		return ok(modalPasarCancelado.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasPasarEstadoCancelado")
	public static Result pasarCanceladoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();

		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalPasarCancelado.render(d));
		}	
		
		if(!soloSinPago(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros que esten relacionados con algun pago.");
			return ok(modalPasarCancelado.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalPasarCancelado.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.modificarEstadoMasivo(Estado.FACTURA_ESTADO_CANCELADO, facturasSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalPasarCancelado.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarCancelado.render(d));
		}
		
	}
	
	@CheckPermiso(key = "marcadoresMasivos")
	public static Result modalMarcadoresMasivos() {
		return ok(modalMarcadoresMasivos.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "marcadoresMasivos")
	public static Result marcadoresMasivos() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();
		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalMarcadoresMasivos.render(d));
		}	
		
		String debe_dgr =request().body().asFormUrlEncoded().get("debe_dgr")[0];
		String debe_dgr_aguinaldo = request().body().asFormUrlEncoded().get("debe_dgr_aguinaldo")[0];
		String debe_afip = request().body().asFormUrlEncoded().get("debe_afip")[0];
		String debe_judicial = request().body().asFormUrlEncoded().get("debe_judicial")[0];
		
		if(d.hasErrors())
			return ok(modalMarcadoresMasivos.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.CargarMarcadoresMasivo(facturasSeleccionados,debe_dgr,debe_dgr_aguinaldo,debe_afip,debe_judicial);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalMarcadoresMasivos.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalMarcadoresMasivos.render(d));
		}
		
	}
	
	@CheckPermiso(key = "facturasCargarOrdenPagoMasiva")
	public static Result modalCargarOrdenPago() {
		return ok(modalCargarOrdenPago.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasCargarOrdenPagoMasiva")
	public static Result cargarOrdenPagoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();

		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalCargarOrdenPago.render(d));
		}	
		
		Integer idOrdenPago = null;
		if(!request().body().asFormUrlEncoded().get("orden_pago_id")[0].isEmpty()){
			idOrdenPago = new Integer(request().body().asFormUrlEncoded().get("orden_pago_id")[0]);
		}		
		
		if(!soloBorrador(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalCargarOrdenPago.render(d));
		}
		
		if(idOrdenPago != null){
			//flash("error", "Seleccione una orden de pago.");
			//return ok(modalCargarOrdenPago.render(d));
			
			
			Integer fa = Factura.find.where().eq("orden_pago_id",idOrdenPago).not(Expr.in("id",facturasSeleccionados)).findRowCount();
			
			if(fa > 0){
				flash("error", "Ya existe el numero de orden de pago en otra factura.");
				return ok(modalCargarOrdenPago.render(d));
			}
		}
		
		
		
		
		if(d.hasErrors())
			return ok(modalCargarOrdenPago.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.CargarOrdenPagoMasivo(idOrdenPago, facturasSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalCargarOrdenPago.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCargarOrdenPago.render(d));
		}
		
	}
	
	@CheckPermiso(key = "facturasFecha322Masiva")
	public static Result modalCargarFecha322() {
		return ok(modalCargarFecha322.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasFecha322Masiva")
	public static Result cargarFecha322Masivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();

		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalCargarFecha322.render(d));
		}	
		if(!soloBorrador(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalCargarFecha322.render(d));
		}
		
		Date fecha322 = DateUtils.formatDate(request().body().asFormUrlEncoded().get("fecha_322_modal")[0], "dd/MM/yyyy");
		if(fecha322 == null){
			flash("error", "Seleccione una fecha de 322 .");
			return ok(modalCargarFecha322.render(d));
		}
		
		
		if(d.hasErrors())
			return ok(modalCargarFecha322.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.CargarFecha322Masivo(fecha322, facturasSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalCargarFecha322.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCargarFecha322.render(d));
		}
		
	}
	
	@CheckPermiso(key = "facturasFechaOrdenPagoMasiva")
	public static Result modalCargarFechaOrdenPago() {
		return ok(modalCargarFechaOrdenPago.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasFechaOrdenPagoMasiva")
	public static Result cargarFechaOrdenPagoMasivo() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();

		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalCargarFechaOrdenPago.render(d));
		}	
		if(!soloBorrador(facturasSeleccionados)) {
			flash("error", "Solo se puede modificar registros en estado borrador.");
			return ok(modalCargarFechaOrdenPago.render(d));
		}
		
		Date fechaOrdenPago = DateUtils.formatDate(request().body().asFormUrlEncoded().get("fecha_orden_pago_modal")[0], "dd/MM/yyyy");
		if(fechaOrdenPago == null){
			flash("error", "Seleccione una fecha de orden de pago .");
			return ok(modalCargarFechaOrdenPago.render(d));
		}
		
		
		if(d.hasErrors())
			return ok(modalCargarFechaOrdenPago.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.CargarFechaOrdenPagoMasivo(fechaOrdenPago, facturasSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalCargarFechaOrdenPago.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCargarFechaOrdenPago.render(d));
		}
		
	}
	
	@CheckPermiso(key = "facturasFechaOrdenPagoMasiva")
	public static Result modalCargarNumeroFacturaParcial() {
		return ok(modalCargarNumeroFacturaParcial.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasFechaOrdenPagoMasiva")
	public static Result cargarNumeroFacturaParcial() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> facturasSeleccionados = getSeleccionados();

		if(facturasSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una factura.");
			return ok(modalCargarNumeroFacturaParcial.render(d));
		}	
		if(!soloParciales(facturasSeleccionados)) {
			flash("error", "Solo se pueden modificar facturas parciales");
			return ok(modalCargarNumeroFacturaParcial.render(d));
		}
		
		 
		if(request().body().asFormUrlEncoded().get("nfactura_modal")[0] == null){
			flash("error", "Seleccione un numpero");
			return ok(modalCargarNumeroFacturaParcial.render(d));
		}
		
		
		if(d.hasErrors())
			return ok(modalCargarNumeroFacturaParcial.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Integer count = Factura.CargarNumeroFacturaParciales(request().body().asFormUrlEncoded().get("nfactura_modal")[0], facturasSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ facturasSeleccionados.size() +" seleccionados.");
			result.put("html", modalCargarNumeroFacturaParcial.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalCargarNumeroFacturaParcial.render(d));
		}
		
	}
	
	@CheckPermiso(key = "pagosModificarNumeroFactura")
	public static Result modalModificarNumeroFactura(Long id) {
		
		Factura p = Factura.find.byId(id);
		
		return ok(modalModificarNumeroFactura.render(form().bindFromRequest(),id,p));
	}
	
	@CheckPermiso(key = "pagosModificarNumeroFactura")
	public static Result modificarNumeroFactura() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		String numero_factura =request().body().asFormUrlEncoded().get("numero_factura")[0];
		String monto =request().body().asFormUrlEncoded().get("monto")[0];
		Long id = new Long(request().body().asFormUrlEncoded().get("id")[0]);
		Factura f = Factura.find.byId(id);
		
		if(f.orden_id == null) {
			flash("error", "Esta factura no tiene orden asociada. Ver con el Administrador del sistema.");
			return ok(modalModificarNumeroFactura.render(d,id,f));
		}
		
		if(numero_factura.isEmpty()) {
			flash("error", "Ingrese un N° de Factura");
			return ok(modalModificarNumeroFactura.render(d,id,f));
		}
		
		if(monto.isEmpty()) {
			flash("error", "Ingrese un monto");
			return ok(modalModificarNumeroFactura.render(d,id,f));
		}
		
		
		if(f.factura_principal_id != null && f.facturaPrincipal.numero_factura != null && !f.facturaPrincipal.numero_factura.isEmpty()) {
			
			String nff = f.facturaPrincipal.numero_factura.replace("-","").replace(" ","");
			String nfp =numero_factura.replace("-","").replace(" ","");
			
			if(nff.compareToIgnoreCase(nfp) != 0) {
				flash("error", "El N° de factura Principal cargada no coincide con el N° de factura que se está cargando. N°FACTURA: "+f.facturaPrincipal.numero_factura);
				return ok(modalModificarNumeroFactura.render(d,id,f));
			}

		}
		
		if(Factura.existeNumeroFacturaCargado(f.id, numero_factura)) {
			flash("error", "Ya existe este numero de factura cargado.");
			return ok(modalModificarNumeroFactura.render(d,id,f));
		}
		
		
		BigDecimal montoACargar = new BigDecimal(monto.replace(",","."));
		BigDecimal montoCargado = Factura.getTotalMontoFacturasCargadas(f.id);
		BigDecimal montoTotal = montoCargado.add(montoACargar);
		
		if(montoTotal.compareTo(f.orden.getTotalTotal()) > 0) {
			flash("error", "Los montos de facturas excede el monto de la orden.");
			return ok(modalModificarNumeroFactura.render(d,id,f));
		}
		
		
		ObjectNode result = Json.newObject();
		try {			
			//Integer count = Pago.modificarNumeroFactura(numero_factura, id);
			
			FacturaDato fd = new FacturaDato();
			fd.numero_factura = numero_factura;
			fd.factura_id = f.id;
			fd.orden_id = (f.orden_id != null)?f.orden_id.longValue():null;
			fd.monto = new BigDecimal(monto.replace(",","."));
			fd.create_date = new Date();
			fd.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			fd.save();
			
			
			result.put("success", true);
			flash("success", "Se actualizado el Numero de factura");
			result.put("html", modalModificarNumeroFactura.render(d,id,f).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalModificarNumeroFactura.render(d,id,f));
		}
		
	}
	
	@CheckPermiso(key = "facturasRechazar")
	public static Result modalRechazarFactura() {
		return ok(modalRechazarFactura.render(form().bindFromRequest()));
	}
	
	@CheckPermiso(key = "facturasRechazar")
	public static Result rechazar() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		String[] motivos = request().body().asFormUrlEncoded().get("motivo_rechazo[]");
		String[] otroMotivo = request().body().asFormUrlEncoded().get("otro");
		String[] idFactura = request().body().asFormUrlEncoded().get("idFactura");
		 
		if(motivos == null && otroMotivo[0].isEmpty()){
			flash("error", "Debe seleccionar un motivo de rechazo.");
			return ok(modalRechazarFactura.render(d));
		}
		
		if(idFactura[0] == null){
			flash("error", "Debe seleccionar una factura");
			return ok(modalRechazarFactura.render(d));
		}
		
		if(d.hasErrors())
			return ok(modalRechazarFactura.render(d));	
		
		ObjectNode result = Json.newObject();
		try {
			Factura fa = Ebean.find(Factura.class).select("id,rechazado,estado_id,write_date,write_usuario_id").setId(idFactura[0]).findUnique();
			fa.rechazado = true;
			fa.estado_id = new Long(Estado.FACTURA_ESTADO_ENCURSO);
			fa.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			fa.write_date = new Date();
			fa.save();
			if(motivos != null){
				for(String m :motivos){
					FacturaRechazo f = new FacturaRechazo();
					f.factura_id = new Long(idFactura[0]);
					f.factura_motivo_rechazo_id = new Long(m);
					f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
					f.write_date = new Date();
					f.save();
				}
			}
			if(!otroMotivo[0].isEmpty()){
				FacturaRechazo f = new FacturaRechazo();
				f.factura_id = new Long(idFactura[0]);
				f.otro = otroMotivo[0];
				f.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				f.write_date = new Date();
				f.save();
			}
			
			result.put("success", true);
			flash("success", "Se actualizaron seleccionados.");
			result.put("html", modalRechazarFactura.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros."+e);
			return ok(modalRechazarFactura.render(d));
		}
		
	}
	
	public static Boolean soloEnCurso(List<Integer> facturasSeleccionados) {
		return Factura.find.where().ne("estado_id", Estado.FACTURA_ESTADO_ENCURSO).in("id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloPreAprobado(List<Integer> facturasSeleccionados) {
		return Factura.find.where()
				.ne("estado_id", Estado.FACTURA_ESTADO_PREAPROBADO)
				.disjunction()
				.isNull("debito_automatico")
				.eq("debito_automatico",false)
				.endJunction()
				.in("id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloBorrador(List<Integer> facturasSeleccionados) {
		return Factura.find.where().ne("estado_id", Estado.FACTURA_ESTADO_BORRADOR).in("id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloParciales(List<Integer> facturasSeleccionados) {
		return Factura.find.where().eq("parcial",true).in("id", facturasSeleccionados).findRowCount() != 0;
	}
	
	public static Boolean soloConOp(List<Integer> facturasSeleccionados) {
		return Factura.find.where().isNull("orden_pago_id").in("id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloConFechaOp(List<Integer> facturasSeleccionados) {
		return Factura.find.where().isNull("fecha_orden_pago").in("id", facturasSeleccionados).findRowCount() == 0;
	}
	public static Boolean soloConPeriodo(List<Integer> facturasSeleccionados) {
		return Factura.find.where().isNull("periodo_id").in("id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloPrecurso(List<Integer> facturasSeleccionados) {
		return Factura.find.where().ne("estado_id", Estado.FACTURA_ESTADO_PRECURSO).in("id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloCancelado(List<Integer> facturasSeleccionados) {
		return Factura.find.where().ne("estado_id", Estado.FACTURA_ESTADO_CANCELADO).in("id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean conExpediente(List<Integer> facturasSeleccionados) {
		return Factura.find.where().isNull("expediente_id").in("id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean conDeudas(List<Integer> facturasSeleccionados) {
		return Factura.find.where().disjunction()
				.eq("debe_dgr_aguinaldo",true)
				.eq("debe_dgr",true)
				.eq("debe_afip",true)
				.eq("debe_judicial",true).endJunction().in("id", facturasSeleccionados).findRowCount() == 0;
		
	}
	
	public static Boolean conFecha322Vencida(List<Integer> facturasSeleccionados) {
		return Factura.find.where()
				.le("fecha_vencimiento_322",new Date())
				.isNotNull("fecha_vencimiento_322")
				.in("id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean conDebeJudicial(List<Integer> facturasSeleccionados) {
		return Factura.find.where().eq("debe_judicial",true).in("id", facturasSeleccionados).findRowCount() == 0;
		
	}
	
	public static Boolean soloConNumero(List<Integer> facturasSeleccionados) {
		boolean ret = false;
		boolean numeroNull = Factura.find.where().isNull("numero_factura").not(Expr.in("proveedor_id",Proveedor.PROVEEDOR_SIN_FACTURAS)).in("id", facturasSeleccionados).findRowCount() == 0;
		boolean numeroVacio = Factura.find.where().eq("numero_factura","").not(Expr.in("proveedor_id",Proveedor.PROVEEDOR_SIN_FACTURAS)).in("id", facturasSeleccionados).findRowCount() == 0;
		
		return (numeroNull && numeroVacio);
	}
	
	public static Boolean soloSinPago(List<Integer> facturasSeleccionados) {
		return Pago.find.where().in("factura_id", facturasSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloSinPagoCancelados(List<Integer> facturasSeleccionados) {
		return Pago.find.where().in("factura_id", facturasSeleccionados).ne("state_id",Estado.PAGO_ESTADO_CANCELADO).findRowCount() == 0;
	}
	
	public static Boolean conLineas(List<Integer> facturasSeleccionados) {
		String sql = " SELECT count(*) cantidad FROM facturas c " +
					 " LEFT OUTER JOIN factura_lineas cl ON c.id = cl.factura_id" +
					 " WHERE cl.id IS NULL AND c.id in (:listId)" +
					 " GROUP BY c.id";
		
		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("listId", facturasSeleccionados).findList();
		 
		return  (l.size() == 0);
	}
	
	public static Boolean conFechaOpVieja(List<Integer> facturasSeleccionados) {
		String sql = " SELECT count(*) cantidad "+
				 	 " FROM facturas c " +
					 " WHERE c.fecha_orden_pago < (select date_start from ejercicios where now() BETWEEN date_start AND date_stop) AND c.id in (:listId)" +
					 " GROUP BY c.id";
		
		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("listId", facturasSeleccionados).findList();
		 
		//return  (l.size() == 0);
		return true;
	}
	
	
	
	public static Boolean sinFechaProvision(List<Integer> facturasSeleccionados) {
		String sql = " SELECT * FROM facturas f " +
					 " INNER JOIN ordenes o ON o.id = f.orden_id " +
					 " WHERE f.id in (:listId) and o.fecha_provision is null and (o.tipo_orden = 'comun' OR o.tipo_orden = 'servicio')";
	
		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("listId", facturasSeleccionados).findList();
		 
		return  (l.size() > 0);
	}
	
	
	public static Boolean hayFacturasParcializadas(List<Integer> facturasSeleccionados) {
		String sql = " SELECT * FROM facturas c " +
					 " WHERE c.factura_principal_id in (:listId) ";
		
		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("listId", facturasSeleccionados).findList();
		 
		return  (l.size() > 0);
	}
	
	public static Result modalDetalleFacturacion(Long id) {
		
		Factura f = Factura.find.byId(id);
		
		return ok(modalDetalleFacturacion.render(f));
	}
	
	public static Result modalDetalleFacturacionPorEstadoPorPeriodo(String nombrePeriodo,Integer estado,Integer proveedorId) {
		
		Periodo p = Periodo.find.where().eq("nombre", nombrePeriodo).findUnique();
		
		ExpressionList<Factura> e = Factura.find.where()
				.eq("periodo_id",p.id)
				.eq("proveedor_id", proveedorId);
		
		if(estado != null && estado == 2){
			e.eq("estado_id",Estado.FACTURA_ESTADO_APROBADO);
		}else{
			e.ne("estado_id",Estado.FACTURA_ESTADO_APROBADO).ne("estado_id",Estado.FACTURA_ESTADO_CANCELADO);
		}
		
		List<Factura> c = e.findList();
		
		return ok(modalDetalleFacturacionPorEstadoPorPeriodo.render(c));
	}
}
