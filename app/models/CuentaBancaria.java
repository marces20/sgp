package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;

@Entity 
@Table(name = "cuenta_bancarias")
public class CuentaBancaria extends Model {

	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cuenta_bancarias_id_seq")
	public Long id;
	@ManyToOne
	@JoinColumn(name="sucursal_banco_id", referencedColumnName="id", insertable=false, updatable=false)
	public SucursalBanco sucursal_banco;
	@Required(message="Sucursal requerida")
	public Long sucursal_banco_id;
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Requiere proveedor")
	public Integer proveedor_id;
	
	@ManyToOne
	@JoinColumn(name="banco_id", referencedColumnName="id", insertable=false, updatable=false)
	public Banco banco;
	@Required(message="Banco requerido")
	public Long banco_id;
	@Required(message="Debe escribir un número de cuenta")
	public String numero_cuenta;
	
	@Required(message="Debe escribir un número de cuenta")
	public String cbu;
	
	public Boolean activo = false;
	public Boolean predeterminada = false;
	
	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Required(message="Estado requerido")
	public Long estado_id;
	
	public Date fecha_cancelado; 
	
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

	public static Finder<Long,CuentaBancaria> find = new Finder<Long,CuentaBancaria>(Long.class, CuentaBancaria.class);
	
	public List<CuentaBancaria> getDataSuggest(String input,Integer limit){
		List<CuentaBancaria> l = find
				.fetch("proveedor")  
    			.fetch("sucursal_banco")  
    			.fetch("banco") 
    			.fetch("estado") 
    			.where()
                .or(Ebean.getExpressionFactory().ilike("proveedor.nombre", "%" + input + "%"),  Ebean.getExpressionFactory().ilike("numero_cuenta", "%" + input + "%")).setMaxRows(limit).orderBy("nombre")
			    .findList();  
		return l;
	}
	
	public static Pagination<CuentaBancaria> page(String nombreProveedor, 
												  String numeroCuenta,
												  String btnFiltro0,
												  String btnFiltro1,
												  String btnFiltro2,
												  String btnFiltro3) {    	
    	Pagination<CuentaBancaria> p = new Pagination<CuentaBancaria>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("proveedor.nombre");
    	
    	ExpressionList<CuentaBancaria> f = find
				   .fetch("proveedor")  
				   .fetch("sucursal_banco")  
				   .fetch("banco")  	
				   .where();

			if(!nombreProveedor.equals("")){
				f.ilike("proveedor.nombre", "%" + nombreProveedor + "%");
			}
			if(!numeroCuenta.equals("")){
				f.ilike("numero_cuenta", "%" + numeroCuenta + "%");
			}
			
			if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty()){
				f = f.disjunction();
				
				if(!btnFiltro0.isEmpty()){
					 f = f.eq("estado_id", Estado.CUENTA_BANCARIA_ESTADO_BORRADOR);
				}	
				if(!btnFiltro1.isEmpty()){
					 f = f.eq("estado_id", Estado.CUENTA_BANCARIA_ESTADO_ENCURSO);
				}	
				if(!btnFiltro2.isEmpty()){
					 f = f.eq("estado_id", Estado.CUENTA_BANCARIA_ESTADO_APROBADO);
				}	
				if(!btnFiltro3.isEmpty()){
					 f = f.eq("estado_id", Estado.CUENTA_BANCARIA_ESTADO_CANCELADO);
				}	
				
				f = f.endJunction();
			}	
			
    	p.setExpressionList(f);
    	return p;
    }
}
