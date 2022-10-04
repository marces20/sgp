// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routeContabilidad.routes
// @HASH:fa3440083ee545870845839a5d2a998efa9fdd7f
// @DATE:Tue Oct 04 11:43:26 ART 2022

import routeContabilidad.Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:373
// @LINE:372
// @LINE:371
// @LINE:370
// @LINE:369
// @LINE:368
// @LINE:367
// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:361
// @LINE:360
// @LINE:358
// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
// @LINE:348
// @LINE:347
// @LINE:345
// @LINE:344
// @LINE:343
// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
// @LINE:336
// @LINE:333
// @LINE:332
// @LINE:330
// @LINE:329
// @LINE:328
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
// @LINE:320
// @LINE:319
// @LINE:318
// @LINE:317
// @LINE:316
// @LINE:311
// @LINE:310
// @LINE:308
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
// @LINE:301
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:286
// @LINE:285
// @LINE:284
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
// @LINE:268
// @LINE:267
// @LINE:266
// @LINE:265
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:254
// @LINE:252
// @LINE:251
// @LINE:250
// @LINE:249
// @LINE:248
// @LINE:247
// @LINE:246
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
// @LINE:234
// @LINE:233
// @LINE:232
// @LINE:231
// @LINE:230
// @LINE:229
// @LINE:228
// @LINE:227
// @LINE:225
// @LINE:224
// @LINE:223
// @LINE:222
// @LINE:221
// @LINE:220
// @LINE:219
// @LINE:218
// @LINE:217
// @LINE:215
// @LINE:211
// @LINE:210
// @LINE:209
// @LINE:207
// @LINE:206
// @LINE:205
// @LINE:204
// @LINE:203
// @LINE:202
// @LINE:200
// @LINE:199
// @LINE:197
// @LINE:196
// @LINE:195
// @LINE:194
// @LINE:193
// @LINE:191
// @LINE:190
// @LINE:188
// @LINE:187
// @LINE:186
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:100
// @LINE:98
// @LINE:96
// @LINE:95
// @LINE:93
// @LINE:92
// @LINE:90
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.contabilidad {

// @LINE:100
// @LINE:98
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:76
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseFacturasController {
    

// @LINE:23
def modalSeleccionActaRelacionada(facturaId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/seleccionar-actas-asociada" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("facturaId", facturaId)))))
}
                                                

// @LINE:22
def asignarActasAsociada(facturaId:Long, actaId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/asignar-actas-asociada" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("facturaId", facturaId)), Some(implicitly[QueryStringBindable[Long]].unbind("actaId", actaId)))))
}
                                                

// @LINE:78
def cambiarEstado(idFactura:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idFactura", idFactura)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:19
def actasAsociadas(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/actas-asociada" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:79
def cambiarEstadoPrecargado(idFactura:Long, idEstado:Long, precarga:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/cambiarEstadoPrecarga" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idFactura", idFactura)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)), if(precarga == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("precarga", precarga)))))
}
                                                

// @LINE:81
def cambiarEstadoAprobado(idFactura:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/cambiarEstadoAprobado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idFactura", idFactura)))))
}
                                                

// @LINE:12
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/crear")
}
                                                

// @LINE:16
def eliminarFacturaDato(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/eliminarFacturaDato" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:28
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:100
def vistaFacturasCargadas(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/vistaFacturasCargadas")
}
                                                

// @LINE:76
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:18
def crearFacturaParcial(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/crearFacturaParcial" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:15
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:13
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/guardar")
}
                                                

// @LINE:30
def get(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:98
def getInfoRetenciones(id:Long = 0, fci:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/getInfoRetenciones" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(fci == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("fci", fci)))))
}
                                                

// @LINE:29
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalBuscar")
}
                                                

// @LINE:20
def eliminarActaAsociada(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/eliminar-actas-asociada" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:14
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:11
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor")
}
                                                

// @LINE:17
def duplicar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/duplicar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:367
// @LINE:268
// @LINE:267
// @LINE:266
// @LINE:265
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
class ReverseBancosController {
    

// @LINE:266
def actualizarBanco(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "banco/actualizar")
}
                                                

// @LINE:268
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "banco/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:262
def crearBanco(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "banco/crear")
}
                                                

// @LINE:367
def suggestBanco(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestBanco/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:265
def eliminarBanco(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "banco/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:267
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "banco/modalBuscar")
}
                                                

// @LINE:264
def editarBanco(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "banco/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:263
def guardarBanco(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "banco/guardar")
}
                                                

// @LINE:261
def indexBanco(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "banco")
}
                                                
    
}
                          

// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:215
class ReverseSucursalBancosController {
    

// @LINE:295
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sucursalBanco/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:293
def actualizarSucursalBanco(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "sucursalBanco/actualizar")
}
                                                

// @LINE:288
def indexSucursalBanco(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sucursalBanco")
}
                                                

// @LINE:289
def crearSucursalBanco(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sucursalBanco/crear")
}
                                                

// @LINE:291
def editarSucursalBanco(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sucursalBanco/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:292
def eliminarSucursalBanco(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sucursalBanco/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:294
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sucursalBanco/modalBuscar")
}
                                                

// @LINE:215
def listOptions(bancoId:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sucursalBanco/listOptions" + queryString(List(if(bancoId == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("bancoId", bancoId)))))
}
                                                

// @LINE:290
def guardarSucursalBanco(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "sucursalBanco/guardar")
}
                                                
    
}
                          

// @LINE:320
// @LINE:319
// @LINE:318
// @LINE:317
// @LINE:316
class ReverseOrdenesPagosCircuitosController {
    

// @LINE:318
def cambiarEstado(idOc:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuitoCambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idOc", idOc)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:317
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:320
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/actualizar")
}
                                                

// @LINE:319
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:316
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuito")
}
                                                
    
}
                          

// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
class ReverseMisPagosController {
    

// @LINE:238
def actualizar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mis-pagos/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:237
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mis-pagos/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:235
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mis-pagos/index")
}
                                                

// @LINE:236
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mis-pagos/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:211
// @LINE:210
// @LINE:209
class ReverseConciliacionPagosController {
    

// @LINE:211
def analisisConciliacionCheques(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "conciliacionCheques/anilisis-conciliacion-cheques")
}
                                                

// @LINE:210
def conciliarCheques(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "conciliacionCheques/conciliar-cheques")
}
                                                

// @LINE:209
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "conciliacionCheques")
}
                                                
    
}
                          

// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
class ReverseFacturasLineasImpuestosController {
    

// @LINE:116
def getSecuenciaRetencionSellos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea-impuesto/getSecuenciaRetencionSellos")
}
                                                

// @LINE:110
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea-impuesto/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:115
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea-impuesto/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:113
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea-impuesto/guardar")
}
                                                

// @LINE:119
def getSecuenciaIva(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea-impuesto/getSecuenciaIva")
}
                                                

// @LINE:118
def getSecuenciaIIBB(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea-impuesto/getSecuenciaIIBB")
}
                                                

// @LINE:114
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea-impuesto/actualizar")
}
                                                

// @LINE:121
def precalcular(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea-impuesto/precalcular" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:120
def getSecuenciaRetencionMunicipal(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea-impuesto/getSecuenciaRetencionMunicipal")
}
                                                

// @LINE:112
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea-impuesto/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:111
def crear(facturaId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea-impuesto/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("facturaId", facturaId)))))
}
                                                

// @LINE:117
def getSecuenciaGanancias(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea-impuesto/getSecuenciaGanancias")
}
                                                
    
}
                          

// @LINE:368
// @LINE:308
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
// @LINE:301
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
class ReverseCuentaBancariasController {
    

// @LINE:298
def crearCuentaBancaria(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentaBancaria/crear")
}
                                                

// @LINE:297
def indexCuentaBancaria(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentaBancaria")
}
                                                

// @LINE:306
def cambiarEstado(idCuenta:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentaBancaria/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idCuenta", idCuenta)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:302
def actualizarCuentaBancaria(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cuentaBancaria/actualizar")
}
                                                

// @LINE:304
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentaBancaria/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:300
def editarCuentaBancaria(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentaBancaria/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:305
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentaBancaria/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:299
def guardarCuentaBancaria(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cuentaBancaria/guardar")
}
                                                

// @LINE:303
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentaBancaria/modalBuscar")
}
                                                

// @LINE:368
def suggestCuentaBancaria(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestCuentaBancaria/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:308
def reporteDatosGenerales(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cuentaBancaria/reporteDatosGenerales")
}
                                                

// @LINE:301
def eliminarCuentaBancaria(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentaBancaria/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:254
// @LINE:252
// @LINE:251
// @LINE:250
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:197
// @LINE:196
class ReversePagosReportesController {
    

// @LINE:254
def informeRetencionSuss(regimen:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagos/informeRetencionSuss" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("regimen", regimen)))))
}
                                                

// @LINE:258
def informeRetencionGcia4245(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagos/informeRetencionGcia4245")
}
                                                

// @LINE:197
def descargarInformeMensualRentas(url:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reportesPagoProveedor/descargarInformeMensualRentas" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("url", url)))))
}
                                                

// @LINE:243
def informeImpuestoMunicipal(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informeImpuestoMunicipal")
}
                                                

// @LINE:252
def descargarLotesPago(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reporteLotePago" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:242
def descargarLotes(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "reporteLote")
}
                                                

// @LINE:241
def reporteCheque(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reporte/cheque" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:251
def informeMensualImpuestos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagos/informeMensualImpuestos")
}
                                                

// @LINE:196
def modalInformeMensualRentas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "reportesPagoProveedor/modalInformeMensualRentas")
}
                                                

// @LINE:256
def informeRetDgrIibb(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagos/informeRetDgrIibb")
}
                                                

// @LINE:250
def modalInformeMensualImpuestos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagos/modalInformeMensualImpuestos")
}
                                                

// @LINE:257
def informeRetDgrIibb331(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagos/informeRetDgrIibb331")
}
                                                

// @LINE:259
def informeRetencionIva(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagos/informeRetencionIva")
}
                                                

// @LINE:255
def informeRetDgrSellos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagos/informeRetencionDgrSellos")
}
                                                

// @LINE:244
def informeProfe(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informeprofe")
}
                                                
    
}
                          

// @LINE:373
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
class ReverseEjerciciosController {
    

// @LINE:275
def actualizarEjercicio(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ejercicio/actualizar")
}
                                                

// @LINE:373
def suggestEjercicio(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestEjercicio/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:272
def guardarEjercicio(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ejercicio/guardar")
}
                                                

// @LINE:270
def indexEjercicio(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ejercicio")
}
                                                

// @LINE:277
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ejercicio/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:276
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ejercicio/modalBuscar")
}
                                                

// @LINE:271
def crearEjercicio(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ejercicio/crear")
}
                                                

// @LINE:273
def editarEjercicio(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ejercicio/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:274
def eliminarEjercicio(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ejercicio/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
class ReverseFacturasLineasReintegrosController {
    

// @LINE:123
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea-reintegro/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:128
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea-reintegro/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:126
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea-reintegro/guardar")
}
                                                

// @LINE:127
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea-reintegro/actualizar")
}
                                                

// @LINE:125
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea-reintegro/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:124
def crear(facturaId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea-reintegro/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("facturaId", facturaId)))))
}
                                                
    
}
                          

// @LINE:372
// @LINE:234
// @LINE:233
// @LINE:232
// @LINE:231
// @LINE:230
// @LINE:229
// @LINE:228
// @LINE:227
class ReverseCuentasController {
    

// @LINE:228
def crear(parent_id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas/crear" + queryString(List(if(parent_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("parent_id", parent_id)))))
}
                                                

// @LINE:372
def suggestCuenta(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestCuenta/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:234
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:232
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:227
def index(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:231
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cuentas/actualizar")
}
                                                

// @LINE:233
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas/modalBuscar")
}
                                                

// @LINE:229
def guardar(parent_id:Long = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cuentas/guardar" + queryString(List(if(parent_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("parent_id", parent_id)))))
}
                                                

// @LINE:230
def editar(parent_id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas/editar" + queryString(List(if(parent_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("parent_id", parent_id)))))
}
                                                
    
}
                          

// @LINE:333
// @LINE:332
// @LINE:330
// @LINE:329
// @LINE:328
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
class ReverseOrdenesPagosCircuitosAccionesController {
    

// @LINE:324
def pasarContabilidadMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/pasarContabilidadMasivo")
}
                                                

// @LINE:321
def modalPasarBorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/modalPasarBorrador")
}
                                                

// @LINE:333
def cargarExpedienteFisico(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/cargarExpedienteFisico")
}
                                                

// @LINE:323
def modalPasarContabilidad(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/modalPasarContabilidad")
}
                                                

// @LINE:327
def modalPasarRendido(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/modalPasarRendido")
}
                                                

// @LINE:330
def pasarCanceladoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/pasarCanceladoMasivo")
}
                                                

// @LINE:322
def pasarBorradorMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/pasarBorradorMasivo")
}
                                                

// @LINE:325
def modalPasarRendiciones(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/modalPasarRendiciones")
}
                                                

// @LINE:329
def modalPasarCancelado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/modalPasarCancelado")
}
                                                

// @LINE:326
def pasarRendicionesMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/pasarRendicionesMasivo")
}
                                                

// @LINE:328
def pasarRendidoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/pasarRendidoMasivo")
}
                                                

// @LINE:332
def modalCargarExpedienteFisico(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuito/modalCargarExpedienteFisico")
}
                                                
    
}
                          

// @LINE:371
// @LINE:225
// @LINE:224
// @LINE:223
// @LINE:222
// @LINE:221
// @LINE:220
// @LINE:219
// @LINE:218
// @LINE:217
class ReverseCuentasAnaliticasController {
    

// @LINE:225
def modalBuscarCuentasAsociadas(solicitud_id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas-analiticas/modalCuentasAsociadasSolicitud" + queryString(List(if(solicitud_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("solicitud_id", solicitud_id)))))
}
                                                

// @LINE:218
def crear(parent_id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas-analiticas/crear" + queryString(List(if(parent_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("parent_id", parent_id)))))
}
                                                

// @LINE:222
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas-analiticas/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:217
def index(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas-analiticas" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:224
def get(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas-analiticas/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:221
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cuentas-analiticas/actualizar")
}
                                                

// @LINE:223
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas-analiticas/modalBuscar")
}
                                                

// @LINE:219
def guardar(parent_id:Long = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cuentas-analiticas/guardar" + queryString(List(if(parent_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("parent_id", parent_id)))))
}
                                                

// @LINE:371
def suggestCuentaAnalitica(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestCuentaAnalitica/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:220
def editar(parent_id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentas-analiticas/editar" + queryString(List(if(parent_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("parent_id", parent_id)))))
}
                                                
    
}
                          

// @LINE:311
// @LINE:310
class ReverseCuentasPropiasController {
    

// @LINE:310
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentasPropias/modalBuscar")
}
                                                

// @LINE:311
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cuentasPropias/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:336
class ReverseOrdenesPagosCircuitosLineasController {
    

// @LINE:336
def index(orden_pago_circuito_id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "OrdenPagoCircuitoLinea" + queryString(List(if(orden_pago_circuito_id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("orden_pago_circuito_id", orden_pago_circuito_id)))))
}
                                                
    
}
                          

// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:361
// @LINE:360
// @LINE:358
// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
class ReverseBalanceController {
    

// @LINE:360
def modalCambiarCuenta(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "Balance/modalCambiarCuenta")
}
                                                

// @LINE:357
def modalPasarControlado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "Balance/modalPasarControlado")
}
                                                

// @LINE:364
def archivoBejermanPagos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "Balance/archivoBejermanPagos")
}
                                                

// @LINE:351
def general(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "Balance/general")
}
                                                

// @LINE:355
def modalPasarBorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "Balance/modalPasarBorrador")
}
                                                

// @LINE:352
def modalAgregarMovimientoBalance(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "Balance/modalAgregarMovimientoBalance")
}
                                                

// @LINE:358
def pasarControladoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "Balance/pasarControladoMasivo")
}
                                                

// @LINE:356
def pasarBorradorMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "Balance/pasarBorradorMasivo")
}
                                                

// @LINE:365
def archivoExcel(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "Balance/archivoExcel")
}
                                                

// @LINE:363
def archivoBejerman(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "Balance/archivoBejerman")
}
                                                

// @LINE:353
def agregarMovimientoBalance(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "Balance/agregarMovimientoBalance")
}
                                                

// @LINE:350
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "Balance")
}
                                                

// @LINE:361
def cambiarCuentaMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "Balance/cambiarCuentaMasivo")
}
                                                
    
}
                          

// @LINE:207
// @LINE:206
// @LINE:205
// @LINE:204
// @LINE:203
// @LINE:202
class ReversePagosLineasController {
    

// @LINE:202
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:207
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:205
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pago-linea/guardar")
}
                                                

// @LINE:206
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pago-linea/actualizar")
}
                                                

// @LINE:204
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:203
def crear(pagoId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("pagoId", pagoId)))))
}
                                                
    
}
                          

