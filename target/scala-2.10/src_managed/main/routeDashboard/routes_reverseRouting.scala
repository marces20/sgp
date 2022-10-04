// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routeDashboard.routes
// @HASH:9584acea7ab162a68e5aa6372ff713688149ed32
// @DATE:Tue Oct 04 11:43:27 ART 2022

import routeDashboard.Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:183
// @LINE:182
// @LINE:180
// @LINE:179
// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:165
// @LINE:163
// @LINE:162
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:141
// @LINE:139
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:121
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:112
// @LINE:110
// @LINE:109
// @LINE:106
// @LINE:104
// @LINE:103
// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:68
// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:33
// @LINE:31
// @LINE:30
// @LINE:28
// @LINE:27
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
package controllers.dashboard {

// @LINE:110
// @LINE:109
class ReverseInformesRecuperoController {
    

// @LINE:110
def deudasPorTipoDeCliente(idTipoCliente:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasRecuperoPorTipoDeCliente" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idTipoCliente", idTipoCliente)))))
}
                                                

// @LINE:109
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "indexInformeRecupero")
}
                                                
    
}
                          

// @LINE:106
// @LINE:104
// @LINE:103
class ReverseAutorizadoLineasController {
    

// @LINE:103
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:104
def eliminar(autorizado_id:Long, orden_id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("autorizado_id", autorizado_id)), Some(implicitly[QueryStringBindable[Long]].unbind("orden_id", orden_id)))))
}
                                                

// @LINE:106
def getActas(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado-linea/get-actas" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:28
class ReverseProfesionalesMedicosController {
    

// @LINE:28
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "profesionalesMedicos")
}
                                                
    
}
                          

// @LINE:180
class ReverseInventarioRismiController {
    

// @LINE:180
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "inventarioRismi")
}
                                                
    
}
                          

// @LINE:165
// @LINE:160
// @LINE:159
// @LINE:157
// @LINE:156
// @LINE:154
// @LINE:150
// @LINE:149
class ReverseDeudasPorAntiguedadController {
    

// @LINE:154
def deudasResumenMensual(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasResumenMensual")
}
                                                

// @LINE:165
def deudasDetallesCuenta(idCuenta:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesAntiguedadCuenta" + queryString(List(if(idCuenta == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("idCuenta", idCuenta)))))
}
                                                

// @LINE:150
def deudasDetalles(idProveedor:Int = 0, equipamiento:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasPorProveedorPorAntiguedad" + queryString(List(if(idProveedor == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("idProveedor", idProveedor)), if(equipamiento == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("equipamiento", equipamiento)))))
}
                                                

// @LINE:156
def deudasDetallesServicios(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesServiciosPorAntiguedad")
}
                                                

// @LINE:160
def deudasResumenInstitucion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasResumenInstitucion")
}
                                                

// @LINE:159
def deudasDetallesInstitucion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesInstitucion")
}
                                                

// @LINE:157
def deudasDetallesPorProveedor(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesPorAntiguedaPorProveedor")
}
                                                

// @LINE:149
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasPorAntigueda")
}
                                                
    
}
                          

// @LINE:49
// @LINE:47
// @LINE:44
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:33
class ReverseLiquidacionesController {
    

// @LINE:37
def getLiquidacionesPorPuestoPorPeriodo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getLiquidacionesPorPuestoPorPeriodo")
}
                                                

// @LINE:47
def liquidacionesTotalesPorEscala(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesTotalesPorEscala")
}
                                                

// @LINE:49
def liquidacionesPorAgrupadoOrganigrama(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesPorAgrupadoOrganigrama")
}
                                                

// @LINE:39
def liquidacionesPorEscala(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesPorEscala")
}
                                                

// @LINE:38
def getLiquidacionesPorPuestoPorPeriodoPorClasificacion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getLiquidacionesPorPuestoPorPeriodoPorClasificacion")
}
                                                

// @LINE:44
def liquidacionesPorOrganigrama(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesPorOrganigrama")
}
                                                

// @LINE:41
def liquidacionesPorProfesion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesPorProfesion")
}
                                                

// @LINE:33
def liquidacionesPorPuesto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesPorPuesto")
}
                                                

// @LINE:36
def getLiquidacionesPorPuesto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getLiquidacionesPorPuesto")
}
                                                

// @LINE:40
def getDetalleLiquidacionClasificacion(idPuestoLaboral:Int, idPeriodo:Int, idClasificacion:Int): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "getDetalleLiquidacionClasificacion" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("idPuestoLaboral", idPuestoLaboral)), Some(implicitly[QueryStringBindable[Int]].unbind("idPeriodo", idPeriodo)), Some(implicitly[QueryStringBindable[Int]].unbind("idClasificacion", idClasificacion)))))
}
                                                
    
}
                          

// @LINE:141
// @LINE:139
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
class ReverseDeudasGlobalizadasReportesController {
    

// @LINE:132
def deudasInformeGeneral(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasInformeGeneral")
}
                                                

// @LINE:137
def deudasHonorariosProveedoresResumenReportes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasHonorariosProveedoresResumenReportes")
}
                                                

// @LINE:139
def deudasCuentasReportes(idCuenta:Int = 0, soloDeuda:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasCuentasReportes" + queryString(List(if(idCuenta == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("idCuenta", idCuenta)), if(soloDeuda == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("soloDeuda", soloDeuda)))))
}
                                                

// @LINE:141
def deudasDetallesOtrosProveedoresResumen(profe:Boolean = false, equipamientos:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasOtrosProveedoresResumenReporte" + queryString(List(if(profe == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("profe", profe)), if(equipamientos == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("equipamientos", equipamientos)))))
}
                                                

// @LINE:129
def deudasResumidasReporte(deposito:Int = 0, ra:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasResumidasReporte" + queryString(List(if(deposito == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("deposito", deposito)), if(ra == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("ra", ra)))))
}
                                                

// @LINE:136
def deudasServiciosProveedoresResumenReportes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasServiciosProveedoresResumenReportes")
}
                                                

// @LINE:135
def deudasDetallesHonorariosReportes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesHonorariosReportes")
}
                                                

// @LINE:130
def deudasDetallesReporte(idProveedor:Int = 0, ra:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesReporte" + queryString(List(if(idProveedor == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("idProveedor", idProveedor)), if(ra == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("ra", ra)))))
}
                                                

// @LINE:134
def deudasDetallesServiciosReportes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesServiciosReportes")
}
                                                

// @LINE:133
def deudasInformeGeneralResumen(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasInformeGeneralResumen")
}
                                                

// @LINE:131
def deudasDetallesOtrosReportes(profe:Boolean = false, equipamientos:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesOtrosReportes" + queryString(List(if(profe == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("profe", profe)), if(equipamientos == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("equipamientos", equipamientos)))))
}
                                                
    
}
                          

// @LINE:56
// @LINE:55
class ReverseProveedoresController {
    

// @LINE:55
def estadoPorExpedientePorLinea(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "estadoPorExpedientePorLinea")
}
                                                

// @LINE:56
def reporteEstadoDefinitivoExpedienteLineas(proveedorId:Long = 0, rubroId:Long = 0, ejercicioId:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reporteEstadoDefinitivoExpedienteLineas" + queryString(List(if(proveedorId == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("proveedorId", proveedorId)), if(rubroId == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("rubroId", rubroId)), if(ejercicioId == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("ejercicioId", ejercicioId)))))
}
                                                
    
}
                          

// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
class ReverseUltimasCotizacionesController {
    

// @LINE:146
def guardarUltimaCotizaciones(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cotizacion/guardar")
}
                                                

// @LINE:147
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cotizacion/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:144
def indexUltimaCotizaciones(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cotizacion")
}
                                                

// @LINE:145
def crearUltimaCotizaciones(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cotizacion/crear")
}
                                                
    
}
                          

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
class ReverseMovimientosCuentasController {
    

// @LINE:177
def conciliacion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "conciliacion")
}
                                                

// @LINE:174
def resumenFinancieroGeneral(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "resumenFinancieroGeneral")
}
                                                

// @LINE:175
def resumenFinancieroDetalle(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "resumenFinancieroDetalle")
}
                                                

// @LINE:176
def resumenFinancieroDetallePorInstitucion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "resumenFinancieroDetalleInstitucion")
}
                                                

// @LINE:173
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "resumenFinanciero")
}
                                                
    
}
                          

// @LINE:183
// @LINE:182
class ReversePresupuestoController {
    

// @LINE:182
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presuControl")
}
                                                

// @LINE:183
def devengado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presuControl/devengado")
}
                                                
    
}
                          

// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:58
class ReverseInformeEstadisticoDeudaProveedoresController {
    

// @LINE:61
def diferencias(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "diferencias")
}
                                                

// @LINE:65
def getActas(id_orden_provision:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe-estadistico-deuda-proveedores/get-actas" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id_orden_provision", id_orden_provision)))))
}
                                                

// @LINE:64
def archivoEstadistico(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe-estadistico-deuda-proveedores/descarga")
}
                                                

// @LINE:62
def procesarDiferencias(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "procesar-diferencias")
}
                                                

// @LINE:58
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe-estadistico-deuda-proveedores")
}
                                                
    
}
                          

// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
class ReverseAutorizadosController {
    

// @LINE:88
def getListadoDeudasActas(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/getListadoDeudasActas")
}
                                                

// @LINE:83
def cambiarEstado(idAutorizado:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idAutorizado", idAutorizado)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:96
def getResumen(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/getResumen" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:77
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/crear")
}
                                                

// @LINE:82
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:94
def modalAgregarMontosCertificacionesCompras(idCertificacion:Long = 0, idAutorizado:Long, idOrdenCompra:Long, tipo_cuenta_id:Long = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/modalAgregarMontosCertificacionesCompras" + queryString(List(if(idCertificacion == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idCertificacion", idCertificacion)), Some(implicitly[QueryStringBindable[Long]].unbind("idAutorizado", idAutorizado)), Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenCompra", idOrdenCompra)), if(tipo_cuenta_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("tipo_cuenta_id", tipo_cuenta_id)))))
}
                                                

// @LINE:89
def getActualizarDatos(idAutorizado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/getActualizarDatos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idAutorizado", idAutorizado)))))
}
                                                

// @LINE:87
def getListadoDeudas(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/getListadoDeudas")
}
                                                

// @LINE:90
def controlCargaCotizacion(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/controlCargaCotizacion")
}
                                                

// @LINE:99
def reporteAutorizadoRemitos(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/reporteAutorizadoRemitos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:85
def cargarLineasAutorizadosCertificacionesCompras(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/cargarLineasAutorizadosCertificacionesCompras")
}
                                                

// @LINE:92
def modalAgregarMontosActas(idActa:Long = 0, idOrdenProvision:Long = 0, idAutorizado:Long, idOrdenCompra:Long = 0, tipo_cuenta_id:Long = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/modalAgregarMontosActas" + queryString(List(if(idActa == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idActa", idActa)), if(idOrdenProvision == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenProvision", idOrdenProvision)), Some(implicitly[QueryStringBindable[Long]].unbind("idAutorizado", idAutorizado)), if(idOrdenCompra == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenCompra", idOrdenCompra)), if(tipo_cuenta_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("tipo_cuenta_id", tipo_cuenta_id)))))
}
                                                

