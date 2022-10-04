package models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "orden_linea_clientes")
public class OrdenLineaCliente extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orden_linea_clientes_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;
	@Required(message="Requiere un proveedor")
	public Long cliente_id;
	
	@ManyToOne
	@JoinColumn(name="orden_linea_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenLinea ordenLinea;
	@Required(message="Requiere un proveedor")
	public Long orden_linea_id;
	
	public BigDecimal cantidad;
	
	public String observacion;
	
	@Formula(select = "totalRecibido", join = "left join ( select SUM(rlc.cantidad) as totalRecibido,rlc.cliente_id as cliente_id,rl.linea_orden_id as linea_orden_id from remitos_lineas rl inner join remito_linea_clientes rlc on rl.id = rlc.remito_linea_id GROUP BY rlc.cliente_id,rl.linea_orden_id union select sum(rlc.cantidad) totalRecibido ,rlc.cliente_id as cliente_id, crl.linea_orden_id from certificaciones_servicios cs inner join certificaciones_servicios_lineas crl on cs.id = crl.certificaciones_servicio_id inner join certificaciones_servicios_linea_clientes rlc on crl.id = rlc.certificaciones_servicios_linea_id group by cliente_id, linea_orden_id  ) as re_li${ta} on re_li${ta}.cliente_id = ${ta}.cliente_id and re_li${ta}.linea_orden_id = ${ta}.orden_linea_id")
	public BigDecimal totalRecibido;
	
	public BigDecimal getTotalRecibido() {
		if(totalRecibido == null)
			return new BigDecimal(0);
		return totalRecibido;
	}
	
	@Formula(select = "totalAnulado", join = "left join ( select SUM(olac.cantidad) as totalAnulado, olac.cliente_id as cliente_id,ola.orden_linea_id as orden_linea_id from orden_lineas_anulaciones ola inner join orden_linea_anulacion_clientes olac on ola.id = olac.orden_linea_anulacion_id GROUP BY olac.cliente_id,ola.orden_linea_id union select sum(rlc.cantidad) totalAnulado ,rlc.cliente_id as cliente_id, crl.linea_orden_id from certificaciones_servicios cs inner join certificaciones_servicios_lineas crl on cs.id = crl.certificaciones_servicio_id inner join certificaciones_servicios_linea_clientes rlc on crl.id = rlc.certificaciones_servicios_linea_id where cs.state_id = 88 group by cliente_id, linea_orden_id ) as lia${ta} on lia${ta}.cliente_id = ${ta}.cliente_id and  lia${ta}.orden_linea_id = ${ta}.orden_linea_id ")
	public BigDecimal totalAnulado;
	
	public BigDecimal getTotalAnulado() {
		if(totalAnulado == null)
			return new BigDecimal(0);
		return totalAnulado;
	}
	
	//@OneToMany
	//public List<OrdenLineaAnulacion> ordenLineaAnulacion;
	
	public static Model.Finder<Long,OrdenLineaCliente> find = new Finder<Long,OrdenLineaCliente>(Long.class, OrdenLineaCliente.class);

	public static Pagination<OrdenLineaCliente> page(Long ordenId) {    	
    	Pagination<OrdenLineaCliente> p = new Pagination<OrdenLineaCliente>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	return p;
    }
	
	public static Pagination<OrdenLineaCliente> pageBuscador(String cliente,
															 String proveedor_id,
															 String expediente_id,String ejercicio) {  
		
    	Pagination<OrdenLineaCliente> p = new Pagination<OrdenLineaCliente>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<OrdenLineaCliente> e = find
    		 	                              .fetch("ordenLinea")	
    		 	                              .fetch("ordenLinea.producto","nombre")	
    										  .fetch("ordenLinea.orden.proveedor", "nombre")
    										  .fetch("ordenLinea.orden.expediente", "nombre")
    										  .fetch("ordenLinea.orden.expediente.ejercicio", "nombre")
    										  .fetch("ordenLinea.orden", "numero_orden_provision")
    										  .fetch("ordenLinea.orden.estado", "nombre")
    										  .where();
    	
    	if(!proveedor_id.isEmpty()){
    		e = e.eq("ordenLinea.orden.proveedor_id", Integer.parseInt(proveedor_id));
    	}
    	if(!expediente_id.isEmpty()){
    		e = e.eq("ordenLinea.orden.expediente_id", Integer.parseInt(expediente_id));
    	}
    	
    	if(!ejercicio.isEmpty()){
			e.eq("ordenLinea.orden.expediente.ejercicio_id", Integer.parseInt(ejercicio));
		}	
    	if(!cliente.isEmpty()){
        	e.eq("cliente_id", Integer.parseInt(cliente));
        }else{
    		//e.isNull("cliente_id");
    		e.isNotNull("cliente_id");
    	}
    	
    	e = e.disjunction();
    	//e = e.eq("ordenLinea.orden.estado_id", Estado.ORDEN_ESTADO_BORRADOR);
    	//e = e.eq("ordenLinea.orden.estado_id", Estado.ORDEN_ESTADO_ENCURSO);
    	//e = e.eq("ordenLinea.orden.estado_id", Estado.ORDEN_ESTADO_PRECURSO);
    	e = e.eq("ordenLinea.orden.estado_id", Estado.ORDEN_ESTADO_APROBADO);
    	e = e.endJunction();
    	
    	p.setExpressionList(e);
    	return p;
    }
}
