package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;

import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "actas_movimientos")
public class ActaMovimiento extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="actas_movimientos_id_seq")
	public Long id;
	
	@OneToOne
	@JoinColumn(name="acta_id", referencedColumnName="id", insertable=false, updatable=false)
	public ActaRecepcion acta;
	@Required(message="Debe tener uns acta asociado")
	public Long acta_id;
	
	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama; 
	@Column(name="organigrama_id")
	@Required(message="Debe seleccionar un departamento/servicio")
	public Long organigrama_id;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario usuario; 
	@Column(name="usuario_id")
	public Long usuario_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy hh:mm:ss")
	public Date fecha_llegada;
	
	@Formats .DateTime(pattern="dd/MM/yyyy hh:mm:ss")
	public Date fecha_salida;
	
	public String descripcion;
	
	public boolean cancelado;
	
	public boolean cierre = false;
	
	public boolean copia = false;
	
	public Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="estado_id")
	public Long estado_id; 
	
	@ManyToOne
	@JoinColumn(name="usuario_receptor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario usuario_receptor; 
	@Column(name="usuario_receptor_id")
	public Long usuario_receptor_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy hh:mm:ss")
	public Date date_recepcion;
	

	public static Model.Finder<Long,ActaMovimiento> find = new Finder<Long,ActaMovimiento>(Long.class, ActaMovimiento.class);
	
	public static Pagination<ActaMovimiento> page(Long actaId) {    	
    	Pagination<ActaMovimiento> p = new Pagination<ActaMovimiento>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(find.fetch("acta").where().eq("acta_id", actaId));
    	return p;
	}
	
	public static Pagination<ActaMovimiento> pagePasesPorUsuario(String usuario_id,
			String numero,
			String expediente_id) {    	
    	Pagination<ActaMovimiento> p = new Pagination<ActaMovimiento>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	 
    	
    	ExpressionList<ActaMovimiento> e = find.fetch("acta")
    										.fetch("organigrama")
    										.fetch("usuario")
    										.fetch("acta.ordenProvision", "numero")
    										.fetch("acta.ordenProvision.ordenCompra.expediente", "nombre, emergencia")
    										.fetch("acta.ordenProvision.ordenCompra.expediente.ejercicio", "nombre")
    										.fetch("acta.ordenProvision.ordenCompra.expediente.parent.ejercicio", "nombre")
    										.where();
    	
    	//e.eq("cancelado",false);
    	//e.eq("estado_id",Estado.ACTA_MOVIMIENTO_ENVIADO);
    	
    	if(!expediente_id.isEmpty()) {
    		e.eq("acta.ordenProvision.ordenCompra.expediente_id", Integer.valueOf(expediente_id));
    	}
    	
    	if(!numero.isEmpty()) {
    		e.eq("acta.numero", numero);
    	} 
    	
    	if(!usuario_id.isEmpty()) {
    		e.eq("usuario_id", Integer.parseInt(usuario_id));
    	}
    	
    	p.setExpressionList(e);
    	return p;
	}
	
	
	public static Pagination<ActaMovimiento> pageGeneral(String organigrama_id,
			String numero,
			String expediente_id,
			String estado_id,
			String cierre,
			String filtroEnviado,
			String filtroCancelado,
			String filtroRecepcionado,
			String ejercicio) {    	
    	Pagination<ActaMovimiento> p = new Pagination<ActaMovimiento>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setPageSize(100);
    	
    	ExpressionList<ActaMovimiento> e = find.fetch("acta")
    											.fetch("organigrama")
												.fetch("usuario")
												.fetch("acta.ordenProvision", "numero")
												.fetch("acta.ordenProvision.ordenCompra.expediente", "nombre, emergencia")
												.fetch("acta.ordenProvision.ordenCompra.expediente.ejercicio", "nombre")
												.fetch("acta.ordenProvision.ordenCompra.expediente.parent.ejercicio", "nombre")
												.where();
    	
    	if(!expediente_id.isEmpty()) {
    		e.eq("acta.ordenProvision.ordenCompra.expediente_id", Integer.valueOf(expediente_id));
    	}
    	
    	if(!numero.isEmpty()) {
    		e.eq("acta.numero", numero);
    	} 
    	
    	if(!ejercicio.isEmpty()) {
    		e.eq("acta.ejercicio_id", Integer.valueOf(ejercicio));
    	}
    	
    	
    	 
    	if(!cierre.isEmpty()){
    		if(cierre.compareToIgnoreCase("SI") == 0){
    			e.eq("cierre", true);
    		}else{
    			e.eq("cierre", false);
    		}
    	}
    	
    	
    	if(!filtroEnviado.isEmpty() || !filtroCancelado.isEmpty() || !filtroRecepcionado.isEmpty()) {
			e = e.disjunction();
			if(!filtroEnviado.isEmpty()){
	    		e = e.eq("estado_id", Estado.ACTA_MOVIMIENTO_ENVIADO);
	    	}
			if(!filtroCancelado.isEmpty()){
	    		e = e.eq("cancelado",true);
	    	}
			if(!filtroRecepcionado.isEmpty()){
	    		e = e.eq("estado_id", Estado.ACTA_MOVIMIENTO_RECEPCIONADO);
	    		e = e.eq("estado_id", Estado.ACTA_MOVIMIENTO_RECEPCIONADO_AUTOMATICO);
	    	}
			 
			e = e.endJunction();
		}else {
			e.eq("estado_id",Estado.ACTA_MOVIMIENTO_ENVIADO);
		}
    	
    	e.eq("cancelado",false);
    	
    	 
    	
    	
    	if(!organigrama_id.isEmpty()  && organigrama_id != null) {
    		e.eq("organigrama_id", Integer.parseInt(organigrama_id));
    	}else {
    		e.isNull("organigrama_id");
    	}
    	
    	p.setExpressionList(e);
    	return p;
	}
	
	public static ActaMovimiento getLastMovimiento(Long eId){
		ActaMovimiento e = ActaMovimiento
								.find.where()
								.eq("acta_id", eId)
								.ne("cancelado", true)
								.setOrderBy("id DESC").setMaxRows(1).findUnique();
		return e;
	}
	
	public static ActaMovimiento getMovimientoAnterior(ActaMovimiento f){
		ActaMovimiento e = ActaMovimiento.find.where()
								.le("id", f.id)
								.ne("id", f.id)
								.ne("cancelado", true)
								.eq("acta_id", f.acta_id)
								.setOrderBy("id DESC").setMaxRows(1).findUnique();
		return e;
	}
	
	public static String getMovimientoAnteriorEnTiempo(ActaMovimiento f){
		String r = "";
		ActaMovimiento e = ActaMovimiento.find.where()
								.le("id", f.id)
								.ne("id", f.id)
								.ne("cancelado", true)
								.eq("acta_id", f.acta_id)
								.setOrderBy("id DESC").setMaxRows(1).findUnique();
		
		if(e.fecha_salida != null){
			r = utils.DateUtils.restarDates(e.fecha_llegada, e.fecha_salida);
		}else{
			r = utils.DateUtils.restarDates(e.fecha_llegada, new Date());
		}
		
		return r;
	}
	
	public static String tiempoEnMovimiento(ActaMovimiento f){
		String r = "";
		
		if(f.fecha_salida != null){
			r = utils.DateUtils.restarDates(f.fecha_llegada, f.fecha_salida);
		}else{
			r = utils.DateUtils.restarDates(f.fecha_llegada, new Date());
		}
		
		return r;
	}
	
	public static boolean isLastMovimientoServicioUsuario(Long idActa,Long orgaId) {
		String sql = " SELECT organigrama_id " +
					 " FROM actas_movimientos " +
					 " WHERE acta_id =:idActa  AND cancelado <> true " +
					 " ORDER BY fecha_llegada DESC" +
					 " LIMIT 1 ";
		
		SqlRow l = Ebean.createSqlQuery(sql)
						 .setParameter("idActa", idActa)
						 .findUnique();
		
		boolean ret = false;
		if(l != null){
			ret = (orgaId.compareTo(l.getLong("organigrama_id")) == 0);
		}else{
			ret = true;
		}
		
		return  ret;
	}
	
	public static List<Long> getStringIsNotMovimientoServicioUsuario(Integer idActa,Long orgaId) {
		List<Integer> le = new ArrayList<Integer>();
		le.add(idActa);
		return getStringIsNotMovimientoServicioUsuario(le,orgaId);
	}
	
	public static List<Long> getStringIsNotMovimientoServicioUsuario(List<Integer> idsActas,Long orgaId) {
		List<Long> ret = new ArrayList<Long>();
		String sql = " SELECT organigrama_id,acta_id FROM actas_movimientos " +
				" WHERE (fecha_llegada, acta_id) IN ( " +
				" SELECT MAX(fecha_llegada),acta_id  " +
				" FROM actas_movimientos em  " +
				" WHERE acta_id in(:listId) AND cancelado <> true " +
				" GROUP BY acta_id) AND organigrama_id  <> :orgaId and copia <> true ";
		
		List<SqlRow> l = Ebean.createSqlQuery(sql)
						 .setParameter("listId", idsActas)
						 .setParameter("orgaId", orgaId)
						 .findList();
		 
		if(l.size() > 0){
			for(SqlRow x : l){
				ret.add(x.getLong("acta_id"));
			}
		}
		
		return  ret;
	}
	
	public static List<Long> getStringIsNotMovimientoCierre(List<Integer> idsActas){
		List<Long> ret = new ArrayList<Long>();
		String sql = " SELECT cierre,acta_id FROM actas_movimientos " +
				" WHERE (fecha_llegada, acta_id) IN ( " +
				" SELECT MAX(fecha_llegada),acta_id  " +
				" FROM actas_movimientos em  " +
				" WHERE acta_id in(:listId) AND cancelado <> true " +
				" GROUP BY acta_id) AND cierre = true and copia <> true ";
		
		List<SqlRow> l = Ebean.createSqlQuery(sql)
						 .setParameter("listId", idsActas)
						 .findList();
		 
		if(l.size() > 0){
			for(SqlRow x : l){
				ret.add(x.getLong("acta_id"));
			}
		}
		
		return  ret;
	}
	
	public static Integer pasarOtroServicioMasivo(Integer idActa,Long organigramaId,String desc){
		List<Integer> idsActas = new ArrayList<Integer>();
		idsActas.add(idActa);
		return pasarOtroServicioMasivo(idsActas,organigramaId,desc);
	}
	
	
	public static Integer pasarOtroServicioMasivo(List<Integer> idsActas,Long organigramaId,String desc){
		return pasarOtroServicioMasivo(idsActas,organigramaId,desc,false);			
	}
	
	public static Integer pasarOtroServicioMasivo(List<Integer> idsActas,Long organigramaId,String desc,boolean creaCopia){
		
		try{
			 
			Date ahora = new Date();
			Integer codigo = getSecuenciaActaMovimientoCodigo();
			
			for(Integer i : idsActas){
				
				ActaMovimiento f = new ActaMovimiento();
				
				
				if(creaCopia) {
					ActaMovimiento fc = new ActaMovimiento();
					fc.descripcion = desc;
					fc.acta_id = (long) i;
					fc.organigrama_id = new Long(71);
					fc.usuario_id = new Long(Usuario.getUsuarioSesion());
					fc.fecha_llegada = ahora;
					fc.cancelado = false;
					fc.codigo = codigo;
					fc.estado_id = (long) Estado.ACTA_MOVIMIENTO_ENVIADO;
					fc.cierre = true;
					fc.copia = true;
					fc.save();
					
					f.cierre = true;
				}
					
				
				f.descripcion = desc;
				f.acta_id = (long) i;
				f.organigrama_id = organigramaId;
				f.usuario_id = new Long(Usuario.getUsuarioSesion());
				f.fecha_llegada = ahora;
				f.cancelado = false;
				f.codigo = codigo;
				f.estado_id = (long) Estado.ACTA_MOVIMIENTO_ENVIADO;
				if(desc.compareTo("Autoasignacion") == 0) {
					f.estado_id = (long) Estado.ACTA_MOVIMIENTO_RECEPCIONADO;
					f.usuario_receptor_id = new Long(Usuario.getUsuarioSesion());
				}
				
				f.save(); 
				
				
				ActaMovimiento ma = getMovimientoAnterior(f);
				
				if(ma != null){
					
					SqlUpdate update = Ebean.createSqlUpdate("UPDATE actas_movimientos SET fecha_salida = :ahora WHERE id = :idz and cierre = false ");
					update.setParameter("ahora", ahora);
					update.setParameter("idz", ma.id);
					update.execute();
					//ma.fecha_salida = ahora;
					//ma.update();
				}
			}
		}catch(Exception e){
			Logger.debug(" "+e.toString());
		}
		return idsActas.size();
	}
	
	public static Integer getSecuenciaActaMovimientoCodigo(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Integer ret =0;
		try {
			
			conn = play.db.DB.getConnection();
			
			stmt = conn.prepareStatement("SELECT nextval('acta_movimiento_codigo_id_seq')");
			 
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				ret = rs.getInt(1);
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
	
}
