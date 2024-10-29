package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import models.auth.Permiso;
import models.haberes.Legajo;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;

@Entity
@Table(name = "agentes")
public class Agente extends Model{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agentes_id_seq")
	public Long id;
	@Required(message="Debe escribir un apellido")
	public String apellido;
	/*@Required(message="Debe escribir un nombre")
	public String nombre;*/

	@Required(message="Debe especificar el tipo de relación")
	public Boolean planta;
	@Required(message="Debe especificar si es activo o no")
	public Boolean activo;

	public Boolean asignacion_familiar;

	@Transient
	public String nombreCompleto;
	@Required(message="Cuit requerido")
	public String cuit;
	@Required(message="Debe escribir un documento")
	public String dni;
	@Required(message="Debe escribir un Sexo")
	public String sexo;
	@Required(message="Debe escribir una fecha de nacimiento")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fnacimiento;
	@Required(message="Debe seleccionar un estado civil")
	public String estado_civil;
	@Required(message="Debe seleccionar un tipo de relacion laboral")
	public String tipo_relacion_laboral;
	@Required(message="Debe escribir una fecha de ingreso")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fingreso;
	@Required(message="Debe escribir una fecha de ingreso principal")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fingresooriginal;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fbaja;

	@ManyToOne
	public Departamento departamento;
	public String tipo_documento;

	@ManyToOne(fetch=FetchType.LAZY)
	public Puesto puesto;
	public String pin;
	//public CuentaBancaria cuenta_bancaria;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	public Date create_date;
	public Date write_date;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date write_email_date;

	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario;
	@Column(name="write_usuario_id")
	public Long write_usuario_id;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	@Column(name="organigrama_id")
	@Required(message="Debe seleccionar un departamento/servicio")
	public Long organigrama_id;

	@ManyToOne
	@JoinColumn(name="profesion_id", referencedColumnName="id", insertable=false, updatable=false)
	public Profesion profesion;
	@Column(name="profesion_id")
	@Required(message="Debe seleccionar una Profesion")
	public Long profesion_id;

	@ManyToOne
	@JoinColumn(name="especialidad_id", referencedColumnName="id", insertable=false, updatable=false)
	public Especialidad especialidad;
	@Column(name="especialidad_id")
	public Long especialidad_id;

