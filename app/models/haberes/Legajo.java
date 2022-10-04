package models.haberes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.Agente;
import models.Proveedor;

import com.avaje.ebean.ExpressionList;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity 
@Table(name = "legajos")
public class Legajo extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="legajos_id_seq")
	public Long id;	
	
	@Required(message="Debe escribir un numero")
	public Integer numero;
	
	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	@Required(message="Requiere un agente")
	public Long agente_id;
	
	public static Model.Finder<Long,Legajo> find = new Model.Finder<Long,Legajo>(Long.class, Legajo.class);
	
	public static Pagination<Legajo> page(String numero){

		Pagination<Legajo> p = new Pagination<Legajo>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("numero");
		
		ExpressionList<Legajo> e = find.fetch("agente").where();
		
		if(!numero.isEmpty()){
			e.eq("numero", Integer.parseInt(numero));
		}
		
		p.setExpressionList(e);
		return p;
	}
	
	public List<Legajo> getDataSuggest(String input,Integer limit){
		List<Legajo> l = find.where()
				.ilike("agente.nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}