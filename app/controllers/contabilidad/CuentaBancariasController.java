package controllers.contabilidad;

import static play.data.Form.form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.h2.expression.ExpressionList;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Banco;
import models.Certificacion;
import models.CuentaBancaria;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.Pago;
import models.Solicitud;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.contabilidad.cuentaBancarias.*;

@Security.Authenticated(Secured.class)
public class CuentaBancariasController extends Controller {
	
	final static Form<CuentaBancaria> cuentaBancariaForm = form(CuentaBancaria.class);
	
	public static Result URL_LISTA_CUENTA_BANCARIA = redirect(
			controllers.contabilidad.routes.CuentaBancariasController.indexCuentaBancaria()
	);
	
	@CheckPermiso(key = "cuentasBancariasGeneral")
	public static Result indexCuentaBancaria() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				 indexCuentaBancaria.render(
						 CuentaBancaria.page(
								 RequestVar.get("nombreProveedor"),
								 RequestVar.get("numeroCuenta"),
								 RequestVar.get("btnFiltro[0]"),//borrador
								 RequestVar.get("btnFiltro[1]"),//en curso
								 RequestVar.get("btnFiltro[2]"),//aprobada
								 RequestVar.get("btnFiltro[3]")//cancelada
								 ),
								 d));
	}
	
	@CheckPermiso(key = "cuentasBancariasGeneral")
	public static Result crearCuentaBancaria() {
		Map<String,String> p = new HashMap<String, String>();
		p.put("estado_id",new Long(Estado.CUENTA_BANCARIA_ESTADO_BORRADOR).toString());
		Form<CuentaBancaria> cuentaBancariaForm = form(CuentaBancaria.class).bind(p);
		cuentaBancariaForm.discardErrors();
		return ok(crearCuentaBancaria.render(cuentaBancariaForm));
	}
	
	
	private static boolean existeCuentaPredeterminada(Form<CuentaBancaria> cuentaForm){
		boolean ret = false;
		 
		if(cuentaForm.data().containsKey("predeterminada")){
			
			com.avaje.ebean.ExpressionList<CuentaBancaria> e = CuentaBancaria.find.where();
			((com.avaje.ebean.ExpressionList<CuentaBancaria>) e).eq("proveedor_id",cuentaForm.get().proveedor_id);
			((com.avaje.ebean.ExpressionList<CuentaBancaria>) e).eq("predeterminada",cuentaForm.get().predeterminada);
			
			if(cuentaForm.get().id != null){
				((com.avaje.ebean.ExpressionList<CuentaBancaria>) e).ne("id",cuentaForm.get().id);
			}
			
			List<CuentaBancaria> cuentaBancariaList = ((com.avaje.ebean.ExpressionList<CuentaBancaria>) e).findList(); 
			 
			if(!cuentaBancariaList.isEmpty()){
				ret = true;
			}
		}
		return ret;
	}
	
	@CheckPermiso(key = "cuentasBancariasGeneral")
	public static Result guardarCuentaBancaria() {
		
		Form<CuentaBancaria> cuentaBancariaForm = form(CuentaBancaria.class).bindFromRequest();
		
		if(cuentaBancariaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearCuentaBancaria.render(cuentaBancariaForm));
		}
		
		try {
			if(existeCuentaPredeterminada(cuentaBancariaForm)){
				flash("error", "Error ya existe una cuenta predeterminada para este proveedor.");
				return badRequest(crearCuentaBancaria.render(cuentaBancariaForm));
			}
			CuentaBancaria c = cuentaBancariaForm.get();
			c.estado_id = new Long(Estado.CUENTA_BANCARIA_ESTADO_BORRADOR);
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.create_date = new Date();
			c.save();

			flash("success", "La Cuenta Bancaria se ha actualizado");
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la Cuenta Bancaria");
			return badRequest(crearCuentaBancaria.render(cuentaBancariaForm));
		}
		
		
		return URL_LISTA_CUENTA_BANCARIA;
	}
	
	@CheckPermiso(key = "cuentasBancariasGeneral")
	public static Result editarCuentaBancaria(Long id) {
		
		
		CuentaBancaria cuentaBancaria = Ebean.find(CuentaBancaria.class, id);
		
		if(cuentaBancaria.estado_id == Estado.CUENTA_BANCARIA_ESTADO_ENCURSO || cuentaBancaria.estado_id == Estado.CUENTA_BANCARIA_ESTADO_APROBADO || cuentaBancaria.estado_id == Estado.CUENTA_BANCARIA_ESTADO_CANCELADO){
			flash("error", "Solo se puede editar en estado borrador.");
			//return badRequest(editarCuentaBancaria.render(cuentaBancariaForm));
			return redirect(request().getHeader("referer"));
		}
		return ok(editarCuentaBancaria.render(cuentaBancariaForm.fill(cuentaBancaria)));
	}
	
	@CheckPermiso(key = "cuentasBancariasGeneral")
	public static Result actualizarCuentaBancaria(){
		
			Form<CuentaBancaria> cuentaBancariaForm = form(CuentaBancaria.class).bindFromRequest();
			if(cuentaBancariaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarCuentaBancaria.render(cuentaBancariaForm));
			}
			
			try {
				if(existeCuentaPredeterminada(cuentaBancariaForm)){
					flash("error", "Error ya existe una cuenta predeterminada para este proveedor.");
					return badRequest(editarCuentaBancaria.render(cuentaBancariaForm));
				}
				CuentaBancaria c = cuentaBancariaForm.get();
				c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				c.write_date = new Date();
				c.update();
				
				flash("success", "La Cuenta Bancaria se ha actualizado");
				return redirect( controllers.contabilidad.routes.CuentaBancariasController.ver(cuentaBancariaForm.get().id));		
			} catch (PersistenceException pe){
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido almacenar la Cuenta Bancaria");
				return badRequest(editarCuentaBancaria.render(cuentaBancariaForm));
			}
		//return URL_LISTA_CUENTA_BANCARIA;
	}
	
	@CheckPermiso(key = "cuentaBancariaEliminar")
	public static Result eliminarCuentaBancaria(Long id) {
		
			try {
				CuentaBancaria.find.byId(id).delete();
				flash("success", "Se ha eliminado la Cuenta Bancaria");
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar la Cuenta Bancaria");
			}
		return URL_LISTA_CUENTA_BANCARIA;
	}
	
	@CheckPermiso(key = "cuentasBancariasGeneral")
	public static Result ver(Long id) {
		CuentaBancaria c = CuentaBancaria.find.byId(id);
		Form<CuentaBancaria> cuentaBancariaForm = form(CuentaBancaria.class).fill(c);
		return ok(verCuentaBancaria.render(cuentaBancariaForm, c));
	}
	
	public static Result cambiarEstado(Long idCuenta, Long idEstado){
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_CUENTA_BANCARIA);
		
		CuentaBancaria c = CuentaBancaria.find.byId(idCuenta);
		
		if(c == null){
			flash("error", "No se encuentra la cuenta bancaria.");
			return URL_LISTA_CUENTA_BANCARIA;
		}
		
		if(idEstado != null){
			
			Boolean permiso = false;
			
			switch ( idEstado.intValue() ) {
				case  Estado.CUENTA_BANCARIA_ESTADO_BORRADOR:
					if(!Permiso.check("cuentaBancariaPasarBorrador")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarEnBorrador(c.id);
		    	break;
				case  Estado.CUENTA_BANCARIA_ESTADO_ENCURSO:
					if(!Permiso.check("cuentaBancariaPasarEnCurso")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarEnCurso(c.id);
			    break;
				case  Estado.CUENTA_BANCARIA_ESTADO_APROBADO:
					if(!Permiso.check("cuentaBancariaPasarAprobado")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarAprobado(c.id);
			    break;
				case  Estado.CUENTA_BANCARIA_ESTADO_CANCELADO:
					if(!Permiso.check("cuentaBancariaPasarCancelado")) {
						return ok(sinPermiso.render(request().getHeader("referer")));
					}
					pasarCancelado(c.id);
			    break;
				default:
			           break;
			}
			
			
		}
		return redirect(controllers.contabilidad.routes.CuentaBancariasController.ver(c.id));
	}
	
	public static void pasarEnBorrador(Long idCuentaBancaria){
		
		CuentaBancaria c = Ebean.find(CuentaBancaria.class).select("id, estado_id,activo,write_date,write_usuario_id").setId(idCuentaBancaria).findUnique();
		
		if(c != null){			
			
			c.activo = false;
			c.estado_id = new Long(Estado.CUENTA_BANCARIA_ESTADO_BORRADOR);
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.write_date = new Date();
			c.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
			
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	public static void pasarEnCurso(Long idCuentaBancaria){
		
		CuentaBancaria c = Ebean.find(CuentaBancaria.class).select("id, estado_id,activo,write_date,write_usuario_id").setId(idCuentaBancaria).findUnique();
		
		if(c != null){			
			c.activo = false;
			c.estado_id = new Long(Estado.CUENTA_BANCARIA_ESTADO_ENCURSO);
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.write_date = new Date();
			c.save();
			flash("success", "Operación exitosa. Estado actual: En Curso");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	public static void pasarAprobado(Long idCuentaBancaria){
		
		CuentaBancaria c = Ebean.find(CuentaBancaria.class).select("id, estado_id,activo,write_date,write_usuario_id").setId(idCuentaBancaria).findUnique();
		
		if(c != null){			
			
			List<CuentaBancaria> c2 = CuentaBancaria.find.where()
					.eq("proveedor_id",c.proveedor_id)
					.eq("estado_id",Estado.CUENTA_BANCARIA_ESTADO_APROBADO)
					.ne("id", c.id).findList();
			Logger.debug("gggggggggggg "+c2);
			
			if(c2 != null && c2.size() == 0){
				c.activo = true;
				c.estado_id = new Long(Estado.CUENTA_BANCARIA_ESTADO_APROBADO);
				c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				c.write_date = new Date();
				c.save();
				flash("success", "Operación exitosa. Estado actual: Aprobado");
			}else{
				flash("error", "Este proveedor ya tiene una cuenta aprobada.");
			}	
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	public static void pasarCancelado(Long idCuentaBancaria){
		
		CuentaBancaria c = Ebean.find(CuentaBancaria.class).select("id, estado_id,activo,write_date,write_usuario_id").setId(idCuentaBancaria).findUnique();
		
		if(c != null){			
			c.activo = false;
			c.estado_id = new Long(Estado.CUENTA_BANCARIA_ESTADO_CANCELADO);
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.write_date = new Date();
			c.fecha_cancelado = new Date();
			c.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	public static Result suggestCuentaBancaria(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode cuentaBancarias = rpta.arrayNode();
	    
	    CuentaBancaria ad = new CuentaBancaria();
		 
		for(CuentaBancaria a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.numero_cuenta);
	        restJs.put("info", "");
	        cuentaBancarias.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", cuentaBancarias);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		CuentaBancaria cuentaBancaria = CuentaBancaria.find.select("id, nombre, proveedor").where().eq("id", id).findUnique();
		
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(cuentaBancaria == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la Cuenta Bancaria");
		} else {
			restJs.put("success", true);
			restJs.put("id", cuentaBancaria.id);
			restJs.put("nombre", cuentaBancaria.numero_cuenta);
		}
		nodo.add(restJs);
		return ok(restJs);
	}
	
	public static Result modalBuscar() {
    	Pagination<CuentaBancaria> p = new Pagination<CuentaBancaria>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");	
    	p.setExpressionList(CuentaBancaria.find.fetch("proveedor").where().ilike("numero_cuenta", "%" + RequestVar.get("numero_cuenta") + "%"));
		return ok( modalBusquedaCuentaBancaria.render(p, form().bindFromRequest()) );
	}
	
	public static Result reporteDatosGenerales(){
		
		List<Integer> cuentasSeleccionados = getSeleccionados();
		
		if(cuentasSeleccionados.isEmpty()) {
			flash("error", "No se han seleccionado cuentas.");
			return ok(modalReporteDatos.render(null));
		}
		
		String error = "";
		Boolean hayError = false;
		
		try {
			
			String dirTemp = System.getProperty("java.io.tmpdir");
			File archivo = new File(dirTemp+"/lotes.xls");
			
			if(archivo.exists()) archivo.delete();
			
			archivo.createNewFile();
			
			List<CuentaBancaria> cuentas = CuentaBancaria.find.where().in("id", cuentasSeleccionados).findList();
			
			
			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			
			Sheet hoja = libro.createSheet("Lotes");
			
			Row fila = hoja.createRow(0);
			fila.createCell(0).setCellValue("Nombre");
			fila.createCell(1).setCellValue("Cuit");
			fila.createCell(2).setCellValue("Cuenta");
			fila.createCell(3).setCellValue("Fecha Baja");
			
			int f = 1; 
			for (CuentaBancaria cu : cuentas) {
					fila = hoja.createRow(f);
					for(int c=0;c<8;c++){
						Cell celda = fila.createCell(c);
						
						switch (c) {
						case 0:
							celda.setCellValue(cu.proveedor.agente.apellido);
							break;
						case 1:
							celda.setCellValue(cu.proveedor.agente.cuit);
							break;	
						case 2:
							celda.setCellValue(cu.numero_cuenta);
							break;		
						case 3:
							if(cu.fecha_cancelado != null){
								celda.setCellValue(utils.DateUtils.formatDate(cu.fecha_cancelado));
							}else{
								celda.setCellValue("");
							}
							break;		
						default:
							break;
						}
					}	
					f++;
			}
			
			libro.write(archivoTmp); 
			
			Writer out = new BufferedWriter(new OutputStreamWriter(archivoTmp, "UTF8"));
			out.flush();
			out.close();
			 
			flash("success", "El archivo fue creado correctamente.");
			return ok(modalReporteDatos.render(archivo.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
	}
	
	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("id_cuenta[]");
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
