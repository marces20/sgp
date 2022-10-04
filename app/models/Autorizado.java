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

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.annotation.Formula;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "autorizados")
public class Autorizado extends Model {
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="autorizados_id_seq")
	public Long id;
	
	public String nombre;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Requiere fecha")
	public Date fecha; 
	
	public Boolean profe;
	
	@ManyToOne
	@JoinColumn(name="tipo_cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoCuenta tipoCuenta;
	@Required(message="Tipo Cuenta requerido")
	public Long tipo_cuenta_id;
	
	@ManyToOne
	@JoinColumn(name="tipo_moneda_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoMoneda tipoMoneda;
	public Long tipo_moneda_id;
	
	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="estado_id")
	public Long estado_id;
	
	public String notas;
	public String descripcion;
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	
	@DecimalComa(value="")
	public BigDecimal cot_dolar;
	
	public Date create_date; 
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	@OneToMany
	public List<AutorizadoLinea> autorizadoLinea;
	
	@Formula(select = "_s${ta}.totalSinActas", join = "left outer join (select autorizado_id, round(sum(al.monto)::numeric,2) as totalSinActas from autorizado_lineas al group by autorizado_id) as _s${ta} on _s${ta}.autorizado_id = ${ta}.id")
	public BigDecimal totalSinActas; 
	
	//@Formula(select = "_c${ta}.total", join = "left outer join (select autorizado_id, round(sum(ala.monto)::numeric,2) as total from autorizado_lineas al inner join autorizado_linea_actas ala on al.id = ala.autorizado_linea_id group by autorizado_id) as _c${ta} on _c${ta}.autorizado_id = ${ta}.id")
	@Formula(select = "_c${ta}.total", join = "left outer join (select autorizado_id, round(sum(al.monto)::numeric,2) as total from autorizado_lineas al group by autorizado_id) as _c${ta} on _c${ta}.autorizado_id = ${ta}.id")
	public BigDecimal total;//Base
	public BigDecimal getTotal(){
		if (total == null){
			if(totalSinActas == null){
				return new BigDecimal(0);
			}else{
				return totalSinActas;
			}
		}
		return total;
	}
	
	public static Finder<Long,Autorizado> find = new Finder<Long,Autorizado>(Long.class, Autorizado.class);
	
	public static Pagination<Autorizado> page(String nombre,
											  String btnFiltro0,//borrador
											  String btnFiltro1,//aprobado
											  String btnFiltro2,//cancelado) 
											  String expediente_id,
											  String proveedor_id
											  ){
		Pagination<Autorizado> p = new Pagination<Autorizado>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("fecha");
    	
    	ExpressionList<Autorizado> e = find.fetch("estado").where();
    	
    	if(!nombre.isEmpty()){
    		e.ilike("nombre", "%" + nombre + "%");
    	}
    	
    	if(!expediente_id.isEmpty()){
    		e.in("autorizadoLinea.expediente_id", Integer.parseInt(expediente_id));
    	}
    	
    	if(!proveedor_id.isEmpty()){
    		e.in("autorizadoLinea.proveedor_id", Integer.parseInt(proveedor_id));
    	}
    	
    	if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("state_id", Estado.AUTORIZADO_ESTADO_BORRADOR);
			}	
			if(!btnFiltro1.isEmpty()){
				e = e.eq("state_id", Estado.AUTORIZADO_ESTADO_APROBADO);
			}
			if(!btnFiltro2.isEmpty()){
				e = e.eq("state_id", Estado.AUTORIZADO_ESTADO_CANCELADO);
			}
			
			
			e = e.endJunction();
		}	
    	
    	p.setExpressionList(e);
    	
    	return p;
    
	}
	
	public static List<SqlRow> getTotalPorProveedor(Long id) {
		
		String sql = "SELECT p.nombre as proveedor,SUM(monto) as monto FROM autorizados a "+
					"INNER JOIN autorizado_lineas al ON al.autorizado_id = a.id "+
					"INNER JOIN proveedores p ON p.id = al.proveedor_id "+
					"WHERE a.id = :id "+
					"GROUP BY al.proveedor_id,p.nombre "+
					"ORDER BY p.nombre";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("id",id)		
				.findList();
		
		return s;
	}
	
	public static List<SqlRow> getTotalPorRubro(Long id) {
		
		String sql = "SELECT oo.nombre as rubro,SUM(monto) as monto FROM autorizados a "+
					"INNER JOIN autorizado_lineas al ON al.autorizado_id = a.id "+
					"INNER JOIN ordenes o ON o.id = al.orden_id "+
					"INNER JOIN ordenes_rubros oo ON oo.id = o.orden_rubro_id "+
					"WHERE a.id = :id "+
					"GROUP BY oo.id,oo.nombre "+
					"ORDER BY oo.nombre";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("id",id)		
				.findList();
		
		return s;
	}
}