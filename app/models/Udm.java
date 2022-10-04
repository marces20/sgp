package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model; 

@Entity 
@Table(name = "udms")
public class Udm extends Model{
	 
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="udms_id_seq")
	public Long id; 
	public String nombre;
	
	public static Model.Finder<Long,Udm> find = new Finder<Long,Udm>(Long.class, Udm.class);
	
	public List<Udm> getDataSuggest(String input,Integer limit){
		List<Udm> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
	
}
