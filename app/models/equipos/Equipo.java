package models.equipos;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import models.Estado;
import models.Organigrama;
import models.haberes.CentroCosto;
import models.haberes.LiquidacionDetalle;
import models.haberes.LiquidacionMes;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "equipos")
public class Equipo extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="equipos_id_seq")
	public Long id;

	@Required(message="Debe escribir un nombre")
	public String nombre;

	@Required(message="Debe escribir un serie")
	public String serie;

	@Required(message="Debe escribir una descripcion")
	public String descripcion;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	@Required(message="Debe escribir un Lugar")
	public Long organigrama_id;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id;

	@Formula(select = "_c${ta}.base", join = "left outer join (select equipo_id, count(*) as base from equipo_incidencias group by equipo_id) as _c${ta} on _c${ta}.equipo_id = ${ta}.id")
	public Integer incidencias;//Base
	public Integer getIncidencias(){
		if (incidencias == null)
			return new Integer(0);
		return incidencias;
	}

	public static Model.Finder<Long,Equipo> find = new Finder<Long,Equipo>(Long.class, Equipo.class);

	public static Pagination<Equipo> page(String serial,
				String filtroBorrador,
			   String filtroFuncionado,
			   String filtroReparacion,
			   String filtroApagado) {
    	Pagination<Equipo> p = new Pagination<Equipo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Equipo> e = find.where();

    	if(!filtroBorrador.isEmpty() || !filtroFuncionado.isEmpty() || !filtroReparacion.isEmpty() || !filtroApagado.isEmpty()) {
    		e = e.disjunction();


	   		if(!filtroBorrador.isEmpty()){
	   			 e = e.eq("estado_id", Estado.EQUIPO_BORRADOR);
	   		}

	   		if(!filtroFuncionado.isEmpty()){
	   			 e = e.eq("estado_id", Estado.EQUIPO_FUNCIONANDO);
	   		}

	   		if(!filtroReparacion.isEmpty()){
	   			 e = e.eq("estado_id", Estado.EQUIPO_REPARACION);
	   		}

	   		if(!filtroApagado.isEmpty()){
	   			 e = e.eq("estado_id", Estado.EQUIPO_APAGADO);
	   		}

	   		e = e.endJunction();
    		p.parcheCountAllFormula = true;
    	}

    	p.setExpressionList(e);

    	return p;
	}

	public List<Equipo> getDataSuggest(String input,Integer limit){
		List<Equipo> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();

		return l;
	}

}
