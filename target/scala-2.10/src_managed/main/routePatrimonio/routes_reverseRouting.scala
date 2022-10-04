// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routePatrimonio.routes
// @HASH:f2062f867d9eeb5641bae91bce5c89e3c639c8fc
// @DATE:Tue Oct 04 11:43:28 ART 2022

import routePatrimonio.Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:215
// @LINE:214
// @LINE:211
// @LINE:210
// @LINE:209
// @LINE:208
// @LINE:207
// @LINE:206
// @LINE:204
// @LINE:202
// @LINE:201
// @LINE:198
// @LINE:197
// @LINE:196
// @LINE:194
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
// @LINE:189
// @LINE:188
// @LINE:187
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:164
// @LINE:163
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:130
// @LINE:129
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:108
// @LINE:107
// @LINE:105
// @LINE:104
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:63
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.patrimonio {

// @LINE:214
// @LINE:30
// @LINE:29
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
class ReverseOrdenesProvisionController {
    

// @LINE:5
def productosRecepcionados(orden_provision_id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/productosRecepcionados" + queryString(List(if(orden_provision_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("orden_provision_id", orden_provision_id)))))
}
                                                

// @LINE:15
def getLastNumeroProvision(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenesProvision/getLastNumeroProvision")
}
                                                

// @LINE:214
def suggestOrdenProvision(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestOrdenProvision/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:4
def verProductosSolicitados(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/ver-productos-solicitados" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:30
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:13
def getRecepciones(orden_provision_id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/getRecepciones" + queryString(List(if(orden_provision_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("orden_provision_id", orden_provision_id)))))
}
                                                

// @LINE:17
def modalAnularProductosPedientes(ordenId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/modalAnularProductosPedientes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("ordenId", ordenId)))))
}
                                                

// @LINE:8
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:20
def modalCrearActasDeAjustes(ordenId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/modalCrearActasDeAjustes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("ordenId", ordenId)))))
}
                                                

// @LINE:7
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenesProvision/actualizar")
}
                                                

// @LINE:29
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/modalBuscar")
}
                                                

// @LINE:18
def anularProductosPediente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenesProvision/anularProductosPediente")
}
                                                

// @LINE:3
def ver(id:Long = 0, idActa:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/ver" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(idActa == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idActa", idActa)))))
}
                                                

// @LINE:24
def informacionPorPacientesExcel(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/informacionPorPacientesExcel")
}
                                                

// @LINE:23
def informacionPorPacientes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/informacionPorPacientes")
}
                                                

// @LINE:6
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:21
def crearActasDeAjustes(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenesProvision/crearActasDeAjustes")
}
                                                

// @LINE:2
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/index")
}
                                                
    
}
                          

// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
class ReverseRemitosLineasBaulController {
    

// @LINE:115
def crear(remito_baul_id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas-baul/crear" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("remito_baul_id", remito_baul_id)))))
}
                                                

// @LINE:111
def index(remito_id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas-baul/index" + queryString(List(if(remito_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("remito_id", remito_id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:112
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas-baul/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:116
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos-lineas-baul/guardar")
}
                                                

// @LINE:114
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos-lineas-baul/actualizar")
}
                                                

// @LINE:113
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas-baul/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
class ReverseInventarioController {
    

// @LINE:100
def eliminar(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "inventario/eliminar" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:102
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "inventario/guardar")
}
                                                

// @LINE:101
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "inventario/actualizar")
}
                                                

// @LINE:99
def registrarModal(remito_linea_id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "inventario/registrarModal" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("remito_linea_id", remito_linea_id)))))
}
                                                

// @LINE:98
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "inventario/index")
}
                                                
    
}
                          

// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
class ReverseCertificacionesServiciosController {
    

// @LINE:59
def cambiarEstado(idCertificacion:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificaciones/cambiar-estado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idCertificacion", idCertificacion)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:60
def crearDesdeOrdenAjax(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "certificaciones/crearDesdeOrdenAjax" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:57
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "certificaciones/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:53
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificaciones/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:58
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificaciones/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:61
def agregarLineasConCliente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "certificaciones/agregarLineasConCliente")
}
                                                

// @LINE:52
def indexAjax(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificaciones/index-ajax")
}
                                                

// @LINE:55
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "certificaciones/guardar")
}
                                                

// @LINE:56
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificaciones/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:51
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificaciones/index")
}
                                                
    
}
                          

// @LINE:164
// @LINE:163
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
class ReverseActasRecepcionReportesController {
    

// @LINE:164
def informeListadoInventariable(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actas-recepcion-reporte/informeListadoInventariable")
}
                                                

// @LINE:163
def modalListadoInventariable(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actas-recepcion-reporte/modalListadoInventariable")
}
                                                

// @LINE:160
def reporteGeneralActa(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/reporteGeneralActa")
}
                                                

// @LINE:158
def reporte(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actas-recepcion-reporte/reporte" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:161
def reporteActaCierre(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actas-recepcion-reporte/reporteActaCierre" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:159
def reporteLineasActas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/reporteLineasActas")
}
                                                
    
}
                          

// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
class ReverseRemitosLineasController {
    

// @LINE:139
def enRemito(id_remito:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas/en-remito" + queryString(List(if(id_remito == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id_remito", id_remito)))))
}
                                                

// @LINE:140
def recepcionarTodos(id_remito:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas/recepcionar-todos" + queryString(List(if(id_remito == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id_remito", id_remito)))))
}
                                                

// @LINE:133
def paraAgregar(id_remito:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas/para-agregar" + queryString(List(if(id_remito == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id_remito", id_remito)))))
}
                                                

// @LINE:137
def modificar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos-lineas/modificar")
}
                                                

// @LINE:142
def modalAgregarConClientes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas/modalAgregarConClientes")
}
                                                

// @LINE:138
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:135
def tienePacientes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas/tiene-pacientes")
}
                                                

// @LINE:136
def agregar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos-lineas/agregar")
}
                                                

// @LINE:134
def agregarConCliente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas/para-agregar-cliente")
}
                                                

// @LINE:141
def controlesAgregarConCliente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos-lineas/controlesAgregarConCliente")
}
                                                

// @LINE:132
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-lineas/index")
}
                                                
    
}
                          

// @LINE:215
// @LINE:105
// @LINE:104
class ReversePrefijosController {
    

// @LINE:105
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "inventario-prefijo/modalBuscar")
}
                                                

// @LINE:215
def suggest(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestPrefijo/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:104
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "inventario-prefijo/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:202
// @LINE:201
// @LINE:198
// @LINE:197
// @LINE:196
// @LINE:194
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
// @LINE:189
// @LINE:188
// @LINE:187
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
class ReverseActasMovimientosController {
    

// @LINE:190
def cancelarPase(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/cancelarPase" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:184
def indexGeneral(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/indexGeneral")
}
                                                

// @LINE:188
def modalPasarOtroServicioIndividual(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/modalPasarOtroServicioIndividual" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:191
def asignarMiServicio(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/asignarMiServicio" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:185
def indexPasesPorUsuario(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/indexPasesPorUsuario")
}
                                                

// @LINE:202
def rechazarPase(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/rechazarPase" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:183
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:178
def index(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:181
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/guardar")
}
                                                

// @LINE:198
def cierreCircuito(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/cierreCircuito")
}
                                                

// @LINE:201
def aceptarPase(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/aceptarPase" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:182
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/actualizar")
}
                                                

// @LINE:196
def modalCierreCircuitoIndividual(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/modalCierreCircuitoIndividual" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:197
def modalCierreCircuito(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/modalCierreCircuito")
}
                                                

// @LINE:189
def pasarOtroServicio(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/pasarOtroServicio")
}
                                                

// @LINE:192
def cancelarPaseLista(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/cancelarPaseLista")
}
                                                

// @LINE:187
def modalPasarOtroServicio(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/modalPasarOtroServicio")
}
                                                

// @LINE:193
def modalAsignarMiServicio(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/modalAsignarMiServicio")
}
                                                

// @LINE:180
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:194
def asignarAMiServicioMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/asignarMiServicioMasivo")
}
                                                

// @LINE:179
def crear(actaId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/movimiento-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("actaId", actaId)))))
}
                                                
    
}
                          

// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
class ReverseLineasCertificacionesController {
    

// @LINE:72
def getListaLineasPacientes(certificacionId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificacion-linea/getListaLineasPacientes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("certificacionId", certificacionId)))))
}
                                                

// @LINE:66
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificacion-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:71
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificacion-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:69
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "certificacion-linea/guardar")
}
                                                

// @LINE:70
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "certificacion-linea/actualizar")
}
                                                

// @LINE:68
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificacion-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:67
def crear(certificacionId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificacion-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("certificacionId", certificacionId)))))
}
                                                
    
}
                          

// @LINE:33
// @LINE:32
// @LINE:27
// @LINE:26
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseOrdenesProvisionReportesController {
    

// @LINE:9
def ordenDeProvision(idOrdenProvision:Long, sinMonto:Boolean = false): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenesProvision/reproteOrdenProvision" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenProvision", idOrdenProvision)), if(sinMonto == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("sinMonto", sinMonto)))))
}
                                                

