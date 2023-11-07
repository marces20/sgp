package controllers.dashboard;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.logging.Logger;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;

import models.Periodo;
import models.haberes.LiquidacionPuesto;
import models.haberes.PuestoLaboral;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.contabilidad.facturasLineas.verLineaProducto;
import views.html.dashboard.honorarios.estadoGeneralPorAgente;
import views.html.dashboard.liquidaciones.*;
import views.html.dashboard.liquidaciones.vistas.*;

@Security.Authenticated(Secured.class)
public class LiquidacionesController extends Controller {

	public static Result liquidacionesTotalesPorEscala() {
		DynamicForm formBuscador = form().bindFromRequest();

		if(RequestVar.get("nuevo").isEmpty()){

			if(RequestVar.get("periodo_id").isEmpty()){
				flash("error", "Debe seleccionar un periodo.");
				return ok(liquidacionesPorProfesion.render(formBuscador,null,null,null));
			}
		}

		if(!RequestVar.get("periodo_id").isEmpty()){

			Long idPeriodo = new Long(RequestVar.get("periodo_id"));

			List<SqlRow> rowParque = PuestoLaboral.getTotalesPorEscala(idPeriodo,false);

			List<SqlRow> rowConvenio = PuestoLaboral.getTotalesPorEscala(idPeriodo, true);

			List<SqlRow> rowPlanta = PuestoLaboral.getTotalesPorEscala(idPeriodo, null);
			return ok(liquidacionesTotalesPorEscala.render(formBuscador,rowParque,rowConvenio,rowPlanta));
		}

		return ok(liquidacionesTotalesPorEscala.render(formBuscador,null,null,null));
	}

	@CheckPermiso(key = "dashboardLiquidacionesPorProfesion")
	public static Result getDetalleLiquidacionClasificacion(Integer idPuestoLaboral,Integer idPeriodo,Integer idClasificacion) {

		List<SqlRow> row = PuestoLaboral.getDetalleLiquidacionClasificacion(idPuestoLaboral,idPeriodo,idClasificacion);

		return ok(detalleHaberesClasificacion.render(row));
	}

	@CheckPermiso(key = "dashboardLiquidacionesPorProfesion")
	public static Result liquidacionesPorProfesion() {
		DynamicForm formBuscador = form().bindFromRequest();


		if(RequestVar.get("nuevo").isEmpty()){
			if(RequestVar.get("profesion_id").isEmpty()){
				flash("error", "Debe seleccionar una profesion.");
				return ok(liquidacionesPorProfesion.render(formBuscador,null,null,null));
			}
			if(RequestVar.get("periodo_id").isEmpty()){
				flash("error", "Debe seleccionar un periodo.");
				return ok(liquidacionesPorProfesion.render(formBuscador,null,null,null));
			}
		}

		if(!RequestVar.get("profesion_id").isEmpty() && !RequestVar.get("periodo_id").isEmpty()){
			Long idProfesion = new Long(RequestVar.get("profesion_id"));
			Long idPeriodo = new Long(RequestVar.get("periodo_id"));

			List<SqlRow> rowParque = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,idProfesion, false,null,null);

			List<SqlRow> rowConvenio = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,idProfesion, true,null,null);

