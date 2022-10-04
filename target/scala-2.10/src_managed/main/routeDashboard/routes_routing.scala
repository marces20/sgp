// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routeDashboard.routes
// @HASH:9584acea7ab162a68e5aa6372ff713688149ed32
// @DATE:Tue Oct 04 11:43:27 ART 2022
package routeDashboard

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:2
private[this] lazy val controllers_dashboard_IndexController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:3
private[this] lazy val controllers_dashboard_HonorariosController_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios"))))
        

// @LINE:4
private[this] lazy val controllers_dashboard_HonorariosController_estadoDeuda2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoDeudaHonorarios"))))
        

// @LINE:5
private[this] lazy val controllers_dashboard_HonorariosController_getEstadoDeudaPorEjercicio3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getEstadoDeudaPorEjercicio"))))
        

// @LINE:6
private[this] lazy val controllers_dashboard_HonorariosController_getEstadoDeudaPorPeriodo4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getEstadoDeudaPorPeriodo"))))
        

// @LINE:7
private[this] lazy val controllers_dashboard_HonorariosController_getDataEstadoDeudaPagadosPorEjercicio5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getDataEstadoDeudaPagadosPorEjercicio"))))
        

// @LINE:8
private[this] lazy val controllers_dashboard_HonorariosController_getDataEstadoDeudaNoPagadosPorEjercicio6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getDataEstadoDeudaNoPagadosPorEjercicio"))))
        

// @LINE:9
private[this] lazy val controllers_dashboard_HonorariosController_getDataEstadoDeudaPagadosPorPeriodo7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getDataEstadoDeudaPagadosPorPeriodo"))))
        

// @LINE:10
private[this] lazy val controllers_dashboard_HonorariosController_getDataEstadoDeudaNoPagadosPorPeriodo8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getDataEstadoDeudaNoPagadosPorPeriodo"))))
        

// @LINE:12
private[this] lazy val controllers_dashboard_HonorariosController_estadoGeneralPorAgente9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoGeneralAgente"))))
        

// @LINE:13
private[this] lazy val controllers_dashboard_HonorariosController_getDatosEstadoGeneralPorAgente10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoGeneralAgente/getDatosEstadoGeneralPorAgente"))))
        

// @LINE:14
private[this] lazy val controllers_dashboard_HonorariosController_getCertificacionesEstadoGeneralPorAgente11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoGeneralAgente/getCertificacionesEstadoGeneralPorAgente"))))
        

// @LINE:15
private[this] lazy val controllers_dashboard_HonorariosController_getFacturacionEstadoGeneralPorAgente12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoGeneralAgente/getFacturacionEstadoGeneralPorAgente"))))
        

// @LINE:16
private[this] lazy val controllers_dashboard_HonorariosController_getPagosEstadoGeneralPorAgente13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoGeneralAgente/getPagosEstadoGeneralPorAgente"))))
        

// @LINE:17
private[this] lazy val controllers_dashboard_HonorariosController_getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo14 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoGeneralAgente/getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo"))))
        

// @LINE:18
private[this] lazy val controllers_dashboard_HonorariosController_porDepartamento15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/porDepartamentos"))))
        

// @LINE:19
private[this] lazy val controllers_dashboard_HonorariosController_getAgentesTotalDepartamento16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/agentesDepartamentos"))))
        

// @LINE:20
private[this] lazy val controllers_dashboard_HonorariosController_getHonorarioDepartamento17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getHonorarioDepartamento"))))
        

// @LINE:21
private[this] lazy val controllers_dashboard_HonorariosController_estadoDeudaMonotributo18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoDeudaMonotributo"))))
        

// @LINE:22
private[this] lazy val controllers_dashboard_HonorariosController_estadoDeudaMonotributoExcel19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoDeudaMonotributoExcel"))))
        

// @LINE:23
private[this] lazy val controllers_dashboard_HonorariosController_estadoDeudaMonotributoProfe20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoDeudaMonotributoProfe"))))
        

// @LINE:24
private[this] lazy val controllers_dashboard_HonorariosController_estadoDeudaMonotributoExcelProfe21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoDeudaMonotributoExcelProfe"))))
        

// @LINE:27
private[this] lazy val controllers_dashboard_HonorariosNewController_index22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorariosNew"))))
        

// @LINE:28
private[this] lazy val controllers_dashboard_ProfesionalesMedicosController_index23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profesionalesMedicos"))))
        

// @LINE:30
private[this] lazy val controllers_dashboard_HonorariosNewController_listadoHonorariosReporte24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("listadoHonorariosReporte"))))
        

// @LINE:31
private[this] lazy val controllers_dashboard_HonorariosNewReportesController_informeHonorarioPorPeriodo25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informeHonorarioPorPeriodo"))))
        

// @LINE:33
private[this] lazy val controllers_dashboard_LiquidacionesController_liquidacionesPorPuesto26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesPorPuesto"))))
        

// @LINE:36
private[this] lazy val controllers_dashboard_LiquidacionesController_getLiquidacionesPorPuesto27 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getLiquidacionesPorPuesto"))))
        

// @LINE:37
private[this] lazy val controllers_dashboard_LiquidacionesController_getLiquidacionesPorPuestoPorPeriodo28 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getLiquidacionesPorPuestoPorPeriodo"))))
        

// @LINE:38
private[this] lazy val controllers_dashboard_LiquidacionesController_getLiquidacionesPorPuestoPorPeriodoPorClasificacion29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getLiquidacionesPorPuestoPorPeriodoPorClasificacion"))))
        

// @LINE:39
private[this] lazy val controllers_dashboard_LiquidacionesController_liquidacionesPorEscala30 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesPorEscala"))))
        

// @LINE:40
private[this] lazy val controllers_dashboard_LiquidacionesController_getDetalleLiquidacionClasificacion31 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getDetalleLiquidacionClasificacion"))))
        

// @LINE:41
private[this] lazy val controllers_dashboard_LiquidacionesController_liquidacionesPorProfesion32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesPorProfesion"))))
        

// @LINE:42
private[this] lazy val controllers_dashboard_LiquidacionesReportesController_liquidacionesPorProfesion33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesPorProfesionReporte"))))
        

// @LINE:44
private[this] lazy val controllers_dashboard_LiquidacionesController_liquidacionesPorOrganigrama34 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesPorOrganigrama"))))
        

// @LINE:45
private[this] lazy val controllers_dashboard_LiquidacionesReportesController_liquidacionesPorOrganigrama35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesPorOrganigramaReporte"))))
        

// @LINE:46
private[this] lazy val controllers_dashboard_LiquidacionesReportesController_liquidacionesPorEscala36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesPorEscalaReporte"))))
        

// @LINE:47
private[this] lazy val controllers_dashboard_LiquidacionesController_liquidacionesTotalesPorEscala37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesTotalesPorEscala"))))
        

// @LINE:49
private[this] lazy val controllers_dashboard_LiquidacionesController_liquidacionesPorAgrupadoOrganigrama38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesPorAgrupadoOrganigrama"))))
        

// @LINE:50
private[this] lazy val controllers_dashboard_LiquidacionesReportesController_liquidacionesPorAgrupadoOrganigrama39 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("liquidacionesPorAgrupadoOrganigramaReporte"))))
        

// @LINE:52
private[this] lazy val controllers_dashboard_ImpuestosController_estadoDeuda40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("impuestosDeuda"))))
        

// @LINE:53
private[this] lazy val controllers_dashboard_ImpuestosController_detalleImpuestos41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("detalleImpuestos"))))
        

// @LINE:55
private[this] lazy val controllers_dashboard_ProveedoresController_estadoPorExpedientePorLinea42 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("estadoPorExpedientePorLinea"))))
        

// @LINE:56
private[this] lazy val controllers_dashboard_ProveedoresController_reporteEstadoDefinitivoExpedienteLineas43 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reporteEstadoDefinitivoExpedienteLineas"))))
        

// @LINE:58
private[this] lazy val controllers_dashboard_InformeEstadisticoDeudaProveedoresController_index44 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe-estadistico-deuda-proveedores"))))
        

// @LINE:59
private[this] lazy val controllers_dashboard_InformeDeudaPorActasController_index45 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe-deuda-actas"))))
        

// @LINE:60
private[this] lazy val controllers_dashboard_InformeDeudaPorActasController_archivoDeudaPorActas46 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("archivo-deuda-actas"))))
        

// @LINE:61
private[this] lazy val controllers_dashboard_InformeEstadisticoDeudaProveedoresController_diferencias47 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("diferencias"))))
        

// @LINE:62
private[this] lazy val controllers_dashboard_InformeEstadisticoDeudaProveedoresController_procesarDiferencias48 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("procesar-diferencias"))))
        

// @LINE:64
private[this] lazy val controllers_dashboard_InformeEstadisticoDeudaProveedoresController_archivoEstadistico49 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe-estadistico-deuda-proveedores/descarga"))))
        

// @LINE:65
private[this] lazy val controllers_dashboard_InformeEstadisticoDeudaProveedoresController_getActas50 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe-estadistico-deuda-proveedores/get-actas"))))
        

// @LINE:67
private[this] lazy val controllers_dashboard_InformeEstadisticoPagoProveedoresController_index51 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe-estadistico-pago-proveedores"))))
        

// @LINE:68
private[this] lazy val controllers_dashboard_InformeEstadisticoPagoProveedoresController_archivoEstadistico52 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe-estadistico-pago-proveedores/descarga"))))
        

// @LINE:70
private[this] lazy val controllers_dashboard_InformeEstadisticoPagoProveedoresController_informePeriodoProveedor53 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe-pago-periodo-proveedores"))))
        

// @LINE:71
private[this] lazy val controllers_dashboard_InformeEstadisticoPagoProveedoresController_informePeriodoProveedorReporte54 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe-pago-periodo-proveedores-reportes"))))
        

// @LINE:73
private[this] lazy val controllers_dashboard_InformeEstadisticoPagoProveedoresController_informeProveedor55 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informeProveedor"))))
        

// @LINE:76
private[this] lazy val controllers_dashboard_AutorizadosController_index56 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado"))))
        

// @LINE:77
private[this] lazy val controllers_dashboard_AutorizadosController_crear57 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/crear"))))
        

// @LINE:78
private[this] lazy val controllers_dashboard_AutorizadosController_guardar58 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/guardar"))))
        

// @LINE:79
private[this] lazy val controllers_dashboard_AutorizadosController_editar59 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/editar"))))
        

// @LINE:80
private[this] lazy val controllers_dashboard_AutorizadosController_eliminar60 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/eliminar"))))
        

// @LINE:81
private[this] lazy val controllers_dashboard_AutorizadosController_ver61 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/ver"))))
        

// @LINE:82
private[this] lazy val controllers_dashboard_AutorizadosController_actualizar62 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/actualizar"))))
        

