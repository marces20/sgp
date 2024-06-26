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
@Table(name = "especialidades")
public class Especialidad extends Model{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="especialidades_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

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

	public static Finder<Long,Especialidad> find = new Finder<Long,Especialidad>(Long.class, Especialidad.class);

	public List<Especialidad> getDataSuggest(String input,Integer limit){
		List<Especialidad> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();
		return l;
	}

	public static Pagination<Especialidad> page(String nombre) {
    	Pagination<Especialidad> p = new Pagination<Especialidad>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("nombre");

    	p.setExpressionList(
    			 find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }

}