// @LINE:12
def informeGeneral(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/informeGeneral" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:26
def notaCierre(idOrdenProvision:Long, n:Int = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenesProvision/reproteNotaCierre" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenProvision", idOrdenProvision)), if(n == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("n", n)))))
}
                                                

// @LINE:33
def reporteListaLineasRemitos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "patrimonio/ordenesProvision/reporteListaLineasRemitos")
}
                                                

// @LINE:10
def informeInventariable(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/informeInventariable" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:32
def reporteGeneralOp(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "patrimonio/ordenesProvision/reporteGeneralOp")
}
                                                

// @LINE:27
def reporteAnulados(idOrdenProvision:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenesProvision/reporteAnulados" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenProvision", idOrdenProvision)))))
}
                                                

// @LINE:11
def informePendiente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesProvision/informePendiente" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
class ReverseRemitosBaulController {
    

// @LINE:93
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-baul/crear")
}
                                                

// @LINE:91
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-baul/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:92
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-baul/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:94
def guardar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-baul/guardar")
}
                                                

// @LINE:96
def actualizar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-baul/actualizar")
}
                                                

// @LINE:95
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-baul/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:90
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos-baul/index")
}
                                                
    
}
                          

// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
class ReverseRecepcionesController {
    

// @LINE:77
def crear(orden_provision_id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recepciones/crear" + queryString(List(if(orden_provision_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("orden_provision_id", orden_provision_id)))))
}
                                                

// @LINE:88
def cargarRemitosMasivos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recepciones/cargarRemitosMasivos")
}
                                                

// @LINE:86
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recepciones/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:76
def ver(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recepciones/ver" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:81
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recepciones/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:75
def indexAjax(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recepciones/indexAjax")
}
                                                

// @LINE:78
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recepciones/guardar")
}
                                                

// @LINE:80
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recepciones/actualizar")
}
                                                

// @LINE:79
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recepciones/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:87
def modalCargarRemitosMasivos(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recepciones/modalCargarRemitosMasivos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:74
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recepciones/index")
}
                                                

// @LINE:85
def modalBuscarRecepcionesDeOrdenes(idOrdenProvision:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recepciones/modalBuscarRecepcionesDeOrdenes" + queryString(List(if(idOrdenProvision == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idOrdenProvision", idOrdenProvision)))))
}
                                                
    
}
                          

// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
class ReverseActasRecepcionAccionesController {
    

// @LINE:166
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "acciones/actasRecepcion/modal-crear")
}
                                                

// @LINE:170
def asignar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "acciones/actasRecepcion/asignar")
}
                                                

// @LINE:169
def modalAsignar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "acciones/actasRecepcion/modal-asignar")
}
                                                

// @LINE:167
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "acciones/actasRecepcion/modal-guardar")
}
                                                

// @LINE:168
def revocar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "acciones/actasRecepcion/revocar")
}
                                                
    
}
                          

// @LINE:153
class ReverseActasRecepcionLineasController {
    

// @LINE:153
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcionLineas/index")
}
                                                
    
}
                          

// @LINE:1
class ReverseIndexController {
    

// @LINE:1
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:211
// @LINE:210
// @LINE:209
// @LINE:208
// @LINE:207
// @LINE:206
class ReverseActaRecepcionLineaAjusteController {
    

// @LINE:206
def index(acta_id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "acta-linea-ajuste/index" + queryString(List(if(acta_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("acta_id", acta_id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:211
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "acta-linea-ajuste/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:209
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "acta-linea-ajuste/guardar")
}
                                                

// @LINE:210
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "acta-linea-ajuste/actualizar")
}
                                                

// @LINE:208
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "acta-linea-ajuste/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:207
def crear(actaId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "acta-linea-ajuste/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("actaId", actaId)))))
}
                                                
    
}
                          

// @LINE:83
// @LINE:82
class ReverseRecepcionesReportesController {
    

// @LINE:82
def reporteLineasRecepciones(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recepciones/reporteLineasRecepciones")
}
                                                

// @LINE:83
def reporteDatosRecepciones(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recepciones/reporteDatosRecepciones")
}
                                                
    
}
                          

// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseAnulacionRecepcionProductosController {
    

// @LINE:38
def crear(linea_orden_id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/crear" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("linea_orden_id", linea_orden_id)))))
}
                                                

// @LINE:42
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "anulacion-productos/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:45
def anularConCliente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/anularConCliente")
}
                                                

// @LINE:37
def verLineasNoCertificadas(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/verLineasNoCertificadas" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:44
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:41
def eliminar(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/eliminar" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:49
def tienePacientes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/tienePacientes")
}
                                                

// @LINE:47
def controlesAnularConCliente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "anulacion-productos/controlesAnularConCliente")
}
                                                

// @LINE:43
def modalProductosEnOrden(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/modalBuscar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:39
def guardar(linea_orden_id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "anulacion-productos/guardar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("linea_orden_id", linea_orden_id)))))
}
                                                

// @LINE:48
def anular(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "anulacion-productos/anular")
}
                                                

// @LINE:36
def verLineas(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/ver-lineas" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:40
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:46
def modalAnularConClientes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/modalAnularConClientes")
}
                                                

// @LINE:35
def productosEnOrden(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anulacion-productos/productosEnOrden" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:204
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:154
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
class ReverseActasRecepcionController {
    

// @LINE:157
def cambiarEstado(idActa:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idActa", idActa)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:149
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/crear")
}
                                                

// @LINE:151
def ver(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/ver" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:154
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:204
def getPacientes(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/getPacientes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:147
def indexAjax(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/indexAjax")
}
                                                

// @LINE:150
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/guardar")
}
                                                

// @LINE:156
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "actasRecepcion/actualizar")
}
                                                

// @LINE:152
def verModal(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/verModal" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:155
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:148
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "actasRecepcion/index")
}
                                                
    
}
                          

// @LINE:130
// @LINE:129
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
class ReverseRemitosController {
    

// @LINE:121
def crear(recepcion_id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos/crear" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("recepcion_id", recepcion_id)))))
}
                                                

// @LINE:124
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:126
def reporteDatosRemitos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos/reporteDatosRemitos")
}
                                                

// @LINE:118
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:125
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:120
def indexAjax(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos/indexAjax")
}
                                                

// @LINE:122
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos/guardar")
}
                                                

// @LINE:130
def cambiarRecepcion(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos/cambiarRecepcion")
}
                                                

// @LINE:129
def modalCambiarRecepcion(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos/modalCambiarRecepcion")
}
                                                

// @LINE:127
def reporteDatosRemitosGeneral(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remitos/reporteDatosRemitosGeneral")
}
                                                

// @LINE:123
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:119
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remitos/index")
}
                                                
    
}
                          

// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
class ReverseActasRecepcionCertificacionesAccionesController {
    

// @LINE:172
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "acciones/actasRecepcionCertificaciones/modal-crear")
}
                                                

// @LINE:176
def asignar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "acciones/actasRecepcionCertificaciones/asignar")
}
                                                

// @LINE:175
def modalAsignar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "acciones/actasRecepcionCertificaciones/modal-asignar")
}
                                                

// @LINE:173
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "acciones/actasRecepcionCertificaciones/modal-guardar")
}
                                                

// @LINE:174
def revocar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "acciones/actasRecepcionCertificaciones/revocar")
}
                                                
    
}
                          

// @LINE:63
class ReverseCertificacionesReportesController {
    

// @LINE:63
def reporteCertificacion(idCertificacion:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "certificaciones/reportes/certificacion" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idCertificacion", idCertificacion)))))
}
                                                
    
}
                          

// @LINE:108
// @LINE:107
class ReversePrefijosAccionesController {
    

// @LINE:108
def modificar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "prefijo/acciones/modificar")
}
                                                

// @LINE:107
def modificarModal(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "prefijo/acciones/modificar-modal")
}
                                                
    
}
                          
}
                  


// @LINE:215
// @LINE:214
// @LINE:211
// @LINE:210
// @LINE:209
// @LINE:208
// @LINE:207
// @LINE:206
// @LINE:204
// @LINE:202
// @LINE:201
// @LINE:198
// @LINE:197
// @LINE:196
// @LINE:194
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
// @LINE:189
// @LINE:188
// @LINE:187
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:164
// @LINE:163
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:130
// @LINE:129
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:108
// @LINE:107
// @LINE:105
// @LINE:104
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:63
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.patrimonio.javascript {

// @LINE:214
// @LINE:30
// @LINE:29
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
class ReverseOrdenesProvisionController {
    

// @LINE:5
def productosRecepcionados : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.productosRecepcionados",
   """
      function(orden_provision_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/productosRecepcionados" + _qS([(orden_provision_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("orden_provision_id", orden_provision_id))])})
      }
   """
)
                        

// @LINE:15
def getLastNumeroProvision : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.getLastNumeroProvision",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/getLastNumeroProvision"})
      }
   """
)
                        

// @LINE:214
def suggestOrdenProvision : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.suggestOrdenProvision",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestOrdenProvision/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:4
def verProductosSolicitados : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.verProductosSolicitados",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/ver-productos-solicitados" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:30
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:13
def getRecepciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.getRecepciones",
   """
      function(orden_provision_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/getRecepciones" + _qS([(orden_provision_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("orden_provision_id", orden_provision_id))])})
      }
   """
)
                        

// @LINE:17
def modalAnularProductosPedientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.modalAnularProductosPedientes",
   """
      function(ordenId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/modalAnularProductosPedientes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("ordenId", ordenId)])})
      }
   """
)
                        

// @LINE:8
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:20
def modalCrearActasDeAjustes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.modalCrearActasDeAjustes",
   """
      function(ordenId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/modalCrearActasDeAjustes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("ordenId", ordenId)])})
      }
   """
)
                        

// @LINE:7
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/actualizar"})
      }
   """
)
                        

