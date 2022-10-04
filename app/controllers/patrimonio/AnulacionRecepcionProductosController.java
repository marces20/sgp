package controllers.patrimonio;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.CertificacionServicio;
import models.CertificacionServicioLinea;
import models.Estado;
import models.Factura;
import models.FacturaLinea;
import models.OrdenLinea;
import models.OrdenLineaAnulacion;
import models.OrdenLineaAnulacionCliente;
import models.OrdenProvisionLineas;
import models.RemitoLinea;
import models.RemitoLineaCliente;
import models.Usuario;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.patrimonio.anulacionRecepcion.*;

@Security.Authenticated(Secured.class)
public class AnulacionRecepcionProductosController extends Controller {
	final static Form<OrdenLineaAnulacion> anulacionForm = form(OrdenLineaAnulacion.class);
	
	public static Result productosEnOrden(Long id){
		
		List<OrdenLineaAnulacion> o = OrdenLineaAnulacion.find.where().eq("ordenLinea.orden_id", id).findList();		
		
		List<Factura> f = Factura.find.where()
						    .eq("orden_id", id)
						   .ne("state_id", Estado.FACTURA_ESTADO_BORRADOR) 
						   .ne("state_id", Estado.FACTURA_ESTADO_CANCELADO).findList();
		
		return ok(indexAnulacionRecepcion.render(id, o,f));
	}
	
	public static Result verLineas(Long id){
		
		List<OrdenLineaAnulacion> o = OrdenLineaAnulacion.find.where().eq("ordenLinea.orden_id", id).findList();		
		
		return ok(verAnulacionRecepcion.render(id, o));
	}
	
	public static Result verLineasNoCertificadas(Long id){
		
		
		List<CertificacionServicio> ox = CertificacionServicio.find.where().eq("ordenProvision.orden_compra_id", id).eq("estado_id",Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA).findList();
		List<CertificacionServicioLinea> csl = new ArrayList<CertificacionServicioLinea>();
		for(CertificacionServicio cs : ox){
			for(CertificacionServicioLinea csx : cs.certificacionesServicioLinea){
				csl.add(csx);
			}
		}
		
		return ok(verNoCertifcado.render(id, csl));
	}

	@CheckPermiso(key = "anulacionRecepcionProductosCrear")
	public static Result crear(Long idOrdenCompra) {
		Form<OrdenLineaAnulacion> linea = form(OrdenLineaAnulacion.class);
		
		List<OrdenProvisionLineas> opl = OrdenProvisionLineas.getQuery(idOrdenCompra).where()
				//.having().gt("pendiente", BigDecimal.ZERO)
				.findList();
		
		return ok(crearLineaProducto.render(idOrdenCompra, linea,opl));
	}
	
	@CheckPermiso(key = "anulacionRecepcionProductosCrear")
	public static Result editar(Long id) {
		OrdenLineaAnulacion linea = OrdenLineaAnulacion.find.byId(id);
		Long idOrdenCompra = linea.ordenLinea.orden_id;

		return ok(editarLineaProducto.render(idOrdenCompra, anulacionForm.fill(linea), id));
	}
	
	@CheckPermiso(key = "anulacionRecepcionProductosCrear")
	public static Result guardar(Long idOrdenCompra) {
		
		Form<OrdenLineaAnulacion> a = form(OrdenLineaAnulacion.class).bindFromRequest();
		List<OrdenProvisionLineas> opl = OrdenProvisionLineas.getQuery(idOrdenCompra).where().gt("pendiente", BigDecimal.ZERO).findList();
		if(a.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(crearLineaProducto.render(idOrdenCompra, a,opl));
		}
		
		ObjectNode result = Json.newObject();
		
		try {
			OrdenLineaAnulacion lineaAnulada = a.get();
			/*if(lineaAnulada.cantidad.compareTo(new BigDecimal(1)) < 0){
				flash("error", "La cantidad debe ser superior a 0.");
				return ok(crearLineaProducto.render(idOrdenCompra, a, idOrdenCompra));
			}*/
			
			if(lineaAnulada.cantidad.compareTo(OrdenProvisionLineas.getCantidadDisponible(lineaAnulada.orden_linea_id)) > 0){
				flash("error", "La cantidad supera a la cantidad disponible a anular.");
				return ok(crearLineaProducto.render(idOrdenCompra, a,opl));
			}else{
				lineaAnulada.create_date = new Date();
				lineaAnulada.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lineaAnulada.save();
				result.put("nuevo", true);
				result.put("success", true);
				OrdenLineaAnulacion linea = OrdenLineaAnulacion.find.byId(lineaAnulada.id);
				Object c = lineaProducto.render(linea);
				result.put("html", c.toString());
			}
			
			
			
		} catch (Exception e) {
			flash("error", "Error en formulario."+e);
			return ok(crearLineaProducto.render(idOrdenCompra, a,opl));
		}
		
		return ok(result);
	}
	

