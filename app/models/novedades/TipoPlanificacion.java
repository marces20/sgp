package models.novedades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "tipo_planificaciones")
public class TipoPlanificacion extends Model{

	public static final int GUARDIA = 1;
	public static final int PRODUCCION_STANDAR = 2;
	public static final int PRODUCCION_IMAGENES = 3;

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_planificaciones_id_seq")
	public Long id;

	@Required(message="Debe escribir un nombre")
	public String nombre;

	public static Model.Finder<Long,TipoPlanificacion> find = new Model.Finder<Long,TipoPlanificacion>(Long.class, TipoPlanificacion.class);
}
