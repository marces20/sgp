package models.recupero;

import java.math.BigDecimal;
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

import models.Estado;
import models.Usuario;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_recibo_facturas")
public class RecuperoReciboFactura  extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_recibo_facturas_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="recupero_factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoFactura recuperoFactura;
	@Column(name="recupero_factura_id")
	@Required(message="Debe tener un factura asociado")
	public Long recupero_factura_id;

	@ManyToOne
	@JoinColumn(name="recupero_recibo_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoRecibo recuperoRecibo;
	@Column(name="recupero_recibo_id")
	@Required(message="Debe tener un recibo asociado")
	public Long recupero_recibo_id;

	@DecimalComa(value="")
	@Required(message="Requiere monto")
	public BigDecimal monto;

	@DecimalComa(value="")
	public BigDecimal saldo;

	public BigDecimal getSaldo(){
		if (saldo == null)
			return new BigDecimal(0);
		return saldo;
	}

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;


	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date create_date;



	public static Model.Finder<Long,RecuperoReciboFactura> find = new Finder<Long,RecuperoReciboFactura>(Long.class, RecuperoReciboFactura.class);

	public static Pagination<RecuperoReciboFactura> page(Long recuperoReciboId){

			Pagination<RecuperoReciboFactura> p = new Pagination<RecuperoReciboFactura>();
			p.setOrderDefault("DESC");
			p.setSortByDefault("id");

			ExpressionList<RecuperoReciboFactura> e = find.where().eq("recupero_recibo_id", recuperoReciboId);



			p.setExpressionList(e);
			return p;
	}

}
