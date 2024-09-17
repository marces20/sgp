package models.equipos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import models.TipoEmbargo;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "tipo_incidencias")
public class TipoIncidencia extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_incidencias_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

	public static Model.Finder<Long,TipoIncidencia> find = new Model.Finder<Long,TipoIncidencia>(Long.class, TipoIncidencia.class);

}