// @LINE:96
// @LINE:95
// @LINE:93
// @LINE:92
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:32
// @LINE:31
class ReverseFacturasAccionesController {
    

// @LINE:68
def modalCargarOrdenPago(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalCargarOrdenPago")
}
                                                

// @LINE:44
def modalCargar349(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/acciones/modalCargar349" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:73
def cargarFecha322Masivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/cargarFecha322Masivo")
}
                                                

// @LINE:62
def modalPasarBorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalPasarBorrador")
}
                                                

// @LINE:32
def descargar322(url:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/acciones/descargar322" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("url", url)))))
}
                                                

// @LINE:85
def modalDetalleFacturacionPorEstadoPorPeriodo(nombrePeriodo:String, estado:Integer, proveedorId:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/acciones/modalDetalleFacturacionPorEstadoPorPeriodo" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("nombrePeriodo", nombrePeriodo)), Some(implicitly[QueryStringBindable[Integer]].unbind("estado", estado)), Some(implicitly[QueryStringBindable[Integer]].unbind("proveedorId", proveedorId)))))
}
                                                

// @LINE:72
def modalCargarFecha322(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalCargarFecha322")
}
                                                

// @LINE:58
def modalPasarEnPreCurso(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalPasarEnPreCurso")
}
                                                

// @LINE:57
def pasarEnPreCursoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/pasarEnCursoMasivo")
}
                                                

// @LINE:42
def importarListaComisiones(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/acciones/importarListaComisiones")
}
                                                

// @LINE:67
def pasarPreAprobadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/pasarPreAprobadoMasivo")
}
                                                

// @LINE:87
def marcadoresMasivos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/marcadoresMasivos")
}
                                                

// @LINE:92
def modalModificarNumeroFactura(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalModificarNumeroFactura" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:74
def modalRechazarFactura(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalRechazarFactura")
}
                                                

// @LINE:71
def cargarFechaOrdenPagoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/cargarFechaOrdenPagoMasivo")
}
                                                

// @LINE:60
def modalPasarAprobado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalPasarAprobado")
}
                                                

// @LINE:70
def modalCargarFechaOrdenPago(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalCargarFechaOrdenPago")
}
                                                

// @LINE:69
def cargarOrdenPagoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/cargarOrdenPagoMasivo")
}
                                                

// @LINE:96
def cargarNumeroFacturaParcial(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/cargarNumeroFacturaParcial")
}
                                                

// @LINE:93
def modificarNumeroFactura(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/modificarNumeroFactura")
}
                                                

// @LINE:75
def rechazar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/rechazar")
}
                                                

// @LINE:95
def modalCargarNumeroFacturaParcial(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalCargarNumeroFacturaParcial")
}
                                                

// @LINE:31
def solicitud322(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/acciones/solicitud322")
}
                                                

// @LINE:65
def pasarCanceladoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/pasarCanceladoMasivo")
}
                                                

// @LINE:63
def pasarBorradorMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/pasarBorradorMasivo")
}
                                                

// @LINE:84
def modalDetalleFacturacion(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalDetalleFacturacion" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:64
def modalPasarCancelado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalPasarCancelado")
}
                                                

// @LINE:61
def pasarAprobadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/pasarAprobadoMasivo")
}
                                                

// @LINE:56
def modalPasarEnCurso(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalPasarEnCurso")
}
                                                

// @LINE:86
def modalMarcadoresMasivos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalMarcadoresMasivos")
}
                                                

// @LINE:59
def pasarEnCursoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/pasarEnPreCursoMasivo")
}
                                                

// @LINE:66
def modalPasarPreAprobado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/modalPasarPreAprobado")
}
                                                

// @LINE:41
def modalImportarListaComisiones(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/acciones/modalImportarListaComisiones")
}
                                                

// @LINE:45
def cargar349(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/acciones/cargar349")
}
                                                
    
}
                          

// @LINE:348
// @LINE:347
// @LINE:345
// @LINE:344
// @LINE:343
// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
class ReverseBalanceCuentaPropiaController {
    

// @LINE:339
def archivoIndex(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "BalanceCuentaPropia/archivoIndex")
}
                                                

// @LINE:348
def getExpedientes(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "BalanceCuentaPropia/get-expedientes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:345
def listaPagos(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "BalanceCuentaPropia/listaPagos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:341
def agregarMovimientoBalanceCuentaPropia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "BalanceCuentaPropia/agregarMovimientoBalanceCuentaPropia")
}
                                                

// @LINE:344
def transferenciaEntreCuentasPropias(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "BalanceCuentaPropia/transferenciaEntreCuentasPropias")
}
                                                

// @LINE:340
def modalAgregarMovimientoBalanceCuentaPropia(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "BalanceCuentaPropia/modalAgregarMovimientoBalanceCuentaPropia")
}
                                                

// @LINE:343
def modalTransferenciaEntreCuentasPropias(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "BalanceCuentaPropia/modalTransferenciaEntreCuentasPropias")
}
                                                

// @LINE:338
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "BalanceCuentaPropia")
}
                                                

// @LINE:347
def getOrdenes(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "BalanceCuentaPropia/get-ordenes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:90
// @LINE:88
// @LINE:83
// @LINE:82
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:27
class ReverseFacturasReportesController {
    

// @LINE:36
def reporteComprobanteRetencionMunicipal(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComprobanteRetencionMunicipal")
}
                                                

// @LINE:90
def reporteFacturasCargadas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reporteFacturasCargadas")
}
                                                

// @LINE:27
def viatico(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/viatico")
}
                                                

// @LINE:53
def modalInformeSellos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/modalInformeMensualSellos")
}
                                                

// @LINE:38
def reporteComprobanteRetencionIva(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComprobanteRetencionIva")
}
                                                

// @LINE:49
def reporteComprobanteRetencioniibb370(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComprobanteRetencionIibb370")
}
                                                

// @LINE:54
def informeSellos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/informeMensualSellos")
}
                                                

// @LINE:88
def reporteLineasFacturas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reporteLineasFacturas")
}
                                                

// @LINE:51
def reporteComprobanteRetencionLimpieza(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComprobanteRetencionLimpieza")
}
                                                

// @LINE:52
def reporteComprobanteRetencionReggral(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComprobanteRetencionReggral")
}
                                                

// @LINE:39
def reporteComisiones(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComisiones")
}
                                                

// @LINE:83
def reporteControlFacturasAFIP(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reporteControlFacturasAFIP")
}
                                                

// @LINE:48
def reporteComprobanteRetencioniibb(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComprobanteRetencionIibb")
}
                                                

// @LINE:34
def ordenDePago(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/OrdenDePago")
}
                                                

// @LINE:47
def reporteRendicionSellos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteRendicionSellos")
}
                                                

// @LINE:82
def reporteControlFacturas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reporteControlFactura")
}
                                                

// @LINE:50
def reporteComprobanteRetencionSeguridad(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComprobanteRetencionSeguridad")
}
                                                

// @LINE:33
def OPCservicios(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/OPCservicios")
}
                                                

// @LINE:35
def reporteComprobanteRetencionSellos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComprobanteRetencionSellos")
}
                                                

// @LINE:37
def reporteComprobanteRetencionGcia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "facturaProveedor/reportes/reporteComprobanteRetencionGcia")
}
                                                
    
}
                          

// @LINE:1
class ReverseIndexController {
    

// @LINE:1
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
class ReversePagosController {
    

// @LINE:138
def cambiarEstado(idPago:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagoProveedor/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idPago", idPago)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:139
def cambiarEstadoTransferenciaConciliado(idPago:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagoProveedor/cambiarEstadoTransferenciaConciliado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idPago", idPago)))))
}
                                                

// @LINE:133
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagoProveedor/crear")
}
                                                

// @LINE:137
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagoProveedor/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:132
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagoProveedor/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:136
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagoProveedor/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:134
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagoProveedor/guardar")
}
                                                

// @LINE:135
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagoProveedor/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:130
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagoProveedor")
}
                                                

// @LINE:131
def duplicar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagoProveedor/duplicar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:370
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
class ReverseOrdenesPagosController {
    

// @LINE:4
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesPagos/crear")
}
                                                

// @LINE:9
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesPagos/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:3
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesPagos/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:5
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenesPagos/guardar")
}
                                                

// @LINE:7
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenesPagos/actualizar")
}
                                                

// @LINE:8
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesPagos/modalBuscar")
}
                                                

// @LINE:370
def suggestOrdenPago(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestOrdenPago/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:6
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesPagos/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:2
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenesPagos")
}
                                                
    
}
                          

// @LINE:249
// @LINE:248
// @LINE:247
// @LINE:246
// @LINE:200
// @LINE:199
// @LINE:195
// @LINE:194
// @LINE:193
// @LINE:191
// @LINE:190
// @LINE:188
// @LINE:187
// @LINE:186
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
class ReversePagosAccionesController {
    

// @LINE:144
def modalModificarReferencia(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarReferencia")
}
                                                

// @LINE:183
def modalModificarCuentaPropia(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarCuentaPropia")
}
                                                

// @LINE:195
def descargarRendiciones(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/descargarRendiciones" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:184
def modificarCuentaPropia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarCuentaPropia")
}
                                                

// @LINE:165
def modalPagarProveedoresExternos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPagarProveedoresExternos")
}
                                                

// @LINE:179
def modalModificarNumeroCheque(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarNumeroCheque")
}
                                                

// @LINE:248
def modalPasarBorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagos/modalPasarBorrador")
}
                                                

// @LINE:178
def pagarCheques(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/pagarCheques")
}
                                                

// @LINE:148
def pagarEmbargos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/pagarEmbargos")
}
                                                

// @LINE:171
def modificarFechaCancelacion(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarFechaCancelacion")
}
                                                

// @LINE:177
def modalPagarCheques(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPagarCheques")
}
                                                

// @LINE:180
def modificarNumeroCheque(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarNumeroCheque")
}
                                                

// @LINE:147
def modalPagarEmbargos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPagarEmbargos")
}
                                                

// @LINE:169
def modificarFechaConciliado(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarFechaConciliado")
}
                                                

// @LINE:173
def modalModificarNumeroFactura(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarNumeroFactura" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:190
def modalPasarConciliado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPasarConciliado")
}
                                                

// @LINE:200
def descargarOpgEmbargoExterno(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/descargarOPGEmbargoExterno" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:193
def descargarOpg(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/descargarOPG" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:158
def pagarProveedoresMacroMasivos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/pagarProveedoresMacroMasivos")
}
                                                

// @LINE:176
def modificarNumeroRecibo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarNumeroRecibo")
}
                                                

// @LINE:145
def modalPagarInterno(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPagarInterno")
}
                                                

// @LINE:146
def pagarInterno(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/pagarInterno")
}
                                                

// @LINE:191
def pasarConciliadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/pasarConciliadoMasivo")
}
                                                

// @LINE:159
def descargarArchivoProveedoresMacroMasivos(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/descargarArchivoProveedoresMacroMasivos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:174
def modificarNumeroFactura(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarNumeroFactura")
}
                                                

// @LINE:182
def modificarTipoPago(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarTipoPago")
}
                                                

// @LINE:247
def pasarCanceladoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagos/pasarCanceladoMasivo")
}
                                                

// @LINE:166
def pagarProveedoresExternos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPagarProveedoresExternos")
}
                                                

// @LINE:153
def modalPagarInterbankingProveedores(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPagarInterbankingProveedores")
}
                                                

// @LINE:143
def modificarReferencia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarReferencia")
}
                                                

// @LINE:249
def pasarBorradorMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pagos/pasarBorradorMasivo")
}
                                                

// @LINE:170
def modalModificarFechaConciliado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarFechaConciliado")
}
                                                

// @LINE:149
def modalPagarEmbargosExternos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPagarEmbargosExternos")
}
                                                

// @LINE:181
def modalModificarTipoPago(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarTipoPago")
}
                                                

// @LINE:188
def crearRefenciaEmbargos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/crearRefenciaEmbargos")
}
                                                

// @LINE:150
def pagarEmbargosExternos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/pagarEmbargosExternos")
}
                                                

// @LINE:246
def modalPasarCancelado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagos/modalPasarCancelado")
}
                                                

// @LINE:164
def pagarPlanta(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/pagarPlanta")
}
                                                

// @LINE:142
def modalModificarFecha(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarFecha")
}
                                                

// @LINE:186
def modificarPaguese(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarPaguese")
}
                                                

// @LINE:154
def pagarInterbankingProveedores(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/pagarInterbankingProveedores")
}
                                                

// @LINE:163
def modalPagarPlanta(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPagarPlanta")
}
                                                

// @LINE:194
def descargarBnf(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/descargarBNF" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:167
def modalDetallePago(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalDetallePago" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:160
def descargarArchivoBnfMacroMasivos(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/descargarArchivoBnfMacroMasivos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:175
def modalModificarNumeroRecibo(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarNumeroRecibo" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:157
def modalPagarProveedoresMacroMasivos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalPagarProveedoresMacroMasivos")
}
                                                

// @LINE:168
def modalDetalleDeudaPorEstadoPorPeriodo(nombrePeriodo:String, estado:Integer, proveedorId:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalDetalleDeudaPorEstadoPorPeriodo" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("nombrePeriodo", nombrePeriodo)), Some(implicitly[QueryStringBindable[Integer]].unbind("estado", estado)), Some(implicitly[QueryStringBindable[Integer]].unbind("proveedorId", proveedorId)))))
}
                                                

// @LINE:185
def modalModificarPaguese(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarPaguese")
}
                                                

// @LINE:155
def descargarArchivoInterbankingProveedores(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/descargarArchivoInterbankingProveedores" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:199
def descargarOpgEmbargo(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/descargarOPGEmbargo" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:172
def modalModificarFechaCancelacion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalModificarFechaCancelacion")
}
                                                

// @LINE:141
def modificarFecha(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modificarFecha")
}
                                                

// @LINE:187
def modalCrearRefenciaEmbargos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accionesPagoProveedor/modalCrearRefenciaEmbargos")
}
                                                
    
}
                          

// @LINE:369
// @LINE:286
// @LINE:285
// @LINE:284
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
class ReversePeriodosController {
    

// @LINE:279
def indexPeriodo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "periodo")
}
                                                

// @LINE:280
def crearPeriodo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "periodo/crear")
}
                                                

// @LINE:282
def editarPeriodo(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "periodo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:284
def actualizarPeriodo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "periodo/actualizar")
}
                                                

// @LINE:286
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "periodo/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:283
def eliminarPeriodo(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "periodo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:285
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "periodo/modalBuscar")
}
                                                

// @LINE:281
def guardarPeriodo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "periodo/guardar")
}
                                                

// @LINE:369
def suggestPeriodo(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestPeriodo/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                
    
}
                          

// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
class ReverseFacturasLineasController {
    

// @LINE:102
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:107
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:105
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea/guardar")
}
                                                

// @LINE:106
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea/actualizar")
}
                                                

// @LINE:108
def eliminarMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea/eliminar-masivo")
}
                                                

// @LINE:104
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:103
def crear(facturaId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("facturaId", facturaId)))))
}
                                                
    
}
                          
}
                  


// @LINE:373
// @LINE:372
// @LINE:371
// @LINE:370
// @LINE:369
// @LINE:368
// @LINE:367
// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:361
// @LINE:360
// @LINE:358
// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
// @LINE:348
// @LINE:347
// @LINE:345
// @LINE:344
// @LINE:343
// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
// @LINE:336
// @LINE:333
// @LINE:332
// @LINE:330
// @LINE:329
// @LINE:328
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
// @LINE:320
// @LINE:319
// @LINE:318
// @LINE:317
// @LINE:316
// @LINE:311
// @LINE:310
// @LINE:308
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
// @LINE:301
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:286
// @LINE:285
// @LINE:284
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
// @LINE:268
// @LINE:267
// @LINE:266
// @LINE:265
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:254
// @LINE:252
// @LINE:251
// @LINE:250
// @LINE:249
// @LINE:248
// @LINE:247
// @LINE:246
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
// @LINE:234
// @LINE:233
// @LINE:232
// @LINE:231
// @LINE:230
// @LINE:229
// @LINE:228
// @LINE:227
// @LINE:225
// @LINE:224
// @LINE:223
// @LINE:222
// @LINE:221
// @LINE:220
// @LINE:219
// @LINE:218
// @LINE:217
// @LINE:215
// @LINE:211
// @LINE:210
// @LINE:209
// @LINE:207
// @LINE:206
// @LINE:205
// @LINE:204
// @LINE:203
// @LINE:202
// @LINE:200
// @LINE:199
// @LINE:197
// @LINE:196
// @LINE:195
// @LINE:194
// @LINE:193
// @LINE:191
// @LINE:190
// @LINE:188
// @LINE:187
// @LINE:186
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:100
// @LINE:98
// @LINE:96
// @LINE:95
// @LINE:93
// @LINE:92
// @LINE:90
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.contabilidad.javascript {

// @LINE:100
// @LINE:98
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:76
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseFacturasController {
    

// @LINE:23
def modalSeleccionActaRelacionada : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.modalSeleccionActaRelacionada",
   """
      function(facturaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/seleccionar-actas-asociada" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("facturaId", facturaId)])})
      }
   """
)
                        

// @LINE:22
def asignarActasAsociada : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.asignarActasAsociada",
   """
      function(facturaId,actaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/asignar-actas-asociada" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("facturaId", facturaId), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("actaId", actaId)])})
      }
   """
)
                        

