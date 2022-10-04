package controllers.patrimonio;

import static play.data.Form.form;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import models.ActaRecepcion;
import models.Estado;
import models.Inventario;
import models.OrdenLinea;
import models.OrdenLineaCliente;
import models.OrdenProvisionLineas;
import models.Recepcion;
import models.Remito;
import models.RemitoLinea;
import models.RemitoLineaCliente;
import play.Logger;
import play.api.data.validation.ValidationError;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.patrimonio.lineasRemitos.*;
import views.html.patrimonio.lineasRemitos.modales.*;
import views.html.patrimonio.recepciones.crearRecepcion;

@Security.Authenticated(Secured.class)
public class RemitosLineasController  extends Controller {
	final static Form<RemitoLinea> oForm = form(RemitoLinea.class);

	public static Result index(){
		DynamicForm d = form().bindFromRequest();
		Pagination<RemitoLinea> lineas = RemitoLinea.page(RequestVar.get("remito_id"), RequestVar.get("producto_id"), RequestVar.get("producto.nombre"));
		
		return ok(indexLineasRemitos.render(lineas, d));
	}
	
	public static Result enRemito(Long id_remito) {
		
		DynamicForm d = form().bindFromRequest();
		Pagination<RemitoLinea> lineas = RemitoLinea.page(RequestVar.get("id_remito"), RequestVar.get("producto_id"), RequestVar.get("producto.nombre"));
		
		return ok(enRemito.render(lineas, d));
	}
	
	public static Result paraAgregar(Long id_remito){	
		DynamicForm d = form().bindFromRequest();

		Long ordenProvision = Remito.find.byId(id_remito).recepcion.ordenProvision.orden_compra_id;
		
		System.out.println("---------------");
		Pagination<OrdenProvisionLineas> o = OrdenProvisionLineas.getProductosParaAgregar(ordenProvision, id_remito, RequestVar.get("producto"));
		System.out.println("---------------");
		
		
		return ok(paraAgregar.render(o, d));
	}
	
	public static Result recepcionarTodos(Long id_remito){
		
		
		
		try {
			OrdenProvisionLineas.recepcionarTodos(id_remito);
			 
			flash("success", "Se ha recepcionado todos los productos");
		} catch (Exception e) {
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			
			flash("error", "No se puede recepcionar todos los productos"+sw.toString());
			 
		}
		
		return redirect(request().getHeader("referer"));
	}
	
	
	public static Result controlesAgregarConCliente(){
		
		Form<RemitoLinea> rForm = form(RemitoLinea.class).bindFromRequest();
		ObjectNode restJs = Json.newObject();
		
		if(rForm.hasErrors()) {

			if(rForm.error("cantidad") != null) {
				restJs.put("message", rForm.error("cantidad").message());
			} else if(rForm.error("linea_orden_id") != null) {
				restJs.put("message", rForm.error("linea_orden_id").message());
			} 
			return ok(restJs);
		} 
		
		RemitoLinea rlx = rForm.get();
		
		if (rlx.cantidad.signum() <= 0) {
			restJs.put("message", "La cantidad debe se mayo a 0.");
			return ok(restJs);
		}
		
		BigDecimal maximo = OrdenProvisionLineas.getCantidadMaxima(rlx.linea_orden_id);
		System.out.println("------------ "+maximo);
		if(maximo.compareTo(rlx.cantidad) == -1) {
			restJs.put("message", "La cantidad que intenta agregar es superior a lo pendiente.");
			return ok(restJs);
		}
		
		return ok(restJs);
	}
	
	public static Result agregar(){
		Form<RemitoLinea> rForm = form(RemitoLinea.class).bindFromRequest();
		ObjectNode restJs = Json.newObject();
		
		if(rForm.hasErrors()) {

			if(rForm.error("cantidad") != null) {
				restJs.put("message", rForm.error("cantidad").message());
			} else if (rForm.get().cantidad.signum() <= 0) {
				restJs.put("message", "La cantidad debe se mayo a 0.");
			} else if(rForm.error("linea_orden_id") != null) {
				restJs.put("message", rForm.error("linea_orden_id").message());
			} 
			return ok(restJs);
		}
		
		
		

		BigDecimal maximo = OrdenProvisionLineas.getCantidadMaxima(rForm.get().linea_orden_id);
		System.out.println("------------ "+maximo);
		if(maximo.compareTo(rForm.get().cantidad) == -1) {
			restJs.put("message", "La cantidad que intenta agregar es superior a lo pendiente.");
			return ok(restJs);
		}
		
		
		restJs.put("tienePacientes", true);
		
		try {
			rForm.get().save();
			restJs.put("success", true);
		} catch (Exception e){
			restJs.put("message", "No se pudo cargar la linea.");
		}
		
		return ok(restJs);
	}
	
