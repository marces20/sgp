package controllers.novedades;

import static play.data.Form.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Agente;
import models.AgenteOrganigrama;
import models.Estado;
import models.Novedad;
import models.Organigrama;
import models.Periodo;
import models.Usuario;
import models.haberes.PuestoLaboral;
import models.novedades.Planificacion;
import models.novedades.ProduccionPuestoPeriodo;
import models.novedades.TipoPlanificacion;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.novedades.planificaciones.tabs.*;

public class ProduccionGeneralController extends Controller {

	public static Result detallesPorAgentePorPlanificacion(Long idPlanificacion) {
		DynamicForm d = form().bindFromRequest();

		List<ProduccionPuestoPeriodo> ppp = ProduccionPuestoPeriodo.find.fetch("puestoLaboral.legajo.agente").where().eq("planificacion_id", idPlanificacion).orderBy("puestoLaboral.legajo.agente.apellido,codigo_ips").findList();

		Map<String,ProduccionPuestoPeriodo> pppTemplate = new HashMap<>();
		for (ProduccionPuestoPeriodo ppptmp: ppp) {
			pppTemplate.put(ppptmp.puestoLaboral.legajo.agente.apellido,ppptmp);
		}


		return ok(detallesPorAgentePorPlanificacionTemplate.render(ppp));


	}

	public static void importarPracticasByRismiAndOrganigrama(Long idOrganigrama) {

		Periodo p = Periodo.getPeriodoByDate(new Date());
		Organigrama  o = Organigrama.find.byId(idOrganigrama);


		Planificacion pla = new Planificacion();
		pla.nombre = "PRODUCCION "+p.getMesAnioStringPeriodo()+" "+o.nombre;
		pla.organigrama_id = idOrganigrama.intValue();
		pla.fecha_inicio = p.date_start;
		pla.fecha_fin= p.date_stop;
		pla.tipo_planificacion_id = TipoPlanificacion.PRODUCCION_GENERAL;
		pla.periodo_id = p.id.intValue();
		pla.estado_id = (long) Estado.PLANIFICIACION_ENCURSO;
		pla.create_usuario_id = new Long(1);
		pla.create_date = new Date();
		pla.nota_servicio = "";

		pla.save();

		List<Agente> agenteList = Agente.find.where()
				.eq("activo",true)
				.disjunction()
				.eq("organigrama_id", idOrganigrama)
				.in("id",AgenteOrganigrama.getIdsAgentesByOrganigrama(idOrganigrama))
				.endJunction()
				.orderBy("id")
			    .findList();

		for(Agente ax:agenteList) {
				PuestoLaboral pl = PuestoLaboral.find.fetch("legajo").where().eq("activo",true).eq("legajo.agente.id",ax.id ).findUnique();
				String dni = ax.dni;
				if(pl != null) {
					//ApiController.getPrestacionesTotalizado("d","d",dni,pl.id,p,pla);
				}else {

				}
		}

	}

}
