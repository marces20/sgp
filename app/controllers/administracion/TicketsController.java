package controllers.administracion;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.commons.mail.EmailException;

import models.Estado;
import models.Ticket;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.EmailUtilis;
import utils.RequestVar;
import views.html.administracion.tickets.crearTicket;
import views.html.administracion.tickets.editarTicket;
import views.html.administracion.tickets.indexTicket;
import views.html.administracion.tickets.verTicket;


public class TicketsController extends Controller {

  final static Form<Ticket> ticketForm = form(Ticket.class);

  public static Result URL_LISTA = redirect(routes.TicketsController.index());

  public static Result index() {
    DynamicForm d = form().bindFromRequest();


    return ok(indexTicket.render(Ticket.page(RequestVar.get("estado")), d));
  }

  public static Result crear() {
    return ok(crearTicket.render(form(Ticket.class)));
  }

  public static Result guardar() throws EmailException {
    Form<Ticket> ticketForm = form(Ticket.class).bindFromRequest();

    try {
      if (ticketForm.hasErrors()) {
        flash("error", "Error en formulario");
        return badRequest(crearTicket.render(ticketForm));
      } else {
        Ticket t = ticketForm.get();
        t.usuario_id = new Long(Usuario.getUsuarioSesion());
        t.fecha = new Date();
        t.estado_id = (long) Estado.TICKET_ABIERTO;
        t.leido = false;

        t.save();

        EmailUtilis eu = new EmailUtilis();
        eu.setSubject("SE CREO UN TICKET");
        eu.setHtmlMsg("Titulo:" + t.asunto + "<br> -- " + t.detalles);
        eu.setFrom("marces2000@gmail.com");

        List<String> adds = new ArrayList<>();
        adds.add("marces2000@gmail.com");
        eu.setAdds(adds);
        eu.enviar();

        flash("success", "El registro se actualizó correctamente.");
      }
    } catch (PersistenceException pe) {
      play.Logger.error("excepcion", pe);
      flash("error", "No se ha podido almacenar el registro");
      return badRequest(crearTicket.render(ticketForm));
    }

    return URL_LISTA;
  }

  public static Result editar(Long id) {

    Ticket t = Ticket.find.byId(id);
    return ok(editarTicket.render(ticketForm.fill(t)));
  }

  public static Result actualizar() {
    Form<Ticket> ticketForm = form(Ticket.class).bindFromRequest();

    try {
      if (ticketForm.hasErrors()) {
        flash("error", "Error en formulario");
        return badRequest(editarTicket.render(ticketForm));
      } else {
        Ticket t = ticketForm.get();
        t.update();
        flash("success", "El registro se actualizó correctamente.");
      }
    } catch (PersistenceException pe) {
      play.Logger.error("excepcion", pe);
      flash("error", "No se ha podido almacenar el registro");
      return badRequest(editarTicket.render(ticketForm));
    }

    return URL_LISTA;
  }

  public static Result ver(Long id) {

    Ticket t = Ticket.find.byId(id);
    ticketForm.fill(t);

    if (!t.leido && Usuario.getUsuarioSesion() == 1) {
      t.leido = true;
      t.update();
    }

    return ok(verTicket.render(t, ticketForm));
  }


  public static Result cambiarEstado(Long id, Long estado_id) {

    if (Usuario.getUsuarioSesion() != 1) {
      return URL_LISTA;
    }


    Ticket t = Ticket.find.byId(id);
    t.estado_id = estado_id;
    if (estado_id.compareTo((long) Estado.TICKET_CERRADO) == 0) {
      t.fecha_cierre = new Date();
    }
    t.update();

    return redirect(controllers.administracion.routes.TicketsController.ver(id));
  }


  public static Result eliminar(Long id) {

    if (Usuario.getUsuarioSesion() != 1) {
      return URL_LISTA;
    }


    Ticket t = Ticket.find.byId(id);
    t.delete();

    return redirect(controllers.administracion.routes.TicketsController.index());
  }


}
