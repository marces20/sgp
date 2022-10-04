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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.FetchConfig;
import com.avaje.ebean.annotation.Formula;

import models.auth.Permiso;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;
@Entity 
@Table(name = "certificaciones_servicios")
public class CertificacionServicio extends Model {

	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="certificaciones_servicios_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="orden_provision_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenProvision ordenProvision;
	
	@Required(message="Orden de provisión requerido")
	public Long orden_provision_id;
	
	@OneToOne
	@JoinColumn(name="acta_id", referencedColumnName="id", insertable=false, updatable=false)
	public ActaRecepcion acta;
	public Long acta_id;
	
	/*@OneToOne
	@JoinColumn(name="linea_orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenLinea lineaOrden;
	@Required(message="Linea de orden requerido")
	public Long linea_orden_id;*/
	
	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	@Required(message="Requiere un periodo")
	public Long periodo_id;
	
	/*@DecimalComa(value="")
	@Required(message="Requiere precio")
	public BigDecimal precio;
	
	@Required(message="Requiere cantidad")
	public BigDecimal cantidad;
	
	@Required(message="Requiere descuento")
	public BigDecimal descuento;*/
	
	@Formats .DateTime(pattern="dd/MM/yyyy")  
	public Date fecha_certificacion;
	
	public String numero_remito;
	