	public static Result modificar(){
		
		DynamicForm d = form().bindFromRequest();

		ObjectNode restJs = Json.newObject();
		
		RemitoLinea rl = RemitoLinea.find.byId(Long.valueOf(d.get("id")));
		
		List<Inventario> enInventario = Inventario.find.where().eq("remito_id", rl.remito_id).eq("producto_id", rl.lineaOrden.producto_id).findList();
			

		if(d.get("cantidad") == "") {
			restJs.put("message", "La cantidad es requerida.");
			return ok(restJs);
		}

		if(enInventario.size() > new BigDecimal(d.get("cantidad")).intValue() ) {
			restJs.put("message", "No se puede modificar. Existen más productos en inventario.");
			return ok(restJs);
		}
		
		if(rl.cantidadMaxima.add(rl.cantidad).compareTo(new BigDecimal(d.get("cantidad"))) == -1) {
			restJs.put("message", "La cantidad que intenta agregar es superior a lo pendiente.");
			return ok(restJs);
		}
		
		List<SqlRow> olSqlRow = OrdenLinea.getCantidadDisponiblePorClientes(rl.linea_orden_id);
		List<RemitoLineaCliente> rlc = RemitoLineaCliente.find.where().eq("remito_linea_id", rl.id).findList(); 
		if(olSqlRow.size() > 0 || rlc.size() > 0){
			restJs.put("message", "No se pueden modificar lineas que tenga asociados pacientes. Debe eliminar la linea y volverla a cargar.");
			return ok(restJs);
			
		}
		

		rl.delete();
		
		Form<RemitoLinea> fr = form(RemitoLinea.class).bindFromRequest();

		if(fr.hasErrors()) {
			restJs.put("message", "Error " + fr.errors());
			return ok(restJs);
		}
		
		RemitoLinea rr = fr.get();
		try {
			rr.save();
			restJs.put("success", true);
		} catch (Exception e){
			restJs.put("message", "No se pudo modificar la linea." + rr.cantidad);
			System.out.println(e);
		}
		
		return ok(restJs);
	}
	
	public static Result eliminar(Long id){
		
		RemitoLinea l = RemitoLinea.find.byId(id);
		ObjectNode restJs = Json.newObject();
		
		
		List<Inventario> enInventario = Inventario.find.where().eq("remito_id", l.remito_id).eq("producto_id", l.lineaOrden.producto_id).findList();
		
		if(enInventario.size() > 0) {
			restJs.put("message", "No se puede eliminar. Existen productos en inventario.");
			return ok(restJs);
		}
		
		
		if(l.remito.recepcion.acta != null && l.remito.recepcion.acta.estado_id == Estado.ACTA_ESTADO_APROBADA) {
			restJs.put("message", "No se puede eliminar productos en actas aprobadas.");
			return ok(restJs);
		}
		
		try {
			l.delete();
			restJs.put("success", true);
		} catch (Exception e) {
			restJs.put("message", "No se pudo eliminar la linea del remito.");
		}
		
		return ok(restJs);
	}
	
	public static Result modalAgregarConClientes() {
		Long remito_id = new Long(RequestVar.get("remito_id"));
		
		BigDecimal cantidad = new BigDecimal(RequestVar.get("cantidad").replace(",","."));
		Long linea_orden_id = new Long(RequestVar.get("linea_orden_id"));
		
		SqlRow disponibleConCliente = OrdenLinea.getCantidadDisponiblePorLineaConClientes(linea_orden_id);
		BigDecimal opl = OrdenProvisionLineas.getCantidadDisponible(linea_orden_id);
		
		BigDecimal dispo = opl.subtract(disponibleConCliente.getBigDecimal("cantidad_disponible"));
		
		Logger.debug("zzzzzzzzzzzzzzzzzz "+dispo);
		
		List<SqlRow> olSqlRow = OrdenLinea.getCantidadDisponiblePorClientes(linea_orden_id);
		
		return ok(modalAgregarConClientes.render(remito_id,cantidad,linea_orden_id,olSqlRow,dispo));
	}
	
