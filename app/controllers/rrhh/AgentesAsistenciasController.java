package controllers.rrhh;

import static play.data.Form.form;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.avaje.ebean.Ebean;

import models.Agente;
import models.AgenteAsistenciaLicencia;
import models.Usuario;
import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import views.html.rrhh.agenteAsistencia.*;

@Security.Authenticated(Secured.class)
public class AgentesAsistenciasController extends Controller {

	public static Result URL_LISTA_AGENTE = redirect(
			controllers.rrhh.routes.AgentesAsistenciasController.index()
	);

	@CheckPermiso(key = "agentesLicencias")
	public static Result index() {
		DynamicForm d = form().bindFromRequest();

		return ok(indexAgenteAsistencia.render(
				Agente.page(RequestVar.get("nombre"),
				 RequestVar.get("cuit"),
				 RequestVar.get("organigrama_id"),
				 RequestVar.get("btnFiltro[0]"),//borrador
				 RequestVar.get("btnFiltro[1]"),//cargado
				 RequestVar.get("btnFiltro[2]"),//aprobado
				 RequestVar.get("btnFiltro[3]"),//cancelado
				 RequestVar.get("btnFiltro[4]"),//cancelado
				 RequestVar.get("tipo_relacion_laboral"),
				 RequestVar.get("dni"),
				 RequestVar.get("activo"),
				 RequestVar.get("residente"),
				 RequestVar.get("asignacion_familiar"),
				 RequestVar.get("con_rul"),
				 RequestVar.get("profesion_id"),
				 RequestVar.get("escala_laboral_id"),
				 RequestVar.get("fingreso_desde"),
				 RequestVar.get("fingreso_hasta"),
				 RequestVar.get("especialidad_id"),
				 RequestVar.get("fcud_desde"),
				 RequestVar.get("fcud_hasta"),
				 RequestVar.get("puesto_id"),
				 RequestVar.get("solo_servicio"),
				 RequestVar.get("asistencial")
				 ),d));

	}

	@CheckPermiso(key = "agentesLicencias")
	public static Result editar(Long id) {
		Agente agente = Ebean.find(Agente.class, id);
		return ok(editarAgenteAsistencia.render(agente));
	}

	@CheckPermiso(key = "agentesLicencias")
	public static Result actualizarAgente(Long agenteId){
		return redirect( controllers.rrhh.routes.AgentesAsistenciasController.ver(agenteId,0)+ UriTrack.get("&"));
	}

	@CheckPermiso(key = "agentesLicencias")
	public static Result ver(Long id,Long tipoLicencia) throws IOException {
		Form<AgenteAsistenciaLicencia> lineaForm = form(AgenteAsistenciaLicencia.class).bindFromRequest();
		Agente agente = Agente.find.byId(id);

		if(agente == null){
			flash("error", "No se encuentra el agente.");
			return URL_LISTA_AGENTE;
		}



		return ok(verAgenteAsistencia.render(agente,lineaForm,tipoLicencia,AgenteAsistenciaLicencia.getDiasLicenciaReglamentariaPorEjercicio(id)));
	}

}
