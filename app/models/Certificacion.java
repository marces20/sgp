package models;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

import models.auth.Permiso;
import models.haberes.PuestoLaboral;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;

@Entity 
@Table(name = "certificaciones")
public class Certificacion extends Model {
	
private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="certificaciones_id_seq")
	public Long id;
	
	@Required(message="Requiere un nombre")
	public String nombre;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Requiere un proveedor")
	public Long proveedor_id;
	
	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden orden;
	public Long orden_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")  
	public Date fecha_certificacion;
	
	public Boolean profe;
	
	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	@Required(message="Requiere un periodo")
	public Long periodo_id;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Requiere un expediente")
	public Long expediente_id;
	   
	@ManyToOne
	@JoinColumn(name="state_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="state_id")
	public Long estado_id;   
	
	public Boolean creacion_automatica = false;
	
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
	
	@Formula(select = "_b${ta}.descuento", join = "left outer join (select certificacion_id, sum(round((((precio*descuento)/100) * cantidad)::numeric)) as descuento from certificaciones_lineas group by certificacion_id) as _b${ta} on _b${ta}.certificacion_id = ${ta}.id")
	public BigDecimal descuento;
	public BigDecimal getDescuento(){
		if (descuento == null)
			return new BigDecimal(0);
		return descuento;
	}
	
	@Formula(select = "_c${ta}.base", join = "left outer join (select certificacion_id, round(sum(precio * cantidad)::numeric,2) as base from certificaciones_lineas group by certificacion_id) as _c${ta} on _c${ta}.certificacion_id = ${ta}.id")
	public BigDecimal base;//Base
	public BigDecimal getBase(){
		if (base == null)
			return new BigDecimal(0);
		return base;
	}

	@Formula(select = "_t${ta}.totalPagado", join = "left outer join (select  f.certificacion_id,round(sum(pl.monto),2) as totalPagado from facturas f inner join pagos p on p.factura_id = f.id inner join pagos_lineas pl on pl.pago_id = p.id group by f.certificacion_id) as _t${ta} on _t${ta}.certificacion_id = ${ta}.id")
	public BigDecimal totalPagado;//total pagado
	public BigDecimal getTotalPagado(){
		if (totalPagado == null)
			return new BigDecimal(0);
		return totalPagado;
	}
	
	
	public BigDecimal getTotal(){
		return getBase().subtract(getDescuento());
	}
	
	@OneToMany()
	public List<CertificacionLinea> certificacionLinea;
	
	public static Finder<Long,Certificacion> find = new Finder<Long,Certificacion>(Long.class, Certificacion.class);
	
	public List<Certificacion> getDataSuggest(String input,Integer limit){
		List<Certificacion> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		return l;
	}
	
	public static Pagination<Certificacion> page(String nombre,
												String proveedor,
												String expediente,
												String fecha_certificacion_desde,
												String fecha_certificacion_hasta,
												String periodo,
												String ejercicio,
												String btnFiltro0,//borrador
												String btnFiltro1,//en curso
												String btnFiltro2,//certificado
												String btnFiltro3,//aprobado
												String btnFiltro4, //cancelado
												String btnFiltro5, //con descuentos
												String cm,
												String tipo_cuenta_id
											    ) {
		Pagination<Certificacion> p = new Pagination<Certificacion>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("proveedor.nombre, periodo_id DESC, id");
    	
    	ExpressionList<Certificacion> e = find.select("id,nombre,fecha_certificacion,base,descuento,estado_id")
    			.fetch("create_usuario")
    			.fetch("proveedor","nombre")
    			.fetch("periodo","nombre")
    			.fetch("tipoCuenta","nombre")
    			.fetch("expediente", "nombre, id, emergencia")
    			.fetch("expediente.ejercicio", "nombre")
    			.fetch("expediente.parent.ejercicio", "nombre")
    			.fetch("estado")
    			.where();
    	
		if(!btnFiltro5.isEmpty()){
			e.gt("descuento", 0.0);
			p.parcheCountAllFormula = true;
		}
    	
		if(!tipo_cuenta_id.isEmpty()){
    		e.eq("tipo_cuenta_id", Integer.parseInt(tipo_cuenta_id));
    	}
    	
    	if(!nombre.isEmpty()){
    		e.ilike("nombre", "%" + nombre + "%");
    	}	
    	if(!proveedor.isEmpty()){
    		e.eq("proveedor_id", Integer.parseInt(proveedor));
    	}	
    	if(!expediente.isEmpty()){
			e.eq("expediente_id", Integer.parseInt(expediente));
		}	
    	if(!fecha_certificacion_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_certificacion_desde, "dd/MM/yyyy");
    		e.ge("fecha_certificacion", fpd);
    	}
		if(!fecha_certificacion_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_certificacion_hasta, "dd/MM/yyyy");
    		e.le("fecha_certificacion", fph);
    	}
		if(!periodo.isEmpty()){
    		e.eq("periodo_id", Integer.parseInt(periodo));
    	}	
		if(!ejercicio.isEmpty()){
			e.eq("expediente.ejercicio_id", Integer.parseInt(ejercicio));
		}	
		
		if(!cm.isEmpty()){
			boolean x = true;
			if(cm.compareToIgnoreCase("NO") == 0){
				x = false;
			} 
			
			List<PuestoLaboral> pl = PuestoLaboral.find.fetch("legajo").where().eq("activo",true).eq("convenio_ministerio", x).findList();
			List<Long> idsAgentes = new ArrayList<Long>();
			for(PuestoLaboral z :pl){
				idsAgentes.add(z.legajo.agente_id);
			}
			e.in("proveedor.agente_id", idsAgentes);
		}
		
		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty() || !btnFiltro4.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("state_id", Estado.CERTIFICACION_ESTADO_BORRADOR);
			}	
			if(!btnFiltro1.isEmpty()){
				e = e.eq("state_id", Estado.CERTIFICACION_ESTADO_ENCURSO);
			}	
			if(!btnFiltro2.isEmpty()){
				e = e.eq("state_id", Estado.CERTIFICACION_ESTADO_CERTIFICADO);
			}
			if(!btnFiltro3.isEmpty()){
				e = e.eq("state_id", Estado.CERTIFICACION_ESTADO_IMPUTADO);
			}
			if(!btnFiltro4.isEmpty()){
				e = e.eq("state_id", Estado.CERTIFICACION_ESTADO_CANCELADO);
			}
			/*
			if(!btnFiltro5.isEmpty()){
				e.gt("descuento", 0.0);
				p.parcheCountAllFormula = true;
			}
			*/
			e = e.endJunction();
		}	
		
		if(!Permiso.check("verExpedientesGuardiasMonotributo")){
			e.not(Expr.in("expediente_id", Expediente.EXP_GUARDIA_MONOTRIBUTOS));
		}
		
    	if(p.parcheCountAllFormula)
    		p.setTotalRowCount(e.findList().size());	
		
    	p.setExpressionList(e);
    	
    	return p;
    
	}
	
	public static Integer modificarFechaDeCertificacion(Date fecha, List<Integer> certificacionesSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE certificaciones " +
				"SET fecha_certificacion = :fecha,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("fecha", fecha);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", certificacionesSeleccionados);
		
		return update.execute();
	}
	
	public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> certificacionesSeleccionados){
														
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE certificaciones " +
				"SET state_id = :idEstado,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idEstado", idEstado);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", certificacionesSeleccionados);
		
		return update.execute();
	}
	
	public static Integer modificarEstadoMasivoConFechaDeCertificacion(Integer idEstado, List<Integer> certificacionesSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE certificaciones " +
				"SET state_id = :idEstado,fecha_certificacion = current_date,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idEstado", idEstado);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", certificacionesSeleccionados);
		
		return update.execute();
	}
	
	public Long duplicar(Long id){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
												 
			stmt = conn.prepareStatement("SELECT duplicar_certificado(?)");
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
	
	public static int duplicarMasivo(List<Integer> idList,Integer periodoIdInt,Double porcentajeDouble){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ret = 0;
		
		try {
			
			conn = play.db.DB.getConnection();
			
			for(Integer x : idList){
				stmt = conn.prepareStatement("SELECT duplicar_certificado(?,?,?)");
				stmt.setInt(1, x);
				stmt.setDouble(2,porcentajeDouble);
				stmt.setInt(3, periodoIdInt);
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					ret++;
				}
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
	
	public static int duplicarMasivoSinPreaumento(List<Integer> idList,Integer periodoIdInt,Double porcentajeDouble,Double porcentajeTotalDouble){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ret = 0;
		
		try {
			
			conn = play.db.DB.getConnection();
			
			for(Integer x : idList){
				stmt = conn.prepareStatement("SELECT duplicar_certificado_sin_preaumento(?,?,?,?)");
				stmt.setInt(1, x);
				stmt.setDouble(2,porcentajeDouble);
				stmt.setDouble(3,porcentajeTotalDouble);
				stmt.setInt(4, periodoIdInt);
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					ret++;
				}
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
	
	public static int duplicarMasivo(List<Integer> idList,Integer meses,Integer idExpediente,Integer idPeriodo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ret = 0;
		
		try {
			
			conn = play.db.DB.getConnection();
			
			for(Integer x : idList){
				stmt = conn.prepareStatement("SELECT duplicar_certificado(?,?,?,?)");
				stmt.setInt(1, x);
				stmt.setInt(2, meses);
				stmt.setInt(3, idExpediente);
				stmt.setInt(4, idPeriodo);
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					ret++;
				}
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
	
	public static Boolean soloCuentasAnliticasHijas(List<Integer> idsCertificaciones) {
		boolean r = true;
		
		String sql = "SELECT * " +
				"FROM certificaciones_lineas " +
				"WHERE certificacion_id in(:idsCertificaciones) " +
				"AND cuenta_analitica_id IN (SELECT parent_id FROM cuentas_analiticas WHERE parent_id is not null)  ";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("idsCertificaciones",idsCertificaciones)		
				.findList();
		
		if(s.size() > 0){
			r = false;
		}
		
		return r;
	}
	
	public static List<SqlRow> getTotalPorProveedorEstadoPeriodo(Long proveedorId) {
		String sql = "SELECT c.periodo_id,p.nombre periodoNombre,state_id estadoId,e.nombre estadoNombre," +
					 "SUM((cl.cantidad*cl.precio) - ROUND(((cl.cantidad*cl.precio)*cl.descuento)/100) ) total " +
					 "FROM certificaciones c " +
					 "INNER JOIN periodos p ON p.id = c.periodo_id " +
					 "INNER JOIN certificaciones_lineas cl ON c.id = cl.certificacion_id " +
					 "inner join estados e on e.id = c.state_id " +
					 "WHERE proveedor_id = :proveedorId " +
					 "GROUP BY c.periodo_id,p.nombre,state_id,e.nombre ";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("proveedorId",proveedorId)		
				.findList();
		
		return s;
	}
	
	public static Boolean soloCertificadoConFecha(List<Integer> certificacionesSeleccionados) {
		return CertificacionCompra.find.where().isNull("fecha_certificacion").in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloCertificado(List<Integer> certificacionesSeleccionados) {
		return CertificacionCompra.find.where().ne("estado_id", Estado.CERTIFICACION_COMPRA_ESTADO_CERTIFICADO).in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloEnCurso(List<Integer> certificacionesSeleccionados) {
		return CertificacionCompra.find.where().ne("estado_id", Estado.CERTIFICACION_COMPRA_ESTADO_ENCURSO).in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloBorrador(List<Integer> certificacionesSeleccionados) {
		return CertificacionCompra.find.where().ne("estado_id", Estado.CERTIFICACION_COMPRA_ESTADO_BORRADOR).in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloCancelado(List<Integer> certificacionesSeleccionados) {
		return CertificacionCompra.find.where().ne("estado_id", Estado.CERTIFICACION_COMPRA_ESTADO_CANCELADO).in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean conExpediente(List<Integer> certificacionesSeleccionados) {
		return CertificacionCompra.find.where().isNull("expediente_id").in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean conPeriodo(List<Integer> certificacionesSeleccionados) {
		return CertificacionCompra.find.where().isNull("periodo_id").in("id", certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean soloSinFactura(List<Integer> certificacionesSeleccionados) {
		return Factura.find.where().in("certificacion_compra_id",certificacionesSeleccionados).findRowCount() == 0;
	}
	
	public static Boolean conLineas(List<Integer> certificacionesSeleccionados) {
		String sql = " SELECT count(*) cantidad FROM certificaciones_compras c " +
					 " LEFT OUTER JOIN certificaciones_compras_lineas cl ON c.id = cl.certificacion_compra_id" +
					 " WHERE cl.id IS NULL AND c.id in (:listId)" +
					 " GROUP BY c.id";
		
		List<SqlRow> l = Ebean.createSqlQuery(sql).setParameter("listId", certificacionesSeleccionados).findList();
		 
		return  (l.size() == 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