// @LINE:83
private[this] lazy val controllers_dashboard_AutorizadosController_cambiarEstado63 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/cambiarEstado"))))
        

// @LINE:84
private[this] lazy val controllers_dashboard_AutorizadosController_cargarLineasAutorizados64 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/cargarLineasAutorizados"))))
        

// @LINE:85
private[this] lazy val controllers_dashboard_AutorizadosController_cargarLineasAutorizadosCertificacionesCompras65 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/cargarLineasAutorizadosCertificacionesCompras"))))
        

// @LINE:86
private[this] lazy val controllers_dashboard_AutorizadosController_modalAgregarMontos66 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/modalAgregarMontos"))))
        

// @LINE:87
private[this] lazy val controllers_dashboard_AutorizadosController_getListadoDeudas67 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/getListadoDeudas"))))
        

// @LINE:88
private[this] lazy val controllers_dashboard_AutorizadosController_getListadoDeudasActas68 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/getListadoDeudasActas"))))
        

// @LINE:89
private[this] lazy val controllers_dashboard_AutorizadosController_getActualizarDatos69 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/getActualizarDatos"))))
        

// @LINE:90
private[this] lazy val controllers_dashboard_AutorizadosController_controlCargaCotizacion70 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/controlCargaCotizacion"))))
        

// @LINE:92
private[this] lazy val controllers_dashboard_AutorizadosController_modalAgregarMontosActas71 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/modalAgregarMontosActas"))))
        

// @LINE:93
private[this] lazy val controllers_dashboard_AutorizadosController_modalAgregarMontosSinOp72 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/modalAgregarMontosSinOp"))))
        

// @LINE:94
private[this] lazy val controllers_dashboard_AutorizadosController_modalAgregarMontosCertificacionesCompras73 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/modalAgregarMontosCertificacionesCompras"))))
        

// @LINE:96
private[this] lazy val controllers_dashboard_AutorizadosController_getResumen74 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/getResumen"))))
        

// @LINE:97
private[this] lazy val controllers_dashboard_AutorizadosController_reporteAutorizado75 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/reporteAutorizado"))))
        

// @LINE:98
private[this] lazy val controllers_dashboard_AutorizadosController_reporteAutorizadoExcel76 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/reporteAutorizadoExcel"))))
        

// @LINE:99
private[this] lazy val controllers_dashboard_AutorizadosController_reporteAutorizadoRemitos77 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/reporteAutorizadoRemitos"))))
        

// @LINE:101
private[this] lazy val controllers_dashboard_AutorizadosController_cargarLineasAutorizadosMasivamente78 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado/cargarLineasAutorizadosMasivamente"))))
        

// @LINE:103
private[this] lazy val controllers_dashboard_AutorizadoLineasController_index79 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado-linea/index"))))
        

// @LINE:104
private[this] lazy val controllers_dashboard_AutorizadoLineasController_eliminar80 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado-linea/eliminar"))))
        

// @LINE:106
private[this] lazy val controllers_dashboard_AutorizadoLineasController_getActas81 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizado-linea/get-actas"))))
        

// @LINE:109
private[this] lazy val controllers_dashboard_InformesRecuperoController_index82 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("indexInformeRecupero"))))
        

// @LINE:110
private[this] lazy val controllers_dashboard_InformesRecuperoController_deudasPorTipoDeCliente83 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasRecuperoPorTipoDeCliente"))))
        

// @LINE:112
private[this] lazy val controllers_dashboard_InformesRecuperoReportesController_deudasPorTipoDeCliente84 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasRecuperoPorTipoDeClienteReporte"))))
        

// @LINE:114
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_index85 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudas"))))
        

// @LINE:115
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasResumidas86 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasResumidas"))))
        

// @LINE:116
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasDetalles87 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasPorProveedorHEARM"))))
        

// @LINE:117
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasDetallesOtros88 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesOtros"))))
        

// @LINE:118
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasDetallesCuentas89 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesCuentas"))))
        

// @LINE:119
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasDetallesPorProveedor90 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesPorProveedor"))))
        

// @LINE:121
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasDetallesOtrosProveedoresResumen91 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesOtrosProveedoresResumen"))))
        

// @LINE:124
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasDetallesServicios92 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesServicios"))))
        

// @LINE:125
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasDetallesServiciosResumen93 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesServiciosResumen"))))
        

// @LINE:126
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasDetallesHonorarios94 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesHonorarios"))))
        

// @LINE:127
private[this] lazy val controllers_dashboard_DeudasGlobalizadasController_deudasDetallesHonorariosResumen95 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesHonorariosResumen"))))
        

// @LINE:129
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasResumidasReporte96 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasResumidasReporte"))))
        

// @LINE:130
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesReporte97 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesReporte"))))
        

// @LINE:131
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesOtrosReportes98 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesOtrosReportes"))))
        

// @LINE:132
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasInformeGeneral99 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasInformeGeneral"))))
        

// @LINE:133
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasInformeGeneralResumen100 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasInformeGeneralResumen"))))
        

// @LINE:134
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesServiciosReportes101 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesServiciosReportes"))))
        

// @LINE:135
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesHonorariosReportes102 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesHonorariosReportes"))))
        

// @LINE:136
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasServiciosProveedoresResumenReportes103 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasServiciosProveedoresResumenReportes"))))
        

// @LINE:137
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasHonorariosProveedoresResumenReportes104 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasHonorariosProveedoresResumenReportes"))))
        

// @LINE:139
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasCuentasReportes105 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasCuentasReportes"))))
        

// @LINE:141
private[this] lazy val controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesOtrosProveedoresResumen106 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasOtrosProveedoresResumenReporte"))))
        

// @LINE:144
private[this] lazy val controllers_dashboard_UltimasCotizacionesController_indexUltimaCotizaciones107 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cotizacion"))))
        

// @LINE:145
private[this] lazy val controllers_dashboard_UltimasCotizacionesController_crearUltimaCotizaciones108 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cotizacion/crear"))))
        

// @LINE:146
private[this] lazy val controllers_dashboard_UltimasCotizacionesController_guardarUltimaCotizaciones109 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cotizacion/guardar"))))
        

// @LINE:147
private[this] lazy val controllers_dashboard_UltimasCotizacionesController_eliminar110 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cotizacion/eliminar"))))
        

// @LINE:149
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadController_index111 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasPorAntigueda"))))
        

// @LINE:150
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadController_deudasDetalles112 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasPorProveedorPorAntiguedad"))))
        

// @LINE:151
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadReportesController_deudasDetallesReporte113 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesPorAntiguedadReporte"))))
        

// @LINE:152
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadReportesController_deudasInformeGeneral114 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasInformeGeneralPorAntiguedad"))))
        

// @LINE:153
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadReportesController_deudasInformeGeneralNuevo115 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasInformeGeneralPorAntiguedadNuevo"))))
        

// @LINE:154
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadController_deudasResumenMensual116 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasResumenMensual"))))
        

// @LINE:155
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadReportesController_deudasMensualReporte117 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasMensualReporte"))))
        

// @LINE:156
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadController_deudasDetallesServicios118 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesServiciosPorAntiguedad"))))
        

// @LINE:157
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadController_deudasDetallesPorProveedor119 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesPorAntiguedaPorProveedor"))))
        

// @LINE:159
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadController_deudasDetallesInstitucion120 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesInstitucion"))))
        

// @LINE:160
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadController_deudasResumenInstitucion121 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasResumenInstitucion"))))
        

// @LINE:161
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadReportesController_deudasDetallePorInstitucionReporte122 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallePorInstitucionReporte"))))
        

// @LINE:162
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadReportesController_deudasResumenPorInstitucionReporte123 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasResumenPorInstitucionReporte"))))
        

// @LINE:163
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadReportesController_deudasDetallesServiciosReportes124 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesAntiguedadServiciosReportes"))))
        

// @LINE:165
private[this] lazy val controllers_dashboard_DeudasPorAntiguedadController_deudasDetallesCuenta125 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deudasDetallesAntiguedadCuenta"))))
        

// @LINE:168
private[this] lazy val controllers_dashboard_ControlDeudaController_autorizadoDistintoDePagado126 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("autorizadoDistintoDePagado"))))
        

// @LINE:169
private[this] lazy val controllers_dashboard_ControlDeudaController_getAutorizadoDistintoDePagado127 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAutorizadoDistintoDePagado"))))
        

// @LINE:170
private[this] lazy val controllers_dashboard_ControlDeudaController_controlDeudaMonedaExtranjera128 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("controlDeudaMonedaExtranjera"))))
        

// @LINE:171
private[this] lazy val controllers_dashboard_ControlDeudaController_index129 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("indexControlDeuda"))))
        

// @LINE:173
private[this] lazy val controllers_dashboard_MovimientosCuentasController_index130 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("resumenFinanciero"))))
        

// @LINE:174
private[this] lazy val controllers_dashboard_MovimientosCuentasController_resumenFinancieroGeneral131 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("resumenFinancieroGeneral"))))
        

// @LINE:175
private[this] lazy val controllers_dashboard_MovimientosCuentasController_resumenFinancieroDetalle132 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("resumenFinancieroDetalle"))))
        

// @LINE:176
private[this] lazy val controllers_dashboard_MovimientosCuentasController_resumenFinancieroDetallePorInstitucion133 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("resumenFinancieroDetalleInstitucion"))))
        

// @LINE:177
private[this] lazy val controllers_dashboard_MovimientosCuentasController_conciliacion134 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("conciliacion"))))
        

// @LINE:179
private[this] lazy val controllers_dashboard_AuditoriaController_index135 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auditoria"))))
        

// @LINE:180
private[this] lazy val controllers_dashboard_InventarioRismiController_index136 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inventarioRismi"))))
        

// @LINE:182
private[this] lazy val controllers_dashboard_PresupuestoController_index137 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presuControl"))))
        

// @LINE:183
private[this] lazy val controllers_dashboard_PresupuestoController_devengado138 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presuControl/devengado"))))
        
