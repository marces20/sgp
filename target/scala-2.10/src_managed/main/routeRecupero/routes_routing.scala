// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routeRecupero.routes
// @HASH:7c49588c87f1e2a5c9494516b9372059b82f7202
// @DATE:Tue Oct 04 11:43:25 ART 2022
package routeRecupero

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


// @LINE:4
private[this] lazy val controllers_recupero_IndexController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:5
private[this] lazy val controllers_recupero_PresupuestosController_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presu"))))
        

// @LINE:6
private[this] lazy val controllers_recupero_PresupuestosController_crear2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presu/crear"))))
        

// @LINE:7
private[this] lazy val controllers_recupero_PresupuestosController_guardar3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presu/guardar"))))
        

// @LINE:8
private[this] lazy val controllers_recupero_PresupuestosController_editar4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presu/editar"))))
        

// @LINE:9
private[this] lazy val controllers_recupero_PresupuestosController_eliminar5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presu/eliminar"))))
        

// @LINE:10
private[this] lazy val controllers_recupero_PresupuestosController_ver6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presu/ver"))))
        

// @LINE:11
private[this] lazy val controllers_recupero_PresupuestosController_duplicar7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presu/duplicar"))))
        

// @LINE:12
private[this] lazy val controllers_recupero_PresupuestosController_actualizar8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presu/actualizar"))))
        

// @LINE:13
private[this] lazy val controllers_recupero_PresupuestosController_cambiarEstado9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presu/cambiarEstado"))))
        

// @LINE:15
private[this] lazy val controllers_recupero_PresupuestoLineasController_index10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto-linea/index"))))
        

// @LINE:16
private[this] lazy val controllers_recupero_PresupuestoLineasController_crear11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto-linea/crear"))))
        

// @LINE:17
private[this] lazy val controllers_recupero_PresupuestoLineasController_editar12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto-linea/editar"))))
        

// @LINE:18
private[this] lazy val controllers_recupero_PresupuestoLineasController_guardar13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto-linea/guardar"))))
        

// @LINE:19
private[this] lazy val controllers_recupero_PresupuestoLineasController_actualizar14 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto-linea/actualizar"))))
        

// @LINE:20
private[this] lazy val controllers_recupero_PresupuestoLineasController_eliminar15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto-linea/eliminar"))))
        

// @LINE:22
private[this] lazy val controllers_recupero_RecuperoFacturasController_index16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura"))))
        

// @LINE:23
private[this] lazy val controllers_recupero_RecuperoFacturasController_crear17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura/crear"))))
        

// @LINE:24
private[this] lazy val controllers_recupero_RecuperoFacturasController_guardar18 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura/guardar"))))
        

// @LINE:25
private[this] lazy val controllers_recupero_RecuperoFacturasController_editar19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura/editar"))))
        

// @LINE:26
private[this] lazy val controllers_recupero_RecuperoFacturasController_eliminar20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura/eliminar"))))
        

// @LINE:27
private[this] lazy val controllers_recupero_RecuperoFacturasController_ver21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura/ver"))))
        

// @LINE:28
private[this] lazy val controllers_recupero_RecuperoFacturasController_actualizar22 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura/actualizar"))))
        

// @LINE:29
private[this] lazy val controllers_recupero_RecuperoFacturasController_cambiarEstado23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura/cambiarEstado"))))
        

// @LINE:31
private[this] lazy val controllers_recupero_RecuperoFacturaLineasController_index24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/index"))))
        

// @LINE:32
private[this] lazy val controllers_recupero_RecuperoFacturaLineasController_crear25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/crear"))))
        

// @LINE:33
private[this] lazy val controllers_recupero_RecuperoFacturaLineasController_editar26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/editar"))))
        

// @LINE:34
private[this] lazy val controllers_recupero_RecuperoFacturaLineasController_guardar27 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/guardar"))))
        

// @LINE:35
private[this] lazy val controllers_recupero_RecuperoFacturaLineasController_actualizar28 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/actualizar"))))
        

// @LINE:36
private[this] lazy val controllers_recupero_RecuperoFacturaLineasController_eliminar29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("factura-linea/eliminar"))))
        

// @LINE:38
private[this] lazy val controllers_recupero_RecuperoNotasCreditosController_index30 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nota-credito-linea/index"))))
        

