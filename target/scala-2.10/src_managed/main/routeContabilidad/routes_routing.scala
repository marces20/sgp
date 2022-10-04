// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routeContabilidad.routes
// @HASH:fa3440083ee545870845839a5d2a998efa9fdd7f
// @DATE:Tue Oct 04 11:43:26 ART 2022
package routeContabilidad

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


// @LINE:1
private[this] lazy val controllers_contabilidad_IndexController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:2
private[this] lazy val controllers_contabilidad_OrdenesPagosController_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesPagos"))))
        

// @LINE:3
private[this] lazy val controllers_contabilidad_OrdenesPagosController_eliminar2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesPagos/eliminar"))))
        

// @LINE:4
private[this] lazy val controllers_contabilidad_OrdenesPagosController_crear3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesPagos/crear"))))
        

// @LINE:5
private[this] lazy val controllers_contabilidad_OrdenesPagosController_guardar4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesPagos/guardar"))))
        

// @LINE:6
private[this] lazy val controllers_contabilidad_OrdenesPagosController_editar5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesPagos/editar"))))
        

// @LINE:7
private[this] lazy val controllers_contabilidad_OrdenesPagosController_actualizar6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesPagos/actualizar"))))
        

// @LINE:8
private[this] lazy val controllers_contabilidad_OrdenesPagosController_modalBuscar7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesPagos/modalBuscar"))))
        

// @LINE:9
private[this] lazy val controllers_contabilidad_OrdenesPagosController_get8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesPagos/get"))))
        

// @LINE:11
private[this] lazy val controllers_contabilidad_FacturasController_index9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor"))))
        

// @LINE:12
private[this] lazy val controllers_contabilidad_FacturasController_crear10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/crear"))))
        

// @LINE:13
private[this] lazy val controllers_contabilidad_FacturasController_guardar11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/guardar"))))
        

// @LINE:14
private[this] lazy val controllers_contabilidad_FacturasController_editar12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/editar"))))
        

// @LINE:15
private[this] lazy val controllers_contabilidad_FacturasController_eliminar13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/eliminar"))))
        

// @LINE:16
private[this] lazy val controllers_contabilidad_FacturasController_eliminarFacturaDato14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/eliminarFacturaDato"))))
        

// @LINE:17
private[this] lazy val controllers_contabilidad_FacturasController_duplicar15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/duplicar"))))
        

// @LINE:18
private[this] lazy val controllers_contabilidad_FacturasController_crearFacturaParcial16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/crearFacturaParcial"))))
        

// @LINE:19
private[this] lazy val controllers_contabilidad_FacturasController_actasAsociadas17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/actas-asociada"))))
        

// @LINE:20
private[this] lazy val controllers_contabilidad_FacturasController_eliminarActaAsociada18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/eliminar-actas-asociada"))))
        

// @LINE:22
private[this] lazy val controllers_contabilidad_FacturasController_asignarActasAsociada19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/asignar-actas-asociada"))))
        

// @LINE:23
private[this] lazy val controllers_contabilidad_FacturasController_modalSeleccionActaRelacionada20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/seleccionar-actas-asociada"))))
        

// @LINE:27
private[this] lazy val controllers_contabilidad_FacturasReportesController_viatico21 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/viatico"))))
        

// @LINE:28
private[this] lazy val controllers_contabilidad_FacturasController_actualizar22 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/actualizar"))))
        

// @LINE:29
private[this] lazy val controllers_contabilidad_FacturasController_modalBuscar23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalBuscar"))))
        

// @LINE:30
private[this] lazy val controllers_contabilidad_FacturasController_get24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/get"))))
        

// @LINE:31
private[this] lazy val controllers_contabilidad_FacturasAccionesController_solicitud32225 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/acciones/solicitud322"))))
        

// @LINE:32
private[this] lazy val controllers_contabilidad_FacturasAccionesController_descargar32226 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/acciones/descargar322"))))
        

// @LINE:33
private[this] lazy val controllers_contabilidad_FacturasReportesController_OPCservicios27 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/OPCservicios"))))
        

// @LINE:34
private[this] lazy val controllers_contabilidad_FacturasReportesController_ordenDePago28 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/OrdenDePago"))))
        

// @LINE:35
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionSellos29 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComprobanteRetencionSellos"))))
        

// @LINE:36
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionMunicipal30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComprobanteRetencionMunicipal"))))
        

// @LINE:37
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionGcia31 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComprobanteRetencionGcia"))))
        

// @LINE:38
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionIva32 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComprobanteRetencionIva"))))
        

// @LINE:39
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComisiones33 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComisiones"))))
        

// @LINE:41
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalImportarListaComisiones34 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/acciones/modalImportarListaComisiones"))))
        

// @LINE:42
private[this] lazy val controllers_contabilidad_FacturasAccionesController_importarListaComisiones35 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/acciones/importarListaComisiones"))))
        

// @LINE:44
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalCargar34936 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/acciones/modalCargar349"))))
        

// @LINE:45
private[this] lazy val controllers_contabilidad_FacturasAccionesController_cargar34937 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/acciones/cargar349"))))
        

// @LINE:47
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteRendicionSellos38 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteRendicionSellos"))))
        

// @LINE:48
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencioniibb39 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComprobanteRetencionIibb"))))
        

// @LINE:49
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencioniibb37040 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComprobanteRetencionIibb370"))))
        

// @LINE:50
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionSeguridad41 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComprobanteRetencionSeguridad"))))
        

// @LINE:51
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionLimpieza42 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComprobanteRetencionLimpieza"))))
        

// @LINE:52
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionReggral43 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/reporteComprobanteRetencionReggral"))))
        

// @LINE:53
private[this] lazy val controllers_contabilidad_FacturasReportesController_modalInformeSellos44 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/modalInformeMensualSellos"))))
        

// @LINE:54
private[this] lazy val controllers_contabilidad_FacturasReportesController_informeSellos45 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reportes/informeMensualSellos"))))
        

// @LINE:56
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalPasarEnCurso46 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalPasarEnCurso"))))
        

// @LINE:57
private[this] lazy val controllers_contabilidad_FacturasAccionesController_pasarEnPreCursoMasivo47 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/pasarEnCursoMasivo"))))
        

// @LINE:58
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalPasarEnPreCurso48 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalPasarEnPreCurso"))))
        

// @LINE:59
private[this] lazy val controllers_contabilidad_FacturasAccionesController_pasarEnCursoMasivo49 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/pasarEnPreCursoMasivo"))))
        

// @LINE:60
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalPasarAprobado50 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalPasarAprobado"))))
        

// @LINE:61
private[this] lazy val controllers_contabilidad_FacturasAccionesController_pasarAprobadoMasivo51 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/pasarAprobadoMasivo"))))
        

// @LINE:62
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalPasarBorrador52 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalPasarBorrador"))))
        

// @LINE:63
private[this] lazy val controllers_contabilidad_FacturasAccionesController_pasarBorradorMasivo53 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/pasarBorradorMasivo"))))
        

// @LINE:64
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalPasarCancelado54 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalPasarCancelado"))))
        

// @LINE:65
private[this] lazy val controllers_contabilidad_FacturasAccionesController_pasarCanceladoMasivo55 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/pasarCanceladoMasivo"))))
        

// @LINE:66
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalPasarPreAprobado56 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalPasarPreAprobado"))))
        

// @LINE:67
private[this] lazy val controllers_contabilidad_FacturasAccionesController_pasarPreAprobadoMasivo57 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/pasarPreAprobadoMasivo"))))
        

// @LINE:68
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalCargarOrdenPago58 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalCargarOrdenPago"))))
        

// @LINE:69
private[this] lazy val controllers_contabilidad_FacturasAccionesController_cargarOrdenPagoMasivo59 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/cargarOrdenPagoMasivo"))))
        

// @LINE:70
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalCargarFechaOrdenPago60 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalCargarFechaOrdenPago"))))
        

// @LINE:71
private[this] lazy val controllers_contabilidad_FacturasAccionesController_cargarFechaOrdenPagoMasivo61 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/cargarFechaOrdenPagoMasivo"))))
        

// @LINE:72
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalCargarFecha32262 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalCargarFecha322"))))
        

// @LINE:73
private[this] lazy val controllers_contabilidad_FacturasAccionesController_cargarFecha322Masivo63 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/cargarFecha322Masivo"))))
        

// @LINE:74
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalRechazarFactura64 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalRechazarFactura"))))
        

// @LINE:75
private[this] lazy val controllers_contabilidad_FacturasAccionesController_rechazar65 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/rechazar"))))
        

// @LINE:76
private[this] lazy val controllers_contabilidad_FacturasController_ver66 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/ver"))))
        

// @LINE:78
private[this] lazy val controllers_contabilidad_FacturasController_cambiarEstado67 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/cambiarEstado"))))
        

// @LINE:79
private[this] lazy val controllers_contabilidad_FacturasController_cambiarEstadoPrecargado68 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/cambiarEstadoPrecarga"))))
        

// @LINE:81
private[this] lazy val controllers_contabilidad_FacturasController_cambiarEstadoAprobado69 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/cambiarEstadoAprobado"))))
        

// @LINE:82
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteControlFacturas70 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reporteControlFactura"))))
        

// @LINE:83
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteControlFacturasAFIP71 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reporteControlFacturasAFIP"))))
        

// @LINE:84
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalDetalleFacturacion72 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalDetalleFacturacion"))))
        

// @LINE:85
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalDetalleFacturacionPorEstadoPorPeriodo73 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/acciones/modalDetalleFacturacionPorEstadoPorPeriodo"))))
        

// @LINE:86
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalMarcadoresMasivos74 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalMarcadoresMasivos"))))
        

// @LINE:87
private[this] lazy val controllers_contabilidad_FacturasAccionesController_marcadoresMasivos75 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/marcadoresMasivos"))))
        

// @LINE:88
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteLineasFacturas76 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reporteLineasFacturas"))))
        

// @LINE:90
private[this] lazy val controllers_contabilidad_FacturasReportesController_reporteFacturasCargadas77 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/reporteFacturasCargadas"))))
        

// @LINE:92
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalModificarNumeroFactura78 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalModificarNumeroFactura"))))
        

// @LINE:93
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modificarNumeroFactura79 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modificarNumeroFactura"))))
        

// @LINE:95
private[this] lazy val controllers_contabilidad_FacturasAccionesController_modalCargarNumeroFacturaParcial80 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/modalCargarNumeroFacturaParcial"))))
        

// @LINE:96
private[this] lazy val controllers_contabilidad_FacturasAccionesController_cargarNumeroFacturaParcial81 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/cargarNumeroFacturaParcial"))))
        

// @LINE:98
private[this] lazy val controllers_contabilidad_FacturasController_getInfoRetenciones82 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/getInfoRetenciones"))))
        

// @LINE:100
private[this] lazy val controllers_contabilidad_FacturasController_vistaFacturasCargadas83 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturaProveedor/vistaFacturasCargadas"))))
        

// @LINE:102
private[this] lazy val controllers_contabilidad_FacturasLineasController_index84 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/index"))))
        

// @LINE:103
private[this] lazy val controllers_contabilidad_FacturasLineasController_crear85 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/crear"))))
        

// @LINE:104
private[this] lazy val controllers_contabilidad_FacturasLineasController_editar86 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/editar"))))
        

// @LINE:105
private[this] lazy val controllers_contabilidad_FacturasLineasController_guardar87 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/guardar"))))
        

// @LINE:106
private[this] lazy val controllers_contabilidad_FacturasLineasController_actualizar88 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/actualizar"))))
        

// @LINE:107
private[this] lazy val controllers_contabilidad_FacturasLineasController_eliminar89 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/eliminar"))))
        

// @LINE:108
private[this] lazy val controllers_contabilidad_FacturasLineasController_eliminarMasivo90 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/eliminar-masivo"))))
        

// @LINE:110
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_index91 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/index"))))
        

// @LINE:111
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_crear92 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/crear"))))
        

// @LINE:112
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_editar93 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/editar"))))
        

// @LINE:113
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_guardar94 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/guardar"))))
        

// @LINE:114
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_actualizar95 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/actualizar"))))
        

// @LINE:115
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_eliminar96 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/eliminar"))))
        

// @LINE:116
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaRetencionSellos97 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/getSecuenciaRetencionSellos"))))
        

// @LINE:117
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaGanancias98 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/getSecuenciaGanancias"))))
        

// @LINE:118
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaIIBB99 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/getSecuenciaIIBB"))))
        

// @LINE:119
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaIva100 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/getSecuenciaIva"))))
        

// @LINE:120
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaRetencionMunicipal101 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/getSecuenciaRetencionMunicipal"))))
        

// @LINE:121
private[this] lazy val controllers_contabilidad_FacturasLineasImpuestosController_precalcular102 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-impuesto/precalcular"))))
        

// @LINE:123
private[this] lazy val controllers_contabilidad_FacturasLineasReintegrosController_index103 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-reintegro/index"))))
        

// @LINE:124
private[this] lazy val controllers_contabilidad_FacturasLineasReintegrosController_crear104 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-reintegro/crear"))))
        

// @LINE:125
private[this] lazy val controllers_contabilidad_FacturasLineasReintegrosController_editar105 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-reintegro/editar"))))
        

// @LINE:126
private[this] lazy val controllers_contabilidad_FacturasLineasReintegrosController_guardar106 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-reintegro/guardar"))))
        

// @LINE:127
private[this] lazy val controllers_contabilidad_FacturasLineasReintegrosController_actualizar107 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-reintegro/actualizar"))))
        

// @LINE:128
private[this] lazy val controllers_contabilidad_FacturasLineasReintegrosController_eliminar108 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea-reintegro/eliminar"))))
        

// @LINE:130
private[this] lazy val controllers_contabilidad_PagosController_index109 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor"))))
        

// @LINE:131
private[this] lazy val controllers_contabilidad_PagosController_duplicar110 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor/duplicar"))))
        

// @LINE:132
private[this] lazy val controllers_contabilidad_PagosController_ver111 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor/ver"))))
        

// @LINE:133
private[this] lazy val controllers_contabilidad_PagosController_crear112 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor/crear"))))
        

// @LINE:134
private[this] lazy val controllers_contabilidad_PagosController_guardar113 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor/guardar"))))
        

// @LINE:135
private[this] lazy val controllers_contabilidad_PagosController_editar114 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor/editar"))))
        

// @LINE:136
private[this] lazy val controllers_contabilidad_PagosController_eliminar115 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor/eliminar"))))
        

// @LINE:137
private[this] lazy val controllers_contabilidad_PagosController_actualizar116 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor/actualizar"))))
        

// @LINE:138
private[this] lazy val controllers_contabilidad_PagosController_cambiarEstado117 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor/cambiarEstado"))))
        

// @LINE:139
private[this] lazy val controllers_contabilidad_PagosController_cambiarEstadoTransferenciaConciliado118 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagoProveedor/cambiarEstadoTransferenciaConciliado"))))
        

// @LINE:141
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarFecha119 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarFecha"))))
        

// @LINE:142
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarFecha120 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarFecha"))))
        

// @LINE:143
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarReferencia121 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarReferencia"))))
        

// @LINE:144
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarReferencia122 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarReferencia"))))
        

// @LINE:145
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPagarInterno123 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPagarInterno"))))
        

// @LINE:146
private[this] lazy val controllers_contabilidad_PagosAccionesController_pagarInterno124 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/pagarInterno"))))
        

// @LINE:147
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPagarEmbargos125 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPagarEmbargos"))))
        

// @LINE:148
private[this] lazy val controllers_contabilidad_PagosAccionesController_pagarEmbargos126 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/pagarEmbargos"))))
        

// @LINE:149
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPagarEmbargosExternos127 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPagarEmbargosExternos"))))
        

// @LINE:150
private[this] lazy val controllers_contabilidad_PagosAccionesController_pagarEmbargosExternos128 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/pagarEmbargosExternos"))))
        

// @LINE:153
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPagarInterbankingProveedores129 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPagarInterbankingProveedores"))))
        

// @LINE:154
private[this] lazy val controllers_contabilidad_PagosAccionesController_pagarInterbankingProveedores130 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/pagarInterbankingProveedores"))))
        

// @LINE:155
private[this] lazy val controllers_contabilidad_PagosAccionesController_descargarArchivoInterbankingProveedores131 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/descargarArchivoInterbankingProveedores"))))
        

// @LINE:157
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPagarProveedoresMacroMasivos132 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPagarProveedoresMacroMasivos"))))
        

// @LINE:158
private[this] lazy val controllers_contabilidad_PagosAccionesController_pagarProveedoresMacroMasivos133 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/pagarProveedoresMacroMasivos"))))
        

// @LINE:159
private[this] lazy val controllers_contabilidad_PagosAccionesController_descargarArchivoProveedoresMacroMasivos134 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/descargarArchivoProveedoresMacroMasivos"))))
        

// @LINE:160
private[this] lazy val controllers_contabilidad_PagosAccionesController_descargarArchivoBnfMacroMasivos135 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/descargarArchivoBnfMacroMasivos"))))
        

// @LINE:163
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPagarPlanta136 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPagarPlanta"))))
        

// @LINE:164
private[this] lazy val controllers_contabilidad_PagosAccionesController_pagarPlanta137 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/pagarPlanta"))))
        

// @LINE:165
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPagarProveedoresExternos138 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPagarProveedoresExternos"))))
        

// @LINE:166
private[this] lazy val controllers_contabilidad_PagosAccionesController_pagarProveedoresExternos139 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPagarProveedoresExternos"))))
        

// @LINE:167
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalDetallePago140 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalDetallePago"))))
        

// @LINE:168
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalDetalleDeudaPorEstadoPorPeriodo141 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalDetalleDeudaPorEstadoPorPeriodo"))))
        

// @LINE:169
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarFechaConciliado142 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarFechaConciliado"))))
        

// @LINE:170
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarFechaConciliado143 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarFechaConciliado"))))
        

// @LINE:171
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarFechaCancelacion144 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarFechaCancelacion"))))
        

// @LINE:172
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarFechaCancelacion145 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarFechaCancelacion"))))
        

// @LINE:173
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarNumeroFactura146 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarNumeroFactura"))))
        

// @LINE:174
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarNumeroFactura147 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarNumeroFactura"))))
        

// @LINE:175
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarNumeroRecibo148 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarNumeroRecibo"))))
        

// @LINE:176
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarNumeroRecibo149 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarNumeroRecibo"))))
        

// @LINE:177
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPagarCheques150 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPagarCheques"))))
        

