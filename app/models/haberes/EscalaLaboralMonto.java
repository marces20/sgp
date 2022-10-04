package models.haberes;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity 
@Table(name = "escalas_laborales_montos")
public class EscalaLaboralMonto extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="escalas_laborales_montos_id_seq")
	public Long id;	
	
	@ManyToOne
	@JoinColumn(name="liquidacion_concepto_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionConcepto liquidacionConcepto;
	@Required(message="Debe tener una Liquidacion asociada")
	public Long liquidacion_concepto_id;
	
	@ManyToOne
	@JoinColumn(name="escala_laboral_id", referencedColumnName="id", insertable=false, updatable=false)
	public EscalaLaboral escalaLaboral;
	public Long escala_laboral_id;
	
	@Required(message="Debe tener un importe")
	public BigDecimal importe_referencia;
	
	public BigDecimal importe_compensador;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_baja;
	
	/*@Required(message="Seleccion si es convencion ministerio")
	public Boolean convenio_ministerio;*/
	
	public Boolean activo;
	
	public static Model.Finder<Long,EscalaLaboralMonto> find = new Model.Finder<Long,EscalaLaboralMonto>(Long.class, EscalaLaboralMonto.class);
	
	public static Pagination<EscalaLaboralMonto> page(String liquidacion_concepto_id,String activo){

		Pagination<EscalaLaboralMonto> p = new Pagination<EscalaLaboralMonto>();
		p.setOrderDefault("DESC");
		p.setSortByDefault("id");
		
		ExpressionList<EscalaLaboralMonto> e = find.where();
		
		if(!liquidacion_concepto_id.isEmpty()) {
    		e.eq("liquidacion_concepto_id", Integer.parseInt(liquidacion_concepto_id));
    	}
		
		if(!activo.isEmpty()) {
			if(activo.compareToIgnoreCase("true") == 0) {
				e.eq("activo", true);
			}else if(activo.compareToIgnoreCase("false") == 0) {
				e.eq("activo", false);
			}
    	}
		
		p.setExpressionList(e);
		return p;
	}
	  
}
