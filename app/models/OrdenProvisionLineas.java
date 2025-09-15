 package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Query;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.annotation.Formula;
import com.avaje.ebean.annotation.Sql;


@Entity
@Sql
public class OrdenProvisionLineas  extends Model {

private static final long serialVersionUID = 1L;

	public Long orden_linea_id;
	@DecimalComa(value="")
	public BigDecimal cantidad;

	public BigDecimal precio;

	public BigDecimal totalRecepcionado;
	public BigDecimal totalAjustes;

	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public  Producto producto;
	public Long producto_id;
	public BigDecimal pendiente;
	public String udm;
	public String departamento;
	public BigDecimal recepcionado;
	public BigDecimal anulados;
	public Integer cantidadPacientes;


	public static Model.Finder<Integer,OrdenProvisionLineas> find = new Model.Finder<Integer,OrdenProvisionLineas>(Integer.class, OrdenProvisionLineas.class);

	public OrdenLinea getOrdenLinea() {
		return OrdenLinea.find.byId(orden_linea_id);
	}

	public BigDecimal getTotalRecepcionado() {
		if(totalRecepcionado == null)
			return new BigDecimal(0);
		return totalRecepcionado;
	}


	public BigDecimal getRecepcionado() {
		if(recepcionado == null)
			return new BigDecimal(0);
		return recepcionado;
	}

	public BigDecimal getAnulados() {
		if(anulados == null)
			return new BigDecimal(0);
		return anulados;
	}

	public BigDecimal getAnuladosMonto() {
		if(anulados == null)
			return new BigDecimal(0);
		return anulados.multiply(precio);
	}

	public BigDecimal getPendiente() {
		if(recepcionado == null)
			return cantidad;
		return cantidad.subtract(recepcionado);
	}

	public BigDecimal getTotalPendiente() {
		return getPendiente().multiply(precio);
	}


	public BigDecimal getTotal () {
		return cantidad.multiply(precio);
	}

	public static Query<OrdenProvisionLineas> getQuery (Long idOrdenCompra) {

/*
		String sql = " SELECT ol.id as orden_linea_id, ol.cantidad cantidad, ol.precio, p.id, p.nombre, SUM(r.cantidad) recepcionado, u.nombre as udm, ol.cantidad - SUM(r.cantidad) as pendiente, tc.totalcertificado from orden_lineas ol " +
					 " inner join productos p on p.id = ol.producto_id  " +
					 " left join (select linea_orden_id, COALESCE(sum(precio),0) totalcertificado from certificaciones_servicios cs group by linea_orden_id) as tc on tc.linea_orden_id = ol.id" +
					 " inner join udms u on u.id = ol.udm_id " +
					 " left join remitos_lineas r on r.linea_orden_id = ol.id  " +
					 " where ol.orden_id = " + idOrdenCompra +
					 " group by ol.id, p.id, p.nombre, u.nombre, ol.precio, totalcertificado ORDER BY p.nombre DESC";
*/



		String sql =
					 //" SELECT ol.id as orden_linea_id, CASE WHEN ola.cantidad IS NOT NULL THEN (ol.cantidad - ola.cantidad) ELSE ol.cantidad END as cantidad, SUM(ol.precio) precio, p.id, p.nombre, SUM(linea.cantidad) recepcionado, u.nombre as udm, ol.cantidad - SUM(linea.cantidad) as pendiente, sum(linea.precio) totalRecepcionado from orden_lineas ol "+
					 " SELECT o.orden_linea_id as orden_linea_id, cantidad, precio, id, nombre,departamento, recepcionado, udm, pendiente, "
					 + "o.totalRecepcionado totalRecepcionado, anulados,cantidad_pacientes FROM ( " +
					 "   SELECT ol.id as orden_linea_id, " +
					 "	 CASE WHEN ola.cantidad IS NOT NULL THEN (ol.cantidad - ola.cantidad) " +
					 "		  ELSE ol.cantidad " +
					 "		  END as cantidad, " +
					 //"	  SUM(ol.precio) as precio, p.id, p.nombre, " +

					 "	  (ol.precio) as precio, p.id, p.nombre,de.nombre as departamento, " +
					 "	  coalesce(SUM(linea.cantidad),0) recepcionado, " +
					 "	  u.nombre as udm, " +
					 "	  ((ol.cantidad - coalesce(SUM(linea.cantidad),0)) - coalesce(SUM(ola.cantidad),0)) as pendiente, " +
					 "	  coalesce(sum(linea.precio),0) as totalRecepcionado, "+
					 " 	  coalesce(sum(ola.cantidad),0) as anulados, "+
					 " 	  coalesce(sum(olc.cantidad),0) as cantidad_pacientes "+
					 " from orden_lineas ol  " +
					 " left join  "+
					 " (  "+
					 " select rec.orden_provision_id, SUM(rl.cantidad) cantidad, rl.linea_orden_id, ol.precio " +
					 " from recepciones rec inner join remitos rem on rec.id = rem.recepcion_id " +
					 " inner join remitos_lineas rl on rem.id = rl.remito_id " +
					 " inner join orden_lineas ol on ol.id = rl.linea_orden_id GROUP BY rec.orden_provision_id, " +
					 " rl.linea_orden_id, ol.precio "+
					 " union all "+
				     " select cs.orden_provision_id, SUM(csl.cantidad), csl.linea_orden_id, "+
					 //" ((SUM(csl.precio) - (SUM(csl.precio) * COALESCE(csl.descuento,0) / 100)) * csl.cantidad) precio "+
				     " sum(round( CAST (((csl.precio - (csl.precio * COALESCE(csl.descuento,0) / 100)) * csl.cantidad) as numeric),2)) precio "+
					 " from certificaciones_servicios cs  "+
					 " inner join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id " +
					 " where state_id = 42 "+
					 //" group by cs.orden_provision_id, csl.linea_orden_id, csl.descuento, csl.cantidad "+
					 " group by cs.orden_provision_id, csl.linea_orden_id "+
					 " ) as linea "+
					 " on ol.id = linea.linea_orden_id "+
					 " left join productos p on p.id = ol.producto_id "+
					 " left join departamentos de on de.id = ol.departamento_id "+
					 " left join udms u on u.id = ol.udm_id "+
					 " left join (select orden_linea_id, SUM(cantidad) cantidad from orden_lineas_anulaciones GROUP BY orden_linea_id union all "+
					 			  "select csl.linea_orden_id,sum(round(csl.cantidad,2)) cantidad " +
					 			  "from certificaciones_servicios cs " +
					 			  "inner join certificaciones_servicios_lineas csl on csl.certificaciones_servicio_id = cs.id " +
					 			  "where cs.state_id = 88  " +
					 			  "group by csl.linea_orden_id "+
					 " ) ola on ola.orden_linea_id = ol.id "+
					 " left join (select orden_linea_id, SUM(cantidad) cantidad from orden_linea_clientes GROUP BY orden_linea_id) olc on olc.orden_linea_id = ol.id "+
					 " where ol.orden_id = " + idOrdenCompra +
					 " group by ol.id, p.id, p.nombre,de.nombre, u.nombre, ola.cantidad, olc.cantidad ORDER BY p.nombre ASC ) as o ";



		RawSql rawSql = RawSqlBuilder.parse(sql)
				.columnMapping("id", "producto.id")
			    .columnMapping("nombre", "producto.nombre")

	      .create();

		return Ebean.find(OrdenProvisionLineas.class).setRawSql(rawSql).fetch("producto");
	}



