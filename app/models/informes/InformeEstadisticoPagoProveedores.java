package models.informes;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import models.Cuenta;
import models.CuentaPropia;
import models.Deposito;
import models.Estado;
import models.Expediente;
import models.Factura;
import models.OrdenRubro;
import models.OrdenSubrubro;
import models.Periodo;
import models.Proveedor;
import models.TipoCuenta;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "informe_estadistico_pago_proveedores")
public class InformeEstadisticoPagoProveedores extends Model{

	@Id
	public Integer id;

	@ManyToOne
	@JoinColumn(name="factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public Factura factura;
	public Long factura_id;

	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	public Long proveedor_id;

	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	public Long deposito_id;

	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Long expediente_id;

	@ManyToOne
	@JoinColumn(name="rubro_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenRubro ordenRubro;
	public Long rubro_id;

	@ManyToOne
	@JoinColumn(name="subrubro_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenSubrubro ordenSubrubro;
	public Long subrubro_id;

	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	public Long periodo_id;

	public BigDecimal total;

	public BigDecimal total_factura;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_pago;

	@ManyToOne
	@JoinColumn(name="state_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="state_id")
	public Long estado_id;

	@ManyToOne
	@JoinColumn(name="cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaPropia cuentaPropia;
	public Integer cuenta_propia_id;

	@ManyToOne
	@JoinColumn(name="cuenta_impuesto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuentaImpuesto;
	public Integer cuenta_impuesto_id;


	//public boolean profe = false;;

	@ManyToOne
	@JoinColumn(name="tipo_cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoCuenta tipoCuenta;
	public Long tipo_cuenta_id;

	public String tipo;

	public static Model.Finder<Long,InformeEstadisticoPagoProveedores> find = new Finder<Long,InformeEstadisticoPagoProveedores>(Long.class, InformeEstadisticoPagoProveedores.class);

	public static Pagination<InformeEstadisticoPagoProveedores> page(String proveedor_id,
			  														 String expediente_id,
																	 String ejercicio_id,
																	 String rubro_id,
																	 String deposito_id,
																	 String fecha_pago_desde,
																	 String fecha_pago_hasta,
																	 String btnFiltro0,//borrador
																	 String btnFiltro1,//contabilizado
																 	 String btnFiltro2,//rendido
																	 String btnFiltro3,//entregado
																	 String btnFiltro4, //cancelado
																	 String cuenta,
																	 String profe,
																	 String impuesto,
																	 String tipo_cuenta_id){

		Pagination<InformeEstadisticoPagoProveedores> p = new Pagination<InformeEstadisticoPagoProveedores>();
		p.setOrderDefault("DESC");
		p.setSortByDefault("fecha_pago");

		ExpressionList<InformeEstadisticoPagoProveedores> e = find
				.fetch("deposito", "nombre")
				.fetch("ordenRubro", "nombre")
				.fetch("proveedor", "nombre")
				.fetch("expediente", "id, nombre")
    			.fetch("expediente.ejercicio", "nombre")
    			.fetch("estado", "id, nombre")
				.where();

		if(!fecha_pago_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_pago_desde, "dd/MM/yyyy");
    		e.ge("fecha_pago", fpd);
    	}

		if(!fecha_pago_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_pago_hasta, "dd/MM/yyyy");
    		e.le("fecha_pago", fph);
    	}

    	if(!deposito_id.isEmpty()){
    		e.eq("deposito_id", Integer.parseInt(deposito_id));
    	}

    	if(!ejercicio_id.isEmpty()){
    		e.eq("expediente.ejercicio_id", Integer.parseInt(ejercicio_id));
    	}

    	if(!expediente_id.isEmpty()){
    		e.eq("expediente_id", Integer.parseInt(expediente_id));
    	}

    	if(!rubro_id.isEmpty()){
    		e.eq("rubro_id", Integer.parseInt(rubro_id));
    	}

    	if(!proveedor_id.isEmpty()){
	    	if(proveedor_id.compareTo("14947") == 0) {
				e.in("proveedor_id", Proveedor.getProveedoresDestacadosRA());
			}else {
				e.eq("proveedor_id", Integer.parseInt(proveedor_id));
			}
    	}

    	if(!cuenta.isEmpty()){
    		if(cuenta.compareToIgnoreCase("PROFE") == 0){
    			e.eq("cuenta_propia_id", 1);
    		}else{
    			e.eq("cuenta_propia_id", 2);
    		}
    	}

    	if(!impuesto.isEmpty()){
    		if(impuesto.compareToIgnoreCase("si") == 0){
    			e.isNotNull("cuenta_impuesto_id");
    		}else{
    			e.isNull("cuenta_impuesto_id");
    		}
    	}


    	if(!profe.isEmpty()){
    		if(profe.compareToIgnoreCase("si") == 0){
    			e.eq("profe", true);
    		}else{
    			e = e.disjunction();
    			 e = e.eq("profe", false);
    			 e = e.isNull("profe");
    			e = e.endJunction();
    		}
    	}

    	if(!tipo_cuenta_id.isEmpty()){
    		e.eq("tipo_cuenta_id", Integer.parseInt(tipo_cuenta_id));
    	}

    	if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty() || !btnFiltro2.isEmpty() || !btnFiltro3.isEmpty() || !btnFiltro4.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_BORRADOR);
			}
			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_CONCILIADO);
			}
			if(!btnFiltro2.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_EN_CURSO);
			}
			if(!btnFiltro3.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_PAGADO);
			}
			if(!btnFiltro4.isEmpty()){
				 e = e.eq("estado_id", Estado.PAGO_ESTADO_CANCELADO);
			}

			e = e.endJunction();
		}

    	p.setExpressionList(e);
    	return p;
    }

}