// @LINE:78
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.cambiarEstado",
   """
      function(idFactura,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idFactura", idFactura), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:19
def actasAsociadas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.actasAsociadas",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/actas-asociada" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:79
def cambiarEstadoPrecargado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.cambiarEstadoPrecargado",
   """
      function(idFactura,idEstado,precarga) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/cambiarEstadoPrecarga" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idFactura", idFactura), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado), (precarga == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("precarga", precarga))])})
      }
   """
)
                        

// @LINE:81
def cambiarEstadoAprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.cambiarEstadoAprobado",
   """
      function(idFactura) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/cambiarEstadoAprobado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idFactura", idFactura)])})
      }
   """
)
                        

// @LINE:12
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/crear"})
      }
   """
)
                        

// @LINE:16
def eliminarFacturaDato : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.eliminarFacturaDato",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/eliminarFacturaDato" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:28
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:100
def vistaFacturasCargadas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.vistaFacturasCargadas",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/vistaFacturasCargadas"})
      }
   """
)
                        

// @LINE:76
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:18
def crearFacturaParcial : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.crearFacturaParcial",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/crearFacturaParcial" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:15
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:13
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/guardar"})
      }
   """
)
                        

// @LINE:30
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:98
def getInfoRetenciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.getInfoRetenciones",
   """
      function(id,fci) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/getInfoRetenciones" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (fci == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("fci", fci))])})
      }
   """
)
                        

// @LINE:29
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalBuscar"})
      }
   """
)
                        

// @LINE:20
def eliminarActaAsociada : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.eliminarActaAsociada",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/eliminar-actas-asociada" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:14
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:11
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor"})
      }
   """
)
                        

// @LINE:17
def duplicar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasController.duplicar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/duplicar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:367
// @LINE:268
// @LINE:267
// @LINE:266
// @LINE:265
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
class ReverseBancosController {
    

// @LINE:266
def actualizarBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BancosController.actualizarBanco",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "banco/actualizar"})
      }
   """
)
                        

// @LINE:268
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BancosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "banco/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:262
def crearBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BancosController.crearBanco",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "banco/crear"})
      }
   """
)
                        

// @LINE:367
def suggestBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BancosController.suggestBanco",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestBanco/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:265
def eliminarBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BancosController.eliminarBanco",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "banco/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:267
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BancosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "banco/modalBuscar"})
      }
   """
)
                        

// @LINE:264
def editarBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BancosController.editarBanco",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "banco/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:263
def guardarBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BancosController.guardarBanco",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "banco/guardar"})
      }
   """
)
                        

// @LINE:261
def indexBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BancosController.indexBanco",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "banco"})
      }
   """
)
                        
    
}
              

// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:215
class ReverseSucursalBancosController {
    

// @LINE:295
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.SucursalBancosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sucursalBanco/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:293
def actualizarSucursalBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.SucursalBancosController.actualizarSucursalBanco",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sucursalBanco/actualizar"})
      }
   """
)
                        

// @LINE:288
def indexSucursalBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.SucursalBancosController.indexSucursalBanco",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sucursalBanco"})
      }
   """
)
                        

// @LINE:289
def crearSucursalBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.SucursalBancosController.crearSucursalBanco",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sucursalBanco/crear"})
      }
   """
)
                        

// @LINE:291
def editarSucursalBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.SucursalBancosController.editarSucursalBanco",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sucursalBanco/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:292
def eliminarSucursalBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.SucursalBancosController.eliminarSucursalBanco",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sucursalBanco/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:294
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.SucursalBancosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sucursalBanco/modalBuscar"})
      }
   """
)
                        

// @LINE:215
def listOptions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.SucursalBancosController.listOptions",
   """
      function(bancoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sucursalBanco/listOptions" + _qS([(bancoId == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("bancoId", bancoId))])})
      }
   """
)
                        

// @LINE:290
def guardarSucursalBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.SucursalBancosController.guardarSucursalBanco",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sucursalBanco/guardar"})
      }
   """
)
                        
    
}
              

// @LINE:320
// @LINE:319
// @LINE:318
// @LINE:317
// @LINE:316
class ReverseOrdenesPagosCircuitosController {
    

// @LINE:318
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosController.cambiarEstado",
   """
      function(idOc,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuitoCambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOc", idOc), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:317
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:320
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/actualizar"})
      }
   """
)
                        

// @LINE:319
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:316
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito"})
      }
   """
)
                        
    
}
              

// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
class ReverseMisPagosController {
    

// @LINE:238
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.MisPagosController.actualizar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mis-pagos/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:237
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.MisPagosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mis-pagos/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:235
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.MisPagosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mis-pagos/index"})
      }
   """
)
                        

// @LINE:236
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.MisPagosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mis-pagos/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:211
// @LINE:210
// @LINE:209
class ReverseConciliacionPagosController {
    

// @LINE:211
def analisisConciliacionCheques : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.ConciliacionPagosController.analisisConciliacionCheques",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "conciliacionCheques/anilisis-conciliacion-cheques"})
      }
   """
)
                        

// @LINE:210
def conciliarCheques : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.ConciliacionPagosController.conciliarCheques",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "conciliacionCheques/conciliar-cheques"})
      }
   """
)
                        

// @LINE:209
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.ConciliacionPagosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "conciliacionCheques"})
      }
   """
)
                        
    
}
              

// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
class ReverseFacturasLineasImpuestosController {
    

// @LINE:116
def getSecuenciaRetencionSellos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaRetencionSellos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/getSecuenciaRetencionSellos"})
      }
   """
)
                        

// @LINE:110
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:115
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:113
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/guardar"})
      }
   """
)
                        

// @LINE:119
def getSecuenciaIva : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaIva",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/getSecuenciaIva"})
      }
   """
)
                        

// @LINE:118
def getSecuenciaIIBB : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaIIBB",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/getSecuenciaIIBB"})
      }
   """
)
                        

// @LINE:114
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/actualizar"})
      }
   """
)
                        

// @LINE:121
def precalcular : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.precalcular",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/precalcular" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:120
def getSecuenciaRetencionMunicipal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaRetencionMunicipal",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/getSecuenciaRetencionMunicipal"})
      }
   """
)
                        

// @LINE:112
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:111
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.crear",
   """
      function(facturaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("facturaId", facturaId)])})
      }
   """
)
                        

// @LINE:117
def getSecuenciaGanancias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaGanancias",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-impuesto/getSecuenciaGanancias"})
      }
   """
)
                        
    
}
              

// @LINE:368
// @LINE:308
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
// @LINE:301
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
class ReverseCuentaBancariasController {
    

// @LINE:298
def crearCuentaBancaria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.crearCuentaBancaria",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/crear"})
      }
   """
)
                        

// @LINE:297
def indexCuentaBancaria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.indexCuentaBancaria",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria"})
      }
   """
)
                        

// @LINE:306
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.cambiarEstado",
   """
      function(idCuenta,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idCuenta", idCuenta), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:302
def actualizarCuentaBancaria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.actualizarCuentaBancaria",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/actualizar"})
      }
   """
)
                        

// @LINE:304
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:300
def editarCuentaBancaria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.editarCuentaBancaria",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:305
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:299
def guardarCuentaBancaria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.guardarCuentaBancaria",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/guardar"})
      }
   """
)
                        

// @LINE:303
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/modalBuscar"})
      }
   """
)
                        

// @LINE:368
def suggestCuentaBancaria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.suggestCuentaBancaria",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestCuentaBancaria/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:308
def reporteDatosGenerales : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.reporteDatosGenerales",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/reporteDatosGenerales"})
      }
   """
)
                        

// @LINE:301
def eliminarCuentaBancaria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentaBancariasController.eliminarCuentaBancaria",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentaBancaria/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:254
// @LINE:252
// @LINE:251
// @LINE:250
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:197
// @LINE:196
class ReversePagosReportesController {
    

// @LINE:254
def informeRetencionSuss : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.informeRetencionSuss",
   """
      function(regimen) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/informeRetencionSuss" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("regimen", regimen)])})
      }
   """
)
                        

// @LINE:258
def informeRetencionGcia4245 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.informeRetencionGcia4245",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/informeRetencionGcia4245"})
      }
   """
)
                        

// @LINE:197
def descargarInformeMensualRentas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.descargarInformeMensualRentas",
   """
      function(url) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reportesPagoProveedor/descargarInformeMensualRentas" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("url", url)])})
      }
   """
)
                        

// @LINE:243
def informeImpuestoMunicipal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.informeImpuestoMunicipal",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informeImpuestoMunicipal"})
      }
   """
)
                        

// @LINE:252
def descargarLotesPago : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.descargarLotesPago",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reporteLotePago" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:242
def descargarLotes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.descargarLotes",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reporteLote"})
      }
   """
)
                        

// @LINE:241
def reporteCheque : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.reporteCheque",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reporte/cheque" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:251
def informeMensualImpuestos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.informeMensualImpuestos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/informeMensualImpuestos"})
      }
   """
)
                        

// @LINE:196
def modalInformeMensualRentas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.modalInformeMensualRentas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reportesPagoProveedor/modalInformeMensualRentas"})
      }
   """
)
                        

// @LINE:256
def informeRetDgrIibb : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.informeRetDgrIibb",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/informeRetDgrIibb"})
      }
   """
)
                        

// @LINE:250
def modalInformeMensualImpuestos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.modalInformeMensualImpuestos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/modalInformeMensualImpuestos"})
      }
   """
)
                        

// @LINE:257
def informeRetDgrIibb331 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.informeRetDgrIibb331",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/informeRetDgrIibb331"})
      }
   """
)
                        

// @LINE:259
def informeRetencionIva : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.informeRetencionIva",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/informeRetencionIva"})
      }
   """
)
                        

// @LINE:255
def informeRetDgrSellos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.informeRetDgrSellos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/informeRetencionDgrSellos"})
      }
   """
)
                        

// @LINE:244
def informeProfe : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosReportesController.informeProfe",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informeprofe"})
      }
   """
)
                        
    
}
              

// @LINE:373
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
class ReverseEjerciciosController {
    

// @LINE:275
def actualizarEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.EjerciciosController.actualizarEjercicio",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ejercicio/actualizar"})
      }
   """
)
                        

// @LINE:373
def suggestEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.EjerciciosController.suggestEjercicio",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestEjercicio/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:272
def guardarEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.EjerciciosController.guardarEjercicio",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ejercicio/guardar"})
      }
   """
)
                        

// @LINE:270
def indexEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.EjerciciosController.indexEjercicio",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ejercicio"})
      }
   """
)
                        

// @LINE:277
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.EjerciciosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ejercicio/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:276
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.EjerciciosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ejercicio/modalBuscar"})
      }
   """
)
                        

// @LINE:271
def crearEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.EjerciciosController.crearEjercicio",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ejercicio/crear"})
      }
   """
)
                        

// @LINE:273
def editarEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.EjerciciosController.editarEjercicio",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ejercicio/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:274
def eliminarEjercicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.EjerciciosController.eliminarEjercicio",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ejercicio/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
class ReverseFacturasLineasReintegrosController {
    

// @LINE:123
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasReintegrosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-reintegro/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:128
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasReintegrosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-reintegro/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:126
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasReintegrosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-reintegro/guardar"})
      }
   """
)
                        

// @LINE:127
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasReintegrosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-reintegro/actualizar"})
      }
   """
)
                        

// @LINE:125
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasReintegrosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-reintegro/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:124
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasReintegrosController.crear",
   """
      function(facturaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea-reintegro/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("facturaId", facturaId)])})
      }
   """
)
                        
    
}
              

// @LINE:372
// @LINE:234
// @LINE:233
// @LINE:232
// @LINE:231
// @LINE:230
// @LINE:229
// @LINE:228
// @LINE:227
class ReverseCuentasController {
    

// @LINE:228
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasController.crear",
   """
      function(parent_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas/crear" + _qS([(parent_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("parent_id", parent_id))])})
      }
   """
)
                        

// @LINE:372
def suggestCuenta : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasController.suggestCuenta",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestCuenta/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:234
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:232
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:227
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasController.index",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:231
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas/actualizar"})
      }
   """
)
                        

// @LINE:233
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas/modalBuscar"})
      }
   """
)
                        

// @LINE:229
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasController.guardar",
   """
      function(parent_id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas/guardar" + _qS([(parent_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("parent_id", parent_id))])})
      }
   """
)
                        

// @LINE:230
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasController.editar",
   """
      function(parent_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas/editar" + _qS([(parent_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("parent_id", parent_id))])})
      }
   """
)
                        
    
}
              

// @LINE:333
// @LINE:332
// @LINE:330
// @LINE:329
// @LINE:328
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
class ReverseOrdenesPagosCircuitosAccionesController {
    

// @LINE:324
def pasarContabilidadMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarContabilidadMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/pasarContabilidadMasivo"})
      }
   """
)
                        

// @LINE:321
def modalPasarBorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarBorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/modalPasarBorrador"})
      }
   """
)
                        

// @LINE:333
def cargarExpedienteFisico : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.cargarExpedienteFisico",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/cargarExpedienteFisico"})
      }
   """
)
                        

// @LINE:323
def modalPasarContabilidad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarContabilidad",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/modalPasarContabilidad"})
      }
   """
)
                        

// @LINE:327
def modalPasarRendido : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarRendido",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/modalPasarRendido"})
      }
   """
)
                        

// @LINE:330
def pasarCanceladoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarCanceladoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/pasarCanceladoMasivo"})
      }
   """
)
                        

// @LINE:322
def pasarBorradorMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarBorradorMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/pasarBorradorMasivo"})
      }
   """
)
                        

// @LINE:325
def modalPasarRendiciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarRendiciones",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/modalPasarRendiciones"})
      }
   """
)
                        

// @LINE:329
def modalPasarCancelado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarCancelado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/modalPasarCancelado"})
      }
   """
)
                        

// @LINE:326
def pasarRendicionesMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarRendicionesMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/pasarRendicionesMasivo"})
      }
   """
)
                        

// @LINE:328
def pasarRendidoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarRendidoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/pasarRendidoMasivo"})
      }
   """
)
                        

// @LINE:332
def modalCargarExpedienteFisico : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalCargarExpedienteFisico",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuito/modalCargarExpedienteFisico"})
      }
   """
)
                        
    
}
              

// @LINE:371
// @LINE:225
// @LINE:224
// @LINE:223
// @LINE:222
// @LINE:221
// @LINE:220
// @LINE:219
// @LINE:218
// @LINE:217
class ReverseCuentasAnaliticasController {
    

// @LINE:225
def modalBuscarCuentasAsociadas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.modalBuscarCuentasAsociadas",
   """
      function(solicitud_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas-analiticas/modalCuentasAsociadasSolicitud" + _qS([(solicitud_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("solicitud_id", solicitud_id))])})
      }
   """
)
                        

// @LINE:218
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.crear",
   """
      function(parent_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas-analiticas/crear" + _qS([(parent_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("parent_id", parent_id))])})
      }
   """
)
                        

// @LINE:222
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas-analiticas/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:217
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.index",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas-analiticas" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:224
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas-analiticas/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:221
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas-analiticas/actualizar"})
      }
   """
)
                        

// @LINE:223
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas-analiticas/modalBuscar"})
      }
   """
)
                        

// @LINE:219
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.guardar",
   """
      function(parent_id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas-analiticas/guardar" + _qS([(parent_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("parent_id", parent_id))])})
      }
   """
)
                        

// @LINE:371
def suggestCuentaAnalitica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.suggestCuentaAnalitica",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestCuentaAnalitica/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:220
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasAnaliticasController.editar",
   """
      function(parent_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentas-analiticas/editar" + _qS([(parent_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("parent_id", parent_id))])})
      }
   """
)
                        
    
}
              

// @LINE:311
// @LINE:310
class ReverseCuentasPropiasController {
    

// @LINE:310
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasPropiasController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentasPropias/modalBuscar"})
      }
   """
)
                        

// @LINE:311
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.CuentasPropiasController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cuentasPropias/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        
    
}
              

// @LINE:336
class ReverseOrdenesPagosCircuitosLineasController {
    

// @LINE:336
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosCircuitosLineasController.index",
   """
      function(orden_pago_circuito_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "OrdenPagoCircuitoLinea" + _qS([(orden_pago_circuito_id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("orden_pago_circuito_id", orden_pago_circuito_id))])})
      }
   """
)
                        
    
}
              

// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:361
// @LINE:360
// @LINE:358
// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
class ReverseBalanceController {
    

// @LINE:360
def modalCambiarCuenta : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.modalCambiarCuenta",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/modalCambiarCuenta"})
      }
   """
)
                        

// @LINE:357
def modalPasarControlado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.modalPasarControlado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/modalPasarControlado"})
      }
   """
)
                        

// @LINE:364
def archivoBejermanPagos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.archivoBejermanPagos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/archivoBejermanPagos"})
      }
   """
)
                        

// @LINE:351
def general : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.general",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/general"})
      }
   """
)
                        

// @LINE:355
def modalPasarBorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.modalPasarBorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/modalPasarBorrador"})
      }
   """
)
                        

// @LINE:352
def modalAgregarMovimientoBalance : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.modalAgregarMovimientoBalance",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/modalAgregarMovimientoBalance"})
      }
   """
)
                        

