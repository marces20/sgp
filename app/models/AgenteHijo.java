package models;

import java.util.ArrayList;
import java.util.Calendar;
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

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "agente_hijos")
public class AgenteHijo extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agente_hijos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	@Required(message="Debe tener un agente asociado.")
	public Long agente_id;
	
	@Required(message="Requiere nombre.")
	public String nombre;
	
	@Required(message="Requiere dni.")
	public String dni;
	
	@ManyToOne
	@JoinColumn(name="estudio_nivel_id", referencedColumnName="id", insertable=false, updatable=false)
	public EstudioNivel estudioNivel;
	public Long estudio_nivel_id;
	
	@ManyToOne
	@JoinColumn(name="estudio_estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public EstudioEstado estudioEstado;
	public Long estudio_estado_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Requiere fecha nacimiento.")
	public Date fnacimiento;
	
	@Required(message="Debe especificar si es discapacitado o no")
	public Boolean discapacidad;
	
	public Integer discapacidad_nivel;
	
	@ManyToOne
	@JoinColumn(name="estado_civil_id", referencedColumnName="id", insertable=false, updatable=false)
	public EstadoCivil estadoCivil;
	@Required(message="Debe seleccionar un estado civil.")
	public Long estado_civil_id;
	
	@Required(message="Debe seleccionar el sexo")
	public String sexo;
	
	public String cod_convivencia;
	public String cod_actividad;
	@Required(message="Debe especificar si es vive o no")
	public Boolean vive;
	@Required(message="Debe especificar si es adoptado o no")
	public Boolean adoptado;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date finicio_certificado_ar;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date ffin_certificado_ar;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	@Required(message="Debe especificar si esta cargado el hijo en el conyugue o no.")
	public Boolean carga_en_conyugue;
	
	public int getEdad(){
		int edad = 0;
		if(fnacimiento != null){
			Calendar fechaNacimiento = Calendar.getInstance();
	        //Se crea un objeto con la fecha actual
	        Calendar fechaActual = Calendar.getInstance();
	        //Se asigna la fecha recibida a la fecha de nacimiento.
	        fechaNacimiento.setTime(fnacimiento);
	        //Se restan la fecha actual y la fecha de nacimiento
	        int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
	        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
	        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
	        //Se ajusta el año dependiendo el mes y el día
	        if(mes<0 || (mes==0 && dia<0)){
	            año--;
	        }
	        //Regresa la edad en base a la fecha de nacimiento
	        return año;
		}
		
		return edad;
	}
	
	public static List<AgenteHijo> controlCargaHijos(String dni,Long id){
		
		List<AgenteHijo> r = new ArrayList<AgenteHijo>();
		
		if(id != null){
			r = find.where().like("dni","%"+dni+"%").ne("id",id).findList();
		}else{
			r = find.where().like("dni","%"+dni+"%").findList();
		}
		
		return r;
	}
	
	public static Finder<Long,AgenteHijo> find = new Finder<Long,AgenteHijo>(Long.class, AgenteHijo.class);
	
	public static Pagination<AgenteHijo> page(Long agenteId) {    	
    	Pagination<AgenteHijo> p = new Pagination<AgenteHijo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("agente_id", agenteId));
    	return p;
	}
	
	
}
