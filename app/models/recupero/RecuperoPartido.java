package models.recupero;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;

@Entity
@Table(name = "recupero_partido")
public class RecuperoPartido extends Model {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_partido_id_seq")
	public Long id;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_desde;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_hasta;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_vencimiento;

	public String cae;

	public String cuit;

	public String dni;

	public String nombre;

	public String numero;

	@DecimalComa(value="")
	@Required(message="Requiere precio")
	public BigDecimal monto;

	public BigDecimal getMonto(){
		return monto;
	}

	public String getNumeroFactura(){
		return "C0001-"+numero;
	}

	public static Model.Finder<Long,RecuperoPartido> find = new Finder<Long,RecuperoPartido>(Long.class, RecuperoPartido.class);

}
