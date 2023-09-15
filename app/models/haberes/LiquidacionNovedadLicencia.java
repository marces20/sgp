package models.haberes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import models.Agente;
import models.AgenteAsistenciaLicencia;
import models.Periodo;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_novedad_licencias")
public class LiquidacionNovedadLicencia extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_novedad_licencias_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="agente_asistencia_licencia_id", referencedColumnName="id", insertable=false, updatable=false)
	public AgenteAsistenciaLicencia agenteAsistenciaLicencia;
	@Required(message="Requiere un agente")
	public Long agente_asistencia_licencia_id;


	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	@Required(message="Requiere un periodo")
	public Long periodo_id;

	public Integer dias;

	public static Model.Finder<Long,LiquidacionNovedadLicencia> find = new Model.Finder<Long,LiquidacionNovedadLicencia>(Long.class, LiquidacionNovedadLicencia.class);

	public static Pagination<LiquidacionNovedadLicencia> page(String nombre,
			  String cuit,String dni,String periodo_id){

		Pagination<LiquidacionNovedadLicencia> p = new Pagination<LiquidacionNovedadLicencia>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("periodo_id, agenteAsistenciaLicencia.agente");

		ExpressionList<LiquidacionNovedadLicencia> e = find.
														fetch("periodo","nombre").
													   fetch("agenteAsistenciaLicencia").
													   fetch("agenteAsistenciaLicencia.agente","apellido,dni,cuit")
													   .where();
		if (!periodo_id.isEmpty()) {
	      e.eq("periodo_id", Integer.parseInt(periodo_id));
	    }

		if(!dni.isEmpty()){
    		e.ilike("agenteAsistenciaLicencia.agente.dni", "%" + dni + "%");
    	}

    	if(!nombre.isEmpty()){
    		e.ilike("agenteAsistenciaLicencia.agente.apellido", "%" + nombre + "%");
    		//.or(Ebean.getExpressionFactory().ilike("apellido", "%" + nombre + "%"), Ebean.getExpressionFactory().ilike("nombre", "%" + nombre + "%"))
    	}
    	if(!cuit.isEmpty()){
    		e.ilike("agenteAsistenciaLicencia.agente.cuit", "%" + cuit + "%");
    	}


		p.setExpressionList(e);
		return p;
	}
}
