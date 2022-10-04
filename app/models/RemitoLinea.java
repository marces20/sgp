package models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;
import com.avaje.ebean.annotation.Sql;
import com.avaje.ebean.annotation.SqlSelect;

import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "remitos_lineas")
public class RemitoLinea extends Model {
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="remitos_lineas_id_seq")
	public Long id;
	
	@OneToOne
	@JoinColumn(name="remito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Remito remito;
	
	@Required(message="Remito requerido")
	public Long remito_id;

	@Required(message="Cantidad requerida")
	@DecimalComa(value="")
	public BigDecimal cantidad;

	
	@OneToOne
	@JoinColumn(name="linea_orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenLinea lineaOrden;
	
	@Required(message="Linea de orden requerido")
	public Long linea_orden_id;
	
	@Formula(select = "_b${ta}.cantidadMaxima", join = "left outer join (select ol.cantidad - SUM(rl.cantidad) as cantidadMaxima, ol.id from remitos_lineas rl inner join orden_lineas ol on ol.id = rl.linea_orden_id GROUP BY ol.id, ol.cantidad) as _b${ta} on _b${ta}.id = ${ta}.linea_orden_id")
	public BigDecimal cantidadMaxima;
	
	@OneToMany
	@JoinColumn(name="remito_linea_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<RemitoLineaCliente> remitoLineaCliente;
	
	public static Finder<Long,RemitoLinea> find = new Finder<Long,RemitoLinea>(Long.class, RemitoLinea.class);
	
	public BigDecimal getTotal(){
		return cantidad.multiply(lineaOrden.precio);
	}
	
	public List<Inventario> getInventario() {
		return Inventario.find.where().eq("remito_id", remito_id).eq("producto_id", lineaOrden.producto_id).order("numero").findList();
	}
	
	public static Pagination<RemitoLinea> page(String idRemito, String producto_id, String producto) {    	
    	Pagination<RemitoLinea> p = new Pagination<RemitoLinea>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("lineaOrden.producto.nombre");
    	
    	ExpressionList<RemitoLinea> e = find.where();

    	if(!idRemito.isEmpty()){
    		e.eq("remito_id", Integer.parseInt(idRemito));
    	}

    	if(!producto_id.isEmpty()){
    		e.eq("producto_id", Integer.parseInt(producto_id));
    	}
    	
    	if(!producto.isEmpty()){
    		e.ilike("lineaOrden.producto.nombre", "%"+producto+"%");
    	}
    	
    	p.setExpressionList( e );
    	return p;
    }
	
	
	
	
	

	
	
}
