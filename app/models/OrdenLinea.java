package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;

import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "orden_lineas")
public class OrdenLinea extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orden_lineas_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm;
	@Required(message="Requiere udm")
	public Long udm_id;

	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden orden;
	@Required(message="Debe tener una orden asociada")
	public Long orden_id;


	@Required(message="Requiere precio")
	@DecimalComa(value="")
	public BigDecimal precio;

	@Required(message="Requiere cantidad")
	@DecimalComa(value="")
	public BigDecimal cantidad;
	@ManyToOne
	public Proveedor proveedor;
	public String nota;


	@ManyToOne
	@JoinColumn(name="producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public  Producto producto;
	@Required(message="Requiere producto")
	public Long producto_id;

	@OneToMany
	@JoinColumn(name = "orden_linea_id")
	public List<OrdenLineaAnulacion>  productoAnulado;

	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica;
	@Required(message="Requiere cuenta presupuestaria")
	public Long cuenta_analitica_id;
	public String observacion;

	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;
	public Long cliente_id;

	@ManyToOne
	@JoinColumn(name="departamento_id", referencedColumnName="id", insertable=false, updatable=false)
	public Departamento departamento;
	public Long departamento_id;

	public String laboratorio;

	public String nombre;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	public Date create_date;
	public Date write_date;

	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario;
	@Column(name="write_usuario_id")
	public Long write_usuario_id;

	@ManyToOne
	@JoinColumn(name="periodo_inicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo_inicio;
	public Long periodo_inicio_id;

	@ManyToOne
	@JoinColumn(name="periodo_fin_id", referencedColumnName="id", insertable=false, updatable=false)
	public Periodo periodo_fin;
	public Long periodo_fin_id;

	@OneToMany
	public List<OrdenLineaCliente> ordenLineaCliente;

	public static Model.Finder<Long,OrdenLinea> find = new Finder<Long,OrdenLinea>(Long.class, OrdenLinea.class);

    public static Pagination<OrdenLinea> page(Long ordenId) {
    	Pagination<OrdenLinea> p = new Pagination<OrdenLinea>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("id");

    	p.setExpressionList(
    			find
    			.fetch("producto")
    			.fetch("ordenLineaCliente.cliente", "id, nombre")
    			.where().eq("orden_id", ordenId));
    	return p;
    }


	public static Pagination<OrdenLinea> paraAgregarEnRemito(Long orden_compra_id, List<Integer> sinProducto) {
    	Pagination<OrdenLinea> p = new Pagination<OrdenLinea>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");


    	ExpressionList<OrdenLinea> e = find.where().eq("orden_id", orden_compra_id).not(Expr.in("producto_id",sinProducto));

    	p.setExpressionList( e );
    	return p;
	}

	public static List<SqlRow> getCantidadDisponiblePorClientes(Long idOrdenLinea) {


		String sql = "select c.id as cliente_id,c.id_paciente_rismi as idPacienteRismi, c.nombre as nombreCliente, s.orden_id, s.orden_linea_id, sum(s.cantidad - COALESCE(r.cantidad,0)) as cantidad "+
				"from clientes c "+
		"inner join ( "+
						"select  olc.orden_linea_id, ol.orden_id, olc.cliente_id, sum(olc.cantidad - COALESCE(a.cantidad,0)) cantidad from orden_linea_clientes olc "+
						"inner join orden_lineas ol on ol.id = olc.orden_linea_id "+
						"left join ( "+
							"select orden_linea_id, cliente_id, sum(olac.cantidad) cantidad from orden_linea_anulacion_clientes  olac "+
							"inner join orden_lineas_anulaciones ola on ola.id = olac.orden_linea_anulacion_id "+
							"group by cliente_id, ola.orden_linea_id  "+
						") a on a.orden_linea_id = olc.orden_linea_id and a.cliente_id = olc.cliente_id "+
						"group by olc.cliente_id, ol.orden_id, olc.orden_linea_id "+
					") s on c.id = s.cliente_id "+
		"left join ( "+
			"select linea_orden_id, cliente_id, sum(rlc.cantidad) cantidad from remitos_lineas rl "+
			"inner join remito_linea_clientes rlc on rl.id = rlc.remito_linea_id "+
			"group by cliente_id, linea_orden_id "+
		") r on r.linea_orden_id = s.orden_linea_id and r.cliente_id = s.cliente_id "+
		"where orden_linea_id = :idOrdenLineaCliente "+
		"group by s.orden_id, s.orden_linea_id, c.id,c.id_paciente_rismi, c.nombre ";

		List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("idOrdenLineaCliente",idOrdenLinea).findList();

		return s;
	}

	public static List<SqlRow> getCantidadDisponiblePorClientesPorOrden(Long idOrden) {


		String sql = "select c.id as cliente_id,c.id_paciente_rismi as idPacienteRismi, c.nombre as nombreCliente, s.orden_id, "+
						"s.orden_linea_id, sum(s.cantidad - COALESCE(r.cantidad,0)) as cantidad "+
										"from clientes c "+
								"inner join (  "+
												"select  olc.orden_linea_id, ol.orden_id, olc.cliente_id,  "+
												"sum(olc.cantidad - COALESCE(a.cantidad,0)) cantidad  "+
												"from orden_linea_clientes olc   "+
												"inner join orden_lineas ol on ol.id = olc.orden_linea_id   "+
												"left join (   "+
													"select orden_linea_id, cliente_id, sum(olac.cantidad) cantidad  "+
													"from orden_linea_anulacion_clientes  olac   "+
													"inner join orden_lineas_anulaciones ola on ola.id = olac.orden_linea_anulacion_id  "+
													"group by cliente_id, ola.orden_linea_id    "+
												") a on a.orden_linea_id = olc.orden_linea_id and a.cliente_id = olc.cliente_id  "+
												"group by olc.cliente_id, ol.orden_id, olc.orden_linea_id   "+
											") s on c.id = s.cliente_id  "+
								"left join (   "+
									"select linea_orden_id, cliente_id, sum(rlc.cantidad) cantidad  "+
									"from remitos_lineas rl   "+
									"inner join remito_linea_clientes rlc on rl.id = rlc.remito_linea_id  "+
									"group by cliente_id, linea_orden_id   "+
								") r on r.linea_orden_id = s.orden_linea_id and r.cliente_id = s.cliente_id  "+
								"where orden_id =  :orden_id "+
								"group by s.orden_id, s.orden_linea_id, c.id,c.id_paciente_rismi, c.nombre ";

		List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("orden_id",idOrden).findList();

		return s;
	}

	public static SqlRow getCantidadDisponiblePorLineaConClientes(Long idOrdenLinea) {

			String sql = "select s.orden_id, s.orden_linea_id, sum(s.cantidad - COALESCE(r.cantidad,0)) as cantidad_disponible "+
						"from clientes c "+
				"inner join ( "+
								"select  olc.orden_linea_id, ol.orden_id, olc.cliente_id, sum(olc.cantidad - COALESCE(a.cantidad,0)) cantidad from orden_linea_clientes olc "+
								"inner join orden_lineas ol on ol.id = olc.orden_linea_id "+
								"left join ( "+
									"select orden_linea_id, cliente_id, sum(olac.cantidad) cantidad from orden_linea_anulacion_clientes  olac "+
									"inner join orden_lineas_anulaciones ola on ola.id = olac.orden_linea_anulacion_id "+
									"group by cliente_id, ola.orden_linea_id "+
								") a on a.orden_linea_id = olc.orden_linea_id and a.cliente_id = olc.cliente_id "+
								"group by olc.cliente_id, ol.orden_id, olc.orden_linea_id "+
							") s on c.id = s.cliente_id "+
				"left join ( "+
					"select linea_orden_id, cliente_id, sum(rlc.cantidad) cantidad from remitos_lineas rl "+
					"inner join remito_linea_clientes rlc on rl.id = rlc.remito_linea_id "+
					"group by cliente_id, linea_orden_id "+
				") r on r.linea_orden_id = s.orden_linea_id and r.cliente_id = s.cliente_id "+
				"where orden_linea_id = :idOrdenLineaCliente "+
				"group by s.orden_id, s.orden_linea_id ";


		SqlRow s = Ebean.createSqlQuery(sql).setParameter("idOrdenLineaCliente",idOrdenLinea).findUnique();

		return s;
	}

	public static List<SqlRow> getCantidadDisponibleConCertificacionPorClientesPorOrdenLinea(Integer idOrdenLinea,boolean mayorACero) {


		String sql = "select c.id as cliente_id,c.id_paciente_rismi as idPacienteRismi, c.nombre as nombreCliente, s.orden_id, "+
						"s.orden_linea_id, sum(s.cantidad - COALESCE(r.cantidad,0)) as cantidad "+
										"from clientes c "+
								"inner join (  "+
												"select  olc.orden_linea_id, ol.orden_id, olc.cliente_id,  "+
												"sum(olc.cantidad - COALESCE(a.cantidad,0)) cantidad  "+
												"from orden_linea_clientes olc   "+
												"inner join orden_lineas ol on ol.id = olc.orden_linea_id   "+
												"left join (   "+
													"select orden_linea_id, cliente_id, sum(olac.cantidad) cantidad  "+
													"from orden_linea_anulacion_clientes  olac   "+
													"inner join orden_lineas_anulaciones ola on ola.id = olac.orden_linea_anulacion_id  "+
													"group by cliente_id, ola.orden_linea_id    "+
												") a on a.orden_linea_id = olc.orden_linea_id and a.cliente_id = olc.cliente_id  "+
												"group by olc.cliente_id, ol.orden_id, olc.orden_linea_id   "+
											") s on c.id = s.cliente_id  "+
								"left join (   "+
									"select linea_orden_id, cliente_id, sum(rlc.cantidad) cantidad "+
									"from certificaciones_servicios cs "+
									"inner join certificaciones_servicios_lineas rl on cs.id = rl.certificaciones_servicio_id "+
									"inner join certificaciones_servicios_linea_clientes rlc on rl.id = rlc.certificaciones_servicios_linea_id "+
									//"where state_id <> :state_id "+
									"group by cliente_id, linea_orden_id "+
								") r on r.linea_orden_id = s.orden_linea_id and r.cliente_id = s.cliente_id  "+
								"where orden_linea_id =  :orden_linea_id ";
							sql +="group by s.orden_id, s.orden_linea_id, c.id,c.id_paciente_rismi, c.nombre ";

							if(mayorACero) {
								sql +=" having sum(s.cantidad - COALESCE(r.cantidad,0)) > 0 ";
							}
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				//.setParameter("state_id",Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA)
						 .setParameter("orden_linea_id",idOrdenLinea).findList();

		return s;
	}

	public static SqlRow getCantidadDisponibleConCertificacionPorLineaConClientes(Integer idOrdenLinea) {

		String sql = "select s.orden_id, s.orden_linea_id, sum(s.cantidad - COALESCE(r.cantidad,0)) as cantidad_disponible "+
					"from clientes c "+
			"inner join ( "+
							"select  olc.orden_linea_id, ol.orden_id, olc.cliente_id, sum(olc.cantidad - COALESCE(a.cantidad,0)) cantidad from orden_linea_clientes olc "+
							"inner join orden_lineas ol on ol.id = olc.orden_linea_id "+
							"left join ( "+
								"select orden_linea_id, cliente_id, sum(olac.cantidad) cantidad from orden_linea_anulacion_clientes  olac "+
								"inner join orden_lineas_anulaciones ola on ola.id = olac.orden_linea_anulacion_id "+
								"group by cliente_id, ola.orden_linea_id "+
							") a on a.orden_linea_id = olc.orden_linea_id and a.cliente_id = olc.cliente_id "+
							"group by olc.cliente_id, ol.orden_id, olc.orden_linea_id "+
						") s on c.id = s.cliente_id "+
			"left join ( "+
				"select linea_orden_id, cliente_id, sum(rlc.cantidad) cantidad "+
				"from certificaciones_servicios cs "+
				"inner join certificaciones_servicios_lineas rl on cs.id = rl.certificaciones_servicio_id "+
				"inner join certificaciones_servicios_linea_clientes rlc on rl.id = rlc.certificaciones_servicios_linea_id "+
				//"where state_id <> :state_id "+
				"group by cliente_id, linea_orden_id "+
			") r on r.linea_orden_id = s.orden_linea_id and r.cliente_id = s.cliente_id "+
			"where orden_linea_id = :idOrdenLineaCliente "+
			"group by s.orden_id, s.orden_linea_id ";


		SqlRow s = Ebean.createSqlQuery(sql)
				//.setParameter("state_id",Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA)
				   .setParameter("idOrdenLineaCliente",idOrdenLinea).findUnique();

		return s;
	}

	public static BigDecimal getCantidadDisponibleConCertificacionPorLineaPorCliente(Long idOrdenLinea,Long idCliente) {

		BigDecimal ret = BigDecimal.ZERO;

		String sql = "select s.orden_id, s.orden_linea_id,c.id, sum(s.cantidad - COALESCE(r.cantidad,0)) as cantidad_disponible "+
					"from clientes c "+
			"inner join ( "+
							"select  olc.orden_linea_id, ol.orden_id, olc.cliente_id, sum(olc.cantidad - COALESCE(a.cantidad,0)) cantidad from orden_linea_clientes olc "+
							"inner join orden_lineas ol on ol.id = olc.orden_linea_id "+
							"left join ( "+
								"select orden_linea_id, cliente_id, sum(olac.cantidad) cantidad from orden_linea_anulacion_clientes  olac "+
								"inner join orden_lineas_anulaciones ola on ola.id = olac.orden_linea_anulacion_id "+
								"group by cliente_id, ola.orden_linea_id "+
							") a on a.orden_linea_id = olc.orden_linea_id and a.cliente_id = olc.cliente_id "+
							"group by olc.cliente_id, ol.orden_id, olc.orden_linea_id "+
						") s on c.id = s.cliente_id "+
			"left join ( "+
				"select linea_orden_id, cliente_id, sum(rlc.cantidad) cantidad "+
				"from certificaciones_servicios cs "+
				"inner join certificaciones_servicios_lineas rl on cs.id = rl.certificaciones_servicio_id "+
				"inner join certificaciones_servicios_linea_clientes rlc on rl.id = rlc.certificaciones_servicios_linea_id "+
				//"where state_id <> :state_id "+
				"group by cliente_id, linea_orden_id "+
			") r on r.linea_orden_id = s.orden_linea_id and r.cliente_id = s.cliente_id "+
			"where orden_linea_id = :idOrdenLinea AND c.id = :idCliente "+
			"group by s.orden_id, s.orden_linea_id,c.id ";


		SqlRow s = Ebean.createSqlQuery(sql)
				//.setParameter("state_id",Estado.CERTIFICACION_SERVICIO_NOCERTIFICADA)
				  .setParameter("idOrdenLinea",idOrdenLinea)
				  .setParameter("idCliente",idCliente).findUnique();

		Logger.debug("11111111111111111111111");
		if(s != null) {
			Logger.debug("2222222222222222");
			Logger.debug("xxxxxxxx "+s);
			ret = s.getBigDecimal("cantidad_disponible");
			Logger.debug("------------ "+ret);
		}
		Logger.debug("3333333333333");
		return ret;
	}

	public static List<SqlRow> getPrecioPorProductoConAjustes(Long idOrden) {

		String sql = "select sum(round(ol.precio, 2)) as precio_inicial, coalesce(sum(oec.total),0), "+
					 "round(sum(round(ol.precio, 2))+coalesce(sum(oec.total),0), 2) as sumatoria, "+
					 "ol.producto_id,ol.orden_id,p.nombre as producto "+
					 "from orden_lineas ol "+
					 "inner join productos p on p.id = ol.producto_id  "+
					 "LEFT JOIN ( SELECT sum(round(precio, 2)) as total,orden_id,producto_id  "+
					 "           FROM orden_lineas_ajustes where suma_precio = true "+
					 "          group by orden_id,producto_id) oec ON oec.orden_id = ol.orden_id and   oec.producto_id = ol.producto_id  "+
					 "where ol.orden_id = :idOrden  "+
					 "group by ol.producto_id,ol.orden_id, p.nombre ";

		List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("idOrden",idOrden).findList();

		return s;
	}


}