// @LINE:29
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/modalBuscar"})
      }
   """
)
                        

// @LINE:18
def anularProductosPediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.anularProductosPediente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/anularProductosPediente"})
      }
   """
)
                        

// @LINE:3
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.ver",
   """
      function(id,idActa) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/ver" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (idActa == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idActa", idActa))])})
      }
   """
)
                        

// @LINE:24
def informacionPorPacientesExcel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.informacionPorPacientesExcel",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/informacionPorPacientesExcel"})
      }
   """
)
                        

// @LINE:23
def informacionPorPacientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.informacionPorPacientes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/informacionPorPacientes"})
      }
   """
)
                        

// @LINE:6
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:21
def crearActasDeAjustes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.crearActasDeAjustes",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/crearActasDeAjustes"})
      }
   """
)
                        

// @LINE:2
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/index"})
      }
   """
)
                        
    
}
              

// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
class ReverseRemitosLineasBaulController {
    

// @LINE:115
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasBaulController.crear",
   """
      function(remito_baul_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas-baul/crear" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("remito_baul_id", remito_baul_id)])})
      }
   """
)
                        

// @LINE:111
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasBaulController.index",
   """
      function(remito_id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas-baul/index" + _qS([(remito_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("remito_id", remito_id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:112
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasBaulController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas-baul/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:116
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasBaulController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas-baul/guardar"})
      }
   """
)
                        

// @LINE:114
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasBaulController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas-baul/actualizar"})
      }
   """
)
                        

// @LINE:113
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasBaulController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas-baul/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
class ReverseInventarioController {
    

// @LINE:100
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.InventarioController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inventario/eliminar" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:102
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.InventarioController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "inventario/guardar"})
      }
   """
)
                        

// @LINE:101
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.InventarioController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "inventario/actualizar"})
      }
   """
)
                        

// @LINE:99
def registrarModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.InventarioController.registrarModal",
   """
      function(remito_linea_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inventario/registrarModal" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("remito_linea_id", remito_linea_id)])})
      }
   """
)
                        

// @LINE:98
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.InventarioController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inventario/index"})
      }
   """
)
                        
    
}
              

// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
class ReverseCertificacionesServiciosController {
    

// @LINE:59
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.cambiarEstado",
   """
      function(idCertificacion,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/cambiar-estado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idCertificacion", idCertificacion), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:60
def crearDesdeOrdenAjax : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.crearDesdeOrdenAjax",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/crearDesdeOrdenAjax" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:57
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:53
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:58
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:61
def agregarLineasConCliente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.agregarLineasConCliente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/agregarLineasConCliente"})
      }
   """
)
                        

// @LINE:52
def indexAjax : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.indexAjax",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/index-ajax"})
      }
   """
)
                        

// @LINE:55
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/guardar"})
      }
   """
)
                        

// @LINE:56
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:51
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesServiciosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/index"})
      }
   """
)
                        
    
}
              

// @LINE:164
// @LINE:163
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
class ReverseActasRecepcionReportesController {
    

// @LINE:164
def informeListadoInventariable : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionReportesController.informeListadoInventariable",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actas-recepcion-reporte/informeListadoInventariable"})
      }
   """
)
                        

// @LINE:163
def modalListadoInventariable : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionReportesController.modalListadoInventariable",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actas-recepcion-reporte/modalListadoInventariable"})
      }
   """
)
                        

// @LINE:160
def reporteGeneralActa : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionReportesController.reporteGeneralActa",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/reporteGeneralActa"})
      }
   """
)
                        

// @LINE:158
def reporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionReportesController.reporte",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actas-recepcion-reporte/reporte" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:161
def reporteActaCierre : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionReportesController.reporteActaCierre",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actas-recepcion-reporte/reporteActaCierre" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:159
def reporteLineasActas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionReportesController.reporteLineasActas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/reporteLineasActas"})
      }
   """
)
                        
    
}
              

// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
class ReverseRemitosLineasController {
    

// @LINE:139
def enRemito : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.enRemito",
   """
      function(id_remito) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/en-remito" + _qS([(id_remito == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id_remito", id_remito))])})
      }
   """
)
                        

// @LINE:140
def recepcionarTodos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.recepcionarTodos",
   """
      function(id_remito) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/recepcionar-todos" + _qS([(id_remito == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id_remito", id_remito))])})
      }
   """
)
                        

// @LINE:133
def paraAgregar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.paraAgregar",
   """
      function(id_remito) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/para-agregar" + _qS([(id_remito == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id_remito", id_remito))])})
      }
   """
)
                        

// @LINE:137
def modificar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.modificar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/modificar"})
      }
   """
)
                        

// @LINE:142
def modalAgregarConClientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.modalAgregarConClientes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/modalAgregarConClientes"})
      }
   """
)
                        

// @LINE:138
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:135
def tienePacientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.tienePacientes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/tiene-pacientes"})
      }
   """
)
                        

// @LINE:136
def agregar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.agregar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/agregar"})
      }
   """
)
                        

// @LINE:134
def agregarConCliente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.agregarConCliente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/para-agregar-cliente"})
      }
   """
)
                        

// @LINE:141
def controlesAgregarConCliente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.controlesAgregarConCliente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/controlesAgregarConCliente"})
      }
   """
)
                        

// @LINE:132
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosLineasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-lineas/index"})
      }
   """
)
                        
    
}
              

// @LINE:215
// @LINE:105
// @LINE:104
class ReversePrefijosController {
    

// @LINE:105
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.PrefijosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inventario-prefijo/modalBuscar"})
      }
   """
)
                        

// @LINE:215
def suggest : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.PrefijosController.suggest",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestPrefijo/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:104
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.PrefijosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inventario-prefijo/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        
    
}
              

// @LINE:202
// @LINE:201
// @LINE:198
// @LINE:197
// @LINE:196
// @LINE:194
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
// @LINE:189
// @LINE:188
// @LINE:187
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
class ReverseActasMovimientosController {
    

// @LINE:190
def cancelarPase : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.cancelarPase",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/cancelarPase" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:184
def indexGeneral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.indexGeneral",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/indexGeneral"})
      }
   """
)
                        

// @LINE:188
def modalPasarOtroServicioIndividual : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.modalPasarOtroServicioIndividual",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/modalPasarOtroServicioIndividual" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:191
def asignarMiServicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.asignarMiServicio",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/asignarMiServicio" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:185
def indexPasesPorUsuario : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.indexPasesPorUsuario",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/indexPasesPorUsuario"})
      }
   """
)
                        

// @LINE:202
def rechazarPase : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.rechazarPase",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/rechazarPase" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:183
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:178
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.index",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:181
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/guardar"})
      }
   """
)
                        

// @LINE:198
def cierreCircuito : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.cierreCircuito",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/cierreCircuito"})
      }
   """
)
                        

// @LINE:201
def aceptarPase : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.aceptarPase",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/aceptarPase" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:182
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/actualizar"})
      }
   """
)
                        

// @LINE:196
def modalCierreCircuitoIndividual : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.modalCierreCircuitoIndividual",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/modalCierreCircuitoIndividual" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:197
def modalCierreCircuito : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.modalCierreCircuito",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/modalCierreCircuito"})
      }
   """
)
                        

// @LINE:189
def pasarOtroServicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.pasarOtroServicio",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/pasarOtroServicio"})
      }
   """
)
                        

// @LINE:192
def cancelarPaseLista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.cancelarPaseLista",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/cancelarPaseLista"})
      }
   """
)
                        

// @LINE:187
def modalPasarOtroServicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.modalPasarOtroServicio",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/modalPasarOtroServicio"})
      }
   """
)
                        

// @LINE:193
def modalAsignarMiServicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.modalAsignarMiServicio",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/modalAsignarMiServicio"})
      }
   """
)
                        

// @LINE:180
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:194
def asignarAMiServicioMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.asignarAMiServicioMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/asignarMiServicioMasivo"})
      }
   """
)
                        

// @LINE:179
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasMovimientosController.crear",
   """
      function(actaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/movimiento-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("actaId", actaId)])})
      }
   """
)
                        
    
}
              

// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
class ReverseLineasCertificacionesController {
    

// @LINE:72
def getListaLineasPacientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.LineasCertificacionesController.getListaLineasPacientes",
   """
      function(certificacionId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificacion-linea/getListaLineasPacientes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("certificacionId", certificacionId)])})
      }
   """
)
                        