// @LINE:358
def pasarControladoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.pasarControladoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/pasarControladoMasivo"})
      }
   """
)
                        

// @LINE:356
def pasarBorradorMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.pasarBorradorMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/pasarBorradorMasivo"})
      }
   """
)
                        

// @LINE:365
def archivoExcel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.archivoExcel",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/archivoExcel"})
      }
   """
)
                        

// @LINE:363
def archivoBejerman : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.archivoBejerman",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/archivoBejerman"})
      }
   """
)
                        

// @LINE:353
def agregarMovimientoBalance : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.agregarMovimientoBalance",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/agregarMovimientoBalance"})
      }
   """
)
                        

// @LINE:350
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance"})
      }
   """
)
                        

// @LINE:361
def cambiarCuentaMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceController.cambiarCuentaMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Balance/cambiarCuentaMasivo"})
      }
   """
)
                        
    
}
              

// @LINE:207
// @LINE:206
// @LINE:205
// @LINE:204
// @LINE:203
// @LINE:202
class ReversePagosLineasController {
    

// @LINE:202
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosLineasController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:207
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosLineasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:205
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosLineasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pago-linea/guardar"})
      }
   """
)
                        

// @LINE:206
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosLineasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pago-linea/actualizar"})
      }
   """
)
                        

// @LINE:204
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosLineasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:203
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosLineasController.crear",
   """
      function(pagoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pagoId", pagoId)])})
      }
   """
)
                        
    
}
              

// @LINE:96
// @LINE:95
// @LINE:93
// @LINE:92
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:32
// @LINE:31
class ReverseFacturasAccionesController {
    

// @LINE:68
def modalCargarOrdenPago : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalCargarOrdenPago",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalCargarOrdenPago"})
      }
   """
)
                        

// @LINE:44
def modalCargar349 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalCargar349",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/acciones/modalCargar349" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:73
def cargarFecha322Masivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.cargarFecha322Masivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/cargarFecha322Masivo"})
      }
   """
)
                        

// @LINE:62
def modalPasarBorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalPasarBorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalPasarBorrador"})
      }
   """
)
                        

// @LINE:32
def descargar322 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.descargar322",
   """
      function(url) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/acciones/descargar322" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("url", url)])})
      }
   """
)
                        

// @LINE:85
def modalDetalleFacturacionPorEstadoPorPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalDetalleFacturacionPorEstadoPorPeriodo",
   """
      function(nombrePeriodo,estado,proveedorId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/acciones/modalDetalleFacturacionPorEstadoPorPeriodo" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("nombrePeriodo", nombrePeriodo), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("estado", estado), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("proveedorId", proveedorId)])})
      }
   """
)
                        

// @LINE:72
def modalCargarFecha322 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalCargarFecha322",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalCargarFecha322"})
      }
   """
)
                        

// @LINE:58
def modalPasarEnPreCurso : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalPasarEnPreCurso",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalPasarEnPreCurso"})
      }
   """
)
                        

// @LINE:57
def pasarEnPreCursoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.pasarEnPreCursoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/pasarEnCursoMasivo"})
      }
   """
)
                        

// @LINE:42
def importarListaComisiones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.importarListaComisiones",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/acciones/importarListaComisiones"})
      }
   """
)
                        

// @LINE:67
def pasarPreAprobadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.pasarPreAprobadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/pasarPreAprobadoMasivo"})
      }
   """
)
                        

// @LINE:87
def marcadoresMasivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.marcadoresMasivos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/marcadoresMasivos"})
      }
   """
)
                        

// @LINE:92
def modalModificarNumeroFactura : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalModificarNumeroFactura",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalModificarNumeroFactura" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:74
def modalRechazarFactura : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalRechazarFactura",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalRechazarFactura"})
      }
   """
)
                        

// @LINE:71
def cargarFechaOrdenPagoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.cargarFechaOrdenPagoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/cargarFechaOrdenPagoMasivo"})
      }
   """
)
                        

// @LINE:60
def modalPasarAprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalPasarAprobado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalPasarAprobado"})
      }
   """
)
                        

// @LINE:70
def modalCargarFechaOrdenPago : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalCargarFechaOrdenPago",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalCargarFechaOrdenPago"})
      }
   """
)
                        

// @LINE:69
def cargarOrdenPagoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.cargarOrdenPagoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/cargarOrdenPagoMasivo"})
      }
   """
)
                        

// @LINE:96
def cargarNumeroFacturaParcial : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.cargarNumeroFacturaParcial",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/cargarNumeroFacturaParcial"})
      }
   """
)
                        

// @LINE:93
def modificarNumeroFactura : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modificarNumeroFactura",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modificarNumeroFactura"})
      }
   """
)
                        

// @LINE:75
def rechazar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.rechazar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/rechazar"})
      }
   """
)
                        

// @LINE:95
def modalCargarNumeroFacturaParcial : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalCargarNumeroFacturaParcial",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalCargarNumeroFacturaParcial"})
      }
   """
)
                        

// @LINE:31
def solicitud322 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.solicitud322",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/acciones/solicitud322"})
      }
   """
)
                        

// @LINE:65
def pasarCanceladoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.pasarCanceladoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/pasarCanceladoMasivo"})
      }
   """
)
                        

// @LINE:63
def pasarBorradorMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.pasarBorradorMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/pasarBorradorMasivo"})
      }
   """
)
                        

// @LINE:84
def modalDetalleFacturacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalDetalleFacturacion",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalDetalleFacturacion" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:64
def modalPasarCancelado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalPasarCancelado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalPasarCancelado"})
      }
   """
)
                        

// @LINE:61
def pasarAprobadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.pasarAprobadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/pasarAprobadoMasivo"})
      }
   """
)
                        

// @LINE:56
def modalPasarEnCurso : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalPasarEnCurso",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalPasarEnCurso"})
      }
   """
)
                        

// @LINE:86
def modalMarcadoresMasivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalMarcadoresMasivos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalMarcadoresMasivos"})
      }
   """
)
                        

// @LINE:59
def pasarEnCursoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.pasarEnCursoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/pasarEnPreCursoMasivo"})
      }
   """
)
                        

// @LINE:66
def modalPasarPreAprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalPasarPreAprobado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/modalPasarPreAprobado"})
      }
   """
)
                        

// @LINE:41
def modalImportarListaComisiones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.modalImportarListaComisiones",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/acciones/modalImportarListaComisiones"})
      }
   """
)
                        

// @LINE:45
def cargar349 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasAccionesController.cargar349",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/acciones/cargar349"})
      }
   """
)
                        
    
}
              

// @LINE:348
// @LINE:347
// @LINE:345
// @LINE:344
// @LINE:343
// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
class ReverseBalanceCuentaPropiaController {
    

// @LINE:339
def archivoIndex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceCuentaPropiaController.archivoIndex",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "BalanceCuentaPropia/archivoIndex"})
      }
   """
)
                        

// @LINE:348
def getExpedientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceCuentaPropiaController.getExpedientes",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "BalanceCuentaPropia/get-expedientes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:345
def listaPagos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceCuentaPropiaController.listaPagos",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "BalanceCuentaPropia/listaPagos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:341
def agregarMovimientoBalanceCuentaPropia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceCuentaPropiaController.agregarMovimientoBalanceCuentaPropia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "BalanceCuentaPropia/agregarMovimientoBalanceCuentaPropia"})
      }
   """
)
                        

// @LINE:344
def transferenciaEntreCuentasPropias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceCuentaPropiaController.transferenciaEntreCuentasPropias",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "BalanceCuentaPropia/transferenciaEntreCuentasPropias"})
      }
   """
)
                        

// @LINE:340
def modalAgregarMovimientoBalanceCuentaPropia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceCuentaPropiaController.modalAgregarMovimientoBalanceCuentaPropia",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "BalanceCuentaPropia/modalAgregarMovimientoBalanceCuentaPropia"})
      }
   """
)
                        

// @LINE:343
def modalTransferenciaEntreCuentasPropias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceCuentaPropiaController.modalTransferenciaEntreCuentasPropias",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "BalanceCuentaPropia/modalTransferenciaEntreCuentasPropias"})
      }
   """
)
                        

// @LINE:338
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceCuentaPropiaController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "BalanceCuentaPropia"})
      }
   """
)
                        

// @LINE:347
def getOrdenes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.BalanceCuentaPropiaController.getOrdenes",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "BalanceCuentaPropia/get-ordenes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:90
// @LINE:88
// @LINE:83
// @LINE:82
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:27
class ReverseFacturasReportesController {
    

// @LINE:36
def reporteComprobanteRetencionMunicipal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionMunicipal",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComprobanteRetencionMunicipal"})
      }
   """
)
                        

// @LINE:90
def reporteFacturasCargadas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteFacturasCargadas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reporteFacturasCargadas"})
      }
   """
)
                        

// @LINE:27
def viatico : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.viatico",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/viatico"})
      }
   """
)
                        

// @LINE:53
def modalInformeSellos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.modalInformeSellos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/modalInformeMensualSellos"})
      }
   """
)
                        

// @LINE:38
def reporteComprobanteRetencionIva : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionIva",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComprobanteRetencionIva"})
      }
   """
)
                        

// @LINE:49
def reporteComprobanteRetencioniibb370 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencioniibb370",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComprobanteRetencionIibb370"})
      }
   """
)
                        

// @LINE:54
def informeSellos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.informeSellos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/informeMensualSellos"})
      }
   """
)
                        

// @LINE:88
def reporteLineasFacturas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteLineasFacturas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reporteLineasFacturas"})
      }
   """
)
                        

// @LINE:51
def reporteComprobanteRetencionLimpieza : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionLimpieza",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComprobanteRetencionLimpieza"})
      }
   """
)
                        

// @LINE:52
def reporteComprobanteRetencionReggral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionReggral",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComprobanteRetencionReggral"})
      }
   """
)
                        

// @LINE:39
def reporteComisiones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComisiones",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComisiones"})
      }
   """
)
                        

// @LINE:83
def reporteControlFacturasAFIP : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteControlFacturasAFIP",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reporteControlFacturasAFIP"})
      }
   """
)
                        

// @LINE:48
def reporteComprobanteRetencioniibb : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencioniibb",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComprobanteRetencionIibb"})
      }
   """
)
                        

// @LINE:34
def ordenDePago : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.ordenDePago",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/OrdenDePago"})
      }
   """
)
                        

// @LINE:47
def reporteRendicionSellos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteRendicionSellos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteRendicionSellos"})
      }
   """
)
                        

// @LINE:82
def reporteControlFacturas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteControlFacturas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reporteControlFactura"})
      }
   """
)
                        

// @LINE:50
def reporteComprobanteRetencionSeguridad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionSeguridad",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComprobanteRetencionSeguridad"})
      }
   """
)
                        

// @LINE:33
def OPCservicios : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.OPCservicios",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/OPCservicios"})
      }
   """
)
                        

// @LINE:35
def reporteComprobanteRetencionSellos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionSellos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComprobanteRetencionSellos"})
      }
   """
)
                        

// @LINE:37
def reporteComprobanteRetencionGcia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionGcia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "facturaProveedor/reportes/reporteComprobanteRetencionGcia"})
      }
   """
)
                        
    
}
              

// @LINE:1
class ReverseIndexController {
    

// @LINE:1
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
class ReversePagosController {
    

// @LINE:138
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.cambiarEstado",
   """
      function(idPago,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idPago", idPago), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:139
def cambiarEstadoTransferenciaConciliado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.cambiarEstadoTransferenciaConciliado",
   """
      function(idPago) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor/cambiarEstadoTransferenciaConciliado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idPago", idPago)])})
      }
   """
)
                        

// @LINE:133
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor/crear"})
      }
   """
)
                        

// @LINE:137
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:132
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:136
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:134
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor/guardar"})
      }
   """
)
                        

// @LINE:135
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:130
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor"})
      }
   """
)
                        

// @LINE:131
def duplicar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosController.duplicar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagoProveedor/duplicar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:370
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
class ReverseOrdenesPagosController {
    

// @LINE:4
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesPagos/crear"})
      }
   """
)
                        

// @LINE:9
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesPagos/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:3
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesPagos/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:5
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesPagos/guardar"})
      }
   """
)
                        

// @LINE:7
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesPagos/actualizar"})
      }
   """
)
                        

// @LINE:8
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesPagos/modalBuscar"})
      }
   """
)
                        

// @LINE:370
def suggestOrdenPago : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosController.suggestOrdenPago",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestOrdenPago/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:6
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesPagos/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:2
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.OrdenesPagosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenesPagos"})
      }
   """
)
                        
    
}
              

// @LINE:249
// @LINE:248
// @LINE:247
// @LINE:246
// @LINE:200
// @LINE:199
// @LINE:195
// @LINE:194
// @LINE:193
// @LINE:191
// @LINE:190
// @LINE:188
// @LINE:187
// @LINE:186
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
class ReversePagosAccionesController {
    

// @LINE:144
def modalModificarReferencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarReferencia",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarReferencia"})
      }
   """
)
                        

// @LINE:183
def modalModificarCuentaPropia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarCuentaPropia",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarCuentaPropia"})
      }
   """
)
                        

// @LINE:195
def descargarRendiciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.descargarRendiciones",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/descargarRendiciones" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:184
def modificarCuentaPropia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarCuentaPropia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarCuentaPropia"})
      }
   """
)
                        

// @LINE:165
def modalPagarProveedoresExternos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPagarProveedoresExternos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPagarProveedoresExternos"})
      }
   """
)
                        

// @LINE:179
def modalModificarNumeroCheque : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarNumeroCheque",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarNumeroCheque"})
      }
   """
)
                        

// @LINE:248
def modalPasarBorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPasarBorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/modalPasarBorrador"})
      }
   """
)
                        

// @LINE:178
def pagarCheques : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pagarCheques",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/pagarCheques"})
      }
   """
)
                        

// @LINE:148
def pagarEmbargos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pagarEmbargos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/pagarEmbargos"})
      }
   """
)
                        

// @LINE:171
def modificarFechaCancelacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarFechaCancelacion",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarFechaCancelacion"})
      }
   """
)
                        

// @LINE:177
def modalPagarCheques : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPagarCheques",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPagarCheques"})
      }
   """
)
                        

// @LINE:180
def modificarNumeroCheque : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarNumeroCheque",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarNumeroCheque"})
      }
   """
)
                        

// @LINE:147
def modalPagarEmbargos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPagarEmbargos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPagarEmbargos"})
      }
   """
)
                        

// @LINE:169
def modificarFechaConciliado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarFechaConciliado",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarFechaConciliado"})
      }
   """
)
                        

// @LINE:173
def modalModificarNumeroFactura : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarNumeroFactura",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarNumeroFactura" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:190
def modalPasarConciliado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPasarConciliado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPasarConciliado"})
      }
   """
)
                        

// @LINE:200
def descargarOpgEmbargoExterno : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.descargarOpgEmbargoExterno",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/descargarOPGEmbargoExterno" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:193
def descargarOpg : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.descargarOpg",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/descargarOPG" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:158
def pagarProveedoresMacroMasivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pagarProveedoresMacroMasivos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/pagarProveedoresMacroMasivos"})
      }
   """
)
                        

// @LINE:176
def modificarNumeroRecibo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarNumeroRecibo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarNumeroRecibo"})
      }
   """
)
                        

// @LINE:145
def modalPagarInterno : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPagarInterno",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPagarInterno"})
      }
   """
)
                        

// @LINE:146
def pagarInterno : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pagarInterno",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/pagarInterno"})
      }
   """
)
                        

// @LINE:191
def pasarConciliadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pasarConciliadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/pasarConciliadoMasivo"})
      }
   """
)
                        

// @LINE:159
def descargarArchivoProveedoresMacroMasivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.descargarArchivoProveedoresMacroMasivos",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/descargarArchivoProveedoresMacroMasivos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:174
def modificarNumeroFactura : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarNumeroFactura",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarNumeroFactura"})
      }
   """
)
                        

// @LINE:182
def modificarTipoPago : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarTipoPago",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarTipoPago"})
      }
   """
)
                        

// @LINE:247
def pasarCanceladoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pasarCanceladoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/pasarCanceladoMasivo"})
      }
   """
)
                        

// @LINE:166
def pagarProveedoresExternos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pagarProveedoresExternos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPagarProveedoresExternos"})
      }
   """
)
                        

// @LINE:153
def modalPagarInterbankingProveedores : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPagarInterbankingProveedores",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPagarInterbankingProveedores"})
      }
   """
)
                        

// @LINE:143
def modificarReferencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarReferencia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarReferencia"})
      }
   """
)
                        

// @LINE:249
def pasarBorradorMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pasarBorradorMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/pasarBorradorMasivo"})
      }
   """
)
                        

// @LINE:170
def modalModificarFechaConciliado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarFechaConciliado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarFechaConciliado"})
      }
   """
)
                        

// @LINE:149
def modalPagarEmbargosExternos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPagarEmbargosExternos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPagarEmbargosExternos"})
      }
   """
)
                        

// @LINE:181
def modalModificarTipoPago : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarTipoPago",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarTipoPago"})
      }
   """
)
                        

