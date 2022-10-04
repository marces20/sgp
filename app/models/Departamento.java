package models;

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
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity 
@Table(name = "departamentos")
public class Departamento extends Model{
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="departamentos_id_seq")
	public Long id;
	
	@Required(message="Debe escribir un nombre")
	public String nombre;
	
	@Required(message="Debe escribir una sigla")
	public String sigla;
	
	public Integer manager;	
	
	public Boolean activo = false;
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Departamento parent_departamento;
	
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
	
	public static Finder<Long,Departamento> find = new Finder<Long,Departamento>(Long.class, Departamento.class);
	
	public List<Departamento> getDataSuggest(String input,Integer limit){
		List<Departamento> l = find.where()
				.ilike("nombre", "%"+input+"%")
				
				.setMaxRows(limit).orderBy("id")
			    .findList();  
		
		return l;
	}
	
	public static Pagination<Departamento> page(String nombre) {    	
    	Pagination<Departamento> p = new Pagination<Departamento>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
                .eq("activo",true)
	            );
    	return p;
    }
}
