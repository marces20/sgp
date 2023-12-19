package controllers.recupero;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Estado;
import models.Usuario;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoNotaDebito;
import models.recupero.RecuperoPago;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.recupero.recuperoNotaDebito.*;

@Security.Authenticated(Secured.class)
public class RecuperoNotasDebitosController extends Controller {

	final static Form<RecuperoNotaDebito> lineaForm = form(RecuperoNotaDebito.class);

	public static Result index(Long facturaId, Boolean editable) {

		Pagination<RecuperoNotaDebito> lineas = RecuperoNotaDebito.page(facturaId);

		RecuperoFactura rf = RecuperoFactura.find.byId(facturaId);

		return ok(indexRecuperoNotaDebito.render(lineas, editable,rf));
	}

	public static Result crear(String facturaId) {
		flash().clear();
		Map<String,String> b = new HashMap<String, String>();
		b.put("recupero_factura_id", facturaId);
		b.put("udm_id","1");
		Form<RecuperoNotaDebito> linea = form(RecuperoNotaDebito.class).bind(b);
		linea.discardErrors();
		return ok(crearLineaNotaDebito.render(linea));
	}

	@CheckPermiso(key = "recuperoNotasEliminar")
	public static Result eliminar(Long id) {
		ObjectNode restJs = Json.newObject();

		try {
			RecuperoNotaDebito nc = RecuperoNotaDebito.find.byId(id);

			List<RecuperoPago> rpl = RecuperoPago.find.where()
					 .eq("recupero_factura_id", nc.recupero_factura_id)
					 .findList();

			if(rpl.size() > 1){//SI HAY MAS DE UN SOLO PAGO LE RESTO A LA PARCIAL

				RecuperoPago rpx = RecuperoPago.find.where()
						  .eq("parcializada",true)
						  .eq("recupero_factura_id",nc.recupero_factura_id)
						  .findUnique();
				rpx.total = rpx.total.subtract(nc.getTotal());
				rpx.save();


			}else if(rpl.size() == 1){//SI HAY UN SOLO PAGO Y ESTÁ PAGADO.. QUIERE DECIR Q NO SE HIZO LA PARCIAL POR ENDE NO SE PUEDE AGREGAR NOTA DE CREDITO

				RecuperoPago rpx = RecuperoPago.find.where()
			   			.eq("id", rpl.get(0).id)
			   			.eq("estado_id", Estado.RECUPERO_PAGO_BORRADOR)
			   			.findUnique();
				if(rpx == null){
					flash("error", "No se pueden agregar NOTAS DE DEBITOS no existe pagos en borrador ni parciales");
					restJs.put("success", false);
				}else {
					rpx.total = rpx.total.subtract(nc.getTotal());
					rpx.save();
				}
			}

			nc.delete();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("success", false);
		}

		restJs.put("success", true);
		return ok(restJs);
	}