// @LINE:178
private[this] lazy val controllers_contabilidad_PagosAccionesController_pagarCheques151 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/pagarCheques"))))
        

// @LINE:179
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarNumeroCheque152 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarNumeroCheque"))))
        

// @LINE:180
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarNumeroCheque153 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarNumeroCheque"))))
        

// @LINE:181
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarTipoPago154 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarTipoPago"))))
        

// @LINE:182
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarTipoPago155 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarTipoPago"))))
        

// @LINE:183
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarCuentaPropia156 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarCuentaPropia"))))
        

// @LINE:184
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarCuentaPropia157 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarCuentaPropia"))))
        

// @LINE:185
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalModificarPaguese158 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalModificarPaguese"))))
        

// @LINE:186
private[this] lazy val controllers_contabilidad_PagosAccionesController_modificarPaguese159 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modificarPaguese"))))
        

// @LINE:187
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalCrearRefenciaEmbargos160 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalCrearRefenciaEmbargos"))))
        

// @LINE:188
private[this] lazy val controllers_contabilidad_PagosAccionesController_crearRefenciaEmbargos161 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/crearRefenciaEmbargos"))))
        

// @LINE:190
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPasarConciliado162 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/modalPasarConciliado"))))
        

// @LINE:191
private[this] lazy val controllers_contabilidad_PagosAccionesController_pasarConciliadoMasivo163 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/pasarConciliadoMasivo"))))
        

// @LINE:193
private[this] lazy val controllers_contabilidad_PagosAccionesController_descargarOpg164 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/descargarOPG"))))
        

// @LINE:194
private[this] lazy val controllers_contabilidad_PagosAccionesController_descargarBnf165 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/descargarBNF"))))
        

// @LINE:195
private[this] lazy val controllers_contabilidad_PagosAccionesController_descargarRendiciones166 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/descargarRendiciones"))))
        

// @LINE:196
private[this] lazy val controllers_contabilidad_PagosReportesController_modalInformeMensualRentas167 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reportesPagoProveedor/modalInformeMensualRentas"))))
        

// @LINE:197
private[this] lazy val controllers_contabilidad_PagosReportesController_descargarInformeMensualRentas168 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reportesPagoProveedor/descargarInformeMensualRentas"))))
        

// @LINE:199
private[this] lazy val controllers_contabilidad_PagosAccionesController_descargarOpgEmbargo169 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/descargarOPGEmbargo"))))
        

// @LINE:200
private[this] lazy val controllers_contabilidad_PagosAccionesController_descargarOpgEmbargoExterno170 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accionesPagoProveedor/descargarOPGEmbargoExterno"))))
        

// @LINE:202
private[this] lazy val controllers_contabilidad_PagosLineasController_index171 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago-linea/index"))))
        

// @LINE:203
private[this] lazy val controllers_contabilidad_PagosLineasController_crear172 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago-linea/crear"))))
        

// @LINE:204
private[this] lazy val controllers_contabilidad_PagosLineasController_editar173 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago-linea/editar"))))
        

// @LINE:205
private[this] lazy val controllers_contabilidad_PagosLineasController_guardar174 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago-linea/guardar"))))
        

// @LINE:206
private[this] lazy val controllers_contabilidad_PagosLineasController_actualizar175 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago-linea/actualizar"))))
        

// @LINE:207
private[this] lazy val controllers_contabilidad_PagosLineasController_eliminar176 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago-linea/eliminar"))))
        

// @LINE:209
private[this] lazy val controllers_contabilidad_ConciliacionPagosController_index177 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("conciliacionCheques"))))
        

// @LINE:210
private[this] lazy val controllers_contabilidad_ConciliacionPagosController_conciliarCheques178 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("conciliacionCheques/conciliar-cheques"))))
        

// @LINE:211
private[this] lazy val controllers_contabilidad_ConciliacionPagosController_analisisConciliacionCheques179 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("conciliacionCheques/anilisis-conciliacion-cheques"))))
        

// @LINE:215
private[this] lazy val controllers_contabilidad_SucursalBancosController_listOptions180 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sucursalBanco/listOptions"))))
        

// @LINE:217
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_index181 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas-analiticas"))))
        

// @LINE:218
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_crear182 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas-analiticas/crear"))))
        

// @LINE:219
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_guardar183 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas-analiticas/guardar"))))
        

// @LINE:220
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_editar184 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas-analiticas/editar"))))
        

// @LINE:221
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_actualizar185 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas-analiticas/actualizar"))))
        

// @LINE:222
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_eliminar186 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas-analiticas/eliminar"))))
        

// @LINE:223
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_modalBuscar187 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas-analiticas/modalBuscar"))))
        

// @LINE:224
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_get188 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas-analiticas/get"))))
        

// @LINE:225
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_modalBuscarCuentasAsociadas189 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas-analiticas/modalCuentasAsociadasSolicitud"))))
        

// @LINE:227
private[this] lazy val controllers_contabilidad_CuentasController_index190 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas"))))
        

// @LINE:228
private[this] lazy val controllers_contabilidad_CuentasController_crear191 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas/crear"))))
        

// @LINE:229
private[this] lazy val controllers_contabilidad_CuentasController_guardar192 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas/guardar"))))
        

// @LINE:230
private[this] lazy val controllers_contabilidad_CuentasController_editar193 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas/editar"))))
        

// @LINE:231
private[this] lazy val controllers_contabilidad_CuentasController_actualizar194 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas/actualizar"))))
        

// @LINE:232
private[this] lazy val controllers_contabilidad_CuentasController_eliminar195 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas/eliminar"))))
        

// @LINE:233
private[this] lazy val controllers_contabilidad_CuentasController_modalBuscar196 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas/modalBuscar"))))
        

// @LINE:234
private[this] lazy val controllers_contabilidad_CuentasController_get197 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentas/get"))))
        

// @LINE:235
private[this] lazy val controllers_contabilidad_MisPagosController_index198 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mis-pagos/index"))))
        

// @LINE:236
private[this] lazy val controllers_contabilidad_MisPagosController_ver199 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mis-pagos/ver"))))
        

// @LINE:237
private[this] lazy val controllers_contabilidad_MisPagosController_editar200 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mis-pagos/editar"))))
        

// @LINE:238
private[this] lazy val controllers_contabilidad_MisPagosController_actualizar201 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mis-pagos/actualizar"))))
        

// @LINE:241
private[this] lazy val controllers_contabilidad_PagosReportesController_reporteCheque202 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reporte/cheque"))))
        

// @LINE:242
private[this] lazy val controllers_contabilidad_PagosReportesController_descargarLotes203 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reporteLote"))))
        

// @LINE:243
private[this] lazy val controllers_contabilidad_PagosReportesController_informeImpuestoMunicipal204 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informeImpuestoMunicipal"))))
        

// @LINE:244
private[this] lazy val controllers_contabilidad_PagosReportesController_informeProfe205 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informeprofe"))))
        

// @LINE:246
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPasarCancelado206 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/modalPasarCancelado"))))
        

// @LINE:247
private[this] lazy val controllers_contabilidad_PagosAccionesController_pasarCanceladoMasivo207 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/pasarCanceladoMasivo"))))
        

// @LINE:248
private[this] lazy val controllers_contabilidad_PagosAccionesController_modalPasarBorrador208 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/modalPasarBorrador"))))
        

// @LINE:249
private[this] lazy val controllers_contabilidad_PagosAccionesController_pasarBorradorMasivo209 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/pasarBorradorMasivo"))))
        

// @LINE:250
private[this] lazy val controllers_contabilidad_PagosReportesController_modalInformeMensualImpuestos210 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/modalInformeMensualImpuestos"))))
        

// @LINE:251
private[this] lazy val controllers_contabilidad_PagosReportesController_informeMensualImpuestos211 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/informeMensualImpuestos"))))
        

// @LINE:252
private[this] lazy val controllers_contabilidad_PagosReportesController_descargarLotesPago212 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reporteLotePago"))))
        

// @LINE:254
private[this] lazy val controllers_contabilidad_PagosReportesController_informeRetencionSuss213 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/informeRetencionSuss"))))
        

// @LINE:255
private[this] lazy val controllers_contabilidad_PagosReportesController_informeRetDgrSellos214 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/informeRetencionDgrSellos"))))
        

// @LINE:256
private[this] lazy val controllers_contabilidad_PagosReportesController_informeRetDgrIibb215 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/informeRetDgrIibb"))))
        

// @LINE:257
private[this] lazy val controllers_contabilidad_PagosReportesController_informeRetDgrIibb331216 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/informeRetDgrIibb331"))))
        

// @LINE:258
private[this] lazy val controllers_contabilidad_PagosReportesController_informeRetencionGcia4245217 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/informeRetencionGcia4245"))))
        

// @LINE:259
private[this] lazy val controllers_contabilidad_PagosReportesController_informeRetencionIva218 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/informeRetencionIva"))))
        

// @LINE:261
private[this] lazy val controllers_contabilidad_BancosController_indexBanco219 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("banco"))))
        

// @LINE:262
private[this] lazy val controllers_contabilidad_BancosController_crearBanco220 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("banco/crear"))))
        

// @LINE:263
private[this] lazy val controllers_contabilidad_BancosController_guardarBanco221 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("banco/guardar"))))
        

// @LINE:264
private[this] lazy val controllers_contabilidad_BancosController_editarBanco222 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("banco/editar"))))
        

// @LINE:265
private[this] lazy val controllers_contabilidad_BancosController_eliminarBanco223 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("banco/eliminar"))))
        

// @LINE:266
private[this] lazy val controllers_contabilidad_BancosController_actualizarBanco224 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("banco/actualizar"))))
        

// @LINE:267
private[this] lazy val controllers_contabilidad_BancosController_modalBuscar225 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("banco/modalBuscar"))))
        

// @LINE:268
private[this] lazy val controllers_contabilidad_BancosController_get226 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("banco/get"))))
        

// @LINE:270
private[this] lazy val controllers_contabilidad_EjerciciosController_indexEjercicio227 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ejercicio"))))
        

// @LINE:271
private[this] lazy val controllers_contabilidad_EjerciciosController_crearEjercicio228 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ejercicio/crear"))))
        

// @LINE:272
private[this] lazy val controllers_contabilidad_EjerciciosController_guardarEjercicio229 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ejercicio/guardar"))))
        

// @LINE:273
private[this] lazy val controllers_contabilidad_EjerciciosController_editarEjercicio230 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ejercicio/editar"))))
        

// @LINE:274
private[this] lazy val controllers_contabilidad_EjerciciosController_eliminarEjercicio231 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ejercicio/eliminar"))))
        

// @LINE:275
private[this] lazy val controllers_contabilidad_EjerciciosController_actualizarEjercicio232 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ejercicio/actualizar"))))
        

// @LINE:276
private[this] lazy val controllers_contabilidad_EjerciciosController_modalBuscar233 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ejercicio/modalBuscar"))))
        

// @LINE:277
private[this] lazy val controllers_contabilidad_EjerciciosController_get234 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ejercicio/get"))))
        

// @LINE:279
private[this] lazy val controllers_contabilidad_PeriodosController_indexPeriodo235 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodo"))))
        

// @LINE:280
private[this] lazy val controllers_contabilidad_PeriodosController_crearPeriodo236 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodo/crear"))))
        

// @LINE:281
private[this] lazy val controllers_contabilidad_PeriodosController_guardarPeriodo237 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodo/guardar"))))
        

// @LINE:282
private[this] lazy val controllers_contabilidad_PeriodosController_editarPeriodo238 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodo/editar"))))
        

// @LINE:283
private[this] lazy val controllers_contabilidad_PeriodosController_eliminarPeriodo239 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodo/eliminar"))))
        

// @LINE:284
private[this] lazy val controllers_contabilidad_PeriodosController_actualizarPeriodo240 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodo/actualizar"))))
        

// @LINE:285
private[this] lazy val controllers_contabilidad_PeriodosController_modalBuscar241 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodo/modalBuscar"))))
        

// @LINE:286
private[this] lazy val controllers_contabilidad_PeriodosController_get242 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodo/get"))))
        

// @LINE:288
private[this] lazy val controllers_contabilidad_SucursalBancosController_indexSucursalBanco243 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sucursalBanco"))))
        

// @LINE:289
private[this] lazy val controllers_contabilidad_SucursalBancosController_crearSucursalBanco244 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sucursalBanco/crear"))))
        

// @LINE:290
private[this] lazy val controllers_contabilidad_SucursalBancosController_guardarSucursalBanco245 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sucursalBanco/guardar"))))
        

// @LINE:291
private[this] lazy val controllers_contabilidad_SucursalBancosController_editarSucursalBanco246 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sucursalBanco/editar"))))
        

// @LINE:292
private[this] lazy val controllers_contabilidad_SucursalBancosController_eliminarSucursalBanco247 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sucursalBanco/eliminar"))))
        

// @LINE:293
private[this] lazy val controllers_contabilidad_SucursalBancosController_actualizarSucursalBanco248 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sucursalBanco/actualizar"))))
        

// @LINE:294
private[this] lazy val controllers_contabilidad_SucursalBancosController_modalBuscar249 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sucursalBanco/modalBuscar"))))
        

// @LINE:295
private[this] lazy val controllers_contabilidad_SucursalBancosController_get250 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sucursalBanco/get"))))
        

// @LINE:297
private[this] lazy val controllers_contabilidad_CuentaBancariasController_indexCuentaBancaria251 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria"))))
        

// @LINE:298
private[this] lazy val controllers_contabilidad_CuentaBancariasController_crearCuentaBancaria252 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/crear"))))
        

// @LINE:299
private[this] lazy val controllers_contabilidad_CuentaBancariasController_guardarCuentaBancaria253 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/guardar"))))
        

// @LINE:300
private[this] lazy val controllers_contabilidad_CuentaBancariasController_editarCuentaBancaria254 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/editar"))))
        

// @LINE:301
private[this] lazy val controllers_contabilidad_CuentaBancariasController_eliminarCuentaBancaria255 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/eliminar"))))
        

// @LINE:302
private[this] lazy val controllers_contabilidad_CuentaBancariasController_actualizarCuentaBancaria256 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/actualizar"))))
        

// @LINE:303
private[this] lazy val controllers_contabilidad_CuentaBancariasController_modalBuscar257 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/modalBuscar"))))
        

// @LINE:304
private[this] lazy val controllers_contabilidad_CuentaBancariasController_get258 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/get"))))
        

// @LINE:305
private[this] lazy val controllers_contabilidad_CuentaBancariasController_ver259 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/ver"))))
        

// @LINE:306
private[this] lazy val controllers_contabilidad_CuentaBancariasController_cambiarEstado260 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/cambiarEstado"))))
        

// @LINE:308
private[this] lazy val controllers_contabilidad_CuentaBancariasController_reporteDatosGenerales261 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentaBancaria/reporteDatosGenerales"))))
        

// @LINE:310
private[this] lazy val controllers_contabilidad_CuentasPropiasController_modalBuscar262 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentasPropias/modalBuscar"))))
        

// @LINE:311
private[this] lazy val controllers_contabilidad_CuentasPropiasController_get263 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cuentasPropias/get"))))
        

// @LINE:316
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosController_index264 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito"))))
        

// @LINE:317
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosController_ver265 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/ver"))))
        

// @LINE:318
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosController_cambiarEstado266 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuitoCambiarEstado"))))
        

// @LINE:319
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosController_editar267 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/editar"))))
        

// @LINE:320
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosController_actualizar268 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/actualizar"))))
        

// @LINE:321
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarBorrador269 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/modalPasarBorrador"))))
        

// @LINE:322
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarBorradorMasivo270 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/pasarBorradorMasivo"))))
        

// @LINE:323
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarContabilidad271 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/modalPasarContabilidad"))))
        

// @LINE:324
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarContabilidadMasivo272 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/pasarContabilidadMasivo"))))
        

// @LINE:325
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarRendiciones273 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/modalPasarRendiciones"))))
        

// @LINE:326
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarRendicionesMasivo274 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/pasarRendicionesMasivo"))))
        

// @LINE:327
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarRendido275 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/modalPasarRendido"))))
        

// @LINE:328
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarRendidoMasivo276 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/pasarRendidoMasivo"))))
        

// @LINE:329
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarCancelado277 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/modalPasarCancelado"))))
        

// @LINE:330
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarCanceladoMasivo278 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/pasarCanceladoMasivo"))))
        

// @LINE:332
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalCargarExpedienteFisico279 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/modalCargarExpedienteFisico"))))
        

// @LINE:333
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosAccionesController_cargarExpedienteFisico280 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuito/cargarExpedienteFisico"))))
        

// @LINE:336
private[this] lazy val controllers_contabilidad_OrdenesPagosCircuitosLineasController_index281 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("OrdenPagoCircuitoLinea"))))
        

// @LINE:338
private[this] lazy val controllers_contabilidad_BalanceCuentaPropiaController_index282 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("BalanceCuentaPropia"))))
        

// @LINE:339
private[this] lazy val controllers_contabilidad_BalanceCuentaPropiaController_archivoIndex283 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("BalanceCuentaPropia/archivoIndex"))))
        

// @LINE:340
private[this] lazy val controllers_contabilidad_BalanceCuentaPropiaController_modalAgregarMovimientoBalanceCuentaPropia284 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("BalanceCuentaPropia/modalAgregarMovimientoBalanceCuentaPropia"))))
        

// @LINE:341
private[this] lazy val controllers_contabilidad_BalanceCuentaPropiaController_agregarMovimientoBalanceCuentaPropia285 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("BalanceCuentaPropia/agregarMovimientoBalanceCuentaPropia"))))
        

// @LINE:343
private[this] lazy val controllers_contabilidad_BalanceCuentaPropiaController_modalTransferenciaEntreCuentasPropias286 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("BalanceCuentaPropia/modalTransferenciaEntreCuentasPropias"))))
        

// @LINE:344
private[this] lazy val controllers_contabilidad_BalanceCuentaPropiaController_transferenciaEntreCuentasPropias287 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("BalanceCuentaPropia/transferenciaEntreCuentasPropias"))))
        

// @LINE:345
private[this] lazy val controllers_contabilidad_BalanceCuentaPropiaController_listaPagos288 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("BalanceCuentaPropia/listaPagos"))))
        

// @LINE:347
private[this] lazy val controllers_contabilidad_BalanceCuentaPropiaController_getOrdenes289 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("BalanceCuentaPropia/get-ordenes"))))
        

