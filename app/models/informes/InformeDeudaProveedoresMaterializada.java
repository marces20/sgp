package models.informes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import models.ActaRecepcion;
import models.Deposito;
import models.Expediente;
import models.Orden;
import models.OrdenProvision;
import models.Periodo;
import models.Proveedor;
import models.TipoCuenta;
import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

@Entity
@Table(name = "informe_estadistico_deuda_proveedores_matrializada")
public class InformeDeudaProveedoresMaterializada extends Model{
	private static final long serialVersionUID = 1L;

	@Id
	public Integer id;

	public Long orden_id;
	public Long orden_provision_id;

	@OneToOne
	@JoinColumn(name="orden_provision_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenProvision ordenProvision;

	public Integer numero_orden_provision;


	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	public Long deposito_id;

	public Integer tipo_moneda;


	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expedienteObj;
	public Long expediente_id;

	public Long ejercicio_id;
	public Long rubro_id;
	public String rubro;
	public String ano;
	public Boolean profe;

	@ManyToOne
	@JoinColumn(name="tipo_cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoCuenta tipoCuenta;
	public Long tipo_cuenta_id;

	public BigDecimal monto_adelanto;

	public BigDecimal totalOrden;
	public BigDecimal totalDeuda;
	public BigDecimal totalPagado;
	public BigDecimal totalActas;
	public BigDecimal totalActasSinAdelanto;
	public BigDecimal totalDeudaEnTramite;
	public BigDecimal totalCompromiso;
	public BigDecimal totalAutorizado;
	public BigDecimal totalRecepcionado;
	public BigDecimal cotizacion;
	public String moneda;

	public String expediente;
	public String nombreProveedor;

	@ManyToOne
	@JoinColumn(name="proveedor_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor;
	@Required(message="Requiere un proveedor")
	public Long proveedor_id;

	public Boolean perimido;

	public static Model.Finder<Long,InformeDeudaProveedoresMaterializada> find = new Finder<Long,InformeDeudaProveedoresMaterializada>(Long.class, InformeDeudaProveedoresMaterializada.class);

	public static Pagination<InformeDeudaProveedoresMaterializada> page(String orden,
																	  String proveedor_id,
																	  String expediente_id,
																	  String ejercicio_id,
																	  String rubro_id,
																	  String deuda_mayor,
																	  String deuda_menor,
																	  String pago_mayor,
																	  String pago_menor,
																	  String compromiso_mayor,
																	  String compromiso_menor,
																	  String cuenta,
																	  String deposito_id,
																	  boolean autorizado,
																	  String tipo_moneda,
																	  String tipo_cuenta_id,
																	  String acta_sin_adelanto_menor_pago,
																	  String monto_adelanto,
																	  String emergencia,
																	  String perimido) {
    	Pagination<InformeDeudaProveedoresMaterializada> p = new Pagination<InformeDeudaProveedoresMaterializada>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("expediente, numero_orden_provision");

    	ExpressionList<InformeDeudaProveedoresMaterializada> e = find
    			.fetch("ordenProvision", "orden_compra_id,numero")
    			.fetch("expedienteObj")
    			.fetch("deposito")
    			.fetch("proveedor")
    			.where();

		if(!emergencia.isEmpty()){
    		if(emergencia.compareToIgnoreCase("SI") ==0){
    			e.eq("expedienteObj.emergencia", true);
    		}else{
    			e.eq("expedienteObj.emergencia", false);
    		}
    	}

		boolean peri = false;

		if(!perimido.isEmpty()){
    		if(perimido.compareToIgnoreCase("SI") ==0){
    			peri = true;
    		}
    	}

		e.eq("perimido", peri);

    	if(!acta_sin_adelanto_menor_pago.isEmpty()){
    		e.raw("(totalActasSinAdelanto < totalPagado)");
    		e.isNotNull("numero_orden_provision");
    	}

    	if(autorizado) {
    		e.raw("(totalAutorizado < totalDeuda + totalPagado)");
    	}

    	if(!tipo_cuenta_id.isEmpty()){
    		e.eq("tipo_cuenta_id", Integer.parseInt(tipo_cuenta_id));
    	}

    	if(!orden.isEmpty()){
    		e.eq("numero_orden_provision", Integer.parseInt(orden));
    	}

    	if(!proveedor_id.isEmpty()){
	    	if(proveedor_id.compareTo("14947") == 0) {
				e.in("proveedor_id", Proveedor.getProveedoresDestacadosRA());
			}else {
				e.eq("proveedor_id", Integer.parseInt(proveedor_id));
			}
    	}

    	if(!expediente_id.isEmpty()){
    		e.eq("expediente_id", Integer.parseInt(expediente_id));
    	}

    	if(!deposito_id.isEmpty()){
    		e.eq("deposito_id", Integer.parseInt(deposito_id));
    	}

    	if(!cuenta.isEmpty()){
    		if(cuenta.equals("operativa")) {
    			e.eq("profe", false);
    		} else if (cuenta.equals("profe")) {
    			e.eq("profe", true);
    		}else{
    			Boolean b = new Boolean(cuenta);
    			if(b){
    				e.eq("profe", true);
    			}else{
    				e.eq("profe", false);
    			}
    		}



    	}

    	if(!ejercicio_id.isEmpty()){
    		e.eq("ejercicio_id", Integer.parseInt(ejercicio_id));
    	}

    	if(!rubro_id.isEmpty()){
    		e.eq("rubro_id", Integer.parseInt(rubro_id));
    	}

    	if(!deuda_mayor.isEmpty()){
    		e.gt("total_deuda", Float.parseFloat(deuda_mayor));
    	}

    	if(!deuda_menor.isEmpty()){
    		e.lt("total_deuda", Float.parseFloat(deuda_menor));
    	}

    	if(!compromiso_mayor.isEmpty()){
    		e.gt("total_compromiso", Float.parseFloat(compromiso_mayor));
    	}

    	if(!compromiso_menor.isEmpty()){
    		e.lt("total_compromiso", Float.parseFloat(compromiso_menor));
    	}

    	if(!tipo_moneda.isEmpty()){
    		e.eq("tipo_moneda", Integer.parseInt(tipo_moneda));
    	}

    	if(!monto_adelanto.isEmpty()){
    		e.isNotNull("monto_adelanto");
    		e.gt("monto_adelanto", 0);
    	}


    	//e.isNotNull("cot_dolar");


    	p.setExpressionList(e);
    	return p;
    }


	public BigDecimal getRestoAAutorizar() {
		return totalOrden.subtract(totalAutorizado);
	}

	public static List<SqlRow> getDeudaDepositoAgrupados(boolean proveedoresSoloDestacados,boolean profe, boolean ra){

		String sql = "SELECT i.deposito_id deposito_id,d.nombre nombre," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN depositos d ON d.id = i.deposito_id " +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";



		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}


		if(ra){
			sql += " AND p.id IN (2050,1430,3045,2176,14106,14441,14971,16359) ";
		}else{
			if(proveedoresSoloDestacados){
				sql += " AND p.id IN (select proveedor_id from proveedores_destacados) ";
				sql += " AND  p.id NOT IN (2050,1430,3045,2176,14106,14441,14971,16359) ";
			}else{
				sql += " AND  p.id NOT IN (select proveedor_id from proveedores_destacados) ";
			}
		}

		sql += " GROUP BY i.deposito_id,d.nombre ORDER BY total_deuda DESC";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getDeudaRubroAgrupados(boolean proveedoresSolosDestacados,boolean profe, boolean ra){

		String sql = "SELECT i.rubro_id rubro_id,i.rubro rubro," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";



		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}


		if(ra){
			sql += " AND p.id IN (2050,1430,3045,2176,14106,14441,14971,16359) ";
		}else{
			if(proveedoresSolosDestacados){
				sql += " AND p.id IN (select proveedor_id from proveedores_destacados) ";
				sql += " AND  p.id NOT IN (2050,1430,3045,2176,14106,14441,14971,16359) ";
			}else{
				sql += " AND  p.id NOT IN (select proveedor_id from proveedores_destacados) ";
			}
		}

		sql += " GROUP BY i.rubro_id, i.rubro ORDER BY total_deuda DESC";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();
		Logger.debug("-------------- fgggggggggggggggg");
		return row;

	}

	public static List<SqlRow> getDeudaPorProveedorAgrupados(boolean proveedoresDestacados,
															 boolean profe,
															 Integer deposito,
															 boolean ra,
															 boolean servicios,
															 boolean equipamiento,
															 boolean honorarios,
															 boolean soloDeuda){
		return getDeudaPorProveedorAgrupados( proveedoresDestacados, profe, deposito, ra, servicios, equipamiento, honorarios, null,soloDeuda);
	}

	public static List<SqlRow> getDeudaPorProveedorAgrupados(boolean proveedoresDestacados,
															 boolean profe,
															 Integer deposito,
															 boolean ra,
															 boolean servicios,
															 boolean equipamiento,
															 boolean honorarios,
															 Boolean soloDestacados,
															 boolean soloDeuda){

		String sql = "SELECT i.proveedor_id proveedor_id,i.nombre_proveedor nombre_proveedor," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" WHERE i.perimido = false ";

		if(soloDeuda){
			sql += "AND (i.total_deuda > 0.01) ";
		}else{
			sql += "AND (i.total_deuda > 0.01 OR i.total_compromiso > 0) ";
		}


		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}

		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}

		if(servicios){
			sql += " AND i.rubro_id = 7 ";
		}else if(honorarios){
			sql += " AND i.rubro_id = 8 ";
		}else if (soloDestacados != null && !soloDestacados && equipamiento) {
			sql += " AND i.rubro_id <> 7   ";
		}else if(equipamiento){
			sql += " AND i.rubro_id = 1 ";
		}else{
			if((ra || proveedoresDestacados)) {
				sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8  ";
			}else{
				sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 1 AND i.rubro_id <> 8 ";
			}

		}

		if(ra){
			sql += " AND p.id IN (2050,1430,3045,2176,14106,14441,14971,16359) ";
		}else{
			if(proveedoresDestacados){
				sql += " AND p.id IN (select proveedor_id from proveedores_destacados) ";
				if(soloDestacados != null && soloDestacados) {
					sql += " AND p.id NOT IN (2050,1430,3045,2176,14106,14441,14971,16359) ";
				}
			}else{
				sql += " AND  p.id NOT IN (select proveedor_id from proveedores_destacados) ";
			}
		}

		sql += " GROUP BY i.proveedor_id,i.nombre_proveedor ORDER BY total_deuda DESC";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	 public static List<SqlRow> getDeudaPorProveedoresDestacados(Integer deposito,Integer rubro,Integer proveedor_id){

		String sql = "SELECT i.proveedor_id proveedor_id,i.nombre_proveedor nombre_proveedor,"
				+ " CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda,"
				+ " CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso "
				+ " FROM informe_estadistico_deuda_proveedores_matrializada i 	"
				+ " INNER JOIN proveedores p ON p.id = i.proveedor_id " + " WHERE i.perimido = false ";

		if (true) {
			sql += "AND (i.total_deuda > 0.01) ";
		} else {
			sql += "AND (i.total_deuda > 0.01 OR i.total_compromiso > 0) ";
		}


		 sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";


		if (deposito == null || deposito == -1) {
			//sql += " AND i.deposito_id <> 1";
		} else if (deposito != 0) {
			sql += " AND i.deposito_id = " + deposito;
		}



		/*if (servicios) {
			sql += " AND i.rubro_id = 7 ";
		} else if (honorarios) {
			sql += " AND i.rubro_id = 8 ";
		} else if (soloDestacados != null && !soloDestacados && equipamiento) {
			sql += " AND i.rubro_id <> 7   ";
		} else if (equipamiento) {
			sql += " AND i.rubro_id = 1 ";
		} else {
			if ((ra || proveedoresDestacados)) {
				sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8  ";
			} else {
				sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 1 AND i.rubro_id <> 8 ";
			}

		}*/

		if (rubro != null) {
			sql += " AND i.rubro_id = " + rubro;
		}

		if(proveedor_id != null) {
			sql += " AND p.id  = " + proveedor_id;
		}else {
			sql += " AND p.id IN (select proveedor_id from proveedores_destacados) ";
		}



		sql += " GROUP BY i.proveedor_id,i.nombre_proveedor ORDER BY total_deuda DESC";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow> row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getDeudaPorProveedoresPorRubro(Integer deposito,List<Integer> rubros){

			String sql = "SELECT i.proveedor_id proveedor_id,i.nombre_proveedor nombre_proveedor,"
					+ " CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda,"
					+ " CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso "
					+ " FROM informe_estadistico_deuda_proveedores_matrializada i 	"
					+ " INNER JOIN proveedores p ON p.id = i.proveedor_id " + " WHERE i.perimido = false ";

			if (true) {
				sql += "AND (i.total_deuda > 0.01) ";
			} else {
				sql += "AND (i.total_deuda > 0.01 OR i.total_compromiso > 0) ";
			}


			 sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";


			if (deposito == null || deposito == -1) {
				//sql += " AND i.deposito_id <> 1";
			} else if (deposito != 0) {
				sql += " AND i.deposito_id = " + deposito;
			}

			sql += " AND i.rubro_id in(:rubros) "; //OTROS SERVICIOS

			/*if (servicios) {
				sql += " AND i.rubro_id = 7 ";
			} else if (honorarios) {
				sql += " AND i.rubro_id = 8 ";
			} else if (soloDestacados != null && !soloDestacados && equipamiento) {
				sql += " AND i.rubro_id <> 7   ";
			} else if (equipamiento) {
				sql += " AND i.rubro_id = 1 ";
			} else {
				if ((ra || proveedoresDestacados)) {
					sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8  ";
				} else {
					sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 1 AND i.rubro_id <> 8 ";
				}

			}*/

			sql += " AND p.id not IN (select proveedor_id from proveedores_destacados) ";


			sql += " GROUP BY i.proveedor_id,i.nombre_proveedor ORDER BY total_deuda DESC";

			SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
			List<SqlRow> row = sqlQuery.setParameter("rubros", rubros).findList();

			return row;

		}


	public static List<SqlRow> getDeudaPorProveedorDetallesOtros(boolean profe,Long deposito,boolean equipamiento,boolean soloDeuda){

		String sql = "SELECT i.numero_orden_provision numeroProvision, i.expediente expediente,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro_id rubroId,i.rubro rubro," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false ";

		if(soloDeuda){
			sql += "AND (i.total_deuda > 0.01) ";
		}else{
			sql += "AND (i.total_deuda > 0.01 OR i.total_compromiso > 0) ";
		}

		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}

		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}

		if(equipamiento){
			sql += " AND i.rubro_id = 1";
		}else{
			sql += " AND i.rubro_id <> 1";
		}
		sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8 ";

		sql += " AND  p.id NOT IN (select proveedor_id from proveedores_destacados) ";


		sql += " GROUP BY i.numero_orden_provision, i.expediente,e.fecha,e.descripcion,i.proveedor_id,i.nombre_proveedor,i.rubro_id,i.rubro " +
			   " ORDER BY i.nombre_proveedor,e.fecha, i.numero_orden_provision  ASC ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getDeudaPorProveedorDetalles(Integer idProoveedor,boolean profe,Long deposito,boolean soloDeudas){

		String sql = "SELECT i.numero_orden_provision numeroProvision, i.expediente expediente,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro rubro," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false ";

		if(soloDeudas){
			sql += "AND (i.total_deuda > 0.01) ";
		}else{
			sql += "AND (i.total_deuda > 0.01 OR i.total_compromiso > 0) ";
		}


		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}

		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}

		if(idProoveedor != null){
			sql += " AND p.id = "+idProoveedor;
		}

		sql += " GROUP BY i.numero_orden_provision, i.expediente,e.fecha,e.descripcion,i.proveedor_id,i.nombre_proveedor,i.rubro " +
				"ORDER BY i.nombre_proveedor,e.fecha ASC";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static List<SqlRow> getDeudaPorProveedorDetallesServicios(Long deposito,boolean todos){

		String sql = "SELECT i.numero_orden_provision numeroProvision,i.orden_provision_id orden_provision_id,i.expediente expediente," +
				" i.expediente_id expediente_id,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro_id rubroId,i.rubro rubro,d.nombre deposito, " +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" INNER JOIN ordenes o ON o.id = i.orden_id " +
				" INNER JOIN depositos d ON d.id = o.deposito_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";

		if(!todos){
			if(deposito == null || deposito == -1){
				sql += " AND i.deposito_id <> 1";
			}else if(deposito != 0){
				sql += " AND i.deposito_id = "+deposito;
			}
		}
		sql += " AND i.rubro_id =7 ";

		sql += " GROUP BY i.numero_orden_provision,i.orden_provision_id, i.expediente,i.expediente_id,e.fecha,e.descripcion,i.proveedor_id," +
				" i.nombre_proveedor,i.rubro_id,i.rubro,d.nombre  " +
			   " ORDER BY i.nombre_proveedor,e.fecha, i.numero_orden_provision  ASC ";
		Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx gggggggggggggggg");
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getDeudaPorProveedorDetallesServiciosResumen(Long deposito,boolean todos){

		String sql = "SELECT " +
				" i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor, " +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 "+
				" THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda " +

				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" INNER JOIN ordenes o ON o.id = i.orden_id " +
				" INNER JOIN depositos d ON d.id = o.deposito_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01)  ";

		if(!todos){
			if(deposito == null || deposito == -1){
				sql += " AND i.deposito_id <> 1";
			}else if(deposito != 0){
				sql += " AND i.deposito_id = "+deposito;
			}
		}
		sql += " AND i.rubro_id =7 ";

		sql += " GROUP BY i.proveedor_id, i.nombre_proveedor " +
			   " ORDER BY total_deuda DESC ,i.nombre_proveedor  ASC ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getDeudaPorProveedorDetallesHonorarios(Long deposito){

		String sql = "SELECT i.numero_orden_provision numeroProvision, i.expediente expediente,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro_id rubroId,i.rubro rubro," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)  ";

		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}

		sql += " AND i.rubro_id =8";


		//sql += " AND  p.id NOT IN (select proveedor_id from proveedores_destacados) ";


		sql += " GROUP BY i.numero_orden_provision, i.expediente,e.fecha,e.descripcion,i.proveedor_id,i.nombre_proveedor,i.rubro_id,i.rubro " +
			   " ORDER BY i.nombre_proveedor,e.fecha, i.numero_orden_provision  ASC ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getDeudaPorProveedorHonorariosResumen(Long deposito){

		String sql = "SELECT i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01)  ";

		/*if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}*/

		sql += " AND i.rubro_id =8";

		sql += " GROUP BY i.proveedor_id,i.nombre_proveedor " +
			   " ORDER BY total_deuda DESC ,i.nombre_proveedor  ASC ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}

	public static List<SqlRow> getDeudaPorCuenta(Integer idCuenta,Long deposito,Boolean soloDeuda){

		String sql = "SELECT i.numero_orden_provision numeroProvision, i.expediente expediente,e.fecha fechaExpediente," +
				" e.descripcion descripcion, i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor,i.rubro_id rubroId,i.rubro rubro," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false AND 1 = 1   ";

		if(soloDeuda){
			sql += " AND (i.total_deuda > 0.01)";
		}else {
			sql += " AND (i.total_deuda > 0.01 OR i.total_compromiso > 0)";
		}

		sql += " AND i.tipo_cuenta_id = "+idCuenta;
		sql += " AND i.rubro_id <> 8 ";

		if(deposito == null || deposito == -1){
			sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			sql += " AND i.deposito_id = "+deposito;
		}




		sql += " GROUP BY i.numero_orden_provision, i.expediente,e.fecha,e.descripcion,i.proveedor_id,i.nombre_proveedor,i.rubro_id,i.rubro " +
			   " ORDER BY i.nombre_proveedor,e.fecha, i.numero_orden_provision  ASC ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}


	public static Map<String,Map<String,Map<Integer,List<SqlRow>>>> getListaFinalDeudasDetallesReporte(Integer idProveedor,boolean ra,boolean soloDeudas){

		List<Integer> listaProveedores = new ArrayList<Integer>();
		if(ra){
			listaProveedores.add(2050);
			listaProveedores.add(1430);
			listaProveedores.add(3045);
			listaProveedores.add(2176);
			listaProveedores.add(14106);
			listaProveedores.add(14441);
			listaProveedores.add(14971);
			listaProveedores.add(16359);

		}else if(idProveedor.compareTo(1589) == 0){
			listaProveedores.add(7348);
			listaProveedores.add(idProveedor);
		}else{
			listaProveedores.add(idProveedor);
		}

		Map<String,Map<String,Map<Integer,List<SqlRow>>>> listaFinal = new HashMap<String, Map<String,Map<Integer,List<SqlRow>>>>();
		Map<String,Map<Integer,List<SqlRow>>> mapProveedores = new HashMap<String, Map<Integer,List<SqlRow>>>();

		Map<Integer,List<SqlRow>> listadoSqlRow = new HashMap<Integer, List<SqlRow>>();
		for(Integer idPro : listaProveedores){
			List<SqlRow> proveedorOperativa = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetalles(idPro,false,(long)Deposito.HEARM,soloDeudas);
			listadoSqlRow.put(idPro, proveedorOperativa);
		}



		mapProveedores.put("HEARM", listadoSqlRow);

		listadoSqlRow = new HashMap<Integer, List<SqlRow>>();
		for(Integer idPro : listaProveedores){
			List<SqlRow> proveedorOperativaOtraInstitucion = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetalles(idPro,false,null,soloDeudas);
			listadoSqlRow.put(idPro, proveedorOperativaOtraInstitucion);
		}

		mapProveedores.put("OTRAS INSTITUCIONES", listadoSqlRow);
		listaFinal.put("OPERATIVA", mapProveedores);
		mapProveedores = new HashMap<String, Map<Integer,List<SqlRow>>>();

		listadoSqlRow = new HashMap<Integer, List<SqlRow>>();
		for(Integer idPro : listaProveedores){
			List<SqlRow> proveedorProfe = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetalles(idPro,true,(long)Deposito.HEARM,soloDeudas);
			listadoSqlRow.put(idPro, proveedorProfe);
		}

		mapProveedores.put("HEARM", listadoSqlRow);

		listadoSqlRow = new HashMap<Integer, List<SqlRow>>();
		for(Integer idPro : listaProveedores){
			List<SqlRow> proveedorProfeOtraInstitucion = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetalles(idPro,true,null,soloDeudas);
			listadoSqlRow.put(idPro, proveedorProfeOtraInstitucion);
		}

		mapProveedores.put("OTRAS INSTITUCIONES", listadoSqlRow);
		listaFinal.put("PROFE", mapProveedores);

		return listaFinal;
	}

	public static void actualizarVistaMaterializada () {

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

	public static List<SqlRow> getDeudaPorOtroProveedoresResumen(boolean profe,Long deposito,boolean equipamiento){

		String sql = "SELECT i.proveedor_id proveedorId,i.nombre_proveedor nombre_proveedor," +
				" CASE WHEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_deuda > 0 THEN total_deuda ELSE 0 END),0) ELSE 0 END total_deuda " +
				//" CASE WHEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) > 0 THEN coalesce(SUM(CASE WHEN total_compromiso > 0 THEN total_compromiso ELSE 0 END),0) ELSE 0 END total_compromiso " +
				" FROM informe_estadistico_deuda_proveedores_matrializada i 	" +
				" INNER JOIN proveedores p ON p.id = i.proveedor_id " +
				" INNER JOIN expedientes e ON e.id = i.expediente_id " +
				" WHERE i.perimido = false AND (i.total_deuda > 0.01)  ";

		if(profe){
			sql += " AND (i.profe = true OR i.tipo_cuenta_id = 2) ";
		}else{
			sql += " AND (i.profe = false OR i.tipo_cuenta_id = 1) ";
		}

		if(deposito == null || deposito == -1){
			//sql += " AND i.deposito_id <> 1";
		}else if(deposito != 0){
			//sql += " AND i.deposito_id = "+deposito;
		}

		if(equipamiento){
			sql += " AND i.rubro_id = 1";
		}else{
			sql += " AND i.rubro_id <> 1";
		}
		sql += " AND i.rubro_id <> 7 AND i.rubro_id <> 8 ";

		sql += " AND  p.id NOT IN (select proveedor_id from proveedores_destacados) ";


		sql += " GROUP BY i.proveedor_id,i.nombre_proveedor " +
			   " ORDER BY total_deuda DESC ,i.nombre_proveedor  ASC ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);

		List<SqlRow>  row = sqlQuery.findList();

		return row;

	}


}
