package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "mis_pagos")
public class MiPago extends Model {
	
	public static final Integer TIPO_INTERNO = 1;
	public static final Integer TIPO_EXTERNO = 2;
	public static final Integer TIPO_PROVEEDORES = 3;

	public enum Tipo {
		AGENTE_CONTRATADO(1, "Agentes contratados"),
		AGENTE_PLANTA(2, "Agentes planta"), 
		PROVEEDORES_EXTERNOS(3, "Proveedores externos");
		private final String value;
		private final Integer key;
		Tipo(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public String value() {
			return value;
		}
		public Integer key() {
			return key;
		}
		
		public static String getValue(Integer key) {
			for (Tipo t : MiPago.Tipo.values()) {
				if(t.key().equals(key))
					return t.value();
			}
			return null;
		}
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mis_pagos_id_seq")
	public Long id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;
	
	public String numero_envio;
	public String numero_lote;
	public Integer tipo;	
	
	@Formula(select = "_b${ta}.cantidad", join = "inner join (select mis_pagos_id, count(mis_pagos_id) as cantidad from pagos group by mis_pagos_id) as _b${ta} on _b${ta}.mis_pagos_id = ${ta}.id")
	public String cantidad;
	
	@Formula(select = "_c${ta}.monto", join = "inner join (select SUM(COALESCE(pl.monto,0)-COALESCE(pl.monto_credito,0)) as monto, p.mis_pagos_id from pagos p left outer join pagos_lineas pl on p.id = pl.pago_id group by p.mis_pagos_id) as _c${ta} on _c${ta}.mis_pagos_id = ${ta}.id")
	public String monto;
	
	@OneToMany
	@JoinColumn(name="mis_pagos_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<Pago> pagos;
	
	public static Finder<Long,MiPago> find = new Finder<Long,MiPago>(Long.class, MiPago.class);
	
	public static Pagination<MiPago> page(String tipo, 
										  String fecha_desde,
										  String fecha_hasta,
										  String referencia,
										  String orden_pago) {    	
			
		Pagination<MiPago> p = new Pagination<MiPago>();
		p.setOrderDefault("DESC");
		p.setSortByDefault("id");
		
		ExpressionList<MiPago> e = find.where();
		
		if(!fecha_desde.isEmpty()){
			Date fpd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
			e.ge("fecha", fpd);
		}
		if(!fecha_hasta.isEmpty()){
			Date fph = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
			e.le("fecha", fph);
		}
		
		if(!tipo.isEmpty()){
			System.out.println("-----------------------------");
			e.eq("tipo", Integer.valueOf(tipo));
		}
		
		if(!referencia.isEmpty()){
			System.out.println("-----------------------------");
			e.eq("pagos.referencia", referencia);
		}
		
		if(!orden_pago.isEmpty()){
    		e.eq("pagos.ordenPago.id",Integer.parseInt(orden_pago) );
    	}

		p.setExpressionList(e);
		
		return p;
	}
}
