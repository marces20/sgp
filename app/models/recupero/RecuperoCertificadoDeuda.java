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

import models.Expediente;
import models.Usuario;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_certificado_deudas")
public class RecuperoCertificadoDeuda extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_certificado_deudas_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Seleccion Expediente")
	public Integer expediente_id;

	@DecimalComa(value="")
	@Required(message="Requiere monto")
	public BigDecimal monto;

	@Required(message="Debe escribir un numero")
	public Integer numero;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	public Date create_date;

	public static Model.Finder<Long,RecuperoCertificadoDeuda> find = new Finder<Long,RecuperoCertificadoDeuda>(Long.class, RecuperoCertificadoDeuda.class);

	public static Pagination<RecuperoCertificadoDeuda> page(String numero,
															String expediente_id,
															String fecha){

		Pagination<RecuperoCertificadoDeuda> p = new Pagination<RecuperoCertificadoDeuda>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<RecuperoCertificadoDeuda> e = find
				.fetch("expediente")
				.where();

    	if(!numero.isEmpty()) {
    		e.ilike("numero", "%"+numero+"%");
    	}

    	p.setExpressionList(e);
    	return p;
	}
}