	public static Result guardar() {
		Form<RecuperoNotaDebito> lineaForm = form(RecuperoNotaDebito.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario "+lineaForm.errors());
				return ok(crearLineaNotaDebito.render(lineaForm));
			} else {

				RecuperoNotaDebito l = lineaForm.get();

				List<RecuperoPago> rpl = RecuperoPago.find.where()
										 .eq("recupero_factura_id", l.recupero_factura_id)
										 .findList();

				if(rpl.size() == 0){
					flash("error", "No existen pagos asociados a esa factura");
					return ok(crearLineaNotaDebito.render(lineaForm));
				}

				BigDecimal ttmp = new BigDecimal(0);
				String pstr = "";
				for(RecuperoPago rp:rpl){
					ttmp = ttmp.add(rp.total);
					pstr += rp.id+"-";
				}

				RecuperoFactura rf = RecuperoFactura.find.byId(l.recupero_factura_id);

				//if(pstr != null && rf.getTotal().add(l.getTotal()).compareTo(ttmp) > 0){
					//flash("error", "El total de la factura excede al total de pagos relacionados. Modifique primero los pagos. Pagos: "+pstr);
					//return ok(crearLineaNotaDebito.render(lineaForm));
				//}

				if(rpl.size() > 1){//SI HAY MAS DE UN SOLO PAGO LE RESTO A LA PARCIAL


					RecuperoPago rpx = RecuperoPago.find.where()
									  .eq("parcializada",true)
									  .eq("recupero_factura_id",l.recupero_factura_id)
									  .findUnique();




					if( rpx.total.add(l.getTotal()).compareTo(BigDecimal.ZERO) < 0) {
						//SI EL MONTO DE LA NOTA ES MAYOR AL MONTO DE LA PARCIAL NO DEJO AGREGAR LA NOTA
						flash("error", "La nota de credito es mayor al saldo del pago parcial");
						return ok(crearLineaNotaDebito.render(lineaForm));
					}


					rpx.total = rpx.total.add(l.getTotal());
					rpx.save();

				}else if(rpl.size() == 1){//SI HAY UN SOLO PAGO Y ESTÁ PAGADO.. QUIERE DECIR Q NO SE HIZO LA PARCIAL POR ENDE NO SE PUEDE AGREGAR NOTA DE CREDITO




					RecuperoPago rp = new RecuperoPago();
					rp.fecha = new Date();
					rp.cliente_id = rf.cliente_id;
					rp.estado_id = (long) Estado.RECUPERO_PAGO_BORRADOR;
					rp.recupero_factura_id = rf.id.intValue();
					rp.periodo_id = rf.periodo_id;
					rp.expediente_id = rf.expediente_id;
					rp.parcializada = true;
					rp.total = rf.getTotal().add(l.getTotal());
					rp.save();

					RecuperoPago rpOld = rpl.get(0);
					rpOld.pago_principal_id = rp.id;
					rpOld.save();







				}

				l.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				l.create_date = new Date();
				l.save();
				flash("success", "El registro se almacenó correctamente.");
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro."+e.getMessage());
			return ok(crearLineaNotaDebito.render(lineaForm));
		}

		RecuperoNotaDebito linea = RecuperoNotaDebito.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaNotaDebito.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("nuevo", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}

	@CheckPermiso(key = "recuperoNotasEditar")
	public static Result editar(Long id) {
		flash().clear();
		RecuperoNotaDebito linea = RecuperoNotaDebito.find.byId(id);
		return ok(editarLineaNotaDebito.render(lineaForm.fill(linea)));
	}

	@CheckPermiso(key = "recuperoNotasEditar")
	public static Result actualizar() {

		Form<RecuperoNotaDebito> lineaForm = form(RecuperoNotaDebito.class).bindFromRequest();

		try {
			if(lineaForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarLineaNotaDebito.render(lineaForm));
			} else {
				RecuperoNotaDebito l = lineaForm.get();

				/*List<RecuperoPago> rpl = RecuperoPago.find.where()
						 .eq("recupero_factura_id", l.recupero_factura_id)
						 .findList();

				BigDecimal ttmp = new BigDecimal(0);
				String pstr = "";
				for(RecuperoPago rp:rpl){
					ttmp = ttmp.add(rp.total);
					pstr += rp.id+"-";
				}

				RecuperoFactura rf = RecuperoFactura.find.byId(l.recupero_factura_id);

				if(l.getTotal().add(rf.getTotal()).compareTo(ttmp) > 0){
					flash("error", "El total de la factura excede al total de pagos relacionados. Modifique primero los pagos. Pagos: "+pstr);
					return ok(editarLineaNotaCredito.render(lineaForm));
				}

				if(rpl.size() == 1){
					RecuperoPago rpx = RecuperoPago.find.where().eq("id", rpl.get(0).id).eq("estado_id", Estado.RECUPERO_PAGO_BORRADOR).findUnique();
					rpx.total = rpx.total.subtract(l.getTotal());
					rpx.save();
				}*/



				l.update(l.id);
			}
		} catch (Exception e){
			play.Logger.error("excepcion", e);
			flash("error", "No se ha podido almacenar el registro.");
			return ok(editarLineaNotaDebito.render(lineaForm));
		}

		RecuperoNotaDebito linea = RecuperoNotaDebito.find.where().eq("id", lineaForm.get().id).findUnique();
		Object c = verLineaNotaDebito.render(linea);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		return ok(restJs);
	}
}
