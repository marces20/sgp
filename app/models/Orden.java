package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;

import models.auth.Permiso;
import models.informes.InformeDeudaPorActaMaterializada;
import models.informes.InformeDeudaProveedoresMaterializada;

@Entity 
@Table(name = "ordenes")
public class Orden extends Model {
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordenes_id_seq")
	public Long id;
	public String origen;
	
	@OneToMany
	@JoinColumn(name="orden_compra_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<OrdenProvision> ordenProvision;
	
	@OneToMany
	public List<OrdenLinea> lineas;
	
	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	@Required(message="Requiere una Institucion")
	public Long deposito_id;
	
	//@Required(message="Requiere fecha de orden")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_orden;
	public Date fecha_aprobada;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_precurso;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_curso;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_entrega;
	
	@Required(message="Requiere una referencia")
	public String nombre;
	
	public Boolean recibido = false;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Requiere un proveedor")
	public Long proveedor_id;
	
	@ManyToOne
	@JoinColumn(name="state_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;

	@Column(name="state_id")
	public Long estado_id;
	
	public BigDecimal monto_total;
	
	@DecimalComa(value="")
	public BigDecimal cot_dolar;
	
	public Integer tipo_moneda;
	
	public String numero_presupuesto;
	
	@Required(message="Debe seleccionar un tipo de orden.")
	public String tipo_orden;
	
	@ManyToOne
	@JoinColumn(name="solicitud_id", referencedColumnName="id", insertable=false, updatable=false)
	public Solicitud solicitud;
	public Long solicitud_id;
	
	@DecimalComa(value="")
	public BigDecimal monto_adelanto;
	
	public Boolean subparcial = false;
	public Boolean contra_periodica = false;
	public Boolean orden_provision = false;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_provision;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_inicio;
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_fin;
	@Required(message="Debe escribir un proveedor")
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Requiere un expediente")
	public Long expediente_id;
	
	public String tipo_contratacion;
	public Boolean contrato_personal = false;
	public Boolean profe;
	public Boolean certificacion_servicio = false;
	public Boolean acta_recepcion = false;
	public Boolean acta_comite = false;
	public Boolean tilde_orden = false;
	public Boolean creacion_automatica = false;
	public Boolean perimido = false;
	
	
	//@Required(message="Requiere Orden de provisión")
	public Integer numero_orden_provision;
	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	public Long periodo_id;
	
	@OneToOne
	@JoinColumn(name="orden_rubro_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenRubro ordenRubro;
	public Long orden_rubro_id;
	
	@OneToOne
	@JoinColumn(name="orden_subrubro_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenSubrubro ordenSubrubro;
	public Long orden_subrubro_id;
	
	public String detalle_rubro;
	
	public String plazo_entrega;
	
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
	
	@ManyToOne
	@JoinColumn(name="tipo_cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoCuenta tipoCuenta;
	@Required(message="Tipo Cuenta requerido")
	public Long tipo_cuenta_id;
	
	public String descripcion;
	
	@Formula(select = "_b${ta}.total", join = "left outer join (select orden_id, round(sum(CAST(precio * ol.cantidad as numeric)),2) as total from orden_lineas ol group by orden_id) as _b${ta} on _b${ta}.orden_id = ${ta}.id")
	public BigDecimal total;
	
	@Formula(select = "_b2${ta}.totalAjuste", join = "left outer join (select orden_id, round(sum(precio * cantidad),2) as totalAjuste from orden_lineas_ajustes group by orden_id) as _b2${ta} on _b2${ta}.orden_id = ${ta}.id")
	public BigDecimal totalAjuste;
	
	public BigDecimal getTotalAjuste(){
		if (totalAjuste == null)
			return new BigDecimal(0);
		return totalAjuste;
	}
	
	public BigDecimal getTotal(){
		if (total == null)
			return new BigDecimal(0);
		return total;
	}
	
	public BigDecimal getTotalTotal(){
		return getTotal().add(getTotalAjuste());
	}
	
	public BigDecimal getTotalDolar(){
		if (cot_dolar != null && cot_dolar.compareTo(BigDecimal.ZERO) > 0)
			return getTotal().divide(cot_dolar, 2, RoundingMode.HALF_UP);
		return new BigDecimal(0);
	}
	
	public BigDecimal getTotalDolarAjusteSinDiferenciaCotizacion(){
		if (cot_dolar != null && cot_dolar.compareTo(BigDecimal.ZERO) > 0)
			return getTotalAjusteSinDiferenciaCotizacion().divide(cot_dolar, 2, RoundingMode.HALF_UP);
		return new BigDecimal(0);
	}
	
	public BigDecimal getTotalDolarSinDiferenciaCotizacio(){
		if (cot_dolar != null && cot_dolar.compareTo(BigDecimal.ZERO) > 0)
			return getTotal().add(getTotalAjusteSinDiferenciaCotizacion()).divide(cot_dolar, 2, RoundingMode.HALF_UP);
		return new BigDecimal(0);
	}
	
	@Formula(select = "_b3${ta}.totalAjusteSinDiferenciaCotizacion", join = "left outer join (select orden_id, sum(precio * cantidad) as totalAjusteSinDiferenciaCotizacion from orden_lineas_ajustes ola where ola.producto_id not in(40277, 40276, 30653)  group by orden_id) as _b3${ta} on _b3${ta}.orden_id = ${ta}.id")
	public BigDecimal totalAjusteSinDiferenciaCotizacion;
	
	public BigDecimal getTotalAjusteSinDiferenciaCotizacion(){
		if (totalAjusteSinDiferenciaCotizacion == null)
			return new BigDecimal(0);
		return totalAjusteSinDiferenciaCotizacion;
	}
	
	@Formula(select = "_b4${ta}.totalAjusteConDiferenciaCotizacion", join = "left outer join (select orden_id, sum(precio * cantidad) as totalAjusteConDiferenciaCotizacion from orden_lineas_ajustes ola where ola.producto_id in(40277, 40276, 30653)  group by orden_id) as _b4${ta} on _b4${ta}.orden_id = ${ta}.id")
	public BigDecimal totalAjusteConDiferenciaCotizacion;
	
	public BigDecimal getTotalAjusteConDiferenciaCotizacion(){
		if (totalAjusteConDiferenciaCotizacion == null)
			return new BigDecimal(0);
		return totalAjusteConDiferenciaCotizacion;
	}
	
	public BigDecimal getTotalTotalSinDiferenciaCotizacion(){
		return getTotal().add(getTotalAjusteSinDiferenciaCotizacion());
	}
	
	@OneToMany
	public List<OrdenLinea> ordenLinea;
	
	public static Finder<Long,Orden> find = new Finder<Long,Orden>(Long.class, Orden.class);
	
	public List<Orden> getDataSuggest(String input,Integer limit){
		List<Orden> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		return l;
	}
  
	public static Pagination<Orden> page(String nombre,
										 String create_usuario,
										 String proveedor,
										 String cliente, 
										 String expediente,
										 String ejercicio,
										 String numero_orden_provision_desde,
										 String numero_orden_provision_hasta,
										 String fecha_fin_contrato_desde,
										 String fecha_fin_contrato_hasta,
										 String fecha_provision_desde,
										 String fecha_provision_hasta,
										 String btnFiltro0,//borrador
										 String btnFiltro1,//en curso
										 String btnFiltro2,//aprobado
										 String btnFiltro3,//Cancelado
										 String btnFiltro4, 
										 String producto,
										 String rubro,
										 String deposito,
										 String tipo_moneda,
										 String profe,
										 String tipo_cuenta_id,
										 String emergencia,
										 String perimido
										 ) {    	
		Pagination<Orden> p = new Pagination<Orden>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<Orden> e = find.select("id,fecha_orden,numero_orden_provision,fecha_inicio,fecha_fin,tipo_moneda,nombre,total,totalAjuste")
    			//.fetch("create_usuario")
    			.fetch("proveedor","nombre")
    			//.fetch("proveedor.agente")
    			.fetch("estado","nombre")
    			.fetch("expediente")
    			.fetch("expediente.ejercicio").where();
    	
    	if(!tipo_moneda.isEmpty()){
			e.isNotNull("tipo_moneda"); 
		}
    	
    	boolean peri = false;
    	
    	if(!perimido.isEmpty()){
    		if(perimido.compareToIgnoreCase("SI") ==0){
    			peri = true;
    		}
    	}
    	
    	e.eq("perimido", peri);
    	
    	if(!profe.isEmpty()){
    		if(profe.compareToIgnoreCase("SI") == 0){
    			e.eq("profe", true);
    		}else{
    			e.eq("profe", false);
    		}
    	} 
    	
    	if(!tipo_cuenta_id.isEmpty()){
    		e.eq("tipo_cuenta_id", Integer.parseInt(tipo_cuenta_id));
    	}
    	
    	if(!nombre.isEmpty()){
    		e.ilike("nombre", "%" + nombre + "%");
    	}	
    	if(!create_usuario.isEmpty()){
			e.eq("create_usuario.id", Integer.parseInt(create_usuario));
    	}	
    	if(!rubro.isEmpty()){
    		e.eq("orden_rubro_id", Integer.parseInt(rubro));
    	}	
    	if(!proveedor.isEmpty()){
    		e.eq("proveedor_id", Integer.parseInt(proveedor));
    	}	
    	if(!deposito.isEmpty()){
    		e.eq("deposito_id", Integer.parseInt(deposito));
    	}	
		if(!expediente.isEmpty()){
			e.eq("expediente_id", Integer.parseInt(expediente));
		}	
		if(!ejercicio.isEmpty()){
			e.eq("expediente.ejercicio_id", Integer.parseInt(ejercicio));
		}	
		
		if(!emergencia.isEmpty()){
    		if(emergencia.compareToIgnoreCase("SI") ==0){
    			e.eq("expediente.emergencia", true);
    		}else{
    			e.eq("expediente.emergencia", false);
    		}
    	}
		
		if(!numero_orden_provision_desde.isEmpty() && numero_orden_provision_desde.compareTo("0") == 0){
			e.isNull("fecha_provision");
		}else{	
			if(!numero_orden_provision_desde.isEmpty()){
	    		e.ge("numero_orden_provision",Integer.parseInt(numero_orden_provision_desde) );
	    	}
			if(!numero_orden_provision_hasta.isEmpty()){
	    		e.le("numero_orden_provision", Integer.parseInt(numero_orden_provision_hasta));
	    	}
		}
		if(!fecha_fin_contrato_desde.isEmpty()){
    		Date ffcd = DateUtils.formatDate(fecha_fin_contrato_desde, "dd/MM/yyyy");
    		e.ge("fecha_inicio", ffcd);
    	}
		if(!fecha_fin_contrato_hasta.isEmpty()){
    		Date ffch = DateUtils.formatDate(fecha_fin_contrato_hasta, "dd/MM/yyyy");
    		e.le("fecha_fin", ffch);
    	}
        if(!cliente.isEmpty())
        	e.eq("lineas.ordenLineaCliente.cliente_id", Integer.parseInt(cliente));
		
        if(!fecha_provision_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_provision_desde, "dd/MM/yyyy");
    		e.ge("fecha_provision", fpd);
    	}
		if(!fecha_provision_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_provision_hasta, "dd/MM/yyyy");
    		e.le("fecha_provision", fph);
    	}
		if(!producto.isEmpty()){
			if(producto.compareTo("42310") == 0) {
				e.ilike("lineas.producto.nombre", "%alquiler%");
			}else {
				e.eq("lineas.producto_id", Integer.parseInt(producto));
			}
			
		}	
		
		
		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty() || !btnFiltro4.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("state_id", Estado.ORDEN_ESTADO_BORRADOR);
			}	
			if(!btnFiltro1.isEmpty()){
				e = e.eq("state_id", Estado.ORDEN_ESTADO_ENCURSO);
			}	
			if(!btnFiltro2.isEmpty()){
				e = e.eq("state_id", Estado.ORDEN_ESTADO_APROBADO);
			}
			if(!btnFiltro3.isEmpty()){
				e = e.eq("state_id",Estado.ORDEN_ESTADO_CANCELADO);
			}
			if(!btnFiltro4.isEmpty()){
				e = e.eq("state_id",Estado.ORDEN_ESTADO_PRECURSO);
			}
			e = e.endJunction();
		}	
		
		 
		
		if(!Permiso.check("verTodoOrden")){
			
			if(Usuario.getUsurioSesion().plansumarmaterno) {
        		e = e.disjunction();
    			e = e.eq("tipo_cuenta_id",TipoCuenta.PLAN_SUMAR_MATERNO);
    			e = e.in("create_usuario_id", Usuario.getUsersPlanSumarMaterno());
    			e = e.endJunction();
        	}
			
			
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e = e.disjunction();
    			e = e.eq("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    			e = e.eq("create_usuario_id", Usuario.getUsurioSesion().id.intValue());
    			e = e.endJunction();
    		}else{
    			e.eq("create_usuario_id", Usuario.getUsurioSesion().id.intValue());
    		}
    	}
		 
    	p.setExpressionList(e);
    	
    	return p;
    }
	
	public static String getOrdenHija(Long idOrden) {
		String ret = null;
		String sql = "SELECT orden_hija FROM ordenes_ejercicio_concluido WHERE orden_id = :orden_id ";
		List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("orden_id",idOrden).findList();
		
		if(s.size() > 0){
			ret = "ORD"+s.get(0).getLong("orden_hija");
		}
		
		return ret;		
	}
	
	public static String getOrdenPadre(Long idOrden) {
		String ret = null;
		String sql = "SELECT orden_id FROM ordenes_ejercicio_concluido WHERE orden_hija = :orden_id ";
		List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("orden_id",idOrden).findList();
		
		if(s.size() > 0){
			ret = "ORD"+s.get(0).getLong("orden_id");
		}
		
		return ret;		
	}	
	
	public static Integer editarRubro(Long idOrden,Long idRubro,Long idSubRubro,String detalle){
		Integer ret;
		
		SqlUpdate update1 = Ebean.createSqlUpdate("alter table ordenes disable trigger all");
		update1.execute();
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE ordenes SET orden_rubro_id = :orden_rubro_id,orden_subrubro_id = :orden_subrubro_id,detalle_rubro = :detalle_rubro "+
												 "WHERE id IN (:id)");
		update.setParameter("orden_rubro_id", idRubro);
		update.setParameter("orden_subrubro_id",idSubRubro);
		update.setParameter("detalle_rubro",detalle);
		update.setParameter("id",idOrden);
		ret = update.execute();
		
		SqlUpdate update2 = Ebean.createSqlUpdate("alter table ordenes enable trigger all");
		update2.execute();
		
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		
		return ret;
	}
	
