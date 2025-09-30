package models;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.Logger;
import play.cache.Cache;
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

	public static ArrayList<Date> getFeriados(){
		ArrayList<Date> feriadosList = null;
		if(Cache.get("feriado") == null) {

			List<Feriado> f = Feriado.find.findList();
			feriadosList = new ArrayList<>();
			for(Feriado fx :f) {
				feriadosList.add(fx.fecha);
			}
			Logger.debug("Feriados seteando Cache: "+feriadosList.toString());
			Cache.set("feriado", feriadosList, 86400);
		}else {

			feriadosList= (ArrayList<Date>) Cache.get("feriado");
			Logger.debug("Feriados desde Cache: "+feriadosList.toString());
		}

		return feriadosList;
	}

}