	@CheckPermiso(key = "anulacionRecepcionProductosCrear")
	public static Result actualizar(Long idOrdenCompra) {
		
		Form<OrdenLineaAnulacion> a = form(OrdenLineaAnulacion.class).bindFromRequest();
		
		if(a.hasErrors()) {
			flash("error", "Error en formulario");
			return ok(editarLineaProducto.render(idOrdenCompra, a, new Long(0)));
		}
		
		ObjectNode restJs = Json.newObject();
		
		try {
			
			a.get().update();
			restJs.put("success", true);	
						
			OrdenLineaAnulacion linea = OrdenLineaAnulacion.find.byId(a.get().id);
			Object c = lineaProducto.render(linea);
			restJs.put("html", c.toString());
			
		} catch (Exception e) {
			flash("error", "No se pudo modificar "+e);
			return ok(editarLineaProducto.render(idOrdenCompra,a,a.get().id));
		}
		
		
		return ok(restJs);
	}
	
	public static Result modalProductosEnOrden(Long idOrdenCompra) {

		
		List<OrdenProvisionLineas> ol = OrdenProvisionLineas.getQuery(idOrdenCompra).where().ilike("producto.nombre", "%" +RequestVar.get("nombre")+ "%").findList();
		
		return ok(modalProductosEnOrden.render(idOrdenCompra, ol, form().bindFromRequest()));
	}
	
    public static Result get(int id){
    	
    	OrdenLinea ol = OrdenLinea.find.byId((long) id);
    	
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		
		if(ol == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el productos");
		} else {
			restJs.put("success", true);
			restJs.put("id", ol.id);
			restJs.put("nombre", ol.producto.nombre);
		}
		nodo.add(restJs);
		return ok(restJs);
    }
	
    @CheckPermiso(key = "anulacionRecepcionProductosCrear")
    public static Result eliminar(Long id){
    	ObjectNode restJs = Json.newObject();
    	try {
    		OrdenLineaAnulacion.find.byId(id).delete();
    		restJs.put("success", true);
    	} catch (Exception e) {
    		restJs.put("messagge", "No se pudo modificar ");
    	}
    	return ok(restJs);
    }
    
    @CheckPermiso(key = "anulacionRecepcionProductosCrear")
    public static Result modalAnularConClientes(){
    	//Long remito_id = new Long(RequestVar.get("remito_id"));
		BigDecimal cantidad = new BigDecimal(RequestVar.get("cantidad"));
		Long linea_orden_id = new Long(RequestVar.get("orden_linea_id"));
		
		SqlRow disponibleConCliente = OrdenLinea.getCantidadDisponiblePorLineaConClientes(linea_orden_id);
		BigDecimal opl = OrdenProvisionLineas.getCantidadDisponible(linea_orden_id);
		
		BigDecimal dispo = opl.subtract(disponibleConCliente.getBigDecimal("cantidad_disponible"));
		
		Logger.debug("zzzzzzzzzzzzzzzzzz "+dispo);
		
		List<SqlRow> olSqlRow = OrdenLinea.getCantidadDisponiblePorClientes(linea_orden_id);
		
		return ok(modalAnularConClientes.render(cantidad,linea_orden_id,olSqlRow,dispo));
    }
    
