package models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.annotation.Sql;

@Entity
@Sql
public class AutorizadoLineaDetalle extends Model {
		
	/*@ManyToOne
	@JoinColumn(name="autorizado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Autorizado autorizado;
	public Long autorizado_id;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	public Long proveedor_id; 
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Long expediente_id;
	
	@ManyToOne
	@JoinColumn(name="orden_provision_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenProvision ordenProvision;
	public Long orden_provision_id;

	@DecimalComa(value="")
	@Required(message="Requiere monto")
	public BigDecimal monto;
	
	
		
	public static Pagination<AutorizadoLineaDetalle> getLineas(Long autorizadoId) {    	
		Pagination<AutorizadoLineaDetalle> p = new Pagination<AutorizadoLineaDetalle>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("orden_provision_id");
		
		RawSql rawSql = RawSqlBuilder.parse("SELECT autorizado_id as autorizado_id, op.id as orden_provision_id,o.proveedor_id as proveedor_id, o.expediente_id as expediente_id,sum(monto) as monto " +
				"FROM autorizado_lineas al " +
				"INNER JOIN  actas_recepcion ar on ar.id =  al.acta_recepcion_id  " +
				"INNER JOIN  ordenes_provision op on op.id =  ar.orden_provision_id  " +
				"INNER JOIN  ordenes o on o.id =  op.orden_compra_id " +
				"GROUP BY autorizado_id,op.id,o.proveedor_id,o.expediente_id")
				.columnMapping("autorizado_id", "autorizado.id")
				.columnMapping("op.id", "ordenProvision.id")
				.columnMapping("o.proveedor_id", "proveedor.id")
				.columnMapping("o.expediente_id", "expediente.id")
				.create();
		
    	ExpressionList<AutorizadoLineaDetalle> e = Ebean.find(AutorizadoLineaDetalle.class).setRawSql(rawSql).where();
    	e.eq("autorizado_id", autorizadoId);
    	
    	p.setExpressionList(e);
    	
		p.parcheCountAllFormula = true;

    	p.setTotalRowCount(e.findList().size());
    	
    	return p;
	}*/
	

}
