package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "productos_depositos")
public class ProductoDeposito  extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productos_depositos_id_seq")
	public Long id;
	
	@OneToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Producto producto;
	@Required(message="Debe tener un producto asociado")
	public Long producto_id;
	
	@OneToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	@Required(message="Debe tener un deposito asociado")
	public Long deposito_id;
	
	public static Model.Finder<Long,ProductoDeposito> find = new Finder<Long,ProductoDeposito>(Long.class, ProductoDeposito.class);
	
	public static int deleteProducto(Long producto_id) throws Exception{
		int r = 0;
		try {
			SqlUpdate down = Ebean.createSqlUpdate("DELETE FROM productos_depositos " +
					"								WHERE producto_id =:producto_id ");
			down.setParameter("producto_id", producto_id);
			r = down.execute(); 
		} catch (Exception e) {
			throw e;
		}
		
		return  r; 
	}	
	
	public static List<Integer> getDepositoByProducto(Long producto_id) {
		List<Integer> ret = new ArrayList<Integer>();
		List<ProductoDeposito> pd = ProductoDeposito.find.where().eq("producto_id", producto_id).findList();
		for(ProductoDeposito pdx :pd){
			ret.add(pdx.deposito_id.intValue());
		}
		return  ret; 
	}	
	
	
}
