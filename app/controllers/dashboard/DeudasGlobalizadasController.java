package controllers.dashboard;

import static play.data.Form.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.avaje.ebean.SqlRow;

import models.ActaRecepcion;
import models.Deposito;
import models.Estado;
import models.Periodo;
import models.Proveedor;
import models.TipoCuenta;
import models.Usuario;
import models.auth.Permiso;
import models.informes.InformeDeudaProveedoresMaterializada;
import models.informes.InformeEstadisticoDeudaProveedores;
import controllers.Secured;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NumberUtils;
import utils.ReportesExcelsUtils;
import utils.RequestVar;
import utils.pagination.Pagination;
import views.html.sinPermiso;
import views.html.dashboard.deudasGlobalizadas.*;

@Security.Authenticated(Secured.class)
public class DeudasGlobalizadasController extends Controller {

	public static Result index(boolean soloDeuda) {
		DynamicForm d = form().bindFromRequest();
		return ok(index.render(d,soloDeuda));
	}

	public static Result deudasDetallesCuentas(Integer idCuenta,boolean soloDeuda) {

		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		DynamicForm d = form().bindFromRequest();
		TipoCuenta tc = TipoCuenta.find.byId(idCuenta.longValue());

		List<SqlRow> listadoPorCuentaHEARM= InformeDeudaProveedoresMaterializada.getDeudaPorCuenta(idCuenta,(long)Deposito.HEARM,soloDeuda);
		List<SqlRow> listadoPorCuentaOtros= InformeDeudaProveedoresMaterializada.getDeudaPorCuenta(idCuenta,null,soloDeuda);

		if(soloDeuda) {
			return ok(deudasCuentasSoloDeuda.render(listadoPorCuentaHEARM,listadoPorCuentaOtros,idCuenta,tc.nombre,d,soloDeuda));
		}else {
			return ok(deudasCuentas.render(listadoPorCuentaHEARM,listadoPorCuentaOtros,idCuenta,tc.nombre,d,soloDeuda));
		}



	}

	public static Result deudasDetallesOtros(boolean profe,boolean equipamientos,boolean soloDeuda) {

		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		DynamicForm d = form().bindFromRequest();
		List<SqlRow> proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesOtros(profe,(long)Deposito.HEARM,equipamientos,soloDeuda);

		List<SqlRow> proveedorOtros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesOtros(profe,null,equipamientos,soloDeuda);

		String cuenta = (profe)?"PROFE":"OPERATIVA";

		if(soloDeuda) {
			return ok(deudasDetallesOtrosSoloDeuda.render(proveedorHEARM,proveedorOtros,cuenta,profe,equipamientos,d,soloDeuda));
		}else {
			return ok(deudasDetallesOtros.render(proveedorHEARM,proveedorOtros,cuenta,profe,equipamientos,d,soloDeuda));
		}
	}

