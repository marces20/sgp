package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;
@Entity 
@Table(name = "lineas_recursos_presupuestarios")
public class LineaRecursoPresupuestario extends Model{
	
private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lineas_recursos_presupuestarios_id_seq")
	public Long id;
	
	 
	@ManyToOne
	@JoinColumn(name="credito_presupuestario_id", referencedColumnName="id", insertable=false, updatable=false)
	public CreditoPresupuestario creditoPresupuestario;
	@Required(message="Debe tener una cabecera asociada")
	public Long credito_presupuestario_id;
	
	
	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Debe tener una cuenta analitica asociada")
	public Long cuenta_analitica_id;
	
	@Required(message="Debe tener un monto")
	public BigDecimal monto;
	
	public String nombre;
	
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
	
	public static Model.Finder<Long,LineaRecursoPresupuestario> find = new Model.Finder<Long,LineaRecursoPresupuestario>(Long.class, LineaRecursoPresupuestario.class);
	
	public static Pagination<LineaRecursoPresupuestario> page(Long creditoPresupuestarioId) {    	
		Pagination<LineaRecursoPresupuestario> p = new Pagination<LineaRecursoPresupuestario>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.fetch("cuentaAnalitica").where().eq("credito_presupuestario_id", creditoPresupuestarioId));
    	return p;
    }
}
