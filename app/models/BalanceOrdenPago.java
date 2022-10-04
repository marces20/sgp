package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "balance_ordenespagos")
public class BalanceOrdenPago extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="balance_ordenespagos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="balance_id", referencedColumnName="id", insertable=false, updatable=false)
	public Balance balance;
	@Required(message="Debe tener un balance asociado")
	public Long balance_id;
	
	@ManyToOne
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;
	@Required(message="Debe tener un expediente asociado")
	public Long orden_pago_id;
	
	public static Model.Finder<Long,BalanceOrdenPago> find = new Finder<Long,BalanceOrdenPago>(Long.class, BalanceOrdenPago.class);
	
	public static int deleteDesdeBalance(Long balance_id) throws Exception{
		int r = 0;
		try {
			SqlUpdate down = Ebean.createSqlUpdate("DELETE FROM balance_ordenespagos WHERE balance_id =:balance_id ");
			down.setParameter("balance_id", balance_id);
			r = down.execute(); 
		} catch (Exception e) {
			throw e;
		}
		
		return  r; 
	}	
	
	public static BalanceOrdenPago insert(Long balance_id,Long orden_pago_id) throws Exception{
		BalanceOrdenPago bcp = new BalanceOrdenPago();
		try {
			bcp.balance_id = balance_id;
			bcp.orden_pago_id = orden_pago_id;
			bcp.save();
		} catch (Exception e) {
			throw e;
		}	

		return bcp;
	}
}
