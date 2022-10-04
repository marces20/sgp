package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "factura_datos")
public class FacturaDato extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="factura_datos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public Factura factura;
	@Required(message="Debe tener una factura asociada")
	public Long factura_id;
	
	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden orden;
	@Required(message="Debe tener una orden asociada")
	public Long orden_id;
	
	@DecimalComa(value="")
	@Required(message="Requiere precio")
	public BigDecimal monto;
	
	@Required(message="Requiere numero")
	public String numero_factura;
	
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
	
	public BigDecimal getMonto(){
		if (monto == null)
			return new BigDecimal(0);
		return monto;
	}
	
	public static Model.Finder<Long,FacturaDato> find = new Finder<Long,FacturaDato>(Long.class, FacturaDato.class);
	
	public static Pagination<FacturaDato> pageListado(String expediente,
													  String proveedor,
													  String orden_pago){
		Pagination<FacturaDato> p = new Pagination<FacturaDato>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");
    	
    	
    	ExpressionList<FacturaDato> e = find.fetch("factura.proveedor", "nombre")
    			.fetch("factura.expediente", "nombre, id")
    			.fetch("factura.expediente.ejercicio", "nombre")
    			.fetch("factura.expediente.parent.ejercicio", "nombre")
    			.fetch("factura.ordenPago", "numero")
    			.fetch("factura.ordenPago.ejercicio", "nombre")
    			.where();
    	
    	if(!proveedor.isEmpty()){
    		e.eq("factura.proveedor_id", Integer.parseInt(proveedor));
    	}
    	
    	if(!expediente.isEmpty()){
    		
    		Expediente ePadre = Expediente.find.byId(new Long(expediente));
    		List<Object> ePadre2 = Expediente.find.where().eq("parent_id", new Long(expediente)).findIds();
    		if(ePadre2.isEmpty() && ePadre.parent == null){
    			e = e.eq("factura.expediente_id", Integer.parseInt(expediente));
    		}else{
	    		e = e.disjunction();
	    			e = e.eq("factura.expediente_id", Integer.parseInt(expediente));
		    		if(ePadre.parent != null){
		    			e = e.eq("factura.expediente_id", ePadre.parent_id);
		    		}else{
		    			//ePadre = Expediente.find.where().eq("parent_id", new Long(expediente)).findUnique();
		    		 	e = e.in("factura.expediente_id", ePadre2);
		    		}
				e = e.endJunction();
    		}	
    	}	
    	
    	if(!orden_pago.isEmpty()){
    		e.eq("factura.ordenPago.id", Integer.parseInt(orden_pago));
    	}
    	
    	p.setExpressionList(e);
    	return p;
    			
	}
	public static Pagination<FacturaDato> page(Long facturaId) {    	
	    	Pagination<FacturaDato> p = new Pagination<FacturaDato>();
	    	p.setOrderDefault("ASC");
	    	p.setSortByDefault("id");
	    	
	    	p.setExpressionList(find.where().eq("factura_id", facturaId));
	    	return p;
	 }
	
}
