package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

 
@Entity 
@Table(name = "tipos_tareas")
public class TipoTarea extends Model{
	
	private static final long serialVersionUID = 1L;
	
	public static final Long MAIL_DEUDA_RA = (long)1;
	public static final Long MAIL_DEUDA_DESTACADOS = (long)2;
	public static final Long MAIL_DEUDA_OTROS = (long)3;
	public static final Long MAIL_PAGADO_NOENTREGADOS = (long)4;
		
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipos_tareas_id_seq")
	public Long id; 
	public String nombre; 
	
	public static Model.Finder<Long,TipoTarea> find = new Finder<Long,TipoTarea>(Long.class, TipoTarea.class);
	
	public List<TipoTarea> getDataSuggest(String input,Integer limit){
		List<TipoTarea> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