// @LINE:81
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:80
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:98
def reporteAutorizadoExcel(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/reporteAutorizadoExcel" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:101
def cargarLineasAutorizadosMasivamente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/cargarLineasAutorizadosMasivamente")
}
                                                

// @LINE:78
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/guardar")
}
                                                

// @LINE:84
def cargarLineasAutorizados(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/cargarLineasAutorizados")
}
                                                

// @LINE:97
def reporteAutorizado(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/reporteAutorizado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:79
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:76
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizado")
}
                                                

// @LINE:86
def modalAgregarMontos(idOrdenProvision:Long = 0, idAutorizado:Long, idOrdenCompra:Long = 0, tipo_cuenta_id:Long = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/modalAgregarMontos" + queryString(List(if(idOrdenProvision == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenProvision", idOrdenProvision)), Some(implicitly[QueryStringBindable[Long]].unbind("idAutorizado", idAutorizado)), if(idOrdenCompra == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenCompra", idOrdenCompra)), if(tipo_cuenta_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("tipo_cuenta_id", tipo_cuenta_id)))))
}
                                                

// @LINE:93
def modalAgregarMontosSinOp(idAutorizado:Long, idOrdenCompra:Long = 0, tipo_cuenta_id:Long = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "autorizado/modalAgregarMontosSinOp" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idAutorizado", idAutorizado)), if(idOrdenCompra == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenCompra", idOrdenCompra)), if(tipo_cuenta_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("tipo_cuenta_id", tipo_cuenta_id)))))
}
                                                
    
}
                          

// @LINE:30
// @LINE:27
class ReverseHonorariosNewController {
    

// @LINE:30
def listadoHonorariosReporte(id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "listadoHonorariosReporte" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:27
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "honorariosNew")
}
                                                
    
}
                          

// @LINE:179
class ReverseAuditoriaController {
    

// @LINE:179
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "auditoria")
}
                                                
    
}
                          

// @LINE:53
// @LINE:52
class ReverseImpuestosController {
    

// @LINE:53
def detalleImpuestos(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "detalleImpuestos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:52
def estadoDeuda(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "impuestosDeuda")
}
                                                
    
}
                          

// @LINE:50
// @LINE:46
// @LINE:45
// @LINE:42
class ReverseLiquidacionesReportesController {
    

// @LINE:46
def liquidacionesPorEscala(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesPorEscalaReporte")
}
                                                

// @LINE:42
def liquidacionesPorProfesion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesPorProfesionReporte")
}
                                                

// @LINE:50
def liquidacionesPorAgrupadoOrganigrama(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesPorAgrupadoOrganigramaReporte")
}
                                                

// @LINE:45
def liquidacionesPorOrganigrama(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "liquidacionesPorOrganigramaReporte")
}
                                                
    
}
                          

// @LINE:2
class ReverseIndexController {
    

// @LINE:2
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:163
// @LINE:162
// @LINE:161
// @LINE:155
// @LINE:153
// @LINE:152
// @LINE:151
class ReverseDeudasPorAntiguedadReportesController {
    

// @LINE:152
def deudasInformeGeneral(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasInformeGeneralPorAntiguedad")
}
                                                

// @LINE:162
def deudasResumenPorInstitucionReporte(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasResumenPorInstitucionReporte")
}
                                                

// @LINE:153
def deudasInformeGeneralNuevo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasInformeGeneralPorAntiguedadNuevo")
}
                                                

// @LINE:161
def deudasDetallePorInstitucionReporte(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallePorInstitucionReporte")
}
                                                

// @LINE:163
def deudasDetallesServiciosReportes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesAntiguedadServiciosReportes")
}
                                                

// @LINE:151
def deudasDetallesReporte(idProveedor:Int = 0, equipamiento:Boolean = false, idCuenta:Int = 0, sinServicio:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesPorAntiguedadReporte" + queryString(List(if(idProveedor == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("idProveedor", idProveedor)), if(equipamiento == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("equipamiento", equipamiento)), if(idCuenta == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("idCuenta", idCuenta)), if(sinServicio == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("sinServicio", sinServicio)))))
}
                                                

// @LINE:155
def deudasMensualReporte(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasMensualReporte")
}
                                                
    
}
                          

// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:68
// @LINE:67
class ReverseInformeEstadisticoPagoProveedoresController {
    

// @LINE:71
def informePeriodoProveedorReporte(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe-pago-periodo-proveedores-reportes")
}
                                                

// @LINE:73
def informeProveedor(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informeProveedor")
}
                                                

// @LINE:68
def archivoEstadistico(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe-estadistico-pago-proveedores/descarga")
}
                                                

// @LINE:67
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe-estadistico-pago-proveedores")
}
                                                

// @LINE:70
def informePeriodoProveedor(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe-pago-periodo-proveedores")
}
                                                
    
}
                          

// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
class ReverseControlDeudaController {
    

// @LINE:168
def autorizadoDistintoDePagado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autorizadoDistintoDePagado")
}
                                                

// @LINE:171
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "indexControlDeuda")
}
                                                

// @LINE:170
def controlDeudaMonedaExtranjera(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "controlDeudaMonedaExtranjera")
}
                                                

// @LINE:169
def getAutorizadoDistintoDePagado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAutorizadoDistintoDePagado")
}
                                                
    
}
                          

// @LINE:31
class ReverseHonorariosNewReportesController {
    

// @LINE:31
def informeHonorarioPorPeriodo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informeHonorarioPorPeriodo")
}
                                                
    
}
                          

// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:121
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
class ReverseDeudasGlobalizadasController {
    

// @LINE:118
def deudasDetallesCuentas(idCuenta:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesCuentas" + queryString(List(if(idCuenta == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("idCuenta", idCuenta)))))
}
                                                

// @LINE:126
def deudasDetallesHonorarios(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesHonorarios")
}
                                                

// @LINE:121
def deudasDetallesOtrosProveedoresResumen(profe:Boolean = false, equipamientos:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesOtrosProveedoresResumen" + queryString(List(if(profe == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("profe", profe)), if(equipamientos == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("equipamientos", equipamientos)))))
}
                                                

// @LINE:116
def deudasDetalles(idProveedor:Int = 0, ra:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasPorProveedorHEARM" + queryString(List(if(idProveedor == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("idProveedor", idProveedor)), if(ra == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("ra", ra)))))
}
                                                

// @LINE:124
def deudasDetallesServicios(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesServicios")
}
                                                

// @LINE:117
def deudasDetallesOtros(profe:Boolean = false, equipamientos:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesOtros" + queryString(List(if(profe == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("profe", profe)), if(equipamientos == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("equipamientos", equipamientos)))))
}
                                                

// @LINE:119
def deudasDetallesPorProveedor(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesPorProveedor")
}
                                                

// @LINE:115
def deudasResumidas(deposito:Int = 0, ra:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasResumidas" + queryString(List(if(deposito == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("deposito", deposito)), if(ra == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("ra", ra)))))
}
                                                

// @LINE:125
def deudasDetallesServiciosResumen(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesServiciosResumen")
}
                                                

// @LINE:114
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudas")
}
                                                

// @LINE:127
def deudasDetallesHonorariosResumen(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasDetallesHonorariosResumen")
}
                                                
    
}
                          

// @LINE:112
class ReverseInformesRecuperoReportesController {
    

// @LINE:112
def deudasPorTipoDeCliente(idTipoCliente:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deudasRecuperoPorTipoDeClienteReporte" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idTipoCliente", idTipoCliente)))))
}
                                                
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
class ReverseHonorariosController {
    

// @LINE:4
def estadoDeuda(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "estadoDeudaHonorarios")
}
                                                

// @LINE:5
def getEstadoDeudaPorEjercicio(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getEstadoDeudaPorEjercicio")
}
                                                

// @LINE:13
def getDatosEstadoGeneralPorAgente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "estadoGeneralAgente/getDatosEstadoGeneralPorAgente")
}
                                                

// @LINE:15
def getFacturacionEstadoGeneralPorAgente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "estadoGeneralAgente/getFacturacionEstadoGeneralPorAgente")
}
                                                

// @LINE:12
def estadoGeneralPorAgente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "estadoGeneralAgente")
}
                                                

// @LINE:22
def estadoDeudaMonotributoExcel(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "estadoDeudaMonotributoExcel")
}
                                                

// @LINE:20
def getHonorarioDepartamento(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "honorarios/getHonorarioDepartamento")
}
                                                

// @LINE:9
def getDataEstadoDeudaPagadosPorPeriodo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getDataEstadoDeudaPagadosPorPeriodo")
}
                                                

// @LINE:24
def estadoDeudaMonotributoExcelProfe(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "estadoDeudaMonotributoExcelProfe")
}
                                                

// @LINE:10
def getDataEstadoDeudaNoPagadosPorPeriodo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getDataEstadoDeudaNoPagadosPorPeriodo")
}
                                                

// @LINE:17
def getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "estadoGeneralAgente/getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo")
}
                                                

// @LINE:6
def getEstadoDeudaPorPeriodo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getEstadoDeudaPorPeriodo")
}
                                                

// @LINE:7
def getDataEstadoDeudaPagadosPorEjercicio(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getDataEstadoDeudaPagadosPorEjercicio")
}
                                                

// @LINE:8
def getDataEstadoDeudaNoPagadosPorEjercicio(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getDataEstadoDeudaNoPagadosPorEjercicio")
}
                                                

// @LINE:16
def getPagosEstadoGeneralPorAgente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "estadoGeneralAgente/getPagosEstadoGeneralPorAgente")
}
                                                

// @LINE:14
def getCertificacionesEstadoGeneralPorAgente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "estadoGeneralAgente/getCertificacionesEstadoGeneralPorAgente")
}
                                                

// @LINE:21
def estadoDeudaMonotributo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "estadoDeudaMonotributo")
}
                                                

// @LINE:18
def porDepartamento(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "honorarios/porDepartamentos")
}
                                                

// @LINE:23
def estadoDeudaMonotributoProfe(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "estadoDeudaMonotributoProfe")
}
                                                

// @LINE:19
def getAgentesTotalDepartamento(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "honorarios/agentesDepartamentos")
}
                                                

// @LINE:3
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "honorarios")
}
                                                
    
}
                          

// @LINE:60
// @LINE:59
class ReverseInformeDeudaPorActasController {
    

// @LINE:60
def archivoDeudaPorActas(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "archivo-deuda-actas")
}
                                                

// @LINE:59
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe-deuda-actas")
}
                                                
    
}
                          
}
                  


