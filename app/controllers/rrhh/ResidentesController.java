package controllers.rrhh;

import static play.data.Form.form;

import controllers.Secured;
import models.Agente;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.rrhh.residente.indexResidente;

@Security.Authenticated(Secured.class)
public class ResidentesController extends Controller {

	public static Result indexResidente() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexResidente.render(
						Agente.page(
								 RequestVar.get("nombre"),
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
								 RequestVar.get("puesto_id")
								 ),
								 d));
	}
}
