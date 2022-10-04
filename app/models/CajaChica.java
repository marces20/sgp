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
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import models.auth.Permiso;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity 
@Table(name = "caja_chica")
public class CajaChica extends Model{
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="caja_chica_id_seq")
	public Long id; 
	
	@Required(message="Debe escribir una referencia")
	public String nombre;
	
	public BigDecimal monto_cheque;
	public String orden_cargo;
	
	@Required(message="Debe escribir una referencia")
	public String referencia;
	
	@Formula(select = "_b${ta}.total", join = "left outer join (select caja_chica_id, sum(round(precio *cantidad,2)) as total from caja_chica_movimientos group by caja_chica_id) as _b${ta} on _b${ta}.caja_chica_id = ${ta}.id")
	public BigDecimal total;
	
	@OneToMany
	public List<CajaChicaMovimiento> movimientos;
	
	@Formats .DateTime(pattern="dd/MM/yyyy") 
	@Required(message="La fecha es obligatorio")
	public Date fecha; 
	
	@Required(message="El monto límite es obligatorio")
	public BigDecimal monto_limite; 
	
	
	@Required(message="El N° cheque es obligatorio")
	public String numero_cheque;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	public Long create_usuario_id;
	 
	public Date create_date; 
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Debe seleccionar un expediente")
	public Integer expediente_id; 

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
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;
	public Long orden_pago_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaPropia cuentaPropia;
	@Required(message="Requiere Cuenta Propia")
	public Integer cuenta_propia_id;
	
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	public BigDecimal getTotal() {
		if (total == null)
			return new BigDecimal(0);
		return total;
		
	}
	
	public BigDecimal getMontoLimite() {
		if (monto_limite == null)
			return new BigDecimal(0);
		return monto_limite;
		
	}
	
	public BigDecimal getTotalDisponible() {
		return getMontoLimite().subtract(getTotal());
	}
	
	public static Finder<Long,CajaChica> find = new Finder<Long,CajaChica>(Long.class, CajaChica.class);
	

	
	public static Pagination<CajaChica> page(
				String referencia,
				String expediente_id,
				String estado,
				String desde,
				String hasta,
				String filtroBorrador,
				String filtroEnCurso,
				String filtroCerrada,
				String filtroCancelada,
				String deposito_id,
				String cheque,
				String orden_pago_id,
				String ejercicio
			){    	
		
		
    	Pagination<CajaChica> p = new Pagination<CajaChica>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<CajaChica> e = find.query()
			.fetch("estado")
			.fetch("deposito")
			.fetch("expediente", "id, nombre, emergencia")
			.fetch("expediente.ejercicio", "nombre")
			.fetch("expediente.parent.ejercicio", "nombre")
			.fetch("ordenPago", "numero, id")
			.fetch("ordenPago.ejercicio", "nombre")
			.where();
    	
    	if(!referencia.isEmpty()){
    		e.ilike("referencia", "%" + referencia + "%");
    	}
    	
    	if(!cheque.isEmpty()){
    		e.ilike("numero_cheque", "%" + cheque + "%");
    	}	
    	
    	if(!ejercicio.isEmpty()){
			e.eq("expediente.ejercicio_id", Integer.parseInt(ejercicio));
		}	
    	
    	if(!deposito_id.isEmpty()) {
    		e.eq("deposito_id", Integer.parseInt(deposito_id));
    	}
    	
    	if(!orden_pago_id.isEmpty()){
    		e.eq("ordenPago.id",Integer.parseInt(orden_pago_id) );
    	}
    	
    	if(!expediente_id.isEmpty()) {
    		e.eq("expediente_id", Integer.parseInt(expediente_id));
    	}
    	
    	if(!desde.isEmpty()){
    		Date fdesde = DateUtils.formatDate(desde, "dd/MM/yyyy");
    		e.ge("create_date", fdesde);
    	}

    	if(!hasta.isEmpty()){
    		Date fhasta = DateUtils.formatDate(hasta, "dd/MM/yyyy");
    		e.le("create_date", fhasta);
    	}
    	
    	if(!filtroBorrador.isEmpty() || !filtroCerrada.isEmpty() || !filtroCancelada.isEmpty() || !filtroEnCurso.isEmpty()) {
			e = e.disjunction();
			if(!filtroBorrador.isEmpty()){
	    		e = e.eq("estado_id",Estado.CAJA_CHICA_BORRADOR);
	    	}
			if(!filtroEnCurso.isEmpty()){
	    		e = e.eq("estado_id",Estado.CAJA_CHICA_ABIERTA);
	    	}
			if(!filtroCerrada.isEmpty()){
	    		e = e.eq("estado_id",Estado.CAJA_CHICA_CERRADA);
	    	}
			if(!filtroCancelada.isEmpty()){
	    		e = e.eq("estado_id",Estado.CAJA_CHICA_CANCELADA);
	    	}
			e = e.endJunction();
		}
    	
    	if(!Permiso.check("verTodoCajaChica")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("deposito_id");
    		}
    	}
    	
    	p.setExpressionList(e);
    	return p;
    	
    }
	
	public boolean controlPermisoDeposito() {
		boolean r = true;
		
		if(!Permiso.check("verTodoCajaChica")){
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