// @LINE:183
// @LINE:182
// @LINE:180
// @LINE:179
// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:165
// @LINE:163
// @LINE:162
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:141
// @LINE:139
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:121
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:112
// @LINE:110
// @LINE:109
// @LINE:106
// @LINE:104
// @LINE:103
// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:68
// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:33
// @LINE:31
// @LINE:30
// @LINE:28
// @LINE:27
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
package controllers.dashboard.javascript {

// @LINE:110
// @LINE:109
class ReverseInformesRecuperoController {
    

// @LINE:110
def deudasPorTipoDeCliente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformesRecuperoController.deudasPorTipoDeCliente",
   """
      function(idTipoCliente) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasRecuperoPorTipoDeCliente" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idTipoCliente", idTipoCliente)])})
      }
   """
)
                        

// @LINE:109
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformesRecuperoController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "indexInformeRecupero"})
      }
   """
)
                        
    
}
              

// @LINE:106
// @LINE:104
// @LINE:103
class ReverseAutorizadoLineasController {
    

// @LINE:103
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadoLineasController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:104
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadoLineasController.eliminar",
   """
      function(autorizado_id,orden_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("autorizado_id", autorizado_id), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("orden_id", orden_id)])})
      }
   """
)
                        

// @LINE:106
def getActas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadoLineasController.getActas",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado-linea/get-actas" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:28
class ReverseProfesionalesMedicosController {
    

// @LINE:28
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.ProfesionalesMedicosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profesionalesMedicos"})
      }
   """
)
                        
    
}
              

// @LINE:180
class ReverseInventarioRismiController {
    

// @LINE:180
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InventarioRismiController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inventarioRismi"})
      }
   """
)
                        
    
}
              

// @LINE:165
// @LINE:160
// @LINE:159
// @LINE:157
// @LINE:156
// @LINE:154
// @LINE:150
// @LINE:149
class ReverseDeudasPorAntiguedadController {
    

// @LINE:154
def deudasResumenMensual : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadController.deudasResumenMensual",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasResumenMensual"})
      }
   """
)
                        

// @LINE:165
def deudasDetallesCuenta : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesCuenta",
   """
      function(idCuenta) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesAntiguedadCuenta" + _qS([(idCuenta == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idCuenta", idCuenta))])})
      }
   """
)
                        

// @LINE:150
def deudasDetalles : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadController.deudasDetalles",
   """
      function(idProveedor,equipamiento) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasPorProveedorPorAntiguedad" + _qS([(idProveedor == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idProveedor", idProveedor)), (equipamiento == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("equipamiento", equipamiento))])})
      }
   """
)
                        

// @LINE:156
def deudasDetallesServicios : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesServicios",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesServiciosPorAntiguedad"})
      }
   """
)
                        

// @LINE:160
def deudasResumenInstitucion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadController.deudasResumenInstitucion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasResumenInstitucion"})
      }
   """
)
                        

// @LINE:159
def deudasDetallesInstitucion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesInstitucion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesInstitucion"})
      }
   """
)
                        

// @LINE:157
def deudasDetallesPorProveedor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesPorProveedor",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesPorAntiguedaPorProveedor"})
      }
   """
)
                        

// @LINE:149
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasPorAntigueda"})
      }
   """
)
                        
    
}
              

// @LINE:49
// @LINE:47
// @LINE:44
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:33
class ReverseLiquidacionesController {
    

// @LINE:37
def getLiquidacionesPorPuestoPorPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuestoPorPeriodo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getLiquidacionesPorPuestoPorPeriodo"})
      }
   """
)
                        

// @LINE:47
def liquidacionesTotalesPorEscala : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.liquidacionesTotalesPorEscala",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesTotalesPorEscala"})
      }
   """
)
                        

// @LINE:49
def liquidacionesPorAgrupadoOrganigrama : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.liquidacionesPorAgrupadoOrganigrama",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesPorAgrupadoOrganigrama"})
      }
   """
)
                        

// @LINE:39
def liquidacionesPorEscala : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.liquidacionesPorEscala",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesPorEscala"})
      }
   """
)
                        

// @LINE:38
def getLiquidacionesPorPuestoPorPeriodoPorClasificacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuestoPorPeriodoPorClasificacion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getLiquidacionesPorPuestoPorPeriodoPorClasificacion"})
      }
   """
)
                        

// @LINE:44
def liquidacionesPorOrganigrama : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.liquidacionesPorOrganigrama",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesPorOrganigrama"})
      }
   """
)
                        

// @LINE:41
def liquidacionesPorProfesion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.liquidacionesPorProfesion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesPorProfesion"})
      }
   """
)
                        

// @LINE:33
def liquidacionesPorPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.liquidacionesPorPuesto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesPorPuesto"})
      }
   """
)
                        

// @LINE:36
def getLiquidacionesPorPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuesto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getLiquidacionesPorPuesto"})
      }
   """
)
                        

// @LINE:40
def getDetalleLiquidacionClasificacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesController.getDetalleLiquidacionClasificacion",
   """
      function(idPuestoLaboral,idPeriodo,idClasificacion) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDetalleLiquidacionClasificacion" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idPuestoLaboral", idPuestoLaboral), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idPeriodo", idPeriodo), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idClasificacion", idClasificacion)])})
      }
   """
)
                        
    
}
              

// @LINE:141
// @LINE:139
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
class ReverseDeudasGlobalizadasReportesController {
    

// @LINE:132
def deudasInformeGeneral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasInformeGeneral",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasInformeGeneral"})
      }
   """
)
                        

// @LINE:137
def deudasHonorariosProveedoresResumenReportes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasHonorariosProveedoresResumenReportes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasHonorariosProveedoresResumenReportes"})
      }
   """
)
                        

// @LINE:139
def deudasCuentasReportes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasCuentasReportes",
   """
      function(idCuenta,soloDeuda) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasCuentasReportes" + _qS([(idCuenta == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idCuenta", idCuenta)), (soloDeuda == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("soloDeuda", soloDeuda))])})
      }
   """
)
                        

// @LINE:141
def deudasDetallesOtrosProveedoresResumen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesOtrosProveedoresResumen",
   """
      function(profe,equipamientos) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasOtrosProveedoresResumenReporte" + _qS([(profe == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("profe", profe)), (equipamientos == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("equipamientos", equipamientos))])})
      }
   """
)
                        

// @LINE:129
def deudasResumidasReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasResumidasReporte",
   """
      function(deposito,ra) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasResumidasReporte" + _qS([(deposito == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("deposito", deposito)), (ra == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("ra", ra))])})
      }
   """
)
                        

// @LINE:136
def deudasServiciosProveedoresResumenReportes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasServiciosProveedoresResumenReportes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasServiciosProveedoresResumenReportes"})
      }
   """
)
                        

// @LINE:135
def deudasDetallesHonorariosReportes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesHonorariosReportes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesHonorariosReportes"})
      }
   """
)
                        

// @LINE:130
def deudasDetallesReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesReporte",
   """
      function(idProveedor,ra) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesReporte" + _qS([(idProveedor == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idProveedor", idProveedor)), (ra == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("ra", ra))])})
      }
   """
)
                        

// @LINE:134
def deudasDetallesServiciosReportes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesServiciosReportes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesServiciosReportes"})
      }
   """
)
                        

// @LINE:133
def deudasInformeGeneralResumen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasInformeGeneralResumen",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasInformeGeneralResumen"})
      }
   """
)
                        

// @LINE:131
def deudasDetallesOtrosReportes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesOtrosReportes",
   """
      function(profe,equipamientos) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesOtrosReportes" + _qS([(profe == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("profe", profe)), (equipamientos == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("equipamientos", equipamientos))])})
      }
   """
)
                        
    
}
              

// @LINE:56
// @LINE:55
class ReverseProveedoresController {
    

// @LINE:55
def estadoPorExpedientePorLinea : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.ProveedoresController.estadoPorExpedientePorLinea",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoPorExpedientePorLinea"})
      }
   """
)
                        

// @LINE:56
def reporteEstadoDefinitivoExpedienteLineas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.ProveedoresController.reporteEstadoDefinitivoExpedienteLineas",
   """
      function(proveedorId,rubroId,ejercicioId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reporteEstadoDefinitivoExpedienteLineas" + _qS([(proveedorId == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("proveedorId", proveedorId)), (rubroId == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("rubroId", rubroId)), (ejercicioId == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("ejercicioId", ejercicioId))])})
      }
   """
)
                        
    
}
              

// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
class ReverseUltimasCotizacionesController {
    

// @LINE:146
def guardarUltimaCotizaciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.UltimasCotizacionesController.guardarUltimaCotizaciones",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cotizacion/guardar"})
      }
   """
)
                        

// @LINE:147
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.UltimasCotizacionesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cotizacion/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:144
def indexUltimaCotizaciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.UltimasCotizacionesController.indexUltimaCotizaciones",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cotizacion"})
      }
   """
)
                        

// @LINE:145
def crearUltimaCotizaciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.UltimasCotizacionesController.crearUltimaCotizaciones",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cotizacion/crear"})
      }
   """
)
                        
    
}
              

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
class ReverseMovimientosCuentasController {
    

// @LINE:177
def conciliacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.MovimientosCuentasController.conciliacion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "conciliacion"})
      }
   """
)
                        

// @LINE:174
def resumenFinancieroGeneral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.MovimientosCuentasController.resumenFinancieroGeneral",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "resumenFinancieroGeneral"})
      }
   """
)
                        

// @LINE:175
def resumenFinancieroDetalle : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.MovimientosCuentasController.resumenFinancieroDetalle",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "resumenFinancieroDetalle"})
      }
   """
)
                        

// @LINE:176
def resumenFinancieroDetallePorInstitucion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.MovimientosCuentasController.resumenFinancieroDetallePorInstitucion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "resumenFinancieroDetalleInstitucion"})
      }
   """
)
                        

// @LINE:173
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.MovimientosCuentasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "resumenFinanciero"})
      }
   """
)
                        
    
}
              

// @LINE:183
// @LINE:182
class ReversePresupuestoController {
    

// @LINE:182
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.PresupuestoController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presuControl"})
      }
   """
)
                        

// @LINE:183
def devengado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.PresupuestoController.devengado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presuControl/devengado"})
      }
   """
)
                        
    
}
              

// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:58
class ReverseInformeEstadisticoDeudaProveedoresController {
    

// @LINE:61
def diferencias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoDeudaProveedoresController.diferencias",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "diferencias"})
      }
   """
)
                        

// @LINE:65
def getActas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoDeudaProveedoresController.getActas",
   """
      function(id_orden_provision) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe-estadistico-deuda-proveedores/get-actas" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id_orden_provision", id_orden_provision)])})
      }
   """
)
                        

// @LINE:64
def archivoEstadistico : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoDeudaProveedoresController.archivoEstadistico",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe-estadistico-deuda-proveedores/descarga"})
      }
   """
)
                        

// @LINE:62
def procesarDiferencias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoDeudaProveedoresController.procesarDiferencias",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "procesar-diferencias"})
      }
   """
)
                        

// @LINE:58
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoDeudaProveedoresController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe-estadistico-deuda-proveedores"})
      }
   """
)
                        
    
}
              

// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
class ReverseAutorizadosController {
    

// @LINE:88
def getListadoDeudasActas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.getListadoDeudasActas",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/getListadoDeudasActas"})
      }
   """
)
                        

