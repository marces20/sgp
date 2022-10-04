package controllers.compras;

import static play.data.Form.form;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import models.BalancePresupuestario;
import models.Certificacion;
import models.CertificacionLinea;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.Producto;
import models.Proveedor;
import models.TipoCuenta;
import models.Usuario;
import models.auth.Permiso;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import play.mvc.Security;
import utils.ArrayUtils;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.sinPermiso;
import views.html.compras.certificaciones.crearCertificacion;
import views.html.compras.certificaciones.crearMasivo;
import views.html.compras.certificaciones.editarCertificacion;
import views.html.compras.certificaciones.indexCertificacion;
import views.html.compras.certificaciones.verCertificacion;
import views.html.compras.certificaciones.modales.modalEditarCuentaAnalitica;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class CertificacionesController extends Controller {
final static Form<Certificacion> certificacionForm = form(Certificacion.class);
	
	public static Result URL_LISTA_CERTIFICACION = redirect(
			controllers.compras.routes.CertificacionesController.index()
	);
	
	
	@CheckPermiso(key = "certificacionesVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();
		
		//Integer c = Certificacion.find.fetch("certificacionLinea").where().eq("id", 81).isNull("certificacionLinea.id").findRowCount();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		Integer c = CertificacionLinea.find.fetch("certificacion").where().isNull("id").findRowCount();

		return ok(
				indexCertificacion.render(
						Certificacion.page(
								 RequestVar.get("nombre"),
								 RequestVar.get("proveedor.id"),
								 RequestVar.get("expediente.id"),
								 RequestVar.get("fecha_certificacion_desde"),
								 RequestVar.get("fecha_certificacion_hasta"),
								 RequestVar.get("periodo_id"),
								 RequestVar.get("ejercicio"),
								 RequestVar.get("btnFiltro[0]"),//borrador
								 RequestVar.get("btnFiltro[1]"),//en curso
								 RequestVar.get("btnFiltro[2]"),//certificado
								 RequestVar.get("btnFiltro[3]"),//aprobado
								 RequestVar.get("btnFiltro[4]"),//cancelado
								 RequestVar.get("btnFiltro[5]"),//con descuentos
								 RequestVar.get("cm"),
								 RequestVar.get("tipo_cuenta_id")
								),
								 d, pf));
	}
	
	public static Result cambiarEstado(Long idCertificacion, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_CERTIFICACION);
		
		Certificacion certificacion = Certificacion.find.byId(idCertificacion);
		
		if(certificacion == null){
			flash("error", "No se encuentra la certificación.");
			return redirect(request().getHeader("referer"));
		}
		
		if((certificacion.expediente_id != null && certificacion.certificacionLinea.isEmpty()) && (idEstado != Estado.CERTIFICACION_ESTADO_CANCELADO && idEstado != Estado.CERTIFICACION_ESTADO_BORRADOR)){
			flash("error", "No se puede modificar el estado si no contiene lineas de productos.");
			return redirect(request().getHeader("referer"));
		}
		
		Integer sl = CertificacionLinea.find.where().eq("certificacion_id",certificacion.id).isNull("cuenta_analitica_id").findRowCount();
		if(sl > 0 ){
			flash("error", "No puede cambiar de estado con lineas que no contengan cuenta presupuestaria.");
			return redirect(request().getHeader("referer"));
		}
		
		if(idEstado != null){
			
			Boolean permiso = false;
			
			switch ( idEstado.intValue() ) {
		      case  Estado.CERTIFICACION_ESTADO_BORRADOR:
		    	  if(!Permiso.check("certificacionesPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(certificacion.id);
		    	  break;
		      case Estado.CERTIFICACION_ESTADO_ENCURSO:
		    	  if(!Permiso.check("certificacionesPasarCurso")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnCurso(certificacion.id);
		    	  break;       
		      case Estado.CERTIFICACION_ESTADO_CERTIFICADO:
		    	  if(!Permiso.check("certificacionesPasarCertificado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCertificado(certificacion.id); 
		    	  break;
		      case Estado.CERTIFICACION_ESTADO_IMPUTADO:
		    	  if(!Permiso.check("certificacionesPasarImputado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarImputado(certificacion.id); 
		    	  break;
		      case Estado.CERTIFICACION_ESTADO_CANCELADO:
		    	  if(!Permiso.check("certificacionesPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(certificacion.id);   
		          break;
		      default:
		           break;
		      }
			  
		}	 
		
		return redirect(controllers.compras.routes.CertificacionesController.ver(certificacion.id)+ UriTrack.get("&"));
	}
	
	@CheckPermiso(key = "certificacionesVer")
	public static Result ver(Long id) {
		 
		Certificacion certificacion = Certificacion.find.byId(id);
		
		if(!Permiso.check("verExpedientesGuardiasMonotributo") && ArrayUtils.contains(Expediente.EXP_GUARDIA_MONOTRIBUTOS, certificacion.expediente_id)){
			return URL_LISTA_CERTIFICACION;
		}
					
		Form<Certificacion> certificacionForm = form(Certificacion.class).fill(certificacion);
		return ok(verCertificacion.render(certificacionForm, certificacion, new PaginadorFicha(UriTrack.code())));
	}
	
	@CheckPermiso(key = "certificacionesCrear")
	public static Result crear() {
		
		Map<String,String> p = new HashMap<String, String>();
		p.put("nombre","CER");
		Form<Certificacion> certificacionForm = form(Certificacion.class).bind(p);
		certificacionForm.discardErrors();
		
		return ok(crearCertificacion.render(certificacionForm));
	}
	
	@CheckPermiso(key = "certificacionesCrear")
	public static Result guardar() {
		
		Form<Certificacion> certificacionForm = form(Certificacion.class).bindFromRequest();
		
		validarForm(certificacionForm);
		
		if(certificacionForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearCertificacion.render(certificacionForm));
		}
		
		try {
			Certificacion c = certificacionForm.get();
			c.create_date = new Date();
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.save();
			
			flash("success", "La certificacion se ha actualizado");
			return redirect( controllers.compras.routes.CertificacionesController.ver(certificacionForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la certificacion");
			return badRequest(crearCertificacion.render(certificacionForm));
		}
		//return URL_LISTA_CERTIFICACION;
	}
	
	@CheckPermiso(key = "certificacionesModificar")
	public static Result editar(Long id) {
		Certificacion certificacion = Certificacion.find.byId(id);
		
		if(!Permiso.check("verExpedientesGuardiasMonotributo") && ArrayUtils.contains(Expediente.EXP_GUARDIA_MONOTRIBUTOS, certificacion.expediente_id)){
			return URL_LISTA_CERTIFICACION;
		}
		
		if(certificacion  == null){
			flash("error", "No se encuentra la certificacion.");
			return redirect(controllers.compras.routes.CertificacionesController.index()+UriTrack.get("?"));
		}else if(certificacion.estado_id == Estado.CERTIFICACION_ESTADO_CERTIFICADO || certificacion.estado_id == Estado.CERTIFICACION_ESTADO_CANCELADO || certificacion.estado_id == Estado.CERTIFICACION_ESTADO_IMPUTADO){
			flash("error", "La certificación no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}
		
		
		return ok(editarCertificacion.render(certificacionForm.fill(certificacion),certificacion));
	}
	
	@CheckPermiso(key = "certificacionesModificar")
	public static Result actualizar(Long id){
		
		Form<Certificacion> certificacionForm = form(Certificacion.class).bindFromRequest();
		validarForm(certificacionForm);
		Certificacion certificacion = Ebean.find(Certificacion.class, id);
		
		if(certificacionForm.hasErrors()) {
			System.out.println(certificacionForm.errors());
			flash("error", "Error en formulario");
			return badRequest(editarCertificacion.render(certificacionForm,certificacion));
		}
		
		try {
			Certificacion c = certificacionForm.get();
			c.estado_id = certificacion.estado_id;
			c.write_date = new Date();
			c.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.update();
			flash("success", "La certificacion se ha actualizado");
			return redirect( controllers.compras.routes.CertificacionesController.ver(certificacionForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la certificacion");
			return badRequest(editarCertificacion.render(certificacionForm,certificacion));
		}
		
		//return URL_LISTA_CERTIFICACION;
	}
	
	@CheckPermiso(key = "certificacionesEliminar")
	public static Result eliminar(Long id) {
		
		Certificacion certificacion = Ebean.find(Certificacion.class).select("id, estado_id").setId(id).findUnique();
		
		if(certificacion == null){
			flash("error", "No se encuentra la certificación.");
			return redirect(controllers.compras.routes.CertificacionesController.index()+UriTrack.get("?"));
		}
		
		if(certificacion.estado_id == Estado.CERTIFICACION_ESTADO_BORRADOR || certificacion.estado_id == Estado.CERTIFICACION_ESTADO_CANCELADO){
			try {
				certificacion.delete();
				flash("success", "Se ha eliminado la certificación");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar la certificación");
			}
		} else {
			flash("error", "No se ha podido eliminar la certificación. Unicamente se puede eliminar cuando el estado de la certificacion se encuentra en borrador o cancelado.");
		}

		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	public static void validarForm(Form<Certificacion> filledForm){
		Validator v = new Validator(filledForm);
		v.add(new DateValidation("fecha_certificacion", "Fecha inválida"));
		v.validate();
	}
	
	public static void pasarEnBorrador(Long idCertificacion){
		
		Certificacion certificacion = Ebean.find(Certificacion.class).select("id, estado_id,write_date,write_usuario_id").setId(idCertificacion).findUnique();
		
		if(certificacion != null){			
			certificacion.estado_id = new Long(Estado.CERTIFICACION_ESTADO_BORRADOR);
			certificacion.write_date = new Date();
			certificacion.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			certificacion.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	@CheckPermiso(key = "certificacionesPasarEnCurso")
	public static void pasarEnCurso(Long idCertificacion){
		
		Certificacion certificacion = Ebean.find(Certificacion.class).select("id, estado_id,write_date,write_usuario_id").setId(idCertificacion).findUnique();
																									   
		if(certificacion != null){			
			certificacion.estado_id = new Long(Estado.CERTIFICACION_ESTADO_ENCURSO);
			certificacion.write_date = new Date();
			certificacion.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			certificacion.save();
			flash("success", "Operación exitosa. Estado actual: En Curso");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	public static void pasarCertificado(Long idCertificacion){
		
		Certificacion certificacion = Ebean.find(Certificacion.class).select("id, estado_id,fecha_certificacion,expediente_id,write_date,write_usuario_id,proveedor_id,periodo_id").setId(idCertificacion).findUnique();
		
		if(certificacion != null){	
			boolean ordenOk = true;
			String error = "";
			//Control para ver si existe factura con mismo agente, mismo proveedor, mismo periodo
			List<Certificacion> certificacionnes = Certificacion.find.where().isNotNull("proveedor.agente_id").eq("proveedor_id", certificacion.proveedor_id).eq("periodo_id", certificacion.periodo_id).eq("expediente_id", certificacion.expediente_id).ne("estado_id", Estado.CERTIFICACION_ESTADO_CANCELADO).ne("estado_id", Estado.CERTIFICACION_ESTADO_BORRADOR).findList();
			
			/*
			if(certificacionnes.size() > 1) {
				flash("error", "No se puede aprobar una certificación con el mismo expediente, periodo y agente.");
				return;
			}
			*/
			List<Integer> co = new ArrayList<Integer>();
			co.add(certificacion.id.intValue());
			if(!Certificacion.soloCuentasAnliticasHijas(co)){
				flash("error", "Las cuentas presupuestarias deben ser Hijas unicamente.");
				return;
			}
			
			certificacion.fecha_certificacion = new Date();
			certificacion.estado_id = new Long(Estado.CERTIFICACION_ESTADO_CERTIFICADO);
			certificacion.write_date = new Date();
			certificacion.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			certificacion.save();
			flash("success", "Operación exitosa. Estado actual: Certificado<br>");
				
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	public static void pasarImputado(Long idCertificacion){
		
		Certificacion certificacion = Ebean.find(Certificacion.class).select("id, estado_id,write_date,write_usuario_id").setId(idCertificacion).findUnique();
		
		if(certificacion != null){	
			
			
			List<Integer> cco = new ArrayList<Integer>();
			cco.add(certificacion.id.intValue());
			
			ArrayNode a = BalancePresupuestario.controlSaldoDefinitivo(cco);
			boolean errorControl =  false;
			String aviso = "";
			for(JsonNode o :a){
				boolean success = new Boolean(o.get("success").toString());
				String cuenta = o.get("cuenta").toString();
				String expediente = o.get("expediente").toString();
				BigDecimal saldoDisponible =  new BigDecimal(o.get("saldoDisponible").toString());
				BigDecimal saldoAImputar =  new BigDecimal(o.get("saldoAImputar").toString());
				BigDecimal saldoPresente =  new BigDecimal(o.get("saldoPresente").toString());
				
				if(!success){
					errorControl =  true;
					aviso += "No tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
					aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
					aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
					aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
				}else{
					aviso += "Tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
					aviso += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
					aviso += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
					aviso += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
				}
			}
			
			if(errorControl){
				flash("error", aviso);
			}else{
				certificacion.estado_id = new Long(Estado.CERTIFICACION_ESTADO_IMPUTADO);
				certificacion.write_date = new Date();
				certificacion.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				certificacion.save();
				flash("success", "Operación exitosa. Estado actual: Aprobado<br>"+aviso);
			}
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	public static void pasarCancelado(Long idCertificacion){
		
		Certificacion certificacion = Ebean.find(Certificacion.class).select("id, estado_id,write_date,write_usuario_id").setId(idCertificacion).findUnique();
		
		boolean certificacionOk = true;
		String error = "";
		Integer tieneFacturas = Factura.find.where().eq("certificacion_id",certificacion.id).findRowCount();
		if(tieneFacturas > 0){
			certificacionOk = false;
			error = "No se puede cancelar la certificación porque tiene facturas asociadas.";
		}
		
		if(certificacion != null && certificacionOk){			
			certificacion.estado_id = new Long(Estado.CERTIFICACION_ESTADO_CANCELADO);
			certificacion.write_date = new Date();
			certificacion.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			certificacion.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos. "+error);
		}

	}
	
	@CheckPermiso(key = "certificacionesEditarCuentaAnalitica")
	public static Result editarCuentaAnalitica() {
		 
		String ret = "";
		String Error = "";
		String[] certificaciones;
		if(request().body().asFormUrlEncoded().get("check_listado[]") != null){ 
			
			certificaciones = request().body().asFormUrlEncoded().get("check_listado[]");	
		}else if(request().body().asFormUrlEncoded().get("id") != null){
			certificaciones = request().body().asFormUrlEncoded().get("id");	
		}else{
			Error += "<p class='responseError'>- No se encuentra seleccionada una certificación.</p>";
			return ok( Error+ret );
		}
		
		
		for (String idCertificacion : certificaciones) {
			Certificacion certificacion = Ebean.find(Certificacion.class).select("id, estado_id,write_date,write_usuario_id").setId(Integer.parseInt(idCertificacion)).findUnique();
			
			if(certificacion.estado_id != Estado.CERTIFICACION_ESTADO_IMPUTADO){
				Integer cuentaId = Integer.parseInt(request().body().asFormUrlEncoded().get("cuentaAnalitica_id")[0]);
				
				Ebean.createUpdate(CertificacionLinea.class, "UPDATE certificaciones_lineas " +
						"SET cuenta_analitica_id=:cuenta_analitica_id,write_date = :write_date,write_usuario_id = :write_usuario_id " +
						"WHERE certificacion_id=:id")
				.setParameter("cuenta_analitica_id",cuentaId)
				.setParameter("write_date",new Date())
				.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()))
				.setParameter("id", Integer.parseInt(idCertificacion)).execute();

				ret += "<p class='responseOk'>- Se actualiz&oacute; la certificación "+certificacion.nombre+".</p>";
			
			}else{
				Error += "<p class='responseError'>- No se puede actualizar la certificación "+certificacion.nombre+" porque se encuentra en estado APROBADO.</p>";
			}
			
		}
		
		
		return ok( Error+ret );
	}
	
	public static Result modalEditarCuentaAnalica() {
    	
		return ok( modalEditarCuentaAnalitica.render(form().bindFromRequest()) );
	}
	
	
	@CheckPermiso(key = "certificacionesDuplicar")
	public static Result duplicar(Long id) throws IOException{
		
		try {
			
			Certificacion c = new Certificacion();
			
			Long idNew = c.duplicar(id);
			if(idNew != -1 && idNew != 0){
				flash("success", "Se ha duplicado la certificacion");
				return redirect(controllers.compras.routes.CertificacionesController.editar(idNew) + UriTrack.get("&"));
			}else{
				flash("error", "No se ha podido duplicar la certificacion");
				String refererUrl = request().getHeader("referer");
				return redirect(refererUrl);
			}
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido duplicar la certificacion");
		}
		
		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}
	
	@CheckPermiso(key = "certificacionesCrearGuardiasMonosMasivos")
	public static Result crearMasivo () {
		Form<Certificacion> nForm = form(Certificacion.class);
		return ok(crearMasivo.render(nForm, null));
	}
	
	public static Result procesarMasivo() {
		
		Form<Certificacion> nForm = form(Certificacion.class).bindFromRequest();
		HashMap<String, List<String>> errores = new HashMap<String, List<String>>();
		MultipartFormData body = request().body().asMultipartFormData();
		Map<String, String[]> formData = request().body().asFormUrlEncoded();
		List<String> msgArchivo = new ArrayList<String>();
		List<String> msgCuit = new ArrayList<String>();
		List<String> msgConcepto = new ArrayList<String>();
		
		String algo = "";
		File file;
		
		Long periodoId = null;
		Long expedienteId = null;
		
		if (nForm.data().get("periodo_id").isEmpty()) {
	    	nForm.reject("periodo_id", "Debe seleccionar periodo.");
			return ok(crearMasivo.render(nForm, null));
	    }
		
	    if (nForm.data().get("expediente_id").isEmpty()) {
	    	nForm.reject("expediente_id", "Debe seleccionar expediente.");
			return ok(crearMasivo.render(nForm, null));
	    }
	   
	    
	    
		try {
			FilePart upload = body.getFile("archivo");
			file = upload.getFile();
		} catch (NullPointerException n) {
			nForm.reject("archivo", "Debe seleccionar un archivo");
			return ok(crearMasivo.render(nForm, null));
		} 
		

	    periodoId = new Long (nForm.data().get("periodo_id"));
	    expedienteId = new Long (nForm.data().get("expediente_id"));
	    
	    
	    Integer contador = 0;
	    Integer cargas = 0;
	    Integer actualizaciones = 0;
	    Ebean.beginTransaction();		
	    try{
	    	FileInputStream input = new FileInputStream(file.getAbsolutePath());
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Row row;
			
			
			String repe = "";
			Boolean cargar = true;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				
				Boolean pasar = false;
				String cuit = null;
				//Long codigo = null;
				String nombreProducto = null;
				BigDecimal cantidad = null;
				BigDecimal importe = null;
				Long ordenId = null;
				row = sheet.getRow(i);
				
				//Valido si alguna celda se encuentra vacía
				try { row.getCell(1).getCellType(); } catch (Exception e) { msgArchivo.add("Linea "+(i + 1)+". El CUIT se encuentra vacío."); pasar = true; }
				//try { row.getCell(2).getCellType(); } catch (Exception e) { msgArchivo.add("Linea "+(i + 1)+". El CODIGO se encuentra vacío."); pasar = true; }
				try { row.getCell(2).getCellType(); } catch (Exception e) { msgArchivo.add("Linea "+(i + 1)+". El Nombre del Producto se encuentra vacío."); pasar = true; }

				try { row.getCell(3).getCellType(); } catch (Exception e) { msgArchivo.add("Linea "+(i + 1)+". La CANTIDAD se encuentra vacío."); pasar = true; }
				try { row.getCell(4).getCellType(); } catch (Exception e) { msgArchivo.add("Linea "+(i + 1)+". El MONTO se encuentra vacío."); pasar = true; }
				try { row.getCell(5).getCellType(); } catch (Exception e) { msgArchivo.add("Linea "+(i + 1)+". La orden encuentra vacío."); pasar = true; }
				if(pasar) {
					cargar = false;
					continue;
				}
				
				//Compruebo si el tipo de celda de cuit es numérico y luego la paso a string
				if(Cell.CELL_TYPE_NUMERIC == row.getCell(1).getCellType()) {
					Double c = row.getCell(1).getNumericCellValue();
					DecimalFormat decimalFormat = new DecimalFormat(".");
					decimalFormat.setGroupingUsed(false);
					decimalFormat.setDecimalSeparatorAlwaysShown(false);
					cuit = decimalFormat.format(c);
				} else {
					msgArchivo.add("Linea "+(i + 1)+". La celda de CUIT debe ser formato numérico.");
					 pasar = true;
				}
				
				//Compruebo si el tipo de celda de codigo es numérico y luego la paso a integer
				if(Cell.CELL_TYPE_STRING == row.getCell(2).getCellType()) {
					String c = row.getCell(2).getStringCellValue();
					nombreProducto = c;
				} else {
					msgArchivo.add("Linea "+(i + 1)+". La celda de CODIGO no debe ser formato numérico.");
					 pasar = true;
				}
				
				//Compruebo si el tipo de celda de cantidad es numérico y luego la paso a BigDecimal
				if(Cell.CELL_TYPE_NUMERIC == row.getCell(3).getCellType()) {
					cantidad = new BigDecimal(row.getCell(3).getNumericCellValue()).setScale(2, RoundingMode.HALF_DOWN);;
				} else {
					msgArchivo.add("Linea "+(i + 1)+". La celda de CANTIDAD debe ser formato numérico.");
					 pasar = true;
				}
			 	
				//Compruebo si el tipo de celda de importe es numérico y luego la paso a BigDecimal
				if(Cell.CELL_TYPE_NUMERIC == row.getCell(4).getCellType()) {
					importe = new BigDecimal(row.getCell(4).getNumericCellValue()).setScale(2, RoundingMode.HALF_DOWN);
				} else {
					msgArchivo.add("Linea "+(i + 1)+". La celda de IMPORTE debe ser formato numérico.");
					 pasar = true;
				}
				
				//Compruebo si el tipo de celda de importe es numérico y luego la paso a BigDecimal
				if(Cell.CELL_TYPE_NUMERIC == row.getCell(5).getCellType()) {
					Integer f = (int) row.getCell(5).getNumericCellValue();
					ordenId = new Long(f);
				} else {
					msgArchivo.add("Linea "+(i + 1)+". La celda de ORDEN debe ser formato numérico.");
					 pasar = true;
				}
				
				

				if(pasar) {
					System.out.println("paaaaasa");
					cargar = false;
					continue;
				}
				
				Long ccc = new Long(cuit);
				Proveedor proveedor = Proveedor.find.where().eq("cuit",ccc ).findUnique();
				
				if(proveedor == null) {
					msgCuit.add("Linea "+(i + 1)+". El puesto laboral con CUIT <b>"+cuit+"</b> no se encuentra en el sistema.");
					pasar = true;
				}
				
				//Busco y compruebo si el concepto se encuentra en el sistema
				//LiquidacionConcepto concepto = LiquidacionConcepto.find.where().eq("codigo", codigo).findUnique();
				
				Producto producto = Producto.find.where().eq("nombre", nombreProducto).findUnique();
				if(producto == null) {
					msgConcepto.add("Linea "+(i + 1)+". El nombre del producto <b>"+nombreProducto+"</b> no se encuentra en el sistema.");
					pasar = true;
				}
				
				if(pasar) {
					cargar = false;
					System.out.println("-------------------");
					continue;
					
				}
				
				
				if(cargar) {
					 
					Certificacion cxl = Certificacion.find.where()
									  .eq("periodo_id", periodoId)
									  .eq("proveedor_id", proveedor.id)
									  .eq("expediente_id", expedienteId)
									  .findUnique();
					
					Long cuentaAnaliticaId = new Long(178);
					if(proveedor.agente.tipo_relacion_laboral.compareToIgnoreCase("1") != 0 && proveedor.agente.tipo_relacion_laboral.compareToIgnoreCase("5") != 0 && proveedor.agente.tipo_relacion_laboral.compareToIgnoreCase("2") != 0){
						cuentaAnaliticaId = new Long(222);
					}
					
					if(cxl != null){
						CertificacionLinea ccl = new CertificacionLinea();
						ccl.cantidad = cantidad;
						ccl.certificacion_id = cxl.id;
						ccl.create_date = new Date();
						ccl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						ccl.cuenta_analitica_id = new Long(178);
						//ccl.precio = producto.precio_coste.setScale(2, RoundingMode.HALF_DOWN); 
						ccl.precio = importe.setScale(2, RoundingMode.HALF_DOWN); 						
						ccl.producto_id = producto.id;
						ccl.udm_id = new Long(1);
						ccl.save();
						cargas++;
					}else{
						Certificacion cc = new Certificacion();
						cc.profe = false;
						cc.creacion_automatica = true;
						cc.create_date = new Date();
						cc.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						cc.estado_id = (long) Estado.CERTIFICACION_ESTADO_BORRADOR;
						cc.expediente_id = expedienteId;
						cc.periodo_id = periodoId;
						cc.proveedor_id = proveedor.id;
						cc.orden_id = ordenId;
						cc.tipo_cuenta_id = TipoCuenta.OPERATIVA;
						cc.save();
						
						CertificacionLinea ccl = new CertificacionLinea();
						ccl.cantidad = cantidad;
						ccl.certificacion_id = cc.id;
						ccl.create_date = new Date();
						ccl.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						ccl.cuenta_analitica_id = new Long(178);
						//ccl.precio = producto.precio_coste.setScale(2, RoundingMode.HALF_DOWN); 
						ccl.precio = importe.setScale(2, RoundingMode.HALF_DOWN); 
						ccl.producto_id = producto.id;
						ccl.udm_id = new Long(1);
						ccl.save();
						cargas++;
					}
				}
				
				contador++;
			}
			
			
			errores.put("archivo", msgArchivo);
			errores.put("concepto", msgConcepto);
			errores.put("cuit", msgCuit);
			
			if(cargar) {
				flash("success", "Se han creado <b>("+cargas+")</b> novedades y <b>("+actualizaciones+")</b> fueron acutalizadas." + repe);
				Ebean.commitTransaction();
			} else {
				Ebean.rollbackTransaction();
				flash("error", "Se han encontrado algunos errores. Corríjalos y vuelva a importar el archivo.");
			} 
			
			
	    } catch(Exception x){
	    	Ebean.rollbackTransaction();
	    	Logger.debug("333333333333 "+x.getMessage());
	    	flash("error", x.getMessage());
		} finally {
			Ebean.endTransaction();  
		}
	    
	   
	    return ok(crearMasivo.render(nForm, errores));
	}
}