	public static Pagination<OrdenProvisionLineas> getProductosRecepcionados(Long idOrdenCompra) {
    	Pagination<OrdenProvisionLineas> p = new Pagination<OrdenProvisionLineas>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("producto.nombre");

    	ExpressionList<OrdenProvisionLineas> e = getQuery(idOrdenCompra).where();

    	e.gt("recepcionado", 0);

		p.parcheCountAllFormula = true;
		p.setTotalRowCount(e.findList().size());



    	p.setExpressionList(e);

		return p;
	}


	public static Pagination<OrdenProvisionLineas> getLineas(Long idOrdenCompra) {
    	Pagination<OrdenProvisionLineas> p = new Pagination<OrdenProvisionLineas>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("producto.nombre");

    	ExpressionList<OrdenProvisionLineas> e = getQuery(idOrdenCompra).where();

		p.parcheCountAllFormula = true;
		p.setTotalRowCount(e.findList().size());

    	p.setExpressionList(e);

		return p;
	}


	public static Pagination<OrdenProvisionLineas> getProductosParaAgregar(Long idOrdenCompra, Long remito_id, String producto) {
    	Pagination<OrdenProvisionLineas> p = new Pagination<OrdenProvisionLineas>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("producto.nombre");

    	ExpressionList<OrdenProvisionLineas> e = getQuery(idOrdenCompra).where();



    	List<RemitoLinea> rl = RemitoLinea.find.select("linea_orden_id").fetch("lineaOrden").where().eq("remito_id", remito_id).findList();
    	List<Long> i = new ArrayList<>();
    	for (RemitoLinea linea : rl) {
			i.add(linea.linea_orden_id);
		}

    	e.not(Expr.in("orden_linea_id", i));

    	if(!producto.isEmpty())
    		e.ilike("producto.nombre", "%"+producto+"%");

    	//e.having().gt("ol.cantidad - SUM(COALESCE(linea.cantidad,0))", 0);
    	e.gt("(cantidad - recepcionado)", 0);

    	p.setExpressionList(e);
		p.parcheCountAllFormula = true;
		p.setTotalRowCount(e.findList().size());
		return p;
	}


