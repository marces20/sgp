package models.recupero;

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

import models.Cliente;
import models.Usuario;
import models.auth.Permiso;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_libredeudas")
public class RecuperoLibreDeuda extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_libredeuda_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;
	public Integer cliente_id;

	@Required(message="Debe escribir una fecha vencimiento")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_vencimiento;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date create_date;

	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date write_date;

	@ManyToOne
	@JoinColumn(name="write_user_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_user;
	@Column(name="write_user_id")
	public Long write_user_id;

	public static Model.Finder<Long,RecuperoLibreDeuda> find = new Finder<Long,RecuperoLibreDeuda>(Long.class, RecuperoLibreDeuda.class);

	public static Pagination<RecuperoLibreDeuda> page(Long clienteId){


		Pagination<RecuperoLibreDeuda> p = new Pagination<RecuperoLibreDeuda>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(find.fetch("cliente").where().eq("cliente_id", clienteId));

		return p;
	}
}
