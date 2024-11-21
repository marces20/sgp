package controllers.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.ClienteTipo;
import models.recupero.InformeTotal;

import com.avaje.ebean.SqlRow;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
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

		if(idTipoCliente.equals(ClienteTipo.PACIENTES) || idTipoCliente.equals(new Long(-1))){
			deudasPorPaciente = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.PACIENTES);
		}
		if(idTipoCliente.equals(ClienteTipo.EXTRANJEROS) || idTipoCliente.equals(new Long(-1))){
			deudasPorExtrajero = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.EXTRANJEROS);
		}
		if(idTipoCliente.equals(ClienteTipo.OBRAS_SOCIALES) || idTipoCliente.equals(new Long(-1))){
			deudasPorObrasSociales = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.OBRAS_SOCIALES);
			totalPagosObra = InformeTotal.getPagoClienteConDeudaPorTipoDeCliente(ClienteTipo.OBRAS_SOCIALES);
			pagoLastDateObra = InformeTotal.getPagoLastDateClienteConDeudaPorTipoDeCliente(ClienteTipo.OBRAS_SOCIALES);

		}
		if(idTipoCliente.equals(ClienteTipo.ART) || idTipoCliente.equals(new Long(-1))){
			deudasPorArt = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.ART);
		}

		if(idTipoCliente.equals(ClienteTipo.SEGUROS) || idTipoCliente.equals(new Long(-1))){
			deudasPorSeguro = InformeTotal.getDeudaPorTipoDeCliente(ClienteTipo.SEGUROS);
		}


		return ok(deudasPorTipoDeCliente.render(idTipoCliente,
												deudasPorPaciente,deudasPorExtrajero,deudasPorObrasSociales,deudasPorArt,deudasPorSeguro,
												totalPagosObra,pagoLastDateObra));
	}
}
