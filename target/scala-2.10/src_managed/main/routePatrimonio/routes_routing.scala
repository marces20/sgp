// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routePatrimonio.routes
// @HASH:f2062f867d9eeb5641bae91bce5c89e3c639c8fc
// @DATE:Tue Oct 04 11:43:28 ART 2022
package routePatrimonio

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
private[this] lazy val controllers_patrimonio_IndexController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:2
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/index"))))
        

// @LINE:3
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_ver2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/ver"))))
        

// @LINE:4
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_verProductosSolicitados3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/ver-productos-solicitados"))))
        

// @LINE:5
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_productosRecepcionados4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/productosRecepcionados"))))
        

// @LINE:6
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_editar5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/editar"))))
        

// @LINE:7
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_actualizar6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/actualizar"))))
        

// @LINE:8
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_eliminar7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/eliminar"))))
        

// @LINE:9
private[this] lazy val controllers_patrimonio_OrdenesProvisionReportesController_ordenDeProvision8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/reproteOrdenProvision"))))
        

// @LINE:10
private[this] lazy val controllers_patrimonio_OrdenesProvisionReportesController_informeInventariable9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/informeInventariable"))))
        

// @LINE:11
private[this] lazy val controllers_patrimonio_OrdenesProvisionReportesController_informePendiente10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/informePendiente"))))
        

// @LINE:12
private[this] lazy val controllers_patrimonio_OrdenesProvisionReportesController_informeGeneral11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/informeGeneral"))))
        

// @LINE:13
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_getRecepciones12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/getRecepciones"))))
        

// @LINE:15
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_getLastNumeroProvision13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/getLastNumeroProvision"))))
        

// @LINE:17
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_modalAnularProductosPedientes14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/modalAnularProductosPedientes"))))
        

// @LINE:18
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_anularProductosPediente15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/anularProductosPediente"))))
        

// @LINE:20
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_modalCrearActasDeAjustes16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/modalCrearActasDeAjustes"))))
        

// @LINE:21
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_crearActasDeAjustes17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/crearActasDeAjustes"))))
        

// @LINE:23
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_informacionPorPacientes18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/informacionPorPacientes"))))
        

// @LINE:24
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_informacionPorPacientesExcel19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/informacionPorPacientesExcel"))))
        

// @LINE:26
private[this] lazy val controllers_patrimonio_OrdenesProvisionReportesController_notaCierre20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/reproteNotaCierre"))))
        

// @LINE:27
private[this] lazy val controllers_patrimonio_OrdenesProvisionReportesController_reporteAnulados21 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/reporteAnulados"))))
        

// @LINE:29
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_modalBuscar22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/modalBuscar"))))
        

// @LINE:30
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_get23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenesProvision/get"))))
        

// @LINE:32
private[this] lazy val controllers_patrimonio_OrdenesProvisionReportesController_reporteGeneralOp24 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("patrimonio/ordenesProvision/reporteGeneralOp"))))
        

// @LINE:33
private[this] lazy val controllers_patrimonio_OrdenesProvisionReportesController_reporteListaLineasRemitos25 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("patrimonio/ordenesProvision/reporteListaLineasRemitos"))))
        

// @LINE:35
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_productosEnOrden26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/productosEnOrden"))))
        

// @LINE:36
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_verLineas27 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/ver-lineas"))))
        

// @LINE:37
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_verLineasNoCertificadas28 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/verLineasNoCertificadas"))))
        

// @LINE:38
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_crear29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/crear"))))
        

// @LINE:39
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_guardar30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/guardar"))))
        

// @LINE:40
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_editar31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/editar"))))
        

// @LINE:41
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_eliminar32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/eliminar"))))
        

// @LINE:42
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_actualizar33 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/actualizar"))))
        

// @LINE:43
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_modalProductosEnOrden34 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/modalBuscar"))))
        

// @LINE:44
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_get35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/get"))))
        

// @LINE:45
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_anularConCliente36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/anularConCliente"))))
        

// @LINE:46
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_modalAnularConClientes37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/modalAnularConClientes"))))
        

// @LINE:47
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_controlesAnularConCliente38 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/controlesAnularConCliente"))))
        

// @LINE:48
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_anular39 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/anular"))))
        

// @LINE:49
private[this] lazy val controllers_patrimonio_AnulacionRecepcionProductosController_tienePacientes40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anulacion-productos/tienePacientes"))))
        

// @LINE:51
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_index41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/index"))))
        

// @LINE:52
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_indexAjax42 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/index-ajax"))))
        

// @LINE:53
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_ver43 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/ver"))))
        

// @LINE:55
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_guardar44 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/guardar"))))
        

// @LINE:56
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_editar45 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/editar"))))
        

// @LINE:57
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_actualizar46 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/actualizar"))))
        

// @LINE:58
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_eliminar47 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/eliminar"))))
        

// @LINE:59
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_cambiarEstado48 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/cambiar-estado"))))
        

// @LINE:60
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_crearDesdeOrdenAjax49 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/crearDesdeOrdenAjax"))))
        

// @LINE:61
private[this] lazy val controllers_patrimonio_CertificacionesServiciosController_agregarLineasConCliente50 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/agregarLineasConCliente"))))
        

// @LINE:63
private[this] lazy val controllers_patrimonio_CertificacionesReportesController_reporteCertificacion51 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificaciones/reportes/certificacion"))))
        

// @LINE:66
private[this] lazy val controllers_patrimonio_LineasCertificacionesController_index52 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificacion-linea/index"))))
        

// @LINE:67
private[this] lazy val controllers_patrimonio_LineasCertificacionesController_crear53 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificacion-linea/crear"))))
        

// @LINE:68
private[this] lazy val controllers_patrimonio_LineasCertificacionesController_editar54 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificacion-linea/editar"))))
        

// @LINE:69
private[this] lazy val controllers_patrimonio_LineasCertificacionesController_guardar55 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificacion-linea/guardar"))))
        

// @LINE:70
private[this] lazy val controllers_patrimonio_LineasCertificacionesController_actualizar56 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificacion-linea/actualizar"))))
        

// @LINE:71
private[this] lazy val controllers_patrimonio_LineasCertificacionesController_eliminar57 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificacion-linea/eliminar"))))
        

// @LINE:72
private[this] lazy val controllers_patrimonio_LineasCertificacionesController_getListaLineasPacientes58 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("certificacion-linea/getListaLineasPacientes"))))
        

// @LINE:74
private[this] lazy val controllers_patrimonio_RecepcionesController_index59 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/index"))))
        

// @LINE:75
private[this] lazy val controllers_patrimonio_RecepcionesController_indexAjax60 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/indexAjax"))))
        

// @LINE:76
private[this] lazy val controllers_patrimonio_RecepcionesController_ver61 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/ver"))))
        

// @LINE:77
private[this] lazy val controllers_patrimonio_RecepcionesController_crear62 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/crear"))))
        

// @LINE:78
private[this] lazy val controllers_patrimonio_RecepcionesController_guardar63 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/guardar"))))
        

// @LINE:79
private[this] lazy val controllers_patrimonio_RecepcionesController_editar64 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/editar"))))
        

// @LINE:80
private[this] lazy val controllers_patrimonio_RecepcionesController_actualizar65 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/actualizar"))))
        

// @LINE:81
private[this] lazy val controllers_patrimonio_RecepcionesController_eliminar66 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/eliminar"))))
        

// @LINE:82
private[this] lazy val controllers_patrimonio_RecepcionesReportesController_reporteLineasRecepciones67 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/reporteLineasRecepciones"))))
        

// @LINE:83
private[this] lazy val controllers_patrimonio_RecepcionesReportesController_reporteDatosRecepciones68 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/reporteDatosRecepciones"))))
        

// @LINE:85
private[this] lazy val controllers_patrimonio_RecepcionesController_modalBuscarRecepcionesDeOrdenes69 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/modalBuscarRecepcionesDeOrdenes"))))
        

// @LINE:86
private[this] lazy val controllers_patrimonio_RecepcionesController_get70 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/get"))))
        

// @LINE:87
private[this] lazy val controllers_patrimonio_RecepcionesController_modalCargarRemitosMasivos71 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/modalCargarRemitosMasivos"))))
        

// @LINE:88
private[this] lazy val controllers_patrimonio_RecepcionesController_cargarRemitosMasivos72 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recepciones/cargarRemitosMasivos"))))
        

// @LINE:90
private[this] lazy val controllers_patrimonio_RemitosBaulController_index73 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-baul/index"))))
        

// @LINE:91
private[this] lazy val controllers_patrimonio_RemitosBaulController_ver74 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-baul/ver"))))
        

// @LINE:92
private[this] lazy val controllers_patrimonio_RemitosBaulController_eliminar75 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-baul/eliminar"))))
        

// @LINE:93
private[this] lazy val controllers_patrimonio_RemitosBaulController_crear76 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-baul/crear"))))
        

// @LINE:94
private[this] lazy val controllers_patrimonio_RemitosBaulController_guardar77 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-baul/guardar"))))
        

// @LINE:95
private[this] lazy val controllers_patrimonio_RemitosBaulController_editar78 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-baul/editar"))))
        

// @LINE:96
private[this] lazy val controllers_patrimonio_RemitosBaulController_actualizar79 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-baul/actualizar"))))
        

// @LINE:98
private[this] lazy val controllers_patrimonio_InventarioController_index80 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inventario/index"))))
        

// @LINE:99
private[this] lazy val controllers_patrimonio_InventarioController_registrarModal81 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inventario/registrarModal"))))
        

// @LINE:100
private[this] lazy val controllers_patrimonio_InventarioController_eliminar82 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inventario/eliminar"))))
        

// @LINE:101
private[this] lazy val controllers_patrimonio_InventarioController_actualizar83 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inventario/actualizar"))))
        

// @LINE:102
private[this] lazy val controllers_patrimonio_InventarioController_guardar84 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inventario/guardar"))))
        

// @LINE:104
private[this] lazy val controllers_patrimonio_PrefijosController_get85 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inventario-prefijo/get"))))
        

// @LINE:105
private[this] lazy val controllers_patrimonio_PrefijosController_modalBuscar86 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inventario-prefijo/modalBuscar"))))
        

// @LINE:107
private[this] lazy val controllers_patrimonio_PrefijosAccionesController_modificarModal87 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("prefijo/acciones/modificar-modal"))))
        

// @LINE:108
private[this] lazy val controllers_patrimonio_PrefijosAccionesController_modificar88 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("prefijo/acciones/modificar"))))
        

// @LINE:111
private[this] lazy val controllers_patrimonio_RemitosLineasBaulController_index89 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas-baul/index"))))
        

// @LINE:112
private[this] lazy val controllers_patrimonio_RemitosLineasBaulController_eliminar90 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas-baul/eliminar"))))
        

