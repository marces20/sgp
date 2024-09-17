package models.equipos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.Usuario;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionPuesto;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "equipo_historias")
public class EquipoHistoria extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="equipo_historias_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="equipo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Equipo equipo;
	@Required(message="Debe tener un equipo asociada")
	public Long equipo_id;

	@Required(message="Debe tener una descripcion")
	public String descripcion;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Debe tener una fecha")
	public Date fecha;

	@ManyToOne
	@JoinColumn(name="create_user", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario createUser;
	@Column(name="create_user")
	public Long create_user;

	public Date create_date;

	public static Model.Finder<Long,EquipoHistoria> find = new Finder<Long,EquipoHistoria>(Long.class, EquipoHistoria.class);

	public static Pagination<EquipoHistoria> page(Long equipoId) {
    	Pagination<EquipoHistoria> p = new Pagination<EquipoHistoria>();
    	p.setPageSize(5000000);
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(find.where().eq("equipo_id", equipoId));
    	return p;
	}


}
