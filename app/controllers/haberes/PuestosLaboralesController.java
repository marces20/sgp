package controllers.haberes;

import static play.data.Form.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.commons.mail.EmailException;

import models.CertificacionCompra;
import models.CertificacionCompraLinea;
import models.Estado;
import models.Factura;
import models.Usuario;
import models.auth.Permiso;
import models.haberes.LiquidacionConceptoTipo;
import models.haberes.LiquidacionEnvioMail;
import models.haberes.LiquidacionMes;
import models.haberes.LiquidacionPuesto;
import models.haberes.PuestoLaboral;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.auth.CheckPermiso;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.haberes.puestosLaborales.*;
import views.html.haberes.puestosLaborales.acciones.*;

public class PuestosLaboralesController extends Controller {
	
	
/*
select 
	'001' sucursal,
	rpad(trim(split_part(apellido, ',', 1)), 32, ' ') apellido,
	rpad(trim(split_part(apellido, ',', 2)), 32, ' ') nombre,
	to_char(fnacimiento, 'ddMMYYYY'),
	sexo,
	estado_civil,
	'001' tipo_documento,
	dni,
	'08' tipo_identificacion_tributaria,
	rpad(trim(cuit), 13, ' ') numero_identificacion_tributaria,
	lpad(trim(zip), 4, '0') codigo_postal,
	prov.id provincia,
	rpad(trim(loc.nombre), 30, ' ') localidad,
	rpad('', 100, ' ') calle,
	lpad('', 5, '0') numero,
	rpad('', 2, ' ') piso,
	rpad('', 2, ' ') departamento,
	rpad('', 11, ' ') telefono,
	lpad(CAST(l.numero AS text), 10, '0') legajo,
	lpad(CAST(sueldo_referencia AS text), 10, '0') sueldo_bruto

	from puestos_laborales pl
inner join legajos l on l.id = pl.legajo_id
inner join agentes a on a.id = l.agente_id
inner join localidades loc on loc.id = a.localidad_id
inner join provincias prov on prov.id = loc.provincia_id
 */
	
	
	
	final static Form<PuestoLaboral> puestoLaboralForm = form(PuestoLaboral.class);
	
	public static Result URL_LISTA_PUESTO_LABORAL = redirect(
			controllers.haberes.routes.PuestosLaboralesController.index()
	);
	
	
	
	
	
	
	
	
	