// @LINE:83
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.cambiarEstado",
   """
      function(idAutorizado,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idAutorizado", idAutorizado), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:96
def getResumen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.getResumen",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/getResumen" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:77
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/crear"})
      }
   """
)
                        

// @LINE:82
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:94
def modalAgregarMontosCertificacionesCompras : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.modalAgregarMontosCertificacionesCompras",
   """
      function(idCertificacion,idAutorizado,idOrdenCompra,tipo_cuenta_id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/modalAgregarMontosCertificacionesCompras" + _qS([(idCertificacion == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idCertificacion", idCertificacion)), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idAutorizado", idAutorizado), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenCompra", idOrdenCompra), (tipo_cuenta_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("tipo_cuenta_id", tipo_cuenta_id))])})
      }
   """
)
                        

// @LINE:89
def getActualizarDatos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.getActualizarDatos",
   """
      function(idAutorizado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/getActualizarDatos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idAutorizado", idAutorizado)])})
      }
   """
)
                        

// @LINE:87
def getListadoDeudas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.getListadoDeudas",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/getListadoDeudas"})
      }
   """
)
                        

// @LINE:90
def controlCargaCotizacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.controlCargaCotizacion",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/controlCargaCotizacion"})
      }
   """
)
                        

// @LINE:99
def reporteAutorizadoRemitos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.reporteAutorizadoRemitos",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/reporteAutorizadoRemitos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:85
def cargarLineasAutorizadosCertificacionesCompras : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.cargarLineasAutorizadosCertificacionesCompras",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/cargarLineasAutorizadosCertificacionesCompras"})
      }
   """
)
                        

// @LINE:92
def modalAgregarMontosActas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.modalAgregarMontosActas",
   """
      function(idActa,idOrdenProvision,idAutorizado,idOrdenCompra,tipo_cuenta_id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/modalAgregarMontosActas" + _qS([(idActa == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idActa", idActa)), (idOrdenProvision == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenProvision", idOrdenProvision)), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idAutorizado", idAutorizado), (idOrdenCompra == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenCompra", idOrdenCompra)), (tipo_cuenta_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("tipo_cuenta_id", tipo_cuenta_id))])})
      }
   """
)
                        

// @LINE:81
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:80
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:98
def reporteAutorizadoExcel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.reporteAutorizadoExcel",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/reporteAutorizadoExcel" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:101
def cargarLineasAutorizadosMasivamente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.cargarLineasAutorizadosMasivamente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/cargarLineasAutorizadosMasivamente"})
      }
   """
)
                        

// @LINE:78
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/guardar"})
      }
   """
)
                        

// @LINE:84
def cargarLineasAutorizados : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.cargarLineasAutorizados",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/cargarLineasAutorizados"})
      }
   """
)
                        

// @LINE:97
def reporteAutorizado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.reporteAutorizado",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/reporteAutorizado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:79
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:76
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado"})
      }
   """
)
                        

// @LINE:86
def modalAgregarMontos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.modalAgregarMontos",
   """
      function(idOrdenProvision,idAutorizado,idOrdenCompra,tipo_cuenta_id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/modalAgregarMontos" + _qS([(idOrdenProvision == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenProvision", idOrdenProvision)), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idAutorizado", idAutorizado), (idOrdenCompra == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenCompra", idOrdenCompra)), (tipo_cuenta_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("tipo_cuenta_id", tipo_cuenta_id))])})
      }
   """
)
                        

// @LINE:93
def modalAgregarMontosSinOp : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AutorizadosController.modalAgregarMontosSinOp",
   """
      function(idAutorizado,idOrdenCompra,tipo_cuenta_id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizado/modalAgregarMontosSinOp" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idAutorizado", idAutorizado), (idOrdenCompra == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenCompra", idOrdenCompra)), (tipo_cuenta_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("tipo_cuenta_id", tipo_cuenta_id))])})
      }
   """
)
                        
    
}
              

// @LINE:30
// @LINE:27
class ReverseHonorariosNewController {
    

// @LINE:30
def listadoHonorariosReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosNewController.listadoHonorariosReporte",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "listadoHonorariosReporte" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:27
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosNewController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "honorariosNew"})
      }
   """
)
                        
    
}
              

// @LINE:179
class ReverseAuditoriaController {
    

// @LINE:179
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.AuditoriaController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auditoria"})
      }
   """
)
                        
    
}
              

// @LINE:53
// @LINE:52
class ReverseImpuestosController {
    

// @LINE:53
def detalleImpuestos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.ImpuestosController.detalleImpuestos",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "detalleImpuestos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:52
def estadoDeuda : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.ImpuestosController.estadoDeuda",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "impuestosDeuda"})
      }
   """
)
                        
    
}
              

// @LINE:50
// @LINE:46
// @LINE:45
// @LINE:42
class ReverseLiquidacionesReportesController {
    

// @LINE:46
def liquidacionesPorEscala : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesReportesController.liquidacionesPorEscala",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesPorEscalaReporte"})
      }
   """
)
                        

// @LINE:42
def liquidacionesPorProfesion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesReportesController.liquidacionesPorProfesion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesPorProfesionReporte"})
      }
   """
)
                        

// @LINE:50
def liquidacionesPorAgrupadoOrganigrama : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesReportesController.liquidacionesPorAgrupadoOrganigrama",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesPorAgrupadoOrganigramaReporte"})
      }
   """
)
                        

// @LINE:45
def liquidacionesPorOrganigrama : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.LiquidacionesReportesController.liquidacionesPorOrganigrama",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "liquidacionesPorOrganigramaReporte"})
      }
   """
)
                        
    
}
              

// @LINE:2
class ReverseIndexController {
    

// @LINE:2
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:163
// @LINE:162
// @LINE:161
// @LINE:155
// @LINE:153
// @LINE:152
// @LINE:151
class ReverseDeudasPorAntiguedadReportesController {
    

// @LINE:152
def deudasInformeGeneral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadReportesController.deudasInformeGeneral",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasInformeGeneralPorAntiguedad"})
      }
   """
)
                        

// @LINE:162
def deudasResumenPorInstitucionReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadReportesController.deudasResumenPorInstitucionReporte",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasResumenPorInstitucionReporte"})
      }
   """
)
                        

// @LINE:153
def deudasInformeGeneralNuevo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadReportesController.deudasInformeGeneralNuevo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasInformeGeneralPorAntiguedadNuevo"})
      }
   """
)
                        

// @LINE:161
def deudasDetallePorInstitucionReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallePorInstitucionReporte",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallePorInstitucionReporte"})
      }
   """
)
                        

// @LINE:163
def deudasDetallesServiciosReportes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallesServiciosReportes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesAntiguedadServiciosReportes"})
      }
   """
)
                        

// @LINE:151
def deudasDetallesReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallesReporte",
   """
      function(idProveedor,equipamiento,idCuenta,sinServicio) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesPorAntiguedadReporte" + _qS([(idProveedor == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idProveedor", idProveedor)), (equipamiento == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("equipamiento", equipamiento)), (idCuenta == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idCuenta", idCuenta)), (sinServicio == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("sinServicio", sinServicio))])})
      }
   """
)
                        

// @LINE:155
def deudasMensualReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasPorAntiguedadReportesController.deudasMensualReporte",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasMensualReporte"})
      }
   """
)
                        
    
}
              

// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:68
// @LINE:67
class ReverseInformeEstadisticoPagoProveedoresController {
    

// @LINE:71
def informePeriodoProveedorReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoPagoProveedoresController.informePeriodoProveedorReporte",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe-pago-periodo-proveedores-reportes"})
      }
   """
)
                        

// @LINE:73
def informeProveedor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoPagoProveedoresController.informeProveedor",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informeProveedor"})
      }
   """
)
                        

// @LINE:68
def archivoEstadistico : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoPagoProveedoresController.archivoEstadistico",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe-estadistico-pago-proveedores/descarga"})
      }
   """
)
                        

// @LINE:67
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoPagoProveedoresController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe-estadistico-pago-proveedores"})
      }
   """
)
                        

// @LINE:70
def informePeriodoProveedor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeEstadisticoPagoProveedoresController.informePeriodoProveedor",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe-pago-periodo-proveedores"})
      }
   """
)
                        
    
}
              

// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
class ReverseControlDeudaController {
    

// @LINE:168
def autorizadoDistintoDePagado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.ControlDeudaController.autorizadoDistintoDePagado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autorizadoDistintoDePagado"})
      }
   """
)
                        

// @LINE:171
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.ControlDeudaController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "indexControlDeuda"})
      }
   """
)
                        

// @LINE:170
def controlDeudaMonedaExtranjera : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.ControlDeudaController.controlDeudaMonedaExtranjera",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "controlDeudaMonedaExtranjera"})
      }
   """
)
                        

// @LINE:169
def getAutorizadoDistintoDePagado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.ControlDeudaController.getAutorizadoDistintoDePagado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAutorizadoDistintoDePagado"})
      }
   """
)
                        
    
}
              

// @LINE:31
class ReverseHonorariosNewReportesController {
    

// @LINE:31
def informeHonorarioPorPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosNewReportesController.informeHonorarioPorPeriodo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informeHonorarioPorPeriodo"})
      }
   """
)
                        
    
}
              

// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:121
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
class ReverseDeudasGlobalizadasController {
    

// @LINE:118
def deudasDetallesCuentas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasDetallesCuentas",
   """
      function(idCuenta) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesCuentas" + _qS([(idCuenta == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idCuenta", idCuenta))])})
      }
   """
)
                        

// @LINE:126
def deudasDetallesHonorarios : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasDetallesHonorarios",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesHonorarios"})
      }
   """
)
                        

// @LINE:121
def deudasDetallesOtrosProveedoresResumen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasDetallesOtrosProveedoresResumen",
   """
      function(profe,equipamientos) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesOtrosProveedoresResumen" + _qS([(profe == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("profe", profe)), (equipamientos == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("equipamientos", equipamientos))])})
      }
   """
)
                        

// @LINE:116
def deudasDetalles : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasDetalles",
   """
      function(idProveedor,ra) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasPorProveedorHEARM" + _qS([(idProveedor == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("idProveedor", idProveedor)), (ra == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("ra", ra))])})
      }
   """
)
                        

// @LINE:124
def deudasDetallesServicios : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasDetallesServicios",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesServicios"})
      }
   """
)
                        

// @LINE:117
def deudasDetallesOtros : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasDetallesOtros",
   """
      function(profe,equipamientos) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesOtros" + _qS([(profe == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("profe", profe)), (equipamientos == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("equipamientos", equipamientos))])})
      }
   """
)
                        

// @LINE:119
def deudasDetallesPorProveedor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasDetallesPorProveedor",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesPorProveedor"})
      }
   """
)
                        

// @LINE:115
def deudasResumidas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasResumidas",
   """
      function(deposito,ra) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasResumidas" + _qS([(deposito == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("deposito", deposito)), (ra == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("ra", ra))])})
      }
   """
)
                        

// @LINE:125
def deudasDetallesServiciosResumen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasDetallesServiciosResumen",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesServiciosResumen"})
      }
   """
)
                        

