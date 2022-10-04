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
import server.Configuracion2;
import utils.pagination.Pagination;

@Entity 
@Table(name = "expedientes_movimientos")
public class ExpedienteMovimiento extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="expedientes_movimientos_id_seq")
	public Long id;
	
	@OneToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Debe tener un expediente asociado")
	public Long expediente_id;
	
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
	
	public Integer codigo;
	
	@OneToMany
	public List<ExpedienteMovimientosOrdenpago> expedienteMovimientosOrdenpago;
	
	public static Model.Finder<Long,ExpedienteMovimiento> find = new Finder<Long,ExpedienteMovimiento>(Long.class, ExpedienteMovimiento.class);
	
	public static Pagination<ExpedienteMovimiento> page(Long expedienteId) {    	
    	Pagination<ExpedienteMovimiento> p = new Pagination<ExpedienteMovimiento>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	p.setExpressionList(find.where().eq("expediente_id", expedienteId));
    	return p;
	}
	
	public static ExpedienteMovimiento getLastMovimiento(Long eId){
		ExpedienteMovimiento e = ExpedienteMovimiento
								.find.where()
								.eq("expediente_id", eId)
								.ne("cancelado", true)
								.setOrderBy("id DESC").setMaxRows(1).findUnique();
		return e;
	}
	
	public static ExpedienteMovimiento getMovimientoAnterior(ExpedienteMovimiento f){
		ExpedienteMovimiento e = ExpedienteMovimiento.find.where()
								.le("id", f.id)
								.ne("id", f.id)
								.ne("cancelado", true)
								.eq("expediente_id", f.expediente_id)
								.setOrderBy("id DESC").setMaxRows(1).findUnique();
		return e;
	}
	
	public static String getMovimientoAnteriorEnTiempo(ExpedienteMovimiento f){
		String r = "";
		ExpedienteMovimiento e = ExpedienteMovimiento.find.where()
								.le("id", f.id)
								.ne("id", f.id)
								.ne("cancelado", true)
								.eq("expediente_id", f.expediente_id)
								.setOrderBy("id DESC").setMaxRows(1).findUnique();
		
		if(e.fecha_salida != null){
			r = utils.DateUtils.restarDates(e.fecha_llegada, e.fecha_salida);
		}else{
			r = utils.DateUtils.restarDates(e.fecha_llegada, new Date());
		}
		
		return r;
	}
	
	public static String tiempoEnMovimiento(ExpedienteMovimiento f){
		String r = "";
		
		if(f.fecha_salida != null){
			r = utils.DateUtils.restarDates(f.fecha_llegada, f.fecha_salida);
		}else{
			r = utils.DateUtils.restarDates(f.fecha_llegada, new Date());
		}
		
		
		
		return r;
	}
	
	public static boolean isLastMovimientoServicioUsuario(Long idExpediente,Long orgaId) {
		String sql = " SELECT organigrama_id " +
					 " FROM expedientes_movimientos " +
					 " WHERE expediente_id =:idExpediente  AND cancelado <> true " +
					 " ORDER BY fecha_llegada DESC" +
					 " LIMIT 1 ";
		
		SqlRow l = Ebean.createSqlQuery(sql)
						 .setParameter("idExpediente", idExpediente)
						 //.setParameter("orgaId", orgaId)
						 .findUnique();
		
		//Logger.debug("xxxxxxxxxxxxxxxxxxxxxx  - "+orgaId+" - ");
		boolean ret = false;
		if(l != null){
			ret = (orgaId.compareTo(l.getLong("organigrama_id")) == 0);
		}else{
			ret = true;
		}
		
		return  ret;
	}
	
	public static List<Long> getStringIsNotMovimientoServicioUsuario(Integer idExpediente,Long orgaId) {
		List<Integer> le = new ArrayList<Integer>();
		le.add(idExpediente);
		return getStringIsNotMovimientoServicioUsuario(le,orgaId);
	}
	
	public static List<Long> getStringIsNotMovimientoServicioUsuario(List<Integer> idsExpedientes,Long orgaId) {
		List<Long> ret = new ArrayList<Long>();
		String sql = " SELECT organigrama_id,expediente_id FROM expedientes_movimientos " +
				" WHERE (fecha_llegada, expediente_id) IN ( " +
				" SELECT MAX(fecha_llegada),expediente_id  " +
				" FROM expedientes_movimientos em  " +
				" WHERE expediente_id in(:listId) AND cancelado <> true " +
				" GROUP BY expediente_id) AND organigrama_id  <> :orgaId ";
		
		List<SqlRow> l = Ebean.createSqlQuery(sql)
						 .setParameter("listId", idsExpedientes)
						 .setParameter("orgaId", orgaId)
						 .findList();
		 
		if(l.size() > 0){
			for(SqlRow x : l){
				ret.add(x.getLong("expediente_id"));
			}
		}
		
		return  ret;
	}
	
	public static Integer pasarOtroServicioMasivo(Integer idExpediente,Long organigramaId,String desc){
		List<Integer> idsExpedientes = new ArrayList<Integer>();
		idsExpedientes.add(idExpediente);
		return pasarOtroServicioMasivo(idsExpedientes,organigramaId,desc);
	}
	
	public static Integer pasarOtroServicioMasivoConOps(List<Integer> idsExpedientes,List<OrdenPagoCircuito> opcl,Long organigramaId,String desc){
		
		try{
			 
			Date ahora = new Date();
			Integer codigo = getSecuenciaExpedienteMovimientoCodigo();
			
			List<Long> listIdsExpedientes = new ArrayList<Long>();
			Long idMov = null;
			Map<Long,List<Long>> expOps = new HashMap<Long,List<Long>>();
			
			for(OrdenPagoCircuito i : opcl){
				Long idExp;
				if(i.expediente_fisico_id != null){
					idExp = i.expediente_fisico_id ;
				}else{
					Expediente ex = Expediente.find.byId(i.expediente_id);
					if(ex.residuo_pasivo){
						idExp = ex.parent_id;
					}else{
						idExp = i.expediente_id ;
					}
				}
				
				if(!expOps.containsKey(idExp)){
					List<Long> lt = new ArrayList<Long>();
					lt.add(i.orden_pago_id);
					expOps.put(idExp, lt);
				}else{
					
					List<Long> ltx = expOps.get(idExp);
					if(!ltx.contains(i.orden_pago_id)){
						ltx.add(i.orden_pago_id);
						expOps.put(idExp, ltx);
					}
				}
				
			}	
			
			for (Map.Entry<Long, List<Long>> entry : expOps.entrySet()) {
				Long key = entry.getKey();
				List<Long> value = entry.getValue();
				
				ExpedienteMovimiento f = new ExpedienteMovimiento();
				f.descripcion = desc;
				f.expediente_id = key;
				f.organigrama_id = organigramaId;
				f.usuario_id = new Long(Usuario.getUsuarioSesion());
				f.fecha_llegada = ahora;
				f.cancelado = false;
				f.codigo = codigo;
				f.save();
				
				idMov =f.id;
				
				ExpedienteMovimiento ma = getMovimientoAnterior(f);
				
				if(ma != null){
					SqlUpdate update = Ebean.createSqlUpdate("UPDATE expedientes_movimientos SET fecha_salida = :ahora WHERE id = :idz ");
					update.setParameter("ahora", ahora);
					update.setParameter("idz", ma.id);
					update.execute();
				}
				
				for(Long v :value){
					ExpedienteMovimientosOrdenpago emo = new ExpedienteMovimientosOrdenpago();
					emo.expediente_movimiento_id = idMov;
					emo.orden_pago_id = v;
					emo.save();
				}
				
			}
		}catch(Exception e){
			Logger.debug(" "+e.toString());
		}
		return idsExpedientes.size();
	}
	
	public static Integer pasarOtroServicioMasivo(List<Integer> idsExpedientes,Long organigramaId,String desc){
		
		try{
			 
			Date ahora = new Date();
			Integer codigo = getSecuenciaExpedienteMovimientoCodigo();
			
			for(Integer i : idsExpedientes){
				
				ExpedienteMovimiento f = new ExpedienteMovimiento();
				f.descripcion = desc;
				f.expediente_id = (long) i;
				f.organigrama_id = organigramaId;
				f.usuario_id = new Long(Usuario.getUsuarioSesion());
				f.fecha_llegada = ahora;
				f.cancelado = false;
				f.codigo = codigo;
				f.save();
				
				ExpedienteMovimiento ma = getMovimientoAnterior(f);
				
				if(ma != null){
					
					SqlUpdate update = Ebean.createSqlUpdate("UPDATE expedientes_movimientos SET fecha_salida = :ahora WHERE id = :idz ");
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
		return idsExpedientes.size();
	}
	
	public static Integer getSecuenciaExpedienteMovimientoCodigo(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Integer ret =0;
		try {
			
			conn = play.db.DB.getConnection();
			
			stmt = conn.prepareStatement("SELECT nextval('expediente_movimiento_codigo_id_seq')");
			 
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

