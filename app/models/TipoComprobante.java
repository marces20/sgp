package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "tipo_comprobantes")
public class TipoComprobante extends Model{

	public static final int FACTURA = 11;
	public static final int NOTA_DEBITO = 12;
	public static final int NOTA_CREDITO = 13;
	public static final int RECIBO_C = 15;


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_comprobantes_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

	public String numero_afip;

	public static Model.Finder<Long,TipoComprobante> find = new Model.Finder<Long,TipoComprobante>(Long.class, TipoComprobante.class);
}
