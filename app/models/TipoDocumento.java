package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "tipo_documentos")
public class TipoDocumento extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_documentos_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

	public static Model.Finder<Long,TipoDocumento> find = new Model.Finder<Long,TipoDocumento>(Long.class, TipoDocumento.class);
}