	public static Result agregarConCliente(){
		
		ObjectNode restJs = Json.newObject();
		
		BigDecimal cantidad = null;
		BigDecimal cantidadCargar = new BigDecimal(RequestVar.get("cantidadCargar"));
		
		if(!RequestVar.get("remito_id").isEmpty() && !RequestVar.get("linea_orden_id").isEmpty()){
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
		
		try {
			
			Long linea_orden_id = new Long(RequestVar.get("linea_orden_id"));
			Long remito_id = new Long(RequestVar.get("remito_id"));
			
			
			RemitoLinea rlx = RemitoLinea.find.where().eq("linea_orden_id", linea_orden_id).eq("remito_id", remito_id).findUnique();
			
			RemitoLinea rl = new RemitoLinea();
			if(rlx != null){
				rlx.cantidad = rlx.cantidad.add(cantidadCargar);
				rlx.save();
				rl = rlx;
			}else{
				rl.cantidad= cantidadCargar;
				rl.remito_id = new Long(RequestVar.get("remito_id"));
				rl.linea_orden_id = new Long(RequestVar.get("linea_orden_id"));
				rl.save();
			}
			
			Logger.debug("xxxxxxxxxxxxxxx "+rl.id);
			Logger.debug("xxxxxxxxxxxxxxx "+cantidadCargar);
			Logger.debug("xxxxxxxxxxxxxxx "+RequestVar.get("clienteId"));
			if(!RequestVar.get("clienteId").isEmpty()){
				RemitoLineaCliente rlc = new RemitoLineaCliente();
				rlc.cantidad = cantidadCargar;
				rlc.cliente_id = new Long(RequestVar.get("clienteId"));
				rlc.remito_linea_id = rl.id;
				rlc.save();
			}
		
			 
			restJs.put("success", true);
		} catch (Exception e){
			restJs.put("message", "No se pudo cargar la linea."+e);
		}
		
		return ok(restJs);
	}
	
	public static Result tienePacientes(){
		
		 
		ObjectNode restJs = Json.newObject();
		
		List<SqlRow> olSqlRow = OrdenLinea.getCantidadDisponiblePorClientes(new Long(RequestVar.get("linea_orden_id")));
		
		if(olSqlRow.size() > 0){
			restJs.put("success", true);
		}else{
			restJs.put("success", false);
		}
		 
		
		return ok(restJs);
	}
	
	/*select * from orden_lineas where orden_id = 49010

			select * from orden_linea_clientes where orden_linea_id = 520065


			SELECT olc.cliente_id as cliente_id,c.nombre as nombreCliente,c.id_paciente_rismi as idPacienteRismi,  
			sum(olc.cantidad)-COALESCE(sum(rlm.cantidad),0)-COALESCE(sum(olac.cantidad),0) as cantidad  
			FROM orden_linea_clientes olc 
			INNER JOIN clientes c ON c.id = olc.cliente_id  
			LEFT JOIN remitos_lineas rl ON rl.linea_orden_id = olc.orden_linea_id  
			LEFT JOIN remito_linea_clientes rlm ON rlm.remito_linea_id = rl.id AND olc.cliente_id = rlm.cliente_id  
			LEFT JOIN orden_lineas_anulaciones ola ON ola.orden_linea_id = olc.orden_linea_id 
			LEFT JOIN orden_linea_anulacion_clientes olac ON olac.orden_linea_anulacion_id = ola.id and  olc.cliente_id = olac.cliente_id 
			WHERE olc.orden_linea_id = 520065
			GROUP BY olc.cliente_id,c.nombre,c.id_paciente_rismi

			alter table orden_lineas disable trigger all;
			    	update orden_lineas set cantidad = 10 where id = 520065;
			    	alter table orden_lineas enable trigger all;*/
	
	
}
