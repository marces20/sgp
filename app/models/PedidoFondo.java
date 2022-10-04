package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity 
@Table(name = "pedidos_fondos")
public class PedidoFondo extends Model {
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pedidos_fondos_id_seq")
	public Long id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy") 
	public Date fecha_pedido;
	
	public Boolean profe;
	
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
	
	@OneToMany()
	public List<PedidoFondoLinea> pedidoFondoLinea;
	
	public static Finder<Long,PedidoFondo> find = new Finder<Long,PedidoFondo>(Long.class, PedidoFondo.class);
	
	public static Pagination<PedidoFondo> page(String id,
											String fecha_pedido_desde,
											String fecha_pedido_hasta) 
	{
		Pagination<PedidoFondo> p = new Pagination<PedidoFondo>();
		p.setOrderDefault("DESC");
		p.setSortByDefault("id,fecha_pedido");
		
		ExpressionList<PedidoFondo> e = find
    			.fetch("create_usuario")
    			.where();
		
		if(!id.isEmpty()){
    		e.eq("id", Integer.parseInt(id));
    	}	
		
		if(!fecha_pedido_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_pedido_desde, "dd/MM/yyyy");
    		e.ge("fecha_pedido", fpd);
    	}
		if(!fecha_pedido_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_pedido_hasta, "dd/MM/yyyy");
    		e.le("fecha_pedido", fph);
    	}
		
		p.setExpressionList(e);
    	
    	return p;
	}					
}
