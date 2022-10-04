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

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "agente_seguimiento_lineas")
public class AgenteSeguimientoLinea extends Model{

private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agente_seguimiento_lineas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="agente_seguimiento_id", referencedColumnName="id", insertable=false, updatable=false)
	public AgenteSeguimiento agenteSeguimiento;
	@Required(message="Debe tener un agente seguimiento asociado.")
	public Long agente_seguimiento_id;
	
	@Required(message="Debe ingresar una observacion.")
	public String observacion;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;
	
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
	
	public static Model.Finder<Long,AgenteSeguimientoLinea> find = new Finder<Long,AgenteSeguimientoLinea>(Long.class, AgenteSeguimientoLinea.class);
	
	public static Pagination<AgenteSeguimientoLinea> page(Long agenteSeguimientoId) {    	
    	Pagination<AgenteSeguimientoLinea> p = new Pagination<AgenteSeguimientoLinea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("agente_seguimiento_id", agenteSeguimientoId));
    	return p;
	}
}