// @LINE:114
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudas"})
      }
   """
)
                        

// @LINE:127
def deudasDetallesHonorariosResumen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.DeudasGlobalizadasController.deudasDetallesHonorariosResumen",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasDetallesHonorariosResumen"})
      }
   """
)
                        
    
}
              

// @LINE:112
class ReverseInformesRecuperoReportesController {
    

// @LINE:112
def deudasPorTipoDeCliente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformesRecuperoReportesController.deudasPorTipoDeCliente",
   """
      function(idTipoCliente) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deudasRecuperoPorTipoDeClienteReporte" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idTipoCliente", idTipoCliente)])})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
class ReverseHonorariosController {
    

// @LINE:4
def estadoDeuda : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.estadoDeuda",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoDeudaHonorarios"})
      }
   """
)
                        

// @LINE:5
def getEstadoDeudaPorEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getEstadoDeudaPorEjercicio",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getEstadoDeudaPorEjercicio"})
      }
   """
)
                        

// @LINE:13
def getDatosEstadoGeneralPorAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getDatosEstadoGeneralPorAgente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoGeneralAgente/getDatosEstadoGeneralPorAgente"})
      }
   """
)
                        

// @LINE:15
def getFacturacionEstadoGeneralPorAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getFacturacionEstadoGeneralPorAgente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoGeneralAgente/getFacturacionEstadoGeneralPorAgente"})
      }
   """
)
                        

// @LINE:12
def estadoGeneralPorAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.estadoGeneralPorAgente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoGeneralAgente"})
      }
   """
)
                        

// @LINE:22
def estadoDeudaMonotributoExcel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.estadoDeudaMonotributoExcel",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoDeudaMonotributoExcel"})
      }
   """
)
                        

// @LINE:20
def getHonorarioDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getHonorarioDepartamento",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getHonorarioDepartamento"})
      }
   """
)
                        

// @LINE:9
def getDataEstadoDeudaPagadosPorPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getDataEstadoDeudaPagadosPorPeriodo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getDataEstadoDeudaPagadosPorPeriodo"})
      }
   """
)
                        

// @LINE:24
def estadoDeudaMonotributoExcelProfe : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.estadoDeudaMonotributoExcelProfe",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoDeudaMonotributoExcelProfe"})
      }
   """
)
                        

// @LINE:10
def getDataEstadoDeudaNoPagadosPorPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getDataEstadoDeudaNoPagadosPorPeriodo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getDataEstadoDeudaNoPagadosPorPeriodo"})
      }
   """
)
                        

// @LINE:17
def getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoGeneralAgente/getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo"})
      }
   """
)
                        

// @LINE:6
def getEstadoDeudaPorPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getEstadoDeudaPorPeriodo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getEstadoDeudaPorPeriodo"})
      }
   """
)
                        

// @LINE:7
def getDataEstadoDeudaPagadosPorEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getDataEstadoDeudaPagadosPorEjercicio",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getDataEstadoDeudaPagadosPorEjercicio"})
      }
   """
)
                        

// @LINE:8
def getDataEstadoDeudaNoPagadosPorEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getDataEstadoDeudaNoPagadosPorEjercicio",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getDataEstadoDeudaNoPagadosPorEjercicio"})
      }
   """
)
                        

// @LINE:16
def getPagosEstadoGeneralPorAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getPagosEstadoGeneralPorAgente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoGeneralAgente/getPagosEstadoGeneralPorAgente"})
      }
   """
)
                        

// @LINE:14
def getCertificacionesEstadoGeneralPorAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getCertificacionesEstadoGeneralPorAgente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoGeneralAgente/getCertificacionesEstadoGeneralPorAgente"})
      }
   """
)
                        

// @LINE:21
def estadoDeudaMonotributo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.estadoDeudaMonotributo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoDeudaMonotributo"})
      }
   """
)
                        

// @LINE:18
def porDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.porDepartamento",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/porDepartamentos"})
      }
   """
)
                        

// @LINE:23
def estadoDeudaMonotributoProfe : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.estadoDeudaMonotributoProfe",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "estadoDeudaMonotributoProfe"})
      }
   """
)
                        

// @LINE:19
def getAgentesTotalDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.getAgentesTotalDepartamento",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/agentesDepartamentos"})
      }
   """
)
                        

// @LINE:3
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.HonorariosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios"})
      }
   """
)
                        
    
}
              

