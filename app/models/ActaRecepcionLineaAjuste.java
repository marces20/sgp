package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import models.auth.Permiso;
import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "actas_recepcion_lineas_ajustes")
public class ActaRecepcionLineaAjuste extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="actas_recepcion_lineas_ajustes_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="acta_id", referencedColumnName="id", insertable=false, updatable=false)
	public ActaRecepcion acta;
	@Required(message="Debe tener un acta asociada")
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
	
	@Required(message="Requiere precio")
	@DecimalComa(value="")
	public BigDecimal precio;
	
	@Required(message="Requiere cantidad")
	@DecimalComa(value="")
	public BigDecimal cantidad;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	public BigDecimal getTotal(){
		return cantidad.multiply(precio).setScale(2, RoundingMode.HALF_UP);
	}
	
	public static Model.Finder<Long,ActaRecepcionLineaAjuste> find = new Finder<Long,ActaRecepcionLineaAjuste>(Long.class, ActaRecepcionLineaAjuste.class);
	
	public static Pagination<ActaRecepcionLineaAjuste> page(Long actaId) {    	
    	Pagination<ActaRecepcionLineaAjuste> p = new Pagination<ActaRecepcionLineaAjuste>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.fetch("producto").where().eq("acta_id",actaId.intValue()));
    	return p;
    }
	
	public static boolean controlMontosAjustesDiferenciaCotizacion(ActaRecepcion ar) {
		
		boolean r = true;
		BigDecimal totalLineasActas = new BigDecimal(0);
		BigDecimal totalLineasOrden = new BigDecimal(0);
		
		//if(ar.ordenProvision.ordenCompra.expediente.ejercicio_id.compareTo(new Long(8)) >= 0) {
			List<OrdenLineaAjuste> ola = OrdenLineaAjuste.find.where()
										.in("producto_id", Producto.LISTA_PRODUCTOS_DIFERENCIA_CAMBIO)
										.eq("orden_id", ar.ordenProvision.ordenCompra.id)
										.findList();
			
			for(OrdenLineaAjuste olax :ola) {
				totalLineasOrden = totalLineasOrden.add(olax.getTotal());
			}
	
			List<ActaRecepcionLineaAjuste> arla = ActaRecepcionLineaAjuste.find.where()
												 .in("producto_id", Producto.LISTA_PRODUCTOS_DIFERENCIA_CAMBIO)
												 .eq("acta.ordenProvision.orden_compra_id",ar.ordenProvision.ordenCompra.id)
												 .findList();
			
			for(ActaRecepcionLineaAjuste arlax :arla) {
				totalLineasActas = totalLineasActas.add(arlax.getTotal());
			}
			String sql = " select la.orden_id, COALESCE(sum(la.precio * cantidad),0) ajustes " + 
						 " from actas_ajustes aj " + 
					     " inner join orden_lineas_ajustes la on la.id = aj.ajuste_id " + 
					     " where la.orden_id = :orden_id " + 
					     " group by la.orden_id";
		
			SqlRow l = Ebean.createSqlQuery(sql).setParameter("orden_id", ar.ordenProvision.ordenCompra.id).findUnique();
			
			if(l!= null) {
				totalLineasActas = totalLineasActas.add(l.getBigDecimal("ajustes"));
			}
			
			
		//}
		Logger.debug("totalLineasOrden:"+totalLineasOrden);
		Logger.debug("totalLineasActas:"+totalLineasActas);

		return (totalLineasActas.compareTo(totalLineasOrden) > 0);
	}
}
