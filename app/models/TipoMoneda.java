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
@Table(name = "tipo_monedas")
public class TipoMoneda extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_moneda_id_seq")
	public Long id; 
	public String nombre;
	public String signo;
	public String titulo;
	
	public static Model.Finder<Long,TipoMoneda> find = new Finder<Long,TipoMoneda>(Long.class, TipoMoneda.class);
	
	public List<TipoMoneda> getDataSuggest(String input,Integer limit){
		List<TipoMoneda> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
