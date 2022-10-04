package models.recupero;

import java.math.BigDecimal;
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
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import models.CertificacionLinea;
import models.Cliente;
import models.Deposito;
import models.Estado;
import models.Factura;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import server.Configuracion2;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity 
@Table(name = "presupuestos")
public class Presupuesto extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="presupuestos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente; 
	@Required(message="Debe tener un cliente asociado")
	public Long cliente_id;
	
	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;
	
	public String nombre;
	public String nota;
	
	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id; 
	
	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	@Required(message="Requiere una Institucion")
	public Long deposito_id;
	
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
	
	@Formula(select = "_c${ta}.total", join = "left outer join (select presupuesto_id, round(sum(precio * cantidad)::numeric,2) as total from presupuesto_lineas group by presupuesto_id) as _c${ta} on _c${ta}.presupuesto_id = ${ta}.id")
	public BigDecimal total;//Base
	public BigDecimal getTotal(){
		if (total == null)
			return new BigDecimal(0);
		return total;
	}
	
	@OneToMany()
	public List<PresupuestoLinea> presupuestoLinea;
	
	public static Model.Finder<Long,Presupuesto> find = new Finder<Long,Presupuesto>(Long.class, Presupuesto.class);
	
	public static Pagination<Presupuesto> page(String nombre, 
											   String cliente, 
											   String desde, 
											   String hasta, 
											   String filtroBorrador, 
											   String filtroEnCurso, 
											   String filtroAprobada, 
											   String filtroCancelada,
											   String deposito) {    	
    	Pagination<Presupuesto> p = new Pagination<Presupuesto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<Presupuesto> e = find.fetch("cliente").fetch("deposito").where();
    		
    	if(!nombre.isEmpty()) {
    		e.ilike("nombre", "%"+nombre+"%");
    	}
    	if(!cliente.isEmpty()) {
    		e.eq("cliente_id", Integer.parseInt(cliente));
    	}
    	if(!deposito.isEmpty()) {
    		e.eq("deposito_id", Integer.parseInt(deposito));
    	}
		if(!desde.isEmpty()){
    		Date fd = DateUtils.formatDate(desde, "dd/MM/yyyy");
    		e.ge("fecha", fd);
    	}
		
		if(!hasta.isEmpty()){
    		Date fh = DateUtils.formatDate(hasta, "dd/MM/yyyy");
    		e.le("fecha", fh);
    	}
    	
    	if(!filtroBorrador.isEmpty() || !filtroAprobada.isEmpty() || !filtroCancelada.isEmpty() || !filtroEnCurso.isEmpty()) {
    		e = e.disjunction();

	   		if(!filtroBorrador.isEmpty()){
	   			 e = e.eq("estado_id", Estado.PRESUPUESTO_BORRADOR);
	   		}
	   		
	   		if(!filtroAprobada.isEmpty()){
	   			 e = e.eq("estado_id", Estado.PRESUPUESTO_APROBADO);
	   		}
	       	
	   		if(!filtroCancelada.isEmpty()){
	   			 e = e.eq("estado_id", Estado.PRESUPUESTO_CANCELADO);
	   		}
	   		
	   		if(!filtroEnCurso.isEmpty()){
	   			 e = e.eq("estado_id", Estado.PRESUPUESTO_ENCURSO);
	   		}
	   		e = e.endJunction();
    	}
    	
    	if(!Permiso.check("verTodoRecupero")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("deposito_id");
    		}
    	}
    	
    	p.setExpressionList(e);
    	return p;
	}
	
	public Long duplicar(Long id){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
												 
			stmt = conn.prepareStatement("SELECT duplicar_presupuesto(?)");
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
		
		if(!Permiso.check("verTodoRecupero")){
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
