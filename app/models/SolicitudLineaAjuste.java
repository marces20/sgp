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
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "solicitud_linea_ajustes")
public class SolicitudLineaAjuste extends Model{
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="solicitud_linea_ajustes_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="solicitud_id", referencedColumnName="id", insertable=false, updatable=false)
	public Solicitud solicitud;
	@Required(message="Debe tener una solicitud asociada")
	public Long solicitud_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Cuenta analítica requerida")
	public Integer cuenta_analitica_id;
	
	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Producto producto;
	public Integer producto_id;

	@DecimalComa(value="")
	public BigDecimal valor;
	
	@Required(message="Requiere cantidad")
	@DecimalComa(value="")
	public BigDecimal cantidad;

	@Required(message="Requiere un valor")
	@DecimalComa(value="")
	public BigDecimal precio;
	
	
	
	public String observacion;
	
	
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	 
	public static Model.Finder<Long,SolicitudLineaAjuste> find = new Finder<Long,SolicitudLineaAjuste>(Long.class, SolicitudLineaAjuste.class);

    public static Pagination<SolicitudLineaAjuste> page(Long solicitudId) {    	
    	Pagination<SolicitudLineaAjuste> p = new Pagination<SolicitudLineaAjuste>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(find.where().eq("solicitud_id", solicitudId));
    	
    	return p;
    }
    
}