// @LINE:348
private[this] lazy val controllers_contabilidad_BalanceCuentaPropiaController_getExpedientes290 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("BalanceCuentaPropia/get-expedientes"))))
        

// @LINE:350
private[this] lazy val controllers_contabilidad_BalanceController_index291 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance"))))
        

// @LINE:351
private[this] lazy val controllers_contabilidad_BalanceController_general292 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/general"))))
        

// @LINE:352
private[this] lazy val controllers_contabilidad_BalanceController_modalAgregarMovimientoBalance293 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/modalAgregarMovimientoBalance"))))
        

// @LINE:353
private[this] lazy val controllers_contabilidad_BalanceController_agregarMovimientoBalance294 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/agregarMovimientoBalance"))))
        

// @LINE:355
private[this] lazy val controllers_contabilidad_BalanceController_modalPasarBorrador295 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/modalPasarBorrador"))))
        

// @LINE:356
private[this] lazy val controllers_contabilidad_BalanceController_pasarBorradorMasivo296 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/pasarBorradorMasivo"))))
        

// @LINE:357
private[this] lazy val controllers_contabilidad_BalanceController_modalPasarControlado297 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/modalPasarControlado"))))
        

// @LINE:358
private[this] lazy val controllers_contabilidad_BalanceController_pasarControladoMasivo298 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/pasarControladoMasivo"))))
        

// @LINE:360
private[this] lazy val controllers_contabilidad_BalanceController_modalCambiarCuenta299 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/modalCambiarCuenta"))))
        

// @LINE:361
private[this] lazy val controllers_contabilidad_BalanceController_cambiarCuentaMasivo300 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/cambiarCuentaMasivo"))))
        

// @LINE:363
private[this] lazy val controllers_contabilidad_BalanceController_archivoBejerman301 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/archivoBejerman"))))
        

// @LINE:364
private[this] lazy val controllers_contabilidad_BalanceController_archivoBejermanPagos302 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/archivoBejermanPagos"))))
        

// @LINE:365
private[this] lazy val controllers_contabilidad_BalanceController_archivoExcel303 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Balance/archivoExcel"))))
        