// @LINE:66
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.LineasCertificacionesController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificacion-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:71
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.LineasCertificacionesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificacion-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:69
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.LineasCertificacionesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "certificacion-linea/guardar"})
      }
   """
)
                        

// @LINE:70
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.LineasCertificacionesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "certificacion-linea/actualizar"})
      }
   """
)
                        

// @LINE:68
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.LineasCertificacionesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificacion-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:67
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.LineasCertificacionesController.crear",
   """
      function(certificacionId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificacion-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("certificacionId", certificacionId)])})
      }
   """
)
                        
    
}
              

// @LINE:33
// @LINE:32
// @LINE:27
// @LINE:26
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseOrdenesProvisionReportesController {
    

// @LINE:9
def ordenDeProvision : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionReportesController.ordenDeProvision",
   """
      function(idOrdenProvision,sinMonto) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/reproteOrdenProvision" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenProvision", idOrdenProvision), (sinMonto == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("sinMonto", sinMonto))])})
      }
   """
)
                        

// @LINE:12
def informeGeneral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionReportesController.informeGeneral",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/informeGeneral" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:26
def notaCierre : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionReportesController.notaCierre",
   """
      function(idOrdenProvision,n) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/reproteNotaCierre" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenProvision", idOrdenProvision), (n == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("n", n))])})
      }
   """
)
                        

// @LINE:33
def reporteListaLineasRemitos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionReportesController.reporteListaLineasRemitos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "patrimonio/ordenesProvision/reporteListaLineasRemitos"})
      }
   """
)
                        

// @LINE:10
def informeInventariable : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionReportesController.informeInventariable",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/informeInventariable" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:32
def reporteGeneralOp : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionReportesController.reporteGeneralOp",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "patrimonio/ordenesProvision/reporteGeneralOp"})
      }
   """
)
                        

// @LINE:27
def reporteAnulados : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionReportesController.reporteAnulados",
   """
      function(idOrdenProvision) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/reporteAnulados" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenProvision", idOrdenProvision)])})
      }
   """
)
                        

// @LINE:11
def informePendiente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.OrdenesProvisionReportesController.informePendiente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesProvision/informePendiente" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
class ReverseRemitosBaulController {
    

// @LINE:93
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosBaulController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-baul/crear"})
      }
   """
)
                        

// @LINE:91
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosBaulController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-baul/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:92
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosBaulController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-baul/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:94
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosBaulController.guardar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-baul/guardar"})
      }
   """
)
                        

// @LINE:96
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosBaulController.actualizar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-baul/actualizar"})
      }
   """
)
                        

// @LINE:95
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosBaulController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-baul/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:90
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosBaulController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos-baul/index"})
      }
   """
)
                        
    
}
              

// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
class ReverseRecepcionesController {
    

// @LINE:77
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.crear",
   """
      function(orden_provision_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/crear" + _qS([(orden_provision_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("orden_provision_id", orden_provision_id))])})
      }
   """
)
                        

// @LINE:88
def cargarRemitosMasivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.cargarRemitosMasivos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/cargarRemitosMasivos"})
      }
   """
)
                        

// @LINE:86
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:76
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/ver" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:81
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:75
def indexAjax : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.indexAjax",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/indexAjax"})
      }
   """
)
                        

// @LINE:78
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/guardar"})
      }
   """
)
                        

// @LINE:80
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/actualizar"})
      }
   """
)
                        

// @LINE:79
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:87
def modalCargarRemitosMasivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.modalCargarRemitosMasivos",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/modalCargarRemitosMasivos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:74
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/index"})
      }
   """
)
                        

// @LINE:85
def modalBuscarRecepcionesDeOrdenes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesController.modalBuscarRecepcionesDeOrdenes",
   """
      function(idOrdenProvision) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/modalBuscarRecepcionesDeOrdenes" + _qS([(idOrdenProvision == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrdenProvision", idOrdenProvision))])})
      }
   """
)
                        
    
}
              

// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
class ReverseActasRecepcionAccionesController {
    

// @LINE:166
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionAccionesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcion/modal-crear"})
      }
   """
)
                        

// @LINE:170
def asignar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionAccionesController.asignar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcion/asignar"})
      }
   """
)
                        

// @LINE:169
def modalAsignar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionAccionesController.modalAsignar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcion/modal-asignar"})
      }
   """
)
                        

// @LINE:167
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionAccionesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcion/modal-guardar"})
      }
   """
)
                        

// @LINE:168
def revocar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionAccionesController.revocar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcion/revocar"})
      }
   """
)
                        
    
}
              

// @LINE:153
class ReverseActasRecepcionLineasController {
    

// @LINE:153
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionLineasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcionLineas/index"})
      }
   """
)
                        
    
}
              

// @LINE:1
class ReverseIndexController {
    

// @LINE:1
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:211
// @LINE:210
// @LINE:209
// @LINE:208
// @LINE:207
// @LINE:206
class ReverseActaRecepcionLineaAjusteController {
    

// @LINE:206
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActaRecepcionLineaAjusteController.index",
   """
      function(acta_id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acta-linea-ajuste/index" + _qS([(acta_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("acta_id", acta_id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:211
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActaRecepcionLineaAjusteController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acta-linea-ajuste/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:209
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActaRecepcionLineaAjusteController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acta-linea-ajuste/guardar"})
      }
   """
)
                        

// @LINE:210
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActaRecepcionLineaAjusteController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acta-linea-ajuste/actualizar"})
      }
   """
)
                        

// @LINE:208
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActaRecepcionLineaAjusteController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acta-linea-ajuste/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:207
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActaRecepcionLineaAjusteController.crear",
   """
      function(actaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acta-linea-ajuste/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("actaId", actaId)])})
      }
   """
)
                        
    
}
              

// @LINE:83
// @LINE:82
class ReverseRecepcionesReportesController {
    

// @LINE:82
def reporteLineasRecepciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesReportesController.reporteLineasRecepciones",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/reporteLineasRecepciones"})
      }
   """
)
                        

// @LINE:83
def reporteDatosRecepciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RecepcionesReportesController.reporteDatosRecepciones",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recepciones/reporteDatosRecepciones"})
      }
   """
)
                        
    
}
              

// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseAnulacionRecepcionProductosController {
    

// @LINE:38
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.crear",
   """
      function(linea_orden_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/crear" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("linea_orden_id", linea_orden_id)])})
      }
   """
)
                        

// @LINE:42
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:45
def anularConCliente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.anularConCliente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/anularConCliente"})
      }
   """
)
                        

// @LINE:37
def verLineasNoCertificadas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.verLineasNoCertificadas",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/verLineasNoCertificadas" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:44
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:41
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/eliminar" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:49
def tienePacientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.tienePacientes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/tienePacientes"})
      }
   """
)
                        

// @LINE:47
def controlesAnularConCliente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.controlesAnularConCliente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/controlesAnularConCliente"})
      }
   """
)
                        

// @LINE:43
def modalProductosEnOrden : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.modalProductosEnOrden",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/modalBuscar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:39
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.guardar",
   """
      function(linea_orden_id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/guardar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("linea_orden_id", linea_orden_id)])})
      }
   """
)
                        

// @LINE:48
def anular : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.anular",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/anular"})
      }
   """
)
                        

// @LINE:36
def verLineas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.verLineas",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/ver-lineas" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:40
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:46
def modalAnularConClientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.modalAnularConClientes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/modalAnularConClientes"})
      }
   """
)
                        

// @LINE:35
def productosEnOrden : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.AnulacionRecepcionProductosController.productosEnOrden",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anulacion-productos/productosEnOrden" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:204
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:154
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
class ReverseActasRecepcionController {
    

// @LINE:157
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.cambiarEstado",
   """
      function(idActa,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idActa", idActa), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:149
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/crear"})
      }
   """
)
                        

// @LINE:151
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/ver" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:154
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:204
def getPacientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.getPacientes",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/getPacientes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:147
def indexAjax : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.indexAjax",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/indexAjax"})
      }
   """
)
                        

// @LINE:150
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/guardar"})
      }
   """
)
                        

// @LINE:156
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/actualizar"})
      }
   """
)
                        

// @LINE:152
def verModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.verModal",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/verModal" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:155
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:148
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "actasRecepcion/index"})
      }
   """
)
                        
    
}
              

// @LINE:130
// @LINE:129
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
class ReverseRemitosController {
    

// @LINE:121
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.crear",
   """
      function(recepcion_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/crear" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("recepcion_id", recepcion_id)])})
      }
   """
)
                        

// @LINE:124
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:126
def reporteDatosRemitos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.reporteDatosRemitos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/reporteDatosRemitos"})
      }
   """
)
                        

// @LINE:118
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:125
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:120
def indexAjax : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.indexAjax",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/indexAjax"})
      }
   """
)
                        

// @LINE:122
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/guardar"})
      }
   """
)
                        

// @LINE:130
def cambiarRecepcion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.cambiarRecepcion",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/cambiarRecepcion"})
      }
   """
)
                        

// @LINE:129
def modalCambiarRecepcion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.modalCambiarRecepcion",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/modalCambiarRecepcion"})
      }
   """
)
                        

