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

import models.Cliente;
import models.Usuario;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_factura_historias")
public class RecuperoFacturaHistoria extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_factura_historias_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="tipo_recupero_factura_historia_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoRecuperoFacturaHistoria tipoRecuperoFacturaHistoriaId;
	@Required(message="Debe tener un tipo asociado")
	public Long tipo_recupero_factura_historia_id;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	public String nota;

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

	public static Model.Finder<Long,RecuperoFacturaHistoria> find = new Finder<Long,RecuperoFacturaHistoria>(Long.class, RecuperoFacturaHistoria.class);

	public static Pagination<RecuperoFacturaHistoria> page(Long recuperoFacturaId) {
    	Pagination<RecuperoFacturaHistoria> p = new Pagination<RecuperoFacturaHistoria>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(find.where().eq("recupero_factura_id", recuperoFacturaId));
    	return p;
	}
}
