package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.RequestVar;
import utils.pagination.Pagination;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import models.auth.Permiso;
@Entity
@Table(name = "recepciones")
public class Recepcion extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recepciones_id_seq")
	public Long id;

	@Required(message="El número es requerido")
	public String numero;

	@OneToOne
	@JoinColumn(name="orden_provision_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenProvision ordenProvision;

	@OneToMany
	@JoinColumn(name = "recepcion_id")
	public Set<Remito>  remito;

	@OneToOne
	@JoinColumn(name="acta_id", referencedColumnName="id", insertable=false, updatable=false)
	public ActaRecepcion acta;
	public Long acta_id;

	@Required(message="Orden de provisión requerido")
	public Long orden_provision_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date create_date;


	@Formula(select = "(select count(id) from remitos r where r.recepcion_id = ${ta}.id) as cantidadRemitos")
	public Integer cantidadRemitos;

	@Formula(select = "(select round(sum(rl.cantidad * ol.precio),2) from remitos r inner join remitos_lineas rl on r.id = rl.remito_id inner join orden_lineas ol on ol.id = rl.linea_orden_id where r.recepcion_id = ${ta}.id)")
	public BigDecimal total;

	public BigDecimal getTotal(){
		if (total == null)
			return new BigDecimal(0);
		return total;
	}

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	public Date write_date;

	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario;
	@Column(name="write_usuario_id")
	public Long write_usuario_id;

	public static Finder<Long,Recepcion> find = new Finder<Long,Recepcion>(Long.class, Recepcion.class);

	public static Pagination<Recepcion> page(String orden_provision,
											 String expediente, String proveedor_id,
											 String numero, String acta,
											 String remito,
											 String fecha_desde,
											 String fecha_hasta,
											 String responsable_id,
											 String acta_numero,
											 String sinActa,
											 String conActa,
											 String fecha_provision_desde,
											 String fecha_provision_hasta,
											 String profe,
											 String tipo_moneda,
											 String deposito_id,
											 String tipo_cuenta_id,
											 String orden_rubro_id
											 ) {
    	Pagination<Recepcion> p = new Pagination<Recepcion>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");



    	ExpressionList<Recepcion> e = find.select("id, numero, orden_provision_id, acta_id, total, create_date, cantidadRemitos")


    			  .fetch("ordenProvision", "numero")
    			  .fetch("ordenProvision.totales", "totalOrden, totalRecepcionado")
				  .fetch("acta", "numero")
				  .fetch("ordenProvision.ordenCompra", "tipo_moneda, fecha_provision, total, totalAjuste")
				  .fetch("ordenProvision.ordenCompra.proveedor", "nombre")

				  .fetch("ordenProvision.ordenCompra.deposito", "nombre")
				  .fetch("ordenProvision.ordenCompra.expediente", "nombre")
				  .fetch("ordenProvision.ordenCompra.expediente.ejercicio", "nombre")
				  .fetch("ordenProvision.ordenCompra.expediente.parent.ejercicio", "nombre")
				  .where();




    	if(!tipo_moneda.isEmpty()){
			e.isNotNull("ordenProvision.ordenCompra.tipo_moneda");
		}

    	if(!expediente.isEmpty()) {
    		e.eq("ordenProvision.ordenCompra.expediente_id", Integer.parseInt(expediente));
    	}

    	if(!tipo_cuenta_id.isEmpty()){
			e.eq("ordenProvision.ordenCompra.tipo_cuenta_id",Integer.parseInt(tipo_cuenta_id));
		}

    	if(!orden_rubro_id.isEmpty()){
			e.eq("ordenProvision.ordenCompra.orden_rubro_id",Integer.parseInt(orden_rubro_id));
		}

    	if(!deposito_id.isEmpty()){
			e.eq("ordenProvision.ordenCompra.deposito_id",Integer.parseInt(deposito_id));
		}

    	if(!profe.isEmpty()){
    		if(profe.compareToIgnoreCase("SI") == 0){
    			e.eq("ordenProvision.ordenCompra.profe", true);
    		}else{
    			e.eq("ordenProvision.ordenCompra.profe", false);
    		}
    	}

    	if(!orden_provision.isEmpty()) {
    		e.eq("ordenProvision.numero", Integer.parseInt(orden_provision));
    	}

    	if(!proveedor_id.isEmpty()) {
    		if(!proveedor_id.isEmpty()) {
        		if(proveedor_id.compareTo("14947") == 0) {
        			e.in("ordenProvision.ordenCompra.proveedor_id", Proveedor.getProveedoresDestacadosRA());
        		}else {
        			e.eq("ordenProvision.ordenCompra.proveedor_id", Integer.valueOf(proveedor_id));
        		}
            }
    		//e.eq("ordenProvision.ordenCompra.proveedor_id", Integer.parseInt(proveedor_id));
    	}

    	if(!numero.isEmpty()) {
    		e.eq("numero", numero);
    	}

    	if(!acta.isEmpty()) {
    		e.eq("acta.numero", acta);
    	}

    	if(!remito.isEmpty()) {
    		e.eq("remito.numero",remito);
    	}

		if(!fecha_desde.isEmpty()){
    		e.ge("create_date", DateUtils.formatDate(fecha_desde, "dd/MM/yyyy"));
    	}

		if(!fecha_hasta.isEmpty()){
    		e.le("create_date", DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy"));
    	}

		if(!fecha_provision_desde.isEmpty()){
			if(fecha_provision_desde.compareToIgnoreCase("00/00/0000") == 0){
				e.isNull("ordenProvision.ordenCompra.fecha_provision");
			}else{
	    		e.ge("ordenProvision.ordenCompra.fecha_provision", DateUtils.formatDate(fecha_provision_desde, "dd/MM/yyyy"));
			}
    	}

		if(!fecha_provision_hasta.isEmpty()){
    		e.le("ordenProvision.ordenCompra.fecha_provision", DateUtils.formatDate(fecha_provision_hasta, "dd/MM/yyyy"));
    	}

    	if(!responsable_id.isEmpty()) {
    		e.eq("create_usuario_id", Integer.parseInt(responsable_id));
    	}

    	if(!acta_numero.isEmpty()) {
    		e.eq("acta.numero", acta_numero);
    	}

    	if(!sinActa.isEmpty()) {
    		e.isNull("acta_id");
    	}

    	if(!conActa.isEmpty()) {
    		if(conActa.compareTo("si") == 0){
    			e.isNotNull("acta_id");
    		}else{
    			e.isNull("acta_id");
    		}
    	}

    	if(!Permiso.check("verTodoOrdenProvision")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("ordenProvision.ordenCompra.deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("ordenProvision.ordenCompra.deposito_id");
    		}
    	}

    	p.setExpressionList( e );
    	return p;
    }


	public static Pagination<Recepcion> getRecepcionados(String idOrdenProvision) {
    	Pagination<Recepcion> p = new Pagination<Recepcion>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Recepcion> e = find.fetch("remito", "remito.lineas").where();

    	if(!idOrdenProvision.isEmpty()) {
    		e.eq("orden_provision_id", Integer.parseInt(idOrdenProvision));
    	}

    	p.setExpressionList( e );
    	return p;
	}

	public static Pagination<Recepcion> getRecepcionesByOrdenDeProvision(Long idOrdenProvision) {
    	Pagination<Recepcion> p = new Pagination<Recepcion>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<Recepcion> e = find
    									  .where()
    									  .eq("orden_provision_id", idOrdenProvision);

		p.parcheCountAllFormula = true;
		p.setTotalRowCount(e.findList().size());

    	p.setExpressionList(e);

		return p;
	}

	public boolean controlPermisoDeposito() {
		boolean r = true;

		if(!Permiso.check("verTodoOrdenProvision")){

			if(ordenProvision == null) {
				OrdenProvision o = OrdenProvision.find.byId(orden_provision_id);
				ordenProvision = o;
			}
			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
				if(Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(ordenProvision.ordenCompra.deposito_id) != 0) {
					r = false;
				}
			}else {
				r = false;
			}
		}

		return r;
	}

}
