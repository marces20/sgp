package models;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;
@Entity 
@Table(name = "remito_linea_baul")
public class RemitoLineaBaul extends Model{
	private static final long serialVersionUID = 1L;

	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="remito_linea_baul_id_seq")
	public Long id;

	@Required(message="Cantidad requerida")
	public BigDecimal cantidad;
	
	
	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public  Producto producto;
	@Required(message="Requiere producto")
	public Long producto_id;

	@ManyToOne
	@JoinColumn(name="remito_baul_id", referencedColumnName="id", insertable=false, updatable=false)
	public RemitoBaul baul;
	@Required(message="Debe pertenecer a un baúl.")
	public Long remito_baul_id;
	
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	public static Model.Finder<Long,RemitoLineaBaul> find = new Finder<Long,RemitoLineaBaul>(Long.class, RemitoLineaBaul.class);
	
	public static Pagination<RemitoLineaBaul> page(Long remito_baul_id) {    	
    	Pagination<RemitoLineaBaul> p = new Pagination<RemitoLineaBaul>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("remito_baul_id", remito_baul_id));
    	return p;
    }
}
