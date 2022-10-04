package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity 
@Table(name = "ordenes_pagos_circuitos_lineas")
public class OrdenPagoCircuitoLinea extends Model{
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordenes_pagos_circuitos_lineas_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="orden_pago_circuito_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPagoCircuito ordenPagoCircuito;
	@Required(message="Debe tener un orden pago circuito")
	public Long orden_pago_circuito_id;
	
	@ManyToOne
	@JoinColumn(name="pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public Pago pago;
	@Required(message="Debe tener un Pago asocidada")
	public Long pago_id;
	
	public static Model.Finder<Long,OrdenPagoCircuitoLinea> find = new Finder<Long,OrdenPagoCircuitoLinea>(Long.class, OrdenPagoCircuitoLinea.class);
	
	public static Pagination<OrdenPagoCircuitoLinea> page(Long ordenPagoCircuitoId) {    	
    	Pagination<OrdenPagoCircuitoLinea> p = new Pagination<OrdenPagoCircuitoLinea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("orden_pago_circuito_id", ordenPagoCircuitoId));
    	return p;
    }
	
}
