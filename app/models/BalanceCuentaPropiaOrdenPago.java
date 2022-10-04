package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "balance_cuentas_propia_ordenespagos")
public class BalanceCuentaPropiaOrdenPago extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="balance_cuentas_propia_ordenespagos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="balance_cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public BalanceCuentaPropia balanceCuentaPropia;
	@Required(message="Debe tener un balanceCuentaPropia asociado")
	public Long balance_cuenta_propia_id;
	
	@ManyToOne
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;
	@Required(message="Debe tener un expediente asociado")
	public Long orden_pago_id;
	
	public static Model.Finder<Long,BalanceCuentaPropiaOrdenPago> find = new Finder<Long,BalanceCuentaPropiaOrdenPago>(Long.class, BalanceCuentaPropiaOrdenPago.class);
	
	public static int deleteDesdeBalance(Long balance_cuenta_propia_id) throws Exception{
		int r = 0;
		try {
			SqlUpdate down = Ebean.createSqlUpdate("DELETE FROM balance_cuentas_propia_ordenespagos WHERE balance_cuenta_propia_id =:balance_cuenta_propia_id ");
			down.setParameter("balance_cuenta_propia_id", balance_cuenta_propia_id);
			r = down.execute(); 
		} catch (Exception e) {
			throw e;
		}
		
		return  r; 
	}	
	
	public static BalanceCuentaPropiaOrdenPago insert(Long balance_cuenta_propia_id,Long orden_pago_id) throws Exception{
		BalanceCuentaPropiaOrdenPago bcp = new BalanceCuentaPropiaOrdenPago();
		try {
			bcp.balance_cuenta_propia_id = balance_cuenta_propia_id;
			bcp.orden_pago_id = orden_pago_id;
			bcp.save();
		} catch (Exception e) {
			throw e;
		}	

		return bcp;
	}	
}
