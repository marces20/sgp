package controllers.recupero;

import static play.data.Form.form;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Estado;
import models.Expediente;
import models.PuntoVenta;
import models.Usuario;
import models.recupero.Presupuesto;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoNotaDebito;
import models.recupero.RecuperoPago;
import models.recupero.RecuperoPlanilla;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.DateUtils;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import views.html.expediente.expediente.modalBusquedaExpediente;
import views.html.recupero.presupuesto.crearPresupuesto;
import views.html.recupero.presupuesto.editarPresupuesto;
import views.html.recupero.presupuesto.verPresupuesto;
import views.html.recupero.recuperoPlanilla.*;
import controllers.Secured;
import controllers.auth.CheckPermiso;

@Security.Authenticated(Secured.class)
public class RecuperoPlanillasController  extends Controller {

	final static Form<RecuperoPlanilla> planillaForm = form(RecuperoPlanilla.class);

	public static Result URL_LISTA_PLANILLA = redirect(
			controllers.recupero.routes.RecuperoPlanillasController.index()
	);

	@CheckPermiso(key = "planillaVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexPlanilla.render(
											RecuperoPlanilla.page(
												  		RequestVar.get("numero"),
												  		RequestVar.get("expediente_id"),
												  		RequestVar.get("fecha_desde"),
												  		RequestVar.get("fecha_hasta"),
												  		RequestVar.get("deposito_id")
												  		),d));
	}

	@CheckPermiso(key = "planillaVer")
	public static Result ver(Long id) {
		RecuperoPlanilla p = RecuperoPlanilla.find.byId(id);
		if(p != null){

			if(!p.controlPermisoDeposito()) {
				flash("error", "La institucion de la planilla no corresponde a su institucion asignada.");
				return redirect(controllers.recupero.routes.RecuperoPlanillasController.index()+UriTrack.get("?"));
			}

			Form<RecuperoPlanilla> planillaForm = form(RecuperoPlanilla.class).fill(p);


			List<RecuperoFactura> rf = RecuperoFactura.find.where().eq("planilla_id", id).findList();
			List<RecuperoNotaCredito> nc = RecuperoNotaCredito.find.where().eq("planilla_id", id).findList();
			List<RecuperoNotaDebito> nd = RecuperoNotaDebito.find.where().eq("planilla_id", id).findList();

			List<RecuperoPago> pa = RecuperoPago.find.where().eq("planilla_id", id).eq("recuperoFactura.recupero_tipo_pago_id", 2).findList();


			return ok(verPlanilla.render(planillaForm, p,rf,nc,nd,pa));
		}else{
			flash("error", "No se encuentra la planilla.");
			return redirect(controllers.recupero.routes.RecuperoPlanillasController.index()+UriTrack.get("?"));
		}
	}

	@CheckPermiso(key = "planillaCrear")
	public static Result crear() {

		Map<String,String> p = new HashMap<String, String>();

		Form<RecuperoPlanilla> planillaForm = form(RecuperoPlanilla.class).bind(p);
		planillaForm.discardErrors();

		return ok(crearPlanilla.render(planillaForm));
	}

	@CheckPermiso(key = "planillaCrear")
	public static Result guardar() {

		Form<RecuperoPlanilla> planillaForm = form(RecuperoPlanilla.class).bindFromRequest();

		if(planillaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(crearPlanilla.render(planillaForm));
		}

		try {
			RecuperoPlanilla c = planillaForm.get();

			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return badRequest(crearPlanilla.render(planillaForm));
			}


			Expediente e  = Expediente.find.byId(c.expediente_id.longValue());

			List<RecuperoPlanilla> rpx = RecuperoPlanilla.find.where()
											.eq("numero", c.numero)
								    		.eq("expediente.ejercicio_id",e.ejercicio_id)
								    		.eq("expediente_id",e.id)
								    		.eq("deposito_id", c.deposito_id)
								    		.findList();


			if(rpx.size() > 0){
				flash("error", "Ya existe ese numero de planilla para este ejercicio.");
				return badRequest(crearPlanilla.render(planillaForm));
			}else{
				c.save();
			}


			flash("success", "La Planilla se ha creado");
			return redirect( controllers.recupero.routes.RecuperoPlanillasController.ver(planillaForm.get().id)+UriTrack.get("&") );
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la planulla");
			return badRequest(crearPlanilla.render(planillaForm));
		}
	}

	@CheckPermiso(key = "planillaModificar")
	public static Result editar(Long id) {
		RecuperoPlanilla planilla = RecuperoPlanilla.find.byId(id);

		if(planilla  == null){
			flash("error", "No se encuentra la planilla.");
			return redirect(controllers.recupero.routes.RecuperoPlanillasController.index()+UriTrack.get("?"));
		}else {
			if(!planilla.controlPermisoDeposito()) {
				flash("error", "La planilla institucion no corresponde a su institucion asignada.");
				return redirect(controllers.recupero.routes.RecuperoPlanillasController.index()+UriTrack.get("?"));
			}
		}

		return ok(editarPlanilla.render(planillaForm.fill(planilla),planilla));
	}

	@CheckPermiso(key = "planillaModificar")
	public static Result actualizar(Long id){

		Form<RecuperoPlanilla> planillaForm = form(RecuperoPlanilla.class).bindFromRequest();

		RecuperoPlanilla planilla = Ebean.find(RecuperoPlanilla.class, id);

		if(planillaForm.hasErrors()) {
			flash("error", "Error en formulario");
			return badRequest(editarPlanilla.render(planillaForm,planilla));
		}

		try {
			RecuperoPlanilla c = planillaForm.get();

			if(!c.controlPermisoDeposito()) {
				flash("error", "La institucion no corresponde a su institucion asignada.");
				return badRequest(editarPlanilla.render(planillaForm,planilla));
			}

			Expediente e  = Expediente.find.byId(c.expediente_id.longValue());

			List<RecuperoPlanilla> rpx = RecuperoPlanilla.find.where()
											.eq("numero", c.numero)
											.eq("expediente.ejercicio_id",e.ejercicio_id)
											.eq("deposito_id", c.deposito_id)
											.eq("expediente_id",e.id)
								   			.ne("id", c.id).findList();

			Logger.debug("cccccccccccccccccccccccccccccccccccccccccc");
			if(rpx.size() > 0){
				flash("error", "Ya existe ese numero de planilla para este ejercicio.");
				return badRequest(editarPlanilla.render(planillaForm,planilla));
			}else{
				c.update();
			}

			flash("success", "La planilla se ha actualizado");
			return redirect( controllers.recupero.routes.RecuperoPlanillasController.ver(planillaForm.get().id) + UriTrack.get("&") );
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la planilla");
			return badRequest(editarPlanilla.render(planillaForm,planilla));
		}
	}

	@CheckPermiso(key = "planillaEliminar")
	public static Result eliminar(Long id) {

		RecuperoPlanilla planilla = Ebean.find(RecuperoPlanilla.class).select("id").setId(id).findUnique();

		if(planilla == null){
			flash("error", "No se encuentra la planilla.");
			return redirect(controllers.recupero.routes.RecuperoPlanillasController.index()+UriTrack.get("?"));
		}

		List<RecuperoFactura> rf = RecuperoFactura.find.where().eq("planilla_id", planilla.id).findList();
		if(rf.size() > 0){
			flash("error", "No se puede eliminar la planilla porque tiene facturas asociadas");
			return redirect(controllers.recupero.routes.RecuperoPlanillasController.index()+UriTrack.get("?"));
		}

		List<RecuperoPago> rp = RecuperoPago.find.where().eq("planilla_id", planilla.id).findList();
		if(rp.size() > 0){
			flash("error", "No se puede eliminar la planilla porque tiene pagos asociadas");
			return redirect(controllers.recupero.routes.RecuperoPlanillasController.index()+UriTrack.get("?"));
		}



 			try {
				planilla.delete();
				flash("success", "Se ha eliminado la planilla");
				return redirect(UriTrack.decode());
			} catch (PersistenceException pe) {
				play.Logger.error("excepcion", pe);
				flash("error", "No se ha podido eliminar la planilla");
			}


		String refererUrl = request().getHeader("referer");
		return redirect(refererUrl);
	}

	public static Result suggestRecuperoPlanilla(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode rp = rpta.arrayNode();

	    RecuperoPlanilla ad = new RecuperoPlanilla();

		for(RecuperoPlanilla a : ad.getDataSuggest(input, 25)){
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        restJs.put("value",a.getRecuperoPlanillaEjercicioDeposito());
	        restJs.put("info", "");
	        rp.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", rp);

		return ok(response);
	}

	public static Result get(int id){
		RecuperoPlanilla rp = RecuperoPlanilla.find.where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(rp == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra la planilla");
		} else {
			restJs.put("success", true);
			restJs.put("id", rp.id);
			restJs.put("nombre", rp.getRecuperoPlanillaEjercicio());
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result modalBuscar() {
    	Pagination<RecuperoPlanilla> p = new Pagination<RecuperoPlanilla>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<RecuperoPlanilla> e = RecuperoPlanilla.find.where();

    	if(!RequestVar.get("ejercicio").isEmpty()){
    		e = e.eq("expediente.ejercicio.id", Integer.parseInt( RequestVar.get("ejercicio")) );
    	}

    	if(!RequestVar.get("numero").isEmpty()){
    		e = e.eq("numero", Integer.parseInt( RequestVar.get("numero")));
    	}

    	//e = e.disjunction();



    	p.setExpressionList(e);
		return ok( modalBusquedaRecuperoPlanilla.render(p, form().bindFromRequest()) );
	}

	public static Result getPlanillaByFecha() {

		ObjectNode obj = Json.newObject();
		ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(!RequestVar.get("puntoventa_id").isEmpty() && !RequestVar.get("fecha").isEmpty()) {
			Long puntoventa_id = new Long(RequestVar.get("puntoventa_id"));

			if(puntoventa_id.compareTo(new Long(14)) == 0 || puntoventa_id.compareTo(new Long(13)) == 0){
				puntoventa_id = new Long(9);
			}

			String ff = RequestVar.get("fecha");
			Date fecha = DateUtils.formatDate(ff, "dd/MM/yyyy");

			List<RecuperoPlanilla> rp=null;

			PuntoVenta pv = PuntoVenta.find.byId(puntoventa_id);

			for (int i = 0; i < 6; i++) {

				rp = RecuperoPlanilla.find.where().eq("deposito_id", pv.deposito_id).eq("fecha", fecha).findList();

				if(rp.size() > 0) {
					restJs.put("success", true);
					restJs.put("idPlanilla", rp.get(0).id);
					restJs.put("numero",rp.get(0).getRecuperoPlanillaEjercicio());
					nodo.add(restJs);
					return ok(restJs);
				}else {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(fecha);
					calendar.add(Calendar.DAY_OF_WEEK, -1);
					Date fechaMenosUno = calendar.getTime();
					fecha = fechaMenosUno;
				}

				Logger.debug("getPlanilla FECHA22: "+fecha.toString());
			}
		}

		restJs.put("error", true);
		restJs.put("message", "No se puede seleccionar la Planilla");


		nodo.add(restJs);
		return ok(restJs);
	}
}