// @LINE:113
private[this] lazy val controllers_patrimonio_RemitosLineasBaulController_editar91 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas-baul/editar"))))
        

// @LINE:114
private[this] lazy val controllers_patrimonio_RemitosLineasBaulController_actualizar92 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas-baul/actualizar"))))
        

// @LINE:115
private[this] lazy val controllers_patrimonio_RemitosLineasBaulController_crear93 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas-baul/crear"))))
        

// @LINE:116
private[this] lazy val controllers_patrimonio_RemitosLineasBaulController_guardar94 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas-baul/guardar"))))
        

// @LINE:118
private[this] lazy val controllers_patrimonio_RemitosController_ver95 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/ver"))))
        

// @LINE:119
private[this] lazy val controllers_patrimonio_RemitosController_index96 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/index"))))
        

// @LINE:120
private[this] lazy val controllers_patrimonio_RemitosController_indexAjax97 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/indexAjax"))))
        

// @LINE:121
private[this] lazy val controllers_patrimonio_RemitosController_crear98 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/crear"))))
        

// @LINE:122
private[this] lazy val controllers_patrimonio_RemitosController_guardar99 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/guardar"))))
        

// @LINE:123
private[this] lazy val controllers_patrimonio_RemitosController_editar100 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/editar"))))
        

// @LINE:124
private[this] lazy val controllers_patrimonio_RemitosController_actualizar101 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/actualizar"))))
        

// @LINE:125
private[this] lazy val controllers_patrimonio_RemitosController_eliminar102 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/eliminar"))))
        

// @LINE:126
private[this] lazy val controllers_patrimonio_RemitosController_reporteDatosRemitos103 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/reporteDatosRemitos"))))
        

// @LINE:127
private[this] lazy val controllers_patrimonio_RemitosController_reporteDatosRemitosGeneral104 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/reporteDatosRemitosGeneral"))))
        

// @LINE:129
private[this] lazy val controllers_patrimonio_RemitosController_modalCambiarRecepcion105 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/modalCambiarRecepcion"))))
        

// @LINE:130
private[this] lazy val controllers_patrimonio_RemitosController_cambiarRecepcion106 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos/cambiarRecepcion"))))
        

// @LINE:132
private[this] lazy val controllers_patrimonio_RemitosLineasController_index107 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/index"))))
        

// @LINE:133
private[this] lazy val controllers_patrimonio_RemitosLineasController_paraAgregar108 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/para-agregar"))))
        

// @LINE:134
private[this] lazy val controllers_patrimonio_RemitosLineasController_agregarConCliente109 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/para-agregar-cliente"))))
        

// @LINE:135
private[this] lazy val controllers_patrimonio_RemitosLineasController_tienePacientes110 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/tiene-pacientes"))))
        

// @LINE:136
private[this] lazy val controllers_patrimonio_RemitosLineasController_agregar111 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/agregar"))))
        

// @LINE:137
private[this] lazy val controllers_patrimonio_RemitosLineasController_modificar112 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/modificar"))))
        

// @LINE:138
private[this] lazy val controllers_patrimonio_RemitosLineasController_eliminar113 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/eliminar"))))
        

// @LINE:139
private[this] lazy val controllers_patrimonio_RemitosLineasController_enRemito114 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/en-remito"))))
        

// @LINE:140
private[this] lazy val controllers_patrimonio_RemitosLineasController_recepcionarTodos115 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/recepcionar-todos"))))
        

// @LINE:141
private[this] lazy val controllers_patrimonio_RemitosLineasController_controlesAgregarConCliente116 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/controlesAgregarConCliente"))))
        

// @LINE:142
private[this] lazy val controllers_patrimonio_RemitosLineasController_modalAgregarConClientes117 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remitos-lineas/modalAgregarConClientes"))))
        

// @LINE:147
private[this] lazy val controllers_patrimonio_ActasRecepcionController_indexAjax118 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/indexAjax"))))
        

// @LINE:148
private[this] lazy val controllers_patrimonio_ActasRecepcionController_index119 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/index"))))
        

// @LINE:149
private[this] lazy val controllers_patrimonio_ActasRecepcionController_crear120 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/crear"))))
        

// @LINE:150
private[this] lazy val controllers_patrimonio_ActasRecepcionController_guardar121 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/guardar"))))
        

// @LINE:151
private[this] lazy val controllers_patrimonio_ActasRecepcionController_ver122 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/ver"))))
        

// @LINE:152
private[this] lazy val controllers_patrimonio_ActasRecepcionController_verModal123 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/verModal"))))
        

// @LINE:153
private[this] lazy val controllers_patrimonio_ActasRecepcionLineasController_index124 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcionLineas/index"))))
        

// @LINE:154
private[this] lazy val controllers_patrimonio_ActasRecepcionController_eliminar125 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/eliminar"))))
        

// @LINE:155
private[this] lazy val controllers_patrimonio_ActasRecepcionController_editar126 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/editar"))))
        

// @LINE:156
private[this] lazy val controllers_patrimonio_ActasRecepcionController_actualizar127 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/actualizar"))))
        

// @LINE:157
private[this] lazy val controllers_patrimonio_ActasRecepcionController_cambiarEstado128 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/cambiarEstado"))))
        

// @LINE:158
private[this] lazy val controllers_patrimonio_ActasRecepcionReportesController_reporte129 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actas-recepcion-reporte/reporte"))))
        

// @LINE:159
private[this] lazy val controllers_patrimonio_ActasRecepcionReportesController_reporteLineasActas130 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/reporteLineasActas"))))
        

// @LINE:160
private[this] lazy val controllers_patrimonio_ActasRecepcionReportesController_reporteGeneralActa131 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/reporteGeneralActa"))))
        

// @LINE:161
private[this] lazy val controllers_patrimonio_ActasRecepcionReportesController_reporteActaCierre132 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actas-recepcion-reporte/reporteActaCierre"))))
        

// @LINE:163
private[this] lazy val controllers_patrimonio_ActasRecepcionReportesController_modalListadoInventariable133 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actas-recepcion-reporte/modalListadoInventariable"))))
        

// @LINE:164
private[this] lazy val controllers_patrimonio_ActasRecepcionReportesController_informeListadoInventariable134 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actas-recepcion-reporte/informeListadoInventariable"))))
        

// @LINE:166
private[this] lazy val controllers_patrimonio_ActasRecepcionAccionesController_crear135 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcion/modal-crear"))))
        

// @LINE:167
private[this] lazy val controllers_patrimonio_ActasRecepcionAccionesController_guardar136 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcion/modal-guardar"))))
        

// @LINE:168
private[this] lazy val controllers_patrimonio_ActasRecepcionAccionesController_revocar137 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcion/revocar"))))
        

// @LINE:169
private[this] lazy val controllers_patrimonio_ActasRecepcionAccionesController_modalAsignar138 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcion/modal-asignar"))))
        

// @LINE:170
private[this] lazy val controllers_patrimonio_ActasRecepcionAccionesController_asignar139 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcion/asignar"))))
        

// @LINE:172
private[this] lazy val controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_crear140 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcionCertificaciones/modal-crear"))))
        

// @LINE:173
private[this] lazy val controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_guardar141 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcionCertificaciones/modal-guardar"))))
        

// @LINE:174
private[this] lazy val controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_revocar142 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcionCertificaciones/revocar"))))
        

// @LINE:175
private[this] lazy val controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_modalAsignar143 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcionCertificaciones/modal-asignar"))))
        

// @LINE:176
private[this] lazy val controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_asignar144 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acciones/actasRecepcionCertificaciones/asignar"))))
        

// @LINE:178
private[this] lazy val controllers_patrimonio_ActasMovimientosController_index145 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/index"))))
        

// @LINE:179
private[this] lazy val controllers_patrimonio_ActasMovimientosController_crear146 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/crear"))))
        

// @LINE:180
private[this] lazy val controllers_patrimonio_ActasMovimientosController_editar147 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/editar"))))
        

// @LINE:181
private[this] lazy val controllers_patrimonio_ActasMovimientosController_guardar148 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/guardar"))))
        

// @LINE:182
private[this] lazy val controllers_patrimonio_ActasMovimientosController_actualizar149 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/actualizar"))))
        

// @LINE:183
private[this] lazy val controllers_patrimonio_ActasMovimientosController_eliminar150 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/eliminar"))))
        

// @LINE:184
private[this] lazy val controllers_patrimonio_ActasMovimientosController_indexGeneral151 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/indexGeneral"))))
        

// @LINE:185
private[this] lazy val controllers_patrimonio_ActasMovimientosController_indexPasesPorUsuario152 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/indexPasesPorUsuario"))))
        

// @LINE:187
private[this] lazy val controllers_patrimonio_ActasMovimientosController_modalPasarOtroServicio153 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/modalPasarOtroServicio"))))
        

// @LINE:188
private[this] lazy val controllers_patrimonio_ActasMovimientosController_modalPasarOtroServicioIndividual154 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/modalPasarOtroServicioIndividual"))))
        

// @LINE:189
private[this] lazy val controllers_patrimonio_ActasMovimientosController_pasarOtroServicio155 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/pasarOtroServicio"))))
        

// @LINE:190
private[this] lazy val controllers_patrimonio_ActasMovimientosController_cancelarPase156 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/cancelarPase"))))
        

// @LINE:191
private[this] lazy val controllers_patrimonio_ActasMovimientosController_asignarMiServicio157 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/asignarMiServicio"))))
        

// @LINE:192
private[this] lazy val controllers_patrimonio_ActasMovimientosController_cancelarPaseLista158 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/cancelarPaseLista"))))
        

// @LINE:193
private[this] lazy val controllers_patrimonio_ActasMovimientosController_modalAsignarMiServicio159 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/modalAsignarMiServicio"))))
        

// @LINE:194
private[this] lazy val controllers_patrimonio_ActasMovimientosController_asignarAMiServicioMasivo160 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/asignarMiServicioMasivo"))))
        

// @LINE:196
private[this] lazy val controllers_patrimonio_ActasMovimientosController_modalCierreCircuitoIndividual161 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/modalCierreCircuitoIndividual"))))
        

// @LINE:197
private[this] lazy val controllers_patrimonio_ActasMovimientosController_modalCierreCircuito162 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/modalCierreCircuito"))))
        

// @LINE:198
private[this] lazy val controllers_patrimonio_ActasMovimientosController_cierreCircuito163 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/cierreCircuito"))))
        

// @LINE:201
private[this] lazy val controllers_patrimonio_ActasMovimientosController_aceptarPase164 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/aceptarPase"))))
        

// @LINE:202
private[this] lazy val controllers_patrimonio_ActasMovimientosController_rechazarPase165 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/movimiento-linea/rechazarPase"))))
        

// @LINE:204
private[this] lazy val controllers_patrimonio_ActasRecepcionController_getPacientes166 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("actasRecepcion/getPacientes"))))
        

