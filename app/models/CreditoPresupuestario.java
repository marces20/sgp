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

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;
import play.data.format.*;

@Entity
@Table(name = "creditos_presupuestarios")
public class CreditoPresupuestario extends Model{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="creditos_presupuestarios_id_seq")
	public Long id;

	@ManyToOne
	public Expediente expediente;

	@ManyToOne
	@Required(message="Debe elegir un ejercicio")
	public Ejercicio ejercicio;

	@Required(message="Debe escribir un nombre")
	public String nombre;

	public String estado;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	public Boolean plan_sumar = false;
	public Boolean afecta = false;

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

	@Formula(select = "_c${ta}.total", join = "left outer join (select credito_presupuestario_id, round(sum(monto)::numeric,2) as total from lineas_creditos_presupuestarios group by credito_presupuestario_id) as _c${ta} on _c${ta}.credito_presupuestario_id = ${ta}.id")
	public BigDecimal total;

	@Formula(select = "_d${ta}.total_recurso", join = "left outer join (select credito_presupuestario_id, round(sum(monto)::numeric,2) as total_recurso from lineas_recursos_presupuestarios group by credito_presupuestario_id) as _d${ta} on _d${ta}.credito_presupuestario_id = ${ta}.id")
	public BigDecimal total_recurso;

	public BigDecimal getTotal(){
		if (total == null)
			return new BigDecimal(0);
		return total;
	}

	public BigDecimal getTotalRecursos(){
		if (total_recurso == null)
			return new BigDecimal(0);
		return total_recurso;
	}


	public static Model.Finder<Long,CreditoPresupuestario> find = new Model.Finder<Long,CreditoPresupuestario>(Long.class, CreditoPresupuestario.class);

	public static Pagination<CreditoPresupuestario> page(String nombre,String ejercicio) {
    	Pagination<CreditoPresupuestario> p = new Pagination<CreditoPresupuestario>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<CreditoPresupuestario> e = find
    			.fetch("expediente")
    			.fetch("ejercicio")
    			.where();

    	if(!nombre.isEmpty())
			e.ilike("nombre", "%" + nombre + "%");

    	if(!ejercicio.isEmpty())
    		e.eq("ejercicio.id", Integer.parseInt(ejercicio));
    	p.setExpressionList(e);
    	return p;

    }
}
