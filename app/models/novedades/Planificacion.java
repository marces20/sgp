package models.novedades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import models.Estado;
import models.Novedad;
import models.Organigrama;
import models.Periodo;
import models.Usuario;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "planificaciones")
public class Planificacion extends Model{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="planificaciones_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	public Integer organigrama_id;

	@Required(message="Debe especificar la fecha de inicio")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_inicio;

	@Required(message="Debe especificar la fecha de fin")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_fin;

	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	@Required(message="Debe seleccionar un periodo")
	public Integer periodo_id;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="estado_id")
	public Long estado_id;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	public Date create_date;

	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario;
	@Column(name="write_usuario_id")
	public Long write_usuario_id;

	public Date write_date;

	public static Model.Finder<Long,Planificacion> find = new Finder<Long,Planificacion>(Long.class, Planificacion.class);

	public static Pagination<Planificacion> page(String organigrama_id ,
			String desde,
			String hasta,
			String btnFiltro0,
			String btnFiltro1,//imputado
			String btnFiltro2) {
    	Pagination<Planificacion> p = new Pagination<Planificacion>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Planificacion> e = find.where();

		if(!organigrama_id.isEmpty()){
			 e.eq("organigrama_id", Integer.parseInt(organigrama_id));
		}



		if(!desde.isEmpty()){
			Date fd = DateUtils.formatDate(desde, "dd-MM-yyyy");
			e.ge("fecha_inicio", fd);
			System.out.println(fd +" ------ " );
		}
		if(!hasta.isEmpty()){
			Date fh = DateUtils.formatDate(hasta, "dd-MM-yyyy");
			e.le("fecha_inicio", fh);
			System.out.println(fh +" ------ " );
		}

		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_BORRADOR);
			}

			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_APROBADO);
			}

			if(!btnFiltro2.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_CANCELADO);
			}

			e = e.endJunction();
		}

    	p.setExpressionList(e);
    	return p;
    }



}
