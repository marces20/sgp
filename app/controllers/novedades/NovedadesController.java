package controllers.novedades;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Estado;
import models.Factura;
import models.Feriado;
import models.Novedad;
import models.OrganigramaGuardiaDato;
import models.Solicitud;
import models.Usuario;
import models.novedades.Planificacion;
import models.recupero.RecuperoFactura;
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
import views.html.novedades.calendar.*;
import views.html.novedades.listaNovedades.*;
import views.html.novedades.listaNovedades.acciones.*;

@Security.Authenticated(Secured.class)
public class NovedadesController extends Controller {

	@CheckPermiso(key = "verCalendario")
	public static Result indexListaNovedades() {
		DynamicForm d = form().bindFromRequest();



		return ok(indexListaNovedades.render(Novedad.page(RequestVar.get("agente_id"),
											Usuario.getUsurioSesion().organigrama_id.toString(),
											RequestVar.get("desde"),
											RequestVar.get("hasta"),
											RequestVar.get("planificacion_id"),
											"fecha_inicio ASC",
											null
											)
											,d));

	}

	@CheckPermiso(key = "verCalendario")
	public static Result listaNovedadesPlanificacion(Long idPlanificacion) {
		DynamicForm d = form().bindFromRequest();

		return ok(listaNovedadesPlanificacion.render(Novedad.page("",
															"",
															"",
															"",
															idPlanificacion.toString(),
															"fecha_inicio ASC",
															null)
															,d));


	}



	public static Result modalEliminarMasivo() {
		return ok(modalEliminarMasivo.render(form().bindFromRequest()));
	}