// @LINE:127
def reporteDatosRemitosGeneral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.reporteDatosRemitosGeneral",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/reporteDatosRemitosGeneral"})
      }
   """
)
                        

// @LINE:123
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:119
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.RemitosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remitos/index"})
      }
   """
)
                        
    
}
              

// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
class ReverseActasRecepcionCertificacionesAccionesController {
    

// @LINE:172
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcionCertificaciones/modal-crear"})
      }
   """
)
                        

// @LINE:176
def asignar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.asignar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcionCertificaciones/asignar"})
      }
   """
)
                        

// @LINE:175
def modalAsignar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.modalAsignar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcionCertificaciones/modal-asignar"})
      }
   """
)
                        

// @LINE:173
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcionCertificaciones/modal-guardar"})
      }
   """
)
                        

// @LINE:174
def revocar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.revocar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acciones/actasRecepcionCertificaciones/revocar"})
      }
   """
)
                        
    
}
              

// @LINE:63
class ReverseCertificacionesReportesController {
    

// @LINE:63
def reporteCertificacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.CertificacionesReportesController.reporteCertificacion",
   """
      function(idCertificacion) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "certificaciones/reportes/certificacion" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idCertificacion", idCertificacion)])})
      }
   """
)
                        
    
}
              

// @LINE:108
// @LINE:107
class ReversePrefijosAccionesController {
    

// @LINE:108
def modificar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.PrefijosAccionesController.modificar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "prefijo/acciones/modificar"})
      }
   """
)
                        

// @LINE:107
def modificarModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.patrimonio.PrefijosAccionesController.modificarModal",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "prefijo/acciones/modificar-modal"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:215
// @LINE:214
// @LINE:211
// @LINE:210
// @LINE:209
// @LINE:208
// @LINE:207
// @LINE:206
// @LINE:204
// @LINE:202
// @LINE:201
// @LINE:198
// @LINE:197
// @LINE:196
// @LINE:194
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
// @LINE:189
// @LINE:188
// @LINE:187
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:164
// @LINE:163
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:130
// @LINE:129
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:108
// @LINE:107
// @LINE:105
// @LINE:104
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:63
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.patrimonio.ref {


// @LINE:214
// @LINE:30
// @LINE:29
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
class ReverseOrdenesProvisionController {
    

// @LINE:5
def productosRecepcionados(orden_provision_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.productosRecepcionados(orden_provision_id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "productosRecepcionados", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/productosRecepcionados""")
)
                      

// @LINE:15
def getLastNumeroProvision(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.getLastNumeroProvision(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "getLastNumeroProvision", Seq(), "POST", """""", _prefix + """ordenesProvision/getLastNumeroProvision""")
)
                      

// @LINE:214
def suggestOrdenProvision(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.suggestOrdenProvision(input), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "suggestOrdenProvision", Seq(classOf[String]), "GET", """""", _prefix + """suggestOrdenProvision/$input<[^/]+>""")
)
                      

// @LINE:4
def verProductosSolicitados(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.verProductosSolicitados(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "verProductosSolicitados", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/ver-productos-solicitados""")
)
                      

// @LINE:30
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.get(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """ordenesProvision/get""")
)
                      

// @LINE:13
def getRecepciones(orden_provision_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.getRecepciones(orden_provision_id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "getRecepciones", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/getRecepciones""")
)
                      

// @LINE:17
def modalAnularProductosPedientes(ordenId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.modalAnularProductosPedientes(ordenId), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "modalAnularProductosPedientes", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/modalAnularProductosPedientes""")
)
                      

// @LINE:8
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.eliminar(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/eliminar""")
)
                      

// @LINE:20
def modalCrearActasDeAjustes(ordenId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.modalCrearActasDeAjustes(ordenId), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "modalCrearActasDeAjustes", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/modalCrearActasDeAjustes""")
)
                      

// @LINE:7
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.actualizar(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "actualizar", Seq(), "POST", """""", _prefix + """ordenesProvision/actualizar""")
)
                      

// @LINE:29
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.modalBuscar(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "modalBuscar", Seq(), "GET", """""", _prefix + """ordenesProvision/modalBuscar""")
)
                      

// @LINE:18
def anularProductosPediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.anularProductosPediente(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "anularProductosPediente", Seq(), "POST", """""", _prefix + """ordenesProvision/anularProductosPediente""")
)
                      

// @LINE:3
def ver(id:Long, idActa:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.ver(id, idActa), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "ver", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """ordenesProvision/ver""")
)
                      

// @LINE:24
def informacionPorPacientesExcel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.informacionPorPacientesExcel(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "informacionPorPacientesExcel", Seq(), "GET", """""", _prefix + """ordenesProvision/informacionPorPacientesExcel""")
)
                      

// @LINE:23
def informacionPorPacientes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.informacionPorPacientes(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "informacionPorPacientes", Seq(), "GET", """""", _prefix + """ordenesProvision/informacionPorPacientes""")
)
                      

// @LINE:6
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.editar(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/editar""")
)
                      

// @LINE:21
def crearActasDeAjustes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.crearActasDeAjustes(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "crearActasDeAjustes", Seq(), "POST", """""", _prefix + """ordenesProvision/crearActasDeAjustes""")
)
                      

// @LINE:2
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionController.index(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionController", "index", Seq(), "GET", """""", _prefix + """ordenesProvision/index""")
)
                      
    
}
                          

// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
class ReverseRemitosLineasBaulController {
    

// @LINE:115
def crear(remito_baul_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasBaulController.crear(remito_baul_id), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "crear", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-lineas-baul/crear""")
)
                      

// @LINE:111
def index(remito_id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasBaulController.index(remito_id, editable), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """remitos-lineas-baul/index""")
)
                      

// @LINE:112
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasBaulController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-lineas-baul/eliminar""")
)
                      

// @LINE:116
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasBaulController.guardar(), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "guardar", Seq(), "POST", """""", _prefix + """remitos-lineas-baul/guardar""")
)
                      

// @LINE:114
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasBaulController.actualizar(), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "actualizar", Seq(), "POST", """""", _prefix + """remitos-lineas-baul/actualizar""")
)
                      

// @LINE:113
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasBaulController.editar(id), HandlerDef(this, "controllers.patrimonio.RemitosLineasBaulController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-lineas-baul/editar""")
)
                      
    
}
                          

// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
class ReverseInventarioController {
    

// @LINE:100
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.InventarioController.eliminar(id), HandlerDef(this, "controllers.patrimonio.InventarioController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """inventario/eliminar""")
)
                      

// @LINE:102
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.InventarioController.guardar(), HandlerDef(this, "controllers.patrimonio.InventarioController", "guardar", Seq(), "POST", """""", _prefix + """inventario/guardar""")
)
                      

// @LINE:101
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.InventarioController.actualizar(), HandlerDef(this, "controllers.patrimonio.InventarioController", "actualizar", Seq(), "POST", """""", _prefix + """inventario/actualizar""")
)
                      

// @LINE:99
def registrarModal(remito_linea_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.InventarioController.registrarModal(remito_linea_id), HandlerDef(this, "controllers.patrimonio.InventarioController", "registrarModal", Seq(classOf[Long]), "GET", """""", _prefix + """inventario/registrarModal""")
)
                      

// @LINE:98
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.InventarioController.index(), HandlerDef(this, "controllers.patrimonio.InventarioController", "index", Seq(), "GET", """""", _prefix + """inventario/index""")
)
                      
    
}
                          

// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
class ReverseCertificacionesServiciosController {
    

// @LINE:59
def cambiarEstado(idCertificacion:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.cambiarEstado(idCertificacion, idEstado), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """certificaciones/cambiar-estado""")
)
                      

// @LINE:60
def crearDesdeOrdenAjax(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.crearDesdeOrdenAjax(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "crearDesdeOrdenAjax", Seq(classOf[Long]), "POST", """""", _prefix + """certificaciones/crearDesdeOrdenAjax""")
)
                      

// @LINE:57
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.actualizar(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """certificaciones/actualizar""")
)
                      

// @LINE:53
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.ver(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """certificaciones/ver""")
)
                      

// @LINE:58
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.eliminar(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """certificaciones/eliminar""")
)
                      

// @LINE:61
def agregarLineasConCliente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.agregarLineasConCliente(), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "agregarLineasConCliente", Seq(), "POST", """""", _prefix + """certificaciones/agregarLineasConCliente""")
)
                      

// @LINE:52
def indexAjax(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.indexAjax(), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "indexAjax", Seq(), "GET", """""", _prefix + """certificaciones/index-ajax""")
)
                      

// @LINE:55
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.guardar(), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "guardar", Seq(), "POST", """GET    /certificaciones/crear             			controllers.patrimonio.CertificacionesServiciosController.crear(linea_orden_id:Long ?= 0)""", _prefix + """certificaciones/guardar""")
)
                      

// @LINE:56
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.editar(id), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """certificaciones/editar""")
)
                      

// @LINE:51
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesServiciosController.index(), HandlerDef(this, "controllers.patrimonio.CertificacionesServiciosController", "index", Seq(), "GET", """""", _prefix + """certificaciones/index""")
)
                      
    
}
                          

// @LINE:164
// @LINE:163
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
class ReverseActasRecepcionReportesController {
    

// @LINE:164
def informeListadoInventariable(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionReportesController.informeListadoInventariable(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "informeListadoInventariable", Seq(), "POST", """""", _prefix + """actas-recepcion-reporte/informeListadoInventariable""")
)
                      

// @LINE:163
def modalListadoInventariable(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionReportesController.modalListadoInventariable(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "modalListadoInventariable", Seq(), "GET", """""", _prefix + """actas-recepcion-reporte/modalListadoInventariable""")
)
                      

// @LINE:160
def reporteGeneralActa(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionReportesController.reporteGeneralActa(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "reporteGeneralActa", Seq(), "POST", """""", _prefix + """actasRecepcion/reporteGeneralActa""")
)
                      

// @LINE:158
def reporte(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionReportesController.reporte(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "reporte", Seq(classOf[Long]), "GET", """""", _prefix + """actas-recepcion-reporte/reporte""")
)
                      

// @LINE:161
def reporteActaCierre(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionReportesController.reporteActaCierre(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "reporteActaCierre", Seq(classOf[Long]), "GET", """""", _prefix + """actas-recepcion-reporte/reporteActaCierre""")
)
                      

// @LINE:159
def reporteLineasActas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionReportesController.reporteLineasActas(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionReportesController", "reporteLineasActas", Seq(), "POST", """""", _prefix + """actasRecepcion/reporteLineasActas""")
)
                      
    
}
                          

// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
class ReverseRemitosLineasController {
    

// @LINE:139
def enRemito(id_remito:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.enRemito(id_remito), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "enRemito", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-lineas/en-remito""")
)
                      

