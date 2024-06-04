package models.haberes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;

import models.Agente;
import models.AgenteAsistenciaLicencia;
import models.Estado;
import models.Expediente;
import models.Periodo;
import models.Usuario;
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


	@ManyToOne
	@JoinColumn(name="write_user_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_user;
	@Column(name="write_user_id")
	public Long write_user_id;

	public Date write_date;

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
															    String btnFiltro2,
															    String btnFiltro3,
															    String btnFiltro4,
															    String periodo_exacto_id,
															    String residente){

		Pagination<LiquidacionNovedadLicencia> p = new Pagination<LiquidacionNovedadLicencia>();
		p.setOrderDefault(" ");
		p.setSortByDefault("periodo_id DESC, agenteAsistenciaLicencia.agente.apellido ASC");

		ExpressionList<LiquidacionNovedadLicencia> e = find.
													   fetch("periodo","nombre").
													   fetch("estado", "nombre").
													   fetch("agenteAsistenciaLicencia").
													   fetch("agenteAsistenciaLicencia.ejercicio","id,nombre").
													   fetch("agenteAsistenciaLicencia.agente","apellido,dni,cuit,tipo_relacion_laboral,activo,organigrama_id,tipo_residencia_id").
													   fetch("agenteAsistenciaLicencia.agente.organigrama","nombre").
													   where();
		if(!residente.isEmpty()){
    		if(residente.compareToIgnoreCase("SI") == 0){
    			e.isNotNull("agenteAsistenciaLicencia.agente.tipo_residencia_id");
    		}else if(residente.compareToIgnoreCase("NO") == 0){
    			e.isNull("agenteAsistenciaLicencia.agente.tipo_residencia_id");
    		}
		}

		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty() || !btnFiltro4.isEmpty()){
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
			if(!btnFiltro3.isEmpty()){
				 e = e.eq("estado_id", Estado.LIQUIDACION_LICENCIAS_NOVEDADES_AREVISAR);
			}
			if(!btnFiltro4.isEmpty()){
				 e = e.eq("estado_id", Estado.LIQUIDACION_LICENCIAS_NOVEDADES_ELIMINADO);
			}

			e = e.endJunction();
    	}

		if (!ejercicio.isEmpty()) {
	      e.eq("agenteAsistenciaLicencia.ejercicio_id", Integer.parseInt(ejercicio));
	    }else {

	    	 e.ge("agenteAsistenciaLicencia.ejercicio_id", new  Long(13));
	    }

		if (!periodo_id.isEmpty()) {
	      e.le("periodo_id", Integer.parseInt(periodo_id));
	    }

		if (!periodo_exacto_id.isEmpty()) {
		      e.eq("periodo_id", Integer.parseInt(periodo_exacto_id));
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
