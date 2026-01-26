package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;
import play.db.ebean.Model;
import utils.pagination.Pagination;

import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

@Entity
@Table(name = "expedientes")
public class Expediente extends Model{


	public static Long[] EXP_GUARDIA_MONOTRIBUTOS = {new Long(11876),new Long(13433),new Long(16496),new Long(19726)};

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="expedientes_id_seq")
	public Long id;
	@Required(message="Expediente requerido")
	public String nombre;

	@Required(message="Debe escribir una descripción")
	public String descripcion;

	@ManyToOne
	@JoinColumn(name="ejercicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Ejercicio ejercicio;
	@Required(message="Ejercicio requerido")
	public Long ejercicio_id;

	@ManyToOne
	@JoinColumn(name="parent_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente parent;
	public Long parent_id;

	@ManyToOne
	public Ejercicio ejercicio_original;

	public Boolean activo = false;
	public Boolean autoasignacion = false;
	public Boolean reservado = false;
	public Boolean guardia = false;
	public String estado;
	public Boolean requisition = false;
	public Boolean residuo_pasivo = false;
	public Boolean licitacion = false;
	public Boolean cerrar = false;
	public Boolean emergencia = false;
	public Boolean profe = false;
	public Integer nro_copia;
	public Boolean pago = false;

	@ManyToOne
	@JoinColumn(name="padre_copia_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente padreCopia;
	public Long padre_copia_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@ManyToOne
	public IniciadorExpediente iniciador;

	@Transient
	public String expedienteEjercicio;

	@OneToMany
	public List<ExpedienteMovimiento> expedienteMovimientos;

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

	@Formula(select = "_d${ta}.servicio", join = "LEFT OUTER JOIN (SELECT o.nombre as servicio,expediente_id FROM expedientes_movimientos  em INNER JOIN organigramas o ON o.id = em.organigrama_id WHERE (em.id, expediente_id) IN (SELECT MAX(em2.id),expediente_id FROM expedientes_movimientos em2 WHERE em2.cancelado <> true GROUP BY expediente_id)) as _d${ta} on _d${ta}.expediente_id = ${ta}.id")
	public String servicio;

	@OneToMany
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<ExpedienteMovimiento> movimientos;

	@OneToOne(fetch=FetchType.LAZY, mappedBy="expediente")
	public ExpedienteMovimiento movimiento;

	public String getServicio(){
		if (servicio == null)
			return "";
		return  servicio;
	}

	public String getExpedienteEjercicio(){
		String ejercicioPadre = "";
		if(parent != null) {
			ejercicioPadre = "/"+parent.ejercicio.nombre;
		}
		return nombre != null ? ejercicio.nombre != null ? nombre +ejercicioPadre+ " / " + ejercicio.nombre : "" : "";
	}

	public String getInstitucionExpedienteEjercicio(){
		String ejercicioPadre = "";
		if(parent != null) {
			ejercicioPadre = "/"+parent.ejercicio.nombre;
		}
		return nombre != null ? ejercicio.nombre != null ? "6550-"+nombre +ejercicioPadre+ " / " + ejercicio.nombre : "" : "";
	}

	public static Finder<Long,Expediente> find = new Finder<Long,Expediente>(Long.class, Expediente.class);

	public List<Expediente> getDataSuggest(String input,Integer limit,boolean copia){
		//
		ExpressionList<Expediente> e= find.where();
		if(copia){
			e.isNotNull("nro_copia");
		}else{
			e.isNull("nro_copia");
		}

		Integer[] aa = {new Integer(1),new Integer(2),new Integer(3),new Integer(4),new Integer(5),new Integer(6),new Integer(7)};

		List<Expediente> l = e.ilike("nombre", "%"+input+"%")
							 .not(Expr.in("ejercicio_id",aa))
							 .setMaxRows(limit).orderBy("id desc")
							 .findList();

		return l;
	}

	public static Pagination<Expediente> page(String nombre, String descripcion,String ejercicio,String rp, String copia,String organigrama_id) {
    	Pagination<Expediente> p = new Pagination<Expediente>();
    	p.setOrderDefault(" ");
    	p.setSortByDefault("residuo_pasivo ASC,ejercicio_id DESC,nombre DESC");


    	ExpressionList<Expediente> e = find.fetch("ejercicio").fetch("movimiento").fetch("movimiento.organigrama").where();


    	String or = "";
    	if(!organigrama_id.isEmpty())
    		e.eq("movimiento.organigrama_id", Integer.parseInt(organigrama_id));
    	else
    		or = "OR movimiento.id IS NULL";



    	e.add(Expr.raw("( (movimiento.fecha_llegada, movimiento.expediente_id) in (SELECT MAX(em2.fecha_llegada), expediente_id FROM expedientes_movimientos em2 WHERE em2.cancelado <> true GROUP BY expediente_id) " + or +")"));


    	if(!nombre.isEmpty())
			e.ilike("nombre", "%" + nombre + "%");
    	if(!descripcion.isEmpty())
			e.ilike("descripcion", "%" + descripcion + "%");
    	if(!ejercicio.isEmpty())
    		e.eq("ejercicio_id", Integer.parseInt(ejercicio));

    	if(!rp.isEmpty()){
    		if(rp.compareToIgnoreCase("SI") ==0){
    			e.eq("residuo_pasivo", true);
    		}else{
    			e.eq("residuo_pasivo", false);
    		}
    	}

    	if(!copia.isEmpty()){
    		if(copia.compareToIgnoreCase("SI") ==0){
    			e.isNotNull("nro_copia");
    		}else{
    			e.isNull("nro_copia");
    		}
    	}

    	p.setExpressionList(
	    			e
	            );
    	return p;
    }

	public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        if (find.where().eq("nombre", nombre).eq("ejercicio_id", ejercicio_id).ne("id", id).findRowCount() > 0) {
            errors.add(new ValidationError("nombre", "El expediente ya existe."));
        }
        return errors.isEmpty() ? null : errors;
    }

	public Long crearCopia(Long idExpediente,Long idUsuario,Long idOrganigrama){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {

			conn = play.db.DB.getConnection();

			stmt = conn.prepareStatement("SELECT expediente_crear_copia(?,?,?)");
			stmt.setInt(1, idExpediente.intValue());
			stmt.setInt(2, idUsuario.intValue());
			stmt.setInt(3, idOrganigrama.intValue());

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

	public Long crearRP(Long idExpediente){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {

			conn = play.db.DB.getConnection();

			stmt = conn.prepareStatement("SELECT expediente_crear_rp(?,?)");
			stmt.setInt(1, idExpediente.intValue());
			stmt.setInt(2, Usuario.getUsurioSesion().id);
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
}