// @LINE:39
private[this] lazy val controllers_recupero_RecuperoNotasCreditosController_crear31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nota-credito-linea/crear"))))
        

// @LINE:40
private[this] lazy val controllers_recupero_RecuperoNotasCreditosController_editar32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nota-credito-linea/editar"))))
        

// @LINE:41
private[this] lazy val controllers_recupero_RecuperoNotasCreditosController_guardar33 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nota-credito-linea/guardar"))))
        

// @LINE:42
private[this] lazy val controllers_recupero_RecuperoNotasCreditosController_actualizar34 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nota-credito-linea/actualizar"))))
        

// @LINE:43
private[this] lazy val controllers_recupero_RecuperoNotasCreditosController_eliminar35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nota-credito-linea/eliminar"))))
        

// @LINE:45
private[this] lazy val controllers_recupero_RecuperoPagosController_index36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago"))))
        

// @LINE:46
private[this] lazy val controllers_recupero_RecuperoPagosController_crear37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/crear"))))
        

// @LINE:47
private[this] lazy val controllers_recupero_RecuperoPagosController_guardar38 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/guardar"))))
        

// @LINE:48
private[this] lazy val controllers_recupero_RecuperoPagosController_editar39 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/editar"))))
        

// @LINE:49
private[this] lazy val controllers_recupero_RecuperoPagosController_eliminar40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/eliminar"))))
        

// @LINE:50
private[this] lazy val controllers_recupero_RecuperoPagosController_ver41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/ver"))))
        

// @LINE:51
private[this] lazy val controllers_recupero_RecuperoPagosController_actualizar42 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/actualizar"))))
        

// @LINE:52
private[this] lazy val controllers_recupero_RecuperoPagosController_cambiarEstado43 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/cambiarEstado"))))
        

// @LINE:53
private[this] lazy val controllers_recupero_RecuperoPagosController_crearPagoParcial44 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/crearPagoParcial"))))
        

// @LINE:55
private[this] lazy val controllers_recupero_RecuperoChequesController_crear45 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/cheques/crear"))))
        

// @LINE:56
private[this] lazy val controllers_recupero_RecuperoChequesController_guardar46 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/cheques/guardar"))))
        

// @LINE:57
private[this] lazy val controllers_recupero_RecuperoChequesController_editar47 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/cheques/editar"))))
        

// @LINE:58
private[this] lazy val controllers_recupero_RecuperoChequesController_actualizar48 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/cheques/actualizar"))))
        

// @LINE:59
private[this] lazy val controllers_recupero_RecuperoChequesController_eliminar49 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/cheques/eliminar"))))
        

// @LINE:60
private[this] lazy val controllers_recupero_RecuperoChequesController_index50 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pago/cheque/index"))))
        

// @LINE:63
private[this] lazy val controllers_recupero_RecuperoPlanillasController_index51 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planilla"))))
        

// @LINE:64
private[this] lazy val controllers_recupero_RecuperoPlanillasController_crear52 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planilla/crear"))))
        

// @LINE:65
private[this] lazy val controllers_recupero_RecuperoPlanillasController_guardar53 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planilla/guardar"))))
        

// @LINE:66
private[this] lazy val controllers_recupero_RecuperoPlanillasController_editar54 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planilla/editar"))))
        

// @LINE:67
private[this] lazy val controllers_recupero_RecuperoPlanillasController_eliminar55 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planilla/eliminar"))))
        

// @LINE:68
private[this] lazy val controllers_recupero_RecuperoPlanillasController_ver56 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planilla/ver"))))
        

// @LINE:69
private[this] lazy val controllers_recupero_RecuperoPlanillasController_actualizar57 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planilla/actualizar"))))
        

// @LINE:70
private[this] lazy val controllers_recupero_RecuperoPlanillasController_modalBuscar58 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planilla/modalBuscar"))))
        

// @LINE:71
private[this] lazy val controllers_recupero_RecuperoPlanillasController_get59 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planilla/get"))))
        

// @LINE:72
private[this] lazy val controllers_recupero_RecuperoPlanillasController_suggestRecuperoPlanilla60 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestRecuperoPlanilla/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:74
private[this] lazy val controllers_recupero_PresupuestosReportesController_presupuesto61 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reporte/presupuesto"))))
        

