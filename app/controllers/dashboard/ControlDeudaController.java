package controllers.dashboard;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.AutorizadoLinea;
import models.Estado;
import models.Factura;
import models.Orden;
import models.informes.InformeDeudaPorActa;
import models.informes.InformeDeudaPorActaMaterializada;
import models.informes.InformeDeudaProveedoresMaterializada;
import models.informes.InformeEstadisticoDeudaProveedores;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import controllers.Secured;
import controllers.auth.CheckPermiso;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.RequestVar;
import views.html.dashboard.controlDeuda.*;

@Security.Authenticated(Secured.class)
public class ControlDeudaController extends Controller {

	@CheckPermiso(key = "dashboardInformeDeudaPorActas")
	public static Result index() {
		return ok(index.render());
	}

	@CheckPermiso(key = "dashboardInformeDeudaPorActas")
	public static Result autorizadoDistintoDePagado() {


		/*String sql = "SELECT * FROM informe_deuda_actas WHERE total_autorizado <> total_pagado";
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();*/
		//actualizarVistaMaterializada ();

		//ExpressionList<InformeDeudaProveedoresMaterializada> e =InformeDeudaProveedoresMaterializada.find
		ExpressionList<InformeEstadisticoDeudaProveedores> e =InformeEstadisticoDeudaProveedores.find.select("tipo_moneda,numero_orden_provision,expediente,rubro,nombreProveedor,totalOrden,"
																				    			+ "totalAutorizado,totalPagado,totalDeuda,totalCompromiso,orden_provision_id,tipo_cuenta_id")
																				    			.fetch("ordenProvision", "orden_compra_id,numero")
																				    			.fetch("expedienteObj","emergencia,fecha,descripcion")
																				    			.fetch("tipoCuenta","nombre")
																				    			.fetch("deposito","nombre")
																				    			.fetch("proveedor","nombre")
												.where();

		e.raw("total_autorizado <> total_pagado");

		return ok(autorizadoDistintoDePagado.render(e.findList()));
	}

	@CheckPermiso(key = "dashboardInformeDeudaPorActas")
	public static Result getAutorizadoDistintoDePagado() {


		//actualizarVistaMaterializada ();
		ExpressionList<InformeEstadisticoDeudaProveedores> e =InformeEstadisticoDeudaProveedores.find.select("tipo_moneda,numero_orden_provision,expediente,rubro,nombreProveedor,totalOrden,"
    			+ "totalAutorizado,totalPagado,totalDeuda,totalCompromiso,orden_provision_id,tipo_cuenta_id")
    			.fetch("ordenProvision", "orden_compra_id,numero")
    			.fetch("expedienteObj","emergencia,fecha,descripcion")
    			.fetch("tipoCuenta","nombre")
    			.fetch("deposito","nombre")
    			.fetch("proveedor","nombre").where();

		e = e.ne("rubro_id",8);
		e = e.ne("rubro_id",10);
    	e = e.raw("total_autorizado <> total_pagado");

		return ok(listaAutorizadoDistintoPagado.render(e.findList()));
	}

	@CheckPermiso(key = "controlDeudaMonedaExtranjera")
	public static Result controlDeudaMonedaExtranjera() {

		List<InformeDeudaProveedoresMaterializada> e =  null;
		List<AutorizadoLinea> al = new ArrayList<AutorizadoLinea>();
		List<AutorizadoLinea> alHijo = new ArrayList<AutorizadoLinea>();
		List<Factura> f = new ArrayList<Factura>();
		List<Factura> fh = new ArrayList<Factura>();
		Orden o = new Orden();
		List<SqlRow> rowActas = new ArrayList<SqlRow>();

		BigDecimal ultimaCotizacion = new BigDecimal(0);

		//actualizarVistaMaterializada ();

		if(!RequestVar.get("orden_id").isEmpty()){
			o = Orden.find.byId(new Long(RequestVar.get("orden_id")));
			if(o.cot_dolar != null && o.tipo_moneda != null){

				//e = InformeDeudaProveedoresMaterializada.find.where().eq("orden_id", Integer.parseInt(RequestVar.get("orden_id"))).findList();

				al = AutorizadoLinea.find.where()
									.eq("orden_id",Integer.parseInt(RequestVar.get("orden_id")))
									.orderBy("monto asc").findList();

				f = Factura.find.where()
					.eq("orden_id",Integer.parseInt(RequestVar.get("orden_id")))
					.eq("estado_id",Estado.FACTURA_ESTADO_APROBADO ).orderBy("base").findList();

				String sql = "SELECT a_2.orden_compra_id AS orden_id,COALESCE(a_2.total,0) AS total,COALESCE(a_2.total_dolar,0) AS total_dolar,a_2.cotizacion as cotizacion "+
				"FROM vista_actas_totales a_2 "+
				"WHERE a_2.state_id = 40 and a_2.orden_compra_id = :orden_id";
				SqlQuery sqlQuery = Ebean.createSqlQuery(sql).setParameter("orden_id", Integer.parseInt(RequestVar.get("orden_id")));
				rowActas = sqlQuery.findList();

				String sql2 = "SELECT cotizacion FROM ultimas_cotizaciones WHERE ultimas_cotizaciones.tipo_moneda = :tipo_moneda "+
							 "ORDER BY ultimas_cotizaciones.fecha DESC LIMIT 1 ";
				SqlQuery sqlQuery2 = Ebean.createSqlQuery(sql2).setParameter("tipo_moneda", o.tipo_moneda);
				ultimaCotizacion = sqlQuery2.findUnique().getBigDecimal("cotizacion");


				////HIJOOOOOOOOOOOOOOSSSSSSSSSSSSSSSS
				String sqloH = "SELECT * FROM ordenes_ejercicio_concluido WHERE orden_id = :orden_id";
				List<SqlRow> sqlQueryoH = Ebean.createSqlQuery(sqloH).setParameter("orden_id", o.id).findList();

				if(sqlQueryoH.size() > 0) {
					Logger.debug("22222222222222222 ");
					List<Integer> idsFacturasHijas = new ArrayList<Integer>();
					for(SqlRow sfh : sqlQueryoH) {

						Logger.debug("xxxxxxxxxxxxxxxxxxx "+sfh.getInteger("orden_hija"));
						idsFacturasHijas.add(sfh.getInteger("orden_hija"));
					}

					fh = Factura.find.where()
							.in("orden_id",idsFacturasHijas)
							.eq("estado_id",Estado.FACTURA_ESTADO_APROBADO ).orderBy("base").findList();

					alHijo = AutorizadoLinea.find.where()
							.in("orden_id",idsFacturasHijas)
							.orderBy("monto asc").findList();
				}
				////HIJOOOOOOOOOOOOOOSSSSSSSSSSSSSSSS




			}
    	}

		return ok(controlDeudaMonedaExtranjera.render(e,al,f,o,rowActas,ultimaCotizacion,form().bindFromRequest(),fh,alHijo));
	}

	private static void actualizarVistaMaterializada () {

		//Ebean.createSqlUpdate("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada").execute();
		Connection conn = play.db.DB.getConnection();
		try {
		    Statement stmt = conn.createStatement();
		    stmt.execute("REFRESH MATERIALIZED VIEW informe_estadistico_deuda_proveedores_matrializada;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