// @LINE:367
private[this] lazy val controllers_contabilidad_BancosController_suggestBanco304 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestBanco/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:368
private[this] lazy val controllers_contabilidad_CuentaBancariasController_suggestCuentaBancaria305 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestCuentaBancaria/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:369
private[this] lazy val controllers_contabilidad_PeriodosController_suggestPeriodo306 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestPeriodo/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:370
private[this] lazy val controllers_contabilidad_OrdenesPagosController_suggestOrdenPago307 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestOrdenPago/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:371
private[this] lazy val controllers_contabilidad_CuentasAnaliticasController_suggestCuentaAnalitica308 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestCuentaAnalitica/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:372
private[this] lazy val controllers_contabilidad_CuentasController_suggestCuenta309 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestCuenta/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:373
private[this] lazy val controllers_contabilidad_EjerciciosController_suggestEjercicio310 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestEjercicio/"),DynamicPart("input", """[^/]+""",true))))
        
def documentation = List(("""GET""", prefix,"""controllers.contabilidad.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesPagos""","""controllers.contabilidad.OrdenesPagosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesPagos/eliminar""","""controllers.contabilidad.OrdenesPagosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesPagos/crear""","""controllers.contabilidad.OrdenesPagosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesPagos/guardar""","""controllers.contabilidad.OrdenesPagosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesPagos/editar""","""controllers.contabilidad.OrdenesPagosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesPagos/actualizar""","""controllers.contabilidad.OrdenesPagosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesPagos/modalBuscar""","""controllers.contabilidad.OrdenesPagosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesPagos/get""","""controllers.contabilidad.OrdenesPagosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor""","""controllers.contabilidad.FacturasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/crear""","""controllers.contabilidad.FacturasController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/guardar""","""controllers.contabilidad.FacturasController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/editar""","""controllers.contabilidad.FacturasController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/eliminar""","""controllers.contabilidad.FacturasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/eliminarFacturaDato""","""controllers.contabilidad.FacturasController.eliminarFacturaDato(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/duplicar""","""controllers.contabilidad.FacturasController.duplicar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/crearFacturaParcial""","""controllers.contabilidad.FacturasController.crearFacturaParcial(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/actas-asociada""","""controllers.contabilidad.FacturasController.actasAsociadas(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/eliminar-actas-asociada""","""controllers.contabilidad.FacturasController.eliminarActaAsociada(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/asignar-actas-asociada""","""controllers.contabilidad.FacturasController.asignarActasAsociada(facturaId:Long, actaId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/seleccionar-actas-asociada""","""controllers.contabilidad.FacturasController.modalSeleccionActaRelacionada(facturaId:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/viatico""","""controllers.contabilidad.FacturasReportesController.viatico()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/actualizar""","""controllers.contabilidad.FacturasController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalBuscar""","""controllers.contabilidad.FacturasController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/get""","""controllers.contabilidad.FacturasController.get(id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/acciones/solicitud322""","""controllers.contabilidad.FacturasAccionesController.solicitud322()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/acciones/descargar322""","""controllers.contabilidad.FacturasAccionesController.descargar322(url:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/OPCservicios""","""controllers.contabilidad.FacturasReportesController.OPCservicios()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/OrdenDePago""","""controllers.contabilidad.FacturasReportesController.ordenDePago()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComprobanteRetencionSellos""","""controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionSellos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComprobanteRetencionMunicipal""","""controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionMunicipal()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComprobanteRetencionGcia""","""controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionGcia()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComprobanteRetencionIva""","""controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionIva()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComisiones""","""controllers.contabilidad.FacturasReportesController.reporteComisiones()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/acciones/modalImportarListaComisiones""","""controllers.contabilidad.FacturasAccionesController.modalImportarListaComisiones()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/acciones/importarListaComisiones""","""controllers.contabilidad.FacturasAccionesController.importarListaComisiones()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/acciones/modalCargar349""","""controllers.contabilidad.FacturasAccionesController.modalCargar349(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/acciones/cargar349""","""controllers.contabilidad.FacturasAccionesController.cargar349()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteRendicionSellos""","""controllers.contabilidad.FacturasReportesController.reporteRendicionSellos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComprobanteRetencionIibb""","""controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencioniibb()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComprobanteRetencionIibb370""","""controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencioniibb370()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComprobanteRetencionSeguridad""","""controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionSeguridad()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComprobanteRetencionLimpieza""","""controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionLimpieza()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/reporteComprobanteRetencionReggral""","""controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionReggral()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/modalInformeMensualSellos""","""controllers.contabilidad.FacturasReportesController.modalInformeSellos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reportes/informeMensualSellos""","""controllers.contabilidad.FacturasReportesController.informeSellos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalPasarEnCurso""","""controllers.contabilidad.FacturasAccionesController.modalPasarEnCurso()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/pasarEnCursoMasivo""","""controllers.contabilidad.FacturasAccionesController.pasarEnPreCursoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalPasarEnPreCurso""","""controllers.contabilidad.FacturasAccionesController.modalPasarEnPreCurso()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/pasarEnPreCursoMasivo""","""controllers.contabilidad.FacturasAccionesController.pasarEnCursoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalPasarAprobado""","""controllers.contabilidad.FacturasAccionesController.modalPasarAprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/pasarAprobadoMasivo""","""controllers.contabilidad.FacturasAccionesController.pasarAprobadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalPasarBorrador""","""controllers.contabilidad.FacturasAccionesController.modalPasarBorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/pasarBorradorMasivo""","""controllers.contabilidad.FacturasAccionesController.pasarBorradorMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalPasarCancelado""","""controllers.contabilidad.FacturasAccionesController.modalPasarCancelado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/pasarCanceladoMasivo""","""controllers.contabilidad.FacturasAccionesController.pasarCanceladoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalPasarPreAprobado""","""controllers.contabilidad.FacturasAccionesController.modalPasarPreAprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/pasarPreAprobadoMasivo""","""controllers.contabilidad.FacturasAccionesController.pasarPreAprobadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalCargarOrdenPago""","""controllers.contabilidad.FacturasAccionesController.modalCargarOrdenPago()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/cargarOrdenPagoMasivo""","""controllers.contabilidad.FacturasAccionesController.cargarOrdenPagoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalCargarFechaOrdenPago""","""controllers.contabilidad.FacturasAccionesController.modalCargarFechaOrdenPago()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/cargarFechaOrdenPagoMasivo""","""controllers.contabilidad.FacturasAccionesController.cargarFechaOrdenPagoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalCargarFecha322""","""controllers.contabilidad.FacturasAccionesController.modalCargarFecha322()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/cargarFecha322Masivo""","""controllers.contabilidad.FacturasAccionesController.cargarFecha322Masivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalRechazarFactura""","""controllers.contabilidad.FacturasAccionesController.modalRechazarFactura()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/rechazar""","""controllers.contabilidad.FacturasAccionesController.rechazar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/ver""","""controllers.contabilidad.FacturasController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/cambiarEstado""","""controllers.contabilidad.FacturasController.cambiarEstado(idFactura:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/cambiarEstadoPrecarga""","""controllers.contabilidad.FacturasController.cambiarEstadoPrecargado(idFactura:Long, idEstado:Long, precarga:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/cambiarEstadoAprobado""","""controllers.contabilidad.FacturasController.cambiarEstadoAprobado(idFactura:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reporteControlFactura""","""controllers.contabilidad.FacturasReportesController.reporteControlFacturas()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reporteControlFacturasAFIP""","""controllers.contabilidad.FacturasReportesController.reporteControlFacturasAFIP()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalDetalleFacturacion""","""controllers.contabilidad.FacturasAccionesController.modalDetalleFacturacion(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/acciones/modalDetalleFacturacionPorEstadoPorPeriodo""","""controllers.contabilidad.FacturasAccionesController.modalDetalleFacturacionPorEstadoPorPeriodo(nombrePeriodo:String, estado:Integer, proveedorId:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalMarcadoresMasivos""","""controllers.contabilidad.FacturasAccionesController.modalMarcadoresMasivos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/marcadoresMasivos""","""controllers.contabilidad.FacturasAccionesController.marcadoresMasivos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reporteLineasFacturas""","""controllers.contabilidad.FacturasReportesController.reporteLineasFacturas()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/reporteFacturasCargadas""","""controllers.contabilidad.FacturasReportesController.reporteFacturasCargadas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalModificarNumeroFactura""","""controllers.contabilidad.FacturasAccionesController.modalModificarNumeroFactura(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modificarNumeroFactura""","""controllers.contabilidad.FacturasAccionesController.modificarNumeroFactura()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/modalCargarNumeroFacturaParcial""","""controllers.contabilidad.FacturasAccionesController.modalCargarNumeroFacturaParcial()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/cargarNumeroFacturaParcial""","""controllers.contabilidad.FacturasAccionesController.cargarNumeroFacturaParcial()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/getInfoRetenciones""","""controllers.contabilidad.FacturasController.getInfoRetenciones(id:Long ?= 0, fci:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturaProveedor/vistaFacturasCargadas""","""controllers.contabilidad.FacturasController.vistaFacturasCargadas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/index""","""controllers.contabilidad.FacturasLineasController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/crear""","""controllers.contabilidad.FacturasLineasController.crear(facturaId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/editar""","""controllers.contabilidad.FacturasLineasController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/guardar""","""controllers.contabilidad.FacturasLineasController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/actualizar""","""controllers.contabilidad.FacturasLineasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/eliminar""","""controllers.contabilidad.FacturasLineasController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/eliminar-masivo""","""controllers.contabilidad.FacturasLineasController.eliminarMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/index""","""controllers.contabilidad.FacturasLineasImpuestosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/crear""","""controllers.contabilidad.FacturasLineasImpuestosController.crear(facturaId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/editar""","""controllers.contabilidad.FacturasLineasImpuestosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/guardar""","""controllers.contabilidad.FacturasLineasImpuestosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/actualizar""","""controllers.contabilidad.FacturasLineasImpuestosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/eliminar""","""controllers.contabilidad.FacturasLineasImpuestosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/getSecuenciaRetencionSellos""","""controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaRetencionSellos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/getSecuenciaGanancias""","""controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaGanancias()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/getSecuenciaIIBB""","""controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaIIBB()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/getSecuenciaIva""","""controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaIva()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/getSecuenciaRetencionMunicipal""","""controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaRetencionMunicipal()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-impuesto/precalcular""","""controllers.contabilidad.FacturasLineasImpuestosController.precalcular(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-reintegro/index""","""controllers.contabilidad.FacturasLineasReintegrosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-reintegro/crear""","""controllers.contabilidad.FacturasLineasReintegrosController.crear(facturaId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-reintegro/editar""","""controllers.contabilidad.FacturasLineasReintegrosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-reintegro/guardar""","""controllers.contabilidad.FacturasLineasReintegrosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-reintegro/actualizar""","""controllers.contabilidad.FacturasLineasReintegrosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea-reintegro/eliminar""","""controllers.contabilidad.FacturasLineasReintegrosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor""","""controllers.contabilidad.PagosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor/duplicar""","""controllers.contabilidad.PagosController.duplicar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor/ver""","""controllers.contabilidad.PagosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor/crear""","""controllers.contabilidad.PagosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor/guardar""","""controllers.contabilidad.PagosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor/editar""","""controllers.contabilidad.PagosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor/eliminar""","""controllers.contabilidad.PagosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor/actualizar""","""controllers.contabilidad.PagosController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor/cambiarEstado""","""controllers.contabilidad.PagosController.cambiarEstado(idPago:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagoProveedor/cambiarEstadoTransferenciaConciliado""","""controllers.contabilidad.PagosController.cambiarEstadoTransferenciaConciliado(idPago:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarFecha""","""controllers.contabilidad.PagosAccionesController.modificarFecha()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarFecha""","""controllers.contabilidad.PagosAccionesController.modalModificarFecha()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarReferencia""","""controllers.contabilidad.PagosAccionesController.modificarReferencia()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarReferencia""","""controllers.contabilidad.PagosAccionesController.modalModificarReferencia()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPagarInterno""","""controllers.contabilidad.PagosAccionesController.modalPagarInterno()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/pagarInterno""","""controllers.contabilidad.PagosAccionesController.pagarInterno()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPagarEmbargos""","""controllers.contabilidad.PagosAccionesController.modalPagarEmbargos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/pagarEmbargos""","""controllers.contabilidad.PagosAccionesController.pagarEmbargos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPagarEmbargosExternos""","""controllers.contabilidad.PagosAccionesController.modalPagarEmbargosExternos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/pagarEmbargosExternos""","""controllers.contabilidad.PagosAccionesController.pagarEmbargosExternos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPagarInterbankingProveedores""","""controllers.contabilidad.PagosAccionesController.modalPagarInterbankingProveedores()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/pagarInterbankingProveedores""","""controllers.contabilidad.PagosAccionesController.pagarInterbankingProveedores()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/descargarArchivoInterbankingProveedores""","""controllers.contabilidad.PagosAccionesController.descargarArchivoInterbankingProveedores(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPagarProveedoresMacroMasivos""","""controllers.contabilidad.PagosAccionesController.modalPagarProveedoresMacroMasivos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/pagarProveedoresMacroMasivos""","""controllers.contabilidad.PagosAccionesController.pagarProveedoresMacroMasivos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/descargarArchivoProveedoresMacroMasivos""","""controllers.contabilidad.PagosAccionesController.descargarArchivoProveedoresMacroMasivos(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/descargarArchivoBnfMacroMasivos""","""controllers.contabilidad.PagosAccionesController.descargarArchivoBnfMacroMasivos(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPagarPlanta""","""controllers.contabilidad.PagosAccionesController.modalPagarPlanta()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/pagarPlanta""","""controllers.contabilidad.PagosAccionesController.pagarPlanta()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPagarProveedoresExternos""","""controllers.contabilidad.PagosAccionesController.modalPagarProveedoresExternos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPagarProveedoresExternos""","""controllers.contabilidad.PagosAccionesController.pagarProveedoresExternos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalDetallePago""","""controllers.contabilidad.PagosAccionesController.modalDetallePago(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalDetalleDeudaPorEstadoPorPeriodo""","""controllers.contabilidad.PagosAccionesController.modalDetalleDeudaPorEstadoPorPeriodo(nombrePeriodo:String, estado:Integer, proveedorId:Integer)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarFechaConciliado""","""controllers.contabilidad.PagosAccionesController.modificarFechaConciliado()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarFechaConciliado""","""controllers.contabilidad.PagosAccionesController.modalModificarFechaConciliado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarFechaCancelacion""","""controllers.contabilidad.PagosAccionesController.modificarFechaCancelacion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarFechaCancelacion""","""controllers.contabilidad.PagosAccionesController.modalModificarFechaCancelacion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarNumeroFactura""","""controllers.contabilidad.PagosAccionesController.modalModificarNumeroFactura(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarNumeroFactura""","""controllers.contabilidad.PagosAccionesController.modificarNumeroFactura()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarNumeroRecibo""","""controllers.contabilidad.PagosAccionesController.modalModificarNumeroRecibo(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarNumeroRecibo""","""controllers.contabilidad.PagosAccionesController.modificarNumeroRecibo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPagarCheques""","""controllers.contabilidad.PagosAccionesController.modalPagarCheques()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/pagarCheques""","""controllers.contabilidad.PagosAccionesController.pagarCheques()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarNumeroCheque""","""controllers.contabilidad.PagosAccionesController.modalModificarNumeroCheque()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarNumeroCheque""","""controllers.contabilidad.PagosAccionesController.modificarNumeroCheque()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarTipoPago""","""controllers.contabilidad.PagosAccionesController.modalModificarTipoPago()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarTipoPago""","""controllers.contabilidad.PagosAccionesController.modificarTipoPago()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarCuentaPropia""","""controllers.contabilidad.PagosAccionesController.modalModificarCuentaPropia()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarCuentaPropia""","""controllers.contabilidad.PagosAccionesController.modificarCuentaPropia()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalModificarPaguese""","""controllers.contabilidad.PagosAccionesController.modalModificarPaguese()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modificarPaguese""","""controllers.contabilidad.PagosAccionesController.modificarPaguese()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalCrearRefenciaEmbargos""","""controllers.contabilidad.PagosAccionesController.modalCrearRefenciaEmbargos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/crearRefenciaEmbargos""","""controllers.contabilidad.PagosAccionesController.crearRefenciaEmbargos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/modalPasarConciliado""","""controllers.contabilidad.PagosAccionesController.modalPasarConciliado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/pasarConciliadoMasivo""","""controllers.contabilidad.PagosAccionesController.pasarConciliadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/descargarOPG""","""controllers.contabilidad.PagosAccionesController.descargarOpg(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/descargarBNF""","""controllers.contabilidad.PagosAccionesController.descargarBnf(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/descargarRendiciones""","""controllers.contabilidad.PagosAccionesController.descargarRendiciones(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reportesPagoProveedor/modalInformeMensualRentas""","""controllers.contabilidad.PagosReportesController.modalInformeMensualRentas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reportesPagoProveedor/descargarInformeMensualRentas""","""controllers.contabilidad.PagosReportesController.descargarInformeMensualRentas(url:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/descargarOPGEmbargo""","""controllers.contabilidad.PagosAccionesController.descargarOpgEmbargo(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accionesPagoProveedor/descargarOPGEmbargoExterno""","""controllers.contabilidad.PagosAccionesController.descargarOpgEmbargoExterno(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago-linea/index""","""controllers.contabilidad.PagosLineasController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago-linea/crear""","""controllers.contabilidad.PagosLineasController.crear(pagoId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago-linea/editar""","""controllers.contabilidad.PagosLineasController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago-linea/guardar""","""controllers.contabilidad.PagosLineasController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago-linea/actualizar""","""controllers.contabilidad.PagosLineasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago-linea/eliminar""","""controllers.contabilidad.PagosLineasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """conciliacionCheques""","""controllers.contabilidad.ConciliacionPagosController.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """conciliacionCheques/conciliar-cheques""","""controllers.contabilidad.ConciliacionPagosController.conciliarCheques()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """conciliacionCheques/anilisis-conciliacion-cheques""","""controllers.contabilidad.ConciliacionPagosController.analisisConciliacionCheques()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sucursalBanco/listOptions""","""controllers.contabilidad.SucursalBancosController.listOptions(bancoId:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas-analiticas""","""controllers.contabilidad.CuentasAnaliticasController.index(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas-analiticas/crear""","""controllers.contabilidad.CuentasAnaliticasController.crear(parent_id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas-analiticas/guardar""","""controllers.contabilidad.CuentasAnaliticasController.guardar(parent_id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas-analiticas/editar""","""controllers.contabilidad.CuentasAnaliticasController.editar(parent_id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas-analiticas/actualizar""","""controllers.contabilidad.CuentasAnaliticasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas-analiticas/eliminar""","""controllers.contabilidad.CuentasAnaliticasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas-analiticas/modalBuscar""","""controllers.contabilidad.CuentasAnaliticasController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas-analiticas/get""","""controllers.contabilidad.CuentasAnaliticasController.get(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas-analiticas/modalCuentasAsociadasSolicitud""","""controllers.contabilidad.CuentasAnaliticasController.modalBuscarCuentasAsociadas(solicitud_id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas""","""controllers.contabilidad.CuentasController.index(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas/crear""","""controllers.contabilidad.CuentasController.crear(parent_id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas/guardar""","""controllers.contabilidad.CuentasController.guardar(parent_id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas/editar""","""controllers.contabilidad.CuentasController.editar(parent_id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas/actualizar""","""controllers.contabilidad.CuentasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas/eliminar""","""controllers.contabilidad.CuentasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas/modalBuscar""","""controllers.contabilidad.CuentasController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentas/get""","""controllers.contabilidad.CuentasController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mis-pagos/index""","""controllers.contabilidad.MisPagosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mis-pagos/ver""","""controllers.contabilidad.MisPagosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mis-pagos/editar""","""controllers.contabilidad.MisPagosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mis-pagos/actualizar""","""controllers.contabilidad.MisPagosController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reporte/cheque""","""controllers.contabilidad.PagosReportesController.reporteCheque(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reporteLote""","""controllers.contabilidad.PagosReportesController.descargarLotes()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informeImpuestoMunicipal""","""controllers.contabilidad.PagosReportesController.informeImpuestoMunicipal()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informeprofe""","""controllers.contabilidad.PagosReportesController.informeProfe()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/modalPasarCancelado""","""controllers.contabilidad.PagosAccionesController.modalPasarCancelado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/pasarCanceladoMasivo""","""controllers.contabilidad.PagosAccionesController.pasarCanceladoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/modalPasarBorrador""","""controllers.contabilidad.PagosAccionesController.modalPasarBorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/pasarBorradorMasivo""","""controllers.contabilidad.PagosAccionesController.pasarBorradorMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/modalInformeMensualImpuestos""","""controllers.contabilidad.PagosReportesController.modalInformeMensualImpuestos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/informeMensualImpuestos""","""controllers.contabilidad.PagosReportesController.informeMensualImpuestos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reporteLotePago""","""controllers.contabilidad.PagosReportesController.descargarLotesPago(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/informeRetencionSuss""","""controllers.contabilidad.PagosReportesController.informeRetencionSuss(regimen:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/informeRetencionDgrSellos""","""controllers.contabilidad.PagosReportesController.informeRetDgrSellos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/informeRetDgrIibb""","""controllers.contabilidad.PagosReportesController.informeRetDgrIibb()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/informeRetDgrIibb331""","""controllers.contabilidad.PagosReportesController.informeRetDgrIibb331()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/informeRetencionGcia4245""","""controllers.contabilidad.PagosReportesController.informeRetencionGcia4245()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/informeRetencionIva""","""controllers.contabilidad.PagosReportesController.informeRetencionIva()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """banco""","""controllers.contabilidad.BancosController.indexBanco()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """banco/crear""","""controllers.contabilidad.BancosController.crearBanco()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """banco/guardar""","""controllers.contabilidad.BancosController.guardarBanco()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """banco/editar""","""controllers.contabilidad.BancosController.editarBanco(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """banco/eliminar""","""controllers.contabilidad.BancosController.eliminarBanco(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """banco/actualizar""","""controllers.contabilidad.BancosController.actualizarBanco()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """banco/modalBuscar""","""controllers.contabilidad.BancosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """banco/get""","""controllers.contabilidad.BancosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ejercicio""","""controllers.contabilidad.EjerciciosController.indexEjercicio()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ejercicio/crear""","""controllers.contabilidad.EjerciciosController.crearEjercicio()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ejercicio/guardar""","""controllers.contabilidad.EjerciciosController.guardarEjercicio()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ejercicio/editar""","""controllers.contabilidad.EjerciciosController.editarEjercicio(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ejercicio/eliminar""","""controllers.contabilidad.EjerciciosController.eliminarEjercicio(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ejercicio/actualizar""","""controllers.contabilidad.EjerciciosController.actualizarEjercicio()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ejercicio/modalBuscar""","""controllers.contabilidad.EjerciciosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ejercicio/get""","""controllers.contabilidad.EjerciciosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodo""","""controllers.contabilidad.PeriodosController.indexPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodo/crear""","""controllers.contabilidad.PeriodosController.crearPeriodo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodo/guardar""","""controllers.contabilidad.PeriodosController.guardarPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodo/editar""","""controllers.contabilidad.PeriodosController.editarPeriodo(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodo/eliminar""","""controllers.contabilidad.PeriodosController.eliminarPeriodo(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodo/actualizar""","""controllers.contabilidad.PeriodosController.actualizarPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodo/modalBuscar""","""controllers.contabilidad.PeriodosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodo/get""","""controllers.contabilidad.PeriodosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sucursalBanco""","""controllers.contabilidad.SucursalBancosController.indexSucursalBanco()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sucursalBanco/crear""","""controllers.contabilidad.SucursalBancosController.crearSucursalBanco()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sucursalBanco/guardar""","""controllers.contabilidad.SucursalBancosController.guardarSucursalBanco()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sucursalBanco/editar""","""controllers.contabilidad.SucursalBancosController.editarSucursalBanco(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sucursalBanco/eliminar""","""controllers.contabilidad.SucursalBancosController.eliminarSucursalBanco(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sucursalBanco/actualizar""","""controllers.contabilidad.SucursalBancosController.actualizarSucursalBanco()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sucursalBanco/modalBuscar""","""controllers.contabilidad.SucursalBancosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sucursalBanco/get""","""controllers.contabilidad.SucursalBancosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria""","""controllers.contabilidad.CuentaBancariasController.indexCuentaBancaria()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/crear""","""controllers.contabilidad.CuentaBancariasController.crearCuentaBancaria()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/guardar""","""controllers.contabilidad.CuentaBancariasController.guardarCuentaBancaria()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/editar""","""controllers.contabilidad.CuentaBancariasController.editarCuentaBancaria(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/eliminar""","""controllers.contabilidad.CuentaBancariasController.eliminarCuentaBancaria(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/actualizar""","""controllers.contabilidad.CuentaBancariasController.actualizarCuentaBancaria()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/modalBuscar""","""controllers.contabilidad.CuentaBancariasController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/get""","""controllers.contabilidad.CuentaBancariasController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/ver""","""controllers.contabilidad.CuentaBancariasController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/cambiarEstado""","""controllers.contabilidad.CuentaBancariasController.cambiarEstado(idCuenta:Long, idEstado:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentaBancaria/reporteDatosGenerales""","""controllers.contabilidad.CuentaBancariasController.reporteDatosGenerales()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentasPropias/modalBuscar""","""controllers.contabilidad.CuentasPropiasController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cuentasPropias/get""","""controllers.contabilidad.CuentasPropiasController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito""","""controllers.contabilidad.OrdenesPagosCircuitosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/ver""","""controllers.contabilidad.OrdenesPagosCircuitosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuitoCambiarEstado""","""controllers.contabilidad.OrdenesPagosCircuitosController.cambiarEstado(idOc:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/editar""","""controllers.contabilidad.OrdenesPagosCircuitosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/actualizar""","""controllers.contabilidad.OrdenesPagosCircuitosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/modalPasarBorrador""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarBorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/pasarBorradorMasivo""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarBorradorMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/modalPasarContabilidad""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarContabilidad()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/pasarContabilidadMasivo""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarContabilidadMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/modalPasarRendiciones""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarRendiciones()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/pasarRendicionesMasivo""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarRendicionesMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/modalPasarRendido""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarRendido()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/pasarRendidoMasivo""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarRendidoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/modalPasarCancelado""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarCancelado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/pasarCanceladoMasivo""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarCanceladoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/modalCargarExpedienteFisico""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalCargarExpedienteFisico()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuito/cargarExpedienteFisico""","""controllers.contabilidad.OrdenesPagosCircuitosAccionesController.cargarExpedienteFisico()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """OrdenPagoCircuitoLinea""","""controllers.contabilidad.OrdenesPagosCircuitosLineasController.index(orden_pago_circuito_id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """BalanceCuentaPropia""","""controllers.contabilidad.BalanceCuentaPropiaController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """BalanceCuentaPropia/archivoIndex""","""controllers.contabilidad.BalanceCuentaPropiaController.archivoIndex()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """BalanceCuentaPropia/modalAgregarMovimientoBalanceCuentaPropia""","""controllers.contabilidad.BalanceCuentaPropiaController.modalAgregarMovimientoBalanceCuentaPropia()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """BalanceCuentaPropia/agregarMovimientoBalanceCuentaPropia""","""controllers.contabilidad.BalanceCuentaPropiaController.agregarMovimientoBalanceCuentaPropia()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """BalanceCuentaPropia/modalTransferenciaEntreCuentasPropias""","""controllers.contabilidad.BalanceCuentaPropiaController.modalTransferenciaEntreCuentasPropias()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """BalanceCuentaPropia/transferenciaEntreCuentasPropias""","""controllers.contabilidad.BalanceCuentaPropiaController.transferenciaEntreCuentasPropias()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """BalanceCuentaPropia/listaPagos""","""controllers.contabilidad.BalanceCuentaPropiaController.listaPagos(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """BalanceCuentaPropia/get-ordenes""","""controllers.contabilidad.BalanceCuentaPropiaController.getOrdenes(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """BalanceCuentaPropia/get-expedientes""","""controllers.contabilidad.BalanceCuentaPropiaController.getExpedientes(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance""","""controllers.contabilidad.BalanceController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/general""","""controllers.contabilidad.BalanceController.general()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/modalAgregarMovimientoBalance""","""controllers.contabilidad.BalanceController.modalAgregarMovimientoBalance()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/agregarMovimientoBalance""","""controllers.contabilidad.BalanceController.agregarMovimientoBalance()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/modalPasarBorrador""","""controllers.contabilidad.BalanceController.modalPasarBorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/pasarBorradorMasivo""","""controllers.contabilidad.BalanceController.pasarBorradorMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/modalPasarControlado""","""controllers.contabilidad.BalanceController.modalPasarControlado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/pasarControladoMasivo""","""controllers.contabilidad.BalanceController.pasarControladoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/modalCambiarCuenta""","""controllers.contabilidad.BalanceController.modalCambiarCuenta()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/cambiarCuentaMasivo""","""controllers.contabilidad.BalanceController.cambiarCuentaMasivo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/archivoBejerman""","""controllers.contabilidad.BalanceController.archivoBejerman()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/archivoBejermanPagos""","""controllers.contabilidad.BalanceController.archivoBejermanPagos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Balance/archivoExcel""","""controllers.contabilidad.BalanceController.archivoExcel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestBanco/$input<[^/]+>""","""controllers.contabilidad.BancosController.suggestBanco(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestCuentaBancaria/$input<[^/]+>""","""controllers.contabilidad.CuentaBancariasController.suggestCuentaBancaria(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestPeriodo/$input<[^/]+>""","""controllers.contabilidad.PeriodosController.suggestPeriodo(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestOrdenPago/$input<[^/]+>""","""controllers.contabilidad.OrdenesPagosController.suggestOrdenPago(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestCuentaAnalitica/$input<[^/]+>""","""controllers.contabilidad.CuentasAnaliticasController.suggestCuentaAnalitica(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestCuenta/$input<[^/]+>""","""controllers.contabilidad.CuentasController.suggestCuenta(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestEjercicio/$input<[^/]+>""","""controllers.contabilidad.EjerciciosController.suggestEjercicio(input:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:1
case controllers_contabilidad_IndexController_index0(params) => {
   call { 
        invokeHandler(controllers.contabilidad.IndexController.index(), HandlerDef(this, "controllers.contabilidad.IndexController", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:2
case controllers_contabilidad_OrdenesPagosController_index1(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosController.index(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "index", Nil,"GET", """""", Routes.prefix + """ordenesPagos"""))
   }
}
        

// @LINE:3
case controllers_contabilidad_OrdenesPagosController_eliminar2(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.OrdenesPagosController.eliminar(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesPagos/eliminar"""))
   }
}
        

// @LINE:4
case controllers_contabilidad_OrdenesPagosController_crear3(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosController.crear(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "crear", Nil,"GET", """""", Routes.prefix + """ordenesPagos/crear"""))
   }
}
        

// @LINE:5
case controllers_contabilidad_OrdenesPagosController_guardar4(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosController.guardar(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "guardar", Nil,"POST", """""", Routes.prefix + """ordenesPagos/guardar"""))
   }
}
        

// @LINE:6
case controllers_contabilidad_OrdenesPagosController_editar5(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.OrdenesPagosController.editar(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesPagos/editar"""))
   }
}
        

// @LINE:7
case controllers_contabilidad_OrdenesPagosController_actualizar6(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosController.actualizar(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "actualizar", Nil,"POST", """""", Routes.prefix + """ordenesPagos/actualizar"""))
   }
}
        

// @LINE:8
case controllers_contabilidad_OrdenesPagosController_modalBuscar7(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """ordenesPagos/modalBuscar"""))
   }
}
        

// @LINE:9
case controllers_contabilidad_OrdenesPagosController_get8(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.OrdenesPagosController.get(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """ordenesPagos/get"""))
   }
}
        

// @LINE:11
case controllers_contabilidad_FacturasController_index9(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasController.index(), HandlerDef(this, "controllers.contabilidad.FacturasController", "index", Nil,"GET", """""", Routes.prefix + """facturaProveedor"""))
   }
}
        

// @LINE:12
case controllers_contabilidad_FacturasController_crear10(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasController.crear(), HandlerDef(this, "controllers.contabilidad.FacturasController", "crear", Nil,"GET", """""", Routes.prefix + """facturaProveedor/crear"""))
   }
}
        

// @LINE:13
case controllers_contabilidad_FacturasController_guardar11(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasController.guardar(), HandlerDef(this, "controllers.contabilidad.FacturasController", "guardar", Nil,"POST", """""", Routes.prefix + """facturaProveedor/guardar"""))
   }
}
        

// @LINE:14
case controllers_contabilidad_FacturasController_editar12(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.editar(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/editar"""))
   }
}
        

// @LINE:15
case controllers_contabilidad_FacturasController_eliminar13(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/eliminar"""))
   }
}
        

// @LINE:16
case controllers_contabilidad_FacturasController_eliminarFacturaDato14(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.eliminarFacturaDato(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "eliminarFacturaDato", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/eliminarFacturaDato"""))
   }
}
        

// @LINE:17
case controllers_contabilidad_FacturasController_duplicar15(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.duplicar(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "duplicar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/duplicar"""))
   }
}
        

// @LINE:18
case controllers_contabilidad_FacturasController_crearFacturaParcial16(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.crearFacturaParcial(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "crearFacturaParcial", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/crearFacturaParcial"""))
   }
}
        

// @LINE:19
case controllers_contabilidad_FacturasController_actasAsociadas17(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.actasAsociadas(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "actasAsociadas", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/actas-asociada"""))
   }
}
        

// @LINE:20
case controllers_contabilidad_FacturasController_eliminarActaAsociada18(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.eliminarActaAsociada(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "eliminarActaAsociada", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/eliminar-actas-asociada"""))
   }
}
        

// @LINE:22
case controllers_contabilidad_FacturasController_asignarActasAsociada19(params) => {
   call(params.fromQuery[Long]("facturaId", None), params.fromQuery[Long]("actaId", None)) { (facturaId, actaId) =>
        invokeHandler(controllers.contabilidad.FacturasController.asignarActasAsociada(facturaId, actaId), HandlerDef(this, "controllers.contabilidad.FacturasController", "asignarActasAsociada", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/asignar-actas-asociada"""))
   }
}
        

// @LINE:23
case controllers_contabilidad_FacturasController_modalSeleccionActaRelacionada20(params) => {
   call(params.fromQuery[Long]("facturaId", None)) { (facturaId) =>
        invokeHandler(controllers.contabilidad.FacturasController.modalSeleccionActaRelacionada(facturaId), HandlerDef(this, "controllers.contabilidad.FacturasController", "modalSeleccionActaRelacionada", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/seleccionar-actas-asociada"""))
   }
}
        

// @LINE:27
case controllers_contabilidad_FacturasReportesController_viatico21(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.viatico(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "viatico", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/viatico"""))
   }
}
        

// @LINE:28
case controllers_contabilidad_FacturasController_actualizar22(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.actualizar(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """facturaProveedor/actualizar"""))
   }
}
        

// @LINE:29
case controllers_contabilidad_FacturasController_modalBuscar23(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.FacturasController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalBuscar"""))
   }
}
        

// @LINE:30
case controllers_contabilidad_FacturasController_get24(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.get(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/get"""))
   }
}
        

// @LINE:31
case controllers_contabilidad_FacturasAccionesController_solicitud32225(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.solicitud322(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "solicitud322", Nil,"POST", """""", Routes.prefix + """facturaProveedor/acciones/solicitud322"""))
   }
}
        

// @LINE:32
case controllers_contabilidad_FacturasAccionesController_descargar32226(params) => {
   call(params.fromQuery[String]("url", None)) { (url) =>
        invokeHandler(controllers.contabilidad.FacturasAccionesController.descargar322(url), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "descargar322", Seq(classOf[String]),"GET", """""", Routes.prefix + """facturaProveedor/acciones/descargar322"""))
   }
}
        

// @LINE:33
case controllers_contabilidad_FacturasReportesController_OPCservicios27(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.OPCservicios(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "OPCservicios", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/OPCservicios"""))
   }
}
        

// @LINE:34
case controllers_contabilidad_FacturasReportesController_ordenDePago28(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.ordenDePago(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "ordenDePago", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/OrdenDePago"""))
   }
}
        

// @LINE:35
case controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionSellos29(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionSellos(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionSellos", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComprobanteRetencionSellos"""))
   }
}
        

// @LINE:36
case controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionMunicipal30(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionMunicipal(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionMunicipal", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComprobanteRetencionMunicipal"""))
   }
}
        

// @LINE:37
case controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionGcia31(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionGcia(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionGcia", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComprobanteRetencionGcia"""))
   }
}
        

// @LINE:38
case controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionIva32(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionIva(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionIva", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComprobanteRetencionIva"""))
   }
}
        

// @LINE:39
case controllers_contabilidad_FacturasReportesController_reporteComisiones33(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComisiones(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComisiones", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComisiones"""))
   }
}
        