// @LINE:206
private[this] lazy val controllers_patrimonio_ActaRecepcionLineaAjusteController_index167 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acta-linea-ajuste/index"))))
        

// @LINE:207
private[this] lazy val controllers_patrimonio_ActaRecepcionLineaAjusteController_crear168 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acta-linea-ajuste/crear"))))
        

// @LINE:208
private[this] lazy val controllers_patrimonio_ActaRecepcionLineaAjusteController_editar169 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acta-linea-ajuste/editar"))))
        

// @LINE:209
private[this] lazy val controllers_patrimonio_ActaRecepcionLineaAjusteController_guardar170 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acta-linea-ajuste/guardar"))))
        

// @LINE:210
private[this] lazy val controllers_patrimonio_ActaRecepcionLineaAjusteController_actualizar171 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acta-linea-ajuste/actualizar"))))
        

// @LINE:211
private[this] lazy val controllers_patrimonio_ActaRecepcionLineaAjusteController_eliminar172 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("acta-linea-ajuste/eliminar"))))
        

// @LINE:214
private[this] lazy val controllers_patrimonio_OrdenesProvisionController_suggestOrdenProvision173 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestOrdenProvision/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:215
private[this] lazy val controllers_patrimonio_PrefijosController_suggest174 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestPrefijo/"),DynamicPart("input", """[^/]+""",true))))
        
def documentation = List(("""GET""", prefix,"""controllers.patrimonio.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/index""","""controllers.patrimonio.OrdenesProvisionController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/ver""","""controllers.patrimonio.OrdenesProvisionController.ver(id:Long ?= 0, idActa:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/ver-productos-solicitados""","""controllers.patrimonio.OrdenesProvisionController.verProductosSolicitados(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/productosRecepcionados""","""controllers.patrimonio.OrdenesProvisionController.productosRecepcionados(orden_provision_id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/editar""","""controllers.patrimonio.OrdenesProvisionController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/actualizar""","""controllers.patrimonio.OrdenesProvisionController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/eliminar""","""controllers.patrimonio.OrdenesProvisionController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/reproteOrdenProvision""","""controllers.patrimonio.OrdenesProvisionReportesController.ordenDeProvision(idOrdenProvision:Long, sinMonto:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/informeInventariable""","""controllers.patrimonio.OrdenesProvisionReportesController.informeInventariable(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/informePendiente""","""controllers.patrimonio.OrdenesProvisionReportesController.informePendiente(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/informeGeneral""","""controllers.patrimonio.OrdenesProvisionReportesController.informeGeneral(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/getRecepciones""","""controllers.patrimonio.OrdenesProvisionController.getRecepciones(orden_provision_id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/getLastNumeroProvision""","""controllers.patrimonio.OrdenesProvisionController.getLastNumeroProvision()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/modalAnularProductosPedientes""","""controllers.patrimonio.OrdenesProvisionController.modalAnularProductosPedientes(ordenId:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/anularProductosPediente""","""controllers.patrimonio.OrdenesProvisionController.anularProductosPediente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/modalCrearActasDeAjustes""","""controllers.patrimonio.OrdenesProvisionController.modalCrearActasDeAjustes(ordenId:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/crearActasDeAjustes""","""controllers.patrimonio.OrdenesProvisionController.crearActasDeAjustes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/informacionPorPacientes""","""controllers.patrimonio.OrdenesProvisionController.informacionPorPacientes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/informacionPorPacientesExcel""","""controllers.patrimonio.OrdenesProvisionController.informacionPorPacientesExcel()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/reproteNotaCierre""","""controllers.patrimonio.OrdenesProvisionReportesController.notaCierre(idOrdenProvision:Long, n:Int ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/reporteAnulados""","""controllers.patrimonio.OrdenesProvisionReportesController.reporteAnulados(idOrdenProvision:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/modalBuscar""","""controllers.patrimonio.OrdenesProvisionController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenesProvision/get""","""controllers.patrimonio.OrdenesProvisionController.get(id:Int ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """patrimonio/ordenesProvision/reporteGeneralOp""","""controllers.patrimonio.OrdenesProvisionReportesController.reporteGeneralOp()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """patrimonio/ordenesProvision/reporteListaLineasRemitos""","""controllers.patrimonio.OrdenesProvisionReportesController.reporteListaLineasRemitos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/productosEnOrden""","""controllers.patrimonio.AnulacionRecepcionProductosController.productosEnOrden(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/ver-lineas""","""controllers.patrimonio.AnulacionRecepcionProductosController.verLineas(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/verLineasNoCertificadas""","""controllers.patrimonio.AnulacionRecepcionProductosController.verLineasNoCertificadas(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/crear""","""controllers.patrimonio.AnulacionRecepcionProductosController.crear(linea_orden_id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/guardar""","""controllers.patrimonio.AnulacionRecepcionProductosController.guardar(linea_orden_id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/editar""","""controllers.patrimonio.AnulacionRecepcionProductosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/eliminar""","""controllers.patrimonio.AnulacionRecepcionProductosController.eliminar(id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/actualizar""","""controllers.patrimonio.AnulacionRecepcionProductosController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/modalBuscar""","""controllers.patrimonio.AnulacionRecepcionProductosController.modalProductosEnOrden(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/get""","""controllers.patrimonio.AnulacionRecepcionProductosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/anularConCliente""","""controllers.patrimonio.AnulacionRecepcionProductosController.anularConCliente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/modalAnularConClientes""","""controllers.patrimonio.AnulacionRecepcionProductosController.modalAnularConClientes()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/controlesAnularConCliente""","""controllers.patrimonio.AnulacionRecepcionProductosController.controlesAnularConCliente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/anular""","""controllers.patrimonio.AnulacionRecepcionProductosController.anular()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anulacion-productos/tienePacientes""","""controllers.patrimonio.AnulacionRecepcionProductosController.tienePacientes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/index""","""controllers.patrimonio.CertificacionesServiciosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/index-ajax""","""controllers.patrimonio.CertificacionesServiciosController.indexAjax()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/ver""","""controllers.patrimonio.CertificacionesServiciosController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/guardar""","""controllers.patrimonio.CertificacionesServiciosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/editar""","""controllers.patrimonio.CertificacionesServiciosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/actualizar""","""controllers.patrimonio.CertificacionesServiciosController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/eliminar""","""controllers.patrimonio.CertificacionesServiciosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/cambiar-estado""","""controllers.patrimonio.CertificacionesServiciosController.cambiarEstado(idCertificacion:Long, idEstado:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/crearDesdeOrdenAjax""","""controllers.patrimonio.CertificacionesServiciosController.crearDesdeOrdenAjax(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/agregarLineasConCliente""","""controllers.patrimonio.CertificacionesServiciosController.agregarLineasConCliente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificaciones/reportes/certificacion""","""controllers.patrimonio.CertificacionesReportesController.reporteCertificacion(idCertificacion:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificacion-linea/index""","""controllers.patrimonio.LineasCertificacionesController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificacion-linea/crear""","""controllers.patrimonio.LineasCertificacionesController.crear(certificacionId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificacion-linea/editar""","""controllers.patrimonio.LineasCertificacionesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificacion-linea/guardar""","""controllers.patrimonio.LineasCertificacionesController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificacion-linea/actualizar""","""controllers.patrimonio.LineasCertificacionesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificacion-linea/eliminar""","""controllers.patrimonio.LineasCertificacionesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """certificacion-linea/getListaLineasPacientes""","""controllers.patrimonio.LineasCertificacionesController.getListaLineasPacientes(certificacionId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/index""","""controllers.patrimonio.RecepcionesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/indexAjax""","""controllers.patrimonio.RecepcionesController.indexAjax()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/ver""","""controllers.patrimonio.RecepcionesController.ver(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/crear""","""controllers.patrimonio.RecepcionesController.crear(orden_provision_id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/guardar""","""controllers.patrimonio.RecepcionesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/editar""","""controllers.patrimonio.RecepcionesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/actualizar""","""controllers.patrimonio.RecepcionesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/eliminar""","""controllers.patrimonio.RecepcionesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/reporteLineasRecepciones""","""controllers.patrimonio.RecepcionesReportesController.reporteLineasRecepciones()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/reporteDatosRecepciones""","""controllers.patrimonio.RecepcionesReportesController.reporteDatosRecepciones()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/modalBuscarRecepcionesDeOrdenes""","""controllers.patrimonio.RecepcionesController.modalBuscarRecepcionesDeOrdenes(idOrdenProvision:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/get""","""controllers.patrimonio.RecepcionesController.get(id:Int ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/modalCargarRemitosMasivos""","""controllers.patrimonio.RecepcionesController.modalCargarRemitosMasivos(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recepciones/cargarRemitosMasivos""","""controllers.patrimonio.RecepcionesController.cargarRemitosMasivos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-baul/index""","""controllers.patrimonio.RemitosBaulController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-baul/ver""","""controllers.patrimonio.RemitosBaulController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-baul/eliminar""","""controllers.patrimonio.RemitosBaulController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-baul/crear""","""controllers.patrimonio.RemitosBaulController.crear()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-baul/guardar""","""controllers.patrimonio.RemitosBaulController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-baul/editar""","""controllers.patrimonio.RemitosBaulController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-baul/actualizar""","""controllers.patrimonio.RemitosBaulController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inventario/index""","""controllers.patrimonio.InventarioController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inventario/registrarModal""","""controllers.patrimonio.InventarioController.registrarModal(remito_linea_id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inventario/eliminar""","""controllers.patrimonio.InventarioController.eliminar(id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inventario/actualizar""","""controllers.patrimonio.InventarioController.actualizar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inventario/guardar""","""controllers.patrimonio.InventarioController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inventario-prefijo/get""","""controllers.patrimonio.PrefijosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inventario-prefijo/modalBuscar""","""controllers.patrimonio.PrefijosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """prefijo/acciones/modificar-modal""","""controllers.patrimonio.PrefijosAccionesController.modificarModal()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """prefijo/acciones/modificar""","""controllers.patrimonio.PrefijosAccionesController.modificar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas-baul/index""","""controllers.patrimonio.RemitosLineasBaulController.index(remito_id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas-baul/eliminar""","""controllers.patrimonio.RemitosLineasBaulController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas-baul/editar""","""controllers.patrimonio.RemitosLineasBaulController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas-baul/actualizar""","""controllers.patrimonio.RemitosLineasBaulController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas-baul/crear""","""controllers.patrimonio.RemitosLineasBaulController.crear(remito_baul_id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas-baul/guardar""","""controllers.patrimonio.RemitosLineasBaulController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/ver""","""controllers.patrimonio.RemitosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/index""","""controllers.patrimonio.RemitosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/indexAjax""","""controllers.patrimonio.RemitosController.indexAjax()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/crear""","""controllers.patrimonio.RemitosController.crear(recepcion_id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/guardar""","""controllers.patrimonio.RemitosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/editar""","""controllers.patrimonio.RemitosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/actualizar""","""controllers.patrimonio.RemitosController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/eliminar""","""controllers.patrimonio.RemitosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/reporteDatosRemitos""","""controllers.patrimonio.RemitosController.reporteDatosRemitos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/reporteDatosRemitosGeneral""","""controllers.patrimonio.RemitosController.reporteDatosRemitosGeneral()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/modalCambiarRecepcion""","""controllers.patrimonio.RemitosController.modalCambiarRecepcion()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos/cambiarRecepcion""","""controllers.patrimonio.RemitosController.cambiarRecepcion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/index""","""controllers.patrimonio.RemitosLineasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/para-agregar""","""controllers.patrimonio.RemitosLineasController.paraAgregar(id_remito:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/para-agregar-cliente""","""controllers.patrimonio.RemitosLineasController.agregarConCliente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/tiene-pacientes""","""controllers.patrimonio.RemitosLineasController.tienePacientes()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/agregar""","""controllers.patrimonio.RemitosLineasController.agregar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/modificar""","""controllers.patrimonio.RemitosLineasController.modificar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/eliminar""","""controllers.patrimonio.RemitosLineasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/en-remito""","""controllers.patrimonio.RemitosLineasController.enRemito(id_remito:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/recepcionar-todos""","""controllers.patrimonio.RemitosLineasController.recepcionarTodos(id_remito:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/controlesAgregarConCliente""","""controllers.patrimonio.RemitosLineasController.controlesAgregarConCliente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remitos-lineas/modalAgregarConClientes""","""controllers.patrimonio.RemitosLineasController.modalAgregarConClientes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/indexAjax""","""controllers.patrimonio.ActasRecepcionController.indexAjax()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/index""","""controllers.patrimonio.ActasRecepcionController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/crear""","""controllers.patrimonio.ActasRecepcionController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/guardar""","""controllers.patrimonio.ActasRecepcionController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/ver""","""controllers.patrimonio.ActasRecepcionController.ver(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/verModal""","""controllers.patrimonio.ActasRecepcionController.verModal(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcionLineas/index""","""controllers.patrimonio.ActasRecepcionLineasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/eliminar""","""controllers.patrimonio.ActasRecepcionController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/editar""","""controllers.patrimonio.ActasRecepcionController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/actualizar""","""controllers.patrimonio.ActasRecepcionController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/cambiarEstado""","""controllers.patrimonio.ActasRecepcionController.cambiarEstado(idActa:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actas-recepcion-reporte/reporte""","""controllers.patrimonio.ActasRecepcionReportesController.reporte(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/reporteLineasActas""","""controllers.patrimonio.ActasRecepcionReportesController.reporteLineasActas()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/reporteGeneralActa""","""controllers.patrimonio.ActasRecepcionReportesController.reporteGeneralActa()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actas-recepcion-reporte/reporteActaCierre""","""controllers.patrimonio.ActasRecepcionReportesController.reporteActaCierre(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actas-recepcion-reporte/modalListadoInventariable""","""controllers.patrimonio.ActasRecepcionReportesController.modalListadoInventariable()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actas-recepcion-reporte/informeListadoInventariable""","""controllers.patrimonio.ActasRecepcionReportesController.informeListadoInventariable()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcion/modal-crear""","""controllers.patrimonio.ActasRecepcionAccionesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcion/modal-guardar""","""controllers.patrimonio.ActasRecepcionAccionesController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcion/revocar""","""controllers.patrimonio.ActasRecepcionAccionesController.revocar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcion/modal-asignar""","""controllers.patrimonio.ActasRecepcionAccionesController.modalAsignar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcion/asignar""","""controllers.patrimonio.ActasRecepcionAccionesController.asignar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcionCertificaciones/modal-crear""","""controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcionCertificaciones/modal-guardar""","""controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcionCertificaciones/revocar""","""controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.revocar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcionCertificaciones/modal-asignar""","""controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.modalAsignar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acciones/actasRecepcionCertificaciones/asignar""","""controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.asignar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/index""","""controllers.patrimonio.ActasMovimientosController.index(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/crear""","""controllers.patrimonio.ActasMovimientosController.crear(actaId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/editar""","""controllers.patrimonio.ActasMovimientosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/guardar""","""controllers.patrimonio.ActasMovimientosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/actualizar""","""controllers.patrimonio.ActasMovimientosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/eliminar""","""controllers.patrimonio.ActasMovimientosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/indexGeneral""","""controllers.patrimonio.ActasMovimientosController.indexGeneral()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/indexPasesPorUsuario""","""controllers.patrimonio.ActasMovimientosController.indexPasesPorUsuario()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/modalPasarOtroServicio""","""controllers.patrimonio.ActasMovimientosController.modalPasarOtroServicio()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/modalPasarOtroServicioIndividual""","""controllers.patrimonio.ActasMovimientosController.modalPasarOtroServicioIndividual(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/pasarOtroServicio""","""controllers.patrimonio.ActasMovimientosController.pasarOtroServicio()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/cancelarPase""","""controllers.patrimonio.ActasMovimientosController.cancelarPase(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/asignarMiServicio""","""controllers.patrimonio.ActasMovimientosController.asignarMiServicio(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/cancelarPaseLista""","""controllers.patrimonio.ActasMovimientosController.cancelarPaseLista()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/modalAsignarMiServicio""","""controllers.patrimonio.ActasMovimientosController.modalAsignarMiServicio()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/asignarMiServicioMasivo""","""controllers.patrimonio.ActasMovimientosController.asignarAMiServicioMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/modalCierreCircuitoIndividual""","""controllers.patrimonio.ActasMovimientosController.modalCierreCircuitoIndividual(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/modalCierreCircuito""","""controllers.patrimonio.ActasMovimientosController.modalCierreCircuito()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/cierreCircuito""","""controllers.patrimonio.ActasMovimientosController.cierreCircuito()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/aceptarPase""","""controllers.patrimonio.ActasMovimientosController.aceptarPase(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/movimiento-linea/rechazarPase""","""controllers.patrimonio.ActasMovimientosController.rechazarPase(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """actasRecepcion/getPacientes""","""controllers.patrimonio.ActasRecepcionController.getPacientes(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acta-linea-ajuste/index""","""controllers.patrimonio.ActaRecepcionLineaAjusteController.index(acta_id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acta-linea-ajuste/crear""","""controllers.patrimonio.ActaRecepcionLineaAjusteController.crear(actaId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acta-linea-ajuste/editar""","""controllers.patrimonio.ActaRecepcionLineaAjusteController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acta-linea-ajuste/guardar""","""controllers.patrimonio.ActaRecepcionLineaAjusteController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acta-linea-ajuste/actualizar""","""controllers.patrimonio.ActaRecepcionLineaAjusteController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """acta-linea-ajuste/eliminar""","""controllers.patrimonio.ActaRecepcionLineaAjusteController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestOrdenProvision/$input<[^/]+>""","""controllers.patrimonio.OrdenesProvisionController.suggestOrdenProvision(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestPrefijo/$input<[^/]+>""","""controllers.patrimonio.PrefijosController.suggest(input:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:1
case controllers_patrimonio_IndexController_index0(params) => {
   call { 
        invokeHandler(controllers.patrimonio.IndexController.index(), HandlerDef(this, "controllers.patrimonio.IndexController", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:2
case controllers_patrimonio_OrdenesProvisionController_index1(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.index(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "index", Nil,"GET", """""", Routes.prefix + """ordenesProvision/index"""))
   }
}
        

// @LINE:3
case controllers_patrimonio_OrdenesProvisionController_ver2(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Long]("idActa", Some(0))) { (id, idActa) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.ver(id, idActa), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "ver", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/ver"""))
   }
}
        

// @LINE:4
case controllers_patrimonio_OrdenesProvisionController_verProductosSolicitados3(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.verProductosSolicitados(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "verProductosSolicitados", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/ver-productos-solicitados"""))
   }
}
        

// @LINE:5
case controllers_patrimonio_OrdenesProvisionController_productosRecepcionados4(params) => {
   call(params.fromQuery[Long]("orden_provision_id", Some(0))) { (orden_provision_id) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.productosRecepcionados(orden_provision_id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "productosRecepcionados", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/productosRecepcionados"""))
   }
}
        

// @LINE:6
case controllers_patrimonio_OrdenesProvisionController_editar5(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.editar(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/editar"""))
   }
}
        

// @LINE:7
case controllers_patrimonio_OrdenesProvisionController_actualizar6(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.actualizar(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "actualizar", Nil,"POST", """""", Routes.prefix + """ordenesProvision/actualizar"""))
   }
}
        

// @LINE:8
case controllers_patrimonio_OrdenesProvisionController_eliminar7(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.eliminar(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/eliminar"""))
   }
}
        

// @LINE:9
case controllers_patrimonio_OrdenesProvisionReportesController_ordenDeProvision8(params) => {
   call(params.fromQuery[Long]("idOrdenProvision", None), params.fromQuery[Boolean]("sinMonto", Some(false))) { (idOrdenProvision, sinMonto) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionReportesController.ordenDeProvision(idOrdenProvision, sinMonto), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "ordenDeProvision", Seq(classOf[Long], classOf[Boolean]),"POST", """""", Routes.prefix + """ordenesProvision/reproteOrdenProvision"""))
   }
}
        

// @LINE:10
case controllers_patrimonio_OrdenesProvisionReportesController_informeInventariable9(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionReportesController.informeInventariable(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "informeInventariable", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/informeInventariable"""))
   }
}
        

// @LINE:11
case controllers_patrimonio_OrdenesProvisionReportesController_informePendiente10(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionReportesController.informePendiente(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "informePendiente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/informePendiente"""))
   }
}
        

// @LINE:12
case controllers_patrimonio_OrdenesProvisionReportesController_informeGeneral11(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionReportesController.informeGeneral(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "informeGeneral", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/informeGeneral"""))
   }
}
        

// @LINE:13
case controllers_patrimonio_OrdenesProvisionController_getRecepciones12(params) => {
   call(params.fromQuery[Long]("orden_provision_id", Some(0))) { (orden_provision_id) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.getRecepciones(orden_provision_id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "getRecepciones", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/getRecepciones"""))
   }
}
        

// @LINE:15
case controllers_patrimonio_OrdenesProvisionController_getLastNumeroProvision13(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.getLastNumeroProvision(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "getLastNumeroProvision", Nil,"POST", """""", Routes.prefix + """ordenesProvision/getLastNumeroProvision"""))
   }
}
        

// @LINE:17
case controllers_patrimonio_OrdenesProvisionController_modalAnularProductosPedientes14(params) => {
   call(params.fromQuery[Long]("ordenId", None)) { (ordenId) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.modalAnularProductosPedientes(ordenId), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "modalAnularProductosPedientes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/modalAnularProductosPedientes"""))
   }
}
        

// @LINE:18
case controllers_patrimonio_OrdenesProvisionController_anularProductosPediente15(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.anularProductosPediente(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "anularProductosPediente", Nil,"POST", """""", Routes.prefix + """ordenesProvision/anularProductosPediente"""))
   }
}
        

// @LINE:20
case controllers_patrimonio_OrdenesProvisionController_modalCrearActasDeAjustes16(params) => {
   call(params.fromQuery[Long]("ordenId", None)) { (ordenId) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.modalCrearActasDeAjustes(ordenId), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "modalCrearActasDeAjustes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenesProvision/modalCrearActasDeAjustes"""))
   }
}
        

// @LINE:21
case controllers_patrimonio_OrdenesProvisionController_crearActasDeAjustes17(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.crearActasDeAjustes(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "crearActasDeAjustes", Nil,"POST", """""", Routes.prefix + """ordenesProvision/crearActasDeAjustes"""))
   }
}
        

// @LINE:23
case controllers_patrimonio_OrdenesProvisionController_informacionPorPacientes18(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.informacionPorPacientes(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "informacionPorPacientes", Nil,"GET", """""", Routes.prefix + """ordenesProvision/informacionPorPacientes"""))
   }
}
        

// @LINE:24
case controllers_patrimonio_OrdenesProvisionController_informacionPorPacientesExcel19(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.informacionPorPacientesExcel(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "informacionPorPacientesExcel", Nil,"GET", """""", Routes.prefix + """ordenesProvision/informacionPorPacientesExcel"""))
   }
}
        

