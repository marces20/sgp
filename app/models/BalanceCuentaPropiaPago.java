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
@Table(name = "balance_cuentas_propia_pagos")
public class BalanceCuentaPropiaPago extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="balance_cuentas_propia_pago_id_seq")
	public Long id;
	
	@OneToOne
	@JoinColumn(name="balance_cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public BalanceCuentaPropia balanceCuentaPropia;
	@Required(message="Debe tener un balanceCuentaPropia asociado")
	public Long balance_cuenta_propia_id;
	
	@OneToOne
	@JoinColumn(name="pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public Pago pago;
	@Required(message="Debe tener un pago asociado")
	public Long pago_id;
	
	public static Model.Finder<Long,BalanceCuentaPropiaPago> find = new Finder<Long,BalanceCuentaPropiaPago>(Long.class, BalanceCuentaPropiaPago.class);
	
	public static BalanceCuentaPropiaPago insert(Long balance_cuenta_propia_id,Long pago_id) throws Exception{
		BalanceCuentaPropiaPago bcp = new BalanceCuentaPropiaPago();
		try {
			bcp.balance_cuenta_propia_id = balance_cuenta_propia_id;
			bcp.pago_id = pago_id;
			bcp.save();
		} catch (Exception e) {
			throw e;
		}	

		return bcp;
	}	
}