	public static Integer editarMontoAdelanto(Long idOrden,BigDecimal monto){
		Integer ret;
		
		SqlUpdate update1 = Ebean.createSqlUpdate("alter table ordenes disable trigger all");
		update1.execute();
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE ordenes SET monto_adelanto = :monto WHERE id IN (:id)");
		update.setParameter("monto", monto);
		update.setParameter("id",idOrden);
		ret = update.execute();
		
		SqlUpdate update2 = Ebean.createSqlUpdate("alter table ordenes enable trigger all");
		update2.execute();
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		return ret;
	}
	
	public static Integer editarCotDolar(Long idOrden,BigDecimal monto){
		Integer ret;
		
		SqlUpdate update1 = Ebean.createSqlUpdate("alter table ordenes disable trigger all");
		update1.execute();
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE ordenes SET cot_dolar = :monto WHERE id IN (:id)");
		update.setParameter("monto", monto);
		update.setParameter("id",idOrden);
		ret = update.execute();
		
		SqlUpdate update2 = Ebean.createSqlUpdate("alter table ordenes enable trigger all");
		update2.execute();
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		return ret;
	}
	
	public static Integer editarFechaProvision(Long idOrden,Date fecha){
		Integer ret;
		Integer ret2;
		
		SqlUpdate update1 = Ebean.createSqlUpdate("alter table ordenes disable trigger all");
		update1.execute();
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE ordenes SET fecha_provision = :fecha WHERE id IN (:id)");
		update.setParameter("fecha", fecha);
		update.setParameter("id",idOrden);
		ret = update.execute();
		
		SqlUpdate update0 = Ebean.createSqlUpdate("UPDATE ordenes_provision SET create_date = :fecha WHERE orden_compra_id IN (:id)");
		update0.setParameter("fecha", new Date());
		update0.setParameter("id",idOrden);
		ret2 = update0.execute();
		
		SqlUpdate update2 = Ebean.createSqlUpdate("alter table ordenes enable trigger all");
		update2.execute();
		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
		return ret;
	}
	
	
	public Long duplicar(Long id){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			stmt = conn.prepareStatement("SELECT duplicar_orden(?)");
			stmt.setInt(1, id.intValue());
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				ret = (long) rs.getInt(1);
			}
			
		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		 
		return ret;
	}
	
	public boolean controlPermisoDeposito() {
		boolean r = true; 
		if(!Permiso.check("verTodoOrden")){
			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
				if(Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(deposito_id) != 0) {
					r = false;
				}
			}else {
				r = false;
			}
		}
		
		return r;
	}
}