    @CheckPermiso(key = "anulacionRecepcionProductosCrear")
    public static Result anularConCliente(){
		
		ObjectNode restJs = Json.newObject();
		Form<OrdenLineaAnulacion> rForm = form(OrdenLineaAnulacion.class).bindFromRequest();
		BigDecimal cantidad = null;
		BigDecimal cantidadCargar = null;
		
		if(!RequestVar.get("orden_linea_id").isEmpty()){
			if(RequestVar.get("cantidadCargar").isEmpty()) {
				restJs.put("message", "Debe cargar una cantidad.");
				return ok(restJs);
			} else {
				cantidad = new BigDecimal(RequestVar.get("cantidad"));
				cantidadCargar = new BigDecimal(RequestVar.get("cantidadCargar"));
				if (cantidadCargar.signum() <= 0) {
					restJs.put("message", "La cantidad debe se mayo a 0.");
					return ok(restJs);
				} else if (cantidadCargar.compareTo(cantidad) > 0) {
					restJs.put("message", "La cantidad es mayor a lo pendiente.");
					return ok(restJs);
				}
			}	
		}else{
			restJs.put("message", "No se pueden cargar los datos");
			return ok(restJs);
		}
		
		Ebean.beginTransaction();
		try {
			
			Logger.debug("xxxxxxxxxxxxxxxxxxxxxxx "+ RequestVar.get("observaciones"));
			 
			
			OrdenLineaAnulacion lineaAnulada = rForm.get();
			lineaAnulada.cantidad = cantidadCargar;
			lineaAnulada.create_date = new Date();
			lineaAnulada.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			lineaAnulada.observaciones = RequestVar.get("observaciones");
			lineaAnulada.save();
			
			if(!RequestVar.get("clienteId").isEmpty()){
				Long clienteId = new Long(RequestVar.get("clienteId"));
				OrdenLineaAnulacionCliente olac = new OrdenLineaAnulacionCliente();
				olac.cantidad = cantidadCargar;
				olac.cliente_id = clienteId;
				olac.orden_linea_anulacion_id = lineaAnulada.id;
				olac.save();
			}
			
			Ebean.commitTransaction();
			restJs.put("nuevo", true);
			restJs.put("success", true);
			
			
		} catch (Exception e){
			Ebean.rollbackTransaction();
			restJs.put("message", "No se pudo cargar la linea."+e);
		}finally{
			Ebean.endTransaction();
		}		
		
		return ok(restJs);
	}
    
    public static Result controlesAnularConCliente(){
    	
    	Form<OrdenLineaAnulacion> rForm = form(OrdenLineaAnulacion.class).bindFromRequest();
		ObjectNode restJs = Json.newObject();
		
		if(rForm.hasErrors()) {
			if(rForm.error("cantidad") != null) {
				restJs.put("message", rForm.error("cantidad").message());
			} else if(rForm.error("orden_linea_id") != null) {
				restJs.put("message", rForm.error("orden_linea_id").message());
			} 
			return ok(restJs);
		} else if (rForm.get().cantidad.signum() <= 0) {
			restJs.put("message", "La cantidad debe se mayo a 0.");
			return ok(restJs);
		}
		
		BigDecimal maximo = OrdenProvisionLineas.getCantidadMaxima(rForm.get().orden_linea_id);
		System.out.println("------------ "+maximo);
		if(maximo.compareTo(rForm.get().cantidad) == -1) {
			restJs.put("message", "La cantidad que intenta agregar es superior a lo pendiente.");
			return ok(restJs);
		}
		
		return ok(restJs);
	}
    
    @CheckPermiso(key = "anulacionRecepcionProductosCrear")
	public static Result anular() {
    	ObjectNode restJs = Json.newObject();
		Form<OrdenLineaAnulacion> rForm = form(OrdenLineaAnulacion.class).bindFromRequest();
		
		if(rForm.hasErrors()) {
			if(rForm.error("cantidad") != null) {
				restJs.put("message", rForm.error("cantidad").message());
			} else if(rForm.error("orden_linea_id") != null) {
				restJs.put("message", rForm.error("orden_linea_id").message());
			} 
			return ok(restJs);
		} 
		
		try {
			OrdenLineaAnulacion lineaAnulada = rForm.get();
			if (lineaAnulada.cantidad.signum() <= 0) {
				restJs.put("message", "La cantidad debe se mayo a 0.");
				return ok(restJs);
			}
			
			if(lineaAnulada.cantidad.compareTo(OrdenProvisionLineas.getCantidadDisponible(lineaAnulada.orden_linea_id)) > 0){
				restJs.put("message", "La cantidad supera a la cantidad disponible a anular.");
				return ok(restJs);
				
			}else{
				lineaAnulada.create_date = new Date();
				lineaAnulada.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				lineaAnulada.save();
				restJs.put("nuevo", true);
				restJs.put("success", true);
				
				/*OrdenLineaAnulacion linea = OrdenLineaAnulacion.find.byId(lineaAnulada.id);
				Object c = lineaProducto.render(linea);
				restJs.put("html", c.toString());*/
			}
			
			
			
		} catch (Exception e) {
			restJs.put("message", "Error en formulario"+e);
			return ok(restJs);
		}
		
		return ok(restJs);
	}
    
    public static Result tienePacientes(){
		
		 
		ObjectNode restJs = Json.newObject();
		
		List<SqlRow> olSqlRow = OrdenLinea.getCantidadDisponiblePorClientes(new Long(RequestVar.get("orden_linea_id")));
		
		if(olSqlRow.size() > 0){
			restJs.put("success", true);
		}else{
			restJs.put("success", false);
		}
		 
		
		return ok(restJs);
	}
}