// @LINE:140
def recepcionarTodos(id_remito:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.recepcionarTodos(id_remito), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "recepcionarTodos", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-lineas/recepcionar-todos""")
)
                      

// @LINE:133
def paraAgregar(id_remito:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.paraAgregar(id_remito), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "paraAgregar", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-lineas/para-agregar""")
)
                      

// @LINE:137
def modificar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.modificar(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "modificar", Seq(), "POST", """""", _prefix + """remitos-lineas/modificar""")
)
                      

// @LINE:142
def modalAgregarConClientes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.modalAgregarConClientes(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "modalAgregarConClientes", Seq(), "GET", """""", _prefix + """remitos-lineas/modalAgregarConClientes""")
)
                      

// @LINE:138
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-lineas/eliminar""")
)
                      

// @LINE:135
def tienePacientes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.tienePacientes(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "tienePacientes", Seq(), "GET", """""", _prefix + """remitos-lineas/tiene-pacientes""")
)
                      

// @LINE:136
def agregar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.agregar(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "agregar", Seq(), "POST", """""", _prefix + """remitos-lineas/agregar""")
)
                      

// @LINE:134
def agregarConCliente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.agregarConCliente(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "agregarConCliente", Seq(), "GET", """""", _prefix + """remitos-lineas/para-agregar-cliente""")
)
                      

// @LINE:141
def controlesAgregarConCliente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.controlesAgregarConCliente(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "controlesAgregarConCliente", Seq(), "POST", """""", _prefix + """remitos-lineas/controlesAgregarConCliente""")
)
                      

// @LINE:132
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosLineasController.index(), HandlerDef(this, "controllers.patrimonio.RemitosLineasController", "index", Seq(), "GET", """""", _prefix + """remitos-lineas/index""")
)
                      
    
}
                          

// @LINE:215
// @LINE:105
// @LINE:104
class ReversePrefijosController {
    

// @LINE:105
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.PrefijosController.modalBuscar(), HandlerDef(this, "controllers.patrimonio.PrefijosController", "modalBuscar", Seq(), "GET", """""", _prefix + """inventario-prefijo/modalBuscar""")
)
                      

// @LINE:215
def suggest(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.PrefijosController.suggest(input), HandlerDef(this, "controllers.patrimonio.PrefijosController", "suggest", Seq(classOf[String]), "GET", """""", _prefix + """suggestPrefijo/$input<[^/]+>""")
)
                      

// @LINE:104
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.PrefijosController.get(id), HandlerDef(this, "controllers.patrimonio.PrefijosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """inventario-prefijo/get""")
)
                      
    
}
                          

// @LINE:202
// @LINE:201
// @LINE:198
// @LINE:197
// @LINE:196
// @LINE:194
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
// @LINE:189
// @LINE:188
// @LINE:187
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
class ReverseActasMovimientosController {
    

// @LINE:190
def cancelarPase(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.cancelarPase(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "cancelarPase", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/cancelarPase""")
)
                      

// @LINE:184
def indexGeneral(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.indexGeneral(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "indexGeneral", Seq(), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/indexGeneral""")
)
                      

// @LINE:188
def modalPasarOtroServicioIndividual(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.modalPasarOtroServicioIndividual(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalPasarOtroServicioIndividual", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/modalPasarOtroServicioIndividual""")
)
                      

// @LINE:191
def asignarMiServicio(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.asignarMiServicio(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "asignarMiServicio", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/asignarMiServicio""")
)
                      

// @LINE:185
def indexPasesPorUsuario(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.indexPasesPorUsuario(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "indexPasesPorUsuario", Seq(), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/indexPasesPorUsuario""")
)
                      

// @LINE:202
def rechazarPase(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.rechazarPase(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "rechazarPase", Seq(classOf[Long]), "POST", """""", _prefix + """actasRecepcion/movimiento-linea/rechazarPase""")
)
                      

// @LINE:183
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.eliminar(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/eliminar""")
)
                      

// @LINE:178
def index(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.index(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "index", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/index""")
)
                      

// @LINE:181
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.guardar(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "guardar", Seq(), "POST", """""", _prefix + """actasRecepcion/movimiento-linea/guardar""")
)
                      

// @LINE:198
def cierreCircuito(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.cierreCircuito(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "cierreCircuito", Seq(), "POST", """""", _prefix + """actasRecepcion/movimiento-linea/cierreCircuito""")
)
                      

// @LINE:201
def aceptarPase(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.aceptarPase(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "aceptarPase", Seq(classOf[Long]), "POST", """""", _prefix + """actasRecepcion/movimiento-linea/aceptarPase""")
)
                      

// @LINE:182
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.actualizar(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "actualizar", Seq(), "POST", """""", _prefix + """actasRecepcion/movimiento-linea/actualizar""")
)
                      

// @LINE:196
def modalCierreCircuitoIndividual(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.modalCierreCircuitoIndividual(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalCierreCircuitoIndividual", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/modalCierreCircuitoIndividual""")
)
                      

// @LINE:197
def modalCierreCircuito(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.modalCierreCircuito(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalCierreCircuito", Seq(), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/modalCierreCircuito""")
)
                      

// @LINE:189
def pasarOtroServicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.pasarOtroServicio(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "pasarOtroServicio", Seq(), "POST", """""", _prefix + """actasRecepcion/movimiento-linea/pasarOtroServicio""")
)
                      

// @LINE:192
def cancelarPaseLista(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.cancelarPaseLista(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "cancelarPaseLista", Seq(), "POST", """""", _prefix + """actasRecepcion/movimiento-linea/cancelarPaseLista""")
)
                      

// @LINE:187
def modalPasarOtroServicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.modalPasarOtroServicio(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalPasarOtroServicio", Seq(), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/modalPasarOtroServicio""")
)
                      

// @LINE:193
def modalAsignarMiServicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.modalAsignarMiServicio(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "modalAsignarMiServicio", Seq(), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/modalAsignarMiServicio""")
)
                      

// @LINE:180
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.editar(id), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/editar""")
)
                      

// @LINE:194
def asignarAMiServicioMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.asignarAMiServicioMasivo(), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "asignarAMiServicioMasivo", Seq(), "POST", """""", _prefix + """actasRecepcion/movimiento-linea/asignarMiServicioMasivo""")
)
                      

