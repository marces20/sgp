package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.Logger;
import play.data.format.Formats;
import play.db.ebean.Model;
import play.libs.Json;
import utils.DateUtils;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;
import com.avaje.ebean.Query;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.annotation.Sql;
import com.avaje.ebean.annotation.SqlSelect;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


@Entity
@Sql
public class BalancePresupuestario extends Model {
	private static final long serialVersionUID = 1L;

	public Long cuenta_analitica_padre_id;
	public Long cuenta_analitica_hija_id;
	//public Long expediente_id;
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public String expedienteRp;
	public BigDecimal saldo;
	public BigDecimal preventivo;
	public BigDecimal definitivo;
	public BigDecimal obligacion;
	public BigDecimal pago;
	public BigDecimal saldo_rp;
	public BigDecimal preventivo_rp;
	public BigDecimal definitivo_rp;
	public BigDecimal obligacion_rp;
	public BigDecimal pago_rp;
	public String nombre;
	public String codigo;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date create_date;

	public boolean profe;
	@ManyToOne
	@JoinColumn(name="obrasocial_id", referencedColumnName="id", insertable=false, updatable=false)
	public Obrasocial obrasocial;

	public CuentaAnalitica cuentaAnalitica;

	public static Model.Finder<Integer,BalancePresupuestario> find = new Model.Finder<Integer,BalancePresupuestario>(Integer.class, BalancePresupuestario.class);

	public static boolean tieneRP(Long idExpediente){
		boolean ret = false;
		String sql = "SELECT * FROM controles_presupuestarios WHERE expediente_id in ( "+
					 "  SELECT id FROM expedientes WHERE parent_id = :idExpediente "+
					 " )";
		List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("idExpediente",idExpediente).findList();
		if(s.size() > 0){
			ret = true;
		}

		return ret;
	}

	public static BigDecimal getSaldoTotalPorCuenta(Long idCuentaAnalitica, String ejercicioId){

		String where =  "";
		if(!ejercicioId.isEmpty()){
			where += " AND ejercicio_id = "+Integer.parseInt(ejercicioId);
		}

		String sql = "SELECT cuenta_analitica_padre_id,ca.nombre, "+
					 "COALESCE(SUM(ROUND(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END,2)),0)  as saldo "+
					 "FROM controles_presupuestarios as cp "+
					 "INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id "+
					 "WHERE cp.cuenta_analitica_padre_id = :cuenta " +
					 " "+where+
					 "GROUP BY cuenta_analitica_padre_id,ca.nombre ";

		SqlRow s = Ebean.createSqlQuery(sql).setParameter("cuenta", idCuentaAnalitica).findUnique();

		BigDecimal r = (s != null)?s.getBigDecimal("saldo"):new BigDecimal(0);

		return r;
	}


	public static Pagination<BalancePresupuestario> getPorCuentaPadre(String cuenta,
																	  String cuentaHija,
																	  String idExpediente,
																	  String ejercicioId,
																	  String tipo_cuenta_id,
																	  String osId) {

		String where = " WHERE 1=1 ";
		String select = " ";
		String groupBy = " ";
		String groupBy2 = " ";
		String inner = " ";

		if(!osId.isEmpty() && !tipo_cuenta_id.isEmpty()){
			where += " AND cl.obrasocial_id = "+Integer.parseInt(osId);

			where += " AND s.tipo_cuenta_id = "+tipo_cuenta_id;
			groupBy2 += " ,cl.obrasocial_id,s.tipo_cuenta_id ";

			inner +="INNER JOIN solicitudes s on s.id = cp.solicitud_id INNER JOIN clientes cl on cl.id = s.cliente_id ";
		}

		if(!cuenta.isEmpty()) {
			where += " AND cuenta_analitica_padre_id = "+Integer.parseInt(cuenta);
		}

		if(!cuentaHija.isEmpty()) {
			where += " AND cuenta_analitica_hija_id = "+Integer.parseInt(cuentaHija);
		}

		if(!idExpediente.isEmpty()){
			where += " AND cp.expediente_id = "+Integer.parseInt(idExpediente);
			groupBy2 += " ,cp.expediente_id ";
		}

		if(!ejercicioId.isEmpty()){
			where += " AND ejercicio_id = "+Integer.parseInt(ejercicioId);
			groupBy2 += " ,ejercicio_id ";
		}

		BigDecimal d ;

		Pagination<BalancePresupuestario> p = new Pagination<BalancePresupuestario>();
    	p.setOrderDefault("ASC");
    	//p.setSortByDefault("cuenta_analitica_padre_id");
    	p.setPageSize(500);
    	RawSql rawSql;
    	RawSql rawSql2;

    	if(!osId.isEmpty() && !tipo_cuenta_id.isEmpty()){

    		rawSql = RawSqlBuilder.unparsed("SELECT cuenta_analitica_padre_id,ca.nombre, "+
    				"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0)  as saldo, " +
					"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0) as preventivo, " +
					"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0)  as definitivo, " +
					"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)  as obligacion," +
					"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)  as pago," +
					"s.tipo_cuenta_id as profe,cl.obrasocial_id as obrasocial  " +
					"FROM controles_presupuestarios as cp " +
					"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
					"INNER JOIN solicitudes s on s.id = cp.solicitud_id " +
					"INNER JOIN clientes cl on cl.id = s.cliente_id " +
					where +
					" GROUP BY cuenta_analitica_padre_id,ca.nombre,ca.orden,s.tipo_cuenta_id,cl.obrasocial_id ORDER BY ca.orden asc ")
					.columnMapping("cuenta_analitica_padre_id", "cuenta_analitica_padre_id")
					.columnMapping("nombre", "nombre")
					.columnMapping("saldo", "saldo")
					.columnMapping("preventivo", "preventivo")
					.columnMapping("definitivo", "definitivo")
					.columnMapping("obligacion", "obligacion")
					.columnMapping("pago", "pago")
					.columnMapping("tipo_cuenta_id", "tipo_cuenta_id")
					.columnMapping("obrasocial", "obrasocial.id")
					.create();


    	}else if(!idExpediente.isEmpty()){
    		rawSql = RawSqlBuilder.unparsed("SELECT cuenta_analitica_padre_id,ca.nombre,expediente_id, "+
    						"((SELECT COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0) " +
    						"FROM controles_presupuestarios WHERE cuenta_analitica_padre_id = cp.cuenta_analitica_padre_id) -" +
							"(SELECT COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0) " +
							"FROM controles_presupuestarios where expediente_id <> "+idExpediente+" AND cuenta_analitica_padre_id = cp.cuenta_analitica_padre_id)) as saldo," +
							"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0) as preventivo, " +
							"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0)  as definitivo, " +
							"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)  as obligacion," +
							"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)  as pago " +
							"FROM controles_presupuestarios as cp " +
							"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
							where +
							" GROUP BY cuenta_analitica_padre_id, expediente_id, ca.nombre,ca.orden ORDER BY ca.orden asc ")
							.columnMapping("cuenta_analitica_padre_id", "cuenta_analitica_padre_id")
							.columnMapping("nombre", "nombre")
							.columnMapping("expediente", "expediente.id")
							.columnMapping("saldo", "saldo")
							.columnMapping("preventivo", "preventivo")
							.columnMapping("definitivo", "definitivo")
							.columnMapping("obligacion", "obligacion")
							.columnMapping("pago", "pago")
							.create();
    	}else{
    		rawSql = RawSqlBuilder.unparsed("SELECT cuenta_analitica_padre_id,ca.nombre,"+
    				"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0)  as saldo, " +
					"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0) as preventivo, " +
					"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0)  as definitivo, " +
					"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)  as obligacion," +
					"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)  as pago " +
					"FROM controles_presupuestarios as cp " +
					"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
					where +
					" GROUP BY cuenta_analitica_padre_id,ca.nombre,ca.orden ORDER BY ca.orden asc")
					.columnMapping("cuenta_analitica_padre_id", "cuenta_analitica_padre_id")
					.columnMapping("nombre", "nombre")
					.columnMapping("saldo", "saldo")
					.columnMapping("preventivo", "preventivo")
					.columnMapping("definitivo", "definitivo")
					.columnMapping("obligacion", "obligacion")
					.columnMapping("pago", "pago")
					.create();
    	}


		p.parcheCountAllFormula = true;

		p.setTotalRowCount(Ebean.createSqlQuery("SELECT COUNT(cuenta_analitica_padre_id) cant " +
				"FROM controles_presupuestarios cp "+inner+" " +where+
				" GROUP BY cuenta_analitica_padre_id "+groupBy2).findList().size());

		p.setExpressionList(Ebean.find(BalancePresupuestario.class).setRawSql(rawSql).fetch("cuentaAnalitica").where());

		return p;
	}

