package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;

import models.auth.Permiso;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.RequestVar;
import utils.pagination.Pagination;
@Entity 
@Table(name = "remitos")
public class Remito extends Model {

	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="remitos_id_seq")
	public Long id;
	
	@Required(message="Número requerido")
	public String numero;
	
	@ManyToOne
	@JoinColumn(name="recepcion_id", referencedColumnName="id", insertable=false, updatable=false)
	public Recepcion recepcion;
	
	public Long recepcion_id;
	
	@OneToMany
	@JoinColumn(name = "remito_id")
	public Set<RemitoLinea>  lineas;
	
	@Formula(select = "_b${ta}.total", join = "left join (select round(SUM(rl.cantidad * ol.precio),2) as total, rl.remito_id from remitos_lineas rl inner join orden_lineas ol on ol.id = rl.linea_orden_id GROUP BY rl.remito_id) as _b${ta} on _b${ta}.remito_id = ${ta}.id")
	public BigDecimal total;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_remito;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date create_date;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	public BigDecimal getTotal(){
		if (total == null)
			return new BigDecimal(0);
		return total;
	}
	
	public static Finder<Long,Remito> find = new Finder<Long,Remito>(Long.class, Remito.class);
	
	public static Pagination<Remito> page(String recepcion_id, 
										String numero, 
										String acta, 
										String orden_provision, 
										String expediente_id, 
										String producto_id, 
										String responsable_id, 
										String proveedor_id,
										String tipo_moneda,
										String fecha_remito_desde,
										String fecha_remito_hasta,
										String create_date_desde,
										String create_date_hasta,
										String deposito_id,
										String numeroRecepcion
										) {    	
    	Pagination<Remito> p = new Pagination<Remito>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<Remito> e = find.select("numero, fecha_remito, total")
    								.fetch("recepcion", "numero, cantidadRemitos")
    								.fetch("recepcion.acta", "numero")
    								.fetch("recepcion.ordenProvision", "numero")
    								.fetch("recepcion.ordenProvision.ordenCompra.deposito", "nombre")
    								.fetch("recepcion.ordenProvision.ordenCompra.proveedor", "nombre")
    								.fetch("recepcion.ordenProvision.ordenCompra.expediente")
    								//.fetch("recepcion.ordenProvision.ordenCompra.expediente.ejercicio", "nombre")
    								.fetch("recepcion.ordenProvision.ordenCompra","tipo_moneda")
    								.where();
    	
    	if(!tipo_moneda.isEmpty()){
			e.isNotNull("recepcion.ordenProvision.ordenCompra.tipo_moneda"); 
		}
    	
    	if(!deposito_id.isEmpty()){
			e.eq("recepcion.ordenProvision.ordenCompra.deposito_id",Integer.parseInt(deposito_id)); 
		}
    	
    	if(!numeroRecepcion.isEmpty()) {
    		e.eq("recepcion.numero", numeroRecepcion);
    	}
    	
    	if(!recepcion_id.isEmpty()) {
    		e.eq("recepcion_id", Integer.parseInt(recepcion_id));
    	}
    	
    	if(!proveedor_id.isEmpty()) {
    		if(!proveedor_id.isEmpty()) {
        		if(proveedor_id.compareTo("14947") == 0) {
        			e.in("recepcion.ordenProvision.ordenCompra.proveedor_id", Proveedor.getProveedoresDestacadosRA());
        		}else {
        			e.eq("recepcion.ordenProvision.ordenCompra.proveedor_id", Integer.valueOf(proveedor_id));
        		}
            }
        	
    		//e.eq("recepcion.ordenProvision.ordenCompra.proveedor_id", Integer.parseInt(proveedor_id));
    	}
    	
    	if(!acta.isEmpty()) {
    		e.eq("recepcion.acta.numero", acta);
    	}
    	
    	System.out.println("------- " + expediente_id);
    	
    	if(!expediente_id.isEmpty()) {
    		e.eq("recepcion.ordenProvision.ordenCompra.expediente.id", Integer.parseInt(expediente_id));
    	}
    	
    	if(!orden_provision.isEmpty()) {
    		e.eq("recepcion.ordenProvision.numero", Integer.parseInt(orden_provision));
    	}
    	
    	
    	
    	if(!numero.isEmpty()) {
    		e.ilike("numero", "%"+numero+"%");
    	}
    	
    	if(!producto_id.isEmpty()) {
    		e.eq("lineas.lineaOrden.producto_id", Integer.parseInt(producto_id));
    	}    
    	
    	if(!responsable_id.isEmpty()) {
    		e.eq("create_usuario_id", Integer.parseInt(responsable_id));
    	} 
    	
    	if(!create_date_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(create_date_desde, "dd/MM/yyyy");
    		e.ge("date_trunc('day',create_date)", fpd);
    	}
		if(!create_date_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(create_date_hasta, "dd/MM/yyyy");
    		e.le("date_trunc('day',create_date)", fph);
    	}
		
		if(!fecha_remito_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_remito_desde, "dd/MM/yyyy");
    		e.ge("fecha_remito", fpd);
    	}
		if(!fecha_remito_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_remito_hasta, "dd/MM/yyyy");
    		e.le("fecha_remito", fph);
    	}
		
		if(!Permiso.check("verTodoOrdenProvision")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("recepcion.ordenProvision.ordenCompra.deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("recepcion.ordenProvision.ordenCompra.deposito_id");
    		}
    	}

    	p.setExpressionList( e );
    	return p;
    }
	
	public List<Producto> comprobarInventario() {
		String sqlOrdenDistinta = "" +
				" select ol.producto_id, SUM(rl.cantidad) enRemito, COALESCE((select COUNT(id) from inventario i where remito_id = rl.remito_id AND i.producto_id = ol.producto_id group by remito_id, producto_id), 0) enInventrio from remitos_lineas rl "+  
				" inner join orden_lineas ol on ol.id = rl.linea_orden_id "+
				" where rl.remito_id = "+ id +" AND ol.cuenta_analitica_id in(:cuentas)  "+
				" group by ol.producto_id, rl.remito_id ";
		
		List<SqlRow> recepcionesOrdenDistinta = Ebean.createSqlQuery(sqlOrdenDistinta).setParameter("cuentas", CuentaAnalitica.getCuentasParaInventario()).findList();
		
		List<Producto> p = new ArrayList<>();
		
		for (SqlRow sr : recepcionesOrdenDistinta) {
			if(sr.getInteger("enRemito") != sr.getInteger("enInventario")) {
				p.add( Producto.find.byId( sr.getLong("producto_id")) );
			}
		}
		return p;
	}
	
	public static Integer cambiarRecepcion(Integer id, List<Integer> remitorSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE remitos " +
				"SET recepcion_id = :id,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("id",id);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", remitorSeleccionados);
		
		return update.execute();
	}
	
	public boolean controlPermisoDeposito() {
		boolean r = true;
		
		if(!Permiso.check("verTodoOrdenProvision")){
			
			if(recepcion == null) {
				Recepcion o = Recepcion.find.byId(recepcion_id);
				recepcion = o;
			}
			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
				if(Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(recepcion.ordenProvision.ordenCompra.deposito_id) != 0) {
					r = false;
				}
			}else {
				r = false;
			}
		}
		
		return r;
	}
	
}
