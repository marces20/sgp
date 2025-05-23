package models;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;

import models.auth.Permiso;
import controllers.auth.CheckPermisoAction;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.StringUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "agente_asistencia_licencias")
public class AgenteAsistenciaLicencia extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agente_asistencia_licencias_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	@Required(message="Debe tener un agente asociado.")
	public Long agente_id;

	@ManyToOne
	@JoinColumn(name="tipo_licencia_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoLicencia tipoLicencia;
	@Required(message="Debe tener tipo de licencia")
	public Long tipo_licencia_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Debe tener fecha inicio")
	public Date finicio;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Debe tener fecha fin")
	public Date ffin;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	@Required(message="Debe tener fecha presentacion")
	public Date fpresentacion;

	@ManyToOne
	@JoinColumn(name="ejercicio_id", referencedColumnName="id", insertable=false, updatable=false)
	public Ejercicio ejercicio;
	@Required(message="Debe tener un año")
	public Long ejercicio_id;

	public String nota;

	public Integer dias;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id;

	@ManyToOne
	@JoinColumn(name="cie_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cie cie;
	public Long cie_id;

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
	public static Finder<Long,AgenteAsistenciaLicencia> find = new Finder<Long,AgenteAsistenciaLicencia>(Long.class, AgenteAsistenciaLicencia.class);

	public static Pagination<AgenteAsistenciaLicencia> page(Long agente_id,Long tipoLicencia) {
    	Pagination<AgenteAsistenciaLicencia> p = new Pagination<AgenteAsistenciaLicencia>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<AgenteAsistenciaLicencia> e = find
    												 .fetch("tipoLicencia","nombre")
    												 .fetch("ejercicio","nombre")
    												 .fetch("create_usuario","nombre")
    												 .fetch("estado","nombre")
    												 .where();
    	e.eq("agente_id", agente_id);

    	if(tipoLicencia.compareTo(new Long(0)) != 0) {
    		e.eq("tipo_licencia_id", tipoLicencia);
    	}

    	p.setExpressionList(e);
    	return p;
	}

	public static Map<Long,Integer>  getDiasLicenciaReglamentariaPorEjercicio(Long idAgente){
		Agente a = Agente.find.where().eq("id", idAgente).findUnique();

		TreeMap<Long,Integer> ret= new TreeMap<>();

		if(a != null) {
			Calendar calendarHoy = Calendar.getInstance();
			calendarHoy.setTime(new Date());

			Date fingreso = a.fingreso;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fingreso);


			Logger.debug("DAY_OF_MONTH "+calendar.get(Calendar.DAY_OF_MONTH) );
			Logger.debug("MONTH "+calendar.get(Calendar.MONTH) );
			Logger.debug("YEAR "+calendar.get(Calendar.YEAR) );

			Integer YEAR = calendar.get(Calendar.YEAR);
			int YEARHASTAHOY = calendarHoy.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);


			if(calendar.get(Calendar.MONTH) > 6) { // INGRESO despues de julio INCLUSIVEEE .. osea 31/07
				YEAR = calendar.get(Calendar.YEAR)+1;
			}else {// INGRESO antes de julio... INCLUSIVEEE .. osea 31/07

			}

			boolean bandera = true;
			int contador_anios = 1;
			int dias = 0;
			while(bandera) {

				Ejercicio e = Ejercicio.find.where().eq("nombre", YEAR.toString()).findUnique();
				if(e != null) {
					if(contador_anios < 5) {
						dias = 15;
					}else if(contador_anios >= 5 && contador_anios < 10) {
						dias = 20;
					}else if(contador_anios >= 10 && contador_anios < 15) {
						dias = 25;
					}else if(contador_anios >= 15) {
						dias = 30;
					}

					ret.put(e.id, dias);
				}
					contador_anios ++;
					YEAR++;

					if(YEAR == calendarHoy.get(Calendar.YEAR)+2) {

						bandera = false;
					}

			}




		}

		return ret;
	}

	public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> opcSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE agente_asistencia_licencias " +
				" SET estado_id = :estado_id "+
				" WHERE id IN (:ids)");

		update.setParameter("estado_id", idEstado);
		update.setParameter("ids", opcSeleccionados);

		return update.execute();
	}

	public boolean tienePermisosTipoLicencia(AgenteAsistenciaLicencia aal){
		boolean r = false;
		TipoLicencia tl =TipoLicencia.find.byId(aal.tipo_licencia_id);
		if(tl.tipo.compareToIgnoreCase(TipoLicencia.TIPO_LICENCIA_DOCENCIA) == 0 && Permiso.check("agentesLicenciasDocencia")){
			r = true;
		}else if(tl.tipo.compareToIgnoreCase(TipoLicencia.TIPO_LICENCIA_PERSONAL) == 0 && Permiso.check("agentesLicenciasPersonal")){
			r = true;
		}else if(tl.tipo.compareToIgnoreCase(TipoLicencia.TIPO_LICENCIA_MEDICINA) == 0 && Permiso.check("agentesLicenciasMedicina")){
			r = true;
		}

		return r;
	}

	public int getDiasTotales() {

		Integer dias = tipoLicencia.dias;
		Integer ejj = new Integer(ejercicio.nombre)-4;
		Date xd = DateUtils.formatDate("31/07/"+ejj.toString(), "dd/MM/yyyy");
		if(agente.fingreso.compareTo(xd) <= 0 && tipo_licencia_id.compareTo(new Long(5)) == 0) {
			dias = 20;
		}

		return dias;
	}

	public int getDiasEntreFechasJava(){

		boolean habiles = false;
		int diffDays = 0 ;

		Calendar calendarInicio = Calendar.getInstance();
		calendarInicio.setTime(finicio);

		Calendar calendarFin = Calendar.getInstance();
		calendarFin.setTime(ffin);
		Logger.debug("getDiasEntreFechasJava id: "+id);
		Logger.debug("getDiasEntreFechasJava calendarInicio: "+calendarInicio.get(Calendar.DAY_OF_WEEK));
		Logger.debug("getDiasEntreFechasJava calendarInicio: "+calendarInicio.get(Calendar.DAY_OF_WEEK));

		if(tipoLicencia != null && tipoLicencia.habiles != null && tipoLicencia.habiles == true){
			Logger.debug(tipoLicencia.habiles.toString());
			habiles = true;

		}

		List<Feriado> f = Feriado.find.findList();
		ArrayList<Date> feriadosList = new ArrayList<>();
		for(Feriado fx :f) {
			feriadosList.add(fx.fecha);
		}

		Logger.debug("calendarInicio.before(calendarFin) id: "+calendarInicio.before(calendarFin));

		 if(calendarFin.before(calendarInicio)) {

			while (calendarFin.before(calendarInicio) || calendarInicio.equals(calendarFin)) {
				if(habiles) {
					if(!feriadosList.contains(calendarInicio.getTime() ) ) {
						if (calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
				            //se aumentan los dias de diferencia entre min y max
				            diffDays--;
						}
					}
				}else {
					 diffDays--;
				}

				calendarInicio.add(Calendar.DATE, -1);
			}

		}else if(calendarInicio.before(calendarFin) || calendarInicio.equals(calendarFin)) {

			while (calendarInicio.before(calendarFin) || calendarInicio.equals(calendarFin)) {
				if(habiles) {
					if(!feriadosList.contains(calendarInicio.getTime() ) ) {
						if (calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
				            //se aumentan los dias de diferencia entre min y max
				            diffDays++;
						}
					}
				}else {
					 diffDays++;
				}

				calendarInicio.add(Calendar.DATE, 1);
			}
		}
		//LICENCIA ANUAL REGLAMENTARIA	11/04/2025	14/04/2025	22/04/2025	0	2024	RESTAN 10 DIAS LAR 2024	MONTENEGRO, DANILA




		return diffDays;
	}



	public int getDiasEntreFechas(){

		return getDiasEntreFechasJava();

		/*Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ret = 0;
		try {

			conn = play.db.DB.getConnection();

			boolean habiles = false;
			Logger.debug("ffffffffffffffffffffffffffffffffff "+id);


			if(tipoLicencia != null && tipoLicencia.habiles != null && tipoLicencia.habiles == true){
				Logger.debug(tipoLicencia.habiles.toString());
				habiles = true;
			}

			stmt = conn.prepareStatement("SELECT get_dias_entre_fechas(?,?,?,?)");
			stmt.setDate(1, DateUtils.convertJavaDateToSqlDate(finicio));
			stmt.setDate(2, DateUtils.convertJavaDateToSqlDate(ffin));
			stmt.setBoolean(3, habiles);
			stmt.setBoolean(4, habiles);

			rs = stmt.executeQuery();
			Logger.debug("xxxxxxxxxxxxx "+finicio);
			if (rs.next()) {
				ret = rs.getInt(1);
			}

		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }

		return ret;*/
	}

	public static int setDiasPorPeriodos(Integer idLicencia){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ret = 0;
		try {

			conn = play.db.DB.getConnection();

			boolean habiles = true;

			Logger.debug("333333333");

			stmt = conn.prepareStatement("SELECT get_dias_periodo_licencias(?,?,?)");
			stmt.setBoolean(1, habiles);
			stmt.setBoolean(2, habiles);
			stmt.setInt(3, idLicencia);

			rs = stmt.executeQuery();

			if (rs.next()) {
				ret = rs.getInt(1);
			}

		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }

		return ret;
	}

	public int getDiasDisponibles(){

		Map<Long,Integer> mapEjercicioDias = getDiasLicenciaReglamentariaPorEjercicio(agente.id);
		int diasTotales = mapEjercicioDias.get(ejercicio.id);

		//return getDiasDisponibles(getDiasTotales());
		return getDiasDisponibles(diasTotales);
	}

	public int getDiasDisponiblesSinEsteId(Integer diasTotales){
		int ret  = 0;

		try {
			if(diasTotales != null && diasTotales != 0){
			//if(tipoLicencia.dias != null && tipoLicencia.dias != 0){
				//int diasTotales =  tipoLicencia.dias;


				List<AgenteAsistenciaLicencia> laall = AgenteAsistenciaLicencia.find.where()
													   .eq("agente_id", agente_id)
													   .eq("tipo_licencia_id", tipo_licencia_id)
													   .eq("ejercicio_id", ejercicio_id)
													   .ne("id", id)
													   .disjunction()
													   .eq("estado_id", Estado.AGENTE_LICENCIA_APROBADO)
													   .eq("estado_id", Estado.AGENTE_LICENCIA_PREAPROBADO)
													   .endJunction()
													   .findList();

				for(AgenteAsistenciaLicencia ax :laall){
					ret += ax.getDiasEntreFechas();
				}

				ret = diasTotales - ret;
			}else{
				ret = 0;
			}



		}catch (Exception e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        }

		return ret;
	}

	public int getDiasDisponibles(Integer diasTotales){
		int ret  = 0;

		try {
			if(diasTotales != null && diasTotales != 0){
			//if(tipoLicencia.dias != null && tipoLicencia.dias != 0){
				//int diasTotales =  tipoLicencia.dias;


				List<AgenteAsistenciaLicencia> laall = AgenteAsistenciaLicencia.find.where()
													   .eq("agente_id", agente_id)
													   .eq("tipo_licencia_id", tipo_licencia_id)
													   .eq("ejercicio_id", ejercicio_id)
													   .disjunction()
													   .eq("estado_id", Estado.AGENTE_LICENCIA_APROBADO)
													   .eq("estado_id", Estado.AGENTE_LICENCIA_PREAPROBADO)
													   .endJunction()
													   .findList();

				for(AgenteAsistenciaLicencia ax :laall){
					ret += ax.dias;//.getDiasEntreFechas();
				}

				ret = diasTotales - ret;
			}else{
				ret = 0;
			}



		}catch (Exception e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        }

		return ret;
	}

	public Map<String, Map<String, Integer[]>> getResumenInasistencia(Long agente_id){

		TreeMap<String, Map<String, Integer[]>> sorted = new TreeMap<>(Collections.reverseOrder());
		Map<String, Map<String, Integer[]>> ret = new HashMap<String, Map<String, Integer[]>>();

				List<AgenteAsistenciaLicencia> laall = AgenteAsistenciaLicencia.find
													   .fetch("agente")
													   .where()
													   .eq("agente_id", agente_id)
													   .disjunction()
													   .eq("estado_id", Estado.AGENTE_LICENCIA_APROBADO)
													   .eq("estado_id", Estado.AGENTE_LICENCIA_PREAPROBADO)
													   .endJunction()
													   .ne("ejercicio_id", 6)
													   .orderBy("ejercicio_id")
													   .findList();



				int i= 0;

				Map<Long,Integer> diasLicenciaReglamentariaPorEjercicio = getDiasLicenciaReglamentariaPorEjercicio(agente_id);

				for(AgenteAsistenciaLicencia ax :laall){

					Integer ejj = new Integer(ax.ejercicio.nombre)-4;
					Date fi =ax.agente.fingreso;
					Date xd = DateUtils.formatDate("31/07/"+ejj.toString(), "dd/MM/yyyy");
					Integer dias = ax.tipoLicencia.dias;

					Logger.debug("ax.agente.fingreso.compareTo(xd) "+ax.agente.fingreso.compareTo(xd));

					if(ax.tipo_licencia_id.compareTo(new Long(5)) == 0) {
						//dias = 20;
						dias = diasLicenciaReglamentariaPorEjercicio.get(ax.ejercicio.id);
					}



					Logger.debug("ejercicio - original "+ax.ejercicio.nombre);
					Logger.debug("ejercicio - restado "+ejj);
					Logger.debug("fi----------- "+fi);
					/*
							fingres 31/07/2016 -> 2020
							fingres 31/07/2015 -> 2019

					*/
					if(ret.containsKey(ax.ejercicio.nombre)){
						Logger.debug("---------------------------11111111111 ");
						Map<String, Integer[]> retTmp = ret.get(ax.ejercicio.nombre);
						Integer[] carga = new Integer[4];//array con los valores de cada tipo de licencia

						if(retTmp.containsKey(ax.tipoLicencia.nombre)){
							Integer[] cargaTmp = retTmp.get(ax.tipoLicencia.nombre);
							cargaTmp[0] = cargaTmp[0]+ax.dias;//ax.getDiasEntreFechas();
							cargaTmp[1] = dias-cargaTmp[0];
							carga = cargaTmp;
						}else{
							carga[0] = ax.dias; //ax.getDiasEntreFechas();//dias tomados
							carga[1] = ax.getDiasDisponibles(dias);//dias disponibles
							carga[2] = dias;//dias totales
						}
						retTmp.remove(ax.tipoLicencia.nombre);
						retTmp.put(ax.tipoLicencia.nombre, carga);
						ret.remove(ax.ejercicio.nombre);
						ret.put(ax.ejercicio.nombre, retTmp);

					}else{
						Logger.debug("---------------------------2222222 ");
						Integer[] cargax = new Integer[4];//array con los valores de cada tipo de licencia
						cargax[0] = ax.dias;//ax.getDiasEntreFechas();//dias tomados
						cargax[1] = ax.getDiasDisponibles(dias);//dias disponibles
						cargax[2] = dias;//dias totales
						Map<String, Integer[]> resumen = new HashMap<String, Integer[]>();
						resumen.put(ax.tipoLicencia.nombre, cargax);
						ret.put(ax.ejercicio.nombre, resumen);
					}
					i++;
				}


				sorted.putAll(ret);




		return sorted;
	}

	public static List<SqlRow> getDiasLicencias(String ejercicio,
											  String apellido,
											  String dni,
											  String cuit,
											  String organigrama,
											  String tipoRelacion,
											  String completas,
											  String activo){
		String where = "";
		ejercicio = (!ejercicio.isEmpty())?ejercicio:"6";

		if(!completas.isEmpty()){
    		if(completas.compareToIgnoreCase("SI") == 0){
    			where += " and COALESCE(dias,0) = 15 ";
    		}else{
    			where += " and COALESCE(dias,0) <> 15 ";
    		}
    	}

		if(!organigrama.isEmpty()){
			where += " and a.organigrama_id ="+organigrama;
    	}

		if(!apellido.isEmpty()){
			where += " and a.apellido ilike '%"+apellido+"%' ";
    	}

		if(!activo.isEmpty()){
			if(activo.compareToIgnoreCase("SI") == 0){
    			where += " and a.activo = TRUE ";
    		}else{
    			where += " and a.activo = FALSE ";
    		}
		}

		if(!dni.isEmpty()){
			where += " and a.dni ilike '%"+dni+"%' ";
    	}

		if(!cuit.isEmpty()){
			where += " and a.cuit ilike '%"+cuit+"%' ";
    	}

		if(!tipoRelacion.isEmpty()){
			where += " and a.tipo_relacion_laboral = '"+tipoRelacion+"'";
    	}


		String sql = "select a.apellido as apellido,a.dni as dni,a.cuit as cuit,o.nombre as organigrama,p.nombre as profesion,a.tipo_relacion_laboral as tipo_relacion_laboral,l.ejercicio,COALESCE(dias,0) as dias "+
					 " from agentes a "+
					 " inner join organigramas o on o.id = a.organigrama_id "+
					 " inner join profesiones p on p.id = a.profesion_id "+
					 "	left join ( "+
							" select "+
							" lic.agente_id, "+
							" ejercicio_id, "+
							" e.nombre as ejercicio, "+
							" (SUM((select count(*) as dia from generate_series(cast(finicio as timestamp), ffin, cast('1 day' as interval)) as f where EXTRACT(DOW FROM date (f)) not in (0,6))) - COALESCE(f.total,0)) as dias "+
							" from agente_asistencia_licencias lic "+
							" inner join ejercicios e on e.id = lic.ejercicio_id "+
							" left join (select agente_id, count(*) total from agente_asistencia_licencias al "+
									" join (SELECT  fecha from feriados) as x on x.fecha between (al.finicio) and (al.ffin) group by agente_id) f on f.agente_id = lic.agente_id "+
									" where ejercicio_id = :ejercicio and lic.estado_id = :estado_id and lic.tipo_licencia_id = :tipo_licencia_id  "+
							" group by ejercicio_id,e.nombre, lic.agente_id, f.total "+
						" ) as l on l.agente_id = a.id "+
						" where 1=1 "+where+" ORDER BY a.apellido";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
						 .setParameter("ejercicio", Integer.parseInt(ejercicio))
						 .setParameter("estado_id", Estado.AGENTE_LICENCIA_APROBADO)
						 .setParameter("tipo_licencia_id", 5)
						 .findList();

		return s;
	}

	public static List<SqlRow> getDiasLicenciasEnFecha(String desde,
													   String hasta,
													   String organigrama,
													   String tipoRelacion,
													   String tipoLicencia,
													   String idEstado,
													   String descripcion,
													   String ejercicio,
													   String nombre,
													   String cuit,
													   String activo
													   ){
		Date fdesde = DateUtils.formatDate(desde, "dd/MM/yyyy");
		Date fhasta = DateUtils.formatDate(hasta, "dd/MM/yyyy");
		String where = "";

		if(!activo.isEmpty()){
    		if(activo.compareToIgnoreCase("SI") == 0){
    			where += " and a.activo = true ";
    		}else{
    			where += " and a.activo = false ";
    		}
    	}

		if(!organigrama.isEmpty()){
			where += " and a.organigrama_id ="+organigrama;
    	}
		if(!tipoRelacion.isEmpty()){
			where += " and a.tipo_relacion_laboral ='"+tipoRelacion+"'";
    	}
		if(!tipoLicencia.isEmpty()){
			where += " and tl.id ="+tipoLicencia;
    	}

		if(!idEstado.isEmpty()){
			where += " and e.id ="+idEstado;
    	}
		if(!descripcion.isEmpty()){
			where += " and al.nota ilike '%"+descripcion+"%'";
    	}
		if(!ejercicio.isEmpty()){
			where += " and al.ejercicio_id ="+ejercicio;
    	}else {
    		//where += " and al.ejercicio_id = 14 ";
    	}

		if(!desde.isEmpty() &&!hasta.isEmpty()){
			where += "and al.finicio >='"+fdesde+"'  and al.ffin <= '"+fhasta+"' ";
    	}

		if(!cuit.isEmpty()){
			where += "and a.cuit ilike '%"+cuit+"%' ";
    	}

    	if(!nombre.isEmpty()){
    		where += "and a.apellido ilike '%"+nombre+"%' ";
    	}

		String sql = "select n.carga_horaria as carga_horaria,n.escala as escala,  a.id as agenteId, a.dni as dni,a.cuit as cuit,a.apellido as apellido,al.finicio as finicio,al.ffin as ffin,tl.nombre as tipoLicencia, "+
					 "o.nombre as organigrama,p.nombre as profesion,a.tipo_relacion_laboral as tipo_relacion_laboral,pu.nombre as puesto, "+
					 "e.nombre as estado,e.id as idestado,al.nota as nota,tl.habiles as tipotipoLicencia, "+
					 "al.dias as dias " +// "get_dias_entre_fechas(al.finicio,al.ffin,tl.habiles,tl.habiles) as dias "+
					 "from agentes a "+
					 "inner join agente_asistencia_licencias al on al.agente_id = a.id "+
					 "inner join tipo_licencias tl on tl.id = al.tipo_licencia_id "+
					 "inner join organigramas o on o.id = a.organigrama_id "+
					 "inner join profesiones p on p.id = a.profesion_id "+
					 "left join puestos pu on pu.id = a.puesto_id "+
					 "inner join estados e on e.id = al.estado_id "+
					 "left join (select agente_id,carga_horaria,el.nombre escala from agente_novedades an inner join escalas_laborales el on el.id = an.escala_laboral_id where activo is true ) n on n.agente_id = a.id "+
					 //"where :fecha between (al.finicio) and (al.ffin) order by a.apellido ";
					 //"where ((al.finicio between (:fechadesde) and (:fechahasta) and al.ffin between (:fechadesde) and (:fechahasta)) "+
					 //" 		OR (al.finicio <= :fechadesde AND al.ffin >= :fechahasta)) "+where+
					// "where (((al.finicio between (:fechadesde) and (:fechahasta)) OR (al.ffin between (:fechadesde) and (:fechahasta))) "+
					 //" OR (al.finicio <= :fechadesde AND al.ffin >= :fechahasta)) "+
					 "where 1=1 "+
					 where+
					 " order by a.apellido ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
		//.setParameter("fechadesde", fdesde)
		//.setParameter("fechahasta", fhasta)
		.findList();

		return s;
	}

/*
 * AgenteAsistenciaLicencia aa = new AgenteAsistenciaLicencia();

		List<AgenteAsistenciaLicencia> aav  = aa.find.where().le("id", 57324).isNull("dias").findList();

		for (AgenteAsistenciaLicencia ax :aav) {

			int di = ax.getDiasEntreFechas();
			ax.dias= di;
			ax.save();
			Logger.debug("dddddddddddddddddddd "+ ax.id);
		}

 * */


}