// @LINE:76
private[this] lazy val controllers_recupero_RecuperoReportesController_informeDeuda62 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recupero/reportes/deudas"))))
        

// @LINE:77
private[this] lazy val controllers_recupero_RecuperoReportesController_informeGeneral63 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recupero/reportes/informeGeneral"))))
        

// @LINE:78
private[this] lazy val controllers_recupero_RecuperoReportesController_archivoInformeDeuda64 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("archivo/deudas"))))
        

// @LINE:79
private[this] lazy val controllers_recupero_RecuperoReportesController_archivoInformeGeneral65 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("archivo/archivoInformeGeneral"))))
        

// @LINE:81
private[this] lazy val controllers_recupero_RecuperoReportesController_reportePagosExcel66 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recupero/reportes/reportePagosExcel"))))
        

// @LINE:82
private[this] lazy val controllers_recupero_RecuperoReportesController_reporteFacturasExcel67 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recupero/reportes/reporteFacturasExcel"))))
        

// @LINE:84
private[this] lazy val controllers_recupero_RecuperoReportesController_imprimirFactura68 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("facturas/imprimir-factura"))))
        

// @LINE:85
private[this] lazy val controllers_recupero_RecuperoReportesController_imprimirRecibo69 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pagos/imprimir-recibo"))))
        

// @LINE:88
private[this] lazy val controllers_recupero_RecuperoReportesController_modalPlanilla70 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reportesPlanilla/modalPlanilla"))))
        

// @LINE:89
private[this] lazy val controllers_recupero_RecuperoReportesController_informePlanilla71 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reportesPlanilla/imprimirPlanilla"))))
        

// @LINE:91
private[this] lazy val controllers_recupero_RecuperoReportesController_informeDesdePlanilla72 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reportesPlanilla/imprimirDesdePlanilla"))))
        
