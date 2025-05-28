package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;


@Entity
@Table(name = "tipo_cuenta")
public class TipoCuenta extends Model{
	private static final long serialVersionUID = 1L;

	public static final Long OPERATIVA = new Long(1);
	public static final Long PROFE = new Long(2);
	public static final Long PLAN_SUMAR_HEARM = new Long(3);
	public static final Long PLAN_SUMAR_LACMI = new Long(4);
	public static final Long PLAN_SUMAR_FATIMA = new Long(5);
	public static final Long PLAN_SUMAR_MATERNO = new Long(6);
	public static final Long FONDO_PERMANENTE_MATERNO = new Long(7);
	public static final Long FONDO_PERMANENTE_OBERA = new Long(8);
	public static final Long PLAN_SUMAR_OBERA = new Long(9);
	public static final Long PLAN_SUMAR_FAVALORO = new Long(9);

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_cuenta_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

	public String numero;

	public String denominacion;

	public static Model.Finder<Long,TipoCuenta> find = new Model.Finder<Long,TipoCuenta>(Long.class, TipoCuenta.class);
}
