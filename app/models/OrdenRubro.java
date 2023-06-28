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
@Table(name = "ordenes_rubros")
public class OrdenRubro extends Model {
	private static final long serialVersionUID = 1L;

	public static final Integer EQUIPAMIENTOS = 1;
	public static final Integer ESTUDIOS_MEDICOS = 2;
	public static final Integer INSUMOS_VARIOS = 3;
	public static final Integer MEDICAMENTOS = 4;
	public static final Integer OTROS_SERVICIOS = 5;
	public static final Integer PROTESIS = 6;
	public static final Integer SERVICIOS = 7;
	public static final Integer HONORARIOS = 8;
	public static final Integer REFACCIONES = 9;
	public static final Integer HABERES = 10;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordenes_rubros_id_seq")
    public Integer id;

	@Required(message="Debe escribir el nombre")
	public String nombre;

	@OneToMany
	List<OrdenSubrubro> ordenSubrubro;

	public static Model.Finder<Long,OrdenRubro> find = new Model.Finder<Long,OrdenRubro>(Long.class, OrdenRubro.class);

}