// @LINE:179
def crear(actaId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasMovimientosController.crear(actaId), HandlerDef(this, "controllers.patrimonio.ActasMovimientosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """actasRecepcion/movimiento-linea/crear""")
)
                      
    
}
                          

// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
class ReverseLineasCertificacionesController {
    

// @LINE:72
def getListaLineasPacientes(certificacionId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.LineasCertificacionesController.getListaLineasPacientes(certificacionId), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "getListaLineasPacientes", Seq(classOf[Long]), "GET", """""", _prefix + """certificacion-linea/getListaLineasPacientes""")
)
                      

// @LINE:66
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.LineasCertificacionesController.index(id, editable), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """certificacion-linea/index""")
)
                      

// @LINE:71
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.LineasCertificacionesController.eliminar(id), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """certificacion-linea/eliminar""")
)
                      

// @LINE:69
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.LineasCertificacionesController.guardar(), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "guardar", Seq(), "POST", """""", _prefix + """certificacion-linea/guardar""")
)
                      

// @LINE:70
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.LineasCertificacionesController.actualizar(), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "actualizar", Seq(), "POST", """""", _prefix + """certificacion-linea/actualizar""")
)
                      

// @LINE:68
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.LineasCertificacionesController.editar(id), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """certificacion-linea/editar""")
)
                      

// @LINE:67
def crear(certificacionId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.LineasCertificacionesController.crear(certificacionId), HandlerDef(this, "controllers.patrimonio.LineasCertificacionesController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """certificacion-linea/crear""")
)
                      
    
}
                          

// @LINE:33
// @LINE:32
// @LINE:27
// @LINE:26
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseOrdenesProvisionReportesController {
    

// @LINE:9
def ordenDeProvision(idOrdenProvision:Long, sinMonto:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionReportesController.ordenDeProvision(idOrdenProvision, sinMonto), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "ordenDeProvision", Seq(classOf[Long], classOf[Boolean]), "POST", """""", _prefix + """ordenesProvision/reproteOrdenProvision""")
)
                      

// @LINE:12
def informeGeneral(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionReportesController.informeGeneral(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "informeGeneral", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/informeGeneral""")
)
                      

// @LINE:26
def notaCierre(idOrdenProvision:Long, n:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionReportesController.notaCierre(idOrdenProvision, n), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "notaCierre", Seq(classOf[Long], classOf[Int]), "POST", """""", _prefix + """ordenesProvision/reproteNotaCierre""")
)
                      

// @LINE:33
def reporteListaLineasRemitos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionReportesController.reporteListaLineasRemitos(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "reporteListaLineasRemitos", Seq(), "POST", """""", _prefix + """patrimonio/ordenesProvision/reporteListaLineasRemitos""")
)
                      

// @LINE:10
def informeInventariable(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionReportesController.informeInventariable(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "informeInventariable", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/informeInventariable""")
)
                      

// @LINE:32
def reporteGeneralOp(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionReportesController.reporteGeneralOp(), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "reporteGeneralOp", Seq(), "POST", """""", _prefix + """patrimonio/ordenesProvision/reporteGeneralOp""")
)
                      

// @LINE:27
def reporteAnulados(idOrdenProvision:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionReportesController.reporteAnulados(idOrdenProvision), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "reporteAnulados", Seq(classOf[Long]), "POST", """""", _prefix + """ordenesProvision/reporteAnulados""")
)
                      

// @LINE:11
def informePendiente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.OrdenesProvisionReportesController.informePendiente(id), HandlerDef(this, "controllers.patrimonio.OrdenesProvisionReportesController", "informePendiente", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesProvision/informePendiente""")
)
                      
    
}
                          

// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
class ReverseRemitosBaulController {
    

// @LINE:93
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosBaulController.crear(), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "crear", Seq(), "GET", """""", _prefix + """remitos-baul/crear""")
)
                      

// @LINE:91
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosBaulController.ver(id), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-baul/ver""")
)
                      

// @LINE:92
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosBaulController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-baul/eliminar""")
)
                      

// @LINE:94
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosBaulController.guardar(), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "guardar", Seq(), "GET", """""", _prefix + """remitos-baul/guardar""")
)
                      

// @LINE:96
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosBaulController.actualizar(), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "actualizar", Seq(), "GET", """""", _prefix + """remitos-baul/actualizar""")
)
                      

// @LINE:95
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosBaulController.editar(id), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """remitos-baul/editar""")
)
                      

// @LINE:90
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosBaulController.index(), HandlerDef(this, "controllers.patrimonio.RemitosBaulController", "index", Seq(), "GET", """""", _prefix + """remitos-baul/index""")
)
                      
    
}
                          

// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
class ReverseRecepcionesController {
    

// @LINE:77
def crear(orden_provision_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.crear(orden_provision_id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "crear", Seq(classOf[Long]), "GET", """""", _prefix + """recepciones/crear""")
)
                      

// @LINE:88
def cargarRemitosMasivos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.cargarRemitosMasivos(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "cargarRemitosMasivos", Seq(), "POST", """""", _prefix + """recepciones/cargarRemitosMasivos""")
)
                      

// @LINE:86
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.get(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """recepciones/get""")
)
                      

// @LINE:76
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.ver(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """recepciones/ver""")
)
                      

// @LINE:81
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """recepciones/eliminar""")
)
                      

// @LINE:75
def indexAjax(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.indexAjax(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "indexAjax", Seq(), "GET", """""", _prefix + """recepciones/indexAjax""")
)
                      

// @LINE:78
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.guardar(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "guardar", Seq(), "POST", """""", _prefix + """recepciones/guardar""")
)
                      

// @LINE:80
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.actualizar(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "actualizar", Seq(), "POST", """""", _prefix + """recepciones/actualizar""")
)
                      

// @LINE:79
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.editar(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """recepciones/editar""")
)
                      

// @LINE:87
def modalCargarRemitosMasivos(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.modalCargarRemitosMasivos(id), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "modalCargarRemitosMasivos", Seq(classOf[Long]), "POST", """""", _prefix + """recepciones/modalCargarRemitosMasivos""")
)
                      

// @LINE:74
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.index(), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "index", Seq(), "GET", """""", _prefix + """recepciones/index""")
)
                      

// @LINE:85
def modalBuscarRecepcionesDeOrdenes(idOrdenProvision:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesController.modalBuscarRecepcionesDeOrdenes(idOrdenProvision), HandlerDef(this, "controllers.patrimonio.RecepcionesController", "modalBuscarRecepcionesDeOrdenes", Seq(classOf[Long]), "GET", """""", _prefix + """recepciones/modalBuscarRecepcionesDeOrdenes""")
)
                      
    
}
                          

// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
class ReverseActasRecepcionAccionesController {
    

// @LINE:166
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionAccionesController.crear(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "crear", Seq(), "GET", """""", _prefix + """acciones/actasRecepcion/modal-crear""")
)
                      

// @LINE:170
def asignar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionAccionesController.asignar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "asignar", Seq(), "POST", """""", _prefix + """acciones/actasRecepcion/asignar""")
)
                      

// @LINE:169
def modalAsignar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionAccionesController.modalAsignar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "modalAsignar", Seq(), "GET", """""", _prefix + """acciones/actasRecepcion/modal-asignar""")
)
                      

// @LINE:167
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionAccionesController.guardar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "guardar", Seq(), "POST", """""", _prefix + """acciones/actasRecepcion/modal-guardar""")
)
                      