// @LINE:26
case controllers_patrimonio_OrdenesProvisionReportesController_notaCierre20(params) => {
   call(params.fromQuery[Long]("idOrdenProvision", None), params.fromQuery[Int]("n", Some(0))) { (idOrdenProvision, n) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionReportesController.notaCierre(idOrdenProvision, n), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "notaCierre", Seq(classOf[Long], classOf[Int]),"POST", """""", Routes.prefix + """ordenesProvision/reproteNotaCierre"""))
   }
}
        

// @LINE:27
case controllers_patrimonio_OrdenesProvisionReportesController_reporteAnulados21(params) => {
   call(params.fromQuery[Long]("idOrdenProvision", None)) { (idOrdenProvision) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionReportesController.reporteAnulados(idOrdenProvision), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "reporteAnulados", Seq(classOf[Long]),"POST", """""", Routes.prefix + """ordenesProvision/reporteAnulados"""))
   }
}
        

// @LINE:29
case controllers_patrimonio_OrdenesProvisionController_modalBuscar22(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.modalBuscar(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """ordenesProvision/modalBuscar"""))
   }
}
        

// @LINE:30
case controllers_patrimonio_OrdenesProvisionController_get23(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.get(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """ordenesProvision/get"""))
   }
}
        

// @LINE:32
case controllers_patrimonio_OrdenesProvisionReportesController_reporteGeneralOp24(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionReportesController.reporteGeneralOp(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "reporteGeneralOp", Nil,"POST", """""", Routes.prefix + """patrimonio/ordenesProvision/reporteGeneralOp"""))
   }
}
        

