package models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.velocity.tools.generic.MathTool;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Query;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;
import com.google.common.collect.Lists;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import models.auth.Permiso;
import models.informes.InformeTotalesPorOrden;
import play.Logger;
import play.Play;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.NumberUtils;
import utils.NumeroALetra;
import utils.pagination.Pagination;


@Entity
@Table(name = "ordenes_provision")
public class OrdenProvision  extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordenes_provision_id_seq")
	public Long id;

	@Required(message="Número requerido")
	public Integer numero;

	//@Formula(select = "_b${ta}.anulados", join = "left outer join (select sum(ola.cantidad * precio) anulados, ol.orden_id from orden_lineas_anulaciones ola join orden_lineas ol on ola.orden_linea_id = ol.id group by orden_id) as _b${ta} on _b${ta}.orden_id = ${ta}.orden_compra_id")
	@Formula(select = "_b${ta}.anulados", join = "left outer join (select sum(round(CAST(ola.cantidad * precio AS numeric),2)) anulados, ol.orden_id from orden_lineas_anulaciones ola join orden_lineas ol on ola.orden_linea_id = ol.id group by orden_id union all select sum(round(csl.precio * csl.cantidad,2)) anulados,op.orden_compra_id orden_id from certificaciones_servicios cs inner join ordenes_provision op on op.id = cs.orden_provision_id left join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id where cs.state_id = 88 group by op.orden_compra_id ) as _b${ta} on _b${ta}.orden_id = ${ta}.orden_compra_id")
	//@Formula(select = "_b${ta}.anulados", join = "left outer join (select sum(round(CAST(ola.cantidad * precio AS numeric),2)) anulados, ol.orden_id from orden_lineas_anulaciones ola join orden_lineas ol on ola.orden_linea_id = ol.id group by orden_id union all select sum(round(csl.precio * csl.cantidad,2)) anulados,op.orden_compra_id orden_id from certificaciones_servicios cs inner join ordenes_provision op on op.id = cs.orden_provision_id left join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id where cs.state_id = 88 and csl.id not in(select certificaciones_servicios_linea_id from certificaciones_servicios_linea_clientes) group by op.orden_compra_id ) as _b${ta} on _b${ta}.orden_id = ${ta}.orden_compra_id")
	public BigDecimal anulados;

	@ManyToOne
	@JoinColumn(name="ejercicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Ejercicio ejercicio;
	@Required(message="Ejercicio requerido")
	public Long ejercicio_id;

	@OneToMany
	@JoinColumn(name = "orden_provision_id")
	public Set<ActaRecepcion>  actas;

	@ManyToOne
	@JoinColumn(name="orden_compra_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden ordenCompra;

	@Required(message="Orden de compra requerido")
	public Long orden_compra_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fcierre;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date plazo_entrega;

	public Date create_date;

	//@Formula(select = "totalRecepciones", join = "left join (select orden_provision_id, round(sum(csl.precio),2) totalRecepciones from certificaciones_servicios cs left join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id group by orden_provision_id ) as _cs${ta} on _cs${ta}.orden_provision_id = ${ta}.id")
	//public BigDecimal totalRecepciones;

	/*@Formula(select = "totalAjustes", join = "left join (select round(SUM(cantidad * precio),2) as totalAjustes, orden_id from orden_lineas_ajustes GROUP BY orden_id) as ajustes${ta} on ajustes${ta}.orden_id = ${ta}.orden_compra_id")
	public BigDecimal totalAjustes;*/


	/*@Formula(select = "totalRecepcionado", join = "left join  (" +
			  " select sumaTotales.orden_provision_id, round(SUM(sumaTotales.totalRecepcionado),2) totalRecepcionado from (select orden_provision_id, round(sum(csl.precio * csl.cantidad),2) totalRecepcionado from certificaciones_servicios cs left join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id where cs.state_id = 42 group by orden_provision_id " +
			  "	union all " +
			  "	select orden_provision_id, round(sum(ol.precio * rl.cantidad),2) totalRecepcionado from recepciones rec inner join remitos rem on rec.id = rem.recepcion_id inner join remitos_lineas rl on rem.id = rl.remito_id inner join orden_lineas ol on ol.id = rl.linea_orden_id group by orden_provision_id"
			  + " union all "
			  + " select a.orden_provision_id, round(sum(la.precio * cantidad),2) totalRecepcionado from actas_ajustes aa inner join actas_recepcion a on a.id = aa.acta_id inner join orden_lineas_ajustes la on la.id = aa.ajuste_id WHERE la.producto_id <> ALL (ARRAY[40277, 40276, 30653]) group by orden_provision_id "
			  + " union all "
			  + " select a.orden_provision_id, round(sum(arl.precio * arl.cantidad),2) totalRecepcionado from actas_recepcion_lineas_ajustes arl inner join actas_recepcion a on a.id = arl.acta_id WHERE arl.producto_id <> ALL (ARRAY[40277, 40276, 30653]) group by a.orden_provision_id "
			  + ") as sumaTotales GROUP BY sumaTotales.orden_provision_id)  as _linea${ta} on _linea${ta}.orden_provision_id = ${ta}.id")
	public BigDecimal totalRecepcionado;
	@Formula(select = "totalRecepcionado", join = "left join  (" +
			  " select sumaTotales.orden_provision_id, round(SUM(sumaTotales.totalRecepcionado),2) totalRecepcionado from (select orden_provision_id, sum(round(csl.precio * csl.cantidad,2)) totalRecepcionado from certificaciones_servicios cs left join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id where cs.state_id = 42 group by orden_provision_id " +
			  "	union all " +
			  "	select orden_provision_id, round(sum(ol.precio * rl.cantidad),2) totalRecepcionado from recepciones rec inner join remitos rem on rec.id = rem.recepcion_id inner join remitos_lineas rl on rem.id = rl.remito_id inner join orden_lineas ol on ol.id = rl.linea_orden_id group by orden_provision_id"
			  + " union all "
			  + " select a.orden_provision_id, round(sum(la.precio * cantidad),2) totalRecepcionado from actas_ajustes aa inner join actas_recepcion a on a.id = aa.acta_id inner join orden_lineas_ajustes la on la.id = aa.ajuste_id group by orden_provision_id "
			  + " union all "
			  + " select a.orden_provision_id, round(sum(arl.precio * arl.cantidad),2) totalRecepcionado from actas_recepcion_lineas_ajustes arl inner join actas_recepcion a on a.id = arl.acta_id group by a.orden_provision_id "
			  + ") as sumaTotales GROUP BY sumaTotales.orden_provision_id)  as _linea${ta} on _linea${ta}.orden_provision_id = ${ta}.id")
	*/




	@ManyToOne
	@JoinColumn(name="orden_compra_id", referencedColumnName="orden_id", insertable=false, updatable=false)
	public InformeTotalesPorOrden totales;

	@Formula(select = "totalActas", join = "left join  (select orden_provision_id, round(sum(csl.precio * csl.cantidad),2) totalActas from certificaciones_servicios cs left join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id where cs.state_id = 42 group by orden_provision_id " +
			  "	union all " +
			  "	select orden_provision_id, round(sum(ol.precio * rl.cantidad),2) totalActas from recepciones rec inner join remitos rem on rec.id = rem.recepcion_id inner join remitos_lineas rl on rem.id = rl.remito_id inner join orden_lineas ol on ol.id = rl.linea_orden_id group by orden_provision_id) as _acta${ta} on _acta${ta}.orden_provision_id = ${ta}.id")
	public BigDecimal totalActas;

	public static Finder<Long,OrdenProvision> find = new Finder<Long,OrdenProvision>(Long.class, OrdenProvision.class);


	/*public BigDecimal getTotalAjustes() {
		if(totalAjustes == null)
			return new BigDecimal(0);
		return totalAjustes;
	}*/

	public BigDecimal getAnulados() {
		if(anulados == null)
			return new BigDecimal(0);
		return anulados;
	}

	public BigDecimal getTotalRecepcionado() {
		if(totales.totalRecepcionado == null)
			return new BigDecimal(0);
		return totales.totalRecepcionado;
	}



	public BigDecimal getPendiente() {
		BigDecimal tot = new java.math.BigDecimal(0);
		BigDecimal totalRec = new java.math.BigDecimal(0);
		BigDecimal ret = new java.math.BigDecimal(0);

		if(ordenCompra != null && ordenCompra.getTotalTotal() != null){
			tot = ordenCompra.getTotalTotal();
		}

		if(totales.totalRecepcionado != null){
			totalRec = totales.totalRecepcionado;
		}

		ret = tot.subtract(totalRec);

		return ret;
	}

	public String getPorcentajeEntregado(){
		BigDecimal tot = new java.math.BigDecimal(1);
		BigDecimal totalRec = new java.math.BigDecimal(0);
		BigDecimal porcentaje = new java.math.BigDecimal(0);
		BigDecimal cien = new java.math.BigDecimal(100);

		if(ordenCompra != null && ordenCompra.getTotalTotal() != null &&  ordenCompra.getTotalTotal().compareTo(java.math.BigDecimal.ZERO) != 0){
			tot = ordenCompra.getTotalTotal();
		}

		if(totales.totalRecepcionado != null && totales.totalRecepcionado.compareTo(java.math.BigDecimal.ZERO) != 0){
			totalRec = totales.totalRecepcionado;
		}

		porcentaje = (totalRec).multiply(cien).divide(tot, 2, java.math.RoundingMode.HALF_UP);

		return porcentaje.toString()+" %";
	}


	public Pagination<OrdenProvisionLineas> getLineas(Long idOrdenProvision) {
		OrdenProvisionLineas o = new OrdenProvisionLineas();
		return o.getLineas(idOrdenProvision);
	}

	public List<OrdenProvision> getDataSuggest(String input,Integer limit,boolean copia){

		ExpressionList<OrdenProvision> e= find.where();

		List<OrdenProvision> l = e.eq("numero", Integer.parseInt(input))
							 .setMaxRows(limit).orderBy("numero")
							 .findList();

		return l;
	}

	public String getOpEjercicio(){
		return numero != null ? ejercicio.nombre != null ? numero.toString() + " / " + ejercicio.nombre : "" : "";
	}

	public static Pagination<OrdenProvision> page(String numero,
												  String orden_compra,
												  String expediente_id,
												  String proveedor_id,
												  String con_acta,
												  String ejercicio,
												  String create_date_desde,
												  String create_date_hasta,
												  String fecha_op_desde,
												  String fecha_op_hasta,
												  String rubro,
												  String deposito,
												  String tipo_moneda,
												  String tipo_cuenta_id,
												  String emergencia
												  ) {
    	Pagination<OrdenProvision> p = new Pagination<OrdenProvision>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("create_date");

    	ExpressionList<OrdenProvision> e = find
    			.select("id, numero,  anulados, create_date")
    										   .fetch("totales", "totalOrden, totalRecepcionado")
    										   .fetch("ordenCompra", "id, tipo_moneda, deposito_id, orden_rubro_id, totalAjuste")
								    		   .fetch("ordenCompra.proveedor", "nombre")
											   .fetch("ordenCompra.expediente", "nombre,emergencia")
											   .fetch("ordenCompra.deposito", "nombre")
											   .fetch("ordenCompra.ordenRubro", "nombre")
											   .fetch("ejercicio", "nombre, id")
											   .fetch("ordenCompra.expediente.ejercicio", "nombre")
											   .fetch("ordenCompra.expediente.parent", "nombre")
											   .fetch("ordenCompra.tipoCuenta", "nombre, numero")
    										   .where();

    	if(!emergencia.isEmpty()){
    		if(emergencia.compareToIgnoreCase("SI") == 0){
    			e.eq("ordenCompra.expediente.emergencia", true);
    		}else{
    			e.eq("ordenCompra.expediente.emergencia", false);
    		}
    	}

    	if(!tipo_cuenta_id.isEmpty()){
			e.eq("ordenCompra.tipo_cuenta_id",Integer.parseInt(tipo_cuenta_id));
		}

    	if(!tipo_moneda.isEmpty()){
			e.isNotNull("ordenCompra.tipo_moneda");
		}

    	if(!numero.isEmpty()) {
    		e.eq("numero", new Integer(numero));
    	}

    	if(!orden_compra.isEmpty()) {
    		e.eq("ordenCompra.nombre", orden_compra);
    	}

    	if(!rubro.isEmpty()){
    		e.eq("ordenCompra.orden_rubro_id", Integer.parseInt(rubro));
    	}

    	if(!deposito.isEmpty()){
    		e.eq("ordenCompra.deposito_id", Integer.parseInt(deposito));
    	}

    	if(!fecha_op_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(fecha_op_desde, "dd/MM/yyyy");
    		e.ge("ordenCompra.fecha_provision", fpd);
    	}
		if(!fecha_op_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(fecha_op_hasta, "dd/MM/yyyy");
    		e.le("ordenCompra.fecha_provision", fph);
    	}

    	if(!expediente_id.isEmpty()) {
    		e.eq("ordenCompra.expediente_id", Integer.parseInt(expediente_id));
    	}

    	if(!ejercicio.isEmpty()) {
    		e.eq("ejercicio_id", Integer.parseInt(ejercicio));
    	}

    	if(!orden_compra.isEmpty()) {
    		e.eq("ordenCompra.nombre", orden_compra);
    	}

    	if(!proveedor_id.isEmpty()) {
    		e.eq("ordenCompra.proveedor_id", Integer.parseInt(proveedor_id));
    	}

    	if(!create_date_desde.isEmpty()){
    		Date fpd = DateUtils.formatDate(create_date_desde, "dd/MM/yyyy");
    		e.ge("create_date", fpd);
    	}
		if(!create_date_hasta.isEmpty()){
    		Date fph = DateUtils.formatDate(create_date_hasta, "dd/MM/yyyy");
    		e.le("create_date", fph);
    	}

    	if(!con_acta.isEmpty()) {

    		/*
    		if(con_acta.equals("0")) {
        		Query<ActaRecepcion> subQuery =
        			    Ebean.createQuery(ActaRecepcion.class)
        			        .select("orden_provision_id")
        			        .where().isNotNull("orden_provision_id").query();;
        			e.not(Expr.in("id", subQuery));
    		}

    		if(con_acta.equals("1")) {
        		Query<ActaRecepcion> subQuery =
        			    Ebean.createQuery(ActaRecepcion.class)
        			        .select("orden_provision_id")
        			        .where().isNotNull("orden_provision_id").query();
        			e.in("id", subQuery);
    		}

    			*/
    		if(con_acta.equals("0")) {
    			//e.raw("COALESCE(ROUND(totales.totalRecepcionado,2),0) != ROUND(totales.totalOrden,2) + COALESCE(ROUND(ordenCompra.totalAjuste,2),0)");
    			e.raw("COALESCE(ROUND(totales.totalRecepcionado,2),0) != ROUND(totales.totalOrden,2)  ");
    		} else if (con_acta.equals("1")) {
    			//e.raw("COALESCE(ROUND(totales.totalRecepcionado ,2),0)  = ROUND(totales.totalOrden,2) + COALESCE(ROUND(ordenCompra.totalAjuste,2),0)");
    			e.raw("COALESCE(ROUND(totales.totalRecepcionado ,2),0)  = ROUND(totales.totalOrden,2) ");
    		}


    	}

    	if(!Permiso.check("verTodoOrdenProvision")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("ordenCompra.deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("ordenCompra.deposito_id");
    		}
    	}



		p.parcheCountAllFormula = true;

    	if(p.parcheCountAllFormula)
    		p.setTotalRowCount(e.findList().size());

    	p.setExpressionList( e );
    	return p;
    }

	public boolean controlPermisoDeposito() {
		boolean r = true;

		if(!Permiso.check("verTodoOrdenProvision")){

			if(ordenCompra == null) {
				OrdenProvision op = OrdenProvision.find.byId(id);
				ordenCompra = op.ordenCompra;
			}

			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
				if(Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(ordenCompra.deposito_id) != 0) {
					r = false;
				}
			}else {
				r = false;
			}
		}

		return r;
	}

	public static void  enableTriggers() {
		Connection conn = null;
	    PreparedStatement stmt = null;

		try {


		    conn = play.db.DB.getConnection();

			stmt = conn.prepareStatement("alter table certificaciones_servicios enable trigger actualiza_total_orden");
			stmt.execute();
		    stmt.close();

		    stmt = conn.prepareStatement("alter table certificaciones_servicios_lineas enable trigger actualiza_total_orden");
		    stmt.execute();
		    stmt.close();

		    stmt = conn.prepareStatement("alter table orden_lineas_ajustes enable trigger actualiza_total_orden");
		    stmt.execute();
		    stmt.close();

		    stmt = conn.prepareStatement("alter table orden_lineas_ajustes enable trigger after_insert_update_delete");
		    stmt.execute();
		    stmt.close();


		    stmt = conn.prepareStatement("alter table ordenes enable trigger actualiza_total_orden");
		    stmt.execute();
		    stmt.close();

		    stmt = conn.prepareStatement("select actualiza_totales_ordenes_ordenes(null)");
		    stmt.execute();
		    stmt.close();

		    stmt = conn.prepareStatement("select actualiza_totales_ordenes_recepcionados(null)");
		    stmt.execute();
		    stmt.close();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (stmt != null)
		          try {
		            stmt.close();
		          } catch (Exception e) {
		          }

		        if (conn != null)
		          try {
		            conn.close();
		          } catch (Exception e) {
		          }
		}
	}

	public static File getArchivoReporteOrdenProvision(File archivo,boolean sinMonto,Orden o,DireccionProveedor dp,Proveedor pr) throws IOException, XDocReportException {

		InputStream in = Play.application().resourceAsStream("resources/reportes/patrimonio/ordenesProvision/orden-provision2.odt");
		if(sinMonto){
			in = Play.application().resourceAsStream("resources/reportes/patrimonio/ordenesProvision/orden-provision-sinmontos.odt");
		}
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

		//OrdenProvision op = OrdenProvision.find.byId(idOrdenProvision);

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE orden_lineas SET departamento_id = 147 WHERE orden_id = :orden_id AND departamento_id is null ");
		update.setParameter("orden_id",o.id);
		update.execute();



		FieldsMetadata metadata = report.createFieldsMetadata();
		metadata.addFieldAsTextStyling("saltoLinea", SyntaxKind.Html);
		metadata.addFieldAsTextStyling("notas", SyntaxKind.Html);
		metadata.addFieldAsTextStyling("textoDolar", SyntaxKind.Html);
		IContext context = report.createContext();


		context.put("math", new MathTool());
		context.put("numberUtils", new NumberUtils());
		context.put("expediente", o.expediente.getInstitucionExpedienteEjercicio());
		context.put("numeroOP",(o.numero_orden_provision != null)?o.numero_orden_provision: "");
		context.put("fechaOP", (o.fecha_provision != null)?DateUtils.formatDate(o.fecha_provision): "");


		context.put("proveedorNombre", pr.nombre);
		context.put("proveedorCuit", pr.cuit);



		String dire = dp.calle;
		dire += " "+dp.numero;

		dire += (dp.localidad != null)?" - "+dp.localidad.nombre:" ";
		dire += (dp.zip != null)?" ("+dp.zip+")":" ";
		dire += (dp.localidad != null && dp.localidad.provincia!= null)?" - "+dp.localidad.provincia.nombre:" ";
		dire += (dp.localidad != null && dp.localidad.provincia!= null && dp.localidad.provincia.pais!= null)?" - "+dp.localidad.provincia.pais.nombre:" ";

		context.put("proveedorDireccion", dire);
		context.put("proveedorTelefono", (dp.telefono != null)?dp.telefono:"");
		context.put("proveedorFax", (dp.fax != null)?dp.fax:"");
		context.put("proveedorMail", (dp.email != null)?dp.email:"");


		String plazo = "20 días";

		String notas = "* Se informa que vencido el plazo de entrega se procedera a la ANULACION AUTOMATICA de los renglones no entregados, y se dara por cerrada la ORDEN DE PROVISION.<br />";
		if(o.orden_rubro_id != null){
			if(o.orden_rubro_id == 6){
				plazo = "Segun fecha de cirugía programada. A confirmar.";
				notas += "* Se solicita asistencia tecnica obligatoria en quirofano.<br />";
			}
			if(o.orden_rubro_id == 2){
				plazo = "Segun fecha de turno programado. A confirmar.";
				notas = "* Segun certificacion de servicios.<br />";
			}
			if(o.orden_rubro_id == 4){
				notas += "* LA ENTREGA DEBE REALIZARSE EN 2 PERIODOS CORRELATIVOS E IGUALES DE 30 DIAS; O CUANDO EL SERVICIO DE FARMACIA O JEFE DEL SERVICIO LO ESTIME CONVENIENTE, COMENZANDO EL MISMO A LA FECHA DE LA ORDEN DE PROVISION. (DICHA ENTREGAS NO SON EXCLUYENTES, Y PUEDEN SER MODIFICADAS DE ACUERDO A LAS NECESIDADES Y URGENCIAS QUE SE PRESENTEN).<br />";
				notas += "* PARA EL CASO DE LOS MEDICAMENTOS Y DESCARTABLES DEBEN ESTAR EN PERFECTAS CONDICIONES DE PRESENTACION Y EMBALAJE.<br />";
				notas += "* EL VENCIMIENTO DE LOS MEDICAMENTOS Y DESCARTABLES DEBEN SER MAYOR A 1 AÑO.<br />";
				notas += "* RESPETAR LAS MARCAS COTIZADAS Y SUGERIDAS POR EL SERVICIO DE FARMACIA.<br />";
				notas += "* NO SE RECIBIRAN MEDICAMENTOS, DESCARTABLES E INSUMOS QUE NO POSEAN AUTORIZACION VIGENTE A LA FECHA DE ENTREGA DE LA A.T.M.A.T.<br />";
			}

			if(o.tipo_moneda != null) {
				notas = "* Se considerará que al momento del pago se tomará el tipo de cambio vendedor del Banco Nación Argentina a la fecha del cierre de las operaciones del día anterior a la fecha de autorización al pago.<br/>";
			}
		}
		context.put("notas", notas);
		if(o.plazo_entrega != null && !o.plazo_entrega.isEmpty()){
			plazo = o.plazo_entrega;
		}

		context.put("plazoEntrega", plazo);

		String direccionEntrega = "Av. Marconi 3736 - Posadas Misiones";
		if(o.deposito.direccion != null){
			direccionEntrega = o.deposito.direccion;
		}
		context.put("direccionEntrega", direccionEntrega);

		String desc =  (o.descripcion != null && !o.descripcion.isEmpty())?"- "+o.descripcion+"<br />":"";
		String textoDolar = desc;
		if(o.cot_dolar != null && o.cot_dolar.compareTo(BigDecimal.ZERO) > 0) {

			TipoMoneda tm = TipoMoneda.find.byId(o.tipo_moneda.longValue());

			textoDolar = "EQUIVALENTE A "+tm.titulo+" "+utils.NumberUtils.moneda(o.getTotalDolar(), o.tipo_moneda)+". TIPO DE CAMBIO VENDEDOR BANCO NACION "+tm.signo+" 1 = "+utils.NumberUtils.moneda(o.cot_dolar);
		}

		context.put("textoDolar", textoDolar);
		String totalLetras = new NumeroALetra().convertNumberToLetterSinPesos(o.total.setScale(2, RoundingMode.HALF_DOWN).toString());
		//String totalLetras = new NumeroALetra().convertNumberToLetterSinPesos("14999040");


		context.put("totalLetras", totalLetras);

		//List<OrdenLinea> lineas = o.ordenLinea;

		List<OrdenLinea> lineas = OrdenLinea.find.where().eq("orden_id", o.id).orderBy("producto.nombre ASC").findList();
		int sizeLineas = lineas.size();

		//lineas = lineas.subList(0,45);

		if(sizeLineas <= 11){
			//Es decir si tiene menos o igual a 10 lineas hago esto
			context.put("menorContadorLineas",true);
			List<OrdenLinea> firtsLineas = lineas.subList(0, lineas.size());
			context.put("contenedorfirtsLineas", lineas);
		}else{
			//Es decir si tiene mas a 10 lineas hago esto
			context.put("menorContadorLineas",false);
			List<OrdenLinea> firtsLineas = lineas.subList(0, 11);
			context.put("contenedorfirtsLineas", firtsLineas);

			List<OrdenLinea> nextLineas = lineas.subList(11,  lineas.size());
			List<List<OrdenLinea>> contenedorNextLineas = Lists.partition(nextLineas, 20);

			context.put("cnl", contenedorNextLineas);
		}

		Integer x= 1;
		List<Map<String,String>> pacientes = new ArrayList<Map<String,String>>();
		for(OrdenLinea lo : lineas ){

			for(OrdenLineaCliente oc :lo.ordenLineaCliente){
				Map<String,String> hs = new HashMap<String,String>();
				//Logger.debug("aaaaaaaaaa"+oc.cliente.nombre);
				hs.put("nLinea",x.toString());
				String ob = (oc.observacion != null)?oc.observacion:"";
				hs.put("obse",ob);
				hs.put("cantidad",oc.cantidad.toString());
				hs.put("nombre",oc.cliente.nombre);
				String refe = (oc.cliente.id_paciente_rismi == null)?(oc.cliente.referencia == null)?"":oc.cliente.referencia:oc.cliente.id_paciente_rismi;
				hs.put("referencia",refe);
				hs.put("producto",lo.producto.nombre);
				pacientes.add(hs);
			}
			x++;
		}

		context.put("pacientes", pacientes);

		OutputStream out = new FileOutputStream(archivo);
        report.process(context, out);

		return archivo;
	}
}
