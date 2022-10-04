package models;

import java.math.BigDecimal;
import java.util.Date;

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
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "agente_estudios")
public class AgenteEstudio extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agente_estudios_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	@Required(message="Debe tener un agente asociado.")
	public Long agente_id;
	
	@ManyToOne
	@JoinColumn(name="estudio_nivel_id", referencedColumnName="id", insertable=false, updatable=false)
	public EstudioNivel estudioNivel;
	@Required(message="Debe seleccionar un nivel de estudio.")
	public Long estudio_nivel_id;
	
	@Required(message="Requiere titulo")
	public String titulo;
	
	@ManyToOne
	@JoinColumn(name="estudio_estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public EstudioEstado estudioEstado;
	@Required(message="Debe seleccionar un estado de estudio.")
	public Long estudio_estado_id;
	
	
	@ManyToOne
	@JoinColumn(name="estudio_subarea_id", referencedColumnName="id", insertable=false, updatable=false)
	public EstudioSubarea estudioSubarea;
	@Required(message="Debe seleccionar un area")
	public Long estudio_subarea_id;
	
	@ManyToOne
	@JoinColumn(name="estudio_institucion_id", referencedColumnName="id", insertable=false, updatable=false)
	public EstudioInstitucion estudioInstitucion;
	@Required(message="Debe seleccionar una institucion")
	public Long estudio_institucion_id;
	
	public String otra_institucion;
	
	@ManyToOne
	@JoinColumn(name="pais_id", referencedColumnName="id", insertable=false, updatable=false)
	public Pais pais;
	@Required(message="Debe seleccionar un pais")
	public Long pais_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date finicio;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date ffin;
	
	public String descripcion;
	
	@DecimalComa(value="")
	public BigDecimal promedio;
	
	public Integer materia_carrera;
	
	public Integer materia_aprobadas;
	
	
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
	
	public static Finder<Long,AgenteEstudio> find = new Finder<Long,AgenteEstudio>(Long.class, AgenteEstudio.class);
	
	public static Pagination<AgenteEstudio> page(Long agenteId) {    	
    	Pagination<AgenteEstudio> p = new Pagination<AgenteEstudio>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("agente_id", agenteId));
    	return p;
	}
	
}
