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

import com.avaje.ebean.ExpressionList;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;
@Entity 
@Table(name = "vista_auditoria")
public class Auditoria extends Model{
	private static final long serialVersionUID = 1L;
	
	@Id  
	public String id_fake;
	
	public Long id;
	
	@Required(message="Debe escribir un nombre")
	public String tabla;	
	
	public Date fecha;
	public String operacion;
	
	public Integer id_objeto;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario usuario; 
	
	public Integer usuario_id; 
	
	public String campo_antiguo;
	public String valor_antiguo;

	public String campo_actual;
	public String valor_actual;
	
	public static Model.Finder<Long,Auditoria> find = new Model.Finder<Long,Auditoria>(Long.class, Auditoria.class);
	
	
	public static Pagination<Auditoria> page(String tabla, String operacion, String usuario_id, String fecha_desde, String fecha_hasta) {    	
    	Pagination<Auditoria> p = new Pagination<Auditoria>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Auditoria> e = find.fetch("usuario").where();
    	
    	if(!tabla.isEmpty()){
    		e.eq("tabla", tabla);
    	}
    	
    	if(!operacion.isEmpty()){
    		e.eq("operacion", operacion);
    	}
    	
    	if(!usuario_id.isEmpty()){
    		e.eq("usuario_id", Integer.parseInt(usuario_id));
    	}
    	
		if(!fecha_desde.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		e.ge("fecha", fod);
    	}
		
		if(!fecha_hasta.isEmpty()){
    		Date foh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		e.le("fecha", foh);
    	}
    	
    	p.setExpressionList(e);
    	return p;
    }
	
	public static Map<String, String> getTablas() {
		Map<String, String> hm = new HashMap<String, String>();

		hm.put("agentes", "Agentes");
		hm.put("agente_familias", "Agente familia");
		hm.put("actas_recepcion", "Actas");
		hm.put("facturas", "Facturas");
		hm.put("ordenes", "Ordenes");
		hm.put("pagos", "Pagos");
		hm.put("expedientes", "Expedientes");
		hm.put("certificaciones", "certificaciones");
		hm.put("certificaciones_compras", "Cert. Compras");
		return hm;
	}
	
	public String getOperacion() {

		switch (operacion) {
		case "U":
			return "Modificación";
		case "I":
			return "Creación";
		case "D":
			return "Eliminación";
		default:
			return "";
		}
	}
	
	
}
