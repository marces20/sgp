package controllers.dashboard;

import static play.data.Form.form;

import java.util.List;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.ActaRecepcion;
import models.AutorizadoLinea;
import models.AutorizadoLineaDetalle;
import models.Estado;
import models.informes.InformeDeudaPorActaMaterializada;
import models.informes.InformeDeudaProveedoresMaterializada;
import models.recupero.PresupuestoLinea;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.pagination.Pagination;
import views.html.dashboard.autorizadosLineas.*;
import controllers.Secured;

@Security.Authenticated(Secured.class)
public class AutorizadoLineasController extends Controller {

	final static Form<AutorizadoLinea> lineaForm = form(AutorizadoLinea.class);
	
	public static Result index(Long autorizadoId, Boolean editable) {
		
		Pagination<AutorizadoLinea> lineas = AutorizadoLinea.page(autorizadoId);
		
		//Pagination<AutorizadoLineaDetalle> lineas = AutorizadoLineaDetalle.getLineas(autorizadoId);
		
		return ok(indexAutorizadoLinea.render(lineas, editable));
	}
	
	public static Result eliminar(Long autorizado_id,Long orden_id) {
		ObjectNode restJs = Json.newObject();
		
		try {
			String dml = "DELETE FROM autorizado_lineas " +
						 "WHERE autorizado_id = :autorizado_id " +
						 "AND orden_id = :orden_id ";
			SqlUpdate delete = Ebean.createSqlUpdate(dml)
					.setParameter("autorizado_id",autorizado_id)
					.setParameter("orden_id",orden_id);
			int rows = delete.execute();
			InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
			InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			restJs.put("success", false);
		}
		
		restJs.put("success", true);
		return ok(restJs);
	}
	
	public static Result getActas(Long id) {
		
		
		String sql = " SELECT ar.numero numero,e.nombre ejercicio FROM autorizado_lineas al "+
					 " INNER JOIN autorizado_linea_actas ala ON al.id = ala.autorizado_linea_id "+
					 " INNER JOIN actas_recepcion ar ON ar.id = ala.acta_recepcion_id " +
					 " INNER JOIN ejercicios e ON e.id=ar.ejercicio_id "+
					 " WHERE al.id = :alid ";
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				   	  	 .setParameter("alid", id)
				   	  	 .findList();
		
		String actas = "";
		
		
		
		for(SqlRow sq:  s ) {
			actas += sq.getString("numero")+"/"+sq.getString("ejercicio")+", ";
		}
		
		if (s.isEmpty()) {
			actas = "Sin acta";
		}
		
		
		return ok(actas.replaceAll(", $", ""));
	}
	
}
