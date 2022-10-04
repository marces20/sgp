package controllers.dashboard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import models.Periodo;
import models.haberes.EscalaLaboral;
import models.haberes.LiquidacionConceptoClasificacion;
import models.haberes.LiquidacionMes;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.dashboard.honorariosNew.index;
import views.html.dashboard.honorariosNew.listadoHonorariosReporte;
import views.html.dashboard.honorariosNew.listadoHonorariosReporte2;
import views.html.dashboard.honorariosNew.listadoHonorariosReporte3;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import controllers.Secured;

@Security.Authenticated(Secured.class)
public class HonorariosNewController extends Controller {
	
	//@CheckPermiso(key = "dashboardHonorariosNuevo")
	public static Result index() {
		return ok(index.render());
	}
	
	
	public static Result listadoHonorariosReporte(Integer id) {
		
		List<Periodo> lp = Periodo.find.where()
							//.eq("ejercicio_id",4)
							//.eq("id",76)
							.le("date_start",new Date())
							.order("id asc").findList();
		
		Periodo lastPeridos = Periodo.find.where()
							//.eq("ejercicio_id",4)
							//.eq("id",76)
							.le("date_start",new Date())
							.order("id desc")
							.setMaxRows(1)
							.findUnique();
		
		Logger.debug("--------------------------------------- "+lastPeridos.id);
		
		List<EscalaLaboral> el = EscalaLaboral.find.where().order("id asc").findList();
		List<LiquidacionConceptoClasificacion> lcc = LiquidacionConceptoClasificacion.find.where().order("id asc").findList();
		Map<String,Map<String,String>> lls = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> altaList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> bajaList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> escalasNoCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> escalasCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,BigDecimal>> escalasProfesionNoCmList = new HashMap<String,Map<String,BigDecimal>>();
		Map<String,Map<String,BigDecimal>> escalasProfesionCmList = new HashMap<String,Map<String,BigDecimal>>();
		
		Map<String,Map<String,BigDecimal>> escalasAsistencialProfesionNoCmList = new HashMap<String,Map<String,BigDecimal>>();
		Map<String,Map<String,BigDecimal>> escalasNoAsistencialProfesionNoCmList = new HashMap<String,Map<String,BigDecimal>>();
		Map<String,Map<String,BigDecimal>> escalasAsistencialProfesionCmList = new HashMap<String,Map<String,BigDecimal>>();
		Map<String,Map<String,BigDecimal>> escalasNoAsistencialProfesionCmList = new HashMap<String,Map<String,BigDecimal>>();
		
		Map<String,Map<String,String>> escalasLiquidacionesNoCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> escalasLiquidacionesCmList = new HashMap<String,Map<String,String>>();
		
		Map<String,Integer> servicioNoCmList = new HashMap<String,Integer>();
		Map<String,Integer> servicioCmList = new HashMap<String,Integer>();
		Map<String,Map<String,BigDecimal>> costoTotalList = new HashMap<String,Map<String,BigDecimal>>();
		Map<String,Map<String,BigDecimal>> costoTotalSinSacList = new HashMap<String,Map<String,BigDecimal>>();
		Map<String,Map<String,BigDecimal>> costoTipoConceptoNoCmList = new HashMap<String,Map<String,BigDecimal>>();
		Map<String,Map<String,BigDecimal>> costoTipoConceptoCmList = new HashMap<String,Map<String,BigDecimal>>();
		
		Map<String,Map<String,BigDecimal>> costoTipoConceptoNoCmListSinSac = new HashMap<String,Map<String,BigDecimal>>();
		Map<String,Map<String,BigDecimal>> costoTipoConceptoCmListSinSac = new HashMap<String,Map<String,BigDecimal>>();
		
		List<String> tipoConceptos = new ArrayList<String>();
		Map<String,Map<String,String>> costoTotalPorClasificacionConceptosNoCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> costoTotalPorClasificacionConceptosCmList = new HashMap<String,Map<String,String>>();
		
		Map<String,Map<String,String>> costoTotalPorEscalaNoCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> costoTotalPorEscalaCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> costoTotalPorEscalaNoCmListSinSac = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> costoTotalPorEscalaCmListSinSac = new HashMap<String,Map<String,String>>();
		
		
		Map<String,Map<String,String>> costoHcaPorEscalaNoCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> costoHcaPorEscalaCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> costoHsaPorEscalaNoCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> costoHsaPorEscalaCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> costoRetPorEscalaNoCmList = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> costoRetPorEscalaCmList = new HashMap<String,Map<String,String>>();
		
		List<SqlRow> escalasProfesionNoCmTmp = LiquidacionMes.getCountPorProfesion(lastPeridos.id,false);
		if(escalasProfesionNoCmTmp.size() > 0){
			for(SqlRow sr:escalasProfesionNoCmTmp){
				if(escalasProfesionNoCmList.containsKey(sr.getString("escala"))){
					Map<String,BigDecimal> ft = escalasProfesionNoCmList.get(sr.getString("escala"));
					ft.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					ft = utils.MapUtils.sortByValueDesc( ft );
					escalasProfesionNoCmList.put(sr.getString("escala"), ft);
				}else{
					Map<String,BigDecimal> f = new HashMap<String,BigDecimal>();
					f.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					escalasProfesionNoCmList.put(sr.getString("escala"), f);
				}
			}
		} 
		
		List<SqlRow> escalasProfesionCmTmp = LiquidacionMes.getCountPorProfesion(lastPeridos.id,true);
		if(escalasProfesionCmTmp.size() > 0){
			for(SqlRow sr:escalasProfesionCmTmp){
				if(escalasProfesionCmList.containsKey(sr.getString("escala"))){
					Map<String,BigDecimal> ft = escalasProfesionCmList.get(sr.getString("escala"));
					ft.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					ft = utils.MapUtils.sortByValueDesc( ft );
					escalasProfesionCmList.put(sr.getString("escala"), ft);
				}else{
					Map<String,BigDecimal> f = new HashMap<String,BigDecimal>();
					f.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					escalasProfesionCmList.put(sr.getString("escala"), f);
				}
			}
		} 
		
		
		List<SqlRow> escalasAsistencialProfesionNoCmTmp = LiquidacionMes.getCountPorProfesionAsistencial(lastPeridos.id,false,true);
		if(escalasAsistencialProfesionNoCmTmp.size() > 0){
			for(SqlRow sr:escalasAsistencialProfesionNoCmTmp){
				if(escalasAsistencialProfesionNoCmList.containsKey(sr.getString("escala"))){
					Map<String,BigDecimal> ft = escalasAsistencialProfesionNoCmList.get(sr.getString("escala"));
					ft.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					ft = utils.MapUtils.sortByValueDesc( ft );
					escalasAsistencialProfesionNoCmList.put(sr.getString("escala"), ft);
				}else{
					Map<String,BigDecimal> f = new HashMap<String,BigDecimal>();
					f.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					escalasAsistencialProfesionNoCmList.put(sr.getString("escala"), f);
				}
			}
		} 
		List<SqlRow> escalasNoAsistencialProfesionNoCmTmp = LiquidacionMes.getCountPorProfesionAsistencial(lastPeridos.id,false,false);
		if(escalasNoAsistencialProfesionNoCmTmp.size() > 0){
			for(SqlRow sr:escalasNoAsistencialProfesionNoCmTmp){
				if(escalasNoAsistencialProfesionNoCmList.containsKey(sr.getString("escala"))){
					Map<String,BigDecimal> ft = escalasNoAsistencialProfesionNoCmList.get(sr.getString("escala"));
					ft.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					ft = utils.MapUtils.sortByValueDesc( ft );
					escalasNoAsistencialProfesionNoCmList.put(sr.getString("escala"), ft);
				}else{
					Map<String,BigDecimal> f = new HashMap<String,BigDecimal>();
					f.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					escalasNoAsistencialProfesionNoCmList.put(sr.getString("escala"), f);
				}
			}
		} 
		
		List<SqlRow> escalasAsistencialProfesionCmTmp = LiquidacionMes.getCountPorProfesionAsistencial(lastPeridos.id,true,true);
		if(escalasAsistencialProfesionCmTmp.size() > 0){
			for(SqlRow sr:escalasAsistencialProfesionCmTmp){
				if(escalasAsistencialProfesionCmList.containsKey(sr.getString("escala"))){
					Map<String,BigDecimal> ft = escalasAsistencialProfesionCmList.get(sr.getString("escala"));
					ft.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					ft = utils.MapUtils.sortByValueDesc( ft );
					escalasAsistencialProfesionCmList.put(sr.getString("escala"), ft);
				}else{
					Map<String,BigDecimal> f = new HashMap<String,BigDecimal>();
					f.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					escalasAsistencialProfesionCmList.put(sr.getString("escala"), f);
				}
			}
		} 
		
		List<SqlRow> escalasNoAsistencialProfesionCmTmp = LiquidacionMes.getCountPorProfesionAsistencial(lastPeridos.id,true,false);
		if(escalasNoAsistencialProfesionCmTmp.size() > 0){
			for(SqlRow sr:escalasNoAsistencialProfesionCmTmp){
				if(escalasNoAsistencialProfesionCmList.containsKey(sr.getString("escala"))){
					Map<String,BigDecimal> ft = escalasNoAsistencialProfesionCmList.get(sr.getString("escala"));
					ft.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					ft = utils.MapUtils.sortByValueDesc( ft );
					escalasNoAsistencialProfesionCmList.put(sr.getString("escala"), ft);
				}else{
					Map<String,BigDecimal> f = new HashMap<String,BigDecimal>();
					f.put(sr.getString("profesion"),sr.getBigDecimal("count"));
					escalasNoAsistencialProfesionCmList.put(sr.getString("escala"), f);
				}
			}
		} 
		
		List<SqlRow> servicioNoCmTmp = LiquidacionMes.getCountPorServicio(lastPeridos.id,false);
		
		if(servicioNoCmTmp.size() > 0){
			for(SqlRow sr:servicioNoCmTmp){
				servicioNoCmList.put(sr.getString("nombre"),sr.getInteger("count"));
			}
			servicioNoCmList = utils.MapUtils.sortByValueDesc( servicioNoCmList );
		}
		
		List<SqlRow> servicioCmTmp = LiquidacionMes.getCountPorServicio(lastPeridos.id,true);
		
		if(servicioCmTmp.size() > 0){
			for(SqlRow sr:servicioCmTmp){
				servicioCmList.put(sr.getString("nombre"),sr.getInteger("count"));
			}
			servicioCmList = utils.MapUtils.sortByValueDesc( servicioCmList );
		}
		
		List<SqlRow> totalFinalUnicoPeriodoPorEscalaNoCmTmp = getTotalFinalUnicoPeriodoPorEscala(lastPeridos.id,false,false);
		List<SqlRow> totalFinalUnicoPeriodoPorEscalaCmTmp = getTotalFinalUnicoPeriodoPorEscala(lastPeridos.id,true,false);
		List<SqlRow> totalFinalUnicoPeriodoPorEscalaNoCmTmpSinSac = getTotalFinalUnicoPeriodoPorEscala(lastPeridos.id,false,true);
		List<SqlRow> totalFinalUnicoPeriodoPorEscalaCmTmpSinSac = getTotalFinalUnicoPeriodoPorEscala(lastPeridos.id,true,true); 
		
		
		for(Periodo p : lp){
			
			
			List<SqlRow> lsTmp = getCountRelacionPorPeriodo(p.id);
			if(lsTmp.size() > 0){
				for(SqlRow sr:lsTmp){
					if(lls.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  lls.get(p.nombre);
						if(sr.getBoolean("cm")){
							sstmp2.put("cm",sr.getString("count"));
						}else{
							sstmp2.put("nocm",sr.getString("count"));
						}
						lls.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						if(sr.getBoolean("cm")){
							sstmp.put("cm",sr.getString("count"));
						}else{
							sstmp.put("nocm",sr.getString("count"));
						}
						lls.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> altasTmp = getCountAltasPorPeriodo(p.id);
			if(altasTmp.size() > 0){
				for(SqlRow sr:altasTmp){
					
					if(altaList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  altaList.get(p.nombre);
						if(sr.getBoolean("cm")){
							sstmp2.put("cm",sr.getString("count"));
						}else{
							sstmp2.put("nocm",sr.getString("count"));
						}
						altaList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						if(sr.getBoolean("cm")){
							sstmp.put("cm",sr.getString("count"));
						}else{
							sstmp.put("nocm",sr.getString("count"));
						}
						altaList.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> bajasTmp = getCountBajasPorPeriodo(p.id);
			if(bajasTmp.size() > 0){
				for(SqlRow sr:bajasTmp){
					if(bajaList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  bajaList.get(p.nombre);
						if(sr.getBoolean("cm")){
							sstmp2.put("cm",sr.getString("count"));
						}else{
							sstmp2.put("nocm",sr.getString("count"));
						}
						bajaList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						if(sr.getBoolean("cm")){
							sstmp.put("cm",sr.getString("count"));
						}else{
							sstmp.put("nocm",sr.getString("count"));
						}
						bajaList.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> escalasNoCmTmp = getCountPorEscala(p.id,false);
			if(escalasNoCmTmp.size() > 0){
				for(SqlRow sr:escalasNoCmTmp){
					if(escalasNoCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  escalasNoCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("count"));
						escalasNoCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("count"));
						escalasNoCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			List<SqlRow> escalasCmTmp = getCountPorEscala(p.id,true);
			if(escalasCmTmp.size() > 0){
				for(SqlRow sr:escalasCmTmp){
					if(escalasCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  escalasCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("count"));
						escalasCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("count"));
						escalasCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			List<SqlRow> escalasLiquidacionesCmTmp = getCountPorEscalaEnLiquidaciones(p.id,true);
			if(escalasLiquidacionesCmTmp.size() > 0){
				for(SqlRow sr:escalasLiquidacionesCmTmp){
					if(escalasLiquidacionesCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  escalasLiquidacionesCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("count"));
						escalasLiquidacionesCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("count"));
						escalasLiquidacionesCmList.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> escalasLiquidacionesNoCmTmp = getCountPorEscalaEnLiquidaciones(p.id,false);
			if(escalasLiquidacionesNoCmTmp.size() > 0){
				for(SqlRow sr:escalasLiquidacionesNoCmTmp){
					if(escalasLiquidacionesNoCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  escalasLiquidacionesNoCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("count"));
						escalasLiquidacionesNoCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("count"));
						escalasLiquidacionesNoCmList.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> costoTotalTmp = getCostoTotalPorPeriodo(p.id);
			if(costoTotalTmp.size() > 0){
				for(SqlRow sr:costoTotalTmp){
					if(costoTotalList.containsKey(p.nombre)){
						Map<String,BigDecimal> sstmp2 =  costoTotalList.get(p.nombre);
						if(sr.getBoolean("cm")){
							sstmp2.put("cm",sr.getBigDecimal("monto"));
						}else{
							sstmp2.put("nocm",sr.getBigDecimal("monto"));
						}
						costoTotalList.put(p.nombre, sstmp2);
					}else{
						Map<String,BigDecimal> sstmp = new HashMap<String,BigDecimal>();
						if(sr.getBoolean("cm")){
							sstmp.put("cm",sr.getBigDecimal("monto"));
						}else{
							sstmp.put("nocm",sr.getBigDecimal("monto"));
						}
						costoTotalList.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> costoTotalSinSacTmp = getCostoTotalPorPeriodoSinSac(p.id);
			if(costoTotalSinSacTmp.size() > 0){
				for(SqlRow sr:costoTotalSinSacTmp){
					if(costoTotalSinSacList.containsKey(p.nombre)){
						Map<String,BigDecimal> sstmp2 =  costoTotalSinSacList.get(p.nombre);
						if(sr.getBoolean("cm")){
							sstmp2.put("cm",sr.getBigDecimal("monto"));
						}else{
							sstmp2.put("nocm",sr.getBigDecimal("monto"));
						}
						costoTotalSinSacList.put(p.nombre, sstmp2);
					}else{
						Map<String,BigDecimal> sstmp = new HashMap<String,BigDecimal>();
						if(sr.getBoolean("cm")){
							sstmp.put("cm",sr.getBigDecimal("monto"));
						}else{
							sstmp.put("nocm",sr.getBigDecimal("monto"));
						}
						costoTotalSinSacList.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> costoTipoConceptoNoCmTmp = getCostoTotalPorTipoConcepto(p.id,false);
			if(costoTipoConceptoNoCmTmp.size() > 0){
				for(SqlRow sr:costoTipoConceptoNoCmTmp){
					String tipo = "";
					if(sr.getInteger("tipo").equals(1) || sr.getInteger("tipo").equals(4)){tipo = "Haberes Con Aporte";
					}else if(sr.getInteger("tipo").equals(2)){tipo = "Haberes sin Aporte";
					}else if(sr.getInteger("tipo").equals(3)){tipo = "Retenciones";
					}else if(sr.getInteger("tipo").equals(5)){tipo = "Contribuciones Patronales";}
					
					if(!tipoConceptos.contains(tipo)){tipoConceptos.add(tipo);}
					
					if(costoTipoConceptoNoCmList.containsKey(p.nombre)){
						Map<String,BigDecimal> sstmp2 =  costoTipoConceptoNoCmList.get(p.nombre);
						sstmp2.put(tipo,sr.getBigDecimal("monto"));
						
						costoTipoConceptoNoCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,BigDecimal> sstmp = new HashMap<String,BigDecimal>();
						sstmp.put(tipo,sr.getBigDecimal("monto"));
						
						costoTipoConceptoNoCmList.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> costoTipoConceptoCmTmp = getCostoTotalPorTipoConcepto(p.id,true);
			if(costoTipoConceptoCmTmp.size() > 0){
				for(SqlRow sr:costoTipoConceptoCmTmp){
					String tipo = "";
					if(sr.getInteger("tipo").equals(1) || sr.getInteger("tipo").equals(4)){tipo = "Haberes Con Aporte";
					}else if(sr.getInteger("tipo").equals(2)){tipo = "Haberes sin Aporte";
					}else if(sr.getInteger("tipo").equals(3)){tipo = "Retenciones";
					}else if(sr.getInteger("tipo").equals(5)){tipo = "Contribuciones Patronales";}
					
					if(!tipoConceptos.contains(tipo)){tipoConceptos.add(tipo);}
					
					if(costoTipoConceptoCmList.containsKey(p.nombre)){
						Map<String,BigDecimal> sstmp2 =  costoTipoConceptoCmList.get(p.nombre);
						sstmp2.put(tipo,sr.getBigDecimal("monto"));
						costoTipoConceptoCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,BigDecimal> sstmp = new HashMap<String,BigDecimal>();
						sstmp.put(tipo,sr.getBigDecimal("monto"));
						
						costoTipoConceptoCmList.put(p.nombre, sstmp);
					}
				}
			}
			//////////////////////////SINSAC
			List<SqlRow> costoTipoConceptoNoCmTmpSinSac = getCostoTotalPorTipoConceptoSinSac(p.id,false);
			if(costoTipoConceptoNoCmTmpSinSac.size() > 0){
				for(SqlRow sr:costoTipoConceptoNoCmTmpSinSac){
					String tipo = "";
					if(sr.getInteger("tipo").equals(1) || sr.getInteger("tipo").equals(4)){tipo = "Haberes Con Aporte";
					}else if(sr.getInteger("tipo").equals(2)){tipo = "Haberes sin Aporte";
					}else if(sr.getInteger("tipo").equals(3)){tipo = "Retenciones";
					}else if(sr.getInteger("tipo").equals(5)){tipo = "Contribuciones Patronales";}
					
					if(!tipoConceptos.contains(tipo)){tipoConceptos.add(tipo);}
					
					if(costoTipoConceptoNoCmListSinSac.containsKey(p.nombre)){
						Map<String,BigDecimal> sstmp2 =  costoTipoConceptoNoCmListSinSac.get(p.nombre);
						sstmp2.put(tipo,sr.getBigDecimal("monto"));
						
						costoTipoConceptoNoCmListSinSac.put(p.nombre, sstmp2);
					}else{
						Map<String,BigDecimal> sstmp = new HashMap<String,BigDecimal>();
						sstmp.put(tipo,sr.getBigDecimal("monto"));
						
						costoTipoConceptoNoCmListSinSac.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> costoTipoConceptoCmTmpSinSca = getCostoTotalPorTipoConceptoSinSac(p.id,true);
			if(costoTipoConceptoCmTmpSinSca.size() > 0){
				for(SqlRow sr:costoTipoConceptoCmTmpSinSca){
					String tipo = "";
					if(sr.getInteger("tipo").equals(1) || sr.getInteger("tipo").equals(4)){tipo = "Haberes Con Aporte";
					}else if(sr.getInteger("tipo").equals(2)){tipo = "Haberes sin Aporte";
					}else if(sr.getInteger("tipo").equals(3)){tipo = "Retenciones";
					}else if(sr.getInteger("tipo").equals(5)){tipo = "Contribuciones Patronales";}
					
					if(!tipoConceptos.contains(tipo)){tipoConceptos.add(tipo);}
					
					if(costoTipoConceptoCmListSinSac.containsKey(p.nombre)){
						Map<String,BigDecimal> sstmp2 =  costoTipoConceptoCmListSinSac.get(p.nombre);
						sstmp2.put(tipo,sr.getBigDecimal("monto"));
						costoTipoConceptoCmListSinSac.put(p.nombre, sstmp2);
					}else{
						Map<String,BigDecimal> sstmp = new HashMap<String,BigDecimal>();
						sstmp.put(tipo,sr.getBigDecimal("monto"));
						
						costoTipoConceptoCmListSinSac.put(p.nombre, sstmp);
					}
				}
			}
			//////////////////////////SINSAC
			
			List<SqlRow> costoTotalPorClasificacionConceptoNoCmTmp = getCostoTotalPorClasificacionConcepto(p.id,false);
			if(costoTotalPorClasificacionConceptoNoCmTmp.size() > 0){
				for(SqlRow sr:costoTotalPorClasificacionConceptoNoCmTmp){
					if(costoTotalPorClasificacionConceptosNoCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoTotalPorClasificacionConceptosNoCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorClasificacionConceptosNoCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorClasificacionConceptosNoCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			List<SqlRow> costoTotalPorClasificacionConceptoCmTmp = getCostoTotalPorClasificacionConcepto(p.id,true);
			if(costoTotalPorClasificacionConceptoCmTmp.size() > 0){
				for(SqlRow sr:costoTotalPorClasificacionConceptoCmTmp){
					if(costoTotalPorClasificacionConceptosCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoTotalPorClasificacionConceptosCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorClasificacionConceptosCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorClasificacionConceptosCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			/////////////////////////////////POR ESCALA ////////////////////////////////
			List<SqlRow> costoHcaPorEscalaNoCmTmp = getCostoHcaPorEscala(p.id,false);
			if(costoHcaPorEscalaNoCmTmp.size() > 0){
				for(SqlRow sr:costoHcaPorEscalaNoCmTmp){
					if(costoHcaPorEscalaNoCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoHcaPorEscalaNoCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoHcaPorEscalaNoCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoHcaPorEscalaNoCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			List<SqlRow> costoHcaPorEscalaCmTmp = getCostoHcaPorEscala(p.id,true);
			if(costoHcaPorEscalaCmTmp.size() > 0){
				for(SqlRow sr:costoHcaPorEscalaCmTmp){
					if(costoHcaPorEscalaCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoHcaPorEscalaCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoHcaPorEscalaCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoHcaPorEscalaCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			List<SqlRow> costoHsaPorEscalaNoCmTmp = getCostoHsaPorEscala(p.id,false);
			if(costoHsaPorEscalaNoCmTmp.size() > 0){
				for(SqlRow sr:costoHsaPorEscalaNoCmTmp){
					if(costoHsaPorEscalaNoCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoHsaPorEscalaNoCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoHsaPorEscalaNoCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoHsaPorEscalaNoCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			List<SqlRow> costoHsaPorEscalaCmTmp = getCostoHsaPorEscala(p.id,true);
			if(costoHsaPorEscalaCmTmp.size() > 0){
				for(SqlRow sr:costoHsaPorEscalaCmTmp){
					if(costoHsaPorEscalaCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoHsaPorEscalaCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoHsaPorEscalaCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoHsaPorEscalaCmList.put(p.nombre, sstmp);
					}
				}
			}
			
			List<SqlRow> costoRetPorEscalaNoCmTmp = getCostoRetPorEscala(p.id,false);
			if(costoRetPorEscalaNoCmTmp.size() > 0){
				for(SqlRow sr:costoRetPorEscalaNoCmTmp){
					if(costoRetPorEscalaNoCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoRetPorEscalaNoCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoRetPorEscalaNoCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoRetPorEscalaNoCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			List<SqlRow> costoRetPorEscalaCmTmp = getCostoRetPorEscala(p.id,true);
			if(costoRetPorEscalaCmTmp.size() > 0){
				for(SqlRow sr:costoRetPorEscalaCmTmp){
					if(costoRetPorEscalaCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoRetPorEscalaCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoRetPorEscalaCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoRetPorEscalaCmList.put(p.nombre, sstmp);
					}
				}
			} 
			
			List<SqlRow> costoTotalPorEscalaNoCmTmp = getCostoTotalPorEscala(p.id,false,false);
			if(costoTotalPorEscalaNoCmTmp.size() > 0){
				for(SqlRow sr:costoTotalPorEscalaNoCmTmp){
					if(costoTotalPorEscalaNoCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoTotalPorEscalaNoCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorEscalaNoCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorEscalaNoCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			List<SqlRow> costoTotalPorEscalaCmTmp = getCostoTotalPorEscala(p.id,true,false);
			if(costoTotalPorEscalaCmTmp.size() > 0){
				for(SqlRow sr:costoTotalPorEscalaCmTmp){
					if(costoTotalPorEscalaCmList.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoTotalPorEscalaCmList.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorEscalaCmList.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorEscalaCmList.put(p.nombre, sstmp);
					}
				}
			}	
			
			List<SqlRow> costoTotalPorEscalaNoCmTmpSinSac = getCostoTotalPorEscala(p.id,false,true);
			if(costoTotalPorEscalaNoCmTmpSinSac.size() > 0){
				for(SqlRow sr:costoTotalPorEscalaNoCmTmpSinSac){
					if(costoTotalPorEscalaNoCmListSinSac.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoTotalPorEscalaNoCmListSinSac.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorEscalaNoCmListSinSac.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorEscalaNoCmListSinSac.put(p.nombre, sstmp);
					}
				}
			}
			
			
			List<SqlRow> costoTotalPorEscalaCmTmpSinSac = getCostoTotalPorEscala(p.id,true,true);
			if(costoTotalPorEscalaCmTmpSinSac.size() > 0){
				for(SqlRow sr:costoTotalPorEscalaCmTmpSinSac){
					if(costoTotalPorEscalaCmListSinSac.containsKey(p.nombre)){
						Map<String,String> sstmp2 =  costoTotalPorEscalaCmListSinSac.get(p.nombre);
						sstmp2.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorEscalaCmListSinSac.put(p.nombre, sstmp2);
					}else{
						Map<String,String> sstmp = new HashMap<String,String>();
						sstmp.put(sr.getString("nombre"),sr.getString("monto"));
						costoTotalPorEscalaCmListSinSac.put(p.nombre, sstmp);
					}
				}
			}
			
			///////////////////////////////FIN POR ESCALA ////////////////////////////////
		}
		
		TreeMap<String,Map<String,String>> countAgentes = new TreeMap<String,Map<String,String>>(lls);
		TreeMap<String,Map<String,String>> countAltas = new TreeMap<String,Map<String,String>>(altaList);
		TreeMap<String,Map<String,String>> countBajas = new TreeMap<String,Map<String,String>>(bajaList);
		TreeMap<String,Map<String,String>> countEscalasNoCm = new TreeMap<String,Map<String,String>>(escalasNoCmList);
		TreeMap<String,Map<String,String>> countEscalasCm = new TreeMap<String,Map<String,String>>(escalasCmList);
		
		TreeMap<String,Map<String,String>> countEscalasLiquidacionesNoCm = new TreeMap<String,Map<String,String>>(escalasLiquidacionesNoCmList);
		TreeMap<String,Map<String,String>> countEscalasLiquidacionesCm = new TreeMap<String,Map<String,String>>(escalasLiquidacionesCmList);
		
		TreeMap<String,Map<String,BigDecimal>> countEscalasProfesionNoCm = new TreeMap<String,Map<String,BigDecimal>>(escalasProfesionNoCmList);
		TreeMap<String,Map<String,BigDecimal>> countEscalasProfesionCm = new TreeMap<String,Map<String,BigDecimal>>(escalasProfesionCmList);
		
		TreeMap<String,Map<String,BigDecimal>> countEscalasAsistencialProfesionNoCmList = new TreeMap<String,Map<String,BigDecimal>>(escalasAsistencialProfesionNoCmList);
		TreeMap<String,Map<String,BigDecimal>> countEscalasNoAsistencialProfesionNoCmList = new TreeMap<String,Map<String,BigDecimal>>(escalasNoAsistencialProfesionNoCmList);
		TreeMap<String,Map<String,BigDecimal>> countEscalasAsistencialProfesionCmList = new TreeMap<String,Map<String,BigDecimal>>(escalasAsistencialProfesionCmList);
		TreeMap<String,Map<String,BigDecimal>> countEscalasNoAsistencialProfesionCmList = new TreeMap<String,Map<String,BigDecimal>>(escalasNoAsistencialProfesionCmList);
		
		TreeMap<String,Map<String,BigDecimal>> countCostoTotal = new TreeMap<String,Map<String,BigDecimal>>(costoTotalList);
		TreeMap<String,Map<String,BigDecimal>> countCostoSinSacTotal = new TreeMap<String,Map<String,BigDecimal>>(costoTotalSinSacList);
		TreeMap<String,Map<String,BigDecimal>> countTipoConceptoNoCmTotal = new TreeMap<String,Map<String,BigDecimal>>(costoTipoConceptoNoCmList);
		TreeMap<String,Map<String,BigDecimal>> countTipoConceptoCmTotal = new TreeMap<String,Map<String,BigDecimal>>(costoTipoConceptoCmList);
		
		TreeMap<String,Map<String,BigDecimal>> countTipoConceptoNoCmTotalSinSac = new TreeMap<String,Map<String,BigDecimal>>(costoTipoConceptoNoCmListSinSac);
		TreeMap<String,Map<String,BigDecimal>> countTipoConceptoCmTotalSinSac = new TreeMap<String,Map<String,BigDecimal>>(costoTipoConceptoCmListSinSac);
		
		TreeMap<String,Map<String,String>> countCostoTotalPorClasificacionConceptosNoCm = new TreeMap<String,Map<String,String>>(costoTotalPorClasificacionConceptosNoCmList);
		TreeMap<String,Map<String,String>> countCostoTotalPorClasificacionConceptosCm = new TreeMap<String,Map<String,String>>(costoTotalPorClasificacionConceptosCmList);
		TreeMap<String,Map<String,String>> countCostoTotalPorEscalaNoCm = new TreeMap<String,Map<String,String>>(costoTotalPorEscalaNoCmList);
		TreeMap<String,Map<String,String>> countCostoTotalPorEscalaCm = new TreeMap<String,Map<String,String>>(costoTotalPorEscalaCmList);
		TreeMap<String,Map<String,String>> countCostoTotalPorEscalaNoCmSinSac = new TreeMap<String,Map<String,String>>(costoTotalPorEscalaNoCmListSinSac);
		TreeMap<String,Map<String,String>> countCostoTotalPorEscalaCmSinSac = new TreeMap<String,Map<String,String>>(costoTotalPorEscalaCmListSinSac);
	
		
		TreeMap<String,Map<String,String>> countCostoHcaPorEscalaNoCm = new TreeMap<String,Map<String,String>>(costoHcaPorEscalaNoCmList);
		TreeMap<String,Map<String,String>> countCostoHcaPorEscalaCm = new TreeMap<String,Map<String,String>>(costoHcaPorEscalaCmList);
		TreeMap<String,Map<String,String>> countCostoHsaPorEscalaNoCm = new TreeMap<String,Map<String,String>>(costoHsaPorEscalaNoCmList);
		TreeMap<String,Map<String,String>> countCostoHsaPorEscalaCm = new TreeMap<String,Map<String,String>>(costoHsaPorEscalaCmList);
		TreeMap<String,Map<String,String>> countCostoRetPorEscalaNoCm = new TreeMap<String,Map<String,String>>(costoRetPorEscalaNoCmList);
		TreeMap<String,Map<String,String>> countCostoRetPorEscalaCm = new TreeMap<String,Map<String,String>>(costoRetPorEscalaCmList);
	 
		if(id == 2){
			return ok(listadoHonorariosReporte2.render(
					el,
					countCostoTotalPorEscalaNoCm,
					countCostoTotalPorEscalaCm,
					countCostoTotalPorEscalaNoCmSinSac,
					countCostoTotalPorEscalaCmSinSac,
					totalFinalUnicoPeriodoPorEscalaNoCmTmp,
					totalFinalUnicoPeriodoPorEscalaCmTmp,
					totalFinalUnicoPeriodoPorEscalaNoCmTmpSinSac,
					totalFinalUnicoPeriodoPorEscalaCmTmpSinSac
				));		
		}else if(id == 3){	
			return ok(listadoHonorariosReporte3.render(
					el,
					countEscalasLiquidacionesNoCm,
					countEscalasLiquidacionesCm,
					countEscalasAsistencialProfesionNoCmList,
					countEscalasNoAsistencialProfesionNoCmList,
					countEscalasAsistencialProfesionCmList,
					countEscalasNoAsistencialProfesionCmList
				));		
		}else{	
			return ok(listadoHonorariosReporte.render(
				countAgentes,
				countAltas,
				countBajas,
				countEscalasNoCm,
				el,
				countEscalasCm,
				countEscalasProfesionNoCm,
				countEscalasProfesionCm,
				servicioNoCmList,
				servicioCmList,
				countCostoTotal,
				countCostoSinSacTotal,
				tipoConceptos,
				countTipoConceptoNoCmTotal,
				countTipoConceptoCmTotal,
				countTipoConceptoNoCmTotalSinSac,
				countTipoConceptoCmTotalSinSac,
				lcc,
				countCostoTotalPorClasificacionConceptosNoCm,
				countCostoTotalPorClasificacionConceptosCm
				
				));
		}	
	}
	
	public static List<SqlRow> getDataPorConcepto(Long idLiquidacion){
		
		String sql = "SELECT count(*) cantidad,round(sum(ld.cantidad),0) totalCantidad,sum(ld.cantidad*ld.importe) importe," +
				"lc.codigo codigo,lc.denominacion deno,lc.liquidacion_concepto_tipo_id tipo " +
				"FROM liquidacion_detalles ld " +
				"INNER JOIN liquidacion_puestos lp ON ld.liquidacion_puesto_id = lp.id " +
				"INNER JOIN liquidacion_conceptos lc ON lc.id = ld.liquidacion_concepto_id " +
				"WHERE lp.liquidacion_mes_id = :idLiquidacion " +
				"GROUP BY lc.codigo,lc.denominacion,lc.liquidacion_concepto_tipo_id " +
				"ORDER BY lc.codigo";
				
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("idLiquidacion", idLiquidacion)
				.findList();
		
		return s;
	}
	
	public static List<SqlRow> getCostoHcaPorEscala(Long idPeriodo,boolean cm){
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = "SELECT round(sum(ld.cantidad*ld.importe)) monto ,el.nombre nombre "+
				     " 	FROM puestos_laborales pl "+     
				     " 	INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id "+  
				     " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+   
				     " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "+
				     " 	INNER JOIN liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id "+
				     " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+ 
				     " 	WHERE lm.periodo_id = :periodo_id "+ 
				     " 	AND lm.convenio_ministerio =  :cm  AND lc.liquidacion_concepto_tipo_id in(1,4) "+
				     " 	GROUP BY lm.convenio_ministerio,el.nombre ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getCostoHsaPorEscala(Long idPeriodo,boolean cm){
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = "SELECT round(sum(ld.cantidad*ld.importe)) monto ,el.nombre nombre "+
				     " 	FROM puestos_laborales pl "+     
				     " 	INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id "+  
				     " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+   
				     " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "+
				     " 	INNER JOIN liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id "+
				     " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+ 
				     " 	WHERE lm.periodo_id = :periodo_id "+ 
				     " 	AND lm.convenio_ministerio =  :cm  AND lc.liquidacion_concepto_tipo_id in(2) "+
				     " 	GROUP BY lm.convenio_ministerio,el.nombre ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getCostoRetPorEscala(Long idPeriodo,boolean cm){
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = "SELECT round(sum(ld.cantidad*ld.importe)) monto ,el.nombre nombre "+
				     " 	FROM puestos_laborales pl "+     
				     " 	INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id "+  
				     " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+   
				     " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "+
				     " 	INNER JOIN liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id "+
				     " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+ 
				     " 	WHERE lm.periodo_id = :periodo_id "+ 
				     " 	AND lm.convenio_ministerio =  :cm  AND lc.liquidacion_concepto_tipo_id in(3) "+
				     " 	GROUP BY lm.convenio_ministerio,el.nombre ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getCostoTotalPorEscala(Long idPeriodo,boolean cm,boolean sinsac){
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = "SELECT " +
					 //"	round(sum(ld.cantidad*ld.importe),2) monto ," +
					 " round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) " +
					 " + " +
					 " COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) " +
					 " - " +
					 " COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) monto, " +
					 "	el.nombre nombre "+
				     " 	FROM puestos_laborales pl "+     
				     " 	INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id "+  
				     " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+   
				     " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id " +
				     "  INNER JOIN liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id " + 
				     " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+ 
				     " 	WHERE lm.periodo_id = :periodo_id "+ 
				     " 	AND lm.convenio_ministerio =  :cm ";
					if(sinsac){
						sql += " AND lm.liquidacion_tipo_id in(1,4)";
					}	
					sql += " 	GROUP BY lm.convenio_ministerio,el.nombre ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	
	
	public static List<SqlRow> getCostoTotalPorClasificacionConcepto(Long idPeriodo,boolean cm){
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = "SELECT round(sum(ld.cantidad*ld.importe)) monto ,lcc.nombre nombre "+
				" 	FROM puestos_laborales pl "+     
				" 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id "+   
				" 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id "+
				" 	inner join liquidacion_conceptos lc on ld.liquidacion_concepto_id = lc.id "+
				" 	inner join liquidacion_concepto_clasificaciones lcc on lcc.id = lc.liquidacion_concepto_clasificacion_id "+
				" 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+ 
				" 	WHERE lm.periodo_id = :periodo_id "+  
				"   AND lm.liquidacion_tipo_id in(1,4)"+
				" 	AND lm.convenio_ministerio =  :cm "+
				" 	GROUP BY lm.convenio_ministerio,lcc.nombre ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getCostoTotalPorTipoConceptoSinSac(Long idPeriodo,boolean cm){
		Periodo p = Periodo.find.byId(idPeriodo);
		String sql = " SELECT round(sum(ld.cantidad*ld.importe)) monto, lc.liquidacion_concepto_tipo_id tipo "+
				" 	FROM puestos_laborales pl "+ 
				" 	INNER JOIN liquidacion_puestos lp ON pl.id = lp.puesto_laboral_id "+ 
				" 	INNER JOIN liquidacion_detalles ld ON lp.id = ld.liquidacion_puesto_id "+
				" 	INNER JOIN liquidacion_conceptos lc ON ld.liquidacion_concepto_id = lc.id "+
				" 	INNER JOIN liquidacion_meses lm ON lm.id = lp.liquidacion_mes_id "+
				" 	WHERE lm.periodo_id = :periodo_id "+ 
				" 	AND lm.convenio_ministerio =  :cm AND lm.liquidacion_tipo_id in(1,4) "+
				" 	GROUP BY lm.convenio_ministerio,lc.liquidacion_concepto_tipo_id ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getCostoTotalPorTipoConcepto(Long idPeriodo,boolean cm){
		Periodo p = Periodo.find.byId(idPeriodo);
		String sql = " SELECT round(sum(ld.cantidad*ld.importe)) monto, lc.liquidacion_concepto_tipo_id tipo "+
				" 	FROM puestos_laborales pl "+ 
				" 	INNER JOIN liquidacion_puestos lp ON pl.id = lp.puesto_laboral_id "+ 
				" 	INNER JOIN liquidacion_detalles ld ON lp.id = ld.liquidacion_puesto_id "+
				" 	INNER JOIN liquidacion_conceptos lc ON ld.liquidacion_concepto_id = lc.id "+
				" 	INNER JOIN liquidacion_meses lm ON lm.id = lp.liquidacion_mes_id "+
				" 	WHERE lm.periodo_id = :periodo_id "+ 
				" 	AND lm.convenio_ministerio =  :cm "+
				" 	GROUP BY lm.convenio_ministerio,lc.liquidacion_concepto_tipo_id ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
	}
	
	public static List<SqlRow> getCostoTotalPorPeriodo(Long idPeriodo){
		
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = " SELECT round(sum(ld.cantidad*ld.importe)) monto,lm.convenio_ministerio cm " + 
					 " 	FROM puestos_laborales pl " +     
					 " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " +    
					 " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id " + 
					 " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +  
					 " 	WHERE lm.periodo_id = :periodo_id " +
					 "	GROUP BY lm.convenio_ministerio ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static List<SqlRow> getCostoTotalPorPeriodoSinSac(Long idPeriodo){
		
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = " SELECT round(sum(ld.cantidad*ld.importe)) monto,lm.convenio_ministerio cm " + 
					 " 	FROM puestos_laborales pl " +     
					 " 	INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " +    
					 " 	INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id " + 
					 " 	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +  
					 " 	WHERE lm.periodo_id = :periodo_id AND lm.liquidacion_tipo_id in(1,4) " +
					 "	GROUP BY lm.convenio_ministerio ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	
	public static List<SqlRow> getCountPorServicio(Long idPeriodo,boolean cm){
		
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = "SELECT COUNT(distinct(a.id)) count,organigrama_id,nombre  from ( " + 
				" 	SELECT  pl.convenio_ministerio cm,lp.puesto_laboral_id,lp.organigrama_id organigrama_id,o.nombre nombre " + 
				" 	FROM puestos_laborales pl " +   
				"   INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " + 
				" 	INNER JOIN organigramas o on o.id = lp.organigrama_id " +
				"	INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +
				" inner join legajos l on l.id = pl.legajo_id    " +
				" inner join agentes a on a.id = l.agente_id  " +
				" 	WHERE lm.periodo_id = :periodo_id " +
				"	AND pl.convenio_ministerio = :cm " + 
				" 	GROUP BY pl.convenio_ministerio,lp.puesto_laboral_id,lp.organigrama_id,o.nombre " +  
				" ) as coiu group by organigrama_id,nombre ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	
	public static List<SqlRow> getCountPorProfesion(Long idPeriodo,boolean cm){
		
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm,el.id,el.nombre escala,p.id ,p.nombre profesion " + 
				" FROM puestos_laborales pl " + 
				" INNER JOIN legajos l on l.id = pl.legajo_id " +
				" INNER JOIN agentes a on a.id = l.agente_id " +
				" LEFT JOIN profesiones p on p.id = a.profesion_id " + 
				" INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id " +
				" INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " + 
				" INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +
				" WHERE " +
				" lm.periodo_id = :periodo_id " +
				" AND pl.convenio_ministerio = :cm " +    
				" GROUP BY pl.convenio_ministerio,el.id,el.nombre,p.id ,p.nombre " +
				" order by el.id,count ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		//sqlQuery.setParameter("date_stop",p.date_stop);
		//sqlQuery.setParameter("date_start",p.date_start);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static List<SqlRow> getCountPorEscala(Long idPeriodo,boolean cm){
		
		Periodo p = Periodo.find.byId(idPeriodo);
		String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm,el.id,el.nombre nombre " +
				" FROM puestos_laborales pl " +
				" INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id " +
				" INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " + 
				" INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " +
				" inner join legajos l on l.id = pl.legajo_id    " +
				" inner join agentes a on a.id = l.agente_id  " +
				" WHERE " +
				" lm.periodo_id = :periodo_id " +
				" AND pl.convenio_ministerio = :cm  " +
				" AND lm.liquidacion_tipo_id in(1,4) "+
				" GROUP BY pl.convenio_ministerio,el.id,el.nombre order by el.id ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		//sqlQuery.setParameter("date_stop",p.date_stop);
		//sqlQuery.setParameter("date_start",p.date_start);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static List<SqlRow> getCountPorEscalaEnLiquidaciones(Long idPeriodo,boolean cm){
		
		Periodo p = Periodo.find.byId(idPeriodo);
		String sql = "SELECT  COUNT(DISTINCT a.id) count,pl.convenio_ministerio cm,el.id,el.nombre nombre "+
				" FROM liquidacion_puestos lp " +
				" INNER JOIN liquidacion_meses lm ON lm.id = lp.liquidacion_mes_id " +
				" INNER JOIN puestos_laborales pl ON pl.id = lp.puesto_laboral_id " +
				" INNER JOIN escalas_laborales el ON el.id = pl.escala_laboral_id " + 
				" inner join legajos l on l.id = pl.legajo_id    " +
				" inner join agentes a on a.id = l.agente_id  " +
				" WHERE " +
				" lm.periodo_id = :periodo_id " +
				" AND pl.convenio_ministerio = :cm " +
				" GROUP BY pl.convenio_ministerio,el.id,el.nombre " +
				" order by el.id ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	
	public static List<SqlRow> getCountRelacionPorPeriodo(Long idPeriodo){
		
		Periodo p = Periodo.find.byId(idPeriodo);
		String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm " +
				" FROM puestos_laborales pl 	" +
				" INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " + 
				" INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id "+
				" inner join legajos l on l.id = pl.legajo_id    " +
				" inner join agentes a on a.id = l.agente_id  " +
				" WHERE " +
				" lm.periodo_id = :periodo_id " +
				" AND lm.liquidacion_tipo_id in(1,4) " +
				" GROUP BY pl.convenio_ministerio";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		//sqlQuery.setParameter("date_stop",p.date_stop);
		//sqlQuery.setParameter("date_start",p.date_start);
		sqlQuery.setParameter("periodo_id",p.id);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static List<SqlRow> getCountAltasPorPeriodo(Long idPeriodo){
		
		Periodo p = Periodo.find.byId(idPeriodo);
		String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm " +
				" FROM puestos_laborales pl 	" +
				" inner join legajos l on l.id = pl.legajo_id " +
				" inner join agentes a on a.id = l.agente_id  " +
				" WHERE pl.fecha_posesion BETWEEN :date_start AND :date_stop" +
				" GROUP BY pl.convenio_ministerio";
		/*String sql = "SELECT a.id,pl.id count,pl.convenio_ministerio cm " +
				" FROM puestos_laborales pl 	" +
				" inner join legajos l on l.id = pl.legajo_id " +
				" WHERE pl.fecha_posesion BETWEEN :date_start AND :date_stop" +
				" GROUP BY pl.convenio_ministerio";*/
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("date_start",p.date_start);
		sqlQuery.setParameter("date_stop",p.date_stop);
		List<SqlRow>  row = sqlQuery.findList();
		/*Map<String,Map<String,String>> altaList = new HashMap<String, Map<String,String>>();
		
		for(SqlRow sr :row){
			
			if(altaList.containsKey(p.nombre)){
				
				Map<String,String> sstmp2 =  altaList.get(p.nombre);
				if(sr.getBoolean("cm")){
					if(sstmp2.containsKey("cm")){
						Map<String,String> sstmp2 =  altaList.get(p.nombre);
					}else{
						sstmp2.put("cm",sr.getString("count"));
					}
					
				}else{
					sstmp2.put("nocm",sr.getString("count"));
				}
				altaList.put(p.nombre, sstmp2);
			
			
			}else{
				Map<String,String> sstmp = new HashMap<String,String>();
				if(sr.getBoolean("cm")){
					sstmp.put("cm",sr.getString("count"));
				}else{
					sstmp.put("nocm",sr.getString("count"));
				}
				altaList.put(p.nombre, sstmp);
			}
		}*/
		
		
		return row;
		
	}
	
	public static List<SqlRow> getCountBajasPorPeriodo(Long idPeriodo){
		
		Periodo p = Periodo.find.byId(idPeriodo);
		
		String sql = "SELECT COUNT(distinct(a.id)) count,pl.convenio_ministerio cm " +
				" FROM puestos_laborales pl 	" +
				" inner join legajos l on l.id = pl.legajo_id " +
				" inner join agentes a on a.id = l.agente_id  " +
				" WHERE pl.fecha_baja BETWEEN :date_start AND :date_stop   " +
				//" WHERE pl.fecha_baja BETWEEN '2016-01-01' AND '2016-01-31'   " +
				" GROUP BY pl.convenio_ministerio";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		sqlQuery.setParameter("date_start",p.date_start);
		sqlQuery.setParameter("date_stop",p.date_stop);
		List<SqlRow>  row = sqlQuery.findList();
		
		return row;
		
	}
	
	public static List<SqlRow> getTotalFinalUnicoPeriodoPorEscala(Long idPeriodo,boolean cm,boolean sinsac){
		Periodo p = Periodo.find.byId(idPeriodo);
		String sql = /*" SELECT " +
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) hca, " + 
				
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) hsa, " +
				
				" round(COALESCE(SUM(CASE WHEN lc.id = 5 OR lc.id = 204 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) jubilacion, " +
				" round(COALESCE(SUM(CASE WHEN lc.id = 4 OR lc.id = 203 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) os, " +
				" round(COALESCE(SUM(CASE WHEN lc.id = 6 OR lc.id = 205 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) sv, " +
				" round(COALESCE(SUM(CASE WHEN lc.id = 7 OR lc.id = 206 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) ss, " +
				" round(COALESCE(SUM(CASE WHEN lc.id = 548 OR lc.id = 562 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) ig, " +
				" round(COALESCE(SUM(CASE WHEN lc.id = 20 OR lc.id = 427 OR lc.id = 466 OR lc.id = 488 OR lc.id = 508 OR lc.id = 509 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) oi, " +
				
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3 AND lc.id <> 20 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) totalret, " +
				
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) " +
				" + " +
				" COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) " +
				" - " +
				" COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) neto, " +
				
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) * 0.1) hpjub, " +
				" round(COALESCE(SUM(CASE WHEN ((lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1) AND  lm.liquidacion_tipo_id in(1,4)) THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) * 0.02) hpos, " +
				
				" round(round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0),2) " + 
				" + " +
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0),2) " +
				" + " +
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) * 0.1,2) " +
				" + " +
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) * 0.02,2) " +
				" + " +
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3 AND lc.id <> 20 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0))) bruto, " +
				" el.nombre nombre " + 
				" FROM puestos_laborales pl " +     
				" INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id " +
				" INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id " +  
				" INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id " + 
				" INNER JOIN liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id " + 
				" INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id " + 
				" WHERE " +
				" lm.periodo_id =:periodo_id AND " +
				" lm.convenio_ministerio = :cm ";
				//" AND lm.id = 442 ";
				if(sinsac){
					sql += " AND lm.liquidacion_tipo_id in(1,4)";
				}*/
				
				"SELECT  " +
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) hca, " +  
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) hsa, " + 
				" round(COALESCE(SUM(CASE WHEN lc.id = 5 OR lc.id = 204 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) jubilacion, " + 
				" round(COALESCE(SUM(CASE WHEN lc.id = 4 OR lc.id = 203 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) os, " + 
				" round(COALESCE(SUM(CASE WHEN lc.id = 6 OR lc.id = 205 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) sv, " +  
				" round(COALESCE(SUM(CASE WHEN lc.id = 7 OR lc.id = 206 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) ss, " +  
				" round(COALESCE(SUM(CASE WHEN lc.id = 548 OR lc.id = 591 OR lc.id = 562 OR lc.id = 584 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) ig, " + 
				" round(COALESCE(SUM(CASE WHEN lc.id = 20 OR lc.id = 427 OR lc.id = 466 OR lc.id = 488 OR lc.id = 508 OR lc.id = 509 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) oi, " + 
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3  THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) totalret, " +
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) " + 
				" +   " +
				" COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) " + 
				" -   " +
				" COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0)) neto,  " +
				" round(COALESCE(SUM(CASE WHEN ((lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1) AND  lm.liquidacion_tipo_id in(1,4,2))THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) * (p.patronal_jubilacion_porcentaje/100)) hpjub, " +  
				" round(COALESCE(SUM(CASE WHEN ((lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1) AND  lm.liquidacion_tipo_id in(1,4)) THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) * (p.patronal_obrasocial_porcentaje/100)) hpos, " +  
				" round(round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0),2)  " +
				" +  " +
				" round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0))  " + 
				" +   " +
				" round(COALESCE(SUM(CASE WHEN (lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1) AND  lm.liquidacion_tipo_id in(1,4,2) THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) * 0.1) " +
				" +  " +
				" round(COALESCE(SUM(CASE WHEN (lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1) AND  lm.liquidacion_tipo_id in(1,4) THEN round(ld.cantidad*ld.importe,2) ELSE 0 END ),0) * 0.02) " +
				" )  " +
				" bruto, " +
				" el.nombre nombre  " +
				" FROM puestos_laborales pl  " +   
				" INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id  " +
				" INNER JOIN liquidacion_puestos lp on pl.id = lp.puesto_laboral_id  " +
				" INNER JOIN liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id  " +
				" INNER JOIN liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id   " +
				" INNER JOIN liquidacion_meses lm on lm.id = lp.liquidacion_mes_id   " +
				" INNER JOIN periodos p on p.id = lm.periodo_id  " +
				" WHERE   " +
				" lm.periodo_id =:periodo_id AND   " +
				" lm.convenio_ministerio = :cm ";
				if(sinsac){
					sql += " AND lm.liquidacion_tipo_id in(1,4)";
				} 
				 
				sql += " GROUP BY lm.convenio_ministerio,el.nombre,p.patronal_jubilacion_porcentaje,p.patronal_obrasocial_porcentaje ";
		
		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		
		sqlQuery.setParameter("periodo_id",p.id);
		sqlQuery.setParameter("cm",cm);
		List<SqlRow>  row = sqlQuery.findList();
		return row;
	}
	
	
	/**********QUERY SALDOS POR SERVICIOS*********************
	WITH RECURSIVE recursetree(id, padre_id) AS (  
   SELECT id, padre_id FROM organigramas 
   --WHERE id = 2
 UNION  
   SELECT t.id, t.padre_id  
   FROM organigramas t  
   JOIN recursetree rt ON rt.id = t.padre_id  
 )  
select o.id,o.padre_id, o.nombre,  
COUNT(DISTINCT a.id) cantidadEmpleados ,
round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 4 OR lc.liquidacion_concepto_tipo_id = 1 THEN cantidad * importe ELSE 0 END ),0)) totalConAporte,  
round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 2 THEN cantidad * importe ELSE 0 END ),0)) totalSinAporte, 
round(COALESCE(SUM(CASE WHEN lc.liquidacion_concepto_tipo_id = 3 THEN cantidad * importe ELSE 0 END ),0)) totalRetenciones
from liquidacion_puestos lp  
inner join liquidacion_meses lm on  lm.id = lp.liquidacion_mes_id 
inner join liquidacion_detalles ld on lp.id = ld.liquidacion_puesto_id  
inner join liquidacion_conceptos lc on lc.id = ld.liquidacion_concepto_id  
inner join puestos_laborales pl on pl.id = lp.puesto_laboral_id  
inner join legajos l on l.id = pl.legajo_id  
inner join agentes a on a.id = l.agente_id  
inner join organigramas o on o.id = lp.organigrama_id
where (lp.organigrama_id in (SELECT id FROM recursetree)) 
and lm.periodo_id =73
and pl.convenio_ministerio = true
and lm.liquidacion_tipo_id in(1,4)
group by o.id ORDER BY o.padre_id,cantidadEmpleados desc
*///////////////////////////////////////
	
/*********************************************************
select el.nombre,round(sum(cl.cantidad*cl.precio)) from certificaciones c
inner join certificaciones_lineas cl on cl.certificacion_id = c.id
inner join proveedores p on p.id = c.proveedor_id
inner join agentes a on a.id = p.agente_id
inner join legajos l on l.agente_id = a.id
inner join puestos_laborales pl on l.id = pl.legajo_id
INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id 
where c.expediente_id = 13433
and pl.convenio_ministerio = false
and pl.activo = true 
and periodo_id = 67
GROUP BY  el.nombre order by el.nombre
	
select pr.categoria_id,ca.nombre,round(sum(cl.cantidad*cl.precio)) from certificaciones c
inner join certificaciones_lineas cl on cl.certificacion_id = c.id
inner join proveedores p on p.id = c.proveedor_id
inner join agentes a on a.id = p.agente_id
inner join legajos l on l.agente_id = a.id
inner join puestos_laborales pl on l.id = pl.legajo_id
INNER JOIN escalas_laborales el on el.id = pl.escala_laboral_id
inner join productos pr on pr.id = cl.producto_id 
inner join categorias ca on ca.id = pr.categoria_id
where c.expediente_id = 13433 
and pl.convenio_ministerio = true
and pl.activo = true 
and periodo_id = 67
GROUP BY  pr.categoria_id,ca.nombre order by pr.categoria_id	

select el.nombre,round(sum(cl.cantidad*cl.precio)) 
from certificaciones c
inner join certificaciones_lineas cl on cl.certificacion_id = c.id
inner join proveedores p on p.id = c.proveedor_id
inner join agentes a on a.id = p.agente_id
inner join legajos l on l.agente_id = a.id
inner join puestos_laborales pl on l.id = pl.legajo_id
INNER JOIN organigramas el on el.id = a.organigrama_id 
where c.expediente_id = 13433 
and pl.convenio_ministerio = true
and pl.activo = true 
and periodo_id = 67
GROUP BY  el.nombre order by el.nombre
	
	
	
*/ 
	
}
