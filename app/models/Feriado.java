package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity
@Table(name = "feriados")
public class Feriado extends Model {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="feriados_id_seq")
    public Integer id;

	public Date fecha; 
	
	
	public static Model.Finder<Integer,Feriado> find = new Model.Finder<Integer,Feriado>(Integer.class, Feriado.class);
	
	public static Pagination<Feriado> page(String desde, String hasta) {    	
    	Pagination<Feriado> p = new Pagination<Feriado>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<Feriado> e = find.where();
    	
    	if(!desde.isEmpty()) {
    		e.eq("fecha", desde);
    	}
    	
    	if(!hasta.isEmpty()) {
    		e.eq("fecha", hasta);
    	}
    	
    	p.setExpressionList(e);
    	return p;
    }
	
}
