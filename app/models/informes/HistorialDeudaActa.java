package models.informes;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "historial_deuda_actas")
public class HistorialDeudaActa extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="historial_deuda_actas_id_seq")
	public Long id;
	
	public Date fecha;
	public Long id_acta;
	public Long certificacion_id;
	public BigDecimal total_acta;
	public BigDecimal total_pagado;
	public BigDecimal total_deuda;
	public BigDecimal total_deuda_limite;
	public BigDecimal total_autorizado;
	String id_fake;
	public Boolean perimido ;
	
	public static Model.Finder<Long,HistorialDeudaActa> find = new Finder<Long,HistorialDeudaActa>(Long.class, HistorialDeudaActa.class);
	
	
}