def documentation = List(("""GET""", prefix,"""controllers.recupero.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presu""","""controllers.recupero.PresupuestosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presu/crear""","""controllers.recupero.PresupuestosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presu/guardar""","""controllers.recupero.PresupuestosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presu/editar""","""controllers.recupero.PresupuestosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presu/eliminar""","""controllers.recupero.PresupuestosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presu/ver""","""controllers.recupero.PresupuestosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presu/duplicar""","""controllers.recupero.PresupuestosController.duplicar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presu/actualizar""","""controllers.recupero.PresupuestosController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presu/cambiarEstado""","""controllers.recupero.PresupuestosController.cambiarEstado(idPresupuesto:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto-linea/index""","""controllers.recupero.PresupuestoLineasController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto-linea/crear""","""controllers.recupero.PresupuestoLineasController.crear(presupuestoId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto-linea/editar""","""controllers.recupero.PresupuestoLineasController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto-linea/guardar""","""controllers.recupero.PresupuestoLineasController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto-linea/actualizar""","""controllers.recupero.PresupuestoLineasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto-linea/eliminar""","""controllers.recupero.PresupuestoLineasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura""","""controllers.recupero.RecuperoFacturasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura/crear""","""controllers.recupero.RecuperoFacturasController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura/guardar""","""controllers.recupero.RecuperoFacturasController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura/editar""","""controllers.recupero.RecuperoFacturasController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura/eliminar""","""controllers.recupero.RecuperoFacturasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura/ver""","""controllers.recupero.RecuperoFacturasController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura/actualizar""","""controllers.recupero.RecuperoFacturasController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura/cambiarEstado""","""controllers.recupero.RecuperoFacturasController.cambiarEstado(idRecuperoFactura:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/index""","""controllers.recupero.RecuperoFacturaLineasController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/crear""","""controllers.recupero.RecuperoFacturaLineasController.crear(facturaId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/editar""","""controllers.recupero.RecuperoFacturaLineasController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/guardar""","""controllers.recupero.RecuperoFacturaLineasController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/actualizar""","""controllers.recupero.RecuperoFacturaLineasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """factura-linea/eliminar""","""controllers.recupero.RecuperoFacturaLineasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nota-credito-linea/index""","""controllers.recupero.RecuperoNotasCreditosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nota-credito-linea/crear""","""controllers.recupero.RecuperoNotasCreditosController.crear(facturaId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nota-credito-linea/editar""","""controllers.recupero.RecuperoNotasCreditosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nota-credito-linea/guardar""","""controllers.recupero.RecuperoNotasCreditosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nota-credito-linea/actualizar""","""controllers.recupero.RecuperoNotasCreditosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nota-credito-linea/eliminar""","""controllers.recupero.RecuperoNotasCreditosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago""","""controllers.recupero.RecuperoPagosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/crear""","""controllers.recupero.RecuperoPagosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/guardar""","""controllers.recupero.RecuperoPagosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/editar""","""controllers.recupero.RecuperoPagosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/eliminar""","""controllers.recupero.RecuperoPagosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/ver""","""controllers.recupero.RecuperoPagosController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/actualizar""","""controllers.recupero.RecuperoPagosController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/cambiarEstado""","""controllers.recupero.RecuperoPagosController.cambiarEstado(idRecuperoPago:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/crearPagoParcial""","""controllers.recupero.RecuperoPagosController.crearPagoParcial(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/cheques/crear""","""controllers.recupero.RecuperoChequesController.crear(pagoId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/cheques/guardar""","""controllers.recupero.RecuperoChequesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/cheques/editar""","""controllers.recupero.RecuperoChequesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/cheques/actualizar""","""controllers.recupero.RecuperoChequesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/cheques/eliminar""","""controllers.recupero.RecuperoChequesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pago/cheque/index""","""controllers.recupero.RecuperoChequesController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planilla""","""controllers.recupero.RecuperoPlanillasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planilla/crear""","""controllers.recupero.RecuperoPlanillasController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planilla/guardar""","""controllers.recupero.RecuperoPlanillasController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planilla/editar""","""controllers.recupero.RecuperoPlanillasController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planilla/eliminar""","""controllers.recupero.RecuperoPlanillasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planilla/ver""","""controllers.recupero.RecuperoPlanillasController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planilla/actualizar""","""controllers.recupero.RecuperoPlanillasController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planilla/modalBuscar""","""controllers.recupero.RecuperoPlanillasController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planilla/get""","""controllers.recupero.RecuperoPlanillasController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestRecuperoPlanilla/$input<[^/]+>""","""controllers.recupero.RecuperoPlanillasController.suggestRecuperoPlanilla(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reporte/presupuesto""","""controllers.recupero.PresupuestosReportesController.presupuesto(id:Long, extrajero:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recupero/reportes/deudas""","""controllers.recupero.RecuperoReportesController.informeDeuda()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recupero/reportes/informeGeneral""","""controllers.recupero.RecuperoReportesController.informeGeneral()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """archivo/deudas""","""controllers.recupero.RecuperoReportesController.archivoInformeDeuda()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """archivo/archivoInformeGeneral""","""controllers.recupero.RecuperoReportesController.archivoInformeGeneral()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recupero/reportes/reportePagosExcel""","""controllers.recupero.RecuperoReportesController.reportePagosExcel()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recupero/reportes/reporteFacturasExcel""","""controllers.recupero.RecuperoReportesController.reporteFacturasExcel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """facturas/imprimir-factura""","""controllers.recupero.RecuperoReportesController.imprimirFactura(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pagos/imprimir-recibo""","""controllers.recupero.RecuperoReportesController.imprimirRecibo(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reportesPlanilla/modalPlanilla""","""controllers.recupero.RecuperoReportesController.modalPlanilla()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reportesPlanilla/imprimirPlanilla""","""controllers.recupero.RecuperoReportesController.informePlanilla()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reportesPlanilla/imprimirDesdePlanilla""","""controllers.recupero.RecuperoReportesController.informeDesdePlanilla(idPlanilla:Long ?= 0)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:4
case controllers_recupero_IndexController_index0(params) => {
   call { 
        invokeHandler(controllers.recupero.IndexController.index(), HandlerDef(this, "controllers.recupero.IndexController", "index", Nil,"GET", """-----------------------------MODULO RECUPERO ---------------------------------""", Routes.prefix + """"""))
   }
}
        

// @LINE:5
case controllers_recupero_PresupuestosController_index1(params) => {
   call { 
        invokeHandler(controllers.recupero.PresupuestosController.index(), HandlerDef(this, "controllers.recupero.PresupuestosController", "index", Nil,"GET", """""", Routes.prefix + """presu"""))
   }
}
        

// @LINE:6
case controllers_recupero_PresupuestosController_crear2(params) => {
   call { 
        invokeHandler(controllers.recupero.PresupuestosController.crear(), HandlerDef(this, "controllers.recupero.PresupuestosController", "crear", Nil,"GET", """""", Routes.prefix + """presu/crear"""))
   }
}
        

// @LINE:7
case controllers_recupero_PresupuestosController_guardar3(params) => {
   call { 
        invokeHandler(controllers.recupero.PresupuestosController.guardar(), HandlerDef(this, "controllers.recupero.PresupuestosController", "guardar", Nil,"POST", """""", Routes.prefix + """presu/guardar"""))
   }
}
        

// @LINE:8
case controllers_recupero_PresupuestosController_editar4(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.PresupuestosController.editar(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presu/editar"""))
   }
}
        

// @LINE:9
case controllers_recupero_PresupuestosController_eliminar5(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.PresupuestosController.eliminar(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presu/eliminar"""))
   }
}
        

// @LINE:10
case controllers_recupero_PresupuestosController_ver6(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.PresupuestosController.ver(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presu/ver"""))
   }
}
        

// @LINE:11
case controllers_recupero_PresupuestosController_duplicar7(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.PresupuestosController.duplicar(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "duplicar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presu/duplicar"""))
   }
}
        