def documentation = List(("""GET""", prefix,"""controllers.dashboard.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios""","""controllers.dashboard.HonorariosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoDeudaHonorarios""","""controllers.dashboard.HonorariosController.estadoDeuda()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getEstadoDeudaPorEjercicio""","""controllers.dashboard.HonorariosController.getEstadoDeudaPorEjercicio()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getEstadoDeudaPorPeriodo""","""controllers.dashboard.HonorariosController.getEstadoDeudaPorPeriodo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getDataEstadoDeudaPagadosPorEjercicio""","""controllers.dashboard.HonorariosController.getDataEstadoDeudaPagadosPorEjercicio()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getDataEstadoDeudaNoPagadosPorEjercicio""","""controllers.dashboard.HonorariosController.getDataEstadoDeudaNoPagadosPorEjercicio()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getDataEstadoDeudaPagadosPorPeriodo""","""controllers.dashboard.HonorariosController.getDataEstadoDeudaPagadosPorPeriodo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getDataEstadoDeudaNoPagadosPorPeriodo""","""controllers.dashboard.HonorariosController.getDataEstadoDeudaNoPagadosPorPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoGeneralAgente""","""controllers.dashboard.HonorariosController.estadoGeneralPorAgente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoGeneralAgente/getDatosEstadoGeneralPorAgente""","""controllers.dashboard.HonorariosController.getDatosEstadoGeneralPorAgente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoGeneralAgente/getCertificacionesEstadoGeneralPorAgente""","""controllers.dashboard.HonorariosController.getCertificacionesEstadoGeneralPorAgente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoGeneralAgente/getFacturacionEstadoGeneralPorAgente""","""controllers.dashboard.HonorariosController.getFacturacionEstadoGeneralPorAgente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoGeneralAgente/getPagosEstadoGeneralPorAgente""","""controllers.dashboard.HonorariosController.getPagosEstadoGeneralPorAgente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoGeneralAgente/getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo""","""controllers.dashboard.HonorariosController.getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/porDepartamentos""","""controllers.dashboard.HonorariosController.porDepartamento()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/agentesDepartamentos""","""controllers.dashboard.HonorariosController.getAgentesTotalDepartamento()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getHonorarioDepartamento""","""controllers.dashboard.HonorariosController.getHonorarioDepartamento()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoDeudaMonotributo""","""controllers.dashboard.HonorariosController.estadoDeudaMonotributo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoDeudaMonotributoExcel""","""controllers.dashboard.HonorariosController.estadoDeudaMonotributoExcel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoDeudaMonotributoProfe""","""controllers.dashboard.HonorariosController.estadoDeudaMonotributoProfe()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoDeudaMonotributoExcelProfe""","""controllers.dashboard.HonorariosController.estadoDeudaMonotributoExcelProfe()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorariosNew""","""controllers.dashboard.HonorariosNewController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profesionalesMedicos""","""controllers.dashboard.ProfesionalesMedicosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """listadoHonorariosReporte""","""controllers.dashboard.HonorariosNewController.listadoHonorariosReporte(id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informeHonorarioPorPeriodo""","""controllers.dashboard.HonorariosNewReportesController.informeHonorarioPorPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesPorPuesto""","""controllers.dashboard.LiquidacionesController.liquidacionesPorPuesto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getLiquidacionesPorPuesto""","""controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuesto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getLiquidacionesPorPuestoPorPeriodo""","""controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuestoPorPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getLiquidacionesPorPuestoPorPeriodoPorClasificacion""","""controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuestoPorPeriodoPorClasificacion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesPorEscala""","""controllers.dashboard.LiquidacionesController.liquidacionesPorEscala()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getDetalleLiquidacionClasificacion""","""controllers.dashboard.LiquidacionesController.getDetalleLiquidacionClasificacion(idPuestoLaboral:Int, idPeriodo:Int, idClasificacion:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesPorProfesion""","""controllers.dashboard.LiquidacionesController.liquidacionesPorProfesion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesPorProfesionReporte""","""controllers.dashboard.LiquidacionesReportesController.liquidacionesPorProfesion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesPorOrganigrama""","""controllers.dashboard.LiquidacionesController.liquidacionesPorOrganigrama()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesPorOrganigramaReporte""","""controllers.dashboard.LiquidacionesReportesController.liquidacionesPorOrganigrama()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesPorEscalaReporte""","""controllers.dashboard.LiquidacionesReportesController.liquidacionesPorEscala()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesTotalesPorEscala""","""controllers.dashboard.LiquidacionesController.liquidacionesTotalesPorEscala()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesPorAgrupadoOrganigrama""","""controllers.dashboard.LiquidacionesController.liquidacionesPorAgrupadoOrganigrama()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """liquidacionesPorAgrupadoOrganigramaReporte""","""controllers.dashboard.LiquidacionesReportesController.liquidacionesPorAgrupadoOrganigrama()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """impuestosDeuda""","""controllers.dashboard.ImpuestosController.estadoDeuda()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """detalleImpuestos""","""controllers.dashboard.ImpuestosController.detalleImpuestos(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """estadoPorExpedientePorLinea""","""controllers.dashboard.ProveedoresController.estadoPorExpedientePorLinea()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reporteEstadoDefinitivoExpedienteLineas""","""controllers.dashboard.ProveedoresController.reporteEstadoDefinitivoExpedienteLineas(proveedorId:Long ?= 0, rubroId:Long ?= 0, ejercicioId:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe-estadistico-deuda-proveedores""","""controllers.dashboard.InformeEstadisticoDeudaProveedoresController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe-deuda-actas""","""controllers.dashboard.InformeDeudaPorActasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """archivo-deuda-actas""","""controllers.dashboard.InformeDeudaPorActasController.archivoDeudaPorActas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """diferencias""","""controllers.dashboard.InformeEstadisticoDeudaProveedoresController.diferencias()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """procesar-diferencias""","""controllers.dashboard.InformeEstadisticoDeudaProveedoresController.procesarDiferencias()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe-estadistico-deuda-proveedores/descarga""","""controllers.dashboard.InformeEstadisticoDeudaProveedoresController.archivoEstadistico()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe-estadistico-deuda-proveedores/get-actas""","""controllers.dashboard.InformeEstadisticoDeudaProveedoresController.getActas(id_orden_provision:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe-estadistico-pago-proveedores""","""controllers.dashboard.InformeEstadisticoPagoProveedoresController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe-estadistico-pago-proveedores/descarga""","""controllers.dashboard.InformeEstadisticoPagoProveedoresController.archivoEstadistico()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe-pago-periodo-proveedores""","""controllers.dashboard.InformeEstadisticoPagoProveedoresController.informePeriodoProveedor()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe-pago-periodo-proveedores-reportes""","""controllers.dashboard.InformeEstadisticoPagoProveedoresController.informePeriodoProveedorReporte()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informeProveedor""","""controllers.dashboard.InformeEstadisticoPagoProveedoresController.informeProveedor()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado""","""controllers.dashboard.AutorizadosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/crear""","""controllers.dashboard.AutorizadosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/guardar""","""controllers.dashboard.AutorizadosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/editar""","""controllers.dashboard.AutorizadosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/eliminar""","""controllers.dashboard.AutorizadosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/ver""","""controllers.dashboard.AutorizadosController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/actualizar""","""controllers.dashboard.AutorizadosController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/cambiarEstado""","""controllers.dashboard.AutorizadosController.cambiarEstado(idAutorizado:Long, idEstado:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/cargarLineasAutorizados""","""controllers.dashboard.AutorizadosController.cargarLineasAutorizados()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/cargarLineasAutorizadosCertificacionesCompras""","""controllers.dashboard.AutorizadosController.cargarLineasAutorizadosCertificacionesCompras()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/modalAgregarMontos""","""controllers.dashboard.AutorizadosController.modalAgregarMontos(idOrdenProvision:Long ?= 0, idAutorizado:Long, idOrdenCompra:Long ?= 0, tipo_cuenta_id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/getListadoDeudas""","""controllers.dashboard.AutorizadosController.getListadoDeudas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/getListadoDeudasActas""","""controllers.dashboard.AutorizadosController.getListadoDeudasActas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/getActualizarDatos""","""controllers.dashboard.AutorizadosController.getActualizarDatos(idAutorizado:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/controlCargaCotizacion""","""controllers.dashboard.AutorizadosController.controlCargaCotizacion()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/modalAgregarMontosActas""","""controllers.dashboard.AutorizadosController.modalAgregarMontosActas(idActa:Long ?= 0, idOrdenProvision:Long ?= 0, idAutorizado:Long, idOrdenCompra:Long ?= 0, tipo_cuenta_id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/modalAgregarMontosSinOp""","""controllers.dashboard.AutorizadosController.modalAgregarMontosSinOp(idAutorizado:Long, idOrdenCompra:Long ?= 0, tipo_cuenta_id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/modalAgregarMontosCertificacionesCompras""","""controllers.dashboard.AutorizadosController.modalAgregarMontosCertificacionesCompras(idCertificacion:Long ?= 0, idAutorizado:Long, idOrdenCompra:Long, tipo_cuenta_id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/getResumen""","""controllers.dashboard.AutorizadosController.getResumen(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/reporteAutorizado""","""controllers.dashboard.AutorizadosController.reporteAutorizado(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/reporteAutorizadoExcel""","""controllers.dashboard.AutorizadosController.reporteAutorizadoExcel(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/reporteAutorizadoRemitos""","""controllers.dashboard.AutorizadosController.reporteAutorizadoRemitos(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado/cargarLineasAutorizadosMasivamente""","""controllers.dashboard.AutorizadosController.cargarLineasAutorizadosMasivamente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado-linea/index""","""controllers.dashboard.AutorizadoLineasController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado-linea/eliminar""","""controllers.dashboard.AutorizadoLineasController.eliminar(autorizado_id:Long, orden_id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizado-linea/get-actas""","""controllers.dashboard.AutorizadoLineasController.getActas(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """indexInformeRecupero""","""controllers.dashboard.InformesRecuperoController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasRecuperoPorTipoDeCliente""","""controllers.dashboard.InformesRecuperoController.deudasPorTipoDeCliente(idTipoCliente:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasRecuperoPorTipoDeClienteReporte""","""controllers.dashboard.InformesRecuperoReportesController.deudasPorTipoDeCliente(idTipoCliente:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudas""","""controllers.dashboard.DeudasGlobalizadasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasResumidas""","""controllers.dashboard.DeudasGlobalizadasController.deudasResumidas(deposito:Int ?= 0, ra:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasPorProveedorHEARM""","""controllers.dashboard.DeudasGlobalizadasController.deudasDetalles(idProveedor:Int ?= 0, ra:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesOtros""","""controllers.dashboard.DeudasGlobalizadasController.deudasDetallesOtros(profe:Boolean ?= false, equipamientos:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesCuentas""","""controllers.dashboard.DeudasGlobalizadasController.deudasDetallesCuentas(idCuenta:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesPorProveedor""","""controllers.dashboard.DeudasGlobalizadasController.deudasDetallesPorProveedor()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesOtrosProveedoresResumen""","""controllers.dashboard.DeudasGlobalizadasController.deudasDetallesOtrosProveedoresResumen(profe:Boolean ?= false, equipamientos:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesServicios""","""controllers.dashboard.DeudasGlobalizadasController.deudasDetallesServicios()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesServiciosResumen""","""controllers.dashboard.DeudasGlobalizadasController.deudasDetallesServiciosResumen()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesHonorarios""","""controllers.dashboard.DeudasGlobalizadasController.deudasDetallesHonorarios()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesHonorariosResumen""","""controllers.dashboard.DeudasGlobalizadasController.deudasDetallesHonorariosResumen()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasResumidasReporte""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasResumidasReporte(deposito:Int ?= 0, ra:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesReporte""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesReporte(idProveedor:Int ?= 0, ra:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesOtrosReportes""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesOtrosReportes(profe:Boolean ?= false, equipamientos:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasInformeGeneral""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasInformeGeneral()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasInformeGeneralResumen""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasInformeGeneralResumen()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesServiciosReportes""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesServiciosReportes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesHonorariosReportes""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesHonorariosReportes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasServiciosProveedoresResumenReportes""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasServiciosProveedoresResumenReportes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasHonorariosProveedoresResumenReportes""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasHonorariosProveedoresResumenReportes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasCuentasReportes""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasCuentasReportes(idCuenta:Int ?= 0, soloDeuda:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasOtrosProveedoresResumenReporte""","""controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesOtrosProveedoresResumen(profe:Boolean ?= false, equipamientos:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cotizacion""","""controllers.dashboard.UltimasCotizacionesController.indexUltimaCotizaciones()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cotizacion/crear""","""controllers.dashboard.UltimasCotizacionesController.crearUltimaCotizaciones()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cotizacion/guardar""","""controllers.dashboard.UltimasCotizacionesController.guardarUltimaCotizaciones()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cotizacion/eliminar""","""controllers.dashboard.UltimasCotizacionesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasPorAntigueda""","""controllers.dashboard.DeudasPorAntiguedadController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasPorProveedorPorAntiguedad""","""controllers.dashboard.DeudasPorAntiguedadController.deudasDetalles(idProveedor:Int ?= 0, equipamiento:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesPorAntiguedadReporte""","""controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallesReporte(idProveedor:Int ?= 0, equipamiento:Boolean ?= false, idCuenta:Int ?= 0, sinServicio:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasInformeGeneralPorAntiguedad""","""controllers.dashboard.DeudasPorAntiguedadReportesController.deudasInformeGeneral()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasInformeGeneralPorAntiguedadNuevo""","""controllers.dashboard.DeudasPorAntiguedadReportesController.deudasInformeGeneralNuevo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasResumenMensual""","""controllers.dashboard.DeudasPorAntiguedadController.deudasResumenMensual()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasMensualReporte""","""controllers.dashboard.DeudasPorAntiguedadReportesController.deudasMensualReporte()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesServiciosPorAntiguedad""","""controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesServicios()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesPorAntiguedaPorProveedor""","""controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesPorProveedor()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesInstitucion""","""controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesInstitucion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasResumenInstitucion""","""controllers.dashboard.DeudasPorAntiguedadController.deudasResumenInstitucion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallePorInstitucionReporte""","""controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallePorInstitucionReporte()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasResumenPorInstitucionReporte""","""controllers.dashboard.DeudasPorAntiguedadReportesController.deudasResumenPorInstitucionReporte()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesAntiguedadServiciosReportes""","""controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallesServiciosReportes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deudasDetallesAntiguedadCuenta""","""controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesCuenta(idCuenta:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """autorizadoDistintoDePagado""","""controllers.dashboard.ControlDeudaController.autorizadoDistintoDePagado()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAutorizadoDistintoDePagado""","""controllers.dashboard.ControlDeudaController.getAutorizadoDistintoDePagado()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """controlDeudaMonedaExtranjera""","""controllers.dashboard.ControlDeudaController.controlDeudaMonedaExtranjera()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """indexControlDeuda""","""controllers.dashboard.ControlDeudaController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """resumenFinanciero""","""controllers.dashboard.MovimientosCuentasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """resumenFinancieroGeneral""","""controllers.dashboard.MovimientosCuentasController.resumenFinancieroGeneral()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """resumenFinancieroDetalle""","""controllers.dashboard.MovimientosCuentasController.resumenFinancieroDetalle()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """resumenFinancieroDetalleInstitucion""","""controllers.dashboard.MovimientosCuentasController.resumenFinancieroDetallePorInstitucion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """conciliacion""","""controllers.dashboard.MovimientosCuentasController.conciliacion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auditoria""","""controllers.dashboard.AuditoriaController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inventarioRismi""","""controllers.dashboard.InventarioRismiController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presuControl""","""controllers.dashboard.PresupuestoController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presuControl/devengado""","""controllers.dashboard.PresupuestoController.devengado()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:2
case controllers_dashboard_IndexController_index0(params) => {
   call { 
        invokeHandler(controllers.dashboard.IndexController.index(), HandlerDef(this, "controllers.dashboard.IndexController", "index", Nil,"GET", """-----------------------------MODULO DASHBOARD ---------------------------------""", Routes.prefix + """"""))
   }
}
        

// @LINE:3
case controllers_dashboard_HonorariosController_index1(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.index(), HandlerDef(this, "controllers.dashboard.HonorariosController", "index", Nil,"GET", """""", Routes.prefix + """honorarios"""))
   }
}
        

// @LINE:4
case controllers_dashboard_HonorariosController_estadoDeuda2(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.estadoDeuda(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeuda", Nil,"GET", """""", Routes.prefix + """estadoDeudaHonorarios"""))
   }
}
        

// @LINE:5
case controllers_dashboard_HonorariosController_getEstadoDeudaPorEjercicio3(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getEstadoDeudaPorEjercicio(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getEstadoDeudaPorEjercicio", Nil,"POST", """""", Routes.prefix + """honorarios/getEstadoDeudaPorEjercicio"""))
   }
}
        

// @LINE:6
case controllers_dashboard_HonorariosController_getEstadoDeudaPorPeriodo4(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getEstadoDeudaPorPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getEstadoDeudaPorPeriodo", Nil,"POST", """""", Routes.prefix + """honorarios/getEstadoDeudaPorPeriodo"""))
   }
}
        

// @LINE:7
case controllers_dashboard_HonorariosController_getDataEstadoDeudaPagadosPorEjercicio5(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getDataEstadoDeudaPagadosPorEjercicio(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDataEstadoDeudaPagadosPorEjercicio", Nil,"POST", """""", Routes.prefix + """honorarios/getDataEstadoDeudaPagadosPorEjercicio"""))
   }
}
        

// @LINE:8
case controllers_dashboard_HonorariosController_getDataEstadoDeudaNoPagadosPorEjercicio6(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getDataEstadoDeudaNoPagadosPorEjercicio(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDataEstadoDeudaNoPagadosPorEjercicio", Nil,"POST", """""", Routes.prefix + """honorarios/getDataEstadoDeudaNoPagadosPorEjercicio"""))
   }
}
        

// @LINE:9
case controllers_dashboard_HonorariosController_getDataEstadoDeudaPagadosPorPeriodo7(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getDataEstadoDeudaPagadosPorPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDataEstadoDeudaPagadosPorPeriodo", Nil,"POST", """""", Routes.prefix + """honorarios/getDataEstadoDeudaPagadosPorPeriodo"""))
   }
}
        

// @LINE:10
case controllers_dashboard_HonorariosController_getDataEstadoDeudaNoPagadosPorPeriodo8(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getDataEstadoDeudaNoPagadosPorPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDataEstadoDeudaNoPagadosPorPeriodo", Nil,"POST", """""", Routes.prefix + """honorarios/getDataEstadoDeudaNoPagadosPorPeriodo"""))
   }
}
        

// @LINE:12
case controllers_dashboard_HonorariosController_estadoGeneralPorAgente9(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.estadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoGeneralPorAgente", Nil,"GET", """""", Routes.prefix + """estadoGeneralAgente"""))
   }
}
        

// @LINE:13
case controllers_dashboard_HonorariosController_getDatosEstadoGeneralPorAgente10(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getDatosEstadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDatosEstadoGeneralPorAgente", Nil,"POST", """""", Routes.prefix + """estadoGeneralAgente/getDatosEstadoGeneralPorAgente"""))
   }
}
        

// @LINE:14
case controllers_dashboard_HonorariosController_getCertificacionesEstadoGeneralPorAgente11(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getCertificacionesEstadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getCertificacionesEstadoGeneralPorAgente", Nil,"POST", """""", Routes.prefix + """estadoGeneralAgente/getCertificacionesEstadoGeneralPorAgente"""))
   }
}
        

// @LINE:15
case controllers_dashboard_HonorariosController_getFacturacionEstadoGeneralPorAgente12(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getFacturacionEstadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getFacturacionEstadoGeneralPorAgente", Nil,"POST", """""", Routes.prefix + """estadoGeneralAgente/getFacturacionEstadoGeneralPorAgente"""))
   }
}
        

// @LINE:16
case controllers_dashboard_HonorariosController_getPagosEstadoGeneralPorAgente13(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getPagosEstadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getPagosEstadoGeneralPorAgente", Nil,"POST", """""", Routes.prefix + """estadoGeneralAgente/getPagosEstadoGeneralPorAgente"""))
   }
}
        

// @LINE:17
case controllers_dashboard_HonorariosController_getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo14(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo", Nil,"POST", """""", Routes.prefix + """estadoGeneralAgente/getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo"""))
   }
}
        

// @LINE:18
case controllers_dashboard_HonorariosController_porDepartamento15(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.porDepartamento(), HandlerDef(this, "controllers.dashboard.HonorariosController", "porDepartamento", Nil,"GET", """""", Routes.prefix + """honorarios/porDepartamentos"""))
   }
}
        

// @LINE:19
case controllers_dashboard_HonorariosController_getAgentesTotalDepartamento16(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getAgentesTotalDepartamento(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getAgentesTotalDepartamento", Nil,"GET", """""", Routes.prefix + """honorarios/agentesDepartamentos"""))
   }
}
        

// @LINE:20
case controllers_dashboard_HonorariosController_getHonorarioDepartamento17(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.getHonorarioDepartamento(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getHonorarioDepartamento", Nil,"GET", """""", Routes.prefix + """honorarios/getHonorarioDepartamento"""))
   }
}
        

// @LINE:21
case controllers_dashboard_HonorariosController_estadoDeudaMonotributo18(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.estadoDeudaMonotributo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeudaMonotributo", Nil,"GET", """""", Routes.prefix + """estadoDeudaMonotributo"""))
   }
}
        

// @LINE:22
case controllers_dashboard_HonorariosController_estadoDeudaMonotributoExcel19(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.estadoDeudaMonotributoExcel(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeudaMonotributoExcel", Nil,"GET", """""", Routes.prefix + """estadoDeudaMonotributoExcel"""))
   }
}
        

// @LINE:23
case controllers_dashboard_HonorariosController_estadoDeudaMonotributoProfe20(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.estadoDeudaMonotributoProfe(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeudaMonotributoProfe", Nil,"GET", """""", Routes.prefix + """estadoDeudaMonotributoProfe"""))
   }
}
        

// @LINE:24
case controllers_dashboard_HonorariosController_estadoDeudaMonotributoExcelProfe21(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosController.estadoDeudaMonotributoExcelProfe(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeudaMonotributoExcelProfe", Nil,"GET", """""", Routes.prefix + """estadoDeudaMonotributoExcelProfe"""))
   }
}
        

// @LINE:27
case controllers_dashboard_HonorariosNewController_index22(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosNewController.index(), HandlerDef(this, "controllers.dashboard.HonorariosNewController", "index", Nil,"GET", """""", Routes.prefix + """honorariosNew"""))
   }
}
        

// @LINE:28
case controllers_dashboard_ProfesionalesMedicosController_index23(params) => {
   call { 
        invokeHandler(controllers.dashboard.ProfesionalesMedicosController.index(), HandlerDef(this, "controllers.dashboard.ProfesionalesMedicosController", "index", Nil,"GET", """""", Routes.prefix + """profesionalesMedicos"""))
   }
}
        

// @LINE:30
case controllers_dashboard_HonorariosNewController_listadoHonorariosReporte24(params) => {
   call(params.fromQuery[Int]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.HonorariosNewController.listadoHonorariosReporte(id), HandlerDef(this, "controllers.dashboard.HonorariosNewController", "listadoHonorariosReporte", Seq(classOf[Int]),"GET", """""", Routes.prefix + """listadoHonorariosReporte"""))
   }
}
        

// @LINE:31
case controllers_dashboard_HonorariosNewReportesController_informeHonorarioPorPeriodo25(params) => {
   call { 
        invokeHandler(controllers.dashboard.HonorariosNewReportesController.informeHonorarioPorPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosNewReportesController", "informeHonorarioPorPeriodo", Nil,"GET", """""", Routes.prefix + """informeHonorarioPorPeriodo"""))
   }
}
        

// @LINE:33
case controllers_dashboard_LiquidacionesController_liquidacionesPorPuesto26(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesController.liquidacionesPorPuesto(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorPuesto", Nil,"GET", """""", Routes.prefix + """liquidacionesPorPuesto"""))
   }
}
        

// @LINE:36
case controllers_dashboard_LiquidacionesController_getLiquidacionesPorPuesto27(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuesto(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "getLiquidacionesPorPuesto", Nil,"GET", """GET /getCertificacionesPorPuesto		controllers.dashboard.LiquidacionesController.getCertificacionesPorPuesto()""", Routes.prefix + """getLiquidacionesPorPuesto"""))
   }
}
        

// @LINE:37
case controllers_dashboard_LiquidacionesController_getLiquidacionesPorPuestoPorPeriodo28(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuestoPorPeriodo(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "getLiquidacionesPorPuestoPorPeriodo", Nil,"GET", """""", Routes.prefix + """getLiquidacionesPorPuestoPorPeriodo"""))
   }
}
        

// @LINE:38
case controllers_dashboard_LiquidacionesController_getLiquidacionesPorPuestoPorPeriodoPorClasificacion29(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuestoPorPeriodoPorClasificacion(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "getLiquidacionesPorPuestoPorPeriodoPorClasificacion", Nil,"GET", """""", Routes.prefix + """getLiquidacionesPorPuestoPorPeriodoPorClasificacion"""))
   }
}
        

// @LINE:39
case controllers_dashboard_LiquidacionesController_liquidacionesPorEscala30(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesController.liquidacionesPorEscala(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorEscala", Nil,"GET", """""", Routes.prefix + """liquidacionesPorEscala"""))
   }
}
        

// @LINE:40
case controllers_dashboard_LiquidacionesController_getDetalleLiquidacionClasificacion31(params) => {
   call(params.fromQuery[Int]("idPuestoLaboral", None), params.fromQuery[Int]("idPeriodo", None), params.fromQuery[Int]("idClasificacion", None)) { (idPuestoLaboral, idPeriodo, idClasificacion) =>
        invokeHandler(controllers.dashboard.LiquidacionesController.getDetalleLiquidacionClasificacion(idPuestoLaboral, idPeriodo, idClasificacion), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "getDetalleLiquidacionClasificacion", Seq(classOf[Int], classOf[Int], classOf[Int]),"POST", """""", Routes.prefix + """getDetalleLiquidacionClasificacion"""))
   }
}
        

// @LINE:41
case controllers_dashboard_LiquidacionesController_liquidacionesPorProfesion32(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesController.liquidacionesPorProfesion(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorProfesion", Nil,"GET", """""", Routes.prefix + """liquidacionesPorProfesion"""))
   }
}
        

// @LINE:42
case controllers_dashboard_LiquidacionesReportesController_liquidacionesPorProfesion33(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesReportesController.liquidacionesPorProfesion(), HandlerDef(this, "controllers.dashboard.LiquidacionesReportesController", "liquidacionesPorProfesion", Nil,"GET", """""", Routes.prefix + """liquidacionesPorProfesionReporte"""))
   }
}
        

// @LINE:44
case controllers_dashboard_LiquidacionesController_liquidacionesPorOrganigrama34(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesController.liquidacionesPorOrganigrama(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorOrganigrama", Nil,"GET", """""", Routes.prefix + """liquidacionesPorOrganigrama"""))
   }
}
        

// @LINE:45
case controllers_dashboard_LiquidacionesReportesController_liquidacionesPorOrganigrama35(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesReportesController.liquidacionesPorOrganigrama(), HandlerDef(this, "controllers.dashboard.LiquidacionesReportesController", "liquidacionesPorOrganigrama", Nil,"GET", """""", Routes.prefix + """liquidacionesPorOrganigramaReporte"""))
   }
}
        

// @LINE:46
case controllers_dashboard_LiquidacionesReportesController_liquidacionesPorEscala36(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesReportesController.liquidacionesPorEscala(), HandlerDef(this, "controllers.dashboard.LiquidacionesReportesController", "liquidacionesPorEscala", Nil,"GET", """""", Routes.prefix + """liquidacionesPorEscalaReporte"""))
   }
}
        

// @LINE:47
case controllers_dashboard_LiquidacionesController_liquidacionesTotalesPorEscala37(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesController.liquidacionesTotalesPorEscala(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesTotalesPorEscala", Nil,"GET", """""", Routes.prefix + """liquidacionesTotalesPorEscala"""))
   }
}
        

// @LINE:49
case controllers_dashboard_LiquidacionesController_liquidacionesPorAgrupadoOrganigrama38(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesController.liquidacionesPorAgrupadoOrganigrama(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorAgrupadoOrganigrama", Nil,"GET", """""", Routes.prefix + """liquidacionesPorAgrupadoOrganigrama"""))
   }
}
        

// @LINE:50
case controllers_dashboard_LiquidacionesReportesController_liquidacionesPorAgrupadoOrganigrama39(params) => {
   call { 
        invokeHandler(controllers.dashboard.LiquidacionesReportesController.liquidacionesPorAgrupadoOrganigrama(), HandlerDef(this, "controllers.dashboard.LiquidacionesReportesController", "liquidacionesPorAgrupadoOrganigrama", Nil,"GET", """""", Routes.prefix + """liquidacionesPorAgrupadoOrganigramaReporte"""))
   }
}
        

// @LINE:52
case controllers_dashboard_ImpuestosController_estadoDeuda40(params) => {
   call { 
        invokeHandler(controllers.dashboard.ImpuestosController.estadoDeuda(), HandlerDef(this, "controllers.dashboard.ImpuestosController", "estadoDeuda", Nil,"GET", """""", Routes.prefix + """impuestosDeuda"""))
   }
}
        

// @LINE:53
case controllers_dashboard_ImpuestosController_detalleImpuestos41(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.ImpuestosController.detalleImpuestos(id), HandlerDef(this, "controllers.dashboard.ImpuestosController", "detalleImpuestos", Seq(classOf[Long]),"GET", """""", Routes.prefix + """detalleImpuestos"""))
   }
}
        

// @LINE:55
case controllers_dashboard_ProveedoresController_estadoPorExpedientePorLinea42(params) => {
   call { 
        invokeHandler(controllers.dashboard.ProveedoresController.estadoPorExpedientePorLinea(), HandlerDef(this, "controllers.dashboard.ProveedoresController", "estadoPorExpedientePorLinea", Nil,"GET", """""", Routes.prefix + """estadoPorExpedientePorLinea"""))
   }
}
        

// @LINE:56
case controllers_dashboard_ProveedoresController_reporteEstadoDefinitivoExpedienteLineas43(params) => {
   call(params.fromQuery[Long]("proveedorId", Some(0)), params.fromQuery[Long]("rubroId", Some(0)), params.fromQuery[Long]("ejercicioId", Some(0))) { (proveedorId, rubroId, ejercicioId) =>
        invokeHandler(controllers.dashboard.ProveedoresController.reporteEstadoDefinitivoExpedienteLineas(proveedorId, rubroId, ejercicioId), HandlerDef(this, "controllers.dashboard.ProveedoresController", "reporteEstadoDefinitivoExpedienteLineas", Seq(classOf[Long], classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """reporteEstadoDefinitivoExpedienteLineas"""))
   }
}
        

// @LINE:58
case controllers_dashboard_InformeEstadisticoDeudaProveedoresController_index44(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeEstadisticoDeudaProveedoresController.index(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "index", Nil,"GET", """""", Routes.prefix + """informe-estadistico-deuda-proveedores"""))
   }
}
        

// @LINE:59
case controllers_dashboard_InformeDeudaPorActasController_index45(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeDeudaPorActasController.index(), HandlerDef(this, "controllers.dashboard.InformeDeudaPorActasController", "index", Nil,"GET", """""", Routes.prefix + """informe-deuda-actas"""))
   }
}
        

// @LINE:60
case controllers_dashboard_InformeDeudaPorActasController_archivoDeudaPorActas46(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeDeudaPorActasController.archivoDeudaPorActas(), HandlerDef(this, "controllers.dashboard.InformeDeudaPorActasController", "archivoDeudaPorActas", Nil,"GET", """""", Routes.prefix + """archivo-deuda-actas"""))
   }
}
        

// @LINE:61
case controllers_dashboard_InformeEstadisticoDeudaProveedoresController_diferencias47(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeEstadisticoDeudaProveedoresController.diferencias(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "diferencias", Nil,"GET", """""", Routes.prefix + """diferencias"""))
   }
}
        

// @LINE:62
case controllers_dashboard_InformeEstadisticoDeudaProveedoresController_procesarDiferencias48(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeEstadisticoDeudaProveedoresController.procesarDiferencias(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "procesarDiferencias", Nil,"POST", """""", Routes.prefix + """procesar-diferencias"""))
   }
}
        

// @LINE:64
case controllers_dashboard_InformeEstadisticoDeudaProveedoresController_archivoEstadistico49(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeEstadisticoDeudaProveedoresController.archivoEstadistico(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "archivoEstadistico", Nil,"GET", """""", Routes.prefix + """informe-estadistico-deuda-proveedores/descarga"""))
   }
}
        

// @LINE:65
case controllers_dashboard_InformeEstadisticoDeudaProveedoresController_getActas50(params) => {
   call(params.fromQuery[Long]("id_orden_provision", None)) { (id_orden_provision) =>
        invokeHandler(controllers.dashboard.InformeEstadisticoDeudaProveedoresController.getActas(id_orden_provision), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "getActas", Seq(classOf[Long]),"GET", """""", Routes.prefix + """informe-estadistico-deuda-proveedores/get-actas"""))
   }
}
        

// @LINE:67
case controllers_dashboard_InformeEstadisticoPagoProveedoresController_index51(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeEstadisticoPagoProveedoresController.index(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "index", Nil,"GET", """""", Routes.prefix + """informe-estadistico-pago-proveedores"""))
   }
}
        

// @LINE:68
case controllers_dashboard_InformeEstadisticoPagoProveedoresController_archivoEstadistico52(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeEstadisticoPagoProveedoresController.archivoEstadistico(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "archivoEstadistico", Nil,"GET", """""", Routes.prefix + """informe-estadistico-pago-proveedores/descarga"""))
   }
}
        

// @LINE:70
case controllers_dashboard_InformeEstadisticoPagoProveedoresController_informePeriodoProveedor53(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeEstadisticoPagoProveedoresController.informePeriodoProveedor(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "informePeriodoProveedor", Nil,"GET", """""", Routes.prefix + """informe-pago-periodo-proveedores"""))
   }
}
        

// @LINE:71
case controllers_dashboard_InformeEstadisticoPagoProveedoresController_informePeriodoProveedorReporte54(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeEstadisticoPagoProveedoresController.informePeriodoProveedorReporte(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "informePeriodoProveedorReporte", Nil,"GET", """""", Routes.prefix + """informe-pago-periodo-proveedores-reportes"""))
   }
}
        

// @LINE:73
case controllers_dashboard_InformeEstadisticoPagoProveedoresController_informeProveedor55(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformeEstadisticoPagoProveedoresController.informeProveedor(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "informeProveedor", Nil,"GET", """""", Routes.prefix + """informeProveedor"""))
   }
}
        

// @LINE:76
case controllers_dashboard_AutorizadosController_index56(params) => {
   call { 
        invokeHandler(controllers.dashboard.AutorizadosController.index(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "index", Nil,"GET", """""", Routes.prefix + """autorizado"""))
   }
}
        

// @LINE:77
case controllers_dashboard_AutorizadosController_crear57(params) => {
   call { 
        invokeHandler(controllers.dashboard.AutorizadosController.crear(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "crear", Nil,"GET", """""", Routes.prefix + """autorizado/crear"""))
   }
}
        

// @LINE:78
case controllers_dashboard_AutorizadosController_guardar58(params) => {
   call { 
        invokeHandler(controllers.dashboard.AutorizadosController.guardar(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "guardar", Nil,"POST", """""", Routes.prefix + """autorizado/guardar"""))
   }
}
        

// @LINE:79
case controllers_dashboard_AutorizadosController_editar59(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.editar(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """autorizado/editar"""))
   }
}
        

// @LINE:80
case controllers_dashboard_AutorizadosController_eliminar60(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.eliminar(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """autorizado/eliminar"""))
   }
}
        

// @LINE:81
case controllers_dashboard_AutorizadosController_ver61(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.ver(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """autorizado/ver"""))
   }
}
        

// @LINE:82
case controllers_dashboard_AutorizadosController_actualizar62(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.actualizar(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """autorizado/actualizar"""))
   }
}
        

// @LINE:83
case controllers_dashboard_AutorizadosController_cambiarEstado63(params) => {
   call(params.fromQuery[Long]("idAutorizado", None), params.fromQuery[Long]("idEstado", None)) { (idAutorizado, idEstado) =>
        invokeHandler(controllers.dashboard.AutorizadosController.cambiarEstado(idAutorizado, idEstado), HandlerDef(this, "controllers.dashboard.AutorizadosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """autorizado/cambiarEstado"""))
   }
}
        

// @LINE:84
case controllers_dashboard_AutorizadosController_cargarLineasAutorizados64(params) => {
   call { 
        invokeHandler(controllers.dashboard.AutorizadosController.cargarLineasAutorizados(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "cargarLineasAutorizados", Nil,"POST", """""", Routes.prefix + """autorizado/cargarLineasAutorizados"""))
   }
}
        

// @LINE:85
case controllers_dashboard_AutorizadosController_cargarLineasAutorizadosCertificacionesCompras65(params) => {
   call { 
        invokeHandler(controllers.dashboard.AutorizadosController.cargarLineasAutorizadosCertificacionesCompras(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "cargarLineasAutorizadosCertificacionesCompras", Nil,"POST", """""", Routes.prefix + """autorizado/cargarLineasAutorizadosCertificacionesCompras"""))
   }
}
        

// @LINE:86
case controllers_dashboard_AutorizadosController_modalAgregarMontos66(params) => {
   call(params.fromQuery[Long]("idOrdenProvision", Some(0)), params.fromQuery[Long]("idAutorizado", None), params.fromQuery[Long]("idOrdenCompra", Some(0)), params.fromQuery[Long]("tipo_cuenta_id", Some(0))) { (idOrdenProvision, idAutorizado, idOrdenCompra, tipo_cuenta_id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.modalAgregarMontos(idOrdenProvision, idAutorizado, idOrdenCompra, tipo_cuenta_id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "modalAgregarMontos", Seq(classOf[Long], classOf[Long], classOf[Long], classOf[Long]),"POST", """""", Routes.prefix + """autorizado/modalAgregarMontos"""))
   }
}
        

// @LINE:87
case controllers_dashboard_AutorizadosController_getListadoDeudas67(params) => {
   call { 
        invokeHandler(controllers.dashboard.AutorizadosController.getListadoDeudas(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "getListadoDeudas", Nil,"GET", """""", Routes.prefix + """autorizado/getListadoDeudas"""))
   }
}
        

// @LINE:88
case controllers_dashboard_AutorizadosController_getListadoDeudasActas68(params) => {
   call { 
        invokeHandler(controllers.dashboard.AutorizadosController.getListadoDeudasActas(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "getListadoDeudasActas", Nil,"GET", """""", Routes.prefix + """autorizado/getListadoDeudasActas"""))
   }
}
        

// @LINE:89
case controllers_dashboard_AutorizadosController_getActualizarDatos69(params) => {
   call(params.fromQuery[Long]("idAutorizado", None)) { (idAutorizado) =>
        invokeHandler(controllers.dashboard.AutorizadosController.getActualizarDatos(idAutorizado), HandlerDef(this, "controllers.dashboard.AutorizadosController", "getActualizarDatos", Seq(classOf[Long]),"GET", """""", Routes.prefix + """autorizado/getActualizarDatos"""))
   }
}
        

// @LINE:90
case controllers_dashboard_AutorizadosController_controlCargaCotizacion70(params) => {
   call { 
        invokeHandler(controllers.dashboard.AutorizadosController.controlCargaCotizacion(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "controlCargaCotizacion", Nil,"POST", """""", Routes.prefix + """autorizado/controlCargaCotizacion"""))
   }
}
        

// @LINE:92
case controllers_dashboard_AutorizadosController_modalAgregarMontosActas71(params) => {
   call(params.fromQuery[Long]("idActa", Some(0)), params.fromQuery[Long]("idOrdenProvision", Some(0)), params.fromQuery[Long]("idAutorizado", None), params.fromQuery[Long]("idOrdenCompra", Some(0)), params.fromQuery[Long]("tipo_cuenta_id", Some(0))) { (idActa, idOrdenProvision, idAutorizado, idOrdenCompra, tipo_cuenta_id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.modalAgregarMontosActas(idActa, idOrdenProvision, idAutorizado, idOrdenCompra, tipo_cuenta_id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "modalAgregarMontosActas", Seq(classOf[Long], classOf[Long], classOf[Long], classOf[Long], classOf[Long]),"POST", """""", Routes.prefix + """autorizado/modalAgregarMontosActas"""))
   }
}
        

// @LINE:93
case controllers_dashboard_AutorizadosController_modalAgregarMontosSinOp72(params) => {
   call(params.fromQuery[Long]("idAutorizado", None), params.fromQuery[Long]("idOrdenCompra", Some(0)), params.fromQuery[Long]("tipo_cuenta_id", Some(0))) { (idAutorizado, idOrdenCompra, tipo_cuenta_id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.modalAgregarMontosSinOp(idAutorizado, idOrdenCompra, tipo_cuenta_id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "modalAgregarMontosSinOp", Seq(classOf[Long], classOf[Long], classOf[Long]),"POST", """""", Routes.prefix + """autorizado/modalAgregarMontosSinOp"""))
   }
}
        

// @LINE:94
case controllers_dashboard_AutorizadosController_modalAgregarMontosCertificacionesCompras73(params) => {
   call(params.fromQuery[Long]("idCertificacion", Some(0)), params.fromQuery[Long]("idAutorizado", None), params.fromQuery[Long]("idOrdenCompra", None), params.fromQuery[Long]("tipo_cuenta_id", Some(0))) { (idCertificacion, idAutorizado, idOrdenCompra, tipo_cuenta_id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.modalAgregarMontosCertificacionesCompras(idCertificacion, idAutorizado, idOrdenCompra, tipo_cuenta_id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "modalAgregarMontosCertificacionesCompras", Seq(classOf[Long], classOf[Long], classOf[Long], classOf[Long]),"POST", """""", Routes.prefix + """autorizado/modalAgregarMontosCertificacionesCompras"""))
   }
}
        

// @LINE:96
case controllers_dashboard_AutorizadosController_getResumen74(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.getResumen(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "getResumen", Seq(classOf[Long]),"GET", """""", Routes.prefix + """autorizado/getResumen"""))
   }
}
        

// @LINE:97
case controllers_dashboard_AutorizadosController_reporteAutorizado75(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.reporteAutorizado(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "reporteAutorizado", Seq(classOf[Long]),"GET", """""", Routes.prefix + """autorizado/reporteAutorizado"""))
   }
}
        

// @LINE:98
case controllers_dashboard_AutorizadosController_reporteAutorizadoExcel76(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.reporteAutorizadoExcel(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "reporteAutorizadoExcel", Seq(classOf[Long]),"GET", """""", Routes.prefix + """autorizado/reporteAutorizadoExcel"""))
   }
}
        

// @LINE:99
case controllers_dashboard_AutorizadosController_reporteAutorizadoRemitos77(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.AutorizadosController.reporteAutorizadoRemitos(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "reporteAutorizadoRemitos", Seq(classOf[Long]),"GET", """""", Routes.prefix + """autorizado/reporteAutorizadoRemitos"""))
   }
}
        

// @LINE:101
case controllers_dashboard_AutorizadosController_cargarLineasAutorizadosMasivamente78(params) => {
   call { 
        invokeHandler(controllers.dashboard.AutorizadosController.cargarLineasAutorizadosMasivamente(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "cargarLineasAutorizadosMasivamente", Nil,"POST", """""", Routes.prefix + """autorizado/cargarLineasAutorizadosMasivamente"""))
   }
}
        

// @LINE:103
case controllers_dashboard_AutorizadoLineasController_index79(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.dashboard.AutorizadoLineasController.index(id, editable), HandlerDef(this, "controllers.dashboard.AutorizadoLineasController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """autorizado-linea/index"""))
   }
}
        

// @LINE:104
case controllers_dashboard_AutorizadoLineasController_eliminar80(params) => {
   call(params.fromQuery[Long]("autorizado_id", None), params.fromQuery[Long]("orden_id", None)) { (autorizado_id, orden_id) =>
        invokeHandler(controllers.dashboard.AutorizadoLineasController.eliminar(autorizado_id, orden_id), HandlerDef(this, "controllers.dashboard.AutorizadoLineasController", "eliminar", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """autorizado-linea/eliminar"""))
   }
}
        

// @LINE:106
case controllers_dashboard_AutorizadoLineasController_getActas81(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.AutorizadoLineasController.getActas(id), HandlerDef(this, "controllers.dashboard.AutorizadoLineasController", "getActas", Seq(classOf[Long]),"GET", """""", Routes.prefix + """autorizado-linea/get-actas"""))
   }
}
        

// @LINE:109
case controllers_dashboard_InformesRecuperoController_index82(params) => {
   call { 
        invokeHandler(controllers.dashboard.InformesRecuperoController.index(), HandlerDef(this, "controllers.dashboard.InformesRecuperoController", "index", Nil,"GET", """""", Routes.prefix + """indexInformeRecupero"""))
   }
}
        

// @LINE:110
case controllers_dashboard_InformesRecuperoController_deudasPorTipoDeCliente83(params) => {
   call(params.fromQuery[Long]("idTipoCliente", None)) { (idTipoCliente) =>
        invokeHandler(controllers.dashboard.InformesRecuperoController.deudasPorTipoDeCliente(idTipoCliente), HandlerDef(this, "controllers.dashboard.InformesRecuperoController", "deudasPorTipoDeCliente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """deudasRecuperoPorTipoDeCliente"""))
   }
}
        

// @LINE:112
case controllers_dashboard_InformesRecuperoReportesController_deudasPorTipoDeCliente84(params) => {
   call(params.fromQuery[Long]("idTipoCliente", None)) { (idTipoCliente) =>
        invokeHandler(controllers.dashboard.InformesRecuperoReportesController.deudasPorTipoDeCliente(idTipoCliente), HandlerDef(this, "controllers.dashboard.InformesRecuperoReportesController", "deudasPorTipoDeCliente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """deudasRecuperoPorTipoDeClienteReporte"""))
   }
}
        

// @LINE:114
case controllers_dashboard_DeudasGlobalizadasController_index85(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.index(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "index", Nil,"GET", """""", Routes.prefix + """deudas"""))
   }
}
        

// @LINE:115
case controllers_dashboard_DeudasGlobalizadasController_deudasResumidas86(params) => {
   call(params.fromQuery[Int]("deposito", Some(0)), params.fromQuery[Boolean]("ra", Some(false))) { (deposito, ra) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasResumidas(deposito, ra), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasResumidas", Seq(classOf[Int], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasResumidas"""))
   }
}
        

// @LINE:116
case controllers_dashboard_DeudasGlobalizadasController_deudasDetalles87(params) => {
   call(params.fromQuery[Int]("idProveedor", Some(0)), params.fromQuery[Boolean]("ra", Some(false))) { (idProveedor, ra) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasDetalles(idProveedor, ra), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetalles", Seq(classOf[Int], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasPorProveedorHEARM"""))
   }
}
        

// @LINE:117
case controllers_dashboard_DeudasGlobalizadasController_deudasDetallesOtros88(params) => {
   call(params.fromQuery[Boolean]("profe", Some(false)), params.fromQuery[Boolean]("equipamientos", Some(false))) { (profe, equipamientos) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasDetallesOtros(profe, equipamientos), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesOtros", Seq(classOf[Boolean], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasDetallesOtros"""))
   }
}
        

// @LINE:118
case controllers_dashboard_DeudasGlobalizadasController_deudasDetallesCuentas89(params) => {
   call(params.fromQuery[Int]("idCuenta", Some(0))) { (idCuenta) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasDetallesCuentas(idCuenta), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesCuentas", Seq(classOf[Int]),"GET", """""", Routes.prefix + """deudasDetallesCuentas"""))
   }
}
        

// @LINE:119
case controllers_dashboard_DeudasGlobalizadasController_deudasDetallesPorProveedor90(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasDetallesPorProveedor(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesPorProveedor", Nil,"GET", """""", Routes.prefix + """deudasDetallesPorProveedor"""))
   }
}
        

// @LINE:121
case controllers_dashboard_DeudasGlobalizadasController_deudasDetallesOtrosProveedoresResumen91(params) => {
   call(params.fromQuery[Boolean]("profe", Some(false)), params.fromQuery[Boolean]("equipamientos", Some(false))) { (profe, equipamientos) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasDetallesOtrosProveedoresResumen(profe, equipamientos), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesOtrosProveedoresResumen", Seq(classOf[Boolean], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasDetallesOtrosProveedoresResumen"""))
   }
}
        

// @LINE:124
case controllers_dashboard_DeudasGlobalizadasController_deudasDetallesServicios92(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasDetallesServicios(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesServicios", Nil,"GET", """""", Routes.prefix + """deudasDetallesServicios"""))
   }
}
        

// @LINE:125
case controllers_dashboard_DeudasGlobalizadasController_deudasDetallesServiciosResumen93(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasDetallesServiciosResumen(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesServiciosResumen", Nil,"GET", """""", Routes.prefix + """deudasDetallesServiciosResumen"""))
   }
}
        

// @LINE:126
case controllers_dashboard_DeudasGlobalizadasController_deudasDetallesHonorarios94(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasDetallesHonorarios(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesHonorarios", Nil,"GET", """""", Routes.prefix + """deudasDetallesHonorarios"""))
   }
}
        

// @LINE:127
case controllers_dashboard_DeudasGlobalizadasController_deudasDetallesHonorariosResumen95(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasController.deudasDetallesHonorariosResumen(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesHonorariosResumen", Nil,"GET", """""", Routes.prefix + """deudasDetallesHonorariosResumen"""))
   }
}
        

// @LINE:129
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasResumidasReporte96(params) => {
   call(params.fromQuery[Int]("deposito", Some(0)), params.fromQuery[Boolean]("ra", Some(false))) { (deposito, ra) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasResumidasReporte(deposito, ra), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasResumidasReporte", Seq(classOf[Int], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasResumidasReporte"""))
   }
}
        

// @LINE:130
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesReporte97(params) => {
   call(params.fromQuery[Int]("idProveedor", Some(0)), params.fromQuery[Boolean]("ra", Some(false))) { (idProveedor, ra) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesReporte(idProveedor, ra), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesReporte", Seq(classOf[Int], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasDetallesReporte"""))
   }
}
        

// @LINE:131
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesOtrosReportes98(params) => {
   call(params.fromQuery[Boolean]("profe", Some(false)), params.fromQuery[Boolean]("equipamientos", Some(false))) { (profe, equipamientos) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesOtrosReportes(profe, equipamientos), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesOtrosReportes", Seq(classOf[Boolean], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasDetallesOtrosReportes"""))
   }
}
        

// @LINE:132
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasInformeGeneral99(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasInformeGeneral(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasInformeGeneral", Nil,"GET", """""", Routes.prefix + """deudasInformeGeneral"""))
   }
}
        

// @LINE:133
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasInformeGeneralResumen100(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasInformeGeneralResumen(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasInformeGeneralResumen", Nil,"GET", """""", Routes.prefix + """deudasInformeGeneralResumen"""))
   }
}
        

// @LINE:134
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesServiciosReportes101(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesServiciosReportes(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesServiciosReportes", Nil,"GET", """""", Routes.prefix + """deudasDetallesServiciosReportes"""))
   }
}
        

// @LINE:135
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesHonorariosReportes102(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesHonorariosReportes(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesHonorariosReportes", Nil,"GET", """""", Routes.prefix + """deudasDetallesHonorariosReportes"""))
   }
}
        

// @LINE:136
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasServiciosProveedoresResumenReportes103(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasServiciosProveedoresResumenReportes(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasServiciosProveedoresResumenReportes", Nil,"GET", """""", Routes.prefix + """deudasServiciosProveedoresResumenReportes"""))
   }
}
        

// @LINE:137
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasHonorariosProveedoresResumenReportes104(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasHonorariosProveedoresResumenReportes(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasHonorariosProveedoresResumenReportes", Nil,"GET", """""", Routes.prefix + """deudasHonorariosProveedoresResumenReportes"""))
   }
}
        

// @LINE:139
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasCuentasReportes105(params) => {
   call(params.fromQuery[Int]("idCuenta", Some(0)), params.fromQuery[Boolean]("soloDeuda", Some(false))) { (idCuenta, soloDeuda) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasCuentasReportes(idCuenta, soloDeuda), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasCuentasReportes", Seq(classOf[Int], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasCuentasReportes"""))
   }
}
        

// @LINE:141
case controllers_dashboard_DeudasGlobalizadasReportesController_deudasDetallesOtrosProveedoresResumen106(params) => {
   call(params.fromQuery[Boolean]("profe", Some(false)), params.fromQuery[Boolean]("equipamientos", Some(false))) { (profe, equipamientos) =>
        invokeHandler(controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesOtrosProveedoresResumen(profe, equipamientos), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesOtrosProveedoresResumen", Seq(classOf[Boolean], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasOtrosProveedoresResumenReporte"""))
   }
}
        

// @LINE:144
case controllers_dashboard_UltimasCotizacionesController_indexUltimaCotizaciones107(params) => {
   call { 
        invokeHandler(controllers.dashboard.UltimasCotizacionesController.indexUltimaCotizaciones(), HandlerDef(this, "controllers.dashboard.UltimasCotizacionesController", "indexUltimaCotizaciones", Nil,"GET", """""", Routes.prefix + """cotizacion"""))
   }
}
        

// @LINE:145
case controllers_dashboard_UltimasCotizacionesController_crearUltimaCotizaciones108(params) => {
   call { 
        invokeHandler(controllers.dashboard.UltimasCotizacionesController.crearUltimaCotizaciones(), HandlerDef(this, "controllers.dashboard.UltimasCotizacionesController", "crearUltimaCotizaciones", Nil,"GET", """""", Routes.prefix + """cotizacion/crear"""))
   }
}
        

// @LINE:146
case controllers_dashboard_UltimasCotizacionesController_guardarUltimaCotizaciones109(params) => {
   call { 
        invokeHandler(controllers.dashboard.UltimasCotizacionesController.guardarUltimaCotizaciones(), HandlerDef(this, "controllers.dashboard.UltimasCotizacionesController", "guardarUltimaCotizaciones", Nil,"POST", """""", Routes.prefix + """cotizacion/guardar"""))
   }
}
        

// @LINE:147
case controllers_dashboard_UltimasCotizacionesController_eliminar110(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.dashboard.UltimasCotizacionesController.eliminar(id), HandlerDef(this, "controllers.dashboard.UltimasCotizacionesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cotizacion/eliminar"""))
   }
}
        

