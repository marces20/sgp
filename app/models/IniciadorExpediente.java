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
@Table(name = "inciador_expedientes")
public class IniciadorExpediente extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inciador_expedientes_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

	public Boolean activo = true;

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

	public static Finder<Long,IniciadorExpediente> find = new Finder<Long,IniciadorExpediente>(Long.class, IniciadorExpediente.class);

	public List<IniciadorExpediente> getDataSuggest(String input,Integer limit){
		List<IniciadorExpediente> l = find.where()
				.ilike("nombre", "%"+input+"%").eq("activo",true)
				.setMaxRows(limit).orderBy("nombre")
			    .findList();

		return l;
	}

	public static Pagination<IniciadorExpediente> page(String nombre) {
    	Pagination<IniciadorExpediente> p = new Pagination<IniciadorExpediente>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%").eq("activo",true)
	            );
    	return p;
    }
}