			List<SqlRow> rowPlanta = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,idProfesion, null,null,null);


			return ok(liquidacionesPorProfesion.render(formBuscador,rowParque,rowConvenio,rowPlanta));
		}

		return ok(liquidacionesPorProfesion.render(formBuscador,null,null,null));

	}

	@CheckPermiso(key = "dashboardLiquidacionesPorProfesion")
	public static Result liquidacionesPorOrganigrama() {
		DynamicForm formBuscador = form().bindFromRequest();


		if(RequestVar.get("nuevo").isEmpty()){
			if(RequestVar.get("organigrama_id").isEmpty()){
				flash("error", "Debe seleccionar un Servicio.");
				return ok(liquidacionesPorOrganigrama.render(formBuscador,null,null,null));
			}
			if(RequestVar.get("periodo_id").isEmpty()){
				flash("error", "Debe seleccionar un periodo.");
				return ok(liquidacionesPorOrganigrama.render(formBuscador,null,null,null));
			}
		}

		if(!RequestVar.get("organigrama_id").isEmpty() && !RequestVar.get("periodo_id").isEmpty()){
			Long idOrganigrama = new Long(RequestVar.get("organigrama_id"));
			Long idPeriodo = new Long(RequestVar.get("periodo_id"));

			List<SqlRow> rowParque = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,null, false,null,idOrganigrama);

			List<SqlRow> rowConvenio = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,null, true,null,idOrganigrama);

			List<SqlRow> rowPlanta = PuestoLaboral.getTotalesPorProfesionPeriodo(idPeriodo,null, null,null,idOrganigrama);


			return ok(liquidacionesPorOrganigrama.render(formBuscador,rowParque,rowConvenio,rowPlanta));
		}

		return ok(liquidacionesPorOrganigrama.render(formBuscador,null,null,null));

	}

	@CheckPermiso(key = "dashboardLiquidacionesPorAgrupadoOrganigrama")
	public static Result liquidacionesPorAgrupadoOrganigrama() {
		DynamicForm formBuscador = form().bindFromRequest();


		if(RequestVar.get("nuevo").isEmpty()){

			if(RequestVar.get("periodo_id").isEmpty()){
				flash("error", "Debe seleccionar un periodo.");
				return ok(liquidacionesPorAgrupadoOrganigrama.render(formBuscador,null,null));
			}
		}

		if(!RequestVar.get("periodo_id").isEmpty()){

			Long idPeriodo = new Long(RequestVar.get("periodo_id"));

			List<SqlRow> rowParque = PuestoLaboral.getTotalesPorAgrupadosOrganigramaPeriodo(idPeriodo,false);

			List<SqlRow> rowConvenio = PuestoLaboral.getTotalesPorAgrupadosOrganigramaPeriodo(idPeriodo,true);




			return ok(liquidacionesPorAgrupadoOrganigrama.render(formBuscador,rowParque,rowConvenio));
		}

		return ok(liquidacionesPorAgrupadoOrganigrama.render(formBuscador,null,null));

	}

	@CheckPermiso(key = "dashboardLiquidacionesPorEscala")
	public static Result liquidacionesPorEscala() {
		DynamicForm formBuscador = form().bindFromRequest();

		if(RequestVar.get("nuevo").isEmpty()){
			if(RequestVar.get("escala_laboral_id").isEmpty()){
				flash("error", "Debe seleccionar una Escala.");
				return ok(liquidacionesPorEscala.render(formBuscador,null,null,null,null));
			}
			if(RequestVar.get("periodo_id").isEmpty()){
				flash("error", "Debe seleccionar un periodo.");
				return ok(liquidacionesPorEscala.render(formBuscador,null,null,null,null));
			}
		}

		if(!RequestVar.get("escala_laboral_id").isEmpty() && !RequestVar.get("periodo_id").isEmpty()){
			Long idescala = new Long(RequestVar.get("escala_laboral_id"));
			Long idPeriodo = new Long(RequestVar.get("periodo_id"));

			List<SqlRow> rowParque = PuestoLaboral.getTotalesPorEscalaProfesionPeriodo(idPeriodo,false,idescala);

			List<SqlRow> rowConvenio = PuestoLaboral.getTotalesPorEscalaProfesionPeriodo(idPeriodo, true,idescala);

			List<SqlRow> rowPlanta = PuestoLaboral.getTotalesPorEscalaProfesionPeriodo(idPeriodo, null,idescala);


			return ok(liquidacionesPorEscala.render(formBuscador,RequestVar.get("escala_id"),rowParque,rowConvenio,rowPlanta));
		}


		return ok(liquidacionesPorEscala.render(formBuscador,RequestVar.get("escala_id"),null,null,null));
	}

	@CheckPermiso(key = "dashboardLiquidacionesPorPuesto")
	public static Result liquidacionesPorPuesto() {
		DynamicForm formBuscador = form().bindFromRequest();
		return ok(liquidacionesPorPuesto.render(formBuscador,RequestVar.get("puesto_id")));
	}

	@CheckPermiso(key = "dashboardLiquidacionesPorPuesto")
	public static Result getLiquidacionesPorPuesto(){

		RequestVar.get("puesto_laboral_id");



		ExpressionList<LiquidacionPuesto> lp = LiquidacionPuesto.find.where();
		lp = lp.eq("puesto_laboral_id", Integer.parseInt(RequestVar.get("puesto_laboral_id")));
		if(!RequestVar.get("periodo_inicio_id").isEmpty()){
			lp = lp.ge("liquidacionMes.periodo_id", Integer.parseInt(RequestVar.get("periodo_inicio_id")));
		}

		if(!RequestVar.get("periodo_fin_id").isEmpty()){
			lp = lp.le("liquidacionMes.periodo_id", Integer.parseInt(RequestVar.get("periodo_fin_id")));
		}

		List<LiquidacionPuesto> xlp = lp.orderBy("id desc").findList();

		PuestoLaboral pl  = PuestoLaboral.find
							.fetch("legajo").where()
							.eq("id", Integer.parseInt(RequestVar.get("puesto_laboral_id")))
							.findUnique();


		Object c = listaLiquidaciones.render(xlp);
		Object c2 = listaLiquidacionesPorClasificacionConcepto.render(xlp);
		Object datosPuesto = datosPuestoLaboral.render(pl);
		ObjectNode restJs = Json.newObject();
		restJs.put("success", true);
		restJs.put("modificar", true);
		restJs.put("html", c.toString());
		restJs.put("html2", c2.toString());
		restJs.put("htmlDatosPuesto", datosPuesto.toString());
		return ok(restJs);

	}

	@CheckPermiso(key = "dashboardLiquidacionesPorPuesto")
	public static Result getLiquidacionesPorPuestoPorPeriodo(){
		ObjectNode rpta = Json.newObject();
		ArrayNode results = rpta.arrayNode();


		ExpressionList<LiquidacionPuesto> lp = LiquidacionPuesto.find.where();
		lp = lp.eq("puesto_laboral_id", Integer.parseInt(RequestVar.get("puesto_laboral_id")));
		if(!RequestVar.get("periodo_inicio_id").isEmpty()){
			lp = lp.ge("liquidacionMes.periodo_id", Integer.parseInt(RequestVar.get("periodo_inicio_id")));
		}

		if(!RequestVar.get("periodo_fin_id").isEmpty()){
			lp = lp.le("liquidacionMes.periodo_id", Integer.parseInt(RequestVar.get("periodo_fin_id")));
		}

		List<LiquidacionPuesto> xlp = lp.orderBy("id desc").findList();


		Map<Integer,BigDecimal> totales = new TreeMap<Integer,BigDecimal>();

		for(LiquidacionPuesto x : xlp){
			Integer periodoId = x.liquidacionMes.periodo_id;
			if(totales.containsKey(periodoId)){
				BigDecimal ttmp = totales.get(periodoId);

				ttmp = ttmp.add(x.getTotalACobrar());

				totales.put(periodoId, ttmp);

			}else{
				totales.put(periodoId, x.getTotalACobrar());
			}
		}

		for (Entry<Integer,BigDecimal> x2: totales.entrySet()) {
    		ObjectNode restJs = Json.newObject();

    		Periodo p = Periodo.find.byId(x2.getKey().longValue());
    		restJs.put("periodo",p.nombre);
	        restJs.put("valor", x2.getValue());
    		results.add(restJs);
    	}

		ObjectNode response = Json.newObject();
		response.put("success", true);
		response.put("results", results);

		return ok(response);
	}

	@CheckPermiso(key = "dashboardLiquidacionesPorPuesto")
	public static Result getLiquidacionesPorPuestoPorPeriodoPorClasificacion(){
		ObjectNode rpta = Json.newObject();
		ArrayNode results = rpta.arrayNode();



		ExpressionList<LiquidacionPuesto> lp = LiquidacionPuesto.find.where();
		lp = lp.eq("puesto_laboral_id", Integer.parseInt(RequestVar.get("puesto_laboral_id")));
		if(!RequestVar.get("periodo_inicio_id").isEmpty()){
			lp = lp.ge("liquidacionMes.periodo_id", Integer.parseInt(RequestVar.get("periodo_inicio_id")));
		}

		if(!RequestVar.get("periodo_fin_id").isEmpty()){
			lp = lp.le("liquidacionMes.periodo_id", Integer.parseInt(RequestVar.get("periodo_fin_id")));
		}

		List<LiquidacionPuesto> xlp = lp.orderBy("id desc").findList();

		Map<Integer,BigDecimal> haber = new TreeMap<Integer,BigDecimal>();
		Map<Integer,BigDecimal> guardias = new TreeMap<Integer,BigDecimal>();
		Map<Integer,BigDecimal> produccion = new TreeMap<Integer,BigDecimal>();
		Map<Integer,BigDecimal> descuentos = new TreeMap<Integer,BigDecimal>();
		Map<Integer,BigDecimal> adicionales = new TreeMap<Integer,BigDecimal>();

		for(LiquidacionPuesto x : xlp){
			Integer periodoId = x.liquidacionMes.periodo_id;

			if(haber.containsKey(periodoId)){
				BigDecimal ttmp = haber.get(periodoId);
				ttmp = ttmp.add(x.getTotalClasificacionHaberContrato());
				haber.put(periodoId, ttmp);

				ttmp = guardias.get(periodoId);
				ttmp = ttmp.add(x.getTotalClasificacionGuardia());
				guardias.put(periodoId, ttmp);

				ttmp = produccion.get(periodoId);
				ttmp = ttmp.add(x.getTotalClasificacionProduccion());
				produccion.put(periodoId, ttmp);

				ttmp = descuentos.get(periodoId);
				ttmp = ttmp.add(x.getTotalClasificacionDescuento());
				descuentos.put(periodoId, ttmp);

				ttmp = adicionales.get(periodoId);
				ttmp = ttmp.add(x.getTotalClasificacionAdicional());
				adicionales.put(periodoId, ttmp);

			}else{
				haber.put(periodoId, x.getTotalClasificacionHaberContrato());
				guardias.put(periodoId, x.getTotalClasificacionGuardia());
				produccion.put(periodoId, x.getTotalClasificacionProduccion());
				descuentos.put(periodoId, x.getTotalClasificacionDescuento());
				adicionales.put(periodoId, x.getTotalClasificacionAdicional());
			}
		}



		for (Entry<Integer,BigDecimal> x2: haber.entrySet()) {
    		ObjectNode restJs = Json.newObject();

    		Periodo p = Periodo.find.byId(x2.getKey().longValue());
    		restJs.put("periodo",p.nombre);
	        restJs.put("haber", haber.get(x2.getKey()));
	        restJs.put("guardias", guardias.get(x2.getKey()));
	        restJs.put("produccion", produccion.get(x2.getKey()));
	        restJs.put("descuentos", descuentos.get(x2.getKey()));
	        restJs.put("adicionales", adicionales.get(x2.getKey()));
    		results.add(restJs);
    	}

		ObjectNode response = Json.newObject();
		response.put("success", true);
		response.put("results", results);

		return ok(response);
	}

}
