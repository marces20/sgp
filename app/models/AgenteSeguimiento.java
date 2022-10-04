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

import com.avaje.ebean.ExpressionList;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "agente_seguimientos")
public class AgenteSeguimiento extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agente_seguimientos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	@Required(message="Debe tener un agente asociado.")
	public Long agente_id;
	
	@ManyToOne
	@JoinColumn(name="tipo_agente_seguimiento_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoAgenteSeguimiento tipoAgenteSeguimiento;
	@Required(message="Requiere un tipo")
	public Long tipo_agente_seguimiento_id;	
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fincio;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date ffin;
	
	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id;
	
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
	
	public static Model.Finder<Long,AgenteSeguimiento> find = new Finder<Long,AgenteSeguimiento>(Long.class, AgenteSeguimiento.class);
	
	public static Pagination<AgenteSeguimiento> page(String nombre,
													 String dni,
													 String tipo_agente_seguimiento,
													 String btnFiltro0,//borrador
													 String btnFiltro1,//proceso
													 String btnFiltro2//cerrada
													 ) {    	
    	Pagination<AgenteSeguimiento> p = new Pagination<AgenteSeguimiento>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<AgenteSeguimiento> e = find.where();
    	
    	if(!nombre.isEmpty()){
    		e.ilike("agente.apellido", "%" + nombre + "%");
    	}
    	
    	if(!dni.isEmpty()){
    		e.ilike("agente.dni", "%" + dni + "%");
    	}
    	
    	if(!tipo_agente_seguimiento.isEmpty()){
    		e.eq("tipo_agente_seguimiento_id", Integer.parseInt(tipo_agente_seguimiento));
    	}
    	
    	if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty()){
    		e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.AGENTE_SEGUIMIENTO_BORRADOR);
			}	
			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.AGENTE_SEGUIMIENTO_PROCESO);
			}
			if(!btnFiltro2.isEmpty()){
				 e = e.eq("estado_id", Estado.AGENTE_SEGUIMIENTO_CERRADO);
			}
			 
			e = e.endJunction();
    	}
    	
    	p.setExpressionList(e);
    	return p;
	}
	
}
