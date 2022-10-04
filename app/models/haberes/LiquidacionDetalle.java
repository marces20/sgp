package models.haberes;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.Factura;
import models.FacturaLinea;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.NumberUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "liquidacion_detalles")
public class LiquidacionDetalle  extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_detalles_id_seq")
	public Long id;	
	
	@ManyToOne
	@JoinColumn(name="liquidacion_puesto_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionPuesto liquidacionPuesto;
	@Required(message="Debe tener una Liquidacion asociada")
	public Long liquidacion_puesto_id;
	
	@ManyToOne
	@JoinColumn(name="liquidacion_concepto_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionConcepto liquidacionConcepto;
	@Required(message="Debe tener una Liquidacion asociada")
	public Long liquidacion_concepto_id;
	
	@DecimalComa(value="")
	@Required(message="Debe tener una cantidad")
	public BigDecimal cantidad;
	@DecimalComa(value="")
	@Required(message="Debe tener un importe")
	public BigDecimal importe;
	
	public BigDecimal getTotal(){
		return cantidad.multiply(importe).setScale(2, BigDecimal.ROUND_HALF_UP);
	}   
	
	public String getTotalMoneda(){
		return NumberUtils.moneda(getTotal());
	}  
	
	public BigDecimal getTotal2(){
		return cantidad.multiply(importe);
	}  
	
	public static Model.Finder<Long,LiquidacionDetalle> find = new Finder<Long,LiquidacionDetalle>(Long.class, LiquidacionDetalle.class);
	
	public static Pagination<LiquidacionDetalle> page(Long liquidacionPuestoId) {    	
    	Pagination<LiquidacionDetalle> p = new Pagination<LiquidacionDetalle>();
    	p.setPageSize(5000000);
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("liquidacionConcepto.codigo");
    	
    	p.setExpressionList(find
    						.fetch("liquidacionConcepto","codigo,denominacion")
    						.fetch("liquidacionConcepto.liquidacionConceptoTipo","id")
    						.where().eq("liquidacion_puesto_id", liquidacionPuestoId));
    	return p;
	}
}

