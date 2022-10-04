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
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "proveedor_datos_dgr")
public class ProveedorDatoDgr extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proveedor_datos_dgr_id_seq")
	public Long id;
	
	@Required(message="El cuit es requerido")
	public Long cuit;
	
	@Required(message="Requiere Periodo")
	public Integer periodo_fiscal;
	
	 
	@Required(message="Requiere Nombre")
	public String razon_social;
	
	@DecimalComa(value="")
	@Required(message="Requiere alicuota")
	public BigDecimal alicuota;
	
	 
	
	@Required(message="Requiere tipo Contribuyente")
	public String tipo_contribuyente;
	
	public String tipo_documento;
	
	public Integer numero_documento; 
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	
	@ManyToOne
	@JoinColumn(name="proveedor_dgr_dato_motivo_id", referencedColumnName="id", insertable=false, updatable=false)
	public ProveedorDatoDgrMotivo proveedor_dgr_dato_motivo; 
	@Column(name="proveedor_dgr_dato_motivo_id")
	@Required(message="Requiere motivo")
	public Long proveedor_dgr_dato_motivo_id;
	
	@ManyToOne
	@JoinColumn(name="proveedor_dgr_dato_regimen_id", referencedColumnName="id", insertable=false, updatable=false)
	public ProveedorDatoDgrRegimen proveedor_dgr_dato_regimen; 
	@Column(name="proveedor_dgr_dato_regimen_id")
	@Required(message="Requiere regimen")
	public Long proveedor_dgr_dato_regimen_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date create_date; 
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	public static Finder<Long,ProveedorDatoDgr> find = new Finder<Long,ProveedorDatoDgr>(Long.class, ProveedorDatoDgr.class);
	
	public static Pagination<ProveedorDatoDgr> page(Long cuit) {    	
    	Pagination<ProveedorDatoDgr> p = new Pagination<ProveedorDatoDgr>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("cuit", cuit));
    	return p;
	}
}