// @LINE:41
case controllers_contabilidad_FacturasAccionesController_modalImportarListaComisiones34(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalImportarListaComisiones(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalImportarListaComisiones", Nil,"POST", """""", Routes.prefix + """facturaProveedor/acciones/modalImportarListaComisiones"""))
   }
}
        

// @LINE:42
case controllers_contabilidad_FacturasAccionesController_importarListaComisiones35(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.importarListaComisiones(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "importarListaComisiones", Nil,"POST", """""", Routes.prefix + """facturaProveedor/acciones/importarListaComisiones"""))
   }
}
        

// @LINE:44
case controllers_contabilidad_FacturasAccionesController_modalCargar34936(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalCargar349(id), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargar349", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/acciones/modalCargar349"""))
   }
}
        

// @LINE:45
case controllers_contabilidad_FacturasAccionesController_cargar34937(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.cargar349(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargar349", Nil,"POST", """""", Routes.prefix + """facturaProveedor/acciones/cargar349"""))
   }
}
        

// @LINE:47
case controllers_contabilidad_FacturasReportesController_reporteRendicionSellos38(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteRendicionSellos(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteRendicionSellos", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteRendicionSellos"""))
   }
}
        

// @LINE:48
case controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencioniibb39(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencioniibb(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencioniibb", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComprobanteRetencionIibb"""))
   }
}
        

// @LINE:49
case controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencioniibb37040(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencioniibb370(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencioniibb370", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComprobanteRetencionIibb370"""))
   }
}
        

// @LINE:50
case controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionSeguridad41(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionSeguridad(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionSeguridad", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComprobanteRetencionSeguridad"""))
   }
}
        

// @LINE:51
case controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionLimpieza42(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionLimpieza(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionLimpieza", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComprobanteRetencionLimpieza"""))
   }
}
        

// @LINE:52
case controllers_contabilidad_FacturasReportesController_reporteComprobanteRetencionReggral43(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionReggral(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionReggral", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/reporteComprobanteRetencionReggral"""))
   }
}
        

// @LINE:53
case controllers_contabilidad_FacturasReportesController_modalInformeSellos44(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.modalInformeSellos(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "modalInformeSellos", Nil,"GET", """""", Routes.prefix + """facturaProveedor/reportes/modalInformeMensualSellos"""))
   }
}
        

// @LINE:54
case controllers_contabilidad_FacturasReportesController_informeSellos45(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.informeSellos(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "informeSellos", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reportes/informeMensualSellos"""))
   }
}
        

// @LINE:56
case controllers_contabilidad_FacturasAccionesController_modalPasarEnCurso46(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalPasarEnCurso(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarEnCurso", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalPasarEnCurso"""))
   }
}
        

// @LINE:57
case controllers_contabilidad_FacturasAccionesController_pasarEnPreCursoMasivo47(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.pasarEnPreCursoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarEnPreCursoMasivo", Nil,"POST", """""", Routes.prefix + """facturaProveedor/pasarEnCursoMasivo"""))
   }
}
        

// @LINE:58
case controllers_contabilidad_FacturasAccionesController_modalPasarEnPreCurso48(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalPasarEnPreCurso(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarEnPreCurso", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalPasarEnPreCurso"""))
   }
}
        

// @LINE:59
case controllers_contabilidad_FacturasAccionesController_pasarEnCursoMasivo49(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.pasarEnCursoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarEnCursoMasivo", Nil,"POST", """""", Routes.prefix + """facturaProveedor/pasarEnPreCursoMasivo"""))
   }
}
        

// @LINE:60
case controllers_contabilidad_FacturasAccionesController_modalPasarAprobado50(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalPasarAprobado(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarAprobado", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalPasarAprobado"""))
   }
}
        

// @LINE:61
case controllers_contabilidad_FacturasAccionesController_pasarAprobadoMasivo51(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.pasarAprobadoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarAprobadoMasivo", Nil,"POST", """""", Routes.prefix + """facturaProveedor/pasarAprobadoMasivo"""))
   }
}
        

// @LINE:62
case controllers_contabilidad_FacturasAccionesController_modalPasarBorrador52(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarBorrador", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalPasarBorrador"""))
   }
}
        

// @LINE:63
case controllers_contabilidad_FacturasAccionesController_pasarBorradorMasivo53(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarBorradorMasivo", Nil,"POST", """""", Routes.prefix + """facturaProveedor/pasarBorradorMasivo"""))
   }
}
        

// @LINE:64
case controllers_contabilidad_FacturasAccionesController_modalPasarCancelado54(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarCancelado", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalPasarCancelado"""))
   }
}
        

// @LINE:65
case controllers_contabilidad_FacturasAccionesController_pasarCanceladoMasivo55(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarCanceladoMasivo", Nil,"POST", """""", Routes.prefix + """facturaProveedor/pasarCanceladoMasivo"""))
   }
}
        

// @LINE:66
case controllers_contabilidad_FacturasAccionesController_modalPasarPreAprobado56(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalPasarPreAprobado(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarPreAprobado", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalPasarPreAprobado"""))
   }
}
        

// @LINE:67
case controllers_contabilidad_FacturasAccionesController_pasarPreAprobadoMasivo57(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.pasarPreAprobadoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarPreAprobadoMasivo", Nil,"POST", """""", Routes.prefix + """facturaProveedor/pasarPreAprobadoMasivo"""))
   }
}
        

// @LINE:68
case controllers_contabilidad_FacturasAccionesController_modalCargarOrdenPago58(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalCargarOrdenPago(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargarOrdenPago", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalCargarOrdenPago"""))
   }
}
        

// @LINE:69
case controllers_contabilidad_FacturasAccionesController_cargarOrdenPagoMasivo59(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.cargarOrdenPagoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargarOrdenPagoMasivo", Nil,"POST", """""", Routes.prefix + """facturaProveedor/cargarOrdenPagoMasivo"""))
   }
}
        

// @LINE:70
case controllers_contabilidad_FacturasAccionesController_modalCargarFechaOrdenPago60(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalCargarFechaOrdenPago(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargarFechaOrdenPago", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalCargarFechaOrdenPago"""))
   }
}
        

// @LINE:71
case controllers_contabilidad_FacturasAccionesController_cargarFechaOrdenPagoMasivo61(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.cargarFechaOrdenPagoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargarFechaOrdenPagoMasivo", Nil,"POST", """""", Routes.prefix + """facturaProveedor/cargarFechaOrdenPagoMasivo"""))
   }
}
        

// @LINE:72
case controllers_contabilidad_FacturasAccionesController_modalCargarFecha32262(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalCargarFecha322(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargarFecha322", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalCargarFecha322"""))
   }
}
        

// @LINE:73
case controllers_contabilidad_FacturasAccionesController_cargarFecha322Masivo63(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.cargarFecha322Masivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargarFecha322Masivo", Nil,"POST", """""", Routes.prefix + """facturaProveedor/cargarFecha322Masivo"""))
   }
}
        

// @LINE:74
case controllers_contabilidad_FacturasAccionesController_modalRechazarFactura64(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalRechazarFactura(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalRechazarFactura", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalRechazarFactura"""))
   }
}
        

// @LINE:75
case controllers_contabilidad_FacturasAccionesController_rechazar65(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.rechazar(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "rechazar", Nil,"POST", """""", Routes.prefix + """facturaProveedor/rechazar"""))
   }
}
        

// @LINE:76
case controllers_contabilidad_FacturasController_ver66(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasController.ver(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/ver"""))
   }
}
        

// @LINE:78
case controllers_contabilidad_FacturasController_cambiarEstado67(params) => {
   call(params.fromQuery[Long]("idFactura", None), params.fromQuery[Long]("idEstado", None)) { (idFactura, idEstado) =>
        invokeHandler(controllers.contabilidad.FacturasController.cambiarEstado(idFactura, idEstado), HandlerDef(this, "controllers.contabilidad.FacturasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/cambiarEstado"""))
   }
}
        

// @LINE:79
case controllers_contabilidad_FacturasController_cambiarEstadoPrecargado68(params) => {
   call(params.fromQuery[Long]("idFactura", None), params.fromQuery[Long]("idEstado", None), params.fromQuery[Boolean]("precarga", Some(false))) { (idFactura, idEstado, precarga) =>
        invokeHandler(controllers.contabilidad.FacturasController.cambiarEstadoPrecargado(idFactura, idEstado, precarga), HandlerDef(this, "controllers.contabilidad.FacturasController", "cambiarEstadoPrecargado", Seq(classOf[Long], classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """facturaProveedor/cambiarEstadoPrecarga"""))
   }
}
        

// @LINE:81
case controllers_contabilidad_FacturasController_cambiarEstadoAprobado69(params) => {
   call(params.fromQuery[Long]("idFactura", None)) { (idFactura) =>
        invokeHandler(controllers.contabilidad.FacturasController.cambiarEstadoAprobado(idFactura), HandlerDef(this, "controllers.contabilidad.FacturasController", "cambiarEstadoAprobado", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/cambiarEstadoAprobado"""))
   }
}
        

// @LINE:82
case controllers_contabilidad_FacturasReportesController_reporteControlFacturas70(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteControlFacturas(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteControlFacturas", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reporteControlFactura"""))
   }
}
        

// @LINE:83
case controllers_contabilidad_FacturasReportesController_reporteControlFacturasAFIP71(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteControlFacturasAFIP(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteControlFacturasAFIP", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reporteControlFacturasAFIP"""))
   }
}
        

// @LINE:84
case controllers_contabilidad_FacturasAccionesController_modalDetalleFacturacion72(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalDetalleFacturacion(id), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalDetalleFacturacion", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/modalDetalleFacturacion"""))
   }
}
        

// @LINE:85
case controllers_contabilidad_FacturasAccionesController_modalDetalleFacturacionPorEstadoPorPeriodo73(params) => {
   call(params.fromQuery[String]("nombrePeriodo", None), params.fromQuery[Integer]("estado", None), params.fromQuery[Integer]("proveedorId", None)) { (nombrePeriodo, estado, proveedorId) =>
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalDetalleFacturacionPorEstadoPorPeriodo(nombrePeriodo, estado, proveedorId), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalDetalleFacturacionPorEstadoPorPeriodo", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """facturaProveedor/acciones/modalDetalleFacturacionPorEstadoPorPeriodo"""))
   }
}
        

// @LINE:86
case controllers_contabilidad_FacturasAccionesController_modalMarcadoresMasivos74(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalMarcadoresMasivos(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalMarcadoresMasivos", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalMarcadoresMasivos"""))
   }
}
        

// @LINE:87
case controllers_contabilidad_FacturasAccionesController_marcadoresMasivos75(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.marcadoresMasivos(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "marcadoresMasivos", Nil,"POST", """""", Routes.prefix + """facturaProveedor/marcadoresMasivos"""))
   }
}
        

// @LINE:88
case controllers_contabilidad_FacturasReportesController_reporteLineasFacturas76(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteLineasFacturas(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteLineasFacturas", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reporteLineasFacturas"""))
   }
}
        

// @LINE:90
case controllers_contabilidad_FacturasReportesController_reporteFacturasCargadas77(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasReportesController.reporteFacturasCargadas(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteFacturasCargadas", Nil,"POST", """""", Routes.prefix + """facturaProveedor/reporteFacturasCargadas"""))
   }
}
        

// @LINE:92
case controllers_contabilidad_FacturasAccionesController_modalModificarNumeroFactura78(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalModificarNumeroFactura(id), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalModificarNumeroFactura", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturaProveedor/modalModificarNumeroFactura"""))
   }
}
        

// @LINE:93
case controllers_contabilidad_FacturasAccionesController_modificarNumeroFactura79(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modificarNumeroFactura(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modificarNumeroFactura", Nil,"POST", """""", Routes.prefix + """facturaProveedor/modificarNumeroFactura"""))
   }
}
        

// @LINE:95
case controllers_contabilidad_FacturasAccionesController_modalCargarNumeroFacturaParcial80(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.modalCargarNumeroFacturaParcial(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargarNumeroFacturaParcial", Nil,"GET", """""", Routes.prefix + """facturaProveedor/modalCargarNumeroFacturaParcial"""))
   }
}
        

// @LINE:96
case controllers_contabilidad_FacturasAccionesController_cargarNumeroFacturaParcial81(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasAccionesController.cargarNumeroFacturaParcial(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargarNumeroFacturaParcial", Nil,"POST", """""", Routes.prefix + """facturaProveedor/cargarNumeroFacturaParcial"""))
   }
}
        

// @LINE:98
case controllers_contabilidad_FacturasController_getInfoRetenciones82(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("fci", Some(false))) { (id, fci) =>
        invokeHandler(controllers.contabilidad.FacturasController.getInfoRetenciones(id, fci), HandlerDef(this, "controllers.contabilidad.FacturasController", "getInfoRetenciones", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """facturaProveedor/getInfoRetenciones"""))
   }
}
        

// @LINE:100
case controllers_contabilidad_FacturasController_vistaFacturasCargadas83(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasController.vistaFacturasCargadas(), HandlerDef(this, "controllers.contabilidad.FacturasController", "vistaFacturasCargadas", Nil,"GET", """""", Routes.prefix + """facturaProveedor/vistaFacturasCargadas"""))
   }
}
        

// @LINE:102
case controllers_contabilidad_FacturasLineasController_index84(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.contabilidad.FacturasLineasController.index(id, editable), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """factura-linea/index"""))
   }
}
        

// @LINE:103
case controllers_contabilidad_FacturasLineasController_crear85(params) => {
   call(params.fromQuery[String]("facturaId", None)) { (facturaId) =>
        invokeHandler(controllers.contabilidad.FacturasLineasController.crear(facturaId), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """factura-linea/crear"""))
   }
}
        

// @LINE:104
case controllers_contabilidad_FacturasLineasController_editar86(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasLineasController.editar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura-linea/editar"""))
   }
}
        

// @LINE:105
case controllers_contabilidad_FacturasLineasController_guardar87(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasController.guardar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "guardar", Nil,"POST", """""", Routes.prefix + """factura-linea/guardar"""))
   }
}
        

// @LINE:106
case controllers_contabilidad_FacturasLineasController_actualizar88(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasController.actualizar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "actualizar", Nil,"POST", """""", Routes.prefix + """factura-linea/actualizar"""))
   }
}
        

// @LINE:107
case controllers_contabilidad_FacturasLineasController_eliminar89(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasLineasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura-linea/eliminar"""))
   }
}
        

// @LINE:108
case controllers_contabilidad_FacturasLineasController_eliminarMasivo90(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasController.eliminarMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "eliminarMasivo", Nil,"POST", """""", Routes.prefix + """factura-linea/eliminar-masivo"""))
   }
}
        

// @LINE:110
case controllers_contabilidad_FacturasLineasImpuestosController_index91(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.index(id, editable), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """factura-linea-impuesto/index"""))
   }
}
        

// @LINE:111
case controllers_contabilidad_FacturasLineasImpuestosController_crear92(params) => {
   call(params.fromQuery[String]("facturaId", None)) { (facturaId) =>
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.crear(facturaId), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """factura-linea-impuesto/crear"""))
   }
}
        

// @LINE:112
case controllers_contabilidad_FacturasLineasImpuestosController_editar93(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.editar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura-linea-impuesto/editar"""))
   }
}
        

// @LINE:113
case controllers_contabilidad_FacturasLineasImpuestosController_guardar94(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.guardar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "guardar", Nil,"POST", """""", Routes.prefix + """factura-linea-impuesto/guardar"""))
   }
}
        

// @LINE:114
case controllers_contabilidad_FacturasLineasImpuestosController_actualizar95(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.actualizar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "actualizar", Nil,"POST", """""", Routes.prefix + """factura-linea-impuesto/actualizar"""))
   }
}
        

