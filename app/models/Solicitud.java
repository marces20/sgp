package models;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import models.auth.Permiso;
import models.haberes.LiquidacionMes;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;

@Entity 
@Table(name = "solicitudes")
public class Solicitud extends Model {
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="solicitud_id_seq")
	public Long id;
	
	public String origen;
	public String descripcion;
	
	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	@Required(message="Institucion requerida")
	public Integer deposito_id;
	
	@Required(message="Debe escribir una referencia")
	public String referencia;
	public String dirigida;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Integer expediente_id;
	
	@OneToMany
	public List<SolicitudLinea> lineas;
	
	@OneToMany
	public List<SolicitudLineaAjuste> lineasAjustes;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_imputacion;
	public Boolean contrato_personal = false;
	public String prioridad;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;
	public Integer cliente_id;
	
	public Boolean profe;
	
	@ManyToOne
	@JoinColumn(name="tipo_cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoCuenta tipoCuenta;
	@Required(message="Tipo Cuenta requerido")
	public Long tipo_cuenta_id;
	
	public Boolean recuperable = false;
	
	public Boolean repo_stock = false;
	
	public Boolean entregado = false;
	
	@ManyToOne
	@JoinColumn(name="departamento_id", referencedColumnName="id", insertable=false, updatable=false)
	public Departamento departamento;
	@Required(message="Departamento requerido")
	public Integer departamento_id;
	
	@ManyToOne
	@JoinColumn(name="state_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;

	@Column(name="state_id")
	public Long estado_id;
	
	@ManyToOne
	public Agente solicitante;
	
	@ManyToOne
	@JoinColumn(name="medico_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente medico;
	public Integer medico_id;
	
	public String creacion_orden_compra;
	
	public String referencia_sigpar;
	
	public String pedido_rismi_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date date_end;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date date_start;
	
	@Formula(select = "_b${ta}.total", join = "left outer join (select solicitud_id, sum(precio_estimado * cantidad) as total from solicitud_lineas group by solicitud_id) as _b${ta} on _b${ta}.solicitud_id = ${ta}.id")
	public BigDecimal total;
	
	@Formula(select = "_b2${ta}.totalAjuste", join = "left outer join (select solicitud_id, sum(precio*cantidad) as totalAjuste from solicitud_linea_ajustes group by solicitud_id) as _b2${ta} on _b2${ta}.solicitud_id = ${ta}.id")
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", updatable = false, insertable = false)
	public Usuario usuario; 

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
	@JoinColumn(name="liquidacion_mes_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionMes liquidacionMes;
	public Long liquidacion_mes_id;
	
	@ManyToOne
	@JoinColumn(name="asignacion_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario asignacion_usuario; 
	@Column(name="asignacion_usuario_id")
	public Long asignacion_usuario_id;
	 
	public Date asignacion_date; 
	
	
	
	public static Model.Finder<Long,Solicitud> find = new Finder<Long,Solicitud>(Long.class, Solicitud.class);
	
	public Long duplicar(Long id,Long userLogin){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			stmt = conn.prepareStatement("SELECT duplicar_solicitud(?,?)");
			stmt.setInt(1, id.intValue());
			stmt.setInt(2,userLogin.intValue());
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
	
	public List<Solicitud> getDataSuggest(String input,Integer limit){
		List<Solicitud> l = find.where()
				.ilike("referencia", "%"+input+"%")
				.setMaxRows(limit).orderBy("referencia")
			    .findList();  
		return l;
	}

	public static boolean controlTildeProfe(Solicitud s){
		
		boolean ret = true;
		
		Integer sl = SolicitudLinea.find.where().in("cuenta_analitica_id", CuentaAnalitica.getCuentasAnaliticasHijas(142)).findRowCount();
		
		if(sl > 0 && (!s.tipo_cuenta_id.equals(TipoCuenta.PROFE))){
			ret = false;
		}
		
		return ret;
	}
	
	
	public static Pagination<Solicitud> page(String referencia, 
											String responsable, 
											String cliente, 
											String expediente, 
											String servicio, 
											String estado, 
											String ejercicio, 
											String desde,
											String hasta,
											String producto,
											String pedido_rismi,
											String profe,
											String recuperable,
											String solicitante,
											String nro_liquidacion_parque,
											String fdesdepreventiva,
											String fhastapreventiva,
											String cuenta_analitica_padre_id,
											String obra_social_id,
											String tipo_cuenta_id,
											String repo_stock,
											String emergencia,
											String entregado,
											String asignacion_usuario_id
											) {
    	Pagination<Solicitud> p = new Pagination<Solicitud>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<Solicitud> e = find.query().select("*, sum(id)")
			.fetch("departamento")
			.fetch("expediente")
			.fetch("usuario")
			.fetch("cliente")
			.fetch("cliente.obrasocial")
			.where();
    	
    	if(Usuario.getUsurioSesion().plansumarmaterno) {
			e = e.eq("tipo_cuenta_id",TipoCuenta.PLAN_SUMAR_MATERNO);
    	}	
    	
    	if(!Permiso.check("verTodasLasSolicitudes")){
    		
    		 
    		
    		Integer deptoId = 0;
    		List<Integer> l = null;
    		if( Usuario.getUsurioSesion().organigrama_id != null){
    			deptoId = Usuario.getUsurioSesion().organigrama_id.intValue();
				l = Usuario.getUsersOrganigramaHijos(deptoId);
    		}else if( Usuario.getUsurioSesion().departamento_id != null){
    			deptoId = Usuario.getUsurioSesion().departamento_id.intValue();
    			l = Usuario.getUsersDepartamentosHijos(deptoId);
    		}
    		Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxx"+l.size());
    		if(l.size() > 0 && Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(Organigrama.HEARM) == 0){
    			if(Usuario.getUsuarioSesion().equals(20)){//von der heyde
    				/*if(!profe.isEmpty()){
    		    		if(profe.compareToIgnoreCase("SI") > 0){
    		    			e.eq("profe", true);
    		    		}
    		    	}else{*/
    		    		
    		    		if(!tipo_cuenta_id.isEmpty()){
    		    			e = e.disjunction();
    	    				e = e.eq("tipo_cuenta_id", TipoCuenta.PROFE);
    	    				e = e.in("create_usuario_id", l);
    	    				e = e.endJunction();
    		    		}else {
		    				e = e.disjunction();
		    				e = e.eq("tipo_cuenta_id", TipoCuenta.PROFE);
		    				e = e.in("create_usuario_id", l);
		    				e = e.endJunction();
    		    		}
	    			//}
    				
    			}else{
    				e = e.in("create_usuario_id", l);
    			}
    		}else{
    			
    			 
    				e = e.disjunction();
        			e = e.in("deposito_id",Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
        			
    	    			e = e.conjunction();
    	    				e = e.in("create_usuario_id",Usuario.getUsuarioSesion());
    	    				e = e.eq("deposito_id",Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    	    			e = e.endJunction();
        			e = e.endJunction();
    		}
    	}
    	
    	if(!obra_social_id.isEmpty()){
    		e.eq("cliente.obrasocial_id", Integer.parseInt(obra_social_id));
    	}
    	
    	if(!tipo_cuenta_id.isEmpty()){
    		e.eq("tipo_cuenta_id", Integer.parseInt(tipo_cuenta_id));
    	}
    	
    	if(!asignacion_usuario_id.isEmpty()){
    		e.eq("asignacion_usuario_id", Integer.parseInt(asignacion_usuario_id));
    	}
    	
    	if(!nro_liquidacion_parque.isEmpty()){
    		e.eq("liquidacionMes.nro_liquidacion_parque", Integer.parseInt(nro_liquidacion_parque));
    	}
    	
    	if(!desde.isEmpty()){
    		Date fdesde = DateUtils.formatDate(desde, "dd/MM/yyyy");
    		e.ge("create_date", fdesde);
    	}

    	if(!hasta.isEmpty()){
    		Date fhasta = DateUtils.formatDate(hasta, "dd/MM/yyyy");
    		e.le("create_date", fhasta);
    	}
    	
    	if(!fdesdepreventiva.isEmpty()){
    		Date fdesde = DateUtils.formatDate(fdesdepreventiva, "dd/MM/yyyy");
    		e.ge("fecha_imputacion", fdesde);
    	}

    	if(!fhastapreventiva.isEmpty()){
    		Date fhasta = DateUtils.formatDate(fhastapreventiva, "dd/MM/yyyy");
    		e.le("fecha_imputacion", fhasta);
    	}
    	
    	if(!profe.isEmpty()){
    		if(profe.compareToIgnoreCase("SI") == 0){
    			e.eq("profe", true);
    		}else{
    			e.eq("profe", false);
    		}
    	} 
    	
    	if(!recuperable.isEmpty()){
    		if(recuperable.compareToIgnoreCase("SI") ==0){
    			e.eq("recuperable", true);
    		}else{
    			e.eq("recuperable", false);
    		}
    	}
    	
    	if(!repo_stock.isEmpty()){
    		if(repo_stock.compareToIgnoreCase("SI") ==0){
    			e.eq("repo_stock", true);
    		}else{
    			e.eq("repo_stock", false);
    		}
    	}
    	
    	if(!entregado.isEmpty()){
    		if(entregado.compareToIgnoreCase("SI") ==0){
    			e.eq("entregado", true);
    		}else{
    			e.eq("entregado", false);
    		}
    	}
    	
    	if(!emergencia.isEmpty()){
    		if(emergencia.compareToIgnoreCase("SI") ==0){
    			e.eq("expediente.emergencia", true);
    		}else{
    			e.eq("expediente.emergencia", false);
    		}
    	}
    	
    	

		if(!referencia.isEmpty())
			e.ilike("referencia", "%" + referencia + "%");
		
		if(!pedido_rismi.isEmpty())
			e.ilike("pedido_rismi_id", "%" + pedido_rismi + "%");
		
		if(!responsable.isEmpty())
			e.eq("create_usuario_id", Integer.parseInt(responsable));
		if(!solicitante.isEmpty())
			e.eq("medico_id", Integer.parseInt(solicitante));
        if(!cliente.isEmpty())
        	e.eq("cliente_id", Integer.parseInt(cliente));
        if(!expediente.isEmpty())
        	e.eq("expediente_id", Integer.parseInt(expediente));
        if(!servicio.isEmpty())
        	e.eq("departamento_id", Integer.parseInt(servicio));
        
        if(!estado.isEmpty()){
        	e.eq("estado.id", Integer.parseInt(estado));
        }
        
        if( Usuario.getUsurioSesion().organigrama_id == null || (!Usuario.getUsurioSesion().organigrama_id.equals(new Long(20)) && !Usuario.getUsurioSesion().organigrama_id.equals(new Long(90)))){
    		e.ne("estado.id", Estado.SOLICITUD_ESTADO_RESERVADO);
    	}
        
        if(!ejercicio.isEmpty())
        	e.eq("expediente.ejercicio_id", Integer.parseInt(ejercicio));
        
        if(!producto.isEmpty())
        	e.eq("lineas.producto_id", Integer.parseInt(producto));
        
        if(!cuenta_analitica_padre_id.isEmpty())
        	e.eq("lineas.cuenta_analitica_id", Integer.parseInt(cuenta_analitica_padre_id));
        
    	p.setExpressionList(e);
    	
    	return p;
	}
	
	public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> solSeleccionados){
		
		SqlUpdate update = Ebean.createSqlUpdate("UPDATE solicitudes " +
				"SET state_id = :idEstado,write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idEstado", idEstado);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", solSeleccionados);
		
		return update.execute();
	}
	
}
