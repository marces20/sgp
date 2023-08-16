package controllers.dashboard;

import static play.data.Form.form;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.SqlRow;

import models.ActaRecepcion;
import models.Deposito;
import models.Estado;
import models.Periodo;
import models.Proveedor;
import models.TipoCuenta;
import models.auth.Permiso;
import models.informes.InformeDeudaProveedoresMaterializada;
import models.informes.InformeEstadisticoDeudaProveedores;
import controllers.Secured;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
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

		List<SqlRow> proveedoresBisionesServicios = InformeDeudaProveedoresMaterializada.getDeudaPorProveedoresDestacados(null,7,14733);

		return ok(resumen082023.render(d,proveedoresDestacados,proveedoresOtrosServicios,proveedoresOtrosRubros,proveedoresOtrosEquipos,proveedoresBisionesServicios));

		/*	10	"HABERES"
			8	"HONORARIOS" X
		 * */
	}










}
