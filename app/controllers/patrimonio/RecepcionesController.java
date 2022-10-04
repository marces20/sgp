package controllers.patrimonio;

import static play.data.Form.form;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import models.Estado;
import models.Expediente;
import models.Orden;
import models.OrdenLinea;
import models.OrdenProvision;
import models.OrdenProvisionLineas;
import models.Producto;
import models.Recepcion;
import models.Remito;
import models.RemitoLinea;
import models.Solicitud;
import models.SolicitudLinea;
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
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import views.html.compras.solicitudes.modales.modalImportarListaProductosCantidades;
import views.html.compras.solicitudes.modales.modalReporteCuadroSolicitud;
import views.html.expediente.expediente.modalBusquedaExpediente;
import views.html.patrimonio.recepciones.*;
import views.html.patrimonio.remitos.crearRemito;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class RecepcionesController extends Controller {
	final static Form<Recepcion> oForm = form(Recepcion.class);
	
	@CheckPermiso(key = "recepcionesVer")
	public static Result index(){
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		Pagination<Recepcion> recepciones = Recepcion.page(RequestVar.get("orden_provision"), 
														   RequestVar.get("expediente_id"), 
														   RequestVar.get("proveedor_id"), 
														   RequestVar.get("numero"), 
														   RequestVar.get("acta"), 
														   RequestVar.get("remito"), 
														   RequestVar.get("fecha_desde"), 
														   RequestVar.get("fecha_hasta"), 
														   RequestVar.get("responsable_id"), 
														   RequestVar.get("acta_numero"), 
														   RequestVar.get("sinActa"),
														   RequestVar.get("conacta"),
														   RequestVar.get("fecha_provision_desde"), 
														   RequestVar.get("fecha_provision_hasta"),
														   RequestVar.get("profe"),
														   RequestVar.get("tipo_moneda"),
														   RequestVar.get("deposito_id"),
														   RequestVar.get("tipo_cuenta_id"),
														   RequestVar.get("orden_rubro_id")
														   );
		
		DynamicForm d = form().bindFromRequest();
		return ok(indexRecepciones.render(recepciones, d, pf));
	}
	
	public static Result indexAjax(){
		Pagination<Recepcion> recepciones = Recepcion.page(RequestVar.get("orden_provision"), 
														   RequestVar.get("expediente_id"), 
														   RequestVar.get("proveedor_id"), 
														   RequestVar.get("numero"), 
														   RequestVar.get("acta"), 
														   RequestVar.get("remito"), 
														   RequestVar.get("fecha_desde"), 
														   RequestVar.get("fecha_hasta"), 
														   RequestVar.get("responsable_id"), 
														   RequestVar.get("acta_numero"), 
														   RequestVar.get("sinActa"),
														   RequestVar.get("conacta"),
														   RequestVar.get("fecha_provision_desde"), 
														   RequestVar.get("fecha_provision_hasta"),
														   RequestVar.get("profe"),
														   RequestVar.get("tipo_moneda"),
														   RequestVar.get("deposito_id"),
														   RequestVar.get("tipo_cuenta_id"),
														   RequestVar.get("orden_rubro_id")
														   );
		DynamicForm d = form().bindFromRequest();

		return ok(indexRecepcionesAjax.render(recepciones, d));
	}
	
	@CheckPermiso(key = "recepcionesVer")
	public static Result ver(Long id){
		Recepcion r = Recepcion.find.byId(id);
		
		if(r != null) {
			if(!r.controlPermisoDeposito()) {
				flash("error", "La recepcion de la orden no corresponde a su institucion asignada.");
				return redirect(controllers.patrimonio.routes.RecepcionesController.index()+UriTrack.get("?"));
			}
			
			PaginadorFicha pf = new PaginadorFicha(UriTrack.code());
			
			return ok(verRecepcion.render(r,pf));
		}else {
			flash("error", "No se encuentra la recepcion.");
			return redirect(controllers.patrimonio.routes.RecepcionesController.index()+UriTrack.get("?"));
		}
	}
	
	@CheckPermiso(key = "recepcionesCrear")
	public static Result crear(Long orden_provision_id){
		
		Form<Recepcion> rForm = form(Recepcion.class);
		Recepcion r = Recepcion.find.where().eq("orden_provision_id", orden_provision_id).setMaxRows(1).orderBy("numero desc").findUnique();
		
		Integer i = 1;
		if(r != null){
			i = new Integer(r.numero);
			i = i+1;
		}
		rForm.data().put("numero", i.toString());
		
		 
		rForm.data().put("orden_provision_id", orden_provision_id.toString());
		return ok(crearRecepcion.render(rForm));
		
	}
	
	@CheckPermiso(key = "recepcionesCrear")
	public static Result guardar(){
		Form<Recepcion> rForm = form(Recepcion.class).bindFromRequest();
		
		if(rForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(crearRecepcion.render(rForm));
		}
		
		Recepcion r2 = Recepcion.find.where()
				.eq("numero", rForm.data().get("numero"))
				.eq("orden_provision_id", new Long(rForm.data().get("orden_provision_id")))
				.findUnique();
		
		if(r2 != null) {
			flash("error", "El número de recepción que intenta crear ya existe.");
			return ok(crearRecepcion.render(rForm));
		}
        
		try {
			Recepcion r = rForm.get();
			
			if(!r.controlPermisoDeposito()) {
				flash("error", "La institucion de la orden no corresponde a su institucion asignada.");
				return redirect(controllers.patrimonio.routes.RecepcionesController.index()+UriTrack.get("?"));
			}
			
			r.create_date = new Date();
			r.create_usuario_id = (long) Usuario.getUsuarioSesion();
			r.save();
			flash("success", "Se ha creado la recepción número <b>"+r.numero+"</b>");
			
			return redirect( controllers.patrimonio.routes.RecepcionesController.ver( r.id )+UriTrack.get("&"));//
		} catch (Exception e) {
			flash("error", "Problemas al crear la recepción");
			return ok(crearRecepcion.render(rForm));
		}
		
	}
	
	@CheckPermiso(key = "recepcionesEliminar")
	public static Result eliminar(Long id){
		Recepcion r = Recepcion.find.byId(id);
		
		if(r.acta_id != null && (r.acta.estado_id == Estado.ACTA_ESTADO_APROBADA || r.acta.estado_id == Estado.ACTA_ESTADO_ENCURSO || r.acta.estado_id == Estado.ACTA_ESTADO_CANCELADA)){
			flash("error", "La orden no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}
		
		
		
		String numero = r.numero;
		ObjectNode restJs = Json.newObject();
		if(!r.remito.isEmpty()) {
			flash("error", "No se puede eliminar recepciones con remitos cargados.");
			return redirect(controllers.patrimonio.routes.RecepcionesController.ver(id)+UriTrack.get("&"));//
		}		
		
		try {
			r.delete();
			flash("success", "Se ha eliminado la recepción número <b>"+numero+"</b>.");
			return redirect(controllers.patrimonio.routes.RecepcionesController.index()+UriTrack.get("?"));//
		} catch (Exception e) {
			flash("error", "Problemas al eliminar la recepción");
			return redirect(controllers.patrimonio.routes.RecepcionesController.ver(id)+UriTrack.get("&"));//
		}

	}
	
	@CheckPermiso(key = "recepcionesCrear")
	public static Result editar(Long id){
		Recepcion r = Recepcion.find.byId(id);
		
		if(r.acta_id != null && (r.acta.estado_id == Estado.ACTA_ESTADO_APROBADA || r.acta.estado_id == Estado.ACTA_ESTADO_ENCURSO || r.acta.estado_id == Estado.ACTA_ESTADO_CANCELADA)){
			flash("error", "La Recepcion no se puede editar cuando el Acta esta en este estado. Debe cambiar su estado a borrador el Acta.");
			return redirect(request().getHeader("referer"));
		}
		if(!r.controlPermisoDeposito()) {
			flash("error", "La recepcion de la orden no corresponde a su institucion asignada.");
			return redirect(controllers.patrimonio.routes.RecepcionesController.index()+UriTrack.get("?"));
		}
		return ok(editarRecepcion.render(form(Recepcion.class).fill(r)));
	}
	
	@CheckPermiso(key = "recepcionesCrear")
	public static Result actualizar(){
		Form<Recepcion> rForm = form(Recepcion.class).bindFromRequest();

		if(rForm.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(editarRecepcion.render(rForm));
		}
		
		List<Recepcion> r2 = Recepcion.find.where()
				.eq("numero", rForm.data().get("numero"))
				.eq("orden_provision_id",new Long(rForm.data().get("orden_provision_id")))
				.ne("id", rForm.get().id).findList();
		
		if(r2.size() > 0) {
			flash("error", "El número de recepción que intenta editar ya existe.");
			return ok(editarRecepcion.render(rForm));
		}
        
		try {
			Recepcion r = rForm.get();
			Long id = rForm.get().id;
			if(!r.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				
			}
			
			r.create_date = new Date();
			r.create_usuario_id = (long) Usuario.getUsuarioSesion();
			r.update();
			flash("success", "Se ha editado la recepción número <b>"+r.numero+"</b>");

			return redirect(controllers.patrimonio.routes.RecepcionesController.ver(id)+UriTrack.get("&"));//
			
		} catch (Exception e) {
			flash("error", "Problemas al crear la recepción");
			return ok(editarRecepcion.render(rForm));
		}
		
	}
	
	public static Result modalBuscarRecepcionesDeOrdenes(Long idOrdenProvision) {
    	Pagination<Recepcion> p = new Pagination<Recepcion>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	
    	ExpressionList<Recepcion> e = Recepcion.find.where().eq("orden_provision_id", idOrdenProvision);
    	
    	p.setExpressionList(e);
		return ok( modalBuscarRecepcionesDeOrdenes.render(p, form().bindFromRequest()) );
	}
	
	public static Result get(int id){
		Recepcion re = Recepcion.find.select("id, numero").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(re == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la recepcion");
		} else {
			restJs.put("success", true);
			restJs.put("id", re.id);
			restJs.put("nombre", re.numero);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalCargarRemitosMasivos(Long id) {
		return ok(modalCargarRemitosMasivos.render(form().bindFromRequest(),id));
	}
	
	public static Result cargarRemitosMasivos() throws IOException{
		
		String error = "";
		Boolean lineasValidas = true;
		String ok = "";
		
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart upload = body.getFile("myfile");
		Long idRecepcion = new Long(request().body().asMultipartFormData().asFormUrlEncoded().get("idRecepcion")[0]);
		Long proveedor_id =  null; 
		Connection connection = play.db.DB.getConnection();

		Recepcion re = Recepcion.find.byId(idRecepcion);
		
		try{

			Map<Long,BigDecimal> controlCantidadesProductos = new HashMap<Long, BigDecimal>();
			Map<Long,BigDecimal> productoCantidadCargadas = new HashMap<Long, BigDecimal>();
			Map<Long,Long> productoIdLineaOrdenCargadas = new HashMap<Long, Long>();
			Map<String,Map<Long,BigDecimal>> datosACargar = new HashMap<String,Map<Long,BigDecimal>>();
			Map<String,Date> remitoFecha = new HashMap<String,Date>();
			Date fecha = null;

			if (idRecepcion != null) {
				
				proveedor_id = re.ordenProvision.ordenCompra.proveedor.id;
				
				List<OrdenLinea> lo = re.ordenProvision.ordenCompra.lineas;
				
				for(OrdenLinea lox :lo) {
					productoCantidadCargadas.put(lox.producto_id, lox.cantidad);
					productoIdLineaOrdenCargadas.put(lox.producto_id, lox.id);
				}
				
				if (upload != null) {
					
				    File file = upload.getFile();
				    
				    FileInputStream input = new FileInputStream(file.getAbsolutePath());
					POIFSFileSystem fs = new POIFSFileSystem(input);
					HSSFWorkbook wb = new HSSFWorkbook(fs);
					HSSFSheet sheet = wb.getSheetAt(0);
					Row row;
					int cantidadDeRowProcesadas = 0;
					//List<SolicitudLinea> lsl = new ArrayList<SolicitudLinea>();
					//List<String> listaP = new ArrayList<String>();
					//Map<String,Double> productoControlPrecio = new HashMap<String,Double>();
					//List<String> productosRepetidos = new ArrayList<String>();
					
					
					
					for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			            row = sheet.getRow(i);
			            //SqlRow rowProducto = null;
			            //Long idProductoAInsertar = null;
						
						
			            int num_emp = (int) row.getCell(0).getNumericCellValue();
			            
			            //String nombreProductoOriginal = row.getCell(1).getStringCellValue();
			            String nombreProducto = row.getCell(3).getStringCellValue().toUpperCase().trim().replace(" ","").replace("-","").replace(".","");
			            //String nombreProductoAInsertar = row.getCell(1).getStringCellValue();
			            Long idProductoCargado = null;
			            
			            
			            /*
			             * Controla por SLUG que el producto  se encuentre en la OP
			             */
			            if(nombreProducto != null && !nombreProducto.isEmpty()){
			            	 
			            	String sqlProducto = "SELECT id FROM productos WHERE slug = :nombre";
					        List<SqlRow> rp = Ebean.createSqlQuery(sqlProducto)
					            			  .setParameter("nombre", nombreProducto)
					            			  .findList();

					            if(rp.size() > 0) {
					            	idProductoCargado = rp.get(0).getLong("id");
					            	if(!productoIdLineaOrdenCargadas.containsKey(idProductoCargado)) {
					            		error += "<p class='responseError'>-El producto en la linea "+num_emp+" no se encuentra cargado en la OP.</p> " + idProductoCargado;
						            	lineasValidas = false;
					            	}
					            	
					            	
					            }else {
					            	error += "<p class='responseError'>-No se encuentra el producto en la linea "+num_emp+" </p>";
					            	lineasValidas = false;
					            }			            	  
			            } else{
			            	error += "<p class='responseError'>-No se encuentra el producto en la linea "+num_emp+" </p>";
			            	lineasValidas = false;
				        }
 
			            /*
			             * Controla que la cantidad esté especificado en el excel
			             */
			            Double cantidad = row.getCell(4).getNumericCellValue();
			            if(cantidad == null){
			            	error += "<p class='responseError'>-No se encuentra la cantidad en la linea "+num_emp+" </p>";
			            	lineasValidas = false;
			            }
			            
			            /*
			             * Controla que el número de remito esté especificado en el excel
			             */
			            String remito = row.getCell(2).getStringCellValue();
			            if(remito == null ||  remito.isEmpty()){
			            	error += "<p class='responseError'>-No se encuentra el remito en la linea "+num_emp+" </p>";
			            	lineasValidas = false;
			            } 
			             
			            
						//Compruebo si el tipo de celda de número es string, si no tiero mensaje
						if(HSSFCell.CELL_TYPE_STRING != row.getCell(2).getCellType()) {
			            	error += "<p class='responseError'>-La linea "+num_emp+" no es de tipo texto</p>";
			            	lineasValidas = false;
						}  
			            
						Date fechastr = null;
						

						
						/*
						 * Compruebo si el tipo de celda de número es string, para transformarlo en Date
						 * En el excel que se exporta los remito la fila de fecha no tiene formato y en el de la plantilla si, por eso
						 */
						if(HSSFCell.CELL_TYPE_STRING == row.getCell(1).getCellType()) {

				             final String OLD_FORMAT = "dd/MM/yyyy";
				             final String NEW_FORMAT = "yyyy/MM/dd";

				             String oldDateString = row.getCell(1).getStringCellValue();
				             String newDateString;

				             SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
				             Date d = sdf.parse(oldDateString);
				             sdf.applyPattern(NEW_FORMAT);
				             
				             fechastr = d;
							
						}  else {
							fechastr = row.getCell(1).getDateCellValue();
						}


			            /*
			             * Compruebo si la fecha se encuentra en el excel
			             */
			            if(fechastr == null){
			            	error += "<p class='responseError'>-No se encuentra la fecha en la linea "+num_emp+" </p>";
			            	lineasValidas = false;
			            }  
			            
			            if(lineasValidas) {
			            	Map<Long,BigDecimal> productoCantidad = new HashMap<Long, BigDecimal>();
			            	BigDecimal cc = new BigDecimal(cantidad);
			            	
			            	if(datosACargar.containsKey(remito)) {
			            		Map<Long,BigDecimal> xx = datosACargar.get(remito);
			            		xx.put(idProductoCargado, cc);
			            		datosACargar.put(remito, xx);
			            		
			            	}else {
			            		remitoFecha.put(remito, fechastr);
			            		productoCantidad.put(idProductoCargado, cc);
			            		datosACargar.put(remito, productoCantidad);
			            	}
			            	
			            	if(controlCantidadesProductos.containsKey(idProductoCargado)) {
			            		BigDecimal xxc = controlCantidadesProductos.get(idProductoCargado);
			            		BigDecimal xxcTmp = xxc.add(cc);
			            		controlCantidadesProductos.put(idProductoCargado, xxcTmp);
			            	}else {
			            		controlCantidadesProductos.put(idProductoCargado, cc);
			            	}
			            }
			            
			             
			            cantidadDeRowProcesadas ++;
					}
					
					
					
				} else {
					lineasValidas = false;
					error += "<p class='responseError'>- No se encuentra el archivo a procesar.</p>";
				} 

			}else{
				lineasValidas = false;
				error += "<p class='responseError'>- No se encuentra la recepcion</p>";
			}
			
			/*
			for (Map.Entry<Long, BigDecimal> entry : controlCantidadesProductos.entrySet()) { 
				Long key = entry.getKey(); 
				BigDecimal value = entry.getValue();  

				
				if(productoCantidadCargadas.containsKey(key)) {
					if(value.compareTo(productoCantidadCargadas.get(key)) > 0) {
						String sqlProducto = "SELECT nombre FROM productos WHERE id = :id";
			            List<SqlRow> rp = Ebean.createSqlQuery(sqlProducto)
			            				 .setParameter("id", key)
			            				 .findList();
			            
						lineasValidas = false;
						error += "<p class='responseError'>- El producto "+rp.get(0).getString("nombre")+" supera la cantidad a cargada con la cantidad a cargar.</p>";
					}
				}
			}
			*/
			
			for (Map.Entry<String, Map<Long,BigDecimal>> entryx : datosACargar.entrySet()) { 
				String key = entryx.getKey(); 
				Map<Long,BigDecimal> value = entryx.getValue();  
				List<Remito> reclist = Remito.find.where()
  				   .eq("numero", key)
  				   .eq("recepcion.ordenProvision.ordenCompra.proveedor.id", proveedor_id)
  				   .findList();
  		
	     		if(reclist.size() > 0){
	     			lineasValidas = false;
					error += "<p class='responseError'>- El remito "+key+" ya se encuentra cargado para este proveedor</p>";
	     		}
			}

			
			List<String> arrListRemitos = new ArrayList<String>();
			List<String> arrListRemitosLineas = new ArrayList<String>();
			
		    String DATE_FORMAT = "yyyy-MM-dd";
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		    
		    SimpleDateFormat sdfWrite = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if(lineasValidas) {
				int cantidadDeRowProcesadas = 0;
				for (Map.Entry<String, Map<Long,BigDecimal>> entryx : datosACargar.entrySet()) { 
					String key = entryx.getKey(); 
					Map<Long,BigDecimal> value = entryx.getValue();  
					
					/*
					Remito r = new Remito();
					r.recepcion_id = idRecepcion;
					r.numero = key;
					r.fecha_remito = remitoFecha.get(key);
					r.create_date = new Date();
					r.create_usuario_id = (long) Usuario.getUsuarioSesion();
					r.save();
					*/
					
					
					System.out.println(sdf.format(remitoFecha.get(key)));
					Object[] arrCabecera = {idRecepcion, "'"+key+"'", Usuario.getUsuarioSesion(), "'"+sdf.format(remitoFecha.get(key))+"'", Usuario.getUsuarioSesion(),  "'"+sdfWrite.format(new Date())+"'"};
					arrListRemitos.add( Arrays.toString(arrCabecera).replace("[", "(").replace("]", ")") );
					
					
					//System.out.println("------------- "+ Arrays.toString(arr2).replace("[", "(").replace("]", ")"));
					
					

					for (Map.Entry<Long,BigDecimal> entryx2 : value.entrySet()) { 
						Long producto = entryx2.getKey(); 
						BigDecimal cantidad = entryx2.getValue();  
						
						Object[] arrLinea = {"'"+key+"'", cantidad, productoIdLineaOrdenCargadas.get(producto)};
						arrListRemitosLineas.add( Arrays.toString(arrLinea).replace("[", "(").replace("]", ")") );

					}
					
					cantidadDeRowProcesadas ++;
				}
				
				Statement stmt = connection.createStatement();
				connection.setAutoCommit(false);
				
				
				stmt.executeUpdate(""
						+ "with remitos as ( "
						+ "	    insert into remitos (recepcion_id, numero, create_usuario_id, fecha_remito, write_usuario_id, write_date) " 
						+ "			values "
						+ arrListRemitos.toString().replace("[", "").replace("]", "")  
						+ "	        returning *) "
						+ "	INSERT INTO remitos_lineas (remito_id, cantidad, linea_orden_id)  "
						+ "	SELECT r.id, rl.cantidad, rl.linea_orden_id from (values 	 "	  
						+ arrListRemitosLineas.toString().replace("[", "").replace("]", "")
						+ "	          ) as rl  (numero, cantidad, linea_orden_id)  "
						+ "	INNER JOIN remitos r ON r.numero = rl.numero "
						+ "");
				
	
				SqlQuery sqlCcantidad = Ebean.createSqlQuery(" with remitos as ("
						+" select SUM(rl.cantidad) cantidadRemito, rl.linea_orden_id from remitos r " 
						+" inner join remitos_lineas rl on rl.remito_id  = r.id "
						+" where r.recepcion_id = " + idRecepcion 
						+" group by linea_orden_id "
						+" )  "
						+" SELECT p.nombre, SUM(cargar.cantidad) cantidadCargar, SUM(COALESCE(cantidadRemito,0)) cantidadRemito, SUM(COALESCE(ol.cantidad,0)) cantidadOrden from  (values "
						+ arrListRemitosLineas.toString().replace("[", "").replace("]", "")
						+ " ) as cargar (numero, cantidad, linea_orden_id)  "  
						+" left join orden_lineas ol on ol.id = cargar.linea_orden_id "
						+" inner join productos p on p.id = ol.producto_id "
						+" left join remitos as r on r.linea_orden_id = cargar.linea_orden_id  "
						+" group by r.linea_orden_id, p.nombre "
						+" having (SUM(COALESCE(cantidadRemito,0)) + SUM(COALESCE(cargar.cantidad,0) )) > SUM( COALESCE(ol.cantidad,0) ) ");
				
				/*
				String sqlCcantidad = " select p.nombre, SUM(rl.cantidad) cantidad from orden_lineas ol " +
						" inner join productos p on p.id = ol.producto_id " +
						" inner join remitos_lineas rl on ol.id = rl.linea_orden_id " +
						" inner join remitos r on r.id = rl.remito_id " +
						" where r.recepcion_id = " + idRecepcion + 
						" group by ol.id, ol.cantidad, p.nombre " +
						" having SUM(rl.cantidad) > ol.cantidad";
				*/

				
				boolean errorCantidad = false;
				for (SqlRow row : sqlCcantidad.findList()) {
					error += "<p class='responseError'>- El producto "+row.getString("nombre")+" supera la cantidad de la orden que es "+ row.getString("cantidadOrden") +". <br />Cargados " + row.getInteger("cantidadRemito") + ". Intenta cargar " + row.getString("cantidadCargar") +" y da un total de " +  (row.getInteger("cantidadRemito") + row.getInteger("cantidadCargar")) + ".</p>";
					errorCantidad = true;
					connection.rollback();
				}


				if(!errorCantidad) {
					ok += "<p class='responseOk'>- Se ha procesado correctamente el archivo. Se procesaron "+cantidadDeRowProcesadas+" remitos.</p>";
					
					stmt.executeQuery("SELECT actualiza_totales_ordenes_recepcionados("+re.ordenProvision.id+")");
				
					connection.commit();
				} else {
					connection.rollback();					
				}

				stmt.close();
			}
			
			
			
		}catch(Exception e){
			error = "Error " + e;	
		} finally {
			
		}
		String ret = error+ok;
		return ok(ret);
		
	}
	
	public static Result descargarRemitosArchivoMasivo(Long recepcion_id) {
		
		
		List<Remito> remitos = Remito.find.where().eq("recepcion_id", recepcion_id).findList();
		
		File archivo = new File("remitos-recepcion-"+ recepcion_id +".xls");

		
        try {    
        	
    		
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
	        
	        Sheet hoja = libro.createSheet("Recepcion " + recepcion_id);
	        CreationHelper createHelper = libro.getCreationHelper(); 
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("numero");
			fila.createCell(1).setCellValue("fecha");
			fila.createCell(2).setCellValue("comprobante");
			fila.createCell(3).setCellValue("descripcion");
			fila.createCell(3).setCellValue("unidades");
			
			
			
			
			
			int f = 1;
			Cell celda;
			for (Remito r : remitos) {

				//Ebean.find(RemitoLinea.class).where().eq("remito_id", r.id).findList();
				
				for (RemitoLinea rl : r.lineas) {
					
					fila = hoja.createRow(f);
					celda = fila.createCell(0);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda.setCellValue(f);
					
					celda = fila.createCell(1);
					CreationHelper creationHelper = libro.getCreationHelper();
					CellStyle cellStyle = libro.createCellStyle();
					cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/MM/yyyy"));
					
					celda.setCellStyle(cellStyle);
					celda.setCellValue(utils.DateUtils.formatDate(r.fecha_remito));
					fila.createCell(2).setCellValue(r.numero);
					
					
					fila.createCell(3).setCellValue(rl.lineaOrden.producto.nombre);
					celda = fila.createCell(4);
					celda.setCellType(Cell.CELL_TYPE_NUMERIC);
					celda.setCellValue(rl.cantidad.doubleValue());
					f++;
				}
	
				
			}



			libro.write(archivoTmp);; 

            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok(archivo);
	}
	
	
}
