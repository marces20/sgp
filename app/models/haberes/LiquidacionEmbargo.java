package models.haberes;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import models.Estado;
import models.Periodo;
import models.Proveedor;
import models.TipoEmbargo;
import models.Usuario;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_embargos")
public class LiquidacionEmbargo  extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_embargos_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name = "puesto_laboral_id", referencedColumnName = "id", insertable = false, updatable = false)
	public PuestoLaboral puestoLaboral;
	@Required(message = "Requiere un puesto laboral")
	public Long puesto_laboral_id;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	@Required(message = "Requiere fecha inicio")
	public Date fecha_inicio;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fecha_fin;

	@ManyToOne
	@JoinColumn(name = "estado_id", referencedColumnName = "id", insertable = false, updatable = false)
	public Estado estado;
	public Long estado_id;

	@ManyToOne
	@JoinColumn(name="create_user", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario createUser;
	public Long create_user;

	public Date create_date;

	@ManyToOne
	@JoinColumn(name="tipo_embargo_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoEmbargo tipoEmbargo;
	@Required(message = "Requiere tipo embargo")
	public Long tipo_embargo_id;

	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Requiere contraparte")
	public Integer proveedor_id;//Proveedor X

	@DecimalComa(value="")
	public BigDecimal importe;

	public static Model.Finder<Long,LiquidacionEmbargo> find = new Finder<Long,LiquidacionEmbargo>(Long.class, LiquidacionEmbargo.class);

	public static Pagination<LiquidacionEmbargo> page(String puesto_laboral_id,
													  String btnFiltro0, // borrador
												      String btnFiltro1, // preaprobado
												      String btnFiltro2, //cancelado
												      String btnFiltro3,// en espera
												      String btnFiltro4,// pos espera
												      String cm,
												      String tipo_embargo_id) {

    	Pagination<LiquidacionEmbargo> p = new Pagination<LiquidacionEmbargo>();

    	p.setOrderDefault("ASC");
    	p.setSortByDefault("puestoLaboral.legajo.agente.apellido");

    	ExpressionList<LiquidacionEmbargo> e = find
    			.fetch("estado", "id, nombre")
    			.fetch("proveedor", "nombre")
    	        .fetch("puestoLaboral.legajo.agente", "apellido")
    	        .where();

    	if (!puesto_laboral_id.isEmpty()) {
    		e.eq("puestoLaboral.id", Integer.parseInt(puesto_laboral_id));
    	}

    	if (!tipo_embargo_id.isEmpty()) {
    		e.eq("tipo_embargo_id", Integer.parseInt(tipo_embargo_id));
    	}

    	if (!cm.isEmpty()) {
	      if (cm.compareToIgnoreCase("SI") == 0) {
	        e.eq("puestoLaboral.convenio_ministerio", true);
	      } else {
	        e.eq("puestoLaboral.convenio_ministerio", false);
	      }
	    }

    	if (!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty()  || !btnFiltro3.isEmpty()   || !btnFiltro4.isEmpty() ) {
    	      e = e.disjunction();
    	      if (!btnFiltro0.isEmpty()) {
    	        e = e.eq("estado_id", Estado.LIQUIDACION_EMBARGO_BORRADOR);
    	      }
    	      if (!btnFiltro1.isEmpty()) {
    	        e = e.eq("estado_id", Estado.LIQUIDACION_EMBARGO_APROBADO);
    	      }
    	      if (!btnFiltro2.isEmpty()) {
    	        e = e.eq("estado_id", Estado.LIQUIDACION_EMBARGO_CANCELADO);
    	      }
    	      if (!btnFiltro3.isEmpty()) {
      	        e = e.eq("estado_id", Estado.LIQUIDACION_EMBARGO_ESPERA);
      	      }
    	      if (!btnFiltro4.isEmpty()) {
      	        e = e.eq("estado_id", Estado.LIQUIDACION_EMBARGO_POST_ESPERA);
      	      }


    	      e = e.endJunction();
    	    }

    	p.setExpressionList(e);

    	return p;
	}

}
