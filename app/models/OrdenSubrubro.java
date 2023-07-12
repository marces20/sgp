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
@Table(name = "ordenes_subrubros")
public class OrdenSubrubro extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordenes_subrubros_id_seq")
    public Integer id;

	@Required(message="Debe escribir el nombre")
	public String nombre;

	@Required(message="Debe escribir el sigla")
	public String sigla;

	@ManyToOne
	public OrdenRubro ordenRubro = new OrdenRubro();

	public static Model.Finder<Long,OrdenSubrubro> find = new Model.Finder<Long,OrdenSubrubro>(Long.class, OrdenSubrubro.class);

	public static List<OrdenSubrubro> getOrdenSubrubro(int rubroId){
		return find.where().eq("orden_rubro_id", rubroId).orderBy("sigla").findList();
	}


}