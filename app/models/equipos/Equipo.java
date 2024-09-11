package models.equipos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import models.Estado;
import models.Organigrama;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionMes;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "equipos")
public class Equipo extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="equipos_id_seq")
	public Long id;

	@Required(message="Debe escribir un nombre")
	public String nombre;

	@Required(message="Debe escribir una descripcion")
	public String descripcion;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	@Required(message="Debe escribir un Lugar")
	public Long organigrama_id;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Required(message="Debe escribir un estado")
	public Long estado_id;

	public static Model.Finder<Long,Equipo> find = new Finder<Long,Equipo>(Long.class, Equipo.class);

	public static Pagination<Equipo> page(Long liquidacionPuestoId) {
    	Pagination<Equipo> p = new Pagination<Equipo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Equipo> e = find.where();

    	p.setExpressionList(e);

    	return p;
	}



}
