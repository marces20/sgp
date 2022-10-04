package controllers.compras;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.PersistenceException;

import models.BalancePresupuestario;
import models.CajaChica;
import models.CajaChicaMovimiento;
import models.CajaChicaPresupuestoLinea;
import models.Estado;
import models.Orden;
import models.OrdenPagoCircuito;
import models.Solicitud;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.math.BigDecimal;

import utils.DateUtils;
import utils.EncondeUriBase64;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.PaginadorFicha;
import utils.pagination.Pagination;
import utils.validation.DateValidation;
import utils.validation.Validator;
import views.html.sinPermiso;
import views.html.compras.cajaChica.*;
import views.html.compras.cajaChica.movimientos.*;
import views.html.compras.solicitudes.modales.modalReporteImputacionPreventiva;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

@Security.Authenticated(Secured.class)
public class CajaChicaController extends Controller {
	
	final static Form<CajaChica> cajaForm = form(CajaChica.class);

	public static Result redirectSearchIndex(String searchIndex) throws IOException{
		String search = EncondeUriBase64.dencode(searchIndex);
		
		return redirect(search);
	}
	
	@CheckPermiso(key = "cajaChicaVer")
	public static Result index() {		
		DynamicForm d = form().bindFromRequest();
		PaginadorFicha pf = new PaginadorFicha(UriTrack.encodeUri());
		
		return ok(
				 index.render(
		 				CajaChica.page(
							 RequestVar.get("referencia"),
							 RequestVar.get("expediente_id"),
							 RequestVar.get("estado"),
							 RequestVar.get("fecha_caja_desde"),
							 RequestVar.get("fecha_caja_hasta"),
							 RequestVar.get("btnFiltro[0]"),
							 RequestVar.get("btnFiltro[1]"),
							 RequestVar.get("btnFiltro[2]"),
							 RequestVar.get("btnFiltro[3]"),
							 RequestVar.get("deposito_id"),
							 RequestVar.get("cheque"),
							 RequestVar.get("ordenPago.id"),
							 RequestVar.get("ejercicio")
							 ),
		 				d,
		 				pf
		 			  )
				);

	}
	
	@CheckPermiso(key = "cajaChicaVer")
	public static Result ver(Long id) {	
		CajaChica caja = CajaChica.find.byId(id);
		
		if(caja != null) {
			
			if(!caja.controlPermisoDeposito()) {
				flash("error", "La institucion de la caja no corresponde a su institucion asignada.");
				return redirect(controllers.compras.routes.CajaChicaController.index()+UriTrack.get("?"));
			}
			
			Form<CajaChica> cajaF = cajaForm.fill(caja);
			
			return ok(ver.render(caja, new PaginadorFicha(UriTrack.code()),cajaF));
			
		}else{
			flash("error", "No se encuentra la caja chica");
			return redirect(controllers.compras.routes.CajaChicaController.index()+UriTrack.get("?"));
		}
		
		
		
	}
	
	@CheckPermiso(key = "cajaChicaCrear")
	public static Result crear() {
		Map<String,String> p = new HashMap<String, String>();
		p.put("nombre","CJ");
		p.put("cuenta_propia_id","2");
		p.put("cuentaPropia.numero","300109408769227");
		
		Form<CajaChica> cajaForm = form(CajaChica.class).bind(p);
		cajaForm.discardErrors();
		 
		
		return ok(crearCajaChica.render(cajaForm));
	}
	
	
	@CheckPermiso(key = "cajaChicaCrear")
	public static Result guardar() {
		
		Form<CajaChica> cajaChicaForm = form(CajaChica.class).bindFromRequest();

		if(cajaChicaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearCajaChica.render(cajaChicaForm));
		}
		
		try {
			CajaChica c = cajaChicaForm.get();
			
			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return badRequest(crearCajaChica.render(cajaChicaForm));
			}
			