	public static void recepcionarTodos(Long id_remito) throws Exception {

		Long idOrdenCompra = Remito.find.byId(id_remito).recepcion.ordenProvision.orden_compra_id;

    	ExpressionList<OrdenProvisionLineas> e = getQuery(idOrdenCompra).where();

    	List<RemitoLinea> rl = RemitoLinea.find.select("linea_orden_id").fetch("lineaOrden").where().eq("remito_id", id_remito).findList();
    	List<Long> i = new ArrayList<>();
    	for (RemitoLinea linea : rl) {
			i.add(linea.linea_orden_id);
		}

    	e.not(Expr.in("orden_linea_id", i));
    	e.gt("(cantidad - recepcionado)", 0);

    	System.out.println("-------------" + e.findList().size());

    	Ebean.beginTransaction();
		try {
			boolean f = false;

			List<SqlRow> sc = OrdenLinea.getCantidadDisponiblePorClientesPorOrden(idOrdenCompra);
			if(sc.size() > 0){
				f = true;
			}

	    	for (OrdenProvisionLineas l : e.findList()) {
	    		RemitoLinea linea = new RemitoLinea();
	    		linea.cantidad = l.getPendiente();
	    		linea.remito_id = id_remito;
	    		linea.linea_orden_id = l.orden_linea_id;
	    		linea.save();

	    		if(f){
	    			List<SqlRow> s = OrdenLinea.getCantidadDisponiblePorClientes(l.orden_linea_id);

	    			if(s.size() > 0){
	    				List<SqlRow> x = OrdenLinea.getCantidadDisponiblePorClientes(l.orden_linea_id);
			    		if(x.size() > 0){
			    			for(SqlRow xs : x){
			    				if(xs.getBigDecimal("cantidad") != null  && xs.getBigDecimal("cantidad").compareTo(BigDecimal.ZERO) > 0){
					    			RemitoLineaCliente rlc = new RemitoLineaCliente();
									rlc.cantidad = xs.getBigDecimal("cantidad");
									rlc.cliente_id = xs.getLong("cliente_id");
									rlc.remito_linea_id = linea.id;
									rlc.save();
			    				}
			    			}
			    		}
	    			}
	    		}
			}
	    	Ebean.commitTransaction();
		} catch (Exception ex){
			Ebean.rollbackTransaction();
			throw ex;
		}finally{
			Ebean.endTransaction();
		}

	}


	public static BigDecimal getCantidadMaxima(Long linea_id) {
		String sql = " select id, " +
					 " ol.cantidad - " +
					 " COALESCE((select SUM(cantidad) from orden_lineas_anulaciones  where orden_linea_id = ol.id GROUP BY orden_linea_id),0) - " +
					 " COALESCE((select SUM(rl.cantidad) from remitos_lineas rl where rl.linea_orden_id = ol.id),0) AS cantidadMaxima" +
					 " from orden_lineas ol " +
					 " where ol.id = " + linea_id;
		return Ebean.createSqlQuery(sql).findUnique().getBigDecimal("cantidadMaxima");
	}

	public static BigDecimal getCantidadDisponible(Long linea_id) {
		String sql = " select id, " +
					 " ol.cantidad - " +
					 " COALESCE((select SUM(cantidad) from orden_lineas_anulaciones  where orden_linea_id = ol.id GROUP BY orden_linea_id),0) - " +
					 " COALESCE((select SUM(rl.cantidad) from remitos_lineas rl where rl.linea_orden_id = ol.id),0) AS cantidadMaxima" +
					 " from orden_lineas ol " +
					 " where ol.id = " + linea_id;
		return Ebean.createSqlQuery(sql).findUnique().getBigDecimal("cantidadMaxima");
	}


	public static BigDecimal getCantidadDisponibleCertificaciones(Long linea_id) {
		String sql = " select id, " +
					 " ol.cantidad - " +
					 " COALESCE((select SUM(cantidad) from orden_lineas_anulaciones  where orden_linea_id = ol.id GROUP BY orden_linea_id),0) - " +
					 //" COALESCE((select SUM(rl.cantidad) from certificaciones_servicios_lineas rl inner join certificaciones_servicios cs on cs.id = rl.certificaciones_servicio_id where cs.state_id <> 88 AND rl.linea_orden_id = ol.id),0) AS cantidadMaxima" +
					 " COALESCE((select SUM(rl.cantidad) from certificaciones_servicios_lineas rl inner join certificaciones_servicios cs on cs.id = rl.certificaciones_servicio_id where rl.linea_orden_id = ol.id),0) AS cantidadMaxima" +
					 " from orden_lineas ol " +
					 " where ol.id = " + linea_id;
		return Ebean.createSqlQuery(sql).findUnique().getBigDecimal("cantidadMaxima");
	}
}
