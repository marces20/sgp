package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity
@Table(name = "depositos")
public class Deposito extends Model{
	private static final long serialVersionUID = 1L;

	public static final int HEARM = 1;
	public static final int MATERNO = 2;
	public static final int LACMI = 3;
	public static final int PEDRIATRIA = 25;
	public static final int UNIDAD_TRASLADO = 27;
	public static final int CEMIS = 28;
	public static final int LEMIS = 29;
	public static final int BANCO_SANGRE = 30;
	public static final int MINISTERIO_SALUD = 31;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="depositos_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

	public String sigla;

	public String direccion;

	public String fantasia;

	public Boolean parque = false;

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

	public static Model.Finder<Long,Deposito> find = new Finder<Long,Deposito>(Long.class, Deposito.class);

	public List<Deposito> getDataSuggest(String input,Integer limit){
		List<Deposito> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();
		return l;
	}

	public static Pagination<Deposito> page(String nombre) {
    	Pagination<Deposito> p = new Pagination<Deposito>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(
	    			find.where()
	                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
}
