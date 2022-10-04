package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.avaje.ebean.ExpressionList;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.libs.Time;
import utils.DateUtils;
import utils.RequestVar;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "novedades")
public class Novedad extends Model{
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="novedades_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	@Required(message="Debe seleccionar el agente")
	public Integer agente_id;
	
	@ManyToOne
	@JoinColumn(name="servicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama servicio;
	@Required(message="Debe seleccionar un servicio")
	public Integer servicio_id;
	
	@Required(message="Debe especificar la fecha de inicio")
	@Formats .DateTime(pattern="dd/MM/yyyy HH:mm") 
	public Date fecha_inicio; 
	
	@Formats .DateTime(pattern="HH:mm") 
	@Required(message="Debe especificar en tiempo en horas:minutos")
    public Date horas;
	
	public String descripcion;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	
	
	public static Model.Finder<Long,Novedad> find = new Finder<Long,Novedad>(Long.class, Novedad.class);
	
	public static Pagination<Novedad> page(String agente, String servicio, String desde, String hasta) {    	
    	Pagination<Novedad> p = new Pagination<Novedad>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<Novedad> e = find.where();
    	
		if(!agente.isEmpty()){
			 e.eq("agente_id", Integer.parseInt(agente));
		}
		
		if(!servicio.isEmpty()){
			 e.eq("servicio_id", Integer.parseInt(servicio));
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

		
    	p.setExpressionList(e);
    	return p;
    }
	
	

}