	@OneToMany
	@JoinColumn(name="certificaciones_servicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<CertificacionServicioLinea> certificacionesServicioLinea;
	
	@ManyToOne
	@JoinColumn(name="state_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="state_id")
	public Long estado_id;
	
	public Date create_date; 
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	
	@Formula(select = "_b${ta}.descuento", join = "left outer join (select certificaciones_servicio_id, sum(round((((precio*descuento)/100) * cantidad)::numeric)) as descuento from certificaciones_servicios_lineas group by certificaciones_servicio_id) as _b${ta} on _b${ta}.certificaciones_servicio_id = ${ta}.id")
	public BigDecimal descuento;
	public BigDecimal getDescuento(){
		if (descuento == null)
			return new BigDecimal(0);
		return descuento;
	}
	
	@Formula(select = "_c${ta}.base", join = "left outer join (select certificaciones_servicio_id, round(sum(precio * cantidad)::numeric,2) as base from certificaciones_servicios_lineas group by certificaciones_servicio_id) as _c${ta} on _c${ta}.certificaciones_servicio_id = ${ta}.id")
	public BigDecimal base;//Base
	public BigDecimal getBase(){
		if (base == null)
			return new BigDecimal(0);
		return base;
	}
	
	public BigDecimal getTotal(){
		return getBase().subtract(getDescuento());
	}
	
	public static Finder<Long,CertificacionServicio> find = new Finder<Long,CertificacionServicio>(Long.class, CertificacionServicio.class);

	
	public static Pagination<CertificacionServicio> page(String id, 
														 String expediente, 
														 String acta, 
														 String orden_provision_id, 
														 String orden_provision_numero, 
														 String producto_id, 
														 String proveedor_id, 
														 String periodo,
														 String rubro,
														 String deposito,
														 String conActa,
														 String filtroBorrador,
														 String filtroCertificada,
														 String filtroNocertificada,
														 String filtroCancelada,
														 String tipo_cuenta_id
														 ){
		
    	Pagination<CertificacionServicio> p = new Pagination<CertificacionServicio>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<CertificacionServicio> e = find.select("id, base, descuento, fecha_certificacion")
    			.fetch("periodo", "nombre")
    			.fetch("acta", "numero")
    			.fetch("ordenProvision", "numero")
    			.fetch("estado", "nombre")
    			.fetch("ordenProvision.ordenCompra", "fecha_provision")
    			.fetch("ordenProvision.ordenCompra.expediente", "nombre, id")
    			.fetch("ordenProvision.ordenCompra.expediente.ejercicio", "nombre")
    			.fetch("ordenProvision.ordenCompra.expediente.parent.ejercicio", "nombre")
    			.fetch("ordenProvision.ordenCompra.proveedor", "nombre")
    			.fetch("ordenProvision.ordenCompra.deposito", "nombre")
    			.fetch("ordenProvision.ordenCompra.ordenRubro", "nombre")
    			.where();
    	
    	if(!tipo_cuenta_id.isEmpty()){
			e.eq("ordenProvision.ordenCompra.tipo_cuenta_id",Integer.parseInt(tipo_cuenta_id)); 
		}
    	
    	if(!id.isEmpty()) {
    		e.eq("id", Integer.parseInt(id));
    	}
    	
    	if(!expediente.isEmpty()) {
    		e.eq("ordenProvision.ordenCompra.expediente_id", Integer.parseInt(expediente));
    	}
    	
    	if(!rubro.isEmpty()){
    		e.eq("ordenProvision.ordenCompra.orden_rubro_id", Integer.parseInt(rubro));
    	}
    	
    	if(!deposito.isEmpty()){
    		e.eq("ordenProvision.ordenCompra.deposito_id", Integer.parseInt(deposito));
    	}	
    	
    	if(!orden_provision_numero.isEmpty()) {
    		e.eq("ordenProvision.numero", Integer.parseInt(orden_provision_numero));
    	}
    	
    	if(!orden_provision_id.isEmpty()) {
    		e.eq("ordenProvision.id", Integer.parseInt(orden_provision_id));
    	}
    	
    	if(!producto_id.isEmpty()) {
    		e.eq("ordenProvision.ordenCompra.producto_id", Integer.parseInt(producto_id));
    	}
    	
    	if(!proveedor_id.isEmpty()) {
    		e.eq("ordenProvision.ordenCompra.proveedor_id", Integer.parseInt(proveedor_id));
    	}
    	
    	if(!periodo.isEmpty()) {
    		e.eq("periodo.id", Integer.parseInt(periodo));
    	}
    	
    	if(!acta.isEmpty()) {
    		e.eq("acta.numero", acta);
    	}
    	
    	if(!conActa.isEmpty()) {
    		if(conActa.compareTo("si") == 0){
    			e.isNotNull("acta_id");
    		}else{
    			e.isNull("acta_id");
    		}
    	} 
    	
    	if(!filtroBorrador.isEmpty() || !filtroCertificada.isEmpty() || !filtroCancelada.isEmpty() || !filtroNocertificada.isEmpty()) {
			e = e.disjunction();
			if(!filtroBorrador.isEmpty()){
	    		e = e.eq("estado_id", Estado.CERTIFICACION_SERVICIO_BORRADOR);
	    	}
			if(!filtroCertificada.isEmpty()){
	    		e = e.eq("estado_id", Estado.CERTIFICACION_SERVICIO_CERTIFICADA);
	    	}
			if(!filtroNocertificada.isEmpty()){
	    		e = e.eq("estado_id", Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA);
	    	}
			if(!filtroCancelada.isEmpty()){
	    		e = e.eq("estado_id", Estado.CERTIFICACION_SERVICIO_CANCELADA);
	    	}
			e = e.endJunction();
		}
    	
    	if(!Permiso.check("verTodoOrdenProvision")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("ordenProvision.ordenCompra.deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("ordenProvision.ordenCompra.deposito_id");
    		}
    	}

    	
    	p.setExpressionList( e );
    	return p;
    }
	
	public boolean controlPermisoDeposito() {
		boolean r = true;
		
		if(!Permiso.check("verTodoOrdenProvision")){
			
			if(ordenProvision == null) {
				OrdenProvision o = OrdenProvision.find.byId(orden_provision_id);
				ordenProvision = o;
			}
			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
				if(Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(ordenProvision.ordenCompra.deposito_id) != 0) {
					r = false;
				}
			}else {
				r = false;
			}
		}
		
		return r;
	}
	
}
