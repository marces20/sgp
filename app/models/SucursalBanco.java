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
@Entity 
@Table(name = "sucursal_bancos")
public class SucursalBanco extends Model{

	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sucursal_bancos_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;
	@ManyToOne
	public Banco banco;
	@Required(message="Debe escribir un codigo de sucursal")
	public String codigo;
	@ManyToOne
	public Localidad localidad;
	
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
	
	public static Finder<Long,SucursalBanco> find = new Finder<Long,SucursalBanco>(Long.class, SucursalBanco.class);
	
	public List<SucursalBanco> getDataSuggest(String input,Integer limit){
		List<SucursalBanco> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		return l;
	}
	
    public static Pagination<SucursalBanco> page(String nombre) {    	
    	Pagination<SucursalBanco> p = new Pagination<SucursalBanco>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
	
	public static List<SucursalBanco> getSucursales(int bancoId){
		return find.where().eq("banco_id", bancoId).findList();
	}
		
}
