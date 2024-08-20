package models.recupero;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import models.TipoComprobante;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_afip_movimientos_id_seq")
public class RecuperoAfipMovimiento extends Model {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_facturas_id_seq")
	public Long id;

	public String comprobante_id;

	@ManyToOne
	@JoinColumn(name="recupero_factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoFactura recuperoFactura;
	public Integer recupero_factura_id;

	@ManyToOne
	@JoinColumn(name="recupero_notacredito_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoNotaCredito recuperoNotaCredito;
	public Integer recupero_notacredito_id;

	@ManyToOne
	@JoinColumn(name="recupero_notadebito_id", referencedColumnName="id", insertable=false, updatable=false)
	public RecuperoNotaDebito recuperoNotaDebito;
	public Integer recupero_notadebito_id;

	@ManyToOne
	@JoinColumn(name="tipo_comprobante_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoComprobante tipoComprobante;
	public Integer tipo_comprobante_id;

	public String cae;
	public String tipo_movimiento;
	public String nota;

	public Date date_create;



	public RecuperoAfipMovimiento(String comprobante_id,Integer recupero_factura_id, Integer recupero_notacredito_id,Integer recupero_notadebito_id,Integer tipo_comprobante_id,String cae,String tipo_movimiento,String nota,Date date_create) {
		this.comprobante_id = comprobante_id;
		this.recupero_factura_id = recupero_factura_id;
		this.recupero_notacredito_id = recupero_notacredito_id;
		this.recupero_notadebito_id = recupero_notadebito_id;
		this.tipo_comprobante_id = tipo_comprobante_id;
		this.cae = cae;
		this.tipo_movimiento = tipo_movimiento;
		this.nota = nota;
		this.date_create = date_create;
	}

	public static Model.Finder<Long,RecuperoAfipMovimiento> find = new Finder<Long,RecuperoAfipMovimiento>(Long.class, RecuperoAfipMovimiento.class);

	public static Pagination<RecuperoAfipMovimiento> page(String puntoventa_id){
    	Pagination<RecuperoAfipMovimiento> p = new Pagination<RecuperoAfipMovimiento>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<RecuperoAfipMovimiento> e = find
				.fetch("recuperoFactura")
				.fetch("recuperoFactura.puntoVenta")
				.fetch("recuperoNotaCredito")
				.fetch("recuperoNotaCredito.puntoVenta")
				.fetch("recuperoNotaDebito")
				.fetch("recuperoNotaDebito.puntoVenta")
				.fetch("tipoComprobante")
				.where();

    	if(!puntoventa_id.isEmpty()) {
    		e.disjunction();
    		e.eq("recuperoFactura.puntoventa_id", Integer.parseInt(puntoventa_id));
    		e.eq("recuperoNotaCredito.puntoventa_id", Integer.parseInt(puntoventa_id));
    		e.eq("recuperoNotaDebito.puntoventa_id", Integer.parseInt(puntoventa_id));
    		e.endJunction();
    	}

    	if(p.parcheCountAllFormula)
    		p.setTotalRowCount(e.findList().size());

    	p.setExpressionList(e);
    	return p;
	}


}
