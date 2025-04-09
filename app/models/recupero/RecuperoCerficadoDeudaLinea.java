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

import models.Cliente;
import models.Usuario;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_certificado_deuda_lineas")
public class RecuperoCerficadoDeudaLinea extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_certificado_deudas_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="recupero_certificado_deuda_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoCertificadoDeuda recuperoCertificadoDeuda;
	@Required(message="Debe tener un certificado asociado")
	public Long recupero_certificado_deuda_id;

	@ManyToOne
	@JoinColumn(name="recupero_factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoFactura recuperoFactura;
	@Required(message="Debe tener una factura asociado")
	public Long recupero_factura_id;

	public String nota;

	@DecimalComa(value="")
	@Required(message="Requiere deuda")
	public BigDecimal deuda;


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

	public static Model.Finder<Long,RecuperoCerficadoDeudaLinea> find = new Finder<Long,RecuperoCerficadoDeudaLinea>(Long.class, RecuperoCerficadoDeudaLinea.class);

	public static Pagination<RecuperoCerficadoDeudaLinea> page(Long recuperoCertificadoDeudaId) {
    	Pagination<RecuperoCerficadoDeudaLinea> p = new Pagination<RecuperoCerficadoDeudaLinea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(find.fetch("recuperoCertificadoDeuda").fetch("recuperoFactura").where().eq("recupero_certificado_deuda_id", recuperoCertificadoDeudaId));
    	return p;
	}


}
