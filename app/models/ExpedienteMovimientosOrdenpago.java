package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "expedientes_movimientos_ordenpagos")
public class ExpedienteMovimientosOrdenpago extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="expediente_movimiento_op_id_seq")
	public Long id;
	
	@OneToOne
	@JoinColumn(name="expediente_movimiento_id", referencedColumnName="id", insertable=false, updatable=false)
	public ExpedienteMovimiento expedienteMovimiento;
	@Required(message="Debe tener un expedienteMovimiento asociado")
	public Long expediente_movimiento_id;
	
	@OneToOne
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;
	@Required(message="Debe tener un ordenPago asociado")
	public Long orden_pago_id;
	
	public static Model.Finder<Long,ExpedienteMovimientosOrdenpago> find = new Finder<Long,ExpedienteMovimientosOrdenpago>(Long.class, ExpedienteMovimientosOrdenpago.class);
}
