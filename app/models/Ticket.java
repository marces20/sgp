package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;

import controllers.Secured;
import play.Play;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.mvc.Security;
import utils.pagination.Pagination;
@Entity
@Table(name = "tickets")

@Security.Authenticated(Secured.class)
public class Ticket extends Model {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tickets_id_seq")
	public Long id;

	@Required(message="Asunto es requerido")
	public String asunto;

	@Required(message="Detalle es requerido")
	public String detalles;

	public String prioridad;
	public Boolean leido;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;

	public Long estado_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_cierre;

	public String respuesta;

	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario usuario;
	public Long usuario_id;

	public static Model.Finder<Long,Ticket> find = new Model.Finder<Long,Ticket>(Long.class, Ticket.class);

	public String getPrioridad() {
		String prioridad = "";

		if ( this.prioridad != null ) {
			switch (this.prioridad) {
			case "baja":
				return "Baja";
			case "media":
				return "Media";
			case "alta":
				return "Alta";
			}
		}

		return prioridad;
	}


	public static Boolean tieneSinLeer() {
		return Ebean.createSqlQuery("select count(*) c from tickets where leido = false").findUnique().getInteger("c") > 0;
	}

	public static String getBase() {

		String url =Play.application().configuration().getString("db.default.url");
		if(url.contains("4.36")) {
			return "-PRODUCCION";
		}else {
			return "-WORKING-"+ url.subSequence(43, url.length());
		}
	}

	public static Pagination<Ticket> page(String estado) {
    	Pagination<Ticket> p = new Pagination<Ticket>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("fecha");



    	ExpressionList<Ticket> e = find.where();


    	//Si usuario en sesion no es el admin, traigo solo los tickets abierto por el usuario en sesion
    	Integer usuario = Usuario.getUsuarioSesion();
    	if(usuario != 1 && usuario != 57 && usuario != 3) {
    		e.eq("usuario_id", usuario);
    	}

    	if(!estado.isEmpty()) {
    		e.eq("estado_id", Integer.parseInt(estado));
    	}else {
    		e.eq("estado_id", Estado.TICKET_ABIERTO);
    	}

    	p.setExpressionList( e );

    	return p;
    }
}