// @LINE:188
def crearRefenciaEmbargos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.crearRefenciaEmbargos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/crearRefenciaEmbargos"})
      }
   """
)
                        

// @LINE:150
def pagarEmbargosExternos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pagarEmbargosExternos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/pagarEmbargosExternos"})
      }
   """
)
                        

// @LINE:246
def modalPasarCancelado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPasarCancelado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/modalPasarCancelado"})
      }
   """
)
                        

// @LINE:164
def pagarPlanta : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pagarPlanta",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/pagarPlanta"})
      }
   """
)
                        

// @LINE:142
def modalModificarFecha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarFecha",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarFecha"})
      }
   """
)
                        

// @LINE:186
def modificarPaguese : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarPaguese",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarPaguese"})
      }
   """
)
                        

// @LINE:154
def pagarInterbankingProveedores : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.pagarInterbankingProveedores",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/pagarInterbankingProveedores"})
      }
   """
)
                        

// @LINE:163
def modalPagarPlanta : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPagarPlanta",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPagarPlanta"})
      }
   """
)
                        

// @LINE:194
def descargarBnf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.descargarBnf",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/descargarBNF" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:167
def modalDetallePago : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalDetallePago",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalDetallePago" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:160
def descargarArchivoBnfMacroMasivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.descargarArchivoBnfMacroMasivos",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/descargarArchivoBnfMacroMasivos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:175
def modalModificarNumeroRecibo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarNumeroRecibo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarNumeroRecibo" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:157
def modalPagarProveedoresMacroMasivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalPagarProveedoresMacroMasivos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalPagarProveedoresMacroMasivos"})
      }
   """
)
                        

// @LINE:168
def modalDetalleDeudaPorEstadoPorPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalDetalleDeudaPorEstadoPorPeriodo",
   """
      function(nombrePeriodo,estado,proveedorId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalDetalleDeudaPorEstadoPorPeriodo" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("nombrePeriodo", nombrePeriodo), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("estado", estado), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("proveedorId", proveedorId)])})
      }
   """
)
                        

// @LINE:185
def modalModificarPaguese : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarPaguese",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarPaguese"})
      }
   """
)
                        

// @LINE:155
def descargarArchivoInterbankingProveedores : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.descargarArchivoInterbankingProveedores",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/descargarArchivoInterbankingProveedores" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:199
def descargarOpgEmbargo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.descargarOpgEmbargo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/descargarOPGEmbargo" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:172
def modalModificarFechaCancelacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalModificarFechaCancelacion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalModificarFechaCancelacion"})
      }
   """
)
                        

// @LINE:141
def modificarFecha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modificarFecha",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modificarFecha"})
      }
   """
)
                        

// @LINE:187
def modalCrearRefenciaEmbargos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PagosAccionesController.modalCrearRefenciaEmbargos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accionesPagoProveedor/modalCrearRefenciaEmbargos"})
      }
   """
)
                        
    
}
              

// @LINE:369
// @LINE:286
// @LINE:285
// @LINE:284
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
class ReversePeriodosController {
    

// @LINE:279
def indexPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PeriodosController.indexPeriodo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "periodo"})
      }
   """
)
                        

// @LINE:280
def crearPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PeriodosController.crearPeriodo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "periodo/crear"})
      }
   """
)
                        

// @LINE:282
def editarPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PeriodosController.editarPeriodo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "periodo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:284
def actualizarPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PeriodosController.actualizarPeriodo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "periodo/actualizar"})
      }
   """
)
                        

// @LINE:286
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PeriodosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "periodo/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:283
def eliminarPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PeriodosController.eliminarPeriodo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "periodo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:285
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PeriodosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "periodo/modalBuscar"})
      }
   """
)
                        

// @LINE:281
def guardarPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PeriodosController.guardarPeriodo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "periodo/guardar"})
      }
   """
)
                        

// @LINE:369
def suggestPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.PeriodosController.suggestPeriodo",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestPeriodo/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        
    
}
              

// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
class ReverseFacturasLineasController {
    

// @LINE:102
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:107
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:105
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/guardar"})
      }
   """
)
                        

// @LINE:106
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/actualizar"})
      }
   """
)
                        

// @LINE:108
def eliminarMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasController.eliminarMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/eliminar-masivo"})
      }
   """
)
                        

// @LINE:104
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:103
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.contabilidad.FacturasLineasController.crear",
   """
      function(facturaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("facturaId", facturaId)])})
      }
   """
)
                        
    
}
              
}
        


// @LINE:373
// @LINE:372
// @LINE:371
// @LINE:370
// @LINE:369
// @LINE:368
// @LINE:367
// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:361
// @LINE:360
// @LINE:358
// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
// @LINE:348
// @LINE:347
// @LINE:345
// @LINE:344
// @LINE:343
// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
// @LINE:336
// @LINE:333
// @LINE:332
// @LINE:330
// @LINE:329
// @LINE:328
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
// @LINE:320
// @LINE:319
// @LINE:318
// @LINE:317
// @LINE:316
// @LINE:311
// @LINE:310
// @LINE:308
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
// @LINE:301
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:286
// @LINE:285
// @LINE:284
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
// @LINE:268
// @LINE:267
// @LINE:266
// @LINE:265
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:254
// @LINE:252
// @LINE:251
// @LINE:250
// @LINE:249
// @LINE:248
// @LINE:247
// @LINE:246
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
// @LINE:234
// @LINE:233
// @LINE:232
// @LINE:231
// @LINE:230
// @LINE:229
// @LINE:228
// @LINE:227
// @LINE:225
// @LINE:224
// @LINE:223
// @LINE:222
// @LINE:221
// @LINE:220
// @LINE:219
// @LINE:218
// @LINE:217
// @LINE:215
// @LINE:211
// @LINE:210
// @LINE:209
// @LINE:207
// @LINE:206
// @LINE:205
// @LINE:204
// @LINE:203
// @LINE:202
// @LINE:200
// @LINE:199
// @LINE:197
// @LINE:196
// @LINE:195
// @LINE:194
// @LINE:193
// @LINE:191
// @LINE:190
// @LINE:188
// @LINE:187
// @LINE:186
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:100
// @LINE:98
// @LINE:96
// @LINE:95
// @LINE:93
// @LINE:92
// @LINE:90
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.contabilidad.ref {


// @LINE:100
// @LINE:98
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:76
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseFacturasController {
    

// @LINE:23
def modalSeleccionActaRelacionada(facturaId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.modalSeleccionActaRelacionada(facturaId), HandlerDef(this, "controllers.contabilidad.FacturasController", "modalSeleccionActaRelacionada", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/seleccionar-actas-asociada""")
)
                      

// @LINE:22
def asignarActasAsociada(facturaId:Long, actaId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.asignarActasAsociada(facturaId, actaId), HandlerDef(this, "controllers.contabilidad.FacturasController", "asignarActasAsociada", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """facturaProveedor/asignar-actas-asociada""")
)
                      

// @LINE:78
def cambiarEstado(idFactura:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.cambiarEstado(idFactura, idEstado), HandlerDef(this, "controllers.contabilidad.FacturasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """facturaProveedor/cambiarEstado""")
)
                      

// @LINE:19
def actasAsociadas(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.actasAsociadas(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "actasAsociadas", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/actas-asociada""")
)
                      

// @LINE:79
def cambiarEstadoPrecargado(idFactura:Long, idEstado:Long, precarga:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.cambiarEstadoPrecargado(idFactura, idEstado, precarga), HandlerDef(this, "controllers.contabilidad.FacturasController", "cambiarEstadoPrecargado", Seq(classOf[Long], classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """facturaProveedor/cambiarEstadoPrecarga""")
)
                      

// @LINE:81
def cambiarEstadoAprobado(idFactura:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.cambiarEstadoAprobado(idFactura), HandlerDef(this, "controllers.contabilidad.FacturasController", "cambiarEstadoAprobado", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/cambiarEstadoAprobado""")
)
                      

// @LINE:12
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.crear(), HandlerDef(this, "controllers.contabilidad.FacturasController", "crear", Seq(), "GET", """""", _prefix + """facturaProveedor/crear""")
)
                      

// @LINE:16
def eliminarFacturaDato(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.eliminarFacturaDato(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "eliminarFacturaDato", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/eliminarFacturaDato""")
)
                      

// @LINE:28
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.actualizar(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """facturaProveedor/actualizar""")
)
                      

// @LINE:100
def vistaFacturasCargadas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.vistaFacturasCargadas(), HandlerDef(this, "controllers.contabilidad.FacturasController", "vistaFacturasCargadas", Seq(), "GET", """""", _prefix + """facturaProveedor/vistaFacturasCargadas""")
)
                      

// @LINE:76
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.ver(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/ver""")
)
                      

// @LINE:18
def crearFacturaParcial(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.crearFacturaParcial(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "crearFacturaParcial", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/crearFacturaParcial""")
)
                      

// @LINE:15
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/eliminar""")
)
                      

// @LINE:13
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.guardar(), HandlerDef(this, "controllers.contabilidad.FacturasController", "guardar", Seq(), "POST", """""", _prefix + """facturaProveedor/guardar""")
)
                      

// @LINE:30
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.get(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/get""")
)
                      

// @LINE:98
def getInfoRetenciones(id:Long, fci:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.getInfoRetenciones(id, fci), HandlerDef(this, "controllers.contabilidad.FacturasController", "getInfoRetenciones", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """facturaProveedor/getInfoRetenciones""")
)
                      

// @LINE:29
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.FacturasController", "modalBuscar", Seq(), "GET", """""", _prefix + """facturaProveedor/modalBuscar""")
)
                      

// @LINE:20
def eliminarActaAsociada(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.eliminarActaAsociada(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "eliminarActaAsociada", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/eliminar-actas-asociada""")
)
                      

// @LINE:14
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.editar(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/editar""")
)
                      

// @LINE:11
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.index(), HandlerDef(this, "controllers.contabilidad.FacturasController", "index", Seq(), "GET", """""", _prefix + """facturaProveedor""")
)
                      

// @LINE:17
def duplicar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasController.duplicar(id), HandlerDef(this, "controllers.contabilidad.FacturasController", "duplicar", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/duplicar""")
)
                      
    
}
                          

