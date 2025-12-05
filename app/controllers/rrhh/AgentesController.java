package controllers.rrhh;

import static play.data.Form.form;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import models.Agente;
import models.AgenteNovedad;
import models.AgenteOrganigrama;
import models.CertificacionCompra;
import models.Estado;
import models.Usuario;
import models.auth.Permiso;
import models.haberes.PuestoLaboral;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import utils.UriTrack;
import utils.pagination.Pagination;
import utils.validation.DateValidation;
import utils.validation.EmailFormatValidation;
import utils.validation.Validator;
import views.html.sinPermiso;
import views.html.compras.certificacionesCompras.crearCertificacion;
import views.html.contabilidad.facturas.acciones.modalPasarEnPreCurso;
import views.html.haberes.liquidacionPuestos.modales.modalReciboSueldoPorPuestoMail;
import views.html.rrhh.agente.*;

@Security.Authenticated(Secured.class)
public class AgentesController extends Controller {

	final static Form<Agente> agenteForm = form(Agente.class);

	public static Result URL_LISTA_AGENTE = redirect(
			controllers.rrhh.routes.AgentesController.indexAgente()
	);

	@CheckPermiso(key = "agentesVer")
	public static Result indexAgente() {
		DynamicForm d = form().bindFromRequest();

		return ok(
				indexAgente.render(
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
								 RequestVar.get("puesto_id"),
								 RequestVar.get("solo_servicio")
								 ),
								 d));

	}

	@CheckPermiso(key = "agentesCrear")
	public static Result crearAgente() {

		Form<Agente> agenteForm = form(Agente.class);
		agenteForm.discardErrors();
		Agente a = null;
		return ok(crearAgente.render(agenteForm,a));
	}

	@CheckPermiso(key = "agentesCrear")
	public static Result guardarAgente() {

		Form<Agente> agenteForm = form(Agente.class).bindFromRequest();
		Agente a = new Agente();
		if(agenteForm.hasErrors()) {
			flash("error", "Error en formulario");
			System.out.println(agenteForm.errors());
			return badRequest(crearAgente.render(agenteForm,a));
		}
		a = agenteForm.get();


		if(a.fingresooriginal.after(a.fingreso)) {
			flash("error", "La Fecha Principal debe ser Mayor a la Fecha Ingreso");
			agenteForm.reject("fingresooriginal","La Fecha Principal debe ser Mayor a la Fecha Ingreso");
			return badRequest(crearAgente.render(agenteForm,a));
		}

		if(agenteForm.get().email != null && !agenteForm.get().email.isEmpty()) {
			if(!EmailFormatValidation.EmailValidation(agenteForm.get().email)) {
				flash("error", "Email Inválido");
				agenteForm.reject("email","Email Inválido");
				return badRequest(crearAgente.render(agenteForm,a));
			}
		}


		List<Agente> aed = Agente.find.where().eq("dni", a.dni).findList();
		if(aed.size() > 0){
			agenteForm.reject("dni","Ya existe una persona con el mismo DNI.");
			flash("error", "Error en formulario");
			return badRequest(crearAgente.render(agenteForm,a));
		}

		List<Agente> aec = Agente.find.where().eq("cuit", a.cuit).findList();
		if(aec.size() > 0){
			agenteForm.reject("cuit","Ya existe una persona con el mismo CUIT.");
			flash("error", "Error en formulario");
			return badRequest(crearAgente.render(agenteForm,a));
		}

		try {
			a.estado_id = (long) Estado.AGENTE_BORRADOR;
			a.create_usuario_id = new Long(Usuario.getUsuarioSesion());
			a.create_date = new Date();
			a.write_email_date = new Date();
			a.save();

			flash("success", "El agente se ha actualizado");
			return redirect( controllers.rrhh.routes.AgentesController.ver( a.id )+ UriTrack.get("&"));
		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el agente");
			return badRequest(crearAgente.render(agenteForm,a));
		}

		//return URL_LISTA_AGENTE;
	}

	@CheckPermiso(key = "agentesCrear")
	public static Result editarAgente(Long id) {
		Agente agente = Ebean.find(Agente.class, id);
		return ok(editarAgente.render(agenteForm.fill(agente),agente));
	}

	@CheckPermiso(key = "agentesCrear")
	public static Result actualizarAgente(Long agenteId){

		Form<Agente> agenteForm = form(Agente.class).bindFromRequest();
		Agente at = Agente.find.byId(agenteId);


		try {


			if(agenteForm.hasErrors()) {
				flash("error", "Error en formulario");
				return badRequest(editarAgente.render(agenteForm,at));
			} else {
				Agente a = agenteForm.get();
				Date fbaja = a.fbaja;
				Long tipo_residencia_id = a.tipo_residencia_id;

				if(agenteForm.get().email != null && !agenteForm.get().email.isEmpty()) {
					if(!EmailFormatValidation.EmailValidation(agenteForm.get().email)) {
						flash("error", "Email Inválido");
						agenteForm.reject("email","Email Inválido");
						return badRequest(editarAgente.render(agenteForm,at));
					}
				}



				if(a.fingresooriginal.after(a.fingreso)) {
					flash("error", "La Fecha Principal debe ser Mayor a la Fecha Ingreso");
					agenteForm.reject("fingresooriginal","La Fecha Principal debe ser Mayor a la Fecha Ingreso");
					return badRequest(editarAgente.render(agenteForm,at));
				}

				List<Agente> aed = Agente.find.where().eq("dni", a.dni).ne("id",a.id).findList();
				if(aed.size() > 0){
					agenteForm.reject("dni","Ya existe una persona con el mismo DNI.");
					flash("error", "Error en formulario");
					return badRequest(editarAgente.render(agenteForm,a));
				}

				List<Agente> aec = Agente.find.where().eq("cuit", a.cuit).ne("id",a.id).findList();
				if(aec.size() > 0){
					agenteForm.reject("cuit","Ya existe una persona con el mismo CUIT.");
					flash("error", "Error en formulario");
					return badRequest(editarAgente.render(agenteForm,a));
				}


				if(a.activo == false) {
					List<PuestoLaboral> pl = PuestoLaboral.find.where().eq("legajo.agente_id", a.id).eq("activo", true).findList();
					if(pl.size() > 0) {
						agenteForm.reject("activo","Tiene un Puesto Activo.");
						flash("error", "No se puede poner el Agente como INACTIVO ya que existen Puestos Laborales del Agente ACTIVOS.");
						return badRequest(editarAgente.render(agenteForm,a));
					}
				}

				if(at.email == null) {
					a.write_email_date = new Date();
				}else {
					if(at.email.compareToIgnoreCase(agenteForm.get().email) != 0) {
						a.write_email_date = new Date();
					}
				}
				a.estado_id = at.estado_id;
				a.write_usuario_id = new Long(Usuario.getUsuarioSesion());
				a.write_date = new Date();
				a.update();

				if (fbaja == null) {
					String cd = "update agentes set fbaja = null where id = :id";
					SqlUpdate update = Ebean.createSqlUpdate(cd).setParameter("id", a.id);
					update.execute();
				}

				if (tipo_residencia_id == null) {
					String cd = "update agentes set tipo_residencia_id = null where id = :id";
					SqlUpdate update = Ebean.createSqlUpdate(cd).setParameter("id", a.id);
					update.execute();
				}

				flash("success", "El agente se ha actualizado");
				return redirect( controllers.rrhh.routes.AgentesController.ver( a.id )+ UriTrack.get("&"));
			}

		} catch (PersistenceException pe){
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido almacenar el agente");
			return badRequest(editarAgente.render(agenteForm,at));
		}
		//return URL_LISTA_AGENTE;
	}

	@CheckPermiso(key = "agentesEliminar")
	public static Result eliminarAgente(Long id) {
		try {
			Agente.find.byId(id).delete();
			flash("success", "Se ha eliminado el agente");
		} catch (PersistenceException pe) {
			System.out.println(pe);
			play.Logger.error("excepcion", pe);
			flash("error", "No se ha podido eliminar el agente");
		}

		return URL_LISTA_AGENTE;
	}

	@CheckPermiso(key = "agentesVer")
	public static Result ver(Long id) throws IOException {
		Agente agente = Agente.find.byId(id);

		List<PuestoLaboral> pl = PuestoLaboral.find.where().eq("legajo.agente_id", agente.id).orderBy("id").findList();

		if(agente == null){
			flash("error", "No se encuentra el agente.");
			return URL_LISTA_AGENTE;
		}

		return ok(verAgente.render(agenteForm.fill(agente),agente,pl));
	}

	public static Result suggestAgenteByOrganigramaSesion(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode agente = rpta.arrayNode();

	    Agente ad = new Agente();

		for(Agente a : ad.getDataSuggestByOrganigramaSesion(input, 25)){

			Logger.debug(a.id+"  ---- "+a.create_date);
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        //restJs.put("value",a.apellido+" "+a.nombre);
	        restJs.put("value",a.apellido);

	        String info = "";
	        if(a.organigrama != null){
	        	info += a.organigrama.nombre;
	        }

	        if(a.cuit != null){
	        	info += " - "+a.cuit;
	        }


	        restJs.put("info", info);
	        agente.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", agente);

		return ok(response);
	}

	public static Result suggestAgente(String input) {

		ObjectNode rpta = Json.newObject();
	    ArrayNode agente = rpta.arrayNode();

	    Agente ad = new Agente();

		for(Agente a : ad.getDataSuggest(input, 25)){

			Logger.debug(a.id+"  ---- "+a.create_date);
			ObjectNode restJs = Json.newObject();
	        restJs.put("id", a.id);
	        //restJs.put("value",a.apellido+" "+a.nombre);
	        restJs.put("value",a.apellido);

	        String info = "";
	        if(a.organigrama != null){
	        	info += a.organigrama.nombre;
	        }

	        if(a.cuit != null){
	        	info += " - "+a.cuit;
	        }


	        restJs.put("info", info);
	        agente.add(restJs);
		}

		ObjectNode response = Json.newObject();
		response.put("results", agente);

		return ok(response);
	}

	public static Result get(Long id){
		//Agente agente = Agente.find.select("id, nombre, apellido").where().eq("id", id).findUnique();
		Agente agente = Agente.find
						.fetch("organigrama","nombre")
						.where().eq("id", id).findUnique();

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		if(agente == null) {
			restJs.put("success", false);
			restJs.put("message", "No se encuentra el agente");
		} else {
			restJs.put("success", true);
			restJs.put("id", agente.id);
			restJs.put("nombre", agente.getNombreCompleto());
		}
		nodo.add(restJs);
		return ok(restJs);
	}

	public static Result actualizarMail(){

		DynamicForm d = form().bindFromRequest();
		d.discardErrors();

		ObjectNode result = Json.newObject();
		try {



			String email = null;
			if(!request().body().asFormUrlEncoded().get("email")[0].isEmpty()){
				email =  request().body().asFormUrlEncoded().get("email")[0];
			}

			if(email == null ){
				flash("error", "Debe escribir un mail");
				return ok(modalReciboSueldoPorPuestoMail.render(d));
			}

			Long idAgente = null;
			if(!request().body().asFormUrlEncoded().get("agente_id")[0].isEmpty()){
				idAgente = new Long(request().body().asFormUrlEncoded().get("agente_id")[0]);
			}

			if(idAgente == null ){
				flash("error", "No se encuentra el agente");
				return ok(modalReciboSueldoPorPuestoMail.render(d));
			}

			Long lpid = null;
			if(!request().body().asFormUrlEncoded().get("lpid")[0].isEmpty()){
				lpid =  new Long(request().body().asFormUrlEncoded().get("lpid")[0]);
			}

			Agente agente = Agente.find.where().eq("id", idAgente).findUnique();

			Map<String,String> b = new HashMap<String, String>();
			b.put("email",email);
			b.put("lpid",lpid.toString());
			b.put("agente_id",agente.id.toString());

			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			String ff = format1.format(agente.write_email_date);
			b.put("write_email_date",ff );

			if (!EmailFormatValidation.EmailValidation(email)) {
				flash("error", "Email Inválido");
				return ok(modalReciboSueldoPorPuestoMail.render(d));
			}else {
				agente.email = email;
				agente.write_email_date = new Date();
				agente.save();


				result.put("success", true);
				flash("success", "Se actualizo el mail.");
				result.put("html", modalReciboSueldoPorPuestoMail.render(d).toString());
				return ok(result);
			}

		} catch (Exception e){
			flash("error", "No se puede modificar los registros.");
			return ok(modalReciboSueldoPorPuestoMail.render(d));
		}
	}


	public static Result modalBuscar() {
    	Pagination<Agente> p = new Pagination<Agente>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(Agente.
    						find
    						.fetch("organigrama","nombre")
    						.where().ilike("apellido", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBusquedaAgente.render(p, form().bindFromRequest()) );
	}

	public static Result modalBuscarByOrgranigrama() {

		Pagination<Agente> p = new Pagination<Agente>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("apellido");
    	p.setExpressionList(Agente.
    						find
    						.fetch("organigrama","nombre")
    						.where()
    						.disjunction()
    						.eq("organigrama_id", Usuario.getUsurioSesion().organigrama_id)
    						.in("id",AgenteOrganigrama.getIdsAgentesByOrganigrama(Usuario.getUsurioSesion().organigrama_id))
    						.endJunction()
    						.ilike("apellido", "%" + RequestVar.get("nombre") + "%"));
		return ok( modalBuscarByOrgranigrama.render(p, form().bindFromRequest()) );
	}

	public static Result cambiarEstado(Long idAgente, Long idEstado) throws IOException{
		Estado estado = Estado.getEstado(idEstado,Estado.TIPO_ORDEN);

		Agente agente = Agente.find.byId(idAgente);

		if(idAgente == null){
			flash("error", "No se encuentra la factura.");
			return redirect(request().getHeader("referer"));
		}

		if(idEstado != null){
			Boolean permiso = false;
			switch ( idEstado.intValue() ) {
		      case  Estado.AGENTE_APROBADO:
		    	 if(!Permiso.check("agentePasarAprobado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				 }
		    	 pasarAprobado(agente.id);
		    	 break;
		      case  Estado.AGENTE_PREAPROBADO:
			    	 if(!Permiso.check("agentePasarPreAprobado")) {
						  return ok(sinPermiso.render(request().getHeader("referer")));
					 }
			    	 pasarPreAprobado(agente.id);
			  break;
		      case Estado.AGENTE_BORRADOR:
		    	 if(!Permiso.check("agentePasarBorrador")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				 }
		    	 pasarBorrador(agente.id);
		    	 break;
		      case Estado.AGENTE_CANCELADO:
		    	 if(!Permiso.check("agentePasarCancelado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				 }
		    	 pasarCancelado(agente.id);
		    	 break;
		     case Estado.AGENTE_CARGADO:
		    	 if(!Permiso.check("agentePasarCargado")) {
					  return ok(sinPermiso.render(request().getHeader("referer")));
				 }
		    	 pasarCargado(agente.id);
		         break;
		     default:
		         System.out.println("error" );
		         break;
		      }

		}

		return redirect(controllers.rrhh.routes.AgentesController.ver(agente.id) + UriTrack.get("&"));
	}

	public static void pasarAprobado(Long Agente){




		System.out.println("1111111111111111111xxxxxxxxx" );
		Ebean.beginTransaction();
		try {
			Agente agente = Ebean.find(Agente.class).select("id, estado_id,write_date,write_usuario_id").setId(Agente).findUnique();



			if(agente != null){

				if(agente.legajos.size() > 0) {

					List<AgenteNovedad> an = AgenteNovedad.find.where().eq("agente_id", agente.id).order("id desc").findList();

					if(an.size() > 0) {


						agente.write_usuario_id = new Long(Usuario.getUsuarioSesion());
						agente.write_date = new Date();
						agente.estado_id = new Long(Estado.AGENTE_APROBADO);
						agente.save();



						List<PuestoLaboral> pl = PuestoLaboral.find.where().eq("legajo.agente_id", agente.id).findList();
						if(pl.size() <= 0) {
							PuestoLaboral pln = new PuestoLaboral();
							pln.especialidad_id = agente.especialidad_id;
							pln.departamento_id = null;
							pln.legajo_id = agente.legajos.get(0).id;
							pln.convenio_ministerio = (agente.tipo_relacion_laboral.compareTo("3") != 0)?false:true;
							pln.fecha_posesion = agente.fingreso;
							pln.estado_id = (long) Estado.PUESTO_LABORAL_BORRADOR;
							pln.activo = true;
							pln.mail_automatico = true;
							pln.centro_costo_id = new Long(1);
							pln.unidad_laboral_id = new Long(1);
							pln.convenio_banco_id = new Long(1);
							pln.cargo_laboral_id = new Long(1);
							pln.instrumento_legal_id = new Long(1);

							pln.categoria_laboral_id = an.get(0).categoria_laboral_id;
							pln.escala_laboral_id = an.get(0).escala_laboral_id;
							pln.save();
						}
						Ebean.commitTransaction();

						flash("success", "Operación exitosa. Estado actual: Aprobado");
					}else {
						Ebean.rollbackTransaction();
						flash("error", "El agente debe tener al menos un Datos Contractuales cargado.");
					}
				}else {
					flash("error", "Error. El Agente no tiene legajo cargado. ");
				}
			} else {
				Ebean.rollbackTransaction();
				flash("error", "Error. No se ha podido cambiar el Estado del Agente.");
			}
		} catch (Exception e) {
			Ebean.rollbackTransaction();
			flash("error", "Error. No se ha podido cambiar el Estado del Agente." + e);
		}finally{
			Ebean.endTransaction();
		}

	}

	public static void pasarPreAprobado(Long Agente){

		Agente agente = Ebean.find(Agente.class).select("id, estado_id,write_date,write_usuario_id").setId(Agente).findUnique();

		if(agente != null){
			agente.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			agente.write_date = new Date();
			agente.estado_id = new Long(Estado.AGENTE_PREAPROBADO);
			agente.save();
			flash("success", "Operación exitosa. Estado actual: Preaprobado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	public static void pasarBorrador(Long Agente){

		Agente agente = Ebean.find(Agente.class).select("id, estado_id,write_date,write_usuario_id").setId(Agente).findUnique();

		if(agente != null){
			agente.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			agente.write_date = new Date();
			agente.estado_id = new Long(Estado.AGENTE_BORRADOR);
			agente.save();
			flash("success", "Operación exitosa. Estado actual: Borrador");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	public static void pasarCancelado(Long Agente){

		Agente agente = Ebean.find(Agente.class).select("id, estado_id,write_date,write_usuario_id").setId(Agente).findUnique();

		if(agente != null){
			agente.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			agente.write_date = new Date();
			agente.estado_id = new Long(Estado.AGENTE_CANCELADO);
			agente.save();
			flash("success", "Operación exitosa. Estado actual: Cancelado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}

	public static void pasarCargado(Long Agente){

		Agente agente = Ebean.find(Agente.class).select("id, estado_id,write_date,write_usuario_id").setId(Agente).findUnique();

		if(agente != null){
			agente.write_usuario_id = new Long(Usuario.getUsuarioSesion());
			agente.write_date = new Date();
			agente.estado_id = new Long(Estado.AGENTE_CARGADO);
			agente.save();
			flash("success", "Operación exitosa. Estado actual: Cargado");
		} else {
			flash("error", "Parámetros incorrectos");
		}
	}
}