	@CheckPermiso(key = "puestoLaboralIndex")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexPuestoLaboral.render(PuestoLaboral.page(
																RequestVar.get("puesto_laboral_id"), 
																RequestVar.get("activo"), 
																RequestVar.get("fecha_desde"), 
																RequestVar.get("fecha_hasta"),
																RequestVar.get("fecha_desde_baja"), 
																RequestVar.get("fecha_hasta_baja"),
																RequestVar.get("cm"),
																RequestVar.get("btnFiltro[0]"),//borrador
																RequestVar.get("btnFiltro[1]")//cargado
																),d));

	}
	
	@CheckPermiso(key = "puestoLaboralCrear")
	public static Result crear() {
		Form<PuestoLaboral> puestoLaboralForm = form(PuestoLaboral.class);
		return ok(crearPuestoLaboral.render(puestoLaboralForm));
	}
	
	@CheckPermiso(key = "puestoLaboralCrear")
	public static Result guardar() {
		
		Form<PuestoLaboral> puestoLaboralForm = form(PuestoLaboral.class).bindFromRequest();
		
		try {
			if(puestoLaboralForm.hasErrors()) {
				flash("error", "Error en formulario "+puestoLaboralForm.errors());
				return badRequest(crearPuestoLaboral.render(puestoLaboralForm));
			} else {
				PuestoLaboral lc = puestoLaboralForm.get();
				
				List<PuestoLaboral> pll = PuestoLaboral.find.where().eq("activo", true).eq("legajo_id", lc.legajo_id).ne("id",lc.id).findList();
				
				if(pll.size() > 0){
					flash("error", "Ya existe un puesto laboral ACTIVO para el mismo legajo.");
					return badRequest(crearPuestoLaboral.render(puestoLaboralForm));
				}
				
				
				lc.estado_id = (long) Estado.PUESTO_LABORAL_BORRADOR;
				//b.create_date = new Date();
				//b.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.save();
				flash("success", "El puesto laboral se ha actualizado");
				return redirect( controllers.haberes.routes.PuestosLaboralesController.ver( puestoLaboralForm.get().id ) + UriTrack.get("&"));
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el puesto laboral");
			return badRequest(crearPuestoLaboral.render(puestoLaboralForm));
		}
	}
	
	@CheckPermiso(key = "puestoLaboralEditar")
	public static Result editar(Long id) {
		PuestoLaboral lc = Ebean.find(PuestoLaboral.class, id);
		return ok(editarPuestoLaboral.render(puestoLaboralForm.fill(lc)));
	}
	
	@CheckPermiso(key = "puestoLaboralEditar")
	public static Result actualizar(){
		
		Form<PuestoLaboral> puestoLaboralForm = form(PuestoLaboral.class).bindFromRequest();
		
		try {
			
			if(puestoLaboralForm.hasErrors()) {
				flash("error", "Error en formulario"+ puestoLaboralForm.errors());
				return badRequest(editarPuestoLaboral.render(puestoLaboralForm));
			} else {
				PuestoLaboral lc = puestoLaboralForm.get();
				
				List<PuestoLaboral> pll = PuestoLaboral.find.where().eq("activo", true).eq("legajo_id", lc.legajo_id).ne("id",lc.id).findList();
				
				if(pll.size() > 0){
					flash("error", "Ya existe un puesto laboral ACTIVO para el mismo legajo.");
					return badRequest(editarPuestoLaboral.render(puestoLaboralForm));
				}
				
				//b.write_date = new Date();
				//b.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				lc.update();
				flash("success", "El puesto laboral se ha actualizado");
				return redirect( controllers.haberes.routes.PuestosLaboralesController.ver( puestoLaboralForm.get().id ) + UriTrack.get("&"));
			}
			
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el puesto laboral");
			return badRequest(editarPuestoLaboral.render(puestoLaboralForm));
		}
	}
	
	@CheckPermiso(key = "puestoLaboralEliminar")
	public static Result eliminar(Long id) {
		try {
			PuestoLaboral.find.byId(id).delete();
			flash("success", "Se ha eliminado el puesto laboral");
			return redirect( UriTrack.decode() );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el puesto laboral");
		}

		return redirect(request().getHeader("referer"));
	}
						
	@CheckPermiso(key = "puestoLaboralVer")
	public static Result ver(Long id) throws IOException {
		PuestoLaboral lc = PuestoLaboral.find.byId(id);

		if(lc == null){
			flash("error", "No se encuentra el puesto laboral.");
			return URL_LISTA_PUESTO_LABORAL;
		}
		
		List<LiquidacionEnvioMail> le = LiquidacionEnvioMail.find
										.fetch("liquidacionPuesto.liquidacionMes","nro_liquidacion_parque")
										.where()
										.eq("liquidacionPuesto.puestoLaboral.id",id).orderBy("fecha desc")
										.findList();
		
		return ok(verPuestoLaboral.render(puestoLaboralForm.fill(lc),lc,le));
	}
	
	public static Result modalBuscar() {

    	Pagination<PuestoLaboral> p = new Pagination<PuestoLaboral>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("legajo.agente.apellido");	
    	p.setExpressionList(PuestoLaboral.find.where().eq("activo",true).ilike("legajo.agente.apellido", "%" + RequestVar.get("nombre") + "%"));

		return ok(modalBuscarPuestos.render(p, form().bindFromRequest()));

	}
	
	public static Result modalBuscarTodos() {

    	Pagination<PuestoLaboral> p = new Pagination<PuestoLaboral>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("legajo.agente.apellido");	
    	p.setExpressionList(PuestoLaboral.find.where().ilike("legajo.agente.apellido", "%" + RequestVar.get("nombre") + "%"));

		return ok(modalBuscarPuestos.render(p, form().bindFromRequest()));

	}
	
	public static Result suggestPuestoLaboral(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode puestoLaboral = rpta.arrayNode();
	    
	    PuestoLaboral lc = new PuestoLaboral();
		 
		for(PuestoLaboral a : lc.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.legajo.agente.apellido);
	       
	        
	        String info = "";
	        String estado  = (a.activo)?"ACTIVO":"INACTIVO";
	        
	        if(!a.activo){
	        	String fbaja = utils.DateUtils.formatDate(a.fecha_baja);
	        	estado = estado+" - Fbaja: "+fbaja; 
	        }
	        info += estado;
	        
	        if(a.legajo.agente.organigrama != null){
	        	info += " - "+a.legajo.agente.organigrama.nombre;
	        }
	        
	        if(a.legajo.agente.cuit != null){
	        	info += " - "+a.legajo.agente.cuit;
	        }
	        
	        restJs.put("info",info);
	        
	        puestoLaboral.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", puestoLaboral);
		 
		return ok(response);
	}
	
	public static Result suggestPuestoLaboralTodos(String input) {
		 
		ObjectNode rpta = Json.newObject();
	    ArrayNode puestoLaboral = rpta.arrayNode();
	    
	    PuestoLaboral lc = new PuestoLaboral();
		 
		for(PuestoLaboral a : lc.getDataSuggestTodos(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.legajo.agente.apellido);
	        String info = "";
	        String estado  = (a.activo)?"ACTIVO":"INACTIVO";
	        
	        if(!a.activo){
	        	String fbaja = utils.DateUtils.formatDate(a.fecha_baja);
	        	estado = estado+" - Fbaja: "+fbaja; 
	        }
	        info += estado;
	        
	        if(a.legajo.agente.organigrama != null){
	        	info += " - "+a.legajo.agente.organigrama.nombre;
	        }
	        
	        if(a.legajo.agente.cuit != null){
	        	info += " - "+a.legajo.agente.cuit;
	        }
	        
	        
	        
	        restJs.put("info",info);
	        
	        puestoLaboral.add(restJs);
		}
		
		ObjectNode response = Json.newObject();
		response.put("results", puestoLaboral);
		 
		return ok(response);
	}
	
	public static Result get(int id){
		PuestoLaboral pl = PuestoLaboral.find.select("id, legajo.agente.apellido").where().eq("id", id).findUnique();

		ObjectNode restJs = Json.newObject();
		
		if(pl == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra puestos laborales");
			//
		} else {
			restJs.put("success", true);
			restJs.put("id", pl.id);
			restJs.put("nombre", pl.legajo.agente.apellido);
		}

		return ok(restJs);
	}
	
	public static Result cambiarEstado(Long idPuesto, Long idEstado) throws IOException{
		
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_CERTIFICACION_COMPRA);
		
		PuestoLaboral p = PuestoLaboral.find.where().eq("id", idPuesto).findUnique();
		
		if(p == null){
			flash("error", "No se encuentra el puesto.");
			return redirect(request().getHeader("referer"));
		}
		
		 
		
		
		
		if(idEstado != null){
			
			Boolean permiso = false;
			
			switch ( idEstado.intValue() ) {
		      case  Estado.PUESTO_LABORAL_BORRADOR:
		    	  if(!Permiso.check("puestoLaboralPasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarEnBorrador(p.id);
		    	  break;
		          
		      case Estado.PUESTO_LABORAL_CONTROLADO:
		    	  if(!Permiso.check("puestoLaboralPasarControlado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarControlado(p.id); 
		    	  break;
		      case Estado.PUESTO_LABORAL_CANCELADO:
		    	  if(!Permiso.check("puestoLaboralPasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				  }
		    	  pasarCancelado(p.id);   
		          break;
		      default:
		           break;
		      }
			  
		}	 
		
		return redirect(controllers.haberes.routes.PuestosLaboralesController.ver(p.id)+ UriTrack.get("&"));
	}
	
	@CheckPermiso(key = "puestoLaboralPasarBorrador")
	public static void pasarEnBorrador(Long id){
		
		PuestoLaboral p = Ebean.find(PuestoLaboral.class).select("id, estado_id").setId(id).findUnique();
		
		if(p != null){			
			p.estado_id = new Long(Estado.PUESTO_LABORAL_BORRADOR);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	@CheckPermiso(key = "puestoLaboralPasarControlado")
	public static void pasarControlado(Long id){
		
		PuestoLaboral p = Ebean.find(PuestoLaboral.class).select("id, estado_id").setId(id).findUnique();
		
		if(p != null){			
			p.estado_id = new Long(Estado.PUESTO_LABORAL_CONTROLADO);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Controlado");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	@CheckPermiso(key = "puestoLaboralPasarCancelado")
	public static void pasarCancelado(Long id){
		
		PuestoLaboral p = Ebean.find(PuestoLaboral.class).select("id, estado_id").setId(id).findUnique();
		
		if(p != null){			
			p.estado_id = new Long(Estado.PUESTO_LABORAL_CANCELADO);
			p.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}

	}
	
	@CheckPermiso(key = "liquidacionMesPreliquidar")
	public static Result liquidarCierre(Long idPuestoLaboral,Long idLiquidacionMes) throws EmailException{
		
		try {
			 
			PuestoLaboral.liquidacionCierre(idPuestoLaboral, idLiquidacionMes);
			
			flash("success", "Se ha preliquidado correctamente");
			
			String refererUrl = request().getHeader("referer");
			return redirect(refererUrl);
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido preliquidar");
			String refererUrl = request().getHeader("referer");
			return redirect(refererUrl);
		}
	}
}
