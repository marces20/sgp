package models;

import java.text.SimpleDateFormat;
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
import utils.ArrayUtils;
import utils.pagination.Pagination;

@Entity 
@Table(name = "ejercicios")
public class Ejercicio extends Model{
	
	public static Long[] PERIMIDOS = {new Long(1),new Long(2),new Long(3),new Long(4),new Long(5),new Long(6),new Long(7),new Long(8)};
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ejercicios_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;
	public String code;
	public String estado;
	public Date date_start; 
	public Date date_stop; 
	
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
	
	public String getNombreParaTapa(){
		return nombre.substring(2);
	}
	
	public static Finder<Long,Ejercicio> find = new Finder<Long,Ejercicio>(Long.class, Ejercicio.class);
	
	public List<Ejercicio> getDataSuggest(String input,Integer limit){
		List<Ejercicio> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("id desc")
			    .findList();  
		
		return l;
	}
	
	public static List<Ejercicio> getEjercicios(){
		return find.orderBy("id desc").findList();
	}
	
	public static Ejercicio getEjercicioByFecha(Date fecha){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		return find.where().eq("nombre",simpleDateFormat.format(fecha)).orderBy("id desc").findUnique();
	}
	
	public static boolean isPerimido(Long id) {
		
		return ArrayUtils.contains(Ejercicio.PERIMIDOS,id);		
		 
	}
	
	public static Pagination<Ejercicio> page(String nombre) {    	
    	Pagination<Ejercicio> p = new Pagination<Ejercicio>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
}
