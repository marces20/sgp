package controllers.novedades;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Agente;
import models.AgenteOrganigrama;
import models.Estado;
import models.Organigrama;
import models.Periodo;
import models.Puesto;
import models.haberes.PuestoLaboral;
import models.novedades.Planificacion;
import models.novedades.ProduccioImagenesPuestoLaboralPeriodo;
import models.novedades.ProduccionPracticasImagenesRismi;
import models.novedades.ProduccionPuestoPeriodo;
import models.novedades.TipoPlanificacion;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.rismi.ApiController;
import views.html.novedades.planificaciones.tabs.*;
import views.html.novedades.produccion.imagenes.*;

@Security.Authenticated(Secured.class)
public class ProduccionImagenesController extends Controller {

	@CheckPermiso(key = "produccionImagenesVer")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexProduccionImagenes.render());
	}

	public static Result detallesPracticasImagenesMinutos(Long idPlanificacion,Integer periodo_id) {
		DynamicForm d = form().bindFromRequest();

		List<SqlRow> ppp = ProduccionPracticasImagenesRismi.getDetallesPracticasMinutos(idPlanificacion,periodo_id.longValue());

		return ok(detallesPracticasImagenesMinutosTemplate.render(ppp));
	}

	public static Result detallesProduccionImagenesTotalizados(Long idPlanificacion) {
		DynamicForm d = form().bindFromRequest();


		List<SqlRow> ppp = ProduccioImagenesPuestoLaboralPeriodo.getProduccionMes(idPlanificacion);

		return ok(detallesProduccionImagenesTotalizadosTemplate.render(ppp));
	}

	public static void importarPracticasImagenesByRismiAndOrganigrama(Long idOrganigrama) {

		Periodo p = Periodo.find.byId(new Long(171));
		Organigrama  o = Organigrama.find.byId(idOrganigrama);


		Planificacion pla = new Planificacion();
		pla.nombre = "PRODUCCION "+p.getMesAnioStringPeriodo()+" "+o.nombre;
		pla.organigrama_id = idOrganigrama.intValue();
		pla.fecha_inicio = p.date_start;
		pla.fecha_fin= p.date_stop;
		pla.tipo_planificacion_id = TipoPlanificacion.PRODUCCION_IMAGENES;
		pla.periodo_id = p.id.intValue();
		pla.estado_id = (long) Estado.PLANIFICIACION_ENCURSO;
		pla.create_usuario_id = new Long(1);
		pla.create_date = new Date();
		pla.nota_servicio = "";

		pla.save();

		List<com.avaje.ebean.SqlRow> pi = ProduccionPracticasImagenesRismi.getPuestosACalcular(p);
		for (SqlRow pix :pi) {

			if(pix.getLong("puesto_laboral_id") != null) {

				PuestoLaboral pl = PuestoLaboral.find.byId(pix.getLong("puesto_laboral_id"));

				if(pl.legajo.agente.organigrama_produccion_id != null && pl.legajo.agente.organigrama_produccion_id.compareTo(idOrganigrama) == 0) {

					Map<String,String> prod= ProduccionPracticasImagenesRismi.calcularProduccionImages(pl,p);

					ProduccioImagenesPuestoLaboralPeriodo ppp = new ProduccioImagenesPuestoLaboralPeriodo();
					ppp.puesto_laboral_id =pix.getLong("puesto_laboral_id");
					ppp.periodo_id = p.id.intValue();
					ppp.planificacion_id = pla.id;
					ppp.dias_mes = new Integer(prod.get("diasMes"));
					ppp.minutos_profesional = new Integer(prod.get("minutosProfesional"));
					ppp.minutos_practicas = new Integer(prod.get("minutosPracticas"));
					ppp.valor_minuto = new BigDecimal(prod.get("valorMinuto"));
					ppp.monto_sueldo = new BigDecimal(prod.get("monto_sueldo"));
					ppp.monto_especialidad = new BigDecimal(prod.get("monto_especialidad"));
					ppp.minutos_exedentes = new Integer(prod.get("minutosExedentes"));;
					ppp.produccion = new BigDecimal(prod.get("producccion"));
					ppp.create_date = new Date();
					ppp.save();
				}
			}
		}
	}
}