// @LINE:33
case controllers_patrimonio_OrdenesProvisionReportesController_reporteListaLineasRemitos25(params) => {
   call { 
        invokeHandler(controllers.patrimonio.OrdenesProvisionReportesController.reporteListaLineasRemitos(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "reporteListaLineasRemitos", Nil,"POST", """""", Routes.prefix + """patrimonio/ordenesProvision/reporteListaLineasRemitos"""))
   }
}
        

// @LINE:35
case controllers_patrimonio_AnulacionRecepcionProductosController_productosEnOrden26(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.productosEnOrden(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "productosEnOrden", Seq(classOf[Long]),"GET", """""", Routes.prefix + """anulacion-productos/productosEnOrden"""))
   }
}
        

// @LINE:36
case controllers_patrimonio_AnulacionRecepcionProductosController_verLineas27(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.verLineas(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "verLineas", Seq(classOf[Long]),"GET", """""", Routes.prefix + """anulacion-productos/ver-lineas"""))
   }
}
        

// @LINE:37
case controllers_patrimonio_AnulacionRecepcionProductosController_verLineasNoCertificadas28(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.verLineasNoCertificadas(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "verLineasNoCertificadas", Seq(classOf[Long]),"GET", """""", Routes.prefix + """anulacion-productos/verLineasNoCertificadas"""))
   }
}
        

// @LINE:38
case controllers_patrimonio_AnulacionRecepcionProductosController_crear29(params) => {
   call(params.fromQuery[Long]("linea_orden_id", None)) { (linea_orden_id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.crear(linea_orden_id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "crear", Seq(classOf[Long]),"GET", """""", Routes.prefix + """anulacion-productos/crear"""))
   }
}
        

