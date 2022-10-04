package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "facturas_actas")
public class FacturaActaAsosiada extends Model {

	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="facturas_actas_id_seq")
	public Long id;
	
	public Long factura_id;
	public Long acta_id;
	
	@ManyToOne
	@JoinColumn(name = "factura_id", insertable=false, updatable=false)
	public Factura factura;

	@ManyToOne
	@JoinColumn(name = "acta_id", insertable=false, updatable=false)
	public ActaRecepcion acta;
	
	
	public static Model.Finder<Long,FacturaActaAsosiada> find = new Finder<Long,FacturaActaAsosiada>(Long.class, FacturaActaAsosiada.class);
	
	
}