// @LINE:60
// @LINE:59
class ReverseInformeDeudaPorActasController {
    

// @LINE:60
def archivoDeudaPorActas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeDeudaPorActasController.archivoDeudaPorActas",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "archivo-deuda-actas"})
      }
   """
)
                        

// @LINE:59
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.dashboard.InformeDeudaPorActasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe-deuda-actas"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:183
// @LINE:182
// @LINE:180
// @LINE:179
// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:165
// @LINE:163
// @LINE:162
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:141
// @LINE:139
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:121
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:112
// @LINE:110
// @LINE:109
// @LINE:106
// @LINE:104
// @LINE:103
// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:68
// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:33
// @LINE:31
// @LINE:30
// @LINE:28
// @LINE:27
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
package controllers.dashboard.ref {


// @LINE:110
// @LINE:109
class ReverseInformesRecuperoController {
    

// @LINE:110
def deudasPorTipoDeCliente(idTipoCliente:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformesRecuperoController.deudasPorTipoDeCliente(idTipoCliente), HandlerDef(this, "controllers.dashboard.InformesRecuperoController", "deudasPorTipoDeCliente", Seq(classOf[Long]), "GET", """""", _prefix + """deudasRecuperoPorTipoDeCliente""")
)
                      

// @LINE:109
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformesRecuperoController.index(), HandlerDef(this, "controllers.dashboard.InformesRecuperoController", "index", Seq(), "GET", """""", _prefix + """indexInformeRecupero""")
)
                      
    
}
                          

// @LINE:106
// @LINE:104
// @LINE:103
class ReverseAutorizadoLineasController {
    

// @LINE:103
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadoLineasController.index(id, editable), HandlerDef(this, "controllers.dashboard.AutorizadoLineasController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """autorizado-linea/index""")
)
                      

// @LINE:104
def eliminar(autorizado_id:Long, orden_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadoLineasController.eliminar(autorizado_id, orden_id), HandlerDef(this, "controllers.dashboard.AutorizadoLineasController", "eliminar", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """autorizado-linea/eliminar""")
)
                      

// @LINE:106
def getActas(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadoLineasController.getActas(id), HandlerDef(this, "controllers.dashboard.AutorizadoLineasController", "getActas", Seq(classOf[Long]), "GET", """""", _prefix + """autorizado-linea/get-actas""")
)
                      
    
}
                          

// @LINE:28
class ReverseProfesionalesMedicosController {
    

// @LINE:28
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.ProfesionalesMedicosController.index(), HandlerDef(this, "controllers.dashboard.ProfesionalesMedicosController", "index", Seq(), "GET", """""", _prefix + """profesionalesMedicos""")
)
                      
    
}
                          

// @LINE:180
class ReverseInventarioRismiController {
    

// @LINE:180
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InventarioRismiController.index(), HandlerDef(this, "controllers.dashboard.InventarioRismiController", "index", Seq(), "GET", """""", _prefix + """inventarioRismi""")
)
                      
    
}
                          

// @LINE:165
// @LINE:160
// @LINE:159
// @LINE:157
// @LINE:156
// @LINE:154
// @LINE:150
// @LINE:149
class ReverseDeudasPorAntiguedadController {
    

// @LINE:154
def deudasResumenMensual(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadController.deudasResumenMensual(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasResumenMensual", Seq(), "GET", """""", _prefix + """deudasResumenMensual""")
)
                      

// @LINE:165
def deudasDetallesCuenta(idCuenta:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesCuenta(idCuenta), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetallesCuenta", Seq(classOf[Int]), "GET", """""", _prefix + """deudasDetallesAntiguedadCuenta""")
)
                      

// @LINE:150
def deudasDetalles(idProveedor:Int, equipamiento:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadController.deudasDetalles(idProveedor, equipamiento), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetalles", Seq(classOf[Int], classOf[Boolean]), "GET", """""", _prefix + """deudasPorProveedorPorAntiguedad""")
)
                      

// @LINE:156
def deudasDetallesServicios(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesServicios(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetallesServicios", Seq(), "GET", """""", _prefix + """deudasDetallesServiciosPorAntiguedad""")
)
                      

// @LINE:160
def deudasResumenInstitucion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadController.deudasResumenInstitucion(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasResumenInstitucion", Seq(), "GET", """""", _prefix + """deudasResumenInstitucion""")
)
                      

// @LINE:159
def deudasDetallesInstitucion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesInstitucion(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetallesInstitucion", Seq(), "GET", """""", _prefix + """deudasDetallesInstitucion""")
)
                      

// @LINE:157
def deudasDetallesPorProveedor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadController.deudasDetallesPorProveedor(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "deudasDetallesPorProveedor", Seq(), "GET", """""", _prefix + """deudasDetallesPorAntiguedaPorProveedor""")
)
                      

// @LINE:149
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadController.index(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadController", "index", Seq(), "GET", """""", _prefix + """deudasPorAntigueda""")
)
                      
    
}
                          

// @LINE:49
// @LINE:47
// @LINE:44
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:33
class ReverseLiquidacionesController {
    

// @LINE:37
def getLiquidacionesPorPuestoPorPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuestoPorPeriodo(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "getLiquidacionesPorPuestoPorPeriodo", Seq(), "GET", """""", _prefix + """getLiquidacionesPorPuestoPorPeriodo""")
)
                      

// @LINE:47
def liquidacionesTotalesPorEscala(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.liquidacionesTotalesPorEscala(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesTotalesPorEscala", Seq(), "GET", """""", _prefix + """liquidacionesTotalesPorEscala""")
)
                      

// @LINE:49
def liquidacionesPorAgrupadoOrganigrama(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.liquidacionesPorAgrupadoOrganigrama(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorAgrupadoOrganigrama", Seq(), "GET", """""", _prefix + """liquidacionesPorAgrupadoOrganigrama""")
)
                      

// @LINE:39
def liquidacionesPorEscala(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.liquidacionesPorEscala(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorEscala", Seq(), "GET", """""", _prefix + """liquidacionesPorEscala""")
)
                      

// @LINE:38
def getLiquidacionesPorPuestoPorPeriodoPorClasificacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuestoPorPeriodoPorClasificacion(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "getLiquidacionesPorPuestoPorPeriodoPorClasificacion", Seq(), "GET", """""", _prefix + """getLiquidacionesPorPuestoPorPeriodoPorClasificacion""")
)
                      

// @LINE:44
def liquidacionesPorOrganigrama(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.liquidacionesPorOrganigrama(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorOrganigrama", Seq(), "GET", """""", _prefix + """liquidacionesPorOrganigrama""")
)
                      

// @LINE:41
def liquidacionesPorProfesion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.liquidacionesPorProfesion(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorProfesion", Seq(), "GET", """""", _prefix + """liquidacionesPorProfesion""")
)
                      

// @LINE:33
def liquidacionesPorPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.liquidacionesPorPuesto(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "liquidacionesPorPuesto", Seq(), "GET", """""", _prefix + """liquidacionesPorPuesto""")
)
                      

// @LINE:36
def getLiquidacionesPorPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.getLiquidacionesPorPuesto(), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "getLiquidacionesPorPuesto", Seq(), "GET", """GET /getCertificacionesPorPuesto		controllers.dashboard.LiquidacionesController.getCertificacionesPorPuesto()""", _prefix + """getLiquidacionesPorPuesto""")
)
                      

// @LINE:40
def getDetalleLiquidacionClasificacion(idPuestoLaboral:Int, idPeriodo:Int, idClasificacion:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesController.getDetalleLiquidacionClasificacion(idPuestoLaboral, idPeriodo, idClasificacion), HandlerDef(this, "controllers.dashboard.LiquidacionesController", "getDetalleLiquidacionClasificacion", Seq(classOf[Int], classOf[Int], classOf[Int]), "POST", """""", _prefix + """getDetalleLiquidacionClasificacion""")
)
                      
    
}
                          

// @LINE:141
// @LINE:139
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
class ReverseDeudasGlobalizadasReportesController {
    

// @LINE:132
def deudasInformeGeneral(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasInformeGeneral(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasInformeGeneral", Seq(), "GET", """""", _prefix + """deudasInformeGeneral""")
)
                      

// @LINE:137
def deudasHonorariosProveedoresResumenReportes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasHonorariosProveedoresResumenReportes(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasHonorariosProveedoresResumenReportes", Seq(), "GET", """""", _prefix + """deudasHonorariosProveedoresResumenReportes""")
)
                      

// @LINE:139
def deudasCuentasReportes(idCuenta:Int, soloDeuda:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasCuentasReportes(idCuenta, soloDeuda), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasCuentasReportes", Seq(classOf[Int], classOf[Boolean]), "GET", """""", _prefix + """deudasCuentasReportes""")
)
                      

// @LINE:141
def deudasDetallesOtrosProveedoresResumen(profe:Boolean, equipamientos:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesOtrosProveedoresResumen(profe, equipamientos), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesOtrosProveedoresResumen", Seq(classOf[Boolean], classOf[Boolean]), "GET", """""", _prefix + """deudasOtrosProveedoresResumenReporte""")
)
                      

// @LINE:129
def deudasResumidasReporte(deposito:Int, ra:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasResumidasReporte(deposito, ra), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasResumidasReporte", Seq(classOf[Int], classOf[Boolean]), "GET", """""", _prefix + """deudasResumidasReporte""")
)
                      

// @LINE:136
def deudasServiciosProveedoresResumenReportes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasServiciosProveedoresResumenReportes(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasServiciosProveedoresResumenReportes", Seq(), "GET", """""", _prefix + """deudasServiciosProveedoresResumenReportes""")
)
                      

// @LINE:135
def deudasDetallesHonorariosReportes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesHonorariosReportes(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesHonorariosReportes", Seq(), "GET", """""", _prefix + """deudasDetallesHonorariosReportes""")
)
                      

// @LINE:130
def deudasDetallesReporte(idProveedor:Int, ra:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesReporte(idProveedor, ra), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesReporte", Seq(classOf[Int], classOf[Boolean]), "GET", """""", _prefix + """deudasDetallesReporte""")
)
                      

// @LINE:134
def deudasDetallesServiciosReportes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesServiciosReportes(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesServiciosReportes", Seq(), "GET", """""", _prefix + """deudasDetallesServiciosReportes""")
)
                      

// @LINE:133
def deudasInformeGeneralResumen(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasInformeGeneralResumen(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasInformeGeneralResumen", Seq(), "GET", """""", _prefix + """deudasInformeGeneralResumen""")
)
                      

// @LINE:131
def deudasDetallesOtrosReportes(profe:Boolean, equipamientos:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasReportesController.deudasDetallesOtrosReportes(profe, equipamientos), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasReportesController", "deudasDetallesOtrosReportes", Seq(classOf[Boolean], classOf[Boolean]), "GET", """""", _prefix + """deudasDetallesOtrosReportes""")
)
                      
    
}
                          

// @LINE:56
// @LINE:55
class ReverseProveedoresController {
    

// @LINE:55
def estadoPorExpedientePorLinea(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.ProveedoresController.estadoPorExpedientePorLinea(), HandlerDef(this, "controllers.dashboard.ProveedoresController", "estadoPorExpedientePorLinea", Seq(), "GET", """""", _prefix + """estadoPorExpedientePorLinea""")
)
                      

// @LINE:56
def reporteEstadoDefinitivoExpedienteLineas(proveedorId:Long, rubroId:Long, ejercicioId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.ProveedoresController.reporteEstadoDefinitivoExpedienteLineas(proveedorId, rubroId, ejercicioId), HandlerDef(this, "controllers.dashboard.ProveedoresController", "reporteEstadoDefinitivoExpedienteLineas", Seq(classOf[Long], classOf[Long], classOf[Long]), "GET", """""", _prefix + """reporteEstadoDefinitivoExpedienteLineas""")
)
                      
    
}
                          

// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
class ReverseUltimasCotizacionesController {
    

// @LINE:146
def guardarUltimaCotizaciones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.UltimasCotizacionesController.guardarUltimaCotizaciones(), HandlerDef(this, "controllers.dashboard.UltimasCotizacionesController", "guardarUltimaCotizaciones", Seq(), "POST", """""", _prefix + """cotizacion/guardar""")
)
                      

// @LINE:147
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.UltimasCotizacionesController.eliminar(id), HandlerDef(this, "controllers.dashboard.UltimasCotizacionesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """cotizacion/eliminar""")
)
                      

// @LINE:144
def indexUltimaCotizaciones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.UltimasCotizacionesController.indexUltimaCotizaciones(), HandlerDef(this, "controllers.dashboard.UltimasCotizacionesController", "indexUltimaCotizaciones", Seq(), "GET", """""", _prefix + """cotizacion""")
)
                      

// @LINE:145
def crearUltimaCotizaciones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.UltimasCotizacionesController.crearUltimaCotizaciones(), HandlerDef(this, "controllers.dashboard.UltimasCotizacionesController", "crearUltimaCotizaciones", Seq(), "GET", """""", _prefix + """cotizacion/crear""")
)
                      
    
}
                          

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
class ReverseMovimientosCuentasController {
    

// @LINE:177
def conciliacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.MovimientosCuentasController.conciliacion(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "conciliacion", Seq(), "GET", """""", _prefix + """conciliacion""")
)
                      

// @LINE:174
def resumenFinancieroGeneral(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.MovimientosCuentasController.resumenFinancieroGeneral(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "resumenFinancieroGeneral", Seq(), "GET", """""", _prefix + """resumenFinancieroGeneral""")
)
                      

// @LINE:175
def resumenFinancieroDetalle(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.MovimientosCuentasController.resumenFinancieroDetalle(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "resumenFinancieroDetalle", Seq(), "GET", """""", _prefix + """resumenFinancieroDetalle""")
)
                      

// @LINE:176
def resumenFinancieroDetallePorInstitucion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.MovimientosCuentasController.resumenFinancieroDetallePorInstitucion(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "resumenFinancieroDetallePorInstitucion", Seq(), "GET", """""", _prefix + """resumenFinancieroDetalleInstitucion""")
)
                      

// @LINE:173
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.MovimientosCuentasController.index(), HandlerDef(this, "controllers.dashboard.MovimientosCuentasController", "index", Seq(), "GET", """""", _prefix + """resumenFinanciero""")
)
                      
    
}
                          

// @LINE:183
// @LINE:182
class ReversePresupuestoController {
    

// @LINE:182
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.PresupuestoController.index(), HandlerDef(this, "controllers.dashboard.PresupuestoController", "index", Seq(), "GET", """""", _prefix + """presuControl""")
)
                      

// @LINE:183
def devengado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.PresupuestoController.devengado(), HandlerDef(this, "controllers.dashboard.PresupuestoController", "devengado", Seq(), "GET", """""", _prefix + """presuControl/devengado""")
)
                      
    
}
                          

// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:58
class ReverseInformeEstadisticoDeudaProveedoresController {
    

// @LINE:61
def diferencias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoDeudaProveedoresController.diferencias(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "diferencias", Seq(), "GET", """""", _prefix + """diferencias""")
)
                      

// @LINE:65
def getActas(id_orden_provision:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoDeudaProveedoresController.getActas(id_orden_provision), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "getActas", Seq(classOf[Long]), "GET", """""", _prefix + """informe-estadistico-deuda-proveedores/get-actas""")
)
                      

// @LINE:64
def archivoEstadistico(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoDeudaProveedoresController.archivoEstadistico(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "archivoEstadistico", Seq(), "GET", """""", _prefix + """informe-estadistico-deuda-proveedores/descarga""")
)
                      

// @LINE:62
def procesarDiferencias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoDeudaProveedoresController.procesarDiferencias(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "procesarDiferencias", Seq(), "POST", """""", _prefix + """procesar-diferencias""")
)
                      

// @LINE:58
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoDeudaProveedoresController.index(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoDeudaProveedoresController", "index", Seq(), "GET", """""", _prefix + """informe-estadistico-deuda-proveedores""")
)
                      
    
}
                          

// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
class ReverseAutorizadosController {
    

// @LINE:88
def getListadoDeudasActas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.getListadoDeudasActas(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "getListadoDeudasActas", Seq(), "GET", """""", _prefix + """autorizado/getListadoDeudasActas""")
)
                      

// @LINE:83
def cambiarEstado(idAutorizado:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.cambiarEstado(idAutorizado, idEstado), HandlerDef(this, "controllers.dashboard.AutorizadosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """autorizado/cambiarEstado""")
)
                      

// @LINE:96
def getResumen(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.getResumen(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "getResumen", Seq(classOf[Long]), "GET", """""", _prefix + """autorizado/getResumen""")
)
                      

// @LINE:77
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.crear(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "crear", Seq(), "GET", """""", _prefix + """autorizado/crear""")
)
                      

// @LINE:82
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.actualizar(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """autorizado/actualizar""")
)
                      

// @LINE:94
def modalAgregarMontosCertificacionesCompras(idCertificacion:Long, idAutorizado:Long, idOrdenCompra:Long, tipo_cuenta_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.modalAgregarMontosCertificacionesCompras(idCertificacion, idAutorizado, idOrdenCompra, tipo_cuenta_id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "modalAgregarMontosCertificacionesCompras", Seq(classOf[Long], classOf[Long], classOf[Long], classOf[Long]), "POST", """""", _prefix + """autorizado/modalAgregarMontosCertificacionesCompras""")
)
                      

// @LINE:89
def getActualizarDatos(idAutorizado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.getActualizarDatos(idAutorizado), HandlerDef(this, "controllers.dashboard.AutorizadosController", "getActualizarDatos", Seq(classOf[Long]), "GET", """""", _prefix + """autorizado/getActualizarDatos""")
)
                      

// @LINE:87
def getListadoDeudas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.getListadoDeudas(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "getListadoDeudas", Seq(), "GET", """""", _prefix + """autorizado/getListadoDeudas""")
)
                      

// @LINE:90
def controlCargaCotizacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.controlCargaCotizacion(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "controlCargaCotizacion", Seq(), "POST", """""", _prefix + """autorizado/controlCargaCotizacion""")
)
                      

// @LINE:99
def reporteAutorizadoRemitos(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.reporteAutorizadoRemitos(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "reporteAutorizadoRemitos", Seq(classOf[Long]), "GET", """""", _prefix + """autorizado/reporteAutorizadoRemitos""")
)
                      

// @LINE:85
def cargarLineasAutorizadosCertificacionesCompras(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.cargarLineasAutorizadosCertificacionesCompras(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "cargarLineasAutorizadosCertificacionesCompras", Seq(), "POST", """""", _prefix + """autorizado/cargarLineasAutorizadosCertificacionesCompras""")
)
                      

// @LINE:92
def modalAgregarMontosActas(idActa:Long, idOrdenProvision:Long, idAutorizado:Long, idOrdenCompra:Long, tipo_cuenta_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.modalAgregarMontosActas(idActa, idOrdenProvision, idAutorizado, idOrdenCompra, tipo_cuenta_id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "modalAgregarMontosActas", Seq(classOf[Long], classOf[Long], classOf[Long], classOf[Long], classOf[Long]), "POST", """""", _prefix + """autorizado/modalAgregarMontosActas""")
)
                      

// @LINE:81
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.ver(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """autorizado/ver""")
)
                      

// @LINE:80
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.eliminar(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """autorizado/eliminar""")
)
                      

// @LINE:98
def reporteAutorizadoExcel(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.reporteAutorizadoExcel(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "reporteAutorizadoExcel", Seq(classOf[Long]), "GET", """""", _prefix + """autorizado/reporteAutorizadoExcel""")
)
                      

// @LINE:101
def cargarLineasAutorizadosMasivamente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.cargarLineasAutorizadosMasivamente(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "cargarLineasAutorizadosMasivamente", Seq(), "POST", """""", _prefix + """autorizado/cargarLineasAutorizadosMasivamente""")
)
                      

// @LINE:78
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.guardar(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "guardar", Seq(), "POST", """""", _prefix + """autorizado/guardar""")
)
                      

// @LINE:84
def cargarLineasAutorizados(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.cargarLineasAutorizados(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "cargarLineasAutorizados", Seq(), "POST", """""", _prefix + """autorizado/cargarLineasAutorizados""")
)
                      

// @LINE:97
def reporteAutorizado(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.reporteAutorizado(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "reporteAutorizado", Seq(classOf[Long]), "GET", """""", _prefix + """autorizado/reporteAutorizado""")
)
                      

// @LINE:79
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.editar(id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """autorizado/editar""")
)
                      

// @LINE:76
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.index(), HandlerDef(this, "controllers.dashboard.AutorizadosController", "index", Seq(), "GET", """""", _prefix + """autorizado""")
)
                      

// @LINE:86
def modalAgregarMontos(idOrdenProvision:Long, idAutorizado:Long, idOrdenCompra:Long, tipo_cuenta_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.modalAgregarMontos(idOrdenProvision, idAutorizado, idOrdenCompra, tipo_cuenta_id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "modalAgregarMontos", Seq(classOf[Long], classOf[Long], classOf[Long], classOf[Long]), "POST", """""", _prefix + """autorizado/modalAgregarMontos""")
)
                      

// @LINE:93
def modalAgregarMontosSinOp(idAutorizado:Long, idOrdenCompra:Long, tipo_cuenta_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AutorizadosController.modalAgregarMontosSinOp(idAutorizado, idOrdenCompra, tipo_cuenta_id), HandlerDef(this, "controllers.dashboard.AutorizadosController", "modalAgregarMontosSinOp", Seq(classOf[Long], classOf[Long], classOf[Long]), "POST", """""", _prefix + """autorizado/modalAgregarMontosSinOp""")
)
                      
    
}
                          

// @LINE:30
// @LINE:27
class ReverseHonorariosNewController {
    

// @LINE:30
def listadoHonorariosReporte(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosNewController.listadoHonorariosReporte(id), HandlerDef(this, "controllers.dashboard.HonorariosNewController", "listadoHonorariosReporte", Seq(classOf[Int]), "GET", """""", _prefix + """listadoHonorariosReporte""")
)
                      

// @LINE:27
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosNewController.index(), HandlerDef(this, "controllers.dashboard.HonorariosNewController", "index", Seq(), "GET", """""", _prefix + """honorariosNew""")
)
                      
    
}
                          

// @LINE:179
class ReverseAuditoriaController {
    

// @LINE:179
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.AuditoriaController.index(), HandlerDef(this, "controllers.dashboard.AuditoriaController", "index", Seq(), "GET", """""", _prefix + """auditoria""")
)
                      
    
}
                          

// @LINE:53
// @LINE:52
class ReverseImpuestosController {
    

// @LINE:53
def detalleImpuestos(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.ImpuestosController.detalleImpuestos(id), HandlerDef(this, "controllers.dashboard.ImpuestosController", "detalleImpuestos", Seq(classOf[Long]), "GET", """""", _prefix + """detalleImpuestos""")
)
                      

// @LINE:52
def estadoDeuda(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.ImpuestosController.estadoDeuda(), HandlerDef(this, "controllers.dashboard.ImpuestosController", "estadoDeuda", Seq(), "GET", """""", _prefix + """impuestosDeuda""")
)
                      
    
}
                          

// @LINE:50
// @LINE:46
// @LINE:45
// @LINE:42
class ReverseLiquidacionesReportesController {
    

// @LINE:46
def liquidacionesPorEscala(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesReportesController.liquidacionesPorEscala(), HandlerDef(this, "controllers.dashboard.LiquidacionesReportesController", "liquidacionesPorEscala", Seq(), "GET", """""", _prefix + """liquidacionesPorEscalaReporte""")
)
                      

// @LINE:42
def liquidacionesPorProfesion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesReportesController.liquidacionesPorProfesion(), HandlerDef(this, "controllers.dashboard.LiquidacionesReportesController", "liquidacionesPorProfesion", Seq(), "GET", """""", _prefix + """liquidacionesPorProfesionReporte""")
)
                      

// @LINE:50
def liquidacionesPorAgrupadoOrganigrama(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesReportesController.liquidacionesPorAgrupadoOrganigrama(), HandlerDef(this, "controllers.dashboard.LiquidacionesReportesController", "liquidacionesPorAgrupadoOrganigrama", Seq(), "GET", """""", _prefix + """liquidacionesPorAgrupadoOrganigramaReporte""")
)
                      

// @LINE:45
def liquidacionesPorOrganigrama(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.LiquidacionesReportesController.liquidacionesPorOrganigrama(), HandlerDef(this, "controllers.dashboard.LiquidacionesReportesController", "liquidacionesPorOrganigrama", Seq(), "GET", """""", _prefix + """liquidacionesPorOrganigramaReporte""")
)
                      
    
}
                          

// @LINE:2
class ReverseIndexController {
    

// @LINE:2
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.IndexController.index(), HandlerDef(this, "controllers.dashboard.IndexController", "index", Seq(), "GET", """-----------------------------MODULO DASHBOARD ---------------------------------""", _prefix + """""")
)
                      
    
}
                          

// @LINE:163
// @LINE:162
// @LINE:161
// @LINE:155
// @LINE:153
// @LINE:152
// @LINE:151
class ReverseDeudasPorAntiguedadReportesController {
    

// @LINE:152
def deudasInformeGeneral(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadReportesController.deudasInformeGeneral(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasInformeGeneral", Seq(), "GET", """""", _prefix + """deudasInformeGeneralPorAntiguedad""")
)
                      

// @LINE:162
def deudasResumenPorInstitucionReporte(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadReportesController.deudasResumenPorInstitucionReporte(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasResumenPorInstitucionReporte", Seq(), "GET", """""", _prefix + """deudasResumenPorInstitucionReporte""")
)
                      

// @LINE:153
def deudasInformeGeneralNuevo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadReportesController.deudasInformeGeneralNuevo(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasInformeGeneralNuevo", Seq(), "GET", """""", _prefix + """deudasInformeGeneralPorAntiguedadNuevo""")
)
                      

// @LINE:161
def deudasDetallePorInstitucionReporte(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallePorInstitucionReporte(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasDetallePorInstitucionReporte", Seq(), "GET", """""", _prefix + """deudasDetallePorInstitucionReporte""")
)
                      

// @LINE:163
def deudasDetallesServiciosReportes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallesServiciosReportes(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasDetallesServiciosReportes", Seq(), "GET", """""", _prefix + """deudasDetallesAntiguedadServiciosReportes""")
)
                      

// @LINE:151
def deudasDetallesReporte(idProveedor:Int, equipamiento:Boolean, idCuenta:Int, sinServicio:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadReportesController.deudasDetallesReporte(idProveedor, equipamiento, idCuenta, sinServicio), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasDetallesReporte", Seq(classOf[Int], classOf[Boolean], classOf[Int], classOf[Boolean]), "GET", """""", _prefix + """deudasDetallesPorAntiguedadReporte""")
)
                      

// @LINE:155
def deudasMensualReporte(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasPorAntiguedadReportesController.deudasMensualReporte(), HandlerDef(this, "controllers.dashboard.DeudasPorAntiguedadReportesController", "deudasMensualReporte", Seq(), "GET", """""", _prefix + """deudasMensualReporte""")
)
                      
    
}
                          

// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:68
// @LINE:67
class ReverseInformeEstadisticoPagoProveedoresController {
    

// @LINE:71
def informePeriodoProveedorReporte(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoPagoProveedoresController.informePeriodoProveedorReporte(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "informePeriodoProveedorReporte", Seq(), "GET", """""", _prefix + """informe-pago-periodo-proveedores-reportes""")
)
                      

// @LINE:73
def informeProveedor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoPagoProveedoresController.informeProveedor(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "informeProveedor", Seq(), "GET", """""", _prefix + """informeProveedor""")
)
                      

// @LINE:68
def archivoEstadistico(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoPagoProveedoresController.archivoEstadistico(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "archivoEstadistico", Seq(), "GET", """""", _prefix + """informe-estadistico-pago-proveedores/descarga""")
)
                      

// @LINE:67
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoPagoProveedoresController.index(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "index", Seq(), "GET", """""", _prefix + """informe-estadistico-pago-proveedores""")
)
                      

// @LINE:70
def informePeriodoProveedor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeEstadisticoPagoProveedoresController.informePeriodoProveedor(), HandlerDef(this, "controllers.dashboard.InformeEstadisticoPagoProveedoresController", "informePeriodoProveedor", Seq(), "GET", """""", _prefix + """informe-pago-periodo-proveedores""")
)
                      
    
}
                          

// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
class ReverseControlDeudaController {
    

// @LINE:168
def autorizadoDistintoDePagado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.ControlDeudaController.autorizadoDistintoDePagado(), HandlerDef(this, "controllers.dashboard.ControlDeudaController", "autorizadoDistintoDePagado", Seq(), "GET", """""", _prefix + """autorizadoDistintoDePagado""")
)
                      

// @LINE:171
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.ControlDeudaController.index(), HandlerDef(this, "controllers.dashboard.ControlDeudaController", "index", Seq(), "GET", """""", _prefix + """indexControlDeuda""")
)
                      

// @LINE:170
def controlDeudaMonedaExtranjera(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.ControlDeudaController.controlDeudaMonedaExtranjera(), HandlerDef(this, "controllers.dashboard.ControlDeudaController", "controlDeudaMonedaExtranjera", Seq(), "GET", """""", _prefix + """controlDeudaMonedaExtranjera""")
)
                      

// @LINE:169
def getAutorizadoDistintoDePagado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.ControlDeudaController.getAutorizadoDistintoDePagado(), HandlerDef(this, "controllers.dashboard.ControlDeudaController", "getAutorizadoDistintoDePagado", Seq(), "GET", """""", _prefix + """getAutorizadoDistintoDePagado""")
)
                      
    
}
                          

// @LINE:31
class ReverseHonorariosNewReportesController {
    

// @LINE:31
def informeHonorarioPorPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosNewReportesController.informeHonorarioPorPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosNewReportesController", "informeHonorarioPorPeriodo", Seq(), "GET", """""", _prefix + """informeHonorarioPorPeriodo""")
)
                      
    
}
                          

// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:121
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
class ReverseDeudasGlobalizadasController {
    

// @LINE:118
def deudasDetallesCuentas(idCuenta:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasDetallesCuentas(idCuenta), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesCuentas", Seq(classOf[Int]), "GET", """""", _prefix + """deudasDetallesCuentas""")
)
                      

// @LINE:126
def deudasDetallesHonorarios(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasDetallesHonorarios(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesHonorarios", Seq(), "GET", """""", _prefix + """deudasDetallesHonorarios""")
)
                      

// @LINE:121
def deudasDetallesOtrosProveedoresResumen(profe:Boolean, equipamientos:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasDetallesOtrosProveedoresResumen(profe, equipamientos), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesOtrosProveedoresResumen", Seq(classOf[Boolean], classOf[Boolean]), "GET", """""", _prefix + """deudasDetallesOtrosProveedoresResumen""")
)
                      

// @LINE:116
def deudasDetalles(idProveedor:Int, ra:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasDetalles(idProveedor, ra), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetalles", Seq(classOf[Int], classOf[Boolean]), "GET", """""", _prefix + """deudasPorProveedorHEARM""")
)
                      

// @LINE:124
def deudasDetallesServicios(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasDetallesServicios(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesServicios", Seq(), "GET", """""", _prefix + """deudasDetallesServicios""")
)
                      

// @LINE:117
def deudasDetallesOtros(profe:Boolean, equipamientos:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasDetallesOtros(profe, equipamientos), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesOtros", Seq(classOf[Boolean], classOf[Boolean]), "GET", """""", _prefix + """deudasDetallesOtros""")
)
                      

// @LINE:119
def deudasDetallesPorProveedor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasDetallesPorProveedor(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesPorProveedor", Seq(), "GET", """""", _prefix + """deudasDetallesPorProveedor""")
)
                      

// @LINE:115
def deudasResumidas(deposito:Int, ra:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasResumidas(deposito, ra), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasResumidas", Seq(classOf[Int], classOf[Boolean]), "GET", """""", _prefix + """deudasResumidas""")
)
                      

// @LINE:125
def deudasDetallesServiciosResumen(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasDetallesServiciosResumen(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesServiciosResumen", Seq(), "GET", """""", _prefix + """deudasDetallesServiciosResumen""")
)
                      

// @LINE:114
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.index(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "index", Seq(), "GET", """""", _prefix + """deudas""")
)
                      

// @LINE:127
def deudasDetallesHonorariosResumen(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.DeudasGlobalizadasController.deudasDetallesHonorariosResumen(), HandlerDef(this, "controllers.dashboard.DeudasGlobalizadasController", "deudasDetallesHonorariosResumen", Seq(), "GET", """""", _prefix + """deudasDetallesHonorariosResumen""")
)
                      
    
}
                          

// @LINE:112
class ReverseInformesRecuperoReportesController {
    

// @LINE:112
def deudasPorTipoDeCliente(idTipoCliente:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformesRecuperoReportesController.deudasPorTipoDeCliente(idTipoCliente), HandlerDef(this, "controllers.dashboard.InformesRecuperoReportesController", "deudasPorTipoDeCliente", Seq(classOf[Long]), "GET", """""", _prefix + """deudasRecuperoPorTipoDeClienteReporte""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
class ReverseHonorariosController {
    

// @LINE:4
def estadoDeuda(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.estadoDeuda(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeuda", Seq(), "GET", """""", _prefix + """estadoDeudaHonorarios""")
)
                      

// @LINE:5
def getEstadoDeudaPorEjercicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getEstadoDeudaPorEjercicio(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getEstadoDeudaPorEjercicio", Seq(), "POST", """""", _prefix + """honorarios/getEstadoDeudaPorEjercicio""")
)
                      

// @LINE:13
def getDatosEstadoGeneralPorAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getDatosEstadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDatosEstadoGeneralPorAgente", Seq(), "POST", """""", _prefix + """estadoGeneralAgente/getDatosEstadoGeneralPorAgente""")
)
                      

// @LINE:15
def getFacturacionEstadoGeneralPorAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getFacturacionEstadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getFacturacionEstadoGeneralPorAgente", Seq(), "POST", """""", _prefix + """estadoGeneralAgente/getFacturacionEstadoGeneralPorAgente""")
)
                      

// @LINE:12
def estadoGeneralPorAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.estadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoGeneralPorAgente", Seq(), "GET", """""", _prefix + """estadoGeneralAgente""")
)
                      

// @LINE:22
def estadoDeudaMonotributoExcel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.estadoDeudaMonotributoExcel(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeudaMonotributoExcel", Seq(), "GET", """""", _prefix + """estadoDeudaMonotributoExcel""")
)
                      

// @LINE:20
def getHonorarioDepartamento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getHonorarioDepartamento(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getHonorarioDepartamento", Seq(), "GET", """""", _prefix + """honorarios/getHonorarioDepartamento""")
)
                      

// @LINE:9
def getDataEstadoDeudaPagadosPorPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getDataEstadoDeudaPagadosPorPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDataEstadoDeudaPagadosPorPeriodo", Seq(), "POST", """""", _prefix + """honorarios/getDataEstadoDeudaPagadosPorPeriodo""")
)
                      

// @LINE:24
def estadoDeudaMonotributoExcelProfe(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.estadoDeudaMonotributoExcelProfe(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeudaMonotributoExcelProfe", Seq(), "GET", """""", _prefix + """estadoDeudaMonotributoExcelProfe""")
)
                      

// @LINE:10
def getDataEstadoDeudaNoPagadosPorPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getDataEstadoDeudaNoPagadosPorPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDataEstadoDeudaNoPagadosPorPeriodo", Seq(), "POST", """""", _prefix + """honorarios/getDataEstadoDeudaNoPagadosPorPeriodo""")
)
                      

// @LINE:17
def getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo", Seq(), "POST", """""", _prefix + """estadoGeneralAgente/getEstadoDeudaEstadoGeneralPorAgenteEstadoPeriodo""")
)
                      

// @LINE:6
def getEstadoDeudaPorPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getEstadoDeudaPorPeriodo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getEstadoDeudaPorPeriodo", Seq(), "POST", """""", _prefix + """honorarios/getEstadoDeudaPorPeriodo""")
)
                      

// @LINE:7
def getDataEstadoDeudaPagadosPorEjercicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getDataEstadoDeudaPagadosPorEjercicio(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDataEstadoDeudaPagadosPorEjercicio", Seq(), "POST", """""", _prefix + """honorarios/getDataEstadoDeudaPagadosPorEjercicio""")
)
                      

// @LINE:8
def getDataEstadoDeudaNoPagadosPorEjercicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getDataEstadoDeudaNoPagadosPorEjercicio(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getDataEstadoDeudaNoPagadosPorEjercicio", Seq(), "POST", """""", _prefix + """honorarios/getDataEstadoDeudaNoPagadosPorEjercicio""")
)
                      

// @LINE:16
def getPagosEstadoGeneralPorAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getPagosEstadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getPagosEstadoGeneralPorAgente", Seq(), "POST", """""", _prefix + """estadoGeneralAgente/getPagosEstadoGeneralPorAgente""")
)
                      

// @LINE:14
def getCertificacionesEstadoGeneralPorAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getCertificacionesEstadoGeneralPorAgente(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getCertificacionesEstadoGeneralPorAgente", Seq(), "POST", """""", _prefix + """estadoGeneralAgente/getCertificacionesEstadoGeneralPorAgente""")
)
                      

// @LINE:21
def estadoDeudaMonotributo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.estadoDeudaMonotributo(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeudaMonotributo", Seq(), "GET", """""", _prefix + """estadoDeudaMonotributo""")
)
                      

// @LINE:18
def porDepartamento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.porDepartamento(), HandlerDef(this, "controllers.dashboard.HonorariosController", "porDepartamento", Seq(), "GET", """""", _prefix + """honorarios/porDepartamentos""")
)
                      

// @LINE:23
def estadoDeudaMonotributoProfe(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.estadoDeudaMonotributoProfe(), HandlerDef(this, "controllers.dashboard.HonorariosController", "estadoDeudaMonotributoProfe", Seq(), "GET", """""", _prefix + """estadoDeudaMonotributoProfe""")
)
                      

// @LINE:19
def getAgentesTotalDepartamento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.getAgentesTotalDepartamento(), HandlerDef(this, "controllers.dashboard.HonorariosController", "getAgentesTotalDepartamento", Seq(), "GET", """""", _prefix + """honorarios/agentesDepartamentos""")
)
                      

// @LINE:3
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.HonorariosController.index(), HandlerDef(this, "controllers.dashboard.HonorariosController", "index", Seq(), "GET", """""", _prefix + """honorarios""")
)
                      
    
}
                          

// @LINE:60
// @LINE:59
class ReverseInformeDeudaPorActasController {
    

// @LINE:60
def archivoDeudaPorActas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeDeudaPorActasController.archivoDeudaPorActas(), HandlerDef(this, "controllers.dashboard.InformeDeudaPorActasController", "archivoDeudaPorActas", Seq(), "GET", """""", _prefix + """archivo-deuda-actas""")
)
                      

// @LINE:59
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.dashboard.InformeDeudaPorActasController.index(), HandlerDef(this, "controllers.dashboard.InformeDeudaPorActasController", "index", Seq(), "GET", """""", _prefix + """informe-deuda-actas""")
)
                      
    
}
                          
}
        
    