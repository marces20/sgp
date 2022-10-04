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

import models.haberes.CategoriaLaboral;
import models.haberes.EscalaLaboral;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "agente_novedades")
public class AgenteNovedad extends Model{

	private static final long serialVersionUID = 1L;
		
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agente_novedades_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	@Required(message="Debe tener un agente asociado.")
	public Long agente_id;
	
	@ManyToOne
	@JoinColumn(name="escala_laboral_id", referencedColumnName="id", insertable=false, updatable=false)
	public EscalaLaboral escalaLaboral;
	@Required(message="Requiere una escala")
	public Long escala_laboral_id;	
	
	@ManyToOne
	@JoinColumn(name="tipo_novedad_agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoNovedadAgente tipoNovedadAgente;
	@Required(message="Requiere un tipo")
	public Long tipo_novedad_agente_id;	
	
	public String observaciones;
	public String situacion;
	
	@Required(message="Requiere carga horaria")
	public Integer carga_horaria;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Requiere fecha")
	public Date fecha_inicio;
	
	@ManyToOne
	@JoinColumn(name="categoria_laboral_id", referencedColumnName="id", insertable=false, updatable=false)
	public CategoriaLaboral categoriaLaboral;
	@Required(message="Requiere una categoria")
	public Long categoria_laboral_id;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	public Date write_date; 
	
	public Boolean activo;
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	public static Model.Finder<Long,AgenteNovedad> find = new Finder<Long,AgenteNovedad>(Long.class, AgenteNovedad.class);
	
	public static Pagination<AgenteNovedad> page(Long agenteId) {    	
    	Pagination<AgenteNovedad> p = new Pagination<AgenteNovedad>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("agente_id", agenteId));
    	return p;
	}
}