	@ManyToOne
	@JoinColumn(name="tipo_residencia_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoResidencia tipoResidencia;
	@Column(name="tipo_residencia_id")
	public Long tipo_residencia_id;

	@ManyToOne
	@JoinColumn(name="localidad_id", referencedColumnName="id", insertable=false, updatable=false)
	public Localidad localidad;

	@Column(name="localidad_id")
	@Required(message="Debe seleccionar una localidad")
	public Long localidad_id;

	@Required(message="Debe escribir un telefono")
	public String telefono;
	public String piso;
	public String depto;
	@Required(message="Debe escribir una calle")
	public String calle;
	public String calle_banco;

	@Required(message="Debe escribir un numero")
	public String numero;
	@Required(message="Debe escribir un CP")
	public String zip;
	//@Required(message="Debe escribir un Email")
	public String email;
	public String mobile;
	public String fax;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id;

	public String conyugue_nombre;
	public String conyugue_dni;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date finicio_matrimonio;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date flicencia_conducir;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date cud;

	@ManyToOne
	@JoinColumn(name="tipo_licencia_conducir_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoLicenciaConducir tipoLicenciaConducir;
	@Column(name="tipo_licencia_conducir_id")
	public Long tipo_licencia_conducir_id;

	@OneToMany
	public List<Legajo> legajos;

	public Integer nro_legajo_externo;

	@OneToMany
	public List<AgenteEstudio> estudios;

	/*@OneToMany
	public List<AgenteHijo> hijos;*/

	@OneToMany
	public List<AgenteRul> agenteRuls;

	@OneToMany
	public List<AgenteFamilia> familias;

	public Integer limite_guardia;

	public static Model.Finder<Long,Agente> find = new Finder<Long,Agente>(Long.class, Agente.class);

	@PostLoad
	public String getNombreCompleto() {
		String nc = "";
		if(apellido != null)
			nc += apellido;
		/*if(nombre != null)
			nc += ", " + nombre;*/
		return nc;
	}

	@Formula(select = "_c${ta}.cantidad_hijos", join = "left outer join (select agente_id, count(*) as cantidad_hijos from agente_familias af WHERE af.tipo_familia_id = 1 group by agente_id) as _c${ta} on _c${ta}.agente_id = ${ta}.id")
	public Integer cantidad_hijos;//Base

	public Integer getCantidadHijos(){
		if (cantidad_hijos == null)
			return new Integer(0);
		return cantidad_hijos;
	}

	public String getEstadoCivil() {
		EstadoCivil e = EstadoCivil.find.byId(new Long(estado_civil));

		return (e != null)?e.nombre:"";
	}

	public String getRelacionLaboral() {
		TipoRelacionLaboral e = TipoRelacionLaboral.find.byId(new Long(tipo_relacion_laboral));

		return (e != null)?e.nombre:"";
	}

	public String getSexoAbreviado() {
		return (sexo.compareToIgnoreCase("male") == 0)?"M":"F";
	}

	public String getDireccionCompleta() {

		return calle+" "+numero+" "+piso+" "+depto;
	}

	public List<Agente> getDataSuggest(String input,Integer limit){
		List<Agente> l = find.where()
				//.or(Ebean.getExpressionFactory().ilike("apellido", "%" + input + "%"), Ebean.getExpressionFactory().ilike("nombre", "%" + input + "%"))
				.ilike("apellido", "%" + input + "%")
				.setMaxRows(limit).orderBy("id")
			    .findList();

		return l;
	}

	public int getEdad() {
		int years = 0;

		try {
			if(fnacimiento != null) {
				Calendar fechaNac = Calendar.getInstance();
				fechaNac.setTime(fnacimiento);

		        Calendar fechaActual = Calendar.getInstance();

		        years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
		        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
		        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

		        if(months < 0 || (months==0 && days < 0)) {
		            years--;
		        }
		    }
		}catch (Exception e) {
			return years;
		}

		 return years;
    }

	public static Pagination<Agente> page(String nombre,
										  String cuit,
										  String organigrama_id,
										  String btnFiltro0,//borrador
										  String btnFiltro1,//cargada
										  String btnFiltro2,//aprobada
										  String btnFiltro3,//cancelada
										  String btnFiltro4,
										  String tipo_relacion_laboral,
										  String dni,
										  String activo,
										  String residente,
										  String asignacion_familiar,
										  String con_rul,
										  String profesion_id,
										  String escala_laboral_id,
										  String fingreso_desde,
										  String fingreso_hasta,
										  String especialidad_id,
										  String fcud_desde,
										  String fcud_hasta,
										  String puesto_id
										  ) {
    	Pagination<Agente> p = new Pagination<Agente>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("apellido");

    	ExpressionList<Agente> e = find
    							   .fetch("profesion","nombre")
    							   .fetch("organigrama","nombre")
    							   .fetch("puesto","nombre")
    							   .fetch("especialidad","nombre")
    							   .where();

    	if(!Permiso.check("verTodoAgentes")){
    		if(Usuario.getUsurioSesion().organigrama != null){
				e.eq("organigrama_id", Usuario.getUsurioSesion().organigrama.id);
			}else {
				e.eq("organigrama_id", 0);
			}
		}

    	if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty()|| !btnFiltro4.isEmpty()){
    		e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.AGENTE_BORRADOR);
			}
			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.AGENTE_CARGADO);
			}
			if(!btnFiltro2.isEmpty()){
				 e = e.eq("estado_id", Estado.AGENTE_APROBADO);
			}
			if(!btnFiltro3.isEmpty()){
				 e = e.eq("estado_id", Estado.AGENTE_CANCELADO);
			}
			if(!btnFiltro4.isEmpty()){
				 e = e.eq("estado_id", Estado.AGENTE_PREAPROBADO);
			}
			e = e.endJunction();
    	}

    	String  sqlx;
    	if(!con_rul.isEmpty()){
    		List<Integer> idsRul= new ArrayList<Integer>();
    		sqlx = "SELECT agente_id FROM agente_rul";
			List<SqlRow> s = Ebean.createSqlQuery(sqlx).findList();
			for(SqlRow sx :s){
				idsRul.add(sx.getInteger("agente_id"));
			}

    		e.in("id", idsRul);
    	}

    	if(!escala_laboral_id.isEmpty()){
    		List<Integer> idsAg= new ArrayList<Integer>();
    		sqlx = "SELECT agente_id FROM agente_novedades WHERE escala_laboral_id = :escala_laboral_id AND (activo is null OR activo <> false) ";
			List<SqlRow> s = Ebean.createSqlQuery(sqlx).setParameter("escala_laboral_id", Integer.parseInt(escala_laboral_id)).findList();
			for(SqlRow sx :s){
				idsAg.add(sx.getInteger("agente_id"));
			}

    		e.in("id", idsAg);
    	}

    	if(!activo.isEmpty()){
    		if(activo.compareToIgnoreCase("SI") == 0){
    			e.eq("activo", true);
    		}else{
    			e.eq("activo", false);
    		}
    	}

    	if(!puesto_id.isEmpty()){
    		e.eq("puesto_id", Integer.parseInt(puesto_id));
    	}

    	if(!residente.isEmpty()){
    		if(residente.compareToIgnoreCase("SI") == 0){
    			e.isNotNull("tipo_residencia_id");
    		}else if(residente.compareToIgnoreCase("basica") == 0){
    			e.eq("tipoResidencia.tipo", "basica");
    		}else if(residente.compareToIgnoreCase("posbasica") == 0){
    			e.eq("tipoResidencia.tipo", "posbasica");
    		}else{
    			e.isNull("tipo_residencia_id");
    		}
    	}

    	if(!asignacion_familiar.isEmpty()){
    		if(asignacion_familiar.compareToIgnoreCase("SI") == 0){
    			e.eq("asignacion_familiar", true);
    		}else{
    			e = e.disjunction();
    			e = e.isNull("asignacion_familiar");
    			e = e.eq("asignacion_familiar", false);
    			e = e.endJunction();
    		}
    	}

    	if(!organigrama_id.isEmpty()){
    		e.eq("organigrama_id", Integer.parseInt(organigrama_id));
    	}

    	if(!especialidad_id.isEmpty()){
    		e.eq("especialidad_id", Integer.parseInt(especialidad_id));
    	}

    	if(!profesion_id.isEmpty()){
    		e.eq("profesion_id", Integer.parseInt(profesion_id));
    	}

    	if(!tipo_relacion_laboral.isEmpty()){
    		e.eq("tipo_relacion_laboral", tipo_relacion_laboral);
    	}

    	if(!dni.isEmpty()){
    		e.ilike("dni", "%" + dni + "%");
    	}

    	if(!nombre.isEmpty()){
    		e.ilike("apellido", "%" + nombre + "%");
    		//.or(Ebean.getExpressionFactory().ilike("apellido", "%" + nombre + "%"), Ebean.getExpressionFactory().ilike("nombre", "%" + nombre + "%"))
    	}
    	if(!cuit.isEmpty()){
    		e.ilike("cuit", "%" + cuit + "%");
    	}

    	if(!fingreso_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fingreso_desde, "dd/MM/yyyy");
    		e.ge("fingreso", fpd);
    	}
		if(!fingreso_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fingreso_hasta, "dd/MM/yyyy");
    		e.le("fingreso", fph);
    	}

		if(!fcud_desde.isEmpty()){
    		Date fpdc = DateUtils.formatDate(fcud_desde, "dd/MM/yyyy");
    		e.ge("cud", fpdc);
    	}
		if(!fcud_hasta.isEmpty()){
    		Date fphc = DateUtils.formatDate(fcud_hasta, "dd/MM/yyyy");
    		e.le("cud", fphc);
    	}

    	p.setExpressionList(e);
    	return p;
    }

	public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> agentesSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE agentes " +
				"SET estado_id = :idEstado,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idEstado", idEstado);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", agentesSeleccionados);

		return update.execute();
	}
}
