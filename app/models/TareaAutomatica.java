package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "tareas_automaticas")
public class TareaAutomatica extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tareas_automaticas_id_seq")
	public Long id; 
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario usuario; 
	@Column(name="usuario_id")
	public Long usuario_id;
	
	@ManyToOne
	@JoinColumn(name="tipo_tarea_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoTarea tipoTarea; 
	@Column(name="tipo_tarea_id")
	public Long tipo_tarea_id;
	
	public static Finder<Long,TareaAutomatica> find = new Finder<Long,TareaAutomatica>(Long.class, TareaAutomatica.class);
	
}