// @LINE:12
case controllers_recupero_PresupuestosController_actualizar8(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.PresupuestosController.actualizar(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """presu/actualizar"""))
   }
}
        

// @LINE:13
case controllers_recupero_PresupuestosController_cambiarEstado9(params) => {
   call(params.fromQuery[Long]("idPresupuesto", None), params.fromQuery[Long]("idEstado", None)) { (idPresupuesto, idEstado) =>
        invokeHandler(controllers.recupero.PresupuestosController.cambiarEstado(idPresupuesto, idEstado), HandlerDef(this, "controllers.recupero.PresupuestosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """presu/cambiarEstado"""))
   }
}
        

// @LINE:15
case controllers_recupero_PresupuestoLineasController_index10(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.recupero.PresupuestoLineasController.index(id, editable), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """presupuesto-linea/index"""))
   }
}
        

// @LINE:16
case controllers_recupero_PresupuestoLineasController_crear11(params) => {
   call(params.fromQuery[String]("presupuestoId", None)) { (presupuestoId) =>
        invokeHandler(controllers.recupero.PresupuestoLineasController.crear(presupuestoId), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """presupuesto-linea/crear"""))
   }
}
        

// @LINE:17
case controllers_recupero_PresupuestoLineasController_editar12(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.PresupuestoLineasController.editar(id), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto-linea/editar"""))
   }
}
        

// @LINE:18
case controllers_recupero_PresupuestoLineasController_guardar13(params) => {
   call { 
        invokeHandler(controllers.recupero.PresupuestoLineasController.guardar(), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "guardar", Nil,"POST", """""", Routes.prefix + """presupuesto-linea/guardar"""))
   }
}
        

// @LINE:19
case controllers_recupero_PresupuestoLineasController_actualizar14(params) => {
   call { 
        invokeHandler(controllers.recupero.PresupuestoLineasController.actualizar(), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "actualizar", Nil,"POST", """""", Routes.prefix + """presupuesto-linea/actualizar"""))
   }
}
        

// @LINE:20
case controllers_recupero_PresupuestoLineasController_eliminar15(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.PresupuestoLineasController.eliminar(id), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto-linea/eliminar"""))
   }
}
        

// @LINE:22
case controllers_recupero_RecuperoFacturasController_index16(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoFacturasController.index(), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "index", Nil,"GET", """""", Routes.prefix + """factura"""))
   }
}
        

// @LINE:23
case controllers_recupero_RecuperoFacturasController_crear17(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoFacturasController.crear(), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "crear", Nil,"GET", """""", Routes.prefix + """factura/crear"""))
   }
}
        

// @LINE:24
case controllers_recupero_RecuperoFacturasController_guardar18(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoFacturasController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "guardar", Nil,"POST", """""", Routes.prefix + """factura/guardar"""))
   }
}
        

// @LINE:25
case controllers_recupero_RecuperoFacturasController_editar19(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoFacturasController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura/editar"""))
   }
}
        

