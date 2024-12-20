package controllers.dashboard;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.ClienteTipo;
import models.recupero.InformeTotal;

import com.avaje.ebean.SqlRow;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.dashboard.informesRecupero.*;
import controllers.Secured;

@Security.Authenticated(Secured.class)
public class InformesRecuperoController extends Controller {

	public static Result index() {
		return ok(index.render());
	}

	public static Result deudasPorTipoDeCliente(Long idTipoCliente) {

		List<SqlRow> deudasPorPaciente = new ArrayList<SqlRow>();
		List<SqlRow> deudasPorExtrajero = new ArrayList<SqlRow>();
		List<SqlRow> deudasPorObrasSociales = new ArrayList<SqlRow>();
		List<SqlRow> deudasPorArt = new ArrayList<SqlRow>();
		List<SqlRow> deudasPorSeguro = new ArrayList<SqlRow>();
		Map<Long, Integer> totalPagosObra = new HashMap<>();
		Map<Long, Date> pagoLastDateObra = new HashMap<>();


		DynamicForm d = form().bindFromRequest();


		if(idTipoCliente.equals(ClienteTipo.PACIENTES) || idTipoCliente.equals(new Long(-1))){
			deudasPorPaciente = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.PACIENTES,RequestVar.get("fecha_desde"),RequestVar.get("fecha_hasta"));
		}
		if(idTipoCliente.equals(ClienteTipo.EXTRANJEROS) || idTipoCliente.equals(new Long(-1))){
			deudasPorExtrajero = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.EXTRANJEROS,RequestVar.get("fecha_desde"),RequestVar.get("fecha_hasta"));
		}
		if(idTipoCliente.equals(ClienteTipo.OBRAS_SOCIALES) || idTipoCliente.equals(new Long(-1))){
			deudasPorObrasSociales = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.OBRAS_SOCIALES,RequestVar.get("fecha_desde"),RequestVar.get("fecha_hasta"));
			totalPagosObra = InformeTotal.getPagoClienteConDeudaPorTipoDeCliente(ClienteTipo.OBRAS_SOCIALES);
			pagoLastDateObra = InformeTotal.getPagoLastDateClienteConDeudaPorTipoDeCliente(ClienteTipo.OBRAS_SOCIALES);

		}
		if(idTipoCliente.equals(ClienteTipo.ART) || idTipoCliente.equals(new Long(-1))){
			deudasPorArt = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.ART,RequestVar.get("fecha_desde"),RequestVar.get("fecha_hasta"));
		}

		if(idTipoCliente.equals(ClienteTipo.SEGUROS) || idTipoCliente.equals(new Long(-1))){
			deudasPorSeguro = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.SEGUROS,RequestVar.get("fecha_desde"),RequestVar.get("fecha_hasta"));
		}


		return ok(deudasPorTipoDeCliente.render(idTipoCliente,
												deudasPorPaciente,deudasPorExtrajero,deudasPorObrasSociales,deudasPorArt,deudasPorSeguro,
												totalPagosObra,pagoLastDateObra,d,RequestVar.get("fecha_desde"),RequestVar.get("fecha_hasta")));
	}
}
