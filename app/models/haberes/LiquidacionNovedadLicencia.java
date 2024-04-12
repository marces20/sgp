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
import models.Estado;
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

	@ManyToOne
	@JoinColumn(name = "estado_id", referencedColumnName = "id", insertable = false, updatable = false)
	public Estado estado;
	public Long estado_id;

	public static Model.Finder<Long,LiquidacionNovedadLicencia> find = new Model.Finder<Long,LiquidacionNovedadLicencia>(Long.class, LiquidacionNovedadLicencia.class);

	public static Pagination<LiquidacionNovedadLicencia> page(String nombre,
										  						String cuit,
										  						String dni,
										  						String periodo_id,
										  						String tipo_relacion_laboral,
										  						String organigrama_id,
										  						String activo,
										  						String ejercicio,
										  						String btnFiltro0,//borrador
																String btnFiltro1,//cargada
															    String btnFiltro2){

		Pagination<LiquidacionNovedadLicencia> p = new Pagination<LiquidacionNovedadLicencia>();
		p.setOrderDefault(" ");
		p.setSortByDefault("periodo_id DESC, agenteAsistenciaLicencia.agente.apellido ASC");

		ExpressionList<LiquidacionNovedadLicencia> e = find.
													   fetch("periodo","nombre").
													   fetch("estado", "nombre").
													   fetch("agenteAsistenciaLicencia").
													   fetch("agenteAsistenciaLicencia.ejercicio","id,nombre").
													   fetch("agenteAsistenciaLicencia.agente","apellido,dni,cuit,tipo_relacion_laboral,activo,organigrama_id").
													   fetch("agenteAsistenciaLicencia.agente.organigrama","nombre").
													   where();

		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty()){
    		e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.LIQUIDACION_LICENCIAS_NOVEDADES_BORRADOR);
			}
			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.LIQUIDACION_LICENCIAS_NOVEDADES_CONTROLADO);
			}
			if(!btnFiltro2.isEmpty()){
				 e = e.eq("estado_id", Estado.LIQUIDACION_LICENCIAS_NOVEDADES_APROBADO);
			}

			e = e.endJunction();
    	}

		if (!ejercicio.isEmpty()) {
		      e.eq("agenteAsistenciaLicencia.ejercicio_id", Integer.parseInt(ejercicio));
		    }

		if (!periodo_id.isEmpty()) {
	      e.le("periodo_id", Integer.parseInt(periodo_id));
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

    	//if(!tipo_relacion_laboral.isEmpty()){
    		e.eq("agenteAsistenciaLicencia.agente.tipo_relacion_laboral", "1");
    	//}

    	if(!activo.isEmpty()){
    		if(activo.compareToIgnoreCase("SI") == 0){
    			e.eq("agenteAsistenciaLicencia.agente.activo", true);
    		}else{
    			e.eq("agenteAsistenciaLicencia.agente.activo", false);
    		}
    	}
    	if(!organigrama_id.isEmpty()){
    		e.eq("agenteAsistenciaLicencia.agente.organigrama_id", Integer.parseInt(organigrama_id));
    	}

		p.setExpressionList(e);
		return p;
	}
}