	public static Result deudasDetallesServicios(boolean soloDeuda) {

		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		DynamicForm d = form().bindFromRequest();
		List<SqlRow> proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServicios((long)Deposito.HEARM,false);
		List<SqlRow> proveedorOtros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServicios(null,false);
		List<SqlRow> proveedorTodos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServicios(null,true);

		Map<Long,BigDecimal> periodoDeuda = new HashMap<Long, BigDecimal>();
		Map<String,Map<Long,BigDecimal>> pret = new HashMap<String, Map<Long,BigDecimal>>();
		Map<String,BigDecimal> deudaSinPeriodos = new HashMap<String,BigDecimal>();
		List<Long> peridoIds = new ArrayList<Long>();

		for(SqlRow ph :proveedorTodos){

			BigDecimal totalDeuda = ph.getBigDecimal("total_deuda");
			Long idOrdenProvision = ph.getLong("orden_provision_id");
			Long idExpediente = ph.getLong("expediente_id");

			String expedienteOp = ph.getLong("expediente_id").toString()+ph.getLong("orden_provision_id").toString();

			if(totalDeuda.compareTo(BigDecimal.ZERO) > 0){

				if(idOrdenProvision != null ){
					List<ActaRecepcion> arl = ActaRecepcion.getListaActasDeudas(idOrdenProvision,null);
					if(arl.size() > 0){
						for(ActaRecepcion ar: arl){

							if(ar.periodo_id != null && ar.periodo_id.compareTo(new Long(0)) != 0){

								if(pret.containsKey(expedienteOp)){
									Map<Long,BigDecimal> periodoDeudaTmp = pret.get(expedienteOp);

									if(periodoDeudaTmp.containsKey(ar.periodo_id)){
										BigDecimal arTotalTmp = periodoDeudaTmp.get(ar.periodo_id);
										arTotalTmp = arTotalTmp.add(ar.total);
										periodoDeudaTmp.put(ar.periodo_id, arTotalTmp);
										pret.put(expedienteOp, periodoDeudaTmp);

									}else{
										periodoDeudaTmp.put(ar.periodo_id, ar.total);
										pret.put(expedienteOp, periodoDeudaTmp);
									}
								}else{
									periodoDeuda = new HashMap<Long, BigDecimal>();
									periodoDeuda.put(ar.periodo_id, ar.total);
									pret.put(expedienteOp, periodoDeuda);

								}

								if(!peridoIds.contains(ar.periodo_id)){
									peridoIds.add(ar.periodo_id);
								}

							}else{
								if(deudaSinPeriodos.containsKey(expedienteOp)){
									BigDecimal arTotalTmp = deudaSinPeriodos.get(expedienteOp);
									arTotalTmp = arTotalTmp.add(ar.total);
									deudaSinPeriodos.put(expedienteOp, arTotalTmp);
								}else{
									deudaSinPeriodos.put(expedienteOp, ar.total);
								}
							}
						}
					}else{
						deudaSinPeriodos.put(expedienteOp, totalDeuda);
					}
				}else{
					deudaSinPeriodos.put(expedienteOp, totalDeuda);
				}
			}
		}

		Collections.sort(peridoIds);

		return ok(deudasDetallesServicios.render(proveedorHEARM,proveedorOtros,peridoIds,pret,deudaSinPeriodos,d,soloDeuda));
	}

	public static Result deudasDetallesHonorarios(boolean soloDeuda) {

		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		DynamicForm d = form().bindFromRequest();
		List<SqlRow> proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesHonorarios((long)Deposito.HEARM);
		List<SqlRow> proveedorOtros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesHonorarios(null);

		return ok(deudasDetallesHonorarios.render(proveedorHEARM,proveedorOtros,d,soloDeuda));

	}

	public static Result deudasDetallesPorProveedor(boolean soloDeuda) {
		DynamicForm d = form().bindFromRequest();

		if(RequestVar.get("proveedor.id") != null && !RequestVar.get("proveedor.id").isEmpty()) {
			InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();


			Integer idProveedor = new Integer(RequestVar.get("proveedor.id"));
			boolean ra = (idProveedor.compareTo(new Integer(14947)) == 0)?true:false;

			Map<String,Map<String,Map<Integer,List<SqlRow>>>> listaFinal = InformeDeudaProveedoresMaterializada.getListaFinalDeudasDetallesReporte(idProveedor,ra,soloDeuda);

			String proveedor = "R.A.";
			if(!ra){
				Proveedor p = Proveedor.find.byId(idProveedor.longValue());
				proveedor = p.nombre;
			}

			return ok(deudasDetallas.render(ra,idProveedor,listaFinal,proveedor,d,soloDeuda));
		}else {
			flash("error", "Debe Seleccionar un proveedor.");
			return ok(index.render(d,soloDeuda));
		}


	}

	public static Result deudasDetalles(Integer idProveedor,boolean ra,boolean soloDeuda) {

		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		DynamicForm d = form().bindFromRequest();
		Map<String,Map<String,Map<Integer,List<SqlRow>>>> listaFinal = InformeDeudaProveedoresMaterializada.getListaFinalDeudasDetallesReporte(idProveedor,ra,soloDeuda);

		String proveedor = "R.A.";
		if(!ra){
			Proveedor p = Proveedor.find.byId(idProveedor.longValue());
			proveedor = p.nombre;
		}
		if(soloDeuda) {
			return ok(deudasDetallasSoloDeuda.render(ra,idProveedor,listaFinal,proveedor,d,soloDeuda));
		}else {
			return ok(deudasDetallas.render(ra,idProveedor,listaFinal,proveedor,d,soloDeuda));
		}
	}



