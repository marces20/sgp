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

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "autorizado_linea_actas")
public class AutorizadoLineaActa extends Model {
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="autorizado_linea_actas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="autorizado_linea_id", referencedColumnName="id", insertable=false, updatable=false)
	public AutorizadoLinea autorizadoLinea;
	@Required(message="Debe tener un autorizado linea asociado")
	public Long autorizado_linea_id;
	
	@ManyToOne
	@JoinColumn(name="acta_recepcion_id", referencedColumnName="id", insertable=false, updatable=false)
	public ActaRecepcion actaRecepcion;
	public Long acta_recepcion_id;
	
	@ManyToOne
	@JoinColumn(name="certificacion_compra_id", referencedColumnName="id", insertable=false, updatable=false)
	public CertificacionCompra certificacionCompra;
	public Long certificacion_compra_id;
	
	@DecimalComa(value="")
	@Required(message="Requiere monto")
	public BigDecimal monto;
	
	public Date create_date; 
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	
	public String tipo_creacion;
	
	public static Model.Finder<Long,AutorizadoLineaActa> find = new Finder<Long,AutorizadoLineaActa>(Long.class, AutorizadoLineaActa.class);
	
	public static Pagination<AutorizadoLineaActa> page(Long autorizadoLineaId) {    	
    	Pagination<AutorizadoLineaActa> p = new Pagination<AutorizadoLineaActa>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("autorizado_linea_id", autorizadoLineaId));
    	return p;
	}

}