			List<CajaChica> cc = CajaChica.find.where()
						   .eq("deposito_id", c.deposito_id)
						   .disjunction()
						   .eq("estado_id", Estado.CAJA_CHICA_ABIERTA)
						   .eq("estado_id", Estado.CAJA_CHICA_BORRADOR)
						   .endJunction().findList();
			if(cc.size() > 0) {
				flash("error", "No se pueden crena ya que existen otras cajas chicas para esta Institucion en estado ABIERTO o BORRADOR.");
				return badRequest(crearCajaChica.render(cajaChicaForm));
			}
			
			
			
			c.create_date = new Date();
			c.estado_id = (long) Estado.CAJA_CHICA_BORRADOR;
			c.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			c.save();
			
			flash("success", "La caja chica se ha creado");
			return redirect( controllers.compras.routes.CajaChicaController.ver(cajaChicaForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido crear la caja chica.");
			return badRequest(crearCajaChica.render(cajaChicaForm));
		}

	}
	
	@CheckPermiso(key = "cajaChicaModificar")
	public static Result editar(Long id) {
		CajaChica caja = CajaChica.find.byId(id);

		if(caja  == null){
			flash("error", "No se encuentra la caja.");
			return redirect(controllers.compras.routes.CajaChicaController.index()+UriTrack.get("?"));
		}else if(caja.estado_id == Estado.CAJA_CHICA_CANCELADA || caja.estado_id == Estado.CAJA_CHICA_CERRADA){
			flash("error", "La caja no se puede editar en este Estado. Debe cambiar su estado a borrador.");
			return redirect(request().getHeader("referer"));
		}else if(!caja.controlPermisoDeposito()) {
			flash("error", "La institucion de la caja no corresponde a su institucion asignada.");
			return redirect(controllers.compras.routes.CajaChicaController.index()+UriTrack.get("?"));
		}
		
		return ok( editarCajaChica.render(cajaForm.fill(caja),caja) );
	}
	
