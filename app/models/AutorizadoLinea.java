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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.annotation.Formula;

import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "autorizado_lineas")
public class AutorizadoLinea extends Model {
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="autorizado_lineas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="autorizado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Autorizado autorizado;
	@Required(message="Debe tener un autorizado asociado")
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
	
	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden orden;
	public Long orden_id;
	
	public Date create_date; 
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	
	/*@ManyToOne
	@JoinColumn(name="acta_recepcion_id", referencedColumnName="id", insertable=false, updatable=false)
	public ActaRecepcion actaRecepcion;
	public Long acta_recepcion_id;*/
	
	@DecimalComa(value="")
	@Required(message="Requiere monto")
	public BigDecimal monto;
	
	@DecimalComa(value="")
	public BigDecimal cot_dolar;
	
	//@Formula(select = "_c${ta}.base", join = "left outer join (select autorizado_linea_id, round(sum(monto)::numeric,2) as base from autorizado_linea_actas group by autorizado_linea_id) as _c${ta} on _c${ta}.autorizado_linea_id = ${ta}.id")
	//@Formula(select = "_c${ta}.base", join = "left outer join (select autorizado_id, round(sum(monto)::numeric,2) as base from autorizado_lineas group by autorizado_id) as _c${ta} on _c${ta}.autorizado_id = ${ta}.autorizado_id")
	//public BigDecimal total;
	
	public BigDecimal getTotal(){
		//if (total == null){
			if (monto == null){
				return new BigDecimal(0);
			}else{
				return monto;
			}	
		//}	
		//return total;
	}
	
	public String getActas() {
		String af = "";
		if(autorizadoLineaActa != null && autorizadoLineaActa.size() > 0){
			for(AutorizadoLineaActa ax : autorizadoLineaActa) {
				if(ax.actaRecepcion != null) {
					af += ax.actaRecepcion.getNombre()+" - ";
				}
			}
		}
		
		return af;
	}
	
	public String getOp() {
		String af = "";
		if(ordenProvision != null){
			af += "OP "+ordenProvision.numero+" - ";
		}
		
		return af;
	}
	
	@OneToMany
	public List<AutorizadoLineaActa> autorizadoLineaActa;
	
	public static Model.Finder<Long,AutorizadoLinea> find = new Finder<Long,AutorizadoLinea>(Long.class, AutorizadoLinea.class);
	
	public static Pagination<AutorizadoLinea> page(Long autorizadoId) {    	
    	Pagination<AutorizadoLinea> p = new Pagination<AutorizadoLinea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.fetch("orden")
    						.fetch("ordenProvision","numero")
    						.fetch("orden.expediente")
    						.fetch("orden.proveedor")
    						.where().eq("autorizado_id", autorizadoId));
    	return p;
	}
	
	public boolean cargarLineasSinActas(ActaRecepcion a) {
		
		boolean ret = false;
		
		try{
			String sql = "SELECT al.id as id,autorizado_linea_id,sum(COALESCE(ala.monto,0)) as monto_autorizado_acta,COALESCE(al.monto,0) as monto_autorizado "+
						"FROM autorizado_lineas al "+
						"LEFT JOIN autorizado_linea_actas ala ON ala.autorizado_linea_id = al.id "+
						"WHERE al.orden_provision_id = :orden_provision_id "+
						"GROUP BY al.id,autorizado_linea_id,al.monto "+
						"HAVING sum(ala.monto) is null OR sum(ala.monto) < al.monto ORDER BY al.id ";
			
			List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("orden_provision_id", a.orden_provision_id).findList();
			
			/*BigDecimal cot_dolar = (a.ordenProvision.ordenCompra.cot_dolar != null)?a.ordenProvision.ordenCompra.cot_dolar:BigDecimal.ONE;
			BigDecimal montoActaEnPesos = a.getTotal();
			BigDecimal montoActaEnDolar = a.getTotal().divide(a.ordenProvision.ordenCompra.cot_dolar);*/
			BigDecimal montoActaEnPesos = a.getTotal();
			for(SqlRow sx :s){
				
				Logger.debug("a "+montoActaEnPesos);
				Logger.debug("b "+sx.getBigDecimal("monto_autorizado"));
				Logger.debug("c "+sx.getBigDecimal("monto_autorizado_acta"));
				Logger.debug("d "+sx.getBigDecimal("monto_autorizado").subtract(sx.getBigDecimal("monto_autorizado_acta")));
				Logger.debug("e "+sx.getLong("id"));
				
				
				
				BigDecimal montoCargado = sx.getBigDecimal("monto_autorizado").subtract(sx.getBigDecimal("monto_autorizado_acta"));
				
				if(montoActaEnPesos.compareTo(BigDecimal.ZERO) > 0){
					
					if(montoCargado.compareTo(montoActaEnPesos) >= 0){
						AutorizadoLineaActa ala = new AutorizadoLineaActa();
						ala.autorizado_linea_id = sx.getLong("id");
						ala.acta_recepcion_id = a.id;
						ala.monto = montoActaEnPesos;
						ala.create_date = new Date();
						ala.create_usuario_id = (long)1;
						ala.tipo_creacion = "Automatico1";
						ala.save();
						montoActaEnPesos = montoActaEnPesos.subtract(montoActaEnPesos);
					}else if(montoCargado.compareTo(montoActaEnPesos) < 0){
						
						montoActaEnPesos = montoActaEnPesos.subtract(montoCargado);
						
						AutorizadoLineaActa ala = new AutorizadoLineaActa();
						ala.autorizado_linea_id = sx.getLong("id");
						ala.acta_recepcion_id = a.id;
						ala.monto = montoCargado;
						ala.create_date = new Date();
						ala.create_usuario_id = (long)1;
						ala.tipo_creacion = "Automatico2";
						ala.save();
					}
				} 
			}
			
		}catch(Exception e){
			Logger.debug("EEEEEEErrorr"+e);
		}
		
		return ret;
	}

}