// @LINE:367
// @LINE:268
// @LINE:267
// @LINE:266
// @LINE:265
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
class ReverseBancosController {
    

// @LINE:266
def actualizarBanco(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BancosController.actualizarBanco(), HandlerDef(this, "controllers.contabilidad.BancosController", "actualizarBanco", Seq(), "POST", """""", _prefix + """banco/actualizar""")
)
                      

// @LINE:268
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BancosController.get(id), HandlerDef(this, "controllers.contabilidad.BancosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """banco/get""")
)
                      

// @LINE:262
def crearBanco(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BancosController.crearBanco(), HandlerDef(this, "controllers.contabilidad.BancosController", "crearBanco", Seq(), "GET", """""", _prefix + """banco/crear""")
)
                      

// @LINE:367
def suggestBanco(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BancosController.suggestBanco(input), HandlerDef(this, "controllers.contabilidad.BancosController", "suggestBanco", Seq(classOf[String]), "GET", """""", _prefix + """suggestBanco/$input<[^/]+>""")
)
                      

// @LINE:265
def eliminarBanco(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BancosController.eliminarBanco(id), HandlerDef(this, "controllers.contabilidad.BancosController", "eliminarBanco", Seq(classOf[Long]), "GET", """""", _prefix + """banco/eliminar""")
)
                      

// @LINE:267
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BancosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.BancosController", "modalBuscar", Seq(), "GET", """""", _prefix + """banco/modalBuscar""")
)
                      

// @LINE:264
def editarBanco(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BancosController.editarBanco(id), HandlerDef(this, "controllers.contabilidad.BancosController", "editarBanco", Seq(classOf[Long]), "GET", """""", _prefix + """banco/editar""")
)
                      

// @LINE:263
def guardarBanco(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BancosController.guardarBanco(), HandlerDef(this, "controllers.contabilidad.BancosController", "guardarBanco", Seq(), "POST", """""", _prefix + """banco/guardar""")
)
                      

// @LINE:261
def indexBanco(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BancosController.indexBanco(), HandlerDef(this, "controllers.contabilidad.BancosController", "indexBanco", Seq(), "GET", """""", _prefix + """banco""")
)
                      
    
}
                          

// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:215
class ReverseSucursalBancosController {
    

// @LINE:295
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.SucursalBancosController.get(id), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """sucursalBanco/get""")
)
                      

// @LINE:293
def actualizarSucursalBanco(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.SucursalBancosController.actualizarSucursalBanco(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "actualizarSucursalBanco", Seq(), "POST", """""", _prefix + """sucursalBanco/actualizar""")
)
                      

// @LINE:288
def indexSucursalBanco(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.SucursalBancosController.indexSucursalBanco(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "indexSucursalBanco", Seq(), "GET", """""", _prefix + """sucursalBanco""")
)
                      

// @LINE:289
def crearSucursalBanco(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.SucursalBancosController.crearSucursalBanco(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "crearSucursalBanco", Seq(), "GET", """""", _prefix + """sucursalBanco/crear""")
)
                      

// @LINE:291
def editarSucursalBanco(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.SucursalBancosController.editarSucursalBanco(id), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "editarSucursalBanco", Seq(classOf[Long]), "GET", """""", _prefix + """sucursalBanco/editar""")
)
                      

// @LINE:292
def eliminarSucursalBanco(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.SucursalBancosController.eliminarSucursalBanco(id), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "eliminarSucursalBanco", Seq(classOf[Long]), "GET", """""", _prefix + """sucursalBanco/eliminar""")
)
                      

// @LINE:294
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.SucursalBancosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "modalBuscar", Seq(), "GET", """""", _prefix + """sucursalBanco/modalBuscar""")
)
                      

// @LINE:215
def listOptions(bancoId:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.SucursalBancosController.listOptions(bancoId), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "listOptions", Seq(classOf[Int]), "GET", """""", _prefix + """sucursalBanco/listOptions""")
)
                      

// @LINE:290
def guardarSucursalBanco(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.SucursalBancosController.guardarSucursalBanco(), HandlerDef(this, "controllers.contabilidad.SucursalBancosController", "guardarSucursalBanco", Seq(), "POST", """""", _prefix + """sucursalBanco/guardar""")
)
                      
    
}
                          

// @LINE:320
// @LINE:319
// @LINE:318
// @LINE:317
// @LINE:316
class ReverseOrdenesPagosCircuitosController {
    

// @LINE:318
def cambiarEstado(idOc:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosController.cambiarEstado(idOc, idEstado), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """OrdenPagoCircuitoCambiarEstado""")
)
                      

// @LINE:317
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosController.ver(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """OrdenPagoCircuito/ver""")
)
                      

// @LINE:320
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosController.actualizar(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "actualizar", Seq(), "POST", """""", _prefix + """OrdenPagoCircuito/actualizar""")
)
                      

// @LINE:319
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosController.editar(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """OrdenPagoCircuito/editar""")
)
                      

// @LINE:316
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosController.index(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosController", "index", Seq(), "GET", """""", _prefix + """OrdenPagoCircuito""")
)
                      
    
}
                          

// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
class ReverseMisPagosController {
    

// @LINE:238
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.MisPagosController.actualizar(id), HandlerDef(this, "controllers.contabilidad.MisPagosController", "actualizar", Seq(classOf[Long]), "GET", """""", _prefix + """mis-pagos/actualizar""")
)
                      

// @LINE:237
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.MisPagosController.editar(id), HandlerDef(this, "controllers.contabilidad.MisPagosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """mis-pagos/editar""")
)
                      

// @LINE:235
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.MisPagosController.index(), HandlerDef(this, "controllers.contabilidad.MisPagosController", "index", Seq(), "GET", """""", _prefix + """mis-pagos/index""")
)
                      

// @LINE:236
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.MisPagosController.ver(id), HandlerDef(this, "controllers.contabilidad.MisPagosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """mis-pagos/ver""")
)
                      
    
}
                          

// @LINE:211
// @LINE:210
// @LINE:209
class ReverseConciliacionPagosController {
    

// @LINE:211
def analisisConciliacionCheques(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.ConciliacionPagosController.analisisConciliacionCheques(), HandlerDef(this, "controllers.contabilidad.ConciliacionPagosController", "analisisConciliacionCheques", Seq(), "POST", """""", _prefix + """conciliacionCheques/anilisis-conciliacion-cheques""")
)
                      

// @LINE:210
def conciliarCheques(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.ConciliacionPagosController.conciliarCheques(), HandlerDef(this, "controllers.contabilidad.ConciliacionPagosController", "conciliarCheques", Seq(), "POST", """""", _prefix + """conciliacionCheques/conciliar-cheques""")
)
                      

// @LINE:209
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.ConciliacionPagosController.index(), HandlerDef(this, "controllers.contabilidad.ConciliacionPagosController", "index", Seq(), "GET", """""", _prefix + """conciliacionCheques""")
)
                      
    
}
                          

// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
class ReverseFacturasLineasImpuestosController {
    

// @LINE:116
def getSecuenciaRetencionSellos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaRetencionSellos(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaRetencionSellos", Seq(), "POST", """""", _prefix + """factura-linea-impuesto/getSecuenciaRetencionSellos""")
)
                      

// @LINE:110
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.index(id, editable), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """factura-linea-impuesto/index""")
)
                      

// @LINE:115
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.eliminar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """factura-linea-impuesto/eliminar""")
)
                      

// @LINE:113
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.guardar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "guardar", Seq(), "POST", """""", _prefix + """factura-linea-impuesto/guardar""")
)
                      

// @LINE:119
def getSecuenciaIva(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaIva(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaIva", Seq(), "POST", """""", _prefix + """factura-linea-impuesto/getSecuenciaIva""")
)
                      

// @LINE:118
def getSecuenciaIIBB(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaIIBB(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaIIBB", Seq(), "POST", """""", _prefix + """factura-linea-impuesto/getSecuenciaIIBB""")
)
                      

// @LINE:114
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.actualizar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "actualizar", Seq(), "POST", """""", _prefix + """factura-linea-impuesto/actualizar""")
)
                      

// @LINE:121
def precalcular(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.precalcular(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "precalcular", Seq(classOf[Long]), "GET", """""", _prefix + """factura-linea-impuesto/precalcular""")
)
                      

// @LINE:120
def getSecuenciaRetencionMunicipal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaRetencionMunicipal(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaRetencionMunicipal", Seq(), "POST", """""", _prefix + """factura-linea-impuesto/getSecuenciaRetencionMunicipal""")
)
                      

// @LINE:112
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.editar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """factura-linea-impuesto/editar""")
)
                      

// @LINE:111
def crear(facturaId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.crear(facturaId), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """factura-linea-impuesto/crear""")
)
                      

// @LINE:117
def getSecuenciaGanancias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasImpuestosController.getSecuenciaGanancias(), HandlerDef(this, "controllers.contabilidad.FacturasLineasImpuestosController", "getSecuenciaGanancias", Seq(), "POST", """""", _prefix + """factura-linea-impuesto/getSecuenciaGanancias""")
)
                      
    
}
                          

// @LINE:368
// @LINE:308
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
// @LINE:301
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
class ReverseCuentaBancariasController {
    

// @LINE:298
def crearCuentaBancaria(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.crearCuentaBancaria(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "crearCuentaBancaria", Seq(), "GET", """""", _prefix + """cuentaBancaria/crear""")
)
                      

// @LINE:297
def indexCuentaBancaria(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.indexCuentaBancaria(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "indexCuentaBancaria", Seq(), "GET", """""", _prefix + """cuentaBancaria""")
)
                      

// @LINE:306
def cambiarEstado(idCuenta:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.cambiarEstado(idCuenta, idEstado), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """cuentaBancaria/cambiarEstado""")
)
                      

// @LINE:302
def actualizarCuentaBancaria(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.actualizarCuentaBancaria(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "actualizarCuentaBancaria", Seq(), "POST", """""", _prefix + """cuentaBancaria/actualizar""")
)
                      

// @LINE:304
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.get(id), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """cuentaBancaria/get""")
)
                      

// @LINE:300
def editarCuentaBancaria(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.editarCuentaBancaria(id), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "editarCuentaBancaria", Seq(classOf[Long]), "GET", """""", _prefix + """cuentaBancaria/editar""")
)
                      

// @LINE:305
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.ver(id), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """cuentaBancaria/ver""")
)
                      

// @LINE:299
def guardarCuentaBancaria(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.guardarCuentaBancaria(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "guardarCuentaBancaria", Seq(), "POST", """""", _prefix + """cuentaBancaria/guardar""")
)
                      

// @LINE:303
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "modalBuscar", Seq(), "GET", """""", _prefix + """cuentaBancaria/modalBuscar""")
)
                      

// @LINE:368
def suggestCuentaBancaria(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.suggestCuentaBancaria(input), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "suggestCuentaBancaria", Seq(classOf[String]), "GET", """""", _prefix + """suggestCuentaBancaria/$input<[^/]+>""")
)
                      

// @LINE:308
def reporteDatosGenerales(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.reporteDatosGenerales(), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "reporteDatosGenerales", Seq(), "POST", """""", _prefix + """cuentaBancaria/reporteDatosGenerales""")
)
                      

// @LINE:301
def eliminarCuentaBancaria(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentaBancariasController.eliminarCuentaBancaria(id), HandlerDef(this, "controllers.contabilidad.CuentaBancariasController", "eliminarCuentaBancaria", Seq(classOf[Long]), "GET", """""", _prefix + """cuentaBancaria/eliminar""")
)
                      
    
}
                          

// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:254
// @LINE:252
// @LINE:251
// @LINE:250
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:197
// @LINE:196
class ReversePagosReportesController {
    

// @LINE:254
def informeRetencionSuss(regimen:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.informeRetencionSuss(regimen), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetencionSuss", Seq(classOf[String]), "POST", """""", _prefix + """pagos/informeRetencionSuss""")
)
                      

// @LINE:258
def informeRetencionGcia4245(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.informeRetencionGcia4245(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetencionGcia4245", Seq(), "POST", """""", _prefix + """pagos/informeRetencionGcia4245""")
)
                      

// @LINE:197
def descargarInformeMensualRentas(url:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.descargarInformeMensualRentas(url), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "descargarInformeMensualRentas", Seq(classOf[String]), "GET", """""", _prefix + """reportesPagoProveedor/descargarInformeMensualRentas""")
)
                      

// @LINE:243
def informeImpuestoMunicipal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.informeImpuestoMunicipal(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeImpuestoMunicipal", Seq(), "POST", """""", _prefix + """informeImpuestoMunicipal""")
)
                      

// @LINE:252
def descargarLotesPago(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.descargarLotesPago(id), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "descargarLotesPago", Seq(classOf[Long]), "GET", """""", _prefix + """reporteLotePago""")
)
                      

// @LINE:242
def descargarLotes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.descargarLotes(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "descargarLotes", Seq(), "POST", """""", _prefix + """reporteLote""")
)
                      

// @LINE:241
def reporteCheque(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.reporteCheque(id), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "reporteCheque", Seq(classOf[Long]), "GET", """""", _prefix + """reporte/cheque""")
)
                      

// @LINE:251
def informeMensualImpuestos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.informeMensualImpuestos(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeMensualImpuestos", Seq(), "POST", """""", _prefix + """pagos/informeMensualImpuestos""")
)
                      

// @LINE:196
def modalInformeMensualRentas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.modalInformeMensualRentas(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "modalInformeMensualRentas", Seq(), "POST", """""", _prefix + """reportesPagoProveedor/modalInformeMensualRentas""")
)
                      

// @LINE:256
def informeRetDgrIibb(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.informeRetDgrIibb(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetDgrIibb", Seq(), "POST", """""", _prefix + """pagos/informeRetDgrIibb""")
)
                      

// @LINE:250
def modalInformeMensualImpuestos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.modalInformeMensualImpuestos(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "modalInformeMensualImpuestos", Seq(), "GET", """""", _prefix + """pagos/modalInformeMensualImpuestos""")
)
                      

// @LINE:257
def informeRetDgrIibb331(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.informeRetDgrIibb331(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetDgrIibb331", Seq(), "POST", """""", _prefix + """pagos/informeRetDgrIibb331""")
)
                      

// @LINE:259
def informeRetencionIva(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.informeRetencionIva(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetencionIva", Seq(), "POST", """""", _prefix + """pagos/informeRetencionIva""")
)
                      

// @LINE:255
def informeRetDgrSellos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.informeRetDgrSellos(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeRetDgrSellos", Seq(), "POST", """""", _prefix + """pagos/informeRetencionDgrSellos""")
)
                      

// @LINE:244
def informeProfe(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosReportesController.informeProfe(), HandlerDef(this, "controllers.contabilidad.PagosReportesController", "informeProfe", Seq(), "POST", """""", _prefix + """informeprofe""")
)
                      
    
}
                          

// @LINE:373
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
class ReverseEjerciciosController {
    

// @LINE:275
def actualizarEjercicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.EjerciciosController.actualizarEjercicio(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "actualizarEjercicio", Seq(), "POST", """""", _prefix + """ejercicio/actualizar""")
)
                      

// @LINE:373
def suggestEjercicio(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.EjerciciosController.suggestEjercicio(input), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "suggestEjercicio", Seq(classOf[String]), "GET", """""", _prefix + """suggestEjercicio/$input<[^/]+>""")
)
                      

// @LINE:272
def guardarEjercicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.EjerciciosController.guardarEjercicio(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "guardarEjercicio", Seq(), "POST", """""", _prefix + """ejercicio/guardar""")
)
                      

// @LINE:270
def indexEjercicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.EjerciciosController.indexEjercicio(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "indexEjercicio", Seq(), "GET", """""", _prefix + """ejercicio""")
)
                      

// @LINE:277
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.EjerciciosController.get(id), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """ejercicio/get""")
)
                      

// @LINE:276
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.EjerciciosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "modalBuscar", Seq(), "GET", """""", _prefix + """ejercicio/modalBuscar""")
)
                      

// @LINE:271
def crearEjercicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.EjerciciosController.crearEjercicio(), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "crearEjercicio", Seq(), "GET", """""", _prefix + """ejercicio/crear""")
)
                      

// @LINE:273
def editarEjercicio(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.EjerciciosController.editarEjercicio(id), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "editarEjercicio", Seq(classOf[Long]), "GET", """""", _prefix + """ejercicio/editar""")
)
                      

// @LINE:274
def eliminarEjercicio(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.EjerciciosController.eliminarEjercicio(id), HandlerDef(this, "controllers.contabilidad.EjerciciosController", "eliminarEjercicio", Seq(classOf[Long]), "GET", """""", _prefix + """ejercicio/eliminar""")
)
                      
    
}
                          

// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
class ReverseFacturasLineasReintegrosController {
    

// @LINE:123
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasReintegrosController.index(id, editable), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """factura-linea-reintegro/index""")
)
                      

// @LINE:128
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasReintegrosController.eliminar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """factura-linea-reintegro/eliminar""")
)
                      

// @LINE:126
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasReintegrosController.guardar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "guardar", Seq(), "POST", """""", _prefix + """factura-linea-reintegro/guardar""")
)
                      

// @LINE:127
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasReintegrosController.actualizar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "actualizar", Seq(), "POST", """""", _prefix + """factura-linea-reintegro/actualizar""")
)
                      

// @LINE:125
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasReintegrosController.editar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """factura-linea-reintegro/editar""")
)
                      

// @LINE:124
def crear(facturaId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasReintegrosController.crear(facturaId), HandlerDef(this, "controllers.contabilidad.FacturasLineasReintegrosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """factura-linea-reintegro/crear""")
)
                      
    
}
                          

// @LINE:372
// @LINE:234
// @LINE:233
// @LINE:232
// @LINE:231
// @LINE:230
// @LINE:229
// @LINE:228
// @LINE:227
class ReverseCuentasController {
    

// @LINE:228
def crear(parent_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasController.crear(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasController", "crear", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas/crear""")
)
                      

// @LINE:372
def suggestCuenta(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasController.suggestCuenta(input), HandlerDef(this, "controllers.contabilidad.CuentasController", "suggestCuenta", Seq(classOf[String]), "GET", """""", _prefix + """suggestCuenta/$input<[^/]+>""")
)
                      

// @LINE:234
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasController.get(id), HandlerDef(this, "controllers.contabilidad.CuentasController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """cuentas/get""")
)
                      

// @LINE:232
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.CuentasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas/eliminar""")
)
                      

// @LINE:227
def index(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasController.index(id), HandlerDef(this, "controllers.contabilidad.CuentasController", "index", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas""")
)
                      

// @LINE:231
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasController.actualizar(), HandlerDef(this, "controllers.contabilidad.CuentasController", "actualizar", Seq(), "POST", """""", _prefix + """cuentas/actualizar""")
)
                      

// @LINE:233
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.CuentasController", "modalBuscar", Seq(), "GET", """""", _prefix + """cuentas/modalBuscar""")
)
                      

// @LINE:229
def guardar(parent_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasController.guardar(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasController", "guardar", Seq(classOf[Long]), "POST", """""", _prefix + """cuentas/guardar""")
)
                      

// @LINE:230
def editar(parent_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasController.editar(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas/editar""")
)
                      
    
}
                          

// @LINE:333
// @LINE:332
// @LINE:330
// @LINE:329
// @LINE:328
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
class ReverseOrdenesPagosCircuitosAccionesController {
    

// @LINE:324
def pasarContabilidadMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarContabilidadMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarContabilidadMasivo", Seq(), "POST", """""", _prefix + """OrdenPagoCircuito/pasarContabilidadMasivo""")
)
                      

// @LINE:321
def modalPasarBorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarBorrador", Seq(), "GET", """""", _prefix + """OrdenPagoCircuito/modalPasarBorrador""")
)
                      

// @LINE:333
def cargarExpedienteFisico(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.cargarExpedienteFisico(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "cargarExpedienteFisico", Seq(), "POST", """""", _prefix + """OrdenPagoCircuito/cargarExpedienteFisico""")
)
                      

// @LINE:323
def modalPasarContabilidad(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarContabilidad(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarContabilidad", Seq(), "GET", """""", _prefix + """OrdenPagoCircuito/modalPasarContabilidad""")
)
                      

// @LINE:327
def modalPasarRendido(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarRendido(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarRendido", Seq(), "GET", """""", _prefix + """OrdenPagoCircuito/modalPasarRendido""")
)
                      

// @LINE:330
def pasarCanceladoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarCanceladoMasivo", Seq(), "POST", """""", _prefix + """OrdenPagoCircuito/pasarCanceladoMasivo""")
)
                      

// @LINE:322
def pasarBorradorMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarBorradorMasivo", Seq(), "POST", """""", _prefix + """OrdenPagoCircuito/pasarBorradorMasivo""")
)
                      

// @LINE:325
def modalPasarRendiciones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarRendiciones(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarRendiciones", Seq(), "GET", """""", _prefix + """OrdenPagoCircuito/modalPasarRendiciones""")
)
                      

// @LINE:329
def modalPasarCancelado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalPasarCancelado", Seq(), "GET", """""", _prefix + """OrdenPagoCircuito/modalPasarCancelado""")
)
                      

// @LINE:326
def pasarRendicionesMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarRendicionesMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarRendicionesMasivo", Seq(), "POST", """""", _prefix + """OrdenPagoCircuito/pasarRendicionesMasivo""")
)
                      

// @LINE:328
def pasarRendidoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.pasarRendidoMasivo(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "pasarRendidoMasivo", Seq(), "POST", """""", _prefix + """OrdenPagoCircuito/pasarRendidoMasivo""")
)
                      

// @LINE:332
def modalCargarExpedienteFisico(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosAccionesController.modalCargarExpedienteFisico(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosAccionesController", "modalCargarExpedienteFisico", Seq(), "GET", """""", _prefix + """OrdenPagoCircuito/modalCargarExpedienteFisico""")
)
                      
    
}
                          

// @LINE:371
// @LINE:225
// @LINE:224
// @LINE:223
// @LINE:222
// @LINE:221
// @LINE:220
// @LINE:219
// @LINE:218
// @LINE:217
class ReverseCuentasAnaliticasController {
    

// @LINE:225
def modalBuscarCuentasAsociadas(solicitud_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.modalBuscarCuentasAsociadas(solicitud_id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "modalBuscarCuentasAsociadas", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas-analiticas/modalCuentasAsociadasSolicitud""")
)
                      

// @LINE:218
def crear(parent_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.crear(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "crear", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas-analiticas/crear""")
)
                      

// @LINE:222
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas-analiticas/eliminar""")
)
                      

// @LINE:217
def index(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.index(id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "index", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas-analiticas""")
)
                      

// @LINE:224
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.get(id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas-analiticas/get""")
)
                      

// @LINE:221
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.actualizar(), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "actualizar", Seq(), "POST", """""", _prefix + """cuentas-analiticas/actualizar""")
)
                      

// @LINE:223
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "modalBuscar", Seq(), "GET", """""", _prefix + """cuentas-analiticas/modalBuscar""")
)
                      

// @LINE:219
def guardar(parent_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.guardar(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "guardar", Seq(classOf[Long]), "POST", """""", _prefix + """cuentas-analiticas/guardar""")
)
                      

// @LINE:371
def suggestCuentaAnalitica(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.suggestCuentaAnalitica(input), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "suggestCuentaAnalitica", Seq(classOf[String]), "GET", """""", _prefix + """suggestCuentaAnalitica/$input<[^/]+>""")
)
                      