	@CheckPermiso(key = "cajaChicaModificar")
	public static Result actualizar(Long id){


		Form<CajaChica> cajaForm = form(CajaChica.class).bindFromRequest();
		CajaChica cc = Ebean.find(CajaChica.class, id); 
		
		if(cajaForm.hasErrors()) {
			flash("error", "Error en formulario.");
			return badRequest(editarCajaChica.render(cajaForm,cc));
		}
 
		try {
			cc =  cajaForm.get();
			
			if(!cc.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return badRequest(editarCajaChica.render(cajaForm,cc));
			}
			cc.write_usuario_id =  new Long(Usuario.getUsuarioSesion());
			cc.write_date = new Date();
			cc.update();
			
			flash("success", "La información se ha actualizado.");
			return redirect( controllers.compras.routes.CajaChicaController.ver(cajaForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido modificar la información.");
			return badRequest(editarCajaChica.render(cajaForm,cc));
		}
		
		
	}
	
	
	@CheckPermiso(key = "cajaChicaEliminar")
	public static Result eliminar(Long id) {
		
		CajaChica caja = Ebean.find(CajaChica.class).select("id, estado_id").setId(id).where().eq("id", id).findUnique();
		
		if(caja == null){
			flash("error", "No se encuentra el registro.");
			return redirect(controllers.compras.routes.CajaChicaController.index()+UriTrack.get("?"));
		}
		
		if(caja.estado_id == Estado.CAJA_CHICA_BORRADOR){
			try {
				caja.delete();
				flash("success", "Se ha eliminado la caja chica.");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar la caja.");
			}
		} else {
			flash("error", "Unicamente se puede eliminar cuando el estado se encuentra en borrador.");
		}

		return redirect(request().getHeader("referer"));
	}
	
	public static Result cambiarEstado(Long id, Long idEstado) {
		CajaChica c = CajaChica.find.byId(id);
		
		if(c == null){
			flash("error", "No se encuentra la caja chica.");
			return redirect(request().getHeader("referer"));
		}

		/*if((c.movimientos.isEmpty()) && idEstado != Estado.CAJA_CHICA_BORRADOR && idEstado != Estado.ORDEN_ESTADO_CANCELADO){
			flash("error", "No se puede modificar el estado si no contiene movimientos.");
			return redirect(request().getHeader("referer"));
		}*/
		
		if(!c.controlPermisoDeposito()) {
			flash("error", "La institucion no corresponde a su institucion asignada.");
			return redirect(request().getHeader("referer"));
		}
		
		
		if(idEstado != null){
			Boolean permiso = false;
			
	  		/*Solicitud s = Solicitud.find.select("id, caja_chica_id").where()
					.eq("caja_chica_id", id)
					.findUnique();
			
			if(s != null) {
				flash("error", "Existe una solicitud que hace referencia a esta caja chica.");
				return redirect(request().getHeader("referer"));
			}*/	
			
			switch ( idEstado.intValue() ) {
		      case  Estado.CAJA_CHICA_BORRADOR:
		    	  if(!Permiso.check("cajaChicaPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(c.id);
		    	  break;
		    	  
		      case Estado.CAJA_CHICA_CANCELADA:
		    	  if(!Permiso.check("cajaChicaPasarCancelado")) {
		    		  
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  
		    	  List<OrdenPagoCircuito> opc = OrdenPagoCircuito.find.where().eq("orden_pago_id", c.orden_pago_id).findList();
		    	  if(opc.size() > 0) {
		    		  flash("error", "La Orden de Pago asociada esta en el circuito de Ordenes de Pagos. Debe eliminar la Orden del circuito.");
			  			return redirect(request().getHeader("referer"));
		    	  }
		    	  
		    	  pasarCancelado(c.id);   
		          break;
		      case Estado.CAJA_CHICA_ABIERTA:
		    	  if(!Permiso.check("cajaChicaPasarAbierta")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarAbierta(c.id); 
		    	  break;
		      case Estado.CAJA_CHICA_CERRADA:
		    	  if(!Permiso.check("cajaChicaPasarCerrada")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  if(c.orden_pago_id == null) {
		  			flash("error", "Debe cargar una Orden de Pago");
		  			return redirect(request().getHeader("referer"));
		  		  }
		    	  
		    	  pasarCerrada(c.id); 
		    	  break;
			}
		}
		return redirect(controllers.compras.routes.CajaChicaController.ver(c.id)+UriTrack.get("&"));
	}


	public static void pasarEnBorrador(Long id) {
		CajaChica c = Ebean.find(CajaChica.class).select("id, estado_id").setId(id).findUnique();
		
		if(c != null){
			c.estado_id = new Long(Estado.CAJA_CHICA_BORRADOR);
			c.write_usuario_id =  new Long(Usuario.getUsuarioSesion());
			c.write_date = new Date();
			c.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	public static void pasarAbierta(Long id) {
		CajaChica c = CajaChica.find.byId(id);
		
		if(c != null){
			
			if(c.numero_cheque == null){
				flash("error", "Debe ingresar N° cheque");
			}else if(c.deposito_id == null){
				flash("error", "Debe ingresar Institucion");
			}else if(c.cuenta_propia_id == null){
				flash("error", "Debe ingresar N° cuenta");
			}else if(c.expediente_id == null){
				flash("error", "Debe ingresar Expediente");
			}else if(c.fecha == null){
				flash("error", "Debe ingresar fecha");
			}else if(c.monto_limite == null){
				flash("error", "Debe ingresar Monto Limite");
			}else{
			
				List<CajaChicaPresupuestoLinea> cpl = CajaChicaPresupuestoLinea.find.where().eq("caja_chica_id", c.id).findList();
				if(cpl.size() == 0){
					flash("error", "La caja chica debe contener lineas de presupuesto para poder pasarla a estado abierta.");
				}else{
					
					boolean errorControl =  false;
					String aviso = "";
					String avisoPresupuesto = "";
					
					ArrayNode a = BalancePresupuestario.controlSaldoCajaChica(c,c.expediente.ejercicio_id.intValue());
					for(JsonNode o :a){
						boolean success = new Boolean(o.get("success").toString());
						String cuenta = o.get("cuenta").toString(); 
						BigDecimal saldoDisponible =  new BigDecimal(o.get("saldoDisponible").toString());
						BigDecimal saldoAImputar =  new BigDecimal(o.get("saldoAImputar").toString());
						BigDecimal saldoPresente =  new BigDecimal(o.get("saldoPresente").toString());
						
						if(!success){
							errorControl =  true;
							if(saldoPresente.compareTo(BigDecimal.ZERO) != 0) {
								avisoPresupuesto += "Debe quedar el monto en 0 el SALDO TOTAL de la cuenta "+cuenta+"<br>";
								avisoPresupuesto += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
								avisoPresupuesto += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
								avisoPresupuesto += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
							}else {
								avisoPresupuesto += "No tiene Saldo disponible para la cuenta "+cuenta+"<br>";
								avisoPresupuesto += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
								avisoPresupuesto += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
								avisoPresupuesto += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
							}
							
						}else{
							avisoPresupuesto += "Tiene Saldo disponible para la cuenta "+cuenta+"<br>";
							avisoPresupuesto += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
							avisoPresupuesto += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
							avisoPresupuesto += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
						}
					}
					
					if(errorControl){
						String r = (aviso.isEmpty())?avisoPresupuesto:aviso;
						flash("error", r);
					}else{
						c.estado_id = new Long(Estado.CAJA_CHICA_ABIERTA);
						c.write_usuario_id =  new Long(Usuario.getUsuarioSesion());
						c.write_date = new Date();
						c.save();
						flash("success", "Operación exitosa. Estado actual: Abierta");
					}
				}
					
			}
			
			
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	public static void pasarCancelado(Long id) {
		CajaChica c = Ebean.find(CajaChica.class).select("id, estado_id").setId(id).findUnique();
		
		if(c != null){
			c.estado_id = new Long(Estado.CAJA_CHICA_CANCELADA);
			c.write_usuario_id =  new Long(Usuario.getUsuarioSesion());
			c.write_date = new Date();
			c.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
	
	public static void pasarCerrada(Long id) {
		
		CajaChica c = CajaChica.find.byId(id);
		
		boolean errorControl =  false;
		String aviso = "";
		String avisoPresupuesto = "";
		
		ArrayNode a = BalancePresupuestario.controlSaldoPreventivoCajaChica(c);
		for(JsonNode o :a){
			boolean success = new Boolean(o.get("success").toString());
			String cuenta = o.get("cuenta").toString();
			String expediente = o.get("expediente").toString();
			BigDecimal saldoDisponible =  new BigDecimal(o.get("saldoDisponible").toString());
			BigDecimal saldoAImputar =  new BigDecimal(o.get("saldoAImputar").toString());
			BigDecimal saldoPresente =  new BigDecimal(o.get("saldoPresente").toString());
			
			if(!success){
				errorControl =  true;
				if(saldoPresente.compareTo(BigDecimal.ZERO) != 0) {
					avisoPresupuesto += "Debe quedar el monto en 0 el SALDO TOTAL de la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
					avisoPresupuesto += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
					avisoPresupuesto += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
					avisoPresupuesto += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
				}else {
					avisoPresupuesto += "No tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
					avisoPresupuesto += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
					avisoPresupuesto += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
					avisoPresupuesto += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
				}
				
			}else{
				avisoPresupuesto += "Tiene Saldo disponible para la cuenta "+cuenta+" para el expediente "+expediente+"<br>";
				avisoPresupuesto += "Saldo Disponible: "+utils.NumberUtils.moneda(saldoDisponible)+"<br>";
				avisoPresupuesto += "Saldo a Imputar: "+utils.NumberUtils.moneda(saldoAImputar)+"<br>";
				avisoPresupuesto += "Saldo Total: "+utils.NumberUtils.moneda(saldoPresente)+"<br><br>";
			}
		}
		
		
		if(errorControl){
			String r = (aviso.isEmpty())?avisoPresupuesto:aviso;
			flash("error", r);
		}else{
			if(c != null){
				c.estado_id = new Long(Estado.CAJA_CHICA_CERRADA);
				c.write_usuario_id =  new Long(Usuario.getUsuarioSesion());
				c.write_date = new Date();
				c.save();
				flash("success", "Operación exitosa. Estado actual: Cerrada");
			} else {
				flash("error", "Parámetros incorrectos");
			}
		}	
	}
	
	public static Result resumenPresupuesto(Long id) {
		
		List<SqlRow> s = CajaChicaMovimiento.getResumenPresupuesto(id); 
		
		return ok(contenidoTabResumenPresupuesto.render(s));
	}
	
	public static Result reporteImputacionPreventivaLista(Long id) throws IOException {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/imputacion_preventiva.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/solicitudes/reporteImputacionPreventiva.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      CajaChica cajaChica = CajaChica.find.byId(id);
		      
		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Codigo");
		      metadata.addFieldAsList("listado.Total");
		       
		      report.setFieldsMetadata(metadata);
		      
		      context.put("expediente", cajaChica.expediente.getExpedienteEjercicio());
		      context.put("asunto", cajaChica.expediente.descripcion);
		      context.put("listado", getMetadataReporteImputacionPreventiva(id,false));
		      context.put("sePuedeImprimir",(cajaChica.estado_id != Estado.CAJA_CHICA_CANCELADA)?true:false);
		      
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			 
	    	return ok(archivo);
	}
	
	public static Result reporteImputacionPreventivaAjustesLista(Long id) throws IOException {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/imputacion_preventiva.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/solicitudes/reporteImputacionPreventiva.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      CajaChica cajaChica = CajaChica.find.byId(id);
		      
		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Codigo");
		      metadata.addFieldAsList("listado.Total");
		       
		      report.setFieldsMetadata(metadata);
		      
		      context.put("expediente", cajaChica.expediente.getExpedienteEjercicio());
		      context.put("asunto", cajaChica.expediente.descripcion);
		      context.put("listado", getMetadataReporteImputacionPreventiva(id,true));
		      context.put("sePuedeImprimir",(cajaChica.estado_id != Estado.CAJA_CHICA_CANCELADA)?true:false);
		      
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			 
	    	return ok(archivo);
	}
	
	private static List<Map<String,String>> getMetadataReporteImputacionPreventiva(Long idCajaChica,boolean ajuste){
		List<Map<String,String>> listado = new ArrayList<Map<String,String>>();
		Map<Integer,String> cuentasCodigo =  new HashMap<Integer,String>();
		String codigoCuenta; 
		Map<Integer, BigDecimal> lineasAjuste = new HashMap<Integer, BigDecimal>();
		
		if(!ajuste) {
			String sqlAjuste = " SELECT sum(sl.monto) total,sl.cuenta_analitica_id cuenta_analitica_id, " +
						 "ca.codigo codigo "  
					   + " FROM caja_chica_presupuesto_lineas sl"   
					   + " INNER JOIN cuentas_analiticas ca ON ca.id = sl.cuenta_analitica_id "
					   + " WHERE caja_chica_id in(:idCajaChica) AND ajuste = false "   
					   + " GROUP BY sl.cuenta_analitica_id,ca.codigo ";  
			List<SqlRow> rowAjuste = Ebean.createSqlQuery(sqlAjuste).setParameter("idCajaChica", idCajaChica).findList(); 
			
			
			for(SqlRow s : rowAjuste){
				Integer idCuenta = new Integer(s.get("cuenta_analitica_id").toString());
				codigoCuenta = s.get("codigo").toString();
				BigDecimal valor = new BigDecimal(s.get("total").toString());
				if(lineasAjuste.containsKey(idCuenta)){
				    valor = lineasAjuste.get(idCuenta).add(valor);
				}
				lineasAjuste.put(idCuenta, valor);
				
				cuentasCodigo.put(idCuenta, codigoCuenta);
			}
		}
		
		if(ajuste) {
			//CARGO LOS AJUSTES
			String sql = " SELECT sum(sl.monto) total," +
					   " sl.cuenta_analitica_id cuenta_analitica_id, ca.codigo codigo "  
					   + " FROM caja_chica_presupuesto_lineas sl"   
					   + " INNER JOIN cuentas_analiticas ca ON ca.id = sl.cuenta_analitica_id "
					   + " WHERE caja_chica_id in(:idCajaChica) AND ajuste = true "   
					   + " GROUP BY sl.cuenta_analitica_id,ca.codigo ";
			
			
			List<SqlRow> row = Ebean.createSqlQuery(sql).setParameter("idCajaChica", idCajaChica).findList(); 
			
			for(SqlRow s : row){
				Integer idCuenta = new Integer(s.get("cuenta_analitica_id").toString());
				codigoCuenta = s.get("codigo").toString();
				BigDecimal b = new BigDecimal(s.get("total").toString());
				
				if(lineasAjuste.containsKey(idCuenta)){
					b = new BigDecimal(s.get("total").toString()).add(lineasAjuste.get(idCuenta));
				}
				
				lineasAjuste.put(idCuenta, b);
				cuentasCodigo.put(idCuenta, codigoCuenta);
			}
		}
		
		for (Entry<Integer, BigDecimal> l : lineasAjuste.entrySet()){
			Integer clave = l.getKey();
			BigDecimal valor = l.getValue();
			
			Map<String,String> d = new HashMap<String, String>();
			d.put("Codigo", cuentasCodigo.get(clave).toString());
			d.put("Total", NumberUtils.moneda(valor,2));
			listado.add(d);
		}
		
		
		Map<String,String> mapTmp = new HashMap<String, String>();
		List<Map<String,String>> listadoTmp = new ArrayList<Map<String,String>>();
		for(Map<String,String> f: listado){
			 
			if(f.get("Total").compareToIgnoreCase("$0,00") != 0){
				if(!f.containsKey( f.get("Codigo"))){
					mapTmp.put("Codigo", f.get("Codigo"));
					mapTmp.put("Total", f.get("Total"));
					listadoTmp.add(mapTmp);
				}
				
			}
		}
		
		return listado;
	}
	 
	public static Result reporteImputacionDefinitiva(Long idCaja) throws IOException {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/imputacion_definitiva.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/ordenes/reporteImputacionDefinitiva.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      CajaChica caja = CajaChica.find.byId(idCaja);
		      
		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.Codigo");
		      metadata.addFieldAsList("listado.Total");
		       
		      report.setFieldsMetadata(metadata);

		       
		      context.put("expediente", caja.expediente.getExpedienteEjercicio());
		      context.put("asunto", caja.expediente.descripcion);
		      
		       
		      context.put("listado", getMetadataReporteImputacionDefinitiva(idCaja));
		      context.put("sePuedeImprimir", (caja.estado_id == Estado.CAJA_CHICA_CERRADA)?true:false );
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			 
	    	return ok(archivo);
	}
	
	private static List<Map<String,String>> getMetadataReporteImputacionDefinitiva(Long idCaja){
		List<Map<String,String>> listado = new ArrayList<Map<String,String>>();
		Map<Integer,String> cuentasCodigo =  new HashMap<Integer,String>();
		
		String sqlAjuste = " SELECT ROUND(SUM(CAST(sl.cantidad*sl.precio AS numeric)),2) total,sl.cuenta_analitica_id cuenta_analitica_id, " +
				 "ca.codigo codigo "  
			   + " FROM caja_chica_movimientos sl"   
			   + " INNER JOIN cuentas_analiticas ca ON ca.id = sl.cuenta_analitica_id "
			   + " WHERE caja_chica_id in(:idCajaChica) "   
			   + " GROUP BY sl.cuenta_analitica_id,ca.codigo ";  
		List<SqlRow> rowAjuste = Ebean.createSqlQuery(sqlAjuste).setParameter("idCajaChica", idCaja).findList(); 
		
		Map<Integer,BigDecimal> hashAjuste = new HashMap<Integer,BigDecimal>();
		String codigoCuenta;
		
		for(SqlRow s : rowAjuste){
			Integer idCuenta = new Integer(s.get("cuenta_analitica_id").toString());
			BigDecimal total = new BigDecimal(s.get("total").toString());
			codigoCuenta = s.get("codigo").toString();
			hashAjuste.put(idCuenta,total);
			
			cuentasCodigo.put(idCuenta, codigoCuenta);
		}
		
		for (Entry<Integer, BigDecimal> l : hashAjuste.entrySet()){
			Integer clave = l.getKey();
			BigDecimal valor = l.getValue();
			
			Map<String,String> d = new HashMap<String, String>();
			d.put("Codigo", cuentasCodigo.get(clave).toString());
			d.put("Total", NumberUtils.moneda(valor,2));
			listado.add(d);
		}
		
		return listado;
	}
	
	public static Result reporteCajaChica(Long idCaja) throws IOException {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/caja_chica.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/caja_chica.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      CajaChica caja = CajaChica.find.byId(idCaja);
		      
		      FieldsMetadata metadata = new FieldsMetadata();
		      metadata.addFieldAsList("listado.fecha");
		      metadata.addFieldAsList("listado.proveedor");
		      metadata.addFieldAsList("listado.cuit");
		      metadata.addFieldAsList("listado.comprobante");
		      metadata.addFieldAsList("listado.concepto");
		      metadata.addFieldAsList("listado.Total");
		       
		      report.setFieldsMetadata(metadata);

		       
		      context.put("expediente", caja.expediente.getExpedienteEjercicio());
		      context.put("asunto", caja.expediente.descripcion);
		      
		      List<Map<String,String>> listado = new ArrayList<Map<String,String>>();
		      BigDecimal t = new BigDecimal(0);
		      List<CajaChicaMovimiento> cm = CajaChicaMovimiento.find.where().eq("caja_chica_id", idCaja).orderBy("fecha").findList();
		      for(CajaChicaMovimiento s : cm){
		    	  Map<String,String> d = new HashMap<String, String>();
		    	  d.put("fecha", DateUtils.formatDate(s.fecha));
		    	  d.put("proveedor", s.proveedor.nombre);
		    	  d.put("cuit", s.proveedor.cuit.toString());
		    	  d.put("comprobante", s.numero_factura);
		    	  d.put("concepto", s.producto.nombre);
		    	  d.put("Total", NumberUtils.moneda(s.getTotal(),2));
		    	  listado.add(d);
		    	  t = t.add(s.getTotal());
		      }
		      
		      context.put("total", NumberUtils.moneda(t,2));
		      context.put("listado", listado);
		      context.put("sePuedeImprimir", (caja.estado_id == Estado.CAJA_CHICA_CERRADA)?true:false );
		      // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			 
	    	return ok(archivo);
	}
	
	public static Result reporteCajaChicaOrdenCargo(Long idCaja) throws IOException {
		
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/caja_chica_orden_cargo.odt");
		
		try {
		      // 1) Load ODT file by filling Velocity template engine and cache it to the registry
			  InputStream in = Play.application().resourceAsStream("resources/reportes/compras/caja_chica_orden_cargo.odt");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
		      
		      // 2) Create context Java model
		      IContext context = report.createContext();
		      
		      CajaChica caja = CajaChica.find.byId(idCaja);
		      
		      context.put("expediente", caja.expediente.getExpedienteEjercicio());
		      context.put("expedienteDescripcion", caja.expediente.descripcion);
		      context.put("fecha_orden", utils.DateUtils.formatDate(caja.fecha));
		      context.put("asunto", caja.expediente.descripcion);
		      context.put("nombre", "NOMBRE");
		      context.put("dni", "DNI");
		      context.put("monto_neto",caja.getTotal());
	          new NumeroALetra();
			  context.put("monto_letra", NumeroALetra.convertNumberToLetter(String.valueOf(caja.getTotal())));
			  
			  // 3) Generate report by merging Java model with the ODT
		      OutputStream out = new FileOutputStream(archivo);
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
			 
	    	return ok(archivo);
	}	
}