// @LINE:39
case controllers_patrimonio_AnulacionRecepcionProductosController_guardar30(params) => {
   call(params.fromQuery[Long]("linea_orden_id", None)) { (linea_orden_id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.guardar(linea_orden_id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "guardar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """anulacion-productos/guardar"""))
   }
}
        

// @LINE:40
case controllers_patrimonio_AnulacionRecepcionProductosController_editar31(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.editar(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """anulacion-productos/editar"""))
   }
}
        

// @LINE:41
case controllers_patrimonio_AnulacionRecepcionProductosController_eliminar32(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.eliminar(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """anulacion-productos/eliminar"""))
   }
}
        

// @LINE:42
case controllers_patrimonio_AnulacionRecepcionProductosController_actualizar33(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.actualizar(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """anulacion-productos/actualizar"""))
   }
}
        

// @LINE:43
case controllers_patrimonio_AnulacionRecepcionProductosController_modalProductosEnOrden34(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.modalProductosEnOrden(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "modalProductosEnOrden", Seq(classOf[Long]),"GET", """""", Routes.prefix + """anulacion-productos/modalBuscar"""))
   }
}
        

// @LINE:44
case controllers_patrimonio_AnulacionRecepcionProductosController_get35(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.get(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """anulacion-productos/get"""))
   }
}
        

// @LINE:45
case controllers_patrimonio_AnulacionRecepcionProductosController_anularConCliente36(params) => {
   call { 
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.anularConCliente(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "anularConCliente", Nil,"GET", """""", Routes.prefix + """anulacion-productos/anularConCliente"""))
   }
}
        

// @LINE:46
case controllers_patrimonio_AnulacionRecepcionProductosController_modalAnularConClientes37(params) => {
   call { 
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.modalAnularConClientes(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "modalAnularConClientes", Nil,"GET", """""", Routes.prefix + """anulacion-productos/modalAnularConClientes"""))
   }
}
        

// @LINE:47
case controllers_patrimonio_AnulacionRecepcionProductosController_controlesAnularConCliente38(params) => {
   call { 
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.controlesAnularConCliente(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "controlesAnularConCliente", Nil,"POST", """""", Routes.prefix + """anulacion-productos/controlesAnularConCliente"""))
   }
}
        

// @LINE:48
case controllers_patrimonio_AnulacionRecepcionProductosController_anular39(params) => {
   call { 
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.anular(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "anular", Nil,"POST", """""", Routes.prefix + """anulacion-productos/anular"""))
   }
}
        

// @LINE:49
case controllers_patrimonio_AnulacionRecepcionProductosController_tienePacientes40(params) => {
   call { 
        invokeHandler(controllers.patrimonio.AnulacionRecepcionProductosController.tienePacientes(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "tienePacientes", Nil,"GET", """""", Routes.prefix + """anulacion-productos/tienePacientes"""))
   }
}
        

// @LINE:51
case controllers_patrimonio_CertificacionesServiciosController_index41(params) => {
   call { 
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.index(), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "index", Nil,"GET", """""", Routes.prefix + """certificaciones/index"""))
   }
}
        

// @LINE:52
case controllers_patrimonio_CertificacionesServiciosController_indexAjax42(params) => {
   call { 
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.indexAjax(), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "indexAjax", Nil,"GET", """""", Routes.prefix + """certificaciones/index-ajax"""))
   }
}
        

// @LINE:53
case controllers_patrimonio_CertificacionesServiciosController_ver43(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.ver(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """certificaciones/ver"""))
   }
}
        

// @LINE:55
case controllers_patrimonio_CertificacionesServiciosController_guardar44(params) => {
   call { 
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.guardar(), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "guardar", Nil,"POST", """GET    /certificaciones/crear             			controllers.patrimonio.CertificacionesServiciosController.crear(linea_orden_id:Long ?= 0)""", Routes.prefix + """certificaciones/guardar"""))
   }
}
        

// @LINE:56
case controllers_patrimonio_CertificacionesServiciosController_editar45(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.editar(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """certificaciones/editar"""))
   }
}
        

// @LINE:57
case controllers_patrimonio_CertificacionesServiciosController_actualizar46(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.actualizar(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """certificaciones/actualizar"""))
   }
}
        

// @LINE:58
case controllers_patrimonio_CertificacionesServiciosController_eliminar47(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.eliminar(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """certificaciones/eliminar"""))
   }
}
        

// @LINE:59
case controllers_patrimonio_CertificacionesServiciosController_cambiarEstado48(params) => {
   call(params.fromQuery[Long]("idCertificacion", None), params.fromQuery[Long]("idEstado", None)) { (idCertificacion, idEstado) =>
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.cambiarEstado(idCertificacion, idEstado), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """certificaciones/cambiar-estado"""))
   }
}
        

// @LINE:60
case controllers_patrimonio_CertificacionesServiciosController_crearDesdeOrdenAjax49(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.crearDesdeOrdenAjax(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "crearDesdeOrdenAjax", Seq(classOf[Long]),"POST", """""", Routes.prefix + """certificaciones/crearDesdeOrdenAjax"""))
   }
}
        

// @LINE:61
case controllers_patrimonio_CertificacionesServiciosController_agregarLineasConCliente50(params) => {
   call { 
        invokeHandler(controllers.patrimonio.CertificacionesServiciosController.agregarLineasConCliente(), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "agregarLineasConCliente", Nil,"POST", """""", Routes.prefix + """certificaciones/agregarLineasConCliente"""))
   }
}
        

// @LINE:63
case controllers_patrimonio_CertificacionesReportesController_reporteCertificacion51(params) => {
   call(params.fromQuery[Long]("idCertificacion", None)) { (idCertificacion) =>
        invokeHandler(controllers.patrimonio.CertificacionesReportesController.reporteCertificacion(idCertificacion), HandlerDef(this, "controllers.patrimonio.CertificacionesReportesController", "reporteCertificacion", Seq(classOf[Long]),"GET", """""", Routes.prefix + """certificaciones/reportes/certificacion"""))
   }
}
        

// @LINE:66
case controllers_patrimonio_LineasCertificacionesController_index52(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.patrimonio.LineasCertificacionesController.index(id, editable), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """certificacion-linea/index"""))
   }
}
        

// @LINE:67
case controllers_patrimonio_LineasCertificacionesController_crear53(params) => {
   call(params.fromQuery[String]("certificacionId", None)) { (certificacionId) =>
        invokeHandler(controllers.patrimonio.LineasCertificacionesController.crear(certificacionId), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """certificacion-linea/crear"""))
   }
}
        

// @LINE:68
case controllers_patrimonio_LineasCertificacionesController_editar54(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.LineasCertificacionesController.editar(id), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """certificacion-linea/editar"""))
   }
}
        

// @LINE:69
case controllers_patrimonio_LineasCertificacionesController_guardar55(params) => {
   call { 
        invokeHandler(controllers.patrimonio.LineasCertificacionesController.guardar(), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "guardar", Nil,"POST", """""", Routes.prefix + """certificacion-linea/guardar"""))
   }
}
        

// @LINE:70
case controllers_patrimonio_LineasCertificacionesController_actualizar56(params) => {
   call { 
        invokeHandler(controllers.patrimonio.LineasCertificacionesController.actualizar(), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "actualizar", Nil,"POST", """""", Routes.prefix + """certificacion-linea/actualizar"""))
   }
}
        

// @LINE:71
case controllers_patrimonio_LineasCertificacionesController_eliminar57(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.LineasCertificacionesController.eliminar(id), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """certificacion-linea/eliminar"""))
   }
}
        

// @LINE:72
case controllers_patrimonio_LineasCertificacionesController_getListaLineasPacientes58(params) => {
   call(params.fromQuery[Long]("certificacionId", None)) { (certificacionId) =>
        invokeHandler(controllers.patrimonio.LineasCertificacionesController.getListaLineasPacientes(certificacionId), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "getListaLineasPacientes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """certificacion-linea/getListaLineasPacientes"""))
   }
}
        

// @LINE:74
case controllers_patrimonio_RecepcionesController_index59(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RecepcionesController.index(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "index", Nil,"GET", """""", Routes.prefix + """recepciones/index"""))
   }
}
        

// @LINE:75
case controllers_patrimonio_RecepcionesController_indexAjax60(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RecepcionesController.indexAjax(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "indexAjax", Nil,"GET", """""", Routes.prefix + """recepciones/indexAjax"""))
   }
}
        

// @LINE:76
case controllers_patrimonio_RecepcionesController_ver61(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.RecepcionesController.ver(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """recepciones/ver"""))
   }
}
        

// @LINE:77
case controllers_patrimonio_RecepcionesController_crear62(params) => {
   call(params.fromQuery[Long]("orden_provision_id", Some(0))) { (orden_provision_id) =>
        invokeHandler(controllers.patrimonio.RecepcionesController.crear(orden_provision_id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "crear", Seq(classOf[Long]),"GET", """""", Routes.prefix + """recepciones/crear"""))
   }
}
        

// @LINE:78
case controllers_patrimonio_RecepcionesController_guardar63(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RecepcionesController.guardar(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "guardar", Nil,"POST", """""", Routes.prefix + """recepciones/guardar"""))
   }
}
        

// @LINE:79
case controllers_patrimonio_RecepcionesController_editar64(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RecepcionesController.editar(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """recepciones/editar"""))
   }
}
        

// @LINE:80
case controllers_patrimonio_RecepcionesController_actualizar65(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RecepcionesController.actualizar(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "actualizar", Nil,"POST", """""", Routes.prefix + """recepciones/actualizar"""))
   }
}
        

// @LINE:81
case controllers_patrimonio_RecepcionesController_eliminar66(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RecepcionesController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """recepciones/eliminar"""))
   }
}
        

// @LINE:82
case controllers_patrimonio_RecepcionesReportesController_reporteLineasRecepciones67(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RecepcionesReportesController.reporteLineasRecepciones(), HandlerDef(this, "controllers.patrimonio.RecepcionesReportesController", "reporteLineasRecepciones", Nil,"POST", """""", Routes.prefix + """recepciones/reporteLineasRecepciones"""))
   }
}
        

// @LINE:83
case controllers_patrimonio_RecepcionesReportesController_reporteDatosRecepciones68(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RecepcionesReportesController.reporteDatosRecepciones(), HandlerDef(this, "controllers.patrimonio.RecepcionesReportesController", "reporteDatosRecepciones", Nil,"POST", """""", Routes.prefix + """recepciones/reporteDatosRecepciones"""))
   }
}
        

// @LINE:85
case controllers_patrimonio_RecepcionesController_modalBuscarRecepcionesDeOrdenes69(params) => {
   call(params.fromQuery[Long]("idOrdenProvision", Some(0))) { (idOrdenProvision) =>
        invokeHandler(controllers.patrimonio.RecepcionesController.modalBuscarRecepcionesDeOrdenes(idOrdenProvision), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "modalBuscarRecepcionesDeOrdenes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """recepciones/modalBuscarRecepcionesDeOrdenes"""))
   }
}
        

// @LINE:86
case controllers_patrimonio_RecepcionesController_get70(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.RecepcionesController.get(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """recepciones/get"""))
   }
}
        

// @LINE:87
case controllers_patrimonio_RecepcionesController_modalCargarRemitosMasivos71(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RecepcionesController.modalCargarRemitosMasivos(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "modalCargarRemitosMasivos", Seq(classOf[Long]),"POST", """""", Routes.prefix + """recepciones/modalCargarRemitosMasivos"""))
   }
}
        

// @LINE:88
case controllers_patrimonio_RecepcionesController_cargarRemitosMasivos72(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RecepcionesController.cargarRemitosMasivos(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "cargarRemitosMasivos", Nil,"POST", """""", Routes.prefix + """recepciones/cargarRemitosMasivos"""))
   }
}
        

// @LINE:90
case controllers_patrimonio_RemitosBaulController_index73(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosBaulController.index(), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "index", Nil,"GET", """""", Routes.prefix + """remitos-baul/index"""))
   }
}
        

// @LINE:91
case controllers_patrimonio_RemitosBaulController_ver74(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosBaulController.ver(id), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-baul/ver"""))
   }
}
        

// @LINE:92
case controllers_patrimonio_RemitosBaulController_eliminar75(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosBaulController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-baul/eliminar"""))
   }
}
        

// @LINE:93
case controllers_patrimonio_RemitosBaulController_crear76(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosBaulController.crear(), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "crear", Nil,"GET", """""", Routes.prefix + """remitos-baul/crear"""))
   }
}
        

// @LINE:94
case controllers_patrimonio_RemitosBaulController_guardar77(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosBaulController.guardar(), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "guardar", Nil,"GET", """""", Routes.prefix + """remitos-baul/guardar"""))
   }
}
        

// @LINE:95
case controllers_patrimonio_RemitosBaulController_editar78(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosBaulController.editar(id), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-baul/editar"""))
   }
}
        

// @LINE:96
case controllers_patrimonio_RemitosBaulController_actualizar79(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosBaulController.actualizar(), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "actualizar", Nil,"GET", """""", Routes.prefix + """remitos-baul/actualizar"""))
   }
}
        

// @LINE:98
case controllers_patrimonio_InventarioController_index80(params) => {
   call { 
        invokeHandler(controllers.patrimonio.InventarioController.index(), HandlerDef(this, "controllers.patrimonio.InventarioController", "index", Nil,"GET", """""", Routes.prefix + """inventario/index"""))
   }
}
        

// @LINE:99
case controllers_patrimonio_InventarioController_registrarModal81(params) => {
   call(params.fromQuery[Long]("remito_linea_id", None)) { (remito_linea_id) =>
        invokeHandler(controllers.patrimonio.InventarioController.registrarModal(remito_linea_id), HandlerDef(this, "controllers.patrimonio.InventarioController", "registrarModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """inventario/registrarModal"""))
   }
}
        

// @LINE:100
case controllers_patrimonio_InventarioController_eliminar82(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.InventarioController.eliminar(id), HandlerDef(this, "controllers.patrimonio.InventarioController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """inventario/eliminar"""))
   }
}
        

// @LINE:101
case controllers_patrimonio_InventarioController_actualizar83(params) => {
   call { 
        invokeHandler(controllers.patrimonio.InventarioController.actualizar(), HandlerDef(this, "controllers.patrimonio.InventarioController", "actualizar", Nil,"POST", """""", Routes.prefix + """inventario/actualizar"""))
   }
}
        

// @LINE:102
case controllers_patrimonio_InventarioController_guardar84(params) => {
   call { 
        invokeHandler(controllers.patrimonio.InventarioController.guardar(), HandlerDef(this, "controllers.patrimonio.InventarioController", "guardar", Nil,"POST", """""", Routes.prefix + """inventario/guardar"""))
   }
}
        

// @LINE:104
case controllers_patrimonio_PrefijosController_get85(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.PrefijosController.get(id), HandlerDef(this, "controllers.patrimonio.PrefijosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """inventario-prefijo/get"""))
   }
}
        

// @LINE:105
case controllers_patrimonio_PrefijosController_modalBuscar86(params) => {
   call { 
        invokeHandler(controllers.patrimonio.PrefijosController.modalBuscar(), HandlerDef(this, "controllers.patrimonio.PrefijosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """inventario-prefijo/modalBuscar"""))
   }
}
        

// @LINE:107
case controllers_patrimonio_PrefijosAccionesController_modificarModal87(params) => {
   call { 
        invokeHandler(controllers.patrimonio.PrefijosAccionesController.modificarModal(), HandlerDef(this, "controllers.patrimonio.PrefijosAccionesController", "modificarModal", Nil,"GET", """""", Routes.prefix + """prefijo/acciones/modificar-modal"""))
   }
}
        

// @LINE:108
case controllers_patrimonio_PrefijosAccionesController_modificar88(params) => {
   call { 
        invokeHandler(controllers.patrimonio.PrefijosAccionesController.modificar(), HandlerDef(this, "controllers.patrimonio.PrefijosAccionesController", "modificar", Nil,"GET", """""", Routes.prefix + """prefijo/acciones/modificar"""))
   }
}
        

// @LINE:111
case controllers_patrimonio_RemitosLineasBaulController_index89(params) => {
   call(params.fromQuery[Long]("remito_id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (remito_id, editable) =>
        invokeHandler(controllers.patrimonio.RemitosLineasBaulController.index(remito_id, editable), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """remitos-lineas-baul/index"""))
   }
}
        

// @LINE:112
case controllers_patrimonio_RemitosLineasBaulController_eliminar90(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosLineasBaulController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-lineas-baul/eliminar"""))
   }
}
        