// @LINE:168
def revocar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionAccionesController.revocar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionAccionesController", "revocar", Seq(), "POST", """""", _prefix + """acciones/actasRecepcion/revocar""")
)
                      
    
}
                          

// @LINE:153
class ReverseActasRecepcionLineasController {
    

// @LINE:153
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionLineasController.index(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionLineasController", "index", Seq(), "GET", """""", _prefix + """actasRecepcionLineas/index""")
)
                      
    
}
                          

// @LINE:1
class ReverseIndexController {
    

// @LINE:1
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.IndexController.index(), HandlerDef(this, "controllers.patrimonio.IndexController", "index", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          

// @LINE:211
// @LINE:210
// @LINE:209
// @LINE:208
// @LINE:207
// @LINE:206
class ReverseActaRecepcionLineaAjusteController {
    

// @LINE:206
def index(acta_id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActaRecepcionLineaAjusteController.index(acta_id, editable), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """acta-linea-ajuste/index""")
)
                      

// @LINE:211
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActaRecepcionLineaAjusteController.eliminar(id), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """acta-linea-ajuste/eliminar""")
)
                      

// @LINE:209
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActaRecepcionLineaAjusteController.guardar(), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "guardar", Seq(), "POST", """""", _prefix + """acta-linea-ajuste/guardar""")
)
                      

// @LINE:210
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActaRecepcionLineaAjusteController.actualizar(), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "actualizar", Seq(), "POST", """""", _prefix + """acta-linea-ajuste/actualizar""")
)
                      

// @LINE:208
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActaRecepcionLineaAjusteController.editar(id), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """acta-linea-ajuste/editar""")
)
                      

// @LINE:207
def crear(actaId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActaRecepcionLineaAjusteController.crear(actaId), HandlerDef(this, "controllers.patrimonio.ActaRecepcionLineaAjusteController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """acta-linea-ajuste/crear""")
)
                      
    
}
                          

// @LINE:83
// @LINE:82
class ReverseRecepcionesReportesController {
    

// @LINE:82
def reporteLineasRecepciones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesReportesController.reporteLineasRecepciones(), HandlerDef(this, "controllers.patrimonio.RecepcionesReportesController", "reporteLineasRecepciones", Seq(), "POST", """""", _prefix + """recepciones/reporteLineasRecepciones""")
)
                      

// @LINE:83
def reporteDatosRecepciones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RecepcionesReportesController.reporteDatosRecepciones(), HandlerDef(this, "controllers.patrimonio.RecepcionesReportesController", "reporteDatosRecepciones", Seq(), "POST", """""", _prefix + """recepciones/reporteDatosRecepciones""")
)
                      
    
}
                          

// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseAnulacionRecepcionProductosController {
    

// @LINE:38
def crear(linea_orden_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.crear(linea_orden_id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "crear", Seq(classOf[Long]), "GET", """""", _prefix + """anulacion-productos/crear""")
)
                      

// @LINE:42
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.actualizar(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """anulacion-productos/actualizar""")
)
                      

// @LINE:45
def anularConCliente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.anularConCliente(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "anularConCliente", Seq(), "GET", """""", _prefix + """anulacion-productos/anularConCliente""")
)
                      

// @LINE:37
def verLineasNoCertificadas(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.verLineasNoCertificadas(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "verLineasNoCertificadas", Seq(classOf[Long]), "GET", """""", _prefix + """anulacion-productos/verLineasNoCertificadas""")
)
                      

// @LINE:44
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.get(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """anulacion-productos/get""")
)
                      

// @LINE:41
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.eliminar(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """anulacion-productos/eliminar""")
)
                      

// @LINE:49
def tienePacientes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.tienePacientes(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "tienePacientes", Seq(), "GET", """""", _prefix + """anulacion-productos/tienePacientes""")
)
                      

// @LINE:47
def controlesAnularConCliente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.controlesAnularConCliente(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "controlesAnularConCliente", Seq(), "POST", """""", _prefix + """anulacion-productos/controlesAnularConCliente""")
)
                      

// @LINE:43
def modalProductosEnOrden(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.modalProductosEnOrden(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "modalProductosEnOrden", Seq(classOf[Long]), "GET", """""", _prefix + """anulacion-productos/modalBuscar""")
)
                      

// @LINE:39
def guardar(linea_orden_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.guardar(linea_orden_id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "guardar", Seq(classOf[Long]), "POST", """""", _prefix + """anulacion-productos/guardar""")
)
                      

// @LINE:48
def anular(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.anular(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "anular", Seq(), "POST", """""", _prefix + """anulacion-productos/anular""")
)
                      

// @LINE:36
def verLineas(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.verLineas(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "verLineas", Seq(classOf[Long]), "GET", """""", _prefix + """anulacion-productos/ver-lineas""")
)
                      

// @LINE:40
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.editar(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """anulacion-productos/editar""")
)
                      

// @LINE:46
def modalAnularConClientes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.modalAnularConClientes(), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "modalAnularConClientes", Seq(), "GET", """""", _prefix + """anulacion-productos/modalAnularConClientes""")
)
                      

// @LINE:35
def productosEnOrden(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.AnulacionRecepcionProductosController.productosEnOrden(id), HandlerDef(this, "controllers.patrimonio.AnulacionRecepcionProductosController", "productosEnOrden", Seq(classOf[Long]), "GET", """""", _prefix + """anulacion-productos/productosEnOrden""")
)
                      
    
}
                          

// @LINE:204
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:154
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
class ReverseActasRecepcionController {
    

// @LINE:157
def cambiarEstado(idActa:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.cambiarEstado(idActa, idEstado), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """actasRecepcion/cambiarEstado""")
)
                      

// @LINE:149
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.crear(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "crear", Seq(), "GET", """""", _prefix + """actasRecepcion/crear""")
)
                      

// @LINE:151
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.ver(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/ver""")
)
                      

// @LINE:154
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.eliminar(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/eliminar""")
)
                      

// @LINE:204
def getPacientes(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.getPacientes(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "getPacientes", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/getPacientes""")
)
                      

// @LINE:147
def indexAjax(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.indexAjax(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "indexAjax", Seq(), "GET", """""", _prefix + """actasRecepcion/indexAjax""")
)
                      

// @LINE:150
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.guardar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "guardar", Seq(), "POST", """""", _prefix + """actasRecepcion/guardar""")
)
                      

// @LINE:156
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.actualizar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "actualizar", Seq(), "POST", """""", _prefix + """actasRecepcion/actualizar""")
)
                      

// @LINE:152
def verModal(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.verModal(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "verModal", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/verModal""")
)
                      

// @LINE:155
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.editar(id), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """actasRecepcion/editar""")
)
                      

// @LINE:148
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionController.index(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionController", "index", Seq(), "GET", """""", _prefix + """actasRecepcion/index""")
)
                      
    
}
                          

// @LINE:130
// @LINE:129
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
class ReverseRemitosController {
    

// @LINE:121
def crear(recepcion_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.crear(recepcion_id), HandlerDef(this, "controllers.patrimonio.RemitosController", "crear", Seq(classOf[Long]), "GET", """""", _prefix + """remitos/crear""")
)
                      

// @LINE:124
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.actualizar(id), HandlerDef(this, "controllers.patrimonio.RemitosController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """remitos/actualizar""")
)
                      

// @LINE:126
def reporteDatosRemitos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.reporteDatosRemitos(), HandlerDef(this, "controllers.patrimonio.RemitosController", "reporteDatosRemitos", Seq(), "POST", """""", _prefix + """remitos/reporteDatosRemitos""")
)
                      

// @LINE:118
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.ver(id), HandlerDef(this, "controllers.patrimonio.RemitosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """remitos/ver""")
)
                      

// @LINE:125
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.eliminar(id), HandlerDef(this, "controllers.patrimonio.RemitosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """remitos/eliminar""")
)
                      

// @LINE:120
def indexAjax(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.indexAjax(), HandlerDef(this, "controllers.patrimonio.RemitosController", "indexAjax", Seq(), "GET", """""", _prefix + """remitos/indexAjax""")
)
                      

// @LINE:122
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.guardar(), HandlerDef(this, "controllers.patrimonio.RemitosController", "guardar", Seq(), "POST", """""", _prefix + """remitos/guardar""")
)
                      

// @LINE:130
def cambiarRecepcion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.cambiarRecepcion(), HandlerDef(this, "controllers.patrimonio.RemitosController", "cambiarRecepcion", Seq(), "POST", """""", _prefix + """remitos/cambiarRecepcion""")
)
                      

// @LINE:129
def modalCambiarRecepcion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.modalCambiarRecepcion(), HandlerDef(this, "controllers.patrimonio.RemitosController", "modalCambiarRecepcion", Seq(), "POST", """""", _prefix + """remitos/modalCambiarRecepcion""")
)
                      

// @LINE:127
def reporteDatosRemitosGeneral(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.reporteDatosRemitosGeneral(), HandlerDef(this, "controllers.patrimonio.RemitosController", "reporteDatosRemitosGeneral", Seq(), "POST", """""", _prefix + """remitos/reporteDatosRemitosGeneral""")
)
                      

// @LINE:123
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.editar(id), HandlerDef(this, "controllers.patrimonio.RemitosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """remitos/editar""")
)
                      

// @LINE:119
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.RemitosController.index(), HandlerDef(this, "controllers.patrimonio.RemitosController", "index", Seq(), "GET", """""", _prefix + """remitos/index""")
)
                      
    
}
                          

// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
class ReverseActasRecepcionCertificacionesAccionesController {
    

// @LINE:172
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.crear(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "crear", Seq(), "GET", """""", _prefix + """acciones/actasRecepcionCertificaciones/modal-crear""")
)
                      

// @LINE:176
def asignar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.asignar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "asignar", Seq(), "POST", """""", _prefix + """acciones/actasRecepcionCertificaciones/asignar""")
)
                      

// @LINE:175
def modalAsignar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.modalAsignar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "modalAsignar", Seq(), "GET", """""", _prefix + """acciones/actasRecepcionCertificaciones/modal-asignar""")
)
                      

// @LINE:173
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.guardar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "guardar", Seq(), "POST", """""", _prefix + """acciones/actasRecepcionCertificaciones/modal-guardar""")
)
                      

// @LINE:174
def revocar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.ActasRecepcionCertificacionesAccionesController.revocar(), HandlerDef(this, "controllers.patrimonio.ActasRecepcionCertificacionesAccionesController", "revocar", Seq(), "POST", """""", _prefix + """acciones/actasRecepcionCertificaciones/revocar""")
)
                      
    
}
                          

// @LINE:63
class ReverseCertificacionesReportesController {
    

// @LINE:63
def reporteCertificacion(idCertificacion:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.CertificacionesReportesController.reporteCertificacion(idCertificacion), HandlerDef(this, "controllers.patrimonio.CertificacionesReportesController", "reporteCertificacion", Seq(classOf[Long]), "GET", """""", _prefix + """certificaciones/reportes/certificacion""")
)
                      
    
}
                          

// @LINE:108
// @LINE:107
class ReversePrefijosAccionesController {
    

// @LINE:108
def modificar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.PrefijosAccionesController.modificar(), HandlerDef(this, "controllers.patrimonio.PrefijosAccionesController", "modificar", Seq(), "GET", """""", _prefix + """prefijo/acciones/modificar""")
)
                      

// @LINE:107
def modificarModal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.patrimonio.PrefijosAccionesController.modificarModal(), HandlerDef(this, "controllers.patrimonio.PrefijosAccionesController", "modificarModal", Seq(), "GET", """""", _prefix + """prefijo/acciones/modificar-modal""")
)
                      
    
}
                          
}
        
    