// @LINE:149
case controllers_dashboard_DeudasPorAntiguedadController_index111(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadController.index(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "index", Nil,"GET", """""", Routes.prefix + """deudasPorAntigueda"""))
   }
}
        

// @LINE:150
case controllers_dashboard_DeudasPorAntiguedadController_deudasDetalles112(params) => {
   call(params.fromQuery[Int]("idProveedor", Some(0)), params.fromQuery[Boolean]("equipamiento", Some(false))) { (idProveedor, equipamiento) =>
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadController.deudasDetalles(idProveedor, equipamiento), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetalles", Seq(classOf[Int], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasPorProveedorPorAntiguedad"""))
   }
}
        

// @LINE:151
case controllers_dashboard_DeudasPorAntiguedadReportesController_deudasDetallesReporte113(params) => {
   call(params.fromQuery[Int]("idProveedor", Some(0)), params.fromQuery[Boolean]("equipamiento", Some(false)), params.fromQuery[Int]("idCuenta", Some(0)), params.fromQuery[Boolean]("sinServicio", Some(false))) { (idProveedor, equipamiento, idCuenta, sinServicio) =>
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallesReporte(idProveedor, equipamiento, idCuenta, sinServicio), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasDetallesReporte", Seq(classOf[Int], classOf[Boolean], classOf[Int], classOf[Boolean]),"GET", """""", Routes.prefix + """deudasDetallesPorAntiguedadReporte"""))
   }
}
        

// @LINE:152
case controllers_dashboard_DeudasPorAntiguedadReportesController_deudasInformeGeneral114(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadReportesController.deudasInformeGeneral(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasInformeGeneral", Nil,"GET", """""", Routes.prefix + """deudasInformeGeneralPorAntiguedad"""))
   }
}
        

// @LINE:153
case controllers_dashboard_DeudasPorAntiguedadReportesController_deudasInformeGeneralNuevo115(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadReportesController.deudasInformeGeneralNuevo(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasInformeGeneralNuevo", Nil,"GET", """""", Routes.prefix + """deudasInformeGeneralPorAntiguedadNuevo"""))
   }
}
        

// @LINE:154
case controllers_dashboard_DeudasPorAntiguedadController_deudasResumenMensual116(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadController.deudasResumenMensual(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasResumenMensual", Nil,"GET", """""", Routes.prefix + """deudasResumenMensual"""))
   }
}
        

// @LINE:155
case controllers_dashboard_DeudasPorAntiguedadReportesController_deudasMensualReporte117(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadReportesController.deudasMensualReporte(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasMensualReporte", Nil,"GET", """""", Routes.prefix + """deudasMensualReporte"""))
   }
}
        

// @LINE:156
case controllers_dashboard_DeudasPorAntiguedadController_deudasDetallesServicios118(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesServicios(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetallesServicios", Nil,"GET", """""", Routes.prefix + """deudasDetallesServiciosPorAntiguedad"""))
   }
}
        

// @LINE:157
case controllers_dashboard_DeudasPorAntiguedadController_deudasDetallesPorProveedor119(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesPorProveedor(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetallesPorProveedor", Nil,"GET", """""", Routes.prefix + """deudasDetallesPorAntiguedaPorProveedor"""))
   }
}
        

// @LINE:159
case controllers_dashboard_DeudasPorAntiguedadController_deudasDetallesInstitucion120(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesInstitucion(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetallesInstitucion", Nil,"GET", """""", Routes.prefix + """deudasDetallesInstitucion"""))
   }
}
        

// @LINE:160
case controllers_dashboard_DeudasPorAntiguedadController_deudasResumenInstitucion121(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadController.deudasResumenInstitucion(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasResumenInstitucion", Nil,"GET", """""", Routes.prefix + """deudasResumenInstitucion"""))
   }
}
        

// @LINE:161
case controllers_dashboard_DeudasPorAntiguedadReportesController_deudasDetallePorInstitucionReporte122(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallePorInstitucionReporte(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasDetallePorInstitucionReporte", Nil,"GET", """""", Routes.prefix + """deudasDetallePorInstitucionReporte"""))
   }
}
        

// @LINE:162
case controllers_dashboard_DeudasPorAntiguedadReportesController_deudasResumenPorInstitucionReporte123(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadReportesController.deudasResumenPorInstitucionReporte(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasResumenPorInstitucionReporte", Nil,"GET", """""", Routes.prefix + """deudasResumenPorInstitucionReporte"""))
   }
}
        

// @LINE:163
case controllers_dashboard_DeudasPorAntiguedadReportesController_deudasDetallesServiciosReportes124(params) => {
   call { 
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallesServiciosReportes(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasDetallesServiciosReportes", Nil,"GET", """""", Routes.prefix + """deudasDetallesAntiguedadServiciosReportes"""))
   }
}
        

// @LINE:165
case controllers_dashboard_DeudasPorAntiguedadController_deudasDetallesCuenta125(params) => {
   call(params.fromQuery[Int]("idCuenta", Some(0))) { (idCuenta) =>
        invokeHandler(controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesCuenta(idCuenta), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetallesCuenta", Seq(classOf[Int]),"GET", """""", Routes.prefix + """deudasDetallesAntiguedadCuenta"""))
   }
}
        

// @LINE:168
case controllers_dashboard_ControlDeudaController_autorizadoDistintoDePagado126(params) => {
   call { 
        invokeHandler(controllers.dashboard.ControlDeudaController.autorizadoDistintoDePagado(), HandlerDef(this, "controllers.dashboard.ControlDeudaController", "autorizadoDistintoDePagado", Nil,"GET", """""", Routes.prefix + """autorizadoDistintoDePagado"""))
   }
}
        

// @LINE:169
case controllers_dashboard_ControlDeudaController_getAutorizadoDistintoDePagado127(params) => {
   call { 
        invokeHandler(controllers.dashboard.ControlDeudaController.getAutorizadoDistintoDePagado(), HandlerDef(this, "controllers.dashboard.ControlDeudaController", "getAutorizadoDistintoDePagado", Nil,"GET", """""", Routes.prefix + """getAutorizadoDistintoDePagado"""))
   }
}
        

// @LINE:170
case controllers_dashboard_ControlDeudaController_controlDeudaMonedaExtranjera128(params) => {
   call { 
        invokeHandler(controllers.dashboard.ControlDeudaController.controlDeudaMonedaExtranjera(), HandlerDef(this, "controllers.dashboard.ControlDeudaController", "controlDeudaMonedaExtranjera", Nil,"GET", """""", Routes.prefix + """controlDeudaMonedaExtranjera"""))
   }
}
        

// @LINE:171
case controllers_dashboard_ControlDeudaController_index129(params) => {
   call { 
        invokeHandler(controllers.dashboard.ControlDeudaController.index(), HandlerDef(this, "controllers.dashboard.ControlDeudaController", "index", Nil,"GET", """""", Routes.prefix + """indexControlDeuda"""))
   }
}
        

// @LINE:173
case controllers_dashboard_MovimientosCuentasController_index130(params) => {
   call { 
        invokeHandler(controllers.dashboard.MovimientosCuentasController.index(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "index", Nil,"GET", """""", Routes.prefix + """resumenFinanciero"""))
   }
}
        

// @LINE:174
case controllers_dashboard_MovimientosCuentasController_resumenFinancieroGeneral131(params) => {
   call { 
        invokeHandler(controllers.dashboard.MovimientosCuentasController.resumenFinancieroGeneral(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "resumenFinancieroGeneral", Nil,"GET", """""", Routes.prefix + """resumenFinancieroGeneral"""))
   }
}
        

// @LINE:175
case controllers_dashboard_MovimientosCuentasController_resumenFinancieroDetalle132(params) => {
   call { 
        invokeHandler(controllers.dashboard.MovimientosCuentasController.resumenFinancieroDetalle(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "resumenFinancieroDetalle", Nil,"GET", """""", Routes.prefix + """resumenFinancieroDetalle"""))
   }
}
        

// @LINE:176
case controllers_dashboard_MovimientosCuentasController_resumenFinancieroDetallePorInstitucion133(params) => {
   call { 
        invokeHandler(controllers.dashboard.MovimientosCuentasController.resumenFinancieroDetallePorInstitucion(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "resumenFinancieroDetallePorInstitucion", Nil,"GET", """""", Routes.prefix + """resumenFinancieroDetalleInstitucion"""))
   }
}
        

// @LINE:177
case controllers_dashboard_MovimientosCuentasController_conciliacion134(params) => {
   call { 
        invokeHandler(controllers.dashboard.MovimientosCuentasController.conciliacion(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "conciliacion", Nil,"GET", """""", Routes.prefix + """conciliacion"""))
   }
}
        

// @LINE:179
case controllers_dashboard_AuditoriaController_index135(params) => {
   call { 
        invokeHandler(controllers.dashboard.AuditoriaController.index(), HandlerDef(this, "controllers.dashboard.AuditoriaController", "index", Nil,"GET", """""", Routes.prefix + """auditoria"""))
   }
}
        

// @LINE:180
case controllers_dashboard_InventarioRismiController_index136(params) => {
   call { 
        invokeHandler(controllers.dashboard.InventarioRismiController.index(), HandlerDef(this, "controllers.dashboard.InventarioRismiController", "index", Nil,"GET", """""", Routes.prefix + """inventarioRismi"""))
   }
}
        

// @LINE:182
case controllers_dashboard_PresupuestoController_index137(params) => {
   call { 
        invokeHandler(controllers.dashboard.PresupuestoController.index(), HandlerDef(this, "controllers.dashboard.PresupuestoController", "index", Nil,"GET", """""", Routes.prefix + """presuControl"""))
   }
}
        

// @LINE:183
case controllers_dashboard_PresupuestoController_devengado138(params) => {
   call { 
        invokeHandler(controllers.dashboard.PresupuestoController.devengado(), HandlerDef(this, "controllers.dashboard.PresupuestoController", "devengado", Nil,"GET", """""", Routes.prefix + """presuControl/devengado"""))
   }
}
        
}

}
     