// @LINE:113
case controllers_patrimonio_RemitosLineasBaulController_editar91(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosLineasBaulController.editar(id), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-lineas-baul/editar"""))
   }
}
        

// @LINE:114
case controllers_patrimonio_RemitosLineasBaulController_actualizar92(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosLineasBaulController.actualizar(), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "actualizar", Nil,"POST", """""", Routes.prefix + """remitos-lineas-baul/actualizar"""))
   }
}
        

// @LINE:115
case controllers_patrimonio_RemitosLineasBaulController_crear93(params) => {
   call(params.fromQuery[Long]("remito_baul_id", None)) { (remito_baul_id) =>
        invokeHandler(controllers.patrimonio.RemitosLineasBaulController.crear(remito_baul_id), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "crear", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-lineas-baul/crear"""))
   }
}
        

// @LINE:116
case controllers_patrimonio_RemitosLineasBaulController_guardar94(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosLineasBaulController.guardar(), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "guardar", Nil,"POST", """""", Routes.prefix + """remitos-lineas-baul/guardar"""))
   }
}
        

// @LINE:118
case controllers_patrimonio_RemitosController_ver95(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosController.ver(id), HandlerDef(this, "controllers.patrimonio.RemitosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos/ver"""))
   }
}
        

// @LINE:119
case controllers_patrimonio_RemitosController_index96(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosController.index(), HandlerDef(this, "controllers.patrimonio.RemitosController", "index", Nil,"GET", """""", Routes.prefix + """remitos/index"""))
   }
}
        

// @LINE:120
case controllers_patrimonio_RemitosController_indexAjax97(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosController.indexAjax(), HandlerDef(this, "controllers.patrimonio.RemitosController", "indexAjax", Nil,"GET", """""", Routes.prefix + """remitos/indexAjax"""))
   }
}
        

// @LINE:121
case controllers_patrimonio_RemitosController_crear98(params) => {
   call(params.fromQuery[Long]("recepcion_id", None)) { (recepcion_id) =>
        invokeHandler(controllers.patrimonio.RemitosController.crear(recepcion_id), HandlerDef(this, "controllers.patrimonio.RemitosController", "crear", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos/crear"""))
   }
}
        

// @LINE:122
case controllers_patrimonio_RemitosController_guardar99(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosController.guardar(), HandlerDef(this, "controllers.patrimonio.RemitosController", "guardar", Nil,"POST", """""", Routes.prefix + """remitos/guardar"""))
   }
}
        

// @LINE:123
case controllers_patrimonio_RemitosController_editar100(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosController.editar(id), HandlerDef(this, "controllers.patrimonio.RemitosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos/editar"""))
   }
}
        

// @LINE:124
case controllers_patrimonio_RemitosController_actualizar101(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosController.actualizar(id), HandlerDef(this, "controllers.patrimonio.RemitosController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """remitos/actualizar"""))
   }
}
        

// @LINE:125
case controllers_patrimonio_RemitosController_eliminar102(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RemitosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos/eliminar"""))
   }
}
        

// @LINE:126
case controllers_patrimonio_RemitosController_reporteDatosRemitos103(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosController.reporteDatosRemitos(), HandlerDef(this, "controllers.patrimonio.RemitosController", "reporteDatosRemitos", Nil,"POST", """""", Routes.prefix + """remitos/reporteDatosRemitos"""))
   }
}
        

// @LINE:127
case controllers_patrimonio_RemitosController_reporteDatosRemitosGeneral104(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosController.reporteDatosRemitosGeneral(), HandlerDef(this, "controllers.patrimonio.RemitosController", "reporteDatosRemitosGeneral", Nil,"POST", """""", Routes.prefix + """remitos/reporteDatosRemitosGeneral"""))
   }
}
        

// @LINE:129
case controllers_patrimonio_RemitosController_modalCambiarRecepcion105(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosController.modalCambiarRecepcion(), HandlerDef(this, "controllers.patrimonio.RemitosController", "modalCambiarRecepcion", Nil,"POST", """""", Routes.prefix + """remitos/modalCambiarRecepcion"""))
   }
}
        

// @LINE:130
case controllers_patrimonio_RemitosController_cambiarRecepcion106(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosController.cambiarRecepcion(), HandlerDef(this, "controllers.patrimonio.RemitosController", "cambiarRecepcion", Nil,"POST", """""", Routes.prefix + """remitos/cambiarRecepcion"""))
   }
}
        

// @LINE:132
case controllers_patrimonio_RemitosLineasController_index107(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosLineasController.index(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "index", Nil,"GET", """""", Routes.prefix + """remitos-lineas/index"""))
   }
}
        

// @LINE:133
case controllers_patrimonio_RemitosLineasController_paraAgregar108(params) => {
   call(params.fromQuery[Long]("id_remito", Some(0))) { (id_remito) =>
        invokeHandler(controllers.patrimonio.RemitosLineasController.paraAgregar(id_remito), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "paraAgregar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-lineas/para-agregar"""))
   }
}
        

// @LINE:134
case controllers_patrimonio_RemitosLineasController_agregarConCliente109(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosLineasController.agregarConCliente(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "agregarConCliente", Nil,"GET", """""", Routes.prefix + """remitos-lineas/para-agregar-cliente"""))
   }
}
        

// @LINE:135
case controllers_patrimonio_RemitosLineasController_tienePacientes110(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosLineasController.tienePacientes(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "tienePacientes", Nil,"GET", """""", Routes.prefix + """remitos-lineas/tiene-pacientes"""))
   }
}
        

// @LINE:136
case controllers_patrimonio_RemitosLineasController_agregar111(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosLineasController.agregar(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "agregar", Nil,"POST", """""", Routes.prefix + """remitos-lineas/agregar"""))
   }
}
        

// @LINE:137
case controllers_patrimonio_RemitosLineasController_modificar112(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosLineasController.modificar(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "modificar", Nil,"POST", """""", Routes.prefix + """remitos-lineas/modificar"""))
   }
}
        

// @LINE:138
case controllers_patrimonio_RemitosLineasController_eliminar113(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.RemitosLineasController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-lineas/eliminar"""))
   }
}
        

// @LINE:139
case controllers_patrimonio_RemitosLineasController_enRemito114(params) => {
   call(params.fromQuery[Long]("id_remito", Some(0))) { (id_remito) =>
        invokeHandler(controllers.patrimonio.RemitosLineasController.enRemito(id_remito), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "enRemito", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-lineas/en-remito"""))
   }
}
        

// @LINE:140
case controllers_patrimonio_RemitosLineasController_recepcionarTodos115(params) => {
   call(params.fromQuery[Long]("id_remito", Some(0))) { (id_remito) =>
        invokeHandler(controllers.patrimonio.RemitosLineasController.recepcionarTodos(id_remito), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "recepcionarTodos", Seq(classOf[Long]),"GET", """""", Routes.prefix + """remitos-lineas/recepcionar-todos"""))
   }
}
        

// @LINE:141
case controllers_patrimonio_RemitosLineasController_controlesAgregarConCliente116(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosLineasController.controlesAgregarConCliente(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "controlesAgregarConCliente", Nil,"POST", """""", Routes.prefix + """remitos-lineas/controlesAgregarConCliente"""))
   }
}
        

// @LINE:142
case controllers_patrimonio_RemitosLineasController_modalAgregarConClientes117(params) => {
   call { 
        invokeHandler(controllers.patrimonio.RemitosLineasController.modalAgregarConClientes(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "modalAgregarConClientes", Nil,"GET", """""", Routes.prefix + """remitos-lineas/modalAgregarConClientes"""))
   }
}
        

// @LINE:147
case controllers_patrimonio_ActasRecepcionController_indexAjax118(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionController.indexAjax(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "indexAjax", Nil,"GET", """""", Routes.prefix + """actasRecepcion/indexAjax"""))
   }
}
        

// @LINE:148
case controllers_patrimonio_ActasRecepcionController_index119(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionController.index(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "index", Nil,"GET", """""", Routes.prefix + """actasRecepcion/index"""))
   }
}
        

// @LINE:149
case controllers_patrimonio_ActasRecepcionController_crear120(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionController.crear(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "crear", Nil,"GET", """""", Routes.prefix + """actasRecepcion/crear"""))
   }
}
        

// @LINE:150
case controllers_patrimonio_ActasRecepcionController_guardar121(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionController.guardar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "guardar", Nil,"POST", """""", Routes.prefix + """actasRecepcion/guardar"""))
   }
}
        

// @LINE:151
case controllers_patrimonio_ActasRecepcionController_ver122(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.ActasRecepcionController.ver(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/ver"""))
   }
}
        

// @LINE:152
case controllers_patrimonio_ActasRecepcionController_verModal123(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.ActasRecepcionController.verModal(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "verModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/verModal"""))
   }
}
        

// @LINE:153
case controllers_patrimonio_ActasRecepcionLineasController_index124(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionLineasController.index(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionLineasController", "index", Nil,"GET", """""", Routes.prefix + """actasRecepcionLineas/index"""))
   }
}
        

// @LINE:154
case controllers_patrimonio_ActasRecepcionController_eliminar125(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasRecepcionController.eliminar(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/eliminar"""))
   }
}
        

// @LINE:155
case controllers_patrimonio_ActasRecepcionController_editar126(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasRecepcionController.editar(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/editar"""))
   }
}
        

// @LINE:156
case controllers_patrimonio_ActasRecepcionController_actualizar127(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionController.actualizar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "actualizar", Nil,"POST", """""", Routes.prefix + """actasRecepcion/actualizar"""))
   }
}
        

// @LINE:157
case controllers_patrimonio_ActasRecepcionController_cambiarEstado128(params) => {
   call(params.fromQuery[Long]("idActa", None), params.fromQuery[Long]("idEstado", None)) { (idActa, idEstado) =>
        invokeHandler(controllers.patrimonio.ActasRecepcionController.cambiarEstado(idActa, idEstado), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/cambiarEstado"""))
   }
}
        

// @LINE:158
case controllers_patrimonio_ActasRecepcionReportesController_reporte129(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasRecepcionReportesController.reporte(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "reporte", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actas-recepcion-reporte/reporte"""))
   }
}
        

// @LINE:159
case controllers_patrimonio_ActasRecepcionReportesController_reporteLineasActas130(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionReportesController.reporteLineasActas(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "reporteLineasActas", Nil,"POST", """""", Routes.prefix + """actasRecepcion/reporteLineasActas"""))
   }
}
        

// @LINE:160
case controllers_patrimonio_ActasRecepcionReportesController_reporteGeneralActa131(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionReportesController.reporteGeneralActa(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "reporteGeneralActa", Nil,"POST", """""", Routes.prefix + """actasRecepcion/reporteGeneralActa"""))
   }
}
        

// @LINE:161
case controllers_patrimonio_ActasRecepcionReportesController_reporteActaCierre132(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasRecepcionReportesController.reporteActaCierre(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "reporteActaCierre", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actas-recepcion-reporte/reporteActaCierre"""))
   }
}
        

