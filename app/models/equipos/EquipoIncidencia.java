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

import models.Estado;
import models.Usuario;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "equipo_incidencias")
public class EquipoIncidencia extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="equipo_incidencias_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="equipo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Equipo equipo;
	@Required(message="Debe tener un equipo asociada")
	public Long equipo_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Debe tener una fecha")
	public Date fecha;

	@ManyToOne
	@JoinColumn(name="create_user", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario createUser;
	@Column(name="create_user")
	public Long create_user;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id;

	@Required(message="Debe tener una descripcion")
	public String descripcion;

	@ManyToOne
	@JoinColumn(name="tipo_incidencia_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoIncidencia tipoIncidencia;
	@Required(message="Debe tener una descripcion")
	public Long tipo_incidencia_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_cierre;

	public static Model.Finder<Long,EquipoIncidencia> find = new Finder<Long,EquipoIncidencia>(Long.class, EquipoIncidencia.class);

	public static Pagination<EquipoIncidencia> page(Long equipoId) {
    	Pagination<EquipoIncidencia> p = new Pagination<EquipoIncidencia>();
    	p.setPageSize(25);
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(find.where().eq("equipo_id", equipoId));
    	return p;
	}

}
