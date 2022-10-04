// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routes
// @HASH:1f124834843d709feba2747cf62a07cc4c597ae1
// @DATE:Tue Oct 04 11:43:29 ART 2022


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
  List[(String,Routes)](("dashboard",routeDashboard.Routes),("contabilidad",routeContabilidad.Routes),("patrimonio",routePatrimonio.Routes),("recupero",routeRecupero.Routes),("informes",routeInformes.Routes)).foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:7
lazy val routeDashboard_Routes0 = Include(routeDashboard.Routes)
        

// @LINE:8
lazy val routeContabilidad_Routes1 = Include(routeContabilidad.Routes)
        

// @LINE:9
lazy val routePatrimonio_Routes2 = Include(routePatrimonio.Routes)
        

// @LINE:10
lazy val routeRecupero_Routes3 = Include(routeRecupero.Routes)
        

// @LINE:11
lazy val routeInformes_Routes4 = Include(routeInformes.Routes)
        

// @LINE:13
private[this] lazy val controllers_Application_index5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:15
private[this] lazy val controllers_Authentication_login6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:16
private[this] lazy val controllers_Authentication_authenticate7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:17
private[this] lazy val controllers_Authentication_logout8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:21
private[this] lazy val controllers_administracion_OrganigramasController_modalBuscarServicios9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/organigrama/modal-buscar-sevicios"))))
        

// @LINE:22
private[this] lazy val controllers_administracion_OrganigramasController_get10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/organigrama/get"))))
        

// @LINE:26
private[this] lazy val controllers_administracion_IndexController_index11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion"))))
        

// @LINE:27
private[this] lazy val controllers_administracion_UsuariosController_index12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/usuarios"))))
        

// @LINE:28
private[this] lazy val controllers_administracion_UsuariosController_crear13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/usuarios/crear"))))
        

// @LINE:29
private[this] lazy val controllers_administracion_UsuariosController_eliminar14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/usuarios/eliminar"))))
        

// @LINE:30
private[this] lazy val controllers_administracion_UsuariosController_editar15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/usuarios/editar"))))
        

// @LINE:31
private[this] lazy val controllers_administracion_UsuariosController_actualizar16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/usuarios/actualizar"))))
        

// @LINE:32
private[this] lazy val controllers_administracion_UsuariosController_guardar17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/usuarios/guardar"))))
        

// @LINE:33
private[this] lazy val controllers_administracion_UsuariosController_suggest18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/usuarios/suggest/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:34
private[this] lazy val controllers_administracion_UsuariosController_modalBuscar19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/usuarios/modalBuscar"))))
        

// @LINE:35
private[this] lazy val controllers_administracion_UsuariosController_get20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/usuarios/get"))))
        

// @LINE:36
private[this] lazy val controllers_administracion_PermisosController_index21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/permisos"))))
        

// @LINE:37
private[this] lazy val controllers_administracion_PermisosController_asignar22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/asignar"))))
        

// @LINE:38
private[this] lazy val controllers_administracion_PermisosController_desasignar23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/desasignar"))))
        

// @LINE:39
private[this] lazy val controllers_administracion_ProvinciasController_listOptions24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/provincias/listOptions"))))
        

// @LINE:40
private[this] lazy val controllers_administracion_LocalidadesController_listOptions25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/localidades/listOptions"))))
        

// @LINE:41
private[this] lazy val controllers_administracion_GruposController_index26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/grupos"))))
        

// @LINE:42
private[this] lazy val controllers_administracion_GruposController_crear27 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/grupos/crear"))))
        

// @LINE:43
private[this] lazy val controllers_administracion_GruposController_eliminar28 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/grupos/eliminar"))))
        

// @LINE:44
private[this] lazy val controllers_administracion_GruposController_editar29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/grupos/editar"))))
        

// @LINE:45
private[this] lazy val controllers_administracion_GruposController_actualizar30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/grupos/actualizar"))))
        

// @LINE:46
private[this] lazy val controllers_administracion_GruposController_guardar31 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/grupos/guardar"))))
        

// @LINE:47
private[this] lazy val controllers_administracion_GruposController_modalBuscar32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/grupos/modalBuscar"))))
        

// @LINE:48
private[this] lazy val controllers_administracion_GruposController_get33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/grupos/get"))))
        

// @LINE:51
private[this] lazy val controllers_administracion_TicketsController_index34 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/tickets"))))
        

// @LINE:52
private[this] lazy val controllers_administracion_TicketsController_crear35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/tickets/crear"))))
        

// @LINE:53
private[this] lazy val controllers_administracion_TicketsController_guardar36 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/tickets/guardar"))))
        

// @LINE:54
private[this] lazy val controllers_administracion_TicketsController_editar37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/tickets/editar"))))
        

// @LINE:55
private[this] lazy val controllers_administracion_TicketsController_actualizar38 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/tickets/actualizar"))))
        

// @LINE:56
private[this] lazy val controllers_administracion_TicketsController_cambiarEstado39 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/tickets/cambiarEstado"))))
        

// @LINE:57
private[this] lazy val controllers_administracion_TicketsController_ver40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/tickets/ver"))))
        

// @LINE:58
private[this] lazy val controllers_administracion_TicketsController_eliminar41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("administracion/tickets/eliminar"))))
        

// @LINE:65
private[this] lazy val controllers_compras_IndexController_index42 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras"))))
        

// @LINE:66
private[this] lazy val controllers_compras_SolicitudesController_index43 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud"))))
        

// @LINE:67
private[this] lazy val controllers_compras_SolicitudesController_crearSolicitud44 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/crear"))))
        

// @LINE:68
private[this] lazy val controllers_compras_SolicitudesController_guardarSolicitud45 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/guardar"))))
        

// @LINE:69
private[this] lazy val controllers_compras_SolicitudesController_ver46 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/ver"))))
        

// @LINE:70
private[this] lazy val controllers_compras_SolicitudesController_editar47 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/editar"))))
        

// @LINE:71
private[this] lazy val controllers_compras_SolicitudesController_duplicar48 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/duplicar"))))
        

// @LINE:72
private[this] lazy val controllers_compras_SolicitudesController_eliminar49 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/eliminar"))))
        

// @LINE:73
private[this] lazy val controllers_compras_SolicitudesController_actualizar50 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/actualizar"))))
        

// @LINE:74
private[this] lazy val controllers_compras_SolicitudesController_modificarEntregado51 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/modificarEntregado"))))
        

// @LINE:75
private[this] lazy val controllers_compras_SolicitudesController_cambiarEstado52 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/cambiarEstado"))))
        

// @LINE:76
private[this] lazy val controllers_compras_SolicitudesController_redirectSearchIndex53 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/redirectIndex"))))
        

// @LINE:78
private[this] lazy val controllers_compras_SolicitudesController_modalEditarCuentaAnalica54 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/modalEditarCuentaAnalitica"))))
        

// @LINE:79
private[this] lazy val controllers_compras_SolicitudesController_editarCuentaAnalitica55 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/editarCuentaAnalitica"))))
        

// @LINE:80
private[this] lazy val controllers_compras_SolicitudesController_modalBuscar56 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/modalBuscar"))))
        

// @LINE:81
private[this] lazy val controllers_compras_SolicitudesController_get57 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/get"))))
        

// @LINE:82
private[this] lazy val controllers_compras_SolicitudAccionesController_modalImportarListaProductos58 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/modalImportarListaProductos"))))
        

// @LINE:83
private[this] lazy val controllers_compras_SolicitudAccionesController_importarListaProductos59 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/importarListaProductos"))))
        

// @LINE:84
private[this] lazy val controllers_compras_SolicitudAccionesController_modalModificarPaciente60 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/modalModificarPacientes"))))
        

// @LINE:85
private[this] lazy val controllers_compras_SolicitudAccionesController_modificarPaciente61 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/modificarPaciente"))))
        

// @LINE:86
private[this] lazy val controllers_compras_SolicitudAccionesController_modalPasarAprobadoPorPresupuesto62 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/modalPasarAprobadoPorPresupuesto"))))
        

// @LINE:87
private[this] lazy val controllers_compras_SolicitudAccionesController_pasarAprobadoPorPresupuesto63 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/pasarAprobadoPorPresupuesto"))))
        

// @LINE:88
private[this] lazy val controllers_compras_SolicitudAccionesController_modalPasarAutorizado64 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/modalPasarAutorizado"))))
        

// @LINE:89
private[this] lazy val controllers_compras_SolicitudAccionesController_pasarAutorizado65 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/pasarAutorizado"))))
        

// @LINE:91
private[this] lazy val controllers_compras_SolicitudAccionesController_modalAsignarUsuario66 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/modalAsignarUsuario"))))
        

// @LINE:92
private[this] lazy val controllers_compras_SolicitudAccionesController_asignarUsuario67 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/asignarUsuario"))))
        

// @LINE:94
private[this] lazy val controllers_compras_LineasOrdenesController_index68 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden/index"))))
        

// @LINE:95
private[this] lazy val controllers_compras_LineasOrdenesController_crear69 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden/crear"))))
        

// @LINE:96
private[this] lazy val controllers_compras_LineasOrdenesController_editar70 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden/editar"))))
        

// @LINE:97
private[this] lazy val controllers_compras_LineasOrdenesController_guardar71 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden/guardar"))))
        

// @LINE:98
private[this] lazy val controllers_compras_LineasOrdenesController_actualizar72 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden/actualizar"))))
        

// @LINE:99
private[this] lazy val controllers_compras_LineasOrdenesController_eliminar73 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden/eliminar"))))
        

// @LINE:100
private[this] lazy val controllers_compras_LineasOrdenesController_modalAddClientes74 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden/modalAddClientes"))))
        

// @LINE:101
private[this] lazy val controllers_compras_LineasOrdenesController_eliminarMasivo75 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden/eliminar-masivo"))))
        

// @LINE:103
private[this] lazy val controllers_compras_OrdenesLineasClientesController_guardarAjax76 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden-cliente/guardarAjax"))))
        

// @LINE:104
private[this] lazy val controllers_compras_OrdenesLineasClientesController_eliminarAjax77 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-orden-cliente/eliminarAjax"))))
        

// @LINE:106
private[this] lazy val controllers_compras_OrdenesReportesController_cuadroComparativoPrecios78 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenCompra/reporte/cuadroComparativoPrecios"))))
        

// @LINE:107
private[this] lazy val controllers_compras_OrdenesReportesController_exportacionDatos79 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenCompra/reporte/exportacionDatos"))))
        

// @LINE:108
private[this] lazy val controllers_compras_OrdenesReportesController_exportacionDatosConLineas80 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenCompra/reporte/exportacionDatosConLineas"))))
        

// @LINE:109
private[this] lazy val controllers_compras_OrdenesReportesController_cuadroSugerenciaAdjudicación81 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenCompra/reporte/cuadroSugerenciaAdjudicacion"))))
        

// @LINE:110
private[this] lazy val controllers_compras_OrdenesReportesController_controlDolar82 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenCompra/reporte/controlDolar"))))
        

// @LINE:111
private[this] lazy val controllers_compras_OrdenesReportesController_reporteCertificacionPaciente83 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenCompra/reporte/reporteCertificacionPaciente"))))
        

// @LINE:112
private[this] lazy val controllers_compras_OrdenesReportesController_controlProfe84 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenCompra/reporte/controlProfe"))))
        

// @LINE:114
private[this] lazy val controllers_compras_OrdenesLineasAjustesController_index85 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/linea-orden-ajuste/index"))))
        

// @LINE:115
private[this] lazy val controllers_compras_OrdenesLineasAjustesController_guardar86 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/linea-orden-ajuste/guardar"))))
        

// @LINE:116
private[this] lazy val controllers_compras_OrdenesLineasAjustesController_eliminar87 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/linea-orden-ajuste/eliminar"))))
        

// @LINE:117
private[this] lazy val controllers_compras_OrdenesLineasAjustesController_crear88 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/linea-orden-ajuste/crear"))))
        

// @LINE:119
private[this] lazy val controllers_compras_LineasSolicitudesController_index89 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-solicitud/index"))))
        

// @LINE:120
private[this] lazy val controllers_compras_LineasSolicitudesController_crear90 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-solicitud/crear"))))
        

// @LINE:121
private[this] lazy val controllers_compras_LineasSolicitudesController_editar91 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-solicitud/editar"))))
        

// @LINE:122
private[this] lazy val controllers_compras_LineasSolicitudesController_guardar92 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-solicitud/guardar"))))
        

// @LINE:123
private[this] lazy val controllers_compras_LineasSolicitudesController_actualizar93 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-solicitud/actualizar"))))
        

// @LINE:124
private[this] lazy val controllers_compras_LineasSolicitudesController_eliminar94 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-solicitud/eliminar"))))
        

// @LINE:125
private[this] lazy val controllers_compras_LineasSolicitudesController_eliminarMasivo95 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-solicitud/eliminarMasivo"))))
        

// @LINE:128
private[this] lazy val controllers_compras_AjustesSolicitudesController_index96 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/ajuste-solicitud/index"))))
        

// @LINE:129
private[this] lazy val controllers_compras_AjustesSolicitudesController_crear97 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/ajuste-solicitud/crear"))))
        

// @LINE:130
private[this] lazy val controllers_compras_AjustesSolicitudesController_guardar98 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/ajuste-solicitud/guardar"))))
        

// @LINE:131
private[this] lazy val controllers_compras_AjustesSolicitudesController_eliminar99 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/ajuste-solicitud/eliminar"))))
        

// @LINE:133
private[this] lazy val controllers_compras_OrdenesController_index100 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden"))))
        

// @LINE:134
private[this] lazy val controllers_compras_OrdenesController_crear101 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/crear"))))
        

// @LINE:135
private[this] lazy val controllers_compras_OrdenesController_guardar102 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/guardar"))))
        

// @LINE:136
private[this] lazy val controllers_compras_OrdenesController_editar103 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/editar"))))
        

// @LINE:137
private[this] lazy val controllers_compras_OrdenesController_eliminar104 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/eliminar"))))
        

// @LINE:138
private[this] lazy val controllers_compras_OrdenesController_duplicar105 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/duplicar"))))
        

// @LINE:139
private[this] lazy val controllers_compras_OrdenesController_actualizar106 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/actualizar"))))
        

// @LINE:140
private[this] lazy val controllers_compras_OrdenesAccionesController_modalImportarListaProductos107 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/modalImportarListaProductos"))))
        

// @LINE:141
private[this] lazy val controllers_compras_OrdenesAccionesController_importarListaProductos108 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/importarListaProductos"))))
        

// @LINE:143
private[this] lazy val controllers_compras_OrdenesController_ver109 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/ver"))))
        

// @LINE:144
private[this] lazy val controllers_compras_OrdenesController_modalEditarCuentaAnalica110 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/modalEditarCuentaAnalitica"))))
        

// @LINE:145
private[this] lazy val controllers_compras_OrdenesController_editarCuentaAnalitica111 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/editarCuentaAnalitica"))))
        

// @LINE:146
private[this] lazy val controllers_compras_OrdenesController_cambiarEstado112 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/cambiarEstado"))))
        

// @LINE:147
private[this] lazy val controllers_compras_OrdenesController_modalBuscar113 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/modalBuscar"))))
        

// @LINE:148
private[this] lazy val controllers_compras_OrdenesController_get114 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/get"))))
        

// @LINE:150
private[this] lazy val controllers_compras_OrdenesAccionesController_modalEditarMontoAdelanto115 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/modalEditarMontoAdelanto"))))
        

// @LINE:151
private[this] lazy val controllers_compras_OrdenesAccionesController_editarMontoAdelanto116 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/editarMontoAdelanto"))))
        

// @LINE:152
private[this] lazy val controllers_compras_OrdenesAccionesController_modalEditarCotDolar117 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/modalEditarCotDolar"))))
        

// @LINE:153
private[this] lazy val controllers_compras_OrdenesAccionesController_editarCotDolar118 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/editarCotDolar"))))
        

// @LINE:154
private[this] lazy val controllers_compras_OrdenesAccionesController_modalEditarFechaProvision119 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/modalEditarFechaProvision"))))
        

// @LINE:155
private[this] lazy val controllers_compras_OrdenesAccionesController_editarFechaProvision120 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/editarFechaProvision"))))
        

// @LINE:156
private[this] lazy val controllers_compras_OrdenesAccionesController_modalEditarRubro121 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/modalEditarRubro"))))
        

// @LINE:157
private[this] lazy val controllers_compras_OrdenesAccionesController_editarRubro122 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/editarRubro"))))
        

// @LINE:158
private[this] lazy val controllers_compras_OrdenesAccionesController_modalOrdenMail123 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/modalOrdenMail"))))
        

// @LINE:159
private[this] lazy val controllers_compras_OrdenesAccionesController_enviarOrdenMail124 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/enviarOrdenMail"))))
        

// @LINE:160
private[this] lazy val controllers_compras_OrdenSubrubroController_listOptions125 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/ordenSubrubro/listOptions"))))
        

// @LINE:161
private[this] lazy val controllers_compras_OrdenesAccionesController_modalCrearDispo126 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/modalCrearDispo"))))
        

// @LINE:162
private[this] lazy val controllers_compras_OrdenesAccionesController_crearDispo127 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/crearDispo"))))
        

// @LINE:164
private[this] lazy val controllers_compras_CertificacionesController_index128 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion"))))
        

// @LINE:165
private[this] lazy val controllers_compras_CertificacionesController_crear129 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/crear"))))
        

// @LINE:166
private[this] lazy val controllers_compras_CertificacionesController_guardar130 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/guardar"))))
        

// @LINE:167
private[this] lazy val controllers_compras_CertificacionesController_editar131 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/editar"))))
        

// @LINE:168
private[this] lazy val controllers_compras_CertificacionesController_eliminar132 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/eliminar"))))
        

// @LINE:169
private[this] lazy val controllers_compras_CertificacionesController_ver133 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/ver"))))
        

// @LINE:170
private[this] lazy val controllers_compras_CertificacionesController_duplicar134 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/duplicar"))))
        

// @LINE:171
private[this] lazy val controllers_compras_CertificacionesController_actualizar135 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/actualizar"))))
        

// @LINE:172
private[this] lazy val controllers_compras_CertificacionesController_cambiarEstado136 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/cambiarEstado"))))
        

// @LINE:173
private[this] lazy val controllers_compras_CertificacionesController_modalEditarCuentaAnalica137 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalEditarCuentaAnalitica"))))
        

// @LINE:174
private[this] lazy val controllers_compras_CertificacionesController_editarCuentaAnalitica138 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/editarCuentaAnalitica"))))
        

// @LINE:175
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalPasarEnCurso139 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalPasarEnCurso"))))
        

// @LINE:176
private[this] lazy val controllers_compras_CertificacionesAccionesController_pasarEnCursoMasivo140 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/pasarEnCursoMasivo"))))
        

// @LINE:177
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalPasarCertificado141 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalPasarCertificado"))))
        

// @LINE:178
private[this] lazy val controllers_compras_CertificacionesAccionesController_pasarCertificadoMasivo142 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/pasarCertificadoMasivo"))))
        

// @LINE:179
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalPasarAprobado143 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalPasarAprobado"))))
        

// @LINE:180
private[this] lazy val controllers_compras_CertificacionesAccionesController_pasarAprobadoMasivo144 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/pasarAprobadoMasivo"))))
        

// @LINE:181
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalPasarBorrador145 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalPasarBorrador"))))
        

// @LINE:182
private[this] lazy val controllers_compras_CertificacionesAccionesController_pasarBorradorMasivo146 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/pasarBorradorMasivo"))))
        

// @LINE:183
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalPasarCancelado147 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalPasarCancelado"))))
        

// @LINE:184
private[this] lazy val controllers_compras_CertificacionesAccionesController_pasarCanceladoMasivo148 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/pasarCanceladoMasivo"))))
        

// @LINE:185
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalEditarFechaCertificacion149 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalEditarFechaCertificacion"))))
        

// @LINE:186
private[this] lazy val controllers_compras_CertificacionesAccionesController_editarFechaCertificacionMasivo150 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/editarFechaCertificacionMasivo"))))
        

// @LINE:187
private[this] lazy val controllers_compras_CertificacionesReportesController_reporteTasas151 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/reporteTasa"))))
        

// @LINE:188
private[this] lazy val controllers_compras_CertificacionesReportesController_reporteElevaciones152 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/reporteElevaciones"))))
        

// @LINE:189
private[this] lazy val controllers_compras_CertificacionesReportesController_bajas153 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/reportes/bajas"))))
        

// @LINE:190
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalDuplicarMasivo154 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalDuplicarMasivo"))))
        

// @LINE:191
private[this] lazy val controllers_compras_CertificacionesAccionesController_duplicarMasivo155 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/duplicarMasivo"))))
        

// @LINE:192
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalCrearAguinaldo156 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalCrearAguinaldo"))))
        

// @LINE:193
private[this] lazy val controllers_compras_CertificacionesAccionesController_crearAguinaldo157 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/CrearAguinaldo"))))
        

// @LINE:194
private[this] lazy val controllers_compras_CertificacionesReportesController_reportePlanillaSueldos158 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/reportePlanilla"))))
        

// @LINE:195
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalDetalleCertificacion159 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalDetalleCertificacion"))))
        

// @LINE:196
private[this] lazy val controllers_compras_CertificacionesAccionesController_modalDetalleCertificacionesPorEstadoPorPeriodo160 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion/modalDetalleCertificacionesPorEstadoPorPeriodo"))))
        

// @LINE:198
private[this] lazy val controllers_compras_LineasCertificacionesController_index161 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea/index"))))
        

// @LINE:199
private[this] lazy val controllers_compras_LineasCertificacionesController_crear162 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea/crear"))))
        

// @LINE:200
private[this] lazy val controllers_compras_LineasCertificacionesController_editar163 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea/editar"))))
        

// @LINE:201
private[this] lazy val controllers_compras_LineasCertificacionesController_guardar164 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea/guardar"))))
        

// @LINE:202
private[this] lazy val controllers_compras_LineasCertificacionesController_actualizar165 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea/actualizar"))))
        

// @LINE:203
private[this] lazy val controllers_compras_LineasCertificacionesController_eliminar166 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea/eliminar"))))
        

// @LINE:205
private[this] lazy val controllers_compras_CertificacionesComprasLineaAjustesController_index167 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea-ajuste/index"))))
        

// @LINE:206
private[this] lazy val controllers_compras_CertificacionesComprasLineaAjustesController_crear168 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea-ajuste/crear"))))
        

// @LINE:207
private[this] lazy val controllers_compras_CertificacionesComprasLineaAjustesController_editar169 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea-ajuste/editar"))))
        

// @LINE:208
private[this] lazy val controllers_compras_CertificacionesComprasLineaAjustesController_guardar170 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea-ajuste/guardar"))))
        

// @LINE:210
private[this] lazy val controllers_compras_CertificacionesComprasLineaAjustesController_actualizar171 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea-ajuste/actualizar"))))
        

// @LINE:211
private[this] lazy val controllers_compras_CertificacionesComprasLineaAjustesController_eliminar172 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-linea-ajuste/eliminar"))))
        

// @LINE:213
private[this] lazy val controllers_compras_CertificacionesReportesController_reporteCertificacion173 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificaciones/reporteCertificacion"))))
        

// @LINE:215
private[this] lazy val controllers_compras_CertificacionesController_crearMasivo174 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificaciones/acciones/crear-masivo"))))
        

// @LINE:216
private[this] lazy val controllers_compras_CertificacionesController_procesarMasivo175 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificaciones/acciones/procesar-masivo"))))
        

// @LINE:218
private[this] lazy val controllers_compras_SolicitudesReportesController_reporteImputacionPreventivaLista176 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/reporte/imputacionPreventiva"))))
        

// @LINE:219
private[this] lazy val controllers_compras_OrdenesReportesController_reporteImputacionDefinitivaGlobal177 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/orden/reporte/imputacionDefinitiva"))))
        

// @LINE:220
private[this] lazy val controllers_compras_SolicitudesReportesController_reporteCuadroSolicitud178 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/reporte/cuadroSolicitud"))))
        

// @LINE:221
private[this] lazy val controllers_compras_SolicitudesReportesController_reporteLineasCotizacion179 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/reporte/lineasCotizacion"))))
        

// @LINE:222
private[this] lazy val controllers_compras_OrdenesReportesController_listadoLineas180 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("orden/reporte/listadoLineas"))))
        

// @LINE:223
private[this] lazy val controllers_compras_OrdenesReportesController_reporteImputacionDefinitiva181 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/reporte/imputacionDefinitiva"))))
        

// @LINE:225
private[this] lazy val controllers_compras_SolicitudesReportesController_modalInformeFarmacia182 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/reporte/modalInformeFarmacia"))))
        

// @LINE:226
private[this] lazy val controllers_compras_SolicitudesReportesController_informeFarmacia183 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/reporte/informeFarmacia"))))
        

// @LINE:227
private[this] lazy val controllers_compras_SolicitudesReportesController_modalInformeFarmaciaPorUsuario184 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/reporte/modalInformeFarmaciaPorUsuario"))))
        

// @LINE:228
private[this] lazy val controllers_compras_SolicitudesReportesController_informeFarmaciaPorUsuario185 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/reporte/informeFarmaciaPorUsuario"))))
        

// @LINE:231
private[this] lazy val controllers_compras_SolicitudesReportesController_informeFarmaciaPaciente186 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/solicitud/reporte/informeFarmaciaPaciente"))))
        

// @LINE:233
private[this] lazy val controllers_compras_PedidosFondosController_index187 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedidoFondo"))))
        

// @LINE:234
private[this] lazy val controllers_compras_PedidosFondosController_crear188 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedidoFondo/crear"))))
        

// @LINE:235
private[this] lazy val controllers_compras_PedidosFondosController_guardar189 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedidoFondo/guardar"))))
        

// @LINE:236
private[this] lazy val controllers_compras_PedidosFondosController_editar190 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedidoFondo/editar"))))
        

// @LINE:237
private[this] lazy val controllers_compras_PedidosFondosController_eliminar191 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedidoFondo/eliminar"))))
        

// @LINE:238
private[this] lazy val controllers_compras_PedidosFondosController_ver192 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedidoFondo/ver"))))
        

// @LINE:239
private[this] lazy val controllers_compras_PedidosFondosController_actualizar193 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedidoFondo/actualizar"))))
        

// @LINE:240
private[this] lazy val controllers_compras_LineasPedidosFondosController_index194 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedido-fondo-linea/index"))))
        

// @LINE:241
private[this] lazy val controllers_compras_LineasPedidosFondosController_crear195 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedido-fondo-linea/crear"))))
        

// @LINE:242
private[this] lazy val controllers_compras_LineasPedidosFondosController_editar196 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedido-fondo-linea/editar"))))
        

// @LINE:243
private[this] lazy val controllers_compras_LineasPedidosFondosController_guardar197 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedido-fondo-linea/guardar"))))
        

// @LINE:244
private[this] lazy val controllers_compras_LineasPedidosFondosController_actualizar198 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedido-fondo-linea/actualizar"))))
        

// @LINE:245
private[this] lazy val controllers_compras_LineasPedidosFondosController_eliminar199 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/pedido-fondo-linea/eliminar"))))
        

// @LINE:247
private[this] lazy val controllers_compras_OrdenesAccionesController_combinar200 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/acciones/combinar"))))
        

// @LINE:248
private[this] lazy val controllers_compras_OrdenesAccionesController_generarOrdenSegunCuadroSugerenia201 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/acciones/generarOrdenSegunCuadroSugerenia"))))
        

// @LINE:249
private[this] lazy val controllers_compras_SolicitudesReportesController_reportePedidoAbastecimiento202 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/reporte/reportePedidoAbastecimiento"))))
        

// @LINE:250
private[this] lazy val controllers_compras_SolicitudesReportesController_reporteImputacionPreventiva203 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/reporte/imputacionPreventiva"))))
        

// @LINE:252
private[this] lazy val controllers_compras_ProveedoresController_index204 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores"))))
        

// @LINE:253
private[this] lazy val controllers_compras_ProveedoresController_crear205 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/crear"))))
        

// @LINE:255
private[this] lazy val controllers_compras_ProveedoresController_guardar206 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/guardar"))))
        

// @LINE:256
private[this] lazy val controllers_compras_ProveedoresController_eliminar207 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/eliminar"))))
        

// @LINE:257
private[this] lazy val controllers_compras_ProveedoresController_eliminarContacto208 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/eliminarContacto"))))
        

// @LINE:258
private[this] lazy val controllers_compras_ProveedoresController_editar209 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/editar"))))
        

// @LINE:259
private[this] lazy val controllers_compras_ProveedoresController_formularioContacto210 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/editarContacto"))))
        

// @LINE:260
private[this] lazy val controllers_compras_ProveedoresController_actualizarContacto211 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/actualizarContacto"))))
        

// @LINE:261
private[this] lazy val controllers_compras_ProveedoresController_guardarContacto212 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/guardarContacto"))))
        

// @LINE:262
private[this] lazy val controllers_compras_ProveedoresController_actualizar213 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/actualizar"))))
        

// @LINE:263
private[this] lazy val controllers_compras_ProveedoresController_modalBuscar214 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/modalBuscar"))))
        

// @LINE:264
private[this] lazy val controllers_compras_ProveedoresController_get215 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/get"))))
        

// @LINE:265
private[this] lazy val controllers_compras_ProveedoresAccionesController_modalInformacionProveedor216 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/modalInformacionProveedor"))))
        

// @LINE:266
private[this] lazy val controllers_compras_ProveedoresController_ver217 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/ver"))))
        

// @LINE:268
private[this] lazy val controllers_compras_ProveedoresAccionesController_actualizarMail218 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/proveedores/actualizarMail"))))
        

// @LINE:270
private[this] lazy val controllers_compras_ClientesController_index219 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes"))))
        

// @LINE:271
private[this] lazy val controllers_compras_ClientesController_crear220 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/crear"))))
        

// @LINE:272
private[this] lazy val controllers_compras_ClientesController_guardar221 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/guardar"))))
        

// @LINE:273
private[this] lazy val controllers_compras_ClientesController_editar222 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/editar"))))
        

// @LINE:274
private[this] lazy val controllers_compras_ClientesController_actualizar223 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/actualizar"))))
        

// @LINE:275
private[this] lazy val controllers_compras_ClientesController_eliminar224 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/eliminar"))))
        

// @LINE:276
private[this] lazy val controllers_compras_ClientesController_ver225 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/ver"))))
        

// @LINE:277
private[this] lazy val controllers_compras_ClientesController_formularioContacto226 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/editarContacto"))))
        

// @LINE:278
private[this] lazy val controllers_compras_ClientesController_eliminarContacto227 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/eliminarContacto"))))
        

// @LINE:279
private[this] lazy val controllers_compras_ClientesController_modalBuscar228 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/modalBuscar"))))
        

// @LINE:280
private[this] lazy val controllers_compras_ClientesController_actualizarContacto229 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/clientes/actualizarContacto"))))
        

// @LINE:281
private[this] lazy val controllers_compras_ClientesController_get230 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/get"))))
        

// @LINE:282
private[this] lazy val controllers_compras_ClientesController_modalCarga231 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/modalCargar"))))
        

// @LINE:283
private[this] lazy val controllers_compras_ClientesController_guardarDesdeModal232 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/guardarDesdeModal"))))
        

// @LINE:285
private[this] lazy val controllers_compras_ProductosController_indexProducto233 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/productos"))))
        

// @LINE:286
private[this] lazy val controllers_compras_ProductosController_listarProducto234 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/productos/"))))
        

// @LINE:287
private[this] lazy val controllers_compras_ProductosController_crearProducto235 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/productos/crear"))))
        

// @LINE:288
private[this] lazy val controllers_compras_ProductosController_guardarProducto236 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/productos/guardar"))))
        

// @LINE:289
private[this] lazy val controllers_compras_ProductosController_editarProducto237 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/productos/editar"))))
        

// @LINE:290
private[this] lazy val controllers_compras_ProductosController_eliminarProducto238 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/productos/eliminar"))))
        

// @LINE:291
private[this] lazy val controllers_compras_ProductosController_actualizarProducto239 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/actualizar"))))
        

// @LINE:292
private[this] lazy val controllers_compras_ProductosController_modalBuscar240 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/modalBuscar"))))
        

// @LINE:293
private[this] lazy val controllers_compras_ProductosController_modalBuscarIps241 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/modalBuscarIps"))))
        

// @LINE:294
private[this] lazy val controllers_compras_ProductosController_modalBuscarSolicitudes242 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/modalBuscarSolicitudes"))))
        

// @LINE:295
private[this] lazy val controllers_compras_ProductosController_get243 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/get"))))
        

// @LINE:296
private[this] lazy val controllers_compras_ProductosController_ver244 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/ver"))))
        

// @LINE:297
private[this] lazy val controllers_compras_ProductosController_getPrecioProducto245 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/getPrecio"))))
        

// @LINE:298
private[this] lazy val controllers_compras_ProductosController_cargaProductoRismi246 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/cargaProductoRismi"))))
        

// @LINE:299
private[this] lazy val controllers_compras_ProductosController_modalCarga247 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/modalCargar"))))
        

// @LINE:300
private[this] lazy val controllers_compras_ProductosController_guardarProductoDesdeModal248 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/producto/guardarProductoDesdeModal"))))
        

// @LINE:302
private[this] lazy val controllers_compras_CategoriasController_indexCategoria249 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/categorias"))))
        

// @LINE:303
private[this] lazy val controllers_compras_CategoriasController_crearCategoria250 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/categorias/crear"))))
        

// @LINE:304
private[this] lazy val controllers_compras_CategoriasController_guardarCategoria251 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/categorias/guardar"))))
        

// @LINE:305
private[this] lazy val controllers_compras_CategoriasController_editarCategoria252 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/categorias/editar"))))
        

// @LINE:306
private[this] lazy val controllers_compras_CategoriasController_eliminarCategoria253 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/categorias/eliminar"))))
        

// @LINE:307
private[this] lazy val controllers_compras_CategoriasController_actualizarCategoria254 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/categorias/actualizar"))))
        

// @LINE:308
private[this] lazy val controllers_compras_CategoriasController_modalBuscar255 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/categorias/modalBuscar"))))
        

// @LINE:309
private[this] lazy val controllers_compras_CategoriasController_get256 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/categorias/get"))))
        

// @LINE:311
private[this] lazy val controllers_compras_TipoProductosController_indexTipoProducto257 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/tipo-producto"))))
        

// @LINE:312
private[this] lazy val controllers_compras_TipoProductosController_crearTipoProducto258 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/tipo-producto/crear"))))
        

// @LINE:313
private[this] lazy val controllers_compras_TipoProductosController_guardarTipoProducto259 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/tipo-producto/guardar"))))
        

// @LINE:314
private[this] lazy val controllers_compras_TipoProductosController_editarTipoProducto260 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/tipo-producto/editar"))))
        

// @LINE:315
private[this] lazy val controllers_compras_TipoProductosController_eliminarTipoProducto261 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/tipo-producto/eliminar"))))
        

// @LINE:316
private[this] lazy val controllers_compras_TipoProductosController_actualizarTipoProducto262 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/tipo-producto/actualizar"))))
        

// @LINE:317
private[this] lazy val controllers_compras_TipoProductosController_modalBuscar263 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/tipo-producto/modalBuscar"))))
        

// @LINE:318
private[this] lazy val controllers_compras_TipoProductosController_get264 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/tipo-producto/get"))))
        

// @LINE:320
private[this] lazy val controllers_compras_ArticulosController_indexArticulo265 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/articulo"))))
        

// @LINE:321
private[this] lazy val controllers_compras_ArticulosController_crearArticulo266 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/articulo/crear"))))
        

// @LINE:322
private[this] lazy val controllers_compras_ArticulosController_guardarArticulo267 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/articulo/guardar"))))
        

// @LINE:323
private[this] lazy val controllers_compras_ArticulosController_editarArticulo268 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/articulo/editar"))))
        

// @LINE:324
private[this] lazy val controllers_compras_ArticulosController_eliminarArticulo269 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/articulo/eliminar"))))
        

// @LINE:325
private[this] lazy val controllers_compras_ArticulosController_actualizarArticulo270 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/articulo/actualizar"))))
        

// @LINE:326
private[this] lazy val controllers_compras_ArticulosController_modalBuscar271 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/articulo/modalBuscar"))))
        

// @LINE:327
private[this] lazy val controllers_compras_ArticulosController_get272 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/articulo/get"))))
        

// @LINE:329
private[this] lazy val controllers_compras_ProveedorAtributosController_index273 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-atributo/index"))))
        

// @LINE:330
private[this] lazy val controllers_compras_ProveedorAtributosController_crear274 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-atributo/crear"))))
        

// @LINE:331
private[this] lazy val controllers_compras_ProveedorAtributosController_editar275 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-atributo/editar"))))
        

// @LINE:332
private[this] lazy val controllers_compras_ProveedorAtributosController_guardar276 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-atributo/guardar"))))
        

// @LINE:333
private[this] lazy val controllers_compras_ProveedorAtributosController_actualizar277 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-atributo/actualizar"))))
        

// @LINE:334
private[this] lazy val controllers_compras_ProveedorAtributosController_eliminar278 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-atributo/eliminar"))))
        

// @LINE:336
private[this] lazy val controllers_compras_ProveedorDatosDgrController_index279 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-datodgr/index"))))
        

// @LINE:337
private[this] lazy val controllers_compras_ProveedorDatosDgrController_crear280 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-datodgr/crear"))))
        

// @LINE:338
private[this] lazy val controllers_compras_ProveedorDatosDgrController_editar281 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-datodgr/editar"))))
        

// @LINE:339
private[this] lazy val controllers_compras_ProveedorDatosDgrController_guardar282 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-datodgr/guardar"))))
        

// @LINE:340
private[this] lazy val controllers_compras_ProveedorDatosDgrController_actualizar283 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-datodgr/actualizar"))))
        

// @LINE:341
private[this] lazy val controllers_compras_ProveedorDatosDgrController_eliminar284 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/linea-proveedor-datodgr/eliminar"))))
        

// @LINE:343
private[this] lazy val controllers_compras_ObrasSocialesController_modalBuscar285 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/ob/modalBuscar"))))
        

// @LINE:344
private[this] lazy val controllers_compras_ObrasSocialesController_get286 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/ob/get"))))
        

// @LINE:347
private[this] lazy val controllers_compras_CertificacionesComprasController_index287 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra"))))
        

// @LINE:348
private[this] lazy val controllers_compras_CertificacionesComprasController_crear288 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/crear"))))
        

// @LINE:349
private[this] lazy val controllers_compras_CertificacionesComprasController_guardar289 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/guardar"))))
        

// @LINE:350
private[this] lazy val controllers_compras_CertificacionesComprasController_editar290 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/editar"))))
        

// @LINE:351
private[this] lazy val controllers_compras_CertificacionesComprasController_eliminar291 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/eliminar"))))
        

// @LINE:352
private[this] lazy val controllers_compras_CertificacionesComprasController_ver292 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/ver"))))
        

// @LINE:353
private[this] lazy val controllers_compras_CertificacionesComprasController_duplicar293 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/duplicar"))))
        

// @LINE:354
private[this] lazy val controllers_compras_CertificacionesComprasController_actualizar294 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/actualizar"))))
        

// @LINE:355
private[this] lazy val controllers_compras_CertificacionesComprasController_cambiarEstado295 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/cambiarEstado"))))
        

// @LINE:356
private[this] lazy val controllers_compras_CertificacionesComprasController_modalEditarCuentaAnalica296 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/modalEditarCuentaAnalitica"))))
        

// @LINE:357
private[this] lazy val controllers_compras_CertificacionesComprasController_editarCuentaAnalitica297 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/editarCuentaAnalitica"))))
        

// @LINE:358
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_modalPasarEnCurso298 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/modalPasarEnCurso"))))
        

// @LINE:359
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_pasarEnCursoMasivo299 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/pasarEnCursoMasivo"))))
        

// @LINE:360
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_modalPasarCertificado300 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/modalPasarCertificado"))))
        

// @LINE:361
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_pasarCertificadoMasivo301 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/pasarCertificadoMasivo"))))
        

// @LINE:362
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_modalPasarBorrador302 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/modalPasarBorrador"))))
        

// @LINE:363
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_pasarBorradorMasivo303 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/pasarBorradorMasivo"))))
        

// @LINE:364
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_modalPasarCancelado304 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/modalPasarCancelado"))))
        

// @LINE:365
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_pasarCanceladoMasivo305 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/pasarCanceladoMasivo"))))
        

// @LINE:366
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_modalEditarFechaCertificacion306 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/modalEditarFechaCertificacion"))))
        

// @LINE:367
private[this] lazy val controllers_compras_CertificacionesComprasAccionesController_editarFechaCertificacionMasivo307 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra/editarFechaCertificacionMasivo"))))
        

// @LINE:369
private[this] lazy val controllers_compras_CertificacionesComprasLineasController_index308 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra-linea/index"))))
        

// @LINE:370
private[this] lazy val controllers_compras_CertificacionesComprasLineasController_crear309 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra-linea/crear"))))
        

// @LINE:371
private[this] lazy val controllers_compras_CertificacionesComprasLineasController_editar310 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra-linea/editar"))))
        

// @LINE:372
private[this] lazy val controllers_compras_CertificacionesComprasLineasController_guardar311 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra-linea/guardar"))))
        

// @LINE:373
private[this] lazy val controllers_compras_CertificacionesComprasLineasController_actualizar312 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra-linea/actualizar"))))
        

// @LINE:374
private[this] lazy val controllers_compras_CertificacionesComprasLineasController_eliminar313 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-compra-linea/eliminar"))))
        

// @LINE:376
private[this] lazy val controllers_compras_CertificacionesComprasReportesController_reporteCertificacion314 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificaciones-compra/reporteCertificacion"))))
        

// @LINE:378
private[this] lazy val controllers_compras_CertificacionesObrasController_index315 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra"))))
        

// @LINE:379
private[this] lazy val controllers_compras_CertificacionesObrasController_crear316 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/crear"))))
        

// @LINE:380
private[this] lazy val controllers_compras_CertificacionesObrasController_guardar317 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/guardar"))))
        

// @LINE:381
private[this] lazy val controllers_compras_CertificacionesObrasController_editar318 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/editar"))))
        

// @LINE:382
private[this] lazy val controllers_compras_CertificacionesObrasController_eliminar319 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/eliminar"))))
        

// @LINE:383
private[this] lazy val controllers_compras_CertificacionesObrasController_ver320 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/ver"))))
        

// @LINE:384
private[this] lazy val controllers_compras_CertificacionesObrasController_duplicar321 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/duplicar"))))
        

// @LINE:385
private[this] lazy val controllers_compras_CertificacionesObrasController_actualizar322 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/actualizar"))))
        

// @LINE:386
private[this] lazy val controllers_compras_CertificacionesObrasController_cambiarEstado323 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/cambiarEstado"))))
        

// @LINE:387
private[this] lazy val controllers_compras_CertificacionesObrasController_modalEditarCuentaAnalica324 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/modalEditarCuentaAnalitica"))))
        

// @LINE:388
private[this] lazy val controllers_compras_CertificacionesObrasController_editarCuentaAnalitica325 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/certificacion-obra/editarCuentaAnalitica"))))
        

// @LINE:400
private[this] lazy val controllers_compras_CajaChicaController_index326 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica"))))
        

// @LINE:401
private[this] lazy val controllers_compras_CajaChicaController_ver327 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/ver"))))
        

// @LINE:402
private[this] lazy val controllers_compras_CajaChicaController_crear328 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/crear"))))
        

// @LINE:403
private[this] lazy val controllers_compras_CajaChicaController_guardar329 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/guardar"))))
        

// @LINE:404
private[this] lazy val controllers_compras_CajaChicaController_editar330 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/editar"))))
        

// @LINE:405
private[this] lazy val controllers_compras_CajaChicaController_actualizar331 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/actualizar"))))
        

// @LINE:406
private[this] lazy val controllers_compras_CajaChicaController_eliminar332 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/eliminar"))))
        

// @LINE:407
private[this] lazy val controllers_compras_CajaChicaController_cambiarEstado333 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/cambiarEstado"))))
        

// @LINE:409
private[this] lazy val controllers_compras_CajaChicaController_resumenPresupuesto334 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/resumenPresupuesto"))))
        

// @LINE:410
private[this] lazy val controllers_compras_CajaChicaController_reporteImputacionPreventivaLista335 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/reporteImputacionPreventivaLista"))))
        

// @LINE:411
private[this] lazy val controllers_compras_CajaChicaController_reporteImputacionPreventivaAjustesLista336 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/reporteImputacionPreventivaListaAjuste"))))
        

// @LINE:412
private[this] lazy val controllers_compras_CajaChicaController_reporteImputacionDefinitiva337 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/reporteImputacionDefinitiva"))))
        

// @LINE:413
private[this] lazy val controllers_compras_CajaChicaController_reporteCajaChica338 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/reporteCajaChica"))))
        

// @LINE:414
private[this] lazy val controllers_compras_CajaChicaController_reporteCajaChicaOrdenCargo339 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica/reporteCajaChicaOrdenCargo"))))
        

// @LINE:416
private[this] lazy val controllers_compras_CajaChicaMovimientosController_lista340 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica-movimientos"))))
        

// @LINE:417
private[this] lazy val controllers_compras_CajaChicaMovimientosController_crear341 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica-movimientos/crear"))))
        

// @LINE:418
private[this] lazy val controllers_compras_CajaChicaMovimientosController_editar342 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica-movimientos/editar"))))
        

// @LINE:419
private[this] lazy val controllers_compras_CajaChicaMovimientosController_guardar343 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica-movimientos/guardar"))))
        

// @LINE:420
private[this] lazy val controllers_compras_CajaChicaMovimientosController_actualizar344 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica-movimientos/actualizar"))))
        

// @LINE:421
private[this] lazy val controllers_compras_CajaChicaMovimientosController_eliminar345 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica-movimientos/eliminar"))))
        

// @LINE:423
private[this] lazy val controllers_compras_CajaChicaPresupuestoLineasController_lista346 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica-presupuesto"))))
        

// @LINE:424
private[this] lazy val controllers_compras_CajaChicaPresupuestoLineasController_crear347 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica-presupuesto/crear"))))
        

// @LINE:425
private[this] lazy val controllers_compras_CajaChicaPresupuestoLineasController_guardar348 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("compras/caja-chica-presupuesto/guardar"))))
        

// @LINE:430
private[this] lazy val controllers_expediente_IndexController_index349 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente"))))
        

// @LINE:431
private[this] lazy val controllers_expediente_IniciadorExpedientesController_indexIniciadorExpediente350 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/iniciadorExpediente"))))
        

// @LINE:432
private[this] lazy val controllers_expediente_IniciadorExpedientesController_crearIniciadorExpediente351 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/iniciadorExpediente/crear"))))
        

// @LINE:433
private[this] lazy val controllers_expediente_IniciadorExpedientesController_guardarIniciadorExpediente352 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/iniciadorExpediente/guardar"))))
        

// @LINE:434
private[this] lazy val controllers_expediente_IniciadorExpedientesController_editarIniciadorExpediente353 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/iniciadorExpediente/editar"))))
        

// @LINE:435
private[this] lazy val controllers_expediente_IniciadorExpedientesController_eliminarIniciadorExpediente354 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expedient/iniciadorExpediente/eliminar"))))
        

// @LINE:436
private[this] lazy val controllers_expediente_IniciadorExpedientesController_actualizarIniciadorExpediente355 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/iniciadorExpediente/actualizar"))))
        

// @LINE:437
private[this] lazy val controllers_expediente_IniciadorExpedientesController_modalBuscar356 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/iniciadorExpediente/modalBuscar"))))
        

// @LINE:438
private[this] lazy val controllers_expediente_IniciadorExpedientesController_get357 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/iniciadorExpediente/get"))))
        

// @LINE:439
private[this] lazy val controllers_expediente_ExpedientesReportesController_reporteMovimiento358 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/reportes/reporteMovimiento"))))
        

// @LINE:441
private[this] lazy val controllers_expediente_ExpedientesController_indexExpediente359 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente"))))
        

// @LINE:442
private[this] lazy val controllers_expediente_ExpedientesController_crearExpediente360 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/crear"))))
        

// @LINE:443
private[this] lazy val controllers_expediente_ExpedientesController_guardarExpediente361 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/guardar"))))
        

// @LINE:444
private[this] lazy val controllers_expediente_ExpedientesController_editarExpediente362 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/editar"))))
        

// @LINE:445
private[this] lazy val controllers_expediente_ExpedientesController_eliminarExpediente363 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/eliminar"))))
        

// @LINE:446
private[this] lazy val controllers_expediente_ExpedientesController_eliminarExpedienteCopia364 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/eliminarCopia"))))
        

// @LINE:447
private[this] lazy val controllers_expediente_ExpedientesController_actualizarExpediente365 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/actualizar"))))
        

// @LINE:448
private[this] lazy val controllers_expediente_ExpedientesController_modalBuscar366 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/modalBuscar"))))
        

// @LINE:449
private[this] lazy val controllers_expediente_ExpedientesController_modalBuscarCopia367 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/modalBuscarCopia"))))
        

// @LINE:450
private[this] lazy val controllers_expediente_ExpedientesController_get368 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/get"))))
        

// @LINE:451
private[this] lazy val controllers_expediente_ExpedientesController_ver369 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/ver"))))
        

// @LINE:452
private[this] lazy val controllers_expediente_ExpedientesController_reporteTapaExpedienteMasivo370 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/reporteTapaExpedienteMasiva"))))
        

// @LINE:453
private[this] lazy val controllers_expediente_ExpedientesController_reporteTapaExpediente371 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/reporteTapaExpediente"))))
        

// @LINE:454
private[this] lazy val controllers_expediente_ExpedientesController_listadoExpedientes372 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/reporteListadoExpedientes"))))
        

// @LINE:455
private[this] lazy val controllers_expediente_ExpedientesController_crearCopia373 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/crearCopia"))))
        

// @LINE:456
private[this] lazy val controllers_expediente_ExpedientesController_crearRP374 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expediente/crearRP"))))
        

// @LINE:457
private[this] lazy val controllers_expediente_ExpedientesController_getExpedientesRecepcionSinFirma375 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/getExpedientesRecepcionSinFirma"))))
        

// @LINE:458
private[this] lazy val controllers_expediente_ExpedientesController_getExpedientesRecepcionSinFirmaReporte376 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/getExpedientesRecepcionSinFirmaReporte"))))
        

// @LINE:459
private[this] lazy val controllers_expediente_ExpedientesController_getExpedientesSinFirma377 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/getExpedientesSinFirma"))))
        

// @LINE:460
private[this] lazy val controllers_expediente_ExpedientesController_getExpedientesSinFirmaReporte378 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/getExpedientesSinFirmaReporte"))))
        

// @LINE:462
private[this] lazy val controllers_expediente_ExpedientesMovimientosController_index379 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/movimiento-linea/index"))))
        

// @LINE:463
private[this] lazy val controllers_expediente_ExpedientesMovimientosController_crear380 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/movimiento-linea/crear"))))
        

// @LINE:464
private[this] lazy val controllers_expediente_ExpedientesMovimientosController_editar381 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/movimiento-linea/editar"))))
        

// @LINE:465
private[this] lazy val controllers_expediente_ExpedientesMovimientosController_guardar382 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/movimiento-linea/guardar"))))
        

// @LINE:466
private[this] lazy val controllers_expediente_ExpedientesMovimientosController_actualizar383 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/movimiento-linea/actualizar"))))
        

// @LINE:467
private[this] lazy val controllers_expediente_ExpedientesMovimientosController_eliminar384 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/movimiento-linea/eliminar"))))
        

// @LINE:469
private[this] lazy val controllers_expediente_ExpedientesAccionesController_modalPasarOtroServicio385 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/acciones/modalPasarOtroServicio"))))
        

// @LINE:470
private[this] lazy val controllers_expediente_ExpedientesAccionesController_modalPasarOtroServicioIndividual386 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/acciones/modalPasarOtroServicioIndividual"))))
        

// @LINE:471
private[this] lazy val controllers_expediente_ExpedientesAccionesController_pasarOtroServicio387 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/acciones/pasarOtroServicio"))))
        

// @LINE:472
private[this] lazy val controllers_expediente_ExpedientesReportesController_reportePaseExpediente388 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/reportes/reportePaseExpediente"))))
        

// @LINE:473
private[this] lazy val controllers_expediente_ExpedientesReportesController_reportePaseExpedienteListaCodigoCombinado389 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/reportes/reportePaseExpedienteLista"))))
        

// @LINE:474
private[this] lazy val controllers_expediente_ExpedientesReportesController_reportePaseExpedienteListaCodigo390 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/reportes/reportePaseExpedienteCodigo"))))
        

// @LINE:476
private[this] lazy val controllers_expediente_ExpedientesReportesController_reportePaseExpedienteLista391 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/reportes/reportePaseExpedienteLista"))))
        

// @LINE:477
private[this] lazy val controllers_expediente_ExpedientesAccionesController_cancelarPase392 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/acciones/cancelarPase"))))
        

// @LINE:478
private[this] lazy val controllers_expediente_ExpedientesAccionesController_cancelarPaseLista393 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/acciones/cancelarPaseLista"))))
        

// @LINE:479
private[this] lazy val controllers_expediente_ExpedientesAccionesController_asignarMiServicio394 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/acciones/asignarMiServicio"))))
        

// @LINE:480
private[this] lazy val controllers_expediente_ExpedientesMisPasesController_index395 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/expedienteMisPases"))))
        

// @LINE:481
private[this] lazy val controllers_expediente_ExpedientesAccionesController_asignarAMiServicioMasivo396 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/acciones/asignarMiServicioMasivo"))))
        

// @LINE:482
private[this] lazy val controllers_expediente_ExpedientesAccionesController_modalAsignarMiServicio397 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/acciones/modalAsignarMiServicio"))))
        

// @LINE:484
private[this] lazy val controllers_expediente_DisposController_index398 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo"))))
        

// @LINE:485
private[this] lazy val controllers_expediente_DisposController_crear399 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/crear"))))
        

// @LINE:486
private[this] lazy val controllers_expediente_DisposController_guardar400 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/guardar"))))
        

// @LINE:487
private[this] lazy val controllers_expediente_DisposController_editar401 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/editar"))))
        

// @LINE:488
private[this] lazy val controllers_expediente_DisposController_actualizar402 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/actualizar"))))
        

// @LINE:489
private[this] lazy val controllers_expediente_DisposController_eliminar403 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/eliminar"))))
        

// @LINE:490
private[this] lazy val controllers_expediente_DisposController_ver404 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/ver"))))
        

// @LINE:491
private[this] lazy val controllers_expediente_DisposController_getLastNumeroDispo405 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/getLastNumeroDispo"))))
        

// @LINE:492
private[this] lazy val controllers_expediente_DisposController_getLastNumeroDispoByOrden406 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/getLastNumeroDispoByOrden"))))
        

// @LINE:493
private[this] lazy val controllers_expediente_DisposController_getDisposPorExpediente407 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/getDisposPorExpediente"))))
        

// @LINE:494
private[this] lazy val controllers_expediente_DisposController_cambiarEstado408 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expediente/dispo/cambiarEstado"))))
        

// @LINE:498
private[this] lazy val controllers_rrhh_IndexController_index409 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh"))))
        

// @LINE:499
private[this] lazy val controllers_rrhh_DepartamentosController_modalBuscar410 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/departamento/modalBuscar"))))
        

// @LINE:500
private[this] lazy val controllers_rrhh_DepartamentosController_get411 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/departamento/get"))))
        

// @LINE:501
private[this] lazy val controllers_rrhh_AgentesEstudiosController_index412 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-estudio/index"))))
        

// @LINE:502
private[this] lazy val controllers_rrhh_AgentesEstudiosController_crear413 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-estudio/crear"))))
        

// @LINE:503
private[this] lazy val controllers_rrhh_AgentesEstudiosController_editar414 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-estudio/editar"))))
        

// @LINE:504
private[this] lazy val controllers_rrhh_AgentesEstudiosController_guardar415 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-estudio/guardar"))))
        

// @LINE:505
private[this] lazy val controllers_rrhh_AgentesEstudiosController_actualizar416 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-estudio/actualizar"))))
        

// @LINE:506
private[this] lazy val controllers_rrhh_AgentesEstudiosController_eliminar417 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-estudio/eliminar"))))
        

// @LINE:507
private[this] lazy val controllers_rrhh_AgentesEstudiosController_listOptionsEstudioSubareas418 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-estudio/listOptionsSubarea"))))
        

// @LINE:509
private[this] lazy val controllers_rrhh_AgentesRulController_index419 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-rul/index"))))
        

// @LINE:510
private[this] lazy val controllers_rrhh_AgentesRulController_crear420 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-rul/crear"))))
        

// @LINE:511
private[this] lazy val controllers_rrhh_AgentesRulController_editar421 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-rul/editar"))))
        

// @LINE:512
private[this] lazy val controllers_rrhh_AgentesRulController_guardar422 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-rul/guardar"))))
        

// @LINE:513
private[this] lazy val controllers_rrhh_AgentesRulController_actualizar423 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-rul/actualizar"))))
        

// @LINE:514
private[this] lazy val controllers_rrhh_AgentesRulController_eliminar424 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-rul/eliminar"))))
        

// @LINE:516
private[this] lazy val controllers_rrhh_AgentesNovedadesController_index425 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-novedad/index"))))
        

// @LINE:517
private[this] lazy val controllers_rrhh_AgentesNovedadesController_crear426 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-novedad/crear"))))
        

// @LINE:518
private[this] lazy val controllers_rrhh_AgentesNovedadesController_editar427 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-novedad/editar"))))
        

// @LINE:519
private[this] lazy val controllers_rrhh_AgentesNovedadesController_guardar428 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-novedad/guardar"))))
        

// @LINE:520
private[this] lazy val controllers_rrhh_AgentesNovedadesController_actualizar429 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-novedad/actualizar"))))
        

// @LINE:521
private[this] lazy val controllers_rrhh_AgentesNovedadesController_eliminar430 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-novedad/eliminar"))))
        

// @LINE:523
private[this] lazy val controllers_rrhh_AgentesHijosController_index431 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-hijo/index"))))
        

// @LINE:524
private[this] lazy val controllers_rrhh_AgentesHijosController_crear432 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-hijo/crear"))))
        

// @LINE:525
private[this] lazy val controllers_rrhh_AgentesHijosController_editar433 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-hijo/editar"))))
        

// @LINE:526
private[this] lazy val controllers_rrhh_AgentesHijosController_guardar434 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-hijo/guardar"))))
        

// @LINE:527
private[this] lazy val controllers_rrhh_AgentesHijosController_actualizar435 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-hijo/actualizar"))))
        

// @LINE:528
private[this] lazy val controllers_rrhh_AgentesHijosController_eliminar436 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-hijo/eliminar"))))
        

// @LINE:530
private[this] lazy val controllers_rrhh_AgentesFamiliasController_index437 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-familia/index"))))
        

// @LINE:531
private[this] lazy val controllers_rrhh_AgentesFamiliasController_crear438 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-familia/crear"))))
        

// @LINE:532
private[this] lazy val controllers_rrhh_AgentesFamiliasController_editar439 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-familia/editar"))))
        

// @LINE:533
private[this] lazy val controllers_rrhh_AgentesFamiliasController_guardar440 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-familia/guardar"))))
        

// @LINE:534
private[this] lazy val controllers_rrhh_AgentesFamiliasController_actualizar441 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-familia/actualizar"))))
        

// @LINE:535
private[this] lazy val controllers_rrhh_AgentesFamiliasController_eliminar442 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-familia/eliminar"))))
        

// @LINE:537
private[this] lazy val controllers_rrhh_DepartamentosController_indexDepartamento443 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/departamento"))))
        

// @LINE:538
private[this] lazy val controllers_rrhh_DepartamentosController_crearDepartamento444 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/departamento/crear"))))
        

// @LINE:539
private[this] lazy val controllers_rrhh_DepartamentosController_guardarDepartamento445 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/departamento/guardar"))))
        

// @LINE:540
private[this] lazy val controllers_rrhh_DepartamentosController_editarDepartamento446 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/departamento/editar"))))
        

// @LINE:541
private[this] lazy val controllers_rrhh_DepartamentosController_eliminarDepartamento447 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/departamento/eliminar"))))
        

// @LINE:542
private[this] lazy val controllers_rrhh_DepartamentosController_actualizarDepartamento448 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/departamento/actualizar"))))
        

// @LINE:544
private[this] lazy val controllers_rrhh_EspecialidadesController_indexEspecialidad449 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/especialidad"))))
        

// @LINE:545
private[this] lazy val controllers_rrhh_EspecialidadesController_crearEspecialidad450 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/especialidad/crear"))))
        

// @LINE:546
private[this] lazy val controllers_rrhh_EspecialidadesController_guardarEspecialidad451 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/especialidad/guardar"))))
        

// @LINE:547
private[this] lazy val controllers_rrhh_EspecialidadesController_editarEspecialidad452 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/especialidad/editar"))))
        

// @LINE:548
private[this] lazy val controllers_rrhh_EspecialidadesController_eliminarEspecialidad453 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/especialidad/eliminar"))))
        

// @LINE:549
private[this] lazy val controllers_rrhh_EspecialidadesController_actualizarEspecialidad454 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/especialidad/actualizar"))))
        

// @LINE:550
private[this] lazy val controllers_rrhh_EspecialidadesController_modalBuscar455 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/especialidad/modalBuscar"))))
        

// @LINE:551
private[this] lazy val controllers_rrhh_EspecialidadesController_get456 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/especialidad/get"))))
        

// @LINE:553
private[this] lazy val controllers_rrhh_ProfesionesController_modalBuscar457 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/profesion/modalBuscar"))))
        

// @LINE:554
private[this] lazy val controllers_rrhh_ProfesionesController_get458 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/profesion/get"))))
        

// @LINE:556
private[this] lazy val controllers_rrhh_CiesController_modalBuscar459 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/cie/modalBuscar"))))
        

// @LINE:557
private[this] lazy val controllers_rrhh_CiesController_get460 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/cie/get"))))
        

// @LINE:559
private[this] lazy val controllers_rrhh_TipoResidenciasController_modalBuscar461 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/tipoResidencia/modalBuscar"))))
        

// @LINE:560
private[this] lazy val controllers_rrhh_TipoResidenciasController_get462 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/tipoResidencia/get"))))
        

// @LINE:561
private[this] lazy val controllers_rrhh_TipoResidenciasController_indexTipoResidencia463 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/tipoResidencia"))))
        

// @LINE:562
private[this] lazy val controllers_rrhh_TipoResidenciasController_crearTipoResidencia464 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/tipoResidencia/crear"))))
        

// @LINE:563
private[this] lazy val controllers_rrhh_TipoResidenciasController_guardarTipoResidencia465 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/tipoResidencia/guardar"))))
        

// @LINE:564
private[this] lazy val controllers_rrhh_TipoResidenciasController_editarTipoResidencia466 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/tipoResidencia/editar"))))
        

// @LINE:565
private[this] lazy val controllers_rrhh_TipoResidenciasController_eliminarTipoResidencia467 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/tipoResidencia/eliminar"))))
        

// @LINE:566
private[this] lazy val controllers_rrhh_TipoResidenciasController_actualizarTipoResidencia468 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/tipoResidencia/actualizar"))))
        

// @LINE:567
private[this] lazy val controllers_rrhh_TipoResidenciasController_ver469 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/tipoResidencia/ver"))))
        

// @LINE:569
private[this] lazy val controllers_rrhh_PuestosController_indexPuesto470 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/puesto"))))
        

// @LINE:570
private[this] lazy val controllers_rrhh_PuestosController_crearPuesto471 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/puesto/crear"))))
        

// @LINE:571
private[this] lazy val controllers_rrhh_PuestosController_guardarPuesto472 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/puesto/guardar"))))
        

// @LINE:572
private[this] lazy val controllers_rrhh_PuestosController_editarPuesto473 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/puesto/editar"))))
        

// @LINE:573
private[this] lazy val controllers_rrhh_PuestosController_eliminarPuesto474 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/puesto/eliminar"))))
        

// @LINE:574
private[this] lazy val controllers_rrhh_PuestosController_actualizarPuesto475 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/puesto/actualizar"))))
        

// @LINE:575
private[this] lazy val controllers_rrhh_PuestosController_modalBuscar476 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/puesto/modalBuscar"))))
        

// @LINE:576
private[this] lazy val controllers_rrhh_PuestosController_get477 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/puesto/get"))))
        

// @LINE:578
private[this] lazy val controllers_rrhh_AgentesController_indexAgente478 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente"))))
        

// @LINE:579
private[this] lazy val controllers_rrhh_AgentesController_crearAgente479 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/crear"))))
        

// @LINE:580
private[this] lazy val controllers_rrhh_AgentesController_guardarAgente480 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/guardar"))))
        

// @LINE:581
private[this] lazy val controllers_rrhh_AgentesController_editarAgente481 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/editar"))))
        

// @LINE:582
private[this] lazy val controllers_rrhh_AgentesController_eliminarAgente482 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/eliminar"))))
        

// @LINE:583
private[this] lazy val controllers_rrhh_AgentesController_actualizarAgente483 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/actualizar"))))
        

// @LINE:584
private[this] lazy val controllers_rrhh_AgentesController_modalBuscar484 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/modalBuscar"))))
        

// @LINE:585
private[this] lazy val controllers_rrhh_AgentesController_get485 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/get"))))
        

// @LINE:586
private[this] lazy val controllers_rrhh_AgentesController_ver486 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/ver"))))
        

// @LINE:587
private[this] lazy val controllers_rrhh_AgentesAccionesController_modalReplicarProveedor487 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/modalReplicarProveedor"))))
        

// @LINE:588
private[this] lazy val controllers_rrhh_AgentesAccionesController_replicarProveedor488 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/replicarProveedor"))))
        

// @LINE:589
private[this] lazy val controllers_rrhh_AgentesController_cambiarEstado489 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/cambiar-estado"))))
        

// @LINE:591
private[this] lazy val controllers_rrhh_AgentesAccionesController_modalPasarAAprobado490 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/modalPasarAAprobado"))))
        

// @LINE:592
private[this] lazy val controllers_rrhh_AgentesAccionesController_pasarAAprobado491 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/pasarAAprobado"))))
        

// @LINE:593
private[this] lazy val controllers_rrhh_AgentesAccionesController_modalPasarABorrador492 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/modalPasarABorrador"))))
        

// @LINE:594
private[this] lazy val controllers_rrhh_AgentesAccionesController_pasarABorrador493 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/pasarABorrador"))))
        

// @LINE:595
private[this] lazy val controllers_rrhh_AgentesAccionesController_modalPasarACancelado494 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/modalPasarACancelado"))))
        

// @LINE:596
private[this] lazy val controllers_rrhh_AgentesAccionesController_pasarACancelado495 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/pasarACancelado"))))
        

// @LINE:597
private[this] lazy val controllers_rrhh_AgentesAccionesController_modalPasarACargado496 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/modalPasarACargado"))))
        

// @LINE:598
private[this] lazy val controllers_rrhh_AgentesAccionesController_pasarACargado497 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/pasarACargado"))))
        

// @LINE:599
private[this] lazy val controllers_rrhh_AgentesAccionesController_modalPasarAPreaprobado498 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/modalPasarAPreaprobado"))))
        

// @LINE:600
private[this] lazy val controllers_rrhh_AgentesAccionesController_pasarAPreaprobado499 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/pasarAPreaprobado"))))
        

// @LINE:602
private[this] lazy val controllers_rrhh_AgentesController_actualizarMail500 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/actualizarMail"))))
        

// @LINE:605
private[this] lazy val controllers_rrhh_NovedadesController_index501 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/novedades"))))
        

// @LINE:606
private[this] lazy val controllers_rrhh_NovedadesController_ver502 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/novedades/ver"))))
        

// @LINE:607
private[this] lazy val controllers_rrhh_NovedadesController_eliminar503 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/novedades/eliminar"))))
        

// @LINE:608
private[this] lazy val controllers_rrhh_NovedadesController_crear504 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/novedades/crear"))))
        

// @LINE:609
private[this] lazy val controllers_rrhh_NovedadesController_guardar505 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/novedades/guardar"))))
        

// @LINE:610
private[this] lazy val controllers_rrhh_NovedadesController_editar506 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/novedades/editar"))))
        

// @LINE:611
private[this] lazy val controllers_rrhh_NovedadesController_actualizar507 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/novedades/actualizar"))))
        

// @LINE:612
private[this] lazy val controllers_rrhh_NovedadesController_lista508 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/novedades/lista"))))
        

// @LINE:613
private[this] lazy val controllers_rrhh_NovedadesController_getFeriados509 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/novedades/feriados"))))
        

// @LINE:615
private[this] lazy val controllers_rrhh_AgentesReportesController_ficha510 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/reportes/ficha"))))
        

// @LINE:616
private[this] lazy val controllers_rrhh_AgentesReportesController_fichaAptitud511 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/reportes/fichaAptitud"))))
        

// @LINE:617
private[this] lazy val controllers_rrhh_AgentesReportesController_reportesDatosAgente512 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/reportes/reportesDatosAgente"))))
        

// @LINE:618
private[this] lazy val controllers_rrhh_AgentesReportesController_reportesCertificacionesAgente513 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente/reportes/reportesCertificacionesAgente"))))
        

// @LINE:620
private[this] lazy val controllers_rrhh_AgentesAsistenciasController_index514 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteAsistencia/index"))))
        

// @LINE:621
private[this] lazy val controllers_rrhh_AgentesAsistenciasController_editar515 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteAsistencia/editar"))))
        

// @LINE:622
private[this] lazy val controllers_rrhh_AgentesAsistenciasController_ver516 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteAsistencia/ver"))))
        

// @LINE:624
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_index517 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/index"))))
        

// @LINE:625
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_crear518 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/crear"))))
        

// @LINE:626
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_editar519 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/editar"))))
        

// @LINE:627
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_guardar520 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencian/guardar"))))
        

// @LINE:628
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_actualizar521 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/actualizar"))))
        

// @LINE:629
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_eliminar522 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/eliminar"))))
        

// @LINE:631
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_modalPasarBorrador523 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/modalPasarBorrador"))))
        

// @LINE:632
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_pasarBorradorMasivo524 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/pasarBorradorMasivo"))))
        

// @LINE:633
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_modalPasarCancelado525 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/modalPasarCancelado"))))
        

// @LINE:634
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_pasarCanceladoMasivo526 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/pasarCanceladoMasivo"))))
        

// @LINE:635
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_modalPasarPreAprobado527 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/modalPasarPreAprobado"))))
        

// @LINE:636
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_pasarPreAprobadoMasivo528 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/pasarPreAprobadoMasivo"))))
        

// @LINE:637
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_modalPasarAprobado529 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/modalPasarAprobado"))))
        

// @LINE:638
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_pasarAprobadoMasivo530 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/pasarAprobadoMasivo"))))
        

// @LINE:640
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_resumen531 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/resumen"))))
        

// @LINE:642
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_getListaLicenciasPendientes532 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/getListaLicenciasPendientes"))))
        

// @LINE:643
private[this] lazy val controllers_rrhh_AgentesAsistenciasLicenciasController_getListaLicenciasEnFecha533 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agente-asistencia-licencia/getListaLicenciasEnFecha"))))
        

// @LINE:645
private[this] lazy val controllers_rrhh_AgentesAsistenciasReportesController_reporteLicencia534 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteAsistencia/reporteLicencia"))))
        

// @LINE:646
private[this] lazy val controllers_rrhh_AgentesAsistenciasReportesController_reporteLicenciaMedicinaLaboral535 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteAsistencia/reporteLicenciaMedicinaLaboral"))))
        

// @LINE:648
private[this] lazy val controllers_rrhh_AgentesSeguimientoController_index536 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteSeguimiento/index"))))
        

// @LINE:649
private[this] lazy val controllers_rrhh_AgentesSeguimientoController_ver537 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteSeguimiento/ver"))))
        

// @LINE:651
private[this] lazy val controllers_rrhh_AgentesSeguimientoController_crearAgenteSeguimiento538 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteSeguimiento/crear"))))
        

// @LINE:652
private[this] lazy val controllers_rrhh_AgentesSeguimientoController_guardarAgenteSeguimiento539 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteSeguimiento/guardar"))))
        

// @LINE:653
private[this] lazy val controllers_rrhh_AgentesSeguimientoController_editarAgenteSeguimiento540 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteSeguimiento/editar"))))
        

// @LINE:654
private[this] lazy val controllers_rrhh_AgentesSeguimientoController_actualizarAgenteSeguimiento541 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteSeguimiento/actualizar"))))
        

// @LINE:655
private[this] lazy val controllers_rrhh_AgentesSeguimientoController_eliminarAgenteSeguimiento542 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteSeguimiento/eliminar"))))
        

// @LINE:656
private[this] lazy val controllers_rrhh_AgentesSeguimientoController_cambiarEstado543 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/agenteSeguimiento/cambiarEstado"))))
        

// @LINE:658
private[this] lazy val controllers_rrhh_AgentesSeguimientoLineasController_index544 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/seguimiento-linea/index"))))
        

// @LINE:659
private[this] lazy val controllers_rrhh_AgentesSeguimientoLineasController_crear545 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/seguimiento-linea/crear"))))
        

// @LINE:660
private[this] lazy val controllers_rrhh_AgentesSeguimientoLineasController_editar546 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/seguimiento-linea/editar"))))
        

// @LINE:661
private[this] lazy val controllers_rrhh_AgentesSeguimientoLineasController_guardar547 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/seguimiento-linea/guardar"))))
        

// @LINE:662
private[this] lazy val controllers_rrhh_AgentesSeguimientoLineasController_actualizar548 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/seguimiento-linea/actualizar"))))
        

// @LINE:663
private[this] lazy val controllers_rrhh_AgentesSeguimientoLineasController_eliminar549 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rrhh/seguimiento-linea/eliminar"))))
        

// @LINE:669
private[this] lazy val controllers_delegacion_IndexController_index550 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delegacion"))))
        

// @LINE:670
private[this] lazy val controllers_delegacion_DepositosController_index551 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delegacion/deposito"))))
        

// @LINE:671
private[this] lazy val controllers_delegacion_DepositosController_crear552 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delegacion/deposito/crear"))))
        

// @LINE:672
private[this] lazy val controllers_delegacion_DepositosController_guardar553 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delegacion/deposito/guardar"))))
        

// @LINE:673
private[this] lazy val controllers_delegacion_DepositosController_editar554 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delegacion/deposito/editar"))))
        

// @LINE:674
private[this] lazy val controllers_delegacion_DepositosController_eliminar555 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delegacion/deposito/eliminar"))))
        

// @LINE:675
private[this] lazy val controllers_delegacion_DepositosController_actualizar556 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delegacion/deposito/actualizar"))))
        

// @LINE:676
private[this] lazy val controllers_delegacion_DepositosController_modalBuscar557 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delegacion/deposito/modalBuscar"))))
        

// @LINE:677
private[this] lazy val controllers_delegacion_DepositosController_get558 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delegacion/deposito/get"))))
        

// @LINE:681
private[this] lazy val controllers_presupuesto_IndexController_index559 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto"))))
        

// @LINE:682
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_index560 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario"))))
        

// @LINE:683
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_crear561 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario/crear"))))
        

// @LINE:684
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_guardar562 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario/guardar"))))
        

// @LINE:685
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_editar563 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario/editar"))))
        

// @LINE:686
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_eliminar564 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario/eliminar"))))
        

// @LINE:687
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_actualizar565 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario/actualizar"))))
        

// @LINE:689
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_get566 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario/get"))))
        

// @LINE:690
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_ver567 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario/ver"))))
        

// @LINE:691
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_aprobar568 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/aprobar"))))
        

// @LINE:693
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_listaCargas569 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-listaCargas"))))
        

// @LINE:695
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_index570 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario"))))
        

// @LINE:697
private[this] lazy val controllers_presupuesto_CreditosPresupuestariosController_reporteListadoCreditos571 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/credito-presupuestario/reporteListadoCreditos"))))
        

// @LINE:698
private[this] lazy val controllers_presupuesto_LineasCreditosPresupuestariosController_index572 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-credito/index"))))
        

// @LINE:699
private[this] lazy val controllers_presupuesto_LineasCreditosPresupuestariosController_crear573 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-credito/crear"))))
        

// @LINE:700
private[this] lazy val controllers_presupuesto_LineasCreditosPresupuestariosController_editar574 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-credito/editar"))))
        

// @LINE:701
private[this] lazy val controllers_presupuesto_LineasCreditosPresupuestariosController_guardar575 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-credito/guardar"))))
        

// @LINE:702
private[this] lazy val controllers_presupuesto_LineasCreditosPresupuestariosController_actualizar576 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-credito/actualizar"))))
        

// @LINE:703
private[this] lazy val controllers_presupuesto_LineasCreditosPresupuestariosController_eliminar577 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-credito/eliminar"))))
        

// @LINE:704
private[this] lazy val controllers_presupuesto_LineasRecursosPresupuestariosController_index578 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-recurso/index"))))
        

// @LINE:705
private[this] lazy val controllers_presupuesto_LineasRecursosPresupuestariosController_crear579 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-recurso/crear"))))
        

// @LINE:706
private[this] lazy val controllers_presupuesto_LineasRecursosPresupuestariosController_editar580 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-recurso/editar"))))
        

// @LINE:707
private[this] lazy val controllers_presupuesto_LineasRecursosPresupuestariosController_guardar581 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-recurso/guardar"))))
        

// @LINE:708
private[this] lazy val controllers_presupuesto_LineasRecursosPresupuestariosController_actualizar582 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-recurso/actualizar"))))
        

// @LINE:709
private[this] lazy val controllers_presupuesto_LineasRecursosPresupuestariosController_eliminar583 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/linea-recurso/eliminar"))))
        

// @LINE:710
private[this] lazy val controllers_presupuesto_BalancePresupuestarioController_index584 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/balance-presupuestario"))))
        

// @LINE:711
private[this] lazy val controllers_presupuesto_BalancePresupuestarioController_balancePresupuestarioPorExpediente585 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/balancePresupuestarioPorExpediente"))))
        

// @LINE:713
private[this] lazy val controllers_presupuesto_BalancePresupuestarioReportesController_modalReporteBalancePorCuentaPorExpediente586 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/reporte/modalReporteBalancePorCuentaPorExpediente"))))
        

// @LINE:714
private[this] lazy val controllers_presupuesto_BalancePresupuestarioReportesController_reporteBalancePorCuentaPorExpediente587 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/reporte/reporteBalancePorCuentaPorExpediente"))))
        

// @LINE:715
private[this] lazy val controllers_presupuesto_BalancePresupuestarioReportesController_modalReporteExportarDatosPresupuestoControl588 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/reporte/modalReporteExportarDatosPresupuestoControl"))))
        

// @LINE:716
private[this] lazy val controllers_presupuesto_BalancePresupuestarioReportesController_reporteExportarDatosPresupuestoControl589 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/reporte/reporteExportarDatosPresupuestoControl"))))
        

// @LINE:718
private[this] lazy val controllers_presupuesto_BalancePresupuestarioReportesController_reporteBalanceDiferenciaPreventivoDefinitivo590 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/reporte/reporteBalanceDiferenciaPreventivoDefinitivo"))))
        

// @LINE:720
private[this] lazy val controllers_presupuesto_BalancePresupuestarioReportesController_modalReporteBalancePorFecha591 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/modalReporteBalancePorFecha"))))
        

// @LINE:721
private[this] lazy val controllers_presupuesto_BalancePresupuestarioReportesController_reporteBalancePorFecha592 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/reporteBalancePorFecha"))))
        

// @LINE:722
private[this] lazy val controllers_presupuesto_BalancePresupuestarioReportesController_reporteBalancePorFechaPorExpediente593 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/reporteBalancePorFechaPorExpediente"))))
        

// @LINE:725
private[this] lazy val controllers_presupuesto_ControlPresupuestarioController_controlAnulacionProductosAutomaticos594 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/controlAnulacionProductosAutomaticos"))))
        

// @LINE:726
private[this] lazy val controllers_presupuesto_ControlPresupuestarioController_controlAnulacionProductosAutomaticosExcel595 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/controlAnulacionProductosAutomaticosExcel"))))
        

// @LINE:728
private[this] lazy val controllers_presupuesto_ControlPresupuestarioController_movimientosSaldoPreventivo596 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/movimientosSaldoPreventivo"))))
        

// @LINE:729
private[this] lazy val controllers_presupuesto_ControlPresupuestarioController_movimientosSaldoPreventivoExcel597 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("presupuesto/movimientosSaldoPreventivoExcel"))))
        

// @LINE:733
private[this] lazy val controllers_rendiciones_IndexController_index598 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rendiciones"))))
        

// @LINE:734
private[this] lazy val controllers_rendiciones_RendicionesController_indexPagosRealizados599 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rendiciones/pagos-realizados"))))
        

// @LINE:742
private[this] lazy val controllers_haberes_IndexController_index600 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes"))))
        

// @LINE:743
private[this] lazy val controllers_haberes_NovedadesController_index601 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades"))))
        

// @LINE:744
private[this] lazy val controllers_haberes_NovedadesController_lista602 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades/lista"))))
        

// @LINE:745
private[this] lazy val controllers_haberes_NovedadesController_ver603 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades/ver"))))
        

// @LINE:746
private[this] lazy val controllers_haberes_NovedadesController_crear604 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades/crear"))))
        

// @LINE:747
private[this] lazy val controllers_haberes_NovedadesController_guardar605 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades/guardar"))))
        

// @LINE:748
private[this] lazy val controllers_haberes_NovedadesController_editar606 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades/editar"))))
        

// @LINE:749
private[this] lazy val controllers_haberes_NovedadesController_actualizar607 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades/actualizar"))))
        

// @LINE:750
private[this] lazy val controllers_haberes_NovedadesController_eliminar608 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades/eliminar"))))
        

// @LINE:752
private[this] lazy val controllers_haberes_NovedadesAccionesController_crearMasivo609 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades/acciones/crear-masivo"))))
        

// @LINE:753
private[this] lazy val controllers_haberes_NovedadesAccionesController_procesarMasivo610 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/novedades/acciones/procesar-masivo"))))
        

// @LINE:756
private[this] lazy val controllers_haberes_PuestosLaboralesController_index611 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales"))))
        

// @LINE:757
private[this] lazy val controllers_haberes_PuestosLaboralesController_crear612 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/crear"))))
        

// @LINE:758
private[this] lazy val controllers_haberes_PuestosLaboralesController_guardar613 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/guardar"))))
        

// @LINE:759
private[this] lazy val controllers_haberes_PuestosLaboralesController_editar614 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/editar"))))
        

// @LINE:760
private[this] lazy val controllers_haberes_PuestosLaboralesController_eliminar615 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborale/eliminar"))))
        

// @LINE:761
private[this] lazy val controllers_haberes_PuestosLaboralesController_actualizar616 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/actualizar"))))
        

// @LINE:762
private[this] lazy val controllers_haberes_PuestosLaboralesController_modalBuscar617 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/modal-buscar"))))
        

// @LINE:763
private[this] lazy val controllers_haberes_PuestosLaboralesController_modalBuscarTodos618 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/modal-buscar-todos"))))
        

// @LINE:764
private[this] lazy val controllers_haberes_PuestosLaboralesController_get619 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/get"))))
        

// @LINE:765
private[this] lazy val controllers_haberes_PuestosLaboralesController_ver620 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/ver"))))
        

// @LINE:766
private[this] lazy val controllers_haberes_PuestosLaboralesController_cambiarEstado621 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/cambiarEstado"))))
        

// @LINE:770
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_activar622 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/acciones/activar"))))
        

// @LINE:771
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_desactivar623 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/acciones/desactivar"))))
        

// @LINE:772
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_modalCrearNovedades624 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/acciones/modalCrearNovedades"))))
        

// @LINE:773
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_crearNovedadesBasicas625 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/crearNovedades"))))
        

// @LINE:774
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_modalPasarABorrador626 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/modalPasarABorrador"))))
        

// @LINE:775
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_pasarABorrador627 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/pasarABorrador"))))
        

// @LINE:776
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_modalPasarAControlado628 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/modalPasarAControlado"))))
        

// @LINE:777
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_pasarAControlado629 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/pasarAControlado"))))
        

// @LINE:778
private[this] lazy val controllers_haberes_PuestosLaboralesController_liquidarCierre630 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/liquidarCierre"))))
        

// @LINE:780
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_modalPreliquidarPuesto631 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/acciones/modalPreliquidarPuesto"))))
        

// @LINE:781
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_preliquidarPuesto632 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/preliquidarPuesto"))))
        

// @LINE:783
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_modalPreliquidarFinalPuesto633 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/acciones/modalPreliquidarPuestoFinal"))))
        

// @LINE:784
private[this] lazy val controllers_haberes_PuestosLaboralesAccionesController_preliquidarFinalPuesto634 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/preliquidarPuestoFinal"))))
        

// @LINE:787
private[this] lazy val controllers_haberes_PuestosLaboralesReportesController_altasMasivas635 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/reportes/alta-masiva"))))
        

// @LINE:788
private[this] lazy val controllers_haberes_PuestosLaboralesReportesController_altasMacroSueldo636 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/reportes/alta-macrosueldo"))))
        

// @LINE:789
private[this] lazy val controllers_haberes_PuestosLaboralesReportesController_descargarArchivo637 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/reportes/descargar-archivo"))))
        

// @LINE:790
private[this] lazy val controllers_haberes_PuestosLaboralesReportesController_listadoPuestosLaborales638 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/reportes/listado"))))
        

// @LINE:791
private[this] lazy val controllers_haberes_PuestosLaboralesReportesController_reportef649639 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/puestos-laborales/reportes/f649"))))
        

// @LINE:792
private[this] lazy val controllers_haberes_PuestosLaboralesReportesController_formulario649640 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reportes/formulario649"))))
        

// @LINE:793
private[this] lazy val controllers_haberes_PuestosLaboralesReportesController_formulario6492019641 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reportes/formulario649-2019"))))
        

// @LINE:794
private[this] lazy val controllers_haberes_PuestosLaboralesReportesController_formulario6492021642 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reportes/formulario649-2021"))))
        

// @LINE:795
private[this] lazy val controllers_haberes_PuestosLaboralesReportesController_formulario6492022643 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reportes/formulario649-2022"))))
        

// @LINE:797
private[this] lazy val controllers_haberes_LiquidacionConceptosController_index644 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConcepto"))))
        

// @LINE:798
private[this] lazy val controllers_haberes_LiquidacionConceptosController_crear645 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConcepto/crear"))))
        

// @LINE:799
private[this] lazy val controllers_haberes_LiquidacionConceptosController_guardar646 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConcepto/guardar"))))
        

// @LINE:800
private[this] lazy val controllers_haberes_LiquidacionConceptosController_editar647 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConcepto/editar"))))
        

// @LINE:801
private[this] lazy val controllers_haberes_LiquidacionConceptosController_eliminar648 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConcepto/eliminar"))))
        

// @LINE:802
private[this] lazy val controllers_haberes_LiquidacionConceptosController_actualizar649 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConcepto/actualizar"))))
        

// @LINE:803
private[this] lazy val controllers_haberes_LiquidacionConceptosController_modalBuscar650 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConcepto/modalBuscar"))))
        

// @LINE:804
private[this] lazy val controllers_haberes_LiquidacionConceptosController_get651 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConcepto/get"))))
        

// @LINE:805
private[this] lazy val controllers_haberes_LiquidacionConceptosController_ver652 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConcepto/ver"))))
        

// @LINE:807
private[this] lazy val controllers_haberes_LiquidacionConceptoTiposController_index653 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConceptoTipo"))))
        

// @LINE:808
private[this] lazy val controllers_haberes_LiquidacionConceptoTiposController_crear654 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConceptoTipo/crear"))))
        

// @LINE:809
private[this] lazy val controllers_haberes_LiquidacionConceptoTiposController_guardar655 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConceptoTipo/guardar"))))
        

// @LINE:810
private[this] lazy val controllers_haberes_LiquidacionConceptoTiposController_editar656 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConceptoTipo/editar"))))
        

// @LINE:811
private[this] lazy val controllers_haberes_LiquidacionConceptoTiposController_eliminar657 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConceptoTipo/eliminar"))))
        

// @LINE:812
private[this] lazy val controllers_haberes_LiquidacionConceptoTiposController_actualizar658 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConceptoTipo/actualizar"))))
        

// @LINE:813
private[this] lazy val controllers_haberes_LiquidacionConceptoTiposController_modalBuscar659 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConceptoTipo/modalBuscar"))))
        

// @LINE:814
private[this] lazy val controllers_haberes_LiquidacionConceptoTiposController_get660 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConceptoTipo/get"))))
        

// @LINE:815
private[this] lazy val controllers_haberes_LiquidacionConceptoTiposController_ver661 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionConceptoTipo/ver"))))
        

// @LINE:817
private[this] lazy val controllers_haberes_LiquidacionBaseCalculosController_index662 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionBaseCalculo"))))
        

// @LINE:818
private[this] lazy val controllers_haberes_LiquidacionBaseCalculosController_crear663 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionBaseCalculo/crear"))))
        

// @LINE:819
private[this] lazy val controllers_haberes_LiquidacionBaseCalculosController_guardar664 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionBaseCalculo/guardar"))))
        

// @LINE:820
private[this] lazy val controllers_haberes_LiquidacionBaseCalculosController_editar665 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionBaseCalculo/editar"))))
        

// @LINE:821
private[this] lazy val controllers_haberes_LiquidacionBaseCalculosController_eliminar666 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionBaseCalculo/eliminar"))))
        

// @LINE:822
private[this] lazy val controllers_haberes_LiquidacionBaseCalculosController_actualizar667 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionBaseCalculo/actualizar"))))
        

// @LINE:823
private[this] lazy val controllers_haberes_LiquidacionBaseCalculosController_modalBuscar668 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionBaseCalculo/modalBuscar"))))
        

// @LINE:824
private[this] lazy val controllers_haberes_LiquidacionBaseCalculosController_get669 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionBaseCalculo/get"))))
        

// @LINE:825
private[this] lazy val controllers_haberes_LiquidacionBaseCalculosController_ver670 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionBaseCalculo/ver"))))
        

// @LINE:827
private[this] lazy val controllers_haberes_LiquidacionTiposController_index671 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionTipo"))))
        

// @LINE:828
private[this] lazy val controllers_haberes_LiquidacionTiposController_crear672 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionTipo/crear"))))
        

// @LINE:829
private[this] lazy val controllers_haberes_LiquidacionTiposController_guardar673 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionTipo/guardar"))))
        

// @LINE:830
private[this] lazy val controllers_haberes_LiquidacionTiposController_editar674 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionTipo/editar"))))
        

// @LINE:831
private[this] lazy val controllers_haberes_LiquidacionTiposController_eliminar675 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionTipo/eliminar"))))
        

// @LINE:832
private[this] lazy val controllers_haberes_LiquidacionTiposController_actualizar676 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionTipo/actualizar"))))
        

// @LINE:833
private[this] lazy val controllers_haberes_LiquidacionTiposController_modalBuscar677 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionTipo/modalBuscar"))))
        

// @LINE:834
private[this] lazy val controllers_haberes_LiquidacionTiposController_get678 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionTipo/get"))))
        

// @LINE:835
private[this] lazy val controllers_haberes_LiquidacionTiposController_ver679 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionTipo/ver"))))
        

// @LINE:837
private[this] lazy val controllers_haberes_UnidadesLaboralesController_index680 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/unidadLaboral"))))
        

// @LINE:838
private[this] lazy val controllers_haberes_UnidadesLaboralesController_crear681 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/unidadLaboral/crear"))))
        

// @LINE:839
private[this] lazy val controllers_haberes_UnidadesLaboralesController_guardar682 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/unidadLaboral/guardar"))))
        

// @LINE:840
private[this] lazy val controllers_haberes_UnidadesLaboralesController_editar683 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/unidadLaboral/editar"))))
        

// @LINE:841
private[this] lazy val controllers_haberes_UnidadesLaboralesController_eliminar684 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/unidadLaboral/eliminar"))))
        

// @LINE:842
private[this] lazy val controllers_haberes_UnidadesLaboralesController_actualizar685 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/unidadLaboral/actualizar"))))
        

// @LINE:843
private[this] lazy val controllers_haberes_UnidadesLaboralesController_modalBuscar686 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/unidadLaboral/modalBuscar"))))
        

// @LINE:844
private[this] lazy val controllers_haberes_UnidadesLaboralesController_get687 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/unidadLaboral/get"))))
        

// @LINE:845
private[this] lazy val controllers_haberes_UnidadesLaboralesController_ver688 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/unidadLaboral/ver"))))
        

// @LINE:847
private[this] lazy val controllers_haberes_CategoriasLaboralesController_index689 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral"))))
        

// @LINE:848
private[this] lazy val controllers_haberes_CategoriasLaboralesController_crear690 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral/crear"))))
        

// @LINE:849
private[this] lazy val controllers_haberes_CategoriasLaboralesController_guardar691 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral/guardar"))))
        

// @LINE:850
private[this] lazy val controllers_haberes_CategoriasLaboralesController_editar692 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral/editar"))))
        

// @LINE:851
private[this] lazy val controllers_haberes_CategoriasLaboralesController_eliminar693 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral/eliminar"))))
        

// @LINE:852
private[this] lazy val controllers_haberes_CategoriasLaboralesController_actualizar694 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral/actualizar"))))
        

// @LINE:853
private[this] lazy val controllers_haberes_CategoriasLaboralesController_modalBuscar695 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral/modalBuscar"))))
        

// @LINE:854
private[this] lazy val controllers_haberes_CategoriasLaboralesController_get696 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral/get"))))
        

// @LINE:855
private[this] lazy val controllers_haberes_CategoriasLaboralesController_ver697 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral/ver"))))
        

// @LINE:856
private[this] lazy val controllers_haberes_CategoriasLaboralesController_suggestCategoriaLaboral698 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/categoriaLaboral/suggestCategoriaLaboral/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:858
private[this] lazy val controllers_haberes_LiquidacionPuestosController_index699 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto"))))
        

// @LINE:859
private[this] lazy val controllers_haberes_LiquidacionPuestosController_crear700 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/crear"))))
        

// @LINE:860
private[this] lazy val controllers_haberes_LiquidacionPuestosController_guardar701 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/guardar"))))
        

// @LINE:861
private[this] lazy val controllers_haberes_LiquidacionPuestosController_editar702 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/editar"))))
        

// @LINE:862
private[this] lazy val controllers_haberes_LiquidacionPuestosController_eliminar703 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/eliminar"))))
        

// @LINE:863
private[this] lazy val controllers_haberes_LiquidacionPuestosController_actualizar704 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/actualizar"))))
        

// @LINE:864
private[this] lazy val controllers_haberes_LiquidacionPuestosController_modalBuscar705 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/modalBuscar"))))
        

// @LINE:865
private[this] lazy val controllers_haberes_LiquidacionPuestosController_get706 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/get"))))
        

// @LINE:866
private[this] lazy val controllers_haberes_LiquidacionPuestosController_ver707 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/ver"))))
        

// @LINE:867
private[this] lazy val controllers_haberes_LiquidacionPuestosReportesController_reciboSueldoPorPuesto708 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/reportes/reciboSueldoPorPuesto"))))
        

// @LINE:868
private[this] lazy val controllers_haberes_LiquidacionPuestosReportesController_reciboSueldo709 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/reportes/reciboSueldo"))))
        

// @LINE:869
private[this] lazy val controllers_haberes_LiquidacionPuestosReportesController_reciboSueldosByLiquidacionMes710 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/reportes/reciboSueldosByLiquidacionMes"))))
        

// @LINE:870
private[this] lazy val controllers_haberes_LiquidacionPuestosController_cambiarEstado711 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/cambiarEstado"))))
        

// @LINE:871
private[this] lazy val controllers_haberes_LiquidacionPuestosReportesController_libroSueldos712 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/reportes/libroSueldos"))))
        

// @LINE:872
private[this] lazy val controllers_haberes_LiquidacionPuestosController_preLiquidar713 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/preliquidar"))))
        

// @LINE:874
private[this] lazy val controllers_haberes_LiquidacionPuestosReportesController_modalReciboSueldoPorPuestoMail714 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/reportes/modalReciboSueldoPorPuestoMail"))))
        

// @LINE:875
private[this] lazy val controllers_haberes_LiquidacionPuestosReportesController_enviarReciboPorMail715 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/reportes/enviarReciboPorMail"))))
        

// @LINE:877
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_modalPasarAOtraLiquidacion716 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/modalPasarAOtraLiquidacion"))))
        

// @LINE:878
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_pasarAOtraLiquidacion717 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/pasarAOtraLiquidacion"))))
        

// @LINE:879
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_modalPasarAprobado718 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/modalPasarAprobado"))))
        

// @LINE:880
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_pasarAprobadoMasivo719 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/pasarEnCursoMasivo"))))
        

// @LINE:881
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_modalPasarPreaprobado720 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/modalPasarPreaprobado"))))
        

// @LINE:882
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_pasarPreaprobadoMasivo721 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/pasarPreaprobadoMasivo"))))
        

// @LINE:883
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_modalPasarBorrador722 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/modalPasarBorrador"))))
        

// @LINE:884
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_pasarBorradorMasivo723 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/pasarBorradorMasivo"))))
        

// @LINE:885
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_modalPasarCancelado724 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/modalPasarCancelado"))))
        

// @LINE:886
private[this] lazy val controllers_haberes_LiquidacionPuestosAccionesController_pasarCanceladoMasivo725 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionPuesto/pasarCanceladoMasivo"))))
        

// @LINE:888
private[this] lazy val controllers_haberes_LiquidacionDetallesController_index726 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacion-detalle/index"))))
        

// @LINE:889
private[this] lazy val controllers_haberes_LiquidacionDetallesController_crear727 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacion-detalle/crear"))))
        

// @LINE:890
private[this] lazy val controllers_haberes_LiquidacionDetallesController_editar728 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacion-d20301766700etalle/editar"))))
        

// @LINE:891
private[this] lazy val controllers_haberes_LiquidacionDetallesController_guardar729 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacion-detalle/guardar"))))
        

// @LINE:892
private[this] lazy val controllers_haberes_LiquidacionDetallesController_actualizar730 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacion-detalle/actualizar"))))
        

// @LINE:893
private[this] lazy val controllers_haberes_LiquidacionDetallesController_eliminar731 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacion-detalle/eliminar"))))
        

// @LINE:895
private[this] lazy val controllers_haberes_CargosLaboralesController_index732 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/cargoLaboral"))))
        

// @LINE:896
private[this] lazy val controllers_haberes_CargosLaboralesController_crear733 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/cargoLaboral/crear"))))
        

// @LINE:897
private[this] lazy val controllers_haberes_CargosLaboralesController_guardar734 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/cargoLaboral/guardar"))))
        

// @LINE:898
private[this] lazy val controllers_haberes_CargosLaboralesController_editar735 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/cargoLaboral/editar"))))
        

// @LINE:899
private[this] lazy val controllers_haberes_CargosLaboralesController_eliminar736 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/cargoLaboral/eliminar"))))
        

// @LINE:900
private[this] lazy val controllers_haberes_CargosLaboralesController_actualizar737 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/cargoLaboral/actualizar"))))
        

// @LINE:901
private[this] lazy val controllers_haberes_CargosLaboralesController_modalBuscar738 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/cargoLaboral/modalBuscar"))))
        

// @LINE:902
private[this] lazy val controllers_haberes_CargosLaboralesController_get739 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/cargoLaboral/get"))))
        

// @LINE:903
private[this] lazy val controllers_haberes_CargosLaboralesController_ver740 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/cargoLaboral/ver"))))
        

// @LINE:905
private[this] lazy val controllers_haberes_CentrosCostosController_index741 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/centroCosto"))))
        

// @LINE:906
private[this] lazy val controllers_haberes_CentrosCostosController_crear742 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/centroCosto/crear"))))
        

// @LINE:907
private[this] lazy val controllers_haberes_CentrosCostosController_guardar743 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/centroCosto/guardar"))))
        

// @LINE:908
private[this] lazy val controllers_haberes_CentrosCostosController_editar744 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/centroCosto/editar"))))
        

// @LINE:909
private[this] lazy val controllers_haberes_CentrosCostosController_eliminar745 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/centroCosto/eliminar"))))
        

// @LINE:910
private[this] lazy val controllers_haberes_CentrosCostosController_actualizar746 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/centroCosto/actualizar"))))
        

// @LINE:911
private[this] lazy val controllers_haberes_CentrosCostosController_modalBuscar747 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/centroCosto/modalBuscar"))))
        

// @LINE:912
private[this] lazy val controllers_haberes_CentrosCostosController_get748 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/centroCosto/get"))))
        

// @LINE:913
private[this] lazy val controllers_haberes_CentrosCostosController_ver749 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/centroCosto/ver"))))
        

// @LINE:915
private[this] lazy val controllers_haberes_EscalasLaboralesController_index750 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral"))))
        

// @LINE:916
private[this] lazy val controllers_haberes_EscalasLaboralesController_crear751 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral/crear"))))
        

// @LINE:917
private[this] lazy val controllers_haberes_EscalasLaboralesController_guardar752 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral/guardar"))))
        

// @LINE:918
private[this] lazy val controllers_haberes_EscalasLaboralesController_editar753 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral/editar"))))
        

// @LINE:919
private[this] lazy val controllers_haberes_EscalasLaboralesController_eliminar754 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral/eliminar"))))
        

// @LINE:920
private[this] lazy val controllers_haberes_EscalasLaboralesController_actualizar755 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral/actualizar"))))
        

// @LINE:921
private[this] lazy val controllers_haberes_EscalasLaboralesController_modalBuscar756 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral/modalBuscar"))))
        

// @LINE:922
private[this] lazy val controllers_haberes_EscalasLaboralesController_get757 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral/get"))))
        

// @LINE:923
private[this] lazy val controllers_haberes_EscalasLaboralesController_ver758 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral/ver"))))
        

// @LINE:924
private[this] lazy val controllers_haberes_EscalasLaboralesController_suggestEscalaLaboral759 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboral/suggestEscalaLaboral/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:926
private[this] lazy val controllers_haberes_ConveniosBancosController_index760 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/convenioBanco"))))
        

// @LINE:927
private[this] lazy val controllers_haberes_ConveniosBancosController_crear761 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/convenioBanco/crear"))))
        

// @LINE:928
private[this] lazy val controllers_haberes_ConveniosBancosController_guardar762 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/convenioBanco/guardar"))))
        

// @LINE:929
private[this] lazy val controllers_haberes_ConveniosBancosController_editar763 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/convenioBanco/editar"))))
        

// @LINE:930
private[this] lazy val controllers_haberes_ConveniosBancosController_eliminar764 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/convenioBanco/eliminar"))))
        

// @LINE:931
private[this] lazy val controllers_haberes_ConveniosBancosController_actualizar765 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/convenioBanco/actualizar"))))
        

// @LINE:932
private[this] lazy val controllers_haberes_ConveniosBancosController_modalBuscar766 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/convenioBanco/modalBuscar"))))
        

// @LINE:933
private[this] lazy val controllers_haberes_ConveniosBancosController_get767 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/convenioBanco/get"))))
        

// @LINE:934
private[this] lazy val controllers_haberes_ConveniosBancosController_ver768 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/convenioBanco/ver"))))
        

// @LINE:936
private[this] lazy val controllers_haberes_LegajosController_index769 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/legajo"))))
        

// @LINE:937
private[this] lazy val controllers_haberes_LegajosController_crear770 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/legajo/crear"))))
        

// @LINE:938
private[this] lazy val controllers_haberes_LegajosController_guardar771 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/legajo/guardar"))))
        

// @LINE:939
private[this] lazy val controllers_haberes_LegajosController_editar772 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/legajo/editar"))))
        

// @LINE:940
private[this] lazy val controllers_haberes_LegajosController_eliminar773 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/legajo/eliminar"))))
        

// @LINE:941
private[this] lazy val controllers_haberes_LegajosController_actualizar774 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/legajo/actualizar"))))
        

// @LINE:942
private[this] lazy val controllers_haberes_LegajosController_modalBuscar775 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/legajo/modalBuscar"))))
        

// @LINE:943
private[this] lazy val controllers_haberes_LegajosController_get776 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/legajo/get"))))
        

// @LINE:944
private[this] lazy val controllers_haberes_LegajosController_ver777 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/legajo/ver"))))
        

// @LINE:946
private[this] lazy val controllers_haberes_InstrumentosLegalesController_index778 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/instrumento"))))
        

// @LINE:947
private[this] lazy val controllers_haberes_InstrumentosLegalesController_crear779 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/instrumento/crear"))))
        

// @LINE:948
private[this] lazy val controllers_haberes_InstrumentosLegalesController_guardar780 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/instrumento/guardar"))))
        

// @LINE:949
private[this] lazy val controllers_haberes_InstrumentosLegalesController_editar781 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/instrumento/editar"))))
        

// @LINE:950
private[this] lazy val controllers_haberes_InstrumentosLegalesController_eliminar782 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/instrumento/eliminar"))))
        

// @LINE:951
private[this] lazy val controllers_haberes_InstrumentosLegalesController_actualizar783 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/instrumento/actualizar"))))
        

// @LINE:952
private[this] lazy val controllers_haberes_InstrumentosLegalesController_modalBuscar784 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/instrumento/modalBuscar"))))
        

// @LINE:953
private[this] lazy val controllers_haberes_InstrumentosLegalesController_get785 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/instrumento/get"))))
        

// @LINE:954
private[this] lazy val controllers_haberes_InstrumentosLegalesController_ver786 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/instrumento/ver"))))
        

// @LINE:956
private[this] lazy val controllers_haberes_LiquidacionMesesController_index787 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes"))))
        

// @LINE:957
private[this] lazy val controllers_haberes_LiquidacionMesesController_crear788 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/crear"))))
        

// @LINE:960
private[this] lazy val controllers_haberes_LiquidacionMesesController_guardar789 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/guardar"))))
        

// @LINE:961
private[this] lazy val controllers_haberes_LiquidacionMesesController_editar790 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/editar"))))
        

// @LINE:962
private[this] lazy val controllers_haberes_LiquidacionMesesController_eliminar791 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/eliminar"))))
        

// @LINE:963
private[this] lazy val controllers_haberes_LiquidacionMesesController_actualizar792 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/actualizar"))))
        

// @LINE:964
private[this] lazy val controllers_haberes_LiquidacionMesesController_modalBuscar793 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/modalBuscar"))))
        

// @LINE:965
private[this] lazy val controllers_haberes_LiquidacionMesesController_get794 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/get"))))
        

// @LINE:966
private[this] lazy val controllers_haberes_LiquidacionMesesController_ver795 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/ver"))))
        

// @LINE:967
private[this] lazy val controllers_haberes_LiquidacionMesesController_preliquidar796 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/preliquidar"))))
        

// @LINE:968
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_totalPorConceptos797 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/totalPorConceptos"))))
        

// @LINE:969
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_comparativoCertificacion798 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/comparativoCertificacion"))))
        

// @LINE:970
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_listadoSeguroVida799 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/listadoSeguroVida"))))
        

// @LINE:971
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_listadoSeguroSepelio800 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/listadoSeguroSepelio"))))
        

// @LINE:972
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_listadoJubilacion801 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/listadoJubilacion"))))
        

// @LINE:973
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_listadoObraSocial802 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/listadoObraSocial"))))
        

// @LINE:974
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_datosGenerales803 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/datosGenerales"))))
        

// @LINE:975
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_ordenDePago804 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/ordenDePago"))))
        

// @LINE:976
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_controlDescuentosBasicos805 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/controlDescuentosBasicos"))))
        

// @LINE:977
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_listadoPorConceptosPorPuestoLaboral806 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/listadoPorConceptosPorPuestoLaboral"))))
        

// @LINE:978
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_listadoDePuestoLaboral807 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/listadoDePuestoLaboral"))))
        

// @LINE:979
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_listadoGeneral808 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/listadoGeneral"))))
        

// @LINE:980
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_listadoDePuestoLaboralComparativoPeriodo809 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/listadoDePuestoLaboralComparativoPeriodo"))))
        

// @LINE:981
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_listadoPorEscalaPorPuestoLaboral810 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/listadoPorEscalaPorPuestoLaboral"))))
        

// @LINE:982
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_modalDatosAfip811 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/modalDatosAfip"))))
        

// @LINE:983
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_reportesDatosAfip812 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/reportesDatosAfip"))))
        

// @LINE:984
private[this] lazy val controllers_haberes_LiquidacionMesesController_cambiarEstado813 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/cambiarEstado"))))
        

// @LINE:985
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_modalDatosAfipGanancias814 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/modalDatosAfipGanancias"))))
        

// @LINE:986
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_reportesDatosAfipGanancias815 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/reportesDatosAfipGanancias"))))
        

// @LINE:987
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_modalControlDatosAfipGanancias816 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/modalControlDatosAfipGanancias"))))
        

// @LINE:988
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_reportesControlDatosAfipGanancias817 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionMes/reportes/reportesControlDatosAfipGanancias"))))
        

// @LINE:990
private[this] lazy val controllers_haberes_LiquidacionAccionesController_exportMacroSueldosLista818 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionAcciones/exportMacroSueldosLista"))))
        

// @LINE:991
private[this] lazy val controllers_haberes_LiquidacionAccionesController_exportMacroSueldos819 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionAcciones/exportMacroSueldos"))))
        

// @LINE:992
private[this] lazy val controllers_haberes_LiquidacionAccionesController_exportBanco820 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionAcciones/exportBanco"))))
        

// @LINE:993
private[this] lazy val controllers_haberes_LiquidacionAccionesController_descargarBanco821 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionAcciones/descargarBanco"))))
        

// @LINE:994
private[this] lazy val controllers_haberes_LiquidacionAccionesController_exportAfip822 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionAcciones/exportAfip"))))
        

// @LINE:995
private[this] lazy val controllers_haberes_LiquidacionAccionesController_descargarAfip823 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionAcciones/descargarAfip"))))
        

// @LINE:996
private[this] lazy val controllers_haberes_LiquidacionAccionesController_exportIps824 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionAcciones/exportIps"))))
        

// @LINE:997
private[this] lazy val controllers_haberes_LiquidacionAccionesController_descargarIps825 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionAcciones/descargarIps"))))
        

// @LINE:998
private[this] lazy val controllers_haberes_LiquidacionMesesReportesController_exportDatosPorConcepto826 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/liquidacionAcciones/exportDatosPorConcepto"))))
        

// @LINE:1000
private[this] lazy val controllers_haberes_EscalasLaboralesMontosController_index827 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboralMonto"))))
        

// @LINE:1001
private[this] lazy val controllers_haberes_EscalasLaboralesMontosController_crear828 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboralMonto/crear"))))
        

// @LINE:1002
private[this] lazy val controllers_haberes_EscalasLaboralesMontosController_guardar829 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboralMonto/guardar"))))
        

// @LINE:1003
private[this] lazy val controllers_haberes_EscalasLaboralesMontosController_editar830 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboralMonto/editar"))))
        

// @LINE:1004
private[this] lazy val controllers_haberes_EscalasLaboralesMontosController_eliminar831 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboralMonto/eliminar"))))
        

// @LINE:1005
private[this] lazy val controllers_haberes_EscalasLaboralesMontosController_actualizar832 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboralMonto/actualizar"))))
        

// @LINE:1006
private[this] lazy val controllers_haberes_EscalasLaboralesMontosController_ver833 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/escalaLaboralMonto/ver"))))
        

// @LINE:1008
private[this] lazy val controllers_haberes_GananciasAccionesController_buscarDatosGananciasEnArchivos834 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/gananciasAcciones/buscarDatosGananciasEnArchivos"))))
        

// @LINE:1009
private[this] lazy val controllers_haberes_GananciasAccionesController_modalBuscarDatosGananciasEnArchivos835 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/gananciasAcciones/modalBuscarDatosGananciasEnArchivos"))))
        

// @LINE:1010
private[this] lazy val controllers_haberes_GananciasAccionesController_modalFormularioF649836 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/gananciasAcciones/modalFormularioF649"))))
        

// @LINE:1012
private[this] lazy val controllers_haberes_PrestaFacilController_enviarArchivo837 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("haberes/prestaFacil/enviarArchivo"))))
        

// @LINE:1018
private[this] lazy val controllers_haberes_LiquidacionMesesController_suggestLiquidacionMes838 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestLiquidacionMes/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1019
private[this] lazy val controllers_compras_ArticulosController_suggestArticulo839 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestArticulo/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1020
private[this] lazy val controllers_compras_CategoriasController_suggestCategoria840 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestCategoria/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1021
private[this] lazy val controllers_compras_TipoProductosController_suggestTipoProducto841 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestTipoProducto/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1023
private[this] lazy val controllers_compras_ProductosController_suggestUdm842 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestUdm/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1025
private[this] lazy val controllers_expediente_IniciadorExpedientesController_suggestIniciadorExpediente843 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestIniciador/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1026
private[this] lazy val controllers_rrhh_DepartamentosController_suggestDepartamento844 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestDepartamento/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1027
private[this] lazy val controllers_rrhh_EspecialidadesController_suggestEspecialidad845 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestEspecialidad/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1028
private[this] lazy val controllers_rrhh_ProfesionesController_suggestProfesion846 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestProfesion/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1029
private[this] lazy val controllers_rrhh_TipoResidenciasController_suggestTipoResidencia847 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestTipoResidencia/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1030
private[this] lazy val controllers_rrhh_PuestosController_suggestPuesto848 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestPuesto/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1032
private[this] lazy val controllers_administracion_LocalidadesController_suggestLocalidad849 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestLocalidad/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1033
private[this] lazy val controllers_rrhh_AgentesController_suggestAgente850 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestAgente/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1034
private[this] lazy val controllers_compras_SolicitudesController_suggestSolicitud851 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestSolicitud/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1035
private[this] lazy val controllers_compras_OrdenesController_suggestOrden852 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestOrden/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1037
private[this] lazy val controllers_compras_ProveedoresController_suggestProveedor853 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestProveedor/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1038
private[this] lazy val controllers_delegacion_DepositosController_suggestDeposito854 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestDeposito/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1039
private[this] lazy val controllers_compras_ClientesController_suggestCliente855 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestCliente/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1040
private[this] lazy val controllers_compras_ProductosController_suggestProducto856 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestProducto/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1041
private[this] lazy val controllers_compras_ProductosController_suggestProductoPresupuesto857 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestProductoPresupuesto/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1042
private[this] lazy val controllers_expediente_ExpedientesController_suggestExpediente858 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestExpediente/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1044
private[this] lazy val controllers_compras_ProductosController_getDataSuggestSolicitud859 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestProductoSolicitud/"),DynamicPart("idDeposito", """[^/]+""",true),StaticPart("/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1046
private[this] lazy val controllers_haberes_LiquidacionConceptosController_suggestLiquidacionConceptoTipo860 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestConcepto/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1047
private[this] lazy val controllers_haberes_PuestosLaboralesController_suggestPuestoLaboral861 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestPuestoLaboral/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1048
private[this] lazy val controllers_haberes_PuestosLaboralesController_suggestPuestoLaboralTodos862 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestPuestoLaboralTodos/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1050
private[this] lazy val controllers_administracion_OrganigramasController_suggestOrganigrama863 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestOrganigrama/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1051
private[this] lazy val controllers_compras_ObrasSocialesController_suggestObrasocial864 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestOb/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1052
private[this] lazy val controllers_expediente_ExpedientesController_suggestExpedienteCopia865 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestExpedienteCopia/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1053
private[this] lazy val controllers_rrhh_CiesController_suggestCie866 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suggestCie/"),DynamicPart("input", """[^/]+""",true))))
        

// @LINE:1054
private[this] lazy val controllers_Assets_at867 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(routeDashboard.Routes.documentation,routeContabilidad.Routes.documentation,routePatrimonio.Routes.documentation,routeRecupero.Routes.documentation,routeInformes.Routes.documentation,("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Authentication.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Authentication.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Authentication.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/organigrama/modal-buscar-sevicios""","""controllers.administracion.OrganigramasController.modalBuscarServicios()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/organigrama/get""","""controllers.administracion.OrganigramasController.get(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion""","""controllers.administracion.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/usuarios""","""controllers.administracion.UsuariosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/usuarios/crear""","""controllers.administracion.UsuariosController.crear()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/usuarios/eliminar""","""controllers.administracion.UsuariosController.eliminar(id:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/usuarios/editar""","""controllers.administracion.UsuariosController.editar(id:Integer)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/usuarios/actualizar""","""controllers.administracion.UsuariosController.actualizar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/usuarios/guardar""","""controllers.administracion.UsuariosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/usuarios/suggest/$input<[^/]+>""","""controllers.administracion.UsuariosController.suggest(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/usuarios/modalBuscar""","""controllers.administracion.UsuariosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/usuarios/get""","""controllers.administracion.UsuariosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/permisos""","""controllers.administracion.PermisosController.index(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/asignar""","""controllers.administracion.PermisosController.asignar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/desasignar""","""controllers.administracion.PermisosController.desasignar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/provincias/listOptions""","""controllers.administracion.ProvinciasController.listOptions(paisId:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/localidades/listOptions""","""controllers.administracion.LocalidadesController.listOptions(provinciaId:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/grupos""","""controllers.administracion.GruposController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/grupos/crear""","""controllers.administracion.GruposController.crear()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/grupos/eliminar""","""controllers.administracion.GruposController.eliminar(id:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/grupos/editar""","""controllers.administracion.GruposController.editar(id:Integer)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/grupos/actualizar""","""controllers.administracion.GruposController.actualizar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/grupos/guardar""","""controllers.administracion.GruposController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/grupos/modalBuscar""","""controllers.administracion.GruposController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/grupos/get""","""controllers.administracion.GruposController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/tickets""","""controllers.administracion.TicketsController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/tickets/crear""","""controllers.administracion.TicketsController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/tickets/guardar""","""controllers.administracion.TicketsController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/tickets/editar""","""controllers.administracion.TicketsController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/tickets/actualizar""","""controllers.administracion.TicketsController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/tickets/cambiarEstado""","""controllers.administracion.TicketsController.cambiarEstado(id:Long, estado_id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/tickets/ver""","""controllers.administracion.TicketsController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """administracion/tickets/eliminar""","""controllers.administracion.TicketsController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras""","""controllers.compras.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud""","""controllers.compras.SolicitudesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/crear""","""controllers.compras.SolicitudesController.crearSolicitud(searchIndex:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/guardar""","""controllers.compras.SolicitudesController.guardarSolicitud(searchIndex:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/ver""","""controllers.compras.SolicitudesController.ver(id:Long, searchIndex:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/editar""","""controllers.compras.SolicitudesController.editar(id:Long, searchIndex:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/duplicar""","""controllers.compras.SolicitudesController.duplicar(id:Long, searchIndex:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/eliminar""","""controllers.compras.SolicitudesController.eliminar(id:Long, searchIndex:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/actualizar""","""controllers.compras.SolicitudesController.actualizar(id:Long, searchIndex:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/modificarEntregado""","""controllers.compras.SolicitudesController.modificarEntregado(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/cambiarEstado""","""controllers.compras.SolicitudesController.cambiarEstado(idSolicitud:Long, idEstado:Long, searchIndex:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/redirectIndex""","""controllers.compras.SolicitudesController.redirectSearchIndex(searchIndex:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/modalEditarCuentaAnalitica""","""controllers.compras.SolicitudesController.modalEditarCuentaAnalica()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/editarCuentaAnalitica""","""controllers.compras.SolicitudesController.editarCuentaAnalitica()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/modalBuscar""","""controllers.compras.SolicitudesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/get""","""controllers.compras.SolicitudesController.get(id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/modalImportarListaProductos""","""controllers.compras.SolicitudAccionesController.modalImportarListaProductos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/importarListaProductos""","""controllers.compras.SolicitudAccionesController.importarListaProductos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/modalModificarPacientes""","""controllers.compras.SolicitudAccionesController.modalModificarPaciente(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/modificarPaciente""","""controllers.compras.SolicitudAccionesController.modificarPaciente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/modalPasarAprobadoPorPresupuesto""","""controllers.compras.SolicitudAccionesController.modalPasarAprobadoPorPresupuesto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/pasarAprobadoPorPresupuesto""","""controllers.compras.SolicitudAccionesController.pasarAprobadoPorPresupuesto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/modalPasarAutorizado""","""controllers.compras.SolicitudAccionesController.modalPasarAutorizado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/pasarAutorizado""","""controllers.compras.SolicitudAccionesController.pasarAutorizado()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/modalAsignarUsuario""","""controllers.compras.SolicitudAccionesController.modalAsignarUsuario(id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/asignarUsuario""","""controllers.compras.SolicitudAccionesController.asignarUsuario()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden/index""","""controllers.compras.LineasOrdenesController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden/crear""","""controllers.compras.LineasOrdenesController.crear(ordenId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden/editar""","""controllers.compras.LineasOrdenesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden/guardar""","""controllers.compras.LineasOrdenesController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden/actualizar""","""controllers.compras.LineasOrdenesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden/eliminar""","""controllers.compras.LineasOrdenesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden/modalAddClientes""","""controllers.compras.LineasOrdenesController.modalAddClientes(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden/eliminar-masivo""","""controllers.compras.LineasOrdenesController.eliminarMasivo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden-cliente/guardarAjax""","""controllers.compras.OrdenesLineasClientesController.guardarAjax()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-orden-cliente/eliminarAjax""","""controllers.compras.OrdenesLineasClientesController.eliminarAjax(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenCompra/reporte/cuadroComparativoPrecios""","""controllers.compras.OrdenesReportesController.cuadroComparativoPrecios()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenCompra/reporte/exportacionDatos""","""controllers.compras.OrdenesReportesController.exportacionDatos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenCompra/reporte/exportacionDatosConLineas""","""controllers.compras.OrdenesReportesController.exportacionDatosConLineas()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenCompra/reporte/cuadroSugerenciaAdjudicacion""","""controllers.compras.OrdenesReportesController.cuadroSugerenciaAdjudicación()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenCompra/reporte/controlDolar""","""controllers.compras.OrdenesReportesController.controlDolar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenCompra/reporte/reporteCertificacionPaciente""","""controllers.compras.OrdenesReportesController.reporteCertificacionPaciente(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenCompra/reporte/controlProfe""","""controllers.compras.OrdenesReportesController.controlProfe(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/linea-orden-ajuste/index""","""controllers.compras.OrdenesLineasAjustesController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/linea-orden-ajuste/guardar""","""controllers.compras.OrdenesLineasAjustesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/linea-orden-ajuste/eliminar""","""controllers.compras.OrdenesLineasAjustesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/linea-orden-ajuste/crear""","""controllers.compras.OrdenesLineasAjustesController.crear(ordenId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-solicitud/index""","""controllers.compras.LineasSolicitudesController.index(id:Long ?= 0, editable:Boolean ?= false, btnEliminar:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-solicitud/crear""","""controllers.compras.LineasSolicitudesController.crear(solicitudId:String, idDeposito:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-solicitud/editar""","""controllers.compras.LineasSolicitudesController.editar(id:Long, idDeposito:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-solicitud/guardar""","""controllers.compras.LineasSolicitudesController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-solicitud/actualizar""","""controllers.compras.LineasSolicitudesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-solicitud/eliminar""","""controllers.compras.LineasSolicitudesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-solicitud/eliminarMasivo""","""controllers.compras.LineasSolicitudesController.eliminarMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/ajuste-solicitud/index""","""controllers.compras.AjustesSolicitudesController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/ajuste-solicitud/crear""","""controllers.compras.AjustesSolicitudesController.crear(solicitudId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/ajuste-solicitud/guardar""","""controllers.compras.AjustesSolicitudesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/ajuste-solicitud/eliminar""","""controllers.compras.AjustesSolicitudesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden""","""controllers.compras.OrdenesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/crear""","""controllers.compras.OrdenesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/guardar""","""controllers.compras.OrdenesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/editar""","""controllers.compras.OrdenesController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/eliminar""","""controllers.compras.OrdenesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/duplicar""","""controllers.compras.OrdenesController.duplicar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/actualizar""","""controllers.compras.OrdenesController.actualizar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/modalImportarListaProductos""","""controllers.compras.OrdenesAccionesController.modalImportarListaProductos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/importarListaProductos""","""controllers.compras.OrdenesAccionesController.importarListaProductos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/ver""","""controllers.compras.OrdenesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/modalEditarCuentaAnalitica""","""controllers.compras.OrdenesController.modalEditarCuentaAnalica(tipo:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/editarCuentaAnalitica""","""controllers.compras.OrdenesController.editarCuentaAnalitica()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/cambiarEstado""","""controllers.compras.OrdenesController.cambiarEstado(idOrden:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/modalBuscar""","""controllers.compras.OrdenesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/get""","""controllers.compras.OrdenesController.get(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/modalEditarMontoAdelanto""","""controllers.compras.OrdenesAccionesController.modalEditarMontoAdelanto(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/editarMontoAdelanto""","""controllers.compras.OrdenesAccionesController.editarMontoAdelanto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/modalEditarCotDolar""","""controllers.compras.OrdenesAccionesController.modalEditarCotDolar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/editarCotDolar""","""controllers.compras.OrdenesAccionesController.editarCotDolar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/modalEditarFechaProvision""","""controllers.compras.OrdenesAccionesController.modalEditarFechaProvision(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/editarFechaProvision""","""controllers.compras.OrdenesAccionesController.editarFechaProvision()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/modalEditarRubro""","""controllers.compras.OrdenesAccionesController.modalEditarRubro(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/editarRubro""","""controllers.compras.OrdenesAccionesController.editarRubro()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/modalOrdenMail""","""controllers.compras.OrdenesAccionesController.modalOrdenMail(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/enviarOrdenMail""","""controllers.compras.OrdenesAccionesController.enviarOrdenMail()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/ordenSubrubro/listOptions""","""controllers.compras.OrdenSubrubroController.listOptions(rubroId:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/modalCrearDispo""","""controllers.compras.OrdenesAccionesController.modalCrearDispo(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/crearDispo""","""controllers.compras.OrdenesAccionesController.crearDispo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion""","""controllers.compras.CertificacionesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/crear""","""controllers.compras.CertificacionesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/guardar""","""controllers.compras.CertificacionesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/editar""","""controllers.compras.CertificacionesController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/eliminar""","""controllers.compras.CertificacionesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/ver""","""controllers.compras.CertificacionesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/duplicar""","""controllers.compras.CertificacionesController.duplicar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/actualizar""","""controllers.compras.CertificacionesController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/cambiarEstado""","""controllers.compras.CertificacionesController.cambiarEstado(idCertificacion:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalEditarCuentaAnalitica""","""controllers.compras.CertificacionesController.modalEditarCuentaAnalica()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/editarCuentaAnalitica""","""controllers.compras.CertificacionesController.editarCuentaAnalitica()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalPasarEnCurso""","""controllers.compras.CertificacionesAccionesController.modalPasarEnCurso()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/pasarEnCursoMasivo""","""controllers.compras.CertificacionesAccionesController.pasarEnCursoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalPasarCertificado""","""controllers.compras.CertificacionesAccionesController.modalPasarCertificado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/pasarCertificadoMasivo""","""controllers.compras.CertificacionesAccionesController.pasarCertificadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalPasarAprobado""","""controllers.compras.CertificacionesAccionesController.modalPasarAprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/pasarAprobadoMasivo""","""controllers.compras.CertificacionesAccionesController.pasarAprobadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalPasarBorrador""","""controllers.compras.CertificacionesAccionesController.modalPasarBorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/pasarBorradorMasivo""","""controllers.compras.CertificacionesAccionesController.pasarBorradorMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalPasarCancelado""","""controllers.compras.CertificacionesAccionesController.modalPasarCancelado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/pasarCanceladoMasivo""","""controllers.compras.CertificacionesAccionesController.pasarCanceladoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalEditarFechaCertificacion""","""controllers.compras.CertificacionesAccionesController.modalEditarFechaCertificacion()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/editarFechaCertificacionMasivo""","""controllers.compras.CertificacionesAccionesController.editarFechaCertificacionMasivo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/reporteTasa""","""controllers.compras.CertificacionesReportesController.reporteTasas()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/reporteElevaciones""","""controllers.compras.CertificacionesReportesController.reporteElevaciones(desc:Boolean)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/reportes/bajas""","""controllers.compras.CertificacionesReportesController.bajas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalDuplicarMasivo""","""controllers.compras.CertificacionesAccionesController.modalDuplicarMasivo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/duplicarMasivo""","""controllers.compras.CertificacionesAccionesController.duplicarMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalCrearAguinaldo""","""controllers.compras.CertificacionesAccionesController.modalCrearAguinaldo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/CrearAguinaldo""","""controllers.compras.CertificacionesAccionesController.crearAguinaldo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/reportePlanilla""","""controllers.compras.CertificacionesReportesController.reportePlanillaSueldos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalDetalleCertificacion""","""controllers.compras.CertificacionesAccionesController.modalDetalleCertificacion(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion/modalDetalleCertificacionesPorEstadoPorPeriodo""","""controllers.compras.CertificacionesAccionesController.modalDetalleCertificacionesPorEstadoPorPeriodo(nombrePeriodo:String, estado:Integer, proveedorId:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea/index""","""controllers.compras.LineasCertificacionesController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea/crear""","""controllers.compras.LineasCertificacionesController.crear(certificacionId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea/editar""","""controllers.compras.LineasCertificacionesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea/guardar""","""controllers.compras.LineasCertificacionesController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea/actualizar""","""controllers.compras.LineasCertificacionesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea/eliminar""","""controllers.compras.LineasCertificacionesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea-ajuste/index""","""controllers.compras.CertificacionesComprasLineaAjustesController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea-ajuste/crear""","""controllers.compras.CertificacionesComprasLineaAjustesController.crear(certificacionId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea-ajuste/editar""","""controllers.compras.CertificacionesComprasLineaAjustesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea-ajuste/guardar""","""controllers.compras.CertificacionesComprasLineaAjustesController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea-ajuste/actualizar""","""controllers.compras.CertificacionesComprasLineaAjustesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-linea-ajuste/eliminar""","""controllers.compras.CertificacionesComprasLineaAjustesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificaciones/reporteCertificacion""","""controllers.compras.CertificacionesReportesController.reporteCertificacion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificaciones/acciones/crear-masivo""","""controllers.compras.CertificacionesController.crearMasivo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificaciones/acciones/procesar-masivo""","""controllers.compras.CertificacionesController.procesarMasivo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/reporte/imputacionPreventiva""","""controllers.compras.SolicitudesReportesController.reporteImputacionPreventivaLista()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/orden/reporte/imputacionDefinitiva""","""controllers.compras.OrdenesReportesController.reporteImputacionDefinitivaGlobal()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/reporte/cuadroSolicitud""","""controllers.compras.SolicitudesReportesController.reporteCuadroSolicitud()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/reporte/lineasCotizacion""","""controllers.compras.SolicitudesReportesController.reporteLineasCotizacion(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """orden/reporte/listadoLineas""","""controllers.compras.OrdenesReportesController.listadoLineas(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/reporte/imputacionDefinitiva""","""controllers.compras.OrdenesReportesController.reporteImputacionDefinitiva(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/reporte/modalInformeFarmacia""","""controllers.compras.SolicitudesReportesController.modalInformeFarmacia()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/reporte/informeFarmacia""","""controllers.compras.SolicitudesReportesController.informeFarmacia()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/reporte/modalInformeFarmaciaPorUsuario""","""controllers.compras.SolicitudesReportesController.modalInformeFarmaciaPorUsuario()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/reporte/informeFarmaciaPorUsuario""","""controllers.compras.SolicitudesReportesController.informeFarmaciaPorUsuario()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/solicitud/reporte/informeFarmaciaPaciente""","""controllers.compras.SolicitudesReportesController.informeFarmaciaPaciente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedidoFondo""","""controllers.compras.PedidosFondosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedidoFondo/crear""","""controllers.compras.PedidosFondosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedidoFondo/guardar""","""controllers.compras.PedidosFondosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedidoFondo/editar""","""controllers.compras.PedidosFondosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedidoFondo/eliminar""","""controllers.compras.PedidosFondosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedidoFondo/ver""","""controllers.compras.PedidosFondosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedidoFondo/actualizar""","""controllers.compras.PedidosFondosController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedido-fondo-linea/index""","""controllers.compras.LineasPedidosFondosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedido-fondo-linea/crear""","""controllers.compras.LineasPedidosFondosController.crear(pedidoFondoId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedido-fondo-linea/editar""","""controllers.compras.LineasPedidosFondosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedido-fondo-linea/guardar""","""controllers.compras.LineasPedidosFondosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedido-fondo-linea/actualizar""","""controllers.compras.LineasPedidosFondosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/pedido-fondo-linea/eliminar""","""controllers.compras.LineasPedidosFondosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/acciones/combinar""","""controllers.compras.OrdenesAccionesController.combinar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/acciones/generarOrdenSegunCuadroSugerenia""","""controllers.compras.OrdenesAccionesController.generarOrdenSegunCuadroSugerenia()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/reporte/reportePedidoAbastecimiento""","""controllers.compras.SolicitudesReportesController.reportePedidoAbastecimiento(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/reporte/imputacionPreventiva""","""controllers.compras.SolicitudesReportesController.reporteImputacionPreventiva(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores""","""controllers.compras.ProveedoresController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/crear""","""controllers.compras.ProveedoresController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/guardar""","""controllers.compras.ProveedoresController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/eliminar""","""controllers.compras.ProveedoresController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/eliminarContacto""","""controllers.compras.ProveedoresController.eliminarContacto(sid:Long, cId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/editar""","""controllers.compras.ProveedoresController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/editarContacto""","""controllers.compras.ProveedoresController.formularioContacto(proveedorId:Long, id:Long ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/actualizarContacto""","""controllers.compras.ProveedoresController.actualizarContacto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/guardarContacto""","""controllers.compras.ProveedoresController.guardarContacto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/actualizar""","""controllers.compras.ProveedoresController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/modalBuscar""","""controllers.compras.ProveedoresController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/get""","""controllers.compras.ProveedoresController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/modalInformacionProveedor""","""controllers.compras.ProveedoresAccionesController.modalInformacionProveedor(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/ver""","""controllers.compras.ProveedoresController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/proveedores/actualizarMail""","""controllers.compras.ProveedoresAccionesController.actualizarMail()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes""","""controllers.compras.ClientesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/crear""","""controllers.compras.ClientesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/guardar""","""controllers.compras.ClientesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/editar""","""controllers.compras.ClientesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/actualizar""","""controllers.compras.ClientesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/eliminar""","""controllers.compras.ClientesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/ver""","""controllers.compras.ClientesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/editarContacto""","""controllers.compras.ClientesController.formularioContacto(clienteId:Long, id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/eliminarContacto""","""controllers.compras.ClientesController.eliminarContacto(sid:Long, cId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/modalBuscar""","""controllers.compras.ClientesController.modalBuscar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/clientes/actualizarContacto""","""controllers.compras.ClientesController.actualizarContacto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/get""","""controllers.compras.ClientesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/modalCargar""","""controllers.compras.ClientesController.modalCarga()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/guardarDesdeModal""","""controllers.compras.ClientesController.guardarDesdeModal()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/productos""","""controllers.compras.ProductosController.indexProducto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/productos/""","""controllers.compras.ProductosController.listarProducto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/productos/crear""","""controllers.compras.ProductosController.crearProducto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/productos/guardar""","""controllers.compras.ProductosController.guardarProducto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/productos/editar""","""controllers.compras.ProductosController.editarProducto(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/productos/eliminar""","""controllers.compras.ProductosController.eliminarProducto(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/actualizar""","""controllers.compras.ProductosController.actualizarProducto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/modalBuscar""","""controllers.compras.ProductosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/modalBuscarIps""","""controllers.compras.ProductosController.modalBuscarIps()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/modalBuscarSolicitudes""","""controllers.compras.ProductosController.modalBuscarSolicitudes(idSolicitud:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/get""","""controllers.compras.ProductosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/ver""","""controllers.compras.ProductosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/getPrecio""","""controllers.compras.ProductosController.getPrecioProducto(producto_id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/cargaProductoRismi""","""controllers.compras.ProductosController.cargaProductoRismi()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/modalCargar""","""controllers.compras.ProductosController.modalCarga()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/producto/guardarProductoDesdeModal""","""controllers.compras.ProductosController.guardarProductoDesdeModal()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/categorias""","""controllers.compras.CategoriasController.indexCategoria()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/categorias/crear""","""controllers.compras.CategoriasController.crearCategoria()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/categorias/guardar""","""controllers.compras.CategoriasController.guardarCategoria()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/categorias/editar""","""controllers.compras.CategoriasController.editarCategoria(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/categorias/eliminar""","""controllers.compras.CategoriasController.eliminarCategoria(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/categorias/actualizar""","""controllers.compras.CategoriasController.actualizarCategoria()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/categorias/modalBuscar""","""controllers.compras.CategoriasController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/categorias/get""","""controllers.compras.CategoriasController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/tipo-producto""","""controllers.compras.TipoProductosController.indexTipoProducto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/tipo-producto/crear""","""controllers.compras.TipoProductosController.crearTipoProducto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/tipo-producto/guardar""","""controllers.compras.TipoProductosController.guardarTipoProducto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/tipo-producto/editar""","""controllers.compras.TipoProductosController.editarTipoProducto(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/tipo-producto/eliminar""","""controllers.compras.TipoProductosController.eliminarTipoProducto(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/tipo-producto/actualizar""","""controllers.compras.TipoProductosController.actualizarTipoProducto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/tipo-producto/modalBuscar""","""controllers.compras.TipoProductosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/tipo-producto/get""","""controllers.compras.TipoProductosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/articulo""","""controllers.compras.ArticulosController.indexArticulo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/articulo/crear""","""controllers.compras.ArticulosController.crearArticulo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/articulo/guardar""","""controllers.compras.ArticulosController.guardarArticulo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/articulo/editar""","""controllers.compras.ArticulosController.editarArticulo(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/articulo/eliminar""","""controllers.compras.ArticulosController.eliminarArticulo(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/articulo/actualizar""","""controllers.compras.ArticulosController.actualizarArticulo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/articulo/modalBuscar""","""controllers.compras.ArticulosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/articulo/get""","""controllers.compras.ArticulosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-atributo/index""","""controllers.compras.ProveedorAtributosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-atributo/crear""","""controllers.compras.ProveedorAtributosController.crear(proveedorId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-atributo/editar""","""controllers.compras.ProveedorAtributosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-atributo/guardar""","""controllers.compras.ProveedorAtributosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-atributo/actualizar""","""controllers.compras.ProveedorAtributosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-atributo/eliminar""","""controllers.compras.ProveedorAtributosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-datodgr/index""","""controllers.compras.ProveedorDatosDgrController.index(cuit:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-datodgr/crear""","""controllers.compras.ProveedorDatosDgrController.crear(cuit:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-datodgr/editar""","""controllers.compras.ProveedorDatosDgrController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-datodgr/guardar""","""controllers.compras.ProveedorDatosDgrController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-datodgr/actualizar""","""controllers.compras.ProveedorDatosDgrController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/linea-proveedor-datodgr/eliminar""","""controllers.compras.ProveedorDatosDgrController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/ob/modalBuscar""","""controllers.compras.ObrasSocialesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/ob/get""","""controllers.compras.ObrasSocialesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra""","""controllers.compras.CertificacionesComprasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/crear""","""controllers.compras.CertificacionesComprasController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/guardar""","""controllers.compras.CertificacionesComprasController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/editar""","""controllers.compras.CertificacionesComprasController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/eliminar""","""controllers.compras.CertificacionesComprasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/ver""","""controllers.compras.CertificacionesComprasController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/duplicar""","""controllers.compras.CertificacionesComprasController.duplicar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/actualizar""","""controllers.compras.CertificacionesComprasController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/cambiarEstado""","""controllers.compras.CertificacionesComprasController.cambiarEstado(idCertificacion:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/modalEditarCuentaAnalitica""","""controllers.compras.CertificacionesComprasController.modalEditarCuentaAnalica()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/editarCuentaAnalitica""","""controllers.compras.CertificacionesComprasController.editarCuentaAnalitica()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/modalPasarEnCurso""","""controllers.compras.CertificacionesComprasAccionesController.modalPasarEnCurso()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/pasarEnCursoMasivo""","""controllers.compras.CertificacionesComprasAccionesController.pasarEnCursoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/modalPasarCertificado""","""controllers.compras.CertificacionesComprasAccionesController.modalPasarCertificado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/pasarCertificadoMasivo""","""controllers.compras.CertificacionesComprasAccionesController.pasarCertificadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/modalPasarBorrador""","""controllers.compras.CertificacionesComprasAccionesController.modalPasarBorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/pasarBorradorMasivo""","""controllers.compras.CertificacionesComprasAccionesController.pasarBorradorMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/modalPasarCancelado""","""controllers.compras.CertificacionesComprasAccionesController.modalPasarCancelado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/pasarCanceladoMasivo""","""controllers.compras.CertificacionesComprasAccionesController.pasarCanceladoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/modalEditarFechaCertificacion""","""controllers.compras.CertificacionesComprasAccionesController.modalEditarFechaCertificacion()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra/editarFechaCertificacionMasivo""","""controllers.compras.CertificacionesComprasAccionesController.editarFechaCertificacionMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra-linea/index""","""controllers.compras.CertificacionesComprasLineasController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra-linea/crear""","""controllers.compras.CertificacionesComprasLineasController.crear(certificacionId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra-linea/editar""","""controllers.compras.CertificacionesComprasLineasController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra-linea/guardar""","""controllers.compras.CertificacionesComprasLineasController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra-linea/actualizar""","""controllers.compras.CertificacionesComprasLineasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-compra-linea/eliminar""","""controllers.compras.CertificacionesComprasLineasController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificaciones-compra/reporteCertificacion""","""controllers.compras.CertificacionesComprasReportesController.reporteCertificacion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra""","""controllers.compras.CertificacionesObrasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/crear""","""controllers.compras.CertificacionesObrasController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/guardar""","""controllers.compras.CertificacionesObrasController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/editar""","""controllers.compras.CertificacionesObrasController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/eliminar""","""controllers.compras.CertificacionesObrasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/ver""","""controllers.compras.CertificacionesObrasController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/duplicar""","""controllers.compras.CertificacionesObrasController.duplicar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/actualizar""","""controllers.compras.CertificacionesObrasController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/cambiarEstado""","""controllers.compras.CertificacionesObrasController.cambiarEstado(idCertificacion:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/modalEditarCuentaAnalitica""","""controllers.compras.CertificacionesObrasController.modalEditarCuentaAnalica()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/certificacion-obra/editarCuentaAnalitica""","""controllers.compras.CertificacionesObrasController.editarCuentaAnalitica()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica""","""controllers.compras.CajaChicaController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/ver""","""controllers.compras.CajaChicaController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/crear""","""controllers.compras.CajaChicaController.crear()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/guardar""","""controllers.compras.CajaChicaController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/editar""","""controllers.compras.CajaChicaController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/actualizar""","""controllers.compras.CajaChicaController.actualizar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/eliminar""","""controllers.compras.CajaChicaController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/cambiarEstado""","""controllers.compras.CajaChicaController.cambiarEstado(id:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/resumenPresupuesto""","""controllers.compras.CajaChicaController.resumenPresupuesto(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/reporteImputacionPreventivaLista""","""controllers.compras.CajaChicaController.reporteImputacionPreventivaLista(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/reporteImputacionPreventivaListaAjuste""","""controllers.compras.CajaChicaController.reporteImputacionPreventivaAjustesLista(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/reporteImputacionDefinitiva""","""controllers.compras.CajaChicaController.reporteImputacionDefinitiva(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/reporteCajaChica""","""controllers.compras.CajaChicaController.reporteCajaChica(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica/reporteCajaChicaOrdenCargo""","""controllers.compras.CajaChicaController.reporteCajaChicaOrdenCargo(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica-movimientos""","""controllers.compras.CajaChicaMovimientosController.lista(cajaId:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica-movimientos/crear""","""controllers.compras.CajaChicaMovimientosController.crear(cajaId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica-movimientos/editar""","""controllers.compras.CajaChicaMovimientosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica-movimientos/guardar""","""controllers.compras.CajaChicaMovimientosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica-movimientos/actualizar""","""controllers.compras.CajaChicaMovimientosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica-movimientos/eliminar""","""controllers.compras.CajaChicaMovimientosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica-presupuesto""","""controllers.compras.CajaChicaPresupuestoLineasController.lista(cajaId:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica-presupuesto/crear""","""controllers.compras.CajaChicaPresupuestoLineasController.crear(cajaId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """compras/caja-chica-presupuesto/guardar""","""controllers.compras.CajaChicaPresupuestoLineasController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente""","""controllers.expediente.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/iniciadorExpediente""","""controllers.expediente.IniciadorExpedientesController.indexIniciadorExpediente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/iniciadorExpediente/crear""","""controllers.expediente.IniciadorExpedientesController.crearIniciadorExpediente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/iniciadorExpediente/guardar""","""controllers.expediente.IniciadorExpedientesController.guardarIniciadorExpediente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/iniciadorExpediente/editar""","""controllers.expediente.IniciadorExpedientesController.editarIniciadorExpediente(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expedient/iniciadorExpediente/eliminar""","""controllers.expediente.IniciadorExpedientesController.eliminarIniciadorExpediente(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/iniciadorExpediente/actualizar""","""controllers.expediente.IniciadorExpedientesController.actualizarIniciadorExpediente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/iniciadorExpediente/modalBuscar""","""controllers.expediente.IniciadorExpedientesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/iniciadorExpediente/get""","""controllers.expediente.IniciadorExpedientesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/reportes/reporteMovimiento""","""controllers.expediente.ExpedientesReportesController.reporteMovimiento()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente""","""controllers.expediente.ExpedientesController.indexExpediente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/crear""","""controllers.expediente.ExpedientesController.crearExpediente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/guardar""","""controllers.expediente.ExpedientesController.guardarExpediente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/editar""","""controllers.expediente.ExpedientesController.editarExpediente(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/eliminar""","""controllers.expediente.ExpedientesController.eliminarExpediente(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/eliminarCopia""","""controllers.expediente.ExpedientesController.eliminarExpedienteCopia(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/actualizar""","""controllers.expediente.ExpedientesController.actualizarExpediente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/modalBuscar""","""controllers.expediente.ExpedientesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/modalBuscarCopia""","""controllers.expediente.ExpedientesController.modalBuscarCopia()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/get""","""controllers.expediente.ExpedientesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/ver""","""controllers.expediente.ExpedientesController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/reporteTapaExpedienteMasiva""","""controllers.expediente.ExpedientesController.reporteTapaExpedienteMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/reporteTapaExpediente""","""controllers.expediente.ExpedientesController.reporteTapaExpediente(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/reporteListadoExpedientes""","""controllers.expediente.ExpedientesController.listadoExpedientes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/crearCopia""","""controllers.expediente.ExpedientesController.crearCopia(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expediente/crearRP""","""controllers.expediente.ExpedientesController.crearRP(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/getExpedientesRecepcionSinFirma""","""controllers.expediente.ExpedientesController.getExpedientesRecepcionSinFirma()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/getExpedientesRecepcionSinFirmaReporte""","""controllers.expediente.ExpedientesController.getExpedientesRecepcionSinFirmaReporte()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/getExpedientesSinFirma""","""controllers.expediente.ExpedientesController.getExpedientesSinFirma()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/getExpedientesSinFirmaReporte""","""controllers.expediente.ExpedientesController.getExpedientesSinFirmaReporte()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/movimiento-linea/index""","""controllers.expediente.ExpedientesMovimientosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/movimiento-linea/crear""","""controllers.expediente.ExpedientesMovimientosController.crear(expedienteId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/movimiento-linea/editar""","""controllers.expediente.ExpedientesMovimientosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/movimiento-linea/guardar""","""controllers.expediente.ExpedientesMovimientosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/movimiento-linea/actualizar""","""controllers.expediente.ExpedientesMovimientosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/movimiento-linea/eliminar""","""controllers.expediente.ExpedientesMovimientosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/acciones/modalPasarOtroServicio""","""controllers.expediente.ExpedientesAccionesController.modalPasarOtroServicio()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/acciones/modalPasarOtroServicioIndividual""","""controllers.expediente.ExpedientesAccionesController.modalPasarOtroServicioIndividual(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/acciones/pasarOtroServicio""","""controllers.expediente.ExpedientesAccionesController.pasarOtroServicio()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/reportes/reportePaseExpediente""","""controllers.expediente.ExpedientesReportesController.reportePaseExpediente(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/reportes/reportePaseExpedienteLista""","""controllers.expediente.ExpedientesReportesController.reportePaseExpedienteListaCodigoCombinado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/reportes/reportePaseExpedienteCodigo""","""controllers.expediente.ExpedientesReportesController.reportePaseExpedienteListaCodigo(codigo:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/reportes/reportePaseExpedienteLista""","""controllers.expediente.ExpedientesReportesController.reportePaseExpedienteLista()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/acciones/cancelarPase""","""controllers.expediente.ExpedientesAccionesController.cancelarPase(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/acciones/cancelarPaseLista""","""controllers.expediente.ExpedientesAccionesController.cancelarPaseLista()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/acciones/asignarMiServicio""","""controllers.expediente.ExpedientesAccionesController.asignarMiServicio(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/expedienteMisPases""","""controllers.expediente.ExpedientesMisPasesController.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/acciones/asignarMiServicioMasivo""","""controllers.expediente.ExpedientesAccionesController.asignarAMiServicioMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/acciones/modalAsignarMiServicio""","""controllers.expediente.ExpedientesAccionesController.modalAsignarMiServicio()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo""","""controllers.expediente.DisposController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/crear""","""controllers.expediente.DisposController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/guardar""","""controllers.expediente.DisposController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/editar""","""controllers.expediente.DisposController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/actualizar""","""controllers.expediente.DisposController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/eliminar""","""controllers.expediente.DisposController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/ver""","""controllers.expediente.DisposController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/getLastNumeroDispo""","""controllers.expediente.DisposController.getLastNumeroDispo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/getLastNumeroDispoByOrden""","""controllers.expediente.DisposController.getLastNumeroDispoByOrden()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/getDisposPorExpediente""","""controllers.expediente.DisposController.getDisposPorExpediente(expedienteId:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expediente/dispo/cambiarEstado""","""controllers.expediente.DisposController.cambiarEstado(idDispo:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh""","""controllers.rrhh.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/departamento/modalBuscar""","""controllers.rrhh.DepartamentosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/departamento/get""","""controllers.rrhh.DepartamentosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-estudio/index""","""controllers.rrhh.AgentesEstudiosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-estudio/crear""","""controllers.rrhh.AgentesEstudiosController.crear(agenteId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-estudio/editar""","""controllers.rrhh.AgentesEstudiosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-estudio/guardar""","""controllers.rrhh.AgentesEstudiosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-estudio/actualizar""","""controllers.rrhh.AgentesEstudiosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-estudio/eliminar""","""controllers.rrhh.AgentesEstudiosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-estudio/listOptionsSubarea""","""controllers.rrhh.AgentesEstudiosController.listOptionsEstudioSubareas(estudioAreaId:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-rul/index""","""controllers.rrhh.AgentesRulController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-rul/crear""","""controllers.rrhh.AgentesRulController.crear(agenteId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-rul/editar""","""controllers.rrhh.AgentesRulController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-rul/guardar""","""controllers.rrhh.AgentesRulController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-rul/actualizar""","""controllers.rrhh.AgentesRulController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-rul/eliminar""","""controllers.rrhh.AgentesRulController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-novedad/index""","""controllers.rrhh.AgentesNovedadesController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-novedad/crear""","""controllers.rrhh.AgentesNovedadesController.crear(agenteId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-novedad/editar""","""controllers.rrhh.AgentesNovedadesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-novedad/guardar""","""controllers.rrhh.AgentesNovedadesController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-novedad/actualizar""","""controllers.rrhh.AgentesNovedadesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-novedad/eliminar""","""controllers.rrhh.AgentesNovedadesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-hijo/index""","""controllers.rrhh.AgentesHijosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-hijo/crear""","""controllers.rrhh.AgentesHijosController.crear(agenteId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-hijo/editar""","""controllers.rrhh.AgentesHijosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-hijo/guardar""","""controllers.rrhh.AgentesHijosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-hijo/actualizar""","""controllers.rrhh.AgentesHijosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-hijo/eliminar""","""controllers.rrhh.AgentesHijosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-familia/index""","""controllers.rrhh.AgentesFamiliasController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-familia/crear""","""controllers.rrhh.AgentesFamiliasController.crear(agenteId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-familia/editar""","""controllers.rrhh.AgentesFamiliasController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-familia/guardar""","""controllers.rrhh.AgentesFamiliasController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-familia/actualizar""","""controllers.rrhh.AgentesFamiliasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-familia/eliminar""","""controllers.rrhh.AgentesFamiliasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/departamento""","""controllers.rrhh.DepartamentosController.indexDepartamento()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/departamento/crear""","""controllers.rrhh.DepartamentosController.crearDepartamento()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/departamento/guardar""","""controllers.rrhh.DepartamentosController.guardarDepartamento()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/departamento/editar""","""controllers.rrhh.DepartamentosController.editarDepartamento(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/departamento/eliminar""","""controllers.rrhh.DepartamentosController.eliminarDepartamento(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/departamento/actualizar""","""controllers.rrhh.DepartamentosController.actualizarDepartamento()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/especialidad""","""controllers.rrhh.EspecialidadesController.indexEspecialidad()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/especialidad/crear""","""controllers.rrhh.EspecialidadesController.crearEspecialidad()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/especialidad/guardar""","""controllers.rrhh.EspecialidadesController.guardarEspecialidad()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/especialidad/editar""","""controllers.rrhh.EspecialidadesController.editarEspecialidad(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/especialidad/eliminar""","""controllers.rrhh.EspecialidadesController.eliminarEspecialidad(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/especialidad/actualizar""","""controllers.rrhh.EspecialidadesController.actualizarEspecialidad()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/especialidad/modalBuscar""","""controllers.rrhh.EspecialidadesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/especialidad/get""","""controllers.rrhh.EspecialidadesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/profesion/modalBuscar""","""controllers.rrhh.ProfesionesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/profesion/get""","""controllers.rrhh.ProfesionesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/cie/modalBuscar""","""controllers.rrhh.CiesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/cie/get""","""controllers.rrhh.CiesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/tipoResidencia/modalBuscar""","""controllers.rrhh.TipoResidenciasController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/tipoResidencia/get""","""controllers.rrhh.TipoResidenciasController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/tipoResidencia""","""controllers.rrhh.TipoResidenciasController.indexTipoResidencia()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/tipoResidencia/crear""","""controllers.rrhh.TipoResidenciasController.crearTipoResidencia()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/tipoResidencia/guardar""","""controllers.rrhh.TipoResidenciasController.guardarTipoResidencia()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/tipoResidencia/editar""","""controllers.rrhh.TipoResidenciasController.editarTipoResidencia(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/tipoResidencia/eliminar""","""controllers.rrhh.TipoResidenciasController.eliminarTipoResidencia(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/tipoResidencia/actualizar""","""controllers.rrhh.TipoResidenciasController.actualizarTipoResidencia()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/tipoResidencia/ver""","""controllers.rrhh.TipoResidenciasController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/puesto""","""controllers.rrhh.PuestosController.indexPuesto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/puesto/crear""","""controllers.rrhh.PuestosController.crearPuesto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/puesto/guardar""","""controllers.rrhh.PuestosController.guardarPuesto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/puesto/editar""","""controllers.rrhh.PuestosController.editarPuesto(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/puesto/eliminar""","""controllers.rrhh.PuestosController.eliminarPuesto(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/puesto/actualizar""","""controllers.rrhh.PuestosController.actualizarPuesto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/puesto/modalBuscar""","""controllers.rrhh.PuestosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/puesto/get""","""controllers.rrhh.PuestosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente""","""controllers.rrhh.AgentesController.indexAgente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/crear""","""controllers.rrhh.AgentesController.crearAgente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/guardar""","""controllers.rrhh.AgentesController.guardarAgente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/editar""","""controllers.rrhh.AgentesController.editarAgente(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/eliminar""","""controllers.rrhh.AgentesController.eliminarAgente(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/actualizar""","""controllers.rrhh.AgentesController.actualizarAgente(agenteId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/modalBuscar""","""controllers.rrhh.AgentesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/get""","""controllers.rrhh.AgentesController.get(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/ver""","""controllers.rrhh.AgentesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/modalReplicarProveedor""","""controllers.rrhh.AgentesAccionesController.modalReplicarProveedor(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/replicarProveedor""","""controllers.rrhh.AgentesAccionesController.replicarProveedor()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/cambiar-estado""","""controllers.rrhh.AgentesController.cambiarEstado(idAgente:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/modalPasarAAprobado""","""controllers.rrhh.AgentesAccionesController.modalPasarAAprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/pasarAAprobado""","""controllers.rrhh.AgentesAccionesController.pasarAAprobado()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/modalPasarABorrador""","""controllers.rrhh.AgentesAccionesController.modalPasarABorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/pasarABorrador""","""controllers.rrhh.AgentesAccionesController.pasarABorrador()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/modalPasarACancelado""","""controllers.rrhh.AgentesAccionesController.modalPasarACancelado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/pasarACancelado""","""controllers.rrhh.AgentesAccionesController.pasarACancelado()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/modalPasarACargado""","""controllers.rrhh.AgentesAccionesController.modalPasarACargado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/pasarACargado""","""controllers.rrhh.AgentesAccionesController.pasarACargado()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/modalPasarAPreaprobado""","""controllers.rrhh.AgentesAccionesController.modalPasarAPreaprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/pasarAPreaprobado""","""controllers.rrhh.AgentesAccionesController.pasarAPreaprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/actualizarMail""","""controllers.rrhh.AgentesController.actualizarMail()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/novedades""","""controllers.rrhh.NovedadesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/novedades/ver""","""controllers.rrhh.NovedadesController.ver(id:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/novedades/eliminar""","""controllers.rrhh.NovedadesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/novedades/crear""","""controllers.rrhh.NovedadesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/novedades/guardar""","""controllers.rrhh.NovedadesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/novedades/editar""","""controllers.rrhh.NovedadesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/novedades/actualizar""","""controllers.rrhh.NovedadesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/novedades/lista""","""controllers.rrhh.NovedadesController.lista()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/novedades/feriados""","""controllers.rrhh.NovedadesController.getFeriados()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/reportes/ficha""","""controllers.rrhh.AgentesReportesController.ficha(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/reportes/fichaAptitud""","""controllers.rrhh.AgentesReportesController.fichaAptitud(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/reportes/reportesDatosAgente""","""controllers.rrhh.AgentesReportesController.reportesDatosAgente()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente/reportes/reportesCertificacionesAgente""","""controllers.rrhh.AgentesReportesController.reportesCertificacionesAgente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteAsistencia/index""","""controllers.rrhh.AgentesAsistenciasController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteAsistencia/editar""","""controllers.rrhh.AgentesAsistenciasController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteAsistencia/ver""","""controllers.rrhh.AgentesAsistenciasController.ver(id:Long, tipoLicencia:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/index""","""controllers.rrhh.AgentesAsistenciasLicenciasController.index(id:Long ?= 0, editable:Boolean ?= false, tipoLicencia:Long ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/crear""","""controllers.rrhh.AgentesAsistenciasLicenciasController.crear(agenteId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/editar""","""controllers.rrhh.AgentesAsistenciasLicenciasController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencian/guardar""","""controllers.rrhh.AgentesAsistenciasLicenciasController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/actualizar""","""controllers.rrhh.AgentesAsistenciasLicenciasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/eliminar""","""controllers.rrhh.AgentesAsistenciasLicenciasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/modalPasarBorrador""","""controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarBorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/pasarBorradorMasivo""","""controllers.rrhh.AgentesAsistenciasLicenciasController.pasarBorradorMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/modalPasarCancelado""","""controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarCancelado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/pasarCanceladoMasivo""","""controllers.rrhh.AgentesAsistenciasLicenciasController.pasarCanceladoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/modalPasarPreAprobado""","""controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarPreAprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/pasarPreAprobadoMasivo""","""controllers.rrhh.AgentesAsistenciasLicenciasController.pasarPreAprobadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/modalPasarAprobado""","""controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarAprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/pasarAprobadoMasivo""","""controllers.rrhh.AgentesAsistenciasLicenciasController.pasarAprobadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/resumen""","""controllers.rrhh.AgentesAsistenciasLicenciasController.resumen(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/getListaLicenciasPendientes""","""controllers.rrhh.AgentesAsistenciasLicenciasController.getListaLicenciasPendientes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agente-asistencia-licencia/getListaLicenciasEnFecha""","""controllers.rrhh.AgentesAsistenciasLicenciasController.getListaLicenciasEnFecha()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteAsistencia/reporteLicencia""","""controllers.rrhh.AgentesAsistenciasReportesController.reporteLicencia()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteAsistencia/reporteLicenciaMedicinaLaboral""","""controllers.rrhh.AgentesAsistenciasReportesController.reporteLicenciaMedicinaLaboral()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteSeguimiento/index""","""controllers.rrhh.AgentesSeguimientoController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteSeguimiento/ver""","""controllers.rrhh.AgentesSeguimientoController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteSeguimiento/crear""","""controllers.rrhh.AgentesSeguimientoController.crearAgenteSeguimiento()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteSeguimiento/guardar""","""controllers.rrhh.AgentesSeguimientoController.guardarAgenteSeguimiento()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteSeguimiento/editar""","""controllers.rrhh.AgentesSeguimientoController.editarAgenteSeguimiento(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteSeguimiento/actualizar""","""controllers.rrhh.AgentesSeguimientoController.actualizarAgenteSeguimiento(agenteId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteSeguimiento/eliminar""","""controllers.rrhh.AgentesSeguimientoController.eliminarAgenteSeguimiento(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/agenteSeguimiento/cambiarEstado""","""controllers.rrhh.AgentesSeguimientoController.cambiarEstado(idSeguimiento:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/seguimiento-linea/index""","""controllers.rrhh.AgentesSeguimientoLineasController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/seguimiento-linea/crear""","""controllers.rrhh.AgentesSeguimientoLineasController.crear(seguimientoId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/seguimiento-linea/editar""","""controllers.rrhh.AgentesSeguimientoLineasController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/seguimiento-linea/guardar""","""controllers.rrhh.AgentesSeguimientoLineasController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/seguimiento-linea/actualizar""","""controllers.rrhh.AgentesSeguimientoLineasController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rrhh/seguimiento-linea/eliminar""","""controllers.rrhh.AgentesSeguimientoLineasController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delegacion""","""controllers.delegacion.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delegacion/deposito""","""controllers.delegacion.DepositosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delegacion/deposito/crear""","""controllers.delegacion.DepositosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delegacion/deposito/guardar""","""controllers.delegacion.DepositosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delegacion/deposito/editar""","""controllers.delegacion.DepositosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delegacion/deposito/eliminar""","""controllers.delegacion.DepositosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delegacion/deposito/actualizar""","""controllers.delegacion.DepositosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delegacion/deposito/modalBuscar""","""controllers.delegacion.DepositosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delegacion/deposito/get""","""controllers.delegacion.DepositosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto""","""controllers.presupuesto.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario""","""controllers.presupuesto.CreditosPresupuestariosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario/crear""","""controllers.presupuesto.CreditosPresupuestariosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario/guardar""","""controllers.presupuesto.CreditosPresupuestariosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario/editar""","""controllers.presupuesto.CreditosPresupuestariosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario/eliminar""","""controllers.presupuesto.CreditosPresupuestariosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario/actualizar""","""controllers.presupuesto.CreditosPresupuestariosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario/get""","""controllers.presupuesto.CreditosPresupuestariosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario/ver""","""controllers.presupuesto.CreditosPresupuestariosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/aprobar""","""controllers.presupuesto.CreditosPresupuestariosController.aprobar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-listaCargas""","""controllers.presupuesto.CreditosPresupuestariosController.listaCargas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario""","""controllers.presupuesto.CreditosPresupuestariosController.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/credito-presupuestario/reporteListadoCreditos""","""controllers.presupuesto.CreditosPresupuestariosController.reporteListadoCreditos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-credito/index""","""controllers.presupuesto.LineasCreditosPresupuestariosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-credito/crear""","""controllers.presupuesto.LineasCreditosPresupuestariosController.crear(creditoPresupuestarioId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-credito/editar""","""controllers.presupuesto.LineasCreditosPresupuestariosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-credito/guardar""","""controllers.presupuesto.LineasCreditosPresupuestariosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-credito/actualizar""","""controllers.presupuesto.LineasCreditosPresupuestariosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-credito/eliminar""","""controllers.presupuesto.LineasCreditosPresupuestariosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-recurso/index""","""controllers.presupuesto.LineasRecursosPresupuestariosController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-recurso/crear""","""controllers.presupuesto.LineasRecursosPresupuestariosController.crear(creditoPresupuestarioId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-recurso/editar""","""controllers.presupuesto.LineasRecursosPresupuestariosController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-recurso/guardar""","""controllers.presupuesto.LineasRecursosPresupuestariosController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-recurso/actualizar""","""controllers.presupuesto.LineasRecursosPresupuestariosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/linea-recurso/eliminar""","""controllers.presupuesto.LineasRecursosPresupuestariosController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/balance-presupuestario""","""controllers.presupuesto.BalancePresupuestarioController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/balancePresupuestarioPorExpediente""","""controllers.presupuesto.BalancePresupuestarioController.balancePresupuestarioPorExpediente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/reporte/modalReporteBalancePorCuentaPorExpediente""","""controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteBalancePorCuentaPorExpediente(id:Integer ?= 0)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/reporte/reporteBalancePorCuentaPorExpediente""","""controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorCuentaPorExpediente(id:Integer ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/reporte/modalReporteExportarDatosPresupuestoControl""","""controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteExportarDatosPresupuestoControl()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/reporte/reporteExportarDatosPresupuestoControl""","""controllers.presupuesto.BalancePresupuestarioReportesController.reporteExportarDatosPresupuestoControl()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/reporte/reporteBalanceDiferenciaPreventivoDefinitivo""","""controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(idEjercicio:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/modalReporteBalancePorFecha""","""controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteBalancePorFecha()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/reporteBalancePorFecha""","""controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorFecha()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/reporteBalancePorFechaPorExpediente""","""controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorFechaPorExpediente()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/controlAnulacionProductosAutomaticos""","""controllers.presupuesto.ControlPresupuestarioController.controlAnulacionProductosAutomaticos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/controlAnulacionProductosAutomaticosExcel""","""controllers.presupuesto.ControlPresupuestarioController.controlAnulacionProductosAutomaticosExcel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/movimientosSaldoPreventivo""","""controllers.presupuesto.ControlPresupuestarioController.movimientosSaldoPreventivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """presupuesto/movimientosSaldoPreventivoExcel""","""controllers.presupuesto.ControlPresupuestarioController.movimientosSaldoPreventivoExcel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rendiciones""","""controllers.rendiciones.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rendiciones/pagos-realizados""","""controllers.rendiciones.RendicionesController.indexPagosRealizados()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes""","""controllers.haberes.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades""","""controllers.haberes.NovedadesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades/lista""","""controllers.haberes.NovedadesController.lista()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades/ver""","""controllers.haberes.NovedadesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades/crear""","""controllers.haberes.NovedadesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades/guardar""","""controllers.haberes.NovedadesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades/editar""","""controllers.haberes.NovedadesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades/actualizar""","""controllers.haberes.NovedadesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades/eliminar""","""controllers.haberes.NovedadesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades/acciones/crear-masivo""","""controllers.haberes.NovedadesAccionesController.crearMasivo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/novedades/acciones/procesar-masivo""","""controllers.haberes.NovedadesAccionesController.procesarMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales""","""controllers.haberes.PuestosLaboralesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/crear""","""controllers.haberes.PuestosLaboralesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/guardar""","""controllers.haberes.PuestosLaboralesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/editar""","""controllers.haberes.PuestosLaboralesController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborale/eliminar""","""controllers.haberes.PuestosLaboralesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/actualizar""","""controllers.haberes.PuestosLaboralesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/modal-buscar""","""controllers.haberes.PuestosLaboralesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/modal-buscar-todos""","""controllers.haberes.PuestosLaboralesController.modalBuscarTodos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/get""","""controllers.haberes.PuestosLaboralesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/ver""","""controllers.haberes.PuestosLaboralesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/cambiarEstado""","""controllers.haberes.PuestosLaboralesController.cambiarEstado(idPuesto:Long, idEstado:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/acciones/activar""","""controllers.haberes.PuestosLaboralesAccionesController.activar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/acciones/desactivar""","""controllers.haberes.PuestosLaboralesAccionesController.desactivar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/acciones/modalCrearNovedades""","""controllers.haberes.PuestosLaboralesAccionesController.modalCrearNovedades()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/crearNovedades""","""controllers.haberes.PuestosLaboralesAccionesController.crearNovedadesBasicas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/modalPasarABorrador""","""controllers.haberes.PuestosLaboralesAccionesController.modalPasarABorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/pasarABorrador""","""controllers.haberes.PuestosLaboralesAccionesController.pasarABorrador()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/modalPasarAControlado""","""controllers.haberes.PuestosLaboralesAccionesController.modalPasarAControlado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/pasarAControlado""","""controllers.haberes.PuestosLaboralesAccionesController.pasarAControlado()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/liquidarCierre""","""controllers.haberes.PuestosLaboralesController.liquidarCierre(idPuestoLaboral:Long, idLiquidacionMes:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/acciones/modalPreliquidarPuesto""","""controllers.haberes.PuestosLaboralesAccionesController.modalPreliquidarPuesto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/preliquidarPuesto""","""controllers.haberes.PuestosLaboralesAccionesController.preliquidarPuesto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/acciones/modalPreliquidarPuestoFinal""","""controllers.haberes.PuestosLaboralesAccionesController.modalPreliquidarFinalPuesto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/preliquidarPuestoFinal""","""controllers.haberes.PuestosLaboralesAccionesController.preliquidarFinalPuesto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/reportes/alta-masiva""","""controllers.haberes.PuestosLaboralesReportesController.altasMasivas()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/reportes/alta-macrosueldo""","""controllers.haberes.PuestosLaboralesReportesController.altasMacroSueldo(nuevo:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/reportes/descargar-archivo""","""controllers.haberes.PuestosLaboralesReportesController.descargarArchivo(url:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/reportes/listado""","""controllers.haberes.PuestosLaboralesReportesController.listadoPuestosLaborales()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/puestos-laborales/reportes/f649""","""controllers.haberes.PuestosLaboralesReportesController.reportef649()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reportes/formulario649""","""controllers.haberes.PuestosLaboralesReportesController.formulario649(id:Long, ejercicio_id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reportes/formulario649-2019""","""controllers.haberes.PuestosLaboralesReportesController.formulario6492019(id:Long, ejercicio_id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reportes/formulario649-2021""","""controllers.haberes.PuestosLaboralesReportesController.formulario6492021(id:Long, ejercicio_id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reportes/formulario649-2022""","""controllers.haberes.PuestosLaboralesReportesController.formulario6492022(id:Long, ejercicio_id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConcepto""","""controllers.haberes.LiquidacionConceptosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConcepto/crear""","""controllers.haberes.LiquidacionConceptosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConcepto/guardar""","""controllers.haberes.LiquidacionConceptosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConcepto/editar""","""controllers.haberes.LiquidacionConceptosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConcepto/eliminar""","""controllers.haberes.LiquidacionConceptosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConcepto/actualizar""","""controllers.haberes.LiquidacionConceptosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConcepto/modalBuscar""","""controllers.haberes.LiquidacionConceptosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConcepto/get""","""controllers.haberes.LiquidacionConceptosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConcepto/ver""","""controllers.haberes.LiquidacionConceptosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConceptoTipo""","""controllers.haberes.LiquidacionConceptoTiposController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConceptoTipo/crear""","""controllers.haberes.LiquidacionConceptoTiposController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConceptoTipo/guardar""","""controllers.haberes.LiquidacionConceptoTiposController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConceptoTipo/editar""","""controllers.haberes.LiquidacionConceptoTiposController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConceptoTipo/eliminar""","""controllers.haberes.LiquidacionConceptoTiposController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConceptoTipo/actualizar""","""controllers.haberes.LiquidacionConceptoTiposController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConceptoTipo/modalBuscar""","""controllers.haberes.LiquidacionConceptoTiposController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConceptoTipo/get""","""controllers.haberes.LiquidacionConceptoTiposController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionConceptoTipo/ver""","""controllers.haberes.LiquidacionConceptoTiposController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionBaseCalculo""","""controllers.haberes.LiquidacionBaseCalculosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionBaseCalculo/crear""","""controllers.haberes.LiquidacionBaseCalculosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionBaseCalculo/guardar""","""controllers.haberes.LiquidacionBaseCalculosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionBaseCalculo/editar""","""controllers.haberes.LiquidacionBaseCalculosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionBaseCalculo/eliminar""","""controllers.haberes.LiquidacionBaseCalculosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionBaseCalculo/actualizar""","""controllers.haberes.LiquidacionBaseCalculosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionBaseCalculo/modalBuscar""","""controllers.haberes.LiquidacionBaseCalculosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionBaseCalculo/get""","""controllers.haberes.LiquidacionBaseCalculosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionBaseCalculo/ver""","""controllers.haberes.LiquidacionBaseCalculosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionTipo""","""controllers.haberes.LiquidacionTiposController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionTipo/crear""","""controllers.haberes.LiquidacionTiposController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionTipo/guardar""","""controllers.haberes.LiquidacionTiposController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionTipo/editar""","""controllers.haberes.LiquidacionTiposController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionTipo/eliminar""","""controllers.haberes.LiquidacionTiposController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionTipo/actualizar""","""controllers.haberes.LiquidacionTiposController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionTipo/modalBuscar""","""controllers.haberes.LiquidacionTiposController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionTipo/get""","""controllers.haberes.LiquidacionTiposController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionTipo/ver""","""controllers.haberes.LiquidacionTiposController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/unidadLaboral""","""controllers.haberes.UnidadesLaboralesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/unidadLaboral/crear""","""controllers.haberes.UnidadesLaboralesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/unidadLaboral/guardar""","""controllers.haberes.UnidadesLaboralesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/unidadLaboral/editar""","""controllers.haberes.UnidadesLaboralesController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/unidadLaboral/eliminar""","""controllers.haberes.UnidadesLaboralesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/unidadLaboral/actualizar""","""controllers.haberes.UnidadesLaboralesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/unidadLaboral/modalBuscar""","""controllers.haberes.UnidadesLaboralesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/unidadLaboral/get""","""controllers.haberes.UnidadesLaboralesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/unidadLaboral/ver""","""controllers.haberes.UnidadesLaboralesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral""","""controllers.haberes.CategoriasLaboralesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral/crear""","""controllers.haberes.CategoriasLaboralesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral/guardar""","""controllers.haberes.CategoriasLaboralesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral/editar""","""controllers.haberes.CategoriasLaboralesController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral/eliminar""","""controllers.haberes.CategoriasLaboralesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral/actualizar""","""controllers.haberes.CategoriasLaboralesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral/modalBuscar""","""controllers.haberes.CategoriasLaboralesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral/get""","""controllers.haberes.CategoriasLaboralesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral/ver""","""controllers.haberes.CategoriasLaboralesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/categoriaLaboral/suggestCategoriaLaboral/$input<[^/]+>""","""controllers.haberes.CategoriasLaboralesController.suggestCategoriaLaboral(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto""","""controllers.haberes.LiquidacionPuestosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/crear""","""controllers.haberes.LiquidacionPuestosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/guardar""","""controllers.haberes.LiquidacionPuestosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/editar""","""controllers.haberes.LiquidacionPuestosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/eliminar""","""controllers.haberes.LiquidacionPuestosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/actualizar""","""controllers.haberes.LiquidacionPuestosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/modalBuscar""","""controllers.haberes.LiquidacionPuestosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/get""","""controllers.haberes.LiquidacionPuestosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/ver""","""controllers.haberes.LiquidacionPuestosController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/reportes/reciboSueldoPorPuesto""","""controllers.haberes.LiquidacionPuestosReportesController.reciboSueldoPorPuesto(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/reportes/reciboSueldo""","""controllers.haberes.LiquidacionPuestosReportesController.reciboSueldo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/reportes/reciboSueldosByLiquidacionMes""","""controllers.haberes.LiquidacionPuestosReportesController.reciboSueldosByLiquidacionMes(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/cambiarEstado""","""controllers.haberes.LiquidacionPuestosController.cambiarEstado(idLiquidacionPuesto:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/reportes/libroSueldos""","""controllers.haberes.LiquidacionPuestosReportesController.libroSueldos(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/preliquidar""","""controllers.haberes.LiquidacionPuestosController.preLiquidar(idPuestoLaboral:Long, idLiquidacionMes:Long, idLiquidacionPuesto:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/reportes/modalReciboSueldoPorPuestoMail""","""controllers.haberes.LiquidacionPuestosReportesController.modalReciboSueldoPorPuestoMail(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/reportes/enviarReciboPorMail""","""controllers.haberes.LiquidacionPuestosReportesController.enviarReciboPorMail()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/modalPasarAOtraLiquidacion""","""controllers.haberes.LiquidacionPuestosAccionesController.modalPasarAOtraLiquidacion()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/pasarAOtraLiquidacion""","""controllers.haberes.LiquidacionPuestosAccionesController.pasarAOtraLiquidacion()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/modalPasarAprobado""","""controllers.haberes.LiquidacionPuestosAccionesController.modalPasarAprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/pasarEnCursoMasivo""","""controllers.haberes.LiquidacionPuestosAccionesController.pasarAprobadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/modalPasarPreaprobado""","""controllers.haberes.LiquidacionPuestosAccionesController.modalPasarPreaprobado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/pasarPreaprobadoMasivo""","""controllers.haberes.LiquidacionPuestosAccionesController.pasarPreaprobadoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/modalPasarBorrador""","""controllers.haberes.LiquidacionPuestosAccionesController.modalPasarBorrador()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/pasarBorradorMasivo""","""controllers.haberes.LiquidacionPuestosAccionesController.pasarBorradorMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/modalPasarCancelado""","""controllers.haberes.LiquidacionPuestosAccionesController.modalPasarCancelado()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionPuesto/pasarCanceladoMasivo""","""controllers.haberes.LiquidacionPuestosAccionesController.pasarCanceladoMasivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacion-detalle/index""","""controllers.haberes.LiquidacionDetallesController.index(id:Long ?= 0, editable:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacion-detalle/crear""","""controllers.haberes.LiquidacionDetallesController.crear(liquidacionPuestoId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacion-d20301766700etalle/editar""","""controllers.haberes.LiquidacionDetallesController.editar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacion-detalle/guardar""","""controllers.haberes.LiquidacionDetallesController.guardar()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacion-detalle/actualizar""","""controllers.haberes.LiquidacionDetallesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacion-detalle/eliminar""","""controllers.haberes.LiquidacionDetallesController.eliminar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/cargoLaboral""","""controllers.haberes.CargosLaboralesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/cargoLaboral/crear""","""controllers.haberes.CargosLaboralesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/cargoLaboral/guardar""","""controllers.haberes.CargosLaboralesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/cargoLaboral/editar""","""controllers.haberes.CargosLaboralesController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/cargoLaboral/eliminar""","""controllers.haberes.CargosLaboralesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/cargoLaboral/actualizar""","""controllers.haberes.CargosLaboralesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/cargoLaboral/modalBuscar""","""controllers.haberes.CargosLaboralesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/cargoLaboral/get""","""controllers.haberes.CargosLaboralesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/cargoLaboral/ver""","""controllers.haberes.CargosLaboralesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/centroCosto""","""controllers.haberes.CentrosCostosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/centroCosto/crear""","""controllers.haberes.CentrosCostosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/centroCosto/guardar""","""controllers.haberes.CentrosCostosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/centroCosto/editar""","""controllers.haberes.CentrosCostosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/centroCosto/eliminar""","""controllers.haberes.CentrosCostosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/centroCosto/actualizar""","""controllers.haberes.CentrosCostosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/centroCosto/modalBuscar""","""controllers.haberes.CentrosCostosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/centroCosto/get""","""controllers.haberes.CentrosCostosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/centroCosto/ver""","""controllers.haberes.CentrosCostosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral""","""controllers.haberes.EscalasLaboralesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral/crear""","""controllers.haberes.EscalasLaboralesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral/guardar""","""controllers.haberes.EscalasLaboralesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral/editar""","""controllers.haberes.EscalasLaboralesController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral/eliminar""","""controllers.haberes.EscalasLaboralesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral/actualizar""","""controllers.haberes.EscalasLaboralesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral/modalBuscar""","""controllers.haberes.EscalasLaboralesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral/get""","""controllers.haberes.EscalasLaboralesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral/ver""","""controllers.haberes.EscalasLaboralesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboral/suggestEscalaLaboral/$input<[^/]+>""","""controllers.haberes.EscalasLaboralesController.suggestEscalaLaboral(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/convenioBanco""","""controllers.haberes.ConveniosBancosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/convenioBanco/crear""","""controllers.haberes.ConveniosBancosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/convenioBanco/guardar""","""controllers.haberes.ConveniosBancosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/convenioBanco/editar""","""controllers.haberes.ConveniosBancosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/convenioBanco/eliminar""","""controllers.haberes.ConveniosBancosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/convenioBanco/actualizar""","""controllers.haberes.ConveniosBancosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/convenioBanco/modalBuscar""","""controllers.haberes.ConveniosBancosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/convenioBanco/get""","""controllers.haberes.ConveniosBancosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/convenioBanco/ver""","""controllers.haberes.ConveniosBancosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/legajo""","""controllers.haberes.LegajosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/legajo/crear""","""controllers.haberes.LegajosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/legajo/guardar""","""controllers.haberes.LegajosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/legajo/editar""","""controllers.haberes.LegajosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/legajo/eliminar""","""controllers.haberes.LegajosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/legajo/actualizar""","""controllers.haberes.LegajosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/legajo/modalBuscar""","""controllers.haberes.LegajosController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/legajo/get""","""controllers.haberes.LegajosController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/legajo/ver""","""controllers.haberes.LegajosController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/instrumento""","""controllers.haberes.InstrumentosLegalesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/instrumento/crear""","""controllers.haberes.InstrumentosLegalesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/instrumento/guardar""","""controllers.haberes.InstrumentosLegalesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/instrumento/editar""","""controllers.haberes.InstrumentosLegalesController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/instrumento/eliminar""","""controllers.haberes.InstrumentosLegalesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/instrumento/actualizar""","""controllers.haberes.InstrumentosLegalesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/instrumento/modalBuscar""","""controllers.haberes.InstrumentosLegalesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/instrumento/get""","""controllers.haberes.InstrumentosLegalesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/instrumento/ver""","""controllers.haberes.InstrumentosLegalesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes""","""controllers.haberes.LiquidacionMesesController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/crear""","""controllers.haberes.LiquidacionMesesController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/guardar""","""controllers.haberes.LiquidacionMesesController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/editar""","""controllers.haberes.LiquidacionMesesController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/eliminar""","""controllers.haberes.LiquidacionMesesController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/actualizar""","""controllers.haberes.LiquidacionMesesController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/modalBuscar""","""controllers.haberes.LiquidacionMesesController.modalBuscar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/get""","""controllers.haberes.LiquidacionMesesController.get(id:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/ver""","""controllers.haberes.LiquidacionMesesController.ver(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/preliquidar""","""controllers.haberes.LiquidacionMesesController.preliquidar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/totalPorConceptos""","""controllers.haberes.LiquidacionMesesReportesController.totalPorConceptos(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/comparativoCertificacion""","""controllers.haberes.LiquidacionMesesReportesController.comparativoCertificacion(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/listadoSeguroVida""","""controllers.haberes.LiquidacionMesesReportesController.listadoSeguroVida(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/listadoSeguroSepelio""","""controllers.haberes.LiquidacionMesesReportesController.listadoSeguroSepelio(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/listadoJubilacion""","""controllers.haberes.LiquidacionMesesReportesController.listadoJubilacion(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/listadoObraSocial""","""controllers.haberes.LiquidacionMesesReportesController.listadoObraSocial(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/datosGenerales""","""controllers.haberes.LiquidacionMesesReportesController.datosGenerales(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/ordenDePago""","""controllers.haberes.LiquidacionMesesReportesController.ordenDePago(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/controlDescuentosBasicos""","""controllers.haberes.LiquidacionMesesReportesController.controlDescuentosBasicos(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/listadoPorConceptosPorPuestoLaboral""","""controllers.haberes.LiquidacionMesesReportesController.listadoPorConceptosPorPuestoLaboral(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/listadoDePuestoLaboral""","""controllers.haberes.LiquidacionMesesReportesController.listadoDePuestoLaboral(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/listadoGeneral""","""controllers.haberes.LiquidacionMesesReportesController.listadoGeneral(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/listadoDePuestoLaboralComparativoPeriodo""","""controllers.haberes.LiquidacionMesesReportesController.listadoDePuestoLaboralComparativoPeriodo(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/listadoPorEscalaPorPuestoLaboral""","""controllers.haberes.LiquidacionMesesReportesController.listadoPorEscalaPorPuestoLaboral(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/modalDatosAfip""","""controllers.haberes.LiquidacionMesesReportesController.modalDatosAfip()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/reportesDatosAfip""","""controllers.haberes.LiquidacionMesesReportesController.reportesDatosAfip()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/cambiarEstado""","""controllers.haberes.LiquidacionMesesController.cambiarEstado(idLiquidacion:Long, idEstado:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/modalDatosAfipGanancias""","""controllers.haberes.LiquidacionMesesReportesController.modalDatosAfipGanancias()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/reportesDatosAfipGanancias""","""controllers.haberes.LiquidacionMesesReportesController.reportesDatosAfipGanancias()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/modalControlDatosAfipGanancias""","""controllers.haberes.LiquidacionMesesReportesController.modalControlDatosAfipGanancias()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionMes/reportes/reportesControlDatosAfipGanancias""","""controllers.haberes.LiquidacionMesesReportesController.reportesControlDatosAfipGanancias()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionAcciones/exportMacroSueldosLista""","""controllers.haberes.LiquidacionAccionesController.exportMacroSueldosLista(nuevo:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionAcciones/exportMacroSueldos""","""controllers.haberes.LiquidacionAccionesController.exportMacroSueldos(liquidacionId:Long, nuevo:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionAcciones/exportBanco""","""controllers.haberes.LiquidacionAccionesController.exportBanco(liquidacionId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionAcciones/descargarBanco""","""controllers.haberes.LiquidacionAccionesController.descargarBanco(url:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionAcciones/exportAfip""","""controllers.haberes.LiquidacionAccionesController.exportAfip(liquidacionId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionAcciones/descargarAfip""","""controllers.haberes.LiquidacionAccionesController.descargarAfip(url:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionAcciones/exportIps""","""controllers.haberes.LiquidacionAccionesController.exportIps(liquidacionId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionAcciones/descargarIps""","""controllers.haberes.LiquidacionAccionesController.descargarIps(url:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/liquidacionAcciones/exportDatosPorConcepto""","""controllers.haberes.LiquidacionMesesReportesController.exportDatosPorConcepto(liquidacionId:Long, conceptoId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboralMonto""","""controllers.haberes.EscalasLaboralesMontosController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboralMonto/crear""","""controllers.haberes.EscalasLaboralesMontosController.crear()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboralMonto/guardar""","""controllers.haberes.EscalasLaboralesMontosController.guardar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboralMonto/editar""","""controllers.haberes.EscalasLaboralesMontosController.editar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboralMonto/eliminar""","""controllers.haberes.EscalasLaboralesMontosController.eliminar(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboralMonto/actualizar""","""controllers.haberes.EscalasLaboralesMontosController.actualizar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/escalaLaboralMonto/ver""","""controllers.haberes.EscalasLaboralesMontosController.ver(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/gananciasAcciones/buscarDatosGananciasEnArchivos""","""controllers.haberes.GananciasAccionesController.buscarDatosGananciasEnArchivos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/gananciasAcciones/modalBuscarDatosGananciasEnArchivos""","""controllers.haberes.GananciasAccionesController.modalBuscarDatosGananciasEnArchivos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/gananciasAcciones/modalFormularioF649""","""controllers.haberes.GananciasAccionesController.modalFormularioF649()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """haberes/prestaFacil/enviarArchivo""","""controllers.haberes.PrestaFacilController.enviarArchivo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestLiquidacionMes/$input<[^/]+>""","""controllers.haberes.LiquidacionMesesController.suggestLiquidacionMes(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestArticulo/$input<[^/]+>""","""controllers.compras.ArticulosController.suggestArticulo(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestCategoria/$input<[^/]+>""","""controllers.compras.CategoriasController.suggestCategoria(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestTipoProducto/$input<[^/]+>""","""controllers.compras.TipoProductosController.suggestTipoProducto(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestUdm/$input<[^/]+>""","""controllers.compras.ProductosController.suggestUdm(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestIniciador/$input<[^/]+>""","""controllers.expediente.IniciadorExpedientesController.suggestIniciadorExpediente(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestDepartamento/$input<[^/]+>""","""controllers.rrhh.DepartamentosController.suggestDepartamento(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestEspecialidad/$input<[^/]+>""","""controllers.rrhh.EspecialidadesController.suggestEspecialidad(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestProfesion/$input<[^/]+>""","""controllers.rrhh.ProfesionesController.suggestProfesion(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestTipoResidencia/$input<[^/]+>""","""controllers.rrhh.TipoResidenciasController.suggestTipoResidencia(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestPuesto/$input<[^/]+>""","""controllers.rrhh.PuestosController.suggestPuesto(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestLocalidad/$input<[^/]+>""","""controllers.administracion.LocalidadesController.suggestLocalidad(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestAgente/$input<[^/]+>""","""controllers.rrhh.AgentesController.suggestAgente(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestSolicitud/$input<[^/]+>""","""controllers.compras.SolicitudesController.suggestSolicitud(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestOrden/$input<[^/]+>""","""controllers.compras.OrdenesController.suggestOrden(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestProveedor/$input<[^/]+>""","""controllers.compras.ProveedoresController.suggestProveedor(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestDeposito/$input<[^/]+>""","""controllers.delegacion.DepositosController.suggestDeposito(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestCliente/$input<[^/]+>""","""controllers.compras.ClientesController.suggestCliente(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestProducto/$input<[^/]+>""","""controllers.compras.ProductosController.suggestProducto(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestProductoPresupuesto/$input<[^/]+>""","""controllers.compras.ProductosController.suggestProductoPresupuesto(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestExpediente/$input<[^/]+>""","""controllers.expediente.ExpedientesController.suggestExpediente(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestProductoSolicitud/$idDeposito<[^/]+>/$input<[^/]+>""","""controllers.compras.ProductosController.getDataSuggestSolicitud(input:String, idDeposito:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestConcepto/$input<[^/]+>""","""controllers.haberes.LiquidacionConceptosController.suggestLiquidacionConceptoTipo(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestPuestoLaboral/$input<[^/]+>""","""controllers.haberes.PuestosLaboralesController.suggestPuestoLaboral(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestPuestoLaboralTodos/$input<[^/]+>""","""controllers.haberes.PuestosLaboralesController.suggestPuestoLaboralTodos(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestOrganigrama/$input<[^/]+>""","""controllers.administracion.OrganigramasController.suggestOrganigrama(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestOb/$input<[^/]+>""","""controllers.compras.ObrasSocialesController.suggestObrasocial(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestExpedienteCopia/$input<[^/]+>""","""controllers.expediente.ExpedientesController.suggestExpedienteCopia(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suggestCie/$input<[^/]+>""","""controllers.rrhh.CiesController.suggestCie(input:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:7
case routeDashboard_Routes0(handler) => handler
        

// @LINE:8
case routeContabilidad_Routes1(handler) => handler
        

// @LINE:9
case routePatrimonio_Routes2(handler) => handler
        

// @LINE:10
case routeRecupero_Routes3(handler) => handler
        

// @LINE:11
case routeInformes_Routes4(handler) => handler
        

// @LINE:13
case controllers_Application_index5(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:15
case controllers_Authentication_login6(params) => {
   call { 
        invokeHandler(controllers.Authentication.login(), HandlerDef(this, "controllers.Authentication", "login", Nil,"GET", """GET   /reporte             controllers.Reportes.index()""", Routes.prefix + """login"""))
   }
}
        

// @LINE:16
case controllers_Authentication_authenticate7(params) => {
   call { 
        invokeHandler(controllers.Authentication.authenticate(), HandlerDef(this, "controllers.Authentication", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:17
case controllers_Authentication_logout8(params) => {
   call { 
        invokeHandler(controllers.Authentication.logout(), HandlerDef(this, "controllers.Authentication", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:21
case controllers_administracion_OrganigramasController_modalBuscarServicios9(params) => {
   call { 
        invokeHandler(controllers.administracion.OrganigramasController.modalBuscarServicios(), HandlerDef(this, "controllers.administracion.OrganigramasController", "modalBuscarServicios", Nil,"GET", """--
-----------------------------ORGANIGRAMAS------------------------------------------------------------""", Routes.prefix + """administracion/organigrama/modal-buscar-sevicios"""))
   }
}
        

// @LINE:22
case controllers_administracion_OrganigramasController_get10(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.administracion.OrganigramasController.get(id), HandlerDef(this, "controllers.administracion.OrganigramasController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """administracion/organigrama/get"""))
   }
}
        

// @LINE:26
case controllers_administracion_IndexController_index11(params) => {
   call { 
        invokeHandler(controllers.administracion.IndexController.index(), HandlerDef(this, "controllers.administracion.IndexController", "index", Nil,"GET", """-----------------------------MODULO ADMINISTRACION ---------------------------------""", Routes.prefix + """administracion"""))
   }
}
        

// @LINE:27
case controllers_administracion_UsuariosController_index12(params) => {
   call { 
        invokeHandler(controllers.administracion.UsuariosController.index(), HandlerDef(this, "controllers.administracion.UsuariosController", "index", Nil,"GET", """""", Routes.prefix + """administracion/usuarios"""))
   }
}
        

// @LINE:28
case controllers_administracion_UsuariosController_crear13(params) => {
   call { 
        invokeHandler(controllers.administracion.UsuariosController.crear(), HandlerDef(this, "controllers.administracion.UsuariosController", "crear", Nil,"GET", """""", Routes.prefix + """administracion/usuarios/crear"""))
   }
}
        

// @LINE:29
case controllers_administracion_UsuariosController_eliminar14(params) => {
   call(params.fromQuery[Integer]("id", None)) { (id) =>
        invokeHandler(controllers.administracion.UsuariosController.eliminar(id), HandlerDef(this, "controllers.administracion.UsuariosController", "eliminar", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """administracion/usuarios/eliminar"""))
   }
}
        

// @LINE:30
case controllers_administracion_UsuariosController_editar15(params) => {
   call(params.fromQuery[Integer]("id", None)) { (id) =>
        invokeHandler(controllers.administracion.UsuariosController.editar(id), HandlerDef(this, "controllers.administracion.UsuariosController", "editar", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """administracion/usuarios/editar"""))
   }
}
        

// @LINE:31
case controllers_administracion_UsuariosController_actualizar16(params) => {
   call { 
        invokeHandler(controllers.administracion.UsuariosController.actualizar(), HandlerDef(this, "controllers.administracion.UsuariosController", "actualizar", Nil,"POST", """""", Routes.prefix + """administracion/usuarios/actualizar"""))
   }
}
        

// @LINE:32
case controllers_administracion_UsuariosController_guardar17(params) => {
   call { 
        invokeHandler(controllers.administracion.UsuariosController.guardar(), HandlerDef(this, "controllers.administracion.UsuariosController", "guardar", Nil,"POST", """""", Routes.prefix + """administracion/usuarios/guardar"""))
   }
}
        

// @LINE:33
case controllers_administracion_UsuariosController_suggest18(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.administracion.UsuariosController.suggest(input), HandlerDef(this, "controllers.administracion.UsuariosController", "suggest", Seq(classOf[String]),"GET", """""", Routes.prefix + """administracion/usuarios/suggest/$input<[^/]+>"""))
   }
}
        

// @LINE:34
case controllers_administracion_UsuariosController_modalBuscar19(params) => {
   call { 
        invokeHandler(controllers.administracion.UsuariosController.modalBuscar(), HandlerDef(this, "controllers.administracion.UsuariosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """administracion/usuarios/modalBuscar"""))
   }
}
        

// @LINE:35
case controllers_administracion_UsuariosController_get20(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.administracion.UsuariosController.get(id), HandlerDef(this, "controllers.administracion.UsuariosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """administracion/usuarios/get"""))
   }
}
        

// @LINE:36
case controllers_administracion_PermisosController_index21(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.administracion.PermisosController.index(id), HandlerDef(this, "controllers.administracion.PermisosController", "index", Seq(classOf[Int]),"GET", """""", Routes.prefix + """administracion/permisos"""))
   }
}
        

// @LINE:37
case controllers_administracion_PermisosController_asignar22(params) => {
   call { 
        invokeHandler(controllers.administracion.PermisosController.asignar(), HandlerDef(this, "controllers.administracion.PermisosController", "asignar", Nil,"GET", """""", Routes.prefix + """administracion/asignar"""))
   }
}
        

// @LINE:38
case controllers_administracion_PermisosController_desasignar23(params) => {
   call { 
        invokeHandler(controllers.administracion.PermisosController.desasignar(), HandlerDef(this, "controllers.administracion.PermisosController", "desasignar", Nil,"GET", """""", Routes.prefix + """administracion/desasignar"""))
   }
}
        

// @LINE:39
case controllers_administracion_ProvinciasController_listOptions24(params) => {
   call(params.fromQuery[Int]("paisId", Some(0))) { (paisId) =>
        invokeHandler(controllers.administracion.ProvinciasController.listOptions(paisId), HandlerDef(this, "controllers.administracion.ProvinciasController", "listOptions", Seq(classOf[Int]),"GET", """""", Routes.prefix + """administracion/provincias/listOptions"""))
   }
}
        

// @LINE:40
case controllers_administracion_LocalidadesController_listOptions25(params) => {
   call(params.fromQuery[Int]("provinciaId", Some(0))) { (provinciaId) =>
        invokeHandler(controllers.administracion.LocalidadesController.listOptions(provinciaId), HandlerDef(this, "controllers.administracion.LocalidadesController", "listOptions", Seq(classOf[Int]),"GET", """""", Routes.prefix + """administracion/localidades/listOptions"""))
   }
}
        

// @LINE:41
case controllers_administracion_GruposController_index26(params) => {
   call { 
        invokeHandler(controllers.administracion.GruposController.index(), HandlerDef(this, "controllers.administracion.GruposController", "index", Nil,"GET", """""", Routes.prefix + """administracion/grupos"""))
   }
}
        

// @LINE:42
case controllers_administracion_GruposController_crear27(params) => {
   call { 
        invokeHandler(controllers.administracion.GruposController.crear(), HandlerDef(this, "controllers.administracion.GruposController", "crear", Nil,"GET", """""", Routes.prefix + """administracion/grupos/crear"""))
   }
}
        

// @LINE:43
case controllers_administracion_GruposController_eliminar28(params) => {
   call(params.fromQuery[Integer]("id", None)) { (id) =>
        invokeHandler(controllers.administracion.GruposController.eliminar(id), HandlerDef(this, "controllers.administracion.GruposController", "eliminar", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """administracion/grupos/eliminar"""))
   }
}
        

// @LINE:44
case controllers_administracion_GruposController_editar29(params) => {
   call(params.fromQuery[Integer]("id", None)) { (id) =>
        invokeHandler(controllers.administracion.GruposController.editar(id), HandlerDef(this, "controllers.administracion.GruposController", "editar", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """administracion/grupos/editar"""))
   }
}
        

// @LINE:45
case controllers_administracion_GruposController_actualizar30(params) => {
   call { 
        invokeHandler(controllers.administracion.GruposController.actualizar(), HandlerDef(this, "controllers.administracion.GruposController", "actualizar", Nil,"POST", """""", Routes.prefix + """administracion/grupos/actualizar"""))
   }
}
        

// @LINE:46
case controllers_administracion_GruposController_guardar31(params) => {
   call { 
        invokeHandler(controllers.administracion.GruposController.guardar(), HandlerDef(this, "controllers.administracion.GruposController", "guardar", Nil,"POST", """""", Routes.prefix + """administracion/grupos/guardar"""))
   }
}
        

// @LINE:47
case controllers_administracion_GruposController_modalBuscar32(params) => {
   call { 
        invokeHandler(controllers.administracion.GruposController.modalBuscar(), HandlerDef(this, "controllers.administracion.GruposController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """administracion/grupos/modalBuscar"""))
   }
}
        

// @LINE:48
case controllers_administracion_GruposController_get33(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.administracion.GruposController.get(id), HandlerDef(this, "controllers.administracion.GruposController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """administracion/grupos/get"""))
   }
}
        

// @LINE:51
case controllers_administracion_TicketsController_index34(params) => {
   call { 
        invokeHandler(controllers.administracion.TicketsController.index(), HandlerDef(this, "controllers.administracion.TicketsController", "index", Nil,"GET", """""", Routes.prefix + """administracion/tickets"""))
   }
}
        

// @LINE:52
case controllers_administracion_TicketsController_crear35(params) => {
   call { 
        invokeHandler(controllers.administracion.TicketsController.crear(), HandlerDef(this, "controllers.administracion.TicketsController", "crear", Nil,"GET", """""", Routes.prefix + """administracion/tickets/crear"""))
   }
}
        

// @LINE:53
case controllers_administracion_TicketsController_guardar36(params) => {
   call { 
        invokeHandler(controllers.administracion.TicketsController.guardar(), HandlerDef(this, "controllers.administracion.TicketsController", "guardar", Nil,"POST", """""", Routes.prefix + """administracion/tickets/guardar"""))
   }
}
        

// @LINE:54
case controllers_administracion_TicketsController_editar37(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.administracion.TicketsController.editar(id), HandlerDef(this, "controllers.administracion.TicketsController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """administracion/tickets/editar"""))
   }
}
        

// @LINE:55
case controllers_administracion_TicketsController_actualizar38(params) => {
   call { 
        invokeHandler(controllers.administracion.TicketsController.actualizar(), HandlerDef(this, "controllers.administracion.TicketsController", "actualizar", Nil,"POST", """""", Routes.prefix + """administracion/tickets/actualizar"""))
   }
}
        

// @LINE:56
case controllers_administracion_TicketsController_cambiarEstado39(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Long]("estado_id", None)) { (id, estado_id) =>
        invokeHandler(controllers.administracion.TicketsController.cambiarEstado(id, estado_id), HandlerDef(this, "controllers.administracion.TicketsController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """administracion/tickets/cambiarEstado"""))
   }
}
        

// @LINE:57
case controllers_administracion_TicketsController_ver40(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.administracion.TicketsController.ver(id), HandlerDef(this, "controllers.administracion.TicketsController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """administracion/tickets/ver"""))
   }
}
        

// @LINE:58
case controllers_administracion_TicketsController_eliminar41(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.administracion.TicketsController.eliminar(id), HandlerDef(this, "controllers.administracion.TicketsController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """administracion/tickets/eliminar"""))
   }
}
        

// @LINE:65
case controllers_compras_IndexController_index42(params) => {
   call { 
        invokeHandler(controllers.compras.IndexController.index(), HandlerDef(this, "controllers.compras.IndexController", "index", Nil,"GET", """-----------------------------MODULO COMPRAS ---------------------------------""", Routes.prefix + """compras"""))
   }
}
        

// @LINE:66
case controllers_compras_SolicitudesController_index43(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesController.index(), HandlerDef(this, "controllers.compras.SolicitudesController", "index", Nil,"GET", """""", Routes.prefix + """compras/solicitud"""))
   }
}
        

// @LINE:67
case controllers_compras_SolicitudesController_crearSolicitud44(params) => {
   call(params.fromQuery[String]("searchIndex", None)) { (searchIndex) =>
        invokeHandler(controllers.compras.SolicitudesController.crearSolicitud(searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "crearSolicitud", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/solicitud/crear"""))
   }
}
        

// @LINE:68
case controllers_compras_SolicitudesController_guardarSolicitud45(params) => {
   call(params.fromQuery[String]("searchIndex", None)) { (searchIndex) =>
        invokeHandler(controllers.compras.SolicitudesController.guardarSolicitud(searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "guardarSolicitud", Seq(classOf[String]),"POST", """""", Routes.prefix + """compras/solicitud/guardar"""))
   }
}
        

// @LINE:69
case controllers_compras_SolicitudesController_ver46(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[String]("searchIndex", None)) { (id, searchIndex) =>
        invokeHandler(controllers.compras.SolicitudesController.ver(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "ver", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """compras/solicitud/ver"""))
   }
}
        

// @LINE:70
case controllers_compras_SolicitudesController_editar47(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[String]("searchIndex", None)) { (id, searchIndex) =>
        invokeHandler(controllers.compras.SolicitudesController.editar(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "editar", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """compras/solicitud/editar"""))
   }
}
        

// @LINE:71
case controllers_compras_SolicitudesController_duplicar48(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[String]("searchIndex", None)) { (id, searchIndex) =>
        invokeHandler(controllers.compras.SolicitudesController.duplicar(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "duplicar", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """compras/solicitud/duplicar"""))
   }
}
        

// @LINE:72
case controllers_compras_SolicitudesController_eliminar49(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[String]("searchIndex", None)) { (id, searchIndex) =>
        invokeHandler(controllers.compras.SolicitudesController.eliminar(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "eliminar", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """compras/solicitud/eliminar"""))
   }
}
        

// @LINE:73
case controllers_compras_SolicitudesController_actualizar50(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[String]("searchIndex", None)) { (id, searchIndex) =>
        invokeHandler(controllers.compras.SolicitudesController.actualizar(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "actualizar", Seq(classOf[Long], classOf[String]),"POST", """""", Routes.prefix + """compras/solicitud/actualizar"""))
   }
}
        

// @LINE:74
case controllers_compras_SolicitudesController_modificarEntregado51(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.SolicitudesController.modificarEntregado(id), HandlerDef(this, "controllers.compras.SolicitudesController", "modificarEntregado", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/solicitud/modificarEntregado"""))
   }
}
        

// @LINE:75
case controllers_compras_SolicitudesController_cambiarEstado52(params) => {
   call(params.fromQuery[Long]("idSolicitud", None), params.fromQuery[Long]("idEstado", None), params.fromQuery[String]("searchIndex", None)) { (idSolicitud, idEstado, searchIndex) =>
        invokeHandler(controllers.compras.SolicitudesController.cambiarEstado(idSolicitud, idEstado, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "cambiarEstado", Seq(classOf[Long], classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """compras/solicitud/cambiarEstado"""))
   }
}
        

// @LINE:76
case controllers_compras_SolicitudesController_redirectSearchIndex53(params) => {
   call(params.fromQuery[String]("searchIndex", None)) { (searchIndex) =>
        invokeHandler(controllers.compras.SolicitudesController.redirectSearchIndex(searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "redirectSearchIndex", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/solicitud/redirectIndex"""))
   }
}
        

// @LINE:78
case controllers_compras_SolicitudesController_modalEditarCuentaAnalica54(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesController.modalEditarCuentaAnalica(), HandlerDef(this, "controllers.compras.SolicitudesController", "modalEditarCuentaAnalica", Nil,"GET", """""", Routes.prefix + """compras/solicitud/modalEditarCuentaAnalitica"""))
   }
}
        

// @LINE:79
case controllers_compras_SolicitudesController_editarCuentaAnalitica55(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.SolicitudesController", "editarCuentaAnalitica", Nil,"POST", """""", Routes.prefix + """compras/solicitud/editarCuentaAnalitica"""))
   }
}
        

// @LINE:80
case controllers_compras_SolicitudesController_modalBuscar56(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesController.modalBuscar(), HandlerDef(this, "controllers.compras.SolicitudesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """compras/solicitud/modalBuscar"""))
   }
}
        

// @LINE:81
case controllers_compras_SolicitudesController_get57(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.SolicitudesController.get(id), HandlerDef(this, "controllers.compras.SolicitudesController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/solicitud/get"""))
   }
}
        

// @LINE:82
case controllers_compras_SolicitudAccionesController_modalImportarListaProductos58(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudAccionesController.modalImportarListaProductos(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalImportarListaProductos", Nil,"POST", """""", Routes.prefix + """compras/solicitud/modalImportarListaProductos"""))
   }
}
        

// @LINE:83
case controllers_compras_SolicitudAccionesController_importarListaProductos59(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudAccionesController.importarListaProductos(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "importarListaProductos", Nil,"POST", """""", Routes.prefix + """compras/solicitud/importarListaProductos"""))
   }
}
        

// @LINE:84
case controllers_compras_SolicitudAccionesController_modalModificarPaciente60(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.SolicitudAccionesController.modalModificarPaciente(id), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalModificarPaciente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/solicitud/modalModificarPacientes"""))
   }
}
        

// @LINE:85
case controllers_compras_SolicitudAccionesController_modificarPaciente61(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudAccionesController.modificarPaciente(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modificarPaciente", Nil,"POST", """""", Routes.prefix + """compras/solicitud/modificarPaciente"""))
   }
}
        

// @LINE:86
case controllers_compras_SolicitudAccionesController_modalPasarAprobadoPorPresupuesto62(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudAccionesController.modalPasarAprobadoPorPresupuesto(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalPasarAprobadoPorPresupuesto", Nil,"GET", """""", Routes.prefix + """compras/solicitud/modalPasarAprobadoPorPresupuesto"""))
   }
}
        

// @LINE:87
case controllers_compras_SolicitudAccionesController_pasarAprobadoPorPresupuesto63(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudAccionesController.pasarAprobadoPorPresupuesto(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "pasarAprobadoPorPresupuesto", Nil,"POST", """""", Routes.prefix + """compras/solicitud/pasarAprobadoPorPresupuesto"""))
   }
}
        

// @LINE:88
case controllers_compras_SolicitudAccionesController_modalPasarAutorizado64(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudAccionesController.modalPasarAutorizado(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalPasarAutorizado", Nil,"GET", """""", Routes.prefix + """compras/solicitud/modalPasarAutorizado"""))
   }
}
        

// @LINE:89
case controllers_compras_SolicitudAccionesController_pasarAutorizado65(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudAccionesController.pasarAutorizado(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "pasarAutorizado", Nil,"POST", """""", Routes.prefix + """compras/solicitud/pasarAutorizado"""))
   }
}
        

// @LINE:91
case controllers_compras_SolicitudAccionesController_modalAsignarUsuario66(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.SolicitudAccionesController.modalAsignarUsuario(id), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalAsignarUsuario", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/solicitud/modalAsignarUsuario"""))
   }
}
        

// @LINE:92
case controllers_compras_SolicitudAccionesController_asignarUsuario67(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudAccionesController.asignarUsuario(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "asignarUsuario", Nil,"POST", """""", Routes.prefix + """compras/solicitud/asignarUsuario"""))
   }
}
        

// @LINE:94
case controllers_compras_LineasOrdenesController_index68(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.compras.LineasOrdenesController.index(id, editable), HandlerDef(this, "controllers.compras.LineasOrdenesController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/linea-orden/index"""))
   }
}
        

// @LINE:95
case controllers_compras_LineasOrdenesController_crear69(params) => {
   call(params.fromQuery[String]("ordenId", None)) { (ordenId) =>
        invokeHandler(controllers.compras.LineasOrdenesController.crear(ordenId), HandlerDef(this, "controllers.compras.LineasOrdenesController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/linea-orden/crear"""))
   }
}
        

// @LINE:96
case controllers_compras_LineasOrdenesController_editar70(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.LineasOrdenesController.editar(id), HandlerDef(this, "controllers.compras.LineasOrdenesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-orden/editar"""))
   }
}
        

// @LINE:97
case controllers_compras_LineasOrdenesController_guardar71(params) => {
   call { 
        invokeHandler(controllers.compras.LineasOrdenesController.guardar(), HandlerDef(this, "controllers.compras.LineasOrdenesController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/linea-orden/guardar"""))
   }
}
        

// @LINE:98
case controllers_compras_LineasOrdenesController_actualizar72(params) => {
   call { 
        invokeHandler(controllers.compras.LineasOrdenesController.actualizar(), HandlerDef(this, "controllers.compras.LineasOrdenesController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/linea-orden/actualizar"""))
   }
}
        

// @LINE:99
case controllers_compras_LineasOrdenesController_eliminar73(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.LineasOrdenesController.eliminar(id), HandlerDef(this, "controllers.compras.LineasOrdenesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-orden/eliminar"""))
   }
}
        

// @LINE:100
case controllers_compras_LineasOrdenesController_modalAddClientes74(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.LineasOrdenesController.modalAddClientes(id), HandlerDef(this, "controllers.compras.LineasOrdenesController", "modalAddClientes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-orden/modalAddClientes"""))
   }
}
        

// @LINE:101
case controllers_compras_LineasOrdenesController_eliminarMasivo75(params) => {
   call { 
        invokeHandler(controllers.compras.LineasOrdenesController.eliminarMasivo(), HandlerDef(this, "controllers.compras.LineasOrdenesController", "eliminarMasivo", Nil,"POST", """""", Routes.prefix + """compras/linea-orden/eliminar-masivo"""))
   }
}
        

// @LINE:103
case controllers_compras_OrdenesLineasClientesController_guardarAjax76(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesLineasClientesController.guardarAjax(), HandlerDef(this, "controllers.compras.OrdenesLineasClientesController", "guardarAjax", Nil,"POST", """""", Routes.prefix + """compras/linea-orden-cliente/guardarAjax"""))
   }
}
        

// @LINE:104
case controllers_compras_OrdenesLineasClientesController_eliminarAjax77(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesLineasClientesController.eliminarAjax(id), HandlerDef(this, "controllers.compras.OrdenesLineasClientesController", "eliminarAjax", Seq(classOf[Long]),"POST", """""", Routes.prefix + """compras/linea-orden-cliente/eliminarAjax"""))
   }
}
        

// @LINE:106
case controllers_compras_OrdenesReportesController_cuadroComparativoPrecios78(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesReportesController.cuadroComparativoPrecios(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "cuadroComparativoPrecios", Nil,"POST", """""", Routes.prefix + """ordenCompra/reporte/cuadroComparativoPrecios"""))
   }
}
        

// @LINE:107
case controllers_compras_OrdenesReportesController_exportacionDatos79(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesReportesController.exportacionDatos(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "exportacionDatos", Nil,"POST", """""", Routes.prefix + """ordenCompra/reporte/exportacionDatos"""))
   }
}
        

// @LINE:108
case controllers_compras_OrdenesReportesController_exportacionDatosConLineas80(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesReportesController.exportacionDatosConLineas(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "exportacionDatosConLineas", Nil,"POST", """""", Routes.prefix + """ordenCompra/reporte/exportacionDatosConLineas"""))
   }
}
        

// @LINE:109
case controllers_compras_OrdenesReportesController_cuadroSugerenciaAdjudicación81(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesReportesController.cuadroSugerenciaAdjudicación(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "cuadroSugerenciaAdjudicación", Nil,"POST", """""", Routes.prefix + """ordenCompra/reporte/cuadroSugerenciaAdjudicacion"""))
   }
}
        

// @LINE:110
case controllers_compras_OrdenesReportesController_controlDolar82(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesReportesController.controlDolar(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "controlDolar", Nil,"POST", """""", Routes.prefix + """ordenCompra/reporte/controlDolar"""))
   }
}
        

// @LINE:111
case controllers_compras_OrdenesReportesController_reporteCertificacionPaciente83(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesReportesController.reporteCertificacionPaciente(id), HandlerDef(this, "controllers.compras.OrdenesReportesController", "reporteCertificacionPaciente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ordenCompra/reporte/reporteCertificacionPaciente"""))
   }
}
        

// @LINE:112
case controllers_compras_OrdenesReportesController_controlProfe84(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.OrdenesReportesController.controlProfe(id), HandlerDef(this, "controllers.compras.OrdenesReportesController", "controlProfe", Seq(classOf[Long]),"POST", """""", Routes.prefix + """ordenCompra/reporte/controlProfe"""))
   }
}
        

// @LINE:114
case controllers_compras_OrdenesLineasAjustesController_index85(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.compras.OrdenesLineasAjustesController.index(id, editable), HandlerDef(this, "controllers.compras.OrdenesLineasAjustesController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/orden/linea-orden-ajuste/index"""))
   }
}
        

// @LINE:115
case controllers_compras_OrdenesLineasAjustesController_guardar86(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesLineasAjustesController.guardar(), HandlerDef(this, "controllers.compras.OrdenesLineasAjustesController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/orden/linea-orden-ajuste/guardar"""))
   }
}
        

// @LINE:116
case controllers_compras_OrdenesLineasAjustesController_eliminar87(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesLineasAjustesController.eliminar(id), HandlerDef(this, "controllers.compras.OrdenesLineasAjustesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/linea-orden-ajuste/eliminar"""))
   }
}
        

// @LINE:117
case controllers_compras_OrdenesLineasAjustesController_crear88(params) => {
   call(params.fromQuery[String]("ordenId", None)) { (ordenId) =>
        invokeHandler(controllers.compras.OrdenesLineasAjustesController.crear(ordenId), HandlerDef(this, "controllers.compras.OrdenesLineasAjustesController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/orden/linea-orden-ajuste/crear"""))
   }
}
        

// @LINE:119
case controllers_compras_LineasSolicitudesController_index89(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false)), params.fromQuery[Long]("btnEliminar", Some(0))) { (id, editable, btnEliminar) =>
        invokeHandler(controllers.compras.LineasSolicitudesController.index(id, editable, btnEliminar), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "index", Seq(classOf[Long], classOf[Boolean], classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-solicitud/index"""))
   }
}
        

// @LINE:120
case controllers_compras_LineasSolicitudesController_crear90(params) => {
   call(params.fromQuery[String]("solicitudId", None), params.fromQuery[Long]("idDeposito", None)) { (solicitudId, idDeposito) =>
        invokeHandler(controllers.compras.LineasSolicitudesController.crear(solicitudId, idDeposito), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "crear", Seq(classOf[String], classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-solicitud/crear"""))
   }
}
        

// @LINE:121
case controllers_compras_LineasSolicitudesController_editar91(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Long]("idDeposito", Some(0))) { (id, idDeposito) =>
        invokeHandler(controllers.compras.LineasSolicitudesController.editar(id, idDeposito), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "editar", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-solicitud/editar"""))
   }
}
        

// @LINE:122
case controllers_compras_LineasSolicitudesController_guardar92(params) => {
   call { 
        invokeHandler(controllers.compras.LineasSolicitudesController.guardar(), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/linea-solicitud/guardar"""))
   }
}
        

// @LINE:123
case controllers_compras_LineasSolicitudesController_actualizar93(params) => {
   call { 
        invokeHandler(controllers.compras.LineasSolicitudesController.actualizar(), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/linea-solicitud/actualizar"""))
   }
}
        

// @LINE:124
case controllers_compras_LineasSolicitudesController_eliminar94(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.LineasSolicitudesController.eliminar(id), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-solicitud/eliminar"""))
   }
}
        

// @LINE:125
case controllers_compras_LineasSolicitudesController_eliminarMasivo95(params) => {
   call { 
        invokeHandler(controllers.compras.LineasSolicitudesController.eliminarMasivo(), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "eliminarMasivo", Nil,"POST", """""", Routes.prefix + """compras/linea-solicitud/eliminarMasivo"""))
   }
}
        

// @LINE:128
case controllers_compras_AjustesSolicitudesController_index96(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.compras.AjustesSolicitudesController.index(id, editable), HandlerDef(this, "controllers.compras.AjustesSolicitudesController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/ajuste-solicitud/index"""))
   }
}
        

// @LINE:129
case controllers_compras_AjustesSolicitudesController_crear97(params) => {
   call(params.fromQuery[String]("solicitudId", None)) { (solicitudId) =>
        invokeHandler(controllers.compras.AjustesSolicitudesController.crear(solicitudId), HandlerDef(this, "controllers.compras.AjustesSolicitudesController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/ajuste-solicitud/crear"""))
   }
}
        

// @LINE:130
case controllers_compras_AjustesSolicitudesController_guardar98(params) => {
   call { 
        invokeHandler(controllers.compras.AjustesSolicitudesController.guardar(), HandlerDef(this, "controllers.compras.AjustesSolicitudesController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/ajuste-solicitud/guardar"""))
   }
}
        

// @LINE:131
case controllers_compras_AjustesSolicitudesController_eliminar99(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.AjustesSolicitudesController.eliminar(id), HandlerDef(this, "controllers.compras.AjustesSolicitudesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/ajuste-solicitud/eliminar"""))
   }
}
        

// @LINE:133
case controllers_compras_OrdenesController_index100(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesController.index(), HandlerDef(this, "controllers.compras.OrdenesController", "index", Nil,"GET", """""", Routes.prefix + """compras/orden"""))
   }
}
        

// @LINE:134
case controllers_compras_OrdenesController_crear101(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesController.crear(), HandlerDef(this, "controllers.compras.OrdenesController", "crear", Nil,"GET", """""", Routes.prefix + """compras/orden/crear"""))
   }
}
        

// @LINE:135
case controllers_compras_OrdenesController_guardar102(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesController.guardar(), HandlerDef(this, "controllers.compras.OrdenesController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/orden/guardar"""))
   }
}
        

// @LINE:136
case controllers_compras_OrdenesController_editar103(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesController.editar(id), HandlerDef(this, "controllers.compras.OrdenesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/editar"""))
   }
}
        

// @LINE:137
case controllers_compras_OrdenesController_eliminar104(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesController.eliminar(id), HandlerDef(this, "controllers.compras.OrdenesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/eliminar"""))
   }
}
        

// @LINE:138
case controllers_compras_OrdenesController_duplicar105(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesController.duplicar(id), HandlerDef(this, "controllers.compras.OrdenesController", "duplicar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/duplicar"""))
   }
}
        

// @LINE:139
case controllers_compras_OrdenesController_actualizar106(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesController.actualizar(id), HandlerDef(this, "controllers.compras.OrdenesController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """compras/orden/actualizar"""))
   }
}
        

// @LINE:140
case controllers_compras_OrdenesAccionesController_modalImportarListaProductos107(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.modalImportarListaProductos(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalImportarListaProductos", Nil,"POST", """""", Routes.prefix + """compras/orden/modalImportarListaProductos"""))
   }
}
        

// @LINE:141
case controllers_compras_OrdenesAccionesController_importarListaProductos108(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.importarListaProductos(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "importarListaProductos", Nil,"POST", """""", Routes.prefix + """compras/orden/importarListaProductos"""))
   }
}
        

// @LINE:143
case controllers_compras_OrdenesController_ver109(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesController.ver(id), HandlerDef(this, "controllers.compras.OrdenesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/ver"""))
   }
}
        

// @LINE:144
case controllers_compras_OrdenesController_modalEditarCuentaAnalica110(params) => {
   call(params.fromQuery[String]("tipo", None)) { (tipo) =>
        invokeHandler(controllers.compras.OrdenesController.modalEditarCuentaAnalica(tipo), HandlerDef(this, "controllers.compras.OrdenesController", "modalEditarCuentaAnalica", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/orden/modalEditarCuentaAnalitica"""))
   }
}
        

// @LINE:145
case controllers_compras_OrdenesController_editarCuentaAnalitica111(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.OrdenesController", "editarCuentaAnalitica", Nil,"POST", """""", Routes.prefix + """compras/orden/editarCuentaAnalitica"""))
   }
}
        

// @LINE:146
case controllers_compras_OrdenesController_cambiarEstado112(params) => {
   call(params.fromQuery[Long]("idOrden", None), params.fromQuery[Long]("idEstado", None)) { (idOrden, idEstado) =>
        invokeHandler(controllers.compras.OrdenesController.cambiarEstado(idOrden, idEstado), HandlerDef(this, "controllers.compras.OrdenesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/cambiarEstado"""))
   }
}
        

// @LINE:147
case controllers_compras_OrdenesController_modalBuscar113(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesController.modalBuscar(), HandlerDef(this, "controllers.compras.OrdenesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """compras/orden/modalBuscar"""))
   }
}
        

// @LINE:148
case controllers_compras_OrdenesController_get114(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.OrdenesController.get(id), HandlerDef(this, "controllers.compras.OrdenesController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/get"""))
   }
}
        

// @LINE:150
case controllers_compras_OrdenesAccionesController_modalEditarMontoAdelanto115(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesAccionesController.modalEditarMontoAdelanto(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalEditarMontoAdelanto", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/modalEditarMontoAdelanto"""))
   }
}
        

// @LINE:151
case controllers_compras_OrdenesAccionesController_editarMontoAdelanto116(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.editarMontoAdelanto(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "editarMontoAdelanto", Nil,"GET", """""", Routes.prefix + """compras/orden/editarMontoAdelanto"""))
   }
}
        

// @LINE:152
case controllers_compras_OrdenesAccionesController_modalEditarCotDolar117(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesAccionesController.modalEditarCotDolar(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalEditarCotDolar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/modalEditarCotDolar"""))
   }
}
        

// @LINE:153
case controllers_compras_OrdenesAccionesController_editarCotDolar118(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.editarCotDolar(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "editarCotDolar", Nil,"GET", """""", Routes.prefix + """compras/orden/editarCotDolar"""))
   }
}
        

// @LINE:154
case controllers_compras_OrdenesAccionesController_modalEditarFechaProvision119(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesAccionesController.modalEditarFechaProvision(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalEditarFechaProvision", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/modalEditarFechaProvision"""))
   }
}
        

// @LINE:155
case controllers_compras_OrdenesAccionesController_editarFechaProvision120(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.editarFechaProvision(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "editarFechaProvision", Nil,"GET", """""", Routes.prefix + """compras/orden/editarFechaProvision"""))
   }
}
        

// @LINE:156
case controllers_compras_OrdenesAccionesController_modalEditarRubro121(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesAccionesController.modalEditarRubro(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalEditarRubro", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/modalEditarRubro"""))
   }
}
        

// @LINE:157
case controllers_compras_OrdenesAccionesController_editarRubro122(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.editarRubro(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "editarRubro", Nil,"GET", """""", Routes.prefix + """compras/orden/editarRubro"""))
   }
}
        

// @LINE:158
case controllers_compras_OrdenesAccionesController_modalOrdenMail123(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesAccionesController.modalOrdenMail(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalOrdenMail", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/modalOrdenMail"""))
   }
}
        

// @LINE:159
case controllers_compras_OrdenesAccionesController_enviarOrdenMail124(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.enviarOrdenMail(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "enviarOrdenMail", Nil,"POST", """""", Routes.prefix + """compras/orden/enviarOrdenMail"""))
   }
}
        

// @LINE:160
case controllers_compras_OrdenSubrubroController_listOptions125(params) => {
   call(params.fromQuery[Int]("rubroId", Some(0))) { (rubroId) =>
        invokeHandler(controllers.compras.OrdenSubrubroController.listOptions(rubroId), HandlerDef(this, "controllers.compras.OrdenSubrubroController", "listOptions", Seq(classOf[Int]),"GET", """""", Routes.prefix + """compras/ordenSubrubro/listOptions"""))
   }
}
        

// @LINE:161
case controllers_compras_OrdenesAccionesController_modalCrearDispo126(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesAccionesController.modalCrearDispo(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalCrearDispo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/orden/modalCrearDispo"""))
   }
}
        

// @LINE:162
case controllers_compras_OrdenesAccionesController_crearDispo127(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.crearDispo(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "crearDispo", Nil,"GET", """""", Routes.prefix + """compras/orden/crearDispo"""))
   }
}
        

// @LINE:164
case controllers_compras_CertificacionesController_index128(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesController.index(), HandlerDef(this, "controllers.compras.CertificacionesController", "index", Nil,"GET", """""", Routes.prefix + """compras/certificacion"""))
   }
}
        

// @LINE:165
case controllers_compras_CertificacionesController_crear129(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesController.crear(), HandlerDef(this, "controllers.compras.CertificacionesController", "crear", Nil,"GET", """""", Routes.prefix + """compras/certificacion/crear"""))
   }
}
        

// @LINE:166
case controllers_compras_CertificacionesController_guardar130(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/certificacion/guardar"""))
   }
}
        

// @LINE:167
case controllers_compras_CertificacionesController_editar131(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion/editar"""))
   }
}
        

// @LINE:168
case controllers_compras_CertificacionesController_eliminar132(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion/eliminar"""))
   }
}
        

// @LINE:169
case controllers_compras_CertificacionesController_ver133(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesController.ver(id), HandlerDef(this, "controllers.compras.CertificacionesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion/ver"""))
   }
}
        

// @LINE:170
case controllers_compras_CertificacionesController_duplicar134(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesController.duplicar(id), HandlerDef(this, "controllers.compras.CertificacionesController", "duplicar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion/duplicar"""))
   }
}
        

// @LINE:171
case controllers_compras_CertificacionesController_actualizar135(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesController.actualizar(id), HandlerDef(this, "controllers.compras.CertificacionesController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """compras/certificacion/actualizar"""))
   }
}
        

// @LINE:172
case controllers_compras_CertificacionesController_cambiarEstado136(params) => {
   call(params.fromQuery[Long]("idCertificacion", None), params.fromQuery[Long]("idEstado", None)) { (idCertificacion, idEstado) =>
        invokeHandler(controllers.compras.CertificacionesController.cambiarEstado(idCertificacion, idEstado), HandlerDef(this, "controllers.compras.CertificacionesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion/cambiarEstado"""))
   }
}
        

// @LINE:173
case controllers_compras_CertificacionesController_modalEditarCuentaAnalica137(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesController.modalEditarCuentaAnalica(), HandlerDef(this, "controllers.compras.CertificacionesController", "modalEditarCuentaAnalica", Nil,"GET", """""", Routes.prefix + """compras/certificacion/modalEditarCuentaAnalitica"""))
   }
}
        

// @LINE:174
case controllers_compras_CertificacionesController_editarCuentaAnalitica138(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.CertificacionesController", "editarCuentaAnalitica", Nil,"POST", """""", Routes.prefix + """compras/certificacion/editarCuentaAnalitica"""))
   }
}
        

// @LINE:175
case controllers_compras_CertificacionesAccionesController_modalPasarEnCurso139(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalPasarEnCurso(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarEnCurso", Nil,"GET", """""", Routes.prefix + """compras/certificacion/modalPasarEnCurso"""))
   }
}
        

// @LINE:176
case controllers_compras_CertificacionesAccionesController_pasarEnCursoMasivo140(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.pasarEnCursoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarEnCursoMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion/pasarEnCursoMasivo"""))
   }
}
        

// @LINE:177
case controllers_compras_CertificacionesAccionesController_modalPasarCertificado141(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalPasarCertificado(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarCertificado", Nil,"GET", """""", Routes.prefix + """compras/certificacion/modalPasarCertificado"""))
   }
}
        

// @LINE:178
case controllers_compras_CertificacionesAccionesController_pasarCertificadoMasivo142(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.pasarCertificadoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarCertificadoMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion/pasarCertificadoMasivo"""))
   }
}
        

// @LINE:179
case controllers_compras_CertificacionesAccionesController_modalPasarAprobado143(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalPasarAprobado(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarAprobado", Nil,"GET", """""", Routes.prefix + """compras/certificacion/modalPasarAprobado"""))
   }
}
        

// @LINE:180
case controllers_compras_CertificacionesAccionesController_pasarAprobadoMasivo144(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.pasarAprobadoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarAprobadoMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion/pasarAprobadoMasivo"""))
   }
}
        

// @LINE:181
case controllers_compras_CertificacionesAccionesController_modalPasarBorrador145(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarBorrador", Nil,"GET", """""", Routes.prefix + """compras/certificacion/modalPasarBorrador"""))
   }
}
        

// @LINE:182
case controllers_compras_CertificacionesAccionesController_pasarBorradorMasivo146(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarBorradorMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion/pasarBorradorMasivo"""))
   }
}
        

// @LINE:183
case controllers_compras_CertificacionesAccionesController_modalPasarCancelado147(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarCancelado", Nil,"GET", """""", Routes.prefix + """compras/certificacion/modalPasarCancelado"""))
   }
}
        

// @LINE:184
case controllers_compras_CertificacionesAccionesController_pasarCanceladoMasivo148(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarCanceladoMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion/pasarCanceladoMasivo"""))
   }
}
        

// @LINE:185
case controllers_compras_CertificacionesAccionesController_modalEditarFechaCertificacion149(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalEditarFechaCertificacion(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalEditarFechaCertificacion", Nil,"GET", """""", Routes.prefix + """compras/certificacion/modalEditarFechaCertificacion"""))
   }
}
        

// @LINE:186
case controllers_compras_CertificacionesAccionesController_editarFechaCertificacionMasivo150(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.editarFechaCertificacionMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "editarFechaCertificacionMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion/editarFechaCertificacionMasivo"""))
   }
}
        

// @LINE:187
case controllers_compras_CertificacionesReportesController_reporteTasas151(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesReportesController.reporteTasas(), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "reporteTasas", Nil,"POST", """""", Routes.prefix + """compras/reporteTasa"""))
   }
}
        

// @LINE:188
case controllers_compras_CertificacionesReportesController_reporteElevaciones152(params) => {
   call(params.fromQuery[Boolean]("desc", None)) { (desc) =>
        invokeHandler(controllers.compras.CertificacionesReportesController.reporteElevaciones(desc), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "reporteElevaciones", Seq(classOf[Boolean]),"POST", """""", Routes.prefix + """compras/reporteElevaciones"""))
   }
}
        

// @LINE:189
case controllers_compras_CertificacionesReportesController_bajas153(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesReportesController.bajas(), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "bajas", Nil,"POST", """""", Routes.prefix + """compras/certificacion/reportes/bajas"""))
   }
}
        

// @LINE:190
case controllers_compras_CertificacionesAccionesController_modalDuplicarMasivo154(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalDuplicarMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalDuplicarMasivo", Nil,"GET", """""", Routes.prefix + """compras/certificacion/modalDuplicarMasivo"""))
   }
}
        

// @LINE:191
case controllers_compras_CertificacionesAccionesController_duplicarMasivo155(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.duplicarMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "duplicarMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion/duplicarMasivo"""))
   }
}
        

// @LINE:192
case controllers_compras_CertificacionesAccionesController_modalCrearAguinaldo156(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalCrearAguinaldo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalCrearAguinaldo", Nil,"GET", """""", Routes.prefix + """compras/certificacion/modalCrearAguinaldo"""))
   }
}
        

// @LINE:193
case controllers_compras_CertificacionesAccionesController_crearAguinaldo157(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesAccionesController.crearAguinaldo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "crearAguinaldo", Nil,"POST", """""", Routes.prefix + """compras/certificacion/CrearAguinaldo"""))
   }
}
        

// @LINE:194
case controllers_compras_CertificacionesReportesController_reportePlanillaSueldos158(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesReportesController.reportePlanillaSueldos(), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "reportePlanillaSueldos", Nil,"POST", """""", Routes.prefix + """compras/reportePlanilla"""))
   }
}
        

// @LINE:195
case controllers_compras_CertificacionesAccionesController_modalDetalleCertificacion159(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalDetalleCertificacion(id), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalDetalleCertificacion", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion/modalDetalleCertificacion"""))
   }
}
        

// @LINE:196
case controllers_compras_CertificacionesAccionesController_modalDetalleCertificacionesPorEstadoPorPeriodo160(params) => {
   call(params.fromQuery[String]("nombrePeriodo", None), params.fromQuery[Integer]("estado", None), params.fromQuery[Integer]("proveedorId", None)) { (nombrePeriodo, estado, proveedorId) =>
        invokeHandler(controllers.compras.CertificacionesAccionesController.modalDetalleCertificacionesPorEstadoPorPeriodo(nombrePeriodo, estado, proveedorId), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalDetalleCertificacionesPorEstadoPorPeriodo", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """compras/certificacion/modalDetalleCertificacionesPorEstadoPorPeriodo"""))
   }
}
        

// @LINE:198
case controllers_compras_LineasCertificacionesController_index161(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.compras.LineasCertificacionesController.index(id, editable), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/certificacion-linea/index"""))
   }
}
        

// @LINE:199
case controllers_compras_LineasCertificacionesController_crear162(params) => {
   call(params.fromQuery[String]("certificacionId", None)) { (certificacionId) =>
        invokeHandler(controllers.compras.LineasCertificacionesController.crear(certificacionId), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/certificacion-linea/crear"""))
   }
}
        

// @LINE:200
case controllers_compras_LineasCertificacionesController_editar163(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.LineasCertificacionesController.editar(id), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-linea/editar"""))
   }
}
        

// @LINE:201
case controllers_compras_LineasCertificacionesController_guardar164(params) => {
   call { 
        invokeHandler(controllers.compras.LineasCertificacionesController.guardar(), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/certificacion-linea/guardar"""))
   }
}
        

// @LINE:202
case controllers_compras_LineasCertificacionesController_actualizar165(params) => {
   call { 
        invokeHandler(controllers.compras.LineasCertificacionesController.actualizar(), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/certificacion-linea/actualizar"""))
   }
}
        

// @LINE:203
case controllers_compras_LineasCertificacionesController_eliminar166(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.LineasCertificacionesController.eliminar(id), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-linea/eliminar"""))
   }
}
        

// @LINE:205
case controllers_compras_CertificacionesComprasLineaAjustesController_index167(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.compras.CertificacionesComprasLineaAjustesController.index(id, editable), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/certificacion-linea-ajuste/index"""))
   }
}
        

// @LINE:206
case controllers_compras_CertificacionesComprasLineaAjustesController_crear168(params) => {
   call(params.fromQuery[String]("certificacionId", None)) { (certificacionId) =>
        invokeHandler(controllers.compras.CertificacionesComprasLineaAjustesController.crear(certificacionId), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/certificacion-linea-ajuste/crear"""))
   }
}
        

// @LINE:207
case controllers_compras_CertificacionesComprasLineaAjustesController_editar169(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesComprasLineaAjustesController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-linea-ajuste/editar"""))
   }
}
        

// @LINE:208
case controllers_compras_CertificacionesComprasLineaAjustesController_guardar170(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasLineaAjustesController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/certificacion-linea-ajuste/guardar"""))
   }
}
        

// @LINE:210
case controllers_compras_CertificacionesComprasLineaAjustesController_actualizar171(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasLineaAjustesController.actualizar(), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/certificacion-linea-ajuste/actualizar"""))
   }
}
        

// @LINE:211
case controllers_compras_CertificacionesComprasLineaAjustesController_eliminar172(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesComprasLineaAjustesController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-linea-ajuste/eliminar"""))
   }
}
        

// @LINE:213
case controllers_compras_CertificacionesReportesController_reporteCertificacion173(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesReportesController.reporteCertificacion(), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "reporteCertificacion", Nil,"POST", """""", Routes.prefix + """compras/certificaciones/reporteCertificacion"""))
   }
}
        

// @LINE:215
case controllers_compras_CertificacionesController_crearMasivo174(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesController.crearMasivo(), HandlerDef(this, "controllers.compras.CertificacionesController", "crearMasivo", Nil,"GET", """""", Routes.prefix + """compras/certificaciones/acciones/crear-masivo"""))
   }
}
        

// @LINE:216
case controllers_compras_CertificacionesController_procesarMasivo175(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesController.procesarMasivo(), HandlerDef(this, "controllers.compras.CertificacionesController", "procesarMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificaciones/acciones/procesar-masivo"""))
   }
}
        

// @LINE:218
case controllers_compras_SolicitudesReportesController_reporteImputacionPreventivaLista176(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesReportesController.reporteImputacionPreventivaLista(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reporteImputacionPreventivaLista", Nil,"POST", """""", Routes.prefix + """compras/solicitud/reporte/imputacionPreventiva"""))
   }
}
        

// @LINE:219
case controllers_compras_OrdenesReportesController_reporteImputacionDefinitivaGlobal177(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesReportesController.reporteImputacionDefinitivaGlobal(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "reporteImputacionDefinitivaGlobal", Nil,"POST", """""", Routes.prefix + """compras/orden/reporte/imputacionDefinitiva"""))
   }
}
        

// @LINE:220
case controllers_compras_SolicitudesReportesController_reporteCuadroSolicitud178(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesReportesController.reporteCuadroSolicitud(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reporteCuadroSolicitud", Nil,"POST", """""", Routes.prefix + """compras/solicitud/reporte/cuadroSolicitud"""))
   }
}
        

// @LINE:221
case controllers_compras_SolicitudesReportesController_reporteLineasCotizacion179(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.SolicitudesReportesController.reporteLineasCotizacion(id), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reporteLineasCotizacion", Seq(classOf[Long]),"POST", """""", Routes.prefix + """compras/solicitud/reporte/lineasCotizacion"""))
   }
}
        

// @LINE:222
case controllers_compras_OrdenesReportesController_listadoLineas180(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesReportesController.listadoLineas(id), HandlerDef(this, "controllers.compras.OrdenesReportesController", "listadoLineas", Seq(classOf[Long]),"GET", """""", Routes.prefix + """orden/reporte/listadoLineas"""))
   }
}
        

// @LINE:223
case controllers_compras_OrdenesReportesController_reporteImputacionDefinitiva181(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.OrdenesReportesController.reporteImputacionDefinitiva(id), HandlerDef(this, "controllers.compras.OrdenesReportesController", "reporteImputacionDefinitiva", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/reporte/imputacionDefinitiva"""))
   }
}
        

// @LINE:225
case controllers_compras_SolicitudesReportesController_modalInformeFarmacia182(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesReportesController.modalInformeFarmacia(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "modalInformeFarmacia", Nil,"POST", """""", Routes.prefix + """compras/solicitud/reporte/modalInformeFarmacia"""))
   }
}
        

// @LINE:226
case controllers_compras_SolicitudesReportesController_informeFarmacia183(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesReportesController.informeFarmacia(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "informeFarmacia", Nil,"POST", """""", Routes.prefix + """compras/solicitud/reporte/informeFarmacia"""))
   }
}
        

// @LINE:227
case controllers_compras_SolicitudesReportesController_modalInformeFarmaciaPorUsuario184(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesReportesController.modalInformeFarmaciaPorUsuario(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "modalInformeFarmaciaPorUsuario", Nil,"POST", """""", Routes.prefix + """compras/solicitud/reporte/modalInformeFarmaciaPorUsuario"""))
   }
}
        

// @LINE:228
case controllers_compras_SolicitudesReportesController_informeFarmaciaPorUsuario185(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesReportesController.informeFarmaciaPorUsuario(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "informeFarmaciaPorUsuario", Nil,"POST", """""", Routes.prefix + """compras/solicitud/reporte/informeFarmaciaPorUsuario"""))
   }
}
        

// @LINE:231
case controllers_compras_SolicitudesReportesController_informeFarmaciaPaciente186(params) => {
   call { 
        invokeHandler(controllers.compras.SolicitudesReportesController.informeFarmaciaPaciente(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "informeFarmaciaPaciente", Nil,"POST", """""", Routes.prefix + """compras/solicitud/reporte/informeFarmaciaPaciente"""))
   }
}
        

// @LINE:233
case controllers_compras_PedidosFondosController_index187(params) => {
   call { 
        invokeHandler(controllers.compras.PedidosFondosController.index(), HandlerDef(this, "controllers.compras.PedidosFondosController", "index", Nil,"GET", """""", Routes.prefix + """compras/pedidoFondo"""))
   }
}
        

// @LINE:234
case controllers_compras_PedidosFondosController_crear188(params) => {
   call { 
        invokeHandler(controllers.compras.PedidosFondosController.crear(), HandlerDef(this, "controllers.compras.PedidosFondosController", "crear", Nil,"GET", """""", Routes.prefix + """compras/pedidoFondo/crear"""))
   }
}
        

// @LINE:235
case controllers_compras_PedidosFondosController_guardar189(params) => {
   call { 
        invokeHandler(controllers.compras.PedidosFondosController.guardar(), HandlerDef(this, "controllers.compras.PedidosFondosController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/pedidoFondo/guardar"""))
   }
}
        

// @LINE:236
case controllers_compras_PedidosFondosController_editar190(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.PedidosFondosController.editar(id), HandlerDef(this, "controllers.compras.PedidosFondosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/pedidoFondo/editar"""))
   }
}
        

// @LINE:237
case controllers_compras_PedidosFondosController_eliminar191(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.PedidosFondosController.eliminar(id), HandlerDef(this, "controllers.compras.PedidosFondosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/pedidoFondo/eliminar"""))
   }
}
        

// @LINE:238
case controllers_compras_PedidosFondosController_ver192(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.PedidosFondosController.ver(id), HandlerDef(this, "controllers.compras.PedidosFondosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/pedidoFondo/ver"""))
   }
}
        

// @LINE:239
case controllers_compras_PedidosFondosController_actualizar193(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.PedidosFondosController.actualizar(id), HandlerDef(this, "controllers.compras.PedidosFondosController", "actualizar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/pedidoFondo/actualizar"""))
   }
}
        

// @LINE:240
case controllers_compras_LineasPedidosFondosController_index194(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.compras.LineasPedidosFondosController.index(id, editable), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/pedido-fondo-linea/index"""))
   }
}
        

// @LINE:241
case controllers_compras_LineasPedidosFondosController_crear195(params) => {
   call(params.fromQuery[String]("pedidoFondoId", None)) { (pedidoFondoId) =>
        invokeHandler(controllers.compras.LineasPedidosFondosController.crear(pedidoFondoId), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/pedido-fondo-linea/crear"""))
   }
}
        

// @LINE:242
case controllers_compras_LineasPedidosFondosController_editar196(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.LineasPedidosFondosController.editar(id), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/pedido-fondo-linea/editar"""))
   }
}
        

// @LINE:243
case controllers_compras_LineasPedidosFondosController_guardar197(params) => {
   call { 
        invokeHandler(controllers.compras.LineasPedidosFondosController.guardar(), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/pedido-fondo-linea/guardar"""))
   }
}
        

// @LINE:244
case controllers_compras_LineasPedidosFondosController_actualizar198(params) => {
   call { 
        invokeHandler(controllers.compras.LineasPedidosFondosController.actualizar(), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/pedido-fondo-linea/actualizar"""))
   }
}
        

// @LINE:245
case controllers_compras_LineasPedidosFondosController_eliminar199(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.LineasPedidosFondosController.eliminar(id), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/pedido-fondo-linea/eliminar"""))
   }
}
        

// @LINE:247
case controllers_compras_OrdenesAccionesController_combinar200(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.combinar(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "combinar", Nil,"POST", """""", Routes.prefix + """compras/acciones/combinar"""))
   }
}
        

// @LINE:248
case controllers_compras_OrdenesAccionesController_generarOrdenSegunCuadroSugerenia201(params) => {
   call { 
        invokeHandler(controllers.compras.OrdenesAccionesController.generarOrdenSegunCuadroSugerenia(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "generarOrdenSegunCuadroSugerenia", Nil,"POST", """""", Routes.prefix + """compras/acciones/generarOrdenSegunCuadroSugerenia"""))
   }
}
        

// @LINE:249
case controllers_compras_SolicitudesReportesController_reportePedidoAbastecimiento202(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.SolicitudesReportesController.reportePedidoAbastecimiento(id), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reportePedidoAbastecimiento", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/reporte/reportePedidoAbastecimiento"""))
   }
}
        

// @LINE:250
case controllers_compras_SolicitudesReportesController_reporteImputacionPreventiva203(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.SolicitudesReportesController.reporteImputacionPreventiva(id), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reporteImputacionPreventiva", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/reporte/imputacionPreventiva"""))
   }
}
        

// @LINE:252
case controllers_compras_ProveedoresController_index204(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedoresController.index(), HandlerDef(this, "controllers.compras.ProveedoresController", "index", Nil,"GET", """""", Routes.prefix + """compras/proveedores"""))
   }
}
        

// @LINE:253
case controllers_compras_ProveedoresController_crear205(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedoresController.crear(), HandlerDef(this, "controllers.compras.ProveedoresController", "crear", Nil,"GET", """""", Routes.prefix + """compras/proveedores/crear"""))
   }
}
        

// @LINE:255
case controllers_compras_ProveedoresController_guardar206(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedoresController.guardar(), HandlerDef(this, "controllers.compras.ProveedoresController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/proveedores/guardar"""))
   }
}
        

// @LINE:256
case controllers_compras_ProveedoresController_eliminar207(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProveedoresController.eliminar(id), HandlerDef(this, "controllers.compras.ProveedoresController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/proveedores/eliminar"""))
   }
}
        

// @LINE:257
case controllers_compras_ProveedoresController_eliminarContacto208(params) => {
   call(params.fromQuery[Long]("sid", None), params.fromQuery[Long]("cId", None)) { (sid, cId) =>
        invokeHandler(controllers.compras.ProveedoresController.eliminarContacto(sid, cId), HandlerDef(this, "controllers.compras.ProveedoresController", "eliminarContacto", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/proveedores/eliminarContacto"""))
   }
}
        

// @LINE:258
case controllers_compras_ProveedoresController_editar209(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProveedoresController.editar(id), HandlerDef(this, "controllers.compras.ProveedoresController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/proveedores/editar"""))
   }
}
        

// @LINE:259
case controllers_compras_ProveedoresController_formularioContacto210(params) => {
   call(params.fromQuery[Long]("proveedorId", None), params.fromQuery[Long]("id", Some(0))) { (proveedorId, id) =>
        invokeHandler(controllers.compras.ProveedoresController.formularioContacto(proveedorId, id), HandlerDef(this, "controllers.compras.ProveedoresController", "formularioContacto", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/proveedores/editarContacto"""))
   }
}
        

// @LINE:260
case controllers_compras_ProveedoresController_actualizarContacto211(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedoresController.actualizarContacto(), HandlerDef(this, "controllers.compras.ProveedoresController", "actualizarContacto", Nil,"POST", """""", Routes.prefix + """compras/proveedores/actualizarContacto"""))
   }
}
        

// @LINE:261
case controllers_compras_ProveedoresController_guardarContacto212(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedoresController.guardarContacto(), HandlerDef(this, "controllers.compras.ProveedoresController", "guardarContacto", Nil,"POST", """""", Routes.prefix + """compras/proveedores/guardarContacto"""))
   }
}
        

// @LINE:262
case controllers_compras_ProveedoresController_actualizar213(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedoresController.actualizar(), HandlerDef(this, "controllers.compras.ProveedoresController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/proveedores/actualizar"""))
   }
}
        

// @LINE:263
case controllers_compras_ProveedoresController_modalBuscar214(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedoresController.modalBuscar(), HandlerDef(this, "controllers.compras.ProveedoresController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """compras/proveedores/modalBuscar"""))
   }
}
        

// @LINE:264
case controllers_compras_ProveedoresController_get215(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.ProveedoresController.get(id), HandlerDef(this, "controllers.compras.ProveedoresController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """compras/proveedores/get"""))
   }
}
        

// @LINE:265
case controllers_compras_ProveedoresAccionesController_modalInformacionProveedor216(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProveedoresAccionesController.modalInformacionProveedor(id), HandlerDef(this, "controllers.compras.ProveedoresAccionesController", "modalInformacionProveedor", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/proveedores/modalInformacionProveedor"""))
   }
}
        

// @LINE:266
case controllers_compras_ProveedoresController_ver217(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProveedoresController.ver(id), HandlerDef(this, "controllers.compras.ProveedoresController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/proveedores/ver"""))
   }
}
        

// @LINE:268
case controllers_compras_ProveedoresAccionesController_actualizarMail218(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedoresAccionesController.actualizarMail(), HandlerDef(this, "controllers.compras.ProveedoresAccionesController", "actualizarMail", Nil,"POST", """""", Routes.prefix + """compras/proveedores/actualizarMail"""))
   }
}
        

// @LINE:270
case controllers_compras_ClientesController_index219(params) => {
   call { 
        invokeHandler(controllers.compras.ClientesController.index(), HandlerDef(this, "controllers.compras.ClientesController", "index", Nil,"GET", """""", Routes.prefix + """compras/clientes"""))
   }
}
        

// @LINE:271
case controllers_compras_ClientesController_crear220(params) => {
   call { 
        invokeHandler(controllers.compras.ClientesController.crear(), HandlerDef(this, "controllers.compras.ClientesController", "crear", Nil,"GET", """""", Routes.prefix + """compras/clientes/crear"""))
   }
}
        

// @LINE:272
case controllers_compras_ClientesController_guardar221(params) => {
   call { 
        invokeHandler(controllers.compras.ClientesController.guardar(), HandlerDef(this, "controllers.compras.ClientesController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/clientes/guardar"""))
   }
}
        

// @LINE:273
case controllers_compras_ClientesController_editar222(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ClientesController.editar(id), HandlerDef(this, "controllers.compras.ClientesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/clientes/editar"""))
   }
}
        

// @LINE:274
case controllers_compras_ClientesController_actualizar223(params) => {
   call { 
        invokeHandler(controllers.compras.ClientesController.actualizar(), HandlerDef(this, "controllers.compras.ClientesController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/clientes/actualizar"""))
   }
}
        

// @LINE:275
case controllers_compras_ClientesController_eliminar224(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ClientesController.eliminar(id), HandlerDef(this, "controllers.compras.ClientesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/clientes/eliminar"""))
   }
}
        

// @LINE:276
case controllers_compras_ClientesController_ver225(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ClientesController.ver(id), HandlerDef(this, "controllers.compras.ClientesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/clientes/ver"""))
   }
}
        

// @LINE:277
case controllers_compras_ClientesController_formularioContacto226(params) => {
   call(params.fromQuery[Long]("clienteId", None), params.fromQuery[Long]("id", Some(0))) { (clienteId, id) =>
        invokeHandler(controllers.compras.ClientesController.formularioContacto(clienteId, id), HandlerDef(this, "controllers.compras.ClientesController", "formularioContacto", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/clientes/editarContacto"""))
   }
}
        

// @LINE:278
case controllers_compras_ClientesController_eliminarContacto227(params) => {
   call(params.fromQuery[Long]("sid", None), params.fromQuery[Long]("cId", None)) { (sid, cId) =>
        invokeHandler(controllers.compras.ClientesController.eliminarContacto(sid, cId), HandlerDef(this, "controllers.compras.ClientesController", "eliminarContacto", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/clientes/eliminarContacto"""))
   }
}
        

// @LINE:279
case controllers_compras_ClientesController_modalBuscar228(params) => {
   call { 
        invokeHandler(controllers.compras.ClientesController.modalBuscar(), HandlerDef(this, "controllers.compras.ClientesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """compras/clientes/modalBuscar"""))
   }
}
        

// @LINE:280
case controllers_compras_ClientesController_actualizarContacto229(params) => {
   call { 
        invokeHandler(controllers.compras.ClientesController.actualizarContacto(), HandlerDef(this, "controllers.compras.ClientesController", "actualizarContacto", Nil,"POST", """""", Routes.prefix + """compras/clientes/actualizarContacto"""))
   }
}
        

// @LINE:281
case controllers_compras_ClientesController_get230(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.ClientesController.get(id), HandlerDef(this, "controllers.compras.ClientesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """compras/get"""))
   }
}
        

// @LINE:282
case controllers_compras_ClientesController_modalCarga231(params) => {
   call { 
        invokeHandler(controllers.compras.ClientesController.modalCarga(), HandlerDef(this, "controllers.compras.ClientesController", "modalCarga", Nil,"GET", """""", Routes.prefix + """compras/modalCargar"""))
   }
}
        

// @LINE:283
case controllers_compras_ClientesController_guardarDesdeModal232(params) => {
   call { 
        invokeHandler(controllers.compras.ClientesController.guardarDesdeModal(), HandlerDef(this, "controllers.compras.ClientesController", "guardarDesdeModal", Nil,"POST", """""", Routes.prefix + """compras/guardarDesdeModal"""))
   }
}
        

// @LINE:285
case controllers_compras_ProductosController_indexProducto233(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.indexProducto(), HandlerDef(this, "controllers.compras.ProductosController", "indexProducto", Nil,"GET", """""", Routes.prefix + """compras/productos"""))
   }
}
        

// @LINE:286
case controllers_compras_ProductosController_listarProducto234(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.listarProducto(), HandlerDef(this, "controllers.compras.ProductosController", "listarProducto", Nil,"GET", """""", Routes.prefix + """compras/productos/"""))
   }
}
        

// @LINE:287
case controllers_compras_ProductosController_crearProducto235(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.crearProducto(), HandlerDef(this, "controllers.compras.ProductosController", "crearProducto", Nil,"GET", """""", Routes.prefix + """compras/productos/crear"""))
   }
}
        

// @LINE:288
case controllers_compras_ProductosController_guardarProducto236(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.guardarProducto(), HandlerDef(this, "controllers.compras.ProductosController", "guardarProducto", Nil,"POST", """""", Routes.prefix + """compras/productos/guardar"""))
   }
}
        

// @LINE:289
case controllers_compras_ProductosController_editarProducto237(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProductosController.editarProducto(id), HandlerDef(this, "controllers.compras.ProductosController", "editarProducto", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/productos/editar"""))
   }
}
        

// @LINE:290
case controllers_compras_ProductosController_eliminarProducto238(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProductosController.eliminarProducto(id), HandlerDef(this, "controllers.compras.ProductosController", "eliminarProducto", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/productos/eliminar"""))
   }
}
        

// @LINE:291
case controllers_compras_ProductosController_actualizarProducto239(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.actualizarProducto(), HandlerDef(this, "controllers.compras.ProductosController", "actualizarProducto", Nil,"POST", """""", Routes.prefix + """compras/producto/actualizar"""))
   }
}
        

// @LINE:292
case controllers_compras_ProductosController_modalBuscar240(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.modalBuscar(), HandlerDef(this, "controllers.compras.ProductosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """compras/producto/modalBuscar"""))
   }
}
        

// @LINE:293
case controllers_compras_ProductosController_modalBuscarIps241(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.modalBuscarIps(), HandlerDef(this, "controllers.compras.ProductosController", "modalBuscarIps", Nil,"GET", """""", Routes.prefix + """compras/producto/modalBuscarIps"""))
   }
}
        

// @LINE:294
case controllers_compras_ProductosController_modalBuscarSolicitudes242(params) => {
   call(params.fromQuery[Long]("idSolicitud", None)) { (idSolicitud) =>
        invokeHandler(controllers.compras.ProductosController.modalBuscarSolicitudes(idSolicitud), HandlerDef(this, "controllers.compras.ProductosController", "modalBuscarSolicitudes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/producto/modalBuscarSolicitudes"""))
   }
}
        

// @LINE:295
case controllers_compras_ProductosController_get243(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.ProductosController.get(id), HandlerDef(this, "controllers.compras.ProductosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """compras/producto/get"""))
   }
}
        

// @LINE:296
case controllers_compras_ProductosController_ver244(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProductosController.ver(id), HandlerDef(this, "controllers.compras.ProductosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/producto/ver"""))
   }
}
        

// @LINE:297
case controllers_compras_ProductosController_getPrecioProducto245(params) => {
   call(params.fromQuery[Int]("producto_id", Some(0))) { (producto_id) =>
        invokeHandler(controllers.compras.ProductosController.getPrecioProducto(producto_id), HandlerDef(this, "controllers.compras.ProductosController", "getPrecioProducto", Seq(classOf[Int]),"GET", """""", Routes.prefix + """compras/producto/getPrecio"""))
   }
}
        

// @LINE:298
case controllers_compras_ProductosController_cargaProductoRismi246(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.cargaProductoRismi(), HandlerDef(this, "controllers.compras.ProductosController", "cargaProductoRismi", Nil,"GET", """""", Routes.prefix + """compras/producto/cargaProductoRismi"""))
   }
}
        

// @LINE:299
case controllers_compras_ProductosController_modalCarga247(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.modalCarga(), HandlerDef(this, "controllers.compras.ProductosController", "modalCarga", Nil,"GET", """""", Routes.prefix + """compras/producto/modalCargar"""))
   }
}
        

// @LINE:300
case controllers_compras_ProductosController_guardarProductoDesdeModal248(params) => {
   call { 
        invokeHandler(controllers.compras.ProductosController.guardarProductoDesdeModal(), HandlerDef(this, "controllers.compras.ProductosController", "guardarProductoDesdeModal", Nil,"POST", """""", Routes.prefix + """compras/producto/guardarProductoDesdeModal"""))
   }
}
        

// @LINE:302
case controllers_compras_CategoriasController_indexCategoria249(params) => {
   call { 
        invokeHandler(controllers.compras.CategoriasController.indexCategoria(), HandlerDef(this, "controllers.compras.CategoriasController", "indexCategoria", Nil,"GET", """""", Routes.prefix + """compras/categorias"""))
   }
}
        

// @LINE:303
case controllers_compras_CategoriasController_crearCategoria250(params) => {
   call { 
        invokeHandler(controllers.compras.CategoriasController.crearCategoria(), HandlerDef(this, "controllers.compras.CategoriasController", "crearCategoria", Nil,"GET", """""", Routes.prefix + """compras/categorias/crear"""))
   }
}
        

// @LINE:304
case controllers_compras_CategoriasController_guardarCategoria251(params) => {
   call { 
        invokeHandler(controllers.compras.CategoriasController.guardarCategoria(), HandlerDef(this, "controllers.compras.CategoriasController", "guardarCategoria", Nil,"POST", """""", Routes.prefix + """compras/categorias/guardar"""))
   }
}
        

// @LINE:305
case controllers_compras_CategoriasController_editarCategoria252(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CategoriasController.editarCategoria(id), HandlerDef(this, "controllers.compras.CategoriasController", "editarCategoria", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/categorias/editar"""))
   }
}
        

// @LINE:306
case controllers_compras_CategoriasController_eliminarCategoria253(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CategoriasController.eliminarCategoria(id), HandlerDef(this, "controllers.compras.CategoriasController", "eliminarCategoria", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/categorias/eliminar"""))
   }
}
        

// @LINE:307
case controllers_compras_CategoriasController_actualizarCategoria254(params) => {
   call { 
        invokeHandler(controllers.compras.CategoriasController.actualizarCategoria(), HandlerDef(this, "controllers.compras.CategoriasController", "actualizarCategoria", Nil,"POST", """""", Routes.prefix + """compras/categorias/actualizar"""))
   }
}
        

// @LINE:308
case controllers_compras_CategoriasController_modalBuscar255(params) => {
   call { 
        invokeHandler(controllers.compras.CategoriasController.modalBuscar(), HandlerDef(this, "controllers.compras.CategoriasController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """compras/categorias/modalBuscar"""))
   }
}
        

// @LINE:309
case controllers_compras_CategoriasController_get256(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.CategoriasController.get(id), HandlerDef(this, "controllers.compras.CategoriasController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """compras/categorias/get"""))
   }
}
        

// @LINE:311
case controllers_compras_TipoProductosController_indexTipoProducto257(params) => {
   call { 
        invokeHandler(controllers.compras.TipoProductosController.indexTipoProducto(), HandlerDef(this, "controllers.compras.TipoProductosController", "indexTipoProducto", Nil,"GET", """""", Routes.prefix + """compras/tipo-producto"""))
   }
}
        

// @LINE:312
case controllers_compras_TipoProductosController_crearTipoProducto258(params) => {
   call { 
        invokeHandler(controllers.compras.TipoProductosController.crearTipoProducto(), HandlerDef(this, "controllers.compras.TipoProductosController", "crearTipoProducto", Nil,"GET", """""", Routes.prefix + """compras/tipo-producto/crear"""))
   }
}
        

// @LINE:313
case controllers_compras_TipoProductosController_guardarTipoProducto259(params) => {
   call { 
        invokeHandler(controllers.compras.TipoProductosController.guardarTipoProducto(), HandlerDef(this, "controllers.compras.TipoProductosController", "guardarTipoProducto", Nil,"POST", """""", Routes.prefix + """compras/tipo-producto/guardar"""))
   }
}
        

// @LINE:314
case controllers_compras_TipoProductosController_editarTipoProducto260(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.TipoProductosController.editarTipoProducto(id), HandlerDef(this, "controllers.compras.TipoProductosController", "editarTipoProducto", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/tipo-producto/editar"""))
   }
}
        

// @LINE:315
case controllers_compras_TipoProductosController_eliminarTipoProducto261(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.TipoProductosController.eliminarTipoProducto(id), HandlerDef(this, "controllers.compras.TipoProductosController", "eliminarTipoProducto", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/tipo-producto/eliminar"""))
   }
}
        

// @LINE:316
case controllers_compras_TipoProductosController_actualizarTipoProducto262(params) => {
   call { 
        invokeHandler(controllers.compras.TipoProductosController.actualizarTipoProducto(), HandlerDef(this, "controllers.compras.TipoProductosController", "actualizarTipoProducto", Nil,"POST", """""", Routes.prefix + """compras/tipo-producto/actualizar"""))
   }
}
        

// @LINE:317
case controllers_compras_TipoProductosController_modalBuscar263(params) => {
   call { 
        invokeHandler(controllers.compras.TipoProductosController.modalBuscar(), HandlerDef(this, "controllers.compras.TipoProductosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """compras/tipo-producto/modalBuscar"""))
   }
}
        

// @LINE:318
case controllers_compras_TipoProductosController_get264(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.TipoProductosController.get(id), HandlerDef(this, "controllers.compras.TipoProductosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """compras/tipo-producto/get"""))
   }
}
        

// @LINE:320
case controllers_compras_ArticulosController_indexArticulo265(params) => {
   call { 
        invokeHandler(controllers.compras.ArticulosController.indexArticulo(), HandlerDef(this, "controllers.compras.ArticulosController", "indexArticulo", Nil,"GET", """""", Routes.prefix + """compras/articulo"""))
   }
}
        

// @LINE:321
case controllers_compras_ArticulosController_crearArticulo266(params) => {
   call { 
        invokeHandler(controllers.compras.ArticulosController.crearArticulo(), HandlerDef(this, "controllers.compras.ArticulosController", "crearArticulo", Nil,"GET", """""", Routes.prefix + """compras/articulo/crear"""))
   }
}
        

// @LINE:322
case controllers_compras_ArticulosController_guardarArticulo267(params) => {
   call { 
        invokeHandler(controllers.compras.ArticulosController.guardarArticulo(), HandlerDef(this, "controllers.compras.ArticulosController", "guardarArticulo", Nil,"POST", """""", Routes.prefix + """compras/articulo/guardar"""))
   }
}
        

// @LINE:323
case controllers_compras_ArticulosController_editarArticulo268(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ArticulosController.editarArticulo(id), HandlerDef(this, "controllers.compras.ArticulosController", "editarArticulo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/articulo/editar"""))
   }
}
        

// @LINE:324
case controllers_compras_ArticulosController_eliminarArticulo269(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ArticulosController.eliminarArticulo(id), HandlerDef(this, "controllers.compras.ArticulosController", "eliminarArticulo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/articulo/eliminar"""))
   }
}
        

// @LINE:325
case controllers_compras_ArticulosController_actualizarArticulo270(params) => {
   call { 
        invokeHandler(controllers.compras.ArticulosController.actualizarArticulo(), HandlerDef(this, "controllers.compras.ArticulosController", "actualizarArticulo", Nil,"POST", """""", Routes.prefix + """compras/articulo/actualizar"""))
   }
}
        

// @LINE:326
case controllers_compras_ArticulosController_modalBuscar271(params) => {
   call { 
        invokeHandler(controllers.compras.ArticulosController.modalBuscar(), HandlerDef(this, "controllers.compras.ArticulosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """compras/articulo/modalBuscar"""))
   }
}
        

// @LINE:327
case controllers_compras_ArticulosController_get272(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.ArticulosController.get(id), HandlerDef(this, "controllers.compras.ArticulosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """compras/articulo/get"""))
   }
}
        

// @LINE:329
case controllers_compras_ProveedorAtributosController_index273(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.compras.ProveedorAtributosController.index(id, editable), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/linea-proveedor-atributo/index"""))
   }
}
        

// @LINE:330
case controllers_compras_ProveedorAtributosController_crear274(params) => {
   call(params.fromQuery[String]("proveedorId", None)) { (proveedorId) =>
        invokeHandler(controllers.compras.ProveedorAtributosController.crear(proveedorId), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/linea-proveedor-atributo/crear"""))
   }
}
        

// @LINE:331
case controllers_compras_ProveedorAtributosController_editar275(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProveedorAtributosController.editar(id), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-proveedor-atributo/editar"""))
   }
}
        

// @LINE:332
case controllers_compras_ProveedorAtributosController_guardar276(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedorAtributosController.guardar(), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/linea-proveedor-atributo/guardar"""))
   }
}
        

// @LINE:333
case controllers_compras_ProveedorAtributosController_actualizar277(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedorAtributosController.actualizar(), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/linea-proveedor-atributo/actualizar"""))
   }
}
        

// @LINE:334
case controllers_compras_ProveedorAtributosController_eliminar278(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProveedorAtributosController.eliminar(id), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-proveedor-atributo/eliminar"""))
   }
}
        

// @LINE:336
case controllers_compras_ProveedorDatosDgrController_index279(params) => {
   call(params.fromQuery[Long]("cuit", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (cuit, editable) =>
        invokeHandler(controllers.compras.ProveedorDatosDgrController.index(cuit, editable), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/linea-proveedor-datodgr/index"""))
   }
}
        

// @LINE:337
case controllers_compras_ProveedorDatosDgrController_crear280(params) => {
   call(params.fromQuery[Long]("cuit", None)) { (cuit) =>
        invokeHandler(controllers.compras.ProveedorDatosDgrController.crear(cuit), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "crear", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-proveedor-datodgr/crear"""))
   }
}
        

// @LINE:338
case controllers_compras_ProveedorDatosDgrController_editar281(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProveedorDatosDgrController.editar(id), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-proveedor-datodgr/editar"""))
   }
}
        

// @LINE:339
case controllers_compras_ProveedorDatosDgrController_guardar282(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedorDatosDgrController.guardar(), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/linea-proveedor-datodgr/guardar"""))
   }
}
        

// @LINE:340
case controllers_compras_ProveedorDatosDgrController_actualizar283(params) => {
   call { 
        invokeHandler(controllers.compras.ProveedorDatosDgrController.actualizar(), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/linea-proveedor-datodgr/actualizar"""))
   }
}
        

// @LINE:341
case controllers_compras_ProveedorDatosDgrController_eliminar284(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.ProveedorDatosDgrController.eliminar(id), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/linea-proveedor-datodgr/eliminar"""))
   }
}
        

// @LINE:343
case controllers_compras_ObrasSocialesController_modalBuscar285(params) => {
   call { 
        invokeHandler(controllers.compras.ObrasSocialesController.modalBuscar(), HandlerDef(this, "controllers.compras.ObrasSocialesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """compras/ob/modalBuscar"""))
   }
}
        

// @LINE:344
case controllers_compras_ObrasSocialesController_get286(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.ObrasSocialesController.get(id), HandlerDef(this, "controllers.compras.ObrasSocialesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """compras/ob/get"""))
   }
}
        

// @LINE:347
case controllers_compras_CertificacionesComprasController_index287(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasController.index(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "index", Nil,"GET", """""", Routes.prefix + """compras/certificacion-compra"""))
   }
}
        

// @LINE:348
case controllers_compras_CertificacionesComprasController_crear288(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasController.crear(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "crear", Nil,"GET", """""", Routes.prefix + """compras/certificacion-compra/crear"""))
   }
}
        

// @LINE:349
case controllers_compras_CertificacionesComprasController_guardar289(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/certificacion-compra/guardar"""))
   }
}
        

// @LINE:350
case controllers_compras_CertificacionesComprasController_editar290(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesComprasController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-compra/editar"""))
   }
}
        

// @LINE:351
case controllers_compras_CertificacionesComprasController_eliminar291(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesComprasController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-compra/eliminar"""))
   }
}
        

// @LINE:352
case controllers_compras_CertificacionesComprasController_ver292(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesComprasController.ver(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-compra/ver"""))
   }
}
        

// @LINE:353
case controllers_compras_CertificacionesComprasController_duplicar293(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesComprasController.duplicar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "duplicar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-compra/duplicar"""))
   }
}
        

// @LINE:354
case controllers_compras_CertificacionesComprasController_actualizar294(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesComprasController.actualizar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """compras/certificacion-compra/actualizar"""))
   }
}
        

// @LINE:355
case controllers_compras_CertificacionesComprasController_cambiarEstado295(params) => {
   call(params.fromQuery[Long]("idCertificacion", None), params.fromQuery[Long]("idEstado", None)) { (idCertificacion, idEstado) =>
        invokeHandler(controllers.compras.CertificacionesComprasController.cambiarEstado(idCertificacion, idEstado), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-compra/cambiarEstado"""))
   }
}
        

// @LINE:356
case controllers_compras_CertificacionesComprasController_modalEditarCuentaAnalica296(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasController.modalEditarCuentaAnalica(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "modalEditarCuentaAnalica", Nil,"GET", """""", Routes.prefix + """compras/certificacion-compra/modalEditarCuentaAnalitica"""))
   }
}
        

// @LINE:357
case controllers_compras_CertificacionesComprasController_editarCuentaAnalitica297(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "editarCuentaAnalitica", Nil,"POST", """""", Routes.prefix + """compras/certificacion-compra/editarCuentaAnalitica"""))
   }
}
        

// @LINE:358
case controllers_compras_CertificacionesComprasAccionesController_modalPasarEnCurso298(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.modalPasarEnCurso(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalPasarEnCurso", Nil,"GET", """""", Routes.prefix + """compras/certificacion-compra/modalPasarEnCurso"""))
   }
}
        

// @LINE:359
case controllers_compras_CertificacionesComprasAccionesController_pasarEnCursoMasivo299(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.pasarEnCursoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "pasarEnCursoMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion-compra/pasarEnCursoMasivo"""))
   }
}
        

// @LINE:360
case controllers_compras_CertificacionesComprasAccionesController_modalPasarCertificado300(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.modalPasarCertificado(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalPasarCertificado", Nil,"GET", """""", Routes.prefix + """compras/certificacion-compra/modalPasarCertificado"""))
   }
}
        

// @LINE:361
case controllers_compras_CertificacionesComprasAccionesController_pasarCertificadoMasivo301(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.pasarCertificadoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "pasarCertificadoMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion-compra/pasarCertificadoMasivo"""))
   }
}
        

// @LINE:362
case controllers_compras_CertificacionesComprasAccionesController_modalPasarBorrador302(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalPasarBorrador", Nil,"GET", """""", Routes.prefix + """compras/certificacion-compra/modalPasarBorrador"""))
   }
}
        

// @LINE:363
case controllers_compras_CertificacionesComprasAccionesController_pasarBorradorMasivo303(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "pasarBorradorMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion-compra/pasarBorradorMasivo"""))
   }
}
        

// @LINE:364
case controllers_compras_CertificacionesComprasAccionesController_modalPasarCancelado304(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalPasarCancelado", Nil,"GET", """""", Routes.prefix + """compras/certificacion-compra/modalPasarCancelado"""))
   }
}
        

// @LINE:365
case controllers_compras_CertificacionesComprasAccionesController_pasarCanceladoMasivo305(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "pasarCanceladoMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion-compra/pasarCanceladoMasivo"""))
   }
}
        

// @LINE:366
case controllers_compras_CertificacionesComprasAccionesController_modalEditarFechaCertificacion306(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.modalEditarFechaCertificacion(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalEditarFechaCertificacion", Nil,"GET", """""", Routes.prefix + """compras/certificacion-compra/modalEditarFechaCertificacion"""))
   }
}
        

// @LINE:367
case controllers_compras_CertificacionesComprasAccionesController_editarFechaCertificacionMasivo307(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasAccionesController.editarFechaCertificacionMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "editarFechaCertificacionMasivo", Nil,"POST", """""", Routes.prefix + """compras/certificacion-compra/editarFechaCertificacionMasivo"""))
   }
}
        

// @LINE:369
case controllers_compras_CertificacionesComprasLineasController_index308(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.compras.CertificacionesComprasLineasController.index(id, editable), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/certificacion-compra-linea/index"""))
   }
}
        

// @LINE:370
case controllers_compras_CertificacionesComprasLineasController_crear309(params) => {
   call(params.fromQuery[String]("certificacionId", None)) { (certificacionId) =>
        invokeHandler(controllers.compras.CertificacionesComprasLineasController.crear(certificacionId), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/certificacion-compra-linea/crear"""))
   }
}
        

// @LINE:371
case controllers_compras_CertificacionesComprasLineasController_editar310(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesComprasLineasController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-compra-linea/editar"""))
   }
}
        

// @LINE:372
case controllers_compras_CertificacionesComprasLineasController_guardar311(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasLineasController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/certificacion-compra-linea/guardar"""))
   }
}
        

// @LINE:373
case controllers_compras_CertificacionesComprasLineasController_actualizar312(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasLineasController.actualizar(), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/certificacion-compra-linea/actualizar"""))
   }
}
        

// @LINE:374
case controllers_compras_CertificacionesComprasLineasController_eliminar313(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesComprasLineasController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-compra-linea/eliminar"""))
   }
}
        

// @LINE:376
case controllers_compras_CertificacionesComprasReportesController_reporteCertificacion314(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesComprasReportesController.reporteCertificacion(), HandlerDef(this, "controllers.compras.CertificacionesComprasReportesController", "reporteCertificacion", Nil,"POST", """""", Routes.prefix + """compras/certificaciones-compra/reporteCertificacion"""))
   }
}
        

// @LINE:378
case controllers_compras_CertificacionesObrasController_index315(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesObrasController.index(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "index", Nil,"GET", """""", Routes.prefix + """compras/certificacion-obra"""))
   }
}
        

// @LINE:379
case controllers_compras_CertificacionesObrasController_crear316(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesObrasController.crear(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "crear", Nil,"GET", """""", Routes.prefix + """compras/certificacion-obra/crear"""))
   }
}
        

// @LINE:380
case controllers_compras_CertificacionesObrasController_guardar317(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesObrasController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/certificacion-obra/guardar"""))
   }
}
        

// @LINE:381
case controllers_compras_CertificacionesObrasController_editar318(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesObrasController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-obra/editar"""))
   }
}
        

// @LINE:382
case controllers_compras_CertificacionesObrasController_eliminar319(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesObrasController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-obra/eliminar"""))
   }
}
        

// @LINE:383
case controllers_compras_CertificacionesObrasController_ver320(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesObrasController.ver(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-obra/ver"""))
   }
}
        

// @LINE:384
case controllers_compras_CertificacionesObrasController_duplicar321(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesObrasController.duplicar(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "duplicar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-obra/duplicar"""))
   }
}
        

// @LINE:385
case controllers_compras_CertificacionesObrasController_actualizar322(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CertificacionesObrasController.actualizar(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "actualizar", Seq(classOf[Long]),"POST", """""", Routes.prefix + """compras/certificacion-obra/actualizar"""))
   }
}
        

// @LINE:386
case controllers_compras_CertificacionesObrasController_cambiarEstado323(params) => {
   call(params.fromQuery[Long]("idCertificacion", None), params.fromQuery[Long]("idEstado", None)) { (idCertificacion, idEstado) =>
        invokeHandler(controllers.compras.CertificacionesObrasController.cambiarEstado(idCertificacion, idEstado), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/certificacion-obra/cambiarEstado"""))
   }
}
        

// @LINE:387
case controllers_compras_CertificacionesObrasController_modalEditarCuentaAnalica324(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesObrasController.modalEditarCuentaAnalica(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "modalEditarCuentaAnalica", Nil,"GET", """""", Routes.prefix + """compras/certificacion-obra/modalEditarCuentaAnalitica"""))
   }
}
        

// @LINE:388
case controllers_compras_CertificacionesObrasController_editarCuentaAnalitica325(params) => {
   call { 
        invokeHandler(controllers.compras.CertificacionesObrasController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "editarCuentaAnalitica", Nil,"POST", """""", Routes.prefix + """compras/certificacion-obra/editarCuentaAnalitica"""))
   }
}
        

// @LINE:400
case controllers_compras_CajaChicaController_index326(params) => {
   call { 
        invokeHandler(controllers.compras.CajaChicaController.index(), HandlerDef(this, "controllers.compras.CajaChicaController", "index", Nil,"GET", """""", Routes.prefix + """compras/caja-chica"""))
   }
}
        

// @LINE:401
case controllers_compras_CajaChicaController_ver327(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.ver(id), HandlerDef(this, "controllers.compras.CajaChicaController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/ver"""))
   }
}
        

// @LINE:402
case controllers_compras_CajaChicaController_crear328(params) => {
   call { 
        invokeHandler(controllers.compras.CajaChicaController.crear(), HandlerDef(this, "controllers.compras.CajaChicaController", "crear", Nil,"GET", """""", Routes.prefix + """compras/caja-chica/crear"""))
   }
}
        

// @LINE:403
case controllers_compras_CajaChicaController_guardar329(params) => {
   call { 
        invokeHandler(controllers.compras.CajaChicaController.guardar(), HandlerDef(this, "controllers.compras.CajaChicaController", "guardar", Nil,"GET", """""", Routes.prefix + """compras/caja-chica/guardar"""))
   }
}
        

// @LINE:404
case controllers_compras_CajaChicaController_editar330(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.editar(id), HandlerDef(this, "controllers.compras.CajaChicaController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/editar"""))
   }
}
        

// @LINE:405
case controllers_compras_CajaChicaController_actualizar331(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.actualizar(id), HandlerDef(this, "controllers.compras.CajaChicaController", "actualizar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/actualizar"""))
   }
}
        

// @LINE:406
case controllers_compras_CajaChicaController_eliminar332(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.eliminar(id), HandlerDef(this, "controllers.compras.CajaChicaController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/eliminar"""))
   }
}
        

// @LINE:407
case controllers_compras_CajaChicaController_cambiarEstado333(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Long]("idEstado", None)) { (id, idEstado) =>
        invokeHandler(controllers.compras.CajaChicaController.cambiarEstado(id, idEstado), HandlerDef(this, "controllers.compras.CajaChicaController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/cambiarEstado"""))
   }
}
        

// @LINE:409
case controllers_compras_CajaChicaController_resumenPresupuesto334(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.resumenPresupuesto(id), HandlerDef(this, "controllers.compras.CajaChicaController", "resumenPresupuesto", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/resumenPresupuesto"""))
   }
}
        

// @LINE:410
case controllers_compras_CajaChicaController_reporteImputacionPreventivaLista335(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.reporteImputacionPreventivaLista(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteImputacionPreventivaLista", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/reporteImputacionPreventivaLista"""))
   }
}
        

// @LINE:411
case controllers_compras_CajaChicaController_reporteImputacionPreventivaAjustesLista336(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.reporteImputacionPreventivaAjustesLista(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteImputacionPreventivaAjustesLista", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/reporteImputacionPreventivaListaAjuste"""))
   }
}
        

// @LINE:412
case controllers_compras_CajaChicaController_reporteImputacionDefinitiva337(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.reporteImputacionDefinitiva(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteImputacionDefinitiva", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/reporteImputacionDefinitiva"""))
   }
}
        

// @LINE:413
case controllers_compras_CajaChicaController_reporteCajaChica338(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.reporteCajaChica(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteCajaChica", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/reporteCajaChica"""))
   }
}
        

// @LINE:414
case controllers_compras_CajaChicaController_reporteCajaChicaOrdenCargo339(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.compras.CajaChicaController.reporteCajaChicaOrdenCargo(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteCajaChicaOrdenCargo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica/reporteCajaChicaOrdenCargo"""))
   }
}
        

// @LINE:416
case controllers_compras_CajaChicaMovimientosController_lista340(params) => {
   call(params.fromQuery[Long]("cajaId", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (cajaId, editable) =>
        invokeHandler(controllers.compras.CajaChicaMovimientosController.lista(cajaId, editable), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "lista", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/caja-chica-movimientos"""))
   }
}
        

// @LINE:417
case controllers_compras_CajaChicaMovimientosController_crear341(params) => {
   call(params.fromQuery[String]("cajaId", None)) { (cajaId) =>
        invokeHandler(controllers.compras.CajaChicaMovimientosController.crear(cajaId), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/caja-chica-movimientos/crear"""))
   }
}
        

// @LINE:418
case controllers_compras_CajaChicaMovimientosController_editar342(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CajaChicaMovimientosController.editar(id), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica-movimientos/editar"""))
   }
}
        

// @LINE:419
case controllers_compras_CajaChicaMovimientosController_guardar343(params) => {
   call { 
        invokeHandler(controllers.compras.CajaChicaMovimientosController.guardar(), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/caja-chica-movimientos/guardar"""))
   }
}
        

// @LINE:420
case controllers_compras_CajaChicaMovimientosController_actualizar344(params) => {
   call { 
        invokeHandler(controllers.compras.CajaChicaMovimientosController.actualizar(), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "actualizar", Nil,"POST", """""", Routes.prefix + """compras/caja-chica-movimientos/actualizar"""))
   }
}
        

// @LINE:421
case controllers_compras_CajaChicaMovimientosController_eliminar345(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.compras.CajaChicaMovimientosController.eliminar(id), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """compras/caja-chica-movimientos/eliminar"""))
   }
}
        

// @LINE:423
case controllers_compras_CajaChicaPresupuestoLineasController_lista346(params) => {
   call(params.fromQuery[Long]("cajaId", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (cajaId, editable) =>
        invokeHandler(controllers.compras.CajaChicaPresupuestoLineasController.lista(cajaId, editable), HandlerDef(this, "controllers.compras.CajaChicaPresupuestoLineasController", "lista", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """compras/caja-chica-presupuesto"""))
   }
}
        

// @LINE:424
case controllers_compras_CajaChicaPresupuestoLineasController_crear347(params) => {
   call(params.fromQuery[String]("cajaId", None)) { (cajaId) =>
        invokeHandler(controllers.compras.CajaChicaPresupuestoLineasController.crear(cajaId), HandlerDef(this, "controllers.compras.CajaChicaPresupuestoLineasController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """compras/caja-chica-presupuesto/crear"""))
   }
}
        

// @LINE:425
case controllers_compras_CajaChicaPresupuestoLineasController_guardar348(params) => {
   call { 
        invokeHandler(controllers.compras.CajaChicaPresupuestoLineasController.guardar(), HandlerDef(this, "controllers.compras.CajaChicaPresupuestoLineasController", "guardar", Nil,"POST", """""", Routes.prefix + """compras/caja-chica-presupuesto/guardar"""))
   }
}
        

// @LINE:430
case controllers_expediente_IndexController_index349(params) => {
   call { 
        invokeHandler(controllers.expediente.IndexController.index(), HandlerDef(this, "controllers.expediente.IndexController", "index", Nil,"GET", """-----------------------------MODULO EXPEDIENTES ---------------------------------""", Routes.prefix + """expediente"""))
   }
}
        

// @LINE:431
case controllers_expediente_IniciadorExpedientesController_indexIniciadorExpediente350(params) => {
   call { 
        invokeHandler(controllers.expediente.IniciadorExpedientesController.indexIniciadorExpediente(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "indexIniciadorExpediente", Nil,"GET", """""", Routes.prefix + """expediente/iniciadorExpediente"""))
   }
}
        

// @LINE:432
case controllers_expediente_IniciadorExpedientesController_crearIniciadorExpediente351(params) => {
   call { 
        invokeHandler(controllers.expediente.IniciadorExpedientesController.crearIniciadorExpediente(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "crearIniciadorExpediente", Nil,"GET", """""", Routes.prefix + """expediente/iniciadorExpediente/crear"""))
   }
}
        

// @LINE:433
case controllers_expediente_IniciadorExpedientesController_guardarIniciadorExpediente352(params) => {
   call { 
        invokeHandler(controllers.expediente.IniciadorExpedientesController.guardarIniciadorExpediente(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "guardarIniciadorExpediente", Nil,"POST", """""", Routes.prefix + """expediente/iniciadorExpediente/guardar"""))
   }
}
        

// @LINE:434
case controllers_expediente_IniciadorExpedientesController_editarIniciadorExpediente353(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.IniciadorExpedientesController.editarIniciadorExpediente(id), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "editarIniciadorExpediente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/iniciadorExpediente/editar"""))
   }
}
        

// @LINE:435
case controllers_expediente_IniciadorExpedientesController_eliminarIniciadorExpediente354(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.IniciadorExpedientesController.eliminarIniciadorExpediente(id), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "eliminarIniciadorExpediente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expedient/iniciadorExpediente/eliminar"""))
   }
}
        

// @LINE:436
case controllers_expediente_IniciadorExpedientesController_actualizarIniciadorExpediente355(params) => {
   call { 
        invokeHandler(controllers.expediente.IniciadorExpedientesController.actualizarIniciadorExpediente(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "actualizarIniciadorExpediente", Nil,"POST", """""", Routes.prefix + """expediente/iniciadorExpediente/actualizar"""))
   }
}
        

// @LINE:437
case controllers_expediente_IniciadorExpedientesController_modalBuscar356(params) => {
   call { 
        invokeHandler(controllers.expediente.IniciadorExpedientesController.modalBuscar(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """expediente/iniciadorExpediente/modalBuscar"""))
   }
}
        

// @LINE:438
case controllers_expediente_IniciadorExpedientesController_get357(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.expediente.IniciadorExpedientesController.get(id), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """expediente/iniciadorExpediente/get"""))
   }
}
        

// @LINE:439
case controllers_expediente_ExpedientesReportesController_reporteMovimiento358(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesReportesController.reporteMovimiento(), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reporteMovimiento", Nil,"GET", """""", Routes.prefix + """expediente/reportes/reporteMovimiento"""))
   }
}
        

// @LINE:441
case controllers_expediente_ExpedientesController_indexExpediente359(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.indexExpediente(), HandlerDef(this, "controllers.expediente.ExpedientesController", "indexExpediente", Nil,"GET", """""", Routes.prefix + """expediente/expediente"""))
   }
}
        

// @LINE:442
case controllers_expediente_ExpedientesController_crearExpediente360(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.crearExpediente(), HandlerDef(this, "controllers.expediente.ExpedientesController", "crearExpediente", Nil,"GET", """""", Routes.prefix + """expediente/expediente/crear"""))
   }
}
        

// @LINE:443
case controllers_expediente_ExpedientesController_guardarExpediente361(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.guardarExpediente(), HandlerDef(this, "controllers.expediente.ExpedientesController", "guardarExpediente", Nil,"POST", """""", Routes.prefix + """expediente/expediente/guardar"""))
   }
}
        

// @LINE:444
case controllers_expediente_ExpedientesController_editarExpediente362(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesController.editarExpediente(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "editarExpediente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/expediente/editar"""))
   }
}
        

// @LINE:445
case controllers_expediente_ExpedientesController_eliminarExpediente363(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesController.eliminarExpediente(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "eliminarExpediente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/expediente/eliminar"""))
   }
}
        

// @LINE:446
case controllers_expediente_ExpedientesController_eliminarExpedienteCopia364(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesController.eliminarExpedienteCopia(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "eliminarExpedienteCopia", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/expediente/eliminarCopia"""))
   }
}
        

// @LINE:447
case controllers_expediente_ExpedientesController_actualizarExpediente365(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.actualizarExpediente(), HandlerDef(this, "controllers.expediente.ExpedientesController", "actualizarExpediente", Nil,"POST", """""", Routes.prefix + """expediente/expediente/actualizar"""))
   }
}
        

// @LINE:448
case controllers_expediente_ExpedientesController_modalBuscar366(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.modalBuscar(), HandlerDef(this, "controllers.expediente.ExpedientesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """expediente/expediente/modalBuscar"""))
   }
}
        

// @LINE:449
case controllers_expediente_ExpedientesController_modalBuscarCopia367(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.modalBuscarCopia(), HandlerDef(this, "controllers.expediente.ExpedientesController", "modalBuscarCopia", Nil,"GET", """""", Routes.prefix + """expediente/expediente/modalBuscarCopia"""))
   }
}
        

// @LINE:450
case controllers_expediente_ExpedientesController_get368(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesController.get(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """expediente/expediente/get"""))
   }
}
        

// @LINE:451
case controllers_expediente_ExpedientesController_ver369(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesController.ver(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/expediente/ver"""))
   }
}
        

// @LINE:452
case controllers_expediente_ExpedientesController_reporteTapaExpedienteMasivo370(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.reporteTapaExpedienteMasivo(), HandlerDef(this, "controllers.expediente.ExpedientesController", "reporteTapaExpedienteMasivo", Nil,"POST", """""", Routes.prefix + """expediente/reporteTapaExpedienteMasiva"""))
   }
}
        

// @LINE:453
case controllers_expediente_ExpedientesController_reporteTapaExpediente371(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesController.reporteTapaExpediente(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "reporteTapaExpediente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/reporteTapaExpediente"""))
   }
}
        

// @LINE:454
case controllers_expediente_ExpedientesController_listadoExpedientes372(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.listadoExpedientes(), HandlerDef(this, "controllers.expediente.ExpedientesController", "listadoExpedientes", Nil,"POST", """""", Routes.prefix + """expediente/reporteListadoExpedientes"""))
   }
}
        

// @LINE:455
case controllers_expediente_ExpedientesController_crearCopia373(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesController.crearCopia(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "crearCopia", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/expediente/crearCopia"""))
   }
}
        

// @LINE:456
case controllers_expediente_ExpedientesController_crearRP374(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesController.crearRP(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "crearRP", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/expediente/crearRP"""))
   }
}
        

// @LINE:457
case controllers_expediente_ExpedientesController_getExpedientesRecepcionSinFirma375(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.getExpedientesRecepcionSinFirma(), HandlerDef(this, "controllers.expediente.ExpedientesController", "getExpedientesRecepcionSinFirma", Nil,"GET", """""", Routes.prefix + """expediente/getExpedientesRecepcionSinFirma"""))
   }
}
        

// @LINE:458
case controllers_expediente_ExpedientesController_getExpedientesRecepcionSinFirmaReporte376(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.getExpedientesRecepcionSinFirmaReporte(), HandlerDef(this, "controllers.expediente.ExpedientesController", "getExpedientesRecepcionSinFirmaReporte", Nil,"GET", """""", Routes.prefix + """expediente/getExpedientesRecepcionSinFirmaReporte"""))
   }
}
        

// @LINE:459
case controllers_expediente_ExpedientesController_getExpedientesSinFirma377(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.getExpedientesSinFirma(), HandlerDef(this, "controllers.expediente.ExpedientesController", "getExpedientesSinFirma", Nil,"GET", """""", Routes.prefix + """expediente/getExpedientesSinFirma"""))
   }
}
        

// @LINE:460
case controllers_expediente_ExpedientesController_getExpedientesSinFirmaReporte378(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesController.getExpedientesSinFirmaReporte(), HandlerDef(this, "controllers.expediente.ExpedientesController", "getExpedientesSinFirmaReporte", Nil,"GET", """""", Routes.prefix + """expediente/getExpedientesSinFirmaReporte"""))
   }
}
        

// @LINE:462
case controllers_expediente_ExpedientesMovimientosController_index379(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.expediente.ExpedientesMovimientosController.index(id, editable), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """expediente/movimiento-linea/index"""))
   }
}
        

// @LINE:463
case controllers_expediente_ExpedientesMovimientosController_crear380(params) => {
   call(params.fromQuery[String]("expedienteId", None)) { (expedienteId) =>
        invokeHandler(controllers.expediente.ExpedientesMovimientosController.crear(expedienteId), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """expediente/movimiento-linea/crear"""))
   }
}
        

// @LINE:464
case controllers_expediente_ExpedientesMovimientosController_editar381(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesMovimientosController.editar(id), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/movimiento-linea/editar"""))
   }
}
        

// @LINE:465
case controllers_expediente_ExpedientesMovimientosController_guardar382(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesMovimientosController.guardar(), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "guardar", Nil,"POST", """""", Routes.prefix + """expediente/movimiento-linea/guardar"""))
   }
}
        

// @LINE:466
case controllers_expediente_ExpedientesMovimientosController_actualizar383(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesMovimientosController.actualizar(), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "actualizar", Nil,"POST", """""", Routes.prefix + """expediente/movimiento-linea/actualizar"""))
   }
}
        

// @LINE:467
case controllers_expediente_ExpedientesMovimientosController_eliminar384(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesMovimientosController.eliminar(id), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/movimiento-linea/eliminar"""))
   }
}
        

// @LINE:469
case controllers_expediente_ExpedientesAccionesController_modalPasarOtroServicio385(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesAccionesController.modalPasarOtroServicio(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "modalPasarOtroServicio", Nil,"GET", """""", Routes.prefix + """expediente/acciones/modalPasarOtroServicio"""))
   }
}
        

// @LINE:470
case controllers_expediente_ExpedientesAccionesController_modalPasarOtroServicioIndividual386(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesAccionesController.modalPasarOtroServicioIndividual(id), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "modalPasarOtroServicioIndividual", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/acciones/modalPasarOtroServicioIndividual"""))
   }
}
        

// @LINE:471
case controllers_expediente_ExpedientesAccionesController_pasarOtroServicio387(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesAccionesController.pasarOtroServicio(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "pasarOtroServicio", Nil,"POST", """""", Routes.prefix + """expediente/acciones/pasarOtroServicio"""))
   }
}
        

// @LINE:472
case controllers_expediente_ExpedientesReportesController_reportePaseExpediente388(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesReportesController.reportePaseExpediente(id), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reportePaseExpediente", Seq(classOf[Long]),"POST", """""", Routes.prefix + """expediente/reportes/reportePaseExpediente"""))
   }
}
        

// @LINE:473
case controllers_expediente_ExpedientesReportesController_reportePaseExpedienteListaCodigoCombinado389(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesReportesController.reportePaseExpedienteListaCodigoCombinado(), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reportePaseExpedienteListaCodigoCombinado", Nil,"POST", """""", Routes.prefix + """expediente/reportes/reportePaseExpedienteLista"""))
   }
}
        

// @LINE:474
case controllers_expediente_ExpedientesReportesController_reportePaseExpedienteListaCodigo390(params) => {
   call(params.fromQuery[Int]("codigo", None)) { (codigo) =>
        invokeHandler(controllers.expediente.ExpedientesReportesController.reportePaseExpedienteListaCodigo(codigo), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reportePaseExpedienteListaCodigo", Seq(classOf[Int]),"POST", """""", Routes.prefix + """expediente/reportes/reportePaseExpedienteCodigo"""))
   }
}
        

// @LINE:476
case controllers_expediente_ExpedientesReportesController_reportePaseExpedienteLista391(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesReportesController.reportePaseExpedienteLista(), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reportePaseExpedienteLista", Nil,"POST", """""", Routes.prefix + """expediente/reportes/reportePaseExpedienteLista"""))
   }
}
        

// @LINE:477
case controllers_expediente_ExpedientesAccionesController_cancelarPase392(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesAccionesController.cancelarPase(id), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "cancelarPase", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/acciones/cancelarPase"""))
   }
}
        

// @LINE:478
case controllers_expediente_ExpedientesAccionesController_cancelarPaseLista393(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesAccionesController.cancelarPaseLista(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "cancelarPaseLista", Nil,"POST", """""", Routes.prefix + """expediente/acciones/cancelarPaseLista"""))
   }
}
        

// @LINE:479
case controllers_expediente_ExpedientesAccionesController_asignarMiServicio394(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.ExpedientesAccionesController.asignarMiServicio(id), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "asignarMiServicio", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/acciones/asignarMiServicio"""))
   }
}
        

// @LINE:480
case controllers_expediente_ExpedientesMisPasesController_index395(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesMisPasesController.index(), HandlerDef(this, "controllers.expediente.ExpedientesMisPasesController", "index", Nil,"GET", """""", Routes.prefix + """expediente/expedienteMisPases"""))
   }
}
        

// @LINE:481
case controllers_expediente_ExpedientesAccionesController_asignarAMiServicioMasivo396(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesAccionesController.asignarAMiServicioMasivo(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "asignarAMiServicioMasivo", Nil,"POST", """""", Routes.prefix + """expediente/acciones/asignarMiServicioMasivo"""))
   }
}
        

// @LINE:482
case controllers_expediente_ExpedientesAccionesController_modalAsignarMiServicio397(params) => {
   call { 
        invokeHandler(controllers.expediente.ExpedientesAccionesController.modalAsignarMiServicio(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "modalAsignarMiServicio", Nil,"GET", """""", Routes.prefix + """expediente/acciones/modalAsignarMiServicio"""))
   }
}
        

// @LINE:484
case controllers_expediente_DisposController_index398(params) => {
   call { 
        invokeHandler(controllers.expediente.DisposController.index(), HandlerDef(this, "controllers.expediente.DisposController", "index", Nil,"GET", """""", Routes.prefix + """expediente/dispo"""))
   }
}
        

// @LINE:485
case controllers_expediente_DisposController_crear399(params) => {
   call { 
        invokeHandler(controllers.expediente.DisposController.crear(), HandlerDef(this, "controllers.expediente.DisposController", "crear", Nil,"GET", """""", Routes.prefix + """expediente/dispo/crear"""))
   }
}
        

// @LINE:486
case controllers_expediente_DisposController_guardar400(params) => {
   call { 
        invokeHandler(controllers.expediente.DisposController.guardar(), HandlerDef(this, "controllers.expediente.DisposController", "guardar", Nil,"POST", """""", Routes.prefix + """expediente/dispo/guardar"""))
   }
}
        

// @LINE:487
case controllers_expediente_DisposController_editar401(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.DisposController.editar(id), HandlerDef(this, "controllers.expediente.DisposController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/dispo/editar"""))
   }
}
        

// @LINE:488
case controllers_expediente_DisposController_actualizar402(params) => {
   call { 
        invokeHandler(controllers.expediente.DisposController.actualizar(), HandlerDef(this, "controllers.expediente.DisposController", "actualizar", Nil,"POST", """""", Routes.prefix + """expediente/dispo/actualizar"""))
   }
}
        

// @LINE:489
case controllers_expediente_DisposController_eliminar403(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.DisposController.eliminar(id), HandlerDef(this, "controllers.expediente.DisposController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/dispo/eliminar"""))
   }
}
        

// @LINE:490
case controllers_expediente_DisposController_ver404(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.expediente.DisposController.ver(id), HandlerDef(this, "controllers.expediente.DisposController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/dispo/ver"""))
   }
}
        

// @LINE:491
case controllers_expediente_DisposController_getLastNumeroDispo405(params) => {
   call { 
        invokeHandler(controllers.expediente.DisposController.getLastNumeroDispo(), HandlerDef(this, "controllers.expediente.DisposController", "getLastNumeroDispo", Nil,"POST", """""", Routes.prefix + """expediente/dispo/getLastNumeroDispo"""))
   }
}
        

// @LINE:492
case controllers_expediente_DisposController_getLastNumeroDispoByOrden406(params) => {
   call { 
        invokeHandler(controllers.expediente.DisposController.getLastNumeroDispoByOrden(), HandlerDef(this, "controllers.expediente.DisposController", "getLastNumeroDispoByOrden", Nil,"POST", """""", Routes.prefix + """expediente/dispo/getLastNumeroDispoByOrden"""))
   }
}
        

// @LINE:493
case controllers_expediente_DisposController_getDisposPorExpediente407(params) => {
   call(params.fromQuery[Long]("expedienteId", Some(0))) { (expedienteId) =>
        invokeHandler(controllers.expediente.DisposController.getDisposPorExpediente(expedienteId), HandlerDef(this, "controllers.expediente.DisposController", "getDisposPorExpediente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """expediente/dispo/getDisposPorExpediente"""))
   }
}
        

// @LINE:494
case controllers_expediente_DisposController_cambiarEstado408(params) => {
   call(params.fromQuery[Long]("idDispo", None), params.fromQuery[Long]("idEstado", None)) { (idDispo, idEstado) =>
        invokeHandler(controllers.expediente.DisposController.cambiarEstado(idDispo, idEstado), HandlerDef(this, "controllers.expediente.DisposController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """expediente/dispo/cambiarEstado"""))
   }
}
        

// @LINE:498
case controllers_rrhh_IndexController_index409(params) => {
   call { 
        invokeHandler(controllers.rrhh.IndexController.index(), HandlerDef(this, "controllers.rrhh.IndexController", "index", Nil,"GET", """-----------------------------MODULO RRHH ---------------------------------""", Routes.prefix + """rrhh"""))
   }
}
        

// @LINE:499
case controllers_rrhh_DepartamentosController_modalBuscar410(params) => {
   call { 
        invokeHandler(controllers.rrhh.DepartamentosController.modalBuscar(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """rrhh/departamento/modalBuscar"""))
   }
}
        

// @LINE:500
case controllers_rrhh_DepartamentosController_get411(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.rrhh.DepartamentosController.get(id), HandlerDef(this, "controllers.rrhh.DepartamentosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """rrhh/departamento/get"""))
   }
}
        

// @LINE:501
case controllers_rrhh_AgentesEstudiosController_index412(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.rrhh.AgentesEstudiosController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """rrhh/agente-estudio/index"""))
   }
}
        

// @LINE:502
case controllers_rrhh_AgentesEstudiosController_crear413(params) => {
   call(params.fromQuery[String]("agenteId", None)) { (agenteId) =>
        invokeHandler(controllers.rrhh.AgentesEstudiosController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """rrhh/agente-estudio/crear"""))
   }
}
        

// @LINE:503
case controllers_rrhh_AgentesEstudiosController_editar414(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesEstudiosController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-estudio/editar"""))
   }
}
        

// @LINE:504
case controllers_rrhh_AgentesEstudiosController_guardar415(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesEstudiosController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "guardar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-estudio/guardar"""))
   }
}
        

// @LINE:505
case controllers_rrhh_AgentesEstudiosController_actualizar416(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesEstudiosController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "actualizar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-estudio/actualizar"""))
   }
}
        

// @LINE:506
case controllers_rrhh_AgentesEstudiosController_eliminar417(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesEstudiosController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-estudio/eliminar"""))
   }
}
        

// @LINE:507
case controllers_rrhh_AgentesEstudiosController_listOptionsEstudioSubareas418(params) => {
   call(params.fromQuery[Int]("estudioAreaId", Some(0))) { (estudioAreaId) =>
        invokeHandler(controllers.rrhh.AgentesEstudiosController.listOptionsEstudioSubareas(estudioAreaId), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "listOptionsEstudioSubareas", Seq(classOf[Int]),"GET", """""", Routes.prefix + """rrhh/agente-estudio/listOptionsSubarea"""))
   }
}
        

// @LINE:509
case controllers_rrhh_AgentesRulController_index419(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.rrhh.AgentesRulController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesRulController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """rrhh/agente-rul/index"""))
   }
}
        

// @LINE:510
case controllers_rrhh_AgentesRulController_crear420(params) => {
   call(params.fromQuery[String]("agenteId", None)) { (agenteId) =>
        invokeHandler(controllers.rrhh.AgentesRulController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesRulController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """rrhh/agente-rul/crear"""))
   }
}
        

// @LINE:511
case controllers_rrhh_AgentesRulController_editar421(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesRulController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesRulController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-rul/editar"""))
   }
}
        

// @LINE:512
case controllers_rrhh_AgentesRulController_guardar422(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesRulController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesRulController", "guardar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-rul/guardar"""))
   }
}
        

// @LINE:513
case controllers_rrhh_AgentesRulController_actualizar423(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesRulController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesRulController", "actualizar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-rul/actualizar"""))
   }
}
        

// @LINE:514
case controllers_rrhh_AgentesRulController_eliminar424(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesRulController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesRulController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-rul/eliminar"""))
   }
}
        

// @LINE:516
case controllers_rrhh_AgentesNovedadesController_index425(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.rrhh.AgentesNovedadesController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """rrhh/agente-novedad/index"""))
   }
}
        

// @LINE:517
case controllers_rrhh_AgentesNovedadesController_crear426(params) => {
   call(params.fromQuery[String]("agenteId", None)) { (agenteId) =>
        invokeHandler(controllers.rrhh.AgentesNovedadesController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """rrhh/agente-novedad/crear"""))
   }
}
        

// @LINE:518
case controllers_rrhh_AgentesNovedadesController_editar427(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesNovedadesController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-novedad/editar"""))
   }
}
        

// @LINE:519
case controllers_rrhh_AgentesNovedadesController_guardar428(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesNovedadesController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "guardar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-novedad/guardar"""))
   }
}
        

// @LINE:520
case controllers_rrhh_AgentesNovedadesController_actualizar429(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesNovedadesController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "actualizar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-novedad/actualizar"""))
   }
}
        

// @LINE:521
case controllers_rrhh_AgentesNovedadesController_eliminar430(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesNovedadesController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-novedad/eliminar"""))
   }
}
        

// @LINE:523
case controllers_rrhh_AgentesHijosController_index431(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.rrhh.AgentesHijosController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """rrhh/agente-hijo/index"""))
   }
}
        

// @LINE:524
case controllers_rrhh_AgentesHijosController_crear432(params) => {
   call(params.fromQuery[String]("agenteId", None)) { (agenteId) =>
        invokeHandler(controllers.rrhh.AgentesHijosController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """rrhh/agente-hijo/crear"""))
   }
}
        

// @LINE:525
case controllers_rrhh_AgentesHijosController_editar433(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesHijosController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-hijo/editar"""))
   }
}
        

// @LINE:526
case controllers_rrhh_AgentesHijosController_guardar434(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesHijosController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "guardar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-hijo/guardar"""))
   }
}
        

// @LINE:527
case controllers_rrhh_AgentesHijosController_actualizar435(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesHijosController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "actualizar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-hijo/actualizar"""))
   }
}
        

// @LINE:528
case controllers_rrhh_AgentesHijosController_eliminar436(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesHijosController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-hijo/eliminar"""))
   }
}
        

// @LINE:530
case controllers_rrhh_AgentesFamiliasController_index437(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.rrhh.AgentesFamiliasController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """rrhh/agente-familia/index"""))
   }
}
        

// @LINE:531
case controllers_rrhh_AgentesFamiliasController_crear438(params) => {
   call(params.fromQuery[String]("agenteId", None)) { (agenteId) =>
        invokeHandler(controllers.rrhh.AgentesFamiliasController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """rrhh/agente-familia/crear"""))
   }
}
        

// @LINE:532
case controllers_rrhh_AgentesFamiliasController_editar439(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesFamiliasController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-familia/editar"""))
   }
}
        

// @LINE:533
case controllers_rrhh_AgentesFamiliasController_guardar440(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesFamiliasController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "guardar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-familia/guardar"""))
   }
}
        

// @LINE:534
case controllers_rrhh_AgentesFamiliasController_actualizar441(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesFamiliasController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "actualizar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-familia/actualizar"""))
   }
}
        

// @LINE:535
case controllers_rrhh_AgentesFamiliasController_eliminar442(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesFamiliasController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-familia/eliminar"""))
   }
}
        

// @LINE:537
case controllers_rrhh_DepartamentosController_indexDepartamento443(params) => {
   call { 
        invokeHandler(controllers.rrhh.DepartamentosController.indexDepartamento(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "indexDepartamento", Nil,"GET", """""", Routes.prefix + """rrhh/departamento"""))
   }
}
        

// @LINE:538
case controllers_rrhh_DepartamentosController_crearDepartamento444(params) => {
   call { 
        invokeHandler(controllers.rrhh.DepartamentosController.crearDepartamento(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "crearDepartamento", Nil,"GET", """""", Routes.prefix + """rrhh/departamento/crear"""))
   }
}
        

// @LINE:539
case controllers_rrhh_DepartamentosController_guardarDepartamento445(params) => {
   call { 
        invokeHandler(controllers.rrhh.DepartamentosController.guardarDepartamento(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "guardarDepartamento", Nil,"POST", """""", Routes.prefix + """rrhh/departamento/guardar"""))
   }
}
        

// @LINE:540
case controllers_rrhh_DepartamentosController_editarDepartamento446(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.DepartamentosController.editarDepartamento(id), HandlerDef(this, "controllers.rrhh.DepartamentosController", "editarDepartamento", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/departamento/editar"""))
   }
}
        

// @LINE:541
case controllers_rrhh_DepartamentosController_eliminarDepartamento447(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.DepartamentosController.eliminarDepartamento(id), HandlerDef(this, "controllers.rrhh.DepartamentosController", "eliminarDepartamento", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/departamento/eliminar"""))
   }
}
        

// @LINE:542
case controllers_rrhh_DepartamentosController_actualizarDepartamento448(params) => {
   call { 
        invokeHandler(controllers.rrhh.DepartamentosController.actualizarDepartamento(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "actualizarDepartamento", Nil,"POST", """""", Routes.prefix + """rrhh/departamento/actualizar"""))
   }
}
        

// @LINE:544
case controllers_rrhh_EspecialidadesController_indexEspecialidad449(params) => {
   call { 
        invokeHandler(controllers.rrhh.EspecialidadesController.indexEspecialidad(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "indexEspecialidad", Nil,"GET", """""", Routes.prefix + """rrhh/especialidad"""))
   }
}
        

// @LINE:545
case controllers_rrhh_EspecialidadesController_crearEspecialidad450(params) => {
   call { 
        invokeHandler(controllers.rrhh.EspecialidadesController.crearEspecialidad(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "crearEspecialidad", Nil,"GET", """""", Routes.prefix + """rrhh/especialidad/crear"""))
   }
}
        

// @LINE:546
case controllers_rrhh_EspecialidadesController_guardarEspecialidad451(params) => {
   call { 
        invokeHandler(controllers.rrhh.EspecialidadesController.guardarEspecialidad(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "guardarEspecialidad", Nil,"POST", """""", Routes.prefix + """rrhh/especialidad/guardar"""))
   }
}
        

// @LINE:547
case controllers_rrhh_EspecialidadesController_editarEspecialidad452(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.EspecialidadesController.editarEspecialidad(id), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "editarEspecialidad", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/especialidad/editar"""))
   }
}
        

// @LINE:548
case controllers_rrhh_EspecialidadesController_eliminarEspecialidad453(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.EspecialidadesController.eliminarEspecialidad(id), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "eliminarEspecialidad", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/especialidad/eliminar"""))
   }
}
        

// @LINE:549
case controllers_rrhh_EspecialidadesController_actualizarEspecialidad454(params) => {
   call { 
        invokeHandler(controllers.rrhh.EspecialidadesController.actualizarEspecialidad(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "actualizarEspecialidad", Nil,"POST", """""", Routes.prefix + """rrhh/especialidad/actualizar"""))
   }
}
        

// @LINE:550
case controllers_rrhh_EspecialidadesController_modalBuscar455(params) => {
   call { 
        invokeHandler(controllers.rrhh.EspecialidadesController.modalBuscar(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """rrhh/especialidad/modalBuscar"""))
   }
}
        

// @LINE:551
case controllers_rrhh_EspecialidadesController_get456(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.rrhh.EspecialidadesController.get(id), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """rrhh/especialidad/get"""))
   }
}
        

// @LINE:553
case controllers_rrhh_ProfesionesController_modalBuscar457(params) => {
   call { 
        invokeHandler(controllers.rrhh.ProfesionesController.modalBuscar(), HandlerDef(this, "controllers.rrhh.ProfesionesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """rrhh/profesion/modalBuscar"""))
   }
}
        

// @LINE:554
case controllers_rrhh_ProfesionesController_get458(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.rrhh.ProfesionesController.get(id), HandlerDef(this, "controllers.rrhh.ProfesionesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """rrhh/profesion/get"""))
   }
}
        

// @LINE:556
case controllers_rrhh_CiesController_modalBuscar459(params) => {
   call { 
        invokeHandler(controllers.rrhh.CiesController.modalBuscar(), HandlerDef(this, "controllers.rrhh.CiesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """rrhh/cie/modalBuscar"""))
   }
}
        

// @LINE:557
case controllers_rrhh_CiesController_get460(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.rrhh.CiesController.get(id), HandlerDef(this, "controllers.rrhh.CiesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """rrhh/cie/get"""))
   }
}
        

// @LINE:559
case controllers_rrhh_TipoResidenciasController_modalBuscar461(params) => {
   call { 
        invokeHandler(controllers.rrhh.TipoResidenciasController.modalBuscar(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """rrhh/tipoResidencia/modalBuscar"""))
   }
}
        

// @LINE:560
case controllers_rrhh_TipoResidenciasController_get462(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.rrhh.TipoResidenciasController.get(id), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """rrhh/tipoResidencia/get"""))
   }
}
        

// @LINE:561
case controllers_rrhh_TipoResidenciasController_indexTipoResidencia463(params) => {
   call { 
        invokeHandler(controllers.rrhh.TipoResidenciasController.indexTipoResidencia(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "indexTipoResidencia", Nil,"GET", """""", Routes.prefix + """rrhh/tipoResidencia"""))
   }
}
        

// @LINE:562
case controllers_rrhh_TipoResidenciasController_crearTipoResidencia464(params) => {
   call { 
        invokeHandler(controllers.rrhh.TipoResidenciasController.crearTipoResidencia(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "crearTipoResidencia", Nil,"GET", """""", Routes.prefix + """rrhh/tipoResidencia/crear"""))
   }
}
        

// @LINE:563
case controllers_rrhh_TipoResidenciasController_guardarTipoResidencia465(params) => {
   call { 
        invokeHandler(controllers.rrhh.TipoResidenciasController.guardarTipoResidencia(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "guardarTipoResidencia", Nil,"POST", """""", Routes.prefix + """rrhh/tipoResidencia/guardar"""))
   }
}
        

// @LINE:564
case controllers_rrhh_TipoResidenciasController_editarTipoResidencia466(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.TipoResidenciasController.editarTipoResidencia(id), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "editarTipoResidencia", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/tipoResidencia/editar"""))
   }
}
        

// @LINE:565
case controllers_rrhh_TipoResidenciasController_eliminarTipoResidencia467(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.TipoResidenciasController.eliminarTipoResidencia(id), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "eliminarTipoResidencia", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/tipoResidencia/eliminar"""))
   }
}
        

// @LINE:566
case controllers_rrhh_TipoResidenciasController_actualizarTipoResidencia468(params) => {
   call { 
        invokeHandler(controllers.rrhh.TipoResidenciasController.actualizarTipoResidencia(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "actualizarTipoResidencia", Nil,"POST", """""", Routes.prefix + """rrhh/tipoResidencia/actualizar"""))
   }
}
        

// @LINE:567
case controllers_rrhh_TipoResidenciasController_ver469(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.TipoResidenciasController.ver(id), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/tipoResidencia/ver"""))
   }
}
        

// @LINE:569
case controllers_rrhh_PuestosController_indexPuesto470(params) => {
   call { 
        invokeHandler(controllers.rrhh.PuestosController.indexPuesto(), HandlerDef(this, "controllers.rrhh.PuestosController", "indexPuesto", Nil,"GET", """""", Routes.prefix + """rrhh/puesto"""))
   }
}
        

// @LINE:570
case controllers_rrhh_PuestosController_crearPuesto471(params) => {
   call { 
        invokeHandler(controllers.rrhh.PuestosController.crearPuesto(), HandlerDef(this, "controllers.rrhh.PuestosController", "crearPuesto", Nil,"GET", """""", Routes.prefix + """rrhh/puesto/crear"""))
   }
}
        

// @LINE:571
case controllers_rrhh_PuestosController_guardarPuesto472(params) => {
   call { 
        invokeHandler(controllers.rrhh.PuestosController.guardarPuesto(), HandlerDef(this, "controllers.rrhh.PuestosController", "guardarPuesto", Nil,"POST", """""", Routes.prefix + """rrhh/puesto/guardar"""))
   }
}
        

// @LINE:572
case controllers_rrhh_PuestosController_editarPuesto473(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.PuestosController.editarPuesto(id), HandlerDef(this, "controllers.rrhh.PuestosController", "editarPuesto", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/puesto/editar"""))
   }
}
        

// @LINE:573
case controllers_rrhh_PuestosController_eliminarPuesto474(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.PuestosController.eliminarPuesto(id), HandlerDef(this, "controllers.rrhh.PuestosController", "eliminarPuesto", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/puesto/eliminar"""))
   }
}
        

// @LINE:574
case controllers_rrhh_PuestosController_actualizarPuesto475(params) => {
   call { 
        invokeHandler(controllers.rrhh.PuestosController.actualizarPuesto(), HandlerDef(this, "controllers.rrhh.PuestosController", "actualizarPuesto", Nil,"POST", """""", Routes.prefix + """rrhh/puesto/actualizar"""))
   }
}
        

// @LINE:575
case controllers_rrhh_PuestosController_modalBuscar476(params) => {
   call { 
        invokeHandler(controllers.rrhh.PuestosController.modalBuscar(), HandlerDef(this, "controllers.rrhh.PuestosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """rrhh/puesto/modalBuscar"""))
   }
}
        

// @LINE:576
case controllers_rrhh_PuestosController_get477(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.rrhh.PuestosController.get(id), HandlerDef(this, "controllers.rrhh.PuestosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """rrhh/puesto/get"""))
   }
}
        

// @LINE:578
case controllers_rrhh_AgentesController_indexAgente478(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesController.indexAgente(), HandlerDef(this, "controllers.rrhh.AgentesController", "indexAgente", Nil,"GET", """""", Routes.prefix + """rrhh/agente"""))
   }
}
        

// @LINE:579
case controllers_rrhh_AgentesController_crearAgente479(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesController.crearAgente(), HandlerDef(this, "controllers.rrhh.AgentesController", "crearAgente", Nil,"GET", """""", Routes.prefix + """rrhh/agente/crear"""))
   }
}
        

// @LINE:580
case controllers_rrhh_AgentesController_guardarAgente480(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesController.guardarAgente(), HandlerDef(this, "controllers.rrhh.AgentesController", "guardarAgente", Nil,"POST", """""", Routes.prefix + """rrhh/agente/guardar"""))
   }
}
        

// @LINE:581
case controllers_rrhh_AgentesController_editarAgente481(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesController.editarAgente(id), HandlerDef(this, "controllers.rrhh.AgentesController", "editarAgente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente/editar"""))
   }
}
        

// @LINE:582
case controllers_rrhh_AgentesController_eliminarAgente482(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesController.eliminarAgente(id), HandlerDef(this, "controllers.rrhh.AgentesController", "eliminarAgente", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente/eliminar"""))
   }
}
        

// @LINE:583
case controllers_rrhh_AgentesController_actualizarAgente483(params) => {
   call(params.fromQuery[Long]("agenteId", None)) { (agenteId) =>
        invokeHandler(controllers.rrhh.AgentesController.actualizarAgente(agenteId), HandlerDef(this, "controllers.rrhh.AgentesController", "actualizarAgente", Seq(classOf[Long]),"POST", """""", Routes.prefix + """rrhh/agente/actualizar"""))
   }
}
        

// @LINE:584
case controllers_rrhh_AgentesController_modalBuscar484(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesController.modalBuscar(), HandlerDef(this, "controllers.rrhh.AgentesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """rrhh/agente/modalBuscar"""))
   }
}
        

// @LINE:585
case controllers_rrhh_AgentesController_get485(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.rrhh.AgentesController.get(id), HandlerDef(this, "controllers.rrhh.AgentesController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente/get"""))
   }
}
        

// @LINE:586
case controllers_rrhh_AgentesController_ver486(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesController.ver(id), HandlerDef(this, "controllers.rrhh.AgentesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente/ver"""))
   }
}
        

// @LINE:587
case controllers_rrhh_AgentesAccionesController_modalReplicarProveedor487(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesAccionesController.modalReplicarProveedor(id), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalReplicarProveedor", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente/modalReplicarProveedor"""))
   }
}
        

// @LINE:588
case controllers_rrhh_AgentesAccionesController_replicarProveedor488(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.replicarProveedor(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "replicarProveedor", Nil,"POST", """""", Routes.prefix + """rrhh/agente/replicarProveedor"""))
   }
}
        

// @LINE:589
case controllers_rrhh_AgentesController_cambiarEstado489(params) => {
   call(params.fromQuery[Long]("idAgente", None), params.fromQuery[Long]("idEstado", None)) { (idAgente, idEstado) =>
        invokeHandler(controllers.rrhh.AgentesController.cambiarEstado(idAgente, idEstado), HandlerDef(this, "controllers.rrhh.AgentesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente/cambiar-estado"""))
   }
}
        

// @LINE:591
case controllers_rrhh_AgentesAccionesController_modalPasarAAprobado490(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.modalPasarAAprobado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarAAprobado", Nil,"GET", """""", Routes.prefix + """rrhh/agente/modalPasarAAprobado"""))
   }
}
        

// @LINE:592
case controllers_rrhh_AgentesAccionesController_pasarAAprobado491(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.pasarAAprobado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarAAprobado", Nil,"POST", """""", Routes.prefix + """rrhh/agente/pasarAAprobado"""))
   }
}
        

// @LINE:593
case controllers_rrhh_AgentesAccionesController_modalPasarABorrador492(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.modalPasarABorrador(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarABorrador", Nil,"GET", """""", Routes.prefix + """rrhh/agente/modalPasarABorrador"""))
   }
}
        

// @LINE:594
case controllers_rrhh_AgentesAccionesController_pasarABorrador493(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.pasarABorrador(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarABorrador", Nil,"POST", """""", Routes.prefix + """rrhh/agente/pasarABorrador"""))
   }
}
        

// @LINE:595
case controllers_rrhh_AgentesAccionesController_modalPasarACancelado494(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.modalPasarACancelado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarACancelado", Nil,"GET", """""", Routes.prefix + """rrhh/agente/modalPasarACancelado"""))
   }
}
        

// @LINE:596
case controllers_rrhh_AgentesAccionesController_pasarACancelado495(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.pasarACancelado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarACancelado", Nil,"POST", """""", Routes.prefix + """rrhh/agente/pasarACancelado"""))
   }
}
        

// @LINE:597
case controllers_rrhh_AgentesAccionesController_modalPasarACargado496(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.modalPasarACargado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarACargado", Nil,"GET", """""", Routes.prefix + """rrhh/agente/modalPasarACargado"""))
   }
}
        

// @LINE:598
case controllers_rrhh_AgentesAccionesController_pasarACargado497(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.pasarACargado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarACargado", Nil,"POST", """""", Routes.prefix + """rrhh/agente/pasarACargado"""))
   }
}
        

// @LINE:599
case controllers_rrhh_AgentesAccionesController_modalPasarAPreaprobado498(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.modalPasarAPreaprobado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarAPreaprobado", Nil,"GET", """""", Routes.prefix + """rrhh/agente/modalPasarAPreaprobado"""))
   }
}
        

// @LINE:600
case controllers_rrhh_AgentesAccionesController_pasarAPreaprobado499(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAccionesController.pasarAPreaprobado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarAPreaprobado", Nil,"POST", """""", Routes.prefix + """rrhh/agente/pasarAPreaprobado"""))
   }
}
        

// @LINE:602
case controllers_rrhh_AgentesController_actualizarMail500(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesController.actualizarMail(), HandlerDef(this, "controllers.rrhh.AgentesController", "actualizarMail", Nil,"POST", """""", Routes.prefix + """rrhh/agente/actualizarMail"""))
   }
}
        

// @LINE:605
case controllers_rrhh_NovedadesController_index501(params) => {
   call { 
        invokeHandler(controllers.rrhh.NovedadesController.index(), HandlerDef(this, "controllers.rrhh.NovedadesController", "index", Nil,"GET", """""", Routes.prefix + """rrhh/novedades"""))
   }
}
        

// @LINE:606
case controllers_rrhh_NovedadesController_ver502(params) => {
   call(params.fromQuery[Long]("id", Some(0))) { (id) =>
        invokeHandler(controllers.rrhh.NovedadesController.ver(id), HandlerDef(this, "controllers.rrhh.NovedadesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/novedades/ver"""))
   }
}
        

// @LINE:607
case controllers_rrhh_NovedadesController_eliminar503(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.NovedadesController.eliminar(id), HandlerDef(this, "controllers.rrhh.NovedadesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/novedades/eliminar"""))
   }
}
        

// @LINE:608
case controllers_rrhh_NovedadesController_crear504(params) => {
   call { 
        invokeHandler(controllers.rrhh.NovedadesController.crear(), HandlerDef(this, "controllers.rrhh.NovedadesController", "crear", Nil,"GET", """""", Routes.prefix + """rrhh/novedades/crear"""))
   }
}
        

// @LINE:609
case controllers_rrhh_NovedadesController_guardar505(params) => {
   call { 
        invokeHandler(controllers.rrhh.NovedadesController.guardar(), HandlerDef(this, "controllers.rrhh.NovedadesController", "guardar", Nil,"POST", """""", Routes.prefix + """rrhh/novedades/guardar"""))
   }
}
        

// @LINE:610
case controllers_rrhh_NovedadesController_editar506(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.NovedadesController.editar(id), HandlerDef(this, "controllers.rrhh.NovedadesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/novedades/editar"""))
   }
}
        

// @LINE:611
case controllers_rrhh_NovedadesController_actualizar507(params) => {
   call { 
        invokeHandler(controllers.rrhh.NovedadesController.actualizar(), HandlerDef(this, "controllers.rrhh.NovedadesController", "actualizar", Nil,"POST", """""", Routes.prefix + """rrhh/novedades/actualizar"""))
   }
}
        

// @LINE:612
case controllers_rrhh_NovedadesController_lista508(params) => {
   call { 
        invokeHandler(controllers.rrhh.NovedadesController.lista(), HandlerDef(this, "controllers.rrhh.NovedadesController", "lista", Nil,"GET", """""", Routes.prefix + """rrhh/novedades/lista"""))
   }
}
        

// @LINE:613
case controllers_rrhh_NovedadesController_getFeriados509(params) => {
   call { 
        invokeHandler(controllers.rrhh.NovedadesController.getFeriados(), HandlerDef(this, "controllers.rrhh.NovedadesController", "getFeriados", Nil,"GET", """""", Routes.prefix + """rrhh/novedades/feriados"""))
   }
}
        

// @LINE:615
case controllers_rrhh_AgentesReportesController_ficha510(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesReportesController.ficha(id), HandlerDef(this, "controllers.rrhh.AgentesReportesController", "ficha", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente/reportes/ficha"""))
   }
}
        

// @LINE:616
case controllers_rrhh_AgentesReportesController_fichaAptitud511(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesReportesController.fichaAptitud(id), HandlerDef(this, "controllers.rrhh.AgentesReportesController", "fichaAptitud", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente/reportes/fichaAptitud"""))
   }
}
        

// @LINE:617
case controllers_rrhh_AgentesReportesController_reportesDatosAgente512(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesReportesController.reportesDatosAgente(), HandlerDef(this, "controllers.rrhh.AgentesReportesController", "reportesDatosAgente", Nil,"POST", """""", Routes.prefix + """rrhh/agente/reportes/reportesDatosAgente"""))
   }
}
        

// @LINE:618
case controllers_rrhh_AgentesReportesController_reportesCertificacionesAgente513(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesReportesController.reportesCertificacionesAgente(), HandlerDef(this, "controllers.rrhh.AgentesReportesController", "reportesCertificacionesAgente", Nil,"POST", """""", Routes.prefix + """rrhh/agente/reportes/reportesCertificacionesAgente"""))
   }
}
        

// @LINE:620
case controllers_rrhh_AgentesAsistenciasController_index514(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasController.index(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasController", "index", Nil,"GET", """""", Routes.prefix + """rrhh/agenteAsistencia/index"""))
   }
}
        

// @LINE:621
case controllers_rrhh_AgentesAsistenciasController_editar515(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesAsistenciasController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agenteAsistencia/editar"""))
   }
}
        

// @LINE:622
case controllers_rrhh_AgentesAsistenciasController_ver516(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Long]("tipoLicencia", Some(0))) { (id, tipoLicencia) =>
        invokeHandler(controllers.rrhh.AgentesAsistenciasController.ver(id, tipoLicencia), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasController", "ver", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agenteAsistencia/ver"""))
   }
}
        

// @LINE:624
case controllers_rrhh_AgentesAsistenciasLicenciasController_index517(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false)), params.fromQuery[Long]("tipoLicencia", Some(0))) { (id, editable, tipoLicencia) =>
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.index(id, editable, tipoLicencia), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "index", Seq(classOf[Long], classOf[Boolean], classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/index"""))
   }
}
        

// @LINE:625
case controllers_rrhh_AgentesAsistenciasLicenciasController_crear518(params) => {
   call(params.fromQuery[String]("agenteId", None)) { (agenteId) =>
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/crear"""))
   }
}
        

// @LINE:626
case controllers_rrhh_AgentesAsistenciasLicenciasController_editar519(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/editar"""))
   }
}
        

// @LINE:627
case controllers_rrhh_AgentesAsistenciasLicenciasController_guardar520(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "guardar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-asistencia-licencian/guardar"""))
   }
}
        

// @LINE:628
case controllers_rrhh_AgentesAsistenciasLicenciasController_actualizar521(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "actualizar", Nil,"POST", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/actualizar"""))
   }
}
        

// @LINE:629
case controllers_rrhh_AgentesAsistenciasLicenciasController_eliminar522(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/eliminar"""))
   }
}
        

// @LINE:631
case controllers_rrhh_AgentesAsistenciasLicenciasController_modalPasarBorrador523(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarBorrador(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "modalPasarBorrador", Nil,"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/modalPasarBorrador"""))
   }
}
        

// @LINE:632
case controllers_rrhh_AgentesAsistenciasLicenciasController_pasarBorradorMasivo524(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.pasarBorradorMasivo(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "pasarBorradorMasivo", Nil,"POST", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/pasarBorradorMasivo"""))
   }
}
        

// @LINE:633
case controllers_rrhh_AgentesAsistenciasLicenciasController_modalPasarCancelado525(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarCancelado(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "modalPasarCancelado", Nil,"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/modalPasarCancelado"""))
   }
}
        

// @LINE:634
case controllers_rrhh_AgentesAsistenciasLicenciasController_pasarCanceladoMasivo526(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "pasarCanceladoMasivo", Nil,"POST", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/pasarCanceladoMasivo"""))
   }
}
        

// @LINE:635
case controllers_rrhh_AgentesAsistenciasLicenciasController_modalPasarPreAprobado527(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarPreAprobado(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "modalPasarPreAprobado", Nil,"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/modalPasarPreAprobado"""))
   }
}
        

// @LINE:636
case controllers_rrhh_AgentesAsistenciasLicenciasController_pasarPreAprobadoMasivo528(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.pasarPreAprobadoMasivo(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "pasarPreAprobadoMasivo", Nil,"POST", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/pasarPreAprobadoMasivo"""))
   }
}
        

// @LINE:637
case controllers_rrhh_AgentesAsistenciasLicenciasController_modalPasarAprobado529(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarAprobado(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "modalPasarAprobado", Nil,"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/modalPasarAprobado"""))
   }
}
        

// @LINE:638
case controllers_rrhh_AgentesAsistenciasLicenciasController_pasarAprobadoMasivo530(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.pasarAprobadoMasivo(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "pasarAprobadoMasivo", Nil,"POST", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/pasarAprobadoMasivo"""))
   }
}
        

// @LINE:640
case controllers_rrhh_AgentesAsistenciasLicenciasController_resumen531(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.resumen(id, editable), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "resumen", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/resumen"""))
   }
}
        

// @LINE:642
case controllers_rrhh_AgentesAsistenciasLicenciasController_getListaLicenciasPendientes532(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.getListaLicenciasPendientes(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "getListaLicenciasPendientes", Nil,"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/getListaLicenciasPendientes"""))
   }
}
        

// @LINE:643
case controllers_rrhh_AgentesAsistenciasLicenciasController_getListaLicenciasEnFecha533(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasLicenciasController.getListaLicenciasEnFecha(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "getListaLicenciasEnFecha", Nil,"GET", """""", Routes.prefix + """rrhh/agente-asistencia-licencia/getListaLicenciasEnFecha"""))
   }
}
        

// @LINE:645
case controllers_rrhh_AgentesAsistenciasReportesController_reporteLicencia534(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasReportesController.reporteLicencia(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasReportesController", "reporteLicencia", Nil,"POST", """""", Routes.prefix + """rrhh/agenteAsistencia/reporteLicencia"""))
   }
}
        

// @LINE:646
case controllers_rrhh_AgentesAsistenciasReportesController_reporteLicenciaMedicinaLaboral535(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesAsistenciasReportesController.reporteLicenciaMedicinaLaboral(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasReportesController", "reporteLicenciaMedicinaLaboral", Nil,"POST", """""", Routes.prefix + """rrhh/agenteAsistencia/reporteLicenciaMedicinaLaboral"""))
   }
}
        

// @LINE:648
case controllers_rrhh_AgentesSeguimientoController_index536(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesSeguimientoController.index(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "index", Nil,"GET", """""", Routes.prefix + """rrhh/agenteSeguimiento/index"""))
   }
}
        

// @LINE:649
case controllers_rrhh_AgentesSeguimientoController_ver537(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesSeguimientoController.ver(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agenteSeguimiento/ver"""))
   }
}
        

// @LINE:651
case controllers_rrhh_AgentesSeguimientoController_crearAgenteSeguimiento538(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesSeguimientoController.crearAgenteSeguimiento(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "crearAgenteSeguimiento", Nil,"GET", """""", Routes.prefix + """rrhh/agenteSeguimiento/crear"""))
   }
}
        

// @LINE:652
case controllers_rrhh_AgentesSeguimientoController_guardarAgenteSeguimiento539(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesSeguimientoController.guardarAgenteSeguimiento(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "guardarAgenteSeguimiento", Nil,"POST", """""", Routes.prefix + """rrhh/agenteSeguimiento/guardar"""))
   }
}
        

// @LINE:653
case controllers_rrhh_AgentesSeguimientoController_editarAgenteSeguimiento540(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesSeguimientoController.editarAgenteSeguimiento(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "editarAgenteSeguimiento", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agenteSeguimiento/editar"""))
   }
}
        

// @LINE:654
case controllers_rrhh_AgentesSeguimientoController_actualizarAgenteSeguimiento541(params) => {
   call(params.fromQuery[Long]("agenteId", None)) { (agenteId) =>
        invokeHandler(controllers.rrhh.AgentesSeguimientoController.actualizarAgenteSeguimiento(agenteId), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "actualizarAgenteSeguimiento", Seq(classOf[Long]),"POST", """""", Routes.prefix + """rrhh/agenteSeguimiento/actualizar"""))
   }
}
        

// @LINE:655
case controllers_rrhh_AgentesSeguimientoController_eliminarAgenteSeguimiento542(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesSeguimientoController.eliminarAgenteSeguimiento(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "eliminarAgenteSeguimiento", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agenteSeguimiento/eliminar"""))
   }
}
        

// @LINE:656
case controllers_rrhh_AgentesSeguimientoController_cambiarEstado543(params) => {
   call(params.fromQuery[Long]("idSeguimiento", None), params.fromQuery[Long]("idEstado", None)) { (idSeguimiento, idEstado) =>
        invokeHandler(controllers.rrhh.AgentesSeguimientoController.cambiarEstado(idSeguimiento, idEstado), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """rrhh/agenteSeguimiento/cambiarEstado"""))
   }
}
        

// @LINE:658
case controllers_rrhh_AgentesSeguimientoLineasController_index544(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.rrhh.AgentesSeguimientoLineasController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """rrhh/seguimiento-linea/index"""))
   }
}
        

// @LINE:659
case controllers_rrhh_AgentesSeguimientoLineasController_crear545(params) => {
   call(params.fromQuery[String]("seguimientoId", None)) { (seguimientoId) =>
        invokeHandler(controllers.rrhh.AgentesSeguimientoLineasController.crear(seguimientoId), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """rrhh/seguimiento-linea/crear"""))
   }
}
        

// @LINE:660
case controllers_rrhh_AgentesSeguimientoLineasController_editar546(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesSeguimientoLineasController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/seguimiento-linea/editar"""))
   }
}
        

// @LINE:661
case controllers_rrhh_AgentesSeguimientoLineasController_guardar547(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesSeguimientoLineasController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "guardar", Nil,"POST", """""", Routes.prefix + """rrhh/seguimiento-linea/guardar"""))
   }
}
        

// @LINE:662
case controllers_rrhh_AgentesSeguimientoLineasController_actualizar548(params) => {
   call { 
        invokeHandler(controllers.rrhh.AgentesSeguimientoLineasController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "actualizar", Nil,"POST", """""", Routes.prefix + """rrhh/seguimiento-linea/actualizar"""))
   }
}
        

// @LINE:663
case controllers_rrhh_AgentesSeguimientoLineasController_eliminar549(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.rrhh.AgentesSeguimientoLineasController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rrhh/seguimiento-linea/eliminar"""))
   }
}
        

// @LINE:669
case controllers_delegacion_IndexController_index550(params) => {
   call { 
        invokeHandler(controllers.delegacion.IndexController.index(), HandlerDef(this, "controllers.delegacion.IndexController", "index", Nil,"GET", """-----------------------------MODULO DELEGACIONES ---------------------------------""", Routes.prefix + """delegacion"""))
   }
}
        

// @LINE:670
case controllers_delegacion_DepositosController_index551(params) => {
   call { 
        invokeHandler(controllers.delegacion.DepositosController.index(), HandlerDef(this, "controllers.delegacion.DepositosController", "index", Nil,"GET", """""", Routes.prefix + """delegacion/deposito"""))
   }
}
        

// @LINE:671
case controllers_delegacion_DepositosController_crear552(params) => {
   call { 
        invokeHandler(controllers.delegacion.DepositosController.crear(), HandlerDef(this, "controllers.delegacion.DepositosController", "crear", Nil,"GET", """""", Routes.prefix + """delegacion/deposito/crear"""))
   }
}
        

// @LINE:672
case controllers_delegacion_DepositosController_guardar553(params) => {
   call { 
        invokeHandler(controllers.delegacion.DepositosController.guardar(), HandlerDef(this, "controllers.delegacion.DepositosController", "guardar", Nil,"POST", """""", Routes.prefix + """delegacion/deposito/guardar"""))
   }
}
        

// @LINE:673
case controllers_delegacion_DepositosController_editar554(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.delegacion.DepositosController.editar(id), HandlerDef(this, "controllers.delegacion.DepositosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """delegacion/deposito/editar"""))
   }
}
        

// @LINE:674
case controllers_delegacion_DepositosController_eliminar555(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.delegacion.DepositosController.eliminar(id), HandlerDef(this, "controllers.delegacion.DepositosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """delegacion/deposito/eliminar"""))
   }
}
        

// @LINE:675
case controllers_delegacion_DepositosController_actualizar556(params) => {
   call { 
        invokeHandler(controllers.delegacion.DepositosController.actualizar(), HandlerDef(this, "controllers.delegacion.DepositosController", "actualizar", Nil,"POST", """""", Routes.prefix + """delegacion/deposito/actualizar"""))
   }
}
        

// @LINE:676
case controllers_delegacion_DepositosController_modalBuscar557(params) => {
   call { 
        invokeHandler(controllers.delegacion.DepositosController.modalBuscar(), HandlerDef(this, "controllers.delegacion.DepositosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """delegacion/deposito/modalBuscar"""))
   }
}
        

// @LINE:677
case controllers_delegacion_DepositosController_get558(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.delegacion.DepositosController.get(id), HandlerDef(this, "controllers.delegacion.DepositosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """delegacion/deposito/get"""))
   }
}
        

// @LINE:681
case controllers_presupuesto_IndexController_index559(params) => {
   call { 
        invokeHandler(controllers.presupuesto.IndexController.index(), HandlerDef(this, "controllers.presupuesto.IndexController", "index", Nil,"GET", """-----------------------------MODULO PRESUPUESTO ---------------------------------""", Routes.prefix + """presupuesto"""))
   }
}
        

// @LINE:682
case controllers_presupuesto_CreditosPresupuestariosController_index560(params) => {
   call { 
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.index(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "index", Nil,"GET", """""", Routes.prefix + """presupuesto/credito-presupuestario"""))
   }
}
        

// @LINE:683
case controllers_presupuesto_CreditosPresupuestariosController_crear561(params) => {
   call { 
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.crear(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "crear", Nil,"GET", """""", Routes.prefix + """presupuesto/credito-presupuestario/crear"""))
   }
}
        

// @LINE:684
case controllers_presupuesto_CreditosPresupuestariosController_guardar562(params) => {
   call { 
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.guardar(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "guardar", Nil,"POST", """""", Routes.prefix + """presupuesto/credito-presupuestario/guardar"""))
   }
}
        

// @LINE:685
case controllers_presupuesto_CreditosPresupuestariosController_editar563(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.editar(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto/credito-presupuestario/editar"""))
   }
}
        

// @LINE:686
case controllers_presupuesto_CreditosPresupuestariosController_eliminar564(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.eliminar(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto/credito-presupuestario/eliminar"""))
   }
}
        

// @LINE:687
case controllers_presupuesto_CreditosPresupuestariosController_actualizar565(params) => {
   call { 
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.actualizar(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "actualizar", Nil,"POST", """""", Routes.prefix + """presupuesto/credito-presupuestario/actualizar"""))
   }
}
        

// @LINE:689
case controllers_presupuesto_CreditosPresupuestariosController_get566(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.get(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "get", Seq(classOf[Int]),"GET", """GET    /presupuesto/credito-presupuestario/modalBuscar			controllers.presupuesto.CreditosPresupuestariosController.modalBuscar()""", Routes.prefix + """presupuesto/credito-presupuestario/get"""))
   }
}
        

// @LINE:690
case controllers_presupuesto_CreditosPresupuestariosController_ver567(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.ver(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto/credito-presupuestario/ver"""))
   }
}
        

// @LINE:691
case controllers_presupuesto_CreditosPresupuestariosController_aprobar568(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.aprobar(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "aprobar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto/aprobar"""))
   }
}
        

// @LINE:693
case controllers_presupuesto_CreditosPresupuestariosController_listaCargas569(params) => {
   call { 
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.listaCargas(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "listaCargas", Nil,"GET", """""", Routes.prefix + """presupuesto/credito-listaCargas"""))
   }
}
        

// @LINE:695
case controllers_presupuesto_CreditosPresupuestariosController_index570(params) => {
   call { 
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.index(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "index", Nil,"GET", """""", Routes.prefix + """presupuesto/credito-presupuestario"""))
   }
}
        

// @LINE:697
case controllers_presupuesto_CreditosPresupuestariosController_reporteListadoCreditos571(params) => {
   call { 
        invokeHandler(controllers.presupuesto.CreditosPresupuestariosController.reporteListadoCreditos(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "reporteListadoCreditos", Nil,"POST", """""", Routes.prefix + """presupuesto/credito-presupuestario/reporteListadoCreditos"""))
   }
}
        

// @LINE:698
case controllers_presupuesto_LineasCreditosPresupuestariosController_index572(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.presupuesto.LineasCreditosPresupuestariosController.index(id, editable), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """presupuesto/linea-credito/index"""))
   }
}
        

// @LINE:699
case controllers_presupuesto_LineasCreditosPresupuestariosController_crear573(params) => {
   call(params.fromQuery[String]("creditoPresupuestarioId", None)) { (creditoPresupuestarioId) =>
        invokeHandler(controllers.presupuesto.LineasCreditosPresupuestariosController.crear(creditoPresupuestarioId), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """presupuesto/linea-credito/crear"""))
   }
}
        

// @LINE:700
case controllers_presupuesto_LineasCreditosPresupuestariosController_editar574(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.presupuesto.LineasCreditosPresupuestariosController.editar(id), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto/linea-credito/editar"""))
   }
}
        

// @LINE:701
case controllers_presupuesto_LineasCreditosPresupuestariosController_guardar575(params) => {
   call { 
        invokeHandler(controllers.presupuesto.LineasCreditosPresupuestariosController.guardar(), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "guardar", Nil,"POST", """""", Routes.prefix + """presupuesto/linea-credito/guardar"""))
   }
}
        

// @LINE:702
case controllers_presupuesto_LineasCreditosPresupuestariosController_actualizar576(params) => {
   call { 
        invokeHandler(controllers.presupuesto.LineasCreditosPresupuestariosController.actualizar(), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "actualizar", Nil,"POST", """""", Routes.prefix + """presupuesto/linea-credito/actualizar"""))
   }
}
        

// @LINE:703
case controllers_presupuesto_LineasCreditosPresupuestariosController_eliminar577(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.presupuesto.LineasCreditosPresupuestariosController.eliminar(id), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto/linea-credito/eliminar"""))
   }
}
        

// @LINE:704
case controllers_presupuesto_LineasRecursosPresupuestariosController_index578(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.presupuesto.LineasRecursosPresupuestariosController.index(id, editable), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """presupuesto/linea-recurso/index"""))
   }
}
        

// @LINE:705
case controllers_presupuesto_LineasRecursosPresupuestariosController_crear579(params) => {
   call(params.fromQuery[String]("creditoPresupuestarioId", None)) { (creditoPresupuestarioId) =>
        invokeHandler(controllers.presupuesto.LineasRecursosPresupuestariosController.crear(creditoPresupuestarioId), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """presupuesto/linea-recurso/crear"""))
   }
}
        

// @LINE:706
case controllers_presupuesto_LineasRecursosPresupuestariosController_editar580(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.presupuesto.LineasRecursosPresupuestariosController.editar(id), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto/linea-recurso/editar"""))
   }
}
        

// @LINE:707
case controllers_presupuesto_LineasRecursosPresupuestariosController_guardar581(params) => {
   call { 
        invokeHandler(controllers.presupuesto.LineasRecursosPresupuestariosController.guardar(), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "guardar", Nil,"POST", """""", Routes.prefix + """presupuesto/linea-recurso/guardar"""))
   }
}
        

// @LINE:708
case controllers_presupuesto_LineasRecursosPresupuestariosController_actualizar582(params) => {
   call { 
        invokeHandler(controllers.presupuesto.LineasRecursosPresupuestariosController.actualizar(), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "actualizar", Nil,"POST", """""", Routes.prefix + """presupuesto/linea-recurso/actualizar"""))
   }
}
        

// @LINE:709
case controllers_presupuesto_LineasRecursosPresupuestariosController_eliminar583(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.presupuesto.LineasRecursosPresupuestariosController.eliminar(id), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto/linea-recurso/eliminar"""))
   }
}
        

// @LINE:710
case controllers_presupuesto_BalancePresupuestarioController_index584(params) => {
   call { 
        invokeHandler(controllers.presupuesto.BalancePresupuestarioController.index(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioController", "index", Nil,"GET", """""", Routes.prefix + """presupuesto/balance-presupuestario"""))
   }
}
        

// @LINE:711
case controllers_presupuesto_BalancePresupuestarioController_balancePresupuestarioPorExpediente585(params) => {
   call { 
        invokeHandler(controllers.presupuesto.BalancePresupuestarioController.balancePresupuestarioPorExpediente(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioController", "balancePresupuestarioPorExpediente", Nil,"GET", """""", Routes.prefix + """presupuesto/balancePresupuestarioPorExpediente"""))
   }
}
        

// @LINE:713
case controllers_presupuesto_BalancePresupuestarioReportesController_modalReporteBalancePorCuentaPorExpediente586(params) => {
   call(params.fromQuery[Integer]("id", Some(0))) { (id) =>
        invokeHandler(controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteBalancePorCuentaPorExpediente(id), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "modalReporteBalancePorCuentaPorExpediente", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """presupuesto/reporte/modalReporteBalancePorCuentaPorExpediente"""))
   }
}
        

// @LINE:714
case controllers_presupuesto_BalancePresupuestarioReportesController_reporteBalancePorCuentaPorExpediente587(params) => {
   call(params.fromQuery[Integer]("id", Some(0))) { (id) =>
        invokeHandler(controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorCuentaPorExpediente(id), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteBalancePorCuentaPorExpediente", Seq(classOf[Integer]),"POST", """""", Routes.prefix + """presupuesto/reporte/reporteBalancePorCuentaPorExpediente"""))
   }
}
        

// @LINE:715
case controllers_presupuesto_BalancePresupuestarioReportesController_modalReporteExportarDatosPresupuestoControl588(params) => {
   call { 
        invokeHandler(controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteExportarDatosPresupuestoControl(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "modalReporteExportarDatosPresupuestoControl", Nil,"GET", """""", Routes.prefix + """presupuesto/reporte/modalReporteExportarDatosPresupuestoControl"""))
   }
}
        

// @LINE:716
case controllers_presupuesto_BalancePresupuestarioReportesController_reporteExportarDatosPresupuestoControl589(params) => {
   call { 
        invokeHandler(controllers.presupuesto.BalancePresupuestarioReportesController.reporteExportarDatosPresupuestoControl(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteExportarDatosPresupuestoControl", Nil,"POST", """""", Routes.prefix + """presupuesto/reporte/reporteExportarDatosPresupuestoControl"""))
   }
}
        

// @LINE:718
case controllers_presupuesto_BalancePresupuestarioReportesController_reporteBalanceDiferenciaPreventivoDefinitivo590(params) => {
   call(params.fromQuery[Long]("idEjercicio", None)) { (idEjercicio) =>
        invokeHandler(controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(idEjercicio), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteBalanceDiferenciaPreventivoDefinitivo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """presupuesto/reporte/reporteBalanceDiferenciaPreventivoDefinitivo"""))
   }
}
        

// @LINE:720
case controllers_presupuesto_BalancePresupuestarioReportesController_modalReporteBalancePorFecha591(params) => {
   call { 
        invokeHandler(controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteBalancePorFecha(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "modalReporteBalancePorFecha", Nil,"GET", """""", Routes.prefix + """presupuesto/modalReporteBalancePorFecha"""))
   }
}
        

// @LINE:721
case controllers_presupuesto_BalancePresupuestarioReportesController_reporteBalancePorFecha592(params) => {
   call { 
        invokeHandler(controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorFecha(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteBalancePorFecha", Nil,"POST", """""", Routes.prefix + """presupuesto/reporteBalancePorFecha"""))
   }
}
        

// @LINE:722
case controllers_presupuesto_BalancePresupuestarioReportesController_reporteBalancePorFechaPorExpediente593(params) => {
   call { 
        invokeHandler(controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorFechaPorExpediente(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteBalancePorFechaPorExpediente", Nil,"POST", """""", Routes.prefix + """presupuesto/reporteBalancePorFechaPorExpediente"""))
   }
}
        

// @LINE:725
case controllers_presupuesto_ControlPresupuestarioController_controlAnulacionProductosAutomaticos594(params) => {
   call { 
        invokeHandler(controllers.presupuesto.ControlPresupuestarioController.controlAnulacionProductosAutomaticos(), HandlerDef(this, "controllers.presupuesto.ControlPresupuestarioController", "controlAnulacionProductosAutomaticos", Nil,"GET", """""", Routes.prefix + """presupuesto/controlAnulacionProductosAutomaticos"""))
   }
}
        

// @LINE:726
case controllers_presupuesto_ControlPresupuestarioController_controlAnulacionProductosAutomaticosExcel595(params) => {
   call { 
        invokeHandler(controllers.presupuesto.ControlPresupuestarioController.controlAnulacionProductosAutomaticosExcel(), HandlerDef(this, "controllers.presupuesto.ControlPresupuestarioController", "controlAnulacionProductosAutomaticosExcel", Nil,"GET", """""", Routes.prefix + """presupuesto/controlAnulacionProductosAutomaticosExcel"""))
   }
}
        

// @LINE:728
case controllers_presupuesto_ControlPresupuestarioController_movimientosSaldoPreventivo596(params) => {
   call { 
        invokeHandler(controllers.presupuesto.ControlPresupuestarioController.movimientosSaldoPreventivo(), HandlerDef(this, "controllers.presupuesto.ControlPresupuestarioController", "movimientosSaldoPreventivo", Nil,"GET", """""", Routes.prefix + """presupuesto/movimientosSaldoPreventivo"""))
   }
}
        

// @LINE:729
case controllers_presupuesto_ControlPresupuestarioController_movimientosSaldoPreventivoExcel597(params) => {
   call { 
        invokeHandler(controllers.presupuesto.ControlPresupuestarioController.movimientosSaldoPreventivoExcel(), HandlerDef(this, "controllers.presupuesto.ControlPresupuestarioController", "movimientosSaldoPreventivoExcel", Nil,"GET", """""", Routes.prefix + """presupuesto/movimientosSaldoPreventivoExcel"""))
   }
}
        

// @LINE:733
case controllers_rendiciones_IndexController_index598(params) => {
   call { 
        invokeHandler(controllers.rendiciones.IndexController.index(), HandlerDef(this, "controllers.rendiciones.IndexController", "index", Nil,"GET", """-----------------------------MODULO RENDICIONES ---------------------------------""", Routes.prefix + """rendiciones"""))
   }
}
        

// @LINE:734
case controllers_rendiciones_RendicionesController_indexPagosRealizados599(params) => {
   call { 
        invokeHandler(controllers.rendiciones.RendicionesController.indexPagosRealizados(), HandlerDef(this, "controllers.rendiciones.RendicionesController", "indexPagosRealizados", Nil,"GET", """""", Routes.prefix + """rendiciones/pagos-realizados"""))
   }
}
        

// @LINE:742
case controllers_haberes_IndexController_index600(params) => {
   call { 
        invokeHandler(controllers.haberes.IndexController.index(), HandlerDef(this, "controllers.haberes.IndexController", "index", Nil,"GET", """-----------------------------MODULO HABERES ---------------------------------""", Routes.prefix + """haberes"""))
   }
}
        

// @LINE:743
case controllers_haberes_NovedadesController_index601(params) => {
   call { 
        invokeHandler(controllers.haberes.NovedadesController.index(), HandlerDef(this, "controllers.haberes.NovedadesController", "index", Nil,"GET", """""", Routes.prefix + """haberes/novedades"""))
   }
}
        

// @LINE:744
case controllers_haberes_NovedadesController_lista602(params) => {
   call { 
        invokeHandler(controllers.haberes.NovedadesController.lista(), HandlerDef(this, "controllers.haberes.NovedadesController", "lista", Nil,"GET", """""", Routes.prefix + """haberes/novedades/lista"""))
   }
}
        

// @LINE:745
case controllers_haberes_NovedadesController_ver603(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.NovedadesController.ver(id), HandlerDef(this, "controllers.haberes.NovedadesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/novedades/ver"""))
   }
}
        

// @LINE:746
case controllers_haberes_NovedadesController_crear604(params) => {
   call { 
        invokeHandler(controllers.haberes.NovedadesController.crear(), HandlerDef(this, "controllers.haberes.NovedadesController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/novedades/crear"""))
   }
}
        

// @LINE:747
case controllers_haberes_NovedadesController_guardar605(params) => {
   call { 
        invokeHandler(controllers.haberes.NovedadesController.guardar(), HandlerDef(this, "controllers.haberes.NovedadesController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/novedades/guardar"""))
   }
}
        

// @LINE:748
case controllers_haberes_NovedadesController_editar606(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.NovedadesController.editar(id), HandlerDef(this, "controllers.haberes.NovedadesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/novedades/editar"""))
   }
}
        

// @LINE:749
case controllers_haberes_NovedadesController_actualizar607(params) => {
   call { 
        invokeHandler(controllers.haberes.NovedadesController.actualizar(), HandlerDef(this, "controllers.haberes.NovedadesController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/novedades/actualizar"""))
   }
}
        

// @LINE:750
case controllers_haberes_NovedadesController_eliminar608(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.NovedadesController.eliminar(id), HandlerDef(this, "controllers.haberes.NovedadesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/novedades/eliminar"""))
   }
}
        

// @LINE:752
case controllers_haberes_NovedadesAccionesController_crearMasivo609(params) => {
   call { 
        invokeHandler(controllers.haberes.NovedadesAccionesController.crearMasivo(), HandlerDef(this, "controllers.haberes.NovedadesAccionesController", "crearMasivo", Nil,"GET", """""", Routes.prefix + """haberes/novedades/acciones/crear-masivo"""))
   }
}
        

// @LINE:753
case controllers_haberes_NovedadesAccionesController_procesarMasivo610(params) => {
   call { 
        invokeHandler(controllers.haberes.NovedadesAccionesController.procesarMasivo(), HandlerDef(this, "controllers.haberes.NovedadesAccionesController", "procesarMasivo", Nil,"POST", """""", Routes.prefix + """haberes/novedades/acciones/procesar-masivo"""))
   }
}
        

// @LINE:756
case controllers_haberes_PuestosLaboralesController_index611(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesController.index(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "index", Nil,"GET", """""", Routes.prefix + """haberes/puestos-laborales"""))
   }
}
        

// @LINE:757
case controllers_haberes_PuestosLaboralesController_crear612(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesController.crear(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/puestos-laborales/crear"""))
   }
}
        

// @LINE:758
case controllers_haberes_PuestosLaboralesController_guardar613(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/guardar"""))
   }
}
        

// @LINE:759
case controllers_haberes_PuestosLaboralesController_editar614(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.PuestosLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/puestos-laborales/editar"""))
   }
}
        

// @LINE:760
case controllers_haberes_PuestosLaboralesController_eliminar615(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.PuestosLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/puestos-laborale/eliminar"""))
   }
}
        

// @LINE:761
case controllers_haberes_PuestosLaboralesController_actualizar616(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/actualizar"""))
   }
}
        

// @LINE:762
case controllers_haberes_PuestosLaboralesController_modalBuscar617(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/puestos-laborales/modal-buscar"""))
   }
}
        

// @LINE:763
case controllers_haberes_PuestosLaboralesController_modalBuscarTodos618(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesController.modalBuscarTodos(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "modalBuscarTodos", Nil,"GET", """""", Routes.prefix + """haberes/puestos-laborales/modal-buscar-todos"""))
   }
}
        

// @LINE:764
case controllers_haberes_PuestosLaboralesController_get619(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.PuestosLaboralesController.get(id), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/puestos-laborales/get"""))
   }
}
        

// @LINE:765
case controllers_haberes_PuestosLaboralesController_ver620(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.PuestosLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/puestos-laborales/ver"""))
   }
}
        

// @LINE:766
case controllers_haberes_PuestosLaboralesController_cambiarEstado621(params) => {
   call(params.fromQuery[Long]("idPuesto", None), params.fromQuery[Long]("idEstado", None)) { (idPuesto, idEstado) =>
        invokeHandler(controllers.haberes.PuestosLaboralesController.cambiarEstado(idPuesto, idEstado), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """haberes/puestos-laborales/cambiarEstado"""))
   }
}
        

// @LINE:770
case controllers_haberes_PuestosLaboralesAccionesController_activar622(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.activar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "activar", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/acciones/activar"""))
   }
}
        

// @LINE:771
case controllers_haberes_PuestosLaboralesAccionesController_desactivar623(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.desactivar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "desactivar", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/acciones/desactivar"""))
   }
}
        

// @LINE:772
case controllers_haberes_PuestosLaboralesAccionesController_modalCrearNovedades624(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.modalCrearNovedades(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalCrearNovedades", Nil,"GET", """""", Routes.prefix + """haberes/puestos-laborales/acciones/modalCrearNovedades"""))
   }
}
        

// @LINE:773
case controllers_haberes_PuestosLaboralesAccionesController_crearNovedadesBasicas625(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.crearNovedadesBasicas(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "crearNovedadesBasicas", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/crearNovedades"""))
   }
}
        

// @LINE:774
case controllers_haberes_PuestosLaboralesAccionesController_modalPasarABorrador626(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.modalPasarABorrador(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalPasarABorrador", Nil,"GET", """""", Routes.prefix + """haberes/puestos-laborales/modalPasarABorrador"""))
   }
}
        

// @LINE:775
case controllers_haberes_PuestosLaboralesAccionesController_pasarABorrador627(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.pasarABorrador(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "pasarABorrador", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/pasarABorrador"""))
   }
}
        

// @LINE:776
case controllers_haberes_PuestosLaboralesAccionesController_modalPasarAControlado628(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.modalPasarAControlado(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalPasarAControlado", Nil,"GET", """""", Routes.prefix + """haberes/puestos-laborales/modalPasarAControlado"""))
   }
}
        

// @LINE:777
case controllers_haberes_PuestosLaboralesAccionesController_pasarAControlado629(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.pasarAControlado(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "pasarAControlado", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/pasarAControlado"""))
   }
}
        

// @LINE:778
case controllers_haberes_PuestosLaboralesController_liquidarCierre630(params) => {
   call(params.fromQuery[Long]("idPuestoLaboral", None), params.fromQuery[Long]("idLiquidacionMes", None)) { (idPuestoLaboral, idLiquidacionMes) =>
        invokeHandler(controllers.haberes.PuestosLaboralesController.liquidarCierre(idPuestoLaboral, idLiquidacionMes), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "liquidarCierre", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """haberes/puestos-laborales/liquidarCierre"""))
   }
}
        

// @LINE:780
case controllers_haberes_PuestosLaboralesAccionesController_modalPreliquidarPuesto631(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.modalPreliquidarPuesto(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalPreliquidarPuesto", Nil,"GET", """""", Routes.prefix + """haberes/puestos-laborales/acciones/modalPreliquidarPuesto"""))
   }
}
        

// @LINE:781
case controllers_haberes_PuestosLaboralesAccionesController_preliquidarPuesto632(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.preliquidarPuesto(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "preliquidarPuesto", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/preliquidarPuesto"""))
   }
}
        

// @LINE:783
case controllers_haberes_PuestosLaboralesAccionesController_modalPreliquidarFinalPuesto633(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.modalPreliquidarFinalPuesto(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalPreliquidarFinalPuesto", Nil,"GET", """""", Routes.prefix + """haberes/puestos-laborales/acciones/modalPreliquidarPuestoFinal"""))
   }
}
        

// @LINE:784
case controllers_haberes_PuestosLaboralesAccionesController_preliquidarFinalPuesto634(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesAccionesController.preliquidarFinalPuesto(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "preliquidarFinalPuesto", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/preliquidarPuestoFinal"""))
   }
}
        

// @LINE:787
case controllers_haberes_PuestosLaboralesReportesController_altasMasivas635(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesReportesController.altasMasivas(), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "altasMasivas", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/reportes/alta-masiva"""))
   }
}
        

// @LINE:788
case controllers_haberes_PuestosLaboralesReportesController_altasMacroSueldo636(params) => {
   call(params.fromQuery[Boolean]("nuevo", Some(false))) { (nuevo) =>
        invokeHandler(controllers.haberes.PuestosLaboralesReportesController.altasMacroSueldo(nuevo), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "altasMacroSueldo", Seq(classOf[Boolean]),"POST", """""", Routes.prefix + """haberes/puestos-laborales/reportes/alta-macrosueldo"""))
   }
}
        

// @LINE:789
case controllers_haberes_PuestosLaboralesReportesController_descargarArchivo637(params) => {
   call(params.fromQuery[String]("url", None)) { (url) =>
        invokeHandler(controllers.haberes.PuestosLaboralesReportesController.descargarArchivo(url), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "descargarArchivo", Seq(classOf[String]),"GET", """""", Routes.prefix + """haberes/puestos-laborales/reportes/descargar-archivo"""))
   }
}
        

// @LINE:790
case controllers_haberes_PuestosLaboralesReportesController_listadoPuestosLaborales638(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesReportesController.listadoPuestosLaborales(), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "listadoPuestosLaborales", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/reportes/listado"""))
   }
}
        

// @LINE:791
case controllers_haberes_PuestosLaboralesReportesController_reportef649639(params) => {
   call { 
        invokeHandler(controllers.haberes.PuestosLaboralesReportesController.reportef649(), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "reportef649", Nil,"POST", """""", Routes.prefix + """haberes/puestos-laborales/reportes/f649"""))
   }
}
        

// @LINE:792
case controllers_haberes_PuestosLaboralesReportesController_formulario649640(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Int]("ejercicio_id", None)) { (id, ejercicio_id) =>
        invokeHandler(controllers.haberes.PuestosLaboralesReportesController.formulario649(id, ejercicio_id), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "formulario649", Seq(classOf[Long], classOf[Int]),"GET", """""", Routes.prefix + """reportes/formulario649"""))
   }
}
        

// @LINE:793
case controllers_haberes_PuestosLaboralesReportesController_formulario6492019641(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Int]("ejercicio_id", None)) { (id, ejercicio_id) =>
        invokeHandler(controllers.haberes.PuestosLaboralesReportesController.formulario6492019(id, ejercicio_id), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "formulario6492019", Seq(classOf[Long], classOf[Int]),"GET", """""", Routes.prefix + """reportes/formulario649-2019"""))
   }
}
        

// @LINE:794
case controllers_haberes_PuestosLaboralesReportesController_formulario6492021642(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Int]("ejercicio_id", None)) { (id, ejercicio_id) =>
        invokeHandler(controllers.haberes.PuestosLaboralesReportesController.formulario6492021(id, ejercicio_id), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "formulario6492021", Seq(classOf[Long], classOf[Int]),"GET", """""", Routes.prefix + """reportes/formulario649-2021"""))
   }
}
        

// @LINE:795
case controllers_haberes_PuestosLaboralesReportesController_formulario6492022643(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Int]("ejercicio_id", None)) { (id, ejercicio_id) =>
        invokeHandler(controllers.haberes.PuestosLaboralesReportesController.formulario6492022(id, ejercicio_id), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "formulario6492022", Seq(classOf[Long], classOf[Int]),"GET", """""", Routes.prefix + """reportes/formulario649-2022"""))
   }
}
        

// @LINE:797
case controllers_haberes_LiquidacionConceptosController_index644(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptosController.index(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "index", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionConcepto"""))
   }
}
        

// @LINE:798
case controllers_haberes_LiquidacionConceptosController_crear645(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptosController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionConcepto/crear"""))
   }
}
        

// @LINE:799
case controllers_haberes_LiquidacionConceptosController_guardar646(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptosController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionConcepto/guardar"""))
   }
}
        

// @LINE:800
case controllers_haberes_LiquidacionConceptosController_editar647(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionConceptosController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionConcepto/editar"""))
   }
}
        

// @LINE:801
case controllers_haberes_LiquidacionConceptosController_eliminar648(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionConceptosController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionConcepto/eliminar"""))
   }
}
        

// @LINE:802
case controllers_haberes_LiquidacionConceptosController_actualizar649(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptosController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionConcepto/actualizar"""))
   }
}
        

// @LINE:803
case controllers_haberes_LiquidacionConceptosController_modalBuscar650(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptosController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionConcepto/modalBuscar"""))
   }
}
        

// @LINE:804
case controllers_haberes_LiquidacionConceptosController_get651(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionConceptosController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/liquidacionConcepto/get"""))
   }
}
        

// @LINE:805
case controllers_haberes_LiquidacionConceptosController_ver652(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionConceptosController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionConcepto/ver"""))
   }
}
        

// @LINE:807
case controllers_haberes_LiquidacionConceptoTiposController_index653(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptoTiposController.index(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "index", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionConceptoTipo"""))
   }
}
        

// @LINE:808
case controllers_haberes_LiquidacionConceptoTiposController_crear654(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptoTiposController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionConceptoTipo/crear"""))
   }
}
        

// @LINE:809
case controllers_haberes_LiquidacionConceptoTiposController_guardar655(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptoTiposController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionConceptoTipo/guardar"""))
   }
}
        

// @LINE:810
case controllers_haberes_LiquidacionConceptoTiposController_editar656(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionConceptoTiposController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionConceptoTipo/editar"""))
   }
}
        

// @LINE:811
case controllers_haberes_LiquidacionConceptoTiposController_eliminar657(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionConceptoTiposController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionConceptoTipo/eliminar"""))
   }
}
        

// @LINE:812
case controllers_haberes_LiquidacionConceptoTiposController_actualizar658(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptoTiposController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionConceptoTipo/actualizar"""))
   }
}
        

// @LINE:813
case controllers_haberes_LiquidacionConceptoTiposController_modalBuscar659(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionConceptoTiposController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionConceptoTipo/modalBuscar"""))
   }
}
        

// @LINE:814
case controllers_haberes_LiquidacionConceptoTiposController_get660(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionConceptoTiposController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/liquidacionConceptoTipo/get"""))
   }
}
        

// @LINE:815
case controllers_haberes_LiquidacionConceptoTiposController_ver661(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionConceptoTiposController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionConceptoTipo/ver"""))
   }
}
        

// @LINE:817
case controllers_haberes_LiquidacionBaseCalculosController_index662(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionBaseCalculosController.index(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "index", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionBaseCalculo"""))
   }
}
        

// @LINE:818
case controllers_haberes_LiquidacionBaseCalculosController_crear663(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionBaseCalculosController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionBaseCalculo/crear"""))
   }
}
        

// @LINE:819
case controllers_haberes_LiquidacionBaseCalculosController_guardar664(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionBaseCalculosController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionBaseCalculo/guardar"""))
   }
}
        

// @LINE:820
case controllers_haberes_LiquidacionBaseCalculosController_editar665(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionBaseCalculosController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionBaseCalculo/editar"""))
   }
}
        

// @LINE:821
case controllers_haberes_LiquidacionBaseCalculosController_eliminar666(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionBaseCalculosController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionBaseCalculo/eliminar"""))
   }
}
        

// @LINE:822
case controllers_haberes_LiquidacionBaseCalculosController_actualizar667(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionBaseCalculosController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionBaseCalculo/actualizar"""))
   }
}
        

// @LINE:823
case controllers_haberes_LiquidacionBaseCalculosController_modalBuscar668(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionBaseCalculosController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionBaseCalculo/modalBuscar"""))
   }
}
        

// @LINE:824
case controllers_haberes_LiquidacionBaseCalculosController_get669(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionBaseCalculosController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/liquidacionBaseCalculo/get"""))
   }
}
        

// @LINE:825
case controllers_haberes_LiquidacionBaseCalculosController_ver670(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionBaseCalculosController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionBaseCalculo/ver"""))
   }
}
        

// @LINE:827
case controllers_haberes_LiquidacionTiposController_index671(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionTiposController.index(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "index", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionTipo"""))
   }
}
        

// @LINE:828
case controllers_haberes_LiquidacionTiposController_crear672(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionTiposController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionTipo/crear"""))
   }
}
        

// @LINE:829
case controllers_haberes_LiquidacionTiposController_guardar673(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionTiposController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionTipo/guardar"""))
   }
}
        

// @LINE:830
case controllers_haberes_LiquidacionTiposController_editar674(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionTiposController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionTipo/editar"""))
   }
}
        

// @LINE:831
case controllers_haberes_LiquidacionTiposController_eliminar675(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionTiposController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionTipo/eliminar"""))
   }
}
        

// @LINE:832
case controllers_haberes_LiquidacionTiposController_actualizar676(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionTiposController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionTipo/actualizar"""))
   }
}
        

// @LINE:833
case controllers_haberes_LiquidacionTiposController_modalBuscar677(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionTiposController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionTipo/modalBuscar"""))
   }
}
        

// @LINE:834
case controllers_haberes_LiquidacionTiposController_get678(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionTiposController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/liquidacionTipo/get"""))
   }
}
        

// @LINE:835
case controllers_haberes_LiquidacionTiposController_ver679(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionTiposController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionTipo/ver"""))
   }
}
        

// @LINE:837
case controllers_haberes_UnidadesLaboralesController_index680(params) => {
   call { 
        invokeHandler(controllers.haberes.UnidadesLaboralesController.index(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "index", Nil,"GET", """""", Routes.prefix + """haberes/unidadLaboral"""))
   }
}
        

// @LINE:838
case controllers_haberes_UnidadesLaboralesController_crear681(params) => {
   call { 
        invokeHandler(controllers.haberes.UnidadesLaboralesController.crear(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/unidadLaboral/crear"""))
   }
}
        

// @LINE:839
case controllers_haberes_UnidadesLaboralesController_guardar682(params) => {
   call { 
        invokeHandler(controllers.haberes.UnidadesLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/unidadLaboral/guardar"""))
   }
}
        

// @LINE:840
case controllers_haberes_UnidadesLaboralesController_editar683(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.UnidadesLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/unidadLaboral/editar"""))
   }
}
        

// @LINE:841
case controllers_haberes_UnidadesLaboralesController_eliminar684(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.UnidadesLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/unidadLaboral/eliminar"""))
   }
}
        

// @LINE:842
case controllers_haberes_UnidadesLaboralesController_actualizar685(params) => {
   call { 
        invokeHandler(controllers.haberes.UnidadesLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/unidadLaboral/actualizar"""))
   }
}
        

// @LINE:843
case controllers_haberes_UnidadesLaboralesController_modalBuscar686(params) => {
   call { 
        invokeHandler(controllers.haberes.UnidadesLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/unidadLaboral/modalBuscar"""))
   }
}
        

// @LINE:844
case controllers_haberes_UnidadesLaboralesController_get687(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.UnidadesLaboralesController.get(id), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/unidadLaboral/get"""))
   }
}
        

// @LINE:845
case controllers_haberes_UnidadesLaboralesController_ver688(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.UnidadesLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/unidadLaboral/ver"""))
   }
}
        

// @LINE:847
case controllers_haberes_CategoriasLaboralesController_index689(params) => {
   call { 
        invokeHandler(controllers.haberes.CategoriasLaboralesController.index(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "index", Nil,"GET", """""", Routes.prefix + """haberes/categoriaLaboral"""))
   }
}
        

// @LINE:848
case controllers_haberes_CategoriasLaboralesController_crear690(params) => {
   call { 
        invokeHandler(controllers.haberes.CategoriasLaboralesController.crear(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/categoriaLaboral/crear"""))
   }
}
        

// @LINE:849
case controllers_haberes_CategoriasLaboralesController_guardar691(params) => {
   call { 
        invokeHandler(controllers.haberes.CategoriasLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/categoriaLaboral/guardar"""))
   }
}
        

// @LINE:850
case controllers_haberes_CategoriasLaboralesController_editar692(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.CategoriasLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/categoriaLaboral/editar"""))
   }
}
        

// @LINE:851
case controllers_haberes_CategoriasLaboralesController_eliminar693(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.CategoriasLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/categoriaLaboral/eliminar"""))
   }
}
        

// @LINE:852
case controllers_haberes_CategoriasLaboralesController_actualizar694(params) => {
   call { 
        invokeHandler(controllers.haberes.CategoriasLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/categoriaLaboral/actualizar"""))
   }
}
        

// @LINE:853
case controllers_haberes_CategoriasLaboralesController_modalBuscar695(params) => {
   call { 
        invokeHandler(controllers.haberes.CategoriasLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/categoriaLaboral/modalBuscar"""))
   }
}
        

// @LINE:854
case controllers_haberes_CategoriasLaboralesController_get696(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.CategoriasLaboralesController.get(id), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/categoriaLaboral/get"""))
   }
}
        

// @LINE:855
case controllers_haberes_CategoriasLaboralesController_ver697(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.CategoriasLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/categoriaLaboral/ver"""))
   }
}
        

// @LINE:856
case controllers_haberes_CategoriasLaboralesController_suggestCategoriaLaboral698(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.haberes.CategoriasLaboralesController.suggestCategoriaLaboral(input), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "suggestCategoriaLaboral", Seq(classOf[String]),"GET", """""", Routes.prefix + """haberes/categoriaLaboral/suggestCategoriaLaboral/$input<[^/]+>"""))
   }
}
        

// @LINE:858
case controllers_haberes_LiquidacionPuestosController_index699(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosController.index(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "index", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionPuesto"""))
   }
}
        

// @LINE:859
case controllers_haberes_LiquidacionPuestosController_crear700(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/crear"""))
   }
}
        

// @LINE:860
case controllers_haberes_LiquidacionPuestosController_guardar701(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/guardar"""))
   }
}
        

// @LINE:861
case controllers_haberes_LiquidacionPuestosController_editar702(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/editar"""))
   }
}
        

// @LINE:862
case controllers_haberes_LiquidacionPuestosController_eliminar703(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/eliminar"""))
   }
}
        

// @LINE:863
case controllers_haberes_LiquidacionPuestosController_actualizar704(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/actualizar"""))
   }
}
        

// @LINE:864
case controllers_haberes_LiquidacionPuestosController_modalBuscar705(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/modalBuscar"""))
   }
}
        

// @LINE:865
case controllers_haberes_LiquidacionPuestosController_get706(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/get"""))
   }
}
        

// @LINE:866
case controllers_haberes_LiquidacionPuestosController_ver707(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/ver"""))
   }
}
        

// @LINE:867
case controllers_haberes_LiquidacionPuestosReportesController_reciboSueldoPorPuesto708(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosReportesController.reciboSueldoPorPuesto(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "reciboSueldoPorPuesto", Seq(classOf[Long]),"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/reportes/reciboSueldoPorPuesto"""))
   }
}
        

// @LINE:868
case controllers_haberes_LiquidacionPuestosReportesController_reciboSueldo709(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosReportesController.reciboSueldo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "reciboSueldo", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/reportes/reciboSueldo"""))
   }
}
        

// @LINE:869
case controllers_haberes_LiquidacionPuestosReportesController_reciboSueldosByLiquidacionMes710(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosReportesController.reciboSueldosByLiquidacionMes(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "reciboSueldosByLiquidacionMes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/reportes/reciboSueldosByLiquidacionMes"""))
   }
}
        

// @LINE:870
case controllers_haberes_LiquidacionPuestosController_cambiarEstado711(params) => {
   call(params.fromQuery[Long]("idLiquidacionPuesto", None), params.fromQuery[Long]("idEstado", None)) { (idLiquidacionPuesto, idEstado) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosController.cambiarEstado(idLiquidacionPuesto, idEstado), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/cambiarEstado"""))
   }
}
        

// @LINE:871
case controllers_haberes_LiquidacionPuestosReportesController_libroSueldos712(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosReportesController.libroSueldos(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "libroSueldos", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/reportes/libroSueldos"""))
   }
}
        

// @LINE:872
case controllers_haberes_LiquidacionPuestosController_preLiquidar713(params) => {
   call(params.fromQuery[Long]("idPuestoLaboral", None), params.fromQuery[Long]("idLiquidacionMes", None), params.fromQuery[Long]("idLiquidacionPuesto", None)) { (idPuestoLaboral, idLiquidacionMes, idLiquidacionPuesto) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosController.preLiquidar(idPuestoLaboral, idLiquidacionMes, idLiquidacionPuesto), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "preLiquidar", Seq(classOf[Long], classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/preliquidar"""))
   }
}
        

// @LINE:874
case controllers_haberes_LiquidacionPuestosReportesController_modalReciboSueldoPorPuestoMail714(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionPuestosReportesController.modalReciboSueldoPorPuestoMail(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "modalReciboSueldoPorPuestoMail", Seq(classOf[Long]),"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/reportes/modalReciboSueldoPorPuestoMail"""))
   }
}
        

// @LINE:875
case controllers_haberes_LiquidacionPuestosReportesController_enviarReciboPorMail715(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosReportesController.enviarReciboPorMail(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "enviarReciboPorMail", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/reportes/enviarReciboPorMail"""))
   }
}
        

// @LINE:877
case controllers_haberes_LiquidacionPuestosAccionesController_modalPasarAOtraLiquidacion716(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.modalPasarAOtraLiquidacion(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarAOtraLiquidacion", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/modalPasarAOtraLiquidacion"""))
   }
}
        

// @LINE:878
case controllers_haberes_LiquidacionPuestosAccionesController_pasarAOtraLiquidacion717(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.pasarAOtraLiquidacion(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarAOtraLiquidacion", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/pasarAOtraLiquidacion"""))
   }
}
        

// @LINE:879
case controllers_haberes_LiquidacionPuestosAccionesController_modalPasarAprobado718(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.modalPasarAprobado(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarAprobado", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/modalPasarAprobado"""))
   }
}
        

// @LINE:880
case controllers_haberes_LiquidacionPuestosAccionesController_pasarAprobadoMasivo719(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.pasarAprobadoMasivo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarAprobadoMasivo", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/pasarEnCursoMasivo"""))
   }
}
        

// @LINE:881
case controllers_haberes_LiquidacionPuestosAccionesController_modalPasarPreaprobado720(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.modalPasarPreaprobado(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarPreaprobado", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/modalPasarPreaprobado"""))
   }
}
        

// @LINE:882
case controllers_haberes_LiquidacionPuestosAccionesController_pasarPreaprobadoMasivo721(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.pasarPreaprobadoMasivo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarPreaprobadoMasivo", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/pasarPreaprobadoMasivo"""))
   }
}
        

// @LINE:883
case controllers_haberes_LiquidacionPuestosAccionesController_modalPasarBorrador722(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarBorrador", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/modalPasarBorrador"""))
   }
}
        

// @LINE:884
case controllers_haberes_LiquidacionPuestosAccionesController_pasarBorradorMasivo723(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarBorradorMasivo", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/pasarBorradorMasivo"""))
   }
}
        

// @LINE:885
case controllers_haberes_LiquidacionPuestosAccionesController_modalPasarCancelado724(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarCancelado", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionPuesto/modalPasarCancelado"""))
   }
}
        

// @LINE:886
case controllers_haberes_LiquidacionPuestosAccionesController_pasarCanceladoMasivo725(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionPuestosAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarCanceladoMasivo", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionPuesto/pasarCanceladoMasivo"""))
   }
}
        

// @LINE:888
case controllers_haberes_LiquidacionDetallesController_index726(params) => {
   call(params.fromQuery[Long]("id", Some(0)), params.fromQuery[Boolean]("editable", Some(false))) { (id, editable) =>
        invokeHandler(controllers.haberes.LiquidacionDetallesController.index(id, editable), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "index", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """haberes/liquidacion-detalle/index"""))
   }
}
        

// @LINE:889
case controllers_haberes_LiquidacionDetallesController_crear727(params) => {
   call(params.fromQuery[String]("liquidacionPuestoId", None)) { (liquidacionPuestoId) =>
        invokeHandler(controllers.haberes.LiquidacionDetallesController.crear(liquidacionPuestoId), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "crear", Seq(classOf[String]),"GET", """""", Routes.prefix + """haberes/liquidacion-detalle/crear"""))
   }
}
        

// @LINE:890
case controllers_haberes_LiquidacionDetallesController_editar728(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionDetallesController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacion-d20301766700etalle/editar"""))
   }
}
        

// @LINE:891
case controllers_haberes_LiquidacionDetallesController_guardar729(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionDetallesController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacion-detalle/guardar"""))
   }
}
        

// @LINE:892
case controllers_haberes_LiquidacionDetallesController_actualizar730(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionDetallesController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacion-detalle/actualizar"""))
   }
}
        

// @LINE:893
case controllers_haberes_LiquidacionDetallesController_eliminar731(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionDetallesController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacion-detalle/eliminar"""))
   }
}
        

// @LINE:895
case controllers_haberes_CargosLaboralesController_index732(params) => {
   call { 
        invokeHandler(controllers.haberes.CargosLaboralesController.index(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "index", Nil,"GET", """""", Routes.prefix + """haberes/cargoLaboral"""))
   }
}
        

// @LINE:896
case controllers_haberes_CargosLaboralesController_crear733(params) => {
   call { 
        invokeHandler(controllers.haberes.CargosLaboralesController.crear(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/cargoLaboral/crear"""))
   }
}
        

// @LINE:897
case controllers_haberes_CargosLaboralesController_guardar734(params) => {
   call { 
        invokeHandler(controllers.haberes.CargosLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/cargoLaboral/guardar"""))
   }
}
        

// @LINE:898
case controllers_haberes_CargosLaboralesController_editar735(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.CargosLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/cargoLaboral/editar"""))
   }
}
        

// @LINE:899
case controllers_haberes_CargosLaboralesController_eliminar736(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.CargosLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/cargoLaboral/eliminar"""))
   }
}
        

// @LINE:900
case controllers_haberes_CargosLaboralesController_actualizar737(params) => {
   call { 
        invokeHandler(controllers.haberes.CargosLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/cargoLaboral/actualizar"""))
   }
}
        

// @LINE:901
case controllers_haberes_CargosLaboralesController_modalBuscar738(params) => {
   call { 
        invokeHandler(controllers.haberes.CargosLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/cargoLaboral/modalBuscar"""))
   }
}
        

// @LINE:902
case controllers_haberes_CargosLaboralesController_get739(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.CargosLaboralesController.get(id), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/cargoLaboral/get"""))
   }
}
        

// @LINE:903
case controllers_haberes_CargosLaboralesController_ver740(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.CargosLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/cargoLaboral/ver"""))
   }
}
        

// @LINE:905
case controllers_haberes_CentrosCostosController_index741(params) => {
   call { 
        invokeHandler(controllers.haberes.CentrosCostosController.index(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "index", Nil,"GET", """""", Routes.prefix + """haberes/centroCosto"""))
   }
}
        

// @LINE:906
case controllers_haberes_CentrosCostosController_crear742(params) => {
   call { 
        invokeHandler(controllers.haberes.CentrosCostosController.crear(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/centroCosto/crear"""))
   }
}
        

// @LINE:907
case controllers_haberes_CentrosCostosController_guardar743(params) => {
   call { 
        invokeHandler(controllers.haberes.CentrosCostosController.guardar(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/centroCosto/guardar"""))
   }
}
        

// @LINE:908
case controllers_haberes_CentrosCostosController_editar744(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.CentrosCostosController.editar(id), HandlerDef(this, "controllers.haberes.CentrosCostosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/centroCosto/editar"""))
   }
}
        

// @LINE:909
case controllers_haberes_CentrosCostosController_eliminar745(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.CentrosCostosController.eliminar(id), HandlerDef(this, "controllers.haberes.CentrosCostosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/centroCosto/eliminar"""))
   }
}
        

// @LINE:910
case controllers_haberes_CentrosCostosController_actualizar746(params) => {
   call { 
        invokeHandler(controllers.haberes.CentrosCostosController.actualizar(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/centroCosto/actualizar"""))
   }
}
        

// @LINE:911
case controllers_haberes_CentrosCostosController_modalBuscar747(params) => {
   call { 
        invokeHandler(controllers.haberes.CentrosCostosController.modalBuscar(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/centroCosto/modalBuscar"""))
   }
}
        

// @LINE:912
case controllers_haberes_CentrosCostosController_get748(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.CentrosCostosController.get(id), HandlerDef(this, "controllers.haberes.CentrosCostosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/centroCosto/get"""))
   }
}
        

// @LINE:913
case controllers_haberes_CentrosCostosController_ver749(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.CentrosCostosController.ver(id), HandlerDef(this, "controllers.haberes.CentrosCostosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/centroCosto/ver"""))
   }
}
        

// @LINE:915
case controllers_haberes_EscalasLaboralesController_index750(params) => {
   call { 
        invokeHandler(controllers.haberes.EscalasLaboralesController.index(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "index", Nil,"GET", """""", Routes.prefix + """haberes/escalaLaboral"""))
   }
}
        

// @LINE:916
case controllers_haberes_EscalasLaboralesController_crear751(params) => {
   call { 
        invokeHandler(controllers.haberes.EscalasLaboralesController.crear(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/escalaLaboral/crear"""))
   }
}
        

// @LINE:917
case controllers_haberes_EscalasLaboralesController_guardar752(params) => {
   call { 
        invokeHandler(controllers.haberes.EscalasLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/escalaLaboral/guardar"""))
   }
}
        

// @LINE:918
case controllers_haberes_EscalasLaboralesController_editar753(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.EscalasLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/escalaLaboral/editar"""))
   }
}
        

// @LINE:919
case controllers_haberes_EscalasLaboralesController_eliminar754(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.EscalasLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/escalaLaboral/eliminar"""))
   }
}
        

// @LINE:920
case controllers_haberes_EscalasLaboralesController_actualizar755(params) => {
   call { 
        invokeHandler(controllers.haberes.EscalasLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/escalaLaboral/actualizar"""))
   }
}
        

// @LINE:921
case controllers_haberes_EscalasLaboralesController_modalBuscar756(params) => {
   call { 
        invokeHandler(controllers.haberes.EscalasLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/escalaLaboral/modalBuscar"""))
   }
}
        

// @LINE:922
case controllers_haberes_EscalasLaboralesController_get757(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.EscalasLaboralesController.get(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/escalaLaboral/get"""))
   }
}
        

// @LINE:923
case controllers_haberes_EscalasLaboralesController_ver758(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.EscalasLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/escalaLaboral/ver"""))
   }
}
        

// @LINE:924
case controllers_haberes_EscalasLaboralesController_suggestEscalaLaboral759(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.haberes.EscalasLaboralesController.suggestEscalaLaboral(input), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "suggestEscalaLaboral", Seq(classOf[String]),"GET", """""", Routes.prefix + """haberes/escalaLaboral/suggestEscalaLaboral/$input<[^/]+>"""))
   }
}
        

// @LINE:926
case controllers_haberes_ConveniosBancosController_index760(params) => {
   call { 
        invokeHandler(controllers.haberes.ConveniosBancosController.index(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "index", Nil,"GET", """""", Routes.prefix + """haberes/convenioBanco"""))
   }
}
        

// @LINE:927
case controllers_haberes_ConveniosBancosController_crear761(params) => {
   call { 
        invokeHandler(controllers.haberes.ConveniosBancosController.crear(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/convenioBanco/crear"""))
   }
}
        

// @LINE:928
case controllers_haberes_ConveniosBancosController_guardar762(params) => {
   call { 
        invokeHandler(controllers.haberes.ConveniosBancosController.guardar(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/convenioBanco/guardar"""))
   }
}
        

// @LINE:929
case controllers_haberes_ConveniosBancosController_editar763(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.ConveniosBancosController.editar(id), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/convenioBanco/editar"""))
   }
}
        

// @LINE:930
case controllers_haberes_ConveniosBancosController_eliminar764(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.ConveniosBancosController.eliminar(id), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/convenioBanco/eliminar"""))
   }
}
        

// @LINE:931
case controllers_haberes_ConveniosBancosController_actualizar765(params) => {
   call { 
        invokeHandler(controllers.haberes.ConveniosBancosController.actualizar(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/convenioBanco/actualizar"""))
   }
}
        

// @LINE:932
case controllers_haberes_ConveniosBancosController_modalBuscar766(params) => {
   call { 
        invokeHandler(controllers.haberes.ConveniosBancosController.modalBuscar(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/convenioBanco/modalBuscar"""))
   }
}
        

// @LINE:933
case controllers_haberes_ConveniosBancosController_get767(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.ConveniosBancosController.get(id), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/convenioBanco/get"""))
   }
}
        

// @LINE:934
case controllers_haberes_ConveniosBancosController_ver768(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.ConveniosBancosController.ver(id), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/convenioBanco/ver"""))
   }
}
        

// @LINE:936
case controllers_haberes_LegajosController_index769(params) => {
   call { 
        invokeHandler(controllers.haberes.LegajosController.index(), HandlerDef(this, "controllers.haberes.LegajosController", "index", Nil,"GET", """""", Routes.prefix + """haberes/legajo"""))
   }
}
        

// @LINE:937
case controllers_haberes_LegajosController_crear770(params) => {
   call { 
        invokeHandler(controllers.haberes.LegajosController.crear(), HandlerDef(this, "controllers.haberes.LegajosController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/legajo/crear"""))
   }
}
        

// @LINE:938
case controllers_haberes_LegajosController_guardar771(params) => {
   call { 
        invokeHandler(controllers.haberes.LegajosController.guardar(), HandlerDef(this, "controllers.haberes.LegajosController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/legajo/guardar"""))
   }
}
        

// @LINE:939
case controllers_haberes_LegajosController_editar772(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LegajosController.editar(id), HandlerDef(this, "controllers.haberes.LegajosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/legajo/editar"""))
   }
}
        

// @LINE:940
case controllers_haberes_LegajosController_eliminar773(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LegajosController.eliminar(id), HandlerDef(this, "controllers.haberes.LegajosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/legajo/eliminar"""))
   }
}
        

// @LINE:941
case controllers_haberes_LegajosController_actualizar774(params) => {
   call { 
        invokeHandler(controllers.haberes.LegajosController.actualizar(), HandlerDef(this, "controllers.haberes.LegajosController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/legajo/actualizar"""))
   }
}
        

// @LINE:942
case controllers_haberes_LegajosController_modalBuscar775(params) => {
   call { 
        invokeHandler(controllers.haberes.LegajosController.modalBuscar(), HandlerDef(this, "controllers.haberes.LegajosController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/legajo/modalBuscar"""))
   }
}
        

// @LINE:943
case controllers_haberes_LegajosController_get776(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.LegajosController.get(id), HandlerDef(this, "controllers.haberes.LegajosController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/legajo/get"""))
   }
}
        

// @LINE:944
case controllers_haberes_LegajosController_ver777(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LegajosController.ver(id), HandlerDef(this, "controllers.haberes.LegajosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/legajo/ver"""))
   }
}
        

// @LINE:946
case controllers_haberes_InstrumentosLegalesController_index778(params) => {
   call { 
        invokeHandler(controllers.haberes.InstrumentosLegalesController.index(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "index", Nil,"GET", """""", Routes.prefix + """haberes/instrumento"""))
   }
}
        

// @LINE:947
case controllers_haberes_InstrumentosLegalesController_crear779(params) => {
   call { 
        invokeHandler(controllers.haberes.InstrumentosLegalesController.crear(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/instrumento/crear"""))
   }
}
        

// @LINE:948
case controllers_haberes_InstrumentosLegalesController_guardar780(params) => {
   call { 
        invokeHandler(controllers.haberes.InstrumentosLegalesController.guardar(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/instrumento/guardar"""))
   }
}
        

// @LINE:949
case controllers_haberes_InstrumentosLegalesController_editar781(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.InstrumentosLegalesController.editar(id), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/instrumento/editar"""))
   }
}
        

// @LINE:950
case controllers_haberes_InstrumentosLegalesController_eliminar782(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.InstrumentosLegalesController.eliminar(id), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/instrumento/eliminar"""))
   }
}
        

// @LINE:951
case controllers_haberes_InstrumentosLegalesController_actualizar783(params) => {
   call { 
        invokeHandler(controllers.haberes.InstrumentosLegalesController.actualizar(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/instrumento/actualizar"""))
   }
}
        

// @LINE:952
case controllers_haberes_InstrumentosLegalesController_modalBuscar784(params) => {
   call { 
        invokeHandler(controllers.haberes.InstrumentosLegalesController.modalBuscar(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/instrumento/modalBuscar"""))
   }
}
        

// @LINE:953
case controllers_haberes_InstrumentosLegalesController_get785(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.InstrumentosLegalesController.get(id), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/instrumento/get"""))
   }
}
        

// @LINE:954
case controllers_haberes_InstrumentosLegalesController_ver786(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.InstrumentosLegalesController.ver(id), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/instrumento/ver"""))
   }
}
        

// @LINE:956
case controllers_haberes_LiquidacionMesesController_index787(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesController.index(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "index", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionMes"""))
   }
}
        

// @LINE:957
case controllers_haberes_LiquidacionMesesController_crear788(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionMes/crear"""))
   }
}
        

// @LINE:960
case controllers_haberes_LiquidacionMesesController_guardar789(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionMes/guardar"""))
   }
}
        

// @LINE:961
case controllers_haberes_LiquidacionMesesController_editar790(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/editar"""))
   }
}
        

// @LINE:962
case controllers_haberes_LiquidacionMesesController_eliminar791(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/eliminar"""))
   }
}
        

// @LINE:963
case controllers_haberes_LiquidacionMesesController_actualizar792(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionMes/actualizar"""))
   }
}
        

// @LINE:964
case controllers_haberes_LiquidacionMesesController_modalBuscar793(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "modalBuscar", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionMes/modalBuscar"""))
   }
}
        

// @LINE:965
case controllers_haberes_LiquidacionMesesController_get794(params) => {
   call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "get", Seq(classOf[Int]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/get"""))
   }
}
        

// @LINE:966
case controllers_haberes_LiquidacionMesesController_ver795(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/ver"""))
   }
}
        

// @LINE:967
case controllers_haberes_LiquidacionMesesController_preliquidar796(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesController.preliquidar(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "preliquidar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/preliquidar"""))
   }
}
        

// @LINE:968
case controllers_haberes_LiquidacionMesesReportesController_totalPorConceptos797(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.totalPorConceptos(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "totalPorConceptos", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/totalPorConceptos"""))
   }
}
        

// @LINE:969
case controllers_haberes_LiquidacionMesesReportesController_comparativoCertificacion798(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.comparativoCertificacion(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "comparativoCertificacion", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/comparativoCertificacion"""))
   }
}
        

// @LINE:970
case controllers_haberes_LiquidacionMesesReportesController_listadoSeguroVida799(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.listadoSeguroVida(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoSeguroVida", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/listadoSeguroVida"""))
   }
}
        

// @LINE:971
case controllers_haberes_LiquidacionMesesReportesController_listadoSeguroSepelio800(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.listadoSeguroSepelio(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoSeguroSepelio", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/listadoSeguroSepelio"""))
   }
}
        

// @LINE:972
case controllers_haberes_LiquidacionMesesReportesController_listadoJubilacion801(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.listadoJubilacion(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoJubilacion", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/listadoJubilacion"""))
   }
}
        

// @LINE:973
case controllers_haberes_LiquidacionMesesReportesController_listadoObraSocial802(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.listadoObraSocial(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoObraSocial", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/listadoObraSocial"""))
   }
}
        

// @LINE:974
case controllers_haberes_LiquidacionMesesReportesController_datosGenerales803(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.datosGenerales(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "datosGenerales", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/datosGenerales"""))
   }
}
        

// @LINE:975
case controllers_haberes_LiquidacionMesesReportesController_ordenDePago804(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.ordenDePago(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "ordenDePago", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/ordenDePago"""))
   }
}
        

// @LINE:976
case controllers_haberes_LiquidacionMesesReportesController_controlDescuentosBasicos805(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.controlDescuentosBasicos(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "controlDescuentosBasicos", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/controlDescuentosBasicos"""))
   }
}
        

// @LINE:977
case controllers_haberes_LiquidacionMesesReportesController_listadoPorConceptosPorPuestoLaboral806(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.listadoPorConceptosPorPuestoLaboral(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoPorConceptosPorPuestoLaboral", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/listadoPorConceptosPorPuestoLaboral"""))
   }
}
        

// @LINE:978
case controllers_haberes_LiquidacionMesesReportesController_listadoDePuestoLaboral807(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.listadoDePuestoLaboral(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoDePuestoLaboral", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/listadoDePuestoLaboral"""))
   }
}
        

// @LINE:979
case controllers_haberes_LiquidacionMesesReportesController_listadoGeneral808(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.listadoGeneral(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoGeneral", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/listadoGeneral"""))
   }
}
        

// @LINE:980
case controllers_haberes_LiquidacionMesesReportesController_listadoDePuestoLaboralComparativoPeriodo809(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.listadoDePuestoLaboralComparativoPeriodo(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoDePuestoLaboralComparativoPeriodo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/listadoDePuestoLaboralComparativoPeriodo"""))
   }
}
        

// @LINE:981
case controllers_haberes_LiquidacionMesesReportesController_listadoPorEscalaPorPuestoLaboral810(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.listadoPorEscalaPorPuestoLaboral(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoPorEscalaPorPuestoLaboral", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/listadoPorEscalaPorPuestoLaboral"""))
   }
}
        

// @LINE:982
case controllers_haberes_LiquidacionMesesReportesController_modalDatosAfip811(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.modalDatosAfip(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "modalDatosAfip", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/modalDatosAfip"""))
   }
}
        

// @LINE:983
case controllers_haberes_LiquidacionMesesReportesController_reportesDatosAfip812(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.reportesDatosAfip(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "reportesDatosAfip", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionMes/reportes/reportesDatosAfip"""))
   }
}
        

// @LINE:984
case controllers_haberes_LiquidacionMesesController_cambiarEstado813(params) => {
   call(params.fromQuery[Long]("idLiquidacion", None), params.fromQuery[Long]("idEstado", None)) { (idLiquidacion, idEstado) =>
        invokeHandler(controllers.haberes.LiquidacionMesesController.cambiarEstado(idLiquidacion, idEstado), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionMes/cambiarEstado"""))
   }
}
        

// @LINE:985
case controllers_haberes_LiquidacionMesesReportesController_modalDatosAfipGanancias814(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.modalDatosAfipGanancias(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "modalDatosAfipGanancias", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/modalDatosAfipGanancias"""))
   }
}
        

// @LINE:986
case controllers_haberes_LiquidacionMesesReportesController_reportesDatosAfipGanancias815(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.reportesDatosAfipGanancias(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "reportesDatosAfipGanancias", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionMes/reportes/reportesDatosAfipGanancias"""))
   }
}
        

// @LINE:987
case controllers_haberes_LiquidacionMesesReportesController_modalControlDatosAfipGanancias816(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.modalControlDatosAfipGanancias(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "modalControlDatosAfipGanancias", Nil,"GET", """""", Routes.prefix + """haberes/liquidacionMes/reportes/modalControlDatosAfipGanancias"""))
   }
}
        

// @LINE:988
case controllers_haberes_LiquidacionMesesReportesController_reportesControlDatosAfipGanancias817(params) => {
   call { 
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.reportesControlDatosAfipGanancias(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "reportesControlDatosAfipGanancias", Nil,"POST", """""", Routes.prefix + """haberes/liquidacionMes/reportes/reportesControlDatosAfipGanancias"""))
   }
}
        

// @LINE:990
case controllers_haberes_LiquidacionAccionesController_exportMacroSueldosLista818(params) => {
   call(params.fromQuery[Boolean]("nuevo", Some(false))) { (nuevo) =>
        invokeHandler(controllers.haberes.LiquidacionAccionesController.exportMacroSueldosLista(nuevo), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportMacroSueldosLista", Seq(classOf[Boolean]),"POST", """""", Routes.prefix + """haberes/liquidacionAcciones/exportMacroSueldosLista"""))
   }
}
        

// @LINE:991
case controllers_haberes_LiquidacionAccionesController_exportMacroSueldos819(params) => {
   call(params.fromQuery[Long]("liquidacionId", None), params.fromQuery[Boolean]("nuevo", Some(false))) { (liquidacionId, nuevo) =>
        invokeHandler(controllers.haberes.LiquidacionAccionesController.exportMacroSueldos(liquidacionId, nuevo), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportMacroSueldos", Seq(classOf[Long], classOf[Boolean]),"GET", """""", Routes.prefix + """haberes/liquidacionAcciones/exportMacroSueldos"""))
   }
}
        

// @LINE:992
case controllers_haberes_LiquidacionAccionesController_exportBanco820(params) => {
   call(params.fromQuery[Long]("liquidacionId", None)) { (liquidacionId) =>
        invokeHandler(controllers.haberes.LiquidacionAccionesController.exportBanco(liquidacionId), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportBanco", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionAcciones/exportBanco"""))
   }
}
        

// @LINE:993
case controllers_haberes_LiquidacionAccionesController_descargarBanco821(params) => {
   call(params.fromQuery[String]("url", None)) { (url) =>
        invokeHandler(controllers.haberes.LiquidacionAccionesController.descargarBanco(url), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "descargarBanco", Seq(classOf[String]),"GET", """""", Routes.prefix + """haberes/liquidacionAcciones/descargarBanco"""))
   }
}
        

// @LINE:994
case controllers_haberes_LiquidacionAccionesController_exportAfip822(params) => {
   call(params.fromQuery[Long]("liquidacionId", None)) { (liquidacionId) =>
        invokeHandler(controllers.haberes.LiquidacionAccionesController.exportAfip(liquidacionId), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportAfip", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionAcciones/exportAfip"""))
   }
}
        

// @LINE:995
case controllers_haberes_LiquidacionAccionesController_descargarAfip823(params) => {
   call(params.fromQuery[String]("url", None)) { (url) =>
        invokeHandler(controllers.haberes.LiquidacionAccionesController.descargarAfip(url), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "descargarAfip", Seq(classOf[String]),"GET", """""", Routes.prefix + """haberes/liquidacionAcciones/descargarAfip"""))
   }
}
        

// @LINE:996
case controllers_haberes_LiquidacionAccionesController_exportIps824(params) => {
   call(params.fromQuery[Long]("liquidacionId", None)) { (liquidacionId) =>
        invokeHandler(controllers.haberes.LiquidacionAccionesController.exportIps(liquidacionId), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportIps", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionAcciones/exportIps"""))
   }
}
        

// @LINE:997
case controllers_haberes_LiquidacionAccionesController_descargarIps825(params) => {
   call(params.fromQuery[String]("url", None)) { (url) =>
        invokeHandler(controllers.haberes.LiquidacionAccionesController.descargarIps(url), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "descargarIps", Seq(classOf[String]),"GET", """""", Routes.prefix + """haberes/liquidacionAcciones/descargarIps"""))
   }
}
        

// @LINE:998
case controllers_haberes_LiquidacionMesesReportesController_exportDatosPorConcepto826(params) => {
   call(params.fromQuery[Long]("liquidacionId", None), params.fromQuery[Long]("conceptoId", None)) { (liquidacionId, conceptoId) =>
        invokeHandler(controllers.haberes.LiquidacionMesesReportesController.exportDatosPorConcepto(liquidacionId, conceptoId), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "exportDatosPorConcepto", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """haberes/liquidacionAcciones/exportDatosPorConcepto"""))
   }
}
        

// @LINE:1000
case controllers_haberes_EscalasLaboralesMontosController_index827(params) => {
   call { 
        invokeHandler(controllers.haberes.EscalasLaboralesMontosController.index(), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "index", Nil,"GET", """""", Routes.prefix + """haberes/escalaLaboralMonto"""))
   }
}
        

// @LINE:1001
case controllers_haberes_EscalasLaboralesMontosController_crear828(params) => {
   call { 
        invokeHandler(controllers.haberes.EscalasLaboralesMontosController.crear(), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "crear", Nil,"GET", """""", Routes.prefix + """haberes/escalaLaboralMonto/crear"""))
   }
}
        

// @LINE:1002
case controllers_haberes_EscalasLaboralesMontosController_guardar829(params) => {
   call { 
        invokeHandler(controllers.haberes.EscalasLaboralesMontosController.guardar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "guardar", Nil,"POST", """""", Routes.prefix + """haberes/escalaLaboralMonto/guardar"""))
   }
}
        

// @LINE:1003
case controllers_haberes_EscalasLaboralesMontosController_editar830(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.EscalasLaboralesMontosController.editar(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "editar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/escalaLaboralMonto/editar"""))
   }
}
        

// @LINE:1004
case controllers_haberes_EscalasLaboralesMontosController_eliminar831(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.EscalasLaboralesMontosController.eliminar(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "eliminar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/escalaLaboralMonto/eliminar"""))
   }
}
        

// @LINE:1005
case controllers_haberes_EscalasLaboralesMontosController_actualizar832(params) => {
   call { 
        invokeHandler(controllers.haberes.EscalasLaboralesMontosController.actualizar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "actualizar", Nil,"POST", """""", Routes.prefix + """haberes/escalaLaboralMonto/actualizar"""))
   }
}
        

// @LINE:1006
case controllers_haberes_EscalasLaboralesMontosController_ver833(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.haberes.EscalasLaboralesMontosController.ver(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "ver", Seq(classOf[Long]),"GET", """""", Routes.prefix + """haberes/escalaLaboralMonto/ver"""))
   }
}
        

// @LINE:1008
case controllers_haberes_GananciasAccionesController_buscarDatosGananciasEnArchivos834(params) => {
   call { 
        invokeHandler(controllers.haberes.GananciasAccionesController.buscarDatosGananciasEnArchivos(), HandlerDef(this, "controllers.haberes.GananciasAccionesController", "buscarDatosGananciasEnArchivos", Nil,"POST", """""", Routes.prefix + """haberes/gananciasAcciones/buscarDatosGananciasEnArchivos"""))
   }
}
        

// @LINE:1009
case controllers_haberes_GananciasAccionesController_modalBuscarDatosGananciasEnArchivos835(params) => {
   call { 
        invokeHandler(controllers.haberes.GananciasAccionesController.modalBuscarDatosGananciasEnArchivos(), HandlerDef(this, "controllers.haberes.GananciasAccionesController", "modalBuscarDatosGananciasEnArchivos", Nil,"GET", """""", Routes.prefix + """haberes/gananciasAcciones/modalBuscarDatosGananciasEnArchivos"""))
   }
}
        

// @LINE:1010
case controllers_haberes_GananciasAccionesController_modalFormularioF649836(params) => {
   call { 
        invokeHandler(controllers.haberes.GananciasAccionesController.modalFormularioF649(), HandlerDef(this, "controllers.haberes.GananciasAccionesController", "modalFormularioF649", Nil,"POST", """""", Routes.prefix + """haberes/gananciasAcciones/modalFormularioF649"""))
   }
}
        

// @LINE:1012
case controllers_haberes_PrestaFacilController_enviarArchivo837(params) => {
   call { 
        invokeHandler(controllers.haberes.PrestaFacilController.enviarArchivo(), HandlerDef(this, "controllers.haberes.PrestaFacilController", "enviarArchivo", Nil,"GET", """""", Routes.prefix + """haberes/prestaFacil/enviarArchivo"""))
   }
}
        

// @LINE:1018
case controllers_haberes_LiquidacionMesesController_suggestLiquidacionMes838(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.haberes.LiquidacionMesesController.suggestLiquidacionMes(input), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "suggestLiquidacionMes", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestLiquidacionMes/$input<[^/]+>"""))
   }
}
        

// @LINE:1019
case controllers_compras_ArticulosController_suggestArticulo839(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.ArticulosController.suggestArticulo(input), HandlerDef(this, "controllers.compras.ArticulosController", "suggestArticulo", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestArticulo/$input<[^/]+>"""))
   }
}
        

// @LINE:1020
case controllers_compras_CategoriasController_suggestCategoria840(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.CategoriasController.suggestCategoria(input), HandlerDef(this, "controllers.compras.CategoriasController", "suggestCategoria", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestCategoria/$input<[^/]+>"""))
   }
}
        

// @LINE:1021
case controllers_compras_TipoProductosController_suggestTipoProducto841(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.TipoProductosController.suggestTipoProducto(input), HandlerDef(this, "controllers.compras.TipoProductosController", "suggestTipoProducto", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestTipoProducto/$input<[^/]+>"""))
   }
}
        

// @LINE:1023
case controllers_compras_ProductosController_suggestUdm842(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.ProductosController.suggestUdm(input), HandlerDef(this, "controllers.compras.ProductosController", "suggestUdm", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestUdm/$input<[^/]+>"""))
   }
}
        

// @LINE:1025
case controllers_expediente_IniciadorExpedientesController_suggestIniciadorExpediente843(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.expediente.IniciadorExpedientesController.suggestIniciadorExpediente(input), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "suggestIniciadorExpediente", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestIniciador/$input<[^/]+>"""))
   }
}
        

// @LINE:1026
case controllers_rrhh_DepartamentosController_suggestDepartamento844(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.rrhh.DepartamentosController.suggestDepartamento(input), HandlerDef(this, "controllers.rrhh.DepartamentosController", "suggestDepartamento", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestDepartamento/$input<[^/]+>"""))
   }
}
        

// @LINE:1027
case controllers_rrhh_EspecialidadesController_suggestEspecialidad845(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.rrhh.EspecialidadesController.suggestEspecialidad(input), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "suggestEspecialidad", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestEspecialidad/$input<[^/]+>"""))
   }
}
        

// @LINE:1028
case controllers_rrhh_ProfesionesController_suggestProfesion846(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.rrhh.ProfesionesController.suggestProfesion(input), HandlerDef(this, "controllers.rrhh.ProfesionesController", "suggestProfesion", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestProfesion/$input<[^/]+>"""))
   }
}
        

// @LINE:1029
case controllers_rrhh_TipoResidenciasController_suggestTipoResidencia847(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.rrhh.TipoResidenciasController.suggestTipoResidencia(input), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "suggestTipoResidencia", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestTipoResidencia/$input<[^/]+>"""))
   }
}
        

// @LINE:1030
case controllers_rrhh_PuestosController_suggestPuesto848(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.rrhh.PuestosController.suggestPuesto(input), HandlerDef(this, "controllers.rrhh.PuestosController", "suggestPuesto", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestPuesto/$input<[^/]+>"""))
   }
}
        

// @LINE:1032
case controllers_administracion_LocalidadesController_suggestLocalidad849(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.administracion.LocalidadesController.suggestLocalidad(input), HandlerDef(this, "controllers.administracion.LocalidadesController", "suggestLocalidad", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestLocalidad/$input<[^/]+>"""))
   }
}
        

// @LINE:1033
case controllers_rrhh_AgentesController_suggestAgente850(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.rrhh.AgentesController.suggestAgente(input), HandlerDef(this, "controllers.rrhh.AgentesController", "suggestAgente", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestAgente/$input<[^/]+>"""))
   }
}
        

// @LINE:1034
case controllers_compras_SolicitudesController_suggestSolicitud851(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.SolicitudesController.suggestSolicitud(input), HandlerDef(this, "controllers.compras.SolicitudesController", "suggestSolicitud", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestSolicitud/$input<[^/]+>"""))
   }
}
        

// @LINE:1035
case controllers_compras_OrdenesController_suggestOrden852(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.OrdenesController.suggestOrden(input), HandlerDef(this, "controllers.compras.OrdenesController", "suggestOrden", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestOrden/$input<[^/]+>"""))
   }
}
        

// @LINE:1037
case controllers_compras_ProveedoresController_suggestProveedor853(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.ProveedoresController.suggestProveedor(input), HandlerDef(this, "controllers.compras.ProveedoresController", "suggestProveedor", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestProveedor/$input<[^/]+>"""))
   }
}
        

// @LINE:1038
case controllers_delegacion_DepositosController_suggestDeposito854(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.delegacion.DepositosController.suggestDeposito(input), HandlerDef(this, "controllers.delegacion.DepositosController", "suggestDeposito", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestDeposito/$input<[^/]+>"""))
   }
}
        

// @LINE:1039
case controllers_compras_ClientesController_suggestCliente855(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.ClientesController.suggestCliente(input), HandlerDef(this, "controllers.compras.ClientesController", "suggestCliente", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestCliente/$input<[^/]+>"""))
   }
}
        

// @LINE:1040
case controllers_compras_ProductosController_suggestProducto856(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.ProductosController.suggestProducto(input), HandlerDef(this, "controllers.compras.ProductosController", "suggestProducto", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestProducto/$input<[^/]+>"""))
   }
}
        

// @LINE:1041
case controllers_compras_ProductosController_suggestProductoPresupuesto857(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.ProductosController.suggestProductoPresupuesto(input), HandlerDef(this, "controllers.compras.ProductosController", "suggestProductoPresupuesto", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestProductoPresupuesto/$input<[^/]+>"""))
   }
}
        

// @LINE:1042
case controllers_expediente_ExpedientesController_suggestExpediente858(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.expediente.ExpedientesController.suggestExpediente(input), HandlerDef(this, "controllers.expediente.ExpedientesController", "suggestExpediente", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestExpediente/$input<[^/]+>"""))
   }
}
        

// @LINE:1044
case controllers_compras_ProductosController_getDataSuggestSolicitud859(params) => {
   call(params.fromPath[String]("input", None), params.fromPath[Long]("idDeposito", None)) { (input, idDeposito) =>
        invokeHandler(controllers.compras.ProductosController.getDataSuggestSolicitud(input, idDeposito), HandlerDef(this, "controllers.compras.ProductosController", "getDataSuggestSolicitud", Seq(classOf[String], classOf[Long]),"GET", """""", Routes.prefix + """suggestProductoSolicitud/$idDeposito<[^/]+>/$input<[^/]+>"""))
   }
}
        

// @LINE:1046
case controllers_haberes_LiquidacionConceptosController_suggestLiquidacionConceptoTipo860(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.haberes.LiquidacionConceptosController.suggestLiquidacionConceptoTipo(input), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "suggestLiquidacionConceptoTipo", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestConcepto/$input<[^/]+>"""))
   }
}
        

// @LINE:1047
case controllers_haberes_PuestosLaboralesController_suggestPuestoLaboral861(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.haberes.PuestosLaboralesController.suggestPuestoLaboral(input), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "suggestPuestoLaboral", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestPuestoLaboral/$input<[^/]+>"""))
   }
}
        

// @LINE:1048
case controllers_haberes_PuestosLaboralesController_suggestPuestoLaboralTodos862(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.haberes.PuestosLaboralesController.suggestPuestoLaboralTodos(input), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "suggestPuestoLaboralTodos", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestPuestoLaboralTodos/$input<[^/]+>"""))
   }
}
        

// @LINE:1050
case controllers_administracion_OrganigramasController_suggestOrganigrama863(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.administracion.OrganigramasController.suggestOrganigrama(input), HandlerDef(this, "controllers.administracion.OrganigramasController", "suggestOrganigrama", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestOrganigrama/$input<[^/]+>"""))
   }
}
        

// @LINE:1051
case controllers_compras_ObrasSocialesController_suggestObrasocial864(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.compras.ObrasSocialesController.suggestObrasocial(input), HandlerDef(this, "controllers.compras.ObrasSocialesController", "suggestObrasocial", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestOb/$input<[^/]+>"""))
   }
}
        

// @LINE:1052
case controllers_expediente_ExpedientesController_suggestExpedienteCopia865(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.expediente.ExpedientesController.suggestExpedienteCopia(input), HandlerDef(this, "controllers.expediente.ExpedientesController", "suggestExpedienteCopia", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestExpedienteCopia/$input<[^/]+>"""))
   }
}
        

// @LINE:1053
case controllers_rrhh_CiesController_suggestCie866(params) => {
   call(params.fromPath[String]("input", None)) { (input) =>
        invokeHandler(controllers.rrhh.CiesController.suggestCie(input), HandlerDef(this, "controllers.rrhh.CiesController", "suggestCie", Seq(classOf[String]),"GET", """""", Routes.prefix + """suggestCie/$input<[^/]+>"""))
   }
}
        

// @LINE:1054
case controllers_Assets_at867(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     