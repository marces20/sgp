package models.rismi;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.recupero.RecuperoFactura;
import models.recupero.RecuperoFacturaLinea;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "rismi_factura_detalle")
public class RismiFacturaDetalle extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rismi_factura_detalle_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="rismi_factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public RismiFactura rismi_factura;
	@Required(message="Debe tener una factura asociado")
	public Long rismi_factura_id;

	@DecimalComa(value="")
	@Required(message="Requiere monto")
	public BigDecimal monto;

	public String producto;

	public static Model.Finder<Long,RismiFacturaDetalle> find = new Finder<Long,RismiFacturaDetalle>(Long.class, RismiFacturaDetalle.class);

	public static Pagination<RismiFacturaDetalle> page(Long rismiFacturaId) {
    	Pagination<RismiFacturaDetalle> p = new Pagination<RismiFacturaDetalle>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");

    	p.setExpressionList(find.where().eq("rismi_factura_id", rismiFacturaId));
    	return p;
	}
}