	public static Result eliminarMasivo() {

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		List<Integer> novedadSeleccionados = getSeleccionados();

		if(novedadSeleccionados.isEmpty()) {
			flash("error", "Seleccione al menos una novedad.");
			return ok(modalEliminarMasivo.render(d));
		}

		if(d.hasErrors())
			return ok(modalEliminarMasivo.render(d));

		ObjectNode result = Json.newObject();
		try {
			int count = 0;

			List<Novedad> novedades = Novedad.find.where().in("id", novedadSeleccionados).findList();
			for(Novedad n :novedades) {
				Novedad.find.byId(n.id).delete();
				count ++;
			}

			result.put("success", true);
			flash("success", "Se eliminaron " + count + " registros de "+ novedadSeleccionados.size() +" seleccionados.");
			result.put("html", modalEliminarMasivo.render(d).toString());
			return ok(result);
		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalEliminarMasivo.render(d));
		}
	}

	@CheckPermiso(key = "verCalendario")
	public static Result index() {

		Long agenteId = (!RequestVar.get("agente_id").isEmpty())?new Long(RequestVar.get("agente_id")):null;
	    Long servicioId =  (!RequestVar.get("servicio_id").isEmpty())?new Long(RequestVar.get("servicio_id")):Usuario.getUsurioSesion().organigrama_id;
		String btnFiltro0 = RequestVar.get("btnFiltro[0]"); // licencias
		String btnFiltro1 = RequestVar.get("btnFiltro[1]"); // guardias
		String btnFiltro2 = RequestVar.get("btnFiltro[2]");

		Map<String,String> p = new HashMap<String, String>();
		p.put("servicio.nombre",Usuario.getUsurioSesion().organigrama.nombre);
		p.put("servicio_id",Usuario.getUsurioSesion().organigrama_id.toString());

		DynamicForm d = form().bindFromRequest().bind(p);
		d.discardErrors();

		return ok(indexNovedades.render(d));

	}

	@CheckPermiso(key = "verCalendario")
	public static Result lista() {

		ObjectNode obj = Json.newObject();
	    ArrayNode s = obj.arrayNode();

	    Long agenteId = (!RequestVar.get("agente_id").isEmpty())?new Long(RequestVar.get("agente_id")):null;
	    Long servicioId =  (!RequestVar.get("servicio_id").isEmpty())?new Long(RequestVar.get("servicio_id")):Usuario.getUsurioSesion().organigrama_id;
		String btnFiltro0 = RequestVar.get("btnFiltro[0]"); // licencias
		String btnFiltro1 = RequestVar.get("btnFiltro[1]"); // guardias
		String btnFiltro2 = RequestVar.get("btnFiltro[2]");

		Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx "+servicioId);

		if(btnFiltro1.isEmpty()){
		    List<Novedad> novedades = Novedad.page(RequestVar.get("agente_id"),
		    									   //Usuario.getUsurioSesion().organigrama_id.toString(),
		    										servicioId.toString(),
		    									   RequestVar.get("desde"),
		    									   RequestVar.get("hasta"),RequestVar.get("planificacion_id"),
		    									   "fecha_inicio ASC",
		    									   "500000").getList();

		    Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxx "+Usuario.getUsurioSesion().organigrama_id.toString());

		    for (Novedad n : novedades) {
			    ObjectNode e = Json.newObject();
			    e.put("id", n.id.toString());
			    e.put("title", n.horas+"HS - "+n.agente.apellido);
			    e.put("start", utils.DateUtils.formatDate(n.fecha_inicio, "yyyy-MM-dd"));
			    e.put("color", n.servicio.color);
				s.add(e);
			}
		}

	    if(!btnFiltro0.isEmpty()){



	    	List<SqlRow>  licencias = Novedad.getDiasLicenciasByOrganigrama(
	    																	//Usuario.getUsurioSesion().organigrama_id,
	    																	servicioId,
	    																	agenteId);

		    for (SqlRow lx : licencias) {


		    	String data = lx.getString("apellido")+"-"+lx.getString("tipo_licencia");

			    ObjectNode e = Json.newObject();
			    e.put("id", lx.getLong("id").toString());
			    e.put("title", data);
			    e.put("start", utils.DateUtils.formatDate(lx.getDate("finicio"), "yyyy-MM-dd"));
			    e.put("end", utils.DateUtils.formatDate(lx.getDate("ffin"), "yyyy-MM-dd"));
			    e.put("color", "#FFB933");
				s.add(e);
			}
	    }
	    Logger.debug("sssssssssssssssssssssssss "+s.toString());

		return ok(s);
	}

	public static Result getFeriados(){

		ObjectNode o = Json.newObject();
		ArrayNode s = o.arrayNode();
		/*Feriado.getFeriados()
		List<Feriado> feriados = Feriado.find.findList();

		for (Feriado f : feriados) {
			s.add(utils.DateUtils.formatDate(f.fecha, "yyyy-MM-dd"));
		}*/

		for (Date f :  Feriado.getFeriados()) {
			s.add(utils.DateUtils.formatDate(f, "yyyy-MM-dd"));
		}

		o.put("feriados", s);
		return ok(o);
	}


	public static Result verNovedad(Long id) {
		Novedad n = Novedad.find.byId(id);

		return ok(views.html.novedades.listaNovedades.verNovedad.render(n));
	}

	public static Result ver(Long id) {
		Novedad n = Novedad.find.byId(id);

		return ok(views.html.novedades.calendar.verNovedad.render(n));
	}

	public static Result eliminar(Long id) {
		try {
			Novedad.find.byId(id).delete();
			flash("success", "Se ha eliminado la novedad");
		} catch (PersistenceException pe) {
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar la novedad");
		}

		return redirect(controllers.novedades.routes.NovedadesController.index()+UriTrack.get("?"));
	}

	public static Result crearMasiva() {



		Map<String,String> b = new HashMap<String, String>();

		b.put("servicio.nombre", Usuario.getUsurioSesion().organigrama.nombre);
		b.put("servicio_id", Usuario.getUsurioSesion().organigrama_id.toString());
		b.put("fecha_inicio", "01/01/2025");


		Form<Novedad> nForm = form(Novedad.class).bind(b);
		nForm.discardErrors();

		return ok(crearFechaMasivaNovedad.render(nForm));

	}

	public static Result guardarMasivo() {

		Form<Novedad> nForm = form(Novedad.class).bindFromRequest();
		ObjectNode restJs = Json.newObject();
		ObjectNode evento = Json.newObject();


		try {


			Logger.debug("111111111 "+nForm );
			Logger.debug("2222222222222222 "+nForm.data().get("fechas"));

			//			nForm.errors().remove("fecha_inicio");
//			nForm.data().put("fecha_inicio","01/01/2025");

			if(nForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(crearFechaMasivaNovedad.render(nForm));
			} else {

				if(nForm.data().get("fechas") != null && !nForm.data().get("fechas").isEmpty()) {


					Novedad e = nForm.get();

					Planificacion p = Planificacion.find.byId(e.planificacion_id.longValue());
					String[] fechasArray = nForm.data().get("fechas").split(",");

					for(String ftmp : fechasArray) {
						if(!p.controlFechaEntreRango(utils.DateUtils.formatDate(ftmp, "dd/MM/yyyy"))) {
							flash("error", "La fecha "+ftmp+" seleccionada esta fuera del rango de las fecha de planificación.");
							return ok(crearFechaMasivaNovedad.render(nForm));
						}
					}

					for(String ftmp : fechasArray) {



						Novedad ex = new Novedad();
						ex.agente_id = e.agente_id;
						ex.descripcion = e.descripcion;
						ex.servicio_id = e.servicio_id;
						ex.fecha_inicio = utils.DateUtils.formatDate(ftmp, "dd/MM/yyyy");
						ex.create_usuario_id = new Long(Usuario.getUsuarioSesion());
						ex.create_date = new Date();
						ex.planificacion_id = e.planificacion_id;
						ex.horas = e.horas;
						ex.save();


					}

					restJs.put("evento", evento);
					restJs.put("success", true);
					restJs.put("nuevo", true);




					return ok(restJs);
					//flash("success", "La novedad se ha creado correctamente");
				}else {
					flash("error", "Debe seleccionar fecha.");
					return ok(crearFechaMasivaNovedad.render(nForm));
				}
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la novedad");
			return badRequest(crearFechaMasivaNovedad.render(nForm));
		}

	}

	public static Result crear() {



		Map<String,String> b = new HashMap<String, String>();
		b.put("fecha_inicio", RequestVar.get("fecha"));
		b.put("servicio.nombre", Usuario.getUsurioSesion().organigrama.nombre);
		b.put("servicio_id", Usuario.getUsurioSesion().organigrama_id.toString());



		Form<Novedad> nForm = form(Novedad.class).bind(b);
		nForm.discardErrors();
		return ok(crearNovedad.render(nForm));

	}

	public static Result guardar() {

		Form<Novedad> nForm = form(Novedad.class).bindFromRequest();
		ObjectNode restJs = Json.newObject();
		ObjectNode evento = Json.newObject();
		try {
			Logger.debug("looooofechasfechas "+nForm );

			if(nForm.hasErrors()) {


				flash("error", "Error en formulario");
				return ok(crearNovedad.render(nForm));
			} else {

				Novedad e = nForm.get();


				Planificacion p = Planificacion.find.byId(e.planificacion_id.longValue());

				if(!p.controlFechaEntreRango(e.fecha_inicio)) {
					flash("error", "La fecha seleccionada esta fuera del rango de las fecha de planificación.");
					return ok(crearNovedad.render(nForm));
				}


				e.create_usuario_id = new Long(Usuario.getUsuarioSesion());
				e.create_date = new Date();
				e.save();

				Novedad n = Novedad.find.byId(e.id);
				restJs.put("success", true);
				restJs.put("nuevo", true);
				evento.put("id", n.id);
				evento.put("nombre", n.agente.apellido);
				evento.put("color", n.servicio.color);
				//evento.put("fecha", utils.DateUtils.formatDate(n.fecha_inicio, "yyyy-MM-dd'T'HH:mm:ss"));
				evento.put("fecha", utils.DateUtils.formatDate(n.fecha_inicio, "yyyy-MM-dd"));

				restJs.put("evento", evento);
				return ok(restJs);

				//flash("success", "La novedad se ha creado correctamente");
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la novedad");
			return badRequest(crearNovedad.render(nForm));
		}

	}

	public static Result editar(Long id) {
		Form<Novedad> nForm = form(Novedad.class).fill(Novedad.find.byId(id));
		return ok(editarNovedad.render(nForm));
	}

	public static Result actualizar() {
		Form<Novedad> nForm = form(Novedad.class).bindFromRequest();
		ObjectNode restJs = Json.newObject();
		ObjectNode evento = Json.newObject();
		try {

			if(nForm.hasErrors()) {
				flash("error", "Error en formulario");
				return ok(editarNovedad.render(nForm));
			} else {
				nForm.get().update();

				Novedad e = Novedad.find.byId(nForm.get().id);

				restJs.put("success", true);
				evento.put("id", e.id);
				evento.put("nombre", e.agente.apellido);
				evento.put("fecha", utils.DateUtils.formatDate(e.fecha_inicio, "yyyy-MM-dd'T'HH:mm:ss"));
				evento.put("color", e.servicio.color);
				restJs.put("evento", evento);
				return ok(restJs);
			}
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar la novedad");
			return badRequest(editarNovedad.render(nForm));
		}
	}

	public static List<Integer> getSeleccionados(){
		String[] checks = null;
		try {
			checks = request().body().asFormUrlEncoded().get("check_listado[]");
		} catch (NullPointerException e) {
		}

		List<Integer> ids = new ArrayList<Integer>();
		if(checks != null) {
			for (String id : checks) {
				ids.add(Integer.valueOf(id));
			}
		}
		return ids;
	}

}