	/*public static Map<Integer,String> getCuentas(Integer idEjercicio){
		String sql = "SELECT cp.cuenta_analitica_padre_id, ca.nombre " +
				"FROM controles_presupuestarios cp " +
				"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
				"WHERE ejercicio_id = :ejercicioId " +
				"GROUP BY cp.cuenta_analitica_padre_id, ca.nombre ORDER BY ca.orden asc ";
		List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("ejercicioId",idEjercicio).findList();

		Map<Integer,String> lr = new HashMap<Integer, String>();
		for(SqlRow a : s){
			lr.put(a.getInteger("cuenta_analitica_padre_id"),a.getString("nombre"));
		}

		return lr;
	}*/

	public static List<SqlRow> getCuentas(Integer idEjercicio){
		String sql = "SELECT cp.cuenta_analitica_padre_id as cuenta_analitica_padre_id, ca.nombre as nombre " +
				"FROM controles_presupuestarios cp " +
				"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
				"WHERE ejercicio_id = :ejercicioId " +
				"GROUP BY cp.cuenta_analitica_padre_id, ca.nombre,ca.orden ORDER BY ca.orden asc ";
		return Ebean.createSqlQuery(sql).setParameter("ejercicioId",idEjercicio).findList();
	}

	public static List<BalancePresupuestario> getSaldosPorCuentaPorExpedientesFecha(Integer idEjercicio,Date ffd,Date ffh,Date ffdd,Date ffhd,Integer idCuenta){

		RawSql rawSql2;
    	String whereCuenta = "";
    	String whereEjercicio = "";
    	String whereFechaPreventivo = "";
    	String whereFechaDefinitivo = "";

    	if(idEjercicio != null){
    		whereEjercicio += " AND ej.id = " +idEjercicio;
    	}

    	if(idCuenta != null){
    		whereCuenta += " AND cuenta_analitica_padre_id = " +idCuenta;
    	}

    	if(ffd != null){
    		String sffd = DateUtils.formatDate(ffd, "yyyy-MM-dd");
    		String sffh = DateUtils.formatDate(ffh, "yyyy-MM-dd");

    		whereFechaPreventivo += " AND ( cp.create_date >= '"+sffd+"' AND  cp.create_date <= '"+sffh+"' AND cp.etapa_presupuestaria_id = 1) ";
    	}

    	if(ffdd != null){
    		String sffdd = DateUtils.formatDate(ffdd, "yyyy-MM-dd");
    		String sffhd = DateUtils.formatDate(ffhd, "yyyy-MM-dd");
    		whereFechaDefinitivo += " AND ( cp.create_date >= '"+sffdd+"' AND  cp.create_date <= '"+sffhd+"' AND cp.etapa_presupuestaria_id = 2) ";
    	}

		rawSql2 = RawSqlBuilder.unparsed(" SELECT cuenta_analitica_padre_id,ca.codigo,ca.nombre,cp.expediente_id eid,e.nombre eNombre,e.fecha,cp.create_date create_date,  " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0)  as saldo, " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0) as preventivo, " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0)  as definitivo, " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)  as obligacion, " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)  as pago " +
	    		" FROM controles_presupuestarios as cp " +
	    		" INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
	    		" INNER JOIN expedientes e ON e.id = cp.expediente_id " +
	    		" INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id " +
	    		" WHERE 1=1 " +

	    		//" cuenta_analitica_padre_id = " +idCuenta+
	    		whereCuenta+whereEjercicio+whereFechaPreventivo+whereFechaDefinitivo+
				" GROUP BY cuenta_analitica_padre_id,ca.codigo,ca.nombre,cp.expediente_id,e.nombre,e.fecha,cp.create_date " +
				" ORDER BY e.nombre, e.fecha ")
	    		.columnMapping("cuenta_analitica_padre_id", "cuenta_analitica_padre_id")
	    		.columnMapping("codigo", "codigo")
				.columnMapping("nombre", "nombre")
				.columnMapping("eid", "expediente.id")
				.columnMapping("eNombre", "expediente.nombre")
				.columnMapping("eFecha", "expediente.fecha")
				.columnMapping("create_date", "create_date")
				.columnMapping("saldo", "saldo")
				.columnMapping("preventivo", "preventivo")
				.columnMapping("definitivo", "definitivo")
				.columnMapping("obligacion", "obligacion")
				.columnMapping("pago", "pago")
				.create();

		List<BalancePresupuestario> lbp = Ebean.find(BalancePresupuestario.class)
										  .setRawSql(rawSql2).fetch("cuentaAnalitica").where().findList();
		return lbp;
	}

	public static List<BalancePresupuestario> getSaldosPorCuentaPorExpedientes(Integer idCuenta,
																			   Integer idCuentaHija,
																			   Integer idEjercicio,
																			   Integer tipo_cuenta_id,
																			   Integer osId){

    	RawSql rawSql2;
    	String whereCuenta = "";
    	String whereEjercicio = "";
    	String whereProfe = "";
    	String innerProfe = "";

    	if(idCuenta != null){
    		whereCuenta += " AND cuenta_analitica_padre_id = " +idCuenta;
    	}
    	if(idCuentaHija != null){
    		whereCuenta += " AND cuenta_analitica_hija_id = " +idCuentaHija;
    	}

    	if(idEjercicio != null){
    		whereEjercicio += " AND ej.id = " +idEjercicio;
    	}

    	if(tipo_cuenta_id != null && osId != null){

    		whereProfe += " AND cl.obrasocial_id = "+osId;
    		whereProfe += " AND s.tipo_cuenta_id = "+tipo_cuenta_id;

    		innerProfe +="INNER JOIN solicitudes s on s.id = cp.solicitud_id INNER JOIN clientes cl on cl.id = s.cliente_id ";


    	}

		rawSql2 = RawSqlBuilder.unparsed(" SELECT cuenta_analitica_padre_id,ca.nombre,cp.expediente_id eid,e.nombre eNombre,e.fecha,  " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0)  as saldo, " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0) as preventivo, " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0)  as definitivo, " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)  as obligacion, " +
	    		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)  as pago " +
	    		" FROM controles_presupuestarios as cp " +
	    		" INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
	    		" INNER JOIN expedientes e ON e.id = cp.expediente_id " +
	    		" INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id " +innerProfe+
	    		" WHERE 1=1 " +

	    		//" cuenta_analitica_padre_id = " +idCuenta+
	    		whereCuenta+whereEjercicio+whereProfe+
				" GROUP BY cuenta_analitica_padre_id,ca.nombre,ca.orden,cp.expediente_id,e.nombre,e.fecha  " +
				" ORDER BY ca.orden asc ")
	    		.columnMapping("cuenta_analitica_padre_id", "cuenta_analitica_padre_id")
				.columnMapping("nombre", "nombre")
				.columnMapping("eid", "expediente.id")
				.columnMapping("eNombre", "expediente.nombre")
				.columnMapping("eFecha", "expediente.fecha")
				.columnMapping("saldo", "saldo")
				.columnMapping("preventivo", "preventivo")
				.columnMapping("definitivo", "definitivo")
				.columnMapping("obligacion", "obligacion")
				.columnMapping("pago", "pago")
				.create();

		List<BalancePresupuestario> lbp = Ebean.find(BalancePresupuestario.class)
										  .setRawSql(rawSql2).fetch("cuentaAnalitica").where().findList();
		return lbp;
	}

	public static List<BalancePresupuestario> getControlDeudaPorEjercicio(Integer idEjercicio){

    	RawSql rawSql2;
    	String whereCuenta = "";
    	String whereEjercicio = "";

    	if(idEjercicio != null){
    		whereEjercicio += " AND ej.id = " +idEjercicio;
    	}

		rawSql2 = RawSqlBuilder.unparsed(" SELECT cp.expediente_id eid,e.nombre eNombre,e.fecha, " +
				" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0)  as saldo, " +
				" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0) as preventivo, " +
				" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0)  as definitivo, " +
				" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)  as obligacion, " +
				" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)  as pago, " +
				" COALESCE(rp.expedienteRp,'') as expedienteRp, " +
				" COALESCE(rp.saldo,0) as saldo_rp, " +
				" COALESCE(rp.preventivo,0) as preventivo_rp, " +
				" COALESCE(rp.definitivo,0) as definitivo_rp, " +
				" COALESCE(rp.obligacion,0) as obligacion_rp, " +
				" COALESCE(rp.pago,0) as pago_rp " +
				" FROM controles_presupuestarios as cp " +
				" INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
				" INNER JOIN expedientes e ON e.id = cp.expediente_id " +
				" INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id  " +
				" left join ( " +
					" SELECT e.parent_id id,e.nombre expedienteRp, " +
					" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0)  as saldo, " +
					" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0)  as preventivo, " +
					" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0)  as definitivo, " +
					" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)  as obligacion," +
					" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)  as pago " +
					" FROM controles_presupuestarios as cp  " +
					" INNER JOIN expedientes e ON e.id = cp.expediente_id  " +
					" WHERE e.parent_id is not null " +
					" GROUP BY e.parent_id,expedienteRp " +
				" ) as rp on rp.id = e.id " +
				" WHERE e.parent_id is null " +
				whereEjercicio+
				" GROUP BY cp.expediente_id,e.nombre,e.fecha,expedienteRp,saldo_rp,preventivo_rp,definitivo_rp,obligacion_rp,pago_rp " +
				" ORDER BY e.nombre, e.fecha ")
				.columnMapping("eid", "expediente.id")
				.columnMapping("eNombre", "expediente.nombre")
				.columnMapping("eFecha", "expediente.fecha")
				.columnMapping("saldo", "saldo")
				.columnMapping("preventivo", "preventivo")
				.columnMapping("definitivo", "definitivo")
				.columnMapping("obligacion", "obligacion")
				.columnMapping("pago", "pago")
				.columnMapping("expedienteRp", "expedienteRp")
				.columnMapping("saldo_rp", "saldo_rp")
				.columnMapping("preventivo_rp", "preventivo_rp")
				.columnMapping("definitivo_rp", "definitivo_rp")
				.columnMapping("obligacion_rp", "obligacion_rp")
				.columnMapping("pago_rp", "pago_rp")
				.create();

		List<BalancePresupuestario> lbp = Ebean.find(BalancePresupuestario.class)
										  .setRawSql(rawSql2).where().findList();
		return lbp;
	}

	public static List<BalancePresupuestario> getInfoParaReportes(Integer idOrganismo,Long idEjercicio){

		RawSql rawSql2;
		String whereEjercicio = "";
		String groupBy2 = "";
		String whereOrganismo = "";

		if(idEjercicio != null){
			whereEjercicio += " AND ejercicio_id = "+idEjercicio;
			groupBy2 += " ,ejercicio_id ";
		}

		if(idOrganismo != null){

			String x ="";
			switch ( idOrganismo ) {
		      case 0:
		    	  x ="00-3-";
		      break;
		      case 1:
		    	  x ="01-3-";
		      break;
		      case 2:
		    	  x ="02-3-";
		      break;
		      case 3:
		    	  x ="03-3-";
		      break;
		      case 4:
		    	  x ="04-3-";
		      break;
		      case 5:
		    	  x ="05-3-";
		      break;
		      case 6:
		    	  x ="06-3-";
		      break;
		      case 7:
		    	  x ="07-3-";
		      break;
		      case 8:
		    	  x ="08-3-";
		      break;
		      default:
		    	  x ="00-3-";
			  break;
		    }

			whereOrganismo += " AND ca.codigo ilike '%"+x+"%' ";
		}


		rawSql2 = RawSqlBuilder.unparsed(" SELECT cuenta_analitica_padre_id,ca.nombre,  " +
		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0)  as saldo, " +
		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0) as preventivo, " +
		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0)  as definitivo, " +
		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)  as obligacion, " +
		" COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)  as pago " +
		" FROM controles_presupuestarios as cp " +
		" INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
		" WHERE ca.id not in(11,23) and ca.nombre NOT ILIKE '%plan sumar%' and 1=1 " +

		whereEjercicio+ whereOrganismo+
		" GROUP BY cuenta_analitica_padre_id,ca.nombre,ca.orden"+groupBy2 +
		" HAVING COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0) > 0 "+
		" ORDER BY ca.orden asc ")
		.columnMapping("cuenta_analitica_padre_id", "cuenta_analitica_padre_id")
		.columnMapping("nombre", "nombre")
		.columnMapping("saldo", "saldo")
		.columnMapping("preventivo", "preventivo")
		.columnMapping("definitivo", "definitivo")
		.columnMapping("obligacion", "obligacion")
		.columnMapping("pago", "pago")
		.create();

		List<BalancePresupuestario> lbp = Ebean.find(BalancePresupuestario.class)
		.setRawSql(rawSql2).fetch("cuentaAnalitica").where().findList();
		return lbp;
	}


	public static Pagination<BalancePresupuestario> page(String nombre) {
    	Pagination<BalancePresupuestario> p = new Pagination<BalancePresupuestario>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("cuenta_analitic_padre_id");

    	ExpressionList<BalancePresupuestario> e = BalancePresupuestario.find.where();


    	p.setExpressionList(e);
    	return p;

    }

	public static BigDecimal getSaldoPresupuestarioPorCuenta(Integer idCuentaAnalitica,Integer ejercicioId){
		String sql = "SELECT " +
					"(COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0) " +
					"- " +
					"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0)) as saldo " +
					"FROM controles_presupuestarios as cp " +
					"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
					"WHERE cuenta_analitica_padre_id = :cuenta AND cp.ejercicio_id = :ejercicioId " +
					"GROUP BY cuenta_analitica_padre_id ";
		SqlRow s = Ebean.createSqlQuery(sql).setParameter("cuenta", idCuentaAnalitica).setParameter("ejercicioId",ejercicioId).findUnique();

		BigDecimal r = (s != null)?s.getBigDecimal("saldo"):new BigDecimal(0);

		return r;
	}

	public static BigDecimal getSaldoInicialPorCuenta(Integer idCuentaAnalitica,Integer ejercicioId){
		String sql = "SELECT " +
					"(COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0))   as saldo " +
					"FROM controles_presupuestarios as cp " +
					"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
					"WHERE cuenta_analitica_padre_id = :cuenta AND cp.ejercicio_id = :ejercicioId " +
					"GROUP BY cuenta_analitica_padre_id ";
		SqlRow s = Ebean.createSqlQuery(sql).setParameter("cuenta", idCuentaAnalitica).setParameter("ejercicioId",ejercicioId).findUnique();

		BigDecimal r = (s != null)?s.getBigDecimal("saldo"):new BigDecimal(0);

		return r;
	}

	public static BigDecimal getSaldoPreventivoPorCuentaPorExpediente(Integer idCuentaAnalitica,Integer idExpediente){

		String sql = "SELECT " +
				"(COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (ROUND(haber,2) - ROUND(debe,2)) END),2),0) " +
				" - " +
				"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (ROUND(haber,2) - ROUND(debe,2)) END),2),0)) " +
				"as saldo " +
				"FROM controles_presupuestarios as cp " +
				"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
				"WHERE cuenta_analitica_padre_id = :cuenta AND expediente_id = :expediente " +
				"GROUP BY cuenta_analitica_padre_id, expediente_id ";

		SqlRow s = Ebean.createSqlQuery(sql)
				.setParameter("cuenta", idCuentaAnalitica)
				.setParameter("expediente", idExpediente)
				.findUnique();

		BigDecimal r = (s != null)?s.getBigDecimal("saldo"):new BigDecimal(0);

		return r;
	}

	public static BigDecimal getSaldoPreventivoPorCuentaPorExpedienteCajaChica(Integer idCuentaAnalitica,Integer idExpediente,Long caja_chica_id){

		String sql = "SELECT " +
				"(COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (ROUND(haber,2) - ROUND(debe,2)) END),2),0) " +
				" - " +
				"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (ROUND(haber,2) - ROUND(debe,2)) END),2),0)) " +
				"as saldo " +
				"FROM controles_presupuestarios as cp " +
				"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
				"WHERE cuenta_analitica_padre_id = :cuenta AND expediente_id = :expediente AND caja_chica_id = :caja_chica_id " +
				"GROUP BY cuenta_analitica_padre_id, expediente_id ";

		SqlRow s = Ebean.createSqlQuery(sql)
				.setParameter("cuenta", idCuentaAnalitica)
				.setParameter("expediente", idExpediente)
				.setParameter("caja_chica_id", caja_chica_id)
				.findUnique();

		BigDecimal r = (s != null)?s.getBigDecimal("saldo"):new BigDecimal(0);

		return r;
	}



	public static BigDecimal getSaldoDefinitivoPorCuentaPorExpediente(Integer idCuentaAnalitica,Integer idExpediente){

		String sql = "SELECT " +
				"(COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0) " +
				" - " +
				"COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)) " +
				"as saldo " +
				"FROM controles_presupuestarios as cp " +
				"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
				"WHERE cuenta_analitica_padre_id = :cuenta AND expediente_id = :expediente " +
				"GROUP BY cuenta_analitica_padre_id, expediente_id ";

		SqlRow s = Ebean.createSqlQuery(sql)
				.setParameter("cuenta", idCuentaAnalitica)
				.setParameter("expediente", idExpediente)
				.findUnique();

		BigDecimal r = (s != null)?s.getBigDecimal("saldo"):new BigDecimal(0);

		return r;
	}

	public static BigDecimal getSaldoObligacionPorCuentaPorExpediente(Integer idCuentaAnalitica,Integer idExpediente){

		String sql = "SELECT " +
				"(COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0) " +
				" - " +
				"COALESCE(ROUND(SUM(ROUND(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)) " +
				"as saldo " +
				"FROM controles_presupuestarios as cp " +
				"INNER JOIN cuentas_analiticas ca ON ca.id = cp.cuenta_analitica_padre_id " +
				"WHERE cuenta_analitica_padre_id = :cuenta AND expediente_id = :expediente " +
				"GROUP BY cuenta_analitica_padre_id, expediente_id ";

		SqlRow s = Ebean.createSqlQuery(sql)
				.setParameter("cuenta", idCuentaAnalitica)
				.setParameter("expediente", idExpediente)
				.findUnique();

		BigDecimal r = (s != null)?s.getBigDecimal("saldo"):new BigDecimal(0);

		return r;
	}

	public static ArrayNode controlSaldoCajaChica(CajaChica cc,Integer ejercicioId){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();

		Map<Integer, BigDecimal> vs = new HashMap<Integer, BigDecimal>();
		Map<Integer, String> cs = new HashMap<Integer, String>();
		Map<Integer, Integer> es = new HashMap<Integer, Integer>();


		String sql = "SELECT e.ejercicio_id ejercicioId,sl.cuenta_analitica_id idCuenta,ca.nombre nombreCuenta, " +
				"ROUND(SUM(sl.monto),2) total " +
				"FROM caja_chica_presupuesto_lineas sl " +
				"INNER JOIN caja_chica s ON s.id = sl.caja_chica_id " +
				"INNER JOIN expedientes e ON e.id = s.expediente_id " +
				"INNER JOIN cuentas_analiticas ca ON ca.id = sl.cuenta_analitica_id " +
				"WHERE caja_chica_id = :caja_chica_id " +
				"GROUP BY cuenta_analitica_id,ca.nombre,e.ejercicio_id ";
		List<SqlRow> q = Ebean.createSqlQuery(sql)
				.setParameter("caja_chica_id",cc.id)
				.findList();

		if(q.size() > 0){
			for(SqlRow ql : q){
				cs.put(ql.getInteger("idCuenta"), ql.getString("nombreCuenta"));
				es.put(ql.getInteger("idCuenta"), ql.getInteger("ejercicioId"));
				if(vs.containsKey(ql.getInteger("idCuenta"))){
					BigDecimal vTmp = vs.get(ql.getInteger("idCuenta")).add(ql.getBigDecimal("total"));
					vs.put(ql.getInteger("idCuenta"), vTmp);
				}else{
					vs.put(ql.getInteger("idCuenta"), ql.getBigDecimal("total"));
				}
			}
		}


		for (Entry<Integer, BigDecimal> e: vs.entrySet()) {
	        System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
	        Integer cuentaId = e.getKey();
	        BigDecimal saldoDisponible = getSaldoPresupuestarioPorCuenta(cuentaId,es.get(cuentaId));
	        BigDecimal saldoAImputar = e.getValue();
	        BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);
	        ObjectNode restJs = Json.newObject();
	        if(saldoDisponible.compareTo(saldoAImputar) == 0 || saldoDisponible.compareTo(saldoAImputar) == 1){
	        	//Todo bien tiene saldo
	        	restJs.put("success", true);
	        	restJs.put("cuenta", cs.get(cuentaId));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);

	        }else{
	        	//Todo mal no tiene saldo
	        	restJs.put("success", false);
	        	restJs.put("cuenta", cs.get(cuentaId));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }
	        nodo.add(restJs);
		}

		return nodo;
	}


	public static ArrayNode controlSaldo(List<Solicitud> ls,Integer ejercicioId){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();

		Map<Integer, BigDecimal> vs = new HashMap<Integer, BigDecimal>();
		Map<Integer, String> cs = new HashMap<Integer, String>();
		Map<Integer, Integer> es = new HashMap<Integer, Integer>();

		for(Solicitud s: ls){
			String sql = "SELECT e.ejercicio_id ejercicioId,sl.cuenta_analitica_id idCuenta,ca.nombre nombreCuenta, " +
					"ROUND(SUM(sl.cantidad*sl.precio_estimado),2) total " +
					"FROM solicitud_lineas sl " +
					"INNER JOIN solicitudes s ON s.id = sl.solicitud_id " +
					"INNER JOIN expedientes e ON e.id = s.expediente_id " +
					"INNER JOIN cuentas_analiticas ca ON ca.id = sl.cuenta_analitica_id " +
					"WHERE solicitud_id = :solicitudId " +
					"GROUP BY cuenta_analitica_id,ca.nombre,e.ejercicio_id ";
			List<SqlRow> q = Ebean.createSqlQuery(sql)
					.setParameter("solicitudId",s.id)
					.findList();

			if(q.size() > 0){
				for(SqlRow ql : q){
					cs.put(ql.getInteger("idCuenta"), ql.getString("nombreCuenta"));
					es.put(ql.getInteger("idCuenta"), ql.getInteger("ejercicioId"));
					if(vs.containsKey(ql.getInteger("idCuenta"))){
						BigDecimal vTmp = vs.get(ql.getInteger("idCuenta")).add(ql.getBigDecimal("total"));
						vs.put(ql.getInteger("idCuenta"), vTmp);
					}else{
						vs.put(ql.getInteger("idCuenta"), ql.getBigDecimal("total"));
					}
				}
			}
		}

		for (Entry<Integer, BigDecimal> e: vs.entrySet()) {
	        System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
	        Integer cuentaId = e.getKey();
	        BigDecimal saldoDisponible = getSaldoPresupuestarioPorCuenta(cuentaId,es.get(cuentaId));
	        BigDecimal saldoAImputar = e.getValue();
	        BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);
	        ObjectNode restJs = Json.newObject();
	        if(saldoDisponible.compareTo(saldoAImputar) == 0 || saldoDisponible.compareTo(saldoAImputar) == 1){
	        	//Todo bien tiene saldo
	        	restJs.put("success", true);
	        	restJs.put("cuenta", cs.get(cuentaId));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);

	        }else{
	        	//Todo mal no tiene saldo
	        	restJs.put("success", false);
	        	restJs.put("cuenta", cs.get(cuentaId));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }
	        nodo.add(restJs);
		}

		return nodo;
	}

	public static ArrayNode controlSaldoPreventivoOrdenLineaAjuste(Orden o,OrdenLineaAjuste ola){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		BigDecimal saldoAImputar = ola.cantidad.multiply(ola.precio).setScale(2, BigDecimal.ROUND_HALF_UP);


		Integer ca = new Integer(CuentaAnalitica.find.byId(ola.cuenta_analitica_id).cuenta_reporta_id.intValue());
		Integer e = new Integer(o.expediente_id.intValue());
		CuentaAnalitica caPadre = CuentaAnalitica.find.byId(new Long(ca));

		BigDecimal saldoDisponible = getSaldoPreventivoPorCuentaPorExpediente(ca,e);
		BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);

		Logger.debug("saldoPresente:"+saldoPresente);
		Logger.debug("saldoDisponible:"+saldoDisponible);
		Logger.debug("saldoAImputar:"+saldoAImputar);
		Logger.debug("saldoDisponible.compareTo(saldoAImputar):"+saldoDisponible.compareTo(saldoAImputar));

		if(saldoDisponible.compareTo(BigDecimal.ZERO) == -1 || saldoDisponible.compareTo(saldoAImputar) == 0 || saldoDisponible.compareTo(saldoAImputar) == 1){
        	//Todo bien tiene saldo
        	restJs.put("success", true);
        	restJs.put("cuenta", caPadre.nombre);
        	restJs.put("expediente", o.expediente.nombre);
        	restJs.put("saldoPresente", saldoPresente);
        	restJs.put("saldoDisponible", saldoDisponible);
        	restJs.put("saldoAImputar", saldoAImputar);
        }else{
        	//Todo mal no tiene saldo
        	restJs.put("success", false);
        	restJs.put("cuenta", caPadre.nombre);
        	restJs.put("expediente", o.expediente.nombre);
        	restJs.put("saldoPresente", saldoPresente);
        	restJs.put("saldoDisponible", saldoDisponible);
        	restJs.put("saldoAImputar", saldoAImputar);
        }
        nodo.add(restJs);

		return nodo;
	}


	public static ArrayNode controlSaldoPreventivoCertificacionCompraLineaAjuste(CertificacionCompra o,CertificacionesComprasLineaAjustes ola){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();

		BigDecimal saldoAImputar = ola.cantidad.multiply(ola.precio);


		Integer ca = new Integer(CuentaAnalitica.find.byId(ola.cuenta_analitica_id).cuenta_reporta_id.intValue());
		Integer e = new Integer(o.expediente_id.intValue());
		CuentaAnalitica caPadre = CuentaAnalitica.find.byId(new Long(ca));

		BigDecimal saldoDisponible = getSaldoDefinitivoPorCuentaPorExpediente(ca,e);

		BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);

		Logger.debug("saldoDisponible "+saldoDisponible);
	    Logger.debug("saldoPresente "+saldoPresente);
	    Logger.debug("saldoDisponible.compareTo(saldoAImputar) "+saldoDisponible.compareTo(saldoAImputar));




        if(saldoAImputar.compareTo(BigDecimal.ZERO) < 0 || saldoDisponible.compareTo(saldoAImputar) == 0 || saldoDisponible.compareTo(saldoAImputar) == 1){
        	//Todo bien tiene saldo
        	restJs.put("success", true);
        	restJs.put("cuenta", caPadre.nombre);
        	restJs.put("expediente", o.expediente.nombre);
        	restJs.put("saldoPresente", saldoPresente);
        	restJs.put("saldoDisponible", saldoDisponible);
        	restJs.put("saldoAImputar", saldoAImputar);
        }else{
        	//Todo mal no tiene saldo
        	restJs.put("success", false);
        	restJs.put("cuenta", caPadre.nombre);
        	restJs.put("expediente", o.expediente.nombre);
        	restJs.put("saldoPresente", saldoPresente);
        	restJs.put("saldoDisponible", saldoDisponible);
        	restJs.put("saldoAImputar", saldoAImputar);
        }
        nodo.add(restJs);

		return nodo;
	}

	public static ArrayNode controlSaldoPreventivo(List<Orden> lo){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();

		Map<String, BigDecimal> vs = new HashMap<String, BigDecimal>();
		Map<Integer, String> cs = new HashMap<Integer, String>();
		Map<Integer, String> es = new HashMap<Integer, String>();

		for(Orden o: lo){
			String sql = "SELECT ca.cuenta_reporta_id idCuenta,cap.nombre nombreCuenta,o.expediente_id expedienteId,e.nombre nombreExpediente, " +
					"ROUND(SUM(CAST(ol.cantidad*ol.precio AS numeric)),2) total " +
					"FROM orden_lineas ol " +
					"INNER JOIN cuentas_analiticas ca ON ca.id = ol.cuenta_analitica_id " +
					"INNER JOIN cuentas_analiticas cap ON cap.id = ca.cuenta_reporta_id " +
					"INNER JOIN ordenes o ON o.id = ol.orden_id " +
					"INNER JOIN expedientes e ON e.id = o.expediente_id " +
					"WHERE orden_id = :ordenId " +
					"GROUP BY idCuenta,cap.nombre,o.expediente_id,e.nombre ";
			List<SqlRow> q = Ebean.createSqlQuery(sql)
							.setParameter("ordenId",o.id)
							.findList();

			if(q.size() > 0){
				for(SqlRow ql : q){
					String hashCuentaExpediente = ql.getInteger("idCuenta").toString()+"&"+ql.getInteger("expedienteId");
					cs.put(ql.getInteger("idCuenta"), ql.getString("nombreCuenta"));
					cs.put(ql.getInteger("expedienteId"), ql.getString("nombreExpediente"));

					if(vs.containsKey(hashCuentaExpediente)){
						BigDecimal vTmp = vs.get(hashCuentaExpediente).add(ql.getBigDecimal("total"));
						vs.put(hashCuentaExpediente, vTmp);
					}else{
						vs.put(hashCuentaExpediente, ql.getBigDecimal("total"));
					}
				}
			}
		}
		for (Entry<String, BigDecimal> e: vs.entrySet()) {
	        System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
	        String hash = e.getKey();
	        String[] splitHash = hash.split("&");
	        System.out.println("["+splitHash+" -- "+hash+"]");
	        Integer idCuenta  = new Integer(splitHash[0]);
	        Integer idExpediente = new Integer(splitHash[1]);

	        BigDecimal saldoDisponible = getSaldoPreventivoPorCuentaPorExpediente(idCuenta,idExpediente);

	        BigDecimal saldoAImputar = e.getValue();
	        BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);
	        ObjectNode restJs = Json.newObject();
	        if(saldoDisponible.compareTo(saldoAImputar) == 0 || saldoDisponible.compareTo(saldoAImputar) == 1){
	        	//Todo bien tiene saldo
	        	restJs.put("success", true);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }else{
	        	//Todo mal no tiene saldo
	        	restJs.put("success", false);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }
	        nodo.add(restJs);
		}


		return nodo;
	}

	public static ArrayNode controlSaldoPreventivoCajaChica(CajaChica lo){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();

		Map<String, BigDecimal> vs = new HashMap<String, BigDecimal>();
		Map<Integer, String> cs = new HashMap<Integer, String>();
		Map<Integer, String> es = new HashMap<Integer, String>();


		String sql = "SELECT ca.cuenta_reporta_id idCuenta,cap.nombre nombreCuenta,o.expediente_id expedienteId,e.nombre nombreExpediente, " +
				"ROUND(SUM(CAST(ol.cantidad*ol.precio AS numeric)),2) total " +
				"FROM caja_chica_movimientos ol " +
				"INNER JOIN cuentas_analiticas ca ON ca.id = ol.cuenta_analitica_id " +
				"INNER JOIN cuentas_analiticas cap ON cap.id = ca.cuenta_reporta_id " +
				"INNER JOIN caja_chica o ON o.id = ol.caja_chica_id " +
				"INNER JOIN expedientes e ON e.id = o.expediente_id " +
				"WHERE caja_chica_id = :caja_chica_id " +
				"GROUP BY idCuenta,cap.nombre,o.expediente_id,e.nombre ";
		List<SqlRow> q = Ebean.createSqlQuery(sql)
						.setParameter("caja_chica_id",lo.id)
						.findList();

		if(q.size() > 0){
			for(SqlRow ql : q){
				String hashCuentaExpediente = ql.getInteger("idCuenta").toString()+"&"+ql.getInteger("expedienteId");
				cs.put(ql.getInteger("idCuenta"), ql.getString("nombreCuenta"));
				cs.put(ql.getInteger("expedienteId"), ql.getString("nombreExpediente"));

				if(vs.containsKey(hashCuentaExpediente)){
					BigDecimal vTmp = vs.get(hashCuentaExpediente).add(ql.getBigDecimal("total"));
					vs.put(hashCuentaExpediente, vTmp);
				}else{
					vs.put(hashCuentaExpediente, ql.getBigDecimal("total"));
				}
			}
		}

		for (Entry<String, BigDecimal> e: vs.entrySet()) {
	        System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
	        String hash = e.getKey();
	        String[] splitHash = hash.split("&");
	        System.out.println("["+splitHash+" -- "+hash+"]");
	        Integer idCuenta  = new Integer(splitHash[0]);
	        Integer idExpediente = new Integer(splitHash[1]);

	        Logger.debug("xxxxxxxxxxxxxxxx "+idCuenta);
	        Logger.debug("xxxxxxxxxxxxxxxx "+idExpediente);

	        //BigDecimal saldoDisponible = getSaldoPreventivoPorCuentaPorExpediente(idCuenta,idExpediente);
	        BigDecimal saldoDisponible = getSaldoPreventivoPorCuentaPorExpedienteCajaChica(idCuenta,idExpediente,lo.id);

	        BigDecimal saldoAImputar = e.getValue();
	        BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);

	        Logger.debug("xxxxxxxxxxxxxxxx "+idCuenta);
	        Logger.debug("xxxxxxxxxxxxxxxx "+idExpediente);
	        Logger.debug("xxxxxxxxxxxxxxxx "+saldoDisponible);
	        Logger.debug("xxxxxxxxxxxxxxxx "+saldoAImputar);
	        Logger.debug("xxxxxxxxxxxxxxxx "+saldoPresente.compareTo(BigDecimal.ZERO));
	        Logger.debug("xxxxxxxxxxxxxxxx "+saldoDisponible.compareTo(saldoAImputar));

	        ObjectNode restJs = Json.newObject();
	        if(saldoPresente.compareTo(BigDecimal.ZERO) >= 0 && saldoDisponible.compareTo(saldoAImputar) >= 0){
	        	//Todo bien tiene saldo
	        	restJs.put("success", true);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }else{
	        	//Todo mal no tiene saldo
	        	restJs.put("success", false);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }
	        nodo.add(restJs);
		}


		return nodo;
	}

	public static ArrayNode controlSaldoDefinitivoCertificacionServicio(List<Integer> lo){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();

		Map<String, BigDecimal> vs = new HashMap<String, BigDecimal>();
		Map<Integer, String> cs = new HashMap<Integer, String>();
		Map<Integer, String> es = new HashMap<Integer, String>();

		for(Integer o: lo){

			String sql = " SELECT ca.cuenta_reporta_id idCuenta,cap.nombre nombreCuenta,ord.expediente_id expedienteId, "+
					" e.nombre nombreExpediente, "+
					" ROUND(SUM(CAST(ol.cantidad*ol.precio AS numeric)),2) "+
					" - "+
					" COALESCE(SUM(CAST((precio*cantidad*descuento)/100 AS numeric)),0) total "+
					" FROM certificaciones_servicios_lineas ol "+
					" INNER JOIN cuentas_analiticas ca ON ca.id = ol.cuenta_analitica_id "+
					" INNER JOIN cuentas_analiticas cap ON cap.id = ca.cuenta_reporta_id "+
					" INNER JOIN certificaciones_servicios o ON o.id = ol.certificaciones_servicio_id "+
					" INNER JOIN ordenes_provision op ON op.id = o.orden_provision_id "+
					" INNER JOIN ordenes ord ON ord.id = op.orden_compra_id "+
					" INNER JOIN expedientes e ON e.id = ord.expediente_id "+
					" WHERE certificaciones_servicio_id = :certificaciones_servicio_id "+
					" GROUP BY idCuenta,cap.nombre,ord.expediente_id,e.nombre";
			List<SqlRow> q = Ebean.createSqlQuery(sql)
							.setParameter("certificaciones_servicio_id",o)
							.findList();

			if(q.size() > 0){
				for(SqlRow ql : q){
					String hashCuentaExpediente = ql.getInteger("idCuenta").toString()+"&"+ql.getInteger("expedienteId");
					cs.put(ql.getInteger("idCuenta"), ql.getString("nombreCuenta"));
					cs.put(ql.getInteger("expedienteId"), ql.getString("nombreExpediente"));

					if(vs.containsKey(hashCuentaExpediente)){
						BigDecimal vTmp = vs.get(hashCuentaExpediente).add(ql.getBigDecimal("total"));
						vs.put(hashCuentaExpediente, vTmp);
					}else{
						Logger.debug("entra en 1 "+ hashCuentaExpediente +" - "+ql.getBigDecimal("total"));
						vs.put(hashCuentaExpediente, ql.getBigDecimal("total"));
					}
				}
			}
		}
		for (Entry<String, BigDecimal> e: vs.entrySet()) {
	        System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
	        String hash = e.getKey();
	        String[] splitHash = hash.split("&");
	        System.out.println("["+splitHash+" -- "+hash+"]");
	        Integer idCuenta  = new Integer(splitHash[0]);
	        Integer idExpediente = new Integer(splitHash[1]);

	        BigDecimal saldoDisponible = getSaldoDefinitivoPorCuentaPorExpediente(idCuenta,idExpediente);

	        BigDecimal saldoAImputar = e.getValue();
	        BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);
	        ObjectNode restJs = Json.newObject();
	        if(saldoDisponible.compareTo(saldoAImputar) == 0 || saldoDisponible.compareTo(saldoAImputar) == 1){
	        	//Todo bien tiene saldo
	        	restJs.put("success", true);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }else{
	        	//Todo mal no tiene saldo
	        	restJs.put("success", false);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }
	        nodo.add(restJs);
		}


		return nodo;
	}

	public static ArrayNode controlSaldoDefinitivoCertificacionesCompras(List<Integer> lo){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();

		Map<String, BigDecimal> vs = new HashMap<String, BigDecimal>();
		Map<Integer, String> cs = new HashMap<Integer, String>();
		Map<Integer, String> es = new HashMap<Integer, String>();

		for(Integer o: lo){

			String sql = "SELECT ca.cuenta_reporta_id idCuenta,cap.nombre nombreCuenta,o.expediente_id expedienteId," +
					"e.nombre nombreExpediente, " +
					//"SUM(ROUND( CAST(ol.cantidad*ol.precio AS numeric),2)) total " +
					"ROUND(SUM(CAST(ol.cantidad*ol.precio AS numeric)) " +
					"- " +
					//"COALESCE(SUM(CAST((precio*cantidad*descuento)/100 AS numeric)),0),2) total " +
					"COALESCE(ROUND(SUM(CAST((precio*cantidad*descuento)/100 AS numeric)),2),0),2) total " +
					"FROM certificaciones_compras_lineas ol " +
					"INNER JOIN cuentas_analiticas ca ON ca.id = ol.cuenta_analitica_id " +
					"INNER JOIN cuentas_analiticas cap ON cap.id = ca.cuenta_reporta_id " +
					"INNER JOIN certificaciones_compras o ON o.id = ol.certificacion_compra_id " +
					"INNER JOIN expedientes e ON e.id = o.expediente_id " +
					"WHERE certificacion_compra_id = :certificacion_id " +
					"GROUP BY idCuenta,cap.nombre,o.expediente_id,e.nombre ";
			List<SqlRow> q = Ebean.createSqlQuery(sql)
							.setParameter("certificacion_id",o)
							.findList();

			if(q.size() > 0){
				for(SqlRow ql : q){
					String hashCuentaExpediente = ql.getInteger("idCuenta").toString()+"&"+ql.getInteger("expedienteId");
					cs.put(ql.getInteger("idCuenta"), ql.getString("nombreCuenta"));
					cs.put(ql.getInteger("expedienteId"), ql.getString("nombreExpediente"));

					if(vs.containsKey(hashCuentaExpediente)){
						BigDecimal vTmp = vs.get(hashCuentaExpediente).add(ql.getBigDecimal("total"));
						vs.put(hashCuentaExpediente, vTmp);
					}else{
						Logger.debug("entra en 1 "+ hashCuentaExpediente +" - "+ql.getBigDecimal("total"));
						vs.put(hashCuentaExpediente, ql.getBigDecimal("total"));
					}
				}
			}
		}
		for (Entry<String, BigDecimal> e: vs.entrySet()) {
	        System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
	        String hash = e.getKey();
	        String[] splitHash = hash.split("&");
	        System.out.println("["+splitHash+" -- "+hash+"]");
	        Integer idCuenta  = new Integer(splitHash[0]);
	        Integer idExpediente = new Integer(splitHash[1]);

	        BigDecimal saldoDisponible = getSaldoDefinitivoPorCuentaPorExpediente(idCuenta,idExpediente);

	        BigDecimal saldoAImputar = e.getValue();
	        BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);




	        ObjectNode restJs = Json.newObject();
	        if(saldoDisponible.compareTo(saldoAImputar) == 0 || saldoDisponible.compareTo(saldoAImputar) == 1){
	        	//Todo bien tiene saldo
	        	restJs.put("success", true);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }else{
	        	//Todo mal no tiene saldo
	        	restJs.put("success", false);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }
	        nodo.add(restJs);
		}


		return nodo;
	}

	public static ArrayNode controlSaldoDefinitivo(List<Integer> lo){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();

		Map<String, BigDecimal> vs = new HashMap<String, BigDecimal>();
		Map<Integer, String> cs = new HashMap<Integer, String>();
		Map<Integer, String> es = new HashMap<Integer, String>();

		for(Integer o: lo){

			String sql = "SELECT ca.cuenta_reporta_id idCuenta,cap.nombre nombreCuenta,o.expediente_id expedienteId," +
					"e.nombre nombreExpediente, " +
					//"SUM(ROUND( CAST(ol.cantidad*ol.precio AS numeric),2)) total " +
					"ROUND(ROUND(SUM(CAST(ol.cantidad*ol.precio AS numeric)),2) " +
					"- " +
					"COALESCE(ROUND(SUM(CAST((precio*cantidad*descuento)/100 AS numeric)),2),0),2) total " +
					"FROM certificaciones_lineas ol " +
					"INNER JOIN cuentas_analiticas ca ON ca.id = ol.cuenta_analitica_id " +
					"INNER JOIN cuentas_analiticas cap ON cap.id = ca.cuenta_reporta_id " +
					"INNER JOIN certificaciones o ON o.id = ol.certificacion_id " +
					"INNER JOIN expedientes e ON e.id = o.expediente_id " +
					"WHERE certificacion_id = :certificacion_id " +
					"GROUP BY idCuenta,cap.nombre,o.expediente_id,e.nombre ";
			List<SqlRow> q = Ebean.createSqlQuery(sql)
							.setParameter("certificacion_id",o)
							.findList();

			if(q.size() > 0){
				for(SqlRow ql : q){
					String hashCuentaExpediente = ql.getInteger("idCuenta").toString()+"&"+ql.getInteger("expedienteId");
					cs.put(ql.getInteger("idCuenta"), ql.getString("nombreCuenta"));
					cs.put(ql.getInteger("expedienteId"), ql.getString("nombreExpediente"));

					if(vs.containsKey(hashCuentaExpediente)){
						BigDecimal vTmp = vs.get(hashCuentaExpediente).add(ql.getBigDecimal("total"));
						vs.put(hashCuentaExpediente, vTmp);
					}else{
						Logger.debug("entra en 1 "+ hashCuentaExpediente +" - "+ql.getBigDecimal("total"));
						vs.put(hashCuentaExpediente, ql.getBigDecimal("total"));
					}
				}
			}
		}
		for (Entry<String, BigDecimal> e: vs.entrySet()) {
	        System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
	        String hash = e.getKey();
	        String[] splitHash = hash.split("&");
	        System.out.println("["+splitHash+" -- "+hash+"]");
	        Integer idCuenta  = new Integer(splitHash[0]);
	        Integer idExpediente = new Integer(splitHash[1]);

	        BigDecimal saldoDisponible = getSaldoDefinitivoPorCuentaPorExpediente(idCuenta,idExpediente);

	        BigDecimal saldoAImputar = e.getValue();
	        BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);
	        ObjectNode restJs = Json.newObject();
	        if(saldoDisponible.compareTo(saldoAImputar) == 0 || saldoDisponible.compareTo(saldoAImputar) == 1){
	        	//Todo bien tiene saldo
	        	restJs.put("success", true);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }else{
	        	//Todo mal no tiene saldo
	        	restJs.put("success", false);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }
	        nodo.add(restJs);
		}


		return nodo;
	}

	public static ArrayNode controlSaldoObligacion(List<Integer> lo){
		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();

		Map<String, BigDecimal> vs = new HashMap<String, BigDecimal>();
		Map<Integer, String> cs = new HashMap<Integer, String>();
		Map<Integer, String> es = new HashMap<Integer, String>();

		for(Integer o: lo){

			String sql = "SELECT ca.cuenta_reporta_id idCuenta,cap.nombre nombreCuenta,o.expediente_id expedienteId,e.nombre nombreExpediente, " +
					"ROUND(SUM(CAST(ol.cantidad*ol.precio AS numeric)),2) total " +
					"FROM factura_lineas ol " +
					"INNER JOIN cuentas_analiticas ca ON ca.id = ol.cuenta_analitica_id " +
					"INNER JOIN cuentas_analiticas cap ON cap.id = ca.cuenta_reporta_id " +
					"INNER JOIN facturas o ON o.id = ol.factura_id " +
					"INNER JOIN expedientes e ON e.id = o.expediente_id " +
					"WHERE factura_id = :factura_id " +
					"GROUP BY idCuenta,cap.nombre,o.expediente_id,e.nombre ";
			List<SqlRow> q = Ebean.createSqlQuery(sql)
							.setParameter("factura_id",o)
							.findList();

			if(q.size() > 0){
				for(SqlRow ql : q){
					String hashCuentaExpediente = ql.getInteger("idCuenta").toString()+"&"+ql.getInteger("expedienteId");
					cs.put(ql.getInteger("idCuenta"), ql.getString("nombreCuenta"));
					cs.put(ql.getInteger("expedienteId"), ql.getString("nombreExpediente"));

					if(vs.containsKey(hashCuentaExpediente)){
						BigDecimal vTmp = vs.get(hashCuentaExpediente).add(ql.getBigDecimal("total"));
						vs.put(hashCuentaExpediente, vTmp);
					}else{
						vs.put(hashCuentaExpediente, ql.getBigDecimal("total"));
					}
				}
			}
		}
		for (Entry<String, BigDecimal> e: vs.entrySet()) {
	        System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
	        String hash = e.getKey();
	        String[] splitHash = hash.split("&");
	        System.out.println("["+splitHash+" -- "+hash+"]");
	        Integer idCuenta  = new Integer(splitHash[0]);
	        Integer idExpediente = new Integer(splitHash[1]);

	        BigDecimal saldoDisponible = getSaldoObligacionPorCuentaPorExpediente(idCuenta,idExpediente);

	        BigDecimal saldoAImputar = e.getValue();
	        BigDecimal saldoPresente = saldoDisponible.subtract(saldoAImputar);
	        ObjectNode restJs = Json.newObject();
	        if(saldoDisponible.compareTo(saldoAImputar) == 0 || saldoDisponible.compareTo(saldoAImputar) == 1){
	        	//Todo bien tiene saldo
	        	restJs.put("success", true);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }else{
	        	//Todo mal no tiene saldo
	        	restJs.put("success", false);
	        	restJs.put("cuenta", cs.get(idCuenta));
	        	restJs.put("expediente", cs.get(idExpediente));
	        	restJs.put("saldoPresente", saldoPresente);
	        	restJs.put("saldoDisponible", saldoDisponible);
	        	restJs.put("saldoAImputar", saldoAImputar);
	        }
	        nodo.add(restJs);
		}


		return nodo;
	}

	public static ArrayNode controlSaldoPreventivoContraFactura(List<Factura> lo){

		ObjectNode obj = Json.newObject();
	    ArrayNode nodo = obj.arrayNode();
		ObjectNode restJs = Json.newObject();
		Map<Expediente, BigDecimal> expMonto = new HashMap<Expediente, BigDecimal>();
		Map<Expediente, Expediente> expPadreHijo = new HashMap<Expediente, Expediente>();

		for(Factura o: lo){
			Expediente exp = o.expediente;

			if(o.expediente.parent_id != null && !o.expediente.licitacion){
				//si es un hijo cargo el exp padre
				exp = o.expediente.parent;
			}else{
				Expediente eh = Expediente.find.where().eq("parent_id", o.expediente.id).ne("residuo_pasivo", false).setMaxRows(1).findUnique();
				if(eh != null){
					expPadreHijo.put(o.expediente, eh);
				}
			}

			if(expMonto.containsKey(exp)){
				BigDecimal mtmp = expMonto.get(exp);
				mtmp = mtmp.add(o.base);
				expMonto.put(exp, mtmp);
			}else{
				expMonto.put(exp, o.base);
			}
		}

		for (Map.Entry<Expediente, BigDecimal> entry : expMonto.entrySet()) {
			Expediente key = entry.getKey();
			BigDecimal value = entry.getValue();


			List<Long> lExp = new ArrayList<Long>();
			lExp.add(key.id);
			if(expPadreHijo.containsKey(key)){
				lExp.add(expPadreHijo.get(key).id);
			}


			List<Factura> fx = Factura.find.where().in("expediente_id", lExp).eq("state_id",Estado.FACTURA_ESTADO_APROBADO).findList();
			for(Factura fx2 : fx){
				value = value.add(fx2.getBase().subtract(fx2.getTotalReintegros()));
			}

			String sql = "SELECT "+
			 "COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 5 THEN (haber - debe) END),2),0)  as saldo, "+
			 "COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 1 THEN (haber - debe) END),2),0) as preventivo, "+
			 "COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 2 THEN (haber - debe) END),2),0)  as definitivo, "+
			 "COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 3 THEN (haber - debe) END),2),0)  as obligacion, "+
			 "COALESCE(ROUND(SUM(CASE WHEN etapa_presupuestaria_id = 4 THEN (haber - debe) END),2),0)  as pago "+
			 "FROM controles_presupuestarios as cp "+
			 "INNER JOIN expedientes e ON e.id = cp.expediente_id "+
			 "INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id "+
			 "WHERE cp.expediente_id in(:ids) ";

			List<SqlRow> q = Ebean.createSqlQuery(sql).setParameter("ids",lExp).findList();

			for(SqlRow s : q){
				if(value.compareTo(s.getBigDecimal("preventivo")) > 0){
					restJs.put("success", false);
		        	restJs.put("expediente", key.getExpedienteEjercicio());
		        	restJs.put("saldoPreventivo", s.getBigDecimal("preventivo"));
		        	restJs.put("saldoFacturado", value);
		        }else{
					restJs.put("success", true);
					restJs.put("expediente", key.getExpedienteEjercicio());
		        	restJs.put("saldoPreventivo", s.getBigDecimal("preventivo"));
		        	restJs.put("saldoFacturado", value);
				}
			}
			nodo.add(restJs);

		}

		return nodo;
	}

	public static List<SqlRow> getDevengado(){

		String sql = "SELECT extract(month from e.fecha) as mon,e.ejercicio_id,ej.nombre, o.orden_rubro_id,o.deposito_id,d.nombre, "+
						"ol.cuenta_analitica_id,cap.nombre,sum(round(ol.precio * ol.cantidad::numeric,2)) + COALESCE(ajustes.total, 0) AS total "+
					"FROM ordenes o "+
					"INNER JOIN orden_lineas ol on ol.orden_id = o.id "+
					"INNER JOIN expedientes e ON e.id = o.expediente_id "+
					"INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id "+
					"INNER JOIN depositos d ON d.id = o.deposito_id "+
					"INNER JOIN cuentas_analiticas ca ON ca.id = ol.cuenta_analitica_id "+
					"INNER JOIN cuentas_analiticas cap ON cap.id = ca.id "+
					"LEFT JOIN ( "+
						   "SELECT orden_id, cuenta_analitica_id, COALESCE(sum(round(a.precio * a.cantidad, 2)), 0) AS total "+
						   "FROM orden_lineas_ajustes a "+
						   "GROUP BY a.cuenta_analitica_id, orden_id "+
					") as ajustes on ol.orden_id = ajustes.orden_id AND ajustes.cuenta_analitica_id = ol.cuenta_analitica_id "+
					"WHERE o.state_id = 11 "+
					"GROUP BY ol.cuenta_analitica_id,  ajustes.total, o.orden_rubro_id,o.deposito_id,d.nombre,cap.nombre,mon,e.ejercicio_id,ej.nombre "+
					"order by o.deposito_id,e.ejercicio_id,mon,o.orden_rubro_id,ol.cuenta_analitica_id ";

		List<SqlRow> q = Ebean.createSqlQuery(sql).findList();

		return q;
	}

	public static List<SqlRow> movimientosSaldoPreventivo(Integer idEjercicio,Integer idCuenta){

		String sql = "SELECT sum(round(haber-debe,2)) as total, "+
				"e.nombre||'/'||ej.nombre as expediente, "+
				"e.ejercicio_id, "+
				"c.create_date as fecha, "+
				"etapa_presupuestaria_id as etapa, "+
				"ca.nombre "+
				"FROM controles_presupuestarios c "+
				"INNER JOIN cuentas_analiticas ca on ca.id = cuenta_analitica_padre_id "+
				"LEFT JOIN expedientes e ON e.id=c.expediente_id "+
				"LEFT JOIN ejercicios ej ON ej.id=e.ejercicio_id "+
				"WHERE "+
				"etapa_presupuestaria_id in(5,1) "+
				"AND cuenta_analitica_padre_id = :idCuenta "+
				"AND c.ejercicio_id =:idEjercicio "+
				"GROUP BY e.id,e.nombre,ej.nombre,e.ejercicio_id,c.create_date,etapa_presupuestaria_id,ca.nombre "+
				"ORDER BY c.create_date asc,etapa_presupuestaria_id desc ";

		List<SqlRow> q = Ebean.createSqlQuery(sql)
						.setParameter("idCuenta",idCuenta)
						.setParameter("idEjercicio",idEjercicio)
						.findList();

		return q;
	}

}
