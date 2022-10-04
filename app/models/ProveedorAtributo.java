package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "proveedor_atributos")
public class ProveedorAtributo extends Model{

	private static final long serialVersionUID = 1L;
	
	public static final Integer AFIP_CONDICION_MONOTRIBUTO = 1;
	public static final Integer AFIP_CONDICION_RESPONSABLE = 2;
	public static final Integer SUSS_TIPO_COMUN = 1;
	public static final Integer SUSS_TIPO_LIMPIEZA = 2;
	public static final Integer SUSS_TIPO_SERVICIO = 3;
	public static final Integer SUSS_TIPO_CONSTRUCTORA = 4;
	public static final Integer DGR_CONDICION_CM = 1;
	public static final Integer DGR_CONDICION_DIRECTO = 2;
	public static final Integer DGR_CONDICION_NOCM = 3;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proveedor_atributos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Debe tener un proveedor asociada")
	public Long proveedor_id;
	
	@Required(message="Debe tener una condicion")
	public Integer afip_condicion;//monotributo - Responsable
	public boolean afip_ganancia = false;
	public boolean exento_iva = false;
	public boolean exento_sello = false;
	public Integer suss_tipo;//comun - limpieza - servicio
	public Integer dgr_condicion;//DGR CM - DGR DIRECTO - 	DGR NO CM
	
	
	public Integer exento_municipal;//agravado 0 - Exento 1
	
	//@Formats .DateTime(pattern="dd/MM/yyyy")
	//public Date fecha_extento_dgr; 
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_extento_afip_gcia;//
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_extento_afip_suss; //
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_extento_dgr_iibb; 
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_extento_dgr_sellos; //
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date create_date; 
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;

	public static Finder<Long,ProveedorAtributo> find = new Finder<Long,ProveedorAtributo>(Long.class, ProveedorAtributo.class);
	
	public static Pagination<ProveedorAtributo> page(Long proveedorId) {    	
    	Pagination<ProveedorAtributo> p = new Pagination<ProveedorAtributo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("proveedor_id", proveedorId));
    	return p;
	}
	
}
