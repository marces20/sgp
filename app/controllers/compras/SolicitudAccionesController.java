package controllers.compras;

import static play.data.Form.form;

import groovy.util.logging.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Security;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import utils.DateUtils;
import utils.RequestVar;
import views.html.compras.certificaciones.modales.modalPasarAprobado;
import views.html.compras.clientes.formClienteContacto;
import views.html.compras.solicitudes.modales.*;
import models.BalancePresupuestario;
import models.Certificacion;
import models.Cliente;
import models.DireccionCliente;
import models.Estado;
import models.Producto;
import models.Solicitud;
import models.SolicitudLinea;
import models.Usuario;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;

@Security.Authenticated(Secured.class)
public class SolicitudAccionesController extends Controller {
	
	final static Form<Solicitud> solicitudForm = form(Solicitud.class);
	
	public static Result importarListaProductos() throws IOException{
		
		String error = "";
		Boolean lineasValidas = true;
		String ok = "";
		
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart upload = body.getFile("myfile");
		Long idSolicitud = new Long(request().body().asMultipartFormData().asFormUrlEncoded().get("idSol")[0]);
		
		
		try{
			if(idSolicitud != null){
				Solicitud s1 = Solicitud.find.byId(idSolicitud);
				
				List<SolicitudLinea> snx = SolicitudLinea.find.where().eq("solicitud_id",idSolicitud).findList();
				boolean yaTieneLineas = (snx.size() > 0)?true:false;
				
				if(s1.estado_id == Estado.SOLICITUD_ESTADO_BORRADOR || s1.estado_id == Estado.SOLICITUD_ESTADO_ENCURSO){
					
				
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
						List<SolicitudLinea> lsl = new ArrayList<SolicitudLinea>();
						List<String> listaP = new ArrayList<String>();
						Map<String,Double> productoControlPrecio = new HashMap<String,Double>();
						List<String> productosRepetidos = new ArrayList<String>();
						
						for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				            row = sheet.getRow(i);
				            SqlRow rowProducto = null;
				            SqlRow rowCuentaAnalitica = null;
							SqlRow rowUnidad = null; 
							Long idProductoAInsertar = null;
							
							
				            int num_emp = (int) row.getCell(0).getNumericCellValue();
				            String nombreProductoOriginal = row.getCell(1).getStringCellValue();
				            String nombreProducto = row.getCell(1).getStringCellValue().toUpperCase().trim().replace(" ","").replace("-","").replace(".","");
				            String nombreProductoAInsertar = row.getCell(1).getStringCellValue();
				            Double cantidad = row.getCell(2).getNumericCellValue();
				            String cuentaAnaliticaCodigo = row.getCell(3).getStringCellValue();
				            String unidadDeMedida = row.getCell(4).getStringCellValue();
				            Double precio = row.getCell(5).getNumericCellValue();
				            
				            
				            
				            Integer idProductoRismi = null;
				            Integer idCategoriaRismi = null;//row.getCell(7).getStringCellValue();
				            Integer idArticuloRismi = null;//row.getCell(8).getStringCellValue();
				            Integer idTipoProductoRismi = null;//row.getCell(9).getStringCellValue();
				            Integer idUdmRismi = null;//row.getCell(10).getStringCellValue();
				            List<Long> dominiosRismi = new ArrayList<Long>();//row.getCell(11).getStringCellValue();
				            
				            Logger.debug("111111111111");
				            
				            /*Cell cellIdProductoRismi = row.getCell(6,  Row.RETURN_BLANK_AS_NULL);
				            Logger.debug("11111aaaaaaaaaaaaaaa");
				            if(cellIdProductoRismi != null){
				            	Logger.debug("11111111111111bbbbbbbbbbbb");
				            	idProductoRismi = (int) row.getCell(6).getNumericCellValue();
				            	Logger.debug("11111111111111ccccccccc"+idProductoRismi);
				            }
				            Logger.debug("22222222222");
				            
				            Cell cellIdCategoriaRismi = row.getCell(7,  Row.RETURN_BLANK_AS_NULL);
				            if(cellIdCategoriaRismi != null){
				            	idCategoriaRismi =(int)  row.getCell(7).getNumericCellValue();
				            }else{
				            	idCategoriaRismi = 14;
				            }
				            Logger.debug("333333333333");
				            Cell cellIdArticuloRismi = row.getCell(8,  Row.RETURN_BLANK_AS_NULL);
				            if(cellIdArticuloRismi != null){
				            	idArticuloRismi =(int)  row.getCell(8).getNumericCellValue();
				            }
				            Logger.debug("44444444444");
				            Cell cellIdTipoProductoRismi = row.getCell(9,  Row.RETURN_BLANK_AS_NULL);
				            if(cellIdTipoProductoRismi != null){
				            	idTipoProductoRismi =(int)  row.getCell(9).getNumericCellValue();
				            }else{
				            	idTipoProductoRismi = 2;
				            }
				            Logger.debug("555555555555");
				            Cell cellIdUdmRismi = row.getCell(10,  Row.RETURN_BLANK_AS_NULL);
				            if(cellIdUdmRismi != null){
				            	idUdmRismi = (int) row.getCell(10).getNumericCellValue();
				            }else{
				            	idUdmRismi = 1;
				            }
				            Logger.debug("666666666666");
				            Cell cellDominiosRismi = row.getCell(11,  Row.RETURN_BLANK_AS_NULL);
				            
				            if(cellDominiosRismi != null){
				            	
				            	String[] parts = row.getCell(11).getStringCellValue().split(";");
				            	for(String e :parts){
				            		dominiosRismi.add(new Long(e));
				            	}
				            }*/
				            
				            
				            if(productoControlPrecio.containsKey(nombreProducto)){
				            	Double a = productoControlPrecio.get(nombreProducto);
				            	if(a.compareTo(precio) != 0){
				            		//hay un producto igual con distinto precio
				            		error += "<p class='responseError'>-Esta producto "+nombreProductoAInsertar+" repetido con distinto precio. linea "+num_emp+" </p>";
				            		lineasValidas = false;
				            	}
				            }else{
				            	productoControlPrecio.put(nombreProducto, precio);
				            }
				            
				            String precioAinsertar = (precio != 0)?precio.toString():"1";
				            String insert = "INSERT INTO productos(nombre,referencia,precio_coste,activo,categoria_id," +
					           		"tipo_producto_id, articulo_id, udm_id, cuenta_ingreso_id, cuenta_gasto_id,compra,venta) VALUES " +
					           		"('"+nombreProductoAInsertar+"','"+nombreProductoAInsertar+"',"+precioAinsertar+",true,XXX,2, 1537, 1, 226,255,false,false);";
				            
				            
				            
				            
				            if(nombreProducto != null && !nombreProducto.isEmpty()){
				            	//if(!listaP.contains(nombreProducto)){
						            //String sqlProducto = "SELECT id FROM productos WHERE UPPER(replace(replace(replace(trim(nombre),' ','' ),'-',''),'.','' )) = :nombre";
				            	String sqlProducto = "SELECT id FROM productos WHERE slug = :nombre";
						            List<SqlRow> rp = Ebean.createSqlQuery(sqlProducto)
						            				 .setParameter("nombre", nombreProducto)
						            				 .findList();
						            for(SqlRow x : rp){
						            	rowProducto = x;
						            }
						            
						            
						            if(rowProducto == null || rowProducto.isEmpty()){
						            	
						            	if(idProductoRismi != null){
						            		
						            		
						            		Producto pe = new Producto();
						            		pe.activo =  true;
						            		pe.nombre = nombreProductoOriginal;
						            		pe.articulo_id = idArticuloRismi;
						            		pe.categoria_id = idCategoriaRismi;
						            		pe.tipo_producto_id = idTipoProductoRismi;
						            		pe.udm_id = new Integer(idUdmRismi);
						            		pe.codigo_rismi = idProductoRismi.toString();
						            		
						            		Logger.debug("gggggggggggggggg "+pe.codigo_rismi);
						            		
						            		Producto pret = Producto.cargarProductosDesdeRismi(pe, dominiosRismi);
						            		Logger.debug("dddddddddddddddddd "+pe.codigo_rismi);
						            		idProductoAInsertar = pret.id;
						            	
						            	}else{
							            	if(!productosRepetidos.contains(nombreProducto)){
								            	if(Usuario.getUsuarioSesion() == 1){
								            		error += "<p class='responseError'>"+insert+" </p>";
								            	}else{
								            		error += "<p class='responseError'>-No se encuentra el producto "+nombreProducto+" en la linea "+num_emp+" </p>";
								            	}
								            	
								            	
								            	
								            	productosRepetidos.add(nombreProducto);
							            	}
							            	lineasValidas = false;
						            	}	
						            }else{
						            	idProductoAInsertar = rowProducto.getLong("id");
						            }
						            listaP.add(nombreProducto);
				            	/*}else{
						            lineasValidas = false;
						            error += "<p class='responseError'>-Esta repetido el producto "+nombreProducto+" en la linea "+num_emp+" </p>";
				            	}*/
						            
				            }else{
				            	error += "<p class='responseError'>-No se encuentra el producto en la linea "+num_emp+" </p>";
				            	lineasValidas = false;
				            }
				            
				          
				            
				            if(cuentaAnaliticaCodigo != null && !cuentaAnaliticaCodigo.isEmpty()){
					            String sqlCuentaAnalitica = "SELECT id " +
					            		"FROM cuentas_analiticas " +
					            		"WHERE UPPER(replace(replace(trim(codigo),' ','' ),'-','')) = :codigo";
					            rowCuentaAnalitica = Ebean.createSqlQuery(sqlCuentaAnalitica)
										       				 .setParameter("codigo", cuentaAnaliticaCodigo.toUpperCase().trim().replace(" ","").replace("-",""))
										       				 .findUnique();
					            if(rowCuentaAnalitica == null || rowCuentaAnalitica.isEmpty()){
					            	error += "<p class='responseError'>-No se encuentra la cuenta analitica "+cuentaAnaliticaCodigo+" en la linea "+num_emp+" </p>";
					            	lineasValidas = false;
					            }
				            }else{
				            	error += "<p class='responseError'>-No se encuentra la cuenta analitica en la linea "+num_emp+" </p>";
				            	lineasValidas = false;
				            }
				            
				            int udmId = 1;
				            if(unidadDeMedida != null && !unidadDeMedida.isEmpty()){
					            String sqlUnidad = "SELECT id FROM udms WHERE UPPER(replace(trim(nombre),' ','' )) = :unidad";
					            
					            rowUnidad = Ebean.createSqlQuery(sqlUnidad)
										       				 .setParameter("unidad", unidadDeMedida.toUpperCase().trim().replace(" ",""))
										       				 .findUnique();
					            if(rowUnidad == null || rowUnidad.isEmpty()){
					            	/*error += "<p class='responseError'>-No se encuentra la unidad "+unidadDeMedida+" en la linea "+num_emp+" </p>";
					            	lineasValidas = false;*/
					            }else{
					            	udmId = rowUnidad.getInteger("id");
					            }
				            }else{
				            	error += "<p class='responseError'>-No se encuentra la unidad en la linea "+num_emp+" </p>";
				            	lineasValidas = false;
				            }
				            
				            
				            if(lineasValidas){
				            	SolicitudLinea sl = new SolicitudLinea();
					            sl.producto_id = idProductoAInsertar;
					            sl.cantidad = new BigDecimal(cantidad).setScale(2, BigDecimal.ROUND_HALF_UP);
					            sl.cuenta_analitica_id = 11;//rowCuentaAnalitica.getInteger("id");
					            sl.precio_estimado = new BigDecimal(precio).setScale(2, BigDecimal.ROUND_HALF_UP);
					            sl.solicitud_id = idSolicitud;
					            sl.udm_id = udmId;
					            sl.create_date = new Date();
					            sl.create_usuario_id = (long) Usuario.getUsuarioSesion();
					            lsl.add(sl);
				            }
				            cantidadDeRowProcesadas ++;
						}
						
						if(lineasValidas){
							for(SolicitudLinea s : lsl){
								List<SolicitudLinea> sn = SolicitudLinea.find.where().eq("producto_id",s.producto_id)
										.eq("solicitud_id",s.solicitud_id).findList();
								if(sn != null && sn.size() > 0){
									for(SolicitudLinea st : sn){
										if(yaTieneLineas){
											st.cantidad = s.cantidad;
										}else{
											st.cantidad = st.cantidad.add(s.cantidad);
										}
										st.cuenta_analitica_id = s.cuenta_analitica_id;
										st.precio_estimado = s.precio_estimado;
										st.udm_id = s.udm_id;
										st.update();
									}
								}else{
									s.save();
								}
							}
							ok += "<p class='responseOk'>- Se ha procesado correctamente el archivo. Se procesaron "+cantidadDeRowProcesadas+" lineas.</p>";
						}
						
					} else {
						error += "<p class='responseError'>- No se encuentra el archivo a procesar.</p>";
					}
				}else{
					error += "<p class='responseError'>- Solo se puede procesar cuando el estado de la solicitud es Borrador o en Curso.</p>";
				}
			}else{
				error += "<p class='responseError'>- No se encuentra la solicitud</p>";
			}
		}catch(Exception e){
			
		}
		
		String ret = error+ok;
		return ok(ret);
	}
	
	public static Result modalImportarListaProductos() {
		return ok(modalImportarListaProductosCantidades.render(form().bindFromRequest()));
	}
	
	public static Result modalAsignarUsuario(Long id) {
		
		Solicitud s =null;
		DynamicForm d = form().bindFromRequest();
		boolean masivo = true;
		if(id.compareTo(new Long(0)) != 0){
			masivo = false;
			s = Solicitud.find.byId(id);
			Map<String,String> p = new HashMap<String, String>();
			p.put("referencia",s.referencia);
			p.put("id",s.id.toString());
			p.put("departamento_id",s.departamento_id.toString());
			 
			
			d = form().bindFromRequest().bind(p);
			 
		}
		
		return ok(modalAsignarUsuario.render(d,masivo));
	}
	
	public static Result asignarUsuario() {
		//Form<Solicitud> solForm = form(Solicitud.class).bindFromRequest();
		
		
		
		DynamicForm d = form().bindFromRequest();
		ObjectNode restJs = Json.newObject();
		boolean masivo = true;
		Long idSolicitud = null;
		
		Long idUser = null;
		
		if(request().body().asFormUrlEncoded().get("asignacion_usuario_id") !=null && !request().body().asFormUrlEncoded().get("asignacion_usuario_id")[0].isEmpty()){
			idUser = new Long(request().body().asFormUrlEncoded().get("asignacion_usuario_id")[0]);
		}	
		
		Logger.debug("11111111");
		if(request().body().asFormUrlEncoded().get("id") !=null && !request().body().asFormUrlEncoded().get("id")[0].isEmpty()){
			idSolicitud = new Long(request().body().asFormUrlEncoded().get("id")[0]);
			masivo = false;
			
			
			
			if(idUser ==  null || idSolicitud ==  null) {
				flash("error", "Error en formulario");
				return ok(modalAsignarUsuario.render(d,masivo));
			} else {
				
				Solicitud solicitud = Solicitud.find.byId(idSolicitud); 
				
				try{
					
					solicitud.asignacion_date = new Date();
					solicitud.asignacion_usuario_id = idUser;
					solicitud.update();
					
					restJs.put("success", true);
					restJs.put("idSolicitud", idSolicitud);
					restJs.put("userAsignadoName", solicitud.asignacion_usuario.nombre);
				}catch(Exception e){
					flash("error", "Error en formulario "+e);
					return ok(modalAsignarUsuario.render(d,masivo));
				}
			}
			
			
		}else {
			Logger.debug("2222222 "+idUser);
			if(idUser !=  null) {
				List<Integer> lista = getSeleccionados();
				if(lista.size() > 0) {
					try{
						 List<Solicitud> sex = Solicitud.find.where().in("id",lista).findList();
						 
						 for(Solicitud ss :sex) {
							 ss.asignacion_date = new Date();
							 ss.asignacion_usuario_id = idUser;
							 ss.update();
						 }
						 
						 restJs.put("success", true);
					}catch(Exception e){
						flash("error", "Error en formulario "+e);
						return ok(modalAsignarUsuario.render(d,masivo));
					}
				 }else {
					 flash("error", "Debe seleccionar al menos una solicitud");
					 return ok(modalAsignarUsuario.render(d,masivo));
				 }
			}else {
				flash("error", "Error en formulario ");
				return ok(modalAsignarUsuario.render(d,masivo));
			}
				
		}
		
		
		
		 
		
		
		
		
		
		return ok(restJs);
	}
	
	public static Result modalModificarPaciente(Long id) {
		
		Solicitud s = Solicitud.find.byId(id);
		Map<String,String> p = new HashMap<String, String>();
		p.put("referencia",s.referencia);
		p.put("id",s.id.toString());
		p.put("departamento_id",s.departamento_id.toString());
		Form<Solicitud> solicitud = form(Solicitud.class).bind(p);
		solicitud.discardErrors();
		
		return ok(modalModificarPaciente.render(solicitud));
	}
	
	public static Result modificarPaciente() {
		
		Form<Solicitud> solForm = form(Solicitud.class).bindFromRequest();
		ObjectNode restJs = Json.newObject();
		
		if(solForm.hasErrors()) {
			flash("error", "Error en formulario"+solForm.errors());
			return ok(modalModificarPaciente.render(solForm));
		} else {
			
			Solicitud solicitud = solForm.get();
			Long idSolicitud = new Long(solicitud.id);
			Integer idCLiente = new Integer(solicitud.cliente_id);
			
			try{
				solicitud.cliente_id = idCLiente;
				solicitud.update();
				
				restJs.put("success", true);
				restJs.put("idSolicitud", idSolicitud);
				restJs.put("idCLiente", idCLiente);
			}catch(Exception e){
				flash("error", "Error en formulario "+e);
				return ok(modalModificarPaciente.render(solForm));
			}
		}
		return ok(restJs);
	}
	
	public static Result pasarAprobadoPorPresupuesto() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> solSeleccionados = getSeleccionados();

		if(solSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una solicitud.");
			return ok(modalPasarAprobadoPorPresupuesto.render(d));
		}	
		
		List<Solicitud> sex = Solicitud.find.where().in("id",solSeleccionados).isNull("expediente_id").findList();
		
		if(sex.size() > 0) {
			flash("error", "Debe tener asignado todos un expediente.");
			return ok(modalPasarAprobadoPorPresupuesto.render(d));
		}	
		
		List<Solicitud> seer = Solicitud.find.where().in("id",solSeleccionados).ne("state_id", Estado.SOLICITUD_ESTADO_BORRADOR).findList();
		
		if(seer.size() > 0) {
			flash("error", "Las solicitudes debe estar en estado Borrador");
			return ok(modalPasarAprobadoPorPresupuesto.render(d));
		}	
		
		
		List<Solicitud> se = Solicitud.find.where().in("id",solSeleccionados).findList();
		Long e = null;
		if(se.size() > 0) {
			e = se.get(0).expediente.ejercicio_id;
			for(Solicitud s : se) {
				if(e.compareTo(s.expediente.ejercicio_id) != 0) {
					flash("error", "Los ejercicios de los expedientes deben ser iguales");
					return ok(modalPasarAprobadoPorPresupuesto.render(d));
				}
			}
		}
		 
		
		//ArrayNode a = BalancePresupuestario.controlSaldoDefinitivo(solSeleccionados);
		ArrayNode a = BalancePresupuestario.controlSaldo(se,e.intValue());
		boolean errorControl =  false;
		String aviso = "";
		for(JsonNode o :a){
			boolean success = new Boolean(o.get("success").toString());
			String cuenta = o.get("cuenta").toString();
			//String expediente = o.get("expediente").toString();
			BigDecimal saldoDisponible =  new BigDecimal(o.get("saldoDisponible").toString());
			BigDecimal saldoAImputar =  new BigDecimal(o.get("saldoAImputar").toString());
			BigDecimal saldoPresente =  new BigDecimal(o.get("saldoPresente").toString());
			
			if(!success){
				errorControl =  true;
				aviso += "No tiene Saldo disponible para la cuenta "+cuenta+"<br>";
				aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}else{
				aviso += "Tiene Saldo disponible para la cuenta "+cuenta+"<br>";
				aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}
		}
		
		if(d.hasErrors())
			return ok(modalPasarAprobadoPorPresupuesto.render(d));	
		
		if(errorControl){
			flash("error", aviso);
			return ok(modalPasarAprobadoPorPresupuesto.render(d));
		}else{
			ObjectNode result = Json.newObject();
			try {
				Integer count = Solicitud.modificarEstadoMasivo(Estado.SOLICITUD_ESTADO_APRESUPUESTO, solSeleccionados);
				result.put("success", true);
				flash("success", "Se actualizaron " + count + " registros de "+ solSeleccionados.size() +" seleccionados.<br>"+aviso);
				result.put("html", modalPasarAprobadoPorPresupuesto.render(d).toString());
				return ok(result);
			} catch (Exception ex){
				flash("error", "No se puede modificar los registros.");
				return ok(modalPasarAprobadoPorPresupuesto.render(d));
			}
		}
	}
	
	public static Result modalPasarAprobadoPorPresupuesto() {
		return ok(modalPasarAprobadoPorPresupuesto.render(form().bindFromRequest()));
	}
	
	public static Result pasarAutorizado() {
		DynamicForm d = form().bindFromRequest();
		d.discardErrors();
		
		List<Integer> solSeleccionados = getSeleccionados();

		if(solSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una solicitud.");
			return ok(modalPasarAutorizado.render(d));
		}	
		
		List<Solicitud> seer = Solicitud.find.where().in("id",solSeleccionados).ne("state_id", Estado.SOLICITUD_ESTADO_APRESUPUESTO).findList();
		
		if(seer.size() > 0) {
			flash("error", "Las solicitudes debe estar en estado Aprobado presupuesto");
			return ok(modalPasarAutorizado.render(d));
		}	
		
		
		List<Solicitud> se = Solicitud.find.where().in("id",solSeleccionados).findList();
		Long e = null;
		if(se.size() > 0) {
			e = se.get(0).expediente.ejercicio_id;
			for(Solicitud s : se) {
				if(e.compareTo(s.expediente.ejercicio_id) != 0) {
					flash("error", "Los ejercicios de los expedientes deben ser iguales");
					return ok(modalPasarAutorizado.render(d));
				}
			}
		}
		 
		ObjectNode result = Json.newObject();
		try {
			Integer count = Solicitud.modificarEstadoMasivo(Estado.SOLICITUD_ESTADO_AUTORIZADO, solSeleccionados);
			result.put("success", true);
			flash("success", "Se actualizaron " + count + " registros de "+ solSeleccionados.size() +" seleccionados.<br>");
			result.put("html", modalPasarAutorizado.render(d).toString());
			return ok(result);
		} catch (Exception ex){
			flash("error", "No se puede modificar los registros.");
			return ok(modalPasarAutorizado.render(d));
		}
		 
	}
	
	
	public static Result modalPasarAutorizado() {
		return ok(modalPasarAutorizado.render(form().bindFromRequest()));
	}
	
	public static List<Integer> getSeleccionados(){
		String[] checks = request().body().asFormUrlEncoded().get("check_listado[]");
		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}
}