// @LINE:220
def editar(parent_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasAnaliticasController.editar(parent_id), HandlerDef(this, "controllers.contabilidad.CuentasAnaliticasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """cuentas-analiticas/editar""")
)
                      
    
}
                          

// @LINE:311
// @LINE:310
class ReverseCuentasPropiasController {
    

// @LINE:310
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasPropiasController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.CuentasPropiasController", "modalBuscar", Seq(), "GET", """""", _prefix + """cuentasPropias/modalBuscar""")
)
                      

// @LINE:311
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.CuentasPropiasController.get(id), HandlerDef(this, "controllers.contabilidad.CuentasPropiasController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """cuentasPropias/get""")
)
                      
    
}
                          

// @LINE:336
class ReverseOrdenesPagosCircuitosLineasController {
    

// @LINE:336
def index(orden_pago_circuito_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosCircuitosLineasController.index(orden_pago_circuito_id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosCircuitosLineasController", "index", Seq(classOf[Long]), "GET", """""", _prefix + """OrdenPagoCircuitoLinea""")
)
                      
    
}
                          

// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:361
// @LINE:360
// @LINE:358
// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
class ReverseBalanceController {
    

// @LINE:360
def modalCambiarCuenta(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.modalCambiarCuenta(), HandlerDef(this, "controllers.contabilidad.BalanceController", "modalCambiarCuenta", Seq(), "GET", """""", _prefix + """Balance/modalCambiarCuenta""")
)
                      

// @LINE:357
def modalPasarControlado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.modalPasarControlado(), HandlerDef(this, "controllers.contabilidad.BalanceController", "modalPasarControlado", Seq(), "GET", """""", _prefix + """Balance/modalPasarControlado""")
)
                      

// @LINE:364
def archivoBejermanPagos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.archivoBejermanPagos(), HandlerDef(this, "controllers.contabilidad.BalanceController", "archivoBejermanPagos", Seq(), "POST", """""", _prefix + """Balance/archivoBejermanPagos""")
)
                      

// @LINE:351
def general(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.general(), HandlerDef(this, "controllers.contabilidad.BalanceController", "general", Seq(), "GET", """""", _prefix + """Balance/general""")
)
                      

// @LINE:355
def modalPasarBorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.modalPasarBorrador(), HandlerDef(this, "controllers.contabilidad.BalanceController", "modalPasarBorrador", Seq(), "GET", """""", _prefix + """Balance/modalPasarBorrador""")
)
                      

// @LINE:352
def modalAgregarMovimientoBalance(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.modalAgregarMovimientoBalance(), HandlerDef(this, "controllers.contabilidad.BalanceController", "modalAgregarMovimientoBalance", Seq(), "GET", """""", _prefix + """Balance/modalAgregarMovimientoBalance""")
)
                      

// @LINE:358
def pasarControladoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.pasarControladoMasivo(), HandlerDef(this, "controllers.contabilidad.BalanceController", "pasarControladoMasivo", Seq(), "POST", """""", _prefix + """Balance/pasarControladoMasivo""")
)
                      

// @LINE:356
def pasarBorradorMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.pasarBorradorMasivo(), HandlerDef(this, "controllers.contabilidad.BalanceController", "pasarBorradorMasivo", Seq(), "POST", """""", _prefix + """Balance/pasarBorradorMasivo""")
)
                      

// @LINE:365
def archivoExcel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.archivoExcel(), HandlerDef(this, "controllers.contabilidad.BalanceController", "archivoExcel", Seq(), "POST", """""", _prefix + """Balance/archivoExcel""")
)
                      

// @LINE:363
def archivoBejerman(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.archivoBejerman(), HandlerDef(this, "controllers.contabilidad.BalanceController", "archivoBejerman", Seq(), "POST", """""", _prefix + """Balance/archivoBejerman""")
)
                      

// @LINE:353
def agregarMovimientoBalance(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.agregarMovimientoBalance(), HandlerDef(this, "controllers.contabilidad.BalanceController", "agregarMovimientoBalance", Seq(), "POST", """""", _prefix + """Balance/agregarMovimientoBalance""")
)
                      

// @LINE:350
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.index(), HandlerDef(this, "controllers.contabilidad.BalanceController", "index", Seq(), "GET", """""", _prefix + """Balance""")
)
                      

// @LINE:361
def cambiarCuentaMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceController.cambiarCuentaMasivo(), HandlerDef(this, "controllers.contabilidad.BalanceController", "cambiarCuentaMasivo", Seq(), "POST", """""", _prefix + """Balance/cambiarCuentaMasivo""")
)
                      
    
}
                          

// @LINE:207
// @LINE:206
// @LINE:205
// @LINE:204
// @LINE:203
// @LINE:202
class ReversePagosLineasController {
    

// @LINE:202
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosLineasController.index(id, editable), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """pago-linea/index""")
)
                      

// @LINE:207
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosLineasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """pago-linea/eliminar""")
)
                      

// @LINE:205
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosLineasController.guardar(), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "guardar", Seq(), "POST", """""", _prefix + """pago-linea/guardar""")
)
                      

// @LINE:206
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosLineasController.actualizar(), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "actualizar", Seq(), "POST", """""", _prefix + """pago-linea/actualizar""")
)
                      

// @LINE:204
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosLineasController.editar(id), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """pago-linea/editar""")
)
                      

// @LINE:203
def crear(pagoId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosLineasController.crear(pagoId), HandlerDef(this, "controllers.contabilidad.PagosLineasController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """pago-linea/crear""")
)
                      
    
}
                          

// @LINE:96
// @LINE:95
// @LINE:93
// @LINE:92
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:32
// @LINE:31
class ReverseFacturasAccionesController {
    

// @LINE:68
def modalCargarOrdenPago(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalCargarOrdenPago(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargarOrdenPago", Seq(), "GET", """""", _prefix + """facturaProveedor/modalCargarOrdenPago""")
)
                      

// @LINE:44
def modalCargar349(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalCargar349(id), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargar349", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/acciones/modalCargar349""")
)
                      

// @LINE:73
def cargarFecha322Masivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.cargarFecha322Masivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargarFecha322Masivo", Seq(), "POST", """""", _prefix + """facturaProveedor/cargarFecha322Masivo""")
)
                      

// @LINE:62
def modalPasarBorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarBorrador", Seq(), "GET", """""", _prefix + """facturaProveedor/modalPasarBorrador""")
)
                      

// @LINE:32
def descargar322(url:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.descargar322(url), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "descargar322", Seq(classOf[String]), "GET", """""", _prefix + """facturaProveedor/acciones/descargar322""")
)
                      

// @LINE:85
def modalDetalleFacturacionPorEstadoPorPeriodo(nombrePeriodo:String, estado:Integer, proveedorId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalDetalleFacturacionPorEstadoPorPeriodo(nombrePeriodo, estado, proveedorId), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalDetalleFacturacionPorEstadoPorPeriodo", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """facturaProveedor/acciones/modalDetalleFacturacionPorEstadoPorPeriodo""")
)
                      

// @LINE:72
def modalCargarFecha322(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalCargarFecha322(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargarFecha322", Seq(), "GET", """""", _prefix + """facturaProveedor/modalCargarFecha322""")
)
                      

// @LINE:58
def modalPasarEnPreCurso(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalPasarEnPreCurso(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarEnPreCurso", Seq(), "GET", """""", _prefix + """facturaProveedor/modalPasarEnPreCurso""")
)
                      

// @LINE:57
def pasarEnPreCursoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.pasarEnPreCursoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarEnPreCursoMasivo", Seq(), "POST", """""", _prefix + """facturaProveedor/pasarEnCursoMasivo""")
)
                      

// @LINE:42
def importarListaComisiones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.importarListaComisiones(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "importarListaComisiones", Seq(), "POST", """""", _prefix + """facturaProveedor/acciones/importarListaComisiones""")
)
                      

// @LINE:67
def pasarPreAprobadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.pasarPreAprobadoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarPreAprobadoMasivo", Seq(), "POST", """""", _prefix + """facturaProveedor/pasarPreAprobadoMasivo""")
)
                      

// @LINE:87
def marcadoresMasivos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.marcadoresMasivos(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "marcadoresMasivos", Seq(), "POST", """""", _prefix + """facturaProveedor/marcadoresMasivos""")
)
                      

// @LINE:92
def modalModificarNumeroFactura(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalModificarNumeroFactura(id), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalModificarNumeroFactura", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/modalModificarNumeroFactura""")
)
                      

// @LINE:74
def modalRechazarFactura(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalRechazarFactura(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalRechazarFactura", Seq(), "GET", """""", _prefix + """facturaProveedor/modalRechazarFactura""")
)
                      

// @LINE:71
def cargarFechaOrdenPagoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.cargarFechaOrdenPagoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargarFechaOrdenPagoMasivo", Seq(), "POST", """""", _prefix + """facturaProveedor/cargarFechaOrdenPagoMasivo""")
)
                      

// @LINE:60
def modalPasarAprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalPasarAprobado(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarAprobado", Seq(), "GET", """""", _prefix + """facturaProveedor/modalPasarAprobado""")
)
                      

// @LINE:70
def modalCargarFechaOrdenPago(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalCargarFechaOrdenPago(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargarFechaOrdenPago", Seq(), "GET", """""", _prefix + """facturaProveedor/modalCargarFechaOrdenPago""")
)
                      

// @LINE:69
def cargarOrdenPagoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.cargarOrdenPagoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargarOrdenPagoMasivo", Seq(), "POST", """""", _prefix + """facturaProveedor/cargarOrdenPagoMasivo""")
)
                      

// @LINE:96
def cargarNumeroFacturaParcial(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.cargarNumeroFacturaParcial(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargarNumeroFacturaParcial", Seq(), "POST", """""", _prefix + """facturaProveedor/cargarNumeroFacturaParcial""")
)
                      

// @LINE:93
def modificarNumeroFactura(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modificarNumeroFactura(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modificarNumeroFactura", Seq(), "POST", """""", _prefix + """facturaProveedor/modificarNumeroFactura""")
)
                      

// @LINE:75
def rechazar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.rechazar(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "rechazar", Seq(), "POST", """""", _prefix + """facturaProveedor/rechazar""")
)
                      

// @LINE:95
def modalCargarNumeroFacturaParcial(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalCargarNumeroFacturaParcial(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalCargarNumeroFacturaParcial", Seq(), "GET", """""", _prefix + """facturaProveedor/modalCargarNumeroFacturaParcial""")
)
                      

// @LINE:31
def solicitud322(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.solicitud322(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "solicitud322", Seq(), "POST", """""", _prefix + """facturaProveedor/acciones/solicitud322""")
)
                      

// @LINE:65
def pasarCanceladoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarCanceladoMasivo", Seq(), "POST", """""", _prefix + """facturaProveedor/pasarCanceladoMasivo""")
)
                      

// @LINE:63
def pasarBorradorMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarBorradorMasivo", Seq(), "POST", """""", _prefix + """facturaProveedor/pasarBorradorMasivo""")
)
                      

// @LINE:84
def modalDetalleFacturacion(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalDetalleFacturacion(id), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalDetalleFacturacion", Seq(classOf[Long]), "GET", """""", _prefix + """facturaProveedor/modalDetalleFacturacion""")
)
                      

// @LINE:64
def modalPasarCancelado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarCancelado", Seq(), "GET", """""", _prefix + """facturaProveedor/modalPasarCancelado""")
)
                      

// @LINE:61
def pasarAprobadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.pasarAprobadoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarAprobadoMasivo", Seq(), "POST", """""", _prefix + """facturaProveedor/pasarAprobadoMasivo""")
)
                      

// @LINE:56
def modalPasarEnCurso(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalPasarEnCurso(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarEnCurso", Seq(), "GET", """""", _prefix + """facturaProveedor/modalPasarEnCurso""")
)
                      

// @LINE:86
def modalMarcadoresMasivos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalMarcadoresMasivos(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalMarcadoresMasivos", Seq(), "GET", """""", _prefix + """facturaProveedor/modalMarcadoresMasivos""")
)
                      

// @LINE:59
def pasarEnCursoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.pasarEnCursoMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "pasarEnCursoMasivo", Seq(), "POST", """""", _prefix + """facturaProveedor/pasarEnPreCursoMasivo""")
)
                      

// @LINE:66
def modalPasarPreAprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalPasarPreAprobado(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalPasarPreAprobado", Seq(), "GET", """""", _prefix + """facturaProveedor/modalPasarPreAprobado""")
)
                      

// @LINE:41
def modalImportarListaComisiones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.modalImportarListaComisiones(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "modalImportarListaComisiones", Seq(), "POST", """""", _prefix + """facturaProveedor/acciones/modalImportarListaComisiones""")
)
                      

// @LINE:45
def cargar349(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasAccionesController.cargar349(), HandlerDef(this, "controllers.contabilidad.FacturasAccionesController", "cargar349", Seq(), "POST", """""", _prefix + """facturaProveedor/acciones/cargar349""")
)
                      
    
}
                          

// @LINE:348
// @LINE:347
// @LINE:345
// @LINE:344
// @LINE:343
// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
class ReverseBalanceCuentaPropiaController {
    

// @LINE:339
def archivoIndex(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceCuentaPropiaController.archivoIndex(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "archivoIndex", Seq(), "GET", """""", _prefix + """BalanceCuentaPropia/archivoIndex""")
)
                      

// @LINE:348
def getExpedientes(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceCuentaPropiaController.getExpedientes(id), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "getExpedientes", Seq(classOf[Long]), "GET", """""", _prefix + """BalanceCuentaPropia/get-expedientes""")
)
                      

// @LINE:345
def listaPagos(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceCuentaPropiaController.listaPagos(id), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "listaPagos", Seq(classOf[Long]), "POST", """""", _prefix + """BalanceCuentaPropia/listaPagos""")
)
                      

// @LINE:341
def agregarMovimientoBalanceCuentaPropia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceCuentaPropiaController.agregarMovimientoBalanceCuentaPropia(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "agregarMovimientoBalanceCuentaPropia", Seq(), "POST", """""", _prefix + """BalanceCuentaPropia/agregarMovimientoBalanceCuentaPropia""")
)
                      

// @LINE:344
def transferenciaEntreCuentasPropias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceCuentaPropiaController.transferenciaEntreCuentasPropias(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "transferenciaEntreCuentasPropias", Seq(), "POST", """""", _prefix + """BalanceCuentaPropia/transferenciaEntreCuentasPropias""")
)
                      

// @LINE:340
def modalAgregarMovimientoBalanceCuentaPropia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceCuentaPropiaController.modalAgregarMovimientoBalanceCuentaPropia(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "modalAgregarMovimientoBalanceCuentaPropia", Seq(), "GET", """""", _prefix + """BalanceCuentaPropia/modalAgregarMovimientoBalanceCuentaPropia""")
)
                      

// @LINE:343
def modalTransferenciaEntreCuentasPropias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceCuentaPropiaController.modalTransferenciaEntreCuentasPropias(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "modalTransferenciaEntreCuentasPropias", Seq(), "GET", """""", _prefix + """BalanceCuentaPropia/modalTransferenciaEntreCuentasPropias""")
)
                      

// @LINE:338
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceCuentaPropiaController.index(), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "index", Seq(), "GET", """""", _prefix + """BalanceCuentaPropia""")
)
                      

// @LINE:347
def getOrdenes(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.BalanceCuentaPropiaController.getOrdenes(id), HandlerDef(this, "controllers.contabilidad.BalanceCuentaPropiaController", "getOrdenes", Seq(classOf[Long]), "GET", """""", _prefix + """BalanceCuentaPropia/get-ordenes""")
)
                      
    
}
                          

// @LINE:90
// @LINE:88
// @LINE:83
// @LINE:82
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:27
class ReverseFacturasReportesController {
    

// @LINE:36
def reporteComprobanteRetencionMunicipal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionMunicipal(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionMunicipal", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComprobanteRetencionMunicipal""")
)
                      

// @LINE:90
def reporteFacturasCargadas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteFacturasCargadas(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteFacturasCargadas", Seq(), "POST", """""", _prefix + """facturaProveedor/reporteFacturasCargadas""")
)
                      

// @LINE:27
def viatico(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.viatico(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "viatico", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/viatico""")
)
                      

// @LINE:53
def modalInformeSellos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.modalInformeSellos(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "modalInformeSellos", Seq(), "GET", """""", _prefix + """facturaProveedor/reportes/modalInformeMensualSellos""")
)
                      

// @LINE:38
def reporteComprobanteRetencionIva(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionIva(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionIva", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComprobanteRetencionIva""")
)
                      

// @LINE:49
def reporteComprobanteRetencioniibb370(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencioniibb370(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencioniibb370", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComprobanteRetencionIibb370""")
)
                      

// @LINE:54
def informeSellos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.informeSellos(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "informeSellos", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/informeMensualSellos""")
)
                      

// @LINE:88
def reporteLineasFacturas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteLineasFacturas(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteLineasFacturas", Seq(), "POST", """""", _prefix + """facturaProveedor/reporteLineasFacturas""")
)
                      

// @LINE:51
def reporteComprobanteRetencionLimpieza(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionLimpieza(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionLimpieza", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComprobanteRetencionLimpieza""")
)
                      

// @LINE:52
def reporteComprobanteRetencionReggral(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionReggral(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionReggral", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComprobanteRetencionReggral""")
)
                      

// @LINE:39
def reporteComisiones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComisiones(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComisiones", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComisiones""")
)
                      

// @LINE:83
def reporteControlFacturasAFIP(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteControlFacturasAFIP(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteControlFacturasAFIP", Seq(), "POST", """""", _prefix + """facturaProveedor/reporteControlFacturasAFIP""")
)
                      

// @LINE:48
def reporteComprobanteRetencioniibb(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencioniibb(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencioniibb", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComprobanteRetencionIibb""")
)
                      

