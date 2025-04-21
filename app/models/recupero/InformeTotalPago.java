package models.recupero;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import models.Cliente;
import models.ClienteTipo;
import models.Deposito;
import models.Expediente;
import models.Periodo;
import models.Usuario;
import models.auth.Permiso;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "informe_pagos_recupero")
public class InformeTotalPago extends Model {

	private static final long serialVersionUID = 1L;
	@Id
	public Long id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_pago;

	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;
	@Required(message="Debe tener un cliente asociado")
	public Long cliente_id;

	@ManyToOne
	@JoinColumn(name="periodo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo;
	public Integer periodo_id;

	@ManyToOne
	@JoinColumn(name="cliente_tipo_id", referencedColumnName="id", insertable=false, updatable=false)
	public ClienteTipo cliente_tipo;
	public Integer cliente_tipo_id;

	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	public Long deposito_id;

	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Integer expediente_id;
	public String numero;
	public String tipo_cliente;
	public String cliente_nombre;

	public String cuit;

	public static Model.Finder<Long,InformeTotalPago> find = new Model.Finder<Long,InformeTotalPago>(Long.class, InformeTotalPago.class);

	public static Pagination<InformeTotalPago> page(String cliente,
												String periodo,
												String expediente,
												String ejercicio,
												String cliente_tipo_id,
												String fecha_pago_desde,
												String fecha_pago_hasta,
												String fecha_factura_desde,
												String fecha_factura_hasta,
												String deposito,
												String certificicado_deuda_id) {


				Pagination<InformeTotalPago> p = new Pagination<InformeTotalPago>();
				p.setOrderDefault("ASC");
				p.setSortByDefault("fecha");

				ExpressionList<InformeTotalPago> e = find

				.fetch("deposito","nombre")
				.fetch("cliente","nombre").where();
				if(!cliente.isEmpty()) {
		    		e.eq("cliente_id", Integer.parseInt(cliente));
		    	}

		    	if(!certificicado_deuda_id.isEmpty()) {
		    		e.eq("recupero_certificado_deuda_id", Integer.parseInt(certificicado_deuda_id));
		    	}

		    	if(!cliente_tipo_id.isEmpty()){
		    		e.eq("cliente_tipo_id", Integer.parseInt(cliente_tipo_id));
		    	}

		    	if(!periodo.isEmpty()) {
		    		e.eq("periodo_id", Integer.parseInt(periodo));
		    	}

		    	if(!expediente.isEmpty()) {
		    		e.eq("expediente_id", Integer.parseInt(expediente));
		    	}

		    	if(!ejercicio.isEmpty()) {
		    		e.eq("ejercicio", Integer.parseInt(ejercicio));
		    	}

		    	if(!fecha_pago_desde.isEmpty()){
		    		Date ffd = DateUtils.formatDate(fecha_pago_desde, "dd/MM/yyyy");
		    		e.ge("fecha_pago", ffd);
		    	}

				if(!fecha_pago_hasta.isEmpty()){
		    		Date ffh = DateUtils.formatDate(fecha_pago_hasta, "dd/MM/yyyy");
		    		e.le("fecha_pago", ffh);
		    	}


		    	if(!fecha_factura_desde.isEmpty()){
		    		Date ffd = DateUtils.formatDate(fecha_factura_desde, "dd/MM/yyyy");
		    		e.ge("fecha", ffd);
		    	}

				if(!fecha_factura_hasta.isEmpty()){
		    		Date ffh = DateUtils.formatDate(fecha_factura_hasta, "dd/MM/yyyy");
		    		e.le("fecha", ffh);
		    	}

				if(!Permiso.check("verTodoRecupero")){
		    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
		    			e.eq("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
		    		}else{
		    			e.isNull("deposito_id");
		    		}
		    	}else {
		    		if(!deposito.isEmpty()) {
		        		e.eq("deposito_id", Integer.parseInt(deposito));
		        	}
		    	}

		    	p.setExpressionList( e );
		    	return p;

	}
}