// @LINE:115
case controllers_contabilidad_FacturasLineasImpuestosController_eliminar96(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.eliminar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura-linea-impuesto/eliminar"""))
   }
}
        

// @LINE:116
case controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaRetencionSellos97(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaRetencionSellos(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaRetencionSellos", Nil,"POST", """""", Routes.prefix + """factura-linea-impuesto/getSecuenciaRetencionSellos"""))
   }
}
        

// @LINE:117
case controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaGanancias98(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaGanancias(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaGanancias", Nil,"POST", """""", Routes.prefix + """factura-linea-impuesto/getSecuenciaGanancias"""))
   }
}
        

// @LINE:118
case controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaIIBB99(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaIIBB(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaIIBB", Nil,"POST", """""", Routes.prefix + """factura-linea-impuesto/getSecuenciaIIBB"""))
   }
}
        

// @LINE:119
case controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaIva100(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaIva(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaIva", Nil,"POST", """""", Routes.prefix + """factura-linea-impuesto/getSecuenciaIva"""))
   }
}
        

// @LINE:120
case controllers_contabilidad_FacturasLineasImpuestosController_getSecuenciaRetencionMunicipal101(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaRetencionMunicipal(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaRetencionMunicipal", Nil,"POST", """""", Routes.prefix + """factura-linea-impuesto/getSecuenciaRetencionMunicipal"""))
   }
}
        

// @LINE:121
case controllers_contabilidad_FacturasLineasImpuestosController_precalcular102(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasLineasImpuestosController.precalcular(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "precalcular", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura-linea-impuesto/precalcular"""))
   }
}
        

// @LINE:123
case controllers_contabilidad_FacturasLineasReintegrosController_index103(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.contabilidad.FacturasLineasReintegrosController.index(id, editable), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """factura-linea-reintegro/index"""))
   }
}
        

// @LINE:124
case controllers_contabilidad_FacturasLineasReintegrosController_crear104(params) => {
   call(params.fromQuery[String]("facturaId", None)) { (facturaId) =>
        invokeHandler(controllers.contabilidad.FacturasLineasReintegrosController.crear(facturaId), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """factura-linea-reintegro/crear"""))
   }
}
        

// @LINE:125
case controllers_contabilidad_FacturasLineasReintegrosController_editar105(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasLineasReintegrosController.editar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura-linea-reintegro/editar"""))
   }
}
        

// @LINE:126
case controllers_contabilidad_FacturasLineasReintegrosController_guardar106(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasReintegrosController.guardar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "guardar", Nil,"POST", """""", Routes.prefix + """factura-linea-reintegro/guardar"""))
   }
}
        

// @LINE:127
case controllers_contabilidad_FacturasLineasReintegrosController_actualizar107(params) => {
   call { 
        invokeHandler(controllers.contabilidad.FacturasLineasReintegrosController.actualizar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "actualizar", Nil,"POST", """""", Routes.prefix + """factura-linea-reintegro/actualizar"""))
   }
}
        

// @LINE:128
case controllers_contabilidad_FacturasLineasReintegrosController_eliminar108(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.FacturasLineasReintegrosController.eliminar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura-linea-reintegro/eliminar"""))
   }
}
        

// @LINE:130
case controllers_contabilidad_PagosController_index109(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosController.index(), HandlerDef(this, "controllers.contabilidad.PagosController", "index", Nil,"GET", """""", Routes.prefix + """pagoProveedor"""))
   }
}
        

// @LINE:131
case controllers_contabilidad_PagosController_duplicar110(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosController.duplicar(id), HandlerDef(this, "controllers.contabilidad.PagosController", "duplicar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pagoProveedor/duplicar"""))
   }
}
        

// @LINE:132
case controllers_contabilidad_PagosController_ver111(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosController.ver(id), HandlerDef(this, "controllers.contabilidad.PagosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pagoProveedor/ver"""))
   }
}
        

// @LINE:133
case controllers_contabilidad_PagosController_crear112(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosController.crear(), HandlerDef(this, "controllers.contabilidad.PagosController", "crear", Nil,"GET", """""", Routes.prefix + """pagoProveedor/crear"""))
   }
}
        

// @LINE:134
case controllers_contabilidad_PagosController_guardar113(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosController.guardar(), HandlerDef(this, "controllers.contabilidad.PagosController", "guardar", Nil,"POST", """""", Routes.prefix + """pagoProveedor/guardar"""))
   }
}
        

// @LINE:135
case controllers_contabilidad_PagosController_editar114(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosController.editar(id), HandlerDef(this, "controllers.contabilidad.PagosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pagoProveedor/editar"""))
   }
}
        

// @LINE:136
case controllers_contabilidad_PagosController_eliminar115(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosController.eliminar(id), HandlerDef(this, "controllers.contabilidad.PagosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pagoProveedor/eliminar"""))
   }
}
        

// @LINE:137
case controllers_contabilidad_PagosController_actualizar116(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosController.actualizar(id), HandlerDef(this, "controllers.contabilidad.PagosController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """pagoProveedor/actualizar"""))
   }
}
        

// @LINE:138
case controllers_contabilidad_PagosController_cambiarEstado117(params) => {
   call(params.fromQuery[Long]("idPago", None), params.fromQuery[Long]("idEstado", None)) { (idPago, idEstado) =>
        invokeHandler(controllers.contabilidad.PagosController.cambiarEstado(idPago, idEstado), HandlerDef(this, "controllers.contabilidad.PagosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """pagoProveedor/cambiarEstado"""))
   }
}
        

// @LINE:139
case controllers_contabilidad_PagosController_cambiarEstadoTransferenciaConciliado118(params) => {
   call(params.fromQuery[Long]("idPago", None)) { (idPago) =>
        invokeHandler(controllers.contabilidad.PagosController.cambiarEstadoTransferenciaConciliado(idPago), HandlerDef(this, "controllers.contabilidad.PagosController", "cambiarEstadoTransferenciaConciliado", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pagoProveedor/cambiarEstadoTransferenciaConciliado"""))
   }
}
        

// @LINE:141
case controllers_contabilidad_PagosAccionesController_modificarFecha119(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarFecha(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarFecha", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarFecha"""))
   }
}
        

// @LINE:142
case controllers_contabilidad_PagosAccionesController_modalModificarFecha120(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarFecha(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarFecha", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarFecha"""))
   }
}
        

// @LINE:143
case controllers_contabilidad_PagosAccionesController_modificarReferencia121(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarReferencia(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarReferencia", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarReferencia"""))
   }
}
        

// @LINE:144
case controllers_contabilidad_PagosAccionesController_modalModificarReferencia122(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarReferencia(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarReferencia", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarReferencia"""))
   }
}
        

// @LINE:145
case controllers_contabilidad_PagosAccionesController_modalPagarInterno123(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPagarInterno(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarInterno", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalPagarInterno"""))
   }
}
        

// @LINE:146
case controllers_contabilidad_PagosAccionesController_pagarInterno124(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pagarInterno(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarInterno", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/pagarInterno"""))
   }
}
        

// @LINE:147
case controllers_contabilidad_PagosAccionesController_modalPagarEmbargos125(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPagarEmbargos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarEmbargos", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalPagarEmbargos"""))
   }
}
        

// @LINE:148
case controllers_contabilidad_PagosAccionesController_pagarEmbargos126(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pagarEmbargos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarEmbargos", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/pagarEmbargos"""))
   }
}
        

// @LINE:149
case controllers_contabilidad_PagosAccionesController_modalPagarEmbargosExternos127(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPagarEmbargosExternos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarEmbargosExternos", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalPagarEmbargosExternos"""))
   }
}
        

// @LINE:150
case controllers_contabilidad_PagosAccionesController_pagarEmbargosExternos128(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pagarEmbargosExternos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarEmbargosExternos", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/pagarEmbargosExternos"""))
   }
}
        

// @LINE:153
case controllers_contabilidad_PagosAccionesController_modalPagarInterbankingProveedores129(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPagarInterbankingProveedores(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarInterbankingProveedores", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalPagarInterbankingProveedores"""))
   }
}
        

// @LINE:154
case controllers_contabilidad_PagosAccionesController_pagarInterbankingProveedores130(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pagarInterbankingProveedores(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarInterbankingProveedores", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/pagarInterbankingProveedores"""))
   }
}
        

// @LINE:155
case controllers_contabilidad_PagosAccionesController_descargarArchivoInterbankingProveedores131(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.descargarArchivoInterbankingProveedores(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarArchivoInterbankingProveedores", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/descargarArchivoInterbankingProveedores"""))
   }
}
        

// @LINE:157
case controllers_contabilidad_PagosAccionesController_modalPagarProveedoresMacroMasivos132(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPagarProveedoresMacroMasivos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarProveedoresMacroMasivos", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalPagarProveedoresMacroMasivos"""))
   }
}
        

// @LINE:158
case controllers_contabilidad_PagosAccionesController_pagarProveedoresMacroMasivos133(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pagarProveedoresMacroMasivos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarProveedoresMacroMasivos", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/pagarProveedoresMacroMasivos"""))
   }
}
        

// @LINE:159
case controllers_contabilidad_PagosAccionesController_descargarArchivoProveedoresMacroMasivos134(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.descargarArchivoProveedoresMacroMasivos(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarArchivoProveedoresMacroMasivos", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/descargarArchivoProveedoresMacroMasivos"""))
   }
}
        

// @LINE:160
case controllers_contabilidad_PagosAccionesController_descargarArchivoBnfMacroMasivos135(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.descargarArchivoBnfMacroMasivos(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarArchivoBnfMacroMasivos", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/descargarArchivoBnfMacroMasivos"""))
   }
}
        

// @LINE:163
case controllers_contabilidad_PagosAccionesController_modalPagarPlanta136(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPagarPlanta(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarPlanta", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalPagarPlanta"""))
   }
}
        

// @LINE:164
case controllers_contabilidad_PagosAccionesController_pagarPlanta137(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pagarPlanta(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarPlanta", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/pagarPlanta"""))
   }
}
        

// @LINE:165
case controllers_contabilidad_PagosAccionesController_modalPagarProveedoresExternos138(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPagarProveedoresExternos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarProveedoresExternos", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalPagarProveedoresExternos"""))
   }
}
        

// @LINE:166
case controllers_contabilidad_PagosAccionesController_pagarProveedoresExternos139(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pagarProveedoresExternos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarProveedoresExternos", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modalPagarProveedoresExternos"""))
   }
}
        

// @LINE:167
case controllers_contabilidad_PagosAccionesController_modalDetallePago140(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalDetallePago(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalDetallePago", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/modalDetallePago"""))
   }
}
        

// @LINE:168
case controllers_contabilidad_PagosAccionesController_modalDetalleDeudaPorEstadoPorPeriodo141(params) => {
   call(params.fromQuery[String]("nombrePeriodo", None), params.fromQuery[Integer]("estado", None), params.fromQuery[Integer]("proveedorId", None)) { (nombrePeriodo, estado, proveedorId) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalDetalleDeudaPorEstadoPorPeriodo(nombrePeriodo, estado, proveedorId), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalDetalleDeudaPorEstadoPorPeriodo", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """accionesPagoProveedor/modalDetalleDeudaPorEstadoPorPeriodo"""))
   }
}
        

// @LINE:169
case controllers_contabilidad_PagosAccionesController_modificarFechaConciliado142(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarFechaConciliado(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarFechaConciliado", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarFechaConciliado"""))
   }
}
        

// @LINE:170
case controllers_contabilidad_PagosAccionesController_modalModificarFechaConciliado143(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarFechaConciliado(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarFechaConciliado", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarFechaConciliado"""))
   }
}
        

// @LINE:171
case controllers_contabilidad_PagosAccionesController_modificarFechaCancelacion144(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarFechaCancelacion(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarFechaCancelacion", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarFechaCancelacion"""))
   }
}
        

// @LINE:172
case controllers_contabilidad_PagosAccionesController_modalModificarFechaCancelacion145(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarFechaCancelacion(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarFechaCancelacion", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarFechaCancelacion"""))
   }
}
        

// @LINE:173
case controllers_contabilidad_PagosAccionesController_modalModificarNumeroFactura146(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarNumeroFactura(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarNumeroFactura", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarNumeroFactura"""))
   }
}
        

// @LINE:174
case controllers_contabilidad_PagosAccionesController_modificarNumeroFactura147(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarNumeroFactura(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarNumeroFactura", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarNumeroFactura"""))
   }
}
        

// @LINE:175
case controllers_contabilidad_PagosAccionesController_modalModificarNumeroRecibo148(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarNumeroRecibo(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarNumeroRecibo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarNumeroRecibo"""))
   }
}
        

// @LINE:176
case controllers_contabilidad_PagosAccionesController_modificarNumeroRecibo149(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarNumeroRecibo(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarNumeroRecibo", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarNumeroRecibo"""))
   }
}
        

// @LINE:177
case controllers_contabilidad_PagosAccionesController_modalPagarCheques150(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPagarCheques(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarCheques", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalPagarCheques"""))
   }
}
        

// @LINE:178
case controllers_contabilidad_PagosAccionesController_pagarCheques151(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pagarCheques(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarCheques", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/pagarCheques"""))
   }
}
        

// @LINE:179
case controllers_contabilidad_PagosAccionesController_modalModificarNumeroCheque152(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarNumeroCheque(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarNumeroCheque", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarNumeroCheque"""))
   }
}
        

// @LINE:180
case controllers_contabilidad_PagosAccionesController_modificarNumeroCheque153(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarNumeroCheque(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarNumeroCheque", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarNumeroCheque"""))
   }
}
        

// @LINE:181
case controllers_contabilidad_PagosAccionesController_modalModificarTipoPago154(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarTipoPago(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarTipoPago", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarTipoPago"""))
   }
}
        

// @LINE:182
case controllers_contabilidad_PagosAccionesController_modificarTipoPago155(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarTipoPago(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarTipoPago", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarTipoPago"""))
   }
}
        

// @LINE:183
case controllers_contabilidad_PagosAccionesController_modalModificarCuentaPropia156(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarCuentaPropia(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarCuentaPropia", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarCuentaPropia"""))
   }
}
        

// @LINE:184
case controllers_contabilidad_PagosAccionesController_modificarCuentaPropia157(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarCuentaPropia(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarCuentaPropia", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarCuentaPropia"""))
   }
}
        

// @LINE:185
case controllers_contabilidad_PagosAccionesController_modalModificarPaguese158(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalModificarPaguese(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarPaguese", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalModificarPaguese"""))
   }
}
        

// @LINE:186
case controllers_contabilidad_PagosAccionesController_modificarPaguese159(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modificarPaguese(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarPaguese", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/modificarPaguese"""))
   }
}
        

// @LINE:187
case controllers_contabilidad_PagosAccionesController_modalCrearRefenciaEmbargos160(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalCrearRefenciaEmbargos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalCrearRefenciaEmbargos", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalCrearRefenciaEmbargos"""))
   }
}
        

// @LINE:188
case controllers_contabilidad_PagosAccionesController_crearRefenciaEmbargos161(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.crearRefenciaEmbargos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "crearRefenciaEmbargos", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/crearRefenciaEmbargos"""))
   }
}
        

// @LINE:190
case controllers_contabilidad_PagosAccionesController_modalPasarConciliado162(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPasarConciliado(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPasarConciliado", Nil,"GET", """""", Routes.prefix + """accionesPagoProveedor/modalPasarConciliado"""))
   }
}
        

// @LINE:191
case controllers_contabilidad_PagosAccionesController_pasarConciliadoMasivo163(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pasarConciliadoMasivo(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pasarConciliadoMasivo", Nil,"POST", """""", Routes.prefix + """accionesPagoProveedor/pasarConciliadoMasivo"""))
   }
}
        

// @LINE:193
case controllers_contabilidad_PagosAccionesController_descargarOpg164(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.descargarOpg(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarOpg", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/descargarOPG"""))
   }
}
        

// @LINE:194
case controllers_contabilidad_PagosAccionesController_descargarBnf165(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.descargarBnf(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarBnf", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/descargarBNF"""))
   }
}
        

// @LINE:195
case controllers_contabilidad_PagosAccionesController_descargarRendiciones166(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.descargarRendiciones(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarRendiciones", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/descargarRendiciones"""))
   }
}
        

// @LINE:196
case controllers_contabilidad_PagosReportesController_modalInformeMensualRentas167(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.modalInformeMensualRentas(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "modalInformeMensualRentas", Nil,"POST", """""", Routes.prefix + """reportesPagoProveedor/modalInformeMensualRentas"""))
   }
}
        

// @LINE:197
case controllers_contabilidad_PagosReportesController_descargarInformeMensualRentas168(params) => {
   call(params.fromQuery[String]("url", None)) { (url) =>
        invokeHandler(controllers.contabilidad.PagosReportesController.descargarInformeMensualRentas(url), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "descargarInformeMensualRentas", Seq(classOf[String]),"GET", """""", Routes.prefix + """reportesPagoProveedor/descargarInformeMensualRentas"""))
   }
}
        

// @LINE:199
case controllers_contabilidad_PagosAccionesController_descargarOpgEmbargo169(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.descargarOpgEmbargo(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarOpgEmbargo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/descargarOPGEmbargo"""))
   }
}
        

// @LINE:200
case controllers_contabilidad_PagosAccionesController_descargarOpgEmbargoExterno170(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosAccionesController.descargarOpgEmbargoExterno(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarOpgEmbargoExterno", Seq(classOf[Long]),"GET", """""", Routes.prefix + """accionesPagoProveedor/descargarOPGEmbargoExterno"""))
   }
}
        

// @LINE:202
case controllers_contabilidad_PagosLineasController_index171(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.contabilidad.PagosLineasController.index(id, editable), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """pago-linea/index"""))
   }
}
        

// @LINE:203
case controllers_contabilidad_PagosLineasController_crear172(params) => {
   call(params.fromQuery[String]("pagoId", None)) { (pagoId) =>
        invokeHandler(controllers.contabilidad.PagosLineasController.crear(pagoId), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """pago-linea/crear"""))
   }
}
        

// @LINE:204
case controllers_contabilidad_PagosLineasController_editar173(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosLineasController.editar(id), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pago-linea/editar"""))
   }
}
        

// @LINE:205
case controllers_contabilidad_PagosLineasController_guardar174(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosLineasController.guardar(), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "guardar", Nil,"POST", """""", Routes.prefix + """pago-linea/guardar"""))
   }
}
        

// @LINE:206
case controllers_contabilidad_PagosLineasController_actualizar175(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosLineasController.actualizar(), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "actualizar", Nil,"POST", """""", Routes.prefix + """pago-linea/actualizar"""))
   }
}
        

