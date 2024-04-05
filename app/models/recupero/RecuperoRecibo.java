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

import models.Estado;
import models.Usuario;
import models.auth.Permiso;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_recibos")
public class RecuperoRecibo extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_recibos_id_seq")
	public Long id;

	@Required(message="Debe escribir un numero")
	public String numero;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public String fecha;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;


	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date create_date;

	@ManyToOne
	@JoinColumn(name="state_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="state_id")
	public Long estado_id;

	public static Model.Finder<Long,RecuperoRecibo> find = new Finder<Long,RecuperoRecibo>(Long.class, RecuperoRecibo.class);

	public static Pagination<RecuperoRecibo> page(String numero,
													String expediente_id,
													String fecha_desde,
													String fecha_hasta){

			Pagination<RecuperoRecibo> p = new Pagination<RecuperoRecibo>();
			p.setOrderDefault("DESC");
			p.setSortByDefault("id");

			ExpressionList<RecuperoRecibo> e = find.where();

			if(!numero.isEmpty()) {
				e.eq("numero",  Integer.parseInt(numero));
			}

			if(!fecha_desde.isEmpty()){
				Date fd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
				e.ge("fecha", fd);
			}

			if(!fecha_hasta.isEmpty()){
				Date fh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
				e.le("fecha", fh);
			}

			/*if(!Permiso.check("verTodoRecupero")){
				if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
					e.eq("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
				}else{
					e.isNull("deposito_id");
				}
			}*/

			p.setExpressionList(e);
			return p;
	}


}
