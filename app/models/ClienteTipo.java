package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.mvc.Result;
import views.html.administracion.provincias.optionsListProvincia;

@Entity
@Table(name = "clientes_tipos")
public class ClienteTipo extends Model {
	private static final long serialVersionUID = 1L;

	public static Long OBRAS_SOCIALES = (long)1;
	public static Long EXTRANJEROS = (long)2;
	public static Long SEGUROS = (long)3;
	public static Long PREPAGAS = (long)4;
	public static Long EMPLEADORES = (long)5;
	public static Long EXTRANJEROS_SIN_RESIDENCIA = (long)6;
	public static Long PACIENTES = (long)7;
	public static Long PARTICULARES_ROBOTICA = (long)8;
	public static Long ART = (long)9;
	public static Long OTROS = (long)10;






	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clientes_tipos_id_seq")
	public Long id;

	@Required(message="Nombre requerido")
	public String nombre;

	public Integer orden;

	public static Finder<Long,ClienteTipo> find = new Finder<Long,ClienteTipo>(Long.class, ClienteTipo.class);

}