// @LINE:26
case controllers_recupero_RecuperoFacturasController_eliminar20(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoFacturasController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura/eliminar"""))
   }
}
        

// @LINE:27
case controllers_recupero_RecuperoFacturasController_ver21(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoFacturasController.ver(id), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura/ver"""))
   }
}
        

// @LINE:28
case controllers_recupero_RecuperoFacturasController_actualizar22(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoFacturasController.actualizar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """factura/actualizar"""))
   }
}
        

// @LINE:29
case controllers_recupero_RecuperoFacturasController_cambiarEstado23(params) => {
   call(params.fromQuery[Long]("idRecuperoFactura", None), params.fromQuery[Long]("idEstado", None)) { (idRecuperoFactura, idEstado) =>
        invokeHandler(controllers.recupero.RecuperoFacturasController.cambiarEstado(idRecuperoFactura, idEstado), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """factura/cambiarEstado"""))
   }
}
        

// @LINE:31
case controllers_recupero_RecuperoFacturaLineasController_index24(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.recupero.RecuperoFacturaLineasController.index(id, editable), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """factura-linea/index"""))
   }
}
        

// @LINE:32
case controllers_recupero_RecuperoFacturaLineasController_crear25(params) => {
   call(params.fromQuery[String]("facturaId", None)) { (facturaId) =>
        invokeHandler(controllers.recupero.RecuperoFacturaLineasController.crear(facturaId), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """factura-linea/crear"""))
   }
}
        

// @LINE:33
case controllers_recupero_RecuperoFacturaLineasController_editar26(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoFacturaLineasController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura-linea/editar"""))
   }
}
        

// @LINE:34
case controllers_recupero_RecuperoFacturaLineasController_guardar27(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoFacturaLineasController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "guardar", Nil,"POST", """""", Routes.prefix + """factura-linea/guardar"""))
   }
}
        

// @LINE:35
case controllers_recupero_RecuperoFacturaLineasController_actualizar28(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoFacturaLineasController.actualizar(), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "actualizar", Nil,"POST", """""", Routes.prefix + """factura-linea/actualizar"""))
   }
}
        

// @LINE:36
case controllers_recupero_RecuperoFacturaLineasController_eliminar29(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoFacturaLineasController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """factura-linea/eliminar"""))
   }
}
        

// @LINE:38
case controllers_recupero_RecuperoNotasCreditosController_index30(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.recupero.RecuperoNotasCreditosController.index(id, editable), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """nota-credito-linea/index"""))
   }
}
        

// @LINE:39
case controllers_recupero_RecuperoNotasCreditosController_crear31(params) => {
   call(params.fromQuery[String]("facturaId", None)) { (facturaId) =>
        invokeHandler(controllers.recupero.RecuperoNotasCreditosController.crear(facturaId), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """nota-credito-linea/crear"""))
   }
}
        

// @LINE:40
case controllers_recupero_RecuperoNotasCreditosController_editar32(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoNotasCreditosController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """nota-credito-linea/editar"""))
   }
}
        

// @LINE:41
case controllers_recupero_RecuperoNotasCreditosController_guardar33(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoNotasCreditosController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "guardar", Nil,"POST", """""", Routes.prefix + """nota-credito-linea/guardar"""))
   }
}
        

// @LINE:42
case controllers_recupero_RecuperoNotasCreditosController_actualizar34(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoNotasCreditosController.actualizar(), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "actualizar", Nil,"POST", """""", Routes.prefix + """nota-credito-linea/actualizar"""))
   }
}
        

// @LINE:43
case controllers_recupero_RecuperoNotasCreditosController_eliminar35(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoNotasCreditosController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """nota-credito-linea/eliminar"""))
   }
}
        

// @LINE:45
case controllers_recupero_RecuperoPagosController_index36(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoPagosController.index(), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "index", Nil,"GET", """""", Routes.prefix + """pago"""))
   }
}
        

// @LINE:46
case controllers_recupero_RecuperoPagosController_crear37(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoPagosController.crear(), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "crear", Nil,"GET", """""", Routes.prefix + """pago/crear"""))
   }
}
        

// @LINE:47
case controllers_recupero_RecuperoPagosController_guardar38(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoPagosController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "guardar", Nil,"POST", """""", Routes.prefix + """pago/guardar"""))
   }
}
        

// @LINE:48
case controllers_recupero_RecuperoPagosController_editar39(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPagosController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pago/editar"""))
   }
}
        

