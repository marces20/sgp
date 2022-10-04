package utils.pagination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import play.cache.Cache;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.Http.RequestHeader;
import play.mvc.Http.Session;
import scala.Array;
import utils.StringUtils;


public class PaginadorFicha {
	private Session session = Http.Context.current().session();
	private String semilla;
	private List<String> listaValores = new ArrayList();
	private List<String> lista = new ArrayList();
	private Integer indexActual = -1;
	
	public PaginadorFicha (String semilla) {
		this.semilla = semilla;
		
		if(session.containsKey(semilla)) {
			lista = StringUtils.explode(session.get(semilla), ", ");
			System.out.println("exite --------" + session.get(semilla));
		} else {
			
		}
	}
	
	public void guardar() {
		System.out.println("................... "+StringUtils.implode(listaValores));
		session.put(this.semilla, StringUtils.implode(listaValores));
	}
	
	public void add(String id) {
		listaValores.add(id);
	}
	
	public List<String> getLista() {
		if (has())
		return lista = StringUtils.explode(session.get(semilla), ", ");
		return lista;
	}
	
	public void setActual(String id) {
		if (!has())
			return;
		
		for (String  s: getLista()) {
			System.out.println("++++++" + s +"++++");
		}
		indexActual = getLista().indexOf(id.toString());
	}
	
	public String next() {
		if(hasNext()) return getLista().get(indexActual + 1);
		return null;
	}
	
	public String prev() {
		return getLista().get(indexActual - 1);
	}
	
	public Integer posicionActual() {
		return indexActual + 1;
	}
	
	public Boolean hasNext() {
		Integer s = getLista().size();
		if(indexActual + 1 < s) return true;
		return false;
	}
	
	public Boolean hasPrev() {
		Integer s = getLista().size();
		if(indexActual > 0) return true;
		return false;
	}
	
	private Boolean has() {
		return (session.containsKey(semilla));
	}
	
	public String getSemilla() {
		return this.semilla;
	}
	
}