// @LINE:207
case controllers_contabilidad_PagosLineasController_eliminar176(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosLineasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pago-linea/eliminar"""))
   }
}
        

// @LINE:209
case controllers_contabilidad_ConciliacionPagosController_index177(params) => {
   call { 
        invokeHandler(controllers.contabilidad.ConciliacionPagosController.index(), HandlerDef(this, "controllers.contabilidad.ConciliacionPagosController", "index", Nil,"GET", """""", Routes.prefix + """conciliacionCheques"""))
   }
}
        

// @LINE:210
case controllers_contabilidad_ConciliacionPagosController_conciliarCheques178(params) => {
   call { 
        invokeHandler(controllers.contabilidad.ConciliacionPagosController.conciliarCheques(), HandlerDef(this, "controllers.contabilidad.ConciliacionPagosController", "conciliarCheques", Nil,"POST", """""", Routes.prefix + """conciliacionCheques/conciliar-cheques"""))
   }
}
        

// @LINE:211
case controllers_contabilidad_ConciliacionPagosController_analisisConciliacionCheques179(params) => {
   call { 
        invokeHandler(controllers.contabilidad.ConciliacionPagosController.analisisConciliacionCheques(), HandlerDef(this, "controllers.contabilidad.ConciliacionPagosController", "analisisConciliacionCheques", Nil,"POST", """""", Routes.prefix + """conciliacionCheques/anilisis-conciliacion-cheques"""))
   }
}
        

// @LINE:215
case controllers_contabilidad_SucursalBancosController_listOptions180(params) => {
   call(params.fromQuery[Int]("bancoId", Some(0))) { (bancoId) =>
        invokeHandler(controllers.contabilidad.SucursalBancosController.listOptions(bancoId), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "listOptions", Seq(classOf[Int]),"GET", """""", Routes.prefix + """sucursalBanco/listOptions"""))
   }
}
        

// @LINE:217
case controllers_contabilidad_CuentasAnaliticasController_index181(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.index(id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "index", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas-analiticas"""))
   }
}
        

// @LINE:218
case controllers_contabilidad_CuentasAnaliticasController_crear182(params) => {
   call(params.fromQuery[Long]("parent_id", Some(0))) { (parent_id) =>
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.crear(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "crear", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas-analiticas/crear"""))
   }
}
        

// @LINE:219
case controllers_contabilidad_CuentasAnaliticasController_guardar183(params) => {
   call(params.fromQuery[Long]("parent_id", Some(0))) { (parent_id) =>
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.guardar(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "guardar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """cuentas-analiticas/guardar"""))
   }
}
        

// @LINE:220
case controllers_contabilidad_CuentasAnaliticasController_editar184(params) => {
   call(params.fromQuery[Long]("parent_id", Some(0))) { (parent_id) =>
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.editar(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas-analiticas/editar"""))
   }
}
        

// @LINE:221
case controllers_contabilidad_CuentasAnaliticasController_actualizar185(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.actualizar(), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "actualizar", Nil,"POST", """""", Routes.prefix + """cuentas-analiticas/actualizar"""))
   }
}
        

// @LINE:222
case controllers_contabilidad_CuentasAnaliticasController_eliminar186(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas-analiticas/eliminar"""))
   }
}
        

// @LINE:223
case controllers_contabilidad_CuentasAnaliticasController_modalBuscar187(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """cuentas-analiticas/modalBuscar"""))
   }
}
        

// @LINE:224
case controllers_contabilidad_CuentasAnaliticasController_get188(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.get(id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas-analiticas/get"""))
   }
}
        

// @LINE:225
case controllers_contabilidad_CuentasAnaliticasController_modalBuscarCuentasAsociadas189(params) => {
   call(params.fromQuery[Long]("solicitud_id", Some(0))) { (solicitud_id) =>
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.modalBuscarCuentasAsociadas(solicitud_id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "modalBuscarCuentasAsociadas", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas-analiticas/modalCuentasAsociadasSolicitud"""))
   }
}
        

// @LINE:227
case controllers_contabilidad_CuentasController_index190(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.CuentasController.index(id), HandlerDef(this, "controllers.contabilidad.CuentasController", "index", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas"""))
   }
}
        

// @LINE:228
case controllers_contabilidad_CuentasController_crear191(params) => {
   call(params.fromQuery[Long]("parent_id", Some(0))) { (parent_id) =>
        invokeHandler(controllers.contabilidad.CuentasController.crear(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasController", "crear", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas/crear"""))
   }
}
        

// @LINE:229
case controllers_contabilidad_CuentasController_guardar192(params) => {
   call(params.fromQuery[Long]("parent_id", Some(0))) { (parent_id) =>
        invokeHandler(controllers.contabilidad.CuentasController.guardar(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasController", "guardar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """cuentas/guardar"""))
   }
}
        

// @LINE:230
case controllers_contabilidad_CuentasController_editar193(params) => {
   call(params.fromQuery[Long]("parent_id", Some(0))) { (parent_id) =>
        invokeHandler(controllers.contabilidad.CuentasController.editar(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas/editar"""))
   }
}
        

// @LINE:231
case controllers_contabilidad_CuentasController_actualizar194(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentasController.actualizar(), HandlerDef(this, "controllers.contabilidad.CuentasController", "actualizar", Nil,"POST", """""", Routes.prefix + """cuentas/actualizar"""))
   }
}
        

// @LINE:232
case controllers_contabilidad_CuentasController_eliminar195(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.CuentasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.CuentasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentas/eliminar"""))
   }
}
        

// @LINE:233
case controllers_contabilidad_CuentasController_modalBuscar196(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.CuentasController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """cuentas/modalBuscar"""))
   }
}
        

// @LINE:234
case controllers_contabilidad_CuentasController_get197(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.CuentasController.get(id), HandlerDef(this, "controllers.contabilidad.CuentasController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """cuentas/get"""))
   }
}
        

// @LINE:235
case controllers_contabilidad_MisPagosController_index198(params) => {
   call { 
        invokeHandler(controllers.contabilidad.MisPagosController.index(), HandlerDef(this, "controllers.contabilidad.MisPagosController", "index", Nil,"GET", """""", Routes.prefix + """mis-pagos/index"""))
   }
}
        

// @LINE:236
case controllers_contabilidad_MisPagosController_ver199(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.MisPagosController.ver(id), HandlerDef(this, "controllers.contabilidad.MisPagosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """mis-pagos/ver"""))
   }
}
        

// @LINE:237
case controllers_contabilidad_MisPagosController_editar200(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.MisPagosController.editar(id), HandlerDef(this, "controllers.contabilidad.MisPagosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """mis-pagos/editar"""))
   }
}
        

// @LINE:238
case controllers_contabilidad_MisPagosController_actualizar201(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.MisPagosController.actualizar(id), HandlerDef(this, "controllers.contabilidad.MisPagosController", "actualizar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """mis-pagos/actualizar"""))
   }
}
        

// @LINE:241
case controllers_contabilidad_PagosReportesController_reporteCheque202(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosReportesController.reporteCheque(id), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "reporteCheque", Seq(classOf[Long]),"GET", """""", Routes.prefix + """reporte/cheque"""))
   }
}
        

// @LINE:242
case controllers_contabilidad_PagosReportesController_descargarLotes203(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.descargarLotes(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "descargarLotes", Nil,"POST", """""", Routes.prefix + """reporteLote"""))
   }
}
        

// @LINE:243
case controllers_contabilidad_PagosReportesController_informeImpuestoMunicipal204(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.informeImpuestoMunicipal(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeImpuestoMunicipal", Nil,"POST", """""", Routes.prefix + """informeImpuestoMunicipal"""))
   }
}
        

// @LINE:244
case controllers_contabilidad_PagosReportesController_informeProfe205(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.informeProfe(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeProfe", Nil,"POST", """""", Routes.prefix + """informeprofe"""))
   }
}
        

// @LINE:246
case controllers_contabilidad_PagosAccionesController_modalPasarCancelado206(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPasarCancelado", Nil,"GET", """""", Routes.prefix + """pagos/modalPasarCancelado"""))
   }
}
        

// @LINE:247
case controllers_contabilidad_PagosAccionesController_pasarCanceladoMasivo207(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pasarCanceladoMasivo", Nil,"POST", """""", Routes.prefix + """pagos/pasarCanceladoMasivo"""))
   }
}
        

// @LINE:248
case controllers_contabilidad_PagosAccionesController_modalPasarBorrador208(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPasarBorrador", Nil,"GET", """""", Routes.prefix + """pagos/modalPasarBorrador"""))
   }
}
        

// @LINE:249
case controllers_contabilidad_PagosAccionesController_pasarBorradorMasivo209(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pasarBorradorMasivo", Nil,"POST", """""", Routes.prefix + """pagos/pasarBorradorMasivo"""))
   }
}
        

// @LINE:250
case controllers_contabilidad_PagosReportesController_modalInformeMensualImpuestos210(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.modalInformeMensualImpuestos(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "modalInformeMensualImpuestos", Nil,"GET", """""", Routes.prefix + """pagos/modalInformeMensualImpuestos"""))
   }
}
        

// @LINE:251
case controllers_contabilidad_PagosReportesController_informeMensualImpuestos211(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.informeMensualImpuestos(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeMensualImpuestos", Nil,"POST", """""", Routes.prefix + """pagos/informeMensualImpuestos"""))
   }
}
        

// @LINE:252
case controllers_contabilidad_PagosReportesController_descargarLotesPago212(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PagosReportesController.descargarLotesPago(id), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "descargarLotesPago", Seq(classOf[Long]),"GET", """""", Routes.prefix + """reporteLotePago"""))
   }
}
        

// @LINE:254
case controllers_contabilidad_PagosReportesController_informeRetencionSuss213(params) => {
   call(params.fromQuery[String]("regimen", None)) { (regimen) =>
        invokeHandler(controllers.contabilidad.PagosReportesController.informeRetencionSuss(regimen), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetencionSuss", Seq(classOf[String]),"POST", """""", Routes.prefix + """pagos/informeRetencionSuss"""))
   }
}
        

// @LINE:255
case controllers_contabilidad_PagosReportesController_informeRetDgrSellos214(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.informeRetDgrSellos(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetDgrSellos", Nil,"POST", """""", Routes.prefix + """pagos/informeRetencionDgrSellos"""))
   }
}
        

// @LINE:256
case controllers_contabilidad_PagosReportesController_informeRetDgrIibb215(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.informeRetDgrIibb(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetDgrIibb", Nil,"POST", """""", Routes.prefix + """pagos/informeRetDgrIibb"""))
   }
}
        

// @LINE:257
case controllers_contabilidad_PagosReportesController_informeRetDgrIibb331216(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.informeRetDgrIibb331(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetDgrIibb331", Nil,"POST", """""", Routes.prefix + """pagos/informeRetDgrIibb331"""))
   }
}
        

// @LINE:258
case controllers_contabilidad_PagosReportesController_informeRetencionGcia4245217(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.informeRetencionGcia4245(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetencionGcia4245", Nil,"POST", """""", Routes.prefix + """pagos/informeRetencionGcia4245"""))
   }
}
        

// @LINE:259
case controllers_contabilidad_PagosReportesController_informeRetencionIva218(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PagosReportesController.informeRetencionIva(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetencionIva", Nil,"POST", """""", Routes.prefix + """pagos/informeRetencionIva"""))
   }
}
        

// @LINE:261
case controllers_contabilidad_BancosController_indexBanco219(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BancosController.indexBanco(), HandlerDef(this, "controllers.contabilidad.BancosController", "indexBanco", Nil,"GET", """""", Routes.prefix + """banco"""))
   }
}
        

// @LINE:262
case controllers_contabilidad_BancosController_crearBanco220(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BancosController.crearBanco(), HandlerDef(this, "controllers.contabilidad.BancosController", "crearBanco", Nil,"GET", """""", Routes.prefix + """banco/crear"""))
   }
}
        

// @LINE:263
case controllers_contabilidad_BancosController_guardarBanco221(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BancosController.guardarBanco(), HandlerDef(this, "controllers.contabilidad.BancosController", "guardarBanco", Nil,"POST", """""", Routes.prefix + """banco/guardar"""))
   }
}
        

// @LINE:264
case controllers_contabilidad_BancosController_editarBanco222(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.BancosController.editarBanco(id), HandlerDef(this, "controllers.contabilidad.BancosController", "editarBanco", Seq(classOf[Long]),"GET", """""", Routes.prefix + """banco/editar"""))
   }
}
        

// @LINE:265
case controllers_contabilidad_BancosController_eliminarBanco223(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.BancosController.eliminarBanco(id), HandlerDef(this, "controllers.contabilidad.BancosController", "eliminarBanco", Seq(classOf[Long]),"GET", """""", Routes.prefix + """banco/eliminar"""))
   }
}
        

// @LINE:266
case controllers_contabilidad_BancosController_actualizarBanco224(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BancosController.actualizarBanco(), HandlerDef(this, "controllers.contabilidad.BancosController", "actualizarBanco", Nil,"POST", """""", Routes.prefix + """banco/actualizar"""))
   }
}
        

// @LINE:267
case controllers_contabilidad_BancosController_modalBuscar225(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BancosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.BancosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """banco/modalBuscar"""))
   }
}
        

// @LINE:268
case controllers_contabilidad_BancosController_get226(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.BancosController.get(id), HandlerDef(this, "controllers.contabilidad.BancosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """banco/get"""))
   }
}
        

// @LINE:270
case controllers_contabilidad_EjerciciosController_indexEjercicio227(params) => {
   call { 
        invokeHandler(controllers.contabilidad.EjerciciosController.indexEjercicio(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "indexEjercicio", Nil,"GET", """""", Routes.prefix + """ejercicio"""))
   }
}
        

// @LINE:271
case controllers_contabilidad_EjerciciosController_crearEjercicio228(params) => {
   call { 
        invokeHandler(controllers.contabilidad.EjerciciosController.crearEjercicio(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "crearEjercicio", Nil,"GET", """""", Routes.prefix + """ejercicio/crear"""))
   }
}
        

// @LINE:272
case controllers_contabilidad_EjerciciosController_guardarEjercicio229(params) => {
   call { 
        invokeHandler(controllers.contabilidad.EjerciciosController.guardarEjercicio(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "guardarEjercicio", Nil,"POST", """""", Routes.prefix + """ejercicio/guardar"""))
   }
}
        

// @LINE:273
case controllers_contabilidad_EjerciciosController_editarEjercicio230(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.EjerciciosController.editarEjercicio(id), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "editarEjercicio", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ejercicio/editar"""))
   }
}
        

// @LINE:274
case controllers_contabilidad_EjerciciosController_eliminarEjercicio231(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.EjerciciosController.eliminarEjercicio(id), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "eliminarEjercicio", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ejercicio/eliminar"""))
   }
}
        

// @LINE:275
case controllers_contabilidad_EjerciciosController_actualizarEjercicio232(params) => {
   call { 
        invokeHandler(controllers.contabilidad.EjerciciosController.actualizarEjercicio(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "actualizarEjercicio", Nil,"POST", """""", Routes.prefix + """ejercicio/actualizar"""))
   }
}
        

// @LINE:276
case controllers_contabilidad_EjerciciosController_modalBuscar233(params) => {
   call { 
        invokeHandler(controllers.contabilidad.EjerciciosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """ejercicio/modalBuscar"""))
   }
}
        

// @LINE:277
case controllers_contabilidad_EjerciciosController_get234(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.EjerciciosController.get(id), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """ejercicio/get"""))
   }
}
        

// @LINE:279
case controllers_contabilidad_PeriodosController_indexPeriodo235(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PeriodosController.indexPeriodo(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "indexPeriodo", Nil,"GET", """""", Routes.prefix + """periodo"""))
   }
}
        

// @LINE:280
case controllers_contabilidad_PeriodosController_crearPeriodo236(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PeriodosController.crearPeriodo(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "crearPeriodo", Nil,"GET", """""", Routes.prefix + """periodo/crear"""))
   }
}
        

// @LINE:281
case controllers_contabilidad_PeriodosController_guardarPeriodo237(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PeriodosController.guardarPeriodo(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "guardarPeriodo", Nil,"POST", """""", Routes.prefix + """periodo/guardar"""))
   }
}
        

// @LINE:282
case controllers_contabilidad_PeriodosController_editarPeriodo238(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PeriodosController.editarPeriodo(id), HandlerDef(this, "controllers.contabilidad.PeriodosController", "editarPeriodo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """periodo/editar"""))
   }
}
        

// @LINE:283
case controllers_contabilidad_PeriodosController_eliminarPeriodo239(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.PeriodosController.eliminarPeriodo(id), HandlerDef(this, "controllers.contabilidad.PeriodosController", "eliminarPeriodo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """periodo/eliminar"""))
   }
}
        

// @LINE:284
case controllers_contabilidad_PeriodosController_actualizarPeriodo240(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PeriodosController.actualizarPeriodo(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "actualizarPeriodo", Nil,"POST", """""", Routes.prefix + """periodo/actualizar"""))
   }
}
        

// @LINE:285
case controllers_contabilidad_PeriodosController_modalBuscar241(params) => {
   call { 
        invokeHandler(controllers.contabilidad.PeriodosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """periodo/modalBuscar"""))
   }
}
        

// @LINE:286
case controllers_contabilidad_PeriodosController_get242(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.PeriodosController.get(id), HandlerDef(this, "controllers.contabilidad.PeriodosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """periodo/get"""))
   }
}
        

// @LINE:288
case controllers_contabilidad_SucursalBancosController_indexSucursalBanco243(params) => {
   call { 
        invokeHandler(controllers.contabilidad.SucursalBancosController.indexSucursalBanco(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "indexSucursalBanco", Nil,"GET", """""", Routes.prefix + """sucursalBanco"""))
   }
}
        

// @LINE:289
case controllers_contabilidad_SucursalBancosController_crearSucursalBanco244(params) => {
   call { 
        invokeHandler(controllers.contabilidad.SucursalBancosController.crearSucursalBanco(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "crearSucursalBanco", Nil,"GET", """""", Routes.prefix + """sucursalBanco/crear"""))
   }
}
        

// @LINE:290
case controllers_contabilidad_SucursalBancosController_guardarSucursalBanco245(params) => {
   call { 
        invokeHandler(controllers.contabilidad.SucursalBancosController.guardarSucursalBanco(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "guardarSucursalBanco", Nil,"POST", """""", Routes.prefix + """sucursalBanco/guardar"""))
   }
}
        

// @LINE:291
case controllers_contabilidad_SucursalBancosController_editarSucursalBanco246(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.SucursalBancosController.editarSucursalBanco(id), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "editarSucursalBanco", Seq(classOf[Long]),"GET", """""", Routes.prefix + """sucursalBanco/editar"""))
   }
}
        

// @LINE:292
case controllers_contabilidad_SucursalBancosController_eliminarSucursalBanco247(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.SucursalBancosController.eliminarSucursalBanco(id), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "eliminarSucursalBanco", Seq(classOf[Long]),"GET", """""", Routes.prefix + """sucursalBanco/eliminar"""))
   }
}
        

// @LINE:293
case controllers_contabilidad_SucursalBancosController_actualizarSucursalBanco248(params) => {
   call { 
        invokeHandler(controllers.contabilidad.SucursalBancosController.actualizarSucursalBanco(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "actualizarSucursalBanco", Nil,"POST", """""", Routes.prefix + """sucursalBanco/actualizar"""))
   }
}
        

// @LINE:294
case controllers_contabilidad_SucursalBancosController_modalBuscar249(params) => {
   call { 
        invokeHandler(controllers.contabilidad.SucursalBancosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """sucursalBanco/modalBuscar"""))
   }
}
        

// @LINE:295
case controllers_contabilidad_SucursalBancosController_get250(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.SucursalBancosController.get(id), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """sucursalBanco/get"""))
   }
}
        

// @LINE:297
case controllers_contabilidad_CuentaBancariasController_indexCuentaBancaria251(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentaBancariasController.indexCuentaBancaria(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "indexCuentaBancaria", Nil,"GET", """""", Routes.prefix + """cuentaBancaria"""))
   }
}
        

// @LINE:298
case controllers_contabilidad_CuentaBancariasController_crearCuentaBancaria252(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentaBancariasController.crearCuentaBancaria(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "crearCuentaBancaria", Nil,"GET", """""", Routes.prefix + """cuentaBancaria/crear"""))
   }
}
        

// @LINE:299
case controllers_contabilidad_CuentaBancariasController_guardarCuentaBancaria253(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentaBancariasController.guardarCuentaBancaria(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "guardarCuentaBancaria", Nil,"POST", """""", Routes.prefix + """cuentaBancaria/guardar"""))
   }
}
        

// @LINE:300
case controllers_contabilidad_CuentaBancariasController_editarCuentaBancaria254(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.CuentaBancariasController.editarCuentaBancaria(id), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "editarCuentaBancaria", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentaBancaria/editar"""))
   }
}
        

