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

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "agente_rul")
public class AgenteRul extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agente_rul_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	@Required(message="Debe tener un agente asociado.")
	public Long agente_id;
	
	@ManyToOne
	@JoinColumn(name="tipo_relacion_laboral_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoRelacionLaboral tipoRelacionLaboral; 
	@Column(name="tipo_relacion_laboral_id")
	public Long tipo_relacion_laboral_id;
	
	@ManyToOne
	@JoinColumn(name="institucion_externa_id", referencedColumnName="id", insertable=false, updatable=false)
	public InstitucionExterna institucionExterna; 
	@Column(name="institucion_externa_id")
	public Long institucion_externa_id;
	
	public String nota;
	
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
	
	public static Model.Finder<Long,AgenteRul> find = new Finder<Long,AgenteRul>(Long.class, AgenteRul.class);
	
	public static Pagination<AgenteRul> page(Long agenteId) {    	
    	Pagination<AgenteRul> p = new Pagination<AgenteRul>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("agente_id", agenteId));
    	return p;
	}
}
