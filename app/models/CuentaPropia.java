package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "cuentas_propias")
public class CuentaPropia extends Model {

	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cuentas_propias_id_seq")
	public Long id;
	
	@Required(message="Requiere nombre")
	public String nombre;
	
	@Required(message="Requiere numero")
	public String numero;
	
	@Required(message="Requiere tipo")
	public String tipo;
	
	public static Finder<Long,CuentaPropia> find = new Finder<Long,CuentaPropia>(Long.class, CuentaPropia.class);
	
	public static Pagination<CuentaPropia> page(String nombre, String numero) {    	
    	Pagination<CuentaPropia> p = new Pagination<CuentaPropia>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<CuentaPropia> f = find.where();
				   

			if(!nombre.equals("")){
				f.ilike("nombre", "%" + nombre + "%");
			}
			if(!numero.equals("")){
				f.ilike("numero", "%" + numero + "%");
			}
    	
    	p.setExpressionList(f);
    	return p;
    }
	
}
