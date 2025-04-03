package models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;


@Entity
@Table(name = "inventario")
public class Inventario extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inventario_id_seq")
	public Long id;

	@Required(message="Número de inventario requerido")
	public Integer numero;

	public BigDecimal division;

	public Integer remito_id;
	@OneToOne
	@JoinColumn(name="remito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Remito remito;

	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public  Producto producto;
	@Required(message="Requiere producto")
	public Long producto_id;

	@ManyToOne
	@JoinColumn(name="nomenclador_inventario_id", referencedColumnName="id", insertable=false, updatable=false)
	public InventarioPrefijo prefijo;
	@Required(message="Requiere un prefijo")
	public Long nomenclador_inventario_id;


	public static Model.Finder<Long,Inventario> find = new Finder<Long,Inventario>(Long.class, Inventario.class);

	public static Pagination<Inventario> page(String prefijo, String numero, String remito, String proveedor, String producto_id,String expediente_id) {
    	Pagination<Inventario> p = new Pagination<Inventario>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("numero");

    	ExpressionList<Inventario> e = find
    			 .fetch("remito.recepcion.ordenProvision.ordenCompra", "proveedor_id,expediente_id")
    			 .fetch("remito.recepcion.ordenProvision.ordenCompra.expediente")
    			 .where();


    	if(!prefijo.isEmpty()) {
    		e.eq("prefijo_inventario_id", Integer.parseInt(prefijo));
    	}

    	if(!numero.isEmpty()) {
    		e.eq("numero", Integer.parseInt(numero));
    	}

    	if(!remito.isEmpty()) {
    		e.eq("remito.numero", remito );
    	}

    	if(!proveedor.isEmpty()) {
    		e.eq("remito.recepcion.ordenProvision.ordenCompra.proveedor_id", Integer.parseInt(proveedor) );
    	}

    	if(!expediente_id.isEmpty()) {
    		e.eq("remito.recepcion.ordenProvision.ordenCompra.expediente_id", Integer.parseInt(expediente_id) );
    	}

    	if(!producto_id.isEmpty()) {
    		e.eq("producto_id", Integer.parseInt(producto_id) );
    	}

    	p.setExpressionList(e);
    	return p;
    }



	/*
select p.nombre, i.numero, pi.nombre from remitos r
inner join remitos_lineas rl on r.id = rl.remito_id
inner join inventario i on i.remito_linea_id = rl.id
inner join prefijos_inventario pi on pi.id = i.prefijo_inventario_id
inner join orden_lineas ol on ol.id = rl.linea_orden_id
inner join productos p on p.id = ol.producto_id
	 */

}
