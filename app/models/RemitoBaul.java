package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

import com.avaje.ebean.ExpressionList;


@Entity 
@Table(name = "remito_baul")
public class RemitoBaul extends Model {

	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="remito_baul_id_seq")
	public Long id;
	public String numero;	
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Requiere proveedor")
	public Integer proveedor_id;//Proveedor X
	
	@OneToMany
	@JoinColumn(name="remito_baul_id")
	public List<RemitoLineaBaul> lineas;

	public String observaciones;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	
	
	public static Finder<Long,RemitoBaul> find = new Finder<Long,RemitoBaul>(Long.class, RemitoBaul.class);
	
	
	public static Pagination<RemitoBaul> page(
										String numero,
										String proveedor_id,
										String producto_id,
										String respondable_id,
										String fecha_desde,
										String fecha_hasta
										){
		Pagination<RemitoBaul> p = new Pagination<RemitoBaul>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("fecha");
    	
    	ExpressionList<RemitoBaul> e = find.where();
    	
		if(!numero.isEmpty()){
    		e.eq("numero", numero);
    	}    	
    	
    	if(!fecha_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		e.ge("fecha", fpd);
    	}
		if(!fecha_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		e.le("fecha", fph);
    	}
    	
		if(!proveedor_id.isEmpty()){
    		e.eq("proveedor_id", Integer.parseInt(proveedor_id));
    	}	

		if(!respondable_id.isEmpty()){
    		e.eq("create_usuario_id", Integer.parseInt(respondable_id));
    	}
		
		if(!producto_id.isEmpty()){
    		e.eq("lineas.producto_id", Integer.parseInt(producto_id));
    	}

    	p.setExpressionList(e);
    	
    	return p;
	}

}