// @LINE:49
case controllers_recupero_RecuperoPagosController_eliminar40(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPagosController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pago/eliminar"""))
   }
}
        

// @LINE:50
case controllers_recupero_RecuperoPagosController_ver41(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPagosController.ver(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pago/ver"""))
   }
}
        

// @LINE:51
case controllers_recupero_RecuperoPagosController_actualizar42(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPagosController.actualizar(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """pago/actualizar"""))
   }
}
        

// @LINE:52
case controllers_recupero_RecuperoPagosController_cambiarEstado43(params) => {
   call(params.fromQuery[Long]("idRecuperoPago", None), params.fromQuery[Long]("idEstado", None)) { (idRecuperoPago, idEstado) =>
        invokeHandler(controllers.recupero.RecuperoPagosController.cambiarEstado(idRecuperoPago, idEstado), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """pago/cambiarEstado"""))
   }
}
        

// @LINE:53
case controllers_recupero_RecuperoPagosController_crearPagoParcial44(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPagosController.crearPagoParcial(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "crearPagoParcial", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pago/crearPagoParcial"""))
   }
}
        

// @LINE:55
case controllers_recupero_RecuperoChequesController_crear45(params) => {
   call(params.fromQuery[String]("pagoId", None)) { (pagoId) =>
        invokeHandler(controllers.recupero.RecuperoChequesController.crear(pagoId), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """pago/cheques/crear"""))
   }
}
        

// @LINE:56
case controllers_recupero_RecuperoChequesController_guardar46(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoChequesController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "guardar", Nil,"POST", """""", Routes.prefix + """pago/cheques/guardar"""))
   }
}
        

// @LINE:57
case controllers_recupero_RecuperoChequesController_editar47(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoChequesController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pago/cheques/editar"""))
   }
}
        

// @LINE:58
case controllers_recupero_RecuperoChequesController_actualizar48(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoChequesController.actualizar(), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "actualizar", Nil,"POST", """""", Routes.prefix + """pago/cheques/actualizar"""))
   }
}
        

// @LINE:59
case controllers_recupero_RecuperoChequesController_eliminar49(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoChequesController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pago/cheques/eliminar"""))
   }
}
        

// @LINE:60
case controllers_recupero_RecuperoChequesController_index50(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.recupero.RecuperoChequesController.index(id, editable), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """pago/cheque/index"""))
   }
}
        

// @LINE:63
case controllers_recupero_RecuperoPlanillasController_index51(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoPlanillasController.index(), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "index", Nil,"GET", """""", Routes.prefix + """planilla"""))
   }
}
        

// @LINE:64
case controllers_recupero_RecuperoPlanillasController_crear52(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoPlanillasController.crear(), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "crear", Nil,"GET", """""", Routes.prefix + """planilla/crear"""))
   }
}
        

// @LINE:65
case controllers_recupero_RecuperoPlanillasController_guardar53(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoPlanillasController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "guardar", Nil,"POST", """""", Routes.prefix + """planilla/guardar"""))
   }
}
        

// @LINE:66
case controllers_recupero_RecuperoPlanillasController_editar54(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPlanillasController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """planilla/editar"""))
   }
}
        

// @LINE:67
case controllers_recupero_RecuperoPlanillasController_eliminar55(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPlanillasController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """planilla/eliminar"""))
   }
}
        

// @LINE:68
case controllers_recupero_RecuperoPlanillasController_ver56(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPlanillasController.ver(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """planilla/ver"""))
   }
}
        

// @LINE:69
case controllers_recupero_RecuperoPlanillasController_actualizar57(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPlanillasController.actualizar(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """planilla/actualizar"""))
   }
}
        

// @LINE:70
case controllers_recupero_RecuperoPlanillasController_modalBuscar58(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoPlanillasController.modalBuscar(), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """planilla/modalBuscar"""))
   }
}
        

// @LINE:71
case controllers_recupero_RecuperoPlanillasController_get59(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.recupero.RecuperoPlanillasController.get(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """planilla/get"""))
   }
}
        

// @LINE:72
case controllers_recupero_RecuperoPlanillasController_suggestRecuperoPlanilla60(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.recupero.RecuperoPlanillasController.suggestRecuperoPlanilla(input), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "suggestRecuperoPlanilla", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestRecuperoPlanilla/$input<[^/]+>"""))
   }
}
        

