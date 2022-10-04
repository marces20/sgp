package models;

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
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity 
@Table(name = "orden_349")
public class Orden349 extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orden_349_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden orden;
	@Required(message="Debe tener una orden asociada")
	public Long orden_id;
	
	@Required(message="Debe tener un nui")
	public String nui;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Debe tener una fecha vencimiento")
	public Date fecha_vencimiento; 
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	
	public static Finder<Long,Orden349> find = new Finder<Long,Orden349>(Long.class, Orden349.class);
	
	public static Pagination<Orden349> page(Long ordenId) {    	
    	Pagination<Orden349> p = new Pagination<Orden349>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("orden_id", ordenId));
    	return p;
	}
	
	public static Date getLastFecha(Integer orden_id) {
		Date r = null;
		String sql = " SELECT fecha_vencimiento FROM orden_349 f " +
					 " WHERE orden_id = :orden_id  order by id desc limit 1 ";
	
		SqlRow l = Ebean.createSqlQuery(sql).setParameter("orden_id", orden_id).findUnique();
		
		if(l != null) {
			r = l.getDate("fecha_vencimiento");
		}
		 
		return  r;
	}
	
	public static HashMap<String,Date> getLastOrden349(Integer orden_id) {
		
		HashMap<String,Date> r = new HashMap<String, Date>();
		
		String sql = " SELECT fecha_vencimiento as  fecha_vencimiento, nui as nui FROM orden_349 f " +
					 " WHERE orden_id = :orden_id  order by id desc limit 1 ";
	
		SqlRow l = Ebean.createSqlQuery(sql).setParameter("orden_id", orden_id).findUnique();
		
		if(l != null) {
			
			r.put(l.getString("nui"),l.getDate("fecha_vencimiento"));
			 
		}
		 
		return  r;
	}
}
