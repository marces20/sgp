package models.haberes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;

import models.Agente;
import models.Articulo;

import models.Departamento;
import models.Especialidad;
import models.Estado;
import models.Periodo;
import models.Usuario;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import server.Configuracion2;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

import com.avaje.ebean.ExpressionList;

@Entity
@Table(name = "puestos_laborales")
public class PuestoLaboral extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="puestos_laborales_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="especialidad_id", referencedColumnName="id", insertable=false, updatable=false)
	public Especialidad especialidad;
	public Long especialidad_id;

	@ManyToOne
	@JoinColumn(name="categoria_laboral_id", referencedColumnName="id", insertable=false, updatable=false)
	public CategoriaLaboral categoriaLaboral;
	@Required(message="Requiere una categoria")
	public Long categoria_laboral_id;

	@ManyToOne
	@JoinColumn(name="escala_laboral_id", referencedColumnName="id", insertable=false, updatable=false)
	public EscalaLaboral escalaLaboral;
	@Required(message="Requiere una escala")
	public Long escala_laboral_id;

	@ManyToOne
	@JoinColumn(name="centro_costo_id", referencedColumnName="id", insertable=false, updatable=false)
	public CentroCosto centrolCosto;
	@Required(message="Requiere una centro de costo")
	public Long centro_costo_id;

	@ManyToOne
	@JoinColumn(name="convenio_banco_id", referencedColumnName="id", insertable=false, updatable=false)
	public ConvenioBanco convenioBanco;
	@Required(message="Requiere un convenio")
	public Long convenio_banco_id;

	@ManyToOne
	@JoinColumn(name="legajo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Legajo legajo;
	@Required(message="Requiere un legajo")
	public Long legajo_id;

	@ManyToOne
	@JoinColumn(name="unidad_laboral_id", referencedColumnName="id", insertable=false, updatable=false)
	public UnidadLaboral unidadLaboral;
	@Required(message="Requiere una unidad")
	public Long unidad_laboral_id;

	@ManyToOne
	@JoinColumn(name="departamento_id", referencedColumnName="id", insertable=false, updatable=false)
	public Departamento departamento;
	//@Required(message="Requiere un departamento")
	public Long departamento_id;

	@ManyToOne
	@JoinColumn(name="cargo_laboral_id", referencedColumnName="id", insertable=false, updatable=false)
	public CargoLaboral cargoLaboral;
	@Required(message="Requiere un cargo")
	public Long cargo_laboral_id;

	@ManyToOne
	@JoinColumn(name="instrumento_legal_id", referencedColumnName="id", insertable=false, updatable=false)
	public InstrumentoLegal instrumentoLegal;
	@Required(message="Requiere un instrumento Legal")
	public Long instrumento_legal_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_posesion;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_baja;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_telegrama;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id;
	public Boolean activo;
	public Boolean mail_automatico;

	@DecimalComa(value="")
	public BigDecimal sueldo_referencia;

	@Required(message="Seleccion si es convencion ministerio")
	public Boolean convenio_ministerio;

	@ManyToOne
	@JoinColumn(name="liquidacion_mes_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionMes liquidacionMes;
	public Long liquidacion_mes_id;

	public Boolean dobla = false;;

	public static Model.Finder<Long,PuestoLaboral> find = new Finder<Long,PuestoLaboral>(Long.class, PuestoLaboral.class);


	public static Pagination<PuestoLaboral> page(String puesto_laboral_id,
												 String activo,
												 String fecha_desde,
												 String fecha_hasta,
												 String fecha_desde_baja,
												 String fecha_hasta_baja,
												 String cm,
												 String btnFiltro0,//borrador
												 String btnFiltro1,
												 String dobla) {

    	Pagination<PuestoLaboral> p = new Pagination<PuestoLaboral>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("legajo.agente.apellido");


    	ExpressionList<PuestoLaboral> e = find.fetch("legajo").where();

    	if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty()){
    		e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.PUESTO_LABORAL_BORRADOR);
			}
			if(!btnFiltro1.isEmpty()){
				 e = e.eq("estado_id", Estado.PUESTO_LABORAL_CONTROLADO);
			}
			e = e.endJunction();
    	}


    	if(!puesto_laboral_id.isEmpty()){
    		e.eq("id", Integer.parseInt(puesto_laboral_id));
    	}

    	if(!activo.isEmpty()){
    		e.eq("t0.activo", new Boolean(activo));
    	}

		if(!fecha_desde.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		e.ge("fecha_posesion", fod);
    	}

		if(!fecha_hasta.isEmpty()){
    		Date foh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		e.le("fecha_posesion", foh);
    	}

		if(!fecha_desde_baja.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_desde_baja, "dd/MM/yyyy");
    		e.ge("fecha_baja", fod);
    	}

		if(!fecha_hasta_baja.isEmpty()){
    		Date foh = DateUtils.formatDate(fecha_hasta_baja, "dd/MM/yyyy");
    		e.le("fecha_baja", foh);
    	}

		if(!cm.isEmpty()){
    		if(cm.compareToIgnoreCase("SI") == 0){
    			e.eq("convenio_ministerio", true);
    		}else{
    			e.eq("convenio_ministerio", false);
    		}
    	}

		if(!dobla.isEmpty()){
    		if(dobla.compareToIgnoreCase("SI") == 0){
    			e.eq("dobla", true);
    		}else{
    			e.eq("dobla", false);
    		}
    	}

    	p.setExpressionList(e);
    	return p;
    }

	public String getNumeroCuenta(){
		String numero = "";

		String sql = "select cb.numero_cuenta numero_cuenta from cuenta_bancarias cb " +
					 "inner join proveedores p on p.id = cb.proveedor_id " +
					 "inner join agentes a on a.id = p.agente_id " +
					 "inner join legajos l on a.id = l.agente_id " +
					 "inner join puestos_laborales pl on pl.legajo_id = l.id " +
					 "where cb.activo = true and cb.predeterminada = true and pl.id = :id limit 1 ";

		SqlRow s = Ebean.createSqlQuery(sql)
				.setParameter("id", this.id)
				.findUnique();
		if(!s.isEmpty()){
			numero = s.getString("numero_cuenta");
		}

		return numero;
	}

	public List<PuestoLaboral> getDataSuggestTodos(String input,Integer limit){
		List<PuestoLaboral> l = find.fetch("legajo").where()
				.ilike("legajo.agente.apellido", "%" + input + "%")
				.setMaxRows(limit).orderBy("legajo.agente.apellido")
			    .findList();

		return l;
	}

	public List<PuestoLaboral> getDataSuggest(String input,Integer limit){
		List<PuestoLaboral> l = find.fetch("legajo").where().eq("activo",true)
				.ilike("legajo.agente.apellido", "%" + input + "%")
				.setMaxRows(limit).orderBy("legajo.agente.apellido")
			    .findList();

		return l;
	}

	public static Integer preliquidarPuestoFinal(Integer idLiquidacion,Integer idPuesto){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Integer ret = new Integer(0);

		try {

			conn = play.db.DB.getConnection();

			stmt = conn.prepareStatement("SELECT bc_liquidacionfinal(?,?)");

			stmt.setInt(1, idPuesto);
			stmt.setInt(2, idLiquidacion);

			rs = stmt.executeQuery();

			if (rs.next()) {
				ret = rs.getInt(1);
			}


		}catch (SQLException e) {
			Logger.error("Error preliquidar: "+e);
			ret = -1;
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }

		return ret;
	}

	public static Integer preliquidarPuesto(Integer idLiquidacion,Integer idPuesto){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Integer ret = new Integer(0);

		try {

			conn = play.db.DB.getConnection();

			stmt = conn.prepareStatement("SELECT pre_liquidacion(?,?)");
			stmt.setInt(1, idLiquidacion);
			stmt.setInt(2, idPuesto);

			rs = stmt.executeQuery();

			if (rs.next()) {
				ret = rs.getInt(1);
			}


		}catch (SQLException e) {
			Logger.error("Error preliquidar: "+e);
			ret = -1;
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }

		return ret;
	}

	public static Integer crearNovedadesBasicas(List<Integer> plSeleccionados,Integer periodo_desde_id,Integer  periodo_hasta_id){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Integer ret = new Integer(0);
		for(Integer x :plSeleccionados){
			try {

				conn = play.db.DB.getConnection();

				stmt = conn.prepareStatement("SELECT carganovedadesautomatico(?,?,?)");
				stmt.setInt(1, x);
				stmt.setInt(2, periodo_desde_id);
				stmt.setInt(3, periodo_hasta_id);

				rs = stmt.executeQuery();

				if (rs.next()) {
					ret = ret +rs.getInt(1);
				}


			}catch (SQLException e) {
				Logger.error("Error crearNovedadesBasicas: "+e);
				ret = -1;
	        } finally {
	        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
	        	if (rs != null) try { rs.close(); } catch (Exception e) { }
	            if (conn != null) try { conn.close(); } catch (Exception e) { }
	        }
		}
		return ret;
	}

	public static List<SqlRow> getLiquidacionDetallePorTipo(Long idPeriodo,Long idPuestoLaboral,Integer tipoConceptos){
		String sql = "SELECT  lc.denominacion concepto, ld.importe importe,ld.cantidad cantidad "+
					   "FROM liquidacion_detalles ld " +
					   "INNER JOIN liquidacion_puestos lp on ld.liquidacion_puesto_id = lp.id "+
					   "INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+
					   "INNER JOIN liquidacion_conceptos lc ON ld.liquidacion_concepto_id = lc.id "+
					   "INNER JOIN liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "WHERE lcc.id =:tipoConceptos " +
					   "AND lp.puesto_laboral_id = :idPuestoLaboral "+
		 			   "AND lm.periodo_id = :idPeriodo ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("idPeriodo",idPeriodo);
		sqlQuery.setParameter("idPuestoLaboral",idPuestoLaboral);
		sqlQuery.setParameter("tipoConceptos",tipoConceptos);

		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static List<SqlRow> getTotalesPorProfesionPeriodo(Long idPeriodo,Long idProfesion,Boolean cm,Long tipoRelacion,Long idOrganigrama){
		//Periodo p = Periodo.find.byId(idPeriodo);

		String sql = "SELECT lm.periodo_id idPeriodo,pl.id idPuestoLaboral,pr.id,pr.nombre profesion,a.id,a.apellido nombre,a.dni dni,t.id idTipoRelacion," +
						"t.nombre tipoRelacion,pl.convenio_ministerio cm,o.nombre organigrama, "+
						"SUM(COALESCE(haber.importe, 0)) haber, "+
						"SUM(COALESCE(guardias.importe, 0)) guardias, "+
						"SUM(COALESCE(produccion.importe, 0)) produccion, "+
						"SUM(COALESCE(adicionales.importe, 0)) adicional, "+
						"SUM(COALESCE(descuentos.importe, 0)) descuentos, "+
						"SUM(COALESCE(haberes.importe, 0) - COALESCE(descu.importe, 0)) neto "+
						"FROM puestos_laborales pl "+
					 "INNER JOIN legajos l on l.id = pl.legajo_id "+
					 "INNER JOIN agentes a on a.id = l.agente_id "+
					 "INNER JOIN organigramas o on o.id = a.organigrama_id "+
					 "INNER JOIN tipo_relacion_laborales t on CAST (a.tipo_relacion_laboral AS INTEGER) = t.id "+
					 "INNER JOIN profesiones pr on pr.id = a.profesion_id "+
					 "INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+
					 "INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "where lc.liquidacion_concepto_tipo_id in (1,2) group by ld.liquidacion_puesto_id "+
					   ") haberes on haberes.liquidacion_puesto_id = lp.id "+

					"left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "where lc.liquidacion_concepto_tipo_id in (3,4) group by ld.liquidacion_puesto_id "+
					   ") descu on descu.liquidacion_puesto_id = lp.id "+

					"left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 1 group by ld.liquidacion_puesto_id "+
					 ") haber on haber.liquidacion_puesto_id = lp.id "+  //HABER

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 2 group by ld.liquidacion_puesto_id "+
					 ") guardias on guardias.liquidacion_puesto_id = lp.id "+ //GUARDIAS

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 3 group by ld.liquidacion_puesto_id "+
					 ") produccion on produccion.liquidacion_puesto_id = lp.id "+//PRODUCCION

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 5 group by ld.liquidacion_puesto_id "+
					 ") descuentos on descuentos.liquidacion_puesto_id = lp.id "+ //DESCUENTOS

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 6 group by ld.liquidacion_puesto_id "+
					 ") adicionales on adicionales.liquidacion_puesto_id = lp.id "+ //ADICIONALES

					 "WHERE  lm.liquidacion_tipo_id = 1 AND lm.periodo_id = :periodo_id ";

					 if(idProfesion != null){
						 sql += "AND a.profesion_id = :profesion_id ";
					 }
					 if(tipoRelacion != null){
						 sql += "AND t.id = :tipoRelacion ";
					 }
					 if(cm != null){
						 sql += "AND pl.convenio_ministerio = :cm ";
					 }
					 if(idOrganigrama != null){
						 sql += "AND a.organigrama_id = :idOrganigrama ";
					 }

					 sql += "GROUP BY lm.periodo_id, pl.id,pr.id,pr.nombre,a.id,a.apellido,a.dni,t.id,t.nombre,pl.convenio_ministerio,o.nombre "+
					 "order by t.nombre,a.apellido ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",idPeriodo);
		 if(idProfesion != null){
			 sqlQuery.setParameter("profesion_id",idProfesion);
		 }
		 if(tipoRelacion != null){
			 sqlQuery.setParameter("tipoRelacion",tipoRelacion);
		 }
		 if(cm != null){
			 sqlQuery.setParameter("cm",cm);
		 }
		 if(idOrganigrama != null){
			 sqlQuery.setParameter("idOrganigrama",idOrganigrama);
		 }

		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static List<SqlRow> getTotalesPorAgrupadosOrganigramaPeriodo(Long idPeriodo,boolean convenio){
		//Periodo p = Periodo.find.byId(idPeriodo);

		String sql = "WITH RECURSIVE recursetree(id, padre_id) AS (  " +
				"   SELECT id, padre_id FROM organigramas " +
				" UNION  " +
				"   SELECT t.id, t.padre_id  " +
				"   FROM organigramas t  " +
				"   JOIN recursetree rt ON rt.id = t.padre_id  " +
				" )  " +
				"select o.id,o.padre_id, o.nombre,  " +
				"COUNT(DISTINCT a.id) cantidadEmpleados ," +
				"round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN cantidad * importe ELSE 0 END ),0)) totalConAporte,  " +
				"round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN cantidad * importe ELSE 0 END ),0)) totalSinAporte, " +
				"round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3 THEN cantidad * importe ELSE 0 END ),0)) totalRetenciones " +
				"from liquidacion_puestos lp  " +
				"inner join liquidacion_meses lm on  lm.id = lp.liquidacion_mes_id " +
				"inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id  " +
				"inner join liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id  " +
				"inner join puestos_laborales pl on pl.id = lp.puesto_laboral_id  " +
				"inner join legajos l on l.id = pl.legajo_id  " +
				"inner join agentes a on a.id = l.agente_id  " +
				"inner join organigramas o on o.id = lp.organigrama_id " +
				"where (lp.organigrama_id in (SELECT id FROM recursetree)) " +
				"and lm.periodo_id = :periodo_id " +
				"and pl.convenio_ministerio = :convenio " +
				"group by o.id ORDER BY o.padre_id,cantidadEmpleados desc ";


		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",idPeriodo);
		sqlQuery.setParameter("convenio",convenio);


		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static List<SqlRow> getTotalesPorEscalaProfesionPeriodo(Long idPeriodo,Boolean cm,Long escalaId){
		//Periodo p = Periodo.find.byId(idPeriodo);

		String sql = "SELECT count(*) as cant, lm.periodo_id, pl.convenio_ministerio,el.nombre,pr.nombre as profesion,t.id as idTipoRelacion, "+
						"SUM(COALESCE(haber.importe, 0)) haber, "+
						"SUM(COALESCE(guardias.importe, 0)) guardias, "+
						"SUM(COALESCE(produccion.importe, 0)) produccion, "+
						"SUM(COALESCE(adicionales.importe, 0)) adicional, "+
						"SUM(COALESCE(descuentos.importe, 0)) descuentos, "+
						"SUM(COALESCE(haberes.importe, 0) - COALESCE(descu.importe, 0)) neto "+
						"FROM puestos_laborales pl "+
					 "INNER JOIN legajos l on l.id = pl.legajo_id "+
					 "INNER JOIN agentes a on a.id = l.agente_id "+
					 "INNER JOIN organigramas o on o.id = a.organigrama_id "+
					 "INNER JOIN tipo_relacion_laborales t on CAST (a.tipo_relacion_laboral AS INTEGER) = t.id "+
					 "INNER JOIN profesiones pr on pr.id = a.profesion_id "+
					 "INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+
					 "INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+
					 "INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id "+

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "where lc.liquidacion_concepto_tipo_id in (1,2) group by ld.liquidacion_puesto_id "+
					   ") haberes on haberes.liquidacion_puesto_id = lp.id "+

					"left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "where lc.liquidacion_concepto_tipo_id in (3,4) group by ld.liquidacion_puesto_id "+
					   ") descu on descu.liquidacion_puesto_id = lp.id "+

					"left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 1 group by ld.liquidacion_puesto_id "+
					 ") haber on haber.liquidacion_puesto_id = lp.id "+  //HABER

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 2 group by ld.liquidacion_puesto_id "+
					 ") guardias on guardias.liquidacion_puesto_id = lp.id "+ //GUARDIAS

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 3 group by ld.liquidacion_puesto_id "+
					 ") produccion on produccion.liquidacion_puesto_id = lp.id "+//PRODUCCION

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 5 group by ld.liquidacion_puesto_id "+
					 ") descuentos on descuentos.liquidacion_puesto_id = lp.id "+ //DESCUENTOS

					 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
					   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
					   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
					   "where lcc.id = 6 group by ld.liquidacion_puesto_id "+
					 ") adicionales on adicionales.liquidacion_puesto_id = lp.id "+ //ADICIONALES

					 "WHERE  lm.liquidacion_tipo_id = 1 AND lm.periodo_id = :periodo_id ";


					 if(cm != null){
						 sql += "AND pl.convenio_ministerio = :cm ";
					 }
					 if(escalaId != null){
						 sql += "AND pl.escala_laboral_id = :escalaId ";
					 }

					 sql += "GROUP BY lm.periodo_id, pl.convenio_ministerio,el.nombre,pr.nombre,t.id "+
					 "order by cant desc ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",idPeriodo);

		 if(cm != null){
			 sqlQuery.setParameter("cm",cm);
		 }
		 if(escalaId != null){
			 sqlQuery.setParameter("escalaId",escalaId);
		 }

		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static List<SqlRow> getTotalesPorEscala(Long idPeriodo,Boolean cm){

		String sql = "SELECT count(*) as cant,pl.convenio_ministerio,el.id,el.nombre as escala,t.id as idTipoRelacion,t.nombre as tipoRelacion, "+
				"SUM(COALESCE(haber.importe, 0)) haber, "+
				"SUM(COALESCE(guardias.importe, 0)) guardias, "+
				"SUM(COALESCE(produccion.importe, 0)) produccion, "+
				"SUM(COALESCE(adicionales.importe, 0)) adicional, "+
				"SUM(COALESCE(descuentos.importe, 0)) descuentos, "+
				"SUM(COALESCE(haberes.importe, 0) - COALESCE(descu.importe, 0)) neto "+
				"FROM puestos_laborales pl "+
			 "INNER JOIN legajos l on l.id = pl.legajo_id "+
			 "INNER JOIN agentes a on a.id = l.agente_id "+
			 "INNER JOIN organigramas o on o.id = a.organigrama_id "+
			 "INNER JOIN tipo_relacion_laborales t on CAST (a.tipo_relacion_laboral AS INTEGER) = t.id "+
			 "INNER JOIN profesiones pr on pr.id = a.profesion_id "+
			 "INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+
			 "INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+
			 "INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id "+

			 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
			   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
			   "where lc.liquidacion_concepto_tipo_id in (1,2) group by ld.liquidacion_puesto_id "+
			   ") haberes on haberes.liquidacion_puesto_id = lp.id "+

			"left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
			   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
			   "where lc.liquidacion_concepto_tipo_id in (3,4) group by ld.liquidacion_puesto_id "+
			   ") descu on descu.liquidacion_puesto_id = lp.id "+

			"left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
			   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
			   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
			   "where lcc.id = 1 group by ld.liquidacion_puesto_id "+
			 ") haber on haber.liquidacion_puesto_id = lp.id "+  //HABER

			 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
			   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
			   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
			   "where lcc.id = 2 group by ld.liquidacion_puesto_id "+
			 ") guardias on guardias.liquidacion_puesto_id = lp.id "+ //GUARDIAS

			 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
			   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
			   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
			   "where lcc.id = 3 group by ld.liquidacion_puesto_id "+
			 ") produccion on produccion.liquidacion_puesto_id = lp.id "+//PRODUCCION

			 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
			   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
			   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
			   "where lcc.id = 5 group by ld.liquidacion_puesto_id "+
			 ") descuentos on descuentos.liquidacion_puesto_id = lp.id "+ //DESCUENTOS

			 "left join (SELECT ld.liquidacion_puesto_id, sum(ld.importe*ld.cantidad) importe "+
			   "from liquidacion_detalles ld join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
			   "inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
			   "where lcc.id = 6 group by ld.liquidacion_puesto_id "+
			 ") adicionales on adicionales.liquidacion_puesto_id = lp.id "+ //ADICIONALES

			 "WHERE  lm.liquidacion_tipo_id = 1 AND lm.periodo_id = :periodo_id ";


			 if(cm != null){
				 sql += "AND pl.convenio_ministerio = :cm ";
			 }


			 sql += "GROUP BY pl.convenio_ministerio,el.id,el.nombre,t.id,t.nombre "+
			 "order by el.id ";

			SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
			sqlQuery.setParameter("periodo_id",idPeriodo);

			 if(cm != null){
				 sqlQuery.setParameter("cm",cm);
			 }


			List<SqlRow>  row = sqlQuery.findList();

			return row;
	}

	public static List<SqlRow> getDetalleLiquidacionClasificacion(Integer idPuestoLaboral,Integer idPeriodo,Integer idClasificacion){
		String sql = "SELECT lc.id,lc.denominacion concepto, sum(ld.cantidad) cantidad,sum(ld.importe) importe "+
		"FROM liquidacion_detalles ld "+
		"INNER JOIN liquidacion_conceptos lc ON ld.liquidacion_concepto_id = lc.id "+
		"INNER JOIN liquidacion_concepto_clasificaciones lcc ON lcc.id = lc.liquidacion_concepto_clasificacion_id "+
		"INNER JOIN liquidacion_puestos lp ON lp.id = ld.liquidacion_puesto_id "+
		"INNER JOIN liquidacion_meses lm ON lm.id = lp.liquidacion_mes_id "+
		"WHERE lcc.id = :idClasificacion AND lp.puesto_laboral_id = :idPuestoLaboral AND lm.periodo_id = :idPeriodo "+
		"GROUP BY lc.id,lc.denominacion ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("idClasificacion",idClasificacion);
		sqlQuery.setParameter("idPuestoLaboral",idPuestoLaboral);
		sqlQuery.setParameter("idPeriodo",idPeriodo);

		List<SqlRow>  row = sqlQuery.findList();

		return row;
	}

	public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> pSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE puestos_laborales " +
				"SET estado_id = :idEstado " +
				"WHERE id IN (:ids)");
		update.setParameter("idEstado", idEstado);
		update.setParameter("ids", pSeleccionados);

		return update.execute();
	}


	public static int liquidacionCierre(Long idPuestoLaboral,Long idLiquidacionMes) {

		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		int idcl = 0;

		try {
			conn = play.db.DB.getConnection();


			stmt = conn.prepareStatement("SELECT bc_liqfinal(?,?)");
			stmt.setLong(1, idPuestoLaboral);
			stmt.setLong(2, idLiquidacionMes);
			rs = stmt.executeQuery();

			if (rs.next()) {
				idcl = rs.getInt(1);
			}

		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }

		return idcl;
	}
}