// @LINE:74
case controllers_recupero_PresupuestosReportesController_presupuesto61(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Boolean]("extrajero", Some(false))) { (id, extrajero) =>
        invokeHandler(controllers.recupero.PresupuestosReportesController.presupuesto(id, extrajero), HandlerDef(this, "controllers.recupero.PresupuestosReportesController", "presupuesto", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """reporte/presupuesto"""))
   }
}
        

// @LINE:76
case controllers_recupero_RecuperoReportesController_informeDeuda62(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoReportesController.informeDeuda(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "informeDeuda", Nil,"GET", """""", Routes.prefix + """recupero/reportes/deudas"""))
   }
}
        

// @LINE:77
case controllers_recupero_RecuperoReportesController_informeGeneral63(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoReportesController.informeGeneral(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "informeGeneral", Nil,"GET", """""", Routes.prefix + """recupero/reportes/informeGeneral"""))
   }
}
        

// @LINE:78
case controllers_recupero_RecuperoReportesController_archivoInformeDeuda64(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoReportesController.archivoInformeDeuda(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "archivoInformeDeuda", Nil,"GET", """""", Routes.prefix + """archivo/deudas"""))
   }
}
        

// @LINE:79
case controllers_recupero_RecuperoReportesController_archivoInformeGeneral65(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoReportesController.archivoInformeGeneral(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "archivoInformeGeneral", Nil,"GET", """""", Routes.prefix + """archivo/archivoInformeGeneral"""))
   }
}
        

// @LINE:81
case controllers_recupero_RecuperoReportesController_reportePagosExcel66(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoReportesController.reportePagosExcel(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "reportePagosExcel", Nil,"POST", """""", Routes.prefix + """recupero/reportes/reportePagosExcel"""))
   }
}
        

// @LINE:82
case controllers_recupero_RecuperoReportesController_reporteFacturasExcel67(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoReportesController.reporteFacturasExcel(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "reporteFacturasExcel", Nil,"POST", """""", Routes.prefix + """recupero/reportes/reporteFacturasExcel"""))
   }
}
        

// @LINE:84
case controllers_recupero_RecuperoReportesController_imprimirFactura68(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoReportesController.imprimirFactura(id), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "imprimirFactura", Seq(classOf[Long]),"GET", """""", Routes.prefix + """facturas/imprimir-factura"""))
   }
}
        

// @LINE:85
case controllers_recupero_RecuperoReportesController_imprimirRecibo69(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.recupero.RecuperoReportesController.imprimirRecibo(id), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "imprimirRecibo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """pagos/imprimir-recibo"""))
   }
}
        

// @LINE:88
case controllers_recupero_RecuperoReportesController_modalPlanilla70(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoReportesController.modalPlanilla(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "modalPlanilla", Nil,"GET", """""", Routes.prefix + """reportesPlanilla/modalPlanilla"""))
   }
}
        

// @LINE:89
case controllers_recupero_RecuperoReportesController_informePlanilla71(params) => {
   call { 
        invokeHandler(controllers.recupero.RecuperoReportesController.informePlanilla(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "informePlanilla", Nil,"POST", """""", Routes.prefix + """reportesPlanilla/imprimirPlanilla"""))
   }
}
        

// @LINE:91
case controllers_recupero_RecuperoReportesController_informeDesdePlanilla72(params) => {
   call(params.fromQuery[Long]("idPlanilla", Some(0))) { (idPlanilla) =>
        invokeHandler(controllers.recupero.RecuperoReportesController.informeDesdePlanilla(idPlanilla), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "informeDesdePlanilla", Seq(classOf[Long]),"POST", """""", Routes.prefix + """reportesPlanilla/imprimirDesdePlanilla"""))
   }
}
        
}

}
     