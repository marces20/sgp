package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "balance_pagos")
public class BalancePago extends Model{
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="balance_pago_id_seq")
	public Long id;
	
	@OneToOne
	@JoinColumn(name="balance_id", referencedColumnName="id", insertable=false, updatable=false)
	public Balance balance;
	@Required(message="Debe tener un balance asociado")
	public Long balance_id;
	
	@OneToOne
	@JoinColumn(name="pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public Pago pago;
	@Required(message="Debe tener un pago asociado")
	public Long pago_id;
	
	public static Model.Finder<Long,BalancePago> find = new Finder<Long,BalancePago>(Long.class, BalancePago.class);
	
	public static BalancePago insert(Long balance_id,Long pago_id) throws Exception{
		BalancePago bcp = new BalancePago();
		try {
			bcp.balance_id = balance_id;
			bcp.pago_id = pago_id;
			bcp.save();
		} catch (Exception e) {
			throw e;
		}	

		return bcp;
	}	
}