// @LINE:163
case controllers_patrimonio_ActasRecepcionReportesController_modalListadoInventariable133(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionReportesController.modalListadoInventariable(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "modalListadoInventariable", Nil,"GET", """""", Routes.prefix + """actas-recepcion-reporte/modalListadoInventariable"""))
   }
}
        

// @LINE:164
case controllers_patrimonio_ActasRecepcionReportesController_informeListadoInventariable134(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionReportesController.informeListadoInventariable(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "informeListadoInventariable", Nil,"POST", """""", Routes.prefix + """actas-recepcion-reporte/informeListadoInventariable"""))
   }
}
        

// @LINE:166
case controllers_patrimonio_ActasRecepcionAccionesController_crear135(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionAccionesController.crear(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "crear", Nil,"GET", """""", Routes.prefix + """acciones/actasRecepcion/modal-crear"""))
   }
}
        

// @LINE:167
case controllers_patrimonio_ActasRecepcionAccionesController_guardar136(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionAccionesController.guardar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "guardar", Nil,"POST", """""", Routes.prefix + """acciones/actasRecepcion/modal-guardar"""))
   }
}
        

// @LINE:168
case controllers_patrimonio_ActasRecepcionAccionesController_revocar137(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionAccionesController.revocar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "revocar", Nil,"POST", """""", Routes.prefix + """acciones/actasRecepcion/revocar"""))
   }
}
        

// @LINE:169
case controllers_patrimonio_ActasRecepcionAccionesController_modalAsignar138(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionAccionesController.modalAsignar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "modalAsignar", Nil,"GET", """""", Routes.prefix + """acciones/actasRecepcion/modal-asignar"""))
   }
}
        

// @LINE:170
case controllers_patrimonio_ActasRecepcionAccionesController_asignar139(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionAccionesController.asignar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "asignar", Nil,"POST", """""", Routes.prefix + """acciones/actasRecepcion/asignar"""))
   }
}
        

// @LINE:172
case controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_crear140(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.crear(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "crear", Nil,"GET", """""", Routes.prefix + """acciones/actasRecepcionCertificaciones/modal-crear"""))
   }
}
        

// @LINE:173
case controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_guardar141(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.guardar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "guardar", Nil,"POST", """""", Routes.prefix + """acciones/actasRecepcionCertificaciones/modal-guardar"""))
   }
}
        

// @LINE:174
case controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_revocar142(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.revocar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "revocar", Nil,"POST", """""", Routes.prefix + """acciones/actasRecepcionCertificaciones/revocar"""))
   }
}
        

// @LINE:175
case controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_modalAsignar143(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.modalAsignar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "modalAsignar", Nil,"GET", """""", Routes.prefix + """acciones/actasRecepcionCertificaciones/modal-asignar"""))
   }
}
        

// @LINE:176
case controllers_patrimonio_ActasRecepcionCertificacionesAccionesController_asignar144(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.asignar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "asignar", Nil,"POST", """""", Routes.prefix + """acciones/actasRecepcionCertificaciones/asignar"""))
   }
}
        

// @LINE:178
case controllers_patrimonio_ActasMovimientosController_index145(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.index(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "index", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/index"""))
   }
}
        

// @LINE:179
case controllers_patrimonio_ActasMovimientosController_crear146(params) => {
   call(params.fromQuery[String]("actaId", None)) { (actaId) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.crear(actaId), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/crear"""))
   }
}
        

// @LINE:180
case controllers_patrimonio_ActasMovimientosController_editar147(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.editar(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/editar"""))
   }
}
        

// @LINE:181
case controllers_patrimonio_ActasMovimientosController_guardar148(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.guardar(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "guardar", Nil,"POST", """""", Routes.prefix + """actasRecepcion/movimiento-linea/guardar"""))
   }
}
        

// @LINE:182
case controllers_patrimonio_ActasMovimientosController_actualizar149(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.actualizar(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "actualizar", Nil,"POST", """""", Routes.prefix + """actasRecepcion/movimiento-linea/actualizar"""))
   }
}
        

// @LINE:183
case controllers_patrimonio_ActasMovimientosController_eliminar150(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.eliminar(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/eliminar"""))
   }
}
        

// @LINE:184
case controllers_patrimonio_ActasMovimientosController_indexGeneral151(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.indexGeneral(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "indexGeneral", Nil,"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/indexGeneral"""))
   }
}
        

// @LINE:185
case controllers_patrimonio_ActasMovimientosController_indexPasesPorUsuario152(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.indexPasesPorUsuario(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "indexPasesPorUsuario", Nil,"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/indexPasesPorUsuario"""))
   }
}
        

// @LINE:187
case controllers_patrimonio_ActasMovimientosController_modalPasarOtroServicio153(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.modalPasarOtroServicio(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalPasarOtroServicio", Nil,"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/modalPasarOtroServicio"""))
   }
}
        

// @LINE:188
case controllers_patrimonio_ActasMovimientosController_modalPasarOtroServicioIndividual154(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.modalPasarOtroServicioIndividual(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalPasarOtroServicioIndividual", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/modalPasarOtroServicioIndividual"""))
   }
}
        

// @LINE:189
case controllers_patrimonio_ActasMovimientosController_pasarOtroServicio155(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.pasarOtroServicio(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "pasarOtroServicio", Nil,"POST", """""", Routes.prefix + """actasRecepcion/movimiento-linea/pasarOtroServicio"""))
   }
}
        

// @LINE:190
case controllers_patrimonio_ActasMovimientosController_cancelarPase156(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.cancelarPase(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "cancelarPase", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/cancelarPase"""))
   }
}
        

// @LINE:191
case controllers_patrimonio_ActasMovimientosController_asignarMiServicio157(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.asignarMiServicio(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "asignarMiServicio", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/asignarMiServicio"""))
   }
}
        

// @LINE:192
case controllers_patrimonio_ActasMovimientosController_cancelarPaseLista158(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.cancelarPaseLista(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "cancelarPaseLista", Nil,"POST", """""", Routes.prefix + """actasRecepcion/movimiento-linea/cancelarPaseLista"""))
   }
}
        

// @LINE:193
case controllers_patrimonio_ActasMovimientosController_modalAsignarMiServicio159(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.modalAsignarMiServicio(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalAsignarMiServicio", Nil,"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/modalAsignarMiServicio"""))
   }
}
        

// @LINE:194
case controllers_patrimonio_ActasMovimientosController_asignarAMiServicioMasivo160(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.asignarAMiServicioMasivo(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "asignarAMiServicioMasivo", Nil,"POST", """""", Routes.prefix + """actasRecepcion/movimiento-linea/asignarMiServicioMasivo"""))
   }
}
        

// @LINE:196
case controllers_patrimonio_ActasMovimientosController_modalCierreCircuitoIndividual161(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.modalCierreCircuitoIndividual(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalCierreCircuitoIndividual", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/modalCierreCircuitoIndividual"""))
   }
}
        

// @LINE:197
case controllers_patrimonio_ActasMovimientosController_modalCierreCircuito162(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.modalCierreCircuito(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalCierreCircuito", Nil,"GET", """""", Routes.prefix + """actasRecepcion/movimiento-linea/modalCierreCircuito"""))
   }
}
        

// @LINE:198
case controllers_patrimonio_ActasMovimientosController_cierreCircuito163(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActasMovimientosController.cierreCircuito(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "cierreCircuito", Nil,"POST", """""", Routes.prefix + """actasRecepcion/movimiento-linea/cierreCircuito"""))
   }
}
        

// @LINE:201
case controllers_patrimonio_ActasMovimientosController_aceptarPase164(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.aceptarPase(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "aceptarPase", Seq(classOf[Long]),"POST", """""", Routes.prefix + """actasRecepcion/movimiento-linea/aceptarPase"""))
   }
}
        

// @LINE:202
case controllers_patrimonio_ActasMovimientosController_rechazarPase165(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasMovimientosController.rechazarPase(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "rechazarPase", Seq(classOf[Long]),"POST", """""", Routes.prefix + """actasRecepcion/movimiento-linea/rechazarPase"""))
   }
}
        

// @LINE:204
case controllers_patrimonio_ActasRecepcionController_getPacientes166(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActasRecepcionController.getPacientes(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "getPacientes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """actasRecepcion/getPacientes"""))
   }
}
        

// @LINE:206
case controllers_patrimonio_ActaRecepcionLineaAjusteController_index167(params) => {
   call(params.fromQuery[Long]("acta_id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (acta_id, editable) =>
        invokeHandler(controllers.patrimonio.ActaRecepcionLineaAjusteController.index(acta_id, editable), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """acta-linea-ajuste/index"""))
   }
}
        

// @LINE:207
case controllers_patrimonio_ActaRecepcionLineaAjusteController_crear168(params) => {
   call(params.fromQuery[String]("actaId", None)) { (actaId) =>
        invokeHandler(controllers.patrimonio.ActaRecepcionLineaAjusteController.crear(actaId), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """acta-linea-ajuste/crear"""))
   }
}
        

// @LINE:208
case controllers_patrimonio_ActaRecepcionLineaAjusteController_editar169(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActaRecepcionLineaAjusteController.editar(id), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """acta-linea-ajuste/editar"""))
   }
}
        

// @LINE:209
case controllers_patrimonio_ActaRecepcionLineaAjusteController_guardar170(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActaRecepcionLineaAjusteController.guardar(), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "guardar", Nil,"POST", """""", Routes.prefix + """acta-linea-ajuste/guardar"""))
   }
}
        

// @LINE:210
case controllers_patrimonio_ActaRecepcionLineaAjusteController_actualizar171(params) => {
   call { 
        invokeHandler(controllers.patrimonio.ActaRecepcionLineaAjusteController.actualizar(), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "actualizar", Nil,"POST", """""", Routes.prefix + """acta-linea-ajuste/actualizar"""))
   }
}
        

// @LINE:211
case controllers_patrimonio_ActaRecepcionLineaAjusteController_eliminar172(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.patrimonio.ActaRecepcionLineaAjusteController.eliminar(id), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """acta-linea-ajuste/eliminar"""))
   }
}
        

// @LINE:214
case controllers_patrimonio_OrdenesProvisionController_suggestOrdenProvision173(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.patrimonio.OrdenesProvisionController.suggestOrdenProvision(input), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "suggestOrdenProvision", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestOrdenProvision/$input<[^/]+>"""))
   }
}
        

// @LINE:215
case controllers_patrimonio_PrefijosController_suggest174(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.patrimonio.PrefijosController.suggest(input), HandlerDef(this, "controllers.patrimonio.PrefijosController", "suggest", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestPrefijo/$input<[^/]+>"""))
   }
}
        
}

}
     