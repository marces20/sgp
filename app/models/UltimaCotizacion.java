package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "ultimas_cotizaciones")
public class UltimaCotizacion extends Model{
	 
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ultimas_cotizaciones_id_seq")
	public Long id; 
	
	@DecimalComa(value="")
	@Required(message="Requiere cotizacion")
	public BigDecimal cotizacion;
	
	@Required(message="Requiere cotizacion")
	public Integer tipo_moneda;
	
	@Required(message="Requiere fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha; 
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	
	@ManyToOne
	@JoinColumn(name="ejercicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Ejercicio ejercicio;
	public Long ejercicio_id;
	
	public static String getMoneda(Integer tipo) {
		
		if(tipo == null) {
			return "Pesos";
		}
		
		switch (tipo) {
		case 1:
			return "Dólar";
		case 2:
			return "Euro";
		default:
			return "Peso";
		}
	}
	
	public static Model.Finder<Long,UltimaCotizacion> find = new Finder<Long,UltimaCotizacion>(Long.class, UltimaCotizacion.class);
	
	public static Pagination<UltimaCotizacion> page(String fecha_desde,String fecha_hasta) {    	
	    	Pagination<UltimaCotizacion> p = new Pagination<UltimaCotizacion>();
	    	p.setOrderDefault("DESC");
	    	p.setSortByDefault("fecha");
	    	
	    	ExpressionList<UltimaCotizacion> e = find.where();
	    			
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
	
	public static BigDecimal getUltimaCotizacionAnualDelExpediente(Long idEjercicio,Long tipoMoneda) {
		Ejercicio e = Ejercicio.find.byId(idEjercicio);
		BigDecimal ret = new BigDecimal(1); 
		String sql = "SELECT cotizacion " + 
					 "FROM ultimas_cotizaciones " + 
					 "WHERE fecha BETWEEN :fdesde AND :fhasta AND tipo_moneda = :tipoMoneda " + 
					 "order by fecha DESC LIMIT 1";
		
		SqlRow s = Ebean.createSqlQuery(sql)
				   .setParameter("fdesde",e.date_start)
				   .setParameter("fhasta",e.date_stop)
				   .setParameter("tipoMoneda",tipoMoneda)
				   .findUnique();
		if(s.getBigDecimal("cotizacion") != null) {
			ret = s.getBigDecimal("cotizacion");
		}
		
		return ret;
	}	
}
