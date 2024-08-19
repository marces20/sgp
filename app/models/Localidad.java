package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "localidades")
public class Localidad extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="localidades_id_seq")
    public Integer id;

	@Required(message="Debe escribir el nombre", groups=Localidad.class)
	public String nombre;

	public Integer sucursal_macro_id;

	@ManyToOne
	public Provincia provincia;

	public static Model.Finder<Long,Localidad> find = new Model.Finder<Long,Localidad>(Long.class, Localidad.class);

	public static List<Localidad> getLocalidades(int provinciaId){
		return find.where().eq("provincia_id", provinciaId).orderBy("nombre").findList();
	}

	public List<Localidad> getDataSuggest(String input,Integer limit){
		List<Localidad> l = find.fetch("provincia").fetch("provincia.pais").where()
				.ilike("nombre", "%"+input+"%").eq("provincia.pais.id", Pais.ARGENTINA)
				.setMaxRows(limit).orderBy("nombre")
			    .findList();
		return l;
	}

}
