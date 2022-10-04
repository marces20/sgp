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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import models.Cliente;
import models.CuentaAnalitica;
import models.Estado;
import models.Expediente;
import models.Periodo;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import server.Configuracion2;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "recupero_pagos")
public class RecuperoPago extends Model {
	
private static final long serialVersionUID = 1L;
	
	public static final String PAGO_CHEQUE   = "cheque";
	public static final String PAGO_TARJETA  = "tarjeta";
	public static final String PAGO_EFECTIVO = "efectivo";

	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_pagos_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente; 
	@Required(message="Debe tener un cliente asociado")
	public Long cliente_id;
	
	public Long pago_principal_id;
	
	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;
	
	public String nombre;
	public String nota;
	public String concepto;
	
	public String numero;
	
	public Boolean parcializada = false;
	
	@Required(message="Seleccione un tipo de pago")
	public String tipoPago;
	
	/*@OneToOne(mappedBy="pago")
	public Cheque cheque;*/
	
	@OneToMany()
	public List<Cheque> cheque;
	
	
	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id; 
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	
	
	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(updatable=false)
	public Date create_date;
	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(updatable=false)
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	public Integer periodo_id;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Integer expediente_id;
	
	@ManyToOne
	@JoinColumn(name="planilla_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoPlanilla planilla;
	@Required(message="Seleccion Planilla")
	public Integer planilla_id;
	
	@ManyToOne
	@JoinColumn(name="recupero_factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoFactura recuperoFactura;
	public Integer recupero_factura_id;
	
	@Transient
	public String textoTipoPago;
	
	@DecimalComa(value="")
	@Required(message="Requiere precio")
	public BigDecimal total;//Base

	
	
    public void setId(Long id) {
        this.id = id;
    }
	
	public static Model.Finder<Long,RecuperoPago> find = new Finder<Long,RecuperoPago>(Long.class, RecuperoPago.class);
	
	public String getTextoTipoPago() {

		try {
			switch (tipoPago) {
			case "cheque":
				return "Cheque";
			case "tarjeta":
				return "Tarjeta";
			case "transferencia":
				return "Trasferencia";
			case "contado":
				return "Contado";
			default:
				return "";
			}
		} catch (Exception es) {
			
		}
		
		return "";
		
	}
	
	public Long parcializar(Long id){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			stmt = conn.prepareStatement("SELECT parcializar_recupero_pago(?)");
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
	
	
	public static Pagination<RecuperoPago> page(String nombre, 
											    String cliente, 
											    String desde, 
											    String hasta, 
											    String tipoPago, 
											    String filtroBorrador, 
											    String filtroEnCurso, 
											    String filtroAprobada, 
											    String filtroCancelada,
											    String numero_factura,
											    String cliente_tipo_id,
											    String puntoventa_id,
											    String deposito,
											    String planilla_id) {    	
    	Pagination<RecuperoPago> p = new Pagination<RecuperoPago>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
       	ExpressionList<RecuperoPago> e = find
       									.fetch("planilla")
       									.fetch("estado")
       									.fetch("recuperoFactura")
       									.fetch("cliente")
       				 					.where();
		
       	if(!numero_factura.isEmpty()) {
    		e.ilike("recuperoFactura.numero", "%"+numero_factura+"%");
    	}
       	
    	if(!nombre.isEmpty()) {
    		e.ilike("nombre", "%"+nombre+"%");
    	}
    	if(!cliente.isEmpty()) {
    		e.eq("cliente_id", Integer.parseInt(cliente));
    	}
    	
    	if(!deposito.isEmpty()) {
    		e.eq("planilla.deposito_id", Integer.parseInt(deposito));
    	}
    	
    	if(!cliente_tipo_id.isEmpty()){
    		e.eq("cliente.cliente_tipo_id", Integer.parseInt(cliente_tipo_id));
    	}
    	if(!puntoventa_id.isEmpty()){
    		e.eq("recuperoFactura.puntoventa_id", Integer.parseInt(puntoventa_id));
    	}
    	
		if(!desde.isEmpty()){
    		Date fd = DateUtils.formatDate(desde, "dd/MM/yyyy");
    		e.ge("fecha", fd);
    	}
		
		if(!hasta.isEmpty()){
    		Date fh = DateUtils.formatDate(hasta, "dd/MM/yyyy");
    		e.le("fecha", fh);
    	}
    	
    	if(!tipoPago.isEmpty()) {
    		e.eq("tipo_pago", tipoPago);
    	}
		
    	if(!filtroBorrador.isEmpty() || !filtroAprobada.isEmpty() || !filtroCancelada.isEmpty() || !filtroEnCurso.isEmpty()) {
    		e = e.disjunction();

	   		if(!filtroBorrador.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_PAGO_BORRADOR);
	   		}
	   		
	   		if(!filtroAprobada.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_PAGO_PAGADO);
	   		}
	       	
	   		if(!filtroCancelada.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_PAGO_CANCELADO);
	   		}
	   		
	   		if(!filtroEnCurso.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_PAGO_ENCURSO);
	   		}
	   		e = e.endJunction();
    	}
    	
    	
    	if(!planilla_id.isEmpty()) {
    		e.eq("planilla_id", Integer.parseInt(planilla_id));
    	}
    	
    	if(!Permiso.check("verTodoRecupero")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e = e.disjunction();

    			e = e.conjunction();
    			e = e.eq("planilla.deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    			e = e.isNotNull("planilla.deposito_id");
    			e = e.endJunction();
    			
    			e = e.conjunction();
    			e = e.eq("recuperoFactura.planilla.deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    			e = e.isNull("planilla.deposito_id");
    			e = e.endJunction();
    			
    			e = e.endJunction();
    		}else{
    			e.isNull("planilla.deposito_id");
    		}
    	}
    	
    	p.setExpressionList(e);
    	return p;
	}
	
	public static BigDecimal getTotalPagadoPorFecha(Date fdesde,Date fhasta){
		
		BigDecimal r = new BigDecimal(0); 
		String where = "";
		if(fhasta != null && fdesde != null){
			where += " AND fecha >= :fdesde AND fecha <= :fhasta ";
		}
		
		String sql = "SELECT SUM(total) as total " +
				"FROM recupero_pagos pr " +
				"WHERE estado_id = :estado "+where;
				
		SqlQuery s = Ebean.createSqlQuery(sql);
		
		if(fhasta != null && fdesde != null){
			s = s.setParameter("fdesde",fdesde);
			s = s.setParameter("fhasta",fhasta);
		}
		
		s = s.setParameter("estado",Estado.RECUPERO_PAGO_PAGADO);
		
		SqlRow re = s.findUnique();
		
		if(s != null){
			r = re.getBigDecimal("total");
		}
		
		return r;
	}
	
	public boolean controlPermisoDeposito() {
		boolean r = true; 
		if(!Permiso.check("verTodoRecupero")){
			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
				
				Long dip = null;
				if(planilla_id != null) {
					RecuperoPlanilla rp = RecuperoPlanilla.find.byId(planilla_id.longValue());
					dip = rp.deposito_id;
				}else {
					RecuperoFactura rf = RecuperoFactura.find.byId(recupero_factura_id.longValue());
					dip = rf.planilla.deposito_id;
				}
				
				Logger.debug("yyyyyyyyyyyy "+dip);
				if(Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(dip) != 0) {
					r = false;
				}
			}else {
				r = false;
			}
		}
		
		return r;
	}
}
