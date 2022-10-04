package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Query;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.annotation.Sql;
import com.avaje.ebean.annotation.SqlSelect;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity
@Sql
public class ActaRecepcionLinea extends Model {


	private static final long serialVersionUID = 1L;

	public BigDecimal cantidad;
	
	public BigDecimal total;
	public BigDecimal unitario;
	
	public Long acta_id;
	
	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public  Producto producto;
	@Required(message="Requiere producto")
	public Long producto_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Requiere cuenta presupuestaria")
	public Long cuenta_analitica_id;
	
	@ManyToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm;
	@Required(message="Requiere UDM")
	public Long udm_id;
	
	public BigDecimal getTotal() {
		if(total == null)
			return new BigDecimal(0);
		return total.setScale(2, RoundingMode.HALF_UP);
	}
	
	public static Query<ActaRecepcionLinea> getQuery() {
    	RawSql rawSql;
    	
    	rawSql = RawSqlBuilder.parse("" +
    			" select p.id, p.nombre, u.id, u.nombre, cantidad, total, lineas.acta_id acta_id, lineas.precio_unitario unitario,ca.id,ca.nombre,ca.codigo "+
    			" from " +
    			" ( " +
    			" 	select rec.acta_id, ol.producto_id, ol.udm_id, SUM(rl.cantidad) cantidad, "+ 
    			"   round(SUM(rl.cantidad * ol.precio),2) as total, round(CAST (ol.precio AS numeric), 2) precio_unitario,ol.cuenta_analitica_id "+
    		    "	from remitos_lineas rl " + 
    			" 	inner join remitos as r on r.id = rl.remito_id " +
    			" 	inner join recepciones as rec on rec.id = r.recepcion_id " +
    			" 	inner join orden_lineas ol on ol.id = rl.linea_orden_id " +
    			" 	group by rec.acta_id, ol.producto_id, ol.precio, ol.udm_id,ol.cuenta_analitica_id " +
    			" 	union " +
    			" 	select  cs.acta_id, ol.producto_id, ol.udm_id, " +
    			"	SUM(csl.cantidad) cantidad, " +
    			//"	(csl.precio - (csl.precio * COALESCE(csl.descuento, 0) / 100)) * SUM(csl.cantidad) as total, " +
    			//" 	round((SUM(csl.precio * csl.cantidad) - SUM(csl.precio * COALESCE(csl.descuento, 0) / 100),2) as total,"+
    			" 	round(SUM(csl.precio * csl.cantidad),2) - round(SUM(CAST (csl.precio AS numeric) * COALESCE(csl.descuento, 0) / 100)) as total,"+
    			"	csl.precio precio_unitario,ol.cuenta_analitica_id "+
    			"	from certificaciones_servicios cs " +
    			" 	inner join certificaciones_servicios_lineas csl on cs.id = csl.certificaciones_servicio_id " +
    			" 	inner join orden_lineas ol on ol.id = csl.linea_orden_id " +
    			" 	group by cs.acta_id, ol.producto_id, csl.precio, ol.udm_id, csl.descuento,ol.cuenta_analitica_id " +

    			" ) lineas " +
    			" inner join cuentas_analiticas ca on ca.id = lineas.cuenta_analitica_id " +
    			" inner join productos p on p.id = lineas.producto_id " +
    			" inner join udms u on u.id = lineas.udm_id ")
				.columnMapping("p.id", "producto.id")
				.columnMapping("p.nombre", "producto.nombre")
				.columnMapping("u.id", "udm.id")
				.columnMapping("u.nombre", "udm.nombre")
				.columnMapping("ca.id", "cuentaAnalitica.id")
				.columnMapping("ca.nombre", "cuentaAnalitica.nombre")
				.columnMapping("ca.codigo", "cuentaAnalitica.codigo")
    			.create();
    	
    	return Ebean.find(ActaRecepcionLinea.class).setRawSql(rawSql);
	}
	
	
	public List<ActaRecepcionLinea> getLineas() {
		
		ExpressionList<ActaRecepcionLinea> e = getQuery().where();
		
		return e.findList();
		
	}
	
	public static Pagination<ActaRecepcionLinea> page(String acta_id, String producto_id) {
		Pagination<ActaRecepcionLinea> p = new Pagination<ActaRecepcionLinea>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("p.nombre");

    	ExpressionList<ActaRecepcionLinea> e = getQuery().where();
    	
    	
    	if(!acta_id.isEmpty()) {
    		e.eq("lineas.acta_id", Integer.parseInt(acta_id));
    	}
    	
    	if(!producto_id.isEmpty()) {
    		e.eq("p.id", Integer.parseInt(producto_id));
    	}
    	
    	p.setExpressionList(e);
    	
		p.parcheCountAllFormula = true;

    	p.setTotalRowCount(e.findList().size());
    	
    	return p;
    	
	}
	
}