// @LINE:34
def ordenDePago(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.ordenDePago(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "ordenDePago", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/OrdenDePago""")
)
                      

// @LINE:47
def reporteRendicionSellos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteRendicionSellos(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteRendicionSellos", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteRendicionSellos""")
)
                      

// @LINE:82
def reporteControlFacturas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteControlFacturas(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteControlFacturas", Seq(), "POST", """""", _prefix + """facturaProveedor/reporteControlFactura""")
)
                      

// @LINE:50
def reporteComprobanteRetencionSeguridad(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionSeguridad(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionSeguridad", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComprobanteRetencionSeguridad""")
)
                      

// @LINE:33
def OPCservicios(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.OPCservicios(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "OPCservicios", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/OPCservicios""")
)
                      

// @LINE:35
def reporteComprobanteRetencionSellos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionSellos(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionSellos", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComprobanteRetencionSellos""")
)
                      

// @LINE:37
def reporteComprobanteRetencionGcia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasReportesController.reporteComprobanteRetencionGcia(), HandlerDef(this, "controllers.contabilidad.FacturasReportesController", "reporteComprobanteRetencionGcia", Seq(), "POST", """""", _prefix + """facturaProveedor/reportes/reporteComprobanteRetencionGcia""")
)
                      
    
}
                          

// @LINE:1
class ReverseIndexController {
    

// @LINE:1
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.IndexController.index(), HandlerDef(this, "controllers.contabilidad.IndexController", "index", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          

// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
class ReversePagosController {
    

// @LINE:138
def cambiarEstado(idPago:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.cambiarEstado(idPago, idEstado), HandlerDef(this, "controllers.contabilidad.PagosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """pagoProveedor/cambiarEstado""")
)
                      

// @LINE:139
def cambiarEstadoTransferenciaConciliado(idPago:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.cambiarEstadoTransferenciaConciliado(idPago), HandlerDef(this, "controllers.contabilidad.PagosController", "cambiarEstadoTransferenciaConciliado", Seq(classOf[Long]), "GET", """""", _prefix + """pagoProveedor/cambiarEstadoTransferenciaConciliado""")
)
                      

// @LINE:133
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.crear(), HandlerDef(this, "controllers.contabilidad.PagosController", "crear", Seq(), "GET", """""", _prefix + """pagoProveedor/crear""")
)
                      

// @LINE:137
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.actualizar(id), HandlerDef(this, "controllers.contabilidad.PagosController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """pagoProveedor/actualizar""")
)
                      

// @LINE:132
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.ver(id), HandlerDef(this, "controllers.contabilidad.PagosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """pagoProveedor/ver""")
)
                      

// @LINE:136
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.eliminar(id), HandlerDef(this, "controllers.contabilidad.PagosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """pagoProveedor/eliminar""")
)
                      

// @LINE:134
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.guardar(), HandlerDef(this, "controllers.contabilidad.PagosController", "guardar", Seq(), "POST", """""", _prefix + """pagoProveedor/guardar""")
)
                      

// @LINE:135
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.editar(id), HandlerDef(this, "controllers.contabilidad.PagosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """pagoProveedor/editar""")
)
                      

// @LINE:130
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.index(), HandlerDef(this, "controllers.contabilidad.PagosController", "index", Seq(), "GET", """""", _prefix + """pagoProveedor""")
)
                      

// @LINE:131
def duplicar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosController.duplicar(id), HandlerDef(this, "controllers.contabilidad.PagosController", "duplicar", Seq(classOf[Long]), "GET", """""", _prefix + """pagoProveedor/duplicar""")
)
                      
    
}
                          

// @LINE:370
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
class ReverseOrdenesPagosController {
    

// @LINE:4
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosController.crear(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "crear", Seq(), "GET", """""", _prefix + """ordenesPagos/crear""")
)
                      

// @LINE:9
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosController.get(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """ordenesPagos/get""")
)
                      

// @LINE:3
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosController.eliminar(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesPagos/eliminar""")
)
                      

// @LINE:5
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosController.guardar(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "guardar", Seq(), "POST", """""", _prefix + """ordenesPagos/guardar""")
)
                      

// @LINE:7
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosController.actualizar(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "actualizar", Seq(), "POST", """""", _prefix + """ordenesPagos/actualizar""")
)
                      

// @LINE:8
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "modalBuscar", Seq(), "GET", """""", _prefix + """ordenesPagos/modalBuscar""")
)
                      

// @LINE:370
def suggestOrdenPago(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosController.suggestOrdenPago(input), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "suggestOrdenPago", Seq(classOf[String]), "GET", """""", _prefix + """suggestOrdenPago/$input<[^/]+>""")
)
                      

// @LINE:6
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosController.editar(id), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """ordenesPagos/editar""")
)
                      

// @LINE:2
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.OrdenesPagosController.index(), HandlerDef(this, "controllers.contabilidad.OrdenesPagosController", "index", Seq(), "GET", """""", _prefix + """ordenesPagos""")
)
                      
    
}
                          

// @LINE:249
// @LINE:248
// @LINE:247
// @LINE:246
// @LINE:200
// @LINE:199
// @LINE:195
// @LINE:194
// @LINE:193
// @LINE:191
// @LINE:190
// @LINE:188
// @LINE:187
// @LINE:186
// @LINE:185
// @LINE:184
// @LINE:183
// @LINE:182
// @LINE:181
// @LINE:180
// @LINE:179
// @LINE:178
// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:172
// @LINE:171
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:155
// @LINE:154
// @LINE:153
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
class ReversePagosAccionesController {
    

// @LINE:144
def modalModificarReferencia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarReferencia(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarReferencia", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarReferencia""")
)
                      

// @LINE:183
def modalModificarCuentaPropia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarCuentaPropia(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarCuentaPropia", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarCuentaPropia""")
)
                      

// @LINE:195
def descargarRendiciones(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.descargarRendiciones(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarRendiciones", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/descargarRendiciones""")
)
                      

// @LINE:184
def modificarCuentaPropia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarCuentaPropia(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarCuentaPropia", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarCuentaPropia""")
)
                      

// @LINE:165
def modalPagarProveedoresExternos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPagarProveedoresExternos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarProveedoresExternos", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalPagarProveedoresExternos""")
)
                      

// @LINE:179
def modalModificarNumeroCheque(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarNumeroCheque(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarNumeroCheque", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarNumeroCheque""")
)
                      

// @LINE:248
def modalPasarBorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPasarBorrador", Seq(), "GET", """""", _prefix + """pagos/modalPasarBorrador""")
)
                      

// @LINE:178
def pagarCheques(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pagarCheques(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarCheques", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/pagarCheques""")
)
                      

// @LINE:148
def pagarEmbargos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pagarEmbargos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarEmbargos", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/pagarEmbargos""")
)
                      

// @LINE:171
def modificarFechaCancelacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarFechaCancelacion(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarFechaCancelacion", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarFechaCancelacion""")
)
                      

// @LINE:177
def modalPagarCheques(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPagarCheques(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarCheques", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalPagarCheques""")
)
                      

// @LINE:180
def modificarNumeroCheque(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarNumeroCheque(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarNumeroCheque", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarNumeroCheque""")
)
                      

// @LINE:147
def modalPagarEmbargos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPagarEmbargos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarEmbargos", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalPagarEmbargos""")
)
                      

// @LINE:169
def modificarFechaConciliado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarFechaConciliado(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarFechaConciliado", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarFechaConciliado""")
)
                      

// @LINE:173
def modalModificarNumeroFactura(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarNumeroFactura(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarNumeroFactura", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarNumeroFactura""")
)
                      

// @LINE:190
def modalPasarConciliado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPasarConciliado(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPasarConciliado", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalPasarConciliado""")
)
                      

// @LINE:200
def descargarOpgEmbargoExterno(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.descargarOpgEmbargoExterno(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarOpgEmbargoExterno", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/descargarOPGEmbargoExterno""")
)
                      

// @LINE:193
def descargarOpg(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.descargarOpg(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarOpg", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/descargarOPG""")
)
                      

// @LINE:158
def pagarProveedoresMacroMasivos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pagarProveedoresMacroMasivos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarProveedoresMacroMasivos", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/pagarProveedoresMacroMasivos""")
)
                      

// @LINE:176
def modificarNumeroRecibo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarNumeroRecibo(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarNumeroRecibo", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarNumeroRecibo""")
)
                      

// @LINE:145
def modalPagarInterno(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPagarInterno(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarInterno", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalPagarInterno""")
)
                      

// @LINE:146
def pagarInterno(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pagarInterno(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarInterno", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/pagarInterno""")
)
                      

// @LINE:191
def pasarConciliadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pasarConciliadoMasivo(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pasarConciliadoMasivo", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/pasarConciliadoMasivo""")
)
                      

// @LINE:159
def descargarArchivoProveedoresMacroMasivos(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.descargarArchivoProveedoresMacroMasivos(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarArchivoProveedoresMacroMasivos", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/descargarArchivoProveedoresMacroMasivos""")
)
                      

// @LINE:174
def modificarNumeroFactura(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarNumeroFactura(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarNumeroFactura", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarNumeroFactura""")
)
                      

// @LINE:182
def modificarTipoPago(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarTipoPago(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarTipoPago", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarTipoPago""")
)
                      

// @LINE:247
def pasarCanceladoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pasarCanceladoMasivo", Seq(), "POST", """""", _prefix + """pagos/pasarCanceladoMasivo""")
)
                      

// @LINE:166
def pagarProveedoresExternos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pagarProveedoresExternos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarProveedoresExternos", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modalPagarProveedoresExternos""")
)
                      

// @LINE:153
def modalPagarInterbankingProveedores(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPagarInterbankingProveedores(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarInterbankingProveedores", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalPagarInterbankingProveedores""")
)
                      

// @LINE:143
def modificarReferencia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarReferencia(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarReferencia", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarReferencia""")
)
                      

// @LINE:249
def pasarBorradorMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pasarBorradorMasivo", Seq(), "POST", """""", _prefix + """pagos/pasarBorradorMasivo""")
)
                      

// @LINE:170
def modalModificarFechaConciliado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarFechaConciliado(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarFechaConciliado", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarFechaConciliado""")
)
                      

// @LINE:149
def modalPagarEmbargosExternos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPagarEmbargosExternos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarEmbargosExternos", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalPagarEmbargosExternos""")
)
                      

// @LINE:181
def modalModificarTipoPago(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarTipoPago(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarTipoPago", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarTipoPago""")
)
                      

// @LINE:188
def crearRefenciaEmbargos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.crearRefenciaEmbargos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "crearRefenciaEmbargos", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/crearRefenciaEmbargos""")
)
                      

// @LINE:150
def pagarEmbargosExternos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pagarEmbargosExternos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarEmbargosExternos", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/pagarEmbargosExternos""")
)
                      

// @LINE:246
def modalPasarCancelado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPasarCancelado", Seq(), "GET", """""", _prefix + """pagos/modalPasarCancelado""")
)
                      

// @LINE:164
def pagarPlanta(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pagarPlanta(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarPlanta", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/pagarPlanta""")
)
                      

// @LINE:142
def modalModificarFecha(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarFecha(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarFecha", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarFecha""")
)
                      

// @LINE:186
def modificarPaguese(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarPaguese(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarPaguese", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarPaguese""")
)
                      

// @LINE:154
def pagarInterbankingProveedores(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.pagarInterbankingProveedores(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "pagarInterbankingProveedores", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/pagarInterbankingProveedores""")
)
                      

// @LINE:163
def modalPagarPlanta(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPagarPlanta(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarPlanta", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalPagarPlanta""")
)
                      

// @LINE:194
def descargarBnf(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.descargarBnf(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarBnf", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/descargarBNF""")
)
                      

// @LINE:167
def modalDetallePago(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalDetallePago(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalDetallePago", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/modalDetallePago""")
)
                      

// @LINE:160
def descargarArchivoBnfMacroMasivos(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.descargarArchivoBnfMacroMasivos(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarArchivoBnfMacroMasivos", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/descargarArchivoBnfMacroMasivos""")
)
                      

// @LINE:175
def modalModificarNumeroRecibo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarNumeroRecibo(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarNumeroRecibo", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarNumeroRecibo""")
)
                      

// @LINE:157
def modalPagarProveedoresMacroMasivos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalPagarProveedoresMacroMasivos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalPagarProveedoresMacroMasivos", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalPagarProveedoresMacroMasivos""")
)
                      

// @LINE:168
def modalDetalleDeudaPorEstadoPorPeriodo(nombrePeriodo:String, estado:Integer, proveedorId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalDetalleDeudaPorEstadoPorPeriodo(nombrePeriodo, estado, proveedorId), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalDetalleDeudaPorEstadoPorPeriodo", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """accionesPagoProveedor/modalDetalleDeudaPorEstadoPorPeriodo""")
)
                      

// @LINE:185
def modalModificarPaguese(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarPaguese(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarPaguese", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarPaguese""")
)
                      

// @LINE:155
def descargarArchivoInterbankingProveedores(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.descargarArchivoInterbankingProveedores(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarArchivoInterbankingProveedores", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/descargarArchivoInterbankingProveedores""")
)
                      

// @LINE:199
def descargarOpgEmbargo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.descargarOpgEmbargo(id), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "descargarOpgEmbargo", Seq(classOf[Long]), "GET", """""", _prefix + """accionesPagoProveedor/descargarOPGEmbargo""")
)
                      

// @LINE:172
def modalModificarFechaCancelacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalModificarFechaCancelacion(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalModificarFechaCancelacion", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalModificarFechaCancelacion""")
)
                      

// @LINE:141
def modificarFecha(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modificarFecha(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modificarFecha", Seq(), "POST", """""", _prefix + """accionesPagoProveedor/modificarFecha""")
)
                      

// @LINE:187
def modalCrearRefenciaEmbargos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PagosAccionesController.modalCrearRefenciaEmbargos(), HandlerDef(this, "controllers.contabilidad.PagosAccionesController", "modalCrearRefenciaEmbargos", Seq(), "GET", """""", _prefix + """accionesPagoProveedor/modalCrearRefenciaEmbargos""")
)
                      
    
}
                          

// @LINE:369
// @LINE:286
// @LINE:285
// @LINE:284
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
class ReversePeriodosController {
    

// @LINE:279
def indexPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PeriodosController.indexPeriodo(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "indexPeriodo", Seq(), "GET", """""", _prefix + """periodo""")
)
                      

// @LINE:280
def crearPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PeriodosController.crearPeriodo(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "crearPeriodo", Seq(), "GET", """""", _prefix + """periodo/crear""")
)
                      

// @LINE:282
def editarPeriodo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PeriodosController.editarPeriodo(id), HandlerDef(this, "controllers.contabilidad.PeriodosController", "editarPeriodo", Seq(classOf[Long]), "GET", """""", _prefix + """periodo/editar""")
)
                      

// @LINE:284
def actualizarPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PeriodosController.actualizarPeriodo(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "actualizarPeriodo", Seq(), "POST", """""", _prefix + """periodo/actualizar""")
)
                      

// @LINE:286
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PeriodosController.get(id), HandlerDef(this, "controllers.contabilidad.PeriodosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """periodo/get""")
)
                      

// @LINE:283
def eliminarPeriodo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PeriodosController.eliminarPeriodo(id), HandlerDef(this, "controllers.contabilidad.PeriodosController", "eliminarPeriodo", Seq(classOf[Long]), "GET", """""", _prefix + """periodo/eliminar""")
)
                      

// @LINE:285
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PeriodosController.modalBuscar(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "modalBuscar", Seq(), "GET", """""", _prefix + """periodo/modalBuscar""")
)
                      

// @LINE:281
def guardarPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PeriodosController.guardarPeriodo(), HandlerDef(this, "controllers.contabilidad.PeriodosController", "guardarPeriodo", Seq(), "POST", """""", _prefix + """periodo/guardar""")
)
                      

// @LINE:369
def suggestPeriodo(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.PeriodosController.suggestPeriodo(input), HandlerDef(this, "controllers.contabilidad.PeriodosController", "suggestPeriodo", Seq(classOf[String]), "GET", """""", _prefix + """suggestPeriodo/$input<[^/]+>""")
)
                      
    
}
                          

// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
class ReverseFacturasLineasController {
    

// @LINE:102
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasController.index(id, editable), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """factura-linea/index""")
)
                      

// @LINE:107
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasController.eliminar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """factura-linea/eliminar""")
)
                      

// @LINE:105
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasController.guardar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "guardar", Seq(), "POST", """""", _prefix + """factura-linea/guardar""")
)
                      

// @LINE:106
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasController.actualizar(), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "actualizar", Seq(), "POST", """""", _prefix + """factura-linea/actualizar""")
)
                      

// @LINE:108
def eliminarMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasController.eliminarMasivo(), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "eliminarMasivo", Seq(), "POST", """""", _prefix + """factura-linea/eliminar-masivo""")
)
                      

// @LINE:104
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasController.editar(id), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """factura-linea/editar""")
)
                      

// @LINE:103
def crear(facturaId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.contabilidad.FacturasLineasController.crear(facturaId), HandlerDef(this, "controllers.contabilidad.FacturasLineasController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """factura-linea/crear""")
)
                      
    
}
                          
}
        
    