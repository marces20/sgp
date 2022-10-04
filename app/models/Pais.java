package models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "pais")
public class Pais extends Model {
	private static final long serialVersionUID = 1L;
	public static final Integer ARGENTINA = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pais_id_seq")
    public Integer id;
	
	@OneToMany
	List<Provincia> provincias;
	
	@Required(message="Debe escribir el nombre")
	public String nombre;
	
	public static Model.Finder<Long,Pais> find = new Model.Finder<Long,Pais>(Long.class, Pais.class);
	
}
