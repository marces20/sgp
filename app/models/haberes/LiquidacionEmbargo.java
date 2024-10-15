package models.haberes;

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
	@Required(message = "Requiere fecha fin")
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

	public static Model.Finder<Long,LiquidacionEmbargo> find = new Finder<Long,LiquidacionEmbargo>(Long.class, LiquidacionEmbargo.class);

	public static Pagination<LiquidacionEmbargo> page(String puesto_laboral_id) {
    	Pagination<LiquidacionEmbargo> p = new Pagination<LiquidacionEmbargo>();
    	p.setPageSize(5000000);
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<LiquidacionEmbargo> e = find.where();
    	p.setExpressionList(e);

    	return p;
	}

}
