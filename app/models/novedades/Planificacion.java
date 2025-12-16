package models.novedades;

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
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.annotation.Formula;

import models.Agente;
import models.Ejercicio;
import models.Estado;
import models.Novedad;
import models.Organigrama;
import models.Periodo;
import models.Usuario;
import models.auth.Permiso;
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

	public String referencia;

	@Required(message="Debe seleccionar un nombre")
	public String nombre;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	@Required(message="Debe seleccionar un servicio")
	public Integer organigrama_id;

	@Required(message="Debe especificar la fecha de inicio")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_inicio;

	@Required(message="Debe especificar la fecha de fin")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_fin;

	@ManyToOne
	@JoinColumn(name="tipo_planificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoPlanificacion tipoPlanificacion;
	@Required(message="Debe seleccionar un tipo")
	public Integer tipo_planificacion_id;

	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	@Required(message="Debe seleccionar un periodo")
	public Integer periodo_id;

	@ManyToOne
	@JoinColumn(name="periodo_liquidacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodoLiquidacion;
	public Integer periodo_liquidacion_id;

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

	public String nota_servicio;
	public String nota_rrhh;
	public String nota_liquidaciones;

	public boolean residencia = false;
	public boolean ocultas = false;


	@Formula(select = "_c${ta}.habiles", join = "left outer join (select planificacion_id, count(*) as habiles from novedades af  WHERE habiles = true group by planificacion_id) as _c${ta} on _c${ta}.planificacion_id = ${ta}.id")
	public Integer habiles;

	@Formula(select = "_d${ta}.inhabiles", join = "left outer join (select planificacion_id, count(*) as inhabiles from novedades af  WHERE habiles = false group by planificacion_id) as _d${ta} on _d${ta}.planificacion_id = ${ta}.id")
	public Integer inhabiles;

	@Formula(select = "_e${ta}.horashabiles", join = "left outer join (select planificacion_id, sum(horas) as horashabiles from novedades af  WHERE habiles = true group by planificacion_id) as _e${ta} on _e${ta}.planificacion_id = ${ta}.id")
	public Integer horashabiles;

	@Formula(select = "_f${ta}.horasinhabiles", join = "left outer join (select planificacion_id, sum(horas) as horasinhabiles from novedades af  WHERE habiles = false group by planificacion_id) as _f${ta} on _f${ta}.planificacion_id = ${ta}.id")
	public Integer horasinhabiles;

	public static Model.Finder<Long,Planificacion> find = new Finder<Long,Planificacion>(Long.class, Planificacion.class);

	public static List<Planificacion> getPlanificacionEnCursoByOrganigrama(){
		return find.where()
				.eq("organigrama_id", Usuario.getUsurioSesion().organigrama_id)
				.eq("estado_id", Estado.PLANIFICIACION_ENCURSO)
				.orderBy("id desc").findList();
	}

	public static Pagination<Planificacion> page(String organigrama_id ,
			String desde,
			String hasta,
			String btnFiltro0,
			String btnFiltro1,//imputado
			String btnFiltro2,
			String btnFiltro3,
			String btnFiltro4,
			String btnFiltro5,
			String btnFiltro6,
			String cliente_id) {
    	Pagination<Planificacion> p = new Pagination<Planificacion>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Planificacion> e = find.where();



    	if(!Permiso.check("verTodoPlanificacion")){
    		//e.eq("organigrama_id", Usuario.getUsurioSesion().organigrama.id);


        		List<Integer> ol = Organigrama.getOrganigramasIdsHijos( Usuario.getUsurioSesion().organigrama.id);
        		e.in("organigrama_id", ol);
        		//e.eq("organigrama_id", Integer.parseInt(organigrama_id));

		}

    	if(!Permiso.check("verPlanificacionResidencia")){
    		e.eq("residencia", false);
    	}

    	if(!Permiso.check("verPlanificacionOcultas")){
    		e.eq("ocultas", false);
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

		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty() || !btnFiltro4.isEmpty() || !btnFiltro5.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_BORRADOR);
			}

			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_ENCURSO);
			}

			if(!btnFiltro2.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_APROBADO_SERVICIO);
			}

			if(!btnFiltro3.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_APROBADO_ASISTENCIAL);
			}

			if(!btnFiltro4.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_APROBADO_RRHH);
			}

			if(!btnFiltro5.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_APROBADO_LIQUIDACIONES);
			}

			if(!btnFiltro6.isEmpty()){
				 e = e.eq("estado_id", Estado.PLANIFICIACION_CANCELADO);
			}

			e = e.endJunction();
		}

    	p.setExpressionList(e);
    	return p;
    }

	public List<Planificacion> getDataSuggest(String input,Integer limit){
		List<Planificacion> l = find.where()
				.disjunction()
				.ilike("referencia", "%" + input + "%")
				.ilike("nombre", "%" + input + "%")
				.endJunction()
				.setMaxRows(limit).orderBy("id")
			    .findList();

		return l;
	}

	public boolean controlPermisoDeposito() {
		boolean r = true;
		if(!Permiso.check("verTodoPlanificacion")){
			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){

				List<Integer> ol = Organigrama.getOrganigramasIdsHijos(Usuario.getUsurioSesion().organigrama.id);

				if(!ol.contains(organigrama_id)) {
					r = false;
				}

			}else {
				r = false;
			}
		}

		return r;
	}

	public boolean controlFechaEntreRango(Date fechaBuscar) {
		return fechaBuscar.compareTo(fecha_inicio) >= 0 && fechaBuscar.compareTo(fecha_fin) <= 0;
	}

}