// @LINE:301
case controllers_contabilidad_CuentaBancariasController_eliminarCuentaBancaria255(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.CuentaBancariasController.eliminarCuentaBancaria(id), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "eliminarCuentaBancaria", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentaBancaria/eliminar"""))
   }
}
        

// @LINE:302
case controllers_contabilidad_CuentaBancariasController_actualizarCuentaBancaria256(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentaBancariasController.actualizarCuentaBancaria(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "actualizarCuentaBancaria", Nil,"POST", """""", Routes.prefix + """cuentaBancaria/actualizar"""))
   }
}
        

// @LINE:303
case controllers_contabilidad_CuentaBancariasController_modalBuscar257(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentaBancariasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """cuentaBancaria/modalBuscar"""))
   }
}
        

// @LINE:304
case controllers_contabilidad_CuentaBancariasController_get258(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.CuentaBancariasController.get(id), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """cuentaBancaria/get"""))
   }
}
        

// @LINE:305
case controllers_contabilidad_CuentaBancariasController_ver259(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.CuentaBancariasController.ver(id), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """cuentaBancaria/ver"""))
   }
}
        

// @LINE:306
case controllers_contabilidad_CuentaBancariasController_cambiarEstado260(params) => {
   call(params.fromQuery[Long]("idCuenta", None), params.fromQuery[Long]("idEstado", None)) { (idCuenta, idEstado) =>
        invokeHandler(controllers.contabilidad.CuentaBancariasController.cambiarEstado(idCuenta, idEstado), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """cuentaBancaria/cambiarEstado"""))
   }
}
        

// @LINE:308
case controllers_contabilidad_CuentaBancariasController_reporteDatosGenerales261(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentaBancariasController.reporteDatosGenerales(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "reporteDatosGenerales", Nil,"POST", """""", Routes.prefix + """cuentaBancaria/reporteDatosGenerales"""))
   }
}
        

// @LINE:310
case controllers_contabilidad_CuentasPropiasController_modalBuscar262(params) => {
   call { 
        invokeHandler(controllers.contabilidad.CuentasPropiasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.CuentasPropiasController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """cuentasPropias/modalBuscar"""))
   }
}
        

// @LINE:311
case controllers_contabilidad_CuentasPropiasController_get263(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.contabilidad.CuentasPropiasController.get(id), HandlerDef(this, "controllers.contabilidad.CuentasPropiasController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """cuentasPropias/get"""))
   }
}
        

// @LINE:316
case controllers_contabilidad_OrdenesPagosCircuitosController_index264(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosController.index(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "index", Nil,"GET", """""", Routes.prefix + """OrdenPagoCircuito"""))
   }
}
        

// @LINE:317
case controllers_contabilidad_OrdenesPagosCircuitosController_ver265(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosController.ver(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """OrdenPagoCircuito/ver"""))
   }
}
        

// @LINE:318
case controllers_contabilidad_OrdenesPagosCircuitosController_cambiarEstado266(params) => {
   call(params.fromQuery[Long]("idOc", None), params.fromQuery[Long]("idEstado", None)) { (idOc, idEstado) =>
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosController.cambiarEstado(idOc, idEstado), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """OrdenPagoCircuitoCambiarEstado"""))
   }
}
        

// @LINE:319
case controllers_contabilidad_OrdenesPagosCircuitosController_editar267(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosController.editar(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """OrdenPagoCircuito/editar"""))
   }
}
        

// @LINE:320
case controllers_contabilidad_OrdenesPagosCircuitosController_actualizar268(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosController.actualizar(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "actualizar", Nil,"POST", """""", Routes.prefix + """OrdenPagoCircuito/actualizar"""))
   }
}
        

// @LINE:321
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarBorrador269(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarBorrador", Nil,"GET", """""", Routes.prefix + """OrdenPagoCircuito/modalPasarBorrador"""))
   }
}
        

// @LINE:322
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarBorradorMasivo270(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarBorradorMasivo", Nil,"POST", """""", Routes.prefix + """OrdenPagoCircuito/pasarBorradorMasivo"""))
   }
}
        

// @LINE:323
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarContabilidad271(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarContabilidad(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarContabilidad", Nil,"GET", """""", Routes.prefix + """OrdenPagoCircuito/modalPasarContabilidad"""))
   }
}
        

// @LINE:324
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarContabilidadMasivo272(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarContabilidadMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarContabilidadMasivo", Nil,"POST", """""", Routes.prefix + """OrdenPagoCircuito/pasarContabilidadMasivo"""))
   }
}
        

// @LINE:325
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarRendiciones273(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarRendiciones(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarRendiciones", Nil,"GET", """""", Routes.prefix + """OrdenPagoCircuito/modalPasarRendiciones"""))
   }
}
        

// @LINE:326
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarRendicionesMasivo274(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarRendicionesMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarRendicionesMasivo", Nil,"POST", """""", Routes.prefix + """OrdenPagoCircuito/pasarRendicionesMasivo"""))
   }
}
        

// @LINE:327
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarRendido275(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarRendido(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarRendido", Nil,"GET", """""", Routes.prefix + """OrdenPagoCircuito/modalPasarRendido"""))
   }
}
        

// @LINE:328
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarRendidoMasivo276(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarRendidoMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarRendidoMasivo", Nil,"POST", """""", Routes.prefix + """OrdenPagoCircuito/pasarRendidoMasivo"""))
   }
}
        

// @LINE:329
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalPasarCancelado277(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarCancelado", Nil,"GET", """""", Routes.prefix + """OrdenPagoCircuito/modalPasarCancelado"""))
   }
}
        

// @LINE:330
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_pasarCanceladoMasivo278(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarCanceladoMasivo", Nil,"POST", """""", Routes.prefix + """OrdenPagoCircuito/pasarCanceladoMasivo"""))
   }
}
        

// @LINE:332
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_modalCargarExpedienteFisico279(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalCargarExpedienteFisico(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalCargarExpedienteFisico", Nil,"GET", """""", Routes.prefix + """OrdenPagoCircuito/modalCargarExpedienteFisico"""))
   }
}
        

// @LINE:333
case controllers_contabilidad_OrdenesPagosCircuitosAccionesController_cargarExpedienteFisico280(params) => {
   call { 
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosAccionesController.cargarExpedienteFisico(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "cargarExpedienteFisico", Nil,"POST", """""", Routes.prefix + """OrdenPagoCircuito/cargarExpedienteFisico"""))
   }
}
        

// @LINE:336
case controllers_contabilidad_OrdenesPagosCircuitosLineasController_index281(params) => {
   call(params.fromQuery[Long]("orden_pago_circuito_id", Some(0))) { (orden_pago_circuito_id) =>
        invokeHandler(controllers.contabilidad.OrdenesPagosCircuitosLineasController.index(orden_pago_circuito_id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosLineasController", "index", Seq(classOf[Long]),"GET", """""", Routes.prefix + """OrdenPagoCircuitoLinea"""))
   }
}
        

// @LINE:338
case controllers_contabilidad_BalanceCuentaPropiaController_index282(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceCuentaPropiaController.index(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "index", Nil,"GET", """""", Routes.prefix + """BalanceCuentaPropia"""))
   }
}
        

// @LINE:339
case controllers_contabilidad_BalanceCuentaPropiaController_archivoIndex283(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceCuentaPropiaController.archivoIndex(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "archivoIndex", Nil,"GET", """""", Routes.prefix + """BalanceCuentaPropia/archivoIndex"""))
   }
}
        

// @LINE:340
case controllers_contabilidad_BalanceCuentaPropiaController_modalAgregarMovimientoBalanceCuentaPropia284(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceCuentaPropiaController.modalAgregarMovimientoBalanceCuentaPropia(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "modalAgregarMovimientoBalanceCuentaPropia", Nil,"GET", """""", Routes.prefix + """BalanceCuentaPropia/modalAgregarMovimientoBalanceCuentaPropia"""))
   }
}
        

// @LINE:341
case controllers_contabilidad_BalanceCuentaPropiaController_agregarMovimientoBalanceCuentaPropia285(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceCuentaPropiaController.agregarMovimientoBalanceCuentaPropia(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "agregarMovimientoBalanceCuentaPropia", Nil,"POST", """""", Routes.prefix + """BalanceCuentaPropia/agregarMovimientoBalanceCuentaPropia"""))
   }
}
        

// @LINE:343
case controllers_contabilidad_BalanceCuentaPropiaController_modalTransferenciaEntreCuentasPropias286(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceCuentaPropiaController.modalTransferenciaEntreCuentasPropias(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "modalTransferenciaEntreCuentasPropias", Nil,"GET", """""", Routes.prefix + """BalanceCuentaPropia/modalTransferenciaEntreCuentasPropias"""))
   }
}
        

// @LINE:344
case controllers_contabilidad_BalanceCuentaPropiaController_transferenciaEntreCuentasPropias287(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceCuentaPropiaController.transferenciaEntreCuentasPropias(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "transferenciaEntreCuentasPropias", Nil,"POST", """""", Routes.prefix + """BalanceCuentaPropia/transferenciaEntreCuentasPropias"""))
   }
}
        

// @LINE:345
case controllers_contabilidad_BalanceCuentaPropiaController_listaPagos288(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.BalanceCuentaPropiaController.listaPagos(id), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "listaPagos", Seq(classOf[Long]),"POST", """""", Routes.prefix + """BalanceCuentaPropia/listaPagos"""))
   }
}
        

// @LINE:347
case controllers_contabilidad_BalanceCuentaPropiaController_getOrdenes289(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.BalanceCuentaPropiaController.getOrdenes(id), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "getOrdenes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """BalanceCuentaPropia/get-ordenes"""))
   }
}
        

// @LINE:348
case controllers_contabilidad_BalanceCuentaPropiaController_getExpedientes290(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.contabilidad.BalanceCuentaPropiaController.getExpedientes(id), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "getExpedientes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """BalanceCuentaPropia/get-expedientes"""))
   }
}
        

// @LINE:350
case controllers_contabilidad_BalanceController_index291(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.index(), HandlerDef(this, "controllers.contabilidad.BalanceController", "index", Nil,"GET", """""", Routes.prefix + """Balance"""))
   }
}
        

// @LINE:351
case controllers_contabilidad_BalanceController_general292(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.general(), HandlerDef(this, "controllers.contabilidad.BalanceController", "general", Nil,"GET", """""", Routes.prefix + """Balance/general"""))
   }
}
        

// @LINE:352
case controllers_contabilidad_BalanceController_modalAgregarMovimientoBalance293(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.modalAgregarMovimientoBalance(), HandlerDef(this, "controllers.contabilidad.BalanceController", "modalAgregarMovimientoBalance", Nil,"GET", """""", Routes.prefix + """Balance/modalAgregarMovimientoBalance"""))
   }
}
        

// @LINE:353
case controllers_contabilidad_BalanceController_agregarMovimientoBalance294(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.agregarMovimientoBalance(), HandlerDef(this, "controllers.contabilidad.BalanceController", "agregarMovimientoBalance", Nil,"POST", """""", Routes.prefix + """Balance/agregarMovimientoBalance"""))
   }
}
        

// @LINE:355
case controllers_contabilidad_BalanceController_modalPasarBorrador295(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.modalPasarBorrador(), HandlerDef(this, "controllers.contabilidad.BalanceController", "modalPasarBorrador", Nil,"GET", """""", Routes.prefix + """Balance/modalPasarBorrador"""))
   }
}
        

// @LINE:356
case controllers_contabilidad_BalanceController_pasarBorradorMasivo296(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.pasarBorradorMasivo(), HandlerDef(this, "controllers.contabilidad.BalanceController", "pasarBorradorMasivo", Nil,"POST", """""", Routes.prefix + """Balance/pasarBorradorMasivo"""))
   }
}
        

// @LINE:357
case controllers_contabilidad_BalanceController_modalPasarControlado297(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.modalPasarControlado(), HandlerDef(this, "controllers.contabilidad.BalanceController", "modalPasarControlado", Nil,"GET", """""", Routes.prefix + """Balance/modalPasarControlado"""))
   }
}
        

// @LINE:358
case controllers_contabilidad_BalanceController_pasarControladoMasivo298(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.pasarControladoMasivo(), HandlerDef(this, "controllers.contabilidad.BalanceController", "pasarControladoMasivo", Nil,"POST", """""", Routes.prefix + """Balance/pasarControladoMasivo"""))
   }
}
        

// @LINE:360
case controllers_contabilidad_BalanceController_modalCambiarCuenta299(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.modalCambiarCuenta(), HandlerDef(this, "controllers.contabilidad.BalanceController", "modalCambiarCuenta", Nil,"GET", """""", Routes.prefix + """Balance/modalCambiarCuenta"""))
   }
}
        

// @LINE:361
case controllers_contabilidad_BalanceController_cambiarCuentaMasivo300(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.cambiarCuentaMasivo(), HandlerDef(this, "controllers.contabilidad.BalanceController", "cambiarCuentaMasivo", Nil,"POST", """""", Routes.prefix + """Balance/cambiarCuentaMasivo"""))
   }
}
        

// @LINE:363
case controllers_contabilidad_BalanceController_archivoBejerman301(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.archivoBejerman(), HandlerDef(this, "controllers.contabilidad.BalanceController", "archivoBejerman", Nil,"POST", """""", Routes.prefix + """Balance/archivoBejerman"""))
   }
}
        

// @LINE:364
case controllers_contabilidad_BalanceController_archivoBejermanPagos302(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.archivoBejermanPagos(), HandlerDef(this, "controllers.contabilidad.BalanceController", "archivoBejermanPagos", Nil,"POST", """""", Routes.prefix + """Balance/archivoBejermanPagos"""))
   }
}
        

// @LINE:365
case controllers_contabilidad_BalanceController_archivoExcel303(params) => {
   call { 
        invokeHandler(controllers.contabilidad.BalanceController.archivoExcel(), HandlerDef(this, "controllers.contabilidad.BalanceController", "archivoExcel", Nil,"POST", """""", Routes.prefix + """Balance/archivoExcel"""))
   }
}
        

// @LINE:367
case controllers_contabilidad_BancosController_suggestBanco304(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.contabilidad.BancosController.suggestBanco(input), HandlerDef(this, "controllers.contabilidad.BancosController", "suggestBanco", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestBanco/$input<[^/]+>"""))
   }
}
        

// @LINE:368
case controllers_contabilidad_CuentaBancariasController_suggestCuentaBancaria305(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.contabilidad.CuentaBancariasController.suggestCuentaBancaria(input), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "suggestCuentaBancaria", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestCuentaBancaria/$input<[^/]+>"""))
   }
}
        

// @LINE:369
case controllers_contabilidad_PeriodosController_suggestPeriodo306(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.contabilidad.PeriodosController.suggestPeriodo(input), HandlerDef(this, "controllers.contabilidad.PeriodosController", "suggestPeriodo", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestPeriodo/$input<[^/]+>"""))
   }
}
        

// @LINE:370
case controllers_contabilidad_OrdenesPagosController_suggestOrdenPago307(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.contabilidad.OrdenesPagosController.suggestOrdenPago(input), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "suggestOrdenPago", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestOrdenPago/$input<[^/]+>"""))
   }
}
        

// @LINE:371
case controllers_contabilidad_CuentasAnaliticasController_suggestCuentaAnalitica308(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.contabilidad.CuentasAnaliticasController.suggestCuentaAnalitica(input), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "suggestCuentaAnalitica", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestCuentaAnalitica/$input<[^/]+>"""))
   }
}
        

// @LINE:372
case controllers_contabilidad_CuentasController_suggestCuenta309(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.contabilidad.CuentasController.suggestCuenta(input), HandlerDef(this, "controllers.contabilidad.CuentasController", "suggestCuenta", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestCuenta/$input<[^/]+>"""))
   }
}
        

// @LINE:373
case controllers_contabilidad_EjerciciosController_suggestEjercicio310(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.contabilidad.EjerciciosController.suggestEjercicio(input), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "suggestEjercicio", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestEjercicio/$input<[^/]+>"""))
   }
}
        
}

}
     