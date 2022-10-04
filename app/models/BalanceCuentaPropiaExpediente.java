package models;

import java.util.List;

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
@Table(name = "balance_cuentas_propia_expedientes")
public class BalanceCuentaPropiaExpediente extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="balance_cuentas_propia_expedientes_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="balance_cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public BalanceCuentaPropia balanceCuentaPropia;
	@Required(message="Debe tener un balanceCuentaPropia asociado")
	public Long balance_cuenta_propia_id;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Debe tener un expediente asociado")
	public Long expediente_id;
	
	public static Model.Finder<Long,BalanceCuentaPropiaExpediente> find = new Finder<Long,BalanceCuentaPropiaExpediente>(Long.class, BalanceCuentaPropiaExpediente.class);

	public static int deleteDesdeBalance(Long balance_cuenta_propia_id) throws Exception{
		int r = 0;
		try {
			SqlUpdate down = Ebean.createSqlUpdate("DELETE FROM balance_cuentas_propia_expedientes WHERE balance_cuenta_propia_id =:balance_cuenta_propia_id ");
			down.setParameter("balance_cuenta_propia_id", balance_cuenta_propia_id);
			r = down.execute(); 
		} catch (Exception e) {
			throw e;
		}
		
		return  r; 
	}	
	
	public static BalanceCuentaPropiaExpediente insert(Long balance_cuenta_propia_id,Long expediente_id) throws Exception{
		BalanceCuentaPropiaExpediente bcp = new BalanceCuentaPropiaExpediente();
		try {
			bcp.balance_cuenta_propia_id = balance_cuenta_propia_id;
			bcp.expediente_id = expediente_id;
			bcp.save();
		} catch (Exception e) {
			throw e;
		}	

		return bcp;
	}	
		
}