	public static Result deudasResumidas(Integer deposito,boolean ra,boolean soloDeuda) {

		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		DynamicForm d = form().bindFromRequest();

		List<SqlRow> proveedoresDestacados = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,false,deposito,ra,false,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,false,deposito,ra,true,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,false,deposito,ra,false,false,true,soloDeuda);
		List<SqlRow> proveedoresNoDestacados = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosEquipos = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosServicios = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosHonorarios = new ArrayList<SqlRow>();
		if(!ra){
			Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			proveedoresNoDestacados = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,false,false,false,soloDeuda);

			proveedoresNoDestacadosServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,true,false,false,soloDeuda);
			proveedoresNoDestacadosHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,false,false,true,soloDeuda);
			proveedoresNoDestacadosEquipos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,false,deposito,ra,false,true,false,soloDeuda);
		}

		List<SqlRow> proveedoresDestacadosProfe = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,true,deposito,ra,false,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosProfeServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,true,deposito,ra,true,false,false,soloDeuda);
		List<SqlRow> proveedoresDestacadosProfeHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(true,true,deposito,ra,false,false,true,soloDeuda);
		List<SqlRow> proveedoresNoDestacadosProfe = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeEquipos = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeServicios = new ArrayList<SqlRow>();
		List<SqlRow> proveedoresNoDestacadosProfeHonorarios = new ArrayList<SqlRow>();
		if(!ra){
			proveedoresNoDestacadosProfe = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,false,false,false,soloDeuda);
			proveedoresNoDestacadosProfeServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,true,false,false,soloDeuda);
			proveedoresNoDestacadosProfeEquipos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,false,true,false,soloDeuda);
			proveedoresNoDestacadosProfeHonorarios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorAgrupados(false,true,deposito,ra,false,false,true,soloDeuda);
		}



		String depositonNombre = (ra)?"GENERAL R.A.":"GENERAL";
		switch ( deposito.intValue() ) {
	      case  Deposito.HEARM:
	    	  depositonNombre = "HEARM";
	    	break;
	      case  -1:
	    	  depositonNombre = "OTRAS INSTITUCIONES";
	    	break;
	      	default:
		         System.out.println("error" );
		         break;
		}

		if(soloDeuda) {
			return ok(deudasResumidasSoloDeuda.render(depositonNombre,
					proveedoresDestacados,
					proveedoresDestacadosServicios,
					proveedoresNoDestacados,
					proveedoresNoDestacadosServicios,
					proveedoresNoDestacadosEquipos,
					proveedoresDestacadosProfe,
					proveedoresDestacadosProfeServicios,
					proveedoresNoDestacadosProfe,
					proveedoresNoDestacadosProfeServicios,
					proveedoresNoDestacadosProfeEquipos,
					proveedoresDestacadosHonorarios,
					proveedoresNoDestacadosHonorarios,
					proveedoresDestacadosProfeHonorarios,
					proveedoresNoDestacadosProfeHonorarios,
					deposito,ra,d,soloDeuda));
		}else {
			return ok(deudasResumidas.render(depositonNombre,
					proveedoresDestacados,
					proveedoresDestacadosServicios,
					proveedoresNoDestacados,
					proveedoresNoDestacadosServicios,
					proveedoresNoDestacadosEquipos,
					proveedoresDestacadosProfe,
					proveedoresDestacadosProfeServicios,
					proveedoresNoDestacadosProfe,
					proveedoresNoDestacadosProfeServicios,
					proveedoresNoDestacadosProfeEquipos,
					proveedoresDestacadosHonorarios,
					proveedoresNoDestacadosHonorarios,
					proveedoresDestacadosProfeHonorarios,
					proveedoresNoDestacadosProfeHonorarios,
					deposito,ra,d,soloDeuda));
		}


	}


	public static Result deudasDetallesOtrosProveedoresResumen(boolean profe,boolean equipamientos,boolean soloDeuda) {

		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		DynamicForm d = form().bindFromRequest();
		List<SqlRow> proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorOtroProveedoresResumen(profe,(long)Deposito.HEARM,equipamientos);
		List<SqlRow> proveedorOtros = null;
		//List<SqlRow> proveedorOtros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesOtros(profe,null,equipamientos);

		String cuenta = (profe)?"PROFE":"OPERATIVA";

		return ok(deudasOtrosProveedoresResumen.render(proveedorHEARM,proveedorOtros,cuenta,profe,equipamientos,d,soloDeuda));

	}

	public static Result deudasDetallesServiciosResumen(boolean soloDeuda) {

		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		DynamicForm d = form().bindFromRequest();
		//List<SqlRow> proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServicios((long)Deposito.HEARM,false);
		//List<SqlRow> proveedorOtros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServicios(null,false);
		List<SqlRow> proveedorTodos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesServiciosResumen(null,true);



		return ok(deudasDetallesServiciosResumen.render(proveedorTodos,d,soloDeuda));
	}

	public static Result deudasDetallesHonorariosResumen(boolean soloDeuda) {

		InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
		DynamicForm d = form().bindFromRequest();
		//List<SqlRow> proveedorHEARM = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorDetallesHonorarios((long)Deposito.HEARM);
		List<SqlRow> proveedorTodos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedorHonorariosResumen(null);

		return ok(deudasDetallesHonorariosResumen.render(proveedorTodos,d,soloDeuda));

	}

	public static Result index082023(boolean soloDeuda) {
		DynamicForm d = form().bindFromRequest();
		return ok(index082023.render(d,soloDeuda));
	}

	public static Result resumen082023() {

		DynamicForm d = form().bindFromRequest();
		List<SqlRow> proveedoresDestacados = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresDestacados(null,null,null);

		List<Integer> otrosServicios = new ArrayList<Integer>();
		otrosServicios.add(5);//5	"OTROS SERVICIOS" X
		otrosServicios.add(7);//7	"SERVICIOS"x

		List<SqlRow> proveedoresOtrosServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresPorRubro(null,otrosServicios);

		List<Integer> otros = new ArrayList<Integer>();
		otros.add(3);//3	"INSUMOS VARIOS" X
		otros.add(4);//4	"MEDICAMENTOS"   X
		otros.add(6);//6	"PROTESIS" X
		otros.add(2);//2	"ESTUDIOS MEDICOS"
		otros.add(9);//9	"REFACCIONES"

		List<SqlRow> proveedoresOtrosRubros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresPorRubro(null,otros);

		List<Integer> equipos = new ArrayList<Integer>();
		equipos.add(1);//1	"EQUIPAMIENTOS" x
		List<SqlRow> proveedoresOtrosEquipos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresPorRubro(null,equipos);

		//List<SqlRow> proveedoresBisionesServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresDestacados(null,7,14733);

		return ok(resumen082023.render(d,proveedoresDestacados,proveedoresOtrosServicios,proveedoresOtrosRubros,proveedoresOtrosEquipos));

		/*	10	"HABERES"
			8	"HONORARIOS" X
		 * */
	}

	public static Result resumen082023ExportExcel() {

		String dirTemp = System.getProperty("java.io.tmpdir");
		Date ahora = new Date();
		DynamicForm d = form().bindFromRequest();
		File archivo = new File(dirTemp+"/INFORME-RESUMEN-"+utils.DateUtils.formatDate(ahora, "dd-MM-yyyy")+"-"+Usuario.getUsuarioSesion()+".xls");

		List<SqlRow> proveedoresDestacados = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresDestacados(null,null,null);

		List<Integer> otrosServiciosList = new ArrayList<Integer>();
		otrosServiciosList.add(5);//5	"OTROS SERVICIOS" X
		otrosServiciosList.add(7);//7	"SERVICIOS"x

		List<SqlRow> proveedoresOtrosServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresPorRubro(null,otrosServiciosList);

		List<Integer> otrosList = new ArrayList<Integer>();
		otrosList.add(3);//3	"INSUMOS VARIOS" X
		otrosList.add(4);//4	"MEDICAMENTOS"   X
		otrosList.add(6);//6	"PROTESIS" X
		otrosList.add(2);//2	"ESTUDIOS MEDICOS"
		otrosList.add(9);//9	"REFACCIONES"

		List<SqlRow> proveedoresOtrosRubros = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresPorRubro(null,otrosList);

		List<Integer> equiposList = new ArrayList<Integer>();
		equiposList.add(1);//1	"EQUIPAMIENTOS" x
		List<SqlRow> proveedoresOtrosEquipos = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresPorRubro(null,equiposList);

		//List<SqlRow> proveedoresBisionesServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresDestacados(null,7,14733);

		BigDecimal total = new BigDecimal(0);
		BigDecimal total_tramite = new BigDecimal(0);
		BigDecimal total_ra = new BigDecimal(0);
		BigDecimal total_tramite_ra = new BigDecimal(0);
		BigDecimal total_teje = new BigDecimal(0);
		BigDecimal total_tramite_teje = new BigDecimal(0);
		BigDecimal total_yaka = new BigDecimal(0);
		BigDecimal total_tramite_yaka = new BigDecimal(0);
		BigDecimal total_ips = new BigDecimal(0);
		BigDecimal total_tramite_ips = new BigDecimal(0);
		BigDecimal total_bisio = new BigDecimal(0);
		BigDecimal total_tramite_bisio = new BigDecimal(0);

		BigDecimal total_safita = new BigDecimal(0);
		BigDecimal total_tramite_safita = new BigDecimal(0);
		BigDecimal total_sanjorge = new BigDecimal(0);
		BigDecimal total_tramite_sanjorge = new BigDecimal(0);
		BigDecimal total_nr = new BigDecimal(0);
		BigDecimal total_tramite_nr = new BigDecimal(0);
		BigDecimal total_pacific = new BigDecimal(0);
		BigDecimal total_tramite_pacific = new BigDecimal(0);
		BigDecimal total_pindoi = new BigDecimal(0);
		BigDecimal total_tramite_pindoi = new BigDecimal(0);
		BigDecimal total_cms = new BigDecimal(0);
		BigDecimal total_tramite_cms = new BigDecimal(0);

		for(SqlRow pd:proveedoresDestacados) {
			if(Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id"))) {
				total_ra= total_ra.add(pd.getBigDecimal("total_deuda"));
				total_tramite_ra= total_tramite_ra.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
			}

			if(Proveedor.getProveedoresTejedor().contains(pd.getLong("proveedor_id"))){
				total_teje= total_teje.add(pd.getBigDecimal("total_deuda"));
				total_tramite_teje= total_tramite_teje.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
				total = total.add(total_teje);
				total_tramite = total_tramite.add(total_tramite_teje);
			}

			if(Proveedor.getProveedoresYacaro().contains(pd.getLong("proveedor_id"))){
				total_yaka= total_yaka.add(pd.getBigDecimal("total_deuda"));
				total_tramite_yaka= total_tramite_yaka.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
				total = total.add(total_yaka);
				total_tramite = total_tramite.add(total_tramite_yaka);
			}

			if(pd.getLong("proveedor_id").compareTo(new Long(11081)) == 0){
				total_ips= total_ips.add(pd.getBigDecimal("total_deuda"));
				total_tramite_ips= total_tramite_ips.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
			}

			if(pd.getLong("proveedor_id").compareTo(new Long(14733)) == 0){
				total_bisio= total_bisio.add(pd.getBigDecimal("total_deuda"));
				total_tramite_bisio= total_tramite_bisio.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")

				total = total.add(total_bisio);
				total_tramite = total_tramite.add(total_tramite_bisio);
			}
			//////////////////////////////////////////////////////////////////////
			if(pd.getLong("proveedor_id").compareTo(new Long(2713)) == 0){ //SAFITA
				total_safita= total_safita.add(pd.getBigDecimal("total_deuda"));
				total_tramite_safita= total_tramite_safita.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
				total = total.add(total_safita);
				total_tramite = total_tramite.add(total_tramite_safita);
			}

			if(pd.getLong("proveedor_id").compareTo(new Long(4359)) == 0){ //SAN JORGE
				total_sanjorge= total_sanjorge.add(pd.getBigDecimal("total_deuda"));
				total_tramite_sanjorge= total_tramite_sanjorge.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
				total = total.add(total_sanjorge);
				total_tramite = total_tramite.add(total_tramite_sanjorge);
			}

			if(pd.getLong("proveedor_id").compareTo(new Long(1589)) == 0){ //NR
				total_nr= total_nr.add(pd.getBigDecimal("total_deuda"));
				total_tramite_nr= total_tramite_nr.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
				total = total.add(total_nr);
				total_tramite = total_tramite.add(total_tramite_nr);
			}

			if(pd.getLong("proveedor_id").compareTo(new Long(1838)) == 0){ //PACIFIC OCEAN
				total_pacific= total_pacific.add(pd.getBigDecimal("total_deuda"));
				total_tramite_pacific= total_tramite_pacific.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
				total = total.add(total_pacific);
				total_tramite = total_tramite.add(total_tramite_pacific);
			}

			if(pd.getLong("proveedor_id").compareTo(new Long(1592)) == 0){ //PINDOI
				total_pindoi= total_pindoi.add(pd.getBigDecimal("total_deuda"));
				total_tramite_pindoi= total_tramite_pindoi.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
				total = total.add(total_pindoi);
				total_tramite = total_tramite.add(total_tramite_pindoi);
			}

			if(pd.getLong("proveedor_id").compareTo(new Long(1588)) == 0){ //CMS
				total_cms= total_cms.add(pd.getBigDecimal("total_deuda"));
				total_tramite_cms= total_tramite_cms.add(BigDecimal.ZERO);//pd.getBigDecimal("total_compromiso")
				total = total.add(total_cms);
				total_tramite = total_tramite.add(total_tramite_cms);
			}

		}


		try {
			if(archivo.exists()) archivo.delete();
			archivo.createNewFile();


			FileOutputStream archivoTmp = new FileOutputStream(archivo);
			Workbook libro = new HSSFWorkbook();

			ReportesExcelsUtils reu = new ReportesExcelsUtils();
			CellStyle estiloMoneda = reu.getEstiloMonedaSinDecimales(libro);
			CellStyle comun = reu.getEstiloComun(libro);
			CellStyle cabeceraPrincipal = reu.getCabecera(libro,14);
			CellStyle cabecera = reu.getCabecera(libro,10);

			Sheet hoja = libro.createSheet("RESUMEN");
			hoja.setColumnWidth(0, 15000);
			hoja.setColumnWidth(1, 5000);
			hoja.setColumnWidth(2, 5000);
			hoja.setColumnWidth(3, 5000);
			hoja.setDefaultRowHeight( (short) 400);

			int x = 0;
			Row fila = hoja.createRow(x);
			Cell celda0 = fila.createCell(0);
			celda0.setCellValue("RESUMEN");
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
			x++;

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("PROVEEDORES");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(1);
			celda0.setCellValue("DEUDA");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(2);
			celda0.setCellValue("DEUDA EN TRAMITE");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(3);
			celda0.setCellValue("TOTAL");
			celda0.setCellStyle(cabecera);
			x++;


			/////////////////////////BISIONES////////////////////////////
			/*BigDecimal total_bisioservicios = new BigDecimal(0);
			BigDecimal total_tramite_bisioservicios = new BigDecimal(0);

			for(SqlRow bisionesServicios:proveedoresBisionesServicios) {

				total_bisioservicios= total_bisioservicios.add(bisionesServicios.getBigDecimal("total_deuda"));
				total_tramite_bisioservicios= total_tramite_bisioservicios.add(BigDecimal.ZERO);//bisionesServicios.getBigDecimal("total_compromiso")

			}*/

			//total = total.subtract(total_bisioservicios);
			//total_tramite = total_tramite.subtract(total_tramite_bisioservicios);

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("BISIONES");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_bisio.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_bisio.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_bisio.add(total_tramite_bisio).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;


			//total = total.add(total_bisioservicios);
			//total_tramite = total_tramite.add(total_tramite_bisioservicios);

			/*fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("BISIONES (Servicios)");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_bisioservicios.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_bisioservicios.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_bisioservicios.add(total_tramite_bisioservicios).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;*/

			////////////////////////SAFITA////////////////////////////
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("SAFITA");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_safita.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_safita.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue(total_safita.add(total_tramite_safita).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;

			////////////////////////SAN JORGE////////////////////////////
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("SAN JORGE");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_sanjorge.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_sanjorge.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_sanjorge.add(total_tramite_sanjorge).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;

			////////////////////////TEJEDOR////////////////////////////
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TEJEDOR (protesis + dialisis + alimentacion parenteral)");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_teje.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_teje.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_teje.add(total_tramite_teje).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;

////////////////////////NR////////////////////////////
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("NR (mensual + insumos)");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_nr.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_nr.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_nr.add(total_tramite_nr).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;

////////////////////////YAKARO////////////////////////////
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("YAKARO (incluido Mission Group)");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_yaka.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_yaka.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_yaka.add(total_tramite_yaka).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;

////////////////////////PACIFIC////////////////////////////
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("Pacific Ocean");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_pacific.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_pacific.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue(total_pacific.add(total_tramite_pacific).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
////////////////////////Constructora Pindoi	////////////////////////////
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("Constructora Pindoi");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_pindoi.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_pindoi.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue(total_pindoi.add(total_tramite_pindoi).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;
////////////////////////CMS////////////////////////////
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("CMS");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_cms.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_cms.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue(total_cms.add(total_tramite_cms).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;


			/*for(SqlRow pd:proveedoresDestacados) {
				if(pd.getLong("proveedor_id").compareTo(new Long(14733)) != 0 && pd.getLong("proveedor_id").compareTo(new Long(11081)) != 0 && pd.getLong("proveedor_id").compareTo(new Long(15631)) != 0 && !Proveedor.getProveedoresYacaro().contains(pd.getLong("proveedor_id")) && !Proveedor.getProveedoresDestacadosRA().contains(pd.getLong("proveedor_id")) && !Proveedor.getProveedoresTejedor().contains(pd.getLong("proveedor_id"))){

					fila = hoja.createRow(x);
					celda0 = fila.createCell(0);
					celda0.setCellValue(pd.getString("nombre_proveedor"));
					celda0.setCellStyle(comun);

					celda0 = fila.createCell(1);
					celda0.setCellValue(pd.getBigDecimal("total_deuda").doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(2);
					celda0.setCellValue(BigDecimal.ZERO.doubleValue());
					celda0.setCellStyle(estiloMoneda);
					celda0 = fila.createCell(3);
					celda0.setCellValue( pd.getBigDecimal("total_deuda").add(BigDecimal.ZERO).doubleValue());
					celda0.setCellStyle(estiloMoneda);
					x++;

					total = total.add(pd.getBigDecimal("total_deuda"));
					total_tramite = total_tramite.add(BigDecimal.ZERO);//pd.getBigDecimal("total_deuda")
				}
			}*/






			BigDecimal total_servicios = new BigDecimal(0);
			BigDecimal total_tramite_servicios = new BigDecimal(0);

			for(SqlRow otrosServicios:proveedoresOtrosServicios) {

				total_servicios= total_servicios.add(otrosServicios.getBigDecimal("total_deuda"));
				total_tramite_servicios= total_tramite_servicios.add(BigDecimal.ZERO);//otrosServicios.getBigDecimal("total_compromiso")
			}
			total = total.add(total_servicios);
			total_tramite = total_tramite.add(total_tramite_servicios);

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("OTROS SERVICIOS");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_servicios.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_servicios.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_servicios.add(total_tramite_servicios).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;

			BigDecimal total_otros = new BigDecimal(0);
			BigDecimal total_tramite_otros = new BigDecimal(0);
			for(SqlRow otros:proveedoresOtrosRubros) {

				total_otros= total_otros.add(otros.getBigDecimal("total_deuda"));
				total_tramite_otros= total_tramite_otros.add(BigDecimal.ZERO);//otros.getBigDecimal("total_compromiso")
			}
			total = total.add(total_otros);
			total_tramite = total_tramite.add(total_tramite_otros);


			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("OTROS");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_otros.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_otros.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_otros.add(total_tramite_otros).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;

			BigDecimal total_equipo = new BigDecimal(0);
			BigDecimal total_tramite_equipo = new BigDecimal(0);
			for(SqlRow equipos:proveedoresOtrosEquipos) {
				total_equipo = total_equipo.add(equipos.getBigDecimal("total_deuda"));
				total_tramite_equipo = new BigDecimal(0);//equipos.getBigDecimal("total_compromiso")
			}
			total = total.add(total_equipo);
			total_tramite = total_tramite.add(total_tramite_equipo);

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("EQUIPAMIENTO");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_equipo.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_equipo.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_equipo.add(total_tramite_equipo).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;



			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTALES");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total.add(total_tramite).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			x++;



			//-------------------------------RA
			x++;x++;
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("R.A");
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
			x++;

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("PROVEEDORES");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(1);
			celda0.setCellValue("DEUDA");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(2);
			celda0.setCellValue("DEUDA EN TRAMITE");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(3);
			celda0.setCellValue("TOTAL");
			celda0.setCellStyle(cabecera);
			x++;

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("R.A");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total_ra.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_ra.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_ra.add(total_tramite_ra).doubleValue());
			celda0.setCellStyle(estiloMoneda);

			x++;
			x++;x++;
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTAL PROVEEDORES DESTACADOS Y R.A");
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
			x++;
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("TOTAL PROVEEDORES DESTACADOS Y R.A");
			celda0.setCellStyle(comun);

			celda0 = fila.createCell(1);
			celda0.setCellValue(total.add(total_ra).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite.add(total_tramite_ra).doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue(total.add(total_ra).add(total_tramite).add(total_tramite_ra).doubleValue());
			celda0.setCellStyle(estiloMoneda);




			//-------------------------------IPS
			x++;x++;x++;
			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("IPS");
			celda0.setCellStyle(cabeceraPrincipal);
			hoja.addMergedRegion(new  CellRangeAddress(x,x,0,3));
			x++;

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("PROVEEDORES");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(1);
			celda0.setCellValue("DEUDA");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(2);
			celda0.setCellValue("DEUDA EN TRAMITE");
			celda0.setCellStyle(cabecera);
			celda0 = fila.createCell(3);
			celda0.setCellValue("TOTAL");
			celda0.setCellStyle(cabecera);
			x++;

			fila = hoja.createRow(x);
			celda0 = fila.createCell(0);
			celda0.setCellValue("IPS");
			celda0.setCellStyle(comun);
			celda0 = fila.createCell(1);
			celda0.setCellValue(total_ips.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			total_tramite_ips = new BigDecimal(0);
			celda0 = fila.createCell(2);
			celda0.setCellValue(total_tramite_ips.doubleValue());
			celda0.setCellStyle(estiloMoneda);
			celda0 = fila.createCell(3);
			celda0.setCellValue( total_ips.add(total_tramite_ips).doubleValue());
			celda0.setCellStyle(estiloMoneda);





			libro.write(archivoTmp);
			return ok(archivo);
		} catch (IOException e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(resumen082023.render(d,proveedoresDestacados,proveedoresOtrosServicios,proveedoresOtrosRubros,proveedoresOtrosEquipos));

		} catch (Exception e) {
			e.printStackTrace();
			flash("error", "No se pudo generar el reporte");
			return ok(resumen082023.render(d,proveedoresDestacados,proveedoresOtrosServicios,proveedoresOtrosRubros,proveedoresOtrosEquipos));

		}


	